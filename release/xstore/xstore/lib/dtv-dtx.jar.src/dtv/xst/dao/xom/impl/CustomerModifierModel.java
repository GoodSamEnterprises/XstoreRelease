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
/*     */ import dtv.xst.dao.xom.CustomerModifierPropertyId;
/*     */ import dtv.xst.dao.xom.IAddressModifier;
/*     */ import dtv.xst.dao.xom.ICustomerModifier;
/*     */ import dtv.xst.dao.xom.ICustomerModifierProperty;
/*     */ import dtv.xst.dao.xom.IOrder;
/*     */ import java.io.ObjectInputStream;
/*     */ import java.util.Date;
/*     */ import java.util.Iterator;
/*     */ import java.util.List;
/*     */ 
/*     */ public class CustomerModifierModel extends AbstractDataModelWithPropertyImpl<ICustomerModifierProperty> implements ICustomerModifier {
/*     */   private static final long serialVersionUID = -1501991691L;
/*     */   private IOrder _parentOrder;
/*     */   private transient boolean _alreadyInStart = false;
/*     */   private transient boolean _alreadyInCommit = false;
/*     */   
/*     */   public String toString() {
/*  36 */     return super.toString() + " Id: " + getObjectId();
/*     */   }
/*     */   private IDataModel _myExtension; private IAddressModifier _address; private transient IAddressModifier _addressSavepoint; private HistoricalList<ICustomerModifierProperty> _properties; private transient HistoricalList<ICustomerModifierProperty> _propertiesSavepoint;
/*     */   
/*     */   public void initDAO() {
/*  41 */     setDAO((IDataAccessObject)new CustomerModifierDAO());
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private CustomerModifierDAO getDAO_() {
/*  49 */     return (CustomerModifierDAO)this._daoImpl;
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
/*  73 */       this._events.post(ICustomerModifier.SET_ORGANIZATIONID, Long.valueOf(argOrganizationId));
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
/*  88 */         Iterator<CustomerModifierPropertyModel> it = this._properties.iterator();
/*  89 */         while (it.hasNext())
/*     */         {
/*  91 */           ((CustomerModifierPropertyModel)it.next()).setOrganizationId_noev(argOrganizationId);
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
/* 115 */       this._events.post(ICustomerModifier.SET_ORDERID, argOrderId);
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
/* 130 */         Iterator<CustomerModifierPropertyModel> it = this._properties.iterator();
/* 131 */         while (it.hasNext())
/*     */         {
/* 133 */           ((CustomerModifierPropertyModel)it.next()).setOrderId_noev(argOrderId);
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
/*     */   public Date getCreateDate() {
/* 146 */     return getDAO_().getCreateDate();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setCreateDate(Date argCreateDate) {
/* 154 */     if (setCreateDate_noev(argCreateDate) && 
/* 155 */       this._events != null && 
/* 156 */       postEventsForChanges()) {
/* 157 */       this._events.post(ICustomerModifier.SET_CREATEDATE, argCreateDate);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setCreateDate_noev(Date argCreateDate) {
/* 164 */     boolean ev_postable = false;
/*     */     
/* 166 */     if ((getDAO_().getCreateDate() == null && argCreateDate != null) || (
/* 167 */       getDAO_().getCreateDate() != null && !getDAO_().getCreateDate().equals(argCreateDate))) {
/* 168 */       getDAO_().setCreateDate(argCreateDate);
/* 169 */       ev_postable = true;
/*     */     } 
/*     */     
/* 172 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getCreateUserId() {
/* 180 */     return getDAO_().getCreateUserId();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setCreateUserId(String argCreateUserId) {
/* 188 */     if (setCreateUserId_noev(argCreateUserId) && 
/* 189 */       this._events != null && 
/* 190 */       postEventsForChanges()) {
/* 191 */       this._events.post(ICustomerModifier.SET_CREATEUSERID, argCreateUserId);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setCreateUserId_noev(String argCreateUserId) {
/* 198 */     boolean ev_postable = false;
/*     */     
/* 200 */     if ((getDAO_().getCreateUserId() == null && argCreateUserId != null) || (
/* 201 */       getDAO_().getCreateUserId() != null && !getDAO_().getCreateUserId().equals(argCreateUserId))) {
/* 202 */       getDAO_().setCreateUserId(argCreateUserId);
/* 203 */       ev_postable = true;
/*     */     } 
/*     */     
/* 206 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Date getUpdateDate() {
/* 214 */     return getDAO_().getUpdateDate();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setUpdateDate(Date argUpdateDate) {
/* 222 */     if (setUpdateDate_noev(argUpdateDate) && 
/* 223 */       this._events != null && 
/* 224 */       postEventsForChanges()) {
/* 225 */       this._events.post(ICustomerModifier.SET_UPDATEDATE, argUpdateDate);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setUpdateDate_noev(Date argUpdateDate) {
/* 232 */     boolean ev_postable = false;
/*     */     
/* 234 */     if ((getDAO_().getUpdateDate() == null && argUpdateDate != null) || (
/* 235 */       getDAO_().getUpdateDate() != null && !getDAO_().getUpdateDate().equals(argUpdateDate))) {
/* 236 */       getDAO_().setUpdateDate(argUpdateDate);
/* 237 */       ev_postable = true;
/*     */     } 
/*     */     
/* 240 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getUpdateUserId() {
/* 248 */     return getDAO_().getUpdateUserId();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setUpdateUserId(String argUpdateUserId) {
/* 256 */     if (setUpdateUserId_noev(argUpdateUserId) && 
/* 257 */       this._events != null && 
/* 258 */       postEventsForChanges()) {
/* 259 */       this._events.post(ICustomerModifier.SET_UPDATEUSERID, argUpdateUserId);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setUpdateUserId_noev(String argUpdateUserId) {
/* 266 */     boolean ev_postable = false;
/*     */     
/* 268 */     if ((getDAO_().getUpdateUserId() == null && argUpdateUserId != null) || (
/* 269 */       getDAO_().getUpdateUserId() != null && !getDAO_().getUpdateUserId().equals(argUpdateUserId))) {
/* 270 */       getDAO_().setUpdateUserId(argUpdateUserId);
/* 271 */       ev_postable = true;
/*     */     } 
/*     */     
/* 274 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getCustomerId() {
/* 282 */     return getDAO_().getCustomerId();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setCustomerId(String argCustomerId) {
/* 290 */     if (setCustomerId_noev(argCustomerId) && 
/* 291 */       this._events != null && 
/* 292 */       postEventsForChanges()) {
/* 293 */       this._events.post(ICustomerModifier.SET_CUSTOMERID, argCustomerId);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setCustomerId_noev(String argCustomerId) {
/* 300 */     boolean ev_postable = false;
/*     */     
/* 302 */     if ((getDAO_().getCustomerId() == null && argCustomerId != null) || (
/* 303 */       getDAO_().getCustomerId() != null && !getDAO_().getCustomerId().equals(argCustomerId))) {
/* 304 */       getDAO_().setCustomerId(argCustomerId);
/* 305 */       ev_postable = true;
/*     */     } 
/*     */     
/* 308 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getOrganizationName() {
/* 316 */     return getDAO_().getOrganizationName();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setOrganizationName(String argOrganizationName) {
/* 324 */     if (setOrganizationName_noev(argOrganizationName) && 
/* 325 */       this._events != null && 
/* 326 */       postEventsForChanges()) {
/* 327 */       this._events.post(ICustomerModifier.SET_ORGANIZATIONNAME, argOrganizationName);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setOrganizationName_noev(String argOrganizationName) {
/* 334 */     boolean ev_postable = false;
/*     */     
/* 336 */     if ((getDAO_().getOrganizationName() == null && argOrganizationName != null) || (
/* 337 */       getDAO_().getOrganizationName() != null && !getDAO_().getOrganizationName().equals(argOrganizationName))) {
/* 338 */       getDAO_().setOrganizationName(argOrganizationName);
/* 339 */       ev_postable = true;
/*     */     } 
/*     */     
/* 342 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getSalutation() {
/* 350 */     return getDAO_().getSalutation();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setSalutation(String argSalutation) {
/* 358 */     if (setSalutation_noev(argSalutation) && 
/* 359 */       this._events != null && 
/* 360 */       postEventsForChanges()) {
/* 361 */       this._events.post(ICustomerModifier.SET_SALUTATION, argSalutation);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setSalutation_noev(String argSalutation) {
/* 368 */     boolean ev_postable = false;
/*     */     
/* 370 */     if ((getDAO_().getSalutation() == null && argSalutation != null) || (
/* 371 */       getDAO_().getSalutation() != null && !getDAO_().getSalutation().equals(argSalutation))) {
/* 372 */       getDAO_().setSalutation(argSalutation);
/* 373 */       ev_postable = true;
/*     */     } 
/*     */     
/* 376 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getFirstName() {
/* 384 */     return getDAO_().getFirstName();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setFirstName(String argFirstName) {
/* 392 */     if (setFirstName_noev(argFirstName) && 
/* 393 */       this._events != null && 
/* 394 */       postEventsForChanges()) {
/* 395 */       this._events.post(ICustomerModifier.SET_FIRSTNAME, argFirstName);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setFirstName_noev(String argFirstName) {
/* 402 */     boolean ev_postable = false;
/*     */     
/* 404 */     if ((getDAO_().getFirstName() == null && argFirstName != null) || (
/* 405 */       getDAO_().getFirstName() != null && !getDAO_().getFirstName().equals(argFirstName))) {
/* 406 */       getDAO_().setFirstName(argFirstName);
/* 407 */       ev_postable = true;
/*     */     } 
/*     */     
/* 410 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getMiddleName() {
/* 418 */     return getDAO_().getMiddleName();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setMiddleName(String argMiddleName) {
/* 426 */     if (setMiddleName_noev(argMiddleName) && 
/* 427 */       this._events != null && 
/* 428 */       postEventsForChanges()) {
/* 429 */       this._events.post(ICustomerModifier.SET_MIDDLENAME, argMiddleName);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setMiddleName_noev(String argMiddleName) {
/* 436 */     boolean ev_postable = false;
/*     */     
/* 438 */     if ((getDAO_().getMiddleName() == null && argMiddleName != null) || (
/* 439 */       getDAO_().getMiddleName() != null && !getDAO_().getMiddleName().equals(argMiddleName))) {
/* 440 */       getDAO_().setMiddleName(argMiddleName);
/* 441 */       ev_postable = true;
/*     */     } 
/*     */     
/* 444 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getLastName() {
/* 452 */     return getDAO_().getLastName();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setLastName(String argLastName) {
/* 460 */     if (setLastName_noev(argLastName) && 
/* 461 */       this._events != null && 
/* 462 */       postEventsForChanges()) {
/* 463 */       this._events.post(ICustomerModifier.SET_LASTNAME, argLastName);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setLastName_noev(String argLastName) {
/* 470 */     boolean ev_postable = false;
/*     */     
/* 472 */     if ((getDAO_().getLastName() == null && argLastName != null) || (
/* 473 */       getDAO_().getLastName() != null && !getDAO_().getLastName().equals(argLastName))) {
/* 474 */       getDAO_().setLastName(argLastName);
/* 475 */       ev_postable = true;
/*     */     } 
/*     */     
/* 478 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getSuffix() {
/* 486 */     return getDAO_().getSuffix();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setSuffix(String argSuffix) {
/* 494 */     if (setSuffix_noev(argSuffix) && 
/* 495 */       this._events != null && 
/* 496 */       postEventsForChanges()) {
/* 497 */       this._events.post(ICustomerModifier.SET_SUFFIX, argSuffix);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setSuffix_noev(String argSuffix) {
/* 504 */     boolean ev_postable = false;
/*     */     
/* 506 */     if ((getDAO_().getSuffix() == null && argSuffix != null) || (
/* 507 */       getDAO_().getSuffix() != null && !getDAO_().getSuffix().equals(argSuffix))) {
/* 508 */       getDAO_().setSuffix(argSuffix);
/* 509 */       ev_postable = true;
/*     */     } 
/*     */     
/* 512 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getTelephone1() {
/* 520 */     return getDAO_().getTelephone1();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setTelephone1(String argTelephone1) {
/* 528 */     if (setTelephone1_noev(argTelephone1) && 
/* 529 */       this._events != null && 
/* 530 */       postEventsForChanges()) {
/* 531 */       this._events.post(ICustomerModifier.SET_TELEPHONE1, argTelephone1);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setTelephone1_noev(String argTelephone1) {
/* 538 */     boolean ev_postable = false;
/*     */     
/* 540 */     if ((getDAO_().getTelephone1() == null && argTelephone1 != null) || (
/* 541 */       getDAO_().getTelephone1() != null && !getDAO_().getTelephone1().equals(argTelephone1))) {
/* 542 */       getDAO_().setTelephone1(argTelephone1);
/* 543 */       ev_postable = true;
/*     */     } 
/*     */     
/* 546 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getTelephone2() {
/* 554 */     return getDAO_().getTelephone2();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setTelephone2(String argTelephone2) {
/* 562 */     if (setTelephone2_noev(argTelephone2) && 
/* 563 */       this._events != null && 
/* 564 */       postEventsForChanges()) {
/* 565 */       this._events.post(ICustomerModifier.SET_TELEPHONE2, argTelephone2);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setTelephone2_noev(String argTelephone2) {
/* 572 */     boolean ev_postable = false;
/*     */     
/* 574 */     if ((getDAO_().getTelephone2() == null && argTelephone2 != null) || (
/* 575 */       getDAO_().getTelephone2() != null && !getDAO_().getTelephone2().equals(argTelephone2))) {
/* 576 */       getDAO_().setTelephone2(argTelephone2);
/* 577 */       ev_postable = true;
/*     */     } 
/*     */     
/* 580 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getEmailAddress() {
/* 588 */     return getDAO_().getEmailAddress();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setEmailAddress(String argEmailAddress) {
/* 596 */     if (setEmailAddress_noev(argEmailAddress) && 
/* 597 */       this._events != null && 
/* 598 */       postEventsForChanges()) {
/* 599 */       this._events.post(ICustomerModifier.SET_EMAILADDRESS, argEmailAddress);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setEmailAddress_noev(String argEmailAddress) {
/* 606 */     boolean ev_postable = false;
/*     */     
/* 608 */     if ((getDAO_().getEmailAddress() == null && argEmailAddress != null) || (
/* 609 */       getDAO_().getEmailAddress() != null && !getDAO_().getEmailAddress().equals(argEmailAddress))) {
/* 610 */       getDAO_().setEmailAddress(argEmailAddress);
/* 611 */       ev_postable = true;
/*     */     } 
/*     */     
/* 614 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public long getAddressSequence() {
/* 622 */     if (getDAO_().getAddressSequence() != null) {
/* 623 */       return getDAO_().getAddressSequence().longValue();
/*     */     }
/*     */     
/* 626 */     return 0L;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setAddressSequence(long argAddressSequence) {
/* 635 */     if (setAddressSequence_noev(argAddressSequence) && 
/* 636 */       this._events != null && 
/* 637 */       postEventsForChanges()) {
/* 638 */       this._events.post(ICustomerModifier.SET_ADDRESSSEQUENCE, Long.valueOf(argAddressSequence));
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setAddressSequence_noev(long argAddressSequence) {
/* 645 */     boolean ev_postable = false;
/*     */     
/* 647 */     if ((getDAO_().getAddressSequence() == null && Long.valueOf(argAddressSequence) != null) || (
/* 648 */       getDAO_().getAddressSequence() != null && !getDAO_().getAddressSequence().equals(Long.valueOf(argAddressSequence)))) {
/* 649 */       getDAO_().setAddressSequence(Long.valueOf(argAddressSequence));
/* 650 */       ev_postable = true;
/*     */     } 
/*     */     
/* 653 */     return ev_postable;
/*     */   }
/*     */   
/*     */   protected ICustomerModifierProperty newProperty(String argPropertyName) {
/* 657 */     CustomerModifierPropertyId id = new CustomerModifierPropertyId();
/*     */     
/* 659 */     id.setOrderId(getOrderId());
/* 660 */     id.setPropertyCode(argPropertyName);
/*     */     
/* 662 */     ICustomerModifierProperty prop = (ICustomerModifierProperty)DataFactory.getInstance().createNewObject((IObjectId)id, ICustomerModifierProperty.class);
/* 663 */     return prop;
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
/* 675 */     return this._address;
/*     */   }
/*     */ 
/*     */   
/*     */   public void setAddress(IAddressModifier argAddress) {
/* 680 */     if (argAddress == null) {
/*     */       
/* 682 */       getDAO_().setAddressSequence(null);
/* 683 */       if (this._address != null)
/*     */       {
/* 685 */         if (postEventsForChanges()) {
/* 686 */           this._eventManager.deregisterEventHandler((IEventAware)this._eventCascade, (IEventSource)new EventDescriptor(this._address));
/*     */         }
/*     */       }
/*     */     } else {
/*     */       
/* 691 */       getDAO_().setAddressSequence(Long.valueOf(argAddress.getSequence()));
/*     */       
/* 693 */       if (postEventsForChanges()) {
/* 694 */         this._eventManager.registerEventHandler((IEventAware)this._eventCascade, (IEventSource)new EventDescriptor(argAddress));
/*     */       }
/*     */     } 
/*     */     
/* 698 */     this._address = argAddress;
/* 699 */     if (postEventsForChanges()) {
/* 700 */       this._events.post(ICustomerModifier.SET_ADDRESS, argAddress);
/*     */     }
/*     */   }
/*     */   
/*     */   @Relationship(name = "Properties")
/*     */   public List<ICustomerModifierProperty> getProperties() {
/* 706 */     if (this._properties == null) {
/* 707 */       this._properties = new HistoricalList(null);
/*     */     }
/* 709 */     return (List<ICustomerModifierProperty>)this._properties;
/*     */   }
/*     */   
/*     */   public void setProperties(List<ICustomerModifierProperty> argProperties) {
/* 713 */     if (this._properties == null) {
/* 714 */       this._properties = new HistoricalList(argProperties);
/*     */     } else {
/* 716 */       this._properties.setCurrentList(argProperties);
/*     */     } 
/*     */     
/* 719 */     for (ICustomerModifierProperty child : this._properties) {
/* 720 */       CustomerModifierPropertyModel model = (CustomerModifierPropertyModel)child;
/* 721 */       model.setOrganizationId_noev(getOrganizationId());
/* 722 */       model.setOrderId_noev(getOrderId());
/* 723 */       if (child instanceof IDataModelImpl) {
/* 724 */         IDataAccessObject childDao = ((IDataModelImpl)child).getDAO();
/* 725 */         if (StringUtils.isEmpty(childDao.getOriginDataSource()) && 
/* 726 */           !StringUtils.isEmpty(getDAO().getOriginDataSource())) {
/* 727 */           childDao.setOriginDataSource(getDAO().getOriginDataSource());
/*     */         }
/*     */       } 
/* 730 */       if (postEventsForChanges()) {
/* 731 */         this._eventManager.registerEventHandler((IEventAware)this._eventCascade, (IEventSource)child);
/*     */       }
/*     */     } 
/*     */   }
/*     */   
/*     */   public void addCustomerModifierProperty(ICustomerModifierProperty argCustomerModifierProperty) {
/* 737 */     if (this._properties == null) {
/* 738 */       this._properties = new HistoricalList(null);
/*     */     }
/* 740 */     argCustomerModifierProperty.setOrganizationId(getOrganizationId());
/* 741 */     argCustomerModifierProperty.setOrderId(getOrderId());
/* 742 */     if (argCustomerModifierProperty instanceof IDataModelImpl) {
/* 743 */       IDataAccessObject childDao = ((IDataModelImpl)argCustomerModifierProperty).getDAO();
/* 744 */       if (StringUtils.isEmpty(childDao.getOriginDataSource()) && 
/* 745 */         !StringUtils.isEmpty(getDAO().getOriginDataSource())) {
/* 746 */         childDao.setOriginDataSource(getDAO().getOriginDataSource());
/*     */       }
/*     */     } 
/*     */ 
/*     */     
/* 751 */     if (postEventsForChanges()) {
/* 752 */       this._eventManager.registerEventHandler((IEventAware)this._eventCascade, (IEventSource)new EventDescriptor(argCustomerModifierProperty));
/*     */     }
/*     */     
/* 755 */     this._properties.add(argCustomerModifierProperty);
/* 756 */     if (postEventsForChanges()) {
/* 757 */       this._events.post(ICustomerModifier.ADD_PROPERTIES, argCustomerModifierProperty);
/*     */     }
/*     */   }
/*     */   
/*     */   public void removeCustomerModifierProperty(ICustomerModifierProperty argCustomerModifierProperty) {
/* 762 */     if (this._properties != null) {
/*     */       
/* 764 */       if (postEventsForChanges()) {
/* 765 */         this._eventManager.deregisterEventHandler((IEventAware)this._eventCascade, (IEventSource)new EventDescriptor(argCustomerModifierProperty));
/*     */       }
/* 767 */       this._properties.remove(argCustomerModifierProperty);
/* 768 */       if (postEventsForChanges()) {
/* 769 */         this._events.post(ICustomerModifier.REMOVE_PROPERTIES, argCustomerModifierProperty);
/*     */       }
/*     */     } 
/*     */   }
/*     */   
/*     */   public void setParentOrder(IOrder argParentOrder) {
/* 775 */     this._parentOrder = argParentOrder;
/*     */   }
/*     */   
/*     */   public IOrder getParentOrder() {
/* 779 */     return this._parentOrder;
/*     */   }
/*     */ 
/*     */   
/*     */   public Object getValue(String argFieldId) {
/* 784 */     if ("Address".equals(argFieldId)) {
/* 785 */       return getAddress();
/*     */     }
/* 787 */     if ("Properties".equals(argFieldId)) {
/* 788 */       return getProperties();
/*     */     }
/* 790 */     if ("CustomerModifierExtension".equals(argFieldId)) {
/* 791 */       return this._myExtension;
/*     */     }
/*     */     
/* 794 */     return super.getValue(argFieldId);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void setValue(String argFieldId, Object argValue) {
/* 800 */     if ("Address".equals(argFieldId)) {
/* 801 */       setAddress((IAddressModifier)argValue);
/*     */     }
/* 803 */     else if ("Properties".equals(argFieldId)) {
/* 804 */       setProperties(changeToList(argValue, ICustomerModifierProperty.class));
/*     */     }
/* 806 */     else if ("CustomerModifierExtension".equals(argFieldId)) {
/* 807 */       this._myExtension = (IDataModel)argValue;
/*     */     } else {
/*     */       
/* 810 */       super.setValue(argFieldId, argValue);
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public void setDependencies(IPersistenceDefaults argPD, EventManager argEM) {
/* 816 */     this._persistenceDefaults = argPD;
/* 817 */     this._daoImpl.setPersistenceDefaults(argPD);
/* 818 */     this._eventManager = argEM;
/* 819 */     this._events = (Eventor)new ModelEventor((IDataModel)this, argEM);
/* 820 */     this._eventCascade = (EventHandler)new CascadingHandler(this);
/* 821 */     if (this._address != null) {
/* 822 */       ((IDataModelImpl)this._address).setDependencies(argPD, argEM);
/*     */     }
/* 824 */     if (this._properties != null) {
/* 825 */       for (ICustomerModifierProperty relationship : this._properties) {
/* 826 */         ((IDataModelImpl)relationship).setDependencies(argPD, argEM);
/*     */       }
/*     */     }
/*     */   }
/*     */   
/*     */   public IDataModel getCustomerModifierExt() {
/* 832 */     return this._myExtension;
/*     */   }
/*     */   
/*     */   public void setCustomerModifierExt(IDataModel argExt) {
/* 836 */     this._myExtension = argExt;
/*     */   }
/*     */ 
/*     */   
/*     */   public void startTransaction() {
/* 841 */     if (this._alreadyInStart) {
/*     */       return;
/*     */     }
/*     */     
/* 845 */     this._alreadyInStart = true;
/*     */ 
/*     */     
/* 848 */     super.startTransaction();
/*     */     
/* 850 */     this._addressSavepoint = this._address;
/* 851 */     if (this._address != null) {
/* 852 */       this._address.startTransaction();
/*     */     }
/*     */     
/* 855 */     this._propertiesSavepoint = this._properties;
/* 856 */     if (this._properties != null) {
/* 857 */       this._propertiesSavepoint = new HistoricalList((List)this._properties);
/* 858 */       Iterator<IDataModel> it = this._properties.iterator();
/* 859 */       while (it.hasNext()) {
/* 860 */         ((IDataModel)it.next()).startTransaction();
/*     */       }
/*     */     } 
/*     */ 
/*     */     
/* 865 */     this._alreadyInStart = false;
/*     */   }
/*     */ 
/*     */   
/*     */   public void rollbackChanges() {
/* 870 */     if (isAlreadyRolledBack()) {
/*     */       return;
/*     */     }
/* 873 */     super.rollbackChanges();
/*     */     
/* 875 */     this._address = this._addressSavepoint;
/* 876 */     this._addressSavepoint = null;
/* 877 */     if (this._address != null) {
/* 878 */       this._address.rollbackChanges();
/*     */     }
/*     */     
/* 881 */     this._properties = this._propertiesSavepoint;
/* 882 */     this._propertiesSavepoint = null;
/* 883 */     if (this._properties != null) {
/* 884 */       Iterator<IDataModel> it = this._properties.iterator();
/* 885 */       while (it.hasNext()) {
/* 886 */         ((IDataModel)it.next()).rollbackChanges();
/*     */       }
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void commitTransaction() {
/* 894 */     if (this._alreadyInCommit) {
/*     */       return;
/*     */     }
/* 897 */     this._alreadyInCommit = true;
/*     */ 
/*     */     
/* 900 */     super.commitTransaction();
/*     */     
/* 902 */     this._addressSavepoint = this._address;
/* 903 */     if (this._address != null) {
/* 904 */       this._address.commitTransaction();
/*     */     }
/*     */     
/* 907 */     this._propertiesSavepoint = this._properties;
/* 908 */     if (this._properties != null) {
/* 909 */       Iterator<IDataModel> it = this._properties.iterator();
/* 910 */       while (it.hasNext()) {
/* 911 */         ((IDataModel)it.next()).commitTransaction();
/*     */       }
/* 913 */       this._properties = new HistoricalList((List)this._properties);
/*     */     } 
/*     */ 
/*     */     
/* 917 */     this._alreadyInCommit = false;
/*     */   }
/*     */ 
/*     */   
/*     */   private void readObject(ObjectInputStream argStream) throws IOException, ClassNotFoundException {
/* 922 */     argStream.defaultReadObject();
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
/*     */   public String getLocationId() {
/* 936 */     return getCustomerId();
/*     */   }
/*     */ 
/*     */   
/*     */   public String getLocationName1() {
/* 941 */     return getFirstName();
/*     */   }
/*     */ 
/*     */   
/*     */   public String getLocationName2() {
/* 946 */     return getLastName();
/*     */   }
/*     */ 
/*     */   
/*     */   public IMutableAddress getLocationAddress() {
/* 951 */     return (IMutableAddress)getAddress();
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public String getCountry() {
/* 957 */     return (getAddress() != null) ? getAddress().getCountry() : null;
/*     */   }
/*     */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\xom\impl\CustomerModifierModel.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */