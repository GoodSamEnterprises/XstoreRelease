/*    */ package dtv.xst.dao.dsc;
/*    */ import dtv.data2.access.IDataModel;
/*    */ import dtv.event.EventEnum;
/*    */ import dtv.xst.dao.tnd.ITender;
/*    */ import java.util.Date;
/*    */ import java.util.List;
/*    */ 
/*    */ public interface ICoupon extends IDataModel, IHasDataProperty<ICouponProperty> {
/*  9 */   public static final EventEnum SET_COUPONSERIALNUMBER = new EventEnum("set couponSerialNumber");
/* 10 */   public static final EventEnum SET_ORGANIZATIONID = new EventEnum("set organizationId");
/* 11 */   public static final EventEnum SET_ORGCODE = new EventEnum("set orgCode");
/* 12 */   public static final EventEnum SET_ORGVALUE = new EventEnum("set orgValue");
/* 13 */   public static final EventEnum SET_CREATEDATE = new EventEnum("set createDate");
/* 14 */   public static final EventEnum SET_CREATEUSERID = new EventEnum("set createUserId");
/* 15 */   public static final EventEnum SET_UPDATEDATE = new EventEnum("set updateDate");
/* 16 */   public static final EventEnum SET_UPDATEUSERID = new EventEnum("set updateUserId");
/* 17 */   public static final EventEnum SET_DISCOUNTCODE = new EventEnum("set discountCode");
/* 18 */   public static final EventEnum SET_COUPONTYPE = new EventEnum("set couponType");
/* 19 */   public static final EventEnum SET_TENDERID = new EventEnum("set tenderId");
/* 20 */   public static final EventEnum SET_EFFECTIVEDATE = new EventEnum("set effectiveDate");
/* 21 */   public static final EventEnum SET_EXPIRATIONDATE = new EventEnum("set expirationDate");
/* 22 */   public static final EventEnum SET_SERIALIZED = new EventEnum("set serialized");
/* 23 */   public static final EventEnum SET_COUPONDISCOUNT = new EventEnum("set CouponDiscount");
/* 24 */   public static final EventEnum SET_TENDER = new EventEnum("set Tender");
/* 25 */   public static final EventEnum ADD_PROPERTIES = new EventEnum("add Properties");
/* 26 */   public static final EventEnum REMOVE_PROPERTIES = new EventEnum("remove Properties");
/* 27 */   public static final EventEnum SET_PROPERTIES = new EventEnum("set Properties");
/* 28 */   public static final EventEnum START_TRANSACTION = new EventEnum("start transaction");
/* 29 */   public static final EventEnum ROLLBACK_TRANSACTION = new EventEnum("rollback transaction");
/* 30 */   public static final EventEnum COMMIT_TRANSACTION = new EventEnum("commit transaction");
/*    */   
/*    */   void setDAO(IDataAccessObject paramIDataAccessObject);
/*    */   
/*    */   String getCouponSerialNumber();
/*    */   
/*    */   void setCouponSerialNumber(String paramString);
/*    */   
/*    */   long getOrganizationId();
/*    */   
/*    */   void setOrganizationId(long paramLong);
/*    */   
/*    */   String getOrgCode();
/*    */   
/*    */   void setOrgCode(String paramString);
/*    */   
/*    */   String getOrgValue();
/*    */   
/*    */   void setOrgValue(String paramString);
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
/*    */   String getDiscountCode();
/*    */   
/*    */   void setDiscountCode(String paramString);
/*    */   
/*    */   String getCouponType();
/*    */   
/*    */   void setCouponType(String paramString);
/*    */   
/*    */   String getTenderId();
/*    */   
/*    */   void setTenderId(String paramString);
/*    */   
/*    */   Date getEffectiveDate();
/*    */   
/*    */   void setEffectiveDate(Date paramDate);
/*    */   
/*    */   Date getExpirationDate();
/*    */   
/*    */   void setExpirationDate(Date paramDate);
/*    */   
/*    */   boolean getSerialized();
/*    */   
/*    */   void setSerialized(boolean paramBoolean);
/*    */   
/*    */   IDataModel getCouponExt();
/*    */   
/*    */   void setCouponExt(IDataModel paramIDataModel);
/*    */   
/*    */   IDiscount getCouponDiscount();
/*    */   
/*    */   void setCouponDiscount(IDiscount paramIDiscount);
/*    */   
/*    */   ITender getTender();
/*    */   
/*    */   void setTender(ITender paramITender);
/*    */   
/*    */   List<ICouponProperty> getProperties();
/*    */   
/*    */   void setProperties(List<ICouponProperty> paramList);
/*    */   
/*    */   void addCouponProperty(ICouponProperty paramICouponProperty);
/*    */   
/*    */   void removeCouponProperty(ICouponProperty paramICouponProperty);
/*    */   
/*    */   void startTransaction();
/*    */   
/*    */   void rollbackChanges();
/*    */   
/*    */   void commitTransaction();
/*    */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\dsc\ICoupon.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */