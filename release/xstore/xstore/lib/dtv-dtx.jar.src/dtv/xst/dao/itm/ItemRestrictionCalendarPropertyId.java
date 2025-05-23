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
/*     */ public class ItemRestrictionCalendarPropertyId
/*     */   extends AbstractObjectId
/*     */ {
/*     */   private static final long serialVersionUID = 1560309740L;
/*     */   private String _restrictionCategory;
/*     */   private String _restrictionCode;
/*     */   private String _dayCode;
/*     */   private DtvDate _effectiveDate;
/*     */   private DtvDate _startTime;
/*     */   private String _saleLineItemTypeCode;
/*     */   private String _propertyCode;
/*     */   
/*     */   public ItemRestrictionCalendarPropertyId() {}
/*     */   
/*     */   public ItemRestrictionCalendarPropertyId(String argObjectIdValue) {
/*  27 */     setValue(argObjectIdValue);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getRestrictionCategory() {
/*  39 */     return this._restrictionCategory;
/*     */   }
/*     */   
/*     */   public void setRestrictionCategory(String argRestrictionCategory) {
/*  43 */     this._restrictionCategory = (argRestrictionCategory != null && MANAGE_CASE) ? argRestrictionCategory.toUpperCase() : argRestrictionCategory;
/*     */   }
/*     */   
/*     */   public String getRestrictionCode() {
/*  47 */     return this._restrictionCode;
/*     */   }
/*     */   
/*     */   public void setRestrictionCode(String argRestrictionCode) {
/*  51 */     this._restrictionCode = (argRestrictionCode != null && MANAGE_CASE) ? argRestrictionCode.toUpperCase() : argRestrictionCode;
/*     */   }
/*     */   
/*     */   public String getDayCode() {
/*  55 */     return this._dayCode;
/*     */   }
/*     */   
/*     */   public void setDayCode(String argDayCode) {
/*  59 */     this._dayCode = (argDayCode != null && MANAGE_CASE) ? argDayCode.toUpperCase() : argDayCode;
/*     */   }
/*     */   
/*     */   public Date getEffectiveDate() {
/*  63 */     return (Date)this._effectiveDate;
/*     */   }
/*     */   
/*     */   public void setEffectiveDate(Date argEffectiveDate) {
/*  67 */     this._effectiveDate = (argEffectiveDate == null || argEffectiveDate instanceof DtvDate) ? (DtvDate)argEffectiveDate : new DtvDate(argEffectiveDate);
/*     */   }
/*     */ 
/*     */   
/*     */   public Date getStartTime() {
/*  72 */     return (Date)this._startTime;
/*     */   }
/*     */   
/*     */   public void setStartTime(Date argStartTime) {
/*  76 */     this._startTime = (argStartTime == null || argStartTime instanceof DtvDate) ? (DtvDate)argStartTime : new DtvDate(argStartTime);
/*     */   }
/*     */ 
/*     */   
/*     */   public String getSaleLineItemTypeCode() {
/*  81 */     return this._saleLineItemTypeCode;
/*     */   }
/*     */   
/*     */   public void setSaleLineItemTypeCode(String argSaleLineItemTypeCode) {
/*  85 */     this._saleLineItemTypeCode = (argSaleLineItemTypeCode != null && MANAGE_CASE) ? argSaleLineItemTypeCode.toUpperCase() : argSaleLineItemTypeCode;
/*     */   }
/*     */   
/*     */   public String getPropertyCode() {
/*  89 */     return this._propertyCode;
/*     */   }
/*     */   
/*     */   public void setPropertyCode(String argPropertyCode) {
/*  93 */     this._propertyCode = (argPropertyCode != null && MANAGE_CASE) ? argPropertyCode.toUpperCase() : argPropertyCode;
/*     */   }
/*     */   
/*     */   public void setValue(String argObjectIdValue) {
/*  97 */     String str = argObjectIdValue;
/*  98 */     if (StringUtils.isEmpty(str)) {
/*  99 */       throw new DtxException("argument passed to setValue() is null or empty - a valid value must be passed");
/*     */     }
/*     */     try {
/* 102 */       String[] tokens = str.split("::");
/* 103 */       str = tokens[0];
/*     */       
/* 105 */       setOrganizationId(Long.valueOf(str));
/* 106 */       str = tokens[1];
/*     */       
/* 108 */       if ("null".equals(str)) {
/* 109 */         setRestrictionCategory((String)null);
/*     */       } else {
/*     */         
/* 112 */         setRestrictionCategory(str);
/*     */       } 
/* 114 */       str = tokens[2];
/*     */       
/* 116 */       if ("null".equals(str)) {
/* 117 */         setRestrictionCode((String)null);
/*     */       } else {
/*     */         
/* 120 */         setRestrictionCode(str);
/*     */       } 
/* 122 */       str = tokens[3];
/*     */       
/* 124 */       if ("null".equals(str)) {
/* 125 */         setDayCode((String)null);
/*     */       } else {
/*     */         
/* 128 */         setDayCode(str);
/*     */       } 
/* 130 */       str = tokens[4];
/*     */       
/* 132 */       if ("null".equals(str)) {
/* 133 */         setEffectiveDate((Date)null);
/*     */       } else {
/*     */         
/* 136 */         setEffectiveDate((Date)new DtvDate());
/* 137 */         this._effectiveDate.setTimeFromSerialization(Long.parseLong(str));
/*     */       } 
/* 139 */       str = tokens[5];
/*     */       
/* 141 */       if ("null".equals(str)) {
/* 142 */         setStartTime((Date)null);
/*     */       } else {
/*     */         
/* 145 */         setStartTime((Date)new DtvDate());
/* 146 */         this._startTime.setTimeFromSerialization(Long.parseLong(str));
/*     */       } 
/* 148 */       str = tokens[6];
/*     */       
/* 150 */       if ("null".equals(str)) {
/* 151 */         setSaleLineItemTypeCode((String)null);
/*     */       } else {
/*     */         
/* 154 */         setSaleLineItemTypeCode(str);
/*     */       } 
/* 156 */       str = tokens[7];
/*     */       
/* 158 */       if ("null".equals(str)) {
/* 159 */         setPropertyCode((String)null);
/*     */       } else {
/*     */         
/* 162 */         setPropertyCode(str);
/*     */       }
/*     */     
/* 165 */     } catch (Exception ee) {
/* 166 */       throw new DtxException("An exception occured while parsing object id string: " + argObjectIdValue, ee);
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean equals(Object ob) {
/* 172 */     if (this == ob) {
/* 173 */       return true;
/*     */     }
/* 175 */     if (!(ob instanceof ItemRestrictionCalendarPropertyId)) {
/* 176 */       return false;
/*     */     }
/* 178 */     ItemRestrictionCalendarPropertyId other = (ItemRestrictionCalendarPropertyId)ob;
/* 179 */     return (((this._organizationId == null && other._organizationId == null) || (this._organizationId != null && this._organizationId
/*     */ 
/*     */       
/* 182 */       .equals(other._organizationId))) && ((this._restrictionCategory == null && other._restrictionCategory == null) || (this._restrictionCategory != null && this._restrictionCategory
/*     */ 
/*     */       
/* 185 */       .equals(other._restrictionCategory))) && ((this._restrictionCode == null && other._restrictionCode == null) || (this._restrictionCode != null && this._restrictionCode
/*     */ 
/*     */       
/* 188 */       .equals(other._restrictionCode))) && ((this._dayCode == null && other._dayCode == null) || (this._dayCode != null && this._dayCode
/*     */ 
/*     */       
/* 191 */       .equals(other._dayCode))) && ((this._effectiveDate == null && other._effectiveDate == null) || (this._effectiveDate != null && this._effectiveDate
/*     */ 
/*     */       
/* 194 */       .equals(other._effectiveDate))) && ((this._startTime == null && other._startTime == null) || (this._startTime != null && this._startTime
/*     */ 
/*     */       
/* 197 */       .equals(other._startTime))) && ((this._saleLineItemTypeCode == null && other._saleLineItemTypeCode == null) || (this._saleLineItemTypeCode != null && this._saleLineItemTypeCode
/*     */ 
/*     */       
/* 200 */       .equals(other._saleLineItemTypeCode))) && ((this._propertyCode == null && other._propertyCode == null) || (this._propertyCode != null && this._propertyCode
/*     */ 
/*     */       
/* 203 */       .equals(other._propertyCode))));
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public int hashCode() {
/* 209 */     return ((this._organizationId == null) ? 0 : this._organizationId
/* 210 */       .hashCode()) + ((this._restrictionCategory == null) ? 0 : this._restrictionCategory
/* 211 */       .hashCode()) + ((this._restrictionCode == null) ? 0 : this._restrictionCode
/* 212 */       .hashCode()) + ((this._dayCode == null) ? 0 : this._dayCode
/* 213 */       .hashCode()) + ((this._effectiveDate == null) ? 0 : this._effectiveDate
/* 214 */       .hashCode()) + ((this._startTime == null) ? 0 : this._startTime
/* 215 */       .hashCode()) + ((this._saleLineItemTypeCode == null) ? 0 : this._saleLineItemTypeCode
/* 216 */       .hashCode()) + ((this._propertyCode == null) ? 0 : this._propertyCode
/* 217 */       .hashCode());
/*     */   }
/*     */ 
/*     */   
/*     */   public String getDtxTypeName() {
/* 222 */     return "ItemRestrictionCalendarProperty";
/*     */   }
/*     */ 
/*     */   
/*     */   public String toString() {
/* 227 */     StringBuilder buff = new StringBuilder(96);
/*     */     
/* 229 */     return buff.append(
/* 230 */         String.valueOf(this._organizationId))
/* 231 */       .append("::").append(this._restrictionCategory)
/* 232 */       .append("::").append(this._restrictionCode)
/* 233 */       .append("::").append(this._dayCode)
/* 234 */       .append("::").append((this._effectiveDate == null) ? "null" : String.valueOf(this._effectiveDate.getTimeSerializable()))
/* 235 */       .append("::").append((this._startTime == null) ? "null" : String.valueOf(this._startTime.getTimeSerializable()))
/* 236 */       .append("::").append(this._saleLineItemTypeCode)
/* 237 */       .append("::").append(this._propertyCode)
/* 238 */       .toString();
/*     */   }
/*     */   
/*     */   public boolean validate() {
/* 242 */     if (this._restrictionCategory == null) {
/* 243 */       return false;
/*     */     }
/* 245 */     if (this._restrictionCode == null) {
/* 246 */       return false;
/*     */     }
/* 248 */     if (this._dayCode == null) {
/* 249 */       return false;
/*     */     }
/* 251 */     if (this._effectiveDate == null) {
/* 252 */       return false;
/*     */     }
/* 254 */     if (this._startTime == null) {
/* 255 */       return false;
/*     */     }
/* 257 */     if (this._saleLineItemTypeCode == null) {
/* 258 */       return false;
/*     */     }
/* 260 */     if (this._propertyCode == null) {
/* 261 */       return false;
/*     */     }
/* 263 */     return true;
/*     */   }
/*     */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\itm\ItemRestrictionCalendarPropertyId.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */