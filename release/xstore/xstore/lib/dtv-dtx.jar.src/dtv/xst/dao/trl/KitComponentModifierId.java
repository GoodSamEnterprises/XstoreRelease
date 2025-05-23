/*     */ package dtv.xst.dao.trl;
/*     */ 
/*     */ import dtv.data2.access.AbstractObjectId;
/*     */ import dtv.data2.access.exception.DtxException;
/*     */ import dtv.util.DtvDate;
/*     */ import dtv.util.StringUtils;
/*     */ import java.util.Date;
/*     */ 
/*     */ 
/*     */ public class KitComponentModifierId
/*     */   extends AbstractObjectId
/*     */ {
/*     */   private static final long serialVersionUID = -995503394L;
/*     */   private Long _retailLocationId;
/*     */   private DtvDate _businessDate;
/*     */   private Long _workstationId;
/*     */   private Long _transactionSequence;
/*     */   private Integer _retailTransactionLineItemSequence;
/*     */   private String _componentItemId;
/*     */   private Long _sequenceNumber;
/*     */   
/*     */   public KitComponentModifierId() {}
/*     */   
/*     */   public KitComponentModifierId(String argObjectIdValue) {
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
/*     */   
/*     */   public Long getRetailLocationId() {
/*  37 */     return this._retailLocationId;
/*     */   }
/*     */   
/*     */   public void setRetailLocationId(Long argRetailLocationId) {
/*  41 */     this._retailLocationId = argRetailLocationId;
/*     */   }
/*     */   
/*     */   public Date getBusinessDate() {
/*  45 */     return (Date)this._businessDate;
/*     */   }
/*     */   
/*     */   public void setBusinessDate(Date argBusinessDate) {
/*  49 */     this._businessDate = (argBusinessDate == null || argBusinessDate instanceof DtvDate) ? (DtvDate)argBusinessDate : new DtvDate(argBusinessDate);
/*     */   }
/*     */ 
/*     */   
/*     */   public Long getWorkstationId() {
/*  54 */     return this._workstationId;
/*     */   }
/*     */   
/*     */   public void setWorkstationId(Long argWorkstationId) {
/*  58 */     this._workstationId = argWorkstationId;
/*     */   }
/*     */   
/*     */   public Long getTransactionSequence() {
/*  62 */     return this._transactionSequence;
/*     */   }
/*     */   
/*     */   public void setTransactionSequence(Long argTransactionSequence) {
/*  66 */     this._transactionSequence = argTransactionSequence;
/*     */   }
/*     */   
/*     */   public Integer getRetailTransactionLineItemSequence() {
/*  70 */     return this._retailTransactionLineItemSequence;
/*     */   }
/*     */   
/*     */   public void setRetailTransactionLineItemSequence(Integer argRetailTransactionLineItemSequence) {
/*  74 */     this._retailTransactionLineItemSequence = argRetailTransactionLineItemSequence;
/*     */   }
/*     */   
/*     */   public String getComponentItemId() {
/*  78 */     return this._componentItemId;
/*     */   }
/*     */   
/*     */   public void setComponentItemId(String argComponentItemId) {
/*  82 */     this._componentItemId = (argComponentItemId != null && MANAGE_CASE) ? argComponentItemId.toUpperCase() : argComponentItemId;
/*     */   }
/*     */   
/*     */   public Long getSequenceNumber() {
/*  86 */     return this._sequenceNumber;
/*     */   }
/*     */   
/*     */   public void setSequenceNumber(Long argSequenceNumber) {
/*  90 */     this._sequenceNumber = argSequenceNumber;
/*     */   }
/*     */   
/*     */   public void setValue(String argObjectIdValue) {
/*  94 */     String str = argObjectIdValue;
/*  95 */     if (StringUtils.isEmpty(str)) {
/*  96 */       throw new DtxException("argument passed to setValue() is null or empty - a valid value must be passed");
/*     */     }
/*     */     try {
/*  99 */       String[] tokens = str.split("::");
/* 100 */       str = tokens[0];
/*     */       
/* 102 */       setOrganizationId(Long.valueOf(str));
/* 103 */       str = tokens[1];
/*     */       
/* 105 */       setRetailLocationId(Long.valueOf(str));
/* 106 */       str = tokens[2];
/*     */       
/* 108 */       if ("null".equals(str)) {
/* 109 */         setBusinessDate((Date)null);
/*     */       } else {
/*     */         
/* 112 */         setBusinessDate((Date)new DtvDate());
/* 113 */         this._businessDate.setTimeFromSerialization(Long.parseLong(str));
/*     */       } 
/* 115 */       str = tokens[3];
/*     */       
/* 117 */       setWorkstationId(Long.valueOf(str));
/* 118 */       str = tokens[4];
/*     */       
/* 120 */       setTransactionSequence(Long.valueOf(str));
/* 121 */       str = tokens[5];
/*     */       
/* 123 */       setRetailTransactionLineItemSequence(Integer.valueOf(str));
/* 124 */       str = tokens[6];
/*     */       
/* 126 */       if ("null".equals(str)) {
/* 127 */         setComponentItemId((String)null);
/*     */       } else {
/*     */         
/* 130 */         setComponentItemId(str);
/*     */       } 
/* 132 */       str = tokens[7];
/*     */       
/* 134 */       setSequenceNumber(Long.valueOf(str));
/*     */     }
/* 136 */     catch (Exception ee) {
/* 137 */       throw new DtxException("An exception occured while parsing object id string: " + argObjectIdValue, ee);
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean equals(Object ob) {
/* 143 */     if (this == ob) {
/* 144 */       return true;
/*     */     }
/* 146 */     if (!(ob instanceof KitComponentModifierId)) {
/* 147 */       return false;
/*     */     }
/* 149 */     KitComponentModifierId other = (KitComponentModifierId)ob;
/* 150 */     return (((this._organizationId == null && other._organizationId == null) || (this._organizationId != null && this._organizationId
/*     */ 
/*     */       
/* 153 */       .equals(other._organizationId))) && ((this._retailLocationId == null && other._retailLocationId == null) || (this._retailLocationId != null && this._retailLocationId
/*     */ 
/*     */       
/* 156 */       .equals(other._retailLocationId))) && ((this._businessDate == null && other._businessDate == null) || (this._businessDate != null && this._businessDate
/*     */ 
/*     */       
/* 159 */       .equals(other._businessDate))) && ((this._workstationId == null && other._workstationId == null) || (this._workstationId != null && this._workstationId
/*     */ 
/*     */       
/* 162 */       .equals(other._workstationId))) && ((this._transactionSequence == null && other._transactionSequence == null) || (this._transactionSequence != null && this._transactionSequence
/*     */ 
/*     */       
/* 165 */       .equals(other._transactionSequence))) && ((this._retailTransactionLineItemSequence == null && other._retailTransactionLineItemSequence == null) || (this._retailTransactionLineItemSequence != null && this._retailTransactionLineItemSequence
/*     */ 
/*     */       
/* 168 */       .equals(other._retailTransactionLineItemSequence))) && ((this._componentItemId == null && other._componentItemId == null) || (this._componentItemId != null && this._componentItemId
/*     */ 
/*     */       
/* 171 */       .equals(other._componentItemId))) && ((this._sequenceNumber == null && other._sequenceNumber == null) || (this._sequenceNumber != null && this._sequenceNumber
/*     */ 
/*     */       
/* 174 */       .equals(other._sequenceNumber))));
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public int hashCode() {
/* 180 */     return ((this._organizationId == null) ? 0 : this._organizationId
/* 181 */       .hashCode()) + ((this._retailLocationId == null) ? 0 : this._retailLocationId
/* 182 */       .hashCode()) + ((this._businessDate == null) ? 0 : this._businessDate
/* 183 */       .hashCode()) + ((this._workstationId == null) ? 0 : this._workstationId
/* 184 */       .hashCode()) + ((this._transactionSequence == null) ? 0 : this._transactionSequence
/* 185 */       .hashCode()) + ((this._retailTransactionLineItemSequence == null) ? 0 : this._retailTransactionLineItemSequence
/* 186 */       .hashCode()) + ((this._componentItemId == null) ? 0 : this._componentItemId
/* 187 */       .hashCode()) + ((this._sequenceNumber == null) ? 0 : this._sequenceNumber
/* 188 */       .hashCode());
/*     */   }
/*     */ 
/*     */   
/*     */   public String getDtxTypeName() {
/* 193 */     return "KitComponentModifier";
/*     */   }
/*     */ 
/*     */   
/*     */   public String toString() {
/* 198 */     StringBuilder buff = new StringBuilder(96);
/*     */     
/* 200 */     return buff.append(
/* 201 */         String.valueOf(this._organizationId))
/* 202 */       .append("::").append(String.valueOf(this._retailLocationId))
/* 203 */       .append("::").append((this._businessDate == null) ? "null" : String.valueOf(this._businessDate.getTimeSerializable()))
/* 204 */       .append("::").append(String.valueOf(this._workstationId))
/* 205 */       .append("::").append(String.valueOf(this._transactionSequence))
/* 206 */       .append("::").append(String.valueOf(this._retailTransactionLineItemSequence))
/* 207 */       .append("::").append(this._componentItemId)
/* 208 */       .append("::").append(String.valueOf(this._sequenceNumber))
/* 209 */       .toString();
/*     */   }
/*     */   
/*     */   public boolean validate() {
/* 213 */     if (this._retailLocationId == null) {
/* 214 */       return false;
/*     */     }
/* 216 */     if (this._businessDate == null) {
/* 217 */       return false;
/*     */     }
/* 219 */     if (this._workstationId == null) {
/* 220 */       return false;
/*     */     }
/* 222 */     if (this._transactionSequence == null) {
/* 223 */       return false;
/*     */     }
/* 225 */     if (this._retailTransactionLineItemSequence == null) {
/* 226 */       return false;
/*     */     }
/* 228 */     if (this._componentItemId == null) {
/* 229 */       return false;
/*     */     }
/* 231 */     if (this._sequenceNumber == null) {
/* 232 */       return false;
/*     */     }
/* 234 */     return true;
/*     */   }
/*     */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\trl\KitComponentModifierId.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */