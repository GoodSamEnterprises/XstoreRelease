/*    */ package dtv.pos.framework.reporting.dataset.function;
/*    */ 
/*    */ import java.math.BigDecimal;
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
/*    */ public class SumAggregateFunction
/*    */   implements IAggregateFunction
/*    */ {
/*    */   public Object calculate(List<HashMap<String, Object>> argRows, String argColumnKey) {
/* 23 */     BigDecimal sum = BigDecimal.ZERO;
/* 24 */     for (HashMap<String, Object> row : argRows) {
/*    */       
/* 26 */       Object obj = row.get(argColumnKey);
/* 27 */       if (obj != null) {
/*    */         
/* 29 */         if (obj instanceof String) {
/* 30 */           sum = sum.add(new BigDecimal((String)obj)); continue;
/*    */         } 
/* 32 */         if (obj instanceof BigDecimal) {
/* 33 */           sum = sum.add((BigDecimal)obj);
/*    */           continue;
/*    */         } 
/* 36 */         throw new UnsupportedOperationException("Unable to sum datatype " + obj.getClass());
/*    */       } 
/*    */     } 
/*    */     
/* 40 */     return sum;
/*    */   }
/*    */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-posframework.jar!\dtv\pos\framework\reporting\dataset\function\SumAggregateFunction.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */