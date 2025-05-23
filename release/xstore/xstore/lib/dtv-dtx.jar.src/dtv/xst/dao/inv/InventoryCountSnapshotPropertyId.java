/*     */ package dtv.xst.dao.inv;
/*     */ 
/*     */ import dtv.data2.access.AbstractObjectId;
/*     */ import dtv.data2.access.exception.DtxException;
/*     */ import dtv.util.StringUtils;
/*     */ 
/*     */ 
/*     */ 
/*     */ public class InventoryCountSnapshotPropertyId
/*     */   extends AbstractObjectId
/*     */ {
/*     */   private static final long serialVersionUID = 1678057228L;
/*     */   private Long _retailLocationId;
/*     */   private String _inventoryCountId;
/*     */   private String _inventoryLocationId;
/*     */   private String _inventoryBucketId;
/*     */   private String _itemId;
/*     */   private String _propertyCode;
/*     */   
/*     */   public InventoryCountSnapshotPropertyId() {}
/*     */   
/*     */   public InventoryCountSnapshotPropertyId(String argObjectIdValue) {
/*  23 */     setValue(argObjectIdValue);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Long getRetailLocationId() {
/*  34 */     return this._retailLocationId;
/*     */   }
/*     */   
/*     */   public void setRetailLocationId(Long argRetailLocationId) {
/*  38 */     this._retailLocationId = argRetailLocationId;
/*     */   }
/*     */   
/*     */   public String getInventoryCountId() {
/*  42 */     return this._inventoryCountId;
/*     */   }
/*     */   
/*     */   public void setInventoryCountId(String argInventoryCountId) {
/*  46 */     this._inventoryCountId = (argInventoryCountId != null && MANAGE_CASE) ? argInventoryCountId.toUpperCase() : argInventoryCountId;
/*     */   }
/*     */   
/*     */   public String getInventoryLocationId() {
/*  50 */     return this._inventoryLocationId;
/*     */   }
/*     */   
/*     */   public void setInventoryLocationId(String argInventoryLocationId) {
/*  54 */     this._inventoryLocationId = (argInventoryLocationId != null && MANAGE_CASE) ? argInventoryLocationId.toUpperCase() : argInventoryLocationId;
/*     */   }
/*     */   
/*     */   public String getInventoryBucketId() {
/*  58 */     return this._inventoryBucketId;
/*     */   }
/*     */   
/*     */   public void setInventoryBucketId(String argInventoryBucketId) {
/*  62 */     this._inventoryBucketId = (argInventoryBucketId != null && MANAGE_CASE) ? argInventoryBucketId.toUpperCase() : argInventoryBucketId;
/*     */   }
/*     */   
/*     */   public String getItemId() {
/*  66 */     return this._itemId;
/*     */   }
/*     */   
/*     */   public void setItemId(String argItemId) {
/*  70 */     this._itemId = (argItemId != null && MANAGE_CASE) ? argItemId.toUpperCase() : argItemId;
/*     */   }
/*     */   
/*     */   public String getPropertyCode() {
/*  74 */     return this._propertyCode;
/*     */   }
/*     */   
/*     */   public void setPropertyCode(String argPropertyCode) {
/*  78 */     this._propertyCode = (argPropertyCode != null && MANAGE_CASE) ? argPropertyCode.toUpperCase() : argPropertyCode;
/*     */   }
/*     */   
/*     */   public void setValue(String argObjectIdValue) {
/*  82 */     String str = argObjectIdValue;
/*  83 */     if (StringUtils.isEmpty(str)) {
/*  84 */       throw new DtxException("argument passed to setValue() is null or empty - a valid value must be passed");
/*     */     }
/*     */     try {
/*  87 */       String[] tokens = str.split("::");
/*  88 */       str = tokens[0];
/*     */       
/*  90 */       setOrganizationId(Long.valueOf(str));
/*  91 */       str = tokens[1];
/*     */       
/*  93 */       setRetailLocationId(Long.valueOf(str));
/*  94 */       str = tokens[2];
/*     */       
/*  96 */       if ("null".equals(str)) {
/*  97 */         setInventoryCountId((String)null);
/*     */       } else {
/*     */         
/* 100 */         setInventoryCountId(str);
/*     */       } 
/* 102 */       str = tokens[3];
/*     */       
/* 104 */       if ("null".equals(str)) {
/* 105 */         setInventoryLocationId((String)null);
/*     */       } else {
/*     */         
/* 108 */         setInventoryLocationId(str);
/*     */       } 
/* 110 */       str = tokens[4];
/*     */       
/* 112 */       if ("null".equals(str)) {
/* 113 */         setInventoryBucketId((String)null);
/*     */       } else {
/*     */         
/* 116 */         setInventoryBucketId(str);
/*     */       } 
/* 118 */       str = tokens[5];
/*     */       
/* 120 */       if ("null".equals(str)) {
/* 121 */         setItemId((String)null);
/*     */       } else {
/*     */         
/* 124 */         setItemId(str);
/*     */       } 
/* 126 */       str = tokens[6];
/*     */       
/* 128 */       if ("null".equals(str)) {
/* 129 */         setPropertyCode((String)null);
/*     */       } else {
/*     */         
/* 132 */         setPropertyCode(str);
/*     */       }
/*     */     
/* 135 */     } catch (Exception ee) {
/* 136 */       throw new DtxException("An exception occured while parsing object id string: " + argObjectIdValue, ee);
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean equals(Object ob) {
/* 142 */     if (this == ob) {
/* 143 */       return true;
/*     */     }
/* 145 */     if (!(ob instanceof InventoryCountSnapshotPropertyId)) {
/* 146 */       return false;
/*     */     }
/* 148 */     InventoryCountSnapshotPropertyId other = (InventoryCountSnapshotPropertyId)ob;
/* 149 */     return (((this._organizationId == null && other._organizationId == null) || (this._organizationId != null && this._organizationId
/*     */ 
/*     */       
/* 152 */       .equals(other._organizationId))) && ((this._retailLocationId == null && other._retailLocationId == null) || (this._retailLocationId != null && this._retailLocationId
/*     */ 
/*     */       
/* 155 */       .equals(other._retailLocationId))) && ((this._inventoryCountId == null && other._inventoryCountId == null) || (this._inventoryCountId != null && this._inventoryCountId
/*     */ 
/*     */       
/* 158 */       .equals(other._inventoryCountId))) && ((this._inventoryLocationId == null && other._inventoryLocationId == null) || (this._inventoryLocationId != null && this._inventoryLocationId
/*     */ 
/*     */       
/* 161 */       .equals(other._inventoryLocationId))) && ((this._inventoryBucketId == null && other._inventoryBucketId == null) || (this._inventoryBucketId != null && this._inventoryBucketId
/*     */ 
/*     */       
/* 164 */       .equals(other._inventoryBucketId))) && ((this._itemId == null && other._itemId == null) || (this._itemId != null && this._itemId
/*     */ 
/*     */       
/* 167 */       .equals(other._itemId))) && ((this._propertyCode == null && other._propertyCode == null) || (this._propertyCode != null && this._propertyCode
/*     */ 
/*     */       
/* 170 */       .equals(other._propertyCode))));
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public int hashCode() {
/* 176 */     return ((this._organizationId == null) ? 0 : this._organizationId
/* 177 */       .hashCode()) + ((this._retailLocationId == null) ? 0 : this._retailLocationId
/* 178 */       .hashCode()) + ((this._inventoryCountId == null) ? 0 : this._inventoryCountId
/* 179 */       .hashCode()) + ((this._inventoryLocationId == null) ? 0 : this._inventoryLocationId
/* 180 */       .hashCode()) + ((this._inventoryBucketId == null) ? 0 : this._inventoryBucketId
/* 181 */       .hashCode()) + ((this._itemId == null) ? 0 : this._itemId
/* 182 */       .hashCode()) + ((this._propertyCode == null) ? 0 : this._propertyCode
/* 183 */       .hashCode());
/*     */   }
/*     */ 
/*     */   
/*     */   public String getDtxTypeName() {
/* 188 */     return "InventoryCountSnapshotProperty";
/*     */   }
/*     */ 
/*     */   
/*     */   public String toString() {
/* 193 */     StringBuilder buff = new StringBuilder(84);
/*     */     
/* 195 */     return buff.append(
/* 196 */         String.valueOf(this._organizationId))
/* 197 */       .append("::").append(String.valueOf(this._retailLocationId))
/* 198 */       .append("::").append(this._inventoryCountId)
/* 199 */       .append("::").append(this._inventoryLocationId)
/* 200 */       .append("::").append(this._inventoryBucketId)
/* 201 */       .append("::").append(this._itemId)
/* 202 */       .append("::").append(this._propertyCode)
/* 203 */       .toString();
/*     */   }
/*     */   
/*     */   public boolean validate() {
/* 207 */     if (this._retailLocationId == null) {
/* 208 */       return false;
/*     */     }
/* 210 */     if (this._inventoryCountId == null) {
/* 211 */       return false;
/*     */     }
/* 213 */     if (this._inventoryLocationId == null) {
/* 214 */       return false;
/*     */     }
/* 216 */     if (this._inventoryBucketId == null) {
/* 217 */       return false;
/*     */     }
/* 219 */     if (this._itemId == null) {
/* 220 */       return false;
/*     */     }
/* 222 */     if (this._propertyCode == null) {
/* 223 */       return false;
/*     */     }
/* 225 */     return true;
/*     */   }
/*     */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\inv\InventoryCountSnapshotPropertyId.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */