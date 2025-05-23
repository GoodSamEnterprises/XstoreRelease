/*     */ package dtv.pos.framework.biometric.fingerprint;
/*     */ 
/*     */ import dtv.data2.access.DataFactory;
/*     */ import dtv.data2.access.IQueryKey;
/*     */ import dtv.data2.access.IQueryResultList;
/*     */ import dtv.data2.access.ObjectNotFoundException;
/*     */ import dtv.data2.access.QueryKey;
/*     */ import dtv.data2.cache.CacheManager;
/*     */ import dtv.data2.cache.ICache;
/*     */ import dtv.data2.cache.NotCachedException;
/*     */ import dtv.hardware.IHardwareMgr;
/*     */ import dtv.hardware.biometric.IDtvBiometricDevice;
/*     */ import dtv.hardware.types.HardwareFamilyType;
/*     */ import dtv.hardware.types.HardwareType;
/*     */ import dtv.pos.iframework.security.StationState;
/*     */ import dtv.xst.dao.hrs.IEmployeeFingerprint;
/*     */ import java.util.ArrayList;
/*     */ import java.util.Collection;
/*     */ import java.util.HashMap;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import javax.inject.Inject;
/*     */ import org.apache.log4j.Logger;
/*     */ 
/*     */ public class CacheLocalFingerprintTemplateData
/*     */ {
/*  27 */   private static final Logger logger_ = Logger.getLogger(CacheLocalFingerprintTemplateData.class);
/*  28 */   private static final boolean debugEnabled_ = logger_.isDebugEnabled();
/*  29 */   private static ICache cache_ = null;
/*     */   
/*     */   private static final String PREFIX = "dtv.pos.hardware.biometric.fingerprint-";
/*     */   
/*     */   private static final String CACHE_NAME = "FINGERPRINT_CACHE";
/*     */   private static final String COLLECTION_KEY = "EMPLOYEE_FINGERPRINT_COLLECTION";
/*  35 */   private static final IQueryKey<IEmployeeFingerprint> EMPLOYEE_FINGERPRINT = (IQueryKey<IEmployeeFingerprint>)new QueryKey("EMPLOYEE_FINGERPRINT", IEmployeeFingerprint.class);
/*     */ 
/*     */ 
/*     */   
/*     */   @Inject
/*     */   private StationState _stationState;
/*     */ 
/*     */   
/*     */   @Inject
/*     */   private IHardwareMgr _hardwareMgr;
/*     */ 
/*     */ 
/*     */   
/*     */   public Collection<IEmployeeFingerprint> getLocalEmployeeFingerprints() {
/*  49 */     loadLocalFingerprints();
/*  50 */     Object result = null;
/*     */     
/*     */     try {
/*  53 */       result = cache_.get("EMPLOYEE_FINGERPRINT_COLLECTION");
/*     */     }
/*  55 */     catch (NotCachedException ee) {
/*  56 */       if (debugEnabled_) {
/*  57 */         logger_.debug("No Biometric data cached");
/*     */       }
/*     */     } 
/*     */     
/*  61 */     return (Collection<IEmployeeFingerprint>)result;
/*     */   }
/*     */   
/*     */   public void init() {
/*  65 */     cache_ = CacheManager.getInstance().getCache("FINGERPRINT_CACHE");
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void loadLocalFingerprints() {
/*  72 */     getDevice().log("************** LOAD FINGERPRINT CACHE START *********************");
/*     */     try {
/*  74 */       cache_.clear();
/*  75 */       IEmployeeFingerprint[] results = null;
/*  76 */       Map<String, Object> params = new HashMap<>();
/*  77 */       params.put("argRetailLocation", Long.valueOf(this._stationState.getRetailLocationId()));
/*     */       
/*  79 */       IQueryResultList iQueryResultList = DataFactory.getObjectByQuery(EMPLOYEE_FINGERPRINT, params);
/*     */       
/*  81 */       cache_.put("EMPLOYEE_FINGERPRINT_COLLECTION", iQueryResultList);
/*  82 */       results = (IEmployeeFingerprint[])iQueryResultList.toArray((Object[])new IEmployeeFingerprint[iQueryResultList.size()]);
/*  83 */       List<IEmployeeFingerprint> employeeFingers = new ArrayList<>();
/*  84 */       if (results.length > 0) {
/*  85 */         String refEmp = results[0].getEmployeeId();
/*  86 */         for (IEmployeeFingerprint thisPrint : results) {
/*  87 */           String thisEmployee = thisPrint.getEmployeeId();
/*  88 */           if (refEmp.equals(thisEmployee)) {
/*  89 */             employeeFingers.add(thisPrint);
/*  90 */             getDevice().log("Employee = " + refEmp + " : Enrolled Finger = " + thisPrint.getSequence());
/*     */           } else {
/*     */             
/*  93 */             cache_.put("dtv.pos.hardware.biometric.fingerprint-" + refEmp, employeeFingers.toArray(new IEmployeeFingerprint[0]));
/*  94 */             employeeFingers.clear();
/*  95 */             refEmp = thisEmployee;
/*  96 */             employeeFingers.add(thisPrint);
/*  97 */             getDevice().log("Employee = " + refEmp + " : Enrolled Finger = " + thisPrint.getSequence());
/*     */           } 
/*     */         } 
/*     */         
/* 101 */         if (employeeFingers.size() != 0) {
/* 102 */           cache_.put("dtv.pos.hardware.biometric.fingerprint-" + refEmp, employeeFingers.toArray(new IEmployeeFingerprint[0]));
/*     */         }
/*     */       }
/*     */     
/* 106 */     } catch (ObjectNotFoundException ex) {
/*     */       
/* 108 */       getDevice().log("No Employee Biometric data found");
/*     */     }
/* 110 */     catch (Exception ex) {
/* 111 */       logger_.error("CAUGHT EXCEPTION", ex);
/*     */     } 
/* 113 */     getDevice().log("************** LOAD FINGERPRINT CACHE END ***********************");
/*     */   }
/*     */   
/*     */   private final IDtvBiometricDevice getDevice() {
/* 117 */     HardwareType<IDtvBiometricDevice> type = HardwareType.forUse(HardwareFamilyType.BIOMETRIC, "FINGERPRINT");
/*     */     
/* 119 */     if (type == null) {
/* 120 */       logger_.debug("null type");
/* 121 */       return null;
/*     */     } 
/*     */     
/* 124 */     IDtvBiometricDevice device = (IDtvBiometricDevice)this._hardwareMgr.getDevice(type);
/*     */     
/* 126 */     if (device == null) {
/* 127 */       logger_.warn("null device for " + type);
/*     */     }
/*     */     
/* 130 */     return device;
/*     */   }
/*     */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-posframework.jar!\dtv\pos\framework\biometric\fingerprint\CacheLocalFingerprintTemplateData.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */