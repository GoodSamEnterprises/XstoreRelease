/*    */ package dtv.xst.dao.cat.impl;
/*    */ 
/*    */ import dtv.data2.access.impl.AbstractDataModelWithPropertyImpl;
/*    */ import dtv.xst.dao.cat.IAwardAccount;
/*    */ import dtv.xst.dao.cat.ICustomerLoyaltyAccount;
/*    */ import dtv.xst.dao.cat.ICustomerLoyaltyCard;
/*    */ import dtv.xst.dao.cat.ICustomerLoyaltyCardModel;
/*    */ import dtv.xst.dao.cat.ICustomerLoyaltyCardProperty;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public abstract class CustomerLoyaltyCardBaseModel
/*    */   extends AbstractDataModelWithPropertyImpl<ICustomerLoyaltyCardProperty>
/*    */   implements ICustomerLoyaltyCard, ICustomerLoyaltyCardModel
/*    */ {
/*    */   private static final long serialVersionUID = 1L;
/*    */   private transient boolean _owned = false;
/*    */   
/*    */   public IAwardAccount getPrimaryAwardAccount() {
/* 28 */     return getAwardAccounts().isEmpty() ? null : getAwardAccounts().get(0);
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public ICustomerLoyaltyAccount getPrimaryLoyaltyAccount() {
/* 34 */     return getLoyaltyAccounts().isEmpty() ? null : getLoyaltyAccounts().get(0);
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public boolean isOwned() {
/* 40 */     return (this._owned || getDAO_().getPartyId() != null);
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public void setOwned(boolean argIsOwned) {
/* 46 */     this._owned = argIsOwned;
/*    */   }
/*    */   
/*    */   private CustomerLoyaltyCardDAO getDAO_() {
/* 50 */     return (CustomerLoyaltyCardDAO)this._daoImpl;
/*    */   }
/*    */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\cat\impl\CustomerLoyaltyCardBaseModel.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */