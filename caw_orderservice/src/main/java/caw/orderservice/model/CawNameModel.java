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

public class CawNameModel {

    private String prefix;

    private String first;

    private String middle;

    private String last;

    private String suffix;

    private String company;

    public String getPrefix() {

        return prefix;
    }

    public void setPrefix(String prefix) {

        this.prefix = prefix;
    }

    public String getFirst() {

        return first;
    }

    public void setFirst(String first) {

        this.first = first;
    }

    public String getMiddle() {

        return middle;
    }

    public void setMiddle(String middle) {

        this.middle = middle;
    }

    public String getLast() {

        return last;
    }

    public void setLast(String last) {

        this.last = last;
    }

    public String getSuffix() {

        return suffix;
    }

    public void setSuffix(String suffix) {

        this.suffix = suffix;
    }

    public String getCompany() {

        return company;
    }

    public void setCompany(String company) {

        this.company = company;
    }
}
