/*     */ package dtv.xst.dao.tsn;
/*     */ 
/*     */ import dtv.data2.access.AbstractObjectId;
/*     */ import dtv.data2.access.exception.DtxException;
/*     */ import dtv.util.DtvDate;
/*     */ import dtv.util.StringUtils;
/*     */ import java.util.Date;
/*     */ 
/*     */ 
/*     */ public class TenderSerializedCountPropertyId
/*     */   extends AbstractObjectId
/*     */ {
/*     */   private static final long serialVersionUID = -452179124L;
/*     */   private DtvDate _businessDayDate;
/*     */   private Long _retailLocationId;
/*     */   private Integer _serializedCountSequence;
/*     */   private String _tenderTypeCode;
/*     */   private Long _transactionSequence;
/*     */   private Long _workstationId;
/*     */   private String _propertyCode;
/*     */   
/*     */   public TenderSerializedCountPropertyId() {}
/*     */   
/*     */   public TenderSerializedCountPropertyId(String argObjectIdValue) {
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
/*     */   public Integer getSerializedCountSequence() {
/*  54 */     return this._serializedCountSequence;
/*     */   }
/*     */   
/*     */   public void setSerializedCountSequence(Integer argSerializedCountSequence) {
/*  58 */     this._serializedCountSequence = argSerializedCountSequence;
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
/* 117 */       setSerializedCountSequence(Integer.valueOf(str));
/* 118 */       str = tokens[4];
/*     */       
/* 120 */       if ("null".equals(str)) {
/* 121 */         setTenderTypeCode((String)null);
/*     */       } else {
/*     */         
/* 124 */         setTenderTypeCode(str);
/*     */       } 
/* 126 */       str = tokens[5];
/*     */       
/* 128 */       setTransactionSequence(Long.valueOf(str));
/* 129 */       str = tokens[6];
/*     */       
/* 131 */       setWorkstationId(Long.valueOf(str));
/* 132 */       str = tokens[7];
/*     */       
/* 134 */       if ("null".equals(str)) {
/* 135 */         setPropertyCode((String)null);
/*     */       } else {
/*     */         
/* 138 */         setPropertyCode(str);
/*     */       }
/*     */     
/* 141 */     } catch (Exception ee) {
/* 142 */       throw new DtxException("An exception occured while parsing object id string: " + argObjectIdValue, ee);
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean equals(Object ob) {
/* 148 */     if (this == ob) {
/* 149 */       return true;
/*     */     }
/* 151 */     if (!(ob instanceof TenderSerializedCountPropertyId)) {
/* 152 */       return false;
/*     */     }
/* 154 */     TenderSerializedCountPropertyId other = (TenderSerializedCountPropertyId)ob;
/* 155 */     return (((this._businessDayDate == null && other._businessDayDate == null) || (this._businessDayDate != null && this._businessDayDate
/*     */ 
/*     */       
/* 158 */       .equals(other._businessDayDate))) && ((this._organizationId == null && other._organizationId == null) || (this._organizationId != null && this._organizationId
/*     */ 
/*     */       
/* 161 */       .equals(other._organizationId))) && ((this._retailLocationId == null && other._retailLocationId == null) || (this._retailLocationId != null && this._retailLocationId
/*     */ 
/*     */       
/* 164 */       .equals(other._retailLocationId))) && ((this._serializedCountSequence == null && other._serializedCountSequence == null) || (this._serializedCountSequence != null && this._serializedCountSequence
/*     */ 
/*     */       
/* 167 */       .equals(other._serializedCountSequence))) && ((this._tenderTypeCode == null && other._tenderTypeCode == null) || (this._tenderTypeCode != null && this._tenderTypeCode
/*     */ 
/*     */       
/* 170 */       .equals(other._tenderTypeCode))) && ((this._transactionSequence == null && other._transactionSequence == null) || (this._transactionSequence != null && this._transactionSequence
/*     */ 
/*     */       
/* 173 */       .equals(other._transactionSequence))) && ((this._workstationId == null && other._workstationId == null) || (this._workstationId != null && this._workstationId
/*     */ 
/*     */       
/* 176 */       .equals(other._workstationId))) && ((this._propertyCode == null && other._propertyCode == null) || (this._propertyCode != null && this._propertyCode
/*     */ 
/*     */       
/* 179 */       .equals(other._propertyCode))));
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public int hashCode() {
/* 185 */     return ((this._businessDayDate == null) ? 0 : this._businessDayDate
/* 186 */       .hashCode()) + ((this._organizationId == null) ? 0 : this._organizationId
/* 187 */       .hashCode()) + ((this._retailLocationId == null) ? 0 : this._retailLocationId
/* 188 */       .hashCode()) + ((this._serializedCountSequence == null) ? 0 : this._serializedCountSequence
/* 189 */       .hashCode()) + ((this._tenderTypeCode == null) ? 0 : this._tenderTypeCode
/* 190 */       .hashCode()) + ((this._transactionSequence == null) ? 0 : this._transactionSequence
/* 191 */       .hashCode()) + ((this._workstationId == null) ? 0 : this._workstationId
/* 192 */       .hashCode()) + ((this._propertyCode == null) ? 0 : this._propertyCode
/* 193 */       .hashCode());
/*     */   }
/*     */ 
/*     */   
/*     */   public String getDtxTypeName() {
/* 198 */     return "TenderSerializedCountProperty";
/*     */   }
/*     */ 
/*     */   
/*     */   public String toString() {
/* 203 */     StringBuilder buff = new StringBuilder(96);
/*     */     
/* 205 */     return buff.append((this._businessDayDate == null) ? "null" : 
/* 206 */         String.valueOf(this._businessDayDate.getTimeSerializable()))
/* 207 */       .append("::").append(String.valueOf(this._organizationId))
/* 208 */       .append("::").append(String.valueOf(this._retailLocationId))
/* 209 */       .append("::").append(String.valueOf(this._serializedCountSequence))
/* 210 */       .append("::").append(this._tenderTypeCode)
/* 211 */       .append("::").append(String.valueOf(this._transactionSequence))
/* 212 */       .append("::").append(String.valueOf(this._workstationId))
/* 213 */       .append("::").append(this._propertyCode)
/* 214 */       .toString();
/*     */   }
/*     */   
/*     */   public boolean validate() {
/* 218 */     if (this._businessDayDate == null) {
/* 219 */       return false;
/*     */     }
/* 221 */     if (this._retailLocationId == null) {
/* 222 */       return false;
/*     */     }
/* 224 */     if (this._serializedCountSequence == null) {
/* 225 */       return false;
/*     */     }
/* 227 */     if (this._tenderTypeCode == null) {
/* 228 */       return false;
/*     */     }
/* 230 */     if (this._transactionSequence == null) {
/* 231 */       return false;
/*     */     }
/* 233 */     if (this._workstationId == null) {
/* 234 */       return false;
/*     */     }
/* 236 */     if (this._propertyCode == null) {
/* 237 */       return false;
/*     */     }
/* 239 */     return true;
/*     */   }
/*     */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\tsn\TenderSerializedCountPropertyId.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */