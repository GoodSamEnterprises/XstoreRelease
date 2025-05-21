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

public class CawCustomerModel {

    private int             customerType;

    private Long            accountNumber;

    private CawNameModel    name;

    private CawAddressModel cawAddressModel;

    private String          partyId;

    public int getCustomerType() {

        return customerType;
    }

    public void setCustomerType(int customerType) {

        this.customerType = customerType;
    }

    public Long getAccountNumber() {

        return accountNumber;
    }

    public void setAccountNumber(Long accountNumber) {

        this.accountNumber = accountNumber;
    }

    public CawNameModel getName() {

        return name;
    }

    public void setName(CawNameModel name) {

        this.name = name;
    }

    public CawAddressModel getAddress() {

        return cawAddressModel;
    }

    public void setAddress(CawAddressModel cawAddressModel) {

        this.cawAddressModel = cawAddressModel;
    }

    public String getPartyId() {

        return partyId;
    }

    public void setPartyId(String partyId) {

        this.partyId = partyId;
    }
}
