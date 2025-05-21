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
 * BZ23052          120917    Implement Advanced Prompting
 * BZ23436          190917    Advanced Prompting with Directive - No Check
 * BZ29840          210318    [Internal][ESB log] There are a lot of redundant statements written into ESB log during having interaction between Xstore and Neuron API.
 *===================================================================
 */

package caw.pos.advance.prompting;

import javax.inject.Inject;

import twitter4j.JSONObject;

import dtv.data2.access.DataFactory;
import dtv.pos.framework.action.access.AbstractVisibilityRule;
import dtv.pos.framework.scope.TransactionScope;
import dtv.pos.iframework.visibilityrules.AccessLevel;
import dtv.pos.iframework.visibilityrules.IAccessLevel;
import dtv.xst.dao.trn.IPosTransaction;
import dtv.xst.dao.trn.PosTransactionPropertyId;
import dtv.xst.dao.trn.impl.PosTransactionPropertyModel;

/**
 *
 */
public class CawCatalystDirectivesTenderRule extends AbstractVisibilityRule {

    @Inject
    private TransactionScope          _transactionScope;

    private String                    tenderName;

    private static final String       CATALYST_DIRECTIVES_TYPE             = "directives";

    private static final String       CATALYST_DIRECTIVES_CASH_ONLY        = "cashOnly";

    private static final String       CATALYST_DIRECTIVES_CREDIT_CARD_ONLY = "creditCardOnly";

    private static final String       CATALYST_DIRECTIVES_NO_CHECK         = "noCheck";

    private CawAdvancePromptingHelper _cawAdvancePromptingHelper           = CawAdvancePromptingHelper
            .getInstance();

    /* (non-Javadoc)
     * @see dtv.pos.framework.action.access.AbstractVisibilityRule#setParameter(java.lang.String, dtv.util.config.IConfigObject)
     */
    @SuppressWarnings("deprecation")
    @Override
    public void setParameter(String argName, String argValue) {

        this.tenderName = argName;
    }

    /* (non-Javadoc)
     * @see dtv.pos.framework.action.access.AbstractVisibilityRule#checkVisibilityImpl()
     */
    @Override
    protected IAccessLevel checkVisibilityImpl() throws Exception {

        AccessLevel accessLevel = AccessLevel.GRANTED;
        try {
            IPosTransaction tran = _transactionScope.getTransaction();

            PosTransactionPropertyId id = new PosTransactionPropertyId();
            id.setOrganizationId(tran.getOperatorPartyId());
            id.setRetailLocationId(tran.getRetailLocationId());
            id.setBusinessDate(tran.getBusinessDate());
            id.setWorkstationId(tran.getWorkstationId());
            id.setTransactionSequence(tran.getTransactionSequence());
            id.setPropertyCode(CATALYST_DIRECTIVES_TYPE);

            PosTransactionPropertyModel posTransactionPropertyModel = DataFactory
                    .getObjectByIdNoThrow(id);

            if (posTransactionPropertyModel != null
                    && posTransactionPropertyModel.getStringValue() != null) {
                String json = posTransactionPropertyModel.getStringValue();
                JSONObject directive = new JSONObject(json);

                // Begin BZ23436
                if (_cawAdvancePromptingHelper
                        .isExistDirectiveType(CawDirectiveType.CASH_ONLY
                                .getType(), directive)
                        || _cawAdvancePromptingHelper
                                .isExistDirectiveType(CawDirectiveType.CREDIT_CARD_ONLY
                                        .getType(), directive)
                        || _cawAdvancePromptingHelper
                                .isExistDirectiveType(CawDirectiveType.NO_CHECK
                                        .getType(), directive)) {
                    accessLevel = AccessLevel.DENIED;
                    if (CATALYST_DIRECTIVES_CASH_ONLY.equals(tenderName)) {
                        accessLevel = AccessLevel.GRANTED;
                    }

                    if (CATALYST_DIRECTIVES_CREDIT_CARD_ONLY
                            .equals(tenderName)) {
                        accessLevel = AccessLevel.GRANTED;
                    }

                    if (CATALYST_DIRECTIVES_NO_CHECK.equals(tenderName)) {
                        accessLevel = AccessLevel.DENIED;
                    }
                }
                // End BZ23436
            }
        } catch (Exception ex) {
            accessLevel = AccessLevel.GRANTED; //BZ29840
        }

        return accessLevel;
    }
}
