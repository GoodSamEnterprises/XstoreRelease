/*    */ package dtv.pos.framework.form.design.model;
/*    */ 
/*    */ import dtv.pos.framework.action.type.XstKeyStroke;
/*    */ import javax.swing.DefaultComboBoxModel;
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
/*    */ public class KeyStrokeComboBoxModel
/*    */   extends DefaultComboBoxModel
/*    */ {
/*    */   private static final long serialVersionUID = 1L;
/*    */   
/*    */   public KeyStrokeComboBoxModel() {
/* 24 */     addElement(null);
/* 25 */     addElement((E)XstKeyStroke.forName("ESCAPE"));
/* 26 */     addElement((E)XstKeyStroke.forName("F2"));
/* 27 */     addElement((E)XstKeyStroke.forName("F3"));
/* 28 */     addElement((E)XstKeyStroke.forName("F4"));
/* 29 */     addElement((E)XstKeyStroke.forName("F5"));
/* 30 */     addElement((E)XstKeyStroke.forName("F6"));
/* 31 */     addElement((E)XstKeyStroke.forName("F7"));
/* 32 */     addElement((E)XstKeyStroke.forName("F8"));
/* 33 */     addElement((E)XstKeyStroke.forName("F9"));
/* 34 */     addElement((E)XstKeyStroke.forName("F10"));
/* 35 */     addElement((E)XstKeyStroke.forName("F11"));
/*    */   }
/*    */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-posframework.jar!\dtv\pos\framework\form\design\model\KeyStrokeComboBoxModel.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */