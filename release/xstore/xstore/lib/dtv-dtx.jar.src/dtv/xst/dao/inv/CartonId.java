/*     */ package dtv.xst.dao.inv;
/*     */ 
/*     */ import dtv.data2.access.AbstractObjectId;
/*     */ import dtv.data2.access.exception.DtxException;
/*     */ import dtv.util.StringUtils;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class CartonId
/*     */   extends AbstractObjectId
/*     */ {
/*     */   private static final long serialVersionUID = 2011245855L;
/*     */   private String _documentId;
/*     */   private String _documentTypeCode;
/*     */   private String _cartonId;
/*     */   private Long _retailLocationId;
/*     */   
/*     */   public CartonId() {}
/*     */   
/*     */   public CartonId(String argObjectIdValue) {
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
/*     */   public String getDocumentTypeCode() {
/*  40 */     return this._documentTypeCode;
/*     */   }
/*     */   
/*     */   public void setDocumentTypeCode(String argDocumentTypeCode) {
/*  44 */     this._documentTypeCode = (argDocumentTypeCode != null && MANAGE_CASE) ? argDocumentTypeCode.toUpperCase() : argDocumentTypeCode;
/*     */   }
/*     */   
/*     */   public String getCartonId() {
/*  48 */     return this._cartonId;
/*     */   }
/*     */   
/*     */   public void setCartonId(String argCartonId) {
/*  52 */     this._cartonId = (argCartonId != null && MANAGE_CASE) ? argCartonId.toUpperCase() : argCartonId;
/*     */   }
/*     */   
/*     */   public Long getRetailLocationId() {
/*  56 */     return this._retailLocationId;
/*     */   }
/*     */   
/*     */   public void setRetailLocationId(Long argRetailLocationId) {
/*  60 */     this._retailLocationId = argRetailLocationId;
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
/*  80 */       if ("null".equals(str)) {
/*  81 */         setDocumentTypeCode((String)null);
/*     */       } else {
/*     */         
/*  84 */         setDocumentTypeCode(str);
/*     */       } 
/*  86 */       str = tokens[2];
/*     */       
/*  88 */       if ("null".equals(str)) {
/*  89 */         setCartonId((String)null);
/*     */       } else {
/*     */         
/*  92 */         setCartonId(str);
/*     */       } 
/*  94 */       str = tokens[3];
/*     */       
/*  96 */       setOrganizationId(Long.valueOf(str));
/*  97 */       str = tokens[4];
/*     */       
/*  99 */       setRetailLocationId(Long.valueOf(str));
/*     */     }
/* 101 */     catch (Exception ee) {
/* 102 */       throw new DtxException("An exception occured while parsing object id string: " + argObjectIdValue, ee);
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean equals(Object ob) {
/* 108 */     if (this == ob) {
/* 109 */       return true;
/*     */     }
/* 111 */     if (!(ob instanceof CartonId)) {
/* 112 */       return false;
/*     */     }
/* 114 */     CartonId other = (CartonId)ob;
/* 115 */     return (((this._documentId == null && other._documentId == null) || (this._documentId != null && this._documentId
/*     */ 
/*     */       
/* 118 */       .equals(other._documentId))) && ((this._documentTypeCode == null && other._documentTypeCode == null) || (this._documentTypeCode != null && this._documentTypeCode
/*     */ 
/*     */       
/* 121 */       .equals(other._documentTypeCode))) && ((this._cartonId == null && other._cartonId == null) || (this._cartonId != null && this._cartonId
/*     */ 
/*     */       
/* 124 */       .equals(other._cartonId))) && ((this._organizationId == null && other._organizationId == null) || (this._organizationId != null && this._organizationId
/*     */ 
/*     */       
/* 127 */       .equals(other._organizationId))) && ((this._retailLocationId == null && other._retailLocationId == null) || (this._retailLocationId != null && this._retailLocationId
/*     */ 
/*     */       
/* 130 */       .equals(other._retailLocationId))));
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public int hashCode() {
/* 136 */     return ((this._documentId == null) ? 0 : this._documentId
/* 137 */       .hashCode()) + ((this._documentTypeCode == null) ? 0 : this._documentTypeCode
/* 138 */       .hashCode()) + ((this._cartonId == null) ? 0 : this._cartonId
/* 139 */       .hashCode()) + ((this._organizationId == null) ? 0 : this._organizationId
/* 140 */       .hashCode()) + ((this._retailLocationId == null) ? 0 : this._retailLocationId
/* 141 */       .hashCode());
/*     */   }
/*     */ 
/*     */   
/*     */   public String getDtxTypeName() {
/* 146 */     return "Carton";
/*     */   }
/*     */ 
/*     */   
/*     */   public String toString() {
/* 151 */     StringBuilder buff = new StringBuilder(60);
/*     */     
/* 153 */     return buff.append(this._documentId)
/*     */       
/* 155 */       .append("::").append(this._documentTypeCode)
/* 156 */       .append("::").append(this._cartonId)
/* 157 */       .append("::").append(String.valueOf(this._organizationId))
/* 158 */       .append("::").append(String.valueOf(this._retailLocationId))
/* 159 */       .toString();
/*     */   }
/*     */   
/*     */   public boolean validate() {
/* 163 */     if (this._documentId == null) {
/* 164 */       return false;
/*     */     }
/* 166 */     if (this._documentTypeCode == null) {
/* 167 */       return false;
/*     */     }
/* 169 */     if (this._cartonId == null) {
/* 170 */       return false;
/*     */     }
/* 172 */     if (this._retailLocationId == null) {
/* 173 */       return false;
/*     */     }
/* 175 */     return true;
/*     */   }
/*     */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\inv\CartonId.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */