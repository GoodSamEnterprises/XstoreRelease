/*    */ package dtv.xst.dao.tsn;
/*    */ import dtv.data2.access.IDataAccessObject;
/*    */ import dtv.data2.access.IDataProperty;
/*    */ import dtv.event.EventEnum;
/*    */ import java.math.BigDecimal;
/*    */ import java.util.Date;
/*    */ 
/*    */ public interface ITenderDenominationCountProperty extends IDataModel, IDataProperty {
/*  9 */   public static final EventEnum SET_BUSINESSDAYDATE = new EventEnum("set businessDayDate");
/* 10 */   public static final EventEnum SET_DENOMINATIONID = new EventEnum("set denominationId");
/* 11 */   public static final EventEnum SET_ORGANIZATIONID = new EventEnum("set organizationId");
/* 12 */   public static final EventEnum SET_RETAILLOCATIONID = new EventEnum("set retailLocationId");
/* 13 */   public static final EventEnum SET_TENDERID = new EventEnum("set tenderId");
/* 14 */   public static final EventEnum SET_TENDERTYPECODE = new EventEnum("set tenderTypeCode");
/* 15 */   public static final EventEnum SET_TRANSACTIONSEQUENCE = new EventEnum("set transactionSequence");
/* 16 */   public static final EventEnum SET_WORKSTATIONID = new EventEnum("set workstationId");
/* 17 */   public static final EventEnum SET_PROPERTYCODE = new EventEnum("set propertyCode");
/* 18 */   public static final EventEnum SET_TYPE = new EventEnum("set type");
/* 19 */   public static final EventEnum SET_STRINGVALUE = new EventEnum("set stringValue");
/* 20 */   public static final EventEnum SET_DATEVALUE = new EventEnum("set dateValue");
/* 21 */   public static final EventEnum SET_DECIMALVALUE = new EventEnum("set decimalValue");
/* 22 */   public static final EventEnum SET_CREATEDATE = new EventEnum("set createDate");
/* 23 */   public static final EventEnum SET_CREATEUSERID = new EventEnum("set createUserId");
/* 24 */   public static final EventEnum SET_UPDATEDATE = new EventEnum("set updateDate");
/* 25 */   public static final EventEnum SET_UPDATEUSERID = new EventEnum("set updateUserId");
/* 26 */   public static final EventEnum START_TRANSACTION = new EventEnum("start transaction");
/* 27 */   public static final EventEnum ROLLBACK_TRANSACTION = new EventEnum("rollback transaction");
/* 28 */   public static final EventEnum COMMIT_TRANSACTION = new EventEnum("commit transaction");
/*    */   
/*    */   void setDAO(IDataAccessObject paramIDataAccessObject);
/*    */   
/*    */   Date getBusinessDayDate();
/*    */   
/*    */   void setBusinessDayDate(Date paramDate);
/*    */   
/*    */   String getDenominationId();
/*    */   
/*    */   void setDenominationId(String paramString);
/*    */   
/*    */   long getOrganizationId();
/*    */   
/*    */   void setOrganizationId(long paramLong);
/*    */   
/*    */   long getRetailLocationId();
/*    */   
/*    */   void setRetailLocationId(long paramLong);
/*    */   
/*    */   String getTenderId();
/*    */   
/*    */   void setTenderId(String paramString);
/*    */   
/*    */   String getTenderTypeCode();
/*    */   
/*    */   void setTenderTypeCode(String paramString);
/*    */   
/*    */   long getTransactionSequence();
/*    */   
/*    */   void setTransactionSequence(long paramLong);
/*    */   
/*    */   long getWorkstationId();
/*    */   
/*    */   void setWorkstationId(long paramLong);
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


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\tsn\ITenderDenominationCountProperty.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */