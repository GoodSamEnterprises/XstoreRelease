/*    */ package dtv.data2.access.impl.jdbc;
/*    */ 
/*    */ import dtv.data2.access.exception.DtxException;
/*    */ import java.util.List;
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
/*    */ 
/*    */ public class JDBCCall
/*    */ {
/*    */   private String sqlString_;
/*    */   private List<Object> params_;
/*    */   private List<Integer> types_;
/*    */   private List<String> paramNames_;
/*    */   
/*    */   public List<String> getParamNames() {
/* 30 */     return this.paramNames_;
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public List<Object> getParams() {
/* 37 */     return this.params_;
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public String getSqlString() {
/* 44 */     return this.sqlString_;
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public List<Integer> getTypes() {
/* 51 */     return this.types_;
/*    */   }
/*    */   
/*    */   public void setParamNames(List<String> argParamNames) {
/* 55 */     this.paramNames_ = argParamNames;
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public void setParams(List<Object> argParams) {
/* 62 */     this.params_ = argParams;
/* 63 */     checkIntegrity();
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public void setSqlString(String argSqlString) {
/* 70 */     this.sqlString_ = argSqlString;
/* 71 */     checkIntegrity();
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public void setTypes(List<Integer> argTypes) {
/* 78 */     this.types_ = argTypes;
/* 79 */     checkIntegrity();
/*    */   }
/*    */ 
/*    */   
/*    */   public String toString() {
/* 84 */     StringBuilder val = new StringBuilder(64);
/*    */     
/* 86 */     val.append("sql: ").append("[");
/* 87 */     val.append(this.sqlString_);
/* 88 */     val.append("] params: ").append(this.params_);
/*    */     
/* 90 */     return val.toString();
/*    */   }
/*    */   
/*    */   private void checkIntegrity() {
/* 94 */     if (this.params_ != null && this.types_ != null && 
/* 95 */       this.params_.size() != this.types_.size())
/* 96 */       throw new DtxException("Class constraint of JDBCCall violated.  params_ and types_ must be equal in size when both non-null. params_: " + this.params_ + " types: " + this.types_); 
/*    */   }
/*    */ }


/* Location:              C:\Base_Xstore_workspace_code\release\xstore\xstore\lib\dtv-data2.jar!\dtv\data2\access\impl\jdbc\JDBCCall.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */