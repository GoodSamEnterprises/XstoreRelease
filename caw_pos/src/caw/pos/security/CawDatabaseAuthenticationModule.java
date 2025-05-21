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
 * BZ29580          280219    [New Requirement] Change GUI verbiage for the terminated employee notification
 *===================================================================
 */
package caw.pos.security;

import java.util.Date;

import javax.inject.Inject;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import caw.pos.common.CawConstants;

import dtv.data2.access.DataFactory;
import dtv.pos.common.ConfigurationMgr;
import dtv.pos.employee.IEmployeeHelper;
import dtv.pos.framework.scope.DefaultScope;
import dtv.pos.iframework.security.ISecurityCallback;
import dtv.pos.iframework.security.ISecurityConstants;
import dtv.pos.security.DatabaseAuthenticationModule;
import dtv.pos.security.LockedUserMessenger;
import dtv.util.DateUtils;
import dtv.xst.dao.hrs.IEmployee;
import dtv.xst.daocommon.ISystemUser;

public class CawDatabaseAuthenticationModule extends DatabaseAuthenticationModule {

    private static final Logger logger_ = LogManager.getLogger(DatabaseAuthenticationModule.class);

    @Inject
    private LockedUserMessenger _lockedUserMessenger;

    @Inject
    private ISecurityCallback   _securityCallback;

    @Inject
    private IEmployeeHelper     _employeehelper;

    @Inject
    private DefaultScope        _defaultScope;

    @Override
    public ISystemUser authenticate() {

        IEmployee employee = this._employeehelper
                .getEmployee(this._defaultScope.getValue(ISecurityConstants.ENTERED_USER_ID));

        if (employee != null && employee.isTerminated(DateUtils.clearTime(DateUtils.getNewDate()))) {

            return this.fail(employee, CawConstants.ACCOUNT_TERMINATED);

        } else {

            return super.authenticate();

        }

    }

    /**
     * @param argEmployee
     * @param argFailureCode
     * @return
     */
    private ISystemUser fail(IEmployee argEmployee, String argFailureCode) {

        this._securityCallback.setLoginFailureReasonCode(argFailureCode);

        if (argEmployee != null && !argEmployee.isLockedOut() && ConfigurationMgr.isAccountLockoutEnabled()
                && (this.isFailLimitExceeded() || this.isChallengeQuestionFailLimitExceeded())) {

            try {
                argEmployee.setLockedOut(true);

                argEmployee.setLockedOutTimestamp(new Date());

                DataFactory.makePersistent(argEmployee);

                this._lockedUserMessenger.notifyLockedOut(argEmployee);

            } catch (Exception ex) {
                logger_.error("Failed to persistent employee login ", ex.getMessage());
            }
        }

        return null;
    }

}
