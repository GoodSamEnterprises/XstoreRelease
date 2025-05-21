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
 * BZ24350          201117    Receipts need to print Tax code summary
 *===================================================================
 */

package caw.pos.common.rcpt;

import java.math.BigDecimal;
import java.util.List;
import java.util.Locale;

import oracle.retail.xstore.countrypack.common.docbuilding.TaxPercentageGroupBuilderField;

import dtv.docbuilding.IDocElementFactory;
import dtv.docbuilding.types.DocBuilderAlignmentType;
import dtv.i18n.formatter.output.IOutputFormatter;
import dtv.pos.register.tax.TaxBreakPointType;
import dtv.util.NumberUtils;
import dtv.util.temp.InjectionHammer;
import dtv.xst.dao.tax.*;
import dtv.xst.dao.trl.impl.TaxLineItemModel;

/**
 *
 */
public class CawTaxPercentageGroupBuilderField
        extends TaxPercentageGroupBuilderField {

    /**
     * 
     */
    public CawTaxPercentageGroupBuilderField(String argContents,
            String argStyle, Integer argLocation,
            DocBuilderAlignmentType argAlignment, int argPriority,
            IOutputFormatter argFormatter) {

        super(argContents, argStyle, argLocation, argAlignment, argPriority, argFormatter);
        InjectionHammer.forceAtInjectProcessing((Object) ((Object) this));
    }

    @Override
    public String getContents(Object argSource, IDocElementFactory argFactory,
            Locale argLocale) {

        if (argSource instanceof TaxLineItemModel) {
            TaxLineItemModel taxLine = (TaxLineItemModel) argSource;
            ITaxLocation taxLocation = this.taxHelper_
                    .getTaxLocationByRetailLocation((long) this._stationState
                            .getRetailLocationId());
            BigDecimal taxPercentage = this
                    .getTaxRateRule(taxLocation, taxLine.getTaxGroupId());
            /*Begin BZ24350*/
            return taxPercentage.multiply(new BigDecimal(100.00))
                    .setScale(3, BigDecimal.ROUND_HALF_EVEN).toString() + "%";
            /*End BZ24350*/
        }
        return null;
    }

    private BigDecimal getTaxRateRule(ITaxLocation argTaxLocation,
            String argTaxGroupId) {

        List<ITaxGroupRule> groupRules = this.taxHelper_
                .getGroupRules(argTaxGroupId, argTaxLocation);
        BigDecimal groupRate = BigDecimal.ZERO;
        for (ITaxGroupRule groupRule : groupRules) {
            BigDecimal groupRuleRate = BigDecimal.ZERO;
            for (ITaxRateRule rateRule : groupRule.getTaxRateRules()) {
                if (!rateRule
                        .doesTaxRuleApply(this._transDateProvider.getDate())) {
                    continue;
                }
                if (TaxBreakPointType.PART.toString()
                        .equals(rateRule.getBreakPointTypeCode())
                        && NumberUtils
                                .isGreaterThanOrEqual((BigDecimal) rateRule
                                        .getPercent(), (BigDecimal) groupRate)) {
                    groupRuleRate = rateRule.getPercent();
                    continue;
                }
                groupRuleRate = NumberUtils
                        .add((BigDecimal) groupRuleRate, (BigDecimal) rateRule
                                .getPercent());
            }
            groupRate = NumberUtils
                    .add((BigDecimal) groupRate, (BigDecimal) groupRuleRate);
        }
        return groupRate;
    }
}
