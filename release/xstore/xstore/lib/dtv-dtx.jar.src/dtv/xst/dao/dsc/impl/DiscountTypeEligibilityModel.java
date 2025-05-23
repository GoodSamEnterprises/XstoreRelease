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
/*     */ import dtv.xst.dao.dsc.DiscountTypeEligibilityPropertyId;
/*     */ import dtv.xst.dao.dsc.IDiscountTypeEligibility;
/*     */ import dtv.xst.dao.dsc.IDiscountTypeEligibilityProperty;
/*     */ import java.io.IOException;
/*     */ import java.io.ObjectInputStream;
/*     */ import java.util.Date;
/*     */ import java.util.Iterator;
/*     */ import java.util.List;
/*     */ 
/*     */ public class DiscountTypeEligibilityModel extends AbstractDataModelWithPropertyImpl<IDiscountTypeEligibilityProperty> implements IDiscountTypeEligibility {
/*     */   private static final long serialVersionUID = -853580718L;
/*     */   private transient boolean _alreadyInStart = false;
/*     */   private transient boolean _alreadyInCommit = false;
/*     */   
/*     */   public String toString() {
/*  33 */     return super.toString() + " Id: " + getObjectId();
/*     */   }
/*     */   private IDataModel _myExtension; private HistoricalList<IDiscountTypeEligibilityProperty> _properties; private transient HistoricalList<IDiscountTypeEligibilityProperty> _propertiesSavepoint;
/*     */   
/*     */   public void initDAO() {
/*  38 */     setDAO((IDataAccessObject)new DiscountTypeEligibilityDAO());
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private DiscountTypeEligibilityDAO getDAO_() {
/*  46 */     return (DiscountTypeEligibilityDAO)this._daoImpl;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getDiscountCode() {
/*  54 */     return getDAO_().getDiscountCode();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setDiscountCode(String argDiscountCode) {
/*  62 */     if (setDiscountCode_noev(argDiscountCode) && 
/*  63 */       this._events != null && 
/*  64 */       postEventsForChanges()) {
/*  65 */       this._events.post(IDiscountTypeEligibility.SET_DISCOUNTCODE, argDiscountCode);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setDiscountCode_noev(String argDiscountCode) {
/*  72 */     boolean ev_postable = false;
/*     */     
/*  74 */     if ((getDAO_().getDiscountCode() == null && argDiscountCode != null) || (
/*  75 */       getDAO_().getDiscountCode() != null && !getDAO_().getDiscountCode().equals(argDiscountCode))) {
/*  76 */       getDAO_().setDiscountCode(argDiscountCode);
/*  77 */       ev_postable = true;
/*  78 */       if (this._properties != null) {
/*     */         
/*  80 */         Iterator<DiscountTypeEligibilityPropertyModel> it = this._properties.iterator();
/*  81 */         while (it.hasNext())
/*     */         {
/*  83 */           ((DiscountTypeEligibilityPropertyModel)it.next()).setDiscountCode_noev(argDiscountCode);
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
/*     */   public long getOrganizationId() {
/*  96 */     if (getDAO_().getOrganizationId() != null) {
/*  97 */       return getDAO_().getOrganizationId().longValue();
/*     */     }
/*     */     
/* 100 */     return 0L;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setOrganizationId(long argOrganizationId) {
/* 109 */     if (setOrganizationId_noev(argOrganizationId) && 
/* 110 */       this._events != null && 
/* 111 */       postEventsForChanges()) {
/* 112 */       this._events.post(IDiscountTypeEligibility.SET_ORGANIZATIONID, Long.valueOf(argOrganizationId));
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setOrganizationId_noev(long argOrganizationId) {
/* 119 */     boolean ev_postable = false;
/*     */     
/* 121 */     if ((getDAO_().getOrganizationId() == null && Long.valueOf(argOrganizationId) != null) || (
/* 122 */       getDAO_().getOrganizationId() != null && !getDAO_().getOrganizationId().equals(Long.valueOf(argOrganizationId)))) {
/* 123 */       getDAO_().setOrganizationId(Long.valueOf(argOrganizationId));
/* 124 */       ev_postable = true;
/* 125 */       if (this._properties != null) {
/*     */         
/* 127 */         Iterator<DiscountTypeEligibilityPropertyModel> it = this._properties.iterator();
/* 128 */         while (it.hasNext())
/*     */         {
/* 130 */           ((DiscountTypeEligibilityPropertyModel)it.next()).setOrganizationId_noev(argOrganizationId);
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
/*     */   public String getSaleLineItemTypeCode() {
/* 143 */     return getDAO_().getSaleLineItemTypeCode();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setSaleLineItemTypeCode(String argSaleLineItemTypeCode) {
/* 151 */     if (setSaleLineItemTypeCode_noev(argSaleLineItemTypeCode) && 
/* 152 */       this._events != null && 
/* 153 */       postEventsForChanges()) {
/* 154 */       this._events.post(IDiscountTypeEligibility.SET_SALELINEITEMTYPECODE, argSaleLineItemTypeCode);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setSaleLineItemTypeCode_noev(String argSaleLineItemTypeCode) {
/* 161 */     boolean ev_postable = false;
/*     */     
/* 163 */     if ((getDAO_().getSaleLineItemTypeCode() == null && argSaleLineItemTypeCode != null) || (
/* 164 */       getDAO_().getSaleLineItemTypeCode() != null && !getDAO_().getSaleLineItemTypeCode().equals(argSaleLineItemTypeCode))) {
/* 165 */       getDAO_().setSaleLineItemTypeCode(argSaleLineItemTypeCode);
/* 166 */       ev_postable = true;
/* 167 */       if (this._properties != null) {
/*     */         
/* 169 */         Iterator<DiscountTypeEligibilityPropertyModel> it = this._properties.iterator();
/* 170 */         while (it.hasNext())
/*     */         {
/* 172 */           ((DiscountTypeEligibilityPropertyModel)it.next()).setSaleLineItemTypeCode_noev(argSaleLineItemTypeCode);
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
/*     */   public String getConfigElement() {
/* 185 */     return getDAO_().getConfigElement();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setConfigElement(String argConfigElement) {
/* 193 */     if (setConfigElement_noev(argConfigElement) && 
/* 194 */       this._events != null && 
/* 195 */       postEventsForChanges()) {
/* 196 */       this._events.post(IDiscountTypeEligibility.SET_CONFIGELEMENT, argConfigElement);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setConfigElement_noev(String argConfigElement) {
/* 203 */     boolean ev_postable = false;
/*     */     
/* 205 */     if ((getDAO_().getConfigElement() == null && argConfigElement != null) || (
/* 206 */       getDAO_().getConfigElement() != null && !getDAO_().getConfigElement().equals(argConfigElement))) {
/* 207 */       getDAO_().setConfigElement(argConfigElement);
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
/*     */   public Date getCreateDate() {
/* 219 */     return getDAO_().getCreateDate();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setCreateDate(Date argCreateDate) {
/* 227 */     if (setCreateDate_noev(argCreateDate) && 
/* 228 */       this._events != null && 
/* 229 */       postEventsForChanges()) {
/* 230 */       this._events.post(IDiscountTypeEligibility.SET_CREATEDATE, argCreateDate);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setCreateDate_noev(Date argCreateDate) {
/* 237 */     boolean ev_postable = false;
/*     */     
/* 239 */     if ((getDAO_().getCreateDate() == null && argCreateDate != null) || (
/* 240 */       getDAO_().getCreateDate() != null && !getDAO_().getCreateDate().equals(argCreateDate))) {
/* 241 */       getDAO_().setCreateDate(argCreateDate);
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
/*     */   public String getCreateUserId() {
/* 253 */     return getDAO_().getCreateUserId();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setCreateUserId(String argCreateUserId) {
/* 261 */     if (setCreateUserId_noev(argCreateUserId) && 
/* 262 */       this._events != null && 
/* 263 */       postEventsForChanges()) {
/* 264 */       this._events.post(IDiscountTypeEligibility.SET_CREATEUSERID, argCreateUserId);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setCreateUserId_noev(String argCreateUserId) {
/* 271 */     boolean ev_postable = false;
/*     */     
/* 273 */     if ((getDAO_().getCreateUserId() == null && argCreateUserId != null) || (
/* 274 */       getDAO_().getCreateUserId() != null && !getDAO_().getCreateUserId().equals(argCreateUserId))) {
/* 275 */       getDAO_().setCreateUserId(argCreateUserId);
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
/*     */   public Date getUpdateDate() {
/* 287 */     return getDAO_().getUpdateDate();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setUpdateDate(Date argUpdateDate) {
/* 295 */     if (setUpdateDate_noev(argUpdateDate) && 
/* 296 */       this._events != null && 
/* 297 */       postEventsForChanges()) {
/* 298 */       this._events.post(IDiscountTypeEligibility.SET_UPDATEDATE, argUpdateDate);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setUpdateDate_noev(Date argUpdateDate) {
/* 305 */     boolean ev_postable = false;
/*     */     
/* 307 */     if ((getDAO_().getUpdateDate() == null && argUpdateDate != null) || (
/* 308 */       getDAO_().getUpdateDate() != null && !getDAO_().getUpdateDate().equals(argUpdateDate))) {
/* 309 */       getDAO_().setUpdateDate(argUpdateDate);
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
/*     */   public String getUpdateUserId() {
/* 321 */     return getDAO_().getUpdateUserId();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setUpdateUserId(String argUpdateUserId) {
/* 329 */     if (setUpdateUserId_noev(argUpdateUserId) && 
/* 330 */       this._events != null && 
/* 331 */       postEventsForChanges()) {
/* 332 */       this._events.post(IDiscountTypeEligibility.SET_UPDATEUSERID, argUpdateUserId);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setUpdateUserId_noev(String argUpdateUserId) {
/* 339 */     boolean ev_postable = false;
/*     */     
/* 341 */     if ((getDAO_().getUpdateUserId() == null && argUpdateUserId != null) || (
/* 342 */       getDAO_().getUpdateUserId() != null && !getDAO_().getUpdateUserId().equals(argUpdateUserId))) {
/* 343 */       getDAO_().setUpdateUserId(argUpdateUserId);
/* 344 */       ev_postable = true;
/*     */     } 
/*     */     
/* 347 */     return ev_postable;
/*     */   }
/*     */   
/*     */   protected IDiscountTypeEligibilityProperty newProperty(String argPropertyName) {
/* 351 */     DiscountTypeEligibilityPropertyId id = new DiscountTypeEligibilityPropertyId();
/*     */     
/* 353 */     id.setDiscountCode(getDiscountCode());
/* 354 */     id.setSaleLineItemTypeCode(getSaleLineItemTypeCode());
/* 355 */     id.setPropertyCode(argPropertyName);
/*     */     
/* 357 */     IDiscountTypeEligibilityProperty prop = (IDiscountTypeEligibilityProperty)DataFactory.getInstance().createNewObject((IObjectId)id, IDiscountTypeEligibilityProperty.class);
/* 358 */     return prop;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @Relationship(name = "Properties")
/*     */   public List<IDiscountTypeEligibilityProperty> getProperties() {
/* 367 */     if (this._properties == null) {
/* 368 */       this._properties = new HistoricalList(null);
/*     */     }
/* 370 */     return (List<IDiscountTypeEligibilityProperty>)this._properties;
/*     */   }
/*     */   
/*     */   public void setProperties(List<IDiscountTypeEligibilityProperty> argProperties) {
/* 374 */     if (this._properties == null) {
/* 375 */       this._properties = new HistoricalList(argProperties);
/*     */     } else {
/* 377 */       this._properties.setCurrentList(argProperties);
/*     */     } 
/*     */     
/* 380 */     for (IDiscountTypeEligibilityProperty child : this._properties) {
/* 381 */       DiscountTypeEligibilityPropertyModel model = (DiscountTypeEligibilityPropertyModel)child;
/* 382 */       model.setDiscountCode_noev(getDiscountCode());
/* 383 */       model.setOrganizationId_noev(getOrganizationId());
/* 384 */       model.setSaleLineItemTypeCode_noev(getSaleLineItemTypeCode());
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
/*     */   public void addDiscountTypeEligibilityProperty(IDiscountTypeEligibilityProperty argDiscountTypeEligibilityProperty) {
/* 399 */     if (this._properties == null) {
/* 400 */       this._properties = new HistoricalList(null);
/*     */     }
/* 402 */     argDiscountTypeEligibilityProperty.setDiscountCode(getDiscountCode());
/* 403 */     argDiscountTypeEligibilityProperty.setOrganizationId(getOrganizationId());
/* 404 */     argDiscountTypeEligibilityProperty.setSaleLineItemTypeCode(getSaleLineItemTypeCode());
/* 405 */     if (argDiscountTypeEligibilityProperty instanceof IDataModelImpl) {
/* 406 */       IDataAccessObject childDao = ((IDataModelImpl)argDiscountTypeEligibilityProperty).getDAO();
/* 407 */       if (StringUtils.isEmpty(childDao.getOriginDataSource()) && 
/* 408 */         !StringUtils.isEmpty(getDAO().getOriginDataSource())) {
/* 409 */         childDao.setOriginDataSource(getDAO().getOriginDataSource());
/*     */       }
/*     */     } 
/*     */ 
/*     */     
/* 414 */     if (postEventsForChanges()) {
/* 415 */       this._eventManager.registerEventHandler((IEventAware)this._eventCascade, (IEventSource)new EventDescriptor(argDiscountTypeEligibilityProperty));
/*     */     }
/*     */     
/* 418 */     this._properties.add(argDiscountTypeEligibilityProperty);
/* 419 */     if (postEventsForChanges()) {
/* 420 */       this._events.post(IDiscountTypeEligibility.ADD_PROPERTIES, argDiscountTypeEligibilityProperty);
/*     */     }
/*     */   }
/*     */   
/*     */   public void removeDiscountTypeEligibilityProperty(IDiscountTypeEligibilityProperty argDiscountTypeEligibilityProperty) {
/* 425 */     if (this._properties != null) {
/*     */       
/* 427 */       if (postEventsForChanges()) {
/* 428 */         this._eventManager.deregisterEventHandler((IEventAware)this._eventCascade, (IEventSource)new EventDescriptor(argDiscountTypeEligibilityProperty));
/*     */       }
/* 430 */       this._properties.remove(argDiscountTypeEligibilityProperty);
/* 431 */       if (postEventsForChanges()) {
/* 432 */         this._events.post(IDiscountTypeEligibility.REMOVE_PROPERTIES, argDiscountTypeEligibilityProperty);
/*     */       }
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public Object getValue(String argFieldId) {
/* 439 */     if ("Properties".equals(argFieldId)) {
/* 440 */       return getProperties();
/*     */     }
/* 442 */     if ("DiscountTypeEligibilityExtension".equals(argFieldId)) {
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
/* 453 */       setProperties(changeToList(argValue, IDiscountTypeEligibilityProperty.class));
/*     */     }
/* 455 */     else if ("DiscountTypeEligibilityExtension".equals(argFieldId)) {
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
/* 471 */       for (IDiscountTypeEligibilityProperty relationship : this._properties) {
/* 472 */         ((IDataModelImpl)relationship).setDependencies(argPD, argEM);
/*     */       }
/*     */     }
/*     */   }
/*     */   
/*     */   public IDataModel getDiscountTypeEligibilityExt() {
/* 478 */     return this._myExtension;
/*     */   }
/*     */   
/*     */   public void setDiscountTypeEligibilityExt(IDataModel argExt) {
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


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\dsc\impl\DiscountTypeEligibilityModel.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */