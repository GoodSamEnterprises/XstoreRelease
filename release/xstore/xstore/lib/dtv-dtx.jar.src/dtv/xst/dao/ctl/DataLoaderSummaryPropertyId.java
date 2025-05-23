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
/*     */ public class DataLoaderSummaryPropertyId
/*     */   extends AbstractObjectId
/*     */ {
/*     */   private static final long serialVersionUID = -1695223458L;
/*     */   private String _fileName;
/*     */   private Long _runTime;
/*     */   private String _propertyCode;
/*     */   
/*     */   public DataLoaderSummaryPropertyId() {}
/*     */   
/*     */   public DataLoaderSummaryPropertyId(String argObjectIdValue) {
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
/*  77 */       if ("null".equals(str)) {
/*  78 */         setPropertyCode((String)null);
/*     */       } else {
/*     */         
/*  81 */         setPropertyCode(str);
/*     */       }
/*     */     
/*  84 */     } catch (Exception ee) {
/*  85 */       throw new DtxException("An exception occured while parsing object id string: " + argObjectIdValue, ee);
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean equals(Object ob) {
/*  91 */     if (this == ob) {
/*  92 */       return true;
/*     */     }
/*  94 */     if (!(ob instanceof DataLoaderSummaryPropertyId)) {
/*  95 */       return false;
/*     */     }
/*  97 */     DataLoaderSummaryPropertyId other = (DataLoaderSummaryPropertyId)ob;
/*  98 */     return (((this._organizationId == null && other._organizationId == null) || (this._organizationId != null && this._organizationId
/*     */ 
/*     */       
/* 101 */       .equals(other._organizationId))) && ((this._fileName == null && other._fileName == null) || (this._fileName != null && this._fileName
/*     */ 
/*     */       
/* 104 */       .equals(other._fileName))) && ((this._runTime == null && other._runTime == null) || (this._runTime != null && this._runTime
/*     */ 
/*     */       
/* 107 */       .equals(other._runTime))) && ((this._propertyCode == null && other._propertyCode == null) || (this._propertyCode != null && this._propertyCode
/*     */ 
/*     */       
/* 110 */       .equals(other._propertyCode))));
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public int hashCode() {
/* 116 */     return ((this._organizationId == null) ? 0 : this._organizationId
/* 117 */       .hashCode()) + ((this._fileName == null) ? 0 : this._fileName
/* 118 */       .hashCode()) + ((this._runTime == null) ? 0 : this._runTime
/* 119 */       .hashCode()) + ((this._propertyCode == null) ? 0 : this._propertyCode
/* 120 */       .hashCode());
/*     */   }
/*     */ 
/*     */   
/*     */   public String getDtxTypeName() {
/* 125 */     return "DataLoaderSummaryProperty";
/*     */   }
/*     */ 
/*     */   
/*     */   public String toString() {
/* 130 */     StringBuilder buff = new StringBuilder(48);
/*     */     
/* 132 */     return buff.append(
/* 133 */         String.valueOf(this._organizationId))
/* 134 */       .append("::").append(this._fileName)
/* 135 */       .append("::").append(String.valueOf(this._runTime))
/* 136 */       .append("::").append(this._propertyCode)
/* 137 */       .toString();
/*     */   }
/*     */   
/*     */   public boolean validate() {
/* 141 */     if (this._fileName == null) {
/* 142 */       return false;
/*     */     }
/* 144 */     if (this._runTime == null) {
/* 145 */       return false;
/*     */     }
/* 147 */     if (this._propertyCode == null) {
/* 148 */       return false;
/*     */     }
/* 150 */     return true;
/*     */   }
/*     */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\ctl\DataLoaderSummaryPropertyId.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */