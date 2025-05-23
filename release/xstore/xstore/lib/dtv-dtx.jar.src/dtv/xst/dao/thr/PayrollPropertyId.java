/*     */ package dtv.xst.dao.thr;
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
/*     */ public class PayrollPropertyId
/*     */   extends AbstractObjectId
/*     */ {
/*     */   private static final long serialVersionUID = -967794182L;
/*     */   private Long _retailLocId;
/*     */   private Long _partyId;
/*     */   private DtvDate _businessDate;
/*     */   private String _payrollCategory;
/*     */   private String _propertyCode;
/*     */   
/*     */   public PayrollPropertyId() {}
/*     */   
/*     */   public PayrollPropertyId(String argObjectIdValue) {
/*  25 */     setValue(argObjectIdValue);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Long getRetailLocId() {
/*  35 */     return this._retailLocId;
/*     */   }
/*     */   
/*     */   public void setRetailLocId(Long argRetailLocId) {
/*  39 */     this._retailLocId = argRetailLocId;
/*     */   }
/*     */   
/*     */   public Long getPartyId() {
/*  43 */     return this._partyId;
/*     */   }
/*     */   
/*     */   public void setPartyId(Long argPartyId) {
/*  47 */     this._partyId = argPartyId;
/*     */   }
/*     */   
/*     */   public Date getBusinessDate() {
/*  51 */     return (Date)this._businessDate;
/*     */   }
/*     */   
/*     */   public void setBusinessDate(Date argBusinessDate) {
/*  55 */     this._businessDate = (argBusinessDate == null || argBusinessDate instanceof DtvDate) ? (DtvDate)argBusinessDate : new DtvDate(argBusinessDate);
/*     */   }
/*     */ 
/*     */   
/*     */   public String getPayrollCategory() {
/*  60 */     return this._payrollCategory;
/*     */   }
/*     */   
/*     */   public void setPayrollCategory(String argPayrollCategory) {
/*  64 */     this._payrollCategory = (argPayrollCategory != null && MANAGE_CASE) ? argPayrollCategory.toUpperCase() : argPayrollCategory;
/*     */   }
/*     */   
/*     */   public String getPropertyCode() {
/*  68 */     return this._propertyCode;
/*     */   }
/*     */   
/*     */   public void setPropertyCode(String argPropertyCode) {
/*  72 */     this._propertyCode = (argPropertyCode != null && MANAGE_CASE) ? argPropertyCode.toUpperCase() : argPropertyCode;
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
/*  84 */       setRetailLocId(Long.valueOf(str));
/*  85 */       str = tokens[1];
/*     */       
/*  87 */       setPartyId(Long.valueOf(str));
/*  88 */       str = tokens[2];
/*     */       
/*  90 */       setOrganizationId(Long.valueOf(str));
/*  91 */       str = tokens[3];
/*     */       
/*  93 */       if ("null".equals(str)) {
/*  94 */         setBusinessDate((Date)null);
/*     */       } else {
/*     */         
/*  97 */         setBusinessDate((Date)new DtvDate());
/*  98 */         this._businessDate.setTimeFromSerialization(Long.parseLong(str));
/*     */       } 
/* 100 */       str = tokens[4];
/*     */       
/* 102 */       if ("null".equals(str)) {
/* 103 */         setPayrollCategory((String)null);
/*     */       } else {
/*     */         
/* 106 */         setPayrollCategory(str);
/*     */       } 
/* 108 */       str = tokens[5];
/*     */       
/* 110 */       if ("null".equals(str)) {
/* 111 */         setPropertyCode((String)null);
/*     */       } else {
/*     */         
/* 114 */         setPropertyCode(str);
/*     */       }
/*     */     
/* 117 */     } catch (Exception ee) {
/* 118 */       throw new DtxException("An exception occured while parsing object id string: " + argObjectIdValue, ee);
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean equals(Object ob) {
/* 124 */     if (this == ob) {
/* 125 */       return true;
/*     */     }
/* 127 */     if (!(ob instanceof PayrollPropertyId)) {
/* 128 */       return false;
/*     */     }
/* 130 */     PayrollPropertyId other = (PayrollPropertyId)ob;
/* 131 */     return (((this._retailLocId == null && other._retailLocId == null) || (this._retailLocId != null && this._retailLocId
/*     */ 
/*     */       
/* 134 */       .equals(other._retailLocId))) && ((this._partyId == null && other._partyId == null) || (this._partyId != null && this._partyId
/*     */ 
/*     */       
/* 137 */       .equals(other._partyId))) && ((this._organizationId == null && other._organizationId == null) || (this._organizationId != null && this._organizationId
/*     */ 
/*     */       
/* 140 */       .equals(other._organizationId))) && ((this._businessDate == null && other._businessDate == null) || (this._businessDate != null && this._businessDate
/*     */ 
/*     */       
/* 143 */       .equals(other._businessDate))) && ((this._payrollCategory == null && other._payrollCategory == null) || (this._payrollCategory != null && this._payrollCategory
/*     */ 
/*     */       
/* 146 */       .equals(other._payrollCategory))) && ((this._propertyCode == null && other._propertyCode == null) || (this._propertyCode != null && this._propertyCode
/*     */ 
/*     */       
/* 149 */       .equals(other._propertyCode))));
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public int hashCode() {
/* 155 */     return ((this._retailLocId == null) ? 0 : this._retailLocId
/* 156 */       .hashCode()) + ((this._partyId == null) ? 0 : this._partyId
/* 157 */       .hashCode()) + ((this._organizationId == null) ? 0 : this._organizationId
/* 158 */       .hashCode()) + ((this._businessDate == null) ? 0 : this._businessDate
/* 159 */       .hashCode()) + ((this._payrollCategory == null) ? 0 : this._payrollCategory
/* 160 */       .hashCode()) + ((this._propertyCode == null) ? 0 : this._propertyCode
/* 161 */       .hashCode());
/*     */   }
/*     */ 
/*     */   
/*     */   public String getDtxTypeName() {
/* 166 */     return "PayrollProperty";
/*     */   }
/*     */ 
/*     */   
/*     */   public String toString() {
/* 171 */     StringBuilder buff = new StringBuilder(72);
/*     */     
/* 173 */     return buff.append(
/* 174 */         String.valueOf(this._retailLocId))
/* 175 */       .append("::").append(String.valueOf(this._partyId))
/* 176 */       .append("::").append(String.valueOf(this._organizationId))
/* 177 */       .append("::").append((this._businessDate == null) ? "null" : String.valueOf(this._businessDate.getTimeSerializable()))
/* 178 */       .append("::").append(this._payrollCategory)
/* 179 */       .append("::").append(this._propertyCode)
/* 180 */       .toString();
/*     */   }
/*     */   
/*     */   public boolean validate() {
/* 184 */     if (this._retailLocId == null) {
/* 185 */       return false;
/*     */     }
/* 187 */     if (this._partyId == null) {
/* 188 */       return false;
/*     */     }
/* 190 */     if (this._businessDate == null) {
/* 191 */       return false;
/*     */     }
/* 193 */     if (this._payrollCategory == null) {
/* 194 */       return false;
/*     */     }
/* 196 */     if (this._propertyCode == null) {
/* 197 */       return false;
/*     */     }
/* 199 */     return true;
/*     */   }
/*     */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\thr\PayrollPropertyId.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */