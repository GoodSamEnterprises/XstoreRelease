/*     */ package dtv.xst.dao.itm.impl;
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
/*     */ import dtv.xst.dao.itm.IMatrixSortOrder;
/*     */ import dtv.xst.dao.itm.IMatrixSortOrderProperty;
/*     */ import dtv.xst.dao.itm.MatrixSortOrderPropertyId;
/*     */ import java.io.IOException;
/*     */ import java.io.ObjectInputStream;
/*     */ import java.util.Date;
/*     */ import java.util.Iterator;
/*     */ import java.util.List;
/*     */ 
/*     */ public class MatrixSortOrderModel extends AbstractDataModelWithPropertyImpl<IMatrixSortOrderProperty> implements IMatrixSortOrder {
/*     */   private static final long serialVersionUID = 647421295L;
/*     */   private transient boolean _alreadyInStart = false;
/*     */   private transient boolean _alreadyInCommit = false;
/*     */   
/*     */   public String toString() {
/*  33 */     return super.toString() + " Id: " + getObjectId();
/*     */   }
/*     */   private IDataModel _myExtension; private HistoricalList<IMatrixSortOrderProperty> _properties; private transient HistoricalList<IMatrixSortOrderProperty> _propertiesSavepoint;
/*     */   
/*     */   public void initDAO() {
/*  38 */     setDAO((IDataAccessObject)new MatrixSortOrderDAO());
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private MatrixSortOrderDAO getDAO_() {
/*  46 */     return (MatrixSortOrderDAO)this._daoImpl;
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
/*  70 */       this._events.post(IMatrixSortOrder.SET_ORGANIZATIONID, Long.valueOf(argOrganizationId));
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
/*  85 */         Iterator<MatrixSortOrderPropertyModel> it = this._properties.iterator();
/*  86 */         while (it.hasNext())
/*     */         {
/*  88 */           ((MatrixSortOrderPropertyModel)it.next()).setOrganizationId_noev(argOrganizationId);
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
/*     */   public String getMatrixSortType() {
/* 101 */     return getDAO_().getMatrixSortType();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setMatrixSortType(String argMatrixSortType) {
/* 109 */     if (setMatrixSortType_noev(argMatrixSortType) && 
/* 110 */       this._events != null && 
/* 111 */       postEventsForChanges()) {
/* 112 */       this._events.post(IMatrixSortOrder.SET_MATRIXSORTTYPE, argMatrixSortType);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setMatrixSortType_noev(String argMatrixSortType) {
/* 119 */     boolean ev_postable = false;
/*     */     
/* 121 */     if ((getDAO_().getMatrixSortType() == null && argMatrixSortType != null) || (
/* 122 */       getDAO_().getMatrixSortType() != null && !getDAO_().getMatrixSortType().equals(argMatrixSortType))) {
/* 123 */       getDAO_().setMatrixSortType(argMatrixSortType);
/* 124 */       ev_postable = true;
/* 125 */       if (this._properties != null) {
/*     */         
/* 127 */         Iterator<MatrixSortOrderPropertyModel> it = this._properties.iterator();
/* 128 */         while (it.hasNext())
/*     */         {
/* 130 */           ((MatrixSortOrderPropertyModel)it.next()).setMatrixSortType_noev(argMatrixSortType);
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
/*     */   public String getMatrixSortId() {
/* 143 */     return getDAO_().getMatrixSortId();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setMatrixSortId(String argMatrixSortId) {
/* 151 */     if (setMatrixSortId_noev(argMatrixSortId) && 
/* 152 */       this._events != null && 
/* 153 */       postEventsForChanges()) {
/* 154 */       this._events.post(IMatrixSortOrder.SET_MATRIXSORTID, argMatrixSortId);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setMatrixSortId_noev(String argMatrixSortId) {
/* 161 */     boolean ev_postable = false;
/*     */     
/* 163 */     if ((getDAO_().getMatrixSortId() == null && argMatrixSortId != null) || (
/* 164 */       getDAO_().getMatrixSortId() != null && !getDAO_().getMatrixSortId().equals(argMatrixSortId))) {
/* 165 */       getDAO_().setMatrixSortId(argMatrixSortId);
/* 166 */       ev_postable = true;
/* 167 */       if (this._properties != null) {
/*     */         
/* 169 */         Iterator<MatrixSortOrderPropertyModel> it = this._properties.iterator();
/* 170 */         while (it.hasNext())
/*     */         {
/* 172 */           ((MatrixSortOrderPropertyModel)it.next()).setMatrixSortId_noev(argMatrixSortId);
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
/*     */   public String getOrgCode() {
/* 185 */     return getDAO_().getOrgCode();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setOrgCode(String argOrgCode) {
/* 193 */     if (setOrgCode_noev(argOrgCode) && 
/* 194 */       this._events != null && 
/* 195 */       postEventsForChanges()) {
/* 196 */       this._events.post(IMatrixSortOrder.SET_ORGCODE, argOrgCode);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setOrgCode_noev(String argOrgCode) {
/* 203 */     boolean ev_postable = false;
/*     */     
/* 205 */     if ((getDAO_().getOrgCode() == null && argOrgCode != null) || (
/* 206 */       getDAO_().getOrgCode() != null && !getDAO_().getOrgCode().equals(argOrgCode))) {
/* 207 */       getDAO_().setOrgCode(argOrgCode);
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
/*     */   public String getOrgValue() {
/* 219 */     return getDAO_().getOrgValue();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setOrgValue(String argOrgValue) {
/* 227 */     if (setOrgValue_noev(argOrgValue) && 
/* 228 */       this._events != null && 
/* 229 */       postEventsForChanges()) {
/* 230 */       this._events.post(IMatrixSortOrder.SET_ORGVALUE, argOrgValue);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setOrgValue_noev(String argOrgValue) {
/* 237 */     boolean ev_postable = false;
/*     */     
/* 239 */     if ((getDAO_().getOrgValue() == null && argOrgValue != null) || (
/* 240 */       getDAO_().getOrgValue() != null && !getDAO_().getOrgValue().equals(argOrgValue))) {
/* 241 */       getDAO_().setOrgValue(argOrgValue);
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
/*     */   public Date getCreateDate() {
/* 253 */     return getDAO_().getCreateDate();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setCreateDate(Date argCreateDate) {
/* 261 */     if (setCreateDate_noev(argCreateDate) && 
/* 262 */       this._events != null && 
/* 263 */       postEventsForChanges()) {
/* 264 */       this._events.post(IMatrixSortOrder.SET_CREATEDATE, argCreateDate);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setCreateDate_noev(Date argCreateDate) {
/* 271 */     boolean ev_postable = false;
/*     */     
/* 273 */     if ((getDAO_().getCreateDate() == null && argCreateDate != null) || (
/* 274 */       getDAO_().getCreateDate() != null && !getDAO_().getCreateDate().equals(argCreateDate))) {
/* 275 */       getDAO_().setCreateDate(argCreateDate);
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
/*     */   public String getCreateUserId() {
/* 287 */     return getDAO_().getCreateUserId();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setCreateUserId(String argCreateUserId) {
/* 295 */     if (setCreateUserId_noev(argCreateUserId) && 
/* 296 */       this._events != null && 
/* 297 */       postEventsForChanges()) {
/* 298 */       this._events.post(IMatrixSortOrder.SET_CREATEUSERID, argCreateUserId);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setCreateUserId_noev(String argCreateUserId) {
/* 305 */     boolean ev_postable = false;
/*     */     
/* 307 */     if ((getDAO_().getCreateUserId() == null && argCreateUserId != null) || (
/* 308 */       getDAO_().getCreateUserId() != null && !getDAO_().getCreateUserId().equals(argCreateUserId))) {
/* 309 */       getDAO_().setCreateUserId(argCreateUserId);
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
/*     */   public Date getUpdateDate() {
/* 321 */     return getDAO_().getUpdateDate();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setUpdateDate(Date argUpdateDate) {
/* 329 */     if (setUpdateDate_noev(argUpdateDate) && 
/* 330 */       this._events != null && 
/* 331 */       postEventsForChanges()) {
/* 332 */       this._events.post(IMatrixSortOrder.SET_UPDATEDATE, argUpdateDate);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setUpdateDate_noev(Date argUpdateDate) {
/* 339 */     boolean ev_postable = false;
/*     */     
/* 341 */     if ((getDAO_().getUpdateDate() == null && argUpdateDate != null) || (
/* 342 */       getDAO_().getUpdateDate() != null && !getDAO_().getUpdateDate().equals(argUpdateDate))) {
/* 343 */       getDAO_().setUpdateDate(argUpdateDate);
/* 344 */       ev_postable = true;
/*     */     } 
/*     */     
/* 347 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getUpdateUserId() {
/* 355 */     return getDAO_().getUpdateUserId();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setUpdateUserId(String argUpdateUserId) {
/* 363 */     if (setUpdateUserId_noev(argUpdateUserId) && 
/* 364 */       this._events != null && 
/* 365 */       postEventsForChanges()) {
/* 366 */       this._events.post(IMatrixSortOrder.SET_UPDATEUSERID, argUpdateUserId);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setUpdateUserId_noev(String argUpdateUserId) {
/* 373 */     boolean ev_postable = false;
/*     */     
/* 375 */     if ((getDAO_().getUpdateUserId() == null && argUpdateUserId != null) || (
/* 376 */       getDAO_().getUpdateUserId() != null && !getDAO_().getUpdateUserId().equals(argUpdateUserId))) {
/* 377 */       getDAO_().setUpdateUserId(argUpdateUserId);
/* 378 */       ev_postable = true;
/*     */     } 
/*     */     
/* 381 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int getSortOrder() {
/* 389 */     if (getDAO_().getSortOrder() != null) {
/* 390 */       return getDAO_().getSortOrder().intValue();
/*     */     }
/*     */     
/* 393 */     return 0;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setSortOrder(int argSortOrder) {
/* 402 */     if (setSortOrder_noev(argSortOrder) && 
/* 403 */       this._events != null && 
/* 404 */       postEventsForChanges()) {
/* 405 */       this._events.post(IMatrixSortOrder.SET_SORTORDER, Integer.valueOf(argSortOrder));
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setSortOrder_noev(int argSortOrder) {
/* 412 */     boolean ev_postable = false;
/*     */     
/* 414 */     if ((getDAO_().getSortOrder() == null && Integer.valueOf(argSortOrder) != null) || (
/* 415 */       getDAO_().getSortOrder() != null && !getDAO_().getSortOrder().equals(Integer.valueOf(argSortOrder)))) {
/* 416 */       getDAO_().setSortOrder(Integer.valueOf(argSortOrder));
/* 417 */       ev_postable = true;
/*     */     } 
/*     */     
/* 420 */     return ev_postable;
/*     */   }
/*     */   
/*     */   protected IMatrixSortOrderProperty newProperty(String argPropertyName) {
/* 424 */     MatrixSortOrderPropertyId id = new MatrixSortOrderPropertyId();
/*     */     
/* 426 */     id.setMatrixSortType(getMatrixSortType());
/* 427 */     id.setMatrixSortId(getMatrixSortId());
/* 428 */     id.setPropertyCode(argPropertyName);
/*     */     
/* 430 */     IMatrixSortOrderProperty prop = (IMatrixSortOrderProperty)DataFactory.getInstance().createNewObject((IObjectId)id, IMatrixSortOrderProperty.class);
/* 431 */     return prop;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @Relationship(name = "Properties")
/*     */   public List<IMatrixSortOrderProperty> getProperties() {
/* 440 */     if (this._properties == null) {
/* 441 */       this._properties = new HistoricalList(null);
/*     */     }
/* 443 */     return (List<IMatrixSortOrderProperty>)this._properties;
/*     */   }
/*     */   
/*     */   public void setProperties(List<IMatrixSortOrderProperty> argProperties) {
/* 447 */     if (this._properties == null) {
/* 448 */       this._properties = new HistoricalList(argProperties);
/*     */     } else {
/* 450 */       this._properties.setCurrentList(argProperties);
/*     */     } 
/*     */     
/* 453 */     for (IMatrixSortOrderProperty child : this._properties) {
/* 454 */       MatrixSortOrderPropertyModel model = (MatrixSortOrderPropertyModel)child;
/* 455 */       model.setOrganizationId_noev(getOrganizationId());
/* 456 */       model.setMatrixSortType_noev(getMatrixSortType());
/* 457 */       model.setMatrixSortId_noev(getMatrixSortId());
/* 458 */       if (child instanceof IDataModelImpl) {
/* 459 */         IDataAccessObject childDao = ((IDataModelImpl)child).getDAO();
/* 460 */         if (StringUtils.isEmpty(childDao.getOriginDataSource()) && 
/* 461 */           !StringUtils.isEmpty(getDAO().getOriginDataSource())) {
/* 462 */           childDao.setOriginDataSource(getDAO().getOriginDataSource());
/*     */         }
/*     */       } 
/* 465 */       if (postEventsForChanges()) {
/* 466 */         this._eventManager.registerEventHandler((IEventAware)this._eventCascade, (IEventSource)child);
/*     */       }
/*     */     } 
/*     */   }
/*     */   
/*     */   public void addMatrixSortOrderProperty(IMatrixSortOrderProperty argMatrixSortOrderProperty) {
/* 472 */     if (this._properties == null) {
/* 473 */       this._properties = new HistoricalList(null);
/*     */     }
/* 475 */     argMatrixSortOrderProperty.setOrganizationId(getOrganizationId());
/* 476 */     argMatrixSortOrderProperty.setMatrixSortType(getMatrixSortType());
/* 477 */     argMatrixSortOrderProperty.setMatrixSortId(getMatrixSortId());
/* 478 */     if (argMatrixSortOrderProperty instanceof IDataModelImpl) {
/* 479 */       IDataAccessObject childDao = ((IDataModelImpl)argMatrixSortOrderProperty).getDAO();
/* 480 */       if (StringUtils.isEmpty(childDao.getOriginDataSource()) && 
/* 481 */         !StringUtils.isEmpty(getDAO().getOriginDataSource())) {
/* 482 */         childDao.setOriginDataSource(getDAO().getOriginDataSource());
/*     */       }
/*     */     } 
/*     */ 
/*     */     
/* 487 */     if (postEventsForChanges()) {
/* 488 */       this._eventManager.registerEventHandler((IEventAware)this._eventCascade, (IEventSource)new EventDescriptor(argMatrixSortOrderProperty));
/*     */     }
/*     */     
/* 491 */     this._properties.add(argMatrixSortOrderProperty);
/* 492 */     if (postEventsForChanges()) {
/* 493 */       this._events.post(IMatrixSortOrder.ADD_PROPERTIES, argMatrixSortOrderProperty);
/*     */     }
/*     */   }
/*     */   
/*     */   public void removeMatrixSortOrderProperty(IMatrixSortOrderProperty argMatrixSortOrderProperty) {
/* 498 */     if (this._properties != null) {
/*     */       
/* 500 */       if (postEventsForChanges()) {
/* 501 */         this._eventManager.deregisterEventHandler((IEventAware)this._eventCascade, (IEventSource)new EventDescriptor(argMatrixSortOrderProperty));
/*     */       }
/* 503 */       this._properties.remove(argMatrixSortOrderProperty);
/* 504 */       if (postEventsForChanges()) {
/* 505 */         this._events.post(IMatrixSortOrder.REMOVE_PROPERTIES, argMatrixSortOrderProperty);
/*     */       }
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public Object getValue(String argFieldId) {
/* 512 */     if ("Properties".equals(argFieldId)) {
/* 513 */       return getProperties();
/*     */     }
/* 515 */     if ("MatrixSortOrderExtension".equals(argFieldId)) {
/* 516 */       return this._myExtension;
/*     */     }
/*     */     
/* 519 */     return super.getValue(argFieldId);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void setValue(String argFieldId, Object argValue) {
/* 525 */     if ("Properties".equals(argFieldId)) {
/* 526 */       setProperties(changeToList(argValue, IMatrixSortOrderProperty.class));
/*     */     }
/* 528 */     else if ("MatrixSortOrderExtension".equals(argFieldId)) {
/* 529 */       this._myExtension = (IDataModel)argValue;
/*     */     } else {
/*     */       
/* 532 */       super.setValue(argFieldId, argValue);
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public void setDependencies(IPersistenceDefaults argPD, EventManager argEM) {
/* 538 */     this._persistenceDefaults = argPD;
/* 539 */     this._daoImpl.setPersistenceDefaults(argPD);
/* 540 */     this._eventManager = argEM;
/* 541 */     this._events = (Eventor)new ModelEventor((IDataModel)this, argEM);
/* 542 */     this._eventCascade = (EventHandler)new CascadingHandler(this);
/* 543 */     if (this._properties != null) {
/* 544 */       for (IMatrixSortOrderProperty relationship : this._properties) {
/* 545 */         ((IDataModelImpl)relationship).setDependencies(argPD, argEM);
/*     */       }
/*     */     }
/*     */   }
/*     */   
/*     */   public IDataModel getMatrixSortOrderExt() {
/* 551 */     return this._myExtension;
/*     */   }
/*     */   
/*     */   public void setMatrixSortOrderExt(IDataModel argExt) {
/* 555 */     this._myExtension = argExt;
/*     */   }
/*     */ 
/*     */   
/*     */   public void startTransaction() {
/* 560 */     if (this._alreadyInStart) {
/*     */       return;
/*     */     }
/*     */     
/* 564 */     this._alreadyInStart = true;
/*     */ 
/*     */     
/* 567 */     super.startTransaction();
/*     */     
/* 569 */     this._propertiesSavepoint = this._properties;
/* 570 */     if (this._properties != null) {
/* 571 */       this._propertiesSavepoint = new HistoricalList((List)this._properties);
/* 572 */       Iterator<IDataModel> it = this._properties.iterator();
/* 573 */       while (it.hasNext()) {
/* 574 */         ((IDataModel)it.next()).startTransaction();
/*     */       }
/*     */     } 
/*     */ 
/*     */     
/* 579 */     this._alreadyInStart = false;
/*     */   }
/*     */ 
/*     */   
/*     */   public void rollbackChanges() {
/* 584 */     if (isAlreadyRolledBack()) {
/*     */       return;
/*     */     }
/* 587 */     super.rollbackChanges();
/*     */     
/* 589 */     this._properties = this._propertiesSavepoint;
/* 590 */     this._propertiesSavepoint = null;
/* 591 */     if (this._properties != null) {
/* 592 */       Iterator<IDataModel> it = this._properties.iterator();
/* 593 */       while (it.hasNext()) {
/* 594 */         ((IDataModel)it.next()).rollbackChanges();
/*     */       }
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void commitTransaction() {
/* 602 */     if (this._alreadyInCommit) {
/*     */       return;
/*     */     }
/* 605 */     this._alreadyInCommit = true;
/*     */ 
/*     */     
/* 608 */     super.commitTransaction();
/*     */     
/* 610 */     this._propertiesSavepoint = this._properties;
/* 611 */     if (this._properties != null) {
/* 612 */       Iterator<IDataModel> it = this._properties.iterator();
/* 613 */       while (it.hasNext()) {
/* 614 */         ((IDataModel)it.next()).commitTransaction();
/*     */       }
/* 616 */       this._properties = new HistoricalList((List)this._properties);
/*     */     } 
/*     */ 
/*     */     
/* 620 */     this._alreadyInCommit = false;
/*     */   }
/*     */ 
/*     */   
/*     */   private void readObject(ObjectInputStream argStream) throws IOException, ClassNotFoundException {
/* 625 */     argStream.defaultReadObject();
/*     */   }
/*     */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\itm\impl\MatrixSortOrderModel.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */