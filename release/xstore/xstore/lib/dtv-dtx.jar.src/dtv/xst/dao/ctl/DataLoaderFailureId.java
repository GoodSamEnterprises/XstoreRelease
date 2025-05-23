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
/*     */ public class DataLoaderFailureId
/*     */   extends AbstractObjectId
/*     */ {
/*     */   private static final long serialVersionUID = 299414093L;
/*     */   private String _fileName;
/*     */   private Long _runTime;
/*     */   private Integer _failureSequence;
/*     */   
/*     */   public DataLoaderFailureId() {}
/*     */   
/*     */   public DataLoaderFailureId(String argObjectIdValue) {
/*  23 */     setValue(argObjectIdValue);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getFileName() {
/*  31 */     return this._fileName;
/*     */   }
/*     */   
/*     */   public void setFileName(String argFileName) {
/*  35 */     this._fileName = (argFileName != null && MANAGE_CASE) ? argFileName.toUpperCase() : argFileName;
/*     */   }
/*     */   
/*     */   public Long getRunTime() {
/*  39 */     return this._runTime;
/*     */   }
/*     */   
/*     */   public void setRunTime(Long argRunTime) {
/*  43 */     this._runTime = argRunTime;
/*     */   }
/*     */   
/*     */   public Integer getFailureSequence() {
/*  47 */     return this._failureSequence;
/*     */   }
/*     */   
/*     */   public void setFailureSequence(Integer argFailureSequence) {
/*  51 */     this._failureSequence = argFailureSequence;
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
/*  67 */         setFileName((String)null);
/*     */       } else {
/*     */         
/*  70 */         setFileName(str);
/*     */       } 
/*  72 */       str = tokens[2];
/*     */       
/*  74 */       setRunTime(Long.valueOf(str));
/*  75 */       str = tokens[3];
/*     */       
/*  77 */       setFailureSequence(Integer.valueOf(str));
/*     */     }
/*  79 */     catch (Exception ee) {
/*  80 */       throw new DtxException("An exception occured while parsing object id string: " + argObjectIdValue, ee);
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean equals(Object ob) {
/*  86 */     if (this == ob) {
/*  87 */       return true;
/*     */     }
/*  89 */     if (!(ob instanceof DataLoaderFailureId)) {
/*  90 */       return false;
/*     */     }
/*  92 */     DataLoaderFailureId other = (DataLoaderFailureId)ob;
/*  93 */     return (((this._organizationId == null && other._organizationId == null) || (this._organizationId != null && this._organizationId
/*     */ 
/*     */       
/*  96 */       .equals(other._organizationId))) && ((this._fileName == null && other._fileName == null) || (this._fileName != null && this._fileName
/*     */ 
/*     */       
/*  99 */       .equals(other._fileName))) && ((this._runTime == null && other._runTime == null) || (this._runTime != null && this._runTime
/*     */ 
/*     */       
/* 102 */       .equals(other._runTime))) && ((this._failureSequence == null && other._failureSequence == null) || (this._failureSequence != null && this._failureSequence
/*     */ 
/*     */       
/* 105 */       .equals(other._failureSequence))));
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public int hashCode() {
/* 111 */     return ((this._organizationId == null) ? 0 : this._organizationId
/* 112 */       .hashCode()) + ((this._fileName == null) ? 0 : this._fileName
/* 113 */       .hashCode()) + ((this._runTime == null) ? 0 : this._runTime
/* 114 */       .hashCode()) + ((this._failureSequence == null) ? 0 : this._failureSequence
/* 115 */       .hashCode());
/*     */   }
/*     */ 
/*     */   
/*     */   public String getDtxTypeName() {
/* 120 */     return "DataLoaderFailure";
/*     */   }
/*     */ 
/*     */   
/*     */   public String toString() {
/* 125 */     StringBuilder buff = new StringBuilder(48);
/*     */     
/* 127 */     return buff.append(
/* 128 */         String.valueOf(this._organizationId))
/* 129 */       .append("::").append(this._fileName)
/* 130 */       .append("::").append(String.valueOf(this._runTime))
/* 131 */       .append("::").append(String.valueOf(this._failureSequence))
/* 132 */       .toString();
/*     */   }
/*     */   
/*     */   public boolean validate() {
/* 136 */     if (this._fileName == null) {
/* 137 */       return false;
/*     */     }
/* 139 */     if (this._runTime == null) {
/* 140 */       return false;
/*     */     }
/* 142 */     if (this._failureSequence == null) {
/* 143 */       return false;
/*     */     }
/* 145 */     return true;
/*     */   }
/*     */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\ctl\DataLoaderFailureId.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */