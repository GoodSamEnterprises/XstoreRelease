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
/*     */ public class EmployeeTaskNoteId
/*     */   extends AbstractObjectId
/*     */ {
/*     */   private static final long serialVersionUID = 9048069L;
/*     */   private Long _retailLocationId;
/*     */   private Long _taskId;
/*     */   private Long _noteSequence;
/*     */   
/*     */   public EmployeeTaskNoteId() {}
/*     */   
/*     */   public EmployeeTaskNoteId(String argObjectIdValue) {
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
/*     */   public Long getNoteSequence() {
/*  47 */     return this._noteSequence;
/*     */   }
/*     */   
/*     */   public void setNoteSequence(Long argNoteSequence) {
/*  51 */     this._noteSequence = argNoteSequence;
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
/*  72 */       setNoteSequence(Long.valueOf(str));
/*     */     }
/*  74 */     catch (Exception ee) {
/*  75 */       throw new DtxException("An exception occured while parsing object id string: " + argObjectIdValue, ee);
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean equals(Object ob) {
/*  81 */     if (this == ob) {
/*  82 */       return true;
/*     */     }
/*  84 */     if (!(ob instanceof EmployeeTaskNoteId)) {
/*  85 */       return false;
/*     */     }
/*  87 */     EmployeeTaskNoteId other = (EmployeeTaskNoteId)ob;
/*  88 */     return (((this._organizationId == null && other._organizationId == null) || (this._organizationId != null && this._organizationId
/*     */ 
/*     */       
/*  91 */       .equals(other._organizationId))) && ((this._retailLocationId == null && other._retailLocationId == null) || (this._retailLocationId != null && this._retailLocationId
/*     */ 
/*     */       
/*  94 */       .equals(other._retailLocationId))) && ((this._taskId == null && other._taskId == null) || (this._taskId != null && this._taskId
/*     */ 
/*     */       
/*  97 */       .equals(other._taskId))) && ((this._noteSequence == null && other._noteSequence == null) || (this._noteSequence != null && this._noteSequence
/*     */ 
/*     */       
/* 100 */       .equals(other._noteSequence))));
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public int hashCode() {
/* 106 */     return ((this._organizationId == null) ? 0 : this._organizationId
/* 107 */       .hashCode()) + ((this._retailLocationId == null) ? 0 : this._retailLocationId
/* 108 */       .hashCode()) + ((this._taskId == null) ? 0 : this._taskId
/* 109 */       .hashCode()) + ((this._noteSequence == null) ? 0 : this._noteSequence
/* 110 */       .hashCode());
/*     */   }
/*     */ 
/*     */   
/*     */   public String getDtxTypeName() {
/* 115 */     return "EmployeeTaskNote";
/*     */   }
/*     */ 
/*     */   
/*     */   public String toString() {
/* 120 */     StringBuilder buff = new StringBuilder(48);
/*     */     
/* 122 */     return buff.append(
/* 123 */         String.valueOf(this._organizationId))
/* 124 */       .append("::").append(String.valueOf(this._retailLocationId))
/* 125 */       .append("::").append(String.valueOf(this._taskId))
/* 126 */       .append("::").append(String.valueOf(this._noteSequence))
/* 127 */       .toString();
/*     */   }
/*     */   
/*     */   public boolean validate() {
/* 131 */     if (this._retailLocationId == null) {
/* 132 */       return false;
/*     */     }
/* 134 */     if (this._taskId == null) {
/* 135 */       return false;
/*     */     }
/* 137 */     if (this._noteSequence == null) {
/* 138 */       return false;
/*     */     }
/* 140 */     return true;
/*     */   }
/*     */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\hrs\EmployeeTaskNoteId.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */