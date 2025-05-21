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
 * BZ23052          160917    Implement Advanced Prompting
 * BZ23479          220917    Add new parameter (EBS_ENABLE) to ON/OFF call to EBS Web Service
 * BZ24424          131117    "RA membership validation" prompt does not display for RA JOIN when you select "1-Year join (w/Auto Renew) - $69.95"
 * BZ26575          140618    [QAS] Update address verification flow to reduce the number of click in the QAS process
 * BZ26270          060718    New Requirement - Display UPC on both Xstore screens and on receipts
 * BZ25958          020818    New Requirement - Remove Gift Card transactions from the Pin Pad
 * BZ26978          060818    Gift Card Receipt not printing for activation/reload
 * BZ27712          121018    [New Requirement] Order Service is not sending item attributes for Work Orders
 * BZ25761          121018    New Requirement - Acquisition of Private Label Credit Card integration in Xstore
 * BZ29535          260219    [Internal] Good Sam Account Inquiry Screen/Form does not display amounts and due date.
 * BZ44528          190821    Electric World & Mobile POS Implementation(Phase 1)
 * BZ48401          210222    [Task] Apply Reward to Redeem in Sales Transaction  
 *===================================================================
 */

package caw.pos.common;

import java.math.BigDecimal;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.*;
import java.time.format.DateTimeFormatter;
import java.util.*;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import caw.pos.tender.voucher.CawVoucherBalanceReloadActiveInfo;

import dtv.i18n.IFormattable;
import dtv.util.crypto.EncString;

/**
 * Collection common function. 
 * The class is used to define static methods
 * relating to common utilities in java.
 */
public class CawUtilFunction {

    private static final Logger _logger = LogManager.getLogger(CawUtilFunction.class);

    /**
     * Convert String to Date with format MM/dd/yyyy
     * @param date
     * @return date
     */
    public static Date formatDateMMDDYYY(String date) {

        Date startDate = null;
        DateFormat df = new SimpleDateFormat(CawConstants.MM_DD_YYYY);
        try {
            startDate = df.parse(date);
        } catch (Exception ex) {
            /* BEGIN BZ29535 */
            if (ex instanceof java.text.ParseException) {
                try {
                    DateTimeFormatter formatter = DateTimeFormatter.BASIC_ISO_DATE;
                    LocalDate localDate = LocalDate.parse(date, formatter);
                    startDate = Date.from(localDate.atStartOfDay(ZoneId.systemDefault()).toInstant());
                } catch (Exception ex1) {
                    _logger.error("Can not parse date." + ex.getMessage());
                }
            }
            /* END BZ29535 */
        }

        return startDate;
    }
    
    /* BEGIN BZ44528: Phase 1 */

    public static Date getPreviousYearStart(Date date) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.add(Calendar.YEAR, -1);
        
        return getYearStart(cal.getTime());
    }
    
    public static Date getPreviousYearEnd(Date date) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.add(Calendar.YEAR, -1);
        
        return getYearEnd(cal.getTime());
    }
    
    public static Date getPreviousQuarterStart(Date date) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.add(Calendar.MONTH, -3);
        
        return getQuarterStart(cal.getTime());
    }
    
    public static Date getPreviousQuarterEnd(Date date) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.add(Calendar.MONTH, -3);
        
        return getQuarterEnd(cal.getTime());
    }
    
    public static Date getPreviousMonthStart(Date date) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.add(Calendar.MONTH, -1);
        
        return getMonthStart(cal.getTime());
    }
    
    public static Date getPreviousMonthEnd(Date date) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.add(Calendar.MONTH, -1);
        
        return getMonthEnd(cal.getTime());
    }
    
    public static Date getPreviousWeekStart(Date date) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.add(Calendar.DATE, -7);
        
        return getWeekStart(cal.getTime());
    }
    
    public static Date getPreviousWeekEnd(Date date) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.add(Calendar.DATE, -7);
        
        return getWeekEnd(cal.getTime());
    }
    
    public static Date getYesterday(Date date) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.add(Calendar.DATE, -1);
        
        return cal.getTime();
    }
    
    public static Date getYearStart(Date date) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.set(Calendar.DAY_OF_YEAR, Calendar.getInstance().getActualMinimum(Calendar.DAY_OF_YEAR));
        
        return cal.getTime();
    }
    
    public static Date getYearEnd(Date date) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.set(Calendar.DAY_OF_YEAR, Calendar.getInstance().getActualMaximum(Calendar.DAY_OF_YEAR));

        return cal.getTime();
    }
    
    public static Date getQuarterStart(Date date) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.set(Calendar.DAY_OF_MONTH, 1);
        cal.set(Calendar.MONTH, cal.get(Calendar.MONTH)/3 * 3);
        return cal.getTime();
    }

    public static Date getQuarterEnd(Date date) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.set(Calendar.DAY_OF_MONTH, 1);
        cal.set(Calendar.MONTH, cal.get(Calendar.MONTH)/3 * 3 + 2);
        cal.set(Calendar.DAY_OF_MONTH, cal.getActualMaximum(Calendar.DAY_OF_MONTH));
        return cal.getTime();
    }
    
    public static Date getMonthStart(Date date) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.set(Calendar.DAY_OF_MONTH, Calendar.getInstance().getActualMinimum(Calendar.DAY_OF_MONTH));

        return cal.getTime();
    }
    
    public static Date getMonthEnd(Date date) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.set(Calendar.DAY_OF_MONTH, Calendar.getInstance().getActualMaximum(Calendar.DAY_OF_MONTH));

        return cal.getTime();
    }
    
    public static Date getWeekStart(Date date) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.set(Calendar.DAY_OF_WEEK, Calendar.getInstance().getActualMinimum(Calendar.DAY_OF_WEEK));

        return cal.getTime();
    }
    
    public static Date getWeekEnd(Date date) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.set(Calendar.DAY_OF_WEEK, Calendar.getInstance().getActualMaximum(Calendar.DAY_OF_WEEK));

        return cal.getTime();
    }
    
    /**
     * Convert String to Date with format dd/MM/yyyy
     * @param date
     * @return date
     */
    public static Date formatDateDDMMYYYY(String date) {

        Date startDate = null;
        DateFormat df = new SimpleDateFormat(CawConstants.DD_MM_YYYY);
        try {
            startDate = df.parse(date);
        } catch (Exception ex) {
            if (ex instanceof java.text.ParseException) {
                try {
                    DateTimeFormatter formatter = DateTimeFormatter.BASIC_ISO_DATE;
                    LocalDate localDate = LocalDate.parse(date, formatter);
                    startDate = Date.from(localDate.atStartOfDay(ZoneId.systemDefault()).toInstant());
                } catch (Exception ex1) {
                    _logger.error("Can not parse date." + ex.getMessage());
                }
            }
        }

        return startDate;
    }
    /* END BZ44528: Phase 1 */

    // Begin BZ24424
    /**
     * The function convert the current date to string format MM/dd/YYYY
     * @return
     */
    public static String convertDateFormatMMDDYYY(Date date) {

        String dateFormatStr = null;
        if (date != null) {
            try {
                DateFormat formater = new SimpleDateFormat(CawConstants.MM_DD_YYYY);
                dateFormatStr = formater.format(date);
            } catch (Exception ex) {
                _logger.error("Can not parse date to string." + ex.getMessage());
            }
        }
        return dateFormatStr;
    }

    /**
     * The function get the current date add more number day.
     * @param dayNumber
     * @return
     */
    public static Date getCurrentDateAddDayNumber(int dayNumber) {

        Date date = null;
        try {
            Date dt = new Date();
            Calendar c = Calendar.getInstance();
            c.setTime(dt);
            c.add(Calendar.DATE, dayNumber);
            date = c.getTime();
        } catch (Exception ex) {
            _logger.error("Can not get the current date add number date" + ex.getMessage());
        }

        return date;

    }
    // End BZ24424

    /**
     * See value in system.properties
     * @param key
     * @param vDefault
     * @return
     */
    public static String getSystemProperty(String key, String vDefault) {

        return CawPropertyUtils.getSystemProperty(key, vDefault);
    }

    /**
     * Convert to int
     * 
     * @param value
     * @param vdefault
     * @return
     */
    public static int vInt(String value, int vdefault) {

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

    public static int vInt(String value) {

        return vInt(value, 0);
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
    public static long vLong(String value) {

        return vLong(value, 0l);
    }

    /**
     * Returns a copy of the string, with leading and trailing whitespace
     * omitted.
     * 
     * @param value
     * @return
     */
    public static String vString(String value) {

        return vString(value, CawConstants.EMPTY_SIGN);
    }

    /**
     * Returns a copy of the string, with leading and trailing whitespace
     * omitted.
     * 
     * @param value
     * @return
     */
    public static String vString(String value, String defaultValue) {

        if (value != null && value.length() > 0) {
            return value.trim();
        } else {
            return defaultValue;
        }
    }

    /**
     * 
     * @param value
     * @return
     */
    public static String trimText(String value) {

        String res = vString(value);
        if (res != null && res.length() > 0) {
            if (CawConstants.NULL_TEXT.compareToIgnoreCase(res) == 0
                    || CawConstants.UNDEFINED_TEXT.compareToIgnoreCase(res) == 0) {
                res = CawConstants.EMPTY_SIGN;
            }
        }
        return res;
    }

    /**
     * Returns a copy of the string, with leading and trailing whitespace
     * omitted.
     * 
     * @param value
     * @return
     */
    public static String vString(Long value) {

        if (value != null) {
            return String.valueOf(value.longValue());
        } else {
            return CawConstants.EMPTY_SIGN;
        }
    }

    /**
     * Returns a copy of the string, with leading and trailing whitespace
     * omitted.
     * 
     * @param value
     * @return
     */
    public static String vString(Object value) {

        if (value != null) {
            return trimText(String.valueOf(value));
        } else {
            return CawConstants.EMPTY_SIGN;
        }
    }

    /**
     * Convert a String to BigDecimal
     * 
     * @param value
     * @return
     */
    public static BigDecimal vBigDecimal(String value, BigDecimal vdefault) {

        try {
            if (value != null && value.length() > 0) {
                return new BigDecimal(value.trim());
            }
        } catch (Exception ex) {
            return vdefault;
        }
        return vdefault;
    }

    public static BigDecimal vBigDecimal(String value) {

        return vBigDecimal(value, BigDecimal.ZERO);
    }

    /**
     * BZ26575 moved to here
     * @param in
     * @return
     */
    public static String sanitizeXmlChars(String in) {

        StringBuilder out = new StringBuilder();
        char current;

        if (in == null || (CawJSONConstant.SPACE_CHARACTER.equals(in))) {
            return CawJSONConstant.SPACE_CHARACTER;
        }
        for (int i = 0; i < in.length(); i++) {
            current = in.charAt(i);
            if ((current == 0x9) || (current == 0xA) || (current == 0xD) || ((current >= 0x20) && (current <= 0xD7FF))
                    || ((current >= 0xE000) && (current <= 0xFFFD))
                    || ((current >= 0x10000) && (current <= 0x10FFFF))) {
                out.append(current);
            }
        }
        return out.toString();
    }

    /**
     * BZ26575 moved to this class
     * @param argString
     * @return
     */
    public static String formatParameter(String argString) {

        return argString != null ? "\"" + argString + "\"" : CawConstants.NULL_TEXT; //From GoodsamVisa
    }

    /**
     * Added BZ23479
     * @return
     */
    public static boolean allowEBSConnection() {

        return CawPropertyUtils.allowEBSConnect();
    }

    /**
     * BZ25958 formated with <6degits>*<4degits>
     * @param o
     * @param mask
     * @return
     */
    public static String formatSerialGCWithMask(Object o, String mask) {

        if (o == null) {
            return CawConstants.EMPTY_SIGN;
        } else {
            StringBuilder sb = new StringBuilder(EncString.getSensitiveData(o));
            int length = sb.length() - 4;
            for (int i = 6; i < length; i++) {
                // BZ25958: Mask all but the last 4 characters regardless if a digit or not
                sb.replace(i, i + 1, mask);
            }

            if (sb.length() > 20) {
                // BZ25958: Get mask field 20 characters
                return sb.substring(sb.length() - 20);
            }
            return sb.toString();
        }
    }

    /**
     * BZ25958 formated for Voucher Card Number
     * @param maskAccNum
     * @return
     */
    public static String maskVCardNbr(String maskAccNum) {

        StringBuffer buf = new StringBuffer();
        if (maskAccNum != null && maskAccNum.length() == 19) {
            buf.append(maskAccNum.substring(0, 6));
            buf.append("*********");
            buf.append(maskAccNum.substring(15, 19));
        }
        return buf.toString();
    }

    /**
     * BZ26978 The function modifier Gift Card Receipt 
     * @param balanceReloadActiveInfos
     * @param argActiveInfo
     * @return
     */
    public static List<CawVoucherBalanceReloadActiveInfo> modifierGiftCardReceiptInfo(
            List<CawVoucherBalanceReloadActiveInfo> balanceReloadActiveInfos,
            CawVoucherBalanceReloadActiveInfo giftCardInfo) {

        if (giftCardInfo != null) {
            if (balanceReloadActiveInfos != null && balanceReloadActiveInfos.size() > 0) {
                balanceReloadActiveInfos.add(giftCardInfo);
                return balanceReloadActiveInfos;
            } else {
                List<CawVoucherBalanceReloadActiveInfo> balanceInfos = new ArrayList<CawVoucherBalanceReloadActiveInfo>();
                balanceInfos.add(giftCardInfo);
                return balanceInfos;
            }
        }

        return null;

    }

    /**
     * Format string to date.
     * @param inputDate
     * @return date
     */
    public static Date formatDateTime(String inputDate) {

        DateTimeFormatter formatter = DateTimeFormatter.ISO_LOCAL_DATE_TIME;
        LocalDateTime localDate = LocalDateTime.parse(inputDate, formatter);
        Date date = Date.from(localDate.atZone(ZoneId.systemDefault()).toInstant());

        return date;
    }

    /**
     * BZ27712
     * Build a query key
     * Format: storeID+bsnDate+regID+transSeq+lineItemSeq
     * @param storeID
     * @param bsnDate
     * @param regID
     * @param transSeq
     * @param lineItemSeq
     * @return
     */
    public static String queryKeyFormat(String prefixCode, long storeID, Date bsnDate, long regID, long transSeq,
            int lineItemSeq) {

        StringBuilder sb = new StringBuilder();
        try {
            DateFormat formatter = new SimpleDateFormat(CawConstants.DATE_TIME_FORMAT_NOSPACE);

            sb.append(prefixCode).append(storeID).append(formatter.format(bsnDate)).append(regID).append(transSeq)
                    .append(lineItemSeq);
        } catch (Exception ex) {
            _logger.error("queryKeyFormat-0: " + ex.getMessage());
        }
        return sb.toString();
    }

    /**
     * BZ25761
     * @param argsInput
     * @return
     */
    public static IFormattable[] promptArgs(IFormattable... argsInput) {

        List<IFormattable> args = new ArrayList<>();
        for (IFormattable arg : argsInput) {
            args.add(arg);
        }
        IFormattable[] argsArray = new IFormattable[args.size()];
        return args.toArray(argsArray);
    }

    /*BEGIN BZ48401*/
    public static Date formatDate(String date, String format) {

        Date startDate = null;
        DateFormat df = new SimpleDateFormat(format);
        try {
            startDate = df.parse(date);
        } catch (Exception ex) {
            if (ex instanceof java.text.ParseException) {
                try {
                    DateTimeFormatter formatter = DateTimeFormatter.BASIC_ISO_DATE;
                    LocalDate localDate = LocalDate.parse(date, formatter);
                    startDate = Date.from(localDate.atStartOfDay(ZoneId.systemDefault()).toInstant());
                } catch (Exception ex1) {
                    _logger.error("Can not parse date." + ex.getMessage());
                }
            }
        }

        return startDate;
    }
    /*END BZ48401*/
}
