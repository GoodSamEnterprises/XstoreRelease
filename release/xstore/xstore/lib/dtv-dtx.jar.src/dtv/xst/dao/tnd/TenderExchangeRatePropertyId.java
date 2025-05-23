/*     */ package dtv.xst.dao.tnd;
/*     */ 
/*     */ import dtv.data2.access.AbstractObjectId;
/*     */ import dtv.data2.access.exception.DtxException;
/*     */ import dtv.util.StringUtils;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class TenderExchangeRatePropertyId
/*     */   extends AbstractObjectId
/*     */ {
/*     */   private static final long serialVersionUID = 1042974124L;
/*     */   private String _baseCurrency;
/*     */   private String _targetCurrency;
/*     */   private String _levelCode;
/*     */   private String _levelValue;
/*     */   private String _propertyCode;
/*     */   
/*     */   public TenderExchangeRatePropertyId() {}
/*     */   
/*     */   public TenderExchangeRatePropertyId(String argObjectIdValue) {
/*  23 */     setValue(argObjectIdValue);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getBaseCurrency() {
/*  33 */     return this._baseCurrency;
/*     */   }
/*     */   
/*     */   public void setBaseCurrency(String argBaseCurrency) {
/*  37 */     this._baseCurrency = (argBaseCurrency != null && MANAGE_CASE) ? argBaseCurrency.toUpperCase() : argBaseCurrency;
/*     */   }
/*     */   
/*     */   public String getTargetCurrency() {
/*  41 */     return this._targetCurrency;
/*     */   }
/*     */   
/*     */   public void setTargetCurrency(String argTargetCurrency) {
/*  45 */     this._targetCurrency = (argTargetCurrency != null && MANAGE_CASE) ? argTargetCurrency.toUpperCase() : argTargetCurrency;
/*     */   }
/*     */   
/*     */   public String getLevelCode() {
/*  49 */     return this._levelCode;
/*     */   }
/*     */   
/*     */   public void setLevelCode(String argLevelCode) {
/*  53 */     this._levelCode = (argLevelCode != null && MANAGE_CASE) ? argLevelCode.toUpperCase() : argLevelCode;
/*     */   }
/*     */   
/*     */   public String getLevelValue() {
/*  57 */     return this._levelValue;
/*     */   }
/*     */   
/*     */   public void setLevelValue(String argLevelValue) {
/*  61 */     this._levelValue = (argLevelValue != null && MANAGE_CASE) ? argLevelValue.toUpperCase() : argLevelValue;
/*     */   }
/*     */   
/*     */   public String getPropertyCode() {
/*  65 */     return this._propertyCode;
/*     */   }
/*     */   
/*     */   public void setPropertyCode(String argPropertyCode) {
/*  69 */     this._propertyCode = (argPropertyCode != null && MANAGE_CASE) ? argPropertyCode.toUpperCase() : argPropertyCode;
/*     */   }
/*     */   
/*     */   public void setValue(String argObjectIdValue) {
/*  73 */     String str = argObjectIdValue;
/*  74 */     if (StringUtils.isEmpty(str)) {
/*  75 */       throw new DtxException("argument passed to setValue() is null or empty - a valid value must be passed");
/*     */     }
/*     */     try {
/*  78 */       String[] tokens = str.split("::");
/*  79 */       str = tokens[0];
/*     */       
/*  81 */       setOrganizationId(Long.valueOf(str));
/*  82 */       str = tokens[1];
/*     */       
/*  84 */       if ("null".equals(str)) {
/*  85 */         setBaseCurrency((String)null);
/*     */       } else {
/*     */         
/*  88 */         setBaseCurrency(str);
/*     */       } 
/*  90 */       str = tokens[2];
/*     */       
/*  92 */       if ("null".equals(str)) {
/*  93 */         setTargetCurrency((String)null);
/*     */       } else {
/*     */         
/*  96 */         setTargetCurrency(str);
/*     */       } 
/*  98 */       str = tokens[3];
/*     */       
/* 100 */       if ("null".equals(str)) {
/* 101 */         setLevelCode((String)null);
/*     */       } else {
/*     */         
/* 104 */         setLevelCode(str);
/*     */       } 
/* 106 */       str = tokens[4];
/*     */       
/* 108 */       if ("null".equals(str)) {
/* 109 */         setLevelValue((String)null);
/*     */       } else {
/*     */         
/* 112 */         setLevelValue(str);
/*     */       } 
/* 114 */       str = tokens[5];
/*     */       
/* 116 */       if ("null".equals(str)) {
/* 117 */         setPropertyCode((String)null);
/*     */       } else {
/*     */         
/* 120 */         setPropertyCode(str);
/*     */       }
/*     */     
/* 123 */     } catch (Exception ee) {
/* 124 */       throw new DtxException("An exception occured while parsing object id string: " + argObjectIdValue, ee);
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean equals(Object ob) {
/* 130 */     if (this == ob) {
/* 131 */       return true;
/*     */     }
/* 133 */     if (!(ob instanceof TenderExchangeRatePropertyId)) {
/* 134 */       return false;
/*     */     }
/* 136 */     TenderExchangeRatePropertyId other = (TenderExchangeRatePropertyId)ob;
/* 137 */     return (((this._organizationId == null && other._organizationId == null) || (this._organizationId != null && this._organizationId
/*     */ 
/*     */       
/* 140 */       .equals(other._organizationId))) && ((this._baseCurrency == null && other._baseCurrency == null) || (this._baseCurrency != null && this._baseCurrency
/*     */ 
/*     */       
/* 143 */       .equals(other._baseCurrency))) && ((this._targetCurrency == null && other._targetCurrency == null) || (this._targetCurrency != null && this._targetCurrency
/*     */ 
/*     */       
/* 146 */       .equals(other._targetCurrency))) && ((this._levelCode == null && other._levelCode == null) || (this._levelCode != null && this._levelCode
/*     */ 
/*     */       
/* 149 */       .equals(other._levelCode))) && ((this._levelValue == null && other._levelValue == null) || (this._levelValue != null && this._levelValue
/*     */ 
/*     */       
/* 152 */       .equals(other._levelValue))) && ((this._propertyCode == null && other._propertyCode == null) || (this._propertyCode != null && this._propertyCode
/*     */ 
/*     */       
/* 155 */       .equals(other._propertyCode))));
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public int hashCode() {
/* 161 */     return ((this._organizationId == null) ? 0 : this._organizationId
/* 162 */       .hashCode()) + ((this._baseCurrency == null) ? 0 : this._baseCurrency
/* 163 */       .hashCode()) + ((this._targetCurrency == null) ? 0 : this._targetCurrency
/* 164 */       .hashCode()) + ((this._levelCode == null) ? 0 : this._levelCode
/* 165 */       .hashCode()) + ((this._levelValue == null) ? 0 : this._levelValue
/* 166 */       .hashCode()) + ((this._propertyCode == null) ? 0 : this._propertyCode
/* 167 */       .hashCode());
/*     */   }
/*     */ 
/*     */   
/*     */   public String getDtxTypeName() {
/* 172 */     return "TenderExchangeRateProperty";
/*     */   }
/*     */ 
/*     */   
/*     */   public String toString() {
/* 177 */     StringBuilder buff = new StringBuilder(72);
/*     */     
/* 179 */     return buff.append(
/* 180 */         String.valueOf(this._organizationId))
/* 181 */       .append("::").append(this._baseCurrency)
/* 182 */       .append("::").append(this._targetCurrency)
/* 183 */       .append("::").append(this._levelCode)
/* 184 */       .append("::").append(this._levelValue)
/* 185 */       .append("::").append(this._propertyCode)
/* 186 */       .toString();
/*     */   }
/*     */   
/*     */   public boolean validate() {
/* 190 */     if (this._baseCurrency == null) {
/* 191 */       return false;
/*     */     }
/* 193 */     if (this._targetCurrency == null) {
/* 194 */       return false;
/*     */     }
/* 196 */     if (this._levelCode == null) {
/* 197 */       return false;
/*     */     }
/* 199 */     if (this._levelValue == null) {
/* 200 */       return false;
/*     */     }
/* 202 */     if (this._propertyCode == null) {
/* 203 */       return false;
/*     */     }
/* 205 */     return true;
/*     */   }
/*     */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\tnd\TenderExchangeRatePropertyId.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */