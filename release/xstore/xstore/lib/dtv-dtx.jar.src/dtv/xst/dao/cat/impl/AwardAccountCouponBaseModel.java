/*    */ package dtv.xst.dao.cat.impl;
/*    */ 
/*    */ import dtv.data2.access.impl.AbstractDataModelWithPropertyImpl;
/*    */ import dtv.i18n.FormattableFactory;
/*    */ import dtv.xst.dao.cat.IAwardAccountCoupon;
/*    */ import dtv.xst.dao.cat.IAwardAccountCouponModel;
/*    */ import dtv.xst.dao.cat.IAwardAccountCouponProperty;
/*    */ import java.math.BigDecimal;
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
/*    */ public abstract class AwardAccountCouponBaseModel
/*    */   extends AbstractDataModelWithPropertyImpl<IAwardAccountCouponProperty>
/*    */   implements IAwardAccountCoupon, IAwardAccountCouponModel
/*    */ {
/*    */   private static final long serialVersionUID = 1L;
/*    */   private transient BigDecimal _redeemAmount;
/*    */   
/*    */   public BigDecimal getRedeemAmount() {
/* 28 */     return this._redeemAmount;
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public String getType() {
/* 34 */     return FormattableFactory.getInstance().getTranslatable("_awardCouponTypeCode").toString();
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public void setRedeemAmount(BigDecimal argRedeemAmount) {
/* 40 */     this._redeemAmount = argRedeemAmount;
/*    */   }
/*    */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\cat\impl\AwardAccountCouponBaseModel.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */