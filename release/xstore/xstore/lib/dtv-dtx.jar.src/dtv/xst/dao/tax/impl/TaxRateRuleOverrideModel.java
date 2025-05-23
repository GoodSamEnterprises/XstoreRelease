/*      */ package dtv.xst.dao.tax.impl;
/*      */ import dtv.data2.IPersistenceDefaults;
/*      */ import dtv.data2.access.IDataAccessObject;
/*      */ import dtv.data2.access.IDataModel;
/*      */ import dtv.data2.access.IDataProperty;
/*      */ import dtv.data2.access.IObjectId;
/*      */ import dtv.data2.access.ModelEventor;
/*      */ import dtv.data2.access.exception.DtxException;
/*      */ import dtv.data2.access.impl.IDataModelImpl;
/*      */ import dtv.event.EventDescriptor;
/*      */ import dtv.event.EventManager;
/*      */ import dtv.event.Eventor;
/*      */ import dtv.event.IEventAware;
/*      */ import dtv.event.IEventSource;
/*      */ import dtv.event.handler.CascadingHandler;
/*      */ import dtv.util.DateUtils;
/*      */ import dtv.util.HistoricalList;
/*      */ import dtv.util.StringUtils;
/*      */ import dtv.xst.dao.tax.ITaxGroupRule;
/*      */ import dtv.xst.dao.tax.ITaxRateRuleOverride;
/*      */ import dtv.xst.dao.tax.ITaxRateRuleOverrideProperty;
/*      */ import dtv.xst.dao.tax.TaxRateRuleOverridePropertyId;
/*      */ import java.io.ObjectInputStream;
/*      */ import java.math.BigDecimal;
/*      */ import java.util.Date;
/*      */ import java.util.Iterator;
/*      */ import java.util.List;
/*      */ 
/*      */ public class TaxRateRuleOverrideModel extends AbstractDataModelWithPropertyImpl<ITaxRateRuleOverrideProperty> implements ITaxRateRuleOverride {
/*      */   private static final long serialVersionUID = -1162493549L;
/*      */   private ITaxGroupRule _parentRule;
/*      */   private transient boolean _alreadyInStart = false;
/*      */   
/*      */   public String toString() {
/*   35 */     return super.toString() + " Id: " + getObjectId();
/*      */   }
/*      */   private transient boolean _alreadyInCommit = false; private IDataModel _myExtension; private HistoricalList<ITaxRateRuleOverrideProperty> _properties; private transient HistoricalList<ITaxRateRuleOverrideProperty> _propertiesSavepoint;
/*      */   
/*      */   public void initDAO() {
/*   40 */     setDAO((IDataAccessObject)new TaxRateRuleOverrideDAO());
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private TaxRateRuleOverrideDAO getDAO_() {
/*   48 */     return (TaxRateRuleOverrideDAO)this._daoImpl;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public Date getExpirationDatetimestamp() {
/*   56 */     return getDAO_().getExpirationDatetimestamp();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setExpirationDatetimestamp(Date argExpirationDatetimestamp) {
/*   64 */     if (setExpirationDatetimestamp_noev(argExpirationDatetimestamp) && 
/*   65 */       this._events != null && 
/*   66 */       postEventsForChanges()) {
/*   67 */       this._events.post(ITaxRateRuleOverride.SET_EXPIRATIONDATETIMESTAMP, argExpirationDatetimestamp);
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean setExpirationDatetimestamp_noev(Date argExpirationDatetimestamp) {
/*   74 */     boolean ev_postable = false;
/*      */     
/*   76 */     if ((getDAO_().getExpirationDatetimestamp() == null && argExpirationDatetimestamp != null) || (
/*   77 */       getDAO_().getExpirationDatetimestamp() != null && !getDAO_().getExpirationDatetimestamp().equals(argExpirationDatetimestamp))) {
/*   78 */       getDAO_().setExpirationDatetimestamp(argExpirationDatetimestamp);
/*   79 */       ev_postable = true;
/*   80 */       if (this._properties != null) {
/*      */         
/*   82 */         Iterator<TaxRateRuleOverridePropertyModel> it = this._properties.iterator();
/*   83 */         while (it.hasNext())
/*      */         {
/*   85 */           ((TaxRateRuleOverridePropertyModel)it.next()).setExpirationDatetimestamp_noev(argExpirationDatetimestamp);
/*      */         }
/*      */       } 
/*      */     } 
/*      */     
/*   90 */     return ev_postable;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public long getOrganizationId() {
/*   98 */     if (getDAO_().getOrganizationId() != null) {
/*   99 */       return getDAO_().getOrganizationId().longValue();
/*      */     }
/*      */     
/*  102 */     return 0L;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setOrganizationId(long argOrganizationId) {
/*  111 */     if (setOrganizationId_noev(argOrganizationId) && 
/*  112 */       this._events != null && 
/*  113 */       postEventsForChanges()) {
/*  114 */       this._events.post(ITaxRateRuleOverride.SET_ORGANIZATIONID, Long.valueOf(argOrganizationId));
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean setOrganizationId_noev(long argOrganizationId) {
/*  121 */     boolean ev_postable = false;
/*      */     
/*  123 */     if ((getDAO_().getOrganizationId() == null && Long.valueOf(argOrganizationId) != null) || (
/*  124 */       getDAO_().getOrganizationId() != null && !getDAO_().getOrganizationId().equals(Long.valueOf(argOrganizationId)))) {
/*  125 */       getDAO_().setOrganizationId(Long.valueOf(argOrganizationId));
/*  126 */       ev_postable = true;
/*  127 */       if (this._properties != null) {
/*      */         
/*  129 */         Iterator<TaxRateRuleOverridePropertyModel> it = this._properties.iterator();
/*  130 */         while (it.hasNext())
/*      */         {
/*  132 */           ((TaxRateRuleOverridePropertyModel)it.next()).setOrganizationId_noev(argOrganizationId);
/*      */         }
/*      */       } 
/*      */     } 
/*      */     
/*  137 */     return ev_postable;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public String getTaxGroupId() {
/*  145 */     return getDAO_().getTaxGroupId();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setTaxGroupId(String argTaxGroupId) {
/*  153 */     if (setTaxGroupId_noev(argTaxGroupId) && 
/*  154 */       this._events != null && 
/*  155 */       postEventsForChanges()) {
/*  156 */       this._events.post(ITaxRateRuleOverride.SET_TAXGROUPID, argTaxGroupId);
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean setTaxGroupId_noev(String argTaxGroupId) {
/*  163 */     boolean ev_postable = false;
/*      */     
/*  165 */     if ((getDAO_().getTaxGroupId() == null && argTaxGroupId != null) || (
/*  166 */       getDAO_().getTaxGroupId() != null && !getDAO_().getTaxGroupId().equals(argTaxGroupId))) {
/*  167 */       getDAO_().setTaxGroupId(argTaxGroupId);
/*  168 */       ev_postable = true;
/*  169 */       if (this._properties != null) {
/*      */         
/*  171 */         Iterator<TaxRateRuleOverridePropertyModel> it = this._properties.iterator();
/*  172 */         while (it.hasNext())
/*      */         {
/*  174 */           ((TaxRateRuleOverridePropertyModel)it.next()).setTaxGroupId_noev(argTaxGroupId);
/*      */         }
/*      */       } 
/*      */     } 
/*      */     
/*  179 */     return ev_postable;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public String getTaxLocationId() {
/*  187 */     return getDAO_().getTaxLocationId();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setTaxLocationId(String argTaxLocationId) {
/*  195 */     if (setTaxLocationId_noev(argTaxLocationId) && 
/*  196 */       this._events != null && 
/*  197 */       postEventsForChanges()) {
/*  198 */       this._events.post(ITaxRateRuleOverride.SET_TAXLOCATIONID, argTaxLocationId);
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean setTaxLocationId_noev(String argTaxLocationId) {
/*  205 */     boolean ev_postable = false;
/*      */     
/*  207 */     if ((getDAO_().getTaxLocationId() == null && argTaxLocationId != null) || (
/*  208 */       getDAO_().getTaxLocationId() != null && !getDAO_().getTaxLocationId().equals(argTaxLocationId))) {
/*  209 */       getDAO_().setTaxLocationId(argTaxLocationId);
/*  210 */       ev_postable = true;
/*  211 */       if (this._properties != null) {
/*      */         
/*  213 */         Iterator<TaxRateRuleOverridePropertyModel> it = this._properties.iterator();
/*  214 */         while (it.hasNext())
/*      */         {
/*  216 */           ((TaxRateRuleOverridePropertyModel)it.next()).setTaxLocationId_noev(argTaxLocationId);
/*      */         }
/*      */       } 
/*      */     } 
/*      */     
/*  221 */     return ev_postable;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public int getTaxRateRuleSequence() {
/*  229 */     if (getDAO_().getTaxRateRuleSequence() != null) {
/*  230 */       return getDAO_().getTaxRateRuleSequence().intValue();
/*      */     }
/*      */     
/*  233 */     return 0;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setTaxRateRuleSequence(int argTaxRateRuleSequence) {
/*  242 */     if (setTaxRateRuleSequence_noev(argTaxRateRuleSequence) && 
/*  243 */       this._events != null && 
/*  244 */       postEventsForChanges()) {
/*  245 */       this._events.post(ITaxRateRuleOverride.SET_TAXRATERULESEQUENCE, Integer.valueOf(argTaxRateRuleSequence));
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean setTaxRateRuleSequence_noev(int argTaxRateRuleSequence) {
/*  252 */     boolean ev_postable = false;
/*      */     
/*  254 */     if ((getDAO_().getTaxRateRuleSequence() == null && Integer.valueOf(argTaxRateRuleSequence) != null) || (
/*  255 */       getDAO_().getTaxRateRuleSequence() != null && !getDAO_().getTaxRateRuleSequence().equals(Integer.valueOf(argTaxRateRuleSequence)))) {
/*  256 */       getDAO_().setTaxRateRuleSequence(Integer.valueOf(argTaxRateRuleSequence));
/*  257 */       ev_postable = true;
/*  258 */       if (this._properties != null) {
/*      */         
/*  260 */         Iterator<TaxRateRuleOverridePropertyModel> it = this._properties.iterator();
/*  261 */         while (it.hasNext())
/*      */         {
/*  263 */           ((TaxRateRuleOverridePropertyModel)it.next()).setTaxRateRuleSequence_noev(argTaxRateRuleSequence);
/*      */         }
/*      */       } 
/*      */     } 
/*      */     
/*  268 */     return ev_postable;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public int getTaxRuleSequence() {
/*  276 */     if (getDAO_().getTaxRuleSequence() != null) {
/*  277 */       return getDAO_().getTaxRuleSequence().intValue();
/*      */     }
/*      */     
/*  280 */     return 0;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setTaxRuleSequence(int argTaxRuleSequence) {
/*  289 */     if (setTaxRuleSequence_noev(argTaxRuleSequence) && 
/*  290 */       this._events != null && 
/*  291 */       postEventsForChanges()) {
/*  292 */       this._events.post(ITaxRateRuleOverride.SET_TAXRULESEQUENCE, Integer.valueOf(argTaxRuleSequence));
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean setTaxRuleSequence_noev(int argTaxRuleSequence) {
/*  299 */     boolean ev_postable = false;
/*      */     
/*  301 */     if ((getDAO_().getTaxRuleSequence() == null && Integer.valueOf(argTaxRuleSequence) != null) || (
/*  302 */       getDAO_().getTaxRuleSequence() != null && !getDAO_().getTaxRuleSequence().equals(Integer.valueOf(argTaxRuleSequence)))) {
/*  303 */       getDAO_().setTaxRuleSequence(Integer.valueOf(argTaxRuleSequence));
/*  304 */       ev_postable = true;
/*  305 */       if (this._properties != null) {
/*      */         
/*  307 */         Iterator<TaxRateRuleOverridePropertyModel> it = this._properties.iterator();
/*  308 */         while (it.hasNext())
/*      */         {
/*  310 */           ((TaxRateRuleOverridePropertyModel)it.next()).setTaxRuleSequence_noev(argTaxRuleSequence);
/*      */         }
/*      */       } 
/*      */     } 
/*      */     
/*  315 */     return ev_postable;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public Date getCreateDate() {
/*  323 */     return getDAO_().getCreateDate();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setCreateDate(Date argCreateDate) {
/*  331 */     if (setCreateDate_noev(argCreateDate) && 
/*  332 */       this._events != null && 
/*  333 */       postEventsForChanges()) {
/*  334 */       this._events.post(ITaxRateRuleOverride.SET_CREATEDATE, argCreateDate);
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean setCreateDate_noev(Date argCreateDate) {
/*  341 */     boolean ev_postable = false;
/*      */     
/*  343 */     if ((getDAO_().getCreateDate() == null && argCreateDate != null) || (
/*  344 */       getDAO_().getCreateDate() != null && !getDAO_().getCreateDate().equals(argCreateDate))) {
/*  345 */       getDAO_().setCreateDate(argCreateDate);
/*  346 */       ev_postable = true;
/*      */     } 
/*      */     
/*  349 */     return ev_postable;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public String getCreateUserId() {
/*  357 */     return getDAO_().getCreateUserId();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setCreateUserId(String argCreateUserId) {
/*  365 */     if (setCreateUserId_noev(argCreateUserId) && 
/*  366 */       this._events != null && 
/*  367 */       postEventsForChanges()) {
/*  368 */       this._events.post(ITaxRateRuleOverride.SET_CREATEUSERID, argCreateUserId);
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean setCreateUserId_noev(String argCreateUserId) {
/*  375 */     boolean ev_postable = false;
/*      */     
/*  377 */     if ((getDAO_().getCreateUserId() == null && argCreateUserId != null) || (
/*  378 */       getDAO_().getCreateUserId() != null && !getDAO_().getCreateUserId().equals(argCreateUserId))) {
/*  379 */       getDAO_().setCreateUserId(argCreateUserId);
/*  380 */       ev_postable = true;
/*      */     } 
/*      */     
/*  383 */     return ev_postable;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public Date getUpdateDate() {
/*  391 */     return getDAO_().getUpdateDate();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setUpdateDate(Date argUpdateDate) {
/*  399 */     if (setUpdateDate_noev(argUpdateDate) && 
/*  400 */       this._events != null && 
/*  401 */       postEventsForChanges()) {
/*  402 */       this._events.post(ITaxRateRuleOverride.SET_UPDATEDATE, argUpdateDate);
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean setUpdateDate_noev(Date argUpdateDate) {
/*  409 */     boolean ev_postable = false;
/*      */     
/*  411 */     if ((getDAO_().getUpdateDate() == null && argUpdateDate != null) || (
/*  412 */       getDAO_().getUpdateDate() != null && !getDAO_().getUpdateDate().equals(argUpdateDate))) {
/*  413 */       getDAO_().setUpdateDate(argUpdateDate);
/*  414 */       ev_postable = true;
/*      */     } 
/*      */     
/*  417 */     return ev_postable;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public String getUpdateUserId() {
/*  425 */     return getDAO_().getUpdateUserId();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setUpdateUserId(String argUpdateUserId) {
/*  433 */     if (setUpdateUserId_noev(argUpdateUserId) && 
/*  434 */       this._events != null && 
/*  435 */       postEventsForChanges()) {
/*  436 */       this._events.post(ITaxRateRuleOverride.SET_UPDATEUSERID, argUpdateUserId);
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean setUpdateUserId_noev(String argUpdateUserId) {
/*  443 */     boolean ev_postable = false;
/*      */     
/*  445 */     if ((getDAO_().getUpdateUserId() == null && argUpdateUserId != null) || (
/*  446 */       getDAO_().getUpdateUserId() != null && !getDAO_().getUpdateUserId().equals(argUpdateUserId))) {
/*  447 */       getDAO_().setUpdateUserId(argUpdateUserId);
/*  448 */       ev_postable = true;
/*      */     } 
/*      */     
/*  451 */     return ev_postable;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public String getOrgCode() {
/*  459 */     return getDAO_().getOrgCode();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setOrgCode(String argOrgCode) {
/*  467 */     if (setOrgCode_noev(argOrgCode) && 
/*  468 */       this._events != null && 
/*  469 */       postEventsForChanges()) {
/*  470 */       this._events.post(ITaxRateRuleOverride.SET_ORGCODE, argOrgCode);
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean setOrgCode_noev(String argOrgCode) {
/*  477 */     boolean ev_postable = false;
/*      */     
/*  479 */     if ((getDAO_().getOrgCode() == null && argOrgCode != null) || (
/*  480 */       getDAO_().getOrgCode() != null && !getDAO_().getOrgCode().equals(argOrgCode))) {
/*  481 */       getDAO_().setOrgCode(argOrgCode);
/*  482 */       ev_postable = true;
/*      */     } 
/*      */     
/*  485 */     return ev_postable;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public String getOrgValue() {
/*  493 */     return getDAO_().getOrgValue();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setOrgValue(String argOrgValue) {
/*  501 */     if (setOrgValue_noev(argOrgValue) && 
/*  502 */       this._events != null && 
/*  503 */       postEventsForChanges()) {
/*  504 */       this._events.post(ITaxRateRuleOverride.SET_ORGVALUE, argOrgValue);
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean setOrgValue_noev(String argOrgValue) {
/*  511 */     boolean ev_postable = false;
/*      */     
/*  513 */     if ((getDAO_().getOrgValue() == null && argOrgValue != null) || (
/*  514 */       getDAO_().getOrgValue() != null && !getDAO_().getOrgValue().equals(argOrgValue))) {
/*  515 */       getDAO_().setOrgValue(argOrgValue);
/*  516 */       ev_postable = true;
/*      */     } 
/*      */     
/*  519 */     return ev_postable;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public BigDecimal getAmount() {
/*  527 */     return getDAO_().getAmount();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setAmount(BigDecimal argAmount) {
/*  535 */     if (setAmount_noev(argAmount) && 
/*  536 */       this._events != null && 
/*  537 */       postEventsForChanges()) {
/*  538 */       this._events.post(ITaxRateRuleOverride.SET_AMOUNT, argAmount);
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean setAmount_noev(BigDecimal argAmount) {
/*  545 */     boolean ev_postable = false;
/*      */     
/*  547 */     if ((getDAO_().getAmount() == null && argAmount != null) || (
/*  548 */       getDAO_().getAmount() != null && !getDAO_().getAmount().equals(argAmount))) {
/*  549 */       getDAO_().setAmount(argAmount);
/*  550 */       ev_postable = true;
/*      */     } 
/*      */     
/*  553 */     return ev_postable;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public String getBreakPointTypeCode() {
/*  561 */     return getDAO_().getBreakPointTypeCode();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setBreakPointTypeCode(String argBreakPointTypeCode) {
/*  569 */     if (setBreakPointTypeCode_noev(argBreakPointTypeCode) && 
/*  570 */       this._events != null && 
/*  571 */       postEventsForChanges()) {
/*  572 */       this._events.post(ITaxRateRuleOverride.SET_BREAKPOINTTYPECODE, argBreakPointTypeCode);
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean setBreakPointTypeCode_noev(String argBreakPointTypeCode) {
/*  579 */     boolean ev_postable = false;
/*      */     
/*  581 */     if ((getDAO_().getBreakPointTypeCode() == null && argBreakPointTypeCode != null) || (
/*  582 */       getDAO_().getBreakPointTypeCode() != null && !getDAO_().getBreakPointTypeCode().equals(argBreakPointTypeCode))) {
/*  583 */       getDAO_().setBreakPointTypeCode(argBreakPointTypeCode);
/*  584 */       ev_postable = true;
/*      */     } 
/*      */     
/*  587 */     return ev_postable;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public Date getDailyEndTimeDao() {
/*  595 */     return getDAO_().getDailyEndTimeDao();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setDailyEndTimeDao(Date argDailyEndTimeDao) {
/*  603 */     if (setDailyEndTimeDao_noev(argDailyEndTimeDao) && 
/*  604 */       this._events != null && 
/*  605 */       postEventsForChanges()) {
/*  606 */       this._events.post(ITaxRateRuleOverride.SET_DAILYENDTIMEDAO, argDailyEndTimeDao);
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean setDailyEndTimeDao_noev(Date argDailyEndTimeDao) {
/*  613 */     boolean ev_postable = false;
/*      */     
/*  615 */     if ((getDAO_().getDailyEndTimeDao() == null && argDailyEndTimeDao != null) || (
/*  616 */       getDAO_().getDailyEndTimeDao() != null && !getDAO_().getDailyEndTimeDao().equals(argDailyEndTimeDao))) {
/*  617 */       getDAO_().setDailyEndTimeDao(argDailyEndTimeDao);
/*  618 */       ev_postable = true;
/*      */     } 
/*      */     
/*  621 */     return ev_postable;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public Date getDailyStartTimeDao() {
/*  629 */     return getDAO_().getDailyStartTimeDao();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setDailyStartTimeDao(Date argDailyStartTimeDao) {
/*  637 */     if (setDailyStartTimeDao_noev(argDailyStartTimeDao) && 
/*  638 */       this._events != null && 
/*  639 */       postEventsForChanges()) {
/*  640 */       this._events.post(ITaxRateRuleOverride.SET_DAILYSTARTTIMEDAO, argDailyStartTimeDao);
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean setDailyStartTimeDao_noev(Date argDailyStartTimeDao) {
/*  647 */     boolean ev_postable = false;
/*      */     
/*  649 */     if ((getDAO_().getDailyStartTimeDao() == null && argDailyStartTimeDao != null) || (
/*  650 */       getDAO_().getDailyStartTimeDao() != null && !getDAO_().getDailyStartTimeDao().equals(argDailyStartTimeDao))) {
/*  651 */       getDAO_().setDailyStartTimeDao(argDailyStartTimeDao);
/*  652 */       ev_postable = true;
/*      */     } 
/*      */     
/*  655 */     return ev_postable;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public Date getEffectiveDatetimestamp() {
/*  663 */     return getDAO_().getEffectiveDatetimestamp();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setEffectiveDatetimestamp(Date argEffectiveDatetimestamp) {
/*  671 */     if (setEffectiveDatetimestamp_noev(argEffectiveDatetimestamp) && 
/*  672 */       this._events != null && 
/*  673 */       postEventsForChanges()) {
/*  674 */       this._events.post(ITaxRateRuleOverride.SET_EFFECTIVEDATETIMESTAMP, argEffectiveDatetimestamp);
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean setEffectiveDatetimestamp_noev(Date argEffectiveDatetimestamp) {
/*  681 */     boolean ev_postable = false;
/*      */     
/*  683 */     if ((getDAO_().getEffectiveDatetimestamp() == null && argEffectiveDatetimestamp != null) || (
/*  684 */       getDAO_().getEffectiveDatetimestamp() != null && !getDAO_().getEffectiveDatetimestamp().equals(argEffectiveDatetimestamp))) {
/*  685 */       getDAO_().setEffectiveDatetimestamp(argEffectiveDatetimestamp);
/*  686 */       ev_postable = true;
/*      */     } 
/*      */     
/*  689 */     return ev_postable;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public BigDecimal getPercent() {
/*  697 */     return getDAO_().getPercent();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setPercent(BigDecimal argPercent) {
/*  705 */     if (setPercent_noev(argPercent) && 
/*  706 */       this._events != null && 
/*  707 */       postEventsForChanges()) {
/*  708 */       this._events.post(ITaxRateRuleOverride.SET_PERCENT, argPercent);
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean setPercent_noev(BigDecimal argPercent) {
/*  715 */     boolean ev_postable = false;
/*      */     
/*  717 */     if ((getDAO_().getPercent() == null && argPercent != null) || (
/*  718 */       getDAO_().getPercent() != null && !getDAO_().getPercent().equals(argPercent))) {
/*  719 */       getDAO_().setPercent(argPercent);
/*  720 */       ev_postable = true;
/*      */     } 
/*      */     
/*  723 */     return ev_postable;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public BigDecimal getTaxRateMaxTaxableAmount() {
/*  731 */     return getDAO_().getTaxRateMaxTaxableAmount();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setTaxRateMaxTaxableAmount(BigDecimal argTaxRateMaxTaxableAmount) {
/*  739 */     if (setTaxRateMaxTaxableAmount_noev(argTaxRateMaxTaxableAmount) && 
/*  740 */       this._events != null && 
/*  741 */       postEventsForChanges()) {
/*  742 */       this._events.post(ITaxRateRuleOverride.SET_TAXRATEMAXTAXABLEAMOUNT, argTaxRateMaxTaxableAmount);
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean setTaxRateMaxTaxableAmount_noev(BigDecimal argTaxRateMaxTaxableAmount) {
/*  749 */     boolean ev_postable = false;
/*      */     
/*  751 */     if ((getDAO_().getTaxRateMaxTaxableAmount() == null && argTaxRateMaxTaxableAmount != null) || (
/*  752 */       getDAO_().getTaxRateMaxTaxableAmount() != null && !getDAO_().getTaxRateMaxTaxableAmount().equals(argTaxRateMaxTaxableAmount))) {
/*  753 */       getDAO_().setTaxRateMaxTaxableAmount(argTaxRateMaxTaxableAmount);
/*  754 */       ev_postable = true;
/*      */     } 
/*      */     
/*  757 */     return ev_postable;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public BigDecimal getTaxRateMinTaxableAmount() {
/*  765 */     return getDAO_().getTaxRateMinTaxableAmount();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setTaxRateMinTaxableAmount(BigDecimal argTaxRateMinTaxableAmount) {
/*  773 */     if (setTaxRateMinTaxableAmount_noev(argTaxRateMinTaxableAmount) && 
/*  774 */       this._events != null && 
/*  775 */       postEventsForChanges()) {
/*  776 */       this._events.post(ITaxRateRuleOverride.SET_TAXRATEMINTAXABLEAMOUNT, argTaxRateMinTaxableAmount);
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean setTaxRateMinTaxableAmount_noev(BigDecimal argTaxRateMinTaxableAmount) {
/*  783 */     boolean ev_postable = false;
/*      */     
/*  785 */     if ((getDAO_().getTaxRateMinTaxableAmount() == null && argTaxRateMinTaxableAmount != null) || (
/*  786 */       getDAO_().getTaxRateMinTaxableAmount() != null && !getDAO_().getTaxRateMinTaxableAmount().equals(argTaxRateMinTaxableAmount))) {
/*  787 */       getDAO_().setTaxRateMinTaxableAmount(argTaxRateMinTaxableAmount);
/*  788 */       ev_postable = true;
/*      */     } 
/*      */     
/*  791 */     return ev_postable;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public String getTaxBracketId() {
/*  799 */     return getDAO_().getTaxBracketId();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setTaxBracketId(String argTaxBracketId) {
/*  807 */     if (setTaxBracketId_noev(argTaxBracketId) && 
/*  808 */       this._events != null && 
/*  809 */       postEventsForChanges()) {
/*  810 */       this._events.post(ITaxRateRuleOverride.SET_TAXBRACKETID, argTaxBracketId);
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean setTaxBracketId_noev(String argTaxBracketId) {
/*  817 */     boolean ev_postable = false;
/*      */     
/*  819 */     if ((getDAO_().getTaxBracketId() == null && argTaxBracketId != null) || (
/*  820 */       getDAO_().getTaxBracketId() != null && !getDAO_().getTaxBracketId().equals(argTaxBracketId))) {
/*  821 */       getDAO_().setTaxBracketId(argTaxBracketId);
/*  822 */       ev_postable = true;
/*      */     } 
/*      */     
/*  825 */     return ev_postable;
/*      */   }
/*      */   
/*      */   protected ITaxRateRuleOverrideProperty newProperty(String argPropertyName) {
/*  829 */     TaxRateRuleOverridePropertyId id = new TaxRateRuleOverridePropertyId();
/*      */     
/*  831 */     id.setExpirationDatetimestamp(getExpirationDatetimestamp());
/*  832 */     id.setTaxGroupId(getTaxGroupId());
/*  833 */     id.setTaxLocationId(getTaxLocationId());
/*  834 */     id.setTaxRateRuleSequence(Integer.valueOf(getTaxRateRuleSequence()));
/*  835 */     id.setTaxRuleSequence(Integer.valueOf(getTaxRuleSequence()));
/*  836 */     id.setPropertyCode(argPropertyName);
/*      */     
/*  838 */     ITaxRateRuleOverrideProperty prop = (ITaxRateRuleOverrideProperty)DataFactory.getInstance().createNewObject((IObjectId)id, ITaxRateRuleOverrideProperty.class);
/*  839 */     return prop;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   @Relationship(name = "Properties")
/*      */   public List<ITaxRateRuleOverrideProperty> getProperties() {
/*  848 */     if (this._properties == null) {
/*  849 */       this._properties = new HistoricalList(null);
/*      */     }
/*  851 */     return (List<ITaxRateRuleOverrideProperty>)this._properties;
/*      */   }
/*      */   
/*      */   public void setProperties(List<ITaxRateRuleOverrideProperty> argProperties) {
/*  855 */     if (this._properties == null) {
/*  856 */       this._properties = new HistoricalList(argProperties);
/*      */     } else {
/*  858 */       this._properties.setCurrentList(argProperties);
/*      */     } 
/*      */     
/*  861 */     for (ITaxRateRuleOverrideProperty child : this._properties) {
/*  862 */       TaxRateRuleOverridePropertyModel model = (TaxRateRuleOverridePropertyModel)child;
/*  863 */       model.setExpirationDatetimestamp_noev(getExpirationDatetimestamp());
/*  864 */       model.setOrganizationId_noev(getOrganizationId());
/*  865 */       model.setTaxGroupId_noev(getTaxGroupId());
/*  866 */       model.setTaxLocationId_noev(getTaxLocationId());
/*  867 */       model.setTaxRateRuleSequence_noev(getTaxRateRuleSequence());
/*  868 */       model.setTaxRuleSequence_noev(getTaxRuleSequence());
/*  869 */       if (child instanceof IDataModelImpl) {
/*  870 */         IDataAccessObject childDao = ((IDataModelImpl)child).getDAO();
/*  871 */         if (StringUtils.isEmpty(childDao.getOriginDataSource()) && 
/*  872 */           !StringUtils.isEmpty(getDAO().getOriginDataSource())) {
/*  873 */           childDao.setOriginDataSource(getDAO().getOriginDataSource());
/*      */         }
/*      */       } 
/*  876 */       if (postEventsForChanges()) {
/*  877 */         this._eventManager.registerEventHandler((IEventAware)this._eventCascade, (IEventSource)child);
/*      */       }
/*      */     } 
/*      */   }
/*      */   
/*      */   public void addTaxRateRuleOverrideProperty(ITaxRateRuleOverrideProperty argTaxRateRuleOverrideProperty) {
/*  883 */     if (this._properties == null) {
/*  884 */       this._properties = new HistoricalList(null);
/*      */     }
/*  886 */     argTaxRateRuleOverrideProperty.setExpirationDatetimestamp(getExpirationDatetimestamp());
/*  887 */     argTaxRateRuleOverrideProperty.setOrganizationId(getOrganizationId());
/*  888 */     argTaxRateRuleOverrideProperty.setTaxGroupId(getTaxGroupId());
/*  889 */     argTaxRateRuleOverrideProperty.setTaxLocationId(getTaxLocationId());
/*  890 */     argTaxRateRuleOverrideProperty.setTaxRateRuleSequence(getTaxRateRuleSequence());
/*  891 */     argTaxRateRuleOverrideProperty.setTaxRuleSequence(getTaxRuleSequence());
/*  892 */     if (argTaxRateRuleOverrideProperty instanceof IDataModelImpl) {
/*  893 */       IDataAccessObject childDao = ((IDataModelImpl)argTaxRateRuleOverrideProperty).getDAO();
/*  894 */       if (StringUtils.isEmpty(childDao.getOriginDataSource()) && 
/*  895 */         !StringUtils.isEmpty(getDAO().getOriginDataSource())) {
/*  896 */         childDao.setOriginDataSource(getDAO().getOriginDataSource());
/*      */       }
/*      */     } 
/*      */ 
/*      */     
/*  901 */     if (postEventsForChanges()) {
/*  902 */       this._eventManager.registerEventHandler((IEventAware)this._eventCascade, (IEventSource)new EventDescriptor(argTaxRateRuleOverrideProperty));
/*      */     }
/*      */     
/*  905 */     this._properties.add(argTaxRateRuleOverrideProperty);
/*  906 */     if (postEventsForChanges()) {
/*  907 */       this._events.post(ITaxRateRuleOverride.ADD_PROPERTIES, argTaxRateRuleOverrideProperty);
/*      */     }
/*      */   }
/*      */   
/*      */   public void removeTaxRateRuleOverrideProperty(ITaxRateRuleOverrideProperty argTaxRateRuleOverrideProperty) {
/*  912 */     if (this._properties != null) {
/*      */       
/*  914 */       if (postEventsForChanges()) {
/*  915 */         this._eventManager.deregisterEventHandler((IEventAware)this._eventCascade, (IEventSource)new EventDescriptor(argTaxRateRuleOverrideProperty));
/*      */       }
/*  917 */       this._properties.remove(argTaxRateRuleOverrideProperty);
/*  918 */       if (postEventsForChanges()) {
/*  919 */         this._events.post(ITaxRateRuleOverride.REMOVE_PROPERTIES, argTaxRateRuleOverrideProperty);
/*      */       }
/*      */     } 
/*      */   }
/*      */   
/*      */   public void setParentRule(ITaxGroupRule argParentRule) {
/*  925 */     this._parentRule = argParentRule;
/*      */   }
/*      */   
/*      */   public ITaxGroupRule getParentRule() {
/*  929 */     return this._parentRule;
/*      */   }
/*      */ 
/*      */   
/*      */   public Object getValue(String argFieldId) {
/*  934 */     if ("Properties".equals(argFieldId)) {
/*  935 */       return getProperties();
/*      */     }
/*  937 */     if ("TaxRateRuleOverrideExtension".equals(argFieldId)) {
/*  938 */       return this._myExtension;
/*      */     }
/*      */     
/*  941 */     return super.getValue(argFieldId);
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public void setValue(String argFieldId, Object argValue) {
/*  947 */     if ("Properties".equals(argFieldId)) {
/*  948 */       setProperties(changeToList(argValue, ITaxRateRuleOverrideProperty.class));
/*      */     }
/*  950 */     else if ("TaxRateRuleOverrideExtension".equals(argFieldId)) {
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
/*  965 */     if (this._properties != null) {
/*  966 */       for (ITaxRateRuleOverrideProperty relationship : this._properties) {
/*  967 */         ((IDataModelImpl)relationship).setDependencies(argPD, argEM);
/*      */       }
/*      */     }
/*      */   }
/*      */   
/*      */   public IDataModel getTaxRateRuleOverrideExt() {
/*  973 */     return this._myExtension;
/*      */   }
/*      */   
/*      */   public void setTaxRateRuleOverrideExt(IDataModel argExt) {
/*  977 */     this._myExtension = argExt;
/*      */   }
/*      */ 
/*      */   
/*      */   public void startTransaction() {
/*  982 */     if (this._alreadyInStart) {
/*      */       return;
/*      */     }
/*      */     
/*  986 */     this._alreadyInStart = true;
/*      */ 
/*      */     
/*  989 */     super.startTransaction();
/*      */     
/*  991 */     this._propertiesSavepoint = this._properties;
/*  992 */     if (this._properties != null) {
/*  993 */       this._propertiesSavepoint = new HistoricalList((List)this._properties);
/*  994 */       Iterator<IDataModel> it = this._properties.iterator();
/*  995 */       while (it.hasNext()) {
/*  996 */         ((IDataModel)it.next()).startTransaction();
/*      */       }
/*      */     } 
/*      */ 
/*      */     
/* 1001 */     this._alreadyInStart = false;
/*      */   }
/*      */ 
/*      */   
/*      */   public void rollbackChanges() {
/* 1006 */     if (isAlreadyRolledBack()) {
/*      */       return;
/*      */     }
/* 1009 */     super.rollbackChanges();
/*      */     
/* 1011 */     this._properties = this._propertiesSavepoint;
/* 1012 */     this._propertiesSavepoint = null;
/* 1013 */     if (this._properties != null) {
/* 1014 */       Iterator<IDataModel> it = this._properties.iterator();
/* 1015 */       while (it.hasNext()) {
/* 1016 */         ((IDataModel)it.next()).rollbackChanges();
/*      */       }
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public void commitTransaction() {
/* 1024 */     if (this._alreadyInCommit) {
/*      */       return;
/*      */     }
/* 1027 */     this._alreadyInCommit = true;
/*      */ 
/*      */     
/* 1030 */     super.commitTransaction();
/*      */     
/* 1032 */     this._propertiesSavepoint = this._properties;
/* 1033 */     if (this._properties != null) {
/* 1034 */       Iterator<IDataModel> it = this._properties.iterator();
/* 1035 */       while (it.hasNext()) {
/* 1036 */         ((IDataModel)it.next()).commitTransaction();
/*      */       }
/* 1038 */       this._properties = new HistoricalList((List)this._properties);
/*      */     } 
/*      */ 
/*      */     
/* 1042 */     this._alreadyInCommit = false;
/*      */   }
/*      */ 
/*      */   
/*      */   private void readObject(ObjectInputStream argStream) throws IOException, ClassNotFoundException {
/* 1047 */     argStream.defaultReadObject();
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
/*      */   public boolean doesTaxRuleApply(BigDecimal argTaxableAmt) {
/* 1060 */     return TaxRateRuleHelper.doesTaxRuleApply(this, argTaxableAmt);
/*      */   }
/*      */   
/*      */   public boolean doesTaxRuleApply(Date argTransactionDateTime) {
/* 1064 */     return TaxRateRuleHelper.doesTaxRuleApply(this, argTransactionDateTime);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public Date getDailyEndTime() {
/* 1075 */     Date dailyEndTime = getDailyEndTimeDao();
/*      */     
/* 1077 */     if (!this.dailyEndTimeOk) {
/* 1078 */       if (dailyEndTime != null) {
/* 1079 */         dailyEndTime = DateUtils.clearDate(dailyEndTime);
/*      */       }
/* 1081 */       this.dailyEndTimeOk = true;
/*      */     } 
/* 1083 */     return dailyEndTime;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private transient boolean dailyEndTimeOk = false;
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setDailyEndTime(Date dailyEndTime) {
/* 1096 */     if (dailyEndTime != null) {
/* 1097 */       dailyEndTime = DateUtils.clearDate(dailyEndTime);
/* 1098 */       this.dailyEndTimeOk = true;
/*      */     } 
/* 1100 */     setDailyEndTimeDao(dailyEndTime);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public Date getDailyStartTime() {
/* 1111 */     Date dailyStartTime = getDailyStartTimeDao();
/*      */     
/* 1113 */     if (!this.dailyStartTimeOk) {
/* 1114 */       if (dailyStartTime != null) {
/* 1115 */         dailyStartTime = DateUtils.clearDate(dailyStartTime);
/*      */       }
/* 1117 */       this.dailyStartTimeOk = true;
/*      */     } 
/* 1119 */     return dailyStartTime;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private transient boolean dailyStartTimeOk = false;
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setDailyStartTime(Date dailyStartTime) {
/* 1131 */     if (dailyStartTime != null) {
/* 1132 */       dailyStartTime = DateUtils.clearDate(dailyStartTime);
/* 1133 */       this.dailyStartTimeOk = true;
/*      */     } 
/* 1135 */     setDailyStartTimeDao(dailyStartTime);
/*      */   }
/*      */   
/*      */   public IDataModel getTaxRateRuleExt() {
/* 1139 */     throw new DtxException("Not implemented, currently.");
/*      */   }
/*      */   
/*      */   public void setTaxRateRuleExt(IDataModel argExt) {
/* 1143 */     throw new DtxException("Not implemented, currently.");
/*      */   }
/*      */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\tax\impl\TaxRateRuleOverrideModel.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */