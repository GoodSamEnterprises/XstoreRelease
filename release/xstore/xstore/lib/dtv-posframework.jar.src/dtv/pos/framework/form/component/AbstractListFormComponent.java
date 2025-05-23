/*    */ package dtv.pos.framework.form.component;
/*    */ 
/*    */ import dtv.pos.iframework.ui.model.IFormModel;
/*    */ import java.util.List;
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
/*    */ public abstract class AbstractListFormComponent<T extends IFormModel>
/*    */   extends AbstractFormComponent<T>
/*    */ {
/* 21 */   private static final Logger logger_ = Logger.getLogger(AbstractListFormComponent.class);
/*    */ 
/*    */ 
/*    */   
/*    */   protected Object getComponentValue() {
/* 26 */     return getSelections();
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   protected abstract List<Object> getSelections();
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   protected void setComponentValue(Object argValue) {
/* 40 */     if (argValue == null || argValue instanceof List) {
/* 41 */       setSelections((List<Object>)argValue);
/*    */     } else {
/*    */       
/* 44 */       logger_.warn("Attempting to set a non-list value to a list " + argValue);
/*    */     } 
/*    */   }
/*    */   
/*    */   protected abstract void setSelections(List<Object> paramList);
/*    */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-posframework.jar!\dtv\pos\framework\form\component\AbstractListFormComponent.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */