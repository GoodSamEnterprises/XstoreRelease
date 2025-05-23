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
/*     */ public class TimecardEntryCommentPropertyId
/*     */   extends AbstractObjectId
/*     */ {
/*     */   private static final long serialVersionUID = 991786399L;
/*     */   private DtvDate _weekEndingDate;
/*     */   private Long _retailLocationId;
/*     */   private Long _workstationId;
/*     */   private Long _partyId;
/*     */   private Long _commentSeq;
/*     */   private String _propertyCode;
/*     */   
/*     */   public TimecardEntryCommentPropertyId() {}
/*     */   
/*     */   public TimecardEntryCommentPropertyId(String argObjectIdValue) {
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
/*     */   public Date getWeekEndingDate() {
/*  36 */     return (Date)this._weekEndingDate;
/*     */   }
/*     */   
/*     */   public void setWeekEndingDate(Date argWeekEndingDate) {
/*  40 */     this._weekEndingDate = (argWeekEndingDate == null || argWeekEndingDate instanceof DtvDate) ? (DtvDate)argWeekEndingDate : new DtvDate(argWeekEndingDate);
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
/*     */   public Long getWorkstationId() {
/*  53 */     return this._workstationId;
/*     */   }
/*     */   
/*     */   public void setWorkstationId(Long argWorkstationId) {
/*  57 */     this._workstationId = argWorkstationId;
/*     */   }
/*     */   
/*     */   public Long getPartyId() {
/*  61 */     return this._partyId;
/*     */   }
/*     */   
/*     */   public void setPartyId(Long argPartyId) {
/*  65 */     this._partyId = argPartyId;
/*     */   }
/*     */   
/*     */   public Long getCommentSeq() {
/*  69 */     return this._commentSeq;
/*     */   }
/*     */   
/*     */   public void setCommentSeq(Long argCommentSeq) {
/*  73 */     this._commentSeq = argCommentSeq;
/*     */   }
/*     */   
/*     */   public String getPropertyCode() {
/*  77 */     return this._propertyCode;
/*     */   }
/*     */   
/*     */   public void setPropertyCode(String argPropertyCode) {
/*  81 */     this._propertyCode = (argPropertyCode != null && MANAGE_CASE) ? argPropertyCode.toUpperCase() : argPropertyCode;
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
/*  97 */         setWeekEndingDate((Date)null);
/*     */       } else {
/*     */         
/* 100 */         setWeekEndingDate((Date)new DtvDate());
/* 101 */         this._weekEndingDate.setTimeFromSerialization(Long.parseLong(str));
/*     */       } 
/* 103 */       str = tokens[2];
/*     */       
/* 105 */       setRetailLocationId(Long.valueOf(str));
/* 106 */       str = tokens[3];
/*     */       
/* 108 */       setWorkstationId(Long.valueOf(str));
/* 109 */       str = tokens[4];
/*     */       
/* 111 */       setPartyId(Long.valueOf(str));
/* 112 */       str = tokens[5];
/*     */       
/* 114 */       setCommentSeq(Long.valueOf(str));
/* 115 */       str = tokens[6];
/*     */       
/* 117 */       if ("null".equals(str)) {
/* 118 */         setPropertyCode((String)null);
/*     */       } else {
/*     */         
/* 121 */         setPropertyCode(str);
/*     */       }
/*     */     
/* 124 */     } catch (Exception ee) {
/* 125 */       throw new DtxException("An exception occured while parsing object id string: " + argObjectIdValue, ee);
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean equals(Object ob) {
/* 131 */     if (this == ob) {
/* 132 */       return true;
/*     */     }
/* 134 */     if (!(ob instanceof TimecardEntryCommentPropertyId)) {
/* 135 */       return false;
/*     */     }
/* 137 */     TimecardEntryCommentPropertyId other = (TimecardEntryCommentPropertyId)ob;
/* 138 */     return (((this._organizationId == null && other._organizationId == null) || (this._organizationId != null && this._organizationId
/*     */ 
/*     */       
/* 141 */       .equals(other._organizationId))) && ((this._weekEndingDate == null && other._weekEndingDate == null) || (this._weekEndingDate != null && this._weekEndingDate
/*     */ 
/*     */       
/* 144 */       .equals(other._weekEndingDate))) && ((this._retailLocationId == null && other._retailLocationId == null) || (this._retailLocationId != null && this._retailLocationId
/*     */ 
/*     */       
/* 147 */       .equals(other._retailLocationId))) && ((this._workstationId == null && other._workstationId == null) || (this._workstationId != null && this._workstationId
/*     */ 
/*     */       
/* 150 */       .equals(other._workstationId))) && ((this._partyId == null && other._partyId == null) || (this._partyId != null && this._partyId
/*     */ 
/*     */       
/* 153 */       .equals(other._partyId))) && ((this._commentSeq == null && other._commentSeq == null) || (this._commentSeq != null && this._commentSeq
/*     */ 
/*     */       
/* 156 */       .equals(other._commentSeq))) && ((this._propertyCode == null && other._propertyCode == null) || (this._propertyCode != null && this._propertyCode
/*     */ 
/*     */       
/* 159 */       .equals(other._propertyCode))));
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public int hashCode() {
/* 165 */     return ((this._organizationId == null) ? 0 : this._organizationId
/* 166 */       .hashCode()) + ((this._weekEndingDate == null) ? 0 : this._weekEndingDate
/* 167 */       .hashCode()) + ((this._retailLocationId == null) ? 0 : this._retailLocationId
/* 168 */       .hashCode()) + ((this._workstationId == null) ? 0 : this._workstationId
/* 169 */       .hashCode()) + ((this._partyId == null) ? 0 : this._partyId
/* 170 */       .hashCode()) + ((this._commentSeq == null) ? 0 : this._commentSeq
/* 171 */       .hashCode()) + ((this._propertyCode == null) ? 0 : this._propertyCode
/* 172 */       .hashCode());
/*     */   }
/*     */ 
/*     */   
/*     */   public String getDtxTypeName() {
/* 177 */     return "TimecardEntryCommentProperty";
/*     */   }
/*     */ 
/*     */   
/*     */   public String toString() {
/* 182 */     StringBuilder buff = new StringBuilder(84);
/*     */     
/* 184 */     return buff.append(
/* 185 */         String.valueOf(this._organizationId))
/* 186 */       .append("::").append((this._weekEndingDate == null) ? "null" : String.valueOf(this._weekEndingDate.getTimeSerializable()))
/* 187 */       .append("::").append(String.valueOf(this._retailLocationId))
/* 188 */       .append("::").append(String.valueOf(this._workstationId))
/* 189 */       .append("::").append(String.valueOf(this._partyId))
/* 190 */       .append("::").append(String.valueOf(this._commentSeq))
/* 191 */       .append("::").append(this._propertyCode)
/* 192 */       .toString();
/*     */   }
/*     */   
/*     */   public boolean validate() {
/* 196 */     if (this._weekEndingDate == null) {
/* 197 */       return false;
/*     */     }
/* 199 */     if (this._retailLocationId == null) {
/* 200 */       return false;
/*     */     }
/* 202 */     if (this._workstationId == null) {
/* 203 */       return false;
/*     */     }
/* 205 */     if (this._partyId == null) {
/* 206 */       return false;
/*     */     }
/* 208 */     if (this._commentSeq == null) {
/* 209 */       return false;
/*     */     }
/* 211 */     if (this._propertyCode == null) {
/* 212 */       return false;
/*     */     }
/* 214 */     return true;
/*     */   }
/*     */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\thr\TimecardEntryCommentPropertyId.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */