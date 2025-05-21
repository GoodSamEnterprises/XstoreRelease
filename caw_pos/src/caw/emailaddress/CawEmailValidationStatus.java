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
 * BZ45995          141021    [New requirement] Email capture when good sam membership is sold
 *===================================================================
 */

package caw.emailaddress;


/**
 *
 */
public enum CawEmailValidationStatus {
    SUCCESS,
    INVALID,
    ERROR,
    UNAVAILABLE;
}
