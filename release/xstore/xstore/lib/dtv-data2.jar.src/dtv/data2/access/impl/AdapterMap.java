/*    */ package dtv.data2.access.impl;
/*    */ 
/*    */ import dtv.data2.access.exception.DtxException;
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
/*    */ public abstract class AdapterMap
/*    */ {
/* 17 */   protected static final Logger logger_ = Logger.getLogger(AdapterMap.class);
/* 18 */   protected static AdapterMap adapterMap_ = null;
/*    */   
/*    */   static {
/* 21 */     adapterMap_ = SelectingImplFactory.<AdapterMap>getImplClass(AdapterMap.class);
/*    */   }
/*    */   
/*    */   public static final IRelationshipAdapter getRelationshipAdapter(Class<?> argClass, String argIdentifier) {
/*    */     try {
/* 26 */       IRelationshipAdapter rel = adapterMap_.getRelationshipAdapterImpl(argClass, argIdentifier);
/* 27 */       if (rel != null) {
/* 28 */         return rel;
/*    */       }
/*    */     }
/* 31 */     catch (DtxException ex) {
/* 32 */       logger_.debug(ex);
/*    */     } 
/* 34 */     throw new DtxException("No relationship adapter found for " + argClass + " and " + argIdentifier);
/*    */   }
/*    */   
/*    */   public abstract IRelationshipAdapter getRelationshipAdapterImpl(Class paramClass, String paramString);
/*    */ }


/* Location:              C:\Base_Xstore_workspace_code\release\xstore\xstore\lib\dtv-data2.jar!\dtv\data2\access\impl\AdapterMap.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */