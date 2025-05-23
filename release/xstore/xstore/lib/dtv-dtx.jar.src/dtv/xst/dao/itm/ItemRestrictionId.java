/*     */ package dtv.xst.dao.itm;
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
/*     */ public class ItemRestrictionId
/*     */   extends AbstractObjectId
/*     */ {
/*     */   private static final long serialVersionUID = 1589862041L;
/*     */   private String _restrictionCategory;
/*     */   private String _restrictionCode;
/*     */   private DtvDate _effectiveDate;
/*     */   private String _saleLineItemTypeCode;
/*     */   private String _propertyName;
/*     */   
/*     */   public ItemRestrictionId() {}
/*     */   
/*     */   public ItemRestrictionId(String argObjectIdValue) {
/*  25 */     setValue(argObjectIdValue);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getRestrictionCategory() {
/*  35 */     return this._restrictionCategory;
/*     */   }
/*     */   
/*     */   public void setRestrictionCategory(String argRestrictionCategory) {
/*  39 */     this._restrictionCategory = (argRestrictionCategory != null && MANAGE_CASE) ? argRestrictionCategory.toUpperCase() : argRestrictionCategory;
/*     */   }
/*     */   
/*     */   public String getRestrictionCode() {
/*  43 */     return this._restrictionCode;
/*     */   }
/*     */   
/*     */   public void setRestrictionCode(String argRestrictionCode) {
/*  47 */     this._restrictionCode = (argRestrictionCode != null && MANAGE_CASE) ? argRestrictionCode.toUpperCase() : argRestrictionCode;
/*     */   }
/*     */   
/*     */   public Date getEffectiveDate() {
/*  51 */     return (Date)this._effectiveDate;
/*     */   }
/*     */   
/*     */   public void setEffectiveDate(Date argEffectiveDate) {
/*  55 */     this._effectiveDate = (argEffectiveDate == null || argEffectiveDate instanceof DtvDate) ? (DtvDate)argEffectiveDate : new DtvDate(argEffectiveDate);
/*     */   }
/*     */ 
/*     */   
/*     */   public String getSaleLineItemTypeCode() {
/*  60 */     return this._saleLineItemTypeCode;
/*     */   }
/*     */   
/*     */   public void setSaleLineItemTypeCode(String argSaleLineItemTypeCode) {
/*  64 */     this._saleLineItemTypeCode = (argSaleLineItemTypeCode != null && MANAGE_CASE) ? argSaleLineItemTypeCode.toUpperCase() : argSaleLineItemTypeCode;
/*     */   }
/*     */   
/*     */   public String getPropertyName() {
/*  68 */     return this._propertyName;
/*     */   }
/*     */   
/*     */   public void setPropertyName(String argPropertyName) {
/*  72 */     this._propertyName = (argPropertyName != null && MANAGE_CASE) ? argPropertyName.toUpperCase() : argPropertyName;
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
/*  84 */       setOrganizationId(Long.valueOf(str));
/*  85 */       str = tokens[1];
/*     */       
/*  87 */       if ("null".equals(str)) {
/*  88 */         setRestrictionCategory((String)null);
/*     */       } else {
/*     */         
/*  91 */         setRestrictionCategory(str);
/*     */       } 
/*  93 */       str = tokens[2];
/*     */       
/*  95 */       if ("null".equals(str)) {
/*  96 */         setRestrictionCode((String)null);
/*     */       } else {
/*     */         
/*  99 */         setRestrictionCode(str);
/*     */       } 
/* 101 */       str = tokens[3];
/*     */       
/* 103 */       if ("null".equals(str)) {
/* 104 */         setEffectiveDate((Date)null);
/*     */       } else {
/*     */         
/* 107 */         setEffectiveDate((Date)new DtvDate());
/* 108 */         this._effectiveDate.setTimeFromSerialization(Long.parseLong(str));
/*     */       } 
/* 110 */       str = tokens[4];
/*     */       
/* 112 */       if ("null".equals(str)) {
/* 113 */         setSaleLineItemTypeCode((String)null);
/*     */       } else {
/*     */         
/* 116 */         setSaleLineItemTypeCode(str);
/*     */       } 
/* 118 */       str = tokens[5];
/*     */       
/* 120 */       if ("null".equals(str)) {
/* 121 */         setPropertyName((String)null);
/*     */       } else {
/*     */         
/* 124 */         setPropertyName(str);
/*     */       }
/*     */     
/* 127 */     } catch (Exception ee) {
/* 128 */       throw new DtxException("An exception occured while parsing object id string: " + argObjectIdValue, ee);
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean equals(Object ob) {
/* 134 */     if (this == ob) {
/* 135 */       return true;
/*     */     }
/* 137 */     if (!(ob instanceof ItemRestrictionId)) {
/* 138 */       return false;
/*     */     }
/* 140 */     ItemRestrictionId other = (ItemRestrictionId)ob;
/* 141 */     return (((this._organizationId == null && other._organizationId == null) || (this._organizationId != null && this._organizationId
/*     */ 
/*     */       
/* 144 */       .equals(other._organizationId))) && ((this._restrictionCategory == null && other._restrictionCategory == null) || (this._restrictionCategory != null && this._restrictionCategory
/*     */ 
/*     */       
/* 147 */       .equals(other._restrictionCategory))) && ((this._restrictionCode == null && other._restrictionCode == null) || (this._restrictionCode != null && this._restrictionCode
/*     */ 
/*     */       
/* 150 */       .equals(other._restrictionCode))) && ((this._effectiveDate == null && other._effectiveDate == null) || (this._effectiveDate != null && this._effectiveDate
/*     */ 
/*     */       
/* 153 */       .equals(other._effectiveDate))) && ((this._saleLineItemTypeCode == null && other._saleLineItemTypeCode == null) || (this._saleLineItemTypeCode != null && this._saleLineItemTypeCode
/*     */ 
/*     */       
/* 156 */       .equals(other._saleLineItemTypeCode))) && ((this._propertyName == null && other._propertyName == null) || (this._propertyName != null && this._propertyName
/*     */ 
/*     */       
/* 159 */       .equals(other._propertyName))));
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public int hashCode() {
/* 165 */     return ((this._organizationId == null) ? 0 : this._organizationId
/* 166 */       .hashCode()) + ((this._restrictionCategory == null) ? 0 : this._restrictionCategory
/* 167 */       .hashCode()) + ((this._restrictionCode == null) ? 0 : this._restrictionCode
/* 168 */       .hashCode()) + ((this._effectiveDate == null) ? 0 : this._effectiveDate
/* 169 */       .hashCode()) + ((this._saleLineItemTypeCode == null) ? 0 : this._saleLineItemTypeCode
/* 170 */       .hashCode()) + ((this._propertyName == null) ? 0 : this._propertyName
/* 171 */       .hashCode());
/*     */   }
/*     */ 
/*     */   
/*     */   public String getDtxTypeName() {
/* 176 */     return "ItemRestriction";
/*     */   }
/*     */ 
/*     */   
/*     */   public String toString() {
/* 181 */     StringBuilder buff = new StringBuilder(72);
/*     */     
/* 183 */     return buff.append(
/* 184 */         String.valueOf(this._organizationId))
/* 185 */       .append("::").append(this._restrictionCategory)
/* 186 */       .append("::").append(this._restrictionCode)
/* 187 */       .append("::").append((this._effectiveDate == null) ? "null" : String.valueOf(this._effectiveDate.getTimeSerializable()))
/* 188 */       .append("::").append(this._saleLineItemTypeCode)
/* 189 */       .append("::").append(this._propertyName)
/* 190 */       .toString();
/*     */   }
/*     */   
/*     */   public boolean validate() {
/* 194 */     if (this._restrictionCategory == null) {
/* 195 */       return false;
/*     */     }
/* 197 */     if (this._restrictionCode == null) {
/* 198 */       return false;
/*     */     }
/* 200 */     if (this._effectiveDate == null) {
/* 201 */       return false;
/*     */     }
/* 203 */     if (this._saleLineItemTypeCode == null) {
/* 204 */       return false;
/*     */     }
/* 206 */     if (this._propertyName == null) {
/* 207 */       return false;
/*     */     }
/* 209 */     return true;
/*     */   }
/*     */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\itm\ItemRestrictionId.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */