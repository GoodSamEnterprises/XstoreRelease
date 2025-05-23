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
/*     */ public class DimensionModifierId
/*     */   extends AbstractObjectId
/*     */ {
/*     */   private static final long serialVersionUID = -734966211L;
/*     */   private DtvDate _businessDate;
/*     */   private String _dimensionCode;
/*     */   private Long _retailLocationId;
/*     */   private Integer _retailTransactionLineItemSequence;
/*     */   private Long _transactionSequence;
/*     */   private Long _workstationId;
/*     */   
/*     */   public DimensionModifierId() {}
/*     */   
/*     */   public DimensionModifierId(String argObjectIdValue) {
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
/*     */   public String getDimensionCode() {
/*  45 */     return this._dimensionCode;
/*     */   }
/*     */   
/*     */   public void setDimensionCode(String argDimensionCode) {
/*  49 */     this._dimensionCode = (argDimensionCode != null && MANAGE_CASE) ? argDimensionCode.toUpperCase() : argDimensionCode;
/*     */   }
/*     */   
/*     */   public Long getRetailLocationId() {
/*  53 */     return this._retailLocationId;
/*     */   }
/*     */   
/*     */   public void setRetailLocationId(Long argRetailLocationId) {
/*  57 */     this._retailLocationId = argRetailLocationId;
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
/* 102 */       if ("null".equals(str)) {
/* 103 */         setDimensionCode((String)null);
/*     */       } else {
/*     */         
/* 106 */         setDimensionCode(str);
/*     */       } 
/* 108 */       str = tokens[2];
/*     */       
/* 110 */       setOrganizationId(Long.valueOf(str));
/* 111 */       str = tokens[3];
/*     */       
/* 113 */       setRetailLocationId(Long.valueOf(str));
/* 114 */       str = tokens[4];
/*     */       
/* 116 */       setRetailTransactionLineItemSequence(Integer.valueOf(str));
/* 117 */       str = tokens[5];
/*     */       
/* 119 */       setTransactionSequence(Long.valueOf(str));
/* 120 */       str = tokens[6];
/*     */       
/* 122 */       setWorkstationId(Long.valueOf(str));
/*     */     }
/* 124 */     catch (Exception ee) {
/* 125 */       throw new DtxException("An exception occured while parsing object id string: " + argObjectIdValue, ee);
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean equals(Object ob) {
/* 131 */     if (this == ob) {
/* 132 */       return true;
/*     */     }
/* 134 */     if (!(ob instanceof DimensionModifierId)) {
/* 135 */       return false;
/*     */     }
/* 137 */     DimensionModifierId other = (DimensionModifierId)ob;
/* 138 */     return (((this._businessDate == null && other._businessDate == null) || (this._businessDate != null && this._businessDate
/*     */ 
/*     */       
/* 141 */       .equals(other._businessDate))) && ((this._dimensionCode == null && other._dimensionCode == null) || (this._dimensionCode != null && this._dimensionCode
/*     */ 
/*     */       
/* 144 */       .equals(other._dimensionCode))) && ((this._organizationId == null && other._organizationId == null) || (this._organizationId != null && this._organizationId
/*     */ 
/*     */       
/* 147 */       .equals(other._organizationId))) && ((this._retailLocationId == null && other._retailLocationId == null) || (this._retailLocationId != null && this._retailLocationId
/*     */ 
/*     */       
/* 150 */       .equals(other._retailLocationId))) && ((this._retailTransactionLineItemSequence == null && other._retailTransactionLineItemSequence == null) || (this._retailTransactionLineItemSequence != null && this._retailTransactionLineItemSequence
/*     */ 
/*     */       
/* 153 */       .equals(other._retailTransactionLineItemSequence))) && ((this._transactionSequence == null && other._transactionSequence == null) || (this._transactionSequence != null && this._transactionSequence
/*     */ 
/*     */       
/* 156 */       .equals(other._transactionSequence))) && ((this._workstationId == null && other._workstationId == null) || (this._workstationId != null && this._workstationId
/*     */ 
/*     */       
/* 159 */       .equals(other._workstationId))));
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public int hashCode() {
/* 165 */     return ((this._businessDate == null) ? 0 : this._businessDate
/* 166 */       .hashCode()) + ((this._dimensionCode == null) ? 0 : this._dimensionCode
/* 167 */       .hashCode()) + ((this._organizationId == null) ? 0 : this._organizationId
/* 168 */       .hashCode()) + ((this._retailLocationId == null) ? 0 : this._retailLocationId
/* 169 */       .hashCode()) + ((this._retailTransactionLineItemSequence == null) ? 0 : this._retailTransactionLineItemSequence
/* 170 */       .hashCode()) + ((this._transactionSequence == null) ? 0 : this._transactionSequence
/* 171 */       .hashCode()) + ((this._workstationId == null) ? 0 : this._workstationId
/* 172 */       .hashCode());
/*     */   }
/*     */ 
/*     */   
/*     */   public String getDtxTypeName() {
/* 177 */     return "DimensionModifier";
/*     */   }
/*     */ 
/*     */   
/*     */   public String toString() {
/* 182 */     StringBuilder buff = new StringBuilder(84);
/*     */     
/* 184 */     return buff.append((this._businessDate == null) ? "null" : 
/* 185 */         String.valueOf(this._businessDate.getTimeSerializable()))
/* 186 */       .append("::").append(this._dimensionCode)
/* 187 */       .append("::").append(String.valueOf(this._organizationId))
/* 188 */       .append("::").append(String.valueOf(this._retailLocationId))
/* 189 */       .append("::").append(String.valueOf(this._retailTransactionLineItemSequence))
/* 190 */       .append("::").append(String.valueOf(this._transactionSequence))
/* 191 */       .append("::").append(String.valueOf(this._workstationId))
/* 192 */       .toString();
/*     */   }
/*     */   
/*     */   public boolean validate() {
/* 196 */     if (this._businessDate == null) {
/* 197 */       return false;
/*     */     }
/* 199 */     if (this._dimensionCode == null) {
/* 200 */       return false;
/*     */     }
/* 202 */     if (this._retailLocationId == null) {
/* 203 */       return false;
/*     */     }
/* 205 */     if (this._retailTransactionLineItemSequence == null) {
/* 206 */       return false;
/*     */     }
/* 208 */     if (this._transactionSequence == null) {
/* 209 */       return false;
/*     */     }
/* 211 */     if (this._workstationId == null) {
/* 212 */       return false;
/*     */     }
/* 214 */     return true;
/*     */   }
/*     */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\trl\DimensionModifierId.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */