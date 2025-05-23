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
/*     */ public class InventoryCountSectionPropertyId
/*     */   extends AbstractObjectId
/*     */ {
/*     */   private static final long serialVersionUID = 1644612135L;
/*     */   private Long _retailLocationId;
/*     */   private String _inventoryBucketId;
/*     */   private String _sectionId;
/*     */   private String _propertyCode;
/*     */   
/*     */   public InventoryCountSectionPropertyId() {}
/*     */   
/*     */   public InventoryCountSectionPropertyId(String argObjectIdValue) {
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
/*     */   public String getInventoryBucketId() {
/*  40 */     return this._inventoryBucketId;
/*     */   }
/*     */   
/*     */   public void setInventoryBucketId(String argInventoryBucketId) {
/*  44 */     this._inventoryBucketId = (argInventoryBucketId != null && MANAGE_CASE) ? argInventoryBucketId.toUpperCase() : argInventoryBucketId;
/*     */   }
/*     */   
/*     */   public String getSectionId() {
/*  48 */     return this._sectionId;
/*     */   }
/*     */   
/*     */   public void setSectionId(String argSectionId) {
/*  52 */     this._sectionId = (argSectionId != null && MANAGE_CASE) ? argSectionId.toUpperCase() : argSectionId;
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
/*  79 */         setInventoryBucketId((String)null);
/*     */       } else {
/*     */         
/*  82 */         setInventoryBucketId(str);
/*     */       } 
/*  84 */       str = tokens[3];
/*     */       
/*  86 */       if ("null".equals(str)) {
/*  87 */         setSectionId((String)null);
/*     */       } else {
/*     */         
/*  90 */         setSectionId(str);
/*     */       } 
/*  92 */       str = tokens[4];
/*     */       
/*  94 */       if ("null".equals(str)) {
/*  95 */         setPropertyCode((String)null);
/*     */       } else {
/*     */         
/*  98 */         setPropertyCode(str);
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
/* 111 */     if (!(ob instanceof InventoryCountSectionPropertyId)) {
/* 112 */       return false;
/*     */     }
/* 114 */     InventoryCountSectionPropertyId other = (InventoryCountSectionPropertyId)ob;
/* 115 */     return (((this._organizationId == null && other._organizationId == null) || (this._organizationId != null && this._organizationId
/*     */ 
/*     */       
/* 118 */       .equals(other._organizationId))) && ((this._retailLocationId == null && other._retailLocationId == null) || (this._retailLocationId != null && this._retailLocationId
/*     */ 
/*     */       
/* 121 */       .equals(other._retailLocationId))) && ((this._inventoryBucketId == null && other._inventoryBucketId == null) || (this._inventoryBucketId != null && this._inventoryBucketId
/*     */ 
/*     */       
/* 124 */       .equals(other._inventoryBucketId))) && ((this._sectionId == null && other._sectionId == null) || (this._sectionId != null && this._sectionId
/*     */ 
/*     */       
/* 127 */       .equals(other._sectionId))) && ((this._propertyCode == null && other._propertyCode == null) || (this._propertyCode != null && this._propertyCode
/*     */ 
/*     */       
/* 130 */       .equals(other._propertyCode))));
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public int hashCode() {
/* 136 */     return ((this._organizationId == null) ? 0 : this._organizationId
/* 137 */       .hashCode()) + ((this._retailLocationId == null) ? 0 : this._retailLocationId
/* 138 */       .hashCode()) + ((this._inventoryBucketId == null) ? 0 : this._inventoryBucketId
/* 139 */       .hashCode()) + ((this._sectionId == null) ? 0 : this._sectionId
/* 140 */       .hashCode()) + ((this._propertyCode == null) ? 0 : this._propertyCode
/* 141 */       .hashCode());
/*     */   }
/*     */ 
/*     */   
/*     */   public String getDtxTypeName() {
/* 146 */     return "InventoryCountSectionProperty";
/*     */   }
/*     */ 
/*     */   
/*     */   public String toString() {
/* 151 */     StringBuilder buff = new StringBuilder(60);
/*     */     
/* 153 */     return buff.append(
/* 154 */         String.valueOf(this._organizationId))
/* 155 */       .append("::").append(String.valueOf(this._retailLocationId))
/* 156 */       .append("::").append(this._inventoryBucketId)
/* 157 */       .append("::").append(this._sectionId)
/* 158 */       .append("::").append(this._propertyCode)
/* 159 */       .toString();
/*     */   }
/*     */   
/*     */   public boolean validate() {
/* 163 */     if (this._retailLocationId == null) {
/* 164 */       return false;
/*     */     }
/* 166 */     if (this._inventoryBucketId == null) {
/* 167 */       return false;
/*     */     }
/* 169 */     if (this._sectionId == null) {
/* 170 */       return false;
/*     */     }
/* 172 */     if (this._propertyCode == null) {
/* 173 */       return false;
/*     */     }
/* 175 */     return true;
/*     */   }
/*     */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\inv\InventoryCountSectionPropertyId.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */