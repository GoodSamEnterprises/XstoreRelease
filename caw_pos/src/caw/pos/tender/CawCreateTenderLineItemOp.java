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
 * BZ30314          220419    [Port BZ30262 to Release 4.2.0] OS transaction failed due to token is missing when tender exchange GiftCard with Credit Card 
 *===================================================================
 */

package caw.pos.tender;

import javax.inject.Inject;

import caw.tenderauth.impl.eigen.CawEigenMgr;

import dtv.pos.iframework.event.IXstEvent;
import dtv.pos.iframework.op.IOpResponse;
import dtv.pos.spring.ValueKeys;
import dtv.pos.tender.CreateTenderLineItemOp;
import dtv.xst.dao.ttr.ITenderLineItem;

/**
 *
 */
public class CawCreateTenderLineItemOp extends CreateTenderLineItemOp {
    @Inject
    private CawEigenMgr _cawEigenMgr;

    /* (non-Javadoc)
     * @see dtv.pos.tender.CreateTenderLineItemOp#handleOpExec(dtv.pos.iframework.event.IXstEvent)
     */
    @Override
    public IOpResponse handleOpExec(IXstEvent argEvent) {

        IOpResponse response = super.handleOpExec(argEvent);
        ITenderLineItem tenderLine = getScopedValue(ValueKeys.CURRENT_TENDER_LINE);
        _cawEigenMgr.setTenderLineExchange(tenderLine);
        return response;
    }

    /* (non-Javadoc)
     * @see dtv.pos.tender.CreateTenderLineItemOp#setParameter(java.lang.String, java.lang.String)
     */
    @Override
    public void setParameter(String argArg0, String argArg1) {
        // @todo Auto-generated method stub
        super.setParameter(argArg0, argArg1);
    }

}
