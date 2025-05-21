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
 * BZ25640          051518    New Requirement - Used Firearm System Process Redesign
 *===================================================================
 */

package caw.pos.register.ufa;

import java.math.BigDecimal;

import dtv.pos.common.PromptKey;

public class CawUFAConstants {

    private static final String             UFA_REASON_TYPE_CODE        = "PAID_OUT_UFA";

    public static final String              UFA_REASON_CODE             = "PO12";

    public static final String              PROPERTY_TYPE               = "STRING";

    public static final String              PROPERTY_EBS_ITEM_CODE      = "EBS_ITEM_CODE";

    public static final String              PROPERTY_ETRACK_ID          = "ETRACK_ID";

    public static final String              PROPERTY_UFA_DETAIL         = "UFA_DETAIL";

    public static final String              IND_COMMENT_REQUIRED        = "REQUIRED";

    public static final String              DOLLAR_SIGN                 = "$";

    public static final PromptKey           PAID_OUT_UFA_NOTIFY_PROMPT  = PromptKey
            .valueOf("PAID_OUT_UFA_NOTIFY");

    public static final PromptKey           PAID_OUT_UFA_COMMENT_PROMPT = PromptKey
            .valueOf("PAID_OUT_COMMENT");

    /**
     * The singleton instance of the CawUFAConstants class
     */
    private static volatile CawUFAConstants instance                    = null;

    private CawUFAConstants() {

        super();
    }

    /**
     * Returns a reference to the single instance of this object
     * 
     * @return CawUFAConstants
     */
    public static CawUFAConstants getInstance() {

        if (instance == null) {
            synchronized (CawUFAConstants.class) {
                if (instance == null) {
                    instance = new CawUFAConstants();
                }
            }
        }
        return instance;
    }

    /**
     * Get UFA Reason Type Code from system properties
     * @return
     */
    public static String getDefaultUAFReasonTypeCode() {

        String code = null;
        try {
            code = System.getProperty("caw.pos.ufa.reason.typecode");
            if (code == null || code.length() == 0) {
                code = UFA_REASON_TYPE_CODE;
            }
        } catch (Exception ex) {
            code = UFA_REASON_TYPE_CODE;
        }
        return code;
    }

    /**
     * Get UFA Reason Code from system properties
     * @return
     */
    public static String getDefaultUAFReasonCode() {

        String code = null;
        try {
            code = System.getProperty("caw.pos.ufa.reason.code");
            if (code == null || code.length() == 0) {
                code = UFA_REASON_CODE;
            }
        } catch (Exception ex) {
            code = UFA_REASON_CODE;
        }
        return code;
    }

    /**
     * Convert to int
     * @param value
     * @return
     */
    public int vInt(String value) {

        return vInt(value, 0);
    }

    /**
     * Convert to int
     * @param value
     * @param vdefault
     * @return
     */
    public int vInt(String value, int vdefault) {

        try {
            if (value != null && value.length() > 0) {
                return Integer.parseInt(value.trim());
            }
        } catch (RuntimeException ex) {
            return vdefault;
        } catch (Exception ex) {
            return vdefault;
        }
        return vdefault;
    }

    /**
     * Convert a String to long
     * 
     * @param value
     * @param vdefault
     * @return
     */
    public long vLong(String value, long vdefault) {

        try {
            if (value != null && value.length() > 0) {
                return Long.parseLong(value.trim());
            }
        } catch (Exception ex) {
            return vdefault;
        }
        return vdefault;
    }

    /**
     * Convert a String to long
     * 
     * @param value
     * @return
     */
    public long vLong(String value) {

        return vLong(value, 0l);
    }

    /**
     * Check a text in number format
     * 
     * @param text
     * @return
     */
    public boolean isNumber(String text) {

        return text.matches("[0-9]*.?[0-9]+");

    }

    /**
     * Convert a String to Double
     * 
     * @param value
     * @param vdefault
     * @return
     */
    public double vDouble(String value) {

        try {
            if (value != null && value.length() > 0) {
                return Double.parseDouble(value.trim());
            }
        } catch (Exception ex) {
            return Double.valueOf(0l);
        }
        return Double.valueOf(0l);
    }

    /**
     * Convert a String to BigDecimal
     * 
     * @param value
     * @param vdefault
     * @return
     */
    public BigDecimal vBigDecimal(String value) {

        try {
            if (value != null && value.length() > 0) {
                return BigDecimal.valueOf(vDouble(value));
            }
        } catch (Exception ex) {
            return BigDecimal.valueOf(0l);
        }
        return BigDecimal.valueOf(0l);
    }

    /**
     * @Method vBigDecimal: convert a Double value to BigDecimal value
     * @param value
     * @param vdefault
     * @return
     */
    public BigDecimal vBigDecimal(Double value) {

        return value != null ? BigDecimal.valueOf(value.doubleValue())
                : BigDecimal.valueOf(0L);
    }

    /**
     * @Method vBigDecimal: convert a Integer value to BigDecimal value
     * @param value
     * @param vdefault
     * @return
     */
    public BigDecimal vBigDecimal(Integer value) {

        return value != null ? BigDecimal.valueOf(value.doubleValue())
                : BigDecimal.valueOf(0L);
    }

    /**
     * 
     * @param point
     *            : parameter indicate the start point 0: beginning of string 1:
     *            ending of string
     * 
     * @param num
     *            : number of character to get
     * @param sOrigin
     *            : original string to get substring
     * @return String
     */
    public static String getSubString(int orient, int num, String sOrigin) {

        String rs = null;
        try {
            String origin;
            if (sOrigin != null && sOrigin.length() > 0) {
                origin = sOrigin;
            } else {
                origin = "";
            }
            int num1 = origin.length();
            if (num1 < num) {
                StringBuilder sb = new StringBuilder();
                for (int i = 0; i < num - num1; i++) {
                    sb.append("0");
                }
                sb.append(origin);
                rs = sb.toString();

            } else {

                if (orient == 0) {
                    // Start from beginning of string
                    rs = origin.substring(0, num);
                } else {
                    // Start from ending of string
                    rs = origin.substring(num1 - num, num1);
                }
            }
        } catch (RuntimeException ex) {
            rs = "0";
        } catch (Exception ex) {
            rs = "0";
        }
        return rs;
    }

    /**
     * Returns a copy of the string, with leading and trailing whitespace
     * omitted.
     * 
     * @param value
     * @return
     */
    public String vString(String value) {

        return vString(value, "");
    }

    /**
     * Returns a copy of the string, with leading and trailing whitespace
     * omitted.
     * 
     * @param value
     * @return
     */
    public String vString(String value, String defaultValue) {

        if (value != null && value.length() > 0) {
            return value.trim();
        } else {
            return defaultValue;
        }
    }
}
