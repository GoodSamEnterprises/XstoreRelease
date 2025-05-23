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
/*     */ 
/*     */ public class ReportLookupId
/*     */   extends AbstractObjectId
/*     */ {
/*     */   private static final long serialVersionUID = 562595822L;
/*     */   private String _ownerId;
/*     */   private String _ownerType;
/*     */   private String _reportId;
/*     */   
/*     */   public ReportLookupId() {}
/*     */   
/*     */   public ReportLookupId(String argObjectIdValue) {
/*  23 */     setValue(argObjectIdValue);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getOwnerId() {
/*  31 */     return this._ownerId;
/*     */   }
/*     */   
/*     */   public void setOwnerId(String argOwnerId) {
/*  35 */     this._ownerId = (argOwnerId != null && MANAGE_CASE) ? argOwnerId.toUpperCase() : argOwnerId;
/*     */   }
/*     */   
/*     */   public String getOwnerType() {
/*  39 */     return this._ownerType;
/*     */   }
/*     */   
/*     */   public void setOwnerType(String argOwnerType) {
/*  43 */     this._ownerType = (argOwnerType != null && MANAGE_CASE) ? argOwnerType.toUpperCase() : argOwnerType;
/*     */   }
/*     */   
/*     */   public String getReportId() {
/*  47 */     return this._reportId;
/*     */   }
/*     */   
/*     */   public void setReportId(String argReportId) {
/*  51 */     this._reportId = (argReportId != null && MANAGE_CASE) ? argReportId.toUpperCase() : argReportId;
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
/*  67 */         setOwnerId((String)null);
/*     */       } else {
/*     */         
/*  70 */         setOwnerId(str);
/*     */       } 
/*  72 */       str = tokens[2];
/*     */       
/*  74 */       if ("null".equals(str)) {
/*  75 */         setOwnerType((String)null);
/*     */       } else {
/*     */         
/*  78 */         setOwnerType(str);
/*     */       } 
/*  80 */       str = tokens[3];
/*     */       
/*  82 */       if ("null".equals(str)) {
/*  83 */         setReportId((String)null);
/*     */       } else {
/*     */         
/*  86 */         setReportId(str);
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
/*  99 */     if (!(ob instanceof ReportLookupId)) {
/* 100 */       return false;
/*     */     }
/* 102 */     ReportLookupId other = (ReportLookupId)ob;
/* 103 */     return (((this._organizationId == null && other._organizationId == null) || (this._organizationId != null && this._organizationId
/*     */ 
/*     */       
/* 106 */       .equals(other._organizationId))) && ((this._ownerId == null && other._ownerId == null) || (this._ownerId != null && this._ownerId
/*     */ 
/*     */       
/* 109 */       .equals(other._ownerId))) && ((this._ownerType == null && other._ownerType == null) || (this._ownerType != null && this._ownerType
/*     */ 
/*     */       
/* 112 */       .equals(other._ownerType))) && ((this._reportId == null && other._reportId == null) || (this._reportId != null && this._reportId
/*     */ 
/*     */       
/* 115 */       .equals(other._reportId))));
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public int hashCode() {
/* 121 */     return ((this._organizationId == null) ? 0 : this._organizationId
/* 122 */       .hashCode()) + ((this._ownerId == null) ? 0 : this._ownerId
/* 123 */       .hashCode()) + ((this._ownerType == null) ? 0 : this._ownerType
/* 124 */       .hashCode()) + ((this._reportId == null) ? 0 : this._reportId
/* 125 */       .hashCode());
/*     */   }
/*     */ 
/*     */   
/*     */   public String getDtxTypeName() {
/* 130 */     return "ReportLookup";
/*     */   }
/*     */ 
/*     */   
/*     */   public String toString() {
/* 135 */     StringBuilder buff = new StringBuilder(48);
/*     */     
/* 137 */     return buff.append(
/* 138 */         String.valueOf(this._organizationId))
/* 139 */       .append("::").append(this._ownerId)
/* 140 */       .append("::").append(this._ownerType)
/* 141 */       .append("::").append(this._reportId)
/* 142 */       .toString();
/*     */   }
/*     */   
/*     */   public boolean validate() {
/* 146 */     if (this._ownerId == null) {
/* 147 */       return false;
/*     */     }
/* 149 */     if (this._ownerType == null) {
/* 150 */       return false;
/*     */     }
/* 152 */     if (this._reportId == null) {
/* 153 */       return false;
/*     */     }
/* 155 */     return true;
/*     */   }
/*     */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\com\ReportLookupId.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */