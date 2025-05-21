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
 * BZ53797          231122    [UAT]Loyalty offers are not removed after Suspend/Resume transaction
 * BZ54290          160823    [PROD] Points are being earned on S&I PrePay Work Order Transactions
 * BZ54126          030823    BTM-268: Suspend Resume transaction displays blank error prompt and xstore is not able to proceed with any other transactions
 *===================================================================
 */

package caw.pos.cheetah;

import static dtv.pos.common.TransactionType.RETAIL_SALE;

import java.util.List;
import java.util.Set;
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
import dtv.xst.dao.crm.IParty;
import dtv.xst.dao.trl.*;

/**
 *
 */
public class CawRemoveOfferOp extends Operation{

    @Override
    public IOpResponse handleOpExec(IXstEvent argArg0) {
        IRetailTransaction trans = _transactionScope.getTransaction(RETAIL_SALE);
        IParty cust = trans.getCustomerParty();
        String jsonMessage = CawCatalystHelper.getLookupResponseData();
        if(cust != null && _transactionScope.getValue(CawValueKeys.IS_LOYALTY_CUSTOMER) != null
                && _transactionScope.getValue(CawValueKeys.IS_LOYALTY_CUSTOMER)) { //BZ54290
            IRetailTransaction _transaction = this._transactionScope.getTransaction(TransactionType.RETAIL_SALE);
            List<ISaleReturnLineItem> saleReturnLines = _transaction.getLineItems(ISaleReturnLineItem.class);
            saleReturnLines.stream().forEach(saleline->{
                List<IRetailPriceModifier> retailPriceModifiers = saleline.getRetailPriceModifiers();
                Set<IRetailPriceModifier> removes = retailPriceModifiers.stream().filter(priceMod->
                priceMod.getStringProperty("IS_PROMO")!=null).collect(Collectors.toSet()); //BZ52837
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
            CawCatalystHelper.setOfferApplyLoyalty(null);
        }
        return HELPER.completeResponse();         
    }
}
