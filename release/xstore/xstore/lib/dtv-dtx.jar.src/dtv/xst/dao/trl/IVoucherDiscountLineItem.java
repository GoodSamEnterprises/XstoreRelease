/*    */ package dtv.xst.dao.trl;
/*    */ import dtv.data2.access.IDataModel;
/*    */ import dtv.event.EventEnum;
/*    */ import dtv.xst.dao.ttr.IVoucher;
/*    */ import java.math.BigDecimal;
/*    */ import java.util.Date;
/*    */ 
/*    */ public interface IVoucherDiscountLineItem extends IDataModel, IVoucherDiscountLineItemModel, IDiscountLineItem {
/*  9 */   public static final EventEnum SET_CREATEDATE = new EventEnum("set createDate");
/* 10 */   public static final EventEnum SET_CREATEUSERID = new EventEnum("set createUserId");
/* 11 */   public static final EventEnum SET_UPDATEDATE = new EventEnum("set updateDate");
/* 12 */   public static final EventEnum SET_UPDATEUSERID = new EventEnum("set updateUserId");
/* 13 */   public static final EventEnum SET_ACTIVITYCODE = new EventEnum("set activityCode");
/* 14 */   public static final EventEnum SET_ADJUDICATIONCODE = new EventEnum("set adjudicationCode");
/* 15 */   public static final EventEnum SET_AUTHORIZATIONCODE = new EventEnum("set authorizationCode");
/* 16 */   public static final EventEnum SET_AUTHORIZATIONMETHODCODE = new EventEnum("set authorizationMethodCode");
/* 17 */   public static final EventEnum SET_ENTRYMETHODCODE = new EventEnum("set entryMethodCode");
/* 18 */   public static final EventEnum SET_SERIALNUMBER = new EventEnum("set serialNumber");
/* 19 */   public static final EventEnum SET_VOUCHERTYPECODE = new EventEnum("set voucherTypeCode");
/* 20 */   public static final EventEnum SET_BANKREFERENCENUMBER = new EventEnum("set bankReferenceNumber");
/* 21 */   public static final EventEnum SET_EFFECTIVEDATE = new EventEnum("set effectiveDate");
/* 22 */   public static final EventEnum SET_EXPIRATIONDATE = new EventEnum("set expirationDate");
/* 23 */   public static final EventEnum SET_FACEVALUEAMOUNT = new EventEnum("set faceValueAmount");
/* 24 */   public static final EventEnum SET_ISSUEDATETIMESTAMP = new EventEnum("set issueDatetimestamp");
/* 25 */   public static final EventEnum SET_ISSUETYPECODE = new EventEnum("set issueTypeCode");
/* 26 */   public static final EventEnum SET_UNSPENTBALANCEAMOUNT = new EventEnum("set unspentBalanceAmount");
/* 27 */   public static final EventEnum SET_VOUCHERSTATUSCODE = new EventEnum("set voucherStatusCode");
/* 28 */   public static final EventEnum SET_TRACENUMBER = new EventEnum("set traceNumber");
/* 29 */   public static final EventEnum SET_VOUCHER = new EventEnum("set Voucher");
/* 30 */   public static final EventEnum START_TRANSACTION = new EventEnum("start transaction");
/* 31 */   public static final EventEnum ROLLBACK_TRANSACTION = new EventEnum("rollback transaction");
/* 32 */   public static final EventEnum COMMIT_TRANSACTION = new EventEnum("commit transaction");
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
/*    */   String getActivityCode();
/*    */   
/*    */   void setActivityCode(String paramString);
/*    */   
/*    */   String getAdjudicationCode();
/*    */   
/*    */   void setAdjudicationCode(String paramString);
/*    */   
/*    */   String getAuthorizationCode();
/*    */   
/*    */   void setAuthorizationCode(String paramString);
/*    */   
/*    */   String getAuthorizationMethodCode();
/*    */   
/*    */   void setAuthorizationMethodCode(String paramString);
/*    */   
/*    */   String getEntryMethodCode();
/*    */   
/*    */   void setEntryMethodCode(String paramString);
/*    */   
/*    */   String getSerialNumber();
/*    */   
/*    */   void setSerialNumber(String paramString);
/*    */   
/*    */   String getVoucherTypeCode();
/*    */   
/*    */   void setVoucherTypeCode(String paramString);
/*    */   
/*    */   String getBankReferenceNumber();
/*    */   
/*    */   void setBankReferenceNumber(String paramString);
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
/*    */   String getTraceNumber();
/*    */   
/*    */   void setTraceNumber(String paramString);
/*    */   
/*    */   IDataModel getVoucherDiscountLineItemExt();
/*    */   
/*    */   void setVoucherDiscountLineItemExt(IDataModel paramIDataModel);
/*    */   
/*    */   IVoucher getVoucher();
/*    */   
/*    */   void setVoucher(IVoucher paramIVoucher);
/*    */   
/*    */   void startTransaction();
/*    */   
/*    */   void rollbackChanges();
/*    */   
/*    */   void commitTransaction();
/*    */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\trl\IVoucherDiscountLineItem.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */