/*    */ package dtv.xst.dao.trl;
/*    */ 
/*    */ import dtv.event.EventEnum;
/*    */ import dtv.xst.dao.cat.ICustomerLoyaltyCard;
/*    */ import dtv.xst.dao.crm.IParty;
/*    */ import dtv.xst.dao.trn.IPosTransaction;
/*    */ import dtv.xst.daocommon.IInventoriedItemTransaction;
/*    */ import java.math.BigDecimal;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public interface IRetailTransactionModel
/*    */   extends IPosTransaction, IInventoriedItemTransaction
/*    */ {
/* 17 */   public static final EventEnum SET_LOYALTYCARDOBJECT = new EventEnum("set loyaltyCard object");
/*    */   
/*    */   IParty getCustomerParty();
/*    */   
/*    */   BigDecimal getDiscountAmount();
/*    */   
/*    */   ICustomerLoyaltyCard getLoyaltyCardObject();
/*    */   
/*    */   boolean getOfficialReceipt();
/*    */   
/*    */   long getOfficialReceiptSeq();
/*    */   
/*    */   void setCustomerParty(IParty paramIParty);
/*    */   
/*    */   void setDiscountAmount(BigDecimal paramBigDecimal);
/*    */   
/*    */   void setLoyaltyCardObject(ICustomerLoyaltyCard paramICustomerLoyaltyCard);
/*    */   
/*    */   void setOfficialReceipt(boolean paramBoolean);
/*    */   
/*    */   void setOfficialReceiptSeq(long paramLong);
/*    */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\trl\IRetailTransactionModel.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */