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
 * BZ46743          100122    Vehicle Identification Number (VIN) Capture for Xstore
 *===================================================================
 */

package caw.pos.order;

import java.util.Iterator;
import java.util.List;

import org.apache.commons.lang3.BooleanUtils;

import caw.pos.common.CawConstants;
import caw.pos.common.CawValueKeys;
import caw.pos.register.vin.CawVinHelper;

import dtv.pos.common.OpChainKey;
import dtv.pos.framework.op.OpState;
import dtv.pos.framework.op.Operation;
import dtv.pos.iframework.event.IXstEvent;
import dtv.pos.iframework.op.*;
import dtv.pos.spring.ValueKeys;
import dtv.xst.dao.xom.IOrderLine;

/**
 *
 */
public class CawProcessVinItemsToPickupOp extends Operation {
    
    private Iterator<IOrderLine> _orderLineIterator;
    private IOrderLine _currentOrderLine;
    
    private final IOpState PROCESSING_STATE = new OpState("PROCESSING_STATE");

    @Override
    public IOpResponse handleOpExec(IXstEvent argArg0) {

        IOpResponse response = HELPER.completeResponse();
        
        if (getOpState() == null) {
            setOpState(PROCESSING_STATE);
            List<IOrderLine> linesToPickup = getScopedValue(ValueKeys.ORDER_LINES_TO_PROCESS);
            this._orderLineIterator = linesToPickup.iterator();
            response = handleNextOrderLine();
        } else {
            if (BooleanUtils.isFalse(_transactionScope.getValue(CawValueKeys.IS_VIN_LINE_VIN_SET))) {
                this._orderLineIterator.remove();
            }
            
            response = handleNextOrderLine();
        }
        
        if (response.getOpStatus().equals(OpStatus.COMPLETE)) {
            _transactionScope.clearValue(CawValueKeys.VIN_LINE_ITEM);
        }
        
        return response;
    }
    
    protected IOpResponse handleNextOrderLine() {
        IOpResponse response = this.HELPER.completeResponse();
        
        if (this._orderLineIterator.hasNext()) {
            
            this._currentOrderLine = _orderLineIterator.next();
            
            if (CawVinHelper.isVinItem(this._currentOrderLine.getShadowedSaleItem().getItem())) {
                _transactionScope.setValue(CawValueKeys.VIN_LINE_ITEM, _currentOrderLine);
                _transactionScope.clearValue(CawValueKeys.IS_VIN_LINE_VIN_SET);
                
                response = HELPER.getWaitStackChainResponse(OpChainKey.valueOf(CawConstants.CAW_VIN_VERIFICATION_CHAIN_NAME));
            }
        }
        
        return response;
    }
}

