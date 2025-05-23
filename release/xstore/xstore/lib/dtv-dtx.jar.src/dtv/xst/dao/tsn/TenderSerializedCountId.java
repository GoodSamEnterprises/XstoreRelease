/*     */ package dtv.xst.dao.tsn;
/*     */ 
/*     */ import dtv.data2.access.AbstractObjectId;
/*     */ import dtv.data2.access.exception.DtxException;
/*     */ import dtv.util.DtvDate;
/*     */ import dtv.util.StringUtils;
/*     */ import java.util.Date;
/*     */ 
/*     */ 
/*     */ 
/*     */ public class TenderSerializedCountId
/*     */   extends AbstractObjectId
/*     */ {
/*     */   private static final long serialVersionUID = -395161513L;
/*     */   private DtvDate _businessDayDate;
/*     */   private Long _retailLocationId;
/*     */   private Integer _serializedCountSequence;
/*     */   private String _tenderTypeCode;
/*     */   private Long _transactionSequence;
/*     */   private Long _workstationId;
/*     */   
/*     */   public TenderSerializedCountId() {}
/*     */   
/*     */   public TenderSerializedCountId(String argObjectIdValue) {
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
/*     */   public Date getBusinessDayDate() {
/*  36 */     return (Date)this._businessDayDate;
/*     */   }
/*     */   
/*     */   public void setBusinessDayDate(Date argBusinessDayDate) {
/*  40 */     this._businessDayDate = (argBusinessDayDate == null || argBusinessDayDate instanceof DtvDate) ? (DtvDate)argBusinessDayDate : new DtvDate(argBusinessDayDate);
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
/*     */   public Integer getSerializedCountSequence() {
/*  53 */     return this._serializedCountSequence;
/*     */   }
/*     */   
/*     */   public void setSerializedCountSequence(Integer argSerializedCountSequence) {
/*  57 */     this._serializedCountSequence = argSerializedCountSequence;
/*     */   }
/*     */   
/*     */   public String getTenderTypeCode() {
/*  61 */     return this._tenderTypeCode;
/*     */   }
/*     */   
/*     */   public void setTenderTypeCode(String argTenderTypeCode) {
/*  65 */     this._tenderTypeCode = (argTenderTypeCode != null && MANAGE_CASE) ? argTenderTypeCode.toUpperCase() : argTenderTypeCode;
/*     */   }
/*     */   
/*     */   public Long getTransactionSequence() {
/*  69 */     return this._transactionSequence;
/*     */   }
/*     */   
/*     */   public void setTransactionSequence(Long argTransactionSequence) {
/*  73 */     this._transactionSequence = argTransactionSequence;
/*     */   }
/*     */   
/*     */   public Long getWorkstationId() {
/*  77 */     return this._workstationId;
/*     */   }
/*     */   
/*     */   public void setWorkstationId(Long argWorkstationId) {
/*  81 */     this._workstationId = argWorkstationId;
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
/*  93 */       if ("null".equals(str)) {
/*  94 */         setBusinessDayDate((Date)null);
/*     */       } else {
/*     */         
/*  97 */         setBusinessDayDate((Date)new DtvDate());
/*  98 */         this._businessDayDate.setTimeFromSerialization(Long.parseLong(str));
/*     */       } 
/* 100 */       str = tokens[1];
/*     */       
/* 102 */       setOrganizationId(Long.valueOf(str));
/* 103 */       str = tokens[2];
/*     */       
/* 105 */       setRetailLocationId(Long.valueOf(str));
/* 106 */       str = tokens[3];
/*     */       
/* 108 */       setSerializedCountSequence(Integer.valueOf(str));
/* 109 */       str = tokens[4];
/*     */       
/* 111 */       if ("null".equals(str)) {
/* 112 */         setTenderTypeCode((String)null);
/*     */       } else {
/*     */         
/* 115 */         setTenderTypeCode(str);
/*     */       } 
/* 117 */       str = tokens[5];
/*     */       
/* 119 */       setTransactionSequence(Long.valueOf(str));
/* 120 */       str = tokens[6];
/*     */       
/* 122 */       setWorkstationId(Long.valueOf(str));
/*     */     }
/* 124 */     catch (Exception ee) {
/* 125 */       throw new DtxException("An exception occured while parsing object id string: " + argObjectIdValue, ee);
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean equals(Object ob) {
/* 131 */     if (this == ob) {
/* 132 */       return true;
/*     */     }
/* 134 */     if (!(ob instanceof TenderSerializedCountId)) {
/* 135 */       return false;
/*     */     }
/* 137 */     TenderSerializedCountId other = (TenderSerializedCountId)ob;
/* 138 */     return (((this._businessDayDate == null && other._businessDayDate == null) || (this._businessDayDate != null && this._businessDayDate
/*     */ 
/*     */       
/* 141 */       .equals(other._businessDayDate))) && ((this._organizationId == null && other._organizationId == null) || (this._organizationId != null && this._organizationId
/*     */ 
/*     */       
/* 144 */       .equals(other._organizationId))) && ((this._retailLocationId == null && other._retailLocationId == null) || (this._retailLocationId != null && this._retailLocationId
/*     */ 
/*     */       
/* 147 */       .equals(other._retailLocationId))) && ((this._serializedCountSequence == null && other._serializedCountSequence == null) || (this._serializedCountSequence != null && this._serializedCountSequence
/*     */ 
/*     */       
/* 150 */       .equals(other._serializedCountSequence))) && ((this._tenderTypeCode == null && other._tenderTypeCode == null) || (this._tenderTypeCode != null && this._tenderTypeCode
/*     */ 
/*     */       
/* 153 */       .equals(other._tenderTypeCode))) && ((this._transactionSequence == null && other._transactionSequence == null) || (this._transactionSequence != null && this._transactionSequence
/*     */ 
/*     */       
/* 156 */       .equals(other._transactionSequence))) && ((this._workstationId == null && other._workstationId == null) || (this._workstationId != null && this._workstationId
/*     */ 
/*     */       
/* 159 */       .equals(other._workstationId))));
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public int hashCode() {
/* 165 */     return ((this._businessDayDate == null) ? 0 : this._businessDayDate
/* 166 */       .hashCode()) + ((this._organizationId == null) ? 0 : this._organizationId
/* 167 */       .hashCode()) + ((this._retailLocationId == null) ? 0 : this._retailLocationId
/* 168 */       .hashCode()) + ((this._serializedCountSequence == null) ? 0 : this._serializedCountSequence
/* 169 */       .hashCode()) + ((this._tenderTypeCode == null) ? 0 : this._tenderTypeCode
/* 170 */       .hashCode()) + ((this._transactionSequence == null) ? 0 : this._transactionSequence
/* 171 */       .hashCode()) + ((this._workstationId == null) ? 0 : this._workstationId
/* 172 */       .hashCode());
/*     */   }
/*     */ 
/*     */   
/*     */   public String getDtxTypeName() {
/* 177 */     return "TenderSerializedCount";
/*     */   }
/*     */ 
/*     */   
/*     */   public String toString() {
/* 182 */     StringBuilder buff = new StringBuilder(84);
/*     */     
/* 184 */     return buff.append((this._businessDayDate == null) ? "null" : 
/* 185 */         String.valueOf(this._businessDayDate.getTimeSerializable()))
/* 186 */       .append("::").append(String.valueOf(this._organizationId))
/* 187 */       .append("::").append(String.valueOf(this._retailLocationId))
/* 188 */       .append("::").append(String.valueOf(this._serializedCountSequence))
/* 189 */       .append("::").append(this._tenderTypeCode)
/* 190 */       .append("::").append(String.valueOf(this._transactionSequence))
/* 191 */       .append("::").append(String.valueOf(this._workstationId))
/* 192 */       .toString();
/*     */   }
/*     */   
/*     */   public boolean validate() {
/* 196 */     if (this._businessDayDate == null) {
/* 197 */       return false;
/*     */     }
/* 199 */     if (this._retailLocationId == null) {
/* 200 */       return false;
/*     */     }
/* 202 */     if (this._serializedCountSequence == null) {
/* 203 */       return false;
/*     */     }
/* 205 */     if (this._tenderTypeCode == null) {
/* 206 */       return false;
/*     */     }
/* 208 */     if (this._transactionSequence == null) {
/* 209 */       return false;
/*     */     }
/* 211 */     if (this._workstationId == null) {
/* 212 */       return false;
/*     */     }
/* 214 */     return true;
/*     */   }
/*     */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\tsn\TenderSerializedCountId.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */