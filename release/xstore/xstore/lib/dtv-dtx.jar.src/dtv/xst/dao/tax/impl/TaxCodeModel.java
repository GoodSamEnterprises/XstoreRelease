/*     */ package dtv.xst.dao.tax.impl;
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
/*     */ import dtv.xst.dao.tax.ITaxCode;
/*     */ import dtv.xst.dao.tax.ITaxCodeProperty;
/*     */ import dtv.xst.dao.tax.TaxCodePropertyId;
/*     */ import java.io.IOException;
/*     */ import java.io.ObjectInputStream;
/*     */ import java.util.Date;
/*     */ import java.util.Iterator;
/*     */ import java.util.List;
/*     */ 
/*     */ public class TaxCodeModel extends AbstractDataModelWithPropertyImpl<ITaxCodeProperty> implements ITaxCode {
/*     */   private static final long serialVersionUID = 130853912L;
/*     */   private transient boolean _alreadyInStart = false;
/*     */   private transient boolean _alreadyInCommit = false;
/*     */   
/*     */   public String toString() {
/*  33 */     return super.toString() + " Id: " + getObjectId();
/*     */   }
/*     */   private IDataModel _myExtension; private HistoricalList<ITaxCodeProperty> _properties; private transient HistoricalList<ITaxCodeProperty> _propertiesSavepoint;
/*     */   
/*     */   public void initDAO() {
/*  38 */     setDAO((IDataAccessObject)new TaxCodeDAO());
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private TaxCodeDAO getDAO_() {
/*  46 */     return (TaxCodeDAO)this._daoImpl;
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
/*  70 */       this._events.post(ITaxCode.SET_ORGANIZATIONID, Long.valueOf(argOrganizationId));
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
/*  85 */         Iterator<TaxCodePropertyModel> it = this._properties.iterator();
/*  86 */         while (it.hasNext())
/*     */         {
/*  88 */           ((TaxCodePropertyModel)it.next()).setOrganizationId_noev(argOrganizationId);
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
/*     */   public String getTaxCodeId() {
/* 101 */     return getDAO_().getTaxCodeId();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setTaxCodeId(String argTaxCodeId) {
/* 109 */     if (setTaxCodeId_noev(argTaxCodeId) && 
/* 110 */       this._events != null && 
/* 111 */       postEventsForChanges()) {
/* 112 */       this._events.post(ITaxCode.SET_TAXCODEID, argTaxCodeId);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setTaxCodeId_noev(String argTaxCodeId) {
/* 119 */     boolean ev_postable = false;
/*     */     
/* 121 */     if ((getDAO_().getTaxCodeId() == null && argTaxCodeId != null) || (
/* 122 */       getDAO_().getTaxCodeId() != null && !getDAO_().getTaxCodeId().equals(argTaxCodeId))) {
/* 123 */       getDAO_().setTaxCodeId(argTaxCodeId);
/* 124 */       ev_postable = true;
/* 125 */       if (this._properties != null) {
/*     */         
/* 127 */         Iterator<TaxCodePropertyModel> it = this._properties.iterator();
/* 128 */         while (it.hasNext())
/*     */         {
/* 130 */           ((TaxCodePropertyModel)it.next()).setTaxCodeId_noev(argTaxCodeId);
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
/*     */   public Date getCreateDate() {
/* 143 */     return getDAO_().getCreateDate();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setCreateDate(Date argCreateDate) {
/* 151 */     if (setCreateDate_noev(argCreateDate) && 
/* 152 */       this._events != null && 
/* 153 */       postEventsForChanges()) {
/* 154 */       this._events.post(ITaxCode.SET_CREATEDATE, argCreateDate);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setCreateDate_noev(Date argCreateDate) {
/* 161 */     boolean ev_postable = false;
/*     */     
/* 163 */     if ((getDAO_().getCreateDate() == null && argCreateDate != null) || (
/* 164 */       getDAO_().getCreateDate() != null && !getDAO_().getCreateDate().equals(argCreateDate))) {
/* 165 */       getDAO_().setCreateDate(argCreateDate);
/* 166 */       ev_postable = true;
/*     */     } 
/*     */     
/* 169 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getCreateUserId() {
/* 177 */     return getDAO_().getCreateUserId();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setCreateUserId(String argCreateUserId) {
/* 185 */     if (setCreateUserId_noev(argCreateUserId) && 
/* 186 */       this._events != null && 
/* 187 */       postEventsForChanges()) {
/* 188 */       this._events.post(ITaxCode.SET_CREATEUSERID, argCreateUserId);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setCreateUserId_noev(String argCreateUserId) {
/* 195 */     boolean ev_postable = false;
/*     */     
/* 197 */     if ((getDAO_().getCreateUserId() == null && argCreateUserId != null) || (
/* 198 */       getDAO_().getCreateUserId() != null && !getDAO_().getCreateUserId().equals(argCreateUserId))) {
/* 199 */       getDAO_().setCreateUserId(argCreateUserId);
/* 200 */       ev_postable = true;
/*     */     } 
/*     */     
/* 203 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Date getUpdateDate() {
/* 211 */     return getDAO_().getUpdateDate();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setUpdateDate(Date argUpdateDate) {
/* 219 */     if (setUpdateDate_noev(argUpdateDate) && 
/* 220 */       this._events != null && 
/* 221 */       postEventsForChanges()) {
/* 222 */       this._events.post(ITaxCode.SET_UPDATEDATE, argUpdateDate);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setUpdateDate_noev(Date argUpdateDate) {
/* 229 */     boolean ev_postable = false;
/*     */     
/* 231 */     if ((getDAO_().getUpdateDate() == null && argUpdateDate != null) || (
/* 232 */       getDAO_().getUpdateDate() != null && !getDAO_().getUpdateDate().equals(argUpdateDate))) {
/* 233 */       getDAO_().setUpdateDate(argUpdateDate);
/* 234 */       ev_postable = true;
/*     */     } 
/*     */     
/* 237 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getUpdateUserId() {
/* 245 */     return getDAO_().getUpdateUserId();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setUpdateUserId(String argUpdateUserId) {
/* 253 */     if (setUpdateUserId_noev(argUpdateUserId) && 
/* 254 */       this._events != null && 
/* 255 */       postEventsForChanges()) {
/* 256 */       this._events.post(ITaxCode.SET_UPDATEUSERID, argUpdateUserId);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setUpdateUserId_noev(String argUpdateUserId) {
/* 263 */     boolean ev_postable = false;
/*     */     
/* 265 */     if ((getDAO_().getUpdateUserId() == null && argUpdateUserId != null) || (
/* 266 */       getDAO_().getUpdateUserId() != null && !getDAO_().getUpdateUserId().equals(argUpdateUserId))) {
/* 267 */       getDAO_().setUpdateUserId(argUpdateUserId);
/* 268 */       ev_postable = true;
/*     */     } 
/*     */     
/* 271 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getDescription() {
/* 279 */     return getDAO_().getDescription();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setDescription(String argDescription) {
/* 287 */     if (setDescription_noev(argDescription) && 
/* 288 */       this._events != null && 
/* 289 */       postEventsForChanges()) {
/* 290 */       this._events.post(ITaxCode.SET_DESCRIPTION, argDescription);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setDescription_noev(String argDescription) {
/* 297 */     boolean ev_postable = false;
/*     */     
/* 299 */     if ((getDAO_().getDescription() == null && argDescription != null) || (
/* 300 */       getDAO_().getDescription() != null && !getDAO_().getDescription().equals(argDescription))) {
/* 301 */       getDAO_().setDescription(argDescription);
/* 302 */       ev_postable = true;
/*     */     } 
/*     */     
/* 305 */     return ev_postable;
/*     */   }
/*     */   
/*     */   protected ITaxCodeProperty newProperty(String argPropertyName) {
/* 309 */     TaxCodePropertyId id = new TaxCodePropertyId();
/*     */     
/* 311 */     id.setTaxCodeId(getTaxCodeId());
/* 312 */     id.setPropertyCode(argPropertyName);
/*     */     
/* 314 */     ITaxCodeProperty prop = (ITaxCodeProperty)DataFactory.getInstance().createNewObject((IObjectId)id, ITaxCodeProperty.class);
/* 315 */     return prop;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @Relationship(name = "Properties")
/*     */   public List<ITaxCodeProperty> getProperties() {
/* 324 */     if (this._properties == null) {
/* 325 */       this._properties = new HistoricalList(null);
/*     */     }
/* 327 */     return (List<ITaxCodeProperty>)this._properties;
/*     */   }
/*     */   
/*     */   public void setProperties(List<ITaxCodeProperty> argProperties) {
/* 331 */     if (this._properties == null) {
/* 332 */       this._properties = new HistoricalList(argProperties);
/*     */     } else {
/* 334 */       this._properties.setCurrentList(argProperties);
/*     */     } 
/*     */     
/* 337 */     for (ITaxCodeProperty child : this._properties) {
/* 338 */       TaxCodePropertyModel model = (TaxCodePropertyModel)child;
/* 339 */       model.setOrganizationId_noev(getOrganizationId());
/* 340 */       model.setTaxCodeId_noev(getTaxCodeId());
/* 341 */       if (child instanceof IDataModelImpl) {
/* 342 */         IDataAccessObject childDao = ((IDataModelImpl)child).getDAO();
/* 343 */         if (StringUtils.isEmpty(childDao.getOriginDataSource()) && 
/* 344 */           !StringUtils.isEmpty(getDAO().getOriginDataSource())) {
/* 345 */           childDao.setOriginDataSource(getDAO().getOriginDataSource());
/*     */         }
/*     */       } 
/* 348 */       if (postEventsForChanges()) {
/* 349 */         this._eventManager.registerEventHandler((IEventAware)this._eventCascade, (IEventSource)child);
/*     */       }
/*     */     } 
/*     */   }
/*     */   
/*     */   public void addTaxCodeProperty(ITaxCodeProperty argTaxCodeProperty) {
/* 355 */     if (this._properties == null) {
/* 356 */       this._properties = new HistoricalList(null);
/*     */     }
/* 358 */     argTaxCodeProperty.setOrganizationId(getOrganizationId());
/* 359 */     argTaxCodeProperty.setTaxCodeId(getTaxCodeId());
/* 360 */     if (argTaxCodeProperty instanceof IDataModelImpl) {
/* 361 */       IDataAccessObject childDao = ((IDataModelImpl)argTaxCodeProperty).getDAO();
/* 362 */       if (StringUtils.isEmpty(childDao.getOriginDataSource()) && 
/* 363 */         !StringUtils.isEmpty(getDAO().getOriginDataSource())) {
/* 364 */         childDao.setOriginDataSource(getDAO().getOriginDataSource());
/*     */       }
/*     */     } 
/*     */ 
/*     */     
/* 369 */     if (postEventsForChanges()) {
/* 370 */       this._eventManager.registerEventHandler((IEventAware)this._eventCascade, (IEventSource)new EventDescriptor(argTaxCodeProperty));
/*     */     }
/*     */     
/* 373 */     this._properties.add(argTaxCodeProperty);
/* 374 */     if (postEventsForChanges()) {
/* 375 */       this._events.post(ITaxCode.ADD_PROPERTIES, argTaxCodeProperty);
/*     */     }
/*     */   }
/*     */   
/*     */   public void removeTaxCodeProperty(ITaxCodeProperty argTaxCodeProperty) {
/* 380 */     if (this._properties != null) {
/*     */       
/* 382 */       if (postEventsForChanges()) {
/* 383 */         this._eventManager.deregisterEventHandler((IEventAware)this._eventCascade, (IEventSource)new EventDescriptor(argTaxCodeProperty));
/*     */       }
/* 385 */       this._properties.remove(argTaxCodeProperty);
/* 386 */       if (postEventsForChanges()) {
/* 387 */         this._events.post(ITaxCode.REMOVE_PROPERTIES, argTaxCodeProperty);
/*     */       }
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public Object getValue(String argFieldId) {
/* 394 */     if ("Properties".equals(argFieldId)) {
/* 395 */       return getProperties();
/*     */     }
/* 397 */     if ("TaxCodeExtension".equals(argFieldId)) {
/* 398 */       return this._myExtension;
/*     */     }
/*     */     
/* 401 */     return super.getValue(argFieldId);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void setValue(String argFieldId, Object argValue) {
/* 407 */     if ("Properties".equals(argFieldId)) {
/* 408 */       setProperties(changeToList(argValue, ITaxCodeProperty.class));
/*     */     }
/* 410 */     else if ("TaxCodeExtension".equals(argFieldId)) {
/* 411 */       this._myExtension = (IDataModel)argValue;
/*     */     } else {
/*     */       
/* 414 */       super.setValue(argFieldId, argValue);
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public void setDependencies(IPersistenceDefaults argPD, EventManager argEM) {
/* 420 */     this._persistenceDefaults = argPD;
/* 421 */     this._daoImpl.setPersistenceDefaults(argPD);
/* 422 */     this._eventManager = argEM;
/* 423 */     this._events = (Eventor)new ModelEventor((IDataModel)this, argEM);
/* 424 */     this._eventCascade = (EventHandler)new CascadingHandler(this);
/* 425 */     if (this._properties != null) {
/* 426 */       for (ITaxCodeProperty relationship : this._properties) {
/* 427 */         ((IDataModelImpl)relationship).setDependencies(argPD, argEM);
/*     */       }
/*     */     }
/*     */   }
/*     */   
/*     */   public IDataModel getTaxCodeExt() {
/* 433 */     return this._myExtension;
/*     */   }
/*     */   
/*     */   public void setTaxCodeExt(IDataModel argExt) {
/* 437 */     this._myExtension = argExt;
/*     */   }
/*     */ 
/*     */   
/*     */   public void startTransaction() {
/* 442 */     if (this._alreadyInStart) {
/*     */       return;
/*     */     }
/*     */     
/* 446 */     this._alreadyInStart = true;
/*     */ 
/*     */     
/* 449 */     super.startTransaction();
/*     */     
/* 451 */     this._propertiesSavepoint = this._properties;
/* 452 */     if (this._properties != null) {
/* 453 */       this._propertiesSavepoint = new HistoricalList((List)this._properties);
/* 454 */       Iterator<IDataModel> it = this._properties.iterator();
/* 455 */       while (it.hasNext()) {
/* 456 */         ((IDataModel)it.next()).startTransaction();
/*     */       }
/*     */     } 
/*     */ 
/*     */     
/* 461 */     this._alreadyInStart = false;
/*     */   }
/*     */ 
/*     */   
/*     */   public void rollbackChanges() {
/* 466 */     if (isAlreadyRolledBack()) {
/*     */       return;
/*     */     }
/* 469 */     super.rollbackChanges();
/*     */     
/* 471 */     this._properties = this._propertiesSavepoint;
/* 472 */     this._propertiesSavepoint = null;
/* 473 */     if (this._properties != null) {
/* 474 */       Iterator<IDataModel> it = this._properties.iterator();
/* 475 */       while (it.hasNext()) {
/* 476 */         ((IDataModel)it.next()).rollbackChanges();
/*     */       }
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void commitTransaction() {
/* 484 */     if (this._alreadyInCommit) {
/*     */       return;
/*     */     }
/* 487 */     this._alreadyInCommit = true;
/*     */ 
/*     */     
/* 490 */     super.commitTransaction();
/*     */     
/* 492 */     this._propertiesSavepoint = this._properties;
/* 493 */     if (this._properties != null) {
/* 494 */       Iterator<IDataModel> it = this._properties.iterator();
/* 495 */       while (it.hasNext()) {
/* 496 */         ((IDataModel)it.next()).commitTransaction();
/*     */       }
/* 498 */       this._properties = new HistoricalList((List)this._properties);
/*     */     } 
/*     */ 
/*     */     
/* 502 */     this._alreadyInCommit = false;
/*     */   }
/*     */ 
/*     */   
/*     */   private void readObject(ObjectInputStream argStream) throws IOException, ClassNotFoundException {
/* 507 */     argStream.defaultReadObject();
/*     */   }
/*     */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\tax\impl\TaxCodeModel.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */