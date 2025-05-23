/*    */ package dtv.pos.framework.form.component;
/*    */ 
/*    */ import dtv.i18n.IFormattable;
/*    */ import dtv.i18n.LocaleManager;
/*    */ import dtv.pos.iframework.form.config.IFormComponentConfig;
/*    */ import dtv.pos.iframework.ui.model.IFormModel;
/*    */ import dtv.ui.touch.animation.HiddenButton;
/*    */ import dtv.ui.touch.animation.IHasHiddenButton;
/*    */ import java.awt.Container;
/*    */ import java.awt.event.ActionEvent;
/*    */ import java.awt.event.ActionListener;
/*    */ import javax.swing.JComponent;
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
/*    */ public class FormHiddenButton<T extends IFormModel>
/*    */   extends AbstractFormComponent<T>
/*    */ {
/*    */   private HiddenButton button_;
/*    */   
/*    */   public FormHiddenButton() {
/* 34 */     this.button_ = new HiddenButton();
/* 35 */     this.button_.addActionListener(new ActionListener()
/*    */         {
/*    */           public void actionPerformed(ActionEvent argE)
/*    */           {
/* 39 */             FormHiddenButton.this.actionPerformed(argE);
/*    */           }
/*    */         });
/* 42 */     setComponent((JComponent)this.button_);
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public void init(IFormComponentConfig<?> argCfg) {
/* 48 */     super.init(argCfg);
/* 49 */     setText(this.textKey_);
/*    */   }
/*    */   
/*    */   protected void actionPerformed(ActionEvent argE) {
/* 53 */     getParent().hiddenButtonPressed(argE);
/*    */   }
/*    */   
/*    */   protected HiddenButton getButton() {
/* 57 */     return this.button_;
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   protected Object getComponentValue() {
/* 63 */     return this.button_.getText();
/*    */   }
/*    */   
/*    */   protected IHasHiddenButton getParent() {
/* 67 */     Container c = getButton().getParent();
/* 68 */     while (c != null && !(c instanceof IHasHiddenButton)) {
/* 69 */       c = c.getParent();
/*    */     }
/* 71 */     return (IHasHiddenButton)c;
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   protected void setComponentValue(Object argValue) {
/* 77 */     setText(argValue);
/*    */   }
/*    */   
/*    */   protected void setText(Object argText) {
/* 81 */     if (argText != null)
/* 82 */       if (argText instanceof IFormattable) {
/* 83 */         this.button_.setText(LocaleManager.getInstance().getRegisteredString((IFormattable)argText).toString());
/*    */       } else {
/*    */         
/* 86 */         this.button_.setText(argText.toString());
/*    */       }  
/*    */   }
/*    */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-posframework.jar!\dtv\pos\framework\form\component\FormHiddenButton.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */