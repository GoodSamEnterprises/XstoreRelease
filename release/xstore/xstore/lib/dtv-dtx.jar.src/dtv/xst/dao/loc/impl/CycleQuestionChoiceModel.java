/*     */ package dtv.xst.dao.loc.impl;
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
/*     */ import dtv.xst.dao.loc.CycleQuestionChoicePropertyId;
/*     */ import dtv.xst.dao.loc.ICycleQuestionChoice;
/*     */ import dtv.xst.dao.loc.ICycleQuestionChoiceProperty;
/*     */ import java.io.IOException;
/*     */ import java.io.ObjectInputStream;
/*     */ import java.util.Date;
/*     */ import java.util.Iterator;
/*     */ import java.util.List;
/*     */ 
/*     */ public class CycleQuestionChoiceModel extends AbstractDataModelWithPropertyImpl<ICycleQuestionChoiceProperty> implements ICycleQuestionChoice {
/*     */   private static final long serialVersionUID = -1352457331L;
/*     */   private transient boolean _alreadyInStart = false;
/*     */   private transient boolean _alreadyInCommit = false;
/*     */   
/*     */   public String toString() {
/*  33 */     return super.toString() + " Id: " + getObjectId();
/*     */   }
/*     */   private IDataModel _myExtension; private HistoricalList<ICycleQuestionChoiceProperty> _properties; private transient HistoricalList<ICycleQuestionChoiceProperty> _propertiesSavepoint;
/*     */   
/*     */   public void initDAO() {
/*  38 */     setDAO((IDataAccessObject)new CycleQuestionChoiceDAO());
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private CycleQuestionChoiceDAO getDAO_() {
/*  46 */     return (CycleQuestionChoiceDAO)this._daoImpl;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getAnswerId() {
/*  54 */     return getDAO_().getAnswerId();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setAnswerId(String argAnswerId) {
/*  62 */     if (setAnswerId_noev(argAnswerId) && 
/*  63 */       this._events != null && 
/*  64 */       postEventsForChanges()) {
/*  65 */       this._events.post(ICycleQuestionChoice.SET_ANSWERID, argAnswerId);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setAnswerId_noev(String argAnswerId) {
/*  72 */     boolean ev_postable = false;
/*     */     
/*  74 */     if ((getDAO_().getAnswerId() == null && argAnswerId != null) || (
/*  75 */       getDAO_().getAnswerId() != null && !getDAO_().getAnswerId().equals(argAnswerId))) {
/*  76 */       getDAO_().setAnswerId(argAnswerId);
/*  77 */       ev_postable = true;
/*  78 */       if (this._properties != null) {
/*     */         
/*  80 */         Iterator<CycleQuestionChoicePropertyModel> it = this._properties.iterator();
/*  81 */         while (it.hasNext())
/*     */         {
/*  83 */           ((CycleQuestionChoicePropertyModel)it.next()).setAnswerId_noev(argAnswerId);
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
/* 112 */       this._events.post(ICycleQuestionChoice.SET_ORGANIZATIONID, Long.valueOf(argOrganizationId));
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
/* 127 */         Iterator<CycleQuestionChoicePropertyModel> it = this._properties.iterator();
/* 128 */         while (it.hasNext())
/*     */         {
/* 130 */           ((CycleQuestionChoicePropertyModel)it.next()).setOrganizationId_noev(argOrganizationId);
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
/*     */   public String getQuestionId() {
/* 143 */     return getDAO_().getQuestionId();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setQuestionId(String argQuestionId) {
/* 151 */     if (setQuestionId_noev(argQuestionId) && 
/* 152 */       this._events != null && 
/* 153 */       postEventsForChanges()) {
/* 154 */       this._events.post(ICycleQuestionChoice.SET_QUESTIONID, argQuestionId);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setQuestionId_noev(String argQuestionId) {
/* 161 */     boolean ev_postable = false;
/*     */     
/* 163 */     if ((getDAO_().getQuestionId() == null && argQuestionId != null) || (
/* 164 */       getDAO_().getQuestionId() != null && !getDAO_().getQuestionId().equals(argQuestionId))) {
/* 165 */       getDAO_().setQuestionId(argQuestionId);
/* 166 */       ev_postable = true;
/* 167 */       if (this._properties != null) {
/*     */         
/* 169 */         Iterator<CycleQuestionChoicePropertyModel> it = this._properties.iterator();
/* 170 */         while (it.hasNext())
/*     */         {
/* 172 */           ((CycleQuestionChoicePropertyModel)it.next()).setQuestionId_noev(argQuestionId);
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
/* 196 */       this._events.post(ICycleQuestionChoice.SET_CREATEDATE, argCreateDate);
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
/* 230 */       this._events.post(ICycleQuestionChoice.SET_CREATEUSERID, argCreateUserId);
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
/* 264 */       this._events.post(ICycleQuestionChoice.SET_UPDATEDATE, argUpdateDate);
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
/* 298 */       this._events.post(ICycleQuestionChoice.SET_UPDATEUSERID, argUpdateUserId);
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
/*     */   public String getAnswerTextKey() {
/* 321 */     return getDAO_().getAnswerTextKey();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setAnswerTextKey(String argAnswerTextKey) {
/* 329 */     if (setAnswerTextKey_noev(argAnswerTextKey) && 
/* 330 */       this._events != null && 
/* 331 */       postEventsForChanges()) {
/* 332 */       this._events.post(ICycleQuestionChoice.SET_ANSWERTEXTKEY, argAnswerTextKey);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setAnswerTextKey_noev(String argAnswerTextKey) {
/* 339 */     boolean ev_postable = false;
/*     */     
/* 341 */     if ((getDAO_().getAnswerTextKey() == null && argAnswerTextKey != null) || (
/* 342 */       getDAO_().getAnswerTextKey() != null && !getDAO_().getAnswerTextKey().equals(argAnswerTextKey))) {
/* 343 */       getDAO_().setAnswerTextKey(argAnswerTextKey);
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
/*     */   public int getSortOrder() {
/* 355 */     if (getDAO_().getSortOrder() != null) {
/* 356 */       return getDAO_().getSortOrder().intValue();
/*     */     }
/*     */     
/* 359 */     return 0;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setSortOrder(int argSortOrder) {
/* 368 */     if (setSortOrder_noev(argSortOrder) && 
/* 369 */       this._events != null && 
/* 370 */       postEventsForChanges()) {
/* 371 */       this._events.post(ICycleQuestionChoice.SET_SORTORDER, Integer.valueOf(argSortOrder));
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setSortOrder_noev(int argSortOrder) {
/* 378 */     boolean ev_postable = false;
/*     */     
/* 380 */     if ((getDAO_().getSortOrder() == null && Integer.valueOf(argSortOrder) != null) || (
/* 381 */       getDAO_().getSortOrder() != null && !getDAO_().getSortOrder().equals(Integer.valueOf(argSortOrder)))) {
/* 382 */       getDAO_().setSortOrder(Integer.valueOf(argSortOrder));
/* 383 */       ev_postable = true;
/*     */     } 
/*     */     
/* 386 */     return ev_postable;
/*     */   }
/*     */   
/*     */   protected ICycleQuestionChoiceProperty newProperty(String argPropertyName) {
/* 390 */     CycleQuestionChoicePropertyId id = new CycleQuestionChoicePropertyId();
/*     */     
/* 392 */     id.setAnswerId(getAnswerId());
/* 393 */     id.setQuestionId(getQuestionId());
/* 394 */     id.setPropertyCode(argPropertyName);
/*     */     
/* 396 */     ICycleQuestionChoiceProperty prop = (ICycleQuestionChoiceProperty)DataFactory.getInstance().createNewObject((IObjectId)id, ICycleQuestionChoiceProperty.class);
/* 397 */     return prop;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @Relationship(name = "Properties")
/*     */   public List<ICycleQuestionChoiceProperty> getProperties() {
/* 406 */     if (this._properties == null) {
/* 407 */       this._properties = new HistoricalList(null);
/*     */     }
/* 409 */     return (List<ICycleQuestionChoiceProperty>)this._properties;
/*     */   }
/*     */   
/*     */   public void setProperties(List<ICycleQuestionChoiceProperty> argProperties) {
/* 413 */     if (this._properties == null) {
/* 414 */       this._properties = new HistoricalList(argProperties);
/*     */     } else {
/* 416 */       this._properties.setCurrentList(argProperties);
/*     */     } 
/*     */     
/* 419 */     for (ICycleQuestionChoiceProperty child : this._properties) {
/* 420 */       CycleQuestionChoicePropertyModel model = (CycleQuestionChoicePropertyModel)child;
/* 421 */       model.setAnswerId_noev(getAnswerId());
/* 422 */       model.setOrganizationId_noev(getOrganizationId());
/* 423 */       model.setQuestionId_noev(getQuestionId());
/* 424 */       if (child instanceof IDataModelImpl) {
/* 425 */         IDataAccessObject childDao = ((IDataModelImpl)child).getDAO();
/* 426 */         if (StringUtils.isEmpty(childDao.getOriginDataSource()) && 
/* 427 */           !StringUtils.isEmpty(getDAO().getOriginDataSource())) {
/* 428 */           childDao.setOriginDataSource(getDAO().getOriginDataSource());
/*     */         }
/*     */       } 
/* 431 */       if (postEventsForChanges()) {
/* 432 */         this._eventManager.registerEventHandler((IEventAware)this._eventCascade, (IEventSource)child);
/*     */       }
/*     */     } 
/*     */   }
/*     */   
/*     */   public void addCycleQuestionChoiceProperty(ICycleQuestionChoiceProperty argCycleQuestionChoiceProperty) {
/* 438 */     if (this._properties == null) {
/* 439 */       this._properties = new HistoricalList(null);
/*     */     }
/* 441 */     argCycleQuestionChoiceProperty.setAnswerId(getAnswerId());
/* 442 */     argCycleQuestionChoiceProperty.setOrganizationId(getOrganizationId());
/* 443 */     argCycleQuestionChoiceProperty.setQuestionId(getQuestionId());
/* 444 */     if (argCycleQuestionChoiceProperty instanceof IDataModelImpl) {
/* 445 */       IDataAccessObject childDao = ((IDataModelImpl)argCycleQuestionChoiceProperty).getDAO();
/* 446 */       if (StringUtils.isEmpty(childDao.getOriginDataSource()) && 
/* 447 */         !StringUtils.isEmpty(getDAO().getOriginDataSource())) {
/* 448 */         childDao.setOriginDataSource(getDAO().getOriginDataSource());
/*     */       }
/*     */     } 
/*     */ 
/*     */     
/* 453 */     if (postEventsForChanges()) {
/* 454 */       this._eventManager.registerEventHandler((IEventAware)this._eventCascade, (IEventSource)new EventDescriptor(argCycleQuestionChoiceProperty));
/*     */     }
/*     */     
/* 457 */     this._properties.add(argCycleQuestionChoiceProperty);
/* 458 */     if (postEventsForChanges()) {
/* 459 */       this._events.post(ICycleQuestionChoice.ADD_PROPERTIES, argCycleQuestionChoiceProperty);
/*     */     }
/*     */   }
/*     */   
/*     */   public void removeCycleQuestionChoiceProperty(ICycleQuestionChoiceProperty argCycleQuestionChoiceProperty) {
/* 464 */     if (this._properties != null) {
/*     */       
/* 466 */       if (postEventsForChanges()) {
/* 467 */         this._eventManager.deregisterEventHandler((IEventAware)this._eventCascade, (IEventSource)new EventDescriptor(argCycleQuestionChoiceProperty));
/*     */       }
/* 469 */       this._properties.remove(argCycleQuestionChoiceProperty);
/* 470 */       if (postEventsForChanges()) {
/* 471 */         this._events.post(ICycleQuestionChoice.REMOVE_PROPERTIES, argCycleQuestionChoiceProperty);
/*     */       }
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public Object getValue(String argFieldId) {
/* 478 */     if ("Properties".equals(argFieldId)) {
/* 479 */       return getProperties();
/*     */     }
/* 481 */     if ("CycleQuestionChoiceExtension".equals(argFieldId)) {
/* 482 */       return this._myExtension;
/*     */     }
/*     */     
/* 485 */     return super.getValue(argFieldId);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void setValue(String argFieldId, Object argValue) {
/* 491 */     if ("Properties".equals(argFieldId)) {
/* 492 */       setProperties(changeToList(argValue, ICycleQuestionChoiceProperty.class));
/*     */     }
/* 494 */     else if ("CycleQuestionChoiceExtension".equals(argFieldId)) {
/* 495 */       this._myExtension = (IDataModel)argValue;
/*     */     } else {
/*     */       
/* 498 */       super.setValue(argFieldId, argValue);
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public void setDependencies(IPersistenceDefaults argPD, EventManager argEM) {
/* 504 */     this._persistenceDefaults = argPD;
/* 505 */     this._daoImpl.setPersistenceDefaults(argPD);
/* 506 */     this._eventManager = argEM;
/* 507 */     this._events = (Eventor)new ModelEventor((IDataModel)this, argEM);
/* 508 */     this._eventCascade = (EventHandler)new CascadingHandler(this);
/* 509 */     if (this._properties != null) {
/* 510 */       for (ICycleQuestionChoiceProperty relationship : this._properties) {
/* 511 */         ((IDataModelImpl)relationship).setDependencies(argPD, argEM);
/*     */       }
/*     */     }
/*     */   }
/*     */   
/*     */   public IDataModel getCycleQuestionChoiceExt() {
/* 517 */     return this._myExtension;
/*     */   }
/*     */   
/*     */   public void setCycleQuestionChoiceExt(IDataModel argExt) {
/* 521 */     this._myExtension = argExt;
/*     */   }
/*     */ 
/*     */   
/*     */   public void startTransaction() {
/* 526 */     if (this._alreadyInStart) {
/*     */       return;
/*     */     }
/*     */     
/* 530 */     this._alreadyInStart = true;
/*     */ 
/*     */     
/* 533 */     super.startTransaction();
/*     */     
/* 535 */     this._propertiesSavepoint = this._properties;
/* 536 */     if (this._properties != null) {
/* 537 */       this._propertiesSavepoint = new HistoricalList((List)this._properties);
/* 538 */       Iterator<IDataModel> it = this._properties.iterator();
/* 539 */       while (it.hasNext()) {
/* 540 */         ((IDataModel)it.next()).startTransaction();
/*     */       }
/*     */     } 
/*     */ 
/*     */     
/* 545 */     this._alreadyInStart = false;
/*     */   }
/*     */ 
/*     */   
/*     */   public void rollbackChanges() {
/* 550 */     if (isAlreadyRolledBack()) {
/*     */       return;
/*     */     }
/* 553 */     super.rollbackChanges();
/*     */     
/* 555 */     this._properties = this._propertiesSavepoint;
/* 556 */     this._propertiesSavepoint = null;
/* 557 */     if (this._properties != null) {
/* 558 */       Iterator<IDataModel> it = this._properties.iterator();
/* 559 */       while (it.hasNext()) {
/* 560 */         ((IDataModel)it.next()).rollbackChanges();
/*     */       }
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void commitTransaction() {
/* 568 */     if (this._alreadyInCommit) {
/*     */       return;
/*     */     }
/* 571 */     this._alreadyInCommit = true;
/*     */ 
/*     */     
/* 574 */     super.commitTransaction();
/*     */     
/* 576 */     this._propertiesSavepoint = this._properties;
/* 577 */     if (this._properties != null) {
/* 578 */       Iterator<IDataModel> it = this._properties.iterator();
/* 579 */       while (it.hasNext()) {
/* 580 */         ((IDataModel)it.next()).commitTransaction();
/*     */       }
/* 582 */       this._properties = new HistoricalList((List)this._properties);
/*     */     } 
/*     */ 
/*     */     
/* 586 */     this._alreadyInCommit = false;
/*     */   }
/*     */ 
/*     */   
/*     */   private void readObject(ObjectInputStream argStream) throws IOException, ClassNotFoundException {
/* 591 */     argStream.defaultReadObject();
/*     */   }
/*     */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\loc\impl\CycleQuestionChoiceModel.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */