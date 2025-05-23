/*    */ package dtv.pos.framework.form.config;
/*    */ 
/*    */ import dtv.util.config.AbstractSetConfig;
/*    */ import dtv.util.config.IConfigObject;
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
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class FormLayoutSetConfig
/*    */   extends AbstractSetConfig<FormLayoutConfig>
/*    */ {
/*    */   private static final long serialVersionUID = 1L;
/*    */   public static final String MAIN_TAG = "FormLayoutSet";
/*    */   private static final String DEFAULT_LAYOUT_TAG = "DefaultLayout";
/*    */   private String defaultLayoutName_;
/*    */   
/*    */   public String getChildTag() {
/* 34 */     return "FormLayout";
/*    */   }
/*    */ 
/*    */   
/*    */   public String getDefaultLayoutName() {
/* 39 */     return this.defaultLayoutName_;
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public void setConfigObject(String argKey, IConfigObject argValue) {
/* 50 */     if (argKey.equalsIgnoreCase("DefaultLayout")) {
/* 51 */       setDefaultLayoutName(argValue.toString());
/*    */     } else {
/*    */       
/* 54 */       super.setConfigObject(argKey, argValue);
/*    */     } 
/*    */   }
/*    */ 
/*    */   
/*    */   private void setDefaultLayoutName(String argDefault) {
/* 60 */     this.defaultLayoutName_ = argDefault.trim().toUpperCase();
/*    */   }
/*    */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-posframework.jar!\dtv\pos\framework\form\config\FormLayoutSetConfig.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */