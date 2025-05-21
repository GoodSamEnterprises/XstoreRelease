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
 * 
 *===================================================================
 */

package caw.tenderauth.impl.visibilityrules;

import caw.tender.impl.mira.response.CawMiraResponse;
import caw.tenderauth.impl.eigen.request.CawMiraGiftCardRequest;
import caw.tenderauth.impl.mira.constants.CawMiraCommand;

import dtv.pos.framework.action.access.AbstractFormVisibilityRule;
import dtv.pos.iframework.form.IEditModel;
import dtv.pos.iframework.visibilityrules.AccessLevel;
import dtv.pos.iframework.visibilityrules.IAccessLevel;
import dtv.tenderauth.event.IAuthResponse;
import dtv.tenderauth.impl.form.TenderAuthEditModel;

/**
 *
 */
public class CawAuthFailedActionTypeVisibilityRule
        extends AbstractFormVisibilityRule {

    @Override
    protected IAccessLevel checkVisibilityImpl() throws Exception {

        IEditModel em = getCurrentEditModel();
        if ((em instanceof TenderAuthEditModel)) {
            TenderAuthEditModel model = (TenderAuthEditModel) em;
            IAuthResponse argResponse = model.getAuthResponse();
            if (argResponse instanceof CawMiraResponse
                    && argResponse
                            .getRequest() instanceof CawMiraGiftCardRequest
                    && !argResponse.isSuccess()
                    && ((CawMiraGiftCardRequest) argResponse.getRequest())
                            .getCommand()
                            .equalsIgnoreCase(CawMiraCommand.BALANCE_INQUIRY)) {
                return AccessLevel.GRANTED;
            }
            return AccessLevel.DENIED;

        }
        return AccessLevel.GRANTED;
    }
}
