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
/*     */ 
/*     */ public class AclAccessTypeId
/*     */   extends AbstractObjectId
/*     */ {
/*     */   private static final long serialVersionUID = -1942796600L;
/*     */   private String _accessTypeCode;
/*     */   private String _securedObjectId;
/*     */   
/*     */   public AclAccessTypeId() {}
/*     */   
/*     */   public AclAccessTypeId(String argObjectIdValue) {
/*  23 */     setValue(argObjectIdValue);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getAccessTypeCode() {
/*  30 */     return this._accessTypeCode;
/*     */   }
/*     */   
/*     */   public void setAccessTypeCode(String argAccessTypeCode) {
/*  34 */     this._accessTypeCode = (argAccessTypeCode != null && MANAGE_CASE) ? argAccessTypeCode.toUpperCase() : argAccessTypeCode;
/*     */   }
/*     */   
/*     */   public String getSecuredObjectId() {
/*  38 */     return this._securedObjectId;
/*     */   }
/*     */   
/*     */   public void setSecuredObjectId(String argSecuredObjectId) {
/*  42 */     this._securedObjectId = (argSecuredObjectId != null && MANAGE_CASE) ? argSecuredObjectId.toUpperCase() : argSecuredObjectId;
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
/*  55 */         setAccessTypeCode((String)null);
/*     */       } else {
/*     */         
/*  58 */         setAccessTypeCode(str);
/*     */       } 
/*  60 */       str = tokens[1];
/*     */       
/*  62 */       setOrganizationId(Long.valueOf(str));
/*  63 */       str = tokens[2];
/*     */       
/*  65 */       if ("null".equals(str)) {
/*  66 */         setSecuredObjectId((String)null);
/*     */       } else {
/*     */         
/*  69 */         setSecuredObjectId(str);
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
/*  82 */     if (!(ob instanceof AclAccessTypeId)) {
/*  83 */       return false;
/*     */     }
/*  85 */     AclAccessTypeId other = (AclAccessTypeId)ob;
/*  86 */     return (((this._accessTypeCode == null && other._accessTypeCode == null) || (this._accessTypeCode != null && this._accessTypeCode
/*     */ 
/*     */       
/*  89 */       .equals(other._accessTypeCode))) && ((this._organizationId == null && other._organizationId == null) || (this._organizationId != null && this._organizationId
/*     */ 
/*     */       
/*  92 */       .equals(other._organizationId))) && ((this._securedObjectId == null && other._securedObjectId == null) || (this._securedObjectId != null && this._securedObjectId
/*     */ 
/*     */       
/*  95 */       .equals(other._securedObjectId))));
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public int hashCode() {
/* 101 */     return ((this._accessTypeCode == null) ? 0 : this._accessTypeCode
/* 102 */       .hashCode()) + ((this._organizationId == null) ? 0 : this._organizationId
/* 103 */       .hashCode()) + ((this._securedObjectId == null) ? 0 : this._securedObjectId
/* 104 */       .hashCode());
/*     */   }
/*     */ 
/*     */   
/*     */   public String getDtxTypeName() {
/* 109 */     return "AclAccessType";
/*     */   }
/*     */ 
/*     */   
/*     */   public String toString() {
/* 114 */     StringBuilder buff = new StringBuilder(36);
/*     */     
/* 116 */     return buff.append(this._accessTypeCode)
/*     */       
/* 118 */       .append("::").append(String.valueOf(this._organizationId))
/* 119 */       .append("::").append(this._securedObjectId)
/* 120 */       .toString();
/*     */   }
/*     */   
/*     */   public boolean validate() {
/* 124 */     if (this._accessTypeCode == null) {
/* 125 */       return false;
/*     */     }
/* 127 */     if (this._securedObjectId == null) {
/* 128 */       return false;
/*     */     }
/* 130 */     return true;
/*     */   }
/*     */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\sec\AclAccessTypeId.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */