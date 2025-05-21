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
 * BZ30378          120619    [New Requirement] Refine QAS result and break out the street number ranges in Xstore
 *===================================================================
 */

package caw.pos.address.search;

import dtv.pos.address.search.AddressSearchResultStatus;

/**
 *
 */
public class CawAddressSearchResultStatus extends AddressSearchResultStatus {
    
    /* Begin BZ30378*/
    public static final AddressSearchResultStatus CAW_QAS_TOO_MANY_RESULTS = new AddressSearchResultStatus("_addressManyResultsStatus", "_addressManyResultsMessage");

    public CawAddressSearchResultStatus(String argStatus, String argMessage) {

        super(argStatus, argMessage);
    }
    /* End BZ30378*/

}
