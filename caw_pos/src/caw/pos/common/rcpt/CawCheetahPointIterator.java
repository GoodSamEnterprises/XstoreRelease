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
 * BZ48629          280422    [Task] Print Points Balances - Sale transaction
 * BZ52876          071122    [UAT] Loyalty info is not getting printed in POS receipt
 * BZ55978          290323    Loyalty Issue: Java Null Pointer
 *===================================================================
 */

package caw.pos.common.rcpt;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.*;
import java.util.stream.Collectors;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import caw.pos.cheetah.promotion.CawCheetahPointsWrapper;
import caw.pos.cheetah.util.CawCheetahHelper;
import caw.pos.common.CawConstants;

import dtv.docbuilding.*;
import dtv.pos.common.ConfigurationMgr;
import dtv.util.temp.InjectionHammer;
import dtv.xst.dao.com.CodeLocator;
import dtv.xst.dao.com.ICodeValue;
import dtv.xst.dao.trl.IRetailTransaction;
import dtv.xst.dao.trl.impl.RetailTransactionModel;
import dtv.xst.dao.trn.IPosTransactionProperty;
/**
 *
 */
public class CawCheetahPointIterator extends DocBuilderIterator {
    
    private static final Logger _logger          = LogManager.getLogger(CawCheetahPointIterator.class);
    
    @SuppressWarnings("deprecation")
    public CawCheetahPointIterator() {
        super();
        InjectionHammer.forceAtInjectProcessing(this);
    }

    private CawCheetahHelper    _cheetahHelper   = CawCheetahHelper.getInstance();
    
    //BEGIN BZ48629
    @Override
    protected void iterate(IPosDocument argArg0, IDocElementFactory argArg1,Object transactionModel) throws IOException {
        HashMap<String, String> hashMap = null;
        /* BEGIN BZ52876 */
        if (transactionModel instanceof IRetailTransaction) {
            RetailTransactionModel retailTransactionModel = (RetailTransactionModel) transactionModel;
            String loyaltyInfo = retailTransactionModel.getStringProperty(CawConstants.CAW_LOYALTY_POINTS_INFORMATION);
            if (loyaltyInfo != null) {
                hashMap = _cheetahHelper.getCheetahRctpPoint(loyaltyInfo);
                /* BEGIN BZ55978 */
                IPosTransactionProperty temp =  retailTransactionModel.getProperty(CawConstants.CAW_LOYALTY_POINTS_INFORMATION);
                retailTransactionModel.removePosTransactionProperty(temp);
                /* END BZ55978 */
            }
        }
        /* END BZ52876 */
        
        IRetailTransaction iRetail = (IRetailTransaction) transactionModel;
        List<CawCheetahPointsWrapper> listSort = new ArrayList<>();
        List<CawCheetahPointsWrapper> loyaltyPointwarpper= new ArrayList<CawCheetahPointsWrapper>();
        List<String> loyaltyPointsCategory = CodeLocator.getCodes(ConfigurationMgr.getOrganizationId(), CawConstants.CAW_LOYALTY_POINTS);
         if (!loyaltyPointsCategory.isEmpty() && hashMap!=null) {
             _logger.debug("Receipt received customer loyalty information.");
             for (String loyaltyCode : loyaltyPointsCategory) {
                 ICodeValue iCode = CodeLocator.getCodeValue(ConfigurationMgr.getOrganizationId(), CawConstants.CAW_LOYALTY_POINTS, loyaltyCode);
                 for (Map.Entry<String, String> entry : hashMap.entrySet()) {
                    if (loyaltyCode.equalsIgnoreCase(entry.getKey())) {
                          CawCheetahPointsWrapper wrapper = new CawCheetahPointsWrapper();
                          wrapper.setCode(loyaltyCode);
                          wrapper.setDescription(iCode.getDescription());
                          wrapper.setSortOrder(iCode.getSortOrder());
                          wrapper.setCustomerLoyaltyInformation(hashMap); //BZ52876
                         if ("pointsRedeemedOrDeductedToday".equalsIgnoreCase(loyaltyCode) && iRetail.getTotal().compareTo(BigDecimal.ZERO) == -1) {//BZ48629
                               loyaltyCode = "pointsDeductedToday";
                               iCode = CodeLocator.getCodeValue(ConfigurationMgr.getOrganizationId(), CawConstants.CAW_LOYALTY_POINTS, loyaltyCode);
                               wrapper.setDescription(iCode.getDescription());
                             }
                          loyaltyPointwarpper.add(wrapper);
                          break;
                         }
                     }
                  }
             if (!loyaltyPointwarpper.isEmpty()) {
                 listSort = loyaltyPointwarpper.stream().sorted(Comparator
                         .comparingInt(CawCheetahPointsWrapper::getSortOrder))
                         .collect(Collectors.toList());
             }
        } 

        super.iterateList(argArg0, argArg1, listSort);
    }
    //END BZ48629
}
