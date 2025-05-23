/*    */ package dtv.pos.i18n.config;
/*    */ 
/*    */ import dtv.i18n.FormattableFactory;
/*    */ import dtv.i18n.IFormattable;
/*    */ import dtv.i18n.config.IFormattableConfig;
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
/*    */ 
/*    */ 
/*    */ public class AppendingFormattableConfig
/*    */   extends AbstractParentConfig
/*    */   implements IFormattableConfig
/*    */ {
/*    */   private static final long serialVersionUID = 1L;
/*    */   private static final String SEPARATOR_TAG = "Separator";
/* 29 */   private final List<IFormattableConfig> formattables_ = new ArrayList<>();
/*    */   
/* 31 */   private String separator_ = null;
/*    */ 
/*    */ 
/*    */   
/*    */   public String getConfigDataType() {
/* 36 */     return "AppendingFormattable";
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public String getConfigValue() {
/* 42 */     return null;
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public IFormattable getFormattable() {
/* 48 */     return getFormattable((Object)null);
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public IFormattable getFormattable(Object argSourceObject) {
/* 54 */     IFormattable[] unformattedData = new IFormattable[this.formattables_.size()];
/* 55 */     for (int i = 0; i < this.formattables_.size(); i++) {
/* 56 */       unformattedData[i] = ((IFormattableConfig)this.formattables_.get(i)).getFormattable(argSourceObject);
/*    */     }
/*    */     
/* 59 */     IFormattable f = FormattableFactory.getInstance().getAppendingFormattable(this.separator_, unformattedData);
/* 60 */     f.setSourceDescription(getSourceDescription());
/* 61 */     return f;
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public Class<IFormattable> getParamDataType() {
/* 67 */     return IFormattable.class;
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public IFormattable getParamValue() {
/* 73 */     return getFormattable();
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public void setConfigObject(String argKey, IConfigObject argValue) {
/* 79 */     if (argKey.equalsIgnoreCase("Separator")) {
/* 80 */       this.separator_ = argValue.toString();
/*    */     }
/* 82 */     else if (argValue instanceof IFormattableConfig) {
/* 83 */       this.formattables_.add((IFormattableConfig)argValue);
/*    */     } else {
/*    */       
/* 86 */       warnUnsupported(argKey, argValue);
/*    */     } 
/*    */   }
/*    */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-posframework.jar!\dtv\pos\i18n\config\AppendingFormattableConfig.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */