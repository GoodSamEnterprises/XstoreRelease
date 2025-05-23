/*      */ package dtv.xst.dao.itm.impl;
/*      */ import dtv.data2.IPersistenceDefaults;
/*      */ import dtv.data2.access.IDataAccessObject;
/*      */ import dtv.data2.access.IDataModel;
/*      */ import dtv.data2.access.IDataProperty;
/*      */ import dtv.data2.access.IObjectId;
/*      */ import dtv.data2.access.ModelEventor;
/*      */ import dtv.data2.access.exception.DtxException;
/*      */ import dtv.data2.access.impl.IDataModelImpl;
/*      */ import dtv.data2.access.impl.Relationship;
/*      */ import dtv.event.EventDescriptor;
/*      */ import dtv.event.EventManager;
/*      */ import dtv.event.Eventor;
/*      */ import dtv.event.IEventAware;
/*      */ import dtv.event.IEventSource;
/*      */ import dtv.util.HistoricalList;
/*      */ import dtv.util.StringUtils;
/*      */ import dtv.xst.dao.itm.AttachedItemsPropertyId;
/*      */ import dtv.xst.dao.itm.IAttachedItems;
/*      */ import dtv.xst.dao.itm.IAttachedItemsProperty;
/*      */ import dtv.xst.dao.itm.IItem;
/*      */ import dtv.xst.dao.trl.ILineItemAssociationTypeCode;
/*      */ import java.math.BigDecimal;
/*      */ import java.util.Date;
/*      */ import java.util.Iterator;
/*      */ import java.util.List;
/*      */ 
/*      */ public class AttachedItemsModel extends AttachedItemsBaseModel implements IAttachedItems {
/*      */   private static final long serialVersionUID = 719229020L;
/*      */   private transient boolean _alreadyInStart = false;
/*      */   private transient boolean _alreadyInCommit = false;
/*      */   private IDataModel _myExtension;
/*      */   private IItem _attachedItem;
/*      */   private transient IItem _attachedItemSavepoint;
/*      */   
/*      */   public String toString() {
/*   37 */     return super.toString() + " Id: " + getObjectId();
/*      */   }
/*      */   private IItem _soldItem; private transient IItem _soldItemSavepoint; private ILineItemAssociationTypeCode _associationType; private transient ILineItemAssociationTypeCode _associationTypeSavepoint; private HistoricalList<IAttachedItemsProperty> _properties; private transient HistoricalList<IAttachedItemsProperty> _propertiesSavepoint;
/*      */   
/*      */   public void initDAO() {
/*   42 */     setDAO((IDataAccessObject)new AttachedItemsDAO());
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private AttachedItemsDAO getDAO_() {
/*   50 */     return (AttachedItemsDAO)this._daoImpl;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public String getAttachedItemId() {
/*   58 */     return getDAO_().getAttachedItemId();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setAttachedItemId(String argAttachedItemId) {
/*   66 */     if (setAttachedItemId_noev(argAttachedItemId) && 
/*   67 */       this._events != null && 
/*   68 */       postEventsForChanges()) {
/*   69 */       this._events.post(IAttachedItems.SET_ATTACHEDITEMID, argAttachedItemId);
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean setAttachedItemId_noev(String argAttachedItemId) {
/*   76 */     boolean ev_postable = false;
/*      */     
/*   78 */     if ((getDAO_().getAttachedItemId() == null && argAttachedItemId != null) || (
/*   79 */       getDAO_().getAttachedItemId() != null && !getDAO_().getAttachedItemId().equals(argAttachedItemId))) {
/*   80 */       getDAO_().setAttachedItemId(argAttachedItemId);
/*   81 */       ev_postable = true;
/*   82 */       if (this._properties != null) {
/*      */         
/*   84 */         Iterator<AttachedItemsPropertyModel> it = this._properties.iterator();
/*   85 */         while (it.hasNext())
/*      */         {
/*   87 */           ((AttachedItemsPropertyModel)it.next()).setAttachedItemId_noev(argAttachedItemId);
/*      */         }
/*      */       } 
/*      */     } 
/*      */     
/*   92 */     return ev_postable;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public long getOrganizationId() {
/*  100 */     if (getDAO_().getOrganizationId() != null) {
/*  101 */       return getDAO_().getOrganizationId().longValue();
/*      */     }
/*      */     
/*  104 */     return 0L;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setOrganizationId(long argOrganizationId) {
/*  113 */     if (setOrganizationId_noev(argOrganizationId) && 
/*  114 */       this._events != null && 
/*  115 */       postEventsForChanges()) {
/*  116 */       this._events.post(IAttachedItems.SET_ORGANIZATIONID, Long.valueOf(argOrganizationId));
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean setOrganizationId_noev(long argOrganizationId) {
/*  123 */     boolean ev_postable = false;
/*      */     
/*  125 */     if ((getDAO_().getOrganizationId() == null && Long.valueOf(argOrganizationId) != null) || (
/*  126 */       getDAO_().getOrganizationId() != null && !getDAO_().getOrganizationId().equals(Long.valueOf(argOrganizationId)))) {
/*  127 */       getDAO_().setOrganizationId(Long.valueOf(argOrganizationId));
/*  128 */       ev_postable = true;
/*  129 */       if (this._properties != null) {
/*      */         
/*  131 */         Iterator<AttachedItemsPropertyModel> it = this._properties.iterator();
/*  132 */         while (it.hasNext())
/*      */         {
/*  134 */           ((AttachedItemsPropertyModel)it.next()).setOrganizationId_noev(argOrganizationId);
/*      */         }
/*      */       } 
/*      */     } 
/*      */     
/*  139 */     return ev_postable;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public String getSoldItemId() {
/*  147 */     return getDAO_().getSoldItemId();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setSoldItemId(String argSoldItemId) {
/*  155 */     if (setSoldItemId_noev(argSoldItemId) && 
/*  156 */       this._events != null && 
/*  157 */       postEventsForChanges()) {
/*  158 */       this._events.post(IAttachedItems.SET_SOLDITEMID, argSoldItemId);
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean setSoldItemId_noev(String argSoldItemId) {
/*  165 */     boolean ev_postable = false;
/*      */     
/*  167 */     if ((getDAO_().getSoldItemId() == null && argSoldItemId != null) || (
/*  168 */       getDAO_().getSoldItemId() != null && !getDAO_().getSoldItemId().equals(argSoldItemId))) {
/*  169 */       getDAO_().setSoldItemId(argSoldItemId);
/*  170 */       ev_postable = true;
/*  171 */       if (this._properties != null) {
/*      */         
/*  173 */         Iterator<AttachedItemsPropertyModel> it = this._properties.iterator();
/*  174 */         while (it.hasNext())
/*      */         {
/*  176 */           ((AttachedItemsPropertyModel)it.next()).setSoldItemId_noev(argSoldItemId);
/*      */         }
/*      */       } 
/*      */     } 
/*      */     
/*  181 */     return ev_postable;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public String getLevelCode() {
/*  189 */     return getDAO_().getLevelCode();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setLevelCode(String argLevelCode) {
/*  197 */     if (setLevelCode_noev(argLevelCode) && 
/*  198 */       this._events != null && 
/*  199 */       postEventsForChanges()) {
/*  200 */       this._events.post(IAttachedItems.SET_LEVELCODE, argLevelCode);
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean setLevelCode_noev(String argLevelCode) {
/*  207 */     boolean ev_postable = false;
/*      */     
/*  209 */     if ((getDAO_().getLevelCode() == null && argLevelCode != null) || (
/*  210 */       getDAO_().getLevelCode() != null && !getDAO_().getLevelCode().equals(argLevelCode))) {
/*  211 */       getDAO_().setLevelCode(argLevelCode);
/*  212 */       ev_postable = true;
/*  213 */       if (this._properties != null) {
/*      */         
/*  215 */         Iterator<AttachedItemsPropertyModel> it = this._properties.iterator();
/*  216 */         while (it.hasNext())
/*      */         {
/*  218 */           ((AttachedItemsPropertyModel)it.next()).setLevelCode_noev(argLevelCode);
/*      */         }
/*      */       } 
/*      */     } 
/*      */     
/*  223 */     return ev_postable;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public String getLevelValue() {
/*  231 */     return getDAO_().getLevelValue();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setLevelValue(String argLevelValue) {
/*  239 */     if (setLevelValue_noev(argLevelValue) && 
/*  240 */       this._events != null && 
/*  241 */       postEventsForChanges()) {
/*  242 */       this._events.post(IAttachedItems.SET_LEVELVALUE, argLevelValue);
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean setLevelValue_noev(String argLevelValue) {
/*  249 */     boolean ev_postable = false;
/*      */     
/*  251 */     if ((getDAO_().getLevelValue() == null && argLevelValue != null) || (
/*  252 */       getDAO_().getLevelValue() != null && !getDAO_().getLevelValue().equals(argLevelValue))) {
/*  253 */       getDAO_().setLevelValue(argLevelValue);
/*  254 */       ev_postable = true;
/*  255 */       if (this._properties != null) {
/*      */         
/*  257 */         Iterator<AttachedItemsPropertyModel> it = this._properties.iterator();
/*  258 */         while (it.hasNext())
/*      */         {
/*  260 */           ((AttachedItemsPropertyModel)it.next()).setLevelValue_noev(argLevelValue);
/*      */         }
/*      */       } 
/*      */     } 
/*      */     
/*  265 */     return ev_postable;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public Date getCreateDate() {
/*  273 */     return getDAO_().getCreateDate();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setCreateDate(Date argCreateDate) {
/*  281 */     if (setCreateDate_noev(argCreateDate) && 
/*  282 */       this._events != null && 
/*  283 */       postEventsForChanges()) {
/*  284 */       this._events.post(IAttachedItems.SET_CREATEDATE, argCreateDate);
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean setCreateDate_noev(Date argCreateDate) {
/*  291 */     boolean ev_postable = false;
/*      */     
/*  293 */     if ((getDAO_().getCreateDate() == null && argCreateDate != null) || (
/*  294 */       getDAO_().getCreateDate() != null && !getDAO_().getCreateDate().equals(argCreateDate))) {
/*  295 */       getDAO_().setCreateDate(argCreateDate);
/*  296 */       ev_postable = true;
/*      */     } 
/*      */     
/*  299 */     return ev_postable;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public String getCreateUserId() {
/*  307 */     return getDAO_().getCreateUserId();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setCreateUserId(String argCreateUserId) {
/*  315 */     if (setCreateUserId_noev(argCreateUserId) && 
/*  316 */       this._events != null && 
/*  317 */       postEventsForChanges()) {
/*  318 */       this._events.post(IAttachedItems.SET_CREATEUSERID, argCreateUserId);
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean setCreateUserId_noev(String argCreateUserId) {
/*  325 */     boolean ev_postable = false;
/*      */     
/*  327 */     if ((getDAO_().getCreateUserId() == null && argCreateUserId != null) || (
/*  328 */       getDAO_().getCreateUserId() != null && !getDAO_().getCreateUserId().equals(argCreateUserId))) {
/*  329 */       getDAO_().setCreateUserId(argCreateUserId);
/*  330 */       ev_postable = true;
/*      */     } 
/*      */     
/*  333 */     return ev_postable;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public Date getUpdateDate() {
/*  341 */     return getDAO_().getUpdateDate();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setUpdateDate(Date argUpdateDate) {
/*  349 */     if (setUpdateDate_noev(argUpdateDate) && 
/*  350 */       this._events != null && 
/*  351 */       postEventsForChanges()) {
/*  352 */       this._events.post(IAttachedItems.SET_UPDATEDATE, argUpdateDate);
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean setUpdateDate_noev(Date argUpdateDate) {
/*  359 */     boolean ev_postable = false;
/*      */     
/*  361 */     if ((getDAO_().getUpdateDate() == null && argUpdateDate != null) || (
/*  362 */       getDAO_().getUpdateDate() != null && !getDAO_().getUpdateDate().equals(argUpdateDate))) {
/*  363 */       getDAO_().setUpdateDate(argUpdateDate);
/*  364 */       ev_postable = true;
/*      */     } 
/*      */     
/*  367 */     return ev_postable;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public String getUpdateUserId() {
/*  375 */     return getDAO_().getUpdateUserId();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setUpdateUserId(String argUpdateUserId) {
/*  383 */     if (setUpdateUserId_noev(argUpdateUserId) && 
/*  384 */       this._events != null && 
/*  385 */       postEventsForChanges()) {
/*  386 */       this._events.post(IAttachedItems.SET_UPDATEUSERID, argUpdateUserId);
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean setUpdateUserId_noev(String argUpdateUserId) {
/*  393 */     boolean ev_postable = false;
/*      */     
/*  395 */     if ((getDAO_().getUpdateUserId() == null && argUpdateUserId != null) || (
/*  396 */       getDAO_().getUpdateUserId() != null && !getDAO_().getUpdateUserId().equals(argUpdateUserId))) {
/*  397 */       getDAO_().setUpdateUserId(argUpdateUserId);
/*  398 */       ev_postable = true;
/*      */     } 
/*      */     
/*  401 */     return ev_postable;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public Date getBeginDatetime() {
/*  409 */     return getDAO_().getBeginDatetime();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setBeginDatetime(Date argBeginDatetime) {
/*  417 */     if (setBeginDatetime_noev(argBeginDatetime) && 
/*  418 */       this._events != null && 
/*  419 */       postEventsForChanges()) {
/*  420 */       this._events.post(IAttachedItems.SET_BEGINDATETIME, argBeginDatetime);
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean setBeginDatetime_noev(Date argBeginDatetime) {
/*  427 */     boolean ev_postable = false;
/*      */     
/*  429 */     if ((getDAO_().getBeginDatetime() == null && argBeginDatetime != null) || (
/*  430 */       getDAO_().getBeginDatetime() != null && !getDAO_().getBeginDatetime().equals(argBeginDatetime))) {
/*  431 */       getDAO_().setBeginDatetime(argBeginDatetime);
/*  432 */       ev_postable = true;
/*      */     } 
/*      */     
/*  435 */     return ev_postable;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public Date getEndDatetime() {
/*  443 */     return getDAO_().getEndDatetime();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setEndDatetime(Date argEndDatetime) {
/*  451 */     if (setEndDatetime_noev(argEndDatetime) && 
/*  452 */       this._events != null && 
/*  453 */       postEventsForChanges()) {
/*  454 */       this._events.post(IAttachedItems.SET_ENDDATETIME, argEndDatetime);
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean setEndDatetime_noev(Date argEndDatetime) {
/*  461 */     boolean ev_postable = false;
/*      */     
/*  463 */     if ((getDAO_().getEndDatetime() == null && argEndDatetime != null) || (
/*  464 */       getDAO_().getEndDatetime() != null && !getDAO_().getEndDatetime().equals(argEndDatetime))) {
/*  465 */       getDAO_().setEndDatetime(argEndDatetime);
/*  466 */       ev_postable = true;
/*      */     } 
/*      */     
/*  469 */     return ev_postable;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean getPromptToAdd() {
/*  477 */     if (getDAO_().getPromptToAdd() != null) {
/*  478 */       return getDAO_().getPromptToAdd().booleanValue();
/*      */     }
/*      */     
/*  481 */     return false;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setPromptToAdd(boolean argPromptToAdd) {
/*  490 */     if (setPromptToAdd_noev(argPromptToAdd) && 
/*  491 */       this._events != null && 
/*  492 */       postEventsForChanges()) {
/*  493 */       this._events.post(IAttachedItems.SET_PROMPTTOADD, Boolean.valueOf(argPromptToAdd));
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean setPromptToAdd_noev(boolean argPromptToAdd) {
/*  500 */     boolean ev_postable = false;
/*      */     
/*  502 */     if ((getDAO_().getPromptToAdd() == null && Boolean.valueOf(argPromptToAdd) != null) || (
/*  503 */       getDAO_().getPromptToAdd() != null && !getDAO_().getPromptToAdd().equals(Boolean.valueOf(argPromptToAdd)))) {
/*  504 */       getDAO_().setPromptToAdd(Boolean.valueOf(argPromptToAdd));
/*  505 */       ev_postable = true;
/*      */     } 
/*      */     
/*  508 */     return ev_postable;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public String getPromptToAddMsgKey() {
/*  516 */     return getDAO_().getPromptToAddMsgKey();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setPromptToAddMsgKey(String argPromptToAddMsgKey) {
/*  524 */     if (setPromptToAddMsgKey_noev(argPromptToAddMsgKey) && 
/*  525 */       this._events != null && 
/*  526 */       postEventsForChanges()) {
/*  527 */       this._events.post(IAttachedItems.SET_PROMPTTOADDMSGKEY, argPromptToAddMsgKey);
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean setPromptToAddMsgKey_noev(String argPromptToAddMsgKey) {
/*  534 */     boolean ev_postable = false;
/*      */     
/*  536 */     if ((getDAO_().getPromptToAddMsgKey() == null && argPromptToAddMsgKey != null) || (
/*  537 */       getDAO_().getPromptToAddMsgKey() != null && !getDAO_().getPromptToAddMsgKey().equals(argPromptToAddMsgKey))) {
/*  538 */       getDAO_().setPromptToAddMsgKey(argPromptToAddMsgKey);
/*  539 */       ev_postable = true;
/*      */     } 
/*      */     
/*  542 */     return ev_postable;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public BigDecimal getQuantityToAdd() {
/*  550 */     return getDAO_().getQuantityToAdd();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setQuantityToAdd(BigDecimal argQuantityToAdd) {
/*  558 */     if (setQuantityToAdd_noev(argQuantityToAdd) && 
/*  559 */       this._events != null && 
/*  560 */       postEventsForChanges()) {
/*  561 */       this._events.post(IAttachedItems.SET_QUANTITYTOADD, argQuantityToAdd);
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean setQuantityToAdd_noev(BigDecimal argQuantityToAdd) {
/*  568 */     boolean ev_postable = false;
/*      */     
/*  570 */     if ((getDAO_().getQuantityToAdd() == null && argQuantityToAdd != null) || (
/*  571 */       getDAO_().getQuantityToAdd() != null && !getDAO_().getQuantityToAdd().equals(argQuantityToAdd))) {
/*  572 */       getDAO_().setQuantityToAdd(argQuantityToAdd);
/*  573 */       ev_postable = true;
/*      */     } 
/*      */     
/*  576 */     return ev_postable;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public String getLineItemAssociationTypeCode() {
/*  584 */     return getDAO_().getLineItemAssociationTypeCode();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setLineItemAssociationTypeCode(String argLineItemAssociationTypeCode) {
/*  592 */     if (setLineItemAssociationTypeCode_noev(argLineItemAssociationTypeCode) && 
/*  593 */       this._events != null && 
/*  594 */       postEventsForChanges()) {
/*  595 */       this._events.post(IAttachedItems.SET_LINEITEMASSOCIATIONTYPECODE, argLineItemAssociationTypeCode);
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean setLineItemAssociationTypeCode_noev(String argLineItemAssociationTypeCode) {
/*  602 */     boolean ev_postable = false;
/*      */     
/*  604 */     if ((getDAO_().getLineItemAssociationTypeCode() == null && argLineItemAssociationTypeCode != null) || (
/*  605 */       getDAO_().getLineItemAssociationTypeCode() != null && !getDAO_().getLineItemAssociationTypeCode().equals(argLineItemAssociationTypeCode))) {
/*  606 */       getDAO_().setLineItemAssociationTypeCode(argLineItemAssociationTypeCode);
/*  607 */       ev_postable = true;
/*      */     } 
/*      */     
/*  610 */     return ev_postable;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean getPromptForReturn() {
/*  618 */     if (getDAO_().getPromptForReturn() != null) {
/*  619 */       return getDAO_().getPromptForReturn().booleanValue();
/*      */     }
/*      */     
/*  622 */     return false;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setPromptForReturn(boolean argPromptForReturn) {
/*  631 */     if (setPromptForReturn_noev(argPromptForReturn) && 
/*  632 */       this._events != null && 
/*  633 */       postEventsForChanges()) {
/*  634 */       this._events.post(IAttachedItems.SET_PROMPTFORRETURN, Boolean.valueOf(argPromptForReturn));
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean setPromptForReturn_noev(boolean argPromptForReturn) {
/*  641 */     boolean ev_postable = false;
/*      */     
/*  643 */     if ((getDAO_().getPromptForReturn() == null && Boolean.valueOf(argPromptForReturn) != null) || (
/*  644 */       getDAO_().getPromptForReturn() != null && !getDAO_().getPromptForReturn().equals(Boolean.valueOf(argPromptForReturn)))) {
/*  645 */       getDAO_().setPromptForReturn(Boolean.valueOf(argPromptForReturn));
/*  646 */       ev_postable = true;
/*      */     } 
/*      */     
/*  649 */     return ev_postable;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public String getPromptForReturnMsgKey() {
/*  657 */     return getDAO_().getPromptForReturnMsgKey();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setPromptForReturnMsgKey(String argPromptForReturnMsgKey) {
/*  665 */     if (setPromptForReturnMsgKey_noev(argPromptForReturnMsgKey) && 
/*  666 */       this._events != null && 
/*  667 */       postEventsForChanges()) {
/*  668 */       this._events.post(IAttachedItems.SET_PROMPTFORRETURNMSGKEY, argPromptForReturnMsgKey);
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean setPromptForReturnMsgKey_noev(String argPromptForReturnMsgKey) {
/*  675 */     boolean ev_postable = false;
/*      */     
/*  677 */     if ((getDAO_().getPromptForReturnMsgKey() == null && argPromptForReturnMsgKey != null) || (
/*  678 */       getDAO_().getPromptForReturnMsgKey() != null && !getDAO_().getPromptForReturnMsgKey().equals(argPromptForReturnMsgKey))) {
/*  679 */       getDAO_().setPromptForReturnMsgKey(argPromptForReturnMsgKey);
/*  680 */       ev_postable = true;
/*      */     } 
/*      */     
/*  683 */     return ev_postable;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public String getExternalId() {
/*  691 */     return getDAO_().getExternalId();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setExternalId(String argExternalId) {
/*  699 */     if (setExternalId_noev(argExternalId) && 
/*  700 */       this._events != null && 
/*  701 */       postEventsForChanges()) {
/*  702 */       this._events.post(IAttachedItems.SET_EXTERNALID, argExternalId);
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean setExternalId_noev(String argExternalId) {
/*  709 */     boolean ev_postable = false;
/*      */     
/*  711 */     if ((getDAO_().getExternalId() == null && argExternalId != null) || (
/*  712 */       getDAO_().getExternalId() != null && !getDAO_().getExternalId().equals(argExternalId))) {
/*  713 */       getDAO_().setExternalId(argExternalId);
/*  714 */       ev_postable = true;
/*      */     } 
/*      */     
/*  717 */     return ev_postable;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public String getExternalSystem() {
/*  725 */     return getDAO_().getExternalSystem();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setExternalSystem(String argExternalSystem) {
/*  733 */     if (setExternalSystem_noev(argExternalSystem) && 
/*  734 */       this._events != null && 
/*  735 */       postEventsForChanges()) {
/*  736 */       this._events.post(IAttachedItems.SET_EXTERNALSYSTEM, argExternalSystem);
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean setExternalSystem_noev(String argExternalSystem) {
/*  743 */     boolean ev_postable = false;
/*      */     
/*  745 */     if ((getDAO_().getExternalSystem() == null && argExternalSystem != null) || (
/*  746 */       getDAO_().getExternalSystem() != null && !getDAO_().getExternalSystem().equals(argExternalSystem))) {
/*  747 */       getDAO_().setExternalSystem(argExternalSystem);
/*  748 */       ev_postable = true;
/*      */     } 
/*      */     
/*  751 */     return ev_postable;
/*      */   }
/*      */   
/*      */   protected IAttachedItemsProperty newProperty(String argPropertyName) {
/*  755 */     AttachedItemsPropertyId id = new AttachedItemsPropertyId();
/*      */     
/*  757 */     id.setAttachedItemId(getAttachedItemId());
/*  758 */     id.setSoldItemId(getSoldItemId());
/*  759 */     id.setLevelCode(getLevelCode());
/*  760 */     id.setLevelValue(getLevelValue());
/*  761 */     id.setPropertyCode(argPropertyName);
/*      */     
/*  763 */     IAttachedItemsProperty prop = (IAttachedItemsProperty)DataFactory.getInstance().createNewObject((IObjectId)id, IAttachedItemsProperty.class);
/*  764 */     return prop;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   @Relationship(name = "AttachedItem")
/*      */   public IItem getAttachedItem() {
/*  782 */     return this._attachedItem;
/*      */   }
/*      */ 
/*      */   
/*      */   public void setAttachedItem(IItem argAttachedItem) {
/*  787 */     if (argAttachedItem == null) {
/*      */       
/*  789 */       if (this._attachedItem != null) {
/*  790 */         throw new DtxException("An Attempt was made to break a ONE-ONE relationship that cannot be broken because all fields that define the relationship are primary keys on the parent data object.");
/*      */       }
/*      */       
/*  793 */       if (this._attachedItem != null)
/*      */       {
/*  795 */         if (postEventsForChanges()) {
/*  796 */           this._eventManager.deregisterEventHandler((IEventAware)this._eventCascade, (IEventSource)new EventDescriptor(this._attachedItem));
/*      */         
/*      */         }
/*      */       
/*      */       }
/*      */     }
/*  802 */     else if (postEventsForChanges()) {
/*  803 */       this._eventManager.registerEventHandler((IEventAware)this._eventCascade, (IEventSource)new EventDescriptor(argAttachedItem));
/*      */     } 
/*      */ 
/*      */     
/*  807 */     this._attachedItem = argAttachedItem;
/*  808 */     if (postEventsForChanges()) {
/*  809 */       this._events.post(IAttachedItems.SET_ATTACHEDITEM, argAttachedItem);
/*      */     }
/*      */   }
/*      */   
/*      */   @Relationship(name = "SoldItem")
/*      */   public IItem getSoldItem() {
/*  815 */     return this._soldItem;
/*      */   }
/*      */ 
/*      */   
/*      */   public void setSoldItem(IItem argSoldItem) {
/*  820 */     if (argSoldItem == null) {
/*      */       
/*  822 */       if (this._soldItem != null) {
/*  823 */         throw new DtxException("An Attempt was made to break a ONE-ONE relationship that cannot be broken because all fields that define the relationship are primary keys on the parent data object.");
/*      */       }
/*      */       
/*  826 */       if (this._soldItem != null)
/*      */       {
/*  828 */         if (postEventsForChanges()) {
/*  829 */           this._eventManager.deregisterEventHandler((IEventAware)this._eventCascade, (IEventSource)new EventDescriptor(this._soldItem));
/*      */         
/*      */         }
/*      */       
/*      */       }
/*      */     }
/*  835 */     else if (postEventsForChanges()) {
/*  836 */       this._eventManager.registerEventHandler((IEventAware)this._eventCascade, (IEventSource)new EventDescriptor(argSoldItem));
/*      */     } 
/*      */ 
/*      */     
/*  840 */     this._soldItem = argSoldItem;
/*  841 */     if (postEventsForChanges()) {
/*  842 */       this._events.post(IAttachedItems.SET_SOLDITEM, argSoldItem);
/*      */     }
/*      */   }
/*      */   
/*      */   @Relationship(name = "AssociationType")
/*      */   public ILineItemAssociationTypeCode getAssociationType() {
/*  848 */     return this._associationType;
/*      */   }
/*      */ 
/*      */   
/*      */   public void setAssociationType(ILineItemAssociationTypeCode argAssociationType) {
/*  853 */     if (argAssociationType == null) {
/*      */       
/*  855 */       getDAO_().setLineItemAssociationTypeCode(null);
/*  856 */       if (this._associationType != null)
/*      */       {
/*  858 */         if (postEventsForChanges()) {
/*  859 */           this._eventManager.deregisterEventHandler((IEventAware)this._eventCascade, (IEventSource)new EventDescriptor(this._associationType));
/*      */         }
/*      */       }
/*      */     } else {
/*      */       
/*  864 */       getDAO_().setLineItemAssociationTypeCode(argAssociationType.getLineItemAssociationTypeCode());
/*      */       
/*  866 */       if (postEventsForChanges()) {
/*  867 */         this._eventManager.registerEventHandler((IEventAware)this._eventCascade, (IEventSource)new EventDescriptor(argAssociationType));
/*      */       }
/*      */     } 
/*      */     
/*  871 */     this._associationType = argAssociationType;
/*  872 */     if (postEventsForChanges()) {
/*  873 */       this._events.post(IAttachedItems.SET_ASSOCIATIONTYPE, argAssociationType);
/*      */     }
/*      */   }
/*      */   
/*      */   @Relationship(name = "Properties")
/*      */   public List<IAttachedItemsProperty> getProperties() {
/*  879 */     if (this._properties == null) {
/*  880 */       this._properties = new HistoricalList(null);
/*      */     }
/*  882 */     return (List<IAttachedItemsProperty>)this._properties;
/*      */   }
/*      */   
/*      */   public void setProperties(List<IAttachedItemsProperty> argProperties) {
/*  886 */     if (this._properties == null) {
/*  887 */       this._properties = new HistoricalList(argProperties);
/*      */     } else {
/*  889 */       this._properties.setCurrentList(argProperties);
/*      */     } 
/*      */     
/*  892 */     for (IAttachedItemsProperty child : this._properties) {
/*  893 */       AttachedItemsPropertyModel model = (AttachedItemsPropertyModel)child;
/*  894 */       model.setAttachedItemId_noev(getAttachedItemId());
/*  895 */       model.setOrganizationId_noev(getOrganizationId());
/*  896 */       model.setSoldItemId_noev(getSoldItemId());
/*  897 */       model.setLevelCode_noev(getLevelCode());
/*  898 */       model.setLevelValue_noev(getLevelValue());
/*  899 */       if (child instanceof IDataModelImpl) {
/*  900 */         IDataAccessObject childDao = ((IDataModelImpl)child).getDAO();
/*  901 */         if (StringUtils.isEmpty(childDao.getOriginDataSource()) && 
/*  902 */           !StringUtils.isEmpty(getDAO().getOriginDataSource())) {
/*  903 */           childDao.setOriginDataSource(getDAO().getOriginDataSource());
/*      */         }
/*      */       } 
/*  906 */       if (postEventsForChanges()) {
/*  907 */         this._eventManager.registerEventHandler((IEventAware)this._eventCascade, (IEventSource)child);
/*      */       }
/*      */     } 
/*      */   }
/*      */   
/*      */   public void addAttachedItemsProperty(IAttachedItemsProperty argAttachedItemsProperty) {
/*  913 */     if (this._properties == null) {
/*  914 */       this._properties = new HistoricalList(null);
/*      */     }
/*  916 */     argAttachedItemsProperty.setAttachedItemId(getAttachedItemId());
/*  917 */     argAttachedItemsProperty.setOrganizationId(getOrganizationId());
/*  918 */     argAttachedItemsProperty.setSoldItemId(getSoldItemId());
/*  919 */     argAttachedItemsProperty.setLevelCode(getLevelCode());
/*  920 */     argAttachedItemsProperty.setLevelValue(getLevelValue());
/*  921 */     if (argAttachedItemsProperty instanceof IDataModelImpl) {
/*  922 */       IDataAccessObject childDao = ((IDataModelImpl)argAttachedItemsProperty).getDAO();
/*  923 */       if (StringUtils.isEmpty(childDao.getOriginDataSource()) && 
/*  924 */         !StringUtils.isEmpty(getDAO().getOriginDataSource())) {
/*  925 */         childDao.setOriginDataSource(getDAO().getOriginDataSource());
/*      */       }
/*      */     } 
/*      */ 
/*      */     
/*  930 */     if (postEventsForChanges()) {
/*  931 */       this._eventManager.registerEventHandler((IEventAware)this._eventCascade, (IEventSource)new EventDescriptor(argAttachedItemsProperty));
/*      */     }
/*      */     
/*  934 */     this._properties.add(argAttachedItemsProperty);
/*  935 */     if (postEventsForChanges()) {
/*  936 */       this._events.post(IAttachedItems.ADD_PROPERTIES, argAttachedItemsProperty);
/*      */     }
/*      */   }
/*      */   
/*      */   public void removeAttachedItemsProperty(IAttachedItemsProperty argAttachedItemsProperty) {
/*  941 */     if (this._properties != null) {
/*      */       
/*  943 */       if (postEventsForChanges()) {
/*  944 */         this._eventManager.deregisterEventHandler((IEventAware)this._eventCascade, (IEventSource)new EventDescriptor(argAttachedItemsProperty));
/*      */       }
/*  946 */       this._properties.remove(argAttachedItemsProperty);
/*  947 */       if (postEventsForChanges()) {
/*  948 */         this._events.post(IAttachedItems.REMOVE_PROPERTIES, argAttachedItemsProperty);
/*      */       }
/*      */     } 
/*      */   }
/*      */ 
/*      */   
/*      */   public Object getValue(String argFieldId) {
/*  955 */     if ("AttachedItem".equals(argFieldId)) {
/*  956 */       return getAttachedItem();
/*      */     }
/*  958 */     if ("SoldItem".equals(argFieldId)) {
/*  959 */       return getSoldItem();
/*      */     }
/*  961 */     if ("AssociationType".equals(argFieldId)) {
/*  962 */       return getAssociationType();
/*      */     }
/*  964 */     if ("Properties".equals(argFieldId)) {
/*  965 */       return getProperties();
/*      */     }
/*  967 */     if ("AttachedItemsExtension".equals(argFieldId)) {
/*  968 */       return this._myExtension;
/*      */     }
/*      */     
/*  971 */     return super.getValue(argFieldId);
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public void setValue(String argFieldId, Object argValue) {
/*  977 */     if ("AttachedItem".equals(argFieldId)) {
/*  978 */       setAttachedItem((IItem)argValue);
/*      */     }
/*  980 */     else if ("SoldItem".equals(argFieldId)) {
/*  981 */       setSoldItem((IItem)argValue);
/*      */     }
/*  983 */     else if ("AssociationType".equals(argFieldId)) {
/*  984 */       setAssociationType((ILineItemAssociationTypeCode)argValue);
/*      */     }
/*  986 */     else if ("Properties".equals(argFieldId)) {
/*  987 */       setProperties(changeToList(argValue, IAttachedItemsProperty.class));
/*      */     }
/*  989 */     else if ("AttachedItemsExtension".equals(argFieldId)) {
/*  990 */       this._myExtension = (IDataModel)argValue;
/*      */     } else {
/*      */       
/*  993 */       super.setValue(argFieldId, argValue);
/*      */     } 
/*      */   }
/*      */ 
/*      */   
/*      */   public void setDependencies(IPersistenceDefaults argPD, EventManager argEM) {
/*  999 */     this._persistenceDefaults = argPD;
/* 1000 */     this._daoImpl.setPersistenceDefaults(argPD);
/* 1001 */     this._eventManager = argEM;
/* 1002 */     this._events = (Eventor)new ModelEventor((IDataModel)this, argEM);
/* 1003 */     this._eventCascade = (EventHandler)new CascadingHandler(this);
/* 1004 */     if (this._attachedItem != null) {
/* 1005 */       ((IDataModelImpl)this._attachedItem).setDependencies(argPD, argEM);
/*      */     }
/* 1007 */     if (this._soldItem != null) {
/* 1008 */       ((IDataModelImpl)this._soldItem).setDependencies(argPD, argEM);
/*      */     }
/* 1010 */     if (this._associationType != null) {
/* 1011 */       ((IDataModelImpl)this._associationType).setDependencies(argPD, argEM);
/*      */     }
/* 1013 */     if (this._properties != null) {
/* 1014 */       for (IAttachedItemsProperty relationship : this._properties) {
/* 1015 */         ((IDataModelImpl)relationship).setDependencies(argPD, argEM);
/*      */       }
/*      */     }
/*      */   }
/*      */   
/*      */   public IDataModel getAttachedItemsExt() {
/* 1021 */     return this._myExtension;
/*      */   }
/*      */   
/*      */   public void setAttachedItemsExt(IDataModel argExt) {
/* 1025 */     this._myExtension = argExt;
/*      */   }
/*      */ 
/*      */   
/*      */   public void startTransaction() {
/* 1030 */     if (this._alreadyInStart) {
/*      */       return;
/*      */     }
/*      */     
/* 1034 */     this._alreadyInStart = true;
/*      */ 
/*      */     
/* 1037 */     super.startTransaction();
/*      */     
/* 1039 */     this._attachedItemSavepoint = this._attachedItem;
/* 1040 */     if (this._attachedItem != null) {
/* 1041 */       this._attachedItem.startTransaction();
/*      */     }
/*      */     
/* 1044 */     this._soldItemSavepoint = this._soldItem;
/* 1045 */     if (this._soldItem != null) {
/* 1046 */       this._soldItem.startTransaction();
/*      */     }
/*      */     
/* 1049 */     this._associationTypeSavepoint = this._associationType;
/* 1050 */     if (this._associationType != null) {
/* 1051 */       this._associationType.startTransaction();
/*      */     }
/*      */     
/* 1054 */     this._propertiesSavepoint = this._properties;
/* 1055 */     if (this._properties != null) {
/* 1056 */       this._propertiesSavepoint = new HistoricalList((List)this._properties);
/* 1057 */       Iterator<IDataModel> it = this._properties.iterator();
/* 1058 */       while (it.hasNext()) {
/* 1059 */         ((IDataModel)it.next()).startTransaction();
/*      */       }
/*      */     } 
/*      */ 
/*      */     
/* 1064 */     this._alreadyInStart = false;
/*      */   }
/*      */ 
/*      */   
/*      */   public void rollbackChanges() {
/* 1069 */     if (isAlreadyRolledBack()) {
/*      */       return;
/*      */     }
/* 1072 */     super.rollbackChanges();
/*      */     
/* 1074 */     this._attachedItem = this._attachedItemSavepoint;
/* 1075 */     this._attachedItemSavepoint = null;
/* 1076 */     if (this._attachedItem != null) {
/* 1077 */       this._attachedItem.rollbackChanges();
/*      */     }
/*      */     
/* 1080 */     this._soldItem = this._soldItemSavepoint;
/* 1081 */     this._soldItemSavepoint = null;
/* 1082 */     if (this._soldItem != null) {
/* 1083 */       this._soldItem.rollbackChanges();
/*      */     }
/*      */     
/* 1086 */     this._associationType = this._associationTypeSavepoint;
/* 1087 */     this._associationTypeSavepoint = null;
/* 1088 */     if (this._associationType != null) {
/* 1089 */       this._associationType.rollbackChanges();
/*      */     }
/*      */     
/* 1092 */     this._properties = this._propertiesSavepoint;
/* 1093 */     this._propertiesSavepoint = null;
/* 1094 */     if (this._properties != null) {
/* 1095 */       Iterator<IDataModel> it = this._properties.iterator();
/* 1096 */       while (it.hasNext()) {
/* 1097 */         ((IDataModel)it.next()).rollbackChanges();
/*      */       }
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public void commitTransaction() {
/* 1105 */     if (this._alreadyInCommit) {
/*      */       return;
/*      */     }
/* 1108 */     this._alreadyInCommit = true;
/*      */ 
/*      */     
/* 1111 */     super.commitTransaction();
/*      */     
/* 1113 */     this._attachedItemSavepoint = this._attachedItem;
/* 1114 */     if (this._attachedItem != null) {
/* 1115 */       this._attachedItem.commitTransaction();
/*      */     }
/*      */     
/* 1118 */     this._soldItemSavepoint = this._soldItem;
/* 1119 */     if (this._soldItem != null) {
/* 1120 */       this._soldItem.commitTransaction();
/*      */     }
/*      */     
/* 1123 */     this._associationTypeSavepoint = this._associationType;
/* 1124 */     if (this._associationType != null) {
/* 1125 */       this._associationType.commitTransaction();
/*      */     }
/*      */     
/* 1128 */     this._propertiesSavepoint = this._properties;
/* 1129 */     if (this._properties != null) {
/* 1130 */       Iterator<IDataModel> it = this._properties.iterator();
/* 1131 */       while (it.hasNext()) {
/* 1132 */         ((IDataModel)it.next()).commitTransaction();
/*      */       }
/* 1134 */       this._properties = new HistoricalList((List)this._properties);
/*      */     } 
/*      */ 
/*      */     
/* 1138 */     this._alreadyInCommit = false;
/*      */   }
/*      */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\itm\impl\AttachedItemsModel.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */