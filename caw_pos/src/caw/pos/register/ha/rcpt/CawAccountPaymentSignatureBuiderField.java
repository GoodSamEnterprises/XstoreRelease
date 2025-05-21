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
 * BZ29476          210219    [Internal] GS Account Payment is prompting signature on PinPad.
 *===================================================================
 */

package caw.pos.register.ha.rcpt;

import java.awt.Point;
import java.util.Locale;

import javax.inject.Inject;

import org.apache.commons.lang3.StringUtils;

import caw.tender.impl.mira.response.CawMiraResponseConverter;
import caw.tenderauth.impl.eigen.CawEigenHelper;

import dtv.docbuilding.AbstractDocBuilderField;
import dtv.docbuilding.IDocElementFactory;
import dtv.docbuilding.types.DocBuilderAlignmentType;
import dtv.hardware.sigcap.ISignature;
import dtv.hardware.sigcap.Signature;
import dtv.hardware.types.HardwareFamilyType;
import dtv.hardware.types.HardwareType;
import dtv.i18n.formatter.output.IOutputFormatter;
import dtv.util.crypto.EncString;
import dtv.util.temp.InjectionHammer;

/**
 *
 */
public class CawAccountPaymentSignatureBuiderField extends AbstractDocBuilderField {

    @Inject
    private CawEigenHelper _cawEigenHelper;

    public CawAccountPaymentSignatureBuiderField(String argContents, String argStyle, Integer argLocation,
            DocBuilderAlignmentType argAlignment, int argPriority, IOutputFormatter argFormatter) {

        super(argContents, argStyle, argLocation, argAlignment, argPriority, argFormatter);
        InjectionHammer.forceAtInjectProcessing(this);
    }

    @Override
    public String getContents(Object argSource, IDocElementFactory argFactory, Locale argLocale) {

        Point[] points = null;
        CawMiraResponseConverter cawMiraResponseConverter = new CawMiraResponseConverter();
        EncString encSignature;
        String strSignature = "";
        try {
            strSignature = _cawEigenHelper.getAcPaymentSignature();
            if (StringUtils.isNotEmpty(strSignature)) {
                points = cawMiraResponseConverter.convertSig2Point(strSignature);
                ISignature isSignature = new Signature(true,
                        HardwareType.forUse(HardwareFamilyType.SIG_CAP, cawMiraResponseConverter.VERIFONE), points,
                        true, false);
                encSignature = isSignature.getData();
                _cawEigenHelper.setAcPaymentSignature(StringUtils.EMPTY);
                return EncString.getSensitiveData(encSignature);
            }
        } catch (Exception ex) {
            // @todo Auto-generated catch block
            ex.printStackTrace();
        }
        return strSignature;
    }
}
