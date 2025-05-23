/*    */ package dtv.pos.framework.action;
/*    */ 
/*    */ import dtv.pos.iframework.action.IXstAction;
/*    */ import dtv.pos.iframework.visibilityrules.IAccessLevel;
/*    */ import java.util.ArrayList;
/*    */ import java.util.Arrays;
/*    */ import java.util.Collection;
/*    */ import java.util.Collections;
/*    */ import java.util.List;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class ActionChooser
/*    */ {
/* 20 */   private static final List<? extends IXstAction> _noActions = Collections.emptyList();
/*    */ 
/*    */ 
/*    */   
/*    */   private final List<? extends IXstAction> _actions;
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public ActionChooser(Collection<? extends IXstAction> argActions) {
/* 30 */     this._actions = (argActions == null) ? _noActions : new ArrayList<>(argActions);
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public ActionChooser(IXstAction... argActions) {
/* 38 */     this((argActions == null) ? (List)null : Arrays.<IXstAction>asList(argActions));
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
/*    */   public IXstAction getMostAccessibleAction() {
/* 50 */     IXstAction mostAccessible = null;
/*    */     
/* 52 */     if (this._actions != null && !this._actions.isEmpty()) {
/* 53 */       mostAccessible = this._actions.get(0);
/* 54 */       IAccessLevel mostAccessibleLevel = null;
/*    */       
/* 56 */       for (IXstAction action : this._actions) {
/* 57 */         if (action != null) {
/* 58 */           IAccessLevel level = action.evaluateVisibility();
/*    */           
/* 60 */           if (level.isGranted()) {
/*    */ 
/*    */             
/* 63 */             mostAccessible = action;
/*    */             
/*    */             break;
/*    */           } 
/* 67 */           if (mostAccessibleLevel == null || level.compareTo(mostAccessibleLevel) > 0) {
/*    */ 
/*    */             
/* 70 */             mostAccessible = action;
/* 71 */             mostAccessibleLevel = level;
/*    */           } 
/*    */         } 
/*    */       } 
/*    */     } 
/* 76 */     return mostAccessible;
/*    */   }
/*    */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-posframework.jar!\dtv\pos\framework\action\ActionChooser.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */