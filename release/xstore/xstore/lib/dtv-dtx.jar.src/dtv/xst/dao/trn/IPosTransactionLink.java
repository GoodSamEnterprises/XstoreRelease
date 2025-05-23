/*    */ package dtv.xst.dao.trn;
/*    */ import dtv.data2.access.IDataAccessObject;
/*    */ import dtv.data2.access.IDataModel;
/*    */ import dtv.event.EventEnum;
/*    */ import java.util.Date;
/*    */ import java.util.List;
/*    */ 
/*    */ public interface IPosTransactionLink extends IDataModel, IHasDataProperty<IPosTransactionLinkProperty> {
/*  9 */   public static final EventEnum SET_BUSINESSDATE = new EventEnum("set businessDate");
/* 10 */   public static final EventEnum SET_LINKBUSINESSDATE = new EventEnum("set linkBusinessDate");
/* 11 */   public static final EventEnum SET_LINKRETAILLOCATIONID = new EventEnum("set linkRetailLocationId");
/* 12 */   public static final EventEnum SET_LINKTRANSACTIONSEQUENCE = new EventEnum("set linkTransactionSequence");
/* 13 */   public static final EventEnum SET_LINKWORKSTATIONID = new EventEnum("set linkWorkstationId");
/* 14 */   public static final EventEnum SET_ORGANIZATIONID = new EventEnum("set organizationId");
/* 15 */   public static final EventEnum SET_RETAILLOCATIONID = new EventEnum("set retailLocationId");
/* 16 */   public static final EventEnum SET_TRANSACTIONSEQUENCE = new EventEnum("set transactionSequence");
/* 17 */   public static final EventEnum SET_WORKSTATIONID = new EventEnum("set workstationId");
/* 18 */   public static final EventEnum SET_CREATEDATE = new EventEnum("set createDate");
/* 19 */   public static final EventEnum SET_CREATEUSERID = new EventEnum("set createUserId");
/* 20 */   public static final EventEnum SET_UPDATEDATE = new EventEnum("set updateDate");
/* 21 */   public static final EventEnum SET_UPDATEUSERID = new EventEnum("set updateUserId");
/* 22 */   public static final EventEnum SET_LINKTYPECODE = new EventEnum("set linkTypeCode");
/* 23 */   public static final EventEnum SET_LINKEDTRANSACTION = new EventEnum("set LinkedTransaction");
/* 24 */   public static final EventEnum ADD_PROPERTIES = new EventEnum("add Properties");
/* 25 */   public static final EventEnum REMOVE_PROPERTIES = new EventEnum("remove Properties");
/* 26 */   public static final EventEnum SET_PROPERTIES = new EventEnum("set Properties");
/* 27 */   public static final EventEnum START_TRANSACTION = new EventEnum("start transaction");
/* 28 */   public static final EventEnum ROLLBACK_TRANSACTION = new EventEnum("rollback transaction");
/* 29 */   public static final EventEnum COMMIT_TRANSACTION = new EventEnum("commit transaction");
/*    */   
/*    */   void setDAO(IDataAccessObject paramIDataAccessObject);
/*    */   
/*    */   Date getBusinessDate();
/*    */   
/*    */   void setBusinessDate(Date paramDate);
/*    */   
/*    */   Date getLinkBusinessDate();
/*    */   
/*    */   void setLinkBusinessDate(Date paramDate);
/*    */   
/*    */   long getLinkRetailLocationId();
/*    */   
/*    */   void setLinkRetailLocationId(long paramLong);
/*    */   
/*    */   long getLinkTransactionSequence();
/*    */   
/*    */   void setLinkTransactionSequence(long paramLong);
/*    */   
/*    */   long getLinkWorkstationId();
/*    */   
/*    */   void setLinkWorkstationId(long paramLong);
/*    */   
/*    */   long getOrganizationId();
/*    */   
/*    */   void setOrganizationId(long paramLong);
/*    */   
/*    */   long getRetailLocationId();
/*    */   
/*    */   void setRetailLocationId(long paramLong);
/*    */   
/*    */   long getTransactionSequence();
/*    */   
/*    */   void setTransactionSequence(long paramLong);
/*    */   
/*    */   long getWorkstationId();
/*    */   
/*    */   void setWorkstationId(long paramLong);
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
/*    */   String getLinkTypeCode();
/*    */   
/*    */   void setLinkTypeCode(String paramString);
/*    */   
/*    */   IDataModel getPosTransactionLinkExt();
/*    */   
/*    */   void setPosTransactionLinkExt(IDataModel paramIDataModel);
/*    */   
/*    */   IPosTransaction getLinkedTransaction();
/*    */   
/*    */   void setLinkedTransaction(IPosTransaction paramIPosTransaction);
/*    */   
/*    */   List<IPosTransactionLinkProperty> getProperties();
/*    */   
/*    */   void setProperties(List<IPosTransactionLinkProperty> paramList);
/*    */   
/*    */   void addPosTransactionLinkProperty(IPosTransactionLinkProperty paramIPosTransactionLinkProperty);
/*    */   
/*    */   void removePosTransactionLinkProperty(IPosTransactionLinkProperty paramIPosTransactionLinkProperty);
/*    */   
/*    */   void setParentTransaction(IPosTransaction paramIPosTransaction);
/*    */   
/*    */   IPosTransaction getParentTransaction();
/*    */   
/*    */   void startTransaction();
/*    */   
/*    */   void rollbackChanges();
/*    */   
/*    */   void commitTransaction();
/*    */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\trn\IPosTransactionLink.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */