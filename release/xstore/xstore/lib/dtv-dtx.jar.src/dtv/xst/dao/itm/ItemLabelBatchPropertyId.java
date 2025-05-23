/*     */ package dtv.xst.dao.itm;
/*     */ 
/*     */ import dtv.data2.access.AbstractObjectId;
/*     */ import dtv.data2.access.exception.DtxException;
/*     */ import dtv.util.StringUtils;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class ItemLabelBatchPropertyId
/*     */   extends AbstractObjectId
/*     */ {
/*     */   private static final long serialVersionUID = 1695564078L;
/*     */   private Long _retailLocationId;
/*     */   private String _batchName;
/*     */   private String _itemId;
/*     */   private String _stockLabel;
/*     */   private String _propertyCode;
/*     */   
/*     */   public ItemLabelBatchPropertyId() {}
/*     */   
/*     */   public ItemLabelBatchPropertyId(String argObjectIdValue) {
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
/*     */   public String getBatchName() {
/*  41 */     return this._batchName;
/*     */   }
/*     */   
/*     */   public void setBatchName(String argBatchName) {
/*  45 */     this._batchName = (argBatchName != null && MANAGE_CASE) ? argBatchName.toUpperCase() : argBatchName;
/*     */   }
/*     */   
/*     */   public String getItemId() {
/*  49 */     return this._itemId;
/*     */   }
/*     */   
/*     */   public void setItemId(String argItemId) {
/*  53 */     this._itemId = (argItemId != null && MANAGE_CASE) ? argItemId.toUpperCase() : argItemId;
/*     */   }
/*     */   
/*     */   public String getStockLabel() {
/*  57 */     return this._stockLabel;
/*     */   }
/*     */   
/*     */   public void setStockLabel(String argStockLabel) {
/*  61 */     this._stockLabel = (argStockLabel != null && MANAGE_CASE) ? argStockLabel.toUpperCase() : argStockLabel;
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
/*  88 */         setBatchName((String)null);
/*     */       } else {
/*     */         
/*  91 */         setBatchName(str);
/*     */       } 
/*  93 */       str = tokens[3];
/*     */       
/*  95 */       if ("null".equals(str)) {
/*  96 */         setItemId((String)null);
/*     */       } else {
/*     */         
/*  99 */         setItemId(str);
/*     */       } 
/* 101 */       str = tokens[4];
/*     */       
/* 103 */       if ("null".equals(str)) {
/* 104 */         setStockLabel((String)null);
/*     */       } else {
/*     */         
/* 107 */         setStockLabel(str);
/*     */       } 
/* 109 */       str = tokens[5];
/*     */       
/* 111 */       if ("null".equals(str)) {
/* 112 */         setPropertyCode((String)null);
/*     */       } else {
/*     */         
/* 115 */         setPropertyCode(str);
/*     */       }
/*     */     
/* 118 */     } catch (Exception ee) {
/* 119 */       throw new DtxException("An exception occured while parsing object id string: " + argObjectIdValue, ee);
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean equals(Object ob) {
/* 125 */     if (this == ob) {
/* 126 */       return true;
/*     */     }
/* 128 */     if (!(ob instanceof ItemLabelBatchPropertyId)) {
/* 129 */       return false;
/*     */     }
/* 131 */     ItemLabelBatchPropertyId other = (ItemLabelBatchPropertyId)ob;
/* 132 */     return (((this._organizationId == null && other._organizationId == null) || (this._organizationId != null && this._organizationId
/*     */ 
/*     */       
/* 135 */       .equals(other._organizationId))) && ((this._retailLocationId == null && other._retailLocationId == null) || (this._retailLocationId != null && this._retailLocationId
/*     */ 
/*     */       
/* 138 */       .equals(other._retailLocationId))) && ((this._batchName == null && other._batchName == null) || (this._batchName != null && this._batchName
/*     */ 
/*     */       
/* 141 */       .equals(other._batchName))) && ((this._itemId == null && other._itemId == null) || (this._itemId != null && this._itemId
/*     */ 
/*     */       
/* 144 */       .equals(other._itemId))) && ((this._stockLabel == null && other._stockLabel == null) || (this._stockLabel != null && this._stockLabel
/*     */ 
/*     */       
/* 147 */       .equals(other._stockLabel))) && ((this._propertyCode == null && other._propertyCode == null) || (this._propertyCode != null && this._propertyCode
/*     */ 
/*     */       
/* 150 */       .equals(other._propertyCode))));
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public int hashCode() {
/* 156 */     return ((this._organizationId == null) ? 0 : this._organizationId
/* 157 */       .hashCode()) + ((this._retailLocationId == null) ? 0 : this._retailLocationId
/* 158 */       .hashCode()) + ((this._batchName == null) ? 0 : this._batchName
/* 159 */       .hashCode()) + ((this._itemId == null) ? 0 : this._itemId
/* 160 */       .hashCode()) + ((this._stockLabel == null) ? 0 : this._stockLabel
/* 161 */       .hashCode()) + ((this._propertyCode == null) ? 0 : this._propertyCode
/* 162 */       .hashCode());
/*     */   }
/*     */ 
/*     */   
/*     */   public String getDtxTypeName() {
/* 167 */     return "ItemLabelBatchProperty";
/*     */   }
/*     */ 
/*     */   
/*     */   public String toString() {
/* 172 */     StringBuilder buff = new StringBuilder(72);
/*     */     
/* 174 */     return buff.append(
/* 175 */         String.valueOf(this._organizationId))
/* 176 */       .append("::").append(String.valueOf(this._retailLocationId))
/* 177 */       .append("::").append(this._batchName)
/* 178 */       .append("::").append(this._itemId)
/* 179 */       .append("::").append(this._stockLabel)
/* 180 */       .append("::").append(this._propertyCode)
/* 181 */       .toString();
/*     */   }
/*     */   
/*     */   public boolean validate() {
/* 185 */     if (this._retailLocationId == null) {
/* 186 */       return false;
/*     */     }
/* 188 */     if (this._batchName == null) {
/* 189 */       return false;
/*     */     }
/* 191 */     if (this._itemId == null) {
/* 192 */       return false;
/*     */     }
/* 194 */     if (this._stockLabel == null) {
/* 195 */       return false;
/*     */     }
/* 197 */     if (this._propertyCode == null) {
/* 198 */       return false;
/*     */     }
/* 200 */     return true;
/*     */   }
/*     */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\itm\ItemLabelBatchPropertyId.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */