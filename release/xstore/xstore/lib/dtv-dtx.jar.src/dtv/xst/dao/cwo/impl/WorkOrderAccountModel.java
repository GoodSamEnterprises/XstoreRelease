/*      */ package dtv.xst.dao.cwo.impl;
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
/*      */ import dtv.xst.dao.cat.ICustomerAccountJournal;
/*      */ import dtv.xst.dao.cat.impl.CustomerItemAccountModel;
/*      */ import dtv.xst.dao.cwo.IServiceLocation;
/*      */ import dtv.xst.dao.cwo.IWorkItem;
/*      */ import dtv.xst.dao.cwo.IWorkOrderAccount;
/*      */ import dtv.xst.dao.cwo.IWorkOrderAccountJournal;
/*      */ import dtv.xst.dao.cwo.IWorkOrderCategory;
/*      */ import dtv.xst.dao.cwo.IWorkOrderPriceCode;
/*      */ import java.io.IOException;
/*      */ import java.io.ObjectInputStream;
/*      */ import java.math.BigDecimal;
/*      */ import java.util.ArrayList;
/*      */ import java.util.Date;
/*      */ import java.util.Iterator;
/*      */ import java.util.List;
/*      */ 
/*      */ public class WorkOrderAccountModel extends CustomerItemAccountModel implements IWorkOrderAccount {
/*      */   private static final long serialVersionUID = -588729136L;
/*      */   private transient boolean _alreadyInStart = false;
/*      */   private transient boolean _alreadyInCommit = false;
/*      */   
/*      */   public void initDAO() {
/*   35 */     setDAO((IDataAccessObject)new WorkOrderAccountDAO());
/*      */   }
/*      */   private IDataModel _myExtension; private HistoricalList<IWorkItem> _workItemsRelationship; private transient HistoricalList<IWorkItem> _workItemsRelationshipSavepoint; private IServiceLocation _workOrderAccountServiceLocation; private transient IServiceLocation _workOrderAccountServiceLocationSavepoint; private IWorkOrderCategory _workOrderAccountCategory;
/*      */   private transient IWorkOrderCategory _workOrderAccountCategorySavepoint;
/*      */   private IWorkOrderPriceCode _workOrderAccountPriceCode;
/*      */   private transient IWorkOrderPriceCode _workOrderAccountPriceCodeSavepoint;
/*      */   
/*      */   private WorkOrderAccountDAO getDAO_() {
/*   43 */     return (WorkOrderAccountDAO)this._daoImpl;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public long getOrganizationId() {
/*   51 */     if (getDAO_().getOrganizationId() != null) {
/*   52 */       return getDAO_().getOrganizationId().longValue();
/*      */     }
/*      */     
/*   55 */     return 0L;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setOrganizationId(long argOrganizationId) {
/*   64 */     if (setOrganizationId_noev(argOrganizationId) && 
/*   65 */       this._events != null && 
/*   66 */       postEventsForChanges()) {
/*   67 */       this._events.post(IWorkOrderAccount.SET_ORGANIZATIONID, Long.valueOf(argOrganizationId));
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean setOrganizationId_noev(long argOrganizationId) {
/*   74 */     boolean ev_postable = false;
/*      */ 
/*      */     
/*   77 */     if (super.setOrganizationId_noev(argOrganizationId) && 
/*   78 */       this._workItemsRelationship != null) {
/*      */       
/*   80 */       Iterator<WorkItemModel> it = this._workItemsRelationship.iterator();
/*   81 */       while (it.hasNext())
/*      */       {
/*   83 */         ((WorkItemModel)it.next()).setOrganizationId_noev(argOrganizationId);
/*      */       }
/*      */     } 
/*      */ 
/*      */     
/*   88 */     return ev_postable;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public String getCustAccountId() {
/*   96 */     return getDAO_().getCustAccountId();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setCustAccountId(String argCustAccountId) {
/*  104 */     if (setCustAccountId_noev(argCustAccountId) && 
/*  105 */       this._events != null && 
/*  106 */       postEventsForChanges()) {
/*  107 */       this._events.post(IWorkOrderAccount.SET_CUSTACCOUNTID, argCustAccountId);
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean setCustAccountId_noev(String argCustAccountId) {
/*  114 */     boolean ev_postable = false;
/*      */ 
/*      */     
/*  117 */     if (super.setCustAccountId_noev(argCustAccountId) && 
/*  118 */       this._workItemsRelationship != null) {
/*      */       
/*  120 */       Iterator<WorkItemModel> it = this._workItemsRelationship.iterator();
/*  121 */       while (it.hasNext())
/*      */       {
/*  123 */         ((WorkItemModel)it.next()).setCustAccountId_noev(argCustAccountId);
/*      */       }
/*      */     } 
/*      */ 
/*      */     
/*  128 */     return ev_postable;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public String getCustAccountCode() {
/*  136 */     return getDAO_().getCustAccountCode();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setCustAccountCode(String argCustAccountCode) {
/*  144 */     if (setCustAccountCode_noev(argCustAccountCode) && 
/*  145 */       this._events != null && 
/*  146 */       postEventsForChanges()) {
/*  147 */       this._events.post(IWorkOrderAccount.SET_CUSTACCOUNTCODE, argCustAccountCode);
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean setCustAccountCode_noev(String argCustAccountCode) {
/*  154 */     boolean ev_postable = false;
/*      */ 
/*      */     
/*  157 */     if (super.setCustAccountCode_noev(argCustAccountCode) && 
/*  158 */       this._workItemsRelationship != null) {
/*      */       
/*  160 */       Iterator<WorkItemModel> it = this._workItemsRelationship.iterator();
/*  161 */       while (it.hasNext())
/*      */       {
/*  163 */         ((WorkItemModel)it.next()).setCustAccountCode_noev(argCustAccountCode);
/*      */       }
/*      */     } 
/*      */ 
/*      */     
/*  168 */     return ev_postable;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public Date getCreateDate() {
/*  176 */     return getDAO_().getCreateDate();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setCreateDate(Date argCreateDate) {
/*  184 */     if (setCreateDate_noev(argCreateDate) && 
/*  185 */       this._events != null && 
/*  186 */       postEventsForChanges()) {
/*  187 */       this._events.post(IWorkOrderAccount.SET_CREATEDATE, argCreateDate);
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean setCreateDate_noev(Date argCreateDate) {
/*  194 */     boolean ev_postable = false;
/*      */     
/*  196 */     if ((getDAO_().getCreateDate() == null && argCreateDate != null) || (
/*  197 */       getDAO_().getCreateDate() != null && !getDAO_().getCreateDate().equals(argCreateDate))) {
/*  198 */       getDAO_().setCreateDate(argCreateDate);
/*  199 */       ev_postable = true;
/*      */     } 
/*      */     
/*  202 */     return ev_postable;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public String getCreateUserId() {
/*  210 */     return getDAO_().getCreateUserId();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setCreateUserId(String argCreateUserId) {
/*  218 */     if (setCreateUserId_noev(argCreateUserId) && 
/*  219 */       this._events != null && 
/*  220 */       postEventsForChanges()) {
/*  221 */       this._events.post(IWorkOrderAccount.SET_CREATEUSERID, argCreateUserId);
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean setCreateUserId_noev(String argCreateUserId) {
/*  228 */     boolean ev_postable = false;
/*      */     
/*  230 */     if ((getDAO_().getCreateUserId() == null && argCreateUserId != null) || (
/*  231 */       getDAO_().getCreateUserId() != null && !getDAO_().getCreateUserId().equals(argCreateUserId))) {
/*  232 */       getDAO_().setCreateUserId(argCreateUserId);
/*  233 */       ev_postable = true;
/*      */     } 
/*      */     
/*  236 */     return ev_postable;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public Date getUpdateDate() {
/*  244 */     return getDAO_().getUpdateDate();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setUpdateDate(Date argUpdateDate) {
/*  252 */     if (setUpdateDate_noev(argUpdateDate) && 
/*  253 */       this._events != null && 
/*  254 */       postEventsForChanges()) {
/*  255 */       this._events.post(IWorkOrderAccount.SET_UPDATEDATE, argUpdateDate);
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean setUpdateDate_noev(Date argUpdateDate) {
/*  262 */     boolean ev_postable = false;
/*      */     
/*  264 */     if ((getDAO_().getUpdateDate() == null && argUpdateDate != null) || (
/*  265 */       getDAO_().getUpdateDate() != null && !getDAO_().getUpdateDate().equals(argUpdateDate))) {
/*  266 */       getDAO_().setUpdateDate(argUpdateDate);
/*  267 */       ev_postable = true;
/*      */     } 
/*      */     
/*  270 */     return ev_postable;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public String getUpdateUserId() {
/*  278 */     return getDAO_().getUpdateUserId();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setUpdateUserId(String argUpdateUserId) {
/*  286 */     if (setUpdateUserId_noev(argUpdateUserId) && 
/*  287 */       this._events != null && 
/*  288 */       postEventsForChanges()) {
/*  289 */       this._events.post(IWorkOrderAccount.SET_UPDATEUSERID, argUpdateUserId);
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean setUpdateUserId_noev(String argUpdateUserId) {
/*  296 */     boolean ev_postable = false;
/*      */     
/*  298 */     if ((getDAO_().getUpdateUserId() == null && argUpdateUserId != null) || (
/*  299 */       getDAO_().getUpdateUserId() != null && !getDAO_().getUpdateUserId().equals(argUpdateUserId))) {
/*  300 */       getDAO_().setUpdateUserId(argUpdateUserId);
/*  301 */       ev_postable = true;
/*      */     } 
/*      */     
/*  304 */     return ev_postable;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public BigDecimal getTotalValueDao() {
/*  312 */     return getDAO_().getTotalValueDao();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setTotalValueDao(BigDecimal argTotalValueDao) {
/*  320 */     if (setTotalValueDao_noev(argTotalValueDao) && 
/*  321 */       this._events != null && 
/*  322 */       postEventsForChanges()) {
/*  323 */       this._events.post(IWorkOrderAccount.SET_TOTALVALUEDAO, argTotalValueDao);
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean setTotalValueDao_noev(BigDecimal argTotalValueDao) {
/*  330 */     boolean ev_postable = false;
/*      */     
/*  332 */     if ((getDAO_().getTotalValueDao() == null && argTotalValueDao != null) || (
/*  333 */       getDAO_().getTotalValueDao() != null && !getDAO_().getTotalValueDao().equals(argTotalValueDao))) {
/*  334 */       getDAO_().setTotalValueDao(argTotalValueDao);
/*  335 */       ev_postable = true;
/*      */     } 
/*      */     
/*  338 */     return ev_postable;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public Date getEstimatedCompletionDate() {
/*  346 */     return getDAO_().getEstimatedCompletionDate();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setEstimatedCompletionDate(Date argEstimatedCompletionDate) {
/*  354 */     if (setEstimatedCompletionDate_noev(argEstimatedCompletionDate) && 
/*  355 */       this._events != null && 
/*  356 */       postEventsForChanges()) {
/*  357 */       this._events.post(IWorkOrderAccount.SET_ESTIMATEDCOMPLETIONDATE, argEstimatedCompletionDate);
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean setEstimatedCompletionDate_noev(Date argEstimatedCompletionDate) {
/*  364 */     boolean ev_postable = false;
/*      */     
/*  366 */     if ((getDAO_().getEstimatedCompletionDate() == null && argEstimatedCompletionDate != null) || (
/*  367 */       getDAO_().getEstimatedCompletionDate() != null && !getDAO_().getEstimatedCompletionDate().equals(argEstimatedCompletionDate))) {
/*  368 */       getDAO_().setEstimatedCompletionDate(argEstimatedCompletionDate);
/*  369 */       ev_postable = true;
/*      */     } 
/*      */     
/*  372 */     return ev_postable;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public BigDecimal getApprovedWorkAmount() {
/*  380 */     return getDAO_().getApprovedWorkAmount();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setApprovedWorkAmount(BigDecimal argApprovedWorkAmount) {
/*  388 */     if (setApprovedWorkAmount_noev(argApprovedWorkAmount) && 
/*  389 */       this._events != null && 
/*  390 */       postEventsForChanges()) {
/*  391 */       this._events.post(IWorkOrderAccount.SET_APPROVEDWORKAMOUNT, argApprovedWorkAmount);
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean setApprovedWorkAmount_noev(BigDecimal argApprovedWorkAmount) {
/*  398 */     boolean ev_postable = false;
/*      */     
/*  400 */     if ((getDAO_().getApprovedWorkAmount() == null && argApprovedWorkAmount != null) || (
/*  401 */       getDAO_().getApprovedWorkAmount() != null && !getDAO_().getApprovedWorkAmount().equals(argApprovedWorkAmount))) {
/*  402 */       getDAO_().setApprovedWorkAmount(argApprovedWorkAmount);
/*  403 */       ev_postable = true;
/*      */     } 
/*      */     
/*  406 */     return ev_postable;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public Date getApprovedWorkDate() {
/*  414 */     return getDAO_().getApprovedWorkDate();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setApprovedWorkDate(Date argApprovedWorkDate) {
/*  422 */     if (setApprovedWorkDate_noev(argApprovedWorkDate) && 
/*  423 */       this._events != null && 
/*  424 */       postEventsForChanges()) {
/*  425 */       this._events.post(IWorkOrderAccount.SET_APPROVEDWORKDATE, argApprovedWorkDate);
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean setApprovedWorkDate_noev(Date argApprovedWorkDate) {
/*  432 */     boolean ev_postable = false;
/*      */     
/*  434 */     if ((getDAO_().getApprovedWorkDate() == null && argApprovedWorkDate != null) || (
/*  435 */       getDAO_().getApprovedWorkDate() != null && !getDAO_().getApprovedWorkDate().equals(argApprovedWorkDate))) {
/*  436 */       getDAO_().setApprovedWorkDate(argApprovedWorkDate);
/*  437 */       ev_postable = true;
/*      */     } 
/*      */     
/*  440 */     return ev_postable;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public Date getLastCustomerNoticeDate() {
/*  448 */     return getDAO_().getLastCustomerNoticeDate();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setLastCustomerNoticeDate(Date argLastCustomerNoticeDate) {
/*  456 */     if (setLastCustomerNoticeDate_noev(argLastCustomerNoticeDate) && 
/*  457 */       this._events != null && 
/*  458 */       postEventsForChanges()) {
/*  459 */       this._events.post(IWorkOrderAccount.SET_LASTCUSTOMERNOTICEDATE, argLastCustomerNoticeDate);
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean setLastCustomerNoticeDate_noev(Date argLastCustomerNoticeDate) {
/*  466 */     boolean ev_postable = false;
/*      */     
/*  468 */     if ((getDAO_().getLastCustomerNoticeDate() == null && argLastCustomerNoticeDate != null) || (
/*  469 */       getDAO_().getLastCustomerNoticeDate() != null && !getDAO_().getLastCustomerNoticeDate().equals(argLastCustomerNoticeDate))) {
/*  470 */       getDAO_().setLastCustomerNoticeDate(argLastCustomerNoticeDate);
/*  471 */       ev_postable = true;
/*      */     } 
/*      */     
/*  474 */     return ev_postable;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public String getContactMethodCode() {
/*  482 */     return getDAO_().getContactMethodCode();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setContactMethodCode(String argContactMethodCode) {
/*  490 */     if (setContactMethodCode_noev(argContactMethodCode) && 
/*  491 */       this._events != null && 
/*  492 */       postEventsForChanges()) {
/*  493 */       this._events.post(IWorkOrderAccount.SET_CONTACTMETHODCODE, argContactMethodCode);
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean setContactMethodCode_noev(String argContactMethodCode) {
/*  500 */     boolean ev_postable = false;
/*      */     
/*  502 */     if ((getDAO_().getContactMethodCode() == null && argContactMethodCode != null) || (
/*  503 */       getDAO_().getContactMethodCode() != null && !getDAO_().getContactMethodCode().equals(argContactMethodCode))) {
/*  504 */       getDAO_().setContactMethodCode(argContactMethodCode);
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
/*      */   public String getPriorityCode() {
/*  516 */     return getDAO_().getPriorityCode();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setPriorityCode(String argPriorityCode) {
/*  524 */     if (setPriorityCode_noev(argPriorityCode) && 
/*  525 */       this._events != null && 
/*  526 */       postEventsForChanges()) {
/*  527 */       this._events.post(IWorkOrderAccount.SET_PRIORITYCODE, argPriorityCode);
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean setPriorityCode_noev(String argPriorityCode) {
/*  534 */     boolean ev_postable = false;
/*      */     
/*  536 */     if ((getDAO_().getPriorityCode() == null && argPriorityCode != null) || (
/*  537 */       getDAO_().getPriorityCode() != null && !getDAO_().getPriorityCode().equals(argPriorityCode))) {
/*  538 */       getDAO_().setPriorityCode(argPriorityCode);
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
/*      */   public String getServiceLocationId() {
/*  550 */     return getDAO_().getServiceLocationId();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setServiceLocationId(String argServiceLocationId) {
/*  558 */     if (setServiceLocationId_noev(argServiceLocationId) && 
/*  559 */       this._events != null && 
/*  560 */       postEventsForChanges()) {
/*  561 */       this._events.post(IWorkOrderAccount.SET_SERVICELOCATIONID, argServiceLocationId);
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean setServiceLocationId_noev(String argServiceLocationId) {
/*  568 */     boolean ev_postable = false;
/*      */     
/*  570 */     if ((getDAO_().getServiceLocationId() == null && argServiceLocationId != null) || (
/*  571 */       getDAO_().getServiceLocationId() != null && !getDAO_().getServiceLocationId().equals(argServiceLocationId))) {
/*  572 */       getDAO_().setServiceLocationId(argServiceLocationId);
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
/*      */   public String getCategoryId() {
/*  584 */     return getDAO_().getCategoryId();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setCategoryId(String argCategoryId) {
/*  592 */     if (setCategoryId_noev(argCategoryId) && 
/*  593 */       this._events != null && 
/*  594 */       postEventsForChanges()) {
/*  595 */       this._events.post(IWorkOrderAccount.SET_CATEGORYID, argCategoryId);
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean setCategoryId_noev(String argCategoryId) {
/*  602 */     boolean ev_postable = false;
/*      */     
/*  604 */     if ((getDAO_().getCategoryId() == null && argCategoryId != null) || (
/*  605 */       getDAO_().getCategoryId() != null && !getDAO_().getCategoryId().equals(argCategoryId))) {
/*  606 */       getDAO_().setCategoryId(argCategoryId);
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
/*      */   public String getPriceCodeString() {
/*  618 */     return getDAO_().getPriceCodeString();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setPriceCodeString(String argPriceCodeString) {
/*  626 */     if (setPriceCodeString_noev(argPriceCodeString) && 
/*  627 */       this._events != null && 
/*  628 */       postEventsForChanges()) {
/*  629 */       this._events.post(IWorkOrderAccount.SET_PRICECODESTRING, argPriceCodeString);
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean setPriceCodeString_noev(String argPriceCodeString) {
/*  636 */     boolean ev_postable = false;
/*      */     
/*  638 */     if ((getDAO_().getPriceCodeString() == null && argPriceCodeString != null) || (
/*  639 */       getDAO_().getPriceCodeString() != null && !getDAO_().getPriceCodeString().equals(argPriceCodeString))) {
/*  640 */       getDAO_().setPriceCodeString(argPriceCodeString);
/*  641 */       ev_postable = true;
/*      */     } 
/*      */     
/*  644 */     return ev_postable;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public BigDecimal getCost() {
/*  652 */     return getDAO_().getCost();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setCost(BigDecimal argCost) {
/*  660 */     if (setCost_noev(argCost) && 
/*  661 */       this._events != null && 
/*  662 */       postEventsForChanges()) {
/*  663 */       this._events.post(IWorkOrderAccount.SET_COST, argCost);
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean setCost_noev(BigDecimal argCost) {
/*  670 */     boolean ev_postable = false;
/*      */     
/*  672 */     if ((getDAO_().getCost() == null && argCost != null) || (
/*  673 */       getDAO_().getCost() != null && !getDAO_().getCost().equals(argCost))) {
/*  674 */       getDAO_().setCost(argCost);
/*  675 */       ev_postable = true;
/*      */     } 
/*      */     
/*  678 */     return ev_postable;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public String getInvoiceNumber() {
/*  686 */     return getDAO_().getInvoiceNumber();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setInvoiceNumber(String argInvoiceNumber) {
/*  694 */     if (setInvoiceNumber_noev(argInvoiceNumber) && 
/*  695 */       this._events != null && 
/*  696 */       postEventsForChanges()) {
/*  697 */       this._events.post(IWorkOrderAccount.SET_INVOICENUMBER, argInvoiceNumber);
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean setInvoiceNumber_noev(String argInvoiceNumber) {
/*  704 */     boolean ev_postable = false;
/*      */     
/*  706 */     if ((getDAO_().getInvoiceNumber() == null && argInvoiceNumber != null) || (
/*  707 */       getDAO_().getInvoiceNumber() != null && !getDAO_().getInvoiceNumber().equals(argInvoiceNumber))) {
/*  708 */       getDAO_().setInvoiceNumber(argInvoiceNumber);
/*  709 */       ev_postable = true;
/*      */     } 
/*      */     
/*  712 */     return ev_postable;
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
/*      */   @Relationship(name = "WorkItemsRelationship")
/*      */   public List<IWorkItem> getWorkItemsRelationship() {
/*  730 */     if (this._workItemsRelationship == null) {
/*  731 */       this._workItemsRelationship = new HistoricalList(null);
/*      */     }
/*  733 */     return (List<IWorkItem>)this._workItemsRelationship;
/*      */   }
/*      */   
/*      */   protected void setWorkItemsRelationshipImpl(List<IWorkItem> argWorkItemsRelationship) {
/*  737 */     if (this._workItemsRelationship == null) {
/*  738 */       this._workItemsRelationship = new HistoricalList(argWorkItemsRelationship);
/*      */     } else {
/*  740 */       this._workItemsRelationship.setCurrentList(argWorkItemsRelationship);
/*      */     } 
/*      */     
/*  743 */     for (IWorkItem child : this._workItemsRelationship) {
/*  744 */       child.setWorkOrderAccount(this);
/*      */     }
/*      */     
/*  747 */     for (IWorkItem child : this._workItemsRelationship) {
/*  748 */       WorkItemModel model = (WorkItemModel)child;
/*  749 */       model.setOrganizationId_noev(getOrganizationId());
/*  750 */       model.setCustAccountId_noev(getCustAccountId());
/*  751 */       model.setCustAccountCode_noev(getCustAccountCode());
/*  752 */       if (child instanceof IDataModelImpl) {
/*  753 */         IDataAccessObject childDao = ((IDataModelImpl)child).getDAO();
/*  754 */         if (StringUtils.isEmpty(childDao.getOriginDataSource()) && 
/*  755 */           !StringUtils.isEmpty(getDAO().getOriginDataSource())) {
/*  756 */           childDao.setOriginDataSource(getDAO().getOriginDataSource());
/*      */         }
/*      */       } 
/*  759 */       if (postEventsForChanges()) {
/*  760 */         this._eventManager.registerEventHandler((IEventAware)this._eventCascade, (IEventSource)child);
/*      */       }
/*      */     } 
/*      */   }
/*      */ 
/*      */   
/*      */   protected void addWorkItemImpl(IWorkItem argWorkItem) {
/*  767 */     argWorkItem.setWorkOrderAccount(this);
/*  768 */     if (this._workItemsRelationship == null) {
/*  769 */       this._workItemsRelationship = new HistoricalList(null);
/*      */     }
/*  771 */     argWorkItem.setOrganizationId(getOrganizationId());
/*  772 */     argWorkItem.setCustAccountId(getCustAccountId());
/*  773 */     argWorkItem.setCustAccountCode(getCustAccountCode());
/*  774 */     if (argWorkItem instanceof IDataModelImpl) {
/*  775 */       IDataAccessObject childDao = ((IDataModelImpl)argWorkItem).getDAO();
/*  776 */       if (StringUtils.isEmpty(childDao.getOriginDataSource()) && 
/*  777 */         !StringUtils.isEmpty(getDAO().getOriginDataSource())) {
/*  778 */         childDao.setOriginDataSource(getDAO().getOriginDataSource());
/*      */       }
/*      */     } 
/*      */ 
/*      */     
/*  783 */     if (postEventsForChanges()) {
/*  784 */       this._eventManager.registerEventHandler((IEventAware)this._eventCascade, (IEventSource)new EventDescriptor(argWorkItem));
/*      */     }
/*      */     
/*  787 */     this._workItemsRelationship.add(argWorkItem);
/*  788 */     if (postEventsForChanges()) {
/*  789 */       this._events.post(IWorkOrderAccount.ADD_WORKITEMSRELATIONSHIP, argWorkItem);
/*      */     }
/*      */   }
/*      */   
/*      */   public void removeWorkItem(IWorkItem argWorkItem) {
/*  794 */     if (this._workItemsRelationship != null) {
/*      */       
/*  796 */       if (postEventsForChanges()) {
/*  797 */         this._eventManager.deregisterEventHandler((IEventAware)this._eventCascade, (IEventSource)new EventDescriptor(argWorkItem));
/*      */       }
/*  799 */       this._workItemsRelationship.remove(argWorkItem);
/*      */       
/*  801 */       argWorkItem.setWorkOrderAccount(null);
/*  802 */       if (postEventsForChanges()) {
/*  803 */         this._events.post(IWorkOrderAccount.REMOVE_WORKITEMSRELATIONSHIP, argWorkItem);
/*      */       }
/*      */     } 
/*      */   }
/*      */   
/*      */   @Relationship(name = "WorkOrderAccountServiceLocation")
/*      */   public IServiceLocation getWorkOrderAccountServiceLocation() {
/*  810 */     return this._workOrderAccountServiceLocation;
/*      */   }
/*      */ 
/*      */   
/*      */   public void setWorkOrderAccountServiceLocation(IServiceLocation argWorkOrderAccountServiceLocation) {
/*  815 */     if (argWorkOrderAccountServiceLocation == null) {
/*      */       
/*  817 */       getDAO_().setServiceLocationId((String)null);
/*  818 */       if (this._workOrderAccountServiceLocation != null)
/*      */       {
/*  820 */         if (postEventsForChanges()) {
/*  821 */           this._eventManager.deregisterEventHandler((IEventAware)this._eventCascade, (IEventSource)new EventDescriptor(this._workOrderAccountServiceLocation));
/*      */         }
/*      */       }
/*      */     } else {
/*      */       
/*  826 */       getDAO_().setServiceLocationId(argWorkOrderAccountServiceLocation.getServiceLocationId());
/*      */       
/*  828 */       if (postEventsForChanges()) {
/*  829 */         this._eventManager.registerEventHandler((IEventAware)this._eventCascade, (IEventSource)new EventDescriptor(argWorkOrderAccountServiceLocation));
/*      */       }
/*      */     } 
/*      */     
/*  833 */     this._workOrderAccountServiceLocation = argWorkOrderAccountServiceLocation;
/*  834 */     if (postEventsForChanges()) {
/*  835 */       this._events.post(IWorkOrderAccount.SET_WORKORDERACCOUNTSERVICELOCATION, argWorkOrderAccountServiceLocation);
/*      */     }
/*      */   }
/*      */   
/*      */   @Relationship(name = "WorkOrderAccountCategory")
/*      */   public IWorkOrderCategory getWorkOrderAccountCategory() {
/*  841 */     return this._workOrderAccountCategory;
/*      */   }
/*      */ 
/*      */   
/*      */   public void setWorkOrderAccountCategory(IWorkOrderCategory argWorkOrderAccountCategory) {
/*  846 */     if (argWorkOrderAccountCategory == null) {
/*      */       
/*  848 */       getDAO_().setCategoryId((String)null);
/*  849 */       if (this._workOrderAccountCategory != null)
/*      */       {
/*  851 */         if (postEventsForChanges()) {
/*  852 */           this._eventManager.deregisterEventHandler((IEventAware)this._eventCascade, (IEventSource)new EventDescriptor(this._workOrderAccountCategory));
/*      */         }
/*      */       }
/*      */     } else {
/*      */       
/*  857 */       getDAO_().setCategoryId(argWorkOrderAccountCategory.getCategoryId());
/*      */       
/*  859 */       if (postEventsForChanges()) {
/*  860 */         this._eventManager.registerEventHandler((IEventAware)this._eventCascade, (IEventSource)new EventDescriptor(argWorkOrderAccountCategory));
/*      */       }
/*      */     } 
/*      */     
/*  864 */     this._workOrderAccountCategory = argWorkOrderAccountCategory;
/*  865 */     if (postEventsForChanges()) {
/*  866 */       this._events.post(IWorkOrderAccount.SET_WORKORDERACCOUNTCATEGORY, argWorkOrderAccountCategory);
/*      */     }
/*      */   }
/*      */   
/*      */   @Relationship(name = "WorkOrderAccountPriceCode")
/*      */   public IWorkOrderPriceCode getWorkOrderAccountPriceCode() {
/*  872 */     return this._workOrderAccountPriceCode;
/*      */   }
/*      */ 
/*      */   
/*      */   public void setWorkOrderAccountPriceCode(IWorkOrderPriceCode argWorkOrderAccountPriceCode) {
/*  877 */     if (argWorkOrderAccountPriceCode == null) {
/*      */       
/*  879 */       getDAO_().setPriceCodeString((String)null);
/*  880 */       if (this._workOrderAccountPriceCode != null)
/*      */       {
/*  882 */         if (postEventsForChanges()) {
/*  883 */           this._eventManager.deregisterEventHandler((IEventAware)this._eventCascade, (IEventSource)new EventDescriptor(this._workOrderAccountPriceCode));
/*      */         }
/*      */       }
/*      */     } else {
/*      */       
/*  888 */       getDAO_().setPriceCodeString(argWorkOrderAccountPriceCode.getPriceCode());
/*      */       
/*  890 */       if (postEventsForChanges()) {
/*  891 */         this._eventManager.registerEventHandler((IEventAware)this._eventCascade, (IEventSource)new EventDescriptor(argWorkOrderAccountPriceCode));
/*      */       }
/*      */     } 
/*      */     
/*  895 */     this._workOrderAccountPriceCode = argWorkOrderAccountPriceCode;
/*  896 */     if (postEventsForChanges()) {
/*  897 */       this._events.post(IWorkOrderAccount.SET_WORKORDERACCOUNTPRICECODE, argWorkOrderAccountPriceCode);
/*      */     }
/*      */   }
/*      */ 
/*      */   
/*      */   public Object getValue(String argFieldId) {
/*  903 */     if ("WorkItemsRelationship".equals(argFieldId)) {
/*  904 */       return getWorkItemsRelationship();
/*      */     }
/*  906 */     if ("WorkOrderAccountServiceLocation".equals(argFieldId)) {
/*  907 */       return getWorkOrderAccountServiceLocation();
/*      */     }
/*  909 */     if ("WorkOrderAccountCategory".equals(argFieldId)) {
/*  910 */       return getWorkOrderAccountCategory();
/*      */     }
/*  912 */     if ("WorkOrderAccountPriceCode".equals(argFieldId)) {
/*  913 */       return getWorkOrderAccountPriceCode();
/*      */     }
/*  915 */     if ("WorkOrderAccountExtension".equals(argFieldId)) {
/*  916 */       return this._myExtension;
/*      */     }
/*      */     
/*  919 */     return super.getValue(argFieldId);
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public void setValue(String argFieldId, Object argValue) {
/*  925 */     if ("WorkItemsRelationship".equals(argFieldId)) {
/*  926 */       setWorkItemsRelationship(changeToList(argValue, IWorkItem.class));
/*      */     }
/*  928 */     else if ("WorkOrderAccountServiceLocation".equals(argFieldId)) {
/*  929 */       setWorkOrderAccountServiceLocation((IServiceLocation)argValue);
/*      */     }
/*  931 */     else if ("WorkOrderAccountCategory".equals(argFieldId)) {
/*  932 */       setWorkOrderAccountCategory((IWorkOrderCategory)argValue);
/*      */     }
/*  934 */     else if ("WorkOrderAccountPriceCode".equals(argFieldId)) {
/*  935 */       setWorkOrderAccountPriceCode((IWorkOrderPriceCode)argValue);
/*      */     }
/*  937 */     else if ("WorkOrderAccountExtension".equals(argFieldId)) {
/*  938 */       this._myExtension = (IDataModel)argValue;
/*      */     } else {
/*      */       
/*  941 */       super.setValue(argFieldId, argValue);
/*      */     } 
/*      */   }
/*      */ 
/*      */   
/*      */   public void setDependencies(IPersistenceDefaults argPD, EventManager argEM) {
/*  947 */     super.setDependencies(argPD, argEM);
/*  948 */     if (this._workItemsRelationship != null) {
/*  949 */       for (IWorkItem relationship : this._workItemsRelationship) {
/*  950 */         ((IDataModelImpl)relationship).setDependencies(argPD, argEM);
/*      */       }
/*      */     }
/*  953 */     if (this._workOrderAccountServiceLocation != null) {
/*  954 */       ((IDataModelImpl)this._workOrderAccountServiceLocation).setDependencies(argPD, argEM);
/*      */     }
/*  956 */     if (this._workOrderAccountCategory != null) {
/*  957 */       ((IDataModelImpl)this._workOrderAccountCategory).setDependencies(argPD, argEM);
/*      */     }
/*  959 */     if (this._workOrderAccountPriceCode != null) {
/*  960 */       ((IDataModelImpl)this._workOrderAccountPriceCode).setDependencies(argPD, argEM);
/*      */     }
/*      */   }
/*      */   
/*      */   public IDataModel getWorkOrderAccountExt() {
/*  965 */     return this._myExtension;
/*      */   }
/*      */   
/*      */   public void setWorkOrderAccountExt(IDataModel argExt) {
/*  969 */     this._myExtension = argExt;
/*      */   }
/*      */ 
/*      */   
/*      */   public void startTransaction() {
/*  974 */     if (this._alreadyInStart) {
/*      */       return;
/*      */     }
/*      */     
/*  978 */     this._alreadyInStart = true;
/*      */ 
/*      */     
/*  981 */     super.startTransaction();
/*      */     
/*  983 */     this._workItemsRelationshipSavepoint = this._workItemsRelationship;
/*  984 */     if (this._workItemsRelationship != null) {
/*  985 */       this._workItemsRelationshipSavepoint = new HistoricalList((List)this._workItemsRelationship);
/*  986 */       Iterator<IDataModel> it = this._workItemsRelationship.iterator();
/*  987 */       while (it.hasNext()) {
/*  988 */         ((IDataModel)it.next()).startTransaction();
/*      */       }
/*      */     } 
/*      */     
/*  992 */     this._workOrderAccountServiceLocationSavepoint = this._workOrderAccountServiceLocation;
/*  993 */     if (this._workOrderAccountServiceLocation != null) {
/*  994 */       this._workOrderAccountServiceLocation.startTransaction();
/*      */     }
/*      */     
/*  997 */     this._workOrderAccountCategorySavepoint = this._workOrderAccountCategory;
/*  998 */     if (this._workOrderAccountCategory != null) {
/*  999 */       this._workOrderAccountCategory.startTransaction();
/*      */     }
/*      */     
/* 1002 */     this._workOrderAccountPriceCodeSavepoint = this._workOrderAccountPriceCode;
/* 1003 */     if (this._workOrderAccountPriceCode != null) {
/* 1004 */       this._workOrderAccountPriceCode.startTransaction();
/*      */     }
/*      */ 
/*      */     
/* 1008 */     this._alreadyInStart = false;
/*      */   }
/*      */ 
/*      */   
/*      */   public void rollbackChanges() {
/* 1013 */     if (isAlreadyRolledBack()) {
/*      */       return;
/*      */     }
/* 1016 */     super.rollbackChanges();
/*      */     
/* 1018 */     this._workItemsRelationship = this._workItemsRelationshipSavepoint;
/* 1019 */     this._workItemsRelationshipSavepoint = null;
/* 1020 */     if (this._workItemsRelationship != null) {
/* 1021 */       Iterator<IDataModel> it = this._workItemsRelationship.iterator();
/* 1022 */       while (it.hasNext()) {
/* 1023 */         ((IDataModel)it.next()).rollbackChanges();
/*      */       }
/*      */     } 
/*      */     
/* 1027 */     this._workOrderAccountServiceLocation = this._workOrderAccountServiceLocationSavepoint;
/* 1028 */     this._workOrderAccountServiceLocationSavepoint = null;
/* 1029 */     if (this._workOrderAccountServiceLocation != null) {
/* 1030 */       this._workOrderAccountServiceLocation.rollbackChanges();
/*      */     }
/*      */     
/* 1033 */     this._workOrderAccountCategory = this._workOrderAccountCategorySavepoint;
/* 1034 */     this._workOrderAccountCategorySavepoint = null;
/* 1035 */     if (this._workOrderAccountCategory != null) {
/* 1036 */       this._workOrderAccountCategory.rollbackChanges();
/*      */     }
/*      */     
/* 1039 */     this._workOrderAccountPriceCode = this._workOrderAccountPriceCodeSavepoint;
/* 1040 */     this._workOrderAccountPriceCodeSavepoint = null;
/* 1041 */     if (this._workOrderAccountPriceCode != null) {
/* 1042 */       this._workOrderAccountPriceCode.rollbackChanges();
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public void commitTransaction() {
/* 1049 */     if (this._alreadyInCommit) {
/*      */       return;
/*      */     }
/* 1052 */     this._alreadyInCommit = true;
/*      */ 
/*      */     
/* 1055 */     super.commitTransaction();
/*      */     
/* 1057 */     this._workItemsRelationshipSavepoint = this._workItemsRelationship;
/* 1058 */     if (this._workItemsRelationship != null) {
/* 1059 */       Iterator<IDataModel> it = this._workItemsRelationship.iterator();
/* 1060 */       while (it.hasNext()) {
/* 1061 */         ((IDataModel)it.next()).commitTransaction();
/*      */       }
/* 1063 */       this._workItemsRelationship = new HistoricalList((List)this._workItemsRelationship);
/*      */     } 
/*      */     
/* 1066 */     this._workOrderAccountServiceLocationSavepoint = this._workOrderAccountServiceLocation;
/* 1067 */     if (this._workOrderAccountServiceLocation != null) {
/* 1068 */       this._workOrderAccountServiceLocation.commitTransaction();
/*      */     }
/*      */     
/* 1071 */     this._workOrderAccountCategorySavepoint = this._workOrderAccountCategory;
/* 1072 */     if (this._workOrderAccountCategory != null) {
/* 1073 */       this._workOrderAccountCategory.commitTransaction();
/*      */     }
/*      */     
/* 1076 */     this._workOrderAccountPriceCodeSavepoint = this._workOrderAccountPriceCode;
/* 1077 */     if (this._workOrderAccountPriceCode != null) {
/* 1078 */       this._workOrderAccountPriceCode.commitTransaction();
/*      */     }
/*      */ 
/*      */     
/* 1082 */     this._alreadyInCommit = false;
/*      */   }
/*      */ 
/*      */   
/*      */   private void readObject(ObjectInputStream argStream) throws IOException, ClassNotFoundException {
/* 1087 */     argStream.defaultReadObject();
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
/* 1100 */   private transient int openWorkItemCount = 0;
/*      */   
/*      */   public void saveToJournal(ICustomerAccountJournal argJournal) {
/* 1103 */     super.saveToJournal(argJournal);
/*      */     
/* 1105 */     if (argJournal instanceof IWorkOrderAccountJournal) {
/* 1106 */       IWorkOrderAccountJournal journal = (IWorkOrderAccountJournal)argJournal;
/*      */ 
/*      */       
/* 1109 */       journal.setApprovedWorkAmount(getApprovedWorkAmount());
/* 1110 */       journal.setApprovedWorkDate(getApprovedWorkDate());
/* 1111 */       journal.setContactMethod(getContactMethodCode());
/* 1112 */       journal.setEstimatedCompletionDate(getEstimatedCompletionDate());
/* 1113 */       journal.setLastCustomerNoticeDate(getLastCustomerNoticeDate());
/* 1114 */       journal.setPriceCodeString(getPriceCodeString());
/* 1115 */       journal.setPriorityCode(getPriorityCode());
/* 1116 */       journal.setTotalValue(getTotalValue());
/* 1117 */       journal.setWorkOrderAccountJournalCategory(getWorkOrderAccountCategory());
/* 1118 */       journal.setWorkOrderAccountJournalPriceCode(getWorkOrderAccountPriceCode());
/* 1119 */       journal.setWorkOrderAccountJournalServiceLocation(getWorkOrderAccountServiceLocation());
/*      */     } 
/*      */   }
/*      */   
/*      */   public void restoreFromJournal(ICustomerAccountJournal argJournal) {
/* 1124 */     super.restoreFromJournal(argJournal);
/*      */     
/* 1126 */     if (argJournal instanceof IWorkOrderAccountJournal) {
/* 1127 */       IWorkOrderAccountJournal journal = (IWorkOrderAccountJournal)argJournal;
/*      */ 
/*      */       
/* 1130 */       setApprovedWorkAmount(journal.getApprovedWorkAmount());
/* 1131 */       setApprovedWorkDate(journal.getApprovedWorkDate());
/* 1132 */       setContactMethodCode(journal.getContactMethod());
/* 1133 */       setEstimatedCompletionDate(journal.getEstimatedCompletionDate());
/* 1134 */       setLastCustomerNoticeDate(journal.getLastCustomerNoticeDate());
/* 1135 */       setPriceCodeString(journal.getPriceCodeString());
/* 1136 */       setPriorityCode(journal.getPriorityCode());
/* 1137 */       setTotalValue(journal.getTotalValue());
/* 1138 */       setWorkOrderAccountCategory(journal.getWorkOrderAccountJournalCategory());
/* 1139 */       setWorkOrderAccountPriceCode(journal.getWorkOrderAccountJournalPriceCode());
/* 1140 */       setWorkOrderAccountServiceLocation(journal.getWorkOrderAccountJournalServiceLocation());
/*      */     } 
/*      */   }
/*      */   
/*      */   public List<IWorkItem> getOpenWorkItems() {
/* 1145 */     List<IWorkItem> result = new ArrayList<>();
/* 1146 */     List<IWorkItem> details = getWorkItemsRelationship();
/* 1147 */     this.openWorkItemCount = 0;
/*      */     
/* 1149 */     if (details != null && !details.isEmpty()) {
/* 1150 */       for (IWorkItem detail : details) {
/* 1151 */         if (!detail.getVoid()) {
/* 1152 */           this.openWorkItemCount++;
/* 1153 */           result.add(detail);
/*      */         } 
/*      */       } 
/*      */     }
/* 1157 */     return result;
/*      */   }
/*      */   
/*      */   public void updateTotalValue() {
/* 1161 */     BigDecimal ZERO = BigDecimal.valueOf(0L);
/* 1162 */     BigDecimal l_totalValue = ZERO;
/*      */     
/* 1164 */     List<IWorkItem> items = getWorkItemsRelationship();
/* 1165 */     if (items != null && !items.isEmpty()) {
/* 1166 */       Iterator<IWorkItem> wis = items.iterator();
/* 1167 */       while (wis.hasNext()) {
/* 1168 */         IWorkItem wi = wis.next();
/* 1169 */         if (!wi.getVoid()) {
/* 1170 */           l_totalValue = l_totalValue.add(wi.getValueAmount());
/*      */         }
/*      */       } 
/*      */     } 
/* 1174 */     setTotalValue(l_totalValue);
/*      */   }
/*      */   
/*      */   public void setTotalValue(BigDecimal totalValue) {
/* 1178 */     setTotalValueDao(totalValue);
/*      */   }
/*      */   
/*      */   public BigDecimal getTotalValue() {
/* 1182 */     updateTotalValue();
/* 1183 */     return getTotalValueDao();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setWorkItemsRelationship(List<IWorkItem> workItems) {
/* 1190 */     setWorkItemsRelationshipImpl(workItems);
/* 1191 */     updateTotalValue();
/*      */   }
/*      */   
/*      */   public void addWorkItems(List<IWorkItem> argWorkItems) {
/* 1195 */     getWorkItemsRelationship().addAll(argWorkItems);
/* 1196 */     updateTotalValue();
/*      */   }
/*      */   
/*      */   public int getOpenWorkItemCount() {
/* 1200 */     getOpenWorkItems();
/* 1201 */     return this.openWorkItemCount;
/*      */   }
/*      */   
/*      */   public void setOpenWorkItemCount(int value) {
/* 1205 */     this.openWorkItemCount = value;
/* 1206 */     updateTotalValue();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void addWorkItem(IWorkItem workItem) {
/* 1213 */     addWorkItemImpl(workItem);
/* 1214 */     updateTotalValue();
/*      */   }
/*      */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\cwo\impl\WorkOrderAccountModel.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */