/*    */ package dtv.pos.framework.biometric.fingerprint;
/*    */ 
/*    */ import dtv.pos.framework.form.BasicEditModel;
/*    */ import dtv.xst.dao.hrs.IEmployeeFingerprint;
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
/*    */ public class FingerprintEditModel
/*    */   extends BasicEditModel
/*    */ {
/*    */   private static final String FP_LIST_MODEL = "fingerprintListModel";
/*    */   private static final String SELECTED_FINGER = "selectedFinger";
/*    */   private static final String MAXIMUM_FINGER_COUNT = "maximumEnrolledFingerCount";
/*    */   private static final String CURRENT_FINGER_COUNT = "currentEnrolledFingerCount";
/*    */   private final FingerprintListModel fingerprintList_;
/*    */   
/*    */   public FingerprintEditModel(IEmployeeFingerprint[] argEnrolledFingers) {
/* 26 */     super(FF.getTranslatable("_fingerprintModelName"), FF.getTranslatable("_fingerprintModelDescription"));
/*    */     
/* 28 */     addField("fingerprintListModel", FingerprintListModel.class);
/* 29 */     addField("selectedFinger", FingerEnum.class);
/* 30 */     addField("maximumEnrolledFingerCount", Integer.class);
/* 31 */     addField("currentEnrolledFingerCount", Integer.class);
/*    */     
/* 33 */     this.fingerprintList_ = new FingerprintListModel(argEnrolledFingers);
/*    */     
/* 35 */     initializeFieldState();
/*    */   }
/*    */   
/*    */   public Integer getCurrentEnrolledFingerCount() {
/* 39 */     return this.fingerprintList_.getCurrentEnrolledCount();
/*    */   }
/*    */   
/*    */   public FingerprintListModel getFingerprintListModel() {
/* 43 */     return this.fingerprintList_;
/*    */   }
/*    */   
/*    */   public Integer getMaximumEnrolledFingerCount() {
/* 47 */     return this.fingerprintList_.getMaximumEnrolledCount();
/*    */   }
/*    */   
/*    */   public FingerEnum getSelectedFinger() {
/* 51 */     return this.fingerprintList_.getSelectedFinger();
/*    */   }
/*    */   
/*    */   public void setCurrentEnrolledFingerCount(Integer argValue) {
/* 55 */     this.fingerprintList_.setCurrentEnrolledCount(argValue);
/*    */   }
/*    */ 
/*    */   
/*    */   public void setFingerprintListModel(FingerprintListModel newValue) {}
/*    */ 
/*    */   
/*    */   public void setMaximumEnrolledFingerCount(Integer argValue) {
/* 63 */     this.fingerprintList_.setMaximumEnrolledCount(argValue);
/*    */   }
/*    */   
/*    */   public void setSelectedFinger(FingerEnum newValue) {
/* 67 */     this.fingerprintList_.setSelectedFinger(newValue);
/*    */   }
/*    */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-posframework.jar!\dtv\pos\framework\biometric\fingerprint\FingerprintEditModel.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */