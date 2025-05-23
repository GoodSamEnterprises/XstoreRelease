/*     */ package dtv.xst.dao.trn.impl;
/*     */ import dtv.data2.IPersistenceDefaults;
/*     */ import dtv.data2.access.IDataAccessObject;
/*     */ import dtv.data2.access.IDataModel;
/*     */ import dtv.data2.access.IDataProperty;
/*     */ import dtv.data2.access.IObjectId;
/*     */ import dtv.data2.access.ModelEventor;
/*     */ import dtv.data2.access.exception.DtxException;
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
/*     */ import dtv.xst.dao.trn.IPosTransaction;
/*     */ import dtv.xst.dao.trn.IPosTransactionLink;
/*     */ import dtv.xst.dao.trn.IPosTransactionLinkProperty;
/*     */ import dtv.xst.dao.trn.PosTransactionLinkPropertyId;
/*     */ import java.io.IOException;
/*     */ import java.io.ObjectInputStream;
/*     */ import java.util.Date;
/*     */ import java.util.Iterator;
/*     */ import java.util.List;
/*     */ 
/*     */ public class PosTransactionLinkModel extends AbstractDataModelWithPropertyImpl<IPosTransactionLinkProperty> implements IPosTransactionLink {
/*     */   private static final long serialVersionUID = -878991580L;
/*     */   private IPosTransaction _parentTransaction;
/*     */   private transient boolean _alreadyInStart = false;
/*     */   private transient boolean _alreadyInCommit = false;
/*     */   
/*     */   public String toString() {
/*  36 */     return super.toString() + " Id: " + getObjectId();
/*     */   }
/*     */   private IDataModel _myExtension; private IPosTransaction _linkedTransaction; private transient IPosTransaction _linkedTransactionSavepoint; private HistoricalList<IPosTransactionLinkProperty> _properties; private transient HistoricalList<IPosTransactionLinkProperty> _propertiesSavepoint;
/*     */   
/*     */   public void initDAO() {
/*  41 */     setDAO((IDataAccessObject)new PosTransactionLinkDAO());
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private PosTransactionLinkDAO getDAO_() {
/*  49 */     return (PosTransactionLinkDAO)this._daoImpl;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Date getBusinessDate() {
/*  57 */     return getDAO_().getBusinessDate();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setBusinessDate(Date argBusinessDate) {
/*  65 */     if (setBusinessDate_noev(argBusinessDate) && 
/*  66 */       this._events != null && 
/*  67 */       postEventsForChanges()) {
/*  68 */       this._events.post(IPosTransactionLink.SET_BUSINESSDATE, argBusinessDate);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setBusinessDate_noev(Date argBusinessDate) {
/*  75 */     boolean ev_postable = false;
/*     */     
/*  77 */     if ((getDAO_().getBusinessDate() == null && argBusinessDate != null) || (
/*  78 */       getDAO_().getBusinessDate() != null && !getDAO_().getBusinessDate().equals(argBusinessDate))) {
/*  79 */       getDAO_().setBusinessDate(argBusinessDate);
/*  80 */       ev_postable = true;
/*  81 */       if (this._properties != null) {
/*     */         
/*  83 */         Iterator<PosTransactionLinkPropertyModel> it = this._properties.iterator();
/*  84 */         while (it.hasNext())
/*     */         {
/*  86 */           ((PosTransactionLinkPropertyModel)it.next()).setBusinessDate_noev(argBusinessDate);
/*     */         }
/*     */       } 
/*     */     } 
/*     */     
/*  91 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Date getLinkBusinessDate() {
/*  99 */     return getDAO_().getLinkBusinessDate();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setLinkBusinessDate(Date argLinkBusinessDate) {
/* 107 */     if (setLinkBusinessDate_noev(argLinkBusinessDate) && 
/* 108 */       this._events != null && 
/* 109 */       postEventsForChanges()) {
/* 110 */       this._events.post(IPosTransactionLink.SET_LINKBUSINESSDATE, argLinkBusinessDate);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setLinkBusinessDate_noev(Date argLinkBusinessDate) {
/* 117 */     boolean ev_postable = false;
/*     */     
/* 119 */     if ((getDAO_().getLinkBusinessDate() == null && argLinkBusinessDate != null) || (
/* 120 */       getDAO_().getLinkBusinessDate() != null && !getDAO_().getLinkBusinessDate().equals(argLinkBusinessDate))) {
/* 121 */       getDAO_().setLinkBusinessDate(argLinkBusinessDate);
/* 122 */       ev_postable = true;
/* 123 */       if (this._properties != null) {
/*     */         
/* 125 */         Iterator<PosTransactionLinkPropertyModel> it = this._properties.iterator();
/* 126 */         while (it.hasNext())
/*     */         {
/* 128 */           ((PosTransactionLinkPropertyModel)it.next()).setLinkBusinessDate_noev(argLinkBusinessDate);
/*     */         }
/*     */       } 
/*     */     } 
/*     */     
/* 133 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public long getLinkRetailLocationId() {
/* 141 */     if (getDAO_().getLinkRetailLocationId() != null) {
/* 142 */       return getDAO_().getLinkRetailLocationId().longValue();
/*     */     }
/*     */     
/* 145 */     return 0L;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setLinkRetailLocationId(long argLinkRetailLocationId) {
/* 154 */     if (setLinkRetailLocationId_noev(argLinkRetailLocationId) && 
/* 155 */       this._events != null && 
/* 156 */       postEventsForChanges()) {
/* 157 */       this._events.post(IPosTransactionLink.SET_LINKRETAILLOCATIONID, Long.valueOf(argLinkRetailLocationId));
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setLinkRetailLocationId_noev(long argLinkRetailLocationId) {
/* 164 */     boolean ev_postable = false;
/*     */     
/* 166 */     if ((getDAO_().getLinkRetailLocationId() == null && Long.valueOf(argLinkRetailLocationId) != null) || (
/* 167 */       getDAO_().getLinkRetailLocationId() != null && !getDAO_().getLinkRetailLocationId().equals(Long.valueOf(argLinkRetailLocationId)))) {
/* 168 */       getDAO_().setLinkRetailLocationId(Long.valueOf(argLinkRetailLocationId));
/* 169 */       ev_postable = true;
/* 170 */       if (this._properties != null) {
/*     */         
/* 172 */         Iterator<PosTransactionLinkPropertyModel> it = this._properties.iterator();
/* 173 */         while (it.hasNext())
/*     */         {
/* 175 */           ((PosTransactionLinkPropertyModel)it.next()).setLinkRetailLocationId_noev(argLinkRetailLocationId);
/*     */         }
/*     */       } 
/*     */     } 
/*     */     
/* 180 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public long getLinkTransactionSequence() {
/* 188 */     if (getDAO_().getLinkTransactionSequence() != null) {
/* 189 */       return getDAO_().getLinkTransactionSequence().longValue();
/*     */     }
/*     */     
/* 192 */     return 0L;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setLinkTransactionSequence(long argLinkTransactionSequence) {
/* 201 */     if (setLinkTransactionSequence_noev(argLinkTransactionSequence) && 
/* 202 */       this._events != null && 
/* 203 */       postEventsForChanges()) {
/* 204 */       this._events.post(IPosTransactionLink.SET_LINKTRANSACTIONSEQUENCE, Long.valueOf(argLinkTransactionSequence));
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setLinkTransactionSequence_noev(long argLinkTransactionSequence) {
/* 211 */     boolean ev_postable = false;
/*     */     
/* 213 */     if ((getDAO_().getLinkTransactionSequence() == null && Long.valueOf(argLinkTransactionSequence) != null) || (
/* 214 */       getDAO_().getLinkTransactionSequence() != null && !getDAO_().getLinkTransactionSequence().equals(Long.valueOf(argLinkTransactionSequence)))) {
/* 215 */       getDAO_().setLinkTransactionSequence(Long.valueOf(argLinkTransactionSequence));
/* 216 */       ev_postable = true;
/* 217 */       if (this._properties != null) {
/*     */         
/* 219 */         Iterator<PosTransactionLinkPropertyModel> it = this._properties.iterator();
/* 220 */         while (it.hasNext())
/*     */         {
/* 222 */           ((PosTransactionLinkPropertyModel)it.next()).setLinkTransactionSequence_noev(argLinkTransactionSequence);
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
/*     */   public long getLinkWorkstationId() {
/* 235 */     if (getDAO_().getLinkWorkstationId() != null) {
/* 236 */       return getDAO_().getLinkWorkstationId().longValue();
/*     */     }
/*     */     
/* 239 */     return 0L;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setLinkWorkstationId(long argLinkWorkstationId) {
/* 248 */     if (setLinkWorkstationId_noev(argLinkWorkstationId) && 
/* 249 */       this._events != null && 
/* 250 */       postEventsForChanges()) {
/* 251 */       this._events.post(IPosTransactionLink.SET_LINKWORKSTATIONID, Long.valueOf(argLinkWorkstationId));
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setLinkWorkstationId_noev(long argLinkWorkstationId) {
/* 258 */     boolean ev_postable = false;
/*     */     
/* 260 */     if ((getDAO_().getLinkWorkstationId() == null && Long.valueOf(argLinkWorkstationId) != null) || (
/* 261 */       getDAO_().getLinkWorkstationId() != null && !getDAO_().getLinkWorkstationId().equals(Long.valueOf(argLinkWorkstationId)))) {
/* 262 */       getDAO_().setLinkWorkstationId(Long.valueOf(argLinkWorkstationId));
/* 263 */       ev_postable = true;
/* 264 */       if (this._properties != null) {
/*     */         
/* 266 */         Iterator<PosTransactionLinkPropertyModel> it = this._properties.iterator();
/* 267 */         while (it.hasNext())
/*     */         {
/* 269 */           ((PosTransactionLinkPropertyModel)it.next()).setLinkWorkstationId_noev(argLinkWorkstationId);
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
/*     */   public long getOrganizationId() {
/* 282 */     if (getDAO_().getOrganizationId() != null) {
/* 283 */       return getDAO_().getOrganizationId().longValue();
/*     */     }
/*     */     
/* 286 */     return 0L;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setOrganizationId(long argOrganizationId) {
/* 295 */     if (setOrganizationId_noev(argOrganizationId) && 
/* 296 */       this._events != null && 
/* 297 */       postEventsForChanges()) {
/* 298 */       this._events.post(IPosTransactionLink.SET_ORGANIZATIONID, Long.valueOf(argOrganizationId));
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setOrganizationId_noev(long argOrganizationId) {
/* 305 */     boolean ev_postable = false;
/*     */     
/* 307 */     if ((getDAO_().getOrganizationId() == null && Long.valueOf(argOrganizationId) != null) || (
/* 308 */       getDAO_().getOrganizationId() != null && !getDAO_().getOrganizationId().equals(Long.valueOf(argOrganizationId)))) {
/* 309 */       getDAO_().setOrganizationId(Long.valueOf(argOrganizationId));
/* 310 */       ev_postable = true;
/* 311 */       if (this._properties != null) {
/*     */         
/* 313 */         Iterator<PosTransactionLinkPropertyModel> it = this._properties.iterator();
/* 314 */         while (it.hasNext())
/*     */         {
/* 316 */           ((PosTransactionLinkPropertyModel)it.next()).setOrganizationId_noev(argOrganizationId);
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
/*     */   public long getRetailLocationId() {
/* 329 */     if (getDAO_().getRetailLocationId() != null) {
/* 330 */       return getDAO_().getRetailLocationId().longValue();
/*     */     }
/*     */     
/* 333 */     return 0L;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setRetailLocationId(long argRetailLocationId) {
/* 342 */     if (setRetailLocationId_noev(argRetailLocationId) && 
/* 343 */       this._events != null && 
/* 344 */       postEventsForChanges()) {
/* 345 */       this._events.post(IPosTransactionLink.SET_RETAILLOCATIONID, Long.valueOf(argRetailLocationId));
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setRetailLocationId_noev(long argRetailLocationId) {
/* 352 */     boolean ev_postable = false;
/*     */     
/* 354 */     if ((getDAO_().getRetailLocationId() == null && Long.valueOf(argRetailLocationId) != null) || (
/* 355 */       getDAO_().getRetailLocationId() != null && !getDAO_().getRetailLocationId().equals(Long.valueOf(argRetailLocationId)))) {
/* 356 */       getDAO_().setRetailLocationId(Long.valueOf(argRetailLocationId));
/* 357 */       ev_postable = true;
/* 358 */       if (this._properties != null) {
/*     */         
/* 360 */         Iterator<PosTransactionLinkPropertyModel> it = this._properties.iterator();
/* 361 */         while (it.hasNext())
/*     */         {
/* 363 */           ((PosTransactionLinkPropertyModel)it.next()).setRetailLocationId_noev(argRetailLocationId);
/*     */         }
/*     */       } 
/*     */     } 
/*     */     
/* 368 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public long getTransactionSequence() {
/* 376 */     if (getDAO_().getTransactionSequence() != null) {
/* 377 */       return getDAO_().getTransactionSequence().longValue();
/*     */     }
/*     */     
/* 380 */     return 0L;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setTransactionSequence(long argTransactionSequence) {
/* 389 */     if (setTransactionSequence_noev(argTransactionSequence) && 
/* 390 */       this._events != null && 
/* 391 */       postEventsForChanges()) {
/* 392 */       this._events.post(IPosTransactionLink.SET_TRANSACTIONSEQUENCE, Long.valueOf(argTransactionSequence));
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setTransactionSequence_noev(long argTransactionSequence) {
/* 399 */     boolean ev_postable = false;
/*     */     
/* 401 */     if ((getDAO_().getTransactionSequence() == null && Long.valueOf(argTransactionSequence) != null) || (
/* 402 */       getDAO_().getTransactionSequence() != null && !getDAO_().getTransactionSequence().equals(Long.valueOf(argTransactionSequence)))) {
/* 403 */       getDAO_().setTransactionSequence(Long.valueOf(argTransactionSequence));
/* 404 */       ev_postable = true;
/* 405 */       if (this._properties != null) {
/*     */         
/* 407 */         Iterator<PosTransactionLinkPropertyModel> it = this._properties.iterator();
/* 408 */         while (it.hasNext())
/*     */         {
/* 410 */           ((PosTransactionLinkPropertyModel)it.next()).setTransactionSequence_noev(argTransactionSequence);
/*     */         }
/*     */       } 
/*     */     } 
/*     */     
/* 415 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public long getWorkstationId() {
/* 423 */     if (getDAO_().getWorkstationId() != null) {
/* 424 */       return getDAO_().getWorkstationId().longValue();
/*     */     }
/*     */     
/* 427 */     return 0L;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setWorkstationId(long argWorkstationId) {
/* 436 */     if (setWorkstationId_noev(argWorkstationId) && 
/* 437 */       this._events != null && 
/* 438 */       postEventsForChanges()) {
/* 439 */       this._events.post(IPosTransactionLink.SET_WORKSTATIONID, Long.valueOf(argWorkstationId));
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setWorkstationId_noev(long argWorkstationId) {
/* 446 */     boolean ev_postable = false;
/*     */     
/* 448 */     if ((getDAO_().getWorkstationId() == null && Long.valueOf(argWorkstationId) != null) || (
/* 449 */       getDAO_().getWorkstationId() != null && !getDAO_().getWorkstationId().equals(Long.valueOf(argWorkstationId)))) {
/* 450 */       getDAO_().setWorkstationId(Long.valueOf(argWorkstationId));
/* 451 */       ev_postable = true;
/* 452 */       if (this._properties != null) {
/*     */         
/* 454 */         Iterator<PosTransactionLinkPropertyModel> it = this._properties.iterator();
/* 455 */         while (it.hasNext())
/*     */         {
/* 457 */           ((PosTransactionLinkPropertyModel)it.next()).setWorkstationId_noev(argWorkstationId);
/*     */         }
/*     */       } 
/*     */     } 
/*     */     
/* 462 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Date getCreateDate() {
/* 470 */     return getDAO_().getCreateDate();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setCreateDate(Date argCreateDate) {
/* 478 */     if (setCreateDate_noev(argCreateDate) && 
/* 479 */       this._events != null && 
/* 480 */       postEventsForChanges()) {
/* 481 */       this._events.post(IPosTransactionLink.SET_CREATEDATE, argCreateDate);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setCreateDate_noev(Date argCreateDate) {
/* 488 */     boolean ev_postable = false;
/*     */     
/* 490 */     if ((getDAO_().getCreateDate() == null && argCreateDate != null) || (
/* 491 */       getDAO_().getCreateDate() != null && !getDAO_().getCreateDate().equals(argCreateDate))) {
/* 492 */       getDAO_().setCreateDate(argCreateDate);
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
/*     */   public String getCreateUserId() {
/* 504 */     return getDAO_().getCreateUserId();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setCreateUserId(String argCreateUserId) {
/* 512 */     if (setCreateUserId_noev(argCreateUserId) && 
/* 513 */       this._events != null && 
/* 514 */       postEventsForChanges()) {
/* 515 */       this._events.post(IPosTransactionLink.SET_CREATEUSERID, argCreateUserId);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setCreateUserId_noev(String argCreateUserId) {
/* 522 */     boolean ev_postable = false;
/*     */     
/* 524 */     if ((getDAO_().getCreateUserId() == null && argCreateUserId != null) || (
/* 525 */       getDAO_().getCreateUserId() != null && !getDAO_().getCreateUserId().equals(argCreateUserId))) {
/* 526 */       getDAO_().setCreateUserId(argCreateUserId);
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
/*     */   public Date getUpdateDate() {
/* 538 */     return getDAO_().getUpdateDate();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setUpdateDate(Date argUpdateDate) {
/* 546 */     if (setUpdateDate_noev(argUpdateDate) && 
/* 547 */       this._events != null && 
/* 548 */       postEventsForChanges()) {
/* 549 */       this._events.post(IPosTransactionLink.SET_UPDATEDATE, argUpdateDate);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setUpdateDate_noev(Date argUpdateDate) {
/* 556 */     boolean ev_postable = false;
/*     */     
/* 558 */     if ((getDAO_().getUpdateDate() == null && argUpdateDate != null) || (
/* 559 */       getDAO_().getUpdateDate() != null && !getDAO_().getUpdateDate().equals(argUpdateDate))) {
/* 560 */       getDAO_().setUpdateDate(argUpdateDate);
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
/*     */   public String getUpdateUserId() {
/* 572 */     return getDAO_().getUpdateUserId();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setUpdateUserId(String argUpdateUserId) {
/* 580 */     if (setUpdateUserId_noev(argUpdateUserId) && 
/* 581 */       this._events != null && 
/* 582 */       postEventsForChanges()) {
/* 583 */       this._events.post(IPosTransactionLink.SET_UPDATEUSERID, argUpdateUserId);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setUpdateUserId_noev(String argUpdateUserId) {
/* 590 */     boolean ev_postable = false;
/*     */     
/* 592 */     if ((getDAO_().getUpdateUserId() == null && argUpdateUserId != null) || (
/* 593 */       getDAO_().getUpdateUserId() != null && !getDAO_().getUpdateUserId().equals(argUpdateUserId))) {
/* 594 */       getDAO_().setUpdateUserId(argUpdateUserId);
/* 595 */       ev_postable = true;
/*     */     } 
/*     */     
/* 598 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getLinkTypeCode() {
/* 606 */     return getDAO_().getLinkTypeCode();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setLinkTypeCode(String argLinkTypeCode) {
/* 614 */     if (setLinkTypeCode_noev(argLinkTypeCode) && 
/* 615 */       this._events != null && 
/* 616 */       postEventsForChanges()) {
/* 617 */       this._events.post(IPosTransactionLink.SET_LINKTYPECODE, argLinkTypeCode);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setLinkTypeCode_noev(String argLinkTypeCode) {
/* 624 */     boolean ev_postable = false;
/*     */     
/* 626 */     if ((getDAO_().getLinkTypeCode() == null && argLinkTypeCode != null) || (
/* 627 */       getDAO_().getLinkTypeCode() != null && !getDAO_().getLinkTypeCode().equals(argLinkTypeCode))) {
/* 628 */       getDAO_().setLinkTypeCode(argLinkTypeCode);
/* 629 */       ev_postable = true;
/*     */     } 
/*     */     
/* 632 */     return ev_postable;
/*     */   }
/*     */   
/*     */   protected IPosTransactionLinkProperty newProperty(String argPropertyName) {
/* 636 */     PosTransactionLinkPropertyId id = new PosTransactionLinkPropertyId();
/*     */     
/* 638 */     id.setBusinessDate(getBusinessDate());
/* 639 */     id.setLinkBusinessDate(getLinkBusinessDate());
/* 640 */     id.setLinkRetailLocationId(Long.valueOf(getLinkRetailLocationId()));
/* 641 */     id.setLinkTransactionSequence(Long.valueOf(getLinkTransactionSequence()));
/* 642 */     id.setLinkWorkstationId(Long.valueOf(getLinkWorkstationId()));
/* 643 */     id.setRetailLocationId(Long.valueOf(getRetailLocationId()));
/* 644 */     id.setTransactionSequence(Long.valueOf(getTransactionSequence()));
/* 645 */     id.setWorkstationId(Long.valueOf(getWorkstationId()));
/* 646 */     id.setPropertyCode(argPropertyName);
/*     */     
/* 648 */     IPosTransactionLinkProperty prop = (IPosTransactionLinkProperty)DataFactory.getInstance().createNewObject((IObjectId)id, IPosTransactionLinkProperty.class);
/* 649 */     return prop;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @Relationship(name = "LinkedTransaction")
/*     */   public IPosTransaction getLinkedTransaction() {
/* 661 */     return this._linkedTransaction;
/*     */   }
/*     */ 
/*     */   
/*     */   public void setLinkedTransaction(IPosTransaction argLinkedTransaction) {
/* 666 */     if (argLinkedTransaction == null) {
/*     */       
/* 668 */       if (this._linkedTransaction != null) {
/* 669 */         throw new DtxException("An Attempt was made to break a ONE-ONE relationship that cannot be broken because all fields that define the relationship are primary keys on the parent data object.");
/*     */       }
/*     */       
/* 672 */       if (this._linkedTransaction != null)
/*     */       {
/* 674 */         if (postEventsForChanges()) {
/* 675 */           this._eventManager.deregisterEventHandler((IEventAware)this._eventCascade, (IEventSource)new EventDescriptor(this._linkedTransaction));
/*     */         
/*     */         }
/*     */       
/*     */       }
/*     */     }
/* 681 */     else if (postEventsForChanges()) {
/* 682 */       this._eventManager.registerEventHandler((IEventAware)this._eventCascade, (IEventSource)new EventDescriptor(argLinkedTransaction));
/*     */     } 
/*     */ 
/*     */     
/* 686 */     this._linkedTransaction = argLinkedTransaction;
/* 687 */     if (postEventsForChanges()) {
/* 688 */       this._events.post(IPosTransactionLink.SET_LINKEDTRANSACTION, argLinkedTransaction);
/*     */     }
/*     */   }
/*     */   
/*     */   @Relationship(name = "Properties")
/*     */   public List<IPosTransactionLinkProperty> getProperties() {
/* 694 */     if (this._properties == null) {
/* 695 */       this._properties = new HistoricalList(null);
/*     */     }
/* 697 */     return (List<IPosTransactionLinkProperty>)this._properties;
/*     */   }
/*     */   
/*     */   public void setProperties(List<IPosTransactionLinkProperty> argProperties) {
/* 701 */     if (this._properties == null) {
/* 702 */       this._properties = new HistoricalList(argProperties);
/*     */     } else {
/* 704 */       this._properties.setCurrentList(argProperties);
/*     */     } 
/*     */     
/* 707 */     for (IPosTransactionLinkProperty child : this._properties) {
/* 708 */       PosTransactionLinkPropertyModel model = (PosTransactionLinkPropertyModel)child;
/* 709 */       model.setBusinessDate_noev(getBusinessDate());
/* 710 */       model.setLinkBusinessDate_noev(getLinkBusinessDate());
/* 711 */       model.setLinkRetailLocationId_noev(getLinkRetailLocationId());
/* 712 */       model.setLinkTransactionSequence_noev(getLinkTransactionSequence());
/* 713 */       model.setLinkWorkstationId_noev(getLinkWorkstationId());
/* 714 */       model.setOrganizationId_noev(getOrganizationId());
/* 715 */       model.setRetailLocationId_noev(getRetailLocationId());
/* 716 */       model.setTransactionSequence_noev(getTransactionSequence());
/* 717 */       model.setWorkstationId_noev(getWorkstationId());
/* 718 */       if (child instanceof IDataModelImpl) {
/* 719 */         IDataAccessObject childDao = ((IDataModelImpl)child).getDAO();
/* 720 */         if (StringUtils.isEmpty(childDao.getOriginDataSource()) && 
/* 721 */           !StringUtils.isEmpty(getDAO().getOriginDataSource())) {
/* 722 */           childDao.setOriginDataSource(getDAO().getOriginDataSource());
/*     */         }
/*     */       } 
/* 725 */       if (postEventsForChanges()) {
/* 726 */         this._eventManager.registerEventHandler((IEventAware)this._eventCascade, (IEventSource)child);
/*     */       }
/*     */     } 
/*     */   }
/*     */   
/*     */   public void addPosTransactionLinkProperty(IPosTransactionLinkProperty argPosTransactionLinkProperty) {
/* 732 */     if (this._properties == null) {
/* 733 */       this._properties = new HistoricalList(null);
/*     */     }
/* 735 */     argPosTransactionLinkProperty.setBusinessDate(getBusinessDate());
/* 736 */     argPosTransactionLinkProperty.setLinkBusinessDate(getLinkBusinessDate());
/* 737 */     argPosTransactionLinkProperty.setLinkRetailLocationId(getLinkRetailLocationId());
/* 738 */     argPosTransactionLinkProperty.setLinkTransactionSequence(getLinkTransactionSequence());
/* 739 */     argPosTransactionLinkProperty.setLinkWorkstationId(getLinkWorkstationId());
/* 740 */     argPosTransactionLinkProperty.setOrganizationId(getOrganizationId());
/* 741 */     argPosTransactionLinkProperty.setRetailLocationId(getRetailLocationId());
/* 742 */     argPosTransactionLinkProperty.setTransactionSequence(getTransactionSequence());
/* 743 */     argPosTransactionLinkProperty.setWorkstationId(getWorkstationId());
/* 744 */     if (argPosTransactionLinkProperty instanceof IDataModelImpl) {
/* 745 */       IDataAccessObject childDao = ((IDataModelImpl)argPosTransactionLinkProperty).getDAO();
/* 746 */       if (StringUtils.isEmpty(childDao.getOriginDataSource()) && 
/* 747 */         !StringUtils.isEmpty(getDAO().getOriginDataSource())) {
/* 748 */         childDao.setOriginDataSource(getDAO().getOriginDataSource());
/*     */       }
/*     */     } 
/*     */ 
/*     */     
/* 753 */     if (postEventsForChanges()) {
/* 754 */       this._eventManager.registerEventHandler((IEventAware)this._eventCascade, (IEventSource)new EventDescriptor(argPosTransactionLinkProperty));
/*     */     }
/*     */     
/* 757 */     this._properties.add(argPosTransactionLinkProperty);
/* 758 */     if (postEventsForChanges()) {
/* 759 */       this._events.post(IPosTransactionLink.ADD_PROPERTIES, argPosTransactionLinkProperty);
/*     */     }
/*     */   }
/*     */   
/*     */   public void removePosTransactionLinkProperty(IPosTransactionLinkProperty argPosTransactionLinkProperty) {
/* 764 */     if (this._properties != null) {
/*     */       
/* 766 */       if (postEventsForChanges()) {
/* 767 */         this._eventManager.deregisterEventHandler((IEventAware)this._eventCascade, (IEventSource)new EventDescriptor(argPosTransactionLinkProperty));
/*     */       }
/* 769 */       this._properties.remove(argPosTransactionLinkProperty);
/* 770 */       if (postEventsForChanges()) {
/* 771 */         this._events.post(IPosTransactionLink.REMOVE_PROPERTIES, argPosTransactionLinkProperty);
/*     */       }
/*     */     } 
/*     */   }
/*     */   
/*     */   public void setParentTransaction(IPosTransaction argParentTransaction) {
/* 777 */     this._parentTransaction = argParentTransaction;
/*     */   }
/*     */   
/*     */   public IPosTransaction getParentTransaction() {
/* 781 */     return this._parentTransaction;
/*     */   }
/*     */ 
/*     */   
/*     */   public Object getValue(String argFieldId) {
/* 786 */     if ("LinkedTransaction".equals(argFieldId)) {
/* 787 */       return getLinkedTransaction();
/*     */     }
/* 789 */     if ("Properties".equals(argFieldId)) {
/* 790 */       return getProperties();
/*     */     }
/* 792 */     if ("PosTransactionLinkExtension".equals(argFieldId)) {
/* 793 */       return this._myExtension;
/*     */     }
/*     */     
/* 796 */     return super.getValue(argFieldId);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void setValue(String argFieldId, Object argValue) {
/* 802 */     if ("LinkedTransaction".equals(argFieldId)) {
/* 803 */       setLinkedTransaction((IPosTransaction)argValue);
/*     */     }
/* 805 */     else if ("Properties".equals(argFieldId)) {
/* 806 */       setProperties(changeToList(argValue, IPosTransactionLinkProperty.class));
/*     */     }
/* 808 */     else if ("PosTransactionLinkExtension".equals(argFieldId)) {
/* 809 */       this._myExtension = (IDataModel)argValue;
/*     */     } else {
/*     */       
/* 812 */       super.setValue(argFieldId, argValue);
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public void setDependencies(IPersistenceDefaults argPD, EventManager argEM) {
/* 818 */     this._persistenceDefaults = argPD;
/* 819 */     this._daoImpl.setPersistenceDefaults(argPD);
/* 820 */     this._eventManager = argEM;
/* 821 */     this._events = (Eventor)new ModelEventor((IDataModel)this, argEM);
/* 822 */     this._eventCascade = (EventHandler)new CascadingHandler(this);
/* 823 */     if (this._linkedTransaction != null) {
/* 824 */       ((IDataModelImpl)this._linkedTransaction).setDependencies(argPD, argEM);
/*     */     }
/* 826 */     if (this._properties != null) {
/* 827 */       for (IPosTransactionLinkProperty relationship : this._properties) {
/* 828 */         ((IDataModelImpl)relationship).setDependencies(argPD, argEM);
/*     */       }
/*     */     }
/*     */   }
/*     */   
/*     */   public IDataModel getPosTransactionLinkExt() {
/* 834 */     return this._myExtension;
/*     */   }
/*     */   
/*     */   public void setPosTransactionLinkExt(IDataModel argExt) {
/* 838 */     this._myExtension = argExt;
/*     */   }
/*     */ 
/*     */   
/*     */   public void startTransaction() {
/* 843 */     if (this._alreadyInStart) {
/*     */       return;
/*     */     }
/*     */     
/* 847 */     this._alreadyInStart = true;
/*     */ 
/*     */     
/* 850 */     super.startTransaction();
/*     */     
/* 852 */     this._linkedTransactionSavepoint = this._linkedTransaction;
/* 853 */     if (this._linkedTransaction != null) {
/* 854 */       this._linkedTransaction.startTransaction();
/*     */     }
/*     */     
/* 857 */     this._propertiesSavepoint = this._properties;
/* 858 */     if (this._properties != null) {
/* 859 */       this._propertiesSavepoint = new HistoricalList((List)this._properties);
/* 860 */       Iterator<IDataModel> it = this._properties.iterator();
/* 861 */       while (it.hasNext()) {
/* 862 */         ((IDataModel)it.next()).startTransaction();
/*     */       }
/*     */     } 
/*     */ 
/*     */     
/* 867 */     this._alreadyInStart = false;
/*     */   }
/*     */ 
/*     */   
/*     */   public void rollbackChanges() {
/* 872 */     if (isAlreadyRolledBack()) {
/*     */       return;
/*     */     }
/* 875 */     super.rollbackChanges();
/*     */     
/* 877 */     this._linkedTransaction = this._linkedTransactionSavepoint;
/* 878 */     this._linkedTransactionSavepoint = null;
/* 879 */     if (this._linkedTransaction != null) {
/* 880 */       this._linkedTransaction.rollbackChanges();
/*     */     }
/*     */     
/* 883 */     this._properties = this._propertiesSavepoint;
/* 884 */     this._propertiesSavepoint = null;
/* 885 */     if (this._properties != null) {
/* 886 */       Iterator<IDataModel> it = this._properties.iterator();
/* 887 */       while (it.hasNext()) {
/* 888 */         ((IDataModel)it.next()).rollbackChanges();
/*     */       }
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void commitTransaction() {
/* 896 */     if (this._alreadyInCommit) {
/*     */       return;
/*     */     }
/* 899 */     this._alreadyInCommit = true;
/*     */ 
/*     */     
/* 902 */     super.commitTransaction();
/*     */     
/* 904 */     this._linkedTransactionSavepoint = this._linkedTransaction;
/* 905 */     if (this._linkedTransaction != null) {
/* 906 */       this._linkedTransaction.commitTransaction();
/*     */     }
/*     */     
/* 909 */     this._propertiesSavepoint = this._properties;
/* 910 */     if (this._properties != null) {
/* 911 */       Iterator<IDataModel> it = this._properties.iterator();
/* 912 */       while (it.hasNext()) {
/* 913 */         ((IDataModel)it.next()).commitTransaction();
/*     */       }
/* 915 */       this._properties = new HistoricalList((List)this._properties);
/*     */     } 
/*     */ 
/*     */     
/* 919 */     this._alreadyInCommit = false;
/*     */   }
/*     */ 
/*     */   
/*     */   private void readObject(ObjectInputStream argStream) throws IOException, ClassNotFoundException {
/* 924 */     argStream.defaultReadObject();
/*     */   }
/*     */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\trn\impl\PosTransactionLinkModel.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */