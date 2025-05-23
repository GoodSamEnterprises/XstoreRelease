/*      */ package dtv.xst.dao.inv.impl;
/*      */ import dtv.data2.IPersistenceDefaults;
/*      */ import dtv.data2.access.DataFactory;
/*      */ import dtv.data2.access.IDataAccessObject;
/*      */ import dtv.data2.access.IDataModel;
/*      */ import dtv.data2.access.IDataProperty;
/*      */ import dtv.data2.access.IObjectId;
/*      */ import dtv.data2.access.ModelEventor;
/*      */ import dtv.data2.access.impl.IDataModelImpl;
/*      */ import dtv.data2.access.impl.Relationship;
/*      */ import dtv.event.EventDescriptor;
/*      */ import dtv.event.EventHandler;
/*      */ import dtv.event.EventManager;
/*      */ import dtv.event.Eventor;
/*      */ import dtv.event.IEventAware;
/*      */ import dtv.event.IEventSource;
/*      */ import dtv.event.handler.CascadingHandler;
/*      */ import dtv.util.HistoricalList;
/*      */ import dtv.util.StringUtils;
/*      */ import dtv.xst.dao.inv.IInventoryDocumentLineItem;
/*      */ import dtv.xst.dao.inv.IInventoryTransaction;
/*      */ import dtv.xst.dao.inv.IInventoryTransactionDetail;
/*      */ import dtv.xst.dao.inv.IInventoryTransactionDetailProperty;
/*      */ import dtv.xst.dao.inv.InventoryTransactionDetailPropertyId;
/*      */ import java.math.BigDecimal;
/*      */ import java.util.Date;
/*      */ import java.util.Iterator;
/*      */ import java.util.List;
/*      */ 
/*      */ public class InventoryTransactionDetailModel extends InventoryTransactionDetailBaseModel implements IInventoryTransactionDetail {
/*      */   private static final long serialVersionUID = -1690444045L;
/*      */   private IInventoryTransaction _parentTransaction;
/*      */   private transient boolean _alreadyInStart = false;
/*      */   private transient boolean _alreadyInCommit = false;
/*      */   
/*      */   public String toString() {
/*   37 */     return super.toString() + " Id: " + getObjectId();
/*      */   }
/*      */   private IDataModel _myExtension; private IInventoryDocumentLineItem _inventoryDocumentLineItem; private transient IInventoryDocumentLineItem _inventoryDocumentLineItemSavepoint; private HistoricalList<IInventoryTransactionDetailProperty> _properties; private transient HistoricalList<IInventoryTransactionDetailProperty> _propertiesSavepoint;
/*      */   
/*      */   public void initDAO() {
/*   42 */     setDAO((IDataAccessObject)new InventoryTransactionDetailDAO());
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private InventoryTransactionDetailDAO getDAO_() {
/*   50 */     return (InventoryTransactionDetailDAO)this._daoImpl;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public long getOrganizationId() {
/*   58 */     if (getDAO_().getOrganizationId() != null) {
/*   59 */       return getDAO_().getOrganizationId().longValue();
/*      */     }
/*      */     
/*   62 */     return 0L;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setOrganizationId(long argOrganizationId) {
/*   71 */     if (setOrganizationId_noev(argOrganizationId) && 
/*   72 */       this._events != null && 
/*   73 */       postEventsForChanges()) {
/*   74 */       this._events.post(IInventoryTransactionDetail.SET_ORGANIZATIONID, Long.valueOf(argOrganizationId));
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean setOrganizationId_noev(long argOrganizationId) {
/*   81 */     boolean ev_postable = false;
/*      */     
/*   83 */     if ((getDAO_().getOrganizationId() == null && Long.valueOf(argOrganizationId) != null) || (
/*   84 */       getDAO_().getOrganizationId() != null && !getDAO_().getOrganizationId().equals(Long.valueOf(argOrganizationId)))) {
/*   85 */       getDAO_().setOrganizationId(Long.valueOf(argOrganizationId));
/*   86 */       ev_postable = true;
/*   87 */       if (this._properties != null) {
/*      */         
/*   89 */         Iterator<InventoryTransactionDetailPropertyModel> it = this._properties.iterator();
/*   90 */         while (it.hasNext())
/*      */         {
/*   92 */           ((InventoryTransactionDetailPropertyModel)it.next()).setOrganizationId_noev(argOrganizationId);
/*      */         }
/*      */       } 
/*      */     } 
/*      */     
/*   97 */     return ev_postable;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public long getRetailLocationId() {
/*  105 */     if (getDAO_().getRetailLocationId() != null) {
/*  106 */       return getDAO_().getRetailLocationId().longValue();
/*      */     }
/*      */     
/*  109 */     return 0L;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setRetailLocationId(long argRetailLocationId) {
/*  118 */     if (setRetailLocationId_noev(argRetailLocationId) && 
/*  119 */       this._events != null && 
/*  120 */       postEventsForChanges()) {
/*  121 */       this._events.post(IInventoryTransactionDetail.SET_RETAILLOCATIONID, Long.valueOf(argRetailLocationId));
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean setRetailLocationId_noev(long argRetailLocationId) {
/*  128 */     boolean ev_postable = false;
/*      */     
/*  130 */     if ((getDAO_().getRetailLocationId() == null && Long.valueOf(argRetailLocationId) != null) || (
/*  131 */       getDAO_().getRetailLocationId() != null && !getDAO_().getRetailLocationId().equals(Long.valueOf(argRetailLocationId)))) {
/*  132 */       getDAO_().setRetailLocationId(Long.valueOf(argRetailLocationId));
/*  133 */       ev_postable = true;
/*  134 */       if (this._properties != null) {
/*      */         
/*  136 */         Iterator<InventoryTransactionDetailPropertyModel> it = this._properties.iterator();
/*  137 */         while (it.hasNext())
/*      */         {
/*  139 */           ((InventoryTransactionDetailPropertyModel)it.next()).setRetailLocationId_noev(argRetailLocationId);
/*      */         }
/*      */       } 
/*      */     } 
/*      */     
/*  144 */     return ev_postable;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public Date getBusinessDate() {
/*  152 */     return getDAO_().getBusinessDate();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setBusinessDate(Date argBusinessDate) {
/*  160 */     if (setBusinessDate_noev(argBusinessDate) && 
/*  161 */       this._events != null && 
/*  162 */       postEventsForChanges()) {
/*  163 */       this._events.post(IInventoryTransactionDetail.SET_BUSINESSDATE, argBusinessDate);
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean setBusinessDate_noev(Date argBusinessDate) {
/*  170 */     boolean ev_postable = false;
/*      */     
/*  172 */     if ((getDAO_().getBusinessDate() == null && argBusinessDate != null) || (
/*  173 */       getDAO_().getBusinessDate() != null && !getDAO_().getBusinessDate().equals(argBusinessDate))) {
/*  174 */       getDAO_().setBusinessDate(argBusinessDate);
/*  175 */       ev_postable = true;
/*  176 */       if (this._properties != null) {
/*      */         
/*  178 */         Iterator<InventoryTransactionDetailPropertyModel> it = this._properties.iterator();
/*  179 */         while (it.hasNext())
/*      */         {
/*  181 */           ((InventoryTransactionDetailPropertyModel)it.next()).setBusinessDate_noev(argBusinessDate);
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
/*      */   public long getWorkstationId() {
/*  194 */     if (getDAO_().getWorkstationId() != null) {
/*  195 */       return getDAO_().getWorkstationId().longValue();
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
/*      */   public void setWorkstationId(long argWorkstationId) {
/*  207 */     if (setWorkstationId_noev(argWorkstationId) && 
/*  208 */       this._events != null && 
/*  209 */       postEventsForChanges()) {
/*  210 */       this._events.post(IInventoryTransactionDetail.SET_WORKSTATIONID, Long.valueOf(argWorkstationId));
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean setWorkstationId_noev(long argWorkstationId) {
/*  217 */     boolean ev_postable = false;
/*      */     
/*  219 */     if ((getDAO_().getWorkstationId() == null && Long.valueOf(argWorkstationId) != null) || (
/*  220 */       getDAO_().getWorkstationId() != null && !getDAO_().getWorkstationId().equals(Long.valueOf(argWorkstationId)))) {
/*  221 */       getDAO_().setWorkstationId(Long.valueOf(argWorkstationId));
/*  222 */       ev_postable = true;
/*  223 */       if (this._properties != null) {
/*      */         
/*  225 */         Iterator<InventoryTransactionDetailPropertyModel> it = this._properties.iterator();
/*  226 */         while (it.hasNext())
/*      */         {
/*  228 */           ((InventoryTransactionDetailPropertyModel)it.next()).setWorkstationId_noev(argWorkstationId);
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
/*      */   public long getTransactionSequence() {
/*  241 */     if (getDAO_().getTransactionSequence() != null) {
/*  242 */       return getDAO_().getTransactionSequence().longValue();
/*      */     }
/*      */     
/*  245 */     return 0L;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setTransactionSequence(long argTransactionSequence) {
/*  254 */     if (setTransactionSequence_noev(argTransactionSequence) && 
/*  255 */       this._events != null && 
/*  256 */       postEventsForChanges()) {
/*  257 */       this._events.post(IInventoryTransactionDetail.SET_TRANSACTIONSEQUENCE, Long.valueOf(argTransactionSequence));
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean setTransactionSequence_noev(long argTransactionSequence) {
/*  264 */     boolean ev_postable = false;
/*      */     
/*  266 */     if ((getDAO_().getTransactionSequence() == null && Long.valueOf(argTransactionSequence) != null) || (
/*  267 */       getDAO_().getTransactionSequence() != null && !getDAO_().getTransactionSequence().equals(Long.valueOf(argTransactionSequence)))) {
/*  268 */       getDAO_().setTransactionSequence(Long.valueOf(argTransactionSequence));
/*  269 */       ev_postable = true;
/*  270 */       if (this._properties != null) {
/*      */         
/*  272 */         Iterator<InventoryTransactionDetailPropertyModel> it = this._properties.iterator();
/*  273 */         while (it.hasNext())
/*      */         {
/*  275 */           ((InventoryTransactionDetailPropertyModel)it.next()).setTransactionSequence_noev(argTransactionSequence);
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
/*      */   public int getInventoryDetailSequence() {
/*  288 */     if (getDAO_().getInventoryDetailSequence() != null) {
/*  289 */       return getDAO_().getInventoryDetailSequence().intValue();
/*      */     }
/*      */     
/*  292 */     return 0;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setInventoryDetailSequence(int argInventoryDetailSequence) {
/*  301 */     if (setInventoryDetailSequence_noev(argInventoryDetailSequence) && 
/*  302 */       this._events != null && 
/*  303 */       postEventsForChanges()) {
/*  304 */       this._events.post(IInventoryTransactionDetail.SET_INVENTORYDETAILSEQUENCE, Integer.valueOf(argInventoryDetailSequence));
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean setInventoryDetailSequence_noev(int argInventoryDetailSequence) {
/*  311 */     boolean ev_postable = false;
/*      */     
/*  313 */     if ((getDAO_().getInventoryDetailSequence() == null && Integer.valueOf(argInventoryDetailSequence) != null) || (
/*  314 */       getDAO_().getInventoryDetailSequence() != null && !getDAO_().getInventoryDetailSequence().equals(Integer.valueOf(argInventoryDetailSequence)))) {
/*  315 */       getDAO_().setInventoryDetailSequence(Integer.valueOf(argInventoryDetailSequence));
/*  316 */       ev_postable = true;
/*  317 */       if (this._properties != null) {
/*      */         
/*  319 */         Iterator<InventoryTransactionDetailPropertyModel> it = this._properties.iterator();
/*  320 */         while (it.hasNext())
/*      */         {
/*  322 */           ((InventoryTransactionDetailPropertyModel)it.next()).setInventoryDetailSequence_noev(argInventoryDetailSequence);
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
/*      */   public Date getCreateDate() {
/*  335 */     return getDAO_().getCreateDate();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setCreateDate(Date argCreateDate) {
/*  343 */     if (setCreateDate_noev(argCreateDate) && 
/*  344 */       this._events != null && 
/*  345 */       postEventsForChanges()) {
/*  346 */       this._events.post(IInventoryTransactionDetail.SET_CREATEDATE, argCreateDate);
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean setCreateDate_noev(Date argCreateDate) {
/*  353 */     boolean ev_postable = false;
/*      */     
/*  355 */     if ((getDAO_().getCreateDate() == null && argCreateDate != null) || (
/*  356 */       getDAO_().getCreateDate() != null && !getDAO_().getCreateDate().equals(argCreateDate))) {
/*  357 */       getDAO_().setCreateDate(argCreateDate);
/*  358 */       ev_postable = true;
/*      */     } 
/*      */     
/*  361 */     return ev_postable;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public String getCreateUserId() {
/*  369 */     return getDAO_().getCreateUserId();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setCreateUserId(String argCreateUserId) {
/*  377 */     if (setCreateUserId_noev(argCreateUserId) && 
/*  378 */       this._events != null && 
/*  379 */       postEventsForChanges()) {
/*  380 */       this._events.post(IInventoryTransactionDetail.SET_CREATEUSERID, argCreateUserId);
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean setCreateUserId_noev(String argCreateUserId) {
/*  387 */     boolean ev_postable = false;
/*      */     
/*  389 */     if ((getDAO_().getCreateUserId() == null && argCreateUserId != null) || (
/*  390 */       getDAO_().getCreateUserId() != null && !getDAO_().getCreateUserId().equals(argCreateUserId))) {
/*  391 */       getDAO_().setCreateUserId(argCreateUserId);
/*  392 */       ev_postable = true;
/*      */     } 
/*      */     
/*  395 */     return ev_postable;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public Date getUpdateDate() {
/*  403 */     return getDAO_().getUpdateDate();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setUpdateDate(Date argUpdateDate) {
/*  411 */     if (setUpdateDate_noev(argUpdateDate) && 
/*  412 */       this._events != null && 
/*  413 */       postEventsForChanges()) {
/*  414 */       this._events.post(IInventoryTransactionDetail.SET_UPDATEDATE, argUpdateDate);
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean setUpdateDate_noev(Date argUpdateDate) {
/*  421 */     boolean ev_postable = false;
/*      */     
/*  423 */     if ((getDAO_().getUpdateDate() == null && argUpdateDate != null) || (
/*  424 */       getDAO_().getUpdateDate() != null && !getDAO_().getUpdateDate().equals(argUpdateDate))) {
/*  425 */       getDAO_().setUpdateDate(argUpdateDate);
/*  426 */       ev_postable = true;
/*      */     } 
/*      */     
/*  429 */     return ev_postable;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public String getUpdateUserId() {
/*  437 */     return getDAO_().getUpdateUserId();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setUpdateUserId(String argUpdateUserId) {
/*  445 */     if (setUpdateUserId_noev(argUpdateUserId) && 
/*  446 */       this._events != null && 
/*  447 */       postEventsForChanges()) {
/*  448 */       this._events.post(IInventoryTransactionDetail.SET_UPDATEUSERID, argUpdateUserId);
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean setUpdateUserId_noev(String argUpdateUserId) {
/*  455 */     boolean ev_postable = false;
/*      */     
/*  457 */     if ((getDAO_().getUpdateUserId() == null && argUpdateUserId != null) || (
/*  458 */       getDAO_().getUpdateUserId() != null && !getDAO_().getUpdateUserId().equals(argUpdateUserId))) {
/*  459 */       getDAO_().setUpdateUserId(argUpdateUserId);
/*  460 */       ev_postable = true;
/*      */     } 
/*      */     
/*  463 */     return ev_postable;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public String getOldStatusCode() {
/*  471 */     return getDAO_().getOldStatusCode();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setOldStatusCode(String argOldStatusCode) {
/*  479 */     if (setOldStatusCode_noev(argOldStatusCode) && 
/*  480 */       this._events != null && 
/*  481 */       postEventsForChanges()) {
/*  482 */       this._events.post(IInventoryTransactionDetail.SET_OLDSTATUSCODE, argOldStatusCode);
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean setOldStatusCode_noev(String argOldStatusCode) {
/*  489 */     boolean ev_postable = false;
/*      */     
/*  491 */     if ((getDAO_().getOldStatusCode() == null && argOldStatusCode != null) || (
/*  492 */       getDAO_().getOldStatusCode() != null && !getDAO_().getOldStatusCode().equals(argOldStatusCode))) {
/*  493 */       getDAO_().setOldStatusCode(argOldStatusCode);
/*  494 */       ev_postable = true;
/*      */     } 
/*      */     
/*  497 */     return ev_postable;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public String getNewStatusCode() {
/*  505 */     return getDAO_().getNewStatusCode();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setNewStatusCode(String argNewStatusCode) {
/*  513 */     if (setNewStatusCode_noev(argNewStatusCode) && 
/*  514 */       this._events != null && 
/*  515 */       postEventsForChanges()) {
/*  516 */       this._events.post(IInventoryTransactionDetail.SET_NEWSTATUSCODE, argNewStatusCode);
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean setNewStatusCode_noev(String argNewStatusCode) {
/*  523 */     boolean ev_postable = false;
/*      */     
/*  525 */     if ((getDAO_().getNewStatusCode() == null && argNewStatusCode != null) || (
/*  526 */       getDAO_().getNewStatusCode() != null && !getDAO_().getNewStatusCode().equals(argNewStatusCode))) {
/*  527 */       getDAO_().setNewStatusCode(argNewStatusCode);
/*  528 */       ev_postable = true;
/*      */     } 
/*      */     
/*  531 */     return ev_postable;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public BigDecimal getPreviousUnitCount() {
/*  539 */     return getDAO_().getPreviousUnitCount();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setPreviousUnitCount(BigDecimal argPreviousUnitCount) {
/*  547 */     if (setPreviousUnitCount_noev(argPreviousUnitCount) && 
/*  548 */       this._events != null && 
/*  549 */       postEventsForChanges()) {
/*  550 */       this._events.post(IInventoryTransactionDetail.SET_PREVIOUSUNITCOUNT, argPreviousUnitCount);
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean setPreviousUnitCount_noev(BigDecimal argPreviousUnitCount) {
/*  557 */     boolean ev_postable = false;
/*      */     
/*  559 */     if ((getDAO_().getPreviousUnitCount() == null && argPreviousUnitCount != null) || (
/*  560 */       getDAO_().getPreviousUnitCount() != null && !getDAO_().getPreviousUnitCount().equals(argPreviousUnitCount))) {
/*  561 */       getDAO_().setPreviousUnitCount(argPreviousUnitCount);
/*  562 */       ev_postable = true;
/*      */     } 
/*      */     
/*  565 */     return ev_postable;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public BigDecimal getNewUnitCount() {
/*  573 */     return getDAO_().getNewUnitCount();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setNewUnitCount(BigDecimal argNewUnitCount) {
/*  581 */     if (setNewUnitCount_noev(argNewUnitCount) && 
/*  582 */       this._events != null && 
/*  583 */       postEventsForChanges()) {
/*  584 */       this._events.post(IInventoryTransactionDetail.SET_NEWUNITCOUNT, argNewUnitCount);
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean setNewUnitCount_noev(BigDecimal argNewUnitCount) {
/*  591 */     boolean ev_postable = false;
/*      */     
/*  593 */     if ((getDAO_().getNewUnitCount() == null && argNewUnitCount != null) || (
/*  594 */       getDAO_().getNewUnitCount() != null && !getDAO_().getNewUnitCount().equals(argNewUnitCount))) {
/*  595 */       getDAO_().setNewUnitCount(argNewUnitCount);
/*  596 */       ev_postable = true;
/*      */     } 
/*      */     
/*  599 */     return ev_postable;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public String getActionCode() {
/*  607 */     return getDAO_().getActionCode();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setActionCode(String argActionCode) {
/*  615 */     if (setActionCode_noev(argActionCode) && 
/*  616 */       this._events != null && 
/*  617 */       postEventsForChanges()) {
/*  618 */       this._events.post(IInventoryTransactionDetail.SET_ACTIONCODE, argActionCode);
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean setActionCode_noev(String argActionCode) {
/*  625 */     boolean ev_postable = false;
/*      */     
/*  627 */     if ((getDAO_().getActionCode() == null && argActionCode != null) || (
/*  628 */       getDAO_().getActionCode() != null && !getDAO_().getActionCode().equals(argActionCode))) {
/*  629 */       getDAO_().setActionCode(argActionCode);
/*  630 */       ev_postable = true;
/*      */     } 
/*      */     
/*  633 */     return ev_postable;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public BigDecimal getNewPostedCount() {
/*  641 */     return getDAO_().getNewPostedCount();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setNewPostedCount(BigDecimal argNewPostedCount) {
/*  649 */     if (setNewPostedCount_noev(argNewPostedCount) && 
/*  650 */       this._events != null && 
/*  651 */       postEventsForChanges()) {
/*  652 */       this._events.post(IInventoryTransactionDetail.SET_NEWPOSTEDCOUNT, argNewPostedCount);
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean setNewPostedCount_noev(BigDecimal argNewPostedCount) {
/*  659 */     boolean ev_postable = false;
/*      */     
/*  661 */     if ((getDAO_().getNewPostedCount() == null && argNewPostedCount != null) || (
/*  662 */       getDAO_().getNewPostedCount() != null && !getDAO_().getNewPostedCount().equals(argNewPostedCount))) {
/*  663 */       getDAO_().setNewPostedCount(argNewPostedCount);
/*  664 */       ev_postable = true;
/*      */     } 
/*      */     
/*  667 */     return ev_postable;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public BigDecimal getPreviousPostedCount() {
/*  675 */     return getDAO_().getPreviousPostedCount();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setPreviousPostedCount(BigDecimal argPreviousPostedCount) {
/*  683 */     if (setPreviousPostedCount_noev(argPreviousPostedCount) && 
/*  684 */       this._events != null && 
/*  685 */       postEventsForChanges()) {
/*  686 */       this._events.post(IInventoryTransactionDetail.SET_PREVIOUSPOSTEDCOUNT, argPreviousPostedCount);
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean setPreviousPostedCount_noev(BigDecimal argPreviousPostedCount) {
/*  693 */     boolean ev_postable = false;
/*      */     
/*  695 */     if ((getDAO_().getPreviousPostedCount() == null && argPreviousPostedCount != null) || (
/*  696 */       getDAO_().getPreviousPostedCount() != null && !getDAO_().getPreviousPostedCount().equals(argPreviousPostedCount))) {
/*  697 */       getDAO_().setPreviousPostedCount(argPreviousPostedCount);
/*  698 */       ev_postable = true;
/*      */     } 
/*      */     
/*  701 */     return ev_postable;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public long getInventoryDocumentRetailLocationId() {
/*  709 */     if (getDAO_().getInventoryDocumentRetailLocationId() != null) {
/*  710 */       return getDAO_().getInventoryDocumentRetailLocationId().longValue();
/*      */     }
/*      */     
/*  713 */     return 0L;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setInventoryDocumentRetailLocationId(long argInventoryDocumentRetailLocationId) {
/*  722 */     if (setInventoryDocumentRetailLocationId_noev(argInventoryDocumentRetailLocationId) && 
/*  723 */       this._events != null && 
/*  724 */       postEventsForChanges()) {
/*  725 */       this._events.post(IInventoryTransactionDetail.SET_INVENTORYDOCUMENTRETAILLOCATIONID, Long.valueOf(argInventoryDocumentRetailLocationId));
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean setInventoryDocumentRetailLocationId_noev(long argInventoryDocumentRetailLocationId) {
/*  732 */     boolean ev_postable = false;
/*      */     
/*  734 */     if ((getDAO_().getInventoryDocumentRetailLocationId() == null && Long.valueOf(argInventoryDocumentRetailLocationId) != null) || (
/*  735 */       getDAO_().getInventoryDocumentRetailLocationId() != null && !getDAO_().getInventoryDocumentRetailLocationId().equals(Long.valueOf(argInventoryDocumentRetailLocationId)))) {
/*  736 */       getDAO_().setInventoryDocumentRetailLocationId(Long.valueOf(argInventoryDocumentRetailLocationId));
/*  737 */       ev_postable = true;
/*      */     } 
/*      */     
/*  740 */     return ev_postable;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public String getDocumentId() {
/*  748 */     return getDAO_().getDocumentId();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setDocumentId(String argDocumentId) {
/*  756 */     if (setDocumentId_noev(argDocumentId) && 
/*  757 */       this._events != null && 
/*  758 */       postEventsForChanges()) {
/*  759 */       this._events.post(IInventoryTransactionDetail.SET_DOCUMENTID, argDocumentId);
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean setDocumentId_noev(String argDocumentId) {
/*  766 */     boolean ev_postable = false;
/*      */     
/*  768 */     if ((getDAO_().getDocumentId() == null && argDocumentId != null) || (
/*  769 */       getDAO_().getDocumentId() != null && !getDAO_().getDocumentId().equals(argDocumentId))) {
/*  770 */       getDAO_().setDocumentId(argDocumentId);
/*  771 */       ev_postable = true;
/*      */     } 
/*      */     
/*  774 */     return ev_postable;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public String getDocumentTypeCode() {
/*  782 */     return getDAO_().getDocumentTypeCode();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setDocumentTypeCode(String argDocumentTypeCode) {
/*  790 */     if (setDocumentTypeCode_noev(argDocumentTypeCode) && 
/*  791 */       this._events != null && 
/*  792 */       postEventsForChanges()) {
/*  793 */       this._events.post(IInventoryTransactionDetail.SET_DOCUMENTTYPECODE, argDocumentTypeCode);
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean setDocumentTypeCode_noev(String argDocumentTypeCode) {
/*  800 */     boolean ev_postable = false;
/*      */     
/*  802 */     if ((getDAO_().getDocumentTypeCode() == null && argDocumentTypeCode != null) || (
/*  803 */       getDAO_().getDocumentTypeCode() != null && !getDAO_().getDocumentTypeCode().equals(argDocumentTypeCode))) {
/*  804 */       getDAO_().setDocumentTypeCode(argDocumentTypeCode);
/*  805 */       ev_postable = true;
/*      */     } 
/*      */     
/*  808 */     return ev_postable;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public int getInventoryDocumentLineNumber() {
/*  816 */     if (getDAO_().getInventoryDocumentLineNumber() != null) {
/*  817 */       return getDAO_().getInventoryDocumentLineNumber().intValue();
/*      */     }
/*      */     
/*  820 */     return 0;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setInventoryDocumentLineNumber(int argInventoryDocumentLineNumber) {
/*  829 */     if (setInventoryDocumentLineNumber_noev(argInventoryDocumentLineNumber) && 
/*  830 */       this._events != null && 
/*  831 */       postEventsForChanges()) {
/*  832 */       this._events.post(IInventoryTransactionDetail.SET_INVENTORYDOCUMENTLINENUMBER, Integer.valueOf(argInventoryDocumentLineNumber));
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean setInventoryDocumentLineNumber_noev(int argInventoryDocumentLineNumber) {
/*  839 */     boolean ev_postable = false;
/*      */     
/*  841 */     if ((getDAO_().getInventoryDocumentLineNumber() == null && Integer.valueOf(argInventoryDocumentLineNumber) != null) || (
/*  842 */       getDAO_().getInventoryDocumentLineNumber() != null && !getDAO_().getInventoryDocumentLineNumber().equals(Integer.valueOf(argInventoryDocumentLineNumber)))) {
/*  843 */       getDAO_().setInventoryDocumentLineNumber(Integer.valueOf(argInventoryDocumentLineNumber));
/*  844 */       ev_postable = true;
/*      */     } 
/*      */     
/*  847 */     return ev_postable;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public String getInventoryItemId() {
/*  855 */     return getDAO_().getInventoryItemId();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setInventoryItemId(String argInventoryItemId) {
/*  863 */     if (setInventoryItemId_noev(argInventoryItemId) && 
/*  864 */       this._events != null && 
/*  865 */       postEventsForChanges()) {
/*  866 */       this._events.post(IInventoryTransactionDetail.SET_INVENTORYITEMID, argInventoryItemId);
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean setInventoryItemId_noev(String argInventoryItemId) {
/*  873 */     boolean ev_postable = false;
/*      */     
/*  875 */     if ((getDAO_().getInventoryItemId() == null && argInventoryItemId != null) || (
/*  876 */       getDAO_().getInventoryItemId() != null && !getDAO_().getInventoryItemId().equals(argInventoryItemId))) {
/*  877 */       getDAO_().setInventoryItemId(argInventoryItemId);
/*  878 */       ev_postable = true;
/*      */     } 
/*      */     
/*  881 */     return ev_postable;
/*      */   }
/*      */   
/*      */   protected IInventoryTransactionDetailProperty newProperty(String argPropertyName) {
/*  885 */     InventoryTransactionDetailPropertyId id = new InventoryTransactionDetailPropertyId();
/*      */     
/*  887 */     id.setRetailLocationId(Long.valueOf(getRetailLocationId()));
/*  888 */     id.setBusinessDate(getBusinessDate());
/*  889 */     id.setWorkstationId(Long.valueOf(getWorkstationId()));
/*  890 */     id.setTransactionSequence(Long.valueOf(getTransactionSequence()));
/*  891 */     id.setInventoryDetailSequence(Integer.valueOf(getInventoryDetailSequence()));
/*  892 */     id.setPropertyCode(argPropertyName);
/*      */     
/*  894 */     IInventoryTransactionDetailProperty prop = (IInventoryTransactionDetailProperty)DataFactory.getInstance().createNewObject((IObjectId)id, IInventoryTransactionDetailProperty.class);
/*  895 */     return prop;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   @Relationship(name = "InventoryDocumentLineItem")
/*      */   public IInventoryDocumentLineItem getInventoryDocumentLineItem() {
/*  907 */     return this._inventoryDocumentLineItem;
/*      */   }
/*      */ 
/*      */   
/*      */   public void setInventoryDocumentLineItem(IInventoryDocumentLineItem argInventoryDocumentLineItem) {
/*  912 */     if (argInventoryDocumentLineItem == null) {
/*      */       
/*  914 */       getDAO_().setDocumentId(null);
/*  915 */       getDAO_().setDocumentTypeCode(null);
/*  916 */       getDAO_().setInventoryDocumentLineNumber(null);
/*  917 */       getDAO_().setInventoryDocumentRetailLocationId(null);
/*  918 */       if (this._inventoryDocumentLineItem != null)
/*      */       {
/*  920 */         if (postEventsForChanges()) {
/*  921 */           this._eventManager.deregisterEventHandler((IEventAware)this._eventCascade, (IEventSource)new EventDescriptor(this._inventoryDocumentLineItem));
/*      */         }
/*      */       }
/*      */     } else {
/*      */       
/*  926 */       getDAO_().setDocumentId(argInventoryDocumentLineItem.getDocumentId());
/*  927 */       getDAO_().setDocumentTypeCode(argInventoryDocumentLineItem.getDocumentTypeCode());
/*  928 */       getDAO_().setInventoryDocumentLineNumber(Integer.valueOf(argInventoryDocumentLineItem.getInventoryDocumentLineNumber()));
/*  929 */       getDAO_().setInventoryDocumentRetailLocationId(Long.valueOf(argInventoryDocumentLineItem.getRetailLocationId()));
/*      */       
/*  931 */       if (postEventsForChanges()) {
/*  932 */         this._eventManager.registerEventHandler((IEventAware)this._eventCascade, (IEventSource)new EventDescriptor(argInventoryDocumentLineItem));
/*      */       }
/*      */     } 
/*      */     
/*  936 */     this._inventoryDocumentLineItem = argInventoryDocumentLineItem;
/*  937 */     if (postEventsForChanges()) {
/*  938 */       this._events.post(IInventoryTransactionDetail.SET_INVENTORYDOCUMENTLINEITEM, argInventoryDocumentLineItem);
/*      */     }
/*      */   }
/*      */   
/*      */   @Relationship(name = "Properties")
/*      */   public List<IInventoryTransactionDetailProperty> getProperties() {
/*  944 */     if (this._properties == null) {
/*  945 */       this._properties = new HistoricalList(null);
/*      */     }
/*  947 */     return (List<IInventoryTransactionDetailProperty>)this._properties;
/*      */   }
/*      */   
/*      */   public void setProperties(List<IInventoryTransactionDetailProperty> argProperties) {
/*  951 */     if (this._properties == null) {
/*  952 */       this._properties = new HistoricalList(argProperties);
/*      */     } else {
/*  954 */       this._properties.setCurrentList(argProperties);
/*      */     } 
/*      */     
/*  957 */     for (IInventoryTransactionDetailProperty child : this._properties) {
/*  958 */       InventoryTransactionDetailPropertyModel model = (InventoryTransactionDetailPropertyModel)child;
/*  959 */       model.setOrganizationId_noev(getOrganizationId());
/*  960 */       model.setRetailLocationId_noev(getRetailLocationId());
/*  961 */       model.setBusinessDate_noev(getBusinessDate());
/*  962 */       model.setWorkstationId_noev(getWorkstationId());
/*  963 */       model.setTransactionSequence_noev(getTransactionSequence());
/*  964 */       model.setInventoryDetailSequence_noev(getInventoryDetailSequence());
/*  965 */       if (child instanceof IDataModelImpl) {
/*  966 */         IDataAccessObject childDao = ((IDataModelImpl)child).getDAO();
/*  967 */         if (StringUtils.isEmpty(childDao.getOriginDataSource()) && 
/*  968 */           !StringUtils.isEmpty(getDAO().getOriginDataSource())) {
/*  969 */           childDao.setOriginDataSource(getDAO().getOriginDataSource());
/*      */         }
/*      */       } 
/*  972 */       if (postEventsForChanges()) {
/*  973 */         this._eventManager.registerEventHandler((IEventAware)this._eventCascade, (IEventSource)child);
/*      */       }
/*      */     } 
/*      */   }
/*      */   
/*      */   public void addInventoryTransactionDetailProperty(IInventoryTransactionDetailProperty argInventoryTransactionDetailProperty) {
/*  979 */     if (this._properties == null) {
/*  980 */       this._properties = new HistoricalList(null);
/*      */     }
/*  982 */     argInventoryTransactionDetailProperty.setOrganizationId(getOrganizationId());
/*  983 */     argInventoryTransactionDetailProperty.setRetailLocationId(getRetailLocationId());
/*  984 */     argInventoryTransactionDetailProperty.setBusinessDate(getBusinessDate());
/*  985 */     argInventoryTransactionDetailProperty.setWorkstationId(getWorkstationId());
/*  986 */     argInventoryTransactionDetailProperty.setTransactionSequence(getTransactionSequence());
/*  987 */     argInventoryTransactionDetailProperty.setInventoryDetailSequence(getInventoryDetailSequence());
/*  988 */     if (argInventoryTransactionDetailProperty instanceof IDataModelImpl) {
/*  989 */       IDataAccessObject childDao = ((IDataModelImpl)argInventoryTransactionDetailProperty).getDAO();
/*  990 */       if (StringUtils.isEmpty(childDao.getOriginDataSource()) && 
/*  991 */         !StringUtils.isEmpty(getDAO().getOriginDataSource())) {
/*  992 */         childDao.setOriginDataSource(getDAO().getOriginDataSource());
/*      */       }
/*      */     } 
/*      */ 
/*      */     
/*  997 */     if (postEventsForChanges()) {
/*  998 */       this._eventManager.registerEventHandler((IEventAware)this._eventCascade, (IEventSource)new EventDescriptor(argInventoryTransactionDetailProperty));
/*      */     }
/*      */     
/* 1001 */     this._properties.add(argInventoryTransactionDetailProperty);
/* 1002 */     if (postEventsForChanges()) {
/* 1003 */       this._events.post(IInventoryTransactionDetail.ADD_PROPERTIES, argInventoryTransactionDetailProperty);
/*      */     }
/*      */   }
/*      */   
/*      */   public void removeInventoryTransactionDetailProperty(IInventoryTransactionDetailProperty argInventoryTransactionDetailProperty) {
/* 1008 */     if (this._properties != null) {
/*      */       
/* 1010 */       if (postEventsForChanges()) {
/* 1011 */         this._eventManager.deregisterEventHandler((IEventAware)this._eventCascade, (IEventSource)new EventDescriptor(argInventoryTransactionDetailProperty));
/*      */       }
/* 1013 */       this._properties.remove(argInventoryTransactionDetailProperty);
/* 1014 */       if (postEventsForChanges()) {
/* 1015 */         this._events.post(IInventoryTransactionDetail.REMOVE_PROPERTIES, argInventoryTransactionDetailProperty);
/*      */       }
/*      */     } 
/*      */   }
/*      */   
/*      */   public void setParentTransaction(IInventoryTransaction argParentTransaction) {
/* 1021 */     this._parentTransaction = argParentTransaction;
/*      */   }
/*      */   
/*      */   public IInventoryTransaction getParentTransaction() {
/* 1025 */     return this._parentTransaction;
/*      */   }
/*      */ 
/*      */   
/*      */   public Object getValue(String argFieldId) {
/* 1030 */     if ("InventoryDocumentLineItem".equals(argFieldId)) {
/* 1031 */       return getInventoryDocumentLineItem();
/*      */     }
/* 1033 */     if ("Properties".equals(argFieldId)) {
/* 1034 */       return getProperties();
/*      */     }
/* 1036 */     if ("InventoryTransactionDetailExtension".equals(argFieldId)) {
/* 1037 */       return this._myExtension;
/*      */     }
/*      */     
/* 1040 */     return super.getValue(argFieldId);
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public void setValue(String argFieldId, Object argValue) {
/* 1046 */     if ("InventoryDocumentLineItem".equals(argFieldId)) {
/* 1047 */       setInventoryDocumentLineItem((IInventoryDocumentLineItem)argValue);
/*      */     }
/* 1049 */     else if ("Properties".equals(argFieldId)) {
/* 1050 */       setProperties(changeToList(argValue, IInventoryTransactionDetailProperty.class));
/*      */     }
/* 1052 */     else if ("InventoryTransactionDetailExtension".equals(argFieldId)) {
/* 1053 */       this._myExtension = (IDataModel)argValue;
/*      */     } else {
/*      */       
/* 1056 */       super.setValue(argFieldId, argValue);
/*      */     } 
/*      */   }
/*      */ 
/*      */   
/*      */   public void setDependencies(IPersistenceDefaults argPD, EventManager argEM) {
/* 1062 */     this._persistenceDefaults = argPD;
/* 1063 */     this._daoImpl.setPersistenceDefaults(argPD);
/* 1064 */     this._eventManager = argEM;
/* 1065 */     this._events = (Eventor)new ModelEventor((IDataModel)this, argEM);
/* 1066 */     this._eventCascade = (EventHandler)new CascadingHandler(this);
/* 1067 */     if (this._inventoryDocumentLineItem != null) {
/* 1068 */       ((IDataModelImpl)this._inventoryDocumentLineItem).setDependencies(argPD, argEM);
/*      */     }
/* 1070 */     if (this._properties != null) {
/* 1071 */       for (IInventoryTransactionDetailProperty relationship : this._properties) {
/* 1072 */         ((IDataModelImpl)relationship).setDependencies(argPD, argEM);
/*      */       }
/*      */     }
/*      */   }
/*      */   
/*      */   public IDataModel getInventoryTransactionDetailExt() {
/* 1078 */     return this._myExtension;
/*      */   }
/*      */   
/*      */   public void setInventoryTransactionDetailExt(IDataModel argExt) {
/* 1082 */     this._myExtension = argExt;
/*      */   }
/*      */ 
/*      */   
/*      */   public void startTransaction() {
/* 1087 */     if (this._alreadyInStart) {
/*      */       return;
/*      */     }
/*      */     
/* 1091 */     this._alreadyInStart = true;
/*      */ 
/*      */     
/* 1094 */     super.startTransaction();
/*      */     
/* 1096 */     this._inventoryDocumentLineItemSavepoint = this._inventoryDocumentLineItem;
/* 1097 */     if (this._inventoryDocumentLineItem != null) {
/* 1098 */       this._inventoryDocumentLineItem.startTransaction();
/*      */     }
/*      */     
/* 1101 */     this._propertiesSavepoint = this._properties;
/* 1102 */     if (this._properties != null) {
/* 1103 */       this._propertiesSavepoint = new HistoricalList((List)this._properties);
/* 1104 */       Iterator<IDataModel> it = this._properties.iterator();
/* 1105 */       while (it.hasNext()) {
/* 1106 */         ((IDataModel)it.next()).startTransaction();
/*      */       }
/*      */     } 
/*      */ 
/*      */     
/* 1111 */     this._alreadyInStart = false;
/*      */   }
/*      */ 
/*      */   
/*      */   public void rollbackChanges() {
/* 1116 */     if (isAlreadyRolledBack()) {
/*      */       return;
/*      */     }
/* 1119 */     super.rollbackChanges();
/*      */     
/* 1121 */     this._inventoryDocumentLineItem = this._inventoryDocumentLineItemSavepoint;
/* 1122 */     this._inventoryDocumentLineItemSavepoint = null;
/* 1123 */     if (this._inventoryDocumentLineItem != null) {
/* 1124 */       this._inventoryDocumentLineItem.rollbackChanges();
/*      */     }
/*      */     
/* 1127 */     this._properties = this._propertiesSavepoint;
/* 1128 */     this._propertiesSavepoint = null;
/* 1129 */     if (this._properties != null) {
/* 1130 */       Iterator<IDataModel> it = this._properties.iterator();
/* 1131 */       while (it.hasNext()) {
/* 1132 */         ((IDataModel)it.next()).rollbackChanges();
/*      */       }
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public void commitTransaction() {
/* 1140 */     if (this._alreadyInCommit) {
/*      */       return;
/*      */     }
/* 1143 */     this._alreadyInCommit = true;
/*      */ 
/*      */     
/* 1146 */     super.commitTransaction();
/*      */     
/* 1148 */     this._inventoryDocumentLineItemSavepoint = this._inventoryDocumentLineItem;
/* 1149 */     if (this._inventoryDocumentLineItem != null) {
/* 1150 */       this._inventoryDocumentLineItem.commitTransaction();
/*      */     }
/*      */     
/* 1153 */     this._propertiesSavepoint = this._properties;
/* 1154 */     if (this._properties != null) {
/* 1155 */       Iterator<IDataModel> it = this._properties.iterator();
/* 1156 */       while (it.hasNext()) {
/* 1157 */         ((IDataModel)it.next()).commitTransaction();
/*      */       }
/* 1159 */       this._properties = new HistoricalList((List)this._properties);
/*      */     } 
/*      */ 
/*      */     
/* 1163 */     this._alreadyInCommit = false;
/*      */   }
/*      */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\inv\impl\InventoryTransactionDetailModel.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */