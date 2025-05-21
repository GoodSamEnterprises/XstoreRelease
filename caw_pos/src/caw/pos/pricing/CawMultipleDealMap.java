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
 * BZ28014          310519    [New Requirement] Xstore needs to allow stackability for/Allow multiple Merchant Certificates in a transaction
 * BZ31793          250719    [INTERNAL] serializedCoupon field in OS log is returned same serial numbers for each Merchant Certificate coupon
 *===================================================================
 */

package caw.pos.pricing;

import java.math.BigDecimal;
import java.util.*;

import dtv.xst.dao.prc.IDeal;

/**
 * Store deals during transaction that related to multiple deal function
 */
public class CawMultipleDealMap {

    private static volatile CawMultipleDealMap INSTANCE = null;

    public static CawMultipleDealMap getInstance() {

        if (INSTANCE == null) {
            synchronized (CawMultipleDealMap.class) {
                if (INSTANCE == null) {
                    INSTANCE = new CawMultipleDealMap();
                }
            }
        }
        return INSTANCE;
    }

    private Map<String, BigDecimal> _multiApply          = new HashMap<>();

    private HashSet<IDeal>          _dealUsed            = new HashSet<>();

    private Map<String, BigDecimal> _preDealUnitPriceMap = new HashMap<>(); // BZ31793

    /**
     * 
     * @return
     */
    public Map<String, BigDecimal> getMultiApply() {
        return _multiApply;
    }

    /**
     * 
     * @param argMultiApply
     */
    public void setMultiApply(Map<String, BigDecimal> argMultiApply) {
        _multiApply = argMultiApply;
    }

    /**
     * 
     * @return
     */
    public HashSet<IDeal> getDealUsed() {
        return _dealUsed;
    }

    /**
     * 
     * @param argDealUsed
     */
    public void setDealUsed(HashSet<IDeal> argDealUsed) {
        _dealUsed = argDealUsed;
    }

    /**
     * 
     * @param key
     * @param value
     */
    public void putToMultipleDealMap(String key, BigDecimal value) {
        _multiApply.put(key, value);
    }

    /**
     * 
     * @param deal
     */
    public void putToUsedDeal(IDeal deal) {
        _dealUsed.add(deal);
    }

    /**
     * 
     */
    public void clearDealMap() {
        _multiApply = new HashMap<>();
        _dealUsed = new HashSet<>();
        _preDealUnitPriceMap = new HashMap<>(); /* BZ31793 */
    }

    /* BEGIN BZ31793 */
    /**
     * @return the preDealUnitPriceMap
     */
    public Map<String, BigDecimal> getPreDealUnitPriceMap() {
        return _preDealUnitPriceMap;
    }

    /**
     * @param argPreDealUnitPriceMap
     *            the preDealUnitPriceMap to set
     */
    public void setPreDealUnitPriceMap(Map<String, BigDecimal> argPreDealUnitPriceMap) {
        _preDealUnitPriceMap = argPreDealUnitPriceMap;
    }

    /**
     * @param key
     * @param value
     */
    public void putToPreDealUnitPriceMap(String key, BigDecimal value) {
        _preDealUnitPriceMap.put(key, value);
    }
    /* END BZ31793 */
}
