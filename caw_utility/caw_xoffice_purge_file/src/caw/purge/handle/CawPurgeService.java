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
package caw.purge.handle;

import java.io.File;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;

import caw.pugre.utility.CawPropertiesUtility;
import caw.pugre.utility.CawPurgeConstant;
import caw.pugre.utility.CawPurgeFileUtility;
import caw.pugre.utility.CawPurgeUtils;
import caw.purge.entity.CawPurgeDeploymentFile;
import caw.purge.jdbc.CawPurgeJdbcHelper;

public class CawPurgeService {
	final static Logger logger = Logger.getLogger(CawPurgeService.class);
	private static final String DEPLOY_STATUS = "DEPLOY_STATUS";
	private static final String DEPLOYMENT_ID = "DEPLOYMENT_ID";
	private static final String FILE_NAME = "FILE_NAME";
	private static final String ORGANIZATION_ID = "ORGANIZATION_ID";
	private static final String NUM_DAY = "{numDay}";
	private static final String NUM_ROWS = "{numRows}";
	private static final String DEPLOY_STATUS_CONDITION = "{deployStatus}";
	private static final String DEPLOY_STATUS_SCHEDULED = "SCHEDULED";
	private static final String DEPLOY_STATUS_IN_PROCESS = "IN_PROCESS";
	private static final String DEPLOY_STATUS_ERROR = "ERROR";
	private static final String DEPLOY_STATUS_CANCELLED = "CANCELLED";
	private static final String DEPLOY_STATUS_COMPLETE = "COMPLETE";
	private static final String PURGE_STATUS = "{purgeStatus}";
	private static final String PURGE_STATUS_SUCCESS = "SUCCESS";
	private static final String ORGANIZATION_ID_VALUE = "{ORGANIZATION_ID}";
	private static final String DEPLOYMENT_ID_VALUE = "{DEPLOYMENT_ID}";
	private static final String DEPLOYMENT_EXCLUDE_TYPE = "{deploymentExcludeType}"; //BZ36145
	
	

	private static final String SELECT_RECORD_OLDER_THAN_DAY = "SELECT name as FILE_NAME FROM cfg_upload_record "
			+ "WHERE ((create_date <= TRUNC(SYSDATE) - {numDay} and update_date is null) "
			+ "or (update_date <= TRUNC(SYSDATE) - {numDay})) order by create_date asc "
			+ "FETCH NEXT {numRows} ROWS ONLY";

	private static final String SELECT_DEPLOYMENT_FILE_OLDER_THAN_DAY = "SELECT dpl.ORGANIZATION_ID, dpl.DEPLOYMENT_ID, (dpl.ORGANIZATION_ID || '_' || dpl.DEPLOYMENT_ID || '_!!_' || dplfile.RELATIVE_PATH) as FILE_NAME, dpl.DEPLOY_STATUS "
			+ "FROM dpl_deployment dpl INNER JOIN dpl_deployment_file dplfile ON dpl.deployment_id = dplfile.deployment_id "
			+ "WHERE dpl.DEPLOY_STATUS IN ({deployStatus}) "
			+ " AND dpl.PURGE_STATUS <> '{purgeStatus}' "
			+ " AND dpl.DEPLOYMENT_TYPE NOT IN ({deploymentExcludeType})" //BZ36145
			+ " AND (( dpl.create_date <= trunc(SYSDATE) - {numDay} AND dpl.update_date IS NULL ) or ( dpl.update_date <= trunc(SYSDATE) -{numDay})) "
			+ " ORDER BY dpl.create_date ASC " + "FETCH NEXT {numRows} ROWS ONLY";

	private static final String UPDATE_DPL_DEPLOYMENT_TABLE = "UPDATE DPL_DEPLOYMENT SET PURGE_STATUS='{purgeStatus}', UPDATE_DATE=TRUNC(SYSDATE) WHERE ORGANIZATION_ID= {ORGANIZATION_ID} and DEPLOYMENT_ID= {DEPLOYMENT_ID}";
	private static final String UPDATE_DPL_DEPLOYMENT_FILE_TABLE = "UPDATE DPL_DEPLOYMENT_FILE SET PURGE_STATUS='{purgeStatus}', UPDATE_DATE=TRUNC(SYSDATE) WHERE ORGANIZATION_ID= {ORGANIZATION_ID} and DEPLOYMENT_ID= {DEPLOYMENT_ID}";
	private static final String UPDATE_DEPLOY_STATUS_DPL_DEPLOYMENT_TABLE = "UPDATE DPL_DEPLOYMENT SET DEPLOY_STATUS='{deployStatus}', PURGE_STATUS='{purgeStatus}', CANCEL_TIMESTAMP=TRUNC(SYSDATE), UPDATE_DATE=TRUNC(SYSDATE) WHERE ORGANIZATION_ID= {ORGANIZATION_ID} and DEPLOYMENT_ID= {DEPLOYMENT_ID}";

	/**
	 * The method gets files to have upload old greater than a day from database.
	 * 
	 * @return List name of file need to purge.
	 */
	public List<String> getUploadFileFromDB() {
		// Get number day to keep the file. The default file keeps in 30 days.
		String days = CawPropertiesUtility.getInstance().getValuByKey(CawPurgeConstant.FILEPURGER_UPLOAD_AFTER_DAYS_AGE,
				CawPurgeConstant.FILEPURGER_UPLOAD_AFTER_DAYS_AGE_DEFAULT);
		/**
		 * Get number row for each bath to process. The default code will be got 1000
		 * records from database.
		 */
		String numRows = CawPropertiesUtility.getInstance().getValuByKey(CawPurgeConstant.FILEPURGER_UPLOAD_CHUNKMAX,
				CawPurgeConstant.FILEPURGER_UPLOAD_CHUNKMAX_DEFAULT);

		List<String> fileNameList = new ArrayList<String>();
		String queryStr = SELECT_RECORD_OLDER_THAN_DAY.replace(NUM_DAY, days).replace(NUM_ROWS, numRows);
		Connection connection = CawPurgeJdbcHelper.getInstance().getConnectionToXcenterDB();
		if (connection != null) {
			try {
				Statement stmt = connection.createStatement();
				ResultSet rs = stmt.executeQuery(queryStr);
				while (rs.next()) {
					if (StringUtils.isNotEmpty(rs.getString(FILE_NAME)))
						fileNameList.add(rs.getString(FILE_NAME));
				}
				connection.close();
			} catch (Exception ex) {
				logger.error("Method getUploadFileFromDB() cannot get the data from database.", ex);
			}
		}

		return fileNameList;
	}

	/**
	 * Get list file have deployed on xcenter old greater than a day from database.
	 * 
	 * @return
	 */
	public List<CawPurgeDeploymentFile> getDeploymentFileFromDB() {
		// Get number day to keep the file. The default file keeps in 30 days.
		String days = CawPropertiesUtility.getInstance().getValuByKey(
				CawPurgeConstant.FILEPURGER_DEPLOYMENT_AFTER_DAYS_AGE,
				CawPurgeConstant.FILEPURGER_DEPLOYMENT_AFTER_DAYS_AGE_DEFAULT);
		/**
		 * Get number row for each bath to process. The default code will be got 1000
		 * records from database.
		 */
		String numRows = CawPropertiesUtility.getInstance().getValuByKey(
				CawPurgeConstant.FILEPURGER_DEPLOYMENT_CHUNKMAX,
				CawPurgeConstant.FILEPURGER_DEPLOYMENT_CHUNKMAX_DEFAULT);

		List<CawPurgeDeploymentFile> deploymentFileList = new ArrayList<CawPurgeDeploymentFile>();
		/* BEGIN BZ36145*/
		String purgeDeployStatus = CawPropertiesUtility.getInstance().getValuByKey(
				CawPurgeConstant.FILEPURGER_DEPLOYMENT_STATUS, CawPurgeConstant.FILEPURGER_DEPLOYMENT_STATUS_DEFAULT);
		String deployStatusStr = convertStringApostrophes(purgeDeployStatus);
		
		String purgeDeployExcludeTypeStr = CawPropertiesUtility.getInstance().getValuByKey(
				CawPurgeConstant.FILEPURGER_DEPLOYMENT_EXCLUDE_TYPE, "");
		String deployExcludeTypeStr = convertStringApostrophes(purgeDeployExcludeTypeStr);
		
		/* END BZ36145*/

		if (StringUtils.isNotEmpty(deployStatusStr) 
				&& StringUtils.isNotEmpty(deployExcludeTypeStr)) {
			String queryStr = SELECT_DEPLOYMENT_FILE_OLDER_THAN_DAY.replace(DEPLOY_STATUS_CONDITION, deployStatusStr)
					.replace(PURGE_STATUS, PURGE_STATUS_SUCCESS).replace(DEPLOYMENT_EXCLUDE_TYPE, deployExcludeTypeStr)
					.replace(NUM_DAY, days).replace(NUM_ROWS, numRows);
			logger.debug("The SQL statement to get deployment from DB:" + queryStr);
			Connection connection = CawPurgeJdbcHelper.getInstance().getConnectionToXcenterDB();
			if (connection != null) {
				try {
					CawPurgeDeploymentFile cawPurgeDeploymentFile = null;
					Statement stmt = connection.createStatement();
					ResultSet rs = stmt.executeQuery(queryStr);
					if (rs != null) {
						while (rs.next()) {
							cawPurgeDeploymentFile = new CawPurgeDeploymentFile();
							cawPurgeDeploymentFile.setOrganizationId(rs.getLong(ORGANIZATION_ID));
							cawPurgeDeploymentFile.setDeploymentId(rs.getLong(DEPLOYMENT_ID));
							cawPurgeDeploymentFile.setDeploymentName(rs.getString(FILE_NAME));
							cawPurgeDeploymentFile.setDeploymentStatus(rs.getString(DEPLOY_STATUS));
							deploymentFileList.add(cawPurgeDeploymentFile);
						}
					}
					connection.close();
				} catch (Exception ex) {
					logger.error("Method getDeploymentFileFromDB() cannot get the data from database.", ex);
				}
			}
		}

		return deploymentFileList;
	}

	/* BEGIN BZ36145*/
	/**
	 * The method get deployment status need to purge from config.
	 */
	protected String convertStringApostrophes(String str) {
		
		String splitStr = null;

		if (StringUtils.isNotEmpty(str)) {
			try {
				StringBuilder builder = new StringBuilder();
				String[] purgeDeployStatusArr = str.split(",");
				if (purgeDeployStatusArr != null && purgeDeployStatusArr.length > 0) {
					for (int i = 0; i < purgeDeployStatusArr.length; i++) {
						builder.append("'");
						builder.append(purgeDeployStatusArr[i].trim());
						builder.append("',");
					}
				}

				if (builder != null && builder.length() > 0) {
					splitStr = builder.substring(0, builder.length() - 1);
				}

			} catch (Exception ex) {
				logger.error("Method getPurgeDeployStatus() cannot get purge status from config.", ex);
			}
		}
		return splitStr;
	}
	/* END BZ36145*/

	/**
	 * 
	 * @param fileNameList
	 */
	public void deleteUploadInDB(List<String> fileNameList) {
		Connection connection = CawPurgeJdbcHelper.getInstance().getConnectionToXcenterDB();
		if (connection != null) {
			if (fileNameList != null && fileNameList.size() > 0) {
				try {
					Statement stmt = connection.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,
							ResultSet.CONCUR_UPDATABLE);
					connection.setAutoCommit(false);
					String deleteTableUploadQuery = new String();
					for (String fileName : fileNameList) {
						deleteTableUploadQuery = "DELETE FROM cfg_upload_record WHERE name='" + fileName + "'";
						logger.info(deleteTableUploadQuery);
						stmt.addBatch(deleteTableUploadQuery);
					}
					stmt.executeBatch();
					connection.commit();
					connection.close();
				} catch (Exception ex) {
					logger.error("Method deleteTablecFgUploadRecord() cannot get the data from database.", ex);
				}
			}
		}
	}

	/**
	 * 
	 * @param deploymentFileList
	 */
	public void deleteDeploymentFileInDB(List<CawPurgeDeploymentFile> deploymentFileList) {
		Connection connection = CawPurgeJdbcHelper.getInstance().getConnectionToXcenterDB();
		if (connection != null) {
			if (deploymentFileList != null && deploymentFileList.size() > 0) {
				try {
					Statement stmt = connection.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,
							ResultSet.CONCUR_UPDATABLE);
					connection.setAutoCommit(false);
					String deleteDeployment = null;
					String deleteDeploymentFile = null;

					for (CawPurgeDeploymentFile deploymentFile : deploymentFileList) {
						if (DEPLOY_STATUS_COMPLETE.equalsIgnoreCase(deploymentFile.getDeploymentStatus())
								|| DEPLOY_STATUS_CANCELLED.equalsIgnoreCase(deploymentFile.getDeploymentStatus())) {
							deleteDeployment = UPDATE_DPL_DEPLOYMENT_TABLE.replace(PURGE_STATUS, PURGE_STATUS_SUCCESS)
									.replace(ORGANIZATION_ID_VALUE,
											CawPurgeUtils.getInstance().vString(deploymentFile.getOrganizationId()))
									.replace(DEPLOYMENT_ID_VALUE,
											CawPurgeUtils.getInstance().vString(deploymentFile.getDeploymentId()));

							deleteDeploymentFile = UPDATE_DPL_DEPLOYMENT_FILE_TABLE
									.replace(PURGE_STATUS, PURGE_STATUS_SUCCESS)
									.replace(ORGANIZATION_ID_VALUE,
											CawPurgeUtils.getInstance().vString(deploymentFile.getOrganizationId()))
									.replace(DEPLOYMENT_ID_VALUE,
											CawPurgeUtils.getInstance().vString(deploymentFile.getDeploymentId()));

						} else if (DEPLOY_STATUS_IN_PROCESS.equalsIgnoreCase(deploymentFile.getDeploymentStatus())
								|| DEPLOY_STATUS_ERROR.equalsIgnoreCase(deploymentFile.getDeploymentStatus())
								|| DEPLOY_STATUS_SCHEDULED.equalsIgnoreCase(deploymentFile.getDeploymentStatus())) {

							deleteDeployment = UPDATE_DEPLOY_STATUS_DPL_DEPLOYMENT_TABLE
									.replace(DEPLOY_STATUS_CONDITION, DEPLOY_STATUS_CANCELLED)
									.replace(PURGE_STATUS, PURGE_STATUS_SUCCESS)
									.replace(ORGANIZATION_ID_VALUE,
											CawPurgeUtils.getInstance().vString(deploymentFile.getOrganizationId()))
									.replace(DEPLOYMENT_ID_VALUE,
											CawPurgeUtils.getInstance().vString(deploymentFile.getDeploymentId()));

							deleteDeploymentFile = UPDATE_DPL_DEPLOYMENT_FILE_TABLE
									.replace(PURGE_STATUS, PURGE_STATUS_SUCCESS)
									.replace(ORGANIZATION_ID_VALUE,
											CawPurgeUtils.getInstance().vString(deploymentFile.getOrganizationId()))
									.replace(DEPLOYMENT_ID_VALUE,
											CawPurgeUtils.getInstance().vString(deploymentFile.getDeploymentId()));
						}

						if (StringUtils.isNotEmpty(deleteDeployment) && StringUtils.isNotEmpty(deleteDeploymentFile)) {
							logger.info(deleteDeployment);
							stmt.addBatch(deleteDeployment);

							logger.info(deleteDeploymentFile);
							stmt.addBatch(deleteDeploymentFile);
						}

						// Clear temp variable
						deleteDeployment = null;
						deleteDeploymentFile = null;
					}

					stmt.executeBatch();
					connection.commit();
					connection.close();
				} catch (Exception ex) {
					logger.error("Cannot update data in database", ex);
				}
			}
		}
	}

	public String getPathFolderUploadFiles() {
		String directoryXadminDeploymentFull = null;
		// Get path from config Example: /u01/xadmin-deployment/
		String uploadDirectory = CawPropertiesUtility.getInstance()
				.getValuByKey(CawPurgeConstant.FILEPURGER_UPLOAD_DIRECTORY);
		if (StringUtils.isNotEmpty(uploadDirectory)) {
			boolean isDirectiry = CawPurgeFileUtility.getInstance().isDirectory(uploadDirectory);
			if (isDirectiry) {
				directoryXadminDeploymentFull = uploadDirectory;
			} else {
				logger.error("The directory " + uploadDirectory + " is not exist.");
			}
		} else {
			logger.error("The directory xadmin-deployment wasn't config.");
		}

		return directoryXadminDeploymentFull;
	}

	/* BEGIN BZ36145 */
	/**
	 * 
	 */
	public void purgeArchivedDataFiles() {
		String uploadArchiveDirectory = CawPropertiesUtility.getInstance()
				.getValuByKey(CawPurgeConstant.FILEPURGER_ARCHIVE_DIRECTORY);
		if (StringUtils.isNotEmpty(uploadArchiveDirectory)) {
			File directory = new File(uploadArchiveDirectory);
			if (directory.exists()) {
				String age = CawPropertiesUtility.getInstance().getValuByKey(
						CawPurgeConstant.FILEPURGER_ARCHIVE_FILE_AFTER_DAYS,
						CawPurgeConstant.FILEPURGER_ARCHIVE_AFTER_DAYS_DEFAULT);
				int day = Integer.valueOf(age) * -1;
				CawPurgeFileUtility.getInstance().deleteFilesOlderThanNdays(directory, day);
			}
		} else {
			logger.info("The method purgeArchivedDataFiles() cannot found the directory in configuration:"
					+ uploadArchiveDirectory);
		}
	}
	/* END BZ36145 */

	public String getDeploymentDirectory() {
		String apacheUploadsPathFull = null;
		String deploymentDirectory = CawPropertiesUtility.getInstance()
				.getValuByKey(CawPurgeConstant.FILEPURGER_DEPLOYMENT_DIRECTORY);
		if (StringUtils.isNotEmpty(deploymentDirectory)) {
			boolean isDirectiry = CawPurgeFileUtility.getInstance().isDirectory(deploymentDirectory);
			if (isDirectiry) {
				apacheUploadsPathFull = deploymentDirectory;
			} else {
				logger.error("The directory " + deploymentDirectory + " is not exist.");
			}
		} else {
			logger.error("The directory xadmin-deployment empty.");
		}

		return apacheUploadsPathFull;
	}

}
