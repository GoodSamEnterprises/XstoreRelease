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
 * BZ26207          190718    New Requirement - Enable Work Order Functionalitys
 * BZ27208          160818    [Updated Requirement] Update Work Order Deposit Minimum to one cent (0.01) instead of zero (0.00)
 * BZ27192          160818    WO Obtain the item details (price, tax, description,...) and work order total from Neuron
 * BZ27253          170818    [WO] Some warranty items has been changed to non-warranty items
 * BZ27243          170818    Work Order Deposit shows double the deposit amount when the first tender is declined
 * BZ27246          200818    Unlocking WO from S&I causes Work Order Offline screen to display when you attempt to select Work Order Complete in Xstore
 * BZ27286          210818    Work Order Deposit - Discount for Elite Customer not coming from S&I 
 * BZ53752          221122    [BTM-255] - Wrong ItemCorrelationKey is being set in OrginalCorrelationKey attribute on returned items in SubmitOrder Request
 *===================================================================
 */

package caw.pos.workorder.common;

import caw.pos.common.CawJSONConstant;

/**
 * All constants relate to work order is here.
 */
public class CawWorkOrderConstants extends CawJSONConstant {

    public static final String WORK_ORDER                              = "WORK_ORDER";

    public static final String OK                                      = "OK";

    public static final String UNAVAILABLE                             = "UNAVAILABLE";

    public static final String DEPOSIT                                 = "Deposit";

    public static final String OPEN                                    = "Open";

    public static final String LOCKED                                  = "Locked";

    public static final String COMPLETE                                = "Complete";

    public static final String CANCELED                                = "Canceled";

    public static final String EBS                                     = "EBS";

    public static final String WO_PREFIX                               = "WO:";

    public static final String DATE_TIME_FORMAT                        = "MM/dd/yyyy hh:mm:ss aa";

    public static final String NON_PHYSICAL                            = "NON_PHYSICAL";

    public static final String ACTUAL                                  = "ACTUAL";

    public static final String TASK                                    = "TASK";

    public static final String CAW_WORK_ORDER_ERROR                    = "CAW_WORK_ORDER_ERROR";

    public static final String DEFAULT_CATEGORY                        = "CWO_CAT_DEF";

    public static final String DEFAULT_PRICE_CODE                      = "CWO_PRICE_CODE_DEF";

    public static final String DEFAULT_SERVICE_LOC                     = "CWO_SERVICE_LOC_DEF";

    // Begin BZ26945
    public static final String CAW_WORK_ORDER_MISSING_ITEM             = "_cawWorkOrderMissingItem";

    public static final String CAW_WORK_ORDER_MISSING_ITEM_MESSAGE     = "_cawWorkOrderMissingItemMessage";

    public static final String CAW_WORK_ORDER_ITEM_NOT_ON_FILE         = "_cawWorkOrderItemNotFile";

    public static final String CAW_WORK_ORDER_ITEM_NOT_ON_FILE_MESSAGE = "_cawWorkOrderItemNotFileMessage";
    // End BZ26945

    // Begin BZ26945
    public static final String CAW_WORK_ORDER_CROSS_STORE              = "_cawWorkOrderCrossStore";

    public static final String CAW_WORK_ORDER_CROSS_STORE_MESSAGE      = "_cawWorkOrderCrossStoreMessage";
    // End BZ26945

    // Begin BZ27208
    public static final String CAW_WORK_ORDER_MIN_DEPOSIT              = "_woMinDepositAmount";

    public static final String CAW_WORK_ORDER_MAX_DEPOSIT              = "_cawCustAcctDepositValidateMaxMsg";
    // End BZ27208

    public static final String CAW_WORK_ORDER_CROSS_STORE_PROMPT       = "CAW_WORK_ORDER_CROSS_STORE";                    //BZ27051

    // Begin BZ27192
    public static final String ENTRY_METHOD_CODE                       = "AUTOMATIC";

    public static final String SALE_RETURN_LINE_ITEM_TYPE_CODE         = "WORK_ORDER";

    public static final String DEPOSIT_MOCKUP_ITEM_NAME                = "Work Order Deposit";

    public static final String MERCH_LEVEL_1                           = "NP";

    public static final String ITEM_DEFAULT_VALUE                      = "*";

    public static final String DEPOSIT_MOCKUP_ITEM_ID                  = "WORK ORDER";

    // End BZ27192

    // BEGIN BZ27253
    public static final String WARRANTY_TYPCODE                        = "WARRANTY";
    //END BZ27253

    // BEGIN BZ27243
    public static final String DEPOSIT_TYPE_CODE                       = "DEPOSIT";
    // END BZ27243

    // Begin BZ27246
    public static final String CAW_WORK_ORDER_HAS_DEPOSIT              = "_cawWorkOrderHasDeposit";

    public static final String CAW_WORK_ORDER_HAS_DEPOSIT_MSG          = "_cawWorkOrderHasDepositMsg";
    // End BZ27246

    public static final String CAW_ITEM_AMT_PROMPT                     = "ITEM_AMT_PROMPT";

    public static final String LOCAL_CURRENCY                          = "LOCAL_CURRENCY";

    public static final String DTV_CLASS_NAME                          = "dtv.xst.dao.ttr.impl.CreditDebitTenderLineItem";

    public static final String HOME_OFFICE_CHECK                       = "HOME_OFFICE_CHECK";

    public static final String WARRANTY_STATUS                         = "WARRANTY_STATUS";

    public static final String SELECTED                                = "Selected";
    
    public static final int WO_COMPLETE_CODE                           = 8;//BZ53752
}
