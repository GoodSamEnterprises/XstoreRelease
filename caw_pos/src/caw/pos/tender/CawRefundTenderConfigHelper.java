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
 * BZ27922          011118    [New Requirement] Make all tender changes configurable
 * BZ33089          251019    [5.0 UAT] Return with receipt a transaction with a Check Tender didn't have mail refund as an option.
 * BZ33090          241219    [5.0 UAT] Disable Cash refund on the verified return transaction unless the original transaction has Cash
 *===================================================================
 */

package caw.pos.tender;

import java.math.BigDecimal;
import java.util.List;
import java.util.Locale;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.collections.CollectionUtils;

import caw.pos.common.CawConstants;

import dtv.pos.common.ConfigurationMgr;
import dtv.pos.register.returns.ReturnType;
import dtv.util.NumberUtils;

import dtv.util.config.ConfigHelper;
import dtv.xst.dao.com.CodeLocator;
import dtv.xst.dao.tnd.ITender;
import dtv.xst.dao.tnd.TenderStatus;
import dtv.xst.dao.trl.IRetailTransaction;
import dtv.xst.dao.trl.ISaleReturnLineItem;
import dtv.xst.dao.ttr.ITenderLineItem;

/**
 *
 */
public class CawRefundTenderConfigHelper
        extends ConfigHelper<CawRefundTenderSetConfig> {

    private static volatile CawRefundTenderConfigHelper instance = null;

    /* Get RefundTenderConfig.xml.
     * @see dtv.util.config.ConfigHelper#getConfigFileName()
     */
    @Override
    protected String getConfigFileName() {

        return CawConstants.REFUND_TENDER_CONFIG;
    }

    /**
     * 
     * @return
     */
    public static CawRefundTenderConfigHelper getInstance() {

        if (instance == null) {
            synchronized (CawRefundTenderConfigHelper.class) {
                if (instance == null) {
                    instance = new CawRefundTenderConfigHelper();
                }
            }
        }
        return instance;
    }

    /**
     * 
     */
    public CawRefundTenderConfigHelper() {

        initialize();
    }

    /**
     * Get specific config from RefundTenderConfig.xml
     * @param argConfigName
     * @return
     */
    public CawRefundTenderConfig getConfig(String argConfigName) {

        return getRootConfig().getConfig(argConfigName);
    }

    /**
     * Get all config from RefundTenderConfig.xml
     * @return
     */
    public List<CawRefundTenderConfig> getAllConfig() {

        List<CawRefundTenderConfig> allConfig = getRootConfig().getAllConfigs();
        return allConfig;
    }

    /**
     * 
     * @param currentTrans
     * @return
     */
    public boolean isUnverifiedReturn(IRetailTransaction currentTrans) {

        boolean hasUnverified = false;

        for (ISaleReturnLineItem saleLine : currentTrans
                .getLineItems(ISaleReturnLineItem.class)) {
            if ((saleLine.getReturn()) && (!saleLine.getVoid())) {
                if (ReturnType.UNVERIFIED
                        .matches(saleLine.getReturnTypeCode())) {
                    hasUnverified = true;
                    break;
                }
            }
        }
        return hasUnverified;
    }

    /**
     * 
     * @param currentTrans
     * @return
     */
    public boolean isBlindReturn(IRetailTransaction currentTrans) {

        boolean hasBlind = false;

        for (ISaleReturnLineItem saleLine : currentTrans
                .getLineItems(ISaleReturnLineItem.class)) {
            if ((saleLine.getReturn()) && (!saleLine.getVoid())) {
                if (ReturnType.BLIND.matches(saleLine.getReturnTypeCode())) {
                    hasBlind = true;
                    break;
                }
            }
        }
        return hasBlind;
    }

    /**
     * This method will return the return type follow priority
     * 1: return web order
     * 2: blind return
     * 3: unverified return
     * 4: verified return
     * @param currentTrans
     * @param lineItemsWebReturn
     * @return
     */
    public String returnType(IRetailTransaction currentTrans,
            List<ISaleReturnLineItem> lineItemsWebReturn) {

        String returnType = "";
        boolean hasWebOrder = false;
        boolean hasBlind = false;
        boolean hasUnverified = false;
        boolean hasVerified = false;
        List<ISaleReturnLineItem> listItems = currentTrans
                .getLineItems(ISaleReturnLineItem.class);

        for (ISaleReturnLineItem saleLine : listItems) {
            if ((saleLine.getReturn()) && (!saleLine.getVoid())) {
                //1: Check web order
                if ((lineItemsWebReturn != null)
                        && (!lineItemsWebReturn.isEmpty())
                        && (lineItemsWebReturn.contains(saleLine))) {
                    hasWebOrder = true;
                }
                //2: Check blind return
                else if (ReturnType.BLIND
                        .matches(saleLine.getReturnTypeCode())) {
                    hasBlind = true;
                }
                //3: Check unverified return
                else if (ReturnType.UNVERIFIED
                        .matches(saleLine.getReturnTypeCode())) {
                    hasUnverified = true;
                }
                //4: Check verified return
                else if (ReturnType.VERIFIED
                        .matches(saleLine.getReturnTypeCode())) {
                    hasVerified = true;
                }
            }
        }

        /*
         * 1: return web order
         * 2: blind return
         * 3: unverified return
         * 4: verified return
         */
        if (hasWebOrder) {
            returnType = CawConstants.RETURN_WEB_ORDER;
        } else if (hasBlind) {
            returnType = ReturnType.BLIND.toString();
        } else if (hasUnverified) {
            returnType = ReturnType.UNVERIFIED.toString();
        } else if (hasVerified) {
            returnType = ReturnType.VERIFIED.toString();
        }

        return returnType;
    }

    /**
     * 
     * @param tenderId
     * @return
     */
    public boolean isEnableForReturn(String tenderId, String availableCode,
            List<ITender> tenders) {

        boolean isEnable = false;

        if (tenderId != null && tenders != null && tenders.size() > 0) {
            ITender iTender = null;

            for (ITender iTenderTemp : tenders) {
                if (tenderId.equalsIgnoreCase(iTenderTemp.getTenderId())) {
                    iTender = iTenderTemp;
                    break;
                }
            }

            if (iTender != null && iTender.containsAvailCode(availableCode)) {
                isEnable = true;
            }
        }
        return isEnable;
    }

    /**
     * 
     * @param tenderID
     * @param config
     * @param origTransList
     * @return
     */
    /*BEGIN BZ33089*/
    public boolean isAvailable(String tenderID, CawRefundTenderConfig config, List<IRetailTransaction> origTransList,
            BigDecimal amt) {

        boolean contain = false;
        //Tender list from orginal transaction
        List<ITenderLineItem> listTender = null;
        ITender tender = null;
        //Check original tender option

        for (IRetailTransaction origTrans : origTransList) {
            listTender = origTrans.getLineItems(ITenderLineItem.class);

            if (listTender != null && !listTender.isEmpty()) {
                for (ITenderLineItem tenderLine : listTender) {
                    //CREDIT/DEBIT
                    /*BEGIN BZ33090*/
                    if (TenderStatus.TENDER.matches(tenderLine.getTenderStatusCode())) {
                    if (CawTenderConstants.CREDIT_CARD.equalsIgnoreCase(tenderID)) {
                        tender = tenderLine.getTender();
                        if ((!tenderLine.getVoid()) && (tender != null)
                                && (config.getOriginalTenderId().contains(tender.getTenderTypecode()))) {
                            contain = true;
                        }
                    }
                    //OTHER TENDER TYPES
                        if ((!tenderLine.getVoid())
                                && (config.getOriginalTenderId().contains(tenderLine.getTenderId()))) {
                        if (isHigherReqAmtWithOrig(tenderLine.getTenderId(), amt, config)) { /*BZ33089*/
                            contain = true;
                        }
                    }
                }
                    /*END BZ33090*/
            }
        }
        }
        return contain;
    }

    /**
     * 
     * @param origTenderId
     * @param amt
     * @param config
     * @return
     */
    public boolean isHigherReqAmtWithOrig(String origTenderId, BigDecimal amt, CawRefundTenderConfig config) {

        boolean isHigher = false;
        String configName = "";

        if (CawTenderConstants.USD_CURRENCY.equals(origTenderId)) {
            configName = CawTenderConstants.MIN_CASH_AMOUNT_WITH_ORIGINAL;
        } else if (CawTenderConstants.CHECK.equals(origTenderId)
                || CawTenderConstants.USD_TRAVELERS_CHECK.equals(origTenderId)) {
            configName = CawTenderConstants.MIN_CHECK_AMOUNT_WITH_ORIGINAL;
        } else if (CawTenderConstants.AR_ACCOUNT.equals(origTenderId)) {
            configName = CawTenderConstants.MIN_AR_AMOUNT_WITH_ORIGINAL;
        }
        //Retrieve configurations from COM_CODE_VALUE 
        if (StringUtils.isNotEmpty(configName)) {
            List<String> values = CodeLocator.getCodes(ConfigurationMgr.getOrganizationId(), configName);
            String value = "";

            if (CollectionUtils.isNotEmpty(values)) {
                value = values.get(0);
            }
            BigDecimal configAmt = NumberUtils.toBigDecimal(value, Locale.US);
            isHigher = (amt.abs().compareTo(configAmt) >= 0);
        } else {
            isHigher = (amt.abs().compareTo(config.getMinAmountWithOriginalTrans()) >= 0);
        }
        return isHigher;
    }
    /*END BZ33089*/
}
