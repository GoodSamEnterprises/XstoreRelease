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
/*     */ 
/*     */ public class TenderTypeCountId
/*     */   extends AbstractObjectId
/*     */ {
/*     */   private static final long serialVersionUID = 838474081L;
/*     */   private DtvDate _businessDayDate;
/*     */   private Long _retailLocationId;
/*     */   private String _tenderTypeCode;
/*     */   private Long _transactionSequence;
/*     */   private Long _workstationId;
/*     */   
/*     */   public TenderTypeCountId() {}
/*     */   
/*     */   public TenderTypeCountId(String argObjectIdValue) {
/*  25 */     setValue(argObjectIdValue);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Date getBusinessDayDate() {
/*  35 */     return (Date)this._businessDayDate;
/*     */   }
/*     */   
/*     */   public void setBusinessDayDate(Date argBusinessDayDate) {
/*  39 */     this._businessDayDate = (argBusinessDayDate == null || argBusinessDayDate instanceof DtvDate) ? (DtvDate)argBusinessDayDate : new DtvDate(argBusinessDayDate);
/*     */   }
/*     */ 
/*     */   
/*     */   public Long getRetailLocationId() {
/*  44 */     return this._retailLocationId;
/*     */   }
/*     */   
/*     */   public void setRetailLocationId(Long argRetailLocationId) {
/*  48 */     this._retailLocationId = argRetailLocationId;
/*     */   }
/*     */   
/*     */   public String getTenderTypeCode() {
/*  52 */     return this._tenderTypeCode;
/*     */   }
/*     */   
/*     */   public void setTenderTypeCode(String argTenderTypeCode) {
/*  56 */     this._tenderTypeCode = (argTenderTypeCode != null && MANAGE_CASE) ? argTenderTypeCode.toUpperCase() : argTenderTypeCode;
/*     */   }
/*     */   
/*     */   public Long getTransactionSequence() {
/*  60 */     return this._transactionSequence;
/*     */   }
/*     */   
/*     */   public void setTransactionSequence(Long argTransactionSequence) {
/*  64 */     this._transactionSequence = argTransactionSequence;
/*     */   }
/*     */   
/*     */   public Long getWorkstationId() {
/*  68 */     return this._workstationId;
/*     */   }
/*     */   
/*     */   public void setWorkstationId(Long argWorkstationId) {
/*  72 */     this._workstationId = argWorkstationId;
/*     */   }
/*     */   
/*     */   public void setValue(String argObjectIdValue) {
/*  76 */     String str = argObjectIdValue;
/*  77 */     if (StringUtils.isEmpty(str)) {
/*  78 */       throw new DtxException("argument passed to setValue() is null or empty - a valid value must be passed");
/*     */     }
/*     */     try {
/*  81 */       String[] tokens = str.split("::");
/*  82 */       str = tokens[0];
/*     */       
/*  84 */       if ("null".equals(str)) {
/*  85 */         setBusinessDayDate((Date)null);
/*     */       } else {
/*     */         
/*  88 */         setBusinessDayDate((Date)new DtvDate());
/*  89 */         this._businessDayDate.setTimeFromSerialization(Long.parseLong(str));
/*     */       } 
/*  91 */       str = tokens[1];
/*     */       
/*  93 */       setOrganizationId(Long.valueOf(str));
/*  94 */       str = tokens[2];
/*     */       
/*  96 */       setRetailLocationId(Long.valueOf(str));
/*  97 */       str = tokens[3];
/*     */       
/*  99 */       if ("null".equals(str)) {
/* 100 */         setTenderTypeCode((String)null);
/*     */       } else {
/*     */         
/* 103 */         setTenderTypeCode(str);
/*     */       } 
/* 105 */       str = tokens[4];
/*     */       
/* 107 */       setTransactionSequence(Long.valueOf(str));
/* 108 */       str = tokens[5];
/*     */       
/* 110 */       setWorkstationId(Long.valueOf(str));
/*     */     }
/* 112 */     catch (Exception ee) {
/* 113 */       throw new DtxException("An exception occured while parsing object id string: " + argObjectIdValue, ee);
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean equals(Object ob) {
/* 119 */     if (this == ob) {
/* 120 */       return true;
/*     */     }
/* 122 */     if (!(ob instanceof TenderTypeCountId)) {
/* 123 */       return false;
/*     */     }
/* 125 */     TenderTypeCountId other = (TenderTypeCountId)ob;
/* 126 */     return (((this._businessDayDate == null && other._businessDayDate == null) || (this._businessDayDate != null && this._businessDayDate
/*     */ 
/*     */       
/* 129 */       .equals(other._businessDayDate))) && ((this._organizationId == null && other._organizationId == null) || (this._organizationId != null && this._organizationId
/*     */ 
/*     */       
/* 132 */       .equals(other._organizationId))) && ((this._retailLocationId == null && other._retailLocationId == null) || (this._retailLocationId != null && this._retailLocationId
/*     */ 
/*     */       
/* 135 */       .equals(other._retailLocationId))) && ((this._tenderTypeCode == null && other._tenderTypeCode == null) || (this._tenderTypeCode != null && this._tenderTypeCode
/*     */ 
/*     */       
/* 138 */       .equals(other._tenderTypeCode))) && ((this._transactionSequence == null && other._transactionSequence == null) || (this._transactionSequence != null && this._transactionSequence
/*     */ 
/*     */       
/* 141 */       .equals(other._transactionSequence))) && ((this._workstationId == null && other._workstationId == null) || (this._workstationId != null && this._workstationId
/*     */ 
/*     */       
/* 144 */       .equals(other._workstationId))));
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public int hashCode() {
/* 150 */     return ((this._businessDayDate == null) ? 0 : this._businessDayDate
/* 151 */       .hashCode()) + ((this._organizationId == null) ? 0 : this._organizationId
/* 152 */       .hashCode()) + ((this._retailLocationId == null) ? 0 : this._retailLocationId
/* 153 */       .hashCode()) + ((this._tenderTypeCode == null) ? 0 : this._tenderTypeCode
/* 154 */       .hashCode()) + ((this._transactionSequence == null) ? 0 : this._transactionSequence
/* 155 */       .hashCode()) + ((this._workstationId == null) ? 0 : this._workstationId
/* 156 */       .hashCode());
/*     */   }
/*     */ 
/*     */   
/*     */   public String getDtxTypeName() {
/* 161 */     return "TenderTypeCount";
/*     */   }
/*     */ 
/*     */   
/*     */   public String toString() {
/* 166 */     StringBuilder buff = new StringBuilder(72);
/*     */     
/* 168 */     return buff.append((this._businessDayDate == null) ? "null" : 
/* 169 */         String.valueOf(this._businessDayDate.getTimeSerializable()))
/* 170 */       .append("::").append(String.valueOf(this._organizationId))
/* 171 */       .append("::").append(String.valueOf(this._retailLocationId))
/* 172 */       .append("::").append(this._tenderTypeCode)
/* 173 */       .append("::").append(String.valueOf(this._transactionSequence))
/* 174 */       .append("::").append(String.valueOf(this._workstationId))
/* 175 */       .toString();
/*     */   }
/*     */   
/*     */   public boolean validate() {
/* 179 */     if (this._businessDayDate == null) {
/* 180 */       return false;
/*     */     }
/* 182 */     if (this._retailLocationId == null) {
/* 183 */       return false;
/*     */     }
/* 185 */     if (this._tenderTypeCode == null) {
/* 186 */       return false;
/*     */     }
/* 188 */     if (this._transactionSequence == null) {
/* 189 */       return false;
/*     */     }
/* 191 */     if (this._workstationId == null) {
/* 192 */       return false;
/*     */     }
/* 194 */     return true;
/*     */   }
/*     */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\tsn\TenderTypeCountId.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */