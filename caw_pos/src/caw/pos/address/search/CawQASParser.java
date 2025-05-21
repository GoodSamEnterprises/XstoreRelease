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
 * BZ25358          290418    Enhancements to QAS Integration with POS 
 *===================================================================
 */

package caw.pos.address.search;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import caw.qas.proweb.*;

/**
 *
 */
public class CawQASParser {

    private static final Logger          _logger  = LogManager.getLogger(CawQASParser.class);

    /**
     * The singleton instance of the CawQASParser class
     */
    private static volatile CawQASParser instance = null;

    /**
     * Default constructor is private
     */
    private CawQASParser() {

        super();
    }

    /**
     * Returns a reference to the single instance of this object
     * 
     * @return CawQASParser
     */
    public static CawQASParser getInstance() {

        if (instance == null) {
            synchronized (CawQASParser.class) {
                if (instance == null) {
                    instance = new CawQASParser();
                }
            }
        }
        return instance;
    }

    public String buildDoSearchRequestXml(CawQASearch searchString) {

        String str2 = "<?xml version=\"1.0\"?>\r\n<soap:Envelope xmlns:soap=\"http://schemas.xmlsoap.org/soap/envelope/\">\r\n  <soap:Body>\r\n"
                + getXMLDoc(searchString.getCountry(), searchString.getEngine().getValue().toString(), searchString
                        .getLayout(), searchString.getSearch(), "\"http://www.qas.com/web-2013-12\"")
                + "  </soap:Body>\r\n" + "</soap:Envelope>";
        String str1 = buildHTTPHeader("DoSearch", str2.length()) + str2;
        return str1;
    }

    public String buildDoRefineRequestXml(String Moniker, String Refinement, CawQARefine searchString) {

        String str2 = "<?xml version=\"1.0\"?>\r\n<soap:Envelope xmlns:soap=\"http://schemas.xmlsoap.org/soap/envelope/\">\r\n  <soap:Body>\r\n"
                + getXMLDocRefine(Moniker, Refinement, searchString.getLayout(), "\"http://www.qas.com/web-2013-12\"")
                + "  </soap:Body>\r\n" + "</soap:Envelope>";
        String str1 = buildHTTPHeader("DoRefine", str2.length()) + str2;
        return str1;
    }

    public String buildHTTPHeader(String paramString, int paramInt) {

        return "POST / HTTP/1.1\r\nSOAPAction: \"http://www.qas.com/web-2013-12/" + paramString + "\"\r\n"
                + "Content-Type: text/xml\r\n" + "Content-Length: " + paramInt + "\r\n"
                + "Proxy-Connection: Keep-Alive\r\n\r\n";
    }

    public String getXMLDoc(String country, String engine, String layout, String search, String paramString) {

        StringBuilder request = new StringBuilder();
        String str1, str2, str3, str4 = "";
        try {
            str1 = country != null ? "<qas:Country>" + country + "</qas:Country>" : "<qas:Country/>";
            str2 = engine != null ? "<qas:Engine>" + engine + "</qas:Engine>" : "<qas:Engine/>";
            str3 = layout != null ? "<qas:Layout>" + layout + "</qas:Layout>" : "<qas:Layout/>";
            str4 = search != null ? "<qas:Search>" + search + "</qas:Search>" : "<qas:Search/>";
            request.append("    <qas:QASearch xmlns:qas=").append(paramString).append(">\r\n      ").append(str1)
                    .append("\r\n      ").append(str2).append("\r\n      ").append(str3).append("\r\n      ")
                    .append(str4).append("\r\n    </qas:QASearch>\r\n");
        } catch (Exception ex) {
            _logger.debug("getXMLDoc-Cann't build Reqeust XML:" + ex.getMessage());
        }
        return request.toString();
    }

    public String getXMLDocRefine(String moniker, String refinement, String layout, String paramString) {

        StringBuilder request = new StringBuilder();
        String strMoniker = "";
        String strRefinement = "";
        String strLayout = "";
        try {
            strMoniker = moniker != null ? "<qas:Moniker>" + moniker + "</qas:Moniker>" : "<qas:Moniker/>";
            strRefinement = refinement != null ? "<qas:Refinement>" + refinement + "</qas:Refinement>"
                    : "<qas:Refinement/>";
            strLayout = layout != null ? "<qas:Layout>" + layout + "</qas:Layout>" : "<qas:Layout/>";
            request.append("    <qas:QARefine xmlns:qas=").append(paramString).append(">\r\n      ").append(strMoniker)
                    .append("\r\n      ").append(strRefinement).append("\r\n      ").append(strLayout)
                    .append("\r\n    </qas:QARefine>\r\n");
        } catch (Exception ex) {
            _logger.debug("Cann't build Reqeust XML:" + ex.getMessage());
        }

        return request.toString();
    }

    //Begin BZ25358
    public String parseDoSearch(CawQASearchResult params) {

        StringBuilder sb = new StringBuilder();
        if (params != null) {
            if (params.getVerifyLevel().equals(CawVerifyLevelType.INTERACTION_REQUIRED)
                    || params.getVerifyLevel().equals(CawVerifyLevelType.VERIFIED)) {
                sb.append("");
                sb.append("<?xml version=\"1.0\"?>\r\n<soap:Envelope xmlns:soap=\"http://schemas.xmlsoap.org/soap/envelope/\">\r\n ");
                sb.append("  <soap:Header>\r\n    <QAInformation xmlns=\"http://www.qas.com/OnDemand-2011-03\">\r\n     <StateTransition>SearchResults</StateTransition>\r\n     <CreditsUsed>1</CreditsUsed>\r\n    </QAInformation>\r\n</soap:Header>\r\n <soap:Body>\r\n");
                sb.append("<QASearchResult xmlns=\"http://www.qas.com/OnDemand-2011-03\" VerifyLevel=\""
                        + params.getVerifyLevel() + "\">\r\n");
                sb.append("  <QAAddress DPVStatus=\"" + params.getQAAddress().getDPVStatus() + "\">\r\n");
                List<CawAddressLineType> addressLines = params.getQAAddress().getAddressLine();
                for (CawAddressLineType line : addressLines) {
                    sb.append("   <AddressLine LineContent=\"" + line.getLineContent() + "\">\r\n");
                    sb.append("     <Label>" + line.getLabel() + "</Label>\r\n");
                    sb.append("     <Line>" + line.getLine() + "</Line>\r\n");
                    sb.append("   </AddressLine>\r\n");
                }
                if (!params.getVerifyLevel().equals(CawVerifyLevelType.VERIFIED)) {
                    if (params.getVerificationFlags() != null) {
                        sb.append("    <StreetCorrected>" + params.getVerificationFlags().isStreetCorrected()
                                + "</StreetCorrected>\r\n");
                        sb.append("    <CityNameChanged>" + params.getVerificationFlags().isCityNameChanged()
                                + "</CityNameChanged>\r\n");
                        sb.append("    <StateProvinceChanged>" + params.getVerificationFlags().isStateProvinceChanged()
                                + "</StateProvinceChanged>\r\n");
                        sb.append("    <PostCodeCorrected>" + params.getVerificationFlags().isPostCodeCorrected()
                                + "</PostCodeCorrected>\r\n");
                    } else {
                        sb.append("</StreetCorrected>\r\n");
                        sb.append("</CityNameChanged>\r\n");
                        sb.append("</StateProvinceChanged>\r\n");
                        sb.append("</PostCodeCorrected>\r\n");
                    }

                }

                sb.append("</QASearchResult>\r\n");
                sb.append("</soap:Body>\r\n" + "</soap:Envelope>\r\n");
            } else if (params.getVerifyLevel().equals(CawVerifyLevelType.PREMISES_PARTIAL)) {
                sb.append("");
                sb.append("<?xml version=\"1.0\"?>\r\n<soap:Envelope xmlns:soap=\"http://schemas.xmlsoap.org/soap/envelope/\">\r\n ");
                sb.append("  <soap:Header>\r\n    <QAInformation xmlns=\"http://www.qas.com/OnDemand-2011-03\">\r\n     <StateTransition>PickList</StateTransition>\r\n     <CreditsUsed>0</CreditsUsed>\r\n    </QAInformation>\r\n</soap:Header>\r\n <soap:Body>\r\n");
                sb.append("<QASearchResult xmlns=\"http://www.qas.com/OnDemand-2011-03\" VerifyLevel=\""
                        + params.getVerifyLevel() + "\">\r\n");
                sb.append("  <QAPicklist MoreOtherMatches=\"" + params.getQAPicklist().isMoreOtherMatches()
                        + "\" OverThreshold=\"" + params.getQAPicklist().isOverThreshold() + "\">\r\n");
                sb.append("    <FullPicklistMoniker> " + params.getQAPicklist().getFullPicklistMoniker()
                        + "</FullPicklistMoniker>\r\n ");
                for (CawPicklistEntryType entry : params.getQAPicklist().getPicklistEntry()) {
                    if (getUnresolvableRange(entry)) {
                        sb.append("      <PicklistEntry Multiples=\"true\" UnresolvableRange=\"true\">\r\n");
                    } else {
                        sb.append("      <PicklistEntry FullAddress=\"true\">\r\n");
                    }
                    sb.append("       <Moniker>");
                    sb.append(entry.getMoniker());
                    sb.append("</Moniker>\r\n");

                    sb.append("       <PartialAddress>");
                    sb.append(entry.getPartialAddress());
                    sb.append("</PartialAddress>\r\n");

                    sb.append("        <Picklist>");
                    sb.append(entry.getPicklist());
                    sb.append("</Picklist>\r\n");

                    sb.append("        <Postcode>");
                    sb.append(entry.getPostcode());
                    sb.append("</Postcode>\r\n");

                    sb.append("        <Score>");
                    sb.append(entry.getScore());
                    sb.append("</Score>\r\n");

                    sb.append("      </PicklistEntry>\r\n");
                }
                sb.append("     <Prompt>Please confirm your Apt/Ste/Unit Number</Prompt>\r\n");
                sb.append("     <Total>" + params.getQAPicklist().getPicklistEntry().size() + "</Total>\r\n");
                sb.append("  </QAPicklist>\r\n");
                sb.append("  <VerificationFlags>\r\n");
                if (params.getVerificationFlags() != null) {
                    sb.append("    <StreetCorrected>" + params.getVerificationFlags().isStreetCorrected()
                            + "</StreetCorrected>\r\n");
                    sb.append("    <CityNameChanged>" + params.getVerificationFlags().isCityNameChanged()
                            + "</CityNameChanged>\r\n");
                    sb.append("    <StateProvinceChanged>" + params.getVerificationFlags().isStateProvinceChanged()
                            + "</StateProvinceChanged>\r\n");
                    sb.append("    <PostCodeCorrected>" + params.getVerificationFlags().isPostCodeCorrected()
                            + "</PostCodeCorrected>\r\n");
                } else {
                    sb.append("</StreetCorrected>\r\n");
                    sb.append("</CityNameChanged>\r\n");
                    sb.append("</StateProvinceChanged>\r\n");
                    sb.append("</PostCodeCorrected>\r\n");
                }
                sb.append("  </VerificationFlags>\r\n");
                sb.append("</QASearchResult>\r\n");
                sb.append("</soap:Body>\r\n" + "</soap:Envelope>\r\n");

            } else if (params.getVerifyLevel().equals(CawVerifyLevelType.MULTIPLE)) {
                sb.append("");
                sb.append("<?xml version=\"1.0\"?>\r\n<soap:Envelope xmlns:soap=\"http://schemas.xmlsoap.org/soap/envelope/\">\r\n ");
                sb.append("  <soap:Header>\r\n    <QAInformation xmlns=\"http://www.qas.com/OnDemand-2011-03\">\r\n     <StateTransition>PickList</StateTransition>\r\n     <CreditsUsed>0</CreditsUsed>\r\n    </QAInformation>\r\n</soap:Header>\r\n <soap:Body>\r\n");
                sb.append("<QASearchResult xmlns=\"http://www.qas.com/OnDemand-2011-03\" VerifyLevel=\""
                        + params.getVerifyLevel() + "\">\r\n");
                sb.append("  <QAPicklist MoreOtherMatches=\"" + params.getQAPicklist().isMoreOtherMatches()
                        + "\" OverThreshold=\"" + params.getQAPicklist().isOverThreshold() + "\">\r\n");
                sb.append("    <FullPicklistMoniker> " + params.getQAPicklist().getFullPicklistMoniker()
                        + "</FullPicklistMoniker>\r\n ");
                for (CawPicklistEntryType entry : params.getQAPicklist().getPicklistEntry()) {
                    sb.append("      <PicklistEntry FullAddress=\"true\">\r\n");
                    sb.append("       <Moniker>");
                    sb.append(entry.getMoniker());
                    sb.append("</Moniker>\r\n");

                    sb.append("       <PartialAddress>");
                    sb.append(entry.getPartialAddress());
                    sb.append("</PartialAddress>\r\n");

                    sb.append("        <Picklist>");
                    sb.append(entry.getPicklist());
                    sb.append("</Picklist>\r\n");

                    sb.append("        <Postcode>");
                    sb.append(entry.getPostcode());
                    sb.append("</Postcode>\r\n");

                    sb.append("        <Score>");
                    sb.append(entry.getScore());
                    sb.append("</Score>\r\n");

                    sb.append("      </PicklistEntry>\r\n");
                }
                sb.append("     <Prompt>Please choose from the options below</Prompt>\r\n");
                sb.append("     <Total>" + params.getQAPicklist().getPicklistEntry().size() + "</Total>\r\n");
                sb.append("  <PotentialMatches>" + params.getQAPicklist().getPotentialMatches()
                        + "</PotentialMatches>\r\n");
                sb.append("  </QAPicklist>\r\n");
                sb.append("  <VerificationFlags>\r\n");
                if (params.getVerificationFlags() != null) {
                    sb.append("    <StreetCorrected>" + params.getVerificationFlags().isStreetCorrected()
                            + "</StreetCorrected>\r\n");
                    sb.append("    <CityNameChanged>" + params.getVerificationFlags().isCityNameChanged()
                            + "</CityNameChanged>\r\n");
                    sb.append("    <StateProvinceChanged>" + params.getVerificationFlags().isStateProvinceChanged()
                            + "</StateProvinceChanged>\r\n");
                    sb.append("    <PostCodeCorrected>" + params.getVerificationFlags().isPostCodeCorrected()
                            + "</PostCodeCorrected>\r\n");
                } else {
                    sb.append("</StreetCorrected>\r\n");
                    sb.append("</CityNameChanged>\r\n");
                    sb.append("</StateProvinceChanged>\r\n");
                    sb.append("</PostCodeCorrected>\r\n");
                }
                sb.append("  </VerificationFlags>\r\n");
                sb.append("</QASearchResult>\r\n");
                sb.append("</soap:Body>\r\n" + "</soap:Envelope>\r\n");
            }
        } //end params
        return sb.toString();
    }

    //End BZ25358
    public String parseRefine(CawPicklist params) {

        StringBuilder sb = new StringBuilder();
        if (params != null) {
            sb.append("");
            sb.append("<?xml version=\"1.0\"?>\r\n<soap:Envelope xmlns:soap=\"http://schemas.xmlsoap.org/soap/envelope/\">\r\n ");
            sb.append("  <soap:Header>\r\n    <QAInformation xmlns=\"http://www.qas.com/OnDemand-2011-03\">\r\n     <StateTransition>Unknown</StateTransition>\r\n     <CreditsUsed>0</CreditsUsed>\r\n    </QAInformation>\r\n</soap:Header>\r\n <soap:Body>\r\n");
            sb.append("<Picklist xmlns=\"http://www.qas.com/OnDemand-2011-03\">\r\n");
            sb.append("  <QAPicklist>\r\n");
            if (params.getQAPicklist() != null) {
                sb.append("    <FullPicklistMoniker> " + params.getQAPicklist().getFullPicklistMoniker()
                        + "</FullPicklistMoniker>\r\n ");
            } else {
                sb.append("</FullPicklistMoniker>\r\n ");
            }

            for (CawPicklistEntryType entry : params.getQAPicklist().getPicklistEntry()) {
                if (getUnresolvableRange(entry)) {
                    sb.append("      <PicklistEntry Multiples=\"true\" UnresolvableRange=\"true\">\r\n");
                } else {
                    sb.append("      <PicklistEntry FullAddress=\"true\">\r\n");
                }
                sb.append("       <Moniker>");
                sb.append(entry.getMoniker());
                sb.append("</Moniker>\r\n");

                sb.append("       <PartialAddress>");
                sb.append(entry.getPartialAddress());
                sb.append("</PartialAddress>\r\n");

                sb.append("        <Picklist>");
                sb.append(entry.getPicklist());
                sb.append("</Picklist>\r\n");

                sb.append("        <Postcode>");
                sb.append(entry.getPostcode());
                sb.append("</Postcode>\r\n");

                sb.append("        <Score>");
                sb.append(entry.getScore());
                sb.append("</Score>\r\n");

                sb.append("      </PicklistEntry>\r\n");
            }

            sb.append("     <Prompt>Enter selection</Prompt>\r\n");
            if (params.getQAPicklist() != null) {
                sb.append("     <Total>" + params.getQAPicklist().getPicklistEntry().size() + "</Total>\r\n");
            } else {
                sb.append("</Total>\r\n");
            }

            sb.append("  </QAPicklist>\r\n");
            sb.append("</Picklist>\r\n");
            sb.append("</soap:Body>\r\n" + "</soap:Envelope>\r\n");
        } //End if params
        return sb.toString();
    }

    protected boolean getUnresolvableRange(CawPicklistEntryType argEntry) {

        boolean unresolvableRange = false;
        if (argEntry.isUnresolvableRange()) {
            unresolvableRange = true;
        } else if (argEntry.getPicklist().contains(" ... ")) {
            unresolvableRange = true;
        }
        return unresolvableRange;
    }
}
