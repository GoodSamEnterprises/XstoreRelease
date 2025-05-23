/*     */ package dtv.xst.dao.hrs.impl;
/*     */ 
/*     */ import dtv.data2.access.IDataAccessObject;
/*     */ import dtv.data2.access.impl.AbstractDataModelWithPropertyImpl;
/*     */ import dtv.data2.access.impl.DaoState;
/*     */ import dtv.util.EncodingHelper;
/*     */ import dtv.xst.dao.hrs.IEmployeeFingerprint;
/*     */ import dtv.xst.dao.hrs.IEmployeeFingerprintModel;
/*     */ import dtv.xst.dao.hrs.IEmployeeFingerprintProperty;
/*     */ import java.io.IOException;
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public abstract class EmployeeFingerprintBaseModel
/*     */   extends AbstractDataModelWithPropertyImpl<IEmployeeFingerprintProperty>
/*     */   implements IEmployeeFingerprint, IEmployeeFingerprintModel
/*     */ {
/*     */   private static final long serialVersionUID = 1L;
/*     */   private transient Object biometricData_;
/*     */   
/*     */   public static Object decodeBiometricData(String argText) throws IOException {
/*  37 */     byte[] result = EncodingHelper.decodeToBytes(argText, false);
/*     */     
/*  39 */     if (result == null) {
/*  40 */       throw new IOException("unable to encode");
/*     */     }
/*     */     
/*  43 */     return result;
/*     */   }
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
/*     */   public static String encodeBiometricData(Object argValue) throws IOException {
/*  56 */     byte[] bytes = (byte[])argValue;
/*  57 */     String result = EncodingHelper.encodeBytes(bytes, false);
/*     */     
/*  59 */     if (result == null) {
/*  60 */       throw new IOException("unable to encode");
/*     */     }
/*     */     
/*  63 */     return result;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Object getBiometricData() throws ClassNotFoundException, IOException {
/*  73 */     if (this.biometricData_ == null) {
/*  74 */       this.biometricData_ = decodeBiometricData(getBiometricStorage());
/*     */     }
/*     */     
/*  77 */     return this.biometricData_;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean isDeleted() {
/*  83 */     return DaoState.isDeleted((IDataAccessObject)getDAO_());
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void markForDeletion() {
/*  89 */     getDAO_().setObjectState(DaoState.DELETED.intVal());
/*     */   }
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
/*     */   public void setBiometricData(Object newValue) throws IOException {
/* 102 */     if (this.biometricData_ != newValue) {
/* 103 */       setBiometricStorage(encodeBiometricData(newValue));
/* 104 */       this.biometricData_ = newValue;
/*     */     } 
/*     */   }
/*     */   
/*     */   private EmployeeFingerprintDAO getDAO_() {
/* 109 */     return (EmployeeFingerprintDAO)this._daoImpl;
/*     */   }
/*     */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\hrs\impl\EmployeeFingerprintBaseModel.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */