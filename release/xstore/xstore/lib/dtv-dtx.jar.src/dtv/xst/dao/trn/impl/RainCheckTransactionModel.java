/*     */ package dtv.xst.dao.trn.impl;
/*     */ 
/*     */ import dtv.data2.IPersistenceDefaults;
/*     */ import dtv.data2.access.IDataAccessObject;
/*     */ import dtv.data2.access.IDataModel;
/*     */ import dtv.data2.access.impl.IDataModelImpl;
/*     */ import dtv.data2.access.impl.Relationship;
/*     */ import dtv.event.EventDescriptor;
/*     */ import dtv.event.EventManager;
/*     */ import dtv.event.IEventAware;
/*     */ import dtv.event.IEventSource;
/*     */ import dtv.xst.dao.trn.IRainCheck;
/*     */ import dtv.xst.dao.trn.IRainCheckTransaction;
/*     */ import java.io.IOException;
/*     */ import java.io.ObjectInputStream;
/*     */ import java.util.Date;
/*     */ 
/*     */ 
/*     */ public class RainCheckTransactionModel
/*     */   extends PosTransactionModel
/*     */   implements IRainCheckTransaction
/*     */ {
/*     */   private static final long serialVersionUID = 1711258762L;
/*     */   private transient boolean _alreadyInStart = false;
/*     */   private transient boolean _alreadyInCommit = false;
/*     */   private IDataModel _myExtension;
/*     */   private IRainCheck _rainCheck;
/*     */   private transient IRainCheck _rainCheckSavepoint;
/*     */   
/*     */   public void initDAO() {
/*  31 */     setDAO((IDataAccessObject)new RainCheckTransactionDAO());
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private RainCheckTransactionDAO getDAO_() {
/*  39 */     return (RainCheckTransactionDAO)this._daoImpl;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Date getCreateDate() {
/*  47 */     return getDAO_().getCreateDate();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setCreateDate(Date argCreateDate) {
/*  55 */     if (setCreateDate_noev(argCreateDate) && 
/*  56 */       this._events != null && 
/*  57 */       postEventsForChanges()) {
/*  58 */       this._events.post(IRainCheckTransaction.SET_CREATEDATE, argCreateDate);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setCreateDate_noev(Date argCreateDate) {
/*  65 */     boolean ev_postable = false;
/*     */     
/*  67 */     if ((getDAO_().getCreateDate() == null && argCreateDate != null) || (
/*  68 */       getDAO_().getCreateDate() != null && !getDAO_().getCreateDate().equals(argCreateDate))) {
/*  69 */       getDAO_().setCreateDate(argCreateDate);
/*  70 */       ev_postable = true;
/*     */     } 
/*     */     
/*  73 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getCreateUserId() {
/*  81 */     return getDAO_().getCreateUserId();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setCreateUserId(String argCreateUserId) {
/*  89 */     if (setCreateUserId_noev(argCreateUserId) && 
/*  90 */       this._events != null && 
/*  91 */       postEventsForChanges()) {
/*  92 */       this._events.post(IRainCheckTransaction.SET_CREATEUSERID, argCreateUserId);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setCreateUserId_noev(String argCreateUserId) {
/*  99 */     boolean ev_postable = false;
/*     */     
/* 101 */     if ((getDAO_().getCreateUserId() == null && argCreateUserId != null) || (
/* 102 */       getDAO_().getCreateUserId() != null && !getDAO_().getCreateUserId().equals(argCreateUserId))) {
/* 103 */       getDAO_().setCreateUserId(argCreateUserId);
/* 104 */       ev_postable = true;
/*     */     } 
/*     */     
/* 107 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Date getUpdateDate() {
/* 115 */     return getDAO_().getUpdateDate();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setUpdateDate(Date argUpdateDate) {
/* 123 */     if (setUpdateDate_noev(argUpdateDate) && 
/* 124 */       this._events != null && 
/* 125 */       postEventsForChanges()) {
/* 126 */       this._events.post(IRainCheckTransaction.SET_UPDATEDATE, argUpdateDate);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setUpdateDate_noev(Date argUpdateDate) {
/* 133 */     boolean ev_postable = false;
/*     */     
/* 135 */     if ((getDAO_().getUpdateDate() == null && argUpdateDate != null) || (
/* 136 */       getDAO_().getUpdateDate() != null && !getDAO_().getUpdateDate().equals(argUpdateDate))) {
/* 137 */       getDAO_().setUpdateDate(argUpdateDate);
/* 138 */       ev_postable = true;
/*     */     } 
/*     */     
/* 141 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getUpdateUserId() {
/* 149 */     return getDAO_().getUpdateUserId();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setUpdateUserId(String argUpdateUserId) {
/* 157 */     if (setUpdateUserId_noev(argUpdateUserId) && 
/* 158 */       this._events != null && 
/* 159 */       postEventsForChanges()) {
/* 160 */       this._events.post(IRainCheckTransaction.SET_UPDATEUSERID, argUpdateUserId);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setUpdateUserId_noev(String argUpdateUserId) {
/* 167 */     boolean ev_postable = false;
/*     */     
/* 169 */     if ((getDAO_().getUpdateUserId() == null && argUpdateUserId != null) || (
/* 170 */       getDAO_().getUpdateUserId() != null && !getDAO_().getUpdateUserId().equals(argUpdateUserId))) {
/* 171 */       getDAO_().setUpdateUserId(argUpdateUserId);
/* 172 */       ev_postable = true;
/*     */     } 
/*     */     
/* 175 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getRainCheckId() {
/* 183 */     return getDAO_().getRainCheckId();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setRainCheckId(String argRainCheckId) {
/* 191 */     if (setRainCheckId_noev(argRainCheckId) && 
/* 192 */       this._events != null && 
/* 193 */       postEventsForChanges()) {
/* 194 */       this._events.post(IRainCheckTransaction.SET_RAINCHECKID, argRainCheckId);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setRainCheckId_noev(String argRainCheckId) {
/* 201 */     boolean ev_postable = false;
/*     */     
/* 203 */     if ((getDAO_().getRainCheckId() == null && argRainCheckId != null) || (
/* 204 */       getDAO_().getRainCheckId() != null && !getDAO_().getRainCheckId().equals(argRainCheckId))) {
/* 205 */       getDAO_().setRainCheckId(argRainCheckId);
/* 206 */       ev_postable = true;
/* 207 */       if (this._rainCheck != null)
/*     */       {
/*     */         
/* 210 */         ((RainCheckModel)this._rainCheck).setRainCheckId_noev(argRainCheckId);
/*     */       }
/*     */     } 
/*     */     
/* 214 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @Relationship(name = "RainCheck")
/*     */   public IRainCheck getRainCheck() {
/* 223 */     return this._rainCheck;
/*     */   }
/*     */ 
/*     */   
/*     */   public void setRainCheck(IRainCheck argRainCheck) {
/* 228 */     if (argRainCheck == null) {
/* 229 */       if (this._rainCheck != null) {
/*     */         
/* 231 */         if (postEventsForChanges()) {
/* 232 */           this._eventManager.deregisterEventHandler((IEventAware)this._eventCascade, (IEventSource)new EventDescriptor(this._rainCheck));
/*     */         }
/* 234 */         addDeletedObject((IDataModel)this._rainCheck);
/*     */       } 
/*     */     } else {
/*     */       
/* 238 */       argRainCheck.setOrganizationId(getOrganizationId());
/* 239 */       argRainCheck.setRainCheckId(getRainCheckId());
/*     */ 
/*     */       
/* 242 */       if (postEventsForChanges()) {
/* 243 */         this._eventManager.registerEventHandler((IEventAware)this._eventCascade, (IEventSource)new EventDescriptor(argRainCheck));
/*     */       }
/*     */     } 
/*     */     
/* 247 */     this._rainCheck = argRainCheck;
/* 248 */     if (postEventsForChanges()) {
/* 249 */       this._events.post(IRainCheckTransaction.SET_RAINCHECK, argRainCheck);
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public Object getValue(String argFieldId) {
/* 255 */     if ("RainCheck".equals(argFieldId)) {
/* 256 */       return getRainCheck();
/*     */     }
/* 258 */     if ("RainCheckTransactionExtension".equals(argFieldId)) {
/* 259 */       return this._myExtension;
/*     */     }
/*     */     
/* 262 */     return super.getValue(argFieldId);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void setValue(String argFieldId, Object argValue) {
/* 268 */     if ("RainCheck".equals(argFieldId)) {
/* 269 */       setRainCheck((IRainCheck)argValue);
/*     */     }
/* 271 */     else if ("RainCheckTransactionExtension".equals(argFieldId)) {
/* 272 */       this._myExtension = (IDataModel)argValue;
/*     */     } else {
/*     */       
/* 275 */       super.setValue(argFieldId, argValue);
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public void setDependencies(IPersistenceDefaults argPD, EventManager argEM) {
/* 281 */     super.setDependencies(argPD, argEM);
/* 282 */     if (this._rainCheck != null) {
/* 283 */       ((IDataModelImpl)this._rainCheck).setDependencies(argPD, argEM);
/*     */     }
/*     */   }
/*     */   
/*     */   public IDataModel getRainCheckTransactionExt() {
/* 288 */     return this._myExtension;
/*     */   }
/*     */   
/*     */   public void setRainCheckTransactionExt(IDataModel argExt) {
/* 292 */     this._myExtension = argExt;
/*     */   }
/*     */ 
/*     */   
/*     */   public void startTransaction() {
/* 297 */     if (this._alreadyInStart) {
/*     */       return;
/*     */     }
/*     */     
/* 301 */     this._alreadyInStart = true;
/*     */ 
/*     */     
/* 304 */     super.startTransaction();
/*     */     
/* 306 */     this._rainCheckSavepoint = this._rainCheck;
/* 307 */     if (this._rainCheck != null) {
/* 308 */       this._rainCheck.startTransaction();
/*     */     }
/*     */ 
/*     */     
/* 312 */     this._alreadyInStart = false;
/*     */   }
/*     */ 
/*     */   
/*     */   public void rollbackChanges() {
/* 317 */     if (isAlreadyRolledBack()) {
/*     */       return;
/*     */     }
/* 320 */     super.rollbackChanges();
/*     */     
/* 322 */     this._rainCheck = this._rainCheckSavepoint;
/* 323 */     this._rainCheckSavepoint = null;
/* 324 */     if (this._rainCheck != null) {
/* 325 */       this._rainCheck.rollbackChanges();
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void commitTransaction() {
/* 332 */     if (this._alreadyInCommit) {
/*     */       return;
/*     */     }
/* 335 */     this._alreadyInCommit = true;
/*     */ 
/*     */     
/* 338 */     super.commitTransaction();
/*     */     
/* 340 */     this._rainCheckSavepoint = this._rainCheck;
/* 341 */     if (this._rainCheck != null) {
/* 342 */       this._rainCheck.commitTransaction();
/*     */     }
/*     */ 
/*     */     
/* 346 */     this._alreadyInCommit = false;
/*     */   }
/*     */ 
/*     */   
/*     */   private void readObject(ObjectInputStream argStream) throws IOException, ClassNotFoundException {
/* 351 */     argStream.defaultReadObject();
/*     */   }
/*     */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\trn\impl\RainCheckTransactionModel.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */