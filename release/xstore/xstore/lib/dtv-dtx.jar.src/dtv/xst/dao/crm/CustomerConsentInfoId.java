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
/*     */ 
/*     */ public class CustomerConsentInfoId
/*     */   extends AbstractObjectId
/*     */ {
/*     */   private static final long serialVersionUID = -1453591286L;
/*     */   private DtvDate _effectiveDate;
/*     */   
/*     */   public CustomerConsentInfoId() {}
/*     */   
/*     */   public CustomerConsentInfoId(String argObjectIdValue) {
/*  25 */     setValue(argObjectIdValue);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public Date getEffectiveDate() {
/*  31 */     return (Date)this._effectiveDate;
/*     */   }
/*     */   
/*     */   public void setEffectiveDate(Date argEffectiveDate) {
/*  35 */     this._effectiveDate = (argEffectiveDate == null || argEffectiveDate instanceof DtvDate) ? (DtvDate)argEffectiveDate : new DtvDate(argEffectiveDate);
/*     */   }
/*     */ 
/*     */   
/*     */   public void setValue(String argObjectIdValue) {
/*  40 */     String str = argObjectIdValue;
/*  41 */     if (StringUtils.isEmpty(str)) {
/*  42 */       throw new DtxException("argument passed to setValue() is null or empty - a valid value must be passed");
/*     */     }
/*     */     try {
/*  45 */       String[] tokens = str.split("::");
/*  46 */       str = tokens[0];
/*     */       
/*  48 */       setOrganizationId(Long.valueOf(str));
/*  49 */       str = tokens[1];
/*     */       
/*  51 */       if ("null".equals(str)) {
/*  52 */         setEffectiveDate((Date)null);
/*     */       } else {
/*     */         
/*  55 */         setEffectiveDate((Date)new DtvDate());
/*  56 */         this._effectiveDate.setTimeFromSerialization(Long.parseLong(str));
/*     */       }
/*     */     
/*  59 */     } catch (Exception ee) {
/*  60 */       throw new DtxException("An exception occured while parsing object id string: " + argObjectIdValue, ee);
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean equals(Object ob) {
/*  66 */     if (this == ob) {
/*  67 */       return true;
/*     */     }
/*  69 */     if (!(ob instanceof CustomerConsentInfoId)) {
/*  70 */       return false;
/*     */     }
/*  72 */     CustomerConsentInfoId other = (CustomerConsentInfoId)ob;
/*  73 */     return (((this._organizationId == null && other._organizationId == null) || (this._organizationId != null && this._organizationId
/*     */ 
/*     */       
/*  76 */       .equals(other._organizationId))) && ((this._effectiveDate == null && other._effectiveDate == null) || (this._effectiveDate != null && this._effectiveDate
/*     */ 
/*     */       
/*  79 */       .equals(other._effectiveDate))));
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public int hashCode() {
/*  85 */     return ((this._organizationId == null) ? 0 : this._organizationId
/*  86 */       .hashCode()) + ((this._effectiveDate == null) ? 0 : this._effectiveDate
/*  87 */       .hashCode());
/*     */   }
/*     */ 
/*     */   
/*     */   public String getDtxTypeName() {
/*  92 */     return "CustomerConsentInfo";
/*     */   }
/*     */ 
/*     */   
/*     */   public String toString() {
/*  97 */     StringBuilder buff = new StringBuilder(24);
/*     */     
/*  99 */     return buff.append(
/* 100 */         String.valueOf(this._organizationId))
/* 101 */       .append("::").append((this._effectiveDate == null) ? "null" : String.valueOf(this._effectiveDate.getTimeSerializable()))
/* 102 */       .toString();
/*     */   }
/*     */   
/*     */   public boolean validate() {
/* 106 */     if (this._effectiveDate == null) {
/* 107 */       return false;
/*     */     }
/* 109 */     return true;
/*     */   }
/*     */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\crm\CustomerConsentInfoId.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */