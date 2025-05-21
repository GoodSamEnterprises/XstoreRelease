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
 * Z61159              160124    [New Requirement] - Xstore AGIS Replacement
 *===================================================================
 */

package caw.pos.common.rcpt;

import java.math.BigDecimal;
import java.util.List;
import java.util.Locale;

import javax.inject.Inject;

import dtv.docbuilding.AbstractDocBuilderField;
import dtv.docbuilding.IDocElementFactory;
import dtv.docbuilding.types.DocBuilderAlignmentType;
import dtv.i18n.FormattableFactory;
import dtv.i18n.formatter.output.IOutputFormatter;
import dtv.pos.common.ConfigurationMgr;
import dtv.util.NumberUtils;
import dtv.xst.dao.com.CodeLocator;
import dtv.xst.dao.trl.IRetailTransaction;

/**
 *
 */
public class CawTotalPointCouldSavedDocBuilderField extends AbstractDocBuilderField {

    @Inject
    protected FormattableFactory _ff;
    
    /**
    * Constructor.
    *
    * @param argContents the contents
    * @param argStyle the style
    * @param argLocation the location
    * @param argAlignment the alignment
    * @param argPriority the priority
    * @param argFormatter the formatter
    */
    public CawTotalPointCouldSavedDocBuilderField(String argContents,
            String argStyle, Integer argLocation,
            DocBuilderAlignmentType argAlignment, int argPriority,
            IOutputFormatter argFormatter) {

        super(argContents, argStyle, argLocation, argAlignment, argPriority, argFormatter);
    }

    /** {@inheritDoc} */
    @SuppressWarnings("finally")
    @Override
    public String getContents(Object argSource, IDocElementFactory argFactory,
            Locale argLocale) {

        BigDecimal totalDiscount = NumberUtils.ZERO;
        if (argSource instanceof IRetailTransaction) {
            totalDiscount = new CawTotalAmountCouldSavedWorker(
                    (IRetailTransaction) argSource).call();
        }
        List<String> listNumberOfMul = CodeLocator
                .getCodes(ConfigurationMgr.getOrganizationId(), _ff.getTranslatable("_cawNumberOfMuliple").toString());
        return String.valueOf(totalDiscount.multiply(BigDecimal.valueOf(Long.valueOf(listNumberOfMul.get(0)))).intValue());
    }
}