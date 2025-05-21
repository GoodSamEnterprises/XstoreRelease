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
 * BZ25640          051518    New Requirement - Used Firearm System Process Redesign
 *===================================================================
 */

package caw.pos.register.ufa;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import dtv.xst.dao.crm.IParty;

public class CawUFAModel {

    private IParty       _customerParty;

    private CawUFADetail _firearmDetail;

    private String       _ebsItemCode;

    private String       _etrackId;

    private String       _storeId;                  //ID in salesChannel

    private String       _registerId;               //Terminal

    private String       _channelType   = "Retail";

    private String       _jsonCustomerDetail;

    private String       _jsonFirearmDetail;

    private String       _customerAccNumber;

    private int          _ebsStatusCode = 0;

    private long         _organizationId;

    private final Logger _logger        = LogManager
            .getLogger(CawUFAModel.class);

    public CawUFAModel() {

        _firearmDetail = new CawUFADetail();
    }

    public void setLayoutModel(CawUFALayoutModel model) {

        if (model != null) {
            this.setEtrackId(model.getUfaEtrackIdField());
        }
    }

    public CawUFALayoutModel getLayoutModel() {

        CawUFALayoutModel model = null;
        try {
            String modelTitle = getCustomerParty().getFirstName() + " "
                    + getCustomerParty().getLastName();
            model = new CawUFALayoutModel(modelTitle);
            model.updLayoutValues(this);
        } catch (Exception ex) {
            _logger.error("getLayoutModel-1", ex);
            model = new CawUFALayoutModel();
        }
        return model;
    }

    static class CawUFADetail {

        //Attributes required --------------------
        private String serialNumber; //": "87295729",

        private String upc;          //": "499920000014",

        private String retailPrice;  //": 450,

        private String vendorCost;   //": 200,

        private String manufacturer; //": "Beretta",

        private String importer;     //": "Browning",

        private String model;        //": "J85748",

        private String action;       //": "Lever Action",

        private String chamber;      //": "NA",

        private String firearmType;  //": "Pistol",

        private String magazineType; //": "Low Cap",

        private String caliberGauge; //": "10mm Auto",

        private String barrel;       //": "1-1/8in FS",

        private String departmentId; //": 64,

        private String classId;      //": 6401,

        private String subclassId;   //": 640102

        public CawUFADetail() {

            serialNumber = null;
        }

        /**
         * @return the serialNumber
         */
        public String getSerialNumber() {

            return serialNumber;
        }

        /**
         * @param argSerialNumber the serialNumber to set
         */
        public void setSerialNumber(String argSerialNumber) {

            serialNumber = argSerialNumber;
        }

        /**
         * @return the upc
         */
        public String getUpc() {

            return upc;
        }

        /**
         * @param argUpc the upc to set
         */
        public void setUpc(String argUpc) {

            upc = argUpc;
        }

        /**
         * @return the retailPrice
         */
        public String getRetailPrice() {

            return retailPrice;
        }

        /**
         * @param argRetailPrice the retailPrice to set
         */
        public void setRetailPrice(String argRetailPrice) {

            retailPrice = argRetailPrice;
        }

        /**
         * @return the vendorCost
         */
        public String getVendorCost() {

            return vendorCost;
        }

        /**
         * @param argVendorCost the vendorCost to set
         */
        public void setVendorCost(String argVendorCost) {

            vendorCost = argVendorCost;
        }

        /**
         * @return the manufacturer
         */
        public String getManufacturer() {

            return manufacturer;
        }

        /**
         * @param argManufacturer the manufacturer to set
         */
        public void setManufacturer(String argManufacturer) {

            manufacturer = argManufacturer;
        }

        /**
         * @return the importer
         */
        public String getImporter() {

            return importer;
        }

        /**
         * @param argImporter the importer to set
         */
        public void setImporter(String argImporter) {

            importer = argImporter;
        }

        /**
         * @return the model
         */
        public String getModel() {

            return model;
        }

        /**
         * @param argModel the model to set
         */
        public void setModel(String argModel) {

            model = argModel;
        }

        /**
         * @return the action
         */
        public String getAction() {

            return action;
        }

        /**
         * @param argAction the action to set
         */
        public void setAction(String argAction) {

            action = argAction;
        }

        /**
         * @return the chamber
         */
        public String getChamber() {

            return chamber;
        }

        /**
         * @param argChamber the chamber to set
         */
        public void setChamber(String argChamber) {

            chamber = argChamber;
        }

        /**
         * @return the firearmType
         */
        public String getFirearmType() {

            return firearmType;
        }

        /**
         * @param argFirearmType the firearmType to set
         */
        public void setFirearmType(String argFirearmType) {

            firearmType = argFirearmType;
        }

        /**
         * @return the magazineType
         */
        public String getMagazineType() {

            return magazineType;
        }

        /**
         * @param argMagazineType the magazineType to set
         */
        public void setMagazineType(String argMagazineType) {

            magazineType = argMagazineType;
        }

        /**
         * @return the caliberGauge
         */
        public String getCaliberGauge() {

            return caliberGauge;
        }

        /**
         * @param argCaliberGauge the caliberGauge to set
         */
        public void setCaliberGauge(String argCaliberGauge) {

            caliberGauge = argCaliberGauge;
        }

        /**
         * @return the barrel
         */
        public String getBarrel() {

            return barrel;
        }

        /**
         * @param argBarrel the barrel to set
         */
        public void setBarrel(String argBarrel) {

            barrel = argBarrel;
        }

        /**
         * @return the departmentId
         */
        public String getDepartmentId() {

            return departmentId;
        }

        /**
         * @param argDepartmentId the departmentId to set
         */
        public void setDepartmentId(String argDepartmentId) {

            departmentId = argDepartmentId;
        }

        /**
         * @return the classId
         */
        public String getClassId() {

            return classId;
        }

        /**
         * @param argClassId the classId to set
         */
        public void setClassId(String argClassId) {

            classId = argClassId;
        }

        /**
         * @return the subclassId
         */
        public String getSubclassId() {

            return subclassId;
        }

        /**
         * @param argSubclassId the subclassId to set
         */
        public void setSubclassId(String argSubclassId) {

            subclassId = argSubclassId;
        }

    }

    /**
     * @return the customerParty
     */
    public IParty getCustomerParty() {

        return _customerParty;
    }

    /**
     * @param argCustomerParty the customerParty to set
     */
    public void setCustomerParty(IParty argCustomerParty) {

        _customerParty = argCustomerParty;
    }

    /**
     * @return the firearmDetail
     */
    public CawUFADetail getFirearmDetail() {

        return _firearmDetail;
    }

    /**
     * @param argFirearm the firearm to set
     */
    public void setFirearmDetail(CawUFADetail argFirearmDetail) {

        _firearmDetail = argFirearmDetail;
    }

    /**
     * @return the ebsItemCode
     */
    public String getEbsItemCode() {

        return _ebsItemCode;
    }

    /**
     * @param argEbsItemCode the ebsItemCode to set
     */
    public void setEbsItemCode(String argEbsItemCode) {

        _ebsItemCode = argEbsItemCode;
    }

    /**
     * @return the etrackId
     */
    public String getEtrackId() {

        return _etrackId;
    }

    /**
     * @param argEtrackId the etrackId to set
     */
    public void setEtrackId(String argEtrackId) {

        _etrackId = argEtrackId;
    }

    /**
     * @return the storeId
     */
    public String getStoreId() {

        return _storeId;
    }

    /**
     * @param argStoreId the storeId to set
     */
    public void setStoreId(String argStoreId) {

        _storeId = argStoreId;
    }

    /**
     * @return the registerId
     */
    public String getRegisterId() {

        return _registerId;
    }

    /**
     * @param argRegisterId the registerId to set
     */
    public void setRegisterId(String argRegisterId) {

        _registerId = argRegisterId;
    }

    /**
     * @return the channelType
     */
    public String getChannelType() {

        return _channelType;
    }

    /**
     * @param argChannelType the channelType to set
     */
    public void setChannelType(String argChannelType) {

        _channelType = argChannelType;
    }

    /**
     * @return the jsonFirearmDetail
     */
    public String getJsonFirearmDetail() {

        return _jsonFirearmDetail;
    }

    /**
     * @param argJsonFirearmDetail the jsonFirearmDetail to set
     */
    public void setJsonFirearmDetail(String argJsonFirearmDetail) {

        _jsonFirearmDetail = argJsonFirearmDetail;
    }

    /**
     * @return the ebsStatusCode
     */
    public int getEbsStatusCode() {

        return _ebsStatusCode;
    }

    /**
     * @param argEbsStatusCode the ebsStatusCode to set
     */
    public void setEbsStatusCode(int argEbsStatusCode) {

        _ebsStatusCode = argEbsStatusCode;
    }

    /**
     * @return the organizationId
     */
    public long getOrganizationId() {

        return _organizationId;
    }

    /**
     * @param argOrganizationId the organizationId to set
     */
    public void setOrganizationId(long argOrganizationId) {

        _organizationId = argOrganizationId;
    }

    /**
     * @return the jsonCustomerDetail
     */
    public String getJsonCustomerDetail() {

        return _jsonCustomerDetail;
    }

    /**
     * @param argJsonCustomerDetail the jsonCustomerDetail to set
     */
    public void setJsonCustomerDetail(String argJsonCustomerDetail) {

        _jsonCustomerDetail = argJsonCustomerDetail;
    }

    /**
     * @return the customerAccNumber
     */
    public String getCustomerAccNumber() {

        return _customerAccNumber;
    }

    /**
     * @param argCustomerAccNumber the customerAccNumber to set
     */
    public void setCustomerAccNumber(String argCustomerAccNumber) {

        _customerAccNumber = argCustomerAccNumber;
    }

}
