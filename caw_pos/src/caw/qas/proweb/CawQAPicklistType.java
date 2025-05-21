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

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.*;

/**
 * CanFlatten          : Can this picklist be flattened.
 * 
 * <p>Java class for QAPicklistType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="QAPicklistType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="FullPicklistMoniker" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="PicklistEntry" type="{http://www.qas.com/web-2013-12}PicklistEntryType" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="Prompt" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="Total" type="{http://www.w3.org/2001/XMLSchema}nonNegativeInteger" minOccurs="0"/>
 *         &lt;element name="PotentialMatches" type="{http://www.w3.org/2001/XMLSchema}nonNegativeInteger" minOccurs="0"/>
 *       &lt;/sequence>
 *       &lt;attribute name="AutoFormatSafe" type="{http://www.w3.org/2001/XMLSchema}boolean" default="false" />
 *       &lt;attribute name="AutoFormatPastClose" type="{http://www.w3.org/2001/XMLSchema}boolean" default="false" />
 *       &lt;attribute name="AutoStepinSafe" type="{http://www.w3.org/2001/XMLSchema}boolean" default="false" />
 *       &lt;attribute name="AutoStepinPastClose" type="{http://www.w3.org/2001/XMLSchema}boolean" default="false" />
 *       &lt;attribute name="LargePotential" type="{http://www.w3.org/2001/XMLSchema}boolean" default="false" />
 *       &lt;attribute name="MaxMatches" type="{http://www.w3.org/2001/XMLSchema}boolean" default="false" />
 *       &lt;attribute name="MoreOtherMatches" type="{http://www.w3.org/2001/XMLSchema}boolean" default="false" />
 *       &lt;attribute name="OverThreshold" type="{http://www.w3.org/2001/XMLSchema}boolean" default="false" />
 *       &lt;attribute name="Timeout" type="{http://www.w3.org/2001/XMLSchema}boolean" default="false" />
 *       &lt;attribute name="CanFlatten" type="{http://www.w3.org/2001/XMLSchema}boolean" default="false" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "QAPicklistType", propOrder = { "fullPicklistMoniker", "picklistEntry", "prompt", "total", "potentialMatches" })
public class CawQAPicklistType {

    @XmlElement(name = "FullPicklistMoniker")
    protected String                     fullPicklistMoniker;

    @XmlElement(name = "PicklistEntry")
    protected List<CawPicklistEntryType> picklistEntry;

    @XmlElement(name = "Prompt", required = true)
    protected String                     prompt;

    @XmlElement(name = "Total")
    @XmlSchemaType(name = "nonNegativeInteger")
    protected BigInteger                 total;

    @XmlElement(name = "PotentialMatches")
    @XmlSchemaType(name = "nonNegativeInteger")
    protected BigInteger                 potentialMatches;

    @XmlAttribute(name = "AutoFormatSafe")
    protected Boolean                    autoFormatSafe;

    @XmlAttribute(name = "AutoFormatPastClose")
    protected Boolean                    autoFormatPastClose;

    @XmlAttribute(name = "AutoStepinSafe")
    protected Boolean                    autoStepinSafe;

    @XmlAttribute(name = "AutoStepinPastClose")
    protected Boolean                    autoStepinPastClose;

    @XmlAttribute(name = "LargePotential")
    protected Boolean                    largePotential;

    @XmlAttribute(name = "MaxMatches")
    protected Boolean                    maxMatches;

    @XmlAttribute(name = "MoreOtherMatches")
    protected Boolean                    moreOtherMatches;

    @XmlAttribute(name = "OverThreshold")
    protected Boolean                    overThreshold;

    @XmlAttribute(name = "Timeout")
    protected Boolean                    timeout;

    @XmlAttribute(name = "CanFlatten")
    protected Boolean                    canFlatten;

    /**
     * Gets the value of the fullPicklistMoniker property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFullPicklistMoniker() {

        return fullPicklistMoniker;
    }

    /**
     * Sets the value of the fullPicklistMoniker property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFullPicklistMoniker(String value) {

        this.fullPicklistMoniker = value;
    }

    /**
     * Gets the value of the picklistEntry property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the picklistEntry property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getPicklistEntry().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link PicklistEntryType }
     * 
     * 
     */
    public List<CawPicklistEntryType> getPicklistEntry() {

        if (picklistEntry == null) {
            picklistEntry = new ArrayList<CawPicklistEntryType>();
        }
        return this.picklistEntry;
    }

    /**
     * Gets the value of the prompt property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPrompt() {

        return prompt;
    }

    /**
     * Sets the value of the prompt property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPrompt(String value) {

        this.prompt = value;
    }

    /**
     * Gets the value of the total property.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getTotal() {

        return total;
    }

    /**
     * Sets the value of the total property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setTotal(BigInteger value) {

        this.total = value;
    }

    /**
     * Gets the value of the potentialMatches property.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getPotentialMatches() {

        return potentialMatches;
    }

    /**
     * Sets the value of the potentialMatches property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setPotentialMatches(BigInteger value) {

        this.potentialMatches = value;
    }

    /**
     * Gets the value of the autoFormatSafe property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public boolean isAutoFormatSafe() {

        if (autoFormatSafe == null) {
            return false;
        } else {
            return autoFormatSafe;
        }
    }

    /**
     * Sets the value of the autoFormatSafe property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setAutoFormatSafe(Boolean value) {

        this.autoFormatSafe = value;
    }

    /**
     * Gets the value of the autoFormatPastClose property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public boolean isAutoFormatPastClose() {

        if (autoFormatPastClose == null) {
            return false;
        } else {
            return autoFormatPastClose;
        }
    }

    /**
     * Sets the value of the autoFormatPastClose property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setAutoFormatPastClose(Boolean value) {

        this.autoFormatPastClose = value;
    }

    /**
     * Gets the value of the autoStepinSafe property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public boolean isAutoStepinSafe() {

        if (autoStepinSafe == null) {
            return false;
        } else {
            return autoStepinSafe;
        }
    }

    /**
     * Sets the value of the autoStepinSafe property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setAutoStepinSafe(Boolean value) {

        this.autoStepinSafe = value;
    }

    /**
     * Gets the value of the autoStepinPastClose property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public boolean isAutoStepinPastClose() {

        if (autoStepinPastClose == null) {
            return false;
        } else {
            return autoStepinPastClose;
        }
    }

    /**
     * Sets the value of the autoStepinPastClose property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setAutoStepinPastClose(Boolean value) {

        this.autoStepinPastClose = value;
    }

    /**
     * Gets the value of the largePotential property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public boolean isLargePotential() {

        if (largePotential == null) {
            return false;
        } else {
            return largePotential;
        }
    }

    /**
     * Sets the value of the largePotential property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setLargePotential(Boolean value) {

        this.largePotential = value;
    }

    /**
     * Gets the value of the maxMatches property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public boolean isMaxMatches() {

        if (maxMatches == null) {
            return false;
        } else {
            return maxMatches;
        }
    }

    /**
     * Sets the value of the maxMatches property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setMaxMatches(Boolean value) {

        this.maxMatches = value;
    }

    /**
     * Gets the value of the moreOtherMatches property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public boolean isMoreOtherMatches() {

        if (moreOtherMatches == null) {
            return false;
        } else {
            return moreOtherMatches;
        }
    }

    /**
     * Sets the value of the moreOtherMatches property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setMoreOtherMatches(Boolean value) {

        this.moreOtherMatches = value;
    }

    /**
     * Gets the value of the overThreshold property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public boolean isOverThreshold() {

        if (overThreshold == null) {
            return false;
        } else {
            return overThreshold;
        }
    }

    /**
     * Sets the value of the overThreshold property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setOverThreshold(Boolean value) {

        this.overThreshold = value;
    }

    /**
     * Gets the value of the timeout property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public boolean isTimeout() {

        if (timeout == null) {
            return false;
        } else {
            return timeout;
        }
    }

    /**
     * Sets the value of the timeout property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setTimeout(Boolean value) {

        this.timeout = value;
    }

    /**
     * Gets the value of the canFlatten property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public boolean isCanFlatten() {

        if (canFlatten == null) {
            return false;
        } else {
            return canFlatten;
        }
    }

    /**
     * Sets the value of the canFlatten property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setCanFlatten(Boolean value) {

        this.canFlatten = value;
    }

}
