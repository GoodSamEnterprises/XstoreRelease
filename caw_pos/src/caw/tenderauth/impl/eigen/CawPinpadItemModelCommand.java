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
 * BZ27344          301018    Pin Pad Performance is slow when item price is updated by a deal/promo or a manual price adjustment
 *===================================================================
 */

package caw.tenderauth.impl.eigen;

/**
 *
 */
public enum CawPinpadItemModelCommand {
    UPDATE_PINPAD_CURRENT_MODEL,

    ADD_PINPAD_CURRENT_MODEL,
    
    ADD_PINPAD_INCLUDE_FOOTER,

    REMOVE_PINPAD_CURRENT_MODEL,

    CLEAR_PINPAD_CURRENT_MODEL,
}
