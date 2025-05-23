/*    */ package dtv.pos.framework;
/*    */ 
/*    */ import com.micros.xstore.config.common.Action;
/*    */ import com.micros.xstore.config.common.Parameter;
/*    */ import com.micros.xstore.config.common.TranslatableType;
/*    */ import dtv.i18n.FormattableFactory;
/*    */ import dtv.i18n.IFormattable;
/*    */ import dtv.i18n.IResourceFormattable;
/*    */ import dtv.pos.iframework.visibilityrules.IVisibilityRule;
/*    */ import dtv.util.ObjectUtils;
/*    */ import dtv.util.config.ConfigException;
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
/*    */ public class ConfigToObjectUtils
/*    */ {
/* 24 */   private static final Logger _logger = Logger.getLogger(ConfigToObjectUtils.class);
/* 25 */   private FormattableFactory _translations = FormattableFactory.getInstance();
/*    */   
/*    */   public IFormattable buildFormattable(TranslatableType argTranslatableConfig) {
/* 28 */     IFormattable f = this._translations.getSimpleFormattable(argTranslatableConfig.getName());
/*    */     
/* 30 */     f.setSourceDescription(argTranslatableConfig.getSourceDescription());
/*    */     
/* 32 */     if (argTranslatableConfig.getBundle() != null) {
/* 33 */       if (f instanceof IResourceFormattable) {
/* 34 */         ((IResourceFormattable)f).setResourceBundleName(argTranslatableConfig.getBundle());
/*    */       } else {
/*    */         
/* 37 */         _logger.warn("unable to use bundle " + argTranslatableConfig.getBundle() + ";" + 
/* 38 */             ObjectUtils.getClassNameFromObject(f) + " does not implement " + IResourceFormattable.class
/* 39 */             .getName() + ":" + argTranslatableConfig.getSourceDescription());
/*    */       } 
/*    */     }
/*    */     
/* 43 */     return f;
/*    */   }
/*    */   
/*    */   public IVisibilityRule buildVisibilityRule(Action.VisibilityRule argRuleConfig) {
/* 47 */     if (argRuleConfig.getClazz() == null) {
/* 48 */       return null;
/*    */     }
/*    */     
/*    */     try {
/* 52 */       IVisibilityRule rule = argRuleConfig.getClazz().newInstance();
/* 53 */       rule.setSourceDescription(argRuleConfig.getSourceDescription());
/*    */       
/* 55 */       if (argRuleConfig.getInverted() != null) {
/* 56 */         String inverted = String.valueOf(argRuleConfig.getInverted().booleanValue());
/* 57 */         rule.setParameter("inverted", inverted);
/*    */       } 
/*    */       
/* 60 */       for (Parameter param : argRuleConfig.getParameters()) {
/* 61 */         rule.setParameter(param.getName(), param.getValue());
/*    */       }
/*    */       
/* 64 */       return rule;
/*    */     }
/* 66 */     catch (ReflectiveOperationException ex) {
/* 67 */       _logger.error("An error occurred creating a visibility rule from the config at " + argRuleConfig
/*    */           
/* 69 */           .getSourceDescription(), ex);
/* 70 */       throw new ConfigException(ex);
/*    */     } 
/*    */   }
/*    */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-posframework.jar!\dtv\pos\framework\ConfigToObjectUtils.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */