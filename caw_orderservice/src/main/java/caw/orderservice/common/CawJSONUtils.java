/**
 * CONFIDENTIAL AND PROPRIETARY SOURCE CODE. 
 * 
 * Use and distribution of this code is subject to applicable 
 * licenses and the permission of the code owner.  This notice 
 * does not indicate the actual or intended publication of 
 * this source code.
 * 
 * Portions [of the software code and associated documentation] 
 * developed for Camping World are proprietary and confidential 
 * to BTM Global. BTM Global has granted Camping World a perpetual, 
 * non-exclusive, non-sublicensable license to use [the software 
 * code and associated documentation] for its internal business 
 * operations only.
 * 
 * ===== BTM Modification ===========================================
 * Req/Bug ID#      ddMMyy    Description
 * BZ48630          150622    [Task] Order Service - Transaction Posting to Cheetah
 *===================================================================
 */

package caw.orderservice.common;

import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;

import twitter4j.JSONArray;
import twitter4j.JSONException;
import twitter4j.JSONObject;

/**
 * Define utility methods for JSON Object
 */
public final class CawJSONUtils {

    private static final Logger logger             = Logger.getLogger(CawJSONUtils.class);

    public static JSONArray getJSONArray(JSONObject object, String key) {

        JSONArray result = null;
        if (object != null && key != null) {
            try {
                Object obj = object.get(key);
                if (obj != null && obj instanceof JSONArray) {
                    result = object.getJSONArray(key);
                }
            } catch (JSONException ex) {
                //Nothing to do, return null
                logger.error("getJSONArray:" + ex.getMessage());
            }
        }
        return result;
    }

    public static JSONObject getJSONObject(JSONObject object, String key) {

        JSONObject result = null;
        if (object != null && key != null) {
            try {
                Object obj = object.get(key);
                if (obj != null && obj instanceof JSONObject) {
                    result = object.getJSONObject(key);
                }
            } catch (Exception ex) {
                //Nothing to do, return null
                logger.error("getJSONObject:" + ex.getMessage());
            }
        }
        return result;
    }

    public static String getString(JSONObject object, String key) {

        String result = null;
        if (object != null && key != null) {
            try {
                result = object.getString(key);
            } catch (Exception ex) {
                //Nothing to do, return null
                logger.error("getString:" + ex.getMessage());
            }
        }
        return result;
    }

    public static JSONObject getJSONObject(Object object) {

        JSONObject result = null;
        if (object != null && object instanceof JSONObject) {
            try {
                result = (JSONObject) object;
            } catch (Exception ex) {
                //Nothing to do, return null
                logger.error("getJSONObject-1:" + ex.getMessage());
            }
        }
        return result;
    }

    public static String getString(JSONObject object, String keyLevel1,
            String keyLevel2) {

        String resValue = null;
        boolean found = false;
        JSONObject objIndex = null;
        try {
            if (!found) {
                JSONArray arr = getJSONArray(object, keyLevel1);
                if (arr != null) {
                    int len = arr.length();
                    for (int i = 0; i < len; i++) {
                        objIndex = getJSONObject(arr.get(i));
                        /*Example: {"identifier":12311522,"type":1,"typeDescription":"Home",
                         * "number":"9062518079","isActive":true,"isPrimary":true}*/
                        if (objIndex != null) {
                            resValue = getString(objIndex, keyLevel2);
                            if (resValue != null
                                    && resValue.length() > 0) {
                                found = true;
                                break;
                            }
                        }
                    }
                }
            }

            if (!found) {
                objIndex = getJSONObject(object, keyLevel1);
                if (objIndex != null) {
                    resValue = getString(objIndex, keyLevel2);
                    if (resValue != null && resValue.length() > 0) {
                        found = true;
                    }
                }
            }
        } catch (Exception ex) {
            logger.error("getString-1" + ex.getMessage());
            //Nothing to do, return null
        }
        return resValue;
    }

    /**
     * Convert a String to long
     * 
     * @param value
     * @param vdefault
     * @return
     */
    public static long vLong(String value, long vdefault) {

        try {
            if (value != null && value.length() > 0) {
                return Long.parseLong(value.trim());
            }
        } catch (Exception ex) {
            logger.error("vLong:" + ex.getMessage());
        }
        return vdefault;
    }

    /**
     * Convert a String to long
     * 
     * @param value
     * @return
     */
    public static long vLong(String value) {

        return vLong(value, 0l);
    }

    // Begin BZ26398
    /**
     * Convert a String to JSONObject
     * @param str
     * @return
     */
    public static JSONObject toJSONObject(String str) {

        JSONObject jsonObject = null;
        if (StringUtils.isNotEmpty(str)) {
            try {
                jsonObject = new JSONObject(str);
            } catch (Exception ex) {
                logger.error("vJSONObject method " + ex.getMessage());
                //Nothing to do, return null
            }
        }

        return jsonObject;
    }

    /**
     * Convert a String to JSONArray
     * @param str
     * @return
     */
    public static JSONArray toJSONArray(String str) {

        JSONArray jsonArray = null;
        if (StringUtils.isNotEmpty(str)) {
            try {
                jsonArray = new JSONArray(str);
            } catch (Exception ex) {
                logger.error("vJSONArray method " + ex.getMessage());
                //Nothing to do, return null
            }
        }

        return jsonArray;
    }
    // End BZ26398

    // Begin BZ26575
    /**
     * 
     * @param valueStr
     * @return
     */
    public static String convertToJsonValue(String valueStr) {

        return valueStr != null ? valueStr : "";

    }
    // End BZ26575
    
    // BEGIN BZ44528
    public static JSONObject getJSONObject(JSONArray jsonArray, int index) {
        JSONObject jsonObject = null;
        
        if (jsonArray != null && jsonArray.length() > 0 && index >= 0) {
            try {
                jsonObject = jsonArray.getJSONObject(index);
            } catch (JSONException ex) {
                logger.error("getJSONObject method " + ex.getMessage());
                //Nothing to do, return null
            }
        }
        
        return jsonObject;
    }
    // END BZ44528

}
