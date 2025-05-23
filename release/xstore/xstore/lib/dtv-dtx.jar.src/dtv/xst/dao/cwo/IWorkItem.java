/*    */ package dtv.xst.dao.cwo;
/*    */ import dtv.data2.access.IDataModel;
/*    */ import dtv.event.EventEnum;
/*    */ import java.math.BigDecimal;
/*    */ import java.util.Date;
/*    */ import java.util.List;
/*    */ 
/*    */ public interface IWorkItem extends IDataModel, IWorkItemModel, IHasDataProperty<IWorkItemProperty> {
/*  9 */   public static final EventEnum SET_ORGANIZATIONID = new EventEnum("set organizationId");
/* 10 */   public static final EventEnum SET_CUSTACCOUNTID = new EventEnum("set custAccountId");
/* 11 */   public static final EventEnum SET_CUSTACCOUNTCODE = new EventEnum("set custAccountCode");
/* 12 */   public static final EventEnum SET_WORKITEMSEQUENCE = new EventEnum("set workItemSequence");
/* 13 */   public static final EventEnum SET_CREATEDATE = new EventEnum("set createDate");
/* 14 */   public static final EventEnum SET_CREATEUSERID = new EventEnum("set createUserId");
/* 15 */   public static final EventEnum SET_UPDATEDATE = new EventEnum("set updateDate");
/* 16 */   public static final EventEnum SET_UPDATEUSERID = new EventEnum("set updateUserId");
/* 17 */   public static final EventEnum SET_ITEMID = new EventEnum("set itemId");
/* 18 */   public static final EventEnum SET_DESCRIPTION = new EventEnum("set description");
/* 19 */   public static final EventEnum SET_VALUEAMOUNT = new EventEnum("set valueAmount");
/* 20 */   public static final EventEnum SET_WARRANTYNUMBER = new EventEnum("set warrantyNumber");
/* 21 */   public static final EventEnum SET_WORKITEMSERIALNUMBER = new EventEnum("set workItemSerialNumber");
/* 22 */   public static final EventEnum SET_VOID = new EventEnum("set void");
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
/*    */   String getCustAccountId();
/*    */   
/*    */   void setCustAccountId(String paramString);
/*    */   
/*    */   String getCustAccountCode();
/*    */   
/*    */   void setCustAccountCode(String paramString);
/*    */   
/*    */   int getWorkItemSequence();
/*    */   
/*    */   void setWorkItemSequence(int paramInt);
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
/*    */   String getItemId();
/*    */   
/*    */   void setItemId(String paramString);
/*    */   
/*    */   String getDescription();
/*    */   
/*    */   void setDescription(String paramString);
/*    */   
/*    */   BigDecimal getValueAmount();
/*    */   
/*    */   void setValueAmount(BigDecimal paramBigDecimal);
/*    */   
/*    */   String getWarrantyNumber();
/*    */   
/*    */   void setWarrantyNumber(String paramString);
/*    */   
/*    */   String getWorkItemSerialNumber();
/*    */   
/*    */   void setWorkItemSerialNumber(String paramString);
/*    */   
/*    */   boolean getVoid();
/*    */   
/*    */   void setVoid(boolean paramBoolean);
/*    */   
/*    */   IDataModel getWorkItemExt();
/*    */   
/*    */   void setWorkItemExt(IDataModel paramIDataModel);
/*    */   
/*    */   List<IWorkItemProperty> getProperties();
/*    */   
/*    */   void setProperties(List<IWorkItemProperty> paramList);
/*    */   
/*    */   void addWorkItemProperty(IWorkItemProperty paramIWorkItemProperty);
/*    */   
/*    */   void removeWorkItemProperty(IWorkItemProperty paramIWorkItemProperty);
/*    */   
/*    */   void setWorkOrderAccount(IWorkOrderAccount paramIWorkOrderAccount);
/*    */   
/*    */   IWorkOrderAccount getWorkOrderAccount();
/*    */   
/*    */   void startTransaction();
/*    */   
/*    */   void rollbackChanges();
/*    */   
/*    */   void commitTransaction();
/*    */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\cwo\IWorkItem.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */