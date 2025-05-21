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
 * Req/Bug ID#      ddMMyy    Description
 * BZ28012          180219    [New Requirement] Reprocess the ApplicationStatus calls if first attempt is unsuccessful
 *===================================================================
 */

package caw.pos.startup;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FilenameUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.http.ResponseEntity;

import caw.pos.araccount.CawCustomerUtil;
import caw.pos.common.CawConstants;
import caw.pos.common.CawPropertyUtils;
import caw.pos.util.CawEBSHelper;

import dtv.util.FileUtils;

/**
 *
 */
public class CawRetryApplicationStatusTimes {

    private static final int    DELAY_TIME_DELETE_FILE   = 1000;

    private static final Logger logger                   = Logger.getLogger(CawRetryApplicationStatusTimes.class);

    private static final String CAW_ESB_QUEUE_PATH       = CawPropertyUtils
            .getSystemProperty(CawConstants.CAW_ESB_QUEUE_PATH, CawConstants.CAW_ESB_QUEUE_PATH);

    private static final String CAW_ESB_QUEUE_ERROR_PATH = CAW_ESB_QUEUE_PATH + CawConstants.CAW_ERROR_FOLDER;

    private static final int    BATCH_MAX_FILE_PROCCESS  = 1000;

    /**
     * Execute run of the task
     */
    public void run() {

        try {
            final File dir = new File(CAW_ESB_QUEUE_PATH);
            final File files[] = dir.listFiles();
            if (files != null && files.length > 0) {
                int maxFileProccess = files.length;
                if (maxFileProccess > BATCH_MAX_FILE_PROCCESS) {
                    maxFileProccess = BATCH_MAX_FILE_PROCCESS;
                }

                for (int i = 0; i < maxFileProccess; i++) {
                    if (files[i].isFile()) {
                        processFile(files[i]);
                    }
                }
            }
        } catch (Exception ex) {
            logger.error("The class CawRetryApplicationStatusTimes.java can load file." + ex.getMessage());
        }
    }

    /**
     * Execute file
     * @param file
     */
    private void processFile(final File file) {

        try {
            if (file != null) {
                logger.info("Begin proccess file:" + file.getName());
                /**
                 * The file have extension is 3 will move to the folder error.
                 */
                String extension = FileUtils.getExtension(file);
                String fileNameWithOutExt = FilenameUtils.removeExtension(file.getName());
                String numberRetryFailed = String.valueOf(CawCustomerUtil.getApplicationStatusRetriesTime());
                if (StringUtils.equalsIgnoreCase(extension, numberRetryFailed)) {
                    try {
                        logger.info("The file has been retired more than 3 times.");
                        final File dir = new File(CAW_ESB_QUEUE_ERROR_PATH);
                        if (!dir.exists()) {
                            dir.mkdirs();
                        }

                        String newFileName = CAW_ESB_QUEUE_ERROR_PATH + "/" + fileNameWithOutExt + ".err";
                        File copied = new File(newFileName);
                        logger.info("The copy file '" + file.getName() + "' to " + CAW_ESB_QUEUE_ERROR_PATH
                                + "folder.");
                        FileUtils.copyFile(file, copied);
                        logger.info("Delete file '" + file.getName() + "'");
                        FileUtils.deleteFileWithDelay(file, 1000);
                    } catch (Exception ex) {
                        logger.error("Can not copie the file '" + file.getName() + "' to folder error."
                                + ex.getMessage());
                    }
                } else {
                    String content = FileUtils.loadFile(file);
                    if (StringUtils.isNotEmpty(content)) {
                        logger.info("The content from file:" + content);
                        ResponseEntity<String> careTakerResponse = CawEBSHelper.getInstance()
                                .sendCareTakerToEBS(content);
                        if (CawEBSHelper.RESPONSE_SUCCESS_CODE == careTakerResponse.getStatusCodeValue()) {
                            logger.info("The file retried success.");
                            logger.info("Delete file success '" + file.getName() + "'");
                            FileUtils.deleteFileWithDelay(file, DELAY_TIME_DELETE_FILE);
                        } else {
                            logger.info("The file retried fail.");
                            int retryNumber = increaseRetryNumber(extension);
                            String newFileName = CAW_ESB_QUEUE_PATH + "/" + fileNameWithOutExt + "." + retryNumber;
                            File copied = new File(newFileName);
                            FileUtils.copyFile(file, copied);
                            // Delete old file
                            FileUtils.deleteFileWithDelay(file, 1000);
                        }
                    }
                }
            }

        } catch (IOException ex) {
            logger.error("The class CawRetryApplicationStatusTimes.java can not load file '" + file.getName() + "'."
                    + ex.getMessage());
        }
    }

    /**
     * @param retryNumber
     * @return
     */
    private int increaseRetryNumber(String retryNumber) {

        int numberRetry = 0;
        try {
            numberRetry = Integer.parseInt(retryNumber);
            numberRetry = numberRetry + 1;
        } catch (Exception ex) {
            logger.debug("Can not parse retry number to an int." + ex.getMessage());
        }

        return numberRetry;

    }

}
