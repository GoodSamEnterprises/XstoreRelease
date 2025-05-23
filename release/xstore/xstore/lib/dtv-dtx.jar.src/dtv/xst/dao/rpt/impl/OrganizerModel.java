/*     */ package dtv.xst.dao.rpt.impl;
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
/*     */ import dtv.xst.dao.rpt.IOrganizer;
/*     */ import dtv.xst.dao.rpt.IOrganizerProperty;
/*     */ import dtv.xst.dao.rpt.OrganizerPropertyId;
/*     */ import java.io.IOException;
/*     */ import java.io.ObjectInputStream;
/*     */ import java.util.Date;
/*     */ import java.util.Iterator;
/*     */ import java.util.List;
/*     */ 
/*     */ public class OrganizerModel extends AbstractDataModelWithPropertyImpl<IOrganizerProperty> implements IOrganizer {
/*     */   private static final long serialVersionUID = -137637105L;
/*     */   private transient boolean _alreadyInStart = false;
/*     */   private transient boolean _alreadyInCommit = false;
/*     */   
/*     */   public String toString() {
/*  33 */     return super.toString() + " Id: " + getObjectId();
/*     */   }
/*     */   private IDataModel _myExtension; private HistoricalList<IOrganizerProperty> _properties; private transient HistoricalList<IOrganizerProperty> _propertiesSavepoint;
/*     */   
/*     */   public void initDAO() {
/*  38 */     setDAO((IDataAccessObject)new OrganizerDAO());
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private OrganizerDAO getDAO_() {
/*  46 */     return (OrganizerDAO)this._daoImpl;
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
/*  70 */       this._events.post(IOrganizer.SET_ORGANIZATIONID, Long.valueOf(argOrganizationId));
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
/*  85 */         Iterator<OrganizerPropertyModel> it = this._properties.iterator();
/*  86 */         while (it.hasNext())
/*     */         {
/*  88 */           ((OrganizerPropertyModel)it.next()).setOrganizationId_noev(argOrganizationId);
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
/*     */   public String getReportName() {
/* 101 */     return getDAO_().getReportName();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setReportName(String argReportName) {
/* 109 */     if (setReportName_noev(argReportName) && 
/* 110 */       this._events != null && 
/* 111 */       postEventsForChanges()) {
/* 112 */       this._events.post(IOrganizer.SET_REPORTNAME, argReportName);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setReportName_noev(String argReportName) {
/* 119 */     boolean ev_postable = false;
/*     */     
/* 121 */     if ((getDAO_().getReportName() == null && argReportName != null) || (
/* 122 */       getDAO_().getReportName() != null && !getDAO_().getReportName().equals(argReportName))) {
/* 123 */       getDAO_().setReportName(argReportName);
/* 124 */       ev_postable = true;
/* 125 */       if (this._properties != null) {
/*     */         
/* 127 */         Iterator<OrganizerPropertyModel> it = this._properties.iterator();
/* 128 */         while (it.hasNext())
/*     */         {
/* 130 */           ((OrganizerPropertyModel)it.next()).setReportName_noev(argReportName);
/*     */         }
/*     */       } 
/*     */     } 
/*     */     
/* 135 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getReportGroup() {
/* 143 */     return getDAO_().getReportGroup();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setReportGroup(String argReportGroup) {
/* 151 */     if (setReportGroup_noev(argReportGroup) && 
/* 152 */       this._events != null && 
/* 153 */       postEventsForChanges()) {
/* 154 */       this._events.post(IOrganizer.SET_REPORTGROUP, argReportGroup);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setReportGroup_noev(String argReportGroup) {
/* 161 */     boolean ev_postable = false;
/*     */     
/* 163 */     if ((getDAO_().getReportGroup() == null && argReportGroup != null) || (
/* 164 */       getDAO_().getReportGroup() != null && !getDAO_().getReportGroup().equals(argReportGroup))) {
/* 165 */       getDAO_().setReportGroup(argReportGroup);
/* 166 */       ev_postable = true;
/* 167 */       if (this._properties != null) {
/*     */         
/* 169 */         Iterator<OrganizerPropertyModel> it = this._properties.iterator();
/* 170 */         while (it.hasNext())
/*     */         {
/* 172 */           ((OrganizerPropertyModel)it.next()).setReportGroup_noev(argReportGroup);
/*     */         }
/*     */       } 
/*     */     } 
/*     */     
/* 177 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getReportElement() {
/* 185 */     return getDAO_().getReportElement();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setReportElement(String argReportElement) {
/* 193 */     if (setReportElement_noev(argReportElement) && 
/* 194 */       this._events != null && 
/* 195 */       postEventsForChanges()) {
/* 196 */       this._events.post(IOrganizer.SET_REPORTELEMENT, argReportElement);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setReportElement_noev(String argReportElement) {
/* 203 */     boolean ev_postable = false;
/*     */     
/* 205 */     if ((getDAO_().getReportElement() == null && argReportElement != null) || (
/* 206 */       getDAO_().getReportElement() != null && !getDAO_().getReportElement().equals(argReportElement))) {
/* 207 */       getDAO_().setReportElement(argReportElement);
/* 208 */       ev_postable = true;
/* 209 */       if (this._properties != null) {
/*     */         
/* 211 */         Iterator<OrganizerPropertyModel> it = this._properties.iterator();
/* 212 */         while (it.hasNext())
/*     */         {
/* 214 */           ((OrganizerPropertyModel)it.next()).setReportElement_noev(argReportElement);
/*     */         }
/*     */       } 
/*     */     } 
/*     */     
/* 219 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Date getCreateDate() {
/* 227 */     return getDAO_().getCreateDate();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setCreateDate(Date argCreateDate) {
/* 235 */     if (setCreateDate_noev(argCreateDate) && 
/* 236 */       this._events != null && 
/* 237 */       postEventsForChanges()) {
/* 238 */       this._events.post(IOrganizer.SET_CREATEDATE, argCreateDate);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setCreateDate_noev(Date argCreateDate) {
/* 245 */     boolean ev_postable = false;
/*     */     
/* 247 */     if ((getDAO_().getCreateDate() == null && argCreateDate != null) || (
/* 248 */       getDAO_().getCreateDate() != null && !getDAO_().getCreateDate().equals(argCreateDate))) {
/* 249 */       getDAO_().setCreateDate(argCreateDate);
/* 250 */       ev_postable = true;
/*     */     } 
/*     */     
/* 253 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getCreateUserId() {
/* 261 */     return getDAO_().getCreateUserId();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setCreateUserId(String argCreateUserId) {
/* 269 */     if (setCreateUserId_noev(argCreateUserId) && 
/* 270 */       this._events != null && 
/* 271 */       postEventsForChanges()) {
/* 272 */       this._events.post(IOrganizer.SET_CREATEUSERID, argCreateUserId);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setCreateUserId_noev(String argCreateUserId) {
/* 279 */     boolean ev_postable = false;
/*     */     
/* 281 */     if ((getDAO_().getCreateUserId() == null && argCreateUserId != null) || (
/* 282 */       getDAO_().getCreateUserId() != null && !getDAO_().getCreateUserId().equals(argCreateUserId))) {
/* 283 */       getDAO_().setCreateUserId(argCreateUserId);
/* 284 */       ev_postable = true;
/*     */     } 
/*     */     
/* 287 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Date getUpdateDate() {
/* 295 */     return getDAO_().getUpdateDate();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setUpdateDate(Date argUpdateDate) {
/* 303 */     if (setUpdateDate_noev(argUpdateDate) && 
/* 304 */       this._events != null && 
/* 305 */       postEventsForChanges()) {
/* 306 */       this._events.post(IOrganizer.SET_UPDATEDATE, argUpdateDate);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setUpdateDate_noev(Date argUpdateDate) {
/* 313 */     boolean ev_postable = false;
/*     */     
/* 315 */     if ((getDAO_().getUpdateDate() == null && argUpdateDate != null) || (
/* 316 */       getDAO_().getUpdateDate() != null && !getDAO_().getUpdateDate().equals(argUpdateDate))) {
/* 317 */       getDAO_().setUpdateDate(argUpdateDate);
/* 318 */       ev_postable = true;
/*     */     } 
/*     */     
/* 321 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getUpdateUserId() {
/* 329 */     return getDAO_().getUpdateUserId();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setUpdateUserId(String argUpdateUserId) {
/* 337 */     if (setUpdateUserId_noev(argUpdateUserId) && 
/* 338 */       this._events != null && 
/* 339 */       postEventsForChanges()) {
/* 340 */       this._events.post(IOrganizer.SET_UPDATEUSERID, argUpdateUserId);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setUpdateUserId_noev(String argUpdateUserId) {
/* 347 */     boolean ev_postable = false;
/*     */     
/* 349 */     if ((getDAO_().getUpdateUserId() == null && argUpdateUserId != null) || (
/* 350 */       getDAO_().getUpdateUserId() != null && !getDAO_().getUpdateUserId().equals(argUpdateUserId))) {
/* 351 */       getDAO_().setUpdateUserId(argUpdateUserId);
/* 352 */       ev_postable = true;
/*     */     } 
/*     */     
/* 355 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int getReportOrder() {
/* 363 */     if (getDAO_().getReportOrder() != null) {
/* 364 */       return getDAO_().getReportOrder().intValue();
/*     */     }
/*     */     
/* 367 */     return 0;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setReportOrder(int argReportOrder) {
/* 376 */     if (setReportOrder_noev(argReportOrder) && 
/* 377 */       this._events != null && 
/* 378 */       postEventsForChanges()) {
/* 379 */       this._events.post(IOrganizer.SET_REPORTORDER, Integer.valueOf(argReportOrder));
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setReportOrder_noev(int argReportOrder) {
/* 386 */     boolean ev_postable = false;
/*     */     
/* 388 */     if ((getDAO_().getReportOrder() == null && Integer.valueOf(argReportOrder) != null) || (
/* 389 */       getDAO_().getReportOrder() != null && !getDAO_().getReportOrder().equals(Integer.valueOf(argReportOrder)))) {
/* 390 */       getDAO_().setReportOrder(Integer.valueOf(argReportOrder));
/* 391 */       ev_postable = true;
/*     */     } 
/*     */     
/* 394 */     return ev_postable;
/*     */   }
/*     */   
/*     */   protected IOrganizerProperty newProperty(String argPropertyName) {
/* 398 */     OrganizerPropertyId id = new OrganizerPropertyId();
/*     */     
/* 400 */     id.setReportName(getReportName());
/* 401 */     id.setReportGroup(getReportGroup());
/* 402 */     id.setReportElement(getReportElement());
/* 403 */     id.setPropertyCode(argPropertyName);
/*     */     
/* 405 */     IOrganizerProperty prop = (IOrganizerProperty)DataFactory.getInstance().createNewObject((IObjectId)id, IOrganizerProperty.class);
/* 406 */     return prop;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @Relationship(name = "Properties")
/*     */   public List<IOrganizerProperty> getProperties() {
/* 415 */     if (this._properties == null) {
/* 416 */       this._properties = new HistoricalList(null);
/*     */     }
/* 418 */     return (List<IOrganizerProperty>)this._properties;
/*     */   }
/*     */   
/*     */   public void setProperties(List<IOrganizerProperty> argProperties) {
/* 422 */     if (this._properties == null) {
/* 423 */       this._properties = new HistoricalList(argProperties);
/*     */     } else {
/* 425 */       this._properties.setCurrentList(argProperties);
/*     */     } 
/*     */     
/* 428 */     for (IOrganizerProperty child : this._properties) {
/* 429 */       OrganizerPropertyModel model = (OrganizerPropertyModel)child;
/* 430 */       model.setOrganizationId_noev(getOrganizationId());
/* 431 */       model.setReportName_noev(getReportName());
/* 432 */       model.setReportGroup_noev(getReportGroup());
/* 433 */       model.setReportElement_noev(getReportElement());
/* 434 */       if (child instanceof IDataModelImpl) {
/* 435 */         IDataAccessObject childDao = ((IDataModelImpl)child).getDAO();
/* 436 */         if (StringUtils.isEmpty(childDao.getOriginDataSource()) && 
/* 437 */           !StringUtils.isEmpty(getDAO().getOriginDataSource())) {
/* 438 */           childDao.setOriginDataSource(getDAO().getOriginDataSource());
/*     */         }
/*     */       } 
/* 441 */       if (postEventsForChanges()) {
/* 442 */         this._eventManager.registerEventHandler((IEventAware)this._eventCascade, (IEventSource)child);
/*     */       }
/*     */     } 
/*     */   }
/*     */   
/*     */   public void addOrganizerProperty(IOrganizerProperty argOrganizerProperty) {
/* 448 */     if (this._properties == null) {
/* 449 */       this._properties = new HistoricalList(null);
/*     */     }
/* 451 */     argOrganizerProperty.setOrganizationId(getOrganizationId());
/* 452 */     argOrganizerProperty.setReportName(getReportName());
/* 453 */     argOrganizerProperty.setReportGroup(getReportGroup());
/* 454 */     argOrganizerProperty.setReportElement(getReportElement());
/* 455 */     if (argOrganizerProperty instanceof IDataModelImpl) {
/* 456 */       IDataAccessObject childDao = ((IDataModelImpl)argOrganizerProperty).getDAO();
/* 457 */       if (StringUtils.isEmpty(childDao.getOriginDataSource()) && 
/* 458 */         !StringUtils.isEmpty(getDAO().getOriginDataSource())) {
/* 459 */         childDao.setOriginDataSource(getDAO().getOriginDataSource());
/*     */       }
/*     */     } 
/*     */ 
/*     */     
/* 464 */     if (postEventsForChanges()) {
/* 465 */       this._eventManager.registerEventHandler((IEventAware)this._eventCascade, (IEventSource)new EventDescriptor(argOrganizerProperty));
/*     */     }
/*     */     
/* 468 */     this._properties.add(argOrganizerProperty);
/* 469 */     if (postEventsForChanges()) {
/* 470 */       this._events.post(IOrganizer.ADD_PROPERTIES, argOrganizerProperty);
/*     */     }
/*     */   }
/*     */   
/*     */   public void removeOrganizerProperty(IOrganizerProperty argOrganizerProperty) {
/* 475 */     if (this._properties != null) {
/*     */       
/* 477 */       if (postEventsForChanges()) {
/* 478 */         this._eventManager.deregisterEventHandler((IEventAware)this._eventCascade, (IEventSource)new EventDescriptor(argOrganizerProperty));
/*     */       }
/* 480 */       this._properties.remove(argOrganizerProperty);
/* 481 */       if (postEventsForChanges()) {
/* 482 */         this._events.post(IOrganizer.REMOVE_PROPERTIES, argOrganizerProperty);
/*     */       }
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public Object getValue(String argFieldId) {
/* 489 */     if ("Properties".equals(argFieldId)) {
/* 490 */       return getProperties();
/*     */     }
/* 492 */     if ("OrganizerExtension".equals(argFieldId)) {
/* 493 */       return this._myExtension;
/*     */     }
/*     */     
/* 496 */     return super.getValue(argFieldId);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void setValue(String argFieldId, Object argValue) {
/* 502 */     if ("Properties".equals(argFieldId)) {
/* 503 */       setProperties(changeToList(argValue, IOrganizerProperty.class));
/*     */     }
/* 505 */     else if ("OrganizerExtension".equals(argFieldId)) {
/* 506 */       this._myExtension = (IDataModel)argValue;
/*     */     } else {
/*     */       
/* 509 */       super.setValue(argFieldId, argValue);
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public void setDependencies(IPersistenceDefaults argPD, EventManager argEM) {
/* 515 */     this._persistenceDefaults = argPD;
/* 516 */     this._daoImpl.setPersistenceDefaults(argPD);
/* 517 */     this._eventManager = argEM;
/* 518 */     this._events = (Eventor)new ModelEventor((IDataModel)this, argEM);
/* 519 */     this._eventCascade = (EventHandler)new CascadingHandler(this);
/* 520 */     if (this._properties != null) {
/* 521 */       for (IOrganizerProperty relationship : this._properties) {
/* 522 */         ((IDataModelImpl)relationship).setDependencies(argPD, argEM);
/*     */       }
/*     */     }
/*     */   }
/*     */   
/*     */   public IDataModel getOrganizerExt() {
/* 528 */     return this._myExtension;
/*     */   }
/*     */   
/*     */   public void setOrganizerExt(IDataModel argExt) {
/* 532 */     this._myExtension = argExt;
/*     */   }
/*     */ 
/*     */   
/*     */   public void startTransaction() {
/* 537 */     if (this._alreadyInStart) {
/*     */       return;
/*     */     }
/*     */     
/* 541 */     this._alreadyInStart = true;
/*     */ 
/*     */     
/* 544 */     super.startTransaction();
/*     */     
/* 546 */     this._propertiesSavepoint = this._properties;
/* 547 */     if (this._properties != null) {
/* 548 */       this._propertiesSavepoint = new HistoricalList((List)this._properties);
/* 549 */       Iterator<IDataModel> it = this._properties.iterator();
/* 550 */       while (it.hasNext()) {
/* 551 */         ((IDataModel)it.next()).startTransaction();
/*     */       }
/*     */     } 
/*     */ 
/*     */     
/* 556 */     this._alreadyInStart = false;
/*     */   }
/*     */ 
/*     */   
/*     */   public void rollbackChanges() {
/* 561 */     if (isAlreadyRolledBack()) {
/*     */       return;
/*     */     }
/* 564 */     super.rollbackChanges();
/*     */     
/* 566 */     this._properties = this._propertiesSavepoint;
/* 567 */     this._propertiesSavepoint = null;
/* 568 */     if (this._properties != null) {
/* 569 */       Iterator<IDataModel> it = this._properties.iterator();
/* 570 */       while (it.hasNext()) {
/* 571 */         ((IDataModel)it.next()).rollbackChanges();
/*     */       }
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void commitTransaction() {
/* 579 */     if (this._alreadyInCommit) {
/*     */       return;
/*     */     }
/* 582 */     this._alreadyInCommit = true;
/*     */ 
/*     */     
/* 585 */     super.commitTransaction();
/*     */     
/* 587 */     this._propertiesSavepoint = this._properties;
/* 588 */     if (this._properties != null) {
/* 589 */       Iterator<IDataModel> it = this._properties.iterator();
/* 590 */       while (it.hasNext()) {
/* 591 */         ((IDataModel)it.next()).commitTransaction();
/*     */       }
/* 593 */       this._properties = new HistoricalList((List)this._properties);
/*     */     } 
/*     */ 
/*     */     
/* 597 */     this._alreadyInCommit = false;
/*     */   }
/*     */ 
/*     */   
/*     */   private void readObject(ObjectInputStream argStream) throws IOException, ClassNotFoundException {
/* 602 */     argStream.defaultReadObject();
/*     */   }
/*     */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\rpt\impl\OrganizerModel.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */