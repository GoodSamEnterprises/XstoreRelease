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
/*     */ public class EmployeeNoteId
/*     */   extends AbstractObjectId
/*     */ {
/*     */   private static final long serialVersionUID = -1564190752L;
/*     */   private String _employeeId;
/*     */   private Long _noteSequence;
/*     */   
/*     */   public EmployeeNoteId() {}
/*     */   
/*     */   public EmployeeNoteId(String argObjectIdValue) {
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
/*     */   public Long getNoteSequence() {
/*  38 */     return this._noteSequence;
/*     */   }
/*     */   
/*     */   public void setNoteSequence(Long argNoteSequence) {
/*  42 */     this._noteSequence = argNoteSequence;
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
/*  65 */       setNoteSequence(Long.valueOf(str));
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
/*  77 */     if (!(ob instanceof EmployeeNoteId)) {
/*  78 */       return false;
/*     */     }
/*  80 */     EmployeeNoteId other = (EmployeeNoteId)ob;
/*  81 */     return (((this._organizationId == null && other._organizationId == null) || (this._organizationId != null && this._organizationId
/*     */ 
/*     */       
/*  84 */       .equals(other._organizationId))) && ((this._employeeId == null && other._employeeId == null) || (this._employeeId != null && this._employeeId
/*     */ 
/*     */       
/*  87 */       .equals(other._employeeId))) && ((this._noteSequence == null && other._noteSequence == null) || (this._noteSequence != null && this._noteSequence
/*     */ 
/*     */       
/*  90 */       .equals(other._noteSequence))));
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public int hashCode() {
/*  96 */     return ((this._organizationId == null) ? 0 : this._organizationId
/*  97 */       .hashCode()) + ((this._employeeId == null) ? 0 : this._employeeId
/*  98 */       .hashCode()) + ((this._noteSequence == null) ? 0 : this._noteSequence
/*  99 */       .hashCode());
/*     */   }
/*     */ 
/*     */   
/*     */   public String getDtxTypeName() {
/* 104 */     return "EmployeeNote";
/*     */   }
/*     */ 
/*     */   
/*     */   public String toString() {
/* 109 */     StringBuilder buff = new StringBuilder(36);
/*     */     
/* 111 */     return buff.append(
/* 112 */         String.valueOf(this._organizationId))
/* 113 */       .append("::").append(this._employeeId)
/* 114 */       .append("::").append(String.valueOf(this._noteSequence))
/* 115 */       .toString();
/*     */   }
/*     */   
/*     */   public boolean validate() {
/* 119 */     if (this._employeeId == null) {
/* 120 */       return false;
/*     */     }
/* 122 */     if (this._noteSequence == null) {
/* 123 */       return false;
/*     */     }
/* 125 */     return true;
/*     */   }
/*     */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\hrs\EmployeeNoteId.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */