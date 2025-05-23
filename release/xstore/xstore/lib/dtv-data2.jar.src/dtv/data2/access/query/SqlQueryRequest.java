/*    */ package dtv.data2.access.query;
/*    */ 
/*    */ import dtv.data2.access.IPersistable;
/*    */ import dtv.data2.access.exception.DtxException;
/*    */ import java.io.IOException;
/*    */ import java.io.NotSerializableException;
/*    */ import java.io.ObjectInputStream;
/*    */ import java.io.ObjectOutputStream;
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
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class SqlQueryRequest
/*    */   implements IPersistable
/*    */ {
/*    */   private String sqlStatement_;
/*    */   private String pmType_;
/*    */   private List<Object> params_;
/*    */   
/*    */   public List<Object> getParams() {
/* 39 */     return this.params_;
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public String getPmType() {
/* 46 */     return this.pmType_;
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public String getSqlStatement() {
/* 53 */     return this.sqlStatement_;
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public void setParams(List<Object> argParams) {
/* 60 */     this.params_ = argParams;
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public void setPmType(String argPmType) {
/* 67 */     this.pmType_ = argPmType;
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public void setSqlStatement(String argSqlStatement) {
/* 74 */     this.sqlStatement_ = argSqlStatement;
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public String toXmlString() {
/* 80 */     throw new DtxException("SqlQueryRequest is not XML serializable.");
/*    */   }
/*    */ 
/*    */   
/*    */   private void readObject(ObjectInputStream in) throws IOException {
/* 85 */     throw new NotSerializableException("SqlQueryRequest is not serializable.");
/*    */   }
/*    */ 
/*    */   
/*    */   private void writeObject(ObjectOutputStream out) throws IOException {
/* 90 */     throw new NotSerializableException("SqlQueryRequest is not serializable.");
/*    */   }
/*    */ }


/* Location:              C:\Base_Xstore_workspace_code\release\xstore\xstore\lib\dtv-data2.jar!\dtv\data2\access\query\SqlQueryRequest.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */