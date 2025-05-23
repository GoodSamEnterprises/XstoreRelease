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
/*     */ import dtv.util.HistoricalList;
/*     */ import dtv.util.StringUtils;
/*     */ import dtv.xst.dao.loc.CycleQuestionPropertyId;
/*     */ import dtv.xst.dao.loc.ICycleQuestion;
/*     */ import dtv.xst.dao.loc.ICycleQuestionChoice;
/*     */ import dtv.xst.dao.loc.ICycleQuestionProperty;
/*     */ import java.io.ObjectInputStream;
/*     */ import java.util.Date;
/*     */ import java.util.Iterator;
/*     */ import java.util.List;
/*     */ 
/*     */ public class CycleQuestionModel extends AbstractDataModelWithPropertyImpl<ICycleQuestionProperty> implements ICycleQuestion {
/*     */   private static final long serialVersionUID = -267705652L;
/*     */   private transient boolean _alreadyInStart = false;
/*     */   private transient boolean _alreadyInCommit = false;
/*     */   private IDataModel _myExtension;
/*     */   
/*     */   public String toString() {
/*  33 */     return super.toString() + " Id: " + getObjectId();
/*     */   }
/*     */   private HistoricalList<ICycleQuestionChoice> _questionChoices; private transient HistoricalList<ICycleQuestionChoice> _questionChoicesSavepoint; private HistoricalList<ICycleQuestionProperty> _properties; private transient HistoricalList<ICycleQuestionProperty> _propertiesSavepoint;
/*     */   
/*     */   public void initDAO() {
/*  38 */     setDAO((IDataAccessObject)new CycleQuestionDAO());
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private CycleQuestionDAO getDAO_() {
/*  46 */     return (CycleQuestionDAO)this._daoImpl;
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
/*  70 */       this._events.post(ICycleQuestion.SET_ORGANIZATIONID, Long.valueOf(argOrganizationId));
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
/*  83 */       if (this._questionChoices != null) {
/*     */         
/*  85 */         Iterator<CycleQuestionChoiceModel> it = this._questionChoices.iterator();
/*  86 */         while (it.hasNext())
/*     */         {
/*  88 */           ((CycleQuestionChoiceModel)it.next()).setOrganizationId_noev(argOrganizationId);
/*     */         }
/*     */       } 
/*  91 */       if (this._properties != null) {
/*     */         
/*  93 */         Iterator<CycleQuestionPropertyModel> it = this._properties.iterator();
/*  94 */         while (it.hasNext())
/*     */         {
/*  96 */           ((CycleQuestionPropertyModel)it.next()).setOrganizationId_noev(argOrganizationId);
/*     */         }
/*     */       } 
/*     */     } 
/*     */     
/* 101 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getQuestionId() {
/* 109 */     return getDAO_().getQuestionId();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setQuestionId(String argQuestionId) {
/* 117 */     if (setQuestionId_noev(argQuestionId) && 
/* 118 */       this._events != null && 
/* 119 */       postEventsForChanges()) {
/* 120 */       this._events.post(ICycleQuestion.SET_QUESTIONID, argQuestionId);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setQuestionId_noev(String argQuestionId) {
/* 127 */     boolean ev_postable = false;
/*     */     
/* 129 */     if ((getDAO_().getQuestionId() == null && argQuestionId != null) || (
/* 130 */       getDAO_().getQuestionId() != null && !getDAO_().getQuestionId().equals(argQuestionId))) {
/* 131 */       getDAO_().setQuestionId(argQuestionId);
/* 132 */       ev_postable = true;
/* 133 */       if (this._questionChoices != null) {
/*     */         
/* 135 */         Iterator<CycleQuestionChoiceModel> it = this._questionChoices.iterator();
/* 136 */         while (it.hasNext())
/*     */         {
/* 138 */           ((CycleQuestionChoiceModel)it.next()).setQuestionId_noev(argQuestionId);
/*     */         }
/*     */       } 
/* 141 */       if (this._properties != null) {
/*     */         
/* 143 */         Iterator<CycleQuestionPropertyModel> it = this._properties.iterator();
/* 144 */         while (it.hasNext())
/*     */         {
/* 146 */           ((CycleQuestionPropertyModel)it.next()).setQuestionId_noev(argQuestionId);
/*     */         }
/*     */       } 
/*     */     } 
/*     */     
/* 151 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Date getCreateDate() {
/* 159 */     return getDAO_().getCreateDate();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setCreateDate(Date argCreateDate) {
/* 167 */     if (setCreateDate_noev(argCreateDate) && 
/* 168 */       this._events != null && 
/* 169 */       postEventsForChanges()) {
/* 170 */       this._events.post(ICycleQuestion.SET_CREATEDATE, argCreateDate);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setCreateDate_noev(Date argCreateDate) {
/* 177 */     boolean ev_postable = false;
/*     */     
/* 179 */     if ((getDAO_().getCreateDate() == null && argCreateDate != null) || (
/* 180 */       getDAO_().getCreateDate() != null && !getDAO_().getCreateDate().equals(argCreateDate))) {
/* 181 */       getDAO_().setCreateDate(argCreateDate);
/* 182 */       ev_postable = true;
/*     */     } 
/*     */     
/* 185 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getCreateUserId() {
/* 193 */     return getDAO_().getCreateUserId();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setCreateUserId(String argCreateUserId) {
/* 201 */     if (setCreateUserId_noev(argCreateUserId) && 
/* 202 */       this._events != null && 
/* 203 */       postEventsForChanges()) {
/* 204 */       this._events.post(ICycleQuestion.SET_CREATEUSERID, argCreateUserId);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setCreateUserId_noev(String argCreateUserId) {
/* 211 */     boolean ev_postable = false;
/*     */     
/* 213 */     if ((getDAO_().getCreateUserId() == null && argCreateUserId != null) || (
/* 214 */       getDAO_().getCreateUserId() != null && !getDAO_().getCreateUserId().equals(argCreateUserId))) {
/* 215 */       getDAO_().setCreateUserId(argCreateUserId);
/* 216 */       ev_postable = true;
/*     */     } 
/*     */     
/* 219 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Date getUpdateDate() {
/* 227 */     return getDAO_().getUpdateDate();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setUpdateDate(Date argUpdateDate) {
/* 235 */     if (setUpdateDate_noev(argUpdateDate) && 
/* 236 */       this._events != null && 
/* 237 */       postEventsForChanges()) {
/* 238 */       this._events.post(ICycleQuestion.SET_UPDATEDATE, argUpdateDate);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setUpdateDate_noev(Date argUpdateDate) {
/* 245 */     boolean ev_postable = false;
/*     */     
/* 247 */     if ((getDAO_().getUpdateDate() == null && argUpdateDate != null) || (
/* 248 */       getDAO_().getUpdateDate() != null && !getDAO_().getUpdateDate().equals(argUpdateDate))) {
/* 249 */       getDAO_().setUpdateDate(argUpdateDate);
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
/*     */   public String getUpdateUserId() {
/* 261 */     return getDAO_().getUpdateUserId();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setUpdateUserId(String argUpdateUserId) {
/* 269 */     if (setUpdateUserId_noev(argUpdateUserId) && 
/* 270 */       this._events != null && 
/* 271 */       postEventsForChanges()) {
/* 272 */       this._events.post(ICycleQuestion.SET_UPDATEUSERID, argUpdateUserId);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setUpdateUserId_noev(String argUpdateUserId) {
/* 279 */     boolean ev_postable = false;
/*     */     
/* 281 */     if ((getDAO_().getUpdateUserId() == null && argUpdateUserId != null) || (
/* 282 */       getDAO_().getUpdateUserId() != null && !getDAO_().getUpdateUserId().equals(argUpdateUserId))) {
/* 283 */       getDAO_().setUpdateUserId(argUpdateUserId);
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
/*     */   public Date getEffectiveDate() {
/* 295 */     return getDAO_().getEffectiveDate();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setEffectiveDate(Date argEffectiveDate) {
/* 303 */     if (setEffectiveDate_noev(argEffectiveDate) && 
/* 304 */       this._events != null && 
/* 305 */       postEventsForChanges()) {
/* 306 */       this._events.post(ICycleQuestion.SET_EFFECTIVEDATE, argEffectiveDate);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setEffectiveDate_noev(Date argEffectiveDate) {
/* 313 */     boolean ev_postable = false;
/*     */     
/* 315 */     if ((getDAO_().getEffectiveDate() == null && argEffectiveDate != null) || (
/* 316 */       getDAO_().getEffectiveDate() != null && !getDAO_().getEffectiveDate().equals(argEffectiveDate))) {
/* 317 */       getDAO_().setEffectiveDate(argEffectiveDate);
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
/*     */   public Date getExpirationDate() {
/* 329 */     return getDAO_().getExpirationDate();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setExpirationDate(Date argExpirationDate) {
/* 337 */     if (setExpirationDate_noev(argExpirationDate) && 
/* 338 */       this._events != null && 
/* 339 */       postEventsForChanges()) {
/* 340 */       this._events.post(ICycleQuestion.SET_EXPIRATIONDATE, argExpirationDate);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setExpirationDate_noev(Date argExpirationDate) {
/* 347 */     boolean ev_postable = false;
/*     */     
/* 349 */     if ((getDAO_().getExpirationDate() == null && argExpirationDate != null) || (
/* 350 */       getDAO_().getExpirationDate() != null && !getDAO_().getExpirationDate().equals(argExpirationDate))) {
/* 351 */       getDAO_().setExpirationDate(argExpirationDate);
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
/*     */   public String getQuestionTextKey() {
/* 363 */     return getDAO_().getQuestionTextKey();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setQuestionTextKey(String argQuestionTextKey) {
/* 371 */     if (setQuestionTextKey_noev(argQuestionTextKey) && 
/* 372 */       this._events != null && 
/* 373 */       postEventsForChanges()) {
/* 374 */       this._events.post(ICycleQuestion.SET_QUESTIONTEXTKEY, argQuestionTextKey);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setQuestionTextKey_noev(String argQuestionTextKey) {
/* 381 */     boolean ev_postable = false;
/*     */     
/* 383 */     if ((getDAO_().getQuestionTextKey() == null && argQuestionTextKey != null) || (
/* 384 */       getDAO_().getQuestionTextKey() != null && !getDAO_().getQuestionTextKey().equals(argQuestionTextKey))) {
/* 385 */       getDAO_().setQuestionTextKey(argQuestionTextKey);
/* 386 */       ev_postable = true;
/*     */     } 
/*     */     
/* 389 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getQuestionTypeCode() {
/* 397 */     return getDAO_().getQuestionTypeCode();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setQuestionTypeCode(String argQuestionTypeCode) {
/* 405 */     if (setQuestionTypeCode_noev(argQuestionTypeCode) && 
/* 406 */       this._events != null && 
/* 407 */       postEventsForChanges()) {
/* 408 */       this._events.post(ICycleQuestion.SET_QUESTIONTYPECODE, argQuestionTypeCode);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setQuestionTypeCode_noev(String argQuestionTypeCode) {
/* 415 */     boolean ev_postable = false;
/*     */     
/* 417 */     if ((getDAO_().getQuestionTypeCode() == null && argQuestionTypeCode != null) || (
/* 418 */       getDAO_().getQuestionTypeCode() != null && !getDAO_().getQuestionTypeCode().equals(argQuestionTypeCode))) {
/* 419 */       getDAO_().setQuestionTypeCode(argQuestionTypeCode);
/* 420 */       ev_postable = true;
/*     */     } 
/*     */     
/* 423 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int getSortOrder() {
/* 431 */     if (getDAO_().getSortOrder() != null) {
/* 432 */       return getDAO_().getSortOrder().intValue();
/*     */     }
/*     */     
/* 435 */     return 0;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setSortOrder(int argSortOrder) {
/* 444 */     if (setSortOrder_noev(argSortOrder) && 
/* 445 */       this._events != null && 
/* 446 */       postEventsForChanges()) {
/* 447 */       this._events.post(ICycleQuestion.SET_SORTORDER, Integer.valueOf(argSortOrder));
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setSortOrder_noev(int argSortOrder) {
/* 454 */     boolean ev_postable = false;
/*     */     
/* 456 */     if ((getDAO_().getSortOrder() == null && Integer.valueOf(argSortOrder) != null) || (
/* 457 */       getDAO_().getSortOrder() != null && !getDAO_().getSortOrder().equals(Integer.valueOf(argSortOrder)))) {
/* 458 */       getDAO_().setSortOrder(Integer.valueOf(argSortOrder));
/* 459 */       ev_postable = true;
/*     */     } 
/*     */     
/* 462 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public long getRetailLocationId() {
/* 470 */     if (getDAO_().getRetailLocationId() != null) {
/* 471 */       return getDAO_().getRetailLocationId().longValue();
/*     */     }
/*     */     
/* 474 */     return 0L;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setRetailLocationId(long argRetailLocationId) {
/* 483 */     if (setRetailLocationId_noev(argRetailLocationId) && 
/* 484 */       this._events != null && 
/* 485 */       postEventsForChanges()) {
/* 486 */       this._events.post(ICycleQuestion.SET_RETAILLOCATIONID, Long.valueOf(argRetailLocationId));
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setRetailLocationId_noev(long argRetailLocationId) {
/* 493 */     boolean ev_postable = false;
/*     */     
/* 495 */     if ((getDAO_().getRetailLocationId() == null && Long.valueOf(argRetailLocationId) != null) || (
/* 496 */       getDAO_().getRetailLocationId() != null && !getDAO_().getRetailLocationId().equals(Long.valueOf(argRetailLocationId)))) {
/* 497 */       getDAO_().setRetailLocationId(Long.valueOf(argRetailLocationId));
/* 498 */       ev_postable = true;
/*     */     } 
/*     */     
/* 501 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean getCorporateMessage() {
/* 509 */     if (getDAO_().getCorporateMessage() != null) {
/* 510 */       return getDAO_().getCorporateMessage().booleanValue();
/*     */     }
/*     */     
/* 513 */     return false;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setCorporateMessage(boolean argCorporateMessage) {
/* 522 */     if (setCorporateMessage_noev(argCorporateMessage) && 
/* 523 */       this._events != null && 
/* 524 */       postEventsForChanges()) {
/* 525 */       this._events.post(ICycleQuestion.SET_CORPORATEMESSAGE, Boolean.valueOf(argCorporateMessage));
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setCorporateMessage_noev(boolean argCorporateMessage) {
/* 532 */     boolean ev_postable = false;
/*     */     
/* 534 */     if ((getDAO_().getCorporateMessage() == null && Boolean.valueOf(argCorporateMessage) != null) || (
/* 535 */       getDAO_().getCorporateMessage() != null && !getDAO_().getCorporateMessage().equals(Boolean.valueOf(argCorporateMessage)))) {
/* 536 */       getDAO_().setCorporateMessage(Boolean.valueOf(argCorporateMessage));
/* 537 */       ev_postable = true;
/*     */     } 
/*     */     
/* 540 */     return ev_postable;
/*     */   }
/*     */   
/*     */   protected ICycleQuestionProperty newProperty(String argPropertyName) {
/* 544 */     CycleQuestionPropertyId id = new CycleQuestionPropertyId();
/*     */     
/* 546 */     id.setQuestionId(getQuestionId());
/* 547 */     id.setPropertyCode(argPropertyName);
/*     */     
/* 549 */     ICycleQuestionProperty prop = (ICycleQuestionProperty)DataFactory.getInstance().createNewObject((IObjectId)id, ICycleQuestionProperty.class);
/* 550 */     return prop;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @Relationship(name = "QuestionChoices")
/*     */   public List<ICycleQuestionChoice> getQuestionChoices() {
/* 562 */     if (this._questionChoices == null) {
/* 563 */       this._questionChoices = new HistoricalList(null);
/*     */     }
/* 565 */     return (List<ICycleQuestionChoice>)this._questionChoices;
/*     */   }
/*     */   
/*     */   public void setQuestionChoices(List<ICycleQuestionChoice> argQuestionChoices) {
/* 569 */     if (this._questionChoices == null) {
/* 570 */       this._questionChoices = new HistoricalList(argQuestionChoices);
/*     */     } else {
/* 572 */       this._questionChoices.setCurrentList(argQuestionChoices);
/*     */     } 
/*     */     
/* 575 */     for (ICycleQuestionChoice child : this._questionChoices) {
/* 576 */       CycleQuestionChoiceModel model = (CycleQuestionChoiceModel)child;
/* 577 */       model.setOrganizationId_noev(getOrganizationId());
/* 578 */       model.setQuestionId_noev(getQuestionId());
/* 579 */       if (child instanceof IDataModelImpl) {
/* 580 */         IDataAccessObject childDao = ((IDataModelImpl)child).getDAO();
/* 581 */         if (StringUtils.isEmpty(childDao.getOriginDataSource()) && 
/* 582 */           !StringUtils.isEmpty(getDAO().getOriginDataSource())) {
/* 583 */           childDao.setOriginDataSource(getDAO().getOriginDataSource());
/*     */         }
/*     */       } 
/* 586 */       if (postEventsForChanges()) {
/* 587 */         this._eventManager.registerEventHandler((IEventAware)this._eventCascade, (IEventSource)child);
/*     */       }
/*     */     } 
/*     */   }
/*     */   
/*     */   public void addCycleQuestionChoice(ICycleQuestionChoice argCycleQuestionChoice) {
/* 593 */     if (this._questionChoices == null) {
/* 594 */       this._questionChoices = new HistoricalList(null);
/*     */     }
/* 596 */     argCycleQuestionChoice.setOrganizationId(getOrganizationId());
/* 597 */     argCycleQuestionChoice.setQuestionId(getQuestionId());
/* 598 */     if (argCycleQuestionChoice instanceof IDataModelImpl) {
/* 599 */       IDataAccessObject childDao = ((IDataModelImpl)argCycleQuestionChoice).getDAO();
/* 600 */       if (StringUtils.isEmpty(childDao.getOriginDataSource()) && 
/* 601 */         !StringUtils.isEmpty(getDAO().getOriginDataSource())) {
/* 602 */         childDao.setOriginDataSource(getDAO().getOriginDataSource());
/*     */       }
/*     */     } 
/*     */ 
/*     */     
/* 607 */     if (postEventsForChanges()) {
/* 608 */       this._eventManager.registerEventHandler((IEventAware)this._eventCascade, (IEventSource)new EventDescriptor(argCycleQuestionChoice));
/*     */     }
/*     */     
/* 611 */     this._questionChoices.add(argCycleQuestionChoice);
/* 612 */     if (postEventsForChanges()) {
/* 613 */       this._events.post(ICycleQuestion.ADD_QUESTIONCHOICES, argCycleQuestionChoice);
/*     */     }
/*     */   }
/*     */   
/*     */   public void removeCycleQuestionChoice(ICycleQuestionChoice argCycleQuestionChoice) {
/* 618 */     if (this._questionChoices != null) {
/*     */       
/* 620 */       if (postEventsForChanges()) {
/* 621 */         this._eventManager.deregisterEventHandler((IEventAware)this._eventCascade, (IEventSource)new EventDescriptor(argCycleQuestionChoice));
/*     */       }
/* 623 */       this._questionChoices.remove(argCycleQuestionChoice);
/* 624 */       if (postEventsForChanges()) {
/* 625 */         this._events.post(ICycleQuestion.REMOVE_QUESTIONCHOICES, argCycleQuestionChoice);
/*     */       }
/*     */     } 
/*     */   }
/*     */   
/*     */   @Relationship(name = "Properties")
/*     */   public List<ICycleQuestionProperty> getProperties() {
/* 632 */     if (this._properties == null) {
/* 633 */       this._properties = new HistoricalList(null);
/*     */     }
/* 635 */     return (List<ICycleQuestionProperty>)this._properties;
/*     */   }
/*     */   
/*     */   public void setProperties(List<ICycleQuestionProperty> argProperties) {
/* 639 */     if (this._properties == null) {
/* 640 */       this._properties = new HistoricalList(argProperties);
/*     */     } else {
/* 642 */       this._properties.setCurrentList(argProperties);
/*     */     } 
/*     */     
/* 645 */     for (ICycleQuestionProperty child : this._properties) {
/* 646 */       CycleQuestionPropertyModel model = (CycleQuestionPropertyModel)child;
/* 647 */       model.setOrganizationId_noev(getOrganizationId());
/* 648 */       model.setQuestionId_noev(getQuestionId());
/* 649 */       if (child instanceof IDataModelImpl) {
/* 650 */         IDataAccessObject childDao = ((IDataModelImpl)child).getDAO();
/* 651 */         if (StringUtils.isEmpty(childDao.getOriginDataSource()) && 
/* 652 */           !StringUtils.isEmpty(getDAO().getOriginDataSource())) {
/* 653 */           childDao.setOriginDataSource(getDAO().getOriginDataSource());
/*     */         }
/*     */       } 
/* 656 */       if (postEventsForChanges()) {
/* 657 */         this._eventManager.registerEventHandler((IEventAware)this._eventCascade, (IEventSource)child);
/*     */       }
/*     */     } 
/*     */   }
/*     */   
/*     */   public void addCycleQuestionProperty(ICycleQuestionProperty argCycleQuestionProperty) {
/* 663 */     if (this._properties == null) {
/* 664 */       this._properties = new HistoricalList(null);
/*     */     }
/* 666 */     argCycleQuestionProperty.setOrganizationId(getOrganizationId());
/* 667 */     argCycleQuestionProperty.setQuestionId(getQuestionId());
/* 668 */     if (argCycleQuestionProperty instanceof IDataModelImpl) {
/* 669 */       IDataAccessObject childDao = ((IDataModelImpl)argCycleQuestionProperty).getDAO();
/* 670 */       if (StringUtils.isEmpty(childDao.getOriginDataSource()) && 
/* 671 */         !StringUtils.isEmpty(getDAO().getOriginDataSource())) {
/* 672 */         childDao.setOriginDataSource(getDAO().getOriginDataSource());
/*     */       }
/*     */     } 
/*     */ 
/*     */     
/* 677 */     if (postEventsForChanges()) {
/* 678 */       this._eventManager.registerEventHandler((IEventAware)this._eventCascade, (IEventSource)new EventDescriptor(argCycleQuestionProperty));
/*     */     }
/*     */     
/* 681 */     this._properties.add(argCycleQuestionProperty);
/* 682 */     if (postEventsForChanges()) {
/* 683 */       this._events.post(ICycleQuestion.ADD_PROPERTIES, argCycleQuestionProperty);
/*     */     }
/*     */   }
/*     */   
/*     */   public void removeCycleQuestionProperty(ICycleQuestionProperty argCycleQuestionProperty) {
/* 688 */     if (this._properties != null) {
/*     */       
/* 690 */       if (postEventsForChanges()) {
/* 691 */         this._eventManager.deregisterEventHandler((IEventAware)this._eventCascade, (IEventSource)new EventDescriptor(argCycleQuestionProperty));
/*     */       }
/* 693 */       this._properties.remove(argCycleQuestionProperty);
/* 694 */       if (postEventsForChanges()) {
/* 695 */         this._events.post(ICycleQuestion.REMOVE_PROPERTIES, argCycleQuestionProperty);
/*     */       }
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public Object getValue(String argFieldId) {
/* 702 */     if ("QuestionChoices".equals(argFieldId)) {
/* 703 */       return getQuestionChoices();
/*     */     }
/* 705 */     if ("Properties".equals(argFieldId)) {
/* 706 */       return getProperties();
/*     */     }
/* 708 */     if ("CycleQuestionExtension".equals(argFieldId)) {
/* 709 */       return this._myExtension;
/*     */     }
/*     */     
/* 712 */     return super.getValue(argFieldId);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void setValue(String argFieldId, Object argValue) {
/* 718 */     if ("QuestionChoices".equals(argFieldId)) {
/* 719 */       setQuestionChoices(changeToList(argValue, ICycleQuestionChoice.class));
/*     */     }
/* 721 */     else if ("Properties".equals(argFieldId)) {
/* 722 */       setProperties(changeToList(argValue, ICycleQuestionProperty.class));
/*     */     }
/* 724 */     else if ("CycleQuestionExtension".equals(argFieldId)) {
/* 725 */       this._myExtension = (IDataModel)argValue;
/*     */     } else {
/*     */       
/* 728 */       super.setValue(argFieldId, argValue);
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public void setDependencies(IPersistenceDefaults argPD, EventManager argEM) {
/* 734 */     this._persistenceDefaults = argPD;
/* 735 */     this._daoImpl.setPersistenceDefaults(argPD);
/* 736 */     this._eventManager = argEM;
/* 737 */     this._events = (Eventor)new ModelEventor((IDataModel)this, argEM);
/* 738 */     this._eventCascade = (EventHandler)new CascadingHandler(this);
/* 739 */     if (this._questionChoices != null) {
/* 740 */       for (ICycleQuestionChoice relationship : this._questionChoices) {
/* 741 */         ((IDataModelImpl)relationship).setDependencies(argPD, argEM);
/*     */       }
/*     */     }
/* 744 */     if (this._properties != null) {
/* 745 */       for (ICycleQuestionProperty relationship : this._properties) {
/* 746 */         ((IDataModelImpl)relationship).setDependencies(argPD, argEM);
/*     */       }
/*     */     }
/*     */   }
/*     */   
/*     */   public IDataModel getCycleQuestionExt() {
/* 752 */     return this._myExtension;
/*     */   }
/*     */   
/*     */   public void setCycleQuestionExt(IDataModel argExt) {
/* 756 */     this._myExtension = argExt;
/*     */   }
/*     */ 
/*     */   
/*     */   public void startTransaction() {
/* 761 */     if (this._alreadyInStart) {
/*     */       return;
/*     */     }
/*     */     
/* 765 */     this._alreadyInStart = true;
/*     */ 
/*     */     
/* 768 */     super.startTransaction();
/*     */     
/* 770 */     this._questionChoicesSavepoint = this._questionChoices;
/* 771 */     if (this._questionChoices != null) {
/* 772 */       this._questionChoicesSavepoint = new HistoricalList((List)this._questionChoices);
/* 773 */       Iterator<IDataModel> it = this._questionChoices.iterator();
/* 774 */       while (it.hasNext()) {
/* 775 */         ((IDataModel)it.next()).startTransaction();
/*     */       }
/*     */     } 
/*     */     
/* 779 */     this._propertiesSavepoint = this._properties;
/* 780 */     if (this._properties != null) {
/* 781 */       this._propertiesSavepoint = new HistoricalList((List)this._properties);
/* 782 */       Iterator<IDataModel> it = this._properties.iterator();
/* 783 */       while (it.hasNext()) {
/* 784 */         ((IDataModel)it.next()).startTransaction();
/*     */       }
/*     */     } 
/*     */ 
/*     */     
/* 789 */     this._alreadyInStart = false;
/*     */   }
/*     */ 
/*     */   
/*     */   public void rollbackChanges() {
/* 794 */     if (isAlreadyRolledBack()) {
/*     */       return;
/*     */     }
/* 797 */     super.rollbackChanges();
/*     */     
/* 799 */     this._questionChoices = this._questionChoicesSavepoint;
/* 800 */     this._questionChoicesSavepoint = null;
/* 801 */     if (this._questionChoices != null) {
/* 802 */       Iterator<IDataModel> it = this._questionChoices.iterator();
/* 803 */       while (it.hasNext()) {
/* 804 */         ((IDataModel)it.next()).rollbackChanges();
/*     */       }
/*     */     } 
/*     */     
/* 808 */     this._properties = this._propertiesSavepoint;
/* 809 */     this._propertiesSavepoint = null;
/* 810 */     if (this._properties != null) {
/* 811 */       Iterator<IDataModel> it = this._properties.iterator();
/* 812 */       while (it.hasNext()) {
/* 813 */         ((IDataModel)it.next()).rollbackChanges();
/*     */       }
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void commitTransaction() {
/* 821 */     if (this._alreadyInCommit) {
/*     */       return;
/*     */     }
/* 824 */     this._alreadyInCommit = true;
/*     */ 
/*     */     
/* 827 */     super.commitTransaction();
/*     */     
/* 829 */     this._questionChoicesSavepoint = this._questionChoices;
/* 830 */     if (this._questionChoices != null) {
/* 831 */       Iterator<IDataModel> it = this._questionChoices.iterator();
/* 832 */       while (it.hasNext()) {
/* 833 */         ((IDataModel)it.next()).commitTransaction();
/*     */       }
/* 835 */       this._questionChoices = new HistoricalList((List)this._questionChoices);
/*     */     } 
/*     */     
/* 838 */     this._propertiesSavepoint = this._properties;
/* 839 */     if (this._properties != null) {
/* 840 */       Iterator<IDataModel> it = this._properties.iterator();
/* 841 */       while (it.hasNext()) {
/* 842 */         ((IDataModel)it.next()).commitTransaction();
/*     */       }
/* 844 */       this._properties = new HistoricalList((List)this._properties);
/*     */     } 
/*     */ 
/*     */     
/* 848 */     this._alreadyInCommit = false;
/*     */   }
/*     */ 
/*     */   
/*     */   private void readObject(ObjectInputStream argStream) throws IOException, ClassNotFoundException {
/* 853 */     argStream.defaultReadObject();
/*     */   }
/*     */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\loc\impl\CycleQuestionModel.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */