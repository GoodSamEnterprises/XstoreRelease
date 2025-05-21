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
 * DPVLockCode    : DPV Lock code
 * 
 * <p>Java class for QADPVLockDetailsType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="QADPVLockDetailsType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="DPVLockDate" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="DPVLockTime" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="DPVSeedAddress" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="DPVLockCode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "QADPVLockDetailsType", propOrder = { "dpvLockDate", "dpvLockTime", "dpvSeedAddress", "dpvLockCode" })
public class CawQADPVLockDetailsType {

    @XmlElement(name = "DPVLockDate")
    protected String dpvLockDate;

    @XmlElement(name = "DPVLockTime")
    protected String dpvLockTime;

    @XmlElement(name = "DPVSeedAddress")
    protected String dpvSeedAddress;

    @XmlElement(name = "DPVLockCode")
    protected String dpvLockCode;

    /**
     * Gets the value of the dpvLockDate property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDPVLockDate() {

        return dpvLockDate;
    }

    /**
     * Sets the value of the dpvLockDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDPVLockDate(String value) {

        this.dpvLockDate = value;
    }

    /**
     * Gets the value of the dpvLockTime property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDPVLockTime() {

        return dpvLockTime;
    }

    /**
     * Sets the value of the dpvLockTime property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDPVLockTime(String value) {

        this.dpvLockTime = value;
    }

    /**
     * Gets the value of the dpvSeedAddress property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDPVSeedAddress() {

        return dpvSeedAddress;
    }

    /**
     * Sets the value of the dpvSeedAddress property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDPVSeedAddress(String value) {

        this.dpvSeedAddress = value;
    }

    /**
     * Gets the value of the dpvLockCode property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDPVLockCode() {

        return dpvLockCode;
    }

    /**
     * Sets the value of the dpvLockCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDPVLockCode(String value) {

        this.dpvLockCode = value;
    }

}
