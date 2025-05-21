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
 * Req/Bug ID#      ddMMyy    Description
 * 
 *===================================================================
 */

package caw.orderservice.bean;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;

import caw.orderservice.rest.CawOrderServiceRestUtils;

/**
 *
 */
public class CawUnitTest {

    //private static final Logger logger = Logger.getLogger(CawUnitTest.class);

    public static void main(String[] args) {
        String argEncryptionService="ccenc";
        String value= "";
        
        /*String res= DtvDecrypter.getInstance(argEncryptionService)
        .decryptIfEncrypted(value);
        
        System.out.println("TEST: "+ res);
        
        try {
          String tmp = argEncryptionService
                  .replace("ce",  "\"" + value + "\""); 
          
          System.out.println("TEST: "+ tmp);
        }catch (Exception e) {
            System.out.println("errr: "+ e.getMessage());
        }*/

        /*String source = "Transaction Fails";
        value = null;
        for (int i=0; i <3 ; i++) {
            value = String.valueOf(source);
            //value = source;
            System.out.println("value1: "+value);
            value = value.replace("a", "TEST");
            System.out.println("value2: "+value);
        }
        System.out.println("source: "+source);*/

        try {
            value = null;
            argEncryptionService = argEncryptionService.replace("cc", value);
        } catch (Exception e) {
            System.out.println("error: "+e.getMessage());
        }
        
        
        
        /*try {
            CawTransactionModel model = new CawTransactionModel();
           if (model != null) {
               System.out.println("go1: "+ model.getTender().hashCode());
               System.out.println("--------------");
               System.out.println("go2: "+ model.getTender().getExpireDate());
           }
        } catch (Exception e) {
            System.out.println("error: "+e.getMessage());
        }*/

        /*InputStream stream = null;
        BufferedReader br = null;
        StringBuilder sb = new StringBuilder();
        String line = null;
        try {
            System.out.println("start: ");
            ClassLoader iclass = CawOrderServiceUtils.class.getClassLoader();
            stream = iclass
                    .getResourceAsStream("C://xoffice//TendersTemplate.txt");
            logger.debug(stream);
            System.out.println(stream);
            br = new BufferedReader(new InputStreamReader(stream));
            while ((line = br.readLine()) != null) {
                sb.append(line).append(CawCommonConstant.NEW_LINE);
            }
            System.out.println("done: " + sb.toString());
        } catch (Exception e) {
            System.out.println("error: " + e.getMessage());
        }
        
        
        try {
            System.out.println("start: ");
            lookUpCustomer("");
        } catch (Exception e) {
            System.out.println("errorN: " + e.getMessage());
        }*/
          
        
    }
    
    
    public static String lookUpCustomer(String accountNumber) {

        String urlAPI = "https://ky-esb-i-stg-01.freedomroads.local:44501/CAMPINGWORLD/customer";
        String neuronUser = "XSTORE-DEV";
        String neuronKey = "yQBe53ng(K79j4[n";
        String locationCode = "0001";
        HttpHeaders httpHeaders = CawOrderServiceRestUtils
                .createHttpHeader(MediaType.APPLICATION_JSON, neuronUser, neuronKey);
        HttpEntity<String> entity = new HttpEntity<String>(httpHeaders);

        String customerLookupUrl = urlAPI + "?accountNumber=" + accountNumber
                + "&locationCode=" + locationCode;
        ResponseEntity<String> customerTemplate = CawOrderServiceRestUtils
                .callServiceAPIResponseEntity(customerLookupUrl, HttpMethod.GET, entity);

        return customerTemplate.getBody();
        
        
    }
}
