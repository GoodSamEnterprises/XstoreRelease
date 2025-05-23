/*     */ package dtv.xst.dao.tsn.impl;
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
/*     */ import dtv.xst.dao.tsn.ISession;
/*     */ import dtv.xst.dao.tsn.ISessionTender;
/*     */ import dtv.xst.dao.tsn.ISessionTenderProperty;
/*     */ import dtv.xst.dao.tsn.SessionTenderPropertyId;
/*     */ import java.io.IOException;
/*     */ import java.io.ObjectInputStream;
/*     */ import java.math.BigDecimal;
/*     */ import java.util.Date;
/*     */ import java.util.Iterator;
/*     */ import java.util.List;
/*     */ 
/*     */ public class SessionTenderModel extends AbstractDataModelWithPropertyImpl<ISessionTenderProperty> implements ISessionTender {
/*     */   private static final long serialVersionUID = 671533290L;
/*     */   private ISession _parentSession;
/*     */   private transient boolean _alreadyInStart = false;
/*     */   
/*     */   public String toString() {
/*  35 */     return super.toString() + " Id: " + getObjectId();
/*     */   }
/*     */   private transient boolean _alreadyInCommit = false; private IDataModel _myExtension; private HistoricalList<ISessionTenderProperty> _properties; private transient HistoricalList<ISessionTenderProperty> _propertiesSavepoint;
/*     */   
/*     */   public void initDAO() {
/*  40 */     setDAO((IDataAccessObject)new SessionTenderDAO());
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private SessionTenderDAO getDAO_() {
/*  48 */     return (SessionTenderDAO)this._daoImpl;
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
/*  72 */       this._events.post(ISessionTender.SET_ORGANIZATIONID, Long.valueOf(argOrganizationId));
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
/*  87 */         Iterator<SessionTenderPropertyModel> it = this._properties.iterator();
/*  88 */         while (it.hasNext())
/*     */         {
/*  90 */           ((SessionTenderPropertyModel)it.next()).setOrganizationId_noev(argOrganizationId);
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
/* 119 */       this._events.post(ISessionTender.SET_RETAILLOCATIONID, Long.valueOf(argRetailLocationId));
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
/* 134 */         Iterator<SessionTenderPropertyModel> it = this._properties.iterator();
/* 135 */         while (it.hasNext())
/*     */         {
/* 137 */           ((SessionTenderPropertyModel)it.next()).setRetailLocationId_noev(argRetailLocationId);
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
/* 166 */       this._events.post(ISessionTender.SET_SESSIONID, Long.valueOf(argSessionId));
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
/* 181 */         Iterator<SessionTenderPropertyModel> it = this._properties.iterator();
/* 182 */         while (it.hasNext())
/*     */         {
/* 184 */           ((SessionTenderPropertyModel)it.next()).setSessionId_noev(argSessionId);
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
/*     */   public String getTenderId() {
/* 197 */     return getDAO_().getTenderId();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setTenderId(String argTenderId) {
/* 205 */     if (setTenderId_noev(argTenderId) && 
/* 206 */       this._events != null && 
/* 207 */       postEventsForChanges()) {
/* 208 */       this._events.post(ISessionTender.SET_TENDERID, argTenderId);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setTenderId_noev(String argTenderId) {
/* 215 */     boolean ev_postable = false;
/*     */     
/* 217 */     if ((getDAO_().getTenderId() == null && argTenderId != null) || (
/* 218 */       getDAO_().getTenderId() != null && !getDAO_().getTenderId().equals(argTenderId))) {
/* 219 */       getDAO_().setTenderId(argTenderId);
/* 220 */       ev_postable = true;
/* 221 */       if (this._properties != null) {
/*     */         
/* 223 */         Iterator<SessionTenderPropertyModel> it = this._properties.iterator();
/* 224 */         while (it.hasNext())
/*     */         {
/* 226 */           ((SessionTenderPropertyModel)it.next()).setTenderId_noev(argTenderId);
/*     */         }
/*     */       } 
/*     */     } 
/*     */     
/* 231 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Date getCreateDate() {
/* 239 */     return getDAO_().getCreateDate();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setCreateDate(Date argCreateDate) {
/* 247 */     if (setCreateDate_noev(argCreateDate) && 
/* 248 */       this._events != null && 
/* 249 */       postEventsForChanges()) {
/* 250 */       this._events.post(ISessionTender.SET_CREATEDATE, argCreateDate);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setCreateDate_noev(Date argCreateDate) {
/* 257 */     boolean ev_postable = false;
/*     */     
/* 259 */     if ((getDAO_().getCreateDate() == null && argCreateDate != null) || (
/* 260 */       getDAO_().getCreateDate() != null && !getDAO_().getCreateDate().equals(argCreateDate))) {
/* 261 */       getDAO_().setCreateDate(argCreateDate);
/* 262 */       ev_postable = true;
/*     */     } 
/*     */     
/* 265 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getCreateUserId() {
/* 273 */     return getDAO_().getCreateUserId();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setCreateUserId(String argCreateUserId) {
/* 281 */     if (setCreateUserId_noev(argCreateUserId) && 
/* 282 */       this._events != null && 
/* 283 */       postEventsForChanges()) {
/* 284 */       this._events.post(ISessionTender.SET_CREATEUSERID, argCreateUserId);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setCreateUserId_noev(String argCreateUserId) {
/* 291 */     boolean ev_postable = false;
/*     */     
/* 293 */     if ((getDAO_().getCreateUserId() == null && argCreateUserId != null) || (
/* 294 */       getDAO_().getCreateUserId() != null && !getDAO_().getCreateUserId().equals(argCreateUserId))) {
/* 295 */       getDAO_().setCreateUserId(argCreateUserId);
/* 296 */       ev_postable = true;
/*     */     } 
/*     */     
/* 299 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Date getUpdateDate() {
/* 307 */     return getDAO_().getUpdateDate();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setUpdateDate(Date argUpdateDate) {
/* 315 */     if (setUpdateDate_noev(argUpdateDate) && 
/* 316 */       this._events != null && 
/* 317 */       postEventsForChanges()) {
/* 318 */       this._events.post(ISessionTender.SET_UPDATEDATE, argUpdateDate);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setUpdateDate_noev(Date argUpdateDate) {
/* 325 */     boolean ev_postable = false;
/*     */     
/* 327 */     if ((getDAO_().getUpdateDate() == null && argUpdateDate != null) || (
/* 328 */       getDAO_().getUpdateDate() != null && !getDAO_().getUpdateDate().equals(argUpdateDate))) {
/* 329 */       getDAO_().setUpdateDate(argUpdateDate);
/* 330 */       ev_postable = true;
/*     */     } 
/*     */     
/* 333 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getUpdateUserId() {
/* 341 */     return getDAO_().getUpdateUserId();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setUpdateUserId(String argUpdateUserId) {
/* 349 */     if (setUpdateUserId_noev(argUpdateUserId) && 
/* 350 */       this._events != null && 
/* 351 */       postEventsForChanges()) {
/* 352 */       this._events.post(ISessionTender.SET_UPDATEUSERID, argUpdateUserId);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setUpdateUserId_noev(String argUpdateUserId) {
/* 359 */     boolean ev_postable = false;
/*     */     
/* 361 */     if ((getDAO_().getUpdateUserId() == null && argUpdateUserId != null) || (
/* 362 */       getDAO_().getUpdateUserId() != null && !getDAO_().getUpdateUserId().equals(argUpdateUserId))) {
/* 363 */       getDAO_().setUpdateUserId(argUpdateUserId);
/* 364 */       ev_postable = true;
/*     */     } 
/*     */     
/* 367 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public BigDecimal getMediaAmount() {
/* 375 */     return getDAO_().getMediaAmount();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setMediaAmount(BigDecimal argMediaAmount) {
/* 383 */     if (setMediaAmount_noev(argMediaAmount) && 
/* 384 */       this._events != null && 
/* 385 */       postEventsForChanges()) {
/* 386 */       this._events.post(ISessionTender.SET_MEDIAAMOUNT, argMediaAmount);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setMediaAmount_noev(BigDecimal argMediaAmount) {
/* 393 */     boolean ev_postable = false;
/*     */     
/* 395 */     if ((getDAO_().getMediaAmount() == null && argMediaAmount != null) || (
/* 396 */       getDAO_().getMediaAmount() != null && !getDAO_().getMediaAmount().equals(argMediaAmount))) {
/* 397 */       getDAO_().setMediaAmount(argMediaAmount);
/* 398 */       ev_postable = true;
/*     */     } 
/*     */     
/* 401 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int getMediaCount() {
/* 409 */     if (getDAO_().getMediaCount() != null) {
/* 410 */       return getDAO_().getMediaCount().intValue();
/*     */     }
/*     */     
/* 413 */     return 0;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setMediaCount(int argMediaCount) {
/* 422 */     if (setMediaCount_noev(argMediaCount) && 
/* 423 */       this._events != null && 
/* 424 */       postEventsForChanges()) {
/* 425 */       this._events.post(ISessionTender.SET_MEDIACOUNT, Integer.valueOf(argMediaCount));
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setMediaCount_noev(int argMediaCount) {
/* 432 */     boolean ev_postable = false;
/*     */     
/* 434 */     if ((getDAO_().getMediaCount() == null && Integer.valueOf(argMediaCount) != null) || (
/* 435 */       getDAO_().getMediaCount() != null && !getDAO_().getMediaCount().equals(Integer.valueOf(argMediaCount)))) {
/* 436 */       getDAO_().setMediaCount(Integer.valueOf(argMediaCount));
/* 437 */       ev_postable = true;
/*     */     } 
/*     */     
/* 440 */     return ev_postable;
/*     */   }
/*     */   
/*     */   protected ISessionTenderProperty newProperty(String argPropertyName) {
/* 444 */     SessionTenderPropertyId id = new SessionTenderPropertyId();
/*     */     
/* 446 */     id.setRetailLocationId(Long.valueOf(getRetailLocationId()));
/* 447 */     id.setSessionId(Long.valueOf(getSessionId()));
/* 448 */     id.setTenderId(getTenderId());
/* 449 */     id.setPropertyCode(argPropertyName);
/*     */     
/* 451 */     ISessionTenderProperty prop = (ISessionTenderProperty)DataFactory.getInstance().createNewObject((IObjectId)id, ISessionTenderProperty.class);
/* 452 */     return prop;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @Relationship(name = "Properties")
/*     */   public List<ISessionTenderProperty> getProperties() {
/* 461 */     if (this._properties == null) {
/* 462 */       this._properties = new HistoricalList(null);
/*     */     }
/* 464 */     return (List<ISessionTenderProperty>)this._properties;
/*     */   }
/*     */   
/*     */   public void setProperties(List<ISessionTenderProperty> argProperties) {
/* 468 */     if (this._properties == null) {
/* 469 */       this._properties = new HistoricalList(argProperties);
/*     */     } else {
/* 471 */       this._properties.setCurrentList(argProperties);
/*     */     } 
/*     */     
/* 474 */     for (ISessionTenderProperty child : this._properties) {
/* 475 */       SessionTenderPropertyModel model = (SessionTenderPropertyModel)child;
/* 476 */       model.setOrganizationId_noev(getOrganizationId());
/* 477 */       model.setRetailLocationId_noev(getRetailLocationId());
/* 478 */       model.setSessionId_noev(getSessionId());
/* 479 */       model.setTenderId_noev(getTenderId());
/* 480 */       if (child instanceof IDataModelImpl) {
/* 481 */         IDataAccessObject childDao = ((IDataModelImpl)child).getDAO();
/* 482 */         if (StringUtils.isEmpty(childDao.getOriginDataSource()) && 
/* 483 */           !StringUtils.isEmpty(getDAO().getOriginDataSource())) {
/* 484 */           childDao.setOriginDataSource(getDAO().getOriginDataSource());
/*     */         }
/*     */       } 
/* 487 */       if (postEventsForChanges()) {
/* 488 */         this._eventManager.registerEventHandler((IEventAware)this._eventCascade, (IEventSource)child);
/*     */       }
/*     */     } 
/*     */   }
/*     */   
/*     */   public void addSessionTenderProperty(ISessionTenderProperty argSessionTenderProperty) {
/* 494 */     if (this._properties == null) {
/* 495 */       this._properties = new HistoricalList(null);
/*     */     }
/* 497 */     argSessionTenderProperty.setOrganizationId(getOrganizationId());
/* 498 */     argSessionTenderProperty.setRetailLocationId(getRetailLocationId());
/* 499 */     argSessionTenderProperty.setSessionId(getSessionId());
/* 500 */     argSessionTenderProperty.setTenderId(getTenderId());
/* 501 */     if (argSessionTenderProperty instanceof IDataModelImpl) {
/* 502 */       IDataAccessObject childDao = ((IDataModelImpl)argSessionTenderProperty).getDAO();
/* 503 */       if (StringUtils.isEmpty(childDao.getOriginDataSource()) && 
/* 504 */         !StringUtils.isEmpty(getDAO().getOriginDataSource())) {
/* 505 */         childDao.setOriginDataSource(getDAO().getOriginDataSource());
/*     */       }
/*     */     } 
/*     */ 
/*     */     
/* 510 */     if (postEventsForChanges()) {
/* 511 */       this._eventManager.registerEventHandler((IEventAware)this._eventCascade, (IEventSource)new EventDescriptor(argSessionTenderProperty));
/*     */     }
/*     */     
/* 514 */     this._properties.add(argSessionTenderProperty);
/* 515 */     if (postEventsForChanges()) {
/* 516 */       this._events.post(ISessionTender.ADD_PROPERTIES, argSessionTenderProperty);
/*     */     }
/*     */   }
/*     */   
/*     */   public void removeSessionTenderProperty(ISessionTenderProperty argSessionTenderProperty) {
/* 521 */     if (this._properties != null) {
/*     */       
/* 523 */       if (postEventsForChanges()) {
/* 524 */         this._eventManager.deregisterEventHandler((IEventAware)this._eventCascade, (IEventSource)new EventDescriptor(argSessionTenderProperty));
/*     */       }
/* 526 */       this._properties.remove(argSessionTenderProperty);
/* 527 */       if (postEventsForChanges()) {
/* 528 */         this._events.post(ISessionTender.REMOVE_PROPERTIES, argSessionTenderProperty);
/*     */       }
/*     */     } 
/*     */   }
/*     */   
/*     */   public void setParentSession(ISession argParentSession) {
/* 534 */     this._parentSession = argParentSession;
/*     */   }
/*     */   
/*     */   public ISession getParentSession() {
/* 538 */     return this._parentSession;
/*     */   }
/*     */ 
/*     */   
/*     */   public Object getValue(String argFieldId) {
/* 543 */     if ("Properties".equals(argFieldId)) {
/* 544 */       return getProperties();
/*     */     }
/* 546 */     if ("SessionTenderExtension".equals(argFieldId)) {
/* 547 */       return this._myExtension;
/*     */     }
/*     */     
/* 550 */     return super.getValue(argFieldId);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void setValue(String argFieldId, Object argValue) {
/* 556 */     if ("Properties".equals(argFieldId)) {
/* 557 */       setProperties(changeToList(argValue, ISessionTenderProperty.class));
/*     */     }
/* 559 */     else if ("SessionTenderExtension".equals(argFieldId)) {
/* 560 */       this._myExtension = (IDataModel)argValue;
/*     */     } else {
/*     */       
/* 563 */       super.setValue(argFieldId, argValue);
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public void setDependencies(IPersistenceDefaults argPD, EventManager argEM) {
/* 569 */     this._persistenceDefaults = argPD;
/* 570 */     this._daoImpl.setPersistenceDefaults(argPD);
/* 571 */     this._eventManager = argEM;
/* 572 */     this._events = (Eventor)new ModelEventor((IDataModel)this, argEM);
/* 573 */     this._eventCascade = (EventHandler)new CascadingHandler(this);
/* 574 */     if (this._properties != null) {
/* 575 */       for (ISessionTenderProperty relationship : this._properties) {
/* 576 */         ((IDataModelImpl)relationship).setDependencies(argPD, argEM);
/*     */       }
/*     */     }
/*     */   }
/*     */   
/*     */   public IDataModel getSessionTenderExt() {
/* 582 */     return this._myExtension;
/*     */   }
/*     */   
/*     */   public void setSessionTenderExt(IDataModel argExt) {
/* 586 */     this._myExtension = argExt;
/*     */   }
/*     */ 
/*     */   
/*     */   public void startTransaction() {
/* 591 */     if (this._alreadyInStart) {
/*     */       return;
/*     */     }
/*     */     
/* 595 */     this._alreadyInStart = true;
/*     */ 
/*     */     
/* 598 */     super.startTransaction();
/*     */     
/* 600 */     this._propertiesSavepoint = this._properties;
/* 601 */     if (this._properties != null) {
/* 602 */       this._propertiesSavepoint = new HistoricalList((List)this._properties);
/* 603 */       Iterator<IDataModel> it = this._properties.iterator();
/* 604 */       while (it.hasNext()) {
/* 605 */         ((IDataModel)it.next()).startTransaction();
/*     */       }
/*     */     } 
/*     */ 
/*     */     
/* 610 */     this._alreadyInStart = false;
/*     */   }
/*     */ 
/*     */   
/*     */   public void rollbackChanges() {
/* 615 */     if (isAlreadyRolledBack()) {
/*     */       return;
/*     */     }
/* 618 */     super.rollbackChanges();
/*     */     
/* 620 */     this._properties = this._propertiesSavepoint;
/* 621 */     this._propertiesSavepoint = null;
/* 622 */     if (this._properties != null) {
/* 623 */       Iterator<IDataModel> it = this._properties.iterator();
/* 624 */       while (it.hasNext()) {
/* 625 */         ((IDataModel)it.next()).rollbackChanges();
/*     */       }
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void commitTransaction() {
/* 633 */     if (this._alreadyInCommit) {
/*     */       return;
/*     */     }
/* 636 */     this._alreadyInCommit = true;
/*     */ 
/*     */     
/* 639 */     super.commitTransaction();
/*     */     
/* 641 */     this._propertiesSavepoint = this._properties;
/* 642 */     if (this._properties != null) {
/* 643 */       Iterator<IDataModel> it = this._properties.iterator();
/* 644 */       while (it.hasNext()) {
/* 645 */         ((IDataModel)it.next()).commitTransaction();
/*     */       }
/* 647 */       this._properties = new HistoricalList((List)this._properties);
/*     */     } 
/*     */     
/* 650 */     getDAO_().setInitMediaAmount(getMediaAmount());
/* 651 */     getDAO_().setInitMediaCount(Integer.valueOf(getMediaCount()));
/*     */ 
/*     */     
/* 654 */     this._alreadyInCommit = false;
/*     */   }
/*     */ 
/*     */   
/*     */   private void readObject(ObjectInputStream argStream) throws IOException, ClassNotFoundException {
/* 659 */     argStream.defaultReadObject();
/*     */   }
/*     */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\tsn\impl\SessionTenderModel.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */