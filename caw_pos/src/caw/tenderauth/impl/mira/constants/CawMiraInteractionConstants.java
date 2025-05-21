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
 * Req/Bug ID#          ddMMyy    Description
 * BZ23164              100917    [DEV] Implement EMV Payment Integration
 *== ================================================================
 */

package caw.tenderauth.impl.mira.constants;

/**
 * The interface CawMiraInteractionConstants
 *
 */
public class CawMiraInteractionConstants {

    public static enum ResponseCode {
        Active, AlreadyActive, Approved, ApprovedFloorLimit, ApprovedNotEcheck, ApprovedReferral, ApprovedSplitTender, ApprovedZeroAmount, CallCenter, CARD_NUM_ERROR, CheckVelocity, ConfigurationError, Deactive, DECLINED, DEVICE_TIME_OUT, Duplicate, ErrorOrRetry, Expended, Expired, FirstTimeUsage, FloorLimit, HoldCall, InquiryForTenderFailed, USER_CANCEL, InquiryForTenderSucceeded, Inactive, Invalid, InvalidCredentials, InvalidMerchCall, InvalidPIN, InvalidTransaction, MaxPINTryDecline, NoMoreLoadsAllowed, NotFound, OFFLINE, OFFLINE_CANT_PROCESS_TYPE, OFFLINE_RETURN, PartialApproval, PositiveIDRequired, VOICE_APPROVAL, Reload, RequestNotSupported, Success, TerminalIdError, TIMEOUT, Undefined, Unknown, ERROR_NOT_SUPPORT, FIELD_INVALID, DEVICE_IS_BUSY, Voided;
    };

    /**
     * Send SendRequestType
     */
    public static enum SendRequestType {
        /**
         * Send request immediately
         */
        ONE_THREAD,
        /**
         * Wait for process
         */
        MULTI_THREAD
    }
}