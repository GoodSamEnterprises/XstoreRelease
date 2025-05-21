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
 * BZ37912          021020    Shipping Fee is being applied to the line item vs transaction level
 * 
 *===================================================================
 */

package caw.pos.order;

import java.util.List;

/**
 *
 */
public class CawShippingGroupsModel {

    private int                            groupId;

    private List<String>                   description;

    private List<CawShippingItemsModel>    shippingItemsModels_;

    private List<CawShipperMethodAPIModel> shipperMethodAPIModels_;

    /**
     * @return the description
     */
    public List<String> getDescription() {

        return description;
    }

    /**
     * @param argDescription the description to set
     */
    public void setDescription(List<String> argDescription) {

        description = argDescription;
    }

    /**
     * @return the groupId
     */
    public int getGroupId() {

        return groupId;
    }

    /**
     * @param argGroupId the groupId to set
     */
    public void setGroupId(int argGroupId) {

        groupId = argGroupId;
    }

    /**
     * @return the shippingItemsModels
     */
    public List<CawShippingItemsModel> getShippingItemsModels() {

        return shippingItemsModels_;
    }

    /**
     * @param argShippingItemsModels the shippingItemsModels to set
     */
    public void setShippingItemsModels(List<CawShippingItemsModel> argShippingItemsModels) {

        shippingItemsModels_ = argShippingItemsModels;
    }

    /**
     * @return the shipperMethodAPIModels
     */
    public List<CawShipperMethodAPIModel> getShipperMethodAPIModels() {

        return shipperMethodAPIModels_;
    }

    /**
     * @param argShipperMethodAPIModels the shipperMethodAPIModels to set
     */
    public void setShipperMethodAPIModels(List<CawShipperMethodAPIModel> argShipperMethodAPIModels) {

        shipperMethodAPIModels_ = argShipperMethodAPIModels;
    }
}
