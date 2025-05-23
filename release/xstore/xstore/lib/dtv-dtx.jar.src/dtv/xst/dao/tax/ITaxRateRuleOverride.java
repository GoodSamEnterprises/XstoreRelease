/*    */ package dtv.xst.dao.tax;
/*    */ import dtv.data2.access.IDataModel;
/*    */ import dtv.event.EventEnum;
/*    */ import java.math.BigDecimal;
/*    */ import java.util.Date;
/*    */ import java.util.List;
/*    */ 
/*    */ public interface ITaxRateRuleOverride extends IDataModel, ITaxRateRuleOverrideModel, IHasDataProperty<ITaxRateRuleOverrideProperty> {
/*  9 */   public static final EventEnum SET_EXPIRATIONDATETIMESTAMP = new EventEnum("set expirationDatetimestamp");
/* 10 */   public static final EventEnum SET_ORGANIZATIONID = new EventEnum("set organizationId");
/* 11 */   public static final EventEnum SET_TAXGROUPID = new EventEnum("set taxGroupId");
/* 12 */   public static final EventEnum SET_TAXLOCATIONID = new EventEnum("set taxLocationId");
/* 13 */   public static final EventEnum SET_TAXRATERULESEQUENCE = new EventEnum("set taxRateRuleSequence");
/* 14 */   public static final EventEnum SET_TAXRULESEQUENCE = new EventEnum("set taxRuleSequence");
/* 15 */   public static final EventEnum SET_CREATEDATE = new EventEnum("set createDate");
/* 16 */   public static final EventEnum SET_CREATEUSERID = new EventEnum("set createUserId");
/* 17 */   public static final EventEnum SET_UPDATEDATE = new EventEnum("set updateDate");
/* 18 */   public static final EventEnum SET_UPDATEUSERID = new EventEnum("set updateUserId");
/* 19 */   public static final EventEnum SET_ORGCODE = new EventEnum("set orgCode");
/* 20 */   public static final EventEnum SET_ORGVALUE = new EventEnum("set orgValue");
/* 21 */   public static final EventEnum SET_AMOUNT = new EventEnum("set amount");
/* 22 */   public static final EventEnum SET_BREAKPOINTTYPECODE = new EventEnum("set breakPointTypeCode");
/* 23 */   public static final EventEnum SET_DAILYENDTIMEDAO = new EventEnum("set dailyEndTimeDao");
/* 24 */   public static final EventEnum SET_DAILYSTARTTIMEDAO = new EventEnum("set dailyStartTimeDao");
/* 25 */   public static final EventEnum SET_EFFECTIVEDATETIMESTAMP = new EventEnum("set effectiveDatetimestamp");
/* 26 */   public static final EventEnum SET_PERCENT = new EventEnum("set percent");
/* 27 */   public static final EventEnum SET_TAXRATEMAXTAXABLEAMOUNT = new EventEnum("set taxRateMaxTaxableAmount");
/* 28 */   public static final EventEnum SET_TAXRATEMINTAXABLEAMOUNT = new EventEnum("set taxRateMinTaxableAmount");
/* 29 */   public static final EventEnum SET_TAXBRACKETID = new EventEnum("set taxBracketId");
/* 30 */   public static final EventEnum ADD_PROPERTIES = new EventEnum("add Properties");
/* 31 */   public static final EventEnum REMOVE_PROPERTIES = new EventEnum("remove Properties");
/* 32 */   public static final EventEnum SET_PROPERTIES = new EventEnum("set Properties");
/* 33 */   public static final EventEnum START_TRANSACTION = new EventEnum("start transaction");
/* 34 */   public static final EventEnum ROLLBACK_TRANSACTION = new EventEnum("rollback transaction");
/* 35 */   public static final EventEnum COMMIT_TRANSACTION = new EventEnum("commit transaction");
/*    */   
/*    */   void setDAO(IDataAccessObject paramIDataAccessObject);
/*    */   
/*    */   Date getExpirationDatetimestamp();
/*    */   
/*    */   void setExpirationDatetimestamp(Date paramDate);
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
/*    */   int getTaxRateRuleSequence();
/*    */   
/*    */   void setTaxRateRuleSequence(int paramInt);
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
/*    */   BigDecimal getAmount();
/*    */   
/*    */   void setAmount(BigDecimal paramBigDecimal);
/*    */   
/*    */   String getBreakPointTypeCode();
/*    */   
/*    */   void setBreakPointTypeCode(String paramString);
/*    */   
/*    */   Date getEffectiveDatetimestamp();
/*    */   
/*    */   void setEffectiveDatetimestamp(Date paramDate);
/*    */   
/*    */   BigDecimal getPercent();
/*    */   
/*    */   void setPercent(BigDecimal paramBigDecimal);
/*    */   
/*    */   BigDecimal getTaxRateMaxTaxableAmount();
/*    */   
/*    */   void setTaxRateMaxTaxableAmount(BigDecimal paramBigDecimal);
/*    */   
/*    */   BigDecimal getTaxRateMinTaxableAmount();
/*    */   
/*    */   void setTaxRateMinTaxableAmount(BigDecimal paramBigDecimal);
/*    */   
/*    */   String getTaxBracketId();
/*    */   
/*    */   void setTaxBracketId(String paramString);
/*    */   
/*    */   IDataModel getTaxRateRuleOverrideExt();
/*    */   
/*    */   void setTaxRateRuleOverrideExt(IDataModel paramIDataModel);
/*    */   
/*    */   List<ITaxRateRuleOverrideProperty> getProperties();
/*    */   
/*    */   void setProperties(List<ITaxRateRuleOverrideProperty> paramList);
/*    */   
/*    */   void addTaxRateRuleOverrideProperty(ITaxRateRuleOverrideProperty paramITaxRateRuleOverrideProperty);
/*    */   
/*    */   void removeTaxRateRuleOverrideProperty(ITaxRateRuleOverrideProperty paramITaxRateRuleOverrideProperty);
/*    */   
/*    */   void setParentRule(ITaxGroupRule paramITaxGroupRule);
/*    */   
/*    */   ITaxGroupRule getParentRule();
/*    */   
/*    */   void startTransaction();
/*    */   
/*    */   void rollbackChanges();
/*    */   
/*    */   void commitTransaction();
/*    */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\tax\ITaxRateRuleOverride.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */