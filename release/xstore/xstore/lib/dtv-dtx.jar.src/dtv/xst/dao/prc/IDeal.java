/*    */ package dtv.xst.dao.prc;
/*    */ import dtv.data2.access.IDataModel;
/*    */ import dtv.event.EventEnum;
/*    */ import java.math.BigDecimal;
/*    */ import java.util.Date;
/*    */ import java.util.List;
/*    */ 
/*    */ public interface IDeal extends IDataModel, IDealModel, IHasDataProperty<IDealProperty> {
/*  9 */   public static final EventEnum SET_ORGANIZATIONID = new EventEnum("set organizationId");
/* 10 */   public static final EventEnum SET_DEALID = new EventEnum("set dealId");
/* 11 */   public static final EventEnum SET_ORGCODE = new EventEnum("set orgCode");
/* 12 */   public static final EventEnum SET_ORGVALUE = new EventEnum("set orgValue");
/* 13 */   public static final EventEnum SET_CREATEDATE = new EventEnum("set createDate");
/* 14 */   public static final EventEnum SET_CREATEUSERID = new EventEnum("set createUserId");
/* 15 */   public static final EventEnum SET_UPDATEDATE = new EventEnum("set updateDate");
/* 16 */   public static final EventEnum SET_UPDATEUSERID = new EventEnum("set updateUserId");
/* 17 */   public static final EventEnum SET_DESCRIPTION = new EventEnum("set description");
/* 18 */   public static final EventEnum SET_CONSUMABLE = new EventEnum("set consumable");
/* 19 */   public static final EventEnum SET_DEFERRED = new EventEnum("set deferred");
/* 20 */   public static final EventEnum SET_EFFECTIVEDATE = new EventEnum("set effectiveDate");
/* 21 */   public static final EventEnum SET_ENDDATE = new EventEnum("set endDate");
/* 22 */   public static final EventEnum SET_STARTTIME = new EventEnum("set startTime");
/* 23 */   public static final EventEnum SET_ENDTIME = new EventEnum("set endTime");
/* 24 */   public static final EventEnum SET_GENEROSITYCAP = new EventEnum("set generosityCap");
/* 25 */   public static final EventEnum SET_ITERATIONCAP = new EventEnum("set iterationCap");
/* 26 */   public static final EventEnum SET_PRIORITYNUDGE = new EventEnum("set priorityNudge");
/* 27 */   public static final EventEnum SET_MINIMUMSUBTOTAL = new EventEnum("set minimumSubtotal");
/* 28 */   public static final EventEnum SET_MAXIMUMSUBTOTAL = new EventEnum("set maximumSubtotal");
/* 29 */   public static final EventEnum SET_TRANSACTIONTYPE = new EventEnum("set transActionType");
/* 30 */   public static final EventEnum SET_TRANSACTIONAMOUNT = new EventEnum("set transActionAmount");
/* 31 */   public static final EventEnum SET_TAXABILITYCODE = new EventEnum("set taxabilityCode");
/* 32 */   public static final EventEnum SET_HIGHERNONACTIONAMT = new EventEnum("set higherNonactionAmt");
/* 33 */   public static final EventEnum SET_EXCLUDEPRICEOVERRIDE = new EventEnum("set excludePriceOverride");
/* 34 */   public static final EventEnum SET_EXCLUDEDISCOUNTED = new EventEnum("set excludeDiscounted");
/* 35 */   public static final EventEnum SET_USEWEEKSCHEDULE = new EventEnum("set useWeekSchedule");
/* 36 */   public static final EventEnum SET_TARGETED = new EventEnum("set targeted");
/* 37 */   public static final EventEnum SET_PROMOTIONID = new EventEnum("set promotionId");
/* 38 */   public static final EventEnum SET_SORTORDER = new EventEnum("set sortOrder");
/* 39 */   public static final EventEnum SET_TYPE = new EventEnum("set type");
/* 40 */   public static final EventEnum SET_GROUPID = new EventEnum("set groupId");
/* 41 */   public static final EventEnum ADD_ITEMS = new EventEnum("add Items");
/* 42 */   public static final EventEnum REMOVE_ITEMS = new EventEnum("remove Items");
/* 43 */   public static final EventEnum SET_ITEMS = new EventEnum("set Items");
/* 44 */   public static final EventEnum ADD_CUSTOMERGROUPS = new EventEnum("add CustomerGroups");
/* 45 */   public static final EventEnum REMOVE_CUSTOMERGROUPS = new EventEnum("remove CustomerGroups");
/* 46 */   public static final EventEnum SET_CUSTOMERGROUPS = new EventEnum("set CustomerGroups");
/* 47 */   public static final EventEnum ADD_TRIGGERS = new EventEnum("add Triggers");
/* 48 */   public static final EventEnum REMOVE_TRIGGERS = new EventEnum("remove Triggers");
/* 49 */   public static final EventEnum SET_TRIGGERS = new EventEnum("set Triggers");
/* 50 */   public static final EventEnum ADD_PROPERTIES = new EventEnum("add Properties");
/* 51 */   public static final EventEnum REMOVE_PROPERTIES = new EventEnum("remove Properties");
/* 52 */   public static final EventEnum SET_PROPERTIES = new EventEnum("set Properties");
/* 53 */   public static final EventEnum START_TRANSACTION = new EventEnum("start transaction");
/* 54 */   public static final EventEnum ROLLBACK_TRANSACTION = new EventEnum("rollback transaction");
/* 55 */   public static final EventEnum COMMIT_TRANSACTION = new EventEnum("commit transaction");
/*    */   
/*    */   void setDAO(IDataAccessObject paramIDataAccessObject);
/*    */   
/*    */   long getOrganizationId();
/*    */   
/*    */   void setOrganizationId(long paramLong);
/*    */   
/*    */   String getDealId();
/*    */   
/*    */   void setDealId(String paramString);
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
/*    */   String getDescription();
/*    */   
/*    */   void setDescription(String paramString);
/*    */   
/*    */   boolean getConsumable();
/*    */   
/*    */   void setConsumable(boolean paramBoolean);
/*    */   
/*    */   boolean getDeferred();
/*    */   
/*    */   void setDeferred(boolean paramBoolean);
/*    */   
/*    */   Date getEffectiveDate();
/*    */   
/*    */   void setEffectiveDate(Date paramDate);
/*    */   
/*    */   Date getEndDate();
/*    */   
/*    */   void setEndDate(Date paramDate);
/*    */   
/*    */   Date getStartTime();
/*    */   
/*    */   void setStartTime(Date paramDate);
/*    */   
/*    */   Date getEndTime();
/*    */   
/*    */   void setEndTime(Date paramDate);
/*    */   
/*    */   BigDecimal getGenerosityCap();
/*    */   
/*    */   void setGenerosityCap(BigDecimal paramBigDecimal);
/*    */   
/*    */   int getIterationCap();
/*    */   
/*    */   void setIterationCap(int paramInt);
/*    */   
/*    */   int getPriorityNudge();
/*    */   
/*    */   void setPriorityNudge(int paramInt);
/*    */   
/*    */   BigDecimal getMinimumSubtotal();
/*    */   
/*    */   void setMinimumSubtotal(BigDecimal paramBigDecimal);
/*    */   
/*    */   BigDecimal getMaximumSubtotal();
/*    */   
/*    */   void setMaximumSubtotal(BigDecimal paramBigDecimal);
/*    */   
/*    */   String getTransActionType();
/*    */   
/*    */   void setTransActionType(String paramString);
/*    */   
/*    */   BigDecimal getTransActionAmount();
/*    */   
/*    */   void setTransActionAmount(BigDecimal paramBigDecimal);
/*    */   
/*    */   String getTaxabilityCode();
/*    */   
/*    */   void setTaxabilityCode(String paramString);
/*    */   
/*    */   boolean getHigherNonactionAmt();
/*    */   
/*    */   void setHigherNonactionAmt(boolean paramBoolean);
/*    */   
/*    */   boolean getExcludePriceOverride();
/*    */   
/*    */   void setExcludePriceOverride(boolean paramBoolean);
/*    */   
/*    */   boolean getExcludeDiscounted();
/*    */   
/*    */   void setExcludeDiscounted(boolean paramBoolean);
/*    */   
/*    */   boolean getUseWeekSchedule();
/*    */   
/*    */   void setUseWeekSchedule(boolean paramBoolean);
/*    */   
/*    */   boolean getTargeted();
/*    */   
/*    */   void setTargeted(boolean paramBoolean);
/*    */   
/*    */   String getPromotionId();
/*    */   
/*    */   void setPromotionId(String paramString);
/*    */   
/*    */   int getSortOrder();
/*    */   
/*    */   void setSortOrder(int paramInt);
/*    */   
/*    */   String getType();
/*    */   
/*    */   void setType(String paramString);
/*    */   
/*    */   String getGroupId();
/*    */   
/*    */   void setGroupId(String paramString);
/*    */   
/*    */   IDataModel getDealExt();
/*    */   
/*    */   void setDealExt(IDataModel paramIDataModel);
/*    */   
/*    */   List<IDealItemAction> getItems();
/*    */   
/*    */   void setItems(List<IDealItemAction> paramList);
/*    */   
/*    */   void addDealItemAction(IDealItemAction paramIDealItemAction);
/*    */   
/*    */   void removeDealItemAction(IDealItemAction paramIDealItemAction);
/*    */   
/*    */   List<IDealCustomerGroups> getCustomerGroups();
/*    */   
/*    */   void setCustomerGroups(List<IDealCustomerGroups> paramList);
/*    */   
/*    */   void addDealCustomerGroups(IDealCustomerGroups paramIDealCustomerGroups);
/*    */   
/*    */   void removeDealCustomerGroups(IDealCustomerGroups paramIDealCustomerGroups);
/*    */   
/*    */   List<IDealTrigger> getTriggers();
/*    */   
/*    */   void setTriggers(List<IDealTrigger> paramList);
/*    */   
/*    */   void addDealTrigger(IDealTrigger paramIDealTrigger);
/*    */   
/*    */   void removeDealTrigger(IDealTrigger paramIDealTrigger);
/*    */   
/*    */   List<IDealProperty> getProperties();
/*    */   
/*    */   void setProperties(List<IDealProperty> paramList);
/*    */   
/*    */   void addDealProperty(IDealProperty paramIDealProperty);
/*    */   
/*    */   void removeDealProperty(IDealProperty paramIDealProperty);
/*    */   
/*    */   void startTransaction();
/*    */   
/*    */   void rollbackChanges();
/*    */   
/*    */   void commitTransaction();
/*    */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\prc\IDeal.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */