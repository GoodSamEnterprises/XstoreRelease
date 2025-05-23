/*    */ package dtv.xst.dao.itm;
/*    */ import dtv.data2.access.IDataModel;
/*    */ import dtv.event.EventEnum;
/*    */ import java.math.BigDecimal;
/*    */ import java.util.Date;
/*    */ import java.util.List;
/*    */ 
/*    */ public interface IItemLabelBatch extends IDataModel, IHasDataProperty<IItemLabelBatchProperty> {
/*  9 */   public static final EventEnum SET_ORGANIZATIONID = new EventEnum("set organizationId");
/* 10 */   public static final EventEnum SET_RETAILLOCATIONID = new EventEnum("set retailLocationId");
/* 11 */   public static final EventEnum SET_BATCHNAME = new EventEnum("set batchName");
/* 12 */   public static final EventEnum SET_ITEMID = new EventEnum("set itemId");
/* 13 */   public static final EventEnum SET_STOCKLABEL = new EventEnum("set stockLabel");
/* 14 */   public static final EventEnum SET_CREATEDATE = new EventEnum("set createDate");
/* 15 */   public static final EventEnum SET_CREATEUSERID = new EventEnum("set createUserId");
/* 16 */   public static final EventEnum SET_UPDATEDATE = new EventEnum("set updateDate");
/* 17 */   public static final EventEnum SET_UPDATEUSERID = new EventEnum("set updateUserId");
/* 18 */   public static final EventEnum SET_COUNT = new EventEnum("set count");
/* 19 */   public static final EventEnum SET_OVERRIDENPRICE = new EventEnum("set overridenPrice");
/* 20 */   public static final EventEnum SET_ITEM = new EventEnum("set Item");
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
/*    */   long getRetailLocationId();
/*    */   
/*    */   void setRetailLocationId(long paramLong);
/*    */   
/*    */   String getBatchName();
/*    */   
/*    */   void setBatchName(String paramString);
/*    */   
/*    */   String getItemId();
/*    */   
/*    */   void setItemId(String paramString);
/*    */   
/*    */   String getStockLabel();
/*    */   
/*    */   void setStockLabel(String paramString);
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
/*    */   long getCount();
/*    */   
/*    */   void setCount(long paramLong);
/*    */   
/*    */   BigDecimal getOverridenPrice();
/*    */   
/*    */   void setOverridenPrice(BigDecimal paramBigDecimal);
/*    */   
/*    */   IDataModel getItemLabelBatchExt();
/*    */   
/*    */   void setItemLabelBatchExt(IDataModel paramIDataModel);
/*    */   
/*    */   IItem getItem();
/*    */   
/*    */   void setItem(IItem paramIItem);
/*    */   
/*    */   List<IItemLabelBatchProperty> getProperties();
/*    */   
/*    */   void setProperties(List<IItemLabelBatchProperty> paramList);
/*    */   
/*    */   void addItemLabelBatchProperty(IItemLabelBatchProperty paramIItemLabelBatchProperty);
/*    */   
/*    */   void removeItemLabelBatchProperty(IItemLabelBatchProperty paramIItemLabelBatchProperty);
/*    */   
/*    */   void startTransaction();
/*    */   
/*    */   void rollbackChanges();
/*    */   
/*    */   void commitTransaction();
/*    */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\itm\IItemLabelBatch.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */