/*     */ package dtv.xst.dao.tax;
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
/*     */ public class TaxAuthorityId
/*     */   extends AbstractObjectId
/*     */ {
/*     */   private static final long serialVersionUID = 1120218104L;
/*     */   private String _taxAuthorityId;
/*     */   
/*     */   public TaxAuthorityId() {}
/*     */   
/*     */   public TaxAuthorityId(String argObjectIdValue) {
/*  23 */     setValue(argObjectIdValue);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public String getTaxAuthorityId() {
/*  29 */     return this._taxAuthorityId;
/*     */   }
/*     */   
/*     */   public void setTaxAuthorityId(String argTaxAuthorityId) {
/*  33 */     this._taxAuthorityId = (argTaxAuthorityId != null && MANAGE_CASE) ? argTaxAuthorityId.toUpperCase() : argTaxAuthorityId;
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
/*  49 */         setTaxAuthorityId((String)null);
/*     */       } else {
/*     */         
/*  52 */         setTaxAuthorityId(str);
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
/*  65 */     if (!(ob instanceof TaxAuthorityId)) {
/*  66 */       return false;
/*     */     }
/*  68 */     TaxAuthorityId other = (TaxAuthorityId)ob;
/*  69 */     return (((this._organizationId == null && other._organizationId == null) || (this._organizationId != null && this._organizationId
/*     */ 
/*     */       
/*  72 */       .equals(other._organizationId))) && ((this._taxAuthorityId == null && other._taxAuthorityId == null) || (this._taxAuthorityId != null && this._taxAuthorityId
/*     */ 
/*     */       
/*  75 */       .equals(other._taxAuthorityId))));
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public int hashCode() {
/*  81 */     return ((this._organizationId == null) ? 0 : this._organizationId
/*  82 */       .hashCode()) + ((this._taxAuthorityId == null) ? 0 : this._taxAuthorityId
/*  83 */       .hashCode());
/*     */   }
/*     */ 
/*     */   
/*     */   public String getDtxTypeName() {
/*  88 */     return "TaxAuthority";
/*     */   }
/*     */ 
/*     */   
/*     */   public String toString() {
/*  93 */     StringBuilder buff = new StringBuilder(24);
/*     */     
/*  95 */     return buff.append(
/*  96 */         String.valueOf(this._organizationId))
/*  97 */       .append("::").append(this._taxAuthorityId)
/*  98 */       .toString();
/*     */   }
/*     */   
/*     */   public boolean validate() {
/* 102 */     if (this._taxAuthorityId == null) {
/* 103 */       return false;
/*     */     }
/* 105 */     return true;
/*     */   }
/*     */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\tax\TaxAuthorityId.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */