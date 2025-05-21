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
 * <p>Java class for LineContentType.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="LineContentType">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="None"/>
 *     &lt;enumeration value="Address"/>
 *     &lt;enumeration value="Name"/>
 *     &lt;enumeration value="Ancillary"/>
 *     &lt;enumeration value="DataPlus"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "LineContentType")
@XmlEnum
public enum CawLineContentType {

    @XmlEnumValue("None")
    NONE("None"), @XmlEnumValue("Address")
    ADDRESS("Address"), @XmlEnumValue("Name")
    NAME("Name"), @XmlEnumValue("Ancillary")
    ANCILLARY("Ancillary"), @XmlEnumValue("DataPlus")
    DATA_PLUS("DataPlus");

    private final String value;

    CawLineContentType(String v) {

        value = v;
    }

    public String value() {

        return value;
    }

    public static CawLineContentType fromValue(String v) {

        for (CawLineContentType c : CawLineContentType.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
