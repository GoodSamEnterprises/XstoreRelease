/*     */ package dtv.xst.dao.xom.impl;
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
/*     */ import dtv.xst.dao.xom.CustomizationModifierPropertyId;
/*     */ import dtv.xst.dao.xom.ICustomizationModifier;
/*     */ import dtv.xst.dao.xom.ICustomizationModifierProperty;
/*     */ import dtv.xst.dao.xom.IOrderLine;
/*     */ import java.io.IOException;
/*     */ import java.io.ObjectInputStream;
/*     */ import java.util.Date;
/*     */ import java.util.Iterator;
/*     */ import java.util.List;
/*     */ 
/*     */ public class CustomizationModifierModel extends AbstractDataModelWithPropertyImpl<ICustomizationModifierProperty> implements ICustomizationModifier {
/*     */   private static final long serialVersionUID = -1871520854L;
/*     */   private IOrderLine _parentOrderLine;
/*     */   private transient boolean _alreadyInStart = false;
/*     */   
/*     */   public String toString() {
/*  35 */     return super.toString() + " Id: " + getObjectId();
/*     */   }
/*     */   private transient boolean _alreadyInCommit = false; private IDataModel _myExtension; private HistoricalList<ICustomizationModifierProperty> _properties; private transient HistoricalList<ICustomizationModifierProperty> _propertiesSavepoint;
/*     */   
/*     */   public void initDAO() {
/*  40 */     setDAO((IDataAccessObject)new CustomizationModifierDAO());
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private CustomizationModifierDAO getDAO_() {
/*  48 */     return (CustomizationModifierDAO)this._daoImpl;
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
/*  72 */       this._events.post(ICustomizationModifier.SET_ORGANIZATIONID, Long.valueOf(argOrganizationId));
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
/*  87 */         Iterator<CustomizationModifierPropertyModel> it = this._properties.iterator();
/*  88 */         while (it.hasNext())
/*     */         {
/*  90 */           ((CustomizationModifierPropertyModel)it.next()).setOrganizationId_noev(argOrganizationId);
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
/*     */   public String getOrderId() {
/* 103 */     return getDAO_().getOrderId();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setOrderId(String argOrderId) {
/* 111 */     if (setOrderId_noev(argOrderId) && 
/* 112 */       this._events != null && 
/* 113 */       postEventsForChanges()) {
/* 114 */       this._events.post(ICustomizationModifier.SET_ORDERID, argOrderId);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setOrderId_noev(String argOrderId) {
/* 121 */     boolean ev_postable = false;
/*     */     
/* 123 */     if ((getDAO_().getOrderId() == null && argOrderId != null) || (
/* 124 */       getDAO_().getOrderId() != null && !getDAO_().getOrderId().equals(argOrderId))) {
/* 125 */       getDAO_().setOrderId(argOrderId);
/* 126 */       ev_postable = true;
/* 127 */       if (this._properties != null) {
/*     */         
/* 129 */         Iterator<CustomizationModifierPropertyModel> it = this._properties.iterator();
/* 130 */         while (it.hasNext())
/*     */         {
/* 132 */           ((CustomizationModifierPropertyModel)it.next()).setOrderId_noev(argOrderId);
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
/*     */   public int getSequence() {
/* 145 */     if (getDAO_().getSequence() != null) {
/* 146 */       return getDAO_().getSequence().intValue();
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
/*     */   public void setSequence(int argSequence) {
/* 158 */     if (setSequence_noev(argSequence) && 
/* 159 */       this._events != null && 
/* 160 */       postEventsForChanges()) {
/* 161 */       this._events.post(ICustomizationModifier.SET_SEQUENCE, Integer.valueOf(argSequence));
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setSequence_noev(int argSequence) {
/* 168 */     boolean ev_postable = false;
/*     */     
/* 170 */     if ((getDAO_().getSequence() == null && Integer.valueOf(argSequence) != null) || (
/* 171 */       getDAO_().getSequence() != null && !getDAO_().getSequence().equals(Integer.valueOf(argSequence)))) {
/* 172 */       getDAO_().setSequence(Integer.valueOf(argSequence));
/* 173 */       ev_postable = true;
/* 174 */       if (this._properties != null) {
/*     */         
/* 176 */         Iterator<CustomizationModifierPropertyModel> it = this._properties.iterator();
/* 177 */         while (it.hasNext())
/*     */         {
/* 179 */           ((CustomizationModifierPropertyModel)it.next()).setSequence_noev(argSequence);
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
/*     */   public int getModSequence() {
/* 192 */     if (getDAO_().getModSequence() != null) {
/* 193 */       return getDAO_().getModSequence().intValue();
/*     */     }
/*     */     
/* 196 */     return 0;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setModSequence(int argModSequence) {
/* 205 */     if (setModSequence_noev(argModSequence) && 
/* 206 */       this._events != null && 
/* 207 */       postEventsForChanges()) {
/* 208 */       this._events.post(ICustomizationModifier.SET_MODSEQUENCE, Integer.valueOf(argModSequence));
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setModSequence_noev(int argModSequence) {
/* 215 */     boolean ev_postable = false;
/*     */     
/* 217 */     if ((getDAO_().getModSequence() == null && Integer.valueOf(argModSequence) != null) || (
/* 218 */       getDAO_().getModSequence() != null && !getDAO_().getModSequence().equals(Integer.valueOf(argModSequence)))) {
/* 219 */       getDAO_().setModSequence(Integer.valueOf(argModSequence));
/* 220 */       ev_postable = true;
/* 221 */       if (this._properties != null) {
/*     */         
/* 223 */         Iterator<CustomizationModifierPropertyModel> it = this._properties.iterator();
/* 224 */         while (it.hasNext())
/*     */         {
/* 226 */           ((CustomizationModifierPropertyModel)it.next()).setModSequence_noev(argModSequence);
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
/* 250 */       this._events.post(ICustomizationModifier.SET_CREATEDATE, argCreateDate);
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
/* 284 */       this._events.post(ICustomizationModifier.SET_CREATEUSERID, argCreateUserId);
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
/* 318 */       this._events.post(ICustomizationModifier.SET_UPDATEDATE, argUpdateDate);
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
/* 352 */       this._events.post(ICustomizationModifier.SET_UPDATEUSERID, argUpdateUserId);
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
/*     */   public String getCustomizationCode() {
/* 375 */     return getDAO_().getCustomizationCode();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setCustomizationCode(String argCustomizationCode) {
/* 383 */     if (setCustomizationCode_noev(argCustomizationCode) && 
/* 384 */       this._events != null && 
/* 385 */       postEventsForChanges()) {
/* 386 */       this._events.post(ICustomizationModifier.SET_CUSTOMIZATIONCODE, argCustomizationCode);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setCustomizationCode_noev(String argCustomizationCode) {
/* 393 */     boolean ev_postable = false;
/*     */     
/* 395 */     if ((getDAO_().getCustomizationCode() == null && argCustomizationCode != null) || (
/* 396 */       getDAO_().getCustomizationCode() != null && !getDAO_().getCustomizationCode().equals(argCustomizationCode))) {
/* 397 */       getDAO_().setCustomizationCode(argCustomizationCode);
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
/*     */   public String getCustomizationMessage() {
/* 409 */     return getDAO_().getCustomizationMessage();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setCustomizationMessage(String argCustomizationMessage) {
/* 417 */     if (setCustomizationMessage_noev(argCustomizationMessage) && 
/* 418 */       this._events != null && 
/* 419 */       postEventsForChanges()) {
/* 420 */       this._events.post(ICustomizationModifier.SET_CUSTOMIZATIONMESSAGE, argCustomizationMessage);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setCustomizationMessage_noev(String argCustomizationMessage) {
/* 427 */     boolean ev_postable = false;
/*     */     
/* 429 */     if ((getDAO_().getCustomizationMessage() == null && argCustomizationMessage != null) || (
/* 430 */       getDAO_().getCustomizationMessage() != null && !getDAO_().getCustomizationMessage().equals(argCustomizationMessage))) {
/* 431 */       getDAO_().setCustomizationMessage(argCustomizationMessage);
/* 432 */       ev_postable = true;
/*     */     } 
/*     */     
/* 435 */     return ev_postable;
/*     */   }
/*     */   
/*     */   protected ICustomizationModifierProperty newProperty(String argPropertyName) {
/* 439 */     CustomizationModifierPropertyId id = new CustomizationModifierPropertyId();
/*     */     
/* 441 */     id.setOrderId(getOrderId());
/* 442 */     id.setSequence(Integer.valueOf(getSequence()));
/* 443 */     id.setModSequence(Integer.valueOf(getModSequence()));
/* 444 */     id.setPropertyCode(argPropertyName);
/*     */     
/* 446 */     ICustomizationModifierProperty prop = (ICustomizationModifierProperty)DataFactory.getInstance().createNewObject((IObjectId)id, ICustomizationModifierProperty.class);
/* 447 */     return prop;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @Relationship(name = "Properties")
/*     */   public List<ICustomizationModifierProperty> getProperties() {
/* 456 */     if (this._properties == null) {
/* 457 */       this._properties = new HistoricalList(null);
/*     */     }
/* 459 */     return (List<ICustomizationModifierProperty>)this._properties;
/*     */   }
/*     */   
/*     */   public void setProperties(List<ICustomizationModifierProperty> argProperties) {
/* 463 */     if (this._properties == null) {
/* 464 */       this._properties = new HistoricalList(argProperties);
/*     */     } else {
/* 466 */       this._properties.setCurrentList(argProperties);
/*     */     } 
/*     */     
/* 469 */     for (ICustomizationModifierProperty child : this._properties) {
/* 470 */       CustomizationModifierPropertyModel model = (CustomizationModifierPropertyModel)child;
/* 471 */       model.setOrganizationId_noev(getOrganizationId());
/* 472 */       model.setOrderId_noev(getOrderId());
/* 473 */       model.setSequence_noev(getSequence());
/* 474 */       model.setModSequence_noev(getModSequence());
/* 475 */       if (child instanceof IDataModelImpl) {
/* 476 */         IDataAccessObject childDao = ((IDataModelImpl)child).getDAO();
/* 477 */         if (StringUtils.isEmpty(childDao.getOriginDataSource()) && 
/* 478 */           !StringUtils.isEmpty(getDAO().getOriginDataSource())) {
/* 479 */           childDao.setOriginDataSource(getDAO().getOriginDataSource());
/*     */         }
/*     */       } 
/* 482 */       if (postEventsForChanges()) {
/* 483 */         this._eventManager.registerEventHandler((IEventAware)this._eventCascade, (IEventSource)child);
/*     */       }
/*     */     } 
/*     */   }
/*     */   
/*     */   public void addCustomizationModifierProperty(ICustomizationModifierProperty argCustomizationModifierProperty) {
/* 489 */     if (this._properties == null) {
/* 490 */       this._properties = new HistoricalList(null);
/*     */     }
/* 492 */     argCustomizationModifierProperty.setOrganizationId(getOrganizationId());
/* 493 */     argCustomizationModifierProperty.setOrderId(getOrderId());
/* 494 */     argCustomizationModifierProperty.setSequence(getSequence());
/* 495 */     argCustomizationModifierProperty.setModSequence(getModSequence());
/* 496 */     if (argCustomizationModifierProperty instanceof IDataModelImpl) {
/* 497 */       IDataAccessObject childDao = ((IDataModelImpl)argCustomizationModifierProperty).getDAO();
/* 498 */       if (StringUtils.isEmpty(childDao.getOriginDataSource()) && 
/* 499 */         !StringUtils.isEmpty(getDAO().getOriginDataSource())) {
/* 500 */         childDao.setOriginDataSource(getDAO().getOriginDataSource());
/*     */       }
/*     */     } 
/*     */ 
/*     */     
/* 505 */     if (postEventsForChanges()) {
/* 506 */       this._eventManager.registerEventHandler((IEventAware)this._eventCascade, (IEventSource)new EventDescriptor(argCustomizationModifierProperty));
/*     */     }
/*     */     
/* 509 */     this._properties.add(argCustomizationModifierProperty);
/* 510 */     if (postEventsForChanges()) {
/* 511 */       this._events.post(ICustomizationModifier.ADD_PROPERTIES, argCustomizationModifierProperty);
/*     */     }
/*     */   }
/*     */   
/*     */   public void removeCustomizationModifierProperty(ICustomizationModifierProperty argCustomizationModifierProperty) {
/* 516 */     if (this._properties != null) {
/*     */       
/* 518 */       if (postEventsForChanges()) {
/* 519 */         this._eventManager.deregisterEventHandler((IEventAware)this._eventCascade, (IEventSource)new EventDescriptor(argCustomizationModifierProperty));
/*     */       }
/* 521 */       this._properties.remove(argCustomizationModifierProperty);
/* 522 */       if (postEventsForChanges()) {
/* 523 */         this._events.post(ICustomizationModifier.REMOVE_PROPERTIES, argCustomizationModifierProperty);
/*     */       }
/*     */     } 
/*     */   }
/*     */   
/*     */   public void setParentOrderLine(IOrderLine argParentOrderLine) {
/* 529 */     this._parentOrderLine = argParentOrderLine;
/*     */   }
/*     */   
/*     */   public IOrderLine getParentOrderLine() {
/* 533 */     return this._parentOrderLine;
/*     */   }
/*     */ 
/*     */   
/*     */   public Object getValue(String argFieldId) {
/* 538 */     if ("Properties".equals(argFieldId)) {
/* 539 */       return getProperties();
/*     */     }
/* 541 */     if ("CustomizationModifierExtension".equals(argFieldId)) {
/* 542 */       return this._myExtension;
/*     */     }
/*     */     
/* 545 */     return super.getValue(argFieldId);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void setValue(String argFieldId, Object argValue) {
/* 551 */     if ("Properties".equals(argFieldId)) {
/* 552 */       setProperties(changeToList(argValue, ICustomizationModifierProperty.class));
/*     */     }
/* 554 */     else if ("CustomizationModifierExtension".equals(argFieldId)) {
/* 555 */       this._myExtension = (IDataModel)argValue;
/*     */     } else {
/*     */       
/* 558 */       super.setValue(argFieldId, argValue);
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public void setDependencies(IPersistenceDefaults argPD, EventManager argEM) {
/* 564 */     this._persistenceDefaults = argPD;
/* 565 */     this._daoImpl.setPersistenceDefaults(argPD);
/* 566 */     this._eventManager = argEM;
/* 567 */     this._events = (Eventor)new ModelEventor((IDataModel)this, argEM);
/* 568 */     this._eventCascade = (EventHandler)new CascadingHandler(this);
/* 569 */     if (this._properties != null) {
/* 570 */       for (ICustomizationModifierProperty relationship : this._properties) {
/* 571 */         ((IDataModelImpl)relationship).setDependencies(argPD, argEM);
/*     */       }
/*     */     }
/*     */   }
/*     */   
/*     */   public IDataModel getCustomizationModifierExt() {
/* 577 */     return this._myExtension;
/*     */   }
/*     */   
/*     */   public void setCustomizationModifierExt(IDataModel argExt) {
/* 581 */     this._myExtension = argExt;
/*     */   }
/*     */ 
/*     */   
/*     */   public void startTransaction() {
/* 586 */     if (this._alreadyInStart) {
/*     */       return;
/*     */     }
/*     */     
/* 590 */     this._alreadyInStart = true;
/*     */ 
/*     */     
/* 593 */     super.startTransaction();
/*     */     
/* 595 */     this._propertiesSavepoint = this._properties;
/* 596 */     if (this._properties != null) {
/* 597 */       this._propertiesSavepoint = new HistoricalList((List)this._properties);
/* 598 */       Iterator<IDataModel> it = this._properties.iterator();
/* 599 */       while (it.hasNext()) {
/* 600 */         ((IDataModel)it.next()).startTransaction();
/*     */       }
/*     */     } 
/*     */ 
/*     */     
/* 605 */     this._alreadyInStart = false;
/*     */   }
/*     */ 
/*     */   
/*     */   public void rollbackChanges() {
/* 610 */     if (isAlreadyRolledBack()) {
/*     */       return;
/*     */     }
/* 613 */     super.rollbackChanges();
/*     */     
/* 615 */     this._properties = this._propertiesSavepoint;
/* 616 */     this._propertiesSavepoint = null;
/* 617 */     if (this._properties != null) {
/* 618 */       Iterator<IDataModel> it = this._properties.iterator();
/* 619 */       while (it.hasNext()) {
/* 620 */         ((IDataModel)it.next()).rollbackChanges();
/*     */       }
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void commitTransaction() {
/* 628 */     if (this._alreadyInCommit) {
/*     */       return;
/*     */     }
/* 631 */     this._alreadyInCommit = true;
/*     */ 
/*     */     
/* 634 */     super.commitTransaction();
/*     */     
/* 636 */     this._propertiesSavepoint = this._properties;
/* 637 */     if (this._properties != null) {
/* 638 */       Iterator<IDataModel> it = this._properties.iterator();
/* 639 */       while (it.hasNext()) {
/* 640 */         ((IDataModel)it.next()).commitTransaction();
/*     */       }
/* 642 */       this._properties = new HistoricalList((List)this._properties);
/*     */     } 
/*     */ 
/*     */     
/* 646 */     this._alreadyInCommit = false;
/*     */   }
/*     */ 
/*     */   
/*     */   private void readObject(ObjectInputStream argStream) throws IOException, ClassNotFoundException {
/* 651 */     argStream.defaultReadObject();
/*     */   }
/*     */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\xom\impl\CustomizationModifierModel.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */