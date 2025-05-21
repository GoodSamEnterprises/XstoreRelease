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

import org.apache.commons.lang3.StringUtils;

import caw.pos.common.CawConstants;

import dtv.data2.access.DataFactory;
import dtv.i18n.IFormattable;
import dtv.pos.common.ConfigurationMgr;
import dtv.pos.framework.form.BasicEditModel;
import dtv.xst.dao.com.DatabaseTranslationId;
import dtv.xst.dao.com.impl.DatabaseTranslationModel;

/**
 *
 */
public class CawMembershipEmailCaptureModel extends BasicEditModel {
    
    public static final String MESSAGE = "message";

    public static final String EMAIL   = "email";

    private String             _message;

    private String             _email;
    
    public CawMembershipEmailCaptureModel(String merchLvl4) {
        
        super(getFormTitle(merchLvl4),FF.getTranslatable("_empty"));
        
        addField(MESSAGE, String.class);
        addField(EMAIL, String.class);
        
        setMessage(getFormMsg(merchLvl4));
        
        initializeFieldState();
    }
    
    private static IFormattable getFormTitle(String merchLvl4) {
        IFormattable result = FF.getTranslatable("_membershipEmailCaptureTitleDefault");
        
        String translationKey = CawConstants.MEMBERSHIP_EMAIL_PROMPT_TITLE_PREFIX + merchLvl4;
        
        DatabaseTranslationId id = new DatabaseTranslationId();
        
        id.setOrganizationId(ConfigurationMgr.getOrganizationId());
        id.setLocale(CawConstants.LOCALE_DEFAULT);
        id.setTranslationKey(translationKey);
        
        DatabaseTranslationModel model = DataFactory.getObjectByIdNoThrow(id);
        
        if (model != null && StringUtils.isNotEmpty(model.getTranslation())) {
            result = FF.getLiteral(model.getTranslation());
        }
        
        return result;
    }
    
    private static String getFormMsg(String merchLvl4) {
        String result = FF.getTranslatable("_membershipEmailCaptureMsgDefault").toString();
        
        String translationKey = CawConstants.MEMBERSHIP_EMAIL_PROMPT_MSG_PREFIX + merchLvl4;
        
        DatabaseTranslationId id = new DatabaseTranslationId();
        
        id.setOrganizationId(ConfigurationMgr.getOrganizationId());
        id.setLocale(CawConstants.LOCALE_DEFAULT);
        id.setTranslationKey(translationKey);
        
        DatabaseTranslationModel model = DataFactory.getObjectByIdNoThrow(id);
        
        if (model != null && StringUtils.isNotEmpty(model.getTranslation())) {
            result = model.getTranslation();
        }
        
        return result;
    }

    public String getMessage() {
    
        return _message;
    }

    public void setMessage(String argMessage) {
    
        _message = argMessage;
    }

    public String getEmail() {
    
        return _email;
    }

    public void setEmail(String argEmail) {
    
        _email = argEmail;
    }
}
