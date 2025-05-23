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
/*     */ import dtv.util.HistoricalList;
/*     */ import dtv.util.StringUtils;
/*     */ import dtv.xst.dao.com.IShippingFee;
/*     */ import dtv.xst.dao.com.IShippingFeeProperty;
/*     */ import dtv.xst.dao.com.IShippingFeeTier;
/*     */ import dtv.xst.dao.com.ShippingFeePropertyId;
/*     */ import java.io.ObjectInputStream;
/*     */ import java.util.Date;
/*     */ import java.util.Iterator;
/*     */ import java.util.List;
/*     */ 
/*     */ public class ShippingFeeModel extends AbstractDataModelWithPropertyImpl<IShippingFeeProperty> implements IShippingFee {
/*     */   private static final long serialVersionUID = -1531586856L;
/*     */   private transient boolean _alreadyInStart = false;
/*     */   private transient boolean _alreadyInCommit = false;
/*     */   private IDataModel _myExtension;
/*     */   
/*     */   public String toString() {
/*  33 */     return super.toString() + " Id: " + getObjectId();
/*     */   }
/*     */   private HistoricalList<IShippingFeeTier> _tieredFees; private transient HistoricalList<IShippingFeeTier> _tieredFeesSavepoint; private HistoricalList<IShippingFeeProperty> _properties; private transient HistoricalList<IShippingFeeProperty> _propertiesSavepoint;
/*     */   
/*     */   public void initDAO() {
/*  38 */     setDAO((IDataAccessObject)new ShippingFeeDAO());
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private ShippingFeeDAO getDAO_() {
/*  46 */     return (ShippingFeeDAO)this._daoImpl;
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
/*  65 */       this._events.post(IShippingFee.SET_RULENAME, argRuleName);
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
/*  78 */       if (this._tieredFees != null) {
/*     */         
/*  80 */         Iterator<ShippingFeeTierModel> it = this._tieredFees.iterator();
/*  81 */         while (it.hasNext())
/*     */         {
/*  83 */           ((ShippingFeeTierModel)it.next()).setParentRuleName_noev(argRuleName);
/*     */         }
/*     */       } 
/*  86 */       if (this._properties != null) {
/*     */         
/*  88 */         Iterator<ShippingFeePropertyModel> it = this._properties.iterator();
/*  89 */         while (it.hasNext())
/*     */         {
/*  91 */           ((ShippingFeePropertyModel)it.next()).setRuleName_noev(argRuleName);
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
/*     */   public long getOrganizationId() {
/* 104 */     if (getDAO_().getOrganizationId() != null) {
/* 105 */       return getDAO_().getOrganizationId().longValue();
/*     */     }
/*     */     
/* 108 */     return 0L;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setOrganizationId(long argOrganizationId) {
/* 117 */     if (setOrganizationId_noev(argOrganizationId) && 
/* 118 */       this._events != null && 
/* 119 */       postEventsForChanges()) {
/* 120 */       this._events.post(IShippingFee.SET_ORGANIZATIONID, Long.valueOf(argOrganizationId));
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setOrganizationId_noev(long argOrganizationId) {
/* 127 */     boolean ev_postable = false;
/*     */     
/* 129 */     if ((getDAO_().getOrganizationId() == null && Long.valueOf(argOrganizationId) != null) || (
/* 130 */       getDAO_().getOrganizationId() != null && !getDAO_().getOrganizationId().equals(Long.valueOf(argOrganizationId)))) {
/* 131 */       getDAO_().setOrganizationId(Long.valueOf(argOrganizationId));
/* 132 */       ev_postable = true;
/* 133 */       if (this._tieredFees != null) {
/*     */         
/* 135 */         Iterator<ShippingFeeTierModel> it = this._tieredFees.iterator();
/* 136 */         while (it.hasNext())
/*     */         {
/* 138 */           ((ShippingFeeTierModel)it.next()).setOrganizationId_noev(argOrganizationId);
/*     */         }
/*     */       } 
/* 141 */       if (this._properties != null) {
/*     */         
/* 143 */         Iterator<ShippingFeePropertyModel> it = this._properties.iterator();
/* 144 */         while (it.hasNext())
/*     */         {
/* 146 */           ((ShippingFeePropertyModel)it.next()).setOrganizationId_noev(argOrganizationId);
/*     */         }
/*     */       } 
/*     */     } 
/*     */     
/* 151 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Date getCreateDate() {
/* 159 */     return getDAO_().getCreateDate();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setCreateDate(Date argCreateDate) {
/* 167 */     if (setCreateDate_noev(argCreateDate) && 
/* 168 */       this._events != null && 
/* 169 */       postEventsForChanges()) {
/* 170 */       this._events.post(IShippingFee.SET_CREATEDATE, argCreateDate);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setCreateDate_noev(Date argCreateDate) {
/* 177 */     boolean ev_postable = false;
/*     */     
/* 179 */     if ((getDAO_().getCreateDate() == null && argCreateDate != null) || (
/* 180 */       getDAO_().getCreateDate() != null && !getDAO_().getCreateDate().equals(argCreateDate))) {
/* 181 */       getDAO_().setCreateDate(argCreateDate);
/* 182 */       ev_postable = true;
/*     */     } 
/*     */     
/* 185 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getCreateUserId() {
/* 193 */     return getDAO_().getCreateUserId();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setCreateUserId(String argCreateUserId) {
/* 201 */     if (setCreateUserId_noev(argCreateUserId) && 
/* 202 */       this._events != null && 
/* 203 */       postEventsForChanges()) {
/* 204 */       this._events.post(IShippingFee.SET_CREATEUSERID, argCreateUserId);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setCreateUserId_noev(String argCreateUserId) {
/* 211 */     boolean ev_postable = false;
/*     */     
/* 213 */     if ((getDAO_().getCreateUserId() == null && argCreateUserId != null) || (
/* 214 */       getDAO_().getCreateUserId() != null && !getDAO_().getCreateUserId().equals(argCreateUserId))) {
/* 215 */       getDAO_().setCreateUserId(argCreateUserId);
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
/*     */   public Date getUpdateDate() {
/* 227 */     return getDAO_().getUpdateDate();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setUpdateDate(Date argUpdateDate) {
/* 235 */     if (setUpdateDate_noev(argUpdateDate) && 
/* 236 */       this._events != null && 
/* 237 */       postEventsForChanges()) {
/* 238 */       this._events.post(IShippingFee.SET_UPDATEDATE, argUpdateDate);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setUpdateDate_noev(Date argUpdateDate) {
/* 245 */     boolean ev_postable = false;
/*     */     
/* 247 */     if ((getDAO_().getUpdateDate() == null && argUpdateDate != null) || (
/* 248 */       getDAO_().getUpdateDate() != null && !getDAO_().getUpdateDate().equals(argUpdateDate))) {
/* 249 */       getDAO_().setUpdateDate(argUpdateDate);
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
/*     */   public String getUpdateUserId() {
/* 261 */     return getDAO_().getUpdateUserId();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setUpdateUserId(String argUpdateUserId) {
/* 269 */     if (setUpdateUserId_noev(argUpdateUserId) && 
/* 270 */       this._events != null && 
/* 271 */       postEventsForChanges()) {
/* 272 */       this._events.post(IShippingFee.SET_UPDATEUSERID, argUpdateUserId);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setUpdateUserId_noev(String argUpdateUserId) {
/* 279 */     boolean ev_postable = false;
/*     */     
/* 281 */     if ((getDAO_().getUpdateUserId() == null && argUpdateUserId != null) || (
/* 282 */       getDAO_().getUpdateUserId() != null && !getDAO_().getUpdateUserId().equals(argUpdateUserId))) {
/* 283 */       getDAO_().setUpdateUserId(argUpdateUserId);
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
/*     */   public String getOrgCode() {
/* 295 */     return getDAO_().getOrgCode();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setOrgCode(String argOrgCode) {
/* 303 */     if (setOrgCode_noev(argOrgCode) && 
/* 304 */       this._events != null && 
/* 305 */       postEventsForChanges()) {
/* 306 */       this._events.post(IShippingFee.SET_ORGCODE, argOrgCode);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setOrgCode_noev(String argOrgCode) {
/* 313 */     boolean ev_postable = false;
/*     */     
/* 315 */     if ((getDAO_().getOrgCode() == null && argOrgCode != null) || (
/* 316 */       getDAO_().getOrgCode() != null && !getDAO_().getOrgCode().equals(argOrgCode))) {
/* 317 */       getDAO_().setOrgCode(argOrgCode);
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
/*     */   public String getOrgValue() {
/* 329 */     return getDAO_().getOrgValue();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setOrgValue(String argOrgValue) {
/* 337 */     if (setOrgValue_noev(argOrgValue) && 
/* 338 */       this._events != null && 
/* 339 */       postEventsForChanges()) {
/* 340 */       this._events.post(IShippingFee.SET_ORGVALUE, argOrgValue);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setOrgValue_noev(String argOrgValue) {
/* 347 */     boolean ev_postable = false;
/*     */     
/* 349 */     if ((getDAO_().getOrgValue() == null && argOrgValue != null) || (
/* 350 */       getDAO_().getOrgValue() != null && !getDAO_().getOrgValue().equals(argOrgValue))) {
/* 351 */       getDAO_().setOrgValue(argOrgValue);
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
/*     */   public long getPriority() {
/* 363 */     if (getDAO_().getPriority() != null) {
/* 364 */       return getDAO_().getPriority().longValue();
/*     */     }
/*     */     
/* 367 */     return 0L;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setPriority(long argPriority) {
/* 376 */     if (setPriority_noev(argPriority) && 
/* 377 */       this._events != null && 
/* 378 */       postEventsForChanges()) {
/* 379 */       this._events.post(IShippingFee.SET_PRIORITY, Long.valueOf(argPriority));
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setPriority_noev(long argPriority) {
/* 386 */     boolean ev_postable = false;
/*     */     
/* 388 */     if ((getDAO_().getPriority() == null && Long.valueOf(argPriority) != null) || (
/* 389 */       getDAO_().getPriority() != null && !getDAO_().getPriority().equals(Long.valueOf(argPriority)))) {
/* 390 */       getDAO_().setPriority(Long.valueOf(argPriority));
/* 391 */       ev_postable = true;
/*     */     } 
/*     */     
/* 394 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getShipItemID() {
/* 402 */     return getDAO_().getShipItemID();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setShipItemID(String argShipItemID) {
/* 410 */     if (setShipItemID_noev(argShipItemID) && 
/* 411 */       this._events != null && 
/* 412 */       postEventsForChanges()) {
/* 413 */       this._events.post(IShippingFee.SET_SHIPITEMID, argShipItemID);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setShipItemID_noev(String argShipItemID) {
/* 420 */     boolean ev_postable = false;
/*     */     
/* 422 */     if ((getDAO_().getShipItemID() == null && argShipItemID != null) || (
/* 423 */       getDAO_().getShipItemID() != null && !getDAO_().getShipItemID().equals(argShipItemID))) {
/* 424 */       getDAO_().setShipItemID(argShipItemID);
/* 425 */       ev_postable = true;
/*     */     } 
/*     */     
/* 428 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getAggregationType() {
/* 436 */     return getDAO_().getAggregationType();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setAggregationType(String argAggregationType) {
/* 444 */     if (setAggregationType_noev(argAggregationType) && 
/* 445 */       this._events != null && 
/* 446 */       postEventsForChanges()) {
/* 447 */       this._events.post(IShippingFee.SET_AGGREGATIONTYPE, argAggregationType);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setAggregationType_noev(String argAggregationType) {
/* 454 */     boolean ev_postable = false;
/*     */     
/* 456 */     if ((getDAO_().getAggregationType() == null && argAggregationType != null) || (
/* 457 */       getDAO_().getAggregationType() != null && !getDAO_().getAggregationType().equals(argAggregationType))) {
/* 458 */       getDAO_().setAggregationType(argAggregationType);
/* 459 */       ev_postable = true;
/*     */     } 
/*     */     
/* 462 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getRuleType() {
/* 470 */     return getDAO_().getRuleType();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setRuleType(String argRuleType) {
/* 478 */     if (setRuleType_noev(argRuleType) && 
/* 479 */       this._events != null && 
/* 480 */       postEventsForChanges()) {
/* 481 */       this._events.post(IShippingFee.SET_RULETYPE, argRuleType);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setRuleType_noev(String argRuleType) {
/* 488 */     boolean ev_postable = false;
/*     */     
/* 490 */     if ((getDAO_().getRuleType() == null && argRuleType != null) || (
/* 491 */       getDAO_().getRuleType() != null && !getDAO_().getRuleType().equals(argRuleType))) {
/* 492 */       getDAO_().setRuleType(argRuleType);
/* 493 */       ev_postable = true;
/*     */     } 
/*     */     
/* 496 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getParam1() {
/* 504 */     return getDAO_().getParam1();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setParam1(String argParam1) {
/* 512 */     if (setParam1_noev(argParam1) && 
/* 513 */       this._events != null && 
/* 514 */       postEventsForChanges()) {
/* 515 */       this._events.post(IShippingFee.SET_PARAM1, argParam1);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setParam1_noev(String argParam1) {
/* 522 */     boolean ev_postable = false;
/*     */     
/* 524 */     if ((getDAO_().getParam1() == null && argParam1 != null) || (
/* 525 */       getDAO_().getParam1() != null && !getDAO_().getParam1().equals(argParam1))) {
/* 526 */       getDAO_().setParam1(argParam1);
/* 527 */       ev_postable = true;
/*     */     } 
/*     */     
/* 530 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getParam2() {
/* 538 */     return getDAO_().getParam2();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setParam2(String argParam2) {
/* 546 */     if (setParam2_noev(argParam2) && 
/* 547 */       this._events != null && 
/* 548 */       postEventsForChanges()) {
/* 549 */       this._events.post(IShippingFee.SET_PARAM2, argParam2);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setParam2_noev(String argParam2) {
/* 556 */     boolean ev_postable = false;
/*     */     
/* 558 */     if ((getDAO_().getParam2() == null && argParam2 != null) || (
/* 559 */       getDAO_().getParam2() != null && !getDAO_().getParam2().equals(argParam2))) {
/* 560 */       getDAO_().setParam2(argParam2);
/* 561 */       ev_postable = true;
/*     */     } 
/*     */     
/* 564 */     return ev_postable;
/*     */   }
/*     */   
/*     */   protected IShippingFeeProperty newProperty(String argPropertyName) {
/* 568 */     ShippingFeePropertyId id = new ShippingFeePropertyId();
/*     */     
/* 570 */     id.setRuleName(getRuleName());
/* 571 */     id.setPropertyCode(argPropertyName);
/*     */     
/* 573 */     IShippingFeeProperty prop = (IShippingFeeProperty)DataFactory.getInstance().createNewObject((IObjectId)id, IShippingFeeProperty.class);
/* 574 */     return prop;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @Relationship(name = "TieredFees")
/*     */   public List<IShippingFeeTier> getTieredFees() {
/* 586 */     if (this._tieredFees == null) {
/* 587 */       this._tieredFees = new HistoricalList(null);
/*     */     }
/* 589 */     return (List<IShippingFeeTier>)this._tieredFees;
/*     */   }
/*     */   
/*     */   public void setTieredFees(List<IShippingFeeTier> argTieredFees) {
/* 593 */     if (this._tieredFees == null) {
/* 594 */       this._tieredFees = new HistoricalList(argTieredFees);
/*     */     } else {
/* 596 */       this._tieredFees.setCurrentList(argTieredFees);
/*     */     } 
/*     */     
/* 599 */     for (IShippingFeeTier child : this._tieredFees) {
/* 600 */       ShippingFeeTierModel model = (ShippingFeeTierModel)child;
/* 601 */       model.setParentRuleName_noev(getRuleName());
/* 602 */       model.setOrganizationId_noev(getOrganizationId());
/* 603 */       if (child instanceof IDataModelImpl) {
/* 604 */         IDataAccessObject childDao = ((IDataModelImpl)child).getDAO();
/* 605 */         if (StringUtils.isEmpty(childDao.getOriginDataSource()) && 
/* 606 */           !StringUtils.isEmpty(getDAO().getOriginDataSource())) {
/* 607 */           childDao.setOriginDataSource(getDAO().getOriginDataSource());
/*     */         }
/*     */       } 
/* 610 */       if (postEventsForChanges()) {
/* 611 */         this._eventManager.registerEventHandler((IEventAware)this._eventCascade, (IEventSource)child);
/*     */       }
/*     */     } 
/*     */   }
/*     */   
/*     */   public void addShippingFeeTier(IShippingFeeTier argShippingFeeTier) {
/* 617 */     if (this._tieredFees == null) {
/* 618 */       this._tieredFees = new HistoricalList(null);
/*     */     }
/* 620 */     argShippingFeeTier.setParentRuleName(getRuleName());
/* 621 */     argShippingFeeTier.setOrganizationId(getOrganizationId());
/* 622 */     if (argShippingFeeTier instanceof IDataModelImpl) {
/* 623 */       IDataAccessObject childDao = ((IDataModelImpl)argShippingFeeTier).getDAO();
/* 624 */       if (StringUtils.isEmpty(childDao.getOriginDataSource()) && 
/* 625 */         !StringUtils.isEmpty(getDAO().getOriginDataSource())) {
/* 626 */         childDao.setOriginDataSource(getDAO().getOriginDataSource());
/*     */       }
/*     */     } 
/*     */ 
/*     */     
/* 631 */     if (postEventsForChanges()) {
/* 632 */       this._eventManager.registerEventHandler((IEventAware)this._eventCascade, (IEventSource)new EventDescriptor(argShippingFeeTier));
/*     */     }
/*     */     
/* 635 */     this._tieredFees.add(argShippingFeeTier);
/* 636 */     if (postEventsForChanges()) {
/* 637 */       this._events.post(IShippingFee.ADD_TIEREDFEES, argShippingFeeTier);
/*     */     }
/*     */   }
/*     */   
/*     */   public void removeShippingFeeTier(IShippingFeeTier argShippingFeeTier) {
/* 642 */     if (this._tieredFees != null) {
/*     */       
/* 644 */       if (postEventsForChanges()) {
/* 645 */         this._eventManager.deregisterEventHandler((IEventAware)this._eventCascade, (IEventSource)new EventDescriptor(argShippingFeeTier));
/*     */       }
/* 647 */       this._tieredFees.remove(argShippingFeeTier);
/* 648 */       if (postEventsForChanges()) {
/* 649 */         this._events.post(IShippingFee.REMOVE_TIEREDFEES, argShippingFeeTier);
/*     */       }
/*     */     } 
/*     */   }
/*     */   
/*     */   @Relationship(name = "Properties")
/*     */   public List<IShippingFeeProperty> getProperties() {
/* 656 */     if (this._properties == null) {
/* 657 */       this._properties = new HistoricalList(null);
/*     */     }
/* 659 */     return (List<IShippingFeeProperty>)this._properties;
/*     */   }
/*     */   
/*     */   public void setProperties(List<IShippingFeeProperty> argProperties) {
/* 663 */     if (this._properties == null) {
/* 664 */       this._properties = new HistoricalList(argProperties);
/*     */     } else {
/* 666 */       this._properties.setCurrentList(argProperties);
/*     */     } 
/*     */     
/* 669 */     for (IShippingFeeProperty child : this._properties) {
/* 670 */       ShippingFeePropertyModel model = (ShippingFeePropertyModel)child;
/* 671 */       model.setRuleName_noev(getRuleName());
/* 672 */       model.setOrganizationId_noev(getOrganizationId());
/* 673 */       if (child instanceof IDataModelImpl) {
/* 674 */         IDataAccessObject childDao = ((IDataModelImpl)child).getDAO();
/* 675 */         if (StringUtils.isEmpty(childDao.getOriginDataSource()) && 
/* 676 */           !StringUtils.isEmpty(getDAO().getOriginDataSource())) {
/* 677 */           childDao.setOriginDataSource(getDAO().getOriginDataSource());
/*     */         }
/*     */       } 
/* 680 */       if (postEventsForChanges()) {
/* 681 */         this._eventManager.registerEventHandler((IEventAware)this._eventCascade, (IEventSource)child);
/*     */       }
/*     */     } 
/*     */   }
/*     */   
/*     */   public void addShippingFeeProperty(IShippingFeeProperty argShippingFeeProperty) {
/* 687 */     if (this._properties == null) {
/* 688 */       this._properties = new HistoricalList(null);
/*     */     }
/* 690 */     argShippingFeeProperty.setRuleName(getRuleName());
/* 691 */     argShippingFeeProperty.setOrganizationId(getOrganizationId());
/* 692 */     if (argShippingFeeProperty instanceof IDataModelImpl) {
/* 693 */       IDataAccessObject childDao = ((IDataModelImpl)argShippingFeeProperty).getDAO();
/* 694 */       if (StringUtils.isEmpty(childDao.getOriginDataSource()) && 
/* 695 */         !StringUtils.isEmpty(getDAO().getOriginDataSource())) {
/* 696 */         childDao.setOriginDataSource(getDAO().getOriginDataSource());
/*     */       }
/*     */     } 
/*     */ 
/*     */     
/* 701 */     if (postEventsForChanges()) {
/* 702 */       this._eventManager.registerEventHandler((IEventAware)this._eventCascade, (IEventSource)new EventDescriptor(argShippingFeeProperty));
/*     */     }
/*     */     
/* 705 */     this._properties.add(argShippingFeeProperty);
/* 706 */     if (postEventsForChanges()) {
/* 707 */       this._events.post(IShippingFee.ADD_PROPERTIES, argShippingFeeProperty);
/*     */     }
/*     */   }
/*     */   
/*     */   public void removeShippingFeeProperty(IShippingFeeProperty argShippingFeeProperty) {
/* 712 */     if (this._properties != null) {
/*     */       
/* 714 */       if (postEventsForChanges()) {
/* 715 */         this._eventManager.deregisterEventHandler((IEventAware)this._eventCascade, (IEventSource)new EventDescriptor(argShippingFeeProperty));
/*     */       }
/* 717 */       this._properties.remove(argShippingFeeProperty);
/* 718 */       if (postEventsForChanges()) {
/* 719 */         this._events.post(IShippingFee.REMOVE_PROPERTIES, argShippingFeeProperty);
/*     */       }
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public Object getValue(String argFieldId) {
/* 726 */     if ("TieredFees".equals(argFieldId)) {
/* 727 */       return getTieredFees();
/*     */     }
/* 729 */     if ("Properties".equals(argFieldId)) {
/* 730 */       return getProperties();
/*     */     }
/* 732 */     if ("ShippingFeeExtension".equals(argFieldId)) {
/* 733 */       return this._myExtension;
/*     */     }
/*     */     
/* 736 */     return super.getValue(argFieldId);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void setValue(String argFieldId, Object argValue) {
/* 742 */     if ("TieredFees".equals(argFieldId)) {
/* 743 */       setTieredFees(changeToList(argValue, IShippingFeeTier.class));
/*     */     }
/* 745 */     else if ("Properties".equals(argFieldId)) {
/* 746 */       setProperties(changeToList(argValue, IShippingFeeProperty.class));
/*     */     }
/* 748 */     else if ("ShippingFeeExtension".equals(argFieldId)) {
/* 749 */       this._myExtension = (IDataModel)argValue;
/*     */     } else {
/*     */       
/* 752 */       super.setValue(argFieldId, argValue);
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public void setDependencies(IPersistenceDefaults argPD, EventManager argEM) {
/* 758 */     this._persistenceDefaults = argPD;
/* 759 */     this._daoImpl.setPersistenceDefaults(argPD);
/* 760 */     this._eventManager = argEM;
/* 761 */     this._events = (Eventor)new ModelEventor((IDataModel)this, argEM);
/* 762 */     this._eventCascade = (EventHandler)new CascadingHandler(this);
/* 763 */     if (this._tieredFees != null) {
/* 764 */       for (IShippingFeeTier relationship : this._tieredFees) {
/* 765 */         ((IDataModelImpl)relationship).setDependencies(argPD, argEM);
/*     */       }
/*     */     }
/* 768 */     if (this._properties != null) {
/* 769 */       for (IShippingFeeProperty relationship : this._properties) {
/* 770 */         ((IDataModelImpl)relationship).setDependencies(argPD, argEM);
/*     */       }
/*     */     }
/*     */   }
/*     */   
/*     */   public IDataModel getShippingFeeExt() {
/* 776 */     return this._myExtension;
/*     */   }
/*     */   
/*     */   public void setShippingFeeExt(IDataModel argExt) {
/* 780 */     this._myExtension = argExt;
/*     */   }
/*     */ 
/*     */   
/*     */   public void startTransaction() {
/* 785 */     if (this._alreadyInStart) {
/*     */       return;
/*     */     }
/*     */     
/* 789 */     this._alreadyInStart = true;
/*     */ 
/*     */     
/* 792 */     super.startTransaction();
/*     */     
/* 794 */     this._tieredFeesSavepoint = this._tieredFees;
/* 795 */     if (this._tieredFees != null) {
/* 796 */       this._tieredFeesSavepoint = new HistoricalList((List)this._tieredFees);
/* 797 */       Iterator<IDataModel> it = this._tieredFees.iterator();
/* 798 */       while (it.hasNext()) {
/* 799 */         ((IDataModel)it.next()).startTransaction();
/*     */       }
/*     */     } 
/*     */     
/* 803 */     this._propertiesSavepoint = this._properties;
/* 804 */     if (this._properties != null) {
/* 805 */       this._propertiesSavepoint = new HistoricalList((List)this._properties);
/* 806 */       Iterator<IDataModel> it = this._properties.iterator();
/* 807 */       while (it.hasNext()) {
/* 808 */         ((IDataModel)it.next()).startTransaction();
/*     */       }
/*     */     } 
/*     */ 
/*     */     
/* 813 */     this._alreadyInStart = false;
/*     */   }
/*     */ 
/*     */   
/*     */   public void rollbackChanges() {
/* 818 */     if (isAlreadyRolledBack()) {
/*     */       return;
/*     */     }
/* 821 */     super.rollbackChanges();
/*     */     
/* 823 */     this._tieredFees = this._tieredFeesSavepoint;
/* 824 */     this._tieredFeesSavepoint = null;
/* 825 */     if (this._tieredFees != null) {
/* 826 */       Iterator<IDataModel> it = this._tieredFees.iterator();
/* 827 */       while (it.hasNext()) {
/* 828 */         ((IDataModel)it.next()).rollbackChanges();
/*     */       }
/*     */     } 
/*     */     
/* 832 */     this._properties = this._propertiesSavepoint;
/* 833 */     this._propertiesSavepoint = null;
/* 834 */     if (this._properties != null) {
/* 835 */       Iterator<IDataModel> it = this._properties.iterator();
/* 836 */       while (it.hasNext()) {
/* 837 */         ((IDataModel)it.next()).rollbackChanges();
/*     */       }
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void commitTransaction() {
/* 845 */     if (this._alreadyInCommit) {
/*     */       return;
/*     */     }
/* 848 */     this._alreadyInCommit = true;
/*     */ 
/*     */     
/* 851 */     super.commitTransaction();
/*     */     
/* 853 */     this._tieredFeesSavepoint = this._tieredFees;
/* 854 */     if (this._tieredFees != null) {
/* 855 */       Iterator<IDataModel> it = this._tieredFees.iterator();
/* 856 */       while (it.hasNext()) {
/* 857 */         ((IDataModel)it.next()).commitTransaction();
/*     */       }
/* 859 */       this._tieredFees = new HistoricalList((List)this._tieredFees);
/*     */     } 
/*     */     
/* 862 */     this._propertiesSavepoint = this._properties;
/* 863 */     if (this._properties != null) {
/* 864 */       Iterator<IDataModel> it = this._properties.iterator();
/* 865 */       while (it.hasNext()) {
/* 866 */         ((IDataModel)it.next()).commitTransaction();
/*     */       }
/* 868 */       this._properties = new HistoricalList((List)this._properties);
/*     */     } 
/*     */ 
/*     */     
/* 872 */     this._alreadyInCommit = false;
/*     */   }
/*     */ 
/*     */   
/*     */   private void readObject(ObjectInputStream argStream) throws IOException, ClassNotFoundException {
/* 877 */     argStream.defaultReadObject();
/*     */   }
/*     */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\com\impl\ShippingFeeModel.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */