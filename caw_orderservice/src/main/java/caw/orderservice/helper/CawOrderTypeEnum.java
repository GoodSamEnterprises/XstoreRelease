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
 * Req/Bug ID#      ddMMyy    Description
 * BZ37463          220820    [Task] Creating Order Service Spec for Brokered Order transaction types.
 *===================================================================
 */

package caw.orderservice.helper;

/**
 *
 */
public enum CawOrderTypeEnum {
    RETAIL_SALE, // just for retail sale
    BROKERED_ORDER, // for create, complete brokered order
    BROKERED_ORDER_STATUS // for accept/reject, pick/reserve/un-reserve
}
