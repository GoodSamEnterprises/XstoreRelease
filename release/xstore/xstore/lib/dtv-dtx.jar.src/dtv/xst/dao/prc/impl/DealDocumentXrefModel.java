/*     */ package dtv.xst.dao.prc.impl;
/*     */ import dtv.data2.IPersistenceDefaults;
/*     */ import dtv.data2.access.IDataAccessObject;
/*     */ import dtv.data2.access.IDataModel;
/*     */ import dtv.data2.access.IDataProperty;
/*     */ import dtv.data2.access.impl.IDataModelImpl;
/*     */ import dtv.data2.access.impl.Relationship;
/*     */ import dtv.event.EventDescriptor;
/*     */ import dtv.event.EventManager;
/*     */ import dtv.event.IEventAware;
/*     */ import dtv.event.IEventSource;
/*     */ import dtv.util.HistoricalList;
/*     */ import dtv.util.StringUtils;
/*     */ import dtv.xst.dao.doc.IDocumentDefinition;
/*     */ import dtv.xst.dao.doc.impl.DocumentDefinitionModel;
/*     */ import dtv.xst.dao.prc.DealDocumentXrefPropertyId;
/*     */ import dtv.xst.dao.prc.IDeal;
/*     */ import dtv.xst.dao.prc.IDealDocumentXref;
/*     */ import dtv.xst.dao.prc.IDealDocumentXrefProperty;
/*     */ import java.io.ObjectInputStream;
/*     */ import java.util.Date;
/*     */ import java.util.Iterator;
/*     */ import java.util.List;
/*     */ 
/*     */ public class DealDocumentXrefModel extends AbstractDataModelWithPropertyImpl<IDealDocumentXrefProperty> implements IDealDocumentXref {
/*     */   private static final long serialVersionUID = 1151195010L;
/*     */   private transient boolean _alreadyInStart = false;
/*     */   private transient boolean _alreadyInCommit = false;
/*     */   private IDataModel _myExtension;
/*     */   private HistoricalList<IDeal> _deals;
/*     */   
/*     */   public String toString() {
/*  33 */     return super.toString() + " Id: " + getObjectId();
/*     */   }
/*     */   private transient HistoricalList<IDeal> _dealsSavepoint; private HistoricalList<IDocumentDefinition> _docDefinitions; private transient HistoricalList<IDocumentDefinition> _docDefinitionsSavepoint; private HistoricalList<IDealDocumentXrefProperty> _properties; private transient HistoricalList<IDealDocumentXrefProperty> _propertiesSavepoint;
/*     */   
/*     */   public void initDAO() {
/*  38 */     setDAO((IDataAccessObject)new DealDocumentXrefDAO());
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private DealDocumentXrefDAO getDAO_() {
/*  46 */     return (DealDocumentXrefDAO)this._daoImpl;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public long getOrganizationId() {
/*  54 */     if (getDAO_().getOrganizationId() != null) {
/*  55 */       return getDAO_().getOrganizationId().longValue();
/*     */     }
/*     */     
/*  58 */     return 0L;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setOrganizationId(long argOrganizationId) {
/*  67 */     if (setOrganizationId_noev(argOrganizationId) && 
/*  68 */       this._events != null && 
/*  69 */       postEventsForChanges()) {
/*  70 */       this._events.post(IDealDocumentXref.SET_ORGANIZATIONID, Long.valueOf(argOrganizationId));
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setOrganizationId_noev(long argOrganizationId) {
/*  77 */     boolean ev_postable = false;
/*     */     
/*  79 */     if ((getDAO_().getOrganizationId() == null && Long.valueOf(argOrganizationId) != null) || (
/*  80 */       getDAO_().getOrganizationId() != null && !getDAO_().getOrganizationId().equals(Long.valueOf(argOrganizationId)))) {
/*  81 */       getDAO_().setOrganizationId(Long.valueOf(argOrganizationId));
/*  82 */       ev_postable = true;
/*  83 */       if (this._deals != null) {
/*     */         
/*  85 */         Iterator<DealModel> it = this._deals.iterator();
/*  86 */         while (it.hasNext())
/*     */         {
/*  88 */           ((DealModel)it.next()).setOrganizationId_noev(argOrganizationId);
/*     */         }
/*     */       } 
/*  91 */       if (this._docDefinitions != null) {
/*     */         
/*  93 */         Iterator<DocumentDefinitionModel> it = this._docDefinitions.iterator();
/*  94 */         while (it.hasNext())
/*     */         {
/*  96 */           ((DocumentDefinitionModel)it.next()).setOrganizationId_noev(argOrganizationId);
/*     */         }
/*     */       } 
/*  99 */       if (this._properties != null) {
/*     */         
/* 101 */         Iterator<DealDocumentXrefPropertyModel> it = this._properties.iterator();
/* 102 */         while (it.hasNext())
/*     */         {
/* 104 */           ((DealDocumentXrefPropertyModel)it.next()).setOrganizationId_noev(argOrganizationId);
/*     */         }
/*     */       } 
/*     */     } 
/*     */     
/* 109 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getDealId() {
/* 117 */     return getDAO_().getDealId();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setDealId(String argDealId) {
/* 125 */     if (setDealId_noev(argDealId) && 
/* 126 */       this._events != null && 
/* 127 */       postEventsForChanges()) {
/* 128 */       this._events.post(IDealDocumentXref.SET_DEALID, argDealId);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setDealId_noev(String argDealId) {
/* 135 */     boolean ev_postable = false;
/*     */     
/* 137 */     if ((getDAO_().getDealId() == null && argDealId != null) || (
/* 138 */       getDAO_().getDealId() != null && !getDAO_().getDealId().equals(argDealId))) {
/* 139 */       getDAO_().setDealId(argDealId);
/* 140 */       ev_postable = true;
/* 141 */       if (this._deals != null) {
/*     */         
/* 143 */         Iterator<DealModel> it = this._deals.iterator();
/* 144 */         while (it.hasNext())
/*     */         {
/* 146 */           ((DealModel)it.next()).setDealId_noev(argDealId);
/*     */         }
/*     */       } 
/* 149 */       if (this._properties != null) {
/*     */         
/* 151 */         Iterator<DealDocumentXrefPropertyModel> it = this._properties.iterator();
/* 152 */         while (it.hasNext())
/*     */         {
/* 154 */           ((DealDocumentXrefPropertyModel)it.next()).setDealId_noev(argDealId);
/*     */         }
/*     */       } 
/*     */     } 
/*     */     
/* 159 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getSeriesId() {
/* 167 */     return getDAO_().getSeriesId();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setSeriesId(String argSeriesId) {
/* 175 */     if (setSeriesId_noev(argSeriesId) && 
/* 176 */       this._events != null && 
/* 177 */       postEventsForChanges()) {
/* 178 */       this._events.post(IDealDocumentXref.SET_SERIESID, argSeriesId);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setSeriesId_noev(String argSeriesId) {
/* 185 */     boolean ev_postable = false;
/*     */     
/* 187 */     if ((getDAO_().getSeriesId() == null && argSeriesId != null) || (
/* 188 */       getDAO_().getSeriesId() != null && !getDAO_().getSeriesId().equals(argSeriesId))) {
/* 189 */       getDAO_().setSeriesId(argSeriesId);
/* 190 */       ev_postable = true;
/* 191 */       if (this._docDefinitions != null) {
/*     */         
/* 193 */         Iterator<DocumentDefinitionModel> it = this._docDefinitions.iterator();
/* 194 */         while (it.hasNext())
/*     */         {
/* 196 */           ((DocumentDefinitionModel)it.next()).setSeriesId_noev(argSeriesId);
/*     */         }
/*     */       } 
/* 199 */       if (this._properties != null) {
/*     */         
/* 201 */         Iterator<DealDocumentXrefPropertyModel> it = this._properties.iterator();
/* 202 */         while (it.hasNext())
/*     */         {
/* 204 */           ((DealDocumentXrefPropertyModel)it.next()).setSeriesId_noev(argSeriesId);
/*     */         }
/*     */       } 
/*     */     } 
/*     */     
/* 209 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getDocumentType() {
/* 217 */     return getDAO_().getDocumentType();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setDocumentType(String argDocumentType) {
/* 225 */     if (setDocumentType_noev(argDocumentType) && 
/* 226 */       this._events != null && 
/* 227 */       postEventsForChanges()) {
/* 228 */       this._events.post(IDealDocumentXref.SET_DOCUMENTTYPE, argDocumentType);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setDocumentType_noev(String argDocumentType) {
/* 235 */     boolean ev_postable = false;
/*     */     
/* 237 */     if ((getDAO_().getDocumentType() == null && argDocumentType != null) || (
/* 238 */       getDAO_().getDocumentType() != null && !getDAO_().getDocumentType().equals(argDocumentType))) {
/* 239 */       getDAO_().setDocumentType(argDocumentType);
/* 240 */       ev_postable = true;
/* 241 */       if (this._docDefinitions != null) {
/*     */         
/* 243 */         Iterator<DocumentDefinitionModel> it = this._docDefinitions.iterator();
/* 244 */         while (it.hasNext())
/*     */         {
/* 246 */           ((DocumentDefinitionModel)it.next()).setDocumentType_noev(argDocumentType);
/*     */         }
/*     */       } 
/* 249 */       if (this._properties != null) {
/*     */         
/* 251 */         Iterator<DealDocumentXrefPropertyModel> it = this._properties.iterator();
/* 252 */         while (it.hasNext())
/*     */         {
/* 254 */           ((DealDocumentXrefPropertyModel)it.next()).setDocumentType_noev(argDocumentType);
/*     */         }
/*     */       } 
/*     */     } 
/*     */     
/* 259 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getOrgCode() {
/* 267 */     return getDAO_().getOrgCode();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setOrgCode(String argOrgCode) {
/* 275 */     if (setOrgCode_noev(argOrgCode) && 
/* 276 */       this._events != null && 
/* 277 */       postEventsForChanges()) {
/* 278 */       this._events.post(IDealDocumentXref.SET_ORGCODE, argOrgCode);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setOrgCode_noev(String argOrgCode) {
/* 285 */     boolean ev_postable = false;
/*     */     
/* 287 */     if ((getDAO_().getOrgCode() == null && argOrgCode != null) || (
/* 288 */       getDAO_().getOrgCode() != null && !getDAO_().getOrgCode().equals(argOrgCode))) {
/* 289 */       getDAO_().setOrgCode(argOrgCode);
/* 290 */       ev_postable = true;
/*     */     } 
/*     */     
/* 293 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getOrgValue() {
/* 301 */     return getDAO_().getOrgValue();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setOrgValue(String argOrgValue) {
/* 309 */     if (setOrgValue_noev(argOrgValue) && 
/* 310 */       this._events != null && 
/* 311 */       postEventsForChanges()) {
/* 312 */       this._events.post(IDealDocumentXref.SET_ORGVALUE, argOrgValue);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setOrgValue_noev(String argOrgValue) {
/* 319 */     boolean ev_postable = false;
/*     */     
/* 321 */     if ((getDAO_().getOrgValue() == null && argOrgValue != null) || (
/* 322 */       getDAO_().getOrgValue() != null && !getDAO_().getOrgValue().equals(argOrgValue))) {
/* 323 */       getDAO_().setOrgValue(argOrgValue);
/* 324 */       ev_postable = true;
/*     */     } 
/*     */     
/* 327 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Date getCreateDate() {
/* 335 */     return getDAO_().getCreateDate();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setCreateDate(Date argCreateDate) {
/* 343 */     if (setCreateDate_noev(argCreateDate) && 
/* 344 */       this._events != null && 
/* 345 */       postEventsForChanges()) {
/* 346 */       this._events.post(IDealDocumentXref.SET_CREATEDATE, argCreateDate);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setCreateDate_noev(Date argCreateDate) {
/* 353 */     boolean ev_postable = false;
/*     */     
/* 355 */     if ((getDAO_().getCreateDate() == null && argCreateDate != null) || (
/* 356 */       getDAO_().getCreateDate() != null && !getDAO_().getCreateDate().equals(argCreateDate))) {
/* 357 */       getDAO_().setCreateDate(argCreateDate);
/* 358 */       ev_postable = true;
/*     */     } 
/*     */     
/* 361 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getCreateUserId() {
/* 369 */     return getDAO_().getCreateUserId();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setCreateUserId(String argCreateUserId) {
/* 377 */     if (setCreateUserId_noev(argCreateUserId) && 
/* 378 */       this._events != null && 
/* 379 */       postEventsForChanges()) {
/* 380 */       this._events.post(IDealDocumentXref.SET_CREATEUSERID, argCreateUserId);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setCreateUserId_noev(String argCreateUserId) {
/* 387 */     boolean ev_postable = false;
/*     */     
/* 389 */     if ((getDAO_().getCreateUserId() == null && argCreateUserId != null) || (
/* 390 */       getDAO_().getCreateUserId() != null && !getDAO_().getCreateUserId().equals(argCreateUserId))) {
/* 391 */       getDAO_().setCreateUserId(argCreateUserId);
/* 392 */       ev_postable = true;
/*     */     } 
/*     */     
/* 395 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Date getUpdateDate() {
/* 403 */     return getDAO_().getUpdateDate();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setUpdateDate(Date argUpdateDate) {
/* 411 */     if (setUpdateDate_noev(argUpdateDate) && 
/* 412 */       this._events != null && 
/* 413 */       postEventsForChanges()) {
/* 414 */       this._events.post(IDealDocumentXref.SET_UPDATEDATE, argUpdateDate);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setUpdateDate_noev(Date argUpdateDate) {
/* 421 */     boolean ev_postable = false;
/*     */     
/* 423 */     if ((getDAO_().getUpdateDate() == null && argUpdateDate != null) || (
/* 424 */       getDAO_().getUpdateDate() != null && !getDAO_().getUpdateDate().equals(argUpdateDate))) {
/* 425 */       getDAO_().setUpdateDate(argUpdateDate);
/* 426 */       ev_postable = true;
/*     */     } 
/*     */     
/* 429 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getUpdateUserId() {
/* 437 */     return getDAO_().getUpdateUserId();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setUpdateUserId(String argUpdateUserId) {
/* 445 */     if (setUpdateUserId_noev(argUpdateUserId) && 
/* 446 */       this._events != null && 
/* 447 */       postEventsForChanges()) {
/* 448 */       this._events.post(IDealDocumentXref.SET_UPDATEUSERID, argUpdateUserId);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setUpdateUserId_noev(String argUpdateUserId) {
/* 455 */     boolean ev_postable = false;
/*     */     
/* 457 */     if ((getDAO_().getUpdateUserId() == null && argUpdateUserId != null) || (
/* 458 */       getDAO_().getUpdateUserId() != null && !getDAO_().getUpdateUserId().equals(argUpdateUserId))) {
/* 459 */       getDAO_().setUpdateUserId(argUpdateUserId);
/* 460 */       ev_postable = true;
/*     */     } 
/*     */     
/* 463 */     return ev_postable;
/*     */   }
/*     */   
/*     */   protected IDealDocumentXrefProperty newProperty(String argPropertyName) {
/* 467 */     DealDocumentXrefPropertyId id = new DealDocumentXrefPropertyId();
/*     */     
/* 469 */     id.setDealId(getDealId());
/* 470 */     id.setSeriesId(getSeriesId());
/* 471 */     id.setDocumentType(getDocumentType());
/* 472 */     id.setPropertyCode(argPropertyName);
/*     */     
/* 474 */     IDealDocumentXrefProperty prop = (IDealDocumentXrefProperty)DataFactory.getInstance().createNewObject((IObjectId)id, IDealDocumentXrefProperty.class);
/* 475 */     return prop;
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
/*     */   
/*     */   @Relationship(name = "Deals")
/*     */   public List<IDeal> getDeals() {
/* 490 */     if (this._deals == null) {
/* 491 */       this._deals = new HistoricalList(null);
/*     */     }
/* 493 */     return (List<IDeal>)this._deals;
/*     */   }
/*     */   
/*     */   public void setDeals(List<IDeal> argDeals) {
/* 497 */     if (this._deals == null) {
/* 498 */       this._deals = new HistoricalList(argDeals);
/*     */     } else {
/* 500 */       this._deals.setCurrentList(argDeals);
/*     */     } 
/*     */     
/* 503 */     for (IDeal child : this._deals) {
/* 504 */       DealModel model = (DealModel)child;
/* 505 */       model.setOrganizationId_noev(getOrganizationId());
/* 506 */       model.setDealId_noev(getDealId());
/* 507 */       if (child instanceof IDataModelImpl) {
/* 508 */         IDataAccessObject childDao = ((IDataModelImpl)child).getDAO();
/* 509 */         if (StringUtils.isEmpty(childDao.getOriginDataSource()) && 
/* 510 */           !StringUtils.isEmpty(getDAO().getOriginDataSource())) {
/* 511 */           childDao.setOriginDataSource(getDAO().getOriginDataSource());
/*     */         }
/*     */       } 
/* 514 */       if (postEventsForChanges()) {
/* 515 */         this._eventManager.registerEventHandler((IEventAware)this._eventCascade, (IEventSource)child);
/*     */       }
/*     */     } 
/*     */   }
/*     */   
/*     */   public void addDeal(IDeal argDeal) {
/* 521 */     if (this._deals == null) {
/* 522 */       this._deals = new HistoricalList(null);
/*     */     }
/* 524 */     argDeal.setOrganizationId(getOrganizationId());
/* 525 */     argDeal.setDealId(getDealId());
/* 526 */     if (argDeal instanceof IDataModelImpl) {
/* 527 */       IDataAccessObject childDao = ((IDataModelImpl)argDeal).getDAO();
/* 528 */       if (StringUtils.isEmpty(childDao.getOriginDataSource()) && 
/* 529 */         !StringUtils.isEmpty(getDAO().getOriginDataSource())) {
/* 530 */         childDao.setOriginDataSource(getDAO().getOriginDataSource());
/*     */       }
/*     */     } 
/*     */ 
/*     */     
/* 535 */     if (postEventsForChanges()) {
/* 536 */       this._eventManager.registerEventHandler((IEventAware)this._eventCascade, (IEventSource)new EventDescriptor(argDeal));
/*     */     }
/*     */     
/* 539 */     this._deals.add(argDeal);
/* 540 */     if (postEventsForChanges()) {
/* 541 */       this._events.post(IDealDocumentXref.ADD_DEALS, argDeal);
/*     */     }
/*     */   }
/*     */   
/*     */   public void removeDeal(IDeal argDeal) {
/* 546 */     if (this._deals != null) {
/*     */       
/* 548 */       if (postEventsForChanges()) {
/* 549 */         this._eventManager.deregisterEventHandler((IEventAware)this._eventCascade, (IEventSource)new EventDescriptor(argDeal));
/*     */       }
/* 551 */       this._deals.remove(argDeal);
/* 552 */       if (postEventsForChanges()) {
/* 553 */         this._events.post(IDealDocumentXref.REMOVE_DEALS, argDeal);
/*     */       }
/*     */     } 
/*     */   }
/*     */   
/*     */   @Relationship(name = "DocDefinitions")
/*     */   public List<IDocumentDefinition> getDocDefinitions() {
/* 560 */     if (this._docDefinitions == null) {
/* 561 */       this._docDefinitions = new HistoricalList(null);
/*     */     }
/* 563 */     return (List<IDocumentDefinition>)this._docDefinitions;
/*     */   }
/*     */   
/*     */   public void setDocDefinitions(List<IDocumentDefinition> argDocDefinitions) {
/* 567 */     if (this._docDefinitions == null) {
/* 568 */       this._docDefinitions = new HistoricalList(argDocDefinitions);
/*     */     } else {
/* 570 */       this._docDefinitions.setCurrentList(argDocDefinitions);
/*     */     } 
/*     */     
/* 573 */     for (IDocumentDefinition child : this._docDefinitions) {
/* 574 */       DocumentDefinitionModel model = (DocumentDefinitionModel)child;
/* 575 */       model.setOrganizationId_noev(getOrganizationId());
/* 576 */       model.setSeriesId_noev(getSeriesId());
/* 577 */       model.setDocumentType_noev(getDocumentType());
/* 578 */       if (child instanceof IDataModelImpl) {
/* 579 */         IDataAccessObject childDao = ((IDataModelImpl)child).getDAO();
/* 580 */         if (StringUtils.isEmpty(childDao.getOriginDataSource()) && 
/* 581 */           !StringUtils.isEmpty(getDAO().getOriginDataSource())) {
/* 582 */           childDao.setOriginDataSource(getDAO().getOriginDataSource());
/*     */         }
/*     */       } 
/* 585 */       if (postEventsForChanges()) {
/* 586 */         this._eventManager.registerEventHandler((IEventAware)this._eventCascade, (IEventSource)child);
/*     */       }
/*     */     } 
/*     */   }
/*     */   
/*     */   public void addDocumentDefinition(IDocumentDefinition argDocumentDefinition) {
/* 592 */     if (this._docDefinitions == null) {
/* 593 */       this._docDefinitions = new HistoricalList(null);
/*     */     }
/* 595 */     argDocumentDefinition.setOrganizationId(getOrganizationId());
/* 596 */     argDocumentDefinition.setSeriesId(getSeriesId());
/* 597 */     argDocumentDefinition.setDocumentType(getDocumentType());
/* 598 */     if (argDocumentDefinition instanceof IDataModelImpl) {
/* 599 */       IDataAccessObject childDao = ((IDataModelImpl)argDocumentDefinition).getDAO();
/* 600 */       if (StringUtils.isEmpty(childDao.getOriginDataSource()) && 
/* 601 */         !StringUtils.isEmpty(getDAO().getOriginDataSource())) {
/* 602 */         childDao.setOriginDataSource(getDAO().getOriginDataSource());
/*     */       }
/*     */     } 
/*     */ 
/*     */     
/* 607 */     if (postEventsForChanges()) {
/* 608 */       this._eventManager.registerEventHandler((IEventAware)this._eventCascade, (IEventSource)new EventDescriptor(argDocumentDefinition));
/*     */     }
/*     */     
/* 611 */     this._docDefinitions.add(argDocumentDefinition);
/* 612 */     if (postEventsForChanges()) {
/* 613 */       this._events.post(IDealDocumentXref.ADD_DOCDEFINITIONS, argDocumentDefinition);
/*     */     }
/*     */   }
/*     */   
/*     */   public void removeDocumentDefinition(IDocumentDefinition argDocumentDefinition) {
/* 618 */     if (this._docDefinitions != null) {
/*     */       
/* 620 */       if (postEventsForChanges()) {
/* 621 */         this._eventManager.deregisterEventHandler((IEventAware)this._eventCascade, (IEventSource)new EventDescriptor(argDocumentDefinition));
/*     */       }
/* 623 */       this._docDefinitions.remove(argDocumentDefinition);
/* 624 */       if (postEventsForChanges()) {
/* 625 */         this._events.post(IDealDocumentXref.REMOVE_DOCDEFINITIONS, argDocumentDefinition);
/*     */       }
/*     */     } 
/*     */   }
/*     */   
/*     */   @Relationship(name = "Properties")
/*     */   public List<IDealDocumentXrefProperty> getProperties() {
/* 632 */     if (this._properties == null) {
/* 633 */       this._properties = new HistoricalList(null);
/*     */     }
/* 635 */     return (List<IDealDocumentXrefProperty>)this._properties;
/*     */   }
/*     */   
/*     */   public void setProperties(List<IDealDocumentXrefProperty> argProperties) {
/* 639 */     if (this._properties == null) {
/* 640 */       this._properties = new HistoricalList(argProperties);
/*     */     } else {
/* 642 */       this._properties.setCurrentList(argProperties);
/*     */     } 
/*     */     
/* 645 */     for (IDealDocumentXrefProperty child : this._properties) {
/* 646 */       DealDocumentXrefPropertyModel model = (DealDocumentXrefPropertyModel)child;
/* 647 */       model.setOrganizationId_noev(getOrganizationId());
/* 648 */       model.setDealId_noev(getDealId());
/* 649 */       model.setSeriesId_noev(getSeriesId());
/* 650 */       model.setDocumentType_noev(getDocumentType());
/* 651 */       if (child instanceof IDataModelImpl) {
/* 652 */         IDataAccessObject childDao = ((IDataModelImpl)child).getDAO();
/* 653 */         if (StringUtils.isEmpty(childDao.getOriginDataSource()) && 
/* 654 */           !StringUtils.isEmpty(getDAO().getOriginDataSource())) {
/* 655 */           childDao.setOriginDataSource(getDAO().getOriginDataSource());
/*     */         }
/*     */       } 
/* 658 */       if (postEventsForChanges()) {
/* 659 */         this._eventManager.registerEventHandler((IEventAware)this._eventCascade, (IEventSource)child);
/*     */       }
/*     */     } 
/*     */   }
/*     */   
/*     */   public void addDealDocumentXrefProperty(IDealDocumentXrefProperty argDealDocumentXrefProperty) {
/* 665 */     if (this._properties == null) {
/* 666 */       this._properties = new HistoricalList(null);
/*     */     }
/* 668 */     argDealDocumentXrefProperty.setOrganizationId(getOrganizationId());
/* 669 */     argDealDocumentXrefProperty.setDealId(getDealId());
/* 670 */     argDealDocumentXrefProperty.setSeriesId(getSeriesId());
/* 671 */     argDealDocumentXrefProperty.setDocumentType(getDocumentType());
/* 672 */     if (argDealDocumentXrefProperty instanceof IDataModelImpl) {
/* 673 */       IDataAccessObject childDao = ((IDataModelImpl)argDealDocumentXrefProperty).getDAO();
/* 674 */       if (StringUtils.isEmpty(childDao.getOriginDataSource()) && 
/* 675 */         !StringUtils.isEmpty(getDAO().getOriginDataSource())) {
/* 676 */         childDao.setOriginDataSource(getDAO().getOriginDataSource());
/*     */       }
/*     */     } 
/*     */ 
/*     */     
/* 681 */     if (postEventsForChanges()) {
/* 682 */       this._eventManager.registerEventHandler((IEventAware)this._eventCascade, (IEventSource)new EventDescriptor(argDealDocumentXrefProperty));
/*     */     }
/*     */     
/* 685 */     this._properties.add(argDealDocumentXrefProperty);
/* 686 */     if (postEventsForChanges()) {
/* 687 */       this._events.post(IDealDocumentXref.ADD_PROPERTIES, argDealDocumentXrefProperty);
/*     */     }
/*     */   }
/*     */   
/*     */   public void removeDealDocumentXrefProperty(IDealDocumentXrefProperty argDealDocumentXrefProperty) {
/* 692 */     if (this._properties != null) {
/*     */       
/* 694 */       if (postEventsForChanges()) {
/* 695 */         this._eventManager.deregisterEventHandler((IEventAware)this._eventCascade, (IEventSource)new EventDescriptor(argDealDocumentXrefProperty));
/*     */       }
/* 697 */       this._properties.remove(argDealDocumentXrefProperty);
/* 698 */       if (postEventsForChanges()) {
/* 699 */         this._events.post(IDealDocumentXref.REMOVE_PROPERTIES, argDealDocumentXrefProperty);
/*     */       }
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public Object getValue(String argFieldId) {
/* 706 */     if ("Deals".equals(argFieldId)) {
/* 707 */       return getDeals();
/*     */     }
/* 709 */     if ("DocDefinitions".equals(argFieldId)) {
/* 710 */       return getDocDefinitions();
/*     */     }
/* 712 */     if ("Properties".equals(argFieldId)) {
/* 713 */       return getProperties();
/*     */     }
/* 715 */     if ("DealDocumentXrefExtension".equals(argFieldId)) {
/* 716 */       return this._myExtension;
/*     */     }
/*     */     
/* 719 */     return super.getValue(argFieldId);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void setValue(String argFieldId, Object argValue) {
/* 725 */     if ("Deals".equals(argFieldId)) {
/* 726 */       setDeals(changeToList(argValue, IDeal.class));
/*     */     }
/* 728 */     else if ("DocDefinitions".equals(argFieldId)) {
/* 729 */       setDocDefinitions(changeToList(argValue, IDocumentDefinition.class));
/*     */     }
/* 731 */     else if ("Properties".equals(argFieldId)) {
/* 732 */       setProperties(changeToList(argValue, IDealDocumentXrefProperty.class));
/*     */     }
/* 734 */     else if ("DealDocumentXrefExtension".equals(argFieldId)) {
/* 735 */       this._myExtension = (IDataModel)argValue;
/*     */     } else {
/*     */       
/* 738 */       super.setValue(argFieldId, argValue);
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public void setDependencies(IPersistenceDefaults argPD, EventManager argEM) {
/* 744 */     this._persistenceDefaults = argPD;
/* 745 */     this._daoImpl.setPersistenceDefaults(argPD);
/* 746 */     this._eventManager = argEM;
/* 747 */     this._events = (Eventor)new ModelEventor((IDataModel)this, argEM);
/* 748 */     this._eventCascade = (EventHandler)new CascadingHandler(this);
/* 749 */     if (this._deals != null) {
/* 750 */       for (IDeal relationship : this._deals) {
/* 751 */         ((IDataModelImpl)relationship).setDependencies(argPD, argEM);
/*     */       }
/*     */     }
/* 754 */     if (this._docDefinitions != null) {
/* 755 */       for (IDocumentDefinition relationship : this._docDefinitions) {
/* 756 */         ((IDataModelImpl)relationship).setDependencies(argPD, argEM);
/*     */       }
/*     */     }
/* 759 */     if (this._properties != null) {
/* 760 */       for (IDealDocumentXrefProperty relationship : this._properties) {
/* 761 */         ((IDataModelImpl)relationship).setDependencies(argPD, argEM);
/*     */       }
/*     */     }
/*     */   }
/*     */   
/*     */   public IDataModel getDealDocumentXrefExt() {
/* 767 */     return this._myExtension;
/*     */   }
/*     */   
/*     */   public void setDealDocumentXrefExt(IDataModel argExt) {
/* 771 */     this._myExtension = argExt;
/*     */   }
/*     */ 
/*     */   
/*     */   public void startTransaction() {
/* 776 */     if (this._alreadyInStart) {
/*     */       return;
/*     */     }
/*     */     
/* 780 */     this._alreadyInStart = true;
/*     */ 
/*     */     
/* 783 */     super.startTransaction();
/*     */     
/* 785 */     this._dealsSavepoint = this._deals;
/* 786 */     if (this._deals != null) {
/* 787 */       this._dealsSavepoint = new HistoricalList((List)this._deals);
/* 788 */       Iterator<IDataModel> it = this._deals.iterator();
/* 789 */       while (it.hasNext()) {
/* 790 */         ((IDataModel)it.next()).startTransaction();
/*     */       }
/*     */     } 
/*     */     
/* 794 */     this._docDefinitionsSavepoint = this._docDefinitions;
/* 795 */     if (this._docDefinitions != null) {
/* 796 */       this._docDefinitionsSavepoint = new HistoricalList((List)this._docDefinitions);
/* 797 */       Iterator<IDataModel> it = this._docDefinitions.iterator();
/* 798 */       while (it.hasNext()) {
/* 799 */         ((IDataModel)it.next()).startTransaction();
/*     */       }
/*     */     } 
/*     */     
/* 803 */     this._propertiesSavepoint = this._properties;
/* 804 */     if (this._properties != null) {
/* 805 */       this._propertiesSavepoint = new HistoricalList((List)this._properties);
/* 806 */       Iterator<IDataModel> it = this._properties.iterator();
/* 807 */       while (it.hasNext()) {
/* 808 */         ((IDataModel)it.next()).startTransaction();
/*     */       }
/*     */     } 
/*     */ 
/*     */     
/* 813 */     this._alreadyInStart = false;
/*     */   }
/*     */ 
/*     */   
/*     */   public void rollbackChanges() {
/* 818 */     if (isAlreadyRolledBack()) {
/*     */       return;
/*     */     }
/* 821 */     super.rollbackChanges();
/*     */     
/* 823 */     this._deals = this._dealsSavepoint;
/* 824 */     this._dealsSavepoint = null;
/* 825 */     if (this._deals != null) {
/* 826 */       Iterator<IDataModel> it = this._deals.iterator();
/* 827 */       while (it.hasNext()) {
/* 828 */         ((IDataModel)it.next()).rollbackChanges();
/*     */       }
/*     */     } 
/*     */     
/* 832 */     this._docDefinitions = this._docDefinitionsSavepoint;
/* 833 */     this._docDefinitionsSavepoint = null;
/* 834 */     if (this._docDefinitions != null) {
/* 835 */       Iterator<IDataModel> it = this._docDefinitions.iterator();
/* 836 */       while (it.hasNext()) {
/* 837 */         ((IDataModel)it.next()).rollbackChanges();
/*     */       }
/*     */     } 
/*     */     
/* 841 */     this._properties = this._propertiesSavepoint;
/* 842 */     this._propertiesSavepoint = null;
/* 843 */     if (this._properties != null) {
/* 844 */       Iterator<IDataModel> it = this._properties.iterator();
/* 845 */       while (it.hasNext()) {
/* 846 */         ((IDataModel)it.next()).rollbackChanges();
/*     */       }
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void commitTransaction() {
/* 854 */     if (this._alreadyInCommit) {
/*     */       return;
/*     */     }
/* 857 */     this._alreadyInCommit = true;
/*     */ 
/*     */     
/* 860 */     super.commitTransaction();
/*     */     
/* 862 */     this._dealsSavepoint = this._deals;
/* 863 */     if (this._deals != null) {
/* 864 */       Iterator<IDataModel> it = this._deals.iterator();
/* 865 */       while (it.hasNext()) {
/* 866 */         ((IDataModel)it.next()).commitTransaction();
/*     */       }
/* 868 */       this._deals = new HistoricalList((List)this._deals);
/*     */     } 
/*     */     
/* 871 */     this._docDefinitionsSavepoint = this._docDefinitions;
/* 872 */     if (this._docDefinitions != null) {
/* 873 */       Iterator<IDataModel> it = this._docDefinitions.iterator();
/* 874 */       while (it.hasNext()) {
/* 875 */         ((IDataModel)it.next()).commitTransaction();
/*     */       }
/* 877 */       this._docDefinitions = new HistoricalList((List)this._docDefinitions);
/*     */     } 
/*     */     
/* 880 */     this._propertiesSavepoint = this._properties;
/* 881 */     if (this._properties != null) {
/* 882 */       Iterator<IDataModel> it = this._properties.iterator();
/* 883 */       while (it.hasNext()) {
/* 884 */         ((IDataModel)it.next()).commitTransaction();
/*     */       }
/* 886 */       this._properties = new HistoricalList((List)this._properties);
/*     */     } 
/*     */ 
/*     */     
/* 890 */     this._alreadyInCommit = false;
/*     */   }
/*     */ 
/*     */   
/*     */   private void readObject(ObjectInputStream argStream) throws IOException, ClassNotFoundException {
/* 895 */     argStream.defaultReadObject();
/*     */   }
/*     */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\prc\impl\DealDocumentXrefModel.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */