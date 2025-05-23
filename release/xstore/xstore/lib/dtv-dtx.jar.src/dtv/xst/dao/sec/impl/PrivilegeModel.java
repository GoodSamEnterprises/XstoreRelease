/*     */ package dtv.xst.dao.sec.impl;
/*     */ import dtv.data2.IPersistenceDefaults;
/*     */ import dtv.data2.access.IDataAccessObject;
/*     */ import dtv.data2.access.IDataModel;
/*     */ import dtv.data2.access.IDataProperty;
/*     */ import dtv.data2.access.IObjectId;
/*     */ import dtv.data2.access.ModelEventor;
/*     */ import dtv.data2.access.impl.IDataModelImpl;
/*     */ import dtv.event.EventDescriptor;
/*     */ import dtv.event.EventManager;
/*     */ import dtv.event.Eventor;
/*     */ import dtv.event.IEventAware;
/*     */ import dtv.event.IEventSource;
/*     */ import dtv.util.Base64;
/*     */ import dtv.util.HistoricalList;
/*     */ import dtv.util.StringUtils;
/*     */ import dtv.xst.dao.sec.IPrivilege;
/*     */ import dtv.xst.dao.sec.IPrivilegeProperty;
/*     */ import dtv.xst.dao.sec.PrivilegePropertyId;
/*     */ import java.io.ObjectInputStream;
/*     */ import java.util.Date;
/*     */ import java.util.Iterator;
/*     */ import java.util.List;
/*     */ 
/*     */ public class PrivilegeModel extends AbstractDataModelWithPropertyImpl<IPrivilegeProperty> implements IPrivilege {
/*     */   private static final long serialVersionUID = 426579601L;
/*     */   private transient boolean _alreadyInStart = false;
/*     */   private transient boolean _alreadyInCommit = false;
/*     */   private IDataModel _myExtension;
/*     */   private HistoricalList<IPrivilegeProperty> _properties;
/*     */   
/*     */   public String toString() {
/*  33 */     return super.toString() + " Id: " + getObjectId();
/*     */   }
/*     */   private transient HistoricalList<IPrivilegeProperty> _propertiesSavepoint; private transient byte[] groupMembershipCache; private transient String lastMembership; private transient byte[] secondPromptGroupMembershipCache; private transient String secondPromptLastMembership;
/*     */   
/*     */   public void initDAO() {
/*  38 */     setDAO((IDataAccessObject)new PrivilegeDAO());
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private PrivilegeDAO getDAO_() {
/*  46 */     return (PrivilegeDAO)this._daoImpl;
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
/*  70 */       this._events.post(IPrivilege.SET_ORGANIZATIONID, Long.valueOf(argOrganizationId));
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
/*  85 */         Iterator<PrivilegePropertyModel> it = this._properties.iterator();
/*  86 */         while (it.hasNext())
/*     */         {
/*  88 */           ((PrivilegePropertyModel)it.next()).setOrganizationId_noev(argOrganizationId);
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
/*     */   public String getPrivilegeType() {
/* 101 */     return getDAO_().getPrivilegeType();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setPrivilegeType(String argPrivilegeType) {
/* 109 */     if (setPrivilegeType_noev(argPrivilegeType) && 
/* 110 */       this._events != null && 
/* 111 */       postEventsForChanges()) {
/* 112 */       this._events.post(IPrivilege.SET_PRIVILEGETYPE, argPrivilegeType);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setPrivilegeType_noev(String argPrivilegeType) {
/* 119 */     boolean ev_postable = false;
/*     */     
/* 121 */     if ((getDAO_().getPrivilegeType() == null && argPrivilegeType != null) || (
/* 122 */       getDAO_().getPrivilegeType() != null && !getDAO_().getPrivilegeType().equals(argPrivilegeType))) {
/* 123 */       getDAO_().setPrivilegeType(argPrivilegeType);
/* 124 */       ev_postable = true;
/* 125 */       if (this._properties != null) {
/*     */         
/* 127 */         Iterator<PrivilegePropertyModel> it = this._properties.iterator();
/* 128 */         while (it.hasNext())
/*     */         {
/* 130 */           ((PrivilegePropertyModel)it.next()).setPrivilegeType_noev(argPrivilegeType);
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
/* 154 */       this._events.post(IPrivilege.SET_CREATEDATE, argCreateDate);
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
/* 188 */       this._events.post(IPrivilege.SET_CREATEUSERID, argCreateUserId);
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
/* 222 */       this._events.post(IPrivilege.SET_UPDATEDATE, argUpdateDate);
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
/* 256 */       this._events.post(IPrivilege.SET_UPDATEUSERID, argUpdateUserId);
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
/*     */   public String getConfigElement() {
/* 279 */     return getDAO_().getConfigElement();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setConfigElement(String argConfigElement) {
/* 287 */     if (setConfigElement_noev(argConfigElement) && 
/* 288 */       this._events != null && 
/* 289 */       postEventsForChanges()) {
/* 290 */       this._events.post(IPrivilege.SET_CONFIGELEMENT, argConfigElement);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setConfigElement_noev(String argConfigElement) {
/* 297 */     boolean ev_postable = false;
/*     */     
/* 299 */     if ((getDAO_().getConfigElement() == null && argConfigElement != null) || (
/* 300 */       getDAO_().getConfigElement() != null && !getDAO_().getConfigElement().equals(argConfigElement))) {
/* 301 */       getDAO_().setConfigElement(argConfigElement);
/* 302 */       ev_postable = true;
/*     */     } 
/*     */     
/* 305 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean getAuthenticationRequired() {
/* 313 */     if (getDAO_().getAuthenticationRequired() != null) {
/* 314 */       return getDAO_().getAuthenticationRequired().booleanValue();
/*     */     }
/*     */     
/* 317 */     return false;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setAuthenticationRequired(boolean argAuthenticationRequired) {
/* 326 */     if (setAuthenticationRequired_noev(argAuthenticationRequired) && 
/* 327 */       this._events != null && 
/* 328 */       postEventsForChanges()) {
/* 329 */       this._events.post(IPrivilege.SET_AUTHENTICATIONREQUIRED, Boolean.valueOf(argAuthenticationRequired));
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setAuthenticationRequired_noev(boolean argAuthenticationRequired) {
/* 336 */     boolean ev_postable = false;
/*     */     
/* 338 */     if ((getDAO_().getAuthenticationRequired() == null && Boolean.valueOf(argAuthenticationRequired) != null) || (
/* 339 */       getDAO_().getAuthenticationRequired() != null && !getDAO_().getAuthenticationRequired().equals(Boolean.valueOf(argAuthenticationRequired)))) {
/* 340 */       getDAO_().setAuthenticationRequired(Boolean.valueOf(argAuthenticationRequired));
/* 341 */       ev_postable = true;
/*     */     } 
/*     */     
/* 344 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getGroupMembershipRaw() {
/* 352 */     return getDAO_().getGroupMembershipRaw();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setGroupMembershipRaw(String argGroupMembershipRaw) {
/* 360 */     if (setGroupMembershipRaw_noev(argGroupMembershipRaw) && 
/* 361 */       this._events != null && 
/* 362 */       postEventsForChanges()) {
/* 363 */       this._events.post(IPrivilege.SET_GROUPMEMBERSHIPRAW, argGroupMembershipRaw);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setGroupMembershipRaw_noev(String argGroupMembershipRaw) {
/* 370 */     boolean ev_postable = false;
/*     */     
/* 372 */     if ((getDAO_().getGroupMembershipRaw() == null && argGroupMembershipRaw != null) || (
/* 373 */       getDAO_().getGroupMembershipRaw() != null && !getDAO_().getGroupMembershipRaw().equals(argGroupMembershipRaw))) {
/* 374 */       getDAO_().setGroupMembershipRaw(argGroupMembershipRaw);
/* 375 */       ev_postable = true;
/*     */     } 
/*     */     
/* 378 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean getOverridable() {
/* 386 */     if (getDAO_().getOverridable() != null) {
/* 387 */       return getDAO_().getOverridable().booleanValue();
/*     */     }
/*     */     
/* 390 */     return false;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setOverridable(boolean argOverridable) {
/* 399 */     if (setOverridable_noev(argOverridable) && 
/* 400 */       this._events != null && 
/* 401 */       postEventsForChanges()) {
/* 402 */       this._events.post(IPrivilege.SET_OVERRIDABLE, Boolean.valueOf(argOverridable));
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setOverridable_noev(boolean argOverridable) {
/* 409 */     boolean ev_postable = false;
/*     */     
/* 411 */     if ((getDAO_().getOverridable() == null && Boolean.valueOf(argOverridable) != null) || (
/* 412 */       getDAO_().getOverridable() != null && !getDAO_().getOverridable().equals(Boolean.valueOf(argOverridable)))) {
/* 413 */       getDAO_().setOverridable(Boolean.valueOf(argOverridable));
/* 414 */       ev_postable = true;
/*     */     } 
/*     */     
/* 417 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getDescription() {
/* 425 */     return getDAO_().getDescription();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setDescription(String argDescription) {
/* 433 */     if (setDescription_noev(argDescription) && 
/* 434 */       this._events != null && 
/* 435 */       postEventsForChanges()) {
/* 436 */       this._events.post(IPrivilege.SET_DESCRIPTION, argDescription);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setDescription_noev(String argDescription) {
/* 443 */     boolean ev_postable = false;
/*     */     
/* 445 */     if ((getDAO_().getDescription() == null && argDescription != null) || (
/* 446 */       getDAO_().getDescription() != null && !getDAO_().getDescription().equals(argDescription))) {
/* 447 */       getDAO_().setDescription(argDescription);
/* 448 */       ev_postable = true;
/*     */     } 
/*     */     
/* 451 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getSecondPromptSettings() {
/* 459 */     return getDAO_().getSecondPromptSettings();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setSecondPromptSettings(String argSecondPromptSettings) {
/* 467 */     if (setSecondPromptSettings_noev(argSecondPromptSettings) && 
/* 468 */       this._events != null && 
/* 469 */       postEventsForChanges()) {
/* 470 */       this._events.post(IPrivilege.SET_SECONDPROMPTSETTINGS, argSecondPromptSettings);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setSecondPromptSettings_noev(String argSecondPromptSettings) {
/* 477 */     boolean ev_postable = false;
/*     */     
/* 479 */     if ((getDAO_().getSecondPromptSettings() == null && argSecondPromptSettings != null) || (
/* 480 */       getDAO_().getSecondPromptSettings() != null && !getDAO_().getSecondPromptSettings().equals(argSecondPromptSettings))) {
/* 481 */       getDAO_().setSecondPromptSettings(argSecondPromptSettings);
/* 482 */       ev_postable = true;
/*     */     } 
/*     */     
/* 485 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean getSecondPromptReqrDiffEmp() {
/* 493 */     if (getDAO_().getSecondPromptReqrDiffEmp() != null) {
/* 494 */       return getDAO_().getSecondPromptReqrDiffEmp().booleanValue();
/*     */     }
/*     */     
/* 497 */     return false;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setSecondPromptReqrDiffEmp(boolean argSecondPromptReqrDiffEmp) {
/* 506 */     if (setSecondPromptReqrDiffEmp_noev(argSecondPromptReqrDiffEmp) && 
/* 507 */       this._events != null && 
/* 508 */       postEventsForChanges()) {
/* 509 */       this._events.post(IPrivilege.SET_SECONDPROMPTREQRDIFFEMP, Boolean.valueOf(argSecondPromptReqrDiffEmp));
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setSecondPromptReqrDiffEmp_noev(boolean argSecondPromptReqrDiffEmp) {
/* 516 */     boolean ev_postable = false;
/*     */     
/* 518 */     if ((getDAO_().getSecondPromptReqrDiffEmp() == null && Boolean.valueOf(argSecondPromptReqrDiffEmp) != null) || (
/* 519 */       getDAO_().getSecondPromptReqrDiffEmp() != null && !getDAO_().getSecondPromptReqrDiffEmp().equals(Boolean.valueOf(argSecondPromptReqrDiffEmp)))) {
/* 520 */       getDAO_().setSecondPromptReqrDiffEmp(Boolean.valueOf(argSecondPromptReqrDiffEmp));
/* 521 */       ev_postable = true;
/*     */     } 
/*     */     
/* 524 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getSecondPromptGroupMembershipRaw() {
/* 532 */     return getDAO_().getSecondPromptGroupMembershipRaw();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setSecondPromptGroupMembershipRaw(String argSecondPromptGroupMembershipRaw) {
/* 540 */     if (setSecondPromptGroupMembershipRaw_noev(argSecondPromptGroupMembershipRaw) && 
/* 541 */       this._events != null && 
/* 542 */       postEventsForChanges()) {
/* 543 */       this._events.post(IPrivilege.SET_SECONDPROMPTGROUPMEMBERSHIPRAW, argSecondPromptGroupMembershipRaw);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setSecondPromptGroupMembershipRaw_noev(String argSecondPromptGroupMembershipRaw) {
/* 550 */     boolean ev_postable = false;
/*     */     
/* 552 */     if ((getDAO_().getSecondPromptGroupMembershipRaw() == null && argSecondPromptGroupMembershipRaw != null) || (
/* 553 */       getDAO_().getSecondPromptGroupMembershipRaw() != null && !getDAO_().getSecondPromptGroupMembershipRaw().equals(argSecondPromptGroupMembershipRaw))) {
/* 554 */       getDAO_().setSecondPromptGroupMembershipRaw(argSecondPromptGroupMembershipRaw);
/* 555 */       ev_postable = true;
/*     */     } 
/*     */     
/* 558 */     return ev_postable;
/*     */   }
/*     */   
/*     */   protected IPrivilegeProperty newProperty(String argPropertyName) {
/* 562 */     PrivilegePropertyId id = new PrivilegePropertyId();
/*     */     
/* 564 */     id.setPrivilegeType(getPrivilegeType());
/* 565 */     id.setPropertyCode(argPropertyName);
/*     */     
/* 567 */     IPrivilegeProperty prop = (IPrivilegeProperty)DataFactory.getInstance().createNewObject((IObjectId)id, IPrivilegeProperty.class);
/* 568 */     return prop;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @Relationship(name = "Properties")
/*     */   public List<IPrivilegeProperty> getProperties() {
/* 577 */     if (this._properties == null) {
/* 578 */       this._properties = new HistoricalList(null);
/*     */     }
/* 580 */     return (List<IPrivilegeProperty>)this._properties;
/*     */   }
/*     */   
/*     */   public void setProperties(List<IPrivilegeProperty> argProperties) {
/* 584 */     if (this._properties == null) {
/* 585 */       this._properties = new HistoricalList(argProperties);
/*     */     } else {
/* 587 */       this._properties.setCurrentList(argProperties);
/*     */     } 
/*     */     
/* 590 */     for (IPrivilegeProperty child : this._properties) {
/* 591 */       PrivilegePropertyModel model = (PrivilegePropertyModel)child;
/* 592 */       model.setOrganizationId_noev(getOrganizationId());
/* 593 */       model.setPrivilegeType_noev(getPrivilegeType());
/* 594 */       if (child instanceof IDataModelImpl) {
/* 595 */         IDataAccessObject childDao = ((IDataModelImpl)child).getDAO();
/* 596 */         if (StringUtils.isEmpty(childDao.getOriginDataSource()) && 
/* 597 */           !StringUtils.isEmpty(getDAO().getOriginDataSource())) {
/* 598 */           childDao.setOriginDataSource(getDAO().getOriginDataSource());
/*     */         }
/*     */       } 
/* 601 */       if (postEventsForChanges()) {
/* 602 */         this._eventManager.registerEventHandler((IEventAware)this._eventCascade, (IEventSource)child);
/*     */       }
/*     */     } 
/*     */   }
/*     */   
/*     */   public void addPrivilegeProperty(IPrivilegeProperty argPrivilegeProperty) {
/* 608 */     if (this._properties == null) {
/* 609 */       this._properties = new HistoricalList(null);
/*     */     }
/* 611 */     argPrivilegeProperty.setOrganizationId(getOrganizationId());
/* 612 */     argPrivilegeProperty.setPrivilegeType(getPrivilegeType());
/* 613 */     if (argPrivilegeProperty instanceof IDataModelImpl) {
/* 614 */       IDataAccessObject childDao = ((IDataModelImpl)argPrivilegeProperty).getDAO();
/* 615 */       if (StringUtils.isEmpty(childDao.getOriginDataSource()) && 
/* 616 */         !StringUtils.isEmpty(getDAO().getOriginDataSource())) {
/* 617 */         childDao.setOriginDataSource(getDAO().getOriginDataSource());
/*     */       }
/*     */     } 
/*     */ 
/*     */     
/* 622 */     if (postEventsForChanges()) {
/* 623 */       this._eventManager.registerEventHandler((IEventAware)this._eventCascade, (IEventSource)new EventDescriptor(argPrivilegeProperty));
/*     */     }
/*     */     
/* 626 */     this._properties.add(argPrivilegeProperty);
/* 627 */     if (postEventsForChanges()) {
/* 628 */       this._events.post(IPrivilege.ADD_PROPERTIES, argPrivilegeProperty);
/*     */     }
/*     */   }
/*     */   
/*     */   public void removePrivilegeProperty(IPrivilegeProperty argPrivilegeProperty) {
/* 633 */     if (this._properties != null) {
/*     */       
/* 635 */       if (postEventsForChanges()) {
/* 636 */         this._eventManager.deregisterEventHandler((IEventAware)this._eventCascade, (IEventSource)new EventDescriptor(argPrivilegeProperty));
/*     */       }
/* 638 */       this._properties.remove(argPrivilegeProperty);
/* 639 */       if (postEventsForChanges()) {
/* 640 */         this._events.post(IPrivilege.REMOVE_PROPERTIES, argPrivilegeProperty);
/*     */       }
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public Object getValue(String argFieldId) {
/* 647 */     if ("Properties".equals(argFieldId)) {
/* 648 */       return getProperties();
/*     */     }
/* 650 */     if ("PrivilegeExtension".equals(argFieldId)) {
/* 651 */       return this._myExtension;
/*     */     }
/*     */     
/* 654 */     return super.getValue(argFieldId);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void setValue(String argFieldId, Object argValue) {
/* 660 */     if ("Properties".equals(argFieldId)) {
/* 661 */       setProperties(changeToList(argValue, IPrivilegeProperty.class));
/*     */     }
/* 663 */     else if ("PrivilegeExtension".equals(argFieldId)) {
/* 664 */       this._myExtension = (IDataModel)argValue;
/*     */     } else {
/*     */       
/* 667 */       super.setValue(argFieldId, argValue);
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public void setDependencies(IPersistenceDefaults argPD, EventManager argEM) {
/* 673 */     this._persistenceDefaults = argPD;
/* 674 */     this._daoImpl.setPersistenceDefaults(argPD);
/* 675 */     this._eventManager = argEM;
/* 676 */     this._events = (Eventor)new ModelEventor((IDataModel)this, argEM);
/* 677 */     this._eventCascade = (EventHandler)new CascadingHandler(this);
/* 678 */     if (this._properties != null) {
/* 679 */       for (IPrivilegeProperty relationship : this._properties) {
/* 680 */         ((IDataModelImpl)relationship).setDependencies(argPD, argEM);
/*     */       }
/*     */     }
/*     */   }
/*     */   
/*     */   public IDataModel getPrivilegeExt() {
/* 686 */     return this._myExtension;
/*     */   }
/*     */   
/*     */   public void setPrivilegeExt(IDataModel argExt) {
/* 690 */     this._myExtension = argExt;
/*     */   }
/*     */ 
/*     */   
/*     */   public void startTransaction() {
/* 695 */     if (this._alreadyInStart) {
/*     */       return;
/*     */     }
/*     */     
/* 699 */     this._alreadyInStart = true;
/*     */ 
/*     */     
/* 702 */     super.startTransaction();
/*     */     
/* 704 */     this._propertiesSavepoint = this._properties;
/* 705 */     if (this._properties != null) {
/* 706 */       this._propertiesSavepoint = new HistoricalList((List)this._properties);
/* 707 */       Iterator<IDataModel> it = this._properties.iterator();
/* 708 */       while (it.hasNext()) {
/* 709 */         ((IDataModel)it.next()).startTransaction();
/*     */       }
/*     */     } 
/*     */ 
/*     */     
/* 714 */     this._alreadyInStart = false;
/*     */   }
/*     */ 
/*     */   
/*     */   public void rollbackChanges() {
/* 719 */     if (isAlreadyRolledBack()) {
/*     */       return;
/*     */     }
/* 722 */     super.rollbackChanges();
/*     */     
/* 724 */     this._properties = this._propertiesSavepoint;
/* 725 */     this._propertiesSavepoint = null;
/* 726 */     if (this._properties != null) {
/* 727 */       Iterator<IDataModel> it = this._properties.iterator();
/* 728 */       while (it.hasNext()) {
/* 729 */         ((IDataModel)it.next()).rollbackChanges();
/*     */       }
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void commitTransaction() {
/* 737 */     if (this._alreadyInCommit) {
/*     */       return;
/*     */     }
/* 740 */     this._alreadyInCommit = true;
/*     */ 
/*     */     
/* 743 */     super.commitTransaction();
/*     */     
/* 745 */     this._propertiesSavepoint = this._properties;
/* 746 */     if (this._properties != null) {
/* 747 */       Iterator<IDataModel> it = this._properties.iterator();
/* 748 */       while (it.hasNext()) {
/* 749 */         ((IDataModel)it.next()).commitTransaction();
/*     */       }
/* 751 */       this._properties = new HistoricalList((List)this._properties);
/*     */     } 
/*     */ 
/*     */     
/* 755 */     this._alreadyInCommit = false;
/*     */   }
/*     */ 
/*     */   
/*     */   private void readObject(ObjectInputStream argStream) throws IOException, ClassNotFoundException {
/* 760 */     argStream.defaultReadObject();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public byte[] getGroupMembership() {
/* 779 */     String groupMembership = getDAO_().getGroupMembershipRaw();
/*     */ 
/*     */     
/* 782 */     if (this.groupMembershipCache == null || this.lastMembership != groupMembership) {
/*     */       try {
/* 784 */         this.groupMembershipCache = Base64.base64ToByteArray(groupMembership);
/* 785 */         this.lastMembership = groupMembership;
/*     */       }
/* 787 */       catch (Exception ex) {
/* 788 */         this.groupMembershipCache = null;
/*     */       } 
/*     */     }
/*     */     
/* 792 */     return this.groupMembershipCache;
/*     */   }
/*     */ 
/*     */   
/*     */   public void setGroupMembership(byte[] argMembership) {
/* 797 */     this.groupMembershipCache = argMembership;
/* 798 */     getDAO_().setGroupMembershipRaw(Base64.byteArrayToBase64(argMembership));
/* 799 */     this.lastMembership = getDAO_().getGroupMembershipRaw();
/*     */   }
/*     */ 
/*     */   
/*     */   public byte[] getSecondPromptGroupMembership() {
/* 804 */     String secondPromptGroupMembership = getDAO_().getSecondPromptGroupMembershipRaw();
/*     */     
/* 806 */     if (this.secondPromptGroupMembershipCache == null || this.secondPromptLastMembership != secondPromptGroupMembership) {
/*     */       
/*     */       try {
/* 809 */         this
/* 810 */           .secondPromptGroupMembershipCache = Base64.base64ToByteArray(secondPromptGroupMembership);
/* 811 */         this.secondPromptLastMembership = secondPromptGroupMembership;
/*     */       }
/* 813 */       catch (Exception ex) {
/* 814 */         this.secondPromptGroupMembershipCache = null;
/*     */       } 
/*     */     }
/*     */     
/* 818 */     return this.secondPromptGroupMembershipCache;
/*     */   }
/*     */   
/*     */   public void setSecondPromptGroupMembership(byte[] argSecondPromptMembership) {
/* 822 */     this.secondPromptGroupMembershipCache = argSecondPromptMembership;
/* 823 */     getDAO_().setSecondPromptGroupMembershipRaw(
/* 824 */         Base64.byteArrayToBase64(argSecondPromptMembership));
/* 825 */     this.secondPromptLastMembership = getDAO_().getSecondPromptGroupMembershipRaw();
/*     */   }
/*     */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\sec\impl\PrivilegeModel.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */