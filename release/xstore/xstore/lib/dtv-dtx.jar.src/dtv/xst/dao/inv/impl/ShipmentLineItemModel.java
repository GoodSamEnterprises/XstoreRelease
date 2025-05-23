/*     */ package dtv.xst.dao.inv.impl;
/*     */ 
/*     */ import dtv.data2.IPersistenceDefaults;
/*     */ import dtv.data2.access.DataFactory;
/*     */ import dtv.data2.access.IDataAccessObject;
/*     */ import dtv.data2.access.IDataModel;
/*     */ import dtv.data2.access.IDataProperty;
/*     */ import dtv.data2.access.IObjectId;
/*     */ import dtv.data2.access.ModelEventor;
/*     */ import dtv.data2.access.impl.IDataModelImpl;
/*     */ import dtv.data2.access.impl.Relationship;
/*     */ import dtv.event.EventDescriptor;
/*     */ import dtv.event.EventHandler;
/*     */ import dtv.event.EventManager;
/*     */ import dtv.event.Eventor;
/*     */ import dtv.event.IEventAware;
/*     */ import dtv.event.IEventSource;
/*     */ import dtv.event.handler.CascadingHandler;
/*     */ import dtv.util.HistoricalList;
/*     */ import dtv.util.StringUtils;
/*     */ import dtv.xst.dao.inv.IShipment;
/*     */ import dtv.xst.dao.inv.IShipmentLineItem;
/*     */ import dtv.xst.dao.inv.IShipmentLineItemProperty;
/*     */ import dtv.xst.dao.inv.ShipmentLineItemPropertyId;
/*     */ import java.math.BigDecimal;
/*     */ import java.util.Date;
/*     */ import java.util.Iterator;
/*     */ import java.util.List;
/*     */ 
/*     */ public class ShipmentLineItemModel extends ShipmentLineItemBaseModel implements IShipmentLineItem {
/*     */   private static final long serialVersionUID = 383149313L;
/*     */   private IShipment _parentShipment;
/*     */   private transient boolean _alreadyInStart = false;
/*     */   
/*     */   public String toString() {
/*  36 */     return super.toString() + " Id: " + getObjectId();
/*     */   }
/*     */   private transient boolean _alreadyInCommit = false; private IDataModel _myExtension; private HistoricalList<IShipmentLineItemProperty> _properties; private transient HistoricalList<IShipmentLineItemProperty> _propertiesSavepoint;
/*     */   
/*     */   public void initDAO() {
/*  41 */     setDAO((IDataAccessObject)new ShipmentLineItemDAO());
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private ShipmentLineItemDAO getDAO_() {
/*  49 */     return (ShipmentLineItemDAO)this._daoImpl;
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
/*  73 */       this._events.post(IShipmentLineItem.SET_ORGANIZATIONID, Long.valueOf(argOrganizationId));
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
/*  88 */         Iterator<ShipmentLineItemPropertyModel> it = this._properties.iterator();
/*  89 */         while (it.hasNext())
/*     */         {
/*  91 */           ((ShipmentLineItemPropertyModel)it.next()).setOrganizationId_noev(argOrganizationId);
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
/*     */   public long getRetailLocationId() {
/* 104 */     if (getDAO_().getRetailLocationId() != null) {
/* 105 */       return getDAO_().getRetailLocationId().longValue();
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
/*     */   public void setRetailLocationId(long argRetailLocationId) {
/* 117 */     if (setRetailLocationId_noev(argRetailLocationId) && 
/* 118 */       this._events != null && 
/* 119 */       postEventsForChanges()) {
/* 120 */       this._events.post(IShipmentLineItem.SET_RETAILLOCATIONID, Long.valueOf(argRetailLocationId));
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setRetailLocationId_noev(long argRetailLocationId) {
/* 127 */     boolean ev_postable = false;
/*     */     
/* 129 */     if ((getDAO_().getRetailLocationId() == null && Long.valueOf(argRetailLocationId) != null) || (
/* 130 */       getDAO_().getRetailLocationId() != null && !getDAO_().getRetailLocationId().equals(Long.valueOf(argRetailLocationId)))) {
/* 131 */       getDAO_().setRetailLocationId(Long.valueOf(argRetailLocationId));
/* 132 */       ev_postable = true;
/* 133 */       if (this._properties != null) {
/*     */         
/* 135 */         Iterator<ShipmentLineItemPropertyModel> it = this._properties.iterator();
/* 136 */         while (it.hasNext())
/*     */         {
/* 138 */           ((ShipmentLineItemPropertyModel)it.next()).setRetailLocationId_noev(argRetailLocationId);
/*     */         }
/*     */       } 
/*     */     } 
/*     */     
/* 143 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getDocumentId() {
/* 151 */     return getDAO_().getDocumentId();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setDocumentId(String argDocumentId) {
/* 159 */     if (setDocumentId_noev(argDocumentId) && 
/* 160 */       this._events != null && 
/* 161 */       postEventsForChanges()) {
/* 162 */       this._events.post(IShipmentLineItem.SET_DOCUMENTID, argDocumentId);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setDocumentId_noev(String argDocumentId) {
/* 169 */     boolean ev_postable = false;
/*     */     
/* 171 */     if ((getDAO_().getDocumentId() == null && argDocumentId != null) || (
/* 172 */       getDAO_().getDocumentId() != null && !getDAO_().getDocumentId().equals(argDocumentId))) {
/* 173 */       getDAO_().setDocumentId(argDocumentId);
/* 174 */       ev_postable = true;
/* 175 */       if (this._properties != null) {
/*     */         
/* 177 */         Iterator<ShipmentLineItemPropertyModel> it = this._properties.iterator();
/* 178 */         while (it.hasNext())
/*     */         {
/* 180 */           ((ShipmentLineItemPropertyModel)it.next()).setDocumentId_noev(argDocumentId);
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
/*     */   public String getDocumentTypeCode() {
/* 193 */     return getDAO_().getDocumentTypeCode();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setDocumentTypeCode(String argDocumentTypeCode) {
/* 201 */     if (setDocumentTypeCode_noev(argDocumentTypeCode) && 
/* 202 */       this._events != null && 
/* 203 */       postEventsForChanges()) {
/* 204 */       this._events.post(IShipmentLineItem.SET_DOCUMENTTYPECODE, argDocumentTypeCode);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setDocumentTypeCode_noev(String argDocumentTypeCode) {
/* 211 */     boolean ev_postable = false;
/*     */     
/* 213 */     if ((getDAO_().getDocumentTypeCode() == null && argDocumentTypeCode != null) || (
/* 214 */       getDAO_().getDocumentTypeCode() != null && !getDAO_().getDocumentTypeCode().equals(argDocumentTypeCode))) {
/* 215 */       getDAO_().setDocumentTypeCode(argDocumentTypeCode);
/* 216 */       ev_postable = true;
/* 217 */       if (this._properties != null) {
/*     */         
/* 219 */         Iterator<ShipmentLineItemPropertyModel> it = this._properties.iterator();
/* 220 */         while (it.hasNext())
/*     */         {
/* 222 */           ((ShipmentLineItemPropertyModel)it.next()).setDocumentTypeCode_noev(argDocumentTypeCode);
/*     */         }
/*     */       } 
/*     */     } 
/*     */     
/* 227 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int getShipmentSequence() {
/* 235 */     if (getDAO_().getShipmentSequence() != null) {
/* 236 */       return getDAO_().getShipmentSequence().intValue();
/*     */     }
/*     */     
/* 239 */     return 0;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setShipmentSequence(int argShipmentSequence) {
/* 248 */     if (setShipmentSequence_noev(argShipmentSequence) && 
/* 249 */       this._events != null && 
/* 250 */       postEventsForChanges()) {
/* 251 */       this._events.post(IShipmentLineItem.SET_SHIPMENTSEQUENCE, Integer.valueOf(argShipmentSequence));
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setShipmentSequence_noev(int argShipmentSequence) {
/* 258 */     boolean ev_postable = false;
/*     */     
/* 260 */     if ((getDAO_().getShipmentSequence() == null && Integer.valueOf(argShipmentSequence) != null) || (
/* 261 */       getDAO_().getShipmentSequence() != null && !getDAO_().getShipmentSequence().equals(Integer.valueOf(argShipmentSequence)))) {
/* 262 */       getDAO_().setShipmentSequence(Integer.valueOf(argShipmentSequence));
/* 263 */       ev_postable = true;
/* 264 */       if (this._properties != null) {
/*     */         
/* 266 */         Iterator<ShipmentLineItemPropertyModel> it = this._properties.iterator();
/* 267 */         while (it.hasNext())
/*     */         {
/* 269 */           ((ShipmentLineItemPropertyModel)it.next()).setShipmentSequence_noev(argShipmentSequence);
/*     */         }
/*     */       } 
/*     */     } 
/*     */     
/* 274 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int getLineItemSequence() {
/* 282 */     if (getDAO_().getLineItemSequence() != null) {
/* 283 */       return getDAO_().getLineItemSequence().intValue();
/*     */     }
/*     */     
/* 286 */     return 0;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setLineItemSequence(int argLineItemSequence) {
/* 295 */     if (setLineItemSequence_noev(argLineItemSequence) && 
/* 296 */       this._events != null && 
/* 297 */       postEventsForChanges()) {
/* 298 */       this._events.post(IShipmentLineItem.SET_LINEITEMSEQUENCE, Integer.valueOf(argLineItemSequence));
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setLineItemSequence_noev(int argLineItemSequence) {
/* 305 */     boolean ev_postable = false;
/*     */     
/* 307 */     if ((getDAO_().getLineItemSequence() == null && Integer.valueOf(argLineItemSequence) != null) || (
/* 308 */       getDAO_().getLineItemSequence() != null && !getDAO_().getLineItemSequence().equals(Integer.valueOf(argLineItemSequence)))) {
/* 309 */       getDAO_().setLineItemSequence(Integer.valueOf(argLineItemSequence));
/* 310 */       ev_postable = true;
/* 311 */       if (this._properties != null) {
/*     */         
/* 313 */         Iterator<ShipmentLineItemPropertyModel> it = this._properties.iterator();
/* 314 */         while (it.hasNext())
/*     */         {
/* 316 */           ((ShipmentLineItemPropertyModel)it.next()).setLineItemSequence_noev(argLineItemSequence);
/*     */         }
/*     */       } 
/*     */     } 
/*     */     
/* 321 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Date getCreateDate() {
/* 329 */     return getDAO_().getCreateDate();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setCreateDate(Date argCreateDate) {
/* 337 */     if (setCreateDate_noev(argCreateDate) && 
/* 338 */       this._events != null && 
/* 339 */       postEventsForChanges()) {
/* 340 */       this._events.post(IShipmentLineItem.SET_CREATEDATE, argCreateDate);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setCreateDate_noev(Date argCreateDate) {
/* 347 */     boolean ev_postable = false;
/*     */     
/* 349 */     if ((getDAO_().getCreateDate() == null && argCreateDate != null) || (
/* 350 */       getDAO_().getCreateDate() != null && !getDAO_().getCreateDate().equals(argCreateDate))) {
/* 351 */       getDAO_().setCreateDate(argCreateDate);
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
/*     */   public String getCreateUserId() {
/* 363 */     return getDAO_().getCreateUserId();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setCreateUserId(String argCreateUserId) {
/* 371 */     if (setCreateUserId_noev(argCreateUserId) && 
/* 372 */       this._events != null && 
/* 373 */       postEventsForChanges()) {
/* 374 */       this._events.post(IShipmentLineItem.SET_CREATEUSERID, argCreateUserId);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setCreateUserId_noev(String argCreateUserId) {
/* 381 */     boolean ev_postable = false;
/*     */     
/* 383 */     if ((getDAO_().getCreateUserId() == null && argCreateUserId != null) || (
/* 384 */       getDAO_().getCreateUserId() != null && !getDAO_().getCreateUserId().equals(argCreateUserId))) {
/* 385 */       getDAO_().setCreateUserId(argCreateUserId);
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
/*     */   public Date getUpdateDate() {
/* 397 */     return getDAO_().getUpdateDate();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setUpdateDate(Date argUpdateDate) {
/* 405 */     if (setUpdateDate_noev(argUpdateDate) && 
/* 406 */       this._events != null && 
/* 407 */       postEventsForChanges()) {
/* 408 */       this._events.post(IShipmentLineItem.SET_UPDATEDATE, argUpdateDate);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setUpdateDate_noev(Date argUpdateDate) {
/* 415 */     boolean ev_postable = false;
/*     */     
/* 417 */     if ((getDAO_().getUpdateDate() == null && argUpdateDate != null) || (
/* 418 */       getDAO_().getUpdateDate() != null && !getDAO_().getUpdateDate().equals(argUpdateDate))) {
/* 419 */       getDAO_().setUpdateDate(argUpdateDate);
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
/*     */   public String getUpdateUserId() {
/* 431 */     return getDAO_().getUpdateUserId();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setUpdateUserId(String argUpdateUserId) {
/* 439 */     if (setUpdateUserId_noev(argUpdateUserId) && 
/* 440 */       this._events != null && 
/* 441 */       postEventsForChanges()) {
/* 442 */       this._events.post(IShipmentLineItem.SET_UPDATEUSERID, argUpdateUserId);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setUpdateUserId_noev(String argUpdateUserId) {
/* 449 */     boolean ev_postable = false;
/*     */     
/* 451 */     if ((getDAO_().getUpdateUserId() == null && argUpdateUserId != null) || (
/* 452 */       getDAO_().getUpdateUserId() != null && !getDAO_().getUpdateUserId().equals(argUpdateUserId))) {
/* 453 */       getDAO_().setUpdateUserId(argUpdateUserId);
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
/*     */   public int getInventoryDocumentLineNumber() {
/* 465 */     if (getDAO_().getInventoryDocumentLineNumber() != null) {
/* 466 */       return getDAO_().getInventoryDocumentLineNumber().intValue();
/*     */     }
/*     */     
/* 469 */     return 0;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setInventoryDocumentLineNumber(int argInventoryDocumentLineNumber) {
/* 478 */     if (setInventoryDocumentLineNumber_noev(argInventoryDocumentLineNumber) && 
/* 479 */       this._events != null && 
/* 480 */       postEventsForChanges()) {
/* 481 */       this._events.post(IShipmentLineItem.SET_INVENTORYDOCUMENTLINENUMBER, Integer.valueOf(argInventoryDocumentLineNumber));
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setInventoryDocumentLineNumber_noev(int argInventoryDocumentLineNumber) {
/* 488 */     boolean ev_postable = false;
/*     */     
/* 490 */     if ((getDAO_().getInventoryDocumentLineNumber() == null && Integer.valueOf(argInventoryDocumentLineNumber) != null) || (
/* 491 */       getDAO_().getInventoryDocumentLineNumber() != null && !getDAO_().getInventoryDocumentLineNumber().equals(Integer.valueOf(argInventoryDocumentLineNumber)))) {
/* 492 */       getDAO_().setInventoryDocumentLineNumber(Integer.valueOf(argInventoryDocumentLineNumber));
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
/*     */   public BigDecimal getShipQuantity() {
/* 504 */     return getDAO_().getShipQuantity();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setShipQuantity(BigDecimal argShipQuantity) {
/* 512 */     if (setShipQuantity_noev(argShipQuantity) && 
/* 513 */       this._events != null && 
/* 514 */       postEventsForChanges()) {
/* 515 */       this._events.post(IShipmentLineItem.SET_SHIPQUANTITY, argShipQuantity);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setShipQuantity_noev(BigDecimal argShipQuantity) {
/* 522 */     boolean ev_postable = false;
/*     */     
/* 524 */     if ((getDAO_().getShipQuantity() == null && argShipQuantity != null) || (
/* 525 */       getDAO_().getShipQuantity() != null && !getDAO_().getShipQuantity().equals(argShipQuantity))) {
/* 526 */       getDAO_().setShipQuantity(argShipQuantity);
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
/*     */   public String getCartonId() {
/* 538 */     return getDAO_().getCartonId();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setCartonId(String argCartonId) {
/* 546 */     if (setCartonId_noev(argCartonId) && 
/* 547 */       this._events != null && 
/* 548 */       postEventsForChanges()) {
/* 549 */       this._events.post(IShipmentLineItem.SET_CARTONID, argCartonId);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setCartonId_noev(String argCartonId) {
/* 556 */     boolean ev_postable = false;
/*     */     
/* 558 */     if ((getDAO_().getCartonId() == null && argCartonId != null) || (
/* 559 */       getDAO_().getCartonId() != null && !getDAO_().getCartonId().equals(argCartonId))) {
/* 560 */       getDAO_().setCartonId(argCartonId);
/* 561 */       ev_postable = true;
/*     */     } 
/*     */     
/* 564 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getStatusCode() {
/* 572 */     return getDAO_().getStatusCode();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setStatusCode(String argStatusCode) {
/* 580 */     if (setStatusCode_noev(argStatusCode) && 
/* 581 */       this._events != null && 
/* 582 */       postEventsForChanges()) {
/* 583 */       this._events.post(IShipmentLineItem.SET_STATUSCODE, argStatusCode);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setStatusCode_noev(String argStatusCode) {
/* 590 */     boolean ev_postable = false;
/*     */     
/* 592 */     if ((getDAO_().getStatusCode() == null && argStatusCode != null) || (
/* 593 */       getDAO_().getStatusCode() != null && !getDAO_().getStatusCode().equals(argStatusCode))) {
/* 594 */       getDAO_().setStatusCode(argStatusCode);
/* 595 */       ev_postable = true;
/*     */     } 
/*     */     
/* 598 */     return ev_postable;
/*     */   }
/*     */   
/*     */   protected IShipmentLineItemProperty newProperty(String argPropertyName) {
/* 602 */     ShipmentLineItemPropertyId id = new ShipmentLineItemPropertyId();
/*     */     
/* 604 */     id.setRetailLocationId(Long.valueOf(getRetailLocationId()));
/* 605 */     id.setDocumentId(getDocumentId());
/* 606 */     id.setDocumentTypeCode(getDocumentTypeCode());
/* 607 */     id.setShipmentSequence(Integer.valueOf(getShipmentSequence()));
/* 608 */     id.setLineItemSequence(Integer.valueOf(getLineItemSequence()));
/* 609 */     id.setPropertyCode(argPropertyName);
/*     */     
/* 611 */     IShipmentLineItemProperty prop = (IShipmentLineItemProperty)DataFactory.getInstance().createNewObject((IObjectId)id, IShipmentLineItemProperty.class);
/* 612 */     return prop;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @Relationship(name = "Properties")
/*     */   public List<IShipmentLineItemProperty> getProperties() {
/* 621 */     if (this._properties == null) {
/* 622 */       this._properties = new HistoricalList(null);
/*     */     }
/* 624 */     return (List<IShipmentLineItemProperty>)this._properties;
/*     */   }
/*     */   
/*     */   public void setProperties(List<IShipmentLineItemProperty> argProperties) {
/* 628 */     if (this._properties == null) {
/* 629 */       this._properties = new HistoricalList(argProperties);
/*     */     } else {
/* 631 */       this._properties.setCurrentList(argProperties);
/*     */     } 
/*     */     
/* 634 */     for (IShipmentLineItemProperty child : this._properties) {
/* 635 */       ShipmentLineItemPropertyModel model = (ShipmentLineItemPropertyModel)child;
/* 636 */       model.setOrganizationId_noev(getOrganizationId());
/* 637 */       model.setRetailLocationId_noev(getRetailLocationId());
/* 638 */       model.setDocumentId_noev(getDocumentId());
/* 639 */       model.setDocumentTypeCode_noev(getDocumentTypeCode());
/* 640 */       model.setShipmentSequence_noev(getShipmentSequence());
/* 641 */       model.setLineItemSequence_noev(getLineItemSequence());
/* 642 */       if (child instanceof IDataModelImpl) {
/* 643 */         IDataAccessObject childDao = ((IDataModelImpl)child).getDAO();
/* 644 */         if (StringUtils.isEmpty(childDao.getOriginDataSource()) && 
/* 645 */           !StringUtils.isEmpty(getDAO().getOriginDataSource())) {
/* 646 */           childDao.setOriginDataSource(getDAO().getOriginDataSource());
/*     */         }
/*     */       } 
/* 649 */       if (postEventsForChanges()) {
/* 650 */         this._eventManager.registerEventHandler((IEventAware)this._eventCascade, (IEventSource)child);
/*     */       }
/*     */     } 
/*     */   }
/*     */   
/*     */   public void addShipmentLineItemProperty(IShipmentLineItemProperty argShipmentLineItemProperty) {
/* 656 */     if (this._properties == null) {
/* 657 */       this._properties = new HistoricalList(null);
/*     */     }
/* 659 */     argShipmentLineItemProperty.setOrganizationId(getOrganizationId());
/* 660 */     argShipmentLineItemProperty.setRetailLocationId(getRetailLocationId());
/* 661 */     argShipmentLineItemProperty.setDocumentId(getDocumentId());
/* 662 */     argShipmentLineItemProperty.setDocumentTypeCode(getDocumentTypeCode());
/* 663 */     argShipmentLineItemProperty.setShipmentSequence(getShipmentSequence());
/* 664 */     argShipmentLineItemProperty.setLineItemSequence(getLineItemSequence());
/* 665 */     if (argShipmentLineItemProperty instanceof IDataModelImpl) {
/* 666 */       IDataAccessObject childDao = ((IDataModelImpl)argShipmentLineItemProperty).getDAO();
/* 667 */       if (StringUtils.isEmpty(childDao.getOriginDataSource()) && 
/* 668 */         !StringUtils.isEmpty(getDAO().getOriginDataSource())) {
/* 669 */         childDao.setOriginDataSource(getDAO().getOriginDataSource());
/*     */       }
/*     */     } 
/*     */ 
/*     */     
/* 674 */     if (postEventsForChanges()) {
/* 675 */       this._eventManager.registerEventHandler((IEventAware)this._eventCascade, (IEventSource)new EventDescriptor(argShipmentLineItemProperty));
/*     */     }
/*     */     
/* 678 */     this._properties.add(argShipmentLineItemProperty);
/* 679 */     if (postEventsForChanges()) {
/* 680 */       this._events.post(IShipmentLineItem.ADD_PROPERTIES, argShipmentLineItemProperty);
/*     */     }
/*     */   }
/*     */   
/*     */   public void removeShipmentLineItemProperty(IShipmentLineItemProperty argShipmentLineItemProperty) {
/* 685 */     if (this._properties != null) {
/*     */       
/* 687 */       if (postEventsForChanges()) {
/* 688 */         this._eventManager.deregisterEventHandler((IEventAware)this._eventCascade, (IEventSource)new EventDescriptor(argShipmentLineItemProperty));
/*     */       }
/* 690 */       this._properties.remove(argShipmentLineItemProperty);
/* 691 */       if (postEventsForChanges()) {
/* 692 */         this._events.post(IShipmentLineItem.REMOVE_PROPERTIES, argShipmentLineItemProperty);
/*     */       }
/*     */     } 
/*     */   }
/*     */   
/*     */   public void setParentShipment(IShipment argParentShipment) {
/* 698 */     this._parentShipment = argParentShipment;
/*     */   }
/*     */   
/*     */   public IShipment getParentShipment() {
/* 702 */     return this._parentShipment;
/*     */   }
/*     */ 
/*     */   
/*     */   public Object getValue(String argFieldId) {
/* 707 */     if ("Properties".equals(argFieldId)) {
/* 708 */       return getProperties();
/*     */     }
/* 710 */     if ("ShipmentLineItemExtension".equals(argFieldId)) {
/* 711 */       return this._myExtension;
/*     */     }
/*     */     
/* 714 */     return super.getValue(argFieldId);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void setValue(String argFieldId, Object argValue) {
/* 720 */     if ("Properties".equals(argFieldId)) {
/* 721 */       setProperties(changeToList(argValue, IShipmentLineItemProperty.class));
/*     */     }
/* 723 */     else if ("ShipmentLineItemExtension".equals(argFieldId)) {
/* 724 */       this._myExtension = (IDataModel)argValue;
/*     */     } else {
/*     */       
/* 727 */       super.setValue(argFieldId, argValue);
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public void setDependencies(IPersistenceDefaults argPD, EventManager argEM) {
/* 733 */     this._persistenceDefaults = argPD;
/* 734 */     this._daoImpl.setPersistenceDefaults(argPD);
/* 735 */     this._eventManager = argEM;
/* 736 */     this._events = (Eventor)new ModelEventor((IDataModel)this, argEM);
/* 737 */     this._eventCascade = (EventHandler)new CascadingHandler(this);
/* 738 */     if (this._properties != null) {
/* 739 */       for (IShipmentLineItemProperty relationship : this._properties) {
/* 740 */         ((IDataModelImpl)relationship).setDependencies(argPD, argEM);
/*     */       }
/*     */     }
/*     */   }
/*     */   
/*     */   public IDataModel getShipmentLineItemExt() {
/* 746 */     return this._myExtension;
/*     */   }
/*     */   
/*     */   public void setShipmentLineItemExt(IDataModel argExt) {
/* 750 */     this._myExtension = argExt;
/*     */   }
/*     */ 
/*     */   
/*     */   public void startTransaction() {
/* 755 */     if (this._alreadyInStart) {
/*     */       return;
/*     */     }
/*     */     
/* 759 */     this._alreadyInStart = true;
/*     */ 
/*     */     
/* 762 */     super.startTransaction();
/*     */     
/* 764 */     this._propertiesSavepoint = this._properties;
/* 765 */     if (this._properties != null) {
/* 766 */       this._propertiesSavepoint = new HistoricalList((List)this._properties);
/* 767 */       Iterator<IDataModel> it = this._properties.iterator();
/* 768 */       while (it.hasNext()) {
/* 769 */         ((IDataModel)it.next()).startTransaction();
/*     */       }
/*     */     } 
/*     */ 
/*     */     
/* 774 */     this._alreadyInStart = false;
/*     */   }
/*     */ 
/*     */   
/*     */   public void rollbackChanges() {
/* 779 */     if (isAlreadyRolledBack()) {
/*     */       return;
/*     */     }
/* 782 */     super.rollbackChanges();
/*     */     
/* 784 */     this._properties = this._propertiesSavepoint;
/* 785 */     this._propertiesSavepoint = null;
/* 786 */     if (this._properties != null) {
/* 787 */       Iterator<IDataModel> it = this._properties.iterator();
/* 788 */       while (it.hasNext()) {
/* 789 */         ((IDataModel)it.next()).rollbackChanges();
/*     */       }
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void commitTransaction() {
/* 797 */     if (this._alreadyInCommit) {
/*     */       return;
/*     */     }
/* 800 */     this._alreadyInCommit = true;
/*     */ 
/*     */     
/* 803 */     super.commitTransaction();
/*     */     
/* 805 */     this._propertiesSavepoint = this._properties;
/* 806 */     if (this._properties != null) {
/* 807 */       Iterator<IDataModel> it = this._properties.iterator();
/* 808 */       while (it.hasNext()) {
/* 809 */         ((IDataModel)it.next()).commitTransaction();
/*     */       }
/* 811 */       this._properties = new HistoricalList((List)this._properties);
/*     */     } 
/*     */ 
/*     */     
/* 815 */     this._alreadyInCommit = false;
/*     */   }
/*     */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\inv\impl\ShipmentLineItemModel.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */