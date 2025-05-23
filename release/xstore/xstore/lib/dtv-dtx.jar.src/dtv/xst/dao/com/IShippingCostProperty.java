/*    */ package dtv.xst.dao.com;
/*    */ import dtv.data2.access.IDataAccessObject;
/*    */ import dtv.data2.access.IDataProperty;
/*    */ import dtv.event.EventEnum;
/*    */ import java.math.BigDecimal;
/*    */ import java.util.Date;
/*    */ 
/*    */ public interface IShippingCostProperty extends IDataModel, IDataProperty {
/*  9 */   public static final EventEnum SET_ORGANIZATIONID = new EventEnum("set organizationId");
/* 10 */   public static final EventEnum SET_CATEGORY = new EventEnum("set category");
/* 11 */   public static final EventEnum SET_BEGINRANGE = new EventEnum("set beginRange");
/* 12 */   public static final EventEnum SET_ENDRANGE = new EventEnum("set endRange");
/* 13 */   public static final EventEnum SET_COST = new EventEnum("set cost");
/* 14 */   public static final EventEnum SET_PROPERTYCODE = new EventEnum("set propertyCode");
/* 15 */   public static final EventEnum SET_TYPE = new EventEnum("set type");
/* 16 */   public static final EventEnum SET_STRINGVALUE = new EventEnum("set stringValue");
/* 17 */   public static final EventEnum SET_DATEVALUE = new EventEnum("set dateValue");
/* 18 */   public static final EventEnum SET_DECIMALVALUE = new EventEnum("set decimalValue");
/* 19 */   public static final EventEnum SET_CREATEDATE = new EventEnum("set createDate");
/* 20 */   public static final EventEnum SET_CREATEUSERID = new EventEnum("set createUserId");
/* 21 */   public static final EventEnum SET_UPDATEDATE = new EventEnum("set updateDate");
/* 22 */   public static final EventEnum SET_UPDATEUSERID = new EventEnum("set updateUserId");
/* 23 */   public static final EventEnum START_TRANSACTION = new EventEnum("start transaction");
/* 24 */   public static final EventEnum ROLLBACK_TRANSACTION = new EventEnum("rollback transaction");
/* 25 */   public static final EventEnum COMMIT_TRANSACTION = new EventEnum("commit transaction");
/*    */   
/*    */   void setDAO(IDataAccessObject paramIDataAccessObject);
/*    */   
/*    */   long getOrganizationId();
/*    */   
/*    */   void setOrganizationId(long paramLong);
/*    */   
/*    */   String getCategory();
/*    */   
/*    */   void setCategory(String paramString);
/*    */   
/*    */   BigDecimal getBeginRange();
/*    */   
/*    */   void setBeginRange(BigDecimal paramBigDecimal);
/*    */   
/*    */   BigDecimal getEndRange();
/*    */   
/*    */   void setEndRange(BigDecimal paramBigDecimal);
/*    */   
/*    */   BigDecimal getCost();
/*    */   
/*    */   void setCost(BigDecimal paramBigDecimal);
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


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\com\IShippingCostProperty.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */