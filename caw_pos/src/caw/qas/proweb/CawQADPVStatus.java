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
 *         &lt;element name="QADPVLockDetails" type="{http://www.qas.com/web-2013-12}QADPVLockDetailsType" minOccurs="0"/>
 *       &lt;/sequence>
 *       &lt;attribute name="DPVReturnedStatus" type="{http://www.qas.com/web-2013-12}DPVStatusType" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = { "qadpvLockDetails" })
@XmlRootElement(name = "QADPVStatus")
public class CawQADPVStatus {

    @XmlElement(name = "QADPVLockDetails")
    protected CawQADPVLockDetailsType qadpvLockDetails;

    @XmlAttribute(name = "DPVReturnedStatus")
    protected CawDPVStatusType        dpvReturnedStatus;

    /**
     * Gets the value of the qadpvLockDetails property.
     * 
     * @return
     *     possible object is
     *     {@link QADPVLockDetailsType }
     *     
     */
    public CawQADPVLockDetailsType getQADPVLockDetails() {

        return qadpvLockDetails;
    }

    /**
     * Sets the value of the qadpvLockDetails property.
     * 
     * @param value
     *     allowed object is
     *     {@link QADPVLockDetailsType }
     *     
     */
    public void setQADPVLockDetails(CawQADPVLockDetailsType value) {

        this.qadpvLockDetails = value;
    }

    /**
     * Gets the value of the dpvReturnedStatus property.
     * 
     * @return
     *     possible object is
     *     {@link DPVStatusType }
     *     
     */
    public CawDPVStatusType getDPVReturnedStatus() {

        return dpvReturnedStatus;
    }

    /**
     * Sets the value of the dpvReturnedStatus property.
     * 
     * @param value
     *     allowed object is
     *     {@link DPVStatusType }
     *     
     */
    public void setDPVReturnedStatus(CawDPVStatusType value) {

        this.dpvReturnedStatus = value;
    }

}
