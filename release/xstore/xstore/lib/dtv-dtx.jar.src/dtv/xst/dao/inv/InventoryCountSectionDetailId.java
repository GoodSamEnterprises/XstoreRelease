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
/*     */ public class InventoryCountSectionDetailId
/*     */   extends AbstractObjectId
/*     */ {
/*     */   private static final long serialVersionUID = 1362489635L;
/*     */   private Long _retailLocationId;
/*     */   private String _inventoryBucketId;
/*     */   private String _sectionId;
/*     */   private Integer _sectionDetailNumber;
/*     */   
/*     */   public InventoryCountSectionDetailId() {}
/*     */   
/*     */   public InventoryCountSectionDetailId(String argObjectIdValue) {
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
/*     */   public Integer getSectionDetailNumber() {
/*  56 */     return this._sectionDetailNumber;
/*     */   }
/*     */   
/*     */   public void setSectionDetailNumber(Integer argSectionDetailNumber) {
/*  60 */     this._sectionDetailNumber = argSectionDetailNumber;
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
/*  94 */       setSectionDetailNumber(Integer.valueOf(str));
/*     */     }
/*  96 */     catch (Exception ee) {
/*  97 */       throw new DtxException("An exception occured while parsing object id string: " + argObjectIdValue, ee);
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean equals(Object ob) {
/* 103 */     if (this == ob) {
/* 104 */       return true;
/*     */     }
/* 106 */     if (!(ob instanceof InventoryCountSectionDetailId)) {
/* 107 */       return false;
/*     */     }
/* 109 */     InventoryCountSectionDetailId other = (InventoryCountSectionDetailId)ob;
/* 110 */     return (((this._organizationId == null && other._organizationId == null) || (this._organizationId != null && this._organizationId
/*     */ 
/*     */       
/* 113 */       .equals(other._organizationId))) && ((this._retailLocationId == null && other._retailLocationId == null) || (this._retailLocationId != null && this._retailLocationId
/*     */ 
/*     */       
/* 116 */       .equals(other._retailLocationId))) && ((this._inventoryBucketId == null && other._inventoryBucketId == null) || (this._inventoryBucketId != null && this._inventoryBucketId
/*     */ 
/*     */       
/* 119 */       .equals(other._inventoryBucketId))) && ((this._sectionId == null && other._sectionId == null) || (this._sectionId != null && this._sectionId
/*     */ 
/*     */       
/* 122 */       .equals(other._sectionId))) && ((this._sectionDetailNumber == null && other._sectionDetailNumber == null) || (this._sectionDetailNumber != null && this._sectionDetailNumber
/*     */ 
/*     */       
/* 125 */       .equals(other._sectionDetailNumber))));
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public int hashCode() {
/* 131 */     return ((this._organizationId == null) ? 0 : this._organizationId
/* 132 */       .hashCode()) + ((this._retailLocationId == null) ? 0 : this._retailLocationId
/* 133 */       .hashCode()) + ((this._inventoryBucketId == null) ? 0 : this._inventoryBucketId
/* 134 */       .hashCode()) + ((this._sectionId == null) ? 0 : this._sectionId
/* 135 */       .hashCode()) + ((this._sectionDetailNumber == null) ? 0 : this._sectionDetailNumber
/* 136 */       .hashCode());
/*     */   }
/*     */ 
/*     */   
/*     */   public String getDtxTypeName() {
/* 141 */     return "InventoryCountSectionDetail";
/*     */   }
/*     */ 
/*     */   
/*     */   public String toString() {
/* 146 */     StringBuilder buff = new StringBuilder(60);
/*     */     
/* 148 */     return buff.append(
/* 149 */         String.valueOf(this._organizationId))
/* 150 */       .append("::").append(String.valueOf(this._retailLocationId))
/* 151 */       .append("::").append(this._inventoryBucketId)
/* 152 */       .append("::").append(this._sectionId)
/* 153 */       .append("::").append(String.valueOf(this._sectionDetailNumber))
/* 154 */       .toString();
/*     */   }
/*     */   
/*     */   public boolean validate() {
/* 158 */     if (this._retailLocationId == null) {
/* 159 */       return false;
/*     */     }
/* 161 */     if (this._inventoryBucketId == null) {
/* 162 */       return false;
/*     */     }
/* 164 */     if (this._sectionId == null) {
/* 165 */       return false;
/*     */     }
/* 167 */     if (this._sectionDetailNumber == null) {
/* 168 */       return false;
/*     */     }
/* 170 */     return true;
/*     */   }
/*     */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\inv\InventoryCountSectionDetailId.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */