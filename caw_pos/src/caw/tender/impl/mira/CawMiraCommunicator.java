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
 * BZ23232              260917    Define Xstore Timeout
 * BZ23359              270917    Gift cards can't be swiped at screen
 * BZ27530              101118    [Prod] Customer "Double Charged" Issue
 *===================================================================
 */

package caw.tender.impl.mira;

import java.io.Serializable;
import java.net.Socket;
import java.util.Date;

import org.apache.log4j.Logger;
import org.w3c.dom.Document;

import MiraServJava.MiraServJavaException;
import caw.tender.impl.mira.request.CawMiraRequest;

import dtv.tenderauth.ReceiveTimeoutException;
import dtv.tenderauth.event.IAuthResponse;
import dtv.tenderauth.impl.AbstractCommunicator;
import dtv.util.DateUtils;

/**
 *
 */
public class CawMiraCommunicator extends AbstractCommunicator {

    /**
     * Socket connector that is used to send message to VeriFone Point
     */
    Socket                      localSocket = null;

    private static final String AUTHORIZING = "AUTHORIZING";

    private static final Logger logger      = Logger.getLogger(CawMiraCommunicator.class);

    /** Constructs a <code>CawMiraCommunicator</code>.
     * 
     */

    public CawMiraCommunicator() {

        super();
    }

    /** {@inheritDoc} */
    @Override
    protected IAuthResponse sendRequestImpl() throws ReceiveTimeoutException {

        // Begin BZ27530
        /**
         * This method always run when we sent the request to MiraServ.
         * We set CawMiraFormatter.REVERSE_FLAG = false to make sure Reverse() only sent when has MiraServ return exception.
        */
        CawMiraFormatter.REVERSE_FLAG = false;
        // End BZ27530

        CawMiraRequest miraRequest = (CawMiraRequest) getRequest();
        getRequestConverter().convertRequest(miraRequest);
        Date startTime = DateUtils.getNewDate();
        calculateProgressPercents();
        setStatus(miraRequest, miraRequest
                .getMessage(AUTHORIZING), getProgressConnectMillis(), 0, getProgressConnectPercent());
        //make sure auth process not null
        miraRequest.setAuthProcess(getAuthProcess());
        try {
            CawMiraFormatter.miraRequest.Process();
        } catch (MiraServJavaException ex) {
            // Begin BZ27530
            logger.error("The error occurred when the process with MiraServe." + ex.getMessage());
            /**
             * If the MiraServ throw a Exception, We need to send the Reverse request to the MiraServ.
             * Due we mark flag CawMiraFormatter.REVERSE_FLAG = true.
             */
            CawMiraFormatter.REVERSE_FLAG = true;
            // End BZ27530
            // Fix BZ 23232: if can not connect to MiraServ, return offline screen
            return null;
        }
        IAuthResponse response = getResponseConverter().convertResponse(null, miraRequest);
        response.setStartTimestamp(startTime);
        response.setEndTimestamp(DateUtils.getNewDate());

        return response;
    }

    /**
     * Sends an Document over socket to the address and port and returns the
     * response as a Document
     * 
     * @param localDeviceInfo
     *            - device information
     * @param request
     *            - the request was formatted
     * @return Serializable - response from Point
     * @throws TimeoutException
     *             - timeout exception
     * @throws Exception
     *             - unknown exception
     */
    public Serializable send(Document request) throws Exception {

        return null;
    }

}
