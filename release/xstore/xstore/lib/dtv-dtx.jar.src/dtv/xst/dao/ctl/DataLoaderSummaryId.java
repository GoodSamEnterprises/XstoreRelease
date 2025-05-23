/*     */ package dtv.xst.dao.ctl;
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
/*     */ public class DataLoaderSummaryId
/*     */   extends AbstractObjectId
/*     */ {
/*     */   private static final long serialVersionUID = -471652247L;
/*     */   private String _fileName;
/*     */   private Long _runTime;
/*     */   
/*     */   public DataLoaderSummaryId() {}
/*     */   
/*     */   public DataLoaderSummaryId(String argObjectIdValue) {
/*  23 */     setValue(argObjectIdValue);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getFileName() {
/*  30 */     return this._fileName;
/*     */   }
/*     */   
/*     */   public void setFileName(String argFileName) {
/*  34 */     this._fileName = (argFileName != null && MANAGE_CASE) ? argFileName.toUpperCase() : argFileName;
/*     */   }
/*     */   
/*     */   public Long getRunTime() {
/*  38 */     return this._runTime;
/*     */   }
/*     */   
/*     */   public void setRunTime(Long argRunTime) {
/*  42 */     this._runTime = argRunTime;
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
/*  58 */         setFileName((String)null);
/*     */       } else {
/*     */         
/*  61 */         setFileName(str);
/*     */       } 
/*  63 */       str = tokens[2];
/*     */       
/*  65 */       setRunTime(Long.valueOf(str));
/*     */     }
/*  67 */     catch (Exception ee) {
/*  68 */       throw new DtxException("An exception occured while parsing object id string: " + argObjectIdValue, ee);
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean equals(Object ob) {
/*  74 */     if (this == ob) {
/*  75 */       return true;
/*     */     }
/*  77 */     if (!(ob instanceof DataLoaderSummaryId)) {
/*  78 */       return false;
/*     */     }
/*  80 */     DataLoaderSummaryId other = (DataLoaderSummaryId)ob;
/*  81 */     return (((this._organizationId == null && other._organizationId == null) || (this._organizationId != null && this._organizationId
/*     */ 
/*     */       
/*  84 */       .equals(other._organizationId))) && ((this._fileName == null && other._fileName == null) || (this._fileName != null && this._fileName
/*     */ 
/*     */       
/*  87 */       .equals(other._fileName))) && ((this._runTime == null && other._runTime == null) || (this._runTime != null && this._runTime
/*     */ 
/*     */       
/*  90 */       .equals(other._runTime))));
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public int hashCode() {
/*  96 */     return ((this._organizationId == null) ? 0 : this._organizationId
/*  97 */       .hashCode()) + ((this._fileName == null) ? 0 : this._fileName
/*  98 */       .hashCode()) + ((this._runTime == null) ? 0 : this._runTime
/*  99 */       .hashCode());
/*     */   }
/*     */ 
/*     */   
/*     */   public String getDtxTypeName() {
/* 104 */     return "DataLoaderSummary";
/*     */   }
/*     */ 
/*     */   
/*     */   public String toString() {
/* 109 */     StringBuilder buff = new StringBuilder(36);
/*     */     
/* 111 */     return buff.append(
/* 112 */         String.valueOf(this._organizationId))
/* 113 */       .append("::").append(this._fileName)
/* 114 */       .append("::").append(String.valueOf(this._runTime))
/* 115 */       .toString();
/*     */   }
/*     */   
/*     */   public boolean validate() {
/* 119 */     if (this._fileName == null) {
/* 120 */       return false;
/*     */     }
/* 122 */     if (this._runTime == null) {
/* 123 */       return false;
/*     */     }
/* 125 */     return true;
/*     */   }
/*     */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\ctl\DataLoaderSummaryId.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */