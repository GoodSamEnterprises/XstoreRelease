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
 * BZ30754          160519    [PORT 30531 to 5.0] [Prod] Unable to complete the WO if WO deposit is created in xstore offline mode
 * BZ45156          030821    [PROD] Update Miraserv auth request to include recurring payment indicator
 *===================================================================
 */

package caw.pos.ejournal;

import java.util.List;
import java.util.Map;

import dtv.data2.access.*;
import dtv.pos.common.ConfigurationMgr;
import dtv.pos.customer.account.type.CustomerAccountType;
import dtv.pos.ejournal.*;
import dtv.util.StringUtils;
import dtv.xst.dao.com.CodeLocator;
import dtv.xst.dao.trn.IPosTransaction;
import dtv.xst.dao.trn.PosTransactionId;
import dtv.xst.query.results.DefaultTransactionSummaryModel;

/**
 *
 */
public class CawTransactionSearchHelper extends TransactionSearchHelper {

    /* Route to Xcenter if we lookup Transaction for WO.
     * @see dtv.pos.ejournal.TransactionSearchHelper#getTransaction(dtv.xst.dao.trn.PosTransactionId, dtv.data2.access.IPersistenceMgrType)
     */
    public IPosTransaction getTransaction(CustomerAccountType accountType, PosTransactionId argId,
            IPersistenceMgrType argPmType) {

        //
        if (accountType.equals(CustomerAccountType.WORK_ORDER)) {
            if (argId == null) {
                return null;
            } else {
                IPosTransaction results = (IPosTransaction) DataFactory.getObjectByIdNoThrow(argId, argPmType);
                if (results != null) {
                    return results;
                } else {
                    IQueryResultList<DefaultTransactionSummaryModel> queryResults = this
                            .runQuery(accountType, new TransactionSearchCriteria(argId), ConfigurationMgr
                                    .getOrganizationId(), argPmType);
                    if (queryResults != null && !queryResults.isEmpty()) {
                        assert queryResults.size() == 1 : "too many results " + queryResults.size();
                        IObjectId actualId = queryResults.get(0).getObjectId();
                        return (IPosTransaction) DataFactory.getObjectByIdNoThrow(actualId, argPmType);
                    } else {
                        return null;
                    }
                }
            }
        }
        //
        return super.getTransaction(argId, argPmType);
    }

    /* Route to Xcenter if we lookup Transaction for WO.
     * @see dtv.pos.ejournal.TransactionSearchHelper#runQuery(dtv.pos.ejournal.ITransactionSearchCriteria, long, dtv.data2.access.IPersistenceMgrType)
     */
    public IQueryResultList<DefaultTransactionSummaryModel> runQuery(CustomerAccountType accountType,
            ITransactionSearchCriteria argCriteria, long argOrgId, IPersistenceMgrType argPmType) {

        //
        if (accountType.equals(CustomerAccountType.WORK_ORDER)) {
            if (argCriteria == null) {
                return new QueryResultList<DefaultTransactionSummaryModel>(DefaultTransactionSummaryModel.class);
            } else {
                Map<String, Object> params = this.getQueryParamaters(argCriteria, argOrgId);
                return DataFactory.getObjectByQueryNoThrow(TRANSACTION_SEARCH, params, argPmType);
            }
        }
        //
        return null;
    }

    /*BEGIN BZ45156*/
    public String getCodeValue(String category) {
        List<String> codeValues = CodeLocator.getCodes(ConfigurationMgr.getOrganizationId(), category);
        String result = StringUtils.EMPTY;
        if(codeValues != null && codeValues.size() > 0) {
            result = codeValues.get(0);
        }
        return result;
    }
    /*END BZ45156*/
}
