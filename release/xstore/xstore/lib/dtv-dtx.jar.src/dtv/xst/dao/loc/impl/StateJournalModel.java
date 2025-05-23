/*     */ package dtv.xst.dao.loc.impl;
/*     */ import dtv.data2.IPersistenceDefaults;
/*     */ import dtv.data2.access.IDataAccessObject;
/*     */ import dtv.data2.access.IDataModel;
/*     */ import dtv.data2.access.IDataProperty;
/*     */ import dtv.data2.access.IObjectId;
/*     */ import dtv.data2.access.ModelEventor;
/*     */ import dtv.data2.access.impl.IDataModelImpl;
/*     */ import dtv.event.EventDescriptor;
/*     */ import dtv.event.EventManager;
/*     */ import dtv.event.Eventor;
/*     */ import dtv.event.IEventAware;
/*     */ import dtv.event.IEventSource;
/*     */ import dtv.event.handler.CascadingHandler;
/*     */ import dtv.util.HistoricalList;
/*     */ import dtv.util.StringUtils;
/*     */ import dtv.xst.dao.loc.IStateJournal;
/*     */ import dtv.xst.dao.loc.IStateJournalProperty;
/*     */ import dtv.xst.dao.loc.StateJournalPropertyId;
/*     */ import java.io.IOException;
/*     */ import java.io.ObjectInputStream;
/*     */ import java.math.BigDecimal;
/*     */ import java.util.Date;
/*     */ import java.util.Iterator;
/*     */ import java.util.List;
/*     */ 
/*     */ public class StateJournalModel extends AbstractDataModelWithPropertyImpl<IStateJournalProperty> implements IStateJournal {
/*     */   private static final long serialVersionUID = -1081884282L;
/*     */   private transient boolean _alreadyInStart = false;
/*     */   private transient boolean _alreadyInCommit = false;
/*     */   
/*     */   public String toString() {
/*  33 */     return super.toString() + " Id: " + getObjectId();
/*     */   }
/*     */   private IDataModel _myExtension; private HistoricalList<IStateJournalProperty> _properties; private transient HistoricalList<IStateJournalProperty> _propertiesSavepoint;
/*     */   
/*     */   public void initDAO() {
/*  38 */     setDAO((IDataAccessObject)new StateJournalDAO());
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private StateJournalDAO getDAO_() {
/*  46 */     return (StateJournalDAO)this._daoImpl;
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
/*  70 */       this._events.post(IStateJournal.SET_ORGANIZATIONID, Long.valueOf(argOrganizationId));
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
/*  83 */       if (this._properties != null) {
/*     */         
/*  85 */         Iterator<StateJournalPropertyModel> it = this._properties.iterator();
/*  86 */         while (it.hasNext())
/*     */         {
/*  88 */           ((StateJournalPropertyModel)it.next()).setOrganizationId_noev(argOrganizationId);
/*     */         }
/*     */       } 
/*     */     } 
/*     */     
/*  93 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public long getRetailLocationId() {
/* 101 */     if (getDAO_().getRetailLocationId() != null) {
/* 102 */       return getDAO_().getRetailLocationId().longValue();
/*     */     }
/*     */     
/* 105 */     return 0L;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setRetailLocationId(long argRetailLocationId) {
/* 114 */     if (setRetailLocationId_noev(argRetailLocationId) && 
/* 115 */       this._events != null && 
/* 116 */       postEventsForChanges()) {
/* 117 */       this._events.post(IStateJournal.SET_RETAILLOCATIONID, Long.valueOf(argRetailLocationId));
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setRetailLocationId_noev(long argRetailLocationId) {
/* 124 */     boolean ev_postable = false;
/*     */     
/* 126 */     if ((getDAO_().getRetailLocationId() == null && Long.valueOf(argRetailLocationId) != null) || (
/* 127 */       getDAO_().getRetailLocationId() != null && !getDAO_().getRetailLocationId().equals(Long.valueOf(argRetailLocationId)))) {
/* 128 */       getDAO_().setRetailLocationId(Long.valueOf(argRetailLocationId));
/* 129 */       ev_postable = true;
/* 130 */       if (this._properties != null) {
/*     */         
/* 132 */         Iterator<StateJournalPropertyModel> it = this._properties.iterator();
/* 133 */         while (it.hasNext())
/*     */         {
/* 135 */           ((StateJournalPropertyModel)it.next()).setRetailLocationId_noev(argRetailLocationId);
/*     */         }
/*     */       } 
/*     */     } 
/*     */     
/* 140 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public long getWorkstationId() {
/* 148 */     if (getDAO_().getWorkstationId() != null) {
/* 149 */       return getDAO_().getWorkstationId().longValue();
/*     */     }
/*     */     
/* 152 */     return 0L;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setWorkstationId(long argWorkstationId) {
/* 161 */     if (setWorkstationId_noev(argWorkstationId) && 
/* 162 */       this._events != null && 
/* 163 */       postEventsForChanges()) {
/* 164 */       this._events.post(IStateJournal.SET_WORKSTATIONID, Long.valueOf(argWorkstationId));
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setWorkstationId_noev(long argWorkstationId) {
/* 171 */     boolean ev_postable = false;
/*     */     
/* 173 */     if ((getDAO_().getWorkstationId() == null && Long.valueOf(argWorkstationId) != null) || (
/* 174 */       getDAO_().getWorkstationId() != null && !getDAO_().getWorkstationId().equals(Long.valueOf(argWorkstationId)))) {
/* 175 */       getDAO_().setWorkstationId(Long.valueOf(argWorkstationId));
/* 176 */       ev_postable = true;
/* 177 */       if (this._properties != null) {
/*     */         
/* 179 */         Iterator<StateJournalPropertyModel> it = this._properties.iterator();
/* 180 */         while (it.hasNext())
/*     */         {
/* 182 */           ((StateJournalPropertyModel)it.next()).setWorkstationId_noev(argWorkstationId);
/*     */         }
/*     */       } 
/*     */     } 
/*     */     
/* 187 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getStatusTypcode() {
/* 195 */     return getDAO_().getStatusTypcode();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setStatusTypcode(String argStatusTypcode) {
/* 203 */     if (setStatusTypcode_noev(argStatusTypcode) && 
/* 204 */       this._events != null && 
/* 205 */       postEventsForChanges()) {
/* 206 */       this._events.post(IStateJournal.SET_STATUSTYPCODE, argStatusTypcode);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setStatusTypcode_noev(String argStatusTypcode) {
/* 213 */     boolean ev_postable = false;
/*     */     
/* 215 */     if ((getDAO_().getStatusTypcode() == null && argStatusTypcode != null) || (
/* 216 */       getDAO_().getStatusTypcode() != null && !getDAO_().getStatusTypcode().equals(argStatusTypcode))) {
/* 217 */       getDAO_().setStatusTypcode(argStatusTypcode);
/* 218 */       ev_postable = true;
/* 219 */       if (this._properties != null) {
/*     */         
/* 221 */         Iterator<StateJournalPropertyModel> it = this._properties.iterator();
/* 222 */         while (it.hasNext())
/*     */         {
/* 224 */           ((StateJournalPropertyModel)it.next()).setStatusTypcode_noev(argStatusTypcode);
/*     */         }
/*     */       } 
/*     */     } 
/*     */     
/* 229 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getStateJournalId() {
/* 237 */     return getDAO_().getStateJournalId();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setStateJournalId(String argStateJournalId) {
/* 245 */     if (setStateJournalId_noev(argStateJournalId) && 
/* 246 */       this._events != null && 
/* 247 */       postEventsForChanges()) {
/* 248 */       this._events.post(IStateJournal.SET_STATEJOURNALID, argStateJournalId);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setStateJournalId_noev(String argStateJournalId) {
/* 255 */     boolean ev_postable = false;
/*     */     
/* 257 */     if ((getDAO_().getStateJournalId() == null && argStateJournalId != null) || (
/* 258 */       getDAO_().getStateJournalId() != null && !getDAO_().getStateJournalId().equals(argStateJournalId))) {
/* 259 */       getDAO_().setStateJournalId(argStateJournalId);
/* 260 */       ev_postable = true;
/* 261 */       if (this._properties != null) {
/*     */         
/* 263 */         Iterator<StateJournalPropertyModel> it = this._properties.iterator();
/* 264 */         while (it.hasNext())
/*     */         {
/* 266 */           ((StateJournalPropertyModel)it.next()).setStateJournalId_noev(argStateJournalId);
/*     */         }
/*     */       } 
/*     */     } 
/*     */     
/* 271 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Date getCreateDate() {
/* 279 */     return getDAO_().getCreateDate();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setCreateDate(Date argCreateDate) {
/* 287 */     if (setCreateDate_noev(argCreateDate) && 
/* 288 */       this._events != null && 
/* 289 */       postEventsForChanges()) {
/* 290 */       this._events.post(IStateJournal.SET_CREATEDATE, argCreateDate);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setCreateDate_noev(Date argCreateDate) {
/* 297 */     boolean ev_postable = false;
/*     */     
/* 299 */     if ((getDAO_().getCreateDate() == null && argCreateDate != null) || (
/* 300 */       getDAO_().getCreateDate() != null && !getDAO_().getCreateDate().equals(argCreateDate))) {
/* 301 */       getDAO_().setCreateDate(argCreateDate);
/* 302 */       ev_postable = true;
/*     */     } 
/*     */     
/* 305 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getCreateUserId() {
/* 313 */     return getDAO_().getCreateUserId();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setCreateUserId(String argCreateUserId) {
/* 321 */     if (setCreateUserId_noev(argCreateUserId) && 
/* 322 */       this._events != null && 
/* 323 */       postEventsForChanges()) {
/* 324 */       this._events.post(IStateJournal.SET_CREATEUSERID, argCreateUserId);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setCreateUserId_noev(String argCreateUserId) {
/* 331 */     boolean ev_postable = false;
/*     */     
/* 333 */     if ((getDAO_().getCreateUserId() == null && argCreateUserId != null) || (
/* 334 */       getDAO_().getCreateUserId() != null && !getDAO_().getCreateUserId().equals(argCreateUserId))) {
/* 335 */       getDAO_().setCreateUserId(argCreateUserId);
/* 336 */       ev_postable = true;
/*     */     } 
/*     */     
/* 339 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Date getUpdateDate() {
/* 347 */     return getDAO_().getUpdateDate();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setUpdateDate(Date argUpdateDate) {
/* 355 */     if (setUpdateDate_noev(argUpdateDate) && 
/* 356 */       this._events != null && 
/* 357 */       postEventsForChanges()) {
/* 358 */       this._events.post(IStateJournal.SET_UPDATEDATE, argUpdateDate);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setUpdateDate_noev(Date argUpdateDate) {
/* 365 */     boolean ev_postable = false;
/*     */     
/* 367 */     if ((getDAO_().getUpdateDate() == null && argUpdateDate != null) || (
/* 368 */       getDAO_().getUpdateDate() != null && !getDAO_().getUpdateDate().equals(argUpdateDate))) {
/* 369 */       getDAO_().setUpdateDate(argUpdateDate);
/* 370 */       ev_postable = true;
/*     */     } 
/*     */     
/* 373 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getUpdateUserId() {
/* 381 */     return getDAO_().getUpdateUserId();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setUpdateUserId(String argUpdateUserId) {
/* 389 */     if (setUpdateUserId_noev(argUpdateUserId) && 
/* 390 */       this._events != null && 
/* 391 */       postEventsForChanges()) {
/* 392 */       this._events.post(IStateJournal.SET_UPDATEUSERID, argUpdateUserId);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setUpdateUserId_noev(String argUpdateUserId) {
/* 399 */     boolean ev_postable = false;
/*     */     
/* 401 */     if ((getDAO_().getUpdateUserId() == null && argUpdateUserId != null) || (
/* 402 */       getDAO_().getUpdateUserId() != null && !getDAO_().getUpdateUserId().equals(argUpdateUserId))) {
/* 403 */       getDAO_().setUpdateUserId(argUpdateUserId);
/* 404 */       ev_postable = true;
/*     */     } 
/*     */     
/* 407 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Date getDateValue() {
/* 415 */     return getDAO_().getDateValue();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setDateValue(Date argDateValue) {
/* 423 */     if (setDateValue_noev(argDateValue));
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setDateValue_noev(Date argDateValue) {
/* 429 */     boolean ev_postable = false;
/*     */     
/* 431 */     if ((getDAO_().getDateValue() == null && argDateValue != null) || (
/* 432 */       getDAO_().getDateValue() != null && !getDAO_().getDateValue().equals(argDateValue))) {
/* 433 */       getDAO_().setDateValue(argDateValue);
/* 434 */       ev_postable = true;
/*     */     } 
/*     */     
/* 437 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getStringValue() {
/* 445 */     return getDAO_().getStringValue();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setStringValue(String argStringValue) {
/* 453 */     if (setStringValue_noev(argStringValue) && 
/* 454 */       this._events != null && 
/* 455 */       postEventsForChanges()) {
/* 456 */       this._events.post(IStateJournal.SET_STRINGVALUE, argStringValue);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setStringValue_noev(String argStringValue) {
/* 463 */     boolean ev_postable = false;
/*     */     
/* 465 */     if ((getDAO_().getStringValue() == null && argStringValue != null) || (
/* 466 */       getDAO_().getStringValue() != null && !getDAO_().getStringValue().equals(argStringValue))) {
/* 467 */       getDAO_().setStringValue(argStringValue);
/* 468 */       ev_postable = true;
/*     */     } 
/*     */     
/* 471 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public BigDecimal getDecimalValue() {
/* 479 */     return getDAO_().getDecimalValue();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setDecimalValue(BigDecimal argDecimalValue) {
/* 487 */     if (setDecimalValue_noev(argDecimalValue) && 
/* 488 */       this._events != null && 
/* 489 */       postEventsForChanges()) {
/* 490 */       this._events.post(IStateJournal.SET_DECIMALVALUE, argDecimalValue);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setDecimalValue_noev(BigDecimal argDecimalValue) {
/* 497 */     boolean ev_postable = false;
/*     */     
/* 499 */     if ((getDAO_().getDecimalValue() == null && argDecimalValue != null) || (
/* 500 */       getDAO_().getDecimalValue() != null && !getDAO_().getDecimalValue().equals(argDecimalValue))) {
/* 501 */       getDAO_().setDecimalValue(argDecimalValue);
/* 502 */       ev_postable = true;
/*     */     } 
/*     */     
/* 505 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Date getTimeStamp() {
/* 513 */     return getDAO_().getTimeStamp();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setTimeStamp(Date argTimeStamp) {
/* 521 */     if (setTimeStamp_noev(argTimeStamp));
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setTimeStamp_noev(Date argTimeStamp) {
/* 527 */     boolean ev_postable = false;
/*     */     
/* 529 */     if ((getDAO_().getTimeStamp() == null && argTimeStamp != null) || (
/* 530 */       getDAO_().getTimeStamp() != null && !getDAO_().getTimeStamp().equals(argTimeStamp))) {
/* 531 */       getDAO_().setTimeStamp(argTimeStamp);
/* 532 */       ev_postable = true;
/*     */     } 
/*     */     
/* 535 */     return ev_postable;
/*     */   }
/*     */   
/*     */   protected IStateJournalProperty newProperty(String argPropertyName) {
/* 539 */     StateJournalPropertyId id = new StateJournalPropertyId();
/*     */     
/* 541 */     id.setRetailLocationId(Long.valueOf(getRetailLocationId()));
/* 542 */     id.setWorkstationId(Long.valueOf(getWorkstationId()));
/* 543 */     id.setStatusTypcode(getStatusTypcode());
/* 544 */     id.setStateJournalId(getStateJournalId());
/* 545 */     id.setPropertyCode(argPropertyName);
/*     */     
/* 547 */     IStateJournalProperty prop = (IStateJournalProperty)DataFactory.getInstance().createNewObject((IObjectId)id, IStateJournalProperty.class);
/* 548 */     return prop;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @Relationship(name = "Properties")
/*     */   public List<IStateJournalProperty> getProperties() {
/* 557 */     if (this._properties == null) {
/* 558 */       this._properties = new HistoricalList(null);
/*     */     }
/* 560 */     return (List<IStateJournalProperty>)this._properties;
/*     */   }
/*     */   
/*     */   public void setProperties(List<IStateJournalProperty> argProperties) {
/* 564 */     if (this._properties == null) {
/* 565 */       this._properties = new HistoricalList(argProperties);
/*     */     } else {
/* 567 */       this._properties.setCurrentList(argProperties);
/*     */     } 
/*     */     
/* 570 */     for (IStateJournalProperty child : this._properties) {
/* 571 */       StateJournalPropertyModel model = (StateJournalPropertyModel)child;
/* 572 */       model.setOrganizationId_noev(getOrganizationId());
/* 573 */       model.setRetailLocationId_noev(getRetailLocationId());
/* 574 */       model.setWorkstationId_noev(getWorkstationId());
/* 575 */       model.setStatusTypcode_noev(getStatusTypcode());
/* 576 */       model.setStateJournalId_noev(getStateJournalId());
/* 577 */       if (child instanceof IDataModelImpl) {
/* 578 */         IDataAccessObject childDao = ((IDataModelImpl)child).getDAO();
/* 579 */         if (StringUtils.isEmpty(childDao.getOriginDataSource()) && 
/* 580 */           !StringUtils.isEmpty(getDAO().getOriginDataSource())) {
/* 581 */           childDao.setOriginDataSource(getDAO().getOriginDataSource());
/*     */         }
/*     */       } 
/* 584 */       if (postEventsForChanges()) {
/* 585 */         this._eventManager.registerEventHandler((IEventAware)this._eventCascade, (IEventSource)child);
/*     */       }
/*     */     } 
/*     */   }
/*     */   
/*     */   public void addStateJournalProperty(IStateJournalProperty argStateJournalProperty) {
/* 591 */     if (this._properties == null) {
/* 592 */       this._properties = new HistoricalList(null);
/*     */     }
/* 594 */     argStateJournalProperty.setOrganizationId(getOrganizationId());
/* 595 */     argStateJournalProperty.setRetailLocationId(getRetailLocationId());
/* 596 */     argStateJournalProperty.setWorkstationId(getWorkstationId());
/* 597 */     argStateJournalProperty.setStatusTypcode(getStatusTypcode());
/* 598 */     argStateJournalProperty.setStateJournalId(getStateJournalId());
/* 599 */     if (argStateJournalProperty instanceof IDataModelImpl) {
/* 600 */       IDataAccessObject childDao = ((IDataModelImpl)argStateJournalProperty).getDAO();
/* 601 */       if (StringUtils.isEmpty(childDao.getOriginDataSource()) && 
/* 602 */         !StringUtils.isEmpty(getDAO().getOriginDataSource())) {
/* 603 */         childDao.setOriginDataSource(getDAO().getOriginDataSource());
/*     */       }
/*     */     } 
/*     */ 
/*     */     
/* 608 */     if (postEventsForChanges()) {
/* 609 */       this._eventManager.registerEventHandler((IEventAware)this._eventCascade, (IEventSource)new EventDescriptor(argStateJournalProperty));
/*     */     }
/*     */     
/* 612 */     this._properties.add(argStateJournalProperty);
/* 613 */     if (postEventsForChanges()) {
/* 614 */       this._events.post(IStateJournal.ADD_PROPERTIES, argStateJournalProperty);
/*     */     }
/*     */   }
/*     */   
/*     */   public void removeStateJournalProperty(IStateJournalProperty argStateJournalProperty) {
/* 619 */     if (this._properties != null) {
/*     */       
/* 621 */       if (postEventsForChanges()) {
/* 622 */         this._eventManager.deregisterEventHandler((IEventAware)this._eventCascade, (IEventSource)new EventDescriptor(argStateJournalProperty));
/*     */       }
/* 624 */       this._properties.remove(argStateJournalProperty);
/* 625 */       if (postEventsForChanges()) {
/* 626 */         this._events.post(IStateJournal.REMOVE_PROPERTIES, argStateJournalProperty);
/*     */       }
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public Object getValue(String argFieldId) {
/* 633 */     if ("Properties".equals(argFieldId)) {
/* 634 */       return getProperties();
/*     */     }
/* 636 */     if ("StateJournalExtension".equals(argFieldId)) {
/* 637 */       return this._myExtension;
/*     */     }
/*     */     
/* 640 */     return super.getValue(argFieldId);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void setValue(String argFieldId, Object argValue) {
/* 646 */     if ("Properties".equals(argFieldId)) {
/* 647 */       setProperties(changeToList(argValue, IStateJournalProperty.class));
/*     */     }
/* 649 */     else if ("StateJournalExtension".equals(argFieldId)) {
/* 650 */       this._myExtension = (IDataModel)argValue;
/*     */     } else {
/*     */       
/* 653 */       super.setValue(argFieldId, argValue);
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public void setDependencies(IPersistenceDefaults argPD, EventManager argEM) {
/* 659 */     this._persistenceDefaults = argPD;
/* 660 */     this._daoImpl.setPersistenceDefaults(argPD);
/* 661 */     this._eventManager = argEM;
/* 662 */     this._events = (Eventor)new ModelEventor((IDataModel)this, argEM);
/* 663 */     this._eventCascade = (EventHandler)new CascadingHandler(this);
/* 664 */     if (this._properties != null) {
/* 665 */       for (IStateJournalProperty relationship : this._properties) {
/* 666 */         ((IDataModelImpl)relationship).setDependencies(argPD, argEM);
/*     */       }
/*     */     }
/*     */   }
/*     */   
/*     */   public IDataModel getStateJournalExt() {
/* 672 */     return this._myExtension;
/*     */   }
/*     */   
/*     */   public void setStateJournalExt(IDataModel argExt) {
/* 676 */     this._myExtension = argExt;
/*     */   }
/*     */ 
/*     */   
/*     */   public void startTransaction() {
/* 681 */     if (this._alreadyInStart) {
/*     */       return;
/*     */     }
/*     */     
/* 685 */     this._alreadyInStart = true;
/*     */ 
/*     */     
/* 688 */     super.startTransaction();
/*     */     
/* 690 */     this._propertiesSavepoint = this._properties;
/* 691 */     if (this._properties != null) {
/* 692 */       this._propertiesSavepoint = new HistoricalList((List)this._properties);
/* 693 */       Iterator<IDataModel> it = this._properties.iterator();
/* 694 */       while (it.hasNext()) {
/* 695 */         ((IDataModel)it.next()).startTransaction();
/*     */       }
/*     */     } 
/*     */ 
/*     */     
/* 700 */     this._alreadyInStart = false;
/*     */   }
/*     */ 
/*     */   
/*     */   public void rollbackChanges() {
/* 705 */     if (isAlreadyRolledBack()) {
/*     */       return;
/*     */     }
/* 708 */     super.rollbackChanges();
/*     */     
/* 710 */     this._properties = this._propertiesSavepoint;
/* 711 */     this._propertiesSavepoint = null;
/* 712 */     if (this._properties != null) {
/* 713 */       Iterator<IDataModel> it = this._properties.iterator();
/* 714 */       while (it.hasNext()) {
/* 715 */         ((IDataModel)it.next()).rollbackChanges();
/*     */       }
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void commitTransaction() {
/* 723 */     if (this._alreadyInCommit) {
/*     */       return;
/*     */     }
/* 726 */     this._alreadyInCommit = true;
/*     */ 
/*     */     
/* 729 */     super.commitTransaction();
/*     */     
/* 731 */     this._propertiesSavepoint = this._properties;
/* 732 */     if (this._properties != null) {
/* 733 */       Iterator<IDataModel> it = this._properties.iterator();
/* 734 */       while (it.hasNext()) {
/* 735 */         ((IDataModel)it.next()).commitTransaction();
/*     */       }
/* 737 */       this._properties = new HistoricalList((List)this._properties);
/*     */     } 
/*     */ 
/*     */     
/* 741 */     this._alreadyInCommit = false;
/*     */   }
/*     */ 
/*     */   
/*     */   private void readObject(ObjectInputStream argStream) throws IOException, ClassNotFoundException {
/* 746 */     argStream.defaultReadObject();
/*     */   }
/*     */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\loc\impl\StateJournalModel.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */