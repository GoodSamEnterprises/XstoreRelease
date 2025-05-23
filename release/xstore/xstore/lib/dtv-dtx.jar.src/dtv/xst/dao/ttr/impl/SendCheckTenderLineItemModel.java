/*     */ package dtv.xst.dao.ttr.impl;
/*     */ 
/*     */ import dtv.data2.IPersistenceDefaults;
/*     */ import dtv.data2.access.IDataAccessObject;
/*     */ import dtv.data2.access.IDataModel;
/*     */ import dtv.event.EventManager;
/*     */ import dtv.xst.dao.ttr.ISendCheckTenderLineItem;
/*     */ import java.io.IOException;
/*     */ import java.io.ObjectInputStream;
/*     */ import java.util.Date;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class SendCheckTenderLineItemModel
/*     */   extends TenderLineItemModel
/*     */   implements ISendCheckTenderLineItem
/*     */ {
/*     */   private static final long serialVersionUID = -1307877765L;
/*     */   private transient boolean _alreadyInStart = false;
/*     */   private transient boolean _alreadyInCommit = false;
/*     */   private IDataModel _myExtension;
/*     */   
/*     */   public void initDAO() {
/*  30 */     setDAO((IDataAccessObject)new SendCheckTenderLineItemDAO());
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private SendCheckTenderLineItemDAO getDAO_() {
/*  38 */     return (SendCheckTenderLineItemDAO)this._daoImpl;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Date getCreateDate() {
/*  46 */     return getDAO_().getCreateDate();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setCreateDate(Date argCreateDate) {
/*  54 */     if (setCreateDate_noev(argCreateDate) && 
/*  55 */       this._events != null && 
/*  56 */       postEventsForChanges()) {
/*  57 */       this._events.post(ISendCheckTenderLineItem.SET_CREATEDATE, argCreateDate);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setCreateDate_noev(Date argCreateDate) {
/*  64 */     boolean ev_postable = false;
/*     */     
/*  66 */     if ((getDAO_().getCreateDate() == null && argCreateDate != null) || (
/*  67 */       getDAO_().getCreateDate() != null && !getDAO_().getCreateDate().equals(argCreateDate))) {
/*  68 */       getDAO_().setCreateDate(argCreateDate);
/*  69 */       ev_postable = true;
/*     */     } 
/*     */     
/*  72 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getCreateUserId() {
/*  80 */     return getDAO_().getCreateUserId();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setCreateUserId(String argCreateUserId) {
/*  88 */     if (setCreateUserId_noev(argCreateUserId) && 
/*  89 */       this._events != null && 
/*  90 */       postEventsForChanges()) {
/*  91 */       this._events.post(ISendCheckTenderLineItem.SET_CREATEUSERID, argCreateUserId);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setCreateUserId_noev(String argCreateUserId) {
/*  98 */     boolean ev_postable = false;
/*     */     
/* 100 */     if ((getDAO_().getCreateUserId() == null && argCreateUserId != null) || (
/* 101 */       getDAO_().getCreateUserId() != null && !getDAO_().getCreateUserId().equals(argCreateUserId))) {
/* 102 */       getDAO_().setCreateUserId(argCreateUserId);
/* 103 */       ev_postable = true;
/*     */     } 
/*     */     
/* 106 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Date getUpdateDate() {
/* 114 */     return getDAO_().getUpdateDate();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setUpdateDate(Date argUpdateDate) {
/* 122 */     if (setUpdateDate_noev(argUpdateDate) && 
/* 123 */       this._events != null && 
/* 124 */       postEventsForChanges()) {
/* 125 */       this._events.post(ISendCheckTenderLineItem.SET_UPDATEDATE, argUpdateDate);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setUpdateDate_noev(Date argUpdateDate) {
/* 132 */     boolean ev_postable = false;
/*     */     
/* 134 */     if ((getDAO_().getUpdateDate() == null && argUpdateDate != null) || (
/* 135 */       getDAO_().getUpdateDate() != null && !getDAO_().getUpdateDate().equals(argUpdateDate))) {
/* 136 */       getDAO_().setUpdateDate(argUpdateDate);
/* 137 */       ev_postable = true;
/*     */     } 
/*     */     
/* 140 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getUpdateUserId() {
/* 148 */     return getDAO_().getUpdateUserId();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setUpdateUserId(String argUpdateUserId) {
/* 156 */     if (setUpdateUserId_noev(argUpdateUserId) && 
/* 157 */       this._events != null && 
/* 158 */       postEventsForChanges()) {
/* 159 */       this._events.post(ISendCheckTenderLineItem.SET_UPDATEUSERID, argUpdateUserId);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setUpdateUserId_noev(String argUpdateUserId) {
/* 166 */     boolean ev_postable = false;
/*     */     
/* 168 */     if ((getDAO_().getUpdateUserId() == null && argUpdateUserId != null) || (
/* 169 */       getDAO_().getUpdateUserId() != null && !getDAO_().getUpdateUserId().equals(argUpdateUserId))) {
/* 170 */       getDAO_().setUpdateUserId(argUpdateUserId);
/* 171 */       ev_postable = true;
/*     */     } 
/*     */     
/* 174 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getAddress1() {
/* 182 */     return getDAO_().getAddress1();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setAddress1(String argAddress1) {
/* 190 */     if (setAddress1_noev(argAddress1) && 
/* 191 */       this._events != null && 
/* 192 */       postEventsForChanges()) {
/* 193 */       this._events.post(ISendCheckTenderLineItem.SET_ADDRESS1, argAddress1);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setAddress1_noev(String argAddress1) {
/* 200 */     boolean ev_postable = false;
/*     */     
/* 202 */     if ((getDAO_().getAddress1() == null && argAddress1 != null) || (
/* 203 */       getDAO_().getAddress1() != null && !getDAO_().getAddress1().equals(argAddress1))) {
/* 204 */       getDAO_().setAddress1(argAddress1);
/* 205 */       ev_postable = true;
/*     */     } 
/*     */     
/* 208 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getAddress2() {
/* 216 */     return getDAO_().getAddress2();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setAddress2(String argAddress2) {
/* 224 */     if (setAddress2_noev(argAddress2) && 
/* 225 */       this._events != null && 
/* 226 */       postEventsForChanges()) {
/* 227 */       this._events.post(ISendCheckTenderLineItem.SET_ADDRESS2, argAddress2);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setAddress2_noev(String argAddress2) {
/* 234 */     boolean ev_postable = false;
/*     */     
/* 236 */     if ((getDAO_().getAddress2() == null && argAddress2 != null) || (
/* 237 */       getDAO_().getAddress2() != null && !getDAO_().getAddress2().equals(argAddress2))) {
/* 238 */       getDAO_().setAddress2(argAddress2);
/* 239 */       ev_postable = true;
/*     */     } 
/*     */     
/* 242 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getAddress3() {
/* 250 */     return getDAO_().getAddress3();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setAddress3(String argAddress3) {
/* 258 */     if (setAddress3_noev(argAddress3) && 
/* 259 */       this._events != null && 
/* 260 */       postEventsForChanges()) {
/* 261 */       this._events.post(ISendCheckTenderLineItem.SET_ADDRESS3, argAddress3);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setAddress3_noev(String argAddress3) {
/* 268 */     boolean ev_postable = false;
/*     */     
/* 270 */     if ((getDAO_().getAddress3() == null && argAddress3 != null) || (
/* 271 */       getDAO_().getAddress3() != null && !getDAO_().getAddress3().equals(argAddress3))) {
/* 272 */       getDAO_().setAddress3(argAddress3);
/* 273 */       ev_postable = true;
/*     */     } 
/*     */     
/* 276 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getAddress4() {
/* 284 */     return getDAO_().getAddress4();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setAddress4(String argAddress4) {
/* 292 */     if (setAddress4_noev(argAddress4) && 
/* 293 */       this._events != null && 
/* 294 */       postEventsForChanges()) {
/* 295 */       this._events.post(ISendCheckTenderLineItem.SET_ADDRESS4, argAddress4);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setAddress4_noev(String argAddress4) {
/* 302 */     boolean ev_postable = false;
/*     */     
/* 304 */     if ((getDAO_().getAddress4() == null && argAddress4 != null) || (
/* 305 */       getDAO_().getAddress4() != null && !getDAO_().getAddress4().equals(argAddress4))) {
/* 306 */       getDAO_().setAddress4(argAddress4);
/* 307 */       ev_postable = true;
/*     */     } 
/*     */     
/* 310 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getApartment() {
/* 318 */     return getDAO_().getApartment();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setApartment(String argApartment) {
/* 326 */     if (setApartment_noev(argApartment) && 
/* 327 */       this._events != null && 
/* 328 */       postEventsForChanges()) {
/* 329 */       this._events.post(ISendCheckTenderLineItem.SET_APARTMENT, argApartment);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setApartment_noev(String argApartment) {
/* 336 */     boolean ev_postable = false;
/*     */     
/* 338 */     if ((getDAO_().getApartment() == null && argApartment != null) || (
/* 339 */       getDAO_().getApartment() != null && !getDAO_().getApartment().equals(argApartment))) {
/* 340 */       getDAO_().setApartment(argApartment);
/* 341 */       ev_postable = true;
/*     */     } 
/*     */     
/* 344 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getCity() {
/* 352 */     return getDAO_().getCity();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setCity(String argCity) {
/* 360 */     if (setCity_noev(argCity) && 
/* 361 */       this._events != null && 
/* 362 */       postEventsForChanges()) {
/* 363 */       this._events.post(ISendCheckTenderLineItem.SET_CITY, argCity);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setCity_noev(String argCity) {
/* 370 */     boolean ev_postable = false;
/*     */     
/* 372 */     if ((getDAO_().getCity() == null && argCity != null) || (
/* 373 */       getDAO_().getCity() != null && !getDAO_().getCity().equals(argCity))) {
/* 374 */       getDAO_().setCity(argCity);
/* 375 */       ev_postable = true;
/*     */     } 
/*     */     
/* 378 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getCountry() {
/* 386 */     return getDAO_().getCountry();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setCountry(String argCountry) {
/* 394 */     if (setCountry_noev(argCountry) && 
/* 395 */       this._events != null && 
/* 396 */       postEventsForChanges()) {
/* 397 */       this._events.post(ISendCheckTenderLineItem.SET_COUNTRY, argCountry);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setCountry_noev(String argCountry) {
/* 404 */     boolean ev_postable = false;
/*     */     
/* 406 */     if ((getDAO_().getCountry() == null && argCountry != null) || (
/* 407 */       getDAO_().getCountry() != null && !getDAO_().getCountry().equals(argCountry))) {
/* 408 */       getDAO_().setCountry(argCountry);
/* 409 */       ev_postable = true;
/*     */     } 
/*     */     
/* 412 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getPayableToName() {
/* 420 */     return getDAO_().getPayableToName();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setPayableToName(String argPayableToName) {
/* 428 */     if (setPayableToName_noev(argPayableToName) && 
/* 429 */       this._events != null && 
/* 430 */       postEventsForChanges()) {
/* 431 */       this._events.post(ISendCheckTenderLineItem.SET_PAYABLETONAME, argPayableToName);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setPayableToName_noev(String argPayableToName) {
/* 438 */     boolean ev_postable = false;
/*     */     
/* 440 */     if ((getDAO_().getPayableToName() == null && argPayableToName != null) || (
/* 441 */       getDAO_().getPayableToName() != null && !getDAO_().getPayableToName().equals(argPayableToName))) {
/* 442 */       getDAO_().setPayableToName(argPayableToName);
/* 443 */       ev_postable = true;
/*     */     } 
/*     */     
/* 446 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getPostalCode() {
/* 454 */     return getDAO_().getPostalCode();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setPostalCode(String argPostalCode) {
/* 462 */     if (setPostalCode_noev(argPostalCode) && 
/* 463 */       this._events != null && 
/* 464 */       postEventsForChanges()) {
/* 465 */       this._events.post(ISendCheckTenderLineItem.SET_POSTALCODE, argPostalCode);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setPostalCode_noev(String argPostalCode) {
/* 472 */     boolean ev_postable = false;
/*     */     
/* 474 */     if ((getDAO_().getPostalCode() == null && argPostalCode != null) || (
/* 475 */       getDAO_().getPostalCode() != null && !getDAO_().getPostalCode().equals(argPostalCode))) {
/* 476 */       getDAO_().setPostalCode(argPostalCode);
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
/*     */   public String getState() {
/* 488 */     return getDAO_().getState();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setState(String argState) {
/* 496 */     if (setState_noev(argState) && 
/* 497 */       this._events != null && 
/* 498 */       postEventsForChanges()) {
/* 499 */       this._events.post(ISendCheckTenderLineItem.SET_STATE, argState);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setState_noev(String argState) {
/* 506 */     boolean ev_postable = false;
/*     */     
/* 508 */     if ((getDAO_().getState() == null && argState != null) || (
/* 509 */       getDAO_().getState() != null && !getDAO_().getState().equals(argState))) {
/* 510 */       getDAO_().setState(argState);
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
/*     */   public String getSendCheckReasonCode() {
/* 522 */     return getDAO_().getSendCheckReasonCode();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setSendCheckReasonCode(String argSendCheckReasonCode) {
/* 530 */     if (setSendCheckReasonCode_noev(argSendCheckReasonCode) && 
/* 531 */       this._events != null && 
/* 532 */       postEventsForChanges()) {
/* 533 */       this._events.post(ISendCheckTenderLineItem.SET_SENDCHECKREASONCODE, argSendCheckReasonCode);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setSendCheckReasonCode_noev(String argSendCheckReasonCode) {
/* 540 */     boolean ev_postable = false;
/*     */     
/* 542 */     if ((getDAO_().getSendCheckReasonCode() == null && argSendCheckReasonCode != null) || (
/* 543 */       getDAO_().getSendCheckReasonCode() != null && !getDAO_().getSendCheckReasonCode().equals(argSendCheckReasonCode))) {
/* 544 */       getDAO_().setSendCheckReasonCode(argSendCheckReasonCode);
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
/*     */   public String getNeighborhood() {
/* 556 */     return getDAO_().getNeighborhood();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setNeighborhood(String argNeighborhood) {
/* 564 */     if (setNeighborhood_noev(argNeighborhood) && 
/* 565 */       this._events != null && 
/* 566 */       postEventsForChanges()) {
/* 567 */       this._events.post(ISendCheckTenderLineItem.SET_NEIGHBORHOOD, argNeighborhood);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setNeighborhood_noev(String argNeighborhood) {
/* 574 */     boolean ev_postable = false;
/*     */     
/* 576 */     if ((getDAO_().getNeighborhood() == null && argNeighborhood != null) || (
/* 577 */       getDAO_().getNeighborhood() != null && !getDAO_().getNeighborhood().equals(argNeighborhood))) {
/* 578 */       getDAO_().setNeighborhood(argNeighborhood);
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
/*     */   public String getCounty() {
/* 590 */     return getDAO_().getCounty();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setCounty(String argCounty) {
/* 598 */     if (setCounty_noev(argCounty) && 
/* 599 */       this._events != null && 
/* 600 */       postEventsForChanges()) {
/* 601 */       this._events.post(ISendCheckTenderLineItem.SET_COUNTY, argCounty);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setCounty_noev(String argCounty) {
/* 608 */     boolean ev_postable = false;
/*     */     
/* 610 */     if ((getDAO_().getCounty() == null && argCounty != null) || (
/* 611 */       getDAO_().getCounty() != null && !getDAO_().getCounty().equals(argCounty))) {
/* 612 */       getDAO_().setCounty(argCounty);
/* 613 */       ev_postable = true;
/*     */     } 
/*     */     
/* 616 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public Object getValue(String argFieldId) {
/* 622 */     if ("SendCheckTenderLineItemExtension".equals(argFieldId)) {
/* 623 */       return this._myExtension;
/*     */     }
/*     */     
/* 626 */     return super.getValue(argFieldId);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void setValue(String argFieldId, Object argValue) {
/* 632 */     if ("SendCheckTenderLineItemExtension".equals(argFieldId)) {
/* 633 */       this._myExtension = (IDataModel)argValue;
/*     */     } else {
/*     */       
/* 636 */       super.setValue(argFieldId, argValue);
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public void setDependencies(IPersistenceDefaults argPD, EventManager argEM) {
/* 642 */     super.setDependencies(argPD, argEM);
/*     */   }
/*     */   
/*     */   public IDataModel getSendCheckTenderLineItemExt() {
/* 646 */     return this._myExtension;
/*     */   }
/*     */   
/*     */   public void setSendCheckTenderLineItemExt(IDataModel argExt) {
/* 650 */     this._myExtension = argExt;
/*     */   }
/*     */ 
/*     */   
/*     */   public void startTransaction() {
/* 655 */     if (this._alreadyInStart) {
/*     */       return;
/*     */     }
/*     */     
/* 659 */     this._alreadyInStart = true;
/*     */ 
/*     */     
/* 662 */     super.startTransaction();
/*     */ 
/*     */     
/* 665 */     this._alreadyInStart = false;
/*     */   }
/*     */ 
/*     */   
/*     */   public void rollbackChanges() {
/* 670 */     if (isAlreadyRolledBack()) {
/*     */       return;
/*     */     }
/* 673 */     super.rollbackChanges();
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void commitTransaction() {
/* 679 */     if (this._alreadyInCommit) {
/*     */       return;
/*     */     }
/* 682 */     this._alreadyInCommit = true;
/*     */ 
/*     */     
/* 685 */     super.commitTransaction();
/*     */ 
/*     */     
/* 688 */     this._alreadyInCommit = false;
/*     */   }
/*     */ 
/*     */   
/*     */   private void readObject(ObjectInputStream argStream) throws IOException, ClassNotFoundException {
/* 693 */     argStream.defaultReadObject();
/*     */   }
/*     */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\ttr\impl\SendCheckTenderLineItemModel.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */