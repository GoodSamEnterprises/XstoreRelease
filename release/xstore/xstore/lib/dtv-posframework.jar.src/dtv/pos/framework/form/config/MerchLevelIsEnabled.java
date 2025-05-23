/*    */ package dtv.pos.framework.form.config;
/*    */ 
/*    */ import dtv.pos.common.ConfigurationMgr;
/*    */ import dtv.pos.framework.form.AbstractFormComponentVisibilityRule;
/*    */ import dtv.pos.iframework.visibilityrules.AccessLevel;
/*    */ import dtv.pos.iframework.visibilityrules.IAccessLevel;
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
/*    */ public class MerchLevelIsEnabled
/*    */   extends AbstractFormComponentVisibilityRule
/*    */ {
/*    */   private final int _level;
/*    */   
/*    */   public MerchLevelIsEnabled(int argLevel) {
/* 24 */     this._level = argLevel;
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public IAccessLevel checkVisibility() throws Exception {
/* 31 */     if (ConfigurationMgr.getNumberOfMerchHierLevels() >= this._level) {
/* 32 */       return (IAccessLevel)AccessLevel.GRANTED;
/*    */     }
/*    */     
/* 35 */     return (IAccessLevel)AccessLevel.DENIED;
/*    */   }
/*    */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-posframework.jar!\dtv\pos\framework\form\config\MerchLevelIsEnabled.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */