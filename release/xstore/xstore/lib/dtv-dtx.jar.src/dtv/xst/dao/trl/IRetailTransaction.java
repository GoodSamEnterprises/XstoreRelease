/*    */ package dtv.xst.dao.trl;
/*    */ import dtv.data2.access.IDataModel;
/*    */ import dtv.event.EventEnum;
/*    */ import dtv.xst.dao.crm.IParty;
/*    */ import java.util.Date;
/*    */ import java.util.List;
/*    */ 
/*    */ public interface IRetailTransaction extends IDataModel, IRetailTransactionModel, IPosTransaction {
/*  9 */   public static final EventEnum SET_CREATEDATE = new EventEnum("set createDate");
/* 10 */   public static final EventEnum SET_CREATEUSERID = new EventEnum("set createUserId");
/* 11 */   public static final EventEnum SET_UPDATEDATE = new EventEnum("set updateDate");
/* 12 */   public static final EventEnum SET_UPDATEUSERID = new EventEnum("set updateUserId");
/* 13 */   public static final EventEnum SET_LOYALTYCARD = new EventEnum("set loyaltyCard");
/* 14 */   public static final EventEnum SET_CUSTOMERPARTYID = new EventEnum("set customerPartyId");
/* 15 */   public static final EventEnum SET_TAXEXEMPTIONID = new EventEnum("set taxExemptionId");
/* 16 */   public static final EventEnum SET_CUSTOMERPARTY = new EventEnum("set CustomerParty");
/* 17 */   public static final EventEnum ADD_INVENTORYDOCUMENTMODIFIERS = new EventEnum("add InventoryDocumentModifiers");
/* 18 */   public static final EventEnum REMOVE_INVENTORYDOCUMENTMODIFIERS = new EventEnum("remove InventoryDocumentModifiers");
/* 19 */   public static final EventEnum SET_INVENTORYDOCUMENTMODIFIERS = new EventEnum("set InventoryDocumentModifiers");
/* 20 */   public static final EventEnum SET_TAXEXEMPTION = new EventEnum("set TaxExemption");
/* 21 */   public static final EventEnum SET_FLIGHTINFORMATION = new EventEnum("set FlightInformation");
/* 22 */   public static final EventEnum START_TRANSACTION = new EventEnum("start transaction");
/* 23 */   public static final EventEnum ROLLBACK_TRANSACTION = new EventEnum("rollback transaction");
/* 24 */   public static final EventEnum COMMIT_TRANSACTION = new EventEnum("commit transaction");
/*    */   
/*    */   void setDAO(IDataAccessObject paramIDataAccessObject);
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
/*    */   String getLoyaltyCard();
/*    */   
/*    */   void setLoyaltyCard(String paramString);
/*    */   
/*    */   long getCustomerPartyId();
/*    */   
/*    */   void setCustomerPartyId(long paramLong);
/*    */   
/*    */   IDataModel getRetailTransactionExt();
/*    */   
/*    */   void setRetailTransactionExt(IDataModel paramIDataModel);
/*    */   
/*    */   IParty getCustomerParty();
/*    */   
/*    */   void setCustomerParty(IParty paramIParty);
/*    */   
/*    */   List<IInventoryDocumentModifier> getInventoryDocumentModifiers();
/*    */   
/*    */   void setInventoryDocumentModifiers(List<IInventoryDocumentModifier> paramList);
/*    */   
/*    */   void addInventoryDocumentModifier(IInventoryDocumentModifier paramIInventoryDocumentModifier);
/*    */   
/*    */   void removeInventoryDocumentModifier(IInventoryDocumentModifier paramIInventoryDocumentModifier);
/*    */   
/*    */   ITaxExemption getTaxExemption();
/*    */   
/*    */   void setTaxExemption(ITaxExemption paramITaxExemption);
/*    */   
/*    */   IRetailTransactionFlightInfo getFlightInformation();
/*    */   
/*    */   void setFlightInformation(IRetailTransactionFlightInfo paramIRetailTransactionFlightInfo);
/*    */   
/*    */   void startTransaction();
/*    */   
/*    */   void rollbackChanges();
/*    */   
/*    */   void commitTransaction();
/*    */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\trl\IRetailTransaction.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */