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
 * BZ23359          270917    Gift cards can't be swiped at screen
 * BZ23359          041017    Gift cards can't be swiped at screen
 * BZ23629          051017    [Xstore] Help Desk Error after submitting ADD COMMENT screen during receipt return
 * BZ23629          051017    [Xstore] Help Desk Error after submitting ADD COMMENT screen during receipt return
 * BZ23978          121017    send ClearSecureEntry transaction type after complete the 
 *                            prescreen/instant credit application
 * BZ23947          121017    [Certification] For instant credit, real time and batch prescreen, 
 *                            birthday format on the pin pad prompt
 * BZ24110          130418    Multiple brand name forXstore
 * BZ25602          110418    [PROD]New Requirement - Add "echo data" to all MiraServ payment transactions
 * BZ26368          110418    Initialize the pin pad to process EMV/Chip and PIN transaction
 * BZ27757          100918    [UAT] Selling a gift card from the Non-Merch menu is significantly slow
 * BZ26858          101118    [PROD] Register suspends transaction involuntarily and charges customer multiple times
 * BZ27933          301018    [26858]Void request of return trans doesn't send to Mira when Register suspends transaction involuntarily
 * BZ27344          301018    Pin Pad Performance is slow when item price is updated by a deal/promo or a manual price adjustment
 * BZ28407          281118    [Internal] PINPAD doesn't show full items when item has quantity >1
 * BZ27875          151018    [PROD] Register suspends transaction involuntarily and charges customer double times once tendering with GC
 * BZ28403          071218    [Internal] Tax amount is not rounding to 2 digits for the decimal on PINPAD.
 * BZ25761          121018    New Requirement - Acquisition of Private Label Credit Card integration in Xstore
 * BZ25762          121418    New Requirement - Credit Account Look up integration in Xstore
 * BZ28743          211218    [PLCC] Allow to enter SSN greater than 10 digits number on PINPAD
 * BZ28738          201218    [PLCC] PINPAD and Xstore display inconsistency once selecting 'NO' on Customer & Confirmation screen
 * BZ28735          211218    [27875] Void request of return trans doesn't send to Mira when Register suspends transaction involuntarily
 * BZ27973          140119    New Requirement - PLCC Account Payment
 * BZ28546          310119    Send item data to CC Auth Request for ADS Settlement
 * BZ29313          120219    [Internal] Xstore sending the incorrect trancode to clear secure entry on pinpad.
 * BZ29314          120219    [Internal] Add CustomerType field to the Prescreen Acceptance request
 * BZ29290          130119    [Internal] Email address is cut off on the IS YOUR INFORMATION CORRECT? form
 * BZ29280          130219    [Internal] [28247] Need to re-format caretaker template to meet the changes in Card Service 2
 * BZ29379          140219    [Internal] Xstore should display the actual response provided by Eigen MiraServ once returning an unsuccessful GS Account Payment inquiry response
 * BZ29399          140219    [Internal] Missing content text on Pin Pad Pre-Approved Form for PLCC once doing prescreen trans.
 * BZ29360          150219    [Internal][Account Lookup] Cannot retrieve account token to tender after Account Lookup found successfully
 * BZ29406          180219    [New Requirement] Xstore must send TC70 Payment Request to Eigen for the account payment transaction
 * BZ29455          200219    Account Payment we receive 741 invalid Amount
 * BZ29478          210219    [EXTERNAL] PLCC Acquisition Changes from Client
 * BZ29535          260219    [Internal] Good Sam Account Inquiry Screen/Form does not display amounts and due date.
 * BZ29601          010319    [EXTERNAL] [PLCC] Compliance feedback: Instant Credit Pin Pad Confirmation Screen
 * BZ29704          120319    [PLCC Cert] Xstore displays the incorrect message for instant credit timeout
 * BZ32046          230719    [New Requirement] Ability to change text Welcome screen on Pin Pad
 * BZ37207          260820    Pinpad verification - Email length modification
 * BZ37382          270820    [Requirement] Signature capturing for Order Creation/Pickup transaction
 * BZ41674          050321    ADS Settlement - ORIG_INVOICE_NO on the return needs to match the INVOICE_NO of the purchase.
 * BZ45156          030821    [PROD] Update Miraserv auth request to include recurring payment indicator
 * BZ46300          060121    [New Requirement] Settlement Request for New Payment Type
 * BZ57844          040823    Bug 57844 - [Task] Loyalty Phase 2.
 *===================================================================
 */

package caw.tenderauth.impl.eigen.constants;

import java.math.BigDecimal;
import java.math.BigInteger;

import caw.pos.common.CawConfigurationMgr;

public abstract interface CawEigenConstants {
    /*Begin BZ 37382 */
    static final String     PINPAD_ODER_PICKUP_TRAINSACTION       = "ORDER PICKUP";

    static final String     PINPAD_ODER_CREATE_TRAINSACTION       = "ORDER CREATE";

    static final String     TRANS_CODE_ITM_DISP_TYPE              = "65";

    static final String     TRANS_ODER_STATUS_TRAINSACTION        = "READY_FOR_PICK_UP";

    static final String     FIELD_LF                              = "LF";

    static final String     FIELD_CLEAR                           = "CLEAR";

    static final String     FIELD_ACCEPT                          = "ACCEPT";
    /*End BZ 37382*/

    static final String     FN_ACCOUNT_TYPE                       = "AY";

    static final String     FN_ACTION_CODE                        = "AB";

    static final String     FN_ACS_URL                            = "UR";

    static final String     FN_ADDRESS_LINE_1                     = "D1";

    static final String     FN_ADDRESS_LINE_2                     = "D2";

    static final String     FN_ADDRESS_LINE_3                     = "D3";

    static final String     FN_AMOUNT_0                           = "A0";

    static final String     FN_AMOUNT_1                           = "A1";

    static final String     FN_AMOUNT_2                           = "A2";

    static final String     FN_APPROVAL_CD                        = "AC";

    static final String     FN_APPROVE_AMOUNT                     = "AM";

    static final String     FN_AUX_RESPONSE_CODE                  = "AR";

    static final String     FN_AVS_RESPONSE_CODE                  = "VR";

    static final String     FN_AVS_RESPONSE_MESSAGE               = "VM";

    static final String     FN_ACCOUNT_BALANCE                    = "B1";

    static final String     FN_ACCOUNT_BALANCE_2                  = "B2";

    static final String     FN_BANK_ACCOUNT_NUMBER                = "BZ";

    static final String     FN_BANK_CHEQ_NUMBER                   = "BC";

    static final String     FN_BANK_ROUTING_NUMBER                = "BR";

    static final String     FN_C_AMOUNT_ADJ                       = "AA";

    static final String     FN_C_AMOUNT_CREDIT                    = "CR";

    static final String     FN_C_AMOUNT_DEBIT                     = "AD";

    static final String     FN_C_NUM_ADJ                          = "NA";

    static final String     FN_NUM_CREDIT                         = "NC";

    static final String     FN_CARD_DESC                          = "CD";

    static final String     FN_CARD_HOLDER_NAME                   = "HN";

    static final String     FN_CARD_TYPE                          = "AT";

    static final String     FN_CASH_BACK_AMOUNT                   = "CK";

    static final String     FN_CASH_BACK_FLAG                     = "CB";

    static final String     FN_CHIP_APPLICATION_ID                = "A8";

    static final String     FN_CHIP_APPLICATION_NAME              = "AN";

    static final String     FN_COMP_SEQ_NUMBER                    = "CM";

    static final String     FN_COUNTRY                            = "CO";

    static final String     FN_COUNTRY_CODE                       = "CC";

    static final String     FN_CURRENCY                           = "CY";

    static final String     FN_CUST_RECEIPT_LANG                  = "CL";

    static final String     FN_CUST_RECEIPT_MSG_TXT               = "CX";

    static final String     FN_CVV_CODE                           = "CV";

    static final String     FN_CVV_RESPONSE                       = "CE";

    static final String     FN_DATE_TIME                          = "DT";

    static final String     FN_DEBIT_FREE_SURCHARGE_AMOUNT        = "CS";

    static final String     FN_DISPLAY_MSG                        = "DM";

    static final String     FN_ECHO_DATE                          = "ED";

    static final String     FN_ENTRY_METHOD                       = "EM";

    static final String     FN_ECI_INDICATOR                      = "EI";

    static final String     FN_EXPIRY_DATE                        = "EX";

    static final String     FN_EXTENDED_CARD_TYPE                 = "AF";

    static final String     FN_EXTENDED_OP_ID                     = "EO";

    static final String     FN_EXTERNAL_PA_REQ                    = "RB";

    static final String     FN_EXT_PA_RES                         = "SB";

    static final String     FN_FALLBACK_INDICATOR                 = "FA";

    static final String     FN_GENERIC_DATA                       = "GD";

    static final String     FN_HOST_DATE_TIME                     = "HD";

    static final String     FN_ID_SEQ_NUMBER                      = "ID";

    static final String     FN_INVOICE_NUM                        = "IN";

    static final String     FN_ISO_RESPONSE_CODE                  = "IR";

    static final String     FN_CURRENCY_RESPONSE_CODE             = "CY";

    static final String     FN_ITEM_DES                           = "IT";

    static final String     FN_LANGUAGE_CODE                      = "OL";

    static final String     FN_MERCHANT_DATA                      = "MD";

    static final String     FN_MESSAGE_TYPE                       = "MT";

    static final String     FN_MICR                               = "MR";

    static final String     FN_NO_MAC                             = "NM";

    static final String     FN_OFFER_CODE                         = "OC";

    static final String     FN_OPERATOR_DETAIL_MSG                = "OD";

    static final String     FN_OPERATOR_ID                        = "OP";

    static final String     FN_OPERATOR_LANGUAGE                  = "OA";

    static final String     FN_OPERATOR_MESSAGE                   = "OM";

    static final String     FN_PAN                                = "PA";

    static final String     FN_PAYMENT_TYPE                       = "PT";

    static final String     FN_PLAN_CODE                          = "PM";

    static final String     FN_POS_CONDITION_CODE                 = "PC";

    static final String     FN_PO_NUMBER_UPC                      = "PC";

    static final String     FN_PREVIOUS_BALANCE                   = "B0";

    static final String     FN_PREPAID_ACCESS_PIN                 = "AP";

    static final String     FN_QUALIFIED_AMOUNT_1                 = "Q1";

    static final String     FN_QUALIFIED_AMOUNT_2                 = "Q2";

    static final String     FN_RECEIPT_LANG                       = "RL";

    static final String     FN_RECEIPT_MSG_ACCOUNT                = "MA";

    static final String     FN_RECEIPT_MSG_ACTION                 = "RA";

    static final String     FN_RECEIPT_MSG_TXT                    = "RX";

    static final String     FN_RECEIPT_REF_NUM                    = "RN";

    static final String     FN_RECEIPT_REQUIRED                   = "RU";

    static final String     FN_RESPONSE_CODE                      = "RC";

    static final String     FN_RESPONSE_MSG                       = "RM";

    static final String     FN_RESPONSE_TYPE                      = "RY";

    static final String     FN_SAF_INDICATOR                      = "SF";

    static final String     FN_SAF_TRANS                          = "ST";

    static final String     FN_SALES_TYPE                         = "SY";

    static final String     FN_SECOND_EXP_DATE                    = "E2";

    static final String     FN_SECOND_PAN                         = "P2";

    static final String     FN_SECOND_TRACK_1                     = "S1";

    static final String     FN_SIGNATURE_REQUIRED                 = "SR";

    static final String     FN_SECOND_TRACK_2                     = "S2";

    static final String     FN_SELECT_CARD_TYPE                   = "S3";

    static final String     FN_STATEMENT_DESC                     = "SE";

    static final String     FN_STATION_ID                         = "SI";

    static final String     FN_TAX_AMOUNT                         = "XA";

    static final String     FN_TELEPHONE_COMPANY_ID               = "TO";

    static final String     FN_TERM_URL                           = "";

    static final String     FN_TERM_AGREE_VERSION                 = "T7";

    static final String     FN_TERM_AGREE_TEXT                    = "T8";

    static final String     FN_TIP_AMOUNT                         = "TA";

    static final String     FN_TIP_FLAG                           = "TM";

    static final String     FN_TOKEN                              = "TK";

    static final String     FN_TRANS_TYPE                         = "TT";

    static final String     FN_SHORT_TOKEN                        = "SO";

    static final String     FN_TRACE_NUMBER                       = "TN";

    static final String     FN_TRACK_1                            = "T1";

    static final String     FN_TRACK_2_ACC                        = "T2";

    static final String     FN_TRANSACTION_COUNTER                = "TR";

    static final String     FN_TRANSACTION_HANDLE                 = "H0";

    static final String     FN_TRANS_CODE                         = "TC";

    static final String     FN_ECHO_DATA                          = "ED";

    static final String     FN_UNIQUE_CARD_ID                     = "UI";

    static final String     FN_VOUCH_SER_NUM                      = "VN";

    static final String     FN_VAA                                = "VA";

    static final String     FN_VERIFICATION_METHOD                = "VE";

    static final String     FN_ZIP                                = "ZP";

    static final String     FN_OTHER_FLAG                         = "OF";

    static final String     FN_HEADER_OPTION                      = "HO";

    static final String     FN_FOOTER_OPTION                      = "FO";

    static final String     FN_HEADER_TXT                         = "HX";

    static final String     FN_FOOTER_TXT                         = "FX";

    static final String     FN_PINPAD_DISP_TIMEOUT                = "D7";

    static final String     FN_SIGNATURE_DATA                     = "SD";

    static final String     FN_SIGNATURE_Y                        = "Y";

    static final String     FN_SIGNATURE_B                        = "B";

    static final String     FN_SIGNATURE_P                        = "P";

    static final String     FN_SIGNATURE_C                        = "C";

    static final String     FN_SIGNATURE_N                        = "N";

    static final String     FN_DECLINED_VALUE                     = "D";

    static final String     FN_TERMINAL_NUMBER                    = "LN";

    static final String     FN_MERCH_ID                           = "SN";

    static final String     FN_DEVICE_ID                          = "HE";

    static final String     FN_EMV_TSI                            = "XS";

    static final String     FN_EMV_TVR                            = "TV";

    static final String     SOCKET_CONNECT_TIMEOUT                = "SOCKETCONNECTTIMEOUT";

    static final String     SIGCAP_TIMEOUT                        = "SIGCAPTIMEOUT";

    static final String     HOST_TIMEOUT                          = "HOSTTIMEOUT";

    static final String     FN_PINPAD_DISP_OPTION                 = "DO";

    static final String     FN_ITEM_CODE                          = "IO";

    static final String     FN_ITEM_QTY                           = "QU";

    static final String     FN_ITEM_UNIT_PRICE                    = "UP";

    static final String     TRANS_CODE_ITM_DISP                   = "64";

    static final String     TRANS_TYPE_ITM_DISP                   = "ItemEntry";

    static final String     VERIFONE_ENTRY_METHOD_SWIPED          = "MSR.VERIFONE";

    static final String     VERIFONE_ENTRY_METHOD_KEYED           = "KEYBOARD.KEYBOARD";

    static final String     EIGEN_GIFT_CARD                       = "EIGEN_GIFT_CARD";

    static final String     MIRA_GIFT_CARD                        = "MIRA_GIFT_CARD";

    static final String     XPAY_GIFT_CARD                        = "XPAY_GIFT_CARD";

    static final String     FN_BIRTH_DATE                         = "1D";

    static final BigDecimal MAX_VALUE_GIFTCARD                    = CawConfigurationMgr.maximumGiftCardBalance();

    static final String     RC_DECLINED                           = "DECLINED";

    static final String     DM_NOT_ACTIVE                         = "ACCT NOT ACTIVE 200";

    static final String     FN_KEY_PRESS                          = "KP";

    static final String     EIGEN_APPROVE                         = "A";

    static final String     PINPAD_KEY_OK                         = "O";

    static final String     RC_CANCELLED                          = "797";

    /** The Constant NOT_A_VALID_VALUE */
    static final BigInteger NOT_A_VALID_VALUE                     = new BigInteger("59046");

    //Begin BZ23390
    static final String     MIRA_ENTRY_METHOD_SWIPED              = "Swiped";                                                              // BZ23595
    //End BZ23390

    static final BigInteger RC_INVALID_CARD_TYPE                  = new BigInteger("717");

    static final String     DM_INVALID_CARD_TYPE                  = "INVALID CARD TYPE";

    static final String     DM_MSG_INVALID_CARD_TYPE              = "INVALID_CARD_TYPE";

    static final String     DM_ACCT_ALREADY_ACTIVE                = "ACCT ALREADY ACT200";

    static final String     DM_MSG_ACCT_ALREADY_ACTIVE            = "ACCT_ALREADY_ACTIVE";

    static final String     DM_INVALID_FORMAT                     = "INVALID FORMAT  301";

    static final String     DM_MSG_INVALID_FORMAT                 = "INVALID_FORMAT";

    /** The Constant SESSION_IN_PROGRESS */
    static final BigInteger SESSION_IN_PROGRESS                   = new BigInteger("59003");

    /** The Constant CONFIGURATION_ERROR */
    static final BigInteger CONFIGURATION_ERROR                   = new BigInteger("59028");

    /** The Constant COMM_ERROR CODE*/
    static final BigInteger COMM_ERROR                            = new BigInteger("703");

    /** The Constant PINPAD_COMM_ERROR CODE*/
    static final BigInteger PINPAD_COMM_ERROR                     = new BigInteger("708");

    /** The Constant PINPAD_COMM_ERROR CODE*/
    static final BigInteger PINPAD_NOT_CONNECT                    = new BigInteger("709");

    /** The Constant PINPAD_COMM_ERROR CODE*/
    static final BigInteger POS_TIMEOUT                           = new BigInteger("729");

    /** The Constant PINPAD_COMM_ERROR CODE*/
    static final BigInteger PINPAD_INPUT_TIMEOUT                  = new BigInteger("787");

    static final BigInteger RC_TIMEOUT                            = new BigInteger("736");

    /** The Constant PINPAD_COMM_ERROR CODE*/
    static final BigInteger TRANSACTION_TIMEOUT                   = new BigInteger("810");

    /** The Constant COMM_ERROR STRING*/
    static final String     COMM_ERROR_STR                        = "COMM_ERROR";

    /** The Constant MUST_BE_GREATER_THAN_0 */
    static final BigInteger MUST_BE_GREATER_THAN_0                = new BigInteger("59048");

    /** The Constant CANNOT_BE_NEGATIVE */
    static final BigInteger CANNOT_BE_NEGATIVE                    = new BigInteger("59047");

    /** The Constant ALREADY_EXISTS */
    static final BigInteger ALREADY_EXISTS                        = new BigInteger("59044");

    /** The Constant IS_REQUIRED */
    static final BigInteger IS_REQUIRED                           = new BigInteger("59042");

    /** The Constant MISMATCH */
    static final BigInteger MISMATCH                              = new BigInteger("59040");

    /** The Constant NO_SESSION */
    static final BigInteger NO_SESSION                            = new BigInteger("59004");

    /** The Constant FIELD_NOT_EXIST */
    static final BigInteger FIELD_NOT_EXIST                       = new BigInteger("59045");

    /** The Constant VOICE_APPROVAL */
    static final BigInteger VOICE_APPROVAL                        = new BigInteger("59024");

    /** The Constant OK */
    static final BigInteger OK_START                              = new BigInteger("0");

    /** The Constant OK */
    static final BigInteger OK_END                                = new BigInteger("9");

    /** The Constant VOIDED */
    static final BigInteger VOIDED                                = new BigInteger("7");

    /** The Constant DECLINED */
    static final BigInteger DECLINED                              = new BigInteger("50");

    /** The Constant CANCELED */
    static final BigInteger TRANSACTION_CANCEL                    = new BigInteger("766");

    /** The Constant CANCELED */
    static final BigInteger CANCELED                              = new BigInteger("799");

    /** The Constant CANCELED */
    static final BigInteger USER_CANCELED                         = new BigInteger("797");

    /** The Constant ERROR NOT SUPPORT*/
    static final BigInteger ERROR_NOT_SUPPORT                     = new BigInteger("59006");

    /** The Constant ERROR BAD CARD*/
    static final BigInteger ERROR_BAD_CARD                        = new BigInteger("59007");

    /** The Constant CAPTURED */
    static final BigInteger CAPTURED                              = new BigInteger("4");

    /** The Constant CAPTURED */
    static final BigInteger APPROVED                              = new BigInteger("5");

    /** The Constant TIME_OUT */
    static final BigInteger TIME_OUT                              = new BigInteger("59026");

    /** The Constant TRUE_BOOLEAN */
    static final String     TRUE_BOOLEAN                          = "TRUE";

    /** The Constant FALSE_BOOLEAN */
    static final String     FALSE_BOOLEAN                         = "FALSE";

    /** Connection disrupted text */
    final String            CONNECTION_DISRUPTED_TXT_RESPONSE     = "Connection disrupted";

    /** Can not process offline text response */
    final String            CANT_PROCESS_OFFLINE_TXT_RESPONSE     = "Communication error; cant process tran offline for this payment type";

    /** Error code for payment media error */
    final BigInteger        PAYMENT_MEDIA_ERROR                   = new BigInteger("10100");

    /** PAYMENT_MEDIA is MC CVV2 length should be 3 length passed was 4 */
    final String            PAYMENT_MEDIA_ERROR_TXT_RESPONSE      = "PAYMENT_MEDIA is MC CVV2 length should be 3 length passed was 4";

    /** Card Read Error; another form of payment or Manual Entry is required */
    final String            CARD_READ_ERROR_TXT_RESPONSE          = "Card Read Error; another form of payment or Manual Entry is required";

    /** Card Data Not Valid */
    final String            CARD_NOT_VALID_TXT_RESPONSE           = "Card Data Not Valid";

    //Begin Bz11708
    /** The Constant ERROR_NOT_ELIGIBLE */
    static final BigInteger ERROR_NOT_ELIGIBLE                    = new BigInteger("3705");
    //End Bz11708

    //Begin BZ11703
    /** The Constant AUTH_CODE_MAX_LEN */
    static final BigInteger AUTH_CODE_MAX_LEN                     = new BigInteger("10098");
    //End BZ11703

    //Begin BZ12185
    /** The Constant UNKONW */
    static final BigInteger UNKONW                                = new BigInteger("0");

    /** The Constant INVALID_AMOUNT */
    static final BigInteger INVALID_AMOUNT                        = new BigInteger("1010");
    //End BZ12185

    /** The Constant INVALID_AMOUNT */
    static final BigInteger CARD_DATA_NOT_VALID                   = new BigInteger("59009");

    static final BigInteger FIELD_INVALID                         = new BigInteger("59043");

    static final BigInteger DEVICE_IS_BUSY                        = new BigInteger("59002");

    static final int        INVOICE_REGISTER                      = 2;

    static final int        INVOICE_TRANSACTION_SEQ               = 4;

    static final String     MIRA_ENTRY_METHOD_KEYED               = "Keyed";                                                               // BZ23595

    static final BigInteger OK_LAST_TRANS                         = new BigInteger("100");

    static final String     IS_UNVOIDED                           = "IS_UNVOIDED";

    static final String     IS_VOIDED                             = "IS_VOIDED";

    static final String     ENABLE                                = "ENABLE";

    static final String     DISABLE                               = "DISABLE";

    static final String     LAST_TRANS_RETRY_NUMBER               = "5";

    static final String     LAST_TRANS_SLEEP_TIME                 = "250";

    static final String     FN_APPROVED_CODE                      = "AC";                                                                  //BZ23585

    static final String     AUTH_NUMBER                           = "authNumber";                                                          //BZ23585

    static final String     MIRA_ENTRY_METHOD_CHIP                = "Chip Read";                                                           //BZ23544

    static final String     MIRA_ENTRY_METHOD_FBACK               = "FSwipe";                                                              //BZ23640

    static final String     USA_CURRENCY_CODE                     = "840";

    static final String     CAD_CURRENCY_CODE                     = "124";

    static final String     USA_CURRENCY_DESC                     = "USD";

    static final String     CAD_CURRENCY_DESC                     = "CAD";

    static final String     CONFIRM_PROMPT                        = "ConfirmPrompt";

    static final String     KCLU                                  = "KCLU";
    
    /*BEGIN BZ37207*/
    static final String     KCSU                                  = "KCSU";
    static final String     KcSU                                  = "KcSU";
    /*END BZ37207*/

    static final String     FIELD_L1                              = "L1";

    static final String     FIELD_L2                              = "L2";

    static final String     FIELD_L3                              = "L3";

    static final String     FIELD_L4                              = "L4";

    static final String     FIELD_L5                              = "L5";

    static final String     FIELD_L6                              = "L6";

    static final String     FIELD_L9                              = "L9";

    static final String     FIELD_KE                              = "KE";

    static final String     FIELD_P1                              = "P1";

    static final String     FIELD_P7                              = "P7";

    static final String     ENTER_FULL                            = "Please Enter Your Full";

    static final String     SOCIAL_SECURITY_NUMBER                = "Social Security Number";

    static final String     CONFIRM_INFO                          = "Press O to Confirm, X to Cancel";

    static final String     CONFIRM_DETAILS                       = "Please confirm Your Details:";

    static final String     VALUE_5N                              = "5N";

    static final String     VALUE_MUCK                            = "MUCK";
    static final String     VALUE_SUCK                            = "SUCK";/* BZ37207 */

    static final String     VALUE_P7_SSN                          = "5|1|9|N|L|*4";                                                        /*BZ28743: changed the limit of number from 12 to 9*/

    static final String     BIRTH_DATE_ENTRY                      = "BirthDateEntry";

    static final String     VALUE_P1_BDE                          = "1D";

    static final String     VALUE_P7_BDE                          = "1|0";

    static final String     VALUE_5_1_20_A_L                      = "5|1|20|A|L|";

    static final String     VALUE_6P                              = "6P";

    static final String     EX_5554443333                         = "Ex: 5554443333";

    static final String     INCLUDING_AREA_CODE                   = "Including Area Code.";

    static final String     TELEPHONE_NUMBER                      = "Telephone Number,";

    static final String     PLEASE_ENTER_YOUR_FULL                = "Please Enter Your Full";

    static final String     VALUE_5_1_7_D_L                       = "5|1|7|D|L|";

    static final String     FIELD_A2                              = "A2";

    static final String     EX_50000                              = "Ex: $50000";

    static final String     ANNUAL_INCOME_AMOUNT                  = "Annual Income Amount";

    static final String     PLEASE_ENTER_YOUR                     = "Please Enter Your";

    static final String     SECURE_ENTRY                          = "SecureEntry";

    static final String     OLPS                                  = "OLPS";

    static final String     FIELD_EN                              = "EN";

    static final String     FIELD_ED                              = "ED";

    static final String     PRE_SCREEN                            = "PreScreen";

    static final String     MADE_OFFER                            = "MadeOffer";

    static final String     VALUE_83                              = "83";

    static final String     VALUE_1                               = "1";

    static final String     FIELD_R0                              = "R0";

    static final String     FIELD_R7                              = "R7";

    static final String     VALUE_EMPTY                           = "";

    static final String     FIELD_6N                              = "6N";

    static final String     FIELD_SN                              = "SN";

    static final String     FIELD_SV                              = "SV";

    static final String     VALUE_N                               = "N";

    static final String     VALUE_Y                               = "Y";

    static final String     FIELD_Z1                              = "Z1";

    static final String     FIELD_1S                              = "1S";

    static final String     FIELD_1C                              = "1C";

    static final String     FIELD_D2                              = "D2";

    static final String     FIELD_D1                              = "D1";

    static final String     FIELD_N3                              = "N3";

    static final String     FIELD_N1                              = "N1";

    static final String     VALUE_A                               = "A";

    static final String     FIELD_OF                              = "OF";

    static final String     FIELD_ME                              = "ME";

    static final String     FIELD_GR                              = "GR";

    static final String     FIELD_AI                              = "AI";

    static final String     FIELD_AU                              = "AU";

    static final String     FIELD_PE                              = "PE";

    static final String     FIELF_T8                              = "T8";

    static final String     FIELD_T7                              = "T7";

    static final String     VALUE_OX                              = "OX";

    static final String     VALUE_5_4_4_N_L_4                     = "5|4|4|N|L|*4";

    static final String     ENTER_4_DIGITS_OF_SSN                 = "4 Digits of Your";

    static final String     ENTER_LAST_NAME                       = "Please Enter The Last";

    static final String     VALUE_01                              = "01";

    static final String     FIELD_EX                              = "EX";

    static final String     FIELD_SO                              = "SO";

    static final String     FIELD_A1                              = "A1";

    static final String     STR_ACCOUNT_NUM                       = "ACCOUNT #";

    static final String     VALUE_OCIT_MB                         = "OcitMB";

    static final String     VALUE_OC_IT_MU                        = "OCItMU";

    static final String     VALUE_K                               = "K";

    static final String     JSON_COUNTRY                          = "country";

    static final String     JSON_CUSTOMER_TYPE                    = "customerType";

    static final String     JSON_LINE1                            = "line1";

    static final String     CITY                                  = "city";

    static final String     STATE_PROVINCE                        = "stateProvince";

    static final String     POSTAL_CODE                           = "postalCode";

    static final String     ACCOUNT_NUMBER                        = "accountNumber";

    static final String     JSON_LAST_NAME                        = "last";

    static final String     JSON_FIRST_NAME                       = "first";

    static final String     JSON_NAME                             = "name";

    static final String     JSON_COMPANY_NAME                     = "company";

    static final String     JSON_LINE2                            = "line2";

    static final String     JSON_ADDRESS                          = "address";

    static final String     RU                                    = "RU";

    static final String     SETUP_SLIDES                          = "SetupSlides";

    static final String     AMT_DUE                               = "Amt. due: ";

    static final String     VALUE_V                               = "V";

    static final String     SE                                    = "SE";

    static final String     EIGEN                                 = "EIGEN";

    /** The Constant CARD_NUM_ERROR BZ23629*/
    static final BigInteger CARD_NUM_ERROR                        = new BigInteger("702");

    static final String     VALUE_94                              = "94";

    // Begin BZ27757
    static final String     GIFT_CARD_NOT_ACTIVE_CODE             = "200";
    // End BZ27757

    /*BZ26858 added */
    static final String     TRANS_TYPE_CLEAR_SECURE_ENTRY         = "ClearSecureEntry";

    static final String     ARG_ORGANIZATION_ID                   = "argOrganizationId";

    static final String     ECHO_DATA_TRANSACTION_SEQUENCE_FORMAT = "%1$06d";

    static final String     ECHO_DATA_FORMAT                      = "%1$04d";

    static final String     MESSAGE_TYPE                          = "MessageType";

    static final String     MESSAGE_TYPE_Q                        = "Q";

    static final String     DOT                                   = ".";

    static final String     CAW_EIGEN_TIMEOUT                     = "caw.eigen.timeout";
    // End BZ26858

    // Begin BZ27933
    static final String     LINE_REFUND                           = "Refund";
    // End BZ27933

    /* Begin BZ27344, BZ28407 */
    static final int        NUMBER_OF_ITEMS_DISPLAY_PINPAD        = 12;

    static final String     INIT_NUMBER_ITEM                      = "1";
    /* End BZ27344 */

    /* Begin BZ27875 */
    static final String     GIFT_CARD_TYPE_RELOAD                 = "RELOAD";

    static final String     GIFT_CARD_TYPE_ISSUED                 = "ISSUED";

    static final String     GIFT_CARD_TYPE_REDEEM                 = "REDEEM";
    /* End BZ27875 */

    /* Begin BZ28403 */
    static final String     FOOTER_DUE                            = " due";
    /* End BZ28403 */

    /* BEGIN BZ25761 Session */
    static final String     FIELD_L7                              = "L7";

    static final String     FIELD_L8                              = "L8";

    //Medium font, Blue text, do not center text, clear screen before adding text
    static final String     VALUE_MUcK                            = "MUcK";

    //Small font, Blue text, do not center text, clear screen before adding text
    static final String     VALUE_SUcK                            = "SUcK";

    //Large font, Blue text, do not center text, clear screen before adding tex
    static final String     VALUE_LUcK                            = "LUcK";

    static final String     KEY_F6_F7                             = "^&";

    static final String     KEY_F6_F7_F8                          = "^&*";

    static final String     KEY_F5                                = "%";

    static final String     KEY_F6                                = "^";

    static final String     KEY_F7                                = "&";

    static final String     KEY_F8                                = "*";

    static final String     KEY_TEXT_F5                           = "F5";

    static final String     KEY_TEXT_F6                           = "F6";

    static final String     KEY_TEXT_F7                           = "F7";

    static final String     KEY_TEXT_F8                           = "F8";

    static final String     TEXT_NO                               = "NO";

    static final String     TEXT_YES                              = "YES";

    static final String     TEXT_THIS_NOT_ME                      = "THIS IS NOT ME";

    /* BEGIN BZ29399 */
    static final String     TEXT_NO_THANKS                        = "NO, THANKS";

    static final String     TEXT_YES_ACCEPT                       = "YES, ACCEPT";
    /* END BZ29399 */

    static final String     STAR_SIGN                             = "*";

    static final String     FIELD_L0                              = "L0";

    static final String     FIELD_LA                              = "LA";

    static final String     FIELD_LB                              = "LB";

    static final String     FIELD_LC                              = "LC";

    static final String     FIELD_LD                              = "LD";

    static final String     FIELD_LE                              = "LE";

    static final String     TEXT_DISPLAY                          = "TextDisplay";

    static final String     VALUE_13_1_7_D_L                      = "13|1|7|D|L|";

    static final String     TEXT_NEXT                             = "NEXT";

    static final String     XML_ACCOUNT_SUMMARY_PATTERN           = "//accountSummary";

    static final String     XML_EXP_DATE_PATTERN                  = "//expirationDate";

    static final String     XML_CARD_TYPE_PATTERN                 = "//cardType";

    static final String     PRESCREEN_ACCEPT                      = "PrescreenAccept";

    static final String     INSTANT_CREDIT                        = "InstantCredit";

    static final String     DOLLAR_SIGN                           = "$";
    /* END BZ25761 Session */

    /* BEGIN BZ25762 */
    static final String     ACCOUNT_SUMMARY                       = "AccountSummary";

    static final String     FIELD_RC                              = "RC";

    static final String     FIELD_RM                              = "RM";
    /* END BZ25762 */

    /* BEGIN BZ28738 */
    static final String     FIELD_D7                              = "D7";

    static final String     TEN_SEC                               = "10";
    /* END BZ28738 */

    /* BEGIN BZ28735 */
    static final String     GIFT_CARD_TYPE_REDEEMED               = "REDEEMED";
    /* END BZ28735 */

    /*BEGIN BZ27973*/
    static final String     VALUE_60                              = "60";
    /*END BZ27973*/

    /*BEGIN BZ28546*/
    static final String     FN_ITEMCODE                           = "IO";

    static final String     FN_ITEMDES                            = "IT";
    /*END BZ28546*/

    /*BEGIN BZ29313*/
    static final String     CLEAR_SECURE_ENTRY_TRANSACTION_CODE   = "64";
    /*END BZ29313*/

    /*BEGIN BZ29314*/
    static final String     FIELD_6Y                              = "6Y";

    static final String     FIELD_6Y_VALUE                        = "G4R";
    /*END BZ29314*/

    /*BEGIN BZ29290*/
    static final int        MAX_LENGTH_FIRST_LINE_EMAIL           = 35;

    static final int        MAX_LENGTH_SECOND_LINE_EMAIL          = 44;

    /*END BZ29290*/
    /* BEGIN BZ29280 */
    static final String     XML_APR_PATTERN                       = "//apr";
    /* END BZ29280 */

    /*BEGIN BZ29379*/
    static final String     ADS_RETURN_CODE_APPROVE_00            = "00";

    static final String     ADS_RETURN_CODE_APPROVE_000           = "000";

    static final String     FIVE_SEC                              = "5";
    /*END BZ29379*/

    static final String     EXPIRY_DATE_MMYY                      = "MMyy";                                                                /*BZ29360*/

    /*BEGIN BZ29406*/
    static final String     VALUE_70                              = "70";

    static final String     FIELD_HI                              = "HI";
    /*END BZ29406*/

    /*BEGIN BZ29455*/
    static final String     DEFAUTL_AMOUNT                        = "0";
    /*END BZ29455*/

    /*BEGIN BZ29478*/
    static final String     TEXT_OK                               = "OK";
    /*END BZ29478*/

    /* BEGIN BZ29535 */
    static final String     MINIMUM_PAYMENT_AMOUNT_DUE            = "MPAD";

    static final String     PAYMENT_DUE_DATE                      = "PDD";
    /* END BZ29535 */

    /*BEGIN BZ29601*/
    static final String     TEXT_SUBMIT                           = "SUBMIT";
    /*END BZ29601*/

    /*BEGIN BZ29704*/
    static final String     AUX_RESPONSE_CODE_200                 = "200";
    /*END BZ29704*/
    /*BEGIN BZ32046*/
    static final String     WELCOME_MESSAGE                       = "WELCOME_MESSAGE";

    static final String     PIN_PAD                               = "PIN_PAD";
    /*END BZ32046*/

    static final String     ORIG_INVOICE_NO                       = "OG";/*BZ41674*/

    static final String     FIELD_RECURRING_PAYMENT               = "RP";/*BZ45156*/
    
    /* BEGIN BZ46300 */
    static final String     FIELD_TE                              = "TE";
    /* END BZ46300 */
    
    static final String     TEXT_CLOSE                            = "CLOSE";//BZ57844
}
