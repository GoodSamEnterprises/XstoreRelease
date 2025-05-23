/*      */ package dtv.xst.dao.trl.impl;
/*      */ 
/*      */ import dtv.data2.IPersistenceDefaults;
/*      */ import dtv.data2.access.IDataAccessObject;
/*      */ import dtv.data2.access.IDataModel;
/*      */ import dtv.data2.access.impl.IDataModelImpl;
/*      */ import dtv.data2.access.impl.Relationship;
/*      */ import dtv.event.EventDescriptor;
/*      */ import dtv.event.EventManager;
/*      */ import dtv.event.IEventAware;
/*      */ import dtv.event.IEventSource;
/*      */ import dtv.util.HistoricalList;
/*      */ import dtv.util.StringUtils;
/*      */ import dtv.xst.dao.itm.IItem;
/*      */ import dtv.xst.dao.trl.IRetailInventoryLocationModifier;
/*      */ import dtv.xst.dao.trl.IRetailTransactionExchangeLineItem;
/*      */ import dtv.xst.dao.xom.IOrderModifier;
/*      */ import dtv.xst.daocommon.IInventoryAccountModifier;
/*      */ import dtv.xst.daocommon.IInventoryLocationModifier;
/*      */ import java.io.IOException;
/*      */ import java.io.ObjectInputStream;
/*      */ import java.math.BigDecimal;
/*      */ import java.util.ArrayList;
/*      */ import java.util.Date;
/*      */ import java.util.Iterator;
/*      */ import java.util.List;
/*      */ 
/*      */ public class RetailTransactionExchangeLineItemModel extends RetailTransactionLineItemModel implements IRetailTransactionExchangeLineItem {
/*      */   private static final long serialVersionUID = -790483899L;
/*      */   private transient boolean _alreadyInStart = false;
/*      */   
/*      */   public void initDAO() {
/*   33 */     setDAO((IDataAccessObject)new RetailTransactionExchangeLineItemDAO());
/*      */   }
/*      */   private transient boolean _alreadyInCommit = false; private IDataModel _myExtension; private HistoricalList<IRetailInventoryLocationModifier> _retailInventoryLocationModifiers;
/*      */   private transient HistoricalList<IRetailInventoryLocationModifier> _retailInventoryLocationModifiersSavepoint;
/*      */   private IItem _item;
/*      */   private transient IItem _itemSavepoint;
/*      */   
/*      */   private RetailTransactionExchangeLineItemDAO getDAO_() {
/*   41 */     return (RetailTransactionExchangeLineItemDAO)this._daoImpl;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public long getOrganizationId() {
/*   49 */     if (getDAO_().getOrganizationId() != null) {
/*   50 */       return getDAO_().getOrganizationId().longValue();
/*      */     }
/*      */     
/*   53 */     return 0L;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setOrganizationId(long argOrganizationId) {
/*   62 */     if (setOrganizationId_noev(argOrganizationId) && 
/*   63 */       this._events != null && 
/*   64 */       postEventsForChanges()) {
/*   65 */       this._events.post(IRetailTransactionExchangeLineItem.SET_ORGANIZATIONID, Long.valueOf(argOrganizationId));
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean setOrganizationId_noev(long argOrganizationId) {
/*   72 */     boolean ev_postable = false;
/*      */ 
/*      */     
/*   75 */     if (super.setOrganizationId_noev(argOrganizationId) && 
/*   76 */       this._retailInventoryLocationModifiers != null) {
/*      */       
/*   78 */       Iterator<RetailInventoryLocationModifierModel> it = this._retailInventoryLocationModifiers.iterator();
/*   79 */       while (it.hasNext())
/*      */       {
/*   81 */         ((RetailInventoryLocationModifierModel)it.next()).setOrganizationId_noev(argOrganizationId);
/*      */       }
/*      */     } 
/*      */ 
/*      */     
/*   86 */     return ev_postable;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public long getRetailLocationId() {
/*   94 */     if (getDAO_().getRetailLocationId() != null) {
/*   95 */       return getDAO_().getRetailLocationId().longValue();
/*      */     }
/*      */     
/*   98 */     return 0L;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setRetailLocationId(long argRetailLocationId) {
/*  107 */     if (setRetailLocationId_noev(argRetailLocationId) && 
/*  108 */       this._events != null && 
/*  109 */       postEventsForChanges()) {
/*  110 */       this._events.post(IRetailTransactionExchangeLineItem.SET_RETAILLOCATIONID, Long.valueOf(argRetailLocationId));
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean setRetailLocationId_noev(long argRetailLocationId) {
/*  117 */     boolean ev_postable = false;
/*      */ 
/*      */     
/*  120 */     if (super.setRetailLocationId_noev(argRetailLocationId) && 
/*  121 */       this._retailInventoryLocationModifiers != null) {
/*      */       
/*  123 */       Iterator<RetailInventoryLocationModifierModel> it = this._retailInventoryLocationModifiers.iterator();
/*  124 */       while (it.hasNext())
/*      */       {
/*  126 */         ((RetailInventoryLocationModifierModel)it.next()).setRetailLocationId_noev(argRetailLocationId);
/*      */       }
/*      */     } 
/*      */ 
/*      */     
/*  131 */     return ev_postable;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public Date getBusinessDate() {
/*  139 */     return getDAO_().getBusinessDate();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setBusinessDate(Date argBusinessDate) {
/*  147 */     if (setBusinessDate_noev(argBusinessDate) && 
/*  148 */       this._events != null && 
/*  149 */       postEventsForChanges()) {
/*  150 */       this._events.post(IRetailTransactionExchangeLineItem.SET_BUSINESSDATE, argBusinessDate);
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean setBusinessDate_noev(Date argBusinessDate) {
/*  157 */     boolean ev_postable = false;
/*      */ 
/*      */     
/*  160 */     if (super.setBusinessDate_noev(argBusinessDate) && 
/*  161 */       this._retailInventoryLocationModifiers != null) {
/*      */       
/*  163 */       Iterator<RetailInventoryLocationModifierModel> it = this._retailInventoryLocationModifiers.iterator();
/*  164 */       while (it.hasNext())
/*      */       {
/*  166 */         ((RetailInventoryLocationModifierModel)it.next()).setBusinessDate_noev(argBusinessDate);
/*      */       }
/*      */     } 
/*      */ 
/*      */     
/*  171 */     return ev_postable;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public long getWorkstationId() {
/*  179 */     if (getDAO_().getWorkstationId() != null) {
/*  180 */       return getDAO_().getWorkstationId().longValue();
/*      */     }
/*      */     
/*  183 */     return 0L;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setWorkstationId(long argWorkstationId) {
/*  192 */     if (setWorkstationId_noev(argWorkstationId) && 
/*  193 */       this._events != null && 
/*  194 */       postEventsForChanges()) {
/*  195 */       this._events.post(IRetailTransactionExchangeLineItem.SET_WORKSTATIONID, Long.valueOf(argWorkstationId));
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean setWorkstationId_noev(long argWorkstationId) {
/*  202 */     boolean ev_postable = false;
/*      */ 
/*      */     
/*  205 */     if (super.setWorkstationId_noev(argWorkstationId) && 
/*  206 */       this._retailInventoryLocationModifiers != null) {
/*      */       
/*  208 */       Iterator<RetailInventoryLocationModifierModel> it = this._retailInventoryLocationModifiers.iterator();
/*  209 */       while (it.hasNext())
/*      */       {
/*  211 */         ((RetailInventoryLocationModifierModel)it.next()).setWorkstationId_noev(argWorkstationId);
/*      */       }
/*      */     } 
/*      */ 
/*      */     
/*  216 */     return ev_postable;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public long getTransactionSequence() {
/*  224 */     if (getDAO_().getTransactionSequence() != null) {
/*  225 */       return getDAO_().getTransactionSequence().longValue();
/*      */     }
/*      */     
/*  228 */     return 0L;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setTransactionSequence(long argTransactionSequence) {
/*  237 */     if (setTransactionSequence_noev(argTransactionSequence) && 
/*  238 */       this._events != null && 
/*  239 */       postEventsForChanges()) {
/*  240 */       this._events.post(IRetailTransactionExchangeLineItem.SET_TRANSACTIONSEQUENCE, Long.valueOf(argTransactionSequence));
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean setTransactionSequence_noev(long argTransactionSequence) {
/*  247 */     boolean ev_postable = false;
/*      */ 
/*      */     
/*  250 */     if (super.setTransactionSequence_noev(argTransactionSequence) && 
/*  251 */       this._retailInventoryLocationModifiers != null) {
/*      */       
/*  253 */       Iterator<RetailInventoryLocationModifierModel> it = this._retailInventoryLocationModifiers.iterator();
/*  254 */       while (it.hasNext())
/*      */       {
/*  256 */         ((RetailInventoryLocationModifierModel)it.next()).setTransactionSequence_noev(argTransactionSequence);
/*      */       }
/*      */     } 
/*      */ 
/*      */     
/*  261 */     return ev_postable;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public int getRetailTransactionLineItemSequence() {
/*  269 */     if (getDAO_().getRetailTransactionLineItemSequence() != null) {
/*  270 */       return getDAO_().getRetailTransactionLineItemSequence().intValue();
/*      */     }
/*      */     
/*  273 */     return 0;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setRetailTransactionLineItemSequence(int argRetailTransactionLineItemSequence) {
/*  282 */     if (setRetailTransactionLineItemSequence_noev(argRetailTransactionLineItemSequence) && 
/*  283 */       this._events != null && 
/*  284 */       postEventsForChanges()) {
/*  285 */       this._events.post(IRetailTransactionExchangeLineItem.SET_RETAILTRANSACTIONLINEITEMSEQUENCE, Integer.valueOf(argRetailTransactionLineItemSequence));
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean setRetailTransactionLineItemSequence_noev(int argRetailTransactionLineItemSequence) {
/*  292 */     boolean ev_postable = false;
/*      */ 
/*      */     
/*  295 */     if (super.setRetailTransactionLineItemSequence_noev(argRetailTransactionLineItemSequence) && 
/*  296 */       this._retailInventoryLocationModifiers != null) {
/*      */       
/*  298 */       Iterator<RetailInventoryLocationModifierModel> it = this._retailInventoryLocationModifiers.iterator();
/*  299 */       while (it.hasNext())
/*      */       {
/*  301 */         ((RetailInventoryLocationModifierModel)it.next()).setTransactionLineItemSequence_noev(argRetailTransactionLineItemSequence);
/*      */       }
/*      */     } 
/*      */ 
/*      */     
/*  306 */     return ev_postable;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public String getItemId() {
/*  314 */     return getDAO_().getItemId();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setItemId(String argItemId) {
/*  322 */     if (setItemId_noev(argItemId) && 
/*  323 */       this._events != null && 
/*  324 */       postEventsForChanges()) {
/*  325 */       this._events.post(IRetailTransactionExchangeLineItem.SET_ITEMID, argItemId);
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean setItemId_noev(String argItemId) {
/*  332 */     boolean ev_postable = false;
/*      */     
/*  334 */     if ((getDAO_().getItemId() == null && argItemId != null) || (
/*  335 */       getDAO_().getItemId() != null && !getDAO_().getItemId().equals(argItemId))) {
/*  336 */       getDAO_().setItemId(argItemId);
/*  337 */       ev_postable = true;
/*      */     } 
/*      */     
/*  340 */     return ev_postable;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public Date getCreateDate() {
/*  348 */     return getDAO_().getCreateDate();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setCreateDate(Date argCreateDate) {
/*  356 */     if (setCreateDate_noev(argCreateDate) && 
/*  357 */       this._events != null && 
/*  358 */       postEventsForChanges()) {
/*  359 */       this._events.post(IRetailTransactionExchangeLineItem.SET_CREATEDATE, argCreateDate);
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean setCreateDate_noev(Date argCreateDate) {
/*  366 */     boolean ev_postable = false;
/*      */     
/*  368 */     if ((getDAO_().getCreateDate() == null && argCreateDate != null) || (
/*  369 */       getDAO_().getCreateDate() != null && !getDAO_().getCreateDate().equals(argCreateDate))) {
/*  370 */       getDAO_().setCreateDate(argCreateDate);
/*  371 */       ev_postable = true;
/*      */     } 
/*      */     
/*  374 */     return ev_postable;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public String getCreateUserId() {
/*  382 */     return getDAO_().getCreateUserId();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setCreateUserId(String argCreateUserId) {
/*  390 */     if (setCreateUserId_noev(argCreateUserId) && 
/*  391 */       this._events != null && 
/*  392 */       postEventsForChanges()) {
/*  393 */       this._events.post(IRetailTransactionExchangeLineItem.SET_CREATEUSERID, argCreateUserId);
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean setCreateUserId_noev(String argCreateUserId) {
/*  400 */     boolean ev_postable = false;
/*      */     
/*  402 */     if ((getDAO_().getCreateUserId() == null && argCreateUserId != null) || (
/*  403 */       getDAO_().getCreateUserId() != null && !getDAO_().getCreateUserId().equals(argCreateUserId))) {
/*  404 */       getDAO_().setCreateUserId(argCreateUserId);
/*  405 */       ev_postable = true;
/*      */     } 
/*      */     
/*  408 */     return ev_postable;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public Date getUpdateDate() {
/*  416 */     return getDAO_().getUpdateDate();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setUpdateDate(Date argUpdateDate) {
/*  424 */     if (setUpdateDate_noev(argUpdateDate) && 
/*  425 */       this._events != null && 
/*  426 */       postEventsForChanges()) {
/*  427 */       this._events.post(IRetailTransactionExchangeLineItem.SET_UPDATEDATE, argUpdateDate);
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean setUpdateDate_noev(Date argUpdateDate) {
/*  434 */     boolean ev_postable = false;
/*      */     
/*  436 */     if ((getDAO_().getUpdateDate() == null && argUpdateDate != null) || (
/*  437 */       getDAO_().getUpdateDate() != null && !getDAO_().getUpdateDate().equals(argUpdateDate))) {
/*  438 */       getDAO_().setUpdateDate(argUpdateDate);
/*  439 */       ev_postable = true;
/*      */     } 
/*      */     
/*  442 */     return ev_postable;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public String getUpdateUserId() {
/*  450 */     return getDAO_().getUpdateUserId();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setUpdateUserId(String argUpdateUserId) {
/*  458 */     if (setUpdateUserId_noev(argUpdateUserId) && 
/*  459 */       this._events != null && 
/*  460 */       postEventsForChanges()) {
/*  461 */       this._events.post(IRetailTransactionExchangeLineItem.SET_UPDATEUSERID, argUpdateUserId);
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean setUpdateUserId_noev(String argUpdateUserId) {
/*  468 */     boolean ev_postable = false;
/*      */     
/*  470 */     if ((getDAO_().getUpdateUserId() == null && argUpdateUserId != null) || (
/*  471 */       getDAO_().getUpdateUserId() != null && !getDAO_().getUpdateUserId().equals(argUpdateUserId))) {
/*  472 */       getDAO_().setUpdateUserId(argUpdateUserId);
/*  473 */       ev_postable = true;
/*      */     } 
/*      */     
/*  476 */     return ev_postable;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public String getOriginalSerialNumber() {
/*  484 */     return getDAO_().getOriginalSerialNumber();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setOriginalSerialNumber(String argOriginalSerialNumber) {
/*  492 */     if (setOriginalSerialNumber_noev(argOriginalSerialNumber) && 
/*  493 */       this._events != null && 
/*  494 */       postEventsForChanges()) {
/*  495 */       this._events.post(IRetailTransactionExchangeLineItem.SET_ORIGINALSERIALNUMBER, argOriginalSerialNumber);
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean setOriginalSerialNumber_noev(String argOriginalSerialNumber) {
/*  502 */     boolean ev_postable = false;
/*      */     
/*  504 */     if ((getDAO_().getOriginalSerialNumber() == null && argOriginalSerialNumber != null) || (
/*  505 */       getDAO_().getOriginalSerialNumber() != null && !getDAO_().getOriginalSerialNumber().equals(argOriginalSerialNumber))) {
/*  506 */       getDAO_().setOriginalSerialNumber(argOriginalSerialNumber);
/*  507 */       ev_postable = true;
/*      */     } 
/*      */     
/*  510 */     return ev_postable;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public String getNewSerialNumber() {
/*  518 */     return getDAO_().getNewSerialNumber();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setNewSerialNumber(String argNewSerialNumber) {
/*  526 */     if (setNewSerialNumber_noev(argNewSerialNumber) && 
/*  527 */       this._events != null && 
/*  528 */       postEventsForChanges()) {
/*  529 */       this._events.post(IRetailTransactionExchangeLineItem.SET_NEWSERIALNUMBER, argNewSerialNumber);
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean setNewSerialNumber_noev(String argNewSerialNumber) {
/*  536 */     boolean ev_postable = false;
/*      */     
/*  538 */     if ((getDAO_().getNewSerialNumber() == null && argNewSerialNumber != null) || (
/*  539 */       getDAO_().getNewSerialNumber() != null && !getDAO_().getNewSerialNumber().equals(argNewSerialNumber))) {
/*  540 */       getDAO_().setNewSerialNumber(argNewSerialNumber);
/*  541 */       ev_postable = true;
/*      */     } 
/*      */     
/*  544 */     return ev_postable;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public long getOriginalRetailLocationId() {
/*  552 */     if (getDAO_().getOriginalRetailLocationId() != null) {
/*  553 */       return getDAO_().getOriginalRetailLocationId().longValue();
/*      */     }
/*      */     
/*  556 */     return 0L;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setOriginalRetailLocationId(long argOriginalRetailLocationId) {
/*  565 */     if (setOriginalRetailLocationId_noev(argOriginalRetailLocationId) && 
/*  566 */       this._events != null && 
/*  567 */       postEventsForChanges()) {
/*  568 */       this._events.post(IRetailTransactionExchangeLineItem.SET_ORIGINALRETAILLOCATIONID, Long.valueOf(argOriginalRetailLocationId));
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean setOriginalRetailLocationId_noev(long argOriginalRetailLocationId) {
/*  575 */     boolean ev_postable = false;
/*      */     
/*  577 */     if ((getDAO_().getOriginalRetailLocationId() == null && Long.valueOf(argOriginalRetailLocationId) != null) || (
/*  578 */       getDAO_().getOriginalRetailLocationId() != null && !getDAO_().getOriginalRetailLocationId().equals(Long.valueOf(argOriginalRetailLocationId)))) {
/*  579 */       getDAO_().setOriginalRetailLocationId(Long.valueOf(argOriginalRetailLocationId));
/*  580 */       ev_postable = true;
/*      */     } 
/*      */     
/*  583 */     return ev_postable;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public Date getOriginalBusinessDate() {
/*  591 */     return getDAO_().getOriginalBusinessDate();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setOriginalBusinessDate(Date argOriginalBusinessDate) {
/*  599 */     if (setOriginalBusinessDate_noev(argOriginalBusinessDate) && 
/*  600 */       this._events != null && 
/*  601 */       postEventsForChanges()) {
/*  602 */       this._events.post(IRetailTransactionExchangeLineItem.SET_ORIGINALBUSINESSDATE, argOriginalBusinessDate);
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean setOriginalBusinessDate_noev(Date argOriginalBusinessDate) {
/*  609 */     boolean ev_postable = false;
/*      */     
/*  611 */     if ((getDAO_().getOriginalBusinessDate() == null && argOriginalBusinessDate != null) || (
/*  612 */       getDAO_().getOriginalBusinessDate() != null && !getDAO_().getOriginalBusinessDate().equals(argOriginalBusinessDate))) {
/*  613 */       getDAO_().setOriginalBusinessDate(argOriginalBusinessDate);
/*  614 */       ev_postable = true;
/*      */     } 
/*      */     
/*  617 */     return ev_postable;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public long getOriginalWorkstationId() {
/*  625 */     if (getDAO_().getOriginalWorkstationId() != null) {
/*  626 */       return getDAO_().getOriginalWorkstationId().longValue();
/*      */     }
/*      */     
/*  629 */     return 0L;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setOriginalWorkstationId(long argOriginalWorkstationId) {
/*  638 */     if (setOriginalWorkstationId_noev(argOriginalWorkstationId) && 
/*  639 */       this._events != null && 
/*  640 */       postEventsForChanges()) {
/*  641 */       this._events.post(IRetailTransactionExchangeLineItem.SET_ORIGINALWORKSTATIONID, Long.valueOf(argOriginalWorkstationId));
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean setOriginalWorkstationId_noev(long argOriginalWorkstationId) {
/*  648 */     boolean ev_postable = false;
/*      */     
/*  650 */     if ((getDAO_().getOriginalWorkstationId() == null && Long.valueOf(argOriginalWorkstationId) != null) || (
/*  651 */       getDAO_().getOriginalWorkstationId() != null && !getDAO_().getOriginalWorkstationId().equals(Long.valueOf(argOriginalWorkstationId)))) {
/*  652 */       getDAO_().setOriginalWorkstationId(Long.valueOf(argOriginalWorkstationId));
/*  653 */       ev_postable = true;
/*      */     } 
/*      */     
/*  656 */     return ev_postable;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public long getOriginalTransactionSequence() {
/*  664 */     if (getDAO_().getOriginalTransactionSequence() != null) {
/*  665 */       return getDAO_().getOriginalTransactionSequence().longValue();
/*      */     }
/*      */     
/*  668 */     return 0L;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setOriginalTransactionSequence(long argOriginalTransactionSequence) {
/*  677 */     if (setOriginalTransactionSequence_noev(argOriginalTransactionSequence) && 
/*  678 */       this._events != null && 
/*  679 */       postEventsForChanges()) {
/*  680 */       this._events.post(IRetailTransactionExchangeLineItem.SET_ORIGINALTRANSACTIONSEQUENCE, Long.valueOf(argOriginalTransactionSequence));
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean setOriginalTransactionSequence_noev(long argOriginalTransactionSequence) {
/*  687 */     boolean ev_postable = false;
/*      */     
/*  689 */     if ((getDAO_().getOriginalTransactionSequence() == null && Long.valueOf(argOriginalTransactionSequence) != null) || (
/*  690 */       getDAO_().getOriginalTransactionSequence() != null && !getDAO_().getOriginalTransactionSequence().equals(Long.valueOf(argOriginalTransactionSequence)))) {
/*  691 */       getDAO_().setOriginalTransactionSequence(Long.valueOf(argOriginalTransactionSequence));
/*  692 */       ev_postable = true;
/*      */     } 
/*      */     
/*  695 */     return ev_postable;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public int getOiginalLineItemSequence() {
/*  703 */     if (getDAO_().getOiginalLineItemSequence() != null) {
/*  704 */       return getDAO_().getOiginalLineItemSequence().intValue();
/*      */     }
/*      */     
/*  707 */     return 0;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setOiginalLineItemSequence(int argOiginalLineItemSequence) {
/*  716 */     if (setOiginalLineItemSequence_noev(argOiginalLineItemSequence) && 
/*  717 */       this._events != null && 
/*  718 */       postEventsForChanges()) {
/*  719 */       this._events.post(IRetailTransactionExchangeLineItem.SET_OIGINALLINEITEMSEQUENCE, Integer.valueOf(argOiginalLineItemSequence));
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean setOiginalLineItemSequence_noev(int argOiginalLineItemSequence) {
/*  726 */     boolean ev_postable = false;
/*      */     
/*  728 */     if ((getDAO_().getOiginalLineItemSequence() == null && Integer.valueOf(argOiginalLineItemSequence) != null) || (
/*  729 */       getDAO_().getOiginalLineItemSequence() != null && !getDAO_().getOiginalLineItemSequence().equals(Integer.valueOf(argOiginalLineItemSequence)))) {
/*  730 */       getDAO_().setOiginalLineItemSequence(Integer.valueOf(argOiginalLineItemSequence));
/*  731 */       ev_postable = true;
/*      */     } 
/*      */     
/*  734 */     return ev_postable;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public String getExchangeReasonCode() {
/*  742 */     return getDAO_().getExchangeReasonCode();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setExchangeReasonCode(String argExchangeReasonCode) {
/*  750 */     if (setExchangeReasonCode_noev(argExchangeReasonCode) && 
/*  751 */       this._events != null && 
/*  752 */       postEventsForChanges()) {
/*  753 */       this._events.post(IRetailTransactionExchangeLineItem.SET_EXCHANGEREASONCODE, argExchangeReasonCode);
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean setExchangeReasonCode_noev(String argExchangeReasonCode) {
/*  760 */     boolean ev_postable = false;
/*      */     
/*  762 */     if ((getDAO_().getExchangeReasonCode() == null && argExchangeReasonCode != null) || (
/*  763 */       getDAO_().getExchangeReasonCode() != null && !getDAO_().getExchangeReasonCode().equals(argExchangeReasonCode))) {
/*  764 */       getDAO_().setExchangeReasonCode(argExchangeReasonCode);
/*  765 */       ev_postable = true;
/*      */     } 
/*      */     
/*  768 */     return ev_postable;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public String getExchangeComment() {
/*  776 */     return getDAO_().getExchangeComment();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setExchangeComment(String argExchangeComment) {
/*  784 */     if (setExchangeComment_noev(argExchangeComment) && 
/*  785 */       this._events != null && 
/*  786 */       postEventsForChanges()) {
/*  787 */       this._events.post(IRetailTransactionExchangeLineItem.SET_EXCHANGECOMMENT, argExchangeComment);
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean setExchangeComment_noev(String argExchangeComment) {
/*  794 */     boolean ev_postable = false;
/*      */     
/*  796 */     if ((getDAO_().getExchangeComment() == null && argExchangeComment != null) || (
/*  797 */       getDAO_().getExchangeComment() != null && !getDAO_().getExchangeComment().equals(argExchangeComment))) {
/*  798 */       getDAO_().setExchangeComment(argExchangeComment);
/*  799 */       ev_postable = true;
/*      */     } 
/*      */     
/*  802 */     return ev_postable;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   @Relationship(name = "RetailInventoryLocationModifiers")
/*      */   public List<IRetailInventoryLocationModifier> getRetailInventoryLocationModifiers() {
/*  814 */     if (this._retailInventoryLocationModifiers == null) {
/*  815 */       this._retailInventoryLocationModifiers = new HistoricalList(null);
/*      */     }
/*  817 */     return (List<IRetailInventoryLocationModifier>)this._retailInventoryLocationModifiers;
/*      */   }
/*      */   
/*      */   public void setRetailInventoryLocationModifiers(List<IRetailInventoryLocationModifier> argRetailInventoryLocationModifiers) {
/*  821 */     if (this._retailInventoryLocationModifiers == null) {
/*  822 */       this._retailInventoryLocationModifiers = new HistoricalList(argRetailInventoryLocationModifiers);
/*      */     } else {
/*  824 */       this._retailInventoryLocationModifiers.setCurrentList(argRetailInventoryLocationModifiers);
/*      */     } 
/*      */     
/*  827 */     for (IRetailInventoryLocationModifier child : this._retailInventoryLocationModifiers) {
/*  828 */       RetailInventoryLocationModifierModel model = (RetailInventoryLocationModifierModel)child;
/*  829 */       model.setOrganizationId_noev(getOrganizationId());
/*  830 */       model.setRetailLocationId_noev(getRetailLocationId());
/*  831 */       model.setBusinessDate_noev(getBusinessDate());
/*  832 */       model.setWorkstationId_noev(getWorkstationId());
/*  833 */       model.setTransactionSequence_noev(getTransactionSequence());
/*  834 */       model.setTransactionLineItemSequence_noev(getRetailTransactionLineItemSequence());
/*  835 */       if (child instanceof IDataModelImpl) {
/*  836 */         IDataAccessObject childDao = ((IDataModelImpl)child).getDAO();
/*  837 */         if (StringUtils.isEmpty(childDao.getOriginDataSource()) && 
/*  838 */           !StringUtils.isEmpty(getDAO().getOriginDataSource())) {
/*  839 */           childDao.setOriginDataSource(getDAO().getOriginDataSource());
/*      */         }
/*      */       } 
/*  842 */       if (postEventsForChanges()) {
/*  843 */         this._eventManager.registerEventHandler((IEventAware)this._eventCascade, (IEventSource)child);
/*      */       }
/*      */     } 
/*      */   }
/*      */   
/*      */   public void addRetailInventoryLocationModifier(IRetailInventoryLocationModifier argRetailInventoryLocationModifier) {
/*  849 */     if (this._retailInventoryLocationModifiers == null) {
/*  850 */       this._retailInventoryLocationModifiers = new HistoricalList(null);
/*      */     }
/*  852 */     argRetailInventoryLocationModifier.setOrganizationId(getOrganizationId());
/*  853 */     argRetailInventoryLocationModifier.setRetailLocationId(getRetailLocationId());
/*  854 */     argRetailInventoryLocationModifier.setBusinessDate(getBusinessDate());
/*  855 */     argRetailInventoryLocationModifier.setWorkstationId(getWorkstationId());
/*  856 */     argRetailInventoryLocationModifier.setTransactionSequence(getTransactionSequence());
/*  857 */     argRetailInventoryLocationModifier.setTransactionLineItemSequence(getRetailTransactionLineItemSequence());
/*  858 */     if (argRetailInventoryLocationModifier instanceof IDataModelImpl) {
/*  859 */       IDataAccessObject childDao = ((IDataModelImpl)argRetailInventoryLocationModifier).getDAO();
/*  860 */       if (StringUtils.isEmpty(childDao.getOriginDataSource()) && 
/*  861 */         !StringUtils.isEmpty(getDAO().getOriginDataSource())) {
/*  862 */         childDao.setOriginDataSource(getDAO().getOriginDataSource());
/*      */       }
/*      */     } 
/*      */ 
/*      */     
/*  867 */     if (postEventsForChanges()) {
/*  868 */       this._eventManager.registerEventHandler((IEventAware)this._eventCascade, (IEventSource)new EventDescriptor(argRetailInventoryLocationModifier));
/*      */     }
/*      */     
/*  871 */     this._retailInventoryLocationModifiers.add(argRetailInventoryLocationModifier);
/*  872 */     if (postEventsForChanges()) {
/*  873 */       this._events.post(IRetailTransactionExchangeLineItem.ADD_RETAILINVENTORYLOCATIONMODIFIERS, argRetailInventoryLocationModifier);
/*      */     }
/*      */   }
/*      */   
/*      */   public void removeRetailInventoryLocationModifier(IRetailInventoryLocationModifier argRetailInventoryLocationModifier) {
/*  878 */     if (this._retailInventoryLocationModifiers != null) {
/*      */       
/*  880 */       if (postEventsForChanges()) {
/*  881 */         this._eventManager.deregisterEventHandler((IEventAware)this._eventCascade, (IEventSource)new EventDescriptor(argRetailInventoryLocationModifier));
/*      */       }
/*  883 */       this._retailInventoryLocationModifiers.remove(argRetailInventoryLocationModifier);
/*  884 */       if (postEventsForChanges()) {
/*  885 */         this._events.post(IRetailTransactionExchangeLineItem.REMOVE_RETAILINVENTORYLOCATIONMODIFIERS, argRetailInventoryLocationModifier);
/*      */       }
/*      */     } 
/*      */   }
/*      */   
/*      */   @Relationship(name = "Item")
/*      */   public IItem getItem() {
/*  892 */     return this._item;
/*      */   }
/*      */ 
/*      */   
/*      */   public void setItem(IItem argItem) {
/*  897 */     if (argItem == null) {
/*      */       
/*  899 */       getDAO_().setItemId((String)null);
/*  900 */       if (this._item != null)
/*      */       {
/*  902 */         if (postEventsForChanges()) {
/*  903 */           this._eventManager.deregisterEventHandler((IEventAware)this._eventCascade, (IEventSource)new EventDescriptor(this._item));
/*      */         }
/*      */       }
/*      */     } else {
/*      */       
/*  908 */       getDAO_().setItemId(argItem.getItemId());
/*      */       
/*  910 */       if (postEventsForChanges()) {
/*  911 */         this._eventManager.registerEventHandler((IEventAware)this._eventCascade, (IEventSource)new EventDescriptor(argItem));
/*      */       }
/*      */     } 
/*      */     
/*  915 */     this._item = argItem;
/*  916 */     if (postEventsForChanges()) {
/*  917 */       this._events.post(IRetailTransactionExchangeLineItem.SET_ITEM, argItem);
/*      */     }
/*      */   }
/*      */ 
/*      */   
/*      */   public Object getValue(String argFieldId) {
/*  923 */     if ("RetailInventoryLocationModifiers".equals(argFieldId)) {
/*  924 */       return getRetailInventoryLocationModifiers();
/*      */     }
/*  926 */     if ("Item".equals(argFieldId)) {
/*  927 */       return getItem();
/*      */     }
/*  929 */     if ("RetailTransactionExchangeLineItemExtension".equals(argFieldId)) {
/*  930 */       return this._myExtension;
/*      */     }
/*      */     
/*  933 */     return super.getValue(argFieldId);
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public void setValue(String argFieldId, Object argValue) {
/*  939 */     if ("RetailInventoryLocationModifiers".equals(argFieldId)) {
/*  940 */       setRetailInventoryLocationModifiers(changeToList(argValue, IRetailInventoryLocationModifier.class));
/*      */     }
/*  942 */     else if ("Item".equals(argFieldId)) {
/*  943 */       setItem((IItem)argValue);
/*      */     }
/*  945 */     else if ("RetailTransactionExchangeLineItemExtension".equals(argFieldId)) {
/*  946 */       this._myExtension = (IDataModel)argValue;
/*      */     } else {
/*      */       
/*  949 */       super.setValue(argFieldId, argValue);
/*      */     } 
/*      */   }
/*      */ 
/*      */   
/*      */   public void setDependencies(IPersistenceDefaults argPD, EventManager argEM) {
/*  955 */     super.setDependencies(argPD, argEM);
/*  956 */     if (this._retailInventoryLocationModifiers != null) {
/*  957 */       for (IRetailInventoryLocationModifier relationship : this._retailInventoryLocationModifiers) {
/*  958 */         ((IDataModelImpl)relationship).setDependencies(argPD, argEM);
/*      */       }
/*      */     }
/*  961 */     if (this._item != null) {
/*  962 */       ((IDataModelImpl)this._item).setDependencies(argPD, argEM);
/*      */     }
/*      */   }
/*      */   
/*      */   public IDataModel getRetailTransactionExchangeLineItemExt() {
/*  967 */     return this._myExtension;
/*      */   }
/*      */   
/*      */   public void setRetailTransactionExchangeLineItemExt(IDataModel argExt) {
/*  971 */     this._myExtension = argExt;
/*      */   }
/*      */ 
/*      */   
/*      */   public void startTransaction() {
/*  976 */     if (this._alreadyInStart) {
/*      */       return;
/*      */     }
/*      */     
/*  980 */     this._alreadyInStart = true;
/*      */ 
/*      */     
/*  983 */     super.startTransaction();
/*      */     
/*  985 */     this._retailInventoryLocationModifiersSavepoint = this._retailInventoryLocationModifiers;
/*  986 */     if (this._retailInventoryLocationModifiers != null) {
/*  987 */       this._retailInventoryLocationModifiersSavepoint = new HistoricalList((List)this._retailInventoryLocationModifiers);
/*  988 */       Iterator<IDataModel> it = this._retailInventoryLocationModifiers.iterator();
/*  989 */       while (it.hasNext()) {
/*  990 */         ((IDataModel)it.next()).startTransaction();
/*      */       }
/*      */     } 
/*      */     
/*  994 */     this._itemSavepoint = this._item;
/*  995 */     if (this._item != null) {
/*  996 */       this._item.startTransaction();
/*      */     }
/*      */ 
/*      */     
/* 1000 */     this._alreadyInStart = false;
/*      */   }
/*      */ 
/*      */   
/*      */   public void rollbackChanges() {
/* 1005 */     if (isAlreadyRolledBack()) {
/*      */       return;
/*      */     }
/* 1008 */     super.rollbackChanges();
/*      */     
/* 1010 */     this._retailInventoryLocationModifiers = this._retailInventoryLocationModifiersSavepoint;
/* 1011 */     this._retailInventoryLocationModifiersSavepoint = null;
/* 1012 */     if (this._retailInventoryLocationModifiers != null) {
/* 1013 */       Iterator<IDataModel> it = this._retailInventoryLocationModifiers.iterator();
/* 1014 */       while (it.hasNext()) {
/* 1015 */         ((IDataModel)it.next()).rollbackChanges();
/*      */       }
/*      */     } 
/*      */     
/* 1019 */     this._item = this._itemSavepoint;
/* 1020 */     this._itemSavepoint = null;
/* 1021 */     if (this._item != null) {
/* 1022 */       this._item.rollbackChanges();
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public void commitTransaction() {
/* 1029 */     if (this._alreadyInCommit) {
/*      */       return;
/*      */     }
/* 1032 */     this._alreadyInCommit = true;
/*      */ 
/*      */     
/* 1035 */     super.commitTransaction();
/*      */     
/* 1037 */     this._retailInventoryLocationModifiersSavepoint = this._retailInventoryLocationModifiers;
/* 1038 */     if (this._retailInventoryLocationModifiers != null) {
/* 1039 */       Iterator<IDataModel> it = this._retailInventoryLocationModifiers.iterator();
/* 1040 */       while (it.hasNext()) {
/* 1041 */         ((IDataModel)it.next()).commitTransaction();
/*      */       }
/* 1043 */       this._retailInventoryLocationModifiers = new HistoricalList((List)this._retailInventoryLocationModifiers);
/*      */     } 
/*      */     
/* 1046 */     this._itemSavepoint = this._item;
/* 1047 */     if (this._item != null) {
/* 1048 */       this._item.commitTransaction();
/*      */     }
/*      */ 
/*      */     
/* 1052 */     this._alreadyInCommit = false;
/*      */   }
/*      */ 
/*      */   
/*      */   private void readObject(ObjectInputStream argStream) throws IOException, ClassNotFoundException {
/* 1057 */     argStream.defaultReadObject();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private transient boolean _incomingInventoryProcessed = false;
/*      */ 
/*      */   
/*      */   private transient BigDecimal _quantityToAllocate;
/*      */ 
/*      */   
/* 1069 */   private IInventoryAccountModifier custAccountMod = null;
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void addInventoryLocationModifier(IInventoryLocationModifier argModifier) {
/* 1075 */     if (argModifier instanceof IRetailInventoryLocationModifier)
/* 1076 */       addRetailInventoryLocationModifier((IRetailInventoryLocationModifier)argModifier); 
/*      */   }
/*      */   
/*      */   public BigDecimal getQuantityToAllocate() {
/* 1080 */     return this._quantityToAllocate;
/*      */   }
/*      */   
/*      */   public void setQuantityToAllocate(BigDecimal argQuantity) {
/* 1084 */     this._quantityToAllocate = argQuantity;
/*      */   }
/*      */   
/*      */   public boolean isIncomingInventoryProcessed() {
/* 1088 */     return this._incomingInventoryProcessed;
/*      */   }
/*      */   
/*      */   public void setIncomingInventoryProcessed(boolean argProcessed) {
/* 1092 */     this._incomingInventoryProcessed = argProcessed;
/*      */   }
/*      */ 
/*      */   
/*      */   public List<? extends IInventoryLocationModifier> getAllInventoryLocationModifiers() {
/* 1097 */     return (List)getRetailInventoryLocationModifiers();
/*      */   }
/*      */ 
/*      */   
/*      */   public void removeInventoryLocationModifier(IInventoryLocationModifier argModifier) {
/* 1102 */     if (argModifier instanceof IRetailInventoryLocationModifier)
/* 1103 */       removeRetailInventoryLocationModifier((IRetailInventoryLocationModifier)argModifier); 
/*      */   }
/*      */   
/*      */   public String getReturnReasonCode() {
/* 1107 */     return getExchangeReasonCode();
/*      */   }
/*      */   
/*      */   public IOrderModifier getOrderModifier() {
/* 1111 */     return null;
/*      */   }
/*      */   
/*      */   public List<? extends IInventoryLocationModifier> getNewInventoryLocationModifiers() {
/* 1115 */     if (this._retailInventoryLocationModifiers == null || this._retailInventoryLocationModifiers.getAddedItems() == null) {
/* 1116 */       return new ArrayList<>();
/*      */     }
/*      */     
/* 1119 */     return this._retailInventoryLocationModifiers.getAddedItems();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public int getLineItemSequence() {
/* 1126 */     return getRetailTransactionLineItemSequence();
/*      */   }
/*      */   
/*      */   public IInventoryAccountModifier getInventoryAccountModifier() {
/* 1130 */     return this.custAccountMod;
/*      */   }
/*      */   
/*      */   public void setInventoryAccountModifier(IInventoryAccountModifier acctMod) {
/* 1134 */     this.custAccountMod = acctMod;
/*      */   }
/*      */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\trl\impl\RetailTransactionExchangeLineItemModel.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */