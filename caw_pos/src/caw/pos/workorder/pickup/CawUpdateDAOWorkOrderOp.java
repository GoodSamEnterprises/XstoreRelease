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
 * BZ27248          210818    Warranty Items from S&I are not associated with the items covered
 *===================================================================
 */

package caw.pos.workorder.pickup;

import javax.inject.Inject;

import dtv.data2.access.impl.DaoState;
import dtv.data2.access.impl.IDataModelImpl;
import dtv.pos.framework.op.Operation;
import dtv.pos.iframework.event.IXstEvent;
import dtv.pos.iframework.op.IOpResponse;
import dtv.pos.workorder.common.WorkOrderHelper;
import dtv.xst.dao.cat.ICustomerItemAccountActivity;
import dtv.xst.dao.cat.ICustomerItemAccountDetail;
import dtv.xst.dao.cwo.IWorkItem;
import dtv.xst.dao.cwo.IWorkOrderAccount;

/**
 *
 */
public class CawUpdateDAOWorkOrderOp extends Operation {

    @Inject
    protected WorkOrderHelper _workOrderHelper;

    /* (non-Javadoc)
     * @see dtv.pos.iframework.op.IOperation#handleOpExec(dtv.pos.iframework.event.IXstEvent)
     */
    @Override
    public IOpResponse handleOpExec(IXstEvent argArg0) {

        IWorkOrderAccount account = _workOrderHelper
                .getCurrentWorkOrderAccount();

        if (account != null) {

            ((IDataModelImpl) account).getDAO()
                    .setObjectState(DaoState.UPDATED.intVal());

            for (ICustomerItemAccountDetail detail : account
                    .getCustItemAccountDetails()) {
                ((IDataModelImpl) detail).getDAO()
                        .setObjectState(DaoState.UPDATED.intVal());

                for (ICustomerItemAccountActivity activity : detail
                        .getCustItemAccountActivities()) {

                    ((IDataModelImpl) activity).getDAO()
                            .setObjectState(DaoState.UPDATED.intVal());
                }
            }

            for (IWorkItem workItem : account.getWorkItemsRelationship()) {
                ((IDataModelImpl) workItem).getDAO()
                        .setObjectState(DaoState.UPDATED.intVal());
            }
        }
        return HELPER.completeResponse();
    }

}
