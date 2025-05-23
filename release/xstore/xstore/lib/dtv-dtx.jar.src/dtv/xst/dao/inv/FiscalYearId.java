/*     */ package dtv.xst.dao.inv;
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
/*     */ public class FiscalYearId
/*     */   extends AbstractObjectId
/*     */ {
/*     */   private static final long serialVersionUID = 1727562555L;
/*     */   private Integer _fiscalYear;
/*     */   
/*     */   public FiscalYearId() {}
/*     */   
/*     */   public FiscalYearId(String argObjectIdValue) {
/*  23 */     setValue(argObjectIdValue);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public Integer getFiscalYear() {
/*  29 */     return this._fiscalYear;
/*     */   }
/*     */   
/*     */   public void setFiscalYear(Integer argFiscalYear) {
/*  33 */     this._fiscalYear = argFiscalYear;
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
/*  48 */       setFiscalYear(Integer.valueOf(str));
/*     */     }
/*  50 */     catch (Exception ee) {
/*  51 */       throw new DtxException("An exception occured while parsing object id string: " + argObjectIdValue, ee);
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean equals(Object ob) {
/*  57 */     if (this == ob) {
/*  58 */       return true;
/*     */     }
/*  60 */     if (!(ob instanceof FiscalYearId)) {
/*  61 */       return false;
/*     */     }
/*  63 */     FiscalYearId other = (FiscalYearId)ob;
/*  64 */     return (((this._organizationId == null && other._organizationId == null) || (this._organizationId != null && this._organizationId
/*     */ 
/*     */       
/*  67 */       .equals(other._organizationId))) && ((this._fiscalYear == null && other._fiscalYear == null) || (this._fiscalYear != null && this._fiscalYear
/*     */ 
/*     */       
/*  70 */       .equals(other._fiscalYear))));
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public int hashCode() {
/*  76 */     return ((this._organizationId == null) ? 0 : this._organizationId
/*  77 */       .hashCode()) + ((this._fiscalYear == null) ? 0 : this._fiscalYear
/*  78 */       .hashCode());
/*     */   }
/*     */ 
/*     */   
/*     */   public String getDtxTypeName() {
/*  83 */     return "FiscalYear";
/*     */   }
/*     */ 
/*     */   
/*     */   public String toString() {
/*  88 */     StringBuilder buff = new StringBuilder(24);
/*     */     
/*  90 */     return buff.append(
/*  91 */         String.valueOf(this._organizationId))
/*  92 */       .append("::").append(String.valueOf(this._fiscalYear))
/*  93 */       .toString();
/*     */   }
/*     */   
/*     */   public boolean validate() {
/*  97 */     if (this._fiscalYear == null) {
/*  98 */       return false;
/*     */     }
/* 100 */     return true;
/*     */   }
/*     */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\inv\FiscalYearId.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */