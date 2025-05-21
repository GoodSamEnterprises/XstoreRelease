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
 * BZ23339          210917    [DEV] Implement Gift card authorization
 * BZ23339          260917    [DEV] Implement Gift card authorization
 * BZ23559          091017    Gift Card Tender Exchange transaction receipt does not meet CW requirements
 * BZ24582          221117    Need to specify the unique terminal Station ID in the MiraServ requests
 * BZ25958          010818    New Requirement - Gift Card User Flow and Receipt Changes
 * BZ27629          210918    [PROD] Update Order Service to send Gift Card item as GC RELOAD in Tender Exchange
 *===================================================================
 */

package caw.pos.common;

import java.util.HashMap;
import java.util.Map;

import caw.payment.verifone.CawEmvPaymentCardInfo;

/**
 *
 */
public class CawVoucherValue {

    public static String                               VOUCHER_TRACE_NUMBER         = "";

    public static String                               VOUCHER_CARD_NUMBER          = "";

    public static boolean                              IS_MANUAL_INPUT_CREDIT       = false;

    private static Map<Integer, CawEmvPaymentCardInfo> emvInfo                      = new HashMap<Integer, CawEmvPaymentCardInfo>(); // BZ23559

    /*BZ 24582 */
    private static String                              MIRA_STATION_ID              = "";

    // Begin BZ25958
    public static String                               GIFT_CARD_TOKEN              = "";

    public static String                               FROM_REG_OPTION              = "FROM_REG_OPTION";
    // End BZ25958

    /*BZ27629 added */
    public static boolean                              IS_TENDER_EXCHANGE_AUTHORIZE = false;

    /*Begin BZ28562 added
     * The Pinpad is overlap screen when we use the gift card or credit. 
     * Therefore we have declared an IS_USE_CREDIT_GIFT_FLAG to mark that we will clear Pinpad and the items add again. 
     *  */
    public static boolean                              IS_USE_CREDIT_GIFT_FLAG      = false;
    /*End BZ28562 added */

    /**
     * @return the vOUCHER_TRACE_NUMBER
     */
    public static String getVOUCHER_TRACE_NUMBER() {

        return VOUCHER_TRACE_NUMBER;
    }

    /**
     * @param argVOUCHER_TRACE_NUMBER the vOUCHER_TRACE_NUMBER to set
     */
    public static void setVOUCHER_TRACE_NUMBER(String argVOUCHER_TRACE_NUMBER) {

        VOUCHER_TRACE_NUMBER = argVOUCHER_TRACE_NUMBER;
    }

    /**
     * @return the vOUCHER_CARD_NUMBER
     */
    public static String getVOUCHER_CARD_NUMBER() {

        return VOUCHER_CARD_NUMBER;
    }

    /**
     * @param argVOUCHER_CARD_NUMBER the vOUCHER_CARD_NUMBER to set
     */
    public static void setVOUCHER_CARD_NUMBER(String argVOUCHER_CARD_NUMBER) {

        VOUCHER_CARD_NUMBER = argVOUCHER_CARD_NUMBER;
    }

    /**
     * @return the iS_MANUAL_INPUT_CREDIT
     */
    public static boolean getIS_MANUAL_INPUT_CREDIT() {

        return IS_MANUAL_INPUT_CREDIT;
    }

    /**
     * @param argIS_MANUAL_INPUT_CREDIT the iS_MANUAL_INPUT_CREDIT to set
     */
    public static void setIS_MANUAL_INPUT_CREDIT(
            Boolean argIS_MANUAL_INPUT_CREDIT) {

        IS_MANUAL_INPUT_CREDIT = argIS_MANUAL_INPUT_CREDIT;
    }

    /**
     * @return the emvInfo
     */
    public static Map<Integer, CawEmvPaymentCardInfo> getEmvInfo() {

        return emvInfo;
    }

    /**
     * @param argEmvInfo the emvInfo to set
     */
    public static void setEmvInfo(
            Map<Integer, CawEmvPaymentCardInfo> argEmvInfo) {

        emvInfo = argEmvInfo;
    }

    /**
     * BZ 24582
     * @return the mIRA_STATION_ID
     */
    public static String getMiraStationID() {

        return MIRA_STATION_ID;
    }

    /**
     * BZ 24582
     * @param argMIRA_STATION_ID the mIRA_STATION_ID to set
     */
    public static void setMiraStationID(String argMiraStationID) {

        MIRA_STATION_ID = argMiraStationID;
    }

    /**
     * BZ25958
     * @param argMIRA_STATION_ID the mIRA_STATION_ID to set
     */
    public static void setGiftCardToken(String token) {

        GIFT_CARD_TOKEN = token;
    }

    /**
     * BZ27629 added
     * @param isTenderExchange
     */
    public static void setIsTenderExchange(boolean isTenderExchange) {

        IS_TENDER_EXCHANGE_AUTHORIZE = isTenderExchange;
    }

}
