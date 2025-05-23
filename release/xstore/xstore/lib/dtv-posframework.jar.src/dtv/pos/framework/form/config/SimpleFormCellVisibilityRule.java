/*    */ package dtv.pos.framework.form.config;
/*    */ 
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
/*    */ public class SimpleFormCellVisibilityRule
/*    */   extends AbstractFormComponentVisibilityRule
/*    */ {
/*    */   private final boolean _visible;
/*    */   
/*    */   public SimpleFormCellVisibilityRule(boolean argVisible) {
/* 22 */     this._visible = argVisible;
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public IAccessLevel checkVisibility() throws Exception {
/* 29 */     return this._visible ? (IAccessLevel)AccessLevel.GRANTED : (IAccessLevel)AccessLevel.DENIED;
/*    */   }
/*    */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-posframework.jar!\dtv\pos\framework\form\config\SimpleFormCellVisibilityRule.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */