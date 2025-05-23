/*     */ package dtv.xst.dao.itm;
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
/*     */ public class MerchandiseHierarchyId
/*     */   extends AbstractObjectId
/*     */ {
/*     */   private static final long serialVersionUID = -746218030L;
/*     */   private String _hierarchyId;
/*     */   
/*     */   public MerchandiseHierarchyId() {}
/*     */   
/*     */   public MerchandiseHierarchyId(String argObjectIdValue) {
/*  23 */     setValue(argObjectIdValue);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public String getHierarchyId() {
/*  29 */     return this._hierarchyId;
/*     */   }
/*     */   
/*     */   public void setHierarchyId(String argHierarchyId) {
/*  33 */     this._hierarchyId = (argHierarchyId != null && MANAGE_CASE) ? argHierarchyId.toUpperCase() : argHierarchyId;
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
/*  45 */       if ("null".equals(str)) {
/*  46 */         setHierarchyId((String)null);
/*     */       } else {
/*     */         
/*  49 */         setHierarchyId(str);
/*     */       } 
/*  51 */       str = tokens[1];
/*     */       
/*  53 */       setOrganizationId(Long.valueOf(str));
/*     */     }
/*  55 */     catch (Exception ee) {
/*  56 */       throw new DtxException("An exception occured while parsing object id string: " + argObjectIdValue, ee);
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean equals(Object ob) {
/*  62 */     if (this == ob) {
/*  63 */       return true;
/*     */     }
/*  65 */     if (!(ob instanceof MerchandiseHierarchyId)) {
/*  66 */       return false;
/*     */     }
/*  68 */     MerchandiseHierarchyId other = (MerchandiseHierarchyId)ob;
/*  69 */     return (((this._hierarchyId == null && other._hierarchyId == null) || (this._hierarchyId != null && this._hierarchyId
/*     */ 
/*     */       
/*  72 */       .equals(other._hierarchyId))) && ((this._organizationId == null && other._organizationId == null) || (this._organizationId != null && this._organizationId
/*     */ 
/*     */       
/*  75 */       .equals(other._organizationId))));
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public int hashCode() {
/*  81 */     return ((this._hierarchyId == null) ? 0 : this._hierarchyId
/*  82 */       .hashCode()) + ((this._organizationId == null) ? 0 : this._organizationId
/*  83 */       .hashCode());
/*     */   }
/*     */ 
/*     */   
/*     */   public String getDtxTypeName() {
/*  88 */     return "MerchandiseHierarchy";
/*     */   }
/*     */ 
/*     */   
/*     */   public String toString() {
/*  93 */     StringBuilder buff = new StringBuilder(24);
/*     */     
/*  95 */     return buff.append(this._hierarchyId)
/*     */       
/*  97 */       .append("::").append(String.valueOf(this._organizationId))
/*  98 */       .toString();
/*     */   }
/*     */   
/*     */   public boolean validate() {
/* 102 */     if (this._hierarchyId == null) {
/* 103 */       return false;
/*     */     }
/* 105 */     return true;
/*     */   }
/*     */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\itm\MerchandiseHierarchyId.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */