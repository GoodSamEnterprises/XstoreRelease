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
/*     */ 
/*     */ public class TransactionVersionId
/*     */   extends AbstractObjectId
/*     */ {
/*     */   private static final long serialVersionUID = 1583695930L;
/*     */   private Long _retailLocationId;
/*     */   private DtvDate _businessDate;
/*     */   private Long _workstationId;
/*     */   private Long _transactionSequence;
/*     */   
/*     */   public TransactionVersionId() {}
/*     */   
/*     */   public TransactionVersionId(String argObjectIdValue) {
/*  25 */     setValue(argObjectIdValue);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Long getRetailLocationId() {
/*  34 */     return this._retailLocationId;
/*     */   }
/*     */   
/*     */   public void setRetailLocationId(Long argRetailLocationId) {
/*  38 */     this._retailLocationId = argRetailLocationId;
/*     */   }
/*     */   
/*     */   public Date getBusinessDate() {
/*  42 */     return (Date)this._businessDate;
/*     */   }
/*     */   
/*     */   public void setBusinessDate(Date argBusinessDate) {
/*  46 */     this._businessDate = (argBusinessDate == null || argBusinessDate instanceof DtvDate) ? (DtvDate)argBusinessDate : new DtvDate(argBusinessDate);
/*     */   }
/*     */ 
/*     */   
/*     */   public Long getWorkstationId() {
/*  51 */     return this._workstationId;
/*     */   }
/*     */   
/*     */   public void setWorkstationId(Long argWorkstationId) {
/*  55 */     this._workstationId = argWorkstationId;
/*     */   }
/*     */   
/*     */   public Long getTransactionSequence() {
/*  59 */     return this._transactionSequence;
/*     */   }
/*     */   
/*     */   public void setTransactionSequence(Long argTransactionSequence) {
/*  63 */     this._transactionSequence = argTransactionSequence;
/*     */   }
/*     */   
/*     */   public void setValue(String argObjectIdValue) {
/*  67 */     String str = argObjectIdValue;
/*  68 */     if (StringUtils.isEmpty(str)) {
/*  69 */       throw new DtxException("argument passed to setValue() is null or empty - a valid value must be passed");
/*     */     }
/*     */     try {
/*  72 */       String[] tokens = str.split("::");
/*  73 */       str = tokens[0];
/*     */       
/*  75 */       setOrganizationId(Long.valueOf(str));
/*  76 */       str = tokens[1];
/*     */       
/*  78 */       setRetailLocationId(Long.valueOf(str));
/*  79 */       str = tokens[2];
/*     */       
/*  81 */       if ("null".equals(str)) {
/*  82 */         setBusinessDate((Date)null);
/*     */       } else {
/*     */         
/*  85 */         setBusinessDate((Date)new DtvDate());
/*  86 */         this._businessDate.setTimeFromSerialization(Long.parseLong(str));
/*     */       } 
/*  88 */       str = tokens[3];
/*     */       
/*  90 */       setWorkstationId(Long.valueOf(str));
/*  91 */       str = tokens[4];
/*     */       
/*  93 */       setTransactionSequence(Long.valueOf(str));
/*     */     }
/*  95 */     catch (Exception ee) {
/*  96 */       throw new DtxException("An exception occured while parsing object id string: " + argObjectIdValue, ee);
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean equals(Object ob) {
/* 102 */     if (this == ob) {
/* 103 */       return true;
/*     */     }
/* 105 */     if (!(ob instanceof TransactionVersionId)) {
/* 106 */       return false;
/*     */     }
/* 108 */     TransactionVersionId other = (TransactionVersionId)ob;
/* 109 */     return (((this._organizationId == null && other._organizationId == null) || (this._organizationId != null && this._organizationId
/*     */ 
/*     */       
/* 112 */       .equals(other._organizationId))) && ((this._retailLocationId == null && other._retailLocationId == null) || (this._retailLocationId != null && this._retailLocationId
/*     */ 
/*     */       
/* 115 */       .equals(other._retailLocationId))) && ((this._businessDate == null && other._businessDate == null) || (this._businessDate != null && this._businessDate
/*     */ 
/*     */       
/* 118 */       .equals(other._businessDate))) && ((this._workstationId == null && other._workstationId == null) || (this._workstationId != null && this._workstationId
/*     */ 
/*     */       
/* 121 */       .equals(other._workstationId))) && ((this._transactionSequence == null && other._transactionSequence == null) || (this._transactionSequence != null && this._transactionSequence
/*     */ 
/*     */       
/* 124 */       .equals(other._transactionSequence))));
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public int hashCode() {
/* 130 */     return ((this._organizationId == null) ? 0 : this._organizationId
/* 131 */       .hashCode()) + ((this._retailLocationId == null) ? 0 : this._retailLocationId
/* 132 */       .hashCode()) + ((this._businessDate == null) ? 0 : this._businessDate
/* 133 */       .hashCode()) + ((this._workstationId == null) ? 0 : this._workstationId
/* 134 */       .hashCode()) + ((this._transactionSequence == null) ? 0 : this._transactionSequence
/* 135 */       .hashCode());
/*     */   }
/*     */ 
/*     */   
/*     */   public String getDtxTypeName() {
/* 140 */     return "TransactionVersion";
/*     */   }
/*     */ 
/*     */   
/*     */   public String toString() {
/* 145 */     StringBuilder buff = new StringBuilder(60);
/*     */     
/* 147 */     return buff.append(
/* 148 */         String.valueOf(this._organizationId))
/* 149 */       .append("::").append(String.valueOf(this._retailLocationId))
/* 150 */       .append("::").append((this._businessDate == null) ? "null" : String.valueOf(this._businessDate.getTimeSerializable()))
/* 151 */       .append("::").append(String.valueOf(this._workstationId))
/* 152 */       .append("::").append(String.valueOf(this._transactionSequence))
/* 153 */       .toString();
/*     */   }
/*     */   
/*     */   public boolean validate() {
/* 157 */     if (this._retailLocationId == null) {
/* 158 */       return false;
/*     */     }
/* 160 */     if (this._businessDate == null) {
/* 161 */       return false;
/*     */     }
/* 163 */     if (this._workstationId == null) {
/* 164 */       return false;
/*     */     }
/* 166 */     if (this._transactionSequence == null) {
/* 167 */       return false;
/*     */     }
/* 169 */     return true;
/*     */   }
/*     */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\trn\TransactionVersionId.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */