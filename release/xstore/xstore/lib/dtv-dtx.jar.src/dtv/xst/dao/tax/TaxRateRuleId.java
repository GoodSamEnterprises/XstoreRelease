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
/*     */ public class TaxRateRuleId
/*     */   extends AbstractObjectId
/*     */ {
/*     */   private static final long serialVersionUID = 133683367L;
/*     */   private String _taxGroupId;
/*     */   private String _taxLocationId;
/*     */   private Integer _taxRateRuleSequence;
/*     */   private Integer _taxRuleSequence;
/*     */   
/*     */   public TaxRateRuleId() {}
/*     */   
/*     */   public TaxRateRuleId(String argObjectIdValue) {
/*  23 */     setValue(argObjectIdValue);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getTaxGroupId() {
/*  32 */     return this._taxGroupId;
/*     */   }
/*     */   
/*     */   public void setTaxGroupId(String argTaxGroupId) {
/*  36 */     this._taxGroupId = (argTaxGroupId != null && MANAGE_CASE) ? argTaxGroupId.toUpperCase() : argTaxGroupId;
/*     */   }
/*     */   
/*     */   public String getTaxLocationId() {
/*  40 */     return this._taxLocationId;
/*     */   }
/*     */   
/*     */   public void setTaxLocationId(String argTaxLocationId) {
/*  44 */     this._taxLocationId = (argTaxLocationId != null && MANAGE_CASE) ? argTaxLocationId.toUpperCase() : argTaxLocationId;
/*     */   }
/*     */   
/*     */   public Integer getTaxRateRuleSequence() {
/*  48 */     return this._taxRateRuleSequence;
/*     */   }
/*     */   
/*     */   public void setTaxRateRuleSequence(Integer argTaxRateRuleSequence) {
/*  52 */     this._taxRateRuleSequence = argTaxRateRuleSequence;
/*     */   }
/*     */   
/*     */   public Integer getTaxRuleSequence() {
/*  56 */     return this._taxRuleSequence;
/*     */   }
/*     */   
/*     */   public void setTaxRuleSequence(Integer argTaxRuleSequence) {
/*  60 */     this._taxRuleSequence = argTaxRuleSequence;
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
/*  76 */         setTaxGroupId((String)null);
/*     */       } else {
/*     */         
/*  79 */         setTaxGroupId(str);
/*     */       } 
/*  81 */       str = tokens[2];
/*     */       
/*  83 */       if ("null".equals(str)) {
/*  84 */         setTaxLocationId((String)null);
/*     */       } else {
/*     */         
/*  87 */         setTaxLocationId(str);
/*     */       } 
/*  89 */       str = tokens[3];
/*     */       
/*  91 */       setTaxRateRuleSequence(Integer.valueOf(str));
/*  92 */       str = tokens[4];
/*     */       
/*  94 */       setTaxRuleSequence(Integer.valueOf(str));
/*     */     }
/*  96 */     catch (Exception ee) {
/*  97 */       throw new DtxException("An exception occured while parsing object id string: " + argObjectIdValue, ee);
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean equals(Object ob) {
/* 103 */     if (this == ob) {
/* 104 */       return true;
/*     */     }
/* 106 */     if (!(ob instanceof TaxRateRuleId)) {
/* 107 */       return false;
/*     */     }
/* 109 */     TaxRateRuleId other = (TaxRateRuleId)ob;
/* 110 */     return (((this._organizationId == null && other._organizationId == null) || (this._organizationId != null && this._organizationId
/*     */ 
/*     */       
/* 113 */       .equals(other._organizationId))) && ((this._taxGroupId == null && other._taxGroupId == null) || (this._taxGroupId != null && this._taxGroupId
/*     */ 
/*     */       
/* 116 */       .equals(other._taxGroupId))) && ((this._taxLocationId == null && other._taxLocationId == null) || (this._taxLocationId != null && this._taxLocationId
/*     */ 
/*     */       
/* 119 */       .equals(other._taxLocationId))) && ((this._taxRateRuleSequence == null && other._taxRateRuleSequence == null) || (this._taxRateRuleSequence != null && this._taxRateRuleSequence
/*     */ 
/*     */       
/* 122 */       .equals(other._taxRateRuleSequence))) && ((this._taxRuleSequence == null && other._taxRuleSequence == null) || (this._taxRuleSequence != null && this._taxRuleSequence
/*     */ 
/*     */       
/* 125 */       .equals(other._taxRuleSequence))));
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public int hashCode() {
/* 131 */     return ((this._organizationId == null) ? 0 : this._organizationId
/* 132 */       .hashCode()) + ((this._taxGroupId == null) ? 0 : this._taxGroupId
/* 133 */       .hashCode()) + ((this._taxLocationId == null) ? 0 : this._taxLocationId
/* 134 */       .hashCode()) + ((this._taxRateRuleSequence == null) ? 0 : this._taxRateRuleSequence
/* 135 */       .hashCode()) + ((this._taxRuleSequence == null) ? 0 : this._taxRuleSequence
/* 136 */       .hashCode());
/*     */   }
/*     */ 
/*     */   
/*     */   public String getDtxTypeName() {
/* 141 */     return "TaxRateRule";
/*     */   }
/*     */ 
/*     */   
/*     */   public String toString() {
/* 146 */     StringBuilder buff = new StringBuilder(60);
/*     */     
/* 148 */     return buff.append(
/* 149 */         String.valueOf(this._organizationId))
/* 150 */       .append("::").append(this._taxGroupId)
/* 151 */       .append("::").append(this._taxLocationId)
/* 152 */       .append("::").append(String.valueOf(this._taxRateRuleSequence))
/* 153 */       .append("::").append(String.valueOf(this._taxRuleSequence))
/* 154 */       .toString();
/*     */   }
/*     */   
/*     */   public boolean validate() {
/* 158 */     if (this._taxGroupId == null) {
/* 159 */       return false;
/*     */     }
/* 161 */     if (this._taxLocationId == null) {
/* 162 */       return false;
/*     */     }
/* 164 */     if (this._taxRateRuleSequence == null) {
/* 165 */       return false;
/*     */     }
/* 167 */     if (this._taxRuleSequence == null) {
/* 168 */       return false;
/*     */     }
/* 170 */     return true;
/*     */   }
/*     */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\tax\TaxRateRuleId.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */