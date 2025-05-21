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
 * BZ61159          160124    [New Requirement] - Xstore AGIS Replacement 
 * BZ62142          010324    [Internal]- The price of membership item shows incorrectly on the Pitches form and Sale screen.
 * BZ62146          060324    [Internal] - The membership information should show on the Membership Info Tab.
 * BZ69391          020625    [AGIS Modification] - Update Pitches form to be able to add non-membership items (Section 2.1.4)
 * BZ69389          020625    [AGIS Modification] - Update UI to display membership item by group (Section 2.1.2)
 * BZ69389          020625    [AGIS Modification] - Update Last Chance Prompt to handle grouping (Section 2.1.3)
 *===================================================================
 */

package caw.pos.agis.model;

import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;

import javax.inject.Inject;

import org.apache.commons.lang3.StringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.objectspace.jgl.Array;

import caw.pos.advance.prompting.CawCatalystHelper;
import caw.pos.common.*;
import twitter4j.*;

import dtv.i18n.FormattableFactory;
import dtv.pos.framework.scope.TransactionScope;
import dtv.pos.pricing.PriceProvider;
import dtv.pos.register.ItemLocator;
import dtv.xst.dao.itm.IItem;

/**
 *
 */
public class CawAGISPitchesLoadDataCustomerResponse {
    private static final        Logger logger_        = LogManager.getLogger(CawAGISPitchesLoadDataCustomerResponse.class);

    private final String        JSON_PITCHES   = "pitches";

    private final String        JSON_ITEM_ID   = "itemCode";

    private final String        JSON_IS_ACCEPT = "accepted";
    
    private final String        JSON_PITCHES_ITEM = "pitchItems";
    
    private final String        JSON_PITCHES_DESCRIPTION = "description";
    
    private final String        JSON_PRICING   = "pricing";
    
    private final String        JSON_IDENTIFIER = "identifier";
    
    private final String        JSON_PITCHES_PRICE = "planPrice";   // BZ62142
        
    private final String        JSON_IS_AUTO_RENEW = "isAutoRenew"; //BZ62146
 
    private final String        JSON_MAX_QUANTITY = "maxQuantity"; 
    
    private final String        JSON_PRODUCT_REFERENCE = "productReference"; 
    
    private final String        JSON_OFFER_REFERENCE = "offerReference"; 
    
    private final String        JSON_PLAN_REFERENCE = "planReference"; 
    
    private final String        JSON_DISTRIBUTION_CHANNEL = "distributionChannel"; 
    
    private final String        JSON_RESPONSE_METHOD = "responseMethod"; 
    
    @Inject
    protected FormattableFactory        fmFact = FormattableFactory.getInstance();;
    
    
    public CawAGISPitchesModel loadDataFromCustomerLookupResponse(TransactionScope transactionScope) {
        
        CawAGISPitchesModel cawAGISPitchesModel = null;
        String customerLookupResponse = CawCatalystHelper.getLookupResponseData();

        if (StringUtils.isNotEmpty(customerLookupResponse)) {
            JSONObject custLookup = CawJSONUtils.toJSONObject(customerLookupResponse);
            
            try {
                // Handle Pricing
                if (custLookup.has(JSON_PRICING) && !custLookup.isNull(JSON_PRICING) ) {
                    JSONObject pricing = custLookup.getJSONObject(JSON_PRICING);
                    if (pricing.has(JSON_IDENTIFIER)) {
                        transactionScope.setValue(CawValueKeys.CAW_AGIS_PRICING_ID,String.valueOf(pricing.getInt(JSON_IDENTIFIER)));
                    }
                }

                // Handle Pitches
                if (custLookup.has(JSON_PITCHES) && !custLookup.isNull(JSON_PITCHES) ) {
                    JSONArray jsonArray = custLookup.getJSONArray(JSON_PITCHES);
                    Map<String, List<CawAGISPitchesItemModel>> pitchMap = new HashMap<>();

                    for (int i = 0; i < jsonArray.length(); i++) {
                        JSONObject pitchGroup = jsonArray.getJSONObject(i);
                        String pitchGroupName = pitchGroup.getString("name");

                        JSONArray pitchItems = pitchGroup.getJSONArray(JSON_PITCHES_ITEM);
                        List<CawAGISPitchesItemModel> listPitch = new ArrayList<>();

                        for (int j = 0; j < pitchItems.length(); j++) {
                            listPitch.add(parsePitchItemToModel(pitchItems.getJSONObject(j)));
                        }

                        pitchMap.put(pitchGroupName, listPitch);
                    }

                    // Extract the first two pitch groups
                    List<Map.Entry<String, List<CawAGISPitchesItemModel>>> entryList = new ArrayList<>(pitchMap.entrySet());

                    String[] names = new String[10];
                    List<CawAGISPitchesItemModel>[] groups = new List[10];

                    // Initialize name and group arrays
                    for (int i = 0; i < 10; i++) {
                        names[i] = entryList.size() > i ? entryList.get(i).getKey() : null;
                        groups[i] = entryList.size() > i ? new ArrayList<>(entryList.get(i).getValue()) : new ArrayList<>();
                    }

                    // Create common options
                    CawAGISPitchesItemModel selectOptions = new CawAGISPitchesItemModel();
                    selectOptions.setItemCode(CawConstants.CAW_MEMBERSHIP_OPTION_CODE);
                    selectOptions.setDescriptions(fmFact.getTranslatable(CawConstants.CAW_MEMBERSHIP_OPTION_DES).toString());

                    CawAGISPitchesItemModel noThanksOptions = new CawAGISPitchesItemModel();
                    noThanksOptions.setItemCode(CawConstants.CAW_NOTHANKS_OPTION_CODE);
                    noThanksOptions.setDescriptions(fmFact.getTranslatable(CawConstants.CAW_NOTHANKS_OPTION_DES).toString());

                    // Add options to each group
                    for (int i = 0; i < 10; i++) {
                        if (groups[i] != null ) {
                            groups[i].add(0, selectOptions);
                            groups[i].add(noThanksOptions);
                        }
                    }

                    // Construct the CawAGISPitchesModel with all groups
                    cawAGISPitchesModel = new CawAGISPitchesModel(groups);
                    
                    cawAGISPitchesModel.setPitchGroupName1(names[0]);
                    cawAGISPitchesModel.setPitchGroupName2(names[1]);
                    cawAGISPitchesModel.setPitchGroupName3(names[2]);
                    cawAGISPitchesModel.setPitchGroupName4(names[3]);
                    cawAGISPitchesModel.setPitchGroupName5(names[4]);
                    cawAGISPitchesModel.setPitchGroupName6(names[5]);
                    cawAGISPitchesModel.setPitchGroupName7(names[6]);
                    cawAGISPitchesModel.setPitchGroupName8(names[7]);
                    cawAGISPitchesModel.setPitchGroupName9(names[8]);
                    cawAGISPitchesModel.setPitchGroupName10(names[9]);

                    cawAGISPitchesModel.setComboBoxGroup1(groups[0].isEmpty() ? new CawAGISPitchesItemModel() : groups[0].get(0));
                    cawAGISPitchesModel.setComboBoxGroup2(groups[1].isEmpty() ? new CawAGISPitchesItemModel() : groups[1].get(0));
                    cawAGISPitchesModel.setComboBoxGroup3(groups[2].isEmpty() ? new CawAGISPitchesItemModel() : groups[2].get(0));
                    cawAGISPitchesModel.setComboBoxGroup4(groups[3].isEmpty() ? new CawAGISPitchesItemModel() : groups[3].get(0));
                    cawAGISPitchesModel.setComboBoxGroup5(groups[4].isEmpty() ? new CawAGISPitchesItemModel() : groups[4].get(0));
                    cawAGISPitchesModel.setComboBoxGroup6(groups[5].isEmpty() ? new CawAGISPitchesItemModel() : groups[5].get(0));
                    cawAGISPitchesModel.setComboBoxGroup7(groups[6].isEmpty() ? new CawAGISPitchesItemModel() : groups[6].get(0));
                    cawAGISPitchesModel.setComboBoxGroup8(groups[7].isEmpty() ? new CawAGISPitchesItemModel() : groups[7].get(0));
                    cawAGISPitchesModel.setComboBoxGroup9(groups[8].isEmpty() ? new CawAGISPitchesItemModel() : groups[8].get(0));
                    cawAGISPitchesModel.setComboBoxGroup10(groups[9].isEmpty() ? new CawAGISPitchesItemModel() : groups[9].get(0));


                    // Store values in transaction scope
                    transactionScope.setValue(CawValueKeys.CAW_AGIS_PICHES_LENGTH, pitchMap.size());
                    transactionScope.setValue(CawValueKeys.CAW_AGIS_PITCHES_JSON, jsonArray.toString());
                }

            } catch (JSONException ex) {
                logger_.error("Error parsing customer lookup response: " + customerLookupResponse, ex);
            }
        }

        return cawAGISPitchesModel;

    }
    
    
    private CawAGISPitchesItemModel parsePitchItemToModel(JSONObject pitchItem) {
        CawAGISPitchesItemModel model = new CawAGISPitchesItemModel();

        if (pitchItem != null) {
            try {
                if (pitchItem.has(JSON_PITCHES_DESCRIPTION)) {
                    model.setDescriptions(pitchItem.getString(JSON_PITCHES_DESCRIPTION));
                }
                if (pitchItem.has(JSON_ITEM_ID)) {
                    model.setItemCode(pitchItem.getString(JSON_ITEM_ID));
                }
                if (pitchItem.has(JSON_MAX_QUANTITY)) {
                    model.setMaxQuantity(pitchItem.getInt(JSON_MAX_QUANTITY));
                }
                if (pitchItem.has(JSON_IS_AUTO_RENEW)) {
                    model.setAutoRenew(pitchItem.getBoolean(JSON_IS_AUTO_RENEW));
                }
                if (pitchItem.has(JSON_PITCHES_PRICE) ){
                    model.setPlanPrice(Double.parseDouble(pitchItem.getString(JSON_PITCHES_PRICE)));
                }
                if (pitchItem.has(JSON_PRODUCT_REFERENCE)) {
                    model.setProductReference(pitchItem.getString(JSON_PRODUCT_REFERENCE));
                }
                if (pitchItem.has(JSON_OFFER_REFERENCE)) {
                    model.setOfferReference(pitchItem.getString(JSON_OFFER_REFERENCE));
                }
                if (pitchItem.has(JSON_PLAN_REFERENCE)) {
                    model.setPlanReference(pitchItem.getString(JSON_PLAN_REFERENCE));
                }
                if (pitchItem.has(JSON_DISTRIBUTION_CHANNEL)) {
                    model.setDistributionChannel(pitchItem.getString("distributionChannel"));
                }
                if (pitchItem.has(JSON_RESPONSE_METHOD)) {
                    model.setResponseMethod(pitchItem.getString(JSON_RESPONSE_METHOD));
                }
            } catch (JSONException ex) {
                logger_.error("Error parsing customer lookup response: " + pitchItem, ex);
            }
        }
        
        return model;
    }

}
