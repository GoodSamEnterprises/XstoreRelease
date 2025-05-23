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
/*     */ public class EmployeeTaskPropertyId
/*     */   extends AbstractObjectId
/*     */ {
/*     */   private static final long serialVersionUID = -201327512L;
/*     */   private Long _retailLocationId;
/*     */   private Long _taskId;
/*     */   private String _propertyCode;
/*     */   
/*     */   public EmployeeTaskPropertyId() {}
/*     */   
/*     */   public EmployeeTaskPropertyId(String argObjectIdValue) {
/*  23 */     setValue(argObjectIdValue);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Long getRetailLocationId() {
/*  31 */     return this._retailLocationId;
/*     */   }
/*     */   
/*     */   public void setRetailLocationId(Long argRetailLocationId) {
/*  35 */     this._retailLocationId = argRetailLocationId;
/*     */   }
/*     */   
/*     */   public Long getTaskId() {
/*  39 */     return this._taskId;
/*     */   }
/*     */   
/*     */   public void setTaskId(Long argTaskId) {
/*  43 */     this._taskId = argTaskId;
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
/*  66 */       setRetailLocationId(Long.valueOf(str));
/*  67 */       str = tokens[2];
/*     */       
/*  69 */       setTaskId(Long.valueOf(str));
/*  70 */       str = tokens[3];
/*     */       
/*  72 */       if ("null".equals(str)) {
/*  73 */         setPropertyCode((String)null);
/*     */       } else {
/*     */         
/*  76 */         setPropertyCode(str);
/*     */       }
/*     */     
/*  79 */     } catch (Exception ee) {
/*  80 */       throw new DtxException("An exception occured while parsing object id string: " + argObjectIdValue, ee);
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean equals(Object ob) {
/*  86 */     if (this == ob) {
/*  87 */       return true;
/*     */     }
/*  89 */     if (!(ob instanceof EmployeeTaskPropertyId)) {
/*  90 */       return false;
/*     */     }
/*  92 */     EmployeeTaskPropertyId other = (EmployeeTaskPropertyId)ob;
/*  93 */     return (((this._organizationId == null && other._organizationId == null) || (this._organizationId != null && this._organizationId
/*     */ 
/*     */       
/*  96 */       .equals(other._organizationId))) && ((this._retailLocationId == null && other._retailLocationId == null) || (this._retailLocationId != null && this._retailLocationId
/*     */ 
/*     */       
/*  99 */       .equals(other._retailLocationId))) && ((this._taskId == null && other._taskId == null) || (this._taskId != null && this._taskId
/*     */ 
/*     */       
/* 102 */       .equals(other._taskId))) && ((this._propertyCode == null && other._propertyCode == null) || (this._propertyCode != null && this._propertyCode
/*     */ 
/*     */       
/* 105 */       .equals(other._propertyCode))));
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public int hashCode() {
/* 111 */     return ((this._organizationId == null) ? 0 : this._organizationId
/* 112 */       .hashCode()) + ((this._retailLocationId == null) ? 0 : this._retailLocationId
/* 113 */       .hashCode()) + ((this._taskId == null) ? 0 : this._taskId
/* 114 */       .hashCode()) + ((this._propertyCode == null) ? 0 : this._propertyCode
/* 115 */       .hashCode());
/*     */   }
/*     */ 
/*     */   
/*     */   public String getDtxTypeName() {
/* 120 */     return "EmployeeTaskProperty";
/*     */   }
/*     */ 
/*     */   
/*     */   public String toString() {
/* 125 */     StringBuilder buff = new StringBuilder(48);
/*     */     
/* 127 */     return buff.append(
/* 128 */         String.valueOf(this._organizationId))
/* 129 */       .append("::").append(String.valueOf(this._retailLocationId))
/* 130 */       .append("::").append(String.valueOf(this._taskId))
/* 131 */       .append("::").append(this._propertyCode)
/* 132 */       .toString();
/*     */   }
/*     */   
/*     */   public boolean validate() {
/* 136 */     if (this._retailLocationId == null) {
/* 137 */       return false;
/*     */     }
/* 139 */     if (this._taskId == null) {
/* 140 */       return false;
/*     */     }
/* 142 */     if (this._propertyCode == null) {
/* 143 */       return false;
/*     */     }
/* 145 */     return true;
/*     */   }
/*     */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\hrs\EmployeeTaskPropertyId.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */