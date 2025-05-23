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
/*     */ 
/*     */ 
/*     */ 
/*     */ public class PayrollNotesId
/*     */   extends AbstractObjectId
/*     */ {
/*     */   private static final long serialVersionUID = 1743357116L;
/*     */   private Long _partyId;
/*     */   private DtvDate _weekEndingDate;
/*     */   private Long _noteSeq;
/*     */   
/*     */   public PayrollNotesId() {}
/*     */   
/*     */   public PayrollNotesId(String argObjectIdValue) {
/*  25 */     setValue(argObjectIdValue);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Long getPartyId() {
/*  33 */     return this._partyId;
/*     */   }
/*     */   
/*     */   public void setPartyId(Long argPartyId) {
/*  37 */     this._partyId = argPartyId;
/*     */   }
/*     */   
/*     */   public Date getWeekEndingDate() {
/*  41 */     return (Date)this._weekEndingDate;
/*     */   }
/*     */   
/*     */   public void setWeekEndingDate(Date argWeekEndingDate) {
/*  45 */     this._weekEndingDate = (argWeekEndingDate == null || argWeekEndingDate instanceof DtvDate) ? (DtvDate)argWeekEndingDate : new DtvDate(argWeekEndingDate);
/*     */   }
/*     */ 
/*     */   
/*     */   public Long getNoteSeq() {
/*  50 */     return this._noteSeq;
/*     */   }
/*     */   
/*     */   public void setNoteSeq(Long argNoteSeq) {
/*  54 */     this._noteSeq = argNoteSeq;
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
/*  69 */       setPartyId(Long.valueOf(str));
/*  70 */       str = tokens[2];
/*     */       
/*  72 */       if ("null".equals(str)) {
/*  73 */         setWeekEndingDate((Date)null);
/*     */       } else {
/*     */         
/*  76 */         setWeekEndingDate((Date)new DtvDate());
/*  77 */         this._weekEndingDate.setTimeFromSerialization(Long.parseLong(str));
/*     */       } 
/*  79 */       str = tokens[3];
/*     */       
/*  81 */       setNoteSeq(Long.valueOf(str));
/*     */     }
/*  83 */     catch (Exception ee) {
/*  84 */       throw new DtxException("An exception occured while parsing object id string: " + argObjectIdValue, ee);
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean equals(Object ob) {
/*  90 */     if (this == ob) {
/*  91 */       return true;
/*     */     }
/*  93 */     if (!(ob instanceof PayrollNotesId)) {
/*  94 */       return false;
/*     */     }
/*  96 */     PayrollNotesId other = (PayrollNotesId)ob;
/*  97 */     return (((this._organizationId == null && other._organizationId == null) || (this._organizationId != null && this._organizationId
/*     */ 
/*     */       
/* 100 */       .equals(other._organizationId))) && ((this._partyId == null && other._partyId == null) || (this._partyId != null && this._partyId
/*     */ 
/*     */       
/* 103 */       .equals(other._partyId))) && ((this._weekEndingDate == null && other._weekEndingDate == null) || (this._weekEndingDate != null && this._weekEndingDate
/*     */ 
/*     */       
/* 106 */       .equals(other._weekEndingDate))) && ((this._noteSeq == null && other._noteSeq == null) || (this._noteSeq != null && this._noteSeq
/*     */ 
/*     */       
/* 109 */       .equals(other._noteSeq))));
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public int hashCode() {
/* 115 */     return ((this._organizationId == null) ? 0 : this._organizationId
/* 116 */       .hashCode()) + ((this._partyId == null) ? 0 : this._partyId
/* 117 */       .hashCode()) + ((this._weekEndingDate == null) ? 0 : this._weekEndingDate
/* 118 */       .hashCode()) + ((this._noteSeq == null) ? 0 : this._noteSeq
/* 119 */       .hashCode());
/*     */   }
/*     */ 
/*     */   
/*     */   public String getDtxTypeName() {
/* 124 */     return "PayrollNotes";
/*     */   }
/*     */ 
/*     */   
/*     */   public String toString() {
/* 129 */     StringBuilder buff = new StringBuilder(48);
/*     */     
/* 131 */     return buff.append(
/* 132 */         String.valueOf(this._organizationId))
/* 133 */       .append("::").append(String.valueOf(this._partyId))
/* 134 */       .append("::").append((this._weekEndingDate == null) ? "null" : String.valueOf(this._weekEndingDate.getTimeSerializable()))
/* 135 */       .append("::").append(String.valueOf(this._noteSeq))
/* 136 */       .toString();
/*     */   }
/*     */   
/*     */   public boolean validate() {
/* 140 */     if (this._partyId == null) {
/* 141 */       return false;
/*     */     }
/* 143 */     if (this._weekEndingDate == null) {
/* 144 */       return false;
/*     */     }
/* 146 */     if (this._noteSeq == null) {
/* 147 */       return false;
/*     */     }
/* 149 */     return true;
/*     */   }
/*     */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\thr\PayrollNotesId.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */