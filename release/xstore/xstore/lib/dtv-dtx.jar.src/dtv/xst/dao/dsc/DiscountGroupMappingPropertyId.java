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
/*     */ public class DiscountGroupMappingPropertyId
/*     */   extends AbstractObjectId
/*     */ {
/*     */   private static final long serialVersionUID = -2042080443L;
/*     */   private String _customerGroupId;
/*     */   private String _discountCode;
/*     */   private String _propertyCode;
/*     */   
/*     */   public DiscountGroupMappingPropertyId() {}
/*     */   
/*     */   public DiscountGroupMappingPropertyId(String argObjectIdValue) {
/*  23 */     setValue(argObjectIdValue);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getCustomerGroupId() {
/*  31 */     return this._customerGroupId;
/*     */   }
/*     */   
/*     */   public void setCustomerGroupId(String argCustomerGroupId) {
/*  35 */     this._customerGroupId = (argCustomerGroupId != null && MANAGE_CASE) ? argCustomerGroupId.toUpperCase() : argCustomerGroupId;
/*     */   }
/*     */   
/*     */   public String getDiscountCode() {
/*  39 */     return this._discountCode;
/*     */   }
/*     */   
/*     */   public void setDiscountCode(String argDiscountCode) {
/*  43 */     this._discountCode = (argDiscountCode != null && MANAGE_CASE) ? argDiscountCode.toUpperCase() : argDiscountCode;
/*     */   }
/*     */   
/*     */   public String getPropertyCode() {
/*  47 */     return this._propertyCode;
/*     */   }
/*     */   
/*     */   public void setPropertyCode(String argPropertyCode) {
/*  51 */     this._propertyCode = (argPropertyCode != null && MANAGE_CASE) ? argPropertyCode.toUpperCase() : argPropertyCode;
/*     */   }
/*     */   
/*     */   public void setValue(String argObjectIdValue) {
/*  55 */     String str = argObjectIdValue;
/*  56 */     if (StringUtils.isEmpty(str)) {
/*  57 */       throw new DtxException("argument passed to setValue() is null or empty - a valid value must be passed");
/*     */     }
/*     */     try {
/*  60 */       String[] tokens = str.split("::");
/*  61 */       str = tokens[0];
/*     */       
/*  63 */       if ("null".equals(str)) {
/*  64 */         setCustomerGroupId((String)null);
/*     */       } else {
/*     */         
/*  67 */         setCustomerGroupId(str);
/*     */       } 
/*  69 */       str = tokens[1];
/*     */       
/*  71 */       if ("null".equals(str)) {
/*  72 */         setDiscountCode((String)null);
/*     */       } else {
/*     */         
/*  75 */         setDiscountCode(str);
/*     */       } 
/*  77 */       str = tokens[2];
/*     */       
/*  79 */       setOrganizationId(Long.valueOf(str));
/*  80 */       str = tokens[3];
/*     */       
/*  82 */       if ("null".equals(str)) {
/*  83 */         setPropertyCode((String)null);
/*     */       } else {
/*     */         
/*  86 */         setPropertyCode(str);
/*     */       }
/*     */     
/*  89 */     } catch (Exception ee) {
/*  90 */       throw new DtxException("An exception occured while parsing object id string: " + argObjectIdValue, ee);
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean equals(Object ob) {
/*  96 */     if (this == ob) {
/*  97 */       return true;
/*     */     }
/*  99 */     if (!(ob instanceof DiscountGroupMappingPropertyId)) {
/* 100 */       return false;
/*     */     }
/* 102 */     DiscountGroupMappingPropertyId other = (DiscountGroupMappingPropertyId)ob;
/* 103 */     return (((this._customerGroupId == null && other._customerGroupId == null) || (this._customerGroupId != null && this._customerGroupId
/*     */ 
/*     */       
/* 106 */       .equals(other._customerGroupId))) && ((this._discountCode == null && other._discountCode == null) || (this._discountCode != null && this._discountCode
/*     */ 
/*     */       
/* 109 */       .equals(other._discountCode))) && ((this._organizationId == null && other._organizationId == null) || (this._organizationId != null && this._organizationId
/*     */ 
/*     */       
/* 112 */       .equals(other._organizationId))) && ((this._propertyCode == null && other._propertyCode == null) || (this._propertyCode != null && this._propertyCode
/*     */ 
/*     */       
/* 115 */       .equals(other._propertyCode))));
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public int hashCode() {
/* 121 */     return ((this._customerGroupId == null) ? 0 : this._customerGroupId
/* 122 */       .hashCode()) + ((this._discountCode == null) ? 0 : this._discountCode
/* 123 */       .hashCode()) + ((this._organizationId == null) ? 0 : this._organizationId
/* 124 */       .hashCode()) + ((this._propertyCode == null) ? 0 : this._propertyCode
/* 125 */       .hashCode());
/*     */   }
/*     */ 
/*     */   
/*     */   public String getDtxTypeName() {
/* 130 */     return "DiscountGroupMappingProperty";
/*     */   }
/*     */ 
/*     */   
/*     */   public String toString() {
/* 135 */     StringBuilder buff = new StringBuilder(48);
/*     */     
/* 137 */     return buff.append(this._customerGroupId)
/*     */       
/* 139 */       .append("::").append(this._discountCode)
/* 140 */       .append("::").append(String.valueOf(this._organizationId))
/* 141 */       .append("::").append(this._propertyCode)
/* 142 */       .toString();
/*     */   }
/*     */   
/*     */   public boolean validate() {
/* 146 */     if (this._customerGroupId == null) {
/* 147 */       return false;
/*     */     }
/* 149 */     if (this._discountCode == null) {
/* 150 */       return false;
/*     */     }
/* 152 */     if (this._propertyCode == null) {
/* 153 */       return false;
/*     */     }
/* 155 */     return true;
/*     */   }
/*     */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\dsc\DiscountGroupMappingPropertyId.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */