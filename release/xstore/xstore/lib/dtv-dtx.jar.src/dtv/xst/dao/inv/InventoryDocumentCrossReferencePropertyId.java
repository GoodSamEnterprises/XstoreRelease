/*     */ package dtv.xst.dao.inv;
/*     */ 
/*     */ import dtv.data2.access.AbstractObjectId;
/*     */ import dtv.data2.access.exception.DtxException;
/*     */ import dtv.util.StringUtils;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class InventoryDocumentCrossReferencePropertyId
/*     */   extends AbstractObjectId
/*     */ {
/*     */   private static final long serialVersionUID = -154660553L;
/*     */   private String _documentId;
/*     */   private Integer _inventoryDocumentLineNumber;
/*     */   private String _documentTypeCode;
/*     */   private Long _retailLocationId;
/*     */   private String _propertyCode;
/*     */   
/*     */   public InventoryDocumentCrossReferencePropertyId() {}
/*     */   
/*     */   public InventoryDocumentCrossReferencePropertyId(String argObjectIdValue) {
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
/*     */   public Integer getInventoryDocumentLineNumber() {
/*  41 */     return this._inventoryDocumentLineNumber;
/*     */   }
/*     */   
/*     */   public void setInventoryDocumentLineNumber(Integer argInventoryDocumentLineNumber) {
/*  45 */     this._inventoryDocumentLineNumber = argInventoryDocumentLineNumber;
/*     */   }
/*     */   
/*     */   public String getDocumentTypeCode() {
/*  49 */     return this._documentTypeCode;
/*     */   }
/*     */   
/*     */   public void setDocumentTypeCode(String argDocumentTypeCode) {
/*  53 */     this._documentTypeCode = (argDocumentTypeCode != null && MANAGE_CASE) ? argDocumentTypeCode.toUpperCase() : argDocumentTypeCode;
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
/*     */   public String getPropertyCode() {
/*  65 */     return this._propertyCode;
/*     */   }
/*     */   
/*     */   public void setPropertyCode(String argPropertyCode) {
/*  69 */     this._propertyCode = (argPropertyCode != null && MANAGE_CASE) ? argPropertyCode.toUpperCase() : argPropertyCode;
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
/*  84 */       if ("null".equals(str)) {
/*  85 */         setDocumentId((String)null);
/*     */       } else {
/*     */         
/*  88 */         setDocumentId(str);
/*     */       } 
/*  90 */       str = tokens[2];
/*     */       
/*  92 */       setInventoryDocumentLineNumber(Integer.valueOf(str));
/*  93 */       str = tokens[3];
/*     */       
/*  95 */       if ("null".equals(str)) {
/*  96 */         setDocumentTypeCode((String)null);
/*     */       } else {
/*     */         
/*  99 */         setDocumentTypeCode(str);
/*     */       } 
/* 101 */       str = tokens[4];
/*     */       
/* 103 */       setRetailLocationId(Long.valueOf(str));
/* 104 */       str = tokens[5];
/*     */       
/* 106 */       if ("null".equals(str)) {
/* 107 */         setPropertyCode((String)null);
/*     */       } else {
/*     */         
/* 110 */         setPropertyCode(str);
/*     */       }
/*     */     
/* 113 */     } catch (Exception ee) {
/* 114 */       throw new DtxException("An exception occured while parsing object id string: " + argObjectIdValue, ee);
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean equals(Object ob) {
/* 120 */     if (this == ob) {
/* 121 */       return true;
/*     */     }
/* 123 */     if (!(ob instanceof InventoryDocumentCrossReferencePropertyId)) {
/* 124 */       return false;
/*     */     }
/* 126 */     InventoryDocumentCrossReferencePropertyId other = (InventoryDocumentCrossReferencePropertyId)ob;
/* 127 */     return (((this._organizationId == null && other._organizationId == null) || (this._organizationId != null && this._organizationId
/*     */ 
/*     */       
/* 130 */       .equals(other._organizationId))) && ((this._documentId == null && other._documentId == null) || (this._documentId != null && this._documentId
/*     */ 
/*     */       
/* 133 */       .equals(other._documentId))) && ((this._inventoryDocumentLineNumber == null && other._inventoryDocumentLineNumber == null) || (this._inventoryDocumentLineNumber != null && this._inventoryDocumentLineNumber
/*     */ 
/*     */       
/* 136 */       .equals(other._inventoryDocumentLineNumber))) && ((this._documentTypeCode == null && other._documentTypeCode == null) || (this._documentTypeCode != null && this._documentTypeCode
/*     */ 
/*     */       
/* 139 */       .equals(other._documentTypeCode))) && ((this._retailLocationId == null && other._retailLocationId == null) || (this._retailLocationId != null && this._retailLocationId
/*     */ 
/*     */       
/* 142 */       .equals(other._retailLocationId))) && ((this._propertyCode == null && other._propertyCode == null) || (this._propertyCode != null && this._propertyCode
/*     */ 
/*     */       
/* 145 */       .equals(other._propertyCode))));
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public int hashCode() {
/* 151 */     return ((this._organizationId == null) ? 0 : this._organizationId
/* 152 */       .hashCode()) + ((this._documentId == null) ? 0 : this._documentId
/* 153 */       .hashCode()) + ((this._inventoryDocumentLineNumber == null) ? 0 : this._inventoryDocumentLineNumber
/* 154 */       .hashCode()) + ((this._documentTypeCode == null) ? 0 : this._documentTypeCode
/* 155 */       .hashCode()) + ((this._retailLocationId == null) ? 0 : this._retailLocationId
/* 156 */       .hashCode()) + ((this._propertyCode == null) ? 0 : this._propertyCode
/* 157 */       .hashCode());
/*     */   }
/*     */ 
/*     */   
/*     */   public String getDtxTypeName() {
/* 162 */     return "InventoryDocumentCrossReferenceProperty";
/*     */   }
/*     */ 
/*     */   
/*     */   public String toString() {
/* 167 */     StringBuilder buff = new StringBuilder(72);
/*     */     
/* 169 */     return buff.append(
/* 170 */         String.valueOf(this._organizationId))
/* 171 */       .append("::").append(this._documentId)
/* 172 */       .append("::").append(String.valueOf(this._inventoryDocumentLineNumber))
/* 173 */       .append("::").append(this._documentTypeCode)
/* 174 */       .append("::").append(String.valueOf(this._retailLocationId))
/* 175 */       .append("::").append(this._propertyCode)
/* 176 */       .toString();
/*     */   }
/*     */   
/*     */   public boolean validate() {
/* 180 */     if (this._documentId == null) {
/* 181 */       return false;
/*     */     }
/* 183 */     if (this._inventoryDocumentLineNumber == null) {
/* 184 */       return false;
/*     */     }
/* 186 */     if (this._documentTypeCode == null) {
/* 187 */       return false;
/*     */     }
/* 189 */     if (this._retailLocationId == null) {
/* 190 */       return false;
/*     */     }
/* 192 */     if (this._propertyCode == null) {
/* 193 */       return false;
/*     */     }
/* 195 */     return true;
/*     */   }
/*     */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\inv\InventoryDocumentCrossReferencePropertyId.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */