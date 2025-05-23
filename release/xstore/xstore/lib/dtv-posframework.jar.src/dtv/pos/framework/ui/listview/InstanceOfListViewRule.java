/*    */ package dtv.pos.framework.ui.listview;
/*    */ 
/*    */ import dtv.util.config.ClassConfig;
/*    */ import dtv.util.config.IConfigObject;
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
/*    */ public class InstanceOfListViewRule
/*    */   extends AbstractListViewRule
/*    */ {
/* 20 */   private static final Logger logger = Logger.getLogger(InstanceOfListViewRule.class);
/*    */   
/* 22 */   private Class<?> configuredClass = null;
/*    */ 
/*    */   
/*    */   public boolean checkListViewRule(Object argData) {
/* 26 */     return getConfiguredClass().isInstance(argData);
/*    */   }
/*    */   
/*    */   protected Class<?> getConfiguredClass() {
/* 30 */     if (this.configuredClass == null) {
/* 31 */       IConfigObject param = getParameter();
/* 32 */       if (param instanceof ClassConfig) {
/* 33 */         this.configuredClass = ((ClassConfig)param).getValue();
/*    */       } else {
/*    */         
/* 36 */         logger.warn("this rule expects a class to be configured as it's paramter;" + getParameter() + " was configured");
/*    */         
/* 38 */         this.configuredClass = BogusClass.class;
/*    */       } 
/*    */     } 
/* 41 */     return this.configuredClass;
/*    */   }
/*    */   
/*    */   private class BogusClass {}
/*    */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-posframework.jar!\dtv\pos\framewor\\ui\listview\InstanceOfListViewRule.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */