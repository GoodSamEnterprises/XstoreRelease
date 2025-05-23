/*    */ package dtv.data2.access.impl.jdbc;
/*    */ 
/*    */ import dtv.data2.access.IDataAccessObject;
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
/*    */ @Deprecated
/*    */ public final class DaoConversionHelper
/*    */ {
/*    */   public static boolean isDaoConvertOnPkViolation(IDataAccessObject argDao) {
/* 18 */     return false;
/*    */   }
/*    */   
/*    */   private DaoConversionHelper() {
/* 22 */     throw new UnsupportedOperationException();
/*    */   }
/*    */ }


/* Location:              C:\Base_Xstore_workspace_code\release\xstore\xstore\lib\dtv-data2.jar!\dtv\data2\access\impl\jdbc\DaoConversionHelper.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */