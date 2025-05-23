/*    */ package dtv.pos.framework.form;
/*    */ 
/*    */ import java.util.HashMap;
/*    */ import java.util.Map;
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
/*    */ public class DefaultEditModelSetFieldFilterFactory
/*    */   implements IEditModelSetFieldFilterFactory
/*    */ {
/* 19 */   private Map<String, IEditModelSetFieldFilter<?>> fieldMutators = new HashMap<>();
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public IEditModelSetFieldFilter<?> getSetFieldFilter(String argFieldName) {
/* 25 */     IEditModelSetFieldFilter<?> result = this.fieldMutators.get(argFieldName);
/* 26 */     return result;
/*    */   }
/*    */   
/*    */   public void setParameters(Map<String, IEditModelSetFieldFilter<?>> argParameters) {
/* 30 */     this.fieldMutators = argParameters;
/*    */   }
/*    */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-posframework.jar!\dtv\pos\framework\form\DefaultEditModelSetFieldFilterFactory.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */