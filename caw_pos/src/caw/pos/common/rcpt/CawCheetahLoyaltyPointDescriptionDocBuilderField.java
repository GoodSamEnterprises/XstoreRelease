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
 * BZ52876          071122    [UAT] Loyalty info is not getting printed in POS receipt
 *===================================================================
 */

package caw.pos.common.rcpt;

import java.util.*;

import javax.inject.Inject;

import caw.pos.cheetah.promotion.CawCheetahPointsWrapper;

import dtv.docbuilding.AbstractDocBuilderField;
import dtv.docbuilding.IDocElementFactory;
import dtv.docbuilding.types.DocBuilderAlignmentType;
import dtv.i18n.formatter.output.IOutputFormatter;
import dtv.pos.framework.scope.TransactionScope;
import dtv.util.temp.InjectionHammer;

/**
 *
 */
public class CawCheetahLoyaltyPointDescriptionDocBuilderField
        extends AbstractDocBuilderField {

    @Inject
    protected TransactionScope  _transactionScope;
    
    
    /**
    * Constructor.
    *
    * @param argContents the contents
    * @param argStyle the style
    * @param argLocation the location
    * @param argAlignment the alignment
    * @param argPriority the priority
    * @param argFormatter the formatter
    */
    public CawCheetahLoyaltyPointDescriptionDocBuilderField(String argContents,
            String argStyle, Integer argLocation,
            DocBuilderAlignmentType argAlignment, int argPriority,
            IOutputFormatter argFormatter) {

        super(argContents, argStyle, argLocation, argAlignment, argPriority, argFormatter);
        InjectionHammer.forceAtInjectProcessing(this);
    }


    /** {@inheritDoc} */
    //BEGIN BZ48629
    @Override
    public String getContents(Object argSource, IDocElementFactory argFactory,
            Locale argLocale) {
        
        String tmp=null;
        CawCheetahPointsWrapper wrapper = (CawCheetahPointsWrapper) argSource;
        
        if(wrapper!=null && wrapper.getCustomerLoyaltyInformation() != null) {
            HashMap<String,String> hashMap = wrapper.getCustomerLoyaltyInformation(); //BZ52876
            for(Map.Entry<String,String> entry : hashMap.entrySet()) {
                if(wrapper.getCode().equalsIgnoreCase(entry.getKey())) {
                    tmp= wrapper.getDescription()+":";
                    break;
                }
            }
        }
       
        return tmp;
    }
    //END BZ48629
 
}
