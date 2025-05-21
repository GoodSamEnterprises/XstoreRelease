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
 * BZ28036          100220    [New Requirement] Enable the base Functionality available for Customer Purchase History
 *===================================================================
 */

package caw.pos.customer.model;

import org.apache.commons.lang3.StringUtils;

import dtv.pos.customer.model.HistoryGroup;
import dtv.xst.query.results.CustomerTransHistoryResult;

/**
 *
 */
public class CawHistoryGroup extends HistoryGroup {

    private static final long serialVersionUID = 1L;

    private final Header      historyHeader_;

    public CawHistoryGroup(CustomerTransHistoryResult argHeader,
            String argGroupHeaderRenderer) {

        super(argHeader, argGroupHeaderRenderer);
        this.historyHeader_ = new Header(argHeader, argGroupHeaderRenderer);
        this.setHeader(this.historyHeader_);
        // @todo Auto-generated constructor stub
    }

    /* (non-Javadoc)
     * @see dtv.pos.customer.model.HistoryGroup#addHistoryItem(dtv.xst.query.results.CustomerTransHistoryResult, java.lang.String)
     */
    @Override
    public void addHistoryItem(CustomerTransHistoryResult argItemData,
            String argGroupItemRenderer) {

        if (StringUtils.isNotEmpty(argItemData.getItemId())) {
            this.addItem(new Item(argItemData, argGroupItemRenderer));
        }
        this.historyHeader_.addPrice(argItemData.getPrice());
    }

}
