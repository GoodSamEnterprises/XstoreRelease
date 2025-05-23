/*     */ package dtv.xst.pricing;
/*     */ 
/*     */ import dtv.xst.dao.trl.RetailPriceModifierReasonCode;
/*     */ import java.io.Serializable;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class XSTPricingDescriptor
/*     */   implements Serializable
/*     */ {
/*     */   private static final long serialVersionUID = 1L;
/*     */   protected final String dealId_;
/*     */   protected final RetailPriceModifierReasonCode reason_;
/*     */   protected final String description_;
/*     */   protected final String taxabilityCode_;
/*     */   
/*     */   public XSTPricingDescriptor(String argDealId, RetailPriceModifierReasonCode argReason, String argDescription, String argTaxabilityCode) {
/*  52 */     this.reason_ = argReason;
/*  53 */     this.description_ = argDescription;
/*  54 */     this.dealId_ = argDealId;
/*  55 */     this.taxabilityCode_ = argTaxabilityCode;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getDealId() {
/*  65 */     return this.dealId_;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getDescription() {
/*  76 */     return this.description_;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public RetailPriceModifierReasonCode getReason() {
/*  86 */     return this.reason_;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getTaxabilityCode() {
/*  95 */     return this.taxabilityCode_;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public String toString() {
/* 101 */     StringBuilder build = new StringBuilder();
/*     */     
/* 103 */     build.append('<').append(this.dealId_).append('>').append(' ');
/* 104 */     build.append(this.description_);
/*     */     
/* 106 */     return build.toString();
/*     */   }
/*     */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\pricing\XSTPricingDescriptor.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */