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
 * Req/Bug ID#          ddMMyy    Description
 * BZ23164              100917    [DEV] Implement EMV Payment Integration
 * BZ24019              161017    [Technical issue] - Empty method
 *== ================================================================
 */

package caw.tender.impl.mira;

import javax.inject.Inject;

import caw.tenderauth.impl.mira.constants.CawMiraInteractionConstants.SendRequestType;

import dtv.data2.access.IDataModel;
import dtv.pos.framework.scope.TransactionScope;
import dtv.pos.iframework.type.TenderUsageCodeType;
import dtv.pos.tender.TenderHelper;
import dtv.tenderauth.*;
import dtv.tenderauth.event.IAuthResponse;
import dtv.xst.dao.tnd.TenderCategory;
import dtv.xst.dao.tnd.TenderStatus;
import dtv.xst.dao.trl.IAuthorizableLineItem;
import dtv.xst.dao.trl.ISaleReturnLineItem;
import dtv.xst.dao.ttr.IAuthorizableTenderLineItem;
import dtv.xst.dao.ttr.ITenderLineItem;

public class CawMiraManager {

    private ITenderLineItem             _tenderLine;

    private String                      _tndrId          = System.getProperty("caw.mira.tenderId.name", "VERIFONE");

    @Inject
    private TenderHelper                _tenderHelper;

    public static final AuthRequestType LAST_TRANSACTION = AuthRequestType.get("LAST_TRANSACTION");

    /**
     * Build authorization processor
     * @return
     */
    public IAuthProcess buildAuthProcessor() {

        return AuthFactory.getInstance().getAuthProcess(_tndrId);
    }

    /**
     * Build authorization processor
     * @return
     */
    public IAuthProcess buildAuthProcessor(String argAuthMethodCode) {

        return AuthFactory.getInstance().getAuthProcess(argAuthMethodCode);
    }

    /**
     * Build a general VERIFONE request
     * @return
     */
    public IAuthRequest buildAuthRequest() {

        // create dummy tender line
        if (_tenderLine == null) {
            _tenderLine = _tenderHelper.createTenderLineItem(_tenderHelper
                    .getLocalCurrency(), TenderCategory.CREDIT_CARD, TenderStatus.TENDER, null);
            ((IAuthorizableTenderLineItem) _tenderLine).setAuthorizationMethodCode(_tndrId);
        }
        // create request
        IAuthRequest currentRequest = AuthFactory.getInstance()
                .makeAuthRequest(AuthRequestType.CREDIT_APP, (IAuthorizableTenderLineItem) _tenderLine, TenderUsageCodeType.DEFAULT, true);
        return currentRequest;
    }

    /**
     * Build a general VERIFONE request
     * @return
     */
    public IAuthRequest buildAuthRequest(AuthRequestType authRequestType, IAuthorizableLineItem tenderLine) {

        // create dummy tender line
        if (tenderLine == null) {
            tenderLine = (IAuthorizableTenderLineItem) _tenderHelper.createTenderLineItem(_tenderHelper
                    .getLocalCurrency(), TenderCategory.CREDIT_CARD, TenderStatus.TENDER, null);
            tenderLine.setAuthorizationMethodCode(_tndrId);
        }
        // create request
        IAuthRequest currentRequest = AuthFactory.getInstance()
                .makeAuthRequest(authRequestType, tenderLine, TenderUsageCodeType.DEFAULT, true);
        return currentRequest;
    }

    /**
     * Build a general VERIFONE request
     * @return
    */
    public IAuthRequest buildLastTransAuthRequest() {

        // create dummy tender line
        if (_tenderLine == null) {
            _tenderLine = _tenderHelper.createTenderLineItem(_tenderHelper
                    .getLocalCurrency(), TenderCategory.CREDIT_CARD, TenderStatus.TENDER, null);
            ((IAuthorizableTenderLineItem) _tenderLine).setAuthorizationMethodCode(_tndrId);
        }
        // create last trans request
        IAuthRequest currentRequest = AuthFactory.getInstance()
                .makeAuthRequest(LAST_TRANSACTION, (IAuthorizableTenderLineItem) _tenderLine, TenderUsageCodeType.DEFAULT, true);
        return currentRequest;
    }

    /**
     * Add an item into VERIFONE
     * 
     * @param newLineItem
     */
    public void addItem(ISaleReturnLineItem newLineItem, TransactionScope transactionScope) {

        //check condition that item isn't extended
        IDataModel itemExt = newLineItem.getItem().getItemExt();
        if (itemExt != null || newLineItem.getVoid()) {
            return;
        }
        IAuthRequest request = buildAuthRequest();
        buildAuthProcessor().processRequest(request);
    }

    /**
     * Start a session for new transaction
     * 
     */
    public void startSession(TransactionScope transactionScope) {

        //start new session
        IAuthRequest request = buildAuthRequest();
        buildAuthProcessor().processRequest(request);
    }

    /**
     * Close a session
     * @param transactionScope
     */
    public void closeSession() {

        IAuthRequest request = buildAuthRequest();
        buildAuthProcessor().processRequest(request);
    }

    /**
    * unregister for the first time that communicate with verifone device
    * @return IAuthResponse
    */
    public IAuthResponse unRegister(int generatedNumber) {

        IAuthRequest request = buildAuthRequest();
        buildAuthProcessor().processRequest(request);
        return request.getResponses()[0];
    }

    /**
     * register for the first time that communicate with verifone device
     * @return IAuthResponse
     */
    public IAuthResponse register(int generatedNumber) {

        IAuthRequest request = buildAuthRequest();
        buildAuthProcessor().processRequest(request);
        return request.getResponses()[0];
    }

    /**
     * @param argGeneratedNumber
     * @param argMultiThread
     * @param argB
     */
    public void register(int generatedNumber, boolean isThrowEvent) {

        IAuthRequest request = buildAuthRequest();
        buildAuthProcessor().processRequest(request);
    }

    /**
     * Override item request for VeriFone device
     * 
     * @param newLineItem, transactionScope
     */
    public void overrideItem(ISaleReturnLineItem newLineItem, TransactionScope transactionScope) {

        //check condition that item isn't extended or voided
        if (newLineItem == null || newLineItem.getVoid()) {
            return;
        }

        IDataModel itemExt = newLineItem.getItem().getItemExt();
        if (itemExt != null || newLineItem.getVoid()) {
            return;
        }

        IAuthRequest request = buildAuthRequest();
        buildAuthProcessor().processRequest(request);
    }

    /**
     * Clean item request for VeriFone device
     * 
     * @param newLineItem, transactionScope
     */
    public void cleanItem(ISaleReturnLineItem newLineItem, TransactionScope transactionScope) {

        IAuthRequest request = buildAuthRequest();
        buildAuthProcessor().processRequest(request);
    }

    /**
     * Refund request for VeriFone device
     * 
     * @param 
     */
    public void refund() {

        IAuthRequest request = buildAuthRequest();
        buildAuthProcessor().processRequest(request);
    }

    /**
     * Capture request for VeriFone device
     * 
     * @param 
     */
    public IAuthResponse capture() {

        IAuthRequest request = buildAuthRequest();
        buildAuthProcessor().processRequest(request);
        return request.getResponses()[0];
    }

    /**
     * get Signature request for VeriFone device
     * 
     * @param 
     */
    public void getSignature() {

        IAuthRequest request = buildAuthRequest();
        buildAuthProcessor().processRequest(request);
    }

    /**
     * get Last TRAN request for VeriFone device
     * 
     * @param 
     */
    public IAuthResponse getLastTrans() {

        IAuthRequest request = buildAuthRequest();
        buildAuthProcessor().processRequest(request);
        return request.getResponses()[0];
    }

    /**
     * test Mac request for VeriFone device
     * 
     * @param 
     */
    public IAuthResponse testMac() {

        IAuthRequest request = buildAuthRequest();
        buildAuthProcessor().processRequest(request);
        return request.getResponses()[0];
    }

    /**
     * @param argB
     * @return
     */
    public IAuthResponse testMac(boolean isThrowEvent) {

        IAuthRequest request = buildAuthRequest();
        buildAuthProcessor().processRequest(request);
        return request.getResponses()[0];
    }

    /**
     * Reversal request for VeriFone device
     * 
     * @param 
     */
    public void reverse() {

        IAuthRequest request = buildAuthRequest();
        buildAuthProcessor().processRequest(request);
    }

    /**
     * Send email message to MIRA and capture email information of customer
     * @return
     */
    public IAuthResponse captureEmail() {

        IAuthRequest request = buildAuthRequest();
        buildAuthProcessor().processRequest(request);
        return request.getResponses()[0];
    }

    /**
     * Send email message to MIRA and capture email information of customer
     * @return
     */
    public void captureEmail(SendRequestType sendType, String customerEmail, boolean isThrowEvent) {

        IAuthRequest request = buildAuthRequest();
        buildAuthProcessor().processRequest(request);
    }

    /**
     * @param argB
     */
    public void closeSession(SendRequestType sendType) {

        IAuthRequest request = buildAuthRequest();
        buildAuthProcessor().processRequest(request);
    }

    /**
     * @param argTransactionScope
     * @param argMultiThread
     */
    public void startSession(TransactionScope transactionScope, SendRequestType sendType) {

        IAuthRequest request = buildAuthRequest();
        buildAuthProcessor().processRequest(request);
    }

    /**
     * @param argTransactionScope
     * @param argMultiThread
     */
    public void startSession(TransactionScope transactionScope, SendRequestType sendType, String argAuthMethodCode) {

        IAuthRequest request = buildAuthRequest();
        buildAuthProcessor(argAuthMethodCode).processRequest(request);
    }

    /**
     * @param argTransactionScope
     * @param argMultiThread
     */
    public void startSessionDummyInvoice(TransactionScope transactionScope, String argAuthMethodCode) {

        IAuthRequest request = buildAuthRequest();
        buildAuthProcessor(argAuthMethodCode).processRequest(request);
    }

    /**
     * To send a SHOW message to display the line item screen
     * @param argB
     */
    public void showLineItemScreen(SendRequestType sendType) {

        IAuthRequest request = buildAuthRequest();
        buildAuthProcessor().processRequest(request);
    }
}
