/*     */ package dtv.pos.framework.reporting.fill;
/*     */ 
/*     */ import dtv.barcode.BarcodeFactory;
/*     */ import dtv.barcode.BarcodeInfo;
/*     */ import dtv.barcode.BarcodeTextType;
/*     */ import dtv.barcode.BarcodeType;
/*     */ import dtv.barcode.IBarcodeFactory;
/*     */ import dtv.barcode.IBarcodeInfo;
/*     */ import dtv.i18n.FormattableFactory;
/*     */ import dtv.i18n.FormatterFactory;
/*     */ import dtv.i18n.FormatterType;
/*     */ import dtv.i18n.IFormattable;
/*     */ import dtv.i18n.IFormatter;
/*     */ import dtv.i18n.OutputContextType;
/*     */ import dtv.i18n.TranslationHelper;
/*     */ import dtv.pos.common.ConfigurationMgr;
/*     */ import dtv.pos.iframework.reporting.IReportHelper;
/*     */ import dtv.pos.ui.text.formatter.DtvMaskFormatter;
/*     */ import dtv.ui.UIResourceManager;
/*     */ import dtv.util.IName;
/*     */ import dtv.util.MutableString;
/*     */ import dtv.util.NumberUtils;
/*     */ import dtv.util.ObjectUtils;
/*     */ import dtv.util.StringUtils;
/*     */ import dtv.util.address.IAddress;
/*     */ import dtv.util.crypto.DtvDecrypter;
/*     */ import dtv.xst.daocommon.ExchangeRateHelper;
/*     */ import java.awt.Image;
/*     */ import java.awt.image.BufferedImage;
/*     */ import java.awt.image.DataBufferByte;
/*     */ import java.lang.reflect.Method;
/*     */ import java.math.BigDecimal;
/*     */ import java.math.RoundingMode;
/*     */ import java.text.ParseException;
/*     */ import java.util.ArrayList;
/*     */ import java.util.Date;
/*     */ import java.util.List;
/*     */ import org.apache.log4j.Logger;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class ReportHelper
/*     */   implements IReportHelper
/*     */ {
/*  48 */   public static final String SYSTEM_PROPERTY = ReportHelper.class.getName();
/*     */   
/*     */   private static final IReportHelper INSTANCE;
/*     */   
/*  52 */   private static final Logger logger_ = Logger.getLogger(ReportHelper.class);
/*     */   
/*  54 */   private static final FormattableFactory FF = FormattableFactory.getInstance();
/*     */   
/*     */   static {
/*  57 */     IReportHelper instance = null;
/*     */     
/*     */     try {
/*  60 */       instance = (IReportHelper)Class.forName(System.getProperty(SYSTEM_PROPERTY)).newInstance();
/*     */     }
/*  62 */     catch (Throwable ex) {
/*  63 */       instance = new ReportHelper();
/*     */     } 
/*  65 */     INSTANCE = instance;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static IReportHelper getInstance() {
/*  74 */     return INSTANCE;
/*     */   }
/*     */ 
/*     */   
/*  78 */   private final IBarcodeFactory barcodeFactory_ = BarcodeFactory.getInstance();
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String applyMask(String argMask, Object argValue) throws ParseException {
/*  90 */     MutableString mask = new MutableString(argMask);
/*  91 */     DtvMaskFormatter formatter = new DtvMaskFormatter(null, mask);
/*  92 */     return formatter.valueToString(argValue);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public String coalesce(Object... argValues) {
/*  98 */     return StringUtils.nonNull(ObjectUtils.coalesce(argValues));
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public String coalesceEmpty(Object... argValues) {
/* 104 */     String retVal = "";
/* 105 */     for (Object obj : argValues) {
/* 106 */       if (StringUtils.nonEmpty(obj) != null) {
/* 107 */         retVal = String.valueOf(obj);
/*     */         break;
/*     */       } 
/*     */     } 
/* 111 */     return retVal;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public String decrypt(String argCipherName, String argEncryptString) {
/* 117 */     return DtvDecrypter.getInstance(argCipherName).decrypt(argEncryptString);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public String format(Object argObject) {
/* 123 */     if (argObject == null) {
/* 124 */       return "";
/*     */     }
/* 126 */     if (argObject instanceof Date) {
/* 127 */       return formatDateTime((Date)argObject);
/*     */     }
/* 129 */     if (argObject instanceof BigDecimal) {
/* 130 */       return formatForAccounting((BigDecimal)argObject);
/*     */     }
/*     */     
/* 133 */     return translate(String.valueOf(argObject), new String[0]);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String format(Object argObject, FormatterType argFormat) {
/* 140 */     FormatterFactory ff = FormatterFactory.getInstance();
/* 141 */     IFormatter f = ff.getFormatter(argFormat);
/* 142 */     return f.format(argObject, OutputContextType.DOCUMENT);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public String format(Object argObject, String argFormatName) {
/* 148 */     return format(argObject, FormatterType.forName(argFormatName));
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public String formatAddress(IAddress argAddress) {
/* 154 */     return format(argAddress, FormatterType.BASIC_ADDRESS);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public String formatDate(Date argDate) {
/* 160 */     return format(argDate, FormatterType.DATE_MEDIUM);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public String formatDateTime(Date argDate) {
/* 166 */     return format(argDate, FormatterType.DATE_TIME_SHORT);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public String formatDecimal(BigDecimal argQuantity) {
/* 172 */     return format(argQuantity, FormatterType.DECIMAL);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public String formatDecimal(BigDecimal argQuantity, int argFractionalDigits) {
/* 178 */     BigDecimal quantity = null;
/*     */     try {
/* 180 */       quantity = NumberUtils.roundFractional(argQuantity, argFractionalDigits, RoundingMode.HALF_UP);
/*     */     
/*     */     }
/* 183 */     catch (IllegalArgumentException ex) {
/* 184 */       quantity = argQuantity;
/*     */     } 
/* 186 */     return format(quantity, FormatterType.DECIMAL);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public String formatForAccounting(BigDecimal argAmount) {
/* 192 */     return format((argAmount == null) ? BigDecimal.ZERO : argAmount, FormatterType.ACCOUNTING);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public String formatForAccountingWithRounding(BigDecimal argAmount) {
/* 198 */     return format((argAmount == null) ? BigDecimal.ZERO : argAmount
/*     */         
/* 200 */         .setScale(ConfigurationMgr.getCurrency().getDefaultFractionDigits(), RoundingMode.HALF_EVEN), FormatterType.ACCOUNTING);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String formatMoney(BigDecimal argAmount) {
/* 207 */     return format((argAmount == null) ? BigDecimal.ZERO : argAmount, FormatterType.MONEY);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public String formatPercent(BigDecimal argPercent) {
/* 213 */     return format(argPercent, FormatterType.PERCENT);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String formatPhoneNumber(String argPhoneNumber) {
/* 223 */     if (argPhoneNumber == null) {
/* 224 */       return "";
/*     */     }
/*     */     
/* 227 */     if (argPhoneNumber.indexOf("-") == -1) {
/* 228 */       return format(argPhoneNumber, "PHONE");
/*     */     }
/* 230 */     return argPhoneNumber;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public String formatTime(Date argDate) {
/* 236 */     return format(argDate, FormatterType.TIME_SHORT);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public byte[] getBarcode(String argText, BarcodeType argEncoding, BarcodeTextType argTextLocation, int argWidth, int argHeigth) {
/* 243 */     if (StringUtils.isEmpty(argText)) {
/* 244 */       return null;
/*     */     }
/*     */     try {
/* 247 */       BarcodeInfo barcodeInfo = new BarcodeInfo(argEncoding, argText, argTextLocation, null, argWidth, argHeigth);
/*     */       
/* 249 */       return this.barcodeFactory_.asPng((IBarcodeInfo)barcodeInfo);
/*     */     }
/* 251 */     catch (Exception ex) {
/* 252 */       BufferedImage bi = new BufferedImage(1, 1, 12);
/* 253 */       return ((DataBufferByte)bi.getData().getDataBuffer()).getData();
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public Boolean getBoolean(String... argConfigPath) {
/* 260 */     return Boolean.valueOf(ConfigurationMgr.getHelper().getBoolean(argConfigPath));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getCodeEnumDesc(String argName, String argClassName) {
/* 277 */     String description = null;
/*     */     
/*     */     try {
/* 280 */       Class<?> clazz = Class.forName(argClassName);
/* 281 */       Method forName = clazz.getMethod("forName", new Class[] { String.class });
/* 282 */       Object result = forName.invoke(null, new Object[] { argName });
/* 283 */       description = (result != null) ? result.toString() : null;
/*     */     }
/* 285 */     catch (ClassNotFoundException ex) {
/* 286 */       logger_.error("Attempted to get description from code enum class [" + argClassName + "], but the class was not found.", ex);
/*     */     
/*     */     }
/* 289 */     catch (NoSuchMethodException ex) {
/* 290 */       logger_.error("Attempted to invoke forName(String) method on class [" + argClassName + "], but the method was not found.", ex);
/*     */     
/*     */     }
/* 293 */     catch (Exception ex) {
/* 294 */       logger_.error("An exception occurred attempting to invoke static forName(String) method on class [" + argClassName + "].", ex);
/*     */     } 
/*     */ 
/*     */     
/* 298 */     return description;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public Image getImage(String argImageKey) {
/* 304 */     return UIResourceManager.getInstance().getImage(argImageKey);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public String getLastFirstName(final String argFirstName, final String argLastName) {
/* 310 */     IName name = new IName()
/*     */       {
/*     */         public String getCountry()
/*     */         {
/* 314 */           return null;
/*     */         }
/*     */ 
/*     */         
/*     */         public String getFirstName() {
/* 319 */           return argFirstName;
/*     */         }
/*     */ 
/*     */         
/*     */         public String getLastName() {
/* 324 */           return argLastName;
/*     */         }
/*     */ 
/*     */         
/*     */         public String getMiddleName() {
/* 329 */           return null;
/*     */         }
/*     */ 
/*     */         
/*     */         public String getSalutation() {
/* 334 */           return null;
/*     */         }
/*     */ 
/*     */         
/*     */         public String getSuffix() {
/* 339 */           return null;
/*     */         }
/*     */       };
/*     */     
/* 343 */     return format(name, FormatterType.LAST_FIRST_NAME);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public BigDecimal getLocalCurrencyAmount(BigDecimal argAmount, String argCurrencyId, long argRetailLocationId) {
/* 350 */     return ExchangeRateHelper.getLocalizedAmount(argAmount, argCurrencyId, 
/* 351 */         ConfigurationMgr.getLocalCurrencyId(), argRetailLocationId);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public String maskSerialNumber(String argSerialNumber) {
/* 357 */     if (argSerialNumber == null) {
/* 358 */       return "";
/*     */     }
/*     */     
/* 361 */     StringBuffer sb = new StringBuffer(argSerialNumber.toString());
/*     */     
/* 363 */     if (sb.length() < 4) {
/* 364 */       return sb.toString();
/*     */     }
/*     */     
/* 367 */     for (int i = sb.length() - 4; i < sb.length(); i++) {
/* 368 */       if (Character.isDigit(sb.charAt(i))) {
/* 369 */         sb.replace(i, i + 1, "X");
/*     */       }
/*     */     } 
/*     */     
/* 373 */     return sb.toString();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public BigDecimal nonNull(BigDecimal argBigDecimal) {
/* 380 */     return NumberUtils.nonNull(argBigDecimal);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public String nonNull(String argString) {
/* 386 */     return StringUtils.nonNull(argString);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public BigDecimal sum(BigDecimal... argNumbers) {
/* 392 */     return NumberUtils.sum(argNumbers);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public BigDecimal sum(Iterable<BigDecimal> argNumbers) {
/* 398 */     return NumberUtils.sum(argNumbers);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public String translate(String argKey, String... args) {
/* 404 */     IFormattable formattable = IFormattable.EMPTY;
/* 405 */     List<IFormattable> params = new ArrayList<>();
/*     */     
/* 407 */     if (args != null) {
/* 408 */       for (String arg : args) {
/* 409 */         params.add((arg == null) ? IFormattable.EMPTY : FF.getSimpleFormattable(arg));
/*     */       }
/*     */     }
/* 412 */     formattable = FF.getSimpleFormattable(argKey, params.<IFormattable>toArray(new IFormattable[0]));
/*     */     
/* 414 */     return formattable.toString(OutputContextType.DOCUMENT);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public String translateLiteral(String argKey) {
/* 420 */     boolean isDbTransKey = TranslationHelper.getInstance().isDatabaseTranslationKey(argKey);
/* 421 */     boolean isTransKey = TranslationHelper.getInstance().isTranslationKey(argKey);
/*     */     
/* 423 */     if (isDbTransKey || isTransKey) {
/* 424 */       IFormattable formattable = FF.getTranslatable(argKey);
/* 425 */       return formattable.toString(OutputContextType.DOCUMENT);
/*     */     } 
/*     */     
/* 428 */     return translate(argKey, new String[0]);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public String translateSafe(String argDefault, String argKey, String... args) {
/* 434 */     String result = translate(argKey, args);
/*     */     
/* 436 */     if (result.startsWith("mr@")) {
/* 437 */       return argDefault;
/*     */     }
/*     */     
/* 440 */     return result;
/*     */   }
/*     */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-posframework.jar!\dtv\pos\framework\reporting\fill\ReportHelper.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */