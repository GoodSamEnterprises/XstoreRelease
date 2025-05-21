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
 * BZ23405          160118    [QAS] There are problem when integrate Xstore with QAS service of Camping World
 *===================================================================
 */

package caw.qas.proweb;

import javax.xml.bind.annotation.*;

/**
 * <p>Java class for VerifyLevelType.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="VerifyLevelType">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="None"/>
 *     &lt;enumeration value="Verified"/>
 *     &lt;enumeration value="InteractionRequired"/>
 *     &lt;enumeration value="PremisesPartial"/>
 *     &lt;enumeration value="StreetPartial"/>
 *     &lt;enumeration value="Multiple"/>
 *     &lt;enumeration value="VerifiedPlace"/>
 *     &lt;enumeration value="VerifiedStreet"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "VerifyLevelType")
@XmlEnum
public enum CawVerifyLevelType {

    @XmlEnumValue("None")
    NONE("None"), @XmlEnumValue("Verified")
    VERIFIED("Verified"), @XmlEnumValue("InteractionRequired")
    INTERACTION_REQUIRED("InteractionRequired"), @XmlEnumValue("PremisesPartial")
    PREMISES_PARTIAL("PremisesPartial"), @XmlEnumValue("StreetPartial")
    STREET_PARTIAL("StreetPartial"), @XmlEnumValue("Multiple")
    MULTIPLE("Multiple"), @XmlEnumValue("VerifiedPlace")
    VERIFIED_PLACE("VerifiedPlace"), @XmlEnumValue("VerifiedStreet")
    VERIFIED_STREET("VerifiedStreet");

    private final String value;

    CawVerifyLevelType(String v) {

        value = v;
    }

    public String value() {

        return value;
    }

    public static CawVerifyLevelType fromValue(String v) {

        for (CawVerifyLevelType c : CawVerifyLevelType.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
