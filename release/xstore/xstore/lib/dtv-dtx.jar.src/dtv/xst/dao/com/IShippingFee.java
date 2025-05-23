/*    */ package dtv.xst.dao.com;
/*    */ import dtv.data2.access.IDataAccessObject;
/*    */ import dtv.data2.access.IDataModel;
/*    */ import dtv.event.EventEnum;
/*    */ import java.util.Date;
/*    */ import java.util.List;
/*    */ 
/*    */ public interface IShippingFee extends IDataModel, IHasDataProperty<IShippingFeeProperty> {
/*  9 */   public static final EventEnum SET_RULENAME = new EventEnum("set ruleName");
/* 10 */   public static final EventEnum SET_ORGANIZATIONID = new EventEnum("set organizationId");
/* 11 */   public static final EventEnum SET_CREATEDATE = new EventEnum("set createDate");
/* 12 */   public static final EventEnum SET_CREATEUSERID = new EventEnum("set createUserId");
/* 13 */   public static final EventEnum SET_UPDATEDATE = new EventEnum("set updateDate");
/* 14 */   public static final EventEnum SET_UPDATEUSERID = new EventEnum("set updateUserId");
/* 15 */   public static final EventEnum SET_ORGCODE = new EventEnum("set orgCode");
/* 16 */   public static final EventEnum SET_ORGVALUE = new EventEnum("set orgValue");
/* 17 */   public static final EventEnum SET_PRIORITY = new EventEnum("set priority");
/* 18 */   public static final EventEnum SET_SHIPITEMID = new EventEnum("set shipItemID");
/* 19 */   public static final EventEnum SET_AGGREGATIONTYPE = new EventEnum("set aggregationType");
/* 20 */   public static final EventEnum SET_RULETYPE = new EventEnum("set ruleType");
/* 21 */   public static final EventEnum SET_PARAM1 = new EventEnum("set param1");
/* 22 */   public static final EventEnum SET_PARAM2 = new EventEnum("set param2");
/* 23 */   public static final EventEnum ADD_TIEREDFEES = new EventEnum("add TieredFees");
/* 24 */   public static final EventEnum REMOVE_TIEREDFEES = new EventEnum("remove TieredFees");
/* 25 */   public static final EventEnum SET_TIEREDFEES = new EventEnum("set TieredFees");
/* 26 */   public static final EventEnum ADD_PROPERTIES = new EventEnum("add Properties");
/* 27 */   public static final EventEnum REMOVE_PROPERTIES = new EventEnum("remove Properties");
/* 28 */   public static final EventEnum SET_PROPERTIES = new EventEnum("set Properties");
/* 29 */   public static final EventEnum START_TRANSACTION = new EventEnum("start transaction");
/* 30 */   public static final EventEnum ROLLBACK_TRANSACTION = new EventEnum("rollback transaction");
/* 31 */   public static final EventEnum COMMIT_TRANSACTION = new EventEnum("commit transaction");
/*    */   
/*    */   void setDAO(IDataAccessObject paramIDataAccessObject);
/*    */   
/*    */   String getRuleName();
/*    */   
/*    */   void setRuleName(String paramString);
/*    */   
/*    */   long getOrganizationId();
/*    */   
/*    */   void setOrganizationId(long paramLong);
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
/*    */   long getPriority();
/*    */   
/*    */   void setPriority(long paramLong);
/*    */   
/*    */   String getShipItemID();
/*    */   
/*    */   void setShipItemID(String paramString);
/*    */   
/*    */   String getAggregationType();
/*    */   
/*    */   void setAggregationType(String paramString);
/*    */   
/*    */   String getRuleType();
/*    */   
/*    */   void setRuleType(String paramString);
/*    */   
/*    */   String getParam1();
/*    */   
/*    */   void setParam1(String paramString);
/*    */   
/*    */   String getParam2();
/*    */   
/*    */   void setParam2(String paramString);
/*    */   
/*    */   IDataModel getShippingFeeExt();
/*    */   
/*    */   void setShippingFeeExt(IDataModel paramIDataModel);
/*    */   
/*    */   List<IShippingFeeTier> getTieredFees();
/*    */   
/*    */   void setTieredFees(List<IShippingFeeTier> paramList);
/*    */   
/*    */   void addShippingFeeTier(IShippingFeeTier paramIShippingFeeTier);
/*    */   
/*    */   void removeShippingFeeTier(IShippingFeeTier paramIShippingFeeTier);
/*    */   
/*    */   List<IShippingFeeProperty> getProperties();
/*    */   
/*    */   void setProperties(List<IShippingFeeProperty> paramList);
/*    */   
/*    */   void addShippingFeeProperty(IShippingFeeProperty paramIShippingFeeProperty);
/*    */   
/*    */   void removeShippingFeeProperty(IShippingFeeProperty paramIShippingFeeProperty);
/*    */   
/*    */   void startTransaction();
/*    */   
/*    */   void rollbackChanges();
/*    */   
/*    */   void commitTransaction();
/*    */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\com\IShippingFee.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */