/*     */ package dtv.xst.dao.doc;
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
/*     */ public class DocumentId
/*     */   extends AbstractObjectId
/*     */ {
/*     */   private static final long serialVersionUID = 926364987L;
/*     */   private String _documentId;
/*     */   private String _documentType;
/*     */   private String _seriesId;
/*     */   
/*     */   public DocumentId() {}
/*     */   
/*     */   public DocumentId(String argObjectIdValue) {
/*  23 */     setValue(argObjectIdValue);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getDocumentId() {
/*  31 */     return this._documentId;
/*     */   }
/*     */   
/*     */   public void setDocumentId(String argDocumentId) {
/*  35 */     this._documentId = (argDocumentId != null && MANAGE_CASE) ? argDocumentId.toUpperCase() : argDocumentId;
/*     */   }
/*     */   
/*     */   public String getDocumentType() {
/*  39 */     return this._documentType;
/*     */   }
/*     */   
/*     */   public void setDocumentType(String argDocumentType) {
/*  43 */     this._documentType = (argDocumentType != null && MANAGE_CASE) ? argDocumentType.toUpperCase() : argDocumentType;
/*     */   }
/*     */   
/*     */   public String getSeriesId() {
/*  47 */     return this._seriesId;
/*     */   }
/*     */   
/*     */   public void setSeriesId(String argSeriesId) {
/*  51 */     this._seriesId = (argSeriesId != null && MANAGE_CASE) ? argSeriesId.toUpperCase() : argSeriesId;
/*     */   }
/*     */   
/*     */   public void setValue(String argObjectIdValue) {
/*  55 */     String str = argObjectIdValue;
/*  56 */     if (StringUtils.isEmpty(str)) {
/*  57 */       throw new DtxException("argument passed to setValue() is null or empty - a valid value must be passed");
/*     */     }
/*     */     try {
/*  60 */       String[] tokens = str.split("::");
/*  61 */       str = tokens[0];
/*     */       
/*  63 */       if ("null".equals(str)) {
/*  64 */         setDocumentId((String)null);
/*     */       } else {
/*     */         
/*  67 */         setDocumentId(str);
/*     */       } 
/*  69 */       str = tokens[1];
/*     */       
/*  71 */       setOrganizationId(Long.valueOf(str));
/*  72 */       str = tokens[2];
/*     */       
/*  74 */       if ("null".equals(str)) {
/*  75 */         setDocumentType((String)null);
/*     */       } else {
/*     */         
/*  78 */         setDocumentType(str);
/*     */       } 
/*  80 */       str = tokens[3];
/*     */       
/*  82 */       if ("null".equals(str)) {
/*  83 */         setSeriesId((String)null);
/*     */       } else {
/*     */         
/*  86 */         setSeriesId(str);
/*     */       }
/*     */     
/*  89 */     } catch (Exception ee) {
/*  90 */       throw new DtxException("An exception occured while parsing object id string: " + argObjectIdValue, ee);
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean equals(Object ob) {
/*  96 */     if (this == ob) {
/*  97 */       return true;
/*     */     }
/*  99 */     if (!(ob instanceof DocumentId)) {
/* 100 */       return false;
/*     */     }
/* 102 */     DocumentId other = (DocumentId)ob;
/* 103 */     return (((this._documentId == null && other._documentId == null) || (this._documentId != null && this._documentId
/*     */ 
/*     */       
/* 106 */       .equals(other._documentId))) && ((this._organizationId == null && other._organizationId == null) || (this._organizationId != null && this._organizationId
/*     */ 
/*     */       
/* 109 */       .equals(other._organizationId))) && ((this._documentType == null && other._documentType == null) || (this._documentType != null && this._documentType
/*     */ 
/*     */       
/* 112 */       .equals(other._documentType))) && ((this._seriesId == null && other._seriesId == null) || (this._seriesId != null && this._seriesId
/*     */ 
/*     */       
/* 115 */       .equals(other._seriesId))));
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public int hashCode() {
/* 121 */     return ((this._documentId == null) ? 0 : this._documentId
/* 122 */       .hashCode()) + ((this._organizationId == null) ? 0 : this._organizationId
/* 123 */       .hashCode()) + ((this._documentType == null) ? 0 : this._documentType
/* 124 */       .hashCode()) + ((this._seriesId == null) ? 0 : this._seriesId
/* 125 */       .hashCode());
/*     */   }
/*     */ 
/*     */   
/*     */   public String getDtxTypeName() {
/* 130 */     return "Document";
/*     */   }
/*     */ 
/*     */   
/*     */   public String toString() {
/* 135 */     StringBuilder buff = new StringBuilder(48);
/*     */     
/* 137 */     return buff.append(this._documentId)
/*     */       
/* 139 */       .append("::").append(String.valueOf(this._organizationId))
/* 140 */       .append("::").append(this._documentType)
/* 141 */       .append("::").append(this._seriesId)
/* 142 */       .toString();
/*     */   }
/*     */   
/*     */   public boolean validate() {
/* 146 */     if (this._documentId == null) {
/* 147 */       return false;
/*     */     }
/* 149 */     if (this._documentType == null) {
/* 150 */       return false;
/*     */     }
/* 152 */     if (this._seriesId == null) {
/* 153 */       return false;
/*     */     }
/* 155 */     return true;
/*     */   }
/*     */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\doc\DocumentId.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */