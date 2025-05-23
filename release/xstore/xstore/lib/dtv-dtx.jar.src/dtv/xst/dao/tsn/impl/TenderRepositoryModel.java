/*     */ package dtv.xst.dao.tsn.impl;
/*     */ import dtv.data2.IPersistenceDefaults;
/*     */ import dtv.data2.access.DataFactory;
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
/*     */ import dtv.xst.dao.tsn.ITenderRepository;
/*     */ import dtv.xst.dao.tsn.ITenderRepositoryFloat;
/*     */ import dtv.xst.dao.tsn.ITenderRepositoryProperty;
/*     */ import dtv.xst.dao.tsn.ITenderRepositoryStatus;
/*     */ import dtv.xst.dao.tsn.TenderRepositoryPropertyId;
/*     */ import java.io.ObjectInputStream;
/*     */ import java.math.BigDecimal;
/*     */ import java.util.Date;
/*     */ import java.util.Iterator;
/*     */ import java.util.List;
/*     */ 
/*     */ public class TenderRepositoryModel extends AbstractDataModelWithPropertyImpl<ITenderRepositoryProperty> implements ITenderRepository {
/*     */   private static final long serialVersionUID = -235965090L;
/*     */   private transient boolean _alreadyInStart = false;
/*     */   private transient boolean _alreadyInCommit = false;
/*     */   private IDataModel _myExtension;
/*     */   private HistoricalList<ITenderRepositoryFloat> _tenderRepositoryFloat;
/*     */   
/*     */   public String toString() {
/*  34 */     return super.toString() + " Id: " + getObjectId();
/*     */   }
/*     */   private transient HistoricalList<ITenderRepositoryFloat> _tenderRepositoryFloatSavepoint; private ITenderRepositoryStatus _tenderRepositoryStatus; private transient ITenderRepositoryStatus _tenderRepositoryStatusSavepoint; private HistoricalList<ITenderRepositoryProperty> _properties; private transient HistoricalList<ITenderRepositoryProperty> _propertiesSavepoint;
/*     */   
/*     */   public void initDAO() {
/*  39 */     setDAO((IDataAccessObject)new TenderRepositoryDAO());
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private TenderRepositoryDAO getDAO_() {
/*  47 */     return (TenderRepositoryDAO)this._daoImpl;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public long getOrganizationId() {
/*  55 */     if (getDAO_().getOrganizationId() != null) {
/*  56 */       return getDAO_().getOrganizationId().longValue();
/*     */     }
/*     */     
/*  59 */     return 0L;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setOrganizationId(long argOrganizationId) {
/*  68 */     if (setOrganizationId_noev(argOrganizationId) && 
/*  69 */       this._events != null && 
/*  70 */       postEventsForChanges()) {
/*  71 */       this._events.post(ITenderRepository.SET_ORGANIZATIONID, Long.valueOf(argOrganizationId));
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setOrganizationId_noev(long argOrganizationId) {
/*  78 */     boolean ev_postable = false;
/*     */     
/*  80 */     if ((getDAO_().getOrganizationId() == null && Long.valueOf(argOrganizationId) != null) || (
/*  81 */       getDAO_().getOrganizationId() != null && !getDAO_().getOrganizationId().equals(Long.valueOf(argOrganizationId)))) {
/*  82 */       getDAO_().setOrganizationId(Long.valueOf(argOrganizationId));
/*  83 */       ev_postable = true;
/*  84 */       if (this._tenderRepositoryFloat != null) {
/*     */         
/*  86 */         Iterator<TenderRepositoryFloatModel> it = this._tenderRepositoryFloat.iterator();
/*  87 */         while (it.hasNext())
/*     */         {
/*  89 */           ((TenderRepositoryFloatModel)it.next()).setOrganizationId_noev(argOrganizationId);
/*     */         }
/*     */       } 
/*  92 */       if (this._properties != null) {
/*     */         
/*  94 */         Iterator<TenderRepositoryPropertyModel> it = this._properties.iterator();
/*  95 */         while (it.hasNext())
/*     */         {
/*  97 */           ((TenderRepositoryPropertyModel)it.next()).setOrganizationId_noev(argOrganizationId);
/*     */         }
/*     */       } 
/* 100 */       if (this._tenderRepositoryStatus != null)
/*     */       {
/*     */         
/* 103 */         ((TenderRepositoryStatusModel)this._tenderRepositoryStatus).setOrganizationId_noev(argOrganizationId);
/*     */       }
/*     */     } 
/*     */     
/* 107 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public long getRetailLocationId() {
/* 115 */     if (getDAO_().getRetailLocationId() != null) {
/* 116 */       return getDAO_().getRetailLocationId().longValue();
/*     */     }
/*     */     
/* 119 */     return 0L;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setRetailLocationId(long argRetailLocationId) {
/* 128 */     if (setRetailLocationId_noev(argRetailLocationId) && 
/* 129 */       this._events != null && 
/* 130 */       postEventsForChanges()) {
/* 131 */       this._events.post(ITenderRepository.SET_RETAILLOCATIONID, Long.valueOf(argRetailLocationId));
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setRetailLocationId_noev(long argRetailLocationId) {
/* 138 */     boolean ev_postable = false;
/*     */     
/* 140 */     if ((getDAO_().getRetailLocationId() == null && Long.valueOf(argRetailLocationId) != null) || (
/* 141 */       getDAO_().getRetailLocationId() != null && !getDAO_().getRetailLocationId().equals(Long.valueOf(argRetailLocationId)))) {
/* 142 */       getDAO_().setRetailLocationId(Long.valueOf(argRetailLocationId));
/* 143 */       ev_postable = true;
/* 144 */       if (this._tenderRepositoryFloat != null) {
/*     */         
/* 146 */         Iterator<TenderRepositoryFloatModel> it = this._tenderRepositoryFloat.iterator();
/* 147 */         while (it.hasNext())
/*     */         {
/* 149 */           ((TenderRepositoryFloatModel)it.next()).setRetailLocationId_noev(argRetailLocationId);
/*     */         }
/*     */       } 
/* 152 */       if (this._properties != null) {
/*     */         
/* 154 */         Iterator<TenderRepositoryPropertyModel> it = this._properties.iterator();
/* 155 */         while (it.hasNext())
/*     */         {
/* 157 */           ((TenderRepositoryPropertyModel)it.next()).setRetailLocationId_noev(argRetailLocationId);
/*     */         }
/*     */       } 
/* 160 */       if (this._tenderRepositoryStatus != null)
/*     */       {
/*     */         
/* 163 */         ((TenderRepositoryStatusModel)this._tenderRepositoryStatus).setRetailLocationId_noev(argRetailLocationId);
/*     */       }
/*     */     } 
/*     */     
/* 167 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getTenderRepositoryId() {
/* 175 */     return getDAO_().getTenderRepositoryId();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setTenderRepositoryId(String argTenderRepositoryId) {
/* 183 */     if (setTenderRepositoryId_noev(argTenderRepositoryId) && 
/* 184 */       this._events != null && 
/* 185 */       postEventsForChanges()) {
/* 186 */       this._events.post(ITenderRepository.SET_TENDERREPOSITORYID, argTenderRepositoryId);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setTenderRepositoryId_noev(String argTenderRepositoryId) {
/* 193 */     boolean ev_postable = false;
/*     */     
/* 195 */     if ((getDAO_().getTenderRepositoryId() == null && argTenderRepositoryId != null) || (
/* 196 */       getDAO_().getTenderRepositoryId() != null && !getDAO_().getTenderRepositoryId().equals(argTenderRepositoryId))) {
/* 197 */       getDAO_().setTenderRepositoryId(argTenderRepositoryId);
/* 198 */       ev_postable = true;
/* 199 */       if (this._tenderRepositoryFloat != null) {
/*     */         
/* 201 */         Iterator<TenderRepositoryFloatModel> it = this._tenderRepositoryFloat.iterator();
/* 202 */         while (it.hasNext())
/*     */         {
/* 204 */           ((TenderRepositoryFloatModel)it.next()).setTenderRepositoryId_noev(argTenderRepositoryId);
/*     */         }
/*     */       } 
/* 207 */       if (this._properties != null) {
/*     */         
/* 209 */         Iterator<TenderRepositoryPropertyModel> it = this._properties.iterator();
/* 210 */         while (it.hasNext())
/*     */         {
/* 212 */           ((TenderRepositoryPropertyModel)it.next()).setTenderRepositoryId_noev(argTenderRepositoryId);
/*     */         }
/*     */       } 
/* 215 */       if (this._tenderRepositoryStatus != null)
/*     */       {
/*     */         
/* 218 */         ((TenderRepositoryStatusModel)this._tenderRepositoryStatus).setTenderRepositoryId_noev(argTenderRepositoryId);
/*     */       }
/*     */     } 
/*     */     
/* 222 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Date getCreateDate() {
/* 230 */     return getDAO_().getCreateDate();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setCreateDate(Date argCreateDate) {
/* 238 */     if (setCreateDate_noev(argCreateDate) && 
/* 239 */       this._events != null && 
/* 240 */       postEventsForChanges()) {
/* 241 */       this._events.post(ITenderRepository.SET_CREATEDATE, argCreateDate);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setCreateDate_noev(Date argCreateDate) {
/* 248 */     boolean ev_postable = false;
/*     */     
/* 250 */     if ((getDAO_().getCreateDate() == null && argCreateDate != null) || (
/* 251 */       getDAO_().getCreateDate() != null && !getDAO_().getCreateDate().equals(argCreateDate))) {
/* 252 */       getDAO_().setCreateDate(argCreateDate);
/* 253 */       ev_postable = true;
/*     */     } 
/*     */     
/* 256 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getCreateUserId() {
/* 264 */     return getDAO_().getCreateUserId();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setCreateUserId(String argCreateUserId) {
/* 272 */     if (setCreateUserId_noev(argCreateUserId) && 
/* 273 */       this._events != null && 
/* 274 */       postEventsForChanges()) {
/* 275 */       this._events.post(ITenderRepository.SET_CREATEUSERID, argCreateUserId);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setCreateUserId_noev(String argCreateUserId) {
/* 282 */     boolean ev_postable = false;
/*     */     
/* 284 */     if ((getDAO_().getCreateUserId() == null && argCreateUserId != null) || (
/* 285 */       getDAO_().getCreateUserId() != null && !getDAO_().getCreateUserId().equals(argCreateUserId))) {
/* 286 */       getDAO_().setCreateUserId(argCreateUserId);
/* 287 */       ev_postable = true;
/*     */     } 
/*     */     
/* 290 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Date getUpdateDate() {
/* 298 */     return getDAO_().getUpdateDate();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setUpdateDate(Date argUpdateDate) {
/* 306 */     if (setUpdateDate_noev(argUpdateDate) && 
/* 307 */       this._events != null && 
/* 308 */       postEventsForChanges()) {
/* 309 */       this._events.post(ITenderRepository.SET_UPDATEDATE, argUpdateDate);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setUpdateDate_noev(Date argUpdateDate) {
/* 316 */     boolean ev_postable = false;
/*     */     
/* 318 */     if ((getDAO_().getUpdateDate() == null && argUpdateDate != null) || (
/* 319 */       getDAO_().getUpdateDate() != null && !getDAO_().getUpdateDate().equals(argUpdateDate))) {
/* 320 */       getDAO_().setUpdateDate(argUpdateDate);
/* 321 */       ev_postable = true;
/*     */     } 
/*     */     
/* 324 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getUpdateUserId() {
/* 332 */     return getDAO_().getUpdateUserId();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setUpdateUserId(String argUpdateUserId) {
/* 340 */     if (setUpdateUserId_noev(argUpdateUserId) && 
/* 341 */       this._events != null && 
/* 342 */       postEventsForChanges()) {
/* 343 */       this._events.post(ITenderRepository.SET_UPDATEUSERID, argUpdateUserId);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setUpdateUserId_noev(String argUpdateUserId) {
/* 350 */     boolean ev_postable = false;
/*     */     
/* 352 */     if ((getDAO_().getUpdateUserId() == null && argUpdateUserId != null) || (
/* 353 */       getDAO_().getUpdateUserId() != null && !getDAO_().getUpdateUserId().equals(argUpdateUserId))) {
/* 354 */       getDAO_().setUpdateUserId(argUpdateUserId);
/* 355 */       ev_postable = true;
/*     */     } 
/*     */     
/* 358 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getDescription() {
/* 366 */     return getDAO_().getDescription();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setDescription(String argDescription) {
/* 374 */     if (setDescription_noev(argDescription) && 
/* 375 */       this._events != null && 
/* 376 */       postEventsForChanges()) {
/* 377 */       this._events.post(ITenderRepository.SET_DESCRIPTION, argDescription);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setDescription_noev(String argDescription) {
/* 384 */     boolean ev_postable = false;
/*     */     
/* 386 */     if ((getDAO_().getDescription() == null && argDescription != null) || (
/* 387 */       getDAO_().getDescription() != null && !getDAO_().getDescription().equals(argDescription))) {
/* 388 */       getDAO_().setDescription(argDescription);
/* 389 */       ev_postable = true;
/*     */     } 
/*     */     
/* 392 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getName() {
/* 400 */     return getDAO_().getName();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setName(String argName) {
/* 408 */     if (setName_noev(argName) && 
/* 409 */       this._events != null && 
/* 410 */       postEventsForChanges()) {
/* 411 */       this._events.post(ITenderRepository.SET_NAME, argName);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setName_noev(String argName) {
/* 418 */     boolean ev_postable = false;
/*     */     
/* 420 */     if ((getDAO_().getName() == null && argName != null) || (
/* 421 */       getDAO_().getName() != null && !getDAO_().getName().equals(argName))) {
/* 422 */       getDAO_().setName(argName);
/* 423 */       ev_postable = true;
/*     */     } 
/*     */     
/* 426 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean getNotIssuable() {
/* 434 */     if (getDAO_().getNotIssuable() != null) {
/* 435 */       return getDAO_().getNotIssuable().booleanValue();
/*     */     }
/*     */     
/* 438 */     return false;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setNotIssuable(boolean argNotIssuable) {
/* 447 */     if (setNotIssuable_noev(argNotIssuable) && 
/* 448 */       this._events != null && 
/* 449 */       postEventsForChanges()) {
/* 450 */       this._events.post(ITenderRepository.SET_NOTISSUABLE, Boolean.valueOf(argNotIssuable));
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setNotIssuable_noev(boolean argNotIssuable) {
/* 457 */     boolean ev_postable = false;
/*     */     
/* 459 */     if ((getDAO_().getNotIssuable() == null && Boolean.valueOf(argNotIssuable) != null) || (
/* 460 */       getDAO_().getNotIssuable() != null && !getDAO_().getNotIssuable().equals(Boolean.valueOf(argNotIssuable)))) {
/* 461 */       getDAO_().setNotIssuable(Boolean.valueOf(argNotIssuable));
/* 462 */       ev_postable = true;
/*     */     } 
/*     */     
/* 465 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getTypeCode() {
/* 473 */     return getDAO_().getTypeCode();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setTypeCode(String argTypeCode) {
/* 481 */     if (setTypeCode_noev(argTypeCode) && 
/* 482 */       this._events != null && 
/* 483 */       postEventsForChanges()) {
/* 484 */       this._events.post(ITenderRepository.SET_TYPECODE, argTypeCode);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setTypeCode_noev(String argTypeCode) {
/* 491 */     boolean ev_postable = false;
/*     */     
/* 493 */     if ((getDAO_().getTypeCode() == null && argTypeCode != null) || (
/* 494 */       getDAO_().getTypeCode() != null && !getDAO_().getTypeCode().equals(argTypeCode))) {
/* 495 */       getDAO_().setTypeCode(argTypeCode);
/* 496 */       ev_postable = true;
/*     */     } 
/*     */     
/* 499 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public long getDefaultWorkstationId() {
/* 507 */     if (getDAO_().getDefaultWorkstationId() != null) {
/* 508 */       return getDAO_().getDefaultWorkstationId().longValue();
/*     */     }
/*     */     
/* 511 */     return 0L;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setDefaultWorkstationId(long argDefaultWorkstationId) {
/* 520 */     if (setDefaultWorkstationId_noev(argDefaultWorkstationId) && 
/* 521 */       this._events != null && 
/* 522 */       postEventsForChanges()) {
/* 523 */       this._events.post(ITenderRepository.SET_DEFAULTWORKSTATIONID, Long.valueOf(argDefaultWorkstationId));
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setDefaultWorkstationId_noev(long argDefaultWorkstationId) {
/* 530 */     boolean ev_postable = false;
/*     */     
/* 532 */     if ((getDAO_().getDefaultWorkstationId() == null && Long.valueOf(argDefaultWorkstationId) != null) || (
/* 533 */       getDAO_().getDefaultWorkstationId() != null && !getDAO_().getDefaultWorkstationId().equals(Long.valueOf(argDefaultWorkstationId)))) {
/* 534 */       getDAO_().setDefaultWorkstationId(Long.valueOf(argDefaultWorkstationId));
/* 535 */       ev_postable = true;
/*     */     } 
/*     */     
/* 538 */     return ev_postable;
/*     */   }
/*     */   
/*     */   protected ITenderRepositoryProperty newProperty(String argPropertyName) {
/* 542 */     TenderRepositoryPropertyId id = new TenderRepositoryPropertyId();
/*     */     
/* 544 */     id.setRetailLocationId(Long.valueOf(getRetailLocationId()));
/* 545 */     id.setTenderRepositoryId(getTenderRepositoryId());
/* 546 */     id.setPropertyCode(argPropertyName);
/*     */     
/* 548 */     ITenderRepositoryProperty prop = (ITenderRepositoryProperty)DataFactory.getInstance().createNewObject((IObjectId)id, ITenderRepositoryProperty.class);
/* 549 */     return prop;
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
/*     */   @Relationship(name = "TenderRepositoryFloat")
/*     */   public List<ITenderRepositoryFloat> getTenderRepositoryFloat() {
/* 564 */     if (this._tenderRepositoryFloat == null) {
/* 565 */       this._tenderRepositoryFloat = new HistoricalList(null);
/*     */     }
/* 567 */     return (List<ITenderRepositoryFloat>)this._tenderRepositoryFloat;
/*     */   }
/*     */   
/*     */   public void setTenderRepositoryFloat(List<ITenderRepositoryFloat> argTenderRepositoryFloat) {
/* 571 */     if (this._tenderRepositoryFloat == null) {
/* 572 */       this._tenderRepositoryFloat = new HistoricalList(argTenderRepositoryFloat);
/*     */     } else {
/* 574 */       this._tenderRepositoryFloat.setCurrentList(argTenderRepositoryFloat);
/*     */     } 
/*     */     
/* 577 */     for (ITenderRepositoryFloat child : this._tenderRepositoryFloat) {
/* 578 */       child.setParentTenderRepository(this);
/*     */     }
/*     */     
/* 581 */     for (ITenderRepositoryFloat child : this._tenderRepositoryFloat) {
/* 582 */       TenderRepositoryFloatModel model = (TenderRepositoryFloatModel)child;
/* 583 */       model.setOrganizationId_noev(getOrganizationId());
/* 584 */       model.setRetailLocationId_noev(getRetailLocationId());
/* 585 */       model.setTenderRepositoryId_noev(getTenderRepositoryId());
/* 586 */       if (child instanceof IDataModelImpl) {
/* 587 */         IDataAccessObject childDao = ((IDataModelImpl)child).getDAO();
/* 588 */         if (StringUtils.isEmpty(childDao.getOriginDataSource()) && 
/* 589 */           !StringUtils.isEmpty(getDAO().getOriginDataSource())) {
/* 590 */           childDao.setOriginDataSource(getDAO().getOriginDataSource());
/*     */         }
/*     */       } 
/* 593 */       if (postEventsForChanges()) {
/* 594 */         this._eventManager.registerEventHandler((IEventAware)this._eventCascade, (IEventSource)child);
/*     */       }
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public void addTenderRepositoryFloat(ITenderRepositoryFloat argTenderRepositoryFloat) {
/* 601 */     argTenderRepositoryFloat.setParentTenderRepository(this);
/* 602 */     if (this._tenderRepositoryFloat == null) {
/* 603 */       this._tenderRepositoryFloat = new HistoricalList(null);
/*     */     }
/* 605 */     argTenderRepositoryFloat.setOrganizationId(getOrganizationId());
/* 606 */     argTenderRepositoryFloat.setRetailLocationId(getRetailLocationId());
/* 607 */     argTenderRepositoryFloat.setTenderRepositoryId(getTenderRepositoryId());
/* 608 */     if (argTenderRepositoryFloat instanceof IDataModelImpl) {
/* 609 */       IDataAccessObject childDao = ((IDataModelImpl)argTenderRepositoryFloat).getDAO();
/* 610 */       if (StringUtils.isEmpty(childDao.getOriginDataSource()) && 
/* 611 */         !StringUtils.isEmpty(getDAO().getOriginDataSource())) {
/* 612 */         childDao.setOriginDataSource(getDAO().getOriginDataSource());
/*     */       }
/*     */     } 
/*     */ 
/*     */     
/* 617 */     if (postEventsForChanges()) {
/* 618 */       this._eventManager.registerEventHandler((IEventAware)this._eventCascade, (IEventSource)new EventDescriptor(argTenderRepositoryFloat));
/*     */     }
/*     */     
/* 621 */     this._tenderRepositoryFloat.add(argTenderRepositoryFloat);
/* 622 */     if (postEventsForChanges()) {
/* 623 */       this._events.post(ITenderRepository.ADD_TENDERREPOSITORYFLOAT, argTenderRepositoryFloat);
/*     */     }
/*     */   }
/*     */   
/*     */   public void removeTenderRepositoryFloat(ITenderRepositoryFloat argTenderRepositoryFloat) {
/* 628 */     if (this._tenderRepositoryFloat != null) {
/*     */       
/* 630 */       if (postEventsForChanges()) {
/* 631 */         this._eventManager.deregisterEventHandler((IEventAware)this._eventCascade, (IEventSource)new EventDescriptor(argTenderRepositoryFloat));
/*     */       }
/* 633 */       this._tenderRepositoryFloat.remove(argTenderRepositoryFloat);
/*     */       
/* 635 */       argTenderRepositoryFloat.setParentTenderRepository(null);
/* 636 */       if (postEventsForChanges()) {
/* 637 */         this._events.post(ITenderRepository.REMOVE_TENDERREPOSITORYFLOAT, argTenderRepositoryFloat);
/*     */       }
/*     */     } 
/*     */   }
/*     */   
/*     */   @Relationship(name = "TenderRepositoryStatus")
/*     */   protected ITenderRepositoryStatus getTenderRepositoryStatusImpl() {
/* 644 */     return this._tenderRepositoryStatus;
/*     */   }
/*     */ 
/*     */   
/*     */   public void setTenderRepositoryStatus(ITenderRepositoryStatus argTenderRepositoryStatus) {
/* 649 */     if (argTenderRepositoryStatus == null) {
/*     */       
/* 651 */       if (this._tenderRepositoryStatus != null) {
/* 652 */         throw new DtxException("An Attempt was made to break a ONE-ONE relationship that cannot be broken because all fields that define the relationship are primary keys on the parent data object.");
/*     */       }
/* 654 */       if (this._tenderRepositoryStatus != null) {
/*     */         
/* 656 */         if (postEventsForChanges()) {
/* 657 */           this._eventManager.deregisterEventHandler((IEventAware)this._eventCascade, (IEventSource)new EventDescriptor(this._tenderRepositoryStatus));
/*     */         }
/* 659 */         addDeletedObject((IDataModel)this._tenderRepositoryStatus);
/*     */       } 
/*     */     } else {
/*     */       
/* 663 */       argTenderRepositoryStatus.setOrganizationId(getOrganizationId());
/* 664 */       argTenderRepositoryStatus.setRetailLocationId(getRetailLocationId());
/* 665 */       argTenderRepositoryStatus.setTenderRepositoryId(getTenderRepositoryId());
/*     */ 
/*     */       
/* 668 */       if (postEventsForChanges()) {
/* 669 */         this._eventManager.registerEventHandler((IEventAware)this._eventCascade, (IEventSource)new EventDescriptor(argTenderRepositoryStatus));
/*     */       }
/*     */     } 
/*     */     
/* 673 */     this._tenderRepositoryStatus = argTenderRepositoryStatus;
/* 674 */     if (postEventsForChanges()) {
/* 675 */       this._events.post(ITenderRepository.SET_TENDERREPOSITORYSTATUS, argTenderRepositoryStatus);
/*     */     }
/*     */   }
/*     */   
/*     */   @Relationship(name = "Properties")
/*     */   public List<ITenderRepositoryProperty> getProperties() {
/* 681 */     if (this._properties == null) {
/* 682 */       this._properties = new HistoricalList(null);
/*     */     }
/* 684 */     return (List<ITenderRepositoryProperty>)this._properties;
/*     */   }
/*     */   
/*     */   public void setProperties(List<ITenderRepositoryProperty> argProperties) {
/* 688 */     if (this._properties == null) {
/* 689 */       this._properties = new HistoricalList(argProperties);
/*     */     } else {
/* 691 */       this._properties.setCurrentList(argProperties);
/*     */     } 
/*     */     
/* 694 */     for (ITenderRepositoryProperty child : this._properties) {
/* 695 */       TenderRepositoryPropertyModel model = (TenderRepositoryPropertyModel)child;
/* 696 */       model.setOrganizationId_noev(getOrganizationId());
/* 697 */       model.setRetailLocationId_noev(getRetailLocationId());
/* 698 */       model.setTenderRepositoryId_noev(getTenderRepositoryId());
/* 699 */       if (child instanceof IDataModelImpl) {
/* 700 */         IDataAccessObject childDao = ((IDataModelImpl)child).getDAO();
/* 701 */         if (StringUtils.isEmpty(childDao.getOriginDataSource()) && 
/* 702 */           !StringUtils.isEmpty(getDAO().getOriginDataSource())) {
/* 703 */           childDao.setOriginDataSource(getDAO().getOriginDataSource());
/*     */         }
/*     */       } 
/* 706 */       if (postEventsForChanges()) {
/* 707 */         this._eventManager.registerEventHandler((IEventAware)this._eventCascade, (IEventSource)child);
/*     */       }
/*     */     } 
/*     */   }
/*     */   
/*     */   public void addTenderRepositoryProperty(ITenderRepositoryProperty argTenderRepositoryProperty) {
/* 713 */     if (this._properties == null) {
/* 714 */       this._properties = new HistoricalList(null);
/*     */     }
/* 716 */     argTenderRepositoryProperty.setOrganizationId(getOrganizationId());
/* 717 */     argTenderRepositoryProperty.setRetailLocationId(getRetailLocationId());
/* 718 */     argTenderRepositoryProperty.setTenderRepositoryId(getTenderRepositoryId());
/* 719 */     if (argTenderRepositoryProperty instanceof IDataModelImpl) {
/* 720 */       IDataAccessObject childDao = ((IDataModelImpl)argTenderRepositoryProperty).getDAO();
/* 721 */       if (StringUtils.isEmpty(childDao.getOriginDataSource()) && 
/* 722 */         !StringUtils.isEmpty(getDAO().getOriginDataSource())) {
/* 723 */         childDao.setOriginDataSource(getDAO().getOriginDataSource());
/*     */       }
/*     */     } 
/*     */ 
/*     */     
/* 728 */     if (postEventsForChanges()) {
/* 729 */       this._eventManager.registerEventHandler((IEventAware)this._eventCascade, (IEventSource)new EventDescriptor(argTenderRepositoryProperty));
/*     */     }
/*     */     
/* 732 */     this._properties.add(argTenderRepositoryProperty);
/* 733 */     if (postEventsForChanges()) {
/* 734 */       this._events.post(ITenderRepository.ADD_PROPERTIES, argTenderRepositoryProperty);
/*     */     }
/*     */   }
/*     */   
/*     */   public void removeTenderRepositoryProperty(ITenderRepositoryProperty argTenderRepositoryProperty) {
/* 739 */     if (this._properties != null) {
/*     */       
/* 741 */       if (postEventsForChanges()) {
/* 742 */         this._eventManager.deregisterEventHandler((IEventAware)this._eventCascade, (IEventSource)new EventDescriptor(argTenderRepositoryProperty));
/*     */       }
/* 744 */       this._properties.remove(argTenderRepositoryProperty);
/* 745 */       if (postEventsForChanges()) {
/* 746 */         this._events.post(ITenderRepository.REMOVE_PROPERTIES, argTenderRepositoryProperty);
/*     */       }
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public Object getValue(String argFieldId) {
/* 753 */     if ("TenderRepositoryFloat".equals(argFieldId)) {
/* 754 */       return getTenderRepositoryFloat();
/*     */     }
/* 756 */     if ("TenderRepositoryStatus".equals(argFieldId)) {
/* 757 */       return getTenderRepositoryStatus();
/*     */     }
/* 759 */     if ("Properties".equals(argFieldId)) {
/* 760 */       return getProperties();
/*     */     }
/* 762 */     if ("TenderRepositoryExtension".equals(argFieldId)) {
/* 763 */       return this._myExtension;
/*     */     }
/*     */     
/* 766 */     return super.getValue(argFieldId);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void setValue(String argFieldId, Object argValue) {
/* 772 */     if ("TenderRepositoryFloat".equals(argFieldId)) {
/* 773 */       setTenderRepositoryFloat(changeToList(argValue, ITenderRepositoryFloat.class));
/*     */     }
/* 775 */     else if ("TenderRepositoryStatus".equals(argFieldId)) {
/* 776 */       setTenderRepositoryStatus((ITenderRepositoryStatus)argValue);
/*     */     }
/* 778 */     else if ("Properties".equals(argFieldId)) {
/* 779 */       setProperties(changeToList(argValue, ITenderRepositoryProperty.class));
/*     */     }
/* 781 */     else if ("TenderRepositoryExtension".equals(argFieldId)) {
/* 782 */       this._myExtension = (IDataModel)argValue;
/*     */     } else {
/*     */       
/* 785 */       super.setValue(argFieldId, argValue);
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public void setDependencies(IPersistenceDefaults argPD, EventManager argEM) {
/* 791 */     this._persistenceDefaults = argPD;
/* 792 */     this._daoImpl.setPersistenceDefaults(argPD);
/* 793 */     this._eventManager = argEM;
/* 794 */     this._events = (Eventor)new ModelEventor((IDataModel)this, argEM);
/* 795 */     this._eventCascade = (EventHandler)new CascadingHandler(this);
/* 796 */     if (this._tenderRepositoryFloat != null) {
/* 797 */       for (ITenderRepositoryFloat relationship : this._tenderRepositoryFloat) {
/* 798 */         ((IDataModelImpl)relationship).setDependencies(argPD, argEM);
/*     */       }
/*     */     }
/* 801 */     if (this._tenderRepositoryStatus != null) {
/* 802 */       ((IDataModelImpl)this._tenderRepositoryStatus).setDependencies(argPD, argEM);
/*     */     }
/* 804 */     if (this._properties != null) {
/* 805 */       for (ITenderRepositoryProperty relationship : this._properties) {
/* 806 */         ((IDataModelImpl)relationship).setDependencies(argPD, argEM);
/*     */       }
/*     */     }
/*     */   }
/*     */   
/*     */   public IDataModel getTenderRepositoryExt() {
/* 812 */     return this._myExtension;
/*     */   }
/*     */   
/*     */   public void setTenderRepositoryExt(IDataModel argExt) {
/* 816 */     this._myExtension = argExt;
/*     */   }
/*     */ 
/*     */   
/*     */   public void startTransaction() {
/* 821 */     if (this._alreadyInStart) {
/*     */       return;
/*     */     }
/*     */     
/* 825 */     this._alreadyInStart = true;
/*     */ 
/*     */     
/* 828 */     super.startTransaction();
/*     */     
/* 830 */     this._tenderRepositoryFloatSavepoint = this._tenderRepositoryFloat;
/* 831 */     if (this._tenderRepositoryFloat != null) {
/* 832 */       this._tenderRepositoryFloatSavepoint = new HistoricalList((List)this._tenderRepositoryFloat);
/* 833 */       Iterator<IDataModel> it = this._tenderRepositoryFloat.iterator();
/* 834 */       while (it.hasNext()) {
/* 835 */         ((IDataModel)it.next()).startTransaction();
/*     */       }
/*     */     } 
/*     */     
/* 839 */     this._tenderRepositoryStatusSavepoint = this._tenderRepositoryStatus;
/* 840 */     if (this._tenderRepositoryStatus != null) {
/* 841 */       this._tenderRepositoryStatus.startTransaction();
/*     */     }
/*     */     
/* 844 */     this._propertiesSavepoint = this._properties;
/* 845 */     if (this._properties != null) {
/* 846 */       this._propertiesSavepoint = new HistoricalList((List)this._properties);
/* 847 */       Iterator<IDataModel> it = this._properties.iterator();
/* 848 */       while (it.hasNext()) {
/* 849 */         ((IDataModel)it.next()).startTransaction();
/*     */       }
/*     */     } 
/*     */ 
/*     */     
/* 854 */     this._alreadyInStart = false;
/*     */   }
/*     */ 
/*     */   
/*     */   public void rollbackChanges() {
/* 859 */     if (isAlreadyRolledBack()) {
/*     */       return;
/*     */     }
/* 862 */     super.rollbackChanges();
/*     */     
/* 864 */     this._tenderRepositoryFloat = this._tenderRepositoryFloatSavepoint;
/* 865 */     this._tenderRepositoryFloatSavepoint = null;
/* 866 */     if (this._tenderRepositoryFloat != null) {
/* 867 */       Iterator<IDataModel> it = this._tenderRepositoryFloat.iterator();
/* 868 */       while (it.hasNext()) {
/* 869 */         ((IDataModel)it.next()).rollbackChanges();
/*     */       }
/*     */     } 
/*     */     
/* 873 */     this._tenderRepositoryStatus = this._tenderRepositoryStatusSavepoint;
/* 874 */     this._tenderRepositoryStatusSavepoint = null;
/* 875 */     if (this._tenderRepositoryStatus != null) {
/* 876 */       this._tenderRepositoryStatus.rollbackChanges();
/*     */     }
/*     */     
/* 879 */     this._properties = this._propertiesSavepoint;
/* 880 */     this._propertiesSavepoint = null;
/* 881 */     if (this._properties != null) {
/* 882 */       Iterator<IDataModel> it = this._properties.iterator();
/* 883 */       while (it.hasNext()) {
/* 884 */         ((IDataModel)it.next()).rollbackChanges();
/*     */       }
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void commitTransaction() {
/* 892 */     if (this._alreadyInCommit) {
/*     */       return;
/*     */     }
/* 895 */     this._alreadyInCommit = true;
/*     */ 
/*     */     
/* 898 */     super.commitTransaction();
/*     */     
/* 900 */     this._tenderRepositoryFloatSavepoint = this._tenderRepositoryFloat;
/* 901 */     if (this._tenderRepositoryFloat != null) {
/* 902 */       Iterator<IDataModel> it = this._tenderRepositoryFloat.iterator();
/* 903 */       while (it.hasNext()) {
/* 904 */         ((IDataModel)it.next()).commitTransaction();
/*     */       }
/* 906 */       this._tenderRepositoryFloat = new HistoricalList((List)this._tenderRepositoryFloat);
/*     */     } 
/*     */     
/* 909 */     this._tenderRepositoryStatusSavepoint = this._tenderRepositoryStatus;
/* 910 */     if (this._tenderRepositoryStatus != null) {
/* 911 */       this._tenderRepositoryStatus.commitTransaction();
/*     */     }
/*     */     
/* 914 */     this._propertiesSavepoint = this._properties;
/* 915 */     if (this._properties != null) {
/* 916 */       Iterator<IDataModel> it = this._properties.iterator();
/* 917 */       while (it.hasNext()) {
/* 918 */         ((IDataModel)it.next()).commitTransaction();
/*     */       }
/* 920 */       this._properties = new HistoricalList((List)this._properties);
/*     */     } 
/*     */ 
/*     */     
/* 924 */     this._alreadyInCommit = false;
/*     */   }
/*     */ 
/*     */   
/*     */   private void readObject(ObjectInputStream argStream) throws IOException, ClassNotFoundException {
/* 929 */     argStream.defaultReadObject();
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
/*     */ 
/*     */   
/*     */   public ITenderRepositoryStatus getTenderRepositoryStatus() {
/* 945 */     if (getTenderRepositoryStatusImpl() == null) {
/* 946 */       setTenderRepositoryStatus((ITenderRepositoryStatus)DataFactory.createObject(ITenderRepositoryStatus.class));
/*     */     }
/* 948 */     return getTenderRepositoryStatusImpl();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public ITenderRepositoryFloat getTenderRepositoryFloatForCurrency(String argCurrencyId) {
/* 957 */     List<ITenderRepositoryFloat> floats = getTenderRepositoryFloat();
/*     */     
/* 959 */     for (ITenderRepositoryFloat floatForCurrency : floats) {
/*     */       
/* 961 */       if (floatForCurrency.getCurrencyId().equals(argCurrencyId)) {
/* 962 */         return floatForCurrency;
/*     */       }
/*     */     } 
/*     */ 
/*     */ 
/*     */     
/* 968 */     ITenderRepositoryFloat defaultFloat = new TenderRepositoryFloatModel();
/* 969 */     defaultFloat.setDefaultCashFloat(BigDecimal.ZERO);
/* 970 */     defaultFloat.setLastClosingCashAmt(BigDecimal.ZERO);
/* 971 */     defaultFloat.setCurrencyId(argCurrencyId);
/* 972 */     addTenderRepositoryFloat(defaultFloat);
/* 973 */     return defaultFloat;
/*     */   }
/*     */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\tsn\impl\TenderRepositoryModel.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */