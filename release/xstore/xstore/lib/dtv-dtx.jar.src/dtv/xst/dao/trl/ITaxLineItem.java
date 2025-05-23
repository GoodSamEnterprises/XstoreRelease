/*    */ package dtv.xst.dao.trl;
/*    */ import dtv.data2.access.IDataModel;
/*    */ import dtv.event.EventEnum;
/*    */ import dtv.xst.dao.tax.ITaxGroupRule;
/*    */ import java.math.BigDecimal;
/*    */ import java.util.Date;
/*    */ 
/*    */ public interface ITaxLineItem extends IDataModel, ITaxLineItemModel, IRetailTransactionLineItem {
/*  9 */   public static final EventEnum SET_CREATEDATE = new EventEnum("set createDate");
/* 10 */   public static final EventEnum SET_CREATEUSERID = new EventEnum("set createUserId");
/* 11 */   public static final EventEnum SET_UPDATEDATE = new EventEnum("set updateDate");
/* 12 */   public static final EventEnum SET_UPDATEUSERID = new EventEnum("set updateUserId");
/* 13 */   public static final EventEnum SET_TAXAMOUNT = new EventEnum("set taxAmount");
/* 14 */   public static final EventEnum SET_TAXPERCENTAGE = new EventEnum("set taxPercentage");
/* 15 */   public static final EventEnum SET_RAWTAXAMOUNT = new EventEnum("set rawTaxAmount");
/* 16 */   public static final EventEnum SET_RAWTAXPERCENTAGE = new EventEnum("set rawTaxPercentage");
/* 17 */   public static final EventEnum SET_TAXOVERRIDEAMOUNT = new EventEnum("set taxOverrideAmount");
/* 18 */   public static final EventEnum SET_TAXOVERRIDE = new EventEnum("set taxOverride");
/* 19 */   public static final EventEnum SET_TAXOVERRIDEPERCENTAGE = new EventEnum("set taxOverridePercentage");
/* 20 */   public static final EventEnum SET_TAXOVERRIDEREASONCODE = new EventEnum("set taxOverrideReasonCode");
/* 21 */   public static final EventEnum SET_TAXABLEAMOUNT = new EventEnum("set taxableAmount");
/* 22 */   public static final EventEnum SET_TAXGROUPID = new EventEnum("set taxGroupId");
/* 23 */   public static final EventEnum SET_TAXLOCATIONID = new EventEnum("set taxLocationId");
/* 24 */   public static final EventEnum SET_TAXRULESEQUENCE = new EventEnum("set taxRuleSequence");
/* 25 */   public static final EventEnum SET_AUTHORITYID = new EventEnum("set authorityId");
/* 26 */   public static final EventEnum SET_AUTHORITYNAME = new EventEnum("set authorityName");
/* 27 */   public static final EventEnum SET_AUTHORITYTYPECODE = new EventEnum("set authorityTypeCode");
/* 28 */   public static final EventEnum SET_SALETAXGROUPRULE = new EventEnum("set SaleTaxGroupRule");
/* 29 */   public static final EventEnum START_TRANSACTION = new EventEnum("start transaction");
/* 30 */   public static final EventEnum ROLLBACK_TRANSACTION = new EventEnum("rollback transaction");
/* 31 */   public static final EventEnum COMMIT_TRANSACTION = new EventEnum("commit transaction");
/*    */   
/*    */   void setDAO(IDataAccessObject paramIDataAccessObject);
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
/*    */   BigDecimal getTaxableAmount();
/*    */   
/*    */   void setTaxableAmount(BigDecimal paramBigDecimal);
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
/*    */   IDataModel getTaxLineItemExt();
/*    */   
/*    */   void setTaxLineItemExt(IDataModel paramIDataModel);
/*    */   
/*    */   ITaxGroupRule getSaleTaxGroupRule();
/*    */   
/*    */   void setSaleTaxGroupRule(ITaxGroupRule paramITaxGroupRule);
/*    */   
/*    */   void startTransaction();
/*    */   
/*    */   void rollbackChanges();
/*    */   
/*    */   void commitTransaction();
/*    */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\trl\ITaxLineItem.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */