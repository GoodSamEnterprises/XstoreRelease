/*    */ package dtv.pos.framework.form.design.dialog;
/*    */ 
/*    */ import dtv.pos.iframework.form.design.type.FormPreviewType;
/*    */ import dtv.ui.UIServices;
/*    */ import java.awt.Frame;
/*    */ import javax.swing.JComponent;
/*    */ import javax.swing.JDialog;
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
/*    */ public class FormPreviewDialog
/*    */   extends JDialog
/*    */ {
/*    */   private static final long serialVersionUID = 1L;
/*    */   
/*    */   public FormPreviewDialog(Frame argOwner, String argTitle, JComponent argForm, FormPreviewType argType) {
/* 25 */     super(argOwner, argTitle, true);
/* 26 */     getContentPane().add(argForm);
/* 27 */     setDefaultCloseOperation(2);
/* 28 */     setResizable(false);
/* 29 */     argForm.setMinimumSize(argType.getSize());
/* 30 */     argForm.setPreferredSize(argType.getSize());
/* 31 */     argForm.setSize(argType.getSize());
/* 32 */     pack();
/* 33 */     UIServices.centerComponent(this);
/*    */   }
/*    */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-posframework.jar!\dtv\pos\framework\form\design\dialog\FormPreviewDialog.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */