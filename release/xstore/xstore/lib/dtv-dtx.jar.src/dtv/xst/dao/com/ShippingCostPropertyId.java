/*     */ package dtv.xst.dao.com;
/*     */ 
/*     */ import dtv.data2.access.AbstractObjectId;
/*     */ import dtv.data2.access.exception.DtxException;
/*     */ import dtv.util.StringUtils;
/*     */ import java.math.BigDecimal;
/*     */ import java.text.DecimalFormat;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class ShippingCostPropertyId
/*     */   extends AbstractObjectId
/*     */ {
/*     */   private static final long serialVersionUID = 1727735216L;
/*     */   private String _category;
/*     */   private BigDecimal _beginRange;
/*     */   private BigDecimal _endRange;
/*     */   private BigDecimal _cost;
/*     */   private String _propertyCode;
/*     */   
/*     */   public ShippingCostPropertyId() {}
/*     */   
/*     */   public ShippingCostPropertyId(String argObjectIdValue) {
/*  29 */     setValue(argObjectIdValue);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getCategory() {
/*  39 */     return this._category;
/*     */   }
/*     */   
/*     */   public void setCategory(String argCategory) {
/*  43 */     this._category = (argCategory != null && MANAGE_CASE) ? argCategory.toUpperCase() : argCategory;
/*     */   }
/*     */   
/*     */   public BigDecimal getBeginRange() {
/*  47 */     return this._beginRange;
/*     */   }
/*     */   
/*     */   public void setBeginRange(BigDecimal argBeginRange) {
/*  51 */     this._beginRange = argBeginRange;
/*     */   }
/*     */   
/*     */   public BigDecimal getEndRange() {
/*  55 */     return this._endRange;
/*     */   }
/*     */   
/*     */   public void setEndRange(BigDecimal argEndRange) {
/*  59 */     this._endRange = argEndRange;
/*     */   }
/*     */   
/*     */   public BigDecimal getCost() {
/*  63 */     return this._cost;
/*     */   }
/*     */   
/*     */   public void setCost(BigDecimal argCost) {
/*  67 */     this._cost = argCost;
/*     */   }
/*     */   
/*     */   public String getPropertyCode() {
/*  71 */     return this._propertyCode;
/*     */   }
/*     */   
/*     */   public void setPropertyCode(String argPropertyCode) {
/*  75 */     this._propertyCode = (argPropertyCode != null && MANAGE_CASE) ? argPropertyCode.toUpperCase() : argPropertyCode;
/*     */   }
/*     */   
/*     */   public void setValue(String argObjectIdValue) {
/*  79 */     String str = argObjectIdValue;
/*  80 */     if (StringUtils.isEmpty(str)) {
/*  81 */       throw new DtxException("argument passed to setValue() is null or empty - a valid value must be passed");
/*     */     }
/*     */     try {
/*  84 */       String[] tokens = str.split("::");
/*  85 */       str = tokens[0];
/*     */       
/*  87 */       setOrganizationId(Long.valueOf(str));
/*  88 */       str = tokens[1];
/*     */       
/*  90 */       if ("null".equals(str)) {
/*  91 */         setCategory((String)null);
/*     */       } else {
/*     */         
/*  94 */         setCategory(str);
/*     */       } 
/*  96 */       str = tokens[2];
/*     */       
/*  98 */       setBeginRange(new BigDecimal(str));
/*  99 */       str = tokens[3];
/*     */       
/* 101 */       setEndRange(new BigDecimal(str));
/* 102 */       str = tokens[4];
/*     */       
/* 104 */       setCost(new BigDecimal(str));
/* 105 */       str = tokens[5];
/*     */       
/* 107 */       if ("null".equals(str)) {
/* 108 */         setPropertyCode((String)null);
/*     */       } else {
/*     */         
/* 111 */         setPropertyCode(str);
/*     */       }
/*     */     
/* 114 */     } catch (Exception ee) {
/* 115 */       throw new DtxException("An exception occured while parsing object id string: " + argObjectIdValue, ee);
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean equals(Object ob) {
/* 121 */     if (this == ob) {
/* 122 */       return true;
/*     */     }
/* 124 */     if (!(ob instanceof ShippingCostPropertyId)) {
/* 125 */       return false;
/*     */     }
/* 127 */     ShippingCostPropertyId other = (ShippingCostPropertyId)ob;
/* 128 */     return (((this._organizationId == null && other._organizationId == null) || (this._organizationId != null && this._organizationId
/*     */ 
/*     */       
/* 131 */       .equals(other._organizationId))) && ((this._category == null && other._category == null) || (this._category != null && this._category
/*     */ 
/*     */       
/* 134 */       .equals(other._category))) && ((this._beginRange == null && other._beginRange == null) || (this._beginRange != null && this._beginRange
/*     */ 
/*     */       
/* 137 */       .equals(other._beginRange))) && ((this._endRange == null && other._endRange == null) || (this._endRange != null && this._endRange
/*     */ 
/*     */       
/* 140 */       .equals(other._endRange))) && ((this._cost == null && other._cost == null) || (this._cost != null && this._cost
/*     */ 
/*     */       
/* 143 */       .equals(other._cost))) && ((this._propertyCode == null && other._propertyCode == null) || (this._propertyCode != null && this._propertyCode
/*     */ 
/*     */       
/* 146 */       .equals(other._propertyCode))));
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public int hashCode() {
/* 152 */     return ((this._organizationId == null) ? 0 : this._organizationId
/* 153 */       .hashCode()) + ((this._category == null) ? 0 : this._category
/* 154 */       .hashCode()) + ((this._beginRange == null) ? 0 : this._beginRange
/* 155 */       .hashCode()) + ((this._endRange == null) ? 0 : this._endRange
/* 156 */       .hashCode()) + ((this._cost == null) ? 0 : this._cost
/* 157 */       .hashCode()) + ((this._propertyCode == null) ? 0 : this._propertyCode
/* 158 */       .hashCode());
/*     */   }
/*     */ 
/*     */   
/*     */   public String getDtxTypeName() {
/* 163 */     return "ShippingCostProperty";
/*     */   }
/*     */ 
/*     */   
/*     */   public String toString() {
/* 168 */     StringBuilder buff = new StringBuilder(72);
/*     */     
/* 170 */     return buff.append(
/* 171 */         String.valueOf(this._organizationId))
/* 172 */       .append("::").append(this._category)
/* 173 */       .append("::").append((new DecimalFormat("0.000000")).format(this._beginRange))
/* 174 */       .append("::").append((new DecimalFormat("0.000000")).format(this._endRange))
/* 175 */       .append("::").append((new DecimalFormat("0.000000")).format(this._cost))
/* 176 */       .append("::").append(this._propertyCode)
/* 177 */       .toString();
/*     */   }
/*     */   
/*     */   public boolean validate() {
/* 181 */     if (this._category == null) {
/* 182 */       return false;
/*     */     }
/* 184 */     if (this._beginRange == null) {
/* 185 */       return false;
/*     */     }
/* 187 */     if (this._endRange == null) {
/* 188 */       return false;
/*     */     }
/* 190 */     if (this._cost == null) {
/* 191 */       return false;
/*     */     }
/* 193 */     if (this._propertyCode == null) {
/* 194 */       return false;
/*     */     }
/* 196 */     return true;
/*     */   }
/*     */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\com\ShippingCostPropertyId.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */