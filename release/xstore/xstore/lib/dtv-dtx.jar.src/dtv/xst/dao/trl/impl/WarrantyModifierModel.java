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
/*     */ import dtv.xst.dao.trl.IWarrantyLineItem;
/*     */ import dtv.xst.dao.trl.IWarrantyModifier;
/*     */ import dtv.xst.dao.trl.IWarrantyModifierProperty;
/*     */ import dtv.xst.dao.trl.WarrantyModifierPropertyId;
/*     */ import java.io.IOException;
/*     */ import java.io.ObjectInputStream;
/*     */ import java.util.Date;
/*     */ import java.util.Iterator;
/*     */ import java.util.List;
/*     */ 
/*     */ public class WarrantyModifierModel extends AbstractDataModelWithPropertyImpl<IWarrantyModifierProperty> implements IWarrantyModifier {
/*     */   private static final long serialVersionUID = 154202131L;
/*     */   private IWarrantyLineItem _parentLine;
/*     */   private transient boolean _alreadyInStart = false;
/*     */   
/*     */   public String toString() {
/*  35 */     return super.toString() + " Id: " + getObjectId();
/*     */   }
/*     */   private transient boolean _alreadyInCommit = false; private IDataModel _myExtension; private HistoricalList<IWarrantyModifierProperty> _properties; private transient HistoricalList<IWarrantyModifierProperty> _propertiesSavepoint;
/*     */   
/*     */   public void initDAO() {
/*  40 */     setDAO((IDataAccessObject)new WarrantyModifierDAO());
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private WarrantyModifierDAO getDAO_() {
/*  48 */     return (WarrantyModifierDAO)this._daoImpl;
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
/*  67 */       this._events.post(IWarrantyModifier.SET_BUSINESSDATE, argBusinessDate);
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
/*  82 */         Iterator<WarrantyModifierPropertyModel> it = this._properties.iterator();
/*  83 */         while (it.hasNext())
/*     */         {
/*  85 */           ((WarrantyModifierPropertyModel)it.next()).setBusinessDate_noev(argBusinessDate);
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
/*     */   public long getOrganizationId() {
/*  98 */     if (getDAO_().getOrganizationId() != null) {
/*  99 */       return getDAO_().getOrganizationId().longValue();
/*     */     }
/*     */     
/* 102 */     return 0L;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setOrganizationId(long argOrganizationId) {
/* 111 */     if (setOrganizationId_noev(argOrganizationId) && 
/* 112 */       this._events != null && 
/* 113 */       postEventsForChanges()) {
/* 114 */       this._events.post(IWarrantyModifier.SET_ORGANIZATIONID, Long.valueOf(argOrganizationId));
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setOrganizationId_noev(long argOrganizationId) {
/* 121 */     boolean ev_postable = false;
/*     */     
/* 123 */     if ((getDAO_().getOrganizationId() == null && Long.valueOf(argOrganizationId) != null) || (
/* 124 */       getDAO_().getOrganizationId() != null && !getDAO_().getOrganizationId().equals(Long.valueOf(argOrganizationId)))) {
/* 125 */       getDAO_().setOrganizationId(Long.valueOf(argOrganizationId));
/* 126 */       ev_postable = true;
/* 127 */       if (this._properties != null) {
/*     */         
/* 129 */         Iterator<WarrantyModifierPropertyModel> it = this._properties.iterator();
/* 130 */         while (it.hasNext())
/*     */         {
/* 132 */           ((WarrantyModifierPropertyModel)it.next()).setOrganizationId_noev(argOrganizationId);
/*     */         }
/*     */       } 
/*     */     } 
/*     */     
/* 137 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public long getRetailLocationId() {
/* 145 */     if (getDAO_().getRetailLocationId() != null) {
/* 146 */       return getDAO_().getRetailLocationId().longValue();
/*     */     }
/*     */     
/* 149 */     return 0L;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setRetailLocationId(long argRetailLocationId) {
/* 158 */     if (setRetailLocationId_noev(argRetailLocationId) && 
/* 159 */       this._events != null && 
/* 160 */       postEventsForChanges()) {
/* 161 */       this._events.post(IWarrantyModifier.SET_RETAILLOCATIONID, Long.valueOf(argRetailLocationId));
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setRetailLocationId_noev(long argRetailLocationId) {
/* 168 */     boolean ev_postable = false;
/*     */     
/* 170 */     if ((getDAO_().getRetailLocationId() == null && Long.valueOf(argRetailLocationId) != null) || (
/* 171 */       getDAO_().getRetailLocationId() != null && !getDAO_().getRetailLocationId().equals(Long.valueOf(argRetailLocationId)))) {
/* 172 */       getDAO_().setRetailLocationId(Long.valueOf(argRetailLocationId));
/* 173 */       ev_postable = true;
/* 174 */       if (this._properties != null) {
/*     */         
/* 176 */         Iterator<WarrantyModifierPropertyModel> it = this._properties.iterator();
/* 177 */         while (it.hasNext())
/*     */         {
/* 179 */           ((WarrantyModifierPropertyModel)it.next()).setRetailLocationId_noev(argRetailLocationId);
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
/*     */   public int getRetailTransactionLineItemSequence() {
/* 192 */     if (getDAO_().getRetailTransactionLineItemSequence() != null) {
/* 193 */       return getDAO_().getRetailTransactionLineItemSequence().intValue();
/*     */     }
/*     */     
/* 196 */     return 0;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setRetailTransactionLineItemSequence(int argRetailTransactionLineItemSequence) {
/* 205 */     if (setRetailTransactionLineItemSequence_noev(argRetailTransactionLineItemSequence) && 
/* 206 */       this._events != null && 
/* 207 */       postEventsForChanges()) {
/* 208 */       this._events.post(IWarrantyModifier.SET_RETAILTRANSACTIONLINEITEMSEQUENCE, Integer.valueOf(argRetailTransactionLineItemSequence));
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setRetailTransactionLineItemSequence_noev(int argRetailTransactionLineItemSequence) {
/* 215 */     boolean ev_postable = false;
/*     */     
/* 217 */     if ((getDAO_().getRetailTransactionLineItemSequence() == null && Integer.valueOf(argRetailTransactionLineItemSequence) != null) || (
/* 218 */       getDAO_().getRetailTransactionLineItemSequence() != null && !getDAO_().getRetailTransactionLineItemSequence().equals(Integer.valueOf(argRetailTransactionLineItemSequence)))) {
/* 219 */       getDAO_().setRetailTransactionLineItemSequence(Integer.valueOf(argRetailTransactionLineItemSequence));
/* 220 */       ev_postable = true;
/* 221 */       if (this._properties != null) {
/*     */         
/* 223 */         Iterator<WarrantyModifierPropertyModel> it = this._properties.iterator();
/* 224 */         while (it.hasNext())
/*     */         {
/* 226 */           ((WarrantyModifierPropertyModel)it.next()).setRetailTransactionLineItemSequence_noev(argRetailTransactionLineItemSequence);
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
/* 255 */       this._events.post(IWarrantyModifier.SET_TRANSACTIONSEQUENCE, Long.valueOf(argTransactionSequence));
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
/* 270 */         Iterator<WarrantyModifierPropertyModel> it = this._properties.iterator();
/* 271 */         while (it.hasNext())
/*     */         {
/* 273 */           ((WarrantyModifierPropertyModel)it.next()).setTransactionSequence_noev(argTransactionSequence);
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
/*     */   public long getWorkstationId() {
/* 286 */     if (getDAO_().getWorkstationId() != null) {
/* 287 */       return getDAO_().getWorkstationId().longValue();
/*     */     }
/*     */     
/* 290 */     return 0L;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setWorkstationId(long argWorkstationId) {
/* 299 */     if (setWorkstationId_noev(argWorkstationId) && 
/* 300 */       this._events != null && 
/* 301 */       postEventsForChanges()) {
/* 302 */       this._events.post(IWarrantyModifier.SET_WORKSTATIONID, Long.valueOf(argWorkstationId));
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setWorkstationId_noev(long argWorkstationId) {
/* 309 */     boolean ev_postable = false;
/*     */     
/* 311 */     if ((getDAO_().getWorkstationId() == null && Long.valueOf(argWorkstationId) != null) || (
/* 312 */       getDAO_().getWorkstationId() != null && !getDAO_().getWorkstationId().equals(Long.valueOf(argWorkstationId)))) {
/* 313 */       getDAO_().setWorkstationId(Long.valueOf(argWorkstationId));
/* 314 */       ev_postable = true;
/* 315 */       if (this._properties != null) {
/*     */         
/* 317 */         Iterator<WarrantyModifierPropertyModel> it = this._properties.iterator();
/* 318 */         while (it.hasNext())
/*     */         {
/* 320 */           ((WarrantyModifierPropertyModel)it.next()).setWorkstationId_noev(argWorkstationId);
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
/*     */   public int getWarrantyModifierSequence() {
/* 333 */     if (getDAO_().getWarrantyModifierSequence() != null) {
/* 334 */       return getDAO_().getWarrantyModifierSequence().intValue();
/*     */     }
/*     */     
/* 337 */     return 0;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setWarrantyModifierSequence(int argWarrantyModifierSequence) {
/* 346 */     if (setWarrantyModifierSequence_noev(argWarrantyModifierSequence) && 
/* 347 */       this._events != null && 
/* 348 */       postEventsForChanges()) {
/* 349 */       this._events.post(IWarrantyModifier.SET_WARRANTYMODIFIERSEQUENCE, Integer.valueOf(argWarrantyModifierSequence));
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setWarrantyModifierSequence_noev(int argWarrantyModifierSequence) {
/* 356 */     boolean ev_postable = false;
/*     */     
/* 358 */     if ((getDAO_().getWarrantyModifierSequence() == null && Integer.valueOf(argWarrantyModifierSequence) != null) || (
/* 359 */       getDAO_().getWarrantyModifierSequence() != null && !getDAO_().getWarrantyModifierSequence().equals(Integer.valueOf(argWarrantyModifierSequence)))) {
/* 360 */       getDAO_().setWarrantyModifierSequence(Integer.valueOf(argWarrantyModifierSequence));
/* 361 */       ev_postable = true;
/* 362 */       if (this._properties != null) {
/*     */         
/* 364 */         Iterator<WarrantyModifierPropertyModel> it = this._properties.iterator();
/* 365 */         while (it.hasNext())
/*     */         {
/* 367 */           ((WarrantyModifierPropertyModel)it.next()).setWarrantyModifierSequence_noev(argWarrantyModifierSequence);
/*     */         }
/*     */       } 
/*     */     } 
/*     */     
/* 372 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Date getCreateDate() {
/* 380 */     return getDAO_().getCreateDate();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setCreateDate(Date argCreateDate) {
/* 388 */     if (setCreateDate_noev(argCreateDate) && 
/* 389 */       this._events != null && 
/* 390 */       postEventsForChanges()) {
/* 391 */       this._events.post(IWarrantyModifier.SET_CREATEDATE, argCreateDate);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setCreateDate_noev(Date argCreateDate) {
/* 398 */     boolean ev_postable = false;
/*     */     
/* 400 */     if ((getDAO_().getCreateDate() == null && argCreateDate != null) || (
/* 401 */       getDAO_().getCreateDate() != null && !getDAO_().getCreateDate().equals(argCreateDate))) {
/* 402 */       getDAO_().setCreateDate(argCreateDate);
/* 403 */       ev_postable = true;
/*     */     } 
/*     */     
/* 406 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getCreateUserId() {
/* 414 */     return getDAO_().getCreateUserId();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setCreateUserId(String argCreateUserId) {
/* 422 */     if (setCreateUserId_noev(argCreateUserId) && 
/* 423 */       this._events != null && 
/* 424 */       postEventsForChanges()) {
/* 425 */       this._events.post(IWarrantyModifier.SET_CREATEUSERID, argCreateUserId);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setCreateUserId_noev(String argCreateUserId) {
/* 432 */     boolean ev_postable = false;
/*     */     
/* 434 */     if ((getDAO_().getCreateUserId() == null && argCreateUserId != null) || (
/* 435 */       getDAO_().getCreateUserId() != null && !getDAO_().getCreateUserId().equals(argCreateUserId))) {
/* 436 */       getDAO_().setCreateUserId(argCreateUserId);
/* 437 */       ev_postable = true;
/*     */     } 
/*     */     
/* 440 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Date getUpdateDate() {
/* 448 */     return getDAO_().getUpdateDate();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setUpdateDate(Date argUpdateDate) {
/* 456 */     if (setUpdateDate_noev(argUpdateDate) && 
/* 457 */       this._events != null && 
/* 458 */       postEventsForChanges()) {
/* 459 */       this._events.post(IWarrantyModifier.SET_UPDATEDATE, argUpdateDate);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setUpdateDate_noev(Date argUpdateDate) {
/* 466 */     boolean ev_postable = false;
/*     */     
/* 468 */     if ((getDAO_().getUpdateDate() == null && argUpdateDate != null) || (
/* 469 */       getDAO_().getUpdateDate() != null && !getDAO_().getUpdateDate().equals(argUpdateDate))) {
/* 470 */       getDAO_().setUpdateDate(argUpdateDate);
/* 471 */       ev_postable = true;
/*     */     } 
/*     */     
/* 474 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getUpdateUserId() {
/* 482 */     return getDAO_().getUpdateUserId();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setUpdateUserId(String argUpdateUserId) {
/* 490 */     if (setUpdateUserId_noev(argUpdateUserId) && 
/* 491 */       this._events != null && 
/* 492 */       postEventsForChanges()) {
/* 493 */       this._events.post(IWarrantyModifier.SET_UPDATEUSERID, argUpdateUserId);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setUpdateUserId_noev(String argUpdateUserId) {
/* 500 */     boolean ev_postable = false;
/*     */     
/* 502 */     if ((getDAO_().getUpdateUserId() == null && argUpdateUserId != null) || (
/* 503 */       getDAO_().getUpdateUserId() != null && !getDAO_().getUpdateUserId().equals(argUpdateUserId))) {
/* 504 */       getDAO_().setUpdateUserId(argUpdateUserId);
/* 505 */       ev_postable = true;
/*     */     } 
/*     */     
/* 508 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getWarrantyNbr() {
/* 516 */     return getDAO_().getWarrantyNbr();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setWarrantyNbr(String argWarrantyNbr) {
/* 524 */     if (setWarrantyNbr_noev(argWarrantyNbr) && 
/* 525 */       this._events != null && 
/* 526 */       postEventsForChanges()) {
/* 527 */       this._events.post(IWarrantyModifier.SET_WARRANTYNBR, argWarrantyNbr);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setWarrantyNbr_noev(String argWarrantyNbr) {
/* 534 */     boolean ev_postable = false;
/*     */     
/* 536 */     if ((getDAO_().getWarrantyNbr() == null && argWarrantyNbr != null) || (
/* 537 */       getDAO_().getWarrantyNbr() != null && !getDAO_().getWarrantyNbr().equals(argWarrantyNbr))) {
/* 538 */       getDAO_().setWarrantyNbr(argWarrantyNbr);
/* 539 */       ev_postable = true;
/*     */     } 
/*     */     
/* 542 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getWarrantyTypeCode() {
/* 550 */     return getDAO_().getWarrantyTypeCode();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setWarrantyTypeCode(String argWarrantyTypeCode) {
/* 558 */     if (setWarrantyTypeCode_noev(argWarrantyTypeCode) && 
/* 559 */       this._events != null && 
/* 560 */       postEventsForChanges()) {
/* 561 */       this._events.post(IWarrantyModifier.SET_WARRANTYTYPECODE, argWarrantyTypeCode);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setWarrantyTypeCode_noev(String argWarrantyTypeCode) {
/* 568 */     boolean ev_postable = false;
/*     */     
/* 570 */     if ((getDAO_().getWarrantyTypeCode() == null && argWarrantyTypeCode != null) || (
/* 571 */       getDAO_().getWarrantyTypeCode() != null && !getDAO_().getWarrantyTypeCode().equals(argWarrantyTypeCode))) {
/* 572 */       getDAO_().setWarrantyTypeCode(argWarrantyTypeCode);
/* 573 */       ev_postable = true;
/*     */     } 
/*     */     
/* 576 */     return ev_postable;
/*     */   }
/*     */   
/*     */   protected IWarrantyModifierProperty newProperty(String argPropertyName) {
/* 580 */     WarrantyModifierPropertyId id = new WarrantyModifierPropertyId();
/*     */     
/* 582 */     id.setBusinessDate(getBusinessDate());
/* 583 */     id.setRetailLocationId(Long.valueOf(getRetailLocationId()));
/* 584 */     id.setRetailTransactionLineItemSequence(Integer.valueOf(getRetailTransactionLineItemSequence()));
/* 585 */     id.setTransactionSequence(Long.valueOf(getTransactionSequence()));
/* 586 */     id.setWorkstationId(Long.valueOf(getWorkstationId()));
/* 587 */     id.setWarrantyModifierSequence(Integer.valueOf(getWarrantyModifierSequence()));
/* 588 */     id.setPropertyCode(argPropertyName);
/*     */     
/* 590 */     IWarrantyModifierProperty prop = (IWarrantyModifierProperty)DataFactory.getInstance().createNewObject((IObjectId)id, IWarrantyModifierProperty.class);
/* 591 */     return prop;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @Relationship(name = "Properties")
/*     */   public List<IWarrantyModifierProperty> getProperties() {
/* 600 */     if (this._properties == null) {
/* 601 */       this._properties = new HistoricalList(null);
/*     */     }
/* 603 */     return (List<IWarrantyModifierProperty>)this._properties;
/*     */   }
/*     */   
/*     */   public void setProperties(List<IWarrantyModifierProperty> argProperties) {
/* 607 */     if (this._properties == null) {
/* 608 */       this._properties = new HistoricalList(argProperties);
/*     */     } else {
/* 610 */       this._properties.setCurrentList(argProperties);
/*     */     } 
/*     */     
/* 613 */     for (IWarrantyModifierProperty child : this._properties) {
/* 614 */       WarrantyModifierPropertyModel model = (WarrantyModifierPropertyModel)child;
/* 615 */       model.setBusinessDate_noev(getBusinessDate());
/* 616 */       model.setOrganizationId_noev(getOrganizationId());
/* 617 */       model.setRetailLocationId_noev(getRetailLocationId());
/* 618 */       model.setRetailTransactionLineItemSequence_noev(getRetailTransactionLineItemSequence());
/* 619 */       model.setTransactionSequence_noev(getTransactionSequence());
/* 620 */       model.setWorkstationId_noev(getWorkstationId());
/* 621 */       model.setWarrantyModifierSequence_noev(getWarrantyModifierSequence());
/* 622 */       if (child instanceof IDataModelImpl) {
/* 623 */         IDataAccessObject childDao = ((IDataModelImpl)child).getDAO();
/* 624 */         if (StringUtils.isEmpty(childDao.getOriginDataSource()) && 
/* 625 */           !StringUtils.isEmpty(getDAO().getOriginDataSource())) {
/* 626 */           childDao.setOriginDataSource(getDAO().getOriginDataSource());
/*     */         }
/*     */       } 
/* 629 */       if (postEventsForChanges()) {
/* 630 */         this._eventManager.registerEventHandler((IEventAware)this._eventCascade, (IEventSource)child);
/*     */       }
/*     */     } 
/*     */   }
/*     */   
/*     */   public void addWarrantyModifierProperty(IWarrantyModifierProperty argWarrantyModifierProperty) {
/* 636 */     if (this._properties == null) {
/* 637 */       this._properties = new HistoricalList(null);
/*     */     }
/* 639 */     argWarrantyModifierProperty.setBusinessDate(getBusinessDate());
/* 640 */     argWarrantyModifierProperty.setOrganizationId(getOrganizationId());
/* 641 */     argWarrantyModifierProperty.setRetailLocationId(getRetailLocationId());
/* 642 */     argWarrantyModifierProperty.setRetailTransactionLineItemSequence(getRetailTransactionLineItemSequence());
/* 643 */     argWarrantyModifierProperty.setTransactionSequence(getTransactionSequence());
/* 644 */     argWarrantyModifierProperty.setWorkstationId(getWorkstationId());
/* 645 */     argWarrantyModifierProperty.setWarrantyModifierSequence(getWarrantyModifierSequence());
/* 646 */     if (argWarrantyModifierProperty instanceof IDataModelImpl) {
/* 647 */       IDataAccessObject childDao = ((IDataModelImpl)argWarrantyModifierProperty).getDAO();
/* 648 */       if (StringUtils.isEmpty(childDao.getOriginDataSource()) && 
/* 649 */         !StringUtils.isEmpty(getDAO().getOriginDataSource())) {
/* 650 */         childDao.setOriginDataSource(getDAO().getOriginDataSource());
/*     */       }
/*     */     } 
/*     */ 
/*     */     
/* 655 */     if (postEventsForChanges()) {
/* 656 */       this._eventManager.registerEventHandler((IEventAware)this._eventCascade, (IEventSource)new EventDescriptor(argWarrantyModifierProperty));
/*     */     }
/*     */     
/* 659 */     this._properties.add(argWarrantyModifierProperty);
/* 660 */     if (postEventsForChanges()) {
/* 661 */       this._events.post(IWarrantyModifier.ADD_PROPERTIES, argWarrantyModifierProperty);
/*     */     }
/*     */   }
/*     */   
/*     */   public void removeWarrantyModifierProperty(IWarrantyModifierProperty argWarrantyModifierProperty) {
/* 666 */     if (this._properties != null) {
/*     */       
/* 668 */       if (postEventsForChanges()) {
/* 669 */         this._eventManager.deregisterEventHandler((IEventAware)this._eventCascade, (IEventSource)new EventDescriptor(argWarrantyModifierProperty));
/*     */       }
/* 671 */       this._properties.remove(argWarrantyModifierProperty);
/* 672 */       if (postEventsForChanges()) {
/* 673 */         this._events.post(IWarrantyModifier.REMOVE_PROPERTIES, argWarrantyModifierProperty);
/*     */       }
/*     */     } 
/*     */   }
/*     */   
/*     */   public void setParentLine(IWarrantyLineItem argParentLine) {
/* 679 */     this._parentLine = argParentLine;
/*     */   }
/*     */   
/*     */   public IWarrantyLineItem getParentLine() {
/* 683 */     return this._parentLine;
/*     */   }
/*     */ 
/*     */   
/*     */   public Object getValue(String argFieldId) {
/* 688 */     if ("Properties".equals(argFieldId)) {
/* 689 */       return getProperties();
/*     */     }
/* 691 */     if ("WarrantyModifierExtension".equals(argFieldId)) {
/* 692 */       return this._myExtension;
/*     */     }
/*     */     
/* 695 */     return super.getValue(argFieldId);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void setValue(String argFieldId, Object argValue) {
/* 701 */     if ("Properties".equals(argFieldId)) {
/* 702 */       setProperties(changeToList(argValue, IWarrantyModifierProperty.class));
/*     */     }
/* 704 */     else if ("WarrantyModifierExtension".equals(argFieldId)) {
/* 705 */       this._myExtension = (IDataModel)argValue;
/*     */     } else {
/*     */       
/* 708 */       super.setValue(argFieldId, argValue);
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public void setDependencies(IPersistenceDefaults argPD, EventManager argEM) {
/* 714 */     this._persistenceDefaults = argPD;
/* 715 */     this._daoImpl.setPersistenceDefaults(argPD);
/* 716 */     this._eventManager = argEM;
/* 717 */     this._events = (Eventor)new ModelEventor((IDataModel)this, argEM);
/* 718 */     this._eventCascade = (EventHandler)new CascadingHandler(this);
/* 719 */     if (this._properties != null) {
/* 720 */       for (IWarrantyModifierProperty relationship : this._properties) {
/* 721 */         ((IDataModelImpl)relationship).setDependencies(argPD, argEM);
/*     */       }
/*     */     }
/*     */   }
/*     */   
/*     */   public IDataModel getWarrantyModifierExt() {
/* 727 */     return this._myExtension;
/*     */   }
/*     */   
/*     */   public void setWarrantyModifierExt(IDataModel argExt) {
/* 731 */     this._myExtension = argExt;
/*     */   }
/*     */ 
/*     */   
/*     */   public void startTransaction() {
/* 736 */     if (this._alreadyInStart) {
/*     */       return;
/*     */     }
/*     */     
/* 740 */     this._alreadyInStart = true;
/*     */ 
/*     */     
/* 743 */     super.startTransaction();
/*     */     
/* 745 */     this._propertiesSavepoint = this._properties;
/* 746 */     if (this._properties != null) {
/* 747 */       this._propertiesSavepoint = new HistoricalList((List)this._properties);
/* 748 */       Iterator<IDataModel> it = this._properties.iterator();
/* 749 */       while (it.hasNext()) {
/* 750 */         ((IDataModel)it.next()).startTransaction();
/*     */       }
/*     */     } 
/*     */ 
/*     */     
/* 755 */     this._alreadyInStart = false;
/*     */   }
/*     */ 
/*     */   
/*     */   public void rollbackChanges() {
/* 760 */     if (isAlreadyRolledBack()) {
/*     */       return;
/*     */     }
/* 763 */     super.rollbackChanges();
/*     */     
/* 765 */     this._properties = this._propertiesSavepoint;
/* 766 */     this._propertiesSavepoint = null;
/* 767 */     if (this._properties != null) {
/* 768 */       Iterator<IDataModel> it = this._properties.iterator();
/* 769 */       while (it.hasNext()) {
/* 770 */         ((IDataModel)it.next()).rollbackChanges();
/*     */       }
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void commitTransaction() {
/* 778 */     if (this._alreadyInCommit) {
/*     */       return;
/*     */     }
/* 781 */     this._alreadyInCommit = true;
/*     */ 
/*     */     
/* 784 */     super.commitTransaction();
/*     */     
/* 786 */     this._propertiesSavepoint = this._properties;
/* 787 */     if (this._properties != null) {
/* 788 */       Iterator<IDataModel> it = this._properties.iterator();
/* 789 */       while (it.hasNext()) {
/* 790 */         ((IDataModel)it.next()).commitTransaction();
/*     */       }
/* 792 */       this._properties = new HistoricalList((List)this._properties);
/*     */     } 
/*     */ 
/*     */     
/* 796 */     this._alreadyInCommit = false;
/*     */   }
/*     */ 
/*     */   
/*     */   private void readObject(ObjectInputStream argStream) throws IOException, ClassNotFoundException {
/* 801 */     argStream.defaultReadObject();
/*     */   }
/*     */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\trl\impl\WarrantyModifierModel.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */