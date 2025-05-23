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
/*     */ public class EmployeeAnswersPropertyId
/*     */   extends AbstractObjectId
/*     */ {
/*     */   private static final long serialVersionUID = -374510404L;
/*     */   private String _employeeId;
/*     */   private String _challengeCode;
/*     */   private String _propertyCode;
/*     */   
/*     */   public EmployeeAnswersPropertyId() {}
/*     */   
/*     */   public EmployeeAnswersPropertyId(String argObjectIdValue) {
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
/*     */   public String getChallengeCode() {
/*  39 */     return this._challengeCode;
/*     */   }
/*     */   
/*     */   public void setChallengeCode(String argChallengeCode) {
/*  43 */     this._challengeCode = (argChallengeCode != null && MANAGE_CASE) ? argChallengeCode.toUpperCase() : argChallengeCode;
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
/*  67 */         setEmployeeId((String)null);
/*     */       } else {
/*     */         
/*  70 */         setEmployeeId(str);
/*     */       } 
/*  72 */       str = tokens[2];
/*     */       
/*  74 */       if ("null".equals(str)) {
/*  75 */         setChallengeCode((String)null);
/*     */       } else {
/*     */         
/*  78 */         setChallengeCode(str);
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
/*  99 */     if (!(ob instanceof EmployeeAnswersPropertyId)) {
/* 100 */       return false;
/*     */     }
/* 102 */     EmployeeAnswersPropertyId other = (EmployeeAnswersPropertyId)ob;
/* 103 */     return (((this._organizationId == null && other._organizationId == null) || (this._organizationId != null && this._organizationId
/*     */ 
/*     */       
/* 106 */       .equals(other._organizationId))) && ((this._employeeId == null && other._employeeId == null) || (this._employeeId != null && this._employeeId
/*     */ 
/*     */       
/* 109 */       .equals(other._employeeId))) && ((this._challengeCode == null && other._challengeCode == null) || (this._challengeCode != null && this._challengeCode
/*     */ 
/*     */       
/* 112 */       .equals(other._challengeCode))) && ((this._propertyCode == null && other._propertyCode == null) || (this._propertyCode != null && this._propertyCode
/*     */ 
/*     */       
/* 115 */       .equals(other._propertyCode))));
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public int hashCode() {
/* 121 */     return ((this._organizationId == null) ? 0 : this._organizationId
/* 122 */       .hashCode()) + ((this._employeeId == null) ? 0 : this._employeeId
/* 123 */       .hashCode()) + ((this._challengeCode == null) ? 0 : this._challengeCode
/* 124 */       .hashCode()) + ((this._propertyCode == null) ? 0 : this._propertyCode
/* 125 */       .hashCode());
/*     */   }
/*     */ 
/*     */   
/*     */   public String getDtxTypeName() {
/* 130 */     return "EmployeeAnswersProperty";
/*     */   }
/*     */ 
/*     */   
/*     */   public String toString() {
/* 135 */     StringBuilder buff = new StringBuilder(48);
/*     */     
/* 137 */     return buff.append(
/* 138 */         String.valueOf(this._organizationId))
/* 139 */       .append("::").append(this._employeeId)
/* 140 */       .append("::").append(this._challengeCode)
/* 141 */       .append("::").append(this._propertyCode)
/* 142 */       .toString();
/*     */   }
/*     */   
/*     */   public boolean validate() {
/* 146 */     if (this._employeeId == null) {
/* 147 */       return false;
/*     */     }
/* 149 */     if (this._challengeCode == null) {
/* 150 */       return false;
/*     */     }
/* 152 */     if (this._propertyCode == null) {
/* 153 */       return false;
/*     */     }
/* 155 */     return true;
/*     */   }
/*     */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\hrs\EmployeeAnswersPropertyId.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */