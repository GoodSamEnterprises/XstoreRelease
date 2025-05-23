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
/*     */ public class DataLoaderFailurePropertyId
/*     */   extends AbstractObjectId
/*     */ {
/*     */   private static final long serialVersionUID = -1337698494L;
/*     */   private String _fileName;
/*     */   private Long _runTime;
/*     */   private Integer _failureSequence;
/*     */   private String _propertyCode;
/*     */   
/*     */   public DataLoaderFailurePropertyId() {}
/*     */   
/*     */   public DataLoaderFailurePropertyId(String argObjectIdValue) {
/*  23 */     setValue(argObjectIdValue);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getFileName() {
/*  32 */     return this._fileName;
/*     */   }
/*     */   
/*     */   public void setFileName(String argFileName) {
/*  36 */     this._fileName = (argFileName != null && MANAGE_CASE) ? argFileName.toUpperCase() : argFileName;
/*     */   }
/*     */   
/*     */   public Long getRunTime() {
/*  40 */     return this._runTime;
/*     */   }
/*     */   
/*     */   public void setRunTime(Long argRunTime) {
/*  44 */     this._runTime = argRunTime;
/*     */   }
/*     */   
/*     */   public Integer getFailureSequence() {
/*  48 */     return this._failureSequence;
/*     */   }
/*     */   
/*     */   public void setFailureSequence(Integer argFailureSequence) {
/*  52 */     this._failureSequence = argFailureSequence;
/*     */   }
/*     */   
/*     */   public String getPropertyCode() {
/*  56 */     return this._propertyCode;
/*     */   }
/*     */   
/*     */   public void setPropertyCode(String argPropertyCode) {
/*  60 */     this._propertyCode = (argPropertyCode != null && MANAGE_CASE) ? argPropertyCode.toUpperCase() : argPropertyCode;
/*     */   }
/*     */   
/*     */   public void setValue(String argObjectIdValue) {
/*  64 */     String str = argObjectIdValue;
/*  65 */     if (StringUtils.isEmpty(str)) {
/*  66 */       throw new DtxException("argument passed to setValue() is null or empty - a valid value must be passed");
/*     */     }
/*     */     try {
/*  69 */       String[] tokens = str.split("::");
/*  70 */       str = tokens[0];
/*     */       
/*  72 */       setOrganizationId(Long.valueOf(str));
/*  73 */       str = tokens[1];
/*     */       
/*  75 */       if ("null".equals(str)) {
/*  76 */         setFileName((String)null);
/*     */       } else {
/*     */         
/*  79 */         setFileName(str);
/*     */       } 
/*  81 */       str = tokens[2];
/*     */       
/*  83 */       setRunTime(Long.valueOf(str));
/*  84 */       str = tokens[3];
/*     */       
/*  86 */       setFailureSequence(Integer.valueOf(str));
/*  87 */       str = tokens[4];
/*     */       
/*  89 */       if ("null".equals(str)) {
/*  90 */         setPropertyCode((String)null);
/*     */       } else {
/*     */         
/*  93 */         setPropertyCode(str);
/*     */       }
/*     */     
/*  96 */     } catch (Exception ee) {
/*  97 */       throw new DtxException("An exception occured while parsing object id string: " + argObjectIdValue, ee);
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean equals(Object ob) {
/* 103 */     if (this == ob) {
/* 104 */       return true;
/*     */     }
/* 106 */     if (!(ob instanceof DataLoaderFailurePropertyId)) {
/* 107 */       return false;
/*     */     }
/* 109 */     DataLoaderFailurePropertyId other = (DataLoaderFailurePropertyId)ob;
/* 110 */     return (((this._organizationId == null && other._organizationId == null) || (this._organizationId != null && this._organizationId
/*     */ 
/*     */       
/* 113 */       .equals(other._organizationId))) && ((this._fileName == null && other._fileName == null) || (this._fileName != null && this._fileName
/*     */ 
/*     */       
/* 116 */       .equals(other._fileName))) && ((this._runTime == null && other._runTime == null) || (this._runTime != null && this._runTime
/*     */ 
/*     */       
/* 119 */       .equals(other._runTime))) && ((this._failureSequence == null && other._failureSequence == null) || (this._failureSequence != null && this._failureSequence
/*     */ 
/*     */       
/* 122 */       .equals(other._failureSequence))) && ((this._propertyCode == null && other._propertyCode == null) || (this._propertyCode != null && this._propertyCode
/*     */ 
/*     */       
/* 125 */       .equals(other._propertyCode))));
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public int hashCode() {
/* 131 */     return ((this._organizationId == null) ? 0 : this._organizationId
/* 132 */       .hashCode()) + ((this._fileName == null) ? 0 : this._fileName
/* 133 */       .hashCode()) + ((this._runTime == null) ? 0 : this._runTime
/* 134 */       .hashCode()) + ((this._failureSequence == null) ? 0 : this._failureSequence
/* 135 */       .hashCode()) + ((this._propertyCode == null) ? 0 : this._propertyCode
/* 136 */       .hashCode());
/*     */   }
/*     */ 
/*     */   
/*     */   public String getDtxTypeName() {
/* 141 */     return "DataLoaderFailureProperty";
/*     */   }
/*     */ 
/*     */   
/*     */   public String toString() {
/* 146 */     StringBuilder buff = new StringBuilder(60);
/*     */     
/* 148 */     return buff.append(
/* 149 */         String.valueOf(this._organizationId))
/* 150 */       .append("::").append(this._fileName)
/* 151 */       .append("::").append(String.valueOf(this._runTime))
/* 152 */       .append("::").append(String.valueOf(this._failureSequence))
/* 153 */       .append("::").append(this._propertyCode)
/* 154 */       .toString();
/*     */   }
/*     */   
/*     */   public boolean validate() {
/* 158 */     if (this._fileName == null) {
/* 159 */       return false;
/*     */     }
/* 161 */     if (this._runTime == null) {
/* 162 */       return false;
/*     */     }
/* 164 */     if (this._failureSequence == null) {
/* 165 */       return false;
/*     */     }
/* 167 */     if (this._propertyCode == null) {
/* 168 */       return false;
/*     */     }
/* 170 */     return true;
/*     */   }
/*     */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\ctl\DataLoaderFailurePropertyId.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */