/*     */ package dtv.xst.dao.doc.impl;
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
/*     */ import dtv.xst.dao.doc.IDocument;
/*     */ import dtv.xst.dao.doc.IDocumentLineItem;
/*     */ import dtv.xst.dao.trl.impl.RetailTransactionLineItemModel;
/*     */ import java.io.IOException;
/*     */ import java.io.ObjectInputStream;
/*     */ import java.util.Date;
/*     */ 
/*     */ public class DocumentLineItemModel
/*     */   extends RetailTransactionLineItemModel
/*     */   implements IDocumentLineItem
/*     */ {
/*     */   private static final long serialVersionUID = -1314475134L;
/*     */   private transient boolean _alreadyInStart = false;
/*     */   private transient boolean _alreadyInCommit = false;
/*     */   private IDataModel _myExtension;
/*     */   private IDocument _document;
/*     */   private transient IDocument _documentSavepoint;
/*     */   
/*     */   public void initDAO() {
/*  31 */     setDAO((IDataAccessObject)new DocumentLineItemDAO());
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private DocumentLineItemDAO getDAO_() {
/*  39 */     return (DocumentLineItemDAO)this._daoImpl;
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
/*  58 */       this._events.post(IDocumentLineItem.SET_CREATEDATE, argCreateDate);
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
/*  92 */       this._events.post(IDocumentLineItem.SET_CREATEUSERID, argCreateUserId);
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
/* 126 */       this._events.post(IDocumentLineItem.SET_UPDATEDATE, argUpdateDate);
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
/* 160 */       this._events.post(IDocumentLineItem.SET_UPDATEUSERID, argUpdateUserId);
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
/*     */   public String getSeriesId() {
/* 183 */     return getDAO_().getSeriesId();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setSeriesId(String argSeriesId) {
/* 191 */     if (setSeriesId_noev(argSeriesId) && 
/* 192 */       this._events != null && 
/* 193 */       postEventsForChanges()) {
/* 194 */       this._events.post(IDocumentLineItem.SET_SERIESID, argSeriesId);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setSeriesId_noev(String argSeriesId) {
/* 201 */     boolean ev_postable = false;
/*     */     
/* 203 */     if ((getDAO_().getSeriesId() == null && argSeriesId != null) || (
/* 204 */       getDAO_().getSeriesId() != null && !getDAO_().getSeriesId().equals(argSeriesId))) {
/* 205 */       getDAO_().setSeriesId(argSeriesId);
/* 206 */       ev_postable = true;
/*     */     } 
/*     */     
/* 209 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getDocumentId() {
/* 217 */     return getDAO_().getDocumentId();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setDocumentId(String argDocumentId) {
/* 225 */     if (setDocumentId_noev(argDocumentId) && 
/* 226 */       this._events != null && 
/* 227 */       postEventsForChanges()) {
/* 228 */       this._events.post(IDocumentLineItem.SET_DOCUMENTID, argDocumentId);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setDocumentId_noev(String argDocumentId) {
/* 235 */     boolean ev_postable = false;
/*     */     
/* 237 */     if ((getDAO_().getDocumentId() == null && argDocumentId != null) || (
/* 238 */       getDAO_().getDocumentId() != null && !getDAO_().getDocumentId().equals(argDocumentId))) {
/* 239 */       getDAO_().setDocumentId(argDocumentId);
/* 240 */       ev_postable = true;
/*     */     } 
/*     */     
/* 243 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getDocumentType() {
/* 251 */     return getDAO_().getDocumentType();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setDocumentType(String argDocumentType) {
/* 259 */     if (setDocumentType_noev(argDocumentType) && 
/* 260 */       this._events != null && 
/* 261 */       postEventsForChanges()) {
/* 262 */       this._events.post(IDocumentLineItem.SET_DOCUMENTTYPE, argDocumentType);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setDocumentType_noev(String argDocumentType) {
/* 269 */     boolean ev_postable = false;
/*     */     
/* 271 */     if ((getDAO_().getDocumentType() == null && argDocumentType != null) || (
/* 272 */       getDAO_().getDocumentType() != null && !getDAO_().getDocumentType().equals(argDocumentType))) {
/* 273 */       getDAO_().setDocumentType(argDocumentType);
/* 274 */       ev_postable = true;
/*     */     } 
/*     */     
/* 277 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getActivityCode() {
/* 285 */     return getDAO_().getActivityCode();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setActivityCode(String argActivityCode) {
/* 293 */     if (setActivityCode_noev(argActivityCode) && 
/* 294 */       this._events != null && 
/* 295 */       postEventsForChanges()) {
/* 296 */       this._events.post(IDocumentLineItem.SET_ACTIVITYCODE, argActivityCode);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setActivityCode_noev(String argActivityCode) {
/* 303 */     boolean ev_postable = false;
/*     */     
/* 305 */     if ((getDAO_().getActivityCode() == null && argActivityCode != null) || (
/* 306 */       getDAO_().getActivityCode() != null && !getDAO_().getActivityCode().equals(argActivityCode))) {
/* 307 */       getDAO_().setActivityCode(argActivityCode);
/* 308 */       ev_postable = true;
/*     */     } 
/*     */     
/* 311 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @Relationship(name = "Document")
/*     */   public IDocument getDocument() {
/* 320 */     return this._document;
/*     */   }
/*     */ 
/*     */   
/*     */   public void setDocument(IDocument argDocument) {
/* 325 */     if (argDocument == null) {
/*     */       
/* 327 */       getDAO_().setDocumentId(null);
/* 328 */       getDAO_().setDocumentType(null);
/* 329 */       getDAO_().setSeriesId(null);
/* 330 */       if (this._document != null)
/*     */       {
/* 332 */         if (postEventsForChanges()) {
/* 333 */           this._eventManager.deregisterEventHandler((IEventAware)this._eventCascade, (IEventSource)new EventDescriptor(this._document));
/*     */         }
/*     */       }
/*     */     } else {
/*     */       
/* 338 */       getDAO_().setDocumentId(argDocument.getDocumentId());
/* 339 */       getDAO_().setDocumentType(argDocument.getDocumentType());
/* 340 */       getDAO_().setSeriesId(argDocument.getSeriesId());
/*     */       
/* 342 */       if (postEventsForChanges()) {
/* 343 */         this._eventManager.registerEventHandler((IEventAware)this._eventCascade, (IEventSource)new EventDescriptor(argDocument));
/*     */       }
/*     */     } 
/*     */     
/* 347 */     this._document = argDocument;
/* 348 */     if (postEventsForChanges()) {
/* 349 */       this._events.post(IDocumentLineItem.SET_DOCUMENT, argDocument);
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public Object getValue(String argFieldId) {
/* 355 */     if ("Document".equals(argFieldId)) {
/* 356 */       return getDocument();
/*     */     }
/* 358 */     if ("DocumentLineItemExtension".equals(argFieldId)) {
/* 359 */       return this._myExtension;
/*     */     }
/*     */     
/* 362 */     return super.getValue(argFieldId);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void setValue(String argFieldId, Object argValue) {
/* 368 */     if ("Document".equals(argFieldId)) {
/* 369 */       setDocument((IDocument)argValue);
/*     */     }
/* 371 */     else if ("DocumentLineItemExtension".equals(argFieldId)) {
/* 372 */       this._myExtension = (IDataModel)argValue;
/*     */     } else {
/*     */       
/* 375 */       super.setValue(argFieldId, argValue);
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public void setDependencies(IPersistenceDefaults argPD, EventManager argEM) {
/* 381 */     super.setDependencies(argPD, argEM);
/* 382 */     if (this._document != null) {
/* 383 */       ((IDataModelImpl)this._document).setDependencies(argPD, argEM);
/*     */     }
/*     */   }
/*     */   
/*     */   public IDataModel getDocumentLineItemExt() {
/* 388 */     return this._myExtension;
/*     */   }
/*     */   
/*     */   public void setDocumentLineItemExt(IDataModel argExt) {
/* 392 */     this._myExtension = argExt;
/*     */   }
/*     */ 
/*     */   
/*     */   public void startTransaction() {
/* 397 */     if (this._alreadyInStart) {
/*     */       return;
/*     */     }
/*     */     
/* 401 */     this._alreadyInStart = true;
/*     */ 
/*     */     
/* 404 */     super.startTransaction();
/*     */     
/* 406 */     this._documentSavepoint = this._document;
/* 407 */     if (this._document != null) {
/* 408 */       this._document.startTransaction();
/*     */     }
/*     */ 
/*     */     
/* 412 */     this._alreadyInStart = false;
/*     */   }
/*     */ 
/*     */   
/*     */   public void rollbackChanges() {
/* 417 */     if (isAlreadyRolledBack()) {
/*     */       return;
/*     */     }
/* 420 */     super.rollbackChanges();
/*     */     
/* 422 */     this._document = this._documentSavepoint;
/* 423 */     this._documentSavepoint = null;
/* 424 */     if (this._document != null) {
/* 425 */       this._document.rollbackChanges();
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void commitTransaction() {
/* 432 */     if (this._alreadyInCommit) {
/*     */       return;
/*     */     }
/* 435 */     this._alreadyInCommit = true;
/*     */ 
/*     */     
/* 438 */     super.commitTransaction();
/*     */     
/* 440 */     this._documentSavepoint = this._document;
/* 441 */     if (this._document != null) {
/* 442 */       this._document.commitTransaction();
/*     */     }
/*     */ 
/*     */     
/* 446 */     this._alreadyInCommit = false;
/*     */   }
/*     */ 
/*     */   
/*     */   private void readObject(ObjectInputStream argStream) throws IOException, ClassNotFoundException {
/* 451 */     argStream.defaultReadObject();
/*     */   }
/*     */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\doc\impl\DocumentLineItemModel.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */