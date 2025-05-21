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
 * BZ29372          150218    [Requirement] PLCC Account Lookup - ID Verification Screen new request
 * BZ29340          220219    [Internal][Account Lookup]Pin Pad does not display Government-Issued Photo ID form simultaneously with Xstore Account Found screen which retrieved successfully from ADS
 *===================================================================
 */

package caw.tenderauth.impl.eigen.accountlookup.op;

import javax.inject.Inject;

import org.apache.commons.lang3.StringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import caw.pos.advance.prompting.CawInputSingleChoice;
import caw.pos.common.CawAccountLookupConstant;
import caw.tenderauth.impl.eigen.CawEigenHelper;
import caw.tenderauth.impl.eigen.goodsam.common.CawCustomerGSHelper;
import twitter4j.JSONObject;

import dtv.data2.access.DataPropertyUtils;
import dtv.i18n.FormattableFactory;
import dtv.pos.common.FormKey;
import dtv.pos.common.OpChainKey;
import dtv.pos.framework.op.AbstractFormOp;
import dtv.pos.framework.validation.ValidationResultList;
import dtv.pos.iframework.action.IXstActionKey;
import dtv.pos.iframework.action.IXstDataAction;
import dtv.pos.iframework.event.IXstEvent;
import dtv.pos.iframework.op.IOpResponse;
import dtv.pos.iframework.validation.IValidationResultList;
import dtv.pos.iframework.validation.SimpleValidationResult;
import dtv.xst.dao.trn.IPosTransaction;

/**
 *
 */
public class CawAccountLookupValidationOp extends AbstractFormOp<CawAccountLookupValidationModel> {

    private static final Logger  _logger                       = LogManager
            .getLogger(CawAccountLookupValidationOp.class);

    private final FormKey        CAW_ACCOUNT_LOOKUP_VALIDATION = FormKey.valueOf("CAW_ACCOUNT_LOOKUP_VALIDATION");

    private static final String  BUTTON_BACK                   = "BACK";

    @Inject
    private CawEigenHelper       _cawEigenHelper;                                                                 // BZ29340

    @Inject
    protected FormattableFactory ff;

    @Override
    protected FormKey getFormKey() {

        return CAW_ACCOUNT_LOOKUP_VALIDATION;
    }

    private CawCustomerGSHelper _gsHelper = CawCustomerGSHelper.getInstance();

    @Override
    protected CawAccountLookupValidationModel createModel() {

        CawAccountLookupValidationModel model = new CawAccountLookupValidationModel();
        model.setAccountFirstName(_gsHelper.getFirstNameADS());
        model.setAccountLastName(_gsHelper.getLastNameADS());

        CawInputSingleChoice card = new CawInputSingleChoice();
        card.setInputId(CawAccountCardType.SELECT_CARD_TYPE.getType());
        card.setInputLable(CawAccountCardType.SELECT_CARD_TYPE.getName());
        model.setAcountCardType(card);

        CawInputSingleChoice state = new CawInputSingleChoice();
        state.setInputId(CawAccountLookupValidationModel.EMPTY_STRING);
        state.setInputLable(CawAccountLookupValidationModel.SELECT_STATE);
        model.setAcountState(state);

        return model;
    }

    @Override
    protected IOpResponse handleInitialState() {

        return super.handleInitialState();
    }

    @Override
    protected IOpResponse handleFormResponse(IXstEvent argEvent) {

        if (argEvent != null && argEvent.getData() != null) {
            CawAccountLookupValidationModel lookupValidationModel = (CawAccountLookupValidationModel) argEvent
                    .getData();
            try {
                lookupValidationModel.getAcountCardType();
                JSONObject accountInfo = new JSONObject();
                accountInfo
                        .put(CawAccountLookupConstant.ACCOUNT_FIRST_NAME, CawAccountLookupValidationModel.EMPTY_STRING);
                if (StringUtils.isNotEmpty(lookupValidationModel.getAccountFirstName())) {
                    accountInfo.put(CawAccountLookupConstant.ACCOUNT_FIRST_NAME, lookupValidationModel
                            .getAccountFirstName());
                }

                accountInfo
                        .put(CawAccountLookupConstant.ACCOUNT_LAST_NAME, CawAccountLookupValidationModel.EMPTY_STRING);
                if (StringUtils.isNotEmpty(lookupValidationModel.getAccountLastName())) {
                    accountInfo.put(CawAccountLookupConstant.ACCOUNT_LAST_NAME, lookupValidationModel
                            .getAccountLastName());
                }

                accountInfo
                        .put(CawAccountLookupConstant.ACCOUNT_CARD_TYPE_CODE, CawAccountLookupValidationModel.EMPTY_STRING);
                accountInfo
                        .put(CawAccountLookupConstant.ACCOUNT_CARD_TYPE_TEXT, CawAccountLookupValidationModel.EMPTY_STRING);
                accountInfo
                        .put(CawAccountLookupConstant.ACCOUNT_STATE_CODE, CawAccountLookupValidationModel.EMPTY_STRING);
                accountInfo
                        .put(CawAccountLookupConstant.ACCOUNT_STATE_TEXT, CawAccountLookupValidationModel.EMPTY_STRING);
                if (lookupValidationModel.getAcountCardType() != null) {
                    CawInputSingleChoice cardType = (CawInputSingleChoice) lookupValidationModel.getAcountCardType();
                    accountInfo.put(CawAccountLookupConstant.ACCOUNT_CARD_TYPE_CODE, cardType.getInputId());
                    accountInfo.put(CawAccountLookupConstant.ACCOUNT_CARD_TYPE_TEXT, cardType.getInputLable());

                    if (cardType.getInputId().equals(CawAccountCardType.DRIVER_LICENSE.getType())) {
                        if (lookupValidationModel.getAcountState() != null) {
                            CawInputSingleChoice accountState = (CawInputSingleChoice) lookupValidationModel
                                    .getAcountState();
                            accountInfo.put(CawAccountLookupConstant.ACCOUNT_STATE_CODE, accountState.getInputId());
                            accountInfo.put(CawAccountLookupConstant.ACCOUNT_STATE_TEXT, accountState.getInputLable());
                        }
                    }
                }

                // Persist the data of Identification Validation form to database.
                IPosTransaction trans = _transactionScope.getTransaction();
                if (trans != null) {
                    DataPropertyUtils
                            .setPropertyValue(trans, CawAccountLookupConstant.PROPERTY_ACOUNT_LOOPKUP, accountInfo
                                    .toString());
                }
            } catch (Exception ex) {
                _logger.error("Can not parse data of the Identification Validation form to JSON." + ex.getMessage());
            }
        }
        _cawEigenHelper.refreshPinpadScreen(_transactionScope); // BZ29340
        return super.handleFormResponse(argEvent);
    }

    @Override
    protected IValidationResultList validateForm(CawAccountLookupValidationModel argArgModel) {

        IValidationResultList list = new ValidationResultList();
        if (argArgModel.getAcountCardType() == null) {
            list.add(SimpleValidationResult.getFailed("_fieldRequired", CawAccountLookupConstant.ID_TYPE));
        } else {
            CawInputSingleChoice cardType = (CawInputSingleChoice) argArgModel.getAcountCardType();
            if (StringUtils.equalsIgnoreCase(cardType.getInputId(), CawAccountCardType.SELECT_CARD_TYPE.getType())) {
                list.add(SimpleValidationResult.getFailed("_fieldRequired", CawAccountLookupConstant.ID_TYPE));
            } else if (StringUtils
                    .equalsIgnoreCase(cardType.getInputId(), CawAccountCardType.DRIVER_LICENSE.getType())) {
                if (argArgModel.getAcountState() != null) {
                    CawInputSingleChoice acountState = (CawInputSingleChoice) argArgModel.getAcountState();
                    if (StringUtils.isEmpty(acountState.getInputId())) {
                        list.add(SimpleValidationResult.getFailed("_fieldRequired", CawAccountLookupConstant.STATE));
                    }
                }
            }
        }

        return argArgModel.validate(list);
    }

    @Override
    protected IOpResponse handleDataAction(IXstDataAction argAction) {

        IXstActionKey key = argAction.getActionKey();
        if (BUTTON_BACK.equals(key.toString())) {
            return HELPER.getWaitStackChainResponse(OpChainKey.valueOf("CAW_GOOD_SAM_ACCOUNT_LOOKUP_CONFIRM"));
        } else {
            return super.handleDataAction(argAction);
        }

    }

}
