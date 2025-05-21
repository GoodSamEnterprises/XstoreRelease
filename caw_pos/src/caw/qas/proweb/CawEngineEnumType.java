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
 * <p>Java class for EngineEnumType.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="EngineEnumType">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="Singleline"/>
 *     &lt;enumeration value="Typedown"/>
 *     &lt;enumeration value="Verification"/>
 *     &lt;enumeration value="Keyfinder"/>
 *     &lt;enumeration value="Intuitive"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "EngineEnumType")
@XmlEnum
public enum CawEngineEnumType {

    @XmlEnumValue("Singleline")
    SINGLELINE("Singleline"), @XmlEnumValue("Typedown")
    TYPEDOWN("Typedown"), @XmlEnumValue("Verification")
    VERIFICATION("Verification"), @XmlEnumValue("Keyfinder")
    KEYFINDER("Keyfinder"), @XmlEnumValue("Intuitive")
    INTUITIVE("Intuitive");

    private final String value;

    CawEngineEnumType(String v) {

        value = v;
    }

    public String value() {

        return value;
    }

    public static CawEngineEnumType fromValue(String v) {

        for (CawEngineEnumType c : CawEngineEnumType.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
