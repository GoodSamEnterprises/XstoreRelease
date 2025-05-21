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
 * BZ25115          180418    New Requirement - Add a Member Price Override Function to the POS Sale screen
 * BZ49889          180522    [Prod] Issue with Member Price Override
 *===================================================================
 */

package caw.pos.register.sale;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import caw.pos.advance.prompting.CawCustomerGroupType;

import dtv.xst.dao.crm.ICustomerAffiliation;
import dtv.xst.dao.crm.IParty;

/**
 *
 */
public class CawMemberPriceOverrideHelper {

    private static final Logger _logger = LogManager.getLogger(CawMemberPriceOverrideHelper.class);

    /**
     * The function checked the customer have a Club pricing Group.
     * @param iParty is customer object
     * @return Return True if the customer is Club pricing.
     */
    public Boolean isOnlyRegularGroup(IParty iParty) {

        Boolean isRegularGroup = Boolean.TRUE;
        try {
            if (iParty != null) {
                List<ICustomerAffiliation> customerGroups = iParty.getCustomerGroups();
                if (customerGroups != null && customerGroups.size() > 0) {
                    for (ICustomerAffiliation iCustomerAffiliation : customerGroups) {
                        if (!CawCustomerGroupType.RETL.getNewName().equalsIgnoreCase(iCustomerAffiliation.getCustomerGroupId())) {
                            isRegularGroup = Boolean.FALSE;
                            break;
                        }
                    }
                }
            }

        } catch (Exception ex) {
            _logger.error("Can not checked group of customer." + ex.getMessage());
        }

        return isRegularGroup;
    }

    /*BEGIN BZ49889*/
    /**
     * The function checked the customer have a Club pricing Group.
     * @param iParty is customer object
     * @return Return True if the customer is Club pricing.
     */
    public Boolean hasClubGroup(IParty iParty) {

        Boolean hasClubGroup = Boolean.FALSE;
        try {
            if (iParty != null) {
                List<ICustomerAffiliation> customerGroups = iParty.getCustomerGroups();
                if (customerGroups != null && customerGroups.size() > 0) {
                    for (ICustomerAffiliation iCustomerAffiliation : customerGroups) {
                        if (CawCustomerGroupType.CLUB.getNewName().equalsIgnoreCase(iCustomerAffiliation.getCustomerGroupId())) {
                            hasClubGroup = Boolean.TRUE;
                            break;
                        }
                    }
                }
            }

        } catch (Exception ex) {
            _logger.error("Can not checked Club group of customer." + ex.getMessage());
        }
        return hasClubGroup;
    }
    /*END BZ49889*/
}
