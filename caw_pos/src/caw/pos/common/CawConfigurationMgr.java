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
 * BZ23147          070917    Implement Serialized coupon
 * BZ23339          180917    Implement Gift card Authorization
 * BZ26270          060718    New Requirement - Display UPC on both Xstore screens and on receipts
 * BZ27208          160818    [Updated Requirement] Update Work Order Deposit Minimum to one cent (0.01) instead of zero (0.00)
 * BZ27670          210918    [Prod] Options to auto unlock users/Display actual reason for failed log in attempts in Xstore
 * BZ30922          210619    [New Requirement] Price Check and Inventory Lookup
 *===================================================================
 */

package caw.pos.common;

import java.math.BigDecimal;

import dtv.pos.common.ConfigurationMgr;
import dtv.pos.common.IConfigurationMgr;

/**
 * Define parameters in SystemConfig.xml
 */
public class CawConfigurationMgr extends ConfigurationMgr {

    public static boolean allowCouponTenderIssueAnotherCard() {

        return getHelper()
                .getBoolean(new String[] { "Store", "SystemConfig", "Tender", "AllowCouponTenderIssueAnotherCard" });
    }

    public static BigDecimal maximumGiftCardBalance() {

        return getHelper()
                .getBigDecimal(new String[] { "Store", "SystemConfig", "GiftCard", "MaximumGiftCardBalance" });
    }

    public static BigDecimal maximumTenderExchangeBalance() {

        return getHelper()
                .getBigDecimal(new String[] { "Store", "SystemConfig", "GiftCard", "MaximumTenderExchangeBalance" });
    }

    /**
     * BZ26270 Added 
     * @return
     */
    public static boolean displayUpcLineOnReceipt() {
        return getHelper()
                .getBoolean(new String[] { "Store", "SystemConfig", "Transaction", "DisplayUPCLine" });
    }

    /**
     * Gets the max number of result..
     *
     * @return the max number of result
     */
    public static String getMaxNumberOfResults() {

        return ConfigurationMgr.getHelper()
                .getString(new String[] { IConfigurationMgr.STORE_TAG, IConfigurationMgr.SYSTEM_CONFIG_TAG, "WorkOrder", "MaxNumberOfResults" });
    }

    // Begin BZ27208
    /**
     * Get the minimum deposit amount.
     * 
     * @return
     */
    public static BigDecimal getMinimumDepositAmount() {

        return ConfigurationMgr.getHelper()
                .getBigDecimal(new String[] { IConfigurationMgr.STORE_TAG, IConfigurationMgr.SYSTEM_CONFIG_TAG, "WorkOrder", "MinimumDepositAmount" });
    }

    // End BZ27208
    // BZ27670 start
    /**
     * Get the minimum deposit amount.
     * 
     * @return
     */
    public static int getLapseTimeBeforeUnlockingUser() {

        return ConfigurationMgr.getHelper()
                .getInt(new String[] { IConfigurationMgr.STORE_TAG, IConfigurationMgr.SYSTEM_CONFIG_TAG, "LoginSecurity", "LapseTimeBeforeUnlockingUser" });
    }
    // BZ27670 end
    /*BEGIN BZ30922*/
    public static boolean isProximitySearch() {
        return ConfigurationMgr.getHelper().getBoolean(new String[] { IConfigurationMgr.STORE_TAG, IConfigurationMgr.SYSTEM_CONFIG_TAG, "InventoryLookup", "IsProximitySearch" });
    }
    /*END BZ30922*/
}
