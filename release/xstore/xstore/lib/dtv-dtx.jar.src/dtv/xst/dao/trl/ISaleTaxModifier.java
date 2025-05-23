/*    */ package dtv.xst.dao.trl;
/*    */ import dtv.data2.access.IDataModel;
/*    */ import dtv.event.EventEnum;
/*    */ import dtv.xst.dao.tax.ITaxGroupRule;
/*    */ import java.math.BigDecimal;
/*    */ import java.util.Date;
/*    */ 
/*    */ public interface ISaleTaxModifier extends IDataModel, ISaleTaxModifierModel, IHasDataProperty<ISaleTaxModifierProperty> {
/*  9 */   public static final EventEnum SET_BUSINESSDATE = new EventEnum("set businessDate");
/* 10 */   public static final EventEnum SET_ORGANIZATIONID = new EventEnum("set organizationId");
/* 11 */   public static final EventEnum SET_RETAILLOCATIONID = new EventEnum("set retailLocationId");
/* 12 */   public static final EventEnum SET_RETAILTRANSACTIONLINEITEMSEQUENCE = new EventEnum("set retailTransactionLineItemSequence");
/* 13 */   public static final EventEnum SET_SALETAXMODIFIERSEQUENCE = new EventEnum("set saleTaxModifierSequence");
/* 14 */   public static final EventEnum SET_TRANSACTIONSEQUENCE = new EventEnum("set transactionSequence");
/* 15 */   public static final EventEnum SET_WORKSTATIONID = new EventEnum("set workstationId");
/* 16 */   public static final EventEnum SET_CREATEDATE = new EventEnum("set createDate");
/* 17 */   public static final EventEnum SET_CREATEUSERID = new EventEnum("set createUserId");
/* 18 */   public static final EventEnum SET_UPDATEDATE = new EventEnum("set updateDate");
/* 19 */   public static final EventEnum SET_UPDATEUSERID = new EventEnum("set updateUserId");
/* 20 */   public static final EventEnum SET_TAXAMOUNT = new EventEnum("set taxAmount");
/* 21 */   public static final EventEnum SET_TAXPERCENTAGE = new EventEnum("set taxPercentage");
/* 22 */   public static final EventEnum SET_RAWTAXAMOUNT = new EventEnum("set rawTaxAmount");
/* 23 */   public static final EventEnum SET_RAWTAXPERCENTAGE = new EventEnum("set rawTaxPercentage");
/* 24 */   public static final EventEnum SET_EXEMPTTAXAMOUNT = new EventEnum("set exemptTaxAmount");
/* 25 */   public static final EventEnum SET_TAXEXEMPTAMOUNT = new EventEnum("set taxExemptAmount");
/* 26 */   public static final EventEnum SET_TAXEXEMPTIONID = new EventEnum("set taxExemptionId");
/* 27 */   public static final EventEnum SET_TAXOVERRIDEAMOUNT = new EventEnum("set taxOverrideAmount");
/* 28 */   public static final EventEnum SET_TAXOVERRIDE = new EventEnum("set taxOverride");
/* 29 */   public static final EventEnum SET_TAXOVERRIDEPERCENTAGE = new EventEnum("set taxOverridePercentage");
/* 30 */   public static final EventEnum SET_TAXOVERRIDEREASONCODE = new EventEnum("set taxOverrideReasonCode");
/* 31 */   public static final EventEnum SET_TAXOVERRIDECOMMENT = new EventEnum("set taxOverrideComment");
/* 32 */   public static final EventEnum SET_TAXABLEAMOUNT = new EventEnum("set taxableAmount");
/* 33 */   public static final EventEnum SET_VOID = new EventEnum("set void");
/* 34 */   public static final EventEnum SET_TAXGROUPID = new EventEnum("set taxGroupId");
/* 35 */   public static final EventEnum SET_TAXLOCATIONID = new EventEnum("set taxLocationId");
/* 36 */   public static final EventEnum SET_TAXRULESEQUENCE = new EventEnum("set taxRuleSequence");
/* 37 */   public static final EventEnum SET_AUTHORITYID = new EventEnum("set authorityId");
/* 38 */   public static final EventEnum SET_AUTHORITYNAME = new EventEnum("set authorityName");
/* 39 */   public static final EventEnum SET_AUTHORITYTYPECODE = new EventEnum("set authorityTypeCode");
/* 40 */   public static final EventEnum SET_TAXOVERRIDEBRACKET = new EventEnum("set taxOverrideBracket");
/* 41 */   public static final EventEnum SET_ORIGTAXABLEAMOUNT = new EventEnum("set origTaxableAmount");
/* 42 */   public static final EventEnum SET_ORIGTAXGROUPID = new EventEnum("set origTaxGroupId");
/* 43 */   public static final EventEnum SET_SALETAXGROUPRULE = new EventEnum("set SaleTaxGroupRule");
/* 44 */   public static final EventEnum ADD_PROPERTIES = new EventEnum("add Properties");
/* 45 */   public static final EventEnum REMOVE_PROPERTIES = new EventEnum("remove Properties");
/* 46 */   public static final EventEnum SET_PROPERTIES = new EventEnum("set Properties");
/* 47 */   public static final EventEnum START_TRANSACTION = new EventEnum("start transaction");
/* 48 */   public static final EventEnum ROLLBACK_TRANSACTION = new EventEnum("rollback transaction");
/* 49 */   public static final EventEnum COMMIT_TRANSACTION = new EventEnum("commit transaction");
/*    */   
/*    */   void setDAO(IDataAccessObject paramIDataAccessObject);
/*    */   
/*    */   Date getBusinessDate();
/*    */   
/*    */   void setBusinessDate(Date paramDate);
/*    */   
/*    */   long getOrganizationId();
/*    */   
/*    */   void setOrganizationId(long paramLong);
/*    */   
/*    */   long getRetailLocationId();
/*    */   
/*    */   void setRetailLocationId(long paramLong);
/*    */   
/*    */   int getRetailTransactionLineItemSequence();
/*    */   
/*    */   void setRetailTransactionLineItemSequence(int paramInt);
/*    */   
/*    */   int getSaleTaxModifierSequence();
/*    */   
/*    */   void setSaleTaxModifierSequence(int paramInt);
/*    */   
/*    */   long getTransactionSequence();
/*    */   
/*    */   void setTransactionSequence(long paramLong);
/*    */   
/*    */   long getWorkstationId();
/*    */   
/*    */   void setWorkstationId(long paramLong);
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
/*    */   BigDecimal getTaxAmount();
/*    */   
/*    */   void setTaxAmount(BigDecimal paramBigDecimal);
/*    */   
/*    */   BigDecimal getTaxPercentage();
/*    */   
/*    */   void setTaxPercentage(BigDecimal paramBigDecimal);
/*    */   
/*    */   BigDecimal getRawTaxAmount();
/*    */   
/*    */   void setRawTaxAmount(BigDecimal paramBigDecimal);
/*    */   
/*    */   BigDecimal getRawTaxPercentage();
/*    */   
/*    */   void setRawTaxPercentage(BigDecimal paramBigDecimal);
/*    */   
/*    */   BigDecimal getExemptTaxAmount();
/*    */   
/*    */   void setExemptTaxAmount(BigDecimal paramBigDecimal);
/*    */   
/*    */   BigDecimal getTaxExemptAmount();
/*    */   
/*    */   void setTaxExemptAmount(BigDecimal paramBigDecimal);
/*    */   
/*    */   String getTaxExemptionId();
/*    */   
/*    */   void setTaxExemptionId(String paramString);
/*    */   
/*    */   BigDecimal getTaxOverrideAmount();
/*    */   
/*    */   void setTaxOverrideAmount(BigDecimal paramBigDecimal);
/*    */   
/*    */   boolean getTaxOverride();
/*    */   
/*    */   void setTaxOverride(boolean paramBoolean);
/*    */   
/*    */   BigDecimal getTaxOverridePercentage();
/*    */   
/*    */   void setTaxOverridePercentage(BigDecimal paramBigDecimal);
/*    */   
/*    */   String getTaxOverrideReasonCode();
/*    */   
/*    */   void setTaxOverrideReasonCode(String paramString);
/*    */   
/*    */   String getTaxOverrideComment();
/*    */   
/*    */   void setTaxOverrideComment(String paramString);
/*    */   
/*    */   BigDecimal getTaxableAmount();
/*    */   
/*    */   void setTaxableAmount(BigDecimal paramBigDecimal);
/*    */   
/*    */   boolean getVoid();
/*    */   
/*    */   void setVoid(boolean paramBoolean);
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
/*    */   String getAuthorityId();
/*    */   
/*    */   void setAuthorityId(String paramString);
/*    */   
/*    */   String getAuthorityName();
/*    */   
/*    */   void setAuthorityName(String paramString);
/*    */   
/*    */   String getAuthorityTypeCode();
/*    */   
/*    */   void setAuthorityTypeCode(String paramString);
/*    */   
/*    */   String getTaxOverrideBracket();
/*    */   
/*    */   void setTaxOverrideBracket(String paramString);
/*    */   
/*    */   BigDecimal getOrigTaxableAmount();
/*    */   
/*    */   void setOrigTaxableAmount(BigDecimal paramBigDecimal);
/*    */   
/*    */   String getOrigTaxGroupId();
/*    */   
/*    */   void setOrigTaxGroupId(String paramString);
/*    */   
/*    */   IDataModel getSaleTaxModifierExt();
/*    */   
/*    */   void setSaleTaxModifierExt(IDataModel paramIDataModel);
/*    */   
/*    */   ITaxGroupRule getSaleTaxGroupRule();
/*    */   
/*    */   void setSaleTaxGroupRule(ITaxGroupRule paramITaxGroupRule);
/*    */   
/*    */   List<ISaleTaxModifierProperty> getProperties();
/*    */   
/*    */   void setProperties(List<ISaleTaxModifierProperty> paramList);
/*    */   
/*    */   void addSaleTaxModifierProperty(ISaleTaxModifierProperty paramISaleTaxModifierProperty);
/*    */   
/*    */   void removeSaleTaxModifierProperty(ISaleTaxModifierProperty paramISaleTaxModifierProperty);
/*    */   
/*    */   void setParentLine(ISaleReturnLineItem paramISaleReturnLineItem);
/*    */   
/*    */   ISaleReturnLineItem getParentLine();
/*    */   
/*    */   void startTransaction();
/*    */   
/*    */   void rollbackChanges();
/*    */   
/*    */   void commitTransaction();
/*    */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\trl\ISaleTaxModifier.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */