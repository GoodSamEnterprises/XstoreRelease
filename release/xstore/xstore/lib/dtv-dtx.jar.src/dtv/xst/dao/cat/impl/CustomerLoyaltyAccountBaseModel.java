/*     */ package dtv.xst.dao.cat.impl;
/*     */ 
/*     */ import dtv.data2.access.impl.AbstractDataModelWithPropertyImpl;
/*     */ import dtv.i18n.FormattableFactory;
/*     */ import dtv.xst.dao.cat.ICustomerLoyaltyAccount;
/*     */ import dtv.xst.dao.cat.ICustomerLoyaltyAccountActivity;
/*     */ import dtv.xst.dao.cat.ICustomerLoyaltyAccountModel;
/*     */ import dtv.xst.dao.cat.ICustomerLoyaltyAccountProperty;
/*     */ import java.math.BigDecimal;
/*     */ import java.util.ArrayList;
/*     */ import java.util.List;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public abstract class CustomerLoyaltyAccountBaseModel
/*     */   extends AbstractDataModelWithPropertyImpl<ICustomerLoyaltyAccountProperty>
/*     */   implements ICustomerLoyaltyAccount, ICustomerLoyaltyAccountModel
/*     */ {
/*     */   private static final long serialVersionUID = 1L;
/*     */   private transient BigDecimal _transactionEarnedPoints;
/*     */   private transient BigDecimal _transactionEscrowPoints;
/*     */   private transient BigDecimal _transactionBonusPoints;
/*     */   private transient BigDecimal _accountEarnedPoints;
/*     */   private transient BigDecimal _accountEscrowPoints;
/*     */   private transient BigDecimal _accountBonusPoints;
/*  28 */   private transient List<ICustomerLoyaltyAccountActivity> _loyaltyAccountActivity = null;
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void addLoyaltyAccountActivity(ICustomerLoyaltyAccountActivity argLoyaltyAccountActivity) {
/*  34 */     if (argLoyaltyAccountActivity != null) {
/*  35 */       getLoyaltyAccountActivityImpl().add(argLoyaltyAccountActivity);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public List<? extends ICustomerLoyaltyAccountActivity> getLoyaltyAccountActivity() {
/*  42 */     return getLoyaltyAccountActivityImpl();
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public BigDecimal getProformaAccountBonusPoints() {
/*  48 */     return this._accountBonusPoints;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public BigDecimal getProformaAccountEarnedPoints() {
/*  54 */     return this._accountEarnedPoints;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public BigDecimal getProformaAccountEscrowPoints() {
/*  60 */     return this._accountEscrowPoints;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public BigDecimal getProformaTransactionBonusPoints() {
/*  66 */     return this._transactionBonusPoints;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public BigDecimal getProformaTransactionEarnedPoints() {
/*  72 */     return this._transactionEarnedPoints;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public BigDecimal getProformaTransactionEscrowPoints() {
/*  78 */     return this._transactionEscrowPoints;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public String getType() {
/*  84 */     return FormattableFactory.getInstance().getTranslatable("_loyaltyAccountTypeCode").toString();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setLoyaltyAccountActivity(List<? extends ICustomerLoyaltyAccountActivity> argActivity) {
/*  91 */     getLoyaltyAccountActivityImpl().clear();
/*  92 */     if (argActivity != null) {
/*  93 */       getLoyaltyAccountActivityImpl().addAll(argActivity);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void setProformaAccountBonusPoints(BigDecimal argPoints) {
/* 100 */     this._accountBonusPoints = argPoints;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void setProformaAccountEarnedPoints(BigDecimal argPoints) {
/* 106 */     this._accountEarnedPoints = argPoints;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void setProformaAccountEscrowPoints(BigDecimal argPoints) {
/* 112 */     this._accountEscrowPoints = argPoints;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void setProformaTransactionBonusPoints(BigDecimal argPoints) {
/* 118 */     this._transactionBonusPoints = argPoints;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void setProformaTransactionEarnedPoints(BigDecimal argPoints) {
/* 124 */     this._transactionEarnedPoints = argPoints;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void setProformaTransactionEscrowPoints(BigDecimal argPoints) {
/* 130 */     this._transactionEscrowPoints = argPoints;
/*     */   }
/*     */   
/*     */   private List<ICustomerLoyaltyAccountActivity> getLoyaltyAccountActivityImpl() {
/* 134 */     if (this._loyaltyAccountActivity == null) {
/* 135 */       this._loyaltyAccountActivity = new ArrayList<>();
/*     */     }
/*     */     
/* 138 */     return this._loyaltyAccountActivity;
/*     */   }
/*     */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\cat\impl\CustomerLoyaltyAccountBaseModel.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */