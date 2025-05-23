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
/*     */ 
/*     */ public class ReceiptDataId
/*     */   extends AbstractObjectId
/*     */ {
/*     */   private static final long serialVersionUID = -593976862L;
/*     */   private Long _retailLocationId;
/*     */   private Long _workstationId;
/*     */   private DtvDate _businessDate;
/*     */   private Long _transactionSequence;
/*     */   private String _receiptId;
/*     */   
/*     */   public ReceiptDataId() {}
/*     */   
/*     */   public ReceiptDataId(String argObjectIdValue) {
/*  25 */     setValue(argObjectIdValue);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Long getRetailLocationId() {
/*  35 */     return this._retailLocationId;
/*     */   }
/*     */   
/*     */   public void setRetailLocationId(Long argRetailLocationId) {
/*  39 */     this._retailLocationId = argRetailLocationId;
/*     */   }
/*     */   
/*     */   public Long getWorkstationId() {
/*  43 */     return this._workstationId;
/*     */   }
/*     */   
/*     */   public void setWorkstationId(Long argWorkstationId) {
/*  47 */     this._workstationId = argWorkstationId;
/*     */   }
/*     */   
/*     */   public Date getBusinessDate() {
/*  51 */     return (Date)this._businessDate;
/*     */   }
/*     */   
/*     */   public void setBusinessDate(Date argBusinessDate) {
/*  55 */     this._businessDate = (argBusinessDate == null || argBusinessDate instanceof DtvDate) ? (DtvDate)argBusinessDate : new DtvDate(argBusinessDate);
/*     */   }
/*     */ 
/*     */   
/*     */   public Long getTransactionSequence() {
/*  60 */     return this._transactionSequence;
/*     */   }
/*     */   
/*     */   public void setTransactionSequence(Long argTransactionSequence) {
/*  64 */     this._transactionSequence = argTransactionSequence;
/*     */   }
/*     */   
/*     */   public String getReceiptId() {
/*  68 */     return this._receiptId;
/*     */   }
/*     */   
/*     */   public void setReceiptId(String argReceiptId) {
/*  72 */     this._receiptId = (argReceiptId != null && MANAGE_CASE) ? argReceiptId.toUpperCase() : argReceiptId;
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
/*  84 */       setOrganizationId(Long.valueOf(str));
/*  85 */       str = tokens[1];
/*     */       
/*  87 */       setRetailLocationId(Long.valueOf(str));
/*  88 */       str = tokens[2];
/*     */       
/*  90 */       setWorkstationId(Long.valueOf(str));
/*  91 */       str = tokens[3];
/*     */       
/*  93 */       if ("null".equals(str)) {
/*  94 */         setBusinessDate((Date)null);
/*     */       } else {
/*     */         
/*  97 */         setBusinessDate((Date)new DtvDate());
/*  98 */         this._businessDate.setTimeFromSerialization(Long.parseLong(str));
/*     */       } 
/* 100 */       str = tokens[4];
/*     */       
/* 102 */       setTransactionSequence(Long.valueOf(str));
/* 103 */       str = tokens[5];
/*     */       
/* 105 */       if ("null".equals(str)) {
/* 106 */         setReceiptId((String)null);
/*     */       } else {
/*     */         
/* 109 */         setReceiptId(str);
/*     */       }
/*     */     
/* 112 */     } catch (Exception ee) {
/* 113 */       throw new DtxException("An exception occured while parsing object id string: " + argObjectIdValue, ee);
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean equals(Object ob) {
/* 119 */     if (this == ob) {
/* 120 */       return true;
/*     */     }
/* 122 */     if (!(ob instanceof ReceiptDataId)) {
/* 123 */       return false;
/*     */     }
/* 125 */     ReceiptDataId other = (ReceiptDataId)ob;
/* 126 */     return (((this._organizationId == null && other._organizationId == null) || (this._organizationId != null && this._organizationId
/*     */ 
/*     */       
/* 129 */       .equals(other._organizationId))) && ((this._retailLocationId == null && other._retailLocationId == null) || (this._retailLocationId != null && this._retailLocationId
/*     */ 
/*     */       
/* 132 */       .equals(other._retailLocationId))) && ((this._workstationId == null && other._workstationId == null) || (this._workstationId != null && this._workstationId
/*     */ 
/*     */       
/* 135 */       .equals(other._workstationId))) && ((this._businessDate == null && other._businessDate == null) || (this._businessDate != null && this._businessDate
/*     */ 
/*     */       
/* 138 */       .equals(other._businessDate))) && ((this._transactionSequence == null && other._transactionSequence == null) || (this._transactionSequence != null && this._transactionSequence
/*     */ 
/*     */       
/* 141 */       .equals(other._transactionSequence))) && ((this._receiptId == null && other._receiptId == null) || (this._receiptId != null && this._receiptId
/*     */ 
/*     */       
/* 144 */       .equals(other._receiptId))));
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public int hashCode() {
/* 150 */     return ((this._organizationId == null) ? 0 : this._organizationId
/* 151 */       .hashCode()) + ((this._retailLocationId == null) ? 0 : this._retailLocationId
/* 152 */       .hashCode()) + ((this._workstationId == null) ? 0 : this._workstationId
/* 153 */       .hashCode()) + ((this._businessDate == null) ? 0 : this._businessDate
/* 154 */       .hashCode()) + ((this._transactionSequence == null) ? 0 : this._transactionSequence
/* 155 */       .hashCode()) + ((this._receiptId == null) ? 0 : this._receiptId
/* 156 */       .hashCode());
/*     */   }
/*     */ 
/*     */   
/*     */   public String getDtxTypeName() {
/* 161 */     return "ReceiptData";
/*     */   }
/*     */ 
/*     */   
/*     */   public String toString() {
/* 166 */     StringBuilder buff = new StringBuilder(72);
/*     */     
/* 168 */     return buff.append(
/* 169 */         String.valueOf(this._organizationId))
/* 170 */       .append("::").append(String.valueOf(this._retailLocationId))
/* 171 */       .append("::").append(String.valueOf(this._workstationId))
/* 172 */       .append("::").append((this._businessDate == null) ? "null" : String.valueOf(this._businessDate.getTimeSerializable()))
/* 173 */       .append("::").append(String.valueOf(this._transactionSequence))
/* 174 */       .append("::").append(this._receiptId)
/* 175 */       .toString();
/*     */   }
/*     */   
/*     */   public boolean validate() {
/* 179 */     if (this._retailLocationId == null) {
/* 180 */       return false;
/*     */     }
/* 182 */     if (this._workstationId == null) {
/* 183 */       return false;
/*     */     }
/* 185 */     if (this._businessDate == null) {
/* 186 */       return false;
/*     */     }
/* 188 */     if (this._transactionSequence == null) {
/* 189 */       return false;
/*     */     }
/* 191 */     if (this._receiptId == null) {
/* 192 */       return false;
/*     */     }
/* 194 */     return true;
/*     */   }
/*     */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\trn\ReceiptDataId.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */