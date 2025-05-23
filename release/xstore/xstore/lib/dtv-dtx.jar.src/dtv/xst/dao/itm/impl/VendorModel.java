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
/*     */ import dtv.xst.dao.com.IAddress;
/*     */ import dtv.xst.dao.itm.IVendor;
/*     */ import dtv.xst.dao.itm.IVendorProperty;
/*     */ import dtv.xst.dao.itm.VendorPropertyId;
/*     */ import java.io.ObjectInputStream;
/*     */ import java.util.Date;
/*     */ import java.util.Iterator;
/*     */ import java.util.List;
/*     */ 
/*     */ public class VendorModel extends AbstractDataModelWithPropertyImpl<IVendorProperty> implements IVendor {
/*     */   private static final long serialVersionUID = -1736208024L;
/*     */   private transient boolean _alreadyInStart = false;
/*     */   private transient boolean _alreadyInCommit = false;
/*     */   private IDataModel _myExtension;
/*     */   
/*     */   public String toString() {
/*  34 */     return super.toString() + " Id: " + getObjectId();
/*     */   }
/*     */   private IAddress _address; private transient IAddress _addressSavepoint; private HistoricalList<IVendorProperty> _properties; private transient HistoricalList<IVendorProperty> _propertiesSavepoint;
/*     */   
/*     */   public void initDAO() {
/*  39 */     setDAO((IDataAccessObject)new VendorDAO());
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private VendorDAO getDAO_() {
/*  47 */     return (VendorDAO)this._daoImpl;
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
/*  71 */       this._events.post(IVendor.SET_ORGANIZATIONID, Long.valueOf(argOrganizationId));
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
/*  86 */         Iterator<VendorPropertyModel> it = this._properties.iterator();
/*  87 */         while (it.hasNext())
/*     */         {
/*  89 */           ((VendorPropertyModel)it.next()).setOrganizationId_noev(argOrganizationId);
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
/*     */   public String getVendorId() {
/* 102 */     return getDAO_().getVendorId();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setVendorId(String argVendorId) {
/* 110 */     if (setVendorId_noev(argVendorId) && 
/* 111 */       this._events != null && 
/* 112 */       postEventsForChanges()) {
/* 113 */       this._events.post(IVendor.SET_VENDORID, argVendorId);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setVendorId_noev(String argVendorId) {
/* 120 */     boolean ev_postable = false;
/*     */     
/* 122 */     if ((getDAO_().getVendorId() == null && argVendorId != null) || (
/* 123 */       getDAO_().getVendorId() != null && !getDAO_().getVendorId().equals(argVendorId))) {
/* 124 */       getDAO_().setVendorId(argVendorId);
/* 125 */       ev_postable = true;
/* 126 */       if (this._properties != null) {
/*     */         
/* 128 */         Iterator<VendorPropertyModel> it = this._properties.iterator();
/* 129 */         while (it.hasNext())
/*     */         {
/* 131 */           ((VendorPropertyModel)it.next()).setVendorId_noev(argVendorId);
/*     */         }
/*     */       } 
/*     */     } 
/*     */     
/* 136 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Date getCreateDate() {
/* 144 */     return getDAO_().getCreateDate();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setCreateDate(Date argCreateDate) {
/* 152 */     if (setCreateDate_noev(argCreateDate) && 
/* 153 */       this._events != null && 
/* 154 */       postEventsForChanges()) {
/* 155 */       this._events.post(IVendor.SET_CREATEDATE, argCreateDate);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setCreateDate_noev(Date argCreateDate) {
/* 162 */     boolean ev_postable = false;
/*     */     
/* 164 */     if ((getDAO_().getCreateDate() == null && argCreateDate != null) || (
/* 165 */       getDAO_().getCreateDate() != null && !getDAO_().getCreateDate().equals(argCreateDate))) {
/* 166 */       getDAO_().setCreateDate(argCreateDate);
/* 167 */       ev_postable = true;
/*     */     } 
/*     */     
/* 170 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getCreateUserId() {
/* 178 */     return getDAO_().getCreateUserId();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setCreateUserId(String argCreateUserId) {
/* 186 */     if (setCreateUserId_noev(argCreateUserId) && 
/* 187 */       this._events != null && 
/* 188 */       postEventsForChanges()) {
/* 189 */       this._events.post(IVendor.SET_CREATEUSERID, argCreateUserId);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setCreateUserId_noev(String argCreateUserId) {
/* 196 */     boolean ev_postable = false;
/*     */     
/* 198 */     if ((getDAO_().getCreateUserId() == null && argCreateUserId != null) || (
/* 199 */       getDAO_().getCreateUserId() != null && !getDAO_().getCreateUserId().equals(argCreateUserId))) {
/* 200 */       getDAO_().setCreateUserId(argCreateUserId);
/* 201 */       ev_postable = true;
/*     */     } 
/*     */     
/* 204 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Date getUpdateDate() {
/* 212 */     return getDAO_().getUpdateDate();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setUpdateDate(Date argUpdateDate) {
/* 220 */     if (setUpdateDate_noev(argUpdateDate) && 
/* 221 */       this._events != null && 
/* 222 */       postEventsForChanges()) {
/* 223 */       this._events.post(IVendor.SET_UPDATEDATE, argUpdateDate);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setUpdateDate_noev(Date argUpdateDate) {
/* 230 */     boolean ev_postable = false;
/*     */     
/* 232 */     if ((getDAO_().getUpdateDate() == null && argUpdateDate != null) || (
/* 233 */       getDAO_().getUpdateDate() != null && !getDAO_().getUpdateDate().equals(argUpdateDate))) {
/* 234 */       getDAO_().setUpdateDate(argUpdateDate);
/* 235 */       ev_postable = true;
/*     */     } 
/*     */     
/* 238 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getUpdateUserId() {
/* 246 */     return getDAO_().getUpdateUserId();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setUpdateUserId(String argUpdateUserId) {
/* 254 */     if (setUpdateUserId_noev(argUpdateUserId) && 
/* 255 */       this._events != null && 
/* 256 */       postEventsForChanges()) {
/* 257 */       this._events.post(IVendor.SET_UPDATEUSERID, argUpdateUserId);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setUpdateUserId_noev(String argUpdateUserId) {
/* 264 */     boolean ev_postable = false;
/*     */     
/* 266 */     if ((getDAO_().getUpdateUserId() == null && argUpdateUserId != null) || (
/* 267 */       getDAO_().getUpdateUserId() != null && !getDAO_().getUpdateUserId().equals(argUpdateUserId))) {
/* 268 */       getDAO_().setUpdateUserId(argUpdateUserId);
/* 269 */       ev_postable = true;
/*     */     } 
/*     */     
/* 272 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getOrgCode() {
/* 280 */     return getDAO_().getOrgCode();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setOrgCode(String argOrgCode) {
/* 288 */     if (setOrgCode_noev(argOrgCode) && 
/* 289 */       this._events != null && 
/* 290 */       postEventsForChanges()) {
/* 291 */       this._events.post(IVendor.SET_ORGCODE, argOrgCode);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setOrgCode_noev(String argOrgCode) {
/* 298 */     boolean ev_postable = false;
/*     */     
/* 300 */     if ((getDAO_().getOrgCode() == null && argOrgCode != null) || (
/* 301 */       getDAO_().getOrgCode() != null && !getDAO_().getOrgCode().equals(argOrgCode))) {
/* 302 */       getDAO_().setOrgCode(argOrgCode);
/* 303 */       ev_postable = true;
/*     */     } 
/*     */     
/* 306 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getOrgValue() {
/* 314 */     return getDAO_().getOrgValue();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setOrgValue(String argOrgValue) {
/* 322 */     if (setOrgValue_noev(argOrgValue) && 
/* 323 */       this._events != null && 
/* 324 */       postEventsForChanges()) {
/* 325 */       this._events.post(IVendor.SET_ORGVALUE, argOrgValue);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setOrgValue_noev(String argOrgValue) {
/* 332 */     boolean ev_postable = false;
/*     */     
/* 334 */     if ((getDAO_().getOrgValue() == null && argOrgValue != null) || (
/* 335 */       getDAO_().getOrgValue() != null && !getDAO_().getOrgValue().equals(argOrgValue))) {
/* 336 */       getDAO_().setOrgValue(argOrgValue);
/* 337 */       ev_postable = true;
/*     */     } 
/*     */     
/* 340 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getName() {
/* 348 */     return getDAO_().getName();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setName(String argName) {
/* 356 */     if (setName_noev(argName) && 
/* 357 */       this._events != null && 
/* 358 */       postEventsForChanges()) {
/* 359 */       this._events.post(IVendor.SET_NAME, argName);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setName_noev(String argName) {
/* 366 */     boolean ev_postable = false;
/*     */     
/* 368 */     if ((getDAO_().getName() == null && argName != null) || (
/* 369 */       getDAO_().getName() != null && !getDAO_().getName().equals(argName))) {
/* 370 */       getDAO_().setName(argName);
/* 371 */       ev_postable = true;
/*     */     } 
/*     */     
/* 374 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getTypeCode() {
/* 382 */     return getDAO_().getTypeCode();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setTypeCode(String argTypeCode) {
/* 390 */     if (setTypeCode_noev(argTypeCode) && 
/* 391 */       this._events != null && 
/* 392 */       postEventsForChanges()) {
/* 393 */       this._events.post(IVendor.SET_TYPECODE, argTypeCode);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setTypeCode_noev(String argTypeCode) {
/* 400 */     boolean ev_postable = false;
/*     */     
/* 402 */     if ((getDAO_().getTypeCode() == null && argTypeCode != null) || (
/* 403 */       getDAO_().getTypeCode() != null && !getDAO_().getTypeCode().equals(argTypeCode))) {
/* 404 */       getDAO_().setTypeCode(argTypeCode);
/* 405 */       ev_postable = true;
/*     */     } 
/*     */     
/* 408 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getTelephone() {
/* 416 */     return getDAO_().getTelephone();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setTelephone(String argTelephone) {
/* 424 */     if (setTelephone_noev(argTelephone) && 
/* 425 */       this._events != null && 
/* 426 */       postEventsForChanges()) {
/* 427 */       this._events.post(IVendor.SET_TELEPHONE, argTelephone);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setTelephone_noev(String argTelephone) {
/* 434 */     boolean ev_postable = false;
/*     */     
/* 436 */     if ((getDAO_().getTelephone() == null && argTelephone != null) || (
/* 437 */       getDAO_().getTelephone() != null && !getDAO_().getTelephone().equals(argTelephone))) {
/* 438 */       getDAO_().setTelephone(argTelephone);
/* 439 */       ev_postable = true;
/*     */     } 
/*     */     
/* 442 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getFax() {
/* 450 */     return getDAO_().getFax();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setFax(String argFax) {
/* 458 */     if (setFax_noev(argFax) && 
/* 459 */       this._events != null && 
/* 460 */       postEventsForChanges()) {
/* 461 */       this._events.post(IVendor.SET_FAX, argFax);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setFax_noev(String argFax) {
/* 468 */     boolean ev_postable = false;
/*     */     
/* 470 */     if ((getDAO_().getFax() == null && argFax != null) || (
/* 471 */       getDAO_().getFax() != null && !getDAO_().getFax().equals(argFax))) {
/* 472 */       getDAO_().setFax(argFax);
/* 473 */       ev_postable = true;
/*     */     } 
/*     */     
/* 476 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getContact() {
/* 484 */     return getDAO_().getContact();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setContact(String argContact) {
/* 492 */     if (setContact_noev(argContact) && 
/* 493 */       this._events != null && 
/* 494 */       postEventsForChanges()) {
/* 495 */       this._events.post(IVendor.SET_CONTACT, argContact);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setContact_noev(String argContact) {
/* 502 */     boolean ev_postable = false;
/*     */     
/* 504 */     if ((getDAO_().getContact() == null && argContact != null) || (
/* 505 */       getDAO_().getContact() != null && !getDAO_().getContact().equals(argContact))) {
/* 506 */       getDAO_().setContact(argContact);
/* 507 */       ev_postable = true;
/*     */     } 
/*     */     
/* 510 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getContactTelephone() {
/* 518 */     return getDAO_().getContactTelephone();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setContactTelephone(String argContactTelephone) {
/* 526 */     if (setContactTelephone_noev(argContactTelephone) && 
/* 527 */       this._events != null && 
/* 528 */       postEventsForChanges()) {
/* 529 */       this._events.post(IVendor.SET_CONTACTTELEPHONE, argContactTelephone);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setContactTelephone_noev(String argContactTelephone) {
/* 536 */     boolean ev_postable = false;
/*     */     
/* 538 */     if ((getDAO_().getContactTelephone() == null && argContactTelephone != null) || (
/* 539 */       getDAO_().getContactTelephone() != null && !getDAO_().getContactTelephone().equals(argContactTelephone))) {
/* 540 */       getDAO_().setContactTelephone(argContactTelephone);
/* 541 */       ev_postable = true;
/*     */     } 
/*     */     
/* 544 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getBuyer() {
/* 552 */     return getDAO_().getBuyer();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setBuyer(String argBuyer) {
/* 560 */     if (setBuyer_noev(argBuyer) && 
/* 561 */       this._events != null && 
/* 562 */       postEventsForChanges()) {
/* 563 */       this._events.post(IVendor.SET_BUYER, argBuyer);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setBuyer_noev(String argBuyer) {
/* 570 */     boolean ev_postable = false;
/*     */     
/* 572 */     if ((getDAO_().getBuyer() == null && argBuyer != null) || (
/* 573 */       getDAO_().getBuyer() != null && !getDAO_().getBuyer().equals(argBuyer))) {
/* 574 */       getDAO_().setBuyer(argBuyer);
/* 575 */       ev_postable = true;
/*     */     } 
/*     */     
/* 578 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getStatus() {
/* 586 */     return getDAO_().getStatus();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setStatus(String argStatus) {
/* 594 */     if (setStatus_noev(argStatus) && 
/* 595 */       this._events != null && 
/* 596 */       postEventsForChanges()) {
/* 597 */       this._events.post(IVendor.SET_STATUS, argStatus);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setStatus_noev(String argStatus) {
/* 604 */     boolean ev_postable = false;
/*     */     
/* 606 */     if ((getDAO_().getStatus() == null && argStatus != null) || (
/* 607 */       getDAO_().getStatus() != null && !getDAO_().getStatus().equals(argStatus))) {
/* 608 */       getDAO_().setStatus(argStatus);
/* 609 */       ev_postable = true;
/*     */     } 
/*     */     
/* 612 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getAddressId() {
/* 620 */     return getDAO_().getAddressId();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setAddressId(String argAddressId) {
/* 628 */     if (setAddressId_noev(argAddressId) && 
/* 629 */       this._events != null && 
/* 630 */       postEventsForChanges()) {
/* 631 */       this._events.post(IVendor.SET_ADDRESSID, argAddressId);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setAddressId_noev(String argAddressId) {
/* 638 */     boolean ev_postable = false;
/*     */     
/* 640 */     if ((getDAO_().getAddressId() == null && argAddressId != null) || (
/* 641 */       getDAO_().getAddressId() != null && !getDAO_().getAddressId().equals(argAddressId))) {
/* 642 */       getDAO_().setAddressId(argAddressId);
/* 643 */       ev_postable = true;
/*     */     } 
/*     */     
/* 646 */     return ev_postable;
/*     */   }
/*     */   
/*     */   protected IVendorProperty newProperty(String argPropertyName) {
/* 650 */     VendorPropertyId id = new VendorPropertyId();
/*     */     
/* 652 */     id.setVendorId(getVendorId());
/* 653 */     id.setPropertyCode(argPropertyName);
/*     */     
/* 655 */     IVendorProperty prop = (IVendorProperty)DataFactory.getInstance().createNewObject((IObjectId)id, IVendorProperty.class);
/* 656 */     return prop;
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
/*     */   public IAddress getAddress() {
/* 668 */     return this._address;
/*     */   }
/*     */ 
/*     */   
/*     */   public void setAddress(IAddress argAddress) {
/* 673 */     if (argAddress == null) {
/*     */       
/* 675 */       getDAO_().setAddressId(null);
/* 676 */       if (this._address != null)
/*     */       {
/* 678 */         if (postEventsForChanges()) {
/* 679 */           this._eventManager.deregisterEventHandler((IEventAware)this._eventCascade, (IEventSource)new EventDescriptor(this._address));
/*     */         }
/*     */       }
/*     */     } else {
/*     */       
/* 684 */       getDAO_().setAddressId(argAddress.getAddressId());
/*     */       
/* 686 */       if (postEventsForChanges()) {
/* 687 */         this._eventManager.registerEventHandler((IEventAware)this._eventCascade, (IEventSource)new EventDescriptor(argAddress));
/*     */       }
/*     */     } 
/*     */     
/* 691 */     this._address = argAddress;
/* 692 */     if (postEventsForChanges()) {
/* 693 */       this._events.post(IVendor.SET_ADDRESS, argAddress);
/*     */     }
/*     */   }
/*     */   
/*     */   @Relationship(name = "Properties")
/*     */   public List<IVendorProperty> getProperties() {
/* 699 */     if (this._properties == null) {
/* 700 */       this._properties = new HistoricalList(null);
/*     */     }
/* 702 */     return (List<IVendorProperty>)this._properties;
/*     */   }
/*     */   
/*     */   public void setProperties(List<IVendorProperty> argProperties) {
/* 706 */     if (this._properties == null) {
/* 707 */       this._properties = new HistoricalList(argProperties);
/*     */     } else {
/* 709 */       this._properties.setCurrentList(argProperties);
/*     */     } 
/*     */     
/* 712 */     for (IVendorProperty child : this._properties) {
/* 713 */       VendorPropertyModel model = (VendorPropertyModel)child;
/* 714 */       model.setOrganizationId_noev(getOrganizationId());
/* 715 */       model.setVendorId_noev(getVendorId());
/* 716 */       if (child instanceof IDataModelImpl) {
/* 717 */         IDataAccessObject childDao = ((IDataModelImpl)child).getDAO();
/* 718 */         if (StringUtils.isEmpty(childDao.getOriginDataSource()) && 
/* 719 */           !StringUtils.isEmpty(getDAO().getOriginDataSource())) {
/* 720 */           childDao.setOriginDataSource(getDAO().getOriginDataSource());
/*     */         }
/*     */       } 
/* 723 */       if (postEventsForChanges()) {
/* 724 */         this._eventManager.registerEventHandler((IEventAware)this._eventCascade, (IEventSource)child);
/*     */       }
/*     */     } 
/*     */   }
/*     */   
/*     */   public void addVendorProperty(IVendorProperty argVendorProperty) {
/* 730 */     if (this._properties == null) {
/* 731 */       this._properties = new HistoricalList(null);
/*     */     }
/* 733 */     argVendorProperty.setOrganizationId(getOrganizationId());
/* 734 */     argVendorProperty.setVendorId(getVendorId());
/* 735 */     if (argVendorProperty instanceof IDataModelImpl) {
/* 736 */       IDataAccessObject childDao = ((IDataModelImpl)argVendorProperty).getDAO();
/* 737 */       if (StringUtils.isEmpty(childDao.getOriginDataSource()) && 
/* 738 */         !StringUtils.isEmpty(getDAO().getOriginDataSource())) {
/* 739 */         childDao.setOriginDataSource(getDAO().getOriginDataSource());
/*     */       }
/*     */     } 
/*     */ 
/*     */     
/* 744 */     if (postEventsForChanges()) {
/* 745 */       this._eventManager.registerEventHandler((IEventAware)this._eventCascade, (IEventSource)new EventDescriptor(argVendorProperty));
/*     */     }
/*     */     
/* 748 */     this._properties.add(argVendorProperty);
/* 749 */     if (postEventsForChanges()) {
/* 750 */       this._events.post(IVendor.ADD_PROPERTIES, argVendorProperty);
/*     */     }
/*     */   }
/*     */   
/*     */   public void removeVendorProperty(IVendorProperty argVendorProperty) {
/* 755 */     if (this._properties != null) {
/*     */       
/* 757 */       if (postEventsForChanges()) {
/* 758 */         this._eventManager.deregisterEventHandler((IEventAware)this._eventCascade, (IEventSource)new EventDescriptor(argVendorProperty));
/*     */       }
/* 760 */       this._properties.remove(argVendorProperty);
/* 761 */       if (postEventsForChanges()) {
/* 762 */         this._events.post(IVendor.REMOVE_PROPERTIES, argVendorProperty);
/*     */       }
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public Object getValue(String argFieldId) {
/* 769 */     if ("Address".equals(argFieldId)) {
/* 770 */       return getAddress();
/*     */     }
/* 772 */     if ("Properties".equals(argFieldId)) {
/* 773 */       return getProperties();
/*     */     }
/* 775 */     if ("VendorExtension".equals(argFieldId)) {
/* 776 */       return this._myExtension;
/*     */     }
/*     */     
/* 779 */     return super.getValue(argFieldId);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void setValue(String argFieldId, Object argValue) {
/* 785 */     if ("Address".equals(argFieldId)) {
/* 786 */       setAddress((IAddress)argValue);
/*     */     }
/* 788 */     else if ("Properties".equals(argFieldId)) {
/* 789 */       setProperties(changeToList(argValue, IVendorProperty.class));
/*     */     }
/* 791 */     else if ("VendorExtension".equals(argFieldId)) {
/* 792 */       this._myExtension = (IDataModel)argValue;
/*     */     } else {
/*     */       
/* 795 */       super.setValue(argFieldId, argValue);
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public void setDependencies(IPersistenceDefaults argPD, EventManager argEM) {
/* 801 */     this._persistenceDefaults = argPD;
/* 802 */     this._daoImpl.setPersistenceDefaults(argPD);
/* 803 */     this._eventManager = argEM;
/* 804 */     this._events = (Eventor)new ModelEventor((IDataModel)this, argEM);
/* 805 */     this._eventCascade = (EventHandler)new CascadingHandler(this);
/* 806 */     if (this._address != null) {
/* 807 */       ((IDataModelImpl)this._address).setDependencies(argPD, argEM);
/*     */     }
/* 809 */     if (this._properties != null) {
/* 810 */       for (IVendorProperty relationship : this._properties) {
/* 811 */         ((IDataModelImpl)relationship).setDependencies(argPD, argEM);
/*     */       }
/*     */     }
/*     */   }
/*     */   
/*     */   public IDataModel getVendorExt() {
/* 817 */     return this._myExtension;
/*     */   }
/*     */   
/*     */   public void setVendorExt(IDataModel argExt) {
/* 821 */     this._myExtension = argExt;
/*     */   }
/*     */ 
/*     */   
/*     */   public void startTransaction() {
/* 826 */     if (this._alreadyInStart) {
/*     */       return;
/*     */     }
/*     */     
/* 830 */     this._alreadyInStart = true;
/*     */ 
/*     */     
/* 833 */     super.startTransaction();
/*     */     
/* 835 */     this._addressSavepoint = this._address;
/* 836 */     if (this._address != null) {
/* 837 */       this._address.startTransaction();
/*     */     }
/*     */     
/* 840 */     this._propertiesSavepoint = this._properties;
/* 841 */     if (this._properties != null) {
/* 842 */       this._propertiesSavepoint = new HistoricalList((List)this._properties);
/* 843 */       Iterator<IDataModel> it = this._properties.iterator();
/* 844 */       while (it.hasNext()) {
/* 845 */         ((IDataModel)it.next()).startTransaction();
/*     */       }
/*     */     } 
/*     */ 
/*     */     
/* 850 */     this._alreadyInStart = false;
/*     */   }
/*     */ 
/*     */   
/*     */   public void rollbackChanges() {
/* 855 */     if (isAlreadyRolledBack()) {
/*     */       return;
/*     */     }
/* 858 */     super.rollbackChanges();
/*     */     
/* 860 */     this._address = this._addressSavepoint;
/* 861 */     this._addressSavepoint = null;
/* 862 */     if (this._address != null) {
/* 863 */       this._address.rollbackChanges();
/*     */     }
/*     */     
/* 866 */     this._properties = this._propertiesSavepoint;
/* 867 */     this._propertiesSavepoint = null;
/* 868 */     if (this._properties != null) {
/* 869 */       Iterator<IDataModel> it = this._properties.iterator();
/* 870 */       while (it.hasNext()) {
/* 871 */         ((IDataModel)it.next()).rollbackChanges();
/*     */       }
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void commitTransaction() {
/* 879 */     if (this._alreadyInCommit) {
/*     */       return;
/*     */     }
/* 882 */     this._alreadyInCommit = true;
/*     */ 
/*     */     
/* 885 */     super.commitTransaction();
/*     */     
/* 887 */     this._addressSavepoint = this._address;
/* 888 */     if (this._address != null) {
/* 889 */       this._address.commitTransaction();
/*     */     }
/*     */     
/* 892 */     this._propertiesSavepoint = this._properties;
/* 893 */     if (this._properties != null) {
/* 894 */       Iterator<IDataModel> it = this._properties.iterator();
/* 895 */       while (it.hasNext()) {
/* 896 */         ((IDataModel)it.next()).commitTransaction();
/*     */       }
/* 898 */       this._properties = new HistoricalList((List)this._properties);
/*     */     } 
/*     */ 
/*     */     
/* 902 */     this._alreadyInCommit = false;
/*     */   }
/*     */ 
/*     */   
/*     */   private void readObject(ObjectInputStream argStream) throws IOException, ClassNotFoundException {
/* 907 */     argStream.defaultReadObject();
/*     */   }
/*     */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\itm\impl\VendorModel.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */