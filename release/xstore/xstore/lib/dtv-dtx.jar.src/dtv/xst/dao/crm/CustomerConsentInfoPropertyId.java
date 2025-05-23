/*     */ package dtv.xst.dao.crm;
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
/*     */ 
/*     */ 
/*     */ public class CustomerConsentInfoPropertyId
/*     */   extends AbstractObjectId
/*     */ {
/*     */   private static final long serialVersionUID = 803966207L;
/*     */   private DtvDate _effectiveDate;
/*     */   private String _propertyCode;
/*     */   
/*     */   public CustomerConsentInfoPropertyId() {}
/*     */   
/*     */   public CustomerConsentInfoPropertyId(String argObjectIdValue) {
/*  25 */     setValue(argObjectIdValue);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Date getEffectiveDate() {
/*  32 */     return (Date)this._effectiveDate;
/*     */   }
/*     */   
/*     */   public void setEffectiveDate(Date argEffectiveDate) {
/*  36 */     this._effectiveDate = (argEffectiveDate == null || argEffectiveDate instanceof DtvDate) ? (DtvDate)argEffectiveDate : new DtvDate(argEffectiveDate);
/*     */   }
/*     */ 
/*     */   
/*     */   public String getPropertyCode() {
/*  41 */     return this._propertyCode;
/*     */   }
/*     */   
/*     */   public void setPropertyCode(String argPropertyCode) {
/*  45 */     this._propertyCode = (argPropertyCode != null && MANAGE_CASE) ? argPropertyCode.toUpperCase() : argPropertyCode;
/*     */   }
/*     */   
/*     */   public void setValue(String argObjectIdValue) {
/*  49 */     String str = argObjectIdValue;
/*  50 */     if (StringUtils.isEmpty(str)) {
/*  51 */       throw new DtxException("argument passed to setValue() is null or empty - a valid value must be passed");
/*     */     }
/*     */     try {
/*  54 */       String[] tokens = str.split("::");
/*  55 */       str = tokens[0];
/*     */       
/*  57 */       setOrganizationId(Long.valueOf(str));
/*  58 */       str = tokens[1];
/*     */       
/*  60 */       if ("null".equals(str)) {
/*  61 */         setEffectiveDate((Date)null);
/*     */       } else {
/*     */         
/*  64 */         setEffectiveDate((Date)new DtvDate());
/*  65 */         this._effectiveDate.setTimeFromSerialization(Long.parseLong(str));
/*     */       } 
/*  67 */       str = tokens[2];
/*     */       
/*  69 */       if ("null".equals(str)) {
/*  70 */         setPropertyCode((String)null);
/*     */       } else {
/*     */         
/*  73 */         setPropertyCode(str);
/*     */       }
/*     */     
/*  76 */     } catch (Exception ee) {
/*  77 */       throw new DtxException("An exception occured while parsing object id string: " + argObjectIdValue, ee);
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean equals(Object ob) {
/*  83 */     if (this == ob) {
/*  84 */       return true;
/*     */     }
/*  86 */     if (!(ob instanceof CustomerConsentInfoPropertyId)) {
/*  87 */       return false;
/*     */     }
/*  89 */     CustomerConsentInfoPropertyId other = (CustomerConsentInfoPropertyId)ob;
/*  90 */     return (((this._organizationId == null && other._organizationId == null) || (this._organizationId != null && this._organizationId
/*     */ 
/*     */       
/*  93 */       .equals(other._organizationId))) && ((this._effectiveDate == null && other._effectiveDate == null) || (this._effectiveDate != null && this._effectiveDate
/*     */ 
/*     */       
/*  96 */       .equals(other._effectiveDate))) && ((this._propertyCode == null && other._propertyCode == null) || (this._propertyCode != null && this._propertyCode
/*     */ 
/*     */       
/*  99 */       .equals(other._propertyCode))));
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public int hashCode() {
/* 105 */     return ((this._organizationId == null) ? 0 : this._organizationId
/* 106 */       .hashCode()) + ((this._effectiveDate == null) ? 0 : this._effectiveDate
/* 107 */       .hashCode()) + ((this._propertyCode == null) ? 0 : this._propertyCode
/* 108 */       .hashCode());
/*     */   }
/*     */ 
/*     */   
/*     */   public String getDtxTypeName() {
/* 113 */     return "CustomerConsentInfoProperty";
/*     */   }
/*     */ 
/*     */   
/*     */   public String toString() {
/* 118 */     StringBuilder buff = new StringBuilder(36);
/*     */     
/* 120 */     return buff.append(
/* 121 */         String.valueOf(this._organizationId))
/* 122 */       .append("::").append((this._effectiveDate == null) ? "null" : String.valueOf(this._effectiveDate.getTimeSerializable()))
/* 123 */       .append("::").append(this._propertyCode)
/* 124 */       .toString();
/*     */   }
/*     */   
/*     */   public boolean validate() {
/* 128 */     if (this._effectiveDate == null) {
/* 129 */       return false;
/*     */     }
/* 131 */     if (this._propertyCode == null) {
/* 132 */       return false;
/*     */     }
/* 134 */     return true;
/*     */   }
/*     */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\crm\CustomerConsentInfoPropertyId.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */