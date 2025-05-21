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
 * BZ51471          191022    [NEW] Change the loyalty offers flow and prompts
 * BZ52837          171022    [UAT] Reward and Promo Offer Adjustments need to use unique couponCodes 
 * BZ53627          151122    [UAT] Received system error after clicking Suspend Transaction button
 * BZ54290          160823    [PROD] Points are being earned on S&I PrePay Work Order Transactions
 *===================================================================
 */

package caw.pos.cheetah.promotion;

import static dtv.pos.common.TransactionType.RETAIL_SALE;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import caw.pos.advance.prompting.CawCatalystHelper;
import caw.pos.common.CawValueKeys;

import dtv.data2.access.DataFactory;
import dtv.data2.access.impl.DaoState;
import dtv.data2.access.impl.IDataModelImpl;
import dtv.pos.common.*;
import dtv.pos.framework.op.Operation;
import dtv.pos.iframework.event.IXstEvent;
import dtv.pos.iframework.op.IOpResponse;
import dtv.xst.dao.crm.IParty;
import dtv.xst.dao.trl.*;

/**
 *
 */
public class CawPreApplyPromotionsOp extends Operation{

    @Override
    public IOpResponse handleOpExec(IXstEvent argArg0) {
        //BEGIN BZ51471
        IRetailTransaction trans = _transactionScope.getTransaction(RETAIL_SALE);
        String jsonMessage = CawCatalystHelper.getLookupResponseData();
        if (trans == null || trans.getCustomerParty() == null) {
            return HELPER.getCompleteStackChainResponse(OpChainKey.valueOf("CUST_ASSOCIATION"));
        }
        IParty cust = trans.getCustomerParty();
        if(cust != null && _transactionScope.getValue(CawValueKeys.IS_LOYALTY_CUSTOMER) != null
                && _transactionScope.getValue(CawValueKeys.IS_LOYALTY_CUSTOMER)) { //BZ54290
//            _transactionScope.setValue(CawValueKeys.IS_APPLY_PROMOS_REWARD, Boolean.TRUE);
            removePromoBeforeApply(); //BZ51471
            return HELPER.completeResponse();
        }
        return HELPER.getPromptResponse(PromptKey.valueOf("CAW_CUST_NO_OFFER_CAN_APPLY"));
        //END BZ51471
    }
    //BEGIN BZ51471
    private void removePromoBeforeApply() {
        IRetailTransaction _transaction = this._transactionScope.getTransaction(TransactionType.RETAIL_SALE);
        List<ISaleReturnLineItem> saleReturnLines = _transaction.getLineItems(ISaleReturnLineItem.class);
        saleReturnLines.stream().forEach(saleline->{
            List<IRetailPriceModifier> retailPriceModifiers = saleline.getRetailPriceModifiers();
            Set<IRetailPriceModifier> removes = retailPriceModifiers.stream().filter(priceMod->
            priceMod.getStringProperty("IS_PROMO")!=null).collect(Collectors.toSet()); //BZ52837
            removes.stream().forEach(priceMod->{
            	//Start BZ53627
            	priceMod.setVoid(true);
                //saleline.removeRetailPriceModifier(priceMod);
               
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
        CawCatalystHelper.setOfferApplyLoyalty(null); 
    }
    //END BZ51471
}
