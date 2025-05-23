/*    */ package dtv.data2.access;
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
/*    */ public abstract class AbstractInstanceGenerator<T>
/*    */ {
/*    */   public T newInstance() throws InstantiationException, IllegalAccessException {
/* 20 */     return getType().newInstance();
/*    */   }
/*    */   
/*    */   protected abstract Class<? extends T> getType();
/*    */ }


/* Location:              C:\Base_Xstore_workspace_code\release\xstore\xstore\lib\dtv-data2.jar!\dtv\data2\access\AbstractInstanceGenerator.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */