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
/*     */ public class SchedulePropertyId
/*     */   extends AbstractObjectId
/*     */ {
/*     */   private static final long serialVersionUID = 578720172L;
/*     */   private String _employeeId;
/*     */   private DtvDate _businessDate;
/*     */   private Long _scheduleSeq;
/*     */   private String _propertyCode;
/*     */   
/*     */   public SchedulePropertyId() {}
/*     */   
/*     */   public SchedulePropertyId(String argObjectIdValue) {
/*  25 */     setValue(argObjectIdValue);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getEmployeeId() {
/*  34 */     return this._employeeId;
/*     */   }
/*     */   
/*     */   public void setEmployeeId(String argEmployeeId) {
/*  38 */     this._employeeId = (argEmployeeId != null && MANAGE_CASE) ? argEmployeeId.toUpperCase() : argEmployeeId;
/*     */   }
/*     */   
/*     */   public Date getBusinessDate() {
/*  42 */     return (Date)this._businessDate;
/*     */   }
/*     */   
/*     */   public void setBusinessDate(Date argBusinessDate) {
/*  46 */     this._businessDate = (argBusinessDate == null || argBusinessDate instanceof DtvDate) ? (DtvDate)argBusinessDate : new DtvDate(argBusinessDate);
/*     */   }
/*     */ 
/*     */   
/*     */   public Long getScheduleSeq() {
/*  51 */     return this._scheduleSeq;
/*     */   }
/*     */   
/*     */   public void setScheduleSeq(Long argScheduleSeq) {
/*  55 */     this._scheduleSeq = argScheduleSeq;
/*     */   }
/*     */   
/*     */   public String getPropertyCode() {
/*  59 */     return this._propertyCode;
/*     */   }
/*     */   
/*     */   public void setPropertyCode(String argPropertyCode) {
/*  63 */     this._propertyCode = (argPropertyCode != null && MANAGE_CASE) ? argPropertyCode.toUpperCase() : argPropertyCode;
/*     */   }
/*     */   
/*     */   public void setValue(String argObjectIdValue) {
/*  67 */     String str = argObjectIdValue;
/*  68 */     if (StringUtils.isEmpty(str)) {
/*  69 */       throw new DtxException("argument passed to setValue() is null or empty - a valid value must be passed");
/*     */     }
/*     */     try {
/*  72 */       String[] tokens = str.split("::");
/*  73 */       str = tokens[0];
/*     */       
/*  75 */       setOrganizationId(Long.valueOf(str));
/*  76 */       str = tokens[1];
/*     */       
/*  78 */       if ("null".equals(str)) {
/*  79 */         setEmployeeId((String)null);
/*     */       } else {
/*     */         
/*  82 */         setEmployeeId(str);
/*     */       } 
/*  84 */       str = tokens[2];
/*     */       
/*  86 */       if ("null".equals(str)) {
/*  87 */         setBusinessDate((Date)null);
/*     */       } else {
/*     */         
/*  90 */         setBusinessDate((Date)new DtvDate());
/*  91 */         this._businessDate.setTimeFromSerialization(Long.parseLong(str));
/*     */       } 
/*  93 */       str = tokens[3];
/*     */       
/*  95 */       setScheduleSeq(Long.valueOf(str));
/*  96 */       str = tokens[4];
/*     */       
/*  98 */       if ("null".equals(str)) {
/*  99 */         setPropertyCode((String)null);
/*     */       } else {
/*     */         
/* 102 */         setPropertyCode(str);
/*     */       }
/*     */     
/* 105 */     } catch (Exception ee) {
/* 106 */       throw new DtxException("An exception occured while parsing object id string: " + argObjectIdValue, ee);
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean equals(Object ob) {
/* 112 */     if (this == ob) {
/* 113 */       return true;
/*     */     }
/* 115 */     if (!(ob instanceof SchedulePropertyId)) {
/* 116 */       return false;
/*     */     }
/* 118 */     SchedulePropertyId other = (SchedulePropertyId)ob;
/* 119 */     return (((this._organizationId == null && other._organizationId == null) || (this._organizationId != null && this._organizationId
/*     */ 
/*     */       
/* 122 */       .equals(other._organizationId))) && ((this._employeeId == null && other._employeeId == null) || (this._employeeId != null && this._employeeId
/*     */ 
/*     */       
/* 125 */       .equals(other._employeeId))) && ((this._businessDate == null && other._businessDate == null) || (this._businessDate != null && this._businessDate
/*     */ 
/*     */       
/* 128 */       .equals(other._businessDate))) && ((this._scheduleSeq == null && other._scheduleSeq == null) || (this._scheduleSeq != null && this._scheduleSeq
/*     */ 
/*     */       
/* 131 */       .equals(other._scheduleSeq))) && ((this._propertyCode == null && other._propertyCode == null) || (this._propertyCode != null && this._propertyCode
/*     */ 
/*     */       
/* 134 */       .equals(other._propertyCode))));
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public int hashCode() {
/* 140 */     return ((this._organizationId == null) ? 0 : this._organizationId
/* 141 */       .hashCode()) + ((this._employeeId == null) ? 0 : this._employeeId
/* 142 */       .hashCode()) + ((this._businessDate == null) ? 0 : this._businessDate
/* 143 */       .hashCode()) + ((this._scheduleSeq == null) ? 0 : this._scheduleSeq
/* 144 */       .hashCode()) + ((this._propertyCode == null) ? 0 : this._propertyCode
/* 145 */       .hashCode());
/*     */   }
/*     */ 
/*     */   
/*     */   public String getDtxTypeName() {
/* 150 */     return "ScheduleProperty";
/*     */   }
/*     */ 
/*     */   
/*     */   public String toString() {
/* 155 */     StringBuilder buff = new StringBuilder(60);
/*     */     
/* 157 */     return buff.append(
/* 158 */         String.valueOf(this._organizationId))
/* 159 */       .append("::").append(this._employeeId)
/* 160 */       .append("::").append((this._businessDate == null) ? "null" : String.valueOf(this._businessDate.getTimeSerializable()))
/* 161 */       .append("::").append(String.valueOf(this._scheduleSeq))
/* 162 */       .append("::").append(this._propertyCode)
/* 163 */       .toString();
/*     */   }
/*     */   
/*     */   public boolean validate() {
/* 167 */     if (this._employeeId == null) {
/* 168 */       return false;
/*     */     }
/* 170 */     if (this._businessDate == null) {
/* 171 */       return false;
/*     */     }
/* 173 */     if (this._scheduleSeq == null) {
/* 174 */       return false;
/*     */     }
/* 176 */     if (this._propertyCode == null) {
/* 177 */       return false;
/*     */     }
/* 179 */     return true;
/*     */   }
/*     */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\sch\SchedulePropertyId.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */