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
 * BZ69392          100225    [AGIS Modification] - Update the Receipt (Section 2.2)
 *===================================================================
 */

package caw.pos.docbuilding.conditions;

import java.util.Iterator;
import java.util.List;

import javax.inject.Inject;

import caw.pos.agis.model.CawAGISPitchesItemModel;
import caw.pos.common.CawValueKeys;

import dtv.docbuilding.conditions.AbstractInvertableCondition;
import dtv.pos.framework.scope.TransactionScope;

/**
 *
 */
public class CawTemporaryCardCondition extends AbstractInvertableCondition {
    @Inject
    protected TransactionScope _transactionScope;
    private String status_ = null;

    @Override
    public void setParameter(String argName, Object argValue) {
        if (!"status".equalsIgnoreCase(argName) && !"value".equalsIgnoreCase(argName)) {
            super.setParameter(argName, argValue);
        } else {
            this.status_ = argValue.toString();
        }

    }

    @Override
    protected boolean conditionMetImpl(Object argSource) {  
        
        List<CawAGISPitchesItemModel> acceptedList = _transactionScope.getValue(CawValueKeys.CAW_AGIS_LIST_ACCEPTED);
        if (acceptedList != null) {
            Iterator<CawAGISPitchesItemModel> iterator = acceptedList.iterator();
            while (iterator.hasNext()) {
                if (this.status_.equalsIgnoreCase(iterator.next().getOfferReference())) {
                    return true;
                }
            }
        }
        
        return false;
    }
}
