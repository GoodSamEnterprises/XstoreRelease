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
package caw.purge.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;

import org.apache.log4j.Logger;

import caw.pugre.utility.CawPropertiesUtility;
import caw.pugre.utility.CawPurgeConstant;
import caw.pugre.utility.CawPurgeEncryptionUtility;

public class CawPurgeJdbcHelper {
	final static Logger logger = Logger.getLogger(CawPurgeJdbcHelper.class);
	private static volatile CawPurgeJdbcHelper INSTANCE = null;
	public static CawPurgeJdbcHelper getInstance() {

		if (INSTANCE == null) {
			synchronized (CawPurgeJdbcHelper.class) {
				if (INSTANCE == null) {
					INSTANCE = new CawPurgeJdbcHelper();
				}
			}
		}
		return INSTANCE;
	}

	/**
	 * The method get connection to Xcenter/Xadmin database.
	 * @return the connection.
	 */
	public Connection getConnectionToXcenterDB() {
		Connection conn = null;
		try {
			String connectionURL = CawPropertiesUtility.getInstance().getValuByKey(CawPurgeConstant.DB_XCENTER_CONNECTION_URL);
			String dbUserName = CawPropertiesUtility.getInstance().getValuByKey(CawPurgeConstant.DB_XCENTER_USERNAMER);
			String dbPassword = CawPropertiesUtility.getInstance().getValuByKey(CawPurgeConstant.DB_XCENTER_PASSWORD);
			if (connectionURL != null && dbUserName != null && dbPassword != null) {
				if (dbUserName.indexOf(CawPurgeConstant.EXCLAMATION_MARK) == 0) {
					dbUserName = dbUserName.substring(1);
					String dbUserNameEncrypt = CawPurgeEncryptionUtility.getInstance().encrypt(dbUserName);
					if (dbUserNameEncrypt != null) {
						CawPropertiesUtility.getInstance().updateProperty(CawPurgeConstant.DB_XCENTER_USERNAMER, dbUserNameEncrypt);
						CawPropertiesUtility.getInstance().reloadPropertiseInMemnory();
					}
				} else {
					dbUserName = CawPurgeEncryptionUtility.getInstance().decrypt(dbUserName);
				}
				
				if (dbPassword.indexOf(CawPurgeConstant.EXCLAMATION_MARK) == 0) {
					dbPassword = dbPassword.substring(1);
					String dbPasswordEncrypt = CawPurgeEncryptionUtility.getInstance().encrypt(dbPassword);
					if (dbPasswordEncrypt != null) {
						CawPropertiesUtility.getInstance().updateProperty(CawPurgeConstant.DB_XCENTER_PASSWORD, dbPasswordEncrypt);
						CawPropertiesUtility.getInstance().reloadPropertiseInMemnory();
					}
				} else {
					dbPassword = CawPurgeEncryptionUtility.getInstance().decrypt(dbPassword);
				}
				
				conn = DriverManager.getConnection(connectionURL, dbUserName, dbPassword);
			} else {
				logger.info("The database information is empty. Please input the information necessary to connect database.");
			}
			
		} catch (Exception e) {
			logger.info("Failed to make connection to database!", e);
		}

		return conn;
	}
}