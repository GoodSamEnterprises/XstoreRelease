/*     */ package dtv.xst.dao.trl.impl;
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
/*     */ import dtv.xst.dao.trl.DimensionModifierPropertyId;
/*     */ import dtv.xst.dao.trl.IDimensionModifier;
/*     */ import dtv.xst.dao.trl.IDimensionModifierProperty;
/*     */ import dtv.xst.dao.trl.ISaleReturnLineItem;
/*     */ import java.io.IOException;
/*     */ import java.io.ObjectInputStream;
/*     */ import java.util.Date;
/*     */ import java.util.Iterator;
/*     */ import java.util.List;
/*     */ 
/*     */ public class DimensionModifierModel extends AbstractDataModelWithPropertyImpl<IDimensionModifierProperty> implements IDimensionModifier {
/*     */   private static final long serialVersionUID = -734966211L;
/*     */   private ISaleReturnLineItem _parentLine;
/*     */   private transient boolean _alreadyInStart = false;
/*     */   
/*     */   public String toString() {
/*  35 */     return super.toString() + " Id: " + getObjectId();
/*     */   }
/*     */   private transient boolean _alreadyInCommit = false; private IDataModel _myExtension; private HistoricalList<IDimensionModifierProperty> _properties; private transient HistoricalList<IDimensionModifierProperty> _propertiesSavepoint;
/*     */   
/*     */   public void initDAO() {
/*  40 */     setDAO((IDataAccessObject)new DimensionModifierDAO());
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private DimensionModifierDAO getDAO_() {
/*  48 */     return (DimensionModifierDAO)this._daoImpl;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Date getBusinessDate() {
/*  56 */     return getDAO_().getBusinessDate();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setBusinessDate(Date argBusinessDate) {
/*  64 */     if (setBusinessDate_noev(argBusinessDate) && 
/*  65 */       this._events != null && 
/*  66 */       postEventsForChanges()) {
/*  67 */       this._events.post(IDimensionModifier.SET_BUSINESSDATE, argBusinessDate);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setBusinessDate_noev(Date argBusinessDate) {
/*  74 */     boolean ev_postable = false;
/*     */     
/*  76 */     if ((getDAO_().getBusinessDate() == null && argBusinessDate != null) || (
/*  77 */       getDAO_().getBusinessDate() != null && !getDAO_().getBusinessDate().equals(argBusinessDate))) {
/*  78 */       getDAO_().setBusinessDate(argBusinessDate);
/*  79 */       ev_postable = true;
/*  80 */       if (this._properties != null) {
/*     */         
/*  82 */         Iterator<DimensionModifierPropertyModel> it = this._properties.iterator();
/*  83 */         while (it.hasNext())
/*     */         {
/*  85 */           ((DimensionModifierPropertyModel)it.next()).setBusinessDate_noev(argBusinessDate);
/*     */         }
/*     */       } 
/*     */     } 
/*     */     
/*  90 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getDimensionCode() {
/*  98 */     return getDAO_().getDimensionCode();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setDimensionCode(String argDimensionCode) {
/* 106 */     if (setDimensionCode_noev(argDimensionCode) && 
/* 107 */       this._events != null && 
/* 108 */       postEventsForChanges()) {
/* 109 */       this._events.post(IDimensionModifier.SET_DIMENSIONCODE, argDimensionCode);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setDimensionCode_noev(String argDimensionCode) {
/* 116 */     boolean ev_postable = false;
/*     */     
/* 118 */     if ((getDAO_().getDimensionCode() == null && argDimensionCode != null) || (
/* 119 */       getDAO_().getDimensionCode() != null && !getDAO_().getDimensionCode().equals(argDimensionCode))) {
/* 120 */       getDAO_().setDimensionCode(argDimensionCode);
/* 121 */       ev_postable = true;
/* 122 */       if (this._properties != null) {
/*     */         
/* 124 */         Iterator<DimensionModifierPropertyModel> it = this._properties.iterator();
/* 125 */         while (it.hasNext())
/*     */         {
/* 127 */           ((DimensionModifierPropertyModel)it.next()).setDimensionCode_noev(argDimensionCode);
/*     */         }
/*     */       } 
/*     */     } 
/*     */     
/* 132 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public long getOrganizationId() {
/* 140 */     if (getDAO_().getOrganizationId() != null) {
/* 141 */       return getDAO_().getOrganizationId().longValue();
/*     */     }
/*     */     
/* 144 */     return 0L;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setOrganizationId(long argOrganizationId) {
/* 153 */     if (setOrganizationId_noev(argOrganizationId) && 
/* 154 */       this._events != null && 
/* 155 */       postEventsForChanges()) {
/* 156 */       this._events.post(IDimensionModifier.SET_ORGANIZATIONID, Long.valueOf(argOrganizationId));
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setOrganizationId_noev(long argOrganizationId) {
/* 163 */     boolean ev_postable = false;
/*     */     
/* 165 */     if ((getDAO_().getOrganizationId() == null && Long.valueOf(argOrganizationId) != null) || (
/* 166 */       getDAO_().getOrganizationId() != null && !getDAO_().getOrganizationId().equals(Long.valueOf(argOrganizationId)))) {
/* 167 */       getDAO_().setOrganizationId(Long.valueOf(argOrganizationId));
/* 168 */       ev_postable = true;
/* 169 */       if (this._properties != null) {
/*     */         
/* 171 */         Iterator<DimensionModifierPropertyModel> it = this._properties.iterator();
/* 172 */         while (it.hasNext())
/*     */         {
/* 174 */           ((DimensionModifierPropertyModel)it.next()).setOrganizationId_noev(argOrganizationId);
/*     */         }
/*     */       } 
/*     */     } 
/*     */     
/* 179 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public long getRetailLocationId() {
/* 187 */     if (getDAO_().getRetailLocationId() != null) {
/* 188 */       return getDAO_().getRetailLocationId().longValue();
/*     */     }
/*     */     
/* 191 */     return 0L;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setRetailLocationId(long argRetailLocationId) {
/* 200 */     if (setRetailLocationId_noev(argRetailLocationId) && 
/* 201 */       this._events != null && 
/* 202 */       postEventsForChanges()) {
/* 203 */       this._events.post(IDimensionModifier.SET_RETAILLOCATIONID, Long.valueOf(argRetailLocationId));
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setRetailLocationId_noev(long argRetailLocationId) {
/* 210 */     boolean ev_postable = false;
/*     */     
/* 212 */     if ((getDAO_().getRetailLocationId() == null && Long.valueOf(argRetailLocationId) != null) || (
/* 213 */       getDAO_().getRetailLocationId() != null && !getDAO_().getRetailLocationId().equals(Long.valueOf(argRetailLocationId)))) {
/* 214 */       getDAO_().setRetailLocationId(Long.valueOf(argRetailLocationId));
/* 215 */       ev_postable = true;
/* 216 */       if (this._properties != null) {
/*     */         
/* 218 */         Iterator<DimensionModifierPropertyModel> it = this._properties.iterator();
/* 219 */         while (it.hasNext())
/*     */         {
/* 221 */           ((DimensionModifierPropertyModel)it.next()).setRetailLocationId_noev(argRetailLocationId);
/*     */         }
/*     */       } 
/*     */     } 
/*     */     
/* 226 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int getRetailTransactionLineItemSequence() {
/* 234 */     if (getDAO_().getRetailTransactionLineItemSequence() != null) {
/* 235 */       return getDAO_().getRetailTransactionLineItemSequence().intValue();
/*     */     }
/*     */     
/* 238 */     return 0;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setRetailTransactionLineItemSequence(int argRetailTransactionLineItemSequence) {
/* 247 */     if (setRetailTransactionLineItemSequence_noev(argRetailTransactionLineItemSequence) && 
/* 248 */       this._events != null && 
/* 249 */       postEventsForChanges()) {
/* 250 */       this._events.post(IDimensionModifier.SET_RETAILTRANSACTIONLINEITEMSEQUENCE, Integer.valueOf(argRetailTransactionLineItemSequence));
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setRetailTransactionLineItemSequence_noev(int argRetailTransactionLineItemSequence) {
/* 257 */     boolean ev_postable = false;
/*     */     
/* 259 */     if ((getDAO_().getRetailTransactionLineItemSequence() == null && Integer.valueOf(argRetailTransactionLineItemSequence) != null) || (
/* 260 */       getDAO_().getRetailTransactionLineItemSequence() != null && !getDAO_().getRetailTransactionLineItemSequence().equals(Integer.valueOf(argRetailTransactionLineItemSequence)))) {
/* 261 */       getDAO_().setRetailTransactionLineItemSequence(Integer.valueOf(argRetailTransactionLineItemSequence));
/* 262 */       ev_postable = true;
/* 263 */       if (this._properties != null) {
/*     */         
/* 265 */         Iterator<DimensionModifierPropertyModel> it = this._properties.iterator();
/* 266 */         while (it.hasNext())
/*     */         {
/* 268 */           ((DimensionModifierPropertyModel)it.next()).setRetailTransactionLineItemSequence_noev(argRetailTransactionLineItemSequence);
/*     */         }
/*     */       } 
/*     */     } 
/*     */     
/* 273 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public long getTransactionSequence() {
/* 281 */     if (getDAO_().getTransactionSequence() != null) {
/* 282 */       return getDAO_().getTransactionSequence().longValue();
/*     */     }
/*     */     
/* 285 */     return 0L;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setTransactionSequence(long argTransactionSequence) {
/* 294 */     if (setTransactionSequence_noev(argTransactionSequence) && 
/* 295 */       this._events != null && 
/* 296 */       postEventsForChanges()) {
/* 297 */       this._events.post(IDimensionModifier.SET_TRANSACTIONSEQUENCE, Long.valueOf(argTransactionSequence));
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setTransactionSequence_noev(long argTransactionSequence) {
/* 304 */     boolean ev_postable = false;
/*     */     
/* 306 */     if ((getDAO_().getTransactionSequence() == null && Long.valueOf(argTransactionSequence) != null) || (
/* 307 */       getDAO_().getTransactionSequence() != null && !getDAO_().getTransactionSequence().equals(Long.valueOf(argTransactionSequence)))) {
/* 308 */       getDAO_().setTransactionSequence(Long.valueOf(argTransactionSequence));
/* 309 */       ev_postable = true;
/* 310 */       if (this._properties != null) {
/*     */         
/* 312 */         Iterator<DimensionModifierPropertyModel> it = this._properties.iterator();
/* 313 */         while (it.hasNext())
/*     */         {
/* 315 */           ((DimensionModifierPropertyModel)it.next()).setTransactionSequence_noev(argTransactionSequence);
/*     */         }
/*     */       } 
/*     */     } 
/*     */     
/* 320 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public long getWorkstationId() {
/* 328 */     if (getDAO_().getWorkstationId() != null) {
/* 329 */       return getDAO_().getWorkstationId().longValue();
/*     */     }
/*     */     
/* 332 */     return 0L;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setWorkstationId(long argWorkstationId) {
/* 341 */     if (setWorkstationId_noev(argWorkstationId) && 
/* 342 */       this._events != null && 
/* 343 */       postEventsForChanges()) {
/* 344 */       this._events.post(IDimensionModifier.SET_WORKSTATIONID, Long.valueOf(argWorkstationId));
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setWorkstationId_noev(long argWorkstationId) {
/* 351 */     boolean ev_postable = false;
/*     */     
/* 353 */     if ((getDAO_().getWorkstationId() == null && Long.valueOf(argWorkstationId) != null) || (
/* 354 */       getDAO_().getWorkstationId() != null && !getDAO_().getWorkstationId().equals(Long.valueOf(argWorkstationId)))) {
/* 355 */       getDAO_().setWorkstationId(Long.valueOf(argWorkstationId));
/* 356 */       ev_postable = true;
/* 357 */       if (this._properties != null) {
/*     */         
/* 359 */         Iterator<DimensionModifierPropertyModel> it = this._properties.iterator();
/* 360 */         while (it.hasNext())
/*     */         {
/* 362 */           ((DimensionModifierPropertyModel)it.next()).setWorkstationId_noev(argWorkstationId);
/*     */         }
/*     */       } 
/*     */     } 
/*     */     
/* 367 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Date getCreateDate() {
/* 375 */     return getDAO_().getCreateDate();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setCreateDate(Date argCreateDate) {
/* 383 */     if (setCreateDate_noev(argCreateDate) && 
/* 384 */       this._events != null && 
/* 385 */       postEventsForChanges()) {
/* 386 */       this._events.post(IDimensionModifier.SET_CREATEDATE, argCreateDate);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setCreateDate_noev(Date argCreateDate) {
/* 393 */     boolean ev_postable = false;
/*     */     
/* 395 */     if ((getDAO_().getCreateDate() == null && argCreateDate != null) || (
/* 396 */       getDAO_().getCreateDate() != null && !getDAO_().getCreateDate().equals(argCreateDate))) {
/* 397 */       getDAO_().setCreateDate(argCreateDate);
/* 398 */       ev_postable = true;
/*     */     } 
/*     */     
/* 401 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getCreateUserId() {
/* 409 */     return getDAO_().getCreateUserId();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setCreateUserId(String argCreateUserId) {
/* 417 */     if (setCreateUserId_noev(argCreateUserId) && 
/* 418 */       this._events != null && 
/* 419 */       postEventsForChanges()) {
/* 420 */       this._events.post(IDimensionModifier.SET_CREATEUSERID, argCreateUserId);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setCreateUserId_noev(String argCreateUserId) {
/* 427 */     boolean ev_postable = false;
/*     */     
/* 429 */     if ((getDAO_().getCreateUserId() == null && argCreateUserId != null) || (
/* 430 */       getDAO_().getCreateUserId() != null && !getDAO_().getCreateUserId().equals(argCreateUserId))) {
/* 431 */       getDAO_().setCreateUserId(argCreateUserId);
/* 432 */       ev_postable = true;
/*     */     } 
/*     */     
/* 435 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Date getUpdateDate() {
/* 443 */     return getDAO_().getUpdateDate();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setUpdateDate(Date argUpdateDate) {
/* 451 */     if (setUpdateDate_noev(argUpdateDate) && 
/* 452 */       this._events != null && 
/* 453 */       postEventsForChanges()) {
/* 454 */       this._events.post(IDimensionModifier.SET_UPDATEDATE, argUpdateDate);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setUpdateDate_noev(Date argUpdateDate) {
/* 461 */     boolean ev_postable = false;
/*     */     
/* 463 */     if ((getDAO_().getUpdateDate() == null && argUpdateDate != null) || (
/* 464 */       getDAO_().getUpdateDate() != null && !getDAO_().getUpdateDate().equals(argUpdateDate))) {
/* 465 */       getDAO_().setUpdateDate(argUpdateDate);
/* 466 */       ev_postable = true;
/*     */     } 
/*     */     
/* 469 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getUpdateUserId() {
/* 477 */     return getDAO_().getUpdateUserId();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setUpdateUserId(String argUpdateUserId) {
/* 485 */     if (setUpdateUserId_noev(argUpdateUserId) && 
/* 486 */       this._events != null && 
/* 487 */       postEventsForChanges()) {
/* 488 */       this._events.post(IDimensionModifier.SET_UPDATEUSERID, argUpdateUserId);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setUpdateUserId_noev(String argUpdateUserId) {
/* 495 */     boolean ev_postable = false;
/*     */     
/* 497 */     if ((getDAO_().getUpdateUserId() == null && argUpdateUserId != null) || (
/* 498 */       getDAO_().getUpdateUserId() != null && !getDAO_().getUpdateUserId().equals(argUpdateUserId))) {
/* 499 */       getDAO_().setUpdateUserId(argUpdateUserId);
/* 500 */       ev_postable = true;
/*     */     } 
/*     */     
/* 503 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getValue() {
/* 511 */     return getDAO_().getValue();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setValue(String argValue) {
/* 519 */     if (setValue_noev(argValue) && 
/* 520 */       this._events != null && 
/* 521 */       postEventsForChanges()) {
/* 522 */       this._events.post(IDimensionModifier.SET_VALUE, argValue);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setValue_noev(String argValue) {
/* 529 */     boolean ev_postable = false;
/*     */     
/* 531 */     if ((getDAO_().getValue() == null && argValue != null) || (
/* 532 */       getDAO_().getValue() != null && !getDAO_().getValue().equals(argValue))) {
/* 533 */       getDAO_().setValue(argValue);
/* 534 */       ev_postable = true;
/*     */     } 
/*     */     
/* 537 */     return ev_postable;
/*     */   }
/*     */   
/*     */   protected IDimensionModifierProperty newProperty(String argPropertyName) {
/* 541 */     DimensionModifierPropertyId id = new DimensionModifierPropertyId();
/*     */     
/* 543 */     id.setBusinessDate(getBusinessDate());
/* 544 */     id.setDimensionCode(getDimensionCode());
/* 545 */     id.setRetailLocationId(Long.valueOf(getRetailLocationId()));
/* 546 */     id.setRetailTransactionLineItemSequence(Integer.valueOf(getRetailTransactionLineItemSequence()));
/* 547 */     id.setTransactionSequence(Long.valueOf(getTransactionSequence()));
/* 548 */     id.setWorkstationId(Long.valueOf(getWorkstationId()));
/* 549 */     id.setPropertyCode(argPropertyName);
/*     */     
/* 551 */     IDimensionModifierProperty prop = (IDimensionModifierProperty)DataFactory.getInstance().createNewObject((IObjectId)id, IDimensionModifierProperty.class);
/* 552 */     return prop;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @Relationship(name = "Properties")
/*     */   public List<IDimensionModifierProperty> getProperties() {
/* 561 */     if (this._properties == null) {
/* 562 */       this._properties = new HistoricalList(null);
/*     */     }
/* 564 */     return (List<IDimensionModifierProperty>)this._properties;
/*     */   }
/*     */   
/*     */   public void setProperties(List<IDimensionModifierProperty> argProperties) {
/* 568 */     if (this._properties == null) {
/* 569 */       this._properties = new HistoricalList(argProperties);
/*     */     } else {
/* 571 */       this._properties.setCurrentList(argProperties);
/*     */     } 
/*     */     
/* 574 */     for (IDimensionModifierProperty child : this._properties) {
/* 575 */       DimensionModifierPropertyModel model = (DimensionModifierPropertyModel)child;
/* 576 */       model.setBusinessDate_noev(getBusinessDate());
/* 577 */       model.setDimensionCode_noev(getDimensionCode());
/* 578 */       model.setOrganizationId_noev(getOrganizationId());
/* 579 */       model.setRetailLocationId_noev(getRetailLocationId());
/* 580 */       model.setRetailTransactionLineItemSequence_noev(getRetailTransactionLineItemSequence());
/* 581 */       model.setTransactionSequence_noev(getTransactionSequence());
/* 582 */       model.setWorkstationId_noev(getWorkstationId());
/* 583 */       if (child instanceof IDataModelImpl) {
/* 584 */         IDataAccessObject childDao = ((IDataModelImpl)child).getDAO();
/* 585 */         if (StringUtils.isEmpty(childDao.getOriginDataSource()) && 
/* 586 */           !StringUtils.isEmpty(getDAO().getOriginDataSource())) {
/* 587 */           childDao.setOriginDataSource(getDAO().getOriginDataSource());
/*     */         }
/*     */       } 
/* 590 */       if (postEventsForChanges()) {
/* 591 */         this._eventManager.registerEventHandler((IEventAware)this._eventCascade, (IEventSource)child);
/*     */       }
/*     */     } 
/*     */   }
/*     */   
/*     */   public void addDimensionModifierProperty(IDimensionModifierProperty argDimensionModifierProperty) {
/* 597 */     if (this._properties == null) {
/* 598 */       this._properties = new HistoricalList(null);
/*     */     }
/* 600 */     argDimensionModifierProperty.setBusinessDate(getBusinessDate());
/* 601 */     argDimensionModifierProperty.setDimensionCode(getDimensionCode());
/* 602 */     argDimensionModifierProperty.setOrganizationId(getOrganizationId());
/* 603 */     argDimensionModifierProperty.setRetailLocationId(getRetailLocationId());
/* 604 */     argDimensionModifierProperty.setRetailTransactionLineItemSequence(getRetailTransactionLineItemSequence());
/* 605 */     argDimensionModifierProperty.setTransactionSequence(getTransactionSequence());
/* 606 */     argDimensionModifierProperty.setWorkstationId(getWorkstationId());
/* 607 */     if (argDimensionModifierProperty instanceof IDataModelImpl) {
/* 608 */       IDataAccessObject childDao = ((IDataModelImpl)argDimensionModifierProperty).getDAO();
/* 609 */       if (StringUtils.isEmpty(childDao.getOriginDataSource()) && 
/* 610 */         !StringUtils.isEmpty(getDAO().getOriginDataSource())) {
/* 611 */         childDao.setOriginDataSource(getDAO().getOriginDataSource());
/*     */       }
/*     */     } 
/*     */ 
/*     */     
/* 616 */     if (postEventsForChanges()) {
/* 617 */       this._eventManager.registerEventHandler((IEventAware)this._eventCascade, (IEventSource)new EventDescriptor(argDimensionModifierProperty));
/*     */     }
/*     */     
/* 620 */     this._properties.add(argDimensionModifierProperty);
/* 621 */     if (postEventsForChanges()) {
/* 622 */       this._events.post(IDimensionModifier.ADD_PROPERTIES, argDimensionModifierProperty);
/*     */     }
/*     */   }
/*     */   
/*     */   public void removeDimensionModifierProperty(IDimensionModifierProperty argDimensionModifierProperty) {
/* 627 */     if (this._properties != null) {
/*     */       
/* 629 */       if (postEventsForChanges()) {
/* 630 */         this._eventManager.deregisterEventHandler((IEventAware)this._eventCascade, (IEventSource)new EventDescriptor(argDimensionModifierProperty));
/*     */       }
/* 632 */       this._properties.remove(argDimensionModifierProperty);
/* 633 */       if (postEventsForChanges()) {
/* 634 */         this._events.post(IDimensionModifier.REMOVE_PROPERTIES, argDimensionModifierProperty);
/*     */       }
/*     */     } 
/*     */   }
/*     */   
/*     */   public void setParentLine(ISaleReturnLineItem argParentLine) {
/* 640 */     this._parentLine = argParentLine;
/*     */   }
/*     */   
/*     */   public ISaleReturnLineItem getParentLine() {
/* 644 */     return this._parentLine;
/*     */   }
/*     */ 
/*     */   
/*     */   public Object getValue(String argFieldId) {
/* 649 */     if ("Properties".equals(argFieldId)) {
/* 650 */       return getProperties();
/*     */     }
/* 652 */     if ("DimensionModifierExtension".equals(argFieldId)) {
/* 653 */       return this._myExtension;
/*     */     }
/*     */     
/* 656 */     return super.getValue(argFieldId);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void setValue(String argFieldId, Object argValue) {
/* 662 */     if ("Properties".equals(argFieldId)) {
/* 663 */       setProperties(changeToList(argValue, IDimensionModifierProperty.class));
/*     */     }
/* 665 */     else if ("DimensionModifierExtension".equals(argFieldId)) {
/* 666 */       this._myExtension = (IDataModel)argValue;
/*     */     } else {
/*     */       
/* 669 */       super.setValue(argFieldId, argValue);
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public void setDependencies(IPersistenceDefaults argPD, EventManager argEM) {
/* 675 */     this._persistenceDefaults = argPD;
/* 676 */     this._daoImpl.setPersistenceDefaults(argPD);
/* 677 */     this._eventManager = argEM;
/* 678 */     this._events = (Eventor)new ModelEventor((IDataModel)this, argEM);
/* 679 */     this._eventCascade = (EventHandler)new CascadingHandler(this);
/* 680 */     if (this._properties != null) {
/* 681 */       for (IDimensionModifierProperty relationship : this._properties) {
/* 682 */         ((IDataModelImpl)relationship).setDependencies(argPD, argEM);
/*     */       }
/*     */     }
/*     */   }
/*     */   
/*     */   public IDataModel getDimensionModifierExt() {
/* 688 */     return this._myExtension;
/*     */   }
/*     */   
/*     */   public void setDimensionModifierExt(IDataModel argExt) {
/* 692 */     this._myExtension = argExt;
/*     */   }
/*     */ 
/*     */   
/*     */   public void startTransaction() {
/* 697 */     if (this._alreadyInStart) {
/*     */       return;
/*     */     }
/*     */     
/* 701 */     this._alreadyInStart = true;
/*     */ 
/*     */     
/* 704 */     super.startTransaction();
/*     */     
/* 706 */     this._propertiesSavepoint = this._properties;
/* 707 */     if (this._properties != null) {
/* 708 */       this._propertiesSavepoint = new HistoricalList((List)this._properties);
/* 709 */       Iterator<IDataModel> it = this._properties.iterator();
/* 710 */       while (it.hasNext()) {
/* 711 */         ((IDataModel)it.next()).startTransaction();
/*     */       }
/*     */     } 
/*     */ 
/*     */     
/* 716 */     this._alreadyInStart = false;
/*     */   }
/*     */ 
/*     */   
/*     */   public void rollbackChanges() {
/* 721 */     if (isAlreadyRolledBack()) {
/*     */       return;
/*     */     }
/* 724 */     super.rollbackChanges();
/*     */     
/* 726 */     this._properties = this._propertiesSavepoint;
/* 727 */     this._propertiesSavepoint = null;
/* 728 */     if (this._properties != null) {
/* 729 */       Iterator<IDataModel> it = this._properties.iterator();
/* 730 */       while (it.hasNext()) {
/* 731 */         ((IDataModel)it.next()).rollbackChanges();
/*     */       }
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void commitTransaction() {
/* 739 */     if (this._alreadyInCommit) {
/*     */       return;
/*     */     }
/* 742 */     this._alreadyInCommit = true;
/*     */ 
/*     */     
/* 745 */     super.commitTransaction();
/*     */     
/* 747 */     this._propertiesSavepoint = this._properties;
/* 748 */     if (this._properties != null) {
/* 749 */       Iterator<IDataModel> it = this._properties.iterator();
/* 750 */       while (it.hasNext()) {
/* 751 */         ((IDataModel)it.next()).commitTransaction();
/*     */       }
/* 753 */       this._properties = new HistoricalList((List)this._properties);
/*     */     } 
/*     */ 
/*     */     
/* 757 */     this._alreadyInCommit = false;
/*     */   }
/*     */ 
/*     */   
/*     */   private void readObject(ObjectInputStream argStream) throws IOException, ClassNotFoundException {
/* 762 */     argStream.defaultReadObject();
/*     */   }
/*     */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\trl\impl\DimensionModifierModel.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */