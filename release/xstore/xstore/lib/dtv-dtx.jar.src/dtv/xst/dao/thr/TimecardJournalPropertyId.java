/*     */ package dtv.xst.dao.thr;
/*     */ 
/*     */ import dtv.data2.access.AbstractObjectId;
/*     */ import dtv.data2.access.exception.DtxException;
/*     */ import dtv.util.DtvDate;
/*     */ import dtv.util.StringUtils;
/*     */ import java.util.Date;
/*     */ 
/*     */ 
/*     */ public class TimecardJournalPropertyId
/*     */   extends AbstractObjectId
/*     */ {
/*     */   private static final long serialVersionUID = -1994885905L;
/*     */   private DtvDate _businessDate;
/*     */   private Long _retailLocationId;
/*     */   private Long _partyId;
/*     */   private Long _timecardEntryId;
/*     */   private Long _workstationId;
/*     */   private Long _timecardEntrySeq;
/*     */   private String _propertyCode;
/*     */   
/*     */   public TimecardJournalPropertyId() {}
/*     */   
/*     */   public TimecardJournalPropertyId(String argObjectIdValue) {
/*  25 */     setValue(argObjectIdValue);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Date getBusinessDate() {
/*  37 */     return (Date)this._businessDate;
/*     */   }
/*     */   
/*     */   public void setBusinessDate(Date argBusinessDate) {
/*  41 */     this._businessDate = (argBusinessDate == null || argBusinessDate instanceof DtvDate) ? (DtvDate)argBusinessDate : new DtvDate(argBusinessDate);
/*     */   }
/*     */ 
/*     */   
/*     */   public Long getRetailLocationId() {
/*  46 */     return this._retailLocationId;
/*     */   }
/*     */   
/*     */   public void setRetailLocationId(Long argRetailLocationId) {
/*  50 */     this._retailLocationId = argRetailLocationId;
/*     */   }
/*     */   
/*     */   public Long getPartyId() {
/*  54 */     return this._partyId;
/*     */   }
/*     */   
/*     */   public void setPartyId(Long argPartyId) {
/*  58 */     this._partyId = argPartyId;
/*     */   }
/*     */   
/*     */   public Long getTimecardEntryId() {
/*  62 */     return this._timecardEntryId;
/*     */   }
/*     */   
/*     */   public void setTimecardEntryId(Long argTimecardEntryId) {
/*  66 */     this._timecardEntryId = argTimecardEntryId;
/*     */   }
/*     */   
/*     */   public Long getWorkstationId() {
/*  70 */     return this._workstationId;
/*     */   }
/*     */   
/*     */   public void setWorkstationId(Long argWorkstationId) {
/*  74 */     this._workstationId = argWorkstationId;
/*     */   }
/*     */   
/*     */   public Long getTimecardEntrySeq() {
/*  78 */     return this._timecardEntrySeq;
/*     */   }
/*     */   
/*     */   public void setTimecardEntrySeq(Long argTimecardEntrySeq) {
/*  82 */     this._timecardEntrySeq = argTimecardEntrySeq;
/*     */   }
/*     */   
/*     */   public String getPropertyCode() {
/*  86 */     return this._propertyCode;
/*     */   }
/*     */   
/*     */   public void setPropertyCode(String argPropertyCode) {
/*  90 */     this._propertyCode = (argPropertyCode != null && MANAGE_CASE) ? argPropertyCode.toUpperCase() : argPropertyCode;
/*     */   }
/*     */   
/*     */   public void setValue(String argObjectIdValue) {
/*  94 */     String str = argObjectIdValue;
/*  95 */     if (StringUtils.isEmpty(str)) {
/*  96 */       throw new DtxException("argument passed to setValue() is null or empty - a valid value must be passed");
/*     */     }
/*     */     try {
/*  99 */       String[] tokens = str.split("::");
/* 100 */       str = tokens[0];
/*     */       
/* 102 */       setOrganizationId(Long.valueOf(str));
/* 103 */       str = tokens[1];
/*     */       
/* 105 */       if ("null".equals(str)) {
/* 106 */         setBusinessDate((Date)null);
/*     */       } else {
/*     */         
/* 109 */         setBusinessDate((Date)new DtvDate());
/* 110 */         this._businessDate.setTimeFromSerialization(Long.parseLong(str));
/*     */       } 
/* 112 */       str = tokens[2];
/*     */       
/* 114 */       setRetailLocationId(Long.valueOf(str));
/* 115 */       str = tokens[3];
/*     */       
/* 117 */       setPartyId(Long.valueOf(str));
/* 118 */       str = tokens[4];
/*     */       
/* 120 */       setTimecardEntryId(Long.valueOf(str));
/* 121 */       str = tokens[5];
/*     */       
/* 123 */       setWorkstationId(Long.valueOf(str));
/* 124 */       str = tokens[6];
/*     */       
/* 126 */       setTimecardEntrySeq(Long.valueOf(str));
/* 127 */       str = tokens[7];
/*     */       
/* 129 */       if ("null".equals(str)) {
/* 130 */         setPropertyCode((String)null);
/*     */       } else {
/*     */         
/* 133 */         setPropertyCode(str);
/*     */       }
/*     */     
/* 136 */     } catch (Exception ee) {
/* 137 */       throw new DtxException("An exception occured while parsing object id string: " + argObjectIdValue, ee);
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean equals(Object ob) {
/* 143 */     if (this == ob) {
/* 144 */       return true;
/*     */     }
/* 146 */     if (!(ob instanceof TimecardJournalPropertyId)) {
/* 147 */       return false;
/*     */     }
/* 149 */     TimecardJournalPropertyId other = (TimecardJournalPropertyId)ob;
/* 150 */     return (((this._organizationId == null && other._organizationId == null) || (this._organizationId != null && this._organizationId
/*     */ 
/*     */       
/* 153 */       .equals(other._organizationId))) && ((this._businessDate == null && other._businessDate == null) || (this._businessDate != null && this._businessDate
/*     */ 
/*     */       
/* 156 */       .equals(other._businessDate))) && ((this._retailLocationId == null && other._retailLocationId == null) || (this._retailLocationId != null && this._retailLocationId
/*     */ 
/*     */       
/* 159 */       .equals(other._retailLocationId))) && ((this._partyId == null && other._partyId == null) || (this._partyId != null && this._partyId
/*     */ 
/*     */       
/* 162 */       .equals(other._partyId))) && ((this._timecardEntryId == null && other._timecardEntryId == null) || (this._timecardEntryId != null && this._timecardEntryId
/*     */ 
/*     */       
/* 165 */       .equals(other._timecardEntryId))) && ((this._workstationId == null && other._workstationId == null) || (this._workstationId != null && this._workstationId
/*     */ 
/*     */       
/* 168 */       .equals(other._workstationId))) && ((this._timecardEntrySeq == null && other._timecardEntrySeq == null) || (this._timecardEntrySeq != null && this._timecardEntrySeq
/*     */ 
/*     */       
/* 171 */       .equals(other._timecardEntrySeq))) && ((this._propertyCode == null && other._propertyCode == null) || (this._propertyCode != null && this._propertyCode
/*     */ 
/*     */       
/* 174 */       .equals(other._propertyCode))));
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public int hashCode() {
/* 180 */     return ((this._organizationId == null) ? 0 : this._organizationId
/* 181 */       .hashCode()) + ((this._businessDate == null) ? 0 : this._businessDate
/* 182 */       .hashCode()) + ((this._retailLocationId == null) ? 0 : this._retailLocationId
/* 183 */       .hashCode()) + ((this._partyId == null) ? 0 : this._partyId
/* 184 */       .hashCode()) + ((this._timecardEntryId == null) ? 0 : this._timecardEntryId
/* 185 */       .hashCode()) + ((this._workstationId == null) ? 0 : this._workstationId
/* 186 */       .hashCode()) + ((this._timecardEntrySeq == null) ? 0 : this._timecardEntrySeq
/* 187 */       .hashCode()) + ((this._propertyCode == null) ? 0 : this._propertyCode
/* 188 */       .hashCode());
/*     */   }
/*     */ 
/*     */   
/*     */   public String getDtxTypeName() {
/* 193 */     return "TimecardJournalProperty";
/*     */   }
/*     */ 
/*     */   
/*     */   public String toString() {
/* 198 */     StringBuilder buff = new StringBuilder(96);
/*     */     
/* 200 */     return buff.append(
/* 201 */         String.valueOf(this._organizationId))
/* 202 */       .append("::").append((this._businessDate == null) ? "null" : String.valueOf(this._businessDate.getTimeSerializable()))
/* 203 */       .append("::").append(String.valueOf(this._retailLocationId))
/* 204 */       .append("::").append(String.valueOf(this._partyId))
/* 205 */       .append("::").append(String.valueOf(this._timecardEntryId))
/* 206 */       .append("::").append(String.valueOf(this._workstationId))
/* 207 */       .append("::").append(String.valueOf(this._timecardEntrySeq))
/* 208 */       .append("::").append(this._propertyCode)
/* 209 */       .toString();
/*     */   }
/*     */   
/*     */   public boolean validate() {
/* 213 */     if (this._businessDate == null) {
/* 214 */       return false;
/*     */     }
/* 216 */     if (this._retailLocationId == null) {
/* 217 */       return false;
/*     */     }
/* 219 */     if (this._partyId == null) {
/* 220 */       return false;
/*     */     }
/* 222 */     if (this._timecardEntryId == null) {
/* 223 */       return false;
/*     */     }
/* 225 */     if (this._workstationId == null) {
/* 226 */       return false;
/*     */     }
/* 228 */     if (this._timecardEntrySeq == null) {
/* 229 */       return false;
/*     */     }
/* 231 */     if (this._propertyCode == null) {
/* 232 */       return false;
/*     */     }
/* 234 */     return true;
/*     */   }
/*     */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\thr\TimecardJournalPropertyId.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */