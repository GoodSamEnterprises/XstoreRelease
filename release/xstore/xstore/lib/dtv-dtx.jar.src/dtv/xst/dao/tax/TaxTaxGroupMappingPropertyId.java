/*     */ package dtv.xst.dao.tax;
/*     */ 
/*     */ import dtv.data2.access.AbstractObjectId;
/*     */ import dtv.data2.access.exception.DtxException;
/*     */ import dtv.util.StringUtils;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class TaxTaxGroupMappingPropertyId
/*     */   extends AbstractObjectId
/*     */ {
/*     */   private static final long serialVersionUID = 1947432068L;
/*     */   private String _customerGroup;
/*     */   private String _taxGroupId;
/*     */   private Integer _rtlLocId;
/*     */   private String _propertyCode;
/*     */   
/*     */   public TaxTaxGroupMappingPropertyId() {}
/*     */   
/*     */   public TaxTaxGroupMappingPropertyId(String argObjectIdValue) {
/*  23 */     setValue(argObjectIdValue);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getCustomerGroup() {
/*  32 */     return this._customerGroup;
/*     */   }
/*     */   
/*     */   public void setCustomerGroup(String argCustomerGroup) {
/*  36 */     this._customerGroup = (argCustomerGroup != null && MANAGE_CASE) ? argCustomerGroup.toUpperCase() : argCustomerGroup;
/*     */   }
/*     */   
/*     */   public String getTaxGroupId() {
/*  40 */     return this._taxGroupId;
/*     */   }
/*     */   
/*     */   public void setTaxGroupId(String argTaxGroupId) {
/*  44 */     this._taxGroupId = (argTaxGroupId != null && MANAGE_CASE) ? argTaxGroupId.toUpperCase() : argTaxGroupId;
/*     */   }
/*     */   
/*     */   public Integer getRtlLocId() {
/*  48 */     return this._rtlLocId;
/*     */   }
/*     */   
/*     */   public void setRtlLocId(Integer argRtlLocId) {
/*  52 */     this._rtlLocId = argRtlLocId;
/*     */   }
/*     */   
/*     */   public String getPropertyCode() {
/*  56 */     return this._propertyCode;
/*     */   }
/*     */   
/*     */   public void setPropertyCode(String argPropertyCode) {
/*  60 */     this._propertyCode = (argPropertyCode != null && MANAGE_CASE) ? argPropertyCode.toUpperCase() : argPropertyCode;
/*     */   }
/*     */   
/*     */   public void setValue(String argObjectIdValue) {
/*  64 */     String str = argObjectIdValue;
/*  65 */     if (StringUtils.isEmpty(str)) {
/*  66 */       throw new DtxException("argument passed to setValue() is null or empty - a valid value must be passed");
/*     */     }
/*     */     try {
/*  69 */       String[] tokens = str.split("::");
/*  70 */       str = tokens[0];
/*     */       
/*  72 */       setOrganizationId(Long.valueOf(str));
/*  73 */       str = tokens[1];
/*     */       
/*  75 */       if ("null".equals(str)) {
/*  76 */         setCustomerGroup((String)null);
/*     */       } else {
/*     */         
/*  79 */         setCustomerGroup(str);
/*     */       } 
/*  81 */       str = tokens[2];
/*     */       
/*  83 */       if ("null".equals(str)) {
/*  84 */         setTaxGroupId((String)null);
/*     */       } else {
/*     */         
/*  87 */         setTaxGroupId(str);
/*     */       } 
/*  89 */       str = tokens[3];
/*     */       
/*  91 */       setRtlLocId(Integer.valueOf(str));
/*  92 */       str = tokens[4];
/*     */       
/*  94 */       if ("null".equals(str)) {
/*  95 */         setPropertyCode((String)null);
/*     */       } else {
/*     */         
/*  98 */         setPropertyCode(str);
/*     */       }
/*     */     
/* 101 */     } catch (Exception ee) {
/* 102 */       throw new DtxException("An exception occured while parsing object id string: " + argObjectIdValue, ee);
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean equals(Object ob) {
/* 108 */     if (this == ob) {
/* 109 */       return true;
/*     */     }
/* 111 */     if (!(ob instanceof TaxTaxGroupMappingPropertyId)) {
/* 112 */       return false;
/*     */     }
/* 114 */     TaxTaxGroupMappingPropertyId other = (TaxTaxGroupMappingPropertyId)ob;
/* 115 */     return (((this._organizationId == null && other._organizationId == null) || (this._organizationId != null && this._organizationId
/*     */ 
/*     */       
/* 118 */       .equals(other._organizationId))) && ((this._customerGroup == null && other._customerGroup == null) || (this._customerGroup != null && this._customerGroup
/*     */ 
/*     */       
/* 121 */       .equals(other._customerGroup))) && ((this._taxGroupId == null && other._taxGroupId == null) || (this._taxGroupId != null && this._taxGroupId
/*     */ 
/*     */       
/* 124 */       .equals(other._taxGroupId))) && ((this._rtlLocId == null && other._rtlLocId == null) || (this._rtlLocId != null && this._rtlLocId
/*     */ 
/*     */       
/* 127 */       .equals(other._rtlLocId))) && ((this._propertyCode == null && other._propertyCode == null) || (this._propertyCode != null && this._propertyCode
/*     */ 
/*     */       
/* 130 */       .equals(other._propertyCode))));
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public int hashCode() {
/* 136 */     return ((this._organizationId == null) ? 0 : this._organizationId
/* 137 */       .hashCode()) + ((this._customerGroup == null) ? 0 : this._customerGroup
/* 138 */       .hashCode()) + ((this._taxGroupId == null) ? 0 : this._taxGroupId
/* 139 */       .hashCode()) + ((this._rtlLocId == null) ? 0 : this._rtlLocId
/* 140 */       .hashCode()) + ((this._propertyCode == null) ? 0 : this._propertyCode
/* 141 */       .hashCode());
/*     */   }
/*     */ 
/*     */   
/*     */   public String getDtxTypeName() {
/* 146 */     return "TaxTaxGroupMappingProperty";
/*     */   }
/*     */ 
/*     */   
/*     */   public String toString() {
/* 151 */     StringBuilder buff = new StringBuilder(60);
/*     */     
/* 153 */     return buff.append(
/* 154 */         String.valueOf(this._organizationId))
/* 155 */       .append("::").append(this._customerGroup)
/* 156 */       .append("::").append(this._taxGroupId)
/* 157 */       .append("::").append(String.valueOf(this._rtlLocId))
/* 158 */       .append("::").append(this._propertyCode)
/* 159 */       .toString();
/*     */   }
/*     */   
/*     */   public boolean validate() {
/* 163 */     if (this._customerGroup == null) {
/* 164 */       return false;
/*     */     }
/* 166 */     if (this._taxGroupId == null) {
/* 167 */       return false;
/*     */     }
/* 169 */     if (this._rtlLocId == null) {
/* 170 */       return false;
/*     */     }
/* 172 */     if (this._propertyCode == null) {
/* 173 */       return false;
/*     */     }
/* 175 */     return true;
/*     */   }
/*     */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\tax\TaxTaxGroupMappingPropertyId.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */