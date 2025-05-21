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
 * Req/Bug ID#          ddMMyy    Description
 * BZ25614              140318    [Order Service] Order Service code review
 * BZ27712              121018    [New Requirement] Order Service is not sending item attributes for Work Orders
 * BZ27971              301018    [2.9.2] Work order refund is causing a 400 error.
 * BZ37463              220820    [Task] Creating Order Service Spec for Brokered Order transaction types.
 *== ================================================================
 */

package caw.orderservice.utils;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.log4j.Logger;

import caw.orderservice.constant.CawCommonConstant;

/**
 * Define Utility 
 */
public class CawUtils {

    static final Logger              logger                  = Logger
            .getLogger(CawUtils.class);

    public static final String       NULL_TEXT               = "null";

    public static final String       UNDEFINED_TEXT          = "undefined";

    public static final String       DETERMINE_STORE_REGEX   = "???".intern();

    public static final String       DETERMINE_SEPARATE_SIGN = ";".intern();

    public static final String       NONE_TEXT               = "NONE".intern();

    public static final char         WILDCARD_STAR           = '*';

    public static final char         WILDCARD_PERCENT        = '%';

    public static final String       STRING_0                = "0";

    public static final String       STRING_1                = "1";
    
    public static final String       STRING_2                = "2"; // BZ37463

    public static final String       STRING_TRUE             = "true";

    /**
     * The singleton instance of the CawUtils class
     */
    private static volatile CawUtils instance                = null;

    /**
     * Default constructor is private
     */
    private CawUtils() {

        super();
    }

    /**
     * Returns a reference to the single instance of this object
     * 
     * @return CawUtils
     */
    public static CawUtils getInstance() {

        if (instance == null) {
            synchronized (CawUtils.class) {
                if (instance == null) {
                    instance = new CawUtils();
                }
            }
        }
        return instance;
    }

    /**
     * Convert to int
     * 
     * @param value
     * @return
     */
    public int vInt(String value) {

        return vInt(value, 0);
    }

    /**
     * Convert to int
     * 
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

        return vLong(value, 0);
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
     * @Method convert a Long value to long value
     * @param value
     * @param vdefault
     * @return
     */
    public long vLong(Long value, long vdefault) {

        return value != null ? value.longValue() : vdefault;
    }

    /**
     * Returns a copy of the string, with leading and trailing whitespace
     * omitted.
     * 
     * @param value
     * @return
     */
    public String vString(String value) {

        return vString(value, CawCommonConstant.EMPTY_STRING);
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

    /**
     * Returns a copy of the string, with leading and trailing whitespace
     * omitted.
     * 
     * @param value
     * @return
     */
    public String vString(Long value) {

        if (value != null) {
            return String.valueOf(value.longValue());
        } else {
            return CawCommonConstant.EMPTY_STRING;
        }
    }

    /**
     * Returns a copy of the string, with leading and trailing whitespace
     * omitted.
     * 
     * @param value
     * @return
     */
    public String vString(Object value) {

        if (value != null) {
            return trimText(String.valueOf(value));
        } else {
            return CawCommonConstant.EMPTY_STRING;
        }
    }

    /**
     * This method is used to convert a double type
     * 
     * @param d
     * @param type.
     *            Example: {#,##0.00}.
     * @return
     */
    public String formatDoubleNumber(double d, String typeformat) {

        if (d == 0) {
            return CawUtils.STRING_0;
        } else {
            DecimalFormat temp = new DecimalFormat(typeformat);
            String ret = temp.format(d);
            return ret;
        }
    }

    /**
     * 
     * @param value
     * @return
     */
    public String trimText(String value) {

        String res = vString(value);
        if (res != null && res.length() > 0) {
            if (NULL_TEXT.compareToIgnoreCase(res) == 0
                    || UNDEFINED_TEXT.compareToIgnoreCase(res) == 0) {
                res = CawCommonConstant.EMPTY_STRING;
            }
        }
        return res;
    }

    /**
     * 
     * @param value
     * @return
     */
    public String trimSpecialChars(String value) {

        StringBuilder result = new StringBuilder();
        char[] c = value.toCharArray();
        int len = c.length;
        for (int i = 0; i < len; i++) {
            int acsii = (int) c[i];
            if (acsii != 194)// ASCII: 194 HTML: &#194; URL: %C2
                result.append(c[i]);
        }
        return result.toString();
    }

    /**
     * Convert original character to converted character in specific string
     * 
     * @param String:
     *            wildraw
     * @param char:
     *            original
     * @param char:
     *            converted
     * @return
     */
    public String convertWildraw(String wildraw, char original,
            char converted) {

        String result = CawCommonConstant.EMPTY_STRING;
        if (wildraw != null && wildraw.length() > 0) {
            char[] array = wildraw.toCharArray();
            int len = array.length;
            for (int i = 0; i < len; i++) {
                if (array[i] == original) {
                    array[i] = converted;
                }
            }
            result = String.valueOf(array);
        }
        return result;
    }

    /**
     * Convert original character to converted character in specific string
     * 
     * @param wildraw
     * @return
     */
    public String sWildraw(String wildraw) {

        return convertWildraw(wildraw, WILDCARD_STAR, WILDCARD_PERCENT);
    }

    /**
     * Get Full Name
     * 
     * @return
     */
    public String concat(String value1, String value2) {

        StringBuilder tmp = new StringBuilder();
        if (value1 != null && value1.length() > 0) {
            tmp.append(value1);
        }
        if (value2 != null && value2.length() > 0) {
            if (tmp.length() > 0) {
                tmp.append(CawCommonConstant.SPACE);
            }
            tmp.append(value2);
        }
        return tmp.toString();
    }

    /**
     * Check String
     * 
     * @param states
     * @param stateCode
     * @return
     */
    public int findOf(String states, String stateCode) {

        if (stateCode == null || stateCode.length() == 0) {
            return -1;
        }
        if (states != null && states.length() > 0) {
            String statesTrimed = vString(states);
            String tmpStates = statesTrimed
                    .replaceAll(CawCommonConstant.SPACE, CawCommonConstant.EMPTY_STRING);
            if (CawUtils.NONE_TEXT.compareToIgnoreCase(tmpStates) == 0) {
                return -1;
            }
            String stateList = CawUtils.DETERMINE_SEPARATE_SIGN + tmpStates
                    + CawUtils.DETERMINE_SEPARATE_SIGN;
            String findTmp = CawUtils.DETERMINE_SEPARATE_SIGN + stateCode
                    + CawUtils.DETERMINE_SEPARATE_SIGN;
            return stateList.indexOf(findTmp);
        } else {
            return -1;
        }

    }

    /**
     * Convert to boolean
     * 
     * @param value
     * @param vdefault
     * @return
     */
    public boolean vBoolean(String value, boolean vdefault) {

        try {
            if (value != null && value.length() > 0) {
                if (value.equalsIgnoreCase(CawUtils.STRING_TRUE)
                        || value.equalsIgnoreCase(CawUtils.STRING_1)) {
                    return true;
                } else {
                    return false;
                }
            }
        } catch (RuntimeException ex) {
            return vdefault;
        } catch (Exception ex) {
            return vdefault;
        }
        return vdefault;
    }

    public boolean vBoolean(String value) {

        return vBoolean(value, false);
    }

    /**
     * Trim to 
     * 
     * @param value
     * @param vdefault
     * @return
     */
    public String substring(String value, int beginIndex) {

        String res = CawCommonConstant.EMPTY_STRING;
        try {
            if (value != null) {
                res = value.substring(beginIndex, value.length());
            }
        } catch (RuntimeException ex) {
            return CawCommonConstant.EMPTY_STRING;
        } catch (Exception ex) {
            return CawCommonConstant.EMPTY_STRING;
        }
        return res;
    }

    /**
     * BZ27712
     * Date to String
     * @param date
     * @return
     */
    public String convertDateToString(Date date) {

        String stringDate = CawCommonConstant.EMPTY_STRING;
        DateFormat formatter = null;
        try {
            formatter = new SimpleDateFormat(
                    CawCommonConstant.DATE_TIME_FORMAT_NOSPACE);
            stringDate = formatter.format(date);
        } catch (Exception ex) {
            logger.error("convertDateToString-0: " + ex.getMessage());
        }
        return stringDate;
    }

    /**
     * BZ27712, BZ27971
     * Build a query key
     * Format: storeID+bsnDate+regID+transSeq+lineItemSeq
     * @param storeID
     * @param bsnDate
     * @param regID
     * @param transSeq
     * @param lineItemSeq
     * @return
     */
    public String queryKeyFormat(String prefixCode, String storeID,
            Timestamp bsnDate, String regID, String transSeq,
            String lineItemSeq) {

        StringBuilder sb = new StringBuilder();
        try {
            String storeIdFormated = storeID
                    .replaceFirst(CawCommonConstant.PREFIX_ZERO, CawCommonConstant.EMPTY_STRING);
            String regIdFormated = regID
                    .replaceFirst(CawCommonConstant.PREFIX_ZERO, CawCommonConstant.EMPTY_STRING);
            String transSeqFormated = transSeq
                    .replaceFirst(CawCommonConstant.PREFIX_ZERO, CawCommonConstant.EMPTY_STRING); //BZ27971
            sb.append(prefixCode).append(storeIdFormated)
                    .append(convertDateToString(bsnDate)).append(regIdFormated)
                    .append(transSeqFormated).append(lineItemSeq);
        } catch (Exception ex) {
            logger.error("queryKeyFormat-0: " + ex.getMessage());
        }
        return sb.toString();
    }
}
