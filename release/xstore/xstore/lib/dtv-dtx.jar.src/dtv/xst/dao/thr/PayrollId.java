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
/*     */ 
/*     */ public class PayrollId
/*     */   extends AbstractObjectId
/*     */ {
/*     */   private static final long serialVersionUID = 878130437L;
/*     */   private Long _retailLocId;
/*     */   private Long _partyId;
/*     */   private DtvDate _businessDate;
/*     */   private String _payrollCategory;
/*     */   
/*     */   public PayrollId() {}
/*     */   
/*     */   public PayrollId(String argObjectIdValue) {
/*  25 */     setValue(argObjectIdValue);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Long getRetailLocId() {
/*  34 */     return this._retailLocId;
/*     */   }
/*     */   
/*     */   public void setRetailLocId(Long argRetailLocId) {
/*  38 */     this._retailLocId = argRetailLocId;
/*     */   }
/*     */   
/*     */   public Long getPartyId() {
/*  42 */     return this._partyId;
/*     */   }
/*     */   
/*     */   public void setPartyId(Long argPartyId) {
/*  46 */     this._partyId = argPartyId;
/*     */   }
/*     */   
/*     */   public Date getBusinessDate() {
/*  50 */     return (Date)this._businessDate;
/*     */   }
/*     */   
/*     */   public void setBusinessDate(Date argBusinessDate) {
/*  54 */     this._businessDate = (argBusinessDate == null || argBusinessDate instanceof DtvDate) ? (DtvDate)argBusinessDate : new DtvDate(argBusinessDate);
/*     */   }
/*     */ 
/*     */   
/*     */   public String getPayrollCategory() {
/*  59 */     return this._payrollCategory;
/*     */   }
/*     */   
/*     */   public void setPayrollCategory(String argPayrollCategory) {
/*  63 */     this._payrollCategory = (argPayrollCategory != null && MANAGE_CASE) ? argPayrollCategory.toUpperCase() : argPayrollCategory;
/*     */   }
/*     */   
/*     */   public void setValue(String argObjectIdValue) {
/*  67 */     String str = argObjectIdValue;
/*  68 */     if (StringUtils.isEmpty(str)) {
/*  69 */       throw new DtxException("argument passed to setValue() is null or empty - a valid value must be passed");
/*     */     }
/*     */     try {
/*  72 */       String[] tokens = str.split("::");
/*  73 */       str = tokens[0];
/*     */       
/*  75 */       setRetailLocId(Long.valueOf(str));
/*  76 */       str = tokens[1];
/*     */       
/*  78 */       setPartyId(Long.valueOf(str));
/*  79 */       str = tokens[2];
/*     */       
/*  81 */       setOrganizationId(Long.valueOf(str));
/*  82 */       str = tokens[3];
/*     */       
/*  84 */       if ("null".equals(str)) {
/*  85 */         setBusinessDate((Date)null);
/*     */       } else {
/*     */         
/*  88 */         setBusinessDate((Date)new DtvDate());
/*  89 */         this._businessDate.setTimeFromSerialization(Long.parseLong(str));
/*     */       } 
/*  91 */       str = tokens[4];
/*     */       
/*  93 */       if ("null".equals(str)) {
/*  94 */         setPayrollCategory((String)null);
/*     */       } else {
/*     */         
/*  97 */         setPayrollCategory(str);
/*     */       }
/*     */     
/* 100 */     } catch (Exception ee) {
/* 101 */       throw new DtxException("An exception occured while parsing object id string: " + argObjectIdValue, ee);
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean equals(Object ob) {
/* 107 */     if (this == ob) {
/* 108 */       return true;
/*     */     }
/* 110 */     if (!(ob instanceof PayrollId)) {
/* 111 */       return false;
/*     */     }
/* 113 */     PayrollId other = (PayrollId)ob;
/* 114 */     return (((this._retailLocId == null && other._retailLocId == null) || (this._retailLocId != null && this._retailLocId
/*     */ 
/*     */       
/* 117 */       .equals(other._retailLocId))) && ((this._partyId == null && other._partyId == null) || (this._partyId != null && this._partyId
/*     */ 
/*     */       
/* 120 */       .equals(other._partyId))) && ((this._organizationId == null && other._organizationId == null) || (this._organizationId != null && this._organizationId
/*     */ 
/*     */       
/* 123 */       .equals(other._organizationId))) && ((this._businessDate == null && other._businessDate == null) || (this._businessDate != null && this._businessDate
/*     */ 
/*     */       
/* 126 */       .equals(other._businessDate))) && ((this._payrollCategory == null && other._payrollCategory == null) || (this._payrollCategory != null && this._payrollCategory
/*     */ 
/*     */       
/* 129 */       .equals(other._payrollCategory))));
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public int hashCode() {
/* 135 */     return ((this._retailLocId == null) ? 0 : this._retailLocId
/* 136 */       .hashCode()) + ((this._partyId == null) ? 0 : this._partyId
/* 137 */       .hashCode()) + ((this._organizationId == null) ? 0 : this._organizationId
/* 138 */       .hashCode()) + ((this._businessDate == null) ? 0 : this._businessDate
/* 139 */       .hashCode()) + ((this._payrollCategory == null) ? 0 : this._payrollCategory
/* 140 */       .hashCode());
/*     */   }
/*     */ 
/*     */   
/*     */   public String getDtxTypeName() {
/* 145 */     return "Payroll";
/*     */   }
/*     */ 
/*     */   
/*     */   public String toString() {
/* 150 */     StringBuilder buff = new StringBuilder(60);
/*     */     
/* 152 */     return buff.append(
/* 153 */         String.valueOf(this._retailLocId))
/* 154 */       .append("::").append(String.valueOf(this._partyId))
/* 155 */       .append("::").append(String.valueOf(this._organizationId))
/* 156 */       .append("::").append((this._businessDate == null) ? "null" : String.valueOf(this._businessDate.getTimeSerializable()))
/* 157 */       .append("::").append(this._payrollCategory)
/* 158 */       .toString();
/*     */   }
/*     */   
/*     */   public boolean validate() {
/* 162 */     if (this._retailLocId == null) {
/* 163 */       return false;
/*     */     }
/* 165 */     if (this._partyId == null) {
/* 166 */       return false;
/*     */     }
/* 168 */     if (this._businessDate == null) {
/* 169 */       return false;
/*     */     }
/* 171 */     if (this._payrollCategory == null) {
/* 172 */       return false;
/*     */     }
/* 174 */     return true;
/*     */   }
/*     */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\thr\PayrollId.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */