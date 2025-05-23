/*     */ package dtv.xst.dao.cat;
/*     */ 
/*     */ import dtv.data2.access.AbstractObjectId;
/*     */ import dtv.data2.access.exception.DtxException;
/*     */ import dtv.util.DtvDate;
/*     */ import dtv.util.StringUtils;
/*     */ import java.util.Date;
/*     */ 
/*     */ 
/*     */ 
/*     */ public class CustomerAccountAuthorizationPropertyId
/*     */   extends AbstractObjectId
/*     */ {
/*     */   private static final long serialVersionUID = 1070701663L;
/*     */   private Integer _retailTransactionLineItemSequence;
/*     */   private Long _retailLocationId;
/*     */   private Long _workstationId;
/*     */   private DtvDate _businessDate;
/*     */   private Long _transactionSequence;
/*     */   private String _propertyCode;
/*     */   
/*     */   public CustomerAccountAuthorizationPropertyId() {}
/*     */   
/*     */   public CustomerAccountAuthorizationPropertyId(String argObjectIdValue) {
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
/*     */   public Integer getRetailTransactionLineItemSequence() {
/*  36 */     return this._retailTransactionLineItemSequence;
/*     */   }
/*     */   
/*     */   public void setRetailTransactionLineItemSequence(Integer argRetailTransactionLineItemSequence) {
/*  40 */     this._retailTransactionLineItemSequence = argRetailTransactionLineItemSequence;
/*     */   }
/*     */   
/*     */   public Long getRetailLocationId() {
/*  44 */     return this._retailLocationId;
/*     */   }
/*     */   
/*     */   public void setRetailLocationId(Long argRetailLocationId) {
/*  48 */     this._retailLocationId = argRetailLocationId;
/*     */   }
/*     */   
/*     */   public Long getWorkstationId() {
/*  52 */     return this._workstationId;
/*     */   }
/*     */   
/*     */   public void setWorkstationId(Long argWorkstationId) {
/*  56 */     this._workstationId = argWorkstationId;
/*     */   }
/*     */   
/*     */   public Date getBusinessDate() {
/*  60 */     return (Date)this._businessDate;
/*     */   }
/*     */   
/*     */   public void setBusinessDate(Date argBusinessDate) {
/*  64 */     this._businessDate = (argBusinessDate == null || argBusinessDate instanceof DtvDate) ? (DtvDate)argBusinessDate : new DtvDate(argBusinessDate);
/*     */   }
/*     */ 
/*     */   
/*     */   public Long getTransactionSequence() {
/*  69 */     return this._transactionSequence;
/*     */   }
/*     */   
/*     */   public void setTransactionSequence(Long argTransactionSequence) {
/*  73 */     this._transactionSequence = argTransactionSequence;
/*     */   }
/*     */   
/*     */   public String getPropertyCode() {
/*  77 */     return this._propertyCode;
/*     */   }
/*     */   
/*     */   public void setPropertyCode(String argPropertyCode) {
/*  81 */     this._propertyCode = (argPropertyCode != null && MANAGE_CASE) ? argPropertyCode.toUpperCase() : argPropertyCode;
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
/*  96 */       setRetailTransactionLineItemSequence(Integer.valueOf(str));
/*  97 */       str = tokens[2];
/*     */       
/*  99 */       setRetailLocationId(Long.valueOf(str));
/* 100 */       str = tokens[3];
/*     */       
/* 102 */       setWorkstationId(Long.valueOf(str));
/* 103 */       str = tokens[4];
/*     */       
/* 105 */       if ("null".equals(str)) {
/* 106 */         setBusinessDate((Date)null);
/*     */       } else {
/*     */         
/* 109 */         setBusinessDate((Date)new DtvDate());
/* 110 */         this._businessDate.setTimeFromSerialization(Long.parseLong(str));
/*     */       } 
/* 112 */       str = tokens[5];
/*     */       
/* 114 */       setTransactionSequence(Long.valueOf(str));
/* 115 */       str = tokens[6];
/*     */       
/* 117 */       if ("null".equals(str)) {
/* 118 */         setPropertyCode((String)null);
/*     */       } else {
/*     */         
/* 121 */         setPropertyCode(str);
/*     */       }
/*     */     
/* 124 */     } catch (Exception ee) {
/* 125 */       throw new DtxException("An exception occured while parsing object id string: " + argObjectIdValue, ee);
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean equals(Object ob) {
/* 131 */     if (this == ob) {
/* 132 */       return true;
/*     */     }
/* 134 */     if (!(ob instanceof CustomerAccountAuthorizationPropertyId)) {
/* 135 */       return false;
/*     */     }
/* 137 */     CustomerAccountAuthorizationPropertyId other = (CustomerAccountAuthorizationPropertyId)ob;
/* 138 */     return (((this._organizationId == null && other._organizationId == null) || (this._organizationId != null && this._organizationId
/*     */ 
/*     */       
/* 141 */       .equals(other._organizationId))) && ((this._retailTransactionLineItemSequence == null && other._retailTransactionLineItemSequence == null) || (this._retailTransactionLineItemSequence != null && this._retailTransactionLineItemSequence
/*     */ 
/*     */       
/* 144 */       .equals(other._retailTransactionLineItemSequence))) && ((this._retailLocationId == null && other._retailLocationId == null) || (this._retailLocationId != null && this._retailLocationId
/*     */ 
/*     */       
/* 147 */       .equals(other._retailLocationId))) && ((this._workstationId == null && other._workstationId == null) || (this._workstationId != null && this._workstationId
/*     */ 
/*     */       
/* 150 */       .equals(other._workstationId))) && ((this._businessDate == null && other._businessDate == null) || (this._businessDate != null && this._businessDate
/*     */ 
/*     */       
/* 153 */       .equals(other._businessDate))) && ((this._transactionSequence == null && other._transactionSequence == null) || (this._transactionSequence != null && this._transactionSequence
/*     */ 
/*     */       
/* 156 */       .equals(other._transactionSequence))) && ((this._propertyCode == null && other._propertyCode == null) || (this._propertyCode != null && this._propertyCode
/*     */ 
/*     */       
/* 159 */       .equals(other._propertyCode))));
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public int hashCode() {
/* 165 */     return ((this._organizationId == null) ? 0 : this._organizationId
/* 166 */       .hashCode()) + ((this._retailTransactionLineItemSequence == null) ? 0 : this._retailTransactionLineItemSequence
/* 167 */       .hashCode()) + ((this._retailLocationId == null) ? 0 : this._retailLocationId
/* 168 */       .hashCode()) + ((this._workstationId == null) ? 0 : this._workstationId
/* 169 */       .hashCode()) + ((this._businessDate == null) ? 0 : this._businessDate
/* 170 */       .hashCode()) + ((this._transactionSequence == null) ? 0 : this._transactionSequence
/* 171 */       .hashCode()) + ((this._propertyCode == null) ? 0 : this._propertyCode
/* 172 */       .hashCode());
/*     */   }
/*     */ 
/*     */   
/*     */   public String getDtxTypeName() {
/* 177 */     return "CustomerAccountAuthorizationProperty";
/*     */   }
/*     */ 
/*     */   
/*     */   public String toString() {
/* 182 */     StringBuilder buff = new StringBuilder(84);
/*     */     
/* 184 */     return buff.append(
/* 185 */         String.valueOf(this._organizationId))
/* 186 */       .append("::").append(String.valueOf(this._retailTransactionLineItemSequence))
/* 187 */       .append("::").append(String.valueOf(this._retailLocationId))
/* 188 */       .append("::").append(String.valueOf(this._workstationId))
/* 189 */       .append("::").append((this._businessDate == null) ? "null" : String.valueOf(this._businessDate.getTimeSerializable()))
/* 190 */       .append("::").append(String.valueOf(this._transactionSequence))
/* 191 */       .append("::").append(this._propertyCode)
/* 192 */       .toString();
/*     */   }
/*     */   
/*     */   public boolean validate() {
/* 196 */     if (this._retailTransactionLineItemSequence == null) {
/* 197 */       return false;
/*     */     }
/* 199 */     if (this._retailLocationId == null) {
/* 200 */       return false;
/*     */     }
/* 202 */     if (this._workstationId == null) {
/* 203 */       return false;
/*     */     }
/* 205 */     if (this._businessDate == null) {
/* 206 */       return false;
/*     */     }
/* 208 */     if (this._transactionSequence == null) {
/* 209 */       return false;
/*     */     }
/* 211 */     if (this._propertyCode == null) {
/* 212 */       return false;
/*     */     }
/* 214 */     return true;
/*     */   }
/*     */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\cat\CustomerAccountAuthorizationPropertyId.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */