/*    */ package dtv.xst.dao.cat.impl;
/*    */ 
/*    */ import dtv.data2.access.IDataModel;
/*    */ import dtv.data2.access.IObjectId;
/*    */ import dtv.data2.access.ObjectManager;
/*    */ import dtv.data2.access.impl.AbstractDataModelWithPropertyImpl;
/*    */ import dtv.util.NumberUtils;
/*    */ import dtv.xst.dao.cat.IEscrowAccount;
/*    */ import dtv.xst.dao.cat.IEscrowAccountActivity;
/*    */ import dtv.xst.dao.cat.IEscrowAccountModel;
/*    */ import dtv.xst.dao.cat.IEscrowAccountProperty;
/*    */ import dtv.xst.dao.crm.IParty;
/*    */ import dtv.xst.dao.crm.PartyId;
/*    */ import java.math.BigDecimal;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public abstract class EscrowAccountBaseModel
/*    */   extends AbstractDataModelWithPropertyImpl<IEscrowAccountProperty>
/*    */   implements IEscrowAccount, IEscrowAccountModel
/*    */ {
/*    */   private static final long serialVersionUID = 1L;
/*    */   private transient ObjectManager manager_;
/*    */   private transient IParty party_;
/*    */   
/*    */   public void addEscrowAccountActivity(IEscrowAccountActivity argEscrowAccountActivity) {
/* 29 */     synchronized (this) {
/* 30 */       argEscrowAccountActivity.setSeqNbr((getEscrowAccountActivities().size() + 1));
/*    */     } 
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public IParty getParty() {
/* 37 */     if (this.party_ == null && getDAO_().getPartyId() != null) {
/* 38 */       if (this.manager_ == null) {
/* 39 */         this.manager_ = ObjectManager.getInstance();
/*    */       }
/*    */       
/* 42 */       PartyId id = new PartyId();
/* 43 */       id.setPartyId(getDAO_().getPartyId());
/* 44 */       this.party_ = (IParty)this.manager_.getManagedObject((IObjectId)id);
/*    */     } 
/*    */     
/* 47 */     return this.party_;
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public void setParty(IParty argParty) {
/* 53 */     if (argParty == null) {
/*    */       return;
/*    */     }
/*    */     
/* 57 */     if (this.manager_ == null) {
/* 58 */       this.manager_ = ObjectManager.getInstance();
/*    */     }
/*    */     
/* 61 */     this.manager_.manageObject((IDataModel)argParty);
/* 62 */     getDAO_().setPartyId(Long.valueOf(argParty.getPartyId()));
/* 63 */     this.party_ = argParty;
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public void updateAccountBalance() {
/* 69 */     BigDecimal balanceAmt = NumberUtils.ZERO;
/*    */     
/* 71 */     for (IEscrowAccountActivity activity : getEscrowAccountActivities()) {
/* 72 */       balanceAmt = balanceAmt.add(NumberUtils.nonNull(activity.getAmt()));
/*    */     }
/*    */     
/* 75 */     setAccountBalance(balanceAmt);
/*    */   }
/*    */   
/*    */   private EscrowAccountDAO getDAO_() {
/* 79 */     return (EscrowAccountDAO)this._daoImpl;
/*    */   }
/*    */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\cat\impl\EscrowAccountBaseModel.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */