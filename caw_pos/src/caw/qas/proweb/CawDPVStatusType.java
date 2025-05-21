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
 * <p>Java class for DPVStatusType.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="DPVStatusType">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="DPVNotConfigured"/>
 *     &lt;enumeration value="DPVConfigured"/>
 *     &lt;enumeration value="DPVConfirmed"/>
 *     &lt;enumeration value="DPVConfirmedMissingSec"/>
 *     &lt;enumeration value="DPVNotConfirmed"/>
 *     &lt;enumeration value="DPVLocked"/>
 *     &lt;enumeration value="DPVSeedHit"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "DPVStatusType")
@XmlEnum
public enum CawDPVStatusType {

    @XmlEnumValue("DPVNotConfigured")
    DPV_NOT_CONFIGURED("DPVNotConfigured"), @XmlEnumValue("DPVConfigured")
    DPV_CONFIGURED("DPVConfigured"), @XmlEnumValue("DPVConfirmed")
    DPV_CONFIRMED("DPVConfirmed"), @XmlEnumValue("DPVConfirmedMissingSec")
    DPV_CONFIRMED_MISSING_SEC("DPVConfirmedMissingSec"), @XmlEnumValue("DPVNotConfirmed")
    DPV_NOT_CONFIRMED("DPVNotConfirmed"), @XmlEnumValue("DPVLocked")
    DPV_LOCKED("DPVLocked"), @XmlEnumValue("DPVSeedHit")
    DPV_SEED_HIT("DPVSeedHit");

    private final String value;

    CawDPVStatusType(String v) {

        value = v;
    }

    public String value() {

        return value;
    }

    public static CawDPVStatusType fromValue(String v) {

        for (CawDPVStatusType c : CawDPVStatusType.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
