/*    */ package dtv.pos.framework.reporting.dataset.function;
/*    */ 
/*    */ import java.math.BigDecimal;
/*    */ import java.math.RoundingMode;
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
/*    */ public class AvgAggregateFunction
/*    */   implements IAggregateFunction
/*    */ {
/*    */   public Object calculate(List<HashMap<String, Object>> argRows, String argColumnKey) {
/* 24 */     BigDecimal sum = BigDecimal.ZERO;
/* 25 */     int count = 0;
/* 26 */     for (HashMap<String, Object> row : argRows) {
/* 27 */       Object obj = row.get(argColumnKey);
/* 28 */       if (obj != null) {
/* 29 */         if (obj instanceof String) {
/* 30 */           sum = sum.add(new BigDecimal((String)obj));
/*    */         }
/* 32 */         else if (obj instanceof BigDecimal) {
/* 33 */           sum = sum.add((BigDecimal)obj);
/*    */         } else {
/*    */           
/* 36 */           throw new UnsupportedOperationException("Unable to avg datatype " + obj.getClass());
/*    */         } 
/* 38 */         count++;
/*    */       } 
/*    */     } 
/*    */     
/* 42 */     BigDecimal avg = BigDecimal.ZERO;
/* 43 */     if (count > 0) {
/* 44 */       avg = sum.divide(new BigDecimal(count), 3, RoundingMode.HALF_UP);
/*    */     }
/* 46 */     return avg;
/*    */   }
/*    */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-posframework.jar!\dtv\pos\framework\reporting\dataset\function\AvgAggregateFunction.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */