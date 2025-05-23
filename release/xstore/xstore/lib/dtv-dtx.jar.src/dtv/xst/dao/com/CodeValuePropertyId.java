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
/*     */ public class CodeValuePropertyId
/*     */   extends AbstractObjectId
/*     */ {
/*     */   private static final long serialVersionUID = -386769575L;
/*     */   private String _category;
/*     */   private String _code;
/*     */   private String _propertyCode;
/*     */   
/*     */   public CodeValuePropertyId() {}
/*     */   
/*     */   public CodeValuePropertyId(String argObjectIdValue) {
/*  23 */     setValue(argObjectIdValue);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getCategory() {
/*  31 */     return this._category;
/*     */   }
/*     */   
/*     */   public void setCategory(String argCategory) {
/*  35 */     this._category = (argCategory != null && MANAGE_CASE) ? argCategory.toUpperCase() : argCategory;
/*     */   }
/*     */   
/*     */   public String getCode() {
/*  39 */     return this._code;
/*     */   }
/*     */   
/*     */   public void setCode(String argCode) {
/*  43 */     this._code = (argCode != null && MANAGE_CASE) ? argCode.toUpperCase() : argCode;
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
/*  63 */       setOrganizationId(Long.valueOf(str));
/*  64 */       str = tokens[1];
/*     */       
/*  66 */       if ("null".equals(str)) {
/*  67 */         setCategory((String)null);
/*     */       } else {
/*     */         
/*  70 */         setCategory(str);
/*     */       } 
/*  72 */       str = tokens[2];
/*     */       
/*  74 */       if ("null".equals(str)) {
/*  75 */         setCode((String)null);
/*     */       } else {
/*     */         
/*  78 */         setCode(str);
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
/*  99 */     if (!(ob instanceof CodeValuePropertyId)) {
/* 100 */       return false;
/*     */     }
/* 102 */     CodeValuePropertyId other = (CodeValuePropertyId)ob;
/* 103 */     return (((this._organizationId == null && other._organizationId == null) || (this._organizationId != null && this._organizationId
/*     */ 
/*     */       
/* 106 */       .equals(other._organizationId))) && ((this._category == null && other._category == null) || (this._category != null && this._category
/*     */ 
/*     */       
/* 109 */       .equals(other._category))) && ((this._code == null && other._code == null) || (this._code != null && this._code
/*     */ 
/*     */       
/* 112 */       .equals(other._code))) && ((this._propertyCode == null && other._propertyCode == null) || (this._propertyCode != null && this._propertyCode
/*     */ 
/*     */       
/* 115 */       .equals(other._propertyCode))));
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public int hashCode() {
/* 121 */     return ((this._organizationId == null) ? 0 : this._organizationId
/* 122 */       .hashCode()) + ((this._category == null) ? 0 : this._category
/* 123 */       .hashCode()) + ((this._code == null) ? 0 : this._code
/* 124 */       .hashCode()) + ((this._propertyCode == null) ? 0 : this._propertyCode
/* 125 */       .hashCode());
/*     */   }
/*     */ 
/*     */   
/*     */   public String getDtxTypeName() {
/* 130 */     return "CodeValueProperty";
/*     */   }
/*     */ 
/*     */   
/*     */   public String toString() {
/* 135 */     StringBuilder buff = new StringBuilder(48);
/*     */     
/* 137 */     return buff.append(
/* 138 */         String.valueOf(this._organizationId))
/* 139 */       .append("::").append(this._category)
/* 140 */       .append("::").append(this._code)
/* 141 */       .append("::").append(this._propertyCode)
/* 142 */       .toString();
/*     */   }
/*     */   
/*     */   public boolean validate() {
/* 146 */     if (this._category == null) {
/* 147 */       return false;
/*     */     }
/* 149 */     if (this._code == null) {
/* 150 */       return false;
/*     */     }
/* 152 */     if (this._propertyCode == null) {
/* 153 */       return false;
/*     */     }
/* 155 */     return true;
/*     */   }
/*     */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\com\CodeValuePropertyId.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */