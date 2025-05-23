/*    */ package dtv.pos.framework.ui.view;
/*    */ 
/*    */ import dtv.pos.common.ConfigurationMgr;
/*    */ import dtv.pos.iframework.action.IXstAction;
/*    */ import dtv.pos.iframework.visibilityrules.AccessLevel;
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
/*    */ public class UIViewUtils
/*    */ {
/*    */   public static final boolean isActionHidden(IXstAction argAction) {
/* 22 */     return (isPrivilegeDenied(argAction) && isDeniedSecureOptionHidden());
/*    */   }
/*    */   
/*    */   public static final boolean isDeniedSecureOptionHidden() {
/* 26 */     return ConfigurationMgr.getHelper()
/* 27 */       .getBoolean(new String[] { "Store", "SystemConfig", "HideDeniedSecureOption" }, false);
/*    */   }
/*    */   
/*    */   public static final boolean isPrivilegeDenied(IXstAction argAction) {
/* 31 */     return AccessLevel.DENIED_PRIVILEGED.equals(argAction.evaluateVisibility());
/*    */   }
/*    */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-posframework.jar!\dtv\pos\framewor\\ui\view\UIViewUtils.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */