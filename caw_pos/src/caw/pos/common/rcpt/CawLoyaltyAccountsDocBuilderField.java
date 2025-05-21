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
 * BZ24102          191017    Club accounts information is repeated many times in receipt 
 *                            when selecting 'Print Balance receipt' on Account tab in Customer screen
 * BZ44053          150621    [PROD] Membership Validation Issue - Cannot sell RENEW on active membership accounts
 *===================================================================
 */

package caw.pos.common.rcpt;

import java.util.*;

import javax.inject.Inject;

import caw.pos.customer.CawCustomerMaintenanceModel;

import dtv.docbuilding.AbstractDocBuilderField;
import dtv.docbuilding.IDocElementFactory;
import dtv.docbuilding.types.DocBuilderAlignmentType;
import dtv.i18n.FormattableFactory;
import dtv.i18n.formatter.output.IOutputFormatter;
import dtv.util.temp.InjectionHammer;
import dtv.xst.dao.cat.ICustomerLoyaltyAccount;
import dtv.xst.dao.cat.ICustomerLoyaltyCard;

/**
 * Printed Club Accounts Info. 
 */
@SuppressWarnings("deprecation")
public class CawLoyaltyAccountsDocBuilderField extends AbstractDocBuilderField {

    @Inject
    private FormattableFactory                _ff;

    private String                            clubID;

    private String                            programName;

    private String                            programLevel;

    private List<CawLoyaltyAccountGroupModel> group;

    public CawLoyaltyAccountsDocBuilderField(String argContents,
            String argStyle, Integer argLocation,
            DocBuilderAlignmentType argAlignment, int argPriority,
            IOutputFormatter argFormatter) {

        super(argContents, argStyle, argLocation, argAlignment, argPriority, argFormatter);
        InjectionHammer.forceAtInjectProcessing(this);
        clubID = _ff.getTranslatable("_loyaltyHistoryRcptLoyaltyCardNumber")
                .toString();
        programName = _ff
                .getTranslatable("_loyaltyHistoryRcptLoyaltyProgramName")
                .toString();
        programLevel = _ff
                .getTranslatable("_loyaltyHistoryRcptLoyaltyProgramLevel")
                .toString();
    }

    @Override
    public String getContents(Object argParamObject,
            IDocElementFactory argParamIDocElementFactory,
            Locale argParamLocale) {

        CawCustomerMaintenanceModel cawCustomerMaintenanceModel = null;
        dtv.pos.i18n.format.CreditCardFormatter formmat = new dtv.pos.i18n.format.CreditCardFormatter();
        StringBuffer fields = new StringBuffer();
        group = new ArrayList<CawLoyaltyAccountGroupModel>();
        CawLoyaltyAccountGroupModel item = null;

        if (argParamObject instanceof CawCustomerMaintenanceModel) {
            cawCustomerMaintenanceModel = (CawCustomerMaintenanceModel) argParamObject;
            for (ICustomerLoyaltyCard customerLoyaltyCard : cawCustomerMaintenanceModel
                    .getLoyaltyCards()) {
                for (ICustomerLoyaltyAccount customerLoyaltyAccount : customerLoyaltyCard
                        .getLoyaltyAccounts()) {
                    if (group.size() == 0) {
                        item = new CawLoyaltyAccountGroupModel();
                        item.setClubId(customerLoyaltyAccount.getCardNumber());
                        item.setProgramLevel(customerLoyaltyAccount
                                .getLoyaltyProgramLevelId()); // BZ-44053
                        item.setProgramName(customerLoyaltyAccount
                                .getLoyaltyProgramName());
                        item.setProgramId(customerLoyaltyAccount
                                .getLoyaltyProgramId()); // BZ-44053
                        group.add(item);
                    } else {
                        if (allowAddToGroup(customerLoyaltyAccount
                                .getCardNumber(), customerLoyaltyAccount
                                        .getLoyaltyProgramId(), customerLoyaltyAccount
                                                .getLoyaltyProgramLevelName())) { // BZ-44053
                            item = new CawLoyaltyAccountGroupModel();
                            item.setClubId(customerLoyaltyAccount
                                    .getCardNumber());
                            item.setProgramLevel(customerLoyaltyAccount
                                    .getLoyaltyProgramLevelId()); // BZ-44053
                            item.setProgramName(customerLoyaltyAccount
                                    .getLoyaltyProgramName());
                            item.setProgramId(customerLoyaltyAccount
                                    .getLoyaltyProgramId()); // BZ-44053
                            group.add(item);
                        }
                    }

                }
            }
        }

        for (CawLoyaltyAccountGroupModel iGroup : group) {
            fields.append(clubID + " " + formmat.format(iGroup.getClubId(), "*")
                    + "\n");
            fields.append(programName + " " + iGroup.getProgramName() + "\n");
            fields.append(programLevel + " " + iGroup.getProgramLevel() + "\n");
        }

        return fields.toString();
    }

    /**
     * Check loyalty account is duplicate. 
     * @param argClubID
     * @param argProgramName
     * @param argProgramLevel
     * @return true if ClubId, ProgramName, ProgramLevel aren't duplicate.
     */
    private boolean allowAddToGroup(String argClubID, String argProgramId,
            String argProgramLevel) { // BZ-44053

        for (CawLoyaltyAccountGroupModel i : group) {
            if (argClubID.equals(i.getClubId())
                    && argProgramId.equals(i.getProgramId())
                    && argProgramLevel.equals(i.getProgramLevel())) { // BZ-44053
                return false;
            }
        }
        return true;
    }

}