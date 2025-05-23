/*     */ package dtv.xst.dao.thr;
/*     */ 
/*     */ import dtv.data2.access.AbstractObjectId;
/*     */ import dtv.data2.access.exception.DtxException;
/*     */ import dtv.util.DtvDate;
/*     */ import dtv.util.StringUtils;
/*     */ import java.util.Date;
/*     */ 
/*     */ 
/*     */ 
/*     */ public class TimecardJournalId
/*     */   extends AbstractObjectId
/*     */ {
/*     */   private static final long serialVersionUID = -2077766406L;
/*     */   private DtvDate _businessDate;
/*     */   private Long _retailLocationId;
/*     */   private Long _partyId;
/*     */   private Long _timecardEntryId;
/*     */   private Long _workstationId;
/*     */   private Long _timecardEntrySeq;
/*     */   
/*     */   public TimecardJournalId() {}
/*     */   
/*     */   public TimecardJournalId(String argObjectIdValue) {
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
/*     */   public Date getBusinessDate() {
/*  36 */     return (Date)this._businessDate;
/*     */   }
/*     */   
/*     */   public void setBusinessDate(Date argBusinessDate) {
/*  40 */     this._businessDate = (argBusinessDate == null || argBusinessDate instanceof DtvDate) ? (DtvDate)argBusinessDate : new DtvDate(argBusinessDate);
/*     */   }
/*     */ 
/*     */   
/*     */   public Long getRetailLocationId() {
/*  45 */     return this._retailLocationId;
/*     */   }
/*     */   
/*     */   public void setRetailLocationId(Long argRetailLocationId) {
/*  49 */     this._retailLocationId = argRetailLocationId;
/*     */   }
/*     */   
/*     */   public Long getPartyId() {
/*  53 */     return this._partyId;
/*     */   }
/*     */   
/*     */   public void setPartyId(Long argPartyId) {
/*  57 */     this._partyId = argPartyId;
/*     */   }
/*     */   
/*     */   public Long getTimecardEntryId() {
/*  61 */     return this._timecardEntryId;
/*     */   }
/*     */   
/*     */   public void setTimecardEntryId(Long argTimecardEntryId) {
/*  65 */     this._timecardEntryId = argTimecardEntryId;
/*     */   }
/*     */   
/*     */   public Long getWorkstationId() {
/*  69 */     return this._workstationId;
/*     */   }
/*     */   
/*     */   public void setWorkstationId(Long argWorkstationId) {
/*  73 */     this._workstationId = argWorkstationId;
/*     */   }
/*     */   
/*     */   public Long getTimecardEntrySeq() {
/*  77 */     return this._timecardEntrySeq;
/*     */   }
/*     */   
/*     */   public void setTimecardEntrySeq(Long argTimecardEntrySeq) {
/*  81 */     this._timecardEntrySeq = argTimecardEntrySeq;
/*     */   }
/*     */   
/*     */   public void setValue(String argObjectIdValue) {
/*  85 */     String str = argObjectIdValue;
/*  86 */     if (StringUtils.isEmpty(str)) {
/*  87 */       throw new DtxException("argument passed to setValue() is null or empty - a valid value must be passed");
/*     */     }
/*     */     try {
/*  90 */       String[] tokens = str.split("::");
/*  91 */       str = tokens[0];
/*     */       
/*  93 */       setOrganizationId(Long.valueOf(str));
/*  94 */       str = tokens[1];
/*     */       
/*  96 */       if ("null".equals(str)) {
/*  97 */         setBusinessDate((Date)null);
/*     */       } else {
/*     */         
/* 100 */         setBusinessDate((Date)new DtvDate());
/* 101 */         this._businessDate.setTimeFromSerialization(Long.parseLong(str));
/*     */       } 
/* 103 */       str = tokens[2];
/*     */       
/* 105 */       setRetailLocationId(Long.valueOf(str));
/* 106 */       str = tokens[3];
/*     */       
/* 108 */       setPartyId(Long.valueOf(str));
/* 109 */       str = tokens[4];
/*     */       
/* 111 */       setTimecardEntryId(Long.valueOf(str));
/* 112 */       str = tokens[5];
/*     */       
/* 114 */       setWorkstationId(Long.valueOf(str));
/* 115 */       str = tokens[6];
/*     */       
/* 117 */       setTimecardEntrySeq(Long.valueOf(str));
/*     */     }
/* 119 */     catch (Exception ee) {
/* 120 */       throw new DtxException("An exception occured while parsing object id string: " + argObjectIdValue, ee);
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean equals(Object ob) {
/* 126 */     if (this == ob) {
/* 127 */       return true;
/*     */     }
/* 129 */     if (!(ob instanceof TimecardJournalId)) {
/* 130 */       return false;
/*     */     }
/* 132 */     TimecardJournalId other = (TimecardJournalId)ob;
/* 133 */     return (((this._organizationId == null && other._organizationId == null) || (this._organizationId != null && this._organizationId
/*     */ 
/*     */       
/* 136 */       .equals(other._organizationId))) && ((this._businessDate == null && other._businessDate == null) || (this._businessDate != null && this._businessDate
/*     */ 
/*     */       
/* 139 */       .equals(other._businessDate))) && ((this._retailLocationId == null && other._retailLocationId == null) || (this._retailLocationId != null && this._retailLocationId
/*     */ 
/*     */       
/* 142 */       .equals(other._retailLocationId))) && ((this._partyId == null && other._partyId == null) || (this._partyId != null && this._partyId
/*     */ 
/*     */       
/* 145 */       .equals(other._partyId))) && ((this._timecardEntryId == null && other._timecardEntryId == null) || (this._timecardEntryId != null && this._timecardEntryId
/*     */ 
/*     */       
/* 148 */       .equals(other._timecardEntryId))) && ((this._workstationId == null && other._workstationId == null) || (this._workstationId != null && this._workstationId
/*     */ 
/*     */       
/* 151 */       .equals(other._workstationId))) && ((this._timecardEntrySeq == null && other._timecardEntrySeq == null) || (this._timecardEntrySeq != null && this._timecardEntrySeq
/*     */ 
/*     */       
/* 154 */       .equals(other._timecardEntrySeq))));
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public int hashCode() {
/* 160 */     return ((this._organizationId == null) ? 0 : this._organizationId
/* 161 */       .hashCode()) + ((this._businessDate == null) ? 0 : this._businessDate
/* 162 */       .hashCode()) + ((this._retailLocationId == null) ? 0 : this._retailLocationId
/* 163 */       .hashCode()) + ((this._partyId == null) ? 0 : this._partyId
/* 164 */       .hashCode()) + ((this._timecardEntryId == null) ? 0 : this._timecardEntryId
/* 165 */       .hashCode()) + ((this._workstationId == null) ? 0 : this._workstationId
/* 166 */       .hashCode()) + ((this._timecardEntrySeq == null) ? 0 : this._timecardEntrySeq
/* 167 */       .hashCode());
/*     */   }
/*     */ 
/*     */   
/*     */   public String getDtxTypeName() {
/* 172 */     return "TimecardJournal";
/*     */   }
/*     */ 
/*     */   
/*     */   public String toString() {
/* 177 */     StringBuilder buff = new StringBuilder(84);
/*     */     
/* 179 */     return buff.append(
/* 180 */         String.valueOf(this._organizationId))
/* 181 */       .append("::").append((this._businessDate == null) ? "null" : String.valueOf(this._businessDate.getTimeSerializable()))
/* 182 */       .append("::").append(String.valueOf(this._retailLocationId))
/* 183 */       .append("::").append(String.valueOf(this._partyId))
/* 184 */       .append("::").append(String.valueOf(this._timecardEntryId))
/* 185 */       .append("::").append(String.valueOf(this._workstationId))
/* 186 */       .append("::").append(String.valueOf(this._timecardEntrySeq))
/* 187 */       .toString();
/*     */   }
/*     */   
/*     */   public boolean validate() {
/* 191 */     if (this._businessDate == null) {
/* 192 */       return false;
/*     */     }
/* 194 */     if (this._retailLocationId == null) {
/* 195 */       return false;
/*     */     }
/* 197 */     if (this._partyId == null) {
/* 198 */       return false;
/*     */     }
/* 200 */     if (this._timecardEntryId == null) {
/* 201 */       return false;
/*     */     }
/* 203 */     if (this._workstationId == null) {
/* 204 */       return false;
/*     */     }
/* 206 */     if (this._timecardEntrySeq == null) {
/* 207 */       return false;
/*     */     }
/* 209 */     return true;
/*     */   }
/*     */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\thr\TimecardJournalId.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */