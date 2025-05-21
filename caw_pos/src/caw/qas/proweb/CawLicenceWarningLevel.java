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
 * <p>Java class for LicenceWarningLevel.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="LicenceWarningLevel">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="None"/>
 *     &lt;enumeration value="DataExpiring"/>
 *     &lt;enumeration value="LicenceExpiring"/>
 *     &lt;enumeration value="ClicksLow"/>
 *     &lt;enumeration value="Evaluation"/>
 *     &lt;enumeration value="NoClicks"/>
 *     &lt;enumeration value="DataExpired"/>
 *     &lt;enumeration value="EvalLicenceExpired"/>
 *     &lt;enumeration value="FullLicenceExpired"/>
 *     &lt;enumeration value="LicenceNotFound"/>
 *     &lt;enumeration value="DataUnreadable"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "LicenceWarningLevel")
@XmlEnum
public enum CawLicenceWarningLevel {

    @XmlEnumValue("None")
    NONE("None"), @XmlEnumValue("DataExpiring")
    DATA_EXPIRING("DataExpiring"), @XmlEnumValue("LicenceExpiring")
    LICENCE_EXPIRING("LicenceExpiring"), @XmlEnumValue("ClicksLow")
    CLICKS_LOW("ClicksLow"), @XmlEnumValue("Evaluation")
    EVALUATION("Evaluation"), @XmlEnumValue("NoClicks")
    NO_CLICKS("NoClicks"), @XmlEnumValue("DataExpired")
    DATA_EXPIRED("DataExpired"), @XmlEnumValue("EvalLicenceExpired")
    EVAL_LICENCE_EXPIRED("EvalLicenceExpired"), @XmlEnumValue("FullLicenceExpired")
    FULL_LICENCE_EXPIRED("FullLicenceExpired"), @XmlEnumValue("LicenceNotFound")
    LICENCE_NOT_FOUND("LicenceNotFound"), @XmlEnumValue("DataUnreadable")
    DATA_UNREADABLE("DataUnreadable");

    private final String value;

    CawLicenceWarningLevel(String v) {

        value = v;
    }

    public String value() {

        return value;
    }

    public static CawLicenceWarningLevel fromValue(String v) {

        for (CawLicenceWarningLevel c : CawLicenceWarningLevel.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
