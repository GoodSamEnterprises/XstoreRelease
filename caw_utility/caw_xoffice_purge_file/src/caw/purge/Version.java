package caw.purge;

/**
 * The Class Version.
 */
public class Version {

	/** The Constant VERSION. */
	private static final String VERSION = "3.0.0.0";

	/** The Constant CUSTOMER_VERSION. */
	private static final String CUSTOMER_VERSION = "0.0.0";

	/** The Constant BUILD_DATE. */
	private static final String BUILD_DATE = "2020-05-28T13:30PM";

	/** The Constant BUG_NUMBER. */
	private static final String BUG_NUMBER = "BZ-36145";

	/**
	 * Gets the builds the date impl.
	 *
	 * @return the builds the date impl
	 */
	public String getBuildDateImpl() {
		return BUILD_DATE;
	}

	/**
	 * Gets the customer version impl.
	 *
	 * @return the customer version impl
	 */
	public String getCustomerVersionImpl() {
		return CUSTOMER_VERSION;
	}

	/**
	 * Gets the base version.
	 *
	 * @return the base version
	 */
	public String getBaseVersion() {
		return VERSION;
	}

	public String getBugNumber() {
		return BUG_NUMBER;
	}
}
