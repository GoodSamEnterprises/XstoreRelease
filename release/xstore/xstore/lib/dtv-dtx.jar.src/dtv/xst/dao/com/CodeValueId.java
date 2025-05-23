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
/*     */ public class CodeValueId
/*     */   extends AbstractObjectId
/*     */ {
/*     */   private static final long serialVersionUID = 868073316L;
/*     */   private String _category;
/*     */   private String _code;
/*     */   
/*     */   public CodeValueId() {}
/*     */   
/*     */   public CodeValueId(String argObjectIdValue) {
/*  23 */     setValue(argObjectIdValue);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getCategory() {
/*  30 */     return this._category;
/*     */   }
/*     */   
/*     */   public void setCategory(String argCategory) {
/*  34 */     this._category = (argCategory != null && MANAGE_CASE) ? argCategory.toUpperCase() : argCategory;
/*     */   }
/*     */   
/*     */   public String getCode() {
/*  38 */     return this._code;
/*     */   }
/*     */   
/*     */   public void setCode(String argCode) {
/*  42 */     this._code = (argCode != null && MANAGE_CASE) ? argCode.toUpperCase() : argCode;
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
/*  58 */         setCategory((String)null);
/*     */       } else {
/*     */         
/*  61 */         setCategory(str);
/*     */       } 
/*  63 */       str = tokens[2];
/*     */       
/*  65 */       if ("null".equals(str)) {
/*  66 */         setCode((String)null);
/*     */       } else {
/*     */         
/*  69 */         setCode(str);
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
/*  82 */     if (!(ob instanceof CodeValueId)) {
/*  83 */       return false;
/*     */     }
/*  85 */     CodeValueId other = (CodeValueId)ob;
/*  86 */     return (((this._organizationId == null && other._organizationId == null) || (this._organizationId != null && this._organizationId
/*     */ 
/*     */       
/*  89 */       .equals(other._organizationId))) && ((this._category == null && other._category == null) || (this._category != null && this._category
/*     */ 
/*     */       
/*  92 */       .equals(other._category))) && ((this._code == null && other._code == null) || (this._code != null && this._code
/*     */ 
/*     */       
/*  95 */       .equals(other._code))));
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public int hashCode() {
/* 101 */     return ((this._organizationId == null) ? 0 : this._organizationId
/* 102 */       .hashCode()) + ((this._category == null) ? 0 : this._category
/* 103 */       .hashCode()) + ((this._code == null) ? 0 : this._code
/* 104 */       .hashCode());
/*     */   }
/*     */ 
/*     */   
/*     */   public String getDtxTypeName() {
/* 109 */     return "CodeValue";
/*     */   }
/*     */ 
/*     */   
/*     */   public String toString() {
/* 114 */     StringBuilder buff = new StringBuilder(36);
/*     */     
/* 116 */     return buff.append(
/* 117 */         String.valueOf(this._organizationId))
/* 118 */       .append("::").append(this._category)
/* 119 */       .append("::").append(this._code)
/* 120 */       .toString();
/*     */   }
/*     */   
/*     */   public boolean validate() {
/* 124 */     if (this._category == null) {
/* 125 */       return false;
/*     */     }
/* 127 */     if (this._code == null) {
/* 128 */       return false;
/*     */     }
/* 130 */     return true;
/*     */   }
/*     */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\com\CodeValueId.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */