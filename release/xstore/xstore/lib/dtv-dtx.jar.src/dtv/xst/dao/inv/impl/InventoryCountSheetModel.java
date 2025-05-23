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
/*     */ import dtv.event.EventHandler;
/*     */ import dtv.event.EventManager;
/*     */ import dtv.event.Eventor;
/*     */ import dtv.event.IEventAware;
/*     */ import dtv.event.IEventSource;
/*     */ import dtv.event.handler.CascadingHandler;
/*     */ import dtv.util.HistoricalList;
/*     */ import dtv.util.StringUtils;
/*     */ import dtv.xst.dao.inv.IInventoryCountSheet;
/*     */ import dtv.xst.dao.inv.IInventoryCountSheetLineItem;
/*     */ import dtv.xst.dao.inv.IInventoryCountSheetProperty;
/*     */ import dtv.xst.dao.inv.InventoryCountSheetPropertyId;
/*     */ import java.util.Date;
/*     */ import java.util.Iterator;
/*     */ import java.util.List;
/*     */ 
/*     */ public class InventoryCountSheetModel extends InventoryCountSheetBaseModel implements IInventoryCountSheet {
/*     */   private static final long serialVersionUID = -1369888788L;
/*     */   private transient boolean _alreadyInStart = false;
/*     */   private transient boolean _alreadyInCommit = false;
/*     */   private IDataModel _myExtension;
/*     */   
/*     */   public String toString() {
/*  34 */     return super.toString() + " Id: " + getObjectId();
/*     */   }
/*     */   private HistoricalList<IInventoryCountSheetLineItem> _countSheetLineItems; private transient HistoricalList<IInventoryCountSheetLineItem> _countSheetLineItemsSavepoint; private HistoricalList<IInventoryCountSheetProperty> _properties; private transient HistoricalList<IInventoryCountSheetProperty> _propertiesSavepoint;
/*     */   
/*     */   public void initDAO() {
/*  39 */     setDAO((IDataAccessObject)new InventoryCountSheetDAO());
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private InventoryCountSheetDAO getDAO_() {
/*  47 */     return (InventoryCountSheetDAO)this._daoImpl;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public long getOrganizationId() {
/*  55 */     if (getDAO_().getOrganizationId() != null) {
/*  56 */       return getDAO_().getOrganizationId().longValue();
/*     */     }
/*     */     
/*  59 */     return 0L;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setOrganizationId(long argOrganizationId) {
/*  68 */     if (setOrganizationId_noev(argOrganizationId) && 
/*  69 */       this._events != null && 
/*  70 */       postEventsForChanges()) {
/*  71 */       this._events.post(IInventoryCountSheet.SET_ORGANIZATIONID, Long.valueOf(argOrganizationId));
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setOrganizationId_noev(long argOrganizationId) {
/*  78 */     boolean ev_postable = false;
/*     */     
/*  80 */     if ((getDAO_().getOrganizationId() == null && Long.valueOf(argOrganizationId) != null) || (
/*  81 */       getDAO_().getOrganizationId() != null && !getDAO_().getOrganizationId().equals(Long.valueOf(argOrganizationId)))) {
/*  82 */       getDAO_().setOrganizationId(Long.valueOf(argOrganizationId));
/*  83 */       ev_postable = true;
/*  84 */       if (this._countSheetLineItems != null) {
/*     */         
/*  86 */         Iterator<InventoryCountSheetLineItemModel> it = this._countSheetLineItems.iterator();
/*  87 */         while (it.hasNext())
/*     */         {
/*  89 */           ((InventoryCountSheetLineItemModel)it.next()).setOrganizationId_noev(argOrganizationId);
/*     */         }
/*     */       } 
/*  92 */       if (this._properties != null) {
/*     */         
/*  94 */         Iterator<InventoryCountSheetPropertyModel> it = this._properties.iterator();
/*  95 */         while (it.hasNext())
/*     */         {
/*  97 */           ((InventoryCountSheetPropertyModel)it.next()).setOrganizationId_noev(argOrganizationId);
/*     */         }
/*     */       } 
/*     */     } 
/*     */     
/* 102 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public long getRetailLocationId() {
/* 110 */     if (getDAO_().getRetailLocationId() != null) {
/* 111 */       return getDAO_().getRetailLocationId().longValue();
/*     */     }
/*     */     
/* 114 */     return 0L;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setRetailLocationId(long argRetailLocationId) {
/* 123 */     if (setRetailLocationId_noev(argRetailLocationId) && 
/* 124 */       this._events != null && 
/* 125 */       postEventsForChanges()) {
/* 126 */       this._events.post(IInventoryCountSheet.SET_RETAILLOCATIONID, Long.valueOf(argRetailLocationId));
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setRetailLocationId_noev(long argRetailLocationId) {
/* 133 */     boolean ev_postable = false;
/*     */     
/* 135 */     if ((getDAO_().getRetailLocationId() == null && Long.valueOf(argRetailLocationId) != null) || (
/* 136 */       getDAO_().getRetailLocationId() != null && !getDAO_().getRetailLocationId().equals(Long.valueOf(argRetailLocationId)))) {
/* 137 */       getDAO_().setRetailLocationId(Long.valueOf(argRetailLocationId));
/* 138 */       ev_postable = true;
/* 139 */       if (this._countSheetLineItems != null) {
/*     */         
/* 141 */         Iterator<InventoryCountSheetLineItemModel> it = this._countSheetLineItems.iterator();
/* 142 */         while (it.hasNext())
/*     */         {
/* 144 */           ((InventoryCountSheetLineItemModel)it.next()).setRetailLocationId_noev(argRetailLocationId);
/*     */         }
/*     */       } 
/* 147 */       if (this._properties != null) {
/*     */         
/* 149 */         Iterator<InventoryCountSheetPropertyModel> it = this._properties.iterator();
/* 150 */         while (it.hasNext())
/*     */         {
/* 152 */           ((InventoryCountSheetPropertyModel)it.next()).setRetailLocationId_noev(argRetailLocationId);
/*     */         }
/*     */       } 
/*     */     } 
/*     */     
/* 157 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getInventoryCountId() {
/* 165 */     return getDAO_().getInventoryCountId();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setInventoryCountId(String argInventoryCountId) {
/* 173 */     if (setInventoryCountId_noev(argInventoryCountId) && 
/* 174 */       this._events != null && 
/* 175 */       postEventsForChanges()) {
/* 176 */       this._events.post(IInventoryCountSheet.SET_INVENTORYCOUNTID, argInventoryCountId);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setInventoryCountId_noev(String argInventoryCountId) {
/* 183 */     boolean ev_postable = false;
/*     */     
/* 185 */     if ((getDAO_().getInventoryCountId() == null && argInventoryCountId != null) || (
/* 186 */       getDAO_().getInventoryCountId() != null && !getDAO_().getInventoryCountId().equals(argInventoryCountId))) {
/* 187 */       getDAO_().setInventoryCountId(argInventoryCountId);
/* 188 */       ev_postable = true;
/* 189 */       if (this._countSheetLineItems != null) {
/*     */         
/* 191 */         Iterator<InventoryCountSheetLineItemModel> it = this._countSheetLineItems.iterator();
/* 192 */         while (it.hasNext())
/*     */         {
/* 194 */           ((InventoryCountSheetLineItemModel)it.next()).setInventoryCountId_noev(argInventoryCountId);
/*     */         }
/*     */       } 
/* 197 */       if (this._properties != null) {
/*     */         
/* 199 */         Iterator<InventoryCountSheetPropertyModel> it = this._properties.iterator();
/* 200 */         while (it.hasNext())
/*     */         {
/* 202 */           ((InventoryCountSheetPropertyModel)it.next()).setInventoryCountId_noev(argInventoryCountId);
/*     */         }
/*     */       } 
/*     */     } 
/*     */     
/* 207 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int getCountSheetNumber() {
/* 215 */     if (getDAO_().getCountSheetNumber() != null) {
/* 216 */       return getDAO_().getCountSheetNumber().intValue();
/*     */     }
/*     */     
/* 219 */     return 0;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setCountSheetNumber(int argCountSheetNumber) {
/* 228 */     if (setCountSheetNumber_noev(argCountSheetNumber) && 
/* 229 */       this._events != null && 
/* 230 */       postEventsForChanges()) {
/* 231 */       this._events.post(IInventoryCountSheet.SET_COUNTSHEETNUMBER, Integer.valueOf(argCountSheetNumber));
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setCountSheetNumber_noev(int argCountSheetNumber) {
/* 238 */     boolean ev_postable = false;
/*     */     
/* 240 */     if ((getDAO_().getCountSheetNumber() == null && Integer.valueOf(argCountSheetNumber) != null) || (
/* 241 */       getDAO_().getCountSheetNumber() != null && !getDAO_().getCountSheetNumber().equals(Integer.valueOf(argCountSheetNumber)))) {
/* 242 */       getDAO_().setCountSheetNumber(Integer.valueOf(argCountSheetNumber));
/* 243 */       ev_postable = true;
/* 244 */       if (this._countSheetLineItems != null) {
/*     */         
/* 246 */         Iterator<InventoryCountSheetLineItemModel> it = this._countSheetLineItems.iterator();
/* 247 */         while (it.hasNext())
/*     */         {
/* 249 */           ((InventoryCountSheetLineItemModel)it.next()).setCountSheetNumber_noev(argCountSheetNumber);
/*     */         }
/*     */       } 
/* 252 */       if (this._properties != null) {
/*     */         
/* 254 */         Iterator<InventoryCountSheetPropertyModel> it = this._properties.iterator();
/* 255 */         while (it.hasNext())
/*     */         {
/* 257 */           ((InventoryCountSheetPropertyModel)it.next()).setCountSheetNumber_noev(argCountSheetNumber);
/*     */         }
/*     */       } 
/*     */     } 
/*     */     
/* 262 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Date getCreateDate() {
/* 270 */     return getDAO_().getCreateDate();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setCreateDate(Date argCreateDate) {
/* 278 */     if (setCreateDate_noev(argCreateDate) && 
/* 279 */       this._events != null && 
/* 280 */       postEventsForChanges()) {
/* 281 */       this._events.post(IInventoryCountSheet.SET_CREATEDATE, argCreateDate);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setCreateDate_noev(Date argCreateDate) {
/* 288 */     boolean ev_postable = false;
/*     */     
/* 290 */     if ((getDAO_().getCreateDate() == null && argCreateDate != null) || (
/* 291 */       getDAO_().getCreateDate() != null && !getDAO_().getCreateDate().equals(argCreateDate))) {
/* 292 */       getDAO_().setCreateDate(argCreateDate);
/* 293 */       ev_postable = true;
/*     */     } 
/*     */     
/* 296 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getCreateUserId() {
/* 304 */     return getDAO_().getCreateUserId();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setCreateUserId(String argCreateUserId) {
/* 312 */     if (setCreateUserId_noev(argCreateUserId) && 
/* 313 */       this._events != null && 
/* 314 */       postEventsForChanges()) {
/* 315 */       this._events.post(IInventoryCountSheet.SET_CREATEUSERID, argCreateUserId);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setCreateUserId_noev(String argCreateUserId) {
/* 322 */     boolean ev_postable = false;
/*     */     
/* 324 */     if ((getDAO_().getCreateUserId() == null && argCreateUserId != null) || (
/* 325 */       getDAO_().getCreateUserId() != null && !getDAO_().getCreateUserId().equals(argCreateUserId))) {
/* 326 */       getDAO_().setCreateUserId(argCreateUserId);
/* 327 */       ev_postable = true;
/*     */     } 
/*     */     
/* 330 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Date getUpdateDate() {
/* 338 */     return getDAO_().getUpdateDate();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setUpdateDate(Date argUpdateDate) {
/* 346 */     if (setUpdateDate_noev(argUpdateDate) && 
/* 347 */       this._events != null && 
/* 348 */       postEventsForChanges()) {
/* 349 */       this._events.post(IInventoryCountSheet.SET_UPDATEDATE, argUpdateDate);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setUpdateDate_noev(Date argUpdateDate) {
/* 356 */     boolean ev_postable = false;
/*     */     
/* 358 */     if ((getDAO_().getUpdateDate() == null && argUpdateDate != null) || (
/* 359 */       getDAO_().getUpdateDate() != null && !getDAO_().getUpdateDate().equals(argUpdateDate))) {
/* 360 */       getDAO_().setUpdateDate(argUpdateDate);
/* 361 */       ev_postable = true;
/*     */     } 
/*     */     
/* 364 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getUpdateUserId() {
/* 372 */     return getDAO_().getUpdateUserId();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setUpdateUserId(String argUpdateUserId) {
/* 380 */     if (setUpdateUserId_noev(argUpdateUserId) && 
/* 381 */       this._events != null && 
/* 382 */       postEventsForChanges()) {
/* 383 */       this._events.post(IInventoryCountSheet.SET_UPDATEUSERID, argUpdateUserId);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setUpdateUserId_noev(String argUpdateUserId) {
/* 390 */     boolean ev_postable = false;
/*     */     
/* 392 */     if ((getDAO_().getUpdateUserId() == null && argUpdateUserId != null) || (
/* 393 */       getDAO_().getUpdateUserId() != null && !getDAO_().getUpdateUserId().equals(argUpdateUserId))) {
/* 394 */       getDAO_().setUpdateUserId(argUpdateUserId);
/* 395 */       ev_postable = true;
/*     */     } 
/*     */     
/* 398 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getInventoryBucketId() {
/* 406 */     return getDAO_().getInventoryBucketId();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setInventoryBucketId(String argInventoryBucketId) {
/* 414 */     if (setInventoryBucketId_noev(argInventoryBucketId) && 
/* 415 */       this._events != null && 
/* 416 */       postEventsForChanges()) {
/* 417 */       this._events.post(IInventoryCountSheet.SET_INVENTORYBUCKETID, argInventoryBucketId);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setInventoryBucketId_noev(String argInventoryBucketId) {
/* 424 */     boolean ev_postable = false;
/*     */     
/* 426 */     if ((getDAO_().getInventoryBucketId() == null && argInventoryBucketId != null) || (
/* 427 */       getDAO_().getInventoryBucketId() != null && !getDAO_().getInventoryBucketId().equals(argInventoryBucketId))) {
/* 428 */       getDAO_().setInventoryBucketId(argInventoryBucketId);
/* 429 */       ev_postable = true;
/*     */     } 
/*     */     
/* 432 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int getSectionNumber() {
/* 440 */     if (getDAO_().getSectionNumber() != null) {
/* 441 */       return getDAO_().getSectionNumber().intValue();
/*     */     }
/*     */     
/* 444 */     return 0;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setSectionNumber(int argSectionNumber) {
/* 453 */     if (setSectionNumber_noev(argSectionNumber) && 
/* 454 */       this._events != null && 
/* 455 */       postEventsForChanges()) {
/* 456 */       this._events.post(IInventoryCountSheet.SET_SECTIONNUMBER, Integer.valueOf(argSectionNumber));
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setSectionNumber_noev(int argSectionNumber) {
/* 463 */     boolean ev_postable = false;
/*     */     
/* 465 */     if ((getDAO_().getSectionNumber() == null && Integer.valueOf(argSectionNumber) != null) || (
/* 466 */       getDAO_().getSectionNumber() != null && !getDAO_().getSectionNumber().equals(Integer.valueOf(argSectionNumber)))) {
/* 467 */       getDAO_().setSectionNumber(Integer.valueOf(argSectionNumber));
/* 468 */       ev_postable = true;
/*     */     } 
/*     */     
/* 471 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getSectionId() {
/* 479 */     return getDAO_().getSectionId();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setSectionId(String argSectionId) {
/* 487 */     if (setSectionId_noev(argSectionId) && 
/* 488 */       this._events != null && 
/* 489 */       postEventsForChanges()) {
/* 490 */       this._events.post(IInventoryCountSheet.SET_SECTIONID, argSectionId);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setSectionId_noev(String argSectionId) {
/* 497 */     boolean ev_postable = false;
/*     */     
/* 499 */     if ((getDAO_().getSectionId() == null && argSectionId != null) || (
/* 500 */       getDAO_().getSectionId() != null && !getDAO_().getSectionId().equals(argSectionId))) {
/* 501 */       getDAO_().setSectionId(argSectionId);
/* 502 */       ev_postable = true;
/*     */     } 
/*     */     
/* 505 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int getCountCycle() {
/* 513 */     if (getDAO_().getCountCycle() != null) {
/* 514 */       return getDAO_().getCountCycle().intValue();
/*     */     }
/*     */     
/* 517 */     return 0;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setCountCycle(int argCountCycle) {
/* 526 */     if (setCountCycle_noev(argCountCycle) && 
/* 527 */       this._events != null && 
/* 528 */       postEventsForChanges()) {
/* 529 */       this._events.post(IInventoryCountSheet.SET_COUNTCYCLE, Integer.valueOf(argCountCycle));
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setCountCycle_noev(int argCountCycle) {
/* 536 */     boolean ev_postable = false;
/*     */     
/* 538 */     if ((getDAO_().getCountCycle() == null && Integer.valueOf(argCountCycle) != null) || (
/* 539 */       getDAO_().getCountCycle() != null && !getDAO_().getCountCycle().equals(Integer.valueOf(argCountCycle)))) {
/* 540 */       getDAO_().setCountCycle(Integer.valueOf(argCountCycle));
/* 541 */       ev_postable = true;
/*     */     } 
/*     */     
/* 544 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getSheetStatus() {
/* 552 */     return getDAO_().getSheetStatus();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setSheetStatus(String argSheetStatus) {
/* 560 */     if (setSheetStatus_noev(argSheetStatus) && 
/* 561 */       this._events != null && 
/* 562 */       postEventsForChanges()) {
/* 563 */       this._events.post(IInventoryCountSheet.SET_SHEETSTATUS, argSheetStatus);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setSheetStatus_noev(String argSheetStatus) {
/* 570 */     boolean ev_postable = false;
/*     */     
/* 572 */     if ((getDAO_().getSheetStatus() == null && argSheetStatus != null) || (
/* 573 */       getDAO_().getSheetStatus() != null && !getDAO_().getSheetStatus().equals(argSheetStatus))) {
/* 574 */       getDAO_().setSheetStatus(argSheetStatus);
/* 575 */       ev_postable = true;
/*     */     } 
/*     */     
/* 578 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean getCheckedOut() {
/* 586 */     if (getDAO_().getCheckedOut() != null) {
/* 587 */       return getDAO_().getCheckedOut().booleanValue();
/*     */     }
/*     */     
/* 590 */     return false;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setCheckedOut(boolean argCheckedOut) {
/* 599 */     if (setCheckedOut_noev(argCheckedOut) && 
/* 600 */       this._events != null && 
/* 601 */       postEventsForChanges()) {
/* 602 */       this._events.post(IInventoryCountSheet.SET_CHECKEDOUT, Boolean.valueOf(argCheckedOut));
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setCheckedOut_noev(boolean argCheckedOut) {
/* 609 */     boolean ev_postable = false;
/*     */     
/* 611 */     if ((getDAO_().getCheckedOut() == null && Boolean.valueOf(argCheckedOut) != null) || (
/* 612 */       getDAO_().getCheckedOut() != null && !getDAO_().getCheckedOut().equals(Boolean.valueOf(argCheckedOut)))) {
/* 613 */       getDAO_().setCheckedOut(Boolean.valueOf(argCheckedOut));
/* 614 */       ev_postable = true;
/*     */     } 
/*     */     
/* 617 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getInventoryBucketName() {
/* 625 */     return getDAO_().getInventoryBucketName();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setInventoryBucketName(String argInventoryBucketName) {
/* 633 */     if (setInventoryBucketName_noev(argInventoryBucketName) && 
/* 634 */       this._events != null && 
/* 635 */       postEventsForChanges()) {
/* 636 */       this._events.post(IInventoryCountSheet.SET_INVENTORYBUCKETNAME, argInventoryBucketName);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setInventoryBucketName_noev(String argInventoryBucketName) {
/* 643 */     boolean ev_postable = false;
/*     */     
/* 645 */     if ((getDAO_().getInventoryBucketName() == null && argInventoryBucketName != null) || (
/* 646 */       getDAO_().getInventoryBucketName() != null && !getDAO_().getInventoryBucketName().equals(argInventoryBucketName))) {
/* 647 */       getDAO_().setInventoryBucketName(argInventoryBucketName);
/* 648 */       ev_postable = true;
/*     */     } 
/*     */     
/* 651 */     return ev_postable;
/*     */   }
/*     */   
/*     */   protected IInventoryCountSheetProperty newProperty(String argPropertyName) {
/* 655 */     InventoryCountSheetPropertyId id = new InventoryCountSheetPropertyId();
/*     */     
/* 657 */     id.setRetailLocationId(Long.valueOf(getRetailLocationId()));
/* 658 */     id.setInventoryCountId(getInventoryCountId());
/* 659 */     id.setCountSheetNumber(Integer.valueOf(getCountSheetNumber()));
/* 660 */     id.setPropertyCode(argPropertyName);
/*     */     
/* 662 */     IInventoryCountSheetProperty prop = (IInventoryCountSheetProperty)DataFactory.getInstance().createNewObject((IObjectId)id, IInventoryCountSheetProperty.class);
/* 663 */     return prop;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @Relationship(name = "CountSheetLineItems")
/*     */   public List<IInventoryCountSheetLineItem> getCountSheetLineItems() {
/* 675 */     if (this._countSheetLineItems == null) {
/* 676 */       this._countSheetLineItems = new HistoricalList(null);
/*     */     }
/* 678 */     return (List<IInventoryCountSheetLineItem>)this._countSheetLineItems;
/*     */   }
/*     */   
/*     */   public void setCountSheetLineItems(List<IInventoryCountSheetLineItem> argCountSheetLineItems) {
/* 682 */     if (this._countSheetLineItems == null) {
/* 683 */       this._countSheetLineItems = new HistoricalList(argCountSheetLineItems);
/*     */     } else {
/* 685 */       this._countSheetLineItems.setCurrentList(argCountSheetLineItems);
/*     */     } 
/*     */     
/* 688 */     for (IInventoryCountSheetLineItem child : this._countSheetLineItems) {
/* 689 */       child.setParentCountSheet(this);
/*     */     }
/*     */ 
/*     */     
/* 693 */     for (IInventoryCountSheetLineItem child : this._countSheetLineItems) {
/* 694 */       InventoryCountSheetLineItemModel model = (InventoryCountSheetLineItemModel)child;
/* 695 */       model.setOrganizationId_noev(getOrganizationId());
/* 696 */       model.setRetailLocationId_noev(getRetailLocationId());
/* 697 */       model.setInventoryCountId_noev(getInventoryCountId());
/* 698 */       model.setCountSheetNumber_noev(getCountSheetNumber());
/* 699 */       if (child instanceof IDataModelImpl) {
/* 700 */         IDataAccessObject childDao = ((IDataModelImpl)child).getDAO();
/* 701 */         if (StringUtils.isEmpty(childDao.getOriginDataSource()) && 
/* 702 */           !StringUtils.isEmpty(getDAO().getOriginDataSource())) {
/* 703 */           childDao.setOriginDataSource(getDAO().getOriginDataSource());
/*     */         }
/*     */       } 
/* 706 */       if (postEventsForChanges()) {
/* 707 */         this._eventManager.registerEventHandler((IEventAware)this._eventCascade, (IEventSource)child);
/*     */       }
/*     */     } 
/*     */   }
/*     */   
/*     */   public void addInventoryCountSheetLineItem(IInventoryCountSheetLineItem argInventoryCountSheetLineItem) {
/* 713 */     super.addInventoryCountSheetLineItem(argInventoryCountSheetLineItem);
/*     */ 
/*     */     
/* 716 */     argInventoryCountSheetLineItem.setParentCountSheet(this);
/* 717 */     if (this._countSheetLineItems == null) {
/* 718 */       this._countSheetLineItems = new HistoricalList(null);
/*     */     }
/* 720 */     argInventoryCountSheetLineItem.setOrganizationId(getOrganizationId());
/* 721 */     argInventoryCountSheetLineItem.setRetailLocationId(getRetailLocationId());
/* 722 */     argInventoryCountSheetLineItem.setInventoryCountId(getInventoryCountId());
/* 723 */     argInventoryCountSheetLineItem.setCountSheetNumber(getCountSheetNumber());
/* 724 */     if (argInventoryCountSheetLineItem instanceof IDataModelImpl) {
/* 725 */       IDataAccessObject childDao = ((IDataModelImpl)argInventoryCountSheetLineItem).getDAO();
/* 726 */       if (StringUtils.isEmpty(childDao.getOriginDataSource()) && 
/* 727 */         !StringUtils.isEmpty(getDAO().getOriginDataSource())) {
/* 728 */         childDao.setOriginDataSource(getDAO().getOriginDataSource());
/*     */       }
/*     */     } 
/*     */ 
/*     */     
/* 733 */     if (postEventsForChanges()) {
/* 734 */       this._eventManager.registerEventHandler((IEventAware)this._eventCascade, (IEventSource)new EventDescriptor(argInventoryCountSheetLineItem));
/*     */     }
/*     */     
/* 737 */     this._countSheetLineItems.add(argInventoryCountSheetLineItem);
/* 738 */     if (postEventsForChanges()) {
/* 739 */       this._events.post(IInventoryCountSheet.ADD_COUNTSHEETLINEITEMS, argInventoryCountSheetLineItem);
/*     */     }
/*     */   }
/*     */   
/*     */   public void removeInventoryCountSheetLineItem(IInventoryCountSheetLineItem argInventoryCountSheetLineItem) {
/* 744 */     if (this._countSheetLineItems != null) {
/*     */       
/* 746 */       if (postEventsForChanges()) {
/* 747 */         this._eventManager.deregisterEventHandler((IEventAware)this._eventCascade, (IEventSource)new EventDescriptor(argInventoryCountSheetLineItem));
/*     */       }
/* 749 */       this._countSheetLineItems.remove(argInventoryCountSheetLineItem);
/*     */       
/* 751 */       argInventoryCountSheetLineItem.setParentCountSheet(null);
/* 752 */       if (postEventsForChanges()) {
/* 753 */         this._events.post(IInventoryCountSheet.REMOVE_COUNTSHEETLINEITEMS, argInventoryCountSheetLineItem);
/*     */       }
/*     */     } 
/*     */   }
/*     */   
/*     */   @Relationship(name = "Properties")
/*     */   public List<IInventoryCountSheetProperty> getProperties() {
/* 760 */     if (this._properties == null) {
/* 761 */       this._properties = new HistoricalList(null);
/*     */     }
/* 763 */     return (List<IInventoryCountSheetProperty>)this._properties;
/*     */   }
/*     */   
/*     */   public void setProperties(List<IInventoryCountSheetProperty> argProperties) {
/* 767 */     if (this._properties == null) {
/* 768 */       this._properties = new HistoricalList(argProperties);
/*     */     } else {
/* 770 */       this._properties.setCurrentList(argProperties);
/*     */     } 
/*     */     
/* 773 */     for (IInventoryCountSheetProperty child : this._properties) {
/* 774 */       InventoryCountSheetPropertyModel model = (InventoryCountSheetPropertyModel)child;
/* 775 */       model.setOrganizationId_noev(getOrganizationId());
/* 776 */       model.setRetailLocationId_noev(getRetailLocationId());
/* 777 */       model.setInventoryCountId_noev(getInventoryCountId());
/* 778 */       model.setCountSheetNumber_noev(getCountSheetNumber());
/* 779 */       if (child instanceof IDataModelImpl) {
/* 780 */         IDataAccessObject childDao = ((IDataModelImpl)child).getDAO();
/* 781 */         if (StringUtils.isEmpty(childDao.getOriginDataSource()) && 
/* 782 */           !StringUtils.isEmpty(getDAO().getOriginDataSource())) {
/* 783 */           childDao.setOriginDataSource(getDAO().getOriginDataSource());
/*     */         }
/*     */       } 
/* 786 */       if (postEventsForChanges()) {
/* 787 */         this._eventManager.registerEventHandler((IEventAware)this._eventCascade, (IEventSource)child);
/*     */       }
/*     */     } 
/*     */   }
/*     */   
/*     */   public void addInventoryCountSheetProperty(IInventoryCountSheetProperty argInventoryCountSheetProperty) {
/* 793 */     if (this._properties == null) {
/* 794 */       this._properties = new HistoricalList(null);
/*     */     }
/* 796 */     argInventoryCountSheetProperty.setOrganizationId(getOrganizationId());
/* 797 */     argInventoryCountSheetProperty.setRetailLocationId(getRetailLocationId());
/* 798 */     argInventoryCountSheetProperty.setInventoryCountId(getInventoryCountId());
/* 799 */     argInventoryCountSheetProperty.setCountSheetNumber(getCountSheetNumber());
/* 800 */     if (argInventoryCountSheetProperty instanceof IDataModelImpl) {
/* 801 */       IDataAccessObject childDao = ((IDataModelImpl)argInventoryCountSheetProperty).getDAO();
/* 802 */       if (StringUtils.isEmpty(childDao.getOriginDataSource()) && 
/* 803 */         !StringUtils.isEmpty(getDAO().getOriginDataSource())) {
/* 804 */         childDao.setOriginDataSource(getDAO().getOriginDataSource());
/*     */       }
/*     */     } 
/*     */ 
/*     */     
/* 809 */     if (postEventsForChanges()) {
/* 810 */       this._eventManager.registerEventHandler((IEventAware)this._eventCascade, (IEventSource)new EventDescriptor(argInventoryCountSheetProperty));
/*     */     }
/*     */     
/* 813 */     this._properties.add(argInventoryCountSheetProperty);
/* 814 */     if (postEventsForChanges()) {
/* 815 */       this._events.post(IInventoryCountSheet.ADD_PROPERTIES, argInventoryCountSheetProperty);
/*     */     }
/*     */   }
/*     */   
/*     */   public void removeInventoryCountSheetProperty(IInventoryCountSheetProperty argInventoryCountSheetProperty) {
/* 820 */     if (this._properties != null) {
/*     */       
/* 822 */       if (postEventsForChanges()) {
/* 823 */         this._eventManager.deregisterEventHandler((IEventAware)this._eventCascade, (IEventSource)new EventDescriptor(argInventoryCountSheetProperty));
/*     */       }
/* 825 */       this._properties.remove(argInventoryCountSheetProperty);
/* 826 */       if (postEventsForChanges()) {
/* 827 */         this._events.post(IInventoryCountSheet.REMOVE_PROPERTIES, argInventoryCountSheetProperty);
/*     */       }
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public Object getValue(String argFieldId) {
/* 834 */     if ("CountSheetLineItems".equals(argFieldId)) {
/* 835 */       return getCountSheetLineItems();
/*     */     }
/* 837 */     if ("Properties".equals(argFieldId)) {
/* 838 */       return getProperties();
/*     */     }
/* 840 */     if ("InventoryCountSheetExtension".equals(argFieldId)) {
/* 841 */       return this._myExtension;
/*     */     }
/*     */     
/* 844 */     return super.getValue(argFieldId);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void setValue(String argFieldId, Object argValue) {
/* 850 */     if ("CountSheetLineItems".equals(argFieldId)) {
/* 851 */       setCountSheetLineItems(changeToList(argValue, IInventoryCountSheetLineItem.class));
/*     */     }
/* 853 */     else if ("Properties".equals(argFieldId)) {
/* 854 */       setProperties(changeToList(argValue, IInventoryCountSheetProperty.class));
/*     */     }
/* 856 */     else if ("InventoryCountSheetExtension".equals(argFieldId)) {
/* 857 */       this._myExtension = (IDataModel)argValue;
/*     */     } else {
/*     */       
/* 860 */       super.setValue(argFieldId, argValue);
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public void setDependencies(IPersistenceDefaults argPD, EventManager argEM) {
/* 866 */     this._persistenceDefaults = argPD;
/* 867 */     this._daoImpl.setPersistenceDefaults(argPD);
/* 868 */     this._eventManager = argEM;
/* 869 */     this._events = (Eventor)new ModelEventor((IDataModel)this, argEM);
/* 870 */     this._eventCascade = (EventHandler)new CascadingHandler(this);
/* 871 */     if (this._countSheetLineItems != null) {
/* 872 */       for (IInventoryCountSheetLineItem relationship : this._countSheetLineItems) {
/* 873 */         ((IDataModelImpl)relationship).setDependencies(argPD, argEM);
/*     */       }
/*     */     }
/* 876 */     if (this._properties != null) {
/* 877 */       for (IInventoryCountSheetProperty relationship : this._properties) {
/* 878 */         ((IDataModelImpl)relationship).setDependencies(argPD, argEM);
/*     */       }
/*     */     }
/*     */   }
/*     */   
/*     */   public IDataModel getInventoryCountSheetExt() {
/* 884 */     return this._myExtension;
/*     */   }
/*     */   
/*     */   public void setInventoryCountSheetExt(IDataModel argExt) {
/* 888 */     this._myExtension = argExt;
/*     */   }
/*     */ 
/*     */   
/*     */   public void startTransaction() {
/* 893 */     if (this._alreadyInStart) {
/*     */       return;
/*     */     }
/*     */     
/* 897 */     this._alreadyInStart = true;
/*     */ 
/*     */     
/* 900 */     super.startTransaction();
/*     */     
/* 902 */     this._countSheetLineItemsSavepoint = this._countSheetLineItems;
/* 903 */     if (this._countSheetLineItems != null) {
/* 904 */       this._countSheetLineItemsSavepoint = new HistoricalList((List)this._countSheetLineItems);
/* 905 */       Iterator<IDataModel> it = this._countSheetLineItems.iterator();
/* 906 */       while (it.hasNext()) {
/* 907 */         ((IDataModel)it.next()).startTransaction();
/*     */       }
/*     */     } 
/*     */     
/* 911 */     this._propertiesSavepoint = this._properties;
/* 912 */     if (this._properties != null) {
/* 913 */       this._propertiesSavepoint = new HistoricalList((List)this._properties);
/* 914 */       Iterator<IDataModel> it = this._properties.iterator();
/* 915 */       while (it.hasNext()) {
/* 916 */         ((IDataModel)it.next()).startTransaction();
/*     */       }
/*     */     } 
/*     */ 
/*     */     
/* 921 */     this._alreadyInStart = false;
/*     */   }
/*     */ 
/*     */   
/*     */   public void rollbackChanges() {
/* 926 */     if (isAlreadyRolledBack()) {
/*     */       return;
/*     */     }
/* 929 */     super.rollbackChanges();
/*     */     
/* 931 */     this._countSheetLineItems = this._countSheetLineItemsSavepoint;
/* 932 */     this._countSheetLineItemsSavepoint = null;
/* 933 */     if (this._countSheetLineItems != null) {
/* 934 */       Iterator<IDataModel> it = this._countSheetLineItems.iterator();
/* 935 */       while (it.hasNext()) {
/* 936 */         ((IDataModel)it.next()).rollbackChanges();
/*     */       }
/*     */     } 
/*     */     
/* 940 */     this._properties = this._propertiesSavepoint;
/* 941 */     this._propertiesSavepoint = null;
/* 942 */     if (this._properties != null) {
/* 943 */       Iterator<IDataModel> it = this._properties.iterator();
/* 944 */       while (it.hasNext()) {
/* 945 */         ((IDataModel)it.next()).rollbackChanges();
/*     */       }
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void commitTransaction() {
/* 953 */     if (this._alreadyInCommit) {
/*     */       return;
/*     */     }
/* 956 */     this._alreadyInCommit = true;
/*     */ 
/*     */     
/* 959 */     super.commitTransaction();
/*     */     
/* 961 */     this._countSheetLineItemsSavepoint = this._countSheetLineItems;
/* 962 */     if (this._countSheetLineItems != null) {
/* 963 */       Iterator<IDataModel> it = this._countSheetLineItems.iterator();
/* 964 */       while (it.hasNext()) {
/* 965 */         ((IDataModel)it.next()).commitTransaction();
/*     */       }
/* 967 */       this._countSheetLineItems = new HistoricalList((List)this._countSheetLineItems);
/*     */     } 
/*     */     
/* 970 */     this._propertiesSavepoint = this._properties;
/* 971 */     if (this._properties != null) {
/* 972 */       Iterator<IDataModel> it = this._properties.iterator();
/* 973 */       while (it.hasNext()) {
/* 974 */         ((IDataModel)it.next()).commitTransaction();
/*     */       }
/* 976 */       this._properties = new HistoricalList((List)this._properties);
/*     */     } 
/*     */ 
/*     */     
/* 980 */     this._alreadyInCommit = false;
/*     */   }
/*     */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\inv\impl\InventoryCountSheetModel.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */