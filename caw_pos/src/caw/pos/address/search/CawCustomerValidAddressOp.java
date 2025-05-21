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
 * BZ26575          140618    [QAS] Update address verification flow to reduce the number of click in the QAS process
 * BZ26564          140618    [Internal] QAS search sent tag country incorrectly the address of customer which country is CAN
 * BZ26836          170718    [Internal][QAS]There are not consistent result found from QAS validation when doing QAS process via Assign&Continue and Save&Changes with the same address.
 * BZ29600          050319    [Internal] Xstore should not allow to edit wholesale customer
 * BZ33497          291019    [INTERNAL] EBS responded 400 107:Customer updates not allowedCustomer has Crew membership that prevents updates
 * BZ33598          231219    [Prod] QAS address match issues
 *===================================================================
 */

package caw.pos.address.search;

import java.util.List;

import javax.inject.Inject;

import org.apache.commons.lang3.StringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import caw.pos.advance.prompting.CawCatalystHelper;
import caw.pos.araccount.CawCustomerUtil;
import caw.pos.common.CawConstants;
import caw.pos.common.CawValueKeys;
import caw.qas.proweb.*;

import dtv.pos.common.PromptKey;
import dtv.pos.framework.op.Operation;
import dtv.pos.iframework.IBusyState;
import dtv.pos.iframework.event.IXstEvent;
import dtv.pos.iframework.op.IOpResponse;
import dtv.pos.spring.ValueKeys;
import dtv.xst.dao.crm.IParty;
import dtv.xst.dao.crm.IPartyLocaleInformation;

/**
 *
 */
public class CawCustomerValidAddressOp extends Operation {

    // Begin BZ26836
    private static final String          MANY_ADDRESS_RESULT_MSG = "_messageManyAddressResults";

    private static final String          ADDRESS_NOT_FOUND_MSG   = "_cawAddressNotifyMsg";
    // End BZ26836

    @Inject
    private IBusyState                   _busyState;

    private static final Logger          _logger                 = LogManager
            .getLogger(CawCustomerValidAddressOp.class);

    private CawPromptAddressLookupHelper _addressHelper          = CawPromptAddressLookupHelper.getInstance();

    @Override
    public boolean isOperationApplicable() {

        IParty party = getScopedValue(ValueKeys.SELECTED_CUSTOMER);
        if (party != null) {
            _logger.debug("The current party Id." + party.getPartyId());
            /* BEGIN BZ29600 */
            boolean isRun = true;
            /* BEGIN BZ33497 -> BZ33598: checking allowEdit for all kinds of customer, allowEdit = true -> run address validation*/
            if (!CawCustomerUtil.isAllowEdit()) {
                isRun = false;
            }
            /* END BZ33497 -> BZ33598*/
            /* END BZ29600 */
            if (isRun) {
                String customerInforStr = CawCatalystHelper.getLookupResponseData();
                String countryAlpha2 = _addressHelper.getCountryCodeFromJson(customerInforStr);
                if (StringUtils.isEmpty(countryAlpha2) && party.getCountry() != null) {
                    countryAlpha2 = party.getCountry();
                }
                if (countryAlpha2 != null && _addressHelper.isCountryQASEnabled(countryAlpha2)) {
                    //BZ26564 only check when address is in CA or US
                    return true;
                }
            }
        }

        return false;
    }

    @Override
    public IOpResponse handleOpExec(IXstEvent argArg0) {

        IParty party = getScopedValue(ValueKeys.SELECTED_CUSTOMER);
        if (party != null) {
            // Get address of customer

            String customerInforStr = CawCatalystHelper.getLookupResponseData();
            String countryAlpha2 = _addressHelper.getCountryCodeFromJson(customerInforStr);
            if (StringUtils.isEmpty(countryAlpha2) && party.getCountry() != null) {
                countryAlpha2 = party.getCountry();
            } else {
                countryAlpha2 = getScopedValue(ValueKeys.ADDRESS_LOOKUP_COUNTRY); //Added BZ26564
            }
            String addressRequestStr = _addressHelper.getMergedAddressOneLine(customerInforStr);
            if (StringUtils.isEmpty(addressRequestStr)) {
                if (party.getLocaleInformation() != null && party.getLocaleInformation().size() > 0) {
                    List<IPartyLocaleInformation> iPartyLocaleInformation = party.getLocaleInformation();
                    IPartyLocaleInformation localeInformation = iPartyLocaleInformation.get(0);
                    addressRequestStr = _addressHelper.getMergedAddressOneLine(localeInformation);
                }
            }

            // Check address of cutomer via QAS 
            CawQASearchResult resultLookup = null;
            if (addressRequestStr != null) {
                _logger.debug("The address of the current customer." + addressRequestStr);

                _busyState.start(CawConstants.BUSY_STATE_MSG);
                resultLookup = _addressHelper.doSearchAddress(addressRequestStr, countryAlpha2);
                _busyState.end();

                if (resultLookup != null && resultLookup.getVerifyLevel() != null) {
                    /*
                     *  When the result of lookup return VerifyLevel are INTERACTION_REQUIRED or VERIFIED,
                     *  That mean QAS return one address.
                     */
                    if (resultLookup.getVerifyLevel().equals(CawVerifyLevelType.INTERACTION_REQUIRED)
                            || resultLookup.getVerifyLevel().equals(CawVerifyLevelType.VERIFIED)) {
                        _logger.debug("The QAS response result VERIFIED or INTERACTION_REQUIRED");
                        if (resultLookup.getQAAddress() != null && resultLookup.getQAAddress().getAddressLine() != null
                                && resultLookup.getQAAddress().getAddressLine().size() > 0) {
                            List<CawAddressLineType> addressLines = resultLookup.getQAAddress().getAddressLine();

                            IPartyLocaleInformation partyLocaleInformation = _addressHelper.adapt(addressLines);
                            String addressResponseStr = _addressHelper.getMergedAddressOneLine(partyLocaleInformation);
                            if (addressResponseStr != null) {
                                _logger.debug("The address of customer response from QAS." + addressResponseStr);
                                if (!addressRequestStr.equalsIgnoreCase(addressResponseStr)) {
                                    // Display dialog for user confirm.
                                    setScopedValue(CawValueKeys.IS_ADDRESS_DIALOG_DISPLAY, CawConstants.CONFIRM);
                                    setScopedValue(CawValueKeys.CAW_CUSTOMER_ADDRESS_INFO, partyLocaleInformation);
                                    setScopedValue(CawValueKeys.CAW_CUSTOMER_ADDRESS_LINES, addressLines);
                                }
                            } else {
                                _logger.debug("The address of current customer does not equal with address response from QAS.");
                                // Will redirect to Sale screen.
                                setScopedValue(CawValueKeys.IS_ADDRESS_DIALOG_DISPLAY, CawConstants.NOT_DISPAY);
                            }
                        }
                    } else if (resultLookup.getVerifyLevel().equals(CawVerifyLevelType.PREMISES_PARTIAL)
                            || resultLookup.getVerifyLevel().equals(CawVerifyLevelType.STREET_PARTIAL) //BZ26836
                            || resultLookup.getVerifyLevel().equals(CawVerifyLevelType.MULTIPLE)) {
                        // Begin BZ26836
                        if (resultLookup.getQAPicklist() != null
                                && resultLookup.getQAPicklist().getPicklistEntry() != null) {
                            int picklistLength = resultLookup.getQAPicklist().getPicklistEntry().size();
                            if (picklistLength > _addressHelper.getPicklistEntryLimit()) {
                                setScopedValue(CawValueKeys.IS_ADDRESS_DIALOG_DISPLAY, CawConstants.NOTIFY);
                                setScopedValue(CawValueKeys.ADDRESS_MESSAGES_DISPLAY, MANY_ADDRESS_RESULT_MSG);
                            } else {
                                // Display notify screen.
                                setScopedValue(CawValueKeys.IS_ADDRESS_MULTIPLE_DISPLAY, CawConstants.MULTIPLE_DISPAY);
                                setScopedValue(CawValueKeys.CAW_QAS_SEARCH_RESULT, resultLookup);
                            }
                        }
                        // End BZ26836

                    } else {
                        _logger.debug("The QAS is the response not result");
                        // No record, the display notify screen.
                        setScopedValue(CawValueKeys.IS_ADDRESS_DIALOG_DISPLAY, CawConstants.NOTIFY);
                        setScopedValue(CawValueKeys.ADDRESS_MESSAGES_DISPLAY, ADDRESS_NOT_FOUND_MSG); //BZ26836
                    }
                } else {
                    // if QAS is offline then redirect to sale screen.
                    if (CawQASHelper.getInstance().isOffline()) {
                        _logger.debug("The QAS is Offline");
                        setScopedValue(CawValueKeys.IS_ADDRESS_DIALOG_DISPLAY, CawConstants.NOT_DISPAY);
                        return HELPER.getCompletePromptResponse(PromptKey.valueOf("CAW_QAS_CHECK_CONNECTION"));
                    } else {
                        _logger.debug("The QAS is the response not result");
                        // No record, the display notify screen.
                        setScopedValue(CawValueKeys.IS_ADDRESS_DIALOG_DISPLAY, CawConstants.NOTIFY);
                        setScopedValue(CawValueKeys.ADDRESS_MESSAGES_DISPLAY, ADDRESS_NOT_FOUND_MSG); //BZ26836
                    }
                }
            }
        }

        return HELPER.completeResponse();
    }
}
