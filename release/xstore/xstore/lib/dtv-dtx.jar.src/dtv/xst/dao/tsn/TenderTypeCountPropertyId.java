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
/*     */ public class TenderTypeCountPropertyId
/*     */   extends AbstractObjectId
/*     */ {
/*     */   private static final long serialVersionUID = 1030187606L;
/*     */   private DtvDate _businessDayDate;
/*     */   private Long _retailLocationId;
/*     */   private String _tenderTypeCode;
/*     */   private Long _transactionSequence;
/*     */   private Long _workstationId;
/*     */   private String _propertyCode;
/*     */   
/*     */   public TenderTypeCountPropertyId() {}
/*     */   
/*     */   public TenderTypeCountPropertyId(String argObjectIdValue) {
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
/*     */   public String getTenderTypeCode() {
/*  53 */     return this._tenderTypeCode;
/*     */   }
/*     */   
/*     */   public void setTenderTypeCode(String argTenderTypeCode) {
/*  57 */     this._tenderTypeCode = (argTenderTypeCode != null && MANAGE_CASE) ? argTenderTypeCode.toUpperCase() : argTenderTypeCode;
/*     */   }
/*     */   
/*     */   public Long getTransactionSequence() {
/*  61 */     return this._transactionSequence;
/*     */   }
/*     */   
/*     */   public void setTransactionSequence(Long argTransactionSequence) {
/*  65 */     this._transactionSequence = argTransactionSequence;
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
/* 108 */       if ("null".equals(str)) {
/* 109 */         setTenderTypeCode((String)null);
/*     */       } else {
/*     */         
/* 112 */         setTenderTypeCode(str);
/*     */       } 
/* 114 */       str = tokens[4];
/*     */       
/* 116 */       setTransactionSequence(Long.valueOf(str));
/* 117 */       str = tokens[5];
/*     */       
/* 119 */       setWorkstationId(Long.valueOf(str));
/* 120 */       str = tokens[6];
/*     */       
/* 122 */       if ("null".equals(str)) {
/* 123 */         setPropertyCode((String)null);
/*     */       } else {
/*     */         
/* 126 */         setPropertyCode(str);
/*     */       }
/*     */     
/* 129 */     } catch (Exception ee) {
/* 130 */       throw new DtxException("An exception occured while parsing object id string: " + argObjectIdValue, ee);
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean equals(Object ob) {
/* 136 */     if (this == ob) {
/* 137 */       return true;
/*     */     }
/* 139 */     if (!(ob instanceof TenderTypeCountPropertyId)) {
/* 140 */       return false;
/*     */     }
/* 142 */     TenderTypeCountPropertyId other = (TenderTypeCountPropertyId)ob;
/* 143 */     return (((this._businessDayDate == null && other._businessDayDate == null) || (this._businessDayDate != null && this._businessDayDate
/*     */ 
/*     */       
/* 146 */       .equals(other._businessDayDate))) && ((this._organizationId == null && other._organizationId == null) || (this._organizationId != null && this._organizationId
/*     */ 
/*     */       
/* 149 */       .equals(other._organizationId))) && ((this._retailLocationId == null && other._retailLocationId == null) || (this._retailLocationId != null && this._retailLocationId
/*     */ 
/*     */       
/* 152 */       .equals(other._retailLocationId))) && ((this._tenderTypeCode == null && other._tenderTypeCode == null) || (this._tenderTypeCode != null && this._tenderTypeCode
/*     */ 
/*     */       
/* 155 */       .equals(other._tenderTypeCode))) && ((this._transactionSequence == null && other._transactionSequence == null) || (this._transactionSequence != null && this._transactionSequence
/*     */ 
/*     */       
/* 158 */       .equals(other._transactionSequence))) && ((this._workstationId == null && other._workstationId == null) || (this._workstationId != null && this._workstationId
/*     */ 
/*     */       
/* 161 */       .equals(other._workstationId))) && ((this._propertyCode == null && other._propertyCode == null) || (this._propertyCode != null && this._propertyCode
/*     */ 
/*     */       
/* 164 */       .equals(other._propertyCode))));
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public int hashCode() {
/* 170 */     return ((this._businessDayDate == null) ? 0 : this._businessDayDate
/* 171 */       .hashCode()) + ((this._organizationId == null) ? 0 : this._organizationId
/* 172 */       .hashCode()) + ((this._retailLocationId == null) ? 0 : this._retailLocationId
/* 173 */       .hashCode()) + ((this._tenderTypeCode == null) ? 0 : this._tenderTypeCode
/* 174 */       .hashCode()) + ((this._transactionSequence == null) ? 0 : this._transactionSequence
/* 175 */       .hashCode()) + ((this._workstationId == null) ? 0 : this._workstationId
/* 176 */       .hashCode()) + ((this._propertyCode == null) ? 0 : this._propertyCode
/* 177 */       .hashCode());
/*     */   }
/*     */ 
/*     */   
/*     */   public String getDtxTypeName() {
/* 182 */     return "TenderTypeCountProperty";
/*     */   }
/*     */ 
/*     */   
/*     */   public String toString() {
/* 187 */     StringBuilder buff = new StringBuilder(84);
/*     */     
/* 189 */     return buff.append((this._businessDayDate == null) ? "null" : 
/* 190 */         String.valueOf(this._businessDayDate.getTimeSerializable()))
/* 191 */       .append("::").append(String.valueOf(this._organizationId))
/* 192 */       .append("::").append(String.valueOf(this._retailLocationId))
/* 193 */       .append("::").append(this._tenderTypeCode)
/* 194 */       .append("::").append(String.valueOf(this._transactionSequence))
/* 195 */       .append("::").append(String.valueOf(this._workstationId))
/* 196 */       .append("::").append(this._propertyCode)
/* 197 */       .toString();
/*     */   }
/*     */   
/*     */   public boolean validate() {
/* 201 */     if (this._businessDayDate == null) {
/* 202 */       return false;
/*     */     }
/* 204 */     if (this._retailLocationId == null) {
/* 205 */       return false;
/*     */     }
/* 207 */     if (this._tenderTypeCode == null) {
/* 208 */       return false;
/*     */     }
/* 210 */     if (this._transactionSequence == null) {
/* 211 */       return false;
/*     */     }
/* 213 */     if (this._workstationId == null) {
/* 214 */       return false;
/*     */     }
/* 216 */     if (this._propertyCode == null) {
/* 217 */       return false;
/*     */     }
/* 219 */     return true;
/*     */   }
/*     */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\tsn\TenderTypeCountPropertyId.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */