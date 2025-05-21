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
 * Req/Bug ID#          ddMMyy    Description
 * INT-92               260817    Customer Integration
 * BZ23147              070917    Implement Serialized coupon
 * BZ23052              120917    Implement Advanced Prompting
 * BZ23478              200917    [Prompting] Update Catalyst = 1 request
 * BZ23596              270917    'Make offer' request doesn't send to EBS when selecting 'NO' on Pre-screen
 * BZ23637              280917    [Prompting Engine] - Changes required to keep the customer from being prompted multiple times for GSC membership
 * BZ23440              091017    Xstore should be displayed message to indicate the system is offline when performing transaction tender by Coupon in offline case
 * BZ23440              111017    Xstore should be displayed message to indicate the system is offline when performing transaction tender by Coupon in offline case
 * BZ23976              121017    Need to send the ADS result to CareTaker after the credit application completes
 * BZ24019              161017    [Technical issue] - Empty method
 * BZ23958              251017    Xstore needs to prompt for membership # when customer joins
 * BZ24349              021117    Should be removed out the trigger only inputting number for membership# when joining new club
 * BZ24435              11917     Response is:400 Cannot authenticate user: 'XSTORE-DEV'
 * BZ24556              201117    [Payments][Build 1.1.3] Help Desk Error displays when you select Yes for Good Sam Prescreen
 * BZ26323              220518    [24561] Should be displayed message to indicate EBS is offlined when doing AR/Third-party tender in offline cases
 * BZ25640              051518    New Requirement - Used Firearm System Process Redesign
 * BZ26398              310518    Club pricing is displayed on top banner once adding RA join item for transaction in offline case.
 * BZ26575              140618    [QAS] Update address verification flow to reduce the number of click in the QAS process
 * BZ48401              210222    [Task] Apply Reward to Redeem in Sales Transaction  
 * BZ50761              280622    403 forbidden error for POS Loyalty Kong Service
 *===================================================================
 */

package caw.pos.util;

import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.*;

import javax.net.ssl.*;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.http.*;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.web.client.*;

import caw.pos.common.CawEBSConstant;
import twitter4j.JSONObject;

/**
 *
 */
public class CawRestClientUtil {

    private static final Logger _logger         = LogManager
            .getLogger(CawRestClientUtil.class);

    private static final String STR_NEURON_USER = "XX-NEURON-USER";

    private static final String STR_NEURON_KEY  = "XX-NEURON-KEY";

    private static final String CUSTOMER        = "customer";

    private static final String MESSAGE         = "message";

    private static final String CAN_PURCHASE    = "canPurchase";
    //Start BZ50761
    public static final String  USER_AGENT      = "User-Agent";

    public static final String  APPLICATION     = "Application";
    //End BZ50761
    /**
     * @param url
     * @param httpMethod
     * @param entity
     * @return
     */
    static ResponseEntity<String> callServiceAPIResponseEntity(String url,
            HttpMethod httpMethod, HttpEntity<String> entity) {

        ResponseEntity<String> result = null;
        enableSSL01();
        RestTemplate restTemplate = new RestTemplate();
        try {
            /*BEGIN BZ48401*/
            StringHttpMessageConverter converMsg = new StringHttpMessageConverter(Charset.forName("UTF-8"));
            converMsg.setWriteAcceptCharset(false);
            restTemplate.getMessageConverters().add(0, converMsg);
            /*END BZ48401*/
            //BZ25640 added to log request
            // Begin BZ23052
            result = restTemplate
                    .exchange(url, httpMethod, entity, String.class);
            // End BZ23052
        } catch (Exception ex) {
            _logger.error("Exception after call:" + url + ". Response is:"
                    + ex.getMessage());
            // BEGIN BZ23440
            if (ex instanceof ResourceAccessException) {
                result = new ResponseEntity<String>("",
                        HttpStatus.REQUEST_TIMEOUT);
            }
            // END BZ23440
            //Begin BZ26323
            if (ex instanceof HttpClientErrorException) {
                if (((HttpClientErrorException) ex).getStatusCode()
                        .equals(HttpStatus.BAD_REQUEST)) {
                    result = new ResponseEntity<String>("",
                            HttpStatus.BAD_REQUEST);
                }
            }
            //End BZ26323
        }
        
        return result;
    }

    // Begin BZ24349
    /**
     * @param url
     * @param httpMethod
     * @param entity
     * @return
     */
    static ResponseEntity<String> callMembershipAPIResponseEntity(String url,
            HttpMethod httpMethod, HttpEntity<String> entity) {

        ResponseEntity<String> result = null;
        enableSSL01();
        String msg = null;
        RestTemplate restTemplate = new RestTemplate();
        try {
            result = restTemplate
                    .exchange(url, httpMethod, entity, String.class);
        } catch (Exception ex) {
            _logger.error("Exception after call:" + url + ". Response is:"
                    + ex.getMessage());
            if (ex instanceof HttpClientErrorException) {
                if (((HttpClientErrorException) ex).getRawStatusCode() == 400) {
                    msg = ex.getMessage();
                    if (msg != null && msg.length() > 4) {
                        msg = msg.substring(4, msg.length());
                    }
                }
            }
        }

        if (msg != null) {
            try {
                JSONObject jsonObject = new JSONObject();
                jsonObject.put(CAN_PURCHASE, Boolean.FALSE);
                jsonObject.put(MESSAGE, msg);
                jsonObject.put(CUSTOMER, "");
                result = new ResponseEntity<String>(jsonObject.toString(),
                        HttpStatus.OK);
            } catch (Exception ex) {
                _logger.error("callMembershipAPI-1: " + ex.getMessage());
            }
        }

        return result;
        // End BZ24349
    }

    /**
     * Create HttpHeaders with
     * NEURON_USER, NEURON_KEY
     * @return
     */
    static HttpHeaders createHttpHeader(String neuronUser, String neuronKey) {

        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        headers.setContentType(MediaType.APPLICATION_JSON);
        
        List<Charset> listCharset = new ArrayList<>();
        listCharset.add(StandardCharsets.UTF_8);

        headers.setAcceptCharset(listCharset);
        
        headers.set(STR_NEURON_USER, neuronUser);
        headers.set(STR_NEURON_KEY, neuronKey);
        
        headers.set(USER_AGENT, APPLICATION); //BZ50761
        return headers;
    }

    /**
     * 
     */
    private static void enableSSL01() {

        TrustManager[] trustAllCerts = new TrustManager[] { new X509TrustManager() {

            @Override
            public java.security.cert.X509Certificate[] getAcceptedIssuers() {

                return null;
            }

            @Override
            public void checkClientTrusted(
                    java.security.cert.X509Certificate[] certs,
                    String authType) {

            }

            @Override
            public void checkServerTrusted(
                    java.security.cert.X509Certificate[] certs,
                    String authType) {

            }
        } };

        try {
            SSLContext sc = SSLContext.getInstance(CawEBSConstant.SSL);
            sc.init(null, trustAllCerts, new java.security.SecureRandom());
            HttpsURLConnection
                    .setDefaultSSLSocketFactory(sc.getSocketFactory());
        } catch (Exception e) {
            _logger.error("Cannot enable SSL: " + e.getMessage());
        }
    }
}
