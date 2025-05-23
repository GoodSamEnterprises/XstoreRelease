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
/*     */ public class DealWeekPropertyId
/*     */   extends AbstractObjectId
/*     */ {
/*     */   private static final long serialVersionUID = 276168853L;
/*     */   private String _dealId;
/*     */   private String _dayCode;
/*     */   private DtvDate _startTime;
/*     */   private String _propertyCode;
/*     */   
/*     */   public DealWeekPropertyId() {}
/*     */   
/*     */   public DealWeekPropertyId(String argObjectIdValue) {
/*  25 */     setValue(argObjectIdValue);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getDealId() {
/*  34 */     return this._dealId;
/*     */   }
/*     */   
/*     */   public void setDealId(String argDealId) {
/*  38 */     this._dealId = (argDealId != null && MANAGE_CASE) ? argDealId.toUpperCase() : argDealId;
/*     */   }
/*     */   
/*     */   public String getDayCode() {
/*  42 */     return this._dayCode;
/*     */   }
/*     */   
/*     */   public void setDayCode(String argDayCode) {
/*  46 */     this._dayCode = (argDayCode != null && MANAGE_CASE) ? argDayCode.toUpperCase() : argDayCode;
/*     */   }
/*     */   
/*     */   public Date getStartTime() {
/*  50 */     return (Date)this._startTime;
/*     */   }
/*     */   
/*     */   public void setStartTime(Date argStartTime) {
/*  54 */     this._startTime = (argStartTime == null || argStartTime instanceof DtvDate) ? (DtvDate)argStartTime : new DtvDate(argStartTime);
/*     */   }
/*     */ 
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
/*  79 */         setDealId((String)null);
/*     */       } else {
/*     */         
/*  82 */         setDealId(str);
/*     */       } 
/*  84 */       str = tokens[2];
/*     */       
/*  86 */       if ("null".equals(str)) {
/*  87 */         setDayCode((String)null);
/*     */       } else {
/*     */         
/*  90 */         setDayCode(str);
/*     */       } 
/*  92 */       str = tokens[3];
/*     */       
/*  94 */       if ("null".equals(str)) {
/*  95 */         setStartTime((Date)null);
/*     */       } else {
/*     */         
/*  98 */         setStartTime((Date)new DtvDate());
/*  99 */         this._startTime.setTimeFromSerialization(Long.parseLong(str));
/*     */       } 
/* 101 */       str = tokens[4];
/*     */       
/* 103 */       if ("null".equals(str)) {
/* 104 */         setPropertyCode((String)null);
/*     */       } else {
/*     */         
/* 107 */         setPropertyCode(str);
/*     */       }
/*     */     
/* 110 */     } catch (Exception ee) {
/* 111 */       throw new DtxException("An exception occured while parsing object id string: " + argObjectIdValue, ee);
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean equals(Object ob) {
/* 117 */     if (this == ob) {
/* 118 */       return true;
/*     */     }
/* 120 */     if (!(ob instanceof DealWeekPropertyId)) {
/* 121 */       return false;
/*     */     }
/* 123 */     DealWeekPropertyId other = (DealWeekPropertyId)ob;
/* 124 */     return (((this._organizationId == null && other._organizationId == null) || (this._organizationId != null && this._organizationId
/*     */ 
/*     */       
/* 127 */       .equals(other._organizationId))) && ((this._dealId == null && other._dealId == null) || (this._dealId != null && this._dealId
/*     */ 
/*     */       
/* 130 */       .equals(other._dealId))) && ((this._dayCode == null && other._dayCode == null) || (this._dayCode != null && this._dayCode
/*     */ 
/*     */       
/* 133 */       .equals(other._dayCode))) && ((this._startTime == null && other._startTime == null) || (this._startTime != null && this._startTime
/*     */ 
/*     */       
/* 136 */       .equals(other._startTime))) && ((this._propertyCode == null && other._propertyCode == null) || (this._propertyCode != null && this._propertyCode
/*     */ 
/*     */       
/* 139 */       .equals(other._propertyCode))));
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public int hashCode() {
/* 145 */     return ((this._organizationId == null) ? 0 : this._organizationId
/* 146 */       .hashCode()) + ((this._dealId == null) ? 0 : this._dealId
/* 147 */       .hashCode()) + ((this._dayCode == null) ? 0 : this._dayCode
/* 148 */       .hashCode()) + ((this._startTime == null) ? 0 : this._startTime
/* 149 */       .hashCode()) + ((this._propertyCode == null) ? 0 : this._propertyCode
/* 150 */       .hashCode());
/*     */   }
/*     */ 
/*     */   
/*     */   public String getDtxTypeName() {
/* 155 */     return "DealWeekProperty";
/*     */   }
/*     */ 
/*     */   
/*     */   public String toString() {
/* 160 */     StringBuilder buff = new StringBuilder(60);
/*     */     
/* 162 */     return buff.append(
/* 163 */         String.valueOf(this._organizationId))
/* 164 */       .append("::").append(this._dealId)
/* 165 */       .append("::").append(this._dayCode)
/* 166 */       .append("::").append((this._startTime == null) ? "null" : String.valueOf(this._startTime.getTimeSerializable()))
/* 167 */       .append("::").append(this._propertyCode)
/* 168 */       .toString();
/*     */   }
/*     */   
/*     */   public boolean validate() {
/* 172 */     if (this._dealId == null) {
/* 173 */       return false;
/*     */     }
/* 175 */     if (this._dayCode == null) {
/* 176 */       return false;
/*     */     }
/* 178 */     if (this._startTime == null) {
/* 179 */       return false;
/*     */     }
/* 181 */     if (this._propertyCode == null) {
/* 182 */       return false;
/*     */     }
/* 184 */     return true;
/*     */   }
/*     */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\prc\DealWeekPropertyId.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */