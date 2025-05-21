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
 * BZ29292          140219    [Internal] Need to fix the text on the PLCC Shopping Pass to match ADS Requirements
 * BZ29361          150219    [Requirement] PLCC Acquisition - Changes to Temporary Shopping Pass
 * BZ29454          220219    [Internal] Temporary Shopping Pass is missing Temporary Limit amount.
 * BZ29522          250219    [Internal] [PLCC] PLCC Shopping Pass
 * BZ29619          040319    [Internal][PLCC] Shopping Pass Changes
 *===================================================================
 */

package caw.tenderauth.impl.eigen.goodsam.op;

import java.util.Date;

import javax.inject.Inject;

import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;

import caw.pos.common.CawConstants;
import caw.tenderauth.impl.eigen.CawEigenMgr;
import caw.tenderauth.impl.eigen.CawGoodSamVisaShoppingPassReferenceData;
import caw.tenderauth.impl.eigen.goodsam.common.CawCustomerGSInfo;

import dtv.i18n.FormattableFactory;
import dtv.pos.common.ConfigurationMgr;
import dtv.pos.i18n.format.MoneyFormatter;
import dtv.pos.iframework.security.StationState;
import dtv.xst.dao.crm.IParty;
import dtv.xst.dao.trn.IPosTransaction;

/**
 *
 */
public class CawShoppingPassHelper {

    private static final Logger  logger_         = Logger.getLogger(CawShoppingPassHelper.class);

    @Inject
    protected StationState       _stationState;

    @Inject
    protected FormattableFactory _ff;

    @Inject
    private CawEigenMgr          _cawEigenMgr;

    private MoneyFormatter       _moneyFormatter = new MoneyFormatter();

    public CawGoodSamVisaShoppingPassReferenceData prepareDataForShoppingPass(CawCustomerGSInfo cawCustomerGSInfo,
            IParty iParty, IPosTransaction argTransaction) {

        long orgID = ConfigurationMgr.getOrganizationId();
        int rtlLocId = _stationState.getRetailLocationId();
        int wkstnId = _stationState.getWorkstationId();
        Date busDate = _stationState.getCurrentBusinessDate();

        CawGoodSamVisaShoppingPassReferenceData gsBean = new CawGoodSamVisaShoppingPassReferenceData(orgID, rtlLocId,
                wkstnId, busDate, argTransaction);
        try {
            if (iParty != null) {
                gsBean.setFirstName(iParty.getFirstName());
                gsBean.setLastName(iParty.getLastName());
            }

            if (cawCustomerGSInfo != null) {
                gsBean.setCardType(cawCustomerGSInfo.getCardType());
                gsBean.setCreditLimit(_moneyFormatter.format(cawCustomerGSInfo.getCreditLimit(), null));
                /* BEGIN BZ29454 */
                if (!CawConstants.VALUE_0.equalsIgnoreCase(cawCustomerGSInfo.getVitualCreditLimit())) {
                    gsBean.setTempCreditLimit(_moneyFormatter.format(cawCustomerGSInfo.getVitualCreditLimit(), null));
                } else {
                    gsBean.setTempCreditLimit(CawConstants.VALUE_00);
                }

                if (StringUtils.isNotEmpty(cawCustomerGSInfo.getApr())) {
                    gsBean.setApr(cawCustomerGSInfo.getApr());
                } else {
                    gsBean.setApr(CawConstants.VALUE_0_PERCENT);
                }
                /* END BZ29454 */
                if (cawCustomerGSInfo.getCardType() == 1) {
                    gsBean.setCawGoodSamCongrats(_ff.getTranslatable("_cawShoppingPassCoBrandCongratulations")
                            .toString());
                    String note1 = _cawEigenMgr.makeString("_cawShoppingPassCoBrandNote1", _moneyFormatter
                            .format(cawCustomerGSInfo.getVitualCreditLimit(), null)); //BZ29619
                    gsBean.setCawGoodSamNote1(note1);
                    gsBean.setCawGoodSamFooter(_ff.getTranslatable("_cawShoppingPassCoBrandFooter").toString());
                } else if (cawCustomerGSInfo.getCardType() == 2) {
                    gsBean.setCawGoodSamCongrats(_ff.getTranslatable("_cawShoppingPassPlccCongratulations").toString());
                    /* BEGIN BZ29361, BZ29454 */
                    String note1 = _ff.getTranslatable("_cawShoppingPassPlccNote1").toString();
                    if (CawConstants.VALUE_00.equals(gsBean.getTempCreditLimit())) {
                        note1 = _cawEigenMgr.makeString("_cawShoppingPassCoBrandNote1", _moneyFormatter
                                .format(cawCustomerGSInfo.getCreditLimit(), null)); //BZ29522, BZ29619
                    } else {
                        note1 = _cawEigenMgr.makeString("_cawShoppingPassCoBrandNote1", _moneyFormatter
                                .format(cawCustomerGSInfo.getVitualCreditLimit(), null)); //BZ29619
                    }

                    gsBean.setCawGoodSamNote1(note1);
                    /* END BZ29361, BZ29454 */

                    gsBean.setCawGoodSamFooter(_ff.getTranslatable("_cawShoppingPassPlccFooter").toString());
                }
            }

        } catch (Exception ex) {
            logger_.info("Can not create the object CawGoodSamVisaShoppingPassReferenceData." + ex.getMessage());
        }

        return gsBean;

    }

}
