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
/*     */ public class RetailTransactionLineItemNotesId
/*     */   extends AbstractObjectId
/*     */ {
/*     */   private static final long serialVersionUID = 1536161759L;
/*     */   private DtvDate _businessDate;
/*     */   private Long _retailLocationId;
/*     */   private Integer _retailTransactionLineItemSequence;
/*     */   private Long _transactionSequence;
/*     */   private Long _workstationId;
/*     */   private Long _noteSeq;
/*     */   
/*     */   public RetailTransactionLineItemNotesId() {}
/*     */   
/*     */   public RetailTransactionLineItemNotesId(String argObjectIdValue) {
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
/*     */   public Date getBusinessDate() {
/*  36 */     return (Date)this._businessDate;
/*     */   }
/*     */   
/*     */   public void setBusinessDate(Date argBusinessDate) {
/*  40 */     this._businessDate = (argBusinessDate == null || argBusinessDate instanceof DtvDate) ? (DtvDate)argBusinessDate : new DtvDate(argBusinessDate);
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
/*     */   public Integer getRetailTransactionLineItemSequence() {
/*  53 */     return this._retailTransactionLineItemSequence;
/*     */   }
/*     */   
/*     */   public void setRetailTransactionLineItemSequence(Integer argRetailTransactionLineItemSequence) {
/*  57 */     this._retailTransactionLineItemSequence = argRetailTransactionLineItemSequence;
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
/*     */   public Long getNoteSeq() {
/*  77 */     return this._noteSeq;
/*     */   }
/*     */   
/*     */   public void setNoteSeq(Long argNoteSeq) {
/*  81 */     this._noteSeq = argNoteSeq;
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
/*  94 */         setBusinessDate((Date)null);
/*     */       } else {
/*     */         
/*  97 */         setBusinessDate((Date)new DtvDate());
/*  98 */         this._businessDate.setTimeFromSerialization(Long.parseLong(str));
/*     */       } 
/* 100 */       str = tokens[1];
/*     */       
/* 102 */       setOrganizationId(Long.valueOf(str));
/* 103 */       str = tokens[2];
/*     */       
/* 105 */       setRetailLocationId(Long.valueOf(str));
/* 106 */       str = tokens[3];
/*     */       
/* 108 */       setRetailTransactionLineItemSequence(Integer.valueOf(str));
/* 109 */       str = tokens[4];
/*     */       
/* 111 */       setTransactionSequence(Long.valueOf(str));
/* 112 */       str = tokens[5];
/*     */       
/* 114 */       setWorkstationId(Long.valueOf(str));
/* 115 */       str = tokens[6];
/*     */       
/* 117 */       setNoteSeq(Long.valueOf(str));
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
/* 129 */     if (!(ob instanceof RetailTransactionLineItemNotesId)) {
/* 130 */       return false;
/*     */     }
/* 132 */     RetailTransactionLineItemNotesId other = (RetailTransactionLineItemNotesId)ob;
/* 133 */     return (((this._businessDate == null && other._businessDate == null) || (this._businessDate != null && this._businessDate
/*     */ 
/*     */       
/* 136 */       .equals(other._businessDate))) && ((this._organizationId == null && other._organizationId == null) || (this._organizationId != null && this._organizationId
/*     */ 
/*     */       
/* 139 */       .equals(other._organizationId))) && ((this._retailLocationId == null && other._retailLocationId == null) || (this._retailLocationId != null && this._retailLocationId
/*     */ 
/*     */       
/* 142 */       .equals(other._retailLocationId))) && ((this._retailTransactionLineItemSequence == null && other._retailTransactionLineItemSequence == null) || (this._retailTransactionLineItemSequence != null && this._retailTransactionLineItemSequence
/*     */ 
/*     */       
/* 145 */       .equals(other._retailTransactionLineItemSequence))) && ((this._transactionSequence == null && other._transactionSequence == null) || (this._transactionSequence != null && this._transactionSequence
/*     */ 
/*     */       
/* 148 */       .equals(other._transactionSequence))) && ((this._workstationId == null && other._workstationId == null) || (this._workstationId != null && this._workstationId
/*     */ 
/*     */       
/* 151 */       .equals(other._workstationId))) && ((this._noteSeq == null && other._noteSeq == null) || (this._noteSeq != null && this._noteSeq
/*     */ 
/*     */       
/* 154 */       .equals(other._noteSeq))));
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public int hashCode() {
/* 160 */     return ((this._businessDate == null) ? 0 : this._businessDate
/* 161 */       .hashCode()) + ((this._organizationId == null) ? 0 : this._organizationId
/* 162 */       .hashCode()) + ((this._retailLocationId == null) ? 0 : this._retailLocationId
/* 163 */       .hashCode()) + ((this._retailTransactionLineItemSequence == null) ? 0 : this._retailTransactionLineItemSequence
/* 164 */       .hashCode()) + ((this._transactionSequence == null) ? 0 : this._transactionSequence
/* 165 */       .hashCode()) + ((this._workstationId == null) ? 0 : this._workstationId
/* 166 */       .hashCode()) + ((this._noteSeq == null) ? 0 : this._noteSeq
/* 167 */       .hashCode());
/*     */   }
/*     */ 
/*     */   
/*     */   public String getDtxTypeName() {
/* 172 */     return "RetailTransactionLineItemNotes";
/*     */   }
/*     */ 
/*     */   
/*     */   public String toString() {
/* 177 */     StringBuilder buff = new StringBuilder(84);
/*     */     
/* 179 */     return buff.append((this._businessDate == null) ? "null" : 
/* 180 */         String.valueOf(this._businessDate.getTimeSerializable()))
/* 181 */       .append("::").append(String.valueOf(this._organizationId))
/* 182 */       .append("::").append(String.valueOf(this._retailLocationId))
/* 183 */       .append("::").append(String.valueOf(this._retailTransactionLineItemSequence))
/* 184 */       .append("::").append(String.valueOf(this._transactionSequence))
/* 185 */       .append("::").append(String.valueOf(this._workstationId))
/* 186 */       .append("::").append(String.valueOf(this._noteSeq))
/* 187 */       .toString();
/*     */   }
/*     */   
/*     */   public boolean validate() {
/* 191 */     if (this._businessDate == null) {
/* 192 */       return false;
/*     */     }
/* 194 */     if (this._retailLocationId == null) {
/* 195 */       return false;
/*     */     }
/* 197 */     if (this._retailTransactionLineItemSequence == null) {
/* 198 */       return false;
/*     */     }
/* 200 */     if (this._transactionSequence == null) {
/* 201 */       return false;
/*     */     }
/* 203 */     if (this._workstationId == null) {
/* 204 */       return false;
/*     */     }
/* 206 */     if (this._noteSeq == null) {
/* 207 */       return false;
/*     */     }
/* 209 */     return true;
/*     */   }
/*     */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\trl\RetailTransactionLineItemNotesId.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */