/*     */ package dtv.pos.framework.tax;
/*     */ 
/*     */ import dtv.util.NumberUtils;
/*     */ import dtv.xst.dao.tax.ITaxAuthority;
/*     */ import dtv.xst.dao.trl.ISaleTaxModifier;
/*     */ import dtv.xst.dao.trl.ITaxLineItem;
/*     */ import java.math.BigDecimal;
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
/*     */ public class TaxInfo
/*     */   implements Comparable<TaxInfo>
/*     */ {
/*  23 */   private BigDecimal _taxAmount = BigDecimal.ZERO;
/*  24 */   private ITaxAuthority _authority = null;
/*     */   private int _order;
/*  26 */   private String _taxType = null;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public TaxInfo(ISaleTaxModifier argModifier) {
/*  33 */     this._taxAmount = NumberUtils.nonNull(argModifier.getTaxAmount());
/*  34 */     this._authority = argModifier.getSaleTaxGroupRule().getTaxAuthority();
/*  35 */     this._order = argModifier.getTaxRuleSequence();
/*  36 */     this._taxType = argModifier.getSaleTaxGroupRule().getTaxTypeCode();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public TaxInfo(ITaxLineItem argTaxLineItem) {
/*  44 */     this._taxAmount = NumberUtils.nonNull(argTaxLineItem.getTaxAmount());
/*  45 */     this._authority = argTaxLineItem.getSaleTaxGroupRule().getTaxAuthority();
/*  46 */     this._order = argTaxLineItem.getTaxRuleSequence();
/*  47 */     this._taxType = argTaxLineItem.getSaleTaxGroupRule().getTaxTypeCode();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void add(ISaleTaxModifier argModifier) {
/*  56 */     add(argModifier.getTaxAmount(), argModifier.getAuthorityId());
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void add(ITaxLineItem argTaxLine) {
/*  65 */     add(argTaxLine.getTaxAmount(), argTaxLine.getAuthorityId());
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public int compareTo(TaxInfo argOther) {
/*  71 */     return getOrder() - argOther.getOrder();
/*     */   }
/*     */   
/*     */   public ITaxAuthority getAuthority() {
/*  75 */     return this._authority;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int getOrder() {
/*  83 */     return this._order;
/*     */   }
/*     */   
/*     */   public BigDecimal getTaxAmount() {
/*  87 */     return this._taxAmount;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getTaxType() {
/*  95 */     return this._taxType;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setOrder(int argOrder) {
/* 103 */     this._order = argOrder;
/*     */   }
/*     */ 
/*     */   
/*     */   private void add(BigDecimal argAmount, String argAuthorityId) {
/* 108 */     if (this._authority.getTaxAuthorityId().equals(argAuthorityId))
/* 109 */       this._taxAmount = this._taxAmount.add(NumberUtils.nonNull(argAmount)); 
/*     */   }
/*     */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-posframework.jar!\dtv\pos\framework\tax\TaxInfo.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */