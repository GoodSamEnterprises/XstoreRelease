/*    */ package dtv.pos.framework.reporting.dataset.function;
/*    */ 
/*    */ import java.util.ArrayList;
/*    */ import java.util.Collections;
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
/*    */ public class MinAggregateFunction
/*    */   implements IAggregateFunction
/*    */ {
/*    */   public Object calculate(List<HashMap<String, Object>> argRows, String argColumnKey) {
/* 23 */     if (argRows == null || argRows.isEmpty()) {
/* 24 */       return null;
/*    */     }
/*    */     
/* 27 */     ArrayList<Comparable> el = new ArrayList<>();
/* 28 */     for (HashMap<String, Object> row : argRows) {
/* 29 */       if (row.containsKey(argColumnKey)) {
/* 30 */         el.add((Comparable)row.get(argColumnKey));
/*    */       }
/*    */     } 
/*    */     
/* 34 */     Object minValue = Collections.min(el);
/* 35 */     return minValue;
/*    */   }
/*    */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-posframework.jar!\dtv\pos\framework\reporting\dataset\function\MinAggregateFunction.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */