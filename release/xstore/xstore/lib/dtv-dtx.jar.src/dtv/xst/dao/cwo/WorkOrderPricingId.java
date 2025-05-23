/*     */ package dtv.xst.dao.cwo;
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
/*     */ public class WorkOrderPricingId
/*     */   extends AbstractObjectId
/*     */ {
/*     */   private static final long serialVersionUID = 273533545L;
/*     */   private String _priceCode;
/*     */   private String _itemId;
/*     */   
/*     */   public WorkOrderPricingId() {}
/*     */   
/*     */   public WorkOrderPricingId(String argObjectIdValue) {
/*  23 */     setValue(argObjectIdValue);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getPriceCode() {
/*  30 */     return this._priceCode;
/*     */   }
/*     */   
/*     */   public void setPriceCode(String argPriceCode) {
/*  34 */     this._priceCode = (argPriceCode != null && MANAGE_CASE) ? argPriceCode.toUpperCase() : argPriceCode;
/*     */   }
/*     */   
/*     */   public String getItemId() {
/*  38 */     return this._itemId;
/*     */   }
/*     */   
/*     */   public void setItemId(String argItemId) {
/*  42 */     this._itemId = (argItemId != null && MANAGE_CASE) ? argItemId.toUpperCase() : argItemId;
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
/*  54 */       setOrganizationId(Long.valueOf(str));
/*  55 */       str = tokens[1];
/*     */       
/*  57 */       if ("null".equals(str)) {
/*  58 */         setPriceCode((String)null);
/*     */       } else {
/*     */         
/*  61 */         setPriceCode(str);
/*     */       } 
/*  63 */       str = tokens[2];
/*     */       
/*  65 */       if ("null".equals(str)) {
/*  66 */         setItemId((String)null);
/*     */       } else {
/*     */         
/*  69 */         setItemId(str);
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
/*  82 */     if (!(ob instanceof WorkOrderPricingId)) {
/*  83 */       return false;
/*     */     }
/*  85 */     WorkOrderPricingId other = (WorkOrderPricingId)ob;
/*  86 */     return (((this._organizationId == null && other._organizationId == null) || (this._organizationId != null && this._organizationId
/*     */ 
/*     */       
/*  89 */       .equals(other._organizationId))) && ((this._priceCode == null && other._priceCode == null) || (this._priceCode != null && this._priceCode
/*     */ 
/*     */       
/*  92 */       .equals(other._priceCode))) && ((this._itemId == null && other._itemId == null) || (this._itemId != null && this._itemId
/*     */ 
/*     */       
/*  95 */       .equals(other._itemId))));
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public int hashCode() {
/* 101 */     return ((this._organizationId == null) ? 0 : this._organizationId
/* 102 */       .hashCode()) + ((this._priceCode == null) ? 0 : this._priceCode
/* 103 */       .hashCode()) + ((this._itemId == null) ? 0 : this._itemId
/* 104 */       .hashCode());
/*     */   }
/*     */ 
/*     */   
/*     */   public String getDtxTypeName() {
/* 109 */     return "WorkOrderPricing";
/*     */   }
/*     */ 
/*     */   
/*     */   public String toString() {
/* 114 */     StringBuilder buff = new StringBuilder(36);
/*     */     
/* 116 */     return buff.append(
/* 117 */         String.valueOf(this._organizationId))
/* 118 */       .append("::").append(this._priceCode)
/* 119 */       .append("::").append(this._itemId)
/* 120 */       .toString();
/*     */   }
/*     */   
/*     */   public boolean validate() {
/* 124 */     if (this._priceCode == null) {
/* 125 */       return false;
/*     */     }
/* 127 */     if (this._itemId == null) {
/* 128 */       return false;
/*     */     }
/* 130 */     return true;
/*     */   }
/*     */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\cwo\WorkOrderPricingId.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */