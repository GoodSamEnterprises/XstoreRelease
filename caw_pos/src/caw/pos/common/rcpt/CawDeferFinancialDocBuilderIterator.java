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
 * BZ33319          040321    Good Sam Visa Promo Plan - Phase 2/Deferred Financing
 *===================================================================
 */

package caw.pos.common.rcpt;

import java.io.IOException;
import java.util.*;

import caw.payment.verifone.CawEmvPaymentCardInfo;
import caw.pos.common.CawConstants;
import caw.pos.common.CawVoucherValue;

import dtv.docbuilding.*;
import dtv.util.CollectionUtils;
import dtv.util.StringUtils;
import dtv.xst.dao.ttr.ICreditDebitTenderLineItem;

/**
 *
 */
public class CawDeferFinancialDocBuilderIterator extends DocBuilderIterator {

    /*BEGIN BZ33319*/

    private static final String COMMA_STR                 = "%2C";

    private static final String START_BOLD_STR            = "\\\\b";

    private static final String START_BOLD_TAG            = "<b>";

    private static final String END_BOLD_TAG              = "</b>";

    private static final String START_BOLD_REPLACE_STR    = "\\\\b<b>";

    private static final String BREAK_LINE_STR            = "\\\\n";

    private static final String END_BOLD_STR              = "\\\\o ";

    private static final String END_BOLD_REPLACE_STR      = "\\\\o</b>";

    private static final String PERCENT                   = "%";

    private static final String PERCENT_STR               = "%25";

    private final String        DEFER_FINANCIAL_SPLIT_STR = "\\\\b|\\\\o";

    @Override
    protected void iterate(IPosDocument argDoc,
            IDocElementFactory argElementFactory, Object argO)
            throws IOException {

        String result = "";
        if (argO instanceof ICreditDebitTenderLineItem) {
            ICreditDebitTenderLineItem lineItem = (ICreditDebitTenderLineItem) argO;
            Map<Integer, CawEmvPaymentCardInfo> mapEMVInfo = CawVoucherValue
                    .getEmvInfo();

            if (CollectionUtils.isEmpty(mapEMVInfo)
                    && !CollectionUtils.isEmpty(CawVoucherValue.getEmvInfo())) { //BZ28744

                mapEMVInfo = CawVoucherValue.getEmvInfo();
            }
            if (!CollectionUtils.isEmpty(mapEMVInfo)) {
                CawEmvPaymentCardInfo emvInfo = mapEMVInfo
                        .get(lineItem.getRetailTransactionLineItemSequence());
                if (emvInfo != null
                        && !StringUtils.isEmpty(emvInfo.getDeferFinancial())) {
                    result = emvInfo.getDeferFinancial()
                            .replaceAll(COMMA_STR, CawConstants.CAW_STRING_COMMA)
                            .replaceAll(BREAK_LINE_STR, CawConstants.CAW_STRING_SPACE)
                            .replaceAll(PERCENT_STR, PERCENT)
                            .replaceAll(START_BOLD_STR, START_BOLD_REPLACE_STR)
                            .replaceAll(END_BOLD_STR, END_BOLD_REPLACE_STR);
                }
            }
        }
        super.iterate(argDoc, argElementFactory, deferFinancialListMsg(result));

    }

    private List<CawDeferFinancialMsg> deferFinancialListMsg(String contents) {

        List<CawDeferFinancialMsg> resultList = new ArrayList<CawDeferFinancialMsg>();
        String[] contensArr = contents.split(DEFER_FINANCIAL_SPLIT_STR);
        CawDeferFinancialMsg deferFinancialMsg = null;
        for (int i = 0; i < contensArr.length; i++) {
            if (!StringUtils.isEmpty(contensArr[i])) {
                deferFinancialMsg = new CawDeferFinancialMsg();
                if (contensArr[i].startsWith(START_BOLD_TAG)) {
                    deferFinancialMsg.setMessage(contensArr[i]
                            .replaceAll(START_BOLD_TAG, CawConstants.CAW_STRING_EMPTY));
                    deferFinancialMsg.setBoldMsg(true);
                } else {
                    deferFinancialMsg.setMessage(contensArr[i]
                            .replaceAll(END_BOLD_TAG, CawConstants.CAW_STRING_EMPTY));
                    deferFinancialMsg.setBoldMsg(false);
                }
                resultList.add(deferFinancialMsg);
            }
        }
        return resultList;
    }

}
