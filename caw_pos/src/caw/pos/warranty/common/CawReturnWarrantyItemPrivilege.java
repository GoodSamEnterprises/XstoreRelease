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
 * BZ30269          280519    [New-Requirement] For returns of warranty merchandise, add in the warranty override to this change - prompt for manager override
 *===================================================================
 */

package caw.pos.warranty.common;

import static dtv.pos.framework.validation.ValidationResult.getOverridable;

import java.util.List;

import javax.inject.Inject;

import dtv.pos.framework.scope.TransactionScope;
import dtv.pos.framework.validation.ValidationResult;
import dtv.pos.iframework.validation.IValidationResult;
import dtv.pos.util.validation.AbstractSecuredValidationRule;
import dtv.xst.dao.cwo.IWorkOrderLineItem;
import dtv.xst.dao.itm.*;
import dtv.xst.dao.trl.*;

/**
 *
 */
public class CawReturnWarrantyItemPrivilege extends AbstractSecuredValidationRule {

    @Inject
    protected TransactionScope _transactionScope;

    /* (non-Javadoc)
     * @see dtv.pos.iframework.validation.IValidationRule#validate()
     */
    @Override
    public IValidationResult validate() {

        if (_transactionScope.getTransaction() != null) {
            List<ISaleReturnLineItem> lineItems = _transactionScope.getTransaction()
                    .getLineItems(ISaleReturnLineItem.class);

            if (org.apache.commons.collections.CollectionUtils.isNotEmpty(lineItems)) {
                ValidationResult resultOverride = getOverridable(FF.getTranslatable("_promptmsg306"), getPrivilege());

                for (ISaleReturnLineItem item : lineItems) {
                    if (item.getReturn() && !item.getVoid()) {
                        /*Return normal transactions*/
                        if (item instanceof IWarrantyLineItem) {
                            return resultOverride;
                        }
                        /*Return work order transactions*/
                        else if (item instanceof IWorkOrderLineItem) {
                            IWorkOrderLineItem woItem = (IWorkOrderLineItem) item;

                            if (woItem.getItem() instanceof IWarrantyItem) {
                                return resultOverride;
                            }
                        }
                    }
                }
            }
        }
        return IValidationResult.SUCCESS;
    }

}
