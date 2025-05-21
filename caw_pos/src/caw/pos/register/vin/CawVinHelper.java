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

package caw.pos.register.vin;

import java.util.List;

import caw.pos.common.CawConstants;

import dtv.xst.dao.itm.*;

/**
 *
 */
public class CawVinHelper {
    
    public static boolean isVinItem(IItem item) {
        boolean result = false;
        
        List<IItemPromptProperty> promptPros = item.getItemPromptProperties();
        
        for (IItemPromptProperty promptProperty : promptPros) {
            if (promptProperty.getCodeGroup() != null && promptProperty.getCodeGroup().equals(CawConstants.CAW_VIN_VERIFICATION_CHAIN_NAME)) {
                result = true;
                break;
            }
        }
        
        return result;
    }
    
}
