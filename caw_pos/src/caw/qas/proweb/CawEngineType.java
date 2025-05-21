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
 * PicklistSize  : The maximum number of items displayed in a picklist (Singleline and Intuitive engine)
 * 
 * <p>Java class for EngineType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="EngineType">
 *   &lt;simpleContent>
 *     &lt;extension base="&lt;http://www.qas.com/web-2013-12>EngineEnumType">
 *       &lt;attribute name="Flatten" type="{http://www.w3.org/2001/XMLSchema}boolean" />
 *       &lt;attribute name="Intensity" type="{http://www.qas.com/web-2013-12}EngineIntensityType" />
 *       &lt;attribute name="PromptSet" type="{http://www.qas.com/web-2013-12}PromptSetType" />
 *       &lt;attribute name="Threshold" type="{http://www.qas.com/web-2013-12}ThresholdType" />
 *       &lt;attribute name="Timeout" type="{http://www.qas.com/web-2013-12}TimeoutType" />
 *       &lt;attribute name="Constraint" type="{http://www.qas.com/web-2013-12}ConstraintType" />
 *       &lt;attribute name="PicklistSize" type="{http://www.qas.com/web-2013-12}PicklistSizeType" />
 *     &lt;/extension>
 *   &lt;/simpleContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "EngineType", propOrder = { "value" })
public class CawEngineType {

    @XmlValue
    protected CawEngineEnumType      value;

    @XmlAttribute(name = "Flatten")
    protected Boolean                flatten;

    @XmlAttribute(name = "Intensity")
    protected CawEngineIntensityType intensity;

    @XmlAttribute(name = "PromptSet")
    protected CawPromptSetType       promptSet;

    @XmlAttribute(name = "Threshold")
    protected Integer                threshold;

    @XmlAttribute(name = "Timeout")
    protected Integer                timeout;

    @XmlAttribute(name = "Constraint")
    protected String                 constraint;

    @XmlAttribute(name = "PicklistSize")
    protected Integer                picklistSize;

    /**
     * The available engines
     * 
     * @return
     *     possible object is
     *     {@link EngineEnumType }
     *     
     */
    public CawEngineEnumType getValue() {

        return value;
    }

    /**
     * Sets the value of the value property.
     * 
     * @param value
     *     allowed object is
     *     {@link EngineEnumType }
     *     
     */
    public void setValue(CawEngineEnumType value) {

        this.value = value;
    }

    /**
     * Gets the value of the flatten property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isFlatten() {

        return flatten;
    }

    /**
     * Sets the value of the flatten property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setFlatten(Boolean value) {

        this.flatten = value;
    }

    /**
     * Gets the value of the intensity property.
     * 
     * @return
     *     possible object is
     *     {@link EngineIntensityType }
     *     
     */
    public CawEngineIntensityType getIntensity() {

        return intensity;
    }

    /**
     * Sets the value of the intensity property.
     * 
     * @param value
     *     allowed object is
     *     {@link EngineIntensityType }
     *     
     */
    public void setIntensity(CawEngineIntensityType value) {

        this.intensity = value;
    }

    /**
     * Gets the value of the promptSet property.
     * 
     * @return
     *     possible object is
     *     {@link PromptSetType }
     *     
     */
    public CawPromptSetType getPromptSet() {

        return promptSet;
    }

    /**
     * Sets the value of the promptSet property.
     * 
     * @param value
     *     allowed object is
     *     {@link PromptSetType }
     *     
     */
    public void setPromptSet(CawPromptSetType value) {

        this.promptSet = value;
    }

    /**
     * Gets the value of the threshold property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getThreshold() {

        return threshold;
    }

    /**
     * Sets the value of the threshold property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setThreshold(Integer value) {

        this.threshold = value;
    }

    /**
     * Gets the value of the timeout property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getTimeout() {

        return timeout;
    }

    /**
     * Sets the value of the timeout property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setTimeout(Integer value) {

        this.timeout = value;
    }

    /**
     * Gets the value of the constraint property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getConstraint() {

        return constraint;
    }

    /**
     * Sets the value of the constraint property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setConstraint(String value) {

        this.constraint = value;
    }

    /**
     * Gets the value of the picklistSize property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getPicklistSize() {

        return picklistSize;
    }

    /**
     * Sets the value of the picklistSize property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setPicklistSize(Integer value) {

        this.picklistSize = value;
    }

}
