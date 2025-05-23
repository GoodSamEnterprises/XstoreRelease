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
/*     */ public class MatrixSortOrderPropertyId
/*     */   extends AbstractObjectId
/*     */ {
/*     */   private static final long serialVersionUID = 1455308900L;
/*     */   private String _matrixSortType;
/*     */   private String _matrixSortId;
/*     */   private String _propertyCode;
/*     */   
/*     */   public MatrixSortOrderPropertyId() {}
/*     */   
/*     */   public MatrixSortOrderPropertyId(String argObjectIdValue) {
/*  23 */     setValue(argObjectIdValue);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getMatrixSortType() {
/*  31 */     return this._matrixSortType;
/*     */   }
/*     */   
/*     */   public void setMatrixSortType(String argMatrixSortType) {
/*  35 */     this._matrixSortType = (argMatrixSortType != null && MANAGE_CASE) ? argMatrixSortType.toUpperCase() : argMatrixSortType;
/*     */   }
/*     */   
/*     */   public String getMatrixSortId() {
/*  39 */     return this._matrixSortId;
/*     */   }
/*     */   
/*     */   public void setMatrixSortId(String argMatrixSortId) {
/*  43 */     this._matrixSortId = (argMatrixSortId != null && MANAGE_CASE) ? argMatrixSortId.toUpperCase() : argMatrixSortId;
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
/*  67 */         setMatrixSortType((String)null);
/*     */       } else {
/*     */         
/*  70 */         setMatrixSortType(str);
/*     */       } 
/*  72 */       str = tokens[2];
/*     */       
/*  74 */       if ("null".equals(str)) {
/*  75 */         setMatrixSortId((String)null);
/*     */       } else {
/*     */         
/*  78 */         setMatrixSortId(str);
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
/*  99 */     if (!(ob instanceof MatrixSortOrderPropertyId)) {
/* 100 */       return false;
/*     */     }
/* 102 */     MatrixSortOrderPropertyId other = (MatrixSortOrderPropertyId)ob;
/* 103 */     return (((this._organizationId == null && other._organizationId == null) || (this._organizationId != null && this._organizationId
/*     */ 
/*     */       
/* 106 */       .equals(other._organizationId))) && ((this._matrixSortType == null && other._matrixSortType == null) || (this._matrixSortType != null && this._matrixSortType
/*     */ 
/*     */       
/* 109 */       .equals(other._matrixSortType))) && ((this._matrixSortId == null && other._matrixSortId == null) || (this._matrixSortId != null && this._matrixSortId
/*     */ 
/*     */       
/* 112 */       .equals(other._matrixSortId))) && ((this._propertyCode == null && other._propertyCode == null) || (this._propertyCode != null && this._propertyCode
/*     */ 
/*     */       
/* 115 */       .equals(other._propertyCode))));
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public int hashCode() {
/* 121 */     return ((this._organizationId == null) ? 0 : this._organizationId
/* 122 */       .hashCode()) + ((this._matrixSortType == null) ? 0 : this._matrixSortType
/* 123 */       .hashCode()) + ((this._matrixSortId == null) ? 0 : this._matrixSortId
/* 124 */       .hashCode()) + ((this._propertyCode == null) ? 0 : this._propertyCode
/* 125 */       .hashCode());
/*     */   }
/*     */ 
/*     */   
/*     */   public String getDtxTypeName() {
/* 130 */     return "MatrixSortOrderProperty";
/*     */   }
/*     */ 
/*     */   
/*     */   public String toString() {
/* 135 */     StringBuilder buff = new StringBuilder(48);
/*     */     
/* 137 */     return buff.append(
/* 138 */         String.valueOf(this._organizationId))
/* 139 */       .append("::").append(this._matrixSortType)
/* 140 */       .append("::").append(this._matrixSortId)
/* 141 */       .append("::").append(this._propertyCode)
/* 142 */       .toString();
/*     */   }
/*     */   
/*     */   public boolean validate() {
/* 146 */     if (this._matrixSortType == null) {
/* 147 */       return false;
/*     */     }
/* 149 */     if (this._matrixSortId == null) {
/* 150 */       return false;
/*     */     }
/* 152 */     if (this._propertyCode == null) {
/* 153 */       return false;
/*     */     }
/* 155 */     return true;
/*     */   }
/*     */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\itm\MatrixSortOrderPropertyId.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */