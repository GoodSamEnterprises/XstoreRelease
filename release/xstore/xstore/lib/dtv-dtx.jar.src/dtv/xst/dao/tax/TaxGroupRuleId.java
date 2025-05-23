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
/*     */ public class TaxGroupRuleId
/*     */   extends AbstractObjectId
/*     */ {
/*     */   private static final long serialVersionUID = -1838428464L;
/*     */   private String _taxGroupId;
/*     */   private String _taxLocationId;
/*     */   private Integer _taxRuleSequence;
/*     */   
/*     */   public TaxGroupRuleId() {}
/*     */   
/*     */   public TaxGroupRuleId(String argObjectIdValue) {
/*  23 */     setValue(argObjectIdValue);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getTaxGroupId() {
/*  31 */     return this._taxGroupId;
/*     */   }
/*     */   
/*     */   public void setTaxGroupId(String argTaxGroupId) {
/*  35 */     this._taxGroupId = (argTaxGroupId != null && MANAGE_CASE) ? argTaxGroupId.toUpperCase() : argTaxGroupId;
/*     */   }
/*     */   
/*     */   public String getTaxLocationId() {
/*  39 */     return this._taxLocationId;
/*     */   }
/*     */   
/*     */   public void setTaxLocationId(String argTaxLocationId) {
/*  43 */     this._taxLocationId = (argTaxLocationId != null && MANAGE_CASE) ? argTaxLocationId.toUpperCase() : argTaxLocationId;
/*     */   }
/*     */   
/*     */   public Integer getTaxRuleSequence() {
/*  47 */     return this._taxRuleSequence;
/*     */   }
/*     */   
/*     */   public void setTaxRuleSequence(Integer argTaxRuleSequence) {
/*  51 */     this._taxRuleSequence = argTaxRuleSequence;
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
/*  67 */         setTaxGroupId((String)null);
/*     */       } else {
/*     */         
/*  70 */         setTaxGroupId(str);
/*     */       } 
/*  72 */       str = tokens[2];
/*     */       
/*  74 */       if ("null".equals(str)) {
/*  75 */         setTaxLocationId((String)null);
/*     */       } else {
/*     */         
/*  78 */         setTaxLocationId(str);
/*     */       } 
/*  80 */       str = tokens[3];
/*     */       
/*  82 */       setTaxRuleSequence(Integer.valueOf(str));
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
/*  94 */     if (!(ob instanceof TaxGroupRuleId)) {
/*  95 */       return false;
/*     */     }
/*  97 */     TaxGroupRuleId other = (TaxGroupRuleId)ob;
/*  98 */     return (((this._organizationId == null && other._organizationId == null) || (this._organizationId != null && this._organizationId
/*     */ 
/*     */       
/* 101 */       .equals(other._organizationId))) && ((this._taxGroupId == null && other._taxGroupId == null) || (this._taxGroupId != null && this._taxGroupId
/*     */ 
/*     */       
/* 104 */       .equals(other._taxGroupId))) && ((this._taxLocationId == null && other._taxLocationId == null) || (this._taxLocationId != null && this._taxLocationId
/*     */ 
/*     */       
/* 107 */       .equals(other._taxLocationId))) && ((this._taxRuleSequence == null && other._taxRuleSequence == null) || (this._taxRuleSequence != null && this._taxRuleSequence
/*     */ 
/*     */       
/* 110 */       .equals(other._taxRuleSequence))));
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public int hashCode() {
/* 116 */     return ((this._organizationId == null) ? 0 : this._organizationId
/* 117 */       .hashCode()) + ((this._taxGroupId == null) ? 0 : this._taxGroupId
/* 118 */       .hashCode()) + ((this._taxLocationId == null) ? 0 : this._taxLocationId
/* 119 */       .hashCode()) + ((this._taxRuleSequence == null) ? 0 : this._taxRuleSequence
/* 120 */       .hashCode());
/*     */   }
/*     */ 
/*     */   
/*     */   public String getDtxTypeName() {
/* 125 */     return "TaxGroupRule";
/*     */   }
/*     */ 
/*     */   
/*     */   public String toString() {
/* 130 */     StringBuilder buff = new StringBuilder(48);
/*     */     
/* 132 */     return buff.append(
/* 133 */         String.valueOf(this._organizationId))
/* 134 */       .append("::").append(this._taxGroupId)
/* 135 */       .append("::").append(this._taxLocationId)
/* 136 */       .append("::").append(String.valueOf(this._taxRuleSequence))
/* 137 */       .toString();
/*     */   }
/*     */   
/*     */   public boolean validate() {
/* 141 */     if (this._taxGroupId == null) {
/* 142 */       return false;
/*     */     }
/* 144 */     if (this._taxLocationId == null) {
/* 145 */       return false;
/*     */     }
/* 147 */     if (this._taxRuleSequence == null) {
/* 148 */       return false;
/*     */     }
/* 150 */     return true;
/*     */   }
/*     */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\tax\TaxGroupRuleId.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */