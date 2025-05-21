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
 * BZ26314          120618    [BZ25115]Member Price Override function is disabled incorrectly in offline mode when same customer is attached for subsequent transaction
 *===================================================================
 */

package caw.pos.register.sale;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import caw.pos.advance.prompting.CawCustomerGroupType;
import caw.pos.common.CawValueKeys;

import dtv.data2.access.DataFactory;
import dtv.data2.access.impl.DaoState;
import dtv.data2.access.impl.IDataModelImpl;
import dtv.pos.framework.op.Operation;
import dtv.pos.iframework.event.IXstEvent;
import dtv.pos.iframework.op.IOpResponse;
import dtv.pos.spring.ValueKeys;
import dtv.xst.dao.crm.ICustomerAffiliation;
import dtv.xst.dao.crm.IParty;

/**
 * When the user using function Member Price Override, the customer has added group 'Club' to DB.
 * After the transaction completed, the group 'Club' need to remove.
 */
public class CawRevertMemberPriceOverrideOp extends Operation {

    private static final Logger _logger = LogManager
            .getLogger(CawRevertMemberPriceOverrideOp.class);

    @Override
    public boolean isOperationApplicable() {

        if (_transactionScope.getValue(CawValueKeys.IS_APPLY_CLUB_PRICE) != null
                && _transactionScope
                        .getValue(CawValueKeys.IS_APPLY_CLUB_PRICE) == Boolean.TRUE) {
            return true;
        }

        return false;
    }

    @Override
    public IOpResponse handleOpExec(IXstEvent argArg0) {

        IParty iParty = _transactionScope.getValue(ValueKeys.SELECTED_CUSTOMER);
        if (iParty != null) {
            List<ICustomerAffiliation> customerGroup = iParty
                    .getCustomerGroups();

            if (customerGroup != null) {
                try {
                    for (ICustomerAffiliation iCustomerAffiliation : customerGroup) {
                        if (CawCustomerGroupType.CLUB.getNewName()
                                .equals(iCustomerAffiliation
                                        .getCustomerGroupId())) {
                            ((IDataModelImpl) iCustomerAffiliation).getDAO()
                                    .setObjectState(DaoState.DELETED.intVal());
                            DataFactory.makePersistent(iCustomerAffiliation);
                        }
                    }
                } catch (Exception ex) {
                    _logger.error("Can not the revert customer group after using function Member Price Override: "
                            + ex.getMessage());
                }

            }
        }

        return HELPER.completeResponse();
    }

}
