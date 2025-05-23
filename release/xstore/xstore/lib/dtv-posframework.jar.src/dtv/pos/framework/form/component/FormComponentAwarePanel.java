/*    */ package dtv.pos.framework.form.component;
/*    */ 
/*    */ import dtv.pos.iframework.ui.model.IFormModel;
/*    */ import dtv.pos.ui.component.PosFormPanel;
/*    */ import java.awt.Component;
/*    */ import java.awt.Dimension;
/*    */ import javax.swing.JLabel;
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
/*    */ public class FormComponentAwarePanel
/*    */   extends FormPanel<IFormModel>
/*    */ {
/* 24 */   private static final Dimension EMPTY_DIMENSION = new Dimension(0, 0);
/*    */   
/*    */   public FormComponentAwarePanel() {
/* 27 */     super(new ComponentAwarePanel(), false);
/*    */   }
/*    */ 
/*    */   
/*    */   public static class ComponentAwarePanel
/*    */     extends PosFormPanel
/*    */   {
/*    */     private static final long serialVersionUID = 1L;
/*    */ 
/*    */     
/*    */     public Dimension getMaximumSize() {
/* 38 */       if (!isValidPanel()) {
/* 39 */         setBounds(0, 0, 0, 0);
/* 40 */         return FormComponentAwarePanel.EMPTY_DIMENSION;
/*    */       } 
/*    */       
/* 43 */       return super.getMaximumSize();
/*    */     }
/*    */ 
/*    */ 
/*    */     
/*    */     public Dimension getMinimumSize() {
/* 49 */       if (!isValidPanel()) {
/* 50 */         setBounds(0, 0, 0, 0);
/* 51 */         return FormComponentAwarePanel.EMPTY_DIMENSION;
/*    */       } 
/*    */       
/* 54 */       return super.getMinimumSize();
/*    */     }
/*    */ 
/*    */ 
/*    */     
/*    */     public Dimension getPreferredSize() {
/* 60 */       if (!isValidPanel()) {
/* 61 */         setBounds(0, 0, 0, 0);
/* 62 */         return FormComponentAwarePanel.EMPTY_DIMENSION;
/*    */       } 
/*    */       
/* 65 */       return super.getPreferredSize();
/*    */     }
/*    */     
/*    */     protected boolean isValidPanel() {
/* 69 */       boolean invalid = false;
/* 70 */       for (Component c : getComponents()) {
/* 71 */         if (c instanceof JLabel) {
/* 72 */           JLabel l = (JLabel)c;
/* 73 */           if (l.getText() == null && l.getIcon() == null) {
/* 74 */             invalid = true;
/*    */             
/*    */             break;
/*    */           } 
/*    */         } 
/*    */       } 
/* 80 */       return !invalid;
/*    */     }
/*    */   }
/*    */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-posframework.jar!\dtv\pos\framework\form\component\FormComponentAwarePanel.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */