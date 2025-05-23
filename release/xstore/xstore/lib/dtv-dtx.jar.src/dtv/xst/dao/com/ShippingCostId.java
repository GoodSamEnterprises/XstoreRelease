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
/*     */ 
/*     */ public class ShippingCostId
/*     */   extends AbstractObjectId
/*     */ {
/*     */   private static final long serialVersionUID = -234631493L;
/*     */   private String _category;
/*     */   private BigDecimal _beginRange;
/*     */   private BigDecimal _endRange;
/*     */   private BigDecimal _cost;
/*     */   
/*     */   public ShippingCostId() {}
/*     */   
/*     */   public ShippingCostId(String argObjectIdValue) {
/*  29 */     setValue(argObjectIdValue);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getCategory() {
/*  38 */     return this._category;
/*     */   }
/*     */   
/*     */   public void setCategory(String argCategory) {
/*  42 */     this._category = (argCategory != null && MANAGE_CASE) ? argCategory.toUpperCase() : argCategory;
/*     */   }
/*     */   
/*     */   public BigDecimal getBeginRange() {
/*  46 */     return this._beginRange;
/*     */   }
/*     */   
/*     */   public void setBeginRange(BigDecimal argBeginRange) {
/*  50 */     this._beginRange = argBeginRange;
/*     */   }
/*     */   
/*     */   public BigDecimal getEndRange() {
/*  54 */     return this._endRange;
/*     */   }
/*     */   
/*     */   public void setEndRange(BigDecimal argEndRange) {
/*  58 */     this._endRange = argEndRange;
/*     */   }
/*     */   
/*     */   public BigDecimal getCost() {
/*  62 */     return this._cost;
/*     */   }
/*     */   
/*     */   public void setCost(BigDecimal argCost) {
/*  66 */     this._cost = argCost;
/*     */   }
/*     */   
/*     */   public void setValue(String argObjectIdValue) {
/*  70 */     String str = argObjectIdValue;
/*  71 */     if (StringUtils.isEmpty(str)) {
/*  72 */       throw new DtxException("argument passed to setValue() is null or empty - a valid value must be passed");
/*     */     }
/*     */     try {
/*  75 */       String[] tokens = str.split("::");
/*  76 */       str = tokens[0];
/*     */       
/*  78 */       setOrganizationId(Long.valueOf(str));
/*  79 */       str = tokens[1];
/*     */       
/*  81 */       if ("null".equals(str)) {
/*  82 */         setCategory((String)null);
/*     */       } else {
/*     */         
/*  85 */         setCategory(str);
/*     */       } 
/*  87 */       str = tokens[2];
/*     */       
/*  89 */       setBeginRange(new BigDecimal(str));
/*  90 */       str = tokens[3];
/*     */       
/*  92 */       setEndRange(new BigDecimal(str));
/*  93 */       str = tokens[4];
/*     */       
/*  95 */       setCost(new BigDecimal(str));
/*     */     }
/*  97 */     catch (Exception ee) {
/*  98 */       throw new DtxException("An exception occured while parsing object id string: " + argObjectIdValue, ee);
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean equals(Object ob) {
/* 104 */     if (this == ob) {
/* 105 */       return true;
/*     */     }
/* 107 */     if (!(ob instanceof ShippingCostId)) {
/* 108 */       return false;
/*     */     }
/* 110 */     ShippingCostId other = (ShippingCostId)ob;
/* 111 */     return (((this._organizationId == null && other._organizationId == null) || (this._organizationId != null && this._organizationId
/*     */ 
/*     */       
/* 114 */       .equals(other._organizationId))) && ((this._category == null && other._category == null) || (this._category != null && this._category
/*     */ 
/*     */       
/* 117 */       .equals(other._category))) && ((this._beginRange == null && other._beginRange == null) || (this._beginRange != null && this._beginRange
/*     */ 
/*     */       
/* 120 */       .equals(other._beginRange))) && ((this._endRange == null && other._endRange == null) || (this._endRange != null && this._endRange
/*     */ 
/*     */       
/* 123 */       .equals(other._endRange))) && ((this._cost == null && other._cost == null) || (this._cost != null && this._cost
/*     */ 
/*     */       
/* 126 */       .equals(other._cost))));
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public int hashCode() {
/* 132 */     return ((this._organizationId == null) ? 0 : this._organizationId
/* 133 */       .hashCode()) + ((this._category == null) ? 0 : this._category
/* 134 */       .hashCode()) + ((this._beginRange == null) ? 0 : this._beginRange
/* 135 */       .hashCode()) + ((this._endRange == null) ? 0 : this._endRange
/* 136 */       .hashCode()) + ((this._cost == null) ? 0 : this._cost
/* 137 */       .hashCode());
/*     */   }
/*     */ 
/*     */   
/*     */   public String getDtxTypeName() {
/* 142 */     return "ShippingCost";
/*     */   }
/*     */ 
/*     */   
/*     */   public String toString() {
/* 147 */     StringBuilder buff = new StringBuilder(60);
/*     */     
/* 149 */     return buff.append(
/* 150 */         String.valueOf(this._organizationId))
/* 151 */       .append("::").append(this._category)
/* 152 */       .append("::").append((new DecimalFormat("0.000000")).format(this._beginRange))
/* 153 */       .append("::").append((new DecimalFormat("0.000000")).format(this._endRange))
/* 154 */       .append("::").append((new DecimalFormat("0.000000")).format(this._cost))
/* 155 */       .toString();
/*     */   }
/*     */   
/*     */   public boolean validate() {
/* 159 */     if (this._category == null) {
/* 160 */       return false;
/*     */     }
/* 162 */     if (this._beginRange == null) {
/* 163 */       return false;
/*     */     }
/* 165 */     if (this._endRange == null) {
/* 166 */       return false;
/*     */     }
/* 168 */     if (this._cost == null) {
/* 169 */       return false;
/*     */     }
/* 171 */     return true;
/*     */   }
/*     */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\com\ShippingCostId.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */