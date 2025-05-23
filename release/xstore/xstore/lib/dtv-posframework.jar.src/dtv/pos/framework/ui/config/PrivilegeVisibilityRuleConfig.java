/*    */ package dtv.pos.framework.ui.config;
/*    */ 
/*    */ import dtv.pos.framework.action.access.CurrentUserAccCheck;
/*    */ import dtv.util.config.ClassConfig;
/*    */ import dtv.util.config.IConfigObject;
/*    */ import dtv.util.config.ParameterConfig;
/*    */ import dtv.util.config.StringConfig;
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
/*    */ public class PrivilegeVisibilityRuleConfig
/*    */   extends VisibilityRuleConfig
/*    */ {
/*    */   private static final long serialVersionUID = 1L;
/*    */   
/*    */   public PrivilegeVisibilityRuleConfig(IConfigObject argParent, String argPrivilegeType) {
/* 30 */     setSourceInfo(argParent.getSourceUrl(), argParent.getSourceLineNumber());
/*    */     
/* 32 */     ClassConfig<?> classCfg = new ClassConfig(CurrentUserAccCheck.class);
/* 33 */     ParameterConfig paramCfg = new ParameterConfig("privilege", (IConfigObject)new StringConfig(argPrivilegeType));
/*    */     
/* 35 */     setConfigObject("class", (IConfigObject)classCfg);
/* 36 */     setConfigObject("parameter", (IConfigObject)paramCfg);
/*    */   }
/*    */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-posframework.jar!\dtv\pos\framewor\\ui\config\PrivilegeVisibilityRuleConfig.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */