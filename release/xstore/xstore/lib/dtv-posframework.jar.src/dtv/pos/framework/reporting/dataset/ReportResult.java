/*    */ package dtv.pos.framework.reporting.dataset;
/*    */ 
/*    */ import java.util.HashMap;
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
/*    */ 
/*    */ public class ReportResult
/*    */ {
/*    */   private String _name;
/*    */   private List<HashMap<String, Object>> _resultSetRows;
/*    */   
/*    */   public String getName() {
/* 33 */     return this._name;
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public List<HashMap<String, Object>> getRows() {
/* 42 */     return this._resultSetRows;
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public void setName(String argName) {
/* 50 */     this._name = argName;
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public void setRows(List<HashMap<String, Object>> argRows) {
/* 59 */     this._resultSetRows = argRows;
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public String toString() {
/* 67 */     StringBuilder builder = new StringBuilder();
/* 68 */     builder.append("Result [name=");
/* 69 */     builder.append(this._name);
/* 70 */     builder.append(", \nrows=");
/*    */     
/* 72 */     int rowCounter = 1;
/* 73 */     for (HashMap<String, Object> rowMap : getRows()) {
/*    */       
/* 75 */       builder.append("\n\t");
/* 76 */       builder.append(rowCounter++);
/* 77 */       builder.append(". [");
/* 78 */       for (String key : rowMap.keySet()) {
/* 79 */         builder.append("  ");
/* 80 */         builder.append(key);
/* 81 */         builder.append("=");
/* 82 */         builder.append(rowMap.get(key));
/*    */       } 
/* 84 */       builder.append("]");
/*    */     } 
/*    */     
/* 87 */     builder.append("]");
/* 88 */     return builder.toString();
/*    */   }
/*    */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-posframework.jar!\dtv\pos\framework\reporting\dataset\ReportResult.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */