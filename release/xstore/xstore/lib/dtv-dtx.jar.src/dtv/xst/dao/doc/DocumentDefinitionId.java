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
/*     */ 
/*     */ public class DocumentDefinitionId
/*     */   extends AbstractObjectId
/*     */ {
/*     */   private static final long serialVersionUID = -1031194386L;
/*     */   private String _seriesId;
/*     */   private String _documentType;
/*     */   
/*     */   public DocumentDefinitionId() {}
/*     */   
/*     */   public DocumentDefinitionId(String argObjectIdValue) {
/*  23 */     setValue(argObjectIdValue);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getSeriesId() {
/*  30 */     return this._seriesId;
/*     */   }
/*     */   
/*     */   public void setSeriesId(String argSeriesId) {
/*  34 */     this._seriesId = (argSeriesId != null && MANAGE_CASE) ? argSeriesId.toUpperCase() : argSeriesId;
/*     */   }
/*     */   
/*     */   public String getDocumentType() {
/*  38 */     return this._documentType;
/*     */   }
/*     */   
/*     */   public void setDocumentType(String argDocumentType) {
/*  42 */     this._documentType = (argDocumentType != null && MANAGE_CASE) ? argDocumentType.toUpperCase() : argDocumentType;
/*     */   }
/*     */   
/*     */   public void setValue(String argObjectIdValue) {
/*  46 */     String str = argObjectIdValue;
/*  47 */     if (StringUtils.isEmpty(str)) {
/*  48 */       throw new DtxException("argument passed to setValue() is null or empty - a valid value must be passed");
/*     */     }
/*     */     try {
/*  51 */       String[] tokens = str.split("::");
/*  52 */       str = tokens[0];
/*     */       
/*  54 */       if ("null".equals(str)) {
/*  55 */         setSeriesId((String)null);
/*     */       } else {
/*     */         
/*  58 */         setSeriesId(str);
/*     */       } 
/*  60 */       str = tokens[1];
/*     */       
/*  62 */       setOrganizationId(Long.valueOf(str));
/*  63 */       str = tokens[2];
/*     */       
/*  65 */       if ("null".equals(str)) {
/*  66 */         setDocumentType((String)null);
/*     */       } else {
/*     */         
/*  69 */         setDocumentType(str);
/*     */       }
/*     */     
/*  72 */     } catch (Exception ee) {
/*  73 */       throw new DtxException("An exception occured while parsing object id string: " + argObjectIdValue, ee);
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean equals(Object ob) {
/*  79 */     if (this == ob) {
/*  80 */       return true;
/*     */     }
/*  82 */     if (!(ob instanceof DocumentDefinitionId)) {
/*  83 */       return false;
/*     */     }
/*  85 */     DocumentDefinitionId other = (DocumentDefinitionId)ob;
/*  86 */     return (((this._seriesId == null && other._seriesId == null) || (this._seriesId != null && this._seriesId
/*     */ 
/*     */       
/*  89 */       .equals(other._seriesId))) && ((this._organizationId == null && other._organizationId == null) || (this._organizationId != null && this._organizationId
/*     */ 
/*     */       
/*  92 */       .equals(other._organizationId))) && ((this._documentType == null && other._documentType == null) || (this._documentType != null && this._documentType
/*     */ 
/*     */       
/*  95 */       .equals(other._documentType))));
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public int hashCode() {
/* 101 */     return ((this._seriesId == null) ? 0 : this._seriesId
/* 102 */       .hashCode()) + ((this._organizationId == null) ? 0 : this._organizationId
/* 103 */       .hashCode()) + ((this._documentType == null) ? 0 : this._documentType
/* 104 */       .hashCode());
/*     */   }
/*     */ 
/*     */   
/*     */   public String getDtxTypeName() {
/* 109 */     return "DocumentDefinition";
/*     */   }
/*     */ 
/*     */   
/*     */   public String toString() {
/* 114 */     StringBuilder buff = new StringBuilder(36);
/*     */     
/* 116 */     return buff.append(this._seriesId)
/*     */       
/* 118 */       .append("::").append(String.valueOf(this._organizationId))
/* 119 */       .append("::").append(this._documentType)
/* 120 */       .toString();
/*     */   }
/*     */   
/*     */   public boolean validate() {
/* 124 */     if (this._seriesId == null) {
/* 125 */       return false;
/*     */     }
/* 127 */     if (this._documentType == null) {
/* 128 */       return false;
/*     */     }
/* 130 */     return true;
/*     */   }
/*     */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\doc\DocumentDefinitionId.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */