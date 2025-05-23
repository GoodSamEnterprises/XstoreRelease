/*    */ package dtv.pos.framework.form.config;
/*    */ 
/*    */ import dtv.pos.iframework.form.config.IFormValueEnumListConfig;
/*    */ import dtv.util.config.AbstractParentConfig;
/*    */ import dtv.util.config.IConfigObject;
/*    */ import java.util.ArrayList;
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
/*    */ public class FormValueEnumListConfig
/*    */   extends AbstractParentConfig
/*    */   implements IFormValueEnumListConfig
/*    */ {
/*    */   private static final long serialVersionUID = 1L;
/* 24 */   private final List<String> values_ = new ArrayList<>();
/*    */ 
/*    */   
/*    */   public List<? extends Object> getValues() {
/* 28 */     return (List)this.values_;
/*    */   }
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
/*    */   public void setConfigObject(String argKey, IConfigObject argValue) {
/* 41 */     if (argKey.equalsIgnoreCase("value")) {
/* 42 */       this.values_.add(argValue.toString());
/*    */     }
/*    */     else {
/*    */       
/* 46 */       warnUnsupported(argKey, argValue);
/*    */     } 
/*    */   }
/*    */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-posframework.jar!\dtv\pos\framework\form\config\FormValueEnumListConfig.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */