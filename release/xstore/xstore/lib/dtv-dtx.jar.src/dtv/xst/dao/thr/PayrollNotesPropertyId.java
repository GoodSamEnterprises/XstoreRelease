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
/*     */ public class PayrollNotesPropertyId
/*     */   extends AbstractObjectId
/*     */ {
/*     */   private static final long serialVersionUID = 1661946545L;
/*     */   private Long _partyId;
/*     */   private DtvDate _weekEndingDate;
/*     */   private Long _noteSeq;
/*     */   private String _propertyCode;
/*     */   
/*     */   public PayrollNotesPropertyId() {}
/*     */   
/*     */   public PayrollNotesPropertyId(String argObjectIdValue) {
/*  25 */     setValue(argObjectIdValue);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Long getPartyId() {
/*  34 */     return this._partyId;
/*     */   }
/*     */   
/*     */   public void setPartyId(Long argPartyId) {
/*  38 */     this._partyId = argPartyId;
/*     */   }
/*     */   
/*     */   public Date getWeekEndingDate() {
/*  42 */     return (Date)this._weekEndingDate;
/*     */   }
/*     */   
/*     */   public void setWeekEndingDate(Date argWeekEndingDate) {
/*  46 */     this._weekEndingDate = (argWeekEndingDate == null || argWeekEndingDate instanceof DtvDate) ? (DtvDate)argWeekEndingDate : new DtvDate(argWeekEndingDate);
/*     */   }
/*     */ 
/*     */   
/*     */   public Long getNoteSeq() {
/*  51 */     return this._noteSeq;
/*     */   }
/*     */   
/*     */   public void setNoteSeq(Long argNoteSeq) {
/*  55 */     this._noteSeq = argNoteSeq;
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
/*  78 */       setPartyId(Long.valueOf(str));
/*  79 */       str = tokens[2];
/*     */       
/*  81 */       if ("null".equals(str)) {
/*  82 */         setWeekEndingDate((Date)null);
/*     */       } else {
/*     */         
/*  85 */         setWeekEndingDate((Date)new DtvDate());
/*  86 */         this._weekEndingDate.setTimeFromSerialization(Long.parseLong(str));
/*     */       } 
/*  88 */       str = tokens[3];
/*     */       
/*  90 */       setNoteSeq(Long.valueOf(str));
/*  91 */       str = tokens[4];
/*     */       
/*  93 */       if ("null".equals(str)) {
/*  94 */         setPropertyCode((String)null);
/*     */       } else {
/*     */         
/*  97 */         setPropertyCode(str);
/*     */       }
/*     */     
/* 100 */     } catch (Exception ee) {
/* 101 */       throw new DtxException("An exception occured while parsing object id string: " + argObjectIdValue, ee);
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean equals(Object ob) {
/* 107 */     if (this == ob) {
/* 108 */       return true;
/*     */     }
/* 110 */     if (!(ob instanceof PayrollNotesPropertyId)) {
/* 111 */       return false;
/*     */     }
/* 113 */     PayrollNotesPropertyId other = (PayrollNotesPropertyId)ob;
/* 114 */     return (((this._organizationId == null && other._organizationId == null) || (this._organizationId != null && this._organizationId
/*     */ 
/*     */       
/* 117 */       .equals(other._organizationId))) && ((this._partyId == null && other._partyId == null) || (this._partyId != null && this._partyId
/*     */ 
/*     */       
/* 120 */       .equals(other._partyId))) && ((this._weekEndingDate == null && other._weekEndingDate == null) || (this._weekEndingDate != null && this._weekEndingDate
/*     */ 
/*     */       
/* 123 */       .equals(other._weekEndingDate))) && ((this._noteSeq == null && other._noteSeq == null) || (this._noteSeq != null && this._noteSeq
/*     */ 
/*     */       
/* 126 */       .equals(other._noteSeq))) && ((this._propertyCode == null && other._propertyCode == null) || (this._propertyCode != null && this._propertyCode
/*     */ 
/*     */       
/* 129 */       .equals(other._propertyCode))));
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public int hashCode() {
/* 135 */     return ((this._organizationId == null) ? 0 : this._organizationId
/* 136 */       .hashCode()) + ((this._partyId == null) ? 0 : this._partyId
/* 137 */       .hashCode()) + ((this._weekEndingDate == null) ? 0 : this._weekEndingDate
/* 138 */       .hashCode()) + ((this._noteSeq == null) ? 0 : this._noteSeq
/* 139 */       .hashCode()) + ((this._propertyCode == null) ? 0 : this._propertyCode
/* 140 */       .hashCode());
/*     */   }
/*     */ 
/*     */   
/*     */   public String getDtxTypeName() {
/* 145 */     return "PayrollNotesProperty";
/*     */   }
/*     */ 
/*     */   
/*     */   public String toString() {
/* 150 */     StringBuilder buff = new StringBuilder(60);
/*     */     
/* 152 */     return buff.append(
/* 153 */         String.valueOf(this._organizationId))
/* 154 */       .append("::").append(String.valueOf(this._partyId))
/* 155 */       .append("::").append((this._weekEndingDate == null) ? "null" : String.valueOf(this._weekEndingDate.getTimeSerializable()))
/* 156 */       .append("::").append(String.valueOf(this._noteSeq))
/* 157 */       .append("::").append(this._propertyCode)
/* 158 */       .toString();
/*     */   }
/*     */   
/*     */   public boolean validate() {
/* 162 */     if (this._partyId == null) {
/* 163 */       return false;
/*     */     }
/* 165 */     if (this._weekEndingDate == null) {
/* 166 */       return false;
/*     */     }
/* 168 */     if (this._noteSeq == null) {
/* 169 */       return false;
/*     */     }
/* 171 */     if (this._propertyCode == null) {
/* 172 */       return false;
/*     */     }
/* 174 */     return true;
/*     */   }
/*     */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\thr\PayrollNotesPropertyId.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */