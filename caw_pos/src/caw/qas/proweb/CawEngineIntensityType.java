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
 * <p>Java class for EngineIntensityType.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="EngineIntensityType">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="Exact"/>
 *     &lt;enumeration value="Close"/>
 *     &lt;enumeration value="Extensive"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "EngineIntensityType")
@XmlEnum
public enum CawEngineIntensityType {

    @XmlEnumValue("Exact")
    EXACT("Exact"), @XmlEnumValue("Close")
    CLOSE("Close"), @XmlEnumValue("Extensive")
    EXTENSIVE("Extensive");

    private final String value;

    CawEngineIntensityType(String v) {

        value = v;
    }

    public String value() {

        return value;
    }

    public static CawEngineIntensityType fromValue(String v) {

        for (CawEngineIntensityType c : CawEngineIntensityType.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
