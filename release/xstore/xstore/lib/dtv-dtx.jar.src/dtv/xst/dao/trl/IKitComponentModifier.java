/*    */ package dtv.xst.dao.trl;
/*    */ import dtv.data2.access.IDataModel;
/*    */ import dtv.event.EventEnum;
/*    */ import dtv.xst.dao.itm.IKitComponent;
/*    */ import java.util.Date;
/*    */ import java.util.List;
/*    */ 
/*    */ public interface IKitComponentModifier extends IDataModel, IHasDataProperty<IKitComponentModifierProperty> {
/*  9 */   public static final EventEnum SET_ORGANIZATIONID = new EventEnum("set organizationId");
/* 10 */   public static final EventEnum SET_RETAILLOCATIONID = new EventEnum("set retailLocationId");
/* 11 */   public static final EventEnum SET_BUSINESSDATE = new EventEnum("set businessDate");
/* 12 */   public static final EventEnum SET_WORKSTATIONID = new EventEnum("set workstationId");
/* 13 */   public static final EventEnum SET_TRANSACTIONSEQUENCE = new EventEnum("set transactionSequence");
/* 14 */   public static final EventEnum SET_RETAILTRANSACTIONLINEITEMSEQUENCE = new EventEnum("set retailTransactionLineItemSequence");
/* 15 */   public static final EventEnum SET_COMPONENTITEMID = new EventEnum("set componentItemId");
/* 16 */   public static final EventEnum SET_SEQUENCENUMBER = new EventEnum("set sequenceNumber");
/* 17 */   public static final EventEnum SET_CREATEDATE = new EventEnum("set createDate");
/* 18 */   public static final EventEnum SET_CREATEUSERID = new EventEnum("set createUserId");
/* 19 */   public static final EventEnum SET_UPDATEDATE = new EventEnum("set updateDate");
/* 20 */   public static final EventEnum SET_UPDATEUSERID = new EventEnum("set updateUserId");
/* 21 */   public static final EventEnum SET_COMPONENTITEMDESC = new EventEnum("set componentItemDesc");
/* 22 */   public static final EventEnum SET_KITITEMID = new EventEnum("set kitItemId");
/* 23 */   public static final EventEnum SET_DISPLAYORDER = new EventEnum("set displayOrder");
/* 24 */   public static final EventEnum SET_QUANTITY = new EventEnum("set quantity");
/* 25 */   public static final EventEnum SET_SERIALNUMBER = new EventEnum("set serialNumber");
/* 26 */   public static final EventEnum SET_KITCOMPONENT = new EventEnum("set KitComponent");
/* 27 */   public static final EventEnum ADD_PROPERTIES = new EventEnum("add Properties");
/* 28 */   public static final EventEnum REMOVE_PROPERTIES = new EventEnum("remove Properties");
/* 29 */   public static final EventEnum SET_PROPERTIES = new EventEnum("set Properties");
/* 30 */   public static final EventEnum START_TRANSACTION = new EventEnum("start transaction");
/* 31 */   public static final EventEnum ROLLBACK_TRANSACTION = new EventEnum("rollback transaction");
/* 32 */   public static final EventEnum COMMIT_TRANSACTION = new EventEnum("commit transaction");
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
/*    */   Date getBusinessDate();
/*    */   
/*    */   void setBusinessDate(Date paramDate);
/*    */   
/*    */   long getWorkstationId();
/*    */   
/*    */   void setWorkstationId(long paramLong);
/*    */   
/*    */   long getTransactionSequence();
/*    */   
/*    */   void setTransactionSequence(long paramLong);
/*    */   
/*    */   int getRetailTransactionLineItemSequence();
/*    */   
/*    */   void setRetailTransactionLineItemSequence(int paramInt);
/*    */   
/*    */   String getComponentItemId();
/*    */   
/*    */   void setComponentItemId(String paramString);
/*    */   
/*    */   long getSequenceNumber();
/*    */   
/*    */   void setSequenceNumber(long paramLong);
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
/*    */   String getComponentItemDesc();
/*    */   
/*    */   void setComponentItemDesc(String paramString);
/*    */   
/*    */   String getKitItemId();
/*    */   
/*    */   void setKitItemId(String paramString);
/*    */   
/*    */   int getDisplayOrder();
/*    */   
/*    */   void setDisplayOrder(int paramInt);
/*    */   
/*    */   int getQuantity();
/*    */   
/*    */   void setQuantity(int paramInt);
/*    */   
/*    */   String getSerialNumber();
/*    */   
/*    */   void setSerialNumber(String paramString);
/*    */   
/*    */   IDataModel getKitComponentModifierExt();
/*    */   
/*    */   void setKitComponentModifierExt(IDataModel paramIDataModel);
/*    */   
/*    */   IKitComponent getKitComponent();
/*    */   
/*    */   void setKitComponent(IKitComponent paramIKitComponent);
/*    */   
/*    */   List<IKitComponentModifierProperty> getProperties();
/*    */   
/*    */   void setProperties(List<IKitComponentModifierProperty> paramList);
/*    */   
/*    */   void addKitComponentModifierProperty(IKitComponentModifierProperty paramIKitComponentModifierProperty);
/*    */   
/*    */   void removeKitComponentModifierProperty(IKitComponentModifierProperty paramIKitComponentModifierProperty);
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


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\trl\IKitComponentModifier.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */