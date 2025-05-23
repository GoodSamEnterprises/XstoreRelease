/*     */ package dtv.xst.dao.doc.impl;
/*     */ import dtv.data2.IPersistenceDefaults;
/*     */ import dtv.data2.access.IDataAccessObject;
/*     */ import dtv.data2.access.IDataModel;
/*     */ import dtv.data2.access.IDataProperty;
/*     */ import dtv.data2.access.ModelEventor;
/*     */ import dtv.data2.access.exception.DtxException;
/*     */ import dtv.data2.access.impl.IDataModelImpl;
/*     */ import dtv.data2.access.impl.Relationship;
/*     */ import dtv.event.EventDescriptor;
/*     */ import dtv.event.EventManager;
/*     */ import dtv.event.Eventor;
/*     */ import dtv.event.IEventAware;
/*     */ import dtv.event.IEventSource;
/*     */ import dtv.util.HistoricalList;
/*     */ import dtv.util.StringUtils;
/*     */ import dtv.xst.dao.doc.DocumentPropertyId;
/*     */ import dtv.xst.dao.doc.IDocument;
/*     */ import dtv.xst.dao.doc.IDocumentDefinition;
/*     */ import dtv.xst.dao.doc.IDocumentProperty;
/*     */ import java.io.ObjectInputStream;
/*     */ import java.math.BigDecimal;
/*     */ import java.util.Date;
/*     */ import java.util.Iterator;
/*     */ import java.util.List;
/*     */ 
/*     */ public class DocumentModel extends AbstractDataModelWithPropertyImpl<IDocumentProperty> implements IDocument {
/*     */   private static final long serialVersionUID = 926364987L;
/*     */   private transient boolean _alreadyInStart = false;
/*     */   private transient boolean _alreadyInCommit = false;
/*     */   private IDataModel _myExtension;
/*     */   
/*     */   public String toString() {
/*  34 */     return super.toString() + " Id: " + getObjectId();
/*     */   }
/*     */   private IDocumentDefinition _documentDefinition; private transient IDocumentDefinition _documentDefinitionSavepoint; private HistoricalList<IDocumentProperty> _properties; private transient HistoricalList<IDocumentProperty> _propertiesSavepoint;
/*     */   
/*     */   public void initDAO() {
/*  39 */     setDAO((IDataAccessObject)new DocumentDAO());
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private DocumentDAO getDAO_() {
/*  47 */     return (DocumentDAO)this._daoImpl;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getDocumentId() {
/*  55 */     return getDAO_().getDocumentId();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setDocumentId(String argDocumentId) {
/*  63 */     if (setDocumentId_noev(argDocumentId) && 
/*  64 */       this._events != null && 
/*  65 */       postEventsForChanges()) {
/*  66 */       this._events.post(IDocument.SET_DOCUMENTID, argDocumentId);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setDocumentId_noev(String argDocumentId) {
/*  73 */     boolean ev_postable = false;
/*     */     
/*  75 */     if ((getDAO_().getDocumentId() == null && argDocumentId != null) || (
/*  76 */       getDAO_().getDocumentId() != null && !getDAO_().getDocumentId().equals(argDocumentId))) {
/*  77 */       getDAO_().setDocumentId(argDocumentId);
/*  78 */       ev_postable = true;
/*  79 */       if (this._properties != null) {
/*     */         
/*  81 */         Iterator<DocumentPropertyModel> it = this._properties.iterator();
/*  82 */         while (it.hasNext())
/*     */         {
/*  84 */           ((DocumentPropertyModel)it.next()).setDocumentId_noev(argDocumentId);
/*     */         }
/*     */       } 
/*     */     } 
/*     */     
/*  89 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public long getOrganizationId() {
/*  97 */     if (getDAO_().getOrganizationId() != null) {
/*  98 */       return getDAO_().getOrganizationId().longValue();
/*     */     }
/*     */     
/* 101 */     return 0L;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setOrganizationId(long argOrganizationId) {
/* 110 */     if (setOrganizationId_noev(argOrganizationId) && 
/* 111 */       this._events != null && 
/* 112 */       postEventsForChanges()) {
/* 113 */       this._events.post(IDocument.SET_ORGANIZATIONID, Long.valueOf(argOrganizationId));
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setOrganizationId_noev(long argOrganizationId) {
/* 120 */     boolean ev_postable = false;
/*     */     
/* 122 */     if ((getDAO_().getOrganizationId() == null && Long.valueOf(argOrganizationId) != null) || (
/* 123 */       getDAO_().getOrganizationId() != null && !getDAO_().getOrganizationId().equals(Long.valueOf(argOrganizationId)))) {
/* 124 */       getDAO_().setOrganizationId(Long.valueOf(argOrganizationId));
/* 125 */       ev_postable = true;
/* 126 */       if (this._properties != null) {
/*     */         
/* 128 */         Iterator<DocumentPropertyModel> it = this._properties.iterator();
/* 129 */         while (it.hasNext())
/*     */         {
/* 131 */           ((DocumentPropertyModel)it.next()).setOrganizationId_noev(argOrganizationId);
/*     */         }
/*     */       } 
/* 134 */       if (this._documentDefinition != null)
/*     */       {
/*     */         
/* 137 */         ((DocumentDefinitionModel)this._documentDefinition).setOrganizationId_noev(argOrganizationId);
/*     */       }
/*     */     } 
/*     */     
/* 141 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getDocumentType() {
/* 149 */     return getDAO_().getDocumentType();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setDocumentType(String argDocumentType) {
/* 157 */     if (setDocumentType_noev(argDocumentType) && 
/* 158 */       this._events != null && 
/* 159 */       postEventsForChanges()) {
/* 160 */       this._events.post(IDocument.SET_DOCUMENTTYPE, argDocumentType);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setDocumentType_noev(String argDocumentType) {
/* 167 */     boolean ev_postable = false;
/*     */     
/* 169 */     if ((getDAO_().getDocumentType() == null && argDocumentType != null) || (
/* 170 */       getDAO_().getDocumentType() != null && !getDAO_().getDocumentType().equals(argDocumentType))) {
/* 171 */       getDAO_().setDocumentType(argDocumentType);
/* 172 */       ev_postable = true;
/* 173 */       if (this._properties != null) {
/*     */         
/* 175 */         Iterator<DocumentPropertyModel> it = this._properties.iterator();
/* 176 */         while (it.hasNext())
/*     */         {
/* 178 */           ((DocumentPropertyModel)it.next()).setDocumentType_noev(argDocumentType);
/*     */         }
/*     */       } 
/* 181 */       if (this._documentDefinition != null)
/*     */       {
/*     */         
/* 184 */         ((DocumentDefinitionModel)this._documentDefinition).setDocumentType_noev(argDocumentType);
/*     */       }
/*     */     } 
/*     */     
/* 188 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getSeriesId() {
/* 196 */     return getDAO_().getSeriesId();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setSeriesId(String argSeriesId) {
/* 204 */     if (setSeriesId_noev(argSeriesId) && 
/* 205 */       this._events != null && 
/* 206 */       postEventsForChanges()) {
/* 207 */       this._events.post(IDocument.SET_SERIESID, argSeriesId);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setSeriesId_noev(String argSeriesId) {
/* 214 */     boolean ev_postable = false;
/*     */     
/* 216 */     if ((getDAO_().getSeriesId() == null && argSeriesId != null) || (
/* 217 */       getDAO_().getSeriesId() != null && !getDAO_().getSeriesId().equals(argSeriesId))) {
/* 218 */       getDAO_().setSeriesId(argSeriesId);
/* 219 */       ev_postable = true;
/* 220 */       if (this._properties != null) {
/*     */         
/* 222 */         Iterator<DocumentPropertyModel> it = this._properties.iterator();
/* 223 */         while (it.hasNext())
/*     */         {
/* 225 */           ((DocumentPropertyModel)it.next()).setSeriesId_noev(argSeriesId);
/*     */         }
/*     */       } 
/* 228 */       if (this._documentDefinition != null)
/*     */       {
/*     */         
/* 231 */         ((DocumentDefinitionModel)this._documentDefinition).setSeriesId_noev(argSeriesId);
/*     */       }
/*     */     } 
/*     */     
/* 235 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Date getCreateDate() {
/* 243 */     return getDAO_().getCreateDate();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setCreateDate(Date argCreateDate) {
/* 251 */     if (setCreateDate_noev(argCreateDate) && 
/* 252 */       this._events != null && 
/* 253 */       postEventsForChanges()) {
/* 254 */       this._events.post(IDocument.SET_CREATEDATE, argCreateDate);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setCreateDate_noev(Date argCreateDate) {
/* 261 */     boolean ev_postable = false;
/*     */     
/* 263 */     if ((getDAO_().getCreateDate() == null && argCreateDate != null) || (
/* 264 */       getDAO_().getCreateDate() != null && !getDAO_().getCreateDate().equals(argCreateDate))) {
/* 265 */       getDAO_().setCreateDate(argCreateDate);
/* 266 */       ev_postable = true;
/*     */     } 
/*     */     
/* 269 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getCreateUserId() {
/* 277 */     return getDAO_().getCreateUserId();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setCreateUserId(String argCreateUserId) {
/* 285 */     if (setCreateUserId_noev(argCreateUserId) && 
/* 286 */       this._events != null && 
/* 287 */       postEventsForChanges()) {
/* 288 */       this._events.post(IDocument.SET_CREATEUSERID, argCreateUserId);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setCreateUserId_noev(String argCreateUserId) {
/* 295 */     boolean ev_postable = false;
/*     */     
/* 297 */     if ((getDAO_().getCreateUserId() == null && argCreateUserId != null) || (
/* 298 */       getDAO_().getCreateUserId() != null && !getDAO_().getCreateUserId().equals(argCreateUserId))) {
/* 299 */       getDAO_().setCreateUserId(argCreateUserId);
/* 300 */       ev_postable = true;
/*     */     } 
/*     */     
/* 303 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Date getUpdateDate() {
/* 311 */     return getDAO_().getUpdateDate();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setUpdateDate(Date argUpdateDate) {
/* 319 */     if (setUpdateDate_noev(argUpdateDate) && 
/* 320 */       this._events != null && 
/* 321 */       postEventsForChanges()) {
/* 322 */       this._events.post(IDocument.SET_UPDATEDATE, argUpdateDate);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setUpdateDate_noev(Date argUpdateDate) {
/* 329 */     boolean ev_postable = false;
/*     */     
/* 331 */     if ((getDAO_().getUpdateDate() == null && argUpdateDate != null) || (
/* 332 */       getDAO_().getUpdateDate() != null && !getDAO_().getUpdateDate().equals(argUpdateDate))) {
/* 333 */       getDAO_().setUpdateDate(argUpdateDate);
/* 334 */       ev_postable = true;
/*     */     } 
/*     */     
/* 337 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getUpdateUserId() {
/* 345 */     return getDAO_().getUpdateUserId();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setUpdateUserId(String argUpdateUserId) {
/* 353 */     if (setUpdateUserId_noev(argUpdateUserId) && 
/* 354 */       this._events != null && 
/* 355 */       postEventsForChanges()) {
/* 356 */       this._events.post(IDocument.SET_UPDATEUSERID, argUpdateUserId);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setUpdateUserId_noev(String argUpdateUserId) {
/* 363 */     boolean ev_postable = false;
/*     */     
/* 365 */     if ((getDAO_().getUpdateUserId() == null && argUpdateUserId != null) || (
/* 366 */       getDAO_().getUpdateUserId() != null && !getDAO_().getUpdateUserId().equals(argUpdateUserId))) {
/* 367 */       getDAO_().setUpdateUserId(argUpdateUserId);
/* 368 */       ev_postable = true;
/*     */     } 
/*     */     
/* 371 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getOrgCode() {
/* 379 */     return getDAO_().getOrgCode();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setOrgCode(String argOrgCode) {
/* 387 */     if (setOrgCode_noev(argOrgCode) && 
/* 388 */       this._events != null && 
/* 389 */       postEventsForChanges()) {
/* 390 */       this._events.post(IDocument.SET_ORGCODE, argOrgCode);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setOrgCode_noev(String argOrgCode) {
/* 397 */     boolean ev_postable = false;
/*     */     
/* 399 */     if ((getDAO_().getOrgCode() == null && argOrgCode != null) || (
/* 400 */       getDAO_().getOrgCode() != null && !getDAO_().getOrgCode().equals(argOrgCode))) {
/* 401 */       getDAO_().setOrgCode(argOrgCode);
/* 402 */       ev_postable = true;
/*     */     } 
/*     */     
/* 405 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getOrgValue() {
/* 413 */     return getDAO_().getOrgValue();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setOrgValue(String argOrgValue) {
/* 421 */     if (setOrgValue_noev(argOrgValue) && 
/* 422 */       this._events != null && 
/* 423 */       postEventsForChanges()) {
/* 424 */       this._events.post(IDocument.SET_ORGVALUE, argOrgValue);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setOrgValue_noev(String argOrgValue) {
/* 431 */     boolean ev_postable = false;
/*     */     
/* 433 */     if ((getDAO_().getOrgValue() == null && argOrgValue != null) || (
/* 434 */       getDAO_().getOrgValue() != null && !getDAO_().getOrgValue().equals(argOrgValue))) {
/* 435 */       getDAO_().setOrgValue(argOrgValue);
/* 436 */       ev_postable = true;
/*     */     } 
/*     */     
/* 439 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getDocumentStatus() {
/* 447 */     return getDAO_().getDocumentStatus();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setDocumentStatus(String argDocumentStatus) {
/* 455 */     if (setDocumentStatus_noev(argDocumentStatus) && 
/* 456 */       this._events != null && 
/* 457 */       postEventsForChanges()) {
/* 458 */       this._events.post(IDocument.SET_DOCUMENTSTATUS, argDocumentStatus);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setDocumentStatus_noev(String argDocumentStatus) {
/* 465 */     boolean ev_postable = false;
/*     */     
/* 467 */     if ((getDAO_().getDocumentStatus() == null && argDocumentStatus != null) || (
/* 468 */       getDAO_().getDocumentStatus() != null && !getDAO_().getDocumentStatus().equals(argDocumentStatus))) {
/* 469 */       getDAO_().setDocumentStatus(argDocumentStatus);
/* 470 */       ev_postable = true;
/*     */     } 
/*     */     
/* 473 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Date getIssueDate() {
/* 481 */     return getDAO_().getIssueDate();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setIssueDate(Date argIssueDate) {
/* 489 */     if (setIssueDate_noev(argIssueDate) && 
/* 490 */       this._events != null && 
/* 491 */       postEventsForChanges()) {
/* 492 */       this._events.post(IDocument.SET_ISSUEDATE, argIssueDate);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setIssueDate_noev(Date argIssueDate) {
/* 499 */     boolean ev_postable = false;
/*     */     
/* 501 */     if ((getDAO_().getIssueDate() == null && argIssueDate != null) || (
/* 502 */       getDAO_().getIssueDate() != null && !getDAO_().getIssueDate().equals(argIssueDate))) {
/* 503 */       getDAO_().setIssueDate(argIssueDate);
/* 504 */       ev_postable = true;
/*     */     } 
/*     */     
/* 507 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Date getEffectiveDate() {
/* 515 */     return getDAO_().getEffectiveDate();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setEffectiveDate(Date argEffectiveDate) {
/* 523 */     if (setEffectiveDate_noev(argEffectiveDate) && 
/* 524 */       this._events != null && 
/* 525 */       postEventsForChanges()) {
/* 526 */       this._events.post(IDocument.SET_EFFECTIVEDATE, argEffectiveDate);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setEffectiveDate_noev(Date argEffectiveDate) {
/* 533 */     boolean ev_postable = false;
/*     */     
/* 535 */     if ((getDAO_().getEffectiveDate() == null && argEffectiveDate != null) || (
/* 536 */       getDAO_().getEffectiveDate() != null && !getDAO_().getEffectiveDate().equals(argEffectiveDate))) {
/* 537 */       getDAO_().setEffectiveDate(argEffectiveDate);
/* 538 */       ev_postable = true;
/*     */     } 
/*     */     
/* 541 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Date getExpirationDate() {
/* 549 */     return getDAO_().getExpirationDate();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setExpirationDate(Date argExpirationDate) {
/* 557 */     if (setExpirationDate_noev(argExpirationDate) && 
/* 558 */       this._events != null && 
/* 559 */       postEventsForChanges()) {
/* 560 */       this._events.post(IDocument.SET_EXPIRATIONDATE, argExpirationDate);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setExpirationDate_noev(Date argExpirationDate) {
/* 567 */     boolean ev_postable = false;
/*     */     
/* 569 */     if ((getDAO_().getExpirationDate() == null && argExpirationDate != null) || (
/* 570 */       getDAO_().getExpirationDate() != null && !getDAO_().getExpirationDate().equals(argExpirationDate))) {
/* 571 */       getDAO_().setExpirationDate(argExpirationDate);
/* 572 */       ev_postable = true;
/*     */     } 
/*     */     
/* 575 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public BigDecimal getAmount() {
/* 583 */     return getDAO_().getAmount();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setAmount(BigDecimal argAmount) {
/* 591 */     if (setAmount_noev(argAmount) && 
/* 592 */       this._events != null && 
/* 593 */       postEventsForChanges()) {
/* 594 */       this._events.post(IDocument.SET_AMOUNT, argAmount);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setAmount_noev(BigDecimal argAmount) {
/* 601 */     boolean ev_postable = false;
/*     */     
/* 603 */     if ((getDAO_().getAmount() == null && argAmount != null) || (
/* 604 */       getDAO_().getAmount() != null && !getDAO_().getAmount().equals(argAmount))) {
/* 605 */       getDAO_().setAmount(argAmount);
/* 606 */       ev_postable = true;
/*     */     } 
/*     */     
/* 609 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public BigDecimal getMaxAmount() {
/* 617 */     return getDAO_().getMaxAmount();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setMaxAmount(BigDecimal argMaxAmount) {
/* 625 */     if (setMaxAmount_noev(argMaxAmount) && 
/* 626 */       this._events != null && 
/* 627 */       postEventsForChanges()) {
/* 628 */       this._events.post(IDocument.SET_MAXAMOUNT, argMaxAmount);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setMaxAmount_noev(BigDecimal argMaxAmount) {
/* 635 */     boolean ev_postable = false;
/*     */     
/* 637 */     if ((getDAO_().getMaxAmount() == null && argMaxAmount != null) || (
/* 638 */       getDAO_().getMaxAmount() != null && !getDAO_().getMaxAmount().equals(argMaxAmount))) {
/* 639 */       getDAO_().setMaxAmount(argMaxAmount);
/* 640 */       ev_postable = true;
/*     */     } 
/*     */     
/* 643 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public BigDecimal getPercent() {
/* 651 */     return getDAO_().getPercent();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setPercent(BigDecimal argPercent) {
/* 659 */     if (setPercent_noev(argPercent) && 
/* 660 */       this._events != null && 
/* 661 */       postEventsForChanges()) {
/* 662 */       this._events.post(IDocument.SET_PERCENT, argPercent);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setPercent_noev(BigDecimal argPercent) {
/* 669 */     boolean ev_postable = false;
/*     */     
/* 671 */     if ((getDAO_().getPercent() == null && argPercent != null) || (
/* 672 */       getDAO_().getPercent() != null && !getDAO_().getPercent().equals(argPercent))) {
/* 673 */       getDAO_().setPercent(argPercent);
/* 674 */       ev_postable = true;
/*     */     } 
/*     */     
/* 677 */     return ev_postable;
/*     */   }
/*     */   
/*     */   protected IDocumentProperty newProperty(String argPropertyName) {
/* 681 */     DocumentPropertyId id = new DocumentPropertyId();
/*     */     
/* 683 */     id.setDocumentId(getDocumentId());
/* 684 */     id.setDocumentType(getDocumentType());
/* 685 */     id.setSeriesId(getSeriesId());
/* 686 */     id.setPropertyCode(argPropertyName);
/*     */     
/* 688 */     IDocumentProperty prop = (IDocumentProperty)DataFactory.getInstance().createNewObject((IObjectId)id, IDocumentProperty.class);
/* 689 */     return prop;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @Relationship(name = "DocumentDefinition")
/*     */   public IDocumentDefinition getDocumentDefinition() {
/* 701 */     return this._documentDefinition;
/*     */   }
/*     */ 
/*     */   
/*     */   public void setDocumentDefinition(IDocumentDefinition argDocumentDefinition) {
/* 706 */     if (argDocumentDefinition == null) {
/*     */       
/* 708 */       if (this._documentDefinition != null) {
/* 709 */         throw new DtxException("An Attempt was made to break a ONE-ONE relationship that cannot be broken because all fields that define the relationship are primary keys on the parent data object.");
/*     */       }
/* 711 */       if (this._documentDefinition != null) {
/*     */         
/* 713 */         if (postEventsForChanges()) {
/* 714 */           this._eventManager.deregisterEventHandler((IEventAware)this._eventCascade, (IEventSource)new EventDescriptor(this._documentDefinition));
/*     */         }
/* 716 */         addDeletedObject((IDataModel)this._documentDefinition);
/*     */       } 
/*     */     } else {
/*     */       
/* 720 */       argDocumentDefinition.setSeriesId(getSeriesId());
/* 721 */       argDocumentDefinition.setOrganizationId(getOrganizationId());
/* 722 */       argDocumentDefinition.setDocumentType(getDocumentType());
/*     */ 
/*     */       
/* 725 */       if (postEventsForChanges()) {
/* 726 */         this._eventManager.registerEventHandler((IEventAware)this._eventCascade, (IEventSource)new EventDescriptor(argDocumentDefinition));
/*     */       }
/*     */     } 
/*     */     
/* 730 */     this._documentDefinition = argDocumentDefinition;
/* 731 */     if (postEventsForChanges()) {
/* 732 */       this._events.post(IDocument.SET_DOCUMENTDEFINITION, argDocumentDefinition);
/*     */     }
/*     */   }
/*     */   
/*     */   @Relationship(name = "Properties")
/*     */   public List<IDocumentProperty> getProperties() {
/* 738 */     if (this._properties == null) {
/* 739 */       this._properties = new HistoricalList(null);
/*     */     }
/* 741 */     return (List<IDocumentProperty>)this._properties;
/*     */   }
/*     */   
/*     */   public void setProperties(List<IDocumentProperty> argProperties) {
/* 745 */     if (this._properties == null) {
/* 746 */       this._properties = new HistoricalList(argProperties);
/*     */     } else {
/* 748 */       this._properties.setCurrentList(argProperties);
/*     */     } 
/*     */     
/* 751 */     for (IDocumentProperty child : this._properties) {
/* 752 */       DocumentPropertyModel model = (DocumentPropertyModel)child;
/* 753 */       model.setDocumentId_noev(getDocumentId());
/* 754 */       model.setOrganizationId_noev(getOrganizationId());
/* 755 */       model.setDocumentType_noev(getDocumentType());
/* 756 */       model.setSeriesId_noev(getSeriesId());
/* 757 */       if (child instanceof IDataModelImpl) {
/* 758 */         IDataAccessObject childDao = ((IDataModelImpl)child).getDAO();
/* 759 */         if (StringUtils.isEmpty(childDao.getOriginDataSource()) && 
/* 760 */           !StringUtils.isEmpty(getDAO().getOriginDataSource())) {
/* 761 */           childDao.setOriginDataSource(getDAO().getOriginDataSource());
/*     */         }
/*     */       } 
/* 764 */       if (postEventsForChanges()) {
/* 765 */         this._eventManager.registerEventHandler((IEventAware)this._eventCascade, (IEventSource)child);
/*     */       }
/*     */     } 
/*     */   }
/*     */   
/*     */   public void addDocumentProperty(IDocumentProperty argDocumentProperty) {
/* 771 */     if (this._properties == null) {
/* 772 */       this._properties = new HistoricalList(null);
/*     */     }
/* 774 */     argDocumentProperty.setDocumentId(getDocumentId());
/* 775 */     argDocumentProperty.setOrganizationId(getOrganizationId());
/* 776 */     argDocumentProperty.setDocumentType(getDocumentType());
/* 777 */     argDocumentProperty.setSeriesId(getSeriesId());
/* 778 */     if (argDocumentProperty instanceof IDataModelImpl) {
/* 779 */       IDataAccessObject childDao = ((IDataModelImpl)argDocumentProperty).getDAO();
/* 780 */       if (StringUtils.isEmpty(childDao.getOriginDataSource()) && 
/* 781 */         !StringUtils.isEmpty(getDAO().getOriginDataSource())) {
/* 782 */         childDao.setOriginDataSource(getDAO().getOriginDataSource());
/*     */       }
/*     */     } 
/*     */ 
/*     */     
/* 787 */     if (postEventsForChanges()) {
/* 788 */       this._eventManager.registerEventHandler((IEventAware)this._eventCascade, (IEventSource)new EventDescriptor(argDocumentProperty));
/*     */     }
/*     */     
/* 791 */     this._properties.add(argDocumentProperty);
/* 792 */     if (postEventsForChanges()) {
/* 793 */       this._events.post(IDocument.ADD_PROPERTIES, argDocumentProperty);
/*     */     }
/*     */   }
/*     */   
/*     */   public void removeDocumentProperty(IDocumentProperty argDocumentProperty) {
/* 798 */     if (this._properties != null) {
/*     */       
/* 800 */       if (postEventsForChanges()) {
/* 801 */         this._eventManager.deregisterEventHandler((IEventAware)this._eventCascade, (IEventSource)new EventDescriptor(argDocumentProperty));
/*     */       }
/* 803 */       this._properties.remove(argDocumentProperty);
/* 804 */       if (postEventsForChanges()) {
/* 805 */         this._events.post(IDocument.REMOVE_PROPERTIES, argDocumentProperty);
/*     */       }
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public Object getValue(String argFieldId) {
/* 812 */     if ("DocumentDefinition".equals(argFieldId)) {
/* 813 */       return getDocumentDefinition();
/*     */     }
/* 815 */     if ("Properties".equals(argFieldId)) {
/* 816 */       return getProperties();
/*     */     }
/* 818 */     if ("DocumentExtension".equals(argFieldId)) {
/* 819 */       return this._myExtension;
/*     */     }
/*     */     
/* 822 */     return super.getValue(argFieldId);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void setValue(String argFieldId, Object argValue) {
/* 828 */     if ("DocumentDefinition".equals(argFieldId)) {
/* 829 */       setDocumentDefinition((IDocumentDefinition)argValue);
/*     */     }
/* 831 */     else if ("Properties".equals(argFieldId)) {
/* 832 */       setProperties(changeToList(argValue, IDocumentProperty.class));
/*     */     }
/* 834 */     else if ("DocumentExtension".equals(argFieldId)) {
/* 835 */       this._myExtension = (IDataModel)argValue;
/*     */     } else {
/*     */       
/* 838 */       super.setValue(argFieldId, argValue);
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public void setDependencies(IPersistenceDefaults argPD, EventManager argEM) {
/* 844 */     this._persistenceDefaults = argPD;
/* 845 */     this._daoImpl.setPersistenceDefaults(argPD);
/* 846 */     this._eventManager = argEM;
/* 847 */     this._events = (Eventor)new ModelEventor((IDataModel)this, argEM);
/* 848 */     this._eventCascade = (EventHandler)new CascadingHandler(this);
/* 849 */     if (this._documentDefinition != null) {
/* 850 */       ((IDataModelImpl)this._documentDefinition).setDependencies(argPD, argEM);
/*     */     }
/* 852 */     if (this._properties != null) {
/* 853 */       for (IDocumentProperty relationship : this._properties) {
/* 854 */         ((IDataModelImpl)relationship).setDependencies(argPD, argEM);
/*     */       }
/*     */     }
/*     */   }
/*     */   
/*     */   public IDataModel getDocumentExt() {
/* 860 */     return this._myExtension;
/*     */   }
/*     */   
/*     */   public void setDocumentExt(IDataModel argExt) {
/* 864 */     this._myExtension = argExt;
/*     */   }
/*     */ 
/*     */   
/*     */   public void startTransaction() {
/* 869 */     if (this._alreadyInStart) {
/*     */       return;
/*     */     }
/*     */     
/* 873 */     this._alreadyInStart = true;
/*     */ 
/*     */     
/* 876 */     super.startTransaction();
/*     */     
/* 878 */     this._documentDefinitionSavepoint = this._documentDefinition;
/* 879 */     if (this._documentDefinition != null) {
/* 880 */       this._documentDefinition.startTransaction();
/*     */     }
/*     */     
/* 883 */     this._propertiesSavepoint = this._properties;
/* 884 */     if (this._properties != null) {
/* 885 */       this._propertiesSavepoint = new HistoricalList((List)this._properties);
/* 886 */       Iterator<IDataModel> it = this._properties.iterator();
/* 887 */       while (it.hasNext()) {
/* 888 */         ((IDataModel)it.next()).startTransaction();
/*     */       }
/*     */     } 
/*     */ 
/*     */     
/* 893 */     this._alreadyInStart = false;
/*     */   }
/*     */ 
/*     */   
/*     */   public void rollbackChanges() {
/* 898 */     if (isAlreadyRolledBack()) {
/*     */       return;
/*     */     }
/* 901 */     super.rollbackChanges();
/*     */     
/* 903 */     this._documentDefinition = this._documentDefinitionSavepoint;
/* 904 */     this._documentDefinitionSavepoint = null;
/* 905 */     if (this._documentDefinition != null) {
/* 906 */       this._documentDefinition.rollbackChanges();
/*     */     }
/*     */     
/* 909 */     this._properties = this._propertiesSavepoint;
/* 910 */     this._propertiesSavepoint = null;
/* 911 */     if (this._properties != null) {
/* 912 */       Iterator<IDataModel> it = this._properties.iterator();
/* 913 */       while (it.hasNext()) {
/* 914 */         ((IDataModel)it.next()).rollbackChanges();
/*     */       }
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void commitTransaction() {
/* 922 */     if (this._alreadyInCommit) {
/*     */       return;
/*     */     }
/* 925 */     this._alreadyInCommit = true;
/*     */ 
/*     */     
/* 928 */     super.commitTransaction();
/*     */     
/* 930 */     this._documentDefinitionSavepoint = this._documentDefinition;
/* 931 */     if (this._documentDefinition != null) {
/* 932 */       this._documentDefinition.commitTransaction();
/*     */     }
/*     */     
/* 935 */     this._propertiesSavepoint = this._properties;
/* 936 */     if (this._properties != null) {
/* 937 */       Iterator<IDataModel> it = this._properties.iterator();
/* 938 */       while (it.hasNext()) {
/* 939 */         ((IDataModel)it.next()).commitTransaction();
/*     */       }
/* 941 */       this._properties = new HistoricalList((List)this._properties);
/*     */     } 
/*     */ 
/*     */     
/* 945 */     this._alreadyInCommit = false;
/*     */   }
/*     */ 
/*     */   
/*     */   private void readObject(ObjectInputStream argStream) throws IOException, ClassNotFoundException {
/* 950 */     argStream.defaultReadObject();
/*     */   }
/*     */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\doc\impl\DocumentModel.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */