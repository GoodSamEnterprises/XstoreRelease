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
/*     */ public class TransactionNotesId
/*     */   extends AbstractObjectId
/*     */ {
/*     */   private static final long serialVersionUID = -349574493L;
/*     */   private DtvDate _businessDate;
/*     */   private Integer _noteSequence;
/*     */   private Long _retailLocationId;
/*     */   private Long _transactionSequence;
/*     */   private Long _workstationId;
/*     */   
/*     */   public TransactionNotesId() {}
/*     */   
/*     */   public TransactionNotesId(String argObjectIdValue) {
/*  25 */     setValue(argObjectIdValue);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Date getBusinessDate() {
/*  35 */     return (Date)this._businessDate;
/*     */   }
/*     */   
/*     */   public void setBusinessDate(Date argBusinessDate) {
/*  39 */     this._businessDate = (argBusinessDate == null || argBusinessDate instanceof DtvDate) ? (DtvDate)argBusinessDate : new DtvDate(argBusinessDate);
/*     */   }
/*     */ 
/*     */   
/*     */   public Integer getNoteSequence() {
/*  44 */     return this._noteSequence;
/*     */   }
/*     */   
/*     */   public void setNoteSequence(Integer argNoteSequence) {
/*  48 */     this._noteSequence = argNoteSequence;
/*     */   }
/*     */   
/*     */   public Long getRetailLocationId() {
/*  52 */     return this._retailLocationId;
/*     */   }
/*     */   
/*     */   public void setRetailLocationId(Long argRetailLocationId) {
/*  56 */     this._retailLocationId = argRetailLocationId;
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
/*  85 */         setBusinessDate((Date)null);
/*     */       } else {
/*     */         
/*  88 */         setBusinessDate((Date)new DtvDate());
/*  89 */         this._businessDate.setTimeFromSerialization(Long.parseLong(str));
/*     */       } 
/*  91 */       str = tokens[1];
/*     */       
/*  93 */       setNoteSequence(Integer.valueOf(str));
/*  94 */       str = tokens[2];
/*     */       
/*  96 */       setOrganizationId(Long.valueOf(str));
/*  97 */       str = tokens[3];
/*     */       
/*  99 */       setRetailLocationId(Long.valueOf(str));
/* 100 */       str = tokens[4];
/*     */       
/* 102 */       setTransactionSequence(Long.valueOf(str));
/* 103 */       str = tokens[5];
/*     */       
/* 105 */       setWorkstationId(Long.valueOf(str));
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
/* 117 */     if (!(ob instanceof TransactionNotesId)) {
/* 118 */       return false;
/*     */     }
/* 120 */     TransactionNotesId other = (TransactionNotesId)ob;
/* 121 */     return (((this._businessDate == null && other._businessDate == null) || (this._businessDate != null && this._businessDate
/*     */ 
/*     */       
/* 124 */       .equals(other._businessDate))) && ((this._noteSequence == null && other._noteSequence == null) || (this._noteSequence != null && this._noteSequence
/*     */ 
/*     */       
/* 127 */       .equals(other._noteSequence))) && ((this._organizationId == null && other._organizationId == null) || (this._organizationId != null && this._organizationId
/*     */ 
/*     */       
/* 130 */       .equals(other._organizationId))) && ((this._retailLocationId == null && other._retailLocationId == null) || (this._retailLocationId != null && this._retailLocationId
/*     */ 
/*     */       
/* 133 */       .equals(other._retailLocationId))) && ((this._transactionSequence == null && other._transactionSequence == null) || (this._transactionSequence != null && this._transactionSequence
/*     */ 
/*     */       
/* 136 */       .equals(other._transactionSequence))) && ((this._workstationId == null && other._workstationId == null) || (this._workstationId != null && this._workstationId
/*     */ 
/*     */       
/* 139 */       .equals(other._workstationId))));
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public int hashCode() {
/* 145 */     return ((this._businessDate == null) ? 0 : this._businessDate
/* 146 */       .hashCode()) + ((this._noteSequence == null) ? 0 : this._noteSequence
/* 147 */       .hashCode()) + ((this._organizationId == null) ? 0 : this._organizationId
/* 148 */       .hashCode()) + ((this._retailLocationId == null) ? 0 : this._retailLocationId
/* 149 */       .hashCode()) + ((this._transactionSequence == null) ? 0 : this._transactionSequence
/* 150 */       .hashCode()) + ((this._workstationId == null) ? 0 : this._workstationId
/* 151 */       .hashCode());
/*     */   }
/*     */ 
/*     */   
/*     */   public String getDtxTypeName() {
/* 156 */     return "TransactionNotes";
/*     */   }
/*     */ 
/*     */   
/*     */   public String toString() {
/* 161 */     StringBuilder buff = new StringBuilder(72);
/*     */     
/* 163 */     return buff.append((this._businessDate == null) ? "null" : 
/* 164 */         String.valueOf(this._businessDate.getTimeSerializable()))
/* 165 */       .append("::").append(String.valueOf(this._noteSequence))
/* 166 */       .append("::").append(String.valueOf(this._organizationId))
/* 167 */       .append("::").append(String.valueOf(this._retailLocationId))
/* 168 */       .append("::").append(String.valueOf(this._transactionSequence))
/* 169 */       .append("::").append(String.valueOf(this._workstationId))
/* 170 */       .toString();
/*     */   }
/*     */   
/*     */   public boolean validate() {
/* 174 */     if (this._businessDate == null) {
/* 175 */       return false;
/*     */     }
/* 177 */     if (this._noteSequence == null) {
/* 178 */       return false;
/*     */     }
/* 180 */     if (this._retailLocationId == null) {
/* 181 */       return false;
/*     */     }
/* 183 */     if (this._transactionSequence == null) {
/* 184 */       return false;
/*     */     }
/* 186 */     if (this._workstationId == null) {
/* 187 */       return false;
/*     */     }
/* 189 */     return true;
/*     */   }
/*     */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\trn\TransactionNotesId.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */