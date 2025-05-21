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
 * BZ28107          051118    [26893] 'Club Price' text for member should be displayed in receipt instead of 'Your price' text
 * BZ28688          171218    [2.9.4] Club Price appears on expired club member return receipts.
 * BZ31523          250619    [Port BZ30263 to 5.0]Display GSC member savings in transaction
 * BZ38075          300920    [Internal] - The Qty column and pricing title on receipt for Club member display incorrectly on Order Pick Slip
 *===================================================================
 */

package caw.pos.common.rcpt;

import static dtv.pos.common.TransactionType.RETAIL_SALE;

import java.util.*;

import javax.inject.Inject;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import caw.pos.advance.prompting.CawCatalystHelper;
import caw.pos.araccount.CawCustomerUtil;
import caw.pos.common.CawQueryConstants;
import caw.pos.customer.CawCustomerEBSQueryResult;

import dtv.data2.access.DataFactory;
import dtv.data2.access.IQueryResultList;
import dtv.docbuilding.AbstractDocBuilderField;
import dtv.docbuilding.IDocElementFactory;
import dtv.docbuilding.types.DocBuilderAlignmentType;
import dtv.i18n.FormattableFactory;
import dtv.i18n.formatter.output.IOutputFormatter;
import dtv.pos.customer.CustomerHelper;
import dtv.pos.framework.scope.TransactionScope;
import dtv.pos.order.maint.OrderPickTicketSource;
import dtv.util.EncodingHelper;
import dtv.util.temp.InjectionHammer;
import dtv.xst.dao.crm.IParty;
import dtv.xst.dao.trl.impl.RetailTransactionModel;
import dtv.xst.dao.trn.IPosTransaction;
import dtv.xst.dao.xom.ICustomerModifier;

public class CawItemHeaderBuilderField extends AbstractDocBuilderField {
    
    private static final Logger _logger               = LogManager
            .getLogger(CawItemHeaderBuilderField.class); 
    
    @Inject
    protected FormattableFactory _formattables;

    @Inject
    protected TransactionScope   _transactionScope;
    
    @Inject
    private CustomerHelper      _customerHelper;
    
    public CawItemHeaderBuilderField(String argContents, String argStyle, Integer argLocation,
            DocBuilderAlignmentType argAlignment, int argPriority, IOutputFormatter argFormatter) {

        super(argContents, argStyle, argLocation, argAlignment, argPriority, argFormatter);
        InjectionHammer.forceAtInjectProcessing(this);
    }

    @Override
    public String getContents(Object argSource, IDocElementFactory argFactory, Locale argLocale) {

        RetailTransactionModel trans = null;
        OrderPickTicketSource order = null;
        IParty iParty = null;
        String priceHeader = _formattables.getTranslatable("_caw_yourPrice").toString();

        if (argSource instanceof RetailTransactionModel) { /*BZ28107*/
            trans = (RetailTransactionModel) argSource;
        } // Start BZ38075
        else if (argSource instanceof OrderPickTicketSource) {
            order = (OrderPickTicketSource) argSource;
            
            iParty = searchCustomerFromXstore(order);
        } // End BZ38075
        else {//BZ28688
            trans = (RetailTransactionModel) _transactionScope.getTransaction(RETAIL_SALE);
        }

        /* BEGIN BZ28688 */
        String response = CawCatalystHelper.getLookupResponseData();

        if (response == null) {
            IPosTransaction suspendTrans = _transactionScope.getValue(TransactionScope.CURRENT_TRANSACTION);
            IPosTransaction resumeTrans = null;
            try {
                resumeTrans = (IPosTransaction) EncodingHelper.deserialize(EncodingHelper.serialize(suspendTrans));
                if (resumeTrans instanceof RetailTransactionModel) {
                    iParty = ((RetailTransactionModel) resumeTrans).getCustomerParty();
                }
            } catch (ClassNotFoundException ex) {
                _logger.debug("ClassNotFoundException: "+ ex.getMessage());
            }
        } else {
            if (trans != null) {
                iParty = trans.getCustomerParty();
            }
        }

        if (CawCustomerUtil.isClubCustomerXstore(iParty)) { /*BZ31523*/
            priceHeader = _formattables.getTranslatable("_caw_clubPrice").toString();
        }
        /* END BZ28688 */
        return priceHeader;
    }

    // Start BZ38075
    private Long getCustomerIdInDB(String accountNumber) {

        Long partId = null;
        IQueryResultList<CawCustomerEBSQueryResult> cawCustomerEBSQueryResult = null;
        Map<String, Object> params = new HashMap<>();
        params.put(CawQueryConstants.ARG_ACCOUNT_NUMBER, accountNumber);
        cawCustomerEBSQueryResult = DataFactory
                .getObjectByQueryNoThrow(CawQueryConstants.CRM_CUSTOMER_EBS_LOOKUP, params);
        if (cawCustomerEBSQueryResult != null && cawCustomerEBSQueryResult.size() > 0) {
            partId = cawCustomerEBSQueryResult.get(0).getPartyId();
        }
        return partId;
    }
    
    private IParty searchCustomerFromXstore(OrderPickTicketSource argOrder) {

        IParty iParty = null;
        ICustomerModifier customer = null;
        Long sourceLoc = null;
        String customerID = "";

        try {

            customer = argOrder.getOrder().getCustomer();
            sourceLoc = Long.parseLong(argOrder.getOrder().getOrderLocationId());
            customerID = customer.getCustomerId();

            Long partyId = getCustomerIdInDB(customerID);
            iParty = _customerHelper.searchPartyById(partyId, sourceLoc, "");
            
        } catch (Exception arg2) {
            _logger.info("Could not find customer " + customerID);
        }

        return iParty;
    }
    // End BZ38075
}
