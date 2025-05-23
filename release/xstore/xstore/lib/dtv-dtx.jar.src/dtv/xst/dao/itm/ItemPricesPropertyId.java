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
/*     */ public class ItemPricesPropertyId
/*     */   extends AbstractObjectId
/*     */ {
/*     */   private static final long serialVersionUID = 669021778L;
/*     */   private String _itemId;
/*     */   private String _levelCode;
/*     */   private String _levelValue;
/*     */   private String _itemPricePropertyCode;
/*     */   private DtvDate _effectiveDate;
/*     */   private BigDecimal _pricingQuantity;
/*     */   private String _propertyCode;
/*     */   
/*     */   public ItemPricesPropertyId() {}
/*     */   
/*     */   public ItemPricesPropertyId(String argObjectIdValue) {
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
/*     */   public String getItemId() {
/*  39 */     return this._itemId;
/*     */   }
/*     */   
/*     */   public void setItemId(String argItemId) {
/*  43 */     this._itemId = (argItemId != null && MANAGE_CASE) ? argItemId.toUpperCase() : argItemId;
/*     */   }
/*     */   
/*     */   public String getLevelCode() {
/*  47 */     return this._levelCode;
/*     */   }
/*     */   
/*     */   public void setLevelCode(String argLevelCode) {
/*  51 */     this._levelCode = (argLevelCode != null && MANAGE_CASE) ? argLevelCode.toUpperCase() : argLevelCode;
/*     */   }
/*     */   
/*     */   public String getLevelValue() {
/*  55 */     return this._levelValue;
/*     */   }
/*     */   
/*     */   public void setLevelValue(String argLevelValue) {
/*  59 */     this._levelValue = (argLevelValue != null && MANAGE_CASE) ? argLevelValue.toUpperCase() : argLevelValue;
/*     */   }
/*     */   
/*     */   public String getItemPricePropertyCode() {
/*  63 */     return this._itemPricePropertyCode;
/*     */   }
/*     */   
/*     */   public void setItemPricePropertyCode(String argItemPricePropertyCode) {
/*  67 */     this._itemPricePropertyCode = (argItemPricePropertyCode != null && MANAGE_CASE) ? argItemPricePropertyCode.toUpperCase() : argItemPricePropertyCode;
/*     */   }
/*     */   
/*     */   public Date getEffectiveDate() {
/*  71 */     return (Date)this._effectiveDate;
/*     */   }
/*     */   
/*     */   public void setEffectiveDate(Date argEffectiveDate) {
/*  75 */     this._effectiveDate = (argEffectiveDate == null || argEffectiveDate instanceof DtvDate) ? (DtvDate)argEffectiveDate : new DtvDate(argEffectiveDate);
/*     */   }
/*     */ 
/*     */   
/*     */   public BigDecimal getPricingQuantity() {
/*  80 */     return this._pricingQuantity;
/*     */   }
/*     */   
/*     */   public void setPricingQuantity(BigDecimal argPricingQuantity) {
/*  84 */     this._pricingQuantity = argPricingQuantity;
/*     */   }
/*     */   
/*     */   public String getPropertyCode() {
/*  88 */     return this._propertyCode;
/*     */   }
/*     */   
/*     */   public void setPropertyCode(String argPropertyCode) {
/*  92 */     this._propertyCode = (argPropertyCode != null && MANAGE_CASE) ? argPropertyCode.toUpperCase() : argPropertyCode;
/*     */   }
/*     */   
/*     */   public void setValue(String argObjectIdValue) {
/*  96 */     String str = argObjectIdValue;
/*  97 */     if (StringUtils.isEmpty(str)) {
/*  98 */       throw new DtxException("argument passed to setValue() is null or empty - a valid value must be passed");
/*     */     }
/*     */     try {
/* 101 */       String[] tokens = str.split("::");
/* 102 */       str = tokens[0];
/*     */       
/* 104 */       setOrganizationId(Long.valueOf(str));
/* 105 */       str = tokens[1];
/*     */       
/* 107 */       if ("null".equals(str)) {
/* 108 */         setItemId((String)null);
/*     */       } else {
/*     */         
/* 111 */         setItemId(str);
/*     */       } 
/* 113 */       str = tokens[2];
/*     */       
/* 115 */       if ("null".equals(str)) {
/* 116 */         setLevelCode((String)null);
/*     */       } else {
/*     */         
/* 119 */         setLevelCode(str);
/*     */       } 
/* 121 */       str = tokens[3];
/*     */       
/* 123 */       if ("null".equals(str)) {
/* 124 */         setLevelValue((String)null);
/*     */       } else {
/*     */         
/* 127 */         setLevelValue(str);
/*     */       } 
/* 129 */       str = tokens[4];
/*     */       
/* 131 */       if ("null".equals(str)) {
/* 132 */         setItemPricePropertyCode((String)null);
/*     */       } else {
/*     */         
/* 135 */         setItemPricePropertyCode(str);
/*     */       } 
/* 137 */       str = tokens[5];
/*     */       
/* 139 */       if ("null".equals(str)) {
/* 140 */         setEffectiveDate((Date)null);
/*     */       } else {
/*     */         
/* 143 */         setEffectiveDate((Date)new DtvDate());
/* 144 */         this._effectiveDate.setTimeFromSerialization(Long.parseLong(str));
/*     */       } 
/* 146 */       str = tokens[6];
/*     */       
/* 148 */       setPricingQuantity(new BigDecimal(str));
/* 149 */       str = tokens[7];
/*     */       
/* 151 */       if ("null".equals(str)) {
/* 152 */         setPropertyCode((String)null);
/*     */       } else {
/*     */         
/* 155 */         setPropertyCode(str);
/*     */       }
/*     */     
/* 158 */     } catch (Exception ee) {
/* 159 */       throw new DtxException("An exception occured while parsing object id string: " + argObjectIdValue, ee);
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean equals(Object ob) {
/* 165 */     if (this == ob) {
/* 166 */       return true;
/*     */     }
/* 168 */     if (!(ob instanceof ItemPricesPropertyId)) {
/* 169 */       return false;
/*     */     }
/* 171 */     ItemPricesPropertyId other = (ItemPricesPropertyId)ob;
/* 172 */     return (((this._organizationId == null && other._organizationId == null) || (this._organizationId != null && this._organizationId
/*     */ 
/*     */       
/* 175 */       .equals(other._organizationId))) && ((this._itemId == null && other._itemId == null) || (this._itemId != null && this._itemId
/*     */ 
/*     */       
/* 178 */       .equals(other._itemId))) && ((this._levelCode == null && other._levelCode == null) || (this._levelCode != null && this._levelCode
/*     */ 
/*     */       
/* 181 */       .equals(other._levelCode))) && ((this._levelValue == null && other._levelValue == null) || (this._levelValue != null && this._levelValue
/*     */ 
/*     */       
/* 184 */       .equals(other._levelValue))) && ((this._itemPricePropertyCode == null && other._itemPricePropertyCode == null) || (this._itemPricePropertyCode != null && this._itemPricePropertyCode
/*     */ 
/*     */       
/* 187 */       .equals(other._itemPricePropertyCode))) && ((this._effectiveDate == null && other._effectiveDate == null) || (this._effectiveDate != null && this._effectiveDate
/*     */ 
/*     */       
/* 190 */       .equals(other._effectiveDate))) && ((this._pricingQuantity == null && other._pricingQuantity == null) || (this._pricingQuantity != null && this._pricingQuantity
/*     */ 
/*     */       
/* 193 */       .equals(other._pricingQuantity))) && ((this._propertyCode == null && other._propertyCode == null) || (this._propertyCode != null && this._propertyCode
/*     */ 
/*     */       
/* 196 */       .equals(other._propertyCode))));
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public int hashCode() {
/* 202 */     return ((this._organizationId == null) ? 0 : this._organizationId
/* 203 */       .hashCode()) + ((this._itemId == null) ? 0 : this._itemId
/* 204 */       .hashCode()) + ((this._levelCode == null) ? 0 : this._levelCode
/* 205 */       .hashCode()) + ((this._levelValue == null) ? 0 : this._levelValue
/* 206 */       .hashCode()) + ((this._itemPricePropertyCode == null) ? 0 : this._itemPricePropertyCode
/* 207 */       .hashCode()) + ((this._effectiveDate == null) ? 0 : this._effectiveDate
/* 208 */       .hashCode()) + ((this._pricingQuantity == null) ? 0 : this._pricingQuantity
/* 209 */       .hashCode()) + ((this._propertyCode == null) ? 0 : this._propertyCode
/* 210 */       .hashCode());
/*     */   }
/*     */ 
/*     */   
/*     */   public String getDtxTypeName() {
/* 215 */     return "ItemPricesProperty";
/*     */   }
/*     */ 
/*     */   
/*     */   public String toString() {
/* 220 */     StringBuilder buff = new StringBuilder(96);
/*     */     
/* 222 */     return buff.append(
/* 223 */         String.valueOf(this._organizationId))
/* 224 */       .append("::").append(this._itemId)
/* 225 */       .append("::").append(this._levelCode)
/* 226 */       .append("::").append(this._levelValue)
/* 227 */       .append("::").append(this._itemPricePropertyCode)
/* 228 */       .append("::").append((this._effectiveDate == null) ? "null" : String.valueOf(this._effectiveDate.getTimeSerializable()))
/* 229 */       .append("::").append((new DecimalFormat("0.000000")).format(this._pricingQuantity))
/* 230 */       .append("::").append(this._propertyCode)
/* 231 */       .toString();
/*     */   }
/*     */   
/*     */   public boolean validate() {
/* 235 */     if (this._itemId == null) {
/* 236 */       return false;
/*     */     }
/* 238 */     if (this._levelCode == null) {
/* 239 */       return false;
/*     */     }
/* 241 */     if (this._levelValue == null) {
/* 242 */       return false;
/*     */     }
/* 244 */     if (this._itemPricePropertyCode == null) {
/* 245 */       return false;
/*     */     }
/* 247 */     if (this._effectiveDate == null) {
/* 248 */       return false;
/*     */     }
/* 250 */     if (this._pricingQuantity == null) {
/* 251 */       return false;
/*     */     }
/* 253 */     if (this._propertyCode == null) {
/* 254 */       return false;
/*     */     }
/* 256 */     return true;
/*     */   }
/*     */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\itm\ItemPricesPropertyId.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */