/*    */ package dtv.pos.framework.ui.context;
/*    */ 
/*    */ import dtv.pos.framework.ui.config.ColorRefConfig;
/*    */ import dtv.pos.iframework.ui.config.IRendererConfig;
/*    */ import dtv.ui.StringObjectPair;
/*    */ import dtv.util.config.AbstractParentConfig;
/*    */ import dtv.util.config.IConfigObject;
/*    */ import dtv.util.config.IReflectionParameterCapable;
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
/*    */ public class ComponentPropertyConfig
/*    */   extends AbstractParentConfig
/*    */ {
/*    */   private static final long serialVersionUID = 1L;
/*    */   public static final String MAIN_TAG = "ComponentProperty";
/*    */   private String property_;
/*    */   private StringObjectPair value_;
/*    */   
/*    */   public Object getProperty() {
/* 31 */     return this.property_;
/*    */   }
/*    */   
/*    */   public StringObjectPair getPropertyValue() {
/* 35 */     return this.value_;
/*    */   }
/*    */ 
/*    */   
/*    */   public void setConfigObject(String argKey, IConfigObject argValue) {
/* 40 */     if ("Property".equalsIgnoreCase(argKey)) {
/* 41 */       this.property_ = argValue.toString();
/*    */     } else {
/*    */       
/* 44 */       String val = argKey.toLowerCase();
/* 45 */       switch (val) {
/*    */         case "value":
/*    */         case "complexvalue":
/* 48 */           if (argValue instanceof IRendererConfig) {
/* 49 */             this.value_ = new StringObjectPair(this.property_, ((IRendererConfig)argValue).getRenderer());
/*    */           }
/* 51 */           else if (argValue instanceof ColorRefConfig) {
/* 52 */             this.value_ = new StringObjectPair(this.property_, ((ColorRefConfig)argValue).getParamValue());
/*    */           }
/* 54 */           else if (argValue instanceof dtv.pos.iframework.ui.config.IViewComponentConfig) {
/* 55 */             this.value_ = new StringObjectPair(this.property_, argValue);
/*    */           }
/* 57 */           else if (argValue instanceof dtv.i18n.config.IFormattableConfig) {
/* 58 */             this.value_ = new StringObjectPair(this.property_, argValue);
/*    */           }
/* 60 */           else if (argValue instanceof dtv.pos.framework.ui.config.IconGroupConfig) {
/* 61 */             this.value_ = new StringObjectPair(this.property_, argValue);
/*    */           }
/* 63 */           else if (argValue instanceof dtv.util.config.StringConfig) {
/* 64 */             this.value_ = new StringObjectPair(this.property_, argValue);
/*    */           }
/* 66 */           else if (argValue instanceof IReflectionParameterCapable) {
/* 67 */             this
/* 68 */               .value_ = new StringObjectPair(this.property_, ((IReflectionParameterCapable)argValue).getParamValue());
/*    */           } 
/*    */           return;
/*    */       } 
/*    */       
/* 73 */       warnUnsupported(argKey, argValue);
/*    */     } 
/*    */   }
/*    */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-posframework.jar!\dtv\pos\framewor\\ui\context\ComponentPropertyConfig.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */