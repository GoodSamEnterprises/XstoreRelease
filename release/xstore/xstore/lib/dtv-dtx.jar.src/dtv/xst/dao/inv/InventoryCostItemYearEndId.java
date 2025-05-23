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
/*     */ 
/*     */ public class InventoryCostItemYearEndId
/*     */   extends AbstractObjectId
/*     */ {
/*     */   private static final long serialVersionUID = 1083488738L;
/*     */   private Integer _fiscalYear;
/*     */   private Long _retailLocationId;
/*     */   private String _itemId;
/*     */   
/*     */   public InventoryCostItemYearEndId() {}
/*     */   
/*     */   public InventoryCostItemYearEndId(String argObjectIdValue) {
/*  23 */     setValue(argObjectIdValue);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Integer getFiscalYear() {
/*  31 */     return this._fiscalYear;
/*     */   }
/*     */   
/*     */   public void setFiscalYear(Integer argFiscalYear) {
/*  35 */     this._fiscalYear = argFiscalYear;
/*     */   }
/*     */   
/*     */   public Long getRetailLocationId() {
/*  39 */     return this._retailLocationId;
/*     */   }
/*     */   
/*     */   public void setRetailLocationId(Long argRetailLocationId) {
/*  43 */     this._retailLocationId = argRetailLocationId;
/*     */   }
/*     */   
/*     */   public String getItemId() {
/*  47 */     return this._itemId;
/*     */   }
/*     */   
/*     */   public void setItemId(String argItemId) {
/*  51 */     this._itemId = (argItemId != null && MANAGE_CASE) ? argItemId.toUpperCase() : argItemId;
/*     */   }
/*     */   
/*     */   public void setValue(String argObjectIdValue) {
/*  55 */     String str = argObjectIdValue;
/*  56 */     if (StringUtils.isEmpty(str)) {
/*  57 */       throw new DtxException("argument passed to setValue() is null or empty - a valid value must be passed");
/*     */     }
/*     */     try {
/*  60 */       String[] tokens = str.split("::");
/*  61 */       str = tokens[0];
/*     */       
/*  63 */       setOrganizationId(Long.valueOf(str));
/*  64 */       str = tokens[1];
/*     */       
/*  66 */       setFiscalYear(Integer.valueOf(str));
/*  67 */       str = tokens[2];
/*     */       
/*  69 */       setRetailLocationId(Long.valueOf(str));
/*  70 */       str = tokens[3];
/*     */       
/*  72 */       if ("null".equals(str)) {
/*  73 */         setItemId((String)null);
/*     */       } else {
/*     */         
/*  76 */         setItemId(str);
/*     */       }
/*     */     
/*  79 */     } catch (Exception ee) {
/*  80 */       throw new DtxException("An exception occured while parsing object id string: " + argObjectIdValue, ee);
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean equals(Object ob) {
/*  86 */     if (this == ob) {
/*  87 */       return true;
/*     */     }
/*  89 */     if (!(ob instanceof InventoryCostItemYearEndId)) {
/*  90 */       return false;
/*     */     }
/*  92 */     InventoryCostItemYearEndId other = (InventoryCostItemYearEndId)ob;
/*  93 */     return (((this._organizationId == null && other._organizationId == null) || (this._organizationId != null && this._organizationId
/*     */ 
/*     */       
/*  96 */       .equals(other._organizationId))) && ((this._fiscalYear == null && other._fiscalYear == null) || (this._fiscalYear != null && this._fiscalYear
/*     */ 
/*     */       
/*  99 */       .equals(other._fiscalYear))) && ((this._retailLocationId == null && other._retailLocationId == null) || (this._retailLocationId != null && this._retailLocationId
/*     */ 
/*     */       
/* 102 */       .equals(other._retailLocationId))) && ((this._itemId == null && other._itemId == null) || (this._itemId != null && this._itemId
/*     */ 
/*     */       
/* 105 */       .equals(other._itemId))));
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public int hashCode() {
/* 111 */     return ((this._organizationId == null) ? 0 : this._organizationId
/* 112 */       .hashCode()) + ((this._fiscalYear == null) ? 0 : this._fiscalYear
/* 113 */       .hashCode()) + ((this._retailLocationId == null) ? 0 : this._retailLocationId
/* 114 */       .hashCode()) + ((this._itemId == null) ? 0 : this._itemId
/* 115 */       .hashCode());
/*     */   }
/*     */ 
/*     */   
/*     */   public String getDtxTypeName() {
/* 120 */     return "InventoryCostItemYearEnd";
/*     */   }
/*     */ 
/*     */   
/*     */   public String toString() {
/* 125 */     StringBuilder buff = new StringBuilder(48);
/*     */     
/* 127 */     return buff.append(
/* 128 */         String.valueOf(this._organizationId))
/* 129 */       .append("::").append(String.valueOf(this._fiscalYear))
/* 130 */       .append("::").append(String.valueOf(this._retailLocationId))
/* 131 */       .append("::").append(this._itemId)
/* 132 */       .toString();
/*     */   }
/*     */   
/*     */   public boolean validate() {
/* 136 */     if (this._fiscalYear == null) {
/* 137 */       return false;
/*     */     }
/* 139 */     if (this._retailLocationId == null) {
/* 140 */       return false;
/*     */     }
/* 142 */     if (this._itemId == null) {
/* 143 */       return false;
/*     */     }
/* 145 */     return true;
/*     */   }
/*     */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\inv\InventoryCostItemYearEndId.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */