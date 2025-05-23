/*     */ package dtv.xst.dao.ttr;
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
/*     */ public class TenderSignatureId
/*     */   extends AbstractObjectId
/*     */ {
/*     */   private static final long serialVersionUID = 1418685476L;
/*     */   private Long _retailLocationId;
/*     */   private DtvDate _businessDate;
/*     */   private Long _workstationId;
/*     */   private Long _transactionSequence;
/*     */   private Integer _retailTransactionLineItemSequence;
/*     */   
/*     */   public TenderSignatureId() {}
/*     */   
/*     */   public TenderSignatureId(String argObjectIdValue) {
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
/*     */   public Date getBusinessDate() {
/*  43 */     return (Date)this._businessDate;
/*     */   }
/*     */   
/*     */   public void setBusinessDate(Date argBusinessDate) {
/*  47 */     this._businessDate = (argBusinessDate == null || argBusinessDate instanceof DtvDate) ? (DtvDate)argBusinessDate : new DtvDate(argBusinessDate);
/*     */   }
/*     */ 
/*     */   
/*     */   public Long getWorkstationId() {
/*  52 */     return this._workstationId;
/*     */   }
/*     */   
/*     */   public void setWorkstationId(Long argWorkstationId) {
/*  56 */     this._workstationId = argWorkstationId;
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
/*     */   public Integer getRetailTransactionLineItemSequence() {
/*  68 */     return this._retailTransactionLineItemSequence;
/*     */   }
/*     */   
/*     */   public void setRetailTransactionLineItemSequence(Integer argRetailTransactionLineItemSequence) {
/*  72 */     this._retailTransactionLineItemSequence = argRetailTransactionLineItemSequence;
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
/*  90 */       if ("null".equals(str)) {
/*  91 */         setBusinessDate((Date)null);
/*     */       } else {
/*     */         
/*  94 */         setBusinessDate((Date)new DtvDate());
/*  95 */         this._businessDate.setTimeFromSerialization(Long.parseLong(str));
/*     */       } 
/*  97 */       str = tokens[3];
/*     */       
/*  99 */       setWorkstationId(Long.valueOf(str));
/* 100 */       str = tokens[4];
/*     */       
/* 102 */       setTransactionSequence(Long.valueOf(str));
/* 103 */       str = tokens[5];
/*     */       
/* 105 */       setRetailTransactionLineItemSequence(Integer.valueOf(str));
/*     */     }
/* 107 */     catch (Exception ee) {
/* 108 */       throw new DtxException("An exception occured while parsing object id string: " + argObjectIdValue, ee);
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean equals(Object ob) {
/* 114 */     if (this == ob) {
/* 115 */       return true;
/*     */     }
/* 117 */     if (!(ob instanceof TenderSignatureId)) {
/* 118 */       return false;
/*     */     }
/* 120 */     TenderSignatureId other = (TenderSignatureId)ob;
/* 121 */     return (((this._organizationId == null && other._organizationId == null) || (this._organizationId != null && this._organizationId
/*     */ 
/*     */       
/* 124 */       .equals(other._organizationId))) && ((this._retailLocationId == null && other._retailLocationId == null) || (this._retailLocationId != null && this._retailLocationId
/*     */ 
/*     */       
/* 127 */       .equals(other._retailLocationId))) && ((this._businessDate == null && other._businessDate == null) || (this._businessDate != null && this._businessDate
/*     */ 
/*     */       
/* 130 */       .equals(other._businessDate))) && ((this._workstationId == null && other._workstationId == null) || (this._workstationId != null && this._workstationId
/*     */ 
/*     */       
/* 133 */       .equals(other._workstationId))) && ((this._transactionSequence == null && other._transactionSequence == null) || (this._transactionSequence != null && this._transactionSequence
/*     */ 
/*     */       
/* 136 */       .equals(other._transactionSequence))) && ((this._retailTransactionLineItemSequence == null && other._retailTransactionLineItemSequence == null) || (this._retailTransactionLineItemSequence != null && this._retailTransactionLineItemSequence
/*     */ 
/*     */       
/* 139 */       .equals(other._retailTransactionLineItemSequence))));
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public int hashCode() {
/* 145 */     return ((this._organizationId == null) ? 0 : this._organizationId
/* 146 */       .hashCode()) + ((this._retailLocationId == null) ? 0 : this._retailLocationId
/* 147 */       .hashCode()) + ((this._businessDate == null) ? 0 : this._businessDate
/* 148 */       .hashCode()) + ((this._workstationId == null) ? 0 : this._workstationId
/* 149 */       .hashCode()) + ((this._transactionSequence == null) ? 0 : this._transactionSequence
/* 150 */       .hashCode()) + ((this._retailTransactionLineItemSequence == null) ? 0 : this._retailTransactionLineItemSequence
/* 151 */       .hashCode());
/*     */   }
/*     */ 
/*     */   
/*     */   public String getDtxTypeName() {
/* 156 */     return "TenderSignature";
/*     */   }
/*     */ 
/*     */   
/*     */   public String toString() {
/* 161 */     StringBuilder buff = new StringBuilder(72);
/*     */     
/* 163 */     return buff.append(
/* 164 */         String.valueOf(this._organizationId))
/* 165 */       .append("::").append(String.valueOf(this._retailLocationId))
/* 166 */       .append("::").append((this._businessDate == null) ? "null" : String.valueOf(this._businessDate.getTimeSerializable()))
/* 167 */       .append("::").append(String.valueOf(this._workstationId))
/* 168 */       .append("::").append(String.valueOf(this._transactionSequence))
/* 169 */       .append("::").append(String.valueOf(this._retailTransactionLineItemSequence))
/* 170 */       .toString();
/*     */   }
/*     */   
/*     */   public boolean validate() {
/* 174 */     if (this._retailLocationId == null) {
/* 175 */       return false;
/*     */     }
/* 177 */     if (this._businessDate == null) {
/* 178 */       return false;
/*     */     }
/* 180 */     if (this._workstationId == null) {
/* 181 */       return false;
/*     */     }
/* 183 */     if (this._transactionSequence == null) {
/* 184 */       return false;
/*     */     }
/* 186 */     if (this._retailTransactionLineItemSequence == null) {
/* 187 */       return false;
/*     */     }
/* 189 */     return true;
/*     */   }
/*     */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\ttr\TenderSignatureId.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */