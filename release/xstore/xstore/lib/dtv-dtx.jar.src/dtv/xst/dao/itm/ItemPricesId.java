/*     */ package dtv.xst.dao.itm;
/*     */ 
/*     */ import dtv.data2.access.AbstractObjectId;
/*     */ import dtv.data2.access.exception.DtxException;
/*     */ import dtv.util.DtvDate;
/*     */ import dtv.util.StringUtils;
/*     */ import java.math.BigDecimal;
/*     */ import java.text.DecimalFormat;
/*     */ import java.util.Date;
/*     */ 
/*     */ 
/*     */ 
/*     */ public class ItemPricesId
/*     */   extends AbstractObjectId
/*     */ {
/*     */   private static final long serialVersionUID = -389226147L;
/*     */   private String _itemId;
/*     */   private String _levelCode;
/*     */   private String _levelValue;
/*     */   private String _itemPricePropertyCode;
/*     */   private DtvDate _effectiveDate;
/*     */   private BigDecimal _pricingQuantity;
/*     */   
/*     */   public ItemPricesId() {}
/*     */   
/*     */   public ItemPricesId(String argObjectIdValue) {
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
/*     */   public String getItemId() {
/*  38 */     return this._itemId;
/*     */   }
/*     */   
/*     */   public void setItemId(String argItemId) {
/*  42 */     this._itemId = (argItemId != null && MANAGE_CASE) ? argItemId.toUpperCase() : argItemId;
/*     */   }
/*     */   
/*     */   public String getLevelCode() {
/*  46 */     return this._levelCode;
/*     */   }
/*     */   
/*     */   public void setLevelCode(String argLevelCode) {
/*  50 */     this._levelCode = (argLevelCode != null && MANAGE_CASE) ? argLevelCode.toUpperCase() : argLevelCode;
/*     */   }
/*     */   
/*     */   public String getLevelValue() {
/*  54 */     return this._levelValue;
/*     */   }
/*     */   
/*     */   public void setLevelValue(String argLevelValue) {
/*  58 */     this._levelValue = (argLevelValue != null && MANAGE_CASE) ? argLevelValue.toUpperCase() : argLevelValue;
/*     */   }
/*     */   
/*     */   public String getItemPricePropertyCode() {
/*  62 */     return this._itemPricePropertyCode;
/*     */   }
/*     */   
/*     */   public void setItemPricePropertyCode(String argItemPricePropertyCode) {
/*  66 */     this._itemPricePropertyCode = (argItemPricePropertyCode != null && MANAGE_CASE) ? argItemPricePropertyCode.toUpperCase() : argItemPricePropertyCode;
/*     */   }
/*     */   
/*     */   public Date getEffectiveDate() {
/*  70 */     return (Date)this._effectiveDate;
/*     */   }
/*     */   
/*     */   public void setEffectiveDate(Date argEffectiveDate) {
/*  74 */     this._effectiveDate = (argEffectiveDate == null || argEffectiveDate instanceof DtvDate) ? (DtvDate)argEffectiveDate : new DtvDate(argEffectiveDate);
/*     */   }
/*     */ 
/*     */   
/*     */   public BigDecimal getPricingQuantity() {
/*  79 */     return this._pricingQuantity;
/*     */   }
/*     */   
/*     */   public void setPricingQuantity(BigDecimal argPricingQuantity) {
/*  83 */     this._pricingQuantity = argPricingQuantity;
/*     */   }
/*     */   
/*     */   public void setValue(String argObjectIdValue) {
/*  87 */     String str = argObjectIdValue;
/*  88 */     if (StringUtils.isEmpty(str)) {
/*  89 */       throw new DtxException("argument passed to setValue() is null or empty - a valid value must be passed");
/*     */     }
/*     */     try {
/*  92 */       String[] tokens = str.split("::");
/*  93 */       str = tokens[0];
/*     */       
/*  95 */       setOrganizationId(Long.valueOf(str));
/*  96 */       str = tokens[1];
/*     */       
/*  98 */       if ("null".equals(str)) {
/*  99 */         setItemId((String)null);
/*     */       } else {
/*     */         
/* 102 */         setItemId(str);
/*     */       } 
/* 104 */       str = tokens[2];
/*     */       
/* 106 */       if ("null".equals(str)) {
/* 107 */         setLevelCode((String)null);
/*     */       } else {
/*     */         
/* 110 */         setLevelCode(str);
/*     */       } 
/* 112 */       str = tokens[3];
/*     */       
/* 114 */       if ("null".equals(str)) {
/* 115 */         setLevelValue((String)null);
/*     */       } else {
/*     */         
/* 118 */         setLevelValue(str);
/*     */       } 
/* 120 */       str = tokens[4];
/*     */       
/* 122 */       if ("null".equals(str)) {
/* 123 */         setItemPricePropertyCode((String)null);
/*     */       } else {
/*     */         
/* 126 */         setItemPricePropertyCode(str);
/*     */       } 
/* 128 */       str = tokens[5];
/*     */       
/* 130 */       if ("null".equals(str)) {
/* 131 */         setEffectiveDate((Date)null);
/*     */       } else {
/*     */         
/* 134 */         setEffectiveDate((Date)new DtvDate());
/* 135 */         this._effectiveDate.setTimeFromSerialization(Long.parseLong(str));
/*     */       } 
/* 137 */       str = tokens[6];
/*     */       
/* 139 */       setPricingQuantity(new BigDecimal(str));
/*     */     }
/* 141 */     catch (Exception ee) {
/* 142 */       throw new DtxException("An exception occured while parsing object id string: " + argObjectIdValue, ee);
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean equals(Object ob) {
/* 148 */     if (this == ob) {
/* 149 */       return true;
/*     */     }
/* 151 */     if (!(ob instanceof ItemPricesId)) {
/* 152 */       return false;
/*     */     }
/* 154 */     ItemPricesId other = (ItemPricesId)ob;
/* 155 */     return (((this._organizationId == null && other._organizationId == null) || (this._organizationId != null && this._organizationId
/*     */ 
/*     */       
/* 158 */       .equals(other._organizationId))) && ((this._itemId == null && other._itemId == null) || (this._itemId != null && this._itemId
/*     */ 
/*     */       
/* 161 */       .equals(other._itemId))) && ((this._levelCode == null && other._levelCode == null) || (this._levelCode != null && this._levelCode
/*     */ 
/*     */       
/* 164 */       .equals(other._levelCode))) && ((this._levelValue == null && other._levelValue == null) || (this._levelValue != null && this._levelValue
/*     */ 
/*     */       
/* 167 */       .equals(other._levelValue))) && ((this._itemPricePropertyCode == null && other._itemPricePropertyCode == null) || (this._itemPricePropertyCode != null && this._itemPricePropertyCode
/*     */ 
/*     */       
/* 170 */       .equals(other._itemPricePropertyCode))) && ((this._effectiveDate == null && other._effectiveDate == null) || (this._effectiveDate != null && this._effectiveDate
/*     */ 
/*     */       
/* 173 */       .equals(other._effectiveDate))) && ((this._pricingQuantity == null && other._pricingQuantity == null) || (this._pricingQuantity != null && this._pricingQuantity
/*     */ 
/*     */       
/* 176 */       .equals(other._pricingQuantity))));
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public int hashCode() {
/* 182 */     return ((this._organizationId == null) ? 0 : this._organizationId
/* 183 */       .hashCode()) + ((this._itemId == null) ? 0 : this._itemId
/* 184 */       .hashCode()) + ((this._levelCode == null) ? 0 : this._levelCode
/* 185 */       .hashCode()) + ((this._levelValue == null) ? 0 : this._levelValue
/* 186 */       .hashCode()) + ((this._itemPricePropertyCode == null) ? 0 : this._itemPricePropertyCode
/* 187 */       .hashCode()) + ((this._effectiveDate == null) ? 0 : this._effectiveDate
/* 188 */       .hashCode()) + ((this._pricingQuantity == null) ? 0 : this._pricingQuantity
/* 189 */       .hashCode());
/*     */   }
/*     */ 
/*     */   
/*     */   public String getDtxTypeName() {
/* 194 */     return "ItemPrices";
/*     */   }
/*     */ 
/*     */   
/*     */   public String toString() {
/* 199 */     StringBuilder buff = new StringBuilder(84);
/*     */     
/* 201 */     return buff.append(
/* 202 */         String.valueOf(this._organizationId))
/* 203 */       .append("::").append(this._itemId)
/* 204 */       .append("::").append(this._levelCode)
/* 205 */       .append("::").append(this._levelValue)
/* 206 */       .append("::").append(this._itemPricePropertyCode)
/* 207 */       .append("::").append((this._effectiveDate == null) ? "null" : String.valueOf(this._effectiveDate.getTimeSerializable()))
/* 208 */       .append("::").append((new DecimalFormat("0.000000")).format(this._pricingQuantity))
/* 209 */       .toString();
/*     */   }
/*     */   
/*     */   public boolean validate() {
/* 213 */     if (this._itemId == null) {
/* 214 */       return false;
/*     */     }
/* 216 */     if (this._levelCode == null) {
/* 217 */       return false;
/*     */     }
/* 219 */     if (this._levelValue == null) {
/* 220 */       return false;
/*     */     }
/* 222 */     if (this._itemPricePropertyCode == null) {
/* 223 */       return false;
/*     */     }
/* 225 */     if (this._effectiveDate == null) {
/* 226 */       return false;
/*     */     }
/* 228 */     if (this._pricingQuantity == null) {
/* 229 */       return false;
/*     */     }
/* 231 */     return true;
/*     */   }
/*     */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\itm\ItemPricesId.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */