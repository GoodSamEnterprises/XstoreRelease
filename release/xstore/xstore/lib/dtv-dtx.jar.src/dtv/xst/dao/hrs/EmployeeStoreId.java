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
/*     */ public class EmployeeStoreId
/*     */   extends AbstractObjectId
/*     */ {
/*     */   private static final long serialVersionUID = -1240510797L;
/*     */   private String _employeeId;
/*     */   private Long _retailLocationId;
/*     */   private Integer _employeeStoreSequence;
/*     */   
/*     */   public EmployeeStoreId() {}
/*     */   
/*     */   public EmployeeStoreId(String argObjectIdValue) {
/*  23 */     setValue(argObjectIdValue);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getEmployeeId() {
/*  31 */     return this._employeeId;
/*     */   }
/*     */   
/*     */   public void setEmployeeId(String argEmployeeId) {
/*  35 */     this._employeeId = (argEmployeeId != null && MANAGE_CASE) ? argEmployeeId.toUpperCase() : argEmployeeId;
/*     */   }
/*     */   
/*     */   public Long getRetailLocationId() {
/*  39 */     return this._retailLocationId;
/*     */   }
/*     */   
/*     */   public void setRetailLocationId(Long argRetailLocationId) {
/*  43 */     this._retailLocationId = argRetailLocationId;
/*     */   }
/*     */   
/*     */   public Integer getEmployeeStoreSequence() {
/*  47 */     return this._employeeStoreSequence;
/*     */   }
/*     */   
/*     */   public void setEmployeeStoreSequence(Integer argEmployeeStoreSequence) {
/*  51 */     this._employeeStoreSequence = argEmployeeStoreSequence;
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
/*  67 */         setEmployeeId((String)null);
/*     */       } else {
/*     */         
/*  70 */         setEmployeeId(str);
/*     */       } 
/*  72 */       str = tokens[2];
/*     */       
/*  74 */       setRetailLocationId(Long.valueOf(str));
/*  75 */       str = tokens[3];
/*     */       
/*  77 */       setEmployeeStoreSequence(Integer.valueOf(str));
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
/*  89 */     if (!(ob instanceof EmployeeStoreId)) {
/*  90 */       return false;
/*     */     }
/*  92 */     EmployeeStoreId other = (EmployeeStoreId)ob;
/*  93 */     return (((this._organizationId == null && other._organizationId == null) || (this._organizationId != null && this._organizationId
/*     */ 
/*     */       
/*  96 */       .equals(other._organizationId))) && ((this._employeeId == null && other._employeeId == null) || (this._employeeId != null && this._employeeId
/*     */ 
/*     */       
/*  99 */       .equals(other._employeeId))) && ((this._retailLocationId == null && other._retailLocationId == null) || (this._retailLocationId != null && this._retailLocationId
/*     */ 
/*     */       
/* 102 */       .equals(other._retailLocationId))) && ((this._employeeStoreSequence == null && other._employeeStoreSequence == null) || (this._employeeStoreSequence != null && this._employeeStoreSequence
/*     */ 
/*     */       
/* 105 */       .equals(other._employeeStoreSequence))));
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public int hashCode() {
/* 111 */     return ((this._organizationId == null) ? 0 : this._organizationId
/* 112 */       .hashCode()) + ((this._employeeId == null) ? 0 : this._employeeId
/* 113 */       .hashCode()) + ((this._retailLocationId == null) ? 0 : this._retailLocationId
/* 114 */       .hashCode()) + ((this._employeeStoreSequence == null) ? 0 : this._employeeStoreSequence
/* 115 */       .hashCode());
/*     */   }
/*     */ 
/*     */   
/*     */   public String getDtxTypeName() {
/* 120 */     return "EmployeeStore";
/*     */   }
/*     */ 
/*     */   
/*     */   public String toString() {
/* 125 */     StringBuilder buff = new StringBuilder(48);
/*     */     
/* 127 */     return buff.append(
/* 128 */         String.valueOf(this._organizationId))
/* 129 */       .append("::").append(this._employeeId)
/* 130 */       .append("::").append(String.valueOf(this._retailLocationId))
/* 131 */       .append("::").append(String.valueOf(this._employeeStoreSequence))
/* 132 */       .toString();
/*     */   }
/*     */   
/*     */   public boolean validate() {
/* 136 */     if (this._employeeId == null) {
/* 137 */       return false;
/*     */     }
/* 139 */     if (this._retailLocationId == null) {
/* 140 */       return false;
/*     */     }
/* 142 */     if (this._employeeStoreSequence == null) {
/* 143 */       return false;
/*     */     }
/* 145 */     return true;
/*     */   }
/*     */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\hrs\EmployeeStoreId.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */