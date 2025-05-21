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
 * BZ51471          191022    [NEW] Change the loyalty offers flow and prompts
 *===================================================================
 */

package caw.pos.cheetah;

import javax.inject.Inject;

import caw.pos.common.CawValueKeys;

import dtv.pos.framework.op.AbstractRunCondition;
import dtv.pos.framework.scope.TransactionScope;

/**
 *
 */
public class CawRemovePromotionsRewardCondition extends AbstractRunCondition{

    @Inject
    private TransactionScope _transactionScope;

    @Override
    protected boolean shouldRunImpl() {
        
        return (_transactionScope.getValue(CawValueKeys.IS_APPLY_PROMOS_REWARD) != null && 
                _transactionScope.getValue(CawValueKeys.IS_APPLY_PROMOS_REWARD )); //BZ51471
    }

}
