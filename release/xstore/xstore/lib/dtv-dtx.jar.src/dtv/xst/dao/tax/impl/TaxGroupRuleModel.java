/*      */ package dtv.xst.dao.tax.impl;
/*      */ import dtv.data2.IPersistenceDefaults;
/*      */ import dtv.data2.access.IDataAccessObject;
/*      */ import dtv.data2.access.IDataModel;
/*      */ import dtv.data2.access.IDataProperty;
/*      */ import dtv.data2.access.ModelEventor;
/*      */ import dtv.data2.access.impl.IDataModelImpl;
/*      */ import dtv.data2.access.impl.Relationship;
/*      */ import dtv.event.EventDescriptor;
/*      */ import dtv.event.EventManager;
/*      */ import dtv.event.Eventor;
/*      */ import dtv.event.IEventAware;
/*      */ import dtv.event.IEventSource;
/*      */ import dtv.util.HistoricalList;
/*      */ import dtv.util.StringUtils;
/*      */ import dtv.xst.dao.tax.ITaxAuthority;
/*      */ import dtv.xst.dao.tax.ITaxGroupRule;
/*      */ import dtv.xst.dao.tax.ITaxGroupRuleProperty;
/*      */ import dtv.xst.dao.tax.ITaxRateRule;
/*      */ import dtv.xst.dao.tax.TaxGroupRulePropertyId;
/*      */ import java.io.ObjectInputStream;
/*      */ import java.util.Date;
/*      */ import java.util.Iterator;
/*      */ import java.util.List;
/*      */ 
/*      */ public class TaxGroupRuleModel extends AbstractDataModelWithPropertyImpl<ITaxGroupRuleProperty> implements ITaxGroupRule {
/*      */   private static final long serialVersionUID = -1838428464L;
/*      */   private transient boolean _alreadyInStart = false;
/*      */   private transient boolean _alreadyInCommit = false;
/*      */   private IDataModel _myExtension;
/*      */   private ITaxAuthority _taxAuthority;
/*      */   
/*      */   public String toString() {
/*   34 */     return super.toString() + " Id: " + getObjectId();
/*      */   }
/*      */   private transient ITaxAuthority _taxAuthoritySavepoint; private HistoricalList<ITaxRateRule> _taxRateRules; private transient HistoricalList<ITaxRateRule> _taxRateRulesSavepoint; private HistoricalList<ITaxGroupRuleProperty> _properties; private transient HistoricalList<ITaxGroupRuleProperty> _propertiesSavepoint;
/*      */   
/*      */   public void initDAO() {
/*   39 */     setDAO((IDataAccessObject)new TaxGroupRuleDAO());
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private TaxGroupRuleDAO getDAO_() {
/*   47 */     return (TaxGroupRuleDAO)this._daoImpl;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public long getOrganizationId() {
/*   55 */     if (getDAO_().getOrganizationId() != null) {
/*   56 */       return getDAO_().getOrganizationId().longValue();
/*      */     }
/*      */     
/*   59 */     return 0L;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setOrganizationId(long argOrganizationId) {
/*   68 */     if (setOrganizationId_noev(argOrganizationId) && 
/*   69 */       this._events != null && 
/*   70 */       postEventsForChanges()) {
/*   71 */       this._events.post(ITaxGroupRule.SET_ORGANIZATIONID, Long.valueOf(argOrganizationId));
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean setOrganizationId_noev(long argOrganizationId) {
/*   78 */     boolean ev_postable = false;
/*      */     
/*   80 */     if ((getDAO_().getOrganizationId() == null && Long.valueOf(argOrganizationId) != null) || (
/*   81 */       getDAO_().getOrganizationId() != null && !getDAO_().getOrganizationId().equals(Long.valueOf(argOrganizationId)))) {
/*   82 */       getDAO_().setOrganizationId(Long.valueOf(argOrganizationId));
/*   83 */       ev_postable = true;
/*   84 */       if (this._taxRateRules != null) {
/*      */         
/*   86 */         Iterator<TaxRateRuleModel> it = this._taxRateRules.iterator();
/*   87 */         while (it.hasNext())
/*      */         {
/*   89 */           ((TaxRateRuleModel)it.next()).setOrganizationId_noev(argOrganizationId);
/*      */         }
/*      */       } 
/*   92 */       if (this._properties != null) {
/*      */         
/*   94 */         Iterator<TaxGroupRulePropertyModel> it = this._properties.iterator();
/*   95 */         while (it.hasNext())
/*      */         {
/*   97 */           ((TaxGroupRulePropertyModel)it.next()).setOrganizationId_noev(argOrganizationId);
/*      */         }
/*      */       } 
/*      */     } 
/*      */     
/*  102 */     return ev_postable;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public String getTaxGroupId() {
/*  110 */     return getDAO_().getTaxGroupId();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setTaxGroupId(String argTaxGroupId) {
/*  118 */     if (setTaxGroupId_noev(argTaxGroupId) && 
/*  119 */       this._events != null && 
/*  120 */       postEventsForChanges()) {
/*  121 */       this._events.post(ITaxGroupRule.SET_TAXGROUPID, argTaxGroupId);
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean setTaxGroupId_noev(String argTaxGroupId) {
/*  128 */     boolean ev_postable = false;
/*      */     
/*  130 */     if ((getDAO_().getTaxGroupId() == null && argTaxGroupId != null) || (
/*  131 */       getDAO_().getTaxGroupId() != null && !getDAO_().getTaxGroupId().equals(argTaxGroupId))) {
/*  132 */       getDAO_().setTaxGroupId(argTaxGroupId);
/*  133 */       ev_postable = true;
/*  134 */       if (this._taxRateRules != null) {
/*      */         
/*  136 */         Iterator<TaxRateRuleModel> it = this._taxRateRules.iterator();
/*  137 */         while (it.hasNext())
/*      */         {
/*  139 */           ((TaxRateRuleModel)it.next()).setTaxGroupId_noev(argTaxGroupId);
/*      */         }
/*      */       } 
/*  142 */       if (this._properties != null) {
/*      */         
/*  144 */         Iterator<TaxGroupRulePropertyModel> it = this._properties.iterator();
/*  145 */         while (it.hasNext())
/*      */         {
/*  147 */           ((TaxGroupRulePropertyModel)it.next()).setTaxGroupId_noev(argTaxGroupId);
/*      */         }
/*      */       } 
/*      */     } 
/*      */     
/*  152 */     return ev_postable;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public String getTaxLocationId() {
/*  160 */     return getDAO_().getTaxLocationId();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setTaxLocationId(String argTaxLocationId) {
/*  168 */     if (setTaxLocationId_noev(argTaxLocationId) && 
/*  169 */       this._events != null && 
/*  170 */       postEventsForChanges()) {
/*  171 */       this._events.post(ITaxGroupRule.SET_TAXLOCATIONID, argTaxLocationId);
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean setTaxLocationId_noev(String argTaxLocationId) {
/*  178 */     boolean ev_postable = false;
/*      */     
/*  180 */     if ((getDAO_().getTaxLocationId() == null && argTaxLocationId != null) || (
/*  181 */       getDAO_().getTaxLocationId() != null && !getDAO_().getTaxLocationId().equals(argTaxLocationId))) {
/*  182 */       getDAO_().setTaxLocationId(argTaxLocationId);
/*  183 */       ev_postable = true;
/*  184 */       if (this._taxRateRules != null) {
/*      */         
/*  186 */         Iterator<TaxRateRuleModel> it = this._taxRateRules.iterator();
/*  187 */         while (it.hasNext())
/*      */         {
/*  189 */           ((TaxRateRuleModel)it.next()).setTaxLocationId_noev(argTaxLocationId);
/*      */         }
/*      */       } 
/*  192 */       if (this._properties != null) {
/*      */         
/*  194 */         Iterator<TaxGroupRulePropertyModel> it = this._properties.iterator();
/*  195 */         while (it.hasNext())
/*      */         {
/*  197 */           ((TaxGroupRulePropertyModel)it.next()).setTaxLocationId_noev(argTaxLocationId);
/*      */         }
/*      */       } 
/*      */     } 
/*      */     
/*  202 */     return ev_postable;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public int getTaxRuleSequence() {
/*  210 */     if (getDAO_().getTaxRuleSequence() != null) {
/*  211 */       return getDAO_().getTaxRuleSequence().intValue();
/*      */     }
/*      */     
/*  214 */     return 0;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setTaxRuleSequence(int argTaxRuleSequence) {
/*  223 */     if (setTaxRuleSequence_noev(argTaxRuleSequence) && 
/*  224 */       this._events != null && 
/*  225 */       postEventsForChanges()) {
/*  226 */       this._events.post(ITaxGroupRule.SET_TAXRULESEQUENCE, Integer.valueOf(argTaxRuleSequence));
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean setTaxRuleSequence_noev(int argTaxRuleSequence) {
/*  233 */     boolean ev_postable = false;
/*      */     
/*  235 */     if ((getDAO_().getTaxRuleSequence() == null && Integer.valueOf(argTaxRuleSequence) != null) || (
/*  236 */       getDAO_().getTaxRuleSequence() != null && !getDAO_().getTaxRuleSequence().equals(Integer.valueOf(argTaxRuleSequence)))) {
/*  237 */       getDAO_().setTaxRuleSequence(Integer.valueOf(argTaxRuleSequence));
/*  238 */       ev_postable = true;
/*  239 */       if (this._taxRateRules != null) {
/*      */         
/*  241 */         Iterator<TaxRateRuleModel> it = this._taxRateRules.iterator();
/*  242 */         while (it.hasNext())
/*      */         {
/*  244 */           ((TaxRateRuleModel)it.next()).setTaxRuleSequence_noev(argTaxRuleSequence);
/*      */         }
/*      */       } 
/*  247 */       if (this._properties != null) {
/*      */         
/*  249 */         Iterator<TaxGroupRulePropertyModel> it = this._properties.iterator();
/*  250 */         while (it.hasNext())
/*      */         {
/*  252 */           ((TaxGroupRulePropertyModel)it.next()).setTaxRuleSequence_noev(argTaxRuleSequence);
/*      */         }
/*      */       } 
/*      */     } 
/*      */     
/*  257 */     return ev_postable;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public Date getCreateDate() {
/*  265 */     return getDAO_().getCreateDate();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setCreateDate(Date argCreateDate) {
/*  273 */     if (setCreateDate_noev(argCreateDate) && 
/*  274 */       this._events != null && 
/*  275 */       postEventsForChanges()) {
/*  276 */       this._events.post(ITaxGroupRule.SET_CREATEDATE, argCreateDate);
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean setCreateDate_noev(Date argCreateDate) {
/*  283 */     boolean ev_postable = false;
/*      */     
/*  285 */     if ((getDAO_().getCreateDate() == null && argCreateDate != null) || (
/*  286 */       getDAO_().getCreateDate() != null && !getDAO_().getCreateDate().equals(argCreateDate))) {
/*  287 */       getDAO_().setCreateDate(argCreateDate);
/*  288 */       ev_postable = true;
/*      */     } 
/*      */     
/*  291 */     return ev_postable;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public String getCreateUserId() {
/*  299 */     return getDAO_().getCreateUserId();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setCreateUserId(String argCreateUserId) {
/*  307 */     if (setCreateUserId_noev(argCreateUserId) && 
/*  308 */       this._events != null && 
/*  309 */       postEventsForChanges()) {
/*  310 */       this._events.post(ITaxGroupRule.SET_CREATEUSERID, argCreateUserId);
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean setCreateUserId_noev(String argCreateUserId) {
/*  317 */     boolean ev_postable = false;
/*      */     
/*  319 */     if ((getDAO_().getCreateUserId() == null && argCreateUserId != null) || (
/*  320 */       getDAO_().getCreateUserId() != null && !getDAO_().getCreateUserId().equals(argCreateUserId))) {
/*  321 */       getDAO_().setCreateUserId(argCreateUserId);
/*  322 */       ev_postable = true;
/*      */     } 
/*      */     
/*  325 */     return ev_postable;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public Date getUpdateDate() {
/*  333 */     return getDAO_().getUpdateDate();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setUpdateDate(Date argUpdateDate) {
/*  341 */     if (setUpdateDate_noev(argUpdateDate) && 
/*  342 */       this._events != null && 
/*  343 */       postEventsForChanges()) {
/*  344 */       this._events.post(ITaxGroupRule.SET_UPDATEDATE, argUpdateDate);
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean setUpdateDate_noev(Date argUpdateDate) {
/*  351 */     boolean ev_postable = false;
/*      */     
/*  353 */     if ((getDAO_().getUpdateDate() == null && argUpdateDate != null) || (
/*  354 */       getDAO_().getUpdateDate() != null && !getDAO_().getUpdateDate().equals(argUpdateDate))) {
/*  355 */       getDAO_().setUpdateDate(argUpdateDate);
/*  356 */       ev_postable = true;
/*      */     } 
/*      */     
/*  359 */     return ev_postable;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public String getUpdateUserId() {
/*  367 */     return getDAO_().getUpdateUserId();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setUpdateUserId(String argUpdateUserId) {
/*  375 */     if (setUpdateUserId_noev(argUpdateUserId) && 
/*  376 */       this._events != null && 
/*  377 */       postEventsForChanges()) {
/*  378 */       this._events.post(ITaxGroupRule.SET_UPDATEUSERID, argUpdateUserId);
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean setUpdateUserId_noev(String argUpdateUserId) {
/*  385 */     boolean ev_postable = false;
/*      */     
/*  387 */     if ((getDAO_().getUpdateUserId() == null && argUpdateUserId != null) || (
/*  388 */       getDAO_().getUpdateUserId() != null && !getDAO_().getUpdateUserId().equals(argUpdateUserId))) {
/*  389 */       getDAO_().setUpdateUserId(argUpdateUserId);
/*  390 */       ev_postable = true;
/*      */     } 
/*      */     
/*  393 */     return ev_postable;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public String getOrgCode() {
/*  401 */     return getDAO_().getOrgCode();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setOrgCode(String argOrgCode) {
/*  409 */     if (setOrgCode_noev(argOrgCode) && 
/*  410 */       this._events != null && 
/*  411 */       postEventsForChanges()) {
/*  412 */       this._events.post(ITaxGroupRule.SET_ORGCODE, argOrgCode);
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean setOrgCode_noev(String argOrgCode) {
/*  419 */     boolean ev_postable = false;
/*      */     
/*  421 */     if ((getDAO_().getOrgCode() == null && argOrgCode != null) || (
/*  422 */       getDAO_().getOrgCode() != null && !getDAO_().getOrgCode().equals(argOrgCode))) {
/*  423 */       getDAO_().setOrgCode(argOrgCode);
/*  424 */       ev_postable = true;
/*      */     } 
/*      */     
/*  427 */     return ev_postable;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public String getOrgValue() {
/*  435 */     return getDAO_().getOrgValue();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setOrgValue(String argOrgValue) {
/*  443 */     if (setOrgValue_noev(argOrgValue) && 
/*  444 */       this._events != null && 
/*  445 */       postEventsForChanges()) {
/*  446 */       this._events.post(ITaxGroupRule.SET_ORGVALUE, argOrgValue);
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean setOrgValue_noev(String argOrgValue) {
/*  453 */     boolean ev_postable = false;
/*      */     
/*  455 */     if ((getDAO_().getOrgValue() == null && argOrgValue != null) || (
/*  456 */       getDAO_().getOrgValue() != null && !getDAO_().getOrgValue().equals(argOrgValue))) {
/*  457 */       getDAO_().setOrgValue(argOrgValue);
/*  458 */       ev_postable = true;
/*      */     } 
/*      */     
/*  461 */     return ev_postable;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean getCompound() {
/*  469 */     if (getDAO_().getCompound() != null) {
/*  470 */       return getDAO_().getCompound().booleanValue();
/*      */     }
/*      */     
/*  473 */     return false;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setCompound(boolean argCompound) {
/*  482 */     if (setCompound_noev(argCompound) && 
/*  483 */       this._events != null && 
/*  484 */       postEventsForChanges()) {
/*  485 */       this._events.post(ITaxGroupRule.SET_COMPOUND, Boolean.valueOf(argCompound));
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean setCompound_noev(boolean argCompound) {
/*  492 */     boolean ev_postable = false;
/*      */     
/*  494 */     if ((getDAO_().getCompound() == null && Boolean.valueOf(argCompound) != null) || (
/*  495 */       getDAO_().getCompound() != null && !getDAO_().getCompound().equals(Boolean.valueOf(argCompound)))) {
/*  496 */       getDAO_().setCompound(Boolean.valueOf(argCompound));
/*  497 */       ev_postable = true;
/*      */     } 
/*      */     
/*  500 */     return ev_postable;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public int getCompoundSequence() {
/*  508 */     if (getDAO_().getCompoundSequence() != null) {
/*  509 */       return getDAO_().getCompoundSequence().intValue();
/*      */     }
/*      */     
/*  512 */     return 0;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setCompoundSequence(int argCompoundSequence) {
/*  521 */     if (setCompoundSequence_noev(argCompoundSequence) && 
/*  522 */       this._events != null && 
/*  523 */       postEventsForChanges()) {
/*  524 */       this._events.post(ITaxGroupRule.SET_COMPOUNDSEQUENCE, Integer.valueOf(argCompoundSequence));
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean setCompoundSequence_noev(int argCompoundSequence) {
/*  531 */     boolean ev_postable = false;
/*      */     
/*  533 */     if ((getDAO_().getCompoundSequence() == null && Integer.valueOf(argCompoundSequence) != null) || (
/*  534 */       getDAO_().getCompoundSequence() != null && !getDAO_().getCompoundSequence().equals(Integer.valueOf(argCompoundSequence)))) {
/*  535 */       getDAO_().setCompoundSequence(Integer.valueOf(argCompoundSequence));
/*  536 */       ev_postable = true;
/*      */     } 
/*      */     
/*  539 */     return ev_postable;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   protected String getDescriptionImpl() {
/*  547 */     return getDAO_().getDescription();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setDescription(String argDescription) {
/*  555 */     if (setDescription_noev(argDescription) && 
/*  556 */       this._events != null && 
/*  557 */       postEventsForChanges()) {
/*  558 */       this._events.post(ITaxGroupRule.SET_DESCRIPTION, argDescription);
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean setDescription_noev(String argDescription) {
/*  565 */     boolean ev_postable = false;
/*      */     
/*  567 */     if ((getDAO_().getDescription() == null && argDescription != null) || (
/*  568 */       getDAO_().getDescription() != null && !getDAO_().getDescription().equals(argDescription))) {
/*  569 */       getDAO_().setDescription(argDescription);
/*  570 */       ev_postable = true;
/*      */     } 
/*      */     
/*  573 */     return ev_postable;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public String getName() {
/*  581 */     return getDAO_().getName();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setName(String argName) {
/*  589 */     if (setName_noev(argName) && 
/*  590 */       this._events != null && 
/*  591 */       postEventsForChanges()) {
/*  592 */       this._events.post(ITaxGroupRule.SET_NAME, argName);
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean setName_noev(String argName) {
/*  599 */     boolean ev_postable = false;
/*      */     
/*  601 */     if ((getDAO_().getName() == null && argName != null) || (
/*  602 */       getDAO_().getName() != null && !getDAO_().getName().equals(argName))) {
/*  603 */       getDAO_().setName(argName);
/*  604 */       ev_postable = true;
/*      */     } 
/*      */     
/*  607 */     return ev_postable;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public String getTaxTypeCode() {
/*  615 */     return getDAO_().getTaxTypeCode();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setTaxTypeCode(String argTaxTypeCode) {
/*  623 */     if (setTaxTypeCode_noev(argTaxTypeCode) && 
/*  624 */       this._events != null && 
/*  625 */       postEventsForChanges()) {
/*  626 */       this._events.post(ITaxGroupRule.SET_TAXTYPECODE, argTaxTypeCode);
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean setTaxTypeCode_noev(String argTaxTypeCode) {
/*  633 */     boolean ev_postable = false;
/*      */     
/*  635 */     if ((getDAO_().getTaxTypeCode() == null && argTaxTypeCode != null) || (
/*  636 */       getDAO_().getTaxTypeCode() != null && !getDAO_().getTaxTypeCode().equals(argTaxTypeCode))) {
/*  637 */       getDAO_().setTaxTypeCode(argTaxTypeCode);
/*  638 */       ev_postable = true;
/*      */     } 
/*      */     
/*  641 */     return ev_postable;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean getTaxedAtTransLevel() {
/*  649 */     if (getDAO_().getTaxedAtTransLevel() != null) {
/*  650 */       return getDAO_().getTaxedAtTransLevel().booleanValue();
/*      */     }
/*      */     
/*  653 */     return false;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setTaxedAtTransLevel(boolean argTaxedAtTransLevel) {
/*  662 */     if (setTaxedAtTransLevel_noev(argTaxedAtTransLevel) && 
/*  663 */       this._events != null && 
/*  664 */       postEventsForChanges()) {
/*  665 */       this._events.post(ITaxGroupRule.SET_TAXEDATTRANSLEVEL, Boolean.valueOf(argTaxedAtTransLevel));
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean setTaxedAtTransLevel_noev(boolean argTaxedAtTransLevel) {
/*  672 */     boolean ev_postable = false;
/*      */     
/*  674 */     if ((getDAO_().getTaxedAtTransLevel() == null && Boolean.valueOf(argTaxedAtTransLevel) != null) || (
/*  675 */       getDAO_().getTaxedAtTransLevel() != null && !getDAO_().getTaxedAtTransLevel().equals(Boolean.valueOf(argTaxedAtTransLevel)))) {
/*  676 */       getDAO_().setTaxedAtTransLevel(Boolean.valueOf(argTaxedAtTransLevel));
/*  677 */       ev_postable = true;
/*      */     } 
/*      */     
/*  680 */     return ev_postable;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public String getTaxAuthorityId() {
/*  688 */     return getDAO_().getTaxAuthorityId();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setTaxAuthorityId(String argTaxAuthorityId) {
/*  696 */     if (setTaxAuthorityId_noev(argTaxAuthorityId) && 
/*  697 */       this._events != null && 
/*  698 */       postEventsForChanges()) {
/*  699 */       this._events.post(ITaxGroupRule.SET_TAXAUTHORITYID, argTaxAuthorityId);
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean setTaxAuthorityId_noev(String argTaxAuthorityId) {
/*  706 */     boolean ev_postable = false;
/*      */     
/*  708 */     if ((getDAO_().getTaxAuthorityId() == null && argTaxAuthorityId != null) || (
/*  709 */       getDAO_().getTaxAuthorityId() != null && !getDAO_().getTaxAuthorityId().equals(argTaxAuthorityId))) {
/*  710 */       getDAO_().setTaxAuthorityId(argTaxAuthorityId);
/*  711 */       ev_postable = true;
/*      */     } 
/*      */     
/*  714 */     return ev_postable;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public String getExternalSystem() {
/*  722 */     return getDAO_().getExternalSystem();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setExternalSystem(String argExternalSystem) {
/*  730 */     if (setExternalSystem_noev(argExternalSystem) && 
/*  731 */       this._events != null && 
/*  732 */       postEventsForChanges()) {
/*  733 */       this._events.post(ITaxGroupRule.SET_EXTERNALSYSTEM, argExternalSystem);
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean setExternalSystem_noev(String argExternalSystem) {
/*  740 */     boolean ev_postable = false;
/*      */     
/*  742 */     if ((getDAO_().getExternalSystem() == null && argExternalSystem != null) || (
/*  743 */       getDAO_().getExternalSystem() != null && !getDAO_().getExternalSystem().equals(argExternalSystem))) {
/*  744 */       getDAO_().setExternalSystem(argExternalSystem);
/*  745 */       ev_postable = true;
/*      */     } 
/*      */     
/*  748 */     return ev_postable;
/*      */   }
/*      */   
/*      */   protected ITaxGroupRuleProperty newProperty(String argPropertyName) {
/*  752 */     TaxGroupRulePropertyId id = new TaxGroupRulePropertyId();
/*      */     
/*  754 */     id.setTaxGroupId(getTaxGroupId());
/*  755 */     id.setTaxLocationId(getTaxLocationId());
/*  756 */     id.setTaxRuleSequence(Integer.valueOf(getTaxRuleSequence()));
/*  757 */     id.setPropertyCode(argPropertyName);
/*      */     
/*  759 */     ITaxGroupRuleProperty prop = (ITaxGroupRuleProperty)DataFactory.getInstance().createNewObject((IObjectId)id, ITaxGroupRuleProperty.class);
/*  760 */     return prop;
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
/*      */   @Relationship(name = "TaxAuthority")
/*      */   public ITaxAuthority getTaxAuthority() {
/*  775 */     return this._taxAuthority;
/*      */   }
/*      */ 
/*      */   
/*      */   public void setTaxAuthority(ITaxAuthority argTaxAuthority) {
/*  780 */     if (argTaxAuthority == null) {
/*      */       
/*  782 */       getDAO_().setTaxAuthorityId(null);
/*  783 */       if (this._taxAuthority != null)
/*      */       {
/*  785 */         if (postEventsForChanges()) {
/*  786 */           this._eventManager.deregisterEventHandler((IEventAware)this._eventCascade, (IEventSource)new EventDescriptor(this._taxAuthority));
/*      */         }
/*      */       }
/*      */     } else {
/*      */       
/*  791 */       getDAO_().setTaxAuthorityId(argTaxAuthority.getTaxAuthorityId());
/*      */       
/*  793 */       if (postEventsForChanges()) {
/*  794 */         this._eventManager.registerEventHandler((IEventAware)this._eventCascade, (IEventSource)new EventDescriptor(argTaxAuthority));
/*      */       }
/*      */     } 
/*      */     
/*  798 */     this._taxAuthority = argTaxAuthority;
/*  799 */     if (postEventsForChanges()) {
/*  800 */       this._events.post(ITaxGroupRule.SET_TAXAUTHORITY, argTaxAuthority);
/*      */     }
/*      */   }
/*      */   
/*      */   @Relationship(name = "TaxRateRules")
/*      */   public List<ITaxRateRule> getTaxRateRules() {
/*  806 */     if (this._taxRateRules == null) {
/*  807 */       this._taxRateRules = new HistoricalList(null);
/*      */     }
/*  809 */     return (List<ITaxRateRule>)this._taxRateRules;
/*      */   }
/*      */   
/*      */   public void setTaxRateRules(List<ITaxRateRule> argTaxRateRules) {
/*  813 */     if (this._taxRateRules == null) {
/*  814 */       this._taxRateRules = new HistoricalList(argTaxRateRules);
/*      */     } else {
/*  816 */       this._taxRateRules.setCurrentList(argTaxRateRules);
/*      */     } 
/*      */     
/*  819 */     for (ITaxRateRule child : this._taxRateRules) {
/*  820 */       child.setParentRule(this);
/*      */     }
/*      */     
/*  823 */     for (ITaxRateRule child : this._taxRateRules) {
/*  824 */       TaxRateRuleModel model = (TaxRateRuleModel)child;
/*  825 */       model.setOrganizationId_noev(getOrganizationId());
/*  826 */       model.setTaxGroupId_noev(getTaxGroupId());
/*  827 */       model.setTaxLocationId_noev(getTaxLocationId());
/*  828 */       model.setTaxRuleSequence_noev(getTaxRuleSequence());
/*  829 */       if (child instanceof IDataModelImpl) {
/*  830 */         IDataAccessObject childDao = ((IDataModelImpl)child).getDAO();
/*  831 */         if (StringUtils.isEmpty(childDao.getOriginDataSource()) && 
/*  832 */           !StringUtils.isEmpty(getDAO().getOriginDataSource())) {
/*  833 */           childDao.setOriginDataSource(getDAO().getOriginDataSource());
/*      */         }
/*      */       } 
/*  836 */       if (postEventsForChanges()) {
/*  837 */         this._eventManager.registerEventHandler((IEventAware)this._eventCascade, (IEventSource)child);
/*      */       }
/*      */     } 
/*      */   }
/*      */ 
/*      */   
/*      */   public void addTaxRateRule(ITaxRateRule argTaxRateRule) {
/*  844 */     argTaxRateRule.setParentRule(this);
/*  845 */     if (this._taxRateRules == null) {
/*  846 */       this._taxRateRules = new HistoricalList(null);
/*      */     }
/*  848 */     argTaxRateRule.setOrganizationId(getOrganizationId());
/*  849 */     argTaxRateRule.setTaxGroupId(getTaxGroupId());
/*  850 */     argTaxRateRule.setTaxLocationId(getTaxLocationId());
/*  851 */     argTaxRateRule.setTaxRuleSequence(getTaxRuleSequence());
/*  852 */     if (argTaxRateRule instanceof IDataModelImpl) {
/*  853 */       IDataAccessObject childDao = ((IDataModelImpl)argTaxRateRule).getDAO();
/*  854 */       if (StringUtils.isEmpty(childDao.getOriginDataSource()) && 
/*  855 */         !StringUtils.isEmpty(getDAO().getOriginDataSource())) {
/*  856 */         childDao.setOriginDataSource(getDAO().getOriginDataSource());
/*      */       }
/*      */     } 
/*      */ 
/*      */     
/*  861 */     if (postEventsForChanges()) {
/*  862 */       this._eventManager.registerEventHandler((IEventAware)this._eventCascade, (IEventSource)new EventDescriptor(argTaxRateRule));
/*      */     }
/*      */     
/*  865 */     this._taxRateRules.add(argTaxRateRule);
/*  866 */     if (postEventsForChanges()) {
/*  867 */       this._events.post(ITaxGroupRule.ADD_TAXRATERULES, argTaxRateRule);
/*      */     }
/*      */   }
/*      */   
/*      */   public void removeTaxRateRule(ITaxRateRule argTaxRateRule) {
/*  872 */     if (this._taxRateRules != null) {
/*      */       
/*  874 */       if (postEventsForChanges()) {
/*  875 */         this._eventManager.deregisterEventHandler((IEventAware)this._eventCascade, (IEventSource)new EventDescriptor(argTaxRateRule));
/*      */       }
/*  877 */       this._taxRateRules.remove(argTaxRateRule);
/*      */       
/*  879 */       argTaxRateRule.setParentRule(null);
/*  880 */       if (postEventsForChanges()) {
/*  881 */         this._events.post(ITaxGroupRule.REMOVE_TAXRATERULES, argTaxRateRule);
/*      */       }
/*      */     } 
/*      */   }
/*      */   
/*      */   @Relationship(name = "Properties")
/*      */   public List<ITaxGroupRuleProperty> getProperties() {
/*  888 */     if (this._properties == null) {
/*  889 */       this._properties = new HistoricalList(null);
/*      */     }
/*  891 */     return (List<ITaxGroupRuleProperty>)this._properties;
/*      */   }
/*      */   
/*      */   public void setProperties(List<ITaxGroupRuleProperty> argProperties) {
/*  895 */     if (this._properties == null) {
/*  896 */       this._properties = new HistoricalList(argProperties);
/*      */     } else {
/*  898 */       this._properties.setCurrentList(argProperties);
/*      */     } 
/*      */     
/*  901 */     for (ITaxGroupRuleProperty child : this._properties) {
/*  902 */       TaxGroupRulePropertyModel model = (TaxGroupRulePropertyModel)child;
/*  903 */       model.setOrganizationId_noev(getOrganizationId());
/*  904 */       model.setTaxGroupId_noev(getTaxGroupId());
/*  905 */       model.setTaxLocationId_noev(getTaxLocationId());
/*  906 */       model.setTaxRuleSequence_noev(getTaxRuleSequence());
/*  907 */       if (child instanceof IDataModelImpl) {
/*  908 */         IDataAccessObject childDao = ((IDataModelImpl)child).getDAO();
/*  909 */         if (StringUtils.isEmpty(childDao.getOriginDataSource()) && 
/*  910 */           !StringUtils.isEmpty(getDAO().getOriginDataSource())) {
/*  911 */           childDao.setOriginDataSource(getDAO().getOriginDataSource());
/*      */         }
/*      */       } 
/*  914 */       if (postEventsForChanges()) {
/*  915 */         this._eventManager.registerEventHandler((IEventAware)this._eventCascade, (IEventSource)child);
/*      */       }
/*      */     } 
/*      */   }
/*      */   
/*      */   public void addTaxGroupRuleProperty(ITaxGroupRuleProperty argTaxGroupRuleProperty) {
/*  921 */     if (this._properties == null) {
/*  922 */       this._properties = new HistoricalList(null);
/*      */     }
/*  924 */     argTaxGroupRuleProperty.setOrganizationId(getOrganizationId());
/*  925 */     argTaxGroupRuleProperty.setTaxGroupId(getTaxGroupId());
/*  926 */     argTaxGroupRuleProperty.setTaxLocationId(getTaxLocationId());
/*  927 */     argTaxGroupRuleProperty.setTaxRuleSequence(getTaxRuleSequence());
/*  928 */     if (argTaxGroupRuleProperty instanceof IDataModelImpl) {
/*  929 */       IDataAccessObject childDao = ((IDataModelImpl)argTaxGroupRuleProperty).getDAO();
/*  930 */       if (StringUtils.isEmpty(childDao.getOriginDataSource()) && 
/*  931 */         !StringUtils.isEmpty(getDAO().getOriginDataSource())) {
/*  932 */         childDao.setOriginDataSource(getDAO().getOriginDataSource());
/*      */       }
/*      */     } 
/*      */ 
/*      */     
/*  937 */     if (postEventsForChanges()) {
/*  938 */       this._eventManager.registerEventHandler((IEventAware)this._eventCascade, (IEventSource)new EventDescriptor(argTaxGroupRuleProperty));
/*      */     }
/*      */     
/*  941 */     this._properties.add(argTaxGroupRuleProperty);
/*  942 */     if (postEventsForChanges()) {
/*  943 */       this._events.post(ITaxGroupRule.ADD_PROPERTIES, argTaxGroupRuleProperty);
/*      */     }
/*      */   }
/*      */   
/*      */   public void removeTaxGroupRuleProperty(ITaxGroupRuleProperty argTaxGroupRuleProperty) {
/*  948 */     if (this._properties != null) {
/*      */       
/*  950 */       if (postEventsForChanges()) {
/*  951 */         this._eventManager.deregisterEventHandler((IEventAware)this._eventCascade, (IEventSource)new EventDescriptor(argTaxGroupRuleProperty));
/*      */       }
/*  953 */       this._properties.remove(argTaxGroupRuleProperty);
/*  954 */       if (postEventsForChanges()) {
/*  955 */         this._events.post(ITaxGroupRule.REMOVE_PROPERTIES, argTaxGroupRuleProperty);
/*      */       }
/*      */     } 
/*      */   }
/*      */ 
/*      */   
/*      */   public Object getValue(String argFieldId) {
/*  962 */     if ("TaxAuthority".equals(argFieldId)) {
/*  963 */       return getTaxAuthority();
/*      */     }
/*  965 */     if ("TaxRateRules".equals(argFieldId)) {
/*  966 */       return getTaxRateRules();
/*      */     }
/*  968 */     if ("Properties".equals(argFieldId)) {
/*  969 */       return getProperties();
/*      */     }
/*  971 */     if ("TaxGroupRuleExtension".equals(argFieldId)) {
/*  972 */       return this._myExtension;
/*      */     }
/*      */     
/*  975 */     return super.getValue(argFieldId);
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public void setValue(String argFieldId, Object argValue) {
/*  981 */     if ("TaxAuthority".equals(argFieldId)) {
/*  982 */       setTaxAuthority((ITaxAuthority)argValue);
/*      */     }
/*  984 */     else if ("TaxRateRules".equals(argFieldId)) {
/*  985 */       setTaxRateRules(changeToList(argValue, ITaxRateRule.class));
/*      */     }
/*  987 */     else if ("Properties".equals(argFieldId)) {
/*  988 */       setProperties(changeToList(argValue, ITaxGroupRuleProperty.class));
/*      */     }
/*  990 */     else if ("TaxGroupRuleExtension".equals(argFieldId)) {
/*  991 */       this._myExtension = (IDataModel)argValue;
/*      */     } else {
/*      */       
/*  994 */       super.setValue(argFieldId, argValue);
/*      */     } 
/*      */   }
/*      */ 
/*      */   
/*      */   public void setDependencies(IPersistenceDefaults argPD, EventManager argEM) {
/* 1000 */     this._persistenceDefaults = argPD;
/* 1001 */     this._daoImpl.setPersistenceDefaults(argPD);
/* 1002 */     this._eventManager = argEM;
/* 1003 */     this._events = (Eventor)new ModelEventor((IDataModel)this, argEM);
/* 1004 */     this._eventCascade = (EventHandler)new CascadingHandler(this);
/* 1005 */     if (this._taxAuthority != null) {
/* 1006 */       ((IDataModelImpl)this._taxAuthority).setDependencies(argPD, argEM);
/*      */     }
/* 1008 */     if (this._taxRateRules != null) {
/* 1009 */       for (ITaxRateRule relationship : this._taxRateRules) {
/* 1010 */         ((IDataModelImpl)relationship).setDependencies(argPD, argEM);
/*      */       }
/*      */     }
/* 1013 */     if (this._properties != null) {
/* 1014 */       for (ITaxGroupRuleProperty relationship : this._properties) {
/* 1015 */         ((IDataModelImpl)relationship).setDependencies(argPD, argEM);
/*      */       }
/*      */     }
/*      */   }
/*      */   
/*      */   public IDataModel getTaxGroupRuleExt() {
/* 1021 */     return this._myExtension;
/*      */   }
/*      */   
/*      */   public void setTaxGroupRuleExt(IDataModel argExt) {
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
/* 1039 */     this._taxAuthoritySavepoint = this._taxAuthority;
/* 1040 */     if (this._taxAuthority != null) {
/* 1041 */       this._taxAuthority.startTransaction();
/*      */     }
/*      */     
/* 1044 */     this._taxRateRulesSavepoint = this._taxRateRules;
/* 1045 */     if (this._taxRateRules != null) {
/* 1046 */       this._taxRateRulesSavepoint = new HistoricalList((List)this._taxRateRules);
/* 1047 */       Iterator<IDataModel> it = this._taxRateRules.iterator();
/* 1048 */       while (it.hasNext()) {
/* 1049 */         ((IDataModel)it.next()).startTransaction();
/*      */       }
/*      */     } 
/*      */     
/* 1053 */     this._propertiesSavepoint = this._properties;
/* 1054 */     if (this._properties != null) {
/* 1055 */       this._propertiesSavepoint = new HistoricalList((List)this._properties);
/* 1056 */       Iterator<IDataModel> it = this._properties.iterator();
/* 1057 */       while (it.hasNext()) {
/* 1058 */         ((IDataModel)it.next()).startTransaction();
/*      */       }
/*      */     } 
/*      */ 
/*      */     
/* 1063 */     this._alreadyInStart = false;
/*      */   }
/*      */ 
/*      */   
/*      */   public void rollbackChanges() {
/* 1068 */     if (isAlreadyRolledBack()) {
/*      */       return;
/*      */     }
/* 1071 */     super.rollbackChanges();
/*      */     
/* 1073 */     this._taxAuthority = this._taxAuthoritySavepoint;
/* 1074 */     this._taxAuthoritySavepoint = null;
/* 1075 */     if (this._taxAuthority != null) {
/* 1076 */       this._taxAuthority.rollbackChanges();
/*      */     }
/*      */     
/* 1079 */     this._taxRateRules = this._taxRateRulesSavepoint;
/* 1080 */     this._taxRateRulesSavepoint = null;
/* 1081 */     if (this._taxRateRules != null) {
/* 1082 */       Iterator<IDataModel> it = this._taxRateRules.iterator();
/* 1083 */       while (it.hasNext()) {
/* 1084 */         ((IDataModel)it.next()).rollbackChanges();
/*      */       }
/*      */     } 
/*      */     
/* 1088 */     this._properties = this._propertiesSavepoint;
/* 1089 */     this._propertiesSavepoint = null;
/* 1090 */     if (this._properties != null) {
/* 1091 */       Iterator<IDataModel> it = this._properties.iterator();
/* 1092 */       while (it.hasNext()) {
/* 1093 */         ((IDataModel)it.next()).rollbackChanges();
/*      */       }
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public void commitTransaction() {
/* 1101 */     if (this._alreadyInCommit) {
/*      */       return;
/*      */     }
/* 1104 */     this._alreadyInCommit = true;
/*      */ 
/*      */     
/* 1107 */     super.commitTransaction();
/*      */     
/* 1109 */     this._taxAuthoritySavepoint = this._taxAuthority;
/* 1110 */     if (this._taxAuthority != null) {
/* 1111 */       this._taxAuthority.commitTransaction();
/*      */     }
/*      */     
/* 1114 */     this._taxRateRulesSavepoint = this._taxRateRules;
/* 1115 */     if (this._taxRateRules != null) {
/* 1116 */       Iterator<IDataModel> it = this._taxRateRules.iterator();
/* 1117 */       while (it.hasNext()) {
/* 1118 */         ((IDataModel)it.next()).commitTransaction();
/*      */       }
/* 1120 */       this._taxRateRules = new HistoricalList((List)this._taxRateRules);
/*      */     } 
/*      */     
/* 1123 */     this._propertiesSavepoint = this._properties;
/* 1124 */     if (this._properties != null) {
/* 1125 */       Iterator<IDataModel> it = this._properties.iterator();
/* 1126 */       while (it.hasNext()) {
/* 1127 */         ((IDataModel)it.next()).commitTransaction();
/*      */       }
/* 1129 */       this._properties = new HistoricalList((List)this._properties);
/*      */     } 
/*      */ 
/*      */     
/* 1133 */     this._alreadyInCommit = false;
/*      */   }
/*      */ 
/*      */   
/*      */   private void readObject(ObjectInputStream argStream) throws IOException, ClassNotFoundException {
/* 1138 */     argStream.defaultReadObject();
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
/*      */   public String getDescription() {
/* 1153 */     String description = getDescriptionImpl();
/* 1154 */     return (description == null) ? getName() : description;
/*      */   }
/*      */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\tax\impl\TaxGroupRuleModel.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */