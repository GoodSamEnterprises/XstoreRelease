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
 * VerifyLevel   : The VerifyLevel attribute specifies the level to which the verification engine has 
 *           verified the input address.
 * 
 * <p>Java class for QABulkSearchItemType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="QABulkSearchItemType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="QAAddress" type="{http://www.qas.com/web-2013-12}QAAddressType"/>
 *         &lt;element name="InputAddress" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="VerificationFlags" type="{http://www.qas.com/web-2013-12}VerificationFlagsType" minOccurs="0"/>
 *       &lt;/sequence>
 *       &lt;attribute name="VerifyLevel" type="{http://www.qas.com/web-2013-12}VerifyLevelType" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "QABulkSearchItemType", propOrder = { "qaAddress", "inputAddress", "verificationFlags" })
public class CawQABulkSearchItemType {

    @XmlElement(name = "QAAddress", required = true)
    protected CawQAAddressType         qaAddress;

    @XmlElement(name = "InputAddress", required = true)
    protected String                   inputAddress;

    @XmlElement(name = "VerificationFlags")
    protected CawVerificationFlagsType verificationFlags;

    @XmlAttribute(name = "VerifyLevel")
    protected CawVerifyLevelType       verifyLevel;

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
     * Gets the value of the inputAddress property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getInputAddress() {

        return inputAddress;
    }

    /**
     * Sets the value of the inputAddress property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setInputAddress(String value) {

        this.inputAddress = value;
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

        return verifyLevel;
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
