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
 * BZ25614              140318    [Order Service] Order Service code review
 *== ================================================================
 */

package caw.orderservice.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import org.apache.log4j.Logger;

/**
 * Define methods to load *.properties files 
 * to used as system or application variables
 */
public class CawPropertiesLoader {

    static final Logger logger     = Logger
            .getLogger(CawPropertiesLoader.class);

    static Properties   propLoader = new Properties();

    static {
        loadAllProperties();
    }

    /**
     * Load config files
     */
    private static void loadAllProperties() {

        loadConfigXmlMapping();
        loadConfigProperties();
    }

    /**
     * Reload config files
     */
    protected static void reloadAllProperties() {

        propLoader.clear();
        loadAllProperties();
    }

    /**
     * read orderservice-config.xml
     * @param filePath
     * @return
     */
    private static void loadConfigXmlMapping() {

        File file = null;
        FileInputStream fileInput = null;
        try {
            String filePath = CawPropertiesConfig.getConfigXMLMappingPath();
            file = new File(filePath);
            fileInput = new FileInputStream(file);
            propLoader.loadFromXML(fileInput);
        } catch (FileNotFoundException e) {
            logger.error("Can not find config.xml " + e.getMessage());
        } catch (IOException e) {
            logger.error("Can not get config.xml " + e.getMessage());
        } finally {
            try {
                if (fileInput != null) {
                    fileInput.close();
                }
            } catch (IOException e) {
                logger.error("Errors " + e.getMessage());
            }
        }
    }

    /**
     * read config.properties file
     * @return
     */
    private static void loadConfigProperties() {

        InputStream input = null;
        try {
            input = new FileInputStream(
                    CawPropertiesConfig.getConfigPropertiesPath());
            propLoader.load(input);
        } catch (Exception e) {
            logger.error("Can not get config.properties " + e.getMessage());
        } finally {
            try {
                if (input != null) {
                    input.close();
                }
            } catch (IOException e) {
                logger.error("Errors " + e.getMessage());
            }
        }
    }

    /**
     * Get value for key from propLoader
     * 
     * @param key
     *            to get the value
     * @return a String that is a value of key in hash map. Return NULL if the
     *         key is not exist in hash map
     */
    public static String getProperty(String key) {

        String value = null;
        try {
            if (key != null && key.length() > 0
                    && propLoader.containsKey(key)) {
                value = propLoader.getProperty(key);
            } else {
                logger.warn("Not define value for " + key);
            }
        } catch (RuntimeException e) {
            logger.error("Error in getProperty: " + e.getMessage());
        } catch (Exception e) {
            logger.error("Not define value for " + key);
        }
        return CawUtils.getInstance().vString(value);
    }

    /**
     * Check configProperties is empty or not
     * 
     * @return
     */
    public static boolean hasProperties() {

        return !propLoader.isEmpty();
    }
}