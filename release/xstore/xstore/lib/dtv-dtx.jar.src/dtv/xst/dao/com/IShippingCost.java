/*    */ package dtv.xst.dao.com;
/*    */ import dtv.data2.access.IDataModel;
/*    */ import dtv.event.EventEnum;
/*    */ import java.math.BigDecimal;
/*    */ import java.util.Date;
/*    */ import java.util.List;
/*    */ 
/*    */ public interface IShippingCost extends IDataModel, IHasDataProperty<IShippingCostProperty> {
/*  9 */   public static final EventEnum SET_ORGANIZATIONID = new EventEnum("set organizationId");
/* 10 */   public static final EventEnum SET_CATEGORY = new EventEnum("set category");
/* 11 */   public static final EventEnum SET_BEGINRANGE = new EventEnum("set beginRange");
/* 12 */   public static final EventEnum SET_ENDRANGE = new EventEnum("set endRange");
/* 13 */   public static final EventEnum SET_COST = new EventEnum("set cost");
/* 14 */   public static final EventEnum SET_CREATEDATE = new EventEnum("set createDate");
/* 15 */   public static final EventEnum SET_CREATEUSERID = new EventEnum("set createUserId");
/* 16 */   public static final EventEnum SET_UPDATEDATE = new EventEnum("set updateDate");
/* 17 */   public static final EventEnum SET_UPDATEUSERID = new EventEnum("set updateUserId");
/* 18 */   public static final EventEnum SET_ORGCODE = new EventEnum("set orgCode");
/* 19 */   public static final EventEnum SET_ORGVALUE = new EventEnum("set orgValue");
/* 20 */   public static final EventEnum SET_MINIMUMCOST = new EventEnum("set minimumCost");
/* 21 */   public static final EventEnum SET_MAXIMUMCOST = new EventEnum("set maximumCost");
/* 22 */   public static final EventEnum SET_ITEMID = new EventEnum("set itemId");
/* 23 */   public static final EventEnum ADD_PROPERTIES = new EventEnum("add Properties");
/* 24 */   public static final EventEnum REMOVE_PROPERTIES = new EventEnum("remove Properties");
/* 25 */   public static final EventEnum SET_PROPERTIES = new EventEnum("set Properties");
/* 26 */   public static final EventEnum START_TRANSACTION = new EventEnum("start transaction");
/* 27 */   public static final EventEnum ROLLBACK_TRANSACTION = new EventEnum("rollback transaction");
/* 28 */   public static final EventEnum COMMIT_TRANSACTION = new EventEnum("commit transaction");
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
/*    */   BigDecimal getMinimumCost();
/*    */   
/*    */   void setMinimumCost(BigDecimal paramBigDecimal);
/*    */   
/*    */   BigDecimal getMaximumCost();
/*    */   
/*    */   void setMaximumCost(BigDecimal paramBigDecimal);
/*    */   
/*    */   String getItemId();
/*    */   
/*    */   void setItemId(String paramString);
/*    */   
/*    */   IDataModel getShippingCostExt();
/*    */   
/*    */   void setShippingCostExt(IDataModel paramIDataModel);
/*    */   
/*    */   List<IShippingCostProperty> getProperties();
/*    */   
/*    */   void setProperties(List<IShippingCostProperty> paramList);
/*    */   
/*    */   void addShippingCostProperty(IShippingCostProperty paramIShippingCostProperty);
/*    */   
/*    */   void removeShippingCostProperty(IShippingCostProperty paramIShippingCostProperty);
/*    */   
/*    */   void startTransaction();
/*    */   
/*    */   void rollbackChanges();
/*    */   
/*    */   void commitTransaction();
/*    */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\com\IShippingCost.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */