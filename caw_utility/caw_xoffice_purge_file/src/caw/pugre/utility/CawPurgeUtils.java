package caw.pugre.utility;

import java.math.BigDecimal;
import java.text.DecimalFormat;

import org.apache.log4j.Logger;

/**
 * Define Utility
 */
public class CawPurgeUtils {

	static final Logger logger = Logger.getLogger(CawPurgeUtils.class);

	public static final String NULL_TEXT = "null";

	public static final String UNDEFINED_TEXT = "undefined";

	public static final String DETERMINE_STORE_REGEX = "???".intern();

	public static final String DETERMINE_SEPARATE_SIGN = ";".intern();

	public static final String NONE_TEXT = "NONE".intern();

	public static final char WILDCARD_STAR = '*';

	public static final char WILDCARD_PERCENT = '%';

	public static final String STRING_0 = "0";

	public static final String STRING_1 = "1";

	public static final String STRING_TRUE = "true";

	public static final String EMPTY_TEXT = "";

	public static final String PREFIX_ZERO = "^0+(?!$)";

	public static final String FORMAT_YYYYMMDD = "yyyMMdd";

	private static volatile CawPurgeUtils INSTANCE = null;

	/**
	 * Returns a reference to the single instance of this object
	 * 
	 * @return CmcUtils
	 */
	public static CawPurgeUtils getInstance() {

		if (INSTANCE == null) {
			synchronized (CawPurgeUtils.class) {
				if (INSTANCE == null) {
					INSTANCE = new CawPurgeUtils();
				}
			}
		}
		return INSTANCE;
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

		return value != null ? BigDecimal.valueOf(value.doubleValue()) : BigDecimal.valueOf(0L);
	}

	/**
	 * @Method vBigDecimal: convert a Integer value to BigDecimal value
	 * @param value
	 * @param vdefault
	 * @return
	 */
	public BigDecimal vBigDecimal(Integer value) {

		return value != null ? BigDecimal.valueOf(value.doubleValue()) : BigDecimal.valueOf(0L);
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
	 * Returns a copy of the string, with leading and trailing whitespace omitted.
	 * 
	 * @param value
	 * @return
	 */
	public String vString(String value) {

		return vString(value, EMPTY_TEXT);
	}

	/**
	 * Returns a copy of the string, with leading and trailing whitespace omitted.
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
	 * Returns a copy of the string, with leading and trailing whitespace omitted.
	 * 
	 * @param value
	 * @return
	 */
	public String vString(Long value) {

		if (value != null) {
			return String.valueOf(value.longValue());
		} else {
			return EMPTY_TEXT;
		}
	}

	/**
	 * Returns a copy of the string, with leading and trailing whitespace omitted.
	 * 
	 * @param value
	 * @return
	 */
	public String vString(Object value) {

		if (value != null) {
			return trimText(String.valueOf(value));
		} else {
			return EMPTY_TEXT;
		}
	}

	/**
	 * This method is used to convert a double type
	 * 
	 * @param d
	 * @param type. Example: {#,##0.00}.
	 * @return
	 */
	public String formatDoubleNumber(double d, String typeformat) {

		if (d == 0) {
			return CawPurgeUtils.STRING_0;
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
			if (NULL_TEXT.compareToIgnoreCase(res) == 0 || UNDEFINED_TEXT.compareToIgnoreCase(res) == 0) {
				res = EMPTY_TEXT;
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
	 * @param String: wildraw
	 * @param char:   original
	 * @param char:   converted
	 * @return
	 */
	public String convertWildraw(String wildraw, char original, char converted) {

		String result = EMPTY_TEXT;
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
	 * Convert to boolean
	 * 
	 * @param value
	 * @param vdefault
	 * @return
	 */
	public boolean vBoolean(String value, boolean vdefault) {

		try {
			if (value != null && value.length() > 0) {
				if (value.equalsIgnoreCase(CawPurgeUtils.STRING_TRUE)
						|| value.equalsIgnoreCase(CawPurgeUtils.STRING_1)) {
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

		String res = EMPTY_TEXT;
		try {
			if (value != null) {
				res = value.substring(beginIndex, value.length());
			}
		} catch (RuntimeException ex) {
			return EMPTY_TEXT;
		} catch (Exception ex) {
			return EMPTY_TEXT;
		}
		return res;
	}

}
