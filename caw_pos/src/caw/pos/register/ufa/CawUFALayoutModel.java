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

import static dtv.pos.iframework.form.IEditModelFieldMetadata.ATTR_NEW;
import static dtv.pos.iframework.form.IEditModelFieldMetadata.ATTR_NO_SETTER;

import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import oracle.retail.xstore.itm.custitem.CustItemResult;

import dtv.pos.customer.custitem.CustItemListModel;
import dtv.pos.framework.form.BasicEditModel;
import dtv.xst.dao.crm.IPartyLocaleInformation;

public class CawUFALayoutModel extends BasicEditModel {

    private static final Logger logger_ = LogManager
            .getLogger(CawUFALayoutModel.class);

    private String              ufaEtrackIdField;

    private String              ufaCustomerNameField;

    private String              ufaCustomerAddressField;

    private String              ufaCustomerCountryField;

    private String              ufaCustomerPhoneField;

    private String              ufaPaidOutAmtField;

    private String              ufaSerialNbrField;

    private String              ufaUPCField;

    private String              ufaModelField;

    private String              ufaManufacturerField;

    private String              ufaImporterField;

    private String              ufaActionField;

    private String              ufaFirearmTypeField;

    private String              ufaChamberField;

    private String              ufaMagazineTypeField;

    private String              ufaCaliberGaugeField;

    private String              ufaBarrelField;

    private String              ufaDepInfoField;

    private String              ufaClassInfoField;

    private String              ufaSubclassInfoField;

    private CustItemListModel   ufaFirearmList;

    public CawUFALayoutModel() {

        super(FF.getTranslatable("_caw_ufa_prompt_title"), FF
                .getTranslatable("_caw_ufa_promtview"));
        iniLayoutFields();
    }

    public CawUFALayoutModel(String modelTitle) {

        super(FF.getSimpleFormattable(modelTitle), FF
                .getSimpleFormattable(" "));
        iniLayoutFields();
    }

    private void iniLayoutFields() {

        addField("ufaEtrackIdField", String.class);

        addField("ufaCustomerNameField", String.class);
        addField("ufaCustomerAddressField", String.class);
        addField("ufaCustomerCountryField", String.class);
        addField("ufaCustomerPhoneField", String.class);

        addField("ufaPaidOutAmtField", String.class);
        addField("ufaSerialNbrField", String.class);
        addField("ufaUPCField", String.class);
        addField("ufaModelField", String.class);
        addField("ufaManufacturerField", String.class);
        addField("ufaImporterField", String.class);
        addField("ufaActionField", String.class);
        addField("ufaChamberField", String.class);
        addField("ufaFirearmTypeField", String.class);
        addField("ufaMagazineTypeField", String.class);
        addField("ufaCaliberGaugeField", String.class);
        addField("ufaBarrelField", String.class);
        addField("ufaDepInfoField", String.class);
        addField("ufaClassInfoField", String.class);
        addField("ufaSubclassInfoField", String.class);

        addField("ufaFirearmList", CustItemListModel.class, ATTR_NEW
                + ATTR_NO_SETTER);

        ufaEtrackIdField = "";

        ufaCustomerNameField = "";
        ufaCustomerAddressField = "";
        ufaCustomerCountryField = "";
        ufaCustomerPhoneField = "";

        ufaPaidOutAmtField = "";
        ufaSerialNbrField = "";
        ufaUPCField = "";
        ufaModelField = "";
        ufaManufacturerField = "";
        ufaImporterField = "";
        ufaActionField = "";
        ufaFirearmTypeField = "";
        ufaChamberField = "";
        ufaMagazineTypeField = "";
        ufaCaliberGaugeField = "";
        ufaBarrelField = "";
        ufaDepInfoField = "";
        ufaClassInfoField = "";
        ufaSubclassInfoField = "";
        ufaFirearmList = null;

    }

    /**
     * Update values for Layout Model
     * @param model
     */
    public void updLayoutValues(CawUFAModel model) {

        CawUFAConstants myutil = CawUFAConstants.getInstance();
        //Part 1: common fields
        //setValue("ufaEtrackIdField", model.getEtrackId());
        setUfaEtrackIdField(myutil.vString(model.getEtrackId()));

        //Part 2: customer fields
        if (model.getCustomerParty() != null) {
            String customerName = model.getCustomerParty().getFirstName() + " "
                    + model.getCustomerParty().getLastName();
            StringBuilder address = new StringBuilder();
            String country = null;
            String telephone = null;

            List<IPartyLocaleInformation> adds = model.getCustomerParty()
                    .getLocaleInformation();
            if (adds != null && adds.size() > 0) {
                IPartyLocaleInformation locAddress = adds.get(0);
                address.append(locAddress.getAddress1());
                address.append(", ");
                address.append(locAddress.getCity());
                address.append(", ");
                address.append(locAddress.getState());
                address.append(" ");
                address.append(locAddress.getPostalCode());

                country = locAddress.getCountry();
            }
            if (country == null) {
                country = model.getCustomerParty().getCountry();
            }
            telephone = model.getCustomerParty().getTelephone1();

            setUfaCustomerNameField(myutil.vString(customerName));
            setUfaCustomerAddressField(myutil.vString(address.toString()));
            setUfaCustomerCountryField(myutil.vString(country));
            setUfaCustomerPhoneField(myutil.vString(telephone));
        }

        //Part 3: Firearm fields
        if (model.getFirearmDetail() != null) {
            setUfaPaidOutAmtField(myutil
                    .vString(CawUFAConstants.DOLLAR_SIGN + myutil.vString(model
                            .getFirearmDetail().getVendorCost())));
            setUfaSerialNbrField(myutil
                    .vString(model.getFirearmDetail().getSerialNumber()));
            setUfaUPCField(myutil.vString(model.getFirearmDetail().getUpc()));
            setUfaModelField(myutil
                    .vString(model.getFirearmDetail().getModel()));
            setUfaManufacturerField(myutil
                    .vString(model.getFirearmDetail().getManufacturer()));
            setUfaImporterField(myutil
                    .vString(model.getFirearmDetail().getImporter()));
            setUfaActionField(myutil
                    .vString(model.getFirearmDetail().getAction()));
            setUfaChamberField(myutil
                    .vString(model.getFirearmDetail().getChamber()));
            setUfaFirearmTypeField(myutil
                    .vString(model.getFirearmDetail().getFirearmType()));
            setUfaMagazineTypeField(myutil
                    .vString(model.getFirearmDetail().getMagazineType()));
            setUfaCaliberGaugeField(myutil
                    .vString(model.getFirearmDetail().getCaliberGauge()));
            setUfaBarrelField(myutil
                    .vString(model.getFirearmDetail().getBarrel()));

            loadMachandiseHier(model.getOrganizationId(), model
                    .getFirearmDetail().getDepartmentId(), model
                            .getFirearmDetail().getClassId(), model
                                    .getFirearmDetail().getSubclassId());
        }

        CustItemListModel list = new CustItemListModel();
        List<CustItemResult> items = new ArrayList<CustItemResult>();
        list.setItems(items);
        setUfaFirearmList(list);
    }

    /**
     * Get name of department, Class, subclass from xStore DB
     */
    private void loadMachandiseHier(long orgId, String depId, String classId,
            String subclassId) {

        try {
            String depName = "";
            String claName = "";
            String subclName = "";
            //Get name for departmentId, classId, subclassId
            depName = CawUFAQueryHelper.getMachandiseHierDesc(orgId, depId);
            claName = CawUFAQueryHelper.getMachandiseHierDesc(orgId, classId);

            //Issue that subclassId is short number depending on from ESB Neuron response
            String tmp = CawUFAConstants.getSubString(0, 4, subclassId);
            String hierClassId = depId + tmp;
            subclName = CawUFAQueryHelper
                    .getMachandiseHierDesc(orgId, hierClassId);
            this.setUfaDepInfoField(depName + " - " + depId);
            this.setUfaClassInfoField(claName + " - " + classId);
            this.setUfaSubclassInfoField(subclName + " - " + hierClassId);
        } catch (Exception ex) {
            logger_.error("updateMachandiseHier: Cannot read name of department, class and sub-class", ex);
        }
    }

    /**
     * @return the ufaEtrackIdField
     */
    public String getUfaEtrackIdField() {

        return ufaEtrackIdField;
    }

    /**
     * @param argUfaEtrackIdField the ufaEtrackIdField to set
     */
    public void setUfaEtrackIdField(String argUfaEtrackIdField) {

        ufaEtrackIdField = argUfaEtrackIdField;
    }

    /**
     * @return the ufaPaidOutAmtField
     */
    public String getUfaPaidOutAmtField() {

        return ufaPaidOutAmtField;
    }

    /**
     * @param argUfaPaidOutAmtField the ufaPaidOutAmtField to set
     */
    public void setUfaPaidOutAmtField(String argUfaPaidOutAmtField) {

        ufaPaidOutAmtField = argUfaPaidOutAmtField;
    }

    /**
     * @return the ufaSerialNbrField
     */
    public String getUfaSerialNbrField() {

        return ufaSerialNbrField;
    }

    /**
     * @param argUfaSerialNbrField the ufaSerialNbrField to set
     */
    public void setUfaSerialNbrField(String argUfaSerialNbrField) {

        ufaSerialNbrField = argUfaSerialNbrField;
    }

    /**
     * @return the ufaUPCField
     */
    public String getUfaUPCField() {

        return ufaUPCField;
    }

    /**
     * @param argUfaUPCField the ufaUPCField to set
     */
    public void setUfaUPCField(String argUfaUPCField) {

        ufaUPCField = argUfaUPCField;
    }

    /**
     * @return the ufaModelField
     */
    public String getUfaModelField() {

        return ufaModelField;
    }

    /**
     * @param argUfaModelField the ufaModelField to set
     */
    public void setUfaModelField(String argUfaModelField) {

        ufaModelField = argUfaModelField;
    }

    /**
     * @return the ufaManufacturerField
     */
    public String getUfaManufacturerField() {

        return ufaManufacturerField;
    }

    /**
     * @param argUfaManufacturerField the ufaManufacturerField to set
     */
    public void setUfaManufacturerField(String argUfaManufacturerField) {

        ufaManufacturerField = argUfaManufacturerField;
    }

    /**
     * @return the ufaImporterField
     */
    public String getUfaImporterField() {

        return ufaImporterField;
    }

    /**
     * @param argUfaImporterField the ufaImporterField to set
     */
    public void setUfaImporterField(String argUfaImporterField) {

        ufaImporterField = argUfaImporterField;
    }

    /**
     * @return the ufaActionField
     */
    public String getUfaActionField() {

        return ufaActionField;
    }

    /**
     * @param argUfaActionField the ufaActionField to set
     */
    public void setUfaActionField(String argUfaActionField) {

        ufaActionField = argUfaActionField;
    }

    /**
     * @return the ufaFirearmTypeField
     */
    public String getUfaFirearmTypeField() {

        return ufaFirearmTypeField;
    }

    /**
     * @param argUfaFirearmTypeField the ufaFirearmTypeField to set
     */
    public void setUfaFirearmTypeField(String argUfaFirearmTypeField) {

        ufaFirearmTypeField = argUfaFirearmTypeField;
    }

    /**
     * @return the ufaDepInfoField
     */
    public String getUfaDepInfoField() {

        return ufaDepInfoField;
    }

    /**
     * @param argUfaDepInfoField the ufaDepInfoField to set
     */
    public void setUfaDepInfoField(String argUfaDepInfoField) {

        ufaDepInfoField = argUfaDepInfoField;
    }

    /**
     * @return the ufaClassInfoField
     */
    public String getUfaClassInfoField() {

        return ufaClassInfoField;
    }

    /**
     * @param argUfaClassInfoField the ufaClassInfoField to set
     */
    public void setUfaClassInfoField(String argUfaClassInfoField) {

        ufaClassInfoField = argUfaClassInfoField;
    }

    /**
     * @return the ufaSubclassInfoField
     */
    public String getUfaSubclassInfoField() {

        return ufaSubclassInfoField;
    }

    /**
     * @param argUfaSubclassInfoField the ufaSubclassInfoField to set
     */
    public void setUfaSubclassInfoField(String argUfaSubclassInfoField) {

        ufaSubclassInfoField = argUfaSubclassInfoField;
    }

    /**
     * @return the ufaMagazineTypeField
     */
    public String getUfaMagazineTypeField() {

        return ufaMagazineTypeField;
    }

    /**
     * @param argUfaMagazineTypeField the ufaMagazineTypeField to set
     */
    public void setUfaMagazineTypeField(String argUfaMagazineTypeField) {

        ufaMagazineTypeField = argUfaMagazineTypeField;
    }

    /**
     * @return the ufaCaliberGaugeField
     */
    public String getUfaCaliberGaugeField() {

        return ufaCaliberGaugeField;
    }

    /**
     * @param argUfaCaliberGaugeField the ufaCaliberGaugeField to set
     */
    public void setUfaCaliberGaugeField(String argUfaCaliberGaugeField) {

        ufaCaliberGaugeField = argUfaCaliberGaugeField;
    }

    /**
     * @return the ufaBarrelField
     */
    public String getUfaBarrelField() {

        return ufaBarrelField;
    }

    /**
     * @param argUfaBarrelField the ufaBarrelField to set
     */
    public void setUfaBarrelField(String argUfaBarrelField) {

        ufaBarrelField = argUfaBarrelField;
    }

    /**
     * @return the ufaChamberField
     */
    public String getUfaChamberField() {

        return ufaChamberField;
    }

    /**
     * @param argUfaChamberField the ufaChamberField to set
     */
    public void setUfaChamberField(String argUfaChamberField) {

        ufaChamberField = argUfaChamberField;
    }

    /**
     * @return the ufaCustomerNameField
     */
    public String getUfaCustomerNameField() {

        return ufaCustomerNameField;
    }

    /**
     * @param argUfaCustomerNameField the ufaCustomerNameField to set
     */
    public void setUfaCustomerNameField(String argUfaCustomerNameField) {

        ufaCustomerNameField = argUfaCustomerNameField;
    }

    /**
     * @return the ufaCustomerAddressField
     */
    public String getUfaCustomerAddressField() {

        return ufaCustomerAddressField;
    }

    /**
     * @param argUfaCustomerAddressField the ufaCustomerAddressField to set
     */
    public void setUfaCustomerAddressField(String argUfaCustomerAddressField) {

        ufaCustomerAddressField = argUfaCustomerAddressField;
    }

    /**
     * @return the ufaCustomerCountryField
     */
    public String getUfaCustomerCountryField() {

        return ufaCustomerCountryField;
    }

    /**
     * @param argUfaCustomerCountryField the ufaCustomerCountryField to set
     */
    public void setUfaCustomerCountryField(String argUfaCustomerCountryField) {

        ufaCustomerCountryField = argUfaCustomerCountryField;
    }

    /**
     * @return the ufaCustomerPhoneField
     */
    public String getUfaCustomerPhoneField() {

        return ufaCustomerPhoneField;
    }

    /**
     * @param argUfaCustomerPhoneField the ufaCustomerPhoneField to set
     */
    public void setUfaCustomerPhoneField(String argUfaCustomerPhoneField) {

        ufaCustomerPhoneField = argUfaCustomerPhoneField;
    }

    /**
     * @return the ufaFirearmList
     */
    public CustItemListModel getUfaFirearmList() {

        return ufaFirearmList;
    }

    /**
     * @param argUfaFirearmList the ufaFirearmList to set
     */
    public void setUfaFirearmList(CustItemListModel argUfaFirearmList) {

        ufaFirearmList = argUfaFirearmList;
    }

}
