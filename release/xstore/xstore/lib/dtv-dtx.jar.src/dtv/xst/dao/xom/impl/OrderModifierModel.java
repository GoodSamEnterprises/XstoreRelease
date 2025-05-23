/*     */ package dtv.xst.dao.xom.impl;
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
/*     */ import dtv.xst.dao.trl.ISaleReturnLineItem;
/*     */ import dtv.xst.dao.xom.IOrderModifier;
/*     */ import dtv.xst.dao.xom.IOrderModifierProperty;
/*     */ import dtv.xst.dao.xom.OrderModifierPropertyId;
/*     */ import java.io.IOException;
/*     */ import java.io.ObjectInputStream;
/*     */ import java.util.Date;
/*     */ import java.util.Iterator;
/*     */ import java.util.List;
/*     */ 
/*     */ public class OrderModifierModel extends AbstractDataModelWithPropertyImpl<IOrderModifierProperty> implements IOrderModifier {
/*     */   private static final long serialVersionUID = 2004742181L;
/*     */   private ISaleReturnLineItem _parentLine;
/*     */   private transient boolean _alreadyInStart = false;
/*     */   
/*     */   public String toString() {
/*  35 */     return super.toString() + " Id: " + getObjectId();
/*     */   }
/*     */   private transient boolean _alreadyInCommit = false; private IDataModel _myExtension; private HistoricalList<IOrderModifierProperty> _properties; private transient HistoricalList<IOrderModifierProperty> _propertiesSavepoint;
/*     */   
/*     */   public void initDAO() {
/*  40 */     setDAO((IDataAccessObject)new OrderModifierDAO());
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private OrderModifierDAO getDAO_() {
/*  48 */     return (OrderModifierDAO)this._daoImpl;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public long getOrganizationId() {
/*  56 */     if (getDAO_().getOrganizationId() != null) {
/*  57 */       return getDAO_().getOrganizationId().longValue();
/*     */     }
/*     */     
/*  60 */     return 0L;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setOrganizationId(long argOrganizationId) {
/*  69 */     if (setOrganizationId_noev(argOrganizationId) && 
/*  70 */       this._events != null && 
/*  71 */       postEventsForChanges()) {
/*  72 */       this._events.post(IOrderModifier.SET_ORGANIZATIONID, Long.valueOf(argOrganizationId));
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setOrganizationId_noev(long argOrganizationId) {
/*  79 */     boolean ev_postable = false;
/*     */     
/*  81 */     if ((getDAO_().getOrganizationId() == null && Long.valueOf(argOrganizationId) != null) || (
/*  82 */       getDAO_().getOrganizationId() != null && !getDAO_().getOrganizationId().equals(Long.valueOf(argOrganizationId)))) {
/*  83 */       getDAO_().setOrganizationId(Long.valueOf(argOrganizationId));
/*  84 */       ev_postable = true;
/*  85 */       if (this._properties != null) {
/*     */         
/*  87 */         Iterator<OrderModifierPropertyModel> it = this._properties.iterator();
/*  88 */         while (it.hasNext())
/*     */         {
/*  90 */           ((OrderModifierPropertyModel)it.next()).setOrganizationId_noev(argOrganizationId);
/*     */         }
/*     */       } 
/*     */     } 
/*     */     
/*  95 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public long getRetailLocationId() {
/* 103 */     if (getDAO_().getRetailLocationId() != null) {
/* 104 */       return getDAO_().getRetailLocationId().longValue();
/*     */     }
/*     */     
/* 107 */     return 0L;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setRetailLocationId(long argRetailLocationId) {
/* 116 */     if (setRetailLocationId_noev(argRetailLocationId) && 
/* 117 */       this._events != null && 
/* 118 */       postEventsForChanges()) {
/* 119 */       this._events.post(IOrderModifier.SET_RETAILLOCATIONID, Long.valueOf(argRetailLocationId));
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setRetailLocationId_noev(long argRetailLocationId) {
/* 126 */     boolean ev_postable = false;
/*     */     
/* 128 */     if ((getDAO_().getRetailLocationId() == null && Long.valueOf(argRetailLocationId) != null) || (
/* 129 */       getDAO_().getRetailLocationId() != null && !getDAO_().getRetailLocationId().equals(Long.valueOf(argRetailLocationId)))) {
/* 130 */       getDAO_().setRetailLocationId(Long.valueOf(argRetailLocationId));
/* 131 */       ev_postable = true;
/* 132 */       if (this._properties != null) {
/*     */         
/* 134 */         Iterator<OrderModifierPropertyModel> it = this._properties.iterator();
/* 135 */         while (it.hasNext())
/*     */         {
/* 137 */           ((OrderModifierPropertyModel)it.next()).setRetailLocationId_noev(argRetailLocationId);
/*     */         }
/*     */       } 
/*     */     } 
/*     */     
/* 142 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Date getBusinessDate() {
/* 150 */     return getDAO_().getBusinessDate();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setBusinessDate(Date argBusinessDate) {
/* 158 */     if (setBusinessDate_noev(argBusinessDate) && 
/* 159 */       this._events != null && 
/* 160 */       postEventsForChanges()) {
/* 161 */       this._events.post(IOrderModifier.SET_BUSINESSDATE, argBusinessDate);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setBusinessDate_noev(Date argBusinessDate) {
/* 168 */     boolean ev_postable = false;
/*     */     
/* 170 */     if ((getDAO_().getBusinessDate() == null && argBusinessDate != null) || (
/* 171 */       getDAO_().getBusinessDate() != null && !getDAO_().getBusinessDate().equals(argBusinessDate))) {
/* 172 */       getDAO_().setBusinessDate(argBusinessDate);
/* 173 */       ev_postable = true;
/* 174 */       if (this._properties != null) {
/*     */         
/* 176 */         Iterator<OrderModifierPropertyModel> it = this._properties.iterator();
/* 177 */         while (it.hasNext())
/*     */         {
/* 179 */           ((OrderModifierPropertyModel)it.next()).setBusinessDate_noev(argBusinessDate);
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
/*     */   public long getWorkstationId() {
/* 192 */     if (getDAO_().getWorkstationId() != null) {
/* 193 */       return getDAO_().getWorkstationId().longValue();
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
/*     */   public void setWorkstationId(long argWorkstationId) {
/* 205 */     if (setWorkstationId_noev(argWorkstationId) && 
/* 206 */       this._events != null && 
/* 207 */       postEventsForChanges()) {
/* 208 */       this._events.post(IOrderModifier.SET_WORKSTATIONID, Long.valueOf(argWorkstationId));
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setWorkstationId_noev(long argWorkstationId) {
/* 215 */     boolean ev_postable = false;
/*     */     
/* 217 */     if ((getDAO_().getWorkstationId() == null && Long.valueOf(argWorkstationId) != null) || (
/* 218 */       getDAO_().getWorkstationId() != null && !getDAO_().getWorkstationId().equals(Long.valueOf(argWorkstationId)))) {
/* 219 */       getDAO_().setWorkstationId(Long.valueOf(argWorkstationId));
/* 220 */       ev_postable = true;
/* 221 */       if (this._properties != null) {
/*     */         
/* 223 */         Iterator<OrderModifierPropertyModel> it = this._properties.iterator();
/* 224 */         while (it.hasNext())
/*     */         {
/* 226 */           ((OrderModifierPropertyModel)it.next()).setWorkstationId_noev(argWorkstationId);
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
/*     */   public long getTransactionSequence() {
/* 239 */     if (getDAO_().getTransactionSequence() != null) {
/* 240 */       return getDAO_().getTransactionSequence().longValue();
/*     */     }
/*     */     
/* 243 */     return 0L;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setTransactionSequence(long argTransactionSequence) {
/* 252 */     if (setTransactionSequence_noev(argTransactionSequence) && 
/* 253 */       this._events != null && 
/* 254 */       postEventsForChanges()) {
/* 255 */       this._events.post(IOrderModifier.SET_TRANSACTIONSEQUENCE, Long.valueOf(argTransactionSequence));
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setTransactionSequence_noev(long argTransactionSequence) {
/* 262 */     boolean ev_postable = false;
/*     */     
/* 264 */     if ((getDAO_().getTransactionSequence() == null && Long.valueOf(argTransactionSequence) != null) || (
/* 265 */       getDAO_().getTransactionSequence() != null && !getDAO_().getTransactionSequence().equals(Long.valueOf(argTransactionSequence)))) {
/* 266 */       getDAO_().setTransactionSequence(Long.valueOf(argTransactionSequence));
/* 267 */       ev_postable = true;
/* 268 */       if (this._properties != null) {
/*     */         
/* 270 */         Iterator<OrderModifierPropertyModel> it = this._properties.iterator();
/* 271 */         while (it.hasNext())
/*     */         {
/* 273 */           ((OrderModifierPropertyModel)it.next()).setTransactionSequence_noev(argTransactionSequence);
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
/*     */   public int getRetailTransactionLineItemSequence() {
/* 286 */     if (getDAO_().getRetailTransactionLineItemSequence() != null) {
/* 287 */       return getDAO_().getRetailTransactionLineItemSequence().intValue();
/*     */     }
/*     */     
/* 290 */     return 0;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setRetailTransactionLineItemSequence(int argRetailTransactionLineItemSequence) {
/* 299 */     if (setRetailTransactionLineItemSequence_noev(argRetailTransactionLineItemSequence) && 
/* 300 */       this._events != null && 
/* 301 */       postEventsForChanges()) {
/* 302 */       this._events.post(IOrderModifier.SET_RETAILTRANSACTIONLINEITEMSEQUENCE, Integer.valueOf(argRetailTransactionLineItemSequence));
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setRetailTransactionLineItemSequence_noev(int argRetailTransactionLineItemSequence) {
/* 309 */     boolean ev_postable = false;
/*     */     
/* 311 */     if ((getDAO_().getRetailTransactionLineItemSequence() == null && Integer.valueOf(argRetailTransactionLineItemSequence) != null) || (
/* 312 */       getDAO_().getRetailTransactionLineItemSequence() != null && !getDAO_().getRetailTransactionLineItemSequence().equals(Integer.valueOf(argRetailTransactionLineItemSequence)))) {
/* 313 */       getDAO_().setRetailTransactionLineItemSequence(Integer.valueOf(argRetailTransactionLineItemSequence));
/* 314 */       ev_postable = true;
/* 315 */       if (this._properties != null) {
/*     */         
/* 317 */         Iterator<OrderModifierPropertyModel> it = this._properties.iterator();
/* 318 */         while (it.hasNext())
/*     */         {
/* 320 */           ((OrderModifierPropertyModel)it.next()).setRetailTransactionLineItemSequence_noev(argRetailTransactionLineItemSequence);
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
/*     */   public Date getCreateDate() {
/* 333 */     return getDAO_().getCreateDate();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setCreateDate(Date argCreateDate) {
/* 341 */     if (setCreateDate_noev(argCreateDate) && 
/* 342 */       this._events != null && 
/* 343 */       postEventsForChanges()) {
/* 344 */       this._events.post(IOrderModifier.SET_CREATEDATE, argCreateDate);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setCreateDate_noev(Date argCreateDate) {
/* 351 */     boolean ev_postable = false;
/*     */     
/* 353 */     if ((getDAO_().getCreateDate() == null && argCreateDate != null) || (
/* 354 */       getDAO_().getCreateDate() != null && !getDAO_().getCreateDate().equals(argCreateDate))) {
/* 355 */       getDAO_().setCreateDate(argCreateDate);
/* 356 */       ev_postable = true;
/*     */     } 
/*     */     
/* 359 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getCreateUserId() {
/* 367 */     return getDAO_().getCreateUserId();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setCreateUserId(String argCreateUserId) {
/* 375 */     if (setCreateUserId_noev(argCreateUserId) && 
/* 376 */       this._events != null && 
/* 377 */       postEventsForChanges()) {
/* 378 */       this._events.post(IOrderModifier.SET_CREATEUSERID, argCreateUserId);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setCreateUserId_noev(String argCreateUserId) {
/* 385 */     boolean ev_postable = false;
/*     */     
/* 387 */     if ((getDAO_().getCreateUserId() == null && argCreateUserId != null) || (
/* 388 */       getDAO_().getCreateUserId() != null && !getDAO_().getCreateUserId().equals(argCreateUserId))) {
/* 389 */       getDAO_().setCreateUserId(argCreateUserId);
/* 390 */       ev_postable = true;
/*     */     } 
/*     */     
/* 393 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Date getUpdateDate() {
/* 401 */     return getDAO_().getUpdateDate();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setUpdateDate(Date argUpdateDate) {
/* 409 */     if (setUpdateDate_noev(argUpdateDate) && 
/* 410 */       this._events != null && 
/* 411 */       postEventsForChanges()) {
/* 412 */       this._events.post(IOrderModifier.SET_UPDATEDATE, argUpdateDate);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setUpdateDate_noev(Date argUpdateDate) {
/* 419 */     boolean ev_postable = false;
/*     */     
/* 421 */     if ((getDAO_().getUpdateDate() == null && argUpdateDate != null) || (
/* 422 */       getDAO_().getUpdateDate() != null && !getDAO_().getUpdateDate().equals(argUpdateDate))) {
/* 423 */       getDAO_().setUpdateDate(argUpdateDate);
/* 424 */       ev_postable = true;
/*     */     } 
/*     */     
/* 427 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getUpdateUserId() {
/* 435 */     return getDAO_().getUpdateUserId();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setUpdateUserId(String argUpdateUserId) {
/* 443 */     if (setUpdateUserId_noev(argUpdateUserId) && 
/* 444 */       this._events != null && 
/* 445 */       postEventsForChanges()) {
/* 446 */       this._events.post(IOrderModifier.SET_UPDATEUSERID, argUpdateUserId);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setUpdateUserId_noev(String argUpdateUserId) {
/* 453 */     boolean ev_postable = false;
/*     */     
/* 455 */     if ((getDAO_().getUpdateUserId() == null && argUpdateUserId != null) || (
/* 456 */       getDAO_().getUpdateUserId() != null && !getDAO_().getUpdateUserId().equals(argUpdateUserId))) {
/* 457 */       getDAO_().setUpdateUserId(argUpdateUserId);
/* 458 */       ev_postable = true;
/*     */     } 
/*     */     
/* 461 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getOrderId() {
/* 469 */     return getDAO_().getOrderId();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setOrderId(String argOrderId) {
/* 477 */     if (setOrderId_noev(argOrderId) && 
/* 478 */       this._events != null && 
/* 479 */       postEventsForChanges()) {
/* 480 */       this._events.post(IOrderModifier.SET_ORDERID, argOrderId);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setOrderId_noev(String argOrderId) {
/* 487 */     boolean ev_postable = false;
/*     */     
/* 489 */     if ((getDAO_().getOrderId() == null && argOrderId != null) || (
/* 490 */       getDAO_().getOrderId() != null && !getDAO_().getOrderId().equals(argOrderId))) {
/* 491 */       getDAO_().setOrderId(argOrderId);
/* 492 */       ev_postable = true;
/*     */     } 
/*     */     
/* 495 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getExternalOrderId() {
/* 503 */     return getDAO_().getExternalOrderId();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setExternalOrderId(String argExternalOrderId) {
/* 511 */     if (setExternalOrderId_noev(argExternalOrderId) && 
/* 512 */       this._events != null && 
/* 513 */       postEventsForChanges()) {
/* 514 */       this._events.post(IOrderModifier.SET_EXTERNALORDERID, argExternalOrderId);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setExternalOrderId_noev(String argExternalOrderId) {
/* 521 */     boolean ev_postable = false;
/*     */     
/* 523 */     if ((getDAO_().getExternalOrderId() == null && argExternalOrderId != null) || (
/* 524 */       getDAO_().getExternalOrderId() != null && !getDAO_().getExternalOrderId().equals(argExternalOrderId))) {
/* 525 */       getDAO_().setExternalOrderId(argExternalOrderId);
/* 526 */       ev_postable = true;
/*     */     } 
/*     */     
/* 529 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getOrderType() {
/* 537 */     return getDAO_().getOrderType();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setOrderType(String argOrderType) {
/* 545 */     if (setOrderType_noev(argOrderType) && 
/* 546 */       this._events != null && 
/* 547 */       postEventsForChanges()) {
/* 548 */       this._events.post(IOrderModifier.SET_ORDERTYPE, argOrderType);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setOrderType_noev(String argOrderType) {
/* 555 */     boolean ev_postable = false;
/*     */     
/* 557 */     if ((getDAO_().getOrderType() == null && argOrderType != null) || (
/* 558 */       getDAO_().getOrderType() != null && !getDAO_().getOrderType().equals(argOrderType))) {
/* 559 */       getDAO_().setOrderType(argOrderType);
/* 560 */       ev_postable = true;
/*     */     } 
/*     */     
/* 563 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getDetailType() {
/* 571 */     return getDAO_().getDetailType();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setDetailType(String argDetailType) {
/* 579 */     if (setDetailType_noev(argDetailType) && 
/* 580 */       this._events != null && 
/* 581 */       postEventsForChanges()) {
/* 582 */       this._events.post(IOrderModifier.SET_DETAILTYPE, argDetailType);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setDetailType_noev(String argDetailType) {
/* 589 */     boolean ev_postable = false;
/*     */     
/* 591 */     if ((getDAO_().getDetailType() == null && argDetailType != null) || (
/* 592 */       getDAO_().getDetailType() != null && !getDAO_().getDetailType().equals(argDetailType))) {
/* 593 */       getDAO_().setDetailType(argDetailType);
/* 594 */       ev_postable = true;
/*     */     } 
/*     */     
/* 597 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int getDetailSequence() {
/* 605 */     if (getDAO_().getDetailSequence() != null) {
/* 606 */       return getDAO_().getDetailSequence().intValue();
/*     */     }
/*     */     
/* 609 */     return 0;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setDetailSequence(int argDetailSequence) {
/* 618 */     if (setDetailSequence_noev(argDetailSequence) && 
/* 619 */       this._events != null && 
/* 620 */       postEventsForChanges()) {
/* 621 */       this._events.post(IOrderModifier.SET_DETAILSEQUENCE, Integer.valueOf(argDetailSequence));
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setDetailSequence_noev(int argDetailSequence) {
/* 628 */     boolean ev_postable = false;
/*     */     
/* 630 */     if ((getDAO_().getDetailSequence() == null && Integer.valueOf(argDetailSequence) != null) || (
/* 631 */       getDAO_().getDetailSequence() != null && !getDAO_().getDetailSequence().equals(Integer.valueOf(argDetailSequence)))) {
/* 632 */       getDAO_().setDetailSequence(Integer.valueOf(argDetailSequence));
/* 633 */       ev_postable = true;
/*     */     } 
/*     */     
/* 636 */     return ev_postable;
/*     */   }
/*     */   
/*     */   protected IOrderModifierProperty newProperty(String argPropertyName) {
/* 640 */     OrderModifierPropertyId id = new OrderModifierPropertyId();
/*     */     
/* 642 */     id.setRetailLocationId(Long.valueOf(getRetailLocationId()));
/* 643 */     id.setBusinessDate(getBusinessDate());
/* 644 */     id.setWorkstationId(Long.valueOf(getWorkstationId()));
/* 645 */     id.setTransactionSequence(Long.valueOf(getTransactionSequence()));
/* 646 */     id.setRetailTransactionLineItemSequence(Integer.valueOf(getRetailTransactionLineItemSequence()));
/* 647 */     id.setPropertyCode(argPropertyName);
/*     */     
/* 649 */     IOrderModifierProperty prop = (IOrderModifierProperty)DataFactory.getInstance().createNewObject((IObjectId)id, IOrderModifierProperty.class);
/* 650 */     return prop;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @Relationship(name = "Properties")
/*     */   public List<IOrderModifierProperty> getProperties() {
/* 659 */     if (this._properties == null) {
/* 660 */       this._properties = new HistoricalList(null);
/*     */     }
/* 662 */     return (List<IOrderModifierProperty>)this._properties;
/*     */   }
/*     */   
/*     */   public void setProperties(List<IOrderModifierProperty> argProperties) {
/* 666 */     if (this._properties == null) {
/* 667 */       this._properties = new HistoricalList(argProperties);
/*     */     } else {
/* 669 */       this._properties.setCurrentList(argProperties);
/*     */     } 
/*     */     
/* 672 */     for (IOrderModifierProperty child : this._properties) {
/* 673 */       OrderModifierPropertyModel model = (OrderModifierPropertyModel)child;
/* 674 */       model.setOrganizationId_noev(getOrganizationId());
/* 675 */       model.setRetailLocationId_noev(getRetailLocationId());
/* 676 */       model.setBusinessDate_noev(getBusinessDate());
/* 677 */       model.setWorkstationId_noev(getWorkstationId());
/* 678 */       model.setTransactionSequence_noev(getTransactionSequence());
/* 679 */       model.setRetailTransactionLineItemSequence_noev(getRetailTransactionLineItemSequence());
/* 680 */       if (child instanceof IDataModelImpl) {
/* 681 */         IDataAccessObject childDao = ((IDataModelImpl)child).getDAO();
/* 682 */         if (StringUtils.isEmpty(childDao.getOriginDataSource()) && 
/* 683 */           !StringUtils.isEmpty(getDAO().getOriginDataSource())) {
/* 684 */           childDao.setOriginDataSource(getDAO().getOriginDataSource());
/*     */         }
/*     */       } 
/* 687 */       if (postEventsForChanges()) {
/* 688 */         this._eventManager.registerEventHandler((IEventAware)this._eventCascade, (IEventSource)child);
/*     */       }
/*     */     } 
/*     */   }
/*     */   
/*     */   public void addOrderModifierProperty(IOrderModifierProperty argOrderModifierProperty) {
/* 694 */     if (this._properties == null) {
/* 695 */       this._properties = new HistoricalList(null);
/*     */     }
/* 697 */     argOrderModifierProperty.setOrganizationId(getOrganizationId());
/* 698 */     argOrderModifierProperty.setRetailLocationId(getRetailLocationId());
/* 699 */     argOrderModifierProperty.setBusinessDate(getBusinessDate());
/* 700 */     argOrderModifierProperty.setWorkstationId(getWorkstationId());
/* 701 */     argOrderModifierProperty.setTransactionSequence(getTransactionSequence());
/* 702 */     argOrderModifierProperty.setRetailTransactionLineItemSequence(getRetailTransactionLineItemSequence());
/* 703 */     if (argOrderModifierProperty instanceof IDataModelImpl) {
/* 704 */       IDataAccessObject childDao = ((IDataModelImpl)argOrderModifierProperty).getDAO();
/* 705 */       if (StringUtils.isEmpty(childDao.getOriginDataSource()) && 
/* 706 */         !StringUtils.isEmpty(getDAO().getOriginDataSource())) {
/* 707 */         childDao.setOriginDataSource(getDAO().getOriginDataSource());
/*     */       }
/*     */     } 
/*     */ 
/*     */     
/* 712 */     if (postEventsForChanges()) {
/* 713 */       this._eventManager.registerEventHandler((IEventAware)this._eventCascade, (IEventSource)new EventDescriptor(argOrderModifierProperty));
/*     */     }
/*     */     
/* 716 */     this._properties.add(argOrderModifierProperty);
/* 717 */     if (postEventsForChanges()) {
/* 718 */       this._events.post(IOrderModifier.ADD_PROPERTIES, argOrderModifierProperty);
/*     */     }
/*     */   }
/*     */   
/*     */   public void removeOrderModifierProperty(IOrderModifierProperty argOrderModifierProperty) {
/* 723 */     if (this._properties != null) {
/*     */       
/* 725 */       if (postEventsForChanges()) {
/* 726 */         this._eventManager.deregisterEventHandler((IEventAware)this._eventCascade, (IEventSource)new EventDescriptor(argOrderModifierProperty));
/*     */       }
/* 728 */       this._properties.remove(argOrderModifierProperty);
/* 729 */       if (postEventsForChanges()) {
/* 730 */         this._events.post(IOrderModifier.REMOVE_PROPERTIES, argOrderModifierProperty);
/*     */       }
/*     */     } 
/*     */   }
/*     */   
/*     */   public void setParentLine(ISaleReturnLineItem argParentLine) {
/* 736 */     this._parentLine = argParentLine;
/*     */   }
/*     */   
/*     */   public ISaleReturnLineItem getParentLine() {
/* 740 */     return this._parentLine;
/*     */   }
/*     */ 
/*     */   
/*     */   public Object getValue(String argFieldId) {
/* 745 */     if ("Properties".equals(argFieldId)) {
/* 746 */       return getProperties();
/*     */     }
/* 748 */     if ("OrderModifierExtension".equals(argFieldId)) {
/* 749 */       return this._myExtension;
/*     */     }
/*     */     
/* 752 */     return super.getValue(argFieldId);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void setValue(String argFieldId, Object argValue) {
/* 758 */     if ("Properties".equals(argFieldId)) {
/* 759 */       setProperties(changeToList(argValue, IOrderModifierProperty.class));
/*     */     }
/* 761 */     else if ("OrderModifierExtension".equals(argFieldId)) {
/* 762 */       this._myExtension = (IDataModel)argValue;
/*     */     } else {
/*     */       
/* 765 */       super.setValue(argFieldId, argValue);
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public void setDependencies(IPersistenceDefaults argPD, EventManager argEM) {
/* 771 */     this._persistenceDefaults = argPD;
/* 772 */     this._daoImpl.setPersistenceDefaults(argPD);
/* 773 */     this._eventManager = argEM;
/* 774 */     this._events = (Eventor)new ModelEventor((IDataModel)this, argEM);
/* 775 */     this._eventCascade = (EventHandler)new CascadingHandler(this);
/* 776 */     if (this._properties != null) {
/* 777 */       for (IOrderModifierProperty relationship : this._properties) {
/* 778 */         ((IDataModelImpl)relationship).setDependencies(argPD, argEM);
/*     */       }
/*     */     }
/*     */   }
/*     */   
/*     */   public IDataModel getOrderModifierExt() {
/* 784 */     return this._myExtension;
/*     */   }
/*     */   
/*     */   public void setOrderModifierExt(IDataModel argExt) {
/* 788 */     this._myExtension = argExt;
/*     */   }
/*     */ 
/*     */   
/*     */   public void startTransaction() {
/* 793 */     if (this._alreadyInStart) {
/*     */       return;
/*     */     }
/*     */     
/* 797 */     this._alreadyInStart = true;
/*     */ 
/*     */     
/* 800 */     super.startTransaction();
/*     */     
/* 802 */     this._propertiesSavepoint = this._properties;
/* 803 */     if (this._properties != null) {
/* 804 */       this._propertiesSavepoint = new HistoricalList((List)this._properties);
/* 805 */       Iterator<IDataModel> it = this._properties.iterator();
/* 806 */       while (it.hasNext()) {
/* 807 */         ((IDataModel)it.next()).startTransaction();
/*     */       }
/*     */     } 
/*     */ 
/*     */     
/* 812 */     this._alreadyInStart = false;
/*     */   }
/*     */ 
/*     */   
/*     */   public void rollbackChanges() {
/* 817 */     if (isAlreadyRolledBack()) {
/*     */       return;
/*     */     }
/* 820 */     super.rollbackChanges();
/*     */     
/* 822 */     this._properties = this._propertiesSavepoint;
/* 823 */     this._propertiesSavepoint = null;
/* 824 */     if (this._properties != null) {
/* 825 */       Iterator<IDataModel> it = this._properties.iterator();
/* 826 */       while (it.hasNext()) {
/* 827 */         ((IDataModel)it.next()).rollbackChanges();
/*     */       }
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void commitTransaction() {
/* 835 */     if (this._alreadyInCommit) {
/*     */       return;
/*     */     }
/* 838 */     this._alreadyInCommit = true;
/*     */ 
/*     */     
/* 841 */     super.commitTransaction();
/*     */     
/* 843 */     this._propertiesSavepoint = this._properties;
/* 844 */     if (this._properties != null) {
/* 845 */       Iterator<IDataModel> it = this._properties.iterator();
/* 846 */       while (it.hasNext()) {
/* 847 */         ((IDataModel)it.next()).commitTransaction();
/*     */       }
/* 849 */       this._properties = new HistoricalList((List)this._properties);
/*     */     } 
/*     */ 
/*     */     
/* 853 */     this._alreadyInCommit = false;
/*     */   }
/*     */ 
/*     */   
/*     */   private void readObject(ObjectInputStream argStream) throws IOException, ClassNotFoundException {
/* 858 */     argStream.defaultReadObject();
/*     */   }
/*     */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\xom\impl\OrderModifierModel.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */