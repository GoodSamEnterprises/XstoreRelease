/*     */ package dtv.xst.dao.dsc.impl;
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
/*     */ import dtv.xst.dao.dsc.DiscountGroupMappingPropertyId;
/*     */ import dtv.xst.dao.dsc.IDiscountGroupMapping;
/*     */ import dtv.xst.dao.dsc.IDiscountGroupMappingProperty;
/*     */ import java.io.IOException;
/*     */ import java.io.ObjectInputStream;
/*     */ import java.util.Date;
/*     */ import java.util.Iterator;
/*     */ import java.util.List;
/*     */ 
/*     */ public class DiscountGroupMappingModel extends AbstractDataModelWithPropertyImpl<IDiscountGroupMappingProperty> implements IDiscountGroupMapping {
/*     */   private static final long serialVersionUID = -2010226352L;
/*     */   private transient boolean _alreadyInStart = false;
/*     */   private transient boolean _alreadyInCommit = false;
/*     */   
/*     */   public String toString() {
/*  33 */     return super.toString() + " Id: " + getObjectId();
/*     */   }
/*     */   private IDataModel _myExtension; private HistoricalList<IDiscountGroupMappingProperty> _properties; private transient HistoricalList<IDiscountGroupMappingProperty> _propertiesSavepoint;
/*     */   
/*     */   public void initDAO() {
/*  38 */     setDAO((IDataAccessObject)new DiscountGroupMappingDAO());
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private DiscountGroupMappingDAO getDAO_() {
/*  46 */     return (DiscountGroupMappingDAO)this._daoImpl;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getCustomerGroupId() {
/*  54 */     return getDAO_().getCustomerGroupId();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setCustomerGroupId(String argCustomerGroupId) {
/*  62 */     if (setCustomerGroupId_noev(argCustomerGroupId) && 
/*  63 */       this._events != null && 
/*  64 */       postEventsForChanges()) {
/*  65 */       this._events.post(IDiscountGroupMapping.SET_CUSTOMERGROUPID, argCustomerGroupId);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setCustomerGroupId_noev(String argCustomerGroupId) {
/*  72 */     boolean ev_postable = false;
/*     */     
/*  74 */     if ((getDAO_().getCustomerGroupId() == null && argCustomerGroupId != null) || (
/*  75 */       getDAO_().getCustomerGroupId() != null && !getDAO_().getCustomerGroupId().equals(argCustomerGroupId))) {
/*  76 */       getDAO_().setCustomerGroupId(argCustomerGroupId);
/*  77 */       ev_postable = true;
/*  78 */       if (this._properties != null) {
/*     */         
/*  80 */         Iterator<DiscountGroupMappingPropertyModel> it = this._properties.iterator();
/*  81 */         while (it.hasNext())
/*     */         {
/*  83 */           ((DiscountGroupMappingPropertyModel)it.next()).setCustomerGroupId_noev(argCustomerGroupId);
/*     */         }
/*     */       } 
/*     */     } 
/*     */     
/*  88 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getDiscountCode() {
/*  96 */     return getDAO_().getDiscountCode();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setDiscountCode(String argDiscountCode) {
/* 104 */     if (setDiscountCode_noev(argDiscountCode) && 
/* 105 */       this._events != null && 
/* 106 */       postEventsForChanges()) {
/* 107 */       this._events.post(IDiscountGroupMapping.SET_DISCOUNTCODE, argDiscountCode);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setDiscountCode_noev(String argDiscountCode) {
/* 114 */     boolean ev_postable = false;
/*     */     
/* 116 */     if ((getDAO_().getDiscountCode() == null && argDiscountCode != null) || (
/* 117 */       getDAO_().getDiscountCode() != null && !getDAO_().getDiscountCode().equals(argDiscountCode))) {
/* 118 */       getDAO_().setDiscountCode(argDiscountCode);
/* 119 */       ev_postable = true;
/* 120 */       if (this._properties != null) {
/*     */         
/* 122 */         Iterator<DiscountGroupMappingPropertyModel> it = this._properties.iterator();
/* 123 */         while (it.hasNext())
/*     */         {
/* 125 */           ((DiscountGroupMappingPropertyModel)it.next()).setDiscountCode_noev(argDiscountCode);
/*     */         }
/*     */       } 
/*     */     } 
/*     */     
/* 130 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public long getOrganizationId() {
/* 138 */     if (getDAO_().getOrganizationId() != null) {
/* 139 */       return getDAO_().getOrganizationId().longValue();
/*     */     }
/*     */     
/* 142 */     return 0L;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setOrganizationId(long argOrganizationId) {
/* 151 */     if (setOrganizationId_noev(argOrganizationId) && 
/* 152 */       this._events != null && 
/* 153 */       postEventsForChanges()) {
/* 154 */       this._events.post(IDiscountGroupMapping.SET_ORGANIZATIONID, Long.valueOf(argOrganizationId));
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setOrganizationId_noev(long argOrganizationId) {
/* 161 */     boolean ev_postable = false;
/*     */     
/* 163 */     if ((getDAO_().getOrganizationId() == null && Long.valueOf(argOrganizationId) != null) || (
/* 164 */       getDAO_().getOrganizationId() != null && !getDAO_().getOrganizationId().equals(Long.valueOf(argOrganizationId)))) {
/* 165 */       getDAO_().setOrganizationId(Long.valueOf(argOrganizationId));
/* 166 */       ev_postable = true;
/* 167 */       if (this._properties != null) {
/*     */         
/* 169 */         Iterator<DiscountGroupMappingPropertyModel> it = this._properties.iterator();
/* 170 */         while (it.hasNext())
/*     */         {
/* 172 */           ((DiscountGroupMappingPropertyModel)it.next()).setOrganizationId_noev(argOrganizationId);
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
/*     */   public Date getCreateDate() {
/* 185 */     return getDAO_().getCreateDate();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setCreateDate(Date argCreateDate) {
/* 193 */     if (setCreateDate_noev(argCreateDate) && 
/* 194 */       this._events != null && 
/* 195 */       postEventsForChanges()) {
/* 196 */       this._events.post(IDiscountGroupMapping.SET_CREATEDATE, argCreateDate);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setCreateDate_noev(Date argCreateDate) {
/* 203 */     boolean ev_postable = false;
/*     */     
/* 205 */     if ((getDAO_().getCreateDate() == null && argCreateDate != null) || (
/* 206 */       getDAO_().getCreateDate() != null && !getDAO_().getCreateDate().equals(argCreateDate))) {
/* 207 */       getDAO_().setCreateDate(argCreateDate);
/* 208 */       ev_postable = true;
/*     */     } 
/*     */     
/* 211 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getCreateUserId() {
/* 219 */     return getDAO_().getCreateUserId();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setCreateUserId(String argCreateUserId) {
/* 227 */     if (setCreateUserId_noev(argCreateUserId) && 
/* 228 */       this._events != null && 
/* 229 */       postEventsForChanges()) {
/* 230 */       this._events.post(IDiscountGroupMapping.SET_CREATEUSERID, argCreateUserId);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setCreateUserId_noev(String argCreateUserId) {
/* 237 */     boolean ev_postable = false;
/*     */     
/* 239 */     if ((getDAO_().getCreateUserId() == null && argCreateUserId != null) || (
/* 240 */       getDAO_().getCreateUserId() != null && !getDAO_().getCreateUserId().equals(argCreateUserId))) {
/* 241 */       getDAO_().setCreateUserId(argCreateUserId);
/* 242 */       ev_postable = true;
/*     */     } 
/*     */     
/* 245 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Date getUpdateDate() {
/* 253 */     return getDAO_().getUpdateDate();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setUpdateDate(Date argUpdateDate) {
/* 261 */     if (setUpdateDate_noev(argUpdateDate) && 
/* 262 */       this._events != null && 
/* 263 */       postEventsForChanges()) {
/* 264 */       this._events.post(IDiscountGroupMapping.SET_UPDATEDATE, argUpdateDate);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setUpdateDate_noev(Date argUpdateDate) {
/* 271 */     boolean ev_postable = false;
/*     */     
/* 273 */     if ((getDAO_().getUpdateDate() == null && argUpdateDate != null) || (
/* 274 */       getDAO_().getUpdateDate() != null && !getDAO_().getUpdateDate().equals(argUpdateDate))) {
/* 275 */       getDAO_().setUpdateDate(argUpdateDate);
/* 276 */       ev_postable = true;
/*     */     } 
/*     */     
/* 279 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getUpdateUserId() {
/* 287 */     return getDAO_().getUpdateUserId();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setUpdateUserId(String argUpdateUserId) {
/* 295 */     if (setUpdateUserId_noev(argUpdateUserId) && 
/* 296 */       this._events != null && 
/* 297 */       postEventsForChanges()) {
/* 298 */       this._events.post(IDiscountGroupMapping.SET_UPDATEUSERID, argUpdateUserId);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setUpdateUserId_noev(String argUpdateUserId) {
/* 305 */     boolean ev_postable = false;
/*     */     
/* 307 */     if ((getDAO_().getUpdateUserId() == null && argUpdateUserId != null) || (
/* 308 */       getDAO_().getUpdateUserId() != null && !getDAO_().getUpdateUserId().equals(argUpdateUserId))) {
/* 309 */       getDAO_().setUpdateUserId(argUpdateUserId);
/* 310 */       ev_postable = true;
/*     */     } 
/*     */     
/* 313 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getConfigElement() {
/* 321 */     return getDAO_().getConfigElement();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setConfigElement(String argConfigElement) {
/* 329 */     if (setConfigElement_noev(argConfigElement) && 
/* 330 */       this._events != null && 
/* 331 */       postEventsForChanges()) {
/* 332 */       this._events.post(IDiscountGroupMapping.SET_CONFIGELEMENT, argConfigElement);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setConfigElement_noev(String argConfigElement) {
/* 339 */     boolean ev_postable = false;
/*     */     
/* 341 */     if ((getDAO_().getConfigElement() == null && argConfigElement != null) || (
/* 342 */       getDAO_().getConfigElement() != null && !getDAO_().getConfigElement().equals(argConfigElement))) {
/* 343 */       getDAO_().setConfigElement(argConfigElement);
/* 344 */       ev_postable = true;
/*     */     } 
/*     */     
/* 347 */     return ev_postable;
/*     */   }
/*     */   
/*     */   protected IDiscountGroupMappingProperty newProperty(String argPropertyName) {
/* 351 */     DiscountGroupMappingPropertyId id = new DiscountGroupMappingPropertyId();
/*     */     
/* 353 */     id.setCustomerGroupId(getCustomerGroupId());
/* 354 */     id.setDiscountCode(getDiscountCode());
/* 355 */     id.setPropertyCode(argPropertyName);
/*     */     
/* 357 */     IDiscountGroupMappingProperty prop = (IDiscountGroupMappingProperty)DataFactory.getInstance().createNewObject((IObjectId)id, IDiscountGroupMappingProperty.class);
/* 358 */     return prop;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @Relationship(name = "Properties")
/*     */   public List<IDiscountGroupMappingProperty> getProperties() {
/* 367 */     if (this._properties == null) {
/* 368 */       this._properties = new HistoricalList(null);
/*     */     }
/* 370 */     return (List<IDiscountGroupMappingProperty>)this._properties;
/*     */   }
/*     */   
/*     */   public void setProperties(List<IDiscountGroupMappingProperty> argProperties) {
/* 374 */     if (this._properties == null) {
/* 375 */       this._properties = new HistoricalList(argProperties);
/*     */     } else {
/* 377 */       this._properties.setCurrentList(argProperties);
/*     */     } 
/*     */     
/* 380 */     for (IDiscountGroupMappingProperty child : this._properties) {
/* 381 */       DiscountGroupMappingPropertyModel model = (DiscountGroupMappingPropertyModel)child;
/* 382 */       model.setCustomerGroupId_noev(getCustomerGroupId());
/* 383 */       model.setDiscountCode_noev(getDiscountCode());
/* 384 */       model.setOrganizationId_noev(getOrganizationId());
/* 385 */       if (child instanceof IDataModelImpl) {
/* 386 */         IDataAccessObject childDao = ((IDataModelImpl)child).getDAO();
/* 387 */         if (StringUtils.isEmpty(childDao.getOriginDataSource()) && 
/* 388 */           !StringUtils.isEmpty(getDAO().getOriginDataSource())) {
/* 389 */           childDao.setOriginDataSource(getDAO().getOriginDataSource());
/*     */         }
/*     */       } 
/* 392 */       if (postEventsForChanges()) {
/* 393 */         this._eventManager.registerEventHandler((IEventAware)this._eventCascade, (IEventSource)child);
/*     */       }
/*     */     } 
/*     */   }
/*     */   
/*     */   public void addDiscountGroupMappingProperty(IDiscountGroupMappingProperty argDiscountGroupMappingProperty) {
/* 399 */     if (this._properties == null) {
/* 400 */       this._properties = new HistoricalList(null);
/*     */     }
/* 402 */     argDiscountGroupMappingProperty.setCustomerGroupId(getCustomerGroupId());
/* 403 */     argDiscountGroupMappingProperty.setDiscountCode(getDiscountCode());
/* 404 */     argDiscountGroupMappingProperty.setOrganizationId(getOrganizationId());
/* 405 */     if (argDiscountGroupMappingProperty instanceof IDataModelImpl) {
/* 406 */       IDataAccessObject childDao = ((IDataModelImpl)argDiscountGroupMappingProperty).getDAO();
/* 407 */       if (StringUtils.isEmpty(childDao.getOriginDataSource()) && 
/* 408 */         !StringUtils.isEmpty(getDAO().getOriginDataSource())) {
/* 409 */         childDao.setOriginDataSource(getDAO().getOriginDataSource());
/*     */       }
/*     */     } 
/*     */ 
/*     */     
/* 414 */     if (postEventsForChanges()) {
/* 415 */       this._eventManager.registerEventHandler((IEventAware)this._eventCascade, (IEventSource)new EventDescriptor(argDiscountGroupMappingProperty));
/*     */     }
/*     */     
/* 418 */     this._properties.add(argDiscountGroupMappingProperty);
/* 419 */     if (postEventsForChanges()) {
/* 420 */       this._events.post(IDiscountGroupMapping.ADD_PROPERTIES, argDiscountGroupMappingProperty);
/*     */     }
/*     */   }
/*     */   
/*     */   public void removeDiscountGroupMappingProperty(IDiscountGroupMappingProperty argDiscountGroupMappingProperty) {
/* 425 */     if (this._properties != null) {
/*     */       
/* 427 */       if (postEventsForChanges()) {
/* 428 */         this._eventManager.deregisterEventHandler((IEventAware)this._eventCascade, (IEventSource)new EventDescriptor(argDiscountGroupMappingProperty));
/*     */       }
/* 430 */       this._properties.remove(argDiscountGroupMappingProperty);
/* 431 */       if (postEventsForChanges()) {
/* 432 */         this._events.post(IDiscountGroupMapping.REMOVE_PROPERTIES, argDiscountGroupMappingProperty);
/*     */       }
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public Object getValue(String argFieldId) {
/* 439 */     if ("Properties".equals(argFieldId)) {
/* 440 */       return getProperties();
/*     */     }
/* 442 */     if ("DiscountGroupMappingExtension".equals(argFieldId)) {
/* 443 */       return this._myExtension;
/*     */     }
/*     */     
/* 446 */     return super.getValue(argFieldId);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void setValue(String argFieldId, Object argValue) {
/* 452 */     if ("Properties".equals(argFieldId)) {
/* 453 */       setProperties(changeToList(argValue, IDiscountGroupMappingProperty.class));
/*     */     }
/* 455 */     else if ("DiscountGroupMappingExtension".equals(argFieldId)) {
/* 456 */       this._myExtension = (IDataModel)argValue;
/*     */     } else {
/*     */       
/* 459 */       super.setValue(argFieldId, argValue);
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public void setDependencies(IPersistenceDefaults argPD, EventManager argEM) {
/* 465 */     this._persistenceDefaults = argPD;
/* 466 */     this._daoImpl.setPersistenceDefaults(argPD);
/* 467 */     this._eventManager = argEM;
/* 468 */     this._events = (Eventor)new ModelEventor((IDataModel)this, argEM);
/* 469 */     this._eventCascade = (EventHandler)new CascadingHandler(this);
/* 470 */     if (this._properties != null) {
/* 471 */       for (IDiscountGroupMappingProperty relationship : this._properties) {
/* 472 */         ((IDataModelImpl)relationship).setDependencies(argPD, argEM);
/*     */       }
/*     */     }
/*     */   }
/*     */   
/*     */   public IDataModel getDiscountGroupMappingExt() {
/* 478 */     return this._myExtension;
/*     */   }
/*     */   
/*     */   public void setDiscountGroupMappingExt(IDataModel argExt) {
/* 482 */     this._myExtension = argExt;
/*     */   }
/*     */ 
/*     */   
/*     */   public void startTransaction() {
/* 487 */     if (this._alreadyInStart) {
/*     */       return;
/*     */     }
/*     */     
/* 491 */     this._alreadyInStart = true;
/*     */ 
/*     */     
/* 494 */     super.startTransaction();
/*     */     
/* 496 */     this._propertiesSavepoint = this._properties;
/* 497 */     if (this._properties != null) {
/* 498 */       this._propertiesSavepoint = new HistoricalList((List)this._properties);
/* 499 */       Iterator<IDataModel> it = this._properties.iterator();
/* 500 */       while (it.hasNext()) {
/* 501 */         ((IDataModel)it.next()).startTransaction();
/*     */       }
/*     */     } 
/*     */ 
/*     */     
/* 506 */     this._alreadyInStart = false;
/*     */   }
/*     */ 
/*     */   
/*     */   public void rollbackChanges() {
/* 511 */     if (isAlreadyRolledBack()) {
/*     */       return;
/*     */     }
/* 514 */     super.rollbackChanges();
/*     */     
/* 516 */     this._properties = this._propertiesSavepoint;
/* 517 */     this._propertiesSavepoint = null;
/* 518 */     if (this._properties != null) {
/* 519 */       Iterator<IDataModel> it = this._properties.iterator();
/* 520 */       while (it.hasNext()) {
/* 521 */         ((IDataModel)it.next()).rollbackChanges();
/*     */       }
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void commitTransaction() {
/* 529 */     if (this._alreadyInCommit) {
/*     */       return;
/*     */     }
/* 532 */     this._alreadyInCommit = true;
/*     */ 
/*     */     
/* 535 */     super.commitTransaction();
/*     */     
/* 537 */     this._propertiesSavepoint = this._properties;
/* 538 */     if (this._properties != null) {
/* 539 */       Iterator<IDataModel> it = this._properties.iterator();
/* 540 */       while (it.hasNext()) {
/* 541 */         ((IDataModel)it.next()).commitTransaction();
/*     */       }
/* 543 */       this._properties = new HistoricalList((List)this._properties);
/*     */     } 
/*     */ 
/*     */     
/* 547 */     this._alreadyInCommit = false;
/*     */   }
/*     */ 
/*     */   
/*     */   private void readObject(ObjectInputStream argStream) throws IOException, ClassNotFoundException {
/* 552 */     argStream.defaultReadObject();
/*     */   }
/*     */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\dsc\impl\DiscountGroupMappingModel.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */