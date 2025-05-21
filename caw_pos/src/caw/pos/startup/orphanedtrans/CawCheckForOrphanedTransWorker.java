/**
 * CONFIDENTIAL AND PROPRIETARY SOURCE CODE. 
 * 
 * Use and distribution of this code is subject to applicable 
 * licenses and the permission of the code owner.  This notice 
 * does not indicate the actual or intended publication of 
 * this source code.
 * 
 * Portions developed for Camping World by BTM Global Consulting
 * LLC and are the property of Camping World.
 * 
 * ===== BTM Modification ===========================================
 * Req/Bug ID#      ddMMyy    Description
 * BZ26858          060918    [PROD] Register suspends transaction involuntarily and charges customer multiple times
 * BZ27933          301018    [26858]Void request of return trans doesn't send to Mira when Register suspends transaction involuntarily
 * BZ27875          151018    [PROD] Register suspends transaction involuntarily and charges customer double times once tendering with GC
 * BZ29753          270319    [Internal] PLCC orphaned transactions are not being replicated to the DB.
 *===================================================================
 */

package caw.pos.startup.orphanedtrans;

import java.util.List;

import javax.inject.Inject;

import org.apache.log4j.Logger;

import caw.tenderauth.impl.eigen.CawEigenMgr;
import caw.tenderauth.impl.eigen.constants.CawEigenConstants;

import dtv.pos.customer.ICustomerHelper;
import dtv.pos.startup.orphanedtrans.CheckForOrphanedTransWorker;
import dtv.xst.dao.crm.IParty;
import dtv.xst.dao.trl.IRetailTransaction;
import dtv.xst.dao.trl.IRetailTransactionLineItem;
import dtv.xst.dao.trl.impl.VoucherSaleLineItemModel;
import dtv.xst.dao.trn.IPosTransaction;
import dtv.xst.dao.ttr.*;
import dtv.xst.dao.ttr.impl.CreditDebitTenderLineItemModel;
import dtv.xst.dao.ttr.impl.VoucherTenderLineItemModel;

/**
 *
 */
public class CawCheckForOrphanedTransWorker extends CheckForOrphanedTransWorker {

    private static final Logger logger = Logger.getLogger(CawCheckForOrphanedTransWorker.class);

    @Inject
    private CawEigenMgr         _cawEigenMgr;

    @Inject
    private ICustomerHelper     _customerHelper;

    @Override
    protected void handlePersist(IPosTransaction iPosTransaction) {

        if (iPosTransaction != null) {
            /* BEGIN BZ29753 */
            if (iPosTransaction instanceof IRetailTransaction) {
                IRetailTransaction retailTrans = (IRetailTransaction) iPosTransaction;
                IParty oldCustParty = retailTrans.getCustomerParty();
                IParty newCustParty = null;
                if (oldCustParty != null) {
                    /*Rebuild new party object by old party object*/
                    newCustParty = _customerHelper.searchPartyById(oldCustParty.getPartyId(), retailTrans
                            .getRetailLocationId(), retailTrans.getCreateUserId());
                    /*Override old party object by new party object*/
                    retailTrans.setCustomerParty(newCustParty);
                }
            }
            /* END BZ29753 */
            try {
                super.handlePersist(iPosTransaction);
            } catch (Exception ex) {
                logger.error("The transaction " + iPosTransaction.getTransactionSequence()
                        + "can not persist in the database." + ex.getMessage());
            }

            /* Begin BZ27875 */
            /**
             * The code handle for case: The Gift Card for sale happened interrupt system. 
             */
            List<IRetailTransactionLineItem> saleLines = iPosTransaction.getSaleLineItems();
            if (saleLines != null && saleLines.size() > 0) {
                for (IRetailTransactionLineItem saleLine : saleLines) {
                    if (saleLine instanceof VoucherSaleLineItemModel) {
                        _cawEigenMgr.sendRequestVoidGiftCardReload(saleLine);
                    }
                }
            }
            /* End BZ27875 */

            CreditDebitTenderLineItemModel creditDebitTenderLineItemModel = null; //BZ27933
            List<IRetailTransactionLineItem> tenderLines = iPosTransaction.getTenderLineItems();
            for (IRetailTransactionLineItem lineItem : tenderLines) {
                if (lineItem instanceof ICreditDebitTenderLineItemModel && !lineItem.getVoid()) {

                    // Begin BZ27933
                    creditDebitTenderLineItemModel = (CreditDebitTenderLineItemModel) lineItem;
                    if (CawEigenConstants.LINE_REFUND
                            .equalsIgnoreCase(creditDebitTenderLineItemModel.getTenderStatusCode())) {
                        _cawEigenMgr.sendVoidRefundTField((ITenderLineItem) lineItem);
                    } else {
                        // End BZ27933
                        _cawEigenMgr.sendVoidCreditDebitRequest((ITenderLineItem) lineItem);
                    }
                }
                /* Begin BZ27875 */
                /**
                 * The code handle for case: The gift card is the tender has interrupted.
                 */
                if (lineItem instanceof VoucherTenderLineItemModel) {
                    _cawEigenMgr.sendRequestVoidGiftCardReload(lineItem);
                }
                /* End BZ27875 */
            }
        }
    }

}
