/*     */ package dtv.xst.dao.inv;
/*     */ 
/*     */ import dtv.data2.access.AbstractObjectId;
/*     */ import dtv.data2.access.exception.DtxException;
/*     */ import dtv.util.StringUtils;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class InventoryCountSheetPropertyId
/*     */   extends AbstractObjectId
/*     */ {
/*     */   private static final long serialVersionUID = 704691681L;
/*     */   private Long _retailLocationId;
/*     */   private String _inventoryCountId;
/*     */   private Integer _countSheetNumber;
/*     */   private String _propertyCode;
/*     */   
/*     */   public InventoryCountSheetPropertyId() {}
/*     */   
/*     */   public InventoryCountSheetPropertyId(String argObjectIdValue) {
/*  23 */     setValue(argObjectIdValue);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Long getRetailLocationId() {
/*  32 */     return this._retailLocationId;
/*     */   }
/*     */   
/*     */   public void setRetailLocationId(Long argRetailLocationId) {
/*  36 */     this._retailLocationId = argRetailLocationId;
/*     */   }
/*     */   
/*     */   public String getInventoryCountId() {
/*  40 */     return this._inventoryCountId;
/*     */   }
/*     */   
/*     */   public void setInventoryCountId(String argInventoryCountId) {
/*  44 */     this._inventoryCountId = (argInventoryCountId != null && MANAGE_CASE) ? argInventoryCountId.toUpperCase() : argInventoryCountId;
/*     */   }
/*     */   
/*     */   public Integer getCountSheetNumber() {
/*  48 */     return this._countSheetNumber;
/*     */   }
/*     */   
/*     */   public void setCountSheetNumber(Integer argCountSheetNumber) {
/*  52 */     this._countSheetNumber = argCountSheetNumber;
/*     */   }
/*     */   
/*     */   public String getPropertyCode() {
/*  56 */     return this._propertyCode;
/*     */   }
/*     */   
/*     */   public void setPropertyCode(String argPropertyCode) {
/*  60 */     this._propertyCode = (argPropertyCode != null && MANAGE_CASE) ? argPropertyCode.toUpperCase() : argPropertyCode;
/*     */   }
/*     */   
/*     */   public void setValue(String argObjectIdValue) {
/*  64 */     String str = argObjectIdValue;
/*  65 */     if (StringUtils.isEmpty(str)) {
/*  66 */       throw new DtxException("argument passed to setValue() is null or empty - a valid value must be passed");
/*     */     }
/*     */     try {
/*  69 */       String[] tokens = str.split("::");
/*  70 */       str = tokens[0];
/*     */       
/*  72 */       setOrganizationId(Long.valueOf(str));
/*  73 */       str = tokens[1];
/*     */       
/*  75 */       setRetailLocationId(Long.valueOf(str));
/*  76 */       str = tokens[2];
/*     */       
/*  78 */       if ("null".equals(str)) {
/*  79 */         setInventoryCountId((String)null);
/*     */       } else {
/*     */         
/*  82 */         setInventoryCountId(str);
/*     */       } 
/*  84 */       str = tokens[3];
/*     */       
/*  86 */       setCountSheetNumber(Integer.valueOf(str));
/*  87 */       str = tokens[4];
/*     */       
/*  89 */       if ("null".equals(str)) {
/*  90 */         setPropertyCode((String)null);
/*     */       } else {
/*     */         
/*  93 */         setPropertyCode(str);
/*     */       }
/*     */     
/*  96 */     } catch (Exception ee) {
/*  97 */       throw new DtxException("An exception occured while parsing object id string: " + argObjectIdValue, ee);
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean equals(Object ob) {
/* 103 */     if (this == ob) {
/* 104 */       return true;
/*     */     }
/* 106 */     if (!(ob instanceof InventoryCountSheetPropertyId)) {
/* 107 */       return false;
/*     */     }
/* 109 */     InventoryCountSheetPropertyId other = (InventoryCountSheetPropertyId)ob;
/* 110 */     return (((this._organizationId == null && other._organizationId == null) || (this._organizationId != null && this._organizationId
/*     */ 
/*     */       
/* 113 */       .equals(other._organizationId))) && ((this._retailLocationId == null && other._retailLocationId == null) || (this._retailLocationId != null && this._retailLocationId
/*     */ 
/*     */       
/* 116 */       .equals(other._retailLocationId))) && ((this._inventoryCountId == null && other._inventoryCountId == null) || (this._inventoryCountId != null && this._inventoryCountId
/*     */ 
/*     */       
/* 119 */       .equals(other._inventoryCountId))) && ((this._countSheetNumber == null && other._countSheetNumber == null) || (this._countSheetNumber != null && this._countSheetNumber
/*     */ 
/*     */       
/* 122 */       .equals(other._countSheetNumber))) && ((this._propertyCode == null && other._propertyCode == null) || (this._propertyCode != null && this._propertyCode
/*     */ 
/*     */       
/* 125 */       .equals(other._propertyCode))));
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public int hashCode() {
/* 131 */     return ((this._organizationId == null) ? 0 : this._organizationId
/* 132 */       .hashCode()) + ((this._retailLocationId == null) ? 0 : this._retailLocationId
/* 133 */       .hashCode()) + ((this._inventoryCountId == null) ? 0 : this._inventoryCountId
/* 134 */       .hashCode()) + ((this._countSheetNumber == null) ? 0 : this._countSheetNumber
/* 135 */       .hashCode()) + ((this._propertyCode == null) ? 0 : this._propertyCode
/* 136 */       .hashCode());
/*     */   }
/*     */ 
/*     */   
/*     */   public String getDtxTypeName() {
/* 141 */     return "InventoryCountSheetProperty";
/*     */   }
/*     */ 
/*     */   
/*     */   public String toString() {
/* 146 */     StringBuilder buff = new StringBuilder(60);
/*     */     
/* 148 */     return buff.append(
/* 149 */         String.valueOf(this._organizationId))
/* 150 */       .append("::").append(String.valueOf(this._retailLocationId))
/* 151 */       .append("::").append(this._inventoryCountId)
/* 152 */       .append("::").append(String.valueOf(this._countSheetNumber))
/* 153 */       .append("::").append(this._propertyCode)
/* 154 */       .toString();
/*     */   }
/*     */   
/*     */   public boolean validate() {
/* 158 */     if (this._retailLocationId == null) {
/* 159 */       return false;
/*     */     }
/* 161 */     if (this._inventoryCountId == null) {
/* 162 */       return false;
/*     */     }
/* 164 */     if (this._countSheetNumber == null) {
/* 165 */       return false;
/*     */     }
/* 167 */     if (this._propertyCode == null) {
/* 168 */       return false;
/*     */     }
/* 170 */     return true;
/*     */   }
/*     */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\inv\InventoryCountSheetPropertyId.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */