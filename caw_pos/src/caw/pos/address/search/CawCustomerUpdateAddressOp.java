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
 * BZ26575          180618    [QAS] Update address verification flow to reduce the number of click in the QAS process
 * BZ61159          190224    [New Requirement] - Xstore AGIS Replacement
 *===================================================================
 */

package caw.pos.address.search;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.http.ResponseEntity;

import caw.pos.advance.prompting.CawCatalystHelper;
import caw.pos.common.*;
import caw.pos.customer.CawCustomerHelper;
import caw.pos.util.CawEBSHelper;
import twitter4j.JSONException;
import twitter4j.JSONObject;

import dtv.data2.access.DataFactory;
import dtv.data2.access.impl.DaoState;
import dtv.data2.access.impl.IDataModelImpl;
import dtv.pos.framework.op.Operation;
import dtv.pos.iframework.event.IXstEvent;
import dtv.pos.iframework.op.IOpResponse;
import dtv.pos.spring.ValueKeys;
import dtv.xst.dao.crm.*;

/**
 *
 */
public class CawCustomerUpdateAddressOp extends Operation {

    private static final Logger _logger            = LogManager.getLogger(CawCustomerUpdateAddressOp.class);

    private CawCustomerHelper   _cawCustomerHelper = CawCustomerHelper.getInstance();

    @Override
    public boolean isOperationApplicable() {

        if (getScopedValue(CawValueKeys.CAW_CUSTOMER_ADDRESS_INFO) != null) {
            return true;
        }

        return false;
    }

    @Override
    public IOpResponse handleOpExec(IXstEvent argArg0) {

        try {
            IPartyLocaleInformation localInformationQAS = getScopedValue(CawValueKeys.CAW_CUSTOMER_ADDRESS_INFO);
            if (localInformationQAS != null) {
                // Customer update address in database.
                IParty party = getScopedValue(ValueKeys.SELECTED_CUSTOMER);
                if (party != null) {
                    List<IPartyLocaleInformation> localInformations = party.getLocaleInformation();
                    if (localInformations != null && localInformations.size() > 0) {
                        // Change address of customer
                        IPartyLocaleInformation localInformation = this
                                .changeCustomerAddress(localInformations, localInformationQAS);
                        // Update address of the customer in database
                        if (localInformation != null) {
                            // Set mode update to model
                            ((IDataModelImpl) localInformation).getDAO().setObjectState(DaoState.UPDATED.intVal());
                            // Call command update to DB
                            DataFactory.makePersistent(localInformation);
                            //After update to database success. The customer address will update to current transaction.
                            localInformations.add(0, localInformation);
                            party.setLocaleInformation(localInformations);
                            setScopedValue(ValueKeys.SELECTED_CUSTOMER, party);
                        }
                    }
                }

                // The customer update address in ESB 
                String customerInfoStr = CawCatalystHelper.getLookupResponseData();
                Integer storeId = Integer.valueOf(_stationState.getRetailLocationId());
                String upsertRequest = this
                        .builRequestUpdateAddressOfcustomer(customerInfoStr, localInformationQAS, party, storeId);
                if (StringUtils.isNotEmpty(upsertRequest)) {
                    ResponseEntity<String> upSertResponse = CawEBSHelper.getInstance()
                            .upsertCustomterToEBS(upsertRequest);

                    if (upSertResponse != null && upSertResponse.getBody() != null && upSertResponse.getBody().length() > 0) { //BZ61159
                        _logger.info("Update address of customer success.");
                        CawCatalystHelper.setLookupResponseData(upSertResponse.getBody());
                    } else {
                        _logger.info("Can not update the address of the customer.");
                    }
                }
            }
        } catch (Exception ex) {
            _logger.error("Can not update address for the customer." + ex.getMessage());
        } finally {
            clearScopedValue(CawValueKeys.CAW_QAS_SEARCH_RESULT);
            clearScopedValue(CawValueKeys.IS_ADDRESS_DIALOG_DISPLAY);
            clearScopedValue(CawValueKeys.CAW_CUSTOMER_ADDRESS_INFO);
            clearScopedValue(CawValueKeys.CAW_CUSTOMER_ADDRESS_LINES);
        }

        return HELPER.completeResponse();

    }

    /**
     * The method update the customer address to database.
     * @param party
     */
    public IPartyLocaleInformation changeCustomerAddress(List<IPartyLocaleInformation> localInformations,
            IPartyLocaleInformation localInformationQAS) {

        IPartyLocaleInformation localInformation = null;
        if (localInformations != null && localInformations.size() > 0 && localInformationQAS != null) {
            // The current Xstore,  the customer only have address. Therefore we will get first element
            localInformation = localInformations.get(0);

            // Update info for customer
            if (StringUtils.isNotEmpty(localInformationQAS.getAddress1())) {
                localInformation.setAddress1(localInformationQAS.getAddress1());
            }

            if (StringUtils.isNotEmpty(localInformationQAS.getAddress2())) {
                localInformation.setAddress2(localInformationQAS.getAddress2());
            }

            if (StringUtils.isNotEmpty(localInformationQAS.getAddress3())) {
                localInformation.setAddress3(localInformationQAS.getAddress3());
            }

            if (StringUtils.isNotEmpty(localInformationQAS.getAddress4())) {
                localInformation.setAddress4(localInformationQAS.getAddress4());
            }

            if (StringUtils.isNotEmpty(localInformationQAS.getAddress4())) {
                localInformation.setAddress4(localInformationQAS.getAddress4());
            }

            if (StringUtils.isNotEmpty(localInformationQAS.getCity())) {
                localInformation.setCity(localInformationQAS.getCity());
            }

            if (StringUtils.isNotEmpty(localInformationQAS.getState())) {
                localInformation.setState(localInformationQAS.getState());
            }

            if (StringUtils.isNotEmpty(localInformationQAS.getPostalCode())) {
                localInformation.setPostalCode(localInformationQAS.getPostalCode());
            }
        }

        return localInformation;
    }

    /**
     * The method build Upsert request using update address of customer on ESB
     * If the customer can not get from ESB then request will build from local via
     * party
     * @param customerInfoStr
     */
    public String builRequestUpdateAddressOfcustomer(String customerInfoStr,
            IPartyLocaleInformation localInformationQAS, IParty party, Integer storeId) {

        String upsertRequestStr = null;

        if (StringUtils.isNotEmpty(customerInfoStr)) {
            _logger.debug("The customer information get from ESB." + customerInfoStr);
            try {
                JSONObject upsertRequestJson = new JSONObject();
                JSONObject salesChannelObj = new JSONObject();
                salesChannelObj.put(CawEBSConstant.SALES_CHANNEL_ID_ATTR, storeId);
                upsertRequestJson.put(CawEBSConstant.SALES_CHANNEL_ATTR, salesChannelObj);

                JSONObject customerJson = new JSONObject(customerInfoStr);

                JSONObject addressJson = makeOrUpdateAddressJSON(localInformationQAS, customerJson);
                if (addressJson != null) {
                    customerJson.put(CawJSONConstant.JSON_ADDRESS, addressJson);
                }

                upsertRequestJson.put(CawEBSConstant.THE_CUSTOMER_ATTR, customerJson);

                upsertRequestStr = upsertRequestJson.toString();
                _logger.debug("The Upsert request using update address of customer." + upsertRequestStr);
            } catch (Exception ex) {
                _logger.error("Can not build upsert request." + ex.getMessage());
            }
        } else {
            if (party != null) {
                List<IPartyIdCrossReference> partyIdCrossReferences = party.getAlternatePartyIds();
                if (partyIdCrossReferences != null && partyIdCrossReferences.size() > 0) {
                    IPartyIdCrossReference crossReference = partyIdCrossReferences.get(0);
                    if (StringUtils.isNotEmpty(crossReference.getAlternateId())) {
                        upsertRequestStr = _cawCustomerHelper
                                .buildUpsertRequest(party, CawJSONUtils.vLong(crossReference.getAlternateId()));
                        _logger.debug("The Upsert request build from party." + upsertRequestStr);
                    }
                }
            }
        }

        return upsertRequestStr;
    }

    /**
     * The method is build address information of the customer.
     * @param localInformationQAS
     * @param customerObj
     * @throws JSONException
     */
    private JSONObject makeOrUpdateAddressJSON(IPartyLocaleInformation localInformationQAS, JSONObject customerObj)
            throws JSONException {

        JSONObject addressJson = new JSONObject();
        // If the current customer has address then we have update the address.
        if (!customerObj.isNull(CawJSONConstant.JSON_ADDRESS)
                && customerObj.getJSONObject(CawJSONConstant.JSON_ADDRESS) != null) {
            addressJson = customerObj.getJSONObject(CawJSONConstant.JSON_ADDRESS);

            addressJson.put(CawJSONConstant.JSON_LINE1, CawJSONUtils
                    .convertToJsonValue(localInformationQAS.getAddress1()));

            addressJson.put(CawJSONConstant.JSON_LINE2, CawJSONUtils
                    .convertToJsonValue(localInformationQAS.getAddress2()));

            addressJson.put(CawJSONConstant.JSON_LINE3, CawJSONUtils
                    .convertToJsonValue(localInformationQAS.getAddress3()));

            addressJson.put(CawJSONConstant.JSON_LINE4, CawJSONUtils
                    .convertToJsonValue(localInformationQAS.getAddress4()));

            addressJson
                    .put(CawJSONConstant.JSON_COUNTY, CawJSONUtils.convertToJsonValue(localInformationQAS.getCounty()));

            addressJson.put(CawJSONConstant.JSON_CITY, CawJSONUtils.convertToJsonValue(localInformationQAS.getCity()));

            addressJson
                    .put(CawJSONConstant.JSON_STATE, CawJSONUtils.convertToJsonValue(localInformationQAS.getState()));

            addressJson.put(CawJSONConstant.JSON_POSTAL_CODE, CawJSONUtils
                    .convertToJsonValue(localInformationQAS.getPostalCode()));

        } else {
            // Mock-up the address of the customer 
            addressJson.put(CawJSONConstant.JSON_COUNTRY, CawJSONUtils
                    .convertToJsonValue(localInformationQAS.getCountry()));

            addressJson.put(CawJSONConstant.JSON_CITY, CawJSONUtils.convertToJsonValue(localInformationQAS.getCity()));

            addressJson.put(CawJSONConstant.JSON_ADDRESS_TYPE, CawJSONUtils
                    .convertToJsonValue(localInformationQAS.getAddressType()));

            addressJson.put(CawJSONConstant.JSON_POSTAL_CODE, CawJSONUtils
                    .convertToJsonValue(localInformationQAS.getPostalCode()));

            addressJson.put(CawJSONConstant.JSON_COUNTY, CawJSONUtils
                    .convertToJsonValue(localInformationQAS.getCountry()));

            addressJson
                    .put(CawJSONConstant.JSON_STATE, CawJSONUtils.convertToJsonValue(localInformationQAS.getState()));

            addressJson.put(CawJSONConstant.JSON_ADDRESS_TYPE_DESCRIPTION, CawJSONConstant.JSON_NOT_SPECIFIED);

            addressJson.put(CawJSONConstant.JSON_AUDIT, CawJSONConstant.SPACE_CHARACTER);

            addressJson.put(CawJSONConstant.JSON_IS_DELIVERABLE, CawJSONConstant.SPACE_CHARACTER);

            addressJson.put(CawJSONConstant.JSON_LINE1, CawJSONUtils
                    .convertToJsonValue(localInformationQAS.getAddress1()));
            addressJson.put(CawJSONConstant.JSON_LINE2, CawJSONUtils
                    .convertToJsonValue(localInformationQAS.getAddress2()));
            addressJson.put(CawJSONConstant.JSON_LINE3, CawJSONUtils
                    .convertToJsonValue(localInformationQAS.getAddress3()));
            addressJson.put(CawJSONConstant.JSON_LINE4, CawJSONUtils
                    .convertToJsonValue(localInformationQAS.getAddress4()));
        }

        return addressJson;
    }

}
