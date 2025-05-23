/*     */ package dtv.xst.dao.trl;
/*     */ 
/*     */ import java.util.Collection;
/*     */ import java.util.HashMap;
/*     */ import java.util.Map;
/*     */ import org.apache.log4j.Logger;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class RetailPriceModifierReasonCode
/*     */ {
/*  17 */   private static final Logger logger_ = Logger.getLogger(RetailPriceModifierReasonCode.class);
/*     */ 
/*     */   
/*  20 */   private static final Map<String, RetailPriceModifierReasonCode> _values = new HashMap<>();
/*     */ 
/*     */   
/*     */   public static final int CHANGE_TYPE_NONE = 0;
/*     */ 
/*     */   
/*     */   public static final int CHANGE_TYPE_MANUAL_OVERRIDE = 1;
/*     */ 
/*     */   
/*     */   public static final int CHANGE_TYPE_AUTOMATIC_OVERRIDE = 16;
/*     */ 
/*     */   
/*     */   public static final int CHANGE_TYPE_DISCOUNT = 256;
/*     */ 
/*     */   
/*  35 */   public static final RetailPriceModifierReasonCode DEAL = new RetailPriceModifierReasonCode("DEAL", 256);
/*     */ 
/*     */ 
/*     */   
/*  39 */   public static final RetailPriceModifierReasonCode LINE_ITEM_DISCOUNT = new RetailPriceModifierReasonCode("LINE_ITEM_DISCOUNT", 256);
/*     */ 
/*     */ 
/*     */   
/*  43 */   public static final RetailPriceModifierReasonCode GROUP_DISCOUNT = new RetailPriceModifierReasonCode("GROUP_DISCOUNT", 256);
/*     */ 
/*     */ 
/*     */   
/*  47 */   public static final RetailPriceModifierReasonCode TRANSACTION_DISCOUNT = new RetailPriceModifierReasonCode("TRANSACTION_DISCOUNT", 256);
/*     */ 
/*     */ 
/*     */   
/*  51 */   public static final RetailPriceModifierReasonCode PRICE_OVERRIDE = new RetailPriceModifierReasonCode("PRICE_OVERRIDE", 1);
/*     */ 
/*     */ 
/*     */   
/*  55 */   public static final RetailPriceModifierReasonCode PROMPT_PRICE_CHANGE = new RetailPriceModifierReasonCode("PROMPT_PRICE_CHANGE", 1);
/*     */ 
/*     */ 
/*     */   
/*  59 */   public static final RetailPriceModifierReasonCode BASE_PRICE_RULE = new RetailPriceModifierReasonCode("BASE_PRICE_RULE", 0);
/*     */ 
/*     */ 
/*     */   
/*  63 */   public static final RetailPriceModifierReasonCode NEW_PRICE_RULE = new RetailPriceModifierReasonCode("NEW_PRICE_RULE", 256);
/*     */ 
/*     */ 
/*     */   
/*  67 */   public static final RetailPriceModifierReasonCode DOCUMENT = new RetailPriceModifierReasonCode("DOCUMENT", 256);
/*     */ 
/*     */ 
/*     */   
/*  71 */   public static final RetailPriceModifierReasonCode MANUFACTURER_COUPON = new RetailPriceModifierReasonCode("MANUFACTURER_COUPON", 256);
/*     */ 
/*     */ 
/*     */   
/*  75 */   public static final RetailPriceModifierReasonCode REFUND_PRORATION = new RetailPriceModifierReasonCode("REFUND_PRORATION", 16);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*  82 */   public static final RetailPriceModifierReasonCode CALCULATED_WARRANTY_PRICE = new RetailPriceModifierReasonCode("CALCULATED_WARRANTY_PRICE", 16);
/*     */ 
/*     */ 
/*     */   
/*     */   private final String _name;
/*     */ 
/*     */   
/*     */   private final int _priceChangeType;
/*     */ 
/*     */ 
/*     */   
/*     */   public static RetailPriceModifierReasonCode forName(String argName) {
/*  94 */     RetailPriceModifierReasonCode found = _values.get(argName.trim().toUpperCase());
/*  95 */     if (found == null) {
/*  96 */       logger_.warn("There is no instance of [" + RetailPriceModifierReasonCode.class.getName() + "] named [" + argName + "].", new Throwable("STACK TRACE"));
/*     */     }
/*     */     
/*  99 */     return found;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Collection<? extends RetailPriceModifierReasonCode> values() {
/* 107 */     return _values.values();
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
/*     */   public RetailPriceModifierReasonCode(String argName, int argPriceChangeType) {
/* 121 */     this._name = argName.trim().toUpperCase();
/* 122 */     this._priceChangeType = argPriceChangeType;
/* 123 */     _values.put(this._name, this);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean equals(Object argOther) {
/* 129 */     if (argOther == this) {
/* 130 */       return true;
/*     */     }
/* 132 */     if (argOther instanceof RetailPriceModifierReasonCode) {
/* 133 */       return ((RetailPriceModifierReasonCode)argOther).getName().equals(getName());
/*     */     }
/* 135 */     return false;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getName() {
/* 143 */     return this._name;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public int hashCode() {
/* 149 */     int prime = 887;
/* 150 */     int hash = 1143343;
/* 151 */     hash = 887 * (hash + getName().hashCode());
/* 152 */     return hash;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean isAutomaticOverride() {
/* 162 */     return ((this._priceChangeType & 0x10) != 0);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean isDiscount() {
/* 173 */     return ((this._priceChangeType & 0x100) != 0);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean isManualOverride() {
/* 183 */     return ((this._priceChangeType & 0x1) != 0);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean isOverride() {
/* 194 */     return (isManualOverride() || isAutomaticOverride());
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean isPriceChange() {
/* 204 */     return (isOverride() || isDiscount());
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean matches(String argName) {
/* 215 */     return getName().equalsIgnoreCase(argName);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public String toString() {
/* 221 */     return this._name;
/*     */   }
/*     */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\trl\RetailPriceModifierReasonCode.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */