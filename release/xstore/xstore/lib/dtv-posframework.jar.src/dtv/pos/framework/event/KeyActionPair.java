/*    */ package dtv.pos.framework.event;
/*    */ 
/*    */ import dtv.util.CompositeObject;
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
/*    */ public class KeyActionPair
/*    */   extends CompositeObject.TwoPiece<KeyStroke, Action>
/*    */ {
/*    */   private static final long serialVersionUID = 1L;
/*    */   
/*    */   public KeyActionPair(KeyStroke keyStroke, Action action) {
/* 30 */     super(keyStroke, action);
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public Action getAction() {
/* 38 */     return (Action)b();
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public KeyStroke getKeyStroke() {
/* 46 */     return (KeyStroke)a();
/*    */   }
/*    */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-posframework.jar!\dtv\pos\framework\event\KeyActionPair.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */