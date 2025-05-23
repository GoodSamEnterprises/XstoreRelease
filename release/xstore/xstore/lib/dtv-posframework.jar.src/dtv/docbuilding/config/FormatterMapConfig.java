/*    */ package dtv.docbuilding.config;
/*    */ 
/*    */ import dtv.i18n.formatter.output.IOutputFormatter;
/*    */ import dtv.i18n.formatter.output.NullFormatter;
/*    */ import dtv.util.StringUtils;
/*    */ import dtv.util.config.AbstractParentConfig;
/*    */ import dtv.util.config.IConfigObject;
/*    */ import java.util.ArrayList;
/*    */ import java.util.List;
/*    */ import java.util.Map;
/*    */ import org.apache.commons.collections.map.CaseInsensitiveMap;
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
/*    */ public class FormatterMapConfig
/*    */   extends AbstractParentConfig
/*    */ {
/*    */   public static final String MAIN_TAG = "FormatterMap";
/*    */   private static final long serialVersionUID = 1L;
/* 30 */   private static final Logger logger_ = Logger.getLogger(FormatterMapConfig.class);
/* 31 */   private static final IOutputFormatter NULL_FORMATTER = (IOutputFormatter)new NullFormatter();
/*    */   
/* 33 */   private final List<FormatterConfig> formatterList_ = new ArrayList<>();
/*    */   
/* 35 */   private Map<String, IOutputFormatter> formatterMap_ = null;
/*    */   
/*    */   public IOutputFormatter getFormatter(String argName) {
/* 38 */     IOutputFormatter formatter = this.formatterMap_.get(argName);
/*    */     
/* 40 */     if (formatter != null) {
/* 41 */       return formatter;
/*    */     }
/*    */     
/* 44 */     if (!StringUtils.isEmpty(argName)) {
/* 45 */       logger_.warn("Invalid formatter type requested [" + argName + "] @@ " + getSourceDescription() + "'");
/*    */     }
/* 47 */     return NULL_FORMATTER;
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public void initialize() {
/* 53 */     if (this.formatterMap_ == null) {
/* 54 */       this.formatterMap_ = (Map<String, IOutputFormatter>)new CaseInsensitiveMap();
/* 55 */       for (FormatterConfig c : this.formatterList_) {
/* 56 */         this.formatterMap_.put(c.getName(), c.getFormatter());
/*    */       }
/*    */     } 
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public void setConfigObject(String argKey, IConfigObject argValue) {
/* 65 */     if (argValue instanceof FormatterConfig) {
/* 66 */       this.formatterList_.add((FormatterConfig)argValue);
/*    */     } else {
/*    */       
/* 69 */       warnUnsupported(argKey, argValue);
/*    */     } 
/*    */   }
/*    */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-posframework.jar!\dtv\docbuilding\config\FormatterMapConfig.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */