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
/*     */ import dtv.xst.dao.inv.IInventoryItemAccountModifier;
/*     */ import dtv.xst.dao.inv.IInventoryItemAccountModifierProperty;
/*     */ import dtv.xst.dao.inv.InventoryItemAccountModifierPropertyId;
/*     */ import java.io.IOException;
/*     */ import java.io.ObjectInputStream;
/*     */ import java.util.Date;
/*     */ import java.util.Iterator;
/*     */ import java.util.List;
/*     */ 
/*     */ public class InventoryItemAccountModifierModel extends AbstractDataModelWithPropertyImpl<IInventoryItemAccountModifierProperty> implements IInventoryItemAccountModifier {
/*     */   private static final long serialVersionUID = 77985205L;
/*     */   private IInventoryDocumentLineItem _parentLine;
/*     */   private transient boolean _alreadyInStart = false;
/*     */   
/*     */   public String toString() {
/*  35 */     return super.toString() + " Id: " + getObjectId();
/*     */   }
/*     */   private transient boolean _alreadyInCommit = false; private IDataModel _myExtension; private HistoricalList<IInventoryItemAccountModifierProperty> _properties; private transient HistoricalList<IInventoryItemAccountModifierProperty> _propertiesSavepoint;
/*     */   
/*     */   public void initDAO() {
/*  40 */     setDAO((IDataAccessObject)new InventoryItemAccountModifierDAO());
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private InventoryItemAccountModifierDAO getDAO_() {
/*  48 */     return (InventoryItemAccountModifierDAO)this._daoImpl;
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
/*  72 */       this._events.post(IInventoryItemAccountModifier.SET_ORGANIZATIONID, Long.valueOf(argOrganizationId));
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
/*  87 */         Iterator<InventoryItemAccountModifierPropertyModel> it = this._properties.iterator();
/*  88 */         while (it.hasNext())
/*     */         {
/*  90 */           ((InventoryItemAccountModifierPropertyModel)it.next()).setOrganizationId_noev(argOrganizationId);
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
/*     */   public String getDocumentId() {
/* 103 */     return getDAO_().getDocumentId();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setDocumentId(String argDocumentId) {
/* 111 */     if (setDocumentId_noev(argDocumentId) && 
/* 112 */       this._events != null && 
/* 113 */       postEventsForChanges()) {
/* 114 */       this._events.post(IInventoryItemAccountModifier.SET_DOCUMENTID, argDocumentId);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setDocumentId_noev(String argDocumentId) {
/* 121 */     boolean ev_postable = false;
/*     */     
/* 123 */     if ((getDAO_().getDocumentId() == null && argDocumentId != null) || (
/* 124 */       getDAO_().getDocumentId() != null && !getDAO_().getDocumentId().equals(argDocumentId))) {
/* 125 */       getDAO_().setDocumentId(argDocumentId);
/* 126 */       ev_postable = true;
/* 127 */       if (this._properties != null) {
/*     */         
/* 129 */         Iterator<InventoryItemAccountModifierPropertyModel> it = this._properties.iterator();
/* 130 */         while (it.hasNext())
/*     */         {
/* 132 */           ((InventoryItemAccountModifierPropertyModel)it.next()).setDocumentId_noev(argDocumentId);
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
/*     */   public int getInventoryDocumentLineNumber() {
/* 145 */     if (getDAO_().getInventoryDocumentLineNumber() != null) {
/* 146 */       return getDAO_().getInventoryDocumentLineNumber().intValue();
/*     */     }
/*     */     
/* 149 */     return 0;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setInventoryDocumentLineNumber(int argInventoryDocumentLineNumber) {
/* 158 */     if (setInventoryDocumentLineNumber_noev(argInventoryDocumentLineNumber) && 
/* 159 */       this._events != null && 
/* 160 */       postEventsForChanges()) {
/* 161 */       this._events.post(IInventoryItemAccountModifier.SET_INVENTORYDOCUMENTLINENUMBER, Integer.valueOf(argInventoryDocumentLineNumber));
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setInventoryDocumentLineNumber_noev(int argInventoryDocumentLineNumber) {
/* 168 */     boolean ev_postable = false;
/*     */     
/* 170 */     if ((getDAO_().getInventoryDocumentLineNumber() == null && Integer.valueOf(argInventoryDocumentLineNumber) != null) || (
/* 171 */       getDAO_().getInventoryDocumentLineNumber() != null && !getDAO_().getInventoryDocumentLineNumber().equals(Integer.valueOf(argInventoryDocumentLineNumber)))) {
/* 172 */       getDAO_().setInventoryDocumentLineNumber(Integer.valueOf(argInventoryDocumentLineNumber));
/* 173 */       ev_postable = true;
/* 174 */       if (this._properties != null) {
/*     */         
/* 176 */         Iterator<InventoryItemAccountModifierPropertyModel> it = this._properties.iterator();
/* 177 */         while (it.hasNext())
/*     */         {
/* 179 */           ((InventoryItemAccountModifierPropertyModel)it.next()).setInventoryDocumentLineNumber_noev(argInventoryDocumentLineNumber);
/*     */         }
/*     */       } 
/*     */     } 
/*     */     
/* 184 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getDocumentTypeCode() {
/* 192 */     return getDAO_().getDocumentTypeCode();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setDocumentTypeCode(String argDocumentTypeCode) {
/* 200 */     if (setDocumentTypeCode_noev(argDocumentTypeCode) && 
/* 201 */       this._events != null && 
/* 202 */       postEventsForChanges()) {
/* 203 */       this._events.post(IInventoryItemAccountModifier.SET_DOCUMENTTYPECODE, argDocumentTypeCode);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setDocumentTypeCode_noev(String argDocumentTypeCode) {
/* 210 */     boolean ev_postable = false;
/*     */     
/* 212 */     if ((getDAO_().getDocumentTypeCode() == null && argDocumentTypeCode != null) || (
/* 213 */       getDAO_().getDocumentTypeCode() != null && !getDAO_().getDocumentTypeCode().equals(argDocumentTypeCode))) {
/* 214 */       getDAO_().setDocumentTypeCode(argDocumentTypeCode);
/* 215 */       ev_postable = true;
/* 216 */       if (this._properties != null) {
/*     */         
/* 218 */         Iterator<InventoryItemAccountModifierPropertyModel> it = this._properties.iterator();
/* 219 */         while (it.hasNext())
/*     */         {
/* 221 */           ((InventoryItemAccountModifierPropertyModel)it.next()).setDocumentTypeCode_noev(argDocumentTypeCode);
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
/* 250 */       this._events.post(IInventoryItemAccountModifier.SET_RETAILLOCATIONID, Long.valueOf(argRetailLocationId));
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
/* 265 */         Iterator<InventoryItemAccountModifierPropertyModel> it = this._properties.iterator();
/* 266 */         while (it.hasNext())
/*     */         {
/* 268 */           ((InventoryItemAccountModifierPropertyModel)it.next()).setRetailLocationId_noev(argRetailLocationId);
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
/*     */   public Date getCreateDate() {
/* 281 */     return getDAO_().getCreateDate();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setCreateDate(Date argCreateDate) {
/* 289 */     if (setCreateDate_noev(argCreateDate) && 
/* 290 */       this._events != null && 
/* 291 */       postEventsForChanges()) {
/* 292 */       this._events.post(IInventoryItemAccountModifier.SET_CREATEDATE, argCreateDate);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setCreateDate_noev(Date argCreateDate) {
/* 299 */     boolean ev_postable = false;
/*     */     
/* 301 */     if ((getDAO_().getCreateDate() == null && argCreateDate != null) || (
/* 302 */       getDAO_().getCreateDate() != null && !getDAO_().getCreateDate().equals(argCreateDate))) {
/* 303 */       getDAO_().setCreateDate(argCreateDate);
/* 304 */       ev_postable = true;
/*     */     } 
/*     */     
/* 307 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getCreateUserId() {
/* 315 */     return getDAO_().getCreateUserId();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setCreateUserId(String argCreateUserId) {
/* 323 */     if (setCreateUserId_noev(argCreateUserId) && 
/* 324 */       this._events != null && 
/* 325 */       postEventsForChanges()) {
/* 326 */       this._events.post(IInventoryItemAccountModifier.SET_CREATEUSERID, argCreateUserId);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setCreateUserId_noev(String argCreateUserId) {
/* 333 */     boolean ev_postable = false;
/*     */     
/* 335 */     if ((getDAO_().getCreateUserId() == null && argCreateUserId != null) || (
/* 336 */       getDAO_().getCreateUserId() != null && !getDAO_().getCreateUserId().equals(argCreateUserId))) {
/* 337 */       getDAO_().setCreateUserId(argCreateUserId);
/* 338 */       ev_postable = true;
/*     */     } 
/*     */     
/* 341 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Date getUpdateDate() {
/* 349 */     return getDAO_().getUpdateDate();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setUpdateDate(Date argUpdateDate) {
/* 357 */     if (setUpdateDate_noev(argUpdateDate) && 
/* 358 */       this._events != null && 
/* 359 */       postEventsForChanges()) {
/* 360 */       this._events.post(IInventoryItemAccountModifier.SET_UPDATEDATE, argUpdateDate);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setUpdateDate_noev(Date argUpdateDate) {
/* 367 */     boolean ev_postable = false;
/*     */     
/* 369 */     if ((getDAO_().getUpdateDate() == null && argUpdateDate != null) || (
/* 370 */       getDAO_().getUpdateDate() != null && !getDAO_().getUpdateDate().equals(argUpdateDate))) {
/* 371 */       getDAO_().setUpdateDate(argUpdateDate);
/* 372 */       ev_postable = true;
/*     */     } 
/*     */     
/* 375 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getUpdateUserId() {
/* 383 */     return getDAO_().getUpdateUserId();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setUpdateUserId(String argUpdateUserId) {
/* 391 */     if (setUpdateUserId_noev(argUpdateUserId) && 
/* 392 */       this._events != null && 
/* 393 */       postEventsForChanges()) {
/* 394 */       this._events.post(IInventoryItemAccountModifier.SET_UPDATEUSERID, argUpdateUserId);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setUpdateUserId_noev(String argUpdateUserId) {
/* 401 */     boolean ev_postable = false;
/*     */     
/* 403 */     if ((getDAO_().getUpdateUserId() == null && argUpdateUserId != null) || (
/* 404 */       getDAO_().getUpdateUserId() != null && !getDAO_().getUpdateUserId().equals(argUpdateUserId))) {
/* 405 */       getDAO_().setUpdateUserId(argUpdateUserId);
/* 406 */       ev_postable = true;
/*     */     } 
/*     */     
/* 409 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getCustAccountCode() {
/* 417 */     return getDAO_().getCustAccountCode();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setCustAccountCode(String argCustAccountCode) {
/* 425 */     if (setCustAccountCode_noev(argCustAccountCode) && 
/* 426 */       this._events != null && 
/* 427 */       postEventsForChanges()) {
/* 428 */       this._events.post(IInventoryItemAccountModifier.SET_CUSTACCOUNTCODE, argCustAccountCode);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setCustAccountCode_noev(String argCustAccountCode) {
/* 435 */     boolean ev_postable = false;
/*     */     
/* 437 */     if ((getDAO_().getCustAccountCode() == null && argCustAccountCode != null) || (
/* 438 */       getDAO_().getCustAccountCode() != null && !getDAO_().getCustAccountCode().equals(argCustAccountCode))) {
/* 439 */       getDAO_().setCustAccountCode(argCustAccountCode);
/* 440 */       ev_postable = true;
/*     */     } 
/*     */     
/* 443 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getCustAccountId() {
/* 451 */     return getDAO_().getCustAccountId();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setCustAccountId(String argCustAccountId) {
/* 459 */     if (setCustAccountId_noev(argCustAccountId) && 
/* 460 */       this._events != null && 
/* 461 */       postEventsForChanges()) {
/* 462 */       this._events.post(IInventoryItemAccountModifier.SET_CUSTACCOUNTID, argCustAccountId);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setCustAccountId_noev(String argCustAccountId) {
/* 469 */     boolean ev_postable = false;
/*     */     
/* 471 */     if ((getDAO_().getCustAccountId() == null && argCustAccountId != null) || (
/* 472 */       getDAO_().getCustAccountId() != null && !getDAO_().getCustAccountId().equals(argCustAccountId))) {
/* 473 */       getDAO_().setCustAccountId(argCustAccountId);
/* 474 */       ev_postable = true;
/*     */     } 
/*     */     
/* 477 */     return ev_postable;
/*     */   }
/*     */   
/*     */   protected IInventoryItemAccountModifierProperty newProperty(String argPropertyName) {
/* 481 */     InventoryItemAccountModifierPropertyId id = new InventoryItemAccountModifierPropertyId();
/*     */     
/* 483 */     id.setDocumentId(getDocumentId());
/* 484 */     id.setInventoryDocumentLineNumber(Integer.valueOf(getInventoryDocumentLineNumber()));
/* 485 */     id.setDocumentTypeCode(getDocumentTypeCode());
/* 486 */     id.setRetailLocationId(Long.valueOf(getRetailLocationId()));
/* 487 */     id.setPropertyCode(argPropertyName);
/*     */     
/* 489 */     IInventoryItemAccountModifierProperty prop = (IInventoryItemAccountModifierProperty)DataFactory.getInstance().createNewObject((IObjectId)id, IInventoryItemAccountModifierProperty.class);
/* 490 */     return prop;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @Relationship(name = "Properties")
/*     */   public List<IInventoryItemAccountModifierProperty> getProperties() {
/* 499 */     if (this._properties == null) {
/* 500 */       this._properties = new HistoricalList(null);
/*     */     }
/* 502 */     return (List<IInventoryItemAccountModifierProperty>)this._properties;
/*     */   }
/*     */   
/*     */   public void setProperties(List<IInventoryItemAccountModifierProperty> argProperties) {
/* 506 */     if (this._properties == null) {
/* 507 */       this._properties = new HistoricalList(argProperties);
/*     */     } else {
/* 509 */       this._properties.setCurrentList(argProperties);
/*     */     } 
/*     */     
/* 512 */     for (IInventoryItemAccountModifierProperty child : this._properties) {
/* 513 */       InventoryItemAccountModifierPropertyModel model = (InventoryItemAccountModifierPropertyModel)child;
/* 514 */       model.setOrganizationId_noev(getOrganizationId());
/* 515 */       model.setDocumentId_noev(getDocumentId());
/* 516 */       model.setInventoryDocumentLineNumber_noev(getInventoryDocumentLineNumber());
/* 517 */       model.setDocumentTypeCode_noev(getDocumentTypeCode());
/* 518 */       model.setRetailLocationId_noev(getRetailLocationId());
/* 519 */       if (child instanceof IDataModelImpl) {
/* 520 */         IDataAccessObject childDao = ((IDataModelImpl)child).getDAO();
/* 521 */         if (StringUtils.isEmpty(childDao.getOriginDataSource()) && 
/* 522 */           !StringUtils.isEmpty(getDAO().getOriginDataSource())) {
/* 523 */           childDao.setOriginDataSource(getDAO().getOriginDataSource());
/*     */         }
/*     */       } 
/* 526 */       if (postEventsForChanges()) {
/* 527 */         this._eventManager.registerEventHandler((IEventAware)this._eventCascade, (IEventSource)child);
/*     */       }
/*     */     } 
/*     */   }
/*     */   
/*     */   public void addInventoryItemAccountModifierProperty(IInventoryItemAccountModifierProperty argInventoryItemAccountModifierProperty) {
/* 533 */     if (this._properties == null) {
/* 534 */       this._properties = new HistoricalList(null);
/*     */     }
/* 536 */     argInventoryItemAccountModifierProperty.setOrganizationId(getOrganizationId());
/* 537 */     argInventoryItemAccountModifierProperty.setDocumentId(getDocumentId());
/* 538 */     argInventoryItemAccountModifierProperty.setInventoryDocumentLineNumber(getInventoryDocumentLineNumber());
/* 539 */     argInventoryItemAccountModifierProperty.setDocumentTypeCode(getDocumentTypeCode());
/* 540 */     argInventoryItemAccountModifierProperty.setRetailLocationId(getRetailLocationId());
/* 541 */     if (argInventoryItemAccountModifierProperty instanceof IDataModelImpl) {
/* 542 */       IDataAccessObject childDao = ((IDataModelImpl)argInventoryItemAccountModifierProperty).getDAO();
/* 543 */       if (StringUtils.isEmpty(childDao.getOriginDataSource()) && 
/* 544 */         !StringUtils.isEmpty(getDAO().getOriginDataSource())) {
/* 545 */         childDao.setOriginDataSource(getDAO().getOriginDataSource());
/*     */       }
/*     */     } 
/*     */ 
/*     */     
/* 550 */     if (postEventsForChanges()) {
/* 551 */       this._eventManager.registerEventHandler((IEventAware)this._eventCascade, (IEventSource)new EventDescriptor(argInventoryItemAccountModifierProperty));
/*     */     }
/*     */     
/* 554 */     this._properties.add(argInventoryItemAccountModifierProperty);
/* 555 */     if (postEventsForChanges()) {
/* 556 */       this._events.post(IInventoryItemAccountModifier.ADD_PROPERTIES, argInventoryItemAccountModifierProperty);
/*     */     }
/*     */   }
/*     */   
/*     */   public void removeInventoryItemAccountModifierProperty(IInventoryItemAccountModifierProperty argInventoryItemAccountModifierProperty) {
/* 561 */     if (this._properties != null) {
/*     */       
/* 563 */       if (postEventsForChanges()) {
/* 564 */         this._eventManager.deregisterEventHandler((IEventAware)this._eventCascade, (IEventSource)new EventDescriptor(argInventoryItemAccountModifierProperty));
/*     */       }
/* 566 */       this._properties.remove(argInventoryItemAccountModifierProperty);
/* 567 */       if (postEventsForChanges()) {
/* 568 */         this._events.post(IInventoryItemAccountModifier.REMOVE_PROPERTIES, argInventoryItemAccountModifierProperty);
/*     */       }
/*     */     } 
/*     */   }
/*     */   
/*     */   public void setParentLine(IInventoryDocumentLineItem argParentLine) {
/* 574 */     this._parentLine = argParentLine;
/*     */   }
/*     */   
/*     */   public IInventoryDocumentLineItem getParentLine() {
/* 578 */     return this._parentLine;
/*     */   }
/*     */ 
/*     */   
/*     */   public Object getValue(String argFieldId) {
/* 583 */     if ("Properties".equals(argFieldId)) {
/* 584 */       return getProperties();
/*     */     }
/* 586 */     if ("InventoryItemAccountModifierExtension".equals(argFieldId)) {
/* 587 */       return this._myExtension;
/*     */     }
/*     */     
/* 590 */     return super.getValue(argFieldId);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void setValue(String argFieldId, Object argValue) {
/* 596 */     if ("Properties".equals(argFieldId)) {
/* 597 */       setProperties(changeToList(argValue, IInventoryItemAccountModifierProperty.class));
/*     */     }
/* 599 */     else if ("InventoryItemAccountModifierExtension".equals(argFieldId)) {
/* 600 */       this._myExtension = (IDataModel)argValue;
/*     */     } else {
/*     */       
/* 603 */       super.setValue(argFieldId, argValue);
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public void setDependencies(IPersistenceDefaults argPD, EventManager argEM) {
/* 609 */     this._persistenceDefaults = argPD;
/* 610 */     this._daoImpl.setPersistenceDefaults(argPD);
/* 611 */     this._eventManager = argEM;
/* 612 */     this._events = (Eventor)new ModelEventor((IDataModel)this, argEM);
/* 613 */     this._eventCascade = (EventHandler)new CascadingHandler(this);
/* 614 */     if (this._properties != null) {
/* 615 */       for (IInventoryItemAccountModifierProperty relationship : this._properties) {
/* 616 */         ((IDataModelImpl)relationship).setDependencies(argPD, argEM);
/*     */       }
/*     */     }
/*     */   }
/*     */   
/*     */   public IDataModel getInventoryItemAccountModifierExt() {
/* 622 */     return this._myExtension;
/*     */   }
/*     */   
/*     */   public void setInventoryItemAccountModifierExt(IDataModel argExt) {
/* 626 */     this._myExtension = argExt;
/*     */   }
/*     */ 
/*     */   
/*     */   public void startTransaction() {
/* 631 */     if (this._alreadyInStart) {
/*     */       return;
/*     */     }
/*     */     
/* 635 */     this._alreadyInStart = true;
/*     */ 
/*     */     
/* 638 */     super.startTransaction();
/*     */     
/* 640 */     this._propertiesSavepoint = this._properties;
/* 641 */     if (this._properties != null) {
/* 642 */       this._propertiesSavepoint = new HistoricalList((List)this._properties);
/* 643 */       Iterator<IDataModel> it = this._properties.iterator();
/* 644 */       while (it.hasNext()) {
/* 645 */         ((IDataModel)it.next()).startTransaction();
/*     */       }
/*     */     } 
/*     */ 
/*     */     
/* 650 */     this._alreadyInStart = false;
/*     */   }
/*     */ 
/*     */   
/*     */   public void rollbackChanges() {
/* 655 */     if (isAlreadyRolledBack()) {
/*     */       return;
/*     */     }
/* 658 */     super.rollbackChanges();
/*     */     
/* 660 */     this._properties = this._propertiesSavepoint;
/* 661 */     this._propertiesSavepoint = null;
/* 662 */     if (this._properties != null) {
/* 663 */       Iterator<IDataModel> it = this._properties.iterator();
/* 664 */       while (it.hasNext()) {
/* 665 */         ((IDataModel)it.next()).rollbackChanges();
/*     */       }
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void commitTransaction() {
/* 673 */     if (this._alreadyInCommit) {
/*     */       return;
/*     */     }
/* 676 */     this._alreadyInCommit = true;
/*     */ 
/*     */     
/* 679 */     super.commitTransaction();
/*     */     
/* 681 */     this._propertiesSavepoint = this._properties;
/* 682 */     if (this._properties != null) {
/* 683 */       Iterator<IDataModel> it = this._properties.iterator();
/* 684 */       while (it.hasNext()) {
/* 685 */         ((IDataModel)it.next()).commitTransaction();
/*     */       }
/* 687 */       this._properties = new HistoricalList((List)this._properties);
/*     */     } 
/*     */ 
/*     */     
/* 691 */     this._alreadyInCommit = false;
/*     */   }
/*     */ 
/*     */   
/*     */   private void readObject(ObjectInputStream argStream) throws IOException, ClassNotFoundException {
/* 696 */     argStream.defaultReadObject();
/*     */   }
/*     */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\inv\impl\InventoryItemAccountModifierModel.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */