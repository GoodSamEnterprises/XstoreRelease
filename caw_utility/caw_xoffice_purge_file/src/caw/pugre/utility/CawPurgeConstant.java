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
 * BZ36145              140520    [Prod] Xadmin Purge 
 *===================================================================
 */
package caw.pugre.utility;

public class CawPurgeConstant {
	// FUNCTION TO PURGE UPLOAD FILES
	public static final String FILEPURGER_UPLOAD_ENABLE            = "filepurger.upload.enable";
	public static final String FILEPURGER_UPLOAD_DIRECTORY         = "filepurger.upload.directory";
	public static final String FILEPURGER_UPLOAD_AFTER_DAYS_AGE    = "filepurger.upload.after.days.age";
	public static final String FILEPURGER_UPLOAD_CHUNKMAX          = "filepurger.upload.chunkmax";
	
	// FUNCTION TO PURGE UPLOAD FILES DEFAULT
	public static final String FILEPURGER_UPLOAD_ENABLE_DEFAULT         = "true";
	public static final String FILEPURGER_UPLOAD_AFTER_DAYS_AGE_DEFAULT = "30";
	public static final String FILEPURGER_UPLOAD_CHUNKMAX_DEFAULT       = "1000";
	
	/* BEGIN BZ36145 */
	// FUNCTION TO PURGE ARCHIVE FILES
	public static final String FILEPURGER_ARCHIVE_FILE_AFTER_DAYS    = "filepurger.archive.file.after.days";
	public static final String FILEPURGER_ARCHIVE_FILE_ENABLE        = "filepurger.archive.file.enable";
	public static final String FILEPURGER_ARCHIVE_DIRECTORY          = "filepurger.archive.directory";
	
	// FUNCTION TO PURGE UPLOAD ARCHIVE DEFAULT
	public static final String FILEPURGER_ARCHIVE_FILE_ENABLE_DEFAULT   = "false";
	public static final String FILEPURGER_ARCHIVE_AFTER_DAYS_DEFAULT    = "30";
	
	/* END BZ36145 */

	// FUNCTION TO PURGE DEPLOYMENT FILES
	public static final String FILEPURGER_DEPLOYMENT_ENABLE         = "filepurger.deployment.enable";
	public static final String FILEPURGER_DEPLOYMENT_DIRECTORY      = "filepurger.deployment.directory";
	public static final String FILEPURGER_DEPLOYMENT_AFTER_DAYS_AGE = "filepurger.deployment.after.days.age";
	public static final String FILEPURGER_DEPLOYMENT_CHUNKMAX       = "filepurger.deployment.chunkmax";
	public static final String FILEPURGER_DEPLOYMENT_STATUS         = "filepurger.deployment.status";
	public static final String FILEPURGER_DEPLOYMENT_WEBDAV_ENABLE  = "filepurger.deployment.webdav.enable";
	public static final String FILEPURGER_DEPLOYMENT_EXCLUDE_TYPE   = "filepurger.deployment.exclude.type";//BZ36145

	// FUNCTION TO PURGE DEPLOYMENT FILES DEFAULT
	public static final String FILEPURGER_DEPLOYMENT_ENABLE_DEFAULT         = "true";
	public static final String FILEPURGER_DEPLOYMENT_AFTER_DAYS_AGE_DEFAULT = "30";
	public static final String FILEPURGER_DEPLOYMENT_CHUNKMAX_DEFAULT       = "1000";
	public static final String FILEPURGER_DEPLOYMENT_STATUS_DEFAULT         = "CANCELLED,COMPLETE";
	public static final String FILEPURGER_DEPLOYMENT_WEBDAV_ENABLE_DEFAULT    = "false";

	// THE INFORMATION TO CONNECTED TO XCENTER DATABASE.
	public static final String DB_XCENTER_CONNECTION_URL = "db.xcenter.connectionURL";
	public static final String DB_XCENTER_USERNAMER      = "db.xcenter.username";
	public static final String DB_XCENTER_PASSWORD       = "db.xcenter.password";
	
	// Purge deployment files via WebDAV
	public static final String FILEPURGER_DEPLOYMENT_WEBDAV_STAGINGHOSTBASEURL = "filepurger.deployment.webdav.StagingHostBaseURL";
	public static final String FILEPURGER_DEPLOYMENT_WEBDAV_USERNAME           = "filepurger.deployment.webdav.username";
	public static final String FILEPURGER_DEPLOYMENT_WEBDAV_PASSWORD           = "filepurger.deployment.webdav.password";
	
	// Configuration trustStore
	public static final String JAVAX_NET_SSL_TRUSTSTORE          = "javax.net.ssl.trustStore";
	public static final String JAVAX_NET_SSL_TRUSTSTOREPASSWORD  = "javax.net.ssl.trustStorePassword";
	
	// Common variable
	public static final String EXCLAMATION_MARK     = "!";
	public static final String LOG4J_CONFIGURE_FILE = "log4j.configure.file";
	
	// MM_DD_YYYY_HH_MM_SS
	public static final String MM_DD_YYYY_HH_MM_SS = "MM/dd/yyyy HH:mm:ss";



}
