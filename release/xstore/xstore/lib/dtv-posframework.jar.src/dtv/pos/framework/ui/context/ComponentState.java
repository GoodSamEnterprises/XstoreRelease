/*    */ package dtv.pos.framework.ui.context;
/*    */ 
/*    */ import dtv.pos.iframework.ui.context.IComponentState;
/*    */ import dtv.util.config.ParameterListConfig;
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
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class ComponentState
/*    */   implements IComponentState
/*    */ {
/*    */   private final String compName_;
/*    */   private final boolean isVisible_;
/*    */   private final boolean isEnabled_;
/*    */   private final ParameterListConfig parameters_;
/*    */   
/*    */   public ComponentState(String argCompName, boolean argIsVisible, boolean argIsEnabled) {
/* 35 */     this(argCompName, argIsVisible, argIsEnabled, null);
/*    */   }
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
/*    */   public ComponentState(String argCompName, boolean argIsVisible, boolean argIsEnabled, ParameterListConfig argParameters) {
/* 50 */     this.compName_ = argCompName;
/* 51 */     this.isVisible_ = argIsVisible;
/* 52 */     this.isEnabled_ = argIsEnabled;
/* 53 */     this.parameters_ = argParameters;
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public String getComponentName() {
/* 62 */     return this.compName_;
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public ParameterListConfig getParameters() {
/* 71 */     return this.parameters_;
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public boolean isEnabled() {
/* 82 */     return this.isEnabled_;
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public boolean isVisible() {
/* 93 */     return this.isVisible_;
/*    */   }
/*    */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-posframework.jar!\dtv\pos\framewor\\ui\context\ComponentState.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */