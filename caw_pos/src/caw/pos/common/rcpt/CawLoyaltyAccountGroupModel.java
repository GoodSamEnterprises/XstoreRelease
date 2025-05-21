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
 * BZ24102          191017    Club accounts information is repeated many times in receipt 
 *                            when selecting 'Print Balance receipt' on Account tab in Customer screen
 * BZ44053          150621    [PROD] Membership Validation Issue - Cannot sell RENEW on active membership accounts
 *===================================================================
 */

package caw.pos.common.rcpt;

/**
 * Club Account Model
 */
public class CawLoyaltyAccountGroupModel {

    private String clubId;

    private String programName;

    private String programLevel;
    
    private String programId; // BZ-44053

    public CawLoyaltyAccountGroupModel() {

        super();
    }

    public CawLoyaltyAccountGroupModel(String argClubId, String argProgramName,
            String argProgramLevel) {

        super();
        clubId = argClubId;
        programName = argProgramName;
        programLevel = argProgramLevel;
    }

    /**
     * @return the clubId
     */
    public String getClubId() {

        return clubId;
    }

    /**
     * @param argClubId the clubId to set
     */
    public void setClubId(String argClubId) {

        clubId = argClubId;
    }

    /**
     * @return the programName
     */
    public String getProgramName() {

        return programName;
    }

    /**
     * @param argProgramName the programName to set
     */
    public void setProgramName(String argProgramName) {

        programName = argProgramName;
    }

    /**
     * @return the programLevel
     */
    public String getProgramLevel() {

        return programLevel;
    }

    /**
     * @param argProgramLevel the programLevel to set
     */
    public void setProgramLevel(String argProgramLevel) {

        programLevel = argProgramLevel;
    }

    // Start BZ-44053
    /**
     * @return the programId
     */
    public String getProgramId() {
    
        return programId;
    }

    
    /**
     * @param argProgramId the programId to set
     */
    public void setProgramId(String argProgramId) {
    
        programId = argProgramId;
    }
    // End BZ-44053
}