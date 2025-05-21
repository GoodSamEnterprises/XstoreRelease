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
 * INT-92               260817    Customer Integration
 *== ================================================================
 */

package caw.pos.util;

/**
 *
 */
public class CawRestClientException extends Exception {

    /**
     * 
     */
    private static final long serialVersionUID = 8958729913435145718L;

    /**
     * @param message
     */
    public CawRestClientException(String message) {

        super(message);
    }
}
