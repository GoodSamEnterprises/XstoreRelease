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
 * CAW_OrderService     210817    Initial development framework              
 *== ================================================================
 */

package caw.orderservice.model;

import java.math.BigDecimal;

public class CawAdjustmentsModel {

    private String     correlationKey;

    private String     type;

    private BigDecimal amount;

    private String     couponCode;

    private String     serializedCoupon;

    public String getCorrelationKey() {

        return correlationKey;
    }

    public void setCorrelationKey(String correlationKey) {

        this.correlationKey = correlationKey;
    }

    public String getType() {

        return type;
    }

    public void setType(String type) {

        this.type = type;
    }

    public BigDecimal getAmount() {

        return amount;
    }

    public void setAmount(BigDecimal amount) {

        this.amount = amount;
    }

    public String getCouponCode() {

        return couponCode;
    }

    public void setCouponCode(String couponCode) {

        this.couponCode = couponCode;
    }

    public String getSerializedCoupon() {

        return serializedCoupon;
    }

    public void setSerializedCoupon(String serializedCoupon) {

        this.serializedCoupon = serializedCoupon;
    }
}
