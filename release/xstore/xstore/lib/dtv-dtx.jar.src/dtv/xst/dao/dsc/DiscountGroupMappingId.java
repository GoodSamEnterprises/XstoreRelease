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
/*     */ public class DiscountGroupMappingId
/*     */   extends AbstractObjectId
/*     */ {
/*     */   private static final long serialVersionUID = -2010226352L;
/*     */   private String _customerGroupId;
/*     */   private String _discountCode;
/*     */   
/*     */   public DiscountGroupMappingId() {}
/*     */   
/*     */   public DiscountGroupMappingId(String argObjectIdValue) {
/*  23 */     setValue(argObjectIdValue);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getCustomerGroupId() {
/*  30 */     return this._customerGroupId;
/*     */   }
/*     */   
/*     */   public void setCustomerGroupId(String argCustomerGroupId) {
/*  34 */     this._customerGroupId = (argCustomerGroupId != null && MANAGE_CASE) ? argCustomerGroupId.toUpperCase() : argCustomerGroupId;
/*     */   }
/*     */   
/*     */   public String getDiscountCode() {
/*  38 */     return this._discountCode;
/*     */   }
/*     */   
/*     */   public void setDiscountCode(String argDiscountCode) {
/*  42 */     this._discountCode = (argDiscountCode != null && MANAGE_CASE) ? argDiscountCode.toUpperCase() : argDiscountCode;
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
/*  55 */         setCustomerGroupId((String)null);
/*     */       } else {
/*     */         
/*  58 */         setCustomerGroupId(str);
/*     */       } 
/*  60 */       str = tokens[1];
/*     */       
/*  62 */       if ("null".equals(str)) {
/*  63 */         setDiscountCode((String)null);
/*     */       } else {
/*     */         
/*  66 */         setDiscountCode(str);
/*     */       } 
/*  68 */       str = tokens[2];
/*     */       
/*  70 */       setOrganizationId(Long.valueOf(str));
/*     */     }
/*  72 */     catch (Exception ee) {
/*  73 */       throw new DtxException("An exception occured while parsing object id string: " + argObjectIdValue, ee);
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean equals(Object ob) {
/*  79 */     if (this == ob) {
/*  80 */       return true;
/*     */     }
/*  82 */     if (!(ob instanceof DiscountGroupMappingId)) {
/*  83 */       return false;
/*     */     }
/*  85 */     DiscountGroupMappingId other = (DiscountGroupMappingId)ob;
/*  86 */     return (((this._customerGroupId == null && other._customerGroupId == null) || (this._customerGroupId != null && this._customerGroupId
/*     */ 
/*     */       
/*  89 */       .equals(other._customerGroupId))) && ((this._discountCode == null && other._discountCode == null) || (this._discountCode != null && this._discountCode
/*     */ 
/*     */       
/*  92 */       .equals(other._discountCode))) && ((this._organizationId == null && other._organizationId == null) || (this._organizationId != null && this._organizationId
/*     */ 
/*     */       
/*  95 */       .equals(other._organizationId))));
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public int hashCode() {
/* 101 */     return ((this._customerGroupId == null) ? 0 : this._customerGroupId
/* 102 */       .hashCode()) + ((this._discountCode == null) ? 0 : this._discountCode
/* 103 */       .hashCode()) + ((this._organizationId == null) ? 0 : this._organizationId
/* 104 */       .hashCode());
/*     */   }
/*     */ 
/*     */   
/*     */   public String getDtxTypeName() {
/* 109 */     return "DiscountGroupMapping";
/*     */   }
/*     */ 
/*     */   
/*     */   public String toString() {
/* 114 */     StringBuilder buff = new StringBuilder(36);
/*     */     
/* 116 */     return buff.append(this._customerGroupId)
/*     */       
/* 118 */       .append("::").append(this._discountCode)
/* 119 */       .append("::").append(String.valueOf(this._organizationId))
/* 120 */       .toString();
/*     */   }
/*     */   
/*     */   public boolean validate() {
/* 124 */     if (this._customerGroupId == null) {
/* 125 */       return false;
/*     */     }
/* 127 */     if (this._discountCode == null) {
/* 128 */       return false;
/*     */     }
/* 130 */     return true;
/*     */   }
/*     */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\dsc\DiscountGroupMappingId.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */