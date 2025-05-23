/*     */ package dtv.xst.dao.inv;
/*     */ 
/*     */ import dtv.data2.access.AbstractObjectId;
/*     */ import dtv.data2.access.exception.DtxException;
/*     */ import dtv.util.StringUtils;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class InventoryDocumentLineSerialId
/*     */   extends AbstractObjectId
/*     */ {
/*     */   private static final long serialVersionUID = 423606495L;
/*     */   private String _documentId;
/*     */   private String _documentTypeCode;
/*     */   private Integer _inventoryDocumentLineNumber;
/*     */   private Long _retailLocationId;
/*     */   private Integer _serialLineNumber;
/*     */   
/*     */   public InventoryDocumentLineSerialId() {}
/*     */   
/*     */   public InventoryDocumentLineSerialId(String argObjectIdValue) {
/*  23 */     setValue(argObjectIdValue);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getDocumentId() {
/*  33 */     return this._documentId;
/*     */   }
/*     */   
/*     */   public void setDocumentId(String argDocumentId) {
/*  37 */     this._documentId = (argDocumentId != null && MANAGE_CASE) ? argDocumentId.toUpperCase() : argDocumentId;
/*     */   }
/*     */   
/*     */   public String getDocumentTypeCode() {
/*  41 */     return this._documentTypeCode;
/*     */   }
/*     */   
/*     */   public void setDocumentTypeCode(String argDocumentTypeCode) {
/*  45 */     this._documentTypeCode = (argDocumentTypeCode != null && MANAGE_CASE) ? argDocumentTypeCode.toUpperCase() : argDocumentTypeCode;
/*     */   }
/*     */   
/*     */   public Integer getInventoryDocumentLineNumber() {
/*  49 */     return this._inventoryDocumentLineNumber;
/*     */   }
/*     */   
/*     */   public void setInventoryDocumentLineNumber(Integer argInventoryDocumentLineNumber) {
/*  53 */     this._inventoryDocumentLineNumber = argInventoryDocumentLineNumber;
/*     */   }
/*     */   
/*     */   public Long getRetailLocationId() {
/*  57 */     return this._retailLocationId;
/*     */   }
/*     */   
/*     */   public void setRetailLocationId(Long argRetailLocationId) {
/*  61 */     this._retailLocationId = argRetailLocationId;
/*     */   }
/*     */   
/*     */   public Integer getSerialLineNumber() {
/*  65 */     return this._serialLineNumber;
/*     */   }
/*     */   
/*     */   public void setSerialLineNumber(Integer argSerialLineNumber) {
/*  69 */     this._serialLineNumber = argSerialLineNumber;
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
/*  81 */       if ("null".equals(str)) {
/*  82 */         setDocumentId((String)null);
/*     */       } else {
/*     */         
/*  85 */         setDocumentId(str);
/*     */       } 
/*  87 */       str = tokens[1];
/*     */       
/*  89 */       if ("null".equals(str)) {
/*  90 */         setDocumentTypeCode((String)null);
/*     */       } else {
/*     */         
/*  93 */         setDocumentTypeCode(str);
/*     */       } 
/*  95 */       str = tokens[2];
/*     */       
/*  97 */       setInventoryDocumentLineNumber(Integer.valueOf(str));
/*  98 */       str = tokens[3];
/*     */       
/* 100 */       setOrganizationId(Long.valueOf(str));
/* 101 */       str = tokens[4];
/*     */       
/* 103 */       setRetailLocationId(Long.valueOf(str));
/* 104 */       str = tokens[5];
/*     */       
/* 106 */       setSerialLineNumber(Integer.valueOf(str));
/*     */     }
/* 108 */     catch (Exception ee) {
/* 109 */       throw new DtxException("An exception occured while parsing object id string: " + argObjectIdValue, ee);
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean equals(Object ob) {
/* 115 */     if (this == ob) {
/* 116 */       return true;
/*     */     }
/* 118 */     if (!(ob instanceof InventoryDocumentLineSerialId)) {
/* 119 */       return false;
/*     */     }
/* 121 */     InventoryDocumentLineSerialId other = (InventoryDocumentLineSerialId)ob;
/* 122 */     return (((this._documentId == null && other._documentId == null) || (this._documentId != null && this._documentId
/*     */ 
/*     */       
/* 125 */       .equals(other._documentId))) && ((this._documentTypeCode == null && other._documentTypeCode == null) || (this._documentTypeCode != null && this._documentTypeCode
/*     */ 
/*     */       
/* 128 */       .equals(other._documentTypeCode))) && ((this._inventoryDocumentLineNumber == null && other._inventoryDocumentLineNumber == null) || (this._inventoryDocumentLineNumber != null && this._inventoryDocumentLineNumber
/*     */ 
/*     */       
/* 131 */       .equals(other._inventoryDocumentLineNumber))) && ((this._organizationId == null && other._organizationId == null) || (this._organizationId != null && this._organizationId
/*     */ 
/*     */       
/* 134 */       .equals(other._organizationId))) && ((this._retailLocationId == null && other._retailLocationId == null) || (this._retailLocationId != null && this._retailLocationId
/*     */ 
/*     */       
/* 137 */       .equals(other._retailLocationId))) && ((this._serialLineNumber == null && other._serialLineNumber == null) || (this._serialLineNumber != null && this._serialLineNumber
/*     */ 
/*     */       
/* 140 */       .equals(other._serialLineNumber))));
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public int hashCode() {
/* 146 */     return ((this._documentId == null) ? 0 : this._documentId
/* 147 */       .hashCode()) + ((this._documentTypeCode == null) ? 0 : this._documentTypeCode
/* 148 */       .hashCode()) + ((this._inventoryDocumentLineNumber == null) ? 0 : this._inventoryDocumentLineNumber
/* 149 */       .hashCode()) + ((this._organizationId == null) ? 0 : this._organizationId
/* 150 */       .hashCode()) + ((this._retailLocationId == null) ? 0 : this._retailLocationId
/* 151 */       .hashCode()) + ((this._serialLineNumber == null) ? 0 : this._serialLineNumber
/* 152 */       .hashCode());
/*     */   }
/*     */ 
/*     */   
/*     */   public String getDtxTypeName() {
/* 157 */     return "InventoryDocumentLineSerial";
/*     */   }
/*     */ 
/*     */   
/*     */   public String toString() {
/* 162 */     StringBuilder buff = new StringBuilder(72);
/*     */     
/* 164 */     return buff.append(this._documentId)
/*     */       
/* 166 */       .append("::").append(this._documentTypeCode)
/* 167 */       .append("::").append(String.valueOf(this._inventoryDocumentLineNumber))
/* 168 */       .append("::").append(String.valueOf(this._organizationId))
/* 169 */       .append("::").append(String.valueOf(this._retailLocationId))
/* 170 */       .append("::").append(String.valueOf(this._serialLineNumber))
/* 171 */       .toString();
/*     */   }
/*     */   
/*     */   public boolean validate() {
/* 175 */     if (this._documentId == null) {
/* 176 */       return false;
/*     */     }
/* 178 */     if (this._documentTypeCode == null) {
/* 179 */       return false;
/*     */     }
/* 181 */     if (this._inventoryDocumentLineNumber == null) {
/* 182 */       return false;
/*     */     }
/* 184 */     if (this._retailLocationId == null) {
/* 185 */       return false;
/*     */     }
/* 187 */     if (this._serialLineNumber == null) {
/* 188 */       return false;
/*     */     }
/* 190 */     return true;
/*     */   }
/*     */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\inv\InventoryDocumentLineSerialId.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */