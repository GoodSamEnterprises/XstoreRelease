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
 * BZ27670          210918    [Prod] Options to auto unlock users/Display actual reason for failed log in attempts in Xstore
 * BZ29580          280219    [New Requirement] Change GUI verbiage for the terminated employee notification
 * BZ33137          031019    Employee Logins - How to Deactivate
 *===================================================================
 */

package caw.pos.security.op;

import javax.inject.Inject;

import caw.pos.common.CawConfigurationMgr;
import caw.pos.common.CawConstants;

import dtv.i18n.FormatterType;
import dtv.i18n.IFormattable;
import dtv.pos.common.PromptKey;
import dtv.pos.framework.ui.config.PromptConfig;
import dtv.pos.iframework.event.IXstEvent;
import dtv.pos.iframework.op.IOpResponse;
import dtv.pos.iframework.security.ISecurityConstants;
import dtv.pos.iframework.security.ISecurityMgr;
import dtv.pos.security.op.NotifyBadAuthenticationOp;

/**
 * The CawNotifyBadAuthenticationOp
 */
public class CawNotifyBadAuthenticationOp extends NotifyBadAuthenticationOp {

    @Inject
    private ISecurityMgr _securityMgr;

    /** (non-Javadoc)
     * @see dtv.pos.security.op.NotifyBadAuthenticationOp#getDefaultPromptKey()
     */
    @Override
    public PromptKey getDefaultPromptKey() {

        //Begin BZ27670
        /* BEGIN BZ29580 */
        if (ISecurityConstants.ACCOUNT_LOCKED_OUT.equalsIgnoreCase(_securityMgr.getLoginFailureReasonCode())) {

            return PromptKey.valueOf(CawConstants.LOGIN_IS_LOCKED);

        } else if (CawConstants.ACCOUNT_TERMINATED.equalsIgnoreCase(_securityMgr.getLoginFailureReasonCode())) {

            return PromptKey.valueOf(CawConstants.LOGIN_IS_TERMINATED);

        }
        //Begin BZ33137
        else if (CawConstants.EMPLOYEE_INACTIVE.equalsIgnoreCase(_securityMgr.getLoginFailureReasonCode())) {
            return PromptKey.valueOf(CawConstants.LOGIN_EMPLOYEE_INACTIVE);
        }
        //End BZ33137
        /* END BZ29580 */
        //End BZ27670
        return super.getDefaultPromptKey();

    }

    /** (non-Javadoc)
     * @see dtv.pos.security.op.NotifyBadAuthenticationOp#handleInitialState(dtv.pos.iframework.event.IXstEvent)
     */
    @Override
    protected IOpResponse handleInitialState(IXstEvent argEvent) {

        this.setOpState(this.POST_PROMPT);
        IFormattable msg = this._securityMgr.getLoginFailureMessage();

        if (msg != null) {
            PromptConfig config = new PromptConfig();
            config.getMsgSectionConfig().setTextKey(msg);
            return this.HELPER.getPromptResponse(this.getPromptKey(), config, new IFormattable[0]);

        } else {

            //Begin BZ27670
            if (ISecurityConstants.ACCOUNT_LOCKED_OUT.equalsIgnoreCase(_securityMgr.getLoginFailureReasonCode())) {
                IFormattable[] args = new IFormattable[1];

                int time = CawConfigurationMgr.getLapseTimeBeforeUnlockingUser();

                args[0] = _ff.getSimpleFormattable(time, FormatterType.SIMPLE);
                return this.HELPER.getPromptResponse(this.getPromptKey(), args);
            }
            /* BEGIN BZ29580 */
            else if (CawConstants.ACCOUNT_TERMINATED.equalsIgnoreCase(_securityMgr.getLoginFailureReasonCode())) {
                return this.HELPER.getPromptResponse(this.getPromptKey());
            }
            /* END BZ29580 */
            /* Begin BZ33137 */
            else if (CawConstants.EMPLOYEE_INACTIVE.equalsIgnoreCase(_securityMgr.getLoginFailureReasonCode())) {
                return this.HELPER.getPromptResponse(this.getPromptKey());
            }
            /* End BZ33137 */
            
            //End BZ27670

            return this.HELPER.getPromptResponse(this.getPromptKey(), new IFormattable[] { IFormattable.EMPTY });
        }
    }

}
