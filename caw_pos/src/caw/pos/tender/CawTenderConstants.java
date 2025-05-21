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
 * BZ24071          181017    Refund Check is unavailable at Refund tender option 
 *                            when performing return transaction for Cash and Check tender
 * BZ27023          060818    [1.6.2] WO - Xstore doesn't retrieve existing tokens for credit tenders when doing WO Cancel transaction
 * BZ27035          060818    Work Order Refund Tender Option Issue
 * BZ27036          060818    Work Order Complete tender options isssue
 * BZ27812          191018    [New Requirement] Add cash as a tender option for Web Orders
 * BZ27922          011118    [New Requirement] Make all tender changes configurable
 * BZ29387          140219    [Internal] Xstore Sale screen with Good Sam Payment Item does not match requirements.
 * BZ33089          251019    [5.0 UAT] Return with receipt a transaction with a Check Tender didn't have mail refund as an option.
 * BZ44971          150921    [New Requirement] IDS Payment Integration with Xstore
 *===================================================================
 */

package caw.pos.tender;

import dtv.pos.tender.TenderConstants;

/**
 * The tender type.
 */
public interface CawTenderConstants extends TenderConstants {

    /** The Constant USD_CURRENCY. */
    public static final String USD_CURRENCY        = "USD_CURRENCY";

    /** The Constant CHECK. */
    public static final String CHECK               = "CHECK";

    /** The Constant USD_TRAVELERS_CHECK. */
    public static final String USD_TRAVELERS_CHECK = "USD_TRAVELERS_CHECK";

    /** The Constant AR_ACCOUNT. */
    public static final String AR_ACCOUNT          = "AR_ACCOUNT";

    /** The Constant CREDIT_CARD. */
    public static final String CREDIT_CARD         = "CREDIT_CARD";        //BZ27023, BZ27035, BZ27036

    public static final String RETURN_WEB_ORDER    = "RETURN_WEB_ORDER";   //BZ27812

    public static final String RETURN_UNVERIFIED   = "RETURN_UNVERIFIED";  //BZ27922

    public static final String ACCOUNT_PAYMENT     = "ACCOUNT_PAYMENT";    //BZ27922, BZ29387

    /*BEGIN BZ33089*/
    public static final String MIN_AR_AMOUNT_WITH_ORIGINAL    = "MIN_AR_AMOUNT_WITH_ORIGINAL";

    public static final String MIN_CHECK_AMOUNT_WITH_ORIGINAL = "MIN_CHECK_AMOUNT_WITH_ORIGINAL";

    public static final String MIN_CASH_AMOUNT_WITH_ORIGINAL  = "MIN_CASH_AMOUNT_WITH_ORIGINAL";
    /*END BZ33089*/
    
    /* BEGIN BZ44971 */
    public static final String COUPON_TENDER_ID               = "COUPON";

    public static final String MALL_CERTIFICATE_TENDER_ID     = "MALL_CERTIFICATE";

    public static final String THIRD_PARTY_TENDER_ID          = "THIRD_PARTY";
    
    public static final String AR_ACCOUNT_TENDER_ID           = "AR_ACCOUNT";
    /* END BZ44971 */
}
