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
/*     */ 
/*     */ public class TaxRateRuleOverrideId
/*     */   extends AbstractObjectId
/*     */ {
/*     */   private static final long serialVersionUID = -1162493549L;
/*     */   private DtvDate _expirationDatetimestamp;
/*     */   private String _taxGroupId;
/*     */   private String _taxLocationId;
/*     */   private Integer _taxRateRuleSequence;
/*     */   private Integer _taxRuleSequence;
/*     */   
/*     */   public TaxRateRuleOverrideId() {}
/*     */   
/*     */   public TaxRateRuleOverrideId(String argObjectIdValue) {
/*  25 */     setValue(argObjectIdValue);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Date getExpirationDatetimestamp() {
/*  35 */     return (Date)this._expirationDatetimestamp;
/*     */   }
/*     */   
/*     */   public void setExpirationDatetimestamp(Date argExpirationDatetimestamp) {
/*  39 */     this._expirationDatetimestamp = (argExpirationDatetimestamp == null || argExpirationDatetimestamp instanceof DtvDate) ? (DtvDate)argExpirationDatetimestamp : new DtvDate(argExpirationDatetimestamp);
/*     */   }
/*     */ 
/*     */   
/*     */   public String getTaxGroupId() {
/*  44 */     return this._taxGroupId;
/*     */   }
/*     */   
/*     */   public void setTaxGroupId(String argTaxGroupId) {
/*  48 */     this._taxGroupId = (argTaxGroupId != null && MANAGE_CASE) ? argTaxGroupId.toUpperCase() : argTaxGroupId;
/*     */   }
/*     */   
/*     */   public String getTaxLocationId() {
/*  52 */     return this._taxLocationId;
/*     */   }
/*     */   
/*     */   public void setTaxLocationId(String argTaxLocationId) {
/*  56 */     this._taxLocationId = (argTaxLocationId != null && MANAGE_CASE) ? argTaxLocationId.toUpperCase() : argTaxLocationId;
/*     */   }
/*     */   
/*     */   public Integer getTaxRateRuleSequence() {
/*  60 */     return this._taxRateRuleSequence;
/*     */   }
/*     */   
/*     */   public void setTaxRateRuleSequence(Integer argTaxRateRuleSequence) {
/*  64 */     this._taxRateRuleSequence = argTaxRateRuleSequence;
/*     */   }
/*     */   
/*     */   public Integer getTaxRuleSequence() {
/*  68 */     return this._taxRuleSequence;
/*     */   }
/*     */   
/*     */   public void setTaxRuleSequence(Integer argTaxRuleSequence) {
/*  72 */     this._taxRuleSequence = argTaxRuleSequence;
/*     */   }
/*     */   
/*     */   public void setValue(String argObjectIdValue) {
/*  76 */     String str = argObjectIdValue;
/*  77 */     if (StringUtils.isEmpty(str)) {
/*  78 */       throw new DtxException("argument passed to setValue() is null or empty - a valid value must be passed");
/*     */     }
/*     */     try {
/*  81 */       String[] tokens = str.split("::");
/*  82 */       str = tokens[0];
/*     */       
/*  84 */       if ("null".equals(str)) {
/*  85 */         setExpirationDatetimestamp((Date)null);
/*     */       } else {
/*     */         
/*  88 */         setExpirationDatetimestamp((Date)new DtvDate());
/*  89 */         this._expirationDatetimestamp.setTimeFromSerialization(Long.parseLong(str));
/*     */       } 
/*  91 */       str = tokens[1];
/*     */       
/*  93 */       setOrganizationId(Long.valueOf(str));
/*  94 */       str = tokens[2];
/*     */       
/*  96 */       if ("null".equals(str)) {
/*  97 */         setTaxGroupId((String)null);
/*     */       } else {
/*     */         
/* 100 */         setTaxGroupId(str);
/*     */       } 
/* 102 */       str = tokens[3];
/*     */       
/* 104 */       if ("null".equals(str)) {
/* 105 */         setTaxLocationId((String)null);
/*     */       } else {
/*     */         
/* 108 */         setTaxLocationId(str);
/*     */       } 
/* 110 */       str = tokens[4];
/*     */       
/* 112 */       setTaxRateRuleSequence(Integer.valueOf(str));
/* 113 */       str = tokens[5];
/*     */       
/* 115 */       setTaxRuleSequence(Integer.valueOf(str));
/*     */     }
/* 117 */     catch (Exception ee) {
/* 118 */       throw new DtxException("An exception occured while parsing object id string: " + argObjectIdValue, ee);
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean equals(Object ob) {
/* 124 */     if (this == ob) {
/* 125 */       return true;
/*     */     }
/* 127 */     if (!(ob instanceof TaxRateRuleOverrideId)) {
/* 128 */       return false;
/*     */     }
/* 130 */     TaxRateRuleOverrideId other = (TaxRateRuleOverrideId)ob;
/* 131 */     return (((this._expirationDatetimestamp == null && other._expirationDatetimestamp == null) || (this._expirationDatetimestamp != null && this._expirationDatetimestamp
/*     */ 
/*     */       
/* 134 */       .equals(other._expirationDatetimestamp))) && ((this._organizationId == null && other._organizationId == null) || (this._organizationId != null && this._organizationId
/*     */ 
/*     */       
/* 137 */       .equals(other._organizationId))) && ((this._taxGroupId == null && other._taxGroupId == null) || (this._taxGroupId != null && this._taxGroupId
/*     */ 
/*     */       
/* 140 */       .equals(other._taxGroupId))) && ((this._taxLocationId == null && other._taxLocationId == null) || (this._taxLocationId != null && this._taxLocationId
/*     */ 
/*     */       
/* 143 */       .equals(other._taxLocationId))) && ((this._taxRateRuleSequence == null && other._taxRateRuleSequence == null) || (this._taxRateRuleSequence != null && this._taxRateRuleSequence
/*     */ 
/*     */       
/* 146 */       .equals(other._taxRateRuleSequence))) && ((this._taxRuleSequence == null && other._taxRuleSequence == null) || (this._taxRuleSequence != null && this._taxRuleSequence
/*     */ 
/*     */       
/* 149 */       .equals(other._taxRuleSequence))));
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public int hashCode() {
/* 155 */     return ((this._expirationDatetimestamp == null) ? 0 : this._expirationDatetimestamp
/* 156 */       .hashCode()) + ((this._organizationId == null) ? 0 : this._organizationId
/* 157 */       .hashCode()) + ((this._taxGroupId == null) ? 0 : this._taxGroupId
/* 158 */       .hashCode()) + ((this._taxLocationId == null) ? 0 : this._taxLocationId
/* 159 */       .hashCode()) + ((this._taxRateRuleSequence == null) ? 0 : this._taxRateRuleSequence
/* 160 */       .hashCode()) + ((this._taxRuleSequence == null) ? 0 : this._taxRuleSequence
/* 161 */       .hashCode());
/*     */   }
/*     */ 
/*     */   
/*     */   public String getDtxTypeName() {
/* 166 */     return "TaxRateRuleOverride";
/*     */   }
/*     */ 
/*     */   
/*     */   public String toString() {
/* 171 */     StringBuilder buff = new StringBuilder(72);
/*     */     
/* 173 */     return buff.append((this._expirationDatetimestamp == null) ? "null" : 
/* 174 */         String.valueOf(this._expirationDatetimestamp.getTimeSerializable()))
/* 175 */       .append("::").append(String.valueOf(this._organizationId))
/* 176 */       .append("::").append(this._taxGroupId)
/* 177 */       .append("::").append(this._taxLocationId)
/* 178 */       .append("::").append(String.valueOf(this._taxRateRuleSequence))
/* 179 */       .append("::").append(String.valueOf(this._taxRuleSequence))
/* 180 */       .toString();
/*     */   }
/*     */   
/*     */   public boolean validate() {
/* 184 */     if (this._expirationDatetimestamp == null) {
/* 185 */       return false;
/*     */     }
/* 187 */     if (this._taxGroupId == null) {
/* 188 */       return false;
/*     */     }
/* 190 */     if (this._taxLocationId == null) {
/* 191 */       return false;
/*     */     }
/* 193 */     if (this._taxRateRuleSequence == null) {
/* 194 */       return false;
/*     */     }
/* 196 */     if (this._taxRuleSequence == null) {
/* 197 */       return false;
/*     */     }
/* 199 */     return true;
/*     */   }
/*     */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\tax\TaxRateRuleOverrideId.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */