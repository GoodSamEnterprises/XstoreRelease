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
/*     */ 
/*     */ public class TaxTaxGroupMappingId
/*     */   extends AbstractObjectId
/*     */ {
/*     */   private static final long serialVersionUID = -772656753L;
/*     */   private String _customerGroup;
/*     */   private String _taxGroupId;
/*     */   private Integer _rtlLocId;
/*     */   
/*     */   public TaxTaxGroupMappingId() {}
/*     */   
/*     */   public TaxTaxGroupMappingId(String argObjectIdValue) {
/*  23 */     setValue(argObjectIdValue);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getCustomerGroup() {
/*  31 */     return this._customerGroup;
/*     */   }
/*     */   
/*     */   public void setCustomerGroup(String argCustomerGroup) {
/*  35 */     this._customerGroup = (argCustomerGroup != null && MANAGE_CASE) ? argCustomerGroup.toUpperCase() : argCustomerGroup;
/*     */   }
/*     */   
/*     */   public String getTaxGroupId() {
/*  39 */     return this._taxGroupId;
/*     */   }
/*     */   
/*     */   public void setTaxGroupId(String argTaxGroupId) {
/*  43 */     this._taxGroupId = (argTaxGroupId != null && MANAGE_CASE) ? argTaxGroupId.toUpperCase() : argTaxGroupId;
/*     */   }
/*     */   
/*     */   public Integer getRtlLocId() {
/*  47 */     return this._rtlLocId;
/*     */   }
/*     */   
/*     */   public void setRtlLocId(Integer argRtlLocId) {
/*  51 */     this._rtlLocId = argRtlLocId;
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
/*  63 */       setOrganizationId(Long.valueOf(str));
/*  64 */       str = tokens[1];
/*     */       
/*  66 */       if ("null".equals(str)) {
/*  67 */         setCustomerGroup((String)null);
/*     */       } else {
/*     */         
/*  70 */         setCustomerGroup(str);
/*     */       } 
/*  72 */       str = tokens[2];
/*     */       
/*  74 */       if ("null".equals(str)) {
/*  75 */         setTaxGroupId((String)null);
/*     */       } else {
/*     */         
/*  78 */         setTaxGroupId(str);
/*     */       } 
/*  80 */       str = tokens[3];
/*     */       
/*  82 */       setRtlLocId(Integer.valueOf(str));
/*     */     }
/*  84 */     catch (Exception ee) {
/*  85 */       throw new DtxException("An exception occured while parsing object id string: " + argObjectIdValue, ee);
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean equals(Object ob) {
/*  91 */     if (this == ob) {
/*  92 */       return true;
/*     */     }
/*  94 */     if (!(ob instanceof TaxTaxGroupMappingId)) {
/*  95 */       return false;
/*     */     }
/*  97 */     TaxTaxGroupMappingId other = (TaxTaxGroupMappingId)ob;
/*  98 */     return (((this._organizationId == null && other._organizationId == null) || (this._organizationId != null && this._organizationId
/*     */ 
/*     */       
/* 101 */       .equals(other._organizationId))) && ((this._customerGroup == null && other._customerGroup == null) || (this._customerGroup != null && this._customerGroup
/*     */ 
/*     */       
/* 104 */       .equals(other._customerGroup))) && ((this._taxGroupId == null && other._taxGroupId == null) || (this._taxGroupId != null && this._taxGroupId
/*     */ 
/*     */       
/* 107 */       .equals(other._taxGroupId))) && ((this._rtlLocId == null && other._rtlLocId == null) || (this._rtlLocId != null && this._rtlLocId
/*     */ 
/*     */       
/* 110 */       .equals(other._rtlLocId))));
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public int hashCode() {
/* 116 */     return ((this._organizationId == null) ? 0 : this._organizationId
/* 117 */       .hashCode()) + ((this._customerGroup == null) ? 0 : this._customerGroup
/* 118 */       .hashCode()) + ((this._taxGroupId == null) ? 0 : this._taxGroupId
/* 119 */       .hashCode()) + ((this._rtlLocId == null) ? 0 : this._rtlLocId
/* 120 */       .hashCode());
/*     */   }
/*     */ 
/*     */   
/*     */   public String getDtxTypeName() {
/* 125 */     return "TaxTaxGroupMapping";
/*     */   }
/*     */ 
/*     */   
/*     */   public String toString() {
/* 130 */     StringBuilder buff = new StringBuilder(48);
/*     */     
/* 132 */     return buff.append(
/* 133 */         String.valueOf(this._organizationId))
/* 134 */       .append("::").append(this._customerGroup)
/* 135 */       .append("::").append(this._taxGroupId)
/* 136 */       .append("::").append(String.valueOf(this._rtlLocId))
/* 137 */       .toString();
/*     */   }
/*     */   
/*     */   public boolean validate() {
/* 141 */     if (this._customerGroup == null) {
/* 142 */       return false;
/*     */     }
/* 144 */     if (this._taxGroupId == null) {
/* 145 */       return false;
/*     */     }
/* 147 */     if (this._rtlLocId == null) {
/* 148 */       return false;
/*     */     }
/* 150 */     return true;
/*     */   }
/*     */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\tax\TaxTaxGroupMappingId.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */