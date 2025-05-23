/*    */ package dtv.pos.framework.ui.view;
/*    */ 
/*    */ import dtv.pos.framework.ui.TextViewElement;
/*    */ import javax.swing.ImageIcon;
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
/*    */ public class SimpleTextViewElement
/*    */   extends TextViewElement
/*    */ {
/*    */   public SimpleTextViewElement(String argObject) {
/* 25 */     super(FF.getSimpleFormattable(argObject));
/*    */   }
/*    */ 
/*    */   
/*    */   public SimpleTextViewElement(String argObject, ImageIcon argImage) {
/* 30 */     super(FF.getSimpleFormattable(argObject), argImage);
/*    */   }
/*    */ 
/*    */   
/*    */   public SimpleTextViewElement(String argObject, String argResourceName) {
/* 35 */     super(FF.getSimpleFormattable(argObject), argResourceName);
/*    */   }
/*    */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-posframework.jar!\dtv\pos\framewor\\ui\view\SimpleTextViewElement.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */