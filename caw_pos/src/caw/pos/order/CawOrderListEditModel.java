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
 * BZ37706          070920    [Internal] Missing membership information such as Membership#, exp,Club price and logo on Top panel into View port when doing an order transaction.
 * BZ69515          120225    Display Good Sam Visa Cardholder indicator Icon
 *===================================================================
 */

package caw.pos.order;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.*;
import java.util.stream.Collectors;

import javax.inject.Inject;

import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import caw.pos.advance.prompting.CawCatalystHelper;
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
import dtv.pos.order.OrderListEditModel;
import dtv.util.NumberUtils;
import dtv.xst.dao.com.*;
import dtv.xst.dao.crm.IParty;
import dtv.xst.dao.trl.IRetailTransaction;
import dtv.xst.dao.trl.IRetailTransactionLineItem;
import dtv.xst.dao.trn.IPosTransaction;

/**
 *
 */
public class CawOrderListEditModel extends OrderListEditModel {

    private static final Logger  logger_                = Logger
            .getLogger(CawOrderListEditModel.class);

    /** The Constant SPACES_FIELD_KEY. */
    public static final String   SPACES_FIELD_KEY       = "   ";

    /** The Constant EXPIRED_DATE_FIELD_KEY. */
    public static final String   EXPIRED_DATE_FIELD_KEY = "Exp: ";

    /** The Constant PRICING_TAG. */
    public static final String   PRICING_TAG            = "pricing";

    /** The Constant MEMBERSHIP_TAG. */
    public static final String   MEMBERSHIP_TAG         = "membership";

    /** The Constant EXPIREDATE_TAG. */
    public static final String   EXPIREDATE_TAG         = "expireDate";

    /** The Constant IDENTIFIER_TAG. */
    public static final String   IDENTIFIER_TAG         = "identifier";

    /** The Constant BAND_TAG. */
    public static final String   BAND_TAG               = "band";

    /** The Constant DESCRIPTION_TAG. */
    public static final String   DESCRIPTION_TAG        = "description";

    public static final String   CLUB_SAVING_MESSAGE    = "clubSavingMessage";

    @Inject
    public ICustomerUIHelper     _customerUIHelper;

    private String               _loyaltyIcon           = null;

    private String               _cawPricingDesc        = null;

    private String               _clubSavingMessage     = null;
    //BEGIN BZ69515
    private final String JSON_CARDHOLDER                = "cardholder";
    private final String JSON_ISACTIVE                  = "isActive";
    private final String GS_VISA_ICON_ENABLED   = "GS_VISA_ICON_ENABLED";
	//END BZ69515
    @Inject
    protected FormattableFactory _ff;

    /**
     * @return the cLUB_SAVING_MESSAGE
     */
    public String getClubSavingMessage() {

        this._clubSavingMessage = "";
        IPosTransaction tran = this._transactionScope.getTransaction();
        if (tran != null && !tran.getSaleLineItems().isEmpty()) {
            /*Filter all non-void item to tmp list*/
            List<IRetailTransactionLineItem> tmp = tran.getSaleLineItems()
                    .stream().filter(tenderLine -> !tenderLine.getVoid())
                    .collect(Collectors.toList());
            if (tmp.isEmpty()) {

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
        setValue(CLUB_SAVING_MESSAGE, this._clubSavingMessage);
    }

    @Override
    protected void updateCustomer(IParty argCustomer) {

        if (argCustomer == null) {
            setValue(CUSTOMER_NAME_FIELD_KEY, null);
            setValue(CUSTOMER_AVATAR_ICON_KEY, null);
            _loyaltyIcon = null;
        } else {
            IFormatter formatter = FormatterFactory.getInstance()
                    .getFormatter(FormatterType.BASIC_NAME);
            String name = formatter.format(argCustomer, OutputContextType.VIEW);

            readPricingDesctionAndLoyaltyIcon(argCustomer
                    .getOrganizationId(), argCustomer.getPartyId());

            String newName = name + SPACES_FIELD_KEY + SPACES_FIELD_KEY
                    + _cawPricingDesc;
            setValue(CUSTOMER_NAME_FIELD_KEY, newName);
            if (StringUtils
                    .isNotEmpty(_customerUIHelper.getAvatarIcon(argCustomer))) {
                setValue(CUSTOMER_AVATAR_ICON_KEY, _customerUIHelper
                        .getAvatarIcon(argCustomer));
            }
            if (StringUtils.isNotEmpty(_loyaltyIcon)) {
                _transactionScope
                        .setValue(CawValueKeys.CAW_CUSTOMER_AVATAR_ICON_KEY, _loyaltyIcon);
                CawMembershipHelper.getInstance()
                        .setMembershipImage(_loyaltyIcon);
            }
        }
    }

    /**
     * Gets the loyalty icon.
     *
     * @return the loyalty icon
     */
    @Override
    public String getLoyaltyIcon() {

        return _loyaltyIcon;
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

        if (response != null) {

            pricingInfo = getPricingInfoFromEBS(response, organizationId, outCustomerMembershipViews);

        }

        /* Start BZ 25318 */
        if (pricingInfo.isEmpty()) {
            Map<String, Object> params = new HashMap<>();
            params.put(CawQueryConstants.ARG_PARTY_ID, partyId);
            List<CawCustomerPartyIdXrefQueryResult> xrefResults = DataFactory
                    .getObjectByQueryNoThrow(CawQueryConstants.CUSTOMER_PARTY_ID_XREF_LOOKUP, params);

            if (!xrefResults.isEmpty()) {

                String jsonPricing = xrefResults.get(0).getStringValue();
                pricingInfo = getPricingInfoFromDatabase(jsonPricing, organizationId);

            }
        }

        if (StringUtils.isEmpty(pricingInfo)) {
            // start - get default retail pricing*/
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
                logger_.warn("Could not find Customer Group [" + id.getCode() + "]" + e.getMessage());
            }
            pricingInfo = description;
            _loyaltyIcon = outputLoyaltyIcon;
            _cawPricingDesc = pricingInfo;

        }
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
        String membershipId = "";
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
                    if (!obMembership.isNull(IDENTIFIER_TAG)) {
                        membershipId = obMembership.getString(IDENTIFIER_TAG);
                    }

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
                            if(isActive) {
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
                                logger_.warn("Could not find Customer Group level [" + id.getCode() + "]" + e.getMessage());
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
                                    logger_.warn("Could not find Customer Group [" + id.getCode() + "]" + e.getMessage());
                                }
                            }
                        }
                    }
                    pricingInformation = membershipId + SPACES_FIELD_KEY
                            + EXPIRED_DATE_FIELD_KEY + expiredDate
                            + SPACES_FIELD_KEY + description;
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
                                logger_.warn("Could not find Customer Group [" + id.getCode() + "]" + e.getMessage());
                            }
                        }
                        pricingInformation = customerMembershipViews.get(0)
                                .getClub() + SPACES_FIELD_KEY
                                + EXPIRED_DATE_FIELD_KEY
                                + customerMembershipViews.get(0).getExpDate()
                                + SPACES_FIELD_KEY + description;
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
                            logger_.warn("Could not find Customer Group [" + id.getCode() + "]" + e.getMessage());
                        }

                        pricingInformation = description;
                    }

                }
            }
        } catch (Exception ex) {
            logger_.error("getPricingInformation: There is no membership from EBS response." + ex.getMessage());
        }

        //OUT PUT----------------
        _loyaltyIcon = outputLoyaltyIcon;
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
        String membershipId = "";
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

                if (!obMembership.isNull(IDENTIFIER_TAG)) {
                    membershipId = obMembership.getString(IDENTIFIER_TAG);
                }
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
                            logger_.warn("Could not find Customer Group level [" + id.getCode() + "]" + e.getMessage());
                        }
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
                                logger_.warn("Could not find Customer Group [" + id.getCode() + "]" + e.getMessage());
                            }
                        }
                    }
                }

                pricingInformation = membershipId + SPACES_FIELD_KEY
                        + EXPIRED_DATE_FIELD_KEY + expiredDate
                        + SPACES_FIELD_KEY + description;
            } else {
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
                    logger_.warn("Could not find Customer Group [" + id.getCode() + "]" + e.getMessage());
                }
                pricingInformation = description;

            }
        } catch (Exception ex) {
            logger_.error("getPricingInfoFromDatabase: Membership not found!" + ex.getMessage());
        }

        //OUTPUT--------
        _loyaltyIcon = outputLoyaltyIcon;
        _cawPricingDesc = pricingInformation;
        return pricingInformation;
    }

    private String getClubMessage() {

        BigDecimal totalDiscount = NumberUtils.ZERO;
        IRetailTransaction trans = (IRetailTransaction) this._transactionScope
                .getTransaction();
        totalDiscount = new CawTotalAmountCouldSavedWorker(trans).call();
        if (trans != null) {
            if (trans.getCustomerParty() != null) {
                int custGroup = isClubCustomerGroupID(trans.getCustomerParty());
                switch (custGroup) {
                case 1:
                    totalDiscount = new CawTotalAmountSavedWorker(trans).call();
                    return _ff.getTranslatable("_caw_totalAmountTranSaved")
                            + new MoneyFormatter().format(totalDiscount, null);
                case 2:
                    return " ";
                }
            }

        }
        return _ff.getTranslatable("_caw_totalAmountTranCouldSaved")
                + new MoneyFormatter().format(totalDiscount, null);

    }

    private int isClubCustomerGroupID(IParty argSource) {

        int custGroup = 0;
        //: changed condition (Crew type from EBS)
        //: changed condition.
        //: swapped condition Whsl before Crew
        if (CawCustomerUtil.isWhslCustomer(argSource)
                || CawCustomerUtil.isCrewCustomerFromEBS(argSource)) {
            return custGroup = 2;
        } else if (CawCustomerUtil.isClubCustomerXstore(argSource)) {
            return custGroup = 1;
        }
        return custGroup;
    }

}
