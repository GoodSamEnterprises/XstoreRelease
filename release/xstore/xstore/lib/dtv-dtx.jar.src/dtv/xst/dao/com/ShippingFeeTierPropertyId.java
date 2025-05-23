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
/*     */ public class ShippingFeeTierPropertyId
/*     */   extends AbstractObjectId
/*     */ {
/*     */   private static final long serialVersionUID = -882558769L;
/*     */   private String _ruleName;
/*     */   private String _parentRuleName;
/*     */   private String _propertyCode;
/*     */   
/*     */   public ShippingFeeTierPropertyId() {}
/*     */   
/*     */   public ShippingFeeTierPropertyId(String argObjectIdValue) {
/*  23 */     setValue(argObjectIdValue);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getRuleName() {
/*  31 */     return this._ruleName;
/*     */   }
/*     */   
/*     */   public void setRuleName(String argRuleName) {
/*  35 */     this._ruleName = (argRuleName != null && MANAGE_CASE) ? argRuleName.toUpperCase() : argRuleName;
/*     */   }
/*     */   
/*     */   public String getParentRuleName() {
/*  39 */     return this._parentRuleName;
/*     */   }
/*     */   
/*     */   public void setParentRuleName(String argParentRuleName) {
/*  43 */     this._parentRuleName = (argParentRuleName != null && MANAGE_CASE) ? argParentRuleName.toUpperCase() : argParentRuleName;
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
/*  64 */         setRuleName((String)null);
/*     */       } else {
/*     */         
/*  67 */         setRuleName(str);
/*     */       } 
/*  69 */       str = tokens[1];
/*     */       
/*  71 */       setOrganizationId(Long.valueOf(str));
/*  72 */       str = tokens[2];
/*     */       
/*  74 */       if ("null".equals(str)) {
/*  75 */         setParentRuleName((String)null);
/*     */       } else {
/*     */         
/*  78 */         setParentRuleName(str);
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
/*  99 */     if (!(ob instanceof ShippingFeeTierPropertyId)) {
/* 100 */       return false;
/*     */     }
/* 102 */     ShippingFeeTierPropertyId other = (ShippingFeeTierPropertyId)ob;
/* 103 */     return (((this._ruleName == null && other._ruleName == null) || (this._ruleName != null && this._ruleName
/*     */ 
/*     */       
/* 106 */       .equals(other._ruleName))) && ((this._organizationId == null && other._organizationId == null) || (this._organizationId != null && this._organizationId
/*     */ 
/*     */       
/* 109 */       .equals(other._organizationId))) && ((this._parentRuleName == null && other._parentRuleName == null) || (this._parentRuleName != null && this._parentRuleName
/*     */ 
/*     */       
/* 112 */       .equals(other._parentRuleName))) && ((this._propertyCode == null && other._propertyCode == null) || (this._propertyCode != null && this._propertyCode
/*     */ 
/*     */       
/* 115 */       .equals(other._propertyCode))));
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public int hashCode() {
/* 121 */     return ((this._ruleName == null) ? 0 : this._ruleName
/* 122 */       .hashCode()) + ((this._organizationId == null) ? 0 : this._organizationId
/* 123 */       .hashCode()) + ((this._parentRuleName == null) ? 0 : this._parentRuleName
/* 124 */       .hashCode()) + ((this._propertyCode == null) ? 0 : this._propertyCode
/* 125 */       .hashCode());
/*     */   }
/*     */ 
/*     */   
/*     */   public String getDtxTypeName() {
/* 130 */     return "ShippingFeeTierProperty";
/*     */   }
/*     */ 
/*     */   
/*     */   public String toString() {
/* 135 */     StringBuilder buff = new StringBuilder(48);
/*     */     
/* 137 */     return buff.append(this._ruleName)
/*     */       
/* 139 */       .append("::").append(String.valueOf(this._organizationId))
/* 140 */       .append("::").append(this._parentRuleName)
/* 141 */       .append("::").append(this._propertyCode)
/* 142 */       .toString();
/*     */   }
/*     */   
/*     */   public boolean validate() {
/* 146 */     if (this._ruleName == null) {
/* 147 */       return false;
/*     */     }
/* 149 */     if (this._parentRuleName == null) {
/* 150 */       return false;
/*     */     }
/* 152 */     if (this._propertyCode == null) {
/* 153 */       return false;
/*     */     }
/* 155 */     return true;
/*     */   }
/*     */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\com\ShippingFeeTierPropertyId.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */