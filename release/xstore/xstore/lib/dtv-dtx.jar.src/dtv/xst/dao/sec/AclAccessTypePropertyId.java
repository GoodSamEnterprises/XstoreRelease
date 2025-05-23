/*     */ package dtv.xst.dao.sec;
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
/*     */ public class AclAccessTypePropertyId
/*     */   extends AbstractObjectId
/*     */ {
/*     */   private static final long serialVersionUID = -39042883L;
/*     */   private String _accessTypeCode;
/*     */   private String _securedObjectId;
/*     */   private String _propertyCode;
/*     */   
/*     */   public AclAccessTypePropertyId() {}
/*     */   
/*     */   public AclAccessTypePropertyId(String argObjectIdValue) {
/*  23 */     setValue(argObjectIdValue);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getAccessTypeCode() {
/*  31 */     return this._accessTypeCode;
/*     */   }
/*     */   
/*     */   public void setAccessTypeCode(String argAccessTypeCode) {
/*  35 */     this._accessTypeCode = (argAccessTypeCode != null && MANAGE_CASE) ? argAccessTypeCode.toUpperCase() : argAccessTypeCode;
/*     */   }
/*     */   
/*     */   public String getSecuredObjectId() {
/*  39 */     return this._securedObjectId;
/*     */   }
/*     */   
/*     */   public void setSecuredObjectId(String argSecuredObjectId) {
/*  43 */     this._securedObjectId = (argSecuredObjectId != null && MANAGE_CASE) ? argSecuredObjectId.toUpperCase() : argSecuredObjectId;
/*     */   }
/*     */   
/*     */   public String getPropertyCode() {
/*  47 */     return this._propertyCode;
/*     */   }
/*     */   
/*     */   public void setPropertyCode(String argPropertyCode) {
/*  51 */     this._propertyCode = (argPropertyCode != null && MANAGE_CASE) ? argPropertyCode.toUpperCase() : argPropertyCode;
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
/*  64 */         setAccessTypeCode((String)null);
/*     */       } else {
/*     */         
/*  67 */         setAccessTypeCode(str);
/*     */       } 
/*  69 */       str = tokens[1];
/*     */       
/*  71 */       setOrganizationId(Long.valueOf(str));
/*  72 */       str = tokens[2];
/*     */       
/*  74 */       if ("null".equals(str)) {
/*  75 */         setSecuredObjectId((String)null);
/*     */       } else {
/*     */         
/*  78 */         setSecuredObjectId(str);
/*     */       } 
/*  80 */       str = tokens[3];
/*     */       
/*  82 */       if ("null".equals(str)) {
/*  83 */         setPropertyCode((String)null);
/*     */       } else {
/*     */         
/*  86 */         setPropertyCode(str);
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
/*  99 */     if (!(ob instanceof AclAccessTypePropertyId)) {
/* 100 */       return false;
/*     */     }
/* 102 */     AclAccessTypePropertyId other = (AclAccessTypePropertyId)ob;
/* 103 */     return (((this._accessTypeCode == null && other._accessTypeCode == null) || (this._accessTypeCode != null && this._accessTypeCode
/*     */ 
/*     */       
/* 106 */       .equals(other._accessTypeCode))) && ((this._organizationId == null && other._organizationId == null) || (this._organizationId != null && this._organizationId
/*     */ 
/*     */       
/* 109 */       .equals(other._organizationId))) && ((this._securedObjectId == null && other._securedObjectId == null) || (this._securedObjectId != null && this._securedObjectId
/*     */ 
/*     */       
/* 112 */       .equals(other._securedObjectId))) && ((this._propertyCode == null && other._propertyCode == null) || (this._propertyCode != null && this._propertyCode
/*     */ 
/*     */       
/* 115 */       .equals(other._propertyCode))));
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public int hashCode() {
/* 121 */     return ((this._accessTypeCode == null) ? 0 : this._accessTypeCode
/* 122 */       .hashCode()) + ((this._organizationId == null) ? 0 : this._organizationId
/* 123 */       .hashCode()) + ((this._securedObjectId == null) ? 0 : this._securedObjectId
/* 124 */       .hashCode()) + ((this._propertyCode == null) ? 0 : this._propertyCode
/* 125 */       .hashCode());
/*     */   }
/*     */ 
/*     */   
/*     */   public String getDtxTypeName() {
/* 130 */     return "AclAccessTypeProperty";
/*     */   }
/*     */ 
/*     */   
/*     */   public String toString() {
/* 135 */     StringBuilder buff = new StringBuilder(48);
/*     */     
/* 137 */     return buff.append(this._accessTypeCode)
/*     */       
/* 139 */       .append("::").append(String.valueOf(this._organizationId))
/* 140 */       .append("::").append(this._securedObjectId)
/* 141 */       .append("::").append(this._propertyCode)
/* 142 */       .toString();
/*     */   }
/*     */   
/*     */   public boolean validate() {
/* 146 */     if (this._accessTypeCode == null) {
/* 147 */       return false;
/*     */     }
/* 149 */     if (this._securedObjectId == null) {
/* 150 */       return false;
/*     */     }
/* 152 */     if (this._propertyCode == null) {
/* 153 */       return false;
/*     */     }
/* 155 */     return true;
/*     */   }
/*     */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\sec\AclAccessTypePropertyId.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */