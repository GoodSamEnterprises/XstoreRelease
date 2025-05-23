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
/*     */ public class DocumentDefinitionPropertiesId
/*     */   extends AbstractObjectId
/*     */ {
/*     */   private static final long serialVersionUID = -1633627967L;
/*     */   private String _seriesId;
/*     */   private String _documentType;
/*     */   private Long _sequence;
/*     */   
/*     */   public DocumentDefinitionPropertiesId() {}
/*     */   
/*     */   public DocumentDefinitionPropertiesId(String argObjectIdValue) {
/*  23 */     setValue(argObjectIdValue);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getSeriesId() {
/*  31 */     return this._seriesId;
/*     */   }
/*     */   
/*     */   public void setSeriesId(String argSeriesId) {
/*  35 */     this._seriesId = (argSeriesId != null && MANAGE_CASE) ? argSeriesId.toUpperCase() : argSeriesId;
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
/*     */   public Long getSequence() {
/*  47 */     return this._sequence;
/*     */   }
/*     */   
/*     */   public void setSequence(Long argSequence) {
/*  51 */     this._sequence = argSequence;
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
/*  64 */         setSeriesId((String)null);
/*     */       } else {
/*     */         
/*  67 */         setSeriesId(str);
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
/*  82 */       setSequence(Long.valueOf(str));
/*     */     }
/*  84 */     catch (Exception ee) {
/*  85 */       throw new DtxException("An exception occured while parsing object id string: " + argObjectIdValue, ee);
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean equals(Object ob) {
/*  91 */     if (this == ob) {
/*  92 */       return true;
/*     */     }
/*  94 */     if (!(ob instanceof DocumentDefinitionPropertiesId)) {
/*  95 */       return false;
/*     */     }
/*  97 */     DocumentDefinitionPropertiesId other = (DocumentDefinitionPropertiesId)ob;
/*  98 */     return (((this._seriesId == null && other._seriesId == null) || (this._seriesId != null && this._seriesId
/*     */ 
/*     */       
/* 101 */       .equals(other._seriesId))) && ((this._organizationId == null && other._organizationId == null) || (this._organizationId != null && this._organizationId
/*     */ 
/*     */       
/* 104 */       .equals(other._organizationId))) && ((this._documentType == null && other._documentType == null) || (this._documentType != null && this._documentType
/*     */ 
/*     */       
/* 107 */       .equals(other._documentType))) && ((this._sequence == null && other._sequence == null) || (this._sequence != null && this._sequence
/*     */ 
/*     */       
/* 110 */       .equals(other._sequence))));
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public int hashCode() {
/* 116 */     return ((this._seriesId == null) ? 0 : this._seriesId
/* 117 */       .hashCode()) + ((this._organizationId == null) ? 0 : this._organizationId
/* 118 */       .hashCode()) + ((this._documentType == null) ? 0 : this._documentType
/* 119 */       .hashCode()) + ((this._sequence == null) ? 0 : this._sequence
/* 120 */       .hashCode());
/*     */   }
/*     */ 
/*     */   
/*     */   public String getDtxTypeName() {
/* 125 */     return "DocumentDefinitionProperties";
/*     */   }
/*     */ 
/*     */   
/*     */   public String toString() {
/* 130 */     StringBuilder buff = new StringBuilder(48);
/*     */     
/* 132 */     return buff.append(this._seriesId)
/*     */       
/* 134 */       .append("::").append(String.valueOf(this._organizationId))
/* 135 */       .append("::").append(this._documentType)
/* 136 */       .append("::").append(String.valueOf(this._sequence))
/* 137 */       .toString();
/*     */   }
/*     */   
/*     */   public boolean validate() {
/* 141 */     if (this._seriesId == null) {
/* 142 */       return false;
/*     */     }
/* 144 */     if (this._documentType == null) {
/* 145 */       return false;
/*     */     }
/* 147 */     if (this._sequence == null) {
/* 148 */       return false;
/*     */     }
/* 150 */     return true;
/*     */   }
/*     */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\doc\DocumentDefinitionPropertiesId.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */