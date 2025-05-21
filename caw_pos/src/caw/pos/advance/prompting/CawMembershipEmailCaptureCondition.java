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
 * BZ45995          141021    [New requirement] Email capture when good sam membership is sold
 *===================================================================
 */

package caw.pos.advance.prompting;

import javax.inject.Inject;

import org.apache.commons.lang3.StringUtils;

import caw.pos.common.CawConstants;
import caw.pos.ejournal.CawTransactionSearchHelper;

import dtv.data2.access.DataFactory;
import dtv.pos.common.ConfigurationMgr;
import dtv.pos.framework.op.AbstractRunCondition;
import dtv.pos.spring.ValueKeys;
import dtv.xst.dao.com.*;
import dtv.xst.dao.com.impl.CodeValueModel;
import dtv.xst.dao.crm.IParty;
import dtv.xst.dao.itm.IItem;

/**
 *
 */
public class CawMembershipEmailCaptureCondition extends AbstractRunCondition {
    
    private static final String CAW_MEMBERSHIP_EMAIL_CAPTURE = "CAW_MEMBERSHIP_EMAIL_CAPTURE";
    @Inject
    private CawTransactionSearchHelper   _cawTransactionSearchHelper;
    @Override
    protected boolean shouldRunImpl() {
        boolean shouldRun = false;

        IItem currentItem = getScopedValue(ValueKeys.CURRENT_ITEM);
        IParty currentCustomer = getScopedValue(ValueKeys.SELECTED_CUSTOMER);
        String enableMenEmailCapture = _cawTransactionSearchHelper.getCodeValue(CawConstants.CAW_MEM_EMAIL_CAPTURE_ENABLE);
        if (CawConstants.TRUE_STRING.equalsIgnoreCase(enableMenEmailCapture) 
                && currentItem != null && currentCustomer != null) {
            if (isCurrentItemEmailCaptureEnabled(currentItem) && isCurrentCustomerHasNoEmail(currentCustomer)) {
                shouldRun = true;
            }
        }

        return shouldRun;
    }
    
    private boolean isCurrentItemEmailCaptureEnabled(IItem currentItem) {
        boolean result = false;
        
        if (currentItem != null) {
            CodeValueId codeValueId = new CodeValueId();
            
            codeValueId.setOrganizationId(ConfigurationMgr.getOrganizationId());
            codeValueId.setCategory(CAW_MEMBERSHIP_EMAIL_CAPTURE);
            codeValueId.setCode(currentItem.getMerchLevel4Id());
            
            CodeValueModel codeValue = DataFactory.getObjectByIdNoThrow(codeValueId);
            
            if (codeValue != null) {
                result = true;
            }
        }
        
        return result;
    }
    
    private boolean isCurrentCustomerHasNoEmail(IParty currentCustomer) {
        boolean result = false;;
        
        if (currentCustomer != null) {
            if (StringUtils.isEmpty(currentCustomer.getEmailAddress())) {
                result = true;
            }
        }
        
        return result;
    }

}
