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
/*     */ 
/*     */ public class CustomerItemAccountModifierId
/*     */   extends AbstractObjectId
/*     */ {
/*     */   private static final long serialVersionUID = 1611431859L;
/*     */   private DtvDate _businessDate;
/*     */   private Long _retailLocationId;
/*     */   private Integer _retailTransactionLineItemSequence;
/*     */   private Long _transactionSequence;
/*     */   private Long _workstationId;
/*     */   
/*     */   public CustomerItemAccountModifierId() {}
/*     */   
/*     */   public CustomerItemAccountModifierId(String argObjectIdValue) {
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
/*     */   public Long getRetailLocationId() {
/*  44 */     return this._retailLocationId;
/*     */   }
/*     */   
/*     */   public void setRetailLocationId(Long argRetailLocationId) {
/*  48 */     this._retailLocationId = argRetailLocationId;
/*     */   }
/*     */   
/*     */   public Integer getRetailTransactionLineItemSequence() {
/*  52 */     return this._retailTransactionLineItemSequence;
/*     */   }
/*     */   
/*     */   public void setRetailTransactionLineItemSequence(Integer argRetailTransactionLineItemSequence) {
/*  56 */     this._retailTransactionLineItemSequence = argRetailTransactionLineItemSequence;
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
/*  93 */       setOrganizationId(Long.valueOf(str));
/*  94 */       str = tokens[2];
/*     */       
/*  96 */       setRetailLocationId(Long.valueOf(str));
/*  97 */       str = tokens[3];
/*     */       
/*  99 */       setRetailTransactionLineItemSequence(Integer.valueOf(str));
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
/* 117 */     if (!(ob instanceof CustomerItemAccountModifierId)) {
/* 118 */       return false;
/*     */     }
/* 120 */     CustomerItemAccountModifierId other = (CustomerItemAccountModifierId)ob;
/* 121 */     return (((this._businessDate == null && other._businessDate == null) || (this._businessDate != null && this._businessDate
/*     */ 
/*     */       
/* 124 */       .equals(other._businessDate))) && ((this._organizationId == null && other._organizationId == null) || (this._organizationId != null && this._organizationId
/*     */ 
/*     */       
/* 127 */       .equals(other._organizationId))) && ((this._retailLocationId == null && other._retailLocationId == null) || (this._retailLocationId != null && this._retailLocationId
/*     */ 
/*     */       
/* 130 */       .equals(other._retailLocationId))) && ((this._retailTransactionLineItemSequence == null && other._retailTransactionLineItemSequence == null) || (this._retailTransactionLineItemSequence != null && this._retailTransactionLineItemSequence
/*     */ 
/*     */       
/* 133 */       .equals(other._retailTransactionLineItemSequence))) && ((this._transactionSequence == null && other._transactionSequence == null) || (this._transactionSequence != null && this._transactionSequence
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
/* 146 */       .hashCode()) + ((this._organizationId == null) ? 0 : this._organizationId
/* 147 */       .hashCode()) + ((this._retailLocationId == null) ? 0 : this._retailLocationId
/* 148 */       .hashCode()) + ((this._retailTransactionLineItemSequence == null) ? 0 : this._retailTransactionLineItemSequence
/* 149 */       .hashCode()) + ((this._transactionSequence == null) ? 0 : this._transactionSequence
/* 150 */       .hashCode()) + ((this._workstationId == null) ? 0 : this._workstationId
/* 151 */       .hashCode());
/*     */   }
/*     */ 
/*     */   
/*     */   public String getDtxTypeName() {
/* 156 */     return "CustomerItemAccountModifier";
/*     */   }
/*     */ 
/*     */   
/*     */   public String toString() {
/* 161 */     StringBuilder buff = new StringBuilder(72);
/*     */     
/* 163 */     return buff.append((this._businessDate == null) ? "null" : 
/* 164 */         String.valueOf(this._businessDate.getTimeSerializable()))
/* 165 */       .append("::").append(String.valueOf(this._organizationId))
/* 166 */       .append("::").append(String.valueOf(this._retailLocationId))
/* 167 */       .append("::").append(String.valueOf(this._retailTransactionLineItemSequence))
/* 168 */       .append("::").append(String.valueOf(this._transactionSequence))
/* 169 */       .append("::").append(String.valueOf(this._workstationId))
/* 170 */       .toString();
/*     */   }
/*     */   
/*     */   public boolean validate() {
/* 174 */     if (this._businessDate == null) {
/* 175 */       return false;
/*     */     }
/* 177 */     if (this._retailLocationId == null) {
/* 178 */       return false;
/*     */     }
/* 180 */     if (this._retailTransactionLineItemSequence == null) {
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


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\trl\CustomerItemAccountModifierId.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */