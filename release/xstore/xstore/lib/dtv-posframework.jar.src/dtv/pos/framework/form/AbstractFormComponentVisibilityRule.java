/*    */ package dtv.pos.framework.form;
/*    */ 
/*    */ import dtv.pos.iframework.visibilityrules.IVisibilityRule;
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
/*    */ 
/*    */ public abstract class AbstractFormComponentVisibilityRule
/*    */   implements IVisibilityRule
/*    */ {
/*    */   private String _sourceDescription;
/*    */   
/*    */   public int compareTo(IVisibilityRule argO) {
/* 27 */     return 0;
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public int getGroup() {
/* 33 */     return 0;
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public String getSourceDescription() {
/* 39 */     return this._sourceDescription;
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public boolean isGranter() {
/* 46 */     return true;
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public void setParameter(String argName, String argValue) {}
/*    */ 
/*    */ 
/*    */   
/*    */   public void setSourceDescription(String argSourceDescription) {
/* 56 */     this._sourceDescription = argSourceDescription;
/*    */   }
/*    */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-posframework.jar!\dtv\pos\framework\form\AbstractFormComponentVisibilityRule.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */