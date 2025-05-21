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
 * BZ48629          250222    [Task] Print Points Balances - Sale transaction
 * BZ49747          290422    [Internal] Loyalty receipt - Redeemable Value should be printed with two decimal digits for the amount value 
 * BZ53149          261022    [Internal] Missing "Points Expiring at Month End" field on the receipt. 
 * BZ52876          071122    [UAT] Loyalty info is not getting printed in POS receipt
 * BZ53389          081122    [UAT] Loyalty info in receipt is not aligned properly
 * BZ53458          101122    [UAT] Points to Expire Change what is displayed on receipt
 * BZ53772          221122    [UAT] Points Expiring Display String improperly trimming one single space from left and right of string before displaying
 *===================================================================
 */

package caw.pos.common.rcpt;

import java.math.BigDecimal;
import java.util.*;

import javax.inject.Inject;

import caw.pos.cheetah.promotion.CawCheetahPointsWrapper;

import dtv.docbuilding.AbstractDocBuilderField;
import dtv.docbuilding.IDocElementFactory;
import dtv.docbuilding.types.DocBuilderAlignmentType;
import dtv.i18n.*;
import dtv.i18n.formatter.output.IOutputFormatter;
import dtv.pos.common.CommonHelper;
import dtv.pos.framework.scope.TransactionScope;
import dtv.util.Money;
import dtv.util.temp.InjectionHammer;

/**
 *
 */
public class CawCheetahLoyaltyPointsDocBuilderField extends AbstractDocBuilderField {

    @Inject
    protected TransactionScope  _transactionScope;
    
    @Inject
    private CommonHelper        _commonHelper;

    public CawCheetahLoyaltyPointsDocBuilderField(String argContents,
            String argStyle, Integer argLocation,
            DocBuilderAlignmentType argAlignment, int argPriority,
            IOutputFormatter argFormatter) {

        super(argContents, argStyle, argLocation, argAlignment, argPriority, argFormatter);
        InjectionHammer.forceAtInjectProcessing(this);
    }


    /** {@inheritDoc} */
    @SuppressWarnings("finally")
    //BEGIN BZ48629
    @Override
    public String getContents(Object argSource, IDocElementFactory argFactory,
            Locale argLocale) {
        String tmp =null;
        CawCheetahPointsWrapper wrapper = (CawCheetahPointsWrapper) argSource;
        
        if(wrapper!=null && wrapper.getCustomerLoyaltyInformation() != null) {
            HashMap<String,String> hashMap = wrapper.getCustomerLoyaltyInformation();//BZ52876
            for(Map.Entry<String,String> entry : hashMap.entrySet()) {
                if(entry != null && wrapper.getCode().equalsIgnoreCase(entry.getKey())) {
                    
                    if("pointsValue".equalsIgnoreCase(wrapper.getCode())) {
                        // BEGIN BZ49747
                        IFormatter formatter = FormatterFactory.getInstance().getMoneyFormatter();
                        BigDecimal pointsValueBigDecimal = new BigDecimal(entry.getValue());
                        Money money = new Money(pointsValueBigDecimal,_commonHelper.getLocalCurrency());
                        IFormattable value = FormattableFactory.getInstance().getSimpleFormattable(formatter.format(money, OutputContextType.RECEIPT));
                        tmp = String.valueOf(value);
                        tmp = tmp.replaceAll("\\s", ""); //BZ53389
                        //END BZ49747
                        break;
                        //BEGIN BZ53149
                    } else if("pointsToExpire".equalsIgnoreCase(wrapper.getCode())){
                        String pointsExpire = entry.getValue();
                        if (pointsExpire != null && !pointsExpire.isEmpty()) {
                            tmp = pointsExpire;//BZ53772                            
                        } else {
                            tmp = "";
                        }
                        
                        break;
                        
                        //END BZ53149
                    } else {
                        tmp = String.format("%,d",Long.parseLong(entry.getValue()));
                        break;
                    }
                  
                }
               
            }
            
        }
       
        return tmp;
    }
    //END BZ48629
}
