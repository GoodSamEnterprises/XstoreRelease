/*    */ package dtv.xst.dao.cwo;
/*    */ import dtv.data2.access.IDataAccessObject;
/*    */ import dtv.data2.access.IDataModel;
/*    */ import dtv.event.EventEnum;
/*    */ import java.util.Date;
/*    */ import java.util.List;
/*    */ 
/*    */ public interface IWorkOrderPriceCode extends IDataModel, IHasDataProperty<IWorkOrderPriceCodeProperty> {
/*  9 */   public static final EventEnum SET_ORGANIZATIONID = new EventEnum("set organizationId");
/* 10 */   public static final EventEnum SET_PRICECODE = new EventEnum("set priceCode");
/* 11 */   public static final EventEnum SET_CREATEDATE = new EventEnum("set createDate");
/* 12 */   public static final EventEnum SET_CREATEUSERID = new EventEnum("set createUserId");
/* 13 */   public static final EventEnum SET_UPDATEDATE = new EventEnum("set updateDate");
/* 14 */   public static final EventEnum SET_UPDATEUSERID = new EventEnum("set updateUserId");
/* 15 */   public static final EventEnum SET_ORGCODE = new EventEnum("set orgCode");
/* 16 */   public static final EventEnum SET_ORGVALUE = new EventEnum("set orgValue");
/* 17 */   public static final EventEnum SET_SORTORDER = new EventEnum("set sortOrder");
/* 18 */   public static final EventEnum SET_DESCRIPTION = new EventEnum("set description");
/* 19 */   public static final EventEnum SET_PROMPTFORWARRANTYNUMBER = new EventEnum("set promptForWarrantyNumber");
/* 20 */   public static final EventEnum ADD_PROPERTIES = new EventEnum("add Properties");
/* 21 */   public static final EventEnum REMOVE_PROPERTIES = new EventEnum("remove Properties");
/* 22 */   public static final EventEnum SET_PROPERTIES = new EventEnum("set Properties");
/* 23 */   public static final EventEnum START_TRANSACTION = new EventEnum("start transaction");
/* 24 */   public static final EventEnum ROLLBACK_TRANSACTION = new EventEnum("rollback transaction");
/* 25 */   public static final EventEnum COMMIT_TRANSACTION = new EventEnum("commit transaction");
/*    */   
/*    */   void setDAO(IDataAccessObject paramIDataAccessObject);
/*    */   
/*    */   long getOrganizationId();
/*    */   
/*    */   void setOrganizationId(long paramLong);
/*    */   
/*    */   String getPriceCode();
/*    */   
/*    */   void setPriceCode(String paramString);
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
/*    */   int getSortOrder();
/*    */   
/*    */   void setSortOrder(int paramInt);
/*    */   
/*    */   String getDescription();
/*    */   
/*    */   void setDescription(String paramString);
/*    */   
/*    */   boolean getPromptForWarrantyNumber();
/*    */   
/*    */   void setPromptForWarrantyNumber(boolean paramBoolean);
/*    */   
/*    */   IDataModel getWorkOrderPriceCodeExt();
/*    */   
/*    */   void setWorkOrderPriceCodeExt(IDataModel paramIDataModel);
/*    */   
/*    */   List<IWorkOrderPriceCodeProperty> getProperties();
/*    */   
/*    */   void setProperties(List<IWorkOrderPriceCodeProperty> paramList);
/*    */   
/*    */   void addWorkOrderPriceCodeProperty(IWorkOrderPriceCodeProperty paramIWorkOrderPriceCodeProperty);
/*    */   
/*    */   void removeWorkOrderPriceCodeProperty(IWorkOrderPriceCodeProperty paramIWorkOrderPriceCodeProperty);
/*    */   
/*    */   void startTransaction();
/*    */   
/*    */   void rollbackChanges();
/*    */   
/*    */   void commitTransaction();
/*    */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\cwo\IWorkOrderPriceCode.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */