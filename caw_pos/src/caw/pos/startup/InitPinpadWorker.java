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
 * BZ26368          110418    Initialize the pin pad to process EMV/Chip and PIN transaction
 * BZ27127          220818    [PROD] Xstore throws a blank error and application will not start if pin pad certificates are missing
 *===================================================================
 */

package caw.pos.startup;

import javax.inject.Inject;

import org.apache.log4j.Logger;

import MiraServJava.MiraServJava;
import MiraServJava.MiraServJavaException;
import caw.tenderauth.impl.eigen.CawEigenHelper;
import caw.tenderauth.impl.eigen.constants.CawEigenConstants;

import dtv.pos.framework.worker.WorkerAdapter;

/**
 * The Class InitBarcodeTranslatorWorker.
 * Initialize the PIN pad to process EMV/Chip and PIN transactions
 * It may also be required to update the PIN pad with encryption keys.
 * Request fields: Station ID, Transaction Code (94)
*/

public class InitPinpadWorker extends WorkerAdapter {

    private static final Logger      logger = Logger
            .getLogger(InitPinpadWorker.class);

    public static final MiraServJava msj    = new MiraServJava();

    @Inject
    private CawEigenHelper           _cawEigenHelper;

    @Override
    protected void performWorkImpl() {

        try {
            msj.Init();
            msj.SetTField(CawEigenConstants.FN_TRANS_CODE, CawEigenConstants.VALUE_94);
            msj.SetTField(CawEigenConstants.FN_STATION_ID, _cawEigenHelper
                    .getStationId());
            msj.Process();
        } catch (MiraServJavaException ex) {
            logger.error("MiraServ Java Exception: " + ex.getMessage());
        } catch (RuntimeException ex) {
            logger.error("MiraServ Java Exception-2: " + ex.getMessage());
        } catch (Exception ex) {
            logger.error("MiraServ Java Exception-3: " + ex.getMessage());
        }
    }
}
