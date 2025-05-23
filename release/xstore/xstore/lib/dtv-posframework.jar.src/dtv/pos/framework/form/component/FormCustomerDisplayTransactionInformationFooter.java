/*    */ package dtv.pos.framework.form.component;
/*    */ 
/*    */ import dtv.pos.iframework.form.component.IFormComponent;
/*    */ import java.awt.Color;
/*    */ import java.awt.Graphics;
/*    */ import java.awt.Image;
/*    */ import javax.swing.event.ListSelectionEvent;
/*    */ import javax.swing.event.ListSelectionListener;
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
/*    */ public class FormCustomerDisplayTransactionInformationFooter
/*    */   extends FormInformationPanel
/*    */   implements IFormComponent, ListSelectionListener
/*    */ {
/* 26 */   private static final Image imageFooterBackground_ = UIRM
/* 27 */     .getImage("_imageCustomerDisplayTransactionFooterBackground");
/* 28 */   private static final Color imageFooterBackgroundColor_ = UIRM.getRGBColor("_imageCustomerDisplayTransactionFooterBackgroundColor", new Color(77, 118, 149));
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public void valueChanged(ListSelectionEvent e) {
/* 34 */     updateFormLabels(this);
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   protected InformationPanel createInformationPanel() {
/* 40 */     return new InformationPanel();
/*    */   }
/*    */   
/*    */   protected void updateFormLabels(FormPanel argFormPanel) {
/* 44 */     if (argFormPanel == null) {
/*    */       return;
/*    */     }
/*    */     
/* 48 */     for (IFormComponent formComp : argFormPanel.getFormComponents()) {
/* 49 */       if (formComp instanceof FormLabel && ((FormLabel)formComp).getModelValue() != null) {
/* 50 */         ((FormLabel)formComp).updateComponentValue();
/*    */       }
/* 52 */       else if (formComp instanceof FormPanel) {
/* 53 */         updateFormLabels((FormPanel)formComp);
/*    */       } 
/*    */     } 
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   private class InformationPanel
/*    */     extends FormInformationPanel.InformationPanel
/*    */   {
/*    */     private static final long serialVersionUID = 1L;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */     
/*    */     private InformationPanel() {}
/*    */ 
/*    */ 
/*    */ 
/*    */     
/*    */     protected void paintBackground(Graphics g) {
/* 77 */       super.paintBackground(g);
/*    */       
/* 79 */       if (FormCustomerDisplayTransactionInformationFooter.imageFooterBackground_ == null) {
/* 80 */         g.setColor(FormCustomerDisplayTransactionInformationFooter.imageFooterBackgroundColor_);
/* 81 */         g.fillRect(0, 0, getWidth() - 1, getHeight());
/*    */       } else {
/*    */         
/* 84 */         g.drawImage(FormCustomerDisplayTransactionInformationFooter.imageFooterBackground_, 0, 0, getWidth() - 1, getHeight(), null);
/*    */       } 
/*    */     }
/*    */   }
/*    */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-posframework.jar!\dtv\pos\framework\form\component\FormCustomerDisplayTransactionInformationFooter.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */