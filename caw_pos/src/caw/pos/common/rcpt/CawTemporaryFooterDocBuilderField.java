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
 * BZ69392          170225    [AGIS Modification] - Update the Receipt (Section 2.2)
 * BZ69871          280225    Spacing Issues for Temp Membership Cards 
 *===================================================================
 */

package caw.pos.common.rcpt;

import java.util.List;
import java.util.Locale;

import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;

import caw.pos.agis.barcode.CawAgisMembershipQRBarcodeBuilderField;
import caw.pos.araccount.CawCustomerUtil;

import dtv.data2.access.ObjectNotFoundException;
import dtv.docbuilding.AbstractDocBuilderField;
import dtv.docbuilding.IDocElementFactory;
import dtv.docbuilding.types.DocBuilderAlignmentType;
import dtv.i18n.formatter.output.IOutputFormatter;
import dtv.pos.common.ConfigurationMgr;
import dtv.xst.dao.com.IReceiptText;
import dtv.xst.dao.crm.IPartyTelephone;
import dtv.xst.dao.trl.impl.RetailTransactionModel;

/**
 *
 */
public class CawTemporaryFooterDocBuilderField extends AbstractDocBuilderField {
    private static Logger _logger = Logger.getLogger(CawAgisMembershipQRBarcodeBuilderField.class);
    private static final String CAW_AGIS_TEMP_MEM_QR_FOOTER_1 = "CAW_AGIS_TEMP_MEM_QR_FOOTER_1";
    private static final String CAW_AGIS_TEMP_MEM_QR_FOOTER_2 = "CAW_AGIS_TEMP_MEM_QR_FOOTER_2";
    private static final String CAW_SUBCODE_DEFAULT   = "DEFAULT";
    
    public CawTemporaryFooterDocBuilderField(String argContents, String argStyle,
            Integer argLocation, DocBuilderAlignmentType argAlignment,
            int argPriority, IOutputFormatter argFormatter) {
        super(argContents, argStyle, argLocation, argAlignment, argPriority, argFormatter);
    }

    @Override
    public String getContents(Object argVar1, IDocElementFactory argVar2, Locale argVar3) {
        try {
            String temporaryFooter = StringUtils.EMPTY;
            /* Receipt Text with Customer phone number */
            IReceiptText  iReceiptText = CawCustomerUtil.getReceiptText(
                    ConfigurationMgr
                    .getOrganizationId(), CAW_AGIS_TEMP_MEM_QR_FOOTER_1, CAW_SUBCODE_DEFAULT);
            if (iReceiptText != null) {
                if (iReceiptText.getReceiptText().contains("XXXX")) {
                    if (argVar1 instanceof RetailTransactionModel) {
                        List<IPartyTelephone> listPhones = ((RetailTransactionModel) argVar1).getCustomerParty().getTelephoneInformation();
                        String phone = StringUtils.EMPTY;
                        
                        for (IPartyTelephone partyPhone : listPhones) {
                            if ("MOBILE".equalsIgnoreCase(partyPhone.getTelephoneType())) {
                                phone = partyPhone.getTelephoneNumber();
                                break;
                            }
                            
                            if ("HOME".equalsIgnoreCase(partyPhone.getTelephoneType())) {
                                phone = partyPhone.getTelephoneNumber();
                            }
                        }
                        
                        if (phone != StringUtils.EMPTY) {
                            if(!iReceiptText.getReceiptText().startsWith("\\n")) {
                                String temp = iReceiptText.getReceiptText().trim() + "  ";
                                temporaryFooter =  temp;
                            }else {
                                temporaryFooter =  iReceiptText.getReceiptText();
                            }
                            String last4digits = phone.substring(phone.length() - 4, phone.length());
                            
                            temporaryFooter = temporaryFooter.replace("XXXX", last4digits);
                        }
                    }
                }
                else {
                    if(!iReceiptText.getReceiptText().startsWith("\\n")) {
                        String temp = iReceiptText.getReceiptText().trim() + "  ";
                        temporaryFooter =  temp;
                    }else {
                        temporaryFooter =  iReceiptText.getReceiptText();
                    }
                }

            }
            
            /* Receipt Text with Subscriber ID */
            IReceiptText  iReceiptTextForSubscriberID = CawCustomerUtil.getReceiptText(
                    ConfigurationMgr
                    .getOrganizationId(), CAW_AGIS_TEMP_MEM_QR_FOOTER_2, CAW_SUBCODE_DEFAULT);
            if (iReceiptTextForSubscriberID != null) {
                if (iReceiptTextForSubscriberID.getReceiptText().contains("XXXX")) {
                    if (argVar1 instanceof RetailTransactionModel) {
                        RetailTransactionModel retailTransactionModel = (RetailTransactionModel) argVar1;
                        String subscriberId = retailTransactionModel.getStringProperty("CAW_SUBSCRIBER_ID_INFORMATION");
                        
                        if (subscriberId != null && subscriberId.isEmpty() == false) {
                            if (!iReceiptTextForSubscriberID.getReceiptText().startsWith("\\n")) {
                                String temp = iReceiptTextForSubscriberID.getReceiptText().trim() + "  ";
                                temporaryFooter =  temporaryFooter + temp; 
                            }else {
                                temporaryFooter =  temporaryFooter + iReceiptTextForSubscriberID.getReceiptText(); 
                            }
                            temporaryFooter = temporaryFooter.replace("XXXX", subscriberId);
                        }
                    }
                }
                else {
                    if (!iReceiptTextForSubscriberID.getReceiptText().startsWith("\\n")) {
                        String temp = iReceiptTextForSubscriberID.getReceiptText().trim() + "  ";
                        temporaryFooter =  temporaryFooter + temp; 
                    }else {
                        temporaryFooter =  temporaryFooter + iReceiptTextForSubscriberID.getReceiptText(); 
                    }
                }

            }
            //BEGIN BZ69871 
            if(StringUtils.isNotEmpty(temporaryFooter) && temporaryFooter.contains("\\n") ) {
                // Ensure that all retrieved text replaces "\\n" with an actual newline
                temporaryFooter = temporaryFooter.replace("\\n", "\n");
            }
            //END BZBZ69871
            return temporaryFooter;
        } catch (ObjectNotFoundException e) {
            _logger.warn("Could not find QR Code: " + e.getMessage());
        }
        return StringUtils.EMPTY;
        // END BZ61965
    }
}
