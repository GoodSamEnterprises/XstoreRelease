/*     */ package dtv.xst.dao.inv;
/*     */ 
/*     */ import dtv.data2.access.AbstractObjectId;
/*     */ import dtv.data2.access.exception.DtxException;
/*     */ import dtv.util.StringUtils;
/*     */ 
/*     */ 
/*     */ 
/*     */ public class DocumentLineItemNotePropertyId
/*     */   extends AbstractObjectId
/*     */ {
/*     */   private static final long serialVersionUID = 83145865L;
/*     */   private Long _retailLocationId;
/*     */   private String _documentId;
/*     */   private String _documentTypeCode;
/*     */   private Integer _inventoryDocumentLineNumber;
/*     */   private Long _noteId;
/*     */   private String _propertyCode;
/*     */   
/*     */   public DocumentLineItemNotePropertyId() {}
/*     */   
/*     */   public DocumentLineItemNotePropertyId(String argObjectIdValue) {
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
/*     */   public String getDocumentId() {
/*  42 */     return this._documentId;
/*     */   }
/*     */   
/*     */   public void setDocumentId(String argDocumentId) {
/*  46 */     this._documentId = (argDocumentId != null && MANAGE_CASE) ? argDocumentId.toUpperCase() : argDocumentId;
/*     */   }
/*     */   
/*     */   public String getDocumentTypeCode() {
/*  50 */     return this._documentTypeCode;
/*     */   }
/*     */   
/*     */   public void setDocumentTypeCode(String argDocumentTypeCode) {
/*  54 */     this._documentTypeCode = (argDocumentTypeCode != null && MANAGE_CASE) ? argDocumentTypeCode.toUpperCase() : argDocumentTypeCode;
/*     */   }
/*     */   
/*     */   public Integer getInventoryDocumentLineNumber() {
/*  58 */     return this._inventoryDocumentLineNumber;
/*     */   }
/*     */   
/*     */   public void setInventoryDocumentLineNumber(Integer argInventoryDocumentLineNumber) {
/*  62 */     this._inventoryDocumentLineNumber = argInventoryDocumentLineNumber;
/*     */   }
/*     */   
/*     */   public Long getNoteId() {
/*  66 */     return this._noteId;
/*     */   }
/*     */   
/*     */   public void setNoteId(Long argNoteId) {
/*  70 */     this._noteId = argNoteId;
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
/*  97 */         setDocumentId((String)null);
/*     */       } else {
/*     */         
/* 100 */         setDocumentId(str);
/*     */       } 
/* 102 */       str = tokens[3];
/*     */       
/* 104 */       if ("null".equals(str)) {
/* 105 */         setDocumentTypeCode((String)null);
/*     */       } else {
/*     */         
/* 108 */         setDocumentTypeCode(str);
/*     */       } 
/* 110 */       str = tokens[4];
/*     */       
/* 112 */       setInventoryDocumentLineNumber(Integer.valueOf(str));
/* 113 */       str = tokens[5];
/*     */       
/* 115 */       setNoteId(Long.valueOf(str));
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
/* 135 */     if (!(ob instanceof DocumentLineItemNotePropertyId)) {
/* 136 */       return false;
/*     */     }
/* 138 */     DocumentLineItemNotePropertyId other = (DocumentLineItemNotePropertyId)ob;
/* 139 */     return (((this._organizationId == null && other._organizationId == null) || (this._organizationId != null && this._organizationId
/*     */ 
/*     */       
/* 142 */       .equals(other._organizationId))) && ((this._retailLocationId == null && other._retailLocationId == null) || (this._retailLocationId != null && this._retailLocationId
/*     */ 
/*     */       
/* 145 */       .equals(other._retailLocationId))) && ((this._documentId == null && other._documentId == null) || (this._documentId != null && this._documentId
/*     */ 
/*     */       
/* 148 */       .equals(other._documentId))) && ((this._documentTypeCode == null && other._documentTypeCode == null) || (this._documentTypeCode != null && this._documentTypeCode
/*     */ 
/*     */       
/* 151 */       .equals(other._documentTypeCode))) && ((this._inventoryDocumentLineNumber == null && other._inventoryDocumentLineNumber == null) || (this._inventoryDocumentLineNumber != null && this._inventoryDocumentLineNumber
/*     */ 
/*     */       
/* 154 */       .equals(other._inventoryDocumentLineNumber))) && ((this._noteId == null && other._noteId == null) || (this._noteId != null && this._noteId
/*     */ 
/*     */       
/* 157 */       .equals(other._noteId))) && ((this._propertyCode == null && other._propertyCode == null) || (this._propertyCode != null && this._propertyCode
/*     */ 
/*     */       
/* 160 */       .equals(other._propertyCode))));
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public int hashCode() {
/* 166 */     return ((this._organizationId == null) ? 0 : this._organizationId
/* 167 */       .hashCode()) + ((this._retailLocationId == null) ? 0 : this._retailLocationId
/* 168 */       .hashCode()) + ((this._documentId == null) ? 0 : this._documentId
/* 169 */       .hashCode()) + ((this._documentTypeCode == null) ? 0 : this._documentTypeCode
/* 170 */       .hashCode()) + ((this._inventoryDocumentLineNumber == null) ? 0 : this._inventoryDocumentLineNumber
/* 171 */       .hashCode()) + ((this._noteId == null) ? 0 : this._noteId
/* 172 */       .hashCode()) + ((this._propertyCode == null) ? 0 : this._propertyCode
/* 173 */       .hashCode());
/*     */   }
/*     */ 
/*     */   
/*     */   public String getDtxTypeName() {
/* 178 */     return "DocumentLineItemNoteProperty";
/*     */   }
/*     */ 
/*     */   
/*     */   public String toString() {
/* 183 */     StringBuilder buff = new StringBuilder(84);
/*     */     
/* 185 */     return buff.append(
/* 186 */         String.valueOf(this._organizationId))
/* 187 */       .append("::").append(String.valueOf(this._retailLocationId))
/* 188 */       .append("::").append(this._documentId)
/* 189 */       .append("::").append(this._documentTypeCode)
/* 190 */       .append("::").append(String.valueOf(this._inventoryDocumentLineNumber))
/* 191 */       .append("::").append(String.valueOf(this._noteId))
/* 192 */       .append("::").append(this._propertyCode)
/* 193 */       .toString();
/*     */   }
/*     */   
/*     */   public boolean validate() {
/* 197 */     if (this._retailLocationId == null) {
/* 198 */       return false;
/*     */     }
/* 200 */     if (this._documentId == null) {
/* 201 */       return false;
/*     */     }
/* 203 */     if (this._documentTypeCode == null) {
/* 204 */       return false;
/*     */     }
/* 206 */     if (this._inventoryDocumentLineNumber == null) {
/* 207 */       return false;
/*     */     }
/* 209 */     if (this._noteId == null) {
/* 210 */       return false;
/*     */     }
/* 212 */     if (this._propertyCode == null) {
/* 213 */       return false;
/*     */     }
/* 215 */     return true;
/*     */   }
/*     */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\inv\DocumentLineItemNotePropertyId.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */