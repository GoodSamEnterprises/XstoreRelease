/*     */ package dtv.xst.dao.itm;
/*     */ 
/*     */ import dtv.data2.access.AbstractObjectId;
/*     */ import dtv.data2.access.exception.DtxException;
/*     */ import dtv.util.StringUtils;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class ItemLabelBatchId
/*     */   extends AbstractObjectId
/*     */ {
/*     */   private static final long serialVersionUID = -51165127L;
/*     */   private Long _retailLocationId;
/*     */   private String _batchName;
/*     */   private String _itemId;
/*     */   private String _stockLabel;
/*     */   
/*     */   public ItemLabelBatchId() {}
/*     */   
/*     */   public ItemLabelBatchId(String argObjectIdValue) {
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
/*     */   public String getBatchName() {
/*  40 */     return this._batchName;
/*     */   }
/*     */   
/*     */   public void setBatchName(String argBatchName) {
/*  44 */     this._batchName = (argBatchName != null && MANAGE_CASE) ? argBatchName.toUpperCase() : argBatchName;
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
/*     */   public String getStockLabel() {
/*  56 */     return this._stockLabel;
/*     */   }
/*     */   
/*     */   public void setStockLabel(String argStockLabel) {
/*  60 */     this._stockLabel = (argStockLabel != null && MANAGE_CASE) ? argStockLabel.toUpperCase() : argStockLabel;
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
/*  79 */         setBatchName((String)null);
/*     */       } else {
/*     */         
/*  82 */         setBatchName(str);
/*     */       } 
/*  84 */       str = tokens[3];
/*     */       
/*  86 */       if ("null".equals(str)) {
/*  87 */         setItemId((String)null);
/*     */       } else {
/*     */         
/*  90 */         setItemId(str);
/*     */       } 
/*  92 */       str = tokens[4];
/*     */       
/*  94 */       if ("null".equals(str)) {
/*  95 */         setStockLabel((String)null);
/*     */       } else {
/*     */         
/*  98 */         setStockLabel(str);
/*     */       }
/*     */     
/* 101 */     } catch (Exception ee) {
/* 102 */       throw new DtxException("An exception occured while parsing object id string: " + argObjectIdValue, ee);
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean equals(Object ob) {
/* 108 */     if (this == ob) {
/* 109 */       return true;
/*     */     }
/* 111 */     if (!(ob instanceof ItemLabelBatchId)) {
/* 112 */       return false;
/*     */     }
/* 114 */     ItemLabelBatchId other = (ItemLabelBatchId)ob;
/* 115 */     return (((this._organizationId == null && other._organizationId == null) || (this._organizationId != null && this._organizationId
/*     */ 
/*     */       
/* 118 */       .equals(other._organizationId))) && ((this._retailLocationId == null && other._retailLocationId == null) || (this._retailLocationId != null && this._retailLocationId
/*     */ 
/*     */       
/* 121 */       .equals(other._retailLocationId))) && ((this._batchName == null && other._batchName == null) || (this._batchName != null && this._batchName
/*     */ 
/*     */       
/* 124 */       .equals(other._batchName))) && ((this._itemId == null && other._itemId == null) || (this._itemId != null && this._itemId
/*     */ 
/*     */       
/* 127 */       .equals(other._itemId))) && ((this._stockLabel == null && other._stockLabel == null) || (this._stockLabel != null && this._stockLabel
/*     */ 
/*     */       
/* 130 */       .equals(other._stockLabel))));
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public int hashCode() {
/* 136 */     return ((this._organizationId == null) ? 0 : this._organizationId
/* 137 */       .hashCode()) + ((this._retailLocationId == null) ? 0 : this._retailLocationId
/* 138 */       .hashCode()) + ((this._batchName == null) ? 0 : this._batchName
/* 139 */       .hashCode()) + ((this._itemId == null) ? 0 : this._itemId
/* 140 */       .hashCode()) + ((this._stockLabel == null) ? 0 : this._stockLabel
/* 141 */       .hashCode());
/*     */   }
/*     */ 
/*     */   
/*     */   public String getDtxTypeName() {
/* 146 */     return "ItemLabelBatch";
/*     */   }
/*     */ 
/*     */   
/*     */   public String toString() {
/* 151 */     StringBuilder buff = new StringBuilder(60);
/*     */     
/* 153 */     return buff.append(
/* 154 */         String.valueOf(this._organizationId))
/* 155 */       .append("::").append(String.valueOf(this._retailLocationId))
/* 156 */       .append("::").append(this._batchName)
/* 157 */       .append("::").append(this._itemId)
/* 158 */       .append("::").append(this._stockLabel)
/* 159 */       .toString();
/*     */   }
/*     */   
/*     */   public boolean validate() {
/* 163 */     if (this._retailLocationId == null) {
/* 164 */       return false;
/*     */     }
/* 166 */     if (this._batchName == null) {
/* 167 */       return false;
/*     */     }
/* 169 */     if (this._itemId == null) {
/* 170 */       return false;
/*     */     }
/* 172 */     if (this._stockLabel == null) {
/* 173 */       return false;
/*     */     }
/* 175 */     return true;
/*     */   }
/*     */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\itm\ItemLabelBatchId.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */