/*    */ package dtv.pos.framework.touch;
/*    */ 
/*    */ import dtv.pos.iframework.ui.ITouchResponsivenessRule;
/*    */ import dtv.util.config.AbstractConfig;
/*    */ import dtv.util.config.ConfigUtils;
/*    */ import dtv.util.config.IConfigObject;
/*    */ import dtv.util.config.ISavableConfig;
/*    */ import dtv.util.config.IXmlWriter;
/*    */ import dtv.util.config.ParameterConfig;
/*    */ import java.io.IOException;
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
/*    */ public class ResponsivenessRuleConfig
/*    */   extends AbstractConfig
/*    */   implements ISavableConfig
/*    */ {
/*    */   private static final long serialVersionUID = 1L;
/* 27 */   private static final Logger _logger = Logger.getLogger(ResponsivenessRuleConfig.class);
/*    */   
/* 29 */   private List<ParameterConfig> _parameters = new ArrayList<>();
/*    */ 
/*    */   
/*    */   private Class<?> _class;
/*    */ 
/*    */ 
/*    */   
/*    */   public ITouchResponsivenessRule getRule() {
/* 37 */     ITouchResponsivenessRule rule = null;
/* 38 */     if (this._class != null) {
/*    */       try {
/* 40 */         rule = (ITouchResponsivenessRule)this._class.newInstance();
/*    */ 
/*    */         
/* 43 */         for (ParameterConfig paramConfig : this._parameters) {
/* 44 */           rule.setParameter(paramConfig.getName(), paramConfig.getValue());
/*    */         }
/*    */       }
/* 47 */       catch (Exception ex) {
/* 48 */         _logger.error("Unable to instantiate rule class [" + this._class + "]", ex);
/*    */       } 
/*    */     } else {
/*    */       
/* 52 */       _logger.error("No class has been specified for this rule");
/*    */     } 
/*    */     
/* 55 */     return rule;
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public boolean isDirty() {
/* 61 */     return false;
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public void setClean() {}
/*    */ 
/*    */ 
/*    */   
/*    */   public void setConfigObject(String argKey, IConfigObject argValue) {
/* 71 */     if ("class".equalsIgnoreCase(argKey)) {
/* 72 */       this._class = ConfigUtils.toClass(argValue);
/*    */     }
/* 74 */     else if (argValue instanceof ParameterConfig) {
/* 75 */       this._parameters.add((ParameterConfig)argValue);
/*    */     } else {
/*    */       
/* 78 */       warnUnsupported(argKey, argValue);
/*    */     } 
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public void setValue(String argValue) {}
/*    */ 
/*    */ 
/*    */   
/*    */   public void write(IXmlWriter argWriter) throws IOException {
/* 90 */     argWriter.writeHeader("ResponsivenessRule", "ResponsivenessRule", "class=\"" + this._class.getName() + "\"");
/* 91 */     for (ParameterConfig p : this._parameters) {
/* 92 */       p.write(argWriter);
/*    */     }
/* 94 */     argWriter.writeFooter("ResponsivenessRule");
/*    */   }
/*    */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-posframework.jar!\dtv\pos\framework\touch\ResponsivenessRuleConfig.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */