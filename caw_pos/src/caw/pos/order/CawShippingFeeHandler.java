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
 * BZ37912          021020    Shipping Fee is being applied to the line item vs transaction level
 *===================================================================
 */

package caw.pos.order;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import caw.pos.shippingfee.CawGetListsShippingFee;
import caw.pos.shippingfee.CawShippingFeeCalculator;

import dtv.pos.common.ConfigurationMgr;
import dtv.pos.common.LocationFactory;
import dtv.pos.shippingfee.*;
import dtv.pos.shippingfee.config.ShipAccountType;
import dtv.util.CollectionUtils;
import dtv.util.address.IAddress;

/**
 *
 */
public class CawShippingFeeHandler {
    
    private static final Logger _logger = LogManager.getLogger(CawShippingFeeHandler.class);

    private static CawShippingFeeHandler INSTANCE;

    /**
     * Returns the singleton instance of this helper.
     * @return the singleton instance of this helper
     */
    public static CawShippingFeeHandler getInstance() {

        if (INSTANCE == null) {
            INSTANCE = new CawShippingFeeHandler();
        }
        return INSTANCE;
    }

    private CawShippingFeeCalculator shipFeeCalculator = null;

    /**
     * Constructs a <code>CawShippingFeeHandler</code>.
     */
    private CawShippingFeeHandler() {

        shipFeeCalculator = new CawShippingFeeCalculator(
                new ShippingFeeRulesDatabaseConfig());
    }

    /**
     * Returns the results request for a shipping fee calculation.
     *
     * @param argFromAddress the address the shipment will be shipped from
     * @param argToAddress the address the shipment will be shipped to
     * @param argAcctType the type of ship account needing a shipping fee calculation
     * @param argItems he collection of items to e shipped
     * @param argRetailLocationId the retail location id
     * @return the results of the shipping fee calculation
     */
    public ShippingFeeCalcResponse getShippingFee(IAddress argFromAddress,
            IAddress argToAddress, ShipAccountType argAcctType,
            List<ShippableLineItem> argItems, long argRetailLocationId) {

        return getShippingFee(argFromAddress, argToAddress, argAcctType, argItems, null, argRetailLocationId);
    }

    /**
     * Returns the results request for a shipping fee calculation.
     *
     * @param argFromAddress the address the shipment will be shipped from
     * @param argToAddress the address the shipment will be shipped to
     * @param argAcctType the type of ship account needing a shipping fee calculation
     * @param argItems the collection of items to be shipped
     * @param argShipMethod the ship method for all items
     * @param argRetailLocationId the retail location id
     * @return the results of the shipping fee calculation
     */
    public ShippingFeeCalcResponse getShippingFee(IAddress argFromAddress,
            IAddress argToAddress, ShipAccountType argAcctType,
            List<ShippableLineItem> argItems, String argShipMethod,
            long argRetailLocationId) {

        ShippingFeeCalcRequest request = new ShippingFeeCalcRequest();

        request.setOrgId(ConfigurationMgr.getOrganizationId());
        request.setFeeCalcStrategy(argAcctType.getShippingCalcStrategy());
        request.setShippingAcctType(argAcctType);
        request.setToAddress(argToAddress);
        request.setFromAddress(argFromAddress);
        request.setRetailLocation(LocationFactory.getInstance()
                .getOrganizationHierarchyNode(argRetailLocationId));
        request.setItems(argItems);
        request.setShipMethod(argShipMethod);

        if (_logger.isDebugEnabled()) {
            _logger.debug("[Shipping Fee] calculation request:"
                    + request.toString());
        }

        return shipFeeCalculator.calculateShippingFee(request);
    }
    /* BEGIN BZ37912 */
    /**
     * @param shipMethodId
     * @return
     */
    @SuppressWarnings("static-access")
    public BigDecimal getShippingFeePrice(String shipMethodId, String itemId) {

        List<CawShippingGroupsModel> shippingGroupsModels = null;
        List<CawShippingItemsModel> shippingItemsModels = null;
        List<CawShipperMethodAPIModel> shipperMethodAPIModels = null;

        if (StringUtils.isNotEmpty(shipMethodId)
                && StringUtils.isNotEmpty(itemId)) {

            shippingGroupsModels = CawGetListsShippingFee.getShippingGroupsModels();

            if (CollectionUtils.isNotEmpty(shippingGroupsModels)) {
                
                for (CawShippingGroupsModel shippingGroup : shippingGroupsModels) {

                    shippingItemsModels = shippingGroup.getShippingItemsModels();

                    if (CollectionUtils.isNotEmpty(shippingItemsModels)) {
                        
                        for (CawShippingItemsModel item : shippingItemsModels) {
                            
                            if (itemId.equals(item.getItemCode())) {
                                
                                shipperMethodAPIModels = shippingGroup.getShipperMethodAPIModels();
                                
                                for (CawShipperMethodAPIModel shipMethod : shipperMethodAPIModels) {

                                    if (shipMethodId.equals(shipMethod.getShipperMethodId())) {
                                        return shipMethod.getFeePrice();
                                    }
                                }
                            }
                        }
                    }
                }
            }

        }
        return BigDecimal.ZERO;
    }
    /* END BZ37912 */

    /**
     * @param shipperMethodAPIModels
     * @param shipperMethodAPIModel
     * @return
     */
    public boolean isExistedShipperMethod(
            List<CawShipperMethodAPIModel> shipperMethodAPIModels,
            CawShipperMethodAPIModel shipperMethodAPIModel) {

        boolean isExisted = false;

        for (int i = 0; i < shipperMethodAPIModels.size(); i++) {

            CawShipperMethodAPIModel sApiModel = shipperMethodAPIModels.get(0);

            if (sApiModel != null && shipperMethodAPIModel != null) {
                if (sApiModel.getShipperMethodId() != null
                        && sApiModel.getShipperMethodId()
                                .equalsIgnoreCase(shipperMethodAPIModel
                                        .getShipperMethodId())

                        && sApiModel.getShipperMethodDesc() != null
                        && sApiModel.getShipperMethodDesc()
                                .equalsIgnoreCase(shipperMethodAPIModel
                                        .getShipperMethodDesc())
                        && sApiModel.getFeePrice() != null
                        && (sApiModel.getFeePrice()
                                .compareTo(shipperMethodAPIModel
                                        .getFeePrice()) == 0)) {
                    isExisted = true;

                }
            }

        }
        return isExisted;
    }
    /* BEGIN BZ37912 */
    /**
     * @param hashTotalFee
     * @return
     */
    public BigDecimal getTotalOrderShippingFeeByGroup(HashMap<String, BigDecimal> hashTotalFee) {

        BigDecimal totalFeeByGroup = BigDecimal.ZERO;
        
        if (hashTotalFee != null && hashTotalFee.size() > 0) {
            
            for (BigDecimal total : hashTotalFee.values()) {
                
                totalFeeByGroup = totalFeeByGroup.add(total);
            }
        }
        return totalFeeByGroup;
    }
    /* END BZ37912 */
}
