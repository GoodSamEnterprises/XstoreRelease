/*     */ package dtv.xst.dao.prc;
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
/*     */ public class DealWeekId
/*     */   extends AbstractObjectId
/*     */ {
/*     */   private static final long serialVersionUID = 575037088L;
/*     */   private String _dealId;
/*     */   private String _dayCode;
/*     */   private DtvDate _startTime;
/*     */   
/*     */   public DealWeekId() {}
/*     */   
/*     */   public DealWeekId(String argObjectIdValue) {
/*  25 */     setValue(argObjectIdValue);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getDealId() {
/*  33 */     return this._dealId;
/*     */   }
/*     */   
/*     */   public void setDealId(String argDealId) {
/*  37 */     this._dealId = (argDealId != null && MANAGE_CASE) ? argDealId.toUpperCase() : argDealId;
/*     */   }
/*     */   
/*     */   public String getDayCode() {
/*  41 */     return this._dayCode;
/*     */   }
/*     */   
/*     */   public void setDayCode(String argDayCode) {
/*  45 */     this._dayCode = (argDayCode != null && MANAGE_CASE) ? argDayCode.toUpperCase() : argDayCode;
/*     */   }
/*     */   
/*     */   public Date getStartTime() {
/*  49 */     return (Date)this._startTime;
/*     */   }
/*     */   
/*     */   public void setStartTime(Date argStartTime) {
/*  53 */     this._startTime = (argStartTime == null || argStartTime instanceof DtvDate) ? (DtvDate)argStartTime : new DtvDate(argStartTime);
/*     */   }
/*     */ 
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
/*  70 */         setDealId((String)null);
/*     */       } else {
/*     */         
/*  73 */         setDealId(str);
/*     */       } 
/*  75 */       str = tokens[2];
/*     */       
/*  77 */       if ("null".equals(str)) {
/*  78 */         setDayCode((String)null);
/*     */       } else {
/*     */         
/*  81 */         setDayCode(str);
/*     */       } 
/*  83 */       str = tokens[3];
/*     */       
/*  85 */       if ("null".equals(str)) {
/*  86 */         setStartTime((Date)null);
/*     */       } else {
/*     */         
/*  89 */         setStartTime((Date)new DtvDate());
/*  90 */         this._startTime.setTimeFromSerialization(Long.parseLong(str));
/*     */       }
/*     */     
/*  93 */     } catch (Exception ee) {
/*  94 */       throw new DtxException("An exception occured while parsing object id string: " + argObjectIdValue, ee);
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean equals(Object ob) {
/* 100 */     if (this == ob) {
/* 101 */       return true;
/*     */     }
/* 103 */     if (!(ob instanceof DealWeekId)) {
/* 104 */       return false;
/*     */     }
/* 106 */     DealWeekId other = (DealWeekId)ob;
/* 107 */     return (((this._organizationId == null && other._organizationId == null) || (this._organizationId != null && this._organizationId
/*     */ 
/*     */       
/* 110 */       .equals(other._organizationId))) && ((this._dealId == null && other._dealId == null) || (this._dealId != null && this._dealId
/*     */ 
/*     */       
/* 113 */       .equals(other._dealId))) && ((this._dayCode == null && other._dayCode == null) || (this._dayCode != null && this._dayCode
/*     */ 
/*     */       
/* 116 */       .equals(other._dayCode))) && ((this._startTime == null && other._startTime == null) || (this._startTime != null && this._startTime
/*     */ 
/*     */       
/* 119 */       .equals(other._startTime))));
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public int hashCode() {
/* 125 */     return ((this._organizationId == null) ? 0 : this._organizationId
/* 126 */       .hashCode()) + ((this._dealId == null) ? 0 : this._dealId
/* 127 */       .hashCode()) + ((this._dayCode == null) ? 0 : this._dayCode
/* 128 */       .hashCode()) + ((this._startTime == null) ? 0 : this._startTime
/* 129 */       .hashCode());
/*     */   }
/*     */ 
/*     */   
/*     */   public String getDtxTypeName() {
/* 134 */     return "DealWeek";
/*     */   }
/*     */ 
/*     */   
/*     */   public String toString() {
/* 139 */     StringBuilder buff = new StringBuilder(48);
/*     */     
/* 141 */     return buff.append(
/* 142 */         String.valueOf(this._organizationId))
/* 143 */       .append("::").append(this._dealId)
/* 144 */       .append("::").append(this._dayCode)
/* 145 */       .append("::").append((this._startTime == null) ? "null" : String.valueOf(this._startTime.getTimeSerializable()))
/* 146 */       .toString();
/*     */   }
/*     */   
/*     */   public boolean validate() {
/* 150 */     if (this._dealId == null) {
/* 151 */       return false;
/*     */     }
/* 153 */     if (this._dayCode == null) {
/* 154 */       return false;
/*     */     }
/* 156 */     if (this._startTime == null) {
/* 157 */       return false;
/*     */     }
/* 159 */     return true;
/*     */   }
/*     */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\prc\DealWeekId.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */