/*    */ package dtv.xst.dao.tax;
/*    */ import dtv.data2.access.IDataAccessObject;
/*    */ import dtv.data2.access.IDataProperty;
/*    */ import dtv.event.EventEnum;
/*    */ import java.math.BigDecimal;
/*    */ import java.util.Date;
/*    */ 
/*    */ public interface ITaxRateRuleOverrideProperty extends IDataModel, IDataProperty {
/*  9 */   public static final EventEnum SET_EXPIRATIONDATETIMESTAMP = new EventEnum("set expirationDatetimestamp");
/* 10 */   public static final EventEnum SET_ORGANIZATIONID = new EventEnum("set organizationId");
/* 11 */   public static final EventEnum SET_TAXGROUPID = new EventEnum("set taxGroupId");
/* 12 */   public static final EventEnum SET_TAXLOCATIONID = new EventEnum("set taxLocationId");
/* 13 */   public static final EventEnum SET_TAXRATERULESEQUENCE = new EventEnum("set taxRateRuleSequence");
/* 14 */   public static final EventEnum SET_TAXRULESEQUENCE = new EventEnum("set taxRuleSequence");
/* 15 */   public static final EventEnum SET_PROPERTYCODE = new EventEnum("set propertyCode");
/* 16 */   public static final EventEnum SET_TYPE = new EventEnum("set type");
/* 17 */   public static final EventEnum SET_STRINGVALUE = new EventEnum("set stringValue");
/* 18 */   public static final EventEnum SET_DATEVALUE = new EventEnum("set dateValue");
/* 19 */   public static final EventEnum SET_DECIMALVALUE = new EventEnum("set decimalValue");
/* 20 */   public static final EventEnum SET_CREATEDATE = new EventEnum("set createDate");
/* 21 */   public static final EventEnum SET_CREATEUSERID = new EventEnum("set createUserId");
/* 22 */   public static final EventEnum SET_UPDATEDATE = new EventEnum("set updateDate");
/* 23 */   public static final EventEnum SET_UPDATEUSERID = new EventEnum("set updateUserId");
/* 24 */   public static final EventEnum START_TRANSACTION = new EventEnum("start transaction");
/* 25 */   public static final EventEnum ROLLBACK_TRANSACTION = new EventEnum("rollback transaction");
/* 26 */   public static final EventEnum COMMIT_TRANSACTION = new EventEnum("commit transaction");
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
/*    */   String getPropertyCode();
/*    */   
/*    */   void setPropertyCode(String paramString);
/*    */   
/*    */   String getType();
/*    */   
/*    */   void setType(String paramString);
/*    */   
/*    */   String getStringValue();
/*    */   
/*    */   void setStringValue(String paramString);
/*    */   
/*    */   Date getDateValue();
/*    */   
/*    */   void setDateValue(Date paramDate);
/*    */   
/*    */   BigDecimal getDecimalValue();
/*    */   
/*    */   void setDecimalValue(BigDecimal paramBigDecimal);
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
/*    */   void startTransaction();
/*    */   
/*    */   void rollbackChanges();
/*    */   
/*    */   void commitTransaction();
/*    */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\tax\ITaxRateRuleOverrideProperty.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */