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
/*     */ import dtv.xst.dao.com.IReasonCode;
/*     */ import dtv.xst.dao.com.IReasonCodeProperty;
/*     */ import dtv.xst.dao.com.ReasonCodePropertyId;
/*     */ import java.io.IOException;
/*     */ import java.io.ObjectInputStream;
/*     */ import java.math.BigDecimal;
/*     */ import java.util.Date;
/*     */ import java.util.Iterator;
/*     */ import java.util.List;
/*     */ 
/*     */ public class ReasonCodeModel extends AbstractDataModelWithPropertyImpl<IReasonCodeProperty> implements IReasonCode {
/*     */   private static final long serialVersionUID = -1579364751L;
/*     */   private transient boolean _alreadyInStart = false;
/*     */   private transient boolean _alreadyInCommit = false;
/*     */   
/*     */   public String toString() {
/*  33 */     return super.toString() + " Id: " + getObjectId();
/*     */   }
/*     */   private IDataModel _myExtension; private HistoricalList<IReasonCodeProperty> _properties; private transient HistoricalList<IReasonCodeProperty> _propertiesSavepoint;
/*     */   
/*     */   public void initDAO() {
/*  38 */     setDAO((IDataAccessObject)new ReasonCodeDAO());
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private ReasonCodeDAO getDAO_() {
/*  46 */     return (ReasonCodeDAO)this._daoImpl;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public long getOrganizationId() {
/*  54 */     if (getDAO_().getOrganizationId() != null) {
/*  55 */       return getDAO_().getOrganizationId().longValue();
/*     */     }
/*     */     
/*  58 */     return 0L;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setOrganizationId(long argOrganizationId) {
/*  67 */     if (setOrganizationId_noev(argOrganizationId) && 
/*  68 */       this._events != null && 
/*  69 */       postEventsForChanges()) {
/*  70 */       this._events.post(IReasonCode.SET_ORGANIZATIONID, Long.valueOf(argOrganizationId));
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setOrganizationId_noev(long argOrganizationId) {
/*  77 */     boolean ev_postable = false;
/*     */     
/*  79 */     if ((getDAO_().getOrganizationId() == null && Long.valueOf(argOrganizationId) != null) || (
/*  80 */       getDAO_().getOrganizationId() != null && !getDAO_().getOrganizationId().equals(Long.valueOf(argOrganizationId)))) {
/*  81 */       getDAO_().setOrganizationId(Long.valueOf(argOrganizationId));
/*  82 */       ev_postable = true;
/*  83 */       if (this._properties != null) {
/*     */         
/*  85 */         Iterator<ReasonCodePropertyModel> it = this._properties.iterator();
/*  86 */         while (it.hasNext())
/*     */         {
/*  88 */           ((ReasonCodePropertyModel)it.next()).setOrganizationId_noev(argOrganizationId);
/*     */         }
/*     */       } 
/*     */     } 
/*     */     
/*  93 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getReasonTypeCode() {
/* 101 */     return getDAO_().getReasonTypeCode();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setReasonTypeCode(String argReasonTypeCode) {
/* 109 */     if (setReasonTypeCode_noev(argReasonTypeCode) && 
/* 110 */       this._events != null && 
/* 111 */       postEventsForChanges()) {
/* 112 */       this._events.post(IReasonCode.SET_REASONTYPECODE, argReasonTypeCode);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setReasonTypeCode_noev(String argReasonTypeCode) {
/* 119 */     boolean ev_postable = false;
/*     */     
/* 121 */     if ((getDAO_().getReasonTypeCode() == null && argReasonTypeCode != null) || (
/* 122 */       getDAO_().getReasonTypeCode() != null && !getDAO_().getReasonTypeCode().equals(argReasonTypeCode))) {
/* 123 */       getDAO_().setReasonTypeCode(argReasonTypeCode);
/* 124 */       ev_postable = true;
/* 125 */       if (this._properties != null) {
/*     */         
/* 127 */         Iterator<ReasonCodePropertyModel> it = this._properties.iterator();
/* 128 */         while (it.hasNext())
/*     */         {
/* 130 */           ((ReasonCodePropertyModel)it.next()).setReasonTypeCode_noev(argReasonTypeCode);
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
/*     */   public String getReasonCode() {
/* 143 */     return getDAO_().getReasonCode();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setReasonCode(String argReasonCode) {
/* 151 */     if (setReasonCode_noev(argReasonCode) && 
/* 152 */       this._events != null && 
/* 153 */       postEventsForChanges()) {
/* 154 */       this._events.post(IReasonCode.SET_REASONCODE, argReasonCode);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setReasonCode_noev(String argReasonCode) {
/* 161 */     boolean ev_postable = false;
/*     */     
/* 163 */     if ((getDAO_().getReasonCode() == null && argReasonCode != null) || (
/* 164 */       getDAO_().getReasonCode() != null && !getDAO_().getReasonCode().equals(argReasonCode))) {
/* 165 */       getDAO_().setReasonCode(argReasonCode);
/* 166 */       ev_postable = true;
/* 167 */       if (this._properties != null) {
/*     */         
/* 169 */         Iterator<ReasonCodePropertyModel> it = this._properties.iterator();
/* 170 */         while (it.hasNext())
/*     */         {
/* 172 */           ((ReasonCodePropertyModel)it.next()).setReasonCode_noev(argReasonCode);
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
/* 196 */       this._events.post(IReasonCode.SET_CREATEDATE, argCreateDate);
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
/* 230 */       this._events.post(IReasonCode.SET_CREATEUSERID, argCreateUserId);
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
/* 264 */       this._events.post(IReasonCode.SET_UPDATEDATE, argUpdateDate);
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
/* 298 */       this._events.post(IReasonCode.SET_UPDATEUSERID, argUpdateUserId);
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
/*     */   public String getConfigElement() {
/* 321 */     return getDAO_().getConfigElement();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setConfigElement(String argConfigElement) {
/* 329 */     if (setConfigElement_noev(argConfigElement) && 
/* 330 */       this._events != null && 
/* 331 */       postEventsForChanges()) {
/* 332 */       this._events.post(IReasonCode.SET_CONFIGELEMENT, argConfigElement);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setConfigElement_noev(String argConfigElement) {
/* 339 */     boolean ev_postable = false;
/*     */     
/* 341 */     if ((getDAO_().getConfigElement() == null && argConfigElement != null) || (
/* 342 */       getDAO_().getConfigElement() != null && !getDAO_().getConfigElement().equals(argConfigElement))) {
/* 343 */       getDAO_().setConfigElement(argConfigElement);
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
/*     */   public String getDescription() {
/* 355 */     return getDAO_().getDescription();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setDescription(String argDescription) {
/* 363 */     if (setDescription_noev(argDescription) && 
/* 364 */       this._events != null && 
/* 365 */       postEventsForChanges()) {
/* 366 */       this._events.post(IReasonCode.SET_DESCRIPTION, argDescription);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setDescription_noev(String argDescription) {
/* 373 */     boolean ev_postable = false;
/*     */     
/* 375 */     if ((getDAO_().getDescription() == null && argDescription != null) || (
/* 376 */       getDAO_().getDescription() != null && !getDAO_().getDescription().equals(argDescription))) {
/* 377 */       getDAO_().setDescription(argDescription);
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
/*     */   public String getCommentRequired() {
/* 389 */     return getDAO_().getCommentRequired();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setCommentRequired(String argCommentRequired) {
/* 397 */     if (setCommentRequired_noev(argCommentRequired) && 
/* 398 */       this._events != null && 
/* 399 */       postEventsForChanges()) {
/* 400 */       this._events.post(IReasonCode.SET_COMMENTREQUIRED, argCommentRequired);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setCommentRequired_noev(String argCommentRequired) {
/* 407 */     boolean ev_postable = false;
/*     */     
/* 409 */     if ((getDAO_().getCommentRequired() == null && argCommentRequired != null) || (
/* 410 */       getDAO_().getCommentRequired() != null && !getDAO_().getCommentRequired().equals(argCommentRequired))) {
/* 411 */       getDAO_().setCommentRequired(argCommentRequired);
/* 412 */       ev_postable = true;
/*     */     } 
/*     */     
/* 415 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int getSortOrder() {
/* 423 */     if (getDAO_().getSortOrder() != null) {
/* 424 */       return getDAO_().getSortOrder().intValue();
/*     */     }
/*     */     
/* 427 */     return 0;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setSortOrder(int argSortOrder) {
/* 436 */     if (setSortOrder_noev(argSortOrder) && 
/* 437 */       this._events != null && 
/* 438 */       postEventsForChanges()) {
/* 439 */       this._events.post(IReasonCode.SET_SORTORDER, Integer.valueOf(argSortOrder));
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setSortOrder_noev(int argSortOrder) {
/* 446 */     boolean ev_postable = false;
/*     */     
/* 448 */     if ((getDAO_().getSortOrder() == null && Integer.valueOf(argSortOrder) != null) || (
/* 449 */       getDAO_().getSortOrder() != null && !getDAO_().getSortOrder().equals(Integer.valueOf(argSortOrder)))) {
/* 450 */       getDAO_().setSortOrder(Integer.valueOf(argSortOrder));
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
/*     */   public String getParentCode() {
/* 462 */     return getDAO_().getParentCode();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setParentCode(String argParentCode) {
/* 470 */     if (setParentCode_noev(argParentCode) && 
/* 471 */       this._events != null && 
/* 472 */       postEventsForChanges()) {
/* 473 */       this._events.post(IReasonCode.SET_PARENTCODE, argParentCode);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setParentCode_noev(String argParentCode) {
/* 480 */     boolean ev_postable = false;
/*     */     
/* 482 */     if ((getDAO_().getParentCode() == null && argParentCode != null) || (
/* 483 */       getDAO_().getParentCode() != null && !getDAO_().getParentCode().equals(argParentCode))) {
/* 484 */       getDAO_().setParentCode(argParentCode);
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
/*     */   public String getGlAccountNumber() {
/* 496 */     return getDAO_().getGlAccountNumber();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setGlAccountNumber(String argGlAccountNumber) {
/* 504 */     if (setGlAccountNumber_noev(argGlAccountNumber) && 
/* 505 */       this._events != null && 
/* 506 */       postEventsForChanges()) {
/* 507 */       this._events.post(IReasonCode.SET_GLACCOUNTNUMBER, argGlAccountNumber);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setGlAccountNumber_noev(String argGlAccountNumber) {
/* 514 */     boolean ev_postable = false;
/*     */     
/* 516 */     if ((getDAO_().getGlAccountNumber() == null && argGlAccountNumber != null) || (
/* 517 */       getDAO_().getGlAccountNumber() != null && !getDAO_().getGlAccountNumber().equals(argGlAccountNumber))) {
/* 518 */       getDAO_().setGlAccountNumber(argGlAccountNumber);
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
/*     */   public BigDecimal getMinimumAmt() {
/* 530 */     return getDAO_().getMinimumAmt();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setMinimumAmt(BigDecimal argMinimumAmt) {
/* 538 */     if (setMinimumAmt_noev(argMinimumAmt) && 
/* 539 */       this._events != null && 
/* 540 */       postEventsForChanges()) {
/* 541 */       this._events.post(IReasonCode.SET_MINIMUMAMT, argMinimumAmt);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setMinimumAmt_noev(BigDecimal argMinimumAmt) {
/* 548 */     boolean ev_postable = false;
/*     */     
/* 550 */     if ((getDAO_().getMinimumAmt() == null && argMinimumAmt != null) || (
/* 551 */       getDAO_().getMinimumAmt() != null && !getDAO_().getMinimumAmt().equals(argMinimumAmt))) {
/* 552 */       getDAO_().setMinimumAmt(argMinimumAmt);
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
/*     */   public BigDecimal getMaximumAmt() {
/* 564 */     return getDAO_().getMaximumAmt();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setMaximumAmt(BigDecimal argMaximumAmt) {
/* 572 */     if (setMaximumAmt_noev(argMaximumAmt) && 
/* 573 */       this._events != null && 
/* 574 */       postEventsForChanges()) {
/* 575 */       this._events.post(IReasonCode.SET_MAXIMUMAMT, argMaximumAmt);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setMaximumAmt_noev(BigDecimal argMaximumAmt) {
/* 582 */     boolean ev_postable = false;
/*     */     
/* 584 */     if ((getDAO_().getMaximumAmt() == null && argMaximumAmt != null) || (
/* 585 */       getDAO_().getMaximumAmt() != null && !getDAO_().getMaximumAmt().equals(argMaximumAmt))) {
/* 586 */       getDAO_().setMaximumAmt(argMaximumAmt);
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
/*     */   public String getCustomerMessage() {
/* 598 */     return getDAO_().getCustomerMessage();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setCustomerMessage(String argCustomerMessage) {
/* 606 */     if (setCustomerMessage_noev(argCustomerMessage) && 
/* 607 */       this._events != null && 
/* 608 */       postEventsForChanges()) {
/* 609 */       this._events.post(IReasonCode.SET_CUSTOMERMESSAGE, argCustomerMessage);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setCustomerMessage_noev(String argCustomerMessage) {
/* 616 */     boolean ev_postable = false;
/*     */     
/* 618 */     if ((getDAO_().getCustomerMessage() == null && argCustomerMessage != null) || (
/* 619 */       getDAO_().getCustomerMessage() != null && !getDAO_().getCustomerMessage().equals(argCustomerMessage))) {
/* 620 */       getDAO_().setCustomerMessage(argCustomerMessage);
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
/*     */   public String getInventoryActionCode() {
/* 632 */     return getDAO_().getInventoryActionCode();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setInventoryActionCode(String argInventoryActionCode) {
/* 640 */     if (setInventoryActionCode_noev(argInventoryActionCode) && 
/* 641 */       this._events != null && 
/* 642 */       postEventsForChanges()) {
/* 643 */       this._events.post(IReasonCode.SET_INVENTORYACTIONCODE, argInventoryActionCode);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setInventoryActionCode_noev(String argInventoryActionCode) {
/* 650 */     boolean ev_postable = false;
/*     */     
/* 652 */     if ((getDAO_().getInventoryActionCode() == null && argInventoryActionCode != null) || (
/* 653 */       getDAO_().getInventoryActionCode() != null && !getDAO_().getInventoryActionCode().equals(argInventoryActionCode))) {
/* 654 */       getDAO_().setInventoryActionCode(argInventoryActionCode);
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
/*     */   public String getInventoryLocationId() {
/* 666 */     return getDAO_().getInventoryLocationId();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setInventoryLocationId(String argInventoryLocationId) {
/* 674 */     if (setInventoryLocationId_noev(argInventoryLocationId) && 
/* 675 */       this._events != null && 
/* 676 */       postEventsForChanges()) {
/* 677 */       this._events.post(IReasonCode.SET_INVENTORYLOCATIONID, argInventoryLocationId);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setInventoryLocationId_noev(String argInventoryLocationId) {
/* 684 */     boolean ev_postable = false;
/*     */     
/* 686 */     if ((getDAO_().getInventoryLocationId() == null && argInventoryLocationId != null) || (
/* 687 */       getDAO_().getInventoryLocationId() != null && !getDAO_().getInventoryLocationId().equals(argInventoryLocationId))) {
/* 688 */       getDAO_().setInventoryLocationId(argInventoryLocationId);
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
/*     */   public String getInventoryBucketId() {
/* 700 */     return getDAO_().getInventoryBucketId();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setInventoryBucketId(String argInventoryBucketId) {
/* 708 */     if (setInventoryBucketId_noev(argInventoryBucketId) && 
/* 709 */       this._events != null && 
/* 710 */       postEventsForChanges()) {
/* 711 */       this._events.post(IReasonCode.SET_INVENTORYBUCKETID, argInventoryBucketId);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setInventoryBucketId_noev(String argInventoryBucketId) {
/* 718 */     boolean ev_postable = false;
/*     */     
/* 720 */     if ((getDAO_().getInventoryBucketId() == null && argInventoryBucketId != null) || (
/* 721 */       getDAO_().getInventoryBucketId() != null && !getDAO_().getInventoryBucketId().equals(argInventoryBucketId))) {
/* 722 */       getDAO_().setInventoryBucketId(argInventoryBucketId);
/* 723 */       ev_postable = true;
/*     */     } 
/*     */     
/* 726 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean getHidden() {
/* 734 */     if (getDAO_().getHidden() != null) {
/* 735 */       return getDAO_().getHidden().booleanValue();
/*     */     }
/*     */     
/* 738 */     return false;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setHidden(boolean argHidden) {
/* 747 */     if (setHidden_noev(argHidden) && 
/* 748 */       this._events != null && 
/* 749 */       postEventsForChanges()) {
/* 750 */       this._events.post(IReasonCode.SET_HIDDEN, Boolean.valueOf(argHidden));
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setHidden_noev(boolean argHidden) {
/* 757 */     boolean ev_postable = false;
/*     */     
/* 759 */     if ((getDAO_().getHidden() == null && Boolean.valueOf(argHidden) != null) || (
/* 760 */       getDAO_().getHidden() != null && !getDAO_().getHidden().equals(Boolean.valueOf(argHidden)))) {
/* 761 */       getDAO_().setHidden(Boolean.valueOf(argHidden));
/* 762 */       ev_postable = true;
/*     */     } 
/*     */     
/* 765 */     return ev_postable;
/*     */   }
/*     */   
/*     */   protected IReasonCodeProperty newProperty(String argPropertyName) {
/* 769 */     ReasonCodePropertyId id = new ReasonCodePropertyId();
/*     */     
/* 771 */     id.setReasonTypeCode(getReasonTypeCode());
/* 772 */     id.setReasonCode(getReasonCode());
/* 773 */     id.setPropertyCode(argPropertyName);
/*     */     
/* 775 */     IReasonCodeProperty prop = (IReasonCodeProperty)DataFactory.getInstance().createNewObject((IObjectId)id, IReasonCodeProperty.class);
/* 776 */     return prop;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @Relationship(name = "Properties")
/*     */   public List<IReasonCodeProperty> getProperties() {
/* 785 */     if (this._properties == null) {
/* 786 */       this._properties = new HistoricalList(null);
/*     */     }
/* 788 */     return (List<IReasonCodeProperty>)this._properties;
/*     */   }
/*     */   
/*     */   public void setProperties(List<IReasonCodeProperty> argProperties) {
/* 792 */     if (this._properties == null) {
/* 793 */       this._properties = new HistoricalList(argProperties);
/*     */     } else {
/* 795 */       this._properties.setCurrentList(argProperties);
/*     */     } 
/*     */     
/* 798 */     for (IReasonCodeProperty child : this._properties) {
/* 799 */       ReasonCodePropertyModel model = (ReasonCodePropertyModel)child;
/* 800 */       model.setOrganizationId_noev(getOrganizationId());
/* 801 */       model.setReasonTypeCode_noev(getReasonTypeCode());
/* 802 */       model.setReasonCode_noev(getReasonCode());
/* 803 */       if (child instanceof IDataModelImpl) {
/* 804 */         IDataAccessObject childDao = ((IDataModelImpl)child).getDAO();
/* 805 */         if (StringUtils.isEmpty(childDao.getOriginDataSource()) && 
/* 806 */           !StringUtils.isEmpty(getDAO().getOriginDataSource())) {
/* 807 */           childDao.setOriginDataSource(getDAO().getOriginDataSource());
/*     */         }
/*     */       } 
/* 810 */       if (postEventsForChanges()) {
/* 811 */         this._eventManager.registerEventHandler((IEventAware)this._eventCascade, (IEventSource)child);
/*     */       }
/*     */     } 
/*     */   }
/*     */   
/*     */   public void addReasonCodeProperty(IReasonCodeProperty argReasonCodeProperty) {
/* 817 */     if (this._properties == null) {
/* 818 */       this._properties = new HistoricalList(null);
/*     */     }
/* 820 */     argReasonCodeProperty.setOrganizationId(getOrganizationId());
/* 821 */     argReasonCodeProperty.setReasonTypeCode(getReasonTypeCode());
/* 822 */     argReasonCodeProperty.setReasonCode(getReasonCode());
/* 823 */     if (argReasonCodeProperty instanceof IDataModelImpl) {
/* 824 */       IDataAccessObject childDao = ((IDataModelImpl)argReasonCodeProperty).getDAO();
/* 825 */       if (StringUtils.isEmpty(childDao.getOriginDataSource()) && 
/* 826 */         !StringUtils.isEmpty(getDAO().getOriginDataSource())) {
/* 827 */         childDao.setOriginDataSource(getDAO().getOriginDataSource());
/*     */       }
/*     */     } 
/*     */ 
/*     */     
/* 832 */     if (postEventsForChanges()) {
/* 833 */       this._eventManager.registerEventHandler((IEventAware)this._eventCascade, (IEventSource)new EventDescriptor(argReasonCodeProperty));
/*     */     }
/*     */     
/* 836 */     this._properties.add(argReasonCodeProperty);
/* 837 */     if (postEventsForChanges()) {
/* 838 */       this._events.post(IReasonCode.ADD_PROPERTIES, argReasonCodeProperty);
/*     */     }
/*     */   }
/*     */   
/*     */   public void removeReasonCodeProperty(IReasonCodeProperty argReasonCodeProperty) {
/* 843 */     if (this._properties != null) {
/*     */       
/* 845 */       if (postEventsForChanges()) {
/* 846 */         this._eventManager.deregisterEventHandler((IEventAware)this._eventCascade, (IEventSource)new EventDescriptor(argReasonCodeProperty));
/*     */       }
/* 848 */       this._properties.remove(argReasonCodeProperty);
/* 849 */       if (postEventsForChanges()) {
/* 850 */         this._events.post(IReasonCode.REMOVE_PROPERTIES, argReasonCodeProperty);
/*     */       }
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public Object getValue(String argFieldId) {
/* 857 */     if ("Properties".equals(argFieldId)) {
/* 858 */       return getProperties();
/*     */     }
/* 860 */     if ("ReasonCodeExtension".equals(argFieldId)) {
/* 861 */       return this._myExtension;
/*     */     }
/*     */     
/* 864 */     return super.getValue(argFieldId);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void setValue(String argFieldId, Object argValue) {
/* 870 */     if ("Properties".equals(argFieldId)) {
/* 871 */       setProperties(changeToList(argValue, IReasonCodeProperty.class));
/*     */     }
/* 873 */     else if ("ReasonCodeExtension".equals(argFieldId)) {
/* 874 */       this._myExtension = (IDataModel)argValue;
/*     */     } else {
/*     */       
/* 877 */       super.setValue(argFieldId, argValue);
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public void setDependencies(IPersistenceDefaults argPD, EventManager argEM) {
/* 883 */     this._persistenceDefaults = argPD;
/* 884 */     this._daoImpl.setPersistenceDefaults(argPD);
/* 885 */     this._eventManager = argEM;
/* 886 */     this._events = (Eventor)new ModelEventor((IDataModel)this, argEM);
/* 887 */     this._eventCascade = (EventHandler)new CascadingHandler(this);
/* 888 */     if (this._properties != null) {
/* 889 */       for (IReasonCodeProperty relationship : this._properties) {
/* 890 */         ((IDataModelImpl)relationship).setDependencies(argPD, argEM);
/*     */       }
/*     */     }
/*     */   }
/*     */   
/*     */   public IDataModel getReasonCodeExt() {
/* 896 */     return this._myExtension;
/*     */   }
/*     */   
/*     */   public void setReasonCodeExt(IDataModel argExt) {
/* 900 */     this._myExtension = argExt;
/*     */   }
/*     */ 
/*     */   
/*     */   public void startTransaction() {
/* 905 */     if (this._alreadyInStart) {
/*     */       return;
/*     */     }
/*     */     
/* 909 */     this._alreadyInStart = true;
/*     */ 
/*     */     
/* 912 */     super.startTransaction();
/*     */     
/* 914 */     this._propertiesSavepoint = this._properties;
/* 915 */     if (this._properties != null) {
/* 916 */       this._propertiesSavepoint = new HistoricalList((List)this._properties);
/* 917 */       Iterator<IDataModel> it = this._properties.iterator();
/* 918 */       while (it.hasNext()) {
/* 919 */         ((IDataModel)it.next()).startTransaction();
/*     */       }
/*     */     } 
/*     */ 
/*     */     
/* 924 */     this._alreadyInStart = false;
/*     */   }
/*     */ 
/*     */   
/*     */   public void rollbackChanges() {
/* 929 */     if (isAlreadyRolledBack()) {
/*     */       return;
/*     */     }
/* 932 */     super.rollbackChanges();
/*     */     
/* 934 */     this._properties = this._propertiesSavepoint;
/* 935 */     this._propertiesSavepoint = null;
/* 936 */     if (this._properties != null) {
/* 937 */       Iterator<IDataModel> it = this._properties.iterator();
/* 938 */       while (it.hasNext()) {
/* 939 */         ((IDataModel)it.next()).rollbackChanges();
/*     */       }
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void commitTransaction() {
/* 947 */     if (this._alreadyInCommit) {
/*     */       return;
/*     */     }
/* 950 */     this._alreadyInCommit = true;
/*     */ 
/*     */     
/* 953 */     super.commitTransaction();
/*     */     
/* 955 */     this._propertiesSavepoint = this._properties;
/* 956 */     if (this._properties != null) {
/* 957 */       Iterator<IDataModel> it = this._properties.iterator();
/* 958 */       while (it.hasNext()) {
/* 959 */         ((IDataModel)it.next()).commitTransaction();
/*     */       }
/* 961 */       this._properties = new HistoricalList((List)this._properties);
/*     */     } 
/*     */ 
/*     */     
/* 965 */     this._alreadyInCommit = false;
/*     */   }
/*     */ 
/*     */   
/*     */   private void readObject(ObjectInputStream argStream) throws IOException, ClassNotFoundException {
/* 970 */     argStream.defaultReadObject();
/*     */   }
/*     */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\com\impl\ReasonCodeModel.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */