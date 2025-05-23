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
/*     */ public class EmployeeStorePropertyId
/*     */   extends AbstractObjectId
/*     */ {
/*     */   private static final long serialVersionUID = -2057097816L;
/*     */   private String _employeeId;
/*     */   private Long _retailLocationId;
/*     */   private Integer _employeeStoreSequence;
/*     */   private String _propertyCode;
/*     */   
/*     */   public EmployeeStorePropertyId() {}
/*     */   
/*     */   public EmployeeStorePropertyId(String argObjectIdValue) {
/*  23 */     setValue(argObjectIdValue);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getEmployeeId() {
/*  32 */     return this._employeeId;
/*     */   }
/*     */   
/*     */   public void setEmployeeId(String argEmployeeId) {
/*  36 */     this._employeeId = (argEmployeeId != null && MANAGE_CASE) ? argEmployeeId.toUpperCase() : argEmployeeId;
/*     */   }
/*     */   
/*     */   public Long getRetailLocationId() {
/*  40 */     return this._retailLocationId;
/*     */   }
/*     */   
/*     */   public void setRetailLocationId(Long argRetailLocationId) {
/*  44 */     this._retailLocationId = argRetailLocationId;
/*     */   }
/*     */   
/*     */   public Integer getEmployeeStoreSequence() {
/*  48 */     return this._employeeStoreSequence;
/*     */   }
/*     */   
/*     */   public void setEmployeeStoreSequence(Integer argEmployeeStoreSequence) {
/*  52 */     this._employeeStoreSequence = argEmployeeStoreSequence;
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
/*  76 */         setEmployeeId((String)null);
/*     */       } else {
/*     */         
/*  79 */         setEmployeeId(str);
/*     */       } 
/*  81 */       str = tokens[2];
/*     */       
/*  83 */       setRetailLocationId(Long.valueOf(str));
/*  84 */       str = tokens[3];
/*     */       
/*  86 */       setEmployeeStoreSequence(Integer.valueOf(str));
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
/* 106 */     if (!(ob instanceof EmployeeStorePropertyId)) {
/* 107 */       return false;
/*     */     }
/* 109 */     EmployeeStorePropertyId other = (EmployeeStorePropertyId)ob;
/* 110 */     return (((this._organizationId == null && other._organizationId == null) || (this._organizationId != null && this._organizationId
/*     */ 
/*     */       
/* 113 */       .equals(other._organizationId))) && ((this._employeeId == null && other._employeeId == null) || (this._employeeId != null && this._employeeId
/*     */ 
/*     */       
/* 116 */       .equals(other._employeeId))) && ((this._retailLocationId == null && other._retailLocationId == null) || (this._retailLocationId != null && this._retailLocationId
/*     */ 
/*     */       
/* 119 */       .equals(other._retailLocationId))) && ((this._employeeStoreSequence == null && other._employeeStoreSequence == null) || (this._employeeStoreSequence != null && this._employeeStoreSequence
/*     */ 
/*     */       
/* 122 */       .equals(other._employeeStoreSequence))) && ((this._propertyCode == null && other._propertyCode == null) || (this._propertyCode != null && this._propertyCode
/*     */ 
/*     */       
/* 125 */       .equals(other._propertyCode))));
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public int hashCode() {
/* 131 */     return ((this._organizationId == null) ? 0 : this._organizationId
/* 132 */       .hashCode()) + ((this._employeeId == null) ? 0 : this._employeeId
/* 133 */       .hashCode()) + ((this._retailLocationId == null) ? 0 : this._retailLocationId
/* 134 */       .hashCode()) + ((this._employeeStoreSequence == null) ? 0 : this._employeeStoreSequence
/* 135 */       .hashCode()) + ((this._propertyCode == null) ? 0 : this._propertyCode
/* 136 */       .hashCode());
/*     */   }
/*     */ 
/*     */   
/*     */   public String getDtxTypeName() {
/* 141 */     return "EmployeeStoreProperty";
/*     */   }
/*     */ 
/*     */   
/*     */   public String toString() {
/* 146 */     StringBuilder buff = new StringBuilder(60);
/*     */     
/* 148 */     return buff.append(
/* 149 */         String.valueOf(this._organizationId))
/* 150 */       .append("::").append(this._employeeId)
/* 151 */       .append("::").append(String.valueOf(this._retailLocationId))
/* 152 */       .append("::").append(String.valueOf(this._employeeStoreSequence))
/* 153 */       .append("::").append(this._propertyCode)
/* 154 */       .toString();
/*     */   }
/*     */   
/*     */   public boolean validate() {
/* 158 */     if (this._employeeId == null) {
/* 159 */       return false;
/*     */     }
/* 161 */     if (this._retailLocationId == null) {
/* 162 */       return false;
/*     */     }
/* 164 */     if (this._employeeStoreSequence == null) {
/* 165 */       return false;
/*     */     }
/* 167 */     if (this._propertyCode == null) {
/* 168 */       return false;
/*     */     }
/* 170 */     return true;
/*     */   }
/*     */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\hrs\EmployeeStorePropertyId.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */