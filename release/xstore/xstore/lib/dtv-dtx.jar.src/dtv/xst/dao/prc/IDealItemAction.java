/*    */ package dtv.xst.dao.prc;
/*    */ import dtv.data2.access.IDataModel;
/*    */ import dtv.event.EventEnum;
/*    */ import java.math.BigDecimal;
/*    */ import java.util.Date;
/*    */ import java.util.List;
/*    */ 
/*    */ public interface IDealItemAction extends IDataModel, IDealItemActionModel, IHasDataProperty<IDealItemActionProperty> {
/*  9 */   public static final EventEnum SET_ORGANIZATIONID = new EventEnum("set organizationId");
/* 10 */   public static final EventEnum SET_DEALID = new EventEnum("set dealId");
/* 11 */   public static final EventEnum SET_ORDINAL = new EventEnum("set ordinal");
/* 12 */   public static final EventEnum SET_ORGCODE = new EventEnum("set orgCode");
/* 13 */   public static final EventEnum SET_ORGVALUE = new EventEnum("set orgValue");
/* 14 */   public static final EventEnum SET_CREATEDATE = new EventEnum("set createDate");
/* 15 */   public static final EventEnum SET_CREATEUSERID = new EventEnum("set createUserId");
/* 16 */   public static final EventEnum SET_UPDATEDATE = new EventEnum("set updateDate");
/* 17 */   public static final EventEnum SET_UPDATEUSERID = new EventEnum("set updateUserId");
/* 18 */   public static final EventEnum SET_CONSUMABLE = new EventEnum("set consumable");
/* 19 */   public static final EventEnum SET_MINQTY = new EventEnum("set minQty");
/* 20 */   public static final EventEnum SET_MAXQTY = new EventEnum("set maxQty");
/* 21 */   public static final EventEnum SET_MINITEMTOTAL = new EventEnum("set minItemTotal");
/* 22 */   public static final EventEnum SET_ACTIONTYPE = new EventEnum("set actionType");
/* 23 */   public static final EventEnum SET_ACTIONARG = new EventEnum("set actionArg");
/* 24 */   public static final EventEnum SET_ACTIONARGQTY = new EventEnum("set actionArgQty");
/* 25 */   public static final EventEnum ADD_PROPERTIES = new EventEnum("add Properties");
/* 26 */   public static final EventEnum REMOVE_PROPERTIES = new EventEnum("remove Properties");
/* 27 */   public static final EventEnum SET_PROPERTIES = new EventEnum("set Properties");
/* 28 */   public static final EventEnum START_TRANSACTION = new EventEnum("start transaction");
/* 29 */   public static final EventEnum ROLLBACK_TRANSACTION = new EventEnum("rollback transaction");
/* 30 */   public static final EventEnum COMMIT_TRANSACTION = new EventEnum("commit transaction");
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
/*    */   int getOrdinal();
/*    */   
/*    */   void setOrdinal(int paramInt);
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
/*    */   boolean getConsumable();
/*    */   
/*    */   void setConsumable(boolean paramBoolean);
/*    */   
/*    */   BigDecimal getMinQty();
/*    */   
/*    */   void setMinQty(BigDecimal paramBigDecimal);
/*    */   
/*    */   BigDecimal getMaxQty();
/*    */   
/*    */   void setMaxQty(BigDecimal paramBigDecimal);
/*    */   
/*    */   BigDecimal getMinItemTotal();
/*    */   
/*    */   void setMinItemTotal(BigDecimal paramBigDecimal);
/*    */   
/*    */   String getActionType();
/*    */   
/*    */   void setActionType(String paramString);
/*    */   
/*    */   BigDecimal getActionArg();
/*    */   
/*    */   void setActionArg(BigDecimal paramBigDecimal);
/*    */   
/*    */   BigDecimal getActionArgQty();
/*    */   
/*    */   void setActionArgQty(BigDecimal paramBigDecimal);
/*    */   
/*    */   IDataModel getDealItemActionExt();
/*    */   
/*    */   void setDealItemActionExt(IDataModel paramIDataModel);
/*    */   
/*    */   List<IDealItemActionProperty> getProperties();
/*    */   
/*    */   void setProperties(List<IDealItemActionProperty> paramList);
/*    */   
/*    */   void addDealItemActionProperty(IDealItemActionProperty paramIDealItemActionProperty);
/*    */   
/*    */   void removeDealItemActionProperty(IDealItemActionProperty paramIDealItemActionProperty);
/*    */   
/*    */   void startTransaction();
/*    */   
/*    */   void rollbackChanges();
/*    */   
/*    */   void commitTransaction();
/*    */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\prc\IDealItemAction.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */