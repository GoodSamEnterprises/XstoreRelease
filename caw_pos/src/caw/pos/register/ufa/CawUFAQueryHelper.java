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
 * BZ25640          051518    New Requirement - Used Firearm System Process Redesign
 *===================================================================
 */

package caw.pos.register.ufa;

import java.util.*;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import dtv.data2.access.*;
import dtv.xst.dao.com.IReasonCode;
import dtv.xst.dao.com.ReasonCodeId;

/**
*
*/
public class CawUFAQueryHelper {

    public static final IQueryKey<CawUFAQueryResult> SQL_MERCH_HIERARCHY_DESC = new QueryKey<CawUFAQueryResult>(
            "SQL_MERCH_HIERARCHY_DESC", CawUFAQueryResult.class);

    public static final IQueryKey<CawUFAQueryResult> SQL_UFA_PAID_OUT_TRAN    = new QueryKey<CawUFAQueryResult>(
            "SQL_UFA_PAID_OUT_TRAN", CawUFAQueryResult.class);

    private static final String                      FIELD_DESCRIPTION        = "DESCRIPTION";

    private static final String                      ARG_HIER_ID              = "argHierId";

    private static final String                      ARG_ORGANIZATION_ID      = "argOrganizationId";

    private static final String                      ARG_STORE_ID             = "argStoreId";

    private static final String                      ARG_ETRACK_ID            = "argEtrackId";

    private static final String                      ARG_EBSITEMCODE          = "argEBSItemCode";

    private static final String                      ARG_UFA_REASON_CODE      = "argReasonCode";

    private static final Logger                      _logger                  = LogManager
            .getLogger(CawUFAQueryHelper.class);

    /**
     * QueryConfig
     * @param orgId
     * @param hierId
     * @return
     */
    public static String getMachandiseHierDesc(long orgId, String hierId) {

        String resName = null;
        try {
            Map<String, Object> params = new HashMap<>();
            params.put(ARG_ORGANIZATION_ID, orgId);
            params.put(ARG_HIER_ID, hierId);
            List<CawUFAQueryResult> results = DataFactory
                    .getObjectByQueryNoThrow(SQL_MERCH_HIERARCHY_DESC, params);
            if (results != null && !results.isEmpty()) {
                CawUFAQueryResult item = results.get(0);
                resName = String.valueOf(item.get(FIELD_DESCRIPTION));
            }
        } catch (Exception ex) {
            _logger.error("getMachandiseHierDesc-1", ex);
        }
        if (resName != null) {
            return resName;
        } else {
            return "";
        }
    }

    /**
    * Check any paid out transaction created in xStore DB for ebsItemCode
    * @return
    */
    public static boolean checkUFAPaidOutExsited(long orgId, String storeId,
            String registerId, String eTrackId, String ebsItemCode) {

        boolean found = false;
        try {
            Map<String, Object> params = new HashMap<>();
            params.put(ARG_UFA_REASON_CODE, CawUFAConstants
                    .getDefaultUAFReasonCode());
            params.put(ARG_ORGANIZATION_ID, orgId);
            params.put(ARG_STORE_ID, storeId);
            params.put(ARG_ETRACK_ID, eTrackId);
            params.put(ARG_EBSITEMCODE, ebsItemCode);
            List<CawUFAQueryResult> results = DataFactory
                    .getObjectByQueryNoThrow(SQL_UFA_PAID_OUT_TRAN, params);
            if (results != null && !results.isEmpty()) {
                CawUFAQueryResult item = results.get(0);
                if (item != null) {
                    found = true;
                }
            }
        } catch (Exception ex) {
            _logger.error("checkUFAPaidOutExsited-1", ex);
        }
        return found;
    }

    /**
     * Get Reason code for UFA
     * @param argOrgId
     * @param argCategory
     * @param argCode
     * @return
     */
    public static IReasonCode getReasonCode(long argOrgId, String argCategory,
            String argCode) {

        IReasonCode res = null;
        try {
            ReasonCodeId id = new ReasonCodeId();
            id.setOrganizationId(Long.valueOf(argOrgId));
            id.setReasonTypeCode(argCategory);
            id.setReasonCode(argCode);
            res = (IReasonCode) DataFactory.getObjectById(id);
        } catch (Exception ex) {
            _logger.error("getReasonCode-1", ex);
        }
        return res;
    }
}
