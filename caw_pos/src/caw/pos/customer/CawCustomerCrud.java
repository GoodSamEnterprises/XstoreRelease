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
 * BZ28985          190219    [Internal] Incorrect customer account number is submitted in the Upsert request to the Neuron API
 *===================================================================
 */

package caw.pos.customer;

/**
 * Enum store value of field crud when sent sent request create the customer
 */
public enum CawCustomerCrud {
    NOT_SPECIFIED(0), CREATED(1), READ(2), UPDATED(4), DELETED(8);

    private Integer value;

    CawCustomerCrud(Integer values) {

        this.value = values;
    }

    public Integer getValue() {

        return value;
    }
}