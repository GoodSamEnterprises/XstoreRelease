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
/*     */ public class EmployeeTaskNotePropertyId
/*     */   extends AbstractObjectId
/*     */ {
/*     */   private static final long serialVersionUID = -881296134L;
/*     */   private Long _retailLocationId;
/*     */   private Long _taskId;
/*     */   private Long _noteSequence;
/*     */   private String _propertyCode;
/*     */   
/*     */   public EmployeeTaskNotePropertyId() {}
/*     */   
/*     */   public EmployeeTaskNotePropertyId(String argObjectIdValue) {
/*  23 */     setValue(argObjectIdValue);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Long getRetailLocationId() {
/*  32 */     return this._retailLocationId;
/*     */   }
/*     */   
/*     */   public void setRetailLocationId(Long argRetailLocationId) {
/*  36 */     this._retailLocationId = argRetailLocationId;
/*     */   }
/*     */   
/*     */   public Long getTaskId() {
/*  40 */     return this._taskId;
/*     */   }
/*     */   
/*     */   public void setTaskId(Long argTaskId) {
/*  44 */     this._taskId = argTaskId;
/*     */   }
/*     */   
/*     */   public Long getNoteSequence() {
/*  48 */     return this._noteSequence;
/*     */   }
/*     */   
/*     */   public void setNoteSequence(Long argNoteSequence) {
/*  52 */     this._noteSequence = argNoteSequence;
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
/*  75 */       setRetailLocationId(Long.valueOf(str));
/*  76 */       str = tokens[2];
/*     */       
/*  78 */       setTaskId(Long.valueOf(str));
/*  79 */       str = tokens[3];
/*     */       
/*  81 */       setNoteSequence(Long.valueOf(str));
/*  82 */       str = tokens[4];
/*     */       
/*  84 */       if ("null".equals(str)) {
/*  85 */         setPropertyCode((String)null);
/*     */       } else {
/*     */         
/*  88 */         setPropertyCode(str);
/*     */       }
/*     */     
/*  91 */     } catch (Exception ee) {
/*  92 */       throw new DtxException("An exception occured while parsing object id string: " + argObjectIdValue, ee);
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean equals(Object ob) {
/*  98 */     if (this == ob) {
/*  99 */       return true;
/*     */     }
/* 101 */     if (!(ob instanceof EmployeeTaskNotePropertyId)) {
/* 102 */       return false;
/*     */     }
/* 104 */     EmployeeTaskNotePropertyId other = (EmployeeTaskNotePropertyId)ob;
/* 105 */     return (((this._organizationId == null && other._organizationId == null) || (this._organizationId != null && this._organizationId
/*     */ 
/*     */       
/* 108 */       .equals(other._organizationId))) && ((this._retailLocationId == null && other._retailLocationId == null) || (this._retailLocationId != null && this._retailLocationId
/*     */ 
/*     */       
/* 111 */       .equals(other._retailLocationId))) && ((this._taskId == null && other._taskId == null) || (this._taskId != null && this._taskId
/*     */ 
/*     */       
/* 114 */       .equals(other._taskId))) && ((this._noteSequence == null && other._noteSequence == null) || (this._noteSequence != null && this._noteSequence
/*     */ 
/*     */       
/* 117 */       .equals(other._noteSequence))) && ((this._propertyCode == null && other._propertyCode == null) || (this._propertyCode != null && this._propertyCode
/*     */ 
/*     */       
/* 120 */       .equals(other._propertyCode))));
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public int hashCode() {
/* 126 */     return ((this._organizationId == null) ? 0 : this._organizationId
/* 127 */       .hashCode()) + ((this._retailLocationId == null) ? 0 : this._retailLocationId
/* 128 */       .hashCode()) + ((this._taskId == null) ? 0 : this._taskId
/* 129 */       .hashCode()) + ((this._noteSequence == null) ? 0 : this._noteSequence
/* 130 */       .hashCode()) + ((this._propertyCode == null) ? 0 : this._propertyCode
/* 131 */       .hashCode());
/*     */   }
/*     */ 
/*     */   
/*     */   public String getDtxTypeName() {
/* 136 */     return "EmployeeTaskNoteProperty";
/*     */   }
/*     */ 
/*     */   
/*     */   public String toString() {
/* 141 */     StringBuilder buff = new StringBuilder(60);
/*     */     
/* 143 */     return buff.append(
/* 144 */         String.valueOf(this._organizationId))
/* 145 */       .append("::").append(String.valueOf(this._retailLocationId))
/* 146 */       .append("::").append(String.valueOf(this._taskId))
/* 147 */       .append("::").append(String.valueOf(this._noteSequence))
/* 148 */       .append("::").append(this._propertyCode)
/* 149 */       .toString();
/*     */   }
/*     */   
/*     */   public boolean validate() {
/* 153 */     if (this._retailLocationId == null) {
/* 154 */       return false;
/*     */     }
/* 156 */     if (this._taskId == null) {
/* 157 */       return false;
/*     */     }
/* 159 */     if (this._noteSequence == null) {
/* 160 */       return false;
/*     */     }
/* 162 */     if (this._propertyCode == null) {
/* 163 */       return false;
/*     */     }
/* 165 */     return true;
/*     */   }
/*     */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\hrs\EmployeeTaskNotePropertyId.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */