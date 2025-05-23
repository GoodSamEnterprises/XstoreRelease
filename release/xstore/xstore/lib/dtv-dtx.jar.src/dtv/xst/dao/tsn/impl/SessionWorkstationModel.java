/*     */ package dtv.xst.dao.tsn.impl;
/*     */ import dtv.data2.IPersistenceDefaults;
/*     */ import dtv.data2.access.IDataAccessObject;
/*     */ import dtv.data2.access.IDataModel;
/*     */ import dtv.data2.access.IDataProperty;
/*     */ import dtv.data2.access.IObjectId;
/*     */ import dtv.data2.access.ModelEventor;
/*     */ import dtv.data2.access.impl.AbstractDataModelWithPropertyImpl;
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
/*     */ import dtv.xst.dao.tsn.ISession;
/*     */ import dtv.xst.dao.tsn.ISessionWorkstation;
/*     */ import dtv.xst.dao.tsn.ISessionWorkstationProperty;
/*     */ import dtv.xst.dao.tsn.SessionWorkstationPropertyId;
/*     */ import java.io.IOException;
/*     */ import java.io.ObjectInputStream;
/*     */ import java.util.Date;
/*     */ import java.util.Iterator;
/*     */ import java.util.List;
/*     */ 
/*     */ public class SessionWorkstationModel extends AbstractDataModelWithPropertyImpl<ISessionWorkstationProperty> implements ISessionWorkstation {
/*     */   private static final long serialVersionUID = 597220525L;
/*     */   private ISession _parentSession;
/*     */   private transient boolean _alreadyInStart = false;
/*     */   
/*     */   public String toString() {
/*  35 */     return super.toString() + " Id: " + getObjectId();
/*     */   }
/*     */   private transient boolean _alreadyInCommit = false; private IDataModel _myExtension; private HistoricalList<ISessionWorkstationProperty> _properties; private transient HistoricalList<ISessionWorkstationProperty> _propertiesSavepoint;
/*     */   
/*     */   public void initDAO() {
/*  40 */     setDAO((IDataAccessObject)new SessionWorkstationDAO());
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private SessionWorkstationDAO getDAO_() {
/*  48 */     return (SessionWorkstationDAO)this._daoImpl;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public long getOrganizationId() {
/*  56 */     if (getDAO_().getOrganizationId() != null) {
/*  57 */       return getDAO_().getOrganizationId().longValue();
/*     */     }
/*     */     
/*  60 */     return 0L;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setOrganizationId(long argOrganizationId) {
/*  69 */     if (setOrganizationId_noev(argOrganizationId) && 
/*  70 */       this._events != null && 
/*  71 */       postEventsForChanges()) {
/*  72 */       this._events.post(ISessionWorkstation.SET_ORGANIZATIONID, Long.valueOf(argOrganizationId));
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setOrganizationId_noev(long argOrganizationId) {
/*  79 */     boolean ev_postable = false;
/*     */     
/*  81 */     if ((getDAO_().getOrganizationId() == null && Long.valueOf(argOrganizationId) != null) || (
/*  82 */       getDAO_().getOrganizationId() != null && !getDAO_().getOrganizationId().equals(Long.valueOf(argOrganizationId)))) {
/*  83 */       getDAO_().setOrganizationId(Long.valueOf(argOrganizationId));
/*  84 */       ev_postable = true;
/*  85 */       if (this._properties != null) {
/*     */         
/*  87 */         Iterator<SessionWorkstationPropertyModel> it = this._properties.iterator();
/*  88 */         while (it.hasNext())
/*     */         {
/*  90 */           ((SessionWorkstationPropertyModel)it.next()).setOrganizationId_noev(argOrganizationId);
/*     */         }
/*     */       } 
/*     */     } 
/*     */     
/*  95 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public long getRetailLocationId() {
/* 103 */     if (getDAO_().getRetailLocationId() != null) {
/* 104 */       return getDAO_().getRetailLocationId().longValue();
/*     */     }
/*     */     
/* 107 */     return 0L;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setRetailLocationId(long argRetailLocationId) {
/* 116 */     if (setRetailLocationId_noev(argRetailLocationId) && 
/* 117 */       this._events != null && 
/* 118 */       postEventsForChanges()) {
/* 119 */       this._events.post(ISessionWorkstation.SET_RETAILLOCATIONID, Long.valueOf(argRetailLocationId));
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setRetailLocationId_noev(long argRetailLocationId) {
/* 126 */     boolean ev_postable = false;
/*     */     
/* 128 */     if ((getDAO_().getRetailLocationId() == null && Long.valueOf(argRetailLocationId) != null) || (
/* 129 */       getDAO_().getRetailLocationId() != null && !getDAO_().getRetailLocationId().equals(Long.valueOf(argRetailLocationId)))) {
/* 130 */       getDAO_().setRetailLocationId(Long.valueOf(argRetailLocationId));
/* 131 */       ev_postable = true;
/* 132 */       if (this._properties != null) {
/*     */         
/* 134 */         Iterator<SessionWorkstationPropertyModel> it = this._properties.iterator();
/* 135 */         while (it.hasNext())
/*     */         {
/* 137 */           ((SessionWorkstationPropertyModel)it.next()).setRetailLocationId_noev(argRetailLocationId);
/*     */         }
/*     */       } 
/*     */     } 
/*     */     
/* 142 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public long getSessionId() {
/* 150 */     if (getDAO_().getSessionId() != null) {
/* 151 */       return getDAO_().getSessionId().longValue();
/*     */     }
/*     */     
/* 154 */     return 0L;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setSessionId(long argSessionId) {
/* 163 */     if (setSessionId_noev(argSessionId) && 
/* 164 */       this._events != null && 
/* 165 */       postEventsForChanges()) {
/* 166 */       this._events.post(ISessionWorkstation.SET_SESSIONID, Long.valueOf(argSessionId));
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setSessionId_noev(long argSessionId) {
/* 173 */     boolean ev_postable = false;
/*     */     
/* 175 */     if ((getDAO_().getSessionId() == null && Long.valueOf(argSessionId) != null) || (
/* 176 */       getDAO_().getSessionId() != null && !getDAO_().getSessionId().equals(Long.valueOf(argSessionId)))) {
/* 177 */       getDAO_().setSessionId(Long.valueOf(argSessionId));
/* 178 */       ev_postable = true;
/* 179 */       if (this._properties != null) {
/*     */         
/* 181 */         Iterator<SessionWorkstationPropertyModel> it = this._properties.iterator();
/* 182 */         while (it.hasNext())
/*     */         {
/* 184 */           ((SessionWorkstationPropertyModel)it.next()).setSessionId_noev(argSessionId);
/*     */         }
/*     */       } 
/*     */     } 
/*     */     
/* 189 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int getSessionWorkstationSequenceNbr() {
/* 197 */     if (getDAO_().getSessionWorkstationSequenceNbr() != null) {
/* 198 */       return getDAO_().getSessionWorkstationSequenceNbr().intValue();
/*     */     }
/*     */     
/* 201 */     return 0;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setSessionWorkstationSequenceNbr(int argSessionWorkstationSequenceNbr) {
/* 210 */     if (setSessionWorkstationSequenceNbr_noev(argSessionWorkstationSequenceNbr) && 
/* 211 */       this._events != null && 
/* 212 */       postEventsForChanges()) {
/* 213 */       this._events.post(ISessionWorkstation.SET_SESSIONWORKSTATIONSEQUENCENBR, Integer.valueOf(argSessionWorkstationSequenceNbr));
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setSessionWorkstationSequenceNbr_noev(int argSessionWorkstationSequenceNbr) {
/* 220 */     boolean ev_postable = false;
/*     */     
/* 222 */     if ((getDAO_().getSessionWorkstationSequenceNbr() == null && Integer.valueOf(argSessionWorkstationSequenceNbr) != null) || (
/* 223 */       getDAO_().getSessionWorkstationSequenceNbr() != null && !getDAO_().getSessionWorkstationSequenceNbr().equals(Integer.valueOf(argSessionWorkstationSequenceNbr)))) {
/* 224 */       getDAO_().setSessionWorkstationSequenceNbr(Integer.valueOf(argSessionWorkstationSequenceNbr));
/* 225 */       ev_postable = true;
/* 226 */       if (this._properties != null) {
/*     */         
/* 228 */         Iterator<SessionWorkstationPropertyModel> it = this._properties.iterator();
/* 229 */         while (it.hasNext())
/*     */         {
/* 231 */           ((SessionWorkstationPropertyModel)it.next()).setSessionWorkstationSequenceNbr_noev(argSessionWorkstationSequenceNbr);
/*     */         }
/*     */       } 
/*     */     } 
/*     */     
/* 236 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Date getCreateDate() {
/* 244 */     return getDAO_().getCreateDate();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setCreateDate(Date argCreateDate) {
/* 252 */     if (setCreateDate_noev(argCreateDate) && 
/* 253 */       this._events != null && 
/* 254 */       postEventsForChanges()) {
/* 255 */       this._events.post(ISessionWorkstation.SET_CREATEDATE, argCreateDate);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setCreateDate_noev(Date argCreateDate) {
/* 262 */     boolean ev_postable = false;
/*     */     
/* 264 */     if ((getDAO_().getCreateDate() == null && argCreateDate != null) || (
/* 265 */       getDAO_().getCreateDate() != null && !getDAO_().getCreateDate().equals(argCreateDate))) {
/* 266 */       getDAO_().setCreateDate(argCreateDate);
/* 267 */       ev_postable = true;
/*     */     } 
/*     */     
/* 270 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getCreateUserId() {
/* 278 */     return getDAO_().getCreateUserId();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setCreateUserId(String argCreateUserId) {
/* 286 */     if (setCreateUserId_noev(argCreateUserId) && 
/* 287 */       this._events != null && 
/* 288 */       postEventsForChanges()) {
/* 289 */       this._events.post(ISessionWorkstation.SET_CREATEUSERID, argCreateUserId);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setCreateUserId_noev(String argCreateUserId) {
/* 296 */     boolean ev_postable = false;
/*     */     
/* 298 */     if ((getDAO_().getCreateUserId() == null && argCreateUserId != null) || (
/* 299 */       getDAO_().getCreateUserId() != null && !getDAO_().getCreateUserId().equals(argCreateUserId))) {
/* 300 */       getDAO_().setCreateUserId(argCreateUserId);
/* 301 */       ev_postable = true;
/*     */     } 
/*     */     
/* 304 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Date getUpdateDate() {
/* 312 */     return getDAO_().getUpdateDate();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setUpdateDate(Date argUpdateDate) {
/* 320 */     if (setUpdateDate_noev(argUpdateDate) && 
/* 321 */       this._events != null && 
/* 322 */       postEventsForChanges()) {
/* 323 */       this._events.post(ISessionWorkstation.SET_UPDATEDATE, argUpdateDate);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setUpdateDate_noev(Date argUpdateDate) {
/* 330 */     boolean ev_postable = false;
/*     */     
/* 332 */     if ((getDAO_().getUpdateDate() == null && argUpdateDate != null) || (
/* 333 */       getDAO_().getUpdateDate() != null && !getDAO_().getUpdateDate().equals(argUpdateDate))) {
/* 334 */       getDAO_().setUpdateDate(argUpdateDate);
/* 335 */       ev_postable = true;
/*     */     } 
/*     */     
/* 338 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getUpdateUserId() {
/* 346 */     return getDAO_().getUpdateUserId();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setUpdateUserId(String argUpdateUserId) {
/* 354 */     if (setUpdateUserId_noev(argUpdateUserId) && 
/* 355 */       this._events != null && 
/* 356 */       postEventsForChanges()) {
/* 357 */       this._events.post(ISessionWorkstation.SET_UPDATEUSERID, argUpdateUserId);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setUpdateUserId_noev(String argUpdateUserId) {
/* 364 */     boolean ev_postable = false;
/*     */     
/* 366 */     if ((getDAO_().getUpdateUserId() == null && argUpdateUserId != null) || (
/* 367 */       getDAO_().getUpdateUserId() != null && !getDAO_().getUpdateUserId().equals(argUpdateUserId))) {
/* 368 */       getDAO_().setUpdateUserId(argUpdateUserId);
/* 369 */       ev_postable = true;
/*     */     } 
/*     */     
/* 372 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Date getBeginDatetimestamp() {
/* 380 */     return getDAO_().getBeginDatetimestamp();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setBeginDatetimestamp(Date argBeginDatetimestamp) {
/* 388 */     if (setBeginDatetimestamp_noev(argBeginDatetimestamp) && 
/* 389 */       this._events != null && 
/* 390 */       postEventsForChanges()) {
/* 391 */       this._events.post(ISessionWorkstation.SET_BEGINDATETIMESTAMP, argBeginDatetimestamp);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setBeginDatetimestamp_noev(Date argBeginDatetimestamp) {
/* 398 */     boolean ev_postable = false;
/*     */     
/* 400 */     if ((getDAO_().getBeginDatetimestamp() == null && argBeginDatetimestamp != null) || (
/* 401 */       getDAO_().getBeginDatetimestamp() != null && !getDAO_().getBeginDatetimestamp().equals(argBeginDatetimestamp))) {
/* 402 */       getDAO_().setBeginDatetimestamp(argBeginDatetimestamp);
/* 403 */       ev_postable = true;
/*     */     } 
/*     */     
/* 406 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getCashDrawerId() {
/* 414 */     return getDAO_().getCashDrawerId();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setCashDrawerId(String argCashDrawerId) {
/* 422 */     if (setCashDrawerId_noev(argCashDrawerId) && 
/* 423 */       this._events != null && 
/* 424 */       postEventsForChanges()) {
/* 425 */       this._events.post(ISessionWorkstation.SET_CASHDRAWERID, argCashDrawerId);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setCashDrawerId_noev(String argCashDrawerId) {
/* 432 */     boolean ev_postable = false;
/*     */     
/* 434 */     if ((getDAO_().getCashDrawerId() == null && argCashDrawerId != null) || (
/* 435 */       getDAO_().getCashDrawerId() != null && !getDAO_().getCashDrawerId().equals(argCashDrawerId))) {
/* 436 */       getDAO_().setCashDrawerId(argCashDrawerId);
/* 437 */       ev_postable = true;
/*     */     } 
/*     */     
/* 440 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Date getEndDatetimestamp() {
/* 448 */     return getDAO_().getEndDatetimestamp();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setEndDatetimestamp(Date argEndDatetimestamp) {
/* 456 */     if (setEndDatetimestamp_noev(argEndDatetimestamp) && 
/* 457 */       this._events != null && 
/* 458 */       postEventsForChanges()) {
/* 459 */       this._events.post(ISessionWorkstation.SET_ENDDATETIMESTAMP, argEndDatetimestamp);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setEndDatetimestamp_noev(Date argEndDatetimestamp) {
/* 466 */     boolean ev_postable = false;
/*     */     
/* 468 */     if ((getDAO_().getEndDatetimestamp() == null && argEndDatetimestamp != null) || (
/* 469 */       getDAO_().getEndDatetimestamp() != null && !getDAO_().getEndDatetimestamp().equals(argEndDatetimestamp))) {
/* 470 */       getDAO_().setEndDatetimestamp(argEndDatetimestamp);
/* 471 */       ev_postable = true;
/*     */     } 
/*     */     
/* 474 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean getAttached() {
/* 482 */     if (getDAO_().getAttached() != null) {
/* 483 */       return getDAO_().getAttached().booleanValue();
/*     */     }
/*     */     
/* 486 */     return false;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setAttached(boolean argAttached) {
/* 495 */     if (setAttached_noev(argAttached) && 
/* 496 */       this._events != null && 
/* 497 */       postEventsForChanges()) {
/* 498 */       this._events.post(ISessionWorkstation.SET_ATTACHED, Boolean.valueOf(argAttached));
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setAttached_noev(boolean argAttached) {
/* 505 */     boolean ev_postable = false;
/*     */     
/* 507 */     if ((getDAO_().getAttached() == null && Boolean.valueOf(argAttached) != null) || (
/* 508 */       getDAO_().getAttached() != null && !getDAO_().getAttached().equals(Boolean.valueOf(argAttached)))) {
/* 509 */       getDAO_().setAttached(Boolean.valueOf(argAttached));
/* 510 */       ev_postable = true;
/*     */     } 
/*     */     
/* 513 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public long getWorkstationId() {
/* 521 */     if (getDAO_().getWorkstationId() != null) {
/* 522 */       return getDAO_().getWorkstationId().longValue();
/*     */     }
/*     */     
/* 525 */     return 0L;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setWorkstationId(long argWorkstationId) {
/* 534 */     if (setWorkstationId_noev(argWorkstationId) && 
/* 535 */       this._events != null && 
/* 536 */       postEventsForChanges()) {
/* 537 */       this._events.post(ISessionWorkstation.SET_WORKSTATIONID, Long.valueOf(argWorkstationId));
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setWorkstationId_noev(long argWorkstationId) {
/* 544 */     boolean ev_postable = false;
/*     */     
/* 546 */     if ((getDAO_().getWorkstationId() == null && Long.valueOf(argWorkstationId) != null) || (
/* 547 */       getDAO_().getWorkstationId() != null && !getDAO_().getWorkstationId().equals(Long.valueOf(argWorkstationId)))) {
/* 548 */       getDAO_().setWorkstationId(Long.valueOf(argWorkstationId));
/* 549 */       ev_postable = true;
/*     */     } 
/*     */     
/* 552 */     return ev_postable;
/*     */   }
/*     */   
/*     */   protected ISessionWorkstationProperty newProperty(String argPropertyName) {
/* 556 */     SessionWorkstationPropertyId id = new SessionWorkstationPropertyId();
/*     */     
/* 558 */     id.setRetailLocationId(Long.valueOf(getRetailLocationId()));
/* 559 */     id.setSessionId(Long.valueOf(getSessionId()));
/* 560 */     id.setSessionWorkstationSequenceNbr(Integer.valueOf(getSessionWorkstationSequenceNbr()));
/* 561 */     id.setPropertyCode(argPropertyName);
/*     */     
/* 563 */     ISessionWorkstationProperty prop = (ISessionWorkstationProperty)DataFactory.getInstance().createNewObject((IObjectId)id, ISessionWorkstationProperty.class);
/* 564 */     return prop;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @Relationship(name = "Properties")
/*     */   public List<ISessionWorkstationProperty> getProperties() {
/* 573 */     if (this._properties == null) {
/* 574 */       this._properties = new HistoricalList(null);
/*     */     }
/* 576 */     return (List<ISessionWorkstationProperty>)this._properties;
/*     */   }
/*     */   
/*     */   public void setProperties(List<ISessionWorkstationProperty> argProperties) {
/* 580 */     if (this._properties == null) {
/* 581 */       this._properties = new HistoricalList(argProperties);
/*     */     } else {
/* 583 */       this._properties.setCurrentList(argProperties);
/*     */     } 
/*     */     
/* 586 */     for (ISessionWorkstationProperty child : this._properties) {
/* 587 */       SessionWorkstationPropertyModel model = (SessionWorkstationPropertyModel)child;
/* 588 */       model.setOrganizationId_noev(getOrganizationId());
/* 589 */       model.setRetailLocationId_noev(getRetailLocationId());
/* 590 */       model.setSessionId_noev(getSessionId());
/* 591 */       model.setSessionWorkstationSequenceNbr_noev(getSessionWorkstationSequenceNbr());
/* 592 */       if (child instanceof IDataModelImpl) {
/* 593 */         IDataAccessObject childDao = ((IDataModelImpl)child).getDAO();
/* 594 */         if (StringUtils.isEmpty(childDao.getOriginDataSource()) && 
/* 595 */           !StringUtils.isEmpty(getDAO().getOriginDataSource())) {
/* 596 */           childDao.setOriginDataSource(getDAO().getOriginDataSource());
/*     */         }
/*     */       } 
/* 599 */       if (postEventsForChanges()) {
/* 600 */         this._eventManager.registerEventHandler((IEventAware)this._eventCascade, (IEventSource)child);
/*     */       }
/*     */     } 
/*     */   }
/*     */   
/*     */   public void addSessionWorkstationProperty(ISessionWorkstationProperty argSessionWorkstationProperty) {
/* 606 */     if (this._properties == null) {
/* 607 */       this._properties = new HistoricalList(null);
/*     */     }
/* 609 */     argSessionWorkstationProperty.setOrganizationId(getOrganizationId());
/* 610 */     argSessionWorkstationProperty.setRetailLocationId(getRetailLocationId());
/* 611 */     argSessionWorkstationProperty.setSessionId(getSessionId());
/* 612 */     argSessionWorkstationProperty.setSessionWorkstationSequenceNbr(getSessionWorkstationSequenceNbr());
/* 613 */     if (argSessionWorkstationProperty instanceof IDataModelImpl) {
/* 614 */       IDataAccessObject childDao = ((IDataModelImpl)argSessionWorkstationProperty).getDAO();
/* 615 */       if (StringUtils.isEmpty(childDao.getOriginDataSource()) && 
/* 616 */         !StringUtils.isEmpty(getDAO().getOriginDataSource())) {
/* 617 */         childDao.setOriginDataSource(getDAO().getOriginDataSource());
/*     */       }
/*     */     } 
/*     */ 
/*     */     
/* 622 */     if (postEventsForChanges()) {
/* 623 */       this._eventManager.registerEventHandler((IEventAware)this._eventCascade, (IEventSource)new EventDescriptor(argSessionWorkstationProperty));
/*     */     }
/*     */     
/* 626 */     this._properties.add(argSessionWorkstationProperty);
/* 627 */     if (postEventsForChanges()) {
/* 628 */       this._events.post(ISessionWorkstation.ADD_PROPERTIES, argSessionWorkstationProperty);
/*     */     }
/*     */   }
/*     */   
/*     */   public void removeSessionWorkstationProperty(ISessionWorkstationProperty argSessionWorkstationProperty) {
/* 633 */     if (this._properties != null) {
/*     */       
/* 635 */       if (postEventsForChanges()) {
/* 636 */         this._eventManager.deregisterEventHandler((IEventAware)this._eventCascade, (IEventSource)new EventDescriptor(argSessionWorkstationProperty));
/*     */       }
/* 638 */       this._properties.remove(argSessionWorkstationProperty);
/* 639 */       if (postEventsForChanges()) {
/* 640 */         this._events.post(ISessionWorkstation.REMOVE_PROPERTIES, argSessionWorkstationProperty);
/*     */       }
/*     */     } 
/*     */   }
/*     */   
/*     */   public void setParentSession(ISession argParentSession) {
/* 646 */     this._parentSession = argParentSession;
/*     */   }
/*     */   
/*     */   public ISession getParentSession() {
/* 650 */     return this._parentSession;
/*     */   }
/*     */ 
/*     */   
/*     */   public Object getValue(String argFieldId) {
/* 655 */     if ("Properties".equals(argFieldId)) {
/* 656 */       return getProperties();
/*     */     }
/* 658 */     if ("SessionWorkstationExtension".equals(argFieldId)) {
/* 659 */       return this._myExtension;
/*     */     }
/*     */     
/* 662 */     return super.getValue(argFieldId);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void setValue(String argFieldId, Object argValue) {
/* 668 */     if ("Properties".equals(argFieldId)) {
/* 669 */       setProperties(changeToList(argValue, ISessionWorkstationProperty.class));
/*     */     }
/* 671 */     else if ("SessionWorkstationExtension".equals(argFieldId)) {
/* 672 */       this._myExtension = (IDataModel)argValue;
/*     */     } else {
/*     */       
/* 675 */       super.setValue(argFieldId, argValue);
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public void setDependencies(IPersistenceDefaults argPD, EventManager argEM) {
/* 681 */     this._persistenceDefaults = argPD;
/* 682 */     this._daoImpl.setPersistenceDefaults(argPD);
/* 683 */     this._eventManager = argEM;
/* 684 */     this._events = (Eventor)new ModelEventor((IDataModel)this, argEM);
/* 685 */     this._eventCascade = (EventHandler)new CascadingHandler(this);
/* 686 */     if (this._properties != null) {
/* 687 */       for (ISessionWorkstationProperty relationship : this._properties) {
/* 688 */         ((IDataModelImpl)relationship).setDependencies(argPD, argEM);
/*     */       }
/*     */     }
/*     */   }
/*     */   
/*     */   public IDataModel getSessionWorkstationExt() {
/* 694 */     return this._myExtension;
/*     */   }
/*     */   
/*     */   public void setSessionWorkstationExt(IDataModel argExt) {
/* 698 */     this._myExtension = argExt;
/*     */   }
/*     */ 
/*     */   
/*     */   public void startTransaction() {
/* 703 */     if (this._alreadyInStart) {
/*     */       return;
/*     */     }
/*     */     
/* 707 */     this._alreadyInStart = true;
/*     */ 
/*     */     
/* 710 */     super.startTransaction();
/*     */     
/* 712 */     this._propertiesSavepoint = this._properties;
/* 713 */     if (this._properties != null) {
/* 714 */       this._propertiesSavepoint = new HistoricalList((List)this._properties);
/* 715 */       Iterator<IDataModel> it = this._properties.iterator();
/* 716 */       while (it.hasNext()) {
/* 717 */         ((IDataModel)it.next()).startTransaction();
/*     */       }
/*     */     } 
/*     */ 
/*     */     
/* 722 */     this._alreadyInStart = false;
/*     */   }
/*     */ 
/*     */   
/*     */   public void rollbackChanges() {
/* 727 */     if (isAlreadyRolledBack()) {
/*     */       return;
/*     */     }
/* 730 */     super.rollbackChanges();
/*     */     
/* 732 */     this._properties = this._propertiesSavepoint;
/* 733 */     this._propertiesSavepoint = null;
/* 734 */     if (this._properties != null) {
/* 735 */       Iterator<IDataModel> it = this._properties.iterator();
/* 736 */       while (it.hasNext()) {
/* 737 */         ((IDataModel)it.next()).rollbackChanges();
/*     */       }
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void commitTransaction() {
/* 745 */     if (this._alreadyInCommit) {
/*     */       return;
/*     */     }
/* 748 */     this._alreadyInCommit = true;
/*     */ 
/*     */     
/* 751 */     super.commitTransaction();
/*     */     
/* 753 */     this._propertiesSavepoint = this._properties;
/* 754 */     if (this._properties != null) {
/* 755 */       Iterator<IDataModel> it = this._properties.iterator();
/* 756 */       while (it.hasNext()) {
/* 757 */         ((IDataModel)it.next()).commitTransaction();
/*     */       }
/* 759 */       this._properties = new HistoricalList((List)this._properties);
/*     */     } 
/*     */ 
/*     */     
/* 763 */     this._alreadyInCommit = false;
/*     */   }
/*     */ 
/*     */   
/*     */   private void readObject(ObjectInputStream argStream) throws IOException, ClassNotFoundException {
/* 768 */     argStream.defaultReadObject();
/*     */   }
/*     */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\tsn\impl\SessionWorkstationModel.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */