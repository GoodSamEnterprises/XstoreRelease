/*     */ package dtv.xst.dao.inv;
/*     */ 
/*     */ import dtv.data2.access.AbstractObjectId;
/*     */ import dtv.data2.access.exception.DtxException;
/*     */ import dtv.util.StringUtils;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class InventoryCountSnapshotId
/*     */   extends AbstractObjectId
/*     */ {
/*     */   private static final long serialVersionUID = 1348133911L;
/*     */   private Long _retailLocationId;
/*     */   private String _inventoryCountId;
/*     */   private String _inventoryLocationId;
/*     */   private String _inventoryBucketId;
/*     */   private String _itemId;
/*     */   
/*     */   public InventoryCountSnapshotId() {}
/*     */   
/*     */   public InventoryCountSnapshotId(String argObjectIdValue) {
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
/*     */   public String getInventoryLocationId() {
/*  49 */     return this._inventoryLocationId;
/*     */   }
/*     */   
/*     */   public void setInventoryLocationId(String argInventoryLocationId) {
/*  53 */     this._inventoryLocationId = (argInventoryLocationId != null && MANAGE_CASE) ? argInventoryLocationId.toUpperCase() : argInventoryLocationId;
/*     */   }
/*     */   
/*     */   public String getInventoryBucketId() {
/*  57 */     return this._inventoryBucketId;
/*     */   }
/*     */   
/*     */   public void setInventoryBucketId(String argInventoryBucketId) {
/*  61 */     this._inventoryBucketId = (argInventoryBucketId != null && MANAGE_CASE) ? argInventoryBucketId.toUpperCase() : argInventoryBucketId;
/*     */   }
/*     */   
/*     */   public String getItemId() {
/*  65 */     return this._itemId;
/*     */   }
/*     */   
/*     */   public void setItemId(String argItemId) {
/*  69 */     this._itemId = (argItemId != null && MANAGE_CASE) ? argItemId.toUpperCase() : argItemId;
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
/*  95 */       if ("null".equals(str)) {
/*  96 */         setInventoryLocationId((String)null);
/*     */       } else {
/*     */         
/*  99 */         setInventoryLocationId(str);
/*     */       } 
/* 101 */       str = tokens[4];
/*     */       
/* 103 */       if ("null".equals(str)) {
/* 104 */         setInventoryBucketId((String)null);
/*     */       } else {
/*     */         
/* 107 */         setInventoryBucketId(str);
/*     */       } 
/* 109 */       str = tokens[5];
/*     */       
/* 111 */       if ("null".equals(str)) {
/* 112 */         setItemId((String)null);
/*     */       } else {
/*     */         
/* 115 */         setItemId(str);
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
/* 128 */     if (!(ob instanceof InventoryCountSnapshotId)) {
/* 129 */       return false;
/*     */     }
/* 131 */     InventoryCountSnapshotId other = (InventoryCountSnapshotId)ob;
/* 132 */     return (((this._organizationId == null && other._organizationId == null) || (this._organizationId != null && this._organizationId
/*     */ 
/*     */       
/* 135 */       .equals(other._organizationId))) && ((this._retailLocationId == null && other._retailLocationId == null) || (this._retailLocationId != null && this._retailLocationId
/*     */ 
/*     */       
/* 138 */       .equals(other._retailLocationId))) && ((this._inventoryCountId == null && other._inventoryCountId == null) || (this._inventoryCountId != null && this._inventoryCountId
/*     */ 
/*     */       
/* 141 */       .equals(other._inventoryCountId))) && ((this._inventoryLocationId == null && other._inventoryLocationId == null) || (this._inventoryLocationId != null && this._inventoryLocationId
/*     */ 
/*     */       
/* 144 */       .equals(other._inventoryLocationId))) && ((this._inventoryBucketId == null && other._inventoryBucketId == null) || (this._inventoryBucketId != null && this._inventoryBucketId
/*     */ 
/*     */       
/* 147 */       .equals(other._inventoryBucketId))) && ((this._itemId == null && other._itemId == null) || (this._itemId != null && this._itemId
/*     */ 
/*     */       
/* 150 */       .equals(other._itemId))));
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public int hashCode() {
/* 156 */     return ((this._organizationId == null) ? 0 : this._organizationId
/* 157 */       .hashCode()) + ((this._retailLocationId == null) ? 0 : this._retailLocationId
/* 158 */       .hashCode()) + ((this._inventoryCountId == null) ? 0 : this._inventoryCountId
/* 159 */       .hashCode()) + ((this._inventoryLocationId == null) ? 0 : this._inventoryLocationId
/* 160 */       .hashCode()) + ((this._inventoryBucketId == null) ? 0 : this._inventoryBucketId
/* 161 */       .hashCode()) + ((this._itemId == null) ? 0 : this._itemId
/* 162 */       .hashCode());
/*     */   }
/*     */ 
/*     */   
/*     */   public String getDtxTypeName() {
/* 167 */     return "InventoryCountSnapshot";
/*     */   }
/*     */ 
/*     */   
/*     */   public String toString() {
/* 172 */     StringBuilder buff = new StringBuilder(72);
/*     */     
/* 174 */     return buff.append(
/* 175 */         String.valueOf(this._organizationId))
/* 176 */       .append("::").append(String.valueOf(this._retailLocationId))
/* 177 */       .append("::").append(this._inventoryCountId)
/* 178 */       .append("::").append(this._inventoryLocationId)
/* 179 */       .append("::").append(this._inventoryBucketId)
/* 180 */       .append("::").append(this._itemId)
/* 181 */       .toString();
/*     */   }
/*     */   
/*     */   public boolean validate() {
/* 185 */     if (this._retailLocationId == null) {
/* 186 */       return false;
/*     */     }
/* 188 */     if (this._inventoryCountId == null) {
/* 189 */       return false;
/*     */     }
/* 191 */     if (this._inventoryLocationId == null) {
/* 192 */       return false;
/*     */     }
/* 194 */     if (this._inventoryBucketId == null) {
/* 195 */       return false;
/*     */     }
/* 197 */     if (this._itemId == null) {
/* 198 */       return false;
/*     */     }
/* 200 */     return true;
/*     */   }
/*     */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\inv\InventoryCountSnapshotId.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */