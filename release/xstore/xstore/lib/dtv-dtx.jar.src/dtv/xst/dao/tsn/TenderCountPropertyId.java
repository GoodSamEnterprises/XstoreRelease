/*     */ package dtv.xst.dao.tsn;
/*     */ 
/*     */ import dtv.data2.access.AbstractObjectId;
/*     */ import dtv.data2.access.exception.DtxException;
/*     */ import dtv.util.DtvDate;
/*     */ import dtv.util.StringUtils;
/*     */ import java.util.Date;
/*     */ 
/*     */ 
/*     */ public class TenderCountPropertyId
/*     */   extends AbstractObjectId
/*     */ {
/*     */   private static final long serialVersionUID = -1781313168L;
/*     */   private DtvDate _businessDayDate;
/*     */   private Long _retailLocationId;
/*     */   private String _tenderId;
/*     */   private String _tenderTypeCode;
/*     */   private Long _transactionSequence;
/*     */   private Long _workstationId;
/*     */   private String _propertyCode;
/*     */   
/*     */   public TenderCountPropertyId() {}
/*     */   
/*     */   public TenderCountPropertyId(String argObjectIdValue) {
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
/*     */   public Date getBusinessDayDate() {
/*  37 */     return (Date)this._businessDayDate;
/*     */   }
/*     */   
/*     */   public void setBusinessDayDate(Date argBusinessDayDate) {
/*  41 */     this._businessDayDate = (argBusinessDayDate == null || argBusinessDayDate instanceof DtvDate) ? (DtvDate)argBusinessDayDate : new DtvDate(argBusinessDayDate);
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
/*     */   public String getTenderId() {
/*  54 */     return this._tenderId;
/*     */   }
/*     */   
/*     */   public void setTenderId(String argTenderId) {
/*  58 */     this._tenderId = (argTenderId != null && MANAGE_CASE) ? argTenderId.toUpperCase() : argTenderId;
/*     */   }
/*     */   
/*     */   public String getTenderTypeCode() {
/*  62 */     return this._tenderTypeCode;
/*     */   }
/*     */   
/*     */   public void setTenderTypeCode(String argTenderTypeCode) {
/*  66 */     this._tenderTypeCode = (argTenderTypeCode != null && MANAGE_CASE) ? argTenderTypeCode.toUpperCase() : argTenderTypeCode;
/*     */   }
/*     */   
/*     */   public Long getTransactionSequence() {
/*  70 */     return this._transactionSequence;
/*     */   }
/*     */   
/*     */   public void setTransactionSequence(Long argTransactionSequence) {
/*  74 */     this._transactionSequence = argTransactionSequence;
/*     */   }
/*     */   
/*     */   public Long getWorkstationId() {
/*  78 */     return this._workstationId;
/*     */   }
/*     */   
/*     */   public void setWorkstationId(Long argWorkstationId) {
/*  82 */     this._workstationId = argWorkstationId;
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
/* 102 */       if ("null".equals(str)) {
/* 103 */         setBusinessDayDate((Date)null);
/*     */       } else {
/*     */         
/* 106 */         setBusinessDayDate((Date)new DtvDate());
/* 107 */         this._businessDayDate.setTimeFromSerialization(Long.parseLong(str));
/*     */       } 
/* 109 */       str = tokens[1];
/*     */       
/* 111 */       setOrganizationId(Long.valueOf(str));
/* 112 */       str = tokens[2];
/*     */       
/* 114 */       setRetailLocationId(Long.valueOf(str));
/* 115 */       str = tokens[3];
/*     */       
/* 117 */       if ("null".equals(str)) {
/* 118 */         setTenderId((String)null);
/*     */       } else {
/*     */         
/* 121 */         setTenderId(str);
/*     */       } 
/* 123 */       str = tokens[4];
/*     */       
/* 125 */       if ("null".equals(str)) {
/* 126 */         setTenderTypeCode((String)null);
/*     */       } else {
/*     */         
/* 129 */         setTenderTypeCode(str);
/*     */       } 
/* 131 */       str = tokens[5];
/*     */       
/* 133 */       setTransactionSequence(Long.valueOf(str));
/* 134 */       str = tokens[6];
/*     */       
/* 136 */       setWorkstationId(Long.valueOf(str));
/* 137 */       str = tokens[7];
/*     */       
/* 139 */       if ("null".equals(str)) {
/* 140 */         setPropertyCode((String)null);
/*     */       } else {
/*     */         
/* 143 */         setPropertyCode(str);
/*     */       }
/*     */     
/* 146 */     } catch (Exception ee) {
/* 147 */       throw new DtxException("An exception occured while parsing object id string: " + argObjectIdValue, ee);
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean equals(Object ob) {
/* 153 */     if (this == ob) {
/* 154 */       return true;
/*     */     }
/* 156 */     if (!(ob instanceof TenderCountPropertyId)) {
/* 157 */       return false;
/*     */     }
/* 159 */     TenderCountPropertyId other = (TenderCountPropertyId)ob;
/* 160 */     return (((this._businessDayDate == null && other._businessDayDate == null) || (this._businessDayDate != null && this._businessDayDate
/*     */ 
/*     */       
/* 163 */       .equals(other._businessDayDate))) && ((this._organizationId == null && other._organizationId == null) || (this._organizationId != null && this._organizationId
/*     */ 
/*     */       
/* 166 */       .equals(other._organizationId))) && ((this._retailLocationId == null && other._retailLocationId == null) || (this._retailLocationId != null && this._retailLocationId
/*     */ 
/*     */       
/* 169 */       .equals(other._retailLocationId))) && ((this._tenderId == null && other._tenderId == null) || (this._tenderId != null && this._tenderId
/*     */ 
/*     */       
/* 172 */       .equals(other._tenderId))) && ((this._tenderTypeCode == null && other._tenderTypeCode == null) || (this._tenderTypeCode != null && this._tenderTypeCode
/*     */ 
/*     */       
/* 175 */       .equals(other._tenderTypeCode))) && ((this._transactionSequence == null && other._transactionSequence == null) || (this._transactionSequence != null && this._transactionSequence
/*     */ 
/*     */       
/* 178 */       .equals(other._transactionSequence))) && ((this._workstationId == null && other._workstationId == null) || (this._workstationId != null && this._workstationId
/*     */ 
/*     */       
/* 181 */       .equals(other._workstationId))) && ((this._propertyCode == null && other._propertyCode == null) || (this._propertyCode != null && this._propertyCode
/*     */ 
/*     */       
/* 184 */       .equals(other._propertyCode))));
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public int hashCode() {
/* 190 */     return ((this._businessDayDate == null) ? 0 : this._businessDayDate
/* 191 */       .hashCode()) + ((this._organizationId == null) ? 0 : this._organizationId
/* 192 */       .hashCode()) + ((this._retailLocationId == null) ? 0 : this._retailLocationId
/* 193 */       .hashCode()) + ((this._tenderId == null) ? 0 : this._tenderId
/* 194 */       .hashCode()) + ((this._tenderTypeCode == null) ? 0 : this._tenderTypeCode
/* 195 */       .hashCode()) + ((this._transactionSequence == null) ? 0 : this._transactionSequence
/* 196 */       .hashCode()) + ((this._workstationId == null) ? 0 : this._workstationId
/* 197 */       .hashCode()) + ((this._propertyCode == null) ? 0 : this._propertyCode
/* 198 */       .hashCode());
/*     */   }
/*     */ 
/*     */   
/*     */   public String getDtxTypeName() {
/* 203 */     return "TenderCountProperty";
/*     */   }
/*     */ 
/*     */   
/*     */   public String toString() {
/* 208 */     StringBuilder buff = new StringBuilder(96);
/*     */     
/* 210 */     return buff.append((this._businessDayDate == null) ? "null" : 
/* 211 */         String.valueOf(this._businessDayDate.getTimeSerializable()))
/* 212 */       .append("::").append(String.valueOf(this._organizationId))
/* 213 */       .append("::").append(String.valueOf(this._retailLocationId))
/* 214 */       .append("::").append(this._tenderId)
/* 215 */       .append("::").append(this._tenderTypeCode)
/* 216 */       .append("::").append(String.valueOf(this._transactionSequence))
/* 217 */       .append("::").append(String.valueOf(this._workstationId))
/* 218 */       .append("::").append(this._propertyCode)
/* 219 */       .toString();
/*     */   }
/*     */   
/*     */   public boolean validate() {
/* 223 */     if (this._businessDayDate == null) {
/* 224 */       return false;
/*     */     }
/* 226 */     if (this._retailLocationId == null) {
/* 227 */       return false;
/*     */     }
/* 229 */     if (this._tenderId == null) {
/* 230 */       return false;
/*     */     }
/* 232 */     if (this._tenderTypeCode == null) {
/* 233 */       return false;
/*     */     }
/* 235 */     if (this._transactionSequence == null) {
/* 236 */       return false;
/*     */     }
/* 238 */     if (this._workstationId == null) {
/* 239 */       return false;
/*     */     }
/* 241 */     if (this._propertyCode == null) {
/* 242 */       return false;
/*     */     }
/* 244 */     return true;
/*     */   }
/*     */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\tsn\TenderCountPropertyId.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */