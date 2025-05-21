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
 * BZ26847          100718    [1.6.0][25958] Reload/Issue Gift card info prints on receipt incorrectly
 * BZ26978          060818    Gift Card Receipt not printing for activation/reload
 * BZ28859          271218    [Internal]Declined Gift Card Tender Exchange Receipt shows Transaction Type as "Cash Out" instead of "Redemption".
 *===================================================================
 */

package caw.pos.docbuilding;

import java.util.Locale;

import org.apache.commons.lang3.StringUtils;

import caw.pos.common.CawConstants;
import caw.pos.common.CawUtilFunction;
import caw.tender.impl.mira.response.CawMiraResponse;
import caw.tenderauth.impl.eigen.request.CawMiraGiftCardRequest;

import dtv.docbuilding.AbstractDocBuilderField;
import dtv.docbuilding.IDocElementFactory;
import dtv.docbuilding.types.DocBuilderAlignmentType;
import dtv.i18n.formatter.output.IOutputFormatter;

/**
 * This class is used to format content in case Gift card denied.
 */
public class CawGetContentGCDeclineBuilder extends AbstractDocBuilderField {

    public CawGetContentGCDeclineBuilder(String argArgContents,
            String argArgStyle, Integer argArgLocation,
            DocBuilderAlignmentType argArgAlignment, int argArgPriority,
            IOutputFormatter argArgFormatter) {

        super(argArgContents, argArgStyle, argArgLocation, argArgAlignment, argArgPriority, argArgFormatter);
    }

    @Override
    public String getContents(Object argParamObject,
            IDocElementFactory argParamIDocElementFactory,
            Locale argParamLocale) {

        StringBuilder mergeContent = new StringBuilder();
        if (argParamObject instanceof CawMiraResponse
                && ((CawMiraResponse) argParamObject)
                        .getRequest() instanceof CawMiraGiftCardRequest) {
            CawMiraGiftCardRequest GCAccountId = (CawMiraGiftCardRequest) ((CawMiraResponse) argParamObject)
                    .getRequest();
            String results = ((CawMiraResponse) argParamObject)
                    .getReceiptText();
            String temp = results
                    .replace(CawConstants.NEW_LINE_SIGN, CawConstants.SEMICOLON_SIGN);
            String[] parts = temp.split(CawConstants.SEMICOLON_SIGN);
            /* if(i==1): this condition convert number gift card 
             * to mask all but except 6 fist characters 
             * and the last 4 characters regardless if a digit or not
             */
            int len = parts.length;
            String str2;
            for (int i = 0; i < len; i++) {
                if (i == 1) {
                    str2 = CawUtilFunction.formatSerialGCWithMask(GCAccountId
                            .getAccountId(), "*");
                    mergeContent.append(str2)
                            .append(CawConstants.NEW_LINE_SIGN);
                } else {
                    mergeContent.append(parts[i])
                            .append(CawConstants.NEW_LINE_SIGN);
                }
            }
        }

        String content = "";
        if (StringUtils.isNotEmpty(mergeContent)) {
            content = repplaceTransactionType(mergeContent.toString());
        }

        return content;
    }

    /**
     * The function replace transaction type of receipt gift card from ISSUE/RELOAD to Activation.
     * @param message
     * @return
     */
    private String repplaceTransactionType(String message) {

        String content = message;
        String messageUpperCasse = message.toUpperCase();
        if (StringUtils.isNotEmpty(content)) {
            if (messageUpperCasse.contains(CawConstants.TRANSACTION_TYPE_ISSUE.toUpperCase())) {
                content = message.replaceAll(CawConstants.CAW_REGEX_REPLACE
                        + CawConstants.TRANSACTION_TYPE_ISSUE, CawConstants.TRANSACTION_TYPE_ACTIVATION);
                return content;
            } else if (messageUpperCasse.contains(CawConstants.TRANSACTION_TYPE_REDEEM.toUpperCase())) {
                content = message.replaceAll(CawConstants.CAW_REGEX_REPLACE
                        + CawConstants.TRANSACTION_TYPE_REDEEM, CawConstants.TRANSACTION_TYPE_REDEMPTION);
            } else if (messageUpperCasse.contains(CawConstants.TRANSACTION_TYPE_CASH_OUT.toUpperCase())) { /*BZ28859*/
                content = message.replaceAll(CawConstants.CAW_REGEX_REPLACE
                        + CawConstants.TRANSACTION_TYPE_CASH_OUT, CawConstants.TRANSACTION_TYPE_REDEMPTION);
            }
        }
        return content;
    }
    // End BZ26978
    
}
