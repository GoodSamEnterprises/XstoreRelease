/*    */ package dtv.pos.framework.reporting.dataset.function;
/*    */ 
/*    */ import java.util.HashMap;
/*    */ import java.util.HashSet;
/*    */ import java.util.List;
/*    */ import java.util.Set;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class CountDistinctAggregateFunction
/*    */   implements IAggregateFunction
/*    */ {
/*    */   public Object calculate(List<HashMap<String, Object>> argRows, String argColumnKey) {
/* 19 */     Set<Object> disctinctObjects = new HashSet();
/* 20 */     for (HashMap<String, Object> row : argRows) {
/*    */       
/* 22 */       Object obj = row.get(argColumnKey);
/* 23 */       if (obj != null && 
/* 24 */         !disctinctObjects.contains(obj)) {
/* 25 */         disctinctObjects.add(obj);
/*    */       }
/*    */     } 
/*    */ 
/*    */     
/* 30 */     return Integer.valueOf(disctinctObjects.size());
/*    */   }
/*    */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-posframework.jar!\dtv\pos\framework\reporting\dataset\function\CountDistinctAggregateFunction.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */