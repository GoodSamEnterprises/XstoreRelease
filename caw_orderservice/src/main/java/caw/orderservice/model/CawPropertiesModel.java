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
 * BZ24658              011217    [OrderService]Serialized items are not passed to Order Service
 * BZ24905              211217    [OrderService] Pull 0600 item attributes to order service
 * BZ25614              140318    [Order Service] Order Service code review
 *== ================================================================
 */

package caw.orderservice.model;

public class CawPropertiesModel {

    private String WARRANTY_STATUS;

    private String ITEM_DEPARTMENT;

    public String getProperty1() {

        return WARRANTY_STATUS;
    }

    public void setProperty1(String property1) {

        this.WARRANTY_STATUS = property1;
    }

    //Begin BZ24658
    private String SERIAL_ITEM;

    public String getProperty3() {

        return SERIAL_ITEM;
    }

    public void setProperty3(String property3) {

        this.SERIAL_ITEM = property3;
    }

    //End BZ24658
    public String getProperty2() {

        return ITEM_DEPARTMENT;
    }

    public void setProperty2(String ITEM_DEPARTMENT) {

        this.ITEM_DEPARTMENT = ITEM_DEPARTMENT;
    }

    //Begin BZ24905
    private String string_value;

    public String getProperty4() {

        return string_value;
    }

    public void setProperty4(String itemCode) {

        this.string_value = itemCode;
    }
    //End BZ24905

}
