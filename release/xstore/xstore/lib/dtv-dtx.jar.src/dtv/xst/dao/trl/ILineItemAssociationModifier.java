/*    */ package dtv.xst.dao.trl;
/*    */ import dtv.data2.access.IDataAccessObject;
/*    */ import dtv.data2.access.IDataModel;
/*    */ import dtv.event.EventEnum;
/*    */ import java.util.Date;
/*    */ import java.util.List;
/*    */ 
/*    */ public interface ILineItemAssociationModifier extends IDataModel, ILineItemAssociationModifierModel, IHasDataProperty<ILineItemAssociationModifierProperty> {
/*  9 */   public static final EventEnum SET_BUSINESSDATE = new EventEnum("set businessDate");
/* 10 */   public static final EventEnum SET_LINEITEMASSOCIATIONMODIFIERSEQUENCE = new EventEnum("set lineItemAssociationModifierSequence");
/* 11 */   public static final EventEnum SET_ORGANIZATIONID = new EventEnum("set organizationId");
/* 12 */   public static final EventEnum SET_RETAILLOCATIONID = new EventEnum("set retailLocationId");
/* 13 */   public static final EventEnum SET_RETAILTRANSACTIONLINEITEMSEQUENCE = new EventEnum("set retailTransactionLineItemSequence");
/* 14 */   public static final EventEnum SET_TRANSACTIONSEQUENCE = new EventEnum("set transactionSequence");
/* 15 */   public static final EventEnum SET_WORKSTATIONID = new EventEnum("set workstationId");
/* 16 */   public static final EventEnum SET_CREATEDATE = new EventEnum("set createDate");
/* 17 */   public static final EventEnum SET_CREATEUSERID = new EventEnum("set createUserId");
/* 18 */   public static final EventEnum SET_UPDATEDATE = new EventEnum("set updateDate");
/* 19 */   public static final EventEnum SET_UPDATEUSERID = new EventEnum("set updateUserId");
/* 20 */   public static final EventEnum SET_CHILDBUSINESSDATE = new EventEnum("set childBusinessDate");
/* 21 */   public static final EventEnum SET_CHILDRETAILLOCATIONID = new EventEnum("set childRetailLocationId");
/* 22 */   public static final EventEnum SET_CHILDRETAILTRANSACTIONLINEITEMSEQUENCE = new EventEnum("set childRetailTransactionLineItemSequence");
/* 23 */   public static final EventEnum SET_CHILDTRANSACTIONSEQUENCE = new EventEnum("set childTransactionSequence");
/* 24 */   public static final EventEnum SET_CHILDWORKSTATIONID = new EventEnum("set childWorkstationId");
/* 25 */   public static final EventEnum SET_LINEITEMASSOCIATIONTYPECODESTRING = new EventEnum("set lineItemAssociationTypeCodeString");
/* 26 */   public static final EventEnum SET_CHILDLINEITEM = new EventEnum("set ChildLineItem");
/* 27 */   public static final EventEnum SET_LINEITEMASSOCIATIONTYPECODE = new EventEnum("set LineItemAssociationTypeCode");
/* 28 */   public static final EventEnum ADD_PROPERTIES = new EventEnum("add Properties");
/* 29 */   public static final EventEnum REMOVE_PROPERTIES = new EventEnum("remove Properties");
/* 30 */   public static final EventEnum SET_PROPERTIES = new EventEnum("set Properties");
/* 31 */   public static final EventEnum START_TRANSACTION = new EventEnum("start transaction");
/* 32 */   public static final EventEnum ROLLBACK_TRANSACTION = new EventEnum("rollback transaction");
/* 33 */   public static final EventEnum COMMIT_TRANSACTION = new EventEnum("commit transaction");
/*    */   
/*    */   void setDAO(IDataAccessObject paramIDataAccessObject);
/*    */   
/*    */   Date getBusinessDate();
/*    */   
/*    */   void setBusinessDate(Date paramDate);
/*    */   
/*    */   int getLineItemAssociationModifierSequence();
/*    */   
/*    */   void setLineItemAssociationModifierSequence(int paramInt);
/*    */   
/*    */   long getOrganizationId();
/*    */   
/*    */   void setOrganizationId(long paramLong);
/*    */   
/*    */   long getRetailLocationId();
/*    */   
/*    */   void setRetailLocationId(long paramLong);
/*    */   
/*    */   int getRetailTransactionLineItemSequence();
/*    */   
/*    */   void setRetailTransactionLineItemSequence(int paramInt);
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
/*    */   Date getChildBusinessDate();
/*    */   
/*    */   void setChildBusinessDate(Date paramDate);
/*    */   
/*    */   long getChildRetailLocationId();
/*    */   
/*    */   void setChildRetailLocationId(long paramLong);
/*    */   
/*    */   int getChildRetailTransactionLineItemSequence();
/*    */   
/*    */   void setChildRetailTransactionLineItemSequence(int paramInt);
/*    */   
/*    */   long getChildTransactionSequence();
/*    */   
/*    */   void setChildTransactionSequence(long paramLong);
/*    */   
/*    */   long getChildWorkstationId();
/*    */   
/*    */   void setChildWorkstationId(long paramLong);
/*    */   
/*    */   String getLineItemAssociationTypeCodeString();
/*    */   
/*    */   void setLineItemAssociationTypeCodeString(String paramString);
/*    */   
/*    */   IDataModel getLineItemAssociationModifierExt();
/*    */   
/*    */   void setLineItemAssociationModifierExt(IDataModel paramIDataModel);
/*    */   
/*    */   ISaleReturnLineItem getChildLineItem();
/*    */   
/*    */   void setChildLineItem(ISaleReturnLineItem paramISaleReturnLineItem);
/*    */   
/*    */   ILineItemAssociationTypeCode getLineItemAssociationTypeCode();
/*    */   
/*    */   void setLineItemAssociationTypeCode(ILineItemAssociationTypeCode paramILineItemAssociationTypeCode);
/*    */   
/*    */   List<ILineItemAssociationModifierProperty> getProperties();
/*    */   
/*    */   void setProperties(List<ILineItemAssociationModifierProperty> paramList);
/*    */   
/*    */   void addLineItemAssociationModifierProperty(ILineItemAssociationModifierProperty paramILineItemAssociationModifierProperty);
/*    */   
/*    */   void removeLineItemAssociationModifierProperty(ILineItemAssociationModifierProperty paramILineItemAssociationModifierProperty);
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


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\trl\ILineItemAssociationModifier.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */