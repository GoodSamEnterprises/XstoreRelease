/*     */ package dtv.xst.dao.trl;
/*     */ 
/*     */ import dtv.data2.access.AbstractObjectId;
/*     */ import dtv.data2.access.exception.DtxException;
/*     */ import dtv.util.DtvDate;
/*     */ import dtv.util.StringUtils;
/*     */ import java.util.Date;
/*     */ 
/*     */ 
/*     */ public class WarrantyModifierPropertyId
/*     */   extends AbstractObjectId
/*     */ {
/*     */   private static final long serialVersionUID = -889360632L;
/*     */   private DtvDate _businessDate;
/*     */   private Long _retailLocationId;
/*     */   private Integer _retailTransactionLineItemSequence;
/*     */   private Long _transactionSequence;
/*     */   private Long _workstationId;
/*     */   private Integer _warrantyModifierSequence;
/*     */   private String _propertyCode;
/*     */   
/*     */   public WarrantyModifierPropertyId() {}
/*     */   
/*     */   public WarrantyModifierPropertyId(String argObjectIdValue) {
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
/*     */   public Date getBusinessDate() {
/*  37 */     return (Date)this._businessDate;
/*     */   }
/*     */   
/*     */   public void setBusinessDate(Date argBusinessDate) {
/*  41 */     this._businessDate = (argBusinessDate == null || argBusinessDate instanceof DtvDate) ? (DtvDate)argBusinessDate : new DtvDate(argBusinessDate);
/*     */   }
/*     */ 
/*     */   
/*     */   public Long getRetailLocationId() {
/*  46 */     return this._retailLocationId;
/*     */   }
/*     */   
/*     */   public void setRetailLocationId(Long argRetailLocationId) {
/*  50 */     this._retailLocationId = argRetailLocationId;
/*     */   }
/*     */   
/*     */   public Integer getRetailTransactionLineItemSequence() {
/*  54 */     return this._retailTransactionLineItemSequence;
/*     */   }
/*     */   
/*     */   public void setRetailTransactionLineItemSequence(Integer argRetailTransactionLineItemSequence) {
/*  58 */     this._retailTransactionLineItemSequence = argRetailTransactionLineItemSequence;
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
/*     */   public Long getWorkstationId() {
/*  70 */     return this._workstationId;
/*     */   }
/*     */   
/*     */   public void setWorkstationId(Long argWorkstationId) {
/*  74 */     this._workstationId = argWorkstationId;
/*     */   }
/*     */   
/*     */   public Integer getWarrantyModifierSequence() {
/*  78 */     return this._warrantyModifierSequence;
/*     */   }
/*     */   
/*     */   public void setWarrantyModifierSequence(Integer argWarrantyModifierSequence) {
/*  82 */     this._warrantyModifierSequence = argWarrantyModifierSequence;
/*     */   }
/*     */   
/*     */   public String getPropertyCode() {
/*  86 */     return this._propertyCode;
/*     */   }
/*     */   
/*     */   public void setPropertyCode(String argPropertyCode) {
/*  90 */     this._propertyCode = (argPropertyCode != null && MANAGE_CASE) ? argPropertyCode.toUpperCase() : argPropertyCode;
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
/* 102 */       if ("null".equals(str)) {
/* 103 */         setBusinessDate((Date)null);
/*     */       } else {
/*     */         
/* 106 */         setBusinessDate((Date)new DtvDate());
/* 107 */         this._businessDate.setTimeFromSerialization(Long.parseLong(str));
/*     */       } 
/* 109 */       str = tokens[1];
/*     */       
/* 111 */       setOrganizationId(Long.valueOf(str));
/* 112 */       str = tokens[2];
/*     */       
/* 114 */       setRetailLocationId(Long.valueOf(str));
/* 115 */       str = tokens[3];
/*     */       
/* 117 */       setRetailTransactionLineItemSequence(Integer.valueOf(str));
/* 118 */       str = tokens[4];
/*     */       
/* 120 */       setTransactionSequence(Long.valueOf(str));
/* 121 */       str = tokens[5];
/*     */       
/* 123 */       setWorkstationId(Long.valueOf(str));
/* 124 */       str = tokens[6];
/*     */       
/* 126 */       setWarrantyModifierSequence(Integer.valueOf(str));
/* 127 */       str = tokens[7];
/*     */       
/* 129 */       if ("null".equals(str)) {
/* 130 */         setPropertyCode((String)null);
/*     */       } else {
/*     */         
/* 133 */         setPropertyCode(str);
/*     */       }
/*     */     
/* 136 */     } catch (Exception ee) {
/* 137 */       throw new DtxException("An exception occured while parsing object id string: " + argObjectIdValue, ee);
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean equals(Object ob) {
/* 143 */     if (this == ob) {
/* 144 */       return true;
/*     */     }
/* 146 */     if (!(ob instanceof WarrantyModifierPropertyId)) {
/* 147 */       return false;
/*     */     }
/* 149 */     WarrantyModifierPropertyId other = (WarrantyModifierPropertyId)ob;
/* 150 */     return (((this._businessDate == null && other._businessDate == null) || (this._businessDate != null && this._businessDate
/*     */ 
/*     */       
/* 153 */       .equals(other._businessDate))) && ((this._organizationId == null && other._organizationId == null) || (this._organizationId != null && this._organizationId
/*     */ 
/*     */       
/* 156 */       .equals(other._organizationId))) && ((this._retailLocationId == null && other._retailLocationId == null) || (this._retailLocationId != null && this._retailLocationId
/*     */ 
/*     */       
/* 159 */       .equals(other._retailLocationId))) && ((this._retailTransactionLineItemSequence == null && other._retailTransactionLineItemSequence == null) || (this._retailTransactionLineItemSequence != null && this._retailTransactionLineItemSequence
/*     */ 
/*     */       
/* 162 */       .equals(other._retailTransactionLineItemSequence))) && ((this._transactionSequence == null && other._transactionSequence == null) || (this._transactionSequence != null && this._transactionSequence
/*     */ 
/*     */       
/* 165 */       .equals(other._transactionSequence))) && ((this._workstationId == null && other._workstationId == null) || (this._workstationId != null && this._workstationId
/*     */ 
/*     */       
/* 168 */       .equals(other._workstationId))) && ((this._warrantyModifierSequence == null && other._warrantyModifierSequence == null) || (this._warrantyModifierSequence != null && this._warrantyModifierSequence
/*     */ 
/*     */       
/* 171 */       .equals(other._warrantyModifierSequence))) && ((this._propertyCode == null && other._propertyCode == null) || (this._propertyCode != null && this._propertyCode
/*     */ 
/*     */       
/* 174 */       .equals(other._propertyCode))));
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public int hashCode() {
/* 180 */     return ((this._businessDate == null) ? 0 : this._businessDate
/* 181 */       .hashCode()) + ((this._organizationId == null) ? 0 : this._organizationId
/* 182 */       .hashCode()) + ((this._retailLocationId == null) ? 0 : this._retailLocationId
/* 183 */       .hashCode()) + ((this._retailTransactionLineItemSequence == null) ? 0 : this._retailTransactionLineItemSequence
/* 184 */       .hashCode()) + ((this._transactionSequence == null) ? 0 : this._transactionSequence
/* 185 */       .hashCode()) + ((this._workstationId == null) ? 0 : this._workstationId
/* 186 */       .hashCode()) + ((this._warrantyModifierSequence == null) ? 0 : this._warrantyModifierSequence
/* 187 */       .hashCode()) + ((this._propertyCode == null) ? 0 : this._propertyCode
/* 188 */       .hashCode());
/*     */   }
/*     */ 
/*     */   
/*     */   public String getDtxTypeName() {
/* 193 */     return "WarrantyModifierProperty";
/*     */   }
/*     */ 
/*     */   
/*     */   public String toString() {
/* 198 */     StringBuilder buff = new StringBuilder(96);
/*     */     
/* 200 */     return buff.append((this._businessDate == null) ? "null" : 
/* 201 */         String.valueOf(this._businessDate.getTimeSerializable()))
/* 202 */       .append("::").append(String.valueOf(this._organizationId))
/* 203 */       .append("::").append(String.valueOf(this._retailLocationId))
/* 204 */       .append("::").append(String.valueOf(this._retailTransactionLineItemSequence))
/* 205 */       .append("::").append(String.valueOf(this._transactionSequence))
/* 206 */       .append("::").append(String.valueOf(this._workstationId))
/* 207 */       .append("::").append(String.valueOf(this._warrantyModifierSequence))
/* 208 */       .append("::").append(this._propertyCode)
/* 209 */       .toString();
/*     */   }
/*     */   
/*     */   public boolean validate() {
/* 213 */     if (this._businessDate == null) {
/* 214 */       return false;
/*     */     }
/* 216 */     if (this._retailLocationId == null) {
/* 217 */       return false;
/*     */     }
/* 219 */     if (this._retailTransactionLineItemSequence == null) {
/* 220 */       return false;
/*     */     }
/* 222 */     if (this._transactionSequence == null) {
/* 223 */       return false;
/*     */     }
/* 225 */     if (this._workstationId == null) {
/* 226 */       return false;
/*     */     }
/* 228 */     if (this._warrantyModifierSequence == null) {
/* 229 */       return false;
/*     */     }
/* 231 */     if (this._propertyCode == null) {
/* 232 */       return false;
/*     */     }
/* 234 */     return true;
/*     */   }
/*     */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\trl\WarrantyModifierPropertyId.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */