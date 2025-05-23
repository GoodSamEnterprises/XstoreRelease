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
/*     */ public class PrivilegePropertyId
/*     */   extends AbstractObjectId
/*     */ {
/*     */   private static final long serialVersionUID = 23213958L;
/*     */   private String _privilegeType;
/*     */   private String _propertyCode;
/*     */   
/*     */   public PrivilegePropertyId() {}
/*     */   
/*     */   public PrivilegePropertyId(String argObjectIdValue) {
/*  23 */     setValue(argObjectIdValue);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getPrivilegeType() {
/*  30 */     return this._privilegeType;
/*     */   }
/*     */   
/*     */   public void setPrivilegeType(String argPrivilegeType) {
/*  34 */     this._privilegeType = (argPrivilegeType != null && MANAGE_CASE) ? argPrivilegeType.toUpperCase() : argPrivilegeType;
/*     */   }
/*     */   
/*     */   public String getPropertyCode() {
/*  38 */     return this._propertyCode;
/*     */   }
/*     */   
/*     */   public void setPropertyCode(String argPropertyCode) {
/*  42 */     this._propertyCode = (argPropertyCode != null && MANAGE_CASE) ? argPropertyCode.toUpperCase() : argPropertyCode;
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
/*  54 */       setOrganizationId(Long.valueOf(str));
/*  55 */       str = tokens[1];
/*     */       
/*  57 */       if ("null".equals(str)) {
/*  58 */         setPrivilegeType((String)null);
/*     */       } else {
/*     */         
/*  61 */         setPrivilegeType(str);
/*     */       } 
/*  63 */       str = tokens[2];
/*     */       
/*  65 */       if ("null".equals(str)) {
/*  66 */         setPropertyCode((String)null);
/*     */       } else {
/*     */         
/*  69 */         setPropertyCode(str);
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
/*  82 */     if (!(ob instanceof PrivilegePropertyId)) {
/*  83 */       return false;
/*     */     }
/*  85 */     PrivilegePropertyId other = (PrivilegePropertyId)ob;
/*  86 */     return (((this._organizationId == null && other._organizationId == null) || (this._organizationId != null && this._organizationId
/*     */ 
/*     */       
/*  89 */       .equals(other._organizationId))) && ((this._privilegeType == null && other._privilegeType == null) || (this._privilegeType != null && this._privilegeType
/*     */ 
/*     */       
/*  92 */       .equals(other._privilegeType))) && ((this._propertyCode == null && other._propertyCode == null) || (this._propertyCode != null && this._propertyCode
/*     */ 
/*     */       
/*  95 */       .equals(other._propertyCode))));
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public int hashCode() {
/* 101 */     return ((this._organizationId == null) ? 0 : this._organizationId
/* 102 */       .hashCode()) + ((this._privilegeType == null) ? 0 : this._privilegeType
/* 103 */       .hashCode()) + ((this._propertyCode == null) ? 0 : this._propertyCode
/* 104 */       .hashCode());
/*     */   }
/*     */ 
/*     */   
/*     */   public String getDtxTypeName() {
/* 109 */     return "PrivilegeProperty";
/*     */   }
/*     */ 
/*     */   
/*     */   public String toString() {
/* 114 */     StringBuilder buff = new StringBuilder(36);
/*     */     
/* 116 */     return buff.append(
/* 117 */         String.valueOf(this._organizationId))
/* 118 */       .append("::").append(this._privilegeType)
/* 119 */       .append("::").append(this._propertyCode)
/* 120 */       .toString();
/*     */   }
/*     */   
/*     */   public boolean validate() {
/* 124 */     if (this._privilegeType == null) {
/* 125 */       return false;
/*     */     }
/* 127 */     if (this._propertyCode == null) {
/* 128 */       return false;
/*     */     }
/* 130 */     return true;
/*     */   }
/*     */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\sec\PrivilegePropertyId.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */