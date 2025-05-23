/*     */ package dtv.xst.dao.tnd;
/*     */ 
/*     */ import dtv.xst.dao.ttr.ITenderLineItem;
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class TenderStatus
/*     */ {
/*  22 */   public static final TenderStatus TENDER = new TenderStatus("Tender", "_tenderStatusTender");
/*     */ 
/*     */   
/*  25 */   public static final TenderStatus CHANGE = new TenderStatus("Change", "_tenderStatusChange");
/*     */ 
/*     */   
/*  28 */   public static final TenderStatus REFUND = new TenderStatus("Refund", "_tenderStatusRefund");
/*     */ 
/*     */   
/*     */   private static Map<String, TenderStatus> values_;
/*     */ 
/*     */   
/*     */   private final String name_;
/*     */   
/*     */   private final String translationKey_;
/*     */ 
/*     */   
/*     */   public static TenderStatus forName(String argName) {
/*  40 */     return values_.get(argName);
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
/*     */   private TenderStatus(String argName, String argTranslationKey) {
/*  56 */     this.name_ = argName;
/*  57 */     this.translationKey_ = argTranslationKey;
/*  58 */     if (values_ == null) {
/*  59 */       values_ = new HashMap<>();
/*     */     }
/*  61 */     values_.put(argName, this);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean equals(Object argObject) {
/*  67 */     boolean equal = false;
/*  68 */     Object object = argObject;
/*  69 */     if (object instanceof String) {
/*  70 */       object = forName((String)object);
/*     */     }
/*  72 */     if (object instanceof TenderStatus) {
/*  73 */       equal = this.name_.equals(((TenderStatus)object).name_);
/*     */     }
/*  75 */     return equal;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getName() {
/*  84 */     return this.name_;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getTranslationKey() {
/*  93 */     return this.translationKey_;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public int hashCode() {
/*  99 */     return this.name_.hashCode();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean matches(ITenderLineItem argValue) {
/* 110 */     return (argValue != null && matches(argValue.getTenderStatusCode()));
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
/* 121 */     return getName().equalsIgnoreCase(argName);
/*     */   }
/*     */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\tnd\TenderStatus.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */