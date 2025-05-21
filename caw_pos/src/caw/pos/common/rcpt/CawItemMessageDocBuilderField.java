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
 * BZ29625          180419    [New Requirement] - Auto-Renewal Item Specific Receipts
 *===================================================================
 */

package caw.pos.common.rcpt;

import java.util.*;

import javax.inject.Inject;

import caw.pos.common.CawConstants;
import caw.pos.common.CawValueKeys;
import caw.pos.item.CawItemHelper;
import caw.pos.item.CawItemMessage;

import dtv.docbuilding.AbstractDocBuilderField;
import dtv.docbuilding.IDocElementFactory;
import dtv.docbuilding.types.DocBuilderAlignmentType;
import dtv.i18n.formatter.output.IOutputFormatter;
import dtv.pos.framework.scope.TransactionScope;
import dtv.util.StringUtils;
import dtv.util.temp.InjectionHammer;

/**
 *
 */
public class CawItemMessageDocBuilderField extends AbstractDocBuilderField {

    @Inject
    protected TransactionScope _transactionScope;

    public CawItemMessageDocBuilderField(String argContents, String argStyle, Integer argLocation,
            DocBuilderAlignmentType argAlignment, int argPriority, IOutputFormatter argFormatter) {

        super(argContents, argStyle, argLocation, argAlignment, argPriority, argFormatter);
        InjectionHammer.forceAtInjectProcessing(this);
    }

    @Override
    public String getContents(Object argSource, IDocElementFactory argFactory, Locale argLocale) {

        @SuppressWarnings("unchecked")
        Map<String, List<CawItemMessage>> mapItemMess = _transactionScope.getValue(CawValueKeys.CAW_MAP_ITM_MSG);
        Map<String, List<CawItemMessage>> mapItemMessSort = new TreeMap<String, List<CawItemMessage>>(
                new Comparator<String>() {
                    // Sort line sequence of item 
                    @Override
                    public int compare(String msg1, String msg2) {
                        String[] Arrmsg1 = msg1.split(CawConstants.CAW_COLON_SIGN);
                        Integer imsg1 = Integer.valueOf(Arrmsg1[1]);
                        String[] Arrmsg2 = msg2.split(CawConstants.CAW_COLON_SIGN);
                        Integer imsg2 = Integer.valueOf(Arrmsg2[1]);
                        return imsg1.compareTo(imsg2);
                    }

                });

        mapItemMessSort.putAll(mapItemMess);

        StringBuilder strItemMessages = new StringBuilder();
        List<CawItemMessage> listCawItemMessages = new ArrayList<>();
        List<CawItemMessage> listCawItemTempMessages = new ArrayList<>();

        for (Map.Entry<String, List<CawItemMessage>> entry : mapItemMessSort.entrySet()) {
            listCawItemTempMessages = entry.getValue();
            for (CawItemMessage cawItemMessage : listCawItemTempMessages) {
                if (!CawItemHelper.getInstance().checkDuplicateItemMSGId(listCawItemMessages, cawItemMessage)) {
                    listCawItemMessages.add(cawItemMessage);
                }
            }
        }

        for (CawItemMessage cawItemMessage : listCawItemMessages) {
            strItemMessages.append(cawItemMessage.getStringMessage() + StringUtils.NEW_LINE);
        }
        _transactionScope.clearValue(CawValueKeys.CAW_MAP_ITM_MSG);
        return strItemMessages.toString();
    }

}
