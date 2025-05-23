/*     */ package dtv.xst.dao.prc;
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
/*     */ public class DealDocumentXrefId
/*     */   extends AbstractObjectId
/*     */ {
/*     */   private static final long serialVersionUID = 1151195010L;
/*     */   private String _dealId;
/*     */   private String _seriesId;
/*     */   private String _documentType;
/*     */   
/*     */   public DealDocumentXrefId() {}
/*     */   
/*     */   public DealDocumentXrefId(String argObjectIdValue) {
/*  23 */     setValue(argObjectIdValue);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getDealId() {
/*  31 */     return this._dealId;
/*     */   }
/*     */   
/*     */   public void setDealId(String argDealId) {
/*  35 */     this._dealId = (argDealId != null && MANAGE_CASE) ? argDealId.toUpperCase() : argDealId;
/*     */   }
/*     */   
/*     */   public String getSeriesId() {
/*  39 */     return this._seriesId;
/*     */   }
/*     */   
/*     */   public void setSeriesId(String argSeriesId) {
/*  43 */     this._seriesId = (argSeriesId != null && MANAGE_CASE) ? argSeriesId.toUpperCase() : argSeriesId;
/*     */   }
/*     */   
/*     */   public String getDocumentType() {
/*  47 */     return this._documentType;
/*     */   }
/*     */   
/*     */   public void setDocumentType(String argDocumentType) {
/*  51 */     this._documentType = (argDocumentType != null && MANAGE_CASE) ? argDocumentType.toUpperCase() : argDocumentType;
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
/*  63 */       setOrganizationId(Long.valueOf(str));
/*  64 */       str = tokens[1];
/*     */       
/*  66 */       if ("null".equals(str)) {
/*  67 */         setDealId((String)null);
/*     */       } else {
/*     */         
/*  70 */         setDealId(str);
/*     */       } 
/*  72 */       str = tokens[2];
/*     */       
/*  74 */       if ("null".equals(str)) {
/*  75 */         setSeriesId((String)null);
/*     */       } else {
/*     */         
/*  78 */         setSeriesId(str);
/*     */       } 
/*  80 */       str = tokens[3];
/*     */       
/*  82 */       if ("null".equals(str)) {
/*  83 */         setDocumentType((String)null);
/*     */       } else {
/*     */         
/*  86 */         setDocumentType(str);
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
/*  99 */     if (!(ob instanceof DealDocumentXrefId)) {
/* 100 */       return false;
/*     */     }
/* 102 */     DealDocumentXrefId other = (DealDocumentXrefId)ob;
/* 103 */     return (((this._organizationId == null && other._organizationId == null) || (this._organizationId != null && this._organizationId
/*     */ 
/*     */       
/* 106 */       .equals(other._organizationId))) && ((this._dealId == null && other._dealId == null) || (this._dealId != null && this._dealId
/*     */ 
/*     */       
/* 109 */       .equals(other._dealId))) && ((this._seriesId == null && other._seriesId == null) || (this._seriesId != null && this._seriesId
/*     */ 
/*     */       
/* 112 */       .equals(other._seriesId))) && ((this._documentType == null && other._documentType == null) || (this._documentType != null && this._documentType
/*     */ 
/*     */       
/* 115 */       .equals(other._documentType))));
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public int hashCode() {
/* 121 */     return ((this._organizationId == null) ? 0 : this._organizationId
/* 122 */       .hashCode()) + ((this._dealId == null) ? 0 : this._dealId
/* 123 */       .hashCode()) + ((this._seriesId == null) ? 0 : this._seriesId
/* 124 */       .hashCode()) + ((this._documentType == null) ? 0 : this._documentType
/* 125 */       .hashCode());
/*     */   }
/*     */ 
/*     */   
/*     */   public String getDtxTypeName() {
/* 130 */     return "DealDocumentXref";
/*     */   }
/*     */ 
/*     */   
/*     */   public String toString() {
/* 135 */     StringBuilder buff = new StringBuilder(48);
/*     */     
/* 137 */     return buff.append(
/* 138 */         String.valueOf(this._organizationId))
/* 139 */       .append("::").append(this._dealId)
/* 140 */       .append("::").append(this._seriesId)
/* 141 */       .append("::").append(this._documentType)
/* 142 */       .toString();
/*     */   }
/*     */   
/*     */   public boolean validate() {
/* 146 */     if (this._dealId == null) {
/* 147 */       return false;
/*     */     }
/* 149 */     if (this._seriesId == null) {
/* 150 */       return false;
/*     */     }
/* 152 */     if (this._documentType == null) {
/* 153 */       return false;
/*     */     }
/* 155 */     return true;
/*     */   }
/*     */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\prc\DealDocumentXrefId.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */