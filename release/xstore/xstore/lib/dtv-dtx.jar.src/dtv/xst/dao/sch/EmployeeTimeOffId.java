/*     */ package dtv.xst.dao.sch;
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
/*     */ public class EmployeeTimeOffId
/*     */   extends AbstractObjectId
/*     */ {
/*     */   private static final long serialVersionUID = -1854604108L;
/*     */   private String _employeeId;
/*     */   private Long _timeOffSeq;
/*     */   
/*     */   public EmployeeTimeOffId() {}
/*     */   
/*     */   public EmployeeTimeOffId(String argObjectIdValue) {
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
/*     */   public Long getTimeOffSeq() {
/*  38 */     return this._timeOffSeq;
/*     */   }
/*     */   
/*     */   public void setTimeOffSeq(Long argTimeOffSeq) {
/*  42 */     this._timeOffSeq = argTimeOffSeq;
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
/*  65 */       setTimeOffSeq(Long.valueOf(str));
/*     */     }
/*  67 */     catch (Exception ee) {
/*  68 */       throw new DtxException("An exception occured while parsing object id string: " + argObjectIdValue, ee);
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean equals(Object ob) {
/*  74 */     if (this == ob) {
/*  75 */       return true;
/*     */     }
/*  77 */     if (!(ob instanceof EmployeeTimeOffId)) {
/*  78 */       return false;
/*     */     }
/*  80 */     EmployeeTimeOffId other = (EmployeeTimeOffId)ob;
/*  81 */     return (((this._organizationId == null && other._organizationId == null) || (this._organizationId != null && this._organizationId
/*     */ 
/*     */       
/*  84 */       .equals(other._organizationId))) && ((this._employeeId == null && other._employeeId == null) || (this._employeeId != null && this._employeeId
/*     */ 
/*     */       
/*  87 */       .equals(other._employeeId))) && ((this._timeOffSeq == null && other._timeOffSeq == null) || (this._timeOffSeq != null && this._timeOffSeq
/*     */ 
/*     */       
/*  90 */       .equals(other._timeOffSeq))));
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public int hashCode() {
/*  96 */     return ((this._organizationId == null) ? 0 : this._organizationId
/*  97 */       .hashCode()) + ((this._employeeId == null) ? 0 : this._employeeId
/*  98 */       .hashCode()) + ((this._timeOffSeq == null) ? 0 : this._timeOffSeq
/*  99 */       .hashCode());
/*     */   }
/*     */ 
/*     */   
/*     */   public String getDtxTypeName() {
/* 104 */     return "EmployeeTimeOff";
/*     */   }
/*     */ 
/*     */   
/*     */   public String toString() {
/* 109 */     StringBuilder buff = new StringBuilder(36);
/*     */     
/* 111 */     return buff.append(
/* 112 */         String.valueOf(this._organizationId))
/* 113 */       .append("::").append(this._employeeId)
/* 114 */       .append("::").append(String.valueOf(this._timeOffSeq))
/* 115 */       .toString();
/*     */   }
/*     */   
/*     */   public boolean validate() {
/* 119 */     if (this._employeeId == null) {
/* 120 */       return false;
/*     */     }
/* 122 */     if (this._timeOffSeq == null) {
/* 123 */       return false;
/*     */     }
/* 125 */     return true;
/*     */   }
/*     */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\sch\EmployeeTimeOffId.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */