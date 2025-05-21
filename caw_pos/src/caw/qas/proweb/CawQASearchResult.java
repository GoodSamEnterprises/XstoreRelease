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
 * <p>Java class for anonymous complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="QAPicklist" type="{http://www.qas.com/web-2013-12}QAPicklistType" minOccurs="0"/>
 *         &lt;element name="QAAddress" type="{http://www.qas.com/web-2013-12}QAAddressType" minOccurs="0"/>
 *         &lt;element name="VerificationFlags" type="{http://www.qas.com/web-2013-12}VerificationFlagsType" minOccurs="0"/>
 *       &lt;/sequence>
 *       &lt;attribute name="VerifyLevel" type="{http://www.qas.com/web-2013-12}VerifyLevelType" default="None" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = { "qaPicklist", "qaAddress", "verificationFlags" })
@XmlRootElement(name = "QASearchResult")
public class CawQASearchResult {

    @XmlElement(name = "QAPicklist")
    protected CawQAPicklistType        qaPicklist;

    @XmlElement(name = "QAAddress")
    protected CawQAAddressType         qaAddress;

    @XmlElement(name = "VerificationFlags")
    protected CawVerificationFlagsType verificationFlags;

    @XmlAttribute(name = "VerifyLevel")
    protected CawVerifyLevelType       verifyLevel;

    /**
     * Gets the value of the qaPicklist property.
     * 
     * @return
     *     possible object is
     *     {@link QAPicklistType }
     *     
     */
    public CawQAPicklistType getQAPicklist() {

        return qaPicklist;
    }

    /**
     * Sets the value of the qaPicklist property.
     * 
     * @param value
     *     allowed object is
     *     {@link QAPicklistType }
     *     
     */
    public void setQAPicklist(CawQAPicklistType value) {

        this.qaPicklist = value;
    }

    /**
     * Gets the value of the qaAddress property.
     * 
     * @return
     *     possible object is
     *     {@link QAAddressType }
     *     
     */
    public CawQAAddressType getQAAddress() {

        return qaAddress;
    }

    /**
     * Sets the value of the qaAddress property.
     * 
     * @param value
     *     allowed object is
     *     {@link QAAddressType }
     *     
     */
    public void setQAAddress(CawQAAddressType value) {

        this.qaAddress = value;
    }

    /**
     * Gets the value of the verificationFlags property.
     * 
     * @return
     *     possible object is
     *     {@link VerificationFlagsType }
     *     
     */
    public CawVerificationFlagsType getVerificationFlags() {

        return verificationFlags;
    }

    /**
     * Sets the value of the verificationFlags property.
     * 
     * @param value
     *     allowed object is
     *     {@link VerificationFlagsType }
     *     
     */
    public void setVerificationFlags(CawVerificationFlagsType value) {

        this.verificationFlags = value;
    }

    /**
     * Gets the value of the verifyLevel property.
     * 
     * @return
     *     possible object is
     *     {@link VerifyLevelType }
     *     
     */
    public CawVerifyLevelType getVerifyLevel() {

        if (verifyLevel == null) {
            return CawVerifyLevelType.NONE;
        } else {
            return verifyLevel;
        }
    }

    /**
     * Sets the value of the verifyLevel property.
     * 
     * @param value
     *     allowed object is
     *     {@link VerifyLevelType }
     *     
     */
    public void setVerifyLevel(CawVerifyLevelType value) {

        this.verifyLevel = value;
    }

}
