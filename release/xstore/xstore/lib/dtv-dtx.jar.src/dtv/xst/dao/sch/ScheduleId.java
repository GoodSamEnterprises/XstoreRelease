/*     */ package dtv.xst.dao.sch;
/*     */ 
/*     */ import dtv.data2.access.AbstractObjectId;
/*     */ import dtv.data2.access.exception.DtxException;
/*     */ import dtv.util.DtvDate;
/*     */ import dtv.util.StringUtils;
/*     */ import java.util.Date;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class ScheduleId
/*     */   extends AbstractObjectId
/*     */ {
/*     */   private static final long serialVersionUID = -633276745L;
/*     */   private String _employeeId;
/*     */   private DtvDate _businessDate;
/*     */   private Long _scheduleSeq;
/*     */   
/*     */   public ScheduleId() {}
/*     */   
/*     */   public ScheduleId(String argObjectIdValue) {
/*  25 */     setValue(argObjectIdValue);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getEmployeeId() {
/*  33 */     return this._employeeId;
/*     */   }
/*     */   
/*     */   public void setEmployeeId(String argEmployeeId) {
/*  37 */     this._employeeId = (argEmployeeId != null && MANAGE_CASE) ? argEmployeeId.toUpperCase() : argEmployeeId;
/*     */   }
/*     */   
/*     */   public Date getBusinessDate() {
/*  41 */     return (Date)this._businessDate;
/*     */   }
/*     */   
/*     */   public void setBusinessDate(Date argBusinessDate) {
/*  45 */     this._businessDate = (argBusinessDate == null || argBusinessDate instanceof DtvDate) ? (DtvDate)argBusinessDate : new DtvDate(argBusinessDate);
/*     */   }
/*     */ 
/*     */   
/*     */   public Long getScheduleSeq() {
/*  50 */     return this._scheduleSeq;
/*     */   }
/*     */   
/*     */   public void setScheduleSeq(Long argScheduleSeq) {
/*  54 */     this._scheduleSeq = argScheduleSeq;
/*     */   }
/*     */   
/*     */   public void setValue(String argObjectIdValue) {
/*  58 */     String str = argObjectIdValue;
/*  59 */     if (StringUtils.isEmpty(str)) {
/*  60 */       throw new DtxException("argument passed to setValue() is null or empty - a valid value must be passed");
/*     */     }
/*     */     try {
/*  63 */       String[] tokens = str.split("::");
/*  64 */       str = tokens[0];
/*     */       
/*  66 */       setOrganizationId(Long.valueOf(str));
/*  67 */       str = tokens[1];
/*     */       
/*  69 */       if ("null".equals(str)) {
/*  70 */         setEmployeeId((String)null);
/*     */       } else {
/*     */         
/*  73 */         setEmployeeId(str);
/*     */       } 
/*  75 */       str = tokens[2];
/*     */       
/*  77 */       if ("null".equals(str)) {
/*  78 */         setBusinessDate((Date)null);
/*     */       } else {
/*     */         
/*  81 */         setBusinessDate((Date)new DtvDate());
/*  82 */         this._businessDate.setTimeFromSerialization(Long.parseLong(str));
/*     */       } 
/*  84 */       str = tokens[3];
/*     */       
/*  86 */       setScheduleSeq(Long.valueOf(str));
/*     */     }
/*  88 */     catch (Exception ee) {
/*  89 */       throw new DtxException("An exception occured while parsing object id string: " + argObjectIdValue, ee);
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean equals(Object ob) {
/*  95 */     if (this == ob) {
/*  96 */       return true;
/*     */     }
/*  98 */     if (!(ob instanceof ScheduleId)) {
/*  99 */       return false;
/*     */     }
/* 101 */     ScheduleId other = (ScheduleId)ob;
/* 102 */     return (((this._organizationId == null && other._organizationId == null) || (this._organizationId != null && this._organizationId
/*     */ 
/*     */       
/* 105 */       .equals(other._organizationId))) && ((this._employeeId == null && other._employeeId == null) || (this._employeeId != null && this._employeeId
/*     */ 
/*     */       
/* 108 */       .equals(other._employeeId))) && ((this._businessDate == null && other._businessDate == null) || (this._businessDate != null && this._businessDate
/*     */ 
/*     */       
/* 111 */       .equals(other._businessDate))) && ((this._scheduleSeq == null && other._scheduleSeq == null) || (this._scheduleSeq != null && this._scheduleSeq
/*     */ 
/*     */       
/* 114 */       .equals(other._scheduleSeq))));
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public int hashCode() {
/* 120 */     return ((this._organizationId == null) ? 0 : this._organizationId
/* 121 */       .hashCode()) + ((this._employeeId == null) ? 0 : this._employeeId
/* 122 */       .hashCode()) + ((this._businessDate == null) ? 0 : this._businessDate
/* 123 */       .hashCode()) + ((this._scheduleSeq == null) ? 0 : this._scheduleSeq
/* 124 */       .hashCode());
/*     */   }
/*     */ 
/*     */   
/*     */   public String getDtxTypeName() {
/* 129 */     return "Schedule";
/*     */   }
/*     */ 
/*     */   
/*     */   public String toString() {
/* 134 */     StringBuilder buff = new StringBuilder(48);
/*     */     
/* 136 */     return buff.append(
/* 137 */         String.valueOf(this._organizationId))
/* 138 */       .append("::").append(this._employeeId)
/* 139 */       .append("::").append((this._businessDate == null) ? "null" : String.valueOf(this._businessDate.getTimeSerializable()))
/* 140 */       .append("::").append(String.valueOf(this._scheduleSeq))
/* 141 */       .toString();
/*     */   }
/*     */   
/*     */   public boolean validate() {
/* 145 */     if (this._employeeId == null) {
/* 146 */       return false;
/*     */     }
/* 148 */     if (this._businessDate == null) {
/* 149 */       return false;
/*     */     }
/* 151 */     if (this._scheduleSeq == null) {
/* 152 */       return false;
/*     */     }
/* 154 */     return true;
/*     */   }
/*     */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\sch\ScheduleId.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */