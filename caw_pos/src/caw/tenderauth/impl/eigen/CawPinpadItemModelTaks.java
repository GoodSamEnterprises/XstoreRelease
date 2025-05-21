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
 * BZ27344          301018    Pin Pad Performance is slow when item price is updated by a deal/promo or a manual price adjustment
 *===================================================================
 */

package caw.tenderauth.impl.eigen;

import javax.inject.Inject;

import org.apache.log4j.Logger;

/**
 * The scheduled task send the item from Queue to MiraServ.
 */
public class CawPinpadItemModelTaks {

    private static final String FIXED_DELAY   = "caw.pos.scheduled.send.request.to.pinpad.fixed.delay";

    private static final String INITIAL_DELAY = "caw.pos.scheduled.send.request.to.pinpad.initial.delay";

    private static final Logger logger_       = Logger.getLogger(CawPinpadItemModelTaks.class);

    @Inject
    private CawEigenMgr         _cawEigenMgr;

    public void run() {

        logger_.debug("The CawPinpadItemModelTaks is running.");
        if (!CawPinpadItemModelHelper.getInstance().getListItemNeedToSendMiraServ().isEmpty()) {
            logger_.debug("The total item in Queue is "
                    + CawPinpadItemModelHelper.getInstance().getListItemNeedToSendMiraServ().size());
            CawPinpadItemModel cawPinpadItemModel = CawPinpadItemModelHelper.getInstance()
                    .getListItemNeedToSendMiraServ().poll();
            sendRequestAddItemToMiraServ(cawPinpadItemModel);
        }
    }

    /**
     * @param cawPinpadItemModel
     */
    private void sendRequestAddItemToMiraServ(CawPinpadItemModel cawPinpadItemModel) {

        if (cawPinpadItemModel.getPinpadItemModelCommand() != null) {
            logger_.debug("CawPinpadItemModelTaks is proccessing [" + cawPinpadItemModel + "]");
            switch (cawPinpadItemModel.getPinpadItemModelCommand()) {
            case CLEAR_PINPAD_CURRENT_MODEL: {
                _cawEigenMgr.startSessionToClearPinpadScreen();
                break;
            }

            case ADD_PINPAD_CURRENT_MODEL: {
                _cawEigenMgr.addItemModelToPinpad(cawPinpadItemModel);
                break;
            }

            case ADD_PINPAD_INCLUDE_FOOTER: {
                _cawEigenMgr.addItemModelToPinpad(cawPinpadItemModel);
                break;
            }

            case REMOVE_PINPAD_CURRENT_MODEL: {
                _cawEigenMgr.removeItemModelToPinpad(cawPinpadItemModel);
                break;
            }
            }
        }
    }

    /**
     * 
     * @return
     */
    public int getInitialDelay() {

        int time = 1000;
        try {
            String initalTimeConfig = System.getProperty(INITIAL_DELAY);
            time = Integer.valueOf(initalTimeConfig);
        } catch (Exception ex) {
            logger_.debug("Can not get InitialDelay time " + ex.getMessage());
        }

        return time;

    }

    /**
     * 
     * @return
     */
    public int getFixedDelay() {

        int time = 1000;
        try {
            String initalTimeConfig = System.getProperty(FIXED_DELAY);
            time = Integer.valueOf(initalTimeConfig);
        } catch (Exception ex) {
            logger_.debug("Can not get FixedDelay time " + ex.getMessage());
        }

        return time;

    }
}
