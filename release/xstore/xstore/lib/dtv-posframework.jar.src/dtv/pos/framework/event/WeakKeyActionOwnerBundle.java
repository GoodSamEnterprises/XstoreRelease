/*    */ package dtv.pos.framework.event;
/*    */ 
/*    */ import dtv.pos.iframework.action.IActionOwner;
/*    */ import dtv.util.CompositeObject;
/*    */ import dtv.util.WeakReference;
/*    */ import java.lang.ref.WeakReference;
/*    */ import javax.swing.Action;
/*    */ import javax.swing.KeyStroke;
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
/*    */ 
/*    */ 
/*    */ 
/*    */ class WeakKeyActionOwnerBundle
/*    */   extends CompositeObject.ThreePiece<WeakReference<KeyStroke>, WeakReference<Action>, WeakReference<IActionOwner>>
/*    */ {
/*    */   private static final long serialVersionUID = 1L;
/*    */   
/*    */   public static WeakKeyActionOwnerBundle valueOf(KeyActionPair argPair, IActionOwner argOwner) {
/* 39 */     return new WeakKeyActionOwnerBundle(argPair.getKeyStroke(), argPair.getAction(), argOwner);
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public WeakKeyActionOwnerBundle(KeyStroke argKeyStroke, Action argAction, IActionOwner argActionOwner) {
/* 50 */     super(new WeakReference(argKeyStroke), new WeakReference(argAction), new WeakReference(argActionOwner));
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public Action getAction() {
/* 61 */     return ((WeakReference<Action>)b()).get();
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public IActionOwner getActionOwner() {
/* 71 */     return ((WeakReference<IActionOwner>)c()).get();
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public KeyStroke getKeyStroke() {
/* 81 */     return ((WeakReference<KeyStroke>)a()).get();
/*    */   }
/*    */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-posframework.jar!\dtv\pos\framework\event\WeakKeyActionOwnerBundle.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */