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
 * BZ25115          180418    New Requirement - Add a Member Price Override Function to the POS Sale screen
 * BZ49889          180522    [Prod] Issue with Member Price Override
 *===================================================================
 */

package caw.pos.register.sale;

import javax.inject.Inject;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import caw.pos.advance.prompting.CawCustomerGroupType;
import caw.pos.common.CawValueKeys;

import dtv.data2.access.DataFactory;
import dtv.data2.access.impl.DaoState;
import dtv.data2.access.impl.IDataModelImpl;
import dtv.pos.common.ConfigurationMgr;
import dtv.pos.framework.op.Operation;
import dtv.pos.iframework.event.IXstEvent;
import dtv.pos.iframework.op.IOpResponse;
import dtv.pos.spring.ValueKeys;
import dtv.xst.dao.crm.*;

/**
 *
 */
public class CawConvertPriceFromRegularToClubOp extends Operation {

    private static final Logger _logger = LogManager.getLogger(CawConvertPriceFromRegularToClubOp.class);
    
    @Inject
    private CawMemberPriceOverrideHelper _cawMemberPriceOverrideHelper;/*BZ49889*/
    
    /* (non-Javadoc)
     * @see dtv.pos.framework.op.Operation#isOperationApplicable()
     */
    @Override
    public boolean isOperationApplicable() {

        Boolean isAllowRun = Boolean.FALSE;
        if (Boolean.TRUE.equals(_transactionScope.getValue(CawValueKeys.IS_APPLY_CLUB_PRICE))) {
            isAllowRun = Boolean.TRUE;
        }

        return isAllowRun;

    }

    /* (non-Javadoc)
     * @see dtv.pos.iframework.op.IOperation#handleOpExec(dtv.pos.iframework.event.IXstEvent)
     */
    @Override
    public IOpResponse handleOpExec(IXstEvent argArg0) {

        IParty iParty = _transactionScope.getValue(ValueKeys.SELECTED_CUSTOMER);
        if (iParty != null && !_cawMemberPriceOverrideHelper.hasClubGroup(iParty)) {/*BZ49889*/
            try {
                /*BEGIN BZ49889*/
                //create Club price object
                CustomerAffiliationId customerAffiliationId = new CustomerAffiliationId();
                customerAffiliationId.setOrganizationId(ConfigurationMgr.getOrganizationId());
                customerAffiliationId.setPartyId(iParty.getPartyId());
                customerAffiliationId.setCustomerGroupId(CawCustomerGroupType.CLUB.getNewName());
                ICustomerAffiliation iCustomerAffiliation = DataFactory.createObject(customerAffiliationId, ICustomerAffiliation.class);
                //insert Club into DB
                ((IDataModelImpl) iCustomerAffiliation).getDAO().setObjectState(DaoState.INSERT_OR_UPDATE.intVal());
                /*END BZ49889*/
                iCustomerAffiliation = DataFactory.makePersistent(iCustomerAffiliation);
                
                iParty.addCustomerAffiliation(iCustomerAffiliation);
                _transactionScope.setValue(ValueKeys.SELECTED_CUSTOMER, iParty);
            } catch (Exception ex) {
                _logger.error("Can not create pricing group for patyId=" + iParty.getPartyId() + "." + ex.getMessage());
            }
        }

        return HELPER.completeResponse();
    }

}
