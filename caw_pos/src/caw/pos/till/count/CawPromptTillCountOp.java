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
 * BZ24135          201017    [Store Operations] Remove additional/non-countable tenders from Count Summary Screen for Register Close
 *===================================================================
 */

package caw.pos.till.count;

import java.util.List;

import javax.inject.Inject;

import dtv.pos.tender.TenderAvailabilityCodeType;
import dtv.pos.tender.TenderHelper;
import dtv.pos.till.count.PromptTillCountOp;
import dtv.pos.till.count.TillCountModel;
import dtv.xst.dao.tnd.ITender;
import dtv.xst.dao.tsn.ISession;

/**
 * This operation handles prompting till count screens. 
 */
public class CawPromptTillCountOp extends PromptTillCountOp {

    @Inject
    private TenderHelper _tenderHelper;

    /**
     * Create and return the till count model for this till count.
     *
     * @return the till count model for this till count.
     */
    @Override
    protected TillCountModel createTillCountModel() {

        ISession currentSession = getSessionToCount();

        List<ITender> tenders = getTendersToCount();
        TillCountModel model = new TillCountModel(null, currentSession, tenders,
                null, false, false, getTenderCountTransactionType(), null);

        return model;
    }

    @Override
    protected List<ITender> getTendersToCount() {

        return _tenderHelper
                .getTendersByAvailabilityCode(TenderAvailabilityCodeType.DEPOSIT);
    }

}
