/*     */ package dtv.xst.dao.xom.impl;
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
/*     */ import dtv.util.address.IAddress;
/*     */ import dtv.util.address.IMutableAddress;
/*     */ import dtv.xst.dao.xom.FulfillmentModifierPropertyId;
/*     */ import dtv.xst.dao.xom.IAddressModifier;
/*     */ import dtv.xst.dao.xom.IFulfillmentModifier;
/*     */ import dtv.xst.dao.xom.IFulfillmentModifierProperty;
/*     */ import dtv.xst.dao.xom.IOrderLine;
/*     */ import java.io.ObjectInputStream;
/*     */ import java.util.Date;
/*     */ import java.util.Iterator;
/*     */ import java.util.List;
/*     */ 
/*     */ public class FulfillmentModifierModel extends AbstractDataModelWithPropertyImpl<IFulfillmentModifierProperty> implements IFulfillmentModifier {
/*     */   private static final long serialVersionUID = -914701643L;
/*     */   private IOrderLine _parentLine;
/*     */   private transient boolean _alreadyInStart = false;
/*     */   private transient boolean _alreadyInCommit = false;
/*     */   
/*     */   public String toString() {
/*  36 */     return super.toString() + " Id: " + getObjectId();
/*     */   }
/*     */   private IDataModel _myExtension; private IAddressModifier _address; private transient IAddressModifier _addressSavepoint; private HistoricalList<IFulfillmentModifierProperty> _properties; private transient HistoricalList<IFulfillmentModifierProperty> _propertiesSavepoint;
/*     */   
/*     */   public void initDAO() {
/*  41 */     setDAO((IDataAccessObject)new FulfillmentModifierDAO());
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private FulfillmentModifierDAO getDAO_() {
/*  49 */     return (FulfillmentModifierDAO)this._daoImpl;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public long getOrganizationId() {
/*  57 */     if (getDAO_().getOrganizationId() != null) {
/*  58 */       return getDAO_().getOrganizationId().longValue();
/*     */     }
/*     */     
/*  61 */     return 0L;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setOrganizationId(long argOrganizationId) {
/*  70 */     if (setOrganizationId_noev(argOrganizationId) && 
/*  71 */       this._events != null && 
/*  72 */       postEventsForChanges()) {
/*  73 */       this._events.post(IFulfillmentModifier.SET_ORGANIZATIONID, Long.valueOf(argOrganizationId));
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setOrganizationId_noev(long argOrganizationId) {
/*  80 */     boolean ev_postable = false;
/*     */     
/*  82 */     if ((getDAO_().getOrganizationId() == null && Long.valueOf(argOrganizationId) != null) || (
/*  83 */       getDAO_().getOrganizationId() != null && !getDAO_().getOrganizationId().equals(Long.valueOf(argOrganizationId)))) {
/*  84 */       getDAO_().setOrganizationId(Long.valueOf(argOrganizationId));
/*  85 */       ev_postable = true;
/*  86 */       if (this._properties != null) {
/*     */         
/*  88 */         Iterator<FulfillmentModifierPropertyModel> it = this._properties.iterator();
/*  89 */         while (it.hasNext())
/*     */         {
/*  91 */           ((FulfillmentModifierPropertyModel)it.next()).setOrganizationId_noev(argOrganizationId);
/*     */         }
/*     */       } 
/*     */     } 
/*     */     
/*  96 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getOrderId() {
/* 104 */     return getDAO_().getOrderId();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setOrderId(String argOrderId) {
/* 112 */     if (setOrderId_noev(argOrderId) && 
/* 113 */       this._events != null && 
/* 114 */       postEventsForChanges()) {
/* 115 */       this._events.post(IFulfillmentModifier.SET_ORDERID, argOrderId);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setOrderId_noev(String argOrderId) {
/* 122 */     boolean ev_postable = false;
/*     */     
/* 124 */     if ((getDAO_().getOrderId() == null && argOrderId != null) || (
/* 125 */       getDAO_().getOrderId() != null && !getDAO_().getOrderId().equals(argOrderId))) {
/* 126 */       getDAO_().setOrderId(argOrderId);
/* 127 */       ev_postable = true;
/* 128 */       if (this._properties != null) {
/*     */         
/* 130 */         Iterator<FulfillmentModifierPropertyModel> it = this._properties.iterator();
/* 131 */         while (it.hasNext())
/*     */         {
/* 133 */           ((FulfillmentModifierPropertyModel)it.next()).setOrderId_noev(argOrderId);
/*     */         }
/*     */       } 
/*     */     } 
/*     */     
/* 138 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int getSequence() {
/* 146 */     if (getDAO_().getSequence() != null) {
/* 147 */       return getDAO_().getSequence().intValue();
/*     */     }
/*     */     
/* 150 */     return 0;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setSequence(int argSequence) {
/* 159 */     if (setSequence_noev(argSequence) && 
/* 160 */       this._events != null && 
/* 161 */       postEventsForChanges()) {
/* 162 */       this._events.post(IFulfillmentModifier.SET_SEQUENCE, Integer.valueOf(argSequence));
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setSequence_noev(int argSequence) {
/* 169 */     boolean ev_postable = false;
/*     */     
/* 171 */     if ((getDAO_().getSequence() == null && Integer.valueOf(argSequence) != null) || (
/* 172 */       getDAO_().getSequence() != null && !getDAO_().getSequence().equals(Integer.valueOf(argSequence)))) {
/* 173 */       getDAO_().setSequence(Integer.valueOf(argSequence));
/* 174 */       ev_postable = true;
/* 175 */       if (this._properties != null) {
/*     */         
/* 177 */         Iterator<FulfillmentModifierPropertyModel> it = this._properties.iterator();
/* 178 */         while (it.hasNext())
/*     */         {
/* 180 */           ((FulfillmentModifierPropertyModel)it.next()).setSequence_noev(argSequence);
/*     */         }
/*     */       } 
/*     */     } 
/*     */     
/* 185 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Date getCreateDate() {
/* 193 */     return getDAO_().getCreateDate();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setCreateDate(Date argCreateDate) {
/* 201 */     if (setCreateDate_noev(argCreateDate) && 
/* 202 */       this._events != null && 
/* 203 */       postEventsForChanges()) {
/* 204 */       this._events.post(IFulfillmentModifier.SET_CREATEDATE, argCreateDate);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setCreateDate_noev(Date argCreateDate) {
/* 211 */     boolean ev_postable = false;
/*     */     
/* 213 */     if ((getDAO_().getCreateDate() == null && argCreateDate != null) || (
/* 214 */       getDAO_().getCreateDate() != null && !getDAO_().getCreateDate().equals(argCreateDate))) {
/* 215 */       getDAO_().setCreateDate(argCreateDate);
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
/*     */   public String getCreateUserId() {
/* 227 */     return getDAO_().getCreateUserId();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setCreateUserId(String argCreateUserId) {
/* 235 */     if (setCreateUserId_noev(argCreateUserId) && 
/* 236 */       this._events != null && 
/* 237 */       postEventsForChanges()) {
/* 238 */       this._events.post(IFulfillmentModifier.SET_CREATEUSERID, argCreateUserId);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setCreateUserId_noev(String argCreateUserId) {
/* 245 */     boolean ev_postable = false;
/*     */     
/* 247 */     if ((getDAO_().getCreateUserId() == null && argCreateUserId != null) || (
/* 248 */       getDAO_().getCreateUserId() != null && !getDAO_().getCreateUserId().equals(argCreateUserId))) {
/* 249 */       getDAO_().setCreateUserId(argCreateUserId);
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
/*     */   public Date getUpdateDate() {
/* 261 */     return getDAO_().getUpdateDate();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setUpdateDate(Date argUpdateDate) {
/* 269 */     if (setUpdateDate_noev(argUpdateDate) && 
/* 270 */       this._events != null && 
/* 271 */       postEventsForChanges()) {
/* 272 */       this._events.post(IFulfillmentModifier.SET_UPDATEDATE, argUpdateDate);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setUpdateDate_noev(Date argUpdateDate) {
/* 279 */     boolean ev_postable = false;
/*     */     
/* 281 */     if ((getDAO_().getUpdateDate() == null && argUpdateDate != null) || (
/* 282 */       getDAO_().getUpdateDate() != null && !getDAO_().getUpdateDate().equals(argUpdateDate))) {
/* 283 */       getDAO_().setUpdateDate(argUpdateDate);
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
/*     */   public String getUpdateUserId() {
/* 295 */     return getDAO_().getUpdateUserId();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setUpdateUserId(String argUpdateUserId) {
/* 303 */     if (setUpdateUserId_noev(argUpdateUserId) && 
/* 304 */       this._events != null && 
/* 305 */       postEventsForChanges()) {
/* 306 */       this._events.post(IFulfillmentModifier.SET_UPDATEUSERID, argUpdateUserId);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setUpdateUserId_noev(String argUpdateUserId) {
/* 313 */     boolean ev_postable = false;
/*     */     
/* 315 */     if ((getDAO_().getUpdateUserId() == null && argUpdateUserId != null) || (
/* 316 */       getDAO_().getUpdateUserId() != null && !getDAO_().getUpdateUserId().equals(argUpdateUserId))) {
/* 317 */       getDAO_().setUpdateUserId(argUpdateUserId);
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
/*     */   public String getLocationId() {
/* 329 */     return getDAO_().getLocationId();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setLocationId(String argLocationId) {
/* 337 */     if (setLocationId_noev(argLocationId) && 
/* 338 */       this._events != null && 
/* 339 */       postEventsForChanges()) {
/* 340 */       this._events.post(IFulfillmentModifier.SET_LOCATIONID, argLocationId);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setLocationId_noev(String argLocationId) {
/* 347 */     boolean ev_postable = false;
/*     */     
/* 349 */     if ((getDAO_().getLocationId() == null && argLocationId != null) || (
/* 350 */       getDAO_().getLocationId() != null && !getDAO_().getLocationId().equals(argLocationId))) {
/* 351 */       getDAO_().setLocationId(argLocationId);
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
/*     */   public String getOrganizationName() {
/* 363 */     return getDAO_().getOrganizationName();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setOrganizationName(String argOrganizationName) {
/* 371 */     if (setOrganizationName_noev(argOrganizationName) && 
/* 372 */       this._events != null && 
/* 373 */       postEventsForChanges()) {
/* 374 */       this._events.post(IFulfillmentModifier.SET_ORGANIZATIONNAME, argOrganizationName);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setOrganizationName_noev(String argOrganizationName) {
/* 381 */     boolean ev_postable = false;
/*     */     
/* 383 */     if ((getDAO_().getOrganizationName() == null && argOrganizationName != null) || (
/* 384 */       getDAO_().getOrganizationName() != null && !getDAO_().getOrganizationName().equals(argOrganizationName))) {
/* 385 */       getDAO_().setOrganizationName(argOrganizationName);
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
/*     */   public String getSalutation() {
/* 397 */     return getDAO_().getSalutation();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setSalutation(String argSalutation) {
/* 405 */     if (setSalutation_noev(argSalutation) && 
/* 406 */       this._events != null && 
/* 407 */       postEventsForChanges()) {
/* 408 */       this._events.post(IFulfillmentModifier.SET_SALUTATION, argSalutation);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setSalutation_noev(String argSalutation) {
/* 415 */     boolean ev_postable = false;
/*     */     
/* 417 */     if ((getDAO_().getSalutation() == null && argSalutation != null) || (
/* 418 */       getDAO_().getSalutation() != null && !getDAO_().getSalutation().equals(argSalutation))) {
/* 419 */       getDAO_().setSalutation(argSalutation);
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
/*     */   public String getLocationName1() {
/* 431 */     return getDAO_().getLocationName1();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setLocationName1(String argLocationName1) {
/* 439 */     if (setLocationName1_noev(argLocationName1) && 
/* 440 */       this._events != null && 
/* 441 */       postEventsForChanges()) {
/* 442 */       this._events.post(IFulfillmentModifier.SET_LOCATIONNAME1, argLocationName1);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setLocationName1_noev(String argLocationName1) {
/* 449 */     boolean ev_postable = false;
/*     */     
/* 451 */     if ((getDAO_().getLocationName1() == null && argLocationName1 != null) || (
/* 452 */       getDAO_().getLocationName1() != null && !getDAO_().getLocationName1().equals(argLocationName1))) {
/* 453 */       getDAO_().setLocationName1(argLocationName1);
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
/*     */   public String getLocationName2() {
/* 465 */     return getDAO_().getLocationName2();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setLocationName2(String argLocationName2) {
/* 473 */     if (setLocationName2_noev(argLocationName2) && 
/* 474 */       this._events != null && 
/* 475 */       postEventsForChanges()) {
/* 476 */       this._events.post(IFulfillmentModifier.SET_LOCATIONNAME2, argLocationName2);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setLocationName2_noev(String argLocationName2) {
/* 483 */     boolean ev_postable = false;
/*     */     
/* 485 */     if ((getDAO_().getLocationName2() == null && argLocationName2 != null) || (
/* 486 */       getDAO_().getLocationName2() != null && !getDAO_().getLocationName2().equals(argLocationName2))) {
/* 487 */       getDAO_().setLocationName2(argLocationName2);
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
/*     */   public String getMiddleName() {
/* 499 */     return getDAO_().getMiddleName();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setMiddleName(String argMiddleName) {
/* 507 */     if (setMiddleName_noev(argMiddleName) && 
/* 508 */       this._events != null && 
/* 509 */       postEventsForChanges()) {
/* 510 */       this._events.post(IFulfillmentModifier.SET_MIDDLENAME, argMiddleName);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setMiddleName_noev(String argMiddleName) {
/* 517 */     boolean ev_postable = false;
/*     */     
/* 519 */     if ((getDAO_().getMiddleName() == null && argMiddleName != null) || (
/* 520 */       getDAO_().getMiddleName() != null && !getDAO_().getMiddleName().equals(argMiddleName))) {
/* 521 */       getDAO_().setMiddleName(argMiddleName);
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
/*     */   public String getSuffix() {
/* 533 */     return getDAO_().getSuffix();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setSuffix(String argSuffix) {
/* 541 */     if (setSuffix_noev(argSuffix) && 
/* 542 */       this._events != null && 
/* 543 */       postEventsForChanges()) {
/* 544 */       this._events.post(IFulfillmentModifier.SET_SUFFIX, argSuffix);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setSuffix_noev(String argSuffix) {
/* 551 */     boolean ev_postable = false;
/*     */     
/* 553 */     if ((getDAO_().getSuffix() == null && argSuffix != null) || (
/* 554 */       getDAO_().getSuffix() != null && !getDAO_().getSuffix().equals(argSuffix))) {
/* 555 */       getDAO_().setSuffix(argSuffix);
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
/*     */   public long getAddressSequence() {
/* 567 */     if (getDAO_().getAddressSequence() != null) {
/* 568 */       return getDAO_().getAddressSequence().longValue();
/*     */     }
/*     */     
/* 571 */     return 0L;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setAddressSequence(long argAddressSequence) {
/* 580 */     if (setAddressSequence_noev(argAddressSequence) && 
/* 581 */       this._events != null && 
/* 582 */       postEventsForChanges()) {
/* 583 */       this._events.post(IFulfillmentModifier.SET_ADDRESSSEQUENCE, Long.valueOf(argAddressSequence));
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setAddressSequence_noev(long argAddressSequence) {
/* 590 */     boolean ev_postable = false;
/*     */     
/* 592 */     if ((getDAO_().getAddressSequence() == null && Long.valueOf(argAddressSequence) != null) || (
/* 593 */       getDAO_().getAddressSequence() != null && !getDAO_().getAddressSequence().equals(Long.valueOf(argAddressSequence)))) {
/* 594 */       getDAO_().setAddressSequence(Long.valueOf(argAddressSequence));
/* 595 */       ev_postable = true;
/*     */     } 
/*     */     
/* 598 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getTelephone1() {
/* 606 */     return getDAO_().getTelephone1();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setTelephone1(String argTelephone1) {
/* 614 */     if (setTelephone1_noev(argTelephone1) && 
/* 615 */       this._events != null && 
/* 616 */       postEventsForChanges()) {
/* 617 */       this._events.post(IFulfillmentModifier.SET_TELEPHONE1, argTelephone1);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setTelephone1_noev(String argTelephone1) {
/* 624 */     boolean ev_postable = false;
/*     */     
/* 626 */     if ((getDAO_().getTelephone1() == null && argTelephone1 != null) || (
/* 627 */       getDAO_().getTelephone1() != null && !getDAO_().getTelephone1().equals(argTelephone1))) {
/* 628 */       getDAO_().setTelephone1(argTelephone1);
/* 629 */       ev_postable = true;
/*     */     } 
/*     */     
/* 632 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getEmailAddress() {
/* 640 */     return getDAO_().getEmailAddress();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setEmailAddress(String argEmailAddress) {
/* 648 */     if (setEmailAddress_noev(argEmailAddress) && 
/* 649 */       this._events != null && 
/* 650 */       postEventsForChanges()) {
/* 651 */       this._events.post(IFulfillmentModifier.SET_EMAILADDRESS, argEmailAddress);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setEmailAddress_noev(String argEmailAddress) {
/* 658 */     boolean ev_postable = false;
/*     */     
/* 660 */     if ((getDAO_().getEmailAddress() == null && argEmailAddress != null) || (
/* 661 */       getDAO_().getEmailAddress() != null && !getDAO_().getEmailAddress().equals(argEmailAddress))) {
/* 662 */       getDAO_().setEmailAddress(argEmailAddress);
/* 663 */       ev_postable = true;
/*     */     } 
/*     */     
/* 666 */     return ev_postable;
/*     */   }
/*     */   
/*     */   protected IFulfillmentModifierProperty newProperty(String argPropertyName) {
/* 670 */     FulfillmentModifierPropertyId id = new FulfillmentModifierPropertyId();
/*     */     
/* 672 */     id.setOrderId(getOrderId());
/* 673 */     id.setSequence(Integer.valueOf(getSequence()));
/* 674 */     id.setPropertyCode(argPropertyName);
/*     */     
/* 676 */     IFulfillmentModifierProperty prop = (IFulfillmentModifierProperty)DataFactory.getInstance().createNewObject((IObjectId)id, IFulfillmentModifierProperty.class);
/* 677 */     return prop;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @Relationship(name = "Address")
/*     */   public IAddressModifier getAddress() {
/* 689 */     return this._address;
/*     */   }
/*     */ 
/*     */   
/*     */   public void setAddress(IAddressModifier argAddress) {
/* 694 */     if (argAddress == null) {
/*     */       
/* 696 */       getDAO_().setAddressSequence(null);
/* 697 */       if (this._address != null)
/*     */       {
/* 699 */         if (postEventsForChanges()) {
/* 700 */           this._eventManager.deregisterEventHandler((IEventAware)this._eventCascade, (IEventSource)new EventDescriptor(this._address));
/*     */         }
/*     */       }
/*     */     } else {
/*     */       
/* 705 */       getDAO_().setAddressSequence(Long.valueOf(argAddress.getSequence()));
/*     */       
/* 707 */       if (postEventsForChanges()) {
/* 708 */         this._eventManager.registerEventHandler((IEventAware)this._eventCascade, (IEventSource)new EventDescriptor(argAddress));
/*     */       }
/*     */     } 
/*     */     
/* 712 */     this._address = argAddress;
/* 713 */     if (postEventsForChanges()) {
/* 714 */       this._events.post(IFulfillmentModifier.SET_ADDRESS, argAddress);
/*     */     }
/*     */   }
/*     */   
/*     */   @Relationship(name = "Properties")
/*     */   public List<IFulfillmentModifierProperty> getProperties() {
/* 720 */     if (this._properties == null) {
/* 721 */       this._properties = new HistoricalList(null);
/*     */     }
/* 723 */     return (List<IFulfillmentModifierProperty>)this._properties;
/*     */   }
/*     */   
/*     */   public void setProperties(List<IFulfillmentModifierProperty> argProperties) {
/* 727 */     if (this._properties == null) {
/* 728 */       this._properties = new HistoricalList(argProperties);
/*     */     } else {
/* 730 */       this._properties.setCurrentList(argProperties);
/*     */     } 
/*     */     
/* 733 */     for (IFulfillmentModifierProperty child : this._properties) {
/* 734 */       FulfillmentModifierPropertyModel model = (FulfillmentModifierPropertyModel)child;
/* 735 */       model.setOrganizationId_noev(getOrganizationId());
/* 736 */       model.setOrderId_noev(getOrderId());
/* 737 */       model.setSequence_noev(getSequence());
/* 738 */       if (child instanceof IDataModelImpl) {
/* 739 */         IDataAccessObject childDao = ((IDataModelImpl)child).getDAO();
/* 740 */         if (StringUtils.isEmpty(childDao.getOriginDataSource()) && 
/* 741 */           !StringUtils.isEmpty(getDAO().getOriginDataSource())) {
/* 742 */           childDao.setOriginDataSource(getDAO().getOriginDataSource());
/*     */         }
/*     */       } 
/* 745 */       if (postEventsForChanges()) {
/* 746 */         this._eventManager.registerEventHandler((IEventAware)this._eventCascade, (IEventSource)child);
/*     */       }
/*     */     } 
/*     */   }
/*     */   
/*     */   public void addFulfillmentModifierProperty(IFulfillmentModifierProperty argFulfillmentModifierProperty) {
/* 752 */     if (this._properties == null) {
/* 753 */       this._properties = new HistoricalList(null);
/*     */     }
/* 755 */     argFulfillmentModifierProperty.setOrganizationId(getOrganizationId());
/* 756 */     argFulfillmentModifierProperty.setOrderId(getOrderId());
/* 757 */     argFulfillmentModifierProperty.setSequence(getSequence());
/* 758 */     if (argFulfillmentModifierProperty instanceof IDataModelImpl) {
/* 759 */       IDataAccessObject childDao = ((IDataModelImpl)argFulfillmentModifierProperty).getDAO();
/* 760 */       if (StringUtils.isEmpty(childDao.getOriginDataSource()) && 
/* 761 */         !StringUtils.isEmpty(getDAO().getOriginDataSource())) {
/* 762 */         childDao.setOriginDataSource(getDAO().getOriginDataSource());
/*     */       }
/*     */     } 
/*     */ 
/*     */     
/* 767 */     if (postEventsForChanges()) {
/* 768 */       this._eventManager.registerEventHandler((IEventAware)this._eventCascade, (IEventSource)new EventDescriptor(argFulfillmentModifierProperty));
/*     */     }
/*     */     
/* 771 */     this._properties.add(argFulfillmentModifierProperty);
/* 772 */     if (postEventsForChanges()) {
/* 773 */       this._events.post(IFulfillmentModifier.ADD_PROPERTIES, argFulfillmentModifierProperty);
/*     */     }
/*     */   }
/*     */   
/*     */   public void removeFulfillmentModifierProperty(IFulfillmentModifierProperty argFulfillmentModifierProperty) {
/* 778 */     if (this._properties != null) {
/*     */       
/* 780 */       if (postEventsForChanges()) {
/* 781 */         this._eventManager.deregisterEventHandler((IEventAware)this._eventCascade, (IEventSource)new EventDescriptor(argFulfillmentModifierProperty));
/*     */       }
/* 783 */       this._properties.remove(argFulfillmentModifierProperty);
/* 784 */       if (postEventsForChanges()) {
/* 785 */         this._events.post(IFulfillmentModifier.REMOVE_PROPERTIES, argFulfillmentModifierProperty);
/*     */       }
/*     */     } 
/*     */   }
/*     */   
/*     */   public void setParentLine(IOrderLine argParentLine) {
/* 791 */     this._parentLine = argParentLine;
/*     */   }
/*     */   
/*     */   public IOrderLine getParentLine() {
/* 795 */     return this._parentLine;
/*     */   }
/*     */ 
/*     */   
/*     */   public Object getValue(String argFieldId) {
/* 800 */     if ("Address".equals(argFieldId)) {
/* 801 */       return getAddress();
/*     */     }
/* 803 */     if ("Properties".equals(argFieldId)) {
/* 804 */       return getProperties();
/*     */     }
/* 806 */     if ("FulfillmentModifierExtension".equals(argFieldId)) {
/* 807 */       return this._myExtension;
/*     */     }
/*     */     
/* 810 */     return super.getValue(argFieldId);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void setValue(String argFieldId, Object argValue) {
/* 816 */     if ("Address".equals(argFieldId)) {
/* 817 */       setAddress((IAddressModifier)argValue);
/*     */     }
/* 819 */     else if ("Properties".equals(argFieldId)) {
/* 820 */       setProperties(changeToList(argValue, IFulfillmentModifierProperty.class));
/*     */     }
/* 822 */     else if ("FulfillmentModifierExtension".equals(argFieldId)) {
/* 823 */       this._myExtension = (IDataModel)argValue;
/*     */     } else {
/*     */       
/* 826 */       super.setValue(argFieldId, argValue);
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public void setDependencies(IPersistenceDefaults argPD, EventManager argEM) {
/* 832 */     this._persistenceDefaults = argPD;
/* 833 */     this._daoImpl.setPersistenceDefaults(argPD);
/* 834 */     this._eventManager = argEM;
/* 835 */     this._events = (Eventor)new ModelEventor((IDataModel)this, argEM);
/* 836 */     this._eventCascade = (EventHandler)new CascadingHandler(this);
/* 837 */     if (this._address != null) {
/* 838 */       ((IDataModelImpl)this._address).setDependencies(argPD, argEM);
/*     */     }
/* 840 */     if (this._properties != null) {
/* 841 */       for (IFulfillmentModifierProperty relationship : this._properties) {
/* 842 */         ((IDataModelImpl)relationship).setDependencies(argPD, argEM);
/*     */       }
/*     */     }
/*     */   }
/*     */   
/*     */   public IDataModel getFulfillmentModifierExt() {
/* 848 */     return this._myExtension;
/*     */   }
/*     */   
/*     */   public void setFulfillmentModifierExt(IDataModel argExt) {
/* 852 */     this._myExtension = argExt;
/*     */   }
/*     */ 
/*     */   
/*     */   public void startTransaction() {
/* 857 */     if (this._alreadyInStart) {
/*     */       return;
/*     */     }
/*     */     
/* 861 */     this._alreadyInStart = true;
/*     */ 
/*     */     
/* 864 */     super.startTransaction();
/*     */     
/* 866 */     this._addressSavepoint = this._address;
/* 867 */     if (this._address != null) {
/* 868 */       this._address.startTransaction();
/*     */     }
/*     */     
/* 871 */     this._propertiesSavepoint = this._properties;
/* 872 */     if (this._properties != null) {
/* 873 */       this._propertiesSavepoint = new HistoricalList((List)this._properties);
/* 874 */       Iterator<IDataModel> it = this._properties.iterator();
/* 875 */       while (it.hasNext()) {
/* 876 */         ((IDataModel)it.next()).startTransaction();
/*     */       }
/*     */     } 
/*     */ 
/*     */     
/* 881 */     this._alreadyInStart = false;
/*     */   }
/*     */ 
/*     */   
/*     */   public void rollbackChanges() {
/* 886 */     if (isAlreadyRolledBack()) {
/*     */       return;
/*     */     }
/* 889 */     super.rollbackChanges();
/*     */     
/* 891 */     this._address = this._addressSavepoint;
/* 892 */     this._addressSavepoint = null;
/* 893 */     if (this._address != null) {
/* 894 */       this._address.rollbackChanges();
/*     */     }
/*     */     
/* 897 */     this._properties = this._propertiesSavepoint;
/* 898 */     this._propertiesSavepoint = null;
/* 899 */     if (this._properties != null) {
/* 900 */       Iterator<IDataModel> it = this._properties.iterator();
/* 901 */       while (it.hasNext()) {
/* 902 */         ((IDataModel)it.next()).rollbackChanges();
/*     */       }
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void commitTransaction() {
/* 910 */     if (this._alreadyInCommit) {
/*     */       return;
/*     */     }
/* 913 */     this._alreadyInCommit = true;
/*     */ 
/*     */     
/* 916 */     super.commitTransaction();
/*     */     
/* 918 */     this._addressSavepoint = this._address;
/* 919 */     if (this._address != null) {
/* 920 */       this._address.commitTransaction();
/*     */     }
/*     */     
/* 923 */     this._propertiesSavepoint = this._properties;
/* 924 */     if (this._properties != null) {
/* 925 */       Iterator<IDataModel> it = this._properties.iterator();
/* 926 */       while (it.hasNext()) {
/* 927 */         ((IDataModel)it.next()).commitTransaction();
/*     */       }
/* 929 */       this._properties = new HistoricalList((List)this._properties);
/*     */     } 
/*     */ 
/*     */     
/* 933 */     this._alreadyInCommit = false;
/*     */   }
/*     */ 
/*     */   
/*     */   private void readObject(ObjectInputStream argStream) throws IOException, ClassNotFoundException {
/* 938 */     argStream.defaultReadObject();
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
/*     */   public IMutableAddress getLocationAddress() {
/* 952 */     return (IMutableAddress)getAddress();
/*     */   }
/*     */ 
/*     */   
/*     */   public void setLocationAddress(IAddressModifier argLocationAddress) {
/* 957 */     setAddress(argLocationAddress);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public String getCountry() {
/* 963 */     return (getAddress() != null) ? getAddress().getCountry() : null;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public String getFirstName() {
/* 969 */     return getLocationName1();
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public String getLastName() {
/* 975 */     return getLocationName2();
/*     */   }
/*     */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\xom\impl\FulfillmentModifierModel.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */