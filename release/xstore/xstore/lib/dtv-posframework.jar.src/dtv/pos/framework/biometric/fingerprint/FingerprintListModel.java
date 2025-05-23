/*     */ package dtv.pos.framework.biometric.fingerprint;
/*     */ 
/*     */ import dtv.hardware.IHardwareConfig;
/*     */ import dtv.hardware.config.HardwareConfigMgr;
/*     */ import dtv.hardware.types.HardwareFamilyType;
/*     */ import dtv.hardware.types.HardwareType;
/*     */ import dtv.pos.framework.ui.model.DefaultListInputModel;
/*     */ import dtv.pos.iframework.hardware.IHardwareType;
/*     */ import dtv.xst.dao.hrs.IEmployeeFingerprint;
/*     */ import java.util.List;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class FingerprintListModel
/*     */   extends DefaultListInputModel
/*     */ {
/*  28 */   private static final FingerEnum[] enrollmentOrderPreference = new FingerEnum[] { FingerEnum.RIGHT_INDEX_FINGER, FingerEnum.LEFT_INDEX_FINGER, FingerEnum.RIGHT_MIDDLE_FINGER, FingerEnum.LEFT_MIDDLE_FINGER, FingerEnum.RIGHT_RING_FINGER, FingerEnum.LEFT_RING_FINGER, FingerEnum.RIGHT_LITTLE_FINGER, FingerEnum.LEFT_LITTLE_FINGER, FingerEnum.RIGHT_THUMB, FingerEnum.LEFT_THUMB };
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*  33 */   private static final IHardwareConfig HM = HardwareConfigMgr.getInstance();
/*     */   
/*     */   private List<IEmployeeFingerprint> fingerprints_;
/*  36 */   private Integer maximumEnrolledCount = loadMaximumEnrolledCount();
/*  37 */   private Integer currentEnrolledCount = Integer.valueOf(0);
/*     */   
/*     */   private final boolean[] enrolled;
/*  40 */   private final String use_ = "FINGERPRINT";
/*  41 */   private final String maxCount_ = "MaximumEnrolledFingerCount";
/*     */ 
/*     */   
/*     */   public FingerprintListModel(IEmployeeFingerprint[] argFingers) {
/*  45 */     this.enrolled = new boolean[10];
/*  46 */     for (IEmployeeFingerprint argFinger : argFingers) {
/*  47 */       if (!argFinger.isDeleted()) {
/*  48 */         int seq = argFinger.getSequence();
/*  49 */         if (seq > -1 && seq < 10) {
/*  50 */           Integer integer1 = this.currentEnrolledCount, integer2 = this.currentEnrolledCount = Integer.valueOf(this.currentEnrolledCount.intValue() + 1);
/*  51 */           this.enrolled[seq] = true;
/*     */         } 
/*     */       } 
/*     */     } 
/*  55 */     FingerEnum currentSelection = null;
/*     */     
/*  57 */     for (int i = 0; i < enrollmentOrderPreference.length; i++) {
/*  58 */       if (!isEnrolled(enrollmentOrderPreference[i].getSortOrder())) {
/*  59 */         currentSelection = enrollmentOrderPreference[i];
/*     */         
/*     */         break;
/*     */       } 
/*     */     } 
/*  64 */     if (currentSelection == null) {
/*  65 */       currentSelection = enrollmentOrderPreference[0];
/*     */     }
/*  67 */     getSelectionModel().setSelectionMode(0);
/*  68 */     getModel().setElements((Object[])FingerEnum.getInstances());
/*  69 */     setSelectedFinger(currentSelection);
/*     */   }
/*     */   
/*     */   public Integer getCurrentEnrolledCount() {
/*  73 */     return this.currentEnrolledCount;
/*     */   }
/*     */   
/*     */   public List<IEmployeeFingerprint> getFingerprints() {
/*  77 */     return this.fingerprints_;
/*     */   }
/*     */   
/*     */   public Integer getMaximumEnrolledCount() {
/*  81 */     return this.maximumEnrolledCount;
/*     */   }
/*     */   
/*     */   public FingerEnum getSelectedFinger() {
/*  85 */     return getSelectedElements().get(0);
/*     */   }
/*     */   
/*     */   public boolean isEnrolled(int argIndex) {
/*  89 */     return this.enrolled[argIndex];
/*     */   }
/*     */   
/*     */   public void setCurrentEnrolledCount(Integer argCurrentEnrolledCount) {
/*  93 */     this.currentEnrolledCount = argCurrentEnrolledCount;
/*     */   }
/*     */   
/*     */   public void setFingerprints(List<IEmployeeFingerprint> fingerprints) {
/*  97 */     this.fingerprints_ = fingerprints;
/*     */   }
/*     */   
/*     */   public void setMaximumEnrolledCount(Integer argMaximumEnrolledCount) {
/* 101 */     this.maximumEnrolledCount = argMaximumEnrolledCount;
/*     */   }
/*     */   
/*     */   public void setSelectedFinger(FingerEnum newValue) {
/* 105 */     setSelection(newValue);
/*     */   }
/*     */   
/*     */   private Integer loadMaximumEnrolledCount() {
/* 109 */     HardwareType hardwareType = HardwareType.forUse(HardwareFamilyType.BIOMETRIC, "FINGERPRINT");
/* 110 */     if (HM.getHardwareRoot().getDeviceConfig((IHardwareType)hardwareType) != null) {
/* 111 */       return (Integer)HM.getHardwareRoot().getDeviceConfig((IHardwareType)hardwareType).get("MaximumEnrolledFingerCount", Integer.valueOf(4));
/*     */     }
/*     */     
/* 114 */     return Integer.valueOf(4);
/*     */   }
/*     */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-posframework.jar!\dtv\pos\framework\biometric\fingerprint\FingerprintListModel.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */