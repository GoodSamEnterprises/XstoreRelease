/*    */ package dtv.data2.access;
/*    */ 
/*    */ import org.springframework.beans.factory.BeanFactory;
/*    */ import org.springframework.beans.factory.BeanFactoryAware;
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
/*    */ class DataFactoryAssistant
/*    */   implements BeanFactoryAware
/*    */ {
/*    */   private static BeanFactory _beanFactory;
/*    */   
/*    */   static IDataFactory getDataFactory() {
/* 22 */     return (IDataFactory)_beanFactory.getBean(IDataFactory.class);
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public void setBeanFactory(BeanFactory argBeanFactory) {
/* 28 */     _beanFactory = argBeanFactory;
/*    */   }
/*    */ }


/* Location:              C:\Base_Xstore_workspace_code\release\xstore\xstore\lib\dtv-data2.jar!\dtv\data2\access\DataFactoryAssistant.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */