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
/*     */ public class RetailPriceModifierId
/*     */   extends AbstractObjectId
/*     */ {
/*     */   private static final long serialVersionUID = 1985659613L;
/*     */   private DtvDate _businessDate;
/*     */   private Long _retailLocationId;
/*     */   private Integer _retailPriceModifierSequenceNbr;
/*     */   private Integer _retailTransactionLineItemSequence;
/*     */   private Long _transactionSequence;
/*     */   private Long _workstationId;
/*     */   
/*     */   public RetailPriceModifierId() {}
/*     */   
/*     */   public RetailPriceModifierId(String argObjectIdValue) {
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
/*     */   public Integer getRetailPriceModifierSequenceNbr() {
/*  53 */     return this._retailPriceModifierSequenceNbr;
/*     */   }
/*     */   
/*     */   public void setRetailPriceModifierSequenceNbr(Integer argRetailPriceModifierSequenceNbr) {
/*  57 */     this._retailPriceModifierSequenceNbr = argRetailPriceModifierSequenceNbr;
/*     */   }
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
/*     */   public Long getWorkstationId() {
/*  77 */     return this._workstationId;
/*     */   }
/*     */   
/*     */   public void setWorkstationId(Long argWorkstationId) {
/*  81 */     this._workstationId = argWorkstationId;
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
/* 108 */       setRetailPriceModifierSequenceNbr(Integer.valueOf(str));
/* 109 */       str = tokens[4];
/*     */       
/* 111 */       setRetailTransactionLineItemSequence(Integer.valueOf(str));
/* 112 */       str = tokens[5];
/*     */       
/* 114 */       setTransactionSequence(Long.valueOf(str));
/* 115 */       str = tokens[6];
/*     */       
/* 117 */       setWorkstationId(Long.valueOf(str));
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
/* 129 */     if (!(ob instanceof RetailPriceModifierId)) {
/* 130 */       return false;
/*     */     }
/* 132 */     RetailPriceModifierId other = (RetailPriceModifierId)ob;
/* 133 */     return (((this._businessDate == null && other._businessDate == null) || (this._businessDate != null && this._businessDate
/*     */ 
/*     */       
/* 136 */       .equals(other._businessDate))) && ((this._organizationId == null && other._organizationId == null) || (this._organizationId != null && this._organizationId
/*     */ 
/*     */       
/* 139 */       .equals(other._organizationId))) && ((this._retailLocationId == null && other._retailLocationId == null) || (this._retailLocationId != null && this._retailLocationId
/*     */ 
/*     */       
/* 142 */       .equals(other._retailLocationId))) && ((this._retailPriceModifierSequenceNbr == null && other._retailPriceModifierSequenceNbr == null) || (this._retailPriceModifierSequenceNbr != null && this._retailPriceModifierSequenceNbr
/*     */ 
/*     */       
/* 145 */       .equals(other._retailPriceModifierSequenceNbr))) && ((this._retailTransactionLineItemSequence == null && other._retailTransactionLineItemSequence == null) || (this._retailTransactionLineItemSequence != null && this._retailTransactionLineItemSequence
/*     */ 
/*     */       
/* 148 */       .equals(other._retailTransactionLineItemSequence))) && ((this._transactionSequence == null && other._transactionSequence == null) || (this._transactionSequence != null && this._transactionSequence
/*     */ 
/*     */       
/* 151 */       .equals(other._transactionSequence))) && ((this._workstationId == null && other._workstationId == null) || (this._workstationId != null && this._workstationId
/*     */ 
/*     */       
/* 154 */       .equals(other._workstationId))));
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public int hashCode() {
/* 160 */     return ((this._businessDate == null) ? 0 : this._businessDate
/* 161 */       .hashCode()) + ((this._organizationId == null) ? 0 : this._organizationId
/* 162 */       .hashCode()) + ((this._retailLocationId == null) ? 0 : this._retailLocationId
/* 163 */       .hashCode()) + ((this._retailPriceModifierSequenceNbr == null) ? 0 : this._retailPriceModifierSequenceNbr
/* 164 */       .hashCode()) + ((this._retailTransactionLineItemSequence == null) ? 0 : this._retailTransactionLineItemSequence
/* 165 */       .hashCode()) + ((this._transactionSequence == null) ? 0 : this._transactionSequence
/* 166 */       .hashCode()) + ((this._workstationId == null) ? 0 : this._workstationId
/* 167 */       .hashCode());
/*     */   }
/*     */ 
/*     */   
/*     */   public String getDtxTypeName() {
/* 172 */     return "RetailPriceModifier";
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
/* 183 */       .append("::").append(String.valueOf(this._retailPriceModifierSequenceNbr))
/* 184 */       .append("::").append(String.valueOf(this._retailTransactionLineItemSequence))
/* 185 */       .append("::").append(String.valueOf(this._transactionSequence))
/* 186 */       .append("::").append(String.valueOf(this._workstationId))
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
/* 197 */     if (this._retailPriceModifierSequenceNbr == null) {
/* 198 */       return false;
/*     */     }
/* 200 */     if (this._retailTransactionLineItemSequence == null) {
/* 201 */       return false;
/*     */     }
/* 203 */     if (this._transactionSequence == null) {
/* 204 */       return false;
/*     */     }
/* 206 */     if (this._workstationId == null) {
/* 207 */       return false;
/*     */     }
/* 209 */     return true;
/*     */   }
/*     */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\trl\RetailPriceModifierId.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */