/*     */ package dtv.xst.dao.inv.impl;
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
/*     */ import dtv.xst.dao.inv.IInventoryCountSheet;
/*     */ import dtv.xst.dao.inv.IInventoryCountSheetLineItem;
/*     */ import dtv.xst.dao.inv.IInventoryCountSheetLineItemProperty;
/*     */ import dtv.xst.dao.inv.InventoryCountSheetLineItemPropertyId;
/*     */ import java.io.IOException;
/*     */ import java.io.ObjectInputStream;
/*     */ import java.math.BigDecimal;
/*     */ import java.util.Date;
/*     */ import java.util.Iterator;
/*     */ import java.util.List;
/*     */ 
/*     */ public class InventoryCountSheetLineItemModel extends AbstractDataModelWithPropertyImpl<IInventoryCountSheetLineItemProperty> implements IInventoryCountSheetLineItem {
/*     */   private static final long serialVersionUID = -1408801485L;
/*     */   private IInventoryCountSheet _parentCountSheet;
/*     */   private transient boolean _alreadyInStart = false;
/*     */   
/*     */   public String toString() {
/*  35 */     return super.toString() + " Id: " + getObjectId();
/*     */   }
/*     */   private transient boolean _alreadyInCommit = false; private IDataModel _myExtension; private HistoricalList<IInventoryCountSheetLineItemProperty> _properties; private transient HistoricalList<IInventoryCountSheetLineItemProperty> _propertiesSavepoint;
/*     */   
/*     */   public void initDAO() {
/*  40 */     setDAO((IDataAccessObject)new InventoryCountSheetLineItemDAO());
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private InventoryCountSheetLineItemDAO getDAO_() {
/*  48 */     return (InventoryCountSheetLineItemDAO)this._daoImpl;
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
/*  72 */       this._events.post(IInventoryCountSheetLineItem.SET_ORGANIZATIONID, Long.valueOf(argOrganizationId));
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
/*  87 */         Iterator<InventoryCountSheetLineItemPropertyModel> it = this._properties.iterator();
/*  88 */         while (it.hasNext())
/*     */         {
/*  90 */           ((InventoryCountSheetLineItemPropertyModel)it.next()).setOrganizationId_noev(argOrganizationId);
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
/* 119 */       this._events.post(IInventoryCountSheetLineItem.SET_RETAILLOCATIONID, Long.valueOf(argRetailLocationId));
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
/* 134 */         Iterator<InventoryCountSheetLineItemPropertyModel> it = this._properties.iterator();
/* 135 */         while (it.hasNext())
/*     */         {
/* 137 */           ((InventoryCountSheetLineItemPropertyModel)it.next()).setRetailLocationId_noev(argRetailLocationId);
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
/*     */   public String getInventoryCountId() {
/* 150 */     return getDAO_().getInventoryCountId();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setInventoryCountId(String argInventoryCountId) {
/* 158 */     if (setInventoryCountId_noev(argInventoryCountId) && 
/* 159 */       this._events != null && 
/* 160 */       postEventsForChanges()) {
/* 161 */       this._events.post(IInventoryCountSheetLineItem.SET_INVENTORYCOUNTID, argInventoryCountId);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setInventoryCountId_noev(String argInventoryCountId) {
/* 168 */     boolean ev_postable = false;
/*     */     
/* 170 */     if ((getDAO_().getInventoryCountId() == null && argInventoryCountId != null) || (
/* 171 */       getDAO_().getInventoryCountId() != null && !getDAO_().getInventoryCountId().equals(argInventoryCountId))) {
/* 172 */       getDAO_().setInventoryCountId(argInventoryCountId);
/* 173 */       ev_postable = true;
/* 174 */       if (this._properties != null) {
/*     */         
/* 176 */         Iterator<InventoryCountSheetLineItemPropertyModel> it = this._properties.iterator();
/* 177 */         while (it.hasNext())
/*     */         {
/* 179 */           ((InventoryCountSheetLineItemPropertyModel)it.next()).setInventoryCountId_noev(argInventoryCountId);
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
/*     */   public int getCountSheetNumber() {
/* 192 */     if (getDAO_().getCountSheetNumber() != null) {
/* 193 */       return getDAO_().getCountSheetNumber().intValue();
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
/*     */   public void setCountSheetNumber(int argCountSheetNumber) {
/* 205 */     if (setCountSheetNumber_noev(argCountSheetNumber) && 
/* 206 */       this._events != null && 
/* 207 */       postEventsForChanges()) {
/* 208 */       this._events.post(IInventoryCountSheetLineItem.SET_COUNTSHEETNUMBER, Integer.valueOf(argCountSheetNumber));
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setCountSheetNumber_noev(int argCountSheetNumber) {
/* 215 */     boolean ev_postable = false;
/*     */     
/* 217 */     if ((getDAO_().getCountSheetNumber() == null && Integer.valueOf(argCountSheetNumber) != null) || (
/* 218 */       getDAO_().getCountSheetNumber() != null && !getDAO_().getCountSheetNumber().equals(Integer.valueOf(argCountSheetNumber)))) {
/* 219 */       getDAO_().setCountSheetNumber(Integer.valueOf(argCountSheetNumber));
/* 220 */       ev_postable = true;
/* 221 */       if (this._properties != null) {
/*     */         
/* 223 */         Iterator<InventoryCountSheetLineItemPropertyModel> it = this._properties.iterator();
/* 224 */         while (it.hasNext())
/*     */         {
/* 226 */           ((InventoryCountSheetLineItemPropertyModel)it.next()).setCountSheetNumber_noev(argCountSheetNumber);
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
/*     */   public int getLineItemNumber() {
/* 239 */     if (getDAO_().getLineItemNumber() != null) {
/* 240 */       return getDAO_().getLineItemNumber().intValue();
/*     */     }
/*     */     
/* 243 */     return 0;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setLineItemNumber(int argLineItemNumber) {
/* 252 */     if (setLineItemNumber_noev(argLineItemNumber) && 
/* 253 */       this._events != null && 
/* 254 */       postEventsForChanges()) {
/* 255 */       this._events.post(IInventoryCountSheetLineItem.SET_LINEITEMNUMBER, Integer.valueOf(argLineItemNumber));
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setLineItemNumber_noev(int argLineItemNumber) {
/* 262 */     boolean ev_postable = false;
/*     */     
/* 264 */     if ((getDAO_().getLineItemNumber() == null && Integer.valueOf(argLineItemNumber) != null) || (
/* 265 */       getDAO_().getLineItemNumber() != null && !getDAO_().getLineItemNumber().equals(Integer.valueOf(argLineItemNumber)))) {
/* 266 */       getDAO_().setLineItemNumber(Integer.valueOf(argLineItemNumber));
/* 267 */       ev_postable = true;
/* 268 */       if (this._properties != null) {
/*     */         
/* 270 */         Iterator<InventoryCountSheetLineItemPropertyModel> it = this._properties.iterator();
/* 271 */         while (it.hasNext())
/*     */         {
/* 273 */           ((InventoryCountSheetLineItemPropertyModel)it.next()).setLineItemNumber_noev(argLineItemNumber);
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
/*     */   public Date getCreateDate() {
/* 286 */     return getDAO_().getCreateDate();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setCreateDate(Date argCreateDate) {
/* 294 */     if (setCreateDate_noev(argCreateDate) && 
/* 295 */       this._events != null && 
/* 296 */       postEventsForChanges()) {
/* 297 */       this._events.post(IInventoryCountSheetLineItem.SET_CREATEDATE, argCreateDate);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setCreateDate_noev(Date argCreateDate) {
/* 304 */     boolean ev_postable = false;
/*     */     
/* 306 */     if ((getDAO_().getCreateDate() == null && argCreateDate != null) || (
/* 307 */       getDAO_().getCreateDate() != null && !getDAO_().getCreateDate().equals(argCreateDate))) {
/* 308 */       getDAO_().setCreateDate(argCreateDate);
/* 309 */       ev_postable = true;
/*     */     } 
/*     */     
/* 312 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getCreateUserId() {
/* 320 */     return getDAO_().getCreateUserId();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setCreateUserId(String argCreateUserId) {
/* 328 */     if (setCreateUserId_noev(argCreateUserId) && 
/* 329 */       this._events != null && 
/* 330 */       postEventsForChanges()) {
/* 331 */       this._events.post(IInventoryCountSheetLineItem.SET_CREATEUSERID, argCreateUserId);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setCreateUserId_noev(String argCreateUserId) {
/* 338 */     boolean ev_postable = false;
/*     */     
/* 340 */     if ((getDAO_().getCreateUserId() == null && argCreateUserId != null) || (
/* 341 */       getDAO_().getCreateUserId() != null && !getDAO_().getCreateUserId().equals(argCreateUserId))) {
/* 342 */       getDAO_().setCreateUserId(argCreateUserId);
/* 343 */       ev_postable = true;
/*     */     } 
/*     */     
/* 346 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Date getUpdateDate() {
/* 354 */     return getDAO_().getUpdateDate();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setUpdateDate(Date argUpdateDate) {
/* 362 */     if (setUpdateDate_noev(argUpdateDate) && 
/* 363 */       this._events != null && 
/* 364 */       postEventsForChanges()) {
/* 365 */       this._events.post(IInventoryCountSheetLineItem.SET_UPDATEDATE, argUpdateDate);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setUpdateDate_noev(Date argUpdateDate) {
/* 372 */     boolean ev_postable = false;
/*     */     
/* 374 */     if ((getDAO_().getUpdateDate() == null && argUpdateDate != null) || (
/* 375 */       getDAO_().getUpdateDate() != null && !getDAO_().getUpdateDate().equals(argUpdateDate))) {
/* 376 */       getDAO_().setUpdateDate(argUpdateDate);
/* 377 */       ev_postable = true;
/*     */     } 
/*     */     
/* 380 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getUpdateUserId() {
/* 388 */     return getDAO_().getUpdateUserId();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setUpdateUserId(String argUpdateUserId) {
/* 396 */     if (setUpdateUserId_noev(argUpdateUserId) && 
/* 397 */       this._events != null && 
/* 398 */       postEventsForChanges()) {
/* 399 */       this._events.post(IInventoryCountSheetLineItem.SET_UPDATEUSERID, argUpdateUserId);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setUpdateUserId_noev(String argUpdateUserId) {
/* 406 */     boolean ev_postable = false;
/*     */     
/* 408 */     if ((getDAO_().getUpdateUserId() == null && argUpdateUserId != null) || (
/* 409 */       getDAO_().getUpdateUserId() != null && !getDAO_().getUpdateUserId().equals(argUpdateUserId))) {
/* 410 */       getDAO_().setUpdateUserId(argUpdateUserId);
/* 411 */       ev_postable = true;
/*     */     } 
/*     */     
/* 414 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getInventoryBucketId() {
/* 422 */     return getDAO_().getInventoryBucketId();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setInventoryBucketId(String argInventoryBucketId) {
/* 430 */     if (setInventoryBucketId_noev(argInventoryBucketId) && 
/* 431 */       this._events != null && 
/* 432 */       postEventsForChanges()) {
/* 433 */       this._events.post(IInventoryCountSheetLineItem.SET_INVENTORYBUCKETID, argInventoryBucketId);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setInventoryBucketId_noev(String argInventoryBucketId) {
/* 440 */     boolean ev_postable = false;
/*     */     
/* 442 */     if ((getDAO_().getInventoryBucketId() == null && argInventoryBucketId != null) || (
/* 443 */       getDAO_().getInventoryBucketId() != null && !getDAO_().getInventoryBucketId().equals(argInventoryBucketId))) {
/* 444 */       getDAO_().setInventoryBucketId(argInventoryBucketId);
/* 445 */       ev_postable = true;
/*     */     } 
/*     */     
/* 448 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int getCountCycle() {
/* 456 */     if (getDAO_().getCountCycle() != null) {
/* 457 */       return getDAO_().getCountCycle().intValue();
/*     */     }
/*     */     
/* 460 */     return 0;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setCountCycle(int argCountCycle) {
/* 469 */     if (setCountCycle_noev(argCountCycle) && 
/* 470 */       this._events != null && 
/* 471 */       postEventsForChanges()) {
/* 472 */       this._events.post(IInventoryCountSheetLineItem.SET_COUNTCYCLE, Integer.valueOf(argCountCycle));
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setCountCycle_noev(int argCountCycle) {
/* 479 */     boolean ev_postable = false;
/*     */     
/* 481 */     if ((getDAO_().getCountCycle() == null && Integer.valueOf(argCountCycle) != null) || (
/* 482 */       getDAO_().getCountCycle() != null && !getDAO_().getCountCycle().equals(Integer.valueOf(argCountCycle)))) {
/* 483 */       getDAO_().setCountCycle(Integer.valueOf(argCountCycle));
/* 484 */       ev_postable = true;
/*     */     } 
/*     */     
/* 487 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int getPageNumber() {
/* 495 */     if (getDAO_().getPageNumber() != null) {
/* 496 */       return getDAO_().getPageNumber().intValue();
/*     */     }
/*     */     
/* 499 */     return 0;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setPageNumber(int argPageNumber) {
/* 508 */     if (setPageNumber_noev(argPageNumber) && 
/* 509 */       this._events != null && 
/* 510 */       postEventsForChanges()) {
/* 511 */       this._events.post(IInventoryCountSheetLineItem.SET_PAGENUMBER, Integer.valueOf(argPageNumber));
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setPageNumber_noev(int argPageNumber) {
/* 518 */     boolean ev_postable = false;
/*     */     
/* 520 */     if ((getDAO_().getPageNumber() == null && Integer.valueOf(argPageNumber) != null) || (
/* 521 */       getDAO_().getPageNumber() != null && !getDAO_().getPageNumber().equals(Integer.valueOf(argPageNumber)))) {
/* 522 */       getDAO_().setPageNumber(Integer.valueOf(argPageNumber));
/* 523 */       ev_postable = true;
/*     */     } 
/*     */     
/* 526 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getItemId() {
/* 534 */     return getDAO_().getItemId();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setItemId(String argItemId) {
/* 542 */     if (setItemId_noev(argItemId) && 
/* 543 */       this._events != null && 
/* 544 */       postEventsForChanges()) {
/* 545 */       this._events.post(IInventoryCountSheetLineItem.SET_ITEMID, argItemId);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setItemId_noev(String argItemId) {
/* 552 */     boolean ev_postable = false;
/*     */     
/* 554 */     if ((getDAO_().getItemId() == null && argItemId != null) || (
/* 555 */       getDAO_().getItemId() != null && !getDAO_().getItemId().equals(argItemId))) {
/* 556 */       getDAO_().setItemId(argItemId);
/* 557 */       ev_postable = true;
/*     */     } 
/*     */     
/* 560 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getAlternateId() {
/* 568 */     return getDAO_().getAlternateId();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setAlternateId(String argAlternateId) {
/* 576 */     if (setAlternateId_noev(argAlternateId) && 
/* 577 */       this._events != null && 
/* 578 */       postEventsForChanges()) {
/* 579 */       this._events.post(IInventoryCountSheetLineItem.SET_ALTERNATEID, argAlternateId);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setAlternateId_noev(String argAlternateId) {
/* 586 */     boolean ev_postable = false;
/*     */     
/* 588 */     if ((getDAO_().getAlternateId() == null && argAlternateId != null) || (
/* 589 */       getDAO_().getAlternateId() != null && !getDAO_().getAlternateId().equals(argAlternateId))) {
/* 590 */       getDAO_().setAlternateId(argAlternateId);
/* 591 */       ev_postable = true;
/*     */     } 
/*     */     
/* 594 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getDescription() {
/* 602 */     return getDAO_().getDescription();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setDescription(String argDescription) {
/* 610 */     if (setDescription_noev(argDescription) && 
/* 611 */       this._events != null && 
/* 612 */       postEventsForChanges()) {
/* 613 */       this._events.post(IInventoryCountSheetLineItem.SET_DESCRIPTION, argDescription);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setDescription_noev(String argDescription) {
/* 620 */     boolean ev_postable = false;
/*     */     
/* 622 */     if ((getDAO_().getDescription() == null && argDescription != null) || (
/* 623 */       getDAO_().getDescription() != null && !getDAO_().getDescription().equals(argDescription))) {
/* 624 */       getDAO_().setDescription(argDescription);
/* 625 */       ev_postable = true;
/*     */     } 
/*     */     
/* 628 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public BigDecimal getQuantity() {
/* 636 */     return getDAO_().getQuantity();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setQuantity(BigDecimal argQuantity) {
/* 644 */     if (setQuantity_noev(argQuantity) && 
/* 645 */       this._events != null && 
/* 646 */       postEventsForChanges()) {
/* 647 */       this._events.post(IInventoryCountSheetLineItem.SET_QUANTITY, argQuantity);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setQuantity_noev(BigDecimal argQuantity) {
/* 654 */     boolean ev_postable = false;
/*     */     
/* 656 */     if ((getDAO_().getQuantity() == null && argQuantity != null) || (
/* 657 */       getDAO_().getQuantity() != null && !getDAO_().getQuantity().equals(argQuantity))) {
/* 658 */       getDAO_().setQuantity(argQuantity);
/* 659 */       ev_postable = true;
/*     */     } 
/*     */     
/* 662 */     return ev_postable;
/*     */   }
/*     */   
/*     */   protected IInventoryCountSheetLineItemProperty newProperty(String argPropertyName) {
/* 666 */     InventoryCountSheetLineItemPropertyId id = new InventoryCountSheetLineItemPropertyId();
/*     */     
/* 668 */     id.setRetailLocationId(Long.valueOf(getRetailLocationId()));
/* 669 */     id.setInventoryCountId(getInventoryCountId());
/* 670 */     id.setCountSheetNumber(Integer.valueOf(getCountSheetNumber()));
/* 671 */     id.setLineItemNumber(Integer.valueOf(getLineItemNumber()));
/* 672 */     id.setPropertyCode(argPropertyName);
/*     */     
/* 674 */     IInventoryCountSheetLineItemProperty prop = (IInventoryCountSheetLineItemProperty)DataFactory.getInstance().createNewObject((IObjectId)id, IInventoryCountSheetLineItemProperty.class);
/* 675 */     return prop;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @Relationship(name = "Properties")
/*     */   public List<IInventoryCountSheetLineItemProperty> getProperties() {
/* 684 */     if (this._properties == null) {
/* 685 */       this._properties = new HistoricalList(null);
/*     */     }
/* 687 */     return (List<IInventoryCountSheetLineItemProperty>)this._properties;
/*     */   }
/*     */   
/*     */   public void setProperties(List<IInventoryCountSheetLineItemProperty> argProperties) {
/* 691 */     if (this._properties == null) {
/* 692 */       this._properties = new HistoricalList(argProperties);
/*     */     } else {
/* 694 */       this._properties.setCurrentList(argProperties);
/*     */     } 
/*     */     
/* 697 */     for (IInventoryCountSheetLineItemProperty child : this._properties) {
/* 698 */       InventoryCountSheetLineItemPropertyModel model = (InventoryCountSheetLineItemPropertyModel)child;
/* 699 */       model.setOrganizationId_noev(getOrganizationId());
/* 700 */       model.setRetailLocationId_noev(getRetailLocationId());
/* 701 */       model.setInventoryCountId_noev(getInventoryCountId());
/* 702 */       model.setCountSheetNumber_noev(getCountSheetNumber());
/* 703 */       model.setLineItemNumber_noev(getLineItemNumber());
/* 704 */       if (child instanceof IDataModelImpl) {
/* 705 */         IDataAccessObject childDao = ((IDataModelImpl)child).getDAO();
/* 706 */         if (StringUtils.isEmpty(childDao.getOriginDataSource()) && 
/* 707 */           !StringUtils.isEmpty(getDAO().getOriginDataSource())) {
/* 708 */           childDao.setOriginDataSource(getDAO().getOriginDataSource());
/*     */         }
/*     */       } 
/* 711 */       if (postEventsForChanges()) {
/* 712 */         this._eventManager.registerEventHandler((IEventAware)this._eventCascade, (IEventSource)child);
/*     */       }
/*     */     } 
/*     */   }
/*     */   
/*     */   public void addInventoryCountSheetLineItemProperty(IInventoryCountSheetLineItemProperty argInventoryCountSheetLineItemProperty) {
/* 718 */     if (this._properties == null) {
/* 719 */       this._properties = new HistoricalList(null);
/*     */     }
/* 721 */     argInventoryCountSheetLineItemProperty.setOrganizationId(getOrganizationId());
/* 722 */     argInventoryCountSheetLineItemProperty.setRetailLocationId(getRetailLocationId());
/* 723 */     argInventoryCountSheetLineItemProperty.setInventoryCountId(getInventoryCountId());
/* 724 */     argInventoryCountSheetLineItemProperty.setCountSheetNumber(getCountSheetNumber());
/* 725 */     argInventoryCountSheetLineItemProperty.setLineItemNumber(getLineItemNumber());
/* 726 */     if (argInventoryCountSheetLineItemProperty instanceof IDataModelImpl) {
/* 727 */       IDataAccessObject childDao = ((IDataModelImpl)argInventoryCountSheetLineItemProperty).getDAO();
/* 728 */       if (StringUtils.isEmpty(childDao.getOriginDataSource()) && 
/* 729 */         !StringUtils.isEmpty(getDAO().getOriginDataSource())) {
/* 730 */         childDao.setOriginDataSource(getDAO().getOriginDataSource());
/*     */       }
/*     */     } 
/*     */ 
/*     */     
/* 735 */     if (postEventsForChanges()) {
/* 736 */       this._eventManager.registerEventHandler((IEventAware)this._eventCascade, (IEventSource)new EventDescriptor(argInventoryCountSheetLineItemProperty));
/*     */     }
/*     */     
/* 739 */     this._properties.add(argInventoryCountSheetLineItemProperty);
/* 740 */     if (postEventsForChanges()) {
/* 741 */       this._events.post(IInventoryCountSheetLineItem.ADD_PROPERTIES, argInventoryCountSheetLineItemProperty);
/*     */     }
/*     */   }
/*     */   
/*     */   public void removeInventoryCountSheetLineItemProperty(IInventoryCountSheetLineItemProperty argInventoryCountSheetLineItemProperty) {
/* 746 */     if (this._properties != null) {
/*     */       
/* 748 */       if (postEventsForChanges()) {
/* 749 */         this._eventManager.deregisterEventHandler((IEventAware)this._eventCascade, (IEventSource)new EventDescriptor(argInventoryCountSheetLineItemProperty));
/*     */       }
/* 751 */       this._properties.remove(argInventoryCountSheetLineItemProperty);
/* 752 */       if (postEventsForChanges()) {
/* 753 */         this._events.post(IInventoryCountSheetLineItem.REMOVE_PROPERTIES, argInventoryCountSheetLineItemProperty);
/*     */       }
/*     */     } 
/*     */   }
/*     */   
/*     */   public void setParentCountSheet(IInventoryCountSheet argParentCountSheet) {
/* 759 */     this._parentCountSheet = argParentCountSheet;
/*     */   }
/*     */   
/*     */   public IInventoryCountSheet getParentCountSheet() {
/* 763 */     return this._parentCountSheet;
/*     */   }
/*     */ 
/*     */   
/*     */   public Object getValue(String argFieldId) {
/* 768 */     if ("Properties".equals(argFieldId)) {
/* 769 */       return getProperties();
/*     */     }
/* 771 */     if ("InventoryCountSheetLineItemExtension".equals(argFieldId)) {
/* 772 */       return this._myExtension;
/*     */     }
/*     */     
/* 775 */     return super.getValue(argFieldId);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void setValue(String argFieldId, Object argValue) {
/* 781 */     if ("Properties".equals(argFieldId)) {
/* 782 */       setProperties(changeToList(argValue, IInventoryCountSheetLineItemProperty.class));
/*     */     }
/* 784 */     else if ("InventoryCountSheetLineItemExtension".equals(argFieldId)) {
/* 785 */       this._myExtension = (IDataModel)argValue;
/*     */     } else {
/*     */       
/* 788 */       super.setValue(argFieldId, argValue);
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public void setDependencies(IPersistenceDefaults argPD, EventManager argEM) {
/* 794 */     this._persistenceDefaults = argPD;
/* 795 */     this._daoImpl.setPersistenceDefaults(argPD);
/* 796 */     this._eventManager = argEM;
/* 797 */     this._events = (Eventor)new ModelEventor((IDataModel)this, argEM);
/* 798 */     this._eventCascade = (EventHandler)new CascadingHandler(this);
/* 799 */     if (this._properties != null) {
/* 800 */       for (IInventoryCountSheetLineItemProperty relationship : this._properties) {
/* 801 */         ((IDataModelImpl)relationship).setDependencies(argPD, argEM);
/*     */       }
/*     */     }
/*     */   }
/*     */   
/*     */   public IDataModel getInventoryCountSheetLineItemExt() {
/* 807 */     return this._myExtension;
/*     */   }
/*     */   
/*     */   public void setInventoryCountSheetLineItemExt(IDataModel argExt) {
/* 811 */     this._myExtension = argExt;
/*     */   }
/*     */ 
/*     */   
/*     */   public void startTransaction() {
/* 816 */     if (this._alreadyInStart) {
/*     */       return;
/*     */     }
/*     */     
/* 820 */     this._alreadyInStart = true;
/*     */ 
/*     */     
/* 823 */     super.startTransaction();
/*     */     
/* 825 */     this._propertiesSavepoint = this._properties;
/* 826 */     if (this._properties != null) {
/* 827 */       this._propertiesSavepoint = new HistoricalList((List)this._properties);
/* 828 */       Iterator<IDataModel> it = this._properties.iterator();
/* 829 */       while (it.hasNext()) {
/* 830 */         ((IDataModel)it.next()).startTransaction();
/*     */       }
/*     */     } 
/*     */ 
/*     */     
/* 835 */     this._alreadyInStart = false;
/*     */   }
/*     */ 
/*     */   
/*     */   public void rollbackChanges() {
/* 840 */     if (isAlreadyRolledBack()) {
/*     */       return;
/*     */     }
/* 843 */     super.rollbackChanges();
/*     */     
/* 845 */     this._properties = this._propertiesSavepoint;
/* 846 */     this._propertiesSavepoint = null;
/* 847 */     if (this._properties != null) {
/* 848 */       Iterator<IDataModel> it = this._properties.iterator();
/* 849 */       while (it.hasNext()) {
/* 850 */         ((IDataModel)it.next()).rollbackChanges();
/*     */       }
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void commitTransaction() {
/* 858 */     if (this._alreadyInCommit) {
/*     */       return;
/*     */     }
/* 861 */     this._alreadyInCommit = true;
/*     */ 
/*     */     
/* 864 */     super.commitTransaction();
/*     */     
/* 866 */     this._propertiesSavepoint = this._properties;
/* 867 */     if (this._properties != null) {
/* 868 */       Iterator<IDataModel> it = this._properties.iterator();
/* 869 */       while (it.hasNext()) {
/* 870 */         ((IDataModel)it.next()).commitTransaction();
/*     */       }
/* 872 */       this._properties = new HistoricalList((List)this._properties);
/*     */     } 
/*     */ 
/*     */     
/* 876 */     this._alreadyInCommit = false;
/*     */   }
/*     */ 
/*     */   
/*     */   private void readObject(ObjectInputStream argStream) throws IOException, ClassNotFoundException {
/* 881 */     argStream.defaultReadObject();
/*     */   }
/*     */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\inv\impl\InventoryCountSheetLineItemModel.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */