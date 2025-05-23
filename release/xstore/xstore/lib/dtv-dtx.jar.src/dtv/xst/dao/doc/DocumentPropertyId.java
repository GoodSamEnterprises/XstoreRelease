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
/*     */ public class DocumentPropertyId
/*     */   extends AbstractObjectId
/*     */ {
/*     */   private static final long serialVersionUID = 799018032L;
/*     */   private String _documentId;
/*     */   private String _documentType;
/*     */   private String _seriesId;
/*     */   private String _propertyCode;
/*     */   
/*     */   public DocumentPropertyId() {}
/*     */   
/*     */   public DocumentPropertyId(String argObjectIdValue) {
/*  23 */     setValue(argObjectIdValue);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getDocumentId() {
/*  32 */     return this._documentId;
/*     */   }
/*     */   
/*     */   public void setDocumentId(String argDocumentId) {
/*  36 */     this._documentId = (argDocumentId != null && MANAGE_CASE) ? argDocumentId.toUpperCase() : argDocumentId;
/*     */   }
/*     */   
/*     */   public String getDocumentType() {
/*  40 */     return this._documentType;
/*     */   }
/*     */   
/*     */   public void setDocumentType(String argDocumentType) {
/*  44 */     this._documentType = (argDocumentType != null && MANAGE_CASE) ? argDocumentType.toUpperCase() : argDocumentType;
/*     */   }
/*     */   
/*     */   public String getSeriesId() {
/*  48 */     return this._seriesId;
/*     */   }
/*     */   
/*     */   public void setSeriesId(String argSeriesId) {
/*  52 */     this._seriesId = (argSeriesId != null && MANAGE_CASE) ? argSeriesId.toUpperCase() : argSeriesId;
/*     */   }
/*     */   
/*     */   public String getPropertyCode() {
/*  56 */     return this._propertyCode;
/*     */   }
/*     */   
/*     */   public void setPropertyCode(String argPropertyCode) {
/*  60 */     this._propertyCode = (argPropertyCode != null && MANAGE_CASE) ? argPropertyCode.toUpperCase() : argPropertyCode;
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
/*  72 */       if ("null".equals(str)) {
/*  73 */         setDocumentId((String)null);
/*     */       } else {
/*     */         
/*  76 */         setDocumentId(str);
/*     */       } 
/*  78 */       str = tokens[1];
/*     */       
/*  80 */       setOrganizationId(Long.valueOf(str));
/*  81 */       str = tokens[2];
/*     */       
/*  83 */       if ("null".equals(str)) {
/*  84 */         setDocumentType((String)null);
/*     */       } else {
/*     */         
/*  87 */         setDocumentType(str);
/*     */       } 
/*  89 */       str = tokens[3];
/*     */       
/*  91 */       if ("null".equals(str)) {
/*  92 */         setSeriesId((String)null);
/*     */       } else {
/*     */         
/*  95 */         setSeriesId(str);
/*     */       } 
/*  97 */       str = tokens[4];
/*     */       
/*  99 */       if ("null".equals(str)) {
/* 100 */         setPropertyCode((String)null);
/*     */       } else {
/*     */         
/* 103 */         setPropertyCode(str);
/*     */       }
/*     */     
/* 106 */     } catch (Exception ee) {
/* 107 */       throw new DtxException("An exception occured while parsing object id string: " + argObjectIdValue, ee);
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean equals(Object ob) {
/* 113 */     if (this == ob) {
/* 114 */       return true;
/*     */     }
/* 116 */     if (!(ob instanceof DocumentPropertyId)) {
/* 117 */       return false;
/*     */     }
/* 119 */     DocumentPropertyId other = (DocumentPropertyId)ob;
/* 120 */     return (((this._documentId == null && other._documentId == null) || (this._documentId != null && this._documentId
/*     */ 
/*     */       
/* 123 */       .equals(other._documentId))) && ((this._organizationId == null && other._organizationId == null) || (this._organizationId != null && this._organizationId
/*     */ 
/*     */       
/* 126 */       .equals(other._organizationId))) && ((this._documentType == null && other._documentType == null) || (this._documentType != null && this._documentType
/*     */ 
/*     */       
/* 129 */       .equals(other._documentType))) && ((this._seriesId == null && other._seriesId == null) || (this._seriesId != null && this._seriesId
/*     */ 
/*     */       
/* 132 */       .equals(other._seriesId))) && ((this._propertyCode == null && other._propertyCode == null) || (this._propertyCode != null && this._propertyCode
/*     */ 
/*     */       
/* 135 */       .equals(other._propertyCode))));
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public int hashCode() {
/* 141 */     return ((this._documentId == null) ? 0 : this._documentId
/* 142 */       .hashCode()) + ((this._organizationId == null) ? 0 : this._organizationId
/* 143 */       .hashCode()) + ((this._documentType == null) ? 0 : this._documentType
/* 144 */       .hashCode()) + ((this._seriesId == null) ? 0 : this._seriesId
/* 145 */       .hashCode()) + ((this._propertyCode == null) ? 0 : this._propertyCode
/* 146 */       .hashCode());
/*     */   }
/*     */ 
/*     */   
/*     */   public String getDtxTypeName() {
/* 151 */     return "DocumentProperty";
/*     */   }
/*     */ 
/*     */   
/*     */   public String toString() {
/* 156 */     StringBuilder buff = new StringBuilder(60);
/*     */     
/* 158 */     return buff.append(this._documentId)
/*     */       
/* 160 */       .append("::").append(String.valueOf(this._organizationId))
/* 161 */       .append("::").append(this._documentType)
/* 162 */       .append("::").append(this._seriesId)
/* 163 */       .append("::").append(this._propertyCode)
/* 164 */       .toString();
/*     */   }
/*     */   
/*     */   public boolean validate() {
/* 168 */     if (this._documentId == null) {
/* 169 */       return false;
/*     */     }
/* 171 */     if (this._documentType == null) {
/* 172 */       return false;
/*     */     }
/* 174 */     if (this._seriesId == null) {
/* 175 */       return false;
/*     */     }
/* 177 */     if (this._propertyCode == null) {
/* 178 */       return false;
/*     */     }
/* 180 */     return true;
/*     */   }
/*     */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\doc\DocumentPropertyId.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */