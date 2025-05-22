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
 * BZ35616              210320    Purge Xadmin deployments based on date.
 * BZ36145              140520    [Prod] Xadmin Purge 
 *===================================================================
 */
package caw.purge.app;

import org.apache.log4j.Logger;

import caw.pugre.utility.CawPropertiesUtility;
import caw.pugre.utility.CawPurgeConstant;
import caw.pugre.utility.CawPurgeUtils;
import caw.purge.handle.CawPurgeHandleProcess;

public class CawAppPurgeFile {
	final static Logger logger = Logger.getLogger(CawAppPurgeFile.class);

	/** Load the configuration */
	static {
		// Load file config.properties
		CawPropertiesUtility.getInstance().loadconfig();
		// Load the log configuration file.
		CawPropertiesUtility.getInstance().loadLog4jConfiguration();
	}

	public static void main(String[] args) {
		logger.info("START THE PURGE FILE NOW.");
		
		CawPurgeHandleProcess cawPurgeHandleProcess = new CawPurgeHandleProcess();
		/** Step 1: Purge files in xadmin-deployment folder */
		String filepurgerUploadEnable = CawPropertiesUtility.getInstance().getValuByKey(
				CawPurgeConstant.FILEPURGER_UPLOAD_ENABLE, CawPurgeConstant.FILEPURGER_UPLOAD_ENABLE_DEFAULT);
		if (CawPurgeUtils.getInstance().vBoolean(filepurgerUploadEnable)) {
			logger.info("============= BEGIN FUNCTION TO PURGE UPLOAD FILES===================");
			cawPurgeHandleProcess.purgreUpoadFiles();
			logger.info("============= END FUNCTION TO PURGE UPLOAD FILES===================");
		}
		
		/* BEGIN BZ36145 */
		/** Step 2: Purge files in /u01/xadmin-deployment/auto/org1000/archive folder */
		String filepurgerUploadArchiveEnable = CawPropertiesUtility.getInstance().getValuByKey(
				CawPurgeConstant.FILEPURGER_ARCHIVE_FILE_ENABLE, CawPurgeConstant.FILEPURGER_ARCHIVE_FILE_ENABLE_DEFAULT);
		if (CawPurgeUtils.getInstance().vBoolean(filepurgerUploadArchiveEnable)) {
			logger.info("============= BEGIN FUNCTION TO PURGE ARCHIVE FILES===================");
			cawPurgeHandleProcess.purgeArchivedFiles();
			logger.info("============= END FUNCTION TO PURGE ARCHIVE FILES===================");
		}
		/* END BZ36145 */
		
		/** Step 3: Purge files in apache uploads folder */
		String filepurgerDeploymentEnable = CawPropertiesUtility.getInstance().getValuByKey(
				CawPurgeConstant.FILEPURGER_DEPLOYMENT_ENABLE, CawPurgeConstant.FILEPURGER_DEPLOYMENT_ENABLE_DEFAULT);
		if (CawPurgeUtils.getInstance().vBoolean(filepurgerDeploymentEnable)) {
			logger.info("============= BEGIN FUNCTION TO PURGE DEPLOYMENT FILES ===================");
			cawPurgeHandleProcess.purgeDeploymentFiles();
			logger.info("============= END FUNCTION TO PURGE DEPLOYMENT FILES ===================");
		}
		
		logger.info("END THE PURGE FILE.");
	}
}
