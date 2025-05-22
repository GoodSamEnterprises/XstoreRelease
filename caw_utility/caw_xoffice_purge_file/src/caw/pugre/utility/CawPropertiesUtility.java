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
 * BZ35616              210320    Purge Xadmin deployments based on date 
 *===================================================================
 */
package caw.pugre.utility;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Properties;

import org.apache.commons.configuration.PropertiesConfiguration;
import org.apache.commons.configuration.PropertiesConfigurationLayout;
import org.apache.commons.lang.StringUtils;
import org.apache.log4j.PropertyConfigurator;

public class CawPropertiesUtility {
	private static Properties properties;
	private static final String USER_DIR             = "user.dir";
	private static final String CONFIG_PROPERTIES    = "/config.properties";

	private static volatile CawPropertiesUtility INSTANCE = null;

	public static CawPropertiesUtility getInstance() {

		if (INSTANCE == null) {
			synchronized (CawPropertiesUtility.class) {
				if (INSTANCE == null) {
					INSTANCE = new CawPropertiesUtility();
				}
			}
		}
		return INSTANCE;
	}

	public CawPropertiesUtility() {
		loadconfig();
	}
	/**
	 * The method load content from file config.properties to properties variable.
	 */
	public void loadconfig() {
		if (properties == null) {
			try {
				String path = System.getProperty(USER_DIR);
				if (path != null && path.length() > 0) {
					InputStream input = new FileInputStream(path + CONFIG_PROPERTIES);
					properties = new Properties();
					properties.load(input);
					input.close();
				}
			} catch (Exception e) {
				System.out.println("Load file config.properties failed." + e.getMessage());
			}
		}
	}
	
	public void updateProperty(String key, String value) {
		try {
			if (StringUtils.isNotEmpty(key) && StringUtils.isNotEmpty(key)) {
				String path = System.getProperty(USER_DIR);
				if (path != null && path.length() > 0) {
					File file = new File(path + CONFIG_PROPERTIES);
					PropertiesConfiguration config = new PropertiesConfiguration();
					PropertiesConfigurationLayout layout = new PropertiesConfigurationLayout(config);
					layout.load(new InputStreamReader(new FileInputStream(file)));

					config.setProperty(key, value);
					layout.save(new FileWriter(path + CONFIG_PROPERTIES, false));
				}
			}
		} catch (Exception e) {
			System.out.println("Update property failed." + e.getMessage());
		}
	}
	

	/**
	 * Load file log4j.properties from configuration key "log4j.configure.file" in
	 * file config.properties.
	 */
	public void loadLog4jConfiguration() {
		try {
			String log4jConfigureFile = properties.getProperty(CawPurgeConstant.LOG4J_CONFIGURE_FILE);
			if (StringUtils.isNotEmpty(log4jConfigureFile)) {
				File configFile = new File(log4jConfigureFile);
				if (configFile.exists()) {
					PropertyConfigurator.configure(log4jConfigureFile);
				}
			}
		} catch (Exception e) {
			System.out.println("Load file log4j.properties failed." + e.getMessage());
		}
	}

	
	/**
	 * Return the value of configuration by key.
	 * @param key
	 * @return
	 */
	public String getValuByKey(String key) {
		String value = null;
		try {
			value = properties.getProperty(key);
		} catch (Exception e) {
			System.out.println("Load configuration from key='"+key+"' failed." + e.getMessage());
		}
		
		return value;
	}
	
	/**
	 * The method get configuration in file config.properties. 
	 * If the you are not set value in in file config.properties. This method will return default value.
	 * @param key
	 * @param defaultValue
	 * @return
	 */
	public String getValuByKey(String key, String defaultValue) {
		String value = defaultValue;
		try {
			if (StringUtils.isNotEmpty(properties.getProperty(key))) {
				value = properties.getProperty(key);
			}
		} catch (Exception e) {
			System.out.println("Method Load configuration from key='"+key+"' failed." + e.getMessage());
		}
		
		return value;
	}

	

	/**
	 * @param iNSTANCE the iNSTANCE to set
	 */
	public void reloadPropertiseInMemnory() {
		INSTANCE = null;
		properties = null;
	}
}
