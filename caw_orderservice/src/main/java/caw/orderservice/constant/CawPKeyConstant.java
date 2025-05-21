/**
 * CONFIDENTIAL AND PROPRIETARY SOURCE CODE. 
 * 
 * Use and distribution of this code is subject to applicable 
 * licenses and the permission of the code owner.  This notice 
 * does not indicate the actual or intended publication of 
 * this source code.
 * 
 * Portions [of the software code and associated documentation] 
 * developed for Camping World are proprietary and confidential 
 * to BTM Global. BTM Global has granted Camping World a perpetual, 
 * non-exclusive, non-sublicensable license to use [the software 
 * code and associated documentation] for its internal business 
 * operations only.
 * 
 * ===== BTM Modification ===========================================
 * Req/Bug ID#          ddMMyy    Description
 * BZ25614              140318    [Order Service] Order Service code review
 * BZ26888              240718    [Internal] Move 2 Paid In (980920) & Paid Out (980919) items to configuration file
 * BZ27629              180818    [PROD] Update Order Service to send Gift Card item as GC RELOAD in Tender Exchange
 * BZ29391              140219    [Internal] PLCC payment generates a 400 error.
 * BZ37463              220820    [Task] Creating Order Service Spec for Brokered Order transaction types.
 * BZ48320              220122    Vehicle Identification Number (VIN) Capture - New Order API to capture VIN into BOPIS transaction
 * BZ48630              150622    [Task] Order Service - Transaction Posting to Cheetah
 *== ================================================================
 */

package caw.orderservice.constant;

/**
 * Define Properties Key 
 */
public class CawPKeyConstant {

    public static final String UPSERT_SERVICE_API          = "ebs.upsert.service.api";

    public static final String ORDER_SERVICE_API           = "ebs.order.service.api";
    
    public static final String ORDER_SERVICE_STATUS_API    = "ebs.order.service.status.api";//BZ37463
    
    public static final String ORDER_SERVICE_CAPTURE_API    = "ebs.order.service.capture.api";//BZ48320

    public static final String NEURON_USER                 = "ebs.order.service.neuron.user";

    public static final String NEURON_KEY                  = "ebs.order.service.neuron.key";

    public static final String MAX_TRANS                   = "max.records";

    public static final String JNDI_DATASOURCE             = "jndi.datasource";

    public static final String DTV_CUSTOMERID              = "dtv.CustomerId";

    public static final String DTV_RES_KEY                 = "dtv.util.crypto.SecretKeyCipherManager.keyStoreDirectory";

    public static final String LOCATIONCODE_KEY            = "locationCode";

    public static final String DISCOUNT_TYPE               = "discount.type";

    public static final String ADJUSTMENT_CLUB_CODE        = "adjustment.club.code";

    public static final String ADJUSTMENT_CREW_CODE        = "adjustment.crew.code";

    public static final String ADJUSTMENT_WHOLESALE_CODE   = "adjustment.wholesale.code";

    public static final String ITEM_NOT_ON_FILE_DEFAULT_ID = "ItemNotOnFileDefaultId";

    public static final String ALLOW_SEND_EMAIL            = "allowSendEmail";

    public static final String SENDER_EMAIL                = "senderEmail";

    public static final String RECIPIENT_EMAIL             = "recipientEmail";

    public static final String SMTP_CONFIG                 = "smtpConfig";

    public static final String MAX_RETRY_COUNT             = "max.retry.count";

    public static final String ITEM_PAID_IN                = "ItemPaidIn";

    public static final String ITEM_PAID_OUT               = "ItemPaidOut";

    public static final String AR_REASON_CODE              = "ArReasonCode";

    public static final String AC_REASON_CODE              = "AcReasonCode";//BZ29391 

    public static final String ITM_CODE_TENDER_EXCHANGE    = "item.tender.exchange.giftcard.reload.id";

    /* BEGIN BZ48630: Handle to use TOKEN */
    public static final String ORDER_SERVICE_API_TOKEN           = "ebs.order.service.api.token";
    
    public static final String ORDER_SERVICE_STATUS_API_TOKEN    = "ebs.order.service.status.api.token";
    
    public static final String ORDER_SERVICE_CAPTURE_API_TOKEN   = "ebs.order.service.capture.api.token";
    
    public static final String UPSERT_SERVICE_API_TOKEN          = "ebs.upsert.service.api.token";
    
    public static final String TOKEN                        = ".token";
    
    public static final String CLIENT_ID                    = ".client.id";

    public static final String CLIENT_SECRET                = ".client.secret";
    
    public static final String GRANT_TYPE                   = ".grant.type";
    
    public static final String CONTINGENCY_TIME             = ".contingency.time";
    /* END BZ48630: Handle to use TOKEN */
}