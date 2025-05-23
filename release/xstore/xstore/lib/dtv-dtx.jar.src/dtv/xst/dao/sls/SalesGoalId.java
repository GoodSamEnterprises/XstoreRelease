/*     */ package dtv.xst.dao.sls;
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
/*     */ public class SalesGoalId
/*     */   extends AbstractObjectId
/*     */ {
/*     */   private static final long serialVersionUID = 1920136735L;
/*     */   private String _salesGoalId;
/*     */   
/*     */   public SalesGoalId() {}
/*     */   
/*     */   public SalesGoalId(String argObjectIdValue) {
/*  23 */     setValue(argObjectIdValue);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public String getSalesGoalId() {
/*  29 */     return this._salesGoalId;
/*     */   }
/*     */   
/*     */   public void setSalesGoalId(String argSalesGoalId) {
/*  33 */     this._salesGoalId = (argSalesGoalId != null && MANAGE_CASE) ? argSalesGoalId.toUpperCase() : argSalesGoalId;
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
/*  49 */         setSalesGoalId((String)null);
/*     */       } else {
/*     */         
/*  52 */         setSalesGoalId(str);
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
/*  65 */     if (!(ob instanceof SalesGoalId)) {
/*  66 */       return false;
/*     */     }
/*  68 */     SalesGoalId other = (SalesGoalId)ob;
/*  69 */     return (((this._organizationId == null && other._organizationId == null) || (this._organizationId != null && this._organizationId
/*     */ 
/*     */       
/*  72 */       .equals(other._organizationId))) && ((this._salesGoalId == null && other._salesGoalId == null) || (this._salesGoalId != null && this._salesGoalId
/*     */ 
/*     */       
/*  75 */       .equals(other._salesGoalId))));
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public int hashCode() {
/*  81 */     return ((this._organizationId == null) ? 0 : this._organizationId
/*  82 */       .hashCode()) + ((this._salesGoalId == null) ? 0 : this._salesGoalId
/*  83 */       .hashCode());
/*     */   }
/*     */ 
/*     */   
/*     */   public String getDtxTypeName() {
/*  88 */     return "SalesGoal";
/*     */   }
/*     */ 
/*     */   
/*     */   public String toString() {
/*  93 */     StringBuilder buff = new StringBuilder(24);
/*     */     
/*  95 */     return buff.append(
/*  96 */         String.valueOf(this._organizationId))
/*  97 */       .append("::").append(this._salesGoalId)
/*  98 */       .toString();
/*     */   }
/*     */   
/*     */   public boolean validate() {
/* 102 */     if (this._salesGoalId == null) {
/* 103 */       return false;
/*     */     }
/* 105 */     return true;
/*     */   }
/*     */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\sls\SalesGoalId.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */