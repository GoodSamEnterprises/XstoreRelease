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
 * BZ23263          250917    Implement House Account
 * BZ24945          020118    AR tender is disable on Return tender option screen when performing return transaction by scanning trans on Sell item screen
 * BZ61330          290124    Update tender options for Verified return, Unverified return, web orders and Tender Exchange
 *===================================================================
 */

package caw.pos.araccount;

import static dtv.hardware.custdisplay.IDtvCustDisplayDevice.TENDER_CANCELLED_EVENT;
import static dtv.hardware.custdisplay.IDtvCustDisplayDevice.TENDER_CANCELLED_EVENT_DESCRIPTOR;
import static dtv.pos.common.ConfigurationMgr.getLocalCurrencyRoundingMode;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Currency;
import java.util.List;

import javax.inject.Inject;
import javax.swing.ImageIcon;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import caw.pos.common.CawConstants;
import caw.pos.common.CawValueKeys;

import dtv.event.eventor.DefaultEventor;
import dtv.hardware.HardwareMgr;
import dtv.i18n.IFormattable;
import dtv.pos.common.*;
import dtv.pos.framework.op.AbstractPromptOp;
import dtv.pos.framework.scope.ValueKey;
import dtv.pos.framework.ui.config.*;
import dtv.pos.iframework.event.IXstEvent;
import dtv.pos.iframework.op.IOpResponse;
import dtv.pos.iframework.type.TenderUsageCodeType;
import dtv.pos.register.returns.ReturnManager;
import dtv.pos.spring.ValueKeys;
import dtv.pos.tender.TenderConstants;
import dtv.pos.tender.TenderHelper;
import dtv.pos.tender.validation.TenderAmountData;
import dtv.pos.ui.util.IconUtils;
import dtv.ui.UIResourceManager;
import dtv.util.NumberUtils;
import dtv.xst.dao.sec.IGroup;
import dtv.xst.dao.tnd.ITender;
import dtv.xst.dao.tnd.TenderStatus;
import dtv.xst.dao.trl.IRetailTransaction;
import dtv.xst.dao.trl.IRetailTransactionLineItem;
import dtv.xst.dao.trn.IPosTransaction;
import dtv.xst.dao.ttr.ITenderLineItem;
import dtv.xst.dao.ttr.impl.TenderLineItemModel;

/**
 * This function is used to show prompt enter AR/Third party amount and handle for these function
 */
public class CawPromptTenderAmtOp extends AbstractPromptOp {

    private static final Logger          _logger                  = LogManager
            .getLogger(CawPromptTenderAmtOp.class);

    /** The tender helper. */
    @Inject
    protected TenderHelper               _tenderHelper;

    @Inject
    private CommonHelper                 _commonHelper;

    @Inject
    private HardwareMgr                  _hardwareMgr;
    
    @Inject
    private ReturnManager                _returnMgr;

    public static final ValueKey<String> ACCOUNT_NUMBER           = new ValueKey<String>(
            String.class, "ACCOUNT_NUMBER");

    private static final String          CAW_PROMPT_AR_WARNING_OP = "CAW_PROMPT_AR_WARNING_OP";

    /** {@inheritDoc} */
    @Override
    public PromptKey getDefaultPromptKey() {

        return PromptKey.valueOf("ENTER_TENDER_AMOUNT");
    }

    /**
     * Return the operation response that contains a prompt request with the specified prompt key. Override the
     * default behavior by sending along the current balance due as part of the prompt request if the current
     * tender is configured to do so.
     *
     * @param argEvent the current event
     * @param argPromptKey the prompt key
     * @param promptArgs prompt arguments
     * @return the operation response that contains a prompt request
     */
    @Override
    public IOpResponse getPromptResponse(IXstEvent argEvent,
            PromptKey argPromptKey, IFormattable[] promptArgs) {

        ITenderLineItem tenderLine = getScopedValue(ValueKeys.CURRENT_TENDER_LINE);
        PromptConfig config = createPromptConfig();

        if (tenderLine.getTender().getOptions().getDfltToAmountDue()) {
            config.setDataFieldConfig(new DataFieldConfig());

            BigDecimal maxAllowed = getDefaultAmountDue().abs();
            config.getDataFieldConfig().setDefaultValue(maxAllowed);
        }

        return HELPER.getPromptResponse(argPromptKey, config, promptArgs);
    }

    /**
     * Handle the response that was entered for this prompt. Subclasses will decide how to appropriately handle
     * the event that has occurred.
     *
     * @param argEvent the current event (containing the response data).
     * @return {@inheritDoc}
     */
    @Override
    public IOpResponse handlePromptResponse(IXstEvent argEvent) {

        //BZ23263
        BigDecimal arBalance = new BigDecimal(0);
        if (_transactionScope
                .getValue(CawValueKeys.AR_ACCOUNT_BALANCE) != null) {
            arBalance = _transactionScope
                    .getValue(CawValueKeys.AR_ACCOUNT_BALANCE);
        }

        new DefaultEventor(TENDER_CANCELLED_EVENT_DESCRIPTOR)
                .post(TENDER_CANCELLED_EVENT);
        ITenderLineItem tenderLine = getScopedValue(ValueKeys.CURRENT_TENDER_LINE);
        TenderAmountData amountData = getScopedValue(ValueKeys.CURRENT_TENDER_AMOUNT_DATA);

        BigDecimal tenderAmount = amountData.getEnteredAmount();
        tenderAmount = _commonHelper.roundCurrency(tenderAmount);

        if (tenderLine.getTenderStatusCode()
                .equalsIgnoreCase(TenderStatus.TENDER.getName())) {
            tenderLine.setAmount(tenderAmount);

            // handle modification of foreign tender amount
            if (_tenderHelper.isForeignTender(tenderLine.getTender())) {
                int localRoundingDigits = ConfigurationMgr
                        .getLocalCurrencyScale();

                // Set the exchange rate
                BigDecimal exchangeRate = _tenderHelper
                        .getExchangeRate(tenderLine.getTender()
                                .getCurrencyId(), _stationState
                                        .getRetailLocationId());
                tenderLine.setExchangeRate(exchangeRate);

                // Set the entered amount of foreign currency
                BigDecimal amt = getBigDecimal(argEvent);
                tenderLine.setForeignAmount(amt);

                // Calculate the amount in local currency
                amt = amt
                        .divide(exchangeRate, localRoundingDigits, RoundingMode.UP);
                tenderLine.setAmount(amt);
            }
        } else {
            // Make the refund and change tender amount negative
            tenderLine.setAmount(tenderAmount.negate());
        }
        //Begin BZ23263

        if (tenderLine.getTender().getTenderId()
                .equalsIgnoreCase("AR_ACCOUNT")) {
            if (tenderLine.getAmount().compareTo(arBalance) > 0) { // BZ 24945
                return HELPER.getStartChainResponse(OpChainKey
                        .valueOf(CAW_PROMPT_AR_WARNING_OP));
            }

        }

        //End BZ23263 
        return HELPER.completeResponse();
    }

    /**
     * Gets if the operation is applicable. Prompting for tendering will be skipped if the tender already has an
     * amount associated with it. This is to support tenders like gift certificates that may have a fixed amount
     * associated with them.
     *
     * @return true is applicable. otherwise false
     */
    @Override
    public boolean isOperationApplicable() {

        ITenderLineItem tenderLineItem = getScopedValue(ValueKeys.CURRENT_TENDER_LINE);
        if (_transactionScope
                .getValue(CawValueKeys.IS_ALLOW_DISPLAY_PROMPT_AMT) != null) {
            if (_transactionScope
                    .getValue(CawValueKeys.IS_ALLOW_DISPLAY_PROMPT_AMT) == true) {
                return true;
            }
        }
        return (tenderLineItem.getAmount() == null);
    }

    /**
     * Creates a prompt config object, allows descendents of this class to add there on prompt config stuff
     * without overriding the entire getPromptRespone method.
     *
     * @return prompt config object
     */
    protected PromptConfig createPromptConfig() {

        PromptConfig config = new PromptConfig();

        // create prompt config to display appropriate icon for selected currency type
        ITenderLineItem tenderLineItem = getScopedValue(ValueKeys.CURRENT_TENDER_LINE);
        String currency = tenderLineItem.getTender().getCurrencyId();
        String key = "_imagePromptCurrency" + currency;
        IconGroupConfig iconGroupConfig = new IconGroupConfig();
        if (UIResourceManager.getInstance().getString(key) == null) {
            key = "_imagePromptCurrency";
        }

        // set the icon using a VolatileIconRefConfig, which takes advantage of caching
        IconRefConfig currencyIconConfig = new VolatileIconRefConfig();
        currencyIconConfig.setValue(key);
        iconGroupConfig
                .setConfigObject(IconGroupConfig.ICON_TAG, currencyIconConfig);
        config.setIconGroupConfig(iconGroupConfig);

        return config;
    }

    /**
     * Get the amount due.
     *
     * @param argTran the transaction to check
     * @return the amount due
     */
    protected BigDecimal getAmountDue(IPosTransaction argTran) {

        return argTran.getAmountDue();
    }

    /**
     * Calculates default amount due.
     *
     * @return default amount due
     */
    protected BigDecimal getDefaultAmountDue() {

        BigDecimal dftAmtDue = BigDecimal.ZERO;

        ITenderLineItem tenderLine = getScopedValue(ValueKeys.CURRENT_TENDER_LINE);
        TenderUsageCodeType tenderUsage = getScopedValue(ValueKeys.CURRENT_TENDER_USAGE_CODE);
        ITender tender = tenderLine.getTender();
        Currency currency = Currency.getInstance(tender.getCurrencyId());

        IGroup group = _stationState.getSystemUser().getPrimaryGroup();
        if (group == null) {
            _logger.warn("system user (operatorId='"
                    + _stationState.getSystemUser().getOperatorId()
                    + "') has no primary group");
        }

        dftAmtDue = _tenderHelper
                .getMaxPromptAmount(tender, tenderUsage, _transactionScope
                        .getTransaction(), group);

        dftAmtDue = getDefaultValue(tender, dftAmtDue);
        dftAmtDue = dftAmtDue.setScale(currency
                .getDefaultFractionDigits(), getLocalCurrencyRoundingMode());

        _hardwareMgr.getCustDisplay().setAmountDue(dftAmtDue);

        return dftAmtDue;
    }

    /**
     * Get the default value for entering a tender.
     *
     * @param argTender the tender for which the user is entering an amount
     * @param argMaxAllowed the maximum allowed amount
     * @return the default amount
     */
    
    //BEGIN BZ61330
    protected BigDecimal getDefaultValue(ITender argTender,
            BigDecimal argMaxAllowed) {
        if(argTender.getTenderId().equalsIgnoreCase(CawConstants.THIRD_PARTY)
                || argTender.getTenderId().equalsIgnoreCase(CawConstants.AR_ACCOUNT)) {
            if(BigDecimal.ZERO.compareTo(this._transactionScope.getTransaction().getAmountDue()) > 0) {
                return getMaxAmountForDefaultValue(argTender.getTenderId());
            }
        }
        return argMaxAllowed;
    }
    
    public BigDecimal getMaxAmountForDefaultValue(String argTender) {
        BigDecimal maxAmount = BigDecimal.ZERO;
        List<IRetailTransaction> origTrans = _returnMgr.getAllOrigTransaction();
        if (null != origTrans && !(origTrans.isEmpty())) {
            for (IRetailTransaction retailTrans : origTrans) {
                List<IRetailTransactionLineItem> origTenderLineList = retailTrans.getTenderLineItems();
                for (IRetailTransactionLineItem origTransLineItem : origTenderLineList) {
                    if (origTransLineItem instanceof TenderLineItemModel && !origTransLineItem.getVoid()) {
                        TenderLineItemModel origTenderLine = (TenderLineItemModel) origTransLineItem;
                        if(origTenderLine.getTenderId().equalsIgnoreCase(argTender)) {
                            maxAmount = maxAmount.add(origTenderLine.getAmount());
                        }
                    }
                }
            }
        }
        return maxAmount;
    }
    //END BZ61330
    
    /** {@inheritDoc} */
    @Override
    protected IFormattable[] getPromptArgs(IXstEvent argEvent) {

        ITenderLineItem tenderLine = getScopedValue(ValueKeys.CURRENT_TENDER_LINE);
        ITender tender = tenderLine.getTender();
        String description = tender.getDescription();
        return new IFormattable[] { _ff.getSimpleFormattable(description) };
    }

    /**
     * Return the valid BigDecimal value from the current event data entered by the user.
     *
     * @param argEvent the current event
     * @return the valid BigDecimal value for the data the user entered.
     */
    protected BigDecimal getTenderAmount(IXstEvent argEvent) {

        if ((argEvent != null) && (argEvent.getData() != null)) {
            BigDecimal tenderAmount = NumberUtils.ZERO;

            if (argEvent.getData() instanceof BigDecimal) {
                tenderAmount = (BigDecimal) argEvent.getData();
            }

            tenderAmount = _commonHelper.roundCurrency(tenderAmount);
            return tenderAmount;
        }

        return null;
    }

    /**
     * Gets the tender amount data.
     *
     * @param argEvent the event
     * @return the tender amount data
     */
    protected TenderAmountData getTenderAmountData(IXstEvent argEvent) {

        ITenderLineItem tenderLine = getScopedValue(ValueKeys.CURRENT_TENDER_LINE);
        IPosTransaction transaction = _transactionScope.getTransaction();

        if (ConfigurationMgr.isBINSmartLookupEnabled()
                && (tenderLine.getTender() == null)) {
            tenderLine.setTender(_tenderHelper
                    .getTender(TenderConstants.DEBIT_CARD, null));
        }

        BigDecimal enteredAmount = getTenderAmount(argEvent);
        BigDecimal tenderedAmt = _tenderHelper
                .getTotalForTender(tenderLine.getTender(), transaction);
        BigDecimal amountDue = getAmountDue(transaction);
        TenderAmountData amountData = new TenderAmountData(enteredAmount,
                tenderedAmt, amountDue);
        return amountData;
    }

    /** {@inheritDoc} */
    @Override
    protected IOpResponse handlePromptEvent(IXstEvent argEvent) {

        TenderAmountData amountData = getTenderAmountData(argEvent);
        setScopedValue(ValueKeys.CURRENT_TENDER_AMOUNT_DATA, amountData);
        return super.handlePromptEvent(argEvent);
    }

    /**
     * A custom variant of IconRefConfig, used by this Op, which uses IconUtils for image acquisition. The
     * parent config which uses this object is generated programmatically, and is otherwise incapable of taking
     * advantage of it. <br>
     * <br>
     *
     * @author mkosem
     * @created Oct 21, 2015
     * @version $Revision: 320971 $
     */
    private class VolatileIconRefConfig extends IconRefConfig {

        private static final long serialVersionUID = 1L;

        @Override
        protected ImageIcon acquireIcon(String argIconPath) {

            return IconUtils.getVolatileComponentImageIcon(argIconPath);
        }
    }
}
