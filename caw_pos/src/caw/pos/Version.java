package caw.pos;

import java.util.Date;

import dtv.util.DateUtils;

/**
 * A class which reports version information for the base customer overlay.<br>
 * <br>
 * Copyright (c) 2007 Datavantage Corporation
 * 
 * @author jweiss
 * @created Jun 1, 2007
 * @version $Revision: 260256 $
 */
public class Version
    extends dtv.pos.Version {

  private static final String CUSTOMER_VERSION = "7.0.37";
  private static final String PATCH_VERSION = "2.79";
  private static final String BUILD_DATE = "2025-04-29T11:53:57-0500";

  /** {@inheritDoc} */
  @Override
  protected Date getCustomerBuildDateImpl() {
    return DateUtils.parseIso(BUILD_DATE);
  }

  /** {@inheritDoc} */
  @Override
  protected String getCustomerVersionImpl() {
    return CUSTOMER_VERSION;
  }

  /** {@inheritDoc} */
  @Override
  protected String getPatchVersionImpl() {
    return PATCH_VERSION;
  }
}
