/*    */ package dtv.xst.dao.cwo;
/*    */ import dtv.data2.access.IDataModel;
/*    */ import dtv.event.EventEnum;
/*    */ import java.math.BigDecimal;
/*    */ import java.util.Date;
/*    */ import java.util.List;
/*    */ 
/*    */ public interface ICategoryServiceLocation extends IDataModel, IHasDataProperty<ICategoryServiceLocationProperty> {
/*  9 */   public static final EventEnum SET_ORGANIZATIONID = new EventEnum("set organizationId");
/* 10 */   public static final EventEnum SET_SERVICELOCATIONID = new EventEnum("set serviceLocationId");
/* 11 */   public static final EventEnum SET_CATEGORYID = new EventEnum("set categoryId");
/* 12 */   public static final EventEnum SET_CREATEDATE = new EventEnum("set createDate");
/* 13 */   public static final EventEnum SET_CREATEUSERID = new EventEnum("set createUserId");
/* 14 */   public static final EventEnum SET_UPDATEDATE = new EventEnum("set updateDate");
/* 15 */   public static final EventEnum SET_UPDATEUSERID = new EventEnum("set updateUserId");
/* 16 */   public static final EventEnum SET_ORGCODE = new EventEnum("set orgCode");
/* 17 */   public static final EventEnum SET_ORGVALUE = new EventEnum("set orgValue");
/* 18 */   public static final EventEnum SET_LEADTIMEQUANTITY = new EventEnum("set leadTimeQuantity");
/* 19 */   public static final EventEnum SET_LEADTIMEUNIT = new EventEnum("set leadTimeUnit");
/* 20 */   public static final EventEnum SET_CREATESHIPMENT = new EventEnum("set createShipment");
/* 21 */   public static final EventEnum SET_CATEGORYSERVICELOCATION = new EventEnum("set CategoryServiceLocation");
/* 22 */   public static final EventEnum ADD_PROPERTIES = new EventEnum("add Properties");
/* 23 */   public static final EventEnum REMOVE_PROPERTIES = new EventEnum("remove Properties");
/* 24 */   public static final EventEnum SET_PROPERTIES = new EventEnum("set Properties");
/* 25 */   public static final EventEnum START_TRANSACTION = new EventEnum("start transaction");
/* 26 */   public static final EventEnum ROLLBACK_TRANSACTION = new EventEnum("rollback transaction");
/* 27 */   public static final EventEnum COMMIT_TRANSACTION = new EventEnum("commit transaction");
/*    */   
/*    */   void setDAO(IDataAccessObject paramIDataAccessObject);
/*    */   
/*    */   long getOrganizationId();
/*    */   
/*    */   void setOrganizationId(long paramLong);
/*    */   
/*    */   String getServiceLocationId();
/*    */   
/*    */   void setServiceLocationId(String paramString);
/*    */   
/*    */   String getCategoryId();
/*    */   
/*    */   void setCategoryId(String paramString);
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
/*    */   BigDecimal getLeadTimeQuantity();
/*    */   
/*    */   void setLeadTimeQuantity(BigDecimal paramBigDecimal);
/*    */   
/*    */   String getLeadTimeUnit();
/*    */   
/*    */   void setLeadTimeUnit(String paramString);
/*    */   
/*    */   boolean getCreateShipment();
/*    */   
/*    */   void setCreateShipment(boolean paramBoolean);
/*    */   
/*    */   IDataModel getCategoryServiceLocationExt();
/*    */   
/*    */   void setCategoryServiceLocationExt(IDataModel paramIDataModel);
/*    */   
/*    */   IServiceLocation getCategoryServiceLocation();
/*    */   
/*    */   void setCategoryServiceLocation(IServiceLocation paramIServiceLocation);
/*    */   
/*    */   List<ICategoryServiceLocationProperty> getProperties();
/*    */   
/*    */   void setProperties(List<ICategoryServiceLocationProperty> paramList);
/*    */   
/*    */   void addCategoryServiceLocationProperty(ICategoryServiceLocationProperty paramICategoryServiceLocationProperty);
/*    */   
/*    */   void removeCategoryServiceLocationProperty(ICategoryServiceLocationProperty paramICategoryServiceLocationProperty);
/*    */   
/*    */   void startTransaction();
/*    */   
/*    */   void rollbackChanges();
/*    */   
/*    */   void commitTransaction();
/*    */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\cwo\ICategoryServiceLocation.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */