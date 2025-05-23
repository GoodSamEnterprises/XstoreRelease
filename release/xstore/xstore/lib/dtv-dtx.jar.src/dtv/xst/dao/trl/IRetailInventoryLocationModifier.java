/*    */ package dtv.xst.dao.trl;
/*    */ import dtv.data2.access.IDataModel;
/*    */ import dtv.event.EventEnum;
/*    */ import java.math.BigDecimal;
/*    */ import java.util.Date;
/*    */ import java.util.List;
/*    */ 
/*    */ public interface IRetailInventoryLocationModifier extends IDataModel, IRetailInventoryLocationModifierModel, IHasDataProperty<IRetailInventoryLocationModifierProperty> {
/*  9 */   public static final EventEnum SET_ORGANIZATIONID = new EventEnum("set organizationId");
/* 10 */   public static final EventEnum SET_RETAILLOCATIONID = new EventEnum("set retailLocationId");
/* 11 */   public static final EventEnum SET_WORKSTATIONID = new EventEnum("set workstationId");
/* 12 */   public static final EventEnum SET_BUSINESSDATE = new EventEnum("set businessDate");
/* 13 */   public static final EventEnum SET_TRANSACTIONSEQUENCE = new EventEnum("set transactionSequence");
/* 14 */   public static final EventEnum SET_TRANSACTIONLINEITEMSEQUENCE = new EventEnum("set transactionLineItemSequence");
/* 15 */   public static final EventEnum SET_MODIFIERSEQUENCE = new EventEnum("set modifierSequence");
/* 16 */   public static final EventEnum SET_CREATEDATE = new EventEnum("set createDate");
/* 17 */   public static final EventEnum SET_CREATEUSERID = new EventEnum("set createUserId");
/* 18 */   public static final EventEnum SET_UPDATEDATE = new EventEnum("set updateDate");
/* 19 */   public static final EventEnum SET_UPDATEUSERID = new EventEnum("set updateUserId");
/* 20 */   public static final EventEnum SET_SERIALNUMBER = new EventEnum("set serialNumber");
/* 21 */   public static final EventEnum SET_SOURCELOCATIONID = new EventEnum("set sourceLocationId");
/* 22 */   public static final EventEnum SET_SOURCEBUCKETID = new EventEnum("set sourceBucketId");
/* 23 */   public static final EventEnum SET_DESTINATIONLOCATIONID = new EventEnum("set destinationLocationId");
/* 24 */   public static final EventEnum SET_DESTINATIONBUCKETID = new EventEnum("set destinationBucketId");
/* 25 */   public static final EventEnum SET_ITEMID = new EventEnum("set itemId");
/* 26 */   public static final EventEnum SET_QUANTITY = new EventEnum("set quantity");
/* 27 */   public static final EventEnum SET_ACTIONCODE = new EventEnum("set actionCode");
/* 28 */   public static final EventEnum SET_VOID = new EventEnum("set void");
/* 29 */   public static final EventEnum ADD_PROPERTIES = new EventEnum("add Properties");
/* 30 */   public static final EventEnum REMOVE_PROPERTIES = new EventEnum("remove Properties");
/* 31 */   public static final EventEnum SET_PROPERTIES = new EventEnum("set Properties");
/* 32 */   public static final EventEnum START_TRANSACTION = new EventEnum("start transaction");
/* 33 */   public static final EventEnum ROLLBACK_TRANSACTION = new EventEnum("rollback transaction");
/* 34 */   public static final EventEnum COMMIT_TRANSACTION = new EventEnum("commit transaction");
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
/*    */   long getWorkstationId();
/*    */   
/*    */   void setWorkstationId(long paramLong);
/*    */   
/*    */   Date getBusinessDate();
/*    */   
/*    */   void setBusinessDate(Date paramDate);
/*    */   
/*    */   long getTransactionSequence();
/*    */   
/*    */   void setTransactionSequence(long paramLong);
/*    */   
/*    */   long getTransactionLineItemSequence();
/*    */   
/*    */   void setTransactionLineItemSequence(long paramLong);
/*    */   
/*    */   long getModifierSequence();
/*    */   
/*    */   void setModifierSequence(long paramLong);
/*    */   
/*    */   String getSerialNumber();
/*    */   
/*    */   void setSerialNumber(String paramString);
/*    */   
/*    */   String getSourceLocationId();
/*    */   
/*    */   void setSourceLocationId(String paramString);
/*    */   
/*    */   String getSourceBucketId();
/*    */   
/*    */   void setSourceBucketId(String paramString);
/*    */   
/*    */   String getDestinationLocationId();
/*    */   
/*    */   void setDestinationLocationId(String paramString);
/*    */   
/*    */   String getDestinationBucketId();
/*    */   
/*    */   void setDestinationBucketId(String paramString);
/*    */   
/*    */   String getItemId();
/*    */   
/*    */   void setItemId(String paramString);
/*    */   
/*    */   BigDecimal getQuantity();
/*    */   
/*    */   void setQuantity(BigDecimal paramBigDecimal);
/*    */   
/*    */   String getActionCode();
/*    */   
/*    */   void setActionCode(String paramString);
/*    */   
/*    */   boolean getVoid();
/*    */   
/*    */   void setVoid(boolean paramBoolean);
/*    */   
/*    */   IDataModel getRetailInventoryLocationModifierExt();
/*    */   
/*    */   void setRetailInventoryLocationModifierExt(IDataModel paramIDataModel);
/*    */   
/*    */   List<IRetailInventoryLocationModifierProperty> getProperties();
/*    */   
/*    */   void setProperties(List<IRetailInventoryLocationModifierProperty> paramList);
/*    */   
/*    */   void addRetailInventoryLocationModifierProperty(IRetailInventoryLocationModifierProperty paramIRetailInventoryLocationModifierProperty);
/*    */   
/*    */   void removeRetailInventoryLocationModifierProperty(IRetailInventoryLocationModifierProperty paramIRetailInventoryLocationModifierProperty);
/*    */   
/*    */   void setParentLine(ISaleReturnLineItem paramISaleReturnLineItem);
/*    */   
/*    */   ISaleReturnLineItem getParentLine();
/*    */   
/*    */   void startTransaction();
/*    */   
/*    */   void rollbackChanges();
/*    */   
/*    */   void commitTransaction();
/*    */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\trl\IRetailInventoryLocationModifier.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */