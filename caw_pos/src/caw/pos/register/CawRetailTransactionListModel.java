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
 * BZ23999          171017    New Changes to Sales Screen Required
 * BZ25318          300118    Missing Club information on top banner when sale/return transaction in offlined case.
 * BZ26471          050618    Club pricing doesn't show on top banner when doing Resume transaction has club/wholesale/Crew pricing
 * BZ27339          031018    [New Requirement] Display Membership Information on Xstore POS Information tab
 * BZ27851          121018    [Internal][27339] Membership info is empty at Account tab when select&View customer has membership info.
 * BZ29842          210319    [Internal][Xstore log] java.lang.IllegalArgumentException: A null value cannot be set in transaction scope is thrown into Xstore log unexpectedly.
 * BZ31523          250619    [Port BZ30263 to 5.0]Display GSC member savings in transaction
 * BZ31780          050719    [Internal] Help desk error occurs when choose Tender Exchange in BO
 * BZ33497          291019    [INTERNAL] EBS responded 400 107:Customer updates not allowedCustomer has Crew membership that prevents updates
 * BZ40798          240221    Modification to member savings calculation
 * BZ49497          060522    [Internal] Customer Loyalty Banner is displaying incorrectly when customer assigned is non-membership.
 * BZ61159          160124    [New Requirement] - Xstore AGIS Replacement
 * BZ62573          190324    [Internal] - ItemID should NOT display on the Banner Customer. 
 * BZ62987          040424    [Internal] The Banner customer and LOGO are displayed incorrectly when assigning a customer has GS Expired 
 * BZ69515          120225    Display Good Sam Visa Cardholder indicator Icon
 *===================================================================
 */

package caw.pos.register;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.*;
import java.util.stream.Collectors;

import javax.inject.Inject;

import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import caw.pos.advance.prompting.*;
import caw.pos.agis.model.CawAGISPitchesModel;
import caw.pos.araccount.CawCustomerUtil;
import caw.pos.common.*;
import caw.pos.common.rcpt.CawTotalAmountCouldSavedWorker;
import caw.pos.common.rcpt.CawTotalAmountSavedWorker;
import caw.pos.customer.CawCustomerConstants;
import caw.pos.customer.CawCustomerPartyIdXrefQueryResult;
import caw.pos.customer.membership.CawCustomerMembershipView;
import caw.pos.customer.membership.CawMembershipHelper;
import twitter4j.JSONObject;

import dtv.data2.access.DataFactory;
import dtv.data2.access.ObjectNotFoundException;
import dtv.i18n.*;
import dtv.pos.common.ConfigurationMgr;
import dtv.pos.customer.ICustomerUIHelper;
import dtv.pos.i18n.format.MoneyFormatter;
import dtv.pos.register.RetailTransactionListModel;
import dtv.util.NumberUtils;
import dtv.xst.dao.com.*;
import dtv.xst.dao.crm.IParty;
import dtv.xst.dao.trl.IRetailTransaction;
import dtv.xst.dao.trl.IRetailTransactionLineItem;
import dtv.xst.dao.trn.IPosTransaction;

/**
 *
 */
public class CawRetailTransactionListModel extends RetailTransactionListModel {

    /** The Constant SPACES_FIELD_KEY. */
    public static final String  SPACES_FIELD_KEY       = "   ";

    /** The Constant EXPIRED_DATE_FIELD_KEY. */
    public static final String  EXPIRED_DATE_FIELD_KEY = "Exp: ";

    /** The Constant PRICING_TAG. */
    public static final String  PRICING_TAG            = "pricing";

    /** The Constant MEMBERSHIP_TAG. */
    public static final String  MEMBERSHIP_TAG         = "membership";

    /** The Constant EXPIREDATE_TAG. */
    public static final String  EXPIREDATE_TAG         = "expireDate";

    /** The Constant IDENTIFIER_TAG. */
    // public static final String  IDENTIFIER_TAG         = "identifier"; //BZ62573

    /** The Constant BAND_TAG. */
    public static final String  BAND_TAG               = "band";

    /** The Constant DESCRIPTION_TAG. */
    public static final String  DESCRIPTION_TAG        = "description";

    public static final String  CLUB_SAVING_MESSAGE    = "clubSavingMessage";//BZ31523
    
    @Inject
    public ICustomerUIHelper    _customerUIHelper;

    private String              _cawLoyaltyIcon        = null;

    private String              _cawPricingDesc        = null;
    
    private String              _clubSavingMessage     = null;/*BZ31780*/
    
    private String              CAW_SPACE              = " ";
    //BEGIN BZ69515
    private final String JSON_CARDHOLDER                = "cardholder";
    private final String JSON_ISACTIVE                  = "isActive";
    private final String GS_VISA_ICON_ENABLED   = "GS_VISA_ICON_ENABLED";
	//END BZ69515
    /*BEGIN BZ31523*/
    @Inject
    protected FormattableFactory _ff;
    
    @Inject
    private CawMembershipActivityHelper _membershipHelper;

    /**
     * @return the cLUB_SAVING_MESSAGE
     */
    public String getClubSavingMessage() {
        this._clubSavingMessage = ""; /*BZ31780*/
        IPosTransaction tran = this._transactionScope.getTransaction();
        if (tran != null && !tran.getSaleLineItems().isEmpty()) {
            /*Filter all non-void item to tmp list*/
            List<IRetailTransactionLineItem> tmp = tran.getSaleLineItems().stream()
                    .filter(tenderLine -> !tenderLine.getVoid()).collect(Collectors.toList());
            if (tmp.isEmpty()) {
        /*BEGIN BZ31780*/
                this._clubSavingMessage = "";
            }
            this._clubSavingMessage = getClubMessage();
        }
        return this._clubSavingMessage;
       
    }
    
    /**
     * @param argClubSavingMessage the clubSavingMessage to set
     */
    public void setClubSavingMessage(String argClubSavingMessage) {
    
        _clubSavingMessage = argClubSavingMessage;
    }
    /*END BZ31780*/
    
    /* (non-Javadoc)
     * @see dtv.pos.register.RetailTransactionListModel#init()
     */
    @Override
    public void init() {
        addField(CLUB_SAVING_MESSAGE, String.class);
        super.init();
    }

    /* (non-Javadoc)
     * @see dtv.pos.register.TransactionListEditModel#updateListItems()
     */
    @Override
    protected void updateListItems() {
        super.updateListItems();
        setValue("clubSavingMessage", this._clubSavingMessage);/*BZ31780*/
    }

    /*END BZ31523*/
    private static final Logger logger_                = Logger
            .getLogger(CawRetailTransactionListModel.class);

    @Override
    protected void updateCustomer(IParty argCustomer) {

        if (argCustomer == null) {
            setValue(CUSTOMER_NAME_FIELD_KEY, null);
            setValue(CUSTOMER_AVATAR_ICON_KEY, null);
            _cawLoyaltyIcon = null;
        } else {
            IFormatter formatter = FormatterFactory.getInstance()
                    .getFormatter(FormatterType.BASIC_NAME);
            String name = formatter.format(argCustomer, OutputContextType.VIEW);

            // BEGIN BZ27339: _cawLoyaltyIcon and _cawPricingDesc
            readPricingDesctionAndLoyaltyIcon(argCustomer
                    .getOrganizationId(), argCustomer.getPartyId());

            String newName = name + SPACES_FIELD_KEY + SPACES_FIELD_KEY
                    + _cawPricingDesc;
            setValue(CUSTOMER_NAME_FIELD_KEY, newName);
            /* BEGIN BZ29842 */
            if (StringUtils.isNotEmpty(_customerUIHelper.getAvatarIcon(argCustomer))) {
                setValue(CUSTOMER_AVATAR_ICON_KEY, _customerUIHelper.getAvatarIcon(argCustomer));
            }
            if (StringUtils.isNotEmpty(_cawLoyaltyIcon)) {
                _transactionScope.setValue(CawValueKeys.CAW_CUSTOMER_AVATAR_ICON_KEY, _cawLoyaltyIcon);
                CawMembershipHelper.getInstance().setMembershipImage(_cawLoyaltyIcon);
            }
            /* END BZ29842 */
            //END BZ27339
        }
    }

    /**
     * Gets the loyalty icon.
     *
     * @return the loyalty icon
     */
    @Override
    public String getLoyaltyIcon() {

        return _cawLoyaltyIcon;
    }

    /**
     * BZ 27339 Modified 
     * Read Loyalty Icon And Description
     * @return
     */
    protected void readPricingDesctionAndLoyaltyIcon(long organizationId,
            long partyId) {

        String pricingInfo = "";
        String response = CawCatalystHelper.getLookupResponseData();
        List<CawCustomerMembershipView> outCustomerMembershipViews = null;
        outCustomerMembershipViews = CawMembershipHelper.getInstance()
                .getReloadMemberships(response);

        if (response != null) { //BZ62987
            //BEGIN BZ 27339
            pricingInfo = getPricingInfoFromEBS(response, organizationId, outCustomerMembershipViews);
            //END BZ 27339
        }
        
        /* Start BZ 25318 */
        if (pricingInfo.isEmpty()) {
            Map<String, Object> params = new HashMap<>();
            params.put(CawQueryConstants.ARG_PARTY_ID, partyId);
            List<CawCustomerPartyIdXrefQueryResult> xrefResults = DataFactory
                    .getObjectByQueryNoThrow(CawQueryConstants.CUSTOMER_PARTY_ID_XREF_LOOKUP, params);

            if (!xrefResults.isEmpty()) {
                //Begin BZ26471
                String jsonPricing = xrefResults.get(0).getStringValue();
                pricingInfo = getPricingInfoFromDatabase(jsonPricing, organizationId);
                //End BZ26471
            }
        }
        /* End BZ 25318 */

        // BZ27851 start
        if (StringUtils.isEmpty(pricingInfo)) {
            /*BZ27339 start - get default retail pricing*/
            String description = null;
            String outputLoyaltyIcon = null;
            ICodeValue value = null;
            CodeValueId id = new CodeValueId();
            id.setOrganizationId(organizationId);
            id.setCategory(CawCustomerConstants.CUSTOMER_GROUPS);
            id.setCode(CawPropertyUtils.CUSTOMER_GROUP_TYPE_RETL_NEW_NAME);
            try {
                value = (ICodeValue) DataFactory.getObjectById(id);
                if (value != null) {
                    description = value.getDescription();
                    outputLoyaltyIcon = value.getImageUrl();
                }
            } catch (ObjectNotFoundException e) {
                logger_.warn("Could not find Customer Group [" + id.getCode()
                        + "]" + e.getMessage());
            }
            pricingInfo = description;
            _cawLoyaltyIcon = outputLoyaltyIcon;
            _cawPricingDesc = pricingInfo;
            /*BZ27339 end*/
        }
        // BZ27851 end
        _cawPricingDesc = pricingInfo;
    }
    //BEGIN BZ69515
    private boolean getIsActive(String jsonCustomerResponse) {
        boolean isActive = false;
        
        List<String> codes = CodeLocator.getCodes(ConfigurationMgr.getOrganizationId(), GS_VISA_ICON_ENABLED);
        if (codes != null && codes.size() > 0) {
            String isEnable = codes.get(0);
            if (!Boolean.valueOf(isEnable)) {
                return false;
            }
        }
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            JsonNode rootNode = objectMapper.readTree(jsonCustomerResponse);
            JsonNode cardholderNode = rootNode.path(JSON_CARDHOLDER);

            if (cardholderNode.isMissingNode()) {
                logger_.warn("Cardholder node not found in EBS customer response.");
                return false;  // Return false if the cardholder node is missing
            }

            JsonNode isActiveNode = cardholderNode.path(JSON_ISACTIVE);
            if (isActiveNode.isMissingNode()) {
                logger_.warn("isActive field not found in EBS customer response.");
                return false;
            }

            isActive = isActiveNode.asBoolean(false);
        } catch (IOException ex) {
            logger_.error("Failed to parse EBS customer response: " + ex.getMessage());
        }

        return isActive;
    }
	//END BZ69515
    private String getPricingInfoFromEBS(String jsonCustomerResponse,
            long orgId,
            List<CawCustomerMembershipView> customerMembershipViews) {

        JSONObject result = null;
        JSONObject obPricing = null;
        JSONObject obMembership = null;
        String pricingInformation = "";
        // String membershipId = ""; BZ62573
        String expiredDate = "";
        String description = "";
        String band = "";
        String benefitLevelName = "";
        String outputLoyaltyIcon = "";

        if (jsonCustomerResponse == null
                || jsonCustomerResponse.length() == 0) {
            return pricingInformation;
        }
        
        boolean isActive = getIsActive(jsonCustomerResponse); //BZ69515
        try {
            result = CawJSONUtils.toJSONObject(jsonCustomerResponse);
            obPricing = CawJSONUtils.getJSONObject(result, PRICING_TAG);
            if (obPricing != null) {
                obMembership = CawJSONUtils
                        .getJSONObject(obPricing, MEMBERSHIP_TAG);
                if (obMembership != null) {
                    /* BEGIN BZ62573
                    if (!obMembership.isNull(IDENTIFIER_TAG)) {
                        membershipId = obMembership.getString(IDENTIFIER_TAG);
                    }
                    END BZ62573 */
                    if (!obMembership.isNull(EXPIREDATE_TAG)) {
                        expiredDate = obMembership.getString(EXPIREDATE_TAG);
                    }

                    if (!obPricing.isNull(BAND_TAG)) {

                        benefitLevelName = obMembership
                                .getString(CawEBSConstant.MEMBERSHIPS_BENEFIT_LEVEL_NAME_ATTR);

                        if (!StringUtils.isEmpty(benefitLevelName)
                                && CawCustomerConstants.CAW_CUSTOMER_ELITE_LEVEL
                                        .equals(benefitLevelName)) {
                            ICodeValue value = null;
                            CodeValueId id = new CodeValueId();
                            id.setOrganizationId(orgId);
                            //BEGIN BZ69515
                            if (isActive) {
                                id.setCategory(CawCustomerConstants.CUSTOMER_GROUPS);
                                id.setCode(CawPropertyUtils.CUSTOMER_GROUP_TYPE_GSVISA_NAME);
                            }else {
                                id.setCategory(CawCustomerConstants.CAW_CUSTOMER_GROUPS_LEVEL);
                                id.setCode(StringUtils.upperCase(benefitLevelName));
                            }
                            //END BZ69515
                            try {
                                value = (ICodeValue) DataFactory
                                        .getObjectById(id);
                                if (value != null) {
                                    description = value.getDescription();
                                    outputLoyaltyIcon = value.getImageUrl();
                                }
                            } catch (ObjectNotFoundException e) {
                                logger_.warn("Could not find Customer Group level ["
                                        + id.getCode() + "]" + e.getMessage());
                            }

                        } else {
                            band = obPricing.getString(BAND_TAG);
                            if (band != null) {
                                ICodeValue value = null;
                                CodeValueId id = new CodeValueId();
                                id.setOrganizationId(orgId);
                                id.setCategory(CawCustomerConstants.CUSTOMER_GROUPS);
                                if (CawPropertyUtils.CUSTOMER_GROUP_TYPE_RETL_OLD_NAME
                                        .equalsIgnoreCase(band)) {
                                    id.setCode(CawPropertyUtils.CUSTOMER_GROUP_TYPE_RETL_NEW_NAME);
                                } else {
                                    //BEGIN BZ69515
                                    if(isActive) {
                                        id.setCode(CawPropertyUtils.CUSTOMER_GROUP_TYPE_GSVISA_NAME);
                                    }else {
                                        id.setCode(band);
                                    }
                                    //END BZ69515
                                }
                                try {
                                    value = (ICodeValue) DataFactory
                                            .getObjectById(id);
                                    if (value != null) {
                                        description = value.getDescription();
                                        outputLoyaltyIcon = value.getImageUrl();
                                    }
                                } catch (ObjectNotFoundException e) {
                                    logger_.warn("Could not find Customer Group ["
                                            + id.getCode() + "]"
                                            + e.getMessage());
                                }
                            }
                        }
                    }
                    //BEGIN BZ62573
                    pricingInformation = EXPIRED_DATE_FIELD_KEY + expiredDate + SPACES_FIELD_KEY + description;
                    //END BZ62573
                } else {

                    if (customerMembershipViews != null
                            && customerMembershipViews.size() > 0) {
                        band = obPricing.getString(BAND_TAG);
                        if (band != null) {
                            ICodeValue value = null;
                            CodeValueId id = new CodeValueId();
                            id.setOrganizationId(orgId);
                            id.setCategory(CawCustomerConstants.CUSTOMER_GROUPS);
                            if (CawPropertyUtils.CUSTOMER_GROUP_TYPE_RETL_OLD_NAME
                                    .equalsIgnoreCase(band)) {
                                id.setCode(CawPropertyUtils.CUSTOMER_GROUP_TYPE_RETL_NEW_NAME);
                            } else {
                                //BEGIN BZ69515
                                if(isActive) {
                                    id.setCode(CawPropertyUtils.CUSTOMER_GROUP_TYPE_GSVISA_NAME);
                                }else {
                                    id.setCode(band);
                                }
                                //END BZ69515
                            }
                            try {
                                value = (ICodeValue) DataFactory
                                        .getObjectById(id);
                                if (value != null) {
                                    description = value.getDescription();
                                    outputLoyaltyIcon = value.getImageUrl();
                                }
                            } catch (ObjectNotFoundException e) {
                                logger_.warn("Could not find Customer Group ["
                                        + id.getCode() + "]" + e.getMessage());
                            }
                        }
                        //Begin BZ49497
                        if (customerMembershipViews.get(0).getExpDate() == null) {
                            pricingInformation = SPACES_FIELD_KEY + description; //BZ62987
                        } else {
                            pricingInformation = EXPIRED_DATE_FIELD_KEY
                                    + customerMembershipViews.get(0).getExpDate()
                                    + SPACES_FIELD_KEY + description;//BZ62987
                        }
                        //End BZ49497
                    } else {
                        ICodeValue value = null;
                        CodeValueId id = new CodeValueId();
                        id.setOrganizationId(orgId);
                        id.setCategory(CawCustomerConstants.CUSTOMER_GROUPS);
                        id.setCode(CawPropertyUtils.CUSTOMER_GROUP_TYPE_RETL_NEW_NAME);
                        try {
                            value = (ICodeValue) DataFactory.getObjectById(id);
                            if (value != null) {
                                description = value.getDescription();
                                outputLoyaltyIcon = value.getImageUrl();
                            }
                        } catch (ObjectNotFoundException e) {
                            logger_.warn("Could not find Customer Group ["
                                    + id.getCode() + "]" + e.getMessage());
                        }

                        pricingInformation = description;
                    }

                }
            }
        } catch (Exception ex) {
            logger_.error("getPricingInformation: There is no membership from EBS response."
                    + ex.getMessage());
        }
        // BZ27339 End

        //OUT PUT----------------
        _cawLoyaltyIcon = outputLoyaltyIcon;
        _cawPricingDesc = pricingInformation;
        return pricingInformation;
    }

    /**
     * Applying for BZ26471, BZ27339
     * This method is used to get pricing's information from database.
     * @param jsonPricingResponse
     * @param organizationId
     * @return
     */
    private String getPricingInfoFromDatabase(String jsonPricingResponse,
            long organizationId) {

        JSONObject result = null;
        JSONObject obMembership = null;
        String pricingInformation = "";
        // String membershipId = ""; BZ62573
        String expiredDate = "";
        String description = "";
        String band = "";
        String outputLoyaltyIcon = "";

        if (jsonPricingResponse == null || jsonPricingResponse.length() == 0) {
            return pricingInformation;
        }

        try {
            result = CawJSONUtils.toJSONObject(jsonPricingResponse);
            obMembership = CawJSONUtils.getJSONObject(result, MEMBERSHIP_TAG);
            if (obMembership != null) {
                /* BEGIN BZ62573
                if (!obMembership.isNull(IDENTIFIER_TAG)) {
                    membershipId = obMembership.getString(IDENTIFIER_TAG);
                }
                END BZ62573 */
                if (!obMembership.isNull(EXPIREDATE_TAG)) {
                    expiredDate = obMembership.getString(EXPIREDATE_TAG);
                }
                if (!result.isNull(BAND_TAG)) {

                    /*BZ27339 start*/
                    String benefitLevelName = CawJSONUtils
                            .getString(obMembership, CawEBSConstant.MEMBERSHIPS_BENEFIT_LEVEL_NAME_ATTR);
                    if (!StringUtils.isEmpty(benefitLevelName)
                            && CawCustomerConstants.CAW_CUSTOMER_ELITE_LEVEL
                                    .equals(benefitLevelName)) {
                        ICodeValue value = null;
                        CodeValueId id = new CodeValueId();
                        id.setOrganizationId(organizationId);
                        id.setCategory(CawCustomerConstants.CAW_CUSTOMER_GROUPS_LEVEL);
                        id.setCode(StringUtils.upperCase(benefitLevelName));
                        try {
                            value = (ICodeValue) DataFactory.getObjectById(id);
                            if (value != null) {
                                description = value.getDescription();
                                outputLoyaltyIcon = value.getImageUrl();
                            }
                        } catch (ObjectNotFoundException e) {
                            logger_.warn("Could not find Customer Group level ["
                                    + id.getCode() + "]" + e.getMessage());
                        }
                        /*BZ27339 end*/
                    } else {
                        band = result.getString(BAND_TAG);
                        if (band != null) {
                            ICodeValue value = null;
                            CodeValueId id = new CodeValueId();
                            id.setOrganizationId(organizationId);
                            id.setCategory(CawCustomerConstants.CUSTOMER_GROUPS);
                            if (CawPropertyUtils.CUSTOMER_GROUP_TYPE_RETL_OLD_NAME
                                    .equalsIgnoreCase(band)) {
                                id.setCode(CawPropertyUtils.CUSTOMER_GROUP_TYPE_RETL_NEW_NAME);
                            } else {
                                id.setCode(band);
                            }

                            try {
                                value = (ICodeValue) DataFactory
                                        .getObjectById(id);
                                if (value != null) {
                                    description = value.getDescription();
                                    outputLoyaltyIcon = value.getImageUrl();
                                }
                            } catch (ObjectNotFoundException e) {
                                logger_.warn("Could not find Customer Group ["
                                        + id.getCode() + "]" + e.getMessage());
                            }
                        }
                    }
                }
                //BEGIN BZ62573
                pricingInformation = EXPIRED_DATE_FIELD_KEY + expiredDate + SPACES_FIELD_KEY + description;
                //END BZ62573
            } else {

                /*BZ27339 start*/
                ICodeValue value = null;
                CodeValueId id = new CodeValueId();
                id.setOrganizationId(organizationId);
                id.setCategory(CawCustomerConstants.CUSTOMER_GROUPS);
                id.setCode(CawPropertyUtils.CUSTOMER_GROUP_TYPE_RETL_NEW_NAME);
                try {
                    value = (ICodeValue) DataFactory.getObjectById(id);
                    if (value != null) {
                        description = value.getDescription();
                        outputLoyaltyIcon = value.getImageUrl();
                    }
                } catch (ObjectNotFoundException e) {
                    logger_.warn("Could not find Customer Group ["
                            + id.getCode() + "]" + e.getMessage());
                }
                pricingInformation = description;
                /*BZ27339 End*/
            }
        } catch (Exception ex) {
            logger_.error("getPricingInfoFromDatabase: Membership not found!"
                    + ex.getMessage());
        }

        //OUTPUT--------
        _cawLoyaltyIcon = outputLoyaltyIcon;
        _cawPricingDesc = pricingInformation;
        return pricingInformation;
    }

    /*BEGIN BZ31523*/
    private String getClubMessage() {

        BigDecimal totalDiscount = NumberUtils.ZERO;
        IRetailTransaction trans = (IRetailTransaction) this._transactionScope
                .getTransaction();
        
        BigDecimal subTotal = trans != null ? trans.getSubtotal() : NumberUtils.ZERO; //BZ61159
        
        totalDiscount = new CawTotalAmountCouldSavedWorker(trans).call();
        _transactionScope.setValue(CawValueKeys.COULD_SAVE, totalDiscount); //BZ40798
        if (trans != null) {
            if (trans.getCustomerParty() != null) {
                int custGroup = isClubCustomerGroupID(trans.getCustomerParty());
                switch (custGroup) {
                case 1:
                    totalDiscount = new CawTotalAmountSavedWorker(trans).call();
                    _transactionScope.setValue(CawValueKeys.GOOD_SAM_SAVINGS, totalDiscount); //BZ40798
                    return _ff.getTranslatable("_caw_totalAmountTranSaved")
                            + new MoneyFormatter().format(totalDiscount, null);
                case 2:
                    return " ";
                }
            }

        }
        
        /* BEGIN BZ61159 */
        List<String> listNumberOfMul = CodeLocator
                .getCodes(ConfigurationMgr.getOrganizationId(), CawConstants.CAW_TOTAL_POINTS_COULD_SAVED);
        
        return _ff.getTranslatable("_cawAGIS_totalAmountPointTranCouldSaved") + String.valueOf(subTotal.multiply(BigDecimal.valueOf(Long.valueOf(listNumberOfMul.get(0)))).intValue()) + CAW_SPACE +_ff.getTranslatable("_cawAGIS_totalAmountTranCouldSaved")
                + new MoneyFormatter().format(totalDiscount, null);
        /* END BZ61159 */
    }

    private int isClubCustomerGroupID(IParty argSource) {

        int custGroup = 0;
        //BZ31523: changed condition (Crew type from EBS)
        //BZ31523: changed condition.
        //BZ33497: swapped condition Whsl before Crew
        if (CawCustomerUtil.isWhslCustomer(argSource) || CawCustomerUtil.isCrewCustomerFromEBS(argSource)) {
            return custGroup = 2;
        } else if (CawCustomerUtil.isClubCustomerXstore(argSource)) {
            return custGroup = 1;
        }
        return custGroup;
    }
    /*END BZ31523*/
    
    /* BEGIN BZ61159 */
    private boolean isVoidedAllGSMembership() {

        if (_transactionScope.getValue(CawValueKeys.CAW_AGIS_PICHES_MODEL) !=null 
                && _transactionScope.getValue(CawValueKeys.CAW_AGIS_PICHES_LENGTH) != null) {
            CawAGISPitchesModel cawAGISPitchesModel = _transactionScope.getValue(CawValueKeys.CAW_AGIS_PICHES_MODEL);        
            int cawAGISPitchesLength = _transactionScope.getValue(CawValueKeys.CAW_AGIS_PICHES_LENGTH);
            
            for (int i = 0; i < cawAGISPitchesLength; i++) {
                boolean isAccept = (boolean) cawAGISPitchesModel.getValue(CawConstants.CAW_ACCEPT_FIELD + i);
                String itemId = String.valueOf(cawAGISPitchesModel.getValue(CawConstants.CAW_ITEM_ID_FIELD + i));
                if(isAccept && isGoodSamItem(itemId)) {
                    return false;
                }
            }
        }
        return true;
    }
    
    private boolean isGoodSamItem(String itemId) {
        if (_membershipHelper.getMembershipActivity(itemId) != null && CawCustomerGroupType.CLUB.getNewName().equals(_membershipHelper.getMembershipActivity(itemId).getCustomerGroup())) {
            return true;
        } else {
            return false;
        }
    }
    /* END BZ61159 */
}
