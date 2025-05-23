/*    */ package dtv.pos.framework.version;
/*    */ 
/*    */ import dtv.data2.access.IPersistenceMgrType;
/*    */ import dtv.data2.access.pm.PersistenceManagerType;
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
/*    */ public enum SchemaVersionScope
/*    */ {
/* 17 */   LOCAL("RESERVED_LOCAL"), STORE("RESERVED_STORE"), CENTRAL("RESERVED_CENTRAL");
/*    */   
/*    */   private IPersistenceMgrType _pmType;
/*    */ 
/*    */   
/*    */   SchemaVersionScope(String argPmTypeName) {
/* 23 */     this._pmType = (IPersistenceMgrType)PersistenceManagerType.forName(argPmTypeName);
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public IPersistenceMgrType getPmType() {
/* 31 */     return this._pmType;
/*    */   }
/*    */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-posframework.jar!\dtv\pos\framework\version\SchemaVersionScope.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */