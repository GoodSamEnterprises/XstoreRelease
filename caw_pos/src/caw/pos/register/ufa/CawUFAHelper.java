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
 * BZ30293          220419    [New Requirement] Update Test EBS URLs in Xstore to the new Neuron instances
 *===================================================================
 */

package caw.pos.register.ufa;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import caw.pos.common.*;
import caw.pos.customer.CawCustomerHelper;
import caw.pos.util.CawEBSHelper;
import twitter4j.JSONObject;

import dtv.data2.access.DataFactory;
import dtv.util.sequence.SequenceFactory;
import dtv.xst.dao.crm.IParty;

public class CawUFAHelper {

    private static final Logger          _logger               = LogManager
            .getLogger(CawUFAHelper.class);

    private static final String          JS_SERIAL_NUMBER      = "serialNumber"; //": "87295729",

    private static final String          JS_UPC                = "upc";          //": "499920000014",

    private static final String          JS_RETAIL_PRICE       = "retailPrice";  //": 450,

    private static final String          JS_VENDOR_COST        = "vendorCost";   //": 200,

    private static final String          JS_MFG                = "manufacturer"; //": "Beretta",

    private static final String          JS_IMP                = "importer";     //": "Browning",

    private static final String          JS_MODEL              = "model";        //": "J85748",

    private static final String          JS_ACTION             = "action";       //": "Lever Action",

    private static final String          JS_CHAMBER            = "chamber";      //": "NA",

    private static final String          JS_FIREARM_TYPE       = "firearmType";  //": "Pistol",

    private static final String          JS_MAGAZINE_TYPE      = "magazineType"; //": "Low Cap",

    private static final String          JS_CALIBER_GAUGE      = "caliberGauge"; //": "10mm Auto",

    private static final String          JS_BARREL             = "barrel";       //": "1-1/8in FS",

    private static final String          JS_DEP_ID             = "departmentId"; //": 64,

    private static final String          JS_CLASS_ID           = "classId";      //": 6401,

    private static final String          JS_SUBCLASS_ID        = "subclassId";   //": 102

    private static final String          JS_EBS_ITEM_CODE      = "ebsItemCode";

    private static final String          JS_EBS_CUSTOMER       = "customer";

    private static final String          JS_EBS_FIREARM_DETAIL = "firearmDetail";

    private static final String          JS_EBS_PHONES         = "phones";

    private static final String          JS_NUMBER             = "number";

    private static final int             NUERON_HTTP_OK        = 200;

    private static volatile CawUFAHelper instance              = null;

    private CawUFAHelper() {

        super();
    }

    /**
     * Returns a reference to the single instance of this object
     * 
     * @return CawUFAHelper
     */
    public static CawUFAHelper getInstance() {

        if (instance == null) {
            synchronized (CawUFAHelper.class) {
                if (instance == null) {
                    instance = new CawUFAHelper();
                }
            }
        }
        return instance;
    }

    /**
     * Get url from system properties
     * @return
     */
    private static String getDefaultUsedFirearmURL() {

        String url = System.getProperty("caw.pos.ufa.search.url");
        if (url == null || url.length() == 0) {
            _logger.error("getDefaultUsedFirearmURL-0: URL not found."); /*BZ30293: updated code to throw error instead of setting URL.*/
        }
        return url;
    }

    /**
     * build JSON UsedFirearm Request
     * @param eTrackId
     * @param storeId
     * @param registerId
     * @return
     */
    public String buildJSONUsedFirearmRequest(String eTrackId, String storeId,
            String registerId) {

        StringBuilder mgsJson = new StringBuilder();
        mgsJson.append("{ \"etrackId\":").append(eTrackId)
                .append(", \"salesChannel\": { \"id\": ").append(storeId)
                .append(", \"channelType\": \"Retail\", \"terminal\": ")
                .append(registerId).append(" } }");
        return mgsJson.toString();
    }

    /**
     * Send JSON request and get response 
     * for searching Used Firearm Purchase
     * @param mgsRequest
     * @return
     */
    public String sendJSONUsedFirearmRequest(String mgsRequest) {

        String body = mgsRequest;
        try {
            _logger.info("sendJSONUsedFirearmRequest-request: " + body);
            ResponseEntity<String> result = CawEBSHelper.getInstance()
                    .sendRequestToEBS(getDefaultUsedFirearmURL(), body);
            if (result != null) {
                _logger.info("sendJSONUsedFirearmRequest-response: "
                        + result.getStatusCode());
                if (result.getStatusCode() == HttpStatus.OK) {
                    String res = result.getBody();
                    _logger.info("sendJSONUsedFirearmRequest-response body: "
                            + res);
                    return res;
                }
            } else {
                _logger.info("sendJSONUsedFirearmRequest-response: Not found.");
            }
        } catch (Exception ex) {
            _logger.error("sendJSONUsedFirearmRequest-1", ex);
        }
        return null;
    }

    /**
     * Parse JSON response message to CawUFAModel object
     * @param mgsResponse
     * @param eTrackId
     * @param storeId
     * @param registerId
     * @param orgId
     * @return
     */
    public CawUFAModel parseJSONUsedFirearmResponse(String mgsResponse,
            String eTrackId, String storeId, String registerId, long orgId) {

        CawUFAModel model = null;
        if (mgsResponse != null && mgsResponse.length() > 0) {
            try {
                JSONObject jsonObject = new JSONObject(mgsResponse);
                model = new CawUFAModel();
                model.setEtrackId(eTrackId);
                model.setStoreId(storeId);
                model.setRegisterId(registerId);
                model.setOrganizationId(orgId);
                //1- For ebsItemCode, and general attributes
                model.setEbsItemCode(jsonObject.getString(JS_EBS_ITEM_CODE));

                //2-For Firearm Info ------------------------
                JSONObject firearmObject = CawJSONUtils
                        .getJSONObject(jsonObject, JS_EBS_FIREARM_DETAIL);
                CawUFAModel firearm = createFirearmDetailObjFromJson(firearmObject);
                if (firearm != null) {
                    model.setFirearmDetail(firearm.getFirearmDetail());
                    model.setJsonFirearmDetail(firearmObject.toString());
                }

                //3- For Customer Info ----------------------
                JSONObject customerObject = CawJSONUtils
                        .getJSONObject(jsonObject, JS_EBS_CUSTOMER);
                //JSONObject customerObject = new JSONObject(customerObject.toString());
                if (customerObject != null) {
                    //Reference to CawCustomerHelper.createPartyObjFromJson
                    IParty argCustomerParty = CawCustomerHelper.getInstance()
                            .createPartyObjFromJson(customerObject);
                    if (argCustomerParty != null) {
                        argCustomerParty.setOrganizationId(orgId);

                        argCustomerParty.setTelephone1(CawJSONUtils
                                .getString(customerObject, JS_EBS_PHONES, JS_NUMBER));

                        model.setCustomerParty(argCustomerParty);
                        model.setJsonCustomerDetail(customerObject.toString());
                        model.setCustomerAccNumber(CawJSONUtils
                                .getString(customerObject, CawJSONConstant.JSON_ACCOUNT_NUMBER));
                    }
                }
                model.setEbsStatusCode(NUERON_HTTP_OK);
            } catch (Exception ex) {
                _logger.error("parseJSONUsedFirearmResponse-1", ex);
                model = null;
            }
        }
        return model;
    }

    /**
     * Get/Set Firearm Info
     * @param firearmObject
     * @return
     */
    private CawUFAModel createFirearmDetailObjFromJson(
            JSONObject firearmObject) {

        CawUFAModel firearm = null;
        try {
            if (firearmObject != null) {
                firearm = new CawUFAModel();
                firearm.getFirearmDetail().setSerialNumber(firearmObject
                        .getString(JS_SERIAL_NUMBER));
                firearm.getFirearmDetail()
                        .setUpc(firearmObject.getString(JS_UPC));
                firearm.getFirearmDetail()
                        .setVendorCost(firearmObject.getString(JS_VENDOR_COST));
                firearm.getFirearmDetail().setRetailPrice(firearmObject
                        .getString(JS_RETAIL_PRICE));
                firearm.getFirearmDetail()
                        .setManufacturer(firearmObject.getString(JS_MFG));
                firearm.getFirearmDetail()
                        .setImporter(firearmObject.getString(JS_IMP));
                firearm.getFirearmDetail()
                        .setModel(firearmObject.getString(JS_MODEL));
                firearm.getFirearmDetail()
                        .setAction(firearmObject.getString(JS_ACTION));
                firearm.getFirearmDetail()
                        .setChamber(firearmObject.getString(JS_CHAMBER));
                firearm.getFirearmDetail().setFirearmType(firearmObject
                        .getString(JS_FIREARM_TYPE));
                firearm.getFirearmDetail().setMagazineType(firearmObject
                        .getString(JS_MAGAZINE_TYPE));
                firearm.getFirearmDetail().setCaliberGauge(firearmObject
                        .getString(JS_CALIBER_GAUGE));
                firearm.getFirearmDetail()
                        .setBarrel(firearmObject.getString(JS_BARREL));
                firearm.getFirearmDetail()
                        .setDepartmentId(firearmObject.getString(JS_DEP_ID));
                firearm.getFirearmDetail()
                        .setClassId(firearmObject.getString(JS_CLASS_ID));
                firearm.getFirearmDetail()
                        .setSubclassId(firearmObject.getString(JS_SUBCLASS_ID));
            }
        } catch (Exception ex) {
            _logger.error("createFirearmDetailObjFromJson-1", ex);
        }
        return firearm;
    }

    /**
     * Search for customer and used firearm in Neuron ESB
     * Step1: Build request and get response
     * Step2: Parse the response to save into Customer & Used Firearm Objects
     * Step3: Put these objects into memory
     * @param eTrackId
     * @param storeId
     * @param registerId
     * @param orgId
     * @return
     */
    public CawUFAModel searchUFA(String eTrackId, String storeId,
            String registerId, long orgId) {

        String mgsRequest = null;
        String mgsResponse = null;
        CawUFAModel model = null;

        try {
            //Look for Used Firearm & Customer via Neuron ESB
            mgsRequest = buildJSONUsedFirearmRequest(eTrackId, storeId, registerId);
            if (mgsRequest != null && mgsRequest.length() > 0) {
                mgsResponse = sendJSONUsedFirearmRequest(mgsRequest);
                if (mgsResponse != null && mgsResponse.length() > 0) {
                    model = parseJSONUsedFirearmResponse(mgsResponse, eTrackId, storeId, registerId, orgId);
                }
            }
            //Just for testing
            /*if (model == null) {
                model = createUsedFirearmResponseDefault();
            }*/
        } catch (Exception ex) {
            _logger.error("searchUFA-1", ex);
        }
        return model;
    }

    /**
     * Just for unit-test when Neuron in offline
     * @return
     */
    CawUFAModel createUsedFirearmResponseDefault() {

        CawUFAModel model = new CawUFAModel();

        model.setEtrackId("100");
        model.setStoreId("645");
        model.setRegisterId("2");
        model.setOrganizationId(1000);
        //1- For ebsItemCode, and general attributes
        model.setEbsItemCode("12345");

        CawUFAModel firearm = new CawUFAModel();
        firearm.getFirearmDetail().setSerialNumber("NH002");
        firearm.getFirearmDetail().setUpc("1234445555");
        firearm.getFirearmDetail().setDepartmentId("64");
        firearm.getFirearmDetail().setClassId("6403");
        firearm.getFirearmDetail().setSubclassId("302");
        model.setFirearmDetail(firearm.getFirearmDetail());
        model.setJsonFirearmDetail("test");

        //3- For Customer Info ----------------------
        IParty party = DataFactory.createObject(IParty.class);
        final long partySeq = SequenceFactory
                .getNextLongValue(CawEBSConstant.PARTY_SEQUENCE_ID);
        party.setOrganizationId(CawEBSConstant.ORGANIZATION_ID);
        party.setPartyId(partySeq);
        String custId = SequenceFactory
                .getNextStringValue(CawEBSConstant.CUSTOMER_SEQUENCE_ID);
        party.setCustomerId(custId);
        party.setPartyTypeCode(CawEBSConstant.CUSTOMER);
        model.setCustomerParty(party);
        model.setJsonCustomerDetail("Test2");
        model.setCustomerAccNumber("333333");
        model.setEbsStatusCode(NUERON_HTTP_OK);

        return model;
    }
}
