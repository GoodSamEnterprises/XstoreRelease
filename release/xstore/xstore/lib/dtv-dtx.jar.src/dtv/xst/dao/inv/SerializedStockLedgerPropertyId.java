/*     */ package dtv.xst.dao.inv;
/*     */ 
/*     */ import dtv.data2.access.AbstractObjectId;
/*     */ import dtv.data2.access.exception.DtxException;
/*     */ import dtv.util.StringUtils;
/*     */ 
/*     */ 
/*     */ 
/*     */ public class SerializedStockLedgerPropertyId
/*     */   extends AbstractObjectId
/*     */ {
/*     */   private static final long serialVersionUID = -648067376L;
/*     */   private Long _retailLocationId;
/*     */   private String _invLocationId;
/*     */   private String _itemId;
/*     */   private String _serialNumber;
/*     */   private String _bucketId;
/*     */   private String _propertyCode;
/*     */   
/*     */   public SerializedStockLedgerPropertyId() {}
/*     */   
/*     */   public SerializedStockLedgerPropertyId(String argObjectIdValue) {
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
/*     */   public String getInvLocationId() {
/*  42 */     return this._invLocationId;
/*     */   }
/*     */   
/*     */   public void setInvLocationId(String argInvLocationId) {
/*  46 */     this._invLocationId = (argInvLocationId != null && MANAGE_CASE) ? argInvLocationId.toUpperCase() : argInvLocationId;
/*     */   }
/*     */   
/*     */   public String getItemId() {
/*  50 */     return this._itemId;
/*     */   }
/*     */   
/*     */   public void setItemId(String argItemId) {
/*  54 */     this._itemId = (argItemId != null && MANAGE_CASE) ? argItemId.toUpperCase() : argItemId;
/*     */   }
/*     */   
/*     */   public String getSerialNumber() {
/*  58 */     return this._serialNumber;
/*     */   }
/*     */   
/*     */   public void setSerialNumber(String argSerialNumber) {
/*  62 */     this._serialNumber = (argSerialNumber != null && MANAGE_CASE) ? argSerialNumber.toUpperCase() : argSerialNumber;
/*     */   }
/*     */   
/*     */   public String getBucketId() {
/*  66 */     return this._bucketId;
/*     */   }
/*     */   
/*     */   public void setBucketId(String argBucketId) {
/*  70 */     this._bucketId = (argBucketId != null && MANAGE_CASE) ? argBucketId.toUpperCase() : argBucketId;
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
/*  97 */         setInvLocationId((String)null);
/*     */       } else {
/*     */         
/* 100 */         setInvLocationId(str);
/*     */       } 
/* 102 */       str = tokens[3];
/*     */       
/* 104 */       if ("null".equals(str)) {
/* 105 */         setItemId((String)null);
/*     */       } else {
/*     */         
/* 108 */         setItemId(str);
/*     */       } 
/* 110 */       str = tokens[4];
/*     */       
/* 112 */       if ("null".equals(str)) {
/* 113 */         setSerialNumber((String)null);
/*     */       } else {
/*     */         
/* 116 */         setSerialNumber(str);
/*     */       } 
/* 118 */       str = tokens[5];
/*     */       
/* 120 */       if ("null".equals(str)) {
/* 121 */         setBucketId((String)null);
/*     */       } else {
/*     */         
/* 124 */         setBucketId(str);
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
/* 145 */     if (!(ob instanceof SerializedStockLedgerPropertyId)) {
/* 146 */       return false;
/*     */     }
/* 148 */     SerializedStockLedgerPropertyId other = (SerializedStockLedgerPropertyId)ob;
/* 149 */     return (((this._organizationId == null && other._organizationId == null) || (this._organizationId != null && this._organizationId
/*     */ 
/*     */       
/* 152 */       .equals(other._organizationId))) && ((this._retailLocationId == null && other._retailLocationId == null) || (this._retailLocationId != null && this._retailLocationId
/*     */ 
/*     */       
/* 155 */       .equals(other._retailLocationId))) && ((this._invLocationId == null && other._invLocationId == null) || (this._invLocationId != null && this._invLocationId
/*     */ 
/*     */       
/* 158 */       .equals(other._invLocationId))) && ((this._itemId == null && other._itemId == null) || (this._itemId != null && this._itemId
/*     */ 
/*     */       
/* 161 */       .equals(other._itemId))) && ((this._serialNumber == null && other._serialNumber == null) || (this._serialNumber != null && this._serialNumber
/*     */ 
/*     */       
/* 164 */       .equals(other._serialNumber))) && ((this._bucketId == null && other._bucketId == null) || (this._bucketId != null && this._bucketId
/*     */ 
/*     */       
/* 167 */       .equals(other._bucketId))) && ((this._propertyCode == null && other._propertyCode == null) || (this._propertyCode != null && this._propertyCode
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
/* 178 */       .hashCode()) + ((this._invLocationId == null) ? 0 : this._invLocationId
/* 179 */       .hashCode()) + ((this._itemId == null) ? 0 : this._itemId
/* 180 */       .hashCode()) + ((this._serialNumber == null) ? 0 : this._serialNumber
/* 181 */       .hashCode()) + ((this._bucketId == null) ? 0 : this._bucketId
/* 182 */       .hashCode()) + ((this._propertyCode == null) ? 0 : this._propertyCode
/* 183 */       .hashCode());
/*     */   }
/*     */ 
/*     */   
/*     */   public String getDtxTypeName() {
/* 188 */     return "SerializedStockLedgerProperty";
/*     */   }
/*     */ 
/*     */   
/*     */   public String toString() {
/* 193 */     StringBuilder buff = new StringBuilder(84);
/*     */     
/* 195 */     return buff.append(
/* 196 */         String.valueOf(this._organizationId))
/* 197 */       .append("::").append(String.valueOf(this._retailLocationId))
/* 198 */       .append("::").append(this._invLocationId)
/* 199 */       .append("::").append(this._itemId)
/* 200 */       .append("::").append(this._serialNumber)
/* 201 */       .append("::").append(this._bucketId)
/* 202 */       .append("::").append(this._propertyCode)
/* 203 */       .toString();
/*     */   }
/*     */   
/*     */   public boolean validate() {
/* 207 */     if (this._retailLocationId == null) {
/* 208 */       return false;
/*     */     }
/* 210 */     if (this._invLocationId == null) {
/* 211 */       return false;
/*     */     }
/* 213 */     if (this._itemId == null) {
/* 214 */       return false;
/*     */     }
/* 216 */     if (this._serialNumber == null) {
/* 217 */       return false;
/*     */     }
/* 219 */     if (this._bucketId == null) {
/* 220 */       return false;
/*     */     }
/* 222 */     if (this._propertyCode == null) {
/* 223 */       return false;
/*     */     }
/* 225 */     return true;
/*     */   }
/*     */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\inv\SerializedStockLedgerPropertyId.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */