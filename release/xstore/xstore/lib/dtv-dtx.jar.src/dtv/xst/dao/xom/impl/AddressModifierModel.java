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
/*     */ import dtv.event.handler.CascadingHandler;
/*     */ import dtv.util.HistoricalList;
/*     */ import dtv.util.StringUtils;
/*     */ import dtv.xst.dao.xom.AddressModifierPropertyId;
/*     */ import dtv.xst.dao.xom.IAddressModifier;
/*     */ import dtv.xst.dao.xom.IAddressModifierProperty;
/*     */ import java.io.IOException;
/*     */ import java.io.ObjectInputStream;
/*     */ import java.util.Date;
/*     */ import java.util.Iterator;
/*     */ import java.util.List;
/*     */ 
/*     */ public class AddressModifierModel extends AbstractDataModelWithPropertyImpl<IAddressModifierProperty> implements IAddressModifier {
/*     */   private static final long serialVersionUID = -1732016437L;
/*     */   private transient boolean _alreadyInStart = false;
/*     */   private transient boolean _alreadyInCommit = false;
/*     */   
/*     */   public String toString() {
/*  33 */     return super.toString() + " Id: " + getObjectId();
/*     */   }
/*     */   private IDataModel _myExtension; private HistoricalList<IAddressModifierProperty> _properties; private transient HistoricalList<IAddressModifierProperty> _propertiesSavepoint;
/*     */   
/*     */   public void initDAO() {
/*  38 */     setDAO((IDataAccessObject)new AddressModifierDAO());
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private AddressModifierDAO getDAO_() {
/*  46 */     return (AddressModifierDAO)this._daoImpl;
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
/*  70 */       this._events.post(IAddressModifier.SET_ORGANIZATIONID, Long.valueOf(argOrganizationId));
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
/*  85 */         Iterator<AddressModifierPropertyModel> it = this._properties.iterator();
/*  86 */         while (it.hasNext())
/*     */         {
/*  88 */           ((AddressModifierPropertyModel)it.next()).setOrganizationId_noev(argOrganizationId);
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
/*     */   public String getOrderId() {
/* 101 */     return getDAO_().getOrderId();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setOrderId(String argOrderId) {
/* 109 */     if (setOrderId_noev(argOrderId) && 
/* 110 */       this._events != null && 
/* 111 */       postEventsForChanges()) {
/* 112 */       this._events.post(IAddressModifier.SET_ORDERID, argOrderId);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setOrderId_noev(String argOrderId) {
/* 119 */     boolean ev_postable = false;
/*     */     
/* 121 */     if ((getDAO_().getOrderId() == null && argOrderId != null) || (
/* 122 */       getDAO_().getOrderId() != null && !getDAO_().getOrderId().equals(argOrderId))) {
/* 123 */       getDAO_().setOrderId(argOrderId);
/* 124 */       ev_postable = true;
/* 125 */       if (this._properties != null) {
/*     */         
/* 127 */         Iterator<AddressModifierPropertyModel> it = this._properties.iterator();
/* 128 */         while (it.hasNext())
/*     */         {
/* 130 */           ((AddressModifierPropertyModel)it.next()).setOrderId_noev(argOrderId);
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
/*     */   public long getSequence() {
/* 143 */     if (getDAO_().getSequence() != null) {
/* 144 */       return getDAO_().getSequence().longValue();
/*     */     }
/*     */     
/* 147 */     return 0L;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setSequence(long argSequence) {
/* 156 */     if (setSequence_noev(argSequence) && 
/* 157 */       this._events != null && 
/* 158 */       postEventsForChanges()) {
/* 159 */       this._events.post(IAddressModifier.SET_SEQUENCE, Long.valueOf(argSequence));
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setSequence_noev(long argSequence) {
/* 166 */     boolean ev_postable = false;
/*     */     
/* 168 */     if ((getDAO_().getSequence() == null && Long.valueOf(argSequence) != null) || (
/* 169 */       getDAO_().getSequence() != null && !getDAO_().getSequence().equals(Long.valueOf(argSequence)))) {
/* 170 */       getDAO_().setSequence(Long.valueOf(argSequence));
/* 171 */       ev_postable = true;
/* 172 */       if (this._properties != null) {
/*     */         
/* 174 */         Iterator<AddressModifierPropertyModel> it = this._properties.iterator();
/* 175 */         while (it.hasNext())
/*     */         {
/* 177 */           ((AddressModifierPropertyModel)it.next()).setSequence_noev(argSequence);
/*     */         }
/*     */       } 
/*     */     } 
/*     */     
/* 182 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Date getCreateDate() {
/* 190 */     return getDAO_().getCreateDate();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setCreateDate(Date argCreateDate) {
/* 198 */     if (setCreateDate_noev(argCreateDate) && 
/* 199 */       this._events != null && 
/* 200 */       postEventsForChanges()) {
/* 201 */       this._events.post(IAddressModifier.SET_CREATEDATE, argCreateDate);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setCreateDate_noev(Date argCreateDate) {
/* 208 */     boolean ev_postable = false;
/*     */     
/* 210 */     if ((getDAO_().getCreateDate() == null && argCreateDate != null) || (
/* 211 */       getDAO_().getCreateDate() != null && !getDAO_().getCreateDate().equals(argCreateDate))) {
/* 212 */       getDAO_().setCreateDate(argCreateDate);
/* 213 */       ev_postable = true;
/*     */     } 
/*     */     
/* 216 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getCreateUserId() {
/* 224 */     return getDAO_().getCreateUserId();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setCreateUserId(String argCreateUserId) {
/* 232 */     if (setCreateUserId_noev(argCreateUserId) && 
/* 233 */       this._events != null && 
/* 234 */       postEventsForChanges()) {
/* 235 */       this._events.post(IAddressModifier.SET_CREATEUSERID, argCreateUserId);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setCreateUserId_noev(String argCreateUserId) {
/* 242 */     boolean ev_postable = false;
/*     */     
/* 244 */     if ((getDAO_().getCreateUserId() == null && argCreateUserId != null) || (
/* 245 */       getDAO_().getCreateUserId() != null && !getDAO_().getCreateUserId().equals(argCreateUserId))) {
/* 246 */       getDAO_().setCreateUserId(argCreateUserId);
/* 247 */       ev_postable = true;
/*     */     } 
/*     */     
/* 250 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Date getUpdateDate() {
/* 258 */     return getDAO_().getUpdateDate();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setUpdateDate(Date argUpdateDate) {
/* 266 */     if (setUpdateDate_noev(argUpdateDate) && 
/* 267 */       this._events != null && 
/* 268 */       postEventsForChanges()) {
/* 269 */       this._events.post(IAddressModifier.SET_UPDATEDATE, argUpdateDate);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setUpdateDate_noev(Date argUpdateDate) {
/* 276 */     boolean ev_postable = false;
/*     */     
/* 278 */     if ((getDAO_().getUpdateDate() == null && argUpdateDate != null) || (
/* 279 */       getDAO_().getUpdateDate() != null && !getDAO_().getUpdateDate().equals(argUpdateDate))) {
/* 280 */       getDAO_().setUpdateDate(argUpdateDate);
/* 281 */       ev_postable = true;
/*     */     } 
/*     */     
/* 284 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getUpdateUserId() {
/* 292 */     return getDAO_().getUpdateUserId();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setUpdateUserId(String argUpdateUserId) {
/* 300 */     if (setUpdateUserId_noev(argUpdateUserId) && 
/* 301 */       this._events != null && 
/* 302 */       postEventsForChanges()) {
/* 303 */       this._events.post(IAddressModifier.SET_UPDATEUSERID, argUpdateUserId);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setUpdateUserId_noev(String argUpdateUserId) {
/* 310 */     boolean ev_postable = false;
/*     */     
/* 312 */     if ((getDAO_().getUpdateUserId() == null && argUpdateUserId != null) || (
/* 313 */       getDAO_().getUpdateUserId() != null && !getDAO_().getUpdateUserId().equals(argUpdateUserId))) {
/* 314 */       getDAO_().setUpdateUserId(argUpdateUserId);
/* 315 */       ev_postable = true;
/*     */     } 
/*     */     
/* 318 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getAddress1() {
/* 326 */     return getDAO_().getAddress1();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setAddress1(String argAddress1) {
/* 334 */     if (setAddress1_noev(argAddress1) && 
/* 335 */       this._events != null && 
/* 336 */       postEventsForChanges()) {
/* 337 */       this._events.post(IAddressModifier.SET_ADDRESS1, argAddress1);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setAddress1_noev(String argAddress1) {
/* 344 */     boolean ev_postable = false;
/*     */     
/* 346 */     if ((getDAO_().getAddress1() == null && argAddress1 != null) || (
/* 347 */       getDAO_().getAddress1() != null && !getDAO_().getAddress1().equals(argAddress1))) {
/* 348 */       getDAO_().setAddress1(argAddress1);
/* 349 */       ev_postable = true;
/*     */     } 
/*     */     
/* 352 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getAddress2() {
/* 360 */     return getDAO_().getAddress2();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setAddress2(String argAddress2) {
/* 368 */     if (setAddress2_noev(argAddress2) && 
/* 369 */       this._events != null && 
/* 370 */       postEventsForChanges()) {
/* 371 */       this._events.post(IAddressModifier.SET_ADDRESS2, argAddress2);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setAddress2_noev(String argAddress2) {
/* 378 */     boolean ev_postable = false;
/*     */     
/* 380 */     if ((getDAO_().getAddress2() == null && argAddress2 != null) || (
/* 381 */       getDAO_().getAddress2() != null && !getDAO_().getAddress2().equals(argAddress2))) {
/* 382 */       getDAO_().setAddress2(argAddress2);
/* 383 */       ev_postable = true;
/*     */     } 
/*     */     
/* 386 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getAddress3() {
/* 394 */     return getDAO_().getAddress3();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setAddress3(String argAddress3) {
/* 402 */     if (setAddress3_noev(argAddress3) && 
/* 403 */       this._events != null && 
/* 404 */       postEventsForChanges()) {
/* 405 */       this._events.post(IAddressModifier.SET_ADDRESS3, argAddress3);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setAddress3_noev(String argAddress3) {
/* 412 */     boolean ev_postable = false;
/*     */     
/* 414 */     if ((getDAO_().getAddress3() == null && argAddress3 != null) || (
/* 415 */       getDAO_().getAddress3() != null && !getDAO_().getAddress3().equals(argAddress3))) {
/* 416 */       getDAO_().setAddress3(argAddress3);
/* 417 */       ev_postable = true;
/*     */     } 
/*     */     
/* 420 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getAddress4() {
/* 428 */     return getDAO_().getAddress4();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setAddress4(String argAddress4) {
/* 436 */     if (setAddress4_noev(argAddress4) && 
/* 437 */       this._events != null && 
/* 438 */       postEventsForChanges()) {
/* 439 */       this._events.post(IAddressModifier.SET_ADDRESS4, argAddress4);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setAddress4_noev(String argAddress4) {
/* 446 */     boolean ev_postable = false;
/*     */     
/* 448 */     if ((getDAO_().getAddress4() == null && argAddress4 != null) || (
/* 449 */       getDAO_().getAddress4() != null && !getDAO_().getAddress4().equals(argAddress4))) {
/* 450 */       getDAO_().setAddress4(argAddress4);
/* 451 */       ev_postable = true;
/*     */     } 
/*     */     
/* 454 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getApartment() {
/* 462 */     return getDAO_().getApartment();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setApartment(String argApartment) {
/* 470 */     if (setApartment_noev(argApartment) && 
/* 471 */       this._events != null && 
/* 472 */       postEventsForChanges()) {
/* 473 */       this._events.post(IAddressModifier.SET_APARTMENT, argApartment);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setApartment_noev(String argApartment) {
/* 480 */     boolean ev_postable = false;
/*     */     
/* 482 */     if ((getDAO_().getApartment() == null && argApartment != null) || (
/* 483 */       getDAO_().getApartment() != null && !getDAO_().getApartment().equals(argApartment))) {
/* 484 */       getDAO_().setApartment(argApartment);
/* 485 */       ev_postable = true;
/*     */     } 
/*     */     
/* 488 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getCity() {
/* 496 */     return getDAO_().getCity();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setCity(String argCity) {
/* 504 */     if (setCity_noev(argCity) && 
/* 505 */       this._events != null && 
/* 506 */       postEventsForChanges()) {
/* 507 */       this._events.post(IAddressModifier.SET_CITY, argCity);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setCity_noev(String argCity) {
/* 514 */     boolean ev_postable = false;
/*     */     
/* 516 */     if ((getDAO_().getCity() == null && argCity != null) || (
/* 517 */       getDAO_().getCity() != null && !getDAO_().getCity().equals(argCity))) {
/* 518 */       getDAO_().setCity(argCity);
/* 519 */       ev_postable = true;
/*     */     } 
/*     */     
/* 522 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getState() {
/* 530 */     return getDAO_().getState();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setState(String argState) {
/* 538 */     if (setState_noev(argState) && 
/* 539 */       this._events != null && 
/* 540 */       postEventsForChanges()) {
/* 541 */       this._events.post(IAddressModifier.SET_STATE, argState);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setState_noev(String argState) {
/* 548 */     boolean ev_postable = false;
/*     */     
/* 550 */     if ((getDAO_().getState() == null && argState != null) || (
/* 551 */       getDAO_().getState() != null && !getDAO_().getState().equals(argState))) {
/* 552 */       getDAO_().setState(argState);
/* 553 */       ev_postable = true;
/*     */     } 
/*     */     
/* 556 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getPostalCode() {
/* 564 */     return getDAO_().getPostalCode();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setPostalCode(String argPostalCode) {
/* 572 */     if (setPostalCode_noev(argPostalCode) && 
/* 573 */       this._events != null && 
/* 574 */       postEventsForChanges()) {
/* 575 */       this._events.post(IAddressModifier.SET_POSTALCODE, argPostalCode);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setPostalCode_noev(String argPostalCode) {
/* 582 */     boolean ev_postable = false;
/*     */     
/* 584 */     if ((getDAO_().getPostalCode() == null && argPostalCode != null) || (
/* 585 */       getDAO_().getPostalCode() != null && !getDAO_().getPostalCode().equals(argPostalCode))) {
/* 586 */       getDAO_().setPostalCode(argPostalCode);
/* 587 */       ev_postable = true;
/*     */     } 
/*     */     
/* 590 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getCountry() {
/* 598 */     return getDAO_().getCountry();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setCountry(String argCountry) {
/* 606 */     if (setCountry_noev(argCountry) && 
/* 607 */       this._events != null && 
/* 608 */       postEventsForChanges()) {
/* 609 */       this._events.post(IAddressModifier.SET_COUNTRY, argCountry);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setCountry_noev(String argCountry) {
/* 616 */     boolean ev_postable = false;
/*     */     
/* 618 */     if ((getDAO_().getCountry() == null && argCountry != null) || (
/* 619 */       getDAO_().getCountry() != null && !getDAO_().getCountry().equals(argCountry))) {
/* 620 */       getDAO_().setCountry(argCountry);
/* 621 */       ev_postable = true;
/*     */     } 
/*     */     
/* 624 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getNeighborhood() {
/* 632 */     return getDAO_().getNeighborhood();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setNeighborhood(String argNeighborhood) {
/* 640 */     if (setNeighborhood_noev(argNeighborhood) && 
/* 641 */       this._events != null && 
/* 642 */       postEventsForChanges()) {
/* 643 */       this._events.post(IAddressModifier.SET_NEIGHBORHOOD, argNeighborhood);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setNeighborhood_noev(String argNeighborhood) {
/* 650 */     boolean ev_postable = false;
/*     */     
/* 652 */     if ((getDAO_().getNeighborhood() == null && argNeighborhood != null) || (
/* 653 */       getDAO_().getNeighborhood() != null && !getDAO_().getNeighborhood().equals(argNeighborhood))) {
/* 654 */       getDAO_().setNeighborhood(argNeighborhood);
/* 655 */       ev_postable = true;
/*     */     } 
/*     */     
/* 658 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getCounty() {
/* 666 */     return getDAO_().getCounty();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setCounty(String argCounty) {
/* 674 */     if (setCounty_noev(argCounty) && 
/* 675 */       this._events != null && 
/* 676 */       postEventsForChanges()) {
/* 677 */       this._events.post(IAddressModifier.SET_COUNTY, argCounty);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setCounty_noev(String argCounty) {
/* 684 */     boolean ev_postable = false;
/*     */     
/* 686 */     if ((getDAO_().getCounty() == null && argCounty != null) || (
/* 687 */       getDAO_().getCounty() != null && !getDAO_().getCounty().equals(argCounty))) {
/* 688 */       getDAO_().setCounty(argCounty);
/* 689 */       ev_postable = true;
/*     */     } 
/*     */     
/* 692 */     return ev_postable;
/*     */   }
/*     */   
/*     */   protected IAddressModifierProperty newProperty(String argPropertyName) {
/* 696 */     AddressModifierPropertyId id = new AddressModifierPropertyId();
/*     */     
/* 698 */     id.setOrderId(getOrderId());
/* 699 */     id.setSequence(Long.valueOf(getSequence()));
/* 700 */     id.setPropertyCode(argPropertyName);
/*     */     
/* 702 */     IAddressModifierProperty prop = (IAddressModifierProperty)DataFactory.getInstance().createNewObject((IObjectId)id, IAddressModifierProperty.class);
/* 703 */     return prop;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @Relationship(name = "Properties")
/*     */   public List<IAddressModifierProperty> getProperties() {
/* 712 */     if (this._properties == null) {
/* 713 */       this._properties = new HistoricalList(null);
/*     */     }
/* 715 */     return (List<IAddressModifierProperty>)this._properties;
/*     */   }
/*     */   
/*     */   public void setProperties(List<IAddressModifierProperty> argProperties) {
/* 719 */     if (this._properties == null) {
/* 720 */       this._properties = new HistoricalList(argProperties);
/*     */     } else {
/* 722 */       this._properties.setCurrentList(argProperties);
/*     */     } 
/*     */     
/* 725 */     for (IAddressModifierProperty child : this._properties) {
/* 726 */       AddressModifierPropertyModel model = (AddressModifierPropertyModel)child;
/* 727 */       model.setOrganizationId_noev(getOrganizationId());
/* 728 */       model.setOrderId_noev(getOrderId());
/* 729 */       model.setSequence_noev(getSequence());
/* 730 */       if (child instanceof IDataModelImpl) {
/* 731 */         IDataAccessObject childDao = ((IDataModelImpl)child).getDAO();
/* 732 */         if (StringUtils.isEmpty(childDao.getOriginDataSource()) && 
/* 733 */           !StringUtils.isEmpty(getDAO().getOriginDataSource())) {
/* 734 */           childDao.setOriginDataSource(getDAO().getOriginDataSource());
/*     */         }
/*     */       } 
/* 737 */       if (postEventsForChanges()) {
/* 738 */         this._eventManager.registerEventHandler((IEventAware)this._eventCascade, (IEventSource)child);
/*     */       }
/*     */     } 
/*     */   }
/*     */   
/*     */   public void addAddressModifierProperty(IAddressModifierProperty argAddressModifierProperty) {
/* 744 */     if (this._properties == null) {
/* 745 */       this._properties = new HistoricalList(null);
/*     */     }
/* 747 */     argAddressModifierProperty.setOrganizationId(getOrganizationId());
/* 748 */     argAddressModifierProperty.setOrderId(getOrderId());
/* 749 */     argAddressModifierProperty.setSequence(getSequence());
/* 750 */     if (argAddressModifierProperty instanceof IDataModelImpl) {
/* 751 */       IDataAccessObject childDao = ((IDataModelImpl)argAddressModifierProperty).getDAO();
/* 752 */       if (StringUtils.isEmpty(childDao.getOriginDataSource()) && 
/* 753 */         !StringUtils.isEmpty(getDAO().getOriginDataSource())) {
/* 754 */         childDao.setOriginDataSource(getDAO().getOriginDataSource());
/*     */       }
/*     */     } 
/*     */ 
/*     */     
/* 759 */     if (postEventsForChanges()) {
/* 760 */       this._eventManager.registerEventHandler((IEventAware)this._eventCascade, (IEventSource)new EventDescriptor(argAddressModifierProperty));
/*     */     }
/*     */     
/* 763 */     this._properties.add(argAddressModifierProperty);
/* 764 */     if (postEventsForChanges()) {
/* 765 */       this._events.post(IAddressModifier.ADD_PROPERTIES, argAddressModifierProperty);
/*     */     }
/*     */   }
/*     */   
/*     */   public void removeAddressModifierProperty(IAddressModifierProperty argAddressModifierProperty) {
/* 770 */     if (this._properties != null) {
/*     */       
/* 772 */       if (postEventsForChanges()) {
/* 773 */         this._eventManager.deregisterEventHandler((IEventAware)this._eventCascade, (IEventSource)new EventDescriptor(argAddressModifierProperty));
/*     */       }
/* 775 */       this._properties.remove(argAddressModifierProperty);
/* 776 */       if (postEventsForChanges()) {
/* 777 */         this._events.post(IAddressModifier.REMOVE_PROPERTIES, argAddressModifierProperty);
/*     */       }
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public Object getValue(String argFieldId) {
/* 784 */     if ("Properties".equals(argFieldId)) {
/* 785 */       return getProperties();
/*     */     }
/* 787 */     if ("AddressModifierExtension".equals(argFieldId)) {
/* 788 */       return this._myExtension;
/*     */     }
/*     */     
/* 791 */     return super.getValue(argFieldId);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void setValue(String argFieldId, Object argValue) {
/* 797 */     if ("Properties".equals(argFieldId)) {
/* 798 */       setProperties(changeToList(argValue, IAddressModifierProperty.class));
/*     */     }
/* 800 */     else if ("AddressModifierExtension".equals(argFieldId)) {
/* 801 */       this._myExtension = (IDataModel)argValue;
/*     */     } else {
/*     */       
/* 804 */       super.setValue(argFieldId, argValue);
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public void setDependencies(IPersistenceDefaults argPD, EventManager argEM) {
/* 810 */     this._persistenceDefaults = argPD;
/* 811 */     this._daoImpl.setPersistenceDefaults(argPD);
/* 812 */     this._eventManager = argEM;
/* 813 */     this._events = (Eventor)new ModelEventor((IDataModel)this, argEM);
/* 814 */     this._eventCascade = (EventHandler)new CascadingHandler(this);
/* 815 */     if (this._properties != null) {
/* 816 */       for (IAddressModifierProperty relationship : this._properties) {
/* 817 */         ((IDataModelImpl)relationship).setDependencies(argPD, argEM);
/*     */       }
/*     */     }
/*     */   }
/*     */   
/*     */   public IDataModel getAddressModifierExt() {
/* 823 */     return this._myExtension;
/*     */   }
/*     */   
/*     */   public void setAddressModifierExt(IDataModel argExt) {
/* 827 */     this._myExtension = argExt;
/*     */   }
/*     */ 
/*     */   
/*     */   public void startTransaction() {
/* 832 */     if (this._alreadyInStart) {
/*     */       return;
/*     */     }
/*     */     
/* 836 */     this._alreadyInStart = true;
/*     */ 
/*     */     
/* 839 */     super.startTransaction();
/*     */     
/* 841 */     this._propertiesSavepoint = this._properties;
/* 842 */     if (this._properties != null) {
/* 843 */       this._propertiesSavepoint = new HistoricalList((List)this._properties);
/* 844 */       Iterator<IDataModel> it = this._properties.iterator();
/* 845 */       while (it.hasNext()) {
/* 846 */         ((IDataModel)it.next()).startTransaction();
/*     */       }
/*     */     } 
/*     */ 
/*     */     
/* 851 */     this._alreadyInStart = false;
/*     */   }
/*     */ 
/*     */   
/*     */   public void rollbackChanges() {
/* 856 */     if (isAlreadyRolledBack()) {
/*     */       return;
/*     */     }
/* 859 */     super.rollbackChanges();
/*     */     
/* 861 */     this._properties = this._propertiesSavepoint;
/* 862 */     this._propertiesSavepoint = null;
/* 863 */     if (this._properties != null) {
/* 864 */       Iterator<IDataModel> it = this._properties.iterator();
/* 865 */       while (it.hasNext()) {
/* 866 */         ((IDataModel)it.next()).rollbackChanges();
/*     */       }
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void commitTransaction() {
/* 874 */     if (this._alreadyInCommit) {
/*     */       return;
/*     */     }
/* 877 */     this._alreadyInCommit = true;
/*     */ 
/*     */     
/* 880 */     super.commitTransaction();
/*     */     
/* 882 */     this._propertiesSavepoint = this._properties;
/* 883 */     if (this._properties != null) {
/* 884 */       Iterator<IDataModel> it = this._properties.iterator();
/* 885 */       while (it.hasNext()) {
/* 886 */         ((IDataModel)it.next()).commitTransaction();
/*     */       }
/* 888 */       this._properties = new HistoricalList((List)this._properties);
/*     */     } 
/*     */ 
/*     */     
/* 892 */     this._alreadyInCommit = false;
/*     */   }
/*     */ 
/*     */   
/*     */   private void readObject(ObjectInputStream argStream) throws IOException, ClassNotFoundException {
/* 897 */     argStream.defaultReadObject();
/*     */   }
/*     */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\xom\impl\AddressModifierModel.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */