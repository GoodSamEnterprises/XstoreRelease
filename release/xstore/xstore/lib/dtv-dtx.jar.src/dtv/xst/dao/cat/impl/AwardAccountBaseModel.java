/*     */ package dtv.xst.dao.cat.impl;
/*     */ 
/*     */ import dtv.data2.access.impl.AbstractDataModelWithPropertyImpl;
/*     */ import dtv.i18n.FormattableFactory;
/*     */ import dtv.xst.dao.cat.IAwardAccount;
/*     */ import dtv.xst.dao.cat.IAwardAccountActivity;
/*     */ import dtv.xst.dao.cat.IAwardAccountCoupon;
/*     */ import dtv.xst.dao.cat.IAwardAccountModel;
/*     */ import dtv.xst.dao.cat.IAwardAccountProperty;
/*     */ import java.math.BigDecimal;
/*     */ import java.util.ArrayList;
/*     */ import java.util.Collection;
/*     */ import java.util.Collections;
/*     */ import java.util.List;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public abstract class AwardAccountBaseModel
/*     */   extends AbstractDataModelWithPropertyImpl<IAwardAccountProperty>
/*     */   implements IAwardAccountModel, IAwardAccount
/*     */ {
/*     */   private static final long serialVersionUID = 1L;
/*  26 */   private static final transient Collection<IAwardAccountCoupon> _noAwards = Collections.emptyList();
/*     */   
/*     */   private transient Collection<IAwardAccountCoupon> _affectedAwards;
/*  29 */   private transient List<IAwardAccountActivity> _awardAccountActivity = null;
/*     */   private transient BigDecimal _availableAwardBalance;
/*  31 */   private transient String _awardTransactionId = null;
/*     */ 
/*     */ 
/*     */   
/*     */   public void addAwardAccountActivity(IAwardAccountActivity argAwardAccountActivity) {
/*  36 */     if (argAwardAccountActivity != null) {
/*  37 */       getAwardAccountActivityImpl().add(argAwardAccountActivity);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public BigDecimal getAccountBalance() {
/*  44 */     BigDecimal balance = BigDecimal.ZERO;
/*     */     
/*  46 */     for (IAwardAccountCoupon awardCoupon : getAwardCoupons()) {
/*  47 */       if (awardCoupon.getAmount() != null) {
/*  48 */         balance = balance.add(awardCoupon.getAmount());
/*     */       }
/*     */     } 
/*     */     
/*  52 */     return balance;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public Collection<IAwardAccountCoupon> getAffectedAwards() {
/*  58 */     return (this._affectedAwards == null) ? _noAwards : this._affectedAwards;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public BigDecimal getAvailableAwardBalance() {
/*  64 */     return this._availableAwardBalance;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public List<? extends IAwardAccountActivity> getAwardAccountActivity() {
/*  70 */     return getAwardAccountActivityImpl();
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public String getAwardTransactionId() {
/*  76 */     return this._awardTransactionId;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public String getType() {
/*  82 */     return FormattableFactory.getInstance().getTranslatable("_awardAccountTypeCode").toString();
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void setAffectedAwards(Collection<IAwardAccountCoupon> argAffectedAwards) {
/*  88 */     this._affectedAwards = argAffectedAwards;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void setAvailableAwardBalance(BigDecimal argAvailableBalance) {
/*  94 */     this._availableAwardBalance = argAvailableBalance;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void setAwardAccountActivity(List<? extends IAwardAccountActivity> argActivity) {
/* 100 */     getAwardAccountActivityImpl().clear();
/*     */     
/* 102 */     if (argActivity != null) {
/* 103 */       getAwardAccountActivityImpl().addAll(argActivity);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void setAwardTransactionId(String argAwardTransactionId) {
/* 110 */     this._awardTransactionId = argAwardTransactionId;
/*     */   }
/*     */   
/*     */   private List<IAwardAccountActivity> getAwardAccountActivityImpl() {
/* 114 */     if (this._awardAccountActivity == null) {
/* 115 */       this._awardAccountActivity = new ArrayList<>();
/*     */     }
/*     */     
/* 118 */     return this._awardAccountActivity;
/*     */   }
/*     */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\cat\impl\AwardAccountBaseModel.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */