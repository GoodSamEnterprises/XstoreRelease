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
public class CawMembershipStatusDocBuilderField
        extends AbstractDocBuilderField {

    public CawMembershipStatusDocBuilderField(String argArgContents,
            String argArgStyle, Integer argArgLocation,
            DocBuilderAlignmentType argArgAlignment, int argArgPriority,
            IOutputFormatter argArgFormatter) {

        super(argArgContents, argArgStyle, argArgLocation, argArgAlignment, argArgPriority, argArgFormatter);
    }

    @Override
    public String getContents(Object argSource, IDocElementFactory argArg1,
            Locale argArg2) {

        String status = "";
        String code = "";

        if (argSource instanceof CustomerLoyaltyAccountModel) {
            code = ((CustomerLoyaltyAccountModel) argSource)
                    .getLoyaltyProgramLevelName();
        }

        ICodeValue iReasonCode = CodeLocator.getCodeValue(ConfigurationMgr
                .getOrganizationId(), CawCustomerConstants.CAW_MEMBERSHIP_STATUS, code);

        if (iReasonCode != null) {
            status = iReasonCode.getDescription();
            if (status != null && status.length() > 0) {
                return status;
            }
        }

        return code;
    }
}
