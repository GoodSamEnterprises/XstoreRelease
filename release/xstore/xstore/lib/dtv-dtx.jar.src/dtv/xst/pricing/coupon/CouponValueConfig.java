/*     */ package dtv.xst.pricing.coupon;
/*     */ 
/*     */ import dtv.pricing2.IFieldTest;
/*     */ import dtv.pricing2.IMatchingRule;
/*     */ import dtv.pricing2.ItemField;
/*     */ import dtv.pricing2.ItemMatch;
/*     */ import dtv.pricing2.PricingDeal;
/*     */ import dtv.pricing2.match.EqualityMatchRule;
/*     */ import dtv.pricing2.match.SimpleFieldTest;
/*     */ import dtv.util.config.AbstractParentConfig;
/*     */ import dtv.util.config.ConfigUtils;
/*     */ import dtv.util.config.IConfigObject;
/*     */ import dtv.xst.dao.trl.ICouponLineItem;
/*     */ import dtv.xst.pricing.XSTPricingAdapter;
/*     */ import java.math.BigDecimal;
/*     */ import java.util.Arrays;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class CouponValueConfig
/*     */   extends AbstractParentConfig
/*     */ {
/*     */   private static final long serialVersionUID = 1L;
/*  26 */   private String code_ = null;
/*  27 */   private String action_ = "CURRENCY_OFF";
/*  28 */   private String actionArg_ = null;
/*  29 */   private BigDecimal quantity_ = BigDecimal.ONE;
/*     */   private boolean enabled_ = true;
/*  31 */   private String description_ = "MANUFACTURER COUPON";
/*  32 */   private String taxabilityCode_ = "POST_TAX";
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private final XSTPricingAdapter adapter_;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public CouponValueConfig(XSTPricingAdapter argAdapter) {
/*  44 */     this.adapter_ = argAdapter;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getAction() {
/*  53 */     return this.action_;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getActionArg() {
/*  62 */     return this.actionArg_;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getCode() {
/*  71 */     return this.code_;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getDealDescription(String argManufacturer) {
/*  81 */     return this.description_;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getDealId(String argManufacturer) {
/*  91 */     return "MANUF_COUPON-" + argManufacturer + "-" + getCode();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public BigDecimal getQuantity() {
/* 100 */     return this.quantity_;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getTaxabilityCode() {
/* 109 */     return this.taxabilityCode_;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean isEnabled() {
/* 117 */     return this.enabled_;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public PricingDeal makeDeal(ICouponLineItem line) {
/* 127 */     if ("PROMPT".equalsIgnoreCase(getActionArg())) {
/* 128 */       return null;
/*     */     }
/* 130 */     if ("BOGO".equalsIgnoreCase(getAction())) {
/* 131 */       return makeBogoDeal(line);
/*     */     }
/*     */ 
/*     */     
/* 135 */     PricingDeal deal = new PricingDeal(line.getManufacturerId(), new ManufacturerCouponPricingDescriptor(this, line.getManufacturerId()));
/*     */     
/* 137 */     deal.setIterationCap(20);
/* 138 */     deal.setTriggers(Arrays.asList(new String[] { "COUPON:" + line.getCouponTypeCode() + ":" + line.getCouponId() }));
/*     */     
/* 140 */     ItemMatch match = new ItemMatch();
/*     */     
/* 142 */     SimpleFieldTest fieldTest = new SimpleFieldTest();
/* 143 */     fieldTest.setField(ItemField.MANUFACTURER.name());
/* 144 */     EqualityMatchRule equalityMatchRule = new EqualityMatchRule();
/* 145 */     equalityMatchRule.setTarget1(line.getManufacturerId());
/* 146 */     fieldTest.setMatchRule((IMatchingRule)equalityMatchRule);
/*     */     
/* 148 */     long quantity = this.adapter_.convertQuantity(getQuantity());
/* 149 */     match.setMinQty(quantity);
/* 150 */     match.setMaxQty(quantity);
/* 151 */     match.setConsumable(true);
/* 152 */     match.setFieldTest((IFieldTest)fieldTest);
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
/* 176 */     return deal;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void setConfigObject(String argKey, IConfigObject argValue) {
/* 182 */     if ("code".equalsIgnoreCase(argKey)) {
/* 183 */       this.code_ = argValue.toString();
/*     */     }
/* 185 */     else if ("action".equalsIgnoreCase(argKey)) {
/* 186 */       this.action_ = argValue.toString();
/*     */     }
/* 188 */     else if ("action_arg".equalsIgnoreCase(argKey)) {
/* 189 */       this.actionArg_ = argValue.toString();
/*     */     }
/* 191 */     else if ("quantity".equalsIgnoreCase(argKey)) {
/* 192 */       this.quantity_ = ConfigUtils.toBigDecimal(argValue);
/*     */     }
/* 194 */     else if ("enabled".equalsIgnoreCase(argKey)) {
/* 195 */       this.enabled_ = ConfigUtils.toBoolean(argValue);
/*     */     }
/* 197 */     else if ("description".equalsIgnoreCase(argKey)) {
/* 198 */       this.description_ = argValue.toString();
/*     */     }
/* 200 */     else if ("taxabilityCode".equalsIgnoreCase(argKey)) {
/* 201 */       this.taxabilityCode_ = argValue.toString();
/*     */     } else {
/*     */       
/* 204 */       warnUnsupported(argKey, argValue);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   private PricingDeal makeBogoDeal(ICouponLineItem argLine) {
/* 211 */     PricingDeal deal = new PricingDeal(argLine.getManufacturerId(), new ManufacturerCouponPricingDescriptor(this, argLine.getManufacturerId()));
/* 212 */     deal.setIterationCap(20);
/* 213 */     deal.setTriggers(Arrays.asList(new String[] { "COUPON:" + argLine.getCouponTypeCode() + ":" + argLine.getCouponId() }));
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
/* 236 */     return deal;
/*     */   }
/*     */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\pricing\coupon\CouponValueConfig.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */