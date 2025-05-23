/*     */ package dtv.xst.dao.ttr.impl;
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
/*     */ import dtv.xst.dao.ttr.IIdentityVerification;
/*     */ import dtv.xst.dao.ttr.IIdentityVerificationProperty;
/*     */ import dtv.xst.dao.ttr.ITenderLineItem;
/*     */ import dtv.xst.dao.ttr.IdentityVerificationPropertyId;
/*     */ import java.io.IOException;
/*     */ import java.io.ObjectInputStream;
/*     */ import java.util.Date;
/*     */ import java.util.Iterator;
/*     */ import java.util.List;
/*     */ 
/*     */ public class IdentityVerificationModel extends AbstractDataModelWithPropertyImpl<IIdentityVerificationProperty> implements IIdentityVerification {
/*     */   private static final long serialVersionUID = 1897243161L;
/*     */   private ITenderLineItem _parentLine;
/*     */   private transient boolean _alreadyInStart = false;
/*     */   
/*     */   public String toString() {
/*  35 */     return super.toString() + " Id: " + getObjectId();
/*     */   }
/*     */   private transient boolean _alreadyInCommit = false; private IDataModel _myExtension; private HistoricalList<IIdentityVerificationProperty> _properties; private transient HistoricalList<IIdentityVerificationProperty> _propertiesSavepoint;
/*     */   
/*     */   public void initDAO() {
/*  40 */     setDAO((IDataAccessObject)new IdentityVerificationDAO());
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private IdentityVerificationDAO getDAO_() {
/*  48 */     return (IdentityVerificationDAO)this._daoImpl;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Date getBusinessDate() {
/*  56 */     return getDAO_().getBusinessDate();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setBusinessDate(Date argBusinessDate) {
/*  64 */     if (setBusinessDate_noev(argBusinessDate) && 
/*  65 */       this._events != null && 
/*  66 */       postEventsForChanges()) {
/*  67 */       this._events.post(IIdentityVerification.SET_BUSINESSDATE, argBusinessDate);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setBusinessDate_noev(Date argBusinessDate) {
/*  74 */     boolean ev_postable = false;
/*     */     
/*  76 */     if ((getDAO_().getBusinessDate() == null && argBusinessDate != null) || (
/*  77 */       getDAO_().getBusinessDate() != null && !getDAO_().getBusinessDate().equals(argBusinessDate))) {
/*  78 */       getDAO_().setBusinessDate(argBusinessDate);
/*  79 */       ev_postable = true;
/*  80 */       if (this._properties != null) {
/*     */         
/*  82 */         Iterator<IdentityVerificationPropertyModel> it = this._properties.iterator();
/*  83 */         while (it.hasNext())
/*     */         {
/*  85 */           ((IdentityVerificationPropertyModel)it.next()).setBusinessDate_noev(argBusinessDate);
/*     */         }
/*     */       } 
/*     */     } 
/*     */     
/*  90 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int getIdentityVerificationSequence() {
/*  98 */     if (getDAO_().getIdentityVerificationSequence() != null) {
/*  99 */       return getDAO_().getIdentityVerificationSequence().intValue();
/*     */     }
/*     */     
/* 102 */     return 0;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setIdentityVerificationSequence(int argIdentityVerificationSequence) {
/* 111 */     if (setIdentityVerificationSequence_noev(argIdentityVerificationSequence) && 
/* 112 */       this._events != null && 
/* 113 */       postEventsForChanges()) {
/* 114 */       this._events.post(IIdentityVerification.SET_IDENTITYVERIFICATIONSEQUENCE, Integer.valueOf(argIdentityVerificationSequence));
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setIdentityVerificationSequence_noev(int argIdentityVerificationSequence) {
/* 121 */     boolean ev_postable = false;
/*     */     
/* 123 */     if ((getDAO_().getIdentityVerificationSequence() == null && Integer.valueOf(argIdentityVerificationSequence) != null) || (
/* 124 */       getDAO_().getIdentityVerificationSequence() != null && !getDAO_().getIdentityVerificationSequence().equals(Integer.valueOf(argIdentityVerificationSequence)))) {
/* 125 */       getDAO_().setIdentityVerificationSequence(Integer.valueOf(argIdentityVerificationSequence));
/* 126 */       ev_postable = true;
/* 127 */       if (this._properties != null) {
/*     */         
/* 129 */         Iterator<IdentityVerificationPropertyModel> it = this._properties.iterator();
/* 130 */         while (it.hasNext())
/*     */         {
/* 132 */           ((IdentityVerificationPropertyModel)it.next()).setIdentityVerificationSequence_noev(argIdentityVerificationSequence);
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
/*     */   public long getOrganizationId() {
/* 145 */     if (getDAO_().getOrganizationId() != null) {
/* 146 */       return getDAO_().getOrganizationId().longValue();
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
/*     */   public void setOrganizationId(long argOrganizationId) {
/* 158 */     if (setOrganizationId_noev(argOrganizationId) && 
/* 159 */       this._events != null && 
/* 160 */       postEventsForChanges()) {
/* 161 */       this._events.post(IIdentityVerification.SET_ORGANIZATIONID, Long.valueOf(argOrganizationId));
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setOrganizationId_noev(long argOrganizationId) {
/* 168 */     boolean ev_postable = false;
/*     */     
/* 170 */     if ((getDAO_().getOrganizationId() == null && Long.valueOf(argOrganizationId) != null) || (
/* 171 */       getDAO_().getOrganizationId() != null && !getDAO_().getOrganizationId().equals(Long.valueOf(argOrganizationId)))) {
/* 172 */       getDAO_().setOrganizationId(Long.valueOf(argOrganizationId));
/* 173 */       ev_postable = true;
/* 174 */       if (this._properties != null) {
/*     */         
/* 176 */         Iterator<IdentityVerificationPropertyModel> it = this._properties.iterator();
/* 177 */         while (it.hasNext())
/*     */         {
/* 179 */           ((IdentityVerificationPropertyModel)it.next()).setOrganizationId_noev(argOrganizationId);
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
/*     */   public long getRetailLocationId() {
/* 192 */     if (getDAO_().getRetailLocationId() != null) {
/* 193 */       return getDAO_().getRetailLocationId().longValue();
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
/*     */   public void setRetailLocationId(long argRetailLocationId) {
/* 205 */     if (setRetailLocationId_noev(argRetailLocationId) && 
/* 206 */       this._events != null && 
/* 207 */       postEventsForChanges()) {
/* 208 */       this._events.post(IIdentityVerification.SET_RETAILLOCATIONID, Long.valueOf(argRetailLocationId));
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setRetailLocationId_noev(long argRetailLocationId) {
/* 215 */     boolean ev_postable = false;
/*     */     
/* 217 */     if ((getDAO_().getRetailLocationId() == null && Long.valueOf(argRetailLocationId) != null) || (
/* 218 */       getDAO_().getRetailLocationId() != null && !getDAO_().getRetailLocationId().equals(Long.valueOf(argRetailLocationId)))) {
/* 219 */       getDAO_().setRetailLocationId(Long.valueOf(argRetailLocationId));
/* 220 */       ev_postable = true;
/* 221 */       if (this._properties != null) {
/*     */         
/* 223 */         Iterator<IdentityVerificationPropertyModel> it = this._properties.iterator();
/* 224 */         while (it.hasNext())
/*     */         {
/* 226 */           ((IdentityVerificationPropertyModel)it.next()).setRetailLocationId_noev(argRetailLocationId);
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
/*     */   public int getRetailTransactionLineItemSequence() {
/* 239 */     if (getDAO_().getRetailTransactionLineItemSequence() != null) {
/* 240 */       return getDAO_().getRetailTransactionLineItemSequence().intValue();
/*     */     }
/*     */     
/* 243 */     return 0;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setRetailTransactionLineItemSequence(int argRetailTransactionLineItemSequence) {
/* 252 */     if (setRetailTransactionLineItemSequence_noev(argRetailTransactionLineItemSequence) && 
/* 253 */       this._events != null && 
/* 254 */       postEventsForChanges()) {
/* 255 */       this._events.post(IIdentityVerification.SET_RETAILTRANSACTIONLINEITEMSEQUENCE, Integer.valueOf(argRetailTransactionLineItemSequence));
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setRetailTransactionLineItemSequence_noev(int argRetailTransactionLineItemSequence) {
/* 262 */     boolean ev_postable = false;
/*     */     
/* 264 */     if ((getDAO_().getRetailTransactionLineItemSequence() == null && Integer.valueOf(argRetailTransactionLineItemSequence) != null) || (
/* 265 */       getDAO_().getRetailTransactionLineItemSequence() != null && !getDAO_().getRetailTransactionLineItemSequence().equals(Integer.valueOf(argRetailTransactionLineItemSequence)))) {
/* 266 */       getDAO_().setRetailTransactionLineItemSequence(Integer.valueOf(argRetailTransactionLineItemSequence));
/* 267 */       ev_postable = true;
/* 268 */       if (this._properties != null) {
/*     */         
/* 270 */         Iterator<IdentityVerificationPropertyModel> it = this._properties.iterator();
/* 271 */         while (it.hasNext())
/*     */         {
/* 273 */           ((IdentityVerificationPropertyModel)it.next()).setRetailTransactionLineItemSequence_noev(argRetailTransactionLineItemSequence);
/*     */         }
/*     */       } 
/*     */     } 
/*     */     
/* 278 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public long getTransactionSequence() {
/* 286 */     if (getDAO_().getTransactionSequence() != null) {
/* 287 */       return getDAO_().getTransactionSequence().longValue();
/*     */     }
/*     */     
/* 290 */     return 0L;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setTransactionSequence(long argTransactionSequence) {
/* 299 */     if (setTransactionSequence_noev(argTransactionSequence) && 
/* 300 */       this._events != null && 
/* 301 */       postEventsForChanges()) {
/* 302 */       this._events.post(IIdentityVerification.SET_TRANSACTIONSEQUENCE, Long.valueOf(argTransactionSequence));
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setTransactionSequence_noev(long argTransactionSequence) {
/* 309 */     boolean ev_postable = false;
/*     */     
/* 311 */     if ((getDAO_().getTransactionSequence() == null && Long.valueOf(argTransactionSequence) != null) || (
/* 312 */       getDAO_().getTransactionSequence() != null && !getDAO_().getTransactionSequence().equals(Long.valueOf(argTransactionSequence)))) {
/* 313 */       getDAO_().setTransactionSequence(Long.valueOf(argTransactionSequence));
/* 314 */       ev_postable = true;
/* 315 */       if (this._properties != null) {
/*     */         
/* 317 */         Iterator<IdentityVerificationPropertyModel> it = this._properties.iterator();
/* 318 */         while (it.hasNext())
/*     */         {
/* 320 */           ((IdentityVerificationPropertyModel)it.next()).setTransactionSequence_noev(argTransactionSequence);
/*     */         }
/*     */       } 
/*     */     } 
/*     */     
/* 325 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public long getWorkstationId() {
/* 333 */     if (getDAO_().getWorkstationId() != null) {
/* 334 */       return getDAO_().getWorkstationId().longValue();
/*     */     }
/*     */     
/* 337 */     return 0L;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setWorkstationId(long argWorkstationId) {
/* 346 */     if (setWorkstationId_noev(argWorkstationId) && 
/* 347 */       this._events != null && 
/* 348 */       postEventsForChanges()) {
/* 349 */       this._events.post(IIdentityVerification.SET_WORKSTATIONID, Long.valueOf(argWorkstationId));
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setWorkstationId_noev(long argWorkstationId) {
/* 356 */     boolean ev_postable = false;
/*     */     
/* 358 */     if ((getDAO_().getWorkstationId() == null && Long.valueOf(argWorkstationId) != null) || (
/* 359 */       getDAO_().getWorkstationId() != null && !getDAO_().getWorkstationId().equals(Long.valueOf(argWorkstationId)))) {
/* 360 */       getDAO_().setWorkstationId(Long.valueOf(argWorkstationId));
/* 361 */       ev_postable = true;
/* 362 */       if (this._properties != null) {
/*     */         
/* 364 */         Iterator<IdentityVerificationPropertyModel> it = this._properties.iterator();
/* 365 */         while (it.hasNext())
/*     */         {
/* 367 */           ((IdentityVerificationPropertyModel)it.next()).setWorkstationId_noev(argWorkstationId);
/*     */         }
/*     */       } 
/*     */     } 
/*     */     
/* 372 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Date getCreateDate() {
/* 380 */     return getDAO_().getCreateDate();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setCreateDate(Date argCreateDate) {
/* 388 */     if (setCreateDate_noev(argCreateDate) && 
/* 389 */       this._events != null && 
/* 390 */       postEventsForChanges()) {
/* 391 */       this._events.post(IIdentityVerification.SET_CREATEDATE, argCreateDate);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setCreateDate_noev(Date argCreateDate) {
/* 398 */     boolean ev_postable = false;
/*     */     
/* 400 */     if ((getDAO_().getCreateDate() == null && argCreateDate != null) || (
/* 401 */       getDAO_().getCreateDate() != null && !getDAO_().getCreateDate().equals(argCreateDate))) {
/* 402 */       getDAO_().setCreateDate(argCreateDate);
/* 403 */       ev_postable = true;
/*     */     } 
/*     */     
/* 406 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getCreateUserId() {
/* 414 */     return getDAO_().getCreateUserId();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setCreateUserId(String argCreateUserId) {
/* 422 */     if (setCreateUserId_noev(argCreateUserId) && 
/* 423 */       this._events != null && 
/* 424 */       postEventsForChanges()) {
/* 425 */       this._events.post(IIdentityVerification.SET_CREATEUSERID, argCreateUserId);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setCreateUserId_noev(String argCreateUserId) {
/* 432 */     boolean ev_postable = false;
/*     */     
/* 434 */     if ((getDAO_().getCreateUserId() == null && argCreateUserId != null) || (
/* 435 */       getDAO_().getCreateUserId() != null && !getDAO_().getCreateUserId().equals(argCreateUserId))) {
/* 436 */       getDAO_().setCreateUserId(argCreateUserId);
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
/*     */   public Date getUpdateDate() {
/* 448 */     return getDAO_().getUpdateDate();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setUpdateDate(Date argUpdateDate) {
/* 456 */     if (setUpdateDate_noev(argUpdateDate) && 
/* 457 */       this._events != null && 
/* 458 */       postEventsForChanges()) {
/* 459 */       this._events.post(IIdentityVerification.SET_UPDATEDATE, argUpdateDate);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setUpdateDate_noev(Date argUpdateDate) {
/* 466 */     boolean ev_postable = false;
/*     */     
/* 468 */     if ((getDAO_().getUpdateDate() == null && argUpdateDate != null) || (
/* 469 */       getDAO_().getUpdateDate() != null && !getDAO_().getUpdateDate().equals(argUpdateDate))) {
/* 470 */       getDAO_().setUpdateDate(argUpdateDate);
/* 471 */       ev_postable = true;
/*     */     } 
/*     */     
/* 474 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getUpdateUserId() {
/* 482 */     return getDAO_().getUpdateUserId();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setUpdateUserId(String argUpdateUserId) {
/* 490 */     if (setUpdateUserId_noev(argUpdateUserId) && 
/* 491 */       this._events != null && 
/* 492 */       postEventsForChanges()) {
/* 493 */       this._events.post(IIdentityVerification.SET_UPDATEUSERID, argUpdateUserId);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setUpdateUserId_noev(String argUpdateUserId) {
/* 500 */     boolean ev_postable = false;
/*     */     
/* 502 */     if ((getDAO_().getUpdateUserId() == null && argUpdateUserId != null) || (
/* 503 */       getDAO_().getUpdateUserId() != null && !getDAO_().getUpdateUserId().equals(argUpdateUserId))) {
/* 504 */       getDAO_().setUpdateUserId(argUpdateUserId);
/* 505 */       ev_postable = true;
/*     */     } 
/*     */     
/* 508 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getIdNumber() {
/* 516 */     return getDAO_().getIdNumber();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setIdNumber(String argIdNumber) {
/* 524 */     if (setIdNumber_noev(argIdNumber) && 
/* 525 */       this._events != null && 
/* 526 */       postEventsForChanges()) {
/* 527 */       this._events.post(IIdentityVerification.SET_IDNUMBER, argIdNumber);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setIdNumber_noev(String argIdNumber) {
/* 534 */     boolean ev_postable = false;
/*     */     
/* 536 */     if ((getDAO_().getIdNumber() == null && argIdNumber != null) || (
/* 537 */       getDAO_().getIdNumber() != null && !getDAO_().getIdNumber().equals(argIdNumber))) {
/* 538 */       getDAO_().setIdNumber(argIdNumber);
/* 539 */       ev_postable = true;
/*     */     } 
/*     */     
/* 542 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getIdTypeCode() {
/* 550 */     return getDAO_().getIdTypeCode();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setIdTypeCode(String argIdTypeCode) {
/* 558 */     if (setIdTypeCode_noev(argIdTypeCode) && 
/* 559 */       this._events != null && 
/* 560 */       postEventsForChanges()) {
/* 561 */       this._events.post(IIdentityVerification.SET_IDTYPECODE, argIdTypeCode);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setIdTypeCode_noev(String argIdTypeCode) {
/* 568 */     boolean ev_postable = false;
/*     */     
/* 570 */     if ((getDAO_().getIdTypeCode() == null && argIdTypeCode != null) || (
/* 571 */       getDAO_().getIdTypeCode() != null && !getDAO_().getIdTypeCode().equals(argIdTypeCode))) {
/* 572 */       getDAO_().setIdTypeCode(argIdTypeCode);
/* 573 */       ev_postable = true;
/*     */     } 
/*     */     
/* 576 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getIssuingAuthority() {
/* 584 */     return getDAO_().getIssuingAuthority();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setIssuingAuthority(String argIssuingAuthority) {
/* 592 */     if (setIssuingAuthority_noev(argIssuingAuthority) && 
/* 593 */       this._events != null && 
/* 594 */       postEventsForChanges()) {
/* 595 */       this._events.post(IIdentityVerification.SET_ISSUINGAUTHORITY, argIssuingAuthority);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setIssuingAuthority_noev(String argIssuingAuthority) {
/* 602 */     boolean ev_postable = false;
/*     */     
/* 604 */     if ((getDAO_().getIssuingAuthority() == null && argIssuingAuthority != null) || (
/* 605 */       getDAO_().getIssuingAuthority() != null && !getDAO_().getIssuingAuthority().equals(argIssuingAuthority))) {
/* 606 */       getDAO_().setIssuingAuthority(argIssuingAuthority);
/* 607 */       ev_postable = true;
/*     */     } 
/*     */     
/* 610 */     return ev_postable;
/*     */   }
/*     */   
/*     */   protected IIdentityVerificationProperty newProperty(String argPropertyName) {
/* 614 */     IdentityVerificationPropertyId id = new IdentityVerificationPropertyId();
/*     */     
/* 616 */     id.setBusinessDate(getBusinessDate());
/* 617 */     id.setIdentityVerificationSequence(Integer.valueOf(getIdentityVerificationSequence()));
/* 618 */     id.setRetailLocationId(Long.valueOf(getRetailLocationId()));
/* 619 */     id.setRetailTransactionLineItemSequence(Integer.valueOf(getRetailTransactionLineItemSequence()));
/* 620 */     id.setTransactionSequence(Long.valueOf(getTransactionSequence()));
/* 621 */     id.setWorkstationId(Long.valueOf(getWorkstationId()));
/* 622 */     id.setPropertyCode(argPropertyName);
/*     */     
/* 624 */     IIdentityVerificationProperty prop = (IIdentityVerificationProperty)DataFactory.getInstance().createNewObject((IObjectId)id, IIdentityVerificationProperty.class);
/* 625 */     return prop;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @Relationship(name = "Properties")
/*     */   public List<IIdentityVerificationProperty> getProperties() {
/* 634 */     if (this._properties == null) {
/* 635 */       this._properties = new HistoricalList(null);
/*     */     }
/* 637 */     return (List<IIdentityVerificationProperty>)this._properties;
/*     */   }
/*     */   
/*     */   public void setProperties(List<IIdentityVerificationProperty> argProperties) {
/* 641 */     if (this._properties == null) {
/* 642 */       this._properties = new HistoricalList(argProperties);
/*     */     } else {
/* 644 */       this._properties.setCurrentList(argProperties);
/*     */     } 
/*     */     
/* 647 */     for (IIdentityVerificationProperty child : this._properties) {
/* 648 */       IdentityVerificationPropertyModel model = (IdentityVerificationPropertyModel)child;
/* 649 */       model.setBusinessDate_noev(getBusinessDate());
/* 650 */       model.setIdentityVerificationSequence_noev(getIdentityVerificationSequence());
/* 651 */       model.setOrganizationId_noev(getOrganizationId());
/* 652 */       model.setRetailLocationId_noev(getRetailLocationId());
/* 653 */       model.setRetailTransactionLineItemSequence_noev(getRetailTransactionLineItemSequence());
/* 654 */       model.setTransactionSequence_noev(getTransactionSequence());
/* 655 */       model.setWorkstationId_noev(getWorkstationId());
/* 656 */       if (child instanceof IDataModelImpl) {
/* 657 */         IDataAccessObject childDao = ((IDataModelImpl)child).getDAO();
/* 658 */         if (StringUtils.isEmpty(childDao.getOriginDataSource()) && 
/* 659 */           !StringUtils.isEmpty(getDAO().getOriginDataSource())) {
/* 660 */           childDao.setOriginDataSource(getDAO().getOriginDataSource());
/*     */         }
/*     */       } 
/* 663 */       if (postEventsForChanges()) {
/* 664 */         this._eventManager.registerEventHandler((IEventAware)this._eventCascade, (IEventSource)child);
/*     */       }
/*     */     } 
/*     */   }
/*     */   
/*     */   public void addIdentityVerificationProperty(IIdentityVerificationProperty argIdentityVerificationProperty) {
/* 670 */     if (this._properties == null) {
/* 671 */       this._properties = new HistoricalList(null);
/*     */     }
/* 673 */     argIdentityVerificationProperty.setBusinessDate(getBusinessDate());
/* 674 */     argIdentityVerificationProperty.setIdentityVerificationSequence(getIdentityVerificationSequence());
/* 675 */     argIdentityVerificationProperty.setOrganizationId(getOrganizationId());
/* 676 */     argIdentityVerificationProperty.setRetailLocationId(getRetailLocationId());
/* 677 */     argIdentityVerificationProperty.setRetailTransactionLineItemSequence(getRetailTransactionLineItemSequence());
/* 678 */     argIdentityVerificationProperty.setTransactionSequence(getTransactionSequence());
/* 679 */     argIdentityVerificationProperty.setWorkstationId(getWorkstationId());
/* 680 */     if (argIdentityVerificationProperty instanceof IDataModelImpl) {
/* 681 */       IDataAccessObject childDao = ((IDataModelImpl)argIdentityVerificationProperty).getDAO();
/* 682 */       if (StringUtils.isEmpty(childDao.getOriginDataSource()) && 
/* 683 */         !StringUtils.isEmpty(getDAO().getOriginDataSource())) {
/* 684 */         childDao.setOriginDataSource(getDAO().getOriginDataSource());
/*     */       }
/*     */     } 
/*     */ 
/*     */     
/* 689 */     if (postEventsForChanges()) {
/* 690 */       this._eventManager.registerEventHandler((IEventAware)this._eventCascade, (IEventSource)new EventDescriptor(argIdentityVerificationProperty));
/*     */     }
/*     */     
/* 693 */     this._properties.add(argIdentityVerificationProperty);
/* 694 */     if (postEventsForChanges()) {
/* 695 */       this._events.post(IIdentityVerification.ADD_PROPERTIES, argIdentityVerificationProperty);
/*     */     }
/*     */   }
/*     */   
/*     */   public void removeIdentityVerificationProperty(IIdentityVerificationProperty argIdentityVerificationProperty) {
/* 700 */     if (this._properties != null) {
/*     */       
/* 702 */       if (postEventsForChanges()) {
/* 703 */         this._eventManager.deregisterEventHandler((IEventAware)this._eventCascade, (IEventSource)new EventDescriptor(argIdentityVerificationProperty));
/*     */       }
/* 705 */       this._properties.remove(argIdentityVerificationProperty);
/* 706 */       if (postEventsForChanges()) {
/* 707 */         this._events.post(IIdentityVerification.REMOVE_PROPERTIES, argIdentityVerificationProperty);
/*     */       }
/*     */     } 
/*     */   }
/*     */   
/*     */   public void setParentLine(ITenderLineItem argParentLine) {
/* 713 */     this._parentLine = argParentLine;
/*     */   }
/*     */   
/*     */   public ITenderLineItem getParentLine() {
/* 717 */     return this._parentLine;
/*     */   }
/*     */ 
/*     */   
/*     */   public Object getValue(String argFieldId) {
/* 722 */     if ("Properties".equals(argFieldId)) {
/* 723 */       return getProperties();
/*     */     }
/* 725 */     if ("IdentityVerificationExtension".equals(argFieldId)) {
/* 726 */       return this._myExtension;
/*     */     }
/*     */     
/* 729 */     return super.getValue(argFieldId);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void setValue(String argFieldId, Object argValue) {
/* 735 */     if ("Properties".equals(argFieldId)) {
/* 736 */       setProperties(changeToList(argValue, IIdentityVerificationProperty.class));
/*     */     }
/* 738 */     else if ("IdentityVerificationExtension".equals(argFieldId)) {
/* 739 */       this._myExtension = (IDataModel)argValue;
/*     */     } else {
/*     */       
/* 742 */       super.setValue(argFieldId, argValue);
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public void setDependencies(IPersistenceDefaults argPD, EventManager argEM) {
/* 748 */     this._persistenceDefaults = argPD;
/* 749 */     this._daoImpl.setPersistenceDefaults(argPD);
/* 750 */     this._eventManager = argEM;
/* 751 */     this._events = (Eventor)new ModelEventor((IDataModel)this, argEM);
/* 752 */     this._eventCascade = (EventHandler)new CascadingHandler(this);
/* 753 */     if (this._properties != null) {
/* 754 */       for (IIdentityVerificationProperty relationship : this._properties) {
/* 755 */         ((IDataModelImpl)relationship).setDependencies(argPD, argEM);
/*     */       }
/*     */     }
/*     */   }
/*     */   
/*     */   public IDataModel getIdentityVerificationExt() {
/* 761 */     return this._myExtension;
/*     */   }
/*     */   
/*     */   public void setIdentityVerificationExt(IDataModel argExt) {
/* 765 */     this._myExtension = argExt;
/*     */   }
/*     */ 
/*     */   
/*     */   public void startTransaction() {
/* 770 */     if (this._alreadyInStart) {
/*     */       return;
/*     */     }
/*     */     
/* 774 */     this._alreadyInStart = true;
/*     */ 
/*     */     
/* 777 */     super.startTransaction();
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
/* 799 */     this._properties = this._propertiesSavepoint;
/* 800 */     this._propertiesSavepoint = null;
/* 801 */     if (this._properties != null) {
/* 802 */       Iterator<IDataModel> it = this._properties.iterator();
/* 803 */       while (it.hasNext()) {
/* 804 */         ((IDataModel)it.next()).rollbackChanges();
/*     */       }
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void commitTransaction() {
/* 812 */     if (this._alreadyInCommit) {
/*     */       return;
/*     */     }
/* 815 */     this._alreadyInCommit = true;
/*     */ 
/*     */     
/* 818 */     super.commitTransaction();
/*     */     
/* 820 */     this._propertiesSavepoint = this._properties;
/* 821 */     if (this._properties != null) {
/* 822 */       Iterator<IDataModel> it = this._properties.iterator();
/* 823 */       while (it.hasNext()) {
/* 824 */         ((IDataModel)it.next()).commitTransaction();
/*     */       }
/* 826 */       this._properties = new HistoricalList((List)this._properties);
/*     */     } 
/*     */ 
/*     */     
/* 830 */     this._alreadyInCommit = false;
/*     */   }
/*     */ 
/*     */   
/*     */   private void readObject(ObjectInputStream argStream) throws IOException, ClassNotFoundException {
/* 835 */     argStream.defaultReadObject();
/*     */   }
/*     */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\ttr\impl\IdentityVerificationModel.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */