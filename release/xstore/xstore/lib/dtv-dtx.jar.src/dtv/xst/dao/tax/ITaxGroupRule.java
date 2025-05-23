/*    */ package dtv.xst.dao.tax;
/*    */ import dtv.data2.access.IDataAccessObject;
/*    */ import dtv.data2.access.IDataModel;
/*    */ import dtv.event.EventEnum;
/*    */ import java.util.Date;
/*    */ import java.util.List;
/*    */ 
/*    */ public interface ITaxGroupRule extends IDataModel, IHasDataProperty<ITaxGroupRuleProperty> {
/*  9 */   public static final EventEnum SET_ORGANIZATIONID = new EventEnum("set organizationId");
/* 10 */   public static final EventEnum SET_TAXGROUPID = new EventEnum("set taxGroupId");
/* 11 */   public static final EventEnum SET_TAXLOCATIONID = new EventEnum("set taxLocationId");
/* 12 */   public static final EventEnum SET_TAXRULESEQUENCE = new EventEnum("set taxRuleSequence");
/* 13 */   public static final EventEnum SET_CREATEDATE = new EventEnum("set createDate");
/* 14 */   public static final EventEnum SET_CREATEUSERID = new EventEnum("set createUserId");
/* 15 */   public static final EventEnum SET_UPDATEDATE = new EventEnum("set updateDate");
/* 16 */   public static final EventEnum SET_UPDATEUSERID = new EventEnum("set updateUserId");
/* 17 */   public static final EventEnum SET_ORGCODE = new EventEnum("set orgCode");
/* 18 */   public static final EventEnum SET_ORGVALUE = new EventEnum("set orgValue");
/* 19 */   public static final EventEnum SET_COMPOUND = new EventEnum("set compound");
/* 20 */   public static final EventEnum SET_COMPOUNDSEQUENCE = new EventEnum("set compoundSequence");
/* 21 */   public static final EventEnum SET_DESCRIPTION = new EventEnum("set description");
/* 22 */   public static final EventEnum SET_NAME = new EventEnum("set name");
/* 23 */   public static final EventEnum SET_TAXTYPECODE = new EventEnum("set taxTypeCode");
/* 24 */   public static final EventEnum SET_TAXEDATTRANSLEVEL = new EventEnum("set taxedAtTransLevel");
/* 25 */   public static final EventEnum SET_TAXAUTHORITYID = new EventEnum("set taxAuthorityId");
/* 26 */   public static final EventEnum SET_EXTERNALSYSTEM = new EventEnum("set externalSystem");
/* 27 */   public static final EventEnum SET_TAXAUTHORITY = new EventEnum("set TaxAuthority");
/* 28 */   public static final EventEnum ADD_TAXRATERULES = new EventEnum("add TaxRateRules");
/* 29 */   public static final EventEnum REMOVE_TAXRATERULES = new EventEnum("remove TaxRateRules");
/* 30 */   public static final EventEnum SET_TAXRATERULES = new EventEnum("set TaxRateRules");
/* 31 */   public static final EventEnum ADD_PROPERTIES = new EventEnum("add Properties");
/* 32 */   public static final EventEnum REMOVE_PROPERTIES = new EventEnum("remove Properties");
/* 33 */   public static final EventEnum SET_PROPERTIES = new EventEnum("set Properties");
/* 34 */   public static final EventEnum START_TRANSACTION = new EventEnum("start transaction");
/* 35 */   public static final EventEnum ROLLBACK_TRANSACTION = new EventEnum("rollback transaction");
/* 36 */   public static final EventEnum COMMIT_TRANSACTION = new EventEnum("commit transaction");
/*    */   
/*    */   void setDAO(IDataAccessObject paramIDataAccessObject);
/*    */   
/*    */   long getOrganizationId();
/*    */   
/*    */   void setOrganizationId(long paramLong);
/*    */   
/*    */   String getTaxGroupId();
/*    */   
/*    */   void setTaxGroupId(String paramString);
/*    */   
/*    */   String getTaxLocationId();
/*    */   
/*    */   void setTaxLocationId(String paramString);
/*    */   
/*    */   int getTaxRuleSequence();
/*    */   
/*    */   void setTaxRuleSequence(int paramInt);
/*    */   
/*    */   Date getCreateDate();
/*    */   
/*    */   void setCreateDate(Date paramDate);
/*    */   
/*    */   String getCreateUserId();
/*    */   
/*    */   void setCreateUserId(String paramString);
/*    */   
/*    */   Date getUpdateDate();
/*    */   
/*    */   void setUpdateDate(Date paramDate);
/*    */   
/*    */   String getUpdateUserId();
/*    */   
/*    */   void setUpdateUserId(String paramString);
/*    */   
/*    */   String getOrgCode();
/*    */   
/*    */   void setOrgCode(String paramString);
/*    */   
/*    */   String getOrgValue();
/*    */   
/*    */   void setOrgValue(String paramString);
/*    */   
/*    */   boolean getCompound();
/*    */   
/*    */   void setCompound(boolean paramBoolean);
/*    */   
/*    */   int getCompoundSequence();
/*    */   
/*    */   void setCompoundSequence(int paramInt);
/*    */   
/*    */   String getDescription();
/*    */   
/*    */   void setDescription(String paramString);
/*    */   
/*    */   String getName();
/*    */   
/*    */   void setName(String paramString);
/*    */   
/*    */   String getTaxTypeCode();
/*    */   
/*    */   void setTaxTypeCode(String paramString);
/*    */   
/*    */   boolean getTaxedAtTransLevel();
/*    */   
/*    */   void setTaxedAtTransLevel(boolean paramBoolean);
/*    */   
/*    */   String getTaxAuthorityId();
/*    */   
/*    */   void setTaxAuthorityId(String paramString);
/*    */   
/*    */   String getExternalSystem();
/*    */   
/*    */   void setExternalSystem(String paramString);
/*    */   
/*    */   IDataModel getTaxGroupRuleExt();
/*    */   
/*    */   void setTaxGroupRuleExt(IDataModel paramIDataModel);
/*    */   
/*    */   ITaxAuthority getTaxAuthority();
/*    */   
/*    */   void setTaxAuthority(ITaxAuthority paramITaxAuthority);
/*    */   
/*    */   List<ITaxRateRule> getTaxRateRules();
/*    */   
/*    */   void setTaxRateRules(List<ITaxRateRule> paramList);
/*    */   
/*    */   void addTaxRateRule(ITaxRateRule paramITaxRateRule);
/*    */   
/*    */   void removeTaxRateRule(ITaxRateRule paramITaxRateRule);
/*    */   
/*    */   List<ITaxGroupRuleProperty> getProperties();
/*    */   
/*    */   void setProperties(List<ITaxGroupRuleProperty> paramList);
/*    */   
/*    */   void addTaxGroupRuleProperty(ITaxGroupRuleProperty paramITaxGroupRuleProperty);
/*    */   
/*    */   void removeTaxGroupRuleProperty(ITaxGroupRuleProperty paramITaxGroupRuleProperty);
/*    */   
/*    */   void startTransaction();
/*    */   
/*    */   void rollbackChanges();
/*    */   
/*    */   void commitTransaction();
/*    */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\tax\ITaxGroupRule.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */