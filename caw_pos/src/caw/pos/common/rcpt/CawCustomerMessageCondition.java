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
 * BZ30259          120220    [New Requirement] Customer Specific Messages on Receipts 
 *===================================================================
 */

package caw.pos.common.rcpt;

import static dtv.pos.common.TransactionType.RETAIL_SALE;

import javax.inject.Inject;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import caw.pos.advance.prompting.CawCatalystHelper;
import caw.pos.araccount.CawCustomerUtil;
import caw.pos.common.CawValueKeys;

import dtv.docbuilding.conditions.AbstractInvertableCondition;
import dtv.pos.framework.scope.TransactionScope;
import dtv.util.EncodingHelper;
import dtv.util.StringUtils;
import dtv.xst.dao.crm.IParty;
import dtv.xst.dao.trl.impl.RetailTransactionModel;
import dtv.xst.dao.trn.IPosTransaction;

/**
 *
 */
public class CawCustomerMessageCondition extends AbstractInvertableCondition {

    @Inject
    protected TransactionScope  _transactionScope;

    private static final Logger _logger = LogManager.getLogger(CawItemHeaderBuilderField.class);

    @Override
    protected boolean conditionMetImpl(Object argSource) {

        String customerMessage = StringUtils.EMPTY;
        RetailTransactionModel trans = null;

        if (argSource instanceof RetailTransactionModel) {
            trans = (RetailTransactionModel) argSource;
        } else {
            trans = (RetailTransactionModel) _transactionScope.getTransaction(RETAIL_SALE);
        }

        String strResponseCustomerFromEBS = CawCatalystHelper.getLookupResponseData();
        IParty iParty = null;
        if (!StringUtils.isEmpty(strResponseCustomerFromEBS)) {
            IPosTransaction suspendTrans = _transactionScope.getValue(TransactionScope.CURRENT_TRANSACTION);
            IPosTransaction resumeTrans = null;
            try {
                resumeTrans = (IPosTransaction) EncodingHelper.deserialize(EncodingHelper.serialize(suspendTrans));
                if (resumeTrans instanceof RetailTransactionModel) {
                    iParty = ((RetailTransactionModel) resumeTrans).getCustomerParty();
                }
            } catch (ClassNotFoundException ex) {
                _logger.debug("ClassNotFoundException: " + ex.getMessage());
                ex.printStackTrace();
            }
        } else {

            if (trans != null) {
                iParty = trans.getCustomerParty();
            }
        }
        customerMessage = CawCustomerUtil.getCustomerMessages(iParty);
        if (!customerMessage.isEmpty()) {
            _transactionScope.setValue(CawValueKeys.CAW_CUSTOMER_MESSAGE, customerMessage);
            return true;
        }
        return false;
    }
}
