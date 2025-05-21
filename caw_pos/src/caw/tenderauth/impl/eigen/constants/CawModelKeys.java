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
 * PAYMENT          070917    Payment-Item Display
 *===================================================================
 */

package caw.tenderauth.impl.eigen.constants;

import caw.tenderauth.impl.eigen.model.CawTransactionListEditModel;

import dtv.pos.iframework.type.ModelKey;

/**
 *
 */
public class CawModelKeys {

    public static final ModelKey<CawTransactionListEditModel> CAW_CURRENT_TRANSACTION = new ModelKey<>(
            "CAW_CURRENT_TRANSACTION");
}
