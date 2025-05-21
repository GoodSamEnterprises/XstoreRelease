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
 * BZ29361          150219    [Requirement] PLCC Acquisition - Changes to Temporary Shopping Pass
 * BZ29454          220219    [Internal] Temporary Shopping Pass is missing Temporary Limit amount.
 *===================================================================
 */

package caw.pos.common.rcpt;

import org.apache.commons.lang3.StringUtils;

import caw.pos.common.CawConstants;
import caw.tenderauth.impl.eigen.CawGoodSamVisaShoppingPassReferenceData;

import dtv.docbuilding.conditions.AbstractInvertableCondition;

/**
 *
 */
public class CawShoppingPassAPRCondition extends AbstractInvertableCondition {

    @Override
    protected boolean conditionMetImpl(Object argSource) {

        Boolean isAPR = Boolean.TRUE;
        if (argSource instanceof CawGoodSamVisaShoppingPassReferenceData) {
            CawGoodSamVisaShoppingPassReferenceData shoppingPassReferenceData = (CawGoodSamVisaShoppingPassReferenceData) argSource;
            if (shoppingPassReferenceData.getCardType() == 2) {
                if (CawConstants.VALUE_0_PERCENT.equalsIgnoreCase(shoppingPassReferenceData.getApr())) {//BZ29454 
                    isAPR = Boolean.FALSE;
                }
            }
        }

        return isAPR;
    }

}
