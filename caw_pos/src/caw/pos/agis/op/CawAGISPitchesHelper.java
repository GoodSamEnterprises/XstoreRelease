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
 * BZ61159          230224    [New Requirement] - Xstore AGIS Replacement
 * BZ62142          020324    [Internal]- The price of membership item shows incorrectly on the Pitches form and Sale screen.
 * BZ62146          060324    [Internal] - The membership information should show on the Membership Info Tab.
 * BZ62567          180324    [Internal] - Pitches information in the Order Service request shows incorrectly.
 * BZ69391          020625    [AGIS Modification] - Update Pitches form to be able to add non-membership items (Section 2.1.4)
 * BZ69389          020625    [AGIS Modification] - Update UI to display membership item by group (Section 2.1.2)
 * BZ69390          020625    [AGIS Modification] - Update Last Chance Prompt to handle grouping (Section 2.1.3)
 *===================================================================
 */

package caw.pos.agis.op;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import caw.pos.agis.model.CawAGISPitchesItemModel;
import caw.pos.agis.model.CawAGISPitchesModel;
import caw.pos.common.*;
import caw.tenderauth.impl.eigen.goodsam.common.CawCustomerGSHelper;
import twitter4j.*;

import dtv.data2.access.DataFactory;
import dtv.pos.framework.scope.TransactionScope;
import dtv.xst.dao.trn.IPosTransactionProperty;

/**
 *
 */
public class CawAGISPitchesHelper {

    private static volatile CawAGISPitchesHelper _instance       = null;
    private final String JSON_PITCHES = "pitches";
    private final String JSON_DECLINED = "declined";
    private final String JSON_ACCEPTED = "accepted";
    private final String STRING = "STRING";
    private final String STRING_TRUE = "TRUE";
    private final String JSON_ITEM_ID   = "itemCode";
    private final String JSON_PITCHES_ITEM = "pitchItems";
    private static final Logger _logger = LogManager.getLogger(CawAGISPitchesHelper.class);
    
    public static CawAGISPitchesHelper getInstance() {

        if (_instance == null) {
            synchronized (CawCustomerGSHelper.class) {
                if (_instance == null) {
                    _instance = new CawAGISPitchesHelper();
                }
            }
        }
        return _instance;
    }
    
    public boolean isMakerPitchesForm(TransactionScope transactionScope ) {
        if (transactionScope.getValue(CawValueKeys.CAW_AGIS_PICHES_MODEL) !=null 
                && transactionScope.getValue(CawValueKeys.CAW_AGIS_PICHES_LENGTH) != null) {

            List<CawAGISPitchesItemModel> itemModels = transactionScope.getValue(CawValueKeys.CAW_AGIS_LIST_ACCEPTED);
            
            if (itemModels != null) {
                boolean hasValidItems = itemModels.stream()
                        .anyMatch(itemModel -> !itemModel.getItemCode().equals(CawConstants.CAW_MEMBERSHIP_OPTION_CODE) &&
                                                !itemModel.getItemCode().equals(CawConstants.CAW_NOTHANKS_OPTION_CODE));
                    return hasValidItems;
            }
        }
       return false;
    }
    
    public void setTemporaryMembershipCard(TransactionScope transactionScope) {
        if(isMakerPitchesForm(transactionScope)) {
            IPosTransactionProperty transactionProperty = DataFactory.createObject(IPosTransactionProperty.class);
            transactionProperty.setPropertyCode(CawConstants.CAW_IS_TEMPOPARY_MEMBERSHIP_CARD);
            transactionProperty.setType(STRING);
            transactionProperty.setStringValue(STRING_TRUE);
            transactionScope.getTransaction().addPosTransactionProperty(transactionProperty);
        }
    }
    
    public boolean isLoadDataPitchesForm(TransactionScope transactionScope) {
        CawAGISPitchesModel cawAGISPitchesModels = transactionScope != null ? transactionScope.getValue(CawValueKeys.CAW_AGIS_PICHES_MODEL) : null;
        return cawAGISPitchesModels == null;
    }
  //BEGIN BZ69391,BZ69389,BZ69389
    public String updatePitchesFormResponse(TransactionScope transactionScope, String customerLookupResponse) {
        String result = customerLookupResponse;
        try {
            if(customerLookupResponse != null && customerLookupResponse.length() > 0) {
                JSONObject customerLookupResponseJson = new JSONObject(customerLookupResponse);
                if(customerLookupResponseJson.has(JSON_PITCHES) && !customerLookupResponseJson.isNull(JSON_PITCHES)
                        && transactionScope.getValue(CawValueKeys.CAW_AGIS_PICHES_MODEL) != null) {
                    JSONArray pitchesJsonArray = customerLookupResponseJson.getJSONArray(JSON_PITCHES);
                    
                    List<CawAGISPitchesItemModel> itemsAccept = transactionScope.getValue(CawValueKeys.CAW_AGIS_LIST_ACCEPTED);
                    
                    List<String> itemIDAccept = itemsAccept.stream()
                            .map(CawAGISPitchesItemModel::getItemCode)
                            .collect(Collectors.toList());
                    
                    for(int i = 0; i < pitchesJsonArray.length(); i++) {
                        JSONObject pitch = pitchesJsonArray.getJSONObject(i);
                        
                        JSONArray pitchArr = pitch.getJSONArray(JSON_PITCHES_ITEM);
                        
                        for(int j = 0; j < pitchArr.length(); j++) {
                            JSONObject item = pitchArr.getJSONObject(j);
                            if(itemIDAccept.contains(item.get(JSON_ITEM_ID))) {
                                pitch.put(JSON_ACCEPTED, true);
                                pitch.put(JSON_DECLINED, false);
                            }
                        }
                    }
                    result = customerLookupResponseJson.toString();
                }
            }
        } catch (Exception ex) {
            _logger.error("[Update Pitches Form Response Error]: " + ex.getMessage());
        }
        return result;
    }
    
    public String updatePitchesFormResponseForOffer(TransactionScope transactionScope, String customerLookupResponse) {
        String result = customerLookupResponse;
        try {
            if(customerLookupResponse != null && customerLookupResponse.length() > 0) {
                JSONObject customerLookupResponseJson = new JSONObject(customerLookupResponse);
                if(customerLookupResponseJson.has(JSON_PITCHES) && !customerLookupResponseJson.isNull(JSON_PITCHES)
                        && transactionScope.getValue(CawValueKeys.CAW_AGIS_PICHES_MODEL) != null) {
                    JSONArray pitchesJsonArray = customerLookupResponseJson.getJSONArray(JSON_PITCHES);
                    
                    List<CawAGISPitchesItemModel> itemsAccept = transactionScope.getValue(CawValueKeys.CAW_AGIS_LIST_ACCEPTED);
                    
                    List<String> itemIDAccept = itemsAccept.stream()
                            .map(CawAGISPitchesItemModel::getItemCode)
                            .collect(Collectors.toList());
                    
                    for(int i = 0; i < pitchesJsonArray.length(); i++) {
                        JSONObject pitch = pitchesJsonArray.getJSONObject(i);
                        
                        JSONArray pitchArr = pitch.getJSONArray(JSON_PITCHES_ITEM);
                        
                        for(int j = 0; j < pitchArr.length(); j++) {
                            JSONObject item = pitchArr.getJSONObject(j);
                            if(itemIDAccept.contains(item.get(JSON_ITEM_ID))) {
                                pitch.put(JSON_ACCEPTED, true);
                                pitch.put(JSON_DECLINED, false);
                            }
                        }
                    }
                    result = customerLookupResponseJson.toString();
                }
            }
        } catch (Exception ex) {
            _logger.error("[Update Pitches Form Response Error]: " + ex.getMessage());
        }
        return result;
    }
    
    public BigDecimal getPriceByItemId(CawAGISPitchesModel cawPitchesModel, int pitchesJsonLength, String itemId) {
        //BEGIN BZ62142
        BigDecimal itemPrice = BigDecimal.ZERO;
        List<CawAGISPitchesItemModel> listItems =  new ArrayList<CawAGISPitchesItemModel>();
        listItems.addAll(cawPitchesModel.getPitchItemsGroup1());
        listItems.addAll(cawPitchesModel.getPitchItemsGroup2());
        for (CawAGISPitchesItemModel item : listItems) {           
            if(item.getItemCode().equals(itemId)) {
                itemPrice = BigDecimal.valueOf(item.getPlanPrice());
                break;
            }
        }
        //END BZ62142
        return itemPrice;
    }
    
    public String getDescriptionByItemId(CawAGISPitchesModel cawPitchesModel, int pitchesJsonLength, String itemId) {
        //BEGIN BZ62142
        String itemDescription = "";
        List<CawAGISPitchesItemModel> listItems =  new ArrayList<CawAGISPitchesItemModel>();
        listItems.addAll(cawPitchesModel.getPitchItemsGroup1());
        listItems.addAll(cawPitchesModel.getPitchItemsGroup2());
        for (CawAGISPitchesItemModel item : listItems) {           
            if(item.getItemCode().equals(itemId)) {
                itemDescription = item.getDescriptions();
                break;
            }
        }
        //END BZ62142
        return itemDescription;
    }
    //BEGIN BZ62146
    public Boolean getAutoRenewByItemId(CawAGISPitchesModel cawPitchesModel, int pitchesJsonLength, String itemId) {
        Boolean autoRenew = Boolean.FALSE;
        List<CawAGISPitchesItemModel> listItems =  new ArrayList<CawAGISPitchesItemModel>();
        listItems.addAll(cawPitchesModel.getPitchItemsGroup1());
        listItems.addAll(cawPitchesModel.getPitchItemsGroup2());
        for (CawAGISPitchesItemModel item : listItems) {           
            if(item.getItemCode().equals(itemId)) {
                autoRenew = item.isAutoRenew();
                break;
            }
        }
        return autoRenew;
    }
    //END BZ62146
    
    public String updatePitchesJson(TransactionScope transactionScope ,CawAGISPitchesModel cawPitchesModel, String pitchesString) {
        String result = pitchesString;
        try {
            if(pitchesString != null && pitchesString.length() > 0) {
                JSONObject customerLookupResponseJson = new JSONObject(pitchesString);
                if(customerLookupResponseJson.has(JSON_PITCHES) && !customerLookupResponseJson.isNull(JSON_PITCHES)
                        && transactionScope.getValue(CawValueKeys.CAW_AGIS_PICHES_MODEL) != null) {
                    JSONArray pitchesJsonArray = customerLookupResponseJson.getJSONArray(JSON_PITCHES);
                    
                    List<CawAGISPitchesItemModel> itemsAccept = transactionScope.getValue(CawValueKeys.CAW_AGIS_LIST_ACCEPTED);
                    
                    List<String> itemIDAccept = itemsAccept.stream()
                            .map(CawAGISPitchesItemModel::getItemCode)
                            .collect(Collectors.toList());
                    
                    for(int i = 0; i < pitchesJsonArray.length(); i++) {
                        JSONObject pitch = pitchesJsonArray.getJSONObject(i);
                        
                        JSONArray pitchArr = pitch.getJSONArray(JSON_PITCHES_ITEM);
                        
                        for(int j = 0; j < pitchArr.length(); j++) {
                            JSONObject item = pitchArr.getJSONObject(j);
                            if(itemIDAccept.contains(item.get(JSON_ITEM_ID))) {
                                pitch.put(JSON_ACCEPTED, true);
                                pitch.put(JSON_DECLINED, false);
                            }
                        }
                    }
                    result = customerLookupResponseJson.toString();
                }
            }
        } catch (Exception ex) {
            _logger.error("[Update Pitches Form Response Error]: " + ex.getMessage());
        }
        return result;
    }
    
    //END BZ69391,BZ69389,BZ69389
}
