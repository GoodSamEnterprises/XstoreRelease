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
 * BZ29125          280119    Port 29014 to Release 3.0 - Work Order quantity does not import to Xstore if only 0500 item exists on the order
 *===================================================================
 */

package caw.pos.workorder.validation;

import dtv.pos.iframework.validation.IValidationResult;
import dtv.pos.util.validation.AbstractValidationRule;

/**
 * Validate to process Deposit Work Order 
 */
public class CawValidateTotalNumberPartTaskRule extends AbstractValidationRule {

    /* Since all task and part items are retrieved from EBS,
     * so no need to validate the number of task items.
     * @see dtv.pos.iframework.validation.IValidationRule#validate()
     */
    @Override
    public IValidationResult validate() {

        return IValidationResult.SUCCESS;
    }
}
