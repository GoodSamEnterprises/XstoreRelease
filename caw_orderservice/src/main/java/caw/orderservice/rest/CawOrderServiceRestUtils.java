/**
 * CONFIDENTIAL AND PROPRIETARY SOURCE CODE. 
 * 
 * Use and distribution of this code is subject to applicable 
 * licenses and the permission of the code owner.  This notice 
 * does not indicate the actual or intended publication of 
 * this source code.
 * 
 * Portions [of the software code and associated documentation] 
 * developed for Camping World are proprietary and confidential 
 * to BTM Global. BTM Global has granted Camping World a perpetual, 
 * non-exclusive, non-sublicensable license to use [the software 
 * code and associated documentation] for its internal business 
 * operations only.
 * 
 * ===== BTM Modification ===========================================
 * Req/Bug ID#          ddMMyy    Description
 * CAW_OrderService     210817    Initial development framework   
 * BZ50761              280622    403 forbidden error for POS Loyalty Kong Service           
 *== ================================================================
 */

package caw.orderservice.rest;

import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;

import org.apache.log4j.Logger;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.web.client.RestTemplate;

public class CawOrderServiceRestUtils {

    private static final Logger logger      = Logger
            .getLogger(CawOrderServiceRestUtils.class);

    public static final String  SSL         = "SSL";

    public static final String  NEURON_KEY  = "XX-NEURON-KEY";

    public static final String  NEURON_USER = "XX-NEURON-USER";
    //Start BZ50761
    public static final String  USER_AGENT  = "User-Agent";

    public static final String  APPLICATION = "Application";
    //End BZ50761
    /**
     * Send request and get response form EBS Server
     * @param url
     * @param httpMethod
     * @param entity
     * @return result
     */
    public static ResponseEntity<String> callServiceAPIResponseEntity(
            String url, HttpMethod httpMethod, HttpEntity<String> entity) {

        enableSSL01();
        RestTemplate restTemplate = new RestTemplate();
        
        StringHttpMessageConverter converMsg = new StringHttpMessageConverter(Charset.forName("UTF-8"));
        converMsg.setWriteAcceptCharset(false);
        restTemplate.getMessageConverters().add(0, converMsg);
        
        ResponseEntity<String> result = restTemplate
                .exchange(url, httpMethod, entity, String.class);
        return result;
    }

    /**
     * Create httpHeader to add to request
     * 
     * @param mediaType
     * @param neuronUser
     * @param neuronKey
     * @return
     */
    public static HttpHeaders createHttpHeader(MediaType mediaType,
            String neuronUser, String neuronKey) {

        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Arrays.asList(mediaType));
        headers.setContentType(mediaType);
        
        List<Charset> listCharset = new ArrayList<>();
        listCharset.add(StandardCharsets.UTF_8);

        headers.setAcceptCharset(listCharset);
        
        headers.set(NEURON_USER, neuronUser);
        headers.set(NEURON_KEY, neuronKey);
        
        headers.set(USER_AGENT, APPLICATION);   //BZ50761
        return headers;
    }

    /**
     * Enable SSL to connect to EBS Server
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
            SSLContext sc = SSLContext.getInstance(SSL);
            sc.init(null, trustAllCerts, new java.security.SecureRandom());
            HttpsURLConnection
                    .setDefaultSSLSocketFactory(sc.getSocketFactory());
        } catch (Exception e) {
            logger.info("Can not enable SSL 01! " + e.getMessage());
        }
    }

}
