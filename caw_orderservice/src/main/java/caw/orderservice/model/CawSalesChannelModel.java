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
 * BZ23591              270917    Add channelType in Customer Update and Order Service
 * BZ63054              080424    [API Change] - Format of the Submit Order API response is changed.
 *== ================================================================
 */

package caw.orderservice.model;

public class CawSalesChannelModel {

    private Integer id;

    private Integer terminal;

    private Integer channelType; //BZ23591

    private String channelTypeDescription; //BEGIN Z63054
    public Integer getId() {

        return id;
    }

    public void setId(Integer id) {

        this.id = id;
    }

    public Integer getTerminal() {

        return terminal;
    }

    public void setTerminal(Integer terminal) {

        this.terminal = terminal;
    }

    /**
     * @return the channelType
     */
    public Integer getChannelType() {

        return channelType;
    }

    /**
     * @param channelType the channelType to set
     */
    public void setChannelType(Integer channelType) {

        this.channelType = channelType;
    }
    /*BEGIN BZ63054*/
    
    /**
     * @return the channelTypeDescription
     */
    public String getChannelTypeDescription() {
    
        return channelTypeDescription;
    }

    
    /**
     * @param channelTypeDescription the channelTypeDescription to set
     */
    public void setChannelTypeDescription(String channelTypeDescription) {
    
        this.channelTypeDescription = channelTypeDescription;
    }
    /*END BZ63054*/
    
}
