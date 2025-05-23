/*    */ package dtv.xst.dao.inv;
/*    */ import dtv.data2.access.IDataModel;
/*    */ import dtv.event.EventEnum;
/*    */ import java.math.BigDecimal;
/*    */ import java.util.Date;
/*    */ import java.util.List;
/*    */ 
/*    */ public interface IInventoryCostItemYearEnd extends IDataModel, IHasDataProperty<IInventoryCostItemYearEndProperty> {
/*  9 */   public static final EventEnum SET_ORGANIZATIONID = new EventEnum("set organizationId");
/* 10 */   public static final EventEnum SET_FISCALYEAR = new EventEnum("set fiscalYear");
/* 11 */   public static final EventEnum SET_RETAILLOCATIONID = new EventEnum("set retailLocationId");
/* 12 */   public static final EventEnum SET_ITEMID = new EventEnum("set itemId");
/* 13 */   public static final EventEnum SET_CREATEDATE = new EventEnum("set createDate");
/* 14 */   public static final EventEnum SET_CREATEUSERID = new EventEnum("set createUserId");
/* 15 */   public static final EventEnum SET_UPDATEDATE = new EventEnum("set updateDate");
/* 16 */   public static final EventEnum SET_UPDATEUSERID = new EventEnum("set updateUserId");
/* 17 */   public static final EventEnum SET_WACQUANTITYRECEIVED = new EventEnum("set wacQuantityReceived");
/* 18 */   public static final EventEnum SET_WACVALUERECEIVED = new EventEnum("set wacValueReceived");
/* 19 */   public static final EventEnum SET_PWACQUANTITYONHANDENDOFYEAR = new EventEnum("set pwacQuantityOnhandEndofyear");
/* 20 */   public static final EventEnum SET_PWACVALUEONHANDENDOFYEAR = new EventEnum("set pwacValueOnhandEndofyear");
/* 21 */   public static final EventEnum ADD_PROPERTIES = new EventEnum("add Properties");
/* 22 */   public static final EventEnum REMOVE_PROPERTIES = new EventEnum("remove Properties");
/* 23 */   public static final EventEnum SET_PROPERTIES = new EventEnum("set Properties");
/* 24 */   public static final EventEnum START_TRANSACTION = new EventEnum("start transaction");
/* 25 */   public static final EventEnum ROLLBACK_TRANSACTION = new EventEnum("rollback transaction");
/* 26 */   public static final EventEnum COMMIT_TRANSACTION = new EventEnum("commit transaction");
/*    */   
/*    */   void setDAO(IDataAccessObject paramIDataAccessObject);
/*    */   
/*    */   long getOrganizationId();
/*    */   
/*    */   void setOrganizationId(long paramLong);
/*    */   
/*    */   int getFiscalYear();
/*    */   
/*    */   void setFiscalYear(int paramInt);
/*    */   
/*    */   long getRetailLocationId();
/*    */   
/*    */   void setRetailLocationId(long paramLong);
/*    */   
/*    */   String getItemId();
/*    */   
/*    */   void setItemId(String paramString);
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
/*    */   BigDecimal getWacQuantityReceived();
/*    */   
/*    */   void setWacQuantityReceived(BigDecimal paramBigDecimal);
/*    */   
/*    */   BigDecimal getWacValueReceived();
/*    */   
/*    */   void setWacValueReceived(BigDecimal paramBigDecimal);
/*    */   
/*    */   BigDecimal getPwacQuantityOnhandEndofyear();
/*    */   
/*    */   void setPwacQuantityOnhandEndofyear(BigDecimal paramBigDecimal);
/*    */   
/*    */   BigDecimal getPwacValueOnhandEndofyear();
/*    */   
/*    */   void setPwacValueOnhandEndofyear(BigDecimal paramBigDecimal);
/*    */   
/*    */   IDataModel getInventoryCostItemYearEndExt();
/*    */   
/*    */   void setInventoryCostItemYearEndExt(IDataModel paramIDataModel);
/*    */   
/*    */   List<IInventoryCostItemYearEndProperty> getProperties();
/*    */   
/*    */   void setProperties(List<IInventoryCostItemYearEndProperty> paramList);
/*    */   
/*    */   void addInventoryCostItemYearEndProperty(IInventoryCostItemYearEndProperty paramIInventoryCostItemYearEndProperty);
/*    */   
/*    */   void removeInventoryCostItemYearEndProperty(IInventoryCostItemYearEndProperty paramIInventoryCostItemYearEndProperty);
/*    */   
/*    */   void startTransaction();
/*    */   
/*    */   void rollbackChanges();
/*    */   
/*    */   void commitTransaction();
/*    */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\inv\IInventoryCostItemYearEnd.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */