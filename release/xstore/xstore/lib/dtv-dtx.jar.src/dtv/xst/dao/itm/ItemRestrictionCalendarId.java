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
/*     */ 
/*     */ public class ItemRestrictionCalendarId
/*     */   extends AbstractObjectId
/*     */ {
/*     */   private static final long serialVersionUID = -1566239497L;
/*     */   private String _restrictionCategory;
/*     */   private String _restrictionCode;
/*     */   private String _dayCode;
/*     */   private DtvDate _effectiveDate;
/*     */   private DtvDate _startTime;
/*     */   private String _saleLineItemTypeCode;
/*     */   
/*     */   public ItemRestrictionCalendarId() {}
/*     */   
/*     */   public ItemRestrictionCalendarId(String argObjectIdValue) {
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
/*     */   public String getRestrictionCategory() {
/*  38 */     return this._restrictionCategory;
/*     */   }
/*     */   
/*     */   public void setRestrictionCategory(String argRestrictionCategory) {
/*  42 */     this._restrictionCategory = (argRestrictionCategory != null && MANAGE_CASE) ? argRestrictionCategory.toUpperCase() : argRestrictionCategory;
/*     */   }
/*     */   
/*     */   public String getRestrictionCode() {
/*  46 */     return this._restrictionCode;
/*     */   }
/*     */   
/*     */   public void setRestrictionCode(String argRestrictionCode) {
/*  50 */     this._restrictionCode = (argRestrictionCode != null && MANAGE_CASE) ? argRestrictionCode.toUpperCase() : argRestrictionCode;
/*     */   }
/*     */   
/*     */   public String getDayCode() {
/*  54 */     return this._dayCode;
/*     */   }
/*     */   
/*     */   public void setDayCode(String argDayCode) {
/*  58 */     this._dayCode = (argDayCode != null && MANAGE_CASE) ? argDayCode.toUpperCase() : argDayCode;
/*     */   }
/*     */   
/*     */   public Date getEffectiveDate() {
/*  62 */     return (Date)this._effectiveDate;
/*     */   }
/*     */   
/*     */   public void setEffectiveDate(Date argEffectiveDate) {
/*  66 */     this._effectiveDate = (argEffectiveDate == null || argEffectiveDate instanceof DtvDate) ? (DtvDate)argEffectiveDate : new DtvDate(argEffectiveDate);
/*     */   }
/*     */ 
/*     */   
/*     */   public Date getStartTime() {
/*  71 */     return (Date)this._startTime;
/*     */   }
/*     */   
/*     */   public void setStartTime(Date argStartTime) {
/*  75 */     this._startTime = (argStartTime == null || argStartTime instanceof DtvDate) ? (DtvDate)argStartTime : new DtvDate(argStartTime);
/*     */   }
/*     */ 
/*     */   
/*     */   public String getSaleLineItemTypeCode() {
/*  80 */     return this._saleLineItemTypeCode;
/*     */   }
/*     */   
/*     */   public void setSaleLineItemTypeCode(String argSaleLineItemTypeCode) {
/*  84 */     this._saleLineItemTypeCode = (argSaleLineItemTypeCode != null && MANAGE_CASE) ? argSaleLineItemTypeCode.toUpperCase() : argSaleLineItemTypeCode;
/*     */   }
/*     */   
/*     */   public void setValue(String argObjectIdValue) {
/*  88 */     String str = argObjectIdValue;
/*  89 */     if (StringUtils.isEmpty(str)) {
/*  90 */       throw new DtxException("argument passed to setValue() is null or empty - a valid value must be passed");
/*     */     }
/*     */     try {
/*  93 */       String[] tokens = str.split("::");
/*  94 */       str = tokens[0];
/*     */       
/*  96 */       setOrganizationId(Long.valueOf(str));
/*  97 */       str = tokens[1];
/*     */       
/*  99 */       if ("null".equals(str)) {
/* 100 */         setRestrictionCategory((String)null);
/*     */       } else {
/*     */         
/* 103 */         setRestrictionCategory(str);
/*     */       } 
/* 105 */       str = tokens[2];
/*     */       
/* 107 */       if ("null".equals(str)) {
/* 108 */         setRestrictionCode((String)null);
/*     */       } else {
/*     */         
/* 111 */         setRestrictionCode(str);
/*     */       } 
/* 113 */       str = tokens[3];
/*     */       
/* 115 */       if ("null".equals(str)) {
/* 116 */         setDayCode((String)null);
/*     */       } else {
/*     */         
/* 119 */         setDayCode(str);
/*     */       } 
/* 121 */       str = tokens[4];
/*     */       
/* 123 */       if ("null".equals(str)) {
/* 124 */         setEffectiveDate((Date)null);
/*     */       } else {
/*     */         
/* 127 */         setEffectiveDate((Date)new DtvDate());
/* 128 */         this._effectiveDate.setTimeFromSerialization(Long.parseLong(str));
/*     */       } 
/* 130 */       str = tokens[5];
/*     */       
/* 132 */       if ("null".equals(str)) {
/* 133 */         setStartTime((Date)null);
/*     */       } else {
/*     */         
/* 136 */         setStartTime((Date)new DtvDate());
/* 137 */         this._startTime.setTimeFromSerialization(Long.parseLong(str));
/*     */       } 
/* 139 */       str = tokens[6];
/*     */       
/* 141 */       if ("null".equals(str)) {
/* 142 */         setSaleLineItemTypeCode((String)null);
/*     */       } else {
/*     */         
/* 145 */         setSaleLineItemTypeCode(str);
/*     */       }
/*     */     
/* 148 */     } catch (Exception ee) {
/* 149 */       throw new DtxException("An exception occured while parsing object id string: " + argObjectIdValue, ee);
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean equals(Object ob) {
/* 155 */     if (this == ob) {
/* 156 */       return true;
/*     */     }
/* 158 */     if (!(ob instanceof ItemRestrictionCalendarId)) {
/* 159 */       return false;
/*     */     }
/* 161 */     ItemRestrictionCalendarId other = (ItemRestrictionCalendarId)ob;
/* 162 */     return (((this._organizationId == null && other._organizationId == null) || (this._organizationId != null && this._organizationId
/*     */ 
/*     */       
/* 165 */       .equals(other._organizationId))) && ((this._restrictionCategory == null && other._restrictionCategory == null) || (this._restrictionCategory != null && this._restrictionCategory
/*     */ 
/*     */       
/* 168 */       .equals(other._restrictionCategory))) && ((this._restrictionCode == null && other._restrictionCode == null) || (this._restrictionCode != null && this._restrictionCode
/*     */ 
/*     */       
/* 171 */       .equals(other._restrictionCode))) && ((this._dayCode == null && other._dayCode == null) || (this._dayCode != null && this._dayCode
/*     */ 
/*     */       
/* 174 */       .equals(other._dayCode))) && ((this._effectiveDate == null && other._effectiveDate == null) || (this._effectiveDate != null && this._effectiveDate
/*     */ 
/*     */       
/* 177 */       .equals(other._effectiveDate))) && ((this._startTime == null && other._startTime == null) || (this._startTime != null && this._startTime
/*     */ 
/*     */       
/* 180 */       .equals(other._startTime))) && ((this._saleLineItemTypeCode == null && other._saleLineItemTypeCode == null) || (this._saleLineItemTypeCode != null && this._saleLineItemTypeCode
/*     */ 
/*     */       
/* 183 */       .equals(other._saleLineItemTypeCode))));
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public int hashCode() {
/* 189 */     return ((this._organizationId == null) ? 0 : this._organizationId
/* 190 */       .hashCode()) + ((this._restrictionCategory == null) ? 0 : this._restrictionCategory
/* 191 */       .hashCode()) + ((this._restrictionCode == null) ? 0 : this._restrictionCode
/* 192 */       .hashCode()) + ((this._dayCode == null) ? 0 : this._dayCode
/* 193 */       .hashCode()) + ((this._effectiveDate == null) ? 0 : this._effectiveDate
/* 194 */       .hashCode()) + ((this._startTime == null) ? 0 : this._startTime
/* 195 */       .hashCode()) + ((this._saleLineItemTypeCode == null) ? 0 : this._saleLineItemTypeCode
/* 196 */       .hashCode());
/*     */   }
/*     */ 
/*     */   
/*     */   public String getDtxTypeName() {
/* 201 */     return "ItemRestrictionCalendar";
/*     */   }
/*     */ 
/*     */   
/*     */   public String toString() {
/* 206 */     StringBuilder buff = new StringBuilder(84);
/*     */     
/* 208 */     return buff.append(
/* 209 */         String.valueOf(this._organizationId))
/* 210 */       .append("::").append(this._restrictionCategory)
/* 211 */       .append("::").append(this._restrictionCode)
/* 212 */       .append("::").append(this._dayCode)
/* 213 */       .append("::").append((this._effectiveDate == null) ? "null" : String.valueOf(this._effectiveDate.getTimeSerializable()))
/* 214 */       .append("::").append((this._startTime == null) ? "null" : String.valueOf(this._startTime.getTimeSerializable()))
/* 215 */       .append("::").append(this._saleLineItemTypeCode)
/* 216 */       .toString();
/*     */   }
/*     */   
/*     */   public boolean validate() {
/* 220 */     if (this._restrictionCategory == null) {
/* 221 */       return false;
/*     */     }
/* 223 */     if (this._restrictionCode == null) {
/* 224 */       return false;
/*     */     }
/* 226 */     if (this._dayCode == null) {
/* 227 */       return false;
/*     */     }
/* 229 */     if (this._effectiveDate == null) {
/* 230 */       return false;
/*     */     }
/* 232 */     if (this._startTime == null) {
/* 233 */       return false;
/*     */     }
/* 235 */     if (this._saleLineItemTypeCode == null) {
/* 236 */       return false;
/*     */     }
/* 238 */     return true;
/*     */   }
/*     */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\itm\ItemRestrictionCalendarId.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */