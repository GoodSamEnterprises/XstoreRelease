/*     */ package dtv.xst.dao.trl;
/*     */ 
/*     */ import dtv.data2.access.AbstractObjectId;
/*     */ import dtv.data2.access.exception.DtxException;
/*     */ import dtv.util.DtvDate;
/*     */ import dtv.util.StringUtils;
/*     */ import java.util.Date;
/*     */ 
/*     */ 
/*     */ public class DimensionModifierPropertyId
/*     */   extends AbstractObjectId
/*     */ {
/*     */   private static final long serialVersionUID = 167379762L;
/*     */   private DtvDate _businessDate;
/*     */   private String _dimensionCode;
/*     */   private Long _retailLocationId;
/*     */   private Integer _retailTransactionLineItemSequence;
/*     */   private Long _transactionSequence;
/*     */   private Long _workstationId;
/*     */   private String _propertyCode;
/*     */   
/*     */   public DimensionModifierPropertyId() {}
/*     */   
/*     */   public DimensionModifierPropertyId(String argObjectIdValue) {
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
/*     */   public String getDimensionCode() {
/*  46 */     return this._dimensionCode;
/*     */   }
/*     */   
/*     */   public void setDimensionCode(String argDimensionCode) {
/*  50 */     this._dimensionCode = (argDimensionCode != null && MANAGE_CASE) ? argDimensionCode.toUpperCase() : argDimensionCode;
/*     */   }
/*     */   
/*     */   public Long getRetailLocationId() {
/*  54 */     return this._retailLocationId;
/*     */   }
/*     */   
/*     */   public void setRetailLocationId(Long argRetailLocationId) {
/*  58 */     this._retailLocationId = argRetailLocationId;
/*     */   }
/*     */   
/*     */   public Integer getRetailTransactionLineItemSequence() {
/*  62 */     return this._retailTransactionLineItemSequence;
/*     */   }
/*     */   
/*     */   public void setRetailTransactionLineItemSequence(Integer argRetailTransactionLineItemSequence) {
/*  66 */     this._retailTransactionLineItemSequence = argRetailTransactionLineItemSequence;
/*     */   }
/*     */   
/*     */   public Long getTransactionSequence() {
/*  70 */     return this._transactionSequence;
/*     */   }
/*     */   
/*     */   public void setTransactionSequence(Long argTransactionSequence) {
/*  74 */     this._transactionSequence = argTransactionSequence;
/*     */   }
/*     */   
/*     */   public Long getWorkstationId() {
/*  78 */     return this._workstationId;
/*     */   }
/*     */   
/*     */   public void setWorkstationId(Long argWorkstationId) {
/*  82 */     this._workstationId = argWorkstationId;
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
/* 111 */       if ("null".equals(str)) {
/* 112 */         setDimensionCode((String)null);
/*     */       } else {
/*     */         
/* 115 */         setDimensionCode(str);
/*     */       } 
/* 117 */       str = tokens[2];
/*     */       
/* 119 */       setOrganizationId(Long.valueOf(str));
/* 120 */       str = tokens[3];
/*     */       
/* 122 */       setRetailLocationId(Long.valueOf(str));
/* 123 */       str = tokens[4];
/*     */       
/* 125 */       setRetailTransactionLineItemSequence(Integer.valueOf(str));
/* 126 */       str = tokens[5];
/*     */       
/* 128 */       setTransactionSequence(Long.valueOf(str));
/* 129 */       str = tokens[6];
/*     */       
/* 131 */       setWorkstationId(Long.valueOf(str));
/* 132 */       str = tokens[7];
/*     */       
/* 134 */       if ("null".equals(str)) {
/* 135 */         setPropertyCode((String)null);
/*     */       } else {
/*     */         
/* 138 */         setPropertyCode(str);
/*     */       }
/*     */     
/* 141 */     } catch (Exception ee) {
/* 142 */       throw new DtxException("An exception occured while parsing object id string: " + argObjectIdValue, ee);
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean equals(Object ob) {
/* 148 */     if (this == ob) {
/* 149 */       return true;
/*     */     }
/* 151 */     if (!(ob instanceof DimensionModifierPropertyId)) {
/* 152 */       return false;
/*     */     }
/* 154 */     DimensionModifierPropertyId other = (DimensionModifierPropertyId)ob;
/* 155 */     return (((this._businessDate == null && other._businessDate == null) || (this._businessDate != null && this._businessDate
/*     */ 
/*     */       
/* 158 */       .equals(other._businessDate))) && ((this._dimensionCode == null && other._dimensionCode == null) || (this._dimensionCode != null && this._dimensionCode
/*     */ 
/*     */       
/* 161 */       .equals(other._dimensionCode))) && ((this._organizationId == null && other._organizationId == null) || (this._organizationId != null && this._organizationId
/*     */ 
/*     */       
/* 164 */       .equals(other._organizationId))) && ((this._retailLocationId == null && other._retailLocationId == null) || (this._retailLocationId != null && this._retailLocationId
/*     */ 
/*     */       
/* 167 */       .equals(other._retailLocationId))) && ((this._retailTransactionLineItemSequence == null && other._retailTransactionLineItemSequence == null) || (this._retailTransactionLineItemSequence != null && this._retailTransactionLineItemSequence
/*     */ 
/*     */       
/* 170 */       .equals(other._retailTransactionLineItemSequence))) && ((this._transactionSequence == null && other._transactionSequence == null) || (this._transactionSequence != null && this._transactionSequence
/*     */ 
/*     */       
/* 173 */       .equals(other._transactionSequence))) && ((this._workstationId == null && other._workstationId == null) || (this._workstationId != null && this._workstationId
/*     */ 
/*     */       
/* 176 */       .equals(other._workstationId))) && ((this._propertyCode == null && other._propertyCode == null) || (this._propertyCode != null && this._propertyCode
/*     */ 
/*     */       
/* 179 */       .equals(other._propertyCode))));
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public int hashCode() {
/* 185 */     return ((this._businessDate == null) ? 0 : this._businessDate
/* 186 */       .hashCode()) + ((this._dimensionCode == null) ? 0 : this._dimensionCode
/* 187 */       .hashCode()) + ((this._organizationId == null) ? 0 : this._organizationId
/* 188 */       .hashCode()) + ((this._retailLocationId == null) ? 0 : this._retailLocationId
/* 189 */       .hashCode()) + ((this._retailTransactionLineItemSequence == null) ? 0 : this._retailTransactionLineItemSequence
/* 190 */       .hashCode()) + ((this._transactionSequence == null) ? 0 : this._transactionSequence
/* 191 */       .hashCode()) + ((this._workstationId == null) ? 0 : this._workstationId
/* 192 */       .hashCode()) + ((this._propertyCode == null) ? 0 : this._propertyCode
/* 193 */       .hashCode());
/*     */   }
/*     */ 
/*     */   
/*     */   public String getDtxTypeName() {
/* 198 */     return "DimensionModifierProperty";
/*     */   }
/*     */ 
/*     */   
/*     */   public String toString() {
/* 203 */     StringBuilder buff = new StringBuilder(96);
/*     */     
/* 205 */     return buff.append((this._businessDate == null) ? "null" : 
/* 206 */         String.valueOf(this._businessDate.getTimeSerializable()))
/* 207 */       .append("::").append(this._dimensionCode)
/* 208 */       .append("::").append(String.valueOf(this._organizationId))
/* 209 */       .append("::").append(String.valueOf(this._retailLocationId))
/* 210 */       .append("::").append(String.valueOf(this._retailTransactionLineItemSequence))
/* 211 */       .append("::").append(String.valueOf(this._transactionSequence))
/* 212 */       .append("::").append(String.valueOf(this._workstationId))
/* 213 */       .append("::").append(this._propertyCode)
/* 214 */       .toString();
/*     */   }
/*     */   
/*     */   public boolean validate() {
/* 218 */     if (this._businessDate == null) {
/* 219 */       return false;
/*     */     }
/* 221 */     if (this._dimensionCode == null) {
/* 222 */       return false;
/*     */     }
/* 224 */     if (this._retailLocationId == null) {
/* 225 */       return false;
/*     */     }
/* 227 */     if (this._retailTransactionLineItemSequence == null) {
/* 228 */       return false;
/*     */     }
/* 230 */     if (this._transactionSequence == null) {
/* 231 */       return false;
/*     */     }
/* 233 */     if (this._workstationId == null) {
/* 234 */       return false;
/*     */     }
/* 236 */     if (this._propertyCode == null) {
/* 237 */       return false;
/*     */     }
/* 239 */     return true;
/*     */   }
/*     */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\trl\DimensionModifierPropertyId.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */