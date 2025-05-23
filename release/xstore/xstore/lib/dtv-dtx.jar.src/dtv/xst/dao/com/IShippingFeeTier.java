/*    */ package dtv.xst.dao.com;
/*    */ import dtv.data2.access.IDataModel;
/*    */ import dtv.event.EventEnum;
/*    */ import java.math.BigDecimal;
/*    */ import java.util.Date;
/*    */ import java.util.List;
/*    */ 
/*    */ public interface IShippingFeeTier extends IDataModel, IHasDataProperty<IShippingFeeTierProperty> {
/*  9 */   public static final EventEnum SET_RULENAME = new EventEnum("set ruleName");
/* 10 */   public static final EventEnum SET_ORGANIZATIONID = new EventEnum("set organizationId");
/* 11 */   public static final EventEnum SET_PARENTRULENAME = new EventEnum("set parentRuleName");
/* 12 */   public static final EventEnum SET_CREATEDATE = new EventEnum("set createDate");
/* 13 */   public static final EventEnum SET_CREATEUSERID = new EventEnum("set createUserId");
/* 14 */   public static final EventEnum SET_UPDATEDATE = new EventEnum("set updateDate");
/* 15 */   public static final EventEnum SET_UPDATEUSERID = new EventEnum("set updateUserId");
/* 16 */   public static final EventEnum SET_ORGCODE = new EventEnum("set orgCode");
/* 17 */   public static final EventEnum SET_ORGVALUE = new EventEnum("set orgValue");
/* 18 */   public static final EventEnum SET_PRIORITY = new EventEnum("set priority");
/* 19 */   public static final EventEnum SET_FEETYPE = new EventEnum("set feeType");
/* 20 */   public static final EventEnum SET_FEEVALUE = new EventEnum("set feeValue");
/* 21 */   public static final EventEnum SET_SHIPMETHOD = new EventEnum("set shipMethod");
/* 22 */   public static final EventEnum SET_MINPRICE = new EventEnum("set minPrice");
/* 23 */   public static final EventEnum SET_MAXPRICE = new EventEnum("set maxPrice");
/* 24 */   public static final EventEnum SET_ITEMID = new EventEnum("set itemId");
/* 25 */   public static final EventEnum SET_RULETYPE = new EventEnum("set ruleType");
/* 26 */   public static final EventEnum SET_PARAM1 = new EventEnum("set param1");
/* 27 */   public static final EventEnum SET_PARAM2 = new EventEnum("set param2");
/* 28 */   public static final EventEnum ADD_PROPERTIES = new EventEnum("add Properties");
/* 29 */   public static final EventEnum REMOVE_PROPERTIES = new EventEnum("remove Properties");
/* 30 */   public static final EventEnum SET_PROPERTIES = new EventEnum("set Properties");
/* 31 */   public static final EventEnum START_TRANSACTION = new EventEnum("start transaction");
/* 32 */   public static final EventEnum ROLLBACK_TRANSACTION = new EventEnum("rollback transaction");
/* 33 */   public static final EventEnum COMMIT_TRANSACTION = new EventEnum("commit transaction");
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
/*    */   String getParentRuleName();
/*    */   
/*    */   void setParentRuleName(String paramString);
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
/*    */   String getFeeType();
/*    */   
/*    */   void setFeeType(String paramString);
/*    */   
/*    */   BigDecimal getFeeValue();
/*    */   
/*    */   void setFeeValue(BigDecimal paramBigDecimal);
/*    */   
/*    */   String getShipMethod();
/*    */   
/*    */   void setShipMethod(String paramString);
/*    */   
/*    */   BigDecimal getMinPrice();
/*    */   
/*    */   void setMinPrice(BigDecimal paramBigDecimal);
/*    */   
/*    */   BigDecimal getMaxPrice();
/*    */   
/*    */   void setMaxPrice(BigDecimal paramBigDecimal);
/*    */   
/*    */   String getItemId();
/*    */   
/*    */   void setItemId(String paramString);
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
/*    */   IDataModel getShippingFeeTierExt();
/*    */   
/*    */   void setShippingFeeTierExt(IDataModel paramIDataModel);
/*    */   
/*    */   List<IShippingFeeTierProperty> getProperties();
/*    */   
/*    */   void setProperties(List<IShippingFeeTierProperty> paramList);
/*    */   
/*    */   void addShippingFeeTierProperty(IShippingFeeTierProperty paramIShippingFeeTierProperty);
/*    */   
/*    */   void removeShippingFeeTierProperty(IShippingFeeTierProperty paramIShippingFeeTierProperty);
/*    */   
/*    */   void startTransaction();
/*    */   
/*    */   void rollbackChanges();
/*    */   
/*    */   void commitTransaction();
/*    */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\com\IShippingFeeTier.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */