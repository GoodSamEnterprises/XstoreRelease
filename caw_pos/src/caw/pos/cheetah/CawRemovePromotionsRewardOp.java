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
 * BZ49449          280422    [Internal] - The promotions were removed incorrectly
 * BZ50442          130622    Redemption data missing in request
 * BZ51471          191022    [NEW] Change the loyalty offers flow and prompts
 * BZ52837          171022    [UAT] Reward and Promo Offer Adjustments need to use unique couponCodes 
 * BZ53627          151122    [UAT] Received system error after clicking Suspend Transaction button
 * BZ54126          030823    BTM-268: Suspend Resume transaction displays blank error prompt and xstore is not able to proceed with any other transactions 
 *===================================================================
 */

package caw.pos.cheetah;

import java.util.*;
import java.util.stream.Collectors;

import caw.pos.advance.prompting.CawCatalystHelper;
import caw.pos.common.CawValueKeys;

import dtv.data2.access.DataFactory;
import dtv.data2.access.impl.DaoState;
import dtv.data2.access.impl.IDataModelImpl;
import dtv.pos.common.TransactionType;
import dtv.pos.framework.op.Operation;
import dtv.pos.iframework.event.IXstEvent;
import dtv.pos.iframework.op.IOpResponse;
import dtv.xst.dao.trl.*;

public class CawRemovePromotionsRewardOp extends Operation {

    @Override
    public IOpResponse handleOpExec(IXstEvent argArg0) {
        //BEGIN BZ52837
        IRetailTransaction _transaction = this._transactionScope.getTransaction(TransactionType.RETAIL_SALE);
        List<ISaleReturnLineItem> saleReturnLines = _transaction.getLineItems(ISaleReturnLineItem.class);
        saleReturnLines.stream().forEach(saleline->{
            List<IRetailPriceModifier> retailPriceModifiers = saleline.getRetailPriceModifiers();
            Set<IRetailPriceModifier> removes = retailPriceModifiers.stream().filter(priceMod->
            priceMod.getStringProperty("IS_REWARD")!=null).collect(Collectors.toSet()); //BZ52837
            removes.stream().forEach(priceMod->{
                //saleline.removeRetailPriceModifier(priceMod);//BZ54126 remove this line
                priceMod.setVoid(true);//BZ54126 
                //Start BZ53627
                List<IRetailPriceModifierProperty> priceModProps = priceMod.getProperties();
                for (IRetailPriceModifierProperty priceModProp : priceModProps) {
                    
                    IRetailPriceModifierProperty model = DataFactory
                            .createObject(IRetailPriceModifierProperty.class);
                    model = priceModProp;
                    
                    ((IDataModelImpl) model).getDAO().setObjectState(DaoState.DELETED.intVal());
                }
                //End BZ53627
            });
        });
        //BEGIN BZ52837
        _transactionScope.clearValue(CawValueKeys.IS_APPLY_PROMOS_REWARD);
        //Start BZ50442
        CawCatalystHelper.setRewardApplyLoyalty(null);
        //End BZ50442
        return HELPER.completeResponse();
    }

}
