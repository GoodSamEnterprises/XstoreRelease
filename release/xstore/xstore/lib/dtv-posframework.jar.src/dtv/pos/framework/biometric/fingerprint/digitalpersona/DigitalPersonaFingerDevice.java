/*     */ package dtv.pos.framework.biometric.fingerprint.digitalpersona;
/*     */ import com.digitalpersona.onetouch.DPFPCaptureFeedback;
/*     */ import com.digitalpersona.onetouch.DPFPDataPurpose;
/*     */ import com.digitalpersona.onetouch.DPFPFeatureSet;
/*     */ import com.digitalpersona.onetouch.DPFPGlobal;
/*     */ import com.digitalpersona.onetouch.DPFPSample;
/*     */ import com.digitalpersona.onetouch.DPFPTemplate;
/*     */ import com.digitalpersona.onetouch.capture.event.DPFPDataAdapter;
/*     */ import com.digitalpersona.onetouch.capture.event.DPFPDataEvent;
/*     */ import com.digitalpersona.onetouch.capture.event.DPFPDataListener;
/*     */ import com.digitalpersona.onetouch.capture.event.DPFPErrorAdapter;
/*     */ import com.digitalpersona.onetouch.capture.event.DPFPErrorEvent;
/*     */ import com.digitalpersona.onetouch.capture.event.DPFPErrorListener;
/*     */ import com.digitalpersona.onetouch.capture.event.DPFPImageQualityAdapter;
/*     */ import com.digitalpersona.onetouch.capture.event.DPFPImageQualityEvent;
/*     */ import com.digitalpersona.onetouch.capture.event.DPFPImageQualityListener;
/*     */ import com.digitalpersona.onetouch.capture.event.DPFPReaderStatusAdapter;
/*     */ import com.digitalpersona.onetouch.capture.event.DPFPReaderStatusEvent;
/*     */ import com.digitalpersona.onetouch.capture.event.DPFPReaderStatusListener;
/*     */ import com.digitalpersona.onetouch.capture.event.DPFPSensorAdapter;
/*     */ import com.digitalpersona.onetouch.capture.event.DPFPSensorEvent;
/*     */ import com.digitalpersona.onetouch.capture.event.DPFPSensorListener;
/*     */ import com.digitalpersona.onetouch.processing.DPFPImageQualityException;
/*     */ import com.digitalpersona.onetouch.processing.DPFPTemplateStatus;
/*     */ import com.digitalpersona.onetouch.readers.DPFPReaderDescription;
/*     */ import com.digitalpersona.onetouch.verification.DPFPVerificationResult;
/*     */ import dtv.hardware.HardwareStartupMessages;
/*     */ import dtv.hardware.biometric.BioEventState;
/*     */ import dtv.hardware.biometric.IDtvBiometricDevice;
/*     */ import dtv.hardware.types.HardwareType;
/*     */ import dtv.xst.dao.hrs.IEmployeeFingerprint;
/*     */ import java.awt.Image;
/*     */ import java.awt.event.ActionEvent;
/*     */ import java.awt.event.ActionListener;
/*     */ import java.util.List;
/*     */ import java.util.concurrent.LinkedBlockingQueue;
/*     */ import javax.swing.BorderFactory;
/*     */ import javax.swing.JButton;
/*     */ import javax.swing.JPanel;
/*     */ import javax.swing.JScrollPane;
/*     */ import javax.swing.JTextArea;
/*     */ import org.apache.log4j.Logger;
/*     */ 
/*     */ public class DigitalPersonaFingerDevice extends DefaultBiometricDevice implements Runnable {
/*  45 */   private static final Logger logger = Logger.getLogger(DigitalPersonaFingerDevice.class); private static final String DEVICE_NAME = "digitalPersona - U.are.U 4500 Fingerprint Reader";
/*  46 */   private static final boolean debugEnabled_ = logger.isDebugEnabled();
/*     */   
/*     */   private static final int TS_IDLE = 0;
/*     */   
/*     */   private static final int TS_ENROLL = 1;
/*     */   private static final int TS_IDENTIFY = 2;
/*     */   private static int threadIndex;
/*  53 */   private final FingerprintStatusWindow statusWindow = new FingerprintStatusWindow();
/*  54 */   private final LinkedBlockingQueue<DPFPSample> samples = new LinkedBlockingQueue<>();
/*  55 */   private final DPFPSample emptySample = DPFPGlobal.getSampleFactory().createSample();
/*  56 */   private final DPFPReadersCollection readers_ = DPFPGlobal.getReadersFactory().getReaders();
/*  57 */   private final DPFPCapture capture_ = DPFPGlobal.getCaptureFactory().createCapture(getActiveReader(), DPFPCapturePriority.CAPTURE_PRIORITY_NORMAL);
/*     */   
/*  59 */   private final DPFPEnrollment enroller_ = DPFPGlobal.getEnrollmentFactory().createEnrollment();
/*     */   
/*  61 */   private final DPFPFeatureExtraction featureExtractor_ = DPFPGlobal.getFeatureExtractionFactory().createFeatureExtraction();
/*     */   
/*  63 */   private final DPFPVerification verifier_ = DPFPGlobal.getVerificationFactory().createVerification(214748);
/*     */   
/*  65 */   private DPFPDataAdapter dataListener_ = null;
/*  66 */   private DPFPErrorAdapter errorListener_ = null;
/*  67 */   private DPFPImageQualityAdapter imageQualityListener_ = null;
/*  68 */   private DPFPReaderStatusAdapter readerStatusListener_ = null;
/*  69 */   private DPFPSensorAdapter sensorListener_ = null;
/*     */   private DpPopulation pop;
/*     */   private IEmployeeFingerprint[] employees;
/*     */   private Thread thread;
/*  73 */   private int threadState = -1;
/*     */ 
/*     */   
/*     */   private boolean abortOperation = false;
/*     */   
/*     */   private boolean fatalErrorOccurred = false;
/*     */   
/*     */   private boolean initialized = false;
/*     */ 
/*     */   
/*     */   public DigitalPersonaFingerDevice(HardwareType<?> argHardwareType) {
/*  84 */     super(argHardwareType, "digitalPersona - U.are.U 4500 Fingerprint Reader");
/*  85 */     addListeners();
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void abortEnroll() {
/*  91 */     if (this.threadState != 1) {
/*     */       return;
/*     */     }
/*  94 */     log("entering abortEnroll");
/*  95 */     this.enroller_.clear();
/*  96 */     this.abortOperation = true;
/*  97 */     log("abortEnroll - setting abortOperation to TRUE");
/*  98 */     this.samples.offer(this.emptySample);
/*     */     
/* 100 */     log("exiting abortEnroll");
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void abortIdentify() {
/* 106 */     if (this.threadState != 2) {
/*     */       return;
/*     */     }
/* 109 */     log("entering abortIdentify");
/* 110 */     this.abortOperation = true;
/* 111 */     log("abortIdentify - setting abortOperation to TRUE");
/* 112 */     this.samples.offer(this.emptySample);
/*     */     
/* 114 */     log("exiting abortIdentify");
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean isInEnrollmentMode() {
/* 120 */     if (this.threadState == 1) {
/* 121 */       return true;
/*     */     }
/* 123 */     return false;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean isPresent() {
/* 129 */     return this.initialized;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void log(String argMessage) {
/* 135 */     log(argMessage, null);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void run() {
/*     */     try {
/* 142 */       while (this.thread != null && !this.fatalErrorOccurred) {
/*     */         
/* 144 */         if (this.threadState == 0) {
/* 145 */           synchronized (this) {
/*     */             
/* 147 */             notifyAll();
/*     */             
/*     */             try {
/* 150 */               log("waiting");
/* 151 */               wait();
/* 152 */               log("on the go " + this.threadState);
/*     */             }
/* 154 */             catch (InterruptedException ex) {
/* 155 */               logger.info("INTERRUPTED");
/*     */             } 
/*     */           } 
/*     */         }
/*     */         
/* 160 */         switch (this.threadState) {
/*     */           case 1:
/* 162 */             log("run-ENROLL case");
/* 163 */             handleInEnrollment();
/*     */             break;
/*     */           
/*     */           case 2:
/* 167 */             log("run-IDENTIFY case");
/* 168 */             handleInVerify();
/*     */             break;
/*     */         } 
/* 171 */         synchronized (this) {
/* 172 */           this.threadState = 0;
/* 173 */           this.abortOperation = false;
/* 174 */           log("synchronized run - Setting abortOperation to FALSE");
/* 175 */           this.samples.clear();
/* 176 */           log("synchronized run - Setting ThreadState = IDLE");
/* 177 */           notifyAll();
/*     */         }
/*     */       
/*     */       } 
/* 181 */     } catch (Throwable t) {
/* 182 */       fatalErrorOccurred(t);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void shutdown() {
/* 189 */     stop();
/* 190 */     this.initialized = false;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void startEnroll() {
/* 196 */     log("entering startEnroll");
/* 197 */     synchronized (this) {
/* 198 */       this.threadState = 1;
/* 199 */       log("startEnroll - Setting ThreadState = ENROLL");
/* 200 */       notifyAll();
/*     */     } 
/* 202 */     log("exiting startEnroll");
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void startIdentify(IEmployeeFingerprint[] argTemplates) {
/* 208 */     log("entering startIdentify");
/* 209 */     List<DPFPTemplate> templateList = new ArrayList<>();
/* 210 */     for (IEmployeeFingerprint argTemplate : argTemplates) {
/*     */       
/*     */       try {
/* 213 */         DPFPTemplate template = DPFPGlobal.getTemplateFactory().createTemplate((byte[])argTemplate.getBiometricData());
/* 214 */         templateList.add(template);
/*     */       }
/* 216 */       catch (Exception ex) {
/* 217 */         logger.error("CAUGHT EXCEPTION", ex);
/*     */       } 
/*     */     } 
/* 220 */     DPFPTemplate[] templates = templateList.<DPFPTemplate>toArray(new DPFPTemplate[templateList.size()]);
/*     */     
/* 222 */     synchronized (this) {
/* 223 */       this.threadState = 2;
/* 224 */       log("startIdentify - Setting ThreadState = IDENTIFY");
/* 225 */       this.pop = new DpPopulation();
/* 226 */       this.pop.setTemplates(templates);
/*     */       
/* 228 */       this.employees = argTemplates;
/*     */       
/* 230 */       notifyAll();
/*     */     } 
/* 232 */     log("exiting startIdentify");
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean startup(HardwareStartupMessages argMessages) {
/* 238 */     boolean success = super.startup(argMessages);
/* 239 */     if (success) {
/* 240 */       start();
/*     */       
/* 242 */       if (this.readers_.isEmpty()) {
/* 243 */         fatalErrorOccurred(new Throwable("DEVICE NOT CONNECTED"));
/*     */       } else {
/*     */         
/* 246 */         this.initialized = true;
/*     */       } 
/*     */     } 
/* 249 */     return success;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected void abortAny() {
/* 256 */     if (this.thread == null || this.threadState == 0) {
/* 257 */       log("abortAny - thread is null or IDLE");
/*     */       return;
/*     */     } 
/* 260 */     log("entering abortAny");
/* 261 */     synchronized (this) {
/* 262 */       this.threadState = 0;
/* 263 */       log("abortAny - Setting ThreadState = IDLE");
/* 264 */       notifyAll();
/*     */     } 
/* 266 */     log("exiting abortAny");
/*     */   }
/*     */   
/*     */   protected void log(String argMessage, Throwable argThrowable) {
/* 270 */     if (debugEnabled_) {
/* 271 */       if (argThrowable == null) {
/* 272 */         logger.debug(argMessage);
/*     */       } else {
/*     */         
/* 275 */         logger.debug(argMessage, argThrowable);
/*     */       } 
/*     */     }
/*     */     
/* 279 */     this.statusWindow.logToStatusWindow(argMessage);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private void addDataListener() {
/* 288 */     if (this.dataListener_ == null) {
/* 289 */       this.dataListener_ = new DPFPDataAdapter()
/*     */         {
/*     */           public void dataAcquired(DPFPDataEvent e) {
/* 292 */             if (e != null && e.getSample() != null) {
/* 293 */               DigitalPersonaFingerDevice.this.samples.offer(e.getSample());
/* 294 */               DigitalPersonaFingerDevice.this.log("Biometric Sample Captured");
/*     */             } else {
/*     */               
/* 297 */               DigitalPersonaFingerDevice.this.log("No biometric sample available during getFingerprint");
/*     */             } 
/*     */           }
/*     */         };
/*     */     }
/* 302 */     this.capture_.addDataListener((DPFPDataListener)this.dataListener_);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private void addErrorListener() {
/* 309 */     if (this.errorListener_ == null) {
/* 310 */       this.errorListener_ = new DPFPErrorAdapter()
/*     */         {
/*     */           public void errorOccured(DPFPErrorEvent e) {
/* 313 */             DigitalPersonaFingerDevice.logger.warn("Error Occurred: " + e.getError().getErrorCode() + " - " + e.getError().getErrorText());
/*     */           }
/*     */ 
/*     */           
/*     */           public void exceptionCaught(DPFPErrorEvent e) {
/* 318 */             DigitalPersonaFingerDevice.logger.error("Exception Caught: ", e.getError().getException());
/*     */           }
/*     */         };
/*     */     }
/* 322 */     this.capture_.addErrorListener((DPFPErrorListener)this.errorListener_);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private void addImageQualityListener() {
/* 329 */     if (this.imageQualityListener_ == null) {
/* 330 */       this.imageQualityListener_ = new DPFPImageQualityAdapter()
/*     */         {
/*     */           public void onImageQuality(DPFPImageQualityEvent e) {
/* 333 */             if (!e.getFeedback().equals(DPFPCaptureFeedback.CAPTURE_FEEDBACK_GOOD)) {
/* 334 */               DigitalPersonaFingerDevice.this.log("Bad Biometric Image captured during getFingerprint");
/*     */               return;
/*     */             } 
/* 337 */             DigitalPersonaFingerDevice.this.log("Good Biometric Image captured during getFingerprint");
/*     */           }
/*     */         };
/*     */     }
/* 341 */     this.capture_.addImageQualityListener((DPFPImageQualityListener)this.imageQualityListener_);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private void addListeners() {
/* 349 */     log("Start adding event Listeners");
/* 350 */     log("** Data Event Listener **");
/* 351 */     addDataListener();
/* 352 */     log("** Image Quality Listener **");
/* 353 */     addImageQualityListener();
/* 354 */     log("** Sensor Listener **");
/* 355 */     addSensorListener();
/* 356 */     log("** Reader Status Listener **");
/* 357 */     addReaderStatusListener();
/* 358 */     log("** Error Listener **");
/* 359 */     addErrorListener();
/* 360 */     log("Done adding event Listeners");
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private void addReaderStatusListener() {
/* 367 */     if (this.readerStatusListener_ == null) {
/* 368 */       this.readerStatusListener_ = new DPFPReaderStatusAdapter()
/*     */         {
/*     */           public void readerConnected(DPFPReaderStatusEvent e) {
/* 371 */             DigitalPersonaFingerDevice.this.log("Device is Connected: " + e.getReaderStatus());
/*     */           }
/*     */ 
/*     */           
/*     */           public void readerDisconnected(DPFPReaderStatusEvent e) {
/* 376 */             DigitalPersonaFingerDevice.this.fatalErrorOccurred(new Throwable("DEVICE NOT CONNECTED:" + e.getReaderStatus()));
/*     */           }
/*     */         };
/*     */     }
/* 380 */     this.capture_.addReaderStatusListener((DPFPReaderStatusListener)this.readerStatusListener_);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private void addSensorListener() {
/* 387 */     if (this.sensorListener_ == null) {
/* 388 */       this.sensorListener_ = new DPFPSensorAdapter()
/*     */         {
/*     */           public void fingerGone(DPFPSensorEvent e) {
/* 391 */             DigitalPersonaFingerDevice.this.log("Finger was removed from device: Sensor Status=" + e.getSensorStatus());
/*     */           }
/*     */ 
/*     */           
/*     */           public void fingerTouched(DPFPSensorEvent e) {
/* 396 */             DigitalPersonaFingerDevice.this.log("Finger has touched the device: Sensor Status=" + e.getSensorStatus());
/* 397 */             DigitalPersonaFingerDevice.this.startInProgressEvent();
/*     */           }
/*     */ 
/*     */           
/*     */           public void imageAcquired(DPFPSensorEvent e) {
/* 402 */             DigitalPersonaFingerDevice.this.log("Image has been Acquired: Sensor Status=" + e.getSensorStatus());
/*     */           }
/*     */         };
/*     */     }
/* 406 */     this.capture_.addSensorListener((DPFPSensorListener)this.sensorListener_);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private void clearListeners() {
/* 413 */     log("Start clearing event Listeners");
/* 414 */     log("** Data Event Listener **");
/* 415 */     this.dataListener_ = null;
/* 416 */     log("** Error Event Listener **");
/* 417 */     this.errorListener_ = null;
/* 418 */     log("** Image Quality Event Listener **");
/* 419 */     this.imageQualityListener_ = null;
/* 420 */     log("** Reader Status Event Listener **");
/* 421 */     this.readerStatusListener_ = null;
/* 422 */     log("** Sensor Event Listener **");
/* 423 */     this.sensorListener_ = null;
/* 424 */     log("Done clearing event Listeners");
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private void fatalErrorOccurred(Throwable t) {
/* 432 */     logger.error("FATAL ERROR -- DISABLING DEVICE", t);
/* 433 */     this.initialized = false;
/* 434 */     this.fatalErrorOccurred = true;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private String getActiveReader() {
/* 443 */     String activeReader = null;
/* 444 */     log("************ Active Biometric Readers START *******************");
/* 445 */     for (DPFPReaderDescription reader : this.readers_) {
/* 446 */       activeReader = reader.getSerialNumber();
/* 447 */       log("Device: " + reader.getProductName() + " : " + activeReader);
/*     */     } 
/* 449 */     log("************ Active Biometric Readers END *******************");
/* 450 */     return activeReader;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private DPFPSample getFingerprint() throws InterruptedException {
/* 461 */     this.samples.clear();
/*     */     
/*     */     try {
/* 464 */       log("Start Capturing Fingerprint");
/* 465 */       if (this.capture_.isStarted()) {
/* 466 */         log("Capturing state already set, ignoring startCapture");
/*     */       } else {
/*     */         
/* 469 */         this.capture_.startCapture();
/*     */       } 
/* 471 */       return this.samples.take();
/*     */     }
/* 473 */     catch (RuntimeException e) {
/* 474 */       throw e;
/*     */     }
/* 476 */     catch (InterruptedException e1) {
/* 477 */       throw e1;
/*     */     } finally {
/*     */       
/* 480 */       stopCapture();
/* 481 */       log("Stop Capturing Fingerprint");
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private void handleInEnrollment() {
/* 489 */     log("In Handle Enrollment");
/*     */     try {
/* 491 */       while (this.enroller_.getFeaturesNeeded() > 0) {
/* 492 */         DPFPSample sample = getFingerprint();
/* 493 */         if (this.abortOperation) {
/*     */           
/* 495 */           log("abortOperation is TRUE in handleInEnrollment");
/*     */           break;
/*     */         } 
/* 498 */         if (sample == null) {
/* 499 */           log("no biomretric sample captured in enrollment");
/*     */           continue;
/*     */         } 
/* 502 */         Image image = DPFPGlobal.getSampleConversionFactory().createImage(sample);
/* 503 */         DpBiometricEvent dpBiometricEvent = new DpBiometricEvent(image, (IDtvBiometricDevice)this, BioEventState.IMAGE_CAPTURED, null, null);
/* 504 */         fireEvent(dpBiometricEvent);
/* 505 */         DPFPFeatureSet featureSet = null;
/*     */         try {
/* 507 */           featureSet = this.featureExtractor_.createFeatureSet(sample, DPFPDataPurpose.DATA_PURPOSE_ENROLLMENT);
/*     */         }
/* 509 */         catch (DPFPImageQualityException e) {
/* 510 */           log("Biometric Image Quality Exception caught during Enrollment1");
/*     */           
/*     */           continue;
/* 513 */         } catch (Exception e2) {
/* 514 */           logger.error("uncaught exception", e2);
/*     */         } 
/* 516 */         this.enroller_.addFeatures(featureSet);
/*     */       }
/*     */     
/* 519 */     } catch (DPFPImageQualityException e) {
/* 520 */       log("Biometric Image Quality Exception caught during Enrollment2");
/*     */     }
/* 522 */     catch (InterruptedException e) {
/* 523 */       throw new RuntimeException(e);
/*     */     }
/* 525 */     catch (Exception e2) {
/* 526 */       logger.error("uncaught exception", e2);
/*     */     } 
/* 528 */     DPFPTemplate template = this.enroller_.getTemplate();
/* 529 */     DpBiometricEvent event = null;
/* 530 */     log("Enrollment Template Status = " + this.enroller_.getTemplateStatus().name());
/* 531 */     if (this.enroller_.getTemplateStatus() == DPFPTemplateStatus.TEMPLATE_STATUS_READY) {
/* 532 */       event = new DpBiometricEvent(null, (IDtvBiometricDevice)this, BioEventState.ENROLLMENT_SUCCESS, null, template.serialize());
/*     */     } else {
/* 534 */       if (this.enroller_.getTemplateStatus() == DPFPTemplateStatus.TEMPLATE_STATUS_UNKNOWN) {
/* 535 */         this.enroller_.clear();
/*     */         
/*     */         return;
/*     */       } 
/* 539 */       event = new DpBiometricEvent(null, (IDtvBiometricDevice)this, BioEventState.ENROLLMENT_FAILED, null, null);
/*     */     } 
/* 541 */     fireEvent(event);
/* 542 */     this.enroller_.clear();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private void handleInVerify() {
/* 549 */     log("In Handle Verification");
/* 550 */     DPFPSample sample = null;
/*     */     try {
/* 552 */       sample = getFingerprint();
/*     */     }
/* 554 */     catch (Exception e) {
/* 555 */       log("Biometric Exception caught during Verify", e);
/*     */     } 
/* 557 */     if (this.abortOperation) {
/*     */       
/* 559 */       log("abortOperation is TRUE during handleInVerify");
/*     */       return;
/*     */     } 
/* 562 */     if (sample == null) {
/* 563 */       log("no Biometric sample captured during Verify");
/*     */       return;
/*     */     } 
/* 566 */     DPFPFeatureSet featureSet = null;
/*     */     try {
/* 568 */       featureSet = this.featureExtractor_.createFeatureSet(sample, DPFPDataPurpose.DATA_PURPOSE_VERIFICATION);
/*     */     }
/* 570 */     catch (DPFPImageQualityException e) {
/* 571 */       log("Biometric Image Quality Exception caught during Verify");
/*     */     }
/* 573 */     catch (Exception e2) {
/* 574 */       logger.error("uncaught exception", e2);
/*     */     } 
/* 576 */     this.verifier_.setFARRequested(214748);
/* 577 */     BioEventState es = BioEventState.IDENTIFY_FAILED;
/* 578 */     IEmployeeFingerprint employeeFingerprint = null;
/* 579 */     DPFPTemplate template = null;
/* 580 */     for (int i = 0; i < (this.pop.getTemplates()).length; i++) {
/* 581 */       template = this.pop.getTemplates()[i];
/* 582 */       log("Trying to match against Employee: " + this.employees[i].getEmployeeId() + " | Enrolled Finger: " + this.employees[i]
/* 583 */           .getSequence());
/* 584 */       DPFPVerificationResult result = this.verifier_.verify(featureSet, template);
/* 585 */       if (result.isVerified()) {
/* 586 */         log("Found a biometric match for Employee: " + this.employees[i].getEmployeeId() + " | Enrolled Finger: " + this.employees[i]
/* 587 */             .getSequence());
/* 588 */         es = BioEventState.IDENTIFY_SUCCESS;
/* 589 */         employeeFingerprint = this.employees[i];
/*     */         break;
/*     */       } 
/* 592 */       log("No biometric match for Employee: " + this.employees[i].getEmployeeId() + " | Enrolled Finger: " + this.employees[i]
/* 593 */           .getSequence());
/*     */     } 
/*     */     
/* 596 */     if (es.equals(BioEventState.IDENTIFY_FAILED)) {
/* 597 */       log("No biometric match found in fingerprint cache");
/*     */     }
/*     */ 
/*     */     
/* 601 */     DpBiometricEvent event = new DpBiometricEvent(null, (IDtvBiometricDevice)this, es, employeeFingerprint, (template != null) ? template.serialize() : null);
/* 602 */     fireEvent(event);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private void removeListeners() {
/* 609 */     log("Start removing event Listeners");
/* 610 */     log("** Data Event Listener **");
/* 611 */     this.capture_.removeDataListener((DPFPDataListener)this.dataListener_);
/* 612 */     log("** Error Event Listener **");
/* 613 */     this.capture_.removeErrorListener((DPFPErrorListener)this.errorListener_);
/* 614 */     log("** Image Quality Event Listener **");
/* 615 */     this.capture_.removeImageQualityListener((DPFPImageQualityListener)this.imageQualityListener_);
/* 616 */     log("** Reader Status Event Listener **");
/* 617 */     this.capture_.removeReaderStatusListener((DPFPReaderStatusListener)this.readerStatusListener_);
/* 618 */     log("** Sensor Event Listener **");
/* 619 */     this.capture_.removeSensorListener((DPFPSensorListener)this.sensorListener_);
/* 620 */     log("Done removing event Listeners");
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private void start() {
/* 627 */     if (this.thread == null) {
/* 628 */       this.threadState = -1;
/* 629 */       this.thread = new Thread(this, "DigitalPersonaFingerDeviceThread-" + ++threadIndex);
/* 630 */       this.thread.start();
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private void startInProgressEvent() {
/* 638 */     if (this.threadState == 1) {
/* 639 */       DpBiometricEvent event = new DpBiometricEvent(null, (IDtvBiometricDevice)this, BioEventState.IN_PROGRESS, null, null);
/* 640 */       fireEvent(event);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private void stop() {
/* 648 */     removeListeners();
/* 649 */     clearListeners();
/* 650 */     abortAny();
/* 651 */     if (this.thread != null) {
/* 652 */       this.thread = null;
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private void stopCapture() {
/* 660 */     this.capture_.stopCapture();
/*     */   }
/*     */   
/*     */   private class FingerprintStatusWindow
/*     */     extends JFrame
/*     */   {
/*     */     private static final long serialVersionUID = -1103117719473403077L;
/* 667 */     private final JTextArea log = new JTextArea();
/* 668 */     private final JScrollPane logPane = new JScrollPane(this.log);
/* 669 */     private final JButton clearButton = new JButton("Clear");
/*     */     
/* 671 */     private final boolean windowEnabled_ = Boolean.getBoolean("dtv.hardware.biometric.StatusWindow.enable");
/*     */     
/*     */     public FingerprintStatusWindow() {
/* 674 */       setState(0);
/* 675 */       setTitle("Fingerprint Status Window");
/* 676 */       setResizable(false);
/*     */       
/* 678 */       this.log.setColumns(40);
/* 679 */       this.log.setEditable(false);
/* 680 */       this.log.setFont(UIManager.getFont("Panel.font"));
/*     */       
/* 682 */       this.logPane.setBorder(BorderFactory.createCompoundBorder(
/* 683 */             BorderFactory.createTitledBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0)), 
/* 684 */             BorderFactory.createLoweredBevelBorder()));
/*     */       
/* 686 */       this.clearButton.addActionListener(new ActionListener()
/*     */           {
/*     */             public void actionPerformed(ActionEvent e) {
/* 689 */               DigitalPersonaFingerDevice.FingerprintStatusWindow.this.onClear();
/*     */             }
/*     */           });
/*     */       
/* 693 */       JPanel center = new JPanel();
/* 694 */       center.setLayout(new GridLayout(1, 1, 0, 5));
/* 695 */       center.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
/* 696 */       center.add(this.logPane);
/*     */       
/* 698 */       JPanel bottom = new JPanel(new FlowLayout(4));
/* 699 */       this.clearButton.setAlignmentX(0.5F);
/* 700 */       bottom.add(this.clearButton);
/*     */       
/* 702 */       setLayout(new BorderLayout());
/* 703 */       add(this.logPane, "Center");
/* 704 */       add(this.clearButton, "Last");
/* 705 */       pack();
/* 706 */       setSize(600, 600);
/* 707 */       setLocationRelativeTo((Component)null);
/* 708 */       if (this.windowEnabled_) {
/* 709 */         setVisible(true);
/*     */       }
/*     */     }
/*     */     
/*     */     public void logToStatusWindow(String argMessage) {
/* 714 */       this.log.append(argMessage + "\n");
/* 715 */       this.log.setCaretPosition(this.log.getText().length());
/*     */     }
/*     */     
/*     */     private void onClear() {
/* 719 */       this.log.setText("");
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-posframework.jar!\dtv\pos\framework\biometric\fingerprint\digitalpersona\DigitalPersonaFingerDevice.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */