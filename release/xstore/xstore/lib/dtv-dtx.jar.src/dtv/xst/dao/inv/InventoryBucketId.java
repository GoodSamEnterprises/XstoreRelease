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
/*     */ 
/*     */ public class InventoryBucketId
/*     */   extends AbstractObjectId
/*     */ {
/*     */   private static final long serialVersionUID = 1441305158L;
/*     */   private Long _retailLocationId;
/*     */   private String _bucketId;
/*     */   
/*     */   public InventoryBucketId() {}
/*     */   
/*     */   public InventoryBucketId(String argObjectIdValue) {
/*  23 */     setValue(argObjectIdValue);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Long getRetailLocationId() {
/*  30 */     return this._retailLocationId;
/*     */   }
/*     */   
/*     */   public void setRetailLocationId(Long argRetailLocationId) {
/*  34 */     this._retailLocationId = argRetailLocationId;
/*     */   }
/*     */   
/*     */   public String getBucketId() {
/*  38 */     return this._bucketId;
/*     */   }
/*     */   
/*     */   public void setBucketId(String argBucketId) {
/*  42 */     this._bucketId = (argBucketId != null && MANAGE_CASE) ? argBucketId.toUpperCase() : argBucketId;
/*     */   }
/*     */   
/*     */   public void setValue(String argObjectIdValue) {
/*  46 */     String str = argObjectIdValue;
/*  47 */     if (StringUtils.isEmpty(str)) {
/*  48 */       throw new DtxException("argument passed to setValue() is null or empty - a valid value must be passed");
/*     */     }
/*     */     try {
/*  51 */       String[] tokens = str.split("::");
/*  52 */       str = tokens[0];
/*     */       
/*  54 */       setOrganizationId(Long.valueOf(str));
/*  55 */       str = tokens[1];
/*     */       
/*  57 */       setRetailLocationId(Long.valueOf(str));
/*  58 */       str = tokens[2];
/*     */       
/*  60 */       if ("null".equals(str)) {
/*  61 */         setBucketId((String)null);
/*     */       } else {
/*     */         
/*  64 */         setBucketId(str);
/*     */       }
/*     */     
/*  67 */     } catch (Exception ee) {
/*  68 */       throw new DtxException("An exception occured while parsing object id string: " + argObjectIdValue, ee);
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean equals(Object ob) {
/*  74 */     if (this == ob) {
/*  75 */       return true;
/*     */     }
/*  77 */     if (!(ob instanceof InventoryBucketId)) {
/*  78 */       return false;
/*     */     }
/*  80 */     InventoryBucketId other = (InventoryBucketId)ob;
/*  81 */     return (((this._organizationId == null && other._organizationId == null) || (this._organizationId != null && this._organizationId
/*     */ 
/*     */       
/*  84 */       .equals(other._organizationId))) && ((this._retailLocationId == null && other._retailLocationId == null) || (this._retailLocationId != null && this._retailLocationId
/*     */ 
/*     */       
/*  87 */       .equals(other._retailLocationId))) && ((this._bucketId == null && other._bucketId == null) || (this._bucketId != null && this._bucketId
/*     */ 
/*     */       
/*  90 */       .equals(other._bucketId))));
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public int hashCode() {
/*  96 */     return ((this._organizationId == null) ? 0 : this._organizationId
/*  97 */       .hashCode()) + ((this._retailLocationId == null) ? 0 : this._retailLocationId
/*  98 */       .hashCode()) + ((this._bucketId == null) ? 0 : this._bucketId
/*  99 */       .hashCode());
/*     */   }
/*     */ 
/*     */   
/*     */   public String getDtxTypeName() {
/* 104 */     return "InventoryBucket";
/*     */   }
/*     */ 
/*     */   
/*     */   public String toString() {
/* 109 */     StringBuilder buff = new StringBuilder(36);
/*     */     
/* 111 */     return buff.append(
/* 112 */         String.valueOf(this._organizationId))
/* 113 */       .append("::").append(String.valueOf(this._retailLocationId))
/* 114 */       .append("::").append(this._bucketId)
/* 115 */       .toString();
/*     */   }
/*     */   
/*     */   public boolean validate() {
/* 119 */     if (this._retailLocationId == null) {
/* 120 */       return false;
/*     */     }
/* 122 */     if (this._bucketId == null) {
/* 123 */       return false;
/*     */     }
/* 125 */     return true;
/*     */   }
/*     */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\inv\InventoryBucketId.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */