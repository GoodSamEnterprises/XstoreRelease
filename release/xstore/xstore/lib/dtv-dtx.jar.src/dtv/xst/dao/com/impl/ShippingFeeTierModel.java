/*     */ package dtv.xst.dao.com.impl;
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
/*     */ import dtv.xst.dao.com.IShippingFeeTier;
/*     */ import dtv.xst.dao.com.IShippingFeeTierProperty;
/*     */ import dtv.xst.dao.com.ShippingFeeTierPropertyId;
/*     */ import java.io.IOException;
/*     */ import java.io.ObjectInputStream;
/*     */ import java.math.BigDecimal;
/*     */ import java.util.Date;
/*     */ import java.util.Iterator;
/*     */ import java.util.List;
/*     */ 
/*     */ public class ShippingFeeTierModel extends AbstractDataModelWithPropertyImpl<IShippingFeeTierProperty> implements IShippingFeeTier {
/*     */   private static final long serialVersionUID = 367423706L;
/*     */   private transient boolean _alreadyInStart = false;
/*     */   private transient boolean _alreadyInCommit = false;
/*     */   
/*     */   public String toString() {
/*  33 */     return super.toString() + " Id: " + getObjectId();
/*     */   }
/*     */   private IDataModel _myExtension; private HistoricalList<IShippingFeeTierProperty> _properties; private transient HistoricalList<IShippingFeeTierProperty> _propertiesSavepoint;
/*     */   
/*     */   public void initDAO() {
/*  38 */     setDAO((IDataAccessObject)new ShippingFeeTierDAO());
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private ShippingFeeTierDAO getDAO_() {
/*  46 */     return (ShippingFeeTierDAO)this._daoImpl;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getRuleName() {
/*  54 */     return getDAO_().getRuleName();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setRuleName(String argRuleName) {
/*  62 */     if (setRuleName_noev(argRuleName) && 
/*  63 */       this._events != null && 
/*  64 */       postEventsForChanges()) {
/*  65 */       this._events.post(IShippingFeeTier.SET_RULENAME, argRuleName);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setRuleName_noev(String argRuleName) {
/*  72 */     boolean ev_postable = false;
/*     */     
/*  74 */     if ((getDAO_().getRuleName() == null && argRuleName != null) || (
/*  75 */       getDAO_().getRuleName() != null && !getDAO_().getRuleName().equals(argRuleName))) {
/*  76 */       getDAO_().setRuleName(argRuleName);
/*  77 */       ev_postable = true;
/*  78 */       if (this._properties != null) {
/*     */         
/*  80 */         Iterator<ShippingFeeTierPropertyModel> it = this._properties.iterator();
/*  81 */         while (it.hasNext())
/*     */         {
/*  83 */           ((ShippingFeeTierPropertyModel)it.next()).setRuleName_noev(argRuleName);
/*     */         }
/*     */       } 
/*     */     } 
/*     */     
/*  88 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public long getOrganizationId() {
/*  96 */     if (getDAO_().getOrganizationId() != null) {
/*  97 */       return getDAO_().getOrganizationId().longValue();
/*     */     }
/*     */     
/* 100 */     return 0L;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setOrganizationId(long argOrganizationId) {
/* 109 */     if (setOrganizationId_noev(argOrganizationId) && 
/* 110 */       this._events != null && 
/* 111 */       postEventsForChanges()) {
/* 112 */       this._events.post(IShippingFeeTier.SET_ORGANIZATIONID, Long.valueOf(argOrganizationId));
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setOrganizationId_noev(long argOrganizationId) {
/* 119 */     boolean ev_postable = false;
/*     */     
/* 121 */     if ((getDAO_().getOrganizationId() == null && Long.valueOf(argOrganizationId) != null) || (
/* 122 */       getDAO_().getOrganizationId() != null && !getDAO_().getOrganizationId().equals(Long.valueOf(argOrganizationId)))) {
/* 123 */       getDAO_().setOrganizationId(Long.valueOf(argOrganizationId));
/* 124 */       ev_postable = true;
/* 125 */       if (this._properties != null) {
/*     */         
/* 127 */         Iterator<ShippingFeeTierPropertyModel> it = this._properties.iterator();
/* 128 */         while (it.hasNext())
/*     */         {
/* 130 */           ((ShippingFeeTierPropertyModel)it.next()).setOrganizationId_noev(argOrganizationId);
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
/*     */   public String getParentRuleName() {
/* 143 */     return getDAO_().getParentRuleName();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setParentRuleName(String argParentRuleName) {
/* 151 */     if (setParentRuleName_noev(argParentRuleName) && 
/* 152 */       this._events != null && 
/* 153 */       postEventsForChanges()) {
/* 154 */       this._events.post(IShippingFeeTier.SET_PARENTRULENAME, argParentRuleName);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setParentRuleName_noev(String argParentRuleName) {
/* 161 */     boolean ev_postable = false;
/*     */     
/* 163 */     if ((getDAO_().getParentRuleName() == null && argParentRuleName != null) || (
/* 164 */       getDAO_().getParentRuleName() != null && !getDAO_().getParentRuleName().equals(argParentRuleName))) {
/* 165 */       getDAO_().setParentRuleName(argParentRuleName);
/* 166 */       ev_postable = true;
/* 167 */       if (this._properties != null) {
/*     */         
/* 169 */         Iterator<ShippingFeeTierPropertyModel> it = this._properties.iterator();
/* 170 */         while (it.hasNext())
/*     */         {
/* 172 */           ((ShippingFeeTierPropertyModel)it.next()).setParentRuleName_noev(argParentRuleName);
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
/*     */   public Date getCreateDate() {
/* 185 */     return getDAO_().getCreateDate();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setCreateDate(Date argCreateDate) {
/* 193 */     if (setCreateDate_noev(argCreateDate) && 
/* 194 */       this._events != null && 
/* 195 */       postEventsForChanges()) {
/* 196 */       this._events.post(IShippingFeeTier.SET_CREATEDATE, argCreateDate);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setCreateDate_noev(Date argCreateDate) {
/* 203 */     boolean ev_postable = false;
/*     */     
/* 205 */     if ((getDAO_().getCreateDate() == null && argCreateDate != null) || (
/* 206 */       getDAO_().getCreateDate() != null && !getDAO_().getCreateDate().equals(argCreateDate))) {
/* 207 */       getDAO_().setCreateDate(argCreateDate);
/* 208 */       ev_postable = true;
/*     */     } 
/*     */     
/* 211 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getCreateUserId() {
/* 219 */     return getDAO_().getCreateUserId();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setCreateUserId(String argCreateUserId) {
/* 227 */     if (setCreateUserId_noev(argCreateUserId) && 
/* 228 */       this._events != null && 
/* 229 */       postEventsForChanges()) {
/* 230 */       this._events.post(IShippingFeeTier.SET_CREATEUSERID, argCreateUserId);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setCreateUserId_noev(String argCreateUserId) {
/* 237 */     boolean ev_postable = false;
/*     */     
/* 239 */     if ((getDAO_().getCreateUserId() == null && argCreateUserId != null) || (
/* 240 */       getDAO_().getCreateUserId() != null && !getDAO_().getCreateUserId().equals(argCreateUserId))) {
/* 241 */       getDAO_().setCreateUserId(argCreateUserId);
/* 242 */       ev_postable = true;
/*     */     } 
/*     */     
/* 245 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Date getUpdateDate() {
/* 253 */     return getDAO_().getUpdateDate();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setUpdateDate(Date argUpdateDate) {
/* 261 */     if (setUpdateDate_noev(argUpdateDate) && 
/* 262 */       this._events != null && 
/* 263 */       postEventsForChanges()) {
/* 264 */       this._events.post(IShippingFeeTier.SET_UPDATEDATE, argUpdateDate);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setUpdateDate_noev(Date argUpdateDate) {
/* 271 */     boolean ev_postable = false;
/*     */     
/* 273 */     if ((getDAO_().getUpdateDate() == null && argUpdateDate != null) || (
/* 274 */       getDAO_().getUpdateDate() != null && !getDAO_().getUpdateDate().equals(argUpdateDate))) {
/* 275 */       getDAO_().setUpdateDate(argUpdateDate);
/* 276 */       ev_postable = true;
/*     */     } 
/*     */     
/* 279 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getUpdateUserId() {
/* 287 */     return getDAO_().getUpdateUserId();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setUpdateUserId(String argUpdateUserId) {
/* 295 */     if (setUpdateUserId_noev(argUpdateUserId) && 
/* 296 */       this._events != null && 
/* 297 */       postEventsForChanges()) {
/* 298 */       this._events.post(IShippingFeeTier.SET_UPDATEUSERID, argUpdateUserId);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setUpdateUserId_noev(String argUpdateUserId) {
/* 305 */     boolean ev_postable = false;
/*     */     
/* 307 */     if ((getDAO_().getUpdateUserId() == null && argUpdateUserId != null) || (
/* 308 */       getDAO_().getUpdateUserId() != null && !getDAO_().getUpdateUserId().equals(argUpdateUserId))) {
/* 309 */       getDAO_().setUpdateUserId(argUpdateUserId);
/* 310 */       ev_postable = true;
/*     */     } 
/*     */     
/* 313 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getOrgCode() {
/* 321 */     return getDAO_().getOrgCode();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setOrgCode(String argOrgCode) {
/* 329 */     if (setOrgCode_noev(argOrgCode) && 
/* 330 */       this._events != null && 
/* 331 */       postEventsForChanges()) {
/* 332 */       this._events.post(IShippingFeeTier.SET_ORGCODE, argOrgCode);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setOrgCode_noev(String argOrgCode) {
/* 339 */     boolean ev_postable = false;
/*     */     
/* 341 */     if ((getDAO_().getOrgCode() == null && argOrgCode != null) || (
/* 342 */       getDAO_().getOrgCode() != null && !getDAO_().getOrgCode().equals(argOrgCode))) {
/* 343 */       getDAO_().setOrgCode(argOrgCode);
/* 344 */       ev_postable = true;
/*     */     } 
/*     */     
/* 347 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getOrgValue() {
/* 355 */     return getDAO_().getOrgValue();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setOrgValue(String argOrgValue) {
/* 363 */     if (setOrgValue_noev(argOrgValue) && 
/* 364 */       this._events != null && 
/* 365 */       postEventsForChanges()) {
/* 366 */       this._events.post(IShippingFeeTier.SET_ORGVALUE, argOrgValue);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setOrgValue_noev(String argOrgValue) {
/* 373 */     boolean ev_postable = false;
/*     */     
/* 375 */     if ((getDAO_().getOrgValue() == null && argOrgValue != null) || (
/* 376 */       getDAO_().getOrgValue() != null && !getDAO_().getOrgValue().equals(argOrgValue))) {
/* 377 */       getDAO_().setOrgValue(argOrgValue);
/* 378 */       ev_postable = true;
/*     */     } 
/*     */     
/* 381 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public long getPriority() {
/* 389 */     if (getDAO_().getPriority() != null) {
/* 390 */       return getDAO_().getPriority().longValue();
/*     */     }
/*     */     
/* 393 */     return 0L;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setPriority(long argPriority) {
/* 402 */     if (setPriority_noev(argPriority) && 
/* 403 */       this._events != null && 
/* 404 */       postEventsForChanges()) {
/* 405 */       this._events.post(IShippingFeeTier.SET_PRIORITY, Long.valueOf(argPriority));
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setPriority_noev(long argPriority) {
/* 412 */     boolean ev_postable = false;
/*     */     
/* 414 */     if ((getDAO_().getPriority() == null && Long.valueOf(argPriority) != null) || (
/* 415 */       getDAO_().getPriority() != null && !getDAO_().getPriority().equals(Long.valueOf(argPriority)))) {
/* 416 */       getDAO_().setPriority(Long.valueOf(argPriority));
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
/*     */   public String getFeeType() {
/* 428 */     return getDAO_().getFeeType();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setFeeType(String argFeeType) {
/* 436 */     if (setFeeType_noev(argFeeType) && 
/* 437 */       this._events != null && 
/* 438 */       postEventsForChanges()) {
/* 439 */       this._events.post(IShippingFeeTier.SET_FEETYPE, argFeeType);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setFeeType_noev(String argFeeType) {
/* 446 */     boolean ev_postable = false;
/*     */     
/* 448 */     if ((getDAO_().getFeeType() == null && argFeeType != null) || (
/* 449 */       getDAO_().getFeeType() != null && !getDAO_().getFeeType().equals(argFeeType))) {
/* 450 */       getDAO_().setFeeType(argFeeType);
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
/*     */   public BigDecimal getFeeValue() {
/* 462 */     return getDAO_().getFeeValue();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setFeeValue(BigDecimal argFeeValue) {
/* 470 */     if (setFeeValue_noev(argFeeValue) && 
/* 471 */       this._events != null && 
/* 472 */       postEventsForChanges()) {
/* 473 */       this._events.post(IShippingFeeTier.SET_FEEVALUE, argFeeValue);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setFeeValue_noev(BigDecimal argFeeValue) {
/* 480 */     boolean ev_postable = false;
/*     */     
/* 482 */     if ((getDAO_().getFeeValue() == null && argFeeValue != null) || (
/* 483 */       getDAO_().getFeeValue() != null && !getDAO_().getFeeValue().equals(argFeeValue))) {
/* 484 */       getDAO_().setFeeValue(argFeeValue);
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
/*     */   public String getShipMethod() {
/* 496 */     return getDAO_().getShipMethod();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setShipMethod(String argShipMethod) {
/* 504 */     if (setShipMethod_noev(argShipMethod) && 
/* 505 */       this._events != null && 
/* 506 */       postEventsForChanges()) {
/* 507 */       this._events.post(IShippingFeeTier.SET_SHIPMETHOD, argShipMethod);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setShipMethod_noev(String argShipMethod) {
/* 514 */     boolean ev_postable = false;
/*     */     
/* 516 */     if ((getDAO_().getShipMethod() == null && argShipMethod != null) || (
/* 517 */       getDAO_().getShipMethod() != null && !getDAO_().getShipMethod().equals(argShipMethod))) {
/* 518 */       getDAO_().setShipMethod(argShipMethod);
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
/*     */   public BigDecimal getMinPrice() {
/* 530 */     return getDAO_().getMinPrice();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setMinPrice(BigDecimal argMinPrice) {
/* 538 */     if (setMinPrice_noev(argMinPrice) && 
/* 539 */       this._events != null && 
/* 540 */       postEventsForChanges()) {
/* 541 */       this._events.post(IShippingFeeTier.SET_MINPRICE, argMinPrice);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setMinPrice_noev(BigDecimal argMinPrice) {
/* 548 */     boolean ev_postable = false;
/*     */     
/* 550 */     if ((getDAO_().getMinPrice() == null && argMinPrice != null) || (
/* 551 */       getDAO_().getMinPrice() != null && !getDAO_().getMinPrice().equals(argMinPrice))) {
/* 552 */       getDAO_().setMinPrice(argMinPrice);
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
/*     */   public BigDecimal getMaxPrice() {
/* 564 */     return getDAO_().getMaxPrice();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setMaxPrice(BigDecimal argMaxPrice) {
/* 572 */     if (setMaxPrice_noev(argMaxPrice) && 
/* 573 */       this._events != null && 
/* 574 */       postEventsForChanges()) {
/* 575 */       this._events.post(IShippingFeeTier.SET_MAXPRICE, argMaxPrice);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setMaxPrice_noev(BigDecimal argMaxPrice) {
/* 582 */     boolean ev_postable = false;
/*     */     
/* 584 */     if ((getDAO_().getMaxPrice() == null && argMaxPrice != null) || (
/* 585 */       getDAO_().getMaxPrice() != null && !getDAO_().getMaxPrice().equals(argMaxPrice))) {
/* 586 */       getDAO_().setMaxPrice(argMaxPrice);
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
/*     */   public String getItemId() {
/* 598 */     return getDAO_().getItemId();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setItemId(String argItemId) {
/* 606 */     if (setItemId_noev(argItemId) && 
/* 607 */       this._events != null && 
/* 608 */       postEventsForChanges()) {
/* 609 */       this._events.post(IShippingFeeTier.SET_ITEMID, argItemId);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setItemId_noev(String argItemId) {
/* 616 */     boolean ev_postable = false;
/*     */     
/* 618 */     if ((getDAO_().getItemId() == null && argItemId != null) || (
/* 619 */       getDAO_().getItemId() != null && !getDAO_().getItemId().equals(argItemId))) {
/* 620 */       getDAO_().setItemId(argItemId);
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
/*     */   public String getRuleType() {
/* 632 */     return getDAO_().getRuleType();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setRuleType(String argRuleType) {
/* 640 */     if (setRuleType_noev(argRuleType) && 
/* 641 */       this._events != null && 
/* 642 */       postEventsForChanges()) {
/* 643 */       this._events.post(IShippingFeeTier.SET_RULETYPE, argRuleType);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setRuleType_noev(String argRuleType) {
/* 650 */     boolean ev_postable = false;
/*     */     
/* 652 */     if ((getDAO_().getRuleType() == null && argRuleType != null) || (
/* 653 */       getDAO_().getRuleType() != null && !getDAO_().getRuleType().equals(argRuleType))) {
/* 654 */       getDAO_().setRuleType(argRuleType);
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
/*     */   public String getParam1() {
/* 666 */     return getDAO_().getParam1();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setParam1(String argParam1) {
/* 674 */     if (setParam1_noev(argParam1) && 
/* 675 */       this._events != null && 
/* 676 */       postEventsForChanges()) {
/* 677 */       this._events.post(IShippingFeeTier.SET_PARAM1, argParam1);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setParam1_noev(String argParam1) {
/* 684 */     boolean ev_postable = false;
/*     */     
/* 686 */     if ((getDAO_().getParam1() == null && argParam1 != null) || (
/* 687 */       getDAO_().getParam1() != null && !getDAO_().getParam1().equals(argParam1))) {
/* 688 */       getDAO_().setParam1(argParam1);
/* 689 */       ev_postable = true;
/*     */     } 
/*     */     
/* 692 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getParam2() {
/* 700 */     return getDAO_().getParam2();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setParam2(String argParam2) {
/* 708 */     if (setParam2_noev(argParam2) && 
/* 709 */       this._events != null && 
/* 710 */       postEventsForChanges()) {
/* 711 */       this._events.post(IShippingFeeTier.SET_PARAM2, argParam2);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setParam2_noev(String argParam2) {
/* 718 */     boolean ev_postable = false;
/*     */     
/* 720 */     if ((getDAO_().getParam2() == null && argParam2 != null) || (
/* 721 */       getDAO_().getParam2() != null && !getDAO_().getParam2().equals(argParam2))) {
/* 722 */       getDAO_().setParam2(argParam2);
/* 723 */       ev_postable = true;
/*     */     } 
/*     */     
/* 726 */     return ev_postable;
/*     */   }
/*     */   
/*     */   protected IShippingFeeTierProperty newProperty(String argPropertyName) {
/* 730 */     ShippingFeeTierPropertyId id = new ShippingFeeTierPropertyId();
/*     */     
/* 732 */     id.setRuleName(getRuleName());
/* 733 */     id.setParentRuleName(getParentRuleName());
/* 734 */     id.setPropertyCode(argPropertyName);
/*     */     
/* 736 */     IShippingFeeTierProperty prop = (IShippingFeeTierProperty)DataFactory.getInstance().createNewObject((IObjectId)id, IShippingFeeTierProperty.class);
/* 737 */     return prop;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @Relationship(name = "Properties")
/*     */   public List<IShippingFeeTierProperty> getProperties() {
/* 746 */     if (this._properties == null) {
/* 747 */       this._properties = new HistoricalList(null);
/*     */     }
/* 749 */     return (List<IShippingFeeTierProperty>)this._properties;
/*     */   }
/*     */   
/*     */   public void setProperties(List<IShippingFeeTierProperty> argProperties) {
/* 753 */     if (this._properties == null) {
/* 754 */       this._properties = new HistoricalList(argProperties);
/*     */     } else {
/* 756 */       this._properties.setCurrentList(argProperties);
/*     */     } 
/*     */     
/* 759 */     for (IShippingFeeTierProperty child : this._properties) {
/* 760 */       ShippingFeeTierPropertyModel model = (ShippingFeeTierPropertyModel)child;
/* 761 */       model.setRuleName_noev(getRuleName());
/* 762 */       model.setOrganizationId_noev(getOrganizationId());
/* 763 */       model.setParentRuleName_noev(getParentRuleName());
/* 764 */       if (child instanceof IDataModelImpl) {
/* 765 */         IDataAccessObject childDao = ((IDataModelImpl)child).getDAO();
/* 766 */         if (StringUtils.isEmpty(childDao.getOriginDataSource()) && 
/* 767 */           !StringUtils.isEmpty(getDAO().getOriginDataSource())) {
/* 768 */           childDao.setOriginDataSource(getDAO().getOriginDataSource());
/*     */         }
/*     */       } 
/* 771 */       if (postEventsForChanges()) {
/* 772 */         this._eventManager.registerEventHandler((IEventAware)this._eventCascade, (IEventSource)child);
/*     */       }
/*     */     } 
/*     */   }
/*     */   
/*     */   public void addShippingFeeTierProperty(IShippingFeeTierProperty argShippingFeeTierProperty) {
/* 778 */     if (this._properties == null) {
/* 779 */       this._properties = new HistoricalList(null);
/*     */     }
/* 781 */     argShippingFeeTierProperty.setRuleName(getRuleName());
/* 782 */     argShippingFeeTierProperty.setOrganizationId(getOrganizationId());
/* 783 */     argShippingFeeTierProperty.setParentRuleName(getParentRuleName());
/* 784 */     if (argShippingFeeTierProperty instanceof IDataModelImpl) {
/* 785 */       IDataAccessObject childDao = ((IDataModelImpl)argShippingFeeTierProperty).getDAO();
/* 786 */       if (StringUtils.isEmpty(childDao.getOriginDataSource()) && 
/* 787 */         !StringUtils.isEmpty(getDAO().getOriginDataSource())) {
/* 788 */         childDao.setOriginDataSource(getDAO().getOriginDataSource());
/*     */       }
/*     */     } 
/*     */ 
/*     */     
/* 793 */     if (postEventsForChanges()) {
/* 794 */       this._eventManager.registerEventHandler((IEventAware)this._eventCascade, (IEventSource)new EventDescriptor(argShippingFeeTierProperty));
/*     */     }
/*     */     
/* 797 */     this._properties.add(argShippingFeeTierProperty);
/* 798 */     if (postEventsForChanges()) {
/* 799 */       this._events.post(IShippingFeeTier.ADD_PROPERTIES, argShippingFeeTierProperty);
/*     */     }
/*     */   }
/*     */   
/*     */   public void removeShippingFeeTierProperty(IShippingFeeTierProperty argShippingFeeTierProperty) {
/* 804 */     if (this._properties != null) {
/*     */       
/* 806 */       if (postEventsForChanges()) {
/* 807 */         this._eventManager.deregisterEventHandler((IEventAware)this._eventCascade, (IEventSource)new EventDescriptor(argShippingFeeTierProperty));
/*     */       }
/* 809 */       this._properties.remove(argShippingFeeTierProperty);
/* 810 */       if (postEventsForChanges()) {
/* 811 */         this._events.post(IShippingFeeTier.REMOVE_PROPERTIES, argShippingFeeTierProperty);
/*     */       }
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public Object getValue(String argFieldId) {
/* 818 */     if ("Properties".equals(argFieldId)) {
/* 819 */       return getProperties();
/*     */     }
/* 821 */     if ("ShippingFeeTierExtension".equals(argFieldId)) {
/* 822 */       return this._myExtension;
/*     */     }
/*     */     
/* 825 */     return super.getValue(argFieldId);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void setValue(String argFieldId, Object argValue) {
/* 831 */     if ("Properties".equals(argFieldId)) {
/* 832 */       setProperties(changeToList(argValue, IShippingFeeTierProperty.class));
/*     */     }
/* 834 */     else if ("ShippingFeeTierExtension".equals(argFieldId)) {
/* 835 */       this._myExtension = (IDataModel)argValue;
/*     */     } else {
/*     */       
/* 838 */       super.setValue(argFieldId, argValue);
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public void setDependencies(IPersistenceDefaults argPD, EventManager argEM) {
/* 844 */     this._persistenceDefaults = argPD;
/* 845 */     this._daoImpl.setPersistenceDefaults(argPD);
/* 846 */     this._eventManager = argEM;
/* 847 */     this._events = (Eventor)new ModelEventor((IDataModel)this, argEM);
/* 848 */     this._eventCascade = (EventHandler)new CascadingHandler(this);
/* 849 */     if (this._properties != null) {
/* 850 */       for (IShippingFeeTierProperty relationship : this._properties) {
/* 851 */         ((IDataModelImpl)relationship).setDependencies(argPD, argEM);
/*     */       }
/*     */     }
/*     */   }
/*     */   
/*     */   public IDataModel getShippingFeeTierExt() {
/* 857 */     return this._myExtension;
/*     */   }
/*     */   
/*     */   public void setShippingFeeTierExt(IDataModel argExt) {
/* 861 */     this._myExtension = argExt;
/*     */   }
/*     */ 
/*     */   
/*     */   public void startTransaction() {
/* 866 */     if (this._alreadyInStart) {
/*     */       return;
/*     */     }
/*     */     
/* 870 */     this._alreadyInStart = true;
/*     */ 
/*     */     
/* 873 */     super.startTransaction();
/*     */     
/* 875 */     this._propertiesSavepoint = this._properties;
/* 876 */     if (this._properties != null) {
/* 877 */       this._propertiesSavepoint = new HistoricalList((List)this._properties);
/* 878 */       Iterator<IDataModel> it = this._properties.iterator();
/* 879 */       while (it.hasNext()) {
/* 880 */         ((IDataModel)it.next()).startTransaction();
/*     */       }
/*     */     } 
/*     */ 
/*     */     
/* 885 */     this._alreadyInStart = false;
/*     */   }
/*     */ 
/*     */   
/*     */   public void rollbackChanges() {
/* 890 */     if (isAlreadyRolledBack()) {
/*     */       return;
/*     */     }
/* 893 */     super.rollbackChanges();
/*     */     
/* 895 */     this._properties = this._propertiesSavepoint;
/* 896 */     this._propertiesSavepoint = null;
/* 897 */     if (this._properties != null) {
/* 898 */       Iterator<IDataModel> it = this._properties.iterator();
/* 899 */       while (it.hasNext()) {
/* 900 */         ((IDataModel)it.next()).rollbackChanges();
/*     */       }
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void commitTransaction() {
/* 908 */     if (this._alreadyInCommit) {
/*     */       return;
/*     */     }
/* 911 */     this._alreadyInCommit = true;
/*     */ 
/*     */     
/* 914 */     super.commitTransaction();
/*     */     
/* 916 */     this._propertiesSavepoint = this._properties;
/* 917 */     if (this._properties != null) {
/* 918 */       Iterator<IDataModel> it = this._properties.iterator();
/* 919 */       while (it.hasNext()) {
/* 920 */         ((IDataModel)it.next()).commitTransaction();
/*     */       }
/* 922 */       this._properties = new HistoricalList((List)this._properties);
/*     */     } 
/*     */ 
/*     */     
/* 926 */     this._alreadyInCommit = false;
/*     */   }
/*     */ 
/*     */   
/*     */   private void readObject(ObjectInputStream argStream) throws IOException, ClassNotFoundException {
/* 931 */     argStream.defaultReadObject();
/*     */   }
/*     */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\com\impl\ShippingFeeTierModel.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */