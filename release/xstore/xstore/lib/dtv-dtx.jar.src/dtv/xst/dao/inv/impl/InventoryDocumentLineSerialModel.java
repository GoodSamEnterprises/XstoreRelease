/*     */ package dtv.xst.dao.inv.impl;
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
/*     */ import dtv.xst.dao.inv.IInventoryDocumentLineItem;
/*     */ import dtv.xst.dao.inv.IInventoryDocumentLineSerial;
/*     */ import dtv.xst.dao.inv.IInventoryDocumentLineSerialProperty;
/*     */ import dtv.xst.dao.inv.InventoryDocumentLineSerialPropertyId;
/*     */ import java.io.IOException;
/*     */ import java.io.ObjectInputStream;
/*     */ import java.util.Date;
/*     */ import java.util.Iterator;
/*     */ import java.util.List;
/*     */ 
/*     */ public class InventoryDocumentLineSerialModel extends AbstractDataModelWithPropertyImpl<IInventoryDocumentLineSerialProperty> implements IInventoryDocumentLineSerial {
/*     */   private static final long serialVersionUID = 423606495L;
/*     */   private IInventoryDocumentLineItem _parentLineItem;
/*     */   private transient boolean _alreadyInStart = false;
/*     */   
/*     */   public String toString() {
/*  35 */     return super.toString() + " Id: " + getObjectId();
/*     */   }
/*     */   private transient boolean _alreadyInCommit = false; private IDataModel _myExtension; private HistoricalList<IInventoryDocumentLineSerialProperty> _properties; private transient HistoricalList<IInventoryDocumentLineSerialProperty> _propertiesSavepoint;
/*     */   
/*     */   public void initDAO() {
/*  40 */     setDAO((IDataAccessObject)new InventoryDocumentLineSerialDAO());
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private InventoryDocumentLineSerialDAO getDAO_() {
/*  48 */     return (InventoryDocumentLineSerialDAO)this._daoImpl;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getDocumentId() {
/*  56 */     return getDAO_().getDocumentId();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setDocumentId(String argDocumentId) {
/*  64 */     if (setDocumentId_noev(argDocumentId) && 
/*  65 */       this._events != null && 
/*  66 */       postEventsForChanges()) {
/*  67 */       this._events.post(IInventoryDocumentLineSerial.SET_DOCUMENTID, argDocumentId);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setDocumentId_noev(String argDocumentId) {
/*  74 */     boolean ev_postable = false;
/*     */     
/*  76 */     if ((getDAO_().getDocumentId() == null && argDocumentId != null) || (
/*  77 */       getDAO_().getDocumentId() != null && !getDAO_().getDocumentId().equals(argDocumentId))) {
/*  78 */       getDAO_().setDocumentId(argDocumentId);
/*  79 */       ev_postable = true;
/*  80 */       if (this._properties != null) {
/*     */         
/*  82 */         Iterator<InventoryDocumentLineSerialPropertyModel> it = this._properties.iterator();
/*  83 */         while (it.hasNext())
/*     */         {
/*  85 */           ((InventoryDocumentLineSerialPropertyModel)it.next()).setDocumentId_noev(argDocumentId);
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
/*     */   public String getDocumentTypeCode() {
/*  98 */     return getDAO_().getDocumentTypeCode();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setDocumentTypeCode(String argDocumentTypeCode) {
/* 106 */     if (setDocumentTypeCode_noev(argDocumentTypeCode) && 
/* 107 */       this._events != null && 
/* 108 */       postEventsForChanges()) {
/* 109 */       this._events.post(IInventoryDocumentLineSerial.SET_DOCUMENTTYPECODE, argDocumentTypeCode);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setDocumentTypeCode_noev(String argDocumentTypeCode) {
/* 116 */     boolean ev_postable = false;
/*     */     
/* 118 */     if ((getDAO_().getDocumentTypeCode() == null && argDocumentTypeCode != null) || (
/* 119 */       getDAO_().getDocumentTypeCode() != null && !getDAO_().getDocumentTypeCode().equals(argDocumentTypeCode))) {
/* 120 */       getDAO_().setDocumentTypeCode(argDocumentTypeCode);
/* 121 */       ev_postable = true;
/* 122 */       if (this._properties != null) {
/*     */         
/* 124 */         Iterator<InventoryDocumentLineSerialPropertyModel> it = this._properties.iterator();
/* 125 */         while (it.hasNext())
/*     */         {
/* 127 */           ((InventoryDocumentLineSerialPropertyModel)it.next()).setDocumentTypeCode_noev(argDocumentTypeCode);
/*     */         }
/*     */       } 
/*     */     } 
/*     */     
/* 132 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int getInventoryDocumentLineNumber() {
/* 140 */     if (getDAO_().getInventoryDocumentLineNumber() != null) {
/* 141 */       return getDAO_().getInventoryDocumentLineNumber().intValue();
/*     */     }
/*     */     
/* 144 */     return 0;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setInventoryDocumentLineNumber(int argInventoryDocumentLineNumber) {
/* 153 */     if (setInventoryDocumentLineNumber_noev(argInventoryDocumentLineNumber) && 
/* 154 */       this._events != null && 
/* 155 */       postEventsForChanges()) {
/* 156 */       this._events.post(IInventoryDocumentLineSerial.SET_INVENTORYDOCUMENTLINENUMBER, Integer.valueOf(argInventoryDocumentLineNumber));
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setInventoryDocumentLineNumber_noev(int argInventoryDocumentLineNumber) {
/* 163 */     boolean ev_postable = false;
/*     */     
/* 165 */     if ((getDAO_().getInventoryDocumentLineNumber() == null && Integer.valueOf(argInventoryDocumentLineNumber) != null) || (
/* 166 */       getDAO_().getInventoryDocumentLineNumber() != null && !getDAO_().getInventoryDocumentLineNumber().equals(Integer.valueOf(argInventoryDocumentLineNumber)))) {
/* 167 */       getDAO_().setInventoryDocumentLineNumber(Integer.valueOf(argInventoryDocumentLineNumber));
/* 168 */       ev_postable = true;
/* 169 */       if (this._properties != null) {
/*     */         
/* 171 */         Iterator<InventoryDocumentLineSerialPropertyModel> it = this._properties.iterator();
/* 172 */         while (it.hasNext())
/*     */         {
/* 174 */           ((InventoryDocumentLineSerialPropertyModel)it.next()).setInventoryDocumentLineNumber_noev(argInventoryDocumentLineNumber);
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
/*     */   public long getOrganizationId() {
/* 187 */     if (getDAO_().getOrganizationId() != null) {
/* 188 */       return getDAO_().getOrganizationId().longValue();
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
/*     */   public void setOrganizationId(long argOrganizationId) {
/* 200 */     if (setOrganizationId_noev(argOrganizationId) && 
/* 201 */       this._events != null && 
/* 202 */       postEventsForChanges()) {
/* 203 */       this._events.post(IInventoryDocumentLineSerial.SET_ORGANIZATIONID, Long.valueOf(argOrganizationId));
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setOrganizationId_noev(long argOrganizationId) {
/* 210 */     boolean ev_postable = false;
/*     */     
/* 212 */     if ((getDAO_().getOrganizationId() == null && Long.valueOf(argOrganizationId) != null) || (
/* 213 */       getDAO_().getOrganizationId() != null && !getDAO_().getOrganizationId().equals(Long.valueOf(argOrganizationId)))) {
/* 214 */       getDAO_().setOrganizationId(Long.valueOf(argOrganizationId));
/* 215 */       ev_postable = true;
/* 216 */       if (this._properties != null) {
/*     */         
/* 218 */         Iterator<InventoryDocumentLineSerialPropertyModel> it = this._properties.iterator();
/* 219 */         while (it.hasNext())
/*     */         {
/* 221 */           ((InventoryDocumentLineSerialPropertyModel)it.next()).setOrganizationId_noev(argOrganizationId);
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
/*     */   public long getRetailLocationId() {
/* 234 */     if (getDAO_().getRetailLocationId() != null) {
/* 235 */       return getDAO_().getRetailLocationId().longValue();
/*     */     }
/*     */     
/* 238 */     return 0L;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setRetailLocationId(long argRetailLocationId) {
/* 247 */     if (setRetailLocationId_noev(argRetailLocationId) && 
/* 248 */       this._events != null && 
/* 249 */       postEventsForChanges()) {
/* 250 */       this._events.post(IInventoryDocumentLineSerial.SET_RETAILLOCATIONID, Long.valueOf(argRetailLocationId));
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setRetailLocationId_noev(long argRetailLocationId) {
/* 257 */     boolean ev_postable = false;
/*     */     
/* 259 */     if ((getDAO_().getRetailLocationId() == null && Long.valueOf(argRetailLocationId) != null) || (
/* 260 */       getDAO_().getRetailLocationId() != null && !getDAO_().getRetailLocationId().equals(Long.valueOf(argRetailLocationId)))) {
/* 261 */       getDAO_().setRetailLocationId(Long.valueOf(argRetailLocationId));
/* 262 */       ev_postable = true;
/* 263 */       if (this._properties != null) {
/*     */         
/* 265 */         Iterator<InventoryDocumentLineSerialPropertyModel> it = this._properties.iterator();
/* 266 */         while (it.hasNext())
/*     */         {
/* 268 */           ((InventoryDocumentLineSerialPropertyModel)it.next()).setRetailLocationId_noev(argRetailLocationId);
/*     */         }
/*     */       } 
/*     */     } 
/*     */     
/* 273 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int getSerialLineNumber() {
/* 281 */     if (getDAO_().getSerialLineNumber() != null) {
/* 282 */       return getDAO_().getSerialLineNumber().intValue();
/*     */     }
/*     */     
/* 285 */     return 0;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setSerialLineNumber(int argSerialLineNumber) {
/* 294 */     if (setSerialLineNumber_noev(argSerialLineNumber) && 
/* 295 */       this._events != null && 
/* 296 */       postEventsForChanges()) {
/* 297 */       this._events.post(IInventoryDocumentLineSerial.SET_SERIALLINENUMBER, Integer.valueOf(argSerialLineNumber));
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setSerialLineNumber_noev(int argSerialLineNumber) {
/* 304 */     boolean ev_postable = false;
/*     */     
/* 306 */     if ((getDAO_().getSerialLineNumber() == null && Integer.valueOf(argSerialLineNumber) != null) || (
/* 307 */       getDAO_().getSerialLineNumber() != null && !getDAO_().getSerialLineNumber().equals(Integer.valueOf(argSerialLineNumber)))) {
/* 308 */       getDAO_().setSerialLineNumber(Integer.valueOf(argSerialLineNumber));
/* 309 */       ev_postable = true;
/* 310 */       if (this._properties != null) {
/*     */         
/* 312 */         Iterator<InventoryDocumentLineSerialPropertyModel> it = this._properties.iterator();
/* 313 */         while (it.hasNext())
/*     */         {
/* 315 */           ((InventoryDocumentLineSerialPropertyModel)it.next()).setSerialLineNumber_noev(argSerialLineNumber);
/*     */         }
/*     */       } 
/*     */     } 
/*     */     
/* 320 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Date getCreateDate() {
/* 328 */     return getDAO_().getCreateDate();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setCreateDate(Date argCreateDate) {
/* 336 */     if (setCreateDate_noev(argCreateDate) && 
/* 337 */       this._events != null && 
/* 338 */       postEventsForChanges()) {
/* 339 */       this._events.post(IInventoryDocumentLineSerial.SET_CREATEDATE, argCreateDate);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setCreateDate_noev(Date argCreateDate) {
/* 346 */     boolean ev_postable = false;
/*     */     
/* 348 */     if ((getDAO_().getCreateDate() == null && argCreateDate != null) || (
/* 349 */       getDAO_().getCreateDate() != null && !getDAO_().getCreateDate().equals(argCreateDate))) {
/* 350 */       getDAO_().setCreateDate(argCreateDate);
/* 351 */       ev_postable = true;
/*     */     } 
/*     */     
/* 354 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getCreateUserId() {
/* 362 */     return getDAO_().getCreateUserId();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setCreateUserId(String argCreateUserId) {
/* 370 */     if (setCreateUserId_noev(argCreateUserId) && 
/* 371 */       this._events != null && 
/* 372 */       postEventsForChanges()) {
/* 373 */       this._events.post(IInventoryDocumentLineSerial.SET_CREATEUSERID, argCreateUserId);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setCreateUserId_noev(String argCreateUserId) {
/* 380 */     boolean ev_postable = false;
/*     */     
/* 382 */     if ((getDAO_().getCreateUserId() == null && argCreateUserId != null) || (
/* 383 */       getDAO_().getCreateUserId() != null && !getDAO_().getCreateUserId().equals(argCreateUserId))) {
/* 384 */       getDAO_().setCreateUserId(argCreateUserId);
/* 385 */       ev_postable = true;
/*     */     } 
/*     */     
/* 388 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Date getUpdateDate() {
/* 396 */     return getDAO_().getUpdateDate();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setUpdateDate(Date argUpdateDate) {
/* 404 */     if (setUpdateDate_noev(argUpdateDate) && 
/* 405 */       this._events != null && 
/* 406 */       postEventsForChanges()) {
/* 407 */       this._events.post(IInventoryDocumentLineSerial.SET_UPDATEDATE, argUpdateDate);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setUpdateDate_noev(Date argUpdateDate) {
/* 414 */     boolean ev_postable = false;
/*     */     
/* 416 */     if ((getDAO_().getUpdateDate() == null && argUpdateDate != null) || (
/* 417 */       getDAO_().getUpdateDate() != null && !getDAO_().getUpdateDate().equals(argUpdateDate))) {
/* 418 */       getDAO_().setUpdateDate(argUpdateDate);
/* 419 */       ev_postable = true;
/*     */     } 
/*     */     
/* 422 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getUpdateUserId() {
/* 430 */     return getDAO_().getUpdateUserId();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setUpdateUserId(String argUpdateUserId) {
/* 438 */     if (setUpdateUserId_noev(argUpdateUserId) && 
/* 439 */       this._events != null && 
/* 440 */       postEventsForChanges()) {
/* 441 */       this._events.post(IInventoryDocumentLineSerial.SET_UPDATEUSERID, argUpdateUserId);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setUpdateUserId_noev(String argUpdateUserId) {
/* 448 */     boolean ev_postable = false;
/*     */     
/* 450 */     if ((getDAO_().getUpdateUserId() == null && argUpdateUserId != null) || (
/* 451 */       getDAO_().getUpdateUserId() != null && !getDAO_().getUpdateUserId().equals(argUpdateUserId))) {
/* 452 */       getDAO_().setUpdateUserId(argUpdateUserId);
/* 453 */       ev_postable = true;
/*     */     } 
/*     */     
/* 456 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getSerialNumber() {
/* 464 */     return getDAO_().getSerialNumber();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setSerialNumber(String argSerialNumber) {
/* 472 */     if (setSerialNumber_noev(argSerialNumber) && 
/* 473 */       this._events != null && 
/* 474 */       postEventsForChanges()) {
/* 475 */       this._events.post(IInventoryDocumentLineSerial.SET_SERIALNUMBER, argSerialNumber);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setSerialNumber_noev(String argSerialNumber) {
/* 482 */     boolean ev_postable = false;
/*     */     
/* 484 */     if ((getDAO_().getSerialNumber() == null && argSerialNumber != null) || (
/* 485 */       getDAO_().getSerialNumber() != null && !getDAO_().getSerialNumber().equals(argSerialNumber))) {
/* 486 */       getDAO_().setSerialNumber(argSerialNumber);
/* 487 */       ev_postable = true;
/*     */     } 
/*     */     
/* 490 */     return ev_postable;
/*     */   }
/*     */   
/*     */   protected IInventoryDocumentLineSerialProperty newProperty(String argPropertyName) {
/* 494 */     InventoryDocumentLineSerialPropertyId id = new InventoryDocumentLineSerialPropertyId();
/*     */     
/* 496 */     id.setDocumentId(getDocumentId());
/* 497 */     id.setDocumentTypeCode(getDocumentTypeCode());
/* 498 */     id.setInventoryDocumentLineNumber(Integer.valueOf(getInventoryDocumentLineNumber()));
/* 499 */     id.setRetailLocationId(Long.valueOf(getRetailLocationId()));
/* 500 */     id.setSerialLineNumber(Integer.valueOf(getSerialLineNumber()));
/* 501 */     id.setPropertyCode(argPropertyName);
/*     */     
/* 503 */     IInventoryDocumentLineSerialProperty prop = (IInventoryDocumentLineSerialProperty)DataFactory.getInstance().createNewObject((IObjectId)id, IInventoryDocumentLineSerialProperty.class);
/* 504 */     return prop;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @Relationship(name = "Properties")
/*     */   public List<IInventoryDocumentLineSerialProperty> getProperties() {
/* 513 */     if (this._properties == null) {
/* 514 */       this._properties = new HistoricalList(null);
/*     */     }
/* 516 */     return (List<IInventoryDocumentLineSerialProperty>)this._properties;
/*     */   }
/*     */   
/*     */   public void setProperties(List<IInventoryDocumentLineSerialProperty> argProperties) {
/* 520 */     if (this._properties == null) {
/* 521 */       this._properties = new HistoricalList(argProperties);
/*     */     } else {
/* 523 */       this._properties.setCurrentList(argProperties);
/*     */     } 
/*     */     
/* 526 */     for (IInventoryDocumentLineSerialProperty child : this._properties) {
/* 527 */       InventoryDocumentLineSerialPropertyModel model = (InventoryDocumentLineSerialPropertyModel)child;
/* 528 */       model.setDocumentId_noev(getDocumentId());
/* 529 */       model.setDocumentTypeCode_noev(getDocumentTypeCode());
/* 530 */       model.setInventoryDocumentLineNumber_noev(getInventoryDocumentLineNumber());
/* 531 */       model.setOrganizationId_noev(getOrganizationId());
/* 532 */       model.setRetailLocationId_noev(getRetailLocationId());
/* 533 */       model.setSerialLineNumber_noev(getSerialLineNumber());
/* 534 */       if (child instanceof IDataModelImpl) {
/* 535 */         IDataAccessObject childDao = ((IDataModelImpl)child).getDAO();
/* 536 */         if (StringUtils.isEmpty(childDao.getOriginDataSource()) && 
/* 537 */           !StringUtils.isEmpty(getDAO().getOriginDataSource())) {
/* 538 */           childDao.setOriginDataSource(getDAO().getOriginDataSource());
/*     */         }
/*     */       } 
/* 541 */       if (postEventsForChanges()) {
/* 542 */         this._eventManager.registerEventHandler((IEventAware)this._eventCascade, (IEventSource)child);
/*     */       }
/*     */     } 
/*     */   }
/*     */   
/*     */   public void addInventoryDocumentLineSerialProperty(IInventoryDocumentLineSerialProperty argInventoryDocumentLineSerialProperty) {
/* 548 */     if (this._properties == null) {
/* 549 */       this._properties = new HistoricalList(null);
/*     */     }
/* 551 */     argInventoryDocumentLineSerialProperty.setDocumentId(getDocumentId());
/* 552 */     argInventoryDocumentLineSerialProperty.setDocumentTypeCode(getDocumentTypeCode());
/* 553 */     argInventoryDocumentLineSerialProperty.setInventoryDocumentLineNumber(getInventoryDocumentLineNumber());
/* 554 */     argInventoryDocumentLineSerialProperty.setOrganizationId(getOrganizationId());
/* 555 */     argInventoryDocumentLineSerialProperty.setRetailLocationId(getRetailLocationId());
/* 556 */     argInventoryDocumentLineSerialProperty.setSerialLineNumber(getSerialLineNumber());
/* 557 */     if (argInventoryDocumentLineSerialProperty instanceof IDataModelImpl) {
/* 558 */       IDataAccessObject childDao = ((IDataModelImpl)argInventoryDocumentLineSerialProperty).getDAO();
/* 559 */       if (StringUtils.isEmpty(childDao.getOriginDataSource()) && 
/* 560 */         !StringUtils.isEmpty(getDAO().getOriginDataSource())) {
/* 561 */         childDao.setOriginDataSource(getDAO().getOriginDataSource());
/*     */       }
/*     */     } 
/*     */ 
/*     */     
/* 566 */     if (postEventsForChanges()) {
/* 567 */       this._eventManager.registerEventHandler((IEventAware)this._eventCascade, (IEventSource)new EventDescriptor(argInventoryDocumentLineSerialProperty));
/*     */     }
/*     */     
/* 570 */     this._properties.add(argInventoryDocumentLineSerialProperty);
/* 571 */     if (postEventsForChanges()) {
/* 572 */       this._events.post(IInventoryDocumentLineSerial.ADD_PROPERTIES, argInventoryDocumentLineSerialProperty);
/*     */     }
/*     */   }
/*     */   
/*     */   public void removeInventoryDocumentLineSerialProperty(IInventoryDocumentLineSerialProperty argInventoryDocumentLineSerialProperty) {
/* 577 */     if (this._properties != null) {
/*     */       
/* 579 */       if (postEventsForChanges()) {
/* 580 */         this._eventManager.deregisterEventHandler((IEventAware)this._eventCascade, (IEventSource)new EventDescriptor(argInventoryDocumentLineSerialProperty));
/*     */       }
/* 582 */       this._properties.remove(argInventoryDocumentLineSerialProperty);
/* 583 */       if (postEventsForChanges()) {
/* 584 */         this._events.post(IInventoryDocumentLineSerial.REMOVE_PROPERTIES, argInventoryDocumentLineSerialProperty);
/*     */       }
/*     */     } 
/*     */   }
/*     */   
/*     */   public void setParentLineItem(IInventoryDocumentLineItem argParentLineItem) {
/* 590 */     this._parentLineItem = argParentLineItem;
/*     */   }
/*     */   
/*     */   public IInventoryDocumentLineItem getParentLineItem() {
/* 594 */     return this._parentLineItem;
/*     */   }
/*     */ 
/*     */   
/*     */   public Object getValue(String argFieldId) {
/* 599 */     if ("Properties".equals(argFieldId)) {
/* 600 */       return getProperties();
/*     */     }
/* 602 */     if ("InventoryDocumentLineSerialExtension".equals(argFieldId)) {
/* 603 */       return this._myExtension;
/*     */     }
/*     */     
/* 606 */     return super.getValue(argFieldId);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void setValue(String argFieldId, Object argValue) {
/* 612 */     if ("Properties".equals(argFieldId)) {
/* 613 */       setProperties(changeToList(argValue, IInventoryDocumentLineSerialProperty.class));
/*     */     }
/* 615 */     else if ("InventoryDocumentLineSerialExtension".equals(argFieldId)) {
/* 616 */       this._myExtension = (IDataModel)argValue;
/*     */     } else {
/*     */       
/* 619 */       super.setValue(argFieldId, argValue);
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public void setDependencies(IPersistenceDefaults argPD, EventManager argEM) {
/* 625 */     this._persistenceDefaults = argPD;
/* 626 */     this._daoImpl.setPersistenceDefaults(argPD);
/* 627 */     this._eventManager = argEM;
/* 628 */     this._events = (Eventor)new ModelEventor((IDataModel)this, argEM);
/* 629 */     this._eventCascade = (EventHandler)new CascadingHandler(this);
/* 630 */     if (this._properties != null) {
/* 631 */       for (IInventoryDocumentLineSerialProperty relationship : this._properties) {
/* 632 */         ((IDataModelImpl)relationship).setDependencies(argPD, argEM);
/*     */       }
/*     */     }
/*     */   }
/*     */   
/*     */   public IDataModel getInventoryDocumentLineSerialExt() {
/* 638 */     return this._myExtension;
/*     */   }
/*     */   
/*     */   public void setInventoryDocumentLineSerialExt(IDataModel argExt) {
/* 642 */     this._myExtension = argExt;
/*     */   }
/*     */ 
/*     */   
/*     */   public void startTransaction() {
/* 647 */     if (this._alreadyInStart) {
/*     */       return;
/*     */     }
/*     */     
/* 651 */     this._alreadyInStart = true;
/*     */ 
/*     */     
/* 654 */     super.startTransaction();
/*     */     
/* 656 */     this._propertiesSavepoint = this._properties;
/* 657 */     if (this._properties != null) {
/* 658 */       this._propertiesSavepoint = new HistoricalList((List)this._properties);
/* 659 */       Iterator<IDataModel> it = this._properties.iterator();
/* 660 */       while (it.hasNext()) {
/* 661 */         ((IDataModel)it.next()).startTransaction();
/*     */       }
/*     */     } 
/*     */ 
/*     */     
/* 666 */     this._alreadyInStart = false;
/*     */   }
/*     */ 
/*     */   
/*     */   public void rollbackChanges() {
/* 671 */     if (isAlreadyRolledBack()) {
/*     */       return;
/*     */     }
/* 674 */     super.rollbackChanges();
/*     */     
/* 676 */     this._properties = this._propertiesSavepoint;
/* 677 */     this._propertiesSavepoint = null;
/* 678 */     if (this._properties != null) {
/* 679 */       Iterator<IDataModel> it = this._properties.iterator();
/* 680 */       while (it.hasNext()) {
/* 681 */         ((IDataModel)it.next()).rollbackChanges();
/*     */       }
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void commitTransaction() {
/* 689 */     if (this._alreadyInCommit) {
/*     */       return;
/*     */     }
/* 692 */     this._alreadyInCommit = true;
/*     */ 
/*     */     
/* 695 */     super.commitTransaction();
/*     */     
/* 697 */     this._propertiesSavepoint = this._properties;
/* 698 */     if (this._properties != null) {
/* 699 */       Iterator<IDataModel> it = this._properties.iterator();
/* 700 */       while (it.hasNext()) {
/* 701 */         ((IDataModel)it.next()).commitTransaction();
/*     */       }
/* 703 */       this._properties = new HistoricalList((List)this._properties);
/*     */     } 
/*     */ 
/*     */     
/* 707 */     this._alreadyInCommit = false;
/*     */   }
/*     */ 
/*     */   
/*     */   private void readObject(ObjectInputStream argStream) throws IOException, ClassNotFoundException {
/* 712 */     argStream.defaultReadObject();
/*     */   }
/*     */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\inv\impl\InventoryDocumentLineSerialModel.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */