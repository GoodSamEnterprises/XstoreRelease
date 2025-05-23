/*     */ package dtv.xst.dao.inv;
/*     */ 
/*     */ import dtv.data2.access.AbstractObjectId;
/*     */ import dtv.data2.access.exception.DtxException;
/*     */ import dtv.util.StringUtils;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class SerializedStockLedgerId
/*     */   extends AbstractObjectId
/*     */ {
/*     */   private static final long serialVersionUID = 313200603L;
/*     */   private Long _retailLocationId;
/*     */   private String _invLocationId;
/*     */   private String _itemId;
/*     */   private String _serialNumber;
/*     */   private String _bucketId;
/*     */   
/*     */   public SerializedStockLedgerId() {}
/*     */   
/*     */   public SerializedStockLedgerId(String argObjectIdValue) {
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
/*     */   public String getInvLocationId() {
/*  41 */     return this._invLocationId;
/*     */   }
/*     */   
/*     */   public void setInvLocationId(String argInvLocationId) {
/*  45 */     this._invLocationId = (argInvLocationId != null && MANAGE_CASE) ? argInvLocationId.toUpperCase() : argInvLocationId;
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
/*     */   public String getSerialNumber() {
/*  57 */     return this._serialNumber;
/*     */   }
/*     */   
/*     */   public void setSerialNumber(String argSerialNumber) {
/*  61 */     this._serialNumber = (argSerialNumber != null && MANAGE_CASE) ? argSerialNumber.toUpperCase() : argSerialNumber;
/*     */   }
/*     */   
/*     */   public String getBucketId() {
/*  65 */     return this._bucketId;
/*     */   }
/*     */   
/*     */   public void setBucketId(String argBucketId) {
/*  69 */     this._bucketId = (argBucketId != null && MANAGE_CASE) ? argBucketId.toUpperCase() : argBucketId;
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
/*  88 */         setInvLocationId((String)null);
/*     */       } else {
/*     */         
/*  91 */         setInvLocationId(str);
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
/* 104 */         setSerialNumber((String)null);
/*     */       } else {
/*     */         
/* 107 */         setSerialNumber(str);
/*     */       } 
/* 109 */       str = tokens[5];
/*     */       
/* 111 */       if ("null".equals(str)) {
/* 112 */         setBucketId((String)null);
/*     */       } else {
/*     */         
/* 115 */         setBucketId(str);
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
/* 128 */     if (!(ob instanceof SerializedStockLedgerId)) {
/* 129 */       return false;
/*     */     }
/* 131 */     SerializedStockLedgerId other = (SerializedStockLedgerId)ob;
/* 132 */     return (((this._organizationId == null && other._organizationId == null) || (this._organizationId != null && this._organizationId
/*     */ 
/*     */       
/* 135 */       .equals(other._organizationId))) && ((this._retailLocationId == null && other._retailLocationId == null) || (this._retailLocationId != null && this._retailLocationId
/*     */ 
/*     */       
/* 138 */       .equals(other._retailLocationId))) && ((this._invLocationId == null && other._invLocationId == null) || (this._invLocationId != null && this._invLocationId
/*     */ 
/*     */       
/* 141 */       .equals(other._invLocationId))) && ((this._itemId == null && other._itemId == null) || (this._itemId != null && this._itemId
/*     */ 
/*     */       
/* 144 */       .equals(other._itemId))) && ((this._serialNumber == null && other._serialNumber == null) || (this._serialNumber != null && this._serialNumber
/*     */ 
/*     */       
/* 147 */       .equals(other._serialNumber))) && ((this._bucketId == null && other._bucketId == null) || (this._bucketId != null && this._bucketId
/*     */ 
/*     */       
/* 150 */       .equals(other._bucketId))));
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public int hashCode() {
/* 156 */     return ((this._organizationId == null) ? 0 : this._organizationId
/* 157 */       .hashCode()) + ((this._retailLocationId == null) ? 0 : this._retailLocationId
/* 158 */       .hashCode()) + ((this._invLocationId == null) ? 0 : this._invLocationId
/* 159 */       .hashCode()) + ((this._itemId == null) ? 0 : this._itemId
/* 160 */       .hashCode()) + ((this._serialNumber == null) ? 0 : this._serialNumber
/* 161 */       .hashCode()) + ((this._bucketId == null) ? 0 : this._bucketId
/* 162 */       .hashCode());
/*     */   }
/*     */ 
/*     */   
/*     */   public String getDtxTypeName() {
/* 167 */     return "SerializedStockLedger";
/*     */   }
/*     */ 
/*     */   
/*     */   public String toString() {
/* 172 */     StringBuilder buff = new StringBuilder(72);
/*     */     
/* 174 */     return buff.append(
/* 175 */         String.valueOf(this._organizationId))
/* 176 */       .append("::").append(String.valueOf(this._retailLocationId))
/* 177 */       .append("::").append(this._invLocationId)
/* 178 */       .append("::").append(this._itemId)
/* 179 */       .append("::").append(this._serialNumber)
/* 180 */       .append("::").append(this._bucketId)
/* 181 */       .toString();
/*     */   }
/*     */   
/*     */   public boolean validate() {
/* 185 */     if (this._retailLocationId == null) {
/* 186 */       return false;
/*     */     }
/* 188 */     if (this._invLocationId == null) {
/* 189 */       return false;
/*     */     }
/* 191 */     if (this._itemId == null) {
/* 192 */       return false;
/*     */     }
/* 194 */     if (this._serialNumber == null) {
/* 195 */       return false;
/*     */     }
/* 197 */     if (this._bucketId == null) {
/* 198 */       return false;
/*     */     }
/* 200 */     return true;
/*     */   }
/*     */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\inv\SerializedStockLedgerId.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */