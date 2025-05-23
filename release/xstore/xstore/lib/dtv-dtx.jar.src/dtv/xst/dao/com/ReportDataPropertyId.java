/*     */ package dtv.xst.dao.com;
/*     */ 
/*     */ import dtv.data2.access.AbstractObjectId;
/*     */ import dtv.data2.access.exception.DtxException;
/*     */ import dtv.util.StringUtils;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class ReportDataPropertyId
/*     */   extends AbstractObjectId
/*     */ {
/*     */   private static final long serialVersionUID = 898309907L;
/*     */   private String _ownerId;
/*     */   private String _ownerType;
/*     */   private String _reportId;
/*     */   private String _propertyCode;
/*     */   
/*     */   public ReportDataPropertyId() {}
/*     */   
/*     */   public ReportDataPropertyId(String argObjectIdValue) {
/*  23 */     setValue(argObjectIdValue);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getOwnerId() {
/*  32 */     return this._ownerId;
/*     */   }
/*     */   
/*     */   public void setOwnerId(String argOwnerId) {
/*  36 */     this._ownerId = (argOwnerId != null && MANAGE_CASE) ? argOwnerId.toUpperCase() : argOwnerId;
/*     */   }
/*     */   
/*     */   public String getOwnerType() {
/*  40 */     return this._ownerType;
/*     */   }
/*     */   
/*     */   public void setOwnerType(String argOwnerType) {
/*  44 */     this._ownerType = (argOwnerType != null && MANAGE_CASE) ? argOwnerType.toUpperCase() : argOwnerType;
/*     */   }
/*     */   
/*     */   public String getReportId() {
/*  48 */     return this._reportId;
/*     */   }
/*     */   
/*     */   public void setReportId(String argReportId) {
/*  52 */     this._reportId = (argReportId != null && MANAGE_CASE) ? argReportId.toUpperCase() : argReportId;
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
/*  72 */       setOrganizationId(Long.valueOf(str));
/*  73 */       str = tokens[1];
/*     */       
/*  75 */       if ("null".equals(str)) {
/*  76 */         setOwnerId((String)null);
/*     */       } else {
/*     */         
/*  79 */         setOwnerId(str);
/*     */       } 
/*  81 */       str = tokens[2];
/*     */       
/*  83 */       if ("null".equals(str)) {
/*  84 */         setOwnerType((String)null);
/*     */       } else {
/*     */         
/*  87 */         setOwnerType(str);
/*     */       } 
/*  89 */       str = tokens[3];
/*     */       
/*  91 */       if ("null".equals(str)) {
/*  92 */         setReportId((String)null);
/*     */       } else {
/*     */         
/*  95 */         setReportId(str);
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
/* 116 */     if (!(ob instanceof ReportDataPropertyId)) {
/* 117 */       return false;
/*     */     }
/* 119 */     ReportDataPropertyId other = (ReportDataPropertyId)ob;
/* 120 */     return (((this._organizationId == null && other._organizationId == null) || (this._organizationId != null && this._organizationId
/*     */ 
/*     */       
/* 123 */       .equals(other._organizationId))) && ((this._ownerId == null && other._ownerId == null) || (this._ownerId != null && this._ownerId
/*     */ 
/*     */       
/* 126 */       .equals(other._ownerId))) && ((this._ownerType == null && other._ownerType == null) || (this._ownerType != null && this._ownerType
/*     */ 
/*     */       
/* 129 */       .equals(other._ownerType))) && ((this._reportId == null && other._reportId == null) || (this._reportId != null && this._reportId
/*     */ 
/*     */       
/* 132 */       .equals(other._reportId))) && ((this._propertyCode == null && other._propertyCode == null) || (this._propertyCode != null && this._propertyCode
/*     */ 
/*     */       
/* 135 */       .equals(other._propertyCode))));
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public int hashCode() {
/* 141 */     return ((this._organizationId == null) ? 0 : this._organizationId
/* 142 */       .hashCode()) + ((this._ownerId == null) ? 0 : this._ownerId
/* 143 */       .hashCode()) + ((this._ownerType == null) ? 0 : this._ownerType
/* 144 */       .hashCode()) + ((this._reportId == null) ? 0 : this._reportId
/* 145 */       .hashCode()) + ((this._propertyCode == null) ? 0 : this._propertyCode
/* 146 */       .hashCode());
/*     */   }
/*     */ 
/*     */   
/*     */   public String getDtxTypeName() {
/* 151 */     return "ReportDataProperty";
/*     */   }
/*     */ 
/*     */   
/*     */   public String toString() {
/* 156 */     StringBuilder buff = new StringBuilder(60);
/*     */     
/* 158 */     return buff.append(
/* 159 */         String.valueOf(this._organizationId))
/* 160 */       .append("::").append(this._ownerId)
/* 161 */       .append("::").append(this._ownerType)
/* 162 */       .append("::").append(this._reportId)
/* 163 */       .append("::").append(this._propertyCode)
/* 164 */       .toString();
/*     */   }
/*     */   
/*     */   public boolean validate() {
/* 168 */     if (this._ownerId == null) {
/* 169 */       return false;
/*     */     }
/* 171 */     if (this._ownerType == null) {
/* 172 */       return false;
/*     */     }
/* 174 */     if (this._reportId == null) {
/* 175 */       return false;
/*     */     }
/* 177 */     if (this._propertyCode == null) {
/* 178 */       return false;
/*     */     }
/* 180 */     return true;
/*     */   }
/*     */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\com\ReportDataPropertyId.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */