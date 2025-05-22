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

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang.time.DateUtils;
import org.apache.log4j.Logger;

public class CawPurgeFileUtility {
	final static Logger logger = Logger.getLogger(CawPurgeFileUtility.class);
	private static volatile CawPurgeFileUtility INSTANCE = null;

	public static CawPurgeFileUtility getInstance() {

		if (INSTANCE == null) {
			synchronized (CawPurgeFileUtility.class) {
				if (INSTANCE == null) {
					INSTANCE = new CawPurgeFileUtility();
				}
			}
		}

		return INSTANCE;
	}

	/**
	 * Return list file name in folder
	 * 
	 * @param path
	 * @return
	 */
	public List<String> getFileNames(String path) {
		List<String> result = null;
		if (StringUtils.isNotEmpty(path)) {
			try (Stream<Path> walk = Files.walk(Paths.get(path))) {
				result = walk.filter(Files::isRegularFile).map(x -> x.toString()).collect(Collectors.toList());
			} catch (IOException e) {
				logger.error("Can not get files name in folder '" + path + "'", e);
			}
		}

		return result;
	}

	/**
	 * The method is check folder exists.
	 * 
	 * @param path
	 * @return
	 */
	public boolean isDirectory(String path) {
		boolean isDirectory = false;
		if (StringUtils.isNotEmpty(path)) {
			try {
				File dir = new File(path);
				if (dir != null && dir.isDirectory()) {
					isDirectory = true;
				} else {
					isDirectory = false;
				}

			} catch (Exception e) {
				logger.error("Method isDirectory() cannot check path exist.", e);
			}
		}

		return isDirectory;
	}

	/**
	 * The method deletes file.
	 * 
	 * @param directy is folder contain file.
	 * @param name    is file name
	 */
	public void deleteFile(String directory, String name) {
		String filePath = directory + "/" + name;
		try {
			File file = new File(filePath);
			if (file.isFile()) {
				FileUtils.forceDelete(file);
				logger.info("Deleted file '" + filePath + "'");
			}
		} catch (Exception e) {
			logger.error(
					"Method deleteFile(String directyOrg1000, String fileName) cannot delete file" + filePath + ".", e);
		}
	}

	/**
	 * The method clean all file in folder.
	 * 
	 * @param directory
	 */
	public void cleanDirectory(String directory) {
		try {
			File file = new File(directory);
			if (file.isDirectory()) {
				FileUtils.cleanDirectory(file);
				logger.info("Clean folder directory '" + directory + "'");
			}
		} catch (Exception e) {
			logger.error("Method cleanDirectory cannot clean file ", e);
		}
	}

	/* BEGIN BZ36145 */
	public void deleteFilesOlderThanNdays(File directory, int daysBack) {
		SimpleDateFormat sdf = new SimpleDateFormat(CawPurgeConstant.MM_DD_YYYY_HH_MM_SS);
		if (directory.exists()) {
			File[] listFiles = directory.listFiles();
			Date oldestAllowedFileDate = DateUtils.addDays(new Date(), daysBack);
			logger.info("Delete file before date:" + oldestAllowedFileDate);
			for (File file : listFiles) {
				if (file.isDirectory()) {
					try {
						String dateStr = sdf.format(file.lastModified());
						logger.info("Last Modified of '" + file.getName() + "' is " + sdf.format(file.lastModified()));

						Date lastModified = sdf.parse(dateStr);
						// lastModified occurs before oldestAllowedFileDate
						if (lastModified.compareTo(oldestAllowedFileDate) < 0) {
							if (file.canWrite()) {
								FileUtils.deleteDirectory(file);
								logger.error("Directory '" + file + "' deleted success.");
							} else {
								logger.error("Purge function did not enough permission to delete the file:'" + file + "'");
							}
						}
					} catch (ParseException e) {
						logger.error("The file cannot parse the last modified to date.", e);
					} catch (IOException e) {
						logger.error("Delete folder failed.", e);
					}
				}
			}
		}
	}
	/* END BZ36145 */
}
