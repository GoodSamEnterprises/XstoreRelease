/*    */ package dtv.xst.dao.ttr;
/*    */ 
/*    */ import dtv.data2.access.IDataAccessObject;
/*    */ import dtv.data2.access.IDataModel;
/*    */ import dtv.event.EventEnum;
/*    */ import java.util.Date;
/*    */ 
/*    */ public interface ICouponTenderLineItem extends IDataModel, ICouponTenderLineItemModel, ITenderLineItem {
/*  9 */   public static final EventEnum SET_CREATEDATE = new EventEnum("set createDate");
/* 10 */   public static final EventEnum SET_CREATEUSERID = new EventEnum("set createUserId");
/* 11 */   public static final EventEnum SET_UPDATEDATE = new EventEnum("set updateDate");
/* 12 */   public static final EventEnum SET_UPDATEUSERID = new EventEnum("set updateUserId");
/* 13 */   public static final EventEnum SET_COUPONTYPECODE = new EventEnum("set couponTypeCode");
/* 14 */   public static final EventEnum SET_EXPIRATIONDATE = new EventEnum("set expirationDate");
/* 15 */   public static final EventEnum SET_KEYENTERED = new EventEnum("set keyEntered");
/* 16 */   public static final EventEnum SET_MANUFACTURERFAMILYCODE = new EventEnum("set manufacturerFamilyCode");
/* 17 */   public static final EventEnum SET_MANUFACTURERID = new EventEnum("set manufacturerId");
/* 18 */   public static final EventEnum SET_PROMOTIONCODE = new EventEnum("set promotionCode");
/* 19 */   public static final EventEnum SET_SCANCODE = new EventEnum("set scanCode");
/* 20 */   public static final EventEnum START_TRANSACTION = new EventEnum("start transaction");
/* 21 */   public static final EventEnum ROLLBACK_TRANSACTION = new EventEnum("rollback transaction");
/* 22 */   public static final EventEnum COMMIT_TRANSACTION = new EventEnum("commit transaction");
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
/*    */   String getCouponTypeCode();
/*    */   
/*    */   void setCouponTypeCode(String paramString);
/*    */   
/*    */   Date getExpirationDate();
/*    */   
/*    */   void setExpirationDate(Date paramDate);
/*    */   
/*    */   boolean getKeyEntered();
/*    */   
/*    */   void setKeyEntered(boolean paramBoolean);
/*    */   
/*    */   String getManufacturerFamilyCode();
/*    */   
/*    */   void setManufacturerFamilyCode(String paramString);
/*    */   
/*    */   String getManufacturerId();
/*    */   
/*    */   void setManufacturerId(String paramString);
/*    */   
/*    */   String getPromotionCode();
/*    */   
/*    */   void setPromotionCode(String paramString);
/*    */   
/*    */   String getScanCode();
/*    */   
/*    */   void setScanCode(String paramString);
/*    */   
/*    */   IDataModel getCouponTenderLineItemExt();
/*    */   
/*    */   void setCouponTenderLineItemExt(IDataModel paramIDataModel);
/*    */   
/*    */   void startTransaction();
/*    */   
/*    */   void rollbackChanges();
/*    */   
/*    */   void commitTransaction();
/*    */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\ttr\ICouponTenderLineItem.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */