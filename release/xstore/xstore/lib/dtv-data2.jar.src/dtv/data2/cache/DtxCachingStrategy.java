/*    */ package dtv.data2.cache;
/*    */ 
/*    */ import java.util.HashMap;
/*    */ import java.util.Map;
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
/*    */ 
/*    */ 
/*    */ 
/*    */ public class DtxCachingStrategy
/*    */ {
/*    */   private static Class<DtxCachingStrategy> class_;
/*    */   private static final String CACHE_NAME = "dtx-cache";
/* 26 */   private static final Logger logger_ = Logger.getLogger(DtxCachingStrategy.class);
/* 27 */   private static final boolean DEBUG = logger_.isDebugEnabled();
/*    */   
/* 29 */   private static ICache permanentCache_ = CacheManager.getInstance().getCache("dtx-cache");
/*    */ 
/*    */   
/*    */   static {
/*    */     try {
/* 34 */       class_ = (Class)Class.forName(System.getProperty(DtxCachingStrategy.class.getName(), DtxCachingStrategy.class
/* 35 */             .getName()));
/*    */     }
/* 37 */     catch (Exception ee) {
/* 38 */       logger_.error("Failed to create class based on system property: " + DtxCachingStrategy.class.getName(), ee);
/*    */       
/* 40 */       class_ = DtxCachingStrategy.class;
/*    */     } 
/*    */   }
/*    */   
/*    */   public static DtxCachingStrategy getNewInstance() {
/*    */     try {
/* 46 */       return class_.newInstance();
/*    */     }
/* 48 */     catch (Exception ee) {
/* 49 */       logger_.error("Failed to instantiate class: " + class_, ee);
/* 50 */       return new DtxCachingStrategy();
/*    */     } 
/*    */   }
/*    */   
/* 54 */   private final Map<Object, Object> sessionCache_ = new HashMap<>();
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
/*    */   public Object get(Object argKey) throws NotCachedException {
/* 68 */     Object result = this.sessionCache_.get(argKey);
/* 69 */     if (DEBUG) {
/* 70 */       logger_.debug("seacrh for key in session cache resulted in: " + result);
/*    */     }
/*    */     
/* 73 */     if (result == null) {
/* 74 */       result = permanentCache_.get(argKey);
/*    */       
/* 76 */       if (DEBUG) {
/* 77 */         logger_.debug("search for key in permanent cache resulted in: " + result);
/*    */       }
/*    */     } 
/*    */     
/* 81 */     return result;
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public void put(Object argKey, Object argValue) {
/* 91 */     if (DEBUG) {
/* 92 */       logger_.debug("adding to session cache.  key: " + argKey + " value: " + argValue);
/*    */     }
/* 94 */     this.sessionCache_.put(argKey, argValue);
/*    */     
/* 96 */     if (DEBUG) {
/* 97 */       logger_.debug("adding to permanent cache.  key: " + argKey + " value: " + argValue);
/*    */     }
/* 99 */     permanentCache_.put(argKey, argValue);
/*    */   }
/*    */ }


/* Location:              C:\Base_Xstore_workspace_code\release\xstore\xstore\lib\dtv-data2.jar!\dtv\data2\cache\DtxCachingStrategy.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */