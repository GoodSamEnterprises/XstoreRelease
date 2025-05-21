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
 * BZ37023          120820    [Task] Modify Xstore to call ShippingAPI to calculate shipping rate for the Delivery Order
 * BZ37642          030920    [Internal] Xstore makes a Shipping Rates API request to Neuron API included a few value of attributes/tags into the body request does not match to specification Neuron API.
 * BZ37912          021020    Shipping Fee is being applied to the line item vs transaction level
 * BZ38442          131020    [TASK] Handling about calculate shipping Fee of Delivery order included a regular item, restricted item with additional freight, and freight quote item
 *===================================================================
 */

package caw.pos.order;

/**
 *
 */
public interface CawShipperMethodConsIfc {

    /**
     * The SALE_CHANEL_ID
     */
    public static final String SALE_CHANEL_ID           = "!{id}";

    /**
     * The SALE_CHANNEL_TYPE
     */
    public static final String SALE_CHANNEL_TYPE        = "!{channelType}";

    /**
     * The CHANNEL_TYPE_DESCRIPTION
     */
    public static final String CHANNEL_TYPE_DESCRIPTION = "!{channelTypeDescription}";

    /**
     * The ZERO_CHAR
     */
    public static final char   ZERO_CHAR                = '0';

    /**
     * The DATE_FORMAT
     */
    public static final String DATE_FORMAT              = "yyyyMMdd";

    /**
     * The CORRELATION_KEY
     */
    public static final String CORRELATION_KEY          = "!{correlationKey}";

    /**
     * The NULL_STRING
     */
    public static final String NULL_STRING              = "null";

    /**
     * The DESCRIPTION
     */
    public static final String DESCRIPTION              = "!{description}";

    /**
     * The ITEM_CODE
     */
    public static final String ITEM_CODE                = "!{itemCode}";

    /**
     * The QUANTITY
     */
    public static final String QUANTITY                 = "!{quantity}";

    /**
     * The PREFERENCE
     */
    public static final String PREFERENCE               = "!{preference}";

    /**
     * The DELIVERY
     */
    public static final String DELIVERY                 = "DELIVERY";

    /**
     * The NAME
     */
    public static final String NAME                     = "!{name}";

    /**
     * The LINE1
     */
    public static final String LINE1                    = "!{line1}";

    /**
     * The CITY
     */
    public static final String CITY                     = "!{city}";

    /**
     * The STATEPROVINCE
     */
    public static final String STATEPROVINCE            = "!{stateProvince}";

    /**
     * The POSTAL_CODE
     */
    public static final String POSTAL_CODE              = "!{postalCode}";

    /**
     * The COUNTRY
     */
    public static final String COUNTRY                  = "!{country}";

    /**
     * The HAS_ERROR
     */
    public static final String HAS_ERROR                = "hasErrors";

    /**
     * The SHIPPING_PREFERENCES
     */
    public static final String SHIPPING_PREFERENCES     = "shippingPreferences";

    /**
     * The SHIPPING_GROUPS
     */
    public static final String SHIPPING_GROUPS          = "shippingGroups";

    /**
     * The SHIPPING_OPTIONS
     */
    public static final String SHIPPING_OPTIONS         = "shippingOptions";

    /**
     * The SERVICE_LEVEL
     */
    public static final String SERVICE_LEVEL            = "serviceLevel";

    /**
     * The SERVICE_DES
     */
    public static final String SERVICE_DES              = "serviceLevelDescription";

    /**
     * The PRICE
     */
    public static final String PRICE                    = "price";
    /* BEGIN BZ38442 */
    /**
     * The TOTAL
     */
    public static final String TOTAL                    = "total";
    
    /**
     * The ADDITIONNAL_PH
     */
    public static final String ADDITIONNAL_PH           = "additionalPH";
    /* END BZ38442 */

    /* BEGIN BZ-37642 */
    public static final String USE_MEMBER_PRICING       = "!{useMemberPricing}";

    public static final String ORDER_TOTAL              = "!{orderTotal}";

    /* END BZ-37642 */
    /* BEGIN BZ37912 */
    public static final String ORDER_SHIPPING_ITEMS     = "!{order_shipping_items}";

    public static final String ORDER_SHIPPING_INFO      = "!{order_shipping_infor}";

    public static final String SHIPPING_ITEMS_ARRAY     = "items";

    public static final String SHIPPING_QUANTITY        = "quantity";

    public static final String SHIPPING_ITEM_CODE       = "itemCode";
    /* END BZ37912 */
    

}
