/*     */ package dtv.xst.dao.hrs.impl;
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
/*     */ import dtv.xst.dao.hrs.IWorkCodes;
/*     */ import dtv.xst.dao.hrs.IWorkCodesProperty;
/*     */ import dtv.xst.dao.hrs.WorkCodesPropertyId;
/*     */ import dtv.xst.dao.thr.IPayrollCategory;
/*     */ import java.util.Date;
/*     */ import java.util.Iterator;
/*     */ import java.util.List;
/*     */ 
/*     */ public class WorkCodesModel extends WorkCodesBaseModel implements IWorkCodes {
/*     */   private static final long serialVersionUID = -1226491019L;
/*     */   private transient boolean _alreadyInStart = false;
/*     */   private transient boolean _alreadyInCommit = false;
/*     */   private IDataModel _myExtension;
/*     */   
/*     */   public String toString() {
/*  35 */     return super.toString() + " Id: " + getObjectId();
/*     */   }
/*     */   private IPayrollCategory _payrollCategory; private transient IPayrollCategory _payrollCategorySavepoint; private HistoricalList<IWorkCodesProperty> _properties; private transient HistoricalList<IWorkCodesProperty> _propertiesSavepoint;
/*     */   
/*     */   public void initDAO() {
/*  40 */     setDAO((IDataAccessObject)new WorkCodesDAO());
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private WorkCodesDAO getDAO_() {
/*  48 */     return (WorkCodesDAO)this._daoImpl;
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
/*  72 */       this._events.post(IWorkCodes.SET_ORGANIZATIONID, Long.valueOf(argOrganizationId));
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
/*  87 */         Iterator<WorkCodesPropertyModel> it = this._properties.iterator();
/*  88 */         while (it.hasNext())
/*     */         {
/*  90 */           ((WorkCodesPropertyModel)it.next()).setOrganizationId_noev(argOrganizationId);
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
/*     */   public String getWorkCode() {
/* 103 */     return getDAO_().getWorkCode();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setWorkCode(String argWorkCode) {
/* 111 */     if (setWorkCode_noev(argWorkCode) && 
/* 112 */       this._events != null && 
/* 113 */       postEventsForChanges()) {
/* 114 */       this._events.post(IWorkCodes.SET_WORKCODE, argWorkCode);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setWorkCode_noev(String argWorkCode) {
/* 121 */     boolean ev_postable = false;
/*     */     
/* 123 */     if ((getDAO_().getWorkCode() == null && argWorkCode != null) || (
/* 124 */       getDAO_().getWorkCode() != null && !getDAO_().getWorkCode().equals(argWorkCode))) {
/* 125 */       getDAO_().setWorkCode(argWorkCode);
/* 126 */       ev_postable = true;
/* 127 */       if (this._properties != null) {
/*     */         
/* 129 */         Iterator<WorkCodesPropertyModel> it = this._properties.iterator();
/* 130 */         while (it.hasNext())
/*     */         {
/* 132 */           ((WorkCodesPropertyModel)it.next()).setWorkCode_noev(argWorkCode);
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
/*     */   public String getOrgCode() {
/* 145 */     return getDAO_().getOrgCode();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setOrgCode(String argOrgCode) {
/* 153 */     if (setOrgCode_noev(argOrgCode) && 
/* 154 */       this._events != null && 
/* 155 */       postEventsForChanges()) {
/* 156 */       this._events.post(IWorkCodes.SET_ORGCODE, argOrgCode);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setOrgCode_noev(String argOrgCode) {
/* 163 */     boolean ev_postable = false;
/*     */     
/* 165 */     if ((getDAO_().getOrgCode() == null && argOrgCode != null) || (
/* 166 */       getDAO_().getOrgCode() != null && !getDAO_().getOrgCode().equals(argOrgCode))) {
/* 167 */       getDAO_().setOrgCode(argOrgCode);
/* 168 */       ev_postable = true;
/*     */     } 
/*     */     
/* 171 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getOrgValue() {
/* 179 */     return getDAO_().getOrgValue();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setOrgValue(String argOrgValue) {
/* 187 */     if (setOrgValue_noev(argOrgValue) && 
/* 188 */       this._events != null && 
/* 189 */       postEventsForChanges()) {
/* 190 */       this._events.post(IWorkCodes.SET_ORGVALUE, argOrgValue);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setOrgValue_noev(String argOrgValue) {
/* 197 */     boolean ev_postable = false;
/*     */     
/* 199 */     if ((getDAO_().getOrgValue() == null && argOrgValue != null) || (
/* 200 */       getDAO_().getOrgValue() != null && !getDAO_().getOrgValue().equals(argOrgValue))) {
/* 201 */       getDAO_().setOrgValue(argOrgValue);
/* 202 */       ev_postable = true;
/*     */     } 
/*     */     
/* 205 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Date getCreateDate() {
/* 213 */     return getDAO_().getCreateDate();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setCreateDate(Date argCreateDate) {
/* 221 */     if (setCreateDate_noev(argCreateDate) && 
/* 222 */       this._events != null && 
/* 223 */       postEventsForChanges()) {
/* 224 */       this._events.post(IWorkCodes.SET_CREATEDATE, argCreateDate);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setCreateDate_noev(Date argCreateDate) {
/* 231 */     boolean ev_postable = false;
/*     */     
/* 233 */     if ((getDAO_().getCreateDate() == null && argCreateDate != null) || (
/* 234 */       getDAO_().getCreateDate() != null && !getDAO_().getCreateDate().equals(argCreateDate))) {
/* 235 */       getDAO_().setCreateDate(argCreateDate);
/* 236 */       ev_postable = true;
/*     */     } 
/*     */     
/* 239 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getCreateUserId() {
/* 247 */     return getDAO_().getCreateUserId();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setCreateUserId(String argCreateUserId) {
/* 255 */     if (setCreateUserId_noev(argCreateUserId) && 
/* 256 */       this._events != null && 
/* 257 */       postEventsForChanges()) {
/* 258 */       this._events.post(IWorkCodes.SET_CREATEUSERID, argCreateUserId);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setCreateUserId_noev(String argCreateUserId) {
/* 265 */     boolean ev_postable = false;
/*     */     
/* 267 */     if ((getDAO_().getCreateUserId() == null && argCreateUserId != null) || (
/* 268 */       getDAO_().getCreateUserId() != null && !getDAO_().getCreateUserId().equals(argCreateUserId))) {
/* 269 */       getDAO_().setCreateUserId(argCreateUserId);
/* 270 */       ev_postable = true;
/*     */     } 
/*     */     
/* 273 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Date getUpdateDate() {
/* 281 */     return getDAO_().getUpdateDate();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setUpdateDate(Date argUpdateDate) {
/* 289 */     if (setUpdateDate_noev(argUpdateDate) && 
/* 290 */       this._events != null && 
/* 291 */       postEventsForChanges()) {
/* 292 */       this._events.post(IWorkCodes.SET_UPDATEDATE, argUpdateDate);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setUpdateDate_noev(Date argUpdateDate) {
/* 299 */     boolean ev_postable = false;
/*     */     
/* 301 */     if ((getDAO_().getUpdateDate() == null && argUpdateDate != null) || (
/* 302 */       getDAO_().getUpdateDate() != null && !getDAO_().getUpdateDate().equals(argUpdateDate))) {
/* 303 */       getDAO_().setUpdateDate(argUpdateDate);
/* 304 */       ev_postable = true;
/*     */     } 
/*     */     
/* 307 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getUpdateUserId() {
/* 315 */     return getDAO_().getUpdateUserId();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setUpdateUserId(String argUpdateUserId) {
/* 323 */     if (setUpdateUserId_noev(argUpdateUserId) && 
/* 324 */       this._events != null && 
/* 325 */       postEventsForChanges()) {
/* 326 */       this._events.post(IWorkCodes.SET_UPDATEUSERID, argUpdateUserId);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setUpdateUserId_noev(String argUpdateUserId) {
/* 333 */     boolean ev_postable = false;
/*     */     
/* 335 */     if ((getDAO_().getUpdateUserId() == null && argUpdateUserId != null) || (
/* 336 */       getDAO_().getUpdateUserId() != null && !getDAO_().getUpdateUserId().equals(argUpdateUserId))) {
/* 337 */       getDAO_().setUpdateUserId(argUpdateUserId);
/* 338 */       ev_postable = true;
/*     */     } 
/*     */     
/* 341 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getDescription() {
/* 349 */     return getDAO_().getDescription();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setDescription(String argDescription) {
/* 357 */     if (setDescription_noev(argDescription) && 
/* 358 */       this._events != null && 
/* 359 */       postEventsForChanges()) {
/* 360 */       this._events.post(IWorkCodes.SET_DESCRIPTION, argDescription);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setDescription_noev(String argDescription) {
/* 367 */     boolean ev_postable = false;
/*     */     
/* 369 */     if ((getDAO_().getDescription() == null && argDescription != null) || (
/* 370 */       getDAO_().getDescription() != null && !getDAO_().getDescription().equals(argDescription))) {
/* 371 */       getDAO_().setDescription(argDescription);
/* 372 */       ev_postable = true;
/*     */     } 
/*     */     
/* 375 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int getSortOrder() {
/* 383 */     if (getDAO_().getSortOrder() != null) {
/* 384 */       return getDAO_().getSortOrder().intValue();
/*     */     }
/*     */     
/* 387 */     return 0;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setSortOrder(int argSortOrder) {
/* 396 */     if (setSortOrder_noev(argSortOrder) && 
/* 397 */       this._events != null && 
/* 398 */       postEventsForChanges()) {
/* 399 */       this._events.post(IWorkCodes.SET_SORTORDER, Integer.valueOf(argSortOrder));
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setSortOrder_noev(int argSortOrder) {
/* 406 */     boolean ev_postable = false;
/*     */     
/* 408 */     if ((getDAO_().getSortOrder() == null && Integer.valueOf(argSortOrder) != null) || (
/* 409 */       getDAO_().getSortOrder() != null && !getDAO_().getSortOrder().equals(Integer.valueOf(argSortOrder)))) {
/* 410 */       getDAO_().setSortOrder(Integer.valueOf(argSortOrder));
/* 411 */       ev_postable = true;
/*     */     } 
/*     */     
/* 414 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean getSelling() {
/* 422 */     if (getDAO_().getSelling() != null) {
/* 423 */       return getDAO_().getSelling().booleanValue();
/*     */     }
/*     */     
/* 426 */     return false;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setSelling(boolean argSelling) {
/* 435 */     if (setSelling_noev(argSelling) && 
/* 436 */       this._events != null && 
/* 437 */       postEventsForChanges()) {
/* 438 */       this._events.post(IWorkCodes.SET_SELLING, Boolean.valueOf(argSelling));
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setSelling_noev(boolean argSelling) {
/* 445 */     boolean ev_postable = false;
/*     */     
/* 447 */     if ((getDAO_().getSelling() == null && Boolean.valueOf(argSelling) != null) || (
/* 448 */       getDAO_().getSelling() != null && !getDAO_().getSelling().equals(Boolean.valueOf(argSelling)))) {
/* 449 */       getDAO_().setSelling(Boolean.valueOf(argSelling));
/* 450 */       ev_postable = true;
/*     */     } 
/*     */     
/* 453 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getPrivilege() {
/* 461 */     return getDAO_().getPrivilege();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setPrivilege(String argPrivilege) {
/* 469 */     if (setPrivilege_noev(argPrivilege) && 
/* 470 */       this._events != null && 
/* 471 */       postEventsForChanges()) {
/* 472 */       this._events.post(IWorkCodes.SET_PRIVILEGE, argPrivilege);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setPrivilege_noev(String argPrivilege) {
/* 479 */     boolean ev_postable = false;
/*     */     
/* 481 */     if ((getDAO_().getPrivilege() == null && argPrivilege != null) || (
/* 482 */       getDAO_().getPrivilege() != null && !getDAO_().getPrivilege().equals(argPrivilege))) {
/* 483 */       getDAO_().setPrivilege(argPrivilege);
/* 484 */       ev_postable = true;
/*     */     } 
/*     */     
/* 487 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getPayrollCategoryString() {
/* 495 */     return getDAO_().getPayrollCategoryString();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setPayrollCategoryString(String argPayrollCategoryString) {
/* 503 */     if (setPayrollCategoryString_noev(argPayrollCategoryString) && 
/* 504 */       this._events != null && 
/* 505 */       postEventsForChanges()) {
/* 506 */       this._events.post(IWorkCodes.SET_PAYROLLCATEGORYSTRING, argPayrollCategoryString);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setPayrollCategoryString_noev(String argPayrollCategoryString) {
/* 513 */     boolean ev_postable = false;
/*     */     
/* 515 */     if ((getDAO_().getPayrollCategoryString() == null && argPayrollCategoryString != null) || (
/* 516 */       getDAO_().getPayrollCategoryString() != null && !getDAO_().getPayrollCategoryString().equals(argPayrollCategoryString))) {
/* 517 */       getDAO_().setPayrollCategoryString(argPayrollCategoryString);
/* 518 */       ev_postable = true;
/*     */     } 
/*     */     
/* 521 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int getMinimumClockInDuration() {
/* 529 */     if (getDAO_().getMinimumClockInDuration() != null) {
/* 530 */       return getDAO_().getMinimumClockInDuration().intValue();
/*     */     }
/*     */     
/* 533 */     return 0;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setMinimumClockInDuration(int argMinimumClockInDuration) {
/* 542 */     if (setMinimumClockInDuration_noev(argMinimumClockInDuration) && 
/* 543 */       this._events != null && 
/* 544 */       postEventsForChanges()) {
/* 545 */       this._events.post(IWorkCodes.SET_MINIMUMCLOCKINDURATION, Integer.valueOf(argMinimumClockInDuration));
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setMinimumClockInDuration_noev(int argMinimumClockInDuration) {
/* 552 */     boolean ev_postable = false;
/*     */     
/* 554 */     if ((getDAO_().getMinimumClockInDuration() == null && Integer.valueOf(argMinimumClockInDuration) != null) || (
/* 555 */       getDAO_().getMinimumClockInDuration() != null && !getDAO_().getMinimumClockInDuration().equals(Integer.valueOf(argMinimumClockInDuration)))) {
/* 556 */       getDAO_().setMinimumClockInDuration(Integer.valueOf(argMinimumClockInDuration));
/* 557 */       ev_postable = true;
/*     */     } 
/*     */     
/* 560 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int getMinimumClockOutDuration() {
/* 568 */     if (getDAO_().getMinimumClockOutDuration() != null) {
/* 569 */       return getDAO_().getMinimumClockOutDuration().intValue();
/*     */     }
/*     */     
/* 572 */     return 0;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setMinimumClockOutDuration(int argMinimumClockOutDuration) {
/* 581 */     if (setMinimumClockOutDuration_noev(argMinimumClockOutDuration) && 
/* 582 */       this._events != null && 
/* 583 */       postEventsForChanges()) {
/* 584 */       this._events.post(IWorkCodes.SET_MINIMUMCLOCKOUTDURATION, Integer.valueOf(argMinimumClockOutDuration));
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setMinimumClockOutDuration_noev(int argMinimumClockOutDuration) {
/* 591 */     boolean ev_postable = false;
/*     */     
/* 593 */     if ((getDAO_().getMinimumClockOutDuration() == null && Integer.valueOf(argMinimumClockOutDuration) != null) || (
/* 594 */       getDAO_().getMinimumClockOutDuration() != null && !getDAO_().getMinimumClockOutDuration().equals(Integer.valueOf(argMinimumClockOutDuration)))) {
/* 595 */       getDAO_().setMinimumClockOutDuration(Integer.valueOf(argMinimumClockOutDuration));
/* 596 */       ev_postable = true;
/*     */     } 
/*     */     
/* 599 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean getHidden() {
/* 607 */     if (getDAO_().getHidden() != null) {
/* 608 */       return getDAO_().getHidden().booleanValue();
/*     */     }
/*     */     
/* 611 */     return false;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setHidden(boolean argHidden) {
/* 620 */     if (setHidden_noev(argHidden) && 
/* 621 */       this._events != null && 
/* 622 */       postEventsForChanges()) {
/* 623 */       this._events.post(IWorkCodes.SET_HIDDEN, Boolean.valueOf(argHidden));
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setHidden_noev(boolean argHidden) {
/* 630 */     boolean ev_postable = false;
/*     */     
/* 632 */     if ((getDAO_().getHidden() == null && Boolean.valueOf(argHidden) != null) || (
/* 633 */       getDAO_().getHidden() != null && !getDAO_().getHidden().equals(Boolean.valueOf(argHidden)))) {
/* 634 */       getDAO_().setHidden(Boolean.valueOf(argHidden));
/* 635 */       ev_postable = true;
/*     */     } 
/*     */     
/* 638 */     return ev_postable;
/*     */   }
/*     */   
/*     */   protected IWorkCodesProperty newProperty(String argPropertyName) {
/* 642 */     WorkCodesPropertyId id = new WorkCodesPropertyId();
/*     */     
/* 644 */     id.setWorkCode(getWorkCode());
/* 645 */     id.setPropertyCode(argPropertyName);
/*     */     
/* 647 */     IWorkCodesProperty prop = (IWorkCodesProperty)DataFactory.getInstance().createNewObject((IObjectId)id, IWorkCodesProperty.class);
/* 648 */     return prop;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @Relationship(name = "PayrollCategory")
/*     */   public IPayrollCategory getPayrollCategory() {
/* 660 */     return this._payrollCategory;
/*     */   }
/*     */ 
/*     */   
/*     */   public void setPayrollCategory(IPayrollCategory argPayrollCategory) {
/* 665 */     if (argPayrollCategory == null) {
/*     */       
/* 667 */       getDAO_().setPayrollCategoryString(null);
/* 668 */       if (this._payrollCategory != null)
/*     */       {
/* 670 */         if (postEventsForChanges()) {
/* 671 */           this._eventManager.deregisterEventHandler((IEventAware)this._eventCascade, (IEventSource)new EventDescriptor(this._payrollCategory));
/*     */         }
/*     */       }
/*     */     } else {
/*     */       
/* 676 */       getDAO_().setPayrollCategoryString(argPayrollCategory.getPayrollCategory());
/*     */       
/* 678 */       if (postEventsForChanges()) {
/* 679 */         this._eventManager.registerEventHandler((IEventAware)this._eventCascade, (IEventSource)new EventDescriptor(argPayrollCategory));
/*     */       }
/*     */     } 
/*     */     
/* 683 */     this._payrollCategory = argPayrollCategory;
/* 684 */     if (postEventsForChanges()) {
/* 685 */       this._events.post(IWorkCodes.SET_PAYROLLCATEGORY, argPayrollCategory);
/*     */     }
/*     */   }
/*     */   
/*     */   @Relationship(name = "Properties")
/*     */   public List<IWorkCodesProperty> getProperties() {
/* 691 */     if (this._properties == null) {
/* 692 */       this._properties = new HistoricalList(null);
/*     */     }
/* 694 */     return (List<IWorkCodesProperty>)this._properties;
/*     */   }
/*     */   
/*     */   public void setProperties(List<IWorkCodesProperty> argProperties) {
/* 698 */     if (this._properties == null) {
/* 699 */       this._properties = new HistoricalList(argProperties);
/*     */     } else {
/* 701 */       this._properties.setCurrentList(argProperties);
/*     */     } 
/*     */     
/* 704 */     for (IWorkCodesProperty child : this._properties) {
/* 705 */       WorkCodesPropertyModel model = (WorkCodesPropertyModel)child;
/* 706 */       model.setOrganizationId_noev(getOrganizationId());
/* 707 */       model.setWorkCode_noev(getWorkCode());
/* 708 */       if (child instanceof IDataModelImpl) {
/* 709 */         IDataAccessObject childDao = ((IDataModelImpl)child).getDAO();
/* 710 */         if (StringUtils.isEmpty(childDao.getOriginDataSource()) && 
/* 711 */           !StringUtils.isEmpty(getDAO().getOriginDataSource())) {
/* 712 */           childDao.setOriginDataSource(getDAO().getOriginDataSource());
/*     */         }
/*     */       } 
/* 715 */       if (postEventsForChanges()) {
/* 716 */         this._eventManager.registerEventHandler((IEventAware)this._eventCascade, (IEventSource)child);
/*     */       }
/*     */     } 
/*     */   }
/*     */   
/*     */   public void addWorkCodesProperty(IWorkCodesProperty argWorkCodesProperty) {
/* 722 */     if (this._properties == null) {
/* 723 */       this._properties = new HistoricalList(null);
/*     */     }
/* 725 */     argWorkCodesProperty.setOrganizationId(getOrganizationId());
/* 726 */     argWorkCodesProperty.setWorkCode(getWorkCode());
/* 727 */     if (argWorkCodesProperty instanceof IDataModelImpl) {
/* 728 */       IDataAccessObject childDao = ((IDataModelImpl)argWorkCodesProperty).getDAO();
/* 729 */       if (StringUtils.isEmpty(childDao.getOriginDataSource()) && 
/* 730 */         !StringUtils.isEmpty(getDAO().getOriginDataSource())) {
/* 731 */         childDao.setOriginDataSource(getDAO().getOriginDataSource());
/*     */       }
/*     */     } 
/*     */ 
/*     */     
/* 736 */     if (postEventsForChanges()) {
/* 737 */       this._eventManager.registerEventHandler((IEventAware)this._eventCascade, (IEventSource)new EventDescriptor(argWorkCodesProperty));
/*     */     }
/*     */     
/* 740 */     this._properties.add(argWorkCodesProperty);
/* 741 */     if (postEventsForChanges()) {
/* 742 */       this._events.post(IWorkCodes.ADD_PROPERTIES, argWorkCodesProperty);
/*     */     }
/*     */   }
/*     */   
/*     */   public void removeWorkCodesProperty(IWorkCodesProperty argWorkCodesProperty) {
/* 747 */     if (this._properties != null) {
/*     */       
/* 749 */       if (postEventsForChanges()) {
/* 750 */         this._eventManager.deregisterEventHandler((IEventAware)this._eventCascade, (IEventSource)new EventDescriptor(argWorkCodesProperty));
/*     */       }
/* 752 */       this._properties.remove(argWorkCodesProperty);
/* 753 */       if (postEventsForChanges()) {
/* 754 */         this._events.post(IWorkCodes.REMOVE_PROPERTIES, argWorkCodesProperty);
/*     */       }
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public Object getValue(String argFieldId) {
/* 761 */     if ("PayrollCategory".equals(argFieldId)) {
/* 762 */       return getPayrollCategory();
/*     */     }
/* 764 */     if ("Properties".equals(argFieldId)) {
/* 765 */       return getProperties();
/*     */     }
/* 767 */     if ("WorkCodesExtension".equals(argFieldId)) {
/* 768 */       return this._myExtension;
/*     */     }
/*     */     
/* 771 */     return super.getValue(argFieldId);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void setValue(String argFieldId, Object argValue) {
/* 777 */     if ("PayrollCategory".equals(argFieldId)) {
/* 778 */       setPayrollCategory((IPayrollCategory)argValue);
/*     */     }
/* 780 */     else if ("Properties".equals(argFieldId)) {
/* 781 */       setProperties(changeToList(argValue, IWorkCodesProperty.class));
/*     */     }
/* 783 */     else if ("WorkCodesExtension".equals(argFieldId)) {
/* 784 */       this._myExtension = (IDataModel)argValue;
/*     */     } else {
/*     */       
/* 787 */       super.setValue(argFieldId, argValue);
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public void setDependencies(IPersistenceDefaults argPD, EventManager argEM) {
/* 793 */     this._persistenceDefaults = argPD;
/* 794 */     this._daoImpl.setPersistenceDefaults(argPD);
/* 795 */     this._eventManager = argEM;
/* 796 */     this._events = (Eventor)new ModelEventor((IDataModel)this, argEM);
/* 797 */     this._eventCascade = (EventHandler)new CascadingHandler(this);
/* 798 */     if (this._payrollCategory != null) {
/* 799 */       ((IDataModelImpl)this._payrollCategory).setDependencies(argPD, argEM);
/*     */     }
/* 801 */     if (this._properties != null) {
/* 802 */       for (IWorkCodesProperty relationship : this._properties) {
/* 803 */         ((IDataModelImpl)relationship).setDependencies(argPD, argEM);
/*     */       }
/*     */     }
/*     */   }
/*     */   
/*     */   public IDataModel getWorkCodesExt() {
/* 809 */     return this._myExtension;
/*     */   }
/*     */   
/*     */   public void setWorkCodesExt(IDataModel argExt) {
/* 813 */     this._myExtension = argExt;
/*     */   }
/*     */ 
/*     */   
/*     */   public void startTransaction() {
/* 818 */     if (this._alreadyInStart) {
/*     */       return;
/*     */     }
/*     */     
/* 822 */     this._alreadyInStart = true;
/*     */ 
/*     */     
/* 825 */     super.startTransaction();
/*     */     
/* 827 */     this._payrollCategorySavepoint = this._payrollCategory;
/* 828 */     if (this._payrollCategory != null) {
/* 829 */       this._payrollCategory.startTransaction();
/*     */     }
/*     */     
/* 832 */     this._propertiesSavepoint = this._properties;
/* 833 */     if (this._properties != null) {
/* 834 */       this._propertiesSavepoint = new HistoricalList((List)this._properties);
/* 835 */       Iterator<IDataModel> it = this._properties.iterator();
/* 836 */       while (it.hasNext()) {
/* 837 */         ((IDataModel)it.next()).startTransaction();
/*     */       }
/*     */     } 
/*     */ 
/*     */     
/* 842 */     this._alreadyInStart = false;
/*     */   }
/*     */ 
/*     */   
/*     */   public void rollbackChanges() {
/* 847 */     if (isAlreadyRolledBack()) {
/*     */       return;
/*     */     }
/* 850 */     super.rollbackChanges();
/*     */     
/* 852 */     this._payrollCategory = this._payrollCategorySavepoint;
/* 853 */     this._payrollCategorySavepoint = null;
/* 854 */     if (this._payrollCategory != null) {
/* 855 */       this._payrollCategory.rollbackChanges();
/*     */     }
/*     */     
/* 858 */     this._properties = this._propertiesSavepoint;
/* 859 */     this._propertiesSavepoint = null;
/* 860 */     if (this._properties != null) {
/* 861 */       Iterator<IDataModel> it = this._properties.iterator();
/* 862 */       while (it.hasNext()) {
/* 863 */         ((IDataModel)it.next()).rollbackChanges();
/*     */       }
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void commitTransaction() {
/* 871 */     if (this._alreadyInCommit) {
/*     */       return;
/*     */     }
/* 874 */     this._alreadyInCommit = true;
/*     */ 
/*     */     
/* 877 */     super.commitTransaction();
/*     */     
/* 879 */     this._payrollCategorySavepoint = this._payrollCategory;
/* 880 */     if (this._payrollCategory != null) {
/* 881 */       this._payrollCategory.commitTransaction();
/*     */     }
/*     */     
/* 884 */     this._propertiesSavepoint = this._properties;
/* 885 */     if (this._properties != null) {
/* 886 */       Iterator<IDataModel> it = this._properties.iterator();
/* 887 */       while (it.hasNext()) {
/* 888 */         ((IDataModel)it.next()).commitTransaction();
/*     */       }
/* 890 */       this._properties = new HistoricalList((List)this._properties);
/*     */     } 
/*     */ 
/*     */     
/* 894 */     this._alreadyInCommit = false;
/*     */   }
/*     */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\hrs\impl\WorkCodesModel.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */