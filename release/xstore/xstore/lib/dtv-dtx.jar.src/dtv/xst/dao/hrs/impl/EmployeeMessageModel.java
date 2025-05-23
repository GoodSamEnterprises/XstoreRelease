/*     */ package dtv.xst.dao.hrs.impl;
/*     */ 
/*     */ import dtv.data2.IPersistenceDefaults;
/*     */ import dtv.data2.access.DataFactory;
/*     */ import dtv.data2.access.IDataAccessObject;
/*     */ import dtv.data2.access.IDataModel;
/*     */ import dtv.data2.access.IDataProperty;
/*     */ import dtv.data2.access.IObjectId;
/*     */ import dtv.data2.access.ModelEventor;
/*     */ import dtv.data2.access.impl.IDataModelImpl;
/*     */ import dtv.data2.access.impl.Relationship;
/*     */ import dtv.event.EventDescriptor;
/*     */ import dtv.event.EventHandler;
/*     */ import dtv.event.EventManager;
/*     */ import dtv.event.Eventor;
/*     */ import dtv.event.IEventAware;
/*     */ import dtv.event.IEventSource;
/*     */ import dtv.event.handler.CascadingHandler;
/*     */ import dtv.util.HistoricalList;
/*     */ import dtv.util.StringUtils;
/*     */ import dtv.xst.dao.hrs.EmployeeMessagePropertyId;
/*     */ import dtv.xst.dao.hrs.IEmployeeMessage;
/*     */ import dtv.xst.dao.hrs.IEmployeeMessageProperty;
/*     */ import java.util.Date;
/*     */ import java.util.Iterator;
/*     */ import java.util.List;
/*     */ 
/*     */ public class EmployeeMessageModel extends EmployeeMessageBaseModel implements IEmployeeMessage {
/*     */   private static final long serialVersionUID = 414263641L;
/*     */   private transient boolean _alreadyInStart = false;
/*     */   private transient boolean _alreadyInCommit = false;
/*     */   
/*     */   public String toString() {
/*  34 */     return super.toString() + " Id: " + getObjectId();
/*     */   }
/*     */   private IDataModel _myExtension; private HistoricalList<IEmployeeMessageProperty> _properties; private transient HistoricalList<IEmployeeMessageProperty> _propertiesSavepoint;
/*     */   
/*     */   public void initDAO() {
/*  39 */     setDAO((IDataAccessObject)new EmployeeMessageDAO());
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private EmployeeMessageDAO getDAO_() {
/*  47 */     return (EmployeeMessageDAO)this._daoImpl;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public long getOrganizationId() {
/*  55 */     if (getDAO_().getOrganizationId() != null) {
/*  56 */       return getDAO_().getOrganizationId().longValue();
/*     */     }
/*     */     
/*  59 */     return 0L;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setOrganizationId(long argOrganizationId) {
/*  68 */     if (setOrganizationId_noev(argOrganizationId) && 
/*  69 */       this._events != null && 
/*  70 */       postEventsForChanges()) {
/*  71 */       this._events.post(IEmployeeMessage.SET_ORGANIZATIONID, Long.valueOf(argOrganizationId));
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setOrganizationId_noev(long argOrganizationId) {
/*  78 */     boolean ev_postable = false;
/*     */     
/*  80 */     if ((getDAO_().getOrganizationId() == null && Long.valueOf(argOrganizationId) != null) || (
/*  81 */       getDAO_().getOrganizationId() != null && !getDAO_().getOrganizationId().equals(Long.valueOf(argOrganizationId)))) {
/*  82 */       getDAO_().setOrganizationId(Long.valueOf(argOrganizationId));
/*  83 */       ev_postable = true;
/*  84 */       if (this._properties != null) {
/*     */         
/*  86 */         Iterator<EmployeeMessagePropertyModel> it = this._properties.iterator();
/*  87 */         while (it.hasNext())
/*     */         {
/*  89 */           ((EmployeeMessagePropertyModel)it.next()).setOrganizationId_noev(argOrganizationId);
/*     */         }
/*     */       } 
/*     */     } 
/*     */     
/*  94 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public long getMessageId() {
/* 102 */     if (getDAO_().getMessageId() != null) {
/* 103 */       return getDAO_().getMessageId().longValue();
/*     */     }
/*     */     
/* 106 */     return 0L;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setMessageId(long argMessageId) {
/* 115 */     if (setMessageId_noev(argMessageId) && 
/* 116 */       this._events != null && 
/* 117 */       postEventsForChanges()) {
/* 118 */       this._events.post(IEmployeeMessage.SET_MESSAGEID, Long.valueOf(argMessageId));
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setMessageId_noev(long argMessageId) {
/* 125 */     boolean ev_postable = false;
/*     */     
/* 127 */     if ((getDAO_().getMessageId() == null && Long.valueOf(argMessageId) != null) || (
/* 128 */       getDAO_().getMessageId() != null && !getDAO_().getMessageId().equals(Long.valueOf(argMessageId)))) {
/* 129 */       getDAO_().setMessageId(Long.valueOf(argMessageId));
/* 130 */       ev_postable = true;
/* 131 */       if (this._properties != null) {
/*     */         
/* 133 */         Iterator<EmployeeMessagePropertyModel> it = this._properties.iterator();
/* 134 */         while (it.hasNext())
/*     */         {
/* 136 */           ((EmployeeMessagePropertyModel)it.next()).setMessageId_noev(argMessageId);
/*     */         }
/*     */       } 
/*     */     } 
/*     */     
/* 141 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getOrgCode() {
/* 149 */     return getDAO_().getOrgCode();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setOrgCode(String argOrgCode) {
/* 157 */     if (setOrgCode_noev(argOrgCode) && 
/* 158 */       this._events != null && 
/* 159 */       postEventsForChanges()) {
/* 160 */       this._events.post(IEmployeeMessage.SET_ORGCODE, argOrgCode);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setOrgCode_noev(String argOrgCode) {
/* 167 */     boolean ev_postable = false;
/*     */     
/* 169 */     if ((getDAO_().getOrgCode() == null && argOrgCode != null) || (
/* 170 */       getDAO_().getOrgCode() != null && !getDAO_().getOrgCode().equals(argOrgCode))) {
/* 171 */       getDAO_().setOrgCode(argOrgCode);
/* 172 */       ev_postable = true;
/*     */     } 
/*     */     
/* 175 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getOrgValue() {
/* 183 */     return getDAO_().getOrgValue();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setOrgValue(String argOrgValue) {
/* 191 */     if (setOrgValue_noev(argOrgValue) && 
/* 192 */       this._events != null && 
/* 193 */       postEventsForChanges()) {
/* 194 */       this._events.post(IEmployeeMessage.SET_ORGVALUE, argOrgValue);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setOrgValue_noev(String argOrgValue) {
/* 201 */     boolean ev_postable = false;
/*     */     
/* 203 */     if ((getDAO_().getOrgValue() == null && argOrgValue != null) || (
/* 204 */       getDAO_().getOrgValue() != null && !getDAO_().getOrgValue().equals(argOrgValue))) {
/* 205 */       getDAO_().setOrgValue(argOrgValue);
/* 206 */       ev_postable = true;
/*     */     } 
/*     */     
/* 209 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Date getStartDate() {
/* 217 */     return getDAO_().getStartDate();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setStartDate(Date argStartDate) {
/* 225 */     if (setStartDate_noev(argStartDate) && 
/* 226 */       this._events != null && 
/* 227 */       postEventsForChanges()) {
/* 228 */       this._events.post(IEmployeeMessage.SET_STARTDATE, argStartDate);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setStartDate_noev(Date argStartDate) {
/* 235 */     boolean ev_postable = false;
/*     */     
/* 237 */     if ((getDAO_().getStartDate() == null && argStartDate != null) || (
/* 238 */       getDAO_().getStartDate() != null && !getDAO_().getStartDate().equals(argStartDate))) {
/* 239 */       getDAO_().setStartDate(argStartDate);
/* 240 */       ev_postable = true;
/*     */     } 
/*     */     
/* 243 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Date getEndDate() {
/* 251 */     return getDAO_().getEndDate();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setEndDate(Date argEndDate) {
/* 259 */     if (setEndDate_noev(argEndDate) && 
/* 260 */       this._events != null && 
/* 261 */       postEventsForChanges()) {
/* 262 */       this._events.post(IEmployeeMessage.SET_ENDDATE, argEndDate);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setEndDate_noev(Date argEndDate) {
/* 269 */     boolean ev_postable = false;
/*     */     
/* 271 */     if ((getDAO_().getEndDate() == null && argEndDate != null) || (
/* 272 */       getDAO_().getEndDate() != null && !getDAO_().getEndDate().equals(argEndDate))) {
/* 273 */       getDAO_().setEndDate(argEndDate);
/* 274 */       ev_postable = true;
/*     */     } 
/*     */     
/* 277 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getPriority() {
/* 285 */     return getDAO_().getPriority();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setPriority(String argPriority) {
/* 293 */     if (setPriority_noev(argPriority) && 
/* 294 */       this._events != null && 
/* 295 */       postEventsForChanges()) {
/* 296 */       this._events.post(IEmployeeMessage.SET_PRIORITY, argPriority);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setPriority_noev(String argPriority) {
/* 303 */     boolean ev_postable = false;
/*     */     
/* 305 */     if ((getDAO_().getPriority() == null && argPriority != null) || (
/* 306 */       getDAO_().getPriority() != null && !getDAO_().getPriority().equals(argPriority))) {
/* 307 */       getDAO_().setPriority(argPriority);
/* 308 */       ev_postable = true;
/*     */     } 
/*     */     
/* 311 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean getStoreCreated() {
/* 319 */     if (getDAO_().getStoreCreated() != null) {
/* 320 */       return getDAO_().getStoreCreated().booleanValue();
/*     */     }
/*     */     
/* 323 */     return false;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setStoreCreated(boolean argStoreCreated) {
/* 332 */     if (setStoreCreated_noev(argStoreCreated) && 
/* 333 */       this._events != null && 
/* 334 */       postEventsForChanges()) {
/* 335 */       this._events.post(IEmployeeMessage.SET_STORECREATED, Boolean.valueOf(argStoreCreated));
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setStoreCreated_noev(boolean argStoreCreated) {
/* 342 */     boolean ev_postable = false;
/*     */     
/* 344 */     if ((getDAO_().getStoreCreated() == null && Boolean.valueOf(argStoreCreated) != null) || (
/* 345 */       getDAO_().getStoreCreated() != null && !getDAO_().getStoreCreated().equals(Boolean.valueOf(argStoreCreated)))) {
/* 346 */       getDAO_().setStoreCreated(Boolean.valueOf(argStoreCreated));
/* 347 */       ev_postable = true;
/*     */     } 
/*     */     
/* 350 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean getWorkstationSpecific() {
/* 358 */     if (getDAO_().getWorkstationSpecific() != null) {
/* 359 */       return getDAO_().getWorkstationSpecific().booleanValue();
/*     */     }
/*     */     
/* 362 */     return false;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setWorkstationSpecific(boolean argWorkstationSpecific) {
/* 371 */     if (setWorkstationSpecific_noev(argWorkstationSpecific) && 
/* 372 */       this._events != null && 
/* 373 */       postEventsForChanges()) {
/* 374 */       this._events.post(IEmployeeMessage.SET_WORKSTATIONSPECIFIC, Boolean.valueOf(argWorkstationSpecific));
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setWorkstationSpecific_noev(boolean argWorkstationSpecific) {
/* 381 */     boolean ev_postable = false;
/*     */     
/* 383 */     if ((getDAO_().getWorkstationSpecific() == null && Boolean.valueOf(argWorkstationSpecific) != null) || (
/* 384 */       getDAO_().getWorkstationSpecific() != null && !getDAO_().getWorkstationSpecific().equals(Boolean.valueOf(argWorkstationSpecific)))) {
/* 385 */       getDAO_().setWorkstationSpecific(Boolean.valueOf(argWorkstationSpecific));
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
/*     */   public int getWorkstationId() {
/* 397 */     if (getDAO_().getWorkstationId() != null) {
/* 398 */       return getDAO_().getWorkstationId().intValue();
/*     */     }
/*     */     
/* 401 */     return 0;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setWorkstationId(int argWorkstationId) {
/* 410 */     if (setWorkstationId_noev(argWorkstationId) && 
/* 411 */       this._events != null && 
/* 412 */       postEventsForChanges()) {
/* 413 */       this._events.post(IEmployeeMessage.SET_WORKSTATIONID, Integer.valueOf(argWorkstationId));
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setWorkstationId_noev(int argWorkstationId) {
/* 420 */     boolean ev_postable = false;
/*     */     
/* 422 */     if ((getDAO_().getWorkstationId() == null && Integer.valueOf(argWorkstationId) != null) || (
/* 423 */       getDAO_().getWorkstationId() != null && !getDAO_().getWorkstationId().equals(Integer.valueOf(argWorkstationId)))) {
/* 424 */       getDAO_().setWorkstationId(Integer.valueOf(argWorkstationId));
/* 425 */       ev_postable = true;
/*     */     } 
/*     */     
/* 428 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getDescription() {
/* 436 */     return getDAO_().getDescription();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setDescription(String argDescription) {
/* 444 */     if (setDescription_noev(argDescription) && 
/* 445 */       this._events != null && 
/* 446 */       postEventsForChanges()) {
/* 447 */       this._events.post(IEmployeeMessage.SET_DESCRIPTION, argDescription);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setDescription_noev(String argDescription) {
/* 454 */     boolean ev_postable = false;
/*     */     
/* 456 */     if ((getDAO_().getDescription() == null && argDescription != null) || (
/* 457 */       getDAO_().getDescription() != null && !getDAO_().getDescription().equals(argDescription))) {
/* 458 */       getDAO_().setDescription(argDescription);
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
/*     */   public boolean getVoid() {
/* 470 */     if (getDAO_().getVoid() != null) {
/* 471 */       return getDAO_().getVoid().booleanValue();
/*     */     }
/*     */     
/* 474 */     return false;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setVoid(boolean argVoid) {
/* 483 */     if (setVoid_noev(argVoid) && 
/* 484 */       this._events != null && 
/* 485 */       postEventsForChanges()) {
/* 486 */       this._events.post(IEmployeeMessage.SET_VOID, Boolean.valueOf(argVoid));
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setVoid_noev(boolean argVoid) {
/* 493 */     boolean ev_postable = false;
/*     */     
/* 495 */     if ((getDAO_().getVoid() == null && Boolean.valueOf(argVoid) != null) || (
/* 496 */       getDAO_().getVoid() != null && !getDAO_().getVoid().equals(Boolean.valueOf(argVoid)))) {
/* 497 */       getDAO_().setVoid(Boolean.valueOf(argVoid));
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
/*     */   public String getMessageURL() {
/* 509 */     return getDAO_().getMessageURL();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setMessageURL(String argMessageURL) {
/* 517 */     if (setMessageURL_noev(argMessageURL) && 
/* 518 */       this._events != null && 
/* 519 */       postEventsForChanges()) {
/* 520 */       this._events.post(IEmployeeMessage.SET_MESSAGEURL, argMessageURL);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setMessageURL_noev(String argMessageURL) {
/* 527 */     boolean ev_postable = false;
/*     */     
/* 529 */     if ((getDAO_().getMessageURL() == null && argMessageURL != null) || (
/* 530 */       getDAO_().getMessageURL() != null && !getDAO_().getMessageURL().equals(argMessageURL))) {
/* 531 */       getDAO_().setMessageURL(argMessageURL);
/* 532 */       ev_postable = true;
/*     */     } 
/*     */     
/* 535 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Date getCreateDate() {
/* 543 */     return getDAO_().getCreateDate();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setCreateDate(Date argCreateDate) {
/* 551 */     if (setCreateDate_noev(argCreateDate) && 
/* 552 */       this._events != null && 
/* 553 */       postEventsForChanges()) {
/* 554 */       this._events.post(IEmployeeMessage.SET_CREATEDATE, argCreateDate);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setCreateDate_noev(Date argCreateDate) {
/* 561 */     boolean ev_postable = false;
/*     */     
/* 563 */     if ((getDAO_().getCreateDate() == null && argCreateDate != null) || (
/* 564 */       getDAO_().getCreateDate() != null && !getDAO_().getCreateDate().equals(argCreateDate))) {
/* 565 */       getDAO_().setCreateDate(argCreateDate);
/* 566 */       ev_postable = true;
/*     */     } 
/*     */     
/* 569 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getCreateUserId() {
/* 577 */     return getDAO_().getCreateUserId();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setCreateUserId(String argCreateUserId) {
/* 585 */     if (setCreateUserId_noev(argCreateUserId) && 
/* 586 */       this._events != null && 
/* 587 */       postEventsForChanges()) {
/* 588 */       this._events.post(IEmployeeMessage.SET_CREATEUSERID, argCreateUserId);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setCreateUserId_noev(String argCreateUserId) {
/* 595 */     boolean ev_postable = false;
/*     */     
/* 597 */     if ((getDAO_().getCreateUserId() == null && argCreateUserId != null) || (
/* 598 */       getDAO_().getCreateUserId() != null && !getDAO_().getCreateUserId().equals(argCreateUserId))) {
/* 599 */       getDAO_().setCreateUserId(argCreateUserId);
/* 600 */       ev_postable = true;
/*     */     } 
/*     */     
/* 603 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Date getUpdateDate() {
/* 611 */     return getDAO_().getUpdateDate();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setUpdateDate(Date argUpdateDate) {
/* 619 */     if (setUpdateDate_noev(argUpdateDate) && 
/* 620 */       this._events != null && 
/* 621 */       postEventsForChanges()) {
/* 622 */       this._events.post(IEmployeeMessage.SET_UPDATEDATE, argUpdateDate);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setUpdateDate_noev(Date argUpdateDate) {
/* 629 */     boolean ev_postable = false;
/*     */     
/* 631 */     if ((getDAO_().getUpdateDate() == null && argUpdateDate != null) || (
/* 632 */       getDAO_().getUpdateDate() != null && !getDAO_().getUpdateDate().equals(argUpdateDate))) {
/* 633 */       getDAO_().setUpdateDate(argUpdateDate);
/* 634 */       ev_postable = true;
/*     */     } 
/*     */     
/* 637 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getUpdateUserId() {
/* 645 */     return getDAO_().getUpdateUserId();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setUpdateUserId(String argUpdateUserId) {
/* 653 */     if (setUpdateUserId_noev(argUpdateUserId) && 
/* 654 */       this._events != null && 
/* 655 */       postEventsForChanges()) {
/* 656 */       this._events.post(IEmployeeMessage.SET_UPDATEUSERID, argUpdateUserId);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setUpdateUserId_noev(String argUpdateUserId) {
/* 663 */     boolean ev_postable = false;
/*     */     
/* 665 */     if ((getDAO_().getUpdateUserId() == null && argUpdateUserId != null) || (
/* 666 */       getDAO_().getUpdateUserId() != null && !getDAO_().getUpdateUserId().equals(argUpdateUserId))) {
/* 667 */       getDAO_().setUpdateUserId(argUpdateUserId);
/* 668 */       ev_postable = true;
/*     */     } 
/*     */     
/* 671 */     return ev_postable;
/*     */   }
/*     */   
/*     */   protected IEmployeeMessageProperty newProperty(String argPropertyName) {
/* 675 */     EmployeeMessagePropertyId id = new EmployeeMessagePropertyId();
/*     */     
/* 677 */     id.setMessageId(Long.valueOf(getMessageId()));
/* 678 */     id.setPropertyCode(argPropertyName);
/*     */     
/* 680 */     IEmployeeMessageProperty prop = (IEmployeeMessageProperty)DataFactory.getInstance().createNewObject((IObjectId)id, IEmployeeMessageProperty.class);
/* 681 */     return prop;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @Relationship(name = "Properties")
/*     */   public List<IEmployeeMessageProperty> getProperties() {
/* 690 */     if (this._properties == null) {
/* 691 */       this._properties = new HistoricalList(null);
/*     */     }
/* 693 */     return (List<IEmployeeMessageProperty>)this._properties;
/*     */   }
/*     */   
/*     */   public void setProperties(List<IEmployeeMessageProperty> argProperties) {
/* 697 */     if (this._properties == null) {
/* 698 */       this._properties = new HistoricalList(argProperties);
/*     */     } else {
/* 700 */       this._properties.setCurrentList(argProperties);
/*     */     } 
/*     */     
/* 703 */     for (IEmployeeMessageProperty child : this._properties) {
/* 704 */       EmployeeMessagePropertyModel model = (EmployeeMessagePropertyModel)child;
/* 705 */       model.setOrganizationId_noev(getOrganizationId());
/* 706 */       model.setMessageId_noev(getMessageId());
/* 707 */       if (child instanceof IDataModelImpl) {
/* 708 */         IDataAccessObject childDao = ((IDataModelImpl)child).getDAO();
/* 709 */         if (StringUtils.isEmpty(childDao.getOriginDataSource()) && 
/* 710 */           !StringUtils.isEmpty(getDAO().getOriginDataSource())) {
/* 711 */           childDao.setOriginDataSource(getDAO().getOriginDataSource());
/*     */         }
/*     */       } 
/* 714 */       if (postEventsForChanges()) {
/* 715 */         this._eventManager.registerEventHandler((IEventAware)this._eventCascade, (IEventSource)child);
/*     */       }
/*     */     } 
/*     */   }
/*     */   
/*     */   public void addEmployeeMessageProperty(IEmployeeMessageProperty argEmployeeMessageProperty) {
/* 721 */     if (this._properties == null) {
/* 722 */       this._properties = new HistoricalList(null);
/*     */     }
/* 724 */     argEmployeeMessageProperty.setOrganizationId(getOrganizationId());
/* 725 */     argEmployeeMessageProperty.setMessageId(getMessageId());
/* 726 */     if (argEmployeeMessageProperty instanceof IDataModelImpl) {
/* 727 */       IDataAccessObject childDao = ((IDataModelImpl)argEmployeeMessageProperty).getDAO();
/* 728 */       if (StringUtils.isEmpty(childDao.getOriginDataSource()) && 
/* 729 */         !StringUtils.isEmpty(getDAO().getOriginDataSource())) {
/* 730 */         childDao.setOriginDataSource(getDAO().getOriginDataSource());
/*     */       }
/*     */     } 
/*     */ 
/*     */     
/* 735 */     if (postEventsForChanges()) {
/* 736 */       this._eventManager.registerEventHandler((IEventAware)this._eventCascade, (IEventSource)new EventDescriptor(argEmployeeMessageProperty));
/*     */     }
/*     */     
/* 739 */     this._properties.add(argEmployeeMessageProperty);
/* 740 */     if (postEventsForChanges()) {
/* 741 */       this._events.post(IEmployeeMessage.ADD_PROPERTIES, argEmployeeMessageProperty);
/*     */     }
/*     */   }
/*     */   
/*     */   public void removeEmployeeMessageProperty(IEmployeeMessageProperty argEmployeeMessageProperty) {
/* 746 */     if (this._properties != null) {
/*     */       
/* 748 */       if (postEventsForChanges()) {
/* 749 */         this._eventManager.deregisterEventHandler((IEventAware)this._eventCascade, (IEventSource)new EventDescriptor(argEmployeeMessageProperty));
/*     */       }
/* 751 */       this._properties.remove(argEmployeeMessageProperty);
/* 752 */       if (postEventsForChanges()) {
/* 753 */         this._events.post(IEmployeeMessage.REMOVE_PROPERTIES, argEmployeeMessageProperty);
/*     */       }
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public Object getValue(String argFieldId) {
/* 760 */     if ("Properties".equals(argFieldId)) {
/* 761 */       return getProperties();
/*     */     }
/* 763 */     if ("EmployeeMessageExtension".equals(argFieldId)) {
/* 764 */       return this._myExtension;
/*     */     }
/*     */     
/* 767 */     return super.getValue(argFieldId);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void setValue(String argFieldId, Object argValue) {
/* 773 */     if ("Properties".equals(argFieldId)) {
/* 774 */       setProperties(changeToList(argValue, IEmployeeMessageProperty.class));
/*     */     }
/* 776 */     else if ("EmployeeMessageExtension".equals(argFieldId)) {
/* 777 */       this._myExtension = (IDataModel)argValue;
/*     */     } else {
/*     */       
/* 780 */       super.setValue(argFieldId, argValue);
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public void setDependencies(IPersistenceDefaults argPD, EventManager argEM) {
/* 786 */     this._persistenceDefaults = argPD;
/* 787 */     this._daoImpl.setPersistenceDefaults(argPD);
/* 788 */     this._eventManager = argEM;
/* 789 */     this._events = (Eventor)new ModelEventor((IDataModel)this, argEM);
/* 790 */     this._eventCascade = (EventHandler)new CascadingHandler(this);
/* 791 */     if (this._properties != null) {
/* 792 */       for (IEmployeeMessageProperty relationship : this._properties) {
/* 793 */         ((IDataModelImpl)relationship).setDependencies(argPD, argEM);
/*     */       }
/*     */     }
/*     */   }
/*     */   
/*     */   public IDataModel getEmployeeMessageExt() {
/* 799 */     return this._myExtension;
/*     */   }
/*     */   
/*     */   public void setEmployeeMessageExt(IDataModel argExt) {
/* 803 */     this._myExtension = argExt;
/*     */   }
/*     */ 
/*     */   
/*     */   public void startTransaction() {
/* 808 */     if (this._alreadyInStart) {
/*     */       return;
/*     */     }
/*     */     
/* 812 */     this._alreadyInStart = true;
/*     */ 
/*     */     
/* 815 */     super.startTransaction();
/*     */     
/* 817 */     this._propertiesSavepoint = this._properties;
/* 818 */     if (this._properties != null) {
/* 819 */       this._propertiesSavepoint = new HistoricalList((List)this._properties);
/* 820 */       Iterator<IDataModel> it = this._properties.iterator();
/* 821 */       while (it.hasNext()) {
/* 822 */         ((IDataModel)it.next()).startTransaction();
/*     */       }
/*     */     } 
/*     */ 
/*     */     
/* 827 */     this._alreadyInStart = false;
/*     */   }
/*     */ 
/*     */   
/*     */   public void rollbackChanges() {
/* 832 */     if (isAlreadyRolledBack()) {
/*     */       return;
/*     */     }
/* 835 */     super.rollbackChanges();
/*     */     
/* 837 */     this._properties = this._propertiesSavepoint;
/* 838 */     this._propertiesSavepoint = null;
/* 839 */     if (this._properties != null) {
/* 840 */       Iterator<IDataModel> it = this._properties.iterator();
/* 841 */       while (it.hasNext()) {
/* 842 */         ((IDataModel)it.next()).rollbackChanges();
/*     */       }
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void commitTransaction() {
/* 850 */     if (this._alreadyInCommit) {
/*     */       return;
/*     */     }
/* 853 */     this._alreadyInCommit = true;
/*     */ 
/*     */     
/* 856 */     super.commitTransaction();
/*     */     
/* 858 */     this._propertiesSavepoint = this._properties;
/* 859 */     if (this._properties != null) {
/* 860 */       Iterator<IDataModel> it = this._properties.iterator();
/* 861 */       while (it.hasNext()) {
/* 862 */         ((IDataModel)it.next()).commitTransaction();
/*     */       }
/* 864 */       this._properties = new HistoricalList((List)this._properties);
/*     */     } 
/*     */ 
/*     */     
/* 868 */     this._alreadyInCommit = false;
/*     */   }
/*     */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\hrs\impl\EmployeeMessageModel.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */