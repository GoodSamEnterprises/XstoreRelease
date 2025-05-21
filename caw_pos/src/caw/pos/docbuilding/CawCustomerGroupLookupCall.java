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
 * BZ23607          031017    CWS Receipts Requires Printing of Regular and Club Pricing for Items
 * BZ24017          151017    [Technical issue] - Avoid calling printStackTrace() in production code
 * BZ24456          131117    [Receipt] Missing auth info on receipts for Gift Card Issue & reload when sold as non-merch item
 *===================================================================
 */

package caw.pos.docbuilding;

import java.io.IOException;
import java.util.*;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import dtv.data2.access.*;
import dtv.docbuilding.*;
import dtv.pos.common.ConfigurationMgr;
import dtv.xst.crm.impl.task.TaskTypeResult;
import dtv.xst.dao.trl.ISaleReturnLineItem;

/**
 * Obtains an IRetailLocation object for a given transaction's RetailLocationId via LocationFactory. <br>
 */
public class CawCustomerGroupLookupCall extends DocBuilderCall {

    public static final IQueryKey<TaskTypeResult> CRM_GROUP_DESCRIPTION_LOOKUP = new QueryKey<TaskTypeResult>(
            "CRM_GROUP_DESCRIPTION_LOOKUP", TaskTypeResult.class);

    private static final String                   ARG_ORGANIZATION_ID          = "argOrganizationId";

    private static final String                   ARG_CUSTOMER_GROUP_CODE      = "argCode";

    private static final Logger                   _logger                      = LogManager
            .getLogger(CawCustomerGroupLookupCall.class);

    /** Constructs a <code>RetailLocationLookupCall</code>. */
    public CawCustomerGroupLookupCall() {

        dtv.util.temp.InjectionHammer.forceAtInjectProcessing(this);
    }

    @Override
    public void buildDoc(IPosDocument argDoc, Object argSource,
            IDocElementFactory argElementFactory) {

        try {
            if (argSource instanceof ISaleReturnLineItem) {
                ISaleReturnLineItem item = (ISaleReturnLineItem) argSource;
                if (item.getPricePropertyCode() != null) { // BZ 24456
                    iterate(argDoc, argElementFactory, item
                            .getPricePropertyCode());
                }
            }

        } catch (IOException ex) {
            _logger.error("Exception in method CawCustomerGroupLookupCall: "
                    + ex.getMessage());
        }
    }

    /**
     * Searching the Group Description based on group code.
     *
     * @return true if the condition is met, else return false
     */
    /** {@inheritDoc} */
    @Override
    protected void iterate(IPosDocument argDoc,
            IDocElementFactory argElementFactory, Object argObject)
            throws IOException {

        TaskTypeResult target = new TaskTypeResult();
        Map<String, Object> params = new HashMap<String, Object>();
        params.put(ARG_ORGANIZATION_ID, ConfigurationMgr.getOrganizationId());
        params.put(ARG_CUSTOMER_GROUP_CODE, argObject.toString());
        try {
            List<TaskTypeResult> results = DataFactory
                    .getObjectByQuery(CRM_GROUP_DESCRIPTION_LOOKUP, params);
            if (results != null && results.size() > 0) {
                TaskTypeResult taskType = results.get(0);
                if (taskType != null) {
                    target = taskType;
                }
            }

        } catch (Exception ex) {
            _logger.error("SQL exception: " + ex.getMessage());
        }

        super.iterate(argDoc, argElementFactory, target);
    }
}
