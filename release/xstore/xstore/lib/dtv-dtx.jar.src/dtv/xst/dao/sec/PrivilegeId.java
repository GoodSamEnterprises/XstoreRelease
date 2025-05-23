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
/*     */ 
/*     */ public class PrivilegeId
/*     */   extends AbstractObjectId
/*     */ {
/*     */   private static final long serialVersionUID = 426579601L;
/*     */   private String _privilegeType;
/*     */   
/*     */   public PrivilegeId() {}
/*     */   
/*     */   public PrivilegeId(String argObjectIdValue) {
/*  23 */     setValue(argObjectIdValue);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public String getPrivilegeType() {
/*  29 */     return this._privilegeType;
/*     */   }
/*     */   
/*     */   public void setPrivilegeType(String argPrivilegeType) {
/*  33 */     this._privilegeType = (argPrivilegeType != null && MANAGE_CASE) ? argPrivilegeType.toUpperCase() : argPrivilegeType;
/*     */   }
/*     */   
/*     */   public void setValue(String argObjectIdValue) {
/*  37 */     String str = argObjectIdValue;
/*  38 */     if (StringUtils.isEmpty(str)) {
/*  39 */       throw new DtxException("argument passed to setValue() is null or empty - a valid value must be passed");
/*     */     }
/*     */     try {
/*  42 */       String[] tokens = str.split("::");
/*  43 */       str = tokens[0];
/*     */       
/*  45 */       setOrganizationId(Long.valueOf(str));
/*  46 */       str = tokens[1];
/*     */       
/*  48 */       if ("null".equals(str)) {
/*  49 */         setPrivilegeType((String)null);
/*     */       } else {
/*     */         
/*  52 */         setPrivilegeType(str);
/*     */       }
/*     */     
/*  55 */     } catch (Exception ee) {
/*  56 */       throw new DtxException("An exception occured while parsing object id string: " + argObjectIdValue, ee);
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean equals(Object ob) {
/*  62 */     if (this == ob) {
/*  63 */       return true;
/*     */     }
/*  65 */     if (!(ob instanceof PrivilegeId)) {
/*  66 */       return false;
/*     */     }
/*  68 */     PrivilegeId other = (PrivilegeId)ob;
/*  69 */     return (((this._organizationId == null && other._organizationId == null) || (this._organizationId != null && this._organizationId
/*     */ 
/*     */       
/*  72 */       .equals(other._organizationId))) && ((this._privilegeType == null && other._privilegeType == null) || (this._privilegeType != null && this._privilegeType
/*     */ 
/*     */       
/*  75 */       .equals(other._privilegeType))));
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public int hashCode() {
/*  81 */     return ((this._organizationId == null) ? 0 : this._organizationId
/*  82 */       .hashCode()) + ((this._privilegeType == null) ? 0 : this._privilegeType
/*  83 */       .hashCode());
/*     */   }
/*     */ 
/*     */   
/*     */   public String getDtxTypeName() {
/*  88 */     return "Privilege";
/*     */   }
/*     */ 
/*     */   
/*     */   public String toString() {
/*  93 */     StringBuilder buff = new StringBuilder(24);
/*     */     
/*  95 */     return buff.append(
/*  96 */         String.valueOf(this._organizationId))
/*  97 */       .append("::").append(this._privilegeType)
/*  98 */       .toString();
/*     */   }
/*     */   
/*     */   public boolean validate() {
/* 102 */     if (this._privilegeType == null) {
/* 103 */       return false;
/*     */     }
/* 105 */     return true;
/*     */   }
/*     */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\sec\PrivilegeId.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */