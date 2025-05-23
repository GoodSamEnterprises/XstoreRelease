package dtv.pos.iframework.ui.config;

import dtv.util.config.ParameterConfig;
import java.math.BigDecimal;

public interface IEditFormatterParams {
  public static final String MAX_CHARS = "maxCharacters";
  
  public static final String REGEX_POLICY = "regexPolicy";
  
  public static final String MAX_INT_DIGITS = "maximumIntegerDigits";
  
  public static final String MAX_FRACT_DIGITS = "maximumFractionalDigits";
  
  public static final String ALLOW_NEGATIVES = "allowNegative";
  
  public static final String ALLOW_NULL = "allowNull";
  
  public static final String MAX_ALLOWED_VALUE = "maximumAllowedValue";
  
  public static final String MIN_ALLOWED_VALUE = "minimumAllowedValue";
  
  Boolean getAllowNegative();
  
  Boolean getAllowNull();
  
  ParameterConfig[] getConfigs();
  
  Integer getMaxCharacters();
  
  BigDecimal getMaximumAllowedValue();
  
  Integer getMaximumFractionalDigits();
  
  Integer getMaximumIntegerDigits();
  
  BigDecimal getMinimumAllowedValue();
  
  String getRegexPolicy();
  
  boolean hasChanges();
  
  void setAllowNegative(Boolean paramBoolean);
  
  void setAllowNull(Boolean paramBoolean);
  
  void setMaxCharacters(Integer paramInteger);
  
  void setMaximumAllowedValue(BigDecimal paramBigDecimal);
  
  void setMaximumFractionalDigits(Integer paramInteger);
  
  void setMaximumIntegerDigits(Integer paramInteger);
  
  void setMinimumAllowedValue(BigDecimal paramBigDecimal);
  
  void setRegexPolicy(String paramString);
}


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-posframework.jar!\dtv\pos\iframewor\\ui\config\IEditFormatterParams.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */