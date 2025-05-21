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
 * BZ27339          031018    [New Requirement] Display Membership Information on Xstore POS Information tab
 *===================================================================
 */

package caw.pos.customer.membership;

import javax.swing.JList;

import dtv.pos.framework.ui.listview.DefaultViewElement;
import dtv.ui.UIResourceManager;

/**
 * The CawCustomerMembershipViewElement
 */
public class CawCustomerMembershipViewElement extends DefaultViewElement {

    /** {@inheritDoc} */
    @Override
    public void initialize(JList<?> argList, Object argModel, int argIndex,
            boolean argIsSelected, boolean argHasFocus) {

        super.initialize(argList, argModel, argIndex, argIsSelected, argHasFocus);

        if (argModel instanceof CawCustomerMembershipView) {

            cell_.setDisabledForeground(UIResourceManager.getInstance()
                    .getRGBColor("_labelFontColorBlack"));

        }
    }

}
