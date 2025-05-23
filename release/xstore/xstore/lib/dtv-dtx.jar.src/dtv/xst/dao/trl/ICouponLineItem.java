/*    */ package dtv.xst.dao.trl;
/*    */ import dtv.data2.access.IDataAccessObject;
/*    */ import dtv.data2.access.IDataModel;
/*    */ import dtv.event.EventEnum;
/*    */ import java.math.BigDecimal;
/*    */ import java.util.Date;
/*    */ 
/*    */ public interface ICouponLineItem extends IDataModel, ICouponLineItemModel, IRetailTransactionLineItem {
/*  9 */   public static final EventEnum SET_CREATEDATE = new EventEnum("set createDate");
/* 10 */   public static final EventEnum SET_CREATEUSERID = new EventEnum("set createUserId");
/* 11 */   public static final EventEnum SET_UPDATEDATE = new EventEnum("set updateDate");
/* 12 */   public static final EventEnum SET_UPDATEUSERID = new EventEnum("set updateUserId");
/* 13 */   public static final EventEnum SET_COUPONID = new EventEnum("set couponId");
/* 14 */   public static final EventEnum SET_COUPONTYPECODE = new EventEnum("set couponTypeCode");
/* 15 */   public static final EventEnum SET_EXPIRATIONDATE = new EventEnum("set expirationDate");
/* 16 */   public static final EventEnum SET_ENTRYMETHODCODE = new EventEnum("set entryMethodCode");
/* 17 */   public static final EventEnum SET_MANUFACTURERID = new EventEnum("set manufacturerId");
/* 18 */   public static final EventEnum SET_VALUECODE = new EventEnum("set valueCode");
/* 19 */   public static final EventEnum SET_AMOUNTENTERED = new EventEnum("set amountEntered");
/* 20 */   public static final EventEnum SET_MANUFACTURERFAMILYCODE = new EventEnum("set manufacturerFamilyCode");
/* 21 */   public static final EventEnum SET_SERIALIZED = new EventEnum("set serialized");
/* 22 */   public static final EventEnum SET_AUTHORIZED = new EventEnum("set authorized");
/* 23 */   public static final EventEnum SET_REDEMPTIONTRANSID = new EventEnum("set redemptionTransId");
/* 24 */   public static final EventEnum START_TRANSACTION = new EventEnum("start transaction");
/* 25 */   public static final EventEnum ROLLBACK_TRANSACTION = new EventEnum("rollback transaction");
/* 26 */   public static final EventEnum COMMIT_TRANSACTION = new EventEnum("commit transaction");
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
/*    */   String getCouponId();
/*    */   
/*    */   void setCouponId(String paramString);
/*    */   
/*    */   String getCouponTypeCode();
/*    */   
/*    */   void setCouponTypeCode(String paramString);
/*    */   
/*    */   Date getExpirationDate();
/*    */   
/*    */   void setExpirationDate(Date paramDate);
/*    */   
/*    */   String getEntryMethodCode();
/*    */   
/*    */   void setEntryMethodCode(String paramString);
/*    */   
/*    */   String getManufacturerId();
/*    */   
/*    */   void setManufacturerId(String paramString);
/*    */   
/*    */   String getValueCode();
/*    */   
/*    */   void setValueCode(String paramString);
/*    */   
/*    */   BigDecimal getAmountEntered();
/*    */   
/*    */   void setAmountEntered(BigDecimal paramBigDecimal);
/*    */   
/*    */   String getManufacturerFamilyCode();
/*    */   
/*    */   void setManufacturerFamilyCode(String paramString);
/*    */   
/*    */   boolean getSerialized();
/*    */   
/*    */   void setSerialized(boolean paramBoolean);
/*    */   
/*    */   boolean getAuthorized();
/*    */   
/*    */   void setAuthorized(boolean paramBoolean);
/*    */   
/*    */   String getRedemptionTransId();
/*    */   
/*    */   void setRedemptionTransId(String paramString);
/*    */   
/*    */   IDataModel getCouponLineItemExt();
/*    */   
/*    */   void setCouponLineItemExt(IDataModel paramIDataModel);
/*    */   
/*    */   void startTransaction();
/*    */   
/*    */   void rollbackChanges();
/*    */   
/*    */   void commitTransaction();
/*    */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\trl\ICouponLineItem.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */