/*     */ package dtv.xst.dao.inv;
/*     */ 
/*     */ import dtv.data2.access.AbstractObjectId;
/*     */ import dtv.data2.access.exception.DtxException;
/*     */ import dtv.util.StringUtils;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class InventoryCountSheetLineItemPropertyId
/*     */   extends AbstractObjectId
/*     */ {
/*     */   private static final long serialVersionUID = 119325736L;
/*     */   private Long _retailLocationId;
/*     */   private String _inventoryCountId;
/*     */   private Integer _countSheetNumber;
/*     */   private Integer _lineItemNumber;
/*     */   private String _propertyCode;
/*     */   
/*     */   public InventoryCountSheetLineItemPropertyId() {}
/*     */   
/*     */   public InventoryCountSheetLineItemPropertyId(String argObjectIdValue) {
/*  23 */     setValue(argObjectIdValue);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Long getRetailLocationId() {
/*  33 */     return this._retailLocationId;
/*     */   }
/*     */   
/*     */   public void setRetailLocationId(Long argRetailLocationId) {
/*  37 */     this._retailLocationId = argRetailLocationId;
/*     */   }
/*     */   
/*     */   public String getInventoryCountId() {
/*  41 */     return this._inventoryCountId;
/*     */   }
/*     */   
/*     */   public void setInventoryCountId(String argInventoryCountId) {
/*  45 */     this._inventoryCountId = (argInventoryCountId != null && MANAGE_CASE) ? argInventoryCountId.toUpperCase() : argInventoryCountId;
/*     */   }
/*     */   
/*     */   public Integer getCountSheetNumber() {
/*  49 */     return this._countSheetNumber;
/*     */   }
/*     */   
/*     */   public void setCountSheetNumber(Integer argCountSheetNumber) {
/*  53 */     this._countSheetNumber = argCountSheetNumber;
/*     */   }
/*     */   
/*     */   public Integer getLineItemNumber() {
/*  57 */     return this._lineItemNumber;
/*     */   }
/*     */   
/*     */   public void setLineItemNumber(Integer argLineItemNumber) {
/*  61 */     this._lineItemNumber = argLineItemNumber;
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
/*  84 */       setRetailLocationId(Long.valueOf(str));
/*  85 */       str = tokens[2];
/*     */       
/*  87 */       if ("null".equals(str)) {
/*  88 */         setInventoryCountId((String)null);
/*     */       } else {
/*     */         
/*  91 */         setInventoryCountId(str);
/*     */       } 
/*  93 */       str = tokens[3];
/*     */       
/*  95 */       setCountSheetNumber(Integer.valueOf(str));
/*  96 */       str = tokens[4];
/*     */       
/*  98 */       setLineItemNumber(Integer.valueOf(str));
/*  99 */       str = tokens[5];
/*     */       
/* 101 */       if ("null".equals(str)) {
/* 102 */         setPropertyCode((String)null);
/*     */       } else {
/*     */         
/* 105 */         setPropertyCode(str);
/*     */       }
/*     */     
/* 108 */     } catch (Exception ee) {
/* 109 */       throw new DtxException("An exception occured while parsing object id string: " + argObjectIdValue, ee);
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean equals(Object ob) {
/* 115 */     if (this == ob) {
/* 116 */       return true;
/*     */     }
/* 118 */     if (!(ob instanceof InventoryCountSheetLineItemPropertyId)) {
/* 119 */       return false;
/*     */     }
/* 121 */     InventoryCountSheetLineItemPropertyId other = (InventoryCountSheetLineItemPropertyId)ob;
/* 122 */     return (((this._organizationId == null && other._organizationId == null) || (this._organizationId != null && this._organizationId
/*     */ 
/*     */       
/* 125 */       .equals(other._organizationId))) && ((this._retailLocationId == null && other._retailLocationId == null) || (this._retailLocationId != null && this._retailLocationId
/*     */ 
/*     */       
/* 128 */       .equals(other._retailLocationId))) && ((this._inventoryCountId == null && other._inventoryCountId == null) || (this._inventoryCountId != null && this._inventoryCountId
/*     */ 
/*     */       
/* 131 */       .equals(other._inventoryCountId))) && ((this._countSheetNumber == null && other._countSheetNumber == null) || (this._countSheetNumber != null && this._countSheetNumber
/*     */ 
/*     */       
/* 134 */       .equals(other._countSheetNumber))) && ((this._lineItemNumber == null && other._lineItemNumber == null) || (this._lineItemNumber != null && this._lineItemNumber
/*     */ 
/*     */       
/* 137 */       .equals(other._lineItemNumber))) && ((this._propertyCode == null && other._propertyCode == null) || (this._propertyCode != null && this._propertyCode
/*     */ 
/*     */       
/* 140 */       .equals(other._propertyCode))));
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public int hashCode() {
/* 146 */     return ((this._organizationId == null) ? 0 : this._organizationId
/* 147 */       .hashCode()) + ((this._retailLocationId == null) ? 0 : this._retailLocationId
/* 148 */       .hashCode()) + ((this._inventoryCountId == null) ? 0 : this._inventoryCountId
/* 149 */       .hashCode()) + ((this._countSheetNumber == null) ? 0 : this._countSheetNumber
/* 150 */       .hashCode()) + ((this._lineItemNumber == null) ? 0 : this._lineItemNumber
/* 151 */       .hashCode()) + ((this._propertyCode == null) ? 0 : this._propertyCode
/* 152 */       .hashCode());
/*     */   }
/*     */ 
/*     */   
/*     */   public String getDtxTypeName() {
/* 157 */     return "InventoryCountSheetLineItemProperty";
/*     */   }
/*     */ 
/*     */   
/*     */   public String toString() {
/* 162 */     StringBuilder buff = new StringBuilder(72);
/*     */     
/* 164 */     return buff.append(
/* 165 */         String.valueOf(this._organizationId))
/* 166 */       .append("::").append(String.valueOf(this._retailLocationId))
/* 167 */       .append("::").append(this._inventoryCountId)
/* 168 */       .append("::").append(String.valueOf(this._countSheetNumber))
/* 169 */       .append("::").append(String.valueOf(this._lineItemNumber))
/* 170 */       .append("::").append(this._propertyCode)
/* 171 */       .toString();
/*     */   }
/*     */   
/*     */   public boolean validate() {
/* 175 */     if (this._retailLocationId == null) {
/* 176 */       return false;
/*     */     }
/* 178 */     if (this._inventoryCountId == null) {
/* 179 */       return false;
/*     */     }
/* 181 */     if (this._countSheetNumber == null) {
/* 182 */       return false;
/*     */     }
/* 184 */     if (this._lineItemNumber == null) {
/* 185 */       return false;
/*     */     }
/* 187 */     if (this._propertyCode == null) {
/* 188 */       return false;
/*     */     }
/* 190 */     return true;
/*     */   }
/*     */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\inv\InventoryCountSheetLineItemPropertyId.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */