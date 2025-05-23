/*     */ package dtv.xst.dao.inv;
/*     */ 
/*     */ import dtv.data2.access.AbstractObjectId;
/*     */ import dtv.data2.access.exception.DtxException;
/*     */ import dtv.util.StringUtils;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class CartonPropertyId
/*     */   extends AbstractObjectId
/*     */ {
/*     */   private static final long serialVersionUID = -883564524L;
/*     */   private String _documentId;
/*     */   private String _documentTypeCode;
/*     */   private String _cartonId;
/*     */   private Long _retailLocationId;
/*     */   private String _propertyCode;
/*     */   
/*     */   public CartonPropertyId() {}
/*     */   
/*     */   public CartonPropertyId(String argObjectIdValue) {
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
/*     */   public String getDocumentTypeCode() {
/*  41 */     return this._documentTypeCode;
/*     */   }
/*     */   
/*     */   public void setDocumentTypeCode(String argDocumentTypeCode) {
/*  45 */     this._documentTypeCode = (argDocumentTypeCode != null && MANAGE_CASE) ? argDocumentTypeCode.toUpperCase() : argDocumentTypeCode;
/*     */   }
/*     */   
/*     */   public String getCartonId() {
/*  49 */     return this._cartonId;
/*     */   }
/*     */   
/*     */   public void setCartonId(String argCartonId) {
/*  53 */     this._cartonId = (argCartonId != null && MANAGE_CASE) ? argCartonId.toUpperCase() : argCartonId;
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
/*  81 */       if ("null".equals(str)) {
/*  82 */         setDocumentId((String)null);
/*     */       } else {
/*     */         
/*  85 */         setDocumentId(str);
/*     */       } 
/*  87 */       str = tokens[1];
/*     */       
/*  89 */       if ("null".equals(str)) {
/*  90 */         setDocumentTypeCode((String)null);
/*     */       } else {
/*     */         
/*  93 */         setDocumentTypeCode(str);
/*     */       } 
/*  95 */       str = tokens[2];
/*     */       
/*  97 */       if ("null".equals(str)) {
/*  98 */         setCartonId((String)null);
/*     */       } else {
/*     */         
/* 101 */         setCartonId(str);
/*     */       } 
/* 103 */       str = tokens[3];
/*     */       
/* 105 */       setOrganizationId(Long.valueOf(str));
/* 106 */       str = tokens[4];
/*     */       
/* 108 */       setRetailLocationId(Long.valueOf(str));
/* 109 */       str = tokens[5];
/*     */       
/* 111 */       if ("null".equals(str)) {
/* 112 */         setPropertyCode((String)null);
/*     */       } else {
/*     */         
/* 115 */         setPropertyCode(str);
/*     */       }
/*     */     
/* 118 */     } catch (Exception ee) {
/* 119 */       throw new DtxException("An exception occured while parsing object id string: " + argObjectIdValue, ee);
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean equals(Object ob) {
/* 125 */     if (this == ob) {
/* 126 */       return true;
/*     */     }
/* 128 */     if (!(ob instanceof CartonPropertyId)) {
/* 129 */       return false;
/*     */     }
/* 131 */     CartonPropertyId other = (CartonPropertyId)ob;
/* 132 */     return (((this._documentId == null && other._documentId == null) || (this._documentId != null && this._documentId
/*     */ 
/*     */       
/* 135 */       .equals(other._documentId))) && ((this._documentTypeCode == null && other._documentTypeCode == null) || (this._documentTypeCode != null && this._documentTypeCode
/*     */ 
/*     */       
/* 138 */       .equals(other._documentTypeCode))) && ((this._cartonId == null && other._cartonId == null) || (this._cartonId != null && this._cartonId
/*     */ 
/*     */       
/* 141 */       .equals(other._cartonId))) && ((this._organizationId == null && other._organizationId == null) || (this._organizationId != null && this._organizationId
/*     */ 
/*     */       
/* 144 */       .equals(other._organizationId))) && ((this._retailLocationId == null && other._retailLocationId == null) || (this._retailLocationId != null && this._retailLocationId
/*     */ 
/*     */       
/* 147 */       .equals(other._retailLocationId))) && ((this._propertyCode == null && other._propertyCode == null) || (this._propertyCode != null && this._propertyCode
/*     */ 
/*     */       
/* 150 */       .equals(other._propertyCode))));
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public int hashCode() {
/* 156 */     return ((this._documentId == null) ? 0 : this._documentId
/* 157 */       .hashCode()) + ((this._documentTypeCode == null) ? 0 : this._documentTypeCode
/* 158 */       .hashCode()) + ((this._cartonId == null) ? 0 : this._cartonId
/* 159 */       .hashCode()) + ((this._organizationId == null) ? 0 : this._organizationId
/* 160 */       .hashCode()) + ((this._retailLocationId == null) ? 0 : this._retailLocationId
/* 161 */       .hashCode()) + ((this._propertyCode == null) ? 0 : this._propertyCode
/* 162 */       .hashCode());
/*     */   }
/*     */ 
/*     */   
/*     */   public String getDtxTypeName() {
/* 167 */     return "CartonProperty";
/*     */   }
/*     */ 
/*     */   
/*     */   public String toString() {
/* 172 */     StringBuilder buff = new StringBuilder(72);
/*     */     
/* 174 */     return buff.append(this._documentId)
/*     */       
/* 176 */       .append("::").append(this._documentTypeCode)
/* 177 */       .append("::").append(this._cartonId)
/* 178 */       .append("::").append(String.valueOf(this._organizationId))
/* 179 */       .append("::").append(String.valueOf(this._retailLocationId))
/* 180 */       .append("::").append(this._propertyCode)
/* 181 */       .toString();
/*     */   }
/*     */   
/*     */   public boolean validate() {
/* 185 */     if (this._documentId == null) {
/* 186 */       return false;
/*     */     }
/* 188 */     if (this._documentTypeCode == null) {
/* 189 */       return false;
/*     */     }
/* 191 */     if (this._cartonId == null) {
/* 192 */       return false;
/*     */     }
/* 194 */     if (this._retailLocationId == null) {
/* 195 */       return false;
/*     */     }
/* 197 */     if (this._propertyCode == null) {
/* 198 */       return false;
/*     */     }
/* 200 */     return true;
/*     */   }
/*     */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\inv\CartonPropertyId.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */