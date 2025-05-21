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
 * BZ28562          071218    PINPAD doesn't reload items once complete transaction by partial Credit card
 * BZ29383          190219    [Internal] GS Account Inquiry form on the PinPad does not go away after selecting Back/Esc.
 *===================================================================
 */

package caw.tenderauth.impl.eigen;

import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;

/**
 * The class process the Queue contain the items before schedule task sends to MiraSever.
 */
public class CawPinpadItemModelHelper {

    private static ConcurrentLinkedQueue<CawPinpadItemModel> _itemNeedToSendToMiraServ = null;

    private static CawPinpadItemModelHelper                  INSTANCE                  = null;

    public static boolean                                    refreshPinPadScreen       = false; // BZ29383

    /**
     * 
     * @return
     */
    public static CawPinpadItemModelHelper getInstance() {

        if (INSTANCE == null) {
            synchronized (CawPinpadItemModelHelper.class) {
                if (INSTANCE == null) {
                    INSTANCE = new CawPinpadItemModelHelper();
                }
            }
        }
        return INSTANCE;
    }

    /**
     * 
     * @return
     */
    public ConcurrentLinkedQueue<CawPinpadItemModel> getListItemNeedToSendMiraServ() {

        if (_itemNeedToSendToMiraServ == null) {
            synchronized (CawPinpadItemModelHelper.class) {
                if (_itemNeedToSendToMiraServ == null) {
                    _itemNeedToSendToMiraServ = new ConcurrentLinkedQueue<CawPinpadItemModel>();
                }
            }
        }

        return _itemNeedToSendToMiraServ;

    }

    /**
     * 
     * @param cawPinpadItemModel
     */
    public void addElementToListNeedToSendMiraServ(
            CawPinpadItemModel cawPinpadItemModel) {

        if (cawPinpadItemModel != null) {
            _itemNeedToSendToMiraServ = getListItemNeedToSendMiraServ();
            _itemNeedToSendToMiraServ.add(cawPinpadItemModel);
        }
    }

    /**
     * 
     * @param collections
     */
    public void addAllElementToListNeedToSendMiraServ(
            Queue<CawPinpadItemModel> collections) {

        if (collections != null && collections.size() > 0) {
            _itemNeedToSendToMiraServ = getListItemNeedToSendMiraServ();
            _itemNeedToSendToMiraServ.addAll(collections);
        }

    }

    /**
     * 
     */
    public void clearAllElementToListNeedToSendMiraServ() {

        if (!_itemNeedToSendToMiraServ.isEmpty()) {
            _itemNeedToSendToMiraServ.clear();
        }
    }

    /* BEGIN BZ29383, BZ28562 */
    /**
     * @return the refreshPinPadScreen
     */
    public static boolean isRefreshPinPadScreen() {
    
        return refreshPinPadScreen;
    }

    
    /**
     * @param argRefreshPinPadScreen the refreshPinPadScreen to set
     */
    private static void setRefreshPinPadScreen(boolean argRefreshPinPadScreen) {
    
        refreshPinPadScreen = argRefreshPinPadScreen;
    }
    
    public static void handleRefreshPinPadScreen(boolean isRefresh) {
        setRefreshPinPadScreen(isRefresh);
    }
    /* END BZ29383, BZ28562 */

}
