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
 * BZ42889          110521    [Prod] Order cancellation with pricing turned on, tries to force a return with a refund. The refund should be happening in Oracle.
 *===================================================================
 */

package caw.pos.tender;

import java.math.BigDecimal;
import java.util.Currency;

import javax.inject.Inject;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import dtv.hardware.HardwareMgr;
import dtv.pos.common.CommonHelper;
import dtv.pos.common.ConfigurationMgr;
import dtv.pos.framework.op.Operation;
import dtv.pos.iframework.event.IXstEvent;
import dtv.pos.iframework.op.IOpResponse;
import dtv.pos.iframework.type.TenderUsageCodeType;
import dtv.pos.spring.ValueKeys;
import dtv.pos.tender.TenderHelper;
import dtv.xst.dao.sec.IGroup;
import dtv.xst.dao.tnd.ITender;
import dtv.xst.dao.trn.IPosTransaction;
import dtv.xst.dao.ttr.ITenderLineItem;

/**
 *
 */
public class CawAutoFillTenderAmtop extends Operation {

    private static final Logger _logger = LogManager
            .getLogger(CawAutoFillTenderAmtop.class);

    @Inject
    private TenderHelper        _tenderHelper;

    @Inject
    private CommonHelper        _commonHelper;

    @Inject
    private HardwareMgr         _hardwareMgr;

    @Override
    public IOpResponse handleOpExec(IXstEvent argVar1) {

        setDefaultAmountDue();

        setDefaultRefundBalance();

        return this.HELPER.completeResponse();

    }

    /**
     * Set default refund balance
     */
    private void setDefaultRefundBalance() {

        ITenderLineItem tenderLine = this
                .getScopedValue(ValueKeys.CURRENT_TENDER_LINE);

        IPosTransaction transaction = this._transactionScope.getTransaction();

        BigDecimal tenderedAmt = this._tenderHelper
                .getTotalForTender(tenderLine.getTender(), transaction);

        tenderedAmt = this._commonHelper.roundCurrency(tenderedAmt);

        BigDecimal amountDue = getAmountDue(transaction);

        tenderLine.setAmount(amountDue);
    }

    /**
     * @param argTran
     * @return
     */
    private BigDecimal getAmountDue(IPosTransaction argTran) {

        return argTran.getAmountDue();
    }

    /**
     * Show balance on VeriFone
     */
    private void setDefaultAmountDue() {

        BigDecimal dftAmtDue = BigDecimal.ZERO;

        ITenderLineItem tenderLine = this
                .getScopedValue(ValueKeys.CURRENT_TENDER_LINE);
        TenderUsageCodeType tenderUsage = this
                .getScopedValue(ValueKeys.CURRENT_TENDER_USAGE_CODE);
        ITender tender = tenderLine.getTender();
        Currency currency = Currency.getInstance(tender.getCurrencyId());

        IGroup group = this._stationState.getSystemUser().getPrimaryGroup();
        if (group == null) {
            _logger.warn("system user (operatorId='"
                    + this._stationState.getSystemUser().getOperatorId()
                    + "') has no primary group");

        }

        dftAmtDue = this._tenderHelper
                .getMaxPromptAmount(tender, tenderUsage, this._transactionScope
                        .getTransaction(), group);
        dftAmtDue = dftAmtDue
                .setScale(currency.getDefaultFractionDigits(), ConfigurationMgr
                        .getLocalCurrencyRoundingMode());

        this._hardwareMgr.getCustDisplay().setAmountDue(dftAmtDue);
    }

}
