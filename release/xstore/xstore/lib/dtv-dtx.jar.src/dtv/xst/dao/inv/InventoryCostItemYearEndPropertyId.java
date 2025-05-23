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
/*     */ public class InventoryCostItemYearEndPropertyId
/*     */   extends AbstractObjectId
/*     */ {
/*     */   private static final long serialVersionUID = -1914832425L;
/*     */   private Integer _fiscalYear;
/*     */   private Long _retailLocationId;
/*     */   private String _itemId;
/*     */   private String _propertyCode;
/*     */   
/*     */   public InventoryCostItemYearEndPropertyId() {}
/*     */   
/*     */   public InventoryCostItemYearEndPropertyId(String argObjectIdValue) {
/*  23 */     setValue(argObjectIdValue);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Integer getFiscalYear() {
/*  32 */     return this._fiscalYear;
/*     */   }
/*     */   
/*     */   public void setFiscalYear(Integer argFiscalYear) {
/*  36 */     this._fiscalYear = argFiscalYear;
/*     */   }
/*     */   
/*     */   public Long getRetailLocationId() {
/*  40 */     return this._retailLocationId;
/*     */   }
/*     */   
/*     */   public void setRetailLocationId(Long argRetailLocationId) {
/*  44 */     this._retailLocationId = argRetailLocationId;
/*     */   }
/*     */   
/*     */   public String getItemId() {
/*  48 */     return this._itemId;
/*     */   }
/*     */   
/*     */   public void setItemId(String argItemId) {
/*  52 */     this._itemId = (argItemId != null && MANAGE_CASE) ? argItemId.toUpperCase() : argItemId;
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
/*  75 */       setFiscalYear(Integer.valueOf(str));
/*  76 */       str = tokens[2];
/*     */       
/*  78 */       setRetailLocationId(Long.valueOf(str));
/*  79 */       str = tokens[3];
/*     */       
/*  81 */       if ("null".equals(str)) {
/*  82 */         setItemId((String)null);
/*     */       } else {
/*     */         
/*  85 */         setItemId(str);
/*     */       } 
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
/* 106 */     if (!(ob instanceof InventoryCostItemYearEndPropertyId)) {
/* 107 */       return false;
/*     */     }
/* 109 */     InventoryCostItemYearEndPropertyId other = (InventoryCostItemYearEndPropertyId)ob;
/* 110 */     return (((this._organizationId == null && other._organizationId == null) || (this._organizationId != null && this._organizationId
/*     */ 
/*     */       
/* 113 */       .equals(other._organizationId))) && ((this._fiscalYear == null && other._fiscalYear == null) || (this._fiscalYear != null && this._fiscalYear
/*     */ 
/*     */       
/* 116 */       .equals(other._fiscalYear))) && ((this._retailLocationId == null && other._retailLocationId == null) || (this._retailLocationId != null && this._retailLocationId
/*     */ 
/*     */       
/* 119 */       .equals(other._retailLocationId))) && ((this._itemId == null && other._itemId == null) || (this._itemId != null && this._itemId
/*     */ 
/*     */       
/* 122 */       .equals(other._itemId))) && ((this._propertyCode == null && other._propertyCode == null) || (this._propertyCode != null && this._propertyCode
/*     */ 
/*     */       
/* 125 */       .equals(other._propertyCode))));
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public int hashCode() {
/* 131 */     return ((this._organizationId == null) ? 0 : this._organizationId
/* 132 */       .hashCode()) + ((this._fiscalYear == null) ? 0 : this._fiscalYear
/* 133 */       .hashCode()) + ((this._retailLocationId == null) ? 0 : this._retailLocationId
/* 134 */       .hashCode()) + ((this._itemId == null) ? 0 : this._itemId
/* 135 */       .hashCode()) + ((this._propertyCode == null) ? 0 : this._propertyCode
/* 136 */       .hashCode());
/*     */   }
/*     */ 
/*     */   
/*     */   public String getDtxTypeName() {
/* 141 */     return "InventoryCostItemYearEndProperty";
/*     */   }
/*     */ 
/*     */   
/*     */   public String toString() {
/* 146 */     StringBuilder buff = new StringBuilder(60);
/*     */     
/* 148 */     return buff.append(
/* 149 */         String.valueOf(this._organizationId))
/* 150 */       .append("::").append(String.valueOf(this._fiscalYear))
/* 151 */       .append("::").append(String.valueOf(this._retailLocationId))
/* 152 */       .append("::").append(this._itemId)
/* 153 */       .append("::").append(this._propertyCode)
/* 154 */       .toString();
/*     */   }
/*     */   
/*     */   public boolean validate() {
/* 158 */     if (this._fiscalYear == null) {
/* 159 */       return false;
/*     */     }
/* 161 */     if (this._retailLocationId == null) {
/* 162 */       return false;
/*     */     }
/* 164 */     if (this._itemId == null) {
/* 165 */       return false;
/*     */     }
/* 167 */     if (this._propertyCode == null) {
/* 168 */       return false;
/*     */     }
/* 170 */     return true;
/*     */   }
/*     */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\inv\InventoryCostItemYearEndPropertyId.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */