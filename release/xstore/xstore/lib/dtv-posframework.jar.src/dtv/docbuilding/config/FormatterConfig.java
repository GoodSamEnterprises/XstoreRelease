/*    */ package dtv.docbuilding.config;
/*    */ 
/*    */ import dtv.i18n.formatter.output.IOutputFormatter;
/*    */ import dtv.i18n.formatter.output.NullFormatter;
/*    */ import dtv.util.StringUtils;
/*    */ import dtv.util.config.AbstractParentConfig;
/*    */ import dtv.util.config.ClassConfig;
/*    */ import dtv.util.config.ConfigUtils;
/*    */ import dtv.util.config.IConfigObject;
/*    */ import dtv.util.config.ParameterConfig;
/*    */ import java.util.ArrayList;
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
/*    */ public class FormatterConfig
/*    */   extends AbstractParentConfig
/*    */ {
/*    */   private static final long serialVersionUID = 1L;
/* 27 */   private static final Logger logger_ = Logger.getLogger(FormatterConfig.class);
/*    */   
/* 29 */   private final List<ParameterConfig> formatterParameters_ = new ArrayList<>();
/*    */   
/* 31 */   private String name_ = null;
/* 32 */   private ClassConfig<?> formatterClassConfig_ = null;
/* 33 */   private IOutputFormatter formatter_ = null;
/*    */   
/*    */   public IOutputFormatter getFormatter() {
/* 36 */     if ((((this.formatter_ == null) ? 1 : 0) & ((this.formatterClassConfig_ != null) ? 1 : 0)) != 0) {
/*    */       try {
/* 38 */         this.formatter_ = this.formatterClassConfig_.getValue().newInstance();
/* 39 */         for (ParameterConfig p : this.formatterParameters_) {
/* 40 */           p.setParameterOn(this.formatter_);
/*    */         }
/*    */       }
/* 43 */       catch (Exception ex) {
/* 44 */         logger_.error("CAUGHT EXCEPTION with config='" + getSourceDescription() + "'", ex);
/* 45 */         this.formatter_ = (IOutputFormatter)new NullFormatter();
/*    */       } 
/*    */     }
/* 48 */     return this.formatter_;
/*    */   }
/*    */   
/*    */   public String getName() {
/* 52 */     return this.name_;
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public void setConfigObject(String argKey, IConfigObject argValue) {
/* 59 */     if ("parameter".equalsIgnoreCase(argKey) && argValue instanceof ParameterConfig) {
/* 60 */       this.formatterParameters_.add((ParameterConfig)argValue);
/*    */     }
/* 62 */     else if ("name".equalsIgnoreCase(argKey)) {
/* 63 */       this.name_ = argValue.toString();
/*    */     }
/* 65 */     else if ("formatter_class".equalsIgnoreCase(argKey) || "class".equalsIgnoreCase(argKey)) {
/* 66 */       this.formatterClassConfig_ = ConfigUtils.toClassConfig(argValue);
/*    */     }
/* 68 */     else if ("ctx".equalsIgnoreCase(argKey)) {
/* 69 */       this.formatterParameters_.add(new ParameterConfig("setOutputContext", argValue));
/*    */     }
/* 71 */     else if (argValue instanceof dtv.util.config.StringConfig) {
/* 72 */       String setterName = "set" + StringUtils.ensureFirstUpperCase(argKey);
/* 73 */       this.formatterParameters_.add(new ParameterConfig(setterName, argValue));
/*    */     } else {
/*    */       
/* 76 */       warnUnsupported(argKey, argValue);
/*    */     } 
/*    */   }
/*    */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-posframework.jar!\dtv\docbuilding\config\FormatterConfig.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */