/*    */ package dtv.data2.cache.impl;
/*    */ 
/*    */ import dtv.data2.cache.AbstractCache;
/*    */ import dtv.data2.cache.ICache;
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
/*    */ public class DummyCache
/*    */   extends AbstractCache
/*    */   implements ICache
/*    */ {
/*    */   public String getStatusDetails() {
/* 22 */     return "Nothing cached (not a real cache).";
/*    */   }
/*    */ 
/*    */   
/*    */   public void init(String argCacheId) {
/* 27 */     setCacheId(argCacheId);
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public void put(Object argKey, Object argValue) {
/* 33 */     if (this.DEBUG) {
/* 34 */       this.logger_.debug("put has no effect as this is a dummy cache.");
/*    */     }
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   protected void clearImpl() {}
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   protected void destroyImpl() {}
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   protected Object getImpl(Object argKey) {
/* 53 */     return null;
/*    */   }
/*    */   
/*    */   protected void initImpl(String argCacheId) {}
/*    */   
/*    */   protected void putImpl(Object argKey, Object argValue) {}
/*    */   
/*    */   protected void removeImpl(Object argKey) {}
/*    */ }


/* Location:              C:\Base_Xstore_workspace_code\release\xstore\xstore\lib\dtv-data2.jar!\dtv\data2\cache\impl\DummyCache.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */