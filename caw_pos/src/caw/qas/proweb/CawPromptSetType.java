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
 * <p>Java class for PromptSetType.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="PromptSetType">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="OneLine"/>
 *     &lt;enumeration value="Default"/>
 *     &lt;enumeration value="Generic"/>
 *     &lt;enumeration value="Optimal"/>
 *     &lt;enumeration value="Alternate"/>
 *     &lt;enumeration value="Alternate2"/>
 *     &lt;enumeration value="Alternate3"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "PromptSetType")
@XmlEnum
public enum CawPromptSetType {

    @XmlEnumValue("OneLine")
    ONE_LINE("OneLine"), @XmlEnumValue("Default")
    DEFAULT("Default"), @XmlEnumValue("Generic")
    GENERIC("Generic"), @XmlEnumValue("Optimal")
    OPTIMAL("Optimal"), @XmlEnumValue("Alternate")
    ALTERNATE("Alternate"), @XmlEnumValue("Alternate2")
    ALTERNATE_2("Alternate2"), @XmlEnumValue("Alternate3")
    ALTERNATE_3("Alternate3");

    private final String value;

    CawPromptSetType(String v) {

        value = v;
    }

    public String value() {

        return value;
    }

    public static CawPromptSetType fromValue(String v) {

        for (CawPromptSetType c : CawPromptSetType.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
