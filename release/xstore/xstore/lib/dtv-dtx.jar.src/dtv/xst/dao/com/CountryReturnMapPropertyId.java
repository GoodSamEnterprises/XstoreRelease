/*     */ package dtv.xst.dao.com;
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
/*     */ public class CountryReturnMapPropertyId
/*     */   extends AbstractObjectId
/*     */ {
/*     */   private static final long serialVersionUID = -1014136021L;
/*     */   private String _purchasedFrom;
/*     */   private String _returnTo;
/*     */   private String _propertyCode;
/*     */   
/*     */   public CountryReturnMapPropertyId() {}
/*     */   
/*     */   public CountryReturnMapPropertyId(String argObjectIdValue) {
/*  23 */     setValue(argObjectIdValue);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getPurchasedFrom() {
/*  31 */     return this._purchasedFrom;
/*     */   }
/*     */   
/*     */   public void setPurchasedFrom(String argPurchasedFrom) {
/*  35 */     this._purchasedFrom = (argPurchasedFrom != null && MANAGE_CASE) ? argPurchasedFrom.toUpperCase() : argPurchasedFrom;
/*     */   }
/*     */   
/*     */   public String getReturnTo() {
/*  39 */     return this._returnTo;
/*     */   }
/*     */   
/*     */   public void setReturnTo(String argReturnTo) {
/*  43 */     this._returnTo = (argReturnTo != null && MANAGE_CASE) ? argReturnTo.toUpperCase() : argReturnTo;
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
/*  63 */       setOrganizationId(Long.valueOf(str));
/*  64 */       str = tokens[1];
/*     */       
/*  66 */       if ("null".equals(str)) {
/*  67 */         setPurchasedFrom((String)null);
/*     */       } else {
/*     */         
/*  70 */         setPurchasedFrom(str);
/*     */       } 
/*  72 */       str = tokens[2];
/*     */       
/*  74 */       if ("null".equals(str)) {
/*  75 */         setReturnTo((String)null);
/*     */       } else {
/*     */         
/*  78 */         setReturnTo(str);
/*     */       } 
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
/*  99 */     if (!(ob instanceof CountryReturnMapPropertyId)) {
/* 100 */       return false;
/*     */     }
/* 102 */     CountryReturnMapPropertyId other = (CountryReturnMapPropertyId)ob;
/* 103 */     return (((this._organizationId == null && other._organizationId == null) || (this._organizationId != null && this._organizationId
/*     */ 
/*     */       
/* 106 */       .equals(other._organizationId))) && ((this._purchasedFrom == null && other._purchasedFrom == null) || (this._purchasedFrom != null && this._purchasedFrom
/*     */ 
/*     */       
/* 109 */       .equals(other._purchasedFrom))) && ((this._returnTo == null && other._returnTo == null) || (this._returnTo != null && this._returnTo
/*     */ 
/*     */       
/* 112 */       .equals(other._returnTo))) && ((this._propertyCode == null && other._propertyCode == null) || (this._propertyCode != null && this._propertyCode
/*     */ 
/*     */       
/* 115 */       .equals(other._propertyCode))));
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public int hashCode() {
/* 121 */     return ((this._organizationId == null) ? 0 : this._organizationId
/* 122 */       .hashCode()) + ((this._purchasedFrom == null) ? 0 : this._purchasedFrom
/* 123 */       .hashCode()) + ((this._returnTo == null) ? 0 : this._returnTo
/* 124 */       .hashCode()) + ((this._propertyCode == null) ? 0 : this._propertyCode
/* 125 */       .hashCode());
/*     */   }
/*     */ 
/*     */   
/*     */   public String getDtxTypeName() {
/* 130 */     return "CountryReturnMapProperty";
/*     */   }
/*     */ 
/*     */   
/*     */   public String toString() {
/* 135 */     StringBuilder buff = new StringBuilder(48);
/*     */     
/* 137 */     return buff.append(
/* 138 */         String.valueOf(this._organizationId))
/* 139 */       .append("::").append(this._purchasedFrom)
/* 140 */       .append("::").append(this._returnTo)
/* 141 */       .append("::").append(this._propertyCode)
/* 142 */       .toString();
/*     */   }
/*     */   
/*     */   public boolean validate() {
/* 146 */     if (this._purchasedFrom == null) {
/* 147 */       return false;
/*     */     }
/* 149 */     if (this._returnTo == null) {
/* 150 */       return false;
/*     */     }
/* 152 */     if (this._propertyCode == null) {
/* 153 */       return false;
/*     */     }
/* 155 */     return true;
/*     */   }
/*     */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\com\CountryReturnMapPropertyId.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */