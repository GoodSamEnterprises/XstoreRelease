/*     */ package dtv.xst.dao.trn;
/*     */ 
/*     */ import dtv.data2.access.AbstractObjectId;
/*     */ import dtv.data2.access.exception.DtxException;
/*     */ import dtv.util.DtvDate;
/*     */ import dtv.util.StringUtils;
/*     */ import java.util.Date;
/*     */ 
/*     */ 
/*     */ 
/*     */ public class ReceiptDataPropertyId
/*     */   extends AbstractObjectId
/*     */ {
/*     */   private static final long serialVersionUID = 2071585239L;
/*     */   private Long _retailLocationId;
/*     */   private Long _workstationId;
/*     */   private DtvDate _businessDate;
/*     */   private Long _transactionSequence;
/*     */   private String _receiptId;
/*     */   private String _propertyCode;
/*     */   
/*     */   public ReceiptDataPropertyId() {}
/*     */   
/*     */   public ReceiptDataPropertyId(String argObjectIdValue) {
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
/*     */   public Long getRetailLocationId() {
/*  36 */     return this._retailLocationId;
/*     */   }
/*     */   
/*     */   public void setRetailLocationId(Long argRetailLocationId) {
/*  40 */     this._retailLocationId = argRetailLocationId;
/*     */   }
/*     */   
/*     */   public Long getWorkstationId() {
/*  44 */     return this._workstationId;
/*     */   }
/*     */   
/*     */   public void setWorkstationId(Long argWorkstationId) {
/*  48 */     this._workstationId = argWorkstationId;
/*     */   }
/*     */   
/*     */   public Date getBusinessDate() {
/*  52 */     return (Date)this._businessDate;
/*     */   }
/*     */   
/*     */   public void setBusinessDate(Date argBusinessDate) {
/*  56 */     this._businessDate = (argBusinessDate == null || argBusinessDate instanceof DtvDate) ? (DtvDate)argBusinessDate : new DtvDate(argBusinessDate);
/*     */   }
/*     */ 
/*     */   
/*     */   public Long getTransactionSequence() {
/*  61 */     return this._transactionSequence;
/*     */   }
/*     */   
/*     */   public void setTransactionSequence(Long argTransactionSequence) {
/*  65 */     this._transactionSequence = argTransactionSequence;
/*     */   }
/*     */   
/*     */   public String getReceiptId() {
/*  69 */     return this._receiptId;
/*     */   }
/*     */   
/*     */   public void setReceiptId(String argReceiptId) {
/*  73 */     this._receiptId = (argReceiptId != null && MANAGE_CASE) ? argReceiptId.toUpperCase() : argReceiptId;
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
/*  96 */       setRetailLocationId(Long.valueOf(str));
/*  97 */       str = tokens[2];
/*     */       
/*  99 */       setWorkstationId(Long.valueOf(str));
/* 100 */       str = tokens[3];
/*     */       
/* 102 */       if ("null".equals(str)) {
/* 103 */         setBusinessDate((Date)null);
/*     */       } else {
/*     */         
/* 106 */         setBusinessDate((Date)new DtvDate());
/* 107 */         this._businessDate.setTimeFromSerialization(Long.parseLong(str));
/*     */       } 
/* 109 */       str = tokens[4];
/*     */       
/* 111 */       setTransactionSequence(Long.valueOf(str));
/* 112 */       str = tokens[5];
/*     */       
/* 114 */       if ("null".equals(str)) {
/* 115 */         setReceiptId((String)null);
/*     */       } else {
/*     */         
/* 118 */         setReceiptId(str);
/*     */       } 
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
/* 139 */     if (!(ob instanceof ReceiptDataPropertyId)) {
/* 140 */       return false;
/*     */     }
/* 142 */     ReceiptDataPropertyId other = (ReceiptDataPropertyId)ob;
/* 143 */     return (((this._organizationId == null && other._organizationId == null) || (this._organizationId != null && this._organizationId
/*     */ 
/*     */       
/* 146 */       .equals(other._organizationId))) && ((this._retailLocationId == null && other._retailLocationId == null) || (this._retailLocationId != null && this._retailLocationId
/*     */ 
/*     */       
/* 149 */       .equals(other._retailLocationId))) && ((this._workstationId == null && other._workstationId == null) || (this._workstationId != null && this._workstationId
/*     */ 
/*     */       
/* 152 */       .equals(other._workstationId))) && ((this._businessDate == null && other._businessDate == null) || (this._businessDate != null && this._businessDate
/*     */ 
/*     */       
/* 155 */       .equals(other._businessDate))) && ((this._transactionSequence == null && other._transactionSequence == null) || (this._transactionSequence != null && this._transactionSequence
/*     */ 
/*     */       
/* 158 */       .equals(other._transactionSequence))) && ((this._receiptId == null && other._receiptId == null) || (this._receiptId != null && this._receiptId
/*     */ 
/*     */       
/* 161 */       .equals(other._receiptId))) && ((this._propertyCode == null && other._propertyCode == null) || (this._propertyCode != null && this._propertyCode
/*     */ 
/*     */       
/* 164 */       .equals(other._propertyCode))));
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public int hashCode() {
/* 170 */     return ((this._organizationId == null) ? 0 : this._organizationId
/* 171 */       .hashCode()) + ((this._retailLocationId == null) ? 0 : this._retailLocationId
/* 172 */       .hashCode()) + ((this._workstationId == null) ? 0 : this._workstationId
/* 173 */       .hashCode()) + ((this._businessDate == null) ? 0 : this._businessDate
/* 174 */       .hashCode()) + ((this._transactionSequence == null) ? 0 : this._transactionSequence
/* 175 */       .hashCode()) + ((this._receiptId == null) ? 0 : this._receiptId
/* 176 */       .hashCode()) + ((this._propertyCode == null) ? 0 : this._propertyCode
/* 177 */       .hashCode());
/*     */   }
/*     */ 
/*     */   
/*     */   public String getDtxTypeName() {
/* 182 */     return "ReceiptDataProperty";
/*     */   }
/*     */ 
/*     */   
/*     */   public String toString() {
/* 187 */     StringBuilder buff = new StringBuilder(84);
/*     */     
/* 189 */     return buff.append(
/* 190 */         String.valueOf(this._organizationId))
/* 191 */       .append("::").append(String.valueOf(this._retailLocationId))
/* 192 */       .append("::").append(String.valueOf(this._workstationId))
/* 193 */       .append("::").append((this._businessDate == null) ? "null" : String.valueOf(this._businessDate.getTimeSerializable()))
/* 194 */       .append("::").append(String.valueOf(this._transactionSequence))
/* 195 */       .append("::").append(this._receiptId)
/* 196 */       .append("::").append(this._propertyCode)
/* 197 */       .toString();
/*     */   }
/*     */   
/*     */   public boolean validate() {
/* 201 */     if (this._retailLocationId == null) {
/* 202 */       return false;
/*     */     }
/* 204 */     if (this._workstationId == null) {
/* 205 */       return false;
/*     */     }
/* 207 */     if (this._businessDate == null) {
/* 208 */       return false;
/*     */     }
/* 210 */     if (this._transactionSequence == null) {
/* 211 */       return false;
/*     */     }
/* 213 */     if (this._receiptId == null) {
/* 214 */       return false;
/*     */     }
/* 216 */     if (this._propertyCode == null) {
/* 217 */       return false;
/*     */     }
/* 219 */     return true;
/*     */   }
/*     */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\trn\ReceiptDataPropertyId.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */