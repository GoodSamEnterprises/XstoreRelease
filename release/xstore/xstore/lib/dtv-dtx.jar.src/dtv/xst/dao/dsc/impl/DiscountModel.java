/*      */ package dtv.xst.dao.dsc.impl;
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
/*      */ import dtv.xst.dao.dsc.DiscountPropertyId;
/*      */ import dtv.xst.dao.dsc.IDiscount;
/*      */ import dtv.xst.dao.dsc.IDiscountCompatability;
/*      */ import dtv.xst.dao.dsc.IDiscountGroupMapping;
/*      */ import dtv.xst.dao.dsc.IDiscountProperty;
/*      */ import dtv.xst.dao.dsc.IDiscountTypeEligibility;
/*      */ import dtv.xst.dao.sec.IPrivilege;
/*      */ import java.math.BigDecimal;
/*      */ import java.util.Date;
/*      */ import java.util.Iterator;
/*      */ import java.util.List;
/*      */ 
/*      */ public class DiscountModel extends DiscountBaseModel implements IDiscount {
/*      */   private static final long serialVersionUID = 337828193L;
/*      */   private transient boolean _alreadyInStart = false;
/*      */   private transient boolean _alreadyInCommit = false;
/*      */   private IDataModel _myExtension;
/*      */   private HistoricalList<IDiscountCompatability> _compatibleDiscounts;
/*      */   private transient HistoricalList<IDiscountCompatability> _compatibleDiscountsSavepoint;
/*      */   private HistoricalList<IDiscountTypeEligibility> _validSaleLineItemTypeCodes;
/*      */   
/*      */   public String toString() {
/*   35 */     return super.toString() + " Id: " + getObjectId();
/*      */   }
/*      */   private transient HistoricalList<IDiscountTypeEligibility> _validSaleLineItemTypeCodesSavepoint; private HistoricalList<IDiscountGroupMapping> _customerGroups; private transient HistoricalList<IDiscountGroupMapping> _customerGroupsSavepoint; private IPrivilege _privilege; private transient IPrivilege _privilegeSavepoint; private HistoricalList<IDiscountProperty> _properties; private transient HistoricalList<IDiscountProperty> _propertiesSavepoint;
/*      */   
/*      */   public void initDAO() {
/*   40 */     setDAO((IDataAccessObject)new DiscountDAO());
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private DiscountDAO getDAO_() {
/*   48 */     return (DiscountDAO)this._daoImpl;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public String getDiscountCode() {
/*   56 */     return getDAO_().getDiscountCode();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setDiscountCode(String argDiscountCode) {
/*   64 */     if (setDiscountCode_noev(argDiscountCode) && 
/*   65 */       this._events != null && 
/*   66 */       postEventsForChanges()) {
/*   67 */       this._events.post(IDiscount.SET_DISCOUNTCODE, argDiscountCode);
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean setDiscountCode_noev(String argDiscountCode) {
/*   74 */     boolean ev_postable = false;
/*      */     
/*   76 */     if ((getDAO_().getDiscountCode() == null && argDiscountCode != null) || (
/*   77 */       getDAO_().getDiscountCode() != null && !getDAO_().getDiscountCode().equals(argDiscountCode))) {
/*   78 */       getDAO_().setDiscountCode(argDiscountCode);
/*   79 */       ev_postable = true;
/*   80 */       if (this._compatibleDiscounts != null) {
/*      */         
/*   82 */         Iterator<DiscountCompatabilityModel> it = this._compatibleDiscounts.iterator();
/*   83 */         while (it.hasNext())
/*      */         {
/*   85 */           ((DiscountCompatabilityModel)it.next()).setPrimaryDiscountCode_noev(argDiscountCode);
/*      */         }
/*      */       } 
/*   88 */       if (this._validSaleLineItemTypeCodes != null) {
/*      */         
/*   90 */         Iterator<DiscountTypeEligibilityModel> it = this._validSaleLineItemTypeCodes.iterator();
/*   91 */         while (it.hasNext())
/*      */         {
/*   93 */           ((DiscountTypeEligibilityModel)it.next()).setDiscountCode_noev(argDiscountCode);
/*      */         }
/*      */       } 
/*   96 */       if (this._customerGroups != null) {
/*      */         
/*   98 */         Iterator<DiscountGroupMappingModel> it = this._customerGroups.iterator();
/*   99 */         while (it.hasNext())
/*      */         {
/*  101 */           ((DiscountGroupMappingModel)it.next()).setDiscountCode_noev(argDiscountCode);
/*      */         }
/*      */       } 
/*  104 */       if (this._properties != null) {
/*      */         
/*  106 */         Iterator<DiscountPropertyModel> it = this._properties.iterator();
/*  107 */         while (it.hasNext())
/*      */         {
/*  109 */           ((DiscountPropertyModel)it.next()).setDiscountCode_noev(argDiscountCode);
/*      */         }
/*      */       } 
/*      */     } 
/*      */     
/*  114 */     return ev_postable;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public long getOrganizationId() {
/*  122 */     if (getDAO_().getOrganizationId() != null) {
/*  123 */       return getDAO_().getOrganizationId().longValue();
/*      */     }
/*      */     
/*  126 */     return 0L;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setOrganizationId(long argOrganizationId) {
/*  135 */     if (setOrganizationId_noev(argOrganizationId) && 
/*  136 */       this._events != null && 
/*  137 */       postEventsForChanges()) {
/*  138 */       this._events.post(IDiscount.SET_ORGANIZATIONID, Long.valueOf(argOrganizationId));
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean setOrganizationId_noev(long argOrganizationId) {
/*  145 */     boolean ev_postable = false;
/*      */     
/*  147 */     if ((getDAO_().getOrganizationId() == null && Long.valueOf(argOrganizationId) != null) || (
/*  148 */       getDAO_().getOrganizationId() != null && !getDAO_().getOrganizationId().equals(Long.valueOf(argOrganizationId)))) {
/*  149 */       getDAO_().setOrganizationId(Long.valueOf(argOrganizationId));
/*  150 */       ev_postable = true;
/*  151 */       if (this._compatibleDiscounts != null) {
/*      */         
/*  153 */         Iterator<DiscountCompatabilityModel> it = this._compatibleDiscounts.iterator();
/*  154 */         while (it.hasNext())
/*      */         {
/*  156 */           ((DiscountCompatabilityModel)it.next()).setOrganizationId_noev(argOrganizationId);
/*      */         }
/*      */       } 
/*  159 */       if (this._validSaleLineItemTypeCodes != null) {
/*      */         
/*  161 */         Iterator<DiscountTypeEligibilityModel> it = this._validSaleLineItemTypeCodes.iterator();
/*  162 */         while (it.hasNext())
/*      */         {
/*  164 */           ((DiscountTypeEligibilityModel)it.next()).setOrganizationId_noev(argOrganizationId);
/*      */         }
/*      */       } 
/*  167 */       if (this._customerGroups != null) {
/*      */         
/*  169 */         Iterator<DiscountGroupMappingModel> it = this._customerGroups.iterator();
/*  170 */         while (it.hasNext())
/*      */         {
/*  172 */           ((DiscountGroupMappingModel)it.next()).setOrganizationId_noev(argOrganizationId);
/*      */         }
/*      */       } 
/*  175 */       if (this._properties != null) {
/*      */         
/*  177 */         Iterator<DiscountPropertyModel> it = this._properties.iterator();
/*  178 */         while (it.hasNext())
/*      */         {
/*  180 */           ((DiscountPropertyModel)it.next()).setOrganizationId_noev(argOrganizationId);
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
/*      */   public String getClassName() {
/*  193 */     return getDAO_().getClassName();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setClassName(String argClassName) {
/*  201 */     if (setClassName_noev(argClassName) && 
/*  202 */       this._events != null && 
/*  203 */       postEventsForChanges()) {
/*  204 */       this._events.post(IDiscount.SET_CLASSNAME, argClassName);
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean setClassName_noev(String argClassName) {
/*  211 */     boolean ev_postable = false;
/*      */     
/*  213 */     if ((getDAO_().getClassName() == null && argClassName != null) || (
/*  214 */       getDAO_().getClassName() != null && !getDAO_().getClassName().equals(argClassName))) {
/*  215 */       getDAO_().setClassName(argClassName);
/*  216 */       ev_postable = true;
/*      */     } 
/*      */     
/*  219 */     return ev_postable;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public Date getCreateDate() {
/*  227 */     return getDAO_().getCreateDate();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setCreateDate(Date argCreateDate) {
/*  235 */     if (setCreateDate_noev(argCreateDate) && 
/*  236 */       this._events != null && 
/*  237 */       postEventsForChanges()) {
/*  238 */       this._events.post(IDiscount.SET_CREATEDATE, argCreateDate);
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean setCreateDate_noev(Date argCreateDate) {
/*  245 */     boolean ev_postable = false;
/*      */     
/*  247 */     if ((getDAO_().getCreateDate() == null && argCreateDate != null) || (
/*  248 */       getDAO_().getCreateDate() != null && !getDAO_().getCreateDate().equals(argCreateDate))) {
/*  249 */       getDAO_().setCreateDate(argCreateDate);
/*  250 */       ev_postable = true;
/*      */     } 
/*      */     
/*  253 */     return ev_postable;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public String getCreateUserId() {
/*  261 */     return getDAO_().getCreateUserId();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setCreateUserId(String argCreateUserId) {
/*  269 */     if (setCreateUserId_noev(argCreateUserId) && 
/*  270 */       this._events != null && 
/*  271 */       postEventsForChanges()) {
/*  272 */       this._events.post(IDiscount.SET_CREATEUSERID, argCreateUserId);
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean setCreateUserId_noev(String argCreateUserId) {
/*  279 */     boolean ev_postable = false;
/*      */     
/*  281 */     if ((getDAO_().getCreateUserId() == null && argCreateUserId != null) || (
/*  282 */       getDAO_().getCreateUserId() != null && !getDAO_().getCreateUserId().equals(argCreateUserId))) {
/*  283 */       getDAO_().setCreateUserId(argCreateUserId);
/*  284 */       ev_postable = true;
/*      */     } 
/*      */     
/*  287 */     return ev_postable;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public Date getUpdateDate() {
/*  295 */     return getDAO_().getUpdateDate();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setUpdateDate(Date argUpdateDate) {
/*  303 */     if (setUpdateDate_noev(argUpdateDate) && 
/*  304 */       this._events != null && 
/*  305 */       postEventsForChanges()) {
/*  306 */       this._events.post(IDiscount.SET_UPDATEDATE, argUpdateDate);
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean setUpdateDate_noev(Date argUpdateDate) {
/*  313 */     boolean ev_postable = false;
/*      */     
/*  315 */     if ((getDAO_().getUpdateDate() == null && argUpdateDate != null) || (
/*  316 */       getDAO_().getUpdateDate() != null && !getDAO_().getUpdateDate().equals(argUpdateDate))) {
/*  317 */       getDAO_().setUpdateDate(argUpdateDate);
/*  318 */       ev_postable = true;
/*      */     } 
/*      */     
/*  321 */     return ev_postable;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public String getUpdateUserId() {
/*  329 */     return getDAO_().getUpdateUserId();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setUpdateUserId(String argUpdateUserId) {
/*  337 */     if (setUpdateUserId_noev(argUpdateUserId) && 
/*  338 */       this._events != null && 
/*  339 */       postEventsForChanges()) {
/*  340 */       this._events.post(IDiscount.SET_UPDATEUSERID, argUpdateUserId);
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean setUpdateUserId_noev(String argUpdateUserId) {
/*  347 */     boolean ev_postable = false;
/*      */     
/*  349 */     if ((getDAO_().getUpdateUserId() == null && argUpdateUserId != null) || (
/*  350 */       getDAO_().getUpdateUserId() != null && !getDAO_().getUpdateUserId().equals(argUpdateUserId))) {
/*  351 */       getDAO_().setUpdateUserId(argUpdateUserId);
/*  352 */       ev_postable = true;
/*      */     } 
/*      */     
/*  355 */     return ev_postable;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public String getConfigElement() {
/*  363 */     return getDAO_().getConfigElement();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setConfigElement(String argConfigElement) {
/*  371 */     if (setConfigElement_noev(argConfigElement) && 
/*  372 */       this._events != null && 
/*  373 */       postEventsForChanges()) {
/*  374 */       this._events.post(IDiscount.SET_CONFIGELEMENT, argConfigElement);
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean setConfigElement_noev(String argConfigElement) {
/*  381 */     boolean ev_postable = false;
/*      */     
/*  383 */     if ((getDAO_().getConfigElement() == null && argConfigElement != null) || (
/*  384 */       getDAO_().getConfigElement() != null && !getDAO_().getConfigElement().equals(argConfigElement))) {
/*  385 */       getDAO_().setConfigElement(argConfigElement);
/*  386 */       ev_postable = true;
/*      */     } 
/*      */     
/*  389 */     return ev_postable;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public BigDecimal getAmount() {
/*  397 */     return getDAO_().getAmount();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setAmount(BigDecimal argAmount) {
/*  405 */     if (setAmount_noev(argAmount) && 
/*  406 */       this._events != null && 
/*  407 */       postEventsForChanges()) {
/*  408 */       this._events.post(IDiscount.SET_AMOUNT, argAmount);
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean setAmount_noev(BigDecimal argAmount) {
/*  415 */     boolean ev_postable = false;
/*      */     
/*  417 */     if ((getDAO_().getAmount() == null && argAmount != null) || (
/*  418 */       getDAO_().getAmount() != null && !getDAO_().getAmount().equals(argAmount))) {
/*  419 */       getDAO_().setAmount(argAmount);
/*  420 */       ev_postable = true;
/*      */     } 
/*      */     
/*  423 */     return ev_postable;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public String getApplicationMethodCode() {
/*  431 */     return getDAO_().getApplicationMethodCode();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setApplicationMethodCode(String argApplicationMethodCode) {
/*  439 */     if (setApplicationMethodCode_noev(argApplicationMethodCode) && 
/*  440 */       this._events != null && 
/*  441 */       postEventsForChanges()) {
/*  442 */       this._events.post(IDiscount.SET_APPLICATIONMETHODCODE, argApplicationMethodCode);
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean setApplicationMethodCode_noev(String argApplicationMethodCode) {
/*  449 */     boolean ev_postable = false;
/*      */     
/*  451 */     if ((getDAO_().getApplicationMethodCode() == null && argApplicationMethodCode != null) || (
/*  452 */       getDAO_().getApplicationMethodCode() != null && !getDAO_().getApplicationMethodCode().equals(argApplicationMethodCode))) {
/*  453 */       getDAO_().setApplicationMethodCode(argApplicationMethodCode);
/*  454 */       ev_postable = true;
/*      */     } 
/*      */     
/*  457 */     return ev_postable;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public String getCalculationMethodCode() {
/*  465 */     return getDAO_().getCalculationMethodCode();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setCalculationMethodCode(String argCalculationMethodCode) {
/*  473 */     if (setCalculationMethodCode_noev(argCalculationMethodCode) && 
/*  474 */       this._events != null && 
/*  475 */       postEventsForChanges()) {
/*  476 */       this._events.post(IDiscount.SET_CALCULATIONMETHODCODE, argCalculationMethodCode);
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean setCalculationMethodCode_noev(String argCalculationMethodCode) {
/*  483 */     boolean ev_postable = false;
/*      */     
/*  485 */     if ((getDAO_().getCalculationMethodCode() == null && argCalculationMethodCode != null) || (
/*  486 */       getDAO_().getCalculationMethodCode() != null && !getDAO_().getCalculationMethodCode().equals(argCalculationMethodCode))) {
/*  487 */       getDAO_().setCalculationMethodCode(argCalculationMethodCode);
/*  488 */       ev_postable = true;
/*      */     } 
/*      */     
/*  491 */     return ev_postable;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public String getDescription() {
/*  499 */     return getDAO_().getDescription();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setDescription(String argDescription) {
/*  507 */     if (setDescription_noev(argDescription) && 
/*  508 */       this._events != null && 
/*  509 */       postEventsForChanges()) {
/*  510 */       this._events.post(IDiscount.SET_DESCRIPTION, argDescription);
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean setDescription_noev(String argDescription) {
/*  517 */     boolean ev_postable = false;
/*      */     
/*  519 */     if ((getDAO_().getDescription() == null && argDescription != null) || (
/*  520 */       getDAO_().getDescription() != null && !getDAO_().getDescription().equals(argDescription))) {
/*  521 */       getDAO_().setDescription(argDescription);
/*  522 */       ev_postable = true;
/*      */     } 
/*      */     
/*  525 */     return ev_postable;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public Date getEffectiveDatetime() {
/*  533 */     return getDAO_().getEffectiveDatetime();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setEffectiveDatetime(Date argEffectiveDatetime) {
/*  541 */     if (setEffectiveDatetime_noev(argEffectiveDatetime) && 
/*  542 */       this._events != null && 
/*  543 */       postEventsForChanges()) {
/*  544 */       this._events.post(IDiscount.SET_EFFECTIVEDATETIME, argEffectiveDatetime);
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean setEffectiveDatetime_noev(Date argEffectiveDatetime) {
/*  551 */     boolean ev_postable = false;
/*      */     
/*  553 */     if ((getDAO_().getEffectiveDatetime() == null && argEffectiveDatetime != null) || (
/*  554 */       getDAO_().getEffectiveDatetime() != null && !getDAO_().getEffectiveDatetime().equals(argEffectiveDatetime))) {
/*  555 */       getDAO_().setEffectiveDatetime(argEffectiveDatetime);
/*  556 */       ev_postable = true;
/*      */     } 
/*      */     
/*  559 */     return ev_postable;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean getExclusiveDiscount() {
/*  567 */     if (getDAO_().getExclusiveDiscount() != null) {
/*  568 */       return getDAO_().getExclusiveDiscount().booleanValue();
/*      */     }
/*      */     
/*  571 */     return false;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setExclusiveDiscount(boolean argExclusiveDiscount) {
/*  580 */     if (setExclusiveDiscount_noev(argExclusiveDiscount) && 
/*  581 */       this._events != null && 
/*  582 */       postEventsForChanges()) {
/*  583 */       this._events.post(IDiscount.SET_EXCLUSIVEDISCOUNT, Boolean.valueOf(argExclusiveDiscount));
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean setExclusiveDiscount_noev(boolean argExclusiveDiscount) {
/*  590 */     boolean ev_postable = false;
/*      */     
/*  592 */     if ((getDAO_().getExclusiveDiscount() == null && Boolean.valueOf(argExclusiveDiscount) != null) || (
/*  593 */       getDAO_().getExclusiveDiscount() != null && !getDAO_().getExclusiveDiscount().equals(Boolean.valueOf(argExclusiveDiscount)))) {
/*  594 */       getDAO_().setExclusiveDiscount(Boolean.valueOf(argExclusiveDiscount));
/*  595 */       ev_postable = true;
/*      */     } 
/*      */     
/*  598 */     return ev_postable;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public Date getExpirationDatetime() {
/*  606 */     return getDAO_().getExpirationDatetime();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setExpirationDatetime(Date argExpirationDatetime) {
/*  614 */     if (setExpirationDatetime_noev(argExpirationDatetime) && 
/*  615 */       this._events != null && 
/*  616 */       postEventsForChanges()) {
/*  617 */       this._events.post(IDiscount.SET_EXPIRATIONDATETIME, argExpirationDatetime);
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean setExpirationDatetime_noev(Date argExpirationDatetime) {
/*  624 */     boolean ev_postable = false;
/*      */     
/*  626 */     if ((getDAO_().getExpirationDatetime() == null && argExpirationDatetime != null) || (
/*  627 */       getDAO_().getExpirationDatetime() != null && !getDAO_().getExpirationDatetime().equals(argExpirationDatetime))) {
/*  628 */       getDAO_().setExpirationDatetime(argExpirationDatetime);
/*  629 */       ev_postable = true;
/*      */     } 
/*      */     
/*  632 */     return ev_postable;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public long getMaximumTransactionCount() {
/*  640 */     if (getDAO_().getMaximumTransactionCount() != null) {
/*  641 */       return getDAO_().getMaximumTransactionCount().longValue();
/*      */     }
/*      */     
/*  644 */     return 0L;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setMaximumTransactionCount(long argMaximumTransactionCount) {
/*  653 */     if (setMaximumTransactionCount_noev(argMaximumTransactionCount) && 
/*  654 */       this._events != null && 
/*  655 */       postEventsForChanges()) {
/*  656 */       this._events.post(IDiscount.SET_MAXIMUMTRANSACTIONCOUNT, Long.valueOf(argMaximumTransactionCount));
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean setMaximumTransactionCount_noev(long argMaximumTransactionCount) {
/*  663 */     boolean ev_postable = false;
/*      */     
/*  665 */     if ((getDAO_().getMaximumTransactionCount() == null && Long.valueOf(argMaximumTransactionCount) != null) || (
/*  666 */       getDAO_().getMaximumTransactionCount() != null && !getDAO_().getMaximumTransactionCount().equals(Long.valueOf(argMaximumTransactionCount)))) {
/*  667 */       getDAO_().setMaximumTransactionCount(Long.valueOf(argMaximumTransactionCount));
/*  668 */       ev_postable = true;
/*      */     } 
/*      */     
/*  671 */     return ev_postable;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public BigDecimal getMinimumEligiblePrice() {
/*  679 */     return getDAO_().getMinimumEligiblePrice();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setMinimumEligiblePrice(BigDecimal argMinimumEligiblePrice) {
/*  687 */     if (setMinimumEligiblePrice_noev(argMinimumEligiblePrice) && 
/*  688 */       this._events != null && 
/*  689 */       postEventsForChanges()) {
/*  690 */       this._events.post(IDiscount.SET_MINIMUMELIGIBLEPRICE, argMinimumEligiblePrice);
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean setMinimumEligiblePrice_noev(BigDecimal argMinimumEligiblePrice) {
/*  697 */     boolean ev_postable = false;
/*      */     
/*  699 */     if ((getDAO_().getMinimumEligiblePrice() == null && argMinimumEligiblePrice != null) || (
/*  700 */       getDAO_().getMinimumEligiblePrice() != null && !getDAO_().getMinimumEligiblePrice().equals(argMinimumEligiblePrice))) {
/*  701 */       getDAO_().setMinimumEligiblePrice(argMinimumEligiblePrice);
/*  702 */       ev_postable = true;
/*      */     } 
/*      */     
/*  705 */     return ev_postable;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public BigDecimal getPercent() {
/*  713 */     return getDAO_().getPercent();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setPercent(BigDecimal argPercent) {
/*  721 */     if (setPercent_noev(argPercent) && 
/*  722 */       this._events != null && 
/*  723 */       postEventsForChanges()) {
/*  724 */       this._events.post(IDiscount.SET_PERCENT, argPercent);
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean setPercent_noev(BigDecimal argPercent) {
/*  731 */     boolean ev_postable = false;
/*      */     
/*  733 */     if ((getDAO_().getPercent() == null && argPercent != null) || (
/*  734 */       getDAO_().getPercent() != null && !getDAO_().getPercent().equals(argPercent))) {
/*  735 */       getDAO_().setPercent(argPercent);
/*  736 */       ev_postable = true;
/*      */     } 
/*      */     
/*  739 */     return ev_postable;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public String getPrompt() {
/*  747 */     return getDAO_().getPrompt();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setPrompt(String argPrompt) {
/*  755 */     if (setPrompt_noev(argPrompt) && 
/*  756 */       this._events != null && 
/*  757 */       postEventsForChanges()) {
/*  758 */       this._events.post(IDiscount.SET_PROMPT, argPrompt);
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean setPrompt_noev(String argPrompt) {
/*  765 */     boolean ev_postable = false;
/*      */     
/*  767 */     if ((getDAO_().getPrompt() == null && argPrompt != null) || (
/*  768 */       getDAO_().getPrompt() != null && !getDAO_().getPrompt().equals(argPrompt))) {
/*  769 */       getDAO_().setPrompt(argPrompt);
/*  770 */       ev_postable = true;
/*      */     } 
/*      */     
/*  773 */     return ev_postable;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public String getSound() {
/*  781 */     return getDAO_().getSound();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setSound(String argSound) {
/*  789 */     if (setSound_noev(argSound) && 
/*  790 */       this._events != null && 
/*  791 */       postEventsForChanges()) {
/*  792 */       this._events.post(IDiscount.SET_SOUND, argSound);
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean setSound_noev(String argSound) {
/*  799 */     boolean ev_postable = false;
/*      */     
/*  801 */     if ((getDAO_().getSound() == null && argSound != null) || (
/*  802 */       getDAO_().getSound() != null && !getDAO_().getSound().equals(argSound))) {
/*  803 */       getDAO_().setSound(argSound);
/*  804 */       ev_postable = true;
/*      */     } 
/*      */     
/*  807 */     return ev_postable;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public String getTypeCode() {
/*  815 */     return getDAO_().getTypeCode();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setTypeCode(String argTypeCode) {
/*  823 */     if (setTypeCode_noev(argTypeCode) && 
/*  824 */       this._events != null && 
/*  825 */       postEventsForChanges()) {
/*  826 */       this._events.post(IDiscount.SET_TYPECODE, argTypeCode);
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean setTypeCode_noev(String argTypeCode) {
/*  833 */     boolean ev_postable = false;
/*      */     
/*  835 */     if ((getDAO_().getTypeCode() == null && argTypeCode != null) || (
/*  836 */       getDAO_().getTypeCode() != null && !getDAO_().getTypeCode().equals(argTypeCode))) {
/*  837 */       getDAO_().setTypeCode(argTypeCode);
/*  838 */       ev_postable = true;
/*      */     } 
/*      */     
/*  841 */     return ev_postable;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean getSerializedDiscount() {
/*  849 */     if (getDAO_().getSerializedDiscount() != null) {
/*  850 */       return getDAO_().getSerializedDiscount().booleanValue();
/*      */     }
/*      */     
/*  853 */     return false;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setSerializedDiscount(boolean argSerializedDiscount) {
/*  862 */     if (setSerializedDiscount_noev(argSerializedDiscount) && 
/*  863 */       this._events != null && 
/*  864 */       postEventsForChanges()) {
/*  865 */       this._events.post(IDiscount.SET_SERIALIZEDDISCOUNT, Boolean.valueOf(argSerializedDiscount));
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean setSerializedDiscount_noev(boolean argSerializedDiscount) {
/*  872 */     boolean ev_postable = false;
/*      */     
/*  874 */     if ((getDAO_().getSerializedDiscount() == null && Boolean.valueOf(argSerializedDiscount) != null) || (
/*  875 */       getDAO_().getSerializedDiscount() != null && !getDAO_().getSerializedDiscount().equals(Boolean.valueOf(argSerializedDiscount)))) {
/*  876 */       getDAO_().setSerializedDiscount(Boolean.valueOf(argSerializedDiscount));
/*  877 */       ev_postable = true;
/*      */     } 
/*      */     
/*  880 */     return ev_postable;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public String getPrivilegeType() {
/*  888 */     return getDAO_().getPrivilegeType();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setPrivilegeType(String argPrivilegeType) {
/*  896 */     if (setPrivilegeType_noev(argPrivilegeType) && 
/*  897 */       this._events != null && 
/*  898 */       postEventsForChanges()) {
/*  899 */       this._events.post(IDiscount.SET_PRIVILEGETYPE, argPrivilegeType);
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean setPrivilegeType_noev(String argPrivilegeType) {
/*  906 */     boolean ev_postable = false;
/*      */     
/*  908 */     if ((getDAO_().getPrivilegeType() == null && argPrivilegeType != null) || (
/*  909 */       getDAO_().getPrivilegeType() != null && !getDAO_().getPrivilegeType().equals(argPrivilegeType))) {
/*  910 */       getDAO_().setPrivilegeType(argPrivilegeType);
/*  911 */       ev_postable = true;
/*      */     } 
/*      */     
/*  914 */     return ev_postable;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public String getTaxabilityCode() {
/*  922 */     return getDAO_().getTaxabilityCode();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setTaxabilityCode(String argTaxabilityCode) {
/*  930 */     if (setTaxabilityCode_noev(argTaxabilityCode) && 
/*  931 */       this._events != null && 
/*  932 */       postEventsForChanges()) {
/*  933 */       this._events.post(IDiscount.SET_TAXABILITYCODE, argTaxabilityCode);
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean setTaxabilityCode_noev(String argTaxabilityCode) {
/*  940 */     boolean ev_postable = false;
/*      */     
/*  942 */     if ((getDAO_().getTaxabilityCode() == null && argTaxabilityCode != null) || (
/*  943 */       getDAO_().getTaxabilityCode() != null && !getDAO_().getTaxabilityCode().equals(argTaxabilityCode))) {
/*  944 */       getDAO_().setTaxabilityCode(argTaxabilityCode);
/*  945 */       ev_postable = true;
/*      */     } 
/*      */     
/*  948 */     return ev_postable;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public BigDecimal getMaxDiscount() {
/*  956 */     return getDAO_().getMaxDiscount();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setMaxDiscount(BigDecimal argMaxDiscount) {
/*  964 */     if (setMaxDiscount_noev(argMaxDiscount) && 
/*  965 */       this._events != null && 
/*  966 */       postEventsForChanges()) {
/*  967 */       this._events.post(IDiscount.SET_MAXDISCOUNT, argMaxDiscount);
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean setMaxDiscount_noev(BigDecimal argMaxDiscount) {
/*  974 */     boolean ev_postable = false;
/*      */     
/*  976 */     if ((getDAO_().getMaxDiscount() == null && argMaxDiscount != null) || (
/*  977 */       getDAO_().getMaxDiscount() != null && !getDAO_().getMaxDiscount().equals(argMaxDiscount))) {
/*  978 */       getDAO_().setMaxDiscount(argMaxDiscount);
/*  979 */       ev_postable = true;
/*      */     } 
/*      */     
/*  982 */     return ev_postable;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public BigDecimal getMaxAmount() {
/*  990 */     return getDAO_().getMaxAmount();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setMaxAmount(BigDecimal argMaxAmount) {
/*  998 */     if (setMaxAmount_noev(argMaxAmount) && 
/*  999 */       this._events != null && 
/* 1000 */       postEventsForChanges()) {
/* 1001 */       this._events.post(IDiscount.SET_MAXAMOUNT, argMaxAmount);
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean setMaxAmount_noev(BigDecimal argMaxAmount) {
/* 1008 */     boolean ev_postable = false;
/*      */     
/* 1010 */     if ((getDAO_().getMaxAmount() == null && argMaxAmount != null) || (
/* 1011 */       getDAO_().getMaxAmount() != null && !getDAO_().getMaxAmount().equals(argMaxAmount))) {
/* 1012 */       getDAO_().setMaxAmount(argMaxAmount);
/* 1013 */       ev_postable = true;
/*      */     } 
/*      */     
/* 1016 */     return ev_postable;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public BigDecimal getMaxPercentage() {
/* 1024 */     return getDAO_().getMaxPercentage();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setMaxPercentage(BigDecimal argMaxPercentage) {
/* 1032 */     if (setMaxPercentage_noev(argMaxPercentage) && 
/* 1033 */       this._events != null && 
/* 1034 */       postEventsForChanges()) {
/* 1035 */       this._events.post(IDiscount.SET_MAXPERCENTAGE, argMaxPercentage);
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean setMaxPercentage_noev(BigDecimal argMaxPercentage) {
/* 1042 */     boolean ev_postable = false;
/*      */     
/* 1044 */     if ((getDAO_().getMaxPercentage() == null && argMaxPercentage != null) || (
/* 1045 */       getDAO_().getMaxPercentage() != null && !getDAO_().getMaxPercentage().equals(argMaxPercentage))) {
/* 1046 */       getDAO_().setMaxPercentage(argMaxPercentage);
/* 1047 */       ev_postable = true;
/*      */     } 
/*      */     
/* 1050 */     return ev_postable;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public int getSortOrder() {
/* 1058 */     if (getDAO_().getSortOrder() != null) {
/* 1059 */       return getDAO_().getSortOrder().intValue();
/*      */     }
/*      */     
/* 1062 */     return 0;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setSortOrder(int argSortOrder) {
/* 1071 */     if (setSortOrder_noev(argSortOrder) && 
/* 1072 */       this._events != null && 
/* 1073 */       postEventsForChanges()) {
/* 1074 */       this._events.post(IDiscount.SET_SORTORDER, Integer.valueOf(argSortOrder));
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean setSortOrder_noev(int argSortOrder) {
/* 1081 */     boolean ev_postable = false;
/*      */     
/* 1083 */     if ((getDAO_().getSortOrder() == null && Integer.valueOf(argSortOrder) != null) || (
/* 1084 */       getDAO_().getSortOrder() != null && !getDAO_().getSortOrder().equals(Integer.valueOf(argSortOrder)))) {
/* 1085 */       getDAO_().setSortOrder(Integer.valueOf(argSortOrder));
/* 1086 */       ev_postable = true;
/*      */     } 
/*      */     
/* 1089 */     return ev_postable;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean getDisallowChange() {
/* 1097 */     if (getDAO_().getDisallowChange() != null) {
/* 1098 */       return getDAO_().getDisallowChange().booleanValue();
/*      */     }
/*      */     
/* 1101 */     return false;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setDisallowChange(boolean argDisallowChange) {
/* 1110 */     if (setDisallowChange_noev(argDisallowChange) && 
/* 1111 */       this._events != null && 
/* 1112 */       postEventsForChanges()) {
/* 1113 */       this._events.post(IDiscount.SET_DISALLOWCHANGE, Boolean.valueOf(argDisallowChange));
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean setDisallowChange_noev(boolean argDisallowChange) {
/* 1120 */     boolean ev_postable = false;
/*      */     
/* 1122 */     if ((getDAO_().getDisallowChange() == null && Boolean.valueOf(argDisallowChange) != null) || (
/* 1123 */       getDAO_().getDisallowChange() != null && !getDAO_().getDisallowChange().equals(Boolean.valueOf(argDisallowChange)))) {
/* 1124 */       getDAO_().setDisallowChange(Boolean.valueOf(argDisallowChange));
/* 1125 */       ev_postable = true;
/*      */     } 
/*      */     
/* 1128 */     return ev_postable;
/*      */   }
/*      */   
/*      */   protected IDiscountProperty newProperty(String argPropertyName) {
/* 1132 */     DiscountPropertyId id = new DiscountPropertyId();
/*      */     
/* 1134 */     id.setDiscountCode(getDiscountCode());
/* 1135 */     id.setPropertyCode(argPropertyName);
/*      */     
/* 1137 */     IDiscountProperty prop = (IDiscountProperty)DataFactory.getInstance().createNewObject((IObjectId)id, IDiscountProperty.class);
/* 1138 */     return prop;
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
/*      */ 
/*      */ 
/*      */   
/*      */   @Relationship(name = "CompatibleDiscounts")
/*      */   public List<IDiscountCompatability> getCompatibleDiscounts() {
/* 1159 */     if (this._compatibleDiscounts == null) {
/* 1160 */       this._compatibleDiscounts = new HistoricalList(null);
/*      */     }
/* 1162 */     return (List<IDiscountCompatability>)this._compatibleDiscounts;
/*      */   }
/*      */   
/*      */   public void setCompatibleDiscounts(List<IDiscountCompatability> argCompatibleDiscounts) {
/* 1166 */     if (this._compatibleDiscounts == null) {
/* 1167 */       this._compatibleDiscounts = new HistoricalList(argCompatibleDiscounts);
/*      */     } else {
/* 1169 */       this._compatibleDiscounts.setCurrentList(argCompatibleDiscounts);
/*      */     } 
/*      */     
/* 1172 */     for (IDiscountCompatability child : this._compatibleDiscounts) {
/* 1173 */       DiscountCompatabilityModel model = (DiscountCompatabilityModel)child;
/* 1174 */       model.setPrimaryDiscountCode_noev(getDiscountCode());
/* 1175 */       model.setOrganizationId_noev(getOrganizationId());
/* 1176 */       if (child instanceof IDataModelImpl) {
/* 1177 */         IDataAccessObject childDao = ((IDataModelImpl)child).getDAO();
/* 1178 */         if (StringUtils.isEmpty(childDao.getOriginDataSource()) && 
/* 1179 */           !StringUtils.isEmpty(getDAO().getOriginDataSource())) {
/* 1180 */           childDao.setOriginDataSource(getDAO().getOriginDataSource());
/*      */         }
/*      */       } 
/* 1183 */       if (postEventsForChanges()) {
/* 1184 */         this._eventManager.registerEventHandler((IEventAware)this._eventCascade, (IEventSource)child);
/*      */       }
/*      */     } 
/*      */   }
/*      */   
/*      */   public void addDiscountCompatability(IDiscountCompatability argDiscountCompatability) {
/* 1190 */     if (this._compatibleDiscounts == null) {
/* 1191 */       this._compatibleDiscounts = new HistoricalList(null);
/*      */     }
/* 1193 */     argDiscountCompatability.setPrimaryDiscountCode(getDiscountCode());
/* 1194 */     argDiscountCompatability.setOrganizationId(getOrganizationId());
/* 1195 */     if (argDiscountCompatability instanceof IDataModelImpl) {
/* 1196 */       IDataAccessObject childDao = ((IDataModelImpl)argDiscountCompatability).getDAO();
/* 1197 */       if (StringUtils.isEmpty(childDao.getOriginDataSource()) && 
/* 1198 */         !StringUtils.isEmpty(getDAO().getOriginDataSource())) {
/* 1199 */         childDao.setOriginDataSource(getDAO().getOriginDataSource());
/*      */       }
/*      */     } 
/*      */ 
/*      */     
/* 1204 */     if (postEventsForChanges()) {
/* 1205 */       this._eventManager.registerEventHandler((IEventAware)this._eventCascade, (IEventSource)new EventDescriptor(argDiscountCompatability));
/*      */     }
/*      */     
/* 1208 */     this._compatibleDiscounts.add(argDiscountCompatability);
/* 1209 */     if (postEventsForChanges()) {
/* 1210 */       this._events.post(IDiscount.ADD_COMPATIBLEDISCOUNTS, argDiscountCompatability);
/*      */     }
/*      */   }
/*      */   
/*      */   public void removeDiscountCompatability(IDiscountCompatability argDiscountCompatability) {
/* 1215 */     if (this._compatibleDiscounts != null) {
/*      */       
/* 1217 */       if (postEventsForChanges()) {
/* 1218 */         this._eventManager.deregisterEventHandler((IEventAware)this._eventCascade, (IEventSource)new EventDescriptor(argDiscountCompatability));
/*      */       }
/* 1220 */       this._compatibleDiscounts.remove(argDiscountCompatability);
/* 1221 */       if (postEventsForChanges()) {
/* 1222 */         this._events.post(IDiscount.REMOVE_COMPATIBLEDISCOUNTS, argDiscountCompatability);
/*      */       }
/*      */     } 
/*      */   }
/*      */   
/*      */   @Relationship(name = "ValidSaleLineItemTypeCodes")
/*      */   public List<IDiscountTypeEligibility> getValidSaleLineItemTypeCodes() {
/* 1229 */     if (this._validSaleLineItemTypeCodes == null) {
/* 1230 */       this._validSaleLineItemTypeCodes = new HistoricalList(null);
/*      */     }
/* 1232 */     return (List<IDiscountTypeEligibility>)this._validSaleLineItemTypeCodes;
/*      */   }
/*      */   
/*      */   public void setValidSaleLineItemTypeCodes(List<IDiscountTypeEligibility> argValidSaleLineItemTypeCodes) {
/* 1236 */     if (this._validSaleLineItemTypeCodes == null) {
/* 1237 */       this._validSaleLineItemTypeCodes = new HistoricalList(argValidSaleLineItemTypeCodes);
/*      */     } else {
/* 1239 */       this._validSaleLineItemTypeCodes.setCurrentList(argValidSaleLineItemTypeCodes);
/*      */     } 
/*      */     
/* 1242 */     for (IDiscountTypeEligibility child : this._validSaleLineItemTypeCodes) {
/* 1243 */       DiscountTypeEligibilityModel model = (DiscountTypeEligibilityModel)child;
/* 1244 */       model.setDiscountCode_noev(getDiscountCode());
/* 1245 */       model.setOrganizationId_noev(getOrganizationId());
/* 1246 */       if (child instanceof IDataModelImpl) {
/* 1247 */         IDataAccessObject childDao = ((IDataModelImpl)child).getDAO();
/* 1248 */         if (StringUtils.isEmpty(childDao.getOriginDataSource()) && 
/* 1249 */           !StringUtils.isEmpty(getDAO().getOriginDataSource())) {
/* 1250 */           childDao.setOriginDataSource(getDAO().getOriginDataSource());
/*      */         }
/*      */       } 
/* 1253 */       if (postEventsForChanges()) {
/* 1254 */         this._eventManager.registerEventHandler((IEventAware)this._eventCascade, (IEventSource)child);
/*      */       }
/*      */     } 
/*      */   }
/*      */   
/*      */   public void addDiscountTypeEligibility(IDiscountTypeEligibility argDiscountTypeEligibility) {
/* 1260 */     if (this._validSaleLineItemTypeCodes == null) {
/* 1261 */       this._validSaleLineItemTypeCodes = new HistoricalList(null);
/*      */     }
/* 1263 */     argDiscountTypeEligibility.setDiscountCode(getDiscountCode());
/* 1264 */     argDiscountTypeEligibility.setOrganizationId(getOrganizationId());
/* 1265 */     if (argDiscountTypeEligibility instanceof IDataModelImpl) {
/* 1266 */       IDataAccessObject childDao = ((IDataModelImpl)argDiscountTypeEligibility).getDAO();
/* 1267 */       if (StringUtils.isEmpty(childDao.getOriginDataSource()) && 
/* 1268 */         !StringUtils.isEmpty(getDAO().getOriginDataSource())) {
/* 1269 */         childDao.setOriginDataSource(getDAO().getOriginDataSource());
/*      */       }
/*      */     } 
/*      */ 
/*      */     
/* 1274 */     if (postEventsForChanges()) {
/* 1275 */       this._eventManager.registerEventHandler((IEventAware)this._eventCascade, (IEventSource)new EventDescriptor(argDiscountTypeEligibility));
/*      */     }
/*      */     
/* 1278 */     this._validSaleLineItemTypeCodes.add(argDiscountTypeEligibility);
/* 1279 */     if (postEventsForChanges()) {
/* 1280 */       this._events.post(IDiscount.ADD_VALIDSALELINEITEMTYPECODES, argDiscountTypeEligibility);
/*      */     }
/*      */   }
/*      */   
/*      */   public void removeDiscountTypeEligibility(IDiscountTypeEligibility argDiscountTypeEligibility) {
/* 1285 */     if (this._validSaleLineItemTypeCodes != null) {
/*      */       
/* 1287 */       if (postEventsForChanges()) {
/* 1288 */         this._eventManager.deregisterEventHandler((IEventAware)this._eventCascade, (IEventSource)new EventDescriptor(argDiscountTypeEligibility));
/*      */       }
/* 1290 */       this._validSaleLineItemTypeCodes.remove(argDiscountTypeEligibility);
/* 1291 */       if (postEventsForChanges()) {
/* 1292 */         this._events.post(IDiscount.REMOVE_VALIDSALELINEITEMTYPECODES, argDiscountTypeEligibility);
/*      */       }
/*      */     } 
/*      */   }
/*      */   
/*      */   @Relationship(name = "CustomerGroups")
/*      */   public List<IDiscountGroupMapping> getCustomerGroups() {
/* 1299 */     if (this._customerGroups == null) {
/* 1300 */       this._customerGroups = new HistoricalList(null);
/*      */     }
/* 1302 */     return (List<IDiscountGroupMapping>)this._customerGroups;
/*      */   }
/*      */   
/*      */   public void setCustomerGroups(List<IDiscountGroupMapping> argCustomerGroups) {
/* 1306 */     if (this._customerGroups == null) {
/* 1307 */       this._customerGroups = new HistoricalList(argCustomerGroups);
/*      */     } else {
/* 1309 */       this._customerGroups.setCurrentList(argCustomerGroups);
/*      */     } 
/*      */     
/* 1312 */     for (IDiscountGroupMapping child : this._customerGroups) {
/* 1313 */       DiscountGroupMappingModel model = (DiscountGroupMappingModel)child;
/* 1314 */       model.setDiscountCode_noev(getDiscountCode());
/* 1315 */       model.setOrganizationId_noev(getOrganizationId());
/* 1316 */       if (child instanceof IDataModelImpl) {
/* 1317 */         IDataAccessObject childDao = ((IDataModelImpl)child).getDAO();
/* 1318 */         if (StringUtils.isEmpty(childDao.getOriginDataSource()) && 
/* 1319 */           !StringUtils.isEmpty(getDAO().getOriginDataSource())) {
/* 1320 */           childDao.setOriginDataSource(getDAO().getOriginDataSource());
/*      */         }
/*      */       } 
/* 1323 */       if (postEventsForChanges()) {
/* 1324 */         this._eventManager.registerEventHandler((IEventAware)this._eventCascade, (IEventSource)child);
/*      */       }
/*      */     } 
/*      */   }
/*      */   
/*      */   public void addDiscountGroupMapping(IDiscountGroupMapping argDiscountGroupMapping) {
/* 1330 */     if (this._customerGroups == null) {
/* 1331 */       this._customerGroups = new HistoricalList(null);
/*      */     }
/* 1333 */     argDiscountGroupMapping.setDiscountCode(getDiscountCode());
/* 1334 */     argDiscountGroupMapping.setOrganizationId(getOrganizationId());
/* 1335 */     if (argDiscountGroupMapping instanceof IDataModelImpl) {
/* 1336 */       IDataAccessObject childDao = ((IDataModelImpl)argDiscountGroupMapping).getDAO();
/* 1337 */       if (StringUtils.isEmpty(childDao.getOriginDataSource()) && 
/* 1338 */         !StringUtils.isEmpty(getDAO().getOriginDataSource())) {
/* 1339 */         childDao.setOriginDataSource(getDAO().getOriginDataSource());
/*      */       }
/*      */     } 
/*      */ 
/*      */     
/* 1344 */     if (postEventsForChanges()) {
/* 1345 */       this._eventManager.registerEventHandler((IEventAware)this._eventCascade, (IEventSource)new EventDescriptor(argDiscountGroupMapping));
/*      */     }
/*      */     
/* 1348 */     this._customerGroups.add(argDiscountGroupMapping);
/* 1349 */     if (postEventsForChanges()) {
/* 1350 */       this._events.post(IDiscount.ADD_CUSTOMERGROUPS, argDiscountGroupMapping);
/*      */     }
/*      */   }
/*      */   
/*      */   public void removeDiscountGroupMapping(IDiscountGroupMapping argDiscountGroupMapping) {
/* 1355 */     if (this._customerGroups != null) {
/*      */       
/* 1357 */       if (postEventsForChanges()) {
/* 1358 */         this._eventManager.deregisterEventHandler((IEventAware)this._eventCascade, (IEventSource)new EventDescriptor(argDiscountGroupMapping));
/*      */       }
/* 1360 */       this._customerGroups.remove(argDiscountGroupMapping);
/* 1361 */       if (postEventsForChanges()) {
/* 1362 */         this._events.post(IDiscount.REMOVE_CUSTOMERGROUPS, argDiscountGroupMapping);
/*      */       }
/*      */     } 
/*      */   }
/*      */   
/*      */   @Relationship(name = "Privilege")
/*      */   public IPrivilege getPrivilege() {
/* 1369 */     return this._privilege;
/*      */   }
/*      */ 
/*      */   
/*      */   public void setPrivilege(IPrivilege argPrivilege) {
/* 1374 */     if (argPrivilege == null) {
/*      */       
/* 1376 */       getDAO_().setPrivilegeType(null);
/* 1377 */       if (this._privilege != null)
/*      */       {
/* 1379 */         if (postEventsForChanges()) {
/* 1380 */           this._eventManager.deregisterEventHandler((IEventAware)this._eventCascade, (IEventSource)new EventDescriptor(this._privilege));
/*      */         }
/*      */       }
/*      */     } else {
/*      */       
/* 1385 */       getDAO_().setPrivilegeType(argPrivilege.getPrivilegeType());
/*      */       
/* 1387 */       if (postEventsForChanges()) {
/* 1388 */         this._eventManager.registerEventHandler((IEventAware)this._eventCascade, (IEventSource)new EventDescriptor(argPrivilege));
/*      */       }
/*      */     } 
/*      */     
/* 1392 */     this._privilege = argPrivilege;
/* 1393 */     if (postEventsForChanges()) {
/* 1394 */       this._events.post(IDiscount.SET_PRIVILEGE, argPrivilege);
/*      */     }
/*      */   }
/*      */   
/*      */   @Relationship(name = "Properties")
/*      */   public List<IDiscountProperty> getProperties() {
/* 1400 */     if (this._properties == null) {
/* 1401 */       this._properties = new HistoricalList(null);
/*      */     }
/* 1403 */     return (List<IDiscountProperty>)this._properties;
/*      */   }
/*      */   
/*      */   public void setProperties(List<IDiscountProperty> argProperties) {
/* 1407 */     if (this._properties == null) {
/* 1408 */       this._properties = new HistoricalList(argProperties);
/*      */     } else {
/* 1410 */       this._properties.setCurrentList(argProperties);
/*      */     } 
/*      */     
/* 1413 */     for (IDiscountProperty child : this._properties) {
/* 1414 */       DiscountPropertyModel model = (DiscountPropertyModel)child;
/* 1415 */       model.setDiscountCode_noev(getDiscountCode());
/* 1416 */       model.setOrganizationId_noev(getOrganizationId());
/* 1417 */       if (child instanceof IDataModelImpl) {
/* 1418 */         IDataAccessObject childDao = ((IDataModelImpl)child).getDAO();
/* 1419 */         if (StringUtils.isEmpty(childDao.getOriginDataSource()) && 
/* 1420 */           !StringUtils.isEmpty(getDAO().getOriginDataSource())) {
/* 1421 */           childDao.setOriginDataSource(getDAO().getOriginDataSource());
/*      */         }
/*      */       } 
/* 1424 */       if (postEventsForChanges()) {
/* 1425 */         this._eventManager.registerEventHandler((IEventAware)this._eventCascade, (IEventSource)child);
/*      */       }
/*      */     } 
/*      */   }
/*      */   
/*      */   public void addDiscountProperty(IDiscountProperty argDiscountProperty) {
/* 1431 */     if (this._properties == null) {
/* 1432 */       this._properties = new HistoricalList(null);
/*      */     }
/* 1434 */     argDiscountProperty.setDiscountCode(getDiscountCode());
/* 1435 */     argDiscountProperty.setOrganizationId(getOrganizationId());
/* 1436 */     if (argDiscountProperty instanceof IDataModelImpl) {
/* 1437 */       IDataAccessObject childDao = ((IDataModelImpl)argDiscountProperty).getDAO();
/* 1438 */       if (StringUtils.isEmpty(childDao.getOriginDataSource()) && 
/* 1439 */         !StringUtils.isEmpty(getDAO().getOriginDataSource())) {
/* 1440 */         childDao.setOriginDataSource(getDAO().getOriginDataSource());
/*      */       }
/*      */     } 
/*      */ 
/*      */     
/* 1445 */     if (postEventsForChanges()) {
/* 1446 */       this._eventManager.registerEventHandler((IEventAware)this._eventCascade, (IEventSource)new EventDescriptor(argDiscountProperty));
/*      */     }
/*      */     
/* 1449 */     this._properties.add(argDiscountProperty);
/* 1450 */     if (postEventsForChanges()) {
/* 1451 */       this._events.post(IDiscount.ADD_PROPERTIES, argDiscountProperty);
/*      */     }
/*      */   }
/*      */   
/*      */   public void removeDiscountProperty(IDiscountProperty argDiscountProperty) {
/* 1456 */     if (this._properties != null) {
/*      */       
/* 1458 */       if (postEventsForChanges()) {
/* 1459 */         this._eventManager.deregisterEventHandler((IEventAware)this._eventCascade, (IEventSource)new EventDescriptor(argDiscountProperty));
/*      */       }
/* 1461 */       this._properties.remove(argDiscountProperty);
/* 1462 */       if (postEventsForChanges()) {
/* 1463 */         this._events.post(IDiscount.REMOVE_PROPERTIES, argDiscountProperty);
/*      */       }
/*      */     } 
/*      */   }
/*      */ 
/*      */   
/*      */   public Object getValue(String argFieldId) {
/* 1470 */     if ("CompatibleDiscounts".equals(argFieldId)) {
/* 1471 */       return getCompatibleDiscounts();
/*      */     }
/* 1473 */     if ("ValidSaleLineItemTypeCodes".equals(argFieldId)) {
/* 1474 */       return getValidSaleLineItemTypeCodes();
/*      */     }
/* 1476 */     if ("CustomerGroups".equals(argFieldId)) {
/* 1477 */       return getCustomerGroups();
/*      */     }
/* 1479 */     if ("Privilege".equals(argFieldId)) {
/* 1480 */       return getPrivilege();
/*      */     }
/* 1482 */     if ("Properties".equals(argFieldId)) {
/* 1483 */       return getProperties();
/*      */     }
/* 1485 */     if ("DiscountExtension".equals(argFieldId)) {
/* 1486 */       return this._myExtension;
/*      */     }
/*      */     
/* 1489 */     return super.getValue(argFieldId);
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public void setValue(String argFieldId, Object argValue) {
/* 1495 */     if ("CompatibleDiscounts".equals(argFieldId)) {
/* 1496 */       setCompatibleDiscounts(changeToList(argValue, IDiscountCompatability.class));
/*      */     }
/* 1498 */     else if ("ValidSaleLineItemTypeCodes".equals(argFieldId)) {
/* 1499 */       setValidSaleLineItemTypeCodes(changeToList(argValue, IDiscountTypeEligibility.class));
/*      */     }
/* 1501 */     else if ("CustomerGroups".equals(argFieldId)) {
/* 1502 */       setCustomerGroups(changeToList(argValue, IDiscountGroupMapping.class));
/*      */     }
/* 1504 */     else if ("Privilege".equals(argFieldId)) {
/* 1505 */       setPrivilege((IPrivilege)argValue);
/*      */     }
/* 1507 */     else if ("Properties".equals(argFieldId)) {
/* 1508 */       setProperties(changeToList(argValue, IDiscountProperty.class));
/*      */     }
/* 1510 */     else if ("DiscountExtension".equals(argFieldId)) {
/* 1511 */       this._myExtension = (IDataModel)argValue;
/*      */     } else {
/*      */       
/* 1514 */       super.setValue(argFieldId, argValue);
/*      */     } 
/*      */   }
/*      */ 
/*      */   
/*      */   public void setDependencies(IPersistenceDefaults argPD, EventManager argEM) {
/* 1520 */     this._persistenceDefaults = argPD;
/* 1521 */     this._daoImpl.setPersistenceDefaults(argPD);
/* 1522 */     this._eventManager = argEM;
/* 1523 */     this._events = (Eventor)new ModelEventor((IDataModel)this, argEM);
/* 1524 */     this._eventCascade = (EventHandler)new CascadingHandler(this);
/* 1525 */     if (this._compatibleDiscounts != null) {
/* 1526 */       for (IDiscountCompatability relationship : this._compatibleDiscounts) {
/* 1527 */         ((IDataModelImpl)relationship).setDependencies(argPD, argEM);
/*      */       }
/*      */     }
/* 1530 */     if (this._validSaleLineItemTypeCodes != null) {
/* 1531 */       for (IDiscountTypeEligibility relationship : this._validSaleLineItemTypeCodes) {
/* 1532 */         ((IDataModelImpl)relationship).setDependencies(argPD, argEM);
/*      */       }
/*      */     }
/* 1535 */     if (this._customerGroups != null) {
/* 1536 */       for (IDiscountGroupMapping relationship : this._customerGroups) {
/* 1537 */         ((IDataModelImpl)relationship).setDependencies(argPD, argEM);
/*      */       }
/*      */     }
/* 1540 */     if (this._privilege != null) {
/* 1541 */       ((IDataModelImpl)this._privilege).setDependencies(argPD, argEM);
/*      */     }
/* 1543 */     if (this._properties != null) {
/* 1544 */       for (IDiscountProperty relationship : this._properties) {
/* 1545 */         ((IDataModelImpl)relationship).setDependencies(argPD, argEM);
/*      */       }
/*      */     }
/*      */   }
/*      */   
/*      */   public IDataModel getDiscountExt() {
/* 1551 */     return this._myExtension;
/*      */   }
/*      */   
/*      */   public void setDiscountExt(IDataModel argExt) {
/* 1555 */     this._myExtension = argExt;
/*      */   }
/*      */ 
/*      */   
/*      */   public void startTransaction() {
/* 1560 */     if (this._alreadyInStart) {
/*      */       return;
/*      */     }
/*      */     
/* 1564 */     this._alreadyInStart = true;
/*      */ 
/*      */     
/* 1567 */     super.startTransaction();
/*      */     
/* 1569 */     this._compatibleDiscountsSavepoint = this._compatibleDiscounts;
/* 1570 */     if (this._compatibleDiscounts != null) {
/* 1571 */       this._compatibleDiscountsSavepoint = new HistoricalList((List)this._compatibleDiscounts);
/* 1572 */       Iterator<IDataModel> it = this._compatibleDiscounts.iterator();
/* 1573 */       while (it.hasNext()) {
/* 1574 */         ((IDataModel)it.next()).startTransaction();
/*      */       }
/*      */     } 
/*      */     
/* 1578 */     this._validSaleLineItemTypeCodesSavepoint = this._validSaleLineItemTypeCodes;
/* 1579 */     if (this._validSaleLineItemTypeCodes != null) {
/* 1580 */       this._validSaleLineItemTypeCodesSavepoint = new HistoricalList((List)this._validSaleLineItemTypeCodes);
/* 1581 */       Iterator<IDataModel> it = this._validSaleLineItemTypeCodes.iterator();
/* 1582 */       while (it.hasNext()) {
/* 1583 */         ((IDataModel)it.next()).startTransaction();
/*      */       }
/*      */     } 
/*      */     
/* 1587 */     this._customerGroupsSavepoint = this._customerGroups;
/* 1588 */     if (this._customerGroups != null) {
/* 1589 */       this._customerGroupsSavepoint = new HistoricalList((List)this._customerGroups);
/* 1590 */       Iterator<IDataModel> it = this._customerGroups.iterator();
/* 1591 */       while (it.hasNext()) {
/* 1592 */         ((IDataModel)it.next()).startTransaction();
/*      */       }
/*      */     } 
/*      */     
/* 1596 */     this._privilegeSavepoint = this._privilege;
/* 1597 */     if (this._privilege != null) {
/* 1598 */       this._privilege.startTransaction();
/*      */     }
/*      */     
/* 1601 */     this._propertiesSavepoint = this._properties;
/* 1602 */     if (this._properties != null) {
/* 1603 */       this._propertiesSavepoint = new HistoricalList((List)this._properties);
/* 1604 */       Iterator<IDataModel> it = this._properties.iterator();
/* 1605 */       while (it.hasNext()) {
/* 1606 */         ((IDataModel)it.next()).startTransaction();
/*      */       }
/*      */     } 
/*      */ 
/*      */     
/* 1611 */     this._alreadyInStart = false;
/*      */   }
/*      */ 
/*      */   
/*      */   public void rollbackChanges() {
/* 1616 */     if (isAlreadyRolledBack()) {
/*      */       return;
/*      */     }
/* 1619 */     super.rollbackChanges();
/*      */     
/* 1621 */     this._compatibleDiscounts = this._compatibleDiscountsSavepoint;
/* 1622 */     this._compatibleDiscountsSavepoint = null;
/* 1623 */     if (this._compatibleDiscounts != null) {
/* 1624 */       Iterator<IDataModel> it = this._compatibleDiscounts.iterator();
/* 1625 */       while (it.hasNext()) {
/* 1626 */         ((IDataModel)it.next()).rollbackChanges();
/*      */       }
/*      */     } 
/*      */     
/* 1630 */     this._validSaleLineItemTypeCodes = this._validSaleLineItemTypeCodesSavepoint;
/* 1631 */     this._validSaleLineItemTypeCodesSavepoint = null;
/* 1632 */     if (this._validSaleLineItemTypeCodes != null) {
/* 1633 */       Iterator<IDataModel> it = this._validSaleLineItemTypeCodes.iterator();
/* 1634 */       while (it.hasNext()) {
/* 1635 */         ((IDataModel)it.next()).rollbackChanges();
/*      */       }
/*      */     } 
/*      */     
/* 1639 */     this._customerGroups = this._customerGroupsSavepoint;
/* 1640 */     this._customerGroupsSavepoint = null;
/* 1641 */     if (this._customerGroups != null) {
/* 1642 */       Iterator<IDataModel> it = this._customerGroups.iterator();
/* 1643 */       while (it.hasNext()) {
/* 1644 */         ((IDataModel)it.next()).rollbackChanges();
/*      */       }
/*      */     } 
/*      */     
/* 1648 */     this._privilege = this._privilegeSavepoint;
/* 1649 */     this._privilegeSavepoint = null;
/* 1650 */     if (this._privilege != null) {
/* 1651 */       this._privilege.rollbackChanges();
/*      */     }
/*      */     
/* 1654 */     this._properties = this._propertiesSavepoint;
/* 1655 */     this._propertiesSavepoint = null;
/* 1656 */     if (this._properties != null) {
/* 1657 */       Iterator<IDataModel> it = this._properties.iterator();
/* 1658 */       while (it.hasNext()) {
/* 1659 */         ((IDataModel)it.next()).rollbackChanges();
/*      */       }
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public void commitTransaction() {
/* 1667 */     if (this._alreadyInCommit) {
/*      */       return;
/*      */     }
/* 1670 */     this._alreadyInCommit = true;
/*      */ 
/*      */     
/* 1673 */     super.commitTransaction();
/*      */     
/* 1675 */     this._compatibleDiscountsSavepoint = this._compatibleDiscounts;
/* 1676 */     if (this._compatibleDiscounts != null) {
/* 1677 */       Iterator<IDataModel> it = this._compatibleDiscounts.iterator();
/* 1678 */       while (it.hasNext()) {
/* 1679 */         ((IDataModel)it.next()).commitTransaction();
/*      */       }
/* 1681 */       this._compatibleDiscounts = new HistoricalList((List)this._compatibleDiscounts);
/*      */     } 
/*      */     
/* 1684 */     this._validSaleLineItemTypeCodesSavepoint = this._validSaleLineItemTypeCodes;
/* 1685 */     if (this._validSaleLineItemTypeCodes != null) {
/* 1686 */       Iterator<IDataModel> it = this._validSaleLineItemTypeCodes.iterator();
/* 1687 */       while (it.hasNext()) {
/* 1688 */         ((IDataModel)it.next()).commitTransaction();
/*      */       }
/* 1690 */       this._validSaleLineItemTypeCodes = new HistoricalList((List)this._validSaleLineItemTypeCodes);
/*      */     } 
/*      */     
/* 1693 */     this._customerGroupsSavepoint = this._customerGroups;
/* 1694 */     if (this._customerGroups != null) {
/* 1695 */       Iterator<IDataModel> it = this._customerGroups.iterator();
/* 1696 */       while (it.hasNext()) {
/* 1697 */         ((IDataModel)it.next()).commitTransaction();
/*      */       }
/* 1699 */       this._customerGroups = new HistoricalList((List)this._customerGroups);
/*      */     } 
/*      */     
/* 1702 */     this._privilegeSavepoint = this._privilege;
/* 1703 */     if (this._privilege != null) {
/* 1704 */       this._privilege.commitTransaction();
/*      */     }
/*      */     
/* 1707 */     this._propertiesSavepoint = this._properties;
/* 1708 */     if (this._properties != null) {
/* 1709 */       Iterator<IDataModel> it = this._properties.iterator();
/* 1710 */       while (it.hasNext()) {
/* 1711 */         ((IDataModel)it.next()).commitTransaction();
/*      */       }
/* 1713 */       this._properties = new HistoricalList((List)this._properties);
/*      */     } 
/*      */ 
/*      */     
/* 1717 */     this._alreadyInCommit = false;
/*      */   }
/*      */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\dsc\impl\DiscountModel.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */