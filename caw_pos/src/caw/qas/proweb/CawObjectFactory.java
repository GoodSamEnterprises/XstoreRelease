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

import javax.xml.bind.annotation.XmlRegistry;

/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the caw.qas.proweb package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class CawObjectFactory {

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: caw.qas.proweb
     * 
     */
    public CawObjectFactory() {

        super();
    }

    /**
     * Create an instance of {@link QAAddressType }
     * 
     */
    public CawQAAddressType createQAAddressType() {

        return new CawQAAddressType();
    }

    /**
     * Create an instance of {@link QASearch }
     * 
     */
    public CawQASearch createQASearch() {

        return new CawQASearch();
    }

    /**
     * Create an instance of {@link EngineType }
     * 
     */
    public CawEngineType createEngineType() {

        return new CawEngineType();
    }

    /**
     * Create an instance of {@link Picklist }
     * 
     */
    public CawPicklist createPicklist() {

        return new CawPicklist();
    }

    /**
     * Create an instance of {@link QAPicklistType }
     * 
     */
    public CawQAPicklistType createQAPicklistType() {

        return new CawQAPicklistType();
    }

    /**
     * Create an instance of {@link QADPVStatus }
     * 
     */
    public CawQADPVStatus createQADPVStatus() {

        return new CawQADPVStatus();
    }

    /**
     * Create an instance of {@link QADPVLockDetailsType }
     * 
     */
    public CawQADPVLockDetailsType createQADPVLockDetailsType() {

        return new CawQADPVLockDetailsType();
    }

    /**
     * Create an instance of {@link QACanSearch }
     * 
     */
    public CawQACanSearch createQACanSearch() {

        return new CawQACanSearch();
    }

    /**
     * Create an instance of {@link QASearchResult }
     * 
     */
    public CawQASearchResult createQASearchResult() {

        return new CawQASearchResult();
    }

    /**
     * Create an instance of {@link VerificationFlagsType }
     * 
     */
    public CawVerificationFlagsType createVerificationFlagsType() {

        return new CawVerificationFlagsType();
    }

    /**
     * Create an instance of {@link QAData }
     * 
     */
    public CawQAData createQAData() {

        return new CawQAData();
    }

    /**
     * Create an instance of {@link QADataSet }
     * 
     */
    public CawQADataSet createQADataSet() {

        return new CawQADataSet();
    }

    /**
     * Create an instance of {@link QARefine }
     * 
     */
    public CawQARefine createQARefine() {

        return new CawQARefine();
    }

    /**
     * Create an instance of {@link QAFault }
     * 
     */
    public CawQAFault createQAFault() {

        return new CawQAFault();
    }

    /**
     * Create an instance of {@link AddressLineType }
     * 
     */
    public CawAddressLineType createAddressLineType() {

        return new CawAddressLineType();
    }

    /**
     * Create an instance of {@link PicklistEntryType }
     * 
     */
    public CawPicklistEntryType createPicklistEntryType() {

        return new CawPicklistEntryType();
    }

    /**
     * Create an instance of {@link DataplusGroupType }
     * 
     */
    public CawDataplusGroupType createDataplusGroupType() {

        return new CawDataplusGroupType();
    }

}
