/*     */ package dtv.xst.dao.tsn.impl;
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
/*     */ import dtv.xst.dao.trn.impl.PosTransactionModel;
/*     */ import dtv.xst.dao.tsn.ISession;
/*     */ import dtv.xst.dao.tsn.ISessionControlTransaction;
/*     */ import dtv.xst.dao.tsn.ISessionWorkstation;
/*     */ import java.io.IOException;
/*     */ import java.io.ObjectInputStream;
/*     */ import java.util.Date;
/*     */ 
/*     */ public class SessionControlTransactionModel
/*     */   extends PosTransactionModel implements ISessionControlTransaction {
/*     */   private static final long serialVersionUID = 893283927L;
/*     */   private transient boolean _alreadyInStart = false;
/*     */   private transient boolean _alreadyInCommit = false;
/*     */   private IDataModel _myExtension;
/*     */   private ISession _session;
/*     */   private transient ISession _sessionSavepoint;
/*     */   private ISessionWorkstation _sessionWorkstation;
/*     */   private transient ISessionWorkstation _sessionWorkstationSavepoint;
/*     */   
/*     */   public void initDAO() {
/*  32 */     setDAO((IDataAccessObject)new SessionControlTransactionDAO());
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private SessionControlTransactionDAO getDAO_() {
/*  40 */     return (SessionControlTransactionDAO)this._daoImpl;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Date getCreateDate() {
/*  48 */     return getDAO_().getCreateDate();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setCreateDate(Date argCreateDate) {
/*  56 */     if (setCreateDate_noev(argCreateDate) && 
/*  57 */       this._events != null && 
/*  58 */       postEventsForChanges()) {
/*  59 */       this._events.post(ISessionControlTransaction.SET_CREATEDATE, argCreateDate);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setCreateDate_noev(Date argCreateDate) {
/*  66 */     boolean ev_postable = false;
/*     */     
/*  68 */     if ((getDAO_().getCreateDate() == null && argCreateDate != null) || (
/*  69 */       getDAO_().getCreateDate() != null && !getDAO_().getCreateDate().equals(argCreateDate))) {
/*  70 */       getDAO_().setCreateDate(argCreateDate);
/*  71 */       ev_postable = true;
/*     */     } 
/*     */     
/*  74 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getCreateUserId() {
/*  82 */     return getDAO_().getCreateUserId();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setCreateUserId(String argCreateUserId) {
/*  90 */     if (setCreateUserId_noev(argCreateUserId) && 
/*  91 */       this._events != null && 
/*  92 */       postEventsForChanges()) {
/*  93 */       this._events.post(ISessionControlTransaction.SET_CREATEUSERID, argCreateUserId);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setCreateUserId_noev(String argCreateUserId) {
/* 100 */     boolean ev_postable = false;
/*     */     
/* 102 */     if ((getDAO_().getCreateUserId() == null && argCreateUserId != null) || (
/* 103 */       getDAO_().getCreateUserId() != null && !getDAO_().getCreateUserId().equals(argCreateUserId))) {
/* 104 */       getDAO_().setCreateUserId(argCreateUserId);
/* 105 */       ev_postable = true;
/*     */     } 
/*     */     
/* 108 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Date getUpdateDate() {
/* 116 */     return getDAO_().getUpdateDate();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setUpdateDate(Date argUpdateDate) {
/* 124 */     if (setUpdateDate_noev(argUpdateDate) && 
/* 125 */       this._events != null && 
/* 126 */       postEventsForChanges()) {
/* 127 */       this._events.post(ISessionControlTransaction.SET_UPDATEDATE, argUpdateDate);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setUpdateDate_noev(Date argUpdateDate) {
/* 134 */     boolean ev_postable = false;
/*     */     
/* 136 */     if ((getDAO_().getUpdateDate() == null && argUpdateDate != null) || (
/* 137 */       getDAO_().getUpdateDate() != null && !getDAO_().getUpdateDate().equals(argUpdateDate))) {
/* 138 */       getDAO_().setUpdateDate(argUpdateDate);
/* 139 */       ev_postable = true;
/*     */     } 
/*     */     
/* 142 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getUpdateUserId() {
/* 150 */     return getDAO_().getUpdateUserId();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setUpdateUserId(String argUpdateUserId) {
/* 158 */     if (setUpdateUserId_noev(argUpdateUserId) && 
/* 159 */       this._events != null && 
/* 160 */       postEventsForChanges()) {
/* 161 */       this._events.post(ISessionControlTransaction.SET_UPDATEUSERID, argUpdateUserId);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setUpdateUserId_noev(String argUpdateUserId) {
/* 168 */     boolean ev_postable = false;
/*     */     
/* 170 */     if ((getDAO_().getUpdateUserId() == null && argUpdateUserId != null) || (
/* 171 */       getDAO_().getUpdateUserId() != null && !getDAO_().getUpdateUserId().equals(argUpdateUserId))) {
/* 172 */       getDAO_().setUpdateUserId(argUpdateUserId);
/* 173 */       ev_postable = true;
/*     */     } 
/*     */     
/* 176 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getTypeCode() {
/* 184 */     return getDAO_().getTypeCode();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setTypeCode(String argTypeCode) {
/* 192 */     if (setTypeCode_noev(argTypeCode) && 
/* 193 */       this._events != null && 
/* 194 */       postEventsForChanges()) {
/* 195 */       this._events.post(ISessionControlTransaction.SET_TYPECODE, argTypeCode);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setTypeCode_noev(String argTypeCode) {
/* 202 */     boolean ev_postable = false;
/*     */     
/* 204 */     if ((getDAO_().getTypeCode() == null && argTypeCode != null) || (
/* 205 */       getDAO_().getTypeCode() != null && !getDAO_().getTypeCode().equals(argTypeCode))) {
/* 206 */       getDAO_().setTypeCode(argTypeCode);
/* 207 */       ev_postable = true;
/*     */     } 
/*     */     
/* 210 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int getSessionWorkstationSequence() {
/* 218 */     if (getDAO_().getSessionWorkstationSequence() != null) {
/* 219 */       return getDAO_().getSessionWorkstationSequence().intValue();
/*     */     }
/*     */     
/* 222 */     return 0;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setSessionWorkstationSequence(int argSessionWorkstationSequence) {
/* 231 */     if (setSessionWorkstationSequence_noev(argSessionWorkstationSequence) && 
/* 232 */       this._events != null && 
/* 233 */       postEventsForChanges()) {
/* 234 */       this._events.post(ISessionControlTransaction.SET_SESSIONWORKSTATIONSEQUENCE, Integer.valueOf(argSessionWorkstationSequence));
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setSessionWorkstationSequence_noev(int argSessionWorkstationSequence) {
/* 241 */     boolean ev_postable = false;
/*     */     
/* 243 */     if ((getDAO_().getSessionWorkstationSequence() == null && Integer.valueOf(argSessionWorkstationSequence) != null) || (
/* 244 */       getDAO_().getSessionWorkstationSequence() != null && !getDAO_().getSessionWorkstationSequence().equals(Integer.valueOf(argSessionWorkstationSequence)))) {
/* 245 */       getDAO_().setSessionWorkstationSequence(Integer.valueOf(argSessionWorkstationSequence));
/* 246 */       ev_postable = true;
/*     */     } 
/*     */     
/* 249 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @Relationship(name = "Session")
/*     */   public ISession getSession() {
/* 261 */     return this._session;
/*     */   }
/*     */ 
/*     */   
/*     */   public void setSession(ISession argSession) {
/* 266 */     if (argSession == null) {
/*     */       
/* 268 */       getDAO_().setSessionId(null);
/* 269 */       if (this._session != null)
/*     */       {
/* 271 */         if (postEventsForChanges()) {
/* 272 */           this._eventManager.deregisterEventHandler((IEventAware)this._eventCascade, (IEventSource)new EventDescriptor(this._session));
/*     */         }
/*     */       }
/*     */     } else {
/*     */       
/* 277 */       getDAO_().setSessionId(Long.valueOf(argSession.getSessionId()));
/*     */       
/* 279 */       if (postEventsForChanges()) {
/* 280 */         this._eventManager.registerEventHandler((IEventAware)this._eventCascade, (IEventSource)new EventDescriptor(argSession));
/*     */       }
/*     */     } 
/*     */     
/* 284 */     this._session = argSession;
/* 285 */     if (postEventsForChanges()) {
/* 286 */       this._events.post(ISessionControlTransaction.SET_SESSION, argSession);
/*     */     }
/*     */   }
/*     */   
/*     */   @Relationship(name = "SessionWorkstation")
/*     */   public ISessionWorkstation getSessionWorkstation() {
/* 292 */     return this._sessionWorkstation;
/*     */   }
/*     */ 
/*     */   
/*     */   public void setSessionWorkstation(ISessionWorkstation argSessionWorkstation) {
/* 297 */     if (argSessionWorkstation == null) {
/*     */       
/* 299 */       getDAO_().setSessionId(null);
/* 300 */       getDAO_().setSessionWorkstationSequence((Integer)null);
/* 301 */       if (this._sessionWorkstation != null)
/*     */       {
/* 303 */         if (postEventsForChanges()) {
/* 304 */           this._eventManager.deregisterEventHandler((IEventAware)this._eventCascade, (IEventSource)new EventDescriptor(this._sessionWorkstation));
/*     */         }
/*     */       }
/*     */     } else {
/*     */       
/* 309 */       getDAO_().setSessionId(Long.valueOf(argSessionWorkstation.getSessionId()));
/* 310 */       getDAO_().setSessionWorkstationSequence(Integer.valueOf(argSessionWorkstation.getSessionWorkstationSequenceNbr()));
/*     */       
/* 312 */       if (postEventsForChanges()) {
/* 313 */         this._eventManager.registerEventHandler((IEventAware)this._eventCascade, (IEventSource)new EventDescriptor(argSessionWorkstation));
/*     */       }
/*     */     } 
/*     */     
/* 317 */     this._sessionWorkstation = argSessionWorkstation;
/* 318 */     if (postEventsForChanges()) {
/* 319 */       this._events.post(ISessionControlTransaction.SET_SESSIONWORKSTATION, argSessionWorkstation);
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public Object getValue(String argFieldId) {
/* 325 */     if ("Session".equals(argFieldId)) {
/* 326 */       return getSession();
/*     */     }
/* 328 */     if ("SessionWorkstation".equals(argFieldId)) {
/* 329 */       return getSessionWorkstation();
/*     */     }
/* 331 */     if ("SessionControlTransactionExtension".equals(argFieldId)) {
/* 332 */       return this._myExtension;
/*     */     }
/*     */     
/* 335 */     return super.getValue(argFieldId);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void setValue(String argFieldId, Object argValue) {
/* 341 */     if ("Session".equals(argFieldId)) {
/* 342 */       setSession((ISession)argValue);
/*     */     }
/* 344 */     else if ("SessionWorkstation".equals(argFieldId)) {
/* 345 */       setSessionWorkstation((ISessionWorkstation)argValue);
/*     */     }
/* 347 */     else if ("SessionControlTransactionExtension".equals(argFieldId)) {
/* 348 */       this._myExtension = (IDataModel)argValue;
/*     */     } else {
/*     */       
/* 351 */       super.setValue(argFieldId, argValue);
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public void setDependencies(IPersistenceDefaults argPD, EventManager argEM) {
/* 357 */     super.setDependencies(argPD, argEM);
/* 358 */     if (this._session != null) {
/* 359 */       ((IDataModelImpl)this._session).setDependencies(argPD, argEM);
/*     */     }
/* 361 */     if (this._sessionWorkstation != null) {
/* 362 */       ((IDataModelImpl)this._sessionWorkstation).setDependencies(argPD, argEM);
/*     */     }
/*     */   }
/*     */   
/*     */   public IDataModel getSessionControlTransactionExt() {
/* 367 */     return this._myExtension;
/*     */   }
/*     */   
/*     */   public void setSessionControlTransactionExt(IDataModel argExt) {
/* 371 */     this._myExtension = argExt;
/*     */   }
/*     */ 
/*     */   
/*     */   public void startTransaction() {
/* 376 */     if (this._alreadyInStart) {
/*     */       return;
/*     */     }
/*     */     
/* 380 */     this._alreadyInStart = true;
/*     */ 
/*     */     
/* 383 */     super.startTransaction();
/*     */     
/* 385 */     this._sessionSavepoint = this._session;
/* 386 */     if (this._session != null) {
/* 387 */       this._session.startTransaction();
/*     */     }
/*     */     
/* 390 */     this._sessionWorkstationSavepoint = this._sessionWorkstation;
/* 391 */     if (this._sessionWorkstation != null) {
/* 392 */       this._sessionWorkstation.startTransaction();
/*     */     }
/*     */ 
/*     */     
/* 396 */     this._alreadyInStart = false;
/*     */   }
/*     */ 
/*     */   
/*     */   public void rollbackChanges() {
/* 401 */     if (isAlreadyRolledBack()) {
/*     */       return;
/*     */     }
/* 404 */     super.rollbackChanges();
/*     */     
/* 406 */     this._session = this._sessionSavepoint;
/* 407 */     this._sessionSavepoint = null;
/* 408 */     if (this._session != null) {
/* 409 */       this._session.rollbackChanges();
/*     */     }
/*     */     
/* 412 */     this._sessionWorkstation = this._sessionWorkstationSavepoint;
/* 413 */     this._sessionWorkstationSavepoint = null;
/* 414 */     if (this._sessionWorkstation != null) {
/* 415 */       this._sessionWorkstation.rollbackChanges();
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void commitTransaction() {
/* 422 */     if (this._alreadyInCommit) {
/*     */       return;
/*     */     }
/* 425 */     this._alreadyInCommit = true;
/*     */ 
/*     */     
/* 428 */     super.commitTransaction();
/*     */     
/* 430 */     this._sessionSavepoint = this._session;
/* 431 */     if (this._session != null) {
/* 432 */       this._session.commitTransaction();
/*     */     }
/*     */     
/* 435 */     this._sessionWorkstationSavepoint = this._sessionWorkstation;
/* 436 */     if (this._sessionWorkstation != null) {
/* 437 */       this._sessionWorkstation.commitTransaction();
/*     */     }
/*     */ 
/*     */     
/* 441 */     this._alreadyInCommit = false;
/*     */   }
/*     */ 
/*     */   
/*     */   private void readObject(ObjectInputStream argStream) throws IOException, ClassNotFoundException {
/* 446 */     argStream.defaultReadObject();
/*     */   }
/*     */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\tsn\impl\SessionControlTransactionModel.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */