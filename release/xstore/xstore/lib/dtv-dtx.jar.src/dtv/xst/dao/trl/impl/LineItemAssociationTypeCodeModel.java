/*     */ package dtv.xst.dao.trl.impl;
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
/*     */ import dtv.xst.dao.trl.ILineItemAssociationTypeCode;
/*     */ import dtv.xst.dao.trl.ILineItemAssociationTypeCodeProperty;
/*     */ import dtv.xst.dao.trl.LineItemAssociationTypeCodePropertyId;
/*     */ import java.io.IOException;
/*     */ import java.io.ObjectInputStream;
/*     */ import java.util.Date;
/*     */ import java.util.Iterator;
/*     */ import java.util.List;
/*     */ 
/*     */ public class LineItemAssociationTypeCodeModel extends AbstractDataModelWithPropertyImpl<ILineItemAssociationTypeCodeProperty> implements ILineItemAssociationTypeCode {
/*     */   private static final long serialVersionUID = 326133537L;
/*     */   private transient boolean _alreadyInStart = false;
/*     */   private transient boolean _alreadyInCommit = false;
/*     */   
/*     */   public String toString() {
/*  33 */     return super.toString() + " Id: " + getObjectId();
/*     */   }
/*     */   private IDataModel _myExtension; private HistoricalList<ILineItemAssociationTypeCodeProperty> _properties; private transient HistoricalList<ILineItemAssociationTypeCodeProperty> _propertiesSavepoint;
/*     */   
/*     */   public void initDAO() {
/*  38 */     setDAO((IDataAccessObject)new LineItemAssociationTypeCodeDAO());
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private LineItemAssociationTypeCodeDAO getDAO_() {
/*  46 */     return (LineItemAssociationTypeCodeDAO)this._daoImpl;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getLineItemAssociationTypeCode() {
/*  54 */     return getDAO_().getLineItemAssociationTypeCode();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setLineItemAssociationTypeCode(String argLineItemAssociationTypeCode) {
/*  62 */     if (setLineItemAssociationTypeCode_noev(argLineItemAssociationTypeCode) && 
/*  63 */       this._events != null && 
/*  64 */       postEventsForChanges()) {
/*  65 */       this._events.post(ILineItemAssociationTypeCode.SET_LINEITEMASSOCIATIONTYPECODE, argLineItemAssociationTypeCode);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setLineItemAssociationTypeCode_noev(String argLineItemAssociationTypeCode) {
/*  72 */     boolean ev_postable = false;
/*     */     
/*  74 */     if ((getDAO_().getLineItemAssociationTypeCode() == null && argLineItemAssociationTypeCode != null) || (
/*  75 */       getDAO_().getLineItemAssociationTypeCode() != null && !getDAO_().getLineItemAssociationTypeCode().equals(argLineItemAssociationTypeCode))) {
/*  76 */       getDAO_().setLineItemAssociationTypeCode(argLineItemAssociationTypeCode);
/*  77 */       ev_postable = true;
/*  78 */       if (this._properties != null) {
/*     */         
/*  80 */         Iterator<LineItemAssociationTypeCodePropertyModel> it = this._properties.iterator();
/*  81 */         while (it.hasNext())
/*     */         {
/*  83 */           ((LineItemAssociationTypeCodePropertyModel)it.next()).setLineItemAssociationTypeCode_noev(argLineItemAssociationTypeCode);
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
/* 112 */       this._events.post(ILineItemAssociationTypeCode.SET_ORGANIZATIONID, Long.valueOf(argOrganizationId));
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
/* 127 */         Iterator<LineItemAssociationTypeCodePropertyModel> it = this._properties.iterator();
/* 128 */         while (it.hasNext())
/*     */         {
/* 130 */           ((LineItemAssociationTypeCodePropertyModel)it.next()).setOrganizationId_noev(argOrganizationId);
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
/*     */   public Date getCreateDate() {
/* 143 */     return getDAO_().getCreateDate();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setCreateDate(Date argCreateDate) {
/* 151 */     if (setCreateDate_noev(argCreateDate) && 
/* 152 */       this._events != null && 
/* 153 */       postEventsForChanges()) {
/* 154 */       this._events.post(ILineItemAssociationTypeCode.SET_CREATEDATE, argCreateDate);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setCreateDate_noev(Date argCreateDate) {
/* 161 */     boolean ev_postable = false;
/*     */     
/* 163 */     if ((getDAO_().getCreateDate() == null && argCreateDate != null) || (
/* 164 */       getDAO_().getCreateDate() != null && !getDAO_().getCreateDate().equals(argCreateDate))) {
/* 165 */       getDAO_().setCreateDate(argCreateDate);
/* 166 */       ev_postable = true;
/*     */     } 
/*     */     
/* 169 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getCreateUserId() {
/* 177 */     return getDAO_().getCreateUserId();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setCreateUserId(String argCreateUserId) {
/* 185 */     if (setCreateUserId_noev(argCreateUserId) && 
/* 186 */       this._events != null && 
/* 187 */       postEventsForChanges()) {
/* 188 */       this._events.post(ILineItemAssociationTypeCode.SET_CREATEUSERID, argCreateUserId);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setCreateUserId_noev(String argCreateUserId) {
/* 195 */     boolean ev_postable = false;
/*     */     
/* 197 */     if ((getDAO_().getCreateUserId() == null && argCreateUserId != null) || (
/* 198 */       getDAO_().getCreateUserId() != null && !getDAO_().getCreateUserId().equals(argCreateUserId))) {
/* 199 */       getDAO_().setCreateUserId(argCreateUserId);
/* 200 */       ev_postable = true;
/*     */     } 
/*     */     
/* 203 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Date getUpdateDate() {
/* 211 */     return getDAO_().getUpdateDate();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setUpdateDate(Date argUpdateDate) {
/* 219 */     if (setUpdateDate_noev(argUpdateDate) && 
/* 220 */       this._events != null && 
/* 221 */       postEventsForChanges()) {
/* 222 */       this._events.post(ILineItemAssociationTypeCode.SET_UPDATEDATE, argUpdateDate);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setUpdateDate_noev(Date argUpdateDate) {
/* 229 */     boolean ev_postable = false;
/*     */     
/* 231 */     if ((getDAO_().getUpdateDate() == null && argUpdateDate != null) || (
/* 232 */       getDAO_().getUpdateDate() != null && !getDAO_().getUpdateDate().equals(argUpdateDate))) {
/* 233 */       getDAO_().setUpdateDate(argUpdateDate);
/* 234 */       ev_postable = true;
/*     */     } 
/*     */     
/* 237 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getUpdateUserId() {
/* 245 */     return getDAO_().getUpdateUserId();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setUpdateUserId(String argUpdateUserId) {
/* 253 */     if (setUpdateUserId_noev(argUpdateUserId) && 
/* 254 */       this._events != null && 
/* 255 */       postEventsForChanges()) {
/* 256 */       this._events.post(ILineItemAssociationTypeCode.SET_UPDATEUSERID, argUpdateUserId);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setUpdateUserId_noev(String argUpdateUserId) {
/* 263 */     boolean ev_postable = false;
/*     */     
/* 265 */     if ((getDAO_().getUpdateUserId() == null && argUpdateUserId != null) || (
/* 266 */       getDAO_().getUpdateUserId() != null && !getDAO_().getUpdateUserId().equals(argUpdateUserId))) {
/* 267 */       getDAO_().setUpdateUserId(argUpdateUserId);
/* 268 */       ev_postable = true;
/*     */     } 
/*     */     
/* 271 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean getCascadeDelete() {
/* 279 */     if (getDAO_().getCascadeDelete() != null) {
/* 280 */       return getDAO_().getCascadeDelete().booleanValue();
/*     */     }
/*     */     
/* 283 */     return false;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setCascadeDelete(boolean argCascadeDelete) {
/* 292 */     if (setCascadeDelete_noev(argCascadeDelete) && 
/* 293 */       this._events != null && 
/* 294 */       postEventsForChanges()) {
/* 295 */       this._events.post(ILineItemAssociationTypeCode.SET_CASCADEDELETE, Boolean.valueOf(argCascadeDelete));
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setCascadeDelete_noev(boolean argCascadeDelete) {
/* 302 */     boolean ev_postable = false;
/*     */     
/* 304 */     if ((getDAO_().getCascadeDelete() == null && Boolean.valueOf(argCascadeDelete) != null) || (
/* 305 */       getDAO_().getCascadeDelete() != null && !getDAO_().getCascadeDelete().equals(Boolean.valueOf(argCascadeDelete)))) {
/* 306 */       getDAO_().setCascadeDelete(Boolean.valueOf(argCascadeDelete));
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
/*     */   public boolean getCascadeQuantity() {
/* 318 */     if (getDAO_().getCascadeQuantity() != null) {
/* 319 */       return getDAO_().getCascadeQuantity().booleanValue();
/*     */     }
/*     */     
/* 322 */     return false;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setCascadeQuantity(boolean argCascadeQuantity) {
/* 331 */     if (setCascadeQuantity_noev(argCascadeQuantity) && 
/* 332 */       this._events != null && 
/* 333 */       postEventsForChanges()) {
/* 334 */       this._events.post(ILineItemAssociationTypeCode.SET_CASCADEQUANTITY, Boolean.valueOf(argCascadeQuantity));
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setCascadeQuantity_noev(boolean argCascadeQuantity) {
/* 341 */     boolean ev_postable = false;
/*     */     
/* 343 */     if ((getDAO_().getCascadeQuantity() == null && Boolean.valueOf(argCascadeQuantity) != null) || (
/* 344 */       getDAO_().getCascadeQuantity() != null && !getDAO_().getCascadeQuantity().equals(Boolean.valueOf(argCascadeQuantity)))) {
/* 345 */       getDAO_().setCascadeQuantity(Boolean.valueOf(argCascadeQuantity));
/* 346 */       ev_postable = true;
/*     */     } 
/*     */     
/* 349 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean getChildRestrictDelete() {
/* 357 */     if (getDAO_().getChildRestrictDelete() != null) {
/* 358 */       return getDAO_().getChildRestrictDelete().booleanValue();
/*     */     }
/*     */     
/* 361 */     return false;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setChildRestrictDelete(boolean argChildRestrictDelete) {
/* 370 */     if (setChildRestrictDelete_noev(argChildRestrictDelete) && 
/* 371 */       this._events != null && 
/* 372 */       postEventsForChanges()) {
/* 373 */       this._events.post(ILineItemAssociationTypeCode.SET_CHILDRESTRICTDELETE, Boolean.valueOf(argChildRestrictDelete));
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setChildRestrictDelete_noev(boolean argChildRestrictDelete) {
/* 380 */     boolean ev_postable = false;
/*     */     
/* 382 */     if ((getDAO_().getChildRestrictDelete() == null && Boolean.valueOf(argChildRestrictDelete) != null) || (
/* 383 */       getDAO_().getChildRestrictDelete() != null && !getDAO_().getChildRestrictDelete().equals(Boolean.valueOf(argChildRestrictDelete)))) {
/* 384 */       getDAO_().setChildRestrictDelete(Boolean.valueOf(argChildRestrictDelete));
/* 385 */       ev_postable = true;
/*     */     } 
/*     */     
/* 388 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean getChildRestrictPrice() {
/* 396 */     if (getDAO_().getChildRestrictPrice() != null) {
/* 397 */       return getDAO_().getChildRestrictPrice().booleanValue();
/*     */     }
/*     */     
/* 400 */     return false;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setChildRestrictPrice(boolean argChildRestrictPrice) {
/* 409 */     if (setChildRestrictPrice_noev(argChildRestrictPrice) && 
/* 410 */       this._events != null && 
/* 411 */       postEventsForChanges()) {
/* 412 */       this._events.post(ILineItemAssociationTypeCode.SET_CHILDRESTRICTPRICE, Boolean.valueOf(argChildRestrictPrice));
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setChildRestrictPrice_noev(boolean argChildRestrictPrice) {
/* 419 */     boolean ev_postable = false;
/*     */     
/* 421 */     if ((getDAO_().getChildRestrictPrice() == null && Boolean.valueOf(argChildRestrictPrice) != null) || (
/* 422 */       getDAO_().getChildRestrictPrice() != null && !getDAO_().getChildRestrictPrice().equals(Boolean.valueOf(argChildRestrictPrice)))) {
/* 423 */       getDAO_().setChildRestrictPrice(Boolean.valueOf(argChildRestrictPrice));
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
/*     */   public boolean getChildRestrictQuantity() {
/* 435 */     if (getDAO_().getChildRestrictQuantity() != null) {
/* 436 */       return getDAO_().getChildRestrictQuantity().booleanValue();
/*     */     }
/*     */     
/* 439 */     return false;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setChildRestrictQuantity(boolean argChildRestrictQuantity) {
/* 448 */     if (setChildRestrictQuantity_noev(argChildRestrictQuantity) && 
/* 449 */       this._events != null && 
/* 450 */       postEventsForChanges()) {
/* 451 */       this._events.post(ILineItemAssociationTypeCode.SET_CHILDRESTRICTQUANTITY, Boolean.valueOf(argChildRestrictQuantity));
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setChildRestrictQuantity_noev(boolean argChildRestrictQuantity) {
/* 458 */     boolean ev_postable = false;
/*     */     
/* 460 */     if ((getDAO_().getChildRestrictQuantity() == null && Boolean.valueOf(argChildRestrictQuantity) != null) || (
/* 461 */       getDAO_().getChildRestrictQuantity() != null && !getDAO_().getChildRestrictQuantity().equals(Boolean.valueOf(argChildRestrictQuantity)))) {
/* 462 */       getDAO_().setChildRestrictQuantity(Boolean.valueOf(argChildRestrictQuantity));
/* 463 */       ev_postable = true;
/*     */     } 
/*     */     
/* 466 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getDescription() {
/* 474 */     return getDAO_().getDescription();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setDescription(String argDescription) {
/* 482 */     if (setDescription_noev(argDescription) && 
/* 483 */       this._events != null && 
/* 484 */       postEventsForChanges()) {
/* 485 */       this._events.post(ILineItemAssociationTypeCode.SET_DESCRIPTION, argDescription);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setDescription_noev(String argDescription) {
/* 492 */     boolean ev_postable = false;
/*     */     
/* 494 */     if ((getDAO_().getDescription() == null && argDescription != null) || (
/* 495 */       getDAO_().getDescription() != null && !getDAO_().getDescription().equals(argDescription))) {
/* 496 */       getDAO_().setDescription(argDescription);
/* 497 */       ev_postable = true;
/*     */     } 
/*     */     
/* 500 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean getParentRestrictDelete() {
/* 508 */     if (getDAO_().getParentRestrictDelete() != null) {
/* 509 */       return getDAO_().getParentRestrictDelete().booleanValue();
/*     */     }
/*     */     
/* 512 */     return false;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setParentRestrictDelete(boolean argParentRestrictDelete) {
/* 521 */     if (setParentRestrictDelete_noev(argParentRestrictDelete) && 
/* 522 */       this._events != null && 
/* 523 */       postEventsForChanges()) {
/* 524 */       this._events.post(ILineItemAssociationTypeCode.SET_PARENTRESTRICTDELETE, Boolean.valueOf(argParentRestrictDelete));
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setParentRestrictDelete_noev(boolean argParentRestrictDelete) {
/* 531 */     boolean ev_postable = false;
/*     */     
/* 533 */     if ((getDAO_().getParentRestrictDelete() == null && Boolean.valueOf(argParentRestrictDelete) != null) || (
/* 534 */       getDAO_().getParentRestrictDelete() != null && !getDAO_().getParentRestrictDelete().equals(Boolean.valueOf(argParentRestrictDelete)))) {
/* 535 */       getDAO_().setParentRestrictDelete(Boolean.valueOf(argParentRestrictDelete));
/* 536 */       ev_postable = true;
/*     */     } 
/*     */     
/* 539 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean getParentRestrictPrice() {
/* 547 */     if (getDAO_().getParentRestrictPrice() != null) {
/* 548 */       return getDAO_().getParentRestrictPrice().booleanValue();
/*     */     }
/*     */     
/* 551 */     return false;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setParentRestrictPrice(boolean argParentRestrictPrice) {
/* 560 */     if (setParentRestrictPrice_noev(argParentRestrictPrice) && 
/* 561 */       this._events != null && 
/* 562 */       postEventsForChanges()) {
/* 563 */       this._events.post(ILineItemAssociationTypeCode.SET_PARENTRESTRICTPRICE, Boolean.valueOf(argParentRestrictPrice));
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setParentRestrictPrice_noev(boolean argParentRestrictPrice) {
/* 570 */     boolean ev_postable = false;
/*     */     
/* 572 */     if ((getDAO_().getParentRestrictPrice() == null && Boolean.valueOf(argParentRestrictPrice) != null) || (
/* 573 */       getDAO_().getParentRestrictPrice() != null && !getDAO_().getParentRestrictPrice().equals(Boolean.valueOf(argParentRestrictPrice)))) {
/* 574 */       getDAO_().setParentRestrictPrice(Boolean.valueOf(argParentRestrictPrice));
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
/*     */   public boolean getParentRestrictQuantity() {
/* 586 */     if (getDAO_().getParentRestrictQuantity() != null) {
/* 587 */       return getDAO_().getParentRestrictQuantity().booleanValue();
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
/*     */   public void setParentRestrictQuantity(boolean argParentRestrictQuantity) {
/* 599 */     if (setParentRestrictQuantity_noev(argParentRestrictQuantity) && 
/* 600 */       this._events != null && 
/* 601 */       postEventsForChanges()) {
/* 602 */       this._events.post(ILineItemAssociationTypeCode.SET_PARENTRESTRICTQUANTITY, Boolean.valueOf(argParentRestrictQuantity));
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setParentRestrictQuantity_noev(boolean argParentRestrictQuantity) {
/* 609 */     boolean ev_postable = false;
/*     */     
/* 611 */     if ((getDAO_().getParentRestrictQuantity() == null && Boolean.valueOf(argParentRestrictQuantity) != null) || (
/* 612 */       getDAO_().getParentRestrictQuantity() != null && !getDAO_().getParentRestrictQuantity().equals(Boolean.valueOf(argParentRestrictQuantity)))) {
/* 613 */       getDAO_().setParentRestrictQuantity(Boolean.valueOf(argParentRestrictQuantity));
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
/*     */   public int getSortOrder() {
/* 625 */     if (getDAO_().getSortOrder() != null) {
/* 626 */       return getDAO_().getSortOrder().intValue();
/*     */     }
/*     */     
/* 629 */     return 0;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setSortOrder(int argSortOrder) {
/* 638 */     if (setSortOrder_noev(argSortOrder) && 
/* 639 */       this._events != null && 
/* 640 */       postEventsForChanges()) {
/* 641 */       this._events.post(ILineItemAssociationTypeCode.SET_SORTORDER, Integer.valueOf(argSortOrder));
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setSortOrder_noev(int argSortOrder) {
/* 648 */     boolean ev_postable = false;
/*     */     
/* 650 */     if ((getDAO_().getSortOrder() == null && Integer.valueOf(argSortOrder) != null) || (
/* 651 */       getDAO_().getSortOrder() != null && !getDAO_().getSortOrder().equals(Integer.valueOf(argSortOrder)))) {
/* 652 */       getDAO_().setSortOrder(Integer.valueOf(argSortOrder));
/* 653 */       ev_postable = true;
/*     */     } 
/*     */     
/* 656 */     return ev_postable;
/*     */   }
/*     */   
/*     */   protected ILineItemAssociationTypeCodeProperty newProperty(String argPropertyName) {
/* 660 */     LineItemAssociationTypeCodePropertyId id = new LineItemAssociationTypeCodePropertyId();
/*     */     
/* 662 */     id.setLineItemAssociationTypeCode(getLineItemAssociationTypeCode());
/* 663 */     id.setPropertyCode(argPropertyName);
/*     */     
/* 665 */     ILineItemAssociationTypeCodeProperty prop = (ILineItemAssociationTypeCodeProperty)DataFactory.getInstance().createNewObject((IObjectId)id, ILineItemAssociationTypeCodeProperty.class);
/* 666 */     return prop;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @Relationship(name = "Properties")
/*     */   public List<ILineItemAssociationTypeCodeProperty> getProperties() {
/* 675 */     if (this._properties == null) {
/* 676 */       this._properties = new HistoricalList(null);
/*     */     }
/* 678 */     return (List<ILineItemAssociationTypeCodeProperty>)this._properties;
/*     */   }
/*     */   
/*     */   public void setProperties(List<ILineItemAssociationTypeCodeProperty> argProperties) {
/* 682 */     if (this._properties == null) {
/* 683 */       this._properties = new HistoricalList(argProperties);
/*     */     } else {
/* 685 */       this._properties.setCurrentList(argProperties);
/*     */     } 
/*     */     
/* 688 */     for (ILineItemAssociationTypeCodeProperty child : this._properties) {
/* 689 */       LineItemAssociationTypeCodePropertyModel model = (LineItemAssociationTypeCodePropertyModel)child;
/* 690 */       model.setLineItemAssociationTypeCode_noev(getLineItemAssociationTypeCode());
/* 691 */       model.setOrganizationId_noev(getOrganizationId());
/* 692 */       if (child instanceof IDataModelImpl) {
/* 693 */         IDataAccessObject childDao = ((IDataModelImpl)child).getDAO();
/* 694 */         if (StringUtils.isEmpty(childDao.getOriginDataSource()) && 
/* 695 */           !StringUtils.isEmpty(getDAO().getOriginDataSource())) {
/* 696 */           childDao.setOriginDataSource(getDAO().getOriginDataSource());
/*     */         }
/*     */       } 
/* 699 */       if (postEventsForChanges()) {
/* 700 */         this._eventManager.registerEventHandler((IEventAware)this._eventCascade, (IEventSource)child);
/*     */       }
/*     */     } 
/*     */   }
/*     */   
/*     */   public void addLineItemAssociationTypeCodeProperty(ILineItemAssociationTypeCodeProperty argLineItemAssociationTypeCodeProperty) {
/* 706 */     if (this._properties == null) {
/* 707 */       this._properties = new HistoricalList(null);
/*     */     }
/* 709 */     argLineItemAssociationTypeCodeProperty.setLineItemAssociationTypeCode(getLineItemAssociationTypeCode());
/* 710 */     argLineItemAssociationTypeCodeProperty.setOrganizationId(getOrganizationId());
/* 711 */     if (argLineItemAssociationTypeCodeProperty instanceof IDataModelImpl) {
/* 712 */       IDataAccessObject childDao = ((IDataModelImpl)argLineItemAssociationTypeCodeProperty).getDAO();
/* 713 */       if (StringUtils.isEmpty(childDao.getOriginDataSource()) && 
/* 714 */         !StringUtils.isEmpty(getDAO().getOriginDataSource())) {
/* 715 */         childDao.setOriginDataSource(getDAO().getOriginDataSource());
/*     */       }
/*     */     } 
/*     */ 
/*     */     
/* 720 */     if (postEventsForChanges()) {
/* 721 */       this._eventManager.registerEventHandler((IEventAware)this._eventCascade, (IEventSource)new EventDescriptor(argLineItemAssociationTypeCodeProperty));
/*     */     }
/*     */     
/* 724 */     this._properties.add(argLineItemAssociationTypeCodeProperty);
/* 725 */     if (postEventsForChanges()) {
/* 726 */       this._events.post(ILineItemAssociationTypeCode.ADD_PROPERTIES, argLineItemAssociationTypeCodeProperty);
/*     */     }
/*     */   }
/*     */   
/*     */   public void removeLineItemAssociationTypeCodeProperty(ILineItemAssociationTypeCodeProperty argLineItemAssociationTypeCodeProperty) {
/* 731 */     if (this._properties != null) {
/*     */       
/* 733 */       if (postEventsForChanges()) {
/* 734 */         this._eventManager.deregisterEventHandler((IEventAware)this._eventCascade, (IEventSource)new EventDescriptor(argLineItemAssociationTypeCodeProperty));
/*     */       }
/* 736 */       this._properties.remove(argLineItemAssociationTypeCodeProperty);
/* 737 */       if (postEventsForChanges()) {
/* 738 */         this._events.post(ILineItemAssociationTypeCode.REMOVE_PROPERTIES, argLineItemAssociationTypeCodeProperty);
/*     */       }
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public Object getValue(String argFieldId) {
/* 745 */     if ("Properties".equals(argFieldId)) {
/* 746 */       return getProperties();
/*     */     }
/* 748 */     if ("LineItemAssociationTypeCodeExtension".equals(argFieldId)) {
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
/* 759 */       setProperties(changeToList(argValue, ILineItemAssociationTypeCodeProperty.class));
/*     */     }
/* 761 */     else if ("LineItemAssociationTypeCodeExtension".equals(argFieldId)) {
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
/* 777 */       for (ILineItemAssociationTypeCodeProperty relationship : this._properties) {
/* 778 */         ((IDataModelImpl)relationship).setDependencies(argPD, argEM);
/*     */       }
/*     */     }
/*     */   }
/*     */   
/*     */   public IDataModel getLineItemAssociationTypeCodeExt() {
/* 784 */     return this._myExtension;
/*     */   }
/*     */   
/*     */   public void setLineItemAssociationTypeCodeExt(IDataModel argExt) {
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getCode() {
/* 871 */     return getLineItemAssociationTypeCode();
/*     */   }
/*     */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\trl\impl\LineItemAssociationTypeCodeModel.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */