/*     */ package dtv.xst.dao.hrs;
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
/*     */ public class EmployeeTaskId
/*     */   extends AbstractObjectId
/*     */ {
/*     */   private static final long serialVersionUID = -1564025485L;
/*     */   private Long _retailLocationId;
/*     */   private Long _taskId;
/*     */   
/*     */   public EmployeeTaskId() {}
/*     */   
/*     */   public EmployeeTaskId(String argObjectIdValue) {
/*  23 */     setValue(argObjectIdValue);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Long getRetailLocationId() {
/*  30 */     return this._retailLocationId;
/*     */   }
/*     */   
/*     */   public void setRetailLocationId(Long argRetailLocationId) {
/*  34 */     this._retailLocationId = argRetailLocationId;
/*     */   }
/*     */   
/*     */   public Long getTaskId() {
/*  38 */     return this._taskId;
/*     */   }
/*     */   
/*     */   public void setTaskId(Long argTaskId) {
/*  42 */     this._taskId = argTaskId;
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
/*  57 */       setRetailLocationId(Long.valueOf(str));
/*  58 */       str = tokens[2];
/*     */       
/*  60 */       setTaskId(Long.valueOf(str));
/*     */     }
/*  62 */     catch (Exception ee) {
/*  63 */       throw new DtxException("An exception occured while parsing object id string: " + argObjectIdValue, ee);
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean equals(Object ob) {
/*  69 */     if (this == ob) {
/*  70 */       return true;
/*     */     }
/*  72 */     if (!(ob instanceof EmployeeTaskId)) {
/*  73 */       return false;
/*     */     }
/*  75 */     EmployeeTaskId other = (EmployeeTaskId)ob;
/*  76 */     return (((this._organizationId == null && other._organizationId == null) || (this._organizationId != null && this._organizationId
/*     */ 
/*     */       
/*  79 */       .equals(other._organizationId))) && ((this._retailLocationId == null && other._retailLocationId == null) || (this._retailLocationId != null && this._retailLocationId
/*     */ 
/*     */       
/*  82 */       .equals(other._retailLocationId))) && ((this._taskId == null && other._taskId == null) || (this._taskId != null && this._taskId
/*     */ 
/*     */       
/*  85 */       .equals(other._taskId))));
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public int hashCode() {
/*  91 */     return ((this._organizationId == null) ? 0 : this._organizationId
/*  92 */       .hashCode()) + ((this._retailLocationId == null) ? 0 : this._retailLocationId
/*  93 */       .hashCode()) + ((this._taskId == null) ? 0 : this._taskId
/*  94 */       .hashCode());
/*     */   }
/*     */ 
/*     */   
/*     */   public String getDtxTypeName() {
/*  99 */     return "EmployeeTask";
/*     */   }
/*     */ 
/*     */   
/*     */   public String toString() {
/* 104 */     StringBuilder buff = new StringBuilder(36);
/*     */     
/* 106 */     return buff.append(
/* 107 */         String.valueOf(this._organizationId))
/* 108 */       .append("::").append(String.valueOf(this._retailLocationId))
/* 109 */       .append("::").append(String.valueOf(this._taskId))
/* 110 */       .toString();
/*     */   }
/*     */   
/*     */   public boolean validate() {
/* 114 */     if (this._retailLocationId == null) {
/* 115 */       return false;
/*     */     }
/* 117 */     if (this._taskId == null) {
/* 118 */       return false;
/*     */     }
/* 120 */     return true;
/*     */   }
/*     */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\hrs\EmployeeTaskId.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */