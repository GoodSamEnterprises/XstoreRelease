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
 * BZ23868          101017    When Opening Register, Prompted to Count Australian & Canada Cash
 *===================================================================
 */

package caw.pos.till.count;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import dtv.pos.common.ConfigurationMgr;
import dtv.pos.common.OpChainKey;
import dtv.pos.iframework.event.IXstEvent;
import dtv.pos.iframework.op.IOpResponse;
import dtv.pos.spring.ValueKeys;
import dtv.pos.till.count.PromptStartTillCountOp;
import dtv.pos.till.count.TillCountModel;
import dtv.pos.till.types.TenderCountTypeCode;
import dtv.xst.dao.tnd.ITender;
import dtv.xst.dao.tsn.ISession;

/**
 * This operation handles prompting the user to enter start till count in register mode.
 * @author jhsiao
 * @created December 7, 2004
 * @version $Revision: 320971 $
 */
public class CawPromptRegisterStartTillCountOp extends PromptStartTillCountOp {

    /** {@inheritDoc} */
    @Override
    public IOpResponse handleOpExec(IXstEvent argEvent) {

        IOpResponse response = super.handleOpExec(argEvent);

        if (ConfigurationMgr.isQuickTransferNoTillCount()) {
            for (ITender tender : getTendersToCount()) {
                _declaredAmounts.put(tender, BigDecimal.ZERO);
            }

            setScopedValue(ValueKeys.ENTERED_TENDER_COUNTS, _declaredAmounts);
            return HELPER.completeResponse();
        }

        return response;
    }

    /** {@inheritDoc} */
    @Override
    protected OpChainKey getCancelTillCountChainKey() {

        return OpChainKey.valueOf("REGISTER_START_TILL_COUNT_CANCEL");
    }

    /** {@inheritDoc} */
    @Override
    protected TillCountModel createTillCountModel() {

        TenderCountTypeCode countMethod = TenderCountTypeCode
                .valueOf(ConfigurationMgr.getStartTillCountMethod());
        ISession currentSession = getScopedValue(ValueKeys.CURRENT_SESSION);

        List<ITender> tenders = getTendersToCount();
        List<ITender> list = new ArrayList();
        if (tenders != null && !tenders.isEmpty()) {
            int size = tenders.size();
            for (int i = 0; i < size; i++) {
                if (tenders.get(i).getTenderId().equals("USD_CURRENCY")) {
                    list.add(tenders.get(i));
                }
            }
        }

        TillCountModel model = new TillCountModel(null, currentSession, list,
                countMethod, false, false, getTenderCountTransactionType(),
                null);
        model.setCountViewSummaryType(getCountViewSummaryType());

        return model;
    }
}
