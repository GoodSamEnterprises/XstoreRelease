/*    */ package dtv.pos.framework.form.component;
/*    */ 
/*    */ import dtv.event.Eventor;
/*    */ import dtv.event.IEventSource;
/*    */ import dtv.event.eventor.DefaultEventor;
/*    */ import dtv.pos.framework.biometric.fingerprint.FingerEnum;
/*    */ import dtv.pos.framework.biometric.fingerprint.FingerprintHandDisplay;
/*    */ import dtv.pos.framework.biometric.fingerprint.FingerprintListModel;
/*    */ import dtv.pos.iframework.form.EditModelFieldChangeType;
/*    */ import dtv.pos.iframework.ui.model.IFormModel;
/*    */ import javax.swing.JComponent;
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
/*    */ 
/*    */ 
/*    */ public class FormBioHands<T extends IFormModel>
/*    */   extends AbstractFormComponent<T>
/*    */   implements IEventSource
/*    */ {
/* 33 */   private final Eventor events_ = (Eventor)new DefaultEventor(this);
/*    */   private final FingerprintHandDisplay fingerComponent_;
/*    */   private FingerprintListModel model_;
/* 36 */   private int currentSelection_ = 0;
/*    */   
/* 38 */   private final ListSelectionListener fingerChangedListener_ = new ListSelectionListener()
/*    */     {
/*    */       public void valueChanged(ListSelectionEvent e) {
/* 41 */         FormBioHands.this.setSelectionChanged();
/* 42 */         FormBioHands.this.events_.post(EditModelFieldChangeType.VALUE_CHANGED, FormBioHands.this.model_);
/*    */       }
/*    */     };
/*    */   
/*    */   public FormBioHands() {
/* 47 */     this.fingerComponent_ = new FingerprintHandDisplay();
/*    */     
/* 49 */     setComponent((JComponent)this.fingerComponent_);
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   protected Object getComponentValue() {
/* 55 */     return null;
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   protected void setComponentValue(Object value) {
/* 61 */     if (value instanceof FingerprintListModel) {
/* 62 */       this.model_ = (FingerprintListModel)value;
/* 63 */       this.model_.getSelectionModel().removeListSelectionListener(this.fingerChangedListener_);
/* 64 */       this.model_.getSelectionModel().addListSelectionListener(this.fingerChangedListener_);
/* 65 */       for (int i = 0; i < 10; i++) {
/* 66 */         this.fingerComponent_.setShowFinger(i, this.model_.isEnrolled(i));
/*    */       }
/* 68 */       if (!this.model_.getCurrentEnrolledCount().equals(this.model_.getMaximumEnrolledCount())) {
/* 69 */         this.fingerComponent_.setSelectedFinger(this.model_.getSelectedFinger());
/*    */       
/*    */       }
/* 72 */       else if (this.model_.isEnrolled(this.model_.getSelectedFinger().getSortOrder())) {
/* 73 */         this.fingerComponent_.setSelectedFinger(this.model_.getSelectedFinger());
/*    */       } else {
/*    */         
/* 76 */         this.fingerComponent_.setSelectedFinger(-1);
/*    */       }
/*    */     
/*    */     } else {
/*    */       
/* 81 */       this.model_ = null;
/* 82 */       for (int i = 0; i < 10; i++) {
/* 83 */         this.fingerComponent_.setShowFinger(i, false);
/*    */       }
/* 85 */       if (this.model_ == null) {
/* 86 */         this.fingerComponent_.setSelectedFinger(-1);
/*    */       }
/*    */     } 
/*    */   }
/*    */   
/*    */   private void setSelectionChanged() {
/* 92 */     int rowSelected = this.model_.getSelectionModel().getLeadSelectionIndex();
/* 93 */     if (this.currentSelection_ == rowSelected) {
/*    */       return;
/*    */     }
/* 96 */     this.currentSelection_ = rowSelected;
/* 97 */     FingerEnum finger = FingerEnum.getInstances()[rowSelected];
/* 98 */     this.fingerComponent_.setSelectedFinger(finger);
/* 99 */     this.model_.setSelectedFinger(finger);
/*    */   }
/*    */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-posframework.jar!\dtv\pos\framework\form\component\FormBioHands.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */