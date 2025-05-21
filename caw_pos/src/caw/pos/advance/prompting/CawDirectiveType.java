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
 * BZ23052          140917    Implement Advanced Prompting
 * BZ23436          190917    Advanced Prompting with Directive - No Check
 *===================================================================
 */

package caw.pos.advance.prompting;

import caw.pos.common.CawValueKeys;

import dtv.pos.framework.scope.ValueKey;

/**
 *
 */
public enum CawDirectiveType {
    // Begin BZ23436
    CASH_ONLY(0, "Cash Only", CawValueKeys.CASH_ONLY), CREDIT_CARD_ONLY(1, "Credit Card Only", CawValueKeys.CREDIT_CARD_ONLY), NO_CHECK(2, "No Check", CawValueKeys.NO_CHECK), ADD_ITEM(3, "Add Item", CawValueKeys.ADD_ITEM), VOID_ITEM(4, "Void Item", CawValueKeys.VOID_ITEM), VOID_TRANSACTION(5, "Void Transaction", CawValueKeys.VOID_TRANSACTION), MAKE_CREDIT_OFFE(7, "Make Credit Offe", CawValueKeys.MAKE_CREDIT_OFFER), SUSPEND_PROMPTING(8, "Suspend Prompting", CawValueKeys.SUSPEND_PROMPTING), STORE_VALUE(9, "Store Value", CawValueKeys.STORE_VALUE), CREDIT_CARD_REQUIRED(10, "Credit Card Required", CawValueKeys.MAKE_CREDIT_OFFER);
    // End BZ23436

    private final int              type;

    private final String           description;

    private final ValueKey<String> cawValueKeys;

    private CawDirectiveType(int directiveType, String directiveDescription,
            ValueKey<String> argCawValueKeys) {

        this.type = directiveType;
        this.description = directiveDescription;
        this.cawValueKeys = argCawValueKeys;
    }

    public int getType() {

        return type;
    }

    public String getDescription() {

        return description;
    }

    public ValueKey<String> getCawValueKeys() {

        return cawValueKeys;
    }

}
