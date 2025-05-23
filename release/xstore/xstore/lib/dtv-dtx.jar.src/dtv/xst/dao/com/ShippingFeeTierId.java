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
/*     */ 
/*     */ public class ShippingFeeTierId
/*     */   extends AbstractObjectId
/*     */ {
/*     */   private static final long serialVersionUID = 367423706L;
/*     */   private String _ruleName;
/*     */   private String _parentRuleName;
/*     */   
/*     */   public ShippingFeeTierId() {}
/*     */   
/*     */   public ShippingFeeTierId(String argObjectIdValue) {
/*  23 */     setValue(argObjectIdValue);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getRuleName() {
/*  30 */     return this._ruleName;
/*     */   }
/*     */   
/*     */   public void setRuleName(String argRuleName) {
/*  34 */     this._ruleName = (argRuleName != null && MANAGE_CASE) ? argRuleName.toUpperCase() : argRuleName;
/*     */   }
/*     */   
/*     */   public String getParentRuleName() {
/*  38 */     return this._parentRuleName;
/*     */   }
/*     */   
/*     */   public void setParentRuleName(String argParentRuleName) {
/*  42 */     this._parentRuleName = (argParentRuleName != null && MANAGE_CASE) ? argParentRuleName.toUpperCase() : argParentRuleName;
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
/*  55 */         setRuleName((String)null);
/*     */       } else {
/*     */         
/*  58 */         setRuleName(str);
/*     */       } 
/*  60 */       str = tokens[1];
/*     */       
/*  62 */       setOrganizationId(Long.valueOf(str));
/*  63 */       str = tokens[2];
/*     */       
/*  65 */       if ("null".equals(str)) {
/*  66 */         setParentRuleName((String)null);
/*     */       } else {
/*     */         
/*  69 */         setParentRuleName(str);
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
/*  82 */     if (!(ob instanceof ShippingFeeTierId)) {
/*  83 */       return false;
/*     */     }
/*  85 */     ShippingFeeTierId other = (ShippingFeeTierId)ob;
/*  86 */     return (((this._ruleName == null && other._ruleName == null) || (this._ruleName != null && this._ruleName
/*     */ 
/*     */       
/*  89 */       .equals(other._ruleName))) && ((this._organizationId == null && other._organizationId == null) || (this._organizationId != null && this._organizationId
/*     */ 
/*     */       
/*  92 */       .equals(other._organizationId))) && ((this._parentRuleName == null && other._parentRuleName == null) || (this._parentRuleName != null && this._parentRuleName
/*     */ 
/*     */       
/*  95 */       .equals(other._parentRuleName))));
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public int hashCode() {
/* 101 */     return ((this._ruleName == null) ? 0 : this._ruleName
/* 102 */       .hashCode()) + ((this._organizationId == null) ? 0 : this._organizationId
/* 103 */       .hashCode()) + ((this._parentRuleName == null) ? 0 : this._parentRuleName
/* 104 */       .hashCode());
/*     */   }
/*     */ 
/*     */   
/*     */   public String getDtxTypeName() {
/* 109 */     return "ShippingFeeTier";
/*     */   }
/*     */ 
/*     */   
/*     */   public String toString() {
/* 114 */     StringBuilder buff = new StringBuilder(36);
/*     */     
/* 116 */     return buff.append(this._ruleName)
/*     */       
/* 118 */       .append("::").append(String.valueOf(this._organizationId))
/* 119 */       .append("::").append(this._parentRuleName)
/* 120 */       .toString();
/*     */   }
/*     */   
/*     */   public boolean validate() {
/* 124 */     if (this._ruleName == null) {
/* 125 */       return false;
/*     */     }
/* 127 */     if (this._parentRuleName == null) {
/* 128 */       return false;
/*     */     }
/* 130 */     return true;
/*     */   }
/*     */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\com\ShippingFeeTierId.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */