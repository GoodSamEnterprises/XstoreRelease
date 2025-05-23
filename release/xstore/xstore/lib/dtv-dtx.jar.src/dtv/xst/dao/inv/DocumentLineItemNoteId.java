/*     */ package dtv.xst.dao.inv;
/*     */ 
/*     */ import dtv.data2.access.AbstractObjectId;
/*     */ import dtv.data2.access.exception.DtxException;
/*     */ import dtv.util.StringUtils;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class DocumentLineItemNoteId
/*     */   extends AbstractObjectId
/*     */ {
/*     */   private static final long serialVersionUID = 1348617876L;
/*     */   private Long _retailLocationId;
/*     */   private String _documentId;
/*     */   private String _documentTypeCode;
/*     */   private Integer _inventoryDocumentLineNumber;
/*     */   private Long _noteId;
/*     */   
/*     */   public DocumentLineItemNoteId() {}
/*     */   
/*     */   public DocumentLineItemNoteId(String argObjectIdValue) {
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
/*     */   public String getDocumentId() {
/*  41 */     return this._documentId;
/*     */   }
/*     */   
/*     */   public void setDocumentId(String argDocumentId) {
/*  45 */     this._documentId = (argDocumentId != null && MANAGE_CASE) ? argDocumentId.toUpperCase() : argDocumentId;
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
/*     */   public Integer getInventoryDocumentLineNumber() {
/*  57 */     return this._inventoryDocumentLineNumber;
/*     */   }
/*     */   
/*     */   public void setInventoryDocumentLineNumber(Integer argInventoryDocumentLineNumber) {
/*  61 */     this._inventoryDocumentLineNumber = argInventoryDocumentLineNumber;
/*     */   }
/*     */   
/*     */   public Long getNoteId() {
/*  65 */     return this._noteId;
/*     */   }
/*     */   
/*     */   public void setNoteId(Long argNoteId) {
/*  69 */     this._noteId = argNoteId;
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
/*  88 */         setDocumentId((String)null);
/*     */       } else {
/*     */         
/*  91 */         setDocumentId(str);
/*     */       } 
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
/* 103 */       setInventoryDocumentLineNumber(Integer.valueOf(str));
/* 104 */       str = tokens[5];
/*     */       
/* 106 */       setNoteId(Long.valueOf(str));
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
/* 118 */     if (!(ob instanceof DocumentLineItemNoteId)) {
/* 119 */       return false;
/*     */     }
/* 121 */     DocumentLineItemNoteId other = (DocumentLineItemNoteId)ob;
/* 122 */     return (((this._organizationId == null && other._organizationId == null) || (this._organizationId != null && this._organizationId
/*     */ 
/*     */       
/* 125 */       .equals(other._organizationId))) && ((this._retailLocationId == null && other._retailLocationId == null) || (this._retailLocationId != null && this._retailLocationId
/*     */ 
/*     */       
/* 128 */       .equals(other._retailLocationId))) && ((this._documentId == null && other._documentId == null) || (this._documentId != null && this._documentId
/*     */ 
/*     */       
/* 131 */       .equals(other._documentId))) && ((this._documentTypeCode == null && other._documentTypeCode == null) || (this._documentTypeCode != null && this._documentTypeCode
/*     */ 
/*     */       
/* 134 */       .equals(other._documentTypeCode))) && ((this._inventoryDocumentLineNumber == null && other._inventoryDocumentLineNumber == null) || (this._inventoryDocumentLineNumber != null && this._inventoryDocumentLineNumber
/*     */ 
/*     */       
/* 137 */       .equals(other._inventoryDocumentLineNumber))) && ((this._noteId == null && other._noteId == null) || (this._noteId != null && this._noteId
/*     */ 
/*     */       
/* 140 */       .equals(other._noteId))));
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public int hashCode() {
/* 146 */     return ((this._organizationId == null) ? 0 : this._organizationId
/* 147 */       .hashCode()) + ((this._retailLocationId == null) ? 0 : this._retailLocationId
/* 148 */       .hashCode()) + ((this._documentId == null) ? 0 : this._documentId
/* 149 */       .hashCode()) + ((this._documentTypeCode == null) ? 0 : this._documentTypeCode
/* 150 */       .hashCode()) + ((this._inventoryDocumentLineNumber == null) ? 0 : this._inventoryDocumentLineNumber
/* 151 */       .hashCode()) + ((this._noteId == null) ? 0 : this._noteId
/* 152 */       .hashCode());
/*     */   }
/*     */ 
/*     */   
/*     */   public String getDtxTypeName() {
/* 157 */     return "DocumentLineItemNote";
/*     */   }
/*     */ 
/*     */   
/*     */   public String toString() {
/* 162 */     StringBuilder buff = new StringBuilder(72);
/*     */     
/* 164 */     return buff.append(
/* 165 */         String.valueOf(this._organizationId))
/* 166 */       .append("::").append(String.valueOf(this._retailLocationId))
/* 167 */       .append("::").append(this._documentId)
/* 168 */       .append("::").append(this._documentTypeCode)
/* 169 */       .append("::").append(String.valueOf(this._inventoryDocumentLineNumber))
/* 170 */       .append("::").append(String.valueOf(this._noteId))
/* 171 */       .toString();
/*     */   }
/*     */   
/*     */   public boolean validate() {
/* 175 */     if (this._retailLocationId == null) {
/* 176 */       return false;
/*     */     }
/* 178 */     if (this._documentId == null) {
/* 179 */       return false;
/*     */     }
/* 181 */     if (this._documentTypeCode == null) {
/* 182 */       return false;
/*     */     }
/* 184 */     if (this._inventoryDocumentLineNumber == null) {
/* 185 */       return false;
/*     */     }
/* 187 */     if (this._noteId == null) {
/* 188 */       return false;
/*     */     }
/* 190 */     return true;
/*     */   }
/*     */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\inv\DocumentLineItemNoteId.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */