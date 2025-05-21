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
 * BZ38009          100720    [INTERNAL] Order Cancel must follow existing CW Refund tender Matrix
 * BZ46879          102720    Xstore Patch 16 Receipt Issues
 *===================================================================
 */

package caw.xst.query.result;

import java.util.Date;

import dtv.data2.access.AbstractQueryResult;
import dtv.data2.access.IObjectId;

/**
 *
 */
public class CawOrderModQueryResult extends AbstractQueryResult {
	
    private static final long serialVersionUID = 1L;
    Long                      orgId;
    String                    rtlId;
    String                    wstId;
    Long                      transSeq;
    Date                      bDate;
    int                       transLineItmSeq;
    /*BEGIN BZ46879*/
    int                       detailSeq;            
    String                    itemType; 
    /*END BZ46879*/

    
    /**
     * @return the orgId
     */
    public Long getOrgId() {
        return orgId;
    }

    /**
     * @param argOrgId the orgId to set
     */
    public void setOrgId(Long argOrgId) {
        orgId = argOrgId;
    }

    /**
     * @return the rtlId
     */
    public String getRtlId() {
        return rtlId;
    }

    /**
     * @param argRtlId the rtlId to set
     */
    public void setRtlId(String argRtlId) {
        rtlId = argRtlId;
    }

    /**
     * @return the wstId
     */
    public String getWstId() {
        return wstId;
    }

    /**
     * @param argWstId the wstId to set
     */
    public void setWstId(String argWstId) {
        wstId = argWstId;
    }

    /**
     * @return the transSeq
     */
    public Long getTransSeq() {
        return transSeq;
    }

    /**
     * @param argTransSeq the transSeq to set
     */
    public void setTransSeq(Long argTransSeq) {
        transSeq = argTransSeq;
    }

    /**
     * @return the bDate
     */
    public Date getBDate() {
        return bDate;
    }

    /**
     * @param argBDate the bDate to set
     */
    public void setBDate(Date argBDate) {
        bDate = argBDate;
    }

    /* (non-Javadoc)
     * @see dtv.data2.access.AbstractQueryResult#getObjectIdImpl()
     */
    @Override
    protected IObjectId getObjectIdImpl() {
        return null;
    }

    public int getTransLineItmSeq() {
        return transLineItmSeq;
    }

    /**
     * @param argTransSeq the transSeq to set
     */
    public void setTransLineItmSeq(int argtransLineItmSeq) {
        transLineItmSeq = argtransLineItmSeq;
    }
    
    /*BEGIN BZ46879*/
    /**
     * @return the detailSeq
     */
    public int getDetailSeq() {
    
        return detailSeq;
    }

    
    /**
     * @param argDetailSeq the detailSeq to set
     */
    public void setDetailSeq(int argDetailSeq) {
    
        detailSeq = argDetailSeq;
    }

    
    /**
     * @return the itemType
     */
    public String getItemType() {
    
        return itemType;
    }

    
    /**
     * @param argItemType the itemType to set
     */
    public void setItemType(String argItemType) {
    
        itemType = argItemType;
    }
    
    /*END BZ46879*/

}
