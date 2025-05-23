/*     */ package dtv.xst.dao.com.impl;
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
/*     */ import dtv.xst.dao.com.IReportLookup;
/*     */ import dtv.xst.dao.com.IReportLookupProperty;
/*     */ import dtv.xst.dao.com.ReportLookupPropertyId;
/*     */ import java.io.IOException;
/*     */ import java.io.ObjectInputStream;
/*     */ import java.util.Date;
/*     */ import java.util.Iterator;
/*     */ import java.util.List;
/*     */ 
/*     */ public class ReportLookupModel extends AbstractDataModelWithPropertyImpl<IReportLookupProperty> implements IReportLookup {
/*     */   private static final long serialVersionUID = 562595822L;
/*     */   private transient boolean _alreadyInStart = false;
/*     */   private transient boolean _alreadyInCommit = false;
/*     */   
/*     */   public String toString() {
/*  33 */     return super.toString() + " Id: " + getObjectId();
/*     */   }
/*     */   private IDataModel _myExtension; private HistoricalList<IReportLookupProperty> _properties; private transient HistoricalList<IReportLookupProperty> _propertiesSavepoint;
/*     */   
/*     */   public void initDAO() {
/*  38 */     setDAO((IDataAccessObject)new ReportLookupDAO());
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private ReportLookupDAO getDAO_() {
/*  46 */     return (ReportLookupDAO)this._daoImpl;
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
/*  70 */       this._events.post(IReportLookup.SET_ORGANIZATIONID, Long.valueOf(argOrganizationId));
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
/*  85 */         Iterator<ReportLookupPropertyModel> it = this._properties.iterator();
/*  86 */         while (it.hasNext())
/*     */         {
/*  88 */           ((ReportLookupPropertyModel)it.next()).setOrganizationId_noev(argOrganizationId);
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
/*     */   public String getOwnerId() {
/* 101 */     return getDAO_().getOwnerId();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setOwnerId(String argOwnerId) {
/* 109 */     if (setOwnerId_noev(argOwnerId) && 
/* 110 */       this._events != null && 
/* 111 */       postEventsForChanges()) {
/* 112 */       this._events.post(IReportLookup.SET_OWNERID, argOwnerId);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setOwnerId_noev(String argOwnerId) {
/* 119 */     boolean ev_postable = false;
/*     */     
/* 121 */     if ((getDAO_().getOwnerId() == null && argOwnerId != null) || (
/* 122 */       getDAO_().getOwnerId() != null && !getDAO_().getOwnerId().equals(argOwnerId))) {
/* 123 */       getDAO_().setOwnerId(argOwnerId);
/* 124 */       ev_postable = true;
/* 125 */       if (this._properties != null) {
/*     */         
/* 127 */         Iterator<ReportLookupPropertyModel> it = this._properties.iterator();
/* 128 */         while (it.hasNext())
/*     */         {
/* 130 */           ((ReportLookupPropertyModel)it.next()).setOwnerId_noev(argOwnerId);
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
/*     */   public String getOwnerType() {
/* 143 */     return getDAO_().getOwnerType();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setOwnerType(String argOwnerType) {
/* 151 */     if (setOwnerType_noev(argOwnerType) && 
/* 152 */       this._events != null && 
/* 153 */       postEventsForChanges()) {
/* 154 */       this._events.post(IReportLookup.SET_OWNERTYPE, argOwnerType);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setOwnerType_noev(String argOwnerType) {
/* 161 */     boolean ev_postable = false;
/*     */     
/* 163 */     if ((getDAO_().getOwnerType() == null && argOwnerType != null) || (
/* 164 */       getDAO_().getOwnerType() != null && !getDAO_().getOwnerType().equals(argOwnerType))) {
/* 165 */       getDAO_().setOwnerType(argOwnerType);
/* 166 */       ev_postable = true;
/* 167 */       if (this._properties != null) {
/*     */         
/* 169 */         Iterator<ReportLookupPropertyModel> it = this._properties.iterator();
/* 170 */         while (it.hasNext())
/*     */         {
/* 172 */           ((ReportLookupPropertyModel)it.next()).setOwnerType_noev(argOwnerType);
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
/*     */   public String getReportId() {
/* 185 */     return getDAO_().getReportId();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setReportId(String argReportId) {
/* 193 */     if (setReportId_noev(argReportId) && 
/* 194 */       this._events != null && 
/* 195 */       postEventsForChanges()) {
/* 196 */       this._events.post(IReportLookup.SET_REPORTID, argReportId);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setReportId_noev(String argReportId) {
/* 203 */     boolean ev_postable = false;
/*     */     
/* 205 */     if ((getDAO_().getReportId() == null && argReportId != null) || (
/* 206 */       getDAO_().getReportId() != null && !getDAO_().getReportId().equals(argReportId))) {
/* 207 */       getDAO_().setReportId(argReportId);
/* 208 */       ev_postable = true;
/* 209 */       if (this._properties != null) {
/*     */         
/* 211 */         Iterator<ReportLookupPropertyModel> it = this._properties.iterator();
/* 212 */         while (it.hasNext())
/*     */         {
/* 214 */           ((ReportLookupPropertyModel)it.next()).setReportId_noev(argReportId);
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
/*     */   public Date getCreateDate() {
/* 227 */     return getDAO_().getCreateDate();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setCreateDate(Date argCreateDate) {
/* 235 */     if (setCreateDate_noev(argCreateDate) && 
/* 236 */       this._events != null && 
/* 237 */       postEventsForChanges()) {
/* 238 */       this._events.post(IReportLookup.SET_CREATEDATE, argCreateDate);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setCreateDate_noev(Date argCreateDate) {
/* 245 */     boolean ev_postable = false;
/*     */     
/* 247 */     if ((getDAO_().getCreateDate() == null && argCreateDate != null) || (
/* 248 */       getDAO_().getCreateDate() != null && !getDAO_().getCreateDate().equals(argCreateDate))) {
/* 249 */       getDAO_().setCreateDate(argCreateDate);
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
/*     */   public String getCreateUserId() {
/* 261 */     return getDAO_().getCreateUserId();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setCreateUserId(String argCreateUserId) {
/* 269 */     if (setCreateUserId_noev(argCreateUserId) && 
/* 270 */       this._events != null && 
/* 271 */       postEventsForChanges()) {
/* 272 */       this._events.post(IReportLookup.SET_CREATEUSERID, argCreateUserId);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setCreateUserId_noev(String argCreateUserId) {
/* 279 */     boolean ev_postable = false;
/*     */     
/* 281 */     if ((getDAO_().getCreateUserId() == null && argCreateUserId != null) || (
/* 282 */       getDAO_().getCreateUserId() != null && !getDAO_().getCreateUserId().equals(argCreateUserId))) {
/* 283 */       getDAO_().setCreateUserId(argCreateUserId);
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
/*     */   public Date getUpdateDate() {
/* 295 */     return getDAO_().getUpdateDate();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setUpdateDate(Date argUpdateDate) {
/* 303 */     if (setUpdateDate_noev(argUpdateDate) && 
/* 304 */       this._events != null && 
/* 305 */       postEventsForChanges()) {
/* 306 */       this._events.post(IReportLookup.SET_UPDATEDATE, argUpdateDate);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setUpdateDate_noev(Date argUpdateDate) {
/* 313 */     boolean ev_postable = false;
/*     */     
/* 315 */     if ((getDAO_().getUpdateDate() == null && argUpdateDate != null) || (
/* 316 */       getDAO_().getUpdateDate() != null && !getDAO_().getUpdateDate().equals(argUpdateDate))) {
/* 317 */       getDAO_().setUpdateDate(argUpdateDate);
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
/*     */   public String getUpdateUserId() {
/* 329 */     return getDAO_().getUpdateUserId();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setUpdateUserId(String argUpdateUserId) {
/* 337 */     if (setUpdateUserId_noev(argUpdateUserId) && 
/* 338 */       this._events != null && 
/* 339 */       postEventsForChanges()) {
/* 340 */       this._events.post(IReportLookup.SET_UPDATEUSERID, argUpdateUserId);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setUpdateUserId_noev(String argUpdateUserId) {
/* 347 */     boolean ev_postable = false;
/*     */     
/* 349 */     if ((getDAO_().getUpdateUserId() == null && argUpdateUserId != null) || (
/* 350 */       getDAO_().getUpdateUserId() != null && !getDAO_().getUpdateUserId().equals(argUpdateUserId))) {
/* 351 */       getDAO_().setUpdateUserId(argUpdateUserId);
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
/*     */   public String getOrgCode() {
/* 363 */     return getDAO_().getOrgCode();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setOrgCode(String argOrgCode) {
/* 371 */     if (setOrgCode_noev(argOrgCode) && 
/* 372 */       this._events != null && 
/* 373 */       postEventsForChanges()) {
/* 374 */       this._events.post(IReportLookup.SET_ORGCODE, argOrgCode);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setOrgCode_noev(String argOrgCode) {
/* 381 */     boolean ev_postable = false;
/*     */     
/* 383 */     if ((getDAO_().getOrgCode() == null && argOrgCode != null) || (
/* 384 */       getDAO_().getOrgCode() != null && !getDAO_().getOrgCode().equals(argOrgCode))) {
/* 385 */       getDAO_().setOrgCode(argOrgCode);
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
/*     */   public String getOrgValue() {
/* 397 */     return getDAO_().getOrgValue();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setOrgValue(String argOrgValue) {
/* 405 */     if (setOrgValue_noev(argOrgValue) && 
/* 406 */       this._events != null && 
/* 407 */       postEventsForChanges()) {
/* 408 */       this._events.post(IReportLookup.SET_ORGVALUE, argOrgValue);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setOrgValue_noev(String argOrgValue) {
/* 415 */     boolean ev_postable = false;
/*     */     
/* 417 */     if ((getDAO_().getOrgValue() == null && argOrgValue != null) || (
/* 418 */       getDAO_().getOrgValue() != null && !getDAO_().getOrgValue().equals(argOrgValue))) {
/* 419 */       getDAO_().setOrgValue(argOrgValue);
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
/*     */   public String getReportUrl() {
/* 431 */     return getDAO_().getReportUrl();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setReportUrl(String argReportUrl) {
/* 439 */     if (setReportUrl_noev(argReportUrl) && 
/* 440 */       this._events != null && 
/* 441 */       postEventsForChanges()) {
/* 442 */       this._events.post(IReportLookup.SET_REPORTURL, argReportUrl);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setReportUrl_noev(String argReportUrl) {
/* 449 */     boolean ev_postable = false;
/*     */     
/* 451 */     if ((getDAO_().getReportUrl() == null && argReportUrl != null) || (
/* 452 */       getDAO_().getReportUrl() != null && !getDAO_().getReportUrl().equals(argReportUrl))) {
/* 453 */       getDAO_().setReportUrl(argReportUrl);
/* 454 */       ev_postable = true;
/*     */     } 
/*     */     
/* 457 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getDescription() {
/* 465 */     return getDAO_().getDescription();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setDescription(String argDescription) {
/* 473 */     if (setDescription_noev(argDescription) && 
/* 474 */       this._events != null && 
/* 475 */       postEventsForChanges()) {
/* 476 */       this._events.post(IReportLookup.SET_DESCRIPTION, argDescription);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setDescription_noev(String argDescription) {
/* 483 */     boolean ev_postable = false;
/*     */     
/* 485 */     if ((getDAO_().getDescription() == null && argDescription != null) || (
/* 486 */       getDAO_().getDescription() != null && !getDAO_().getDescription().equals(argDescription))) {
/* 487 */       getDAO_().setDescription(argDescription);
/* 488 */       ev_postable = true;
/*     */     } 
/*     */     
/* 491 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getRecordType() {
/* 499 */     return getDAO_().getRecordType();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setRecordType(String argRecordType) {
/* 507 */     if (setRecordType_noev(argRecordType) && 
/* 508 */       this._events != null && 
/* 509 */       postEventsForChanges()) {
/* 510 */       this._events.post(IReportLookup.SET_RECORDTYPE, argRecordType);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setRecordType_noev(String argRecordType) {
/* 517 */     boolean ev_postable = false;
/*     */     
/* 519 */     if ((getDAO_().getRecordType() == null && argRecordType != null) || (
/* 520 */       getDAO_().getRecordType() != null && !getDAO_().getRecordType().equals(argRecordType))) {
/* 521 */       getDAO_().setRecordType(argRecordType);
/* 522 */       ev_postable = true;
/*     */     } 
/*     */     
/* 525 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Date getRecordCreationDate() {
/* 533 */     return getDAO_().getRecordCreationDate();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setRecordCreationDate(Date argRecordCreationDate) {
/* 541 */     if (setRecordCreationDate_noev(argRecordCreationDate) && 
/* 542 */       this._events != null && 
/* 543 */       postEventsForChanges()) {
/* 544 */       this._events.post(IReportLookup.SET_RECORDCREATIONDATE, argRecordCreationDate);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setRecordCreationDate_noev(Date argRecordCreationDate) {
/* 551 */     boolean ev_postable = false;
/*     */     
/* 553 */     if ((getDAO_().getRecordCreationDate() == null && argRecordCreationDate != null) || (
/* 554 */       getDAO_().getRecordCreationDate() != null && !getDAO_().getRecordCreationDate().equals(argRecordCreationDate))) {
/* 555 */       getDAO_().setRecordCreationDate(argRecordCreationDate);
/* 556 */       ev_postable = true;
/*     */     } 
/*     */     
/* 559 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getRecordLevel() {
/* 567 */     return getDAO_().getRecordLevel();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setRecordLevel(String argRecordLevel) {
/* 575 */     if (setRecordLevel_noev(argRecordLevel) && 
/* 576 */       this._events != null && 
/* 577 */       postEventsForChanges()) {
/* 578 */       this._events.post(IReportLookup.SET_RECORDLEVEL, argRecordLevel);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setRecordLevel_noev(String argRecordLevel) {
/* 585 */     boolean ev_postable = false;
/*     */     
/* 587 */     if ((getDAO_().getRecordLevel() == null && argRecordLevel != null) || (
/* 588 */       getDAO_().getRecordLevel() != null && !getDAO_().getRecordLevel().equals(argRecordLevel))) {
/* 589 */       getDAO_().setRecordLevel(argRecordLevel);
/* 590 */       ev_postable = true;
/*     */     } 
/*     */     
/* 593 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getParentReportId() {
/* 601 */     return getDAO_().getParentReportId();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setParentReportId(String argParentReportId) {
/* 609 */     if (setParentReportId_noev(argParentReportId) && 
/* 610 */       this._events != null && 
/* 611 */       postEventsForChanges()) {
/* 612 */       this._events.post(IReportLookup.SET_PARENTREPORTID, argParentReportId);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setParentReportId_noev(String argParentReportId) {
/* 619 */     boolean ev_postable = false;
/*     */     
/* 621 */     if ((getDAO_().getParentReportId() == null && argParentReportId != null) || (
/* 622 */       getDAO_().getParentReportId() != null && !getDAO_().getParentReportId().equals(argParentReportId))) {
/* 623 */       getDAO_().setParentReportId(argParentReportId);
/* 624 */       ev_postable = true;
/*     */     } 
/*     */     
/* 627 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean getDelete() {
/* 635 */     if (getDAO_().getDelete() != null) {
/* 636 */       return getDAO_().getDelete().booleanValue();
/*     */     }
/*     */     
/* 639 */     return false;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setDelete(boolean argDelete) {
/* 648 */     if (setDelete_noev(argDelete) && 
/* 649 */       this._events != null && 
/* 650 */       postEventsForChanges()) {
/* 651 */       this._events.post(IReportLookup.SET_DELETE, Boolean.valueOf(argDelete));
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setDelete_noev(boolean argDelete) {
/* 658 */     boolean ev_postable = false;
/*     */     
/* 660 */     if ((getDAO_().getDelete() == null && Boolean.valueOf(argDelete) != null) || (
/* 661 */       getDAO_().getDelete() != null && !getDAO_().getDelete().equals(Boolean.valueOf(argDelete)))) {
/* 662 */       getDAO_().setDelete(Boolean.valueOf(argDelete));
/* 663 */       ev_postable = true;
/*     */     } 
/*     */     
/* 666 */     return ev_postable;
/*     */   }
/*     */   
/*     */   protected IReportLookupProperty newProperty(String argPropertyName) {
/* 670 */     ReportLookupPropertyId id = new ReportLookupPropertyId();
/*     */     
/* 672 */     id.setOwnerId(getOwnerId());
/* 673 */     id.setOwnerType(getOwnerType());
/* 674 */     id.setReportId(getReportId());
/* 675 */     id.setPropertyCode(argPropertyName);
/*     */     
/* 677 */     IReportLookupProperty prop = (IReportLookupProperty)DataFactory.getInstance().createNewObject((IObjectId)id, IReportLookupProperty.class);
/* 678 */     return prop;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @Relationship(name = "Properties")
/*     */   public List<IReportLookupProperty> getProperties() {
/* 687 */     if (this._properties == null) {
/* 688 */       this._properties = new HistoricalList(null);
/*     */     }
/* 690 */     return (List<IReportLookupProperty>)this._properties;
/*     */   }
/*     */   
/*     */   public void setProperties(List<IReportLookupProperty> argProperties) {
/* 694 */     if (this._properties == null) {
/* 695 */       this._properties = new HistoricalList(argProperties);
/*     */     } else {
/* 697 */       this._properties.setCurrentList(argProperties);
/*     */     } 
/*     */     
/* 700 */     for (IReportLookupProperty child : this._properties) {
/* 701 */       ReportLookupPropertyModel model = (ReportLookupPropertyModel)child;
/* 702 */       model.setOrganizationId_noev(getOrganizationId());
/* 703 */       model.setOwnerId_noev(getOwnerId());
/* 704 */       model.setOwnerType_noev(getOwnerType());
/* 705 */       model.setReportId_noev(getReportId());
/* 706 */       if (child instanceof IDataModelImpl) {
/* 707 */         IDataAccessObject childDao = ((IDataModelImpl)child).getDAO();
/* 708 */         if (StringUtils.isEmpty(childDao.getOriginDataSource()) && 
/* 709 */           !StringUtils.isEmpty(getDAO().getOriginDataSource())) {
/* 710 */           childDao.setOriginDataSource(getDAO().getOriginDataSource());
/*     */         }
/*     */       } 
/* 713 */       if (postEventsForChanges()) {
/* 714 */         this._eventManager.registerEventHandler((IEventAware)this._eventCascade, (IEventSource)child);
/*     */       }
/*     */     } 
/*     */   }
/*     */   
/*     */   public void addReportLookupProperty(IReportLookupProperty argReportLookupProperty) {
/* 720 */     if (this._properties == null) {
/* 721 */       this._properties = new HistoricalList(null);
/*     */     }
/* 723 */     argReportLookupProperty.setOrganizationId(getOrganizationId());
/* 724 */     argReportLookupProperty.setOwnerId(getOwnerId());
/* 725 */     argReportLookupProperty.setOwnerType(getOwnerType());
/* 726 */     argReportLookupProperty.setReportId(getReportId());
/* 727 */     if (argReportLookupProperty instanceof IDataModelImpl) {
/* 728 */       IDataAccessObject childDao = ((IDataModelImpl)argReportLookupProperty).getDAO();
/* 729 */       if (StringUtils.isEmpty(childDao.getOriginDataSource()) && 
/* 730 */         !StringUtils.isEmpty(getDAO().getOriginDataSource())) {
/* 731 */         childDao.setOriginDataSource(getDAO().getOriginDataSource());
/*     */       }
/*     */     } 
/*     */ 
/*     */     
/* 736 */     if (postEventsForChanges()) {
/* 737 */       this._eventManager.registerEventHandler((IEventAware)this._eventCascade, (IEventSource)new EventDescriptor(argReportLookupProperty));
/*     */     }
/*     */     
/* 740 */     this._properties.add(argReportLookupProperty);
/* 741 */     if (postEventsForChanges()) {
/* 742 */       this._events.post(IReportLookup.ADD_PROPERTIES, argReportLookupProperty);
/*     */     }
/*     */   }
/*     */   
/*     */   public void removeReportLookupProperty(IReportLookupProperty argReportLookupProperty) {
/* 747 */     if (this._properties != null) {
/*     */       
/* 749 */       if (postEventsForChanges()) {
/* 750 */         this._eventManager.deregisterEventHandler((IEventAware)this._eventCascade, (IEventSource)new EventDescriptor(argReportLookupProperty));
/*     */       }
/* 752 */       this._properties.remove(argReportLookupProperty);
/* 753 */       if (postEventsForChanges()) {
/* 754 */         this._events.post(IReportLookup.REMOVE_PROPERTIES, argReportLookupProperty);
/*     */       }
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public Object getValue(String argFieldId) {
/* 761 */     if ("Properties".equals(argFieldId)) {
/* 762 */       return getProperties();
/*     */     }
/* 764 */     if ("ReportLookupExtension".equals(argFieldId)) {
/* 765 */       return this._myExtension;
/*     */     }
/*     */     
/* 768 */     return super.getValue(argFieldId);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void setValue(String argFieldId, Object argValue) {
/* 774 */     if ("Properties".equals(argFieldId)) {
/* 775 */       setProperties(changeToList(argValue, IReportLookupProperty.class));
/*     */     }
/* 777 */     else if ("ReportLookupExtension".equals(argFieldId)) {
/* 778 */       this._myExtension = (IDataModel)argValue;
/*     */     } else {
/*     */       
/* 781 */       super.setValue(argFieldId, argValue);
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public void setDependencies(IPersistenceDefaults argPD, EventManager argEM) {
/* 787 */     this._persistenceDefaults = argPD;
/* 788 */     this._daoImpl.setPersistenceDefaults(argPD);
/* 789 */     this._eventManager = argEM;
/* 790 */     this._events = (Eventor)new ModelEventor((IDataModel)this, argEM);
/* 791 */     this._eventCascade = (EventHandler)new CascadingHandler(this);
/* 792 */     if (this._properties != null) {
/* 793 */       for (IReportLookupProperty relationship : this._properties) {
/* 794 */         ((IDataModelImpl)relationship).setDependencies(argPD, argEM);
/*     */       }
/*     */     }
/*     */   }
/*     */   
/*     */   public IDataModel getReportLookupExt() {
/* 800 */     return this._myExtension;
/*     */   }
/*     */   
/*     */   public void setReportLookupExt(IDataModel argExt) {
/* 804 */     this._myExtension = argExt;
/*     */   }
/*     */ 
/*     */   
/*     */   public void startTransaction() {
/* 809 */     if (this._alreadyInStart) {
/*     */       return;
/*     */     }
/*     */     
/* 813 */     this._alreadyInStart = true;
/*     */ 
/*     */     
/* 816 */     super.startTransaction();
/*     */     
/* 818 */     this._propertiesSavepoint = this._properties;
/* 819 */     if (this._properties != null) {
/* 820 */       this._propertiesSavepoint = new HistoricalList((List)this._properties);
/* 821 */       Iterator<IDataModel> it = this._properties.iterator();
/* 822 */       while (it.hasNext()) {
/* 823 */         ((IDataModel)it.next()).startTransaction();
/*     */       }
/*     */     } 
/*     */ 
/*     */     
/* 828 */     this._alreadyInStart = false;
/*     */   }
/*     */ 
/*     */   
/*     */   public void rollbackChanges() {
/* 833 */     if (isAlreadyRolledBack()) {
/*     */       return;
/*     */     }
/* 836 */     super.rollbackChanges();
/*     */     
/* 838 */     this._properties = this._propertiesSavepoint;
/* 839 */     this._propertiesSavepoint = null;
/* 840 */     if (this._properties != null) {
/* 841 */       Iterator<IDataModel> it = this._properties.iterator();
/* 842 */       while (it.hasNext()) {
/* 843 */         ((IDataModel)it.next()).rollbackChanges();
/*     */       }
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void commitTransaction() {
/* 851 */     if (this._alreadyInCommit) {
/*     */       return;
/*     */     }
/* 854 */     this._alreadyInCommit = true;
/*     */ 
/*     */     
/* 857 */     super.commitTransaction();
/*     */     
/* 859 */     this._propertiesSavepoint = this._properties;
/* 860 */     if (this._properties != null) {
/* 861 */       Iterator<IDataModel> it = this._properties.iterator();
/* 862 */       while (it.hasNext()) {
/* 863 */         ((IDataModel)it.next()).commitTransaction();
/*     */       }
/* 865 */       this._properties = new HistoricalList((List)this._properties);
/*     */     } 
/*     */ 
/*     */     
/* 869 */     this._alreadyInCommit = false;
/*     */   }
/*     */ 
/*     */   
/*     */   private void readObject(ObjectInputStream argStream) throws IOException, ClassNotFoundException {
/* 874 */     argStream.defaultReadObject();
/*     */   }
/*     */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\com\impl\ReportLookupModel.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */