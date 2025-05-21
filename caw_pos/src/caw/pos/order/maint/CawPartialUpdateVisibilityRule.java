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
 * BZ42307          200921    [Requirement] Add ability to reject at the item level for BOPIS 
 *===================================================================
 */

package caw.pos.order.maint;

import java.math.BigDecimal;
import java.util.List;

import javax.inject.Inject;

import caw.pos.common.CawValueKeys;

import dtv.pos.framework.action.access.AbstractVisibilityRule;
import dtv.pos.framework.scope.OperationDefaultScope;
import dtv.pos.iframework.visibilityrules.AccessLevel;
import dtv.pos.iframework.visibilityrules.IAccessLevel;
import dtv.xst.dao.xom.IOrderLine;

public class CawPartialUpdateVisibilityRule extends AbstractVisibilityRule {

    @Inject
    private OperationDefaultScope _defaultScope;

    @Override
    protected IAccessLevel checkVisibilityImpl() throws Exception {

        IAccessLevel access = AccessLevel.DENIED;
        List<IOrderLine> orderLines = this._defaultScope.getValue(CawValueKeys.ORDER_LINE_DETAILS_TO_PROCESS);
        if (orderLines != null) {
            boolean visible = orderLines.stream().anyMatch((li) -> {
                return li.getQuantity().compareTo(BigDecimal.ONE) > 0;
            });
            if (visible) {
                access = AccessLevel.GRANTED;
            }
        }
        return access;
    }
}