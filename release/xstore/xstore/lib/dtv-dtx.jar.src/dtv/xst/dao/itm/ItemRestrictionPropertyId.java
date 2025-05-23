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
/*     */ public class ItemRestrictionPropertyId
/*     */   extends AbstractObjectId
/*     */ {
/*     */   private static final long serialVersionUID = 1913911182L;
/*     */   private String _restrictionCategory;
/*     */   private String _restrictionCode;
/*     */   private DtvDate _effectiveDate;
/*     */   private String _saleLineItemTypeCode;
/*     */   private String _propertyName;
/*     */   private String _propertyCode;
/*     */   
/*     */   public ItemRestrictionPropertyId() {}
/*     */   
/*     */   public ItemRestrictionPropertyId(String argObjectIdValue) {
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
/*     */   public String getRestrictionCategory() {
/*  36 */     return this._restrictionCategory;
/*     */   }
/*     */   
/*     */   public void setRestrictionCategory(String argRestrictionCategory) {
/*  40 */     this._restrictionCategory = (argRestrictionCategory != null && MANAGE_CASE) ? argRestrictionCategory.toUpperCase() : argRestrictionCategory;
/*     */   }
/*     */   
/*     */   public String getRestrictionCode() {
/*  44 */     return this._restrictionCode;
/*     */   }
/*     */   
/*     */   public void setRestrictionCode(String argRestrictionCode) {
/*  48 */     this._restrictionCode = (argRestrictionCode != null && MANAGE_CASE) ? argRestrictionCode.toUpperCase() : argRestrictionCode;
/*     */   }
/*     */   
/*     */   public Date getEffectiveDate() {
/*  52 */     return (Date)this._effectiveDate;
/*     */   }
/*     */   
/*     */   public void setEffectiveDate(Date argEffectiveDate) {
/*  56 */     this._effectiveDate = (argEffectiveDate == null || argEffectiveDate instanceof DtvDate) ? (DtvDate)argEffectiveDate : new DtvDate(argEffectiveDate);
/*     */   }
/*     */ 
/*     */   
/*     */   public String getSaleLineItemTypeCode() {
/*  61 */     return this._saleLineItemTypeCode;
/*     */   }
/*     */   
/*     */   public void setSaleLineItemTypeCode(String argSaleLineItemTypeCode) {
/*  65 */     this._saleLineItemTypeCode = (argSaleLineItemTypeCode != null && MANAGE_CASE) ? argSaleLineItemTypeCode.toUpperCase() : argSaleLineItemTypeCode;
/*     */   }
/*     */   
/*     */   public String getPropertyName() {
/*  69 */     return this._propertyName;
/*     */   }
/*     */   
/*     */   public void setPropertyName(String argPropertyName) {
/*  73 */     this._propertyName = (argPropertyName != null && MANAGE_CASE) ? argPropertyName.toUpperCase() : argPropertyName;
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
/*  93 */       setOrganizationId(Long.valueOf(str));
/*  94 */       str = tokens[1];
/*     */       
/*  96 */       if ("null".equals(str)) {
/*  97 */         setRestrictionCategory((String)null);
/*     */       } else {
/*     */         
/* 100 */         setRestrictionCategory(str);
/*     */       } 
/* 102 */       str = tokens[2];
/*     */       
/* 104 */       if ("null".equals(str)) {
/* 105 */         setRestrictionCode((String)null);
/*     */       } else {
/*     */         
/* 108 */         setRestrictionCode(str);
/*     */       } 
/* 110 */       str = tokens[3];
/*     */       
/* 112 */       if ("null".equals(str)) {
/* 113 */         setEffectiveDate((Date)null);
/*     */       } else {
/*     */         
/* 116 */         setEffectiveDate((Date)new DtvDate());
/* 117 */         this._effectiveDate.setTimeFromSerialization(Long.parseLong(str));
/*     */       } 
/* 119 */       str = tokens[4];
/*     */       
/* 121 */       if ("null".equals(str)) {
/* 122 */         setSaleLineItemTypeCode((String)null);
/*     */       } else {
/*     */         
/* 125 */         setSaleLineItemTypeCode(str);
/*     */       } 
/* 127 */       str = tokens[5];
/*     */       
/* 129 */       if ("null".equals(str)) {
/* 130 */         setPropertyName((String)null);
/*     */       } else {
/*     */         
/* 133 */         setPropertyName(str);
/*     */       } 
/* 135 */       str = tokens[6];
/*     */       
/* 137 */       if ("null".equals(str)) {
/* 138 */         setPropertyCode((String)null);
/*     */       } else {
/*     */         
/* 141 */         setPropertyCode(str);
/*     */       }
/*     */     
/* 144 */     } catch (Exception ee) {
/* 145 */       throw new DtxException("An exception occured while parsing object id string: " + argObjectIdValue, ee);
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean equals(Object ob) {
/* 151 */     if (this == ob) {
/* 152 */       return true;
/*     */     }
/* 154 */     if (!(ob instanceof ItemRestrictionPropertyId)) {
/* 155 */       return false;
/*     */     }
/* 157 */     ItemRestrictionPropertyId other = (ItemRestrictionPropertyId)ob;
/* 158 */     return (((this._organizationId == null && other._organizationId == null) || (this._organizationId != null && this._organizationId
/*     */ 
/*     */       
/* 161 */       .equals(other._organizationId))) && ((this._restrictionCategory == null && other._restrictionCategory == null) || (this._restrictionCategory != null && this._restrictionCategory
/*     */ 
/*     */       
/* 164 */       .equals(other._restrictionCategory))) && ((this._restrictionCode == null && other._restrictionCode == null) || (this._restrictionCode != null && this._restrictionCode
/*     */ 
/*     */       
/* 167 */       .equals(other._restrictionCode))) && ((this._effectiveDate == null && other._effectiveDate == null) || (this._effectiveDate != null && this._effectiveDate
/*     */ 
/*     */       
/* 170 */       .equals(other._effectiveDate))) && ((this._saleLineItemTypeCode == null && other._saleLineItemTypeCode == null) || (this._saleLineItemTypeCode != null && this._saleLineItemTypeCode
/*     */ 
/*     */       
/* 173 */       .equals(other._saleLineItemTypeCode))) && ((this._propertyName == null && other._propertyName == null) || (this._propertyName != null && this._propertyName
/*     */ 
/*     */       
/* 176 */       .equals(other._propertyName))) && ((this._propertyCode == null && other._propertyCode == null) || (this._propertyCode != null && this._propertyCode
/*     */ 
/*     */       
/* 179 */       .equals(other._propertyCode))));
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public int hashCode() {
/* 185 */     return ((this._organizationId == null) ? 0 : this._organizationId
/* 186 */       .hashCode()) + ((this._restrictionCategory == null) ? 0 : this._restrictionCategory
/* 187 */       .hashCode()) + ((this._restrictionCode == null) ? 0 : this._restrictionCode
/* 188 */       .hashCode()) + ((this._effectiveDate == null) ? 0 : this._effectiveDate
/* 189 */       .hashCode()) + ((this._saleLineItemTypeCode == null) ? 0 : this._saleLineItemTypeCode
/* 190 */       .hashCode()) + ((this._propertyName == null) ? 0 : this._propertyName
/* 191 */       .hashCode()) + ((this._propertyCode == null) ? 0 : this._propertyCode
/* 192 */       .hashCode());
/*     */   }
/*     */ 
/*     */   
/*     */   public String getDtxTypeName() {
/* 197 */     return "ItemRestrictionProperty";
/*     */   }
/*     */ 
/*     */   
/*     */   public String toString() {
/* 202 */     StringBuilder buff = new StringBuilder(84);
/*     */     
/* 204 */     return buff.append(
/* 205 */         String.valueOf(this._organizationId))
/* 206 */       .append("::").append(this._restrictionCategory)
/* 207 */       .append("::").append(this._restrictionCode)
/* 208 */       .append("::").append((this._effectiveDate == null) ? "null" : String.valueOf(this._effectiveDate.getTimeSerializable()))
/* 209 */       .append("::").append(this._saleLineItemTypeCode)
/* 210 */       .append("::").append(this._propertyName)
/* 211 */       .append("::").append(this._propertyCode)
/* 212 */       .toString();
/*     */   }
/*     */   
/*     */   public boolean validate() {
/* 216 */     if (this._restrictionCategory == null) {
/* 217 */       return false;
/*     */     }
/* 219 */     if (this._restrictionCode == null) {
/* 220 */       return false;
/*     */     }
/* 222 */     if (this._effectiveDate == null) {
/* 223 */       return false;
/*     */     }
/* 225 */     if (this._saleLineItemTypeCode == null) {
/* 226 */       return false;
/*     */     }
/* 228 */     if (this._propertyName == null) {
/* 229 */       return false;
/*     */     }
/* 231 */     if (this._propertyCode == null) {
/* 232 */       return false;
/*     */     }
/* 234 */     return true;
/*     */   }
/*     */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\itm\ItemRestrictionPropertyId.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */