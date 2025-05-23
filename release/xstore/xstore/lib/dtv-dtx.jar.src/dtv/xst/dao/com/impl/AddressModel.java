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
/*     */ import dtv.xst.dao.com.AddressPropertyId;
/*     */ import dtv.xst.dao.com.IAddress;
/*     */ import dtv.xst.dao.com.IAddressProperty;
/*     */ import java.io.IOException;
/*     */ import java.io.ObjectInputStream;
/*     */ import java.util.Date;
/*     */ import java.util.Iterator;
/*     */ import java.util.List;
/*     */ 
/*     */ public class AddressModel extends AbstractDataModelWithPropertyImpl<IAddressProperty> implements IAddress {
/*     */   private static final long serialVersionUID = 516961236L;
/*     */   private transient boolean _alreadyInStart = false;
/*     */   private transient boolean _alreadyInCommit = false;
/*     */   
/*     */   public String toString() {
/*  33 */     return super.toString() + " Id: " + getObjectId();
/*     */   }
/*     */   private IDataModel _myExtension; private HistoricalList<IAddressProperty> _properties; private transient HistoricalList<IAddressProperty> _propertiesSavepoint;
/*     */   
/*     */   public void initDAO() {
/*  38 */     setDAO((IDataAccessObject)new AddressDAO());
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private AddressDAO getDAO_() {
/*  46 */     return (AddressDAO)this._daoImpl;
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
/*  70 */       this._events.post(IAddress.SET_ORGANIZATIONID, Long.valueOf(argOrganizationId));
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
/*  85 */         Iterator<AddressPropertyModel> it = this._properties.iterator();
/*  86 */         while (it.hasNext())
/*     */         {
/*  88 */           ((AddressPropertyModel)it.next()).setOrganizationId_noev(argOrganizationId);
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
/*     */   public String getAddressId() {
/* 101 */     return getDAO_().getAddressId();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setAddressId(String argAddressId) {
/* 109 */     if (setAddressId_noev(argAddressId) && 
/* 110 */       this._events != null && 
/* 111 */       postEventsForChanges()) {
/* 112 */       this._events.post(IAddress.SET_ADDRESSID, argAddressId);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setAddressId_noev(String argAddressId) {
/* 119 */     boolean ev_postable = false;
/*     */     
/* 121 */     if ((getDAO_().getAddressId() == null && argAddressId != null) || (
/* 122 */       getDAO_().getAddressId() != null && !getDAO_().getAddressId().equals(argAddressId))) {
/* 123 */       getDAO_().setAddressId(argAddressId);
/* 124 */       ev_postable = true;
/* 125 */       if (this._properties != null) {
/*     */         
/* 127 */         Iterator<AddressPropertyModel> it = this._properties.iterator();
/* 128 */         while (it.hasNext())
/*     */         {
/* 130 */           ((AddressPropertyModel)it.next()).setAddressId_noev(argAddressId);
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
/* 154 */       this._events.post(IAddress.SET_CREATEDATE, argCreateDate);
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
/* 188 */       this._events.post(IAddress.SET_CREATEUSERID, argCreateUserId);
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
/* 222 */       this._events.post(IAddress.SET_UPDATEDATE, argUpdateDate);
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
/* 256 */       this._events.post(IAddress.SET_UPDATEUSERID, argUpdateUserId);
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
/*     */   public String getOrgCode() {
/* 279 */     return getDAO_().getOrgCode();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setOrgCode(String argOrgCode) {
/* 287 */     if (setOrgCode_noev(argOrgCode) && 
/* 288 */       this._events != null && 
/* 289 */       postEventsForChanges()) {
/* 290 */       this._events.post(IAddress.SET_ORGCODE, argOrgCode);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setOrgCode_noev(String argOrgCode) {
/* 297 */     boolean ev_postable = false;
/*     */     
/* 299 */     if ((getDAO_().getOrgCode() == null && argOrgCode != null) || (
/* 300 */       getDAO_().getOrgCode() != null && !getDAO_().getOrgCode().equals(argOrgCode))) {
/* 301 */       getDAO_().setOrgCode(argOrgCode);
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
/*     */   public String getOrgValue() {
/* 313 */     return getDAO_().getOrgValue();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setOrgValue(String argOrgValue) {
/* 321 */     if (setOrgValue_noev(argOrgValue) && 
/* 322 */       this._events != null && 
/* 323 */       postEventsForChanges()) {
/* 324 */       this._events.post(IAddress.SET_ORGVALUE, argOrgValue);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setOrgValue_noev(String argOrgValue) {
/* 331 */     boolean ev_postable = false;
/*     */     
/* 333 */     if ((getDAO_().getOrgValue() == null && argOrgValue != null) || (
/* 334 */       getDAO_().getOrgValue() != null && !getDAO_().getOrgValue().equals(argOrgValue))) {
/* 335 */       getDAO_().setOrgValue(argOrgValue);
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
/*     */   public String getAddress1() {
/* 347 */     return getDAO_().getAddress1();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setAddress1(String argAddress1) {
/* 355 */     if (setAddress1_noev(argAddress1) && 
/* 356 */       this._events != null && 
/* 357 */       postEventsForChanges()) {
/* 358 */       this._events.post(IAddress.SET_ADDRESS1, argAddress1);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setAddress1_noev(String argAddress1) {
/* 365 */     boolean ev_postable = false;
/*     */     
/* 367 */     if ((getDAO_().getAddress1() == null && argAddress1 != null) || (
/* 368 */       getDAO_().getAddress1() != null && !getDAO_().getAddress1().equals(argAddress1))) {
/* 369 */       getDAO_().setAddress1(argAddress1);
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
/*     */   public String getAddress2() {
/* 381 */     return getDAO_().getAddress2();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setAddress2(String argAddress2) {
/* 389 */     if (setAddress2_noev(argAddress2) && 
/* 390 */       this._events != null && 
/* 391 */       postEventsForChanges()) {
/* 392 */       this._events.post(IAddress.SET_ADDRESS2, argAddress2);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setAddress2_noev(String argAddress2) {
/* 399 */     boolean ev_postable = false;
/*     */     
/* 401 */     if ((getDAO_().getAddress2() == null && argAddress2 != null) || (
/* 402 */       getDAO_().getAddress2() != null && !getDAO_().getAddress2().equals(argAddress2))) {
/* 403 */       getDAO_().setAddress2(argAddress2);
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
/*     */   public String getAddress3() {
/* 415 */     return getDAO_().getAddress3();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setAddress3(String argAddress3) {
/* 423 */     if (setAddress3_noev(argAddress3) && 
/* 424 */       this._events != null && 
/* 425 */       postEventsForChanges()) {
/* 426 */       this._events.post(IAddress.SET_ADDRESS3, argAddress3);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setAddress3_noev(String argAddress3) {
/* 433 */     boolean ev_postable = false;
/*     */     
/* 435 */     if ((getDAO_().getAddress3() == null && argAddress3 != null) || (
/* 436 */       getDAO_().getAddress3() != null && !getDAO_().getAddress3().equals(argAddress3))) {
/* 437 */       getDAO_().setAddress3(argAddress3);
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
/*     */   public String getAddress4() {
/* 449 */     return getDAO_().getAddress4();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setAddress4(String argAddress4) {
/* 457 */     if (setAddress4_noev(argAddress4) && 
/* 458 */       this._events != null && 
/* 459 */       postEventsForChanges()) {
/* 460 */       this._events.post(IAddress.SET_ADDRESS4, argAddress4);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setAddress4_noev(String argAddress4) {
/* 467 */     boolean ev_postable = false;
/*     */     
/* 469 */     if ((getDAO_().getAddress4() == null && argAddress4 != null) || (
/* 470 */       getDAO_().getAddress4() != null && !getDAO_().getAddress4().equals(argAddress4))) {
/* 471 */       getDAO_().setAddress4(argAddress4);
/* 472 */       ev_postable = true;
/*     */     } 
/*     */     
/* 475 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getApartment() {
/* 483 */     return getDAO_().getApartment();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setApartment(String argApartment) {
/* 491 */     if (setApartment_noev(argApartment) && 
/* 492 */       this._events != null && 
/* 493 */       postEventsForChanges()) {
/* 494 */       this._events.post(IAddress.SET_APARTMENT, argApartment);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setApartment_noev(String argApartment) {
/* 501 */     boolean ev_postable = false;
/*     */     
/* 503 */     if ((getDAO_().getApartment() == null && argApartment != null) || (
/* 504 */       getDAO_().getApartment() != null && !getDAO_().getApartment().equals(argApartment))) {
/* 505 */       getDAO_().setApartment(argApartment);
/* 506 */       ev_postable = true;
/*     */     } 
/*     */     
/* 509 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getCity() {
/* 517 */     return getDAO_().getCity();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setCity(String argCity) {
/* 525 */     if (setCity_noev(argCity) && 
/* 526 */       this._events != null && 
/* 527 */       postEventsForChanges()) {
/* 528 */       this._events.post(IAddress.SET_CITY, argCity);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setCity_noev(String argCity) {
/* 535 */     boolean ev_postable = false;
/*     */     
/* 537 */     if ((getDAO_().getCity() == null && argCity != null) || (
/* 538 */       getDAO_().getCity() != null && !getDAO_().getCity().equals(argCity))) {
/* 539 */       getDAO_().setCity(argCity);
/* 540 */       ev_postable = true;
/*     */     } 
/*     */     
/* 543 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getState() {
/* 551 */     return getDAO_().getState();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setState(String argState) {
/* 559 */     if (setState_noev(argState) && 
/* 560 */       this._events != null && 
/* 561 */       postEventsForChanges()) {
/* 562 */       this._events.post(IAddress.SET_STATE, argState);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setState_noev(String argState) {
/* 569 */     boolean ev_postable = false;
/*     */     
/* 571 */     if ((getDAO_().getState() == null && argState != null) || (
/* 572 */       getDAO_().getState() != null && !getDAO_().getState().equals(argState))) {
/* 573 */       getDAO_().setState(argState);
/* 574 */       ev_postable = true;
/*     */     } 
/*     */     
/* 577 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getPostalCode() {
/* 585 */     return getDAO_().getPostalCode();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setPostalCode(String argPostalCode) {
/* 593 */     if (setPostalCode_noev(argPostalCode) && 
/* 594 */       this._events != null && 
/* 595 */       postEventsForChanges()) {
/* 596 */       this._events.post(IAddress.SET_POSTALCODE, argPostalCode);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setPostalCode_noev(String argPostalCode) {
/* 603 */     boolean ev_postable = false;
/*     */     
/* 605 */     if ((getDAO_().getPostalCode() == null && argPostalCode != null) || (
/* 606 */       getDAO_().getPostalCode() != null && !getDAO_().getPostalCode().equals(argPostalCode))) {
/* 607 */       getDAO_().setPostalCode(argPostalCode);
/* 608 */       ev_postable = true;
/*     */     } 
/*     */     
/* 611 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getCountry() {
/* 619 */     return getDAO_().getCountry();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setCountry(String argCountry) {
/* 627 */     if (setCountry_noev(argCountry) && 
/* 628 */       this._events != null && 
/* 629 */       postEventsForChanges()) {
/* 630 */       this._events.post(IAddress.SET_COUNTRY, argCountry);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setCountry_noev(String argCountry) {
/* 637 */     boolean ev_postable = false;
/*     */     
/* 639 */     if ((getDAO_().getCountry() == null && argCountry != null) || (
/* 640 */       getDAO_().getCountry() != null && !getDAO_().getCountry().equals(argCountry))) {
/* 641 */       getDAO_().setCountry(argCountry);
/* 642 */       ev_postable = true;
/*     */     } 
/*     */     
/* 645 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getNeighborhood() {
/* 653 */     return getDAO_().getNeighborhood();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setNeighborhood(String argNeighborhood) {
/* 661 */     if (setNeighborhood_noev(argNeighborhood) && 
/* 662 */       this._events != null && 
/* 663 */       postEventsForChanges()) {
/* 664 */       this._events.post(IAddress.SET_NEIGHBORHOOD, argNeighborhood);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setNeighborhood_noev(String argNeighborhood) {
/* 671 */     boolean ev_postable = false;
/*     */     
/* 673 */     if ((getDAO_().getNeighborhood() == null && argNeighborhood != null) || (
/* 674 */       getDAO_().getNeighborhood() != null && !getDAO_().getNeighborhood().equals(argNeighborhood))) {
/* 675 */       getDAO_().setNeighborhood(argNeighborhood);
/* 676 */       ev_postable = true;
/*     */     } 
/*     */     
/* 679 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getCounty() {
/* 687 */     return getDAO_().getCounty();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setCounty(String argCounty) {
/* 695 */     if (setCounty_noev(argCounty) && 
/* 696 */       this._events != null && 
/* 697 */       postEventsForChanges()) {
/* 698 */       this._events.post(IAddress.SET_COUNTY, argCounty);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setCounty_noev(String argCounty) {
/* 705 */     boolean ev_postable = false;
/*     */     
/* 707 */     if ((getDAO_().getCounty() == null && argCounty != null) || (
/* 708 */       getDAO_().getCounty() != null && !getDAO_().getCounty().equals(argCounty))) {
/* 709 */       getDAO_().setCounty(argCounty);
/* 710 */       ev_postable = true;
/*     */     } 
/*     */     
/* 713 */     return ev_postable;
/*     */   }
/*     */   
/*     */   protected IAddressProperty newProperty(String argPropertyName) {
/* 717 */     AddressPropertyId id = new AddressPropertyId();
/*     */     
/* 719 */     id.setAddressId(getAddressId());
/* 720 */     id.setPropertyCode(argPropertyName);
/*     */     
/* 722 */     IAddressProperty prop = (IAddressProperty)DataFactory.getInstance().createNewObject((IObjectId)id, IAddressProperty.class);
/* 723 */     return prop;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @Relationship(name = "Properties")
/*     */   public List<IAddressProperty> getProperties() {
/* 732 */     if (this._properties == null) {
/* 733 */       this._properties = new HistoricalList(null);
/*     */     }
/* 735 */     return (List<IAddressProperty>)this._properties;
/*     */   }
/*     */   
/*     */   public void setProperties(List<IAddressProperty> argProperties) {
/* 739 */     if (this._properties == null) {
/* 740 */       this._properties = new HistoricalList(argProperties);
/*     */     } else {
/* 742 */       this._properties.setCurrentList(argProperties);
/*     */     } 
/*     */     
/* 745 */     for (IAddressProperty child : this._properties) {
/* 746 */       AddressPropertyModel model = (AddressPropertyModel)child;
/* 747 */       model.setOrganizationId_noev(getOrganizationId());
/* 748 */       model.setAddressId_noev(getAddressId());
/* 749 */       if (child instanceof IDataModelImpl) {
/* 750 */         IDataAccessObject childDao = ((IDataModelImpl)child).getDAO();
/* 751 */         if (StringUtils.isEmpty(childDao.getOriginDataSource()) && 
/* 752 */           !StringUtils.isEmpty(getDAO().getOriginDataSource())) {
/* 753 */           childDao.setOriginDataSource(getDAO().getOriginDataSource());
/*     */         }
/*     */       } 
/* 756 */       if (postEventsForChanges()) {
/* 757 */         this._eventManager.registerEventHandler((IEventAware)this._eventCascade, (IEventSource)child);
/*     */       }
/*     */     } 
/*     */   }
/*     */   
/*     */   public void addAddressProperty(IAddressProperty argAddressProperty) {
/* 763 */     if (this._properties == null) {
/* 764 */       this._properties = new HistoricalList(null);
/*     */     }
/* 766 */     argAddressProperty.setOrganizationId(getOrganizationId());
/* 767 */     argAddressProperty.setAddressId(getAddressId());
/* 768 */     if (argAddressProperty instanceof IDataModelImpl) {
/* 769 */       IDataAccessObject childDao = ((IDataModelImpl)argAddressProperty).getDAO();
/* 770 */       if (StringUtils.isEmpty(childDao.getOriginDataSource()) && 
/* 771 */         !StringUtils.isEmpty(getDAO().getOriginDataSource())) {
/* 772 */         childDao.setOriginDataSource(getDAO().getOriginDataSource());
/*     */       }
/*     */     } 
/*     */ 
/*     */     
/* 777 */     if (postEventsForChanges()) {
/* 778 */       this._eventManager.registerEventHandler((IEventAware)this._eventCascade, (IEventSource)new EventDescriptor(argAddressProperty));
/*     */     }
/*     */     
/* 781 */     this._properties.add(argAddressProperty);
/* 782 */     if (postEventsForChanges()) {
/* 783 */       this._events.post(IAddress.ADD_PROPERTIES, argAddressProperty);
/*     */     }
/*     */   }
/*     */   
/*     */   public void removeAddressProperty(IAddressProperty argAddressProperty) {
/* 788 */     if (this._properties != null) {
/*     */       
/* 790 */       if (postEventsForChanges()) {
/* 791 */         this._eventManager.deregisterEventHandler((IEventAware)this._eventCascade, (IEventSource)new EventDescriptor(argAddressProperty));
/*     */       }
/* 793 */       this._properties.remove(argAddressProperty);
/* 794 */       if (postEventsForChanges()) {
/* 795 */         this._events.post(IAddress.REMOVE_PROPERTIES, argAddressProperty);
/*     */       }
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public Object getValue(String argFieldId) {
/* 802 */     if ("Properties".equals(argFieldId)) {
/* 803 */       return getProperties();
/*     */     }
/* 805 */     if ("AddressExtension".equals(argFieldId)) {
/* 806 */       return this._myExtension;
/*     */     }
/*     */     
/* 809 */     return super.getValue(argFieldId);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void setValue(String argFieldId, Object argValue) {
/* 815 */     if ("Properties".equals(argFieldId)) {
/* 816 */       setProperties(changeToList(argValue, IAddressProperty.class));
/*     */     }
/* 818 */     else if ("AddressExtension".equals(argFieldId)) {
/* 819 */       this._myExtension = (IDataModel)argValue;
/*     */     } else {
/*     */       
/* 822 */       super.setValue(argFieldId, argValue);
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public void setDependencies(IPersistenceDefaults argPD, EventManager argEM) {
/* 828 */     this._persistenceDefaults = argPD;
/* 829 */     this._daoImpl.setPersistenceDefaults(argPD);
/* 830 */     this._eventManager = argEM;
/* 831 */     this._events = (Eventor)new ModelEventor((IDataModel)this, argEM);
/* 832 */     this._eventCascade = (EventHandler)new CascadingHandler(this);
/* 833 */     if (this._properties != null) {
/* 834 */       for (IAddressProperty relationship : this._properties) {
/* 835 */         ((IDataModelImpl)relationship).setDependencies(argPD, argEM);
/*     */       }
/*     */     }
/*     */   }
/*     */   
/*     */   public IDataModel getAddressExt() {
/* 841 */     return this._myExtension;
/*     */   }
/*     */   
/*     */   public void setAddressExt(IDataModel argExt) {
/* 845 */     this._myExtension = argExt;
/*     */   }
/*     */ 
/*     */   
/*     */   public void startTransaction() {
/* 850 */     if (this._alreadyInStart) {
/*     */       return;
/*     */     }
/*     */     
/* 854 */     this._alreadyInStart = true;
/*     */ 
/*     */     
/* 857 */     super.startTransaction();
/*     */     
/* 859 */     this._propertiesSavepoint = this._properties;
/* 860 */     if (this._properties != null) {
/* 861 */       this._propertiesSavepoint = new HistoricalList((List)this._properties);
/* 862 */       Iterator<IDataModel> it = this._properties.iterator();
/* 863 */       while (it.hasNext()) {
/* 864 */         ((IDataModel)it.next()).startTransaction();
/*     */       }
/*     */     } 
/*     */ 
/*     */     
/* 869 */     this._alreadyInStart = false;
/*     */   }
/*     */ 
/*     */   
/*     */   public void rollbackChanges() {
/* 874 */     if (isAlreadyRolledBack()) {
/*     */       return;
/*     */     }
/* 877 */     super.rollbackChanges();
/*     */     
/* 879 */     this._properties = this._propertiesSavepoint;
/* 880 */     this._propertiesSavepoint = null;
/* 881 */     if (this._properties != null) {
/* 882 */       Iterator<IDataModel> it = this._properties.iterator();
/* 883 */       while (it.hasNext()) {
/* 884 */         ((IDataModel)it.next()).rollbackChanges();
/*     */       }
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void commitTransaction() {
/* 892 */     if (this._alreadyInCommit) {
/*     */       return;
/*     */     }
/* 895 */     this._alreadyInCommit = true;
/*     */ 
/*     */     
/* 898 */     super.commitTransaction();
/*     */     
/* 900 */     this._propertiesSavepoint = this._properties;
/* 901 */     if (this._properties != null) {
/* 902 */       Iterator<IDataModel> it = this._properties.iterator();
/* 903 */       while (it.hasNext()) {
/* 904 */         ((IDataModel)it.next()).commitTransaction();
/*     */       }
/* 906 */       this._properties = new HistoricalList((List)this._properties);
/*     */     } 
/*     */ 
/*     */     
/* 910 */     this._alreadyInCommit = false;
/*     */   }
/*     */ 
/*     */   
/*     */   private void readObject(ObjectInputStream argStream) throws IOException, ClassNotFoundException {
/* 915 */     argStream.defaultReadObject();
/*     */   }
/*     */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\com\impl\AddressModel.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */