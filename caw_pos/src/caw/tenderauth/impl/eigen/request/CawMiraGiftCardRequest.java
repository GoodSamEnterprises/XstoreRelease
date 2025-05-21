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
 * BZ24019          161017    [Technical issue] - Empty method
 *===================================================================
 */

package caw.tenderauth.impl.eigen.request;

import org.apache.log4j.Logger;

import MiraServJava.MiraServJava;
import caw.tender.impl.mira.request.CawMiraRequest;
import caw.tender.impl.mira.response.CawMiraResponse;

import dtv.hardware.events.IAccountInputEvent;
import dtv.pos.iframework.type.TenderUsageCodeType;
import dtv.tenderauth.AuthRequestType;
import dtv.tenderauth.storedvalue.IStoredValueAuthRequest;
import dtv.util.crypto.EncString;
import dtv.xst.dao.trl.IAuthorizableLineItem;

public class CawMiraGiftCardRequest
        extends CawMiraRequest implements IStoredValueAuthRequest {

    private String              accountId_;

    private static final Logger logger_ = Logger
            .getLogger(CawMiraGiftCardRequest.class);

    public CawMiraGiftCardRequest(AuthRequestType argType,
            IAuthorizableLineItem argLine) {

        this(argType, argLine, null);
    }

    public CawMiraGiftCardRequest(AuthRequestType argType,
            IAuthorizableLineItem argLine,
            TenderUsageCodeType argTenderUsageCode) {

        super(argType, argLine, argTenderUsageCode);
    }

    @Override
    public CawMiraResponse getResponse(MiraServJava argResponse) {

        return new CawMiraResponse(getAuthProcess(), this,
                getAuthProcess().getAuthMethodCode(), argResponse);
    }

    /** {@inheritDoc} */
    @Override
    public EncString getAccountId() {

        return EncString.valueOf(accountId_);
    }

    /** {@inheritDoc} */
    @Override
    public String getCurrencyId() {

        return null;
    }

    /** {@inheritDoc} */
    @Override
    public boolean getIgnoreFailure() {

        return false;
    }

    /** {@inheritDoc} */
    @Override
    public IAccountInputEvent<?> getInputEvent() {

        return null;
    }

    /** {@inheritDoc} */
    @Override
    public EncString getPIN() {

        return null;
    }

    /** {@inheritDoc} */
    @Override
    public String getPreviousTransaction() {

        return null;
    }

    /** {@inheritDoc} */
    @Override
    public long getTransactionSequence() {

        return 0;
    }

    /** {@inheritDoc} */
    @Override
    public void setAccountId(EncString argParamString) {

        accountId_ = EncString.getSensitiveData(argParamString);
    }

    /** {@inheritDoc} */
    @Override
    public void setCurrencyId(String argParamString) {

        logger_.info("Do nothing");
    }

    /** {@inheritDoc} */
    @Override
    public void setIgnoreFailure(boolean argParamBoolean) {

        logger_.info("Do nothing");
    }

    /** {@inheritDoc} */
    @Override
    public void setInputEvent(
            IAccountInputEvent<?> argParamIAccountInputEvent) {

        logger_.info("Do nothing");
    }

    /** {@inheritDoc} */
    @Override
    public void setPIN(EncString argParamString) {

        logger_.info("Do nothing");
    }

    /** {@inheritDoc} */
    @Override
    public void setPreviousTransaction(String argParamString) {

        logger_.info("Do nothing");
    }

    /** {@inheritDoc} */
    @Override
    public void setTransactionSequence(long argParamLong) {

        logger_.info("Do nothing");
    }

    /* (non-Javadoc)
     * @see caw.tender.impl.mira.request.CawMiraRequest#getTenderDescription()
     */
    @Override
    public String getTenderDescription() {

        return "";
    }
}
