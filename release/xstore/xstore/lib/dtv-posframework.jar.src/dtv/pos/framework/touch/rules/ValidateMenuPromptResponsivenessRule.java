/*    */ package dtv.pos.framework.touch.rules;
/*    */ 
/*    */ import dtv.pos.framework.event.KeyActionPair;
/*    */ import dtv.pos.framework.event.XstKeyEventDispatcher;
/*    */ import dtv.pos.iframework.action.IXstAction;
/*    */ import dtv.pos.iframework.action.IXstChainAction;
/*    */ import dtv.pos.iframework.action.IXstDataAction;
/*    */ import dtv.pos.iframework.ui.config.ITouchConfig;
/*    */ import java.awt.event.MouseEvent;
/*    */ import java.util.Collection;
/*    */ import javax.inject.Inject;
/*    */ import javax.swing.Action;
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
/*    */ public class ValidateMenuPromptResponsivenessRule
/*    */   extends AbstractTouchResponsivenessRule
/*    */ {
/*    */   @Inject
/*    */   private XstKeyEventDispatcher _keyEventDispatcher;
/*    */   
/*    */   protected IXstAction getAction(MouseEvent argE) {
/* 31 */     IXstAction action = null;
/* 32 */     ITouchConfig config = getParentConfigObject();
/* 33 */     if (config != null) {
/* 34 */       action = config.getAction();
/*    */     }
/*    */     
/* 37 */     if (action == null && argE.getSource() instanceof IXstAction) {
/* 38 */       action = (IXstAction)argE.getSource();
/*    */     }
/*    */     
/* 41 */     return action;
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   protected boolean isResponsiveImpl(MouseEvent argE) {
/* 47 */     IXstAction key = getAction(argE);
/* 48 */     Collection<? extends KeyActionPair> mappings = this._keyEventDispatcher.getCurrentMappings();
/*    */     
/* 50 */     if (mappings != null)
/*    */     {
/* 52 */       for (KeyActionPair pair : mappings) {
/* 53 */         Action action = pair.getAction();
/*    */         
/* 55 */         if (!(action instanceof IXstAction)) {
/*    */           continue;
/*    */         }
/*    */         
/* 59 */         IXstAction xstAction = (IXstAction)action;
/* 60 */         if (checkAction(xstAction, key.getActionKey().toString()))
/*    */         {
/* 62 */           return true;
/*    */         }
/*    */       } 
/*    */     }
/*    */     
/* 67 */     return false;
/*    */   }
/*    */ 
/*    */   
/*    */   private boolean checkAction(IXstAction argAction, String argKey) {
/* 72 */     if (argKey.equalsIgnoreCase(argAction.getName()))
/*    */     {
/* 74 */       return true;
/*    */     }
/*    */     
/* 77 */     if (argAction instanceof IXstDataAction) {
/* 78 */       IXstDataAction action = (IXstDataAction)argAction;
/*    */       
/* 80 */       if (argKey.equalsIgnoreCase(action.getActionKey().toString()))
/*    */       {
/* 82 */         return true;
/*    */       }
/*    */     } 
/*    */     
/* 86 */     if (argAction instanceof IXstChainAction) {
/* 87 */       IXstChainAction action = (IXstChainAction)argAction;
/*    */       
/* 89 */       if (argKey.equalsIgnoreCase(action.getOpChainKey().toString()))
/*    */       {
/* 91 */         return true;
/*    */       }
/*    */     } 
/*    */     
/* 95 */     return false;
/*    */   }
/*    */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-posframework.jar!\dtv\pos\framework\touch\rules\ValidateMenuPromptResponsivenessRule.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */