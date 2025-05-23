/*    */ package dtv.pos.framework.location;
/*    */ 
/*    */ import dtv.util.address.AddressService;
/*    */ import dtv.util.address.CountryCache;
/*    */ import dtv.util.config.AbstractParentConfig;
/*    */ import dtv.util.config.IConfigObject;
/*    */ import org.apache.log4j.Logger;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class StoreCountryConfig
/*    */   extends AbstractParentConfig
/*    */ {
/*    */   private static final long serialVersionUID = 1L;
/*    */   private static final String CODE_TAG = "Code";
/*    */   private static final String NAME_TAG = "Name";
/*    */   private static final String AVS_ENABLED_TAG = "addressVerificationEnabled";
/* 28 */   private static final Logger logger_ = Logger.getLogger(StoreCountryConfig.class);
/* 29 */   private static CountryCache countryCache_ = null;
/*    */   private String code_;
/*    */   
/*    */   static {
/*    */     try {
/* 34 */       countryCache_ = (CountryCache)AddressService.getInternalInstance().getFieldCache("DEFAULT", "country");
/*    */     }
/* 36 */     catch (Throwable e) {
/* 37 */       logger_.warn("CAUGHT EXCEPTION", e);
/*    */     } 
/*    */   }
/*    */ 
/*    */   
/*    */   private String name_;
/*    */   private boolean avsEnabled_;
/*    */   
/*    */   public boolean getAvsEnabled() {
/* 46 */     return this.avsEnabled_;
/*    */   }
/*    */   
/*    */   public String getCode() {
/* 50 */     return this.code_;
/*    */   }
/*    */   
/*    */   public String getName() {
/* 54 */     return this.name_;
/*    */   }
/*    */ 
/*    */   
/*    */   public void setConfigObject(String argKey, IConfigObject argValue) {
/* 59 */     if ("Code".equalsIgnoreCase(argKey)) {
/* 60 */       this.code_ = argValue.toString();
/*    */ 
/*    */       
/* 63 */       if (this.name_ == null && countryCache_ != null) {
/* 64 */         this.name_ = countryCache_.getNameForCode(this.code_);
/*    */       
/*    */       }
/*    */     }
/* 68 */     else if ("Name".equalsIgnoreCase(argKey)) {
/* 69 */       this.name_ = argValue.toString();
/*    */     }
/* 71 */     else if ("addressVerificationEnabled".equalsIgnoreCase(argKey)) {
/* 72 */       this.avsEnabled_ = Boolean.valueOf(argValue.toString()).booleanValue();
/*    */     } else {
/*    */       
/* 75 */       warnUnsupported(argKey, argValue);
/*    */     } 
/*    */   }
/*    */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-posframework.jar!\dtv\pos\framework\location\StoreCountryConfig.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */