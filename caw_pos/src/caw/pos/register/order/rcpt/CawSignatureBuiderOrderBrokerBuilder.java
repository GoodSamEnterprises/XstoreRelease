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
 * BZ37382          270820    [Requirement] Signature capturing for Order Creation/Pickup transaction
 *===================================================================
 */

package caw.pos.register.order.rcpt;

import java.awt.Point;
import java.util.Locale;

import javax.inject.Inject;

import org.apache.commons.lang3.StringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import caw.pos.register.ha.rcpt.CawRcptHASubtotalBuilderField;
import caw.tender.impl.mira.response.CawMiraResponseConverter;
import caw.tenderauth.impl.eigen.CawEigenMgr;

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
public class CawSignatureBuiderOrderBrokerBuilder extends AbstractDocBuilderField {
    
    private static final Logger _logger = LogManager
            .getLogger(CawSignatureBuiderOrderBrokerBuilder.class);
    
    /*BEGIN BZ37382*/
    @Inject
    private CawEigenMgr _cawEigenMgr;

    public CawSignatureBuiderOrderBrokerBuilder(String argContents, String argStyle,
            Integer argLocation, DocBuilderAlignmentType argAlignment,
            int argPriority, IOutputFormatter argFormatter) {

        super(argContents, argStyle, argLocation, argAlignment, argPriority, argFormatter);
        InjectionHammer.forceAtInjectProcessing(this);
    }

    @Override
    public String getContents(Object argSource, IDocElementFactory argFactory,
            Locale argLocale) {

        Point[] points = null;
        CawMiraResponseConverter cawMiraResponseConverter = new CawMiraResponseConverter();
        EncString encSignature;
        String strSignature = "";
        try {
            if (_cawEigenMgr.getSigCap() != null) {
                strSignature = _cawEigenMgr.getSigCap();
                if (StringUtils.isNotEmpty(strSignature)) {
                    points = cawMiraResponseConverter
                            .convertSig2Point(strSignature);
                    ISignature isSignature = new Signature(true, HardwareType
                            .forUse(HardwareFamilyType.SIG_CAP, cawMiraResponseConverter.VERIFONE),
                            points, true, false);
                    encSignature = isSignature.getData();
                    return EncString.getSensitiveData(encSignature);
                }
            }
        } catch (Exception ex) {
            // @todo Auto-generated catch block
            ex.printStackTrace();
        }
        return strSignature;
    }
    /*END BZ37382*/
}
