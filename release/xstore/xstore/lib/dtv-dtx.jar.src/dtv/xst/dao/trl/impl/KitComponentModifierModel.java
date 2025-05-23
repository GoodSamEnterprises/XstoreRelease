/*      */ package dtv.xst.dao.trl.impl;
/*      */ import dtv.data2.IPersistenceDefaults;
/*      */ import dtv.data2.access.IDataAccessObject;
/*      */ import dtv.data2.access.IDataModel;
/*      */ import dtv.data2.access.IDataProperty;
/*      */ import dtv.data2.access.IObjectId;
/*      */ import dtv.data2.access.ModelEventor;
/*      */ import dtv.data2.access.impl.IDataModelImpl;
/*      */ import dtv.data2.access.impl.Relationship;
/*      */ import dtv.event.EventDescriptor;
/*      */ import dtv.event.EventManager;
/*      */ import dtv.event.Eventor;
/*      */ import dtv.event.IEventAware;
/*      */ import dtv.event.IEventSource;
/*      */ import dtv.event.handler.CascadingHandler;
/*      */ import dtv.util.HistoricalList;
/*      */ import dtv.util.StringUtils;
/*      */ import dtv.xst.dao.itm.IKitComponent;
/*      */ import dtv.xst.dao.trl.IKitComponentModifier;
/*      */ import dtv.xst.dao.trl.IKitComponentModifierProperty;
/*      */ import dtv.xst.dao.trl.ISaleReturnLineItem;
/*      */ import dtv.xst.dao.trl.KitComponentModifierPropertyId;
/*      */ import java.io.IOException;
/*      */ import java.io.ObjectInputStream;
/*      */ import java.util.Date;
/*      */ import java.util.Iterator;
/*      */ import java.util.List;
/*      */ 
/*      */ public class KitComponentModifierModel extends AbstractDataModelWithPropertyImpl<IKitComponentModifierProperty> implements IKitComponentModifier {
/*      */   private static final long serialVersionUID = -995503394L;
/*      */   private ISaleReturnLineItem _parentLine;
/*      */   private transient boolean _alreadyInStart = false;
/*      */   private transient boolean _alreadyInCommit = false;
/*      */   
/*      */   public String toString() {
/*   36 */     return super.toString() + " Id: " + getObjectId();
/*      */   }
/*      */   private IDataModel _myExtension; private IKitComponent _kitComponent; private transient IKitComponent _kitComponentSavepoint; private HistoricalList<IKitComponentModifierProperty> _properties; private transient HistoricalList<IKitComponentModifierProperty> _propertiesSavepoint;
/*      */   
/*      */   public void initDAO() {
/*   41 */     setDAO((IDataAccessObject)new KitComponentModifierDAO());
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private KitComponentModifierDAO getDAO_() {
/*   49 */     return (KitComponentModifierDAO)this._daoImpl;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public long getOrganizationId() {
/*   57 */     if (getDAO_().getOrganizationId() != null) {
/*   58 */       return getDAO_().getOrganizationId().longValue();
/*      */     }
/*      */     
/*   61 */     return 0L;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setOrganizationId(long argOrganizationId) {
/*   70 */     if (setOrganizationId_noev(argOrganizationId) && 
/*   71 */       this._events != null && 
/*   72 */       postEventsForChanges()) {
/*   73 */       this._events.post(IKitComponentModifier.SET_ORGANIZATIONID, Long.valueOf(argOrganizationId));
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean setOrganizationId_noev(long argOrganizationId) {
/*   80 */     boolean ev_postable = false;
/*      */     
/*   82 */     if ((getDAO_().getOrganizationId() == null && Long.valueOf(argOrganizationId) != null) || (
/*   83 */       getDAO_().getOrganizationId() != null && !getDAO_().getOrganizationId().equals(Long.valueOf(argOrganizationId)))) {
/*   84 */       getDAO_().setOrganizationId(Long.valueOf(argOrganizationId));
/*   85 */       ev_postable = true;
/*   86 */       if (this._properties != null) {
/*      */         
/*   88 */         Iterator<KitComponentModifierPropertyModel> it = this._properties.iterator();
/*   89 */         while (it.hasNext())
/*      */         {
/*   91 */           ((KitComponentModifierPropertyModel)it.next()).setOrganizationId_noev(argOrganizationId);
/*      */         }
/*      */       } 
/*      */     } 
/*      */     
/*   96 */     return ev_postable;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public long getRetailLocationId() {
/*  104 */     if (getDAO_().getRetailLocationId() != null) {
/*  105 */       return getDAO_().getRetailLocationId().longValue();
/*      */     }
/*      */     
/*  108 */     return 0L;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setRetailLocationId(long argRetailLocationId) {
/*  117 */     if (setRetailLocationId_noev(argRetailLocationId) && 
/*  118 */       this._events != null && 
/*  119 */       postEventsForChanges()) {
/*  120 */       this._events.post(IKitComponentModifier.SET_RETAILLOCATIONID, Long.valueOf(argRetailLocationId));
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean setRetailLocationId_noev(long argRetailLocationId) {
/*  127 */     boolean ev_postable = false;
/*      */     
/*  129 */     if ((getDAO_().getRetailLocationId() == null && Long.valueOf(argRetailLocationId) != null) || (
/*  130 */       getDAO_().getRetailLocationId() != null && !getDAO_().getRetailLocationId().equals(Long.valueOf(argRetailLocationId)))) {
/*  131 */       getDAO_().setRetailLocationId(Long.valueOf(argRetailLocationId));
/*  132 */       ev_postable = true;
/*  133 */       if (this._properties != null) {
/*      */         
/*  135 */         Iterator<KitComponentModifierPropertyModel> it = this._properties.iterator();
/*  136 */         while (it.hasNext())
/*      */         {
/*  138 */           ((KitComponentModifierPropertyModel)it.next()).setRetailLocationId_noev(argRetailLocationId);
/*      */         }
/*      */       } 
/*      */     } 
/*      */     
/*  143 */     return ev_postable;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public Date getBusinessDate() {
/*  151 */     return getDAO_().getBusinessDate();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setBusinessDate(Date argBusinessDate) {
/*  159 */     if (setBusinessDate_noev(argBusinessDate) && 
/*  160 */       this._events != null && 
/*  161 */       postEventsForChanges()) {
/*  162 */       this._events.post(IKitComponentModifier.SET_BUSINESSDATE, argBusinessDate);
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean setBusinessDate_noev(Date argBusinessDate) {
/*  169 */     boolean ev_postable = false;
/*      */     
/*  171 */     if ((getDAO_().getBusinessDate() == null && argBusinessDate != null) || (
/*  172 */       getDAO_().getBusinessDate() != null && !getDAO_().getBusinessDate().equals(argBusinessDate))) {
/*  173 */       getDAO_().setBusinessDate(argBusinessDate);
/*  174 */       ev_postable = true;
/*  175 */       if (this._properties != null) {
/*      */         
/*  177 */         Iterator<KitComponentModifierPropertyModel> it = this._properties.iterator();
/*  178 */         while (it.hasNext())
/*      */         {
/*  180 */           ((KitComponentModifierPropertyModel)it.next()).setBusinessDate_noev(argBusinessDate);
/*      */         }
/*      */       } 
/*      */     } 
/*      */     
/*  185 */     return ev_postable;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public long getWorkstationId() {
/*  193 */     if (getDAO_().getWorkstationId() != null) {
/*  194 */       return getDAO_().getWorkstationId().longValue();
/*      */     }
/*      */     
/*  197 */     return 0L;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setWorkstationId(long argWorkstationId) {
/*  206 */     if (setWorkstationId_noev(argWorkstationId) && 
/*  207 */       this._events != null && 
/*  208 */       postEventsForChanges()) {
/*  209 */       this._events.post(IKitComponentModifier.SET_WORKSTATIONID, Long.valueOf(argWorkstationId));
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean setWorkstationId_noev(long argWorkstationId) {
/*  216 */     boolean ev_postable = false;
/*      */     
/*  218 */     if ((getDAO_().getWorkstationId() == null && Long.valueOf(argWorkstationId) != null) || (
/*  219 */       getDAO_().getWorkstationId() != null && !getDAO_().getWorkstationId().equals(Long.valueOf(argWorkstationId)))) {
/*  220 */       getDAO_().setWorkstationId(Long.valueOf(argWorkstationId));
/*  221 */       ev_postable = true;
/*  222 */       if (this._properties != null) {
/*      */         
/*  224 */         Iterator<KitComponentModifierPropertyModel> it = this._properties.iterator();
/*  225 */         while (it.hasNext())
/*      */         {
/*  227 */           ((KitComponentModifierPropertyModel)it.next()).setWorkstationId_noev(argWorkstationId);
/*      */         }
/*      */       } 
/*      */     } 
/*      */     
/*  232 */     return ev_postable;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public long getTransactionSequence() {
/*  240 */     if (getDAO_().getTransactionSequence() != null) {
/*  241 */       return getDAO_().getTransactionSequence().longValue();
/*      */     }
/*      */     
/*  244 */     return 0L;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setTransactionSequence(long argTransactionSequence) {
/*  253 */     if (setTransactionSequence_noev(argTransactionSequence) && 
/*  254 */       this._events != null && 
/*  255 */       postEventsForChanges()) {
/*  256 */       this._events.post(IKitComponentModifier.SET_TRANSACTIONSEQUENCE, Long.valueOf(argTransactionSequence));
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean setTransactionSequence_noev(long argTransactionSequence) {
/*  263 */     boolean ev_postable = false;
/*      */     
/*  265 */     if ((getDAO_().getTransactionSequence() == null && Long.valueOf(argTransactionSequence) != null) || (
/*  266 */       getDAO_().getTransactionSequence() != null && !getDAO_().getTransactionSequence().equals(Long.valueOf(argTransactionSequence)))) {
/*  267 */       getDAO_().setTransactionSequence(Long.valueOf(argTransactionSequence));
/*  268 */       ev_postable = true;
/*  269 */       if (this._properties != null) {
/*      */         
/*  271 */         Iterator<KitComponentModifierPropertyModel> it = this._properties.iterator();
/*  272 */         while (it.hasNext())
/*      */         {
/*  274 */           ((KitComponentModifierPropertyModel)it.next()).setTransactionSequence_noev(argTransactionSequence);
/*      */         }
/*      */       } 
/*      */     } 
/*      */     
/*  279 */     return ev_postable;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public int getRetailTransactionLineItemSequence() {
/*  287 */     if (getDAO_().getRetailTransactionLineItemSequence() != null) {
/*  288 */       return getDAO_().getRetailTransactionLineItemSequence().intValue();
/*      */     }
/*      */     
/*  291 */     return 0;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setRetailTransactionLineItemSequence(int argRetailTransactionLineItemSequence) {
/*  300 */     if (setRetailTransactionLineItemSequence_noev(argRetailTransactionLineItemSequence) && 
/*  301 */       this._events != null && 
/*  302 */       postEventsForChanges()) {
/*  303 */       this._events.post(IKitComponentModifier.SET_RETAILTRANSACTIONLINEITEMSEQUENCE, Integer.valueOf(argRetailTransactionLineItemSequence));
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean setRetailTransactionLineItemSequence_noev(int argRetailTransactionLineItemSequence) {
/*  310 */     boolean ev_postable = false;
/*      */     
/*  312 */     if ((getDAO_().getRetailTransactionLineItemSequence() == null && Integer.valueOf(argRetailTransactionLineItemSequence) != null) || (
/*  313 */       getDAO_().getRetailTransactionLineItemSequence() != null && !getDAO_().getRetailTransactionLineItemSequence().equals(Integer.valueOf(argRetailTransactionLineItemSequence)))) {
/*  314 */       getDAO_().setRetailTransactionLineItemSequence(Integer.valueOf(argRetailTransactionLineItemSequence));
/*  315 */       ev_postable = true;
/*  316 */       if (this._properties != null) {
/*      */         
/*  318 */         Iterator<KitComponentModifierPropertyModel> it = this._properties.iterator();
/*  319 */         while (it.hasNext())
/*      */         {
/*  321 */           ((KitComponentModifierPropertyModel)it.next()).setRetailTransactionLineItemSequence_noev(argRetailTransactionLineItemSequence);
/*      */         }
/*      */       } 
/*      */     } 
/*      */     
/*  326 */     return ev_postable;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public String getComponentItemId() {
/*  334 */     return getDAO_().getComponentItemId();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setComponentItemId(String argComponentItemId) {
/*  342 */     if (setComponentItemId_noev(argComponentItemId) && 
/*  343 */       this._events != null && 
/*  344 */       postEventsForChanges()) {
/*  345 */       this._events.post(IKitComponentModifier.SET_COMPONENTITEMID, argComponentItemId);
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean setComponentItemId_noev(String argComponentItemId) {
/*  352 */     boolean ev_postable = false;
/*      */     
/*  354 */     if ((getDAO_().getComponentItemId() == null && argComponentItemId != null) || (
/*  355 */       getDAO_().getComponentItemId() != null && !getDAO_().getComponentItemId().equals(argComponentItemId))) {
/*  356 */       getDAO_().setComponentItemId(argComponentItemId);
/*  357 */       ev_postable = true;
/*  358 */       if (this._properties != null) {
/*      */         
/*  360 */         Iterator<KitComponentModifierPropertyModel> it = this._properties.iterator();
/*  361 */         while (it.hasNext())
/*      */         {
/*  363 */           ((KitComponentModifierPropertyModel)it.next()).setComponentItemId_noev(argComponentItemId);
/*      */         }
/*      */       } 
/*      */     } 
/*      */     
/*  368 */     return ev_postable;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public long getSequenceNumber() {
/*  376 */     if (getDAO_().getSequenceNumber() != null) {
/*  377 */       return getDAO_().getSequenceNumber().longValue();
/*      */     }
/*      */     
/*  380 */     return 0L;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setSequenceNumber(long argSequenceNumber) {
/*  389 */     if (setSequenceNumber_noev(argSequenceNumber) && 
/*  390 */       this._events != null && 
/*  391 */       postEventsForChanges()) {
/*  392 */       this._events.post(IKitComponentModifier.SET_SEQUENCENUMBER, Long.valueOf(argSequenceNumber));
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean setSequenceNumber_noev(long argSequenceNumber) {
/*  399 */     boolean ev_postable = false;
/*      */     
/*  401 */     if ((getDAO_().getSequenceNumber() == null && Long.valueOf(argSequenceNumber) != null) || (
/*  402 */       getDAO_().getSequenceNumber() != null && !getDAO_().getSequenceNumber().equals(Long.valueOf(argSequenceNumber)))) {
/*  403 */       getDAO_().setSequenceNumber(Long.valueOf(argSequenceNumber));
/*  404 */       ev_postable = true;
/*  405 */       if (this._properties != null) {
/*      */         
/*  407 */         Iterator<KitComponentModifierPropertyModel> it = this._properties.iterator();
/*  408 */         while (it.hasNext())
/*      */         {
/*  410 */           ((KitComponentModifierPropertyModel)it.next()).setSequenceNumber_noev(argSequenceNumber);
/*      */         }
/*      */       } 
/*      */     } 
/*      */     
/*  415 */     return ev_postable;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public Date getCreateDate() {
/*  423 */     return getDAO_().getCreateDate();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setCreateDate(Date argCreateDate) {
/*  431 */     if (setCreateDate_noev(argCreateDate) && 
/*  432 */       this._events != null && 
/*  433 */       postEventsForChanges()) {
/*  434 */       this._events.post(IKitComponentModifier.SET_CREATEDATE, argCreateDate);
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean setCreateDate_noev(Date argCreateDate) {
/*  441 */     boolean ev_postable = false;
/*      */     
/*  443 */     if ((getDAO_().getCreateDate() == null && argCreateDate != null) || (
/*  444 */       getDAO_().getCreateDate() != null && !getDAO_().getCreateDate().equals(argCreateDate))) {
/*  445 */       getDAO_().setCreateDate(argCreateDate);
/*  446 */       ev_postable = true;
/*      */     } 
/*      */     
/*  449 */     return ev_postable;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public String getCreateUserId() {
/*  457 */     return getDAO_().getCreateUserId();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setCreateUserId(String argCreateUserId) {
/*  465 */     if (setCreateUserId_noev(argCreateUserId) && 
/*  466 */       this._events != null && 
/*  467 */       postEventsForChanges()) {
/*  468 */       this._events.post(IKitComponentModifier.SET_CREATEUSERID, argCreateUserId);
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean setCreateUserId_noev(String argCreateUserId) {
/*  475 */     boolean ev_postable = false;
/*      */     
/*  477 */     if ((getDAO_().getCreateUserId() == null && argCreateUserId != null) || (
/*  478 */       getDAO_().getCreateUserId() != null && !getDAO_().getCreateUserId().equals(argCreateUserId))) {
/*  479 */       getDAO_().setCreateUserId(argCreateUserId);
/*  480 */       ev_postable = true;
/*      */     } 
/*      */     
/*  483 */     return ev_postable;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public Date getUpdateDate() {
/*  491 */     return getDAO_().getUpdateDate();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setUpdateDate(Date argUpdateDate) {
/*  499 */     if (setUpdateDate_noev(argUpdateDate) && 
/*  500 */       this._events != null && 
/*  501 */       postEventsForChanges()) {
/*  502 */       this._events.post(IKitComponentModifier.SET_UPDATEDATE, argUpdateDate);
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean setUpdateDate_noev(Date argUpdateDate) {
/*  509 */     boolean ev_postable = false;
/*      */     
/*  511 */     if ((getDAO_().getUpdateDate() == null && argUpdateDate != null) || (
/*  512 */       getDAO_().getUpdateDate() != null && !getDAO_().getUpdateDate().equals(argUpdateDate))) {
/*  513 */       getDAO_().setUpdateDate(argUpdateDate);
/*  514 */       ev_postable = true;
/*      */     } 
/*      */     
/*  517 */     return ev_postable;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public String getUpdateUserId() {
/*  525 */     return getDAO_().getUpdateUserId();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setUpdateUserId(String argUpdateUserId) {
/*  533 */     if (setUpdateUserId_noev(argUpdateUserId) && 
/*  534 */       this._events != null && 
/*  535 */       postEventsForChanges()) {
/*  536 */       this._events.post(IKitComponentModifier.SET_UPDATEUSERID, argUpdateUserId);
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean setUpdateUserId_noev(String argUpdateUserId) {
/*  543 */     boolean ev_postable = false;
/*      */     
/*  545 */     if ((getDAO_().getUpdateUserId() == null && argUpdateUserId != null) || (
/*  546 */       getDAO_().getUpdateUserId() != null && !getDAO_().getUpdateUserId().equals(argUpdateUserId))) {
/*  547 */       getDAO_().setUpdateUserId(argUpdateUserId);
/*  548 */       ev_postable = true;
/*      */     } 
/*      */     
/*  551 */     return ev_postable;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public String getComponentItemDesc() {
/*  559 */     return getDAO_().getComponentItemDesc();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setComponentItemDesc(String argComponentItemDesc) {
/*  567 */     if (setComponentItemDesc_noev(argComponentItemDesc) && 
/*  568 */       this._events != null && 
/*  569 */       postEventsForChanges()) {
/*  570 */       this._events.post(IKitComponentModifier.SET_COMPONENTITEMDESC, argComponentItemDesc);
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean setComponentItemDesc_noev(String argComponentItemDesc) {
/*  577 */     boolean ev_postable = false;
/*      */     
/*  579 */     if ((getDAO_().getComponentItemDesc() == null && argComponentItemDesc != null) || (
/*  580 */       getDAO_().getComponentItemDesc() != null && !getDAO_().getComponentItemDesc().equals(argComponentItemDesc))) {
/*  581 */       getDAO_().setComponentItemDesc(argComponentItemDesc);
/*  582 */       ev_postable = true;
/*      */     } 
/*      */     
/*  585 */     return ev_postable;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public String getKitItemId() {
/*  593 */     return getDAO_().getKitItemId();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setKitItemId(String argKitItemId) {
/*  601 */     if (setKitItemId_noev(argKitItemId) && 
/*  602 */       this._events != null && 
/*  603 */       postEventsForChanges()) {
/*  604 */       this._events.post(IKitComponentModifier.SET_KITITEMID, argKitItemId);
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean setKitItemId_noev(String argKitItemId) {
/*  611 */     boolean ev_postable = false;
/*      */     
/*  613 */     if ((getDAO_().getKitItemId() == null && argKitItemId != null) || (
/*  614 */       getDAO_().getKitItemId() != null && !getDAO_().getKitItemId().equals(argKitItemId))) {
/*  615 */       getDAO_().setKitItemId(argKitItemId);
/*  616 */       ev_postable = true;
/*      */     } 
/*      */     
/*  619 */     return ev_postable;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public int getDisplayOrder() {
/*  627 */     if (getDAO_().getDisplayOrder() != null) {
/*  628 */       return getDAO_().getDisplayOrder().intValue();
/*      */     }
/*      */     
/*  631 */     return 0;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setDisplayOrder(int argDisplayOrder) {
/*  640 */     if (setDisplayOrder_noev(argDisplayOrder) && 
/*  641 */       this._events != null && 
/*  642 */       postEventsForChanges()) {
/*  643 */       this._events.post(IKitComponentModifier.SET_DISPLAYORDER, Integer.valueOf(argDisplayOrder));
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean setDisplayOrder_noev(int argDisplayOrder) {
/*  650 */     boolean ev_postable = false;
/*      */     
/*  652 */     if ((getDAO_().getDisplayOrder() == null && Integer.valueOf(argDisplayOrder) != null) || (
/*  653 */       getDAO_().getDisplayOrder() != null && !getDAO_().getDisplayOrder().equals(Integer.valueOf(argDisplayOrder)))) {
/*  654 */       getDAO_().setDisplayOrder(Integer.valueOf(argDisplayOrder));
/*  655 */       ev_postable = true;
/*      */     } 
/*      */     
/*  658 */     return ev_postable;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public int getQuantity() {
/*  666 */     if (getDAO_().getQuantity() != null) {
/*  667 */       return getDAO_().getQuantity().intValue();
/*      */     }
/*      */     
/*  670 */     return 0;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setQuantity(int argQuantity) {
/*  679 */     if (setQuantity_noev(argQuantity) && 
/*  680 */       this._events != null && 
/*  681 */       postEventsForChanges()) {
/*  682 */       this._events.post(IKitComponentModifier.SET_QUANTITY, Integer.valueOf(argQuantity));
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean setQuantity_noev(int argQuantity) {
/*  689 */     boolean ev_postable = false;
/*      */     
/*  691 */     if ((getDAO_().getQuantity() == null && Integer.valueOf(argQuantity) != null) || (
/*  692 */       getDAO_().getQuantity() != null && !getDAO_().getQuantity().equals(Integer.valueOf(argQuantity)))) {
/*  693 */       getDAO_().setQuantity(Integer.valueOf(argQuantity));
/*  694 */       ev_postable = true;
/*      */     } 
/*      */     
/*  697 */     return ev_postable;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public String getSerialNumber() {
/*  705 */     return getDAO_().getSerialNumber();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setSerialNumber(String argSerialNumber) {
/*  713 */     if (setSerialNumber_noev(argSerialNumber) && 
/*  714 */       this._events != null && 
/*  715 */       postEventsForChanges()) {
/*  716 */       this._events.post(IKitComponentModifier.SET_SERIALNUMBER, argSerialNumber);
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean setSerialNumber_noev(String argSerialNumber) {
/*  723 */     boolean ev_postable = false;
/*      */     
/*  725 */     if ((getDAO_().getSerialNumber() == null && argSerialNumber != null) || (
/*  726 */       getDAO_().getSerialNumber() != null && !getDAO_().getSerialNumber().equals(argSerialNumber))) {
/*  727 */       getDAO_().setSerialNumber(argSerialNumber);
/*  728 */       ev_postable = true;
/*      */     } 
/*      */     
/*  731 */     return ev_postable;
/*      */   }
/*      */   
/*      */   protected IKitComponentModifierProperty newProperty(String argPropertyName) {
/*  735 */     KitComponentModifierPropertyId id = new KitComponentModifierPropertyId();
/*      */     
/*  737 */     id.setRetailLocationId(Long.valueOf(getRetailLocationId()));
/*  738 */     id.setBusinessDate(getBusinessDate());
/*  739 */     id.setWorkstationId(Long.valueOf(getWorkstationId()));
/*  740 */     id.setTransactionSequence(Long.valueOf(getTransactionSequence()));
/*  741 */     id.setRetailTransactionLineItemSequence(Integer.valueOf(getRetailTransactionLineItemSequence()));
/*  742 */     id.setComponentItemId(getComponentItemId());
/*  743 */     id.setSequenceNumber(Long.valueOf(getSequenceNumber()));
/*  744 */     id.setPropertyCode(argPropertyName);
/*      */     
/*  746 */     IKitComponentModifierProperty prop = (IKitComponentModifierProperty)DataFactory.getInstance().createNewObject((IObjectId)id, IKitComponentModifierProperty.class);
/*  747 */     return prop;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   @Relationship(name = "KitComponent")
/*      */   public IKitComponent getKitComponent() {
/*  759 */     return this._kitComponent;
/*      */   }
/*      */ 
/*      */   
/*      */   public void setKitComponent(IKitComponent argKitComponent) {
/*  764 */     if (argKitComponent == null) {
/*      */       
/*  766 */       getDAO_().setKitItemId(null);
/*  767 */       if (this._kitComponent != null)
/*      */       {
/*  769 */         if (postEventsForChanges()) {
/*  770 */           this._eventManager.deregisterEventHandler((IEventAware)this._eventCascade, (IEventSource)new EventDescriptor(this._kitComponent));
/*      */         }
/*      */       }
/*      */     } else {
/*      */       
/*  775 */       getDAO_().setKitItemId(argKitComponent.getKitItemId());
/*      */       
/*  777 */       if (postEventsForChanges()) {
/*  778 */         this._eventManager.registerEventHandler((IEventAware)this._eventCascade, (IEventSource)new EventDescriptor(argKitComponent));
/*      */       }
/*      */     } 
/*      */     
/*  782 */     this._kitComponent = argKitComponent;
/*  783 */     if (postEventsForChanges()) {
/*  784 */       this._events.post(IKitComponentModifier.SET_KITCOMPONENT, argKitComponent);
/*      */     }
/*      */   }
/*      */   
/*      */   @Relationship(name = "Properties")
/*      */   public List<IKitComponentModifierProperty> getProperties() {
/*  790 */     if (this._properties == null) {
/*  791 */       this._properties = new HistoricalList(null);
/*      */     }
/*  793 */     return (List<IKitComponentModifierProperty>)this._properties;
/*      */   }
/*      */   
/*      */   public void setProperties(List<IKitComponentModifierProperty> argProperties) {
/*  797 */     if (this._properties == null) {
/*  798 */       this._properties = new HistoricalList(argProperties);
/*      */     } else {
/*  800 */       this._properties.setCurrentList(argProperties);
/*      */     } 
/*      */     
/*  803 */     for (IKitComponentModifierProperty child : this._properties) {
/*  804 */       KitComponentModifierPropertyModel model = (KitComponentModifierPropertyModel)child;
/*  805 */       model.setOrganizationId_noev(getOrganizationId());
/*  806 */       model.setRetailLocationId_noev(getRetailLocationId());
/*  807 */       model.setBusinessDate_noev(getBusinessDate());
/*  808 */       model.setWorkstationId_noev(getWorkstationId());
/*  809 */       model.setTransactionSequence_noev(getTransactionSequence());
/*  810 */       model.setRetailTransactionLineItemSequence_noev(getRetailTransactionLineItemSequence());
/*  811 */       model.setComponentItemId_noev(getComponentItemId());
/*  812 */       model.setSequenceNumber_noev(getSequenceNumber());
/*  813 */       if (child instanceof IDataModelImpl) {
/*  814 */         IDataAccessObject childDao = ((IDataModelImpl)child).getDAO();
/*  815 */         if (StringUtils.isEmpty(childDao.getOriginDataSource()) && 
/*  816 */           !StringUtils.isEmpty(getDAO().getOriginDataSource())) {
/*  817 */           childDao.setOriginDataSource(getDAO().getOriginDataSource());
/*      */         }
/*      */       } 
/*  820 */       if (postEventsForChanges()) {
/*  821 */         this._eventManager.registerEventHandler((IEventAware)this._eventCascade, (IEventSource)child);
/*      */       }
/*      */     } 
/*      */   }
/*      */   
/*      */   public void addKitComponentModifierProperty(IKitComponentModifierProperty argKitComponentModifierProperty) {
/*  827 */     if (this._properties == null) {
/*  828 */       this._properties = new HistoricalList(null);
/*      */     }
/*  830 */     argKitComponentModifierProperty.setOrganizationId(getOrganizationId());
/*  831 */     argKitComponentModifierProperty.setRetailLocationId(getRetailLocationId());
/*  832 */     argKitComponentModifierProperty.setBusinessDate(getBusinessDate());
/*  833 */     argKitComponentModifierProperty.setWorkstationId(getWorkstationId());
/*  834 */     argKitComponentModifierProperty.setTransactionSequence(getTransactionSequence());
/*  835 */     argKitComponentModifierProperty.setRetailTransactionLineItemSequence(getRetailTransactionLineItemSequence());
/*  836 */     argKitComponentModifierProperty.setComponentItemId(getComponentItemId());
/*  837 */     argKitComponentModifierProperty.setSequenceNumber(getSequenceNumber());
/*  838 */     if (argKitComponentModifierProperty instanceof IDataModelImpl) {
/*  839 */       IDataAccessObject childDao = ((IDataModelImpl)argKitComponentModifierProperty).getDAO();
/*  840 */       if (StringUtils.isEmpty(childDao.getOriginDataSource()) && 
/*  841 */         !StringUtils.isEmpty(getDAO().getOriginDataSource())) {
/*  842 */         childDao.setOriginDataSource(getDAO().getOriginDataSource());
/*      */       }
/*      */     } 
/*      */ 
/*      */     
/*  847 */     if (postEventsForChanges()) {
/*  848 */       this._eventManager.registerEventHandler((IEventAware)this._eventCascade, (IEventSource)new EventDescriptor(argKitComponentModifierProperty));
/*      */     }
/*      */     
/*  851 */     this._properties.add(argKitComponentModifierProperty);
/*  852 */     if (postEventsForChanges()) {
/*  853 */       this._events.post(IKitComponentModifier.ADD_PROPERTIES, argKitComponentModifierProperty);
/*      */     }
/*      */   }
/*      */   
/*      */   public void removeKitComponentModifierProperty(IKitComponentModifierProperty argKitComponentModifierProperty) {
/*  858 */     if (this._properties != null) {
/*      */       
/*  860 */       if (postEventsForChanges()) {
/*  861 */         this._eventManager.deregisterEventHandler((IEventAware)this._eventCascade, (IEventSource)new EventDescriptor(argKitComponentModifierProperty));
/*      */       }
/*  863 */       this._properties.remove(argKitComponentModifierProperty);
/*  864 */       if (postEventsForChanges()) {
/*  865 */         this._events.post(IKitComponentModifier.REMOVE_PROPERTIES, argKitComponentModifierProperty);
/*      */       }
/*      */     } 
/*      */   }
/*      */   
/*      */   public void setParentLine(ISaleReturnLineItem argParentLine) {
/*  871 */     this._parentLine = argParentLine;
/*      */   }
/*      */   
/*      */   public ISaleReturnLineItem getParentLine() {
/*  875 */     return this._parentLine;
/*      */   }
/*      */ 
/*      */   
/*      */   public Object getValue(String argFieldId) {
/*  880 */     if ("KitComponent".equals(argFieldId)) {
/*  881 */       return getKitComponent();
/*      */     }
/*  883 */     if ("Properties".equals(argFieldId)) {
/*  884 */       return getProperties();
/*      */     }
/*  886 */     if ("KitComponentModifierExtension".equals(argFieldId)) {
/*  887 */       return this._myExtension;
/*      */     }
/*      */     
/*  890 */     return super.getValue(argFieldId);
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public void setValue(String argFieldId, Object argValue) {
/*  896 */     if ("KitComponent".equals(argFieldId)) {
/*  897 */       setKitComponent((IKitComponent)argValue);
/*      */     }
/*  899 */     else if ("Properties".equals(argFieldId)) {
/*  900 */       setProperties(changeToList(argValue, IKitComponentModifierProperty.class));
/*      */     }
/*  902 */     else if ("KitComponentModifierExtension".equals(argFieldId)) {
/*  903 */       this._myExtension = (IDataModel)argValue;
/*      */     } else {
/*      */       
/*  906 */       super.setValue(argFieldId, argValue);
/*      */     } 
/*      */   }
/*      */ 
/*      */   
/*      */   public void setDependencies(IPersistenceDefaults argPD, EventManager argEM) {
/*  912 */     this._persistenceDefaults = argPD;
/*  913 */     this._daoImpl.setPersistenceDefaults(argPD);
/*  914 */     this._eventManager = argEM;
/*  915 */     this._events = (Eventor)new ModelEventor((IDataModel)this, argEM);
/*  916 */     this._eventCascade = (EventHandler)new CascadingHandler(this);
/*  917 */     if (this._kitComponent != null) {
/*  918 */       ((IDataModelImpl)this._kitComponent).setDependencies(argPD, argEM);
/*      */     }
/*  920 */     if (this._properties != null) {
/*  921 */       for (IKitComponentModifierProperty relationship : this._properties) {
/*  922 */         ((IDataModelImpl)relationship).setDependencies(argPD, argEM);
/*      */       }
/*      */     }
/*      */   }
/*      */   
/*      */   public IDataModel getKitComponentModifierExt() {
/*  928 */     return this._myExtension;
/*      */   }
/*      */   
/*      */   public void setKitComponentModifierExt(IDataModel argExt) {
/*  932 */     this._myExtension = argExt;
/*      */   }
/*      */ 
/*      */   
/*      */   public void startTransaction() {
/*  937 */     if (this._alreadyInStart) {
/*      */       return;
/*      */     }
/*      */     
/*  941 */     this._alreadyInStart = true;
/*      */ 
/*      */     
/*  944 */     super.startTransaction();
/*      */     
/*  946 */     this._kitComponentSavepoint = this._kitComponent;
/*  947 */     if (this._kitComponent != null) {
/*  948 */       this._kitComponent.startTransaction();
/*      */     }
/*      */     
/*  951 */     this._propertiesSavepoint = this._properties;
/*  952 */     if (this._properties != null) {
/*  953 */       this._propertiesSavepoint = new HistoricalList((List)this._properties);
/*  954 */       Iterator<IDataModel> it = this._properties.iterator();
/*  955 */       while (it.hasNext()) {
/*  956 */         ((IDataModel)it.next()).startTransaction();
/*      */       }
/*      */     } 
/*      */ 
/*      */     
/*  961 */     this._alreadyInStart = false;
/*      */   }
/*      */ 
/*      */   
/*      */   public void rollbackChanges() {
/*  966 */     if (isAlreadyRolledBack()) {
/*      */       return;
/*      */     }
/*  969 */     super.rollbackChanges();
/*      */     
/*  971 */     this._kitComponent = this._kitComponentSavepoint;
/*  972 */     this._kitComponentSavepoint = null;
/*  973 */     if (this._kitComponent != null) {
/*  974 */       this._kitComponent.rollbackChanges();
/*      */     }
/*      */     
/*  977 */     this._properties = this._propertiesSavepoint;
/*  978 */     this._propertiesSavepoint = null;
/*  979 */     if (this._properties != null) {
/*  980 */       Iterator<IDataModel> it = this._properties.iterator();
/*  981 */       while (it.hasNext()) {
/*  982 */         ((IDataModel)it.next()).rollbackChanges();
/*      */       }
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public void commitTransaction() {
/*  990 */     if (this._alreadyInCommit) {
/*      */       return;
/*      */     }
/*  993 */     this._alreadyInCommit = true;
/*      */ 
/*      */     
/*  996 */     super.commitTransaction();
/*      */     
/*  998 */     this._kitComponentSavepoint = this._kitComponent;
/*  999 */     if (this._kitComponent != null) {
/* 1000 */       this._kitComponent.commitTransaction();
/*      */     }
/*      */     
/* 1003 */     this._propertiesSavepoint = this._properties;
/* 1004 */     if (this._properties != null) {
/* 1005 */       Iterator<IDataModel> it = this._properties.iterator();
/* 1006 */       while (it.hasNext()) {
/* 1007 */         ((IDataModel)it.next()).commitTransaction();
/*      */       }
/* 1009 */       this._properties = new HistoricalList((List)this._properties);
/*      */     } 
/*      */ 
/*      */     
/* 1013 */     this._alreadyInCommit = false;
/*      */   }
/*      */ 
/*      */   
/*      */   private void readObject(ObjectInputStream argStream) throws IOException, ClassNotFoundException {
/* 1018 */     argStream.defaultReadObject();
/*      */   }
/*      */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\trl\impl\KitComponentModifierModel.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */