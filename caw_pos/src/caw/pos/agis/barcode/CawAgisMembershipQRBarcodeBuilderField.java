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
 * BZ61159          160124    [New Requirement] - Xstore AGIS Replacement
 * BZ69392          170225    [AGIS Modification] - Update the Receipt (Section 2.2)
 *===================================================================
 */

package caw.pos.agis.barcode;

import java.util.Locale;

import org.apache.log4j.Logger;

import caw.pos.araccount.CawCustomerUtil;

import dtv.data2.access.ObjectNotFoundException;
import dtv.docbuilding.AbstractDocBuilderField;
import dtv.docbuilding.IDocElementFactory;
import dtv.docbuilding.types.DocBuilderAlignmentType;
import dtv.i18n.formatter.output.IOutputFormatter;
import dtv.pos.common.ConfigurationMgr;
import dtv.xst.dao.com.IReceiptText;

public class CawAgisMembershipQRBarcodeBuilderField extends AbstractDocBuilderField {
    private static Logger _logger = Logger.getLogger(CawAgisMembershipQRBarcodeBuilderField.class);
    private static final String CAW_AGIS_TEMP_MEM_QR_LINK = "CAW_AGIS_TEMP_MEM_QR_LINK";
    private static final String CAW_SUBCODE_DEFAULT   = "DEFAULT";
    private static final String CAW_QR_LINK_DEFAULT   = "https://www.goodsam.com/rewards";
    
    public CawAgisMembershipQRBarcodeBuilderField(String argContents, String argStyle,
            Integer argLocation, DocBuilderAlignmentType argAlignment,
            int argPriority, IOutputFormatter argFormatter) {
        super(argContents, argStyle, argLocation, argAlignment, argPriority, argFormatter);
    }

    @Override
    public String getContents(Object argVar1, IDocElementFactory argVar2,
            Locale argVar3) {
        // BEGIN BZ61965
        String qrContent = CAW_QR_LINK_DEFAULT;
        try {
            IReceiptText  iReceiptText = CawCustomerUtil.getReceiptText(
                    ConfigurationMgr
                    .getOrganizationId(), CAW_AGIS_TEMP_MEM_QR_LINK, CAW_SUBCODE_DEFAULT);
            if (iReceiptText != null) {
                qrContent = iReceiptText.getReceiptText();
            }
        } catch (ObjectNotFoundException e) {
            _logger.warn("Could not find QR Code: " + e.getMessage());
        }
        return qrContent;
        // END BZ61965
    }

}