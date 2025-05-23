/*     */ package dtv.xst.dao.inv;
/*     */ 
/*     */ import dtv.data2.access.AbstractObjectId;
/*     */ import dtv.data2.access.exception.DtxException;
/*     */ import dtv.util.StringUtils;
/*     */ 
/*     */ 
/*     */ 
/*     */ public class InventoryDocumentLineSerialPropertyId
/*     */   extends AbstractObjectId
/*     */ {
/*     */   private static final long serialVersionUID = -1974686764L;
/*     */   private String _documentId;
/*     */   private String _documentTypeCode;
/*     */   private Integer _inventoryDocumentLineNumber;
/*     */   private Long _retailLocationId;
/*     */   private Integer _serialLineNumber;
/*     */   private String _propertyCode;
/*     */   
/*     */   public InventoryDocumentLineSerialPropertyId() {}
/*     */   
/*     */   public InventoryDocumentLineSerialPropertyId(String argObjectIdValue) {
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
/*     */   public String getDocumentId() {
/*  34 */     return this._documentId;
/*     */   }
/*     */   
/*     */   public void setDocumentId(String argDocumentId) {
/*  38 */     this._documentId = (argDocumentId != null && MANAGE_CASE) ? argDocumentId.toUpperCase() : argDocumentId;
/*     */   }
/*     */   
/*     */   public String getDocumentTypeCode() {
/*  42 */     return this._documentTypeCode;
/*     */   }
/*     */   
/*     */   public void setDocumentTypeCode(String argDocumentTypeCode) {
/*  46 */     this._documentTypeCode = (argDocumentTypeCode != null && MANAGE_CASE) ? argDocumentTypeCode.toUpperCase() : argDocumentTypeCode;
/*     */   }
/*     */   
/*     */   public Integer getInventoryDocumentLineNumber() {
/*  50 */     return this._inventoryDocumentLineNumber;
/*     */   }
/*     */   
/*     */   public void setInventoryDocumentLineNumber(Integer argInventoryDocumentLineNumber) {
/*  54 */     this._inventoryDocumentLineNumber = argInventoryDocumentLineNumber;
/*     */   }
/*     */   
/*     */   public Long getRetailLocationId() {
/*  58 */     return this._retailLocationId;
/*     */   }
/*     */   
/*     */   public void setRetailLocationId(Long argRetailLocationId) {
/*  62 */     this._retailLocationId = argRetailLocationId;
/*     */   }
/*     */   
/*     */   public Integer getSerialLineNumber() {
/*  66 */     return this._serialLineNumber;
/*     */   }
/*     */   
/*     */   public void setSerialLineNumber(Integer argSerialLineNumber) {
/*  70 */     this._serialLineNumber = argSerialLineNumber;
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
/*  90 */       if ("null".equals(str)) {
/*  91 */         setDocumentId((String)null);
/*     */       } else {
/*     */         
/*  94 */         setDocumentId(str);
/*     */       } 
/*  96 */       str = tokens[1];
/*     */       
/*  98 */       if ("null".equals(str)) {
/*  99 */         setDocumentTypeCode((String)null);
/*     */       } else {
/*     */         
/* 102 */         setDocumentTypeCode(str);
/*     */       } 
/* 104 */       str = tokens[2];
/*     */       
/* 106 */       setInventoryDocumentLineNumber(Integer.valueOf(str));
/* 107 */       str = tokens[3];
/*     */       
/* 109 */       setOrganizationId(Long.valueOf(str));
/* 110 */       str = tokens[4];
/*     */       
/* 112 */       setRetailLocationId(Long.valueOf(str));
/* 113 */       str = tokens[5];
/*     */       
/* 115 */       setSerialLineNumber(Integer.valueOf(str));
/* 116 */       str = tokens[6];
/*     */       
/* 118 */       if ("null".equals(str)) {
/* 119 */         setPropertyCode((String)null);
/*     */       } else {
/*     */         
/* 122 */         setPropertyCode(str);
/*     */       }
/*     */     
/* 125 */     } catch (Exception ee) {
/* 126 */       throw new DtxException("An exception occured while parsing object id string: " + argObjectIdValue, ee);
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean equals(Object ob) {
/* 132 */     if (this == ob) {
/* 133 */       return true;
/*     */     }
/* 135 */     if (!(ob instanceof InventoryDocumentLineSerialPropertyId)) {
/* 136 */       return false;
/*     */     }
/* 138 */     InventoryDocumentLineSerialPropertyId other = (InventoryDocumentLineSerialPropertyId)ob;
/* 139 */     return (((this._documentId == null && other._documentId == null) || (this._documentId != null && this._documentId
/*     */ 
/*     */       
/* 142 */       .equals(other._documentId))) && ((this._documentTypeCode == null && other._documentTypeCode == null) || (this._documentTypeCode != null && this._documentTypeCode
/*     */ 
/*     */       
/* 145 */       .equals(other._documentTypeCode))) && ((this._inventoryDocumentLineNumber == null && other._inventoryDocumentLineNumber == null) || (this._inventoryDocumentLineNumber != null && this._inventoryDocumentLineNumber
/*     */ 
/*     */       
/* 148 */       .equals(other._inventoryDocumentLineNumber))) && ((this._organizationId == null && other._organizationId == null) || (this._organizationId != null && this._organizationId
/*     */ 
/*     */       
/* 151 */       .equals(other._organizationId))) && ((this._retailLocationId == null && other._retailLocationId == null) || (this._retailLocationId != null && this._retailLocationId
/*     */ 
/*     */       
/* 154 */       .equals(other._retailLocationId))) && ((this._serialLineNumber == null && other._serialLineNumber == null) || (this._serialLineNumber != null && this._serialLineNumber
/*     */ 
/*     */       
/* 157 */       .equals(other._serialLineNumber))) && ((this._propertyCode == null && other._propertyCode == null) || (this._propertyCode != null && this._propertyCode
/*     */ 
/*     */       
/* 160 */       .equals(other._propertyCode))));
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public int hashCode() {
/* 166 */     return ((this._documentId == null) ? 0 : this._documentId
/* 167 */       .hashCode()) + ((this._documentTypeCode == null) ? 0 : this._documentTypeCode
/* 168 */       .hashCode()) + ((this._inventoryDocumentLineNumber == null) ? 0 : this._inventoryDocumentLineNumber
/* 169 */       .hashCode()) + ((this._organizationId == null) ? 0 : this._organizationId
/* 170 */       .hashCode()) + ((this._retailLocationId == null) ? 0 : this._retailLocationId
/* 171 */       .hashCode()) + ((this._serialLineNumber == null) ? 0 : this._serialLineNumber
/* 172 */       .hashCode()) + ((this._propertyCode == null) ? 0 : this._propertyCode
/* 173 */       .hashCode());
/*     */   }
/*     */ 
/*     */   
/*     */   public String getDtxTypeName() {
/* 178 */     return "InventoryDocumentLineSerialProperty";
/*     */   }
/*     */ 
/*     */   
/*     */   public String toString() {
/* 183 */     StringBuilder buff = new StringBuilder(84);
/*     */     
/* 185 */     return buff.append(this._documentId)
/*     */       
/* 187 */       .append("::").append(this._documentTypeCode)
/* 188 */       .append("::").append(String.valueOf(this._inventoryDocumentLineNumber))
/* 189 */       .append("::").append(String.valueOf(this._organizationId))
/* 190 */       .append("::").append(String.valueOf(this._retailLocationId))
/* 191 */       .append("::").append(String.valueOf(this._serialLineNumber))
/* 192 */       .append("::").append(this._propertyCode)
/* 193 */       .toString();
/*     */   }
/*     */   
/*     */   public boolean validate() {
/* 197 */     if (this._documentId == null) {
/* 198 */       return false;
/*     */     }
/* 200 */     if (this._documentTypeCode == null) {
/* 201 */       return false;
/*     */     }
/* 203 */     if (this._inventoryDocumentLineNumber == null) {
/* 204 */       return false;
/*     */     }
/* 206 */     if (this._retailLocationId == null) {
/* 207 */       return false;
/*     */     }
/* 209 */     if (this._serialLineNumber == null) {
/* 210 */       return false;
/*     */     }
/* 212 */     if (this._propertyCode == null) {
/* 213 */       return false;
/*     */     }
/* 215 */     return true;
/*     */   }
/*     */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\inv\InventoryDocumentLineSerialPropertyId.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */