/*    */ package dtv.pos.framework.action.access;
/*    */ 
/*    */ import dtv.pos.iframework.visibilityrules.AccessLevel;
/*    */ import dtv.pos.iframework.visibilityrules.IAccessLevel;
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
/*    */ 
/*    */ 
/*    */ 
/*    */ public class HideForFormFactorRule
/*    */   extends AbstractVisibilityRule
/*    */ {
/*    */   private static final String PARAM_FORM_FACTOR = "FormFactor";
/* 27 */   private final List<String> _deniedFormFactors = new ArrayList<>();
/*    */   
/*    */   public List<String> getFormFactors() {
/* 30 */     return this._deniedFormFactors;
/*    */   }
/*    */   
/*    */   public void setFormFactors(List<String> argFormFactors) {
/* 34 */     this._deniedFormFactors.clear();
/* 35 */     this._deniedFormFactors.addAll(argFormFactors);
/*    */   }
/*    */ 
/*    */   
/*    */   public void setParameter(String argName, String argValue) {
/* 40 */     if ("FormFactor".equalsIgnoreCase(argName)) {
/* 41 */       this._deniedFormFactors.add(argValue.toString());
/*    */     } else {
/*    */       
/* 44 */       super.setParameter(argName, argValue);
/*    */     } 
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   protected IAccessLevel checkVisibilityImpl() throws Exception {
/* 52 */     AccessLevel accessLevel = AccessLevel.GRANTED;
/* 53 */     String formFactor = System.getProperty("dtv.location.device.formfactor");
/*    */     
/* 55 */     if (formFactor != null && this._deniedFormFactors.contains(formFactor)) {
/* 56 */       accessLevel = AccessLevel.DENIED;
/*    */     }
/*    */     
/* 59 */     return (IAccessLevel)accessLevel;
/*    */   }
/*    */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-posframework.jar!\dtv\pos\framework\action\access\HideForFormFactorRule.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */