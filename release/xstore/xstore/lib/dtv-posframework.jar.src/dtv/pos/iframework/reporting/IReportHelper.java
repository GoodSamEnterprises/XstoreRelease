package dtv.pos.iframework.reporting;

import dtv.barcode.BarcodeTextType;
import dtv.barcode.BarcodeType;
import dtv.i18n.FormatterType;
import dtv.util.address.IAddress;
import java.awt.Image;
import java.math.BigDecimal;
import java.text.ParseException;
import java.util.Date;

public interface IReportHelper {
  String applyMask(String paramString, Object paramObject) throws ParseException;
  
  String coalesce(Object... paramVarArgs);
  
  String coalesceEmpty(Object... paramVarArgs);
  
  String decrypt(String paramString1, String paramString2);
  
  String format(Object paramObject);
  
  String format(Object paramObject, FormatterType paramFormatterType);
  
  String format(Object paramObject, String paramString);
  
  String formatAddress(IAddress paramIAddress);
  
  String formatDate(Date paramDate);
  
  String formatDateTime(Date paramDate);
  
  String formatDecimal(BigDecimal paramBigDecimal);
  
  String formatDecimal(BigDecimal paramBigDecimal, int paramInt);
  
  String formatForAccounting(BigDecimal paramBigDecimal);
  
  String formatForAccountingWithRounding(BigDecimal paramBigDecimal);
  
  String formatMoney(BigDecimal paramBigDecimal);
  
  String formatPercent(BigDecimal paramBigDecimal);
  
  String formatPhoneNumber(String paramString);
  
  String formatTime(Date paramDate);
  
  byte[] getBarcode(String paramString, BarcodeType paramBarcodeType, BarcodeTextType paramBarcodeTextType, int paramInt1, int paramInt2);
  
  Boolean getBoolean(String... paramVarArgs);
  
  String getCodeEnumDesc(String paramString1, String paramString2);
  
  Image getImage(String paramString);
  
  String getLastFirstName(String paramString1, String paramString2);
  
  BigDecimal getLocalCurrencyAmount(BigDecimal paramBigDecimal, String paramString, long paramLong);
  
  String maskSerialNumber(String paramString);
  
  BigDecimal nonNull(BigDecimal paramBigDecimal);
  
  String nonNull(String paramString);
  
  BigDecimal sum(BigDecimal... paramVarArgs);
  
  BigDecimal sum(Iterable<BigDecimal> paramIterable);
  
  String translate(String paramString, String... paramVarArgs);
  
  String translateLiteral(String paramString);
  
  String translateSafe(String paramString1, String paramString2, String... paramVarArgs);
}


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-posframework.jar!\dtv\pos\iframework\reporting\IReportHelper.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */