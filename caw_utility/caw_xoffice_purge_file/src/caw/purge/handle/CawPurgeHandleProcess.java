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
package caw.purge.handle;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;

import caw.pugre.utility.CawPropertiesUtility;
import caw.pugre.utility.CawPurgeConstant;
import caw.pugre.utility.CawPurgeFileUtility;
import caw.pugre.utility.CawPurgeHttpServiceUtility;
import caw.pugre.utility.CawPurgeUtils;
import caw.purge.entity.CawPurgeDeploymentFile;

/**
 * This class handles the purge process
 *
 */
public class CawPurgeHandleProcess {

	final static Logger logger = Logger.getLogger(CawPurgeHandleProcess.class);

	/**
	 * The method purge files in folder xadmin-deployment.
	 * The folder xadmin-deployment get from configuration "directory.xadmin.deployment" in file config.properties
	 */
	public void purgreUpoadFiles() {
		CawPurgeService cawPurgeJdbcService = new CawPurgeService();

		/**
		 * Get the path of folder to contain files upload.
		 * Example: /u01/xadmin-deployment/
		 */
		String uploadDirectory = cawPurgeJdbcService.getPathFolderUploadFiles();
		if (uploadDirectory != null) {
			List<String> fileNameList = cawPurgeJdbcService.getUploadFileFromDB();
			if (fileNameList != null && fileNameList.size() > 0) {
				for (String fileName : fileNameList) {
					CawPurgeFileUtility.getInstance().deleteFile(uploadDirectory, fileName);
				}
				cawPurgeJdbcService.deleteUploadInDB(fileNameList);
			}
		}
	}

	/**
	 * Purge process of archived data files
	 */
	public void purgeArchivedFiles() {
		CawPurgeService cawPurgeJdbcService = new CawPurgeService();
		cawPurgeJdbcService.purgeArchivedDataFiles();
	}

	/**
	 * The method purge file in folder Apache Upload
	 */
	public void purgeDeploymentFiles() {
		CawPurgeService cawPurgeJdbcService = new CawPurgeService();

		List<CawPurgeDeploymentFile> deploymentFileList = cawPurgeJdbcService.getDeploymentFileFromDB();

		if (deploymentFileList != null && deploymentFileList.size() > 0) {
			String deploySameServer = CawPropertiesUtility.getInstance().getValuByKey(
					CawPurgeConstant.FILEPURGER_DEPLOYMENT_WEBDAV_ENABLE,
					CawPurgeConstant.FILEPURGER_DEPLOYMENT_WEBDAV_ENABLE);
			boolean isDeploySameServer = CawPurgeUtils.getInstance().vBoolean(deploySameServer);

			if (!isDeploySameServer) {
				String deploymentDirectory = cawPurgeJdbcService.getDeploymentDirectory();
				if (StringUtils.isNotEmpty(deploymentDirectory)) {
					for (CawPurgeDeploymentFile cawPurgeDeploymentFile : deploymentFileList) {
						CawPurgeFileUtility.getInstance().deleteFile(deploymentDirectory,
								cawPurgeDeploymentFile.getDeploymentName());
					}
					
				} else {
					logger.error("Can not found the path '" + deploymentDirectory +"' on server.");
				}
			} else {
				boolean deleteSuccessful = true;
				List<CawPurgeDeploymentFile> ignoreDeploymentFile = new ArrayList<CawPurgeDeploymentFile>();
				for (CawPurgeDeploymentFile cawPurgeDeploymentFile : deploymentFileList) {
					deleteSuccessful = CawPurgeHttpServiceUtility.getInstance().deleteFile(cawPurgeDeploymentFile.getDeploymentName());
					if (!deleteSuccessful) {
						ignoreDeploymentFile.add(cawPurgeDeploymentFile);
					}
				}
				
				if (ignoreDeploymentFile.size() > 0) {
					deploymentFileList.removeAll(ignoreDeploymentFile);
				}
			}
			cawPurgeJdbcService.deleteDeploymentFileInDB(deploymentFileList);
		}
	}
}
