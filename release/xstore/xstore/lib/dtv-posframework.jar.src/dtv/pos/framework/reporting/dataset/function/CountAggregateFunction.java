/*    */ package dtv.pos.framework.reporting.dataset.function;
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
/*    */ public class CountAggregateFunction
/*    */   implements IAggregateFunction
/*    */ {
/*    */   public Object calculate(List<HashMap<String, Object>> argRows, String argColumnKey) {
/* 22 */     Object obj = new Integer(argRows.size());
/* 23 */     return obj;
/*    */   }
/*    */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-posframework.jar!\dtv\pos\framework\reporting\dataset\function\CountAggregateFunction.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */