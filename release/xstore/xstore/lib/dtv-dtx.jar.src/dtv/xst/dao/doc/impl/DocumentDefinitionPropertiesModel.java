/*     */ package dtv.xst.dao.doc.impl;
/*     */ import dtv.data2.IPersistenceDefaults;
/*     */ import dtv.data2.access.IDataAccessObject;
/*     */ import dtv.data2.access.IDataModel;
/*     */ import dtv.data2.access.IDataProperty;
/*     */ import dtv.data2.access.IObjectId;
/*     */ import dtv.data2.access.ModelEventor;
/*     */ import dtv.data2.access.impl.IDataModelImpl;
/*     */ import dtv.data2.access.impl.Relationship;
/*     */ import dtv.event.EventDescriptor;
/*     */ import dtv.event.EventManager;
/*     */ import dtv.event.Eventor;
/*     */ import dtv.event.IEventAware;
/*     */ import dtv.event.IEventSource;
/*     */ import dtv.event.handler.CascadingHandler;
/*     */ import dtv.util.HistoricalList;
/*     */ import dtv.util.StringUtils;
/*     */ import dtv.xst.dao.doc.DocumentDefinitionPropertiesPropertyId;
/*     */ import dtv.xst.dao.doc.IDocumentDefinition;
/*     */ import dtv.xst.dao.doc.IDocumentDefinitionProperties;
/*     */ import dtv.xst.dao.doc.IDocumentDefinitionPropertiesProperty;
/*     */ import java.io.IOException;
/*     */ import java.io.ObjectInputStream;
/*     */ import java.math.BigDecimal;
/*     */ import java.util.Date;
/*     */ import java.util.Iterator;
/*     */ import java.util.List;
/*     */ 
/*     */ public class DocumentDefinitionPropertiesModel extends AbstractDataModelWithPropertyImpl<IDocumentDefinitionPropertiesProperty> implements IDocumentDefinitionProperties {
/*     */   private static final long serialVersionUID = -1633627967L;
/*     */   private IDocumentDefinition _parentDocumentDefinition;
/*     */   private transient boolean _alreadyInStart = false;
/*     */   
/*     */   public String toString() {
/*  35 */     return super.toString() + " Id: " + getObjectId();
/*     */   }
/*     */   private transient boolean _alreadyInCommit = false; private IDataModel _myExtension; private HistoricalList<IDocumentDefinitionPropertiesProperty> _properties; private transient HistoricalList<IDocumentDefinitionPropertiesProperty> _propertiesSavepoint;
/*     */   
/*     */   public void initDAO() {
/*  40 */     setDAO((IDataAccessObject)new DocumentDefinitionPropertiesDAO());
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private DocumentDefinitionPropertiesDAO getDAO_() {
/*  48 */     return (DocumentDefinitionPropertiesDAO)this._daoImpl;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getSeriesId() {
/*  56 */     return getDAO_().getSeriesId();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setSeriesId(String argSeriesId) {
/*  64 */     if (setSeriesId_noev(argSeriesId) && 
/*  65 */       this._events != null && 
/*  66 */       postEventsForChanges()) {
/*  67 */       this._events.post(IDocumentDefinitionProperties.SET_SERIESID, argSeriesId);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setSeriesId_noev(String argSeriesId) {
/*  74 */     boolean ev_postable = false;
/*     */     
/*  76 */     if ((getDAO_().getSeriesId() == null && argSeriesId != null) || (
/*  77 */       getDAO_().getSeriesId() != null && !getDAO_().getSeriesId().equals(argSeriesId))) {
/*  78 */       getDAO_().setSeriesId(argSeriesId);
/*  79 */       ev_postable = true;
/*  80 */       if (this._properties != null) {
/*     */         
/*  82 */         Iterator<DocumentDefinitionPropertiesPropertyModel> it = this._properties.iterator();
/*  83 */         while (it.hasNext())
/*     */         {
/*  85 */           ((DocumentDefinitionPropertiesPropertyModel)it.next()).setSeriesId_noev(argSeriesId);
/*     */         }
/*     */       } 
/*     */     } 
/*     */     
/*  90 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public long getOrganizationId() {
/*  98 */     if (getDAO_().getOrganizationId() != null) {
/*  99 */       return getDAO_().getOrganizationId().longValue();
/*     */     }
/*     */     
/* 102 */     return 0L;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setOrganizationId(long argOrganizationId) {
/* 111 */     if (setOrganizationId_noev(argOrganizationId) && 
/* 112 */       this._events != null && 
/* 113 */       postEventsForChanges()) {
/* 114 */       this._events.post(IDocumentDefinitionProperties.SET_ORGANIZATIONID, Long.valueOf(argOrganizationId));
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setOrganizationId_noev(long argOrganizationId) {
/* 121 */     boolean ev_postable = false;
/*     */     
/* 123 */     if ((getDAO_().getOrganizationId() == null && Long.valueOf(argOrganizationId) != null) || (
/* 124 */       getDAO_().getOrganizationId() != null && !getDAO_().getOrganizationId().equals(Long.valueOf(argOrganizationId)))) {
/* 125 */       getDAO_().setOrganizationId(Long.valueOf(argOrganizationId));
/* 126 */       ev_postable = true;
/* 127 */       if (this._properties != null) {
/*     */         
/* 129 */         Iterator<DocumentDefinitionPropertiesPropertyModel> it = this._properties.iterator();
/* 130 */         while (it.hasNext())
/*     */         {
/* 132 */           ((DocumentDefinitionPropertiesPropertyModel)it.next()).setOrganizationId_noev(argOrganizationId);
/*     */         }
/*     */       } 
/*     */     } 
/*     */     
/* 137 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getDocumentType() {
/* 145 */     return getDAO_().getDocumentType();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setDocumentType(String argDocumentType) {
/* 153 */     if (setDocumentType_noev(argDocumentType) && 
/* 154 */       this._events != null && 
/* 155 */       postEventsForChanges()) {
/* 156 */       this._events.post(IDocumentDefinitionProperties.SET_DOCUMENTTYPE, argDocumentType);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setDocumentType_noev(String argDocumentType) {
/* 163 */     boolean ev_postable = false;
/*     */     
/* 165 */     if ((getDAO_().getDocumentType() == null && argDocumentType != null) || (
/* 166 */       getDAO_().getDocumentType() != null && !getDAO_().getDocumentType().equals(argDocumentType))) {
/* 167 */       getDAO_().setDocumentType(argDocumentType);
/* 168 */       ev_postable = true;
/* 169 */       if (this._properties != null) {
/*     */         
/* 171 */         Iterator<DocumentDefinitionPropertiesPropertyModel> it = this._properties.iterator();
/* 172 */         while (it.hasNext())
/*     */         {
/* 174 */           ((DocumentDefinitionPropertiesPropertyModel)it.next()).setDocumentType_noev(argDocumentType);
/*     */         }
/*     */       } 
/*     */     } 
/*     */     
/* 179 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public long getSequence() {
/* 187 */     if (getDAO_().getSequence() != null) {
/* 188 */       return getDAO_().getSequence().longValue();
/*     */     }
/*     */     
/* 191 */     return 0L;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setSequence(long argSequence) {
/* 200 */     if (setSequence_noev(argSequence) && 
/* 201 */       this._events != null && 
/* 202 */       postEventsForChanges()) {
/* 203 */       this._events.post(IDocumentDefinitionProperties.SET_SEQUENCE, Long.valueOf(argSequence));
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setSequence_noev(long argSequence) {
/* 210 */     boolean ev_postable = false;
/*     */     
/* 212 */     if ((getDAO_().getSequence() == null && Long.valueOf(argSequence) != null) || (
/* 213 */       getDAO_().getSequence() != null && !getDAO_().getSequence().equals(Long.valueOf(argSequence)))) {
/* 214 */       getDAO_().setSequence(Long.valueOf(argSequence));
/* 215 */       ev_postable = true;
/* 216 */       if (this._properties != null) {
/*     */         
/* 218 */         Iterator<DocumentDefinitionPropertiesPropertyModel> it = this._properties.iterator();
/* 219 */         while (it.hasNext())
/*     */         {
/* 221 */           ((DocumentDefinitionPropertiesPropertyModel)it.next()).setSequence_noev(argSequence);
/*     */         }
/*     */       } 
/*     */     } 
/*     */     
/* 226 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Date getCreateDate() {
/* 234 */     return getDAO_().getCreateDate();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setCreateDate(Date argCreateDate) {
/* 242 */     if (setCreateDate_noev(argCreateDate) && 
/* 243 */       this._events != null && 
/* 244 */       postEventsForChanges()) {
/* 245 */       this._events.post(IDocumentDefinitionProperties.SET_CREATEDATE, argCreateDate);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setCreateDate_noev(Date argCreateDate) {
/* 252 */     boolean ev_postable = false;
/*     */     
/* 254 */     if ((getDAO_().getCreateDate() == null && argCreateDate != null) || (
/* 255 */       getDAO_().getCreateDate() != null && !getDAO_().getCreateDate().equals(argCreateDate))) {
/* 256 */       getDAO_().setCreateDate(argCreateDate);
/* 257 */       ev_postable = true;
/*     */     } 
/*     */     
/* 260 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getCreateUserId() {
/* 268 */     return getDAO_().getCreateUserId();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setCreateUserId(String argCreateUserId) {
/* 276 */     if (setCreateUserId_noev(argCreateUserId) && 
/* 277 */       this._events != null && 
/* 278 */       postEventsForChanges()) {
/* 279 */       this._events.post(IDocumentDefinitionProperties.SET_CREATEUSERID, argCreateUserId);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setCreateUserId_noev(String argCreateUserId) {
/* 286 */     boolean ev_postable = false;
/*     */     
/* 288 */     if ((getDAO_().getCreateUserId() == null && argCreateUserId != null) || (
/* 289 */       getDAO_().getCreateUserId() != null && !getDAO_().getCreateUserId().equals(argCreateUserId))) {
/* 290 */       getDAO_().setCreateUserId(argCreateUserId);
/* 291 */       ev_postable = true;
/*     */     } 
/*     */     
/* 294 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Date getUpdateDate() {
/* 302 */     return getDAO_().getUpdateDate();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setUpdateDate(Date argUpdateDate) {
/* 310 */     if (setUpdateDate_noev(argUpdateDate) && 
/* 311 */       this._events != null && 
/* 312 */       postEventsForChanges()) {
/* 313 */       this._events.post(IDocumentDefinitionProperties.SET_UPDATEDATE, argUpdateDate);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setUpdateDate_noev(Date argUpdateDate) {
/* 320 */     boolean ev_postable = false;
/*     */     
/* 322 */     if ((getDAO_().getUpdateDate() == null && argUpdateDate != null) || (
/* 323 */       getDAO_().getUpdateDate() != null && !getDAO_().getUpdateDate().equals(argUpdateDate))) {
/* 324 */       getDAO_().setUpdateDate(argUpdateDate);
/* 325 */       ev_postable = true;
/*     */     } 
/*     */     
/* 328 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getUpdateUserId() {
/* 336 */     return getDAO_().getUpdateUserId();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setUpdateUserId(String argUpdateUserId) {
/* 344 */     if (setUpdateUserId_noev(argUpdateUserId) && 
/* 345 */       this._events != null && 
/* 346 */       postEventsForChanges()) {
/* 347 */       this._events.post(IDocumentDefinitionProperties.SET_UPDATEUSERID, argUpdateUserId);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setUpdateUserId_noev(String argUpdateUserId) {
/* 354 */     boolean ev_postable = false;
/*     */     
/* 356 */     if ((getDAO_().getUpdateUserId() == null && argUpdateUserId != null) || (
/* 357 */       getDAO_().getUpdateUserId() != null && !getDAO_().getUpdateUserId().equals(argUpdateUserId))) {
/* 358 */       getDAO_().setUpdateUserId(argUpdateUserId);
/* 359 */       ev_postable = true;
/*     */     } 
/*     */     
/* 362 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getOrgCode() {
/* 370 */     return getDAO_().getOrgCode();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setOrgCode(String argOrgCode) {
/* 378 */     if (setOrgCode_noev(argOrgCode) && 
/* 379 */       this._events != null && 
/* 380 */       postEventsForChanges()) {
/* 381 */       this._events.post(IDocumentDefinitionProperties.SET_ORGCODE, argOrgCode);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setOrgCode_noev(String argOrgCode) {
/* 388 */     boolean ev_postable = false;
/*     */     
/* 390 */     if ((getDAO_().getOrgCode() == null && argOrgCode != null) || (
/* 391 */       getDAO_().getOrgCode() != null && !getDAO_().getOrgCode().equals(argOrgCode))) {
/* 392 */       getDAO_().setOrgCode(argOrgCode);
/* 393 */       ev_postable = true;
/*     */     } 
/*     */     
/* 396 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getOrgValue() {
/* 404 */     return getDAO_().getOrgValue();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setOrgValue(String argOrgValue) {
/* 412 */     if (setOrgValue_noev(argOrgValue) && 
/* 413 */       this._events != null && 
/* 414 */       postEventsForChanges()) {
/* 415 */       this._events.post(IDocumentDefinitionProperties.SET_ORGVALUE, argOrgValue);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setOrgValue_noev(String argOrgValue) {
/* 422 */     boolean ev_postable = false;
/*     */     
/* 424 */     if ((getDAO_().getOrgValue() == null && argOrgValue != null) || (
/* 425 */       getDAO_().getOrgValue() != null && !getDAO_().getOrgValue().equals(argOrgValue))) {
/* 426 */       getDAO_().setOrgValue(argOrgValue);
/* 427 */       ev_postable = true;
/*     */     } 
/*     */     
/* 430 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getPropertyCode() {
/* 438 */     return getDAO_().getPropertyCode();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setPropertyCode(String argPropertyCode) {
/* 446 */     if (setPropertyCode_noev(argPropertyCode) && 
/* 447 */       this._events != null && 
/* 448 */       postEventsForChanges()) {
/* 449 */       this._events.post(IDocumentDefinitionProperties.SET_PROPERTYCODE, argPropertyCode);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setPropertyCode_noev(String argPropertyCode) {
/* 456 */     boolean ev_postable = false;
/*     */     
/* 458 */     if ((getDAO_().getPropertyCode() == null && argPropertyCode != null) || (
/* 459 */       getDAO_().getPropertyCode() != null && !getDAO_().getPropertyCode().equals(argPropertyCode))) {
/* 460 */       getDAO_().setPropertyCode(argPropertyCode);
/* 461 */       ev_postable = true;
/*     */     } 
/*     */     
/* 464 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getType() {
/* 472 */     return getDAO_().getType();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setType(String argType) {
/* 480 */     if (setType_noev(argType) && 
/* 481 */       this._events != null && 
/* 482 */       postEventsForChanges()) {
/* 483 */       this._events.post(IDocumentDefinitionProperties.SET_TYPE, argType);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setType_noev(String argType) {
/* 490 */     boolean ev_postable = false;
/*     */     
/* 492 */     if ((getDAO_().getType() == null && argType != null) || (
/* 493 */       getDAO_().getType() != null && !getDAO_().getType().equals(argType))) {
/* 494 */       getDAO_().setType(argType);
/* 495 */       ev_postable = true;
/*     */     } 
/*     */     
/* 498 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getStringValue() {
/* 506 */     return getDAO_().getStringValue();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setStringValue(String argStringValue) {
/* 514 */     if (setStringValue_noev(argStringValue) && 
/* 515 */       this._events != null && 
/* 516 */       postEventsForChanges()) {
/* 517 */       this._events.post(IDocumentDefinitionProperties.SET_STRINGVALUE, argStringValue);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setStringValue_noev(String argStringValue) {
/* 524 */     boolean ev_postable = false;
/*     */     
/* 526 */     if ((getDAO_().getStringValue() == null && argStringValue != null) || (
/* 527 */       getDAO_().getStringValue() != null && !getDAO_().getStringValue().equals(argStringValue))) {
/* 528 */       getDAO_().setStringValue(argStringValue);
/* 529 */       ev_postable = true;
/*     */     } 
/*     */     
/* 532 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Date getDateValue() {
/* 540 */     return getDAO_().getDateValue();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setDateValue(Date argDateValue) {
/* 548 */     if (setDateValue_noev(argDateValue) && 
/* 549 */       this._events != null && 
/* 550 */       postEventsForChanges()) {
/* 551 */       this._events.post(IDocumentDefinitionProperties.SET_DATEVALUE, argDateValue);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setDateValue_noev(Date argDateValue) {
/* 558 */     boolean ev_postable = false;
/*     */     
/* 560 */     if ((getDAO_().getDateValue() == null && argDateValue != null) || (
/* 561 */       getDAO_().getDateValue() != null && !getDAO_().getDateValue().equals(argDateValue))) {
/* 562 */       getDAO_().setDateValue(argDateValue);
/* 563 */       ev_postable = true;
/*     */     } 
/*     */     
/* 566 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public BigDecimal getDecimalValue() {
/* 574 */     return getDAO_().getDecimalValue();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setDecimalValue(BigDecimal argDecimalValue) {
/* 582 */     if (setDecimalValue_noev(argDecimalValue) && 
/* 583 */       this._events != null && 
/* 584 */       postEventsForChanges()) {
/* 585 */       this._events.post(IDocumentDefinitionProperties.SET_DECIMALVALUE, argDecimalValue);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setDecimalValue_noev(BigDecimal argDecimalValue) {
/* 592 */     boolean ev_postable = false;
/*     */     
/* 594 */     if ((getDAO_().getDecimalValue() == null && argDecimalValue != null) || (
/* 595 */       getDAO_().getDecimalValue() != null && !getDAO_().getDecimalValue().equals(argDecimalValue))) {
/* 596 */       getDAO_().setDecimalValue(argDecimalValue);
/* 597 */       ev_postable = true;
/*     */     } 
/*     */     
/* 600 */     return ev_postable;
/*     */   }
/*     */   
/*     */   protected IDocumentDefinitionPropertiesProperty newProperty(String argPropertyName) {
/* 604 */     DocumentDefinitionPropertiesPropertyId id = new DocumentDefinitionPropertiesPropertyId();
/*     */     
/* 606 */     id.setSeriesId(getSeriesId());
/* 607 */     id.setDocumentType(getDocumentType());
/* 608 */     id.setSequence(Long.valueOf(getSequence()));
/* 609 */     id.setPropertyCode(argPropertyName);
/*     */     
/* 611 */     IDocumentDefinitionPropertiesProperty prop = (IDocumentDefinitionPropertiesProperty)DataFactory.getInstance().createNewObject((IObjectId)id, IDocumentDefinitionPropertiesProperty.class);
/* 612 */     return prop;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @Relationship(name = "Properties")
/*     */   public List<IDocumentDefinitionPropertiesProperty> getProperties() {
/* 621 */     if (this._properties == null) {
/* 622 */       this._properties = new HistoricalList(null);
/*     */     }
/* 624 */     return (List<IDocumentDefinitionPropertiesProperty>)this._properties;
/*     */   }
/*     */   
/*     */   public void setProperties(List<IDocumentDefinitionPropertiesProperty> argProperties) {
/* 628 */     if (this._properties == null) {
/* 629 */       this._properties = new HistoricalList(argProperties);
/*     */     } else {
/* 631 */       this._properties.setCurrentList(argProperties);
/*     */     } 
/*     */     
/* 634 */     for (IDocumentDefinitionPropertiesProperty child : this._properties) {
/* 635 */       DocumentDefinitionPropertiesPropertyModel model = (DocumentDefinitionPropertiesPropertyModel)child;
/* 636 */       model.setSeriesId_noev(getSeriesId());
/* 637 */       model.setOrganizationId_noev(getOrganizationId());
/* 638 */       model.setDocumentType_noev(getDocumentType());
/* 639 */       model.setSequence_noev(getSequence());
/* 640 */       if (child instanceof IDataModelImpl) {
/* 641 */         IDataAccessObject childDao = ((IDataModelImpl)child).getDAO();
/* 642 */         if (StringUtils.isEmpty(childDao.getOriginDataSource()) && 
/* 643 */           !StringUtils.isEmpty(getDAO().getOriginDataSource())) {
/* 644 */           childDao.setOriginDataSource(getDAO().getOriginDataSource());
/*     */         }
/*     */       } 
/* 647 */       if (postEventsForChanges()) {
/* 648 */         this._eventManager.registerEventHandler((IEventAware)this._eventCascade, (IEventSource)child);
/*     */       }
/*     */     } 
/*     */   }
/*     */   
/*     */   public void addDocumentDefinitionPropertiesProperty(IDocumentDefinitionPropertiesProperty argDocumentDefinitionPropertiesProperty) {
/* 654 */     if (this._properties == null) {
/* 655 */       this._properties = new HistoricalList(null);
/*     */     }
/* 657 */     argDocumentDefinitionPropertiesProperty.setSeriesId(getSeriesId());
/* 658 */     argDocumentDefinitionPropertiesProperty.setOrganizationId(getOrganizationId());
/* 659 */     argDocumentDefinitionPropertiesProperty.setDocumentType(getDocumentType());
/* 660 */     argDocumentDefinitionPropertiesProperty.setSequence(getSequence());
/* 661 */     if (argDocumentDefinitionPropertiesProperty instanceof IDataModelImpl) {
/* 662 */       IDataAccessObject childDao = ((IDataModelImpl)argDocumentDefinitionPropertiesProperty).getDAO();
/* 663 */       if (StringUtils.isEmpty(childDao.getOriginDataSource()) && 
/* 664 */         !StringUtils.isEmpty(getDAO().getOriginDataSource())) {
/* 665 */         childDao.setOriginDataSource(getDAO().getOriginDataSource());
/*     */       }
/*     */     } 
/*     */ 
/*     */     
/* 670 */     if (postEventsForChanges()) {
/* 671 */       this._eventManager.registerEventHandler((IEventAware)this._eventCascade, (IEventSource)new EventDescriptor(argDocumentDefinitionPropertiesProperty));
/*     */     }
/*     */     
/* 674 */     this._properties.add(argDocumentDefinitionPropertiesProperty);
/* 675 */     if (postEventsForChanges()) {
/* 676 */       this._events.post(IDocumentDefinitionProperties.ADD_PROPERTIES, argDocumentDefinitionPropertiesProperty);
/*     */     }
/*     */   }
/*     */   
/*     */   public void removeDocumentDefinitionPropertiesProperty(IDocumentDefinitionPropertiesProperty argDocumentDefinitionPropertiesProperty) {
/* 681 */     if (this._properties != null) {
/*     */       
/* 683 */       if (postEventsForChanges()) {
/* 684 */         this._eventManager.deregisterEventHandler((IEventAware)this._eventCascade, (IEventSource)new EventDescriptor(argDocumentDefinitionPropertiesProperty));
/*     */       }
/* 686 */       this._properties.remove(argDocumentDefinitionPropertiesProperty);
/* 687 */       if (postEventsForChanges()) {
/* 688 */         this._events.post(IDocumentDefinitionProperties.REMOVE_PROPERTIES, argDocumentDefinitionPropertiesProperty);
/*     */       }
/*     */     } 
/*     */   }
/*     */   
/*     */   public void setParentDocumentDefinition(IDocumentDefinition argParentDocumentDefinition) {
/* 694 */     this._parentDocumentDefinition = argParentDocumentDefinition;
/*     */   }
/*     */   
/*     */   public IDocumentDefinition getParentDocumentDefinition() {
/* 698 */     return this._parentDocumentDefinition;
/*     */   }
/*     */ 
/*     */   
/*     */   public Object getValue(String argFieldId) {
/* 703 */     if ("Properties".equals(argFieldId)) {
/* 704 */       return getProperties();
/*     */     }
/* 706 */     if ("DocumentDefinitionPropertiesExtension".equals(argFieldId)) {
/* 707 */       return this._myExtension;
/*     */     }
/*     */     
/* 710 */     return super.getValue(argFieldId);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void setValue(String argFieldId, Object argValue) {
/* 716 */     if ("Properties".equals(argFieldId)) {
/* 717 */       setProperties(changeToList(argValue, IDocumentDefinitionPropertiesProperty.class));
/*     */     }
/* 719 */     else if ("DocumentDefinitionPropertiesExtension".equals(argFieldId)) {
/* 720 */       this._myExtension = (IDataModel)argValue;
/*     */     } else {
/*     */       
/* 723 */       super.setValue(argFieldId, argValue);
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public void setDependencies(IPersistenceDefaults argPD, EventManager argEM) {
/* 729 */     this._persistenceDefaults = argPD;
/* 730 */     this._daoImpl.setPersistenceDefaults(argPD);
/* 731 */     this._eventManager = argEM;
/* 732 */     this._events = (Eventor)new ModelEventor((IDataModel)this, argEM);
/* 733 */     this._eventCascade = (EventHandler)new CascadingHandler(this);
/* 734 */     if (this._properties != null) {
/* 735 */       for (IDocumentDefinitionPropertiesProperty relationship : this._properties) {
/* 736 */         ((IDataModelImpl)relationship).setDependencies(argPD, argEM);
/*     */       }
/*     */     }
/*     */   }
/*     */   
/*     */   public IDataModel getDocumentDefinitionPropertiesExt() {
/* 742 */     return this._myExtension;
/*     */   }
/*     */   
/*     */   public void setDocumentDefinitionPropertiesExt(IDataModel argExt) {
/* 746 */     this._myExtension = argExt;
/*     */   }
/*     */ 
/*     */   
/*     */   public void startTransaction() {
/* 751 */     if (this._alreadyInStart) {
/*     */       return;
/*     */     }
/*     */     
/* 755 */     this._alreadyInStart = true;
/*     */ 
/*     */     
/* 758 */     super.startTransaction();
/*     */     
/* 760 */     this._propertiesSavepoint = this._properties;
/* 761 */     if (this._properties != null) {
/* 762 */       this._propertiesSavepoint = new HistoricalList((List)this._properties);
/* 763 */       Iterator<IDataModel> it = this._properties.iterator();
/* 764 */       while (it.hasNext()) {
/* 765 */         ((IDataModel)it.next()).startTransaction();
/*     */       }
/*     */     } 
/*     */ 
/*     */     
/* 770 */     this._alreadyInStart = false;
/*     */   }
/*     */ 
/*     */   
/*     */   public void rollbackChanges() {
/* 775 */     if (isAlreadyRolledBack()) {
/*     */       return;
/*     */     }
/* 778 */     super.rollbackChanges();
/*     */     
/* 780 */     this._properties = this._propertiesSavepoint;
/* 781 */     this._propertiesSavepoint = null;
/* 782 */     if (this._properties != null) {
/* 783 */       Iterator<IDataModel> it = this._properties.iterator();
/* 784 */       while (it.hasNext()) {
/* 785 */         ((IDataModel)it.next()).rollbackChanges();
/*     */       }
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void commitTransaction() {
/* 793 */     if (this._alreadyInCommit) {
/*     */       return;
/*     */     }
/* 796 */     this._alreadyInCommit = true;
/*     */ 
/*     */     
/* 799 */     super.commitTransaction();
/*     */     
/* 801 */     this._propertiesSavepoint = this._properties;
/* 802 */     if (this._properties != null) {
/* 803 */       Iterator<IDataModel> it = this._properties.iterator();
/* 804 */       while (it.hasNext()) {
/* 805 */         ((IDataModel)it.next()).commitTransaction();
/*     */       }
/* 807 */       this._properties = new HistoricalList((List)this._properties);
/*     */     } 
/*     */ 
/*     */     
/* 811 */     this._alreadyInCommit = false;
/*     */   }
/*     */ 
/*     */   
/*     */   private void readObject(ObjectInputStream argStream) throws IOException, ClassNotFoundException {
/* 816 */     argStream.defaultReadObject();
/*     */   }
/*     */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\doc\impl\DocumentDefinitionPropertiesModel.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */