/*    */ package dtv.data2.access.config.query;
/*    */ 
/*    */ import dtv.util.config.AbstractParentConfig;
/*    */ import dtv.util.config.IConfigObject;
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
/*    */ public class QuerySortConfig
/*    */   extends AbstractParentConfig
/*    */ {
/*    */   private static final long serialVersionUID = 1L;
/* 23 */   private String _sortField = null;
/* 24 */   private String _sortOrder = null;
/* 25 */   private String _requiredSort = null;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public String getSortField() {
/* 33 */     return this._sortField;
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public String getSortOrder() {
/* 42 */     return this._sortOrder;
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public String isRequiredSort() {
/* 51 */     return this._requiredSort;
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public void setConfigObject(String argKey, IConfigObject argValue) {
/* 57 */     if ("field".equalsIgnoreCase(argKey)) {
/* 58 */       this._sortField = argValue.toString();
/*    */     }
/* 60 */     else if ("order".equalsIgnoreCase(argKey)) {
/* 61 */       this._sortOrder = argValue.toString();
/*    */     }
/* 63 */     else if ("required".equalsIgnoreCase(argKey)) {
/* 64 */       this._requiredSort = argValue.toString();
/*    */     } else {
/*    */       
/* 67 */       warnUnsupported(argKey, argValue);
/*    */     } 
/*    */   }
/*    */ }


/* Location:              C:\Base_Xstore_workspace_code\release\xstore\xstore\lib\dtv-data2.jar!\dtv\data2\access\config\query\QuerySortConfig.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */