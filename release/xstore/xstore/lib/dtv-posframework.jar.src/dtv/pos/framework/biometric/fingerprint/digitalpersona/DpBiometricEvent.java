/*    */ package dtv.pos.framework.biometric.fingerprint.digitalpersona;
/*    */ 
/*    */ import dtv.hardware.biometric.BioEventState;
/*    */ import dtv.hardware.biometric.IDtvBiometricDevice;
/*    */ import dtv.hardware.biometric.IDtvBiometricEvent;
/*    */ import dtv.hardware.types.DtvHardwareEventType;
/*    */ import dtv.pos.framework.event.XstEvent;
/*    */ import dtv.pos.iframework.event.IXstEventType;
/*    */ import dtv.xst.dao.hrs.IEmployeeFingerprint;
/*    */ import java.awt.Image;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class DpBiometricEvent
/*    */   extends XstEvent
/*    */   implements IDtvBiometricEvent
/*    */ {
/*    */   private final Image image_;
/*    */   private final IDtvBiometricDevice source_;
/*    */   private final BioEventState state_;
/*    */   private final IEmployeeFingerprint employeeFingerprint_;
/*    */   private final byte[] template_;
/* 27 */   private String toString_ = null;
/*    */ 
/*    */ 
/*    */   
/*    */   public DpBiometricEvent(Image argImage, IDtvBiometricDevice argSource, BioEventState argState, IEmployeeFingerprint argEmployeeFingerprint, byte[] argTemplate) {
/* 32 */     super((IXstEventType)DtvHardwareEventType.BIO_EVENT);
/* 33 */     this.image_ = argImage;
/* 34 */     this.source_ = argSource;
/* 35 */     this.state_ = argState;
/* 36 */     this.employeeFingerprint_ = argEmployeeFingerprint;
/* 37 */     this.template_ = argTemplate;
/*    */   }
/*    */ 
/*    */   
/*    */   public Object getBioData() {
/* 42 */     return this.template_;
/*    */   }
/*    */ 
/*    */   
/*    */   public Image getImage() {
/* 47 */     return this.image_;
/*    */   }
/*    */ 
/*    */   
/*    */   public IEmployeeFingerprint getMatchedEmployeeFingerprint() {
/* 52 */     return this.employeeFingerprint_;
/*    */   }
/*    */ 
/*    */   
/*    */   public Object getSource() {
/* 57 */     return this.source_;
/*    */   }
/*    */ 
/*    */   
/*    */   public BioEventState getState() {
/* 62 */     return this.state_;
/*    */   }
/*    */ 
/*    */   
/*    */   public String toString() {
/* 67 */     if (this.toString_ == null) {
/* 68 */       StringBuffer sb = new StringBuffer(256);
/* 69 */       sb.append(getClass().getName());
/* 70 */       sb.append("[state=").append(this.state_);
/* 71 */       sb.append(",image=").append((this.image_ == null) ? "no" : "yes");
/* 72 */       sb.append(",match=").append((this.employeeFingerprint_ == null) ? "no" : "yes");
/* 73 */       sb.append(",template=").append((this.template_ == null) ? "no" : "yes");
/* 74 */       sb.append("]");
/* 75 */       this.toString_ = sb.toString();
/*    */     } 
/* 77 */     return this.toString_;
/*    */   }
/*    */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-posframework.jar!\dtv\pos\framework\biometric\fingerprint\digitalpersona\DpBiometricEvent.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */