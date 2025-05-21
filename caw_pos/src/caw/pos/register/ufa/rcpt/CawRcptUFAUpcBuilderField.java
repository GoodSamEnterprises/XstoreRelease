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
 * BZ25640          051518    New Requirement - Used Firearm System Process Redesign
 *===================================================================
 */

package caw.pos.register.ufa.rcpt;

import java.util.Locale;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import twitter4j.JSONException;
import twitter4j.JSONObject;

import dtv.docbuilding.AbstractDocBuilderField;
import dtv.docbuilding.IDocElementFactory;
import dtv.docbuilding.types.DocBuilderAlignmentType;
import dtv.i18n.formatter.output.IOutputFormatter;
import dtv.xst.dao.trl.IRetailTransactionLineItemProperty;
import dtv.xst.dao.tsn.ITenderControlTransaction;
import dtv.xst.dao.ttr.ITenderLineItem;

/**
 *
 */
public class CawRcptUFAUpcBuilderField extends AbstractDocBuilderField {

    private static final Logger _logger = LogManager
            .getLogger(CawRcptUFAUpcBuilderField.class);

    public CawRcptUFAUpcBuilderField(String argContents, String argStyle,
            Integer argLocation, DocBuilderAlignmentType argAlignment,
            int argPriority, IOutputFormatter argFormatter) {

        super(argContents, argStyle, argLocation, argAlignment, argPriority, argFormatter);
    }

    @Override
    public String getContents(Object argSource, IDocElementFactory argFactory,
            Locale argLocale) {

        String result = "";
        if (argSource instanceof ITenderControlTransaction) {
            ITenderControlTransaction tndControlTrans = (ITenderControlTransaction) argSource;
            tndControlTrans.getRetailTransactionLineItems().get(0)
                    .getProperties();
            Object tender = tndControlTrans.getRetailTransactionLineItems()
                    .get(0);
            if (tender instanceof ITenderLineItem) {
                Object mObj = ((ITenderLineItem) tender).getProperties().get(2);
                if (mObj instanceof IRetailTransactionLineItemProperty) {
                    ((IRetailTransactionLineItemProperty) mObj)
                            .getStringValue();
                    JSONObject objects = null;
                    try {
                        objects = new JSONObject(
                                ((IRetailTransactionLineItemProperty) mObj)
                                        .getStringValue());
                        if (!objects.isNull("upc")) {
                            result = objects.get("upc").toString();
                        }
                    } catch (JSONException ex) {
                        _logger.error("getContents-upc", ex);
                    }

                }
            }
        }
        return result;
    }

}
