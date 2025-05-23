/*     */ package dtv.xst.dao.trl;
/*     */ 
/*     */ import dtv.data2.access.AbstractObjectId;
/*     */ import dtv.data2.access.exception.DtxException;
/*     */ import dtv.util.DtvDate;
/*     */ import dtv.util.StringUtils;
/*     */ import java.util.Date;
/*     */ 
/*     */ 
/*     */ 
/*     */ public class ReturnedItemJournalId
/*     */   extends AbstractObjectId
/*     */ {
/*     */   private static final long serialVersionUID = 769133365L;
/*     */   private Long _retailLocationId;
/*     */   private Long _workstationId;
/*     */   private DtvDate _businessDate;
/*     */   private Integer _retailTransactionLineItemSequence;
/*     */   private Long _transactionSequence;
/*     */   private Long _journalSequence;
/*     */   
/*     */   public ReturnedItemJournalId() {}
/*     */   
/*     */   public ReturnedItemJournalId(String argObjectIdValue) {
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
/*     */   public Integer getRetailTransactionLineItemSequence() {
/*  61 */     return this._retailTransactionLineItemSequence;
/*     */   }
/*     */   
/*     */   public void setRetailTransactionLineItemSequence(Integer argRetailTransactionLineItemSequence) {
/*  65 */     this._retailTransactionLineItemSequence = argRetailTransactionLineItemSequence;
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
/*     */   public Long getJournalSequence() {
/*  77 */     return this._journalSequence;
/*     */   }
/*     */   
/*     */   public void setJournalSequence(Long argJournalSequence) {
/*  81 */     this._journalSequence = argJournalSequence;
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
/* 111 */       setRetailTransactionLineItemSequence(Integer.valueOf(str));
/* 112 */       str = tokens[5];
/*     */       
/* 114 */       setTransactionSequence(Long.valueOf(str));
/* 115 */       str = tokens[6];
/*     */       
/* 117 */       setJournalSequence(Long.valueOf(str));
/*     */     }
/* 119 */     catch (Exception ee) {
/* 120 */       throw new DtxException("An exception occured while parsing object id string: " + argObjectIdValue, ee);
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean equals(Object ob) {
/* 126 */     if (this == ob) {
/* 127 */       return true;
/*     */     }
/* 129 */     if (!(ob instanceof ReturnedItemJournalId)) {
/* 130 */       return false;
/*     */     }
/* 132 */     ReturnedItemJournalId other = (ReturnedItemJournalId)ob;
/* 133 */     return (((this._organizationId == null && other._organizationId == null) || (this._organizationId != null && this._organizationId
/*     */ 
/*     */       
/* 136 */       .equals(other._organizationId))) && ((this._retailLocationId == null && other._retailLocationId == null) || (this._retailLocationId != null && this._retailLocationId
/*     */ 
/*     */       
/* 139 */       .equals(other._retailLocationId))) && ((this._workstationId == null && other._workstationId == null) || (this._workstationId != null && this._workstationId
/*     */ 
/*     */       
/* 142 */       .equals(other._workstationId))) && ((this._businessDate == null && other._businessDate == null) || (this._businessDate != null && this._businessDate
/*     */ 
/*     */       
/* 145 */       .equals(other._businessDate))) && ((this._retailTransactionLineItemSequence == null && other._retailTransactionLineItemSequence == null) || (this._retailTransactionLineItemSequence != null && this._retailTransactionLineItemSequence
/*     */ 
/*     */       
/* 148 */       .equals(other._retailTransactionLineItemSequence))) && ((this._transactionSequence == null && other._transactionSequence == null) || (this._transactionSequence != null && this._transactionSequence
/*     */ 
/*     */       
/* 151 */       .equals(other._transactionSequence))) && ((this._journalSequence == null && other._journalSequence == null) || (this._journalSequence != null && this._journalSequence
/*     */ 
/*     */       
/* 154 */       .equals(other._journalSequence))));
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public int hashCode() {
/* 160 */     return ((this._organizationId == null) ? 0 : this._organizationId
/* 161 */       .hashCode()) + ((this._retailLocationId == null) ? 0 : this._retailLocationId
/* 162 */       .hashCode()) + ((this._workstationId == null) ? 0 : this._workstationId
/* 163 */       .hashCode()) + ((this._businessDate == null) ? 0 : this._businessDate
/* 164 */       .hashCode()) + ((this._retailTransactionLineItemSequence == null) ? 0 : this._retailTransactionLineItemSequence
/* 165 */       .hashCode()) + ((this._transactionSequence == null) ? 0 : this._transactionSequence
/* 166 */       .hashCode()) + ((this._journalSequence == null) ? 0 : this._journalSequence
/* 167 */       .hashCode());
/*     */   }
/*     */ 
/*     */   
/*     */   public String getDtxTypeName() {
/* 172 */     return "ReturnedItemJournal";
/*     */   }
/*     */ 
/*     */   
/*     */   public String toString() {
/* 177 */     StringBuilder buff = new StringBuilder(84);
/*     */     
/* 179 */     return buff.append(
/* 180 */         String.valueOf(this._organizationId))
/* 181 */       .append("::").append(String.valueOf(this._retailLocationId))
/* 182 */       .append("::").append(String.valueOf(this._workstationId))
/* 183 */       .append("::").append((this._businessDate == null) ? "null" : String.valueOf(this._businessDate.getTimeSerializable()))
/* 184 */       .append("::").append(String.valueOf(this._retailTransactionLineItemSequence))
/* 185 */       .append("::").append(String.valueOf(this._transactionSequence))
/* 186 */       .append("::").append(String.valueOf(this._journalSequence))
/* 187 */       .toString();
/*     */   }
/*     */   
/*     */   public boolean validate() {
/* 191 */     if (this._retailLocationId == null) {
/* 192 */       return false;
/*     */     }
/* 194 */     if (this._workstationId == null) {
/* 195 */       return false;
/*     */     }
/* 197 */     if (this._businessDate == null) {
/* 198 */       return false;
/*     */     }
/* 200 */     if (this._retailTransactionLineItemSequence == null) {
/* 201 */       return false;
/*     */     }
/* 203 */     if (this._transactionSequence == null) {
/* 204 */       return false;
/*     */     }
/* 206 */     if (this._journalSequence == null) {
/* 207 */       return false;
/*     */     }
/* 209 */     return true;
/*     */   }
/*     */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\trl\ReturnedItemJournalId.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */