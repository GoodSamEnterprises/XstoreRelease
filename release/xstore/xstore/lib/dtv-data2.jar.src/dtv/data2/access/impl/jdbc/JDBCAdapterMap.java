/*    */ package dtv.data2.access.impl.jdbc;
/*    */ 
/*    */ import dtv.data2.access.exception.DtxException;
/*    */ import dtv.data2.access.impl.AdapterMap;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public abstract class JDBCAdapterMap
/*    */   extends AdapterMap
/*    */ {
/*    */   public static final IJDBCTableAdapter getTableAdapter(String argIdentifier) {
/* 18 */     if (adapterMap_ instanceof JDBCAdapterMap) {
/*    */       try {
/* 20 */         IJDBCTableAdapter adapter = ((JDBCAdapterMap)adapterMap_).getTableAdapterImpl(argIdentifier);
/* 21 */         if (adapter != null) {
/* 22 */           return adapter;
/*    */         }
/*    */       }
/* 25 */       catch (DtxException ex) {
/* 26 */         logger_.debug(ex);
/*    */       } 
/*    */     }
/* 29 */     throw new DtxException("Could not find table adapter for: " + argIdentifier);
/*    */   }
/*    */   
/*    */   public abstract IJDBCTableAdapter getTableAdapterImpl(String paramString);
/*    */ }


/* Location:              C:\Base_Xstore_workspace_code\release\xstore\xstore\lib\dtv-data2.jar!\dtv\data2\access\impl\jdbc\JDBCAdapterMap.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */