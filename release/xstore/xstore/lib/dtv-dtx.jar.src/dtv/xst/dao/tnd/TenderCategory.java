/*     */ package dtv.xst.dao.tnd;
/*     */ 
/*     */ import dtv.xst.dao.ttr.IAccountCreditTenderLineItem;
/*     */ import dtv.xst.dao.ttr.IAccountReceivableTenderLineItem;
/*     */ import dtv.xst.dao.ttr.ICheckTenderLineItem;
/*     */ import dtv.xst.dao.ttr.ICouponTenderLineItem;
/*     */ import dtv.xst.dao.ttr.ICreditDebitTenderLineItem;
/*     */ import dtv.xst.dao.ttr.ISendCheckTenderLineItem;
/*     */ import dtv.xst.dao.ttr.ITenderLineItem;
/*     */ import dtv.xst.dao.ttr.IVoucherTenderLineItem;
/*     */ import java.io.Serializable;
/*     */ import java.util.HashMap;
/*     */ import java.util.Map;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class TenderCategory
/*     */   implements Serializable
/*     */ {
/*     */   private static final long serialVersionUID = 7123944123123312L;
/*  26 */   public static final TenderCategory CURRENCY = new TenderCategory("CURRENCY", ITenderLineItem.class);
/*     */ 
/*     */   
/*  29 */   public static final TenderCategory CREDIT_CARD = new TenderCategory("CREDIT_CARD", (Class)ICreditDebitTenderLineItem.class);
/*     */ 
/*     */ 
/*     */   
/*  33 */   public static final TenderCategory EBT = new TenderCategory("EBT", (Class)ICreditDebitTenderLineItem.class);
/*     */ 
/*     */   
/*  36 */   public static final TenderCategory CHECK = new TenderCategory("CHECK", (Class)ICheckTenderLineItem.class);
/*     */ 
/*     */   
/*  39 */   public static final TenderCategory VOUCHER = new TenderCategory("VOUCHER", (Class)IVoucherTenderLineItem.class);
/*     */ 
/*     */   
/*  42 */   public static final TenderCategory ACCOUNT = new TenderCategory("ACCOUNT", (Class)IAccountReceivableTenderLineItem.class);
/*     */ 
/*     */ 
/*     */   
/*  46 */   public static final TenderCategory HOME_OFFICE_CHECK = new TenderCategory("HOME_OFFICE_CHECK", (Class)ISendCheckTenderLineItem.class);
/*     */ 
/*     */ 
/*     */   
/*  50 */   public static final TenderCategory COUPON = new TenderCategory("COUPON", (Class)ICouponTenderLineItem.class);
/*     */ 
/*     */   
/*  53 */   public static final TenderCategory MALL_CERTIFICATE = new TenderCategory("MALL_CERTIFICATE", ITenderLineItem.class);
/*     */ 
/*     */ 
/*     */   
/*  57 */   public static final TenderCategory MALL_CERTIFICATE_CHECK = new TenderCategory("MALL_CERTIFICATE_CHECK", ITenderLineItem.class);
/*     */ 
/*     */ 
/*     */   
/*  61 */   public static final TenderCategory MISCELLANEOUS = new TenderCategory("MISCELLANEOUS", ITenderLineItem.class);
/*     */ 
/*     */ 
/*     */   
/*  65 */   public static final TenderCategory ACCOUNT_CREDIT = new TenderCategory("ACCOUNT_CREDIT", (Class)IAccountCreditTenderLineItem.class);
/*     */ 
/*     */ 
/*     */   
/*  69 */   public static final TenderCategory TRAVELERS_CHECK = new TenderCategory("TRAVELERS_CHECK", (Class)ICheckTenderLineItem.class);
/*     */ 
/*     */ 
/*     */   
/*  73 */   public static final TenderCategory FOREIGN_CURRENCY = new TenderCategory("FOREIGN_CURRENCY", ITenderLineItem.class);
/*     */ 
/*     */ 
/*     */   
/*  77 */   public static final TenderCategory MONEY_ORDER = new TenderCategory("MONEY_ORDER", ITenderLineItem.class);
/*     */ 
/*     */   
/*  80 */   public static final TenderCategory MGW_CREDIT_CARD = new TenderCategory("MGW_CREDIT_CARD", (Class)ICreditDebitTenderLineItem.class);
/*     */ 
/*     */ 
/*     */   
/*  84 */   public static final TenderCategory MGW_DEBIT_CARD = new TenderCategory("MGW_DEBIT_CARD", (Class)ICreditDebitTenderLineItem.class);
/*     */ 
/*     */ 
/*     */   
/*  88 */   public static final TenderCategory MGW_GIFT_CARD = new TenderCategory("MGW_GIFT_CARD", ITenderLineItem.class);
/*     */ 
/*     */ 
/*     */   
/*     */   private static Map<String, TenderCategory> values_;
/*     */ 
/*     */   
/*     */   private final String name_;
/*     */ 
/*     */   
/*     */   private final Class<? extends ITenderLineItem> interfaceClass_;
/*     */ 
/*     */ 
/*     */   
/*     */   public static TenderCategory forName(String argName) {
/* 103 */     if (argName == null) {
/* 104 */       return null;
/*     */     }
/* 106 */     TenderCategory found = values_.get(argName.trim().toUpperCase());
/* 107 */     if (found == null) {
/* 108 */       return new TenderCategory(argName, ITenderLineItem.class);
/*     */     }
/* 110 */     return found;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static TenderCategory[] getAll() {
/* 119 */     return (TenderCategory[])values_.values().toArray((Object[])new TenderCategory[values_.size()]);
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
/*     */   protected TenderCategory(String argName, Class<? extends ITenderLineItem> argClass) {
/* 132 */     this.name_ = argName;
/* 133 */     this.interfaceClass_ = argClass;
/* 134 */     if (values_ == null) {
/* 135 */       values_ = new HashMap<>();
/*     */     }
/* 137 */     values_.put(this.name_, this);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Class<? extends ITenderLineItem> getInterfaceClass() {
/* 145 */     return this.interfaceClass_;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getName() {
/* 154 */     return this.name_;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean matches(ITender argTender) {
/* 165 */     return (argTender != null && matches(argTender.getTenderTypecode()));
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
/* 176 */     return getName().equalsIgnoreCase(argName);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public String toString() {
/* 182 */     return getName();
/*     */   }
/*     */ 
/*     */   
/*     */   private Object readResolve() {
/* 187 */     return forName(this.name_);
/*     */   }
/*     */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\tnd\TenderCategory.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */