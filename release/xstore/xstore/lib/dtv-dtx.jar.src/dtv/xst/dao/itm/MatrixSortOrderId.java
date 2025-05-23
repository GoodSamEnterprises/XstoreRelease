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
/*     */ public class MatrixSortOrderId
/*     */   extends AbstractObjectId
/*     */ {
/*     */   private static final long serialVersionUID = 647421295L;
/*     */   private String _matrixSortType;
/*     */   private String _matrixSortId;
/*     */   
/*     */   public MatrixSortOrderId() {}
/*     */   
/*     */   public MatrixSortOrderId(String argObjectIdValue) {
/*  23 */     setValue(argObjectIdValue);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getMatrixSortType() {
/*  30 */     return this._matrixSortType;
/*     */   }
/*     */   
/*     */   public void setMatrixSortType(String argMatrixSortType) {
/*  34 */     this._matrixSortType = (argMatrixSortType != null && MANAGE_CASE) ? argMatrixSortType.toUpperCase() : argMatrixSortType;
/*     */   }
/*     */   
/*     */   public String getMatrixSortId() {
/*  38 */     return this._matrixSortId;
/*     */   }
/*     */   
/*     */   public void setMatrixSortId(String argMatrixSortId) {
/*  42 */     this._matrixSortId = (argMatrixSortId != null && MANAGE_CASE) ? argMatrixSortId.toUpperCase() : argMatrixSortId;
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
/*  58 */         setMatrixSortType((String)null);
/*     */       } else {
/*     */         
/*  61 */         setMatrixSortType(str);
/*     */       } 
/*  63 */       str = tokens[2];
/*     */       
/*  65 */       if ("null".equals(str)) {
/*  66 */         setMatrixSortId((String)null);
/*     */       } else {
/*     */         
/*  69 */         setMatrixSortId(str);
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
/*  82 */     if (!(ob instanceof MatrixSortOrderId)) {
/*  83 */       return false;
/*     */     }
/*  85 */     MatrixSortOrderId other = (MatrixSortOrderId)ob;
/*  86 */     return (((this._organizationId == null && other._organizationId == null) || (this._organizationId != null && this._organizationId
/*     */ 
/*     */       
/*  89 */       .equals(other._organizationId))) && ((this._matrixSortType == null && other._matrixSortType == null) || (this._matrixSortType != null && this._matrixSortType
/*     */ 
/*     */       
/*  92 */       .equals(other._matrixSortType))) && ((this._matrixSortId == null && other._matrixSortId == null) || (this._matrixSortId != null && this._matrixSortId
/*     */ 
/*     */       
/*  95 */       .equals(other._matrixSortId))));
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public int hashCode() {
/* 101 */     return ((this._organizationId == null) ? 0 : this._organizationId
/* 102 */       .hashCode()) + ((this._matrixSortType == null) ? 0 : this._matrixSortType
/* 103 */       .hashCode()) + ((this._matrixSortId == null) ? 0 : this._matrixSortId
/* 104 */       .hashCode());
/*     */   }
/*     */ 
/*     */   
/*     */   public String getDtxTypeName() {
/* 109 */     return "MatrixSortOrder";
/*     */   }
/*     */ 
/*     */   
/*     */   public String toString() {
/* 114 */     StringBuilder buff = new StringBuilder(36);
/*     */     
/* 116 */     return buff.append(
/* 117 */         String.valueOf(this._organizationId))
/* 118 */       .append("::").append(this._matrixSortType)
/* 119 */       .append("::").append(this._matrixSortId)
/* 120 */       .toString();
/*     */   }
/*     */   
/*     */   public boolean validate() {
/* 124 */     if (this._matrixSortType == null) {
/* 125 */       return false;
/*     */     }
/* 127 */     if (this._matrixSortId == null) {
/* 128 */       return false;
/*     */     }
/* 130 */     return true;
/*     */   }
/*     */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\itm\MatrixSortOrderId.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */