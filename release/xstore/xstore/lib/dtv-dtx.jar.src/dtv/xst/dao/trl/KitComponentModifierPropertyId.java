/*     */ package dtv.xst.dao.trl;
/*     */ 
/*     */ import dtv.data2.access.AbstractObjectId;
/*     */ import dtv.data2.access.exception.DtxException;
/*     */ import dtv.util.DtvDate;
/*     */ import dtv.util.StringUtils;
/*     */ import java.util.Date;
/*     */ 
/*     */ public class KitComponentModifierPropertyId
/*     */   extends AbstractObjectId
/*     */ {
/*     */   private static final long serialVersionUID = -1967630637L;
/*     */   private Long _retailLocationId;
/*     */   private DtvDate _businessDate;
/*     */   private Long _workstationId;
/*     */   private Long _transactionSequence;
/*     */   private Integer _retailTransactionLineItemSequence;
/*     */   private String _componentItemId;
/*     */   private Long _sequenceNumber;
/*     */   private String _propertyCode;
/*     */   
/*     */   public KitComponentModifierPropertyId() {}
/*     */   
/*     */   public KitComponentModifierPropertyId(String argObjectIdValue) {
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
/*     */   
/*     */   public Long getRetailLocationId() {
/*  38 */     return this._retailLocationId;
/*     */   }
/*     */   
/*     */   public void setRetailLocationId(Long argRetailLocationId) {
/*  42 */     this._retailLocationId = argRetailLocationId;
/*     */   }
/*     */   
/*     */   public Date getBusinessDate() {
/*  46 */     return (Date)this._businessDate;
/*     */   }
/*     */   
/*     */   public void setBusinessDate(Date argBusinessDate) {
/*  50 */     this._businessDate = (argBusinessDate == null || argBusinessDate instanceof DtvDate) ? (DtvDate)argBusinessDate : new DtvDate(argBusinessDate);
/*     */   }
/*     */ 
/*     */   
/*     */   public Long getWorkstationId() {
/*  55 */     return this._workstationId;
/*     */   }
/*     */   
/*     */   public void setWorkstationId(Long argWorkstationId) {
/*  59 */     this._workstationId = argWorkstationId;
/*     */   }
/*     */   
/*     */   public Long getTransactionSequence() {
/*  63 */     return this._transactionSequence;
/*     */   }
/*     */   
/*     */   public void setTransactionSequence(Long argTransactionSequence) {
/*  67 */     this._transactionSequence = argTransactionSequence;
/*     */   }
/*     */   
/*     */   public Integer getRetailTransactionLineItemSequence() {
/*  71 */     return this._retailTransactionLineItemSequence;
/*     */   }
/*     */   
/*     */   public void setRetailTransactionLineItemSequence(Integer argRetailTransactionLineItemSequence) {
/*  75 */     this._retailTransactionLineItemSequence = argRetailTransactionLineItemSequence;
/*     */   }
/*     */   
/*     */   public String getComponentItemId() {
/*  79 */     return this._componentItemId;
/*     */   }
/*     */   
/*     */   public void setComponentItemId(String argComponentItemId) {
/*  83 */     this._componentItemId = (argComponentItemId != null && MANAGE_CASE) ? argComponentItemId.toUpperCase() : argComponentItemId;
/*     */   }
/*     */   
/*     */   public Long getSequenceNumber() {
/*  87 */     return this._sequenceNumber;
/*     */   }
/*     */   
/*     */   public void setSequenceNumber(Long argSequenceNumber) {
/*  91 */     this._sequenceNumber = argSequenceNumber;
/*     */   }
/*     */   
/*     */   public String getPropertyCode() {
/*  95 */     return this._propertyCode;
/*     */   }
/*     */   
/*     */   public void setPropertyCode(String argPropertyCode) {
/*  99 */     this._propertyCode = (argPropertyCode != null && MANAGE_CASE) ? argPropertyCode.toUpperCase() : argPropertyCode;
/*     */   }
/*     */   
/*     */   public void setValue(String argObjectIdValue) {
/* 103 */     String str = argObjectIdValue;
/* 104 */     if (StringUtils.isEmpty(str)) {
/* 105 */       throw new DtxException("argument passed to setValue() is null or empty - a valid value must be passed");
/*     */     }
/*     */     try {
/* 108 */       String[] tokens = str.split("::");
/* 109 */       str = tokens[0];
/*     */       
/* 111 */       setOrganizationId(Long.valueOf(str));
/* 112 */       str = tokens[1];
/*     */       
/* 114 */       setRetailLocationId(Long.valueOf(str));
/* 115 */       str = tokens[2];
/*     */       
/* 117 */       if ("null".equals(str)) {
/* 118 */         setBusinessDate((Date)null);
/*     */       } else {
/*     */         
/* 121 */         setBusinessDate((Date)new DtvDate());
/* 122 */         this._businessDate.setTimeFromSerialization(Long.parseLong(str));
/*     */       } 
/* 124 */       str = tokens[3];
/*     */       
/* 126 */       setWorkstationId(Long.valueOf(str));
/* 127 */       str = tokens[4];
/*     */       
/* 129 */       setTransactionSequence(Long.valueOf(str));
/* 130 */       str = tokens[5];
/*     */       
/* 132 */       setRetailTransactionLineItemSequence(Integer.valueOf(str));
/* 133 */       str = tokens[6];
/*     */       
/* 135 */       if ("null".equals(str)) {
/* 136 */         setComponentItemId((String)null);
/*     */       } else {
/*     */         
/* 139 */         setComponentItemId(str);
/*     */       } 
/* 141 */       str = tokens[7];
/*     */       
/* 143 */       setSequenceNumber(Long.valueOf(str));
/* 144 */       str = tokens[8];
/*     */       
/* 146 */       if ("null".equals(str)) {
/* 147 */         setPropertyCode((String)null);
/*     */       } else {
/*     */         
/* 150 */         setPropertyCode(str);
/*     */       }
/*     */     
/* 153 */     } catch (Exception ee) {
/* 154 */       throw new DtxException("An exception occured while parsing object id string: " + argObjectIdValue, ee);
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean equals(Object ob) {
/* 160 */     if (this == ob) {
/* 161 */       return true;
/*     */     }
/* 163 */     if (!(ob instanceof KitComponentModifierPropertyId)) {
/* 164 */       return false;
/*     */     }
/* 166 */     KitComponentModifierPropertyId other = (KitComponentModifierPropertyId)ob;
/* 167 */     return (((this._organizationId == null && other._organizationId == null) || (this._organizationId != null && this._organizationId
/*     */ 
/*     */       
/* 170 */       .equals(other._organizationId))) && ((this._retailLocationId == null && other._retailLocationId == null) || (this._retailLocationId != null && this._retailLocationId
/*     */ 
/*     */       
/* 173 */       .equals(other._retailLocationId))) && ((this._businessDate == null && other._businessDate == null) || (this._businessDate != null && this._businessDate
/*     */ 
/*     */       
/* 176 */       .equals(other._businessDate))) && ((this._workstationId == null && other._workstationId == null) || (this._workstationId != null && this._workstationId
/*     */ 
/*     */       
/* 179 */       .equals(other._workstationId))) && ((this._transactionSequence == null && other._transactionSequence == null) || (this._transactionSequence != null && this._transactionSequence
/*     */ 
/*     */       
/* 182 */       .equals(other._transactionSequence))) && ((this._retailTransactionLineItemSequence == null && other._retailTransactionLineItemSequence == null) || (this._retailTransactionLineItemSequence != null && this._retailTransactionLineItemSequence
/*     */ 
/*     */       
/* 185 */       .equals(other._retailTransactionLineItemSequence))) && ((this._componentItemId == null && other._componentItemId == null) || (this._componentItemId != null && this._componentItemId
/*     */ 
/*     */       
/* 188 */       .equals(other._componentItemId))) && ((this._sequenceNumber == null && other._sequenceNumber == null) || (this._sequenceNumber != null && this._sequenceNumber
/*     */ 
/*     */       
/* 191 */       .equals(other._sequenceNumber))) && ((this._propertyCode == null && other._propertyCode == null) || (this._propertyCode != null && this._propertyCode
/*     */ 
/*     */       
/* 194 */       .equals(other._propertyCode))));
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public int hashCode() {
/* 200 */     return ((this._organizationId == null) ? 0 : this._organizationId
/* 201 */       .hashCode()) + ((this._retailLocationId == null) ? 0 : this._retailLocationId
/* 202 */       .hashCode()) + ((this._businessDate == null) ? 0 : this._businessDate
/* 203 */       .hashCode()) + ((this._workstationId == null) ? 0 : this._workstationId
/* 204 */       .hashCode()) + ((this._transactionSequence == null) ? 0 : this._transactionSequence
/* 205 */       .hashCode()) + ((this._retailTransactionLineItemSequence == null) ? 0 : this._retailTransactionLineItemSequence
/* 206 */       .hashCode()) + ((this._componentItemId == null) ? 0 : this._componentItemId
/* 207 */       .hashCode()) + ((this._sequenceNumber == null) ? 0 : this._sequenceNumber
/* 208 */       .hashCode()) + ((this._propertyCode == null) ? 0 : this._propertyCode
/* 209 */       .hashCode());
/*     */   }
/*     */ 
/*     */   
/*     */   public String getDtxTypeName() {
/* 214 */     return "KitComponentModifierProperty";
/*     */   }
/*     */ 
/*     */   
/*     */   public String toString() {
/* 219 */     StringBuilder buff = new StringBuilder(108);
/*     */     
/* 221 */     return buff.append(
/* 222 */         String.valueOf(this._organizationId))
/* 223 */       .append("::").append(String.valueOf(this._retailLocationId))
/* 224 */       .append("::").append((this._businessDate == null) ? "null" : String.valueOf(this._businessDate.getTimeSerializable()))
/* 225 */       .append("::").append(String.valueOf(this._workstationId))
/* 226 */       .append("::").append(String.valueOf(this._transactionSequence))
/* 227 */       .append("::").append(String.valueOf(this._retailTransactionLineItemSequence))
/* 228 */       .append("::").append(this._componentItemId)
/* 229 */       .append("::").append(String.valueOf(this._sequenceNumber))
/* 230 */       .append("::").append(this._propertyCode)
/* 231 */       .toString();
/*     */   }
/*     */   
/*     */   public boolean validate() {
/* 235 */     if (this._retailLocationId == null) {
/* 236 */       return false;
/*     */     }
/* 238 */     if (this._businessDate == null) {
/* 239 */       return false;
/*     */     }
/* 241 */     if (this._workstationId == null) {
/* 242 */       return false;
/*     */     }
/* 244 */     if (this._transactionSequence == null) {
/* 245 */       return false;
/*     */     }
/* 247 */     if (this._retailTransactionLineItemSequence == null) {
/* 248 */       return false;
/*     */     }
/* 250 */     if (this._componentItemId == null) {
/* 251 */       return false;
/*     */     }
/* 253 */     if (this._sequenceNumber == null) {
/* 254 */       return false;
/*     */     }
/* 256 */     if (this._propertyCode == null) {
/* 257 */       return false;
/*     */     }
/* 259 */     return true;
/*     */   }
/*     */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\trl\KitComponentModifierPropertyId.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */