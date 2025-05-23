/*    */ package dtv.xst.dao.cat.impl;
/*    */ 
/*    */ import dtv.data2.access.IObjectId;
/*    */ import dtv.data2.access.ObjectManager;
/*    */ import dtv.data2.access.impl.AbstractDataModelWithPropertyImpl;
/*    */ import dtv.xst.dao.cat.IChargeAccountUser;
/*    */ import dtv.xst.dao.cat.IChargeAccountUserModel;
/*    */ import dtv.xst.dao.cat.IChargeAccountUserProperty;
/*    */ import dtv.xst.dao.crm.IParty;
/*    */ import dtv.xst.dao.crm.PartyId;
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
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public abstract class ChargeAccountUserBaseModel
/*    */   extends AbstractDataModelWithPropertyImpl<IChargeAccountUserProperty>
/*    */   implements IChargeAccountUser, IChargeAccountUserModel
/*    */ {
/*    */   private static final long serialVersionUID = 1L;
/*    */   private transient ObjectManager manager_;
/*    */   private transient IParty party_;
/*    */   
/*    */   public String getAccountUserFullName() {
/* 35 */     return getDAO_().getAccountUserLastName() + ", " + getDAO_().getAccountUserFirstName();
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public IParty getParty() {
/* 41 */     if (this.party_ == null && getDAO_().getPartyId() != null) {
/* 42 */       if (this.manager_ == null) {
/* 43 */         this.manager_ = ObjectManager.getInstance();
/*    */       }
/*    */       
/* 46 */       PartyId id = new PartyId();
/* 47 */       id.setPartyId(getDAO_().getPartyId());
/* 48 */       this.party_ = (IParty)this.manager_.getManagedObject((IObjectId)id);
/*    */     } 
/*    */     
/* 51 */     return this.party_;
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public void setParty(IParty argParty) {
/* 57 */     if (argParty == null) {
/*    */       return;
/*    */     }
/*    */     
/* 61 */     if (this.manager_ == null) {
/* 62 */       this.manager_ = ObjectManager.getInstance();
/*    */     }
/*    */     
/* 65 */     getDAO_().setPartyId(Long.valueOf(argParty.getPartyId()));
/* 66 */     this.party_ = argParty;
/*    */   }
/*    */   
/*    */   private ChargeAccountUserDAO getDAO_() {
/* 70 */     return (ChargeAccountUserDAO)this._daoImpl;
/*    */   }
/*    */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\cat\impl\ChargeAccountUserBaseModel.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */