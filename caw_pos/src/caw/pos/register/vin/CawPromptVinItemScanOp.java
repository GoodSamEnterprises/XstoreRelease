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
 * BZ46743          050122    Vehicle Identification Number (VIN) Capture for Xstore
 * BZ48082          100122    New: Patch 19 - VIN Item - Xstore should NOT bypass the VIN number capture/verification when the user leaves the VIN number entry prompt blank
 *===================================================================
 */

package caw.pos.register.vin;

import org.apache.commons.lang3.StringUtils;

import caw.pos.common.CawConstants;
import caw.pos.common.CawValueKeys;

import dtv.data2.access.IHasDataProperty;
import dtv.hardware.events.ItemScanEvent;
import dtv.hardware.types.InputType;
import dtv.i18n.IFormattable;
import dtv.pos.common.PromptKey;
import dtv.pos.framework.op.OpState;
import dtv.pos.framework.op.Operation;
import dtv.pos.iframework.event.*;
import dtv.pos.iframework.op.*;
import dtv.pos.spring.ValueKeys;
import dtv.xst.dao.trl.ISaleReturnLineItem;
import dtv.xst.dao.xom.IOrderLine;

public class CawPromptVinItemScanOp extends Operation implements IXstEventObserver {
    
    private final IOpState               ENTER_VIN_STATE        = new OpState("ENTER_VIN_STATE");

    private final IOpState               VALIDATE_VIN_STATE     = new OpState("VALIDATE_VIN_STATE");

    private final IOpState               NOT_MATCH_STATE        = new OpState("NOT_MATCH_STATE");

    private final IOpState               VALIDATION_ERROR_STATE = new OpState("VALIDATION_ERROR_STATE");
    
    private IOpState                     _previousOpState;
    
    private IHasDataProperty<?>          _currentLine;

    private ISaleReturnLineItem          _currentLineSaleLine;

    private String                       vehiIdenNumber         = "";

    private static final IXstEventType[] EVENTS                 = { InputType.INPUT_ITEM };
    
    @Override
    public IXstEventType[] getObservedEvents() {

        return EVENTS;
    }

    @Override
    public boolean isOperationApplicable() {
        boolean result = super.isOperationApplicable();
        
        IHasDataProperty<?> currentLine = _transactionScope.getValue(CawValueKeys.VIN_LINE_ITEM);
        
        if (currentLine == null) {
            currentLine = getScopedValue(ValueKeys.CURRENT_SALE_LINE);
        }
        
        if (currentLine != null 
                && currentLine instanceof ISaleReturnLineItem 
                && ((ISaleReturnLineItem)currentLine).getReturn()) {
            _transactionScope.setValue(CawValueKeys.IS_GO_THROUGH_ITEM_PROPERTY_PROMPT_CHAIN, Boolean.TRUE);
            result = false;
        }
        
        return result;
    }

    /* BEGIN BZ48082 */
    @Override
    public IOpResponse handleOpExec(IXstEvent argArg) {
        IOpResponse response = HELPER.completeResponse();

        if (getOpState() == null) {
            _transactionScope.setValue(CawValueKeys.IS_VIN_LINE_VIN_SET, Boolean.FALSE);
            this._currentLine = _transactionScope.getValue(CawValueKeys.VIN_LINE_ITEM);
            
            if (this._currentLine == null) {
                this._currentLine = getScopedValue(ValueKeys.CURRENT_SALE_LINE);
            }
            
            this._currentLineSaleLine = getSaleReturnLineItem();
            
            response = handleFirstPromptVin();
            
        } else if (getOpState() == ENTER_VIN_STATE) {
            
            if (argArg instanceof ItemScanEvent) {
                // Scan VIN
                _currentLine.setStringProperty(CawConstants.CAW_VEHICLE_IDENTIFICATION_NUMBER, argArg.getStringData());
                _transactionScope.setValue(CawValueKeys.IS_VIN_LINE_VIN_SET, Boolean.TRUE);
                response = HELPER.completeResponse();
            } else {
                // Manual input VIN
                if (StringUtils.isEmpty(argArg.getStringData())) {
                    response = handleNoEntry();
                } else {
                    vehiIdenNumber = argArg.getStringData();
                    response = handleSecondPromptVin();
                }
            }
        } else if (getOpState() == VALIDATE_VIN_STATE) {
            String reTypeVin = argArg.getStringData();
            
            if (reTypeVin.equals(vehiIdenNumber)) {
                _currentLine.setStringProperty(CawConstants.CAW_VEHICLE_IDENTIFICATION_NUMBER, vehiIdenNumber);
                _transactionScope.setValue(CawValueKeys.IS_VIN_LINE_VIN_SET, Boolean.TRUE);
            } else {
                setOpState(NOT_MATCH_STATE);
                response = HELPER.getPromptResponse(PromptKey.valueOf("CAW_VIN_NUMBER_VALIDATION"), IFormattable.EMPTY);
            }
        } else if (getOpState() == NOT_MATCH_STATE) {
            response = handleFirstPromptVin();
        } else if (getOpState() == VALIDATION_ERROR_STATE) {
            if (_previousOpState == ENTER_VIN_STATE) {
                response = handleFirstPromptVin();
            } else if (_previousOpState == VALIDATE_VIN_STATE) {
                response = handleSecondPromptVin();
            }
        }
        
        if (response.getOpStatus() == OpStatus.COMPLETE) {
            _transactionScope.setValue(CawValueKeys.IS_GO_THROUGH_ITEM_PROPERTY_PROMPT_CHAIN, Boolean.TRUE);
        }
        
        return response;
    }
    
    private IOpResponse handleFirstPromptVin() {
        setOpState(ENTER_VIN_STATE);
        return getVinEntryPrompt(_currentLineSaleLine);
    }
    
    private IOpResponse handleSecondPromptVin() {
        setOpState(VALIDATE_VIN_STATE);
        return getVinVerifyPrompt(_currentLineSaleLine);
    }
    
    private IOpResponse handleNoEntry() {
        _previousOpState = getOpState();
        setOpState(VALIDATION_ERROR_STATE);
        return getValidationErrorMessasge();
    }
    
    private IOpResponse getValidationErrorMessasge() {
        IFormattable[] format = new IFormattable[1];
        format[0] = _formattables.getTranslatable("_entryIsRequired");
        return HELPER.getPromptResponse(PromptKey.valueOf("VALIDATION_ERROR_MESSAGE"), format);
    }
    /* END BZ48082 */
    
    private IOpResponse getVinVerifyPrompt(ISaleReturnLineItem lineItem) {
        IFormattable[] promptArgs = new IFormattable[2];
        
        promptArgs[0] = _formattables.getSimpleFormattable(lineItem.getItemId());
        
        if (StringUtils.isEmpty(lineItem.getEnteredDescription())) {
            promptArgs[1] = _formattables.getSimpleFormattable(lineItem.getItemDescription());
        } else {
            promptArgs[1] = _formattables.getSimpleFormattable(lineItem.getEnteredDescription());
        }
        
        return HELPER.getPromptResponse(PromptKey.valueOf("CAW_VIN_ITEM_RE_SCAN"), promptArgs);
    }
    
    private IOpResponse getVinEntryPrompt(ISaleReturnLineItem lineItem) {
        IFormattable[] promptArgs = new IFormattable[2];
        
        promptArgs[0] = _formattables.getSimpleFormattable(lineItem.getItemId());
        
        if (StringUtils.isEmpty(lineItem.getEnteredDescription())) {
            promptArgs[1] = _formattables.getSimpleFormattable(lineItem.getItemDescription());
        } else {
            promptArgs[1] = _formattables.getSimpleFormattable(lineItem.getEnteredDescription());
        }
        
        return HELPER.getPromptResponse(PromptKey.valueOf("CAW_VIN_ITEM_SCAN"), promptArgs);
    }
    
    private ISaleReturnLineItem getSaleReturnLineItem() {
        ISaleReturnLineItem result = null;
        
        if (this._currentLine instanceof ISaleReturnLineItem) {
            result = (ISaleReturnLineItem)this._currentLine;
        } else if (this._currentLine instanceof IOrderLine) {
            result = ((IOrderLine)this._currentLine).getShadowedSaleItem();
        }
        
        return result;
    }
}
