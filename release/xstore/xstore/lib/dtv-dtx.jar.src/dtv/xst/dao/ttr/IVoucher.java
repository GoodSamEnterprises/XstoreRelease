/*    */ package dtv.xst.dao.ttr;
/*    */ import dtv.data2.access.IDataModel;
/*    */ import dtv.event.EventEnum;
/*    */ import java.math.BigDecimal;
/*    */ import java.util.Date;
/*    */ import java.util.List;
/*    */ 
/*    */ public interface IVoucher extends IDataModel, IVoucherModel, IHasDataProperty<IVoucherProperty> {
/*  9 */   public static final EventEnum SET_ORGANIZATIONID = new EventEnum("set organizationId");
/* 10 */   public static final EventEnum SET_SERIALNUMBER = new EventEnum("set serialNumber");
/* 11 */   public static final EventEnum SET_VOUCHERTYPECODE = new EventEnum("set voucherTypeCode");
/* 12 */   public static final EventEnum SET_CREATEDATE = new EventEnum("set createDate");
/* 13 */   public static final EventEnum SET_CREATEUSERID = new EventEnum("set createUserId");
/* 14 */   public static final EventEnum SET_UPDATEDATE = new EventEnum("set updateDate");
/* 15 */   public static final EventEnum SET_UPDATEUSERID = new EventEnum("set updateUserId");
/* 16 */   public static final EventEnum SET_EFFECTIVEDATE = new EventEnum("set effectiveDate");
/* 17 */   public static final EventEnum SET_EXPIRATIONDATE = new EventEnum("set expirationDate");
/* 18 */   public static final EventEnum SET_FACEVALUEAMOUNT = new EventEnum("set faceValueAmount");
/* 19 */   public static final EventEnum SET_ISSUEDATETIMESTAMP = new EventEnum("set issueDatetimestamp");
/* 20 */   public static final EventEnum SET_ISSUETYPECODE = new EventEnum("set issueTypeCode");
/* 21 */   public static final EventEnum SET_UNSPENTBALANCEAMOUNT = new EventEnum("set unspentBalanceAmount");
/* 22 */   public static final EventEnum SET_VOUCHERSTATUSCODE = new EventEnum("set voucherStatusCode");
/* 23 */   public static final EventEnum SET_CURRENCYID = new EventEnum("set currencyId");
/* 24 */   public static final EventEnum ADD_PROPERTIES = new EventEnum("add Properties");
/* 25 */   public static final EventEnum REMOVE_PROPERTIES = new EventEnum("remove Properties");
/* 26 */   public static final EventEnum SET_PROPERTIES = new EventEnum("set Properties");
/* 27 */   public static final EventEnum START_TRANSACTION = new EventEnum("start transaction");
/* 28 */   public static final EventEnum ROLLBACK_TRANSACTION = new EventEnum("rollback transaction");
/* 29 */   public static final EventEnum COMMIT_TRANSACTION = new EventEnum("commit transaction");
/*    */   
/*    */   void setDAO(IDataAccessObject paramIDataAccessObject);
/*    */   
/*    */   long getOrganizationId();
/*    */   
/*    */   void setOrganizationId(long paramLong);
/*    */   
/*    */   String getSerialNumber();
/*    */   
/*    */   void setSerialNumber(String paramString);
/*    */   
/*    */   String getVoucherTypeCode();
/*    */   
/*    */   void setVoucherTypeCode(String paramString);
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
/*    */   Date getEffectiveDate();
/*    */   
/*    */   void setEffectiveDate(Date paramDate);
/*    */   
/*    */   Date getExpirationDate();
/*    */   
/*    */   void setExpirationDate(Date paramDate);
/*    */   
/*    */   BigDecimal getFaceValueAmount();
/*    */   
/*    */   void setFaceValueAmount(BigDecimal paramBigDecimal);
/*    */   
/*    */   Date getIssueDatetimestamp();
/*    */   
/*    */   void setIssueDatetimestamp(Date paramDate);
/*    */   
/*    */   String getIssueTypeCode();
/*    */   
/*    */   void setIssueTypeCode(String paramString);
/*    */   
/*    */   BigDecimal getUnspentBalanceAmount();
/*    */   
/*    */   void setUnspentBalanceAmount(BigDecimal paramBigDecimal);
/*    */   
/*    */   String getVoucherStatusCode();
/*    */   
/*    */   void setVoucherStatusCode(String paramString);
/*    */   
/*    */   String getCurrencyId();
/*    */   
/*    */   void setCurrencyId(String paramString);
/*    */   
/*    */   IDataModel getVoucherExt();
/*    */   
/*    */   void setVoucherExt(IDataModel paramIDataModel);
/*    */   
/*    */   List<IVoucherProperty> getProperties();
/*    */   
/*    */   void setProperties(List<IVoucherProperty> paramList);
/*    */   
/*    */   void addVoucherProperty(IVoucherProperty paramIVoucherProperty);
/*    */   
/*    */   void removeVoucherProperty(IVoucherProperty paramIVoucherProperty);
/*    */   
/*    */   void startTransaction();
/*    */   
/*    */   void rollbackChanges();
/*    */   
/*    */   void commitTransaction();
/*    */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\ttr\IVoucher.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */