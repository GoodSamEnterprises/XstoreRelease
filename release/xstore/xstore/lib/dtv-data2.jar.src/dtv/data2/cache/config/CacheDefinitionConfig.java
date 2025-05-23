/*    */ package dtv.data2.cache.config;
/*    */ 
/*    */ import dtv.data2.cache.ICache;
/*    */ import dtv.data2.cache.impl.DummyCache;
/*    */ import dtv.util.config.AbstractParentConfig;
/*    */ import dtv.util.config.ConfigUtils;
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
/*    */ public class CacheDefinitionConfig
/*    */   extends AbstractParentConfig
/*    */ {
/* 21 */   private static final Logger logger_ = Logger.getLogger(CacheDefinitionConfig.class);
/*    */   
/*    */   private static final long serialVersionUID = 1L;
/*    */   
/*    */   private static final String KEY_ID = "id";
/*    */   
/*    */   private static final String KEY_CLEARABLE = "clearable";
/*    */   
/*    */   private static final String KEY_IMPL = "Impl";
/*    */   
/*    */   private static final String KEY_FILTER_REF = "CacheFilterRef";
/*    */   
/*    */   private String cacheId_;
/*    */   private boolean clearable_;
/*    */   private Class<? extends ICache> cacheImpl_;
/*    */   private String cacheFilterRef_;
/*    */   
/*    */   public String getCacheFilterRef() {
/* 39 */     return this.cacheFilterRef_;
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public String getCacheId() {
/* 46 */     return this.cacheId_;
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public Class<? extends ICache> getCacheImpl() {
/* 53 */     return this.cacheImpl_;
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public boolean isClearable() {
/* 60 */     return this.clearable_;
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public void setConfigObject(String argKey, IConfigObject argValue) {
/* 67 */     if ("id".equals(argKey)) {
/* 68 */       this.cacheId_ = argValue.toString();
/*    */     }
/* 70 */     else if ("clearable".equals(argKey)) {
/* 71 */       this.clearable_ = ConfigUtils.toBoolean(argValue);
/*    */     }
/* 73 */     else if ("Impl".equals(argKey)) {
/*    */       try {
/* 75 */         this.cacheImpl_ = (Class)Class.forName(argValue.toString());
/*    */       }
/* 77 */       catch (Exception ee) {
/* 78 */         logger_.error("Excpetion occured while create class: " + argValue.toString(), ee);
/* 79 */         this.cacheImpl_ = (Class)DummyCache.class;
/*    */       }
/*    */     
/* 82 */     } else if ("CacheFilterRef".equals(argKey)) {
/* 83 */       this.cacheFilterRef_ = argValue.toString();
/*    */     } else {
/*    */       
/* 86 */       throw new RuntimeException("Unknown config object: " + argKey + " " + argValue);
/*    */     } 
/*    */   }
/*    */ }


/* Location:              C:\Base_Xstore_workspace_code\release\xstore\xstore\lib\dtv-data2.jar!\dtv\data2\cache\config\CacheDefinitionConfig.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */