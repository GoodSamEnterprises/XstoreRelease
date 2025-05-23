/*     */ package dtv.xst.dao.thr.impl;
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
/*     */ import dtv.event.handler.CascadingHandler;
/*     */ import dtv.util.HistoricalList;
/*     */ import dtv.util.StringUtils;
/*     */ import dtv.xst.dao.thr.IPayroll;
/*     */ import dtv.xst.dao.thr.IPayrollProperty;
/*     */ import dtv.xst.dao.thr.PayrollPropertyId;
/*     */ import java.io.IOException;
/*     */ import java.io.ObjectInputStream;
/*     */ import java.math.BigDecimal;
/*     */ import java.util.Date;
/*     */ import java.util.Iterator;
/*     */ import java.util.List;
/*     */ 
/*     */ public class PayrollModel extends AbstractDataModelWithPropertyImpl<IPayrollProperty> implements IPayroll {
/*     */   private static final long serialVersionUID = 878130437L;
/*     */   private transient boolean _alreadyInStart = false;
/*     */   private transient boolean _alreadyInCommit = false;
/*     */   
/*     */   public String toString() {
/*  33 */     return super.toString() + " Id: " + getObjectId();
/*     */   }
/*     */   private IDataModel _myExtension; private HistoricalList<IPayrollProperty> _properties; private transient HistoricalList<IPayrollProperty> _propertiesSavepoint;
/*     */   
/*     */   public void initDAO() {
/*  38 */     setDAO((IDataAccessObject)new PayrollDAO());
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private PayrollDAO getDAO_() {
/*  46 */     return (PayrollDAO)this._daoImpl;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public long getRetailLocId() {
/*  54 */     if (getDAO_().getRetailLocId() != null) {
/*  55 */       return getDAO_().getRetailLocId().longValue();
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
/*     */   public void setRetailLocId(long argRetailLocId) {
/*  67 */     if (setRetailLocId_noev(argRetailLocId) && 
/*  68 */       this._events != null && 
/*  69 */       postEventsForChanges()) {
/*  70 */       this._events.post(IPayroll.SET_RETAILLOCID, Long.valueOf(argRetailLocId));
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setRetailLocId_noev(long argRetailLocId) {
/*  77 */     boolean ev_postable = false;
/*     */     
/*  79 */     if ((getDAO_().getRetailLocId() == null && Long.valueOf(argRetailLocId) != null) || (
/*  80 */       getDAO_().getRetailLocId() != null && !getDAO_().getRetailLocId().equals(Long.valueOf(argRetailLocId)))) {
/*  81 */       getDAO_().setRetailLocId(Long.valueOf(argRetailLocId));
/*  82 */       ev_postable = true;
/*  83 */       if (this._properties != null) {
/*     */         
/*  85 */         Iterator<PayrollPropertyModel> it = this._properties.iterator();
/*  86 */         while (it.hasNext())
/*     */         {
/*  88 */           ((PayrollPropertyModel)it.next()).setRetailLocId_noev(argRetailLocId);
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
/*     */   public long getPartyId() {
/* 101 */     if (getDAO_().getPartyId() != null) {
/* 102 */       return getDAO_().getPartyId().longValue();
/*     */     }
/*     */     
/* 105 */     return 0L;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setPartyId(long argPartyId) {
/* 114 */     if (setPartyId_noev(argPartyId) && 
/* 115 */       this._events != null && 
/* 116 */       postEventsForChanges()) {
/* 117 */       this._events.post(IPayroll.SET_PARTYID, Long.valueOf(argPartyId));
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setPartyId_noev(long argPartyId) {
/* 124 */     boolean ev_postable = false;
/*     */     
/* 126 */     if ((getDAO_().getPartyId() == null && Long.valueOf(argPartyId) != null) || (
/* 127 */       getDAO_().getPartyId() != null && !getDAO_().getPartyId().equals(Long.valueOf(argPartyId)))) {
/* 128 */       getDAO_().setPartyId(Long.valueOf(argPartyId));
/* 129 */       ev_postable = true;
/* 130 */       if (this._properties != null) {
/*     */         
/* 132 */         Iterator<PayrollPropertyModel> it = this._properties.iterator();
/* 133 */         while (it.hasNext())
/*     */         {
/* 135 */           ((PayrollPropertyModel)it.next()).setPartyId_noev(argPartyId);
/*     */         }
/*     */       } 
/*     */     } 
/*     */     
/* 140 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public long getOrganizationId() {
/* 148 */     if (getDAO_().getOrganizationId() != null) {
/* 149 */       return getDAO_().getOrganizationId().longValue();
/*     */     }
/*     */     
/* 152 */     return 0L;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setOrganizationId(long argOrganizationId) {
/* 161 */     if (setOrganizationId_noev(argOrganizationId) && 
/* 162 */       this._events != null && 
/* 163 */       postEventsForChanges()) {
/* 164 */       this._events.post(IPayroll.SET_ORGANIZATIONID, Long.valueOf(argOrganizationId));
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setOrganizationId_noev(long argOrganizationId) {
/* 171 */     boolean ev_postable = false;
/*     */     
/* 173 */     if ((getDAO_().getOrganizationId() == null && Long.valueOf(argOrganizationId) != null) || (
/* 174 */       getDAO_().getOrganizationId() != null && !getDAO_().getOrganizationId().equals(Long.valueOf(argOrganizationId)))) {
/* 175 */       getDAO_().setOrganizationId(Long.valueOf(argOrganizationId));
/* 176 */       ev_postable = true;
/* 177 */       if (this._properties != null) {
/*     */         
/* 179 */         Iterator<PayrollPropertyModel> it = this._properties.iterator();
/* 180 */         while (it.hasNext())
/*     */         {
/* 182 */           ((PayrollPropertyModel)it.next()).setOrganizationId_noev(argOrganizationId);
/*     */         }
/*     */       } 
/*     */     } 
/*     */     
/* 187 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Date getBusinessDate() {
/* 195 */     return getDAO_().getBusinessDate();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setBusinessDate(Date argBusinessDate) {
/* 203 */     if (setBusinessDate_noev(argBusinessDate) && 
/* 204 */       this._events != null && 
/* 205 */       postEventsForChanges()) {
/* 206 */       this._events.post(IPayroll.SET_BUSINESSDATE, argBusinessDate);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setBusinessDate_noev(Date argBusinessDate) {
/* 213 */     boolean ev_postable = false;
/*     */     
/* 215 */     if ((getDAO_().getBusinessDate() == null && argBusinessDate != null) || (
/* 216 */       getDAO_().getBusinessDate() != null && !getDAO_().getBusinessDate().equals(argBusinessDate))) {
/* 217 */       getDAO_().setBusinessDate(argBusinessDate);
/* 218 */       ev_postable = true;
/* 219 */       if (this._properties != null) {
/*     */         
/* 221 */         Iterator<PayrollPropertyModel> it = this._properties.iterator();
/* 222 */         while (it.hasNext())
/*     */         {
/* 224 */           ((PayrollPropertyModel)it.next()).setBusinessDate_noev(argBusinessDate);
/*     */         }
/*     */       } 
/*     */     } 
/*     */     
/* 229 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getPayrollCategory() {
/* 237 */     return getDAO_().getPayrollCategory();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setPayrollCategory(String argPayrollCategory) {
/* 245 */     if (setPayrollCategory_noev(argPayrollCategory) && 
/* 246 */       this._events != null && 
/* 247 */       postEventsForChanges()) {
/* 248 */       this._events.post(IPayroll.SET_PAYROLLCATEGORY, argPayrollCategory);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setPayrollCategory_noev(String argPayrollCategory) {
/* 255 */     boolean ev_postable = false;
/*     */     
/* 257 */     if ((getDAO_().getPayrollCategory() == null && argPayrollCategory != null) || (
/* 258 */       getDAO_().getPayrollCategory() != null && !getDAO_().getPayrollCategory().equals(argPayrollCategory))) {
/* 259 */       getDAO_().setPayrollCategory(argPayrollCategory);
/* 260 */       ev_postable = true;
/* 261 */       if (this._properties != null) {
/*     */         
/* 263 */         Iterator<PayrollPropertyModel> it = this._properties.iterator();
/* 264 */         while (it.hasNext())
/*     */         {
/* 266 */           ((PayrollPropertyModel)it.next()).setPayrollCategory_noev(argPayrollCategory);
/*     */         }
/*     */       } 
/*     */     } 
/*     */     
/* 271 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Date getCreateDate() {
/* 279 */     return getDAO_().getCreateDate();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setCreateDate(Date argCreateDate) {
/* 287 */     if (setCreateDate_noev(argCreateDate) && 
/* 288 */       this._events != null && 
/* 289 */       postEventsForChanges()) {
/* 290 */       this._events.post(IPayroll.SET_CREATEDATE, argCreateDate);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setCreateDate_noev(Date argCreateDate) {
/* 297 */     boolean ev_postable = false;
/*     */     
/* 299 */     if ((getDAO_().getCreateDate() == null && argCreateDate != null) || (
/* 300 */       getDAO_().getCreateDate() != null && !getDAO_().getCreateDate().equals(argCreateDate))) {
/* 301 */       getDAO_().setCreateDate(argCreateDate);
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
/*     */   public String getCreateUserId() {
/* 313 */     return getDAO_().getCreateUserId();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setCreateUserId(String argCreateUserId) {
/* 321 */     if (setCreateUserId_noev(argCreateUserId) && 
/* 322 */       this._events != null && 
/* 323 */       postEventsForChanges()) {
/* 324 */       this._events.post(IPayroll.SET_CREATEUSERID, argCreateUserId);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setCreateUserId_noev(String argCreateUserId) {
/* 331 */     boolean ev_postable = false;
/*     */     
/* 333 */     if ((getDAO_().getCreateUserId() == null && argCreateUserId != null) || (
/* 334 */       getDAO_().getCreateUserId() != null && !getDAO_().getCreateUserId().equals(argCreateUserId))) {
/* 335 */       getDAO_().setCreateUserId(argCreateUserId);
/* 336 */       ev_postable = true;
/*     */     } 
/*     */     
/* 339 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Date getUpdateDate() {
/* 347 */     return getDAO_().getUpdateDate();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setUpdateDate(Date argUpdateDate) {
/* 355 */     if (setUpdateDate_noev(argUpdateDate) && 
/* 356 */       this._events != null && 
/* 357 */       postEventsForChanges()) {
/* 358 */       this._events.post(IPayroll.SET_UPDATEDATE, argUpdateDate);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setUpdateDate_noev(Date argUpdateDate) {
/* 365 */     boolean ev_postable = false;
/*     */     
/* 367 */     if ((getDAO_().getUpdateDate() == null && argUpdateDate != null) || (
/* 368 */       getDAO_().getUpdateDate() != null && !getDAO_().getUpdateDate().equals(argUpdateDate))) {
/* 369 */       getDAO_().setUpdateDate(argUpdateDate);
/* 370 */       ev_postable = true;
/*     */     } 
/*     */     
/* 373 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getUpdateUserId() {
/* 381 */     return getDAO_().getUpdateUserId();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setUpdateUserId(String argUpdateUserId) {
/* 389 */     if (setUpdateUserId_noev(argUpdateUserId) && 
/* 390 */       this._events != null && 
/* 391 */       postEventsForChanges()) {
/* 392 */       this._events.post(IPayroll.SET_UPDATEUSERID, argUpdateUserId);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setUpdateUserId_noev(String argUpdateUserId) {
/* 399 */     boolean ev_postable = false;
/*     */     
/* 401 */     if ((getDAO_().getUpdateUserId() == null && argUpdateUserId != null) || (
/* 402 */       getDAO_().getUpdateUserId() != null && !getDAO_().getUpdateUserId().equals(argUpdateUserId))) {
/* 403 */       getDAO_().setUpdateUserId(argUpdateUserId);
/* 404 */       ev_postable = true;
/*     */     } 
/*     */     
/* 407 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public BigDecimal getHoursCount() {
/* 415 */     return getDAO_().getHoursCount();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setHoursCount(BigDecimal argHoursCount) {
/* 423 */     if (setHoursCount_noev(argHoursCount) && 
/* 424 */       this._events != null && 
/* 425 */       postEventsForChanges()) {
/* 426 */       this._events.post(IPayroll.SET_HOURSCOUNT, argHoursCount);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setHoursCount_noev(BigDecimal argHoursCount) {
/* 433 */     boolean ev_postable = false;
/*     */     
/* 435 */     if ((getDAO_().getHoursCount() == null && argHoursCount != null) || (
/* 436 */       getDAO_().getHoursCount() != null && !getDAO_().getHoursCount().equals(argHoursCount))) {
/* 437 */       getDAO_().setHoursCount(argHoursCount);
/* 438 */       ev_postable = true;
/*     */     } 
/*     */     
/* 441 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean getPosted() {
/* 449 */     if (getDAO_().getPosted() != null) {
/* 450 */       return getDAO_().getPosted().booleanValue();
/*     */     }
/*     */     
/* 453 */     return false;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setPosted(boolean argPosted) {
/* 462 */     if (setPosted_noev(argPosted) && 
/* 463 */       this._events != null && 
/* 464 */       postEventsForChanges()) {
/* 465 */       this._events.post(IPayroll.SET_POSTED, Boolean.valueOf(argPosted));
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setPosted_noev(boolean argPosted) {
/* 472 */     boolean ev_postable = false;
/*     */     
/* 474 */     if ((getDAO_().getPosted() == null && Boolean.valueOf(argPosted) != null) || (
/* 475 */       getDAO_().getPosted() != null && !getDAO_().getPosted().equals(Boolean.valueOf(argPosted)))) {
/* 476 */       getDAO_().setPosted(Boolean.valueOf(argPosted));
/* 477 */       ev_postable = true;
/*     */     } 
/*     */     
/* 480 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Date getPostedDate() {
/* 488 */     return getDAO_().getPostedDate();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setPostedDate(Date argPostedDate) {
/* 496 */     if (setPostedDate_noev(argPostedDate) && 
/* 497 */       this._events != null && 
/* 498 */       postEventsForChanges()) {
/* 499 */       this._events.post(IPayroll.SET_POSTEDDATE, argPostedDate);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setPostedDate_noev(Date argPostedDate) {
/* 506 */     boolean ev_postable = false;
/*     */     
/* 508 */     if ((getDAO_().getPostedDate() == null && argPostedDate != null) || (
/* 509 */       getDAO_().getPostedDate() != null && !getDAO_().getPostedDate().equals(argPostedDate))) {
/* 510 */       getDAO_().setPostedDate(argPostedDate);
/* 511 */       ev_postable = true;
/*     */     } 
/*     */     
/* 514 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getPayrollStatus() {
/* 522 */     return getDAO_().getPayrollStatus();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setPayrollStatus(String argPayrollStatus) {
/* 530 */     if (setPayrollStatus_noev(argPayrollStatus) && 
/* 531 */       this._events != null && 
/* 532 */       postEventsForChanges()) {
/* 533 */       this._events.post(IPayroll.SET_PAYROLLSTATUS, argPayrollStatus);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setPayrollStatus_noev(String argPayrollStatus) {
/* 540 */     boolean ev_postable = false;
/*     */     
/* 542 */     if ((getDAO_().getPayrollStatus() == null && argPayrollStatus != null) || (
/* 543 */       getDAO_().getPayrollStatus() != null && !getDAO_().getPayrollStatus().equals(argPayrollStatus))) {
/* 544 */       getDAO_().setPayrollStatus(argPayrollStatus);
/* 545 */       ev_postable = true;
/*     */     } 
/*     */     
/* 548 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Date getReviewedDate() {
/* 556 */     return getDAO_().getReviewedDate();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setReviewedDate(Date argReviewedDate) {
/* 564 */     if (setReviewedDate_noev(argReviewedDate) && 
/* 565 */       this._events != null && 
/* 566 */       postEventsForChanges()) {
/* 567 */       this._events.post(IPayroll.SET_REVIEWEDDATE, argReviewedDate);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setReviewedDate_noev(Date argReviewedDate) {
/* 574 */     boolean ev_postable = false;
/*     */     
/* 576 */     if ((getDAO_().getReviewedDate() == null && argReviewedDate != null) || (
/* 577 */       getDAO_().getReviewedDate() != null && !getDAO_().getReviewedDate().equals(argReviewedDate))) {
/* 578 */       getDAO_().setReviewedDate(argReviewedDate);
/* 579 */       ev_postable = true;
/*     */     } 
/*     */     
/* 582 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getPayCode() {
/* 590 */     return getDAO_().getPayCode();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setPayCode(String argPayCode) {
/* 598 */     if (setPayCode_noev(argPayCode) && 
/* 599 */       this._events != null && 
/* 600 */       postEventsForChanges()) {
/* 601 */       this._events.post(IPayroll.SET_PAYCODE, argPayCode);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setPayCode_noev(String argPayCode) {
/* 608 */     boolean ev_postable = false;
/*     */     
/* 610 */     if ((getDAO_().getPayCode() == null && argPayCode != null) || (
/* 611 */       getDAO_().getPayCode() != null && !getDAO_().getPayCode().equals(argPayCode))) {
/* 612 */       getDAO_().setPayCode(argPayCode);
/* 613 */       ev_postable = true;
/*     */     } 
/*     */     
/* 616 */     return ev_postable;
/*     */   }
/*     */   
/*     */   protected IPayrollProperty newProperty(String argPropertyName) {
/* 620 */     PayrollPropertyId id = new PayrollPropertyId();
/*     */     
/* 622 */     id.setRetailLocId(Long.valueOf(getRetailLocId()));
/* 623 */     id.setPartyId(Long.valueOf(getPartyId()));
/* 624 */     id.setBusinessDate(getBusinessDate());
/* 625 */     id.setPayrollCategory(getPayrollCategory());
/* 626 */     id.setPropertyCode(argPropertyName);
/*     */     
/* 628 */     IPayrollProperty prop = (IPayrollProperty)DataFactory.getInstance().createNewObject((IObjectId)id, IPayrollProperty.class);
/* 629 */     return prop;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @Relationship(name = "Properties")
/*     */   public List<IPayrollProperty> getProperties() {
/* 638 */     if (this._properties == null) {
/* 639 */       this._properties = new HistoricalList(null);
/*     */     }
/* 641 */     return (List<IPayrollProperty>)this._properties;
/*     */   }
/*     */   
/*     */   public void setProperties(List<IPayrollProperty> argProperties) {
/* 645 */     if (this._properties == null) {
/* 646 */       this._properties = new HistoricalList(argProperties);
/*     */     } else {
/* 648 */       this._properties.setCurrentList(argProperties);
/*     */     } 
/*     */     
/* 651 */     for (IPayrollProperty child : this._properties) {
/* 652 */       PayrollPropertyModel model = (PayrollPropertyModel)child;
/* 653 */       model.setRetailLocId_noev(getRetailLocId());
/* 654 */       model.setPartyId_noev(getPartyId());
/* 655 */       model.setOrganizationId_noev(getOrganizationId());
/* 656 */       model.setBusinessDate_noev(getBusinessDate());
/* 657 */       model.setPayrollCategory_noev(getPayrollCategory());
/* 658 */       if (child instanceof IDataModelImpl) {
/* 659 */         IDataAccessObject childDao = ((IDataModelImpl)child).getDAO();
/* 660 */         if (StringUtils.isEmpty(childDao.getOriginDataSource()) && 
/* 661 */           !StringUtils.isEmpty(getDAO().getOriginDataSource())) {
/* 662 */           childDao.setOriginDataSource(getDAO().getOriginDataSource());
/*     */         }
/*     */       } 
/* 665 */       if (postEventsForChanges()) {
/* 666 */         this._eventManager.registerEventHandler((IEventAware)this._eventCascade, (IEventSource)child);
/*     */       }
/*     */     } 
/*     */   }
/*     */   
/*     */   public void addPayrollProperty(IPayrollProperty argPayrollProperty) {
/* 672 */     if (this._properties == null) {
/* 673 */       this._properties = new HistoricalList(null);
/*     */     }
/* 675 */     argPayrollProperty.setRetailLocId(getRetailLocId());
/* 676 */     argPayrollProperty.setPartyId(getPartyId());
/* 677 */     argPayrollProperty.setOrganizationId(getOrganizationId());
/* 678 */     argPayrollProperty.setBusinessDate(getBusinessDate());
/* 679 */     argPayrollProperty.setPayrollCategory(getPayrollCategory());
/* 680 */     if (argPayrollProperty instanceof IDataModelImpl) {
/* 681 */       IDataAccessObject childDao = ((IDataModelImpl)argPayrollProperty).getDAO();
/* 682 */       if (StringUtils.isEmpty(childDao.getOriginDataSource()) && 
/* 683 */         !StringUtils.isEmpty(getDAO().getOriginDataSource())) {
/* 684 */         childDao.setOriginDataSource(getDAO().getOriginDataSource());
/*     */       }
/*     */     } 
/*     */ 
/*     */     
/* 689 */     if (postEventsForChanges()) {
/* 690 */       this._eventManager.registerEventHandler((IEventAware)this._eventCascade, (IEventSource)new EventDescriptor(argPayrollProperty));
/*     */     }
/*     */     
/* 693 */     this._properties.add(argPayrollProperty);
/* 694 */     if (postEventsForChanges()) {
/* 695 */       this._events.post(IPayroll.ADD_PROPERTIES, argPayrollProperty);
/*     */     }
/*     */   }
/*     */   
/*     */   public void removePayrollProperty(IPayrollProperty argPayrollProperty) {
/* 700 */     if (this._properties != null) {
/*     */       
/* 702 */       if (postEventsForChanges()) {
/* 703 */         this._eventManager.deregisterEventHandler((IEventAware)this._eventCascade, (IEventSource)new EventDescriptor(argPayrollProperty));
/*     */       }
/* 705 */       this._properties.remove(argPayrollProperty);
/* 706 */       if (postEventsForChanges()) {
/* 707 */         this._events.post(IPayroll.REMOVE_PROPERTIES, argPayrollProperty);
/*     */       }
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public Object getValue(String argFieldId) {
/* 714 */     if ("Properties".equals(argFieldId)) {
/* 715 */       return getProperties();
/*     */     }
/* 717 */     if ("PayrollExtension".equals(argFieldId)) {
/* 718 */       return this._myExtension;
/*     */     }
/*     */     
/* 721 */     return super.getValue(argFieldId);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void setValue(String argFieldId, Object argValue) {
/* 727 */     if ("Properties".equals(argFieldId)) {
/* 728 */       setProperties(changeToList(argValue, IPayrollProperty.class));
/*     */     }
/* 730 */     else if ("PayrollExtension".equals(argFieldId)) {
/* 731 */       this._myExtension = (IDataModel)argValue;
/*     */     } else {
/*     */       
/* 734 */       super.setValue(argFieldId, argValue);
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public void setDependencies(IPersistenceDefaults argPD, EventManager argEM) {
/* 740 */     this._persistenceDefaults = argPD;
/* 741 */     this._daoImpl.setPersistenceDefaults(argPD);
/* 742 */     this._eventManager = argEM;
/* 743 */     this._events = (Eventor)new ModelEventor((IDataModel)this, argEM);
/* 744 */     this._eventCascade = (EventHandler)new CascadingHandler(this);
/* 745 */     if (this._properties != null) {
/* 746 */       for (IPayrollProperty relationship : this._properties) {
/* 747 */         ((IDataModelImpl)relationship).setDependencies(argPD, argEM);
/*     */       }
/*     */     }
/*     */   }
/*     */   
/*     */   public IDataModel getPayrollExt() {
/* 753 */     return this._myExtension;
/*     */   }
/*     */   
/*     */   public void setPayrollExt(IDataModel argExt) {
/* 757 */     this._myExtension = argExt;
/*     */   }
/*     */ 
/*     */   
/*     */   public void startTransaction() {
/* 762 */     if (this._alreadyInStart) {
/*     */       return;
/*     */     }
/*     */     
/* 766 */     this._alreadyInStart = true;
/*     */ 
/*     */     
/* 769 */     super.startTransaction();
/*     */     
/* 771 */     this._propertiesSavepoint = this._properties;
/* 772 */     if (this._properties != null) {
/* 773 */       this._propertiesSavepoint = new HistoricalList((List)this._properties);
/* 774 */       Iterator<IDataModel> it = this._properties.iterator();
/* 775 */       while (it.hasNext()) {
/* 776 */         ((IDataModel)it.next()).startTransaction();
/*     */       }
/*     */     } 
/*     */ 
/*     */     
/* 781 */     this._alreadyInStart = false;
/*     */   }
/*     */ 
/*     */   
/*     */   public void rollbackChanges() {
/* 786 */     if (isAlreadyRolledBack()) {
/*     */       return;
/*     */     }
/* 789 */     super.rollbackChanges();
/*     */     
/* 791 */     this._properties = this._propertiesSavepoint;
/* 792 */     this._propertiesSavepoint = null;
/* 793 */     if (this._properties != null) {
/* 794 */       Iterator<IDataModel> it = this._properties.iterator();
/* 795 */       while (it.hasNext()) {
/* 796 */         ((IDataModel)it.next()).rollbackChanges();
/*     */       }
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void commitTransaction() {
/* 804 */     if (this._alreadyInCommit) {
/*     */       return;
/*     */     }
/* 807 */     this._alreadyInCommit = true;
/*     */ 
/*     */     
/* 810 */     super.commitTransaction();
/*     */     
/* 812 */     this._propertiesSavepoint = this._properties;
/* 813 */     if (this._properties != null) {
/* 814 */       Iterator<IDataModel> it = this._properties.iterator();
/* 815 */       while (it.hasNext()) {
/* 816 */         ((IDataModel)it.next()).commitTransaction();
/*     */       }
/* 818 */       this._properties = new HistoricalList((List)this._properties);
/*     */     } 
/*     */ 
/*     */     
/* 822 */     this._alreadyInCommit = false;
/*     */   }
/*     */ 
/*     */   
/*     */   private void readObject(ObjectInputStream argStream) throws IOException, ClassNotFoundException {
/* 827 */     argStream.defaultReadObject();
/*     */   }
/*     */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\thr\impl\PayrollModel.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */