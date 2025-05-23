/*     */ package dtv.xst.dao.inv;
/*     */ 
/*     */ import dtv.data2.access.AbstractObjectId;
/*     */ import dtv.data2.access.exception.DtxException;
/*     */ import dtv.util.DtvDate;
/*     */ import dtv.util.StringUtils;
/*     */ import java.util.Date;
/*     */ 
/*     */ 
/*     */ 
/*     */ public class InventoryMovementPendingDetailId
/*     */   extends AbstractObjectId
/*     */ {
/*     */   private static final long serialVersionUID = 827340925L;
/*     */   private Long _retailLocationId;
/*     */   private DtvDate _businessDate;
/*     */   private Long _workstationId;
/*     */   private Long _transactionSequence;
/*     */   private Long _lineItemSequence;
/*     */   private Long _pendingSequence;
/*     */   
/*     */   public InventoryMovementPendingDetailId() {}
/*     */   
/*     */   public InventoryMovementPendingDetailId(String argObjectIdValue) {
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
/*     */   public Date getBusinessDate() {
/*  44 */     return (Date)this._businessDate;
/*     */   }
/*     */   
/*     */   public void setBusinessDate(Date argBusinessDate) {
/*  48 */     this._businessDate = (argBusinessDate == null || argBusinessDate instanceof DtvDate) ? (DtvDate)argBusinessDate : new DtvDate(argBusinessDate);
/*     */   }
/*     */ 
/*     */   
/*     */   public Long getWorkstationId() {
/*  53 */     return this._workstationId;
/*     */   }
/*     */   
/*     */   public void setWorkstationId(Long argWorkstationId) {
/*  57 */     this._workstationId = argWorkstationId;
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
/*     */   public Long getLineItemSequence() {
/*  69 */     return this._lineItemSequence;
/*     */   }
/*     */   
/*     */   public void setLineItemSequence(Long argLineItemSequence) {
/*  73 */     this._lineItemSequence = argLineItemSequence;
/*     */   }
/*     */   
/*     */   public Long getPendingSequence() {
/*  77 */     return this._pendingSequence;
/*     */   }
/*     */   
/*     */   public void setPendingSequence(Long argPendingSequence) {
/*  81 */     this._pendingSequence = argPendingSequence;
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
/*  99 */       if ("null".equals(str)) {
/* 100 */         setBusinessDate((Date)null);
/*     */       } else {
/*     */         
/* 103 */         setBusinessDate((Date)new DtvDate());
/* 104 */         this._businessDate.setTimeFromSerialization(Long.parseLong(str));
/*     */       } 
/* 106 */       str = tokens[3];
/*     */       
/* 108 */       setWorkstationId(Long.valueOf(str));
/* 109 */       str = tokens[4];
/*     */       
/* 111 */       setTransactionSequence(Long.valueOf(str));
/* 112 */       str = tokens[5];
/*     */       
/* 114 */       setLineItemSequence(Long.valueOf(str));
/* 115 */       str = tokens[6];
/*     */       
/* 117 */       setPendingSequence(Long.valueOf(str));
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
/* 129 */     if (!(ob instanceof InventoryMovementPendingDetailId)) {
/* 130 */       return false;
/*     */     }
/* 132 */     InventoryMovementPendingDetailId other = (InventoryMovementPendingDetailId)ob;
/* 133 */     return (((this._organizationId == null && other._organizationId == null) || (this._organizationId != null && this._organizationId
/*     */ 
/*     */       
/* 136 */       .equals(other._organizationId))) && ((this._retailLocationId == null && other._retailLocationId == null) || (this._retailLocationId != null && this._retailLocationId
/*     */ 
/*     */       
/* 139 */       .equals(other._retailLocationId))) && ((this._businessDate == null && other._businessDate == null) || (this._businessDate != null && this._businessDate
/*     */ 
/*     */       
/* 142 */       .equals(other._businessDate))) && ((this._workstationId == null && other._workstationId == null) || (this._workstationId != null && this._workstationId
/*     */ 
/*     */       
/* 145 */       .equals(other._workstationId))) && ((this._transactionSequence == null && other._transactionSequence == null) || (this._transactionSequence != null && this._transactionSequence
/*     */ 
/*     */       
/* 148 */       .equals(other._transactionSequence))) && ((this._lineItemSequence == null && other._lineItemSequence == null) || (this._lineItemSequence != null && this._lineItemSequence
/*     */ 
/*     */       
/* 151 */       .equals(other._lineItemSequence))) && ((this._pendingSequence == null && other._pendingSequence == null) || (this._pendingSequence != null && this._pendingSequence
/*     */ 
/*     */       
/* 154 */       .equals(other._pendingSequence))));
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public int hashCode() {
/* 160 */     return ((this._organizationId == null) ? 0 : this._organizationId
/* 161 */       .hashCode()) + ((this._retailLocationId == null) ? 0 : this._retailLocationId
/* 162 */       .hashCode()) + ((this._businessDate == null) ? 0 : this._businessDate
/* 163 */       .hashCode()) + ((this._workstationId == null) ? 0 : this._workstationId
/* 164 */       .hashCode()) + ((this._transactionSequence == null) ? 0 : this._transactionSequence
/* 165 */       .hashCode()) + ((this._lineItemSequence == null) ? 0 : this._lineItemSequence
/* 166 */       .hashCode()) + ((this._pendingSequence == null) ? 0 : this._pendingSequence
/* 167 */       .hashCode());
/*     */   }
/*     */ 
/*     */   
/*     */   public String getDtxTypeName() {
/* 172 */     return "InventoryMovementPendingDetail";
/*     */   }
/*     */ 
/*     */   
/*     */   public String toString() {
/* 177 */     StringBuilder buff = new StringBuilder(84);
/*     */     
/* 179 */     return buff.append(
/* 180 */         String.valueOf(this._organizationId))
/* 181 */       .append("::").append(String.valueOf(this._retailLocationId))
/* 182 */       .append("::").append((this._businessDate == null) ? "null" : String.valueOf(this._businessDate.getTimeSerializable()))
/* 183 */       .append("::").append(String.valueOf(this._workstationId))
/* 184 */       .append("::").append(String.valueOf(this._transactionSequence))
/* 185 */       .append("::").append(String.valueOf(this._lineItemSequence))
/* 186 */       .append("::").append(String.valueOf(this._pendingSequence))
/* 187 */       .toString();
/*     */   }
/*     */   
/*     */   public boolean validate() {
/* 191 */     if (this._retailLocationId == null) {
/* 192 */       return false;
/*     */     }
/* 194 */     if (this._businessDate == null) {
/* 195 */       return false;
/*     */     }
/* 197 */     if (this._workstationId == null) {
/* 198 */       return false;
/*     */     }
/* 200 */     if (this._transactionSequence == null) {
/* 201 */       return false;
/*     */     }
/* 203 */     if (this._lineItemSequence == null) {
/* 204 */       return false;
/*     */     }
/* 206 */     if (this._pendingSequence == null) {
/* 207 */       return false;
/*     */     }
/* 209 */     return true;
/*     */   }
/*     */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\inv\InventoryMovementPendingDetailId.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */