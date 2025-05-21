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
 * Req/Bug ID#          ddMMyy    Description
 * BZ30922              210619    [New Requirement] Price Check and Inventory Lookup
 *===================================================================
 */
package caw.pos.inventory.lookup;

import java.math.BigDecimal;
import java.util.List;

import caw.tenderauth.impl.eigen.constants.CawEigenConstants;

import dtv.data2.access.IDataModel;
import dtv.pos.framework.form.EditModelField;
import dtv.pos.i18n.format.MoneyFormatter;
import dtv.pos.iframework.form.ICardinality;
import dtv.pos.iframework.form.IEditModelField;
import dtv.pos.iframework.form.config.IDaoEditMappingConfig;
import dtv.pos.inventory.lookup.ItemResultsEditModel;
import dtv.pos.pricing.PriceProvider;
import dtv.pricing2.PriceContext;
import dtv.xst.dao.itm.IItem;

import static dtv.pos.iframework.form.IEditModelFieldMetadata.ATTR_NEW;
import static dtv.pos.iframework.form.IEditModelFieldMetadata.ATTR_NO_SETTER;

public class CawItemResultsPriceModel extends ItemResultsEditModel {

    private MoneyFormatter              _moneyFormatter           = new MoneyFormatter();
    public static final String          REGULAR_PRICE             = "regularPrice";
    public static final String          CLUB_PRICE                = "clubPrice";
    public static final String          WHOLESALE_PRICE           = "wholeSalePrice";
    public static final String          CREW_PRICE                = "crewPrice";
    public static final String          LIST_INVENTORY_STORE_INFO = "listInventoryStoreInfo";
    private String                      _regularPrice;
    private String                      _clubPrice;
    private String                      _wholeSalePrice;
    private String                      _crewPrice;
    private List<CawInventoryStoreInfo> _listInventoryStoreInfo   = null;

    /**
     * @return the listInventoryStoreInfo
     */
    public List<CawInventoryStoreInfo> getListInventoryStoreInfo() {
        return _listInventoryStoreInfo;
    }

    /**
     * @param argListInventoryStoreInfo the listInventoryStoreInfo to set
     */
    public void setListInventoryStoreInfo(List<CawInventoryStoreInfo> argListInventoryStoreInfo) {
        _listInventoryStoreInfo = argListInventoryStoreInfo;
    }
    
    
    /**
     * @return the regularPrice
     */
    public String getRegularPrice() {
        return _regularPrice;
    }

    /**
     * @param argRegularPrice the regularPrice to set
     */
    public void setRegularPrice(String argRegularPrice) {
        _regularPrice = argRegularPrice;
    }

    /**
     * @return the clubPrice
     */
    public String getClubPrice() {
        return _clubPrice;
    }

    /**
     * @param argClubPrice the clubPrice to set
     */
    public void setClubPrice(String argClubPrice) {
        _clubPrice = argClubPrice;
    }

    /**
     * @return the wholeSalePrice
     */
    public String getWholeSalePrice() {
        return _wholeSalePrice;
    }

    /**
     * @param argWholeSalePrice the wholeSalePrice to set
     */
    public void setWholeSalePrice(String argWholeSalePrice) {
        _wholeSalePrice = argWholeSalePrice;
    }

    /**
     * @return the crewPrice
     */
    public String getCrewPrice() {
        return _crewPrice;
    }

    /**
     * @param argCrewPrice the crewPrice to set
     */
    public void setCrewPrice(String argCrewPrice) {
        _crewPrice = argCrewPrice;
    }

    /**
     * 
     */
    public CawItemResultsPriceModel(IDataModel[] argDaos, IDaoEditMappingConfig argConfig, Boolean argIsNew) {
        super(argDaos, argConfig, argIsNew);

        addField(REGULAR_PRICE, String.class, ATTR_NEW + ATTR_NO_SETTER);
        addField(CLUB_PRICE, String.class, ATTR_NEW + ATTR_NO_SETTER);
        addField(WHOLESALE_PRICE, String.class, ATTR_NEW + ATTR_NO_SETTER);
        addField(CREW_PRICE, String.class, ATTR_NEW + ATTR_NO_SETTER);
        loadInventories();
        IEditModelField<?> inventoryStoreInfoField = EditModelField
                .makeFieldDefUnsafe(this, LIST_INVENTORY_STORE_INFO, List.class, ATTR_NEW
                        + ATTR_NO_SETTER, null, ICardinality.OPTIONAL, getListInventoryStoreInfo(), null, null, null);
        addField(inventoryStoreInfoField);
        initializeFieldState();
    }

    /**
     * 
     */
    @Override
    protected void initializeFieldValues() {
        super.initializeFieldValues();
        updateModelExtend();
        updateFieldValue();
    }

    /**
     * 
     */
    public void updateModelExtend() {

        setValue(REGULAR_PRICE, _regularPrice);
        setValue(CLUB_PRICE, _clubPrice);
        setValue(WHOLESALE_PRICE, _wholeSalePrice);
        setValue(CREW_PRICE, _crewPrice);
        setValue(LIST_INVENTORY_STORE_INFO, _listInventoryStoreInfo);
    }

    /**
     * 
     */
    public void updateFieldValue() {

        IItem item = getModeledItem();
        setRegularPrice(getPrice(item.getItemId(), "REGULAR_PRICE"));
        setClubPrice(getPrice(item.getItemId(), "CLUB"));
        setWholeSalePrice(getPrice(item.getItemId(), "WHSL"));
        setCrewPrice(getPrice(item.getItemId(), "CREW"));
    }

    /**
     * 
     */
    private String getPrice(String itemId, String priceType) {
        String formatPrice = "";
        PriceContext itemPrice = PriceProvider.getActualPrice(itemId, new BigDecimal(1), null, priceType);
        if (itemPrice != null) {
            formatPrice = CawEigenConstants.DOLLAR_SIGN + _moneyFormatter.format(itemPrice.getPrice(), null);
        }
        return formatPrice;
    }
    
    /**
     * 
     */
    private void loadInventories() {
        setListInventoryStoreInfo(CawInventoryLookupHelper.getInstance().getListInventoryStoreInfo());
    }
}
