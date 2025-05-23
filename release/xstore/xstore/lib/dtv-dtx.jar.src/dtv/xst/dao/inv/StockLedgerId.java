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
/*     */ public class StockLedgerId
/*     */   extends AbstractObjectId
/*     */ {
/*     */   private static final long serialVersionUID = 282529791L;
/*     */   private Long _retailLocationId;
/*     */   private String _bucketId;
/*     */   private String _invLocationId;
/*     */   private String _itemId;
/*     */   
/*     */   public StockLedgerId() {}
/*     */   
/*     */   public StockLedgerId(String argObjectIdValue) {
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
/*     */   public String getBucketId() {
/*  40 */     return this._bucketId;
/*     */   }
/*     */   
/*     */   public void setBucketId(String argBucketId) {
/*  44 */     this._bucketId = (argBucketId != null && MANAGE_CASE) ? argBucketId.toUpperCase() : argBucketId;
/*     */   }
/*     */   
/*     */   public String getInvLocationId() {
/*  48 */     return this._invLocationId;
/*     */   }
/*     */   
/*     */   public void setInvLocationId(String argInvLocationId) {
/*  52 */     this._invLocationId = (argInvLocationId != null && MANAGE_CASE) ? argInvLocationId.toUpperCase() : argInvLocationId;
/*     */   }
/*     */   
/*     */   public String getItemId() {
/*  56 */     return this._itemId;
/*     */   }
/*     */   
/*     */   public void setItemId(String argItemId) {
/*  60 */     this._itemId = (argItemId != null && MANAGE_CASE) ? argItemId.toUpperCase() : argItemId;
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
/*  79 */         setBucketId((String)null);
/*     */       } else {
/*     */         
/*  82 */         setBucketId(str);
/*     */       } 
/*  84 */       str = tokens[3];
/*     */       
/*  86 */       if ("null".equals(str)) {
/*  87 */         setInvLocationId((String)null);
/*     */       } else {
/*     */         
/*  90 */         setInvLocationId(str);
/*     */       } 
/*  92 */       str = tokens[4];
/*     */       
/*  94 */       if ("null".equals(str)) {
/*  95 */         setItemId((String)null);
/*     */       } else {
/*     */         
/*  98 */         setItemId(str);
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
/* 111 */     if (!(ob instanceof StockLedgerId)) {
/* 112 */       return false;
/*     */     }
/* 114 */     StockLedgerId other = (StockLedgerId)ob;
/* 115 */     return (((this._organizationId == null && other._organizationId == null) || (this._organizationId != null && this._organizationId
/*     */ 
/*     */       
/* 118 */       .equals(other._organizationId))) && ((this._retailLocationId == null && other._retailLocationId == null) || (this._retailLocationId != null && this._retailLocationId
/*     */ 
/*     */       
/* 121 */       .equals(other._retailLocationId))) && ((this._bucketId == null && other._bucketId == null) || (this._bucketId != null && this._bucketId
/*     */ 
/*     */       
/* 124 */       .equals(other._bucketId))) && ((this._invLocationId == null && other._invLocationId == null) || (this._invLocationId != null && this._invLocationId
/*     */ 
/*     */       
/* 127 */       .equals(other._invLocationId))) && ((this._itemId == null && other._itemId == null) || (this._itemId != null && this._itemId
/*     */ 
/*     */       
/* 130 */       .equals(other._itemId))));
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public int hashCode() {
/* 136 */     return ((this._organizationId == null) ? 0 : this._organizationId
/* 137 */       .hashCode()) + ((this._retailLocationId == null) ? 0 : this._retailLocationId
/* 138 */       .hashCode()) + ((this._bucketId == null) ? 0 : this._bucketId
/* 139 */       .hashCode()) + ((this._invLocationId == null) ? 0 : this._invLocationId
/* 140 */       .hashCode()) + ((this._itemId == null) ? 0 : this._itemId
/* 141 */       .hashCode());
/*     */   }
/*     */ 
/*     */   
/*     */   public String getDtxTypeName() {
/* 146 */     return "StockLedger";
/*     */   }
/*     */ 
/*     */   
/*     */   public String toString() {
/* 151 */     StringBuilder buff = new StringBuilder(60);
/*     */     
/* 153 */     return buff.append(
/* 154 */         String.valueOf(this._organizationId))
/* 155 */       .append("::").append(String.valueOf(this._retailLocationId))
/* 156 */       .append("::").append(this._bucketId)
/* 157 */       .append("::").append(this._invLocationId)
/* 158 */       .append("::").append(this._itemId)
/* 159 */       .toString();
/*     */   }
/*     */   
/*     */   public boolean validate() {
/* 163 */     if (this._retailLocationId == null) {
/* 164 */       return false;
/*     */     }
/* 166 */     if (this._bucketId == null) {
/* 167 */       return false;
/*     */     }
/* 169 */     if (this._invLocationId == null) {
/* 170 */       return false;
/*     */     }
/* 172 */     if (this._itemId == null) {
/* 173 */       return false;
/*     */     }
/* 175 */     return true;
/*     */   }
/*     */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\inv\StockLedgerId.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */