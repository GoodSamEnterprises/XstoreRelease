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
/*     */ import dtv.xst.dao.itm.IItemRestrictionCalendar;
/*     */ import dtv.xst.dao.itm.IItemRestrictionCalendarProperty;
/*     */ import dtv.xst.dao.itm.ItemRestrictionCalendarPropertyId;
/*     */ import java.io.IOException;
/*     */ import java.io.ObjectInputStream;
/*     */ import java.util.Date;
/*     */ import java.util.Iterator;
/*     */ import java.util.List;
/*     */ 
/*     */ public class ItemRestrictionCalendarModel extends AbstractDataModelWithPropertyImpl<IItemRestrictionCalendarProperty> implements IItemRestrictionCalendar {
/*     */   private static final long serialVersionUID = -1566239497L;
/*     */   private transient boolean _alreadyInStart = false;
/*     */   private transient boolean _alreadyInCommit = false;
/*     */   
/*     */   public String toString() {
/*  33 */     return super.toString() + " Id: " + getObjectId();
/*     */   }
/*     */   private IDataModel _myExtension; private HistoricalList<IItemRestrictionCalendarProperty> _properties; private transient HistoricalList<IItemRestrictionCalendarProperty> _propertiesSavepoint;
/*     */   
/*     */   public void initDAO() {
/*  38 */     setDAO((IDataAccessObject)new ItemRestrictionCalendarDAO());
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private ItemRestrictionCalendarDAO getDAO_() {
/*  46 */     return (ItemRestrictionCalendarDAO)this._daoImpl;
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
/*  70 */       this._events.post(IItemRestrictionCalendar.SET_ORGANIZATIONID, Long.valueOf(argOrganizationId));
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
/*  85 */         Iterator<ItemRestrictionCalendarPropertyModel> it = this._properties.iterator();
/*  86 */         while (it.hasNext())
/*     */         {
/*  88 */           ((ItemRestrictionCalendarPropertyModel)it.next()).setOrganizationId_noev(argOrganizationId);
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
/*     */   public String getRestrictionCategory() {
/* 101 */     return getDAO_().getRestrictionCategory();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setRestrictionCategory(String argRestrictionCategory) {
/* 109 */     if (setRestrictionCategory_noev(argRestrictionCategory) && 
/* 110 */       this._events != null && 
/* 111 */       postEventsForChanges()) {
/* 112 */       this._events.post(IItemRestrictionCalendar.SET_RESTRICTIONCATEGORY, argRestrictionCategory);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setRestrictionCategory_noev(String argRestrictionCategory) {
/* 119 */     boolean ev_postable = false;
/*     */     
/* 121 */     if ((getDAO_().getRestrictionCategory() == null && argRestrictionCategory != null) || (
/* 122 */       getDAO_().getRestrictionCategory() != null && !getDAO_().getRestrictionCategory().equals(argRestrictionCategory))) {
/* 123 */       getDAO_().setRestrictionCategory(argRestrictionCategory);
/* 124 */       ev_postable = true;
/* 125 */       if (this._properties != null) {
/*     */         
/* 127 */         Iterator<ItemRestrictionCalendarPropertyModel> it = this._properties.iterator();
/* 128 */         while (it.hasNext())
/*     */         {
/* 130 */           ((ItemRestrictionCalendarPropertyModel)it.next()).setRestrictionCategory_noev(argRestrictionCategory);
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
/*     */   public String getRestrictionCode() {
/* 143 */     return getDAO_().getRestrictionCode();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setRestrictionCode(String argRestrictionCode) {
/* 151 */     if (setRestrictionCode_noev(argRestrictionCode) && 
/* 152 */       this._events != null && 
/* 153 */       postEventsForChanges()) {
/* 154 */       this._events.post(IItemRestrictionCalendar.SET_RESTRICTIONCODE, argRestrictionCode);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setRestrictionCode_noev(String argRestrictionCode) {
/* 161 */     boolean ev_postable = false;
/*     */     
/* 163 */     if ((getDAO_().getRestrictionCode() == null && argRestrictionCode != null) || (
/* 164 */       getDAO_().getRestrictionCode() != null && !getDAO_().getRestrictionCode().equals(argRestrictionCode))) {
/* 165 */       getDAO_().setRestrictionCode(argRestrictionCode);
/* 166 */       ev_postable = true;
/* 167 */       if (this._properties != null) {
/*     */         
/* 169 */         Iterator<ItemRestrictionCalendarPropertyModel> it = this._properties.iterator();
/* 170 */         while (it.hasNext())
/*     */         {
/* 172 */           ((ItemRestrictionCalendarPropertyModel)it.next()).setRestrictionCode_noev(argRestrictionCode);
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
/*     */   public String getDayCode() {
/* 185 */     return getDAO_().getDayCode();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setDayCode(String argDayCode) {
/* 193 */     if (setDayCode_noev(argDayCode) && 
/* 194 */       this._events != null && 
/* 195 */       postEventsForChanges()) {
/* 196 */       this._events.post(IItemRestrictionCalendar.SET_DAYCODE, argDayCode);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setDayCode_noev(String argDayCode) {
/* 203 */     boolean ev_postable = false;
/*     */     
/* 205 */     if ((getDAO_().getDayCode() == null && argDayCode != null) || (
/* 206 */       getDAO_().getDayCode() != null && !getDAO_().getDayCode().equals(argDayCode))) {
/* 207 */       getDAO_().setDayCode(argDayCode);
/* 208 */       ev_postable = true;
/* 209 */       if (this._properties != null) {
/*     */         
/* 211 */         Iterator<ItemRestrictionCalendarPropertyModel> it = this._properties.iterator();
/* 212 */         while (it.hasNext())
/*     */         {
/* 214 */           ((ItemRestrictionCalendarPropertyModel)it.next()).setDayCode_noev(argDayCode);
/*     */         }
/*     */       } 
/*     */     } 
/*     */     
/* 219 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Date getEffectiveDate() {
/* 227 */     return getDAO_().getEffectiveDate();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setEffectiveDate(Date argEffectiveDate) {
/* 235 */     if (setEffectiveDate_noev(argEffectiveDate) && 
/* 236 */       this._events != null && 
/* 237 */       postEventsForChanges()) {
/* 238 */       this._events.post(IItemRestrictionCalendar.SET_EFFECTIVEDATE, argEffectiveDate);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setEffectiveDate_noev(Date argEffectiveDate) {
/* 245 */     boolean ev_postable = false;
/*     */     
/* 247 */     if ((getDAO_().getEffectiveDate() == null && argEffectiveDate != null) || (
/* 248 */       getDAO_().getEffectiveDate() != null && !getDAO_().getEffectiveDate().equals(argEffectiveDate))) {
/* 249 */       getDAO_().setEffectiveDate(argEffectiveDate);
/* 250 */       ev_postable = true;
/* 251 */       if (this._properties != null) {
/*     */         
/* 253 */         Iterator<ItemRestrictionCalendarPropertyModel> it = this._properties.iterator();
/* 254 */         while (it.hasNext())
/*     */         {
/* 256 */           ((ItemRestrictionCalendarPropertyModel)it.next()).setEffectiveDate_noev(argEffectiveDate);
/*     */         }
/*     */       } 
/*     */     } 
/*     */     
/* 261 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Date getStartTime() {
/* 269 */     return getDAO_().getStartTime();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setStartTime(Date argStartTime) {
/* 277 */     if (setStartTime_noev(argStartTime) && 
/* 278 */       this._events != null && 
/* 279 */       postEventsForChanges()) {
/* 280 */       this._events.post(IItemRestrictionCalendar.SET_STARTTIME, argStartTime);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setStartTime_noev(Date argStartTime) {
/* 287 */     boolean ev_postable = false;
/*     */     
/* 289 */     if ((getDAO_().getStartTime() == null && argStartTime != null) || (
/* 290 */       getDAO_().getStartTime() != null && !getDAO_().getStartTime().equals(argStartTime))) {
/* 291 */       getDAO_().setStartTime(argStartTime);
/* 292 */       ev_postable = true;
/* 293 */       if (this._properties != null) {
/*     */         
/* 295 */         Iterator<ItemRestrictionCalendarPropertyModel> it = this._properties.iterator();
/* 296 */         while (it.hasNext())
/*     */         {
/* 298 */           ((ItemRestrictionCalendarPropertyModel)it.next()).setStartTime_noev(argStartTime);
/*     */         }
/*     */       } 
/*     */     } 
/*     */     
/* 303 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getSaleLineItemTypeCode() {
/* 311 */     return getDAO_().getSaleLineItemTypeCode();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setSaleLineItemTypeCode(String argSaleLineItemTypeCode) {
/* 319 */     if (setSaleLineItemTypeCode_noev(argSaleLineItemTypeCode) && 
/* 320 */       this._events != null && 
/* 321 */       postEventsForChanges()) {
/* 322 */       this._events.post(IItemRestrictionCalendar.SET_SALELINEITEMTYPECODE, argSaleLineItemTypeCode);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setSaleLineItemTypeCode_noev(String argSaleLineItemTypeCode) {
/* 329 */     boolean ev_postable = false;
/*     */     
/* 331 */     if ((getDAO_().getSaleLineItemTypeCode() == null && argSaleLineItemTypeCode != null) || (
/* 332 */       getDAO_().getSaleLineItemTypeCode() != null && !getDAO_().getSaleLineItemTypeCode().equals(argSaleLineItemTypeCode))) {
/* 333 */       getDAO_().setSaleLineItemTypeCode(argSaleLineItemTypeCode);
/* 334 */       ev_postable = true;
/* 335 */       if (this._properties != null) {
/*     */         
/* 337 */         Iterator<ItemRestrictionCalendarPropertyModel> it = this._properties.iterator();
/* 338 */         while (it.hasNext())
/*     */         {
/* 340 */           ((ItemRestrictionCalendarPropertyModel)it.next()).setSaleLineItemTypeCode_noev(argSaleLineItemTypeCode);
/*     */         }
/*     */       } 
/*     */     } 
/*     */     
/* 345 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getOrgCode() {
/* 353 */     return getDAO_().getOrgCode();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setOrgCode(String argOrgCode) {
/* 361 */     if (setOrgCode_noev(argOrgCode) && 
/* 362 */       this._events != null && 
/* 363 */       postEventsForChanges()) {
/* 364 */       this._events.post(IItemRestrictionCalendar.SET_ORGCODE, argOrgCode);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setOrgCode_noev(String argOrgCode) {
/* 371 */     boolean ev_postable = false;
/*     */     
/* 373 */     if ((getDAO_().getOrgCode() == null && argOrgCode != null) || (
/* 374 */       getDAO_().getOrgCode() != null && !getDAO_().getOrgCode().equals(argOrgCode))) {
/* 375 */       getDAO_().setOrgCode(argOrgCode);
/* 376 */       ev_postable = true;
/*     */     } 
/*     */     
/* 379 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getOrgValue() {
/* 387 */     return getDAO_().getOrgValue();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setOrgValue(String argOrgValue) {
/* 395 */     if (setOrgValue_noev(argOrgValue) && 
/* 396 */       this._events != null && 
/* 397 */       postEventsForChanges()) {
/* 398 */       this._events.post(IItemRestrictionCalendar.SET_ORGVALUE, argOrgValue);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setOrgValue_noev(String argOrgValue) {
/* 405 */     boolean ev_postable = false;
/*     */     
/* 407 */     if ((getDAO_().getOrgValue() == null && argOrgValue != null) || (
/* 408 */       getDAO_().getOrgValue() != null && !getDAO_().getOrgValue().equals(argOrgValue))) {
/* 409 */       getDAO_().setOrgValue(argOrgValue);
/* 410 */       ev_postable = true;
/*     */     } 
/*     */     
/* 413 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Date getCreateDate() {
/* 421 */     return getDAO_().getCreateDate();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setCreateDate(Date argCreateDate) {
/* 429 */     if (setCreateDate_noev(argCreateDate) && 
/* 430 */       this._events != null && 
/* 431 */       postEventsForChanges()) {
/* 432 */       this._events.post(IItemRestrictionCalendar.SET_CREATEDATE, argCreateDate);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setCreateDate_noev(Date argCreateDate) {
/* 439 */     boolean ev_postable = false;
/*     */     
/* 441 */     if ((getDAO_().getCreateDate() == null && argCreateDate != null) || (
/* 442 */       getDAO_().getCreateDate() != null && !getDAO_().getCreateDate().equals(argCreateDate))) {
/* 443 */       getDAO_().setCreateDate(argCreateDate);
/* 444 */       ev_postable = true;
/*     */     } 
/*     */     
/* 447 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getCreateUserId() {
/* 455 */     return getDAO_().getCreateUserId();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setCreateUserId(String argCreateUserId) {
/* 463 */     if (setCreateUserId_noev(argCreateUserId) && 
/* 464 */       this._events != null && 
/* 465 */       postEventsForChanges()) {
/* 466 */       this._events.post(IItemRestrictionCalendar.SET_CREATEUSERID, argCreateUserId);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setCreateUserId_noev(String argCreateUserId) {
/* 473 */     boolean ev_postable = false;
/*     */     
/* 475 */     if ((getDAO_().getCreateUserId() == null && argCreateUserId != null) || (
/* 476 */       getDAO_().getCreateUserId() != null && !getDAO_().getCreateUserId().equals(argCreateUserId))) {
/* 477 */       getDAO_().setCreateUserId(argCreateUserId);
/* 478 */       ev_postable = true;
/*     */     } 
/*     */     
/* 481 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Date getUpdateDate() {
/* 489 */     return getDAO_().getUpdateDate();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setUpdateDate(Date argUpdateDate) {
/* 497 */     if (setUpdateDate_noev(argUpdateDate) && 
/* 498 */       this._events != null && 
/* 499 */       postEventsForChanges()) {
/* 500 */       this._events.post(IItemRestrictionCalendar.SET_UPDATEDATE, argUpdateDate);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setUpdateDate_noev(Date argUpdateDate) {
/* 507 */     boolean ev_postable = false;
/*     */     
/* 509 */     if ((getDAO_().getUpdateDate() == null && argUpdateDate != null) || (
/* 510 */       getDAO_().getUpdateDate() != null && !getDAO_().getUpdateDate().equals(argUpdateDate))) {
/* 511 */       getDAO_().setUpdateDate(argUpdateDate);
/* 512 */       ev_postable = true;
/*     */     } 
/*     */     
/* 515 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getUpdateUserId() {
/* 523 */     return getDAO_().getUpdateUserId();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setUpdateUserId(String argUpdateUserId) {
/* 531 */     if (setUpdateUserId_noev(argUpdateUserId) && 
/* 532 */       this._events != null && 
/* 533 */       postEventsForChanges()) {
/* 534 */       this._events.post(IItemRestrictionCalendar.SET_UPDATEUSERID, argUpdateUserId);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setUpdateUserId_noev(String argUpdateUserId) {
/* 541 */     boolean ev_postable = false;
/*     */     
/* 543 */     if ((getDAO_().getUpdateUserId() == null && argUpdateUserId != null) || (
/* 544 */       getDAO_().getUpdateUserId() != null && !getDAO_().getUpdateUserId().equals(argUpdateUserId))) {
/* 545 */       getDAO_().setUpdateUserId(argUpdateUserId);
/* 546 */       ev_postable = true;
/*     */     } 
/*     */     
/* 549 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Date getExpirationDate() {
/* 557 */     return getDAO_().getExpirationDate();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setExpirationDate(Date argExpirationDate) {
/* 565 */     if (setExpirationDate_noev(argExpirationDate) && 
/* 566 */       this._events != null && 
/* 567 */       postEventsForChanges()) {
/* 568 */       this._events.post(IItemRestrictionCalendar.SET_EXPIRATIONDATE, argExpirationDate);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setExpirationDate_noev(Date argExpirationDate) {
/* 575 */     boolean ev_postable = false;
/*     */     
/* 577 */     if ((getDAO_().getExpirationDate() == null && argExpirationDate != null) || (
/* 578 */       getDAO_().getExpirationDate() != null && !getDAO_().getExpirationDate().equals(argExpirationDate))) {
/* 579 */       getDAO_().setExpirationDate(argExpirationDate);
/* 580 */       ev_postable = true;
/*     */     } 
/*     */     
/* 583 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Date getEndTime() {
/* 591 */     return getDAO_().getEndTime();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setEndTime(Date argEndTime) {
/* 599 */     if (setEndTime_noev(argEndTime) && 
/* 600 */       this._events != null && 
/* 601 */       postEventsForChanges()) {
/* 602 */       this._events.post(IItemRestrictionCalendar.SET_ENDTIME, argEndTime);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setEndTime_noev(Date argEndTime) {
/* 609 */     boolean ev_postable = false;
/*     */     
/* 611 */     if ((getDAO_().getEndTime() == null && argEndTime != null) || (
/* 612 */       getDAO_().getEndTime() != null && !getDAO_().getEndTime().equals(argEndTime))) {
/* 613 */       getDAO_().setEndTime(argEndTime);
/* 614 */       ev_postable = true;
/*     */     } 
/*     */     
/* 617 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean getExemption() {
/* 625 */     if (getDAO_().getExemption() != null) {
/* 626 */       return getDAO_().getExemption().booleanValue();
/*     */     }
/*     */     
/* 629 */     return false;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setExemption(boolean argExemption) {
/* 638 */     if (setExemption_noev(argExemption) && 
/* 639 */       this._events != null && 
/* 640 */       postEventsForChanges()) {
/* 641 */       this._events.post(IItemRestrictionCalendar.SET_EXEMPTION, Boolean.valueOf(argExemption));
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setExemption_noev(boolean argExemption) {
/* 648 */     boolean ev_postable = false;
/*     */     
/* 650 */     if ((getDAO_().getExemption() == null && Boolean.valueOf(argExemption) != null) || (
/* 651 */       getDAO_().getExemption() != null && !getDAO_().getExemption().equals(Boolean.valueOf(argExemption)))) {
/* 652 */       getDAO_().setExemption(Boolean.valueOf(argExemption));
/* 653 */       ev_postable = true;
/*     */     } 
/*     */     
/* 656 */     return ev_postable;
/*     */   }
/*     */   
/*     */   protected IItemRestrictionCalendarProperty newProperty(String argPropertyName) {
/* 660 */     ItemRestrictionCalendarPropertyId id = new ItemRestrictionCalendarPropertyId();
/*     */     
/* 662 */     id.setRestrictionCategory(getRestrictionCategory());
/* 663 */     id.setRestrictionCode(getRestrictionCode());
/* 664 */     id.setDayCode(getDayCode());
/* 665 */     id.setEffectiveDate(getEffectiveDate());
/* 666 */     id.setStartTime(getStartTime());
/* 667 */     id.setSaleLineItemTypeCode(getSaleLineItemTypeCode());
/* 668 */     id.setPropertyCode(argPropertyName);
/*     */     
/* 670 */     IItemRestrictionCalendarProperty prop = (IItemRestrictionCalendarProperty)DataFactory.getInstance().createNewObject((IObjectId)id, IItemRestrictionCalendarProperty.class);
/* 671 */     return prop;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @Relationship(name = "Properties")
/*     */   public List<IItemRestrictionCalendarProperty> getProperties() {
/* 680 */     if (this._properties == null) {
/* 681 */       this._properties = new HistoricalList(null);
/*     */     }
/* 683 */     return (List<IItemRestrictionCalendarProperty>)this._properties;
/*     */   }
/*     */   
/*     */   public void setProperties(List<IItemRestrictionCalendarProperty> argProperties) {
/* 687 */     if (this._properties == null) {
/* 688 */       this._properties = new HistoricalList(argProperties);
/*     */     } else {
/* 690 */       this._properties.setCurrentList(argProperties);
/*     */     } 
/*     */     
/* 693 */     for (IItemRestrictionCalendarProperty child : this._properties) {
/* 694 */       ItemRestrictionCalendarPropertyModel model = (ItemRestrictionCalendarPropertyModel)child;
/* 695 */       model.setOrganizationId_noev(getOrganizationId());
/* 696 */       model.setRestrictionCategory_noev(getRestrictionCategory());
/* 697 */       model.setRestrictionCode_noev(getRestrictionCode());
/* 698 */       model.setDayCode_noev(getDayCode());
/* 699 */       model.setEffectiveDate_noev(getEffectiveDate());
/* 700 */       model.setStartTime_noev(getStartTime());
/* 701 */       model.setSaleLineItemTypeCode_noev(getSaleLineItemTypeCode());
/* 702 */       if (child instanceof IDataModelImpl) {
/* 703 */         IDataAccessObject childDao = ((IDataModelImpl)child).getDAO();
/* 704 */         if (StringUtils.isEmpty(childDao.getOriginDataSource()) && 
/* 705 */           !StringUtils.isEmpty(getDAO().getOriginDataSource())) {
/* 706 */           childDao.setOriginDataSource(getDAO().getOriginDataSource());
/*     */         }
/*     */       } 
/* 709 */       if (postEventsForChanges()) {
/* 710 */         this._eventManager.registerEventHandler((IEventAware)this._eventCascade, (IEventSource)child);
/*     */       }
/*     */     } 
/*     */   }
/*     */   
/*     */   public void addItemRestrictionCalendarProperty(IItemRestrictionCalendarProperty argItemRestrictionCalendarProperty) {
/* 716 */     if (this._properties == null) {
/* 717 */       this._properties = new HistoricalList(null);
/*     */     }
/* 719 */     argItemRestrictionCalendarProperty.setOrganizationId(getOrganizationId());
/* 720 */     argItemRestrictionCalendarProperty.setRestrictionCategory(getRestrictionCategory());
/* 721 */     argItemRestrictionCalendarProperty.setRestrictionCode(getRestrictionCode());
/* 722 */     argItemRestrictionCalendarProperty.setDayCode(getDayCode());
/* 723 */     argItemRestrictionCalendarProperty.setEffectiveDate(getEffectiveDate());
/* 724 */     argItemRestrictionCalendarProperty.setStartTime(getStartTime());
/* 725 */     argItemRestrictionCalendarProperty.setSaleLineItemTypeCode(getSaleLineItemTypeCode());
/* 726 */     if (argItemRestrictionCalendarProperty instanceof IDataModelImpl) {
/* 727 */       IDataAccessObject childDao = ((IDataModelImpl)argItemRestrictionCalendarProperty).getDAO();
/* 728 */       if (StringUtils.isEmpty(childDao.getOriginDataSource()) && 
/* 729 */         !StringUtils.isEmpty(getDAO().getOriginDataSource())) {
/* 730 */         childDao.setOriginDataSource(getDAO().getOriginDataSource());
/*     */       }
/*     */     } 
/*     */ 
/*     */     
/* 735 */     if (postEventsForChanges()) {
/* 736 */       this._eventManager.registerEventHandler((IEventAware)this._eventCascade, (IEventSource)new EventDescriptor(argItemRestrictionCalendarProperty));
/*     */     }
/*     */     
/* 739 */     this._properties.add(argItemRestrictionCalendarProperty);
/* 740 */     if (postEventsForChanges()) {
/* 741 */       this._events.post(IItemRestrictionCalendar.ADD_PROPERTIES, argItemRestrictionCalendarProperty);
/*     */     }
/*     */   }
/*     */   
/*     */   public void removeItemRestrictionCalendarProperty(IItemRestrictionCalendarProperty argItemRestrictionCalendarProperty) {
/* 746 */     if (this._properties != null) {
/*     */       
/* 748 */       if (postEventsForChanges()) {
/* 749 */         this._eventManager.deregisterEventHandler((IEventAware)this._eventCascade, (IEventSource)new EventDescriptor(argItemRestrictionCalendarProperty));
/*     */       }
/* 751 */       this._properties.remove(argItemRestrictionCalendarProperty);
/* 752 */       if (postEventsForChanges()) {
/* 753 */         this._events.post(IItemRestrictionCalendar.REMOVE_PROPERTIES, argItemRestrictionCalendarProperty);
/*     */       }
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public Object getValue(String argFieldId) {
/* 760 */     if ("Properties".equals(argFieldId)) {
/* 761 */       return getProperties();
/*     */     }
/* 763 */     if ("ItemRestrictionCalendarExtension".equals(argFieldId)) {
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
/* 774 */       setProperties(changeToList(argValue, IItemRestrictionCalendarProperty.class));
/*     */     }
/* 776 */     else if ("ItemRestrictionCalendarExtension".equals(argFieldId)) {
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
/* 792 */       for (IItemRestrictionCalendarProperty relationship : this._properties) {
/* 793 */         ((IDataModelImpl)relationship).setDependencies(argPD, argEM);
/*     */       }
/*     */     }
/*     */   }
/*     */   
/*     */   public IDataModel getItemRestrictionCalendarExt() {
/* 799 */     return this._myExtension;
/*     */   }
/*     */   
/*     */   public void setItemRestrictionCalendarExt(IDataModel argExt) {
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
/*     */ 
/*     */   
/*     */   private void readObject(ObjectInputStream argStream) throws IOException, ClassNotFoundException {
/* 873 */     argStream.defaultReadObject();
/*     */   }
/*     */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\itm\impl\ItemRestrictionCalendarModel.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */