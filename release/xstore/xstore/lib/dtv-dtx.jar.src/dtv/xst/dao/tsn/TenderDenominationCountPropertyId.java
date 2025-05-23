/*     */ package dtv.xst.dao.tsn;
/*     */ 
/*     */ import dtv.data2.access.AbstractObjectId;
/*     */ import dtv.data2.access.exception.DtxException;
/*     */ import dtv.util.DtvDate;
/*     */ import dtv.util.StringUtils;
/*     */ import java.util.Date;
/*     */ 
/*     */ public class TenderDenominationCountPropertyId
/*     */   extends AbstractObjectId
/*     */ {
/*     */   private static final long serialVersionUID = 759654283L;
/*     */   private DtvDate _businessDayDate;
/*     */   private String _denominationId;
/*     */   private Long _retailLocationId;
/*     */   private String _tenderId;
/*     */   private String _tenderTypeCode;
/*     */   private Long _transactionSequence;
/*     */   private Long _workstationId;
/*     */   private String _propertyCode;
/*     */   
/*     */   public TenderDenominationCountPropertyId() {}
/*     */   
/*     */   public TenderDenominationCountPropertyId(String argObjectIdValue) {
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
/*     */   
/*     */   public Date getBusinessDayDate() {
/*  38 */     return (Date)this._businessDayDate;
/*     */   }
/*     */   
/*     */   public void setBusinessDayDate(Date argBusinessDayDate) {
/*  42 */     this._businessDayDate = (argBusinessDayDate == null || argBusinessDayDate instanceof DtvDate) ? (DtvDate)argBusinessDayDate : new DtvDate(argBusinessDayDate);
/*     */   }
/*     */ 
/*     */   
/*     */   public String getDenominationId() {
/*  47 */     return this._denominationId;
/*     */   }
/*     */   
/*     */   public void setDenominationId(String argDenominationId) {
/*  51 */     this._denominationId = (argDenominationId != null && MANAGE_CASE) ? argDenominationId.toUpperCase() : argDenominationId;
/*     */   }
/*     */   
/*     */   public Long getRetailLocationId() {
/*  55 */     return this._retailLocationId;
/*     */   }
/*     */   
/*     */   public void setRetailLocationId(Long argRetailLocationId) {
/*  59 */     this._retailLocationId = argRetailLocationId;
/*     */   }
/*     */   
/*     */   public String getTenderId() {
/*  63 */     return this._tenderId;
/*     */   }
/*     */   
/*     */   public void setTenderId(String argTenderId) {
/*  67 */     this._tenderId = (argTenderId != null && MANAGE_CASE) ? argTenderId.toUpperCase() : argTenderId;
/*     */   }
/*     */   
/*     */   public String getTenderTypeCode() {
/*  71 */     return this._tenderTypeCode;
/*     */   }
/*     */   
/*     */   public void setTenderTypeCode(String argTenderTypeCode) {
/*  75 */     this._tenderTypeCode = (argTenderTypeCode != null && MANAGE_CASE) ? argTenderTypeCode.toUpperCase() : argTenderTypeCode;
/*     */   }
/*     */   
/*     */   public Long getTransactionSequence() {
/*  79 */     return this._transactionSequence;
/*     */   }
/*     */   
/*     */   public void setTransactionSequence(Long argTransactionSequence) {
/*  83 */     this._transactionSequence = argTransactionSequence;
/*     */   }
/*     */   
/*     */   public Long getWorkstationId() {
/*  87 */     return this._workstationId;
/*     */   }
/*     */   
/*     */   public void setWorkstationId(Long argWorkstationId) {
/*  91 */     this._workstationId = argWorkstationId;
/*     */   }
/*     */   
/*     */   public String getPropertyCode() {
/*  95 */     return this._propertyCode;
/*     */   }
/*     */   
/*     */   public void setPropertyCode(String argPropertyCode) {
/*  99 */     this._propertyCode = (argPropertyCode != null && MANAGE_CASE) ? argPropertyCode.toUpperCase() : argPropertyCode;
/*     */   }
/*     */   
/*     */   public void setValue(String argObjectIdValue) {
/* 103 */     String str = argObjectIdValue;
/* 104 */     if (StringUtils.isEmpty(str)) {
/* 105 */       throw new DtxException("argument passed to setValue() is null or empty - a valid value must be passed");
/*     */     }
/*     */     try {
/* 108 */       String[] tokens = str.split("::");
/* 109 */       str = tokens[0];
/*     */       
/* 111 */       if ("null".equals(str)) {
/* 112 */         setBusinessDayDate((Date)null);
/*     */       } else {
/*     */         
/* 115 */         setBusinessDayDate((Date)new DtvDate());
/* 116 */         this._businessDayDate.setTimeFromSerialization(Long.parseLong(str));
/*     */       } 
/* 118 */       str = tokens[1];
/*     */       
/* 120 */       if ("null".equals(str)) {
/* 121 */         setDenominationId((String)null);
/*     */       } else {
/*     */         
/* 124 */         setDenominationId(str);
/*     */       } 
/* 126 */       str = tokens[2];
/*     */       
/* 128 */       setOrganizationId(Long.valueOf(str));
/* 129 */       str = tokens[3];
/*     */       
/* 131 */       setRetailLocationId(Long.valueOf(str));
/* 132 */       str = tokens[4];
/*     */       
/* 134 */       if ("null".equals(str)) {
/* 135 */         setTenderId((String)null);
/*     */       } else {
/*     */         
/* 138 */         setTenderId(str);
/*     */       } 
/* 140 */       str = tokens[5];
/*     */       
/* 142 */       if ("null".equals(str)) {
/* 143 */         setTenderTypeCode((String)null);
/*     */       } else {
/*     */         
/* 146 */         setTenderTypeCode(str);
/*     */       } 
/* 148 */       str = tokens[6];
/*     */       
/* 150 */       setTransactionSequence(Long.valueOf(str));
/* 151 */       str = tokens[7];
/*     */       
/* 153 */       setWorkstationId(Long.valueOf(str));
/* 154 */       str = tokens[8];
/*     */       
/* 156 */       if ("null".equals(str)) {
/* 157 */         setPropertyCode((String)null);
/*     */       } else {
/*     */         
/* 160 */         setPropertyCode(str);
/*     */       }
/*     */     
/* 163 */     } catch (Exception ee) {
/* 164 */       throw new DtxException("An exception occured while parsing object id string: " + argObjectIdValue, ee);
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean equals(Object ob) {
/* 170 */     if (this == ob) {
/* 171 */       return true;
/*     */     }
/* 173 */     if (!(ob instanceof TenderDenominationCountPropertyId)) {
/* 174 */       return false;
/*     */     }
/* 176 */     TenderDenominationCountPropertyId other = (TenderDenominationCountPropertyId)ob;
/* 177 */     return (((this._businessDayDate == null && other._businessDayDate == null) || (this._businessDayDate != null && this._businessDayDate
/*     */ 
/*     */       
/* 180 */       .equals(other._businessDayDate))) && ((this._denominationId == null && other._denominationId == null) || (this._denominationId != null && this._denominationId
/*     */ 
/*     */       
/* 183 */       .equals(other._denominationId))) && ((this._organizationId == null && other._organizationId == null) || (this._organizationId != null && this._organizationId
/*     */ 
/*     */       
/* 186 */       .equals(other._organizationId))) && ((this._retailLocationId == null && other._retailLocationId == null) || (this._retailLocationId != null && this._retailLocationId
/*     */ 
/*     */       
/* 189 */       .equals(other._retailLocationId))) && ((this._tenderId == null && other._tenderId == null) || (this._tenderId != null && this._tenderId
/*     */ 
/*     */       
/* 192 */       .equals(other._tenderId))) && ((this._tenderTypeCode == null && other._tenderTypeCode == null) || (this._tenderTypeCode != null && this._tenderTypeCode
/*     */ 
/*     */       
/* 195 */       .equals(other._tenderTypeCode))) && ((this._transactionSequence == null && other._transactionSequence == null) || (this._transactionSequence != null && this._transactionSequence
/*     */ 
/*     */       
/* 198 */       .equals(other._transactionSequence))) && ((this._workstationId == null && other._workstationId == null) || (this._workstationId != null && this._workstationId
/*     */ 
/*     */       
/* 201 */       .equals(other._workstationId))) && ((this._propertyCode == null && other._propertyCode == null) || (this._propertyCode != null && this._propertyCode
/*     */ 
/*     */       
/* 204 */       .equals(other._propertyCode))));
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public int hashCode() {
/* 210 */     return ((this._businessDayDate == null) ? 0 : this._businessDayDate
/* 211 */       .hashCode()) + ((this._denominationId == null) ? 0 : this._denominationId
/* 212 */       .hashCode()) + ((this._organizationId == null) ? 0 : this._organizationId
/* 213 */       .hashCode()) + ((this._retailLocationId == null) ? 0 : this._retailLocationId
/* 214 */       .hashCode()) + ((this._tenderId == null) ? 0 : this._tenderId
/* 215 */       .hashCode()) + ((this._tenderTypeCode == null) ? 0 : this._tenderTypeCode
/* 216 */       .hashCode()) + ((this._transactionSequence == null) ? 0 : this._transactionSequence
/* 217 */       .hashCode()) + ((this._workstationId == null) ? 0 : this._workstationId
/* 218 */       .hashCode()) + ((this._propertyCode == null) ? 0 : this._propertyCode
/* 219 */       .hashCode());
/*     */   }
/*     */ 
/*     */   
/*     */   public String getDtxTypeName() {
/* 224 */     return "TenderDenominationCountProperty";
/*     */   }
/*     */ 
/*     */   
/*     */   public String toString() {
/* 229 */     StringBuilder buff = new StringBuilder(108);
/*     */     
/* 231 */     return buff.append((this._businessDayDate == null) ? "null" : 
/* 232 */         String.valueOf(this._businessDayDate.getTimeSerializable()))
/* 233 */       .append("::").append(this._denominationId)
/* 234 */       .append("::").append(String.valueOf(this._organizationId))
/* 235 */       .append("::").append(String.valueOf(this._retailLocationId))
/* 236 */       .append("::").append(this._tenderId)
/* 237 */       .append("::").append(this._tenderTypeCode)
/* 238 */       .append("::").append(String.valueOf(this._transactionSequence))
/* 239 */       .append("::").append(String.valueOf(this._workstationId))
/* 240 */       .append("::").append(this._propertyCode)
/* 241 */       .toString();
/*     */   }
/*     */   
/*     */   public boolean validate() {
/* 245 */     if (this._businessDayDate == null) {
/* 246 */       return false;
/*     */     }
/* 248 */     if (this._denominationId == null) {
/* 249 */       return false;
/*     */     }
/* 251 */     if (this._retailLocationId == null) {
/* 252 */       return false;
/*     */     }
/* 254 */     if (this._tenderId == null) {
/* 255 */       return false;
/*     */     }
/* 257 */     if (this._tenderTypeCode == null) {
/* 258 */       return false;
/*     */     }
/* 260 */     if (this._transactionSequence == null) {
/* 261 */       return false;
/*     */     }
/* 263 */     if (this._workstationId == null) {
/* 264 */       return false;
/*     */     }
/* 266 */     if (this._propertyCode == null) {
/* 267 */       return false;
/*     */     }
/* 269 */     return true;
/*     */   }
/*     */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\tsn\TenderDenominationCountPropertyId.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */