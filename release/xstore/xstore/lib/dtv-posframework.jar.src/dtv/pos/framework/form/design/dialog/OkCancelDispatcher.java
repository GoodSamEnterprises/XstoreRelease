/*     */ package dtv.pos.framework.form.design.dialog;
/*     */ 
/*     */ import java.awt.KeyEventDispatcher;
/*     */ import java.awt.KeyboardFocusManager;
/*     */ import java.awt.event.ActionEvent;
/*     */ import java.awt.event.ActionListener;
/*     */ import java.awt.event.KeyEvent;
/*     */ import java.util.ArrayList;
/*     */ import java.util.List;
/*     */ import javax.swing.JButton;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class OkCancelDispatcher
/*     */   implements KeyEventDispatcher
/*     */ {
/*  22 */   private final List<IOkCancelListener> listeners_ = new ArrayList<>();
/*     */   private final JButton okButton_;
/*     */   private final JButton cancelButton_;
/*     */   
/*  26 */   private final ActionListener okAction = new ActionListener()
/*     */     {
/*     */       public void actionPerformed(ActionEvent e) {
/*  29 */         OkCancelDispatcher.this.notifyListenersOk();
/*     */       }
/*     */     };
/*     */   
/*  33 */   private final ActionListener cancelAction = new ActionListener()
/*     */     {
/*     */       public void actionPerformed(ActionEvent e) {
/*  36 */         OkCancelDispatcher.this.notifyListenersCancel();
/*     */       }
/*     */     };
/*     */   
/*     */   public OkCancelDispatcher(JButton okButton, JButton cancelButton) {
/*  41 */     this.okButton_ = okButton;
/*  42 */     okButton.addActionListener(this.okAction);
/*  43 */     okButton.setDefaultCapable(true);
/*  44 */     okButton.getRootPane().setDefaultButton(okButton);
/*     */     
/*  46 */     this.cancelButton_ = cancelButton;
/*  47 */     cancelButton.addActionListener(this.cancelAction);
/*     */   }
/*     */   
/*     */   public void addOkCancelListener(IOkCancelListener l) {
/*  51 */     this.listeners_.add(l);
/*  52 */     if (this.listeners_.size() == 1) {
/*  53 */       register();
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean dispatchKeyEvent(KeyEvent keyEvent) {
/*  59 */     if (!checkViable()) {
/*  60 */       deregister();
/*  61 */       return false;
/*     */     } 
/*     */     
/*  64 */     if (keyEvent.getID() == 400) {
/*  65 */       switch (keyEvent.getKeyChar()) {
/*     */         case '\n':
/*  67 */           notifyListenersOk();
/*  68 */           keyEvent.consume();
/*  69 */           return true;
/*     */         
/*     */         case '\033':
/*  72 */           notifyListenersCancel();
/*  73 */           keyEvent.consume();
/*  74 */           return true;
/*     */       } 
/*     */     }
/*  77 */     return false;
/*     */   }
/*     */ 
/*     */   
/*     */   public void finalize() {
/*  82 */     deregister();
/*     */   }
/*     */   
/*     */   public void removeOkCancelListener(IOkCancelListener l) {
/*  86 */     this.listeners_.remove(l);
/*  87 */     if (this.listeners_.size() == 0) {
/*  88 */       deregister();
/*     */     }
/*     */   }
/*     */   
/*     */   protected void notifyListenersCancel() {
/*  93 */     for (int i = 0; i < this.listeners_.size(); i++) {
/*  94 */       ((IOkCancelListener)this.listeners_.get(i)).cancelSelected();
/*     */     }
/*     */   }
/*     */   
/*     */   protected void notifyListenersOk() {
/*  99 */     for (int i = 0; i < this.listeners_.size(); i++) {
/* 100 */       ((IOkCancelListener)this.listeners_.get(i)).okSelected();
/*     */     }
/*     */   }
/*     */   
/*     */   private boolean checkViable() {
/* 105 */     return ((this.okButton_ != null && this.okButton_.isVisible()) || (this.cancelButton_ != null && this.cancelButton_
/* 106 */       .isVisible()));
/*     */   }
/*     */   
/*     */   private void deregister() {
/* 110 */     KeyboardFocusManager.getCurrentKeyboardFocusManager().removeKeyEventDispatcher(this);
/*     */   }
/*     */   
/*     */   private void register() {
/* 114 */     KeyboardFocusManager.getCurrentKeyboardFocusManager().addKeyEventDispatcher(this);
/*     */   }
/*     */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-posframework.jar!\dtv\pos\framework\form\design\dialog\OkCancelDispatcher.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */