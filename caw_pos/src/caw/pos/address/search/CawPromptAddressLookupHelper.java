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
 * BZ23405          160118    [QAS] There are problem when integrate Xstore with QAS service of Camping World
 * BZ25358          290418    Enhancements to QAS Integration with POS
 * BZ26564          140618    [Internal] QAS search sent tag country incorrectly the address of customer which country is CAN
 * BZ26568          180618    [Internal] Can assign a customer without QAS validation address lookup to sale screen after changing another country.
 * BZ26575          140618    [QAS] Update address verification flow to reduce the number of click in the QAS process
 *===================================================================
 */

package caw.pos.address.search;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.google.common.base.Strings;

import caw.pos.common.*;
import caw.qas.proweb.*;
import oracle.retail.xstore.avs.impl.SearchResultEnum;
import oracle.retail.xstore.avs.impl.exceptions.*;
import oracle.retail.xstore.avs.impl.response.AddressVerificationResponse;
import twitter4j.JSONObject;

import dtv.data2.access.DataFactory;
import dtv.pos.address.search.AddressSearchInfo;
import dtv.pos.address.search.AddressSearchResultStatus;
import dtv.pos.customer.IQualifiedAddress;
import dtv.service.ServiceException;
import dtv.xst.dao.crm.IPartyLocaleInformation;

/**
 * this class is used to invoke to QAS service. Sending Request and getting response, parsing data and showing log file.
 */
public class CawPromptAddressLookupHelper {

    private static final String                          DATABASE_LAYOUT           = "Database Layout";

    private static final String                          CITY_NAME                 = "City name";

    private static final String                          STATE_CODE                = "State code";

    private static final String                          CITY_NAME2                = "Municipality name";

    private static final String                          STATE_CODE2               = "Province code";

    private static final String                          POSTAL_CODE               = "Postal code";

    private static final String                          COUNTRY                   = "Country";                             //BZ26575

    private static final Logger                          _logger                   = LogManager
            .getLogger(CawPromptAddressLookupHelper.class);

    private static final String                          PICK_LIST_ENTRY_LIMIT_KEY = "caw.pos.address.picklist.entry.limit";

    private static final int                             PICK_LIST_ENTRY_LIMIT_DEF = 100;

    /**
     * The singleton instance of the CawPromptAddressLookupHelper class
     */
    private static volatile CawPromptAddressLookupHelper instance                  = null;

    /**
     * Default constructor is private
     */
    private CawPromptAddressLookupHelper() {

        super();
    }

    /**
     * Returns a reference to the single instance of this object
     * 
     * @return CawPromptAddressLookupHelper
     */
    public static CawPromptAddressLookupHelper getInstance() {

        if (instance == null) {
            synchronized (CawPromptAddressLookupHelper.class) {
                if (instance == null) {
                    instance = new CawPromptAddressLookupHelper();
                }
            }
        }
        return instance;
    }

    /**
     * BZ25358
     * Limit for Pick List entry 
     * @return
     */
    public int getPicklistEntryLimit() {

        return CawUtilFunction.vInt(CawUtilFunction
                .getSystemProperty(PICK_LIST_ENTRY_LIMIT_KEY, String.valueOf(PICK_LIST_ENTRY_LIMIT_DEF)));
    }

    /**
     * Search Address in Neuron
     * Example: Alpha2 [US, CA]; Alpha3 [USA, CAN]
     * @param argAddressLine
     * @param countryAlpha2
     * @return
     */
    public CawQASearchResult doSearchAddress(String argAddressLine, String countryAlpha2) {

        CawQASearchResult result = null;
        try {
            CawQASearch searchString = new CawQASearch();
            searchString.setCountry(getCountryMapping(countryAlpha2));//BZ26564
            CawEngineType enType = new CawEngineType();
            enType.setFlatten(true);
            enType.setIntensity(CawEngineIntensityType.CLOSE);
            enType.setValue(CawEngineEnumType.VERIFICATION);
            searchString.setEngine(enType);
            searchString.setLayout(DATABASE_LAYOUT);
            searchString.setSearch(argAddressLine);
            searchString.setFormattedAddressInPicklist(false);
            _logger.info("Outbound SOAP request for DoResearch:"
                    + CawQASParser.getInstance().buildDoSearchRequestXml(searchString));
            result = CawQASHelper.getInstance().doSearch(searchString);
            _logger.info("Outbound SOAP Response for DoResearch:" + CawQASParser.getInstance().parseDoSearch(result));

        } catch (Exception e) {
            _logger.error("doSearchAddress-1", e);
        }
        return result;
    }

    /**
     * Refine Address
     * @param Moniker
     * @param Refinement
     * @param countryAlpha2
     * @return
     */
    public CawPicklist doRefineAddress(String moniker, String refinement, String countryAlpha2) {

        CawPicklist result = null;
        try {
            CawQASHelper myQAS = CawQASHelper.getInstance();
            CawQARefine searchString = new CawQARefine();
            searchString.setLanguage(getCountryMapping(countryAlpha2));
            searchString.setLayout(DATABASE_LAYOUT);
            searchString.setMoniker(moniker);
            searchString.setRefinement(refinement);
            searchString.setFormattedAddressInPicklist(false);

            _logger.info("Outbound SOAP request for DoRefine:"
                    + CawQASParser.getInstance().buildDoRefineRequestXml(moniker, refinement, searchString));
            result = myQAS.doRefine(searchString);
            _logger.info("Outbound SOAP Response for DoRefine:" + CawQASParser.getInstance().parseRefine(result));

        } catch (Exception e) {
            _logger.error("doRefineAddress-2", e);
        }
        return result;
    }

    /**
     * Process of address Lookup
     * @param addressResponse
     * @return
     */
    public AddressSearchInfo addressLookup(AddressVerificationResponse addressResponse) {

        AddressSearchInfo addressSearchResponse = new AddressSearchInfo();
        try {
            switch (addressResponse.getSearchResult()) {
            case MULTIPLE_MATCHES:
                addressSearchResponse.setMoreMatchesThanRequested(addressResponse.isMoreMatchesThanRequested());
            case ADDITIONAL_DATA_NEEDED:
                addressSearchResponse.setAddressLine("");
                addressSearchResponse.setAddressId(addressResponse.getMatches().get(0));
                addressSearchResponse.setAddressIds(addressResponse.getMatches());
                addressSearchResponse.setAddressSearchResultStatus(AddressSearchResultStatus.ADDRESS_CONTINUE_SEARCH);
                break;
            case FORMATTED_ADDRESS_AVAILABLE:
                IPartyLocaleInformation address = addressResponse.getRetrievedAddress();
                addressSearchResponse.setAddressSearchResultStatus(AddressSearchResultStatus.ADDRESS_FOUND);
                addressSearchResponse.setRetrievedAddressNotComplete(addressResponse.isRetrievedAddressNotComplete());
                addressSearchResponse.setResultAddress(address);
                break;
            case ONE_UNVERIFIED_ADDRESS_IN_LIST:
                addressSearchResponse.setAddressLine("");
                addressSearchResponse.setAddressId(addressResponse.getMatches().get(0));
                addressSearchResponse.setAddressIds(addressResponse.getMatches());
                addressSearchResponse.setAddressSearchResultStatus(AddressSearchResultStatus.ADDRESS_CONTINUE_SEARCH);
                break;
            default:
                break;
            }
        } catch (AvsNoMatchesException anme) {
            addressSearchResponse.setAddressSearchResultStatus(AddressSearchResultStatus.ADDRESS_NOT_FOUND);
        } catch (AvsSelectionNotValidException asnve) {
            addressSearchResponse.setAddressSearchResultStatus(AddressSearchResultStatus.INVALID_ADDRESS_LINE);
        } catch (AvsTooManyMatchesException atmme) {
            addressSearchResponse.setAddressSearchResultStatus(AddressSearchResultStatus.ADDRESS_TOO_MUCH);
        } catch (AvsConfigurationException atmme) {
            addressSearchResponse.setAddressSearchResultStatus(AddressSearchResultStatus.ADDRESS_CONFIGURATION_ERROR);
        } catch (AvsCountryValidationFailureException se) {
            addressSearchResponse
                    .setAddressSearchResultStatus(AddressSearchResultStatus.ADDRESS_COUNTRY_VALIDATION_ERROR);
        } catch (CriticalErrorException se) {
            addressSearchResponse.setAddressSearchResultStatus(AddressSearchResultStatus.ADDRESS_CRITICAL_ERROR);
        } catch (ServiceException se) {
            addressSearchResponse.setAddressSearchResultStatus(AddressSearchResultStatus.ADDRESS_CRITICAL_ERROR);
        } catch (Exception ex) {
            _logger.error("addressLookup-2", ex);
        }
        return addressSearchResponse;
    }

    protected boolean getUnresolvableRange(CawPicklistEntryType argEntry) {

        boolean unresolvableRange = false;
        if (argEntry.isUnresolvableRange()) {
            unresolvableRange = true;
        } else if (argEntry.getPicklist().contains(" ... ")) {
            unresolvableRange = true;
        }
        return unresolvableRange;
    }

    public IPartyLocaleInformation adapt(List<CawAddressLineType> argAddressLines) {

        IPartyLocaleInformation address = DataFactory.createObject(IPartyLocaleInformation.class);
        AddressIdEnum addressLineToFill = AddressIdEnum.Address1;
        for (CawAddressLineType line : argAddressLines) {
            if (line.getLineContent().equals(CawLineContentType.NONE)) {
                if (addressLineToFill == AddressIdEnum.Address1 && !StringUtils.isEmpty(line.getLine())) {
                    address.setAddress1(line.getLine());
                    addressLineToFill = AddressIdEnum.Address2;
                    continue;
                }
                if (addressLineToFill == AddressIdEnum.Address2 && !StringUtils.isEmpty(line.getLine())) {
                    address.setAddress2(line.getLine());
                    addressLineToFill = AddressIdEnum.Address3;
                    continue;
                }
                if (addressLineToFill == AddressIdEnum.Address3 && !StringUtils.isEmpty(line.getLine())) {
                    address.setAddress3(line.getLine());
                    addressLineToFill = AddressIdEnum.Address4;
                    continue;
                }
                if (addressLineToFill != AddressIdEnum.Address4 || StringUtils.isEmpty(line.getLine())) {
                    continue;
                }
                address.setAddress4(line.getLine());
                continue;
            }

            if (line.getLabel().equalsIgnoreCase(CITY_NAME) || CITY_NAME2.equalsIgnoreCase(line.getLabel())) {
                address.setCity(line.getLine());
                continue;
            }
            if (line.getLabel().equalsIgnoreCase(STATE_CODE) || STATE_CODE2.equalsIgnoreCase(line.getLabel())) {
                address.setState(line.getLine());
                continue;
            }
            if ((line.getLineContent().equals(CawLineContentType.ADDRESS) && StringUtils.isEmpty(line.getLabel()))) {
                address.setPostalCode(line.getLine());
            }
            if (POSTAL_CODE.equalsIgnoreCase(line.getLabel())) {
                address.setPostalCode(line.getLine());
                continue;
            }
            //Begin BZ26575
            if (COUNTRY.equalsIgnoreCase(line.getLabel())) {
                address.setCountry(ConverrtCountryMapping(line.getLine()));//BZ26575
                continue;
            }
            //End BZ26575
        }
        return address;
    }

    private static enum AddressIdEnum {
        Address1, Address2, Address3, Address4;
    }

    protected boolean adaptRetrievedAddressIncomplete(IPartyLocaleInformation argPartyLocale,
            CawVerifyLevelType cawVerifyLevelType) {

        boolean isIncomplete = false;
        if (StringUtils.isEmpty(argPartyLocale.getState())) {
            isIncomplete = true;
        } else if (StringUtils.isEmpty(argPartyLocale.getCity())) {
            isIncomplete = true;
        } else if (StringUtils.isEmpty(argPartyLocale.getPostalCode())) {
            isIncomplete = true;
        }
        if (cawVerifyLevelType != null && (cawVerifyLevelType.equals(CawVerifyLevelType.INTERACTION_REQUIRED)
                || cawVerifyLevelType.equals(CawVerifyLevelType.MULTIPLE)
                || cawVerifyLevelType.equals(CawVerifyLevelType.VERIFIED_STREET)
                || cawVerifyLevelType.equals(CawVerifyLevelType.VERIFIED_PLACE))) {
            isIncomplete = true;
        }
        return isIncomplete;
    }

    /**
     * Added BZ26564 to get 3 letters of Country
     * Example: Alpha2 [US, CA]; Alpha3 [USA, CAN]
     * @param countryAlpha2
     * @return
     */
    private String getCountryMapping(String countryAlpha2) {

        String country_language = CawEBSConstant.USA;
        if (!Strings.isNullOrEmpty(countryAlpha2)) {
            if (CawEBSConstant.US.equalsIgnoreCase(countryAlpha2)) {
                country_language = CawEBSConstant.USA;
            } else if (CawEBSConstant.CA.equalsIgnoreCase(countryAlpha2)) {
                country_language = CawEBSConstant.CAN;
            }
        }
        return country_language;
    }

    /**
     * Added BZ26564 just applied for US or CA
     * @param countryAlpha2
     * @return
     */
    public boolean isCountryQASEnabled(String countryAlpha2) {

        if (countryAlpha2 != null && (CawEBSConstant.US.equalsIgnoreCase(countryAlpha2)
                || CawEBSConstant.CA.equalsIgnoreCase(countryAlpha2))) {
            return true;
        }
        return false;
    }

    //Begin BZ25358 and BZ26575

    /**
     * Get full address line
     * Address1 [, Address2] [, Address3] [, Address4], [City], [State] [Postcode]
     * @param mainAddress
     * @return
     */
    public String getMergedAddressOneLine(IQualifiedAddress mainAddress) {

        StringBuilder address = new StringBuilder();
        IQualifiedAddress _mainAddress = mainAddress;//new TemporaryAddress();
        try {
            if (_mainAddress != null) {
                if (_mainAddress.getAddress1() != null) {
                    address.append(_mainAddress.getAddress1());
                }
                if (_mainAddress.getAddress2() != null) {
                    if (_mainAddress.getAddress1() == null) {
                        address.append(_mainAddress.getAddress2());
                    } else {
                        address.append(", ").append(_mainAddress.getAddress2());
                    }
                }
                if (_mainAddress.getAddress3() != null) {
                    if (_mainAddress.getAddress1() == null && _mainAddress.getAddress2() == null) {
                        address.append(_mainAddress.getAddress3());
                    } else {
                        address.append(", ").append(_mainAddress.getAddress3());
                    }
                }
                if (_mainAddress.getAddress4() != null) {
                    if (_mainAddress.getAddress1() == null && _mainAddress.getAddress2() == null
                            && _mainAddress.getAddress3() == null) {
                        address.append(_mainAddress.getAddress4());
                    } else {
                        address.append(", ").append(_mainAddress.getAddress4());
                    }
                }
                address.append(", ");
                if (_mainAddress.getCity() != null) {
                    address.append(_mainAddress.getCity());
                }
                address.append(", ");
                if (_mainAddress.getState() != null) {
                    address.append(_mainAddress.getState());
                }
                if (_mainAddress.getPostalCode() != null) {
                    address.append(" ").append(_mainAddress.getPostalCode());
                }
            }
        } catch (Exception ex) {
            _logger.error("getMergedAddressLine-1: " + ex.getMessage());
        }
        return address.toString();
    }

    /**
     * 
     * @param localeInformation
     * @return
     */
    public String getMergedAddressOneLine(IPartyLocaleInformation localeInformation) {

        StringBuilder address = new StringBuilder();
        try {
            if (localeInformation != null) {
                if (StringUtils.isNotEmpty(localeInformation.getAddress1())) {
                    address.append(localeInformation.getAddress1());
                    address.append(", ");
                }

                if (StringUtils.isNotEmpty(localeInformation.getAddress2())) {
                    address.append(localeInformation.getAddress2());
                    address.append(", ");
                }

                if (StringUtils.isNotEmpty(localeInformation.getAddress3())) {
                    address.append(localeInformation.getAddress3());
                    address.append(", ");
                }

                if (StringUtils.isNotEmpty(localeInformation.getAddress4())) {
                    address.append(localeInformation.getAddress4());
                    address.append(", ");
                }

                if (localeInformation.getCity() != null) {
                    address.append(localeInformation.getCity());
                    address.append(", ");
                }

                if (localeInformation.getState() != null) {
                    address.append(localeInformation.getState());
                    if (localeInformation.getPostalCode() != null) {
                        address.append(" ").append(localeInformation.getPostalCode());
                    }
                } else {
                    if (StringUtils.isNotEmpty(address)) {
                        address = new StringBuilder(address.subSequence(0, address.length() - 2));
                        if (localeInformation.getPostalCode() != null) {
                            address.append(" ").append(localeInformation.getPostalCode());
                        }
                    }
                }

            }
        } catch (Exception ex) {
            _logger.error("getAddressLine-1: " + ex.getMessage());
        }
        return address.toString();
    }

    /**
     * 
     * @param jsonCustomer
     * @return
     */
    public String getMergedAddressOneLine(String jsonCustomer) {

        StringBuilder addressLine = new StringBuilder();
        if (StringUtils.isNotEmpty(jsonCustomer)) {
            try {
                JSONObject customerJsonObj = new JSONObject(jsonCustomer);

                if (!customerJsonObj.isNull(CawJSONConstant.JSON_ADDRESS)
                        && customerJsonObj.getJSONObject(CawJSONConstant.JSON_ADDRESS) != null) {

                    JSONObject addressJsonObj = customerJsonObj.getJSONObject(CawJSONConstant.JSON_ADDRESS);
                    if (!addressJsonObj.isNull(CawJSONConstant.JSON_LINE1)
                            && StringUtils.isNotEmpty(addressJsonObj.getString(CawJSONConstant.JSON_LINE1))) {
                        addressLine.append(addressJsonObj.getString(CawJSONConstant.JSON_LINE1));
                        addressLine.append(", ");
                    }

                    if (!addressJsonObj.isNull(CawJSONConstant.JSON_LINE2)
                            && StringUtils.isNotEmpty(addressJsonObj.getString(CawJSONConstant.JSON_LINE2))) {
                        addressLine.append(addressJsonObj.getString(CawJSONConstant.JSON_LINE2));
                        addressLine.append(", ");
                    }

                    if (!addressJsonObj.isNull(CawJSONConstant.JSON_LINE3)
                            && StringUtils.isNotEmpty(addressJsonObj.getString(CawJSONConstant.JSON_LINE3))) {
                        addressLine.append(addressJsonObj.getString(CawJSONConstant.JSON_LINE3));
                        addressLine.append(", ");
                    }

                    if (!addressJsonObj.isNull(CawJSONConstant.JSON_LINE4)
                            && StringUtils.isNotEmpty(addressJsonObj.getString(CawJSONConstant.JSON_LINE4))) {
                        addressLine.append(addressJsonObj.getString(CawJSONConstant.JSON_LINE4));
                        addressLine.append(", ");
                    }

                    if (!addressJsonObj.isNull(CawJSONConstant.JSON_CITY)
                            && StringUtils.isNotEmpty(addressJsonObj.getString(CawJSONConstant.JSON_CITY))) {
                        addressLine.append(addressJsonObj.getString(CawJSONConstant.JSON_CITY));
                        addressLine.append(", ");
                    }

                    if (!addressJsonObj.isNull(CawJSONConstant.JSON_STATE)
                            && StringUtils.isNotEmpty(addressJsonObj.getString(CawJSONConstant.JSON_STATE))) {
                        addressLine.append(addressJsonObj.getString(CawJSONConstant.JSON_STATE));
                        addressLine.append(" ");

                        if (!addressJsonObj.isNull(CawJSONConstant.JSON_POSTAL_CODE)
                                && StringUtils.isNotEmpty(addressJsonObj.getString(CawJSONConstant.JSON_POSTAL_CODE))) {
                            addressLine.append(addressJsonObj.getString(CawJSONConstant.JSON_POSTAL_CODE));
                        }
                    } else {
                        if (!addressJsonObj.isNull(CawJSONConstant.JSON_POSTAL_CODE)
                                && StringUtils.isNotEmpty(addressJsonObj.getString(CawJSONConstant.JSON_POSTAL_CODE))) {
                            if (StringUtils.isNotEmpty(addressLine)) {
                                addressLine = new StringBuilder(addressLine.subSequence(0, addressLine.length() - 1));
                                addressLine.append(addressJsonObj.getString(CawJSONConstant.JSON_POSTAL_CODE));
                            }
                        }
                    }

                }
            } catch (Exception ex) {
                _logger.error("Can not parse address of the customer");
            }
        }

        return addressLine.toString();
    }

    /**
     * The method get country code of the customer.
     * if EBS online, The country code will get from ESB response.
     * else if the customer offline, the country code will get from database.
     * @param customerJson
     */
    public String getCountryCodeFromJson(String customerJson) {

        String countryCode = null;
        if (StringUtils.isNotEmpty(customerJson)) {
            JSONObject customerLoopkupJson = CawJSONUtils.toJSONObject(customerJson);
            if (customerLoopkupJson != null) {
                try {
                    if (!customerLoopkupJson.isNull(CawJSONConstant.JSON_COUNTRY)) {
                        JSONObject addressObj = customerLoopkupJson.getJSONObject(CawJSONConstant.JSON_COUNTRY);
                        if (addressObj != null) {
                            countryCode = CawJSONUtils.getString(addressObj, CawJSONConstant.JSON_COUNTRY);
                            if (countryCode != null && countryCode.length() > 2) {
                                countryCode = countryCode.substring(0, 2);
                            }
                        }
                    }
                } catch (Exception ex) {
                    _logger.error("Can not get country code." + ex.getMessage());
                }
            }
        }
        return countryCode;
    }

    //End BZ25358 and BZ26575
    //Begin BZ26575
    private String ConverrtCountryMapping(String countryAlpha2) {

        String country_language = CawEBSConstant.USA;
        if (!Strings.isNullOrEmpty(countryAlpha2)) {
            if (CawEBSConstant.US_COUNTRY.equalsIgnoreCase(countryAlpha2)) {
                country_language = CawEBSConstant.US;
            } else if (CawEBSConstant.CAN_COUNTRY.equalsIgnoreCase(countryAlpha2)) {
                country_language = CawEBSConstant.CA;
            }
        }
        return country_language;
    }

    public AddressSearchInfo getAddressSearchInfo(CawVerifyLevelType verifyLevel, CawQAAddressType address) {

        AddressSearchInfo addressSearchInfo = null;
        try {
            if (address != null && address.getAddressLine() != null && address.getAddressLine().size() > 0) {

                List<CawAddressLineType> addressLines = address.getAddressLine();

                AddressVerificationResponse addressResponse = new AddressVerificationResponse();
                addressResponse.setSearchResult(SearchResultEnum.FORMATTED_ADDRESS_AVAILABLE);
                IPartyLocaleInformation retrievedAddressInfo = adapt(addressLines);
                addressResponse.setRetrievedAddress(retrievedAddressInfo);
                addressResponse
                        .setRetrievedAddressNotComplete(adaptRetrievedAddressIncomplete(retrievedAddressInfo, verifyLevel));
                addressSearchInfo = addressLookup(addressResponse);
            }
        } catch (Exception ex) {
            _logger.error("getAddressSearchInfo-1: " + ex.getMessage());
        }

        return addressSearchInfo;
    }
    //End BZ26575
}
