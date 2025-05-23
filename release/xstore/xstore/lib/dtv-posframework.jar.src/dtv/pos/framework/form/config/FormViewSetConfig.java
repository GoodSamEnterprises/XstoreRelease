/*    */ package dtv.pos.framework.form.config;
/*    */ 
/*    */ import dtv.pos.iframework.form.config.IFormViewConfig;
/*    */ import dtv.pos.iframework.form.config.IFormViewSetConfig;
/*    */ import dtv.util.config.AbstractSetConfig;
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
/*    */ public class FormViewSetConfig
/*    */   extends AbstractSetConfig<IFormViewConfig>
/*    */   implements IFormViewSetConfig
/*    */ {
/*    */   private static final long serialVersionUID = 1L;
/*    */   public static final String MAIN_TAG = "FormViewSet";
/*    */   
/*    */   public String getChildTag() {
/* 25 */     return "FormView";
/*    */   }
/*    */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-posframework.jar!\dtv\pos\framework\form\config\FormViewSetConfig.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */