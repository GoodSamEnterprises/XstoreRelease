/*     */ package dtv.xst.dao.tax;
/*     */ 
/*     */ import dtv.data2.access.AbstractObjectId;
/*     */ import dtv.data2.access.exception.DtxException;
/*     */ import dtv.util.DtvDate;
/*     */ import dtv.util.StringUtils;
/*     */ import java.util.Date;
/*     */ 
/*     */ 
/*     */ 
/*     */ public class TaxRateRuleOverridePropertyId
/*     */   extends AbstractObjectId
/*     */ {
/*     */   private static final long serialVersionUID = -1185365880L;
/*     */   private DtvDate _expirationDatetimestamp;
/*     */   private String _taxGroupId;
/*     */   private String _taxLocationId;
/*     */   private Integer _taxRateRuleSequence;
/*     */   private Integer _taxRuleSequence;
/*     */   private String _propertyCode;
/*     */   
/*     */   public TaxRateRuleOverridePropertyId() {}
/*     */   
/*     */   public TaxRateRuleOverridePropertyId(String argObjectIdValue) {
/*  25 */     setValue(argObjectIdValue);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Date getExpirationDatetimestamp() {
/*  36 */     return (Date)this._expirationDatetimestamp;
/*     */   }
/*     */   
/*     */   public void setExpirationDatetimestamp(Date argExpirationDatetimestamp) {
/*  40 */     this._expirationDatetimestamp = (argExpirationDatetimestamp == null || argExpirationDatetimestamp instanceof DtvDate) ? (DtvDate)argExpirationDatetimestamp : new DtvDate(argExpirationDatetimestamp);
/*     */   }
/*     */ 
/*     */   
/*     */   public String getTaxGroupId() {
/*  45 */     return this._taxGroupId;
/*     */   }
/*     */   
/*     */   public void setTaxGroupId(String argTaxGroupId) {
/*  49 */     this._taxGroupId = (argTaxGroupId != null && MANAGE_CASE) ? argTaxGroupId.toUpperCase() : argTaxGroupId;
/*     */   }
/*     */   
/*     */   public String getTaxLocationId() {
/*  53 */     return this._taxLocationId;
/*     */   }
/*     */   
/*     */   public void setTaxLocationId(String argTaxLocationId) {
/*  57 */     this._taxLocationId = (argTaxLocationId != null && MANAGE_CASE) ? argTaxLocationId.toUpperCase() : argTaxLocationId;
/*     */   }
/*     */   
/*     */   public Integer getTaxRateRuleSequence() {
/*  61 */     return this._taxRateRuleSequence;
/*     */   }
/*     */   
/*     */   public void setTaxRateRuleSequence(Integer argTaxRateRuleSequence) {
/*  65 */     this._taxRateRuleSequence = argTaxRateRuleSequence;
/*     */   }
/*     */   
/*     */   public Integer getTaxRuleSequence() {
/*  69 */     return this._taxRuleSequence;
/*     */   }
/*     */   
/*     */   public void setTaxRuleSequence(Integer argTaxRuleSequence) {
/*  73 */     this._taxRuleSequence = argTaxRuleSequence;
/*     */   }
/*     */   
/*     */   public String getPropertyCode() {
/*  77 */     return this._propertyCode;
/*     */   }
/*     */   
/*     */   public void setPropertyCode(String argPropertyCode) {
/*  81 */     this._propertyCode = (argPropertyCode != null && MANAGE_CASE) ? argPropertyCode.toUpperCase() : argPropertyCode;
/*     */   }
/*     */   
/*     */   public void setValue(String argObjectIdValue) {
/*  85 */     String str = argObjectIdValue;
/*  86 */     if (StringUtils.isEmpty(str)) {
/*  87 */       throw new DtxException("argument passed to setValue() is null or empty - a valid value must be passed");
/*     */     }
/*     */     try {
/*  90 */       String[] tokens = str.split("::");
/*  91 */       str = tokens[0];
/*     */       
/*  93 */       if ("null".equals(str)) {
/*  94 */         setExpirationDatetimestamp((Date)null);
/*     */       } else {
/*     */         
/*  97 */         setExpirationDatetimestamp((Date)new DtvDate());
/*  98 */         this._expirationDatetimestamp.setTimeFromSerialization(Long.parseLong(str));
/*     */       } 
/* 100 */       str = tokens[1];
/*     */       
/* 102 */       setOrganizationId(Long.valueOf(str));
/* 103 */       str = tokens[2];
/*     */       
/* 105 */       if ("null".equals(str)) {
/* 106 */         setTaxGroupId((String)null);
/*     */       } else {
/*     */         
/* 109 */         setTaxGroupId(str);
/*     */       } 
/* 111 */       str = tokens[3];
/*     */       
/* 113 */       if ("null".equals(str)) {
/* 114 */         setTaxLocationId((String)null);
/*     */       } else {
/*     */         
/* 117 */         setTaxLocationId(str);
/*     */       } 
/* 119 */       str = tokens[4];
/*     */       
/* 121 */       setTaxRateRuleSequence(Integer.valueOf(str));
/* 122 */       str = tokens[5];
/*     */       
/* 124 */       setTaxRuleSequence(Integer.valueOf(str));
/* 125 */       str = tokens[6];
/*     */       
/* 127 */       if ("null".equals(str)) {
/* 128 */         setPropertyCode((String)null);
/*     */       } else {
/*     */         
/* 131 */         setPropertyCode(str);
/*     */       }
/*     */     
/* 134 */     } catch (Exception ee) {
/* 135 */       throw new DtxException("An exception occured while parsing object id string: " + argObjectIdValue, ee);
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean equals(Object ob) {
/* 141 */     if (this == ob) {
/* 142 */       return true;
/*     */     }
/* 144 */     if (!(ob instanceof TaxRateRuleOverridePropertyId)) {
/* 145 */       return false;
/*     */     }
/* 147 */     TaxRateRuleOverridePropertyId other = (TaxRateRuleOverridePropertyId)ob;
/* 148 */     return (((this._expirationDatetimestamp == null && other._expirationDatetimestamp == null) || (this._expirationDatetimestamp != null && this._expirationDatetimestamp
/*     */ 
/*     */       
/* 151 */       .equals(other._expirationDatetimestamp))) && ((this._organizationId == null && other._organizationId == null) || (this._organizationId != null && this._organizationId
/*     */ 
/*     */       
/* 154 */       .equals(other._organizationId))) && ((this._taxGroupId == null && other._taxGroupId == null) || (this._taxGroupId != null && this._taxGroupId
/*     */ 
/*     */       
/* 157 */       .equals(other._taxGroupId))) && ((this._taxLocationId == null && other._taxLocationId == null) || (this._taxLocationId != null && this._taxLocationId
/*     */ 
/*     */       
/* 160 */       .equals(other._taxLocationId))) && ((this._taxRateRuleSequence == null && other._taxRateRuleSequence == null) || (this._taxRateRuleSequence != null && this._taxRateRuleSequence
/*     */ 
/*     */       
/* 163 */       .equals(other._taxRateRuleSequence))) && ((this._taxRuleSequence == null && other._taxRuleSequence == null) || (this._taxRuleSequence != null && this._taxRuleSequence
/*     */ 
/*     */       
/* 166 */       .equals(other._taxRuleSequence))) && ((this._propertyCode == null && other._propertyCode == null) || (this._propertyCode != null && this._propertyCode
/*     */ 
/*     */       
/* 169 */       .equals(other._propertyCode))));
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public int hashCode() {
/* 175 */     return ((this._expirationDatetimestamp == null) ? 0 : this._expirationDatetimestamp
/* 176 */       .hashCode()) + ((this._organizationId == null) ? 0 : this._organizationId
/* 177 */       .hashCode()) + ((this._taxGroupId == null) ? 0 : this._taxGroupId
/* 178 */       .hashCode()) + ((this._taxLocationId == null) ? 0 : this._taxLocationId
/* 179 */       .hashCode()) + ((this._taxRateRuleSequence == null) ? 0 : this._taxRateRuleSequence
/* 180 */       .hashCode()) + ((this._taxRuleSequence == null) ? 0 : this._taxRuleSequence
/* 181 */       .hashCode()) + ((this._propertyCode == null) ? 0 : this._propertyCode
/* 182 */       .hashCode());
/*     */   }
/*     */ 
/*     */   
/*     */   public String getDtxTypeName() {
/* 187 */     return "TaxRateRuleOverrideProperty";
/*     */   }
/*     */ 
/*     */   
/*     */   public String toString() {
/* 192 */     StringBuilder buff = new StringBuilder(84);
/*     */     
/* 194 */     return buff.append((this._expirationDatetimestamp == null) ? "null" : 
/* 195 */         String.valueOf(this._expirationDatetimestamp.getTimeSerializable()))
/* 196 */       .append("::").append(String.valueOf(this._organizationId))
/* 197 */       .append("::").append(this._taxGroupId)
/* 198 */       .append("::").append(this._taxLocationId)
/* 199 */       .append("::").append(String.valueOf(this._taxRateRuleSequence))
/* 200 */       .append("::").append(String.valueOf(this._taxRuleSequence))
/* 201 */       .append("::").append(this._propertyCode)
/* 202 */       .toString();
/*     */   }
/*     */   
/*     */   public boolean validate() {
/* 206 */     if (this._expirationDatetimestamp == null) {
/* 207 */       return false;
/*     */     }
/* 209 */     if (this._taxGroupId == null) {
/* 210 */       return false;
/*     */     }
/* 212 */     if (this._taxLocationId == null) {
/* 213 */       return false;
/*     */     }
/* 215 */     if (this._taxRateRuleSequence == null) {
/* 216 */       return false;
/*     */     }
/* 218 */     if (this._taxRuleSequence == null) {
/* 219 */       return false;
/*     */     }
/* 221 */     if (this._propertyCode == null) {
/* 222 */       return false;
/*     */     }
/* 224 */     return true;
/*     */   }
/*     */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\tax\TaxRateRuleOverridePropertyId.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */