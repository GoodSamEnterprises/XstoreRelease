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
/*      */ import dtv.xst.dao.trl.ILineItemAssociationModifier;
/*      */ import dtv.xst.dao.trl.ILineItemAssociationModifierProperty;
/*      */ import dtv.xst.dao.trl.ILineItemAssociationTypeCode;
/*      */ import dtv.xst.dao.trl.ISaleReturnLineItem;
/*      */ import dtv.xst.dao.trl.LineItemAssociationModifierPropertyId;
/*      */ import java.io.IOException;
/*      */ import java.io.ObjectInputStream;
/*      */ import java.util.Date;
/*      */ import java.util.Iterator;
/*      */ import java.util.List;
/*      */ 
/*      */ public class LineItemAssociationModifierModel extends AbstractDataModelWithPropertyImpl<ILineItemAssociationModifierProperty> implements ILineItemAssociationModifier {
/*      */   private static final long serialVersionUID = 387442097L;
/*      */   private ISaleReturnLineItem _parentLine;
/*      */   private transient boolean _alreadyInStart = false;
/*      */   private transient boolean _alreadyInCommit = false;
/*      */   private IDataModel _myExtension;
/*      */   
/*      */   public String toString() {
/*   37 */     return super.toString() + " Id: " + getObjectId();
/*      */   }
/*      */   private ISaleReturnLineItem _childLineItem; private transient ISaleReturnLineItem _childLineItemSavepoint; private ILineItemAssociationTypeCode _lineItemAssociationTypeCode; private transient ILineItemAssociationTypeCode _lineItemAssociationTypeCodeSavepoint; private HistoricalList<ILineItemAssociationModifierProperty> _properties; private transient HistoricalList<ILineItemAssociationModifierProperty> _propertiesSavepoint;
/*      */   
/*      */   public void initDAO() {
/*   42 */     setDAO((IDataAccessObject)new LineItemAssociationModifierDAO());
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private LineItemAssociationModifierDAO getDAO_() {
/*   50 */     return (LineItemAssociationModifierDAO)this._daoImpl;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public Date getBusinessDate() {
/*   58 */     return getDAO_().getBusinessDate();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setBusinessDate(Date argBusinessDate) {
/*   66 */     if (setBusinessDate_noev(argBusinessDate) && 
/*   67 */       this._events != null && 
/*   68 */       postEventsForChanges()) {
/*   69 */       this._events.post(ILineItemAssociationModifier.SET_BUSINESSDATE, argBusinessDate);
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean setBusinessDate_noev(Date argBusinessDate) {
/*   76 */     boolean ev_postable = false;
/*      */     
/*   78 */     if ((getDAO_().getBusinessDate() == null && argBusinessDate != null) || (
/*   79 */       getDAO_().getBusinessDate() != null && !getDAO_().getBusinessDate().equals(argBusinessDate))) {
/*   80 */       getDAO_().setBusinessDate(argBusinessDate);
/*   81 */       ev_postable = true;
/*   82 */       if (this._properties != null) {
/*      */         
/*   84 */         Iterator<LineItemAssociationModifierPropertyModel> it = this._properties.iterator();
/*   85 */         while (it.hasNext())
/*      */         {
/*   87 */           ((LineItemAssociationModifierPropertyModel)it.next()).setBusinessDate_noev(argBusinessDate);
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
/*      */   public int getLineItemAssociationModifierSequence() {
/*  100 */     if (getDAO_().getLineItemAssociationModifierSequence() != null) {
/*  101 */       return getDAO_().getLineItemAssociationModifierSequence().intValue();
/*      */     }
/*      */     
/*  104 */     return 0;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setLineItemAssociationModifierSequence(int argLineItemAssociationModifierSequence) {
/*  113 */     if (setLineItemAssociationModifierSequence_noev(argLineItemAssociationModifierSequence) && 
/*  114 */       this._events != null && 
/*  115 */       postEventsForChanges()) {
/*  116 */       this._events.post(ILineItemAssociationModifier.SET_LINEITEMASSOCIATIONMODIFIERSEQUENCE, Integer.valueOf(argLineItemAssociationModifierSequence));
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean setLineItemAssociationModifierSequence_noev(int argLineItemAssociationModifierSequence) {
/*  123 */     boolean ev_postable = false;
/*      */     
/*  125 */     if ((getDAO_().getLineItemAssociationModifierSequence() == null && Integer.valueOf(argLineItemAssociationModifierSequence) != null) || (
/*  126 */       getDAO_().getLineItemAssociationModifierSequence() != null && !getDAO_().getLineItemAssociationModifierSequence().equals(Integer.valueOf(argLineItemAssociationModifierSequence)))) {
/*  127 */       getDAO_().setLineItemAssociationModifierSequence(Integer.valueOf(argLineItemAssociationModifierSequence));
/*  128 */       ev_postable = true;
/*  129 */       if (this._properties != null) {
/*      */         
/*  131 */         Iterator<LineItemAssociationModifierPropertyModel> it = this._properties.iterator();
/*  132 */         while (it.hasNext())
/*      */         {
/*  134 */           ((LineItemAssociationModifierPropertyModel)it.next()).setLineItemAssociationModifierSequence_noev(argLineItemAssociationModifierSequence);
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
/*      */   public long getOrganizationId() {
/*  147 */     if (getDAO_().getOrganizationId() != null) {
/*  148 */       return getDAO_().getOrganizationId().longValue();
/*      */     }
/*      */     
/*  151 */     return 0L;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setOrganizationId(long argOrganizationId) {
/*  160 */     if (setOrganizationId_noev(argOrganizationId) && 
/*  161 */       this._events != null && 
/*  162 */       postEventsForChanges()) {
/*  163 */       this._events.post(ILineItemAssociationModifier.SET_ORGANIZATIONID, Long.valueOf(argOrganizationId));
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean setOrganizationId_noev(long argOrganizationId) {
/*  170 */     boolean ev_postable = false;
/*      */     
/*  172 */     if ((getDAO_().getOrganizationId() == null && Long.valueOf(argOrganizationId) != null) || (
/*  173 */       getDAO_().getOrganizationId() != null && !getDAO_().getOrganizationId().equals(Long.valueOf(argOrganizationId)))) {
/*  174 */       getDAO_().setOrganizationId(Long.valueOf(argOrganizationId));
/*  175 */       ev_postable = true;
/*  176 */       if (this._properties != null) {
/*      */         
/*  178 */         Iterator<LineItemAssociationModifierPropertyModel> it = this._properties.iterator();
/*  179 */         while (it.hasNext())
/*      */         {
/*  181 */           ((LineItemAssociationModifierPropertyModel)it.next()).setOrganizationId_noev(argOrganizationId);
/*      */         }
/*      */       } 
/*      */     } 
/*      */     
/*  186 */     return ev_postable;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public long getRetailLocationId() {
/*  194 */     if (getDAO_().getRetailLocationId() != null) {
/*  195 */       return getDAO_().getRetailLocationId().longValue();
/*      */     }
/*      */     
/*  198 */     return 0L;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setRetailLocationId(long argRetailLocationId) {
/*  207 */     if (setRetailLocationId_noev(argRetailLocationId) && 
/*  208 */       this._events != null && 
/*  209 */       postEventsForChanges()) {
/*  210 */       this._events.post(ILineItemAssociationModifier.SET_RETAILLOCATIONID, Long.valueOf(argRetailLocationId));
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean setRetailLocationId_noev(long argRetailLocationId) {
/*  217 */     boolean ev_postable = false;
/*      */     
/*  219 */     if ((getDAO_().getRetailLocationId() == null && Long.valueOf(argRetailLocationId) != null) || (
/*  220 */       getDAO_().getRetailLocationId() != null && !getDAO_().getRetailLocationId().equals(Long.valueOf(argRetailLocationId)))) {
/*  221 */       getDAO_().setRetailLocationId(Long.valueOf(argRetailLocationId));
/*  222 */       ev_postable = true;
/*  223 */       if (this._properties != null) {
/*      */         
/*  225 */         Iterator<LineItemAssociationModifierPropertyModel> it = this._properties.iterator();
/*  226 */         while (it.hasNext())
/*      */         {
/*  228 */           ((LineItemAssociationModifierPropertyModel)it.next()).setRetailLocationId_noev(argRetailLocationId);
/*      */         }
/*      */       } 
/*      */     } 
/*      */     
/*  233 */     return ev_postable;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public int getRetailTransactionLineItemSequence() {
/*  241 */     if (getDAO_().getRetailTransactionLineItemSequence() != null) {
/*  242 */       return getDAO_().getRetailTransactionLineItemSequence().intValue();
/*      */     }
/*      */     
/*  245 */     return 0;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setRetailTransactionLineItemSequence(int argRetailTransactionLineItemSequence) {
/*  254 */     if (setRetailTransactionLineItemSequence_noev(argRetailTransactionLineItemSequence) && 
/*  255 */       this._events != null && 
/*  256 */       postEventsForChanges()) {
/*  257 */       this._events.post(ILineItemAssociationModifier.SET_RETAILTRANSACTIONLINEITEMSEQUENCE, Integer.valueOf(argRetailTransactionLineItemSequence));
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean setRetailTransactionLineItemSequence_noev(int argRetailTransactionLineItemSequence) {
/*  264 */     boolean ev_postable = false;
/*      */     
/*  266 */     if ((getDAO_().getRetailTransactionLineItemSequence() == null && Integer.valueOf(argRetailTransactionLineItemSequence) != null) || (
/*  267 */       getDAO_().getRetailTransactionLineItemSequence() != null && !getDAO_().getRetailTransactionLineItemSequence().equals(Integer.valueOf(argRetailTransactionLineItemSequence)))) {
/*  268 */       getDAO_().setRetailTransactionLineItemSequence(Integer.valueOf(argRetailTransactionLineItemSequence));
/*  269 */       ev_postable = true;
/*  270 */       if (this._properties != null) {
/*      */         
/*  272 */         Iterator<LineItemAssociationModifierPropertyModel> it = this._properties.iterator();
/*  273 */         while (it.hasNext())
/*      */         {
/*  275 */           ((LineItemAssociationModifierPropertyModel)it.next()).setRetailTransactionLineItemSequence_noev(argRetailTransactionLineItemSequence);
/*      */         }
/*      */       } 
/*      */     } 
/*      */     
/*  280 */     return ev_postable;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public long getTransactionSequence() {
/*  288 */     if (getDAO_().getTransactionSequence() != null) {
/*  289 */       return getDAO_().getTransactionSequence().longValue();
/*      */     }
/*      */     
/*  292 */     return 0L;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setTransactionSequence(long argTransactionSequence) {
/*  301 */     if (setTransactionSequence_noev(argTransactionSequence) && 
/*  302 */       this._events != null && 
/*  303 */       postEventsForChanges()) {
/*  304 */       this._events.post(ILineItemAssociationModifier.SET_TRANSACTIONSEQUENCE, Long.valueOf(argTransactionSequence));
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean setTransactionSequence_noev(long argTransactionSequence) {
/*  311 */     boolean ev_postable = false;
/*      */     
/*  313 */     if ((getDAO_().getTransactionSequence() == null && Long.valueOf(argTransactionSequence) != null) || (
/*  314 */       getDAO_().getTransactionSequence() != null && !getDAO_().getTransactionSequence().equals(Long.valueOf(argTransactionSequence)))) {
/*  315 */       getDAO_().setTransactionSequence(Long.valueOf(argTransactionSequence));
/*  316 */       ev_postable = true;
/*  317 */       if (this._properties != null) {
/*      */         
/*  319 */         Iterator<LineItemAssociationModifierPropertyModel> it = this._properties.iterator();
/*  320 */         while (it.hasNext())
/*      */         {
/*  322 */           ((LineItemAssociationModifierPropertyModel)it.next()).setTransactionSequence_noev(argTransactionSequence);
/*      */         }
/*      */       } 
/*      */     } 
/*      */     
/*  327 */     return ev_postable;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public long getWorkstationId() {
/*  335 */     if (getDAO_().getWorkstationId() != null) {
/*  336 */       return getDAO_().getWorkstationId().longValue();
/*      */     }
/*      */     
/*  339 */     return 0L;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setWorkstationId(long argWorkstationId) {
/*  348 */     if (setWorkstationId_noev(argWorkstationId) && 
/*  349 */       this._events != null && 
/*  350 */       postEventsForChanges()) {
/*  351 */       this._events.post(ILineItemAssociationModifier.SET_WORKSTATIONID, Long.valueOf(argWorkstationId));
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean setWorkstationId_noev(long argWorkstationId) {
/*  358 */     boolean ev_postable = false;
/*      */     
/*  360 */     if ((getDAO_().getWorkstationId() == null && Long.valueOf(argWorkstationId) != null) || (
/*  361 */       getDAO_().getWorkstationId() != null && !getDAO_().getWorkstationId().equals(Long.valueOf(argWorkstationId)))) {
/*  362 */       getDAO_().setWorkstationId(Long.valueOf(argWorkstationId));
/*  363 */       ev_postable = true;
/*  364 */       if (this._properties != null) {
/*      */         
/*  366 */         Iterator<LineItemAssociationModifierPropertyModel> it = this._properties.iterator();
/*  367 */         while (it.hasNext())
/*      */         {
/*  369 */           ((LineItemAssociationModifierPropertyModel)it.next()).setWorkstationId_noev(argWorkstationId);
/*      */         }
/*      */       } 
/*      */     } 
/*      */     
/*  374 */     return ev_postable;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public Date getCreateDate() {
/*  382 */     return getDAO_().getCreateDate();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setCreateDate(Date argCreateDate) {
/*  390 */     if (setCreateDate_noev(argCreateDate) && 
/*  391 */       this._events != null && 
/*  392 */       postEventsForChanges()) {
/*  393 */       this._events.post(ILineItemAssociationModifier.SET_CREATEDATE, argCreateDate);
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean setCreateDate_noev(Date argCreateDate) {
/*  400 */     boolean ev_postable = false;
/*      */     
/*  402 */     if ((getDAO_().getCreateDate() == null && argCreateDate != null) || (
/*  403 */       getDAO_().getCreateDate() != null && !getDAO_().getCreateDate().equals(argCreateDate))) {
/*  404 */       getDAO_().setCreateDate(argCreateDate);
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
/*      */   public String getCreateUserId() {
/*  416 */     return getDAO_().getCreateUserId();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setCreateUserId(String argCreateUserId) {
/*  424 */     if (setCreateUserId_noev(argCreateUserId) && 
/*  425 */       this._events != null && 
/*  426 */       postEventsForChanges()) {
/*  427 */       this._events.post(ILineItemAssociationModifier.SET_CREATEUSERID, argCreateUserId);
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean setCreateUserId_noev(String argCreateUserId) {
/*  434 */     boolean ev_postable = false;
/*      */     
/*  436 */     if ((getDAO_().getCreateUserId() == null && argCreateUserId != null) || (
/*  437 */       getDAO_().getCreateUserId() != null && !getDAO_().getCreateUserId().equals(argCreateUserId))) {
/*  438 */       getDAO_().setCreateUserId(argCreateUserId);
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
/*      */   public Date getUpdateDate() {
/*  450 */     return getDAO_().getUpdateDate();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setUpdateDate(Date argUpdateDate) {
/*  458 */     if (setUpdateDate_noev(argUpdateDate) && 
/*  459 */       this._events != null && 
/*  460 */       postEventsForChanges()) {
/*  461 */       this._events.post(ILineItemAssociationModifier.SET_UPDATEDATE, argUpdateDate);
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean setUpdateDate_noev(Date argUpdateDate) {
/*  468 */     boolean ev_postable = false;
/*      */     
/*  470 */     if ((getDAO_().getUpdateDate() == null && argUpdateDate != null) || (
/*  471 */       getDAO_().getUpdateDate() != null && !getDAO_().getUpdateDate().equals(argUpdateDate))) {
/*  472 */       getDAO_().setUpdateDate(argUpdateDate);
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
/*      */   public String getUpdateUserId() {
/*  484 */     return getDAO_().getUpdateUserId();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setUpdateUserId(String argUpdateUserId) {
/*  492 */     if (setUpdateUserId_noev(argUpdateUserId) && 
/*  493 */       this._events != null && 
/*  494 */       postEventsForChanges()) {
/*  495 */       this._events.post(ILineItemAssociationModifier.SET_UPDATEUSERID, argUpdateUserId);
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean setUpdateUserId_noev(String argUpdateUserId) {
/*  502 */     boolean ev_postable = false;
/*      */     
/*  504 */     if ((getDAO_().getUpdateUserId() == null && argUpdateUserId != null) || (
/*  505 */       getDAO_().getUpdateUserId() != null && !getDAO_().getUpdateUserId().equals(argUpdateUserId))) {
/*  506 */       getDAO_().setUpdateUserId(argUpdateUserId);
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
/*      */   public Date getChildBusinessDate() {
/*  518 */     return getDAO_().getChildBusinessDate();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setChildBusinessDate(Date argChildBusinessDate) {
/*  526 */     if (setChildBusinessDate_noev(argChildBusinessDate) && 
/*  527 */       this._events != null && 
/*  528 */       postEventsForChanges()) {
/*  529 */       this._events.post(ILineItemAssociationModifier.SET_CHILDBUSINESSDATE, argChildBusinessDate);
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean setChildBusinessDate_noev(Date argChildBusinessDate) {
/*  536 */     boolean ev_postable = false;
/*      */     
/*  538 */     if ((getDAO_().getChildBusinessDate() == null && argChildBusinessDate != null) || (
/*  539 */       getDAO_().getChildBusinessDate() != null && !getDAO_().getChildBusinessDate().equals(argChildBusinessDate))) {
/*  540 */       getDAO_().setChildBusinessDate(argChildBusinessDate);
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
/*      */   public long getChildRetailLocationId() {
/*  552 */     if (getDAO_().getChildRetailLocationId() != null) {
/*  553 */       return getDAO_().getChildRetailLocationId().longValue();
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
/*      */   public void setChildRetailLocationId(long argChildRetailLocationId) {
/*  565 */     if (setChildRetailLocationId_noev(argChildRetailLocationId) && 
/*  566 */       this._events != null && 
/*  567 */       postEventsForChanges()) {
/*  568 */       this._events.post(ILineItemAssociationModifier.SET_CHILDRETAILLOCATIONID, Long.valueOf(argChildRetailLocationId));
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean setChildRetailLocationId_noev(long argChildRetailLocationId) {
/*  575 */     boolean ev_postable = false;
/*      */     
/*  577 */     if ((getDAO_().getChildRetailLocationId() == null && Long.valueOf(argChildRetailLocationId) != null) || (
/*  578 */       getDAO_().getChildRetailLocationId() != null && !getDAO_().getChildRetailLocationId().equals(Long.valueOf(argChildRetailLocationId)))) {
/*  579 */       getDAO_().setChildRetailLocationId(Long.valueOf(argChildRetailLocationId));
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
/*      */   public int getChildRetailTransactionLineItemSequence() {
/*  591 */     if (getDAO_().getChildRetailTransactionLineItemSequence() != null) {
/*  592 */       return getDAO_().getChildRetailTransactionLineItemSequence().intValue();
/*      */     }
/*      */     
/*  595 */     return 0;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setChildRetailTransactionLineItemSequence(int argChildRetailTransactionLineItemSequence) {
/*  604 */     if (setChildRetailTransactionLineItemSequence_noev(argChildRetailTransactionLineItemSequence) && 
/*  605 */       this._events != null && 
/*  606 */       postEventsForChanges()) {
/*  607 */       this._events.post(ILineItemAssociationModifier.SET_CHILDRETAILTRANSACTIONLINEITEMSEQUENCE, Integer.valueOf(argChildRetailTransactionLineItemSequence));
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean setChildRetailTransactionLineItemSequence_noev(int argChildRetailTransactionLineItemSequence) {
/*  614 */     boolean ev_postable = false;
/*      */     
/*  616 */     if ((getDAO_().getChildRetailTransactionLineItemSequence() == null && Integer.valueOf(argChildRetailTransactionLineItemSequence) != null) || (
/*  617 */       getDAO_().getChildRetailTransactionLineItemSequence() != null && !getDAO_().getChildRetailTransactionLineItemSequence().equals(Integer.valueOf(argChildRetailTransactionLineItemSequence)))) {
/*  618 */       getDAO_().setChildRetailTransactionLineItemSequence(Integer.valueOf(argChildRetailTransactionLineItemSequence));
/*  619 */       ev_postable = true;
/*      */     } 
/*      */     
/*  622 */     return ev_postable;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public long getChildTransactionSequence() {
/*  630 */     if (getDAO_().getChildTransactionSequence() != null) {
/*  631 */       return getDAO_().getChildTransactionSequence().longValue();
/*      */     }
/*      */     
/*  634 */     return 0L;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setChildTransactionSequence(long argChildTransactionSequence) {
/*  643 */     if (setChildTransactionSequence_noev(argChildTransactionSequence) && 
/*  644 */       this._events != null && 
/*  645 */       postEventsForChanges()) {
/*  646 */       this._events.post(ILineItemAssociationModifier.SET_CHILDTRANSACTIONSEQUENCE, Long.valueOf(argChildTransactionSequence));
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean setChildTransactionSequence_noev(long argChildTransactionSequence) {
/*  653 */     boolean ev_postable = false;
/*      */     
/*  655 */     if ((getDAO_().getChildTransactionSequence() == null && Long.valueOf(argChildTransactionSequence) != null) || (
/*  656 */       getDAO_().getChildTransactionSequence() != null && !getDAO_().getChildTransactionSequence().equals(Long.valueOf(argChildTransactionSequence)))) {
/*  657 */       getDAO_().setChildTransactionSequence(Long.valueOf(argChildTransactionSequence));
/*  658 */       ev_postable = true;
/*      */     } 
/*      */     
/*  661 */     return ev_postable;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public long getChildWorkstationId() {
/*  669 */     if (getDAO_().getChildWorkstationId() != null) {
/*  670 */       return getDAO_().getChildWorkstationId().longValue();
/*      */     }
/*      */     
/*  673 */     return 0L;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setChildWorkstationId(long argChildWorkstationId) {
/*  682 */     if (setChildWorkstationId_noev(argChildWorkstationId) && 
/*  683 */       this._events != null && 
/*  684 */       postEventsForChanges()) {
/*  685 */       this._events.post(ILineItemAssociationModifier.SET_CHILDWORKSTATIONID, Long.valueOf(argChildWorkstationId));
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean setChildWorkstationId_noev(long argChildWorkstationId) {
/*  692 */     boolean ev_postable = false;
/*      */     
/*  694 */     if ((getDAO_().getChildWorkstationId() == null && Long.valueOf(argChildWorkstationId) != null) || (
/*  695 */       getDAO_().getChildWorkstationId() != null && !getDAO_().getChildWorkstationId().equals(Long.valueOf(argChildWorkstationId)))) {
/*  696 */       getDAO_().setChildWorkstationId(Long.valueOf(argChildWorkstationId));
/*  697 */       ev_postable = true;
/*      */     } 
/*      */     
/*  700 */     return ev_postable;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public String getLineItemAssociationTypeCodeString() {
/*  708 */     return getDAO_().getLineItemAssociationTypeCodeString();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setLineItemAssociationTypeCodeString(String argLineItemAssociationTypeCodeString) {
/*  716 */     if (setLineItemAssociationTypeCodeString_noev(argLineItemAssociationTypeCodeString) && 
/*  717 */       this._events != null && 
/*  718 */       postEventsForChanges()) {
/*  719 */       this._events.post(ILineItemAssociationModifier.SET_LINEITEMASSOCIATIONTYPECODESTRING, argLineItemAssociationTypeCodeString);
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean setLineItemAssociationTypeCodeString_noev(String argLineItemAssociationTypeCodeString) {
/*  726 */     boolean ev_postable = false;
/*      */     
/*  728 */     if ((getDAO_().getLineItemAssociationTypeCodeString() == null && argLineItemAssociationTypeCodeString != null) || (
/*  729 */       getDAO_().getLineItemAssociationTypeCodeString() != null && !getDAO_().getLineItemAssociationTypeCodeString().equals(argLineItemAssociationTypeCodeString))) {
/*  730 */       getDAO_().setLineItemAssociationTypeCodeString(argLineItemAssociationTypeCodeString);
/*  731 */       ev_postable = true;
/*      */     } 
/*      */     
/*  734 */     return ev_postable;
/*      */   }
/*      */   
/*      */   protected ILineItemAssociationModifierProperty newProperty(String argPropertyName) {
/*  738 */     LineItemAssociationModifierPropertyId id = new LineItemAssociationModifierPropertyId();
/*      */     
/*  740 */     id.setBusinessDate(getBusinessDate());
/*  741 */     id.setLineItemAssociationModifierSequence(Integer.valueOf(getLineItemAssociationModifierSequence()));
/*  742 */     id.setRetailLocationId(Long.valueOf(getRetailLocationId()));
/*  743 */     id.setRetailTransactionLineItemSequence(Integer.valueOf(getRetailTransactionLineItemSequence()));
/*  744 */     id.setTransactionSequence(Long.valueOf(getTransactionSequence()));
/*  745 */     id.setWorkstationId(Long.valueOf(getWorkstationId()));
/*  746 */     id.setPropertyCode(argPropertyName);
/*      */     
/*  748 */     ILineItemAssociationModifierProperty prop = (ILineItemAssociationModifierProperty)DataFactory.getInstance().createNewObject((IObjectId)id, ILineItemAssociationModifierProperty.class);
/*  749 */     return prop;
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
/*      */   @Relationship(name = "ChildLineItem")
/*      */   public ISaleReturnLineItem getChildLineItem() {
/*  764 */     return this._childLineItem;
/*      */   }
/*      */ 
/*      */   
/*      */   public void setChildLineItem(ISaleReturnLineItem argChildLineItem) {
/*  769 */     if (argChildLineItem == null) {
/*      */       
/*  771 */       getDAO_().setChildRetailLocationId(null);
/*  772 */       getDAO_().setChildBusinessDate(null);
/*  773 */       getDAO_().setChildWorkstationId(null);
/*  774 */       getDAO_().setChildTransactionSequence(null);
/*  775 */       getDAO_().setChildRetailTransactionLineItemSequence(null);
/*  776 */       if (this._childLineItem != null)
/*      */       {
/*  778 */         if (postEventsForChanges()) {
/*  779 */           this._eventManager.deregisterEventHandler((IEventAware)this._eventCascade, (IEventSource)new EventDescriptor(this._childLineItem));
/*      */         }
/*      */       }
/*      */     } else {
/*      */       
/*  784 */       getDAO_().setChildRetailLocationId(Long.valueOf(argChildLineItem.getRetailLocationId()));
/*  785 */       getDAO_().setChildBusinessDate(argChildLineItem.getBusinessDate());
/*  786 */       getDAO_().setChildWorkstationId(Long.valueOf(argChildLineItem.getWorkstationId()));
/*  787 */       getDAO_().setChildTransactionSequence(Long.valueOf(argChildLineItem.getTransactionSequence()));
/*  788 */       getDAO_().setChildRetailTransactionLineItemSequence(Integer.valueOf(argChildLineItem.getRetailTransactionLineItemSequence()));
/*      */       
/*  790 */       if (postEventsForChanges()) {
/*  791 */         this._eventManager.registerEventHandler((IEventAware)this._eventCascade, (IEventSource)new EventDescriptor(argChildLineItem));
/*      */       }
/*      */     } 
/*      */     
/*  795 */     this._childLineItem = argChildLineItem;
/*  796 */     if (postEventsForChanges()) {
/*  797 */       this._events.post(ILineItemAssociationModifier.SET_CHILDLINEITEM, argChildLineItem);
/*      */     }
/*      */   }
/*      */   
/*      */   @Relationship(name = "LineItemAssociationTypeCode")
/*      */   public ILineItemAssociationTypeCode getLineItemAssociationTypeCode() {
/*  803 */     return this._lineItemAssociationTypeCode;
/*      */   }
/*      */ 
/*      */   
/*      */   public void setLineItemAssociationTypeCode(ILineItemAssociationTypeCode argLineItemAssociationTypeCode) {
/*  808 */     if (argLineItemAssociationTypeCode == null) {
/*      */       
/*  810 */       getDAO_().setLineItemAssociationTypeCodeString(null);
/*  811 */       if (this._lineItemAssociationTypeCode != null)
/*      */       {
/*  813 */         if (postEventsForChanges()) {
/*  814 */           this._eventManager.deregisterEventHandler((IEventAware)this._eventCascade, (IEventSource)new EventDescriptor(this._lineItemAssociationTypeCode));
/*      */         }
/*      */       }
/*      */     } else {
/*      */       
/*  819 */       getDAO_().setLineItemAssociationTypeCodeString(argLineItemAssociationTypeCode.getLineItemAssociationTypeCode());
/*      */       
/*  821 */       if (postEventsForChanges()) {
/*  822 */         this._eventManager.registerEventHandler((IEventAware)this._eventCascade, (IEventSource)new EventDescriptor(argLineItemAssociationTypeCode));
/*      */       }
/*      */     } 
/*      */     
/*  826 */     this._lineItemAssociationTypeCode = argLineItemAssociationTypeCode;
/*  827 */     if (postEventsForChanges()) {
/*  828 */       this._events.post(ILineItemAssociationModifier.SET_LINEITEMASSOCIATIONTYPECODE, argLineItemAssociationTypeCode);
/*      */     }
/*      */   }
/*      */   
/*      */   @Relationship(name = "Properties")
/*      */   public List<ILineItemAssociationModifierProperty> getProperties() {
/*  834 */     if (this._properties == null) {
/*  835 */       this._properties = new HistoricalList(null);
/*      */     }
/*  837 */     return (List<ILineItemAssociationModifierProperty>)this._properties;
/*      */   }
/*      */   
/*      */   public void setProperties(List<ILineItemAssociationModifierProperty> argProperties) {
/*  841 */     if (this._properties == null) {
/*  842 */       this._properties = new HistoricalList(argProperties);
/*      */     } else {
/*  844 */       this._properties.setCurrentList(argProperties);
/*      */     } 
/*      */     
/*  847 */     for (ILineItemAssociationModifierProperty child : this._properties) {
/*  848 */       LineItemAssociationModifierPropertyModel model = (LineItemAssociationModifierPropertyModel)child;
/*  849 */       model.setBusinessDate_noev(getBusinessDate());
/*  850 */       model.setLineItemAssociationModifierSequence_noev(getLineItemAssociationModifierSequence());
/*  851 */       model.setOrganizationId_noev(getOrganizationId());
/*  852 */       model.setRetailLocationId_noev(getRetailLocationId());
/*  853 */       model.setRetailTransactionLineItemSequence_noev(getRetailTransactionLineItemSequence());
/*  854 */       model.setTransactionSequence_noev(getTransactionSequence());
/*  855 */       model.setWorkstationId_noev(getWorkstationId());
/*  856 */       if (child instanceof IDataModelImpl) {
/*  857 */         IDataAccessObject childDao = ((IDataModelImpl)child).getDAO();
/*  858 */         if (StringUtils.isEmpty(childDao.getOriginDataSource()) && 
/*  859 */           !StringUtils.isEmpty(getDAO().getOriginDataSource())) {
/*  860 */           childDao.setOriginDataSource(getDAO().getOriginDataSource());
/*      */         }
/*      */       } 
/*  863 */       if (postEventsForChanges()) {
/*  864 */         this._eventManager.registerEventHandler((IEventAware)this._eventCascade, (IEventSource)child);
/*      */       }
/*      */     } 
/*      */   }
/*      */   
/*      */   public void addLineItemAssociationModifierProperty(ILineItemAssociationModifierProperty argLineItemAssociationModifierProperty) {
/*  870 */     if (this._properties == null) {
/*  871 */       this._properties = new HistoricalList(null);
/*      */     }
/*  873 */     argLineItemAssociationModifierProperty.setBusinessDate(getBusinessDate());
/*  874 */     argLineItemAssociationModifierProperty.setLineItemAssociationModifierSequence(getLineItemAssociationModifierSequence());
/*  875 */     argLineItemAssociationModifierProperty.setOrganizationId(getOrganizationId());
/*  876 */     argLineItemAssociationModifierProperty.setRetailLocationId(getRetailLocationId());
/*  877 */     argLineItemAssociationModifierProperty.setRetailTransactionLineItemSequence(getRetailTransactionLineItemSequence());
/*  878 */     argLineItemAssociationModifierProperty.setTransactionSequence(getTransactionSequence());
/*  879 */     argLineItemAssociationModifierProperty.setWorkstationId(getWorkstationId());
/*  880 */     if (argLineItemAssociationModifierProperty instanceof IDataModelImpl) {
/*  881 */       IDataAccessObject childDao = ((IDataModelImpl)argLineItemAssociationModifierProperty).getDAO();
/*  882 */       if (StringUtils.isEmpty(childDao.getOriginDataSource()) && 
/*  883 */         !StringUtils.isEmpty(getDAO().getOriginDataSource())) {
/*  884 */         childDao.setOriginDataSource(getDAO().getOriginDataSource());
/*      */       }
/*      */     } 
/*      */ 
/*      */     
/*  889 */     if (postEventsForChanges()) {
/*  890 */       this._eventManager.registerEventHandler((IEventAware)this._eventCascade, (IEventSource)new EventDescriptor(argLineItemAssociationModifierProperty));
/*      */     }
/*      */     
/*  893 */     this._properties.add(argLineItemAssociationModifierProperty);
/*  894 */     if (postEventsForChanges()) {
/*  895 */       this._events.post(ILineItemAssociationModifier.ADD_PROPERTIES, argLineItemAssociationModifierProperty);
/*      */     }
/*      */   }
/*      */   
/*      */   public void removeLineItemAssociationModifierProperty(ILineItemAssociationModifierProperty argLineItemAssociationModifierProperty) {
/*  900 */     if (this._properties != null) {
/*      */       
/*  902 */       if (postEventsForChanges()) {
/*  903 */         this._eventManager.deregisterEventHandler((IEventAware)this._eventCascade, (IEventSource)new EventDescriptor(argLineItemAssociationModifierProperty));
/*      */       }
/*  905 */       this._properties.remove(argLineItemAssociationModifierProperty);
/*  906 */       if (postEventsForChanges()) {
/*  907 */         this._events.post(ILineItemAssociationModifier.REMOVE_PROPERTIES, argLineItemAssociationModifierProperty);
/*      */       }
/*      */     } 
/*      */   }
/*      */   
/*      */   public void setParentLine(ISaleReturnLineItem argParentLine) {
/*  913 */     this._parentLine = argParentLine;
/*      */   }
/*      */   
/*      */   public ISaleReturnLineItem getParentLine() {
/*  917 */     return this._parentLine;
/*      */   }
/*      */ 
/*      */   
/*      */   public Object getValue(String argFieldId) {
/*  922 */     if ("ChildLineItem".equals(argFieldId)) {
/*  923 */       return getChildLineItem();
/*      */     }
/*  925 */     if ("LineItemAssociationTypeCode".equals(argFieldId)) {
/*  926 */       return getLineItemAssociationTypeCode();
/*      */     }
/*  928 */     if ("Properties".equals(argFieldId)) {
/*  929 */       return getProperties();
/*      */     }
/*  931 */     if ("LineItemAssociationModifierExtension".equals(argFieldId)) {
/*  932 */       return this._myExtension;
/*      */     }
/*      */     
/*  935 */     return super.getValue(argFieldId);
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public void setValue(String argFieldId, Object argValue) {
/*  941 */     if ("ChildLineItem".equals(argFieldId)) {
/*  942 */       setChildLineItem((ISaleReturnLineItem)argValue);
/*      */     }
/*  944 */     else if ("LineItemAssociationTypeCode".equals(argFieldId)) {
/*  945 */       setLineItemAssociationTypeCode((ILineItemAssociationTypeCode)argValue);
/*      */     }
/*  947 */     else if ("Properties".equals(argFieldId)) {
/*  948 */       setProperties(changeToList(argValue, ILineItemAssociationModifierProperty.class));
/*      */     }
/*  950 */     else if ("LineItemAssociationModifierExtension".equals(argFieldId)) {
/*  951 */       this._myExtension = (IDataModel)argValue;
/*      */     } else {
/*      */       
/*  954 */       super.setValue(argFieldId, argValue);
/*      */     } 
/*      */   }
/*      */ 
/*      */   
/*      */   public void setDependencies(IPersistenceDefaults argPD, EventManager argEM) {
/*  960 */     this._persistenceDefaults = argPD;
/*  961 */     this._daoImpl.setPersistenceDefaults(argPD);
/*  962 */     this._eventManager = argEM;
/*  963 */     this._events = (Eventor)new ModelEventor((IDataModel)this, argEM);
/*  964 */     this._eventCascade = (EventHandler)new CascadingHandler(this);
/*  965 */     if (this._childLineItem != null) {
/*  966 */       ((IDataModelImpl)this._childLineItem).setDependencies(argPD, argEM);
/*      */     }
/*  968 */     if (this._lineItemAssociationTypeCode != null) {
/*  969 */       ((IDataModelImpl)this._lineItemAssociationTypeCode).setDependencies(argPD, argEM);
/*      */     }
/*  971 */     if (this._properties != null) {
/*  972 */       for (ILineItemAssociationModifierProperty relationship : this._properties) {
/*  973 */         ((IDataModelImpl)relationship).setDependencies(argPD, argEM);
/*      */       }
/*      */     }
/*      */   }
/*      */   
/*      */   public IDataModel getLineItemAssociationModifierExt() {
/*  979 */     return this._myExtension;
/*      */   }
/*      */   
/*      */   public void setLineItemAssociationModifierExt(IDataModel argExt) {
/*  983 */     this._myExtension = argExt;
/*      */   }
/*      */ 
/*      */   
/*      */   public void startTransaction() {
/*  988 */     if (this._alreadyInStart) {
/*      */       return;
/*      */     }
/*      */     
/*  992 */     this._alreadyInStart = true;
/*      */ 
/*      */     
/*  995 */     super.startTransaction();
/*      */     
/*  997 */     this._childLineItemSavepoint = this._childLineItem;
/*  998 */     if (this._childLineItem != null) {
/*  999 */       this._childLineItem.startTransaction();
/*      */     }
/*      */     
/* 1002 */     this._lineItemAssociationTypeCodeSavepoint = this._lineItemAssociationTypeCode;
/* 1003 */     if (this._lineItemAssociationTypeCode != null) {
/* 1004 */       this._lineItemAssociationTypeCode.startTransaction();
/*      */     }
/*      */     
/* 1007 */     this._propertiesSavepoint = this._properties;
/* 1008 */     if (this._properties != null) {
/* 1009 */       this._propertiesSavepoint = new HistoricalList((List)this._properties);
/* 1010 */       Iterator<IDataModel> it = this._properties.iterator();
/* 1011 */       while (it.hasNext()) {
/* 1012 */         ((IDataModel)it.next()).startTransaction();
/*      */       }
/*      */     } 
/*      */ 
/*      */     
/* 1017 */     this._alreadyInStart = false;
/*      */   }
/*      */ 
/*      */   
/*      */   public void rollbackChanges() {
/* 1022 */     if (isAlreadyRolledBack()) {
/*      */       return;
/*      */     }
/* 1025 */     super.rollbackChanges();
/*      */     
/* 1027 */     this._childLineItem = this._childLineItemSavepoint;
/* 1028 */     this._childLineItemSavepoint = null;
/* 1029 */     if (this._childLineItem != null) {
/* 1030 */       this._childLineItem.rollbackChanges();
/*      */     }
/*      */     
/* 1033 */     this._lineItemAssociationTypeCode = this._lineItemAssociationTypeCodeSavepoint;
/* 1034 */     this._lineItemAssociationTypeCodeSavepoint = null;
/* 1035 */     if (this._lineItemAssociationTypeCode != null) {
/* 1036 */       this._lineItemAssociationTypeCode.rollbackChanges();
/*      */     }
/*      */     
/* 1039 */     this._properties = this._propertiesSavepoint;
/* 1040 */     this._propertiesSavepoint = null;
/* 1041 */     if (this._properties != null) {
/* 1042 */       Iterator<IDataModel> it = this._properties.iterator();
/* 1043 */       while (it.hasNext()) {
/* 1044 */         ((IDataModel)it.next()).rollbackChanges();
/*      */       }
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public void commitTransaction() {
/* 1052 */     if (this._alreadyInCommit) {
/*      */       return;
/*      */     }
/* 1055 */     this._alreadyInCommit = true;
/*      */ 
/*      */     
/* 1058 */     super.commitTransaction();
/*      */     
/* 1060 */     this._childLineItemSavepoint = this._childLineItem;
/* 1061 */     if (this._childLineItem != null) {
/* 1062 */       this._childLineItem.commitTransaction();
/*      */     }
/*      */     
/* 1065 */     this._lineItemAssociationTypeCodeSavepoint = this._lineItemAssociationTypeCode;
/* 1066 */     if (this._lineItemAssociationTypeCode != null) {
/* 1067 */       this._lineItemAssociationTypeCode.commitTransaction();
/*      */     }
/*      */     
/* 1070 */     this._propertiesSavepoint = this._properties;
/* 1071 */     if (this._properties != null) {
/* 1072 */       Iterator<IDataModel> it = this._properties.iterator();
/* 1073 */       while (it.hasNext()) {
/* 1074 */         ((IDataModel)it.next()).commitTransaction();
/*      */       }
/* 1076 */       this._properties = new HistoricalList((List)this._properties);
/*      */     } 
/*      */ 
/*      */     
/* 1080 */     this._alreadyInCommit = false;
/*      */   }
/*      */ 
/*      */   
/*      */   private void readObject(ObjectInputStream argStream) throws IOException, ClassNotFoundException {
/* 1085 */     argStream.defaultReadObject();
/*      */   }
/*      */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\trl\impl\LineItemAssociationModifierModel.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */