/*    */ package dtv.pos.framework.ui.view;
/*    */ 
/*    */ import dtv.i18n.IFormattable;
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
/*    */ public class FormattableTextViewElement
/*    */   extends TextViewElement
/*    */ {
/*    */   public FormattableTextViewElement(IFormattable argMessage) {
/* 25 */     super(argMessage);
/*    */   }
/*    */ 
/*    */   
/*    */   public FormattableTextViewElement(IFormattable argMessage, ImageIcon argImage) {
/* 30 */     super(argMessage, argImage);
/*    */   }
/*    */ 
/*    */   
/*    */   public FormattableTextViewElement(IFormattable argMessage, String argResourceName) {
/* 35 */     super(argMessage, argResourceName);
/*    */   }
/*    */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-posframework.jar!\dtv\pos\framewor\\ui\view\FormattableTextViewElement.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */