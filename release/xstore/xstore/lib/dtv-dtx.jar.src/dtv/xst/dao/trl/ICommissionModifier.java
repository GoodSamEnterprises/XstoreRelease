/*    */ package dtv.xst.dao.trl;
/*    */ import dtv.data2.access.IDataModel;
/*    */ import dtv.event.EventEnum;
/*    */ import dtv.xst.dao.crm.IParty;
/*    */ import java.math.BigDecimal;
/*    */ import java.util.Date;
/*    */ 
/*    */ public interface ICommissionModifier extends IDataModel, ICommissionModifierModel, IHasDataProperty<ICommissionModifierProperty> {
/*  9 */   public static final EventEnum SET_BUSINESSDATE = new EventEnum("set businessDate");
/* 10 */   public static final EventEnum SET_COMMISSIONMODIFIERSEQUENCENBR = new EventEnum("set commissionModifierSequenceNbr");
/* 11 */   public static final EventEnum SET_ORGANIZATIONID = new EventEnum("set organizationId");
/* 12 */   public static final EventEnum SET_RETAILLOCATIONID = new EventEnum("set retailLocationId");
/* 13 */   public static final EventEnum SET_RETAILTRANSACTIONLINEITEMSEQUENCE = new EventEnum("set retailTransactionLineItemSequence");
/* 14 */   public static final EventEnum SET_TRANSACTIONSEQUENCE = new EventEnum("set transactionSequence");
/* 15 */   public static final EventEnum SET_WORKSTATIONID = new EventEnum("set workstationId");
/* 16 */   public static final EventEnum SET_CREATEDATE = new EventEnum("set createDate");
/* 17 */   public static final EventEnum SET_CREATEUSERID = new EventEnum("set createUserId");
/* 18 */   public static final EventEnum SET_UPDATEDATE = new EventEnum("set updateDate");
/* 19 */   public static final EventEnum SET_UPDATEUSERID = new EventEnum("set updateUserId");
/* 20 */   public static final EventEnum SET_AMOUNT = new EventEnum("set amount");
/* 21 */   public static final EventEnum SET_PERCENTAGE = new EventEnum("set percentage");
/* 22 */   public static final EventEnum SET_PERCENTAGEOFITEM = new EventEnum("set percentageOfItem");
/* 23 */   public static final EventEnum SET_TYPECODE = new EventEnum("set typeCode");
/* 24 */   public static final EventEnum SET_UNVERIFIABLEEMPLOYEEID = new EventEnum("set unverifiableEmployeeId");
/* 25 */   public static final EventEnum SET_EMPLOYEEPARTYID = new EventEnum("set employeePartyId");
/* 26 */   public static final EventEnum SET_EMPLOYEEPARTY = new EventEnum("set EmployeeParty");
/* 27 */   public static final EventEnum ADD_PROPERTIES = new EventEnum("add Properties");
/* 28 */   public static final EventEnum REMOVE_PROPERTIES = new EventEnum("remove Properties");
/* 29 */   public static final EventEnum SET_PROPERTIES = new EventEnum("set Properties");
/* 30 */   public static final EventEnum START_TRANSACTION = new EventEnum("start transaction");
/* 31 */   public static final EventEnum ROLLBACK_TRANSACTION = new EventEnum("rollback transaction");
/* 32 */   public static final EventEnum COMMIT_TRANSACTION = new EventEnum("commit transaction");
/*    */   
/*    */   void setDAO(IDataAccessObject paramIDataAccessObject);
/*    */   
/*    */   Date getBusinessDate();
/*    */   
/*    */   void setBusinessDate(Date paramDate);
/*    */   
/*    */   int getCommissionModifierSequenceNbr();
/*    */   
/*    */   void setCommissionModifierSequenceNbr(int paramInt);
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
/*    */   BigDecimal getAmount();
/*    */   
/*    */   void setAmount(BigDecimal paramBigDecimal);
/*    */   
/*    */   BigDecimal getPercentage();
/*    */   
/*    */   void setPercentage(BigDecimal paramBigDecimal);
/*    */   
/*    */   BigDecimal getPercentageOfItem();
/*    */   
/*    */   void setPercentageOfItem(BigDecimal paramBigDecimal);
/*    */   
/*    */   String getTypeCode();
/*    */   
/*    */   void setTypeCode(String paramString);
/*    */   
/*    */   String getUnverifiableEmployeeId();
/*    */   
/*    */   void setUnverifiableEmployeeId(String paramString);
/*    */   
/*    */   long getEmployeePartyId();
/*    */   
/*    */   void setEmployeePartyId(long paramLong);
/*    */   
/*    */   IDataModel getCommissionModifierExt();
/*    */   
/*    */   void setCommissionModifierExt(IDataModel paramIDataModel);
/*    */   
/*    */   IParty getEmployeeParty();
/*    */   
/*    */   void setEmployeeParty(IParty paramIParty);
/*    */   
/*    */   List<ICommissionModifierProperty> getProperties();
/*    */   
/*    */   void setProperties(List<ICommissionModifierProperty> paramList);
/*    */   
/*    */   void addCommissionModifierProperty(ICommissionModifierProperty paramICommissionModifierProperty);
/*    */   
/*    */   void removeCommissionModifierProperty(ICommissionModifierProperty paramICommissionModifierProperty);
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


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\trl\ICommissionModifier.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */