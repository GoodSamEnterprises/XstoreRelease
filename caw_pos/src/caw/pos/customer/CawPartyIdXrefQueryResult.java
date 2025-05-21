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
 * BZ26398          070618    Club pricing is displayed on top banner once adding RA join item for transaction in offline case.
 *===================================================================
 */

package caw.pos.customer;

import java.math.BigDecimal;
import java.util.Date;

import dtv.data2.access.AbstractQueryResult;
import dtv.data2.access.IObjectId;

/**
 *
 */
public class CawPartyIdXrefQueryResult extends AbstractQueryResult {

    private static final long serialVersionUID = 1L;

    private Long              organizationId;

    private Long              partyId;

    private String            alternateIdOwner;

    private String            propertyCode;

    private String            type;

    private String            stringValue;

    private Date              dateValue;

    private BigDecimal        decimalValue;

    /**
     * @return the organizationId
     */
    public Long getOrganizationId() {

        return organizationId;
    }

    /**
     * @param argOrganizationId the organizationId to set
     */
    public void setOrganizationId(Long argOrganizationId) {

        organizationId = argOrganizationId;
    }

    /**
     * @return the partyId
     */
    public Long getPartyId() {

        return partyId;
    }

    /**
     * @param argPartyId the partyId to set
     */
    public void setPartyId(Long argPartyId) {

        partyId = argPartyId;
    }

    /**
     * @return the alternateIdOwner
     */
    public String getAlternateIdOwner() {

        return alternateIdOwner;
    }

    /**
     * @param argAlternateIdOwner the alternateIdOwner to set
     */
    public void setAlternateIdOwner(String argAlternateIdOwner) {

        alternateIdOwner = argAlternateIdOwner;
    }

    /**
     * @return the propertyCode
     */
    public String getPropertyCode() {

        return propertyCode;
    }

    /**
     * @param argPropertyCode the propertyCode to set
     */
    public void setPropertyCode(String argPropertyCode) {

        propertyCode = argPropertyCode;
    }

    /**
     * @return the type
     */
    public String getType() {

        return type;
    }

    /**
     * @param argType the type to set
     */
    public void setType(String argType) {

        type = argType;
    }

    /**
     * @return the stringValue
     */
    public String getStringValue() {

        return stringValue;
    }

    /**
     * @param argStringValue the stringValue to set
     */
    public void setStringValue(String argStringValue) {

        stringValue = argStringValue;
    }

    /**
     * @return the dateValue
     */
    public Date getDateValue() {

        return dateValue;
    }

    /**
     * @param argDateValue the dateValue to set
     */
    public void setDateValue(Date argDateValue) {

        dateValue = argDateValue;
    }

    /**
     * @return the decimalValue
     */
    public BigDecimal getDecimalValue() {

        return decimalValue;
    }

    /**
     * @param argDecimalValue the decimalValue to set
     */
    public void setDecimalValue(BigDecimal argDecimalValue) {

        decimalValue = argDecimalValue;
    }

    @Override
    protected IObjectId getObjectIdImpl() {

        return null;
    }

}
