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
 * BZ26893          291018    [New Requirement] - Xstore Transaction Receipt Changes
 * BZ44053          150621    [PROD] Membership Validation Issue - Cannot sell RENEW on active membership accounts
 *===================================================================
 */

package caw.pos.common.rcpt;

import java.util.Locale;
import caw.pos.customer.CawCustomerConstants;
import dtv.docbuilding.AbstractDocBuilderField;
import dtv.docbuilding.IDocElementFactory;
import dtv.docbuilding.types.DocBuilderAlignmentType;
import dtv.i18n.formatter.output.IOutputFormatter;
import dtv.pos.common.ConfigurationMgr;
import dtv.xst.dao.cat.impl.CustomerLoyaltyAccountModel;
import dtv.xst.dao.com.CodeLocator;
import dtv.xst.dao.com.ICodeValue;

/**
 *
 */
public class CawMembershipNameDocBuilderField extends AbstractDocBuilderField {

    public CawMembershipNameDocBuilderField(String argArgContents,
            String argArgStyle, Integer argArgLocation,
            DocBuilderAlignmentType argArgAlignment, int argArgPriority,
            IOutputFormatter argArgFormatter) {

        super(argArgContents, argArgStyle, argArgLocation, argArgAlignment, argArgPriority, argArgFormatter);
    }

    @Override
    public String getContents(Object argSource, IDocElementFactory argArg1,
            Locale argArg2) {

        String name = "";
        String code = "";
        // Start BZ-44053
        String result = "";
        if (argSource instanceof CustomerLoyaltyAccountModel) {
            CustomerLoyaltyAccountModel loyaltyAcc = (CustomerLoyaltyAccountModel) argSource;
            code = loyaltyAcc.getLoyaltyProgramId();
            result = loyaltyAcc.getLoyaltyProgramName();
        } // End BZ-44053
        
        ICodeValue iReasonCode = CodeLocator.getCodeValue(ConfigurationMgr
                .getOrganizationId(), CawCustomerConstants.CAW_MEMBERSHIP_NAME, code);

        // Start BZ-44053
        if (iReasonCode != null) {
            name = iReasonCode.getDescription();
            if (name != null && name.length() > 0) {
                result = name;
            }
        } // End BZ-44053

        return result; // BZ-44053
    }
}
