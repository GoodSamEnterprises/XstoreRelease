/*      */ package dtv.xst.dao.tax.impl;
/*      */ import dtv.data2.IPersistenceDefaults;
/*      */ import dtv.data2.access.IDataAccessObject;
/*      */ import dtv.data2.access.IDataModel;
/*      */ import dtv.data2.access.IDataProperty;
/*      */ import dtv.data2.access.IObjectId;
/*      */ import dtv.data2.access.ModelEventor;
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
/*      */ import dtv.xst.dao.tax.ITaxRateRule;
/*      */ import dtv.xst.dao.tax.ITaxRateRuleProperty;
/*      */ import dtv.xst.dao.tax.TaxRateRulePropertyId;
/*      */ import java.io.IOException;
/*      */ import java.io.ObjectInputStream;
/*      */ import java.math.BigDecimal;
/*      */ import java.util.Date;
/*      */ import java.util.Iterator;
/*      */ import java.util.List;
/*      */ 
/*      */ public class TaxRateRuleModel extends AbstractDataModelWithPropertyImpl<ITaxRateRuleProperty> implements ITaxRateRule {
/*      */   private static final long serialVersionUID = 133683367L;
/*      */   private ITaxGroupRule _parentRule;
/*      */   private transient boolean _alreadyInStart = false;
/*      */   
/*      */   public String toString() {
/*   35 */     return super.toString() + " Id: " + getObjectId();
/*      */   }
/*      */   private transient boolean _alreadyInCommit = false; private IDataModel _myExtension; private HistoricalList<ITaxRateRuleProperty> _properties; private transient HistoricalList<ITaxRateRuleProperty> _propertiesSavepoint;
/*      */   
/*      */   public void initDAO() {
/*   40 */     setDAO((IDataAccessObject)new TaxRateRuleDAO());
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private TaxRateRuleDAO getDAO_() {
/*   48 */     return (TaxRateRuleDAO)this._daoImpl;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public long getOrganizationId() {
/*   56 */     if (getDAO_().getOrganizationId() != null) {
/*   57 */       return getDAO_().getOrganizationId().longValue();
/*      */     }
/*      */     
/*   60 */     return 0L;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setOrganizationId(long argOrganizationId) {
/*   69 */     if (setOrganizationId_noev(argOrganizationId) && 
/*   70 */       this._events != null && 
/*   71 */       postEventsForChanges()) {
/*   72 */       this._events.post(ITaxRateRule.SET_ORGANIZATIONID, Long.valueOf(argOrganizationId));
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean setOrganizationId_noev(long argOrganizationId) {
/*   79 */     boolean ev_postable = false;
/*      */     
/*   81 */     if ((getDAO_().getOrganizationId() == null && Long.valueOf(argOrganizationId) != null) || (
/*   82 */       getDAO_().getOrganizationId() != null && !getDAO_().getOrganizationId().equals(Long.valueOf(argOrganizationId)))) {
/*   83 */       getDAO_().setOrganizationId(Long.valueOf(argOrganizationId));
/*   84 */       ev_postable = true;
/*   85 */       if (this._properties != null) {
/*      */         
/*   87 */         Iterator<TaxRateRulePropertyModel> it = this._properties.iterator();
/*   88 */         while (it.hasNext())
/*      */         {
/*   90 */           ((TaxRateRulePropertyModel)it.next()).setOrganizationId_noev(argOrganizationId);
/*      */         }
/*      */       } 
/*      */     } 
/*      */     
/*   95 */     return ev_postable;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public String getTaxGroupId() {
/*  103 */     return getDAO_().getTaxGroupId();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setTaxGroupId(String argTaxGroupId) {
/*  111 */     if (setTaxGroupId_noev(argTaxGroupId) && 
/*  112 */       this._events != null && 
/*  113 */       postEventsForChanges()) {
/*  114 */       this._events.post(ITaxRateRule.SET_TAXGROUPID, argTaxGroupId);
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean setTaxGroupId_noev(String argTaxGroupId) {
/*  121 */     boolean ev_postable = false;
/*      */     
/*  123 */     if ((getDAO_().getTaxGroupId() == null && argTaxGroupId != null) || (
/*  124 */       getDAO_().getTaxGroupId() != null && !getDAO_().getTaxGroupId().equals(argTaxGroupId))) {
/*  125 */       getDAO_().setTaxGroupId(argTaxGroupId);
/*  126 */       ev_postable = true;
/*  127 */       if (this._properties != null) {
/*      */         
/*  129 */         Iterator<TaxRateRulePropertyModel> it = this._properties.iterator();
/*  130 */         while (it.hasNext())
/*      */         {
/*  132 */           ((TaxRateRulePropertyModel)it.next()).setTaxGroupId_noev(argTaxGroupId);
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
/*      */   public String getTaxLocationId() {
/*  145 */     return getDAO_().getTaxLocationId();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setTaxLocationId(String argTaxLocationId) {
/*  153 */     if (setTaxLocationId_noev(argTaxLocationId) && 
/*  154 */       this._events != null && 
/*  155 */       postEventsForChanges()) {
/*  156 */       this._events.post(ITaxRateRule.SET_TAXLOCATIONID, argTaxLocationId);
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean setTaxLocationId_noev(String argTaxLocationId) {
/*  163 */     boolean ev_postable = false;
/*      */     
/*  165 */     if ((getDAO_().getTaxLocationId() == null && argTaxLocationId != null) || (
/*  166 */       getDAO_().getTaxLocationId() != null && !getDAO_().getTaxLocationId().equals(argTaxLocationId))) {
/*  167 */       getDAO_().setTaxLocationId(argTaxLocationId);
/*  168 */       ev_postable = true;
/*  169 */       if (this._properties != null) {
/*      */         
/*  171 */         Iterator<TaxRateRulePropertyModel> it = this._properties.iterator();
/*  172 */         while (it.hasNext())
/*      */         {
/*  174 */           ((TaxRateRulePropertyModel)it.next()).setTaxLocationId_noev(argTaxLocationId);
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
/*      */   public int getTaxRateRuleSequence() {
/*  187 */     if (getDAO_().getTaxRateRuleSequence() != null) {
/*  188 */       return getDAO_().getTaxRateRuleSequence().intValue();
/*      */     }
/*      */     
/*  191 */     return 0;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setTaxRateRuleSequence(int argTaxRateRuleSequence) {
/*  200 */     if (setTaxRateRuleSequence_noev(argTaxRateRuleSequence) && 
/*  201 */       this._events != null && 
/*  202 */       postEventsForChanges()) {
/*  203 */       this._events.post(ITaxRateRule.SET_TAXRATERULESEQUENCE, Integer.valueOf(argTaxRateRuleSequence));
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean setTaxRateRuleSequence_noev(int argTaxRateRuleSequence) {
/*  210 */     boolean ev_postable = false;
/*      */     
/*  212 */     if ((getDAO_().getTaxRateRuleSequence() == null && Integer.valueOf(argTaxRateRuleSequence) != null) || (
/*  213 */       getDAO_().getTaxRateRuleSequence() != null && !getDAO_().getTaxRateRuleSequence().equals(Integer.valueOf(argTaxRateRuleSequence)))) {
/*  214 */       getDAO_().setTaxRateRuleSequence(Integer.valueOf(argTaxRateRuleSequence));
/*  215 */       ev_postable = true;
/*  216 */       if (this._properties != null) {
/*      */         
/*  218 */         Iterator<TaxRateRulePropertyModel> it = this._properties.iterator();
/*  219 */         while (it.hasNext())
/*      */         {
/*  221 */           ((TaxRateRulePropertyModel)it.next()).setTaxRateRuleSequence_noev(argTaxRateRuleSequence);
/*      */         }
/*      */       } 
/*      */     } 
/*      */     
/*  226 */     return ev_postable;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public int getTaxRuleSequence() {
/*  234 */     if (getDAO_().getTaxRuleSequence() != null) {
/*  235 */       return getDAO_().getTaxRuleSequence().intValue();
/*      */     }
/*      */     
/*  238 */     return 0;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setTaxRuleSequence(int argTaxRuleSequence) {
/*  247 */     if (setTaxRuleSequence_noev(argTaxRuleSequence) && 
/*  248 */       this._events != null && 
/*  249 */       postEventsForChanges()) {
/*  250 */       this._events.post(ITaxRateRule.SET_TAXRULESEQUENCE, Integer.valueOf(argTaxRuleSequence));
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean setTaxRuleSequence_noev(int argTaxRuleSequence) {
/*  257 */     boolean ev_postable = false;
/*      */     
/*  259 */     if ((getDAO_().getTaxRuleSequence() == null && Integer.valueOf(argTaxRuleSequence) != null) || (
/*  260 */       getDAO_().getTaxRuleSequence() != null && !getDAO_().getTaxRuleSequence().equals(Integer.valueOf(argTaxRuleSequence)))) {
/*  261 */       getDAO_().setTaxRuleSequence(Integer.valueOf(argTaxRuleSequence));
/*  262 */       ev_postable = true;
/*  263 */       if (this._properties != null) {
/*      */         
/*  265 */         Iterator<TaxRateRulePropertyModel> it = this._properties.iterator();
/*  266 */         while (it.hasNext())
/*      */         {
/*  268 */           ((TaxRateRulePropertyModel)it.next()).setTaxRuleSequence_noev(argTaxRuleSequence);
/*      */         }
/*      */       } 
/*      */     } 
/*      */     
/*  273 */     return ev_postable;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public Date getCreateDate() {
/*  281 */     return getDAO_().getCreateDate();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setCreateDate(Date argCreateDate) {
/*  289 */     if (setCreateDate_noev(argCreateDate) && 
/*  290 */       this._events != null && 
/*  291 */       postEventsForChanges()) {
/*  292 */       this._events.post(ITaxRateRule.SET_CREATEDATE, argCreateDate);
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean setCreateDate_noev(Date argCreateDate) {
/*  299 */     boolean ev_postable = false;
/*      */     
/*  301 */     if ((getDAO_().getCreateDate() == null && argCreateDate != null) || (
/*  302 */       getDAO_().getCreateDate() != null && !getDAO_().getCreateDate().equals(argCreateDate))) {
/*  303 */       getDAO_().setCreateDate(argCreateDate);
/*  304 */       ev_postable = true;
/*      */     } 
/*      */     
/*  307 */     return ev_postable;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public String getCreateUserId() {
/*  315 */     return getDAO_().getCreateUserId();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setCreateUserId(String argCreateUserId) {
/*  323 */     if (setCreateUserId_noev(argCreateUserId) && 
/*  324 */       this._events != null && 
/*  325 */       postEventsForChanges()) {
/*  326 */       this._events.post(ITaxRateRule.SET_CREATEUSERID, argCreateUserId);
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean setCreateUserId_noev(String argCreateUserId) {
/*  333 */     boolean ev_postable = false;
/*      */     
/*  335 */     if ((getDAO_().getCreateUserId() == null && argCreateUserId != null) || (
/*  336 */       getDAO_().getCreateUserId() != null && !getDAO_().getCreateUserId().equals(argCreateUserId))) {
/*  337 */       getDAO_().setCreateUserId(argCreateUserId);
/*  338 */       ev_postable = true;
/*      */     } 
/*      */     
/*  341 */     return ev_postable;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public Date getUpdateDate() {
/*  349 */     return getDAO_().getUpdateDate();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setUpdateDate(Date argUpdateDate) {
/*  357 */     if (setUpdateDate_noev(argUpdateDate) && 
/*  358 */       this._events != null && 
/*  359 */       postEventsForChanges()) {
/*  360 */       this._events.post(ITaxRateRule.SET_UPDATEDATE, argUpdateDate);
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean setUpdateDate_noev(Date argUpdateDate) {
/*  367 */     boolean ev_postable = false;
/*      */     
/*  369 */     if ((getDAO_().getUpdateDate() == null && argUpdateDate != null) || (
/*  370 */       getDAO_().getUpdateDate() != null && !getDAO_().getUpdateDate().equals(argUpdateDate))) {
/*  371 */       getDAO_().setUpdateDate(argUpdateDate);
/*  372 */       ev_postable = true;
/*      */     } 
/*      */     
/*  375 */     return ev_postable;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public String getUpdateUserId() {
/*  383 */     return getDAO_().getUpdateUserId();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setUpdateUserId(String argUpdateUserId) {
/*  391 */     if (setUpdateUserId_noev(argUpdateUserId) && 
/*  392 */       this._events != null && 
/*  393 */       postEventsForChanges()) {
/*  394 */       this._events.post(ITaxRateRule.SET_UPDATEUSERID, argUpdateUserId);
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean setUpdateUserId_noev(String argUpdateUserId) {
/*  401 */     boolean ev_postable = false;
/*      */     
/*  403 */     if ((getDAO_().getUpdateUserId() == null && argUpdateUserId != null) || (
/*  404 */       getDAO_().getUpdateUserId() != null && !getDAO_().getUpdateUserId().equals(argUpdateUserId))) {
/*  405 */       getDAO_().setUpdateUserId(argUpdateUserId);
/*  406 */       ev_postable = true;
/*      */     } 
/*      */     
/*  409 */     return ev_postable;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public String getOrgCode() {
/*  417 */     return getDAO_().getOrgCode();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setOrgCode(String argOrgCode) {
/*  425 */     if (setOrgCode_noev(argOrgCode) && 
/*  426 */       this._events != null && 
/*  427 */       postEventsForChanges()) {
/*  428 */       this._events.post(ITaxRateRule.SET_ORGCODE, argOrgCode);
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean setOrgCode_noev(String argOrgCode) {
/*  435 */     boolean ev_postable = false;
/*      */     
/*  437 */     if ((getDAO_().getOrgCode() == null && argOrgCode != null) || (
/*  438 */       getDAO_().getOrgCode() != null && !getDAO_().getOrgCode().equals(argOrgCode))) {
/*  439 */       getDAO_().setOrgCode(argOrgCode);
/*  440 */       ev_postable = true;
/*      */     } 
/*      */     
/*  443 */     return ev_postable;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public String getOrgValue() {
/*  451 */     return getDAO_().getOrgValue();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setOrgValue(String argOrgValue) {
/*  459 */     if (setOrgValue_noev(argOrgValue) && 
/*  460 */       this._events != null && 
/*  461 */       postEventsForChanges()) {
/*  462 */       this._events.post(ITaxRateRule.SET_ORGVALUE, argOrgValue);
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean setOrgValue_noev(String argOrgValue) {
/*  469 */     boolean ev_postable = false;
/*      */     
/*  471 */     if ((getDAO_().getOrgValue() == null && argOrgValue != null) || (
/*  472 */       getDAO_().getOrgValue() != null && !getDAO_().getOrgValue().equals(argOrgValue))) {
/*  473 */       getDAO_().setOrgValue(argOrgValue);
/*  474 */       ev_postable = true;
/*      */     } 
/*      */     
/*  477 */     return ev_postable;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public BigDecimal getAmount() {
/*  485 */     return getDAO_().getAmount();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setAmount(BigDecimal argAmount) {
/*  493 */     if (setAmount_noev(argAmount) && 
/*  494 */       this._events != null && 
/*  495 */       postEventsForChanges()) {
/*  496 */       this._events.post(ITaxRateRule.SET_AMOUNT, argAmount);
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean setAmount_noev(BigDecimal argAmount) {
/*  503 */     boolean ev_postable = false;
/*      */     
/*  505 */     if ((getDAO_().getAmount() == null && argAmount != null) || (
/*  506 */       getDAO_().getAmount() != null && !getDAO_().getAmount().equals(argAmount))) {
/*  507 */       getDAO_().setAmount(argAmount);
/*  508 */       ev_postable = true;
/*      */     } 
/*      */     
/*  511 */     return ev_postable;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public String getBreakPointTypeCode() {
/*  519 */     return getDAO_().getBreakPointTypeCode();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setBreakPointTypeCode(String argBreakPointTypeCode) {
/*  527 */     if (setBreakPointTypeCode_noev(argBreakPointTypeCode) && 
/*  528 */       this._events != null && 
/*  529 */       postEventsForChanges()) {
/*  530 */       this._events.post(ITaxRateRule.SET_BREAKPOINTTYPECODE, argBreakPointTypeCode);
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean setBreakPointTypeCode_noev(String argBreakPointTypeCode) {
/*  537 */     boolean ev_postable = false;
/*      */     
/*  539 */     if ((getDAO_().getBreakPointTypeCode() == null && argBreakPointTypeCode != null) || (
/*  540 */       getDAO_().getBreakPointTypeCode() != null && !getDAO_().getBreakPointTypeCode().equals(argBreakPointTypeCode))) {
/*  541 */       getDAO_().setBreakPointTypeCode(argBreakPointTypeCode);
/*  542 */       ev_postable = true;
/*      */     } 
/*      */     
/*  545 */     return ev_postable;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public Date getDailyEndTimeDao() {
/*  553 */     return getDAO_().getDailyEndTimeDao();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setDailyEndTimeDao(Date argDailyEndTimeDao) {
/*  561 */     if (setDailyEndTimeDao_noev(argDailyEndTimeDao) && 
/*  562 */       this._events != null && 
/*  563 */       postEventsForChanges()) {
/*  564 */       this._events.post(ITaxRateRule.SET_DAILYENDTIMEDAO, argDailyEndTimeDao);
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean setDailyEndTimeDao_noev(Date argDailyEndTimeDao) {
/*  571 */     boolean ev_postable = false;
/*      */     
/*  573 */     if ((getDAO_().getDailyEndTimeDao() == null && argDailyEndTimeDao != null) || (
/*  574 */       getDAO_().getDailyEndTimeDao() != null && !getDAO_().getDailyEndTimeDao().equals(argDailyEndTimeDao))) {
/*  575 */       getDAO_().setDailyEndTimeDao(argDailyEndTimeDao);
/*  576 */       ev_postable = true;
/*      */     } 
/*      */     
/*  579 */     return ev_postable;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public Date getDailyStartTimeDao() {
/*  587 */     return getDAO_().getDailyStartTimeDao();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setDailyStartTimeDao(Date argDailyStartTimeDao) {
/*  595 */     if (setDailyStartTimeDao_noev(argDailyStartTimeDao) && 
/*  596 */       this._events != null && 
/*  597 */       postEventsForChanges()) {
/*  598 */       this._events.post(ITaxRateRule.SET_DAILYSTARTTIMEDAO, argDailyStartTimeDao);
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean setDailyStartTimeDao_noev(Date argDailyStartTimeDao) {
/*  605 */     boolean ev_postable = false;
/*      */     
/*  607 */     if ((getDAO_().getDailyStartTimeDao() == null && argDailyStartTimeDao != null) || (
/*  608 */       getDAO_().getDailyStartTimeDao() != null && !getDAO_().getDailyStartTimeDao().equals(argDailyStartTimeDao))) {
/*  609 */       getDAO_().setDailyStartTimeDao(argDailyStartTimeDao);
/*  610 */       ev_postable = true;
/*      */     } 
/*      */     
/*  613 */     return ev_postable;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public Date getEffectiveDatetimestamp() {
/*  621 */     return getDAO_().getEffectiveDatetimestamp();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setEffectiveDatetimestamp(Date argEffectiveDatetimestamp) {
/*  629 */     if (setEffectiveDatetimestamp_noev(argEffectiveDatetimestamp) && 
/*  630 */       this._events != null && 
/*  631 */       postEventsForChanges()) {
/*  632 */       this._events.post(ITaxRateRule.SET_EFFECTIVEDATETIMESTAMP, argEffectiveDatetimestamp);
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean setEffectiveDatetimestamp_noev(Date argEffectiveDatetimestamp) {
/*  639 */     boolean ev_postable = false;
/*      */     
/*  641 */     if ((getDAO_().getEffectiveDatetimestamp() == null && argEffectiveDatetimestamp != null) || (
/*  642 */       getDAO_().getEffectiveDatetimestamp() != null && !getDAO_().getEffectiveDatetimestamp().equals(argEffectiveDatetimestamp))) {
/*  643 */       getDAO_().setEffectiveDatetimestamp(argEffectiveDatetimestamp);
/*  644 */       ev_postable = true;
/*      */     } 
/*      */     
/*  647 */     return ev_postable;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public Date getExpirationDatetimestamp() {
/*  655 */     return getDAO_().getExpirationDatetimestamp();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setExpirationDatetimestamp(Date argExpirationDatetimestamp) {
/*  663 */     if (setExpirationDatetimestamp_noev(argExpirationDatetimestamp) && 
/*  664 */       this._events != null && 
/*  665 */       postEventsForChanges()) {
/*  666 */       this._events.post(ITaxRateRule.SET_EXPIRATIONDATETIMESTAMP, argExpirationDatetimestamp);
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean setExpirationDatetimestamp_noev(Date argExpirationDatetimestamp) {
/*  673 */     boolean ev_postable = false;
/*      */     
/*  675 */     if ((getDAO_().getExpirationDatetimestamp() == null && argExpirationDatetimestamp != null) || (
/*  676 */       getDAO_().getExpirationDatetimestamp() != null && !getDAO_().getExpirationDatetimestamp().equals(argExpirationDatetimestamp))) {
/*  677 */       getDAO_().setExpirationDatetimestamp(argExpirationDatetimestamp);
/*  678 */       ev_postable = true;
/*      */     } 
/*      */     
/*  681 */     return ev_postable;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public BigDecimal getPercent() {
/*  689 */     return getDAO_().getPercent();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setPercent(BigDecimal argPercent) {
/*  697 */     if (setPercent_noev(argPercent) && 
/*  698 */       this._events != null && 
/*  699 */       postEventsForChanges()) {
/*  700 */       this._events.post(ITaxRateRule.SET_PERCENT, argPercent);
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean setPercent_noev(BigDecimal argPercent) {
/*  707 */     boolean ev_postable = false;
/*      */     
/*  709 */     if ((getDAO_().getPercent() == null && argPercent != null) || (
/*  710 */       getDAO_().getPercent() != null && !getDAO_().getPercent().equals(argPercent))) {
/*  711 */       getDAO_().setPercent(argPercent);
/*  712 */       ev_postable = true;
/*      */     } 
/*      */     
/*  715 */     return ev_postable;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public BigDecimal getTaxRateMaxTaxableAmount() {
/*  723 */     return getDAO_().getTaxRateMaxTaxableAmount();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setTaxRateMaxTaxableAmount(BigDecimal argTaxRateMaxTaxableAmount) {
/*  731 */     if (setTaxRateMaxTaxableAmount_noev(argTaxRateMaxTaxableAmount) && 
/*  732 */       this._events != null && 
/*  733 */       postEventsForChanges()) {
/*  734 */       this._events.post(ITaxRateRule.SET_TAXRATEMAXTAXABLEAMOUNT, argTaxRateMaxTaxableAmount);
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean setTaxRateMaxTaxableAmount_noev(BigDecimal argTaxRateMaxTaxableAmount) {
/*  741 */     boolean ev_postable = false;
/*      */     
/*  743 */     if ((getDAO_().getTaxRateMaxTaxableAmount() == null && argTaxRateMaxTaxableAmount != null) || (
/*  744 */       getDAO_().getTaxRateMaxTaxableAmount() != null && !getDAO_().getTaxRateMaxTaxableAmount().equals(argTaxRateMaxTaxableAmount))) {
/*  745 */       getDAO_().setTaxRateMaxTaxableAmount(argTaxRateMaxTaxableAmount);
/*  746 */       ev_postable = true;
/*      */     } 
/*      */     
/*  749 */     return ev_postable;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public BigDecimal getTaxRateMinTaxableAmount() {
/*  757 */     return getDAO_().getTaxRateMinTaxableAmount();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setTaxRateMinTaxableAmount(BigDecimal argTaxRateMinTaxableAmount) {
/*  765 */     if (setTaxRateMinTaxableAmount_noev(argTaxRateMinTaxableAmount) && 
/*  766 */       this._events != null && 
/*  767 */       postEventsForChanges()) {
/*  768 */       this._events.post(ITaxRateRule.SET_TAXRATEMINTAXABLEAMOUNT, argTaxRateMinTaxableAmount);
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean setTaxRateMinTaxableAmount_noev(BigDecimal argTaxRateMinTaxableAmount) {
/*  775 */     boolean ev_postable = false;
/*      */     
/*  777 */     if ((getDAO_().getTaxRateMinTaxableAmount() == null && argTaxRateMinTaxableAmount != null) || (
/*  778 */       getDAO_().getTaxRateMinTaxableAmount() != null && !getDAO_().getTaxRateMinTaxableAmount().equals(argTaxRateMinTaxableAmount))) {
/*  779 */       getDAO_().setTaxRateMinTaxableAmount(argTaxRateMinTaxableAmount);
/*  780 */       ev_postable = true;
/*      */     } 
/*      */     
/*  783 */     return ev_postable;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public String getTaxBracketId() {
/*  791 */     return getDAO_().getTaxBracketId();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setTaxBracketId(String argTaxBracketId) {
/*  799 */     if (setTaxBracketId_noev(argTaxBracketId) && 
/*  800 */       this._events != null && 
/*  801 */       postEventsForChanges()) {
/*  802 */       this._events.post(ITaxRateRule.SET_TAXBRACKETID, argTaxBracketId);
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean setTaxBracketId_noev(String argTaxBracketId) {
/*  809 */     boolean ev_postable = false;
/*      */     
/*  811 */     if ((getDAO_().getTaxBracketId() == null && argTaxBracketId != null) || (
/*  812 */       getDAO_().getTaxBracketId() != null && !getDAO_().getTaxBracketId().equals(argTaxBracketId))) {
/*  813 */       getDAO_().setTaxBracketId(argTaxBracketId);
/*  814 */       ev_postable = true;
/*      */     } 
/*      */     
/*  817 */     return ev_postable;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public String getExternalSystem() {
/*  825 */     return getDAO_().getExternalSystem();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setExternalSystem(String argExternalSystem) {
/*  833 */     if (setExternalSystem_noev(argExternalSystem) && 
/*  834 */       this._events != null && 
/*  835 */       postEventsForChanges()) {
/*  836 */       this._events.post(ITaxRateRule.SET_EXTERNALSYSTEM, argExternalSystem);
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean setExternalSystem_noev(String argExternalSystem) {
/*  843 */     boolean ev_postable = false;
/*      */     
/*  845 */     if ((getDAO_().getExternalSystem() == null && argExternalSystem != null) || (
/*  846 */       getDAO_().getExternalSystem() != null && !getDAO_().getExternalSystem().equals(argExternalSystem))) {
/*  847 */       getDAO_().setExternalSystem(argExternalSystem);
/*  848 */       ev_postable = true;
/*      */     } 
/*      */     
/*  851 */     return ev_postable;
/*      */   }
/*      */   
/*      */   protected ITaxRateRuleProperty newProperty(String argPropertyName) {
/*  855 */     TaxRateRulePropertyId id = new TaxRateRulePropertyId();
/*      */     
/*  857 */     id.setTaxGroupId(getTaxGroupId());
/*  858 */     id.setTaxLocationId(getTaxLocationId());
/*  859 */     id.setTaxRateRuleSequence(Integer.valueOf(getTaxRateRuleSequence()));
/*  860 */     id.setTaxRuleSequence(Integer.valueOf(getTaxRuleSequence()));
/*  861 */     id.setPropertyCode(argPropertyName);
/*      */     
/*  863 */     ITaxRateRuleProperty prop = (ITaxRateRuleProperty)DataFactory.getInstance().createNewObject((IObjectId)id, ITaxRateRuleProperty.class);
/*  864 */     return prop;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   @Relationship(name = "Properties")
/*      */   public List<ITaxRateRuleProperty> getProperties() {
/*  873 */     if (this._properties == null) {
/*  874 */       this._properties = new HistoricalList(null);
/*      */     }
/*  876 */     return (List<ITaxRateRuleProperty>)this._properties;
/*      */   }
/*      */   
/*      */   public void setProperties(List<ITaxRateRuleProperty> argProperties) {
/*  880 */     if (this._properties == null) {
/*  881 */       this._properties = new HistoricalList(argProperties);
/*      */     } else {
/*  883 */       this._properties.setCurrentList(argProperties);
/*      */     } 
/*      */     
/*  886 */     for (ITaxRateRuleProperty child : this._properties) {
/*  887 */       TaxRateRulePropertyModel model = (TaxRateRulePropertyModel)child;
/*  888 */       model.setOrganizationId_noev(getOrganizationId());
/*  889 */       model.setTaxGroupId_noev(getTaxGroupId());
/*  890 */       model.setTaxLocationId_noev(getTaxLocationId());
/*  891 */       model.setTaxRateRuleSequence_noev(getTaxRateRuleSequence());
/*  892 */       model.setTaxRuleSequence_noev(getTaxRuleSequence());
/*  893 */       if (child instanceof IDataModelImpl) {
/*  894 */         IDataAccessObject childDao = ((IDataModelImpl)child).getDAO();
/*  895 */         if (StringUtils.isEmpty(childDao.getOriginDataSource()) && 
/*  896 */           !StringUtils.isEmpty(getDAO().getOriginDataSource())) {
/*  897 */           childDao.setOriginDataSource(getDAO().getOriginDataSource());
/*      */         }
/*      */       } 
/*  900 */       if (postEventsForChanges()) {
/*  901 */         this._eventManager.registerEventHandler((IEventAware)this._eventCascade, (IEventSource)child);
/*      */       }
/*      */     } 
/*      */   }
/*      */   
/*      */   public void addTaxRateRuleProperty(ITaxRateRuleProperty argTaxRateRuleProperty) {
/*  907 */     if (this._properties == null) {
/*  908 */       this._properties = new HistoricalList(null);
/*      */     }
/*  910 */     argTaxRateRuleProperty.setOrganizationId(getOrganizationId());
/*  911 */     argTaxRateRuleProperty.setTaxGroupId(getTaxGroupId());
/*  912 */     argTaxRateRuleProperty.setTaxLocationId(getTaxLocationId());
/*  913 */     argTaxRateRuleProperty.setTaxRateRuleSequence(getTaxRateRuleSequence());
/*  914 */     argTaxRateRuleProperty.setTaxRuleSequence(getTaxRuleSequence());
/*  915 */     if (argTaxRateRuleProperty instanceof IDataModelImpl) {
/*  916 */       IDataAccessObject childDao = ((IDataModelImpl)argTaxRateRuleProperty).getDAO();
/*  917 */       if (StringUtils.isEmpty(childDao.getOriginDataSource()) && 
/*  918 */         !StringUtils.isEmpty(getDAO().getOriginDataSource())) {
/*  919 */         childDao.setOriginDataSource(getDAO().getOriginDataSource());
/*      */       }
/*      */     } 
/*      */ 
/*      */     
/*  924 */     if (postEventsForChanges()) {
/*  925 */       this._eventManager.registerEventHandler((IEventAware)this._eventCascade, (IEventSource)new EventDescriptor(argTaxRateRuleProperty));
/*      */     }
/*      */     
/*  928 */     this._properties.add(argTaxRateRuleProperty);
/*  929 */     if (postEventsForChanges()) {
/*  930 */       this._events.post(ITaxRateRule.ADD_PROPERTIES, argTaxRateRuleProperty);
/*      */     }
/*      */   }
/*      */   
/*      */   public void removeTaxRateRuleProperty(ITaxRateRuleProperty argTaxRateRuleProperty) {
/*  935 */     if (this._properties != null) {
/*      */       
/*  937 */       if (postEventsForChanges()) {
/*  938 */         this._eventManager.deregisterEventHandler((IEventAware)this._eventCascade, (IEventSource)new EventDescriptor(argTaxRateRuleProperty));
/*      */       }
/*  940 */       this._properties.remove(argTaxRateRuleProperty);
/*  941 */       if (postEventsForChanges()) {
/*  942 */         this._events.post(ITaxRateRule.REMOVE_PROPERTIES, argTaxRateRuleProperty);
/*      */       }
/*      */     } 
/*      */   }
/*      */   
/*      */   public void setParentRule(ITaxGroupRule argParentRule) {
/*  948 */     this._parentRule = argParentRule;
/*      */   }
/*      */   
/*      */   public ITaxGroupRule getParentRule() {
/*  952 */     return this._parentRule;
/*      */   }
/*      */ 
/*      */   
/*      */   public Object getValue(String argFieldId) {
/*  957 */     if ("Properties".equals(argFieldId)) {
/*  958 */       return getProperties();
/*      */     }
/*  960 */     if ("TaxRateRuleExtension".equals(argFieldId)) {
/*  961 */       return this._myExtension;
/*      */     }
/*      */     
/*  964 */     return super.getValue(argFieldId);
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public void setValue(String argFieldId, Object argValue) {
/*  970 */     if ("Properties".equals(argFieldId)) {
/*  971 */       setProperties(changeToList(argValue, ITaxRateRuleProperty.class));
/*      */     }
/*  973 */     else if ("TaxRateRuleExtension".equals(argFieldId)) {
/*  974 */       this._myExtension = (IDataModel)argValue;
/*      */     } else {
/*      */       
/*  977 */       super.setValue(argFieldId, argValue);
/*      */     } 
/*      */   }
/*      */ 
/*      */   
/*      */   public void setDependencies(IPersistenceDefaults argPD, EventManager argEM) {
/*  983 */     this._persistenceDefaults = argPD;
/*  984 */     this._daoImpl.setPersistenceDefaults(argPD);
/*  985 */     this._eventManager = argEM;
/*  986 */     this._events = (Eventor)new ModelEventor((IDataModel)this, argEM);
/*  987 */     this._eventCascade = (EventHandler)new CascadingHandler(this);
/*  988 */     if (this._properties != null) {
/*  989 */       for (ITaxRateRuleProperty relationship : this._properties) {
/*  990 */         ((IDataModelImpl)relationship).setDependencies(argPD, argEM);
/*      */       }
/*      */     }
/*      */   }
/*      */   
/*      */   public IDataModel getTaxRateRuleExt() {
/*  996 */     return this._myExtension;
/*      */   }
/*      */   
/*      */   public void setTaxRateRuleExt(IDataModel argExt) {
/* 1000 */     this._myExtension = argExt;
/*      */   }
/*      */ 
/*      */   
/*      */   public void startTransaction() {
/* 1005 */     if (this._alreadyInStart) {
/*      */       return;
/*      */     }
/*      */     
/* 1009 */     this._alreadyInStart = true;
/*      */ 
/*      */     
/* 1012 */     super.startTransaction();
/*      */     
/* 1014 */     this._propertiesSavepoint = this._properties;
/* 1015 */     if (this._properties != null) {
/* 1016 */       this._propertiesSavepoint = new HistoricalList((List)this._properties);
/* 1017 */       Iterator<IDataModel> it = this._properties.iterator();
/* 1018 */       while (it.hasNext()) {
/* 1019 */         ((IDataModel)it.next()).startTransaction();
/*      */       }
/*      */     } 
/*      */ 
/*      */     
/* 1024 */     this._alreadyInStart = false;
/*      */   }
/*      */ 
/*      */   
/*      */   public void rollbackChanges() {
/* 1029 */     if (isAlreadyRolledBack()) {
/*      */       return;
/*      */     }
/* 1032 */     super.rollbackChanges();
/*      */     
/* 1034 */     this._properties = this._propertiesSavepoint;
/* 1035 */     this._propertiesSavepoint = null;
/* 1036 */     if (this._properties != null) {
/* 1037 */       Iterator<IDataModel> it = this._properties.iterator();
/* 1038 */       while (it.hasNext()) {
/* 1039 */         ((IDataModel)it.next()).rollbackChanges();
/*      */       }
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public void commitTransaction() {
/* 1047 */     if (this._alreadyInCommit) {
/*      */       return;
/*      */     }
/* 1050 */     this._alreadyInCommit = true;
/*      */ 
/*      */     
/* 1053 */     super.commitTransaction();
/*      */     
/* 1055 */     this._propertiesSavepoint = this._properties;
/* 1056 */     if (this._properties != null) {
/* 1057 */       Iterator<IDataModel> it = this._properties.iterator();
/* 1058 */       while (it.hasNext()) {
/* 1059 */         ((IDataModel)it.next()).commitTransaction();
/*      */       }
/* 1061 */       this._properties = new HistoricalList((List)this._properties);
/*      */     } 
/*      */ 
/*      */     
/* 1065 */     this._alreadyInCommit = false;
/*      */   }
/*      */ 
/*      */   
/*      */   private void readObject(ObjectInputStream argStream) throws IOException, ClassNotFoundException {
/* 1070 */     argStream.defaultReadObject();
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
/* 1083 */     return TaxRateRuleHelper.doesTaxRuleApply(this, argTaxableAmt);
/*      */   }
/*      */   
/*      */   public boolean doesTaxRuleApply(Date argTransactionDateTime) {
/* 1087 */     return TaxRateRuleHelper.doesTaxRuleApply(this, argTransactionDateTime);
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
/* 1098 */     Date dailyEndTime = getDailyEndTimeDao();
/*      */     
/* 1100 */     if (!this.dailyEndTimeOk) {
/* 1101 */       if (dailyEndTime != null) {
/* 1102 */         dailyEndTime = DateUtils.clearDate(dailyEndTime);
/*      */       }
/* 1104 */       this.dailyEndTimeOk = true;
/*      */     } 
/* 1106 */     return dailyEndTime;
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
/* 1119 */     if (dailyEndTime != null) {
/* 1120 */       dailyEndTime = DateUtils.clearDate(dailyEndTime);
/* 1121 */       this.dailyEndTimeOk = true;
/*      */     } 
/* 1123 */     setDailyEndTimeDao(dailyEndTime);
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
/* 1134 */     Date dailyStartTime = getDailyStartTimeDao();
/* 1135 */     if (!this.dailyStartTimeOk) {
/* 1136 */       if (dailyStartTime != null) {
/* 1137 */         dailyStartTime = DateUtils.clearDate(dailyStartTime);
/*      */       }
/* 1139 */       this.dailyStartTimeOk = true;
/*      */     } 
/* 1141 */     return dailyStartTime;
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
/* 1153 */     if (dailyStartTime != null) {
/* 1154 */       dailyStartTime = DateUtils.clearDate(dailyStartTime);
/* 1155 */       this.dailyStartTimeOk = true;
/*      */     } 
/* 1157 */     setDailyStartTimeDao(dailyStartTime);
/*      */   }
/*      */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\tax\impl\TaxRateRuleModel.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */