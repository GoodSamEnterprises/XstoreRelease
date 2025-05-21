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
 * BZ44528          130821    Electric World & Mobile POS Implementation(Phase 1)
 *===================================================================
 */

package caw.pos.wondersign.response;

import java.util.List;

import com.fasterxml.jackson.databind.JsonNode;

import caw.pos.wondersign.model.CawWonderSignCart;

/**
 *
 */
public class CawCartSearchResponse {

    public static final int         SEARCH_CART_SUCCESS_STATUS = 2;

    public static final int         SEARCH_CART_ERROR_STATUS   = 3;

    private List<CawWonderSignCart> results;

    private int                     matches;

    private int                     totalPages;

    private int                     status;

    private String                  statusDescription;

    private JsonNode                errors;

    private JsonNode                warnings;

    private String                  timeInService;

    /**
     * 
     */
    public CawCartSearchResponse() {

        super();
    }

    /**
     * @return the results
     */
    public List<CawWonderSignCart> getResults() {

        return results;
    }

    /**
     * @param argResults the results to set
     */
    public void setResults(List<CawWonderSignCart> argResults) {

        results = argResults;
    }

    /**
     * @return the matches
     */
    public int getMatches() {

        return matches;
    }

    /**
     * @param argMatches the matches to set
     */
    public void setMatches(int argMatches) {

        matches = argMatches;
    }

    /**
     * @return the totalPages
     */
    public int getTotalPages() {

        return totalPages;
    }

    /**
     * @param argTotalPages the totalPages to set
     */
    public void setTotalPages(int argTotalPages) {

        totalPages = argTotalPages;
    }

    /**
     * @return the status
     */
    public int getStatus() {

        return status;
    }

    /**
     * @param argStatus the status to set
     */
    public void setStatus(int argStatus) {

        status = argStatus;
    }

    /**
     * @return the statusDescription
     */
    public String getStatusDescription() {

        return statusDescription;
    }

    /**
     * @param argStatusDescription the statusDescription to set
     */
    public void setStatusDescription(String argStatusDescription) {

        statusDescription = argStatusDescription;
    }

    /**
     * @return the errors
     */
    public JsonNode getErrors() {

        return errors;
    }

    /**
     * @param argErrors the errors to set
     */
    public void setErrors(JsonNode argErrors) {

        errors = argErrors;
    }

    /**
     * @return the warnings
     */
    public JsonNode getWarnings() {

        return warnings;
    }

    /**
     * @param argWarnings the warnings to set
     */
    public void setWarnings(JsonNode argWarnings) {

        warnings = argWarnings;
    }

    /**
     * @return the timeInService
     */
    public String getTimeInService() {

        return timeInService;
    }

    /**
     * @param argTimeInService the timeInService to set
     */
    public void setTimeInService(String argTimeInService) {

        timeInService = argTimeInService;
    }

    @Override
    public String toString() {

        return "CawCartSearchResponse [results=" + results + ", matches="
                + matches + ", totalPages=" + totalPages + ", status=" + status
                + ", statusDescription=" + statusDescription + ", errors="
                + errors + ", warnings=" + warnings + ", timeInService="
                + timeInService + "]";
    }

}
