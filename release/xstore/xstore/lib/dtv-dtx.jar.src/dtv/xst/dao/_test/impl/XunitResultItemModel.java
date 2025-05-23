/*     */ package dtv.xst.dao._test.impl;
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
/*     */ import dtv.xst.dao._test.IXunitResult;
/*     */ import dtv.xst.dao._test.IXunitResultItem;
/*     */ import dtv.xst.dao._test.IXunitResultItemProperty;
/*     */ import dtv.xst.dao._test.XunitResultItemPropertyId;
/*     */ import java.io.IOException;
/*     */ import java.io.ObjectInputStream;
/*     */ import java.util.Date;
/*     */ import java.util.Iterator;
/*     */ import java.util.List;
/*     */ 
/*     */ public class XunitResultItemModel extends AbstractDataModelWithPropertyImpl<IXunitResultItemProperty> implements IXunitResultItem {
/*     */   private static final long serialVersionUID = -1907652660L;
/*     */   private IXunitResult _parentResult;
/*     */   private transient boolean _alreadyInStart = false;
/*     */   
/*     */   public String toString() {
/*  35 */     return super.toString() + " Id: " + getObjectId();
/*     */   }
/*     */   private transient boolean _alreadyInCommit = false; private IDataModel _myExtension; private HistoricalList<IXunitResultItemProperty> _properties; private transient HistoricalList<IXunitResultItemProperty> _propertiesSavepoint;
/*     */   
/*     */   public void initDAO() {
/*  40 */     setDAO((IDataAccessObject)new XunitResultItemDAO());
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private XunitResultItemDAO getDAO_() {
/*  48 */     return (XunitResultItemDAO)this._daoImpl;
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
/*  72 */       this._events.post(IXunitResultItem.SET_ORGANIZATIONID, Long.valueOf(argOrganizationId));
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
/*  87 */         Iterator<XunitResultItemPropertyModel> it = this._properties.iterator();
/*  88 */         while (it.hasNext())
/*     */         {
/*  90 */           ((XunitResultItemPropertyModel)it.next()).setOrganizationId_noev(argOrganizationId);
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
/*     */   public String getHostname() {
/* 103 */     return getDAO_().getHostname();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setHostname(String argHostname) {
/* 111 */     if (setHostname_noev(argHostname) && 
/* 112 */       this._events != null && 
/* 113 */       postEventsForChanges()) {
/* 114 */       this._events.post(IXunitResultItem.SET_HOSTNAME, argHostname);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setHostname_noev(String argHostname) {
/* 121 */     boolean ev_postable = false;
/*     */     
/* 123 */     if ((getDAO_().getHostname() == null && argHostname != null) || (
/* 124 */       getDAO_().getHostname() != null && !getDAO_().getHostname().equals(argHostname))) {
/* 125 */       getDAO_().setHostname(argHostname);
/* 126 */       ev_postable = true;
/* 127 */       if (this._properties != null) {
/*     */         
/* 129 */         Iterator<XunitResultItemPropertyModel> it = this._properties.iterator();
/* 130 */         while (it.hasNext())
/*     */         {
/* 132 */           ((XunitResultItemPropertyModel)it.next()).setHostname_noev(argHostname);
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
/*     */   public long getResultTimestamp() {
/* 145 */     if (getDAO_().getResultTimestamp() != null) {
/* 146 */       return getDAO_().getResultTimestamp().longValue();
/*     */     }
/*     */     
/* 149 */     return 0L;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setResultTimestamp(long argResultTimestamp) {
/* 158 */     if (setResultTimestamp_noev(argResultTimestamp) && 
/* 159 */       this._events != null && 
/* 160 */       postEventsForChanges()) {
/* 161 */       this._events.post(IXunitResultItem.SET_RESULTTIMESTAMP, Long.valueOf(argResultTimestamp));
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setResultTimestamp_noev(long argResultTimestamp) {
/* 168 */     boolean ev_postable = false;
/*     */     
/* 170 */     if ((getDAO_().getResultTimestamp() == null && Long.valueOf(argResultTimestamp) != null) || (
/* 171 */       getDAO_().getResultTimestamp() != null && !getDAO_().getResultTimestamp().equals(Long.valueOf(argResultTimestamp)))) {
/* 172 */       getDAO_().setResultTimestamp(Long.valueOf(argResultTimestamp));
/* 173 */       ev_postable = true;
/* 174 */       if (this._properties != null) {
/*     */         
/* 176 */         Iterator<XunitResultItemPropertyModel> it = this._properties.iterator();
/* 177 */         while (it.hasNext())
/*     */         {
/* 179 */           ((XunitResultItemPropertyModel)it.next()).setResultTimestamp_noev(argResultTimestamp);
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
/*     */   public long getResultItemSequence() {
/* 192 */     if (getDAO_().getResultItemSequence() != null) {
/* 193 */       return getDAO_().getResultItemSequence().longValue();
/*     */     }
/*     */     
/* 196 */     return 0L;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setResultItemSequence(long argResultItemSequence) {
/* 205 */     if (setResultItemSequence_noev(argResultItemSequence) && 
/* 206 */       this._events != null && 
/* 207 */       postEventsForChanges()) {
/* 208 */       this._events.post(IXunitResultItem.SET_RESULTITEMSEQUENCE, Long.valueOf(argResultItemSequence));
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setResultItemSequence_noev(long argResultItemSequence) {
/* 215 */     boolean ev_postable = false;
/*     */     
/* 217 */     if ((getDAO_().getResultItemSequence() == null && Long.valueOf(argResultItemSequence) != null) || (
/* 218 */       getDAO_().getResultItemSequence() != null && !getDAO_().getResultItemSequence().equals(Long.valueOf(argResultItemSequence)))) {
/* 219 */       getDAO_().setResultItemSequence(Long.valueOf(argResultItemSequence));
/* 220 */       ev_postable = true;
/* 221 */       if (this._properties != null) {
/*     */         
/* 223 */         Iterator<XunitResultItemPropertyModel> it = this._properties.iterator();
/* 224 */         while (it.hasNext())
/*     */         {
/* 226 */           ((XunitResultItemPropertyModel)it.next()).setResultItemSequence_noev(argResultItemSequence);
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
/* 250 */       this._events.post(IXunitResultItem.SET_CREATEDATE, argCreateDate);
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
/* 284 */       this._events.post(IXunitResultItem.SET_CREATEUSERID, argCreateUserId);
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
/* 318 */       this._events.post(IXunitResultItem.SET_UPDATEDATE, argUpdateDate);
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
/* 352 */       this._events.post(IXunitResultItem.SET_UPDATEUSERID, argUpdateUserId);
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
/*     */   public String getTestCaseName() {
/* 375 */     return getDAO_().getTestCaseName();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setTestCaseName(String argTestCaseName) {
/* 383 */     if (setTestCaseName_noev(argTestCaseName) && 
/* 384 */       this._events != null && 
/* 385 */       postEventsForChanges()) {
/* 386 */       this._events.post(IXunitResultItem.SET_TESTCASENAME, argTestCaseName);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setTestCaseName_noev(String argTestCaseName) {
/* 393 */     boolean ev_postable = false;
/*     */     
/* 395 */     if ((getDAO_().getTestCaseName() == null && argTestCaseName != null) || (
/* 396 */       getDAO_().getTestCaseName() != null && !getDAO_().getTestCaseName().equals(argTestCaseName))) {
/* 397 */       getDAO_().setTestCaseName(argTestCaseName);
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
/*     */   public long getTestNumber() {
/* 409 */     if (getDAO_().getTestNumber() != null) {
/* 410 */       return getDAO_().getTestNumber().longValue();
/*     */     }
/*     */     
/* 413 */     return 0L;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setTestNumber(long argTestNumber) {
/* 422 */     if (setTestNumber_noev(argTestNumber) && 
/* 423 */       this._events != null && 
/* 424 */       postEventsForChanges()) {
/* 425 */       this._events.post(IXunitResultItem.SET_TESTNUMBER, Long.valueOf(argTestNumber));
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setTestNumber_noev(long argTestNumber) {
/* 432 */     boolean ev_postable = false;
/*     */     
/* 434 */     if ((getDAO_().getTestNumber() == null && Long.valueOf(argTestNumber) != null) || (
/* 435 */       getDAO_().getTestNumber() != null && !getDAO_().getTestNumber().equals(Long.valueOf(argTestNumber)))) {
/* 436 */       getDAO_().setTestNumber(Long.valueOf(argTestNumber));
/* 437 */       ev_postable = true;
/*     */     } 
/*     */     
/* 440 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public long getTestIteration() {
/* 448 */     if (getDAO_().getTestIteration() != null) {
/* 449 */       return getDAO_().getTestIteration().longValue();
/*     */     }
/*     */     
/* 452 */     return 0L;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setTestIteration(long argTestIteration) {
/* 461 */     if (setTestIteration_noev(argTestIteration) && 
/* 462 */       this._events != null && 
/* 463 */       postEventsForChanges()) {
/* 464 */       this._events.post(IXunitResultItem.SET_TESTITERATION, Long.valueOf(argTestIteration));
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setTestIteration_noev(long argTestIteration) {
/* 471 */     boolean ev_postable = false;
/*     */     
/* 473 */     if ((getDAO_().getTestIteration() == null && Long.valueOf(argTestIteration) != null) || (
/* 474 */       getDAO_().getTestIteration() != null && !getDAO_().getTestIteration().equals(Long.valueOf(argTestIteration)))) {
/* 475 */       getDAO_().setTestIteration(Long.valueOf(argTestIteration));
/* 476 */       ev_postable = true;
/*     */     } 
/*     */     
/* 479 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getResultItemStatus() {
/* 487 */     return getDAO_().getResultItemStatus();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setResultItemStatus(String argResultItemStatus) {
/* 495 */     if (setResultItemStatus_noev(argResultItemStatus) && 
/* 496 */       this._events != null && 
/* 497 */       postEventsForChanges()) {
/* 498 */       this._events.post(IXunitResultItem.SET_RESULTITEMSTATUS, argResultItemStatus);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setResultItemStatus_noev(String argResultItemStatus) {
/* 505 */     boolean ev_postable = false;
/*     */     
/* 507 */     if ((getDAO_().getResultItemStatus() == null && argResultItemStatus != null) || (
/* 508 */       getDAO_().getResultItemStatus() != null && !getDAO_().getResultItemStatus().equals(argResultItemStatus))) {
/* 509 */       getDAO_().setResultItemStatus(argResultItemStatus);
/* 510 */       ev_postable = true;
/*     */     } 
/*     */     
/* 513 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Date getResultItemDatetimestamp() {
/* 521 */     return getDAO_().getResultItemDatetimestamp();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setResultItemDatetimestamp(Date argResultItemDatetimestamp) {
/* 529 */     if (setResultItemDatetimestamp_noev(argResultItemDatetimestamp) && 
/* 530 */       this._events != null && 
/* 531 */       postEventsForChanges()) {
/* 532 */       this._events.post(IXunitResultItem.SET_RESULTITEMDATETIMESTAMP, argResultItemDatetimestamp);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setResultItemDatetimestamp_noev(Date argResultItemDatetimestamp) {
/* 539 */     boolean ev_postable = false;
/*     */     
/* 541 */     if ((getDAO_().getResultItemDatetimestamp() == null && argResultItemDatetimestamp != null) || (
/* 542 */       getDAO_().getResultItemDatetimestamp() != null && !getDAO_().getResultItemDatetimestamp().equals(argResultItemDatetimestamp))) {
/* 543 */       getDAO_().setResultItemDatetimestamp(argResultItemDatetimestamp);
/* 544 */       ev_postable = true;
/*     */     } 
/*     */     
/* 547 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getFailureReason() {
/* 555 */     return getDAO_().getFailureReason();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setFailureReason(String argFailureReason) {
/* 563 */     if (setFailureReason_noev(argFailureReason) && 
/* 564 */       this._events != null && 
/* 565 */       postEventsForChanges()) {
/* 566 */       this._events.post(IXunitResultItem.SET_FAILUREREASON, argFailureReason);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setFailureReason_noev(String argFailureReason) {
/* 573 */     boolean ev_postable = false;
/*     */     
/* 575 */     if ((getDAO_().getFailureReason() == null && argFailureReason != null) || (
/* 576 */       getDAO_().getFailureReason() != null && !getDAO_().getFailureReason().equals(argFailureReason))) {
/* 577 */       getDAO_().setFailureReason(argFailureReason);
/* 578 */       ev_postable = true;
/*     */     } 
/*     */     
/* 581 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getLogData() {
/* 589 */     return getDAO_().getLogData();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setLogData(String argLogData) {
/* 597 */     if (setLogData_noev(argLogData) && 
/* 598 */       this._events != null && 
/* 599 */       postEventsForChanges()) {
/* 600 */       this._events.post(IXunitResultItem.SET_LOGDATA, argLogData);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setLogData_noev(String argLogData) {
/* 607 */     boolean ev_postable = false;
/*     */     
/* 609 */     if ((getDAO_().getLogData() == null && argLogData != null) || (
/* 610 */       getDAO_().getLogData() != null && !getDAO_().getLogData().equals(argLogData))) {
/* 611 */       getDAO_().setLogData(argLogData);
/* 612 */       ev_postable = true;
/*     */     } 
/*     */     
/* 615 */     return ev_postable;
/*     */   }
/*     */   
/*     */   protected IXunitResultItemProperty newProperty(String argPropertyName) {
/* 619 */     XunitResultItemPropertyId id = new XunitResultItemPropertyId();
/*     */     
/* 621 */     id.setHostname(getHostname());
/* 622 */     id.setResultTimestamp(Long.valueOf(getResultTimestamp()));
/* 623 */     id.setResultItemSequence(Long.valueOf(getResultItemSequence()));
/* 624 */     id.setPropertyCode(argPropertyName);
/*     */     
/* 626 */     IXunitResultItemProperty prop = (IXunitResultItemProperty)DataFactory.getInstance().createNewObject((IObjectId)id, IXunitResultItemProperty.class);
/* 627 */     return prop;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @Relationship(name = "Properties")
/*     */   public List<IXunitResultItemProperty> getProperties() {
/* 636 */     if (this._properties == null) {
/* 637 */       this._properties = new HistoricalList(null);
/*     */     }
/* 639 */     return (List<IXunitResultItemProperty>)this._properties;
/*     */   }
/*     */   
/*     */   public void setProperties(List<IXunitResultItemProperty> argProperties) {
/* 643 */     if (this._properties == null) {
/* 644 */       this._properties = new HistoricalList(argProperties);
/*     */     } else {
/* 646 */       this._properties.setCurrentList(argProperties);
/*     */     } 
/*     */     
/* 649 */     for (IXunitResultItemProperty child : this._properties) {
/* 650 */       XunitResultItemPropertyModel model = (XunitResultItemPropertyModel)child;
/* 651 */       model.setOrganizationId_noev(getOrganizationId());
/* 652 */       model.setHostname_noev(getHostname());
/* 653 */       model.setResultTimestamp_noev(getResultTimestamp());
/* 654 */       model.setResultItemSequence_noev(getResultItemSequence());
/* 655 */       if (child instanceof IDataModelImpl) {
/* 656 */         IDataAccessObject childDao = ((IDataModelImpl)child).getDAO();
/* 657 */         if (StringUtils.isEmpty(childDao.getOriginDataSource()) && 
/* 658 */           !StringUtils.isEmpty(getDAO().getOriginDataSource())) {
/* 659 */           childDao.setOriginDataSource(getDAO().getOriginDataSource());
/*     */         }
/*     */       } 
/* 662 */       if (postEventsForChanges()) {
/* 663 */         this._eventManager.registerEventHandler((IEventAware)this._eventCascade, (IEventSource)child);
/*     */       }
/*     */     } 
/*     */   }
/*     */   
/*     */   public void addXunitResultItemProperty(IXunitResultItemProperty argXunitResultItemProperty) {
/* 669 */     if (this._properties == null) {
/* 670 */       this._properties = new HistoricalList(null);
/*     */     }
/* 672 */     argXunitResultItemProperty.setOrganizationId(getOrganizationId());
/* 673 */     argXunitResultItemProperty.setHostname(getHostname());
/* 674 */     argXunitResultItemProperty.setResultTimestamp(getResultTimestamp());
/* 675 */     argXunitResultItemProperty.setResultItemSequence(getResultItemSequence());
/* 676 */     if (argXunitResultItemProperty instanceof IDataModelImpl) {
/* 677 */       IDataAccessObject childDao = ((IDataModelImpl)argXunitResultItemProperty).getDAO();
/* 678 */       if (StringUtils.isEmpty(childDao.getOriginDataSource()) && 
/* 679 */         !StringUtils.isEmpty(getDAO().getOriginDataSource())) {
/* 680 */         childDao.setOriginDataSource(getDAO().getOriginDataSource());
/*     */       }
/*     */     } 
/*     */ 
/*     */     
/* 685 */     if (postEventsForChanges()) {
/* 686 */       this._eventManager.registerEventHandler((IEventAware)this._eventCascade, (IEventSource)new EventDescriptor(argXunitResultItemProperty));
/*     */     }
/*     */     
/* 689 */     this._properties.add(argXunitResultItemProperty);
/* 690 */     if (postEventsForChanges()) {
/* 691 */       this._events.post(IXunitResultItem.ADD_PROPERTIES, argXunitResultItemProperty);
/*     */     }
/*     */   }
/*     */   
/*     */   public void removeXunitResultItemProperty(IXunitResultItemProperty argXunitResultItemProperty) {
/* 696 */     if (this._properties != null) {
/*     */       
/* 698 */       if (postEventsForChanges()) {
/* 699 */         this._eventManager.deregisterEventHandler((IEventAware)this._eventCascade, (IEventSource)new EventDescriptor(argXunitResultItemProperty));
/*     */       }
/* 701 */       this._properties.remove(argXunitResultItemProperty);
/* 702 */       if (postEventsForChanges()) {
/* 703 */         this._events.post(IXunitResultItem.REMOVE_PROPERTIES, argXunitResultItemProperty);
/*     */       }
/*     */     } 
/*     */   }
/*     */   
/*     */   public void setParentResult(IXunitResult argParentResult) {
/* 709 */     this._parentResult = argParentResult;
/*     */   }
/*     */   
/*     */   public IXunitResult getParentResult() {
/* 713 */     return this._parentResult;
/*     */   }
/*     */ 
/*     */   
/*     */   public Object getValue(String argFieldId) {
/* 718 */     if ("Properties".equals(argFieldId)) {
/* 719 */       return getProperties();
/*     */     }
/* 721 */     if ("XunitResultItemExtension".equals(argFieldId)) {
/* 722 */       return this._myExtension;
/*     */     }
/*     */     
/* 725 */     return super.getValue(argFieldId);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void setValue(String argFieldId, Object argValue) {
/* 731 */     if ("Properties".equals(argFieldId)) {
/* 732 */       setProperties(changeToList(argValue, IXunitResultItemProperty.class));
/*     */     }
/* 734 */     else if ("XunitResultItemExtension".equals(argFieldId)) {
/* 735 */       this._myExtension = (IDataModel)argValue;
/*     */     } else {
/*     */       
/* 738 */       super.setValue(argFieldId, argValue);
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public void setDependencies(IPersistenceDefaults argPD, EventManager argEM) {
/* 744 */     this._persistenceDefaults = argPD;
/* 745 */     this._daoImpl.setPersistenceDefaults(argPD);
/* 746 */     this._eventManager = argEM;
/* 747 */     this._events = (Eventor)new ModelEventor((IDataModel)this, argEM);
/* 748 */     this._eventCascade = (EventHandler)new CascadingHandler(this);
/* 749 */     if (this._properties != null) {
/* 750 */       for (IXunitResultItemProperty relationship : this._properties) {
/* 751 */         ((IDataModelImpl)relationship).setDependencies(argPD, argEM);
/*     */       }
/*     */     }
/*     */   }
/*     */   
/*     */   public IDataModel getXunitResultItemExt() {
/* 757 */     return this._myExtension;
/*     */   }
/*     */   
/*     */   public void setXunitResultItemExt(IDataModel argExt) {
/* 761 */     this._myExtension = argExt;
/*     */   }
/*     */ 
/*     */   
/*     */   public void startTransaction() {
/* 766 */     if (this._alreadyInStart) {
/*     */       return;
/*     */     }
/*     */     
/* 770 */     this._alreadyInStart = true;
/*     */ 
/*     */     
/* 773 */     super.startTransaction();
/*     */     
/* 775 */     this._propertiesSavepoint = this._properties;
/* 776 */     if (this._properties != null) {
/* 777 */       this._propertiesSavepoint = new HistoricalList((List)this._properties);
/* 778 */       Iterator<IDataModel> it = this._properties.iterator();
/* 779 */       while (it.hasNext()) {
/* 780 */         ((IDataModel)it.next()).startTransaction();
/*     */       }
/*     */     } 
/*     */ 
/*     */     
/* 785 */     this._alreadyInStart = false;
/*     */   }
/*     */ 
/*     */   
/*     */   public void rollbackChanges() {
/* 790 */     if (isAlreadyRolledBack()) {
/*     */       return;
/*     */     }
/* 793 */     super.rollbackChanges();
/*     */     
/* 795 */     this._properties = this._propertiesSavepoint;
/* 796 */     this._propertiesSavepoint = null;
/* 797 */     if (this._properties != null) {
/* 798 */       Iterator<IDataModel> it = this._properties.iterator();
/* 799 */       while (it.hasNext()) {
/* 800 */         ((IDataModel)it.next()).rollbackChanges();
/*     */       }
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void commitTransaction() {
/* 808 */     if (this._alreadyInCommit) {
/*     */       return;
/*     */     }
/* 811 */     this._alreadyInCommit = true;
/*     */ 
/*     */     
/* 814 */     super.commitTransaction();
/*     */     
/* 816 */     this._propertiesSavepoint = this._properties;
/* 817 */     if (this._properties != null) {
/* 818 */       Iterator<IDataModel> it = this._properties.iterator();
/* 819 */       while (it.hasNext()) {
/* 820 */         ((IDataModel)it.next()).commitTransaction();
/*     */       }
/* 822 */       this._properties = new HistoricalList((List)this._properties);
/*     */     } 
/*     */ 
/*     */     
/* 826 */     this._alreadyInCommit = false;
/*     */   }
/*     */ 
/*     */   
/*     */   private void readObject(ObjectInputStream argStream) throws IOException, ClassNotFoundException {
/* 831 */     argStream.defaultReadObject();
/*     */   }
/*     */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\_test\impl\XunitResultItemModel.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */