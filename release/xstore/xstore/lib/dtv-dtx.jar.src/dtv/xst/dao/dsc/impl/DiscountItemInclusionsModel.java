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
/*     */ import dtv.xst.dao.dsc.DiscountItemInclusionsPropertyId;
/*     */ import dtv.xst.dao.dsc.IDiscountItemInclusions;
/*     */ import dtv.xst.dao.dsc.IDiscountItemInclusionsProperty;
/*     */ import java.io.IOException;
/*     */ import java.io.ObjectInputStream;
/*     */ import java.util.Date;
/*     */ import java.util.Iterator;
/*     */ import java.util.List;
/*     */ 
/*     */ public class DiscountItemInclusionsModel extends AbstractDataModelWithPropertyImpl<IDiscountItemInclusionsProperty> implements IDiscountItemInclusions {
/*     */   private static final long serialVersionUID = -844796405L;
/*     */   private transient boolean _alreadyInStart = false;
/*     */   private transient boolean _alreadyInCommit = false;
/*     */   
/*     */   public String toString() {
/*  33 */     return super.toString() + " Id: " + getObjectId();
/*     */   }
/*     */   private IDataModel _myExtension; private HistoricalList<IDiscountItemInclusionsProperty> _properties; private transient HistoricalList<IDiscountItemInclusionsProperty> _propertiesSavepoint;
/*     */   
/*     */   public void initDAO() {
/*  38 */     setDAO((IDataAccessObject)new DiscountItemInclusionsDAO());
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private DiscountItemInclusionsDAO getDAO_() {
/*  46 */     return (DiscountItemInclusionsDAO)this._daoImpl;
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
/*  65 */       this._events.post(IDiscountItemInclusions.SET_DISCOUNTCODE, argDiscountCode);
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
/*  80 */         Iterator<DiscountItemInclusionsPropertyModel> it = this._properties.iterator();
/*  81 */         while (it.hasNext())
/*     */         {
/*  83 */           ((DiscountItemInclusionsPropertyModel)it.next()).setDiscountCode_noev(argDiscountCode);
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
/*     */   public String getItemId() {
/*  96 */     return getDAO_().getItemId();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setItemId(String argItemId) {
/* 104 */     if (setItemId_noev(argItemId) && 
/* 105 */       this._events != null && 
/* 106 */       postEventsForChanges()) {
/* 107 */       this._events.post(IDiscountItemInclusions.SET_ITEMID, argItemId);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setItemId_noev(String argItemId) {
/* 114 */     boolean ev_postable = false;
/*     */     
/* 116 */     if ((getDAO_().getItemId() == null && argItemId != null) || (
/* 117 */       getDAO_().getItemId() != null && !getDAO_().getItemId().equals(argItemId))) {
/* 118 */       getDAO_().setItemId(argItemId);
/* 119 */       ev_postable = true;
/* 120 */       if (this._properties != null) {
/*     */         
/* 122 */         Iterator<DiscountItemInclusionsPropertyModel> it = this._properties.iterator();
/* 123 */         while (it.hasNext())
/*     */         {
/* 125 */           ((DiscountItemInclusionsPropertyModel)it.next()).setItemId_noev(argItemId);
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
/* 154 */       this._events.post(IDiscountItemInclusions.SET_ORGANIZATIONID, Long.valueOf(argOrganizationId));
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
/* 169 */         Iterator<DiscountItemInclusionsPropertyModel> it = this._properties.iterator();
/* 170 */         while (it.hasNext())
/*     */         {
/* 172 */           ((DiscountItemInclusionsPropertyModel)it.next()).setOrganizationId_noev(argOrganizationId);
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
/* 196 */       this._events.post(IDiscountItemInclusions.SET_CREATEDATE, argCreateDate);
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
/* 230 */       this._events.post(IDiscountItemInclusions.SET_CREATEUSERID, argCreateUserId);
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
/* 264 */       this._events.post(IDiscountItemInclusions.SET_UPDATEDATE, argUpdateDate);
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
/* 298 */       this._events.post(IDiscountItemInclusions.SET_UPDATEUSERID, argUpdateUserId);
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
/*     */   protected IDiscountItemInclusionsProperty newProperty(String argPropertyName) {
/* 317 */     DiscountItemInclusionsPropertyId id = new DiscountItemInclusionsPropertyId();
/*     */     
/* 319 */     id.setDiscountCode(getDiscountCode());
/* 320 */     id.setItemId(getItemId());
/* 321 */     id.setPropertyCode(argPropertyName);
/*     */     
/* 323 */     IDiscountItemInclusionsProperty prop = (IDiscountItemInclusionsProperty)DataFactory.getInstance().createNewObject((IObjectId)id, IDiscountItemInclusionsProperty.class);
/* 324 */     return prop;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @Relationship(name = "Properties")
/*     */   public List<IDiscountItemInclusionsProperty> getProperties() {
/* 333 */     if (this._properties == null) {
/* 334 */       this._properties = new HistoricalList(null);
/*     */     }
/* 336 */     return (List<IDiscountItemInclusionsProperty>)this._properties;
/*     */   }
/*     */   
/*     */   public void setProperties(List<IDiscountItemInclusionsProperty> argProperties) {
/* 340 */     if (this._properties == null) {
/* 341 */       this._properties = new HistoricalList(argProperties);
/*     */     } else {
/* 343 */       this._properties.setCurrentList(argProperties);
/*     */     } 
/*     */     
/* 346 */     for (IDiscountItemInclusionsProperty child : this._properties) {
/* 347 */       DiscountItemInclusionsPropertyModel model = (DiscountItemInclusionsPropertyModel)child;
/* 348 */       model.setDiscountCode_noev(getDiscountCode());
/* 349 */       model.setItemId_noev(getItemId());
/* 350 */       model.setOrganizationId_noev(getOrganizationId());
/* 351 */       if (child instanceof IDataModelImpl) {
/* 352 */         IDataAccessObject childDao = ((IDataModelImpl)child).getDAO();
/* 353 */         if (StringUtils.isEmpty(childDao.getOriginDataSource()) && 
/* 354 */           !StringUtils.isEmpty(getDAO().getOriginDataSource())) {
/* 355 */           childDao.setOriginDataSource(getDAO().getOriginDataSource());
/*     */         }
/*     */       } 
/* 358 */       if (postEventsForChanges()) {
/* 359 */         this._eventManager.registerEventHandler((IEventAware)this._eventCascade, (IEventSource)child);
/*     */       }
/*     */     } 
/*     */   }
/*     */   
/*     */   public void addDiscountItemInclusionsProperty(IDiscountItemInclusionsProperty argDiscountItemInclusionsProperty) {
/* 365 */     if (this._properties == null) {
/* 366 */       this._properties = new HistoricalList(null);
/*     */     }
/* 368 */     argDiscountItemInclusionsProperty.setDiscountCode(getDiscountCode());
/* 369 */     argDiscountItemInclusionsProperty.setItemId(getItemId());
/* 370 */     argDiscountItemInclusionsProperty.setOrganizationId(getOrganizationId());
/* 371 */     if (argDiscountItemInclusionsProperty instanceof IDataModelImpl) {
/* 372 */       IDataAccessObject childDao = ((IDataModelImpl)argDiscountItemInclusionsProperty).getDAO();
/* 373 */       if (StringUtils.isEmpty(childDao.getOriginDataSource()) && 
/* 374 */         !StringUtils.isEmpty(getDAO().getOriginDataSource())) {
/* 375 */         childDao.setOriginDataSource(getDAO().getOriginDataSource());
/*     */       }
/*     */     } 
/*     */ 
/*     */     
/* 380 */     if (postEventsForChanges()) {
/* 381 */       this._eventManager.registerEventHandler((IEventAware)this._eventCascade, (IEventSource)new EventDescriptor(argDiscountItemInclusionsProperty));
/*     */     }
/*     */     
/* 384 */     this._properties.add(argDiscountItemInclusionsProperty);
/* 385 */     if (postEventsForChanges()) {
/* 386 */       this._events.post(IDiscountItemInclusions.ADD_PROPERTIES, argDiscountItemInclusionsProperty);
/*     */     }
/*     */   }
/*     */   
/*     */   public void removeDiscountItemInclusionsProperty(IDiscountItemInclusionsProperty argDiscountItemInclusionsProperty) {
/* 391 */     if (this._properties != null) {
/*     */       
/* 393 */       if (postEventsForChanges()) {
/* 394 */         this._eventManager.deregisterEventHandler((IEventAware)this._eventCascade, (IEventSource)new EventDescriptor(argDiscountItemInclusionsProperty));
/*     */       }
/* 396 */       this._properties.remove(argDiscountItemInclusionsProperty);
/* 397 */       if (postEventsForChanges()) {
/* 398 */         this._events.post(IDiscountItemInclusions.REMOVE_PROPERTIES, argDiscountItemInclusionsProperty);
/*     */       }
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public Object getValue(String argFieldId) {
/* 405 */     if ("Properties".equals(argFieldId)) {
/* 406 */       return getProperties();
/*     */     }
/* 408 */     if ("DiscountItemInclusionsExtension".equals(argFieldId)) {
/* 409 */       return this._myExtension;
/*     */     }
/*     */     
/* 412 */     return super.getValue(argFieldId);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void setValue(String argFieldId, Object argValue) {
/* 418 */     if ("Properties".equals(argFieldId)) {
/* 419 */       setProperties(changeToList(argValue, IDiscountItemInclusionsProperty.class));
/*     */     }
/* 421 */     else if ("DiscountItemInclusionsExtension".equals(argFieldId)) {
/* 422 */       this._myExtension = (IDataModel)argValue;
/*     */     } else {
/*     */       
/* 425 */       super.setValue(argFieldId, argValue);
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public void setDependencies(IPersistenceDefaults argPD, EventManager argEM) {
/* 431 */     this._persistenceDefaults = argPD;
/* 432 */     this._daoImpl.setPersistenceDefaults(argPD);
/* 433 */     this._eventManager = argEM;
/* 434 */     this._events = (Eventor)new ModelEventor((IDataModel)this, argEM);
/* 435 */     this._eventCascade = (EventHandler)new CascadingHandler(this);
/* 436 */     if (this._properties != null) {
/* 437 */       for (IDiscountItemInclusionsProperty relationship : this._properties) {
/* 438 */         ((IDataModelImpl)relationship).setDependencies(argPD, argEM);
/*     */       }
/*     */     }
/*     */   }
/*     */   
/*     */   public IDataModel getDiscountItemInclusionsExt() {
/* 444 */     return this._myExtension;
/*     */   }
/*     */   
/*     */   public void setDiscountItemInclusionsExt(IDataModel argExt) {
/* 448 */     this._myExtension = argExt;
/*     */   }
/*     */ 
/*     */   
/*     */   public void startTransaction() {
/* 453 */     if (this._alreadyInStart) {
/*     */       return;
/*     */     }
/*     */     
/* 457 */     this._alreadyInStart = true;
/*     */ 
/*     */     
/* 460 */     super.startTransaction();
/*     */     
/* 462 */     this._propertiesSavepoint = this._properties;
/* 463 */     if (this._properties != null) {
/* 464 */       this._propertiesSavepoint = new HistoricalList((List)this._properties);
/* 465 */       Iterator<IDataModel> it = this._properties.iterator();
/* 466 */       while (it.hasNext()) {
/* 467 */         ((IDataModel)it.next()).startTransaction();
/*     */       }
/*     */     } 
/*     */ 
/*     */     
/* 472 */     this._alreadyInStart = false;
/*     */   }
/*     */ 
/*     */   
/*     */   public void rollbackChanges() {
/* 477 */     if (isAlreadyRolledBack()) {
/*     */       return;
/*     */     }
/* 480 */     super.rollbackChanges();
/*     */     
/* 482 */     this._properties = this._propertiesSavepoint;
/* 483 */     this._propertiesSavepoint = null;
/* 484 */     if (this._properties != null) {
/* 485 */       Iterator<IDataModel> it = this._properties.iterator();
/* 486 */       while (it.hasNext()) {
/* 487 */         ((IDataModel)it.next()).rollbackChanges();
/*     */       }
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void commitTransaction() {
/* 495 */     if (this._alreadyInCommit) {
/*     */       return;
/*     */     }
/* 498 */     this._alreadyInCommit = true;
/*     */ 
/*     */     
/* 501 */     super.commitTransaction();
/*     */     
/* 503 */     this._propertiesSavepoint = this._properties;
/* 504 */     if (this._properties != null) {
/* 505 */       Iterator<IDataModel> it = this._properties.iterator();
/* 506 */       while (it.hasNext()) {
/* 507 */         ((IDataModel)it.next()).commitTransaction();
/*     */       }
/* 509 */       this._properties = new HistoricalList((List)this._properties);
/*     */     } 
/*     */ 
/*     */     
/* 513 */     this._alreadyInCommit = false;
/*     */   }
/*     */ 
/*     */   
/*     */   private void readObject(ObjectInputStream argStream) throws IOException, ClassNotFoundException {
/* 518 */     argStream.defaultReadObject();
/*     */   }
/*     */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\dsc\impl\DiscountItemInclusionsModel.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */