/*      */ package dtv.xst.dao.com.impl;
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
/*      */ import dtv.xst.dao.com.ITransactionPropertyPrompt;
/*      */ import dtv.xst.dao.com.ITransactionPropertyPromptProperty;
/*      */ import dtv.xst.dao.com.TransactionPropertyPromptPropertyId;
/*      */ import java.io.IOException;
/*      */ import java.io.ObjectInputStream;
/*      */ import java.util.Date;
/*      */ import java.util.Iterator;
/*      */ import java.util.List;
/*      */ 
/*      */ public class TransactionPropertyPromptModel extends AbstractDataModelWithPropertyImpl<ITransactionPropertyPromptProperty> implements ITransactionPropertyPrompt {
/*      */   private static final long serialVersionUID = 1510887927L;
/*      */   private transient boolean _alreadyInStart = false;
/*      */   private transient boolean _alreadyInCommit = false;
/*      */   
/*      */   public String toString() {
/*   33 */     return super.toString() + " Id: " + getObjectId();
/*      */   }
/*      */   private IDataModel _myExtension; private HistoricalList<ITransactionPropertyPromptProperty> _properties; private transient HistoricalList<ITransactionPropertyPromptProperty> _propertiesSavepoint;
/*      */   
/*      */   public void initDAO() {
/*   38 */     setDAO((IDataAccessObject)new TransactionPropertyPromptDAO());
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private TransactionPropertyPromptDAO getDAO_() {
/*   46 */     return (TransactionPropertyPromptDAO)this._daoImpl;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public long getOrganizationId() {
/*   54 */     if (getDAO_().getOrganizationId() != null) {
/*   55 */       return getDAO_().getOrganizationId().longValue();
/*      */     }
/*      */     
/*   58 */     return 0L;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setOrganizationId(long argOrganizationId) {
/*   67 */     if (setOrganizationId_noev(argOrganizationId) && 
/*   68 */       this._events != null && 
/*   69 */       postEventsForChanges()) {
/*   70 */       this._events.post(ITransactionPropertyPrompt.SET_ORGANIZATIONID, Long.valueOf(argOrganizationId));
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean setOrganizationId_noev(long argOrganizationId) {
/*   77 */     boolean ev_postable = false;
/*      */     
/*   79 */     if ((getDAO_().getOrganizationId() == null && Long.valueOf(argOrganizationId) != null) || (
/*   80 */       getDAO_().getOrganizationId() != null && !getDAO_().getOrganizationId().equals(Long.valueOf(argOrganizationId)))) {
/*   81 */       getDAO_().setOrganizationId(Long.valueOf(argOrganizationId));
/*   82 */       ev_postable = true;
/*   83 */       if (this._properties != null) {
/*      */         
/*   85 */         Iterator<TransactionPropertyPromptPropertyModel> it = this._properties.iterator();
/*   86 */         while (it.hasNext())
/*      */         {
/*   88 */           ((TransactionPropertyPromptPropertyModel)it.next()).setOrganizationId_noev(argOrganizationId);
/*      */         }
/*      */       } 
/*      */     } 
/*      */     
/*   93 */     return ev_postable;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public String getPromptPropertyCode() {
/*  101 */     return getDAO_().getPromptPropertyCode();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setPromptPropertyCode(String argPromptPropertyCode) {
/*  109 */     if (setPromptPropertyCode_noev(argPromptPropertyCode) && 
/*  110 */       this._events != null && 
/*  111 */       postEventsForChanges()) {
/*  112 */       this._events.post(ITransactionPropertyPrompt.SET_PROMPTPROPERTYCODE, argPromptPropertyCode);
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean setPromptPropertyCode_noev(String argPromptPropertyCode) {
/*  119 */     boolean ev_postable = false;
/*      */     
/*  121 */     if ((getDAO_().getPromptPropertyCode() == null && argPromptPropertyCode != null) || (
/*  122 */       getDAO_().getPromptPropertyCode() != null && !getDAO_().getPromptPropertyCode().equals(argPromptPropertyCode))) {
/*  123 */       getDAO_().setPromptPropertyCode(argPromptPropertyCode);
/*  124 */       ev_postable = true;
/*  125 */       if (this._properties != null) {
/*      */         
/*  127 */         Iterator<TransactionPropertyPromptPropertyModel> it = this._properties.iterator();
/*  128 */         while (it.hasNext())
/*      */         {
/*  130 */           ((TransactionPropertyPromptPropertyModel)it.next()).setPromptPropertyCode_noev(argPromptPropertyCode);
/*      */         }
/*      */       } 
/*      */     } 
/*      */     
/*  135 */     return ev_postable;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public Date getEffectiveDate() {
/*  143 */     return getDAO_().getEffectiveDate();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setEffectiveDate(Date argEffectiveDate) {
/*  151 */     if (setEffectiveDate_noev(argEffectiveDate) && 
/*  152 */       this._events != null && 
/*  153 */       postEventsForChanges()) {
/*  154 */       this._events.post(ITransactionPropertyPrompt.SET_EFFECTIVEDATE, argEffectiveDate);
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean setEffectiveDate_noev(Date argEffectiveDate) {
/*  161 */     boolean ev_postable = false;
/*      */     
/*  163 */     if ((getDAO_().getEffectiveDate() == null && argEffectiveDate != null) || (
/*  164 */       getDAO_().getEffectiveDate() != null && !getDAO_().getEffectiveDate().equals(argEffectiveDate))) {
/*  165 */       getDAO_().setEffectiveDate(argEffectiveDate);
/*  166 */       ev_postable = true;
/*  167 */       if (this._properties != null) {
/*      */         
/*  169 */         Iterator<TransactionPropertyPromptPropertyModel> it = this._properties.iterator();
/*  170 */         while (it.hasNext())
/*      */         {
/*  172 */           ((TransactionPropertyPromptPropertyModel)it.next()).setEffectiveDate_noev(argEffectiveDate);
/*      */         }
/*      */       } 
/*      */     } 
/*      */     
/*  177 */     return ev_postable;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public Date getCreateDate() {
/*  185 */     return getDAO_().getCreateDate();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setCreateDate(Date argCreateDate) {
/*  193 */     if (setCreateDate_noev(argCreateDate) && 
/*  194 */       this._events != null && 
/*  195 */       postEventsForChanges()) {
/*  196 */       this._events.post(ITransactionPropertyPrompt.SET_CREATEDATE, argCreateDate);
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean setCreateDate_noev(Date argCreateDate) {
/*  203 */     boolean ev_postable = false;
/*      */     
/*  205 */     if ((getDAO_().getCreateDate() == null && argCreateDate != null) || (
/*  206 */       getDAO_().getCreateDate() != null && !getDAO_().getCreateDate().equals(argCreateDate))) {
/*  207 */       getDAO_().setCreateDate(argCreateDate);
/*  208 */       ev_postable = true;
/*      */     } 
/*      */     
/*  211 */     return ev_postable;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public String getCreateUserId() {
/*  219 */     return getDAO_().getCreateUserId();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setCreateUserId(String argCreateUserId) {
/*  227 */     if (setCreateUserId_noev(argCreateUserId) && 
/*  228 */       this._events != null && 
/*  229 */       postEventsForChanges()) {
/*  230 */       this._events.post(ITransactionPropertyPrompt.SET_CREATEUSERID, argCreateUserId);
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean setCreateUserId_noev(String argCreateUserId) {
/*  237 */     boolean ev_postable = false;
/*      */     
/*  239 */     if ((getDAO_().getCreateUserId() == null && argCreateUserId != null) || (
/*  240 */       getDAO_().getCreateUserId() != null && !getDAO_().getCreateUserId().equals(argCreateUserId))) {
/*  241 */       getDAO_().setCreateUserId(argCreateUserId);
/*  242 */       ev_postable = true;
/*      */     } 
/*      */     
/*  245 */     return ev_postable;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public Date getUpdateDate() {
/*  253 */     return getDAO_().getUpdateDate();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setUpdateDate(Date argUpdateDate) {
/*  261 */     if (setUpdateDate_noev(argUpdateDate) && 
/*  262 */       this._events != null && 
/*  263 */       postEventsForChanges()) {
/*  264 */       this._events.post(ITransactionPropertyPrompt.SET_UPDATEDATE, argUpdateDate);
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean setUpdateDate_noev(Date argUpdateDate) {
/*  271 */     boolean ev_postable = false;
/*      */     
/*  273 */     if ((getDAO_().getUpdateDate() == null && argUpdateDate != null) || (
/*  274 */       getDAO_().getUpdateDate() != null && !getDAO_().getUpdateDate().equals(argUpdateDate))) {
/*  275 */       getDAO_().setUpdateDate(argUpdateDate);
/*  276 */       ev_postable = true;
/*      */     } 
/*      */     
/*  279 */     return ev_postable;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public String getUpdateUserId() {
/*  287 */     return getDAO_().getUpdateUserId();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setUpdateUserId(String argUpdateUserId) {
/*  295 */     if (setUpdateUserId_noev(argUpdateUserId) && 
/*  296 */       this._events != null && 
/*  297 */       postEventsForChanges()) {
/*  298 */       this._events.post(ITransactionPropertyPrompt.SET_UPDATEUSERID, argUpdateUserId);
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean setUpdateUserId_noev(String argUpdateUserId) {
/*  305 */     boolean ev_postable = false;
/*      */     
/*  307 */     if ((getDAO_().getUpdateUserId() == null && argUpdateUserId != null) || (
/*  308 */       getDAO_().getUpdateUserId() != null && !getDAO_().getUpdateUserId().equals(argUpdateUserId))) {
/*  309 */       getDAO_().setUpdateUserId(argUpdateUserId);
/*  310 */       ev_postable = true;
/*      */     } 
/*      */     
/*  313 */     return ev_postable;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public String getOrgCode() {
/*  321 */     return getDAO_().getOrgCode();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setOrgCode(String argOrgCode) {
/*  329 */     if (setOrgCode_noev(argOrgCode) && 
/*  330 */       this._events != null && 
/*  331 */       postEventsForChanges()) {
/*  332 */       this._events.post(ITransactionPropertyPrompt.SET_ORGCODE, argOrgCode);
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean setOrgCode_noev(String argOrgCode) {
/*  339 */     boolean ev_postable = false;
/*      */     
/*  341 */     if ((getDAO_().getOrgCode() == null && argOrgCode != null) || (
/*  342 */       getDAO_().getOrgCode() != null && !getDAO_().getOrgCode().equals(argOrgCode))) {
/*  343 */       getDAO_().setOrgCode(argOrgCode);
/*  344 */       ev_postable = true;
/*      */     } 
/*      */     
/*  347 */     return ev_postable;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public String getOrgValue() {
/*  355 */     return getDAO_().getOrgValue();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setOrgValue(String argOrgValue) {
/*  363 */     if (setOrgValue_noev(argOrgValue) && 
/*  364 */       this._events != null && 
/*  365 */       postEventsForChanges()) {
/*  366 */       this._events.post(ITransactionPropertyPrompt.SET_ORGVALUE, argOrgValue);
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean setOrgValue_noev(String argOrgValue) {
/*  373 */     boolean ev_postable = false;
/*      */     
/*  375 */     if ((getDAO_().getOrgValue() == null && argOrgValue != null) || (
/*  376 */       getDAO_().getOrgValue() != null && !getDAO_().getOrgValue().equals(argOrgValue))) {
/*  377 */       getDAO_().setOrgValue(argOrgValue);
/*  378 */       ev_postable = true;
/*      */     } 
/*      */     
/*  381 */     return ev_postable;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public Date getExpirationDate() {
/*  389 */     return getDAO_().getExpirationDate();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setExpirationDate(Date argExpirationDate) {
/*  397 */     if (setExpirationDate_noev(argExpirationDate) && 
/*  398 */       this._events != null && 
/*  399 */       postEventsForChanges()) {
/*  400 */       this._events.post(ITransactionPropertyPrompt.SET_EXPIRATIONDATE, argExpirationDate);
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean setExpirationDate_noev(Date argExpirationDate) {
/*  407 */     boolean ev_postable = false;
/*      */     
/*  409 */     if ((getDAO_().getExpirationDate() == null && argExpirationDate != null) || (
/*  410 */       getDAO_().getExpirationDate() != null && !getDAO_().getExpirationDate().equals(argExpirationDate))) {
/*  411 */       getDAO_().setExpirationDate(argExpirationDate);
/*  412 */       ev_postable = true;
/*      */     } 
/*      */     
/*  415 */     return ev_postable;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public String getPromptMethodCode() {
/*  423 */     return getDAO_().getPromptMethodCode();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setPromptMethodCode(String argPromptMethodCode) {
/*  431 */     if (setPromptMethodCode_noev(argPromptMethodCode) && 
/*  432 */       this._events != null && 
/*  433 */       postEventsForChanges()) {
/*  434 */       this._events.post(ITransactionPropertyPrompt.SET_PROMPTMETHODCODE, argPromptMethodCode);
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean setPromptMethodCode_noev(String argPromptMethodCode) {
/*  441 */     boolean ev_postable = false;
/*      */     
/*  443 */     if ((getDAO_().getPromptMethodCode() == null && argPromptMethodCode != null) || (
/*  444 */       getDAO_().getPromptMethodCode() != null && !getDAO_().getPromptMethodCode().equals(argPromptMethodCode))) {
/*  445 */       getDAO_().setPromptMethodCode(argPromptMethodCode);
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
/*      */   public String getCodeCategory() {
/*  457 */     return getDAO_().getCodeCategory();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setCodeCategory(String argCodeCategory) {
/*  465 */     if (setCodeCategory_noev(argCodeCategory) && 
/*  466 */       this._events != null && 
/*  467 */       postEventsForChanges()) {
/*  468 */       this._events.post(ITransactionPropertyPrompt.SET_CODECATEGORY, argCodeCategory);
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean setCodeCategory_noev(String argCodeCategory) {
/*  475 */     boolean ev_postable = false;
/*      */     
/*  477 */     if ((getDAO_().getCodeCategory() == null && argCodeCategory != null) || (
/*  478 */       getDAO_().getCodeCategory() != null && !getDAO_().getCodeCategory().equals(argCodeCategory))) {
/*  479 */       getDAO_().setCodeCategory(argCodeCategory);
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
/*      */   public String getPromptTitleKey() {
/*  491 */     return getDAO_().getPromptTitleKey();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setPromptTitleKey(String argPromptTitleKey) {
/*  499 */     if (setPromptTitleKey_noev(argPromptTitleKey) && 
/*  500 */       this._events != null && 
/*  501 */       postEventsForChanges()) {
/*  502 */       this._events.post(ITransactionPropertyPrompt.SET_PROMPTTITLEKEY, argPromptTitleKey);
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean setPromptTitleKey_noev(String argPromptTitleKey) {
/*  509 */     boolean ev_postable = false;
/*      */     
/*  511 */     if ((getDAO_().getPromptTitleKey() == null && argPromptTitleKey != null) || (
/*  512 */       getDAO_().getPromptTitleKey() != null && !getDAO_().getPromptTitleKey().equals(argPromptTitleKey))) {
/*  513 */       getDAO_().setPromptTitleKey(argPromptTitleKey);
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
/*      */   public String getPromptMessageKey() {
/*  525 */     return getDAO_().getPromptMessageKey();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setPromptMessageKey(String argPromptMessageKey) {
/*  533 */     if (setPromptMessageKey_noev(argPromptMessageKey) && 
/*  534 */       this._events != null && 
/*  535 */       postEventsForChanges()) {
/*  536 */       this._events.post(ITransactionPropertyPrompt.SET_PROMPTMESSAGEKEY, argPromptMessageKey);
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean setPromptMessageKey_noev(String argPromptMessageKey) {
/*  543 */     boolean ev_postable = false;
/*      */     
/*  545 */     if ((getDAO_().getPromptMessageKey() == null && argPromptMessageKey != null) || (
/*  546 */       getDAO_().getPromptMessageKey() != null && !getDAO_().getPromptMessageKey().equals(argPromptMessageKey))) {
/*  547 */       getDAO_().setPromptMessageKey(argPromptMessageKey);
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
/*      */   public boolean getRequired() {
/*  559 */     if (getDAO_().getRequired() != null) {
/*  560 */       return getDAO_().getRequired().booleanValue();
/*      */     }
/*      */     
/*  563 */     return false;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setRequired(boolean argRequired) {
/*  572 */     if (setRequired_noev(argRequired) && 
/*  573 */       this._events != null && 
/*  574 */       postEventsForChanges()) {
/*  575 */       this._events.post(ITransactionPropertyPrompt.SET_REQUIRED, Boolean.valueOf(argRequired));
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean setRequired_noev(boolean argRequired) {
/*  582 */     boolean ev_postable = false;
/*      */     
/*  584 */     if ((getDAO_().getRequired() == null && Boolean.valueOf(argRequired) != null) || (
/*  585 */       getDAO_().getRequired() != null && !getDAO_().getRequired().equals(Boolean.valueOf(argRequired)))) {
/*  586 */       getDAO_().setRequired(Boolean.valueOf(argRequired));
/*  587 */       ev_postable = true;
/*      */     } 
/*      */     
/*  590 */     return ev_postable;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public int getSortOrder() {
/*  598 */     if (getDAO_().getSortOrder() != null) {
/*  599 */       return getDAO_().getSortOrder().intValue();
/*      */     }
/*      */     
/*  602 */     return 0;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setSortOrder(int argSortOrder) {
/*  611 */     if (setSortOrder_noev(argSortOrder) && 
/*  612 */       this._events != null && 
/*  613 */       postEventsForChanges()) {
/*  614 */       this._events.post(ITransactionPropertyPrompt.SET_SORTORDER, Integer.valueOf(argSortOrder));
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean setSortOrder_noev(int argSortOrder) {
/*  621 */     boolean ev_postable = false;
/*      */     
/*  623 */     if ((getDAO_().getSortOrder() == null && Integer.valueOf(argSortOrder) != null) || (
/*  624 */       getDAO_().getSortOrder() != null && !getDAO_().getSortOrder().equals(Integer.valueOf(argSortOrder)))) {
/*  625 */       getDAO_().setSortOrder(Integer.valueOf(argSortOrder));
/*  626 */       ev_postable = true;
/*      */     } 
/*      */     
/*  629 */     return ev_postable;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public String getPromptEditPattern() {
/*  637 */     return getDAO_().getPromptEditPattern();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setPromptEditPattern(String argPromptEditPattern) {
/*  645 */     if (setPromptEditPattern_noev(argPromptEditPattern) && 
/*  646 */       this._events != null && 
/*  647 */       postEventsForChanges()) {
/*  648 */       this._events.post(ITransactionPropertyPrompt.SET_PROMPTEDITPATTERN, argPromptEditPattern);
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean setPromptEditPattern_noev(String argPromptEditPattern) {
/*  655 */     boolean ev_postable = false;
/*      */     
/*  657 */     if ((getDAO_().getPromptEditPattern() == null && argPromptEditPattern != null) || (
/*  658 */       getDAO_().getPromptEditPattern() != null && !getDAO_().getPromptEditPattern().equals(argPromptEditPattern))) {
/*  659 */       getDAO_().setPromptEditPattern(argPromptEditPattern);
/*  660 */       ev_postable = true;
/*      */     } 
/*      */     
/*  663 */     return ev_postable;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public String getValidationRuleKey() {
/*  671 */     return getDAO_().getValidationRuleKey();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setValidationRuleKey(String argValidationRuleKey) {
/*  679 */     if (setValidationRuleKey_noev(argValidationRuleKey) && 
/*  680 */       this._events != null && 
/*  681 */       postEventsForChanges()) {
/*  682 */       this._events.post(ITransactionPropertyPrompt.SET_VALIDATIONRULEKEY, argValidationRuleKey);
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean setValidationRuleKey_noev(String argValidationRuleKey) {
/*  689 */     boolean ev_postable = false;
/*      */     
/*  691 */     if ((getDAO_().getValidationRuleKey() == null && argValidationRuleKey != null) || (
/*  692 */       getDAO_().getValidationRuleKey() != null && !getDAO_().getValidationRuleKey().equals(argValidationRuleKey))) {
/*  693 */       getDAO_().setValidationRuleKey(argValidationRuleKey);
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
/*      */   public String getPromptKey() {
/*  705 */     return getDAO_().getPromptKey();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setPromptKey(String argPromptKey) {
/*  713 */     if (setPromptKey_noev(argPromptKey) && 
/*  714 */       this._events != null && 
/*  715 */       postEventsForChanges()) {
/*  716 */       this._events.post(ITransactionPropertyPrompt.SET_PROMPTKEY, argPromptKey);
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean setPromptKey_noev(String argPromptKey) {
/*  723 */     boolean ev_postable = false;
/*      */     
/*  725 */     if ((getDAO_().getPromptKey() == null && argPromptKey != null) || (
/*  726 */       getDAO_().getPromptKey() != null && !getDAO_().getPromptKey().equals(argPromptKey))) {
/*  727 */       getDAO_().setPromptKey(argPromptKey);
/*  728 */       ev_postable = true;
/*      */     } 
/*      */     
/*  731 */     return ev_postable;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public String getChainKey() {
/*  739 */     return getDAO_().getChainKey();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setChainKey(String argChainKey) {
/*  747 */     if (setChainKey_noev(argChainKey) && 
/*  748 */       this._events != null && 
/*  749 */       postEventsForChanges()) {
/*  750 */       this._events.post(ITransactionPropertyPrompt.SET_CHAINKEY, argChainKey);
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean setChainKey_noev(String argChainKey) {
/*  757 */     boolean ev_postable = false;
/*      */     
/*  759 */     if ((getDAO_().getChainKey() == null && argChainKey != null) || (
/*  760 */       getDAO_().getChainKey() != null && !getDAO_().getChainKey().equals(argChainKey))) {
/*  761 */       getDAO_().setChainKey(argChainKey);
/*  762 */       ev_postable = true;
/*      */     } 
/*      */     
/*  765 */     return ev_postable;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public String getTransactionState() {
/*  773 */     return getDAO_().getTransactionState();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setTransactionState(String argTransactionState) {
/*  781 */     if (setTransactionState_noev(argTransactionState) && 
/*  782 */       this._events != null && 
/*  783 */       postEventsForChanges()) {
/*  784 */       this._events.post(ITransactionPropertyPrompt.SET_TRANSACTIONSTATE, argTransactionState);
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean setTransactionState_noev(String argTransactionState) {
/*  791 */     boolean ev_postable = false;
/*      */     
/*  793 */     if ((getDAO_().getTransactionState() == null && argTransactionState != null) || (
/*  794 */       getDAO_().getTransactionState() != null && !getDAO_().getTransactionState().equals(argTransactionState))) {
/*  795 */       getDAO_().setTransactionState(argTransactionState);
/*  796 */       ev_postable = true;
/*      */     } 
/*      */     
/*  799 */     return ev_postable;
/*      */   }
/*      */   
/*      */   protected ITransactionPropertyPromptProperty newProperty(String argPropertyName) {
/*  803 */     TransactionPropertyPromptPropertyId id = new TransactionPropertyPromptPropertyId();
/*      */     
/*  805 */     id.setPromptPropertyCode(getPromptPropertyCode());
/*  806 */     id.setEffectiveDate(getEffectiveDate());
/*  807 */     id.setPropertyCode(argPropertyName);
/*      */     
/*  809 */     ITransactionPropertyPromptProperty prop = (ITransactionPropertyPromptProperty)DataFactory.getInstance().createNewObject((IObjectId)id, ITransactionPropertyPromptProperty.class);
/*  810 */     return prop;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   @Relationship(name = "Properties")
/*      */   public List<ITransactionPropertyPromptProperty> getProperties() {
/*  819 */     if (this._properties == null) {
/*  820 */       this._properties = new HistoricalList(null);
/*      */     }
/*  822 */     return (List<ITransactionPropertyPromptProperty>)this._properties;
/*      */   }
/*      */   
/*      */   public void setProperties(List<ITransactionPropertyPromptProperty> argProperties) {
/*  826 */     if (this._properties == null) {
/*  827 */       this._properties = new HistoricalList(argProperties);
/*      */     } else {
/*  829 */       this._properties.setCurrentList(argProperties);
/*      */     } 
/*      */     
/*  832 */     for (ITransactionPropertyPromptProperty child : this._properties) {
/*  833 */       TransactionPropertyPromptPropertyModel model = (TransactionPropertyPromptPropertyModel)child;
/*  834 */       model.setOrganizationId_noev(getOrganizationId());
/*  835 */       model.setPromptPropertyCode_noev(getPromptPropertyCode());
/*  836 */       model.setEffectiveDate_noev(getEffectiveDate());
/*  837 */       if (child instanceof IDataModelImpl) {
/*  838 */         IDataAccessObject childDao = ((IDataModelImpl)child).getDAO();
/*  839 */         if (StringUtils.isEmpty(childDao.getOriginDataSource()) && 
/*  840 */           !StringUtils.isEmpty(getDAO().getOriginDataSource())) {
/*  841 */           childDao.setOriginDataSource(getDAO().getOriginDataSource());
/*      */         }
/*      */       } 
/*  844 */       if (postEventsForChanges()) {
/*  845 */         this._eventManager.registerEventHandler((IEventAware)this._eventCascade, (IEventSource)child);
/*      */       }
/*      */     } 
/*      */   }
/*      */   
/*      */   public void addTransactionPropertyPromptProperty(ITransactionPropertyPromptProperty argTransactionPropertyPromptProperty) {
/*  851 */     if (this._properties == null) {
/*  852 */       this._properties = new HistoricalList(null);
/*      */     }
/*  854 */     argTransactionPropertyPromptProperty.setOrganizationId(getOrganizationId());
/*  855 */     argTransactionPropertyPromptProperty.setPromptPropertyCode(getPromptPropertyCode());
/*  856 */     argTransactionPropertyPromptProperty.setEffectiveDate(getEffectiveDate());
/*  857 */     if (argTransactionPropertyPromptProperty instanceof IDataModelImpl) {
/*  858 */       IDataAccessObject childDao = ((IDataModelImpl)argTransactionPropertyPromptProperty).getDAO();
/*  859 */       if (StringUtils.isEmpty(childDao.getOriginDataSource()) && 
/*  860 */         !StringUtils.isEmpty(getDAO().getOriginDataSource())) {
/*  861 */         childDao.setOriginDataSource(getDAO().getOriginDataSource());
/*      */       }
/*      */     } 
/*      */ 
/*      */     
/*  866 */     if (postEventsForChanges()) {
/*  867 */       this._eventManager.registerEventHandler((IEventAware)this._eventCascade, (IEventSource)new EventDescriptor(argTransactionPropertyPromptProperty));
/*      */     }
/*      */     
/*  870 */     this._properties.add(argTransactionPropertyPromptProperty);
/*  871 */     if (postEventsForChanges()) {
/*  872 */       this._events.post(ITransactionPropertyPrompt.ADD_PROPERTIES, argTransactionPropertyPromptProperty);
/*      */     }
/*      */   }
/*      */   
/*      */   public void removeTransactionPropertyPromptProperty(ITransactionPropertyPromptProperty argTransactionPropertyPromptProperty) {
/*  877 */     if (this._properties != null) {
/*      */       
/*  879 */       if (postEventsForChanges()) {
/*  880 */         this._eventManager.deregisterEventHandler((IEventAware)this._eventCascade, (IEventSource)new EventDescriptor(argTransactionPropertyPromptProperty));
/*      */       }
/*  882 */       this._properties.remove(argTransactionPropertyPromptProperty);
/*  883 */       if (postEventsForChanges()) {
/*  884 */         this._events.post(ITransactionPropertyPrompt.REMOVE_PROPERTIES, argTransactionPropertyPromptProperty);
/*      */       }
/*      */     } 
/*      */   }
/*      */ 
/*      */   
/*      */   public Object getValue(String argFieldId) {
/*  891 */     if ("Properties".equals(argFieldId)) {
/*  892 */       return getProperties();
/*      */     }
/*  894 */     if ("TransactionPropertyPromptExtension".equals(argFieldId)) {
/*  895 */       return this._myExtension;
/*      */     }
/*      */     
/*  898 */     return super.getValue(argFieldId);
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public void setValue(String argFieldId, Object argValue) {
/*  904 */     if ("Properties".equals(argFieldId)) {
/*  905 */       setProperties(changeToList(argValue, ITransactionPropertyPromptProperty.class));
/*      */     }
/*  907 */     else if ("TransactionPropertyPromptExtension".equals(argFieldId)) {
/*  908 */       this._myExtension = (IDataModel)argValue;
/*      */     } else {
/*      */       
/*  911 */       super.setValue(argFieldId, argValue);
/*      */     } 
/*      */   }
/*      */ 
/*      */   
/*      */   public void setDependencies(IPersistenceDefaults argPD, EventManager argEM) {
/*  917 */     this._persistenceDefaults = argPD;
/*  918 */     this._daoImpl.setPersistenceDefaults(argPD);
/*  919 */     this._eventManager = argEM;
/*  920 */     this._events = (Eventor)new ModelEventor((IDataModel)this, argEM);
/*  921 */     this._eventCascade = (EventHandler)new CascadingHandler(this);
/*  922 */     if (this._properties != null) {
/*  923 */       for (ITransactionPropertyPromptProperty relationship : this._properties) {
/*  924 */         ((IDataModelImpl)relationship).setDependencies(argPD, argEM);
/*      */       }
/*      */     }
/*      */   }
/*      */   
/*      */   public IDataModel getTransactionPropertyPromptExt() {
/*  930 */     return this._myExtension;
/*      */   }
/*      */   
/*      */   public void setTransactionPropertyPromptExt(IDataModel argExt) {
/*  934 */     this._myExtension = argExt;
/*      */   }
/*      */ 
/*      */   
/*      */   public void startTransaction() {
/*  939 */     if (this._alreadyInStart) {
/*      */       return;
/*      */     }
/*      */     
/*  943 */     this._alreadyInStart = true;
/*      */ 
/*      */     
/*  946 */     super.startTransaction();
/*      */     
/*  948 */     this._propertiesSavepoint = this._properties;
/*  949 */     if (this._properties != null) {
/*  950 */       this._propertiesSavepoint = new HistoricalList((List)this._properties);
/*  951 */       Iterator<IDataModel> it = this._properties.iterator();
/*  952 */       while (it.hasNext()) {
/*  953 */         ((IDataModel)it.next()).startTransaction();
/*      */       }
/*      */     } 
/*      */ 
/*      */     
/*  958 */     this._alreadyInStart = false;
/*      */   }
/*      */ 
/*      */   
/*      */   public void rollbackChanges() {
/*  963 */     if (isAlreadyRolledBack()) {
/*      */       return;
/*      */     }
/*  966 */     super.rollbackChanges();
/*      */     
/*  968 */     this._properties = this._propertiesSavepoint;
/*  969 */     this._propertiesSavepoint = null;
/*  970 */     if (this._properties != null) {
/*  971 */       Iterator<IDataModel> it = this._properties.iterator();
/*  972 */       while (it.hasNext()) {
/*  973 */         ((IDataModel)it.next()).rollbackChanges();
/*      */       }
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public void commitTransaction() {
/*  981 */     if (this._alreadyInCommit) {
/*      */       return;
/*      */     }
/*  984 */     this._alreadyInCommit = true;
/*      */ 
/*      */     
/*  987 */     super.commitTransaction();
/*      */     
/*  989 */     this._propertiesSavepoint = this._properties;
/*  990 */     if (this._properties != null) {
/*  991 */       Iterator<IDataModel> it = this._properties.iterator();
/*  992 */       while (it.hasNext()) {
/*  993 */         ((IDataModel)it.next()).commitTransaction();
/*      */       }
/*  995 */       this._properties = new HistoricalList((List)this._properties);
/*      */     } 
/*      */ 
/*      */     
/*  999 */     this._alreadyInCommit = false;
/*      */   }
/*      */ 
/*      */   
/*      */   private void readObject(ObjectInputStream argStream) throws IOException, ClassNotFoundException {
/* 1004 */     argStream.defaultReadObject();
/*      */   }
/*      */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\com\impl\TransactionPropertyPromptModel.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */