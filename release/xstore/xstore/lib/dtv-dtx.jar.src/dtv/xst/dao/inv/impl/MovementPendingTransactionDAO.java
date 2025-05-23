/*    */ package dtv.xst.dao.inv.impl;
/*    */ 
/*    */ import dtv.xst.dao.trn.impl.PosTransactionDAO;
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
/*    */ public class MovementPendingTransactionDAO
/*    */   extends PosTransactionDAO
/*    */ {
/*    */   private static final long serialVersionUID = -1469642762L;
/* 23 */   private static final Logger _logger = Logger.getLogger(MovementPendingTransactionDAO.class);
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public String toString() {
/* 29 */     StringBuilder buf = new StringBuilder(512);
/* 30 */     buf.append(super.toString());
/*    */     
/* 32 */     return buf.toString();
/*    */   }
/*    */ 
/*    */   
/*    */   public String toXmlString() {
/* 37 */     StringBuilder buf = new StringBuilder(1450);
/* 38 */     buf.append("<").append("dao").append(" name=\"MovementPendingTransaction\" cmd=\"" + getObjectStateString() + "\">");
/* 39 */     getFieldsAsXml(buf);
/* 40 */     buf.append("</").append("dao").append(">");
/*    */     
/* 42 */     return buf.toString();
/*    */   }
/*    */   
/*    */   public Map<String, String> getValues() {
/* 46 */     Map<String, String> values = super.getValues();
/* 47 */     return values;
/*    */   }
/*    */ 
/*    */   
/*    */   public void setValues(Map<String, String> argValues) {
/* 52 */     super.setValues(argValues);
/* 53 */     for (Map.Entry<String, String> field : argValues.entrySet()) {
/*    */       
/* 55 */       String fieldName = field.getKey();
/* 56 */       String fieldValue = field.getValue();
/* 57 */       String str1 = fieldName; byte b = -1; str1.hashCode(); switch (b) {
/*    */       
/*    */       } 
/*    */     } 
/*    */   }
/*    */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\inv\impl\MovementPendingTransactionDAO.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */