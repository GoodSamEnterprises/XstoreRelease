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
/*     */ public class EmployeeAnswersId
/*     */   extends AbstractObjectId
/*     */ {
/*     */   private static final long serialVersionUID = -1388060217L;
/*     */   private String _employeeId;
/*     */   private String _challengeCode;
/*     */   
/*     */   public EmployeeAnswersId() {}
/*     */   
/*     */   public EmployeeAnswersId(String argObjectIdValue) {
/*  23 */     setValue(argObjectIdValue);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getEmployeeId() {
/*  30 */     return this._employeeId;
/*     */   }
/*     */   
/*     */   public void setEmployeeId(String argEmployeeId) {
/*  34 */     this._employeeId = (argEmployeeId != null && MANAGE_CASE) ? argEmployeeId.toUpperCase() : argEmployeeId;
/*     */   }
/*     */   
/*     */   public String getChallengeCode() {
/*  38 */     return this._challengeCode;
/*     */   }
/*     */   
/*     */   public void setChallengeCode(String argChallengeCode) {
/*  42 */     this._challengeCode = (argChallengeCode != null && MANAGE_CASE) ? argChallengeCode.toUpperCase() : argChallengeCode;
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
/*  58 */         setEmployeeId((String)null);
/*     */       } else {
/*     */         
/*  61 */         setEmployeeId(str);
/*     */       } 
/*  63 */       str = tokens[2];
/*     */       
/*  65 */       if ("null".equals(str)) {
/*  66 */         setChallengeCode((String)null);
/*     */       } else {
/*     */         
/*  69 */         setChallengeCode(str);
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
/*  82 */     if (!(ob instanceof EmployeeAnswersId)) {
/*  83 */       return false;
/*     */     }
/*  85 */     EmployeeAnswersId other = (EmployeeAnswersId)ob;
/*  86 */     return (((this._organizationId == null && other._organizationId == null) || (this._organizationId != null && this._organizationId
/*     */ 
/*     */       
/*  89 */       .equals(other._organizationId))) && ((this._employeeId == null && other._employeeId == null) || (this._employeeId != null && this._employeeId
/*     */ 
/*     */       
/*  92 */       .equals(other._employeeId))) && ((this._challengeCode == null && other._challengeCode == null) || (this._challengeCode != null && this._challengeCode
/*     */ 
/*     */       
/*  95 */       .equals(other._challengeCode))));
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public int hashCode() {
/* 101 */     return ((this._organizationId == null) ? 0 : this._organizationId
/* 102 */       .hashCode()) + ((this._employeeId == null) ? 0 : this._employeeId
/* 103 */       .hashCode()) + ((this._challengeCode == null) ? 0 : this._challengeCode
/* 104 */       .hashCode());
/*     */   }
/*     */ 
/*     */   
/*     */   public String getDtxTypeName() {
/* 109 */     return "EmployeeAnswers";
/*     */   }
/*     */ 
/*     */   
/*     */   public String toString() {
/* 114 */     StringBuilder buff = new StringBuilder(36);
/*     */     
/* 116 */     return buff.append(
/* 117 */         String.valueOf(this._organizationId))
/* 118 */       .append("::").append(this._employeeId)
/* 119 */       .append("::").append(this._challengeCode)
/* 120 */       .toString();
/*     */   }
/*     */   
/*     */   public boolean validate() {
/* 124 */     if (this._employeeId == null) {
/* 125 */       return false;
/*     */     }
/* 127 */     if (this._challengeCode == null) {
/* 128 */       return false;
/*     */     }
/* 130 */     return true;
/*     */   }
/*     */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\hrs\EmployeeAnswersId.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */