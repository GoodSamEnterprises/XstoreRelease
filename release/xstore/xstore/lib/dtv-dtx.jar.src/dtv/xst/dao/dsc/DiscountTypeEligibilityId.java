/*     */ package dtv.xst.dao.dsc;
/*     */ 
/*     */ import dtv.data2.access.AbstractObjectId;
/*     */ import dtv.data2.access.exception.DtxException;
/*     */ import dtv.util.StringUtils;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class DiscountTypeEligibilityId
/*     */   extends AbstractObjectId
/*     */ {
/*     */   private static final long serialVersionUID = -853580718L;
/*     */   private String _discountCode;
/*     */   private String _saleLineItemTypeCode;
/*     */   
/*     */   public DiscountTypeEligibilityId() {}
/*     */   
/*     */   public DiscountTypeEligibilityId(String argObjectIdValue) {
/*  23 */     setValue(argObjectIdValue);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getDiscountCode() {
/*  30 */     return this._discountCode;
/*     */   }
/*     */   
/*     */   public void setDiscountCode(String argDiscountCode) {
/*  34 */     this._discountCode = (argDiscountCode != null && MANAGE_CASE) ? argDiscountCode.toUpperCase() : argDiscountCode;
/*     */   }
/*     */   
/*     */   public String getSaleLineItemTypeCode() {
/*  38 */     return this._saleLineItemTypeCode;
/*     */   }
/*     */   
/*     */   public void setSaleLineItemTypeCode(String argSaleLineItemTypeCode) {
/*  42 */     this._saleLineItemTypeCode = (argSaleLineItemTypeCode != null && MANAGE_CASE) ? argSaleLineItemTypeCode.toUpperCase() : argSaleLineItemTypeCode;
/*     */   }
/*     */   
/*     */   public void setValue(String argObjectIdValue) {
/*  46 */     String str = argObjectIdValue;
/*  47 */     if (StringUtils.isEmpty(str)) {
/*  48 */       throw new DtxException("argument passed to setValue() is null or empty - a valid value must be passed");
/*     */     }
/*     */     try {
/*  51 */       String[] tokens = str.split("::");
/*  52 */       str = tokens[0];
/*     */       
/*  54 */       if ("null".equals(str)) {
/*  55 */         setDiscountCode((String)null);
/*     */       } else {
/*     */         
/*  58 */         setDiscountCode(str);
/*     */       } 
/*  60 */       str = tokens[1];
/*     */       
/*  62 */       setOrganizationId(Long.valueOf(str));
/*  63 */       str = tokens[2];
/*     */       
/*  65 */       if ("null".equals(str)) {
/*  66 */         setSaleLineItemTypeCode((String)null);
/*     */       } else {
/*     */         
/*  69 */         setSaleLineItemTypeCode(str);
/*     */       }
/*     */     
/*  72 */     } catch (Exception ee) {
/*  73 */       throw new DtxException("An exception occured while parsing object id string: " + argObjectIdValue, ee);
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean equals(Object ob) {
/*  79 */     if (this == ob) {
/*  80 */       return true;
/*     */     }
/*  82 */     if (!(ob instanceof DiscountTypeEligibilityId)) {
/*  83 */       return false;
/*     */     }
/*  85 */     DiscountTypeEligibilityId other = (DiscountTypeEligibilityId)ob;
/*  86 */     return (((this._discountCode == null && other._discountCode == null) || (this._discountCode != null && this._discountCode
/*     */ 
/*     */       
/*  89 */       .equals(other._discountCode))) && ((this._organizationId == null && other._organizationId == null) || (this._organizationId != null && this._organizationId
/*     */ 
/*     */       
/*  92 */       .equals(other._organizationId))) && ((this._saleLineItemTypeCode == null && other._saleLineItemTypeCode == null) || (this._saleLineItemTypeCode != null && this._saleLineItemTypeCode
/*     */ 
/*     */       
/*  95 */       .equals(other._saleLineItemTypeCode))));
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public int hashCode() {
/* 101 */     return ((this._discountCode == null) ? 0 : this._discountCode
/* 102 */       .hashCode()) + ((this._organizationId == null) ? 0 : this._organizationId
/* 103 */       .hashCode()) + ((this._saleLineItemTypeCode == null) ? 0 : this._saleLineItemTypeCode
/* 104 */       .hashCode());
/*     */   }
/*     */ 
/*     */   
/*     */   public String getDtxTypeName() {
/* 109 */     return "DiscountTypeEligibility";
/*     */   }
/*     */ 
/*     */   
/*     */   public String toString() {
/* 114 */     StringBuilder buff = new StringBuilder(36);
/*     */     
/* 116 */     return buff.append(this._discountCode)
/*     */       
/* 118 */       .append("::").append(String.valueOf(this._organizationId))
/* 119 */       .append("::").append(this._saleLineItemTypeCode)
/* 120 */       .toString();
/*     */   }
/*     */   
/*     */   public boolean validate() {
/* 124 */     if (this._discountCode == null) {
/* 125 */       return false;
/*     */     }
/* 127 */     if (this._saleLineItemTypeCode == null) {
/* 128 */       return false;
/*     */     }
/* 130 */     return true;
/*     */   }
/*     */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\dsc\DiscountTypeEligibilityId.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */