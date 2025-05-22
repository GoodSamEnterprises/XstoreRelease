package caw.pugre.utility;

import org.apache.commons.httpclient.Credentials;
import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.UsernamePasswordCredentials;
import org.apache.commons.httpclient.auth.AuthScope;
import org.apache.commons.lang.StringUtils;
import org.apache.jackrabbit.webdav.client.methods.DeleteMethod;
import org.apache.log4j.Logger;

public class CawPurgeHttpServiceUtility {
	final static Logger logger = Logger.getLogger(CawPurgeEncryptionUtility.class);
	
	private static final String JAVAX_NET_SSL_TRUST_STORE_PASSWORD = "javax.net.ssl.trustStorePassword";
	private static final String JAVAX_NET_SSL_TRUST_STORE = "javax.net.ssl.trustStore";

	private static volatile CawPurgeHttpServiceUtility INSTANCE = null;

	public static CawPurgeHttpServiceUtility getInstance() {

		if (INSTANCE == null) {
			synchronized (CawPurgeHttpServiceUtility.class) {
				if (INSTANCE == null) {
					INSTANCE = new CawPurgeHttpServiceUtility();
				}
			}
		}
		return INSTANCE;
	}

	public boolean deleteFile(String relativePath) {
		boolean successful = true;
		if (StringUtils.isNotEmpty(relativePath)) {
			try {
				String trustStore = CawPropertiesUtility.getInstance()
						.getValuByKey(CawPurgeConstant.JAVAX_NET_SSL_TRUSTSTORE);
				String trustStorePassword = CawPropertiesUtility.getInstance()
						.getValuByKey(CawPurgeConstant.JAVAX_NET_SSL_TRUSTSTOREPASSWORD);

				if (StringUtils.isNotEmpty(trustStore) && StringUtils.isNotEmpty(trustStorePassword)) {
					// Set path to trustStore
					System.setProperty(JAVAX_NET_SSL_TRUST_STORE, trustStore);

					if (trustStorePassword.indexOf(CawPurgeConstant.EXCLAMATION_MARK) == 0) {
						trustStorePassword = trustStorePassword.substring(1);
						String trustStorePasswordEncrypt = CawPurgeEncryptionUtility.getInstance()
								.encrypt(trustStorePassword);
						if (trustStorePasswordEncrypt != null) {
							CawPropertiesUtility.getInstance().updateProperty(
									CawPurgeConstant.JAVAX_NET_SSL_TRUSTSTOREPASSWORD, trustStorePasswordEncrypt);
							CawPropertiesUtility.getInstance().reloadPropertiseInMemnory();
						}
					} else {
						trustStorePassword = CawPurgeEncryptionUtility.getInstance().decrypt(trustStorePassword);
					}
					// Set password for trustStore
					System.setProperty(JAVAX_NET_SSL_TRUST_STORE_PASSWORD, trustStorePassword);

					// Get user name and password
					String apacheUser = CawPropertiesUtility.getInstance()
							.getValuByKey(CawPurgeConstant.FILEPURGER_DEPLOYMENT_WEBDAV_USERNAME);
					String apachePassword = CawPropertiesUtility.getInstance()
							.getValuByKey(CawPurgeConstant.FILEPURGER_DEPLOYMENT_WEBDAV_PASSWORD);

					if (StringUtils.isNotEmpty(apacheUser) && StringUtils.isNotEmpty(apachePassword)) {
						if (apacheUser.indexOf(CawPurgeConstant.EXCLAMATION_MARK) == 0) {
							apacheUser = apacheUser.substring(1);
							String apacheUserEncrypt = CawPurgeEncryptionUtility.getInstance().encrypt(apacheUser);
							if (apacheUserEncrypt != null) {
								CawPropertiesUtility.getInstance().updateProperty(
										CawPurgeConstant.FILEPURGER_DEPLOYMENT_WEBDAV_USERNAME, apacheUserEncrypt);
								CawPropertiesUtility.getInstance().reloadPropertiseInMemnory();
							}
						} else {
							apacheUser = CawPurgeEncryptionUtility.getInstance().decrypt(apacheUser);
						}

						if (apachePassword.indexOf(CawPurgeConstant.EXCLAMATION_MARK) == 0) {
							apachePassword = apachePassword.substring(1);
							String apachePasswordEncrypt = CawPurgeEncryptionUtility.getInstance()
									.encrypt(apachePassword);
							if (apachePasswordEncrypt != null) {
								CawPropertiesUtility.getInstance().updateProperty(
										CawPurgeConstant.FILEPURGER_DEPLOYMENT_WEBDAV_PASSWORD, apachePasswordEncrypt);
								CawPropertiesUtility.getInstance().reloadPropertiseInMemnory();
							}
						} else {
							apachePassword = CawPurgeEncryptionUtility.getInstance().decrypt(apachePassword);
						}
					}

					HttpClient client = new HttpClient();
					Credentials creds = new UsernamePasswordCredentials(apacheUser, apachePassword);
					client.getState().setCredentials(AuthScope.ANY, creds);

					String stagingHostBaseURL = CawPropertiesUtility.getInstance()
							.getValuByKey(CawPurgeConstant.FILEPURGER_DEPLOYMENT_WEBDAV_STAGINGHOSTBASEURL);
					if (StringUtils.isNotEmpty(stagingHostBaseURL)) {
						String fullPath = stagingHostBaseURL + relativePath;
						logger.info("Running delete file:" + fullPath);
						DeleteMethod method = new DeleteMethod(fullPath);
						method.setDoAuthentication(true);
						int status = client.executeMethod(method);
						String mgsout = "RESPONSE CODE [" + status + "]::" + method.getStatusCode() + "::"
								+ method.getStatusText();
						logger.info(mgsout);
					}
				}

			} catch (Exception e) {
				successful = false;
				logger.error("Delete deployment file failed.", e);
			}
		}
		
		return successful;
	}
}
