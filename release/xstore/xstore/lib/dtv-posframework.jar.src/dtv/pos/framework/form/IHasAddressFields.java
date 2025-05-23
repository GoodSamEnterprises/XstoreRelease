package dtv.pos.framework.form;

public interface IHasAddressFields {
  public static final String ADDRESS1_FIELD = "address1";
  
  public static final String ADDRESS2_FIELD = "address2";
  
  public static final String ADDRESS3_FIELD = "address3";
  
  public static final String ADDRESS4_FIELD = "address4";
  
  public static final String APARTMENT_FIELD = "apartment";
  
  public static final String CITY_FIELD = "city";
  
  public static final String STATE_FIELD = "state";
  
  public static final String POSTAL_CODE_FIELD = "postalCode";
  
  public static final String COUNTRY_FIELD = "country";
  
  public static final String NEIGHBORHOOD_FIELD = "neighborhood";
  
  public static final String COUNTY_FIELD = "county";
  
  String getAddressField(String paramString);
  
  String getAddressMode();
}


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-posframework.jar!\dtv\pos\framework\form\IHasAddressFields.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */