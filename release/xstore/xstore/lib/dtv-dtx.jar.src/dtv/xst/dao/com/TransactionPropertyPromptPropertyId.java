/*     */ package dtv.xst.dao.com;
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
/*     */ public class TransactionPropertyPromptPropertyId
/*     */   extends AbstractObjectId
/*     */ {
/*     */   private static final long serialVersionUID = -371413780L;
/*     */   private String _promptPropertyCode;
/*     */   private DtvDate _effectiveDate;
/*     */   private String _propertyCode;
/*     */   
/*     */   public TransactionPropertyPromptPropertyId() {}
/*     */   
/*     */   public TransactionPropertyPromptPropertyId(String argObjectIdValue) {
/*  25 */     setValue(argObjectIdValue);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getPromptPropertyCode() {
/*  33 */     return this._promptPropertyCode;
/*     */   }
/*     */   
/*     */   public void setPromptPropertyCode(String argPromptPropertyCode) {
/*  37 */     this._promptPropertyCode = (argPromptPropertyCode != null && MANAGE_CASE) ? argPromptPropertyCode.toUpperCase() : argPromptPropertyCode;
/*     */   }
/*     */   
/*     */   public Date getEffectiveDate() {
/*  41 */     return (Date)this._effectiveDate;
/*     */   }
/*     */   
/*     */   public void setEffectiveDate(Date argEffectiveDate) {
/*  45 */     this._effectiveDate = (argEffectiveDate == null || argEffectiveDate instanceof DtvDate) ? (DtvDate)argEffectiveDate : new DtvDate(argEffectiveDate);
/*     */   }
/*     */ 
/*     */   
/*     */   public String getPropertyCode() {
/*  50 */     return this._propertyCode;
/*     */   }
/*     */   
/*     */   public void setPropertyCode(String argPropertyCode) {
/*  54 */     this._propertyCode = (argPropertyCode != null && MANAGE_CASE) ? argPropertyCode.toUpperCase() : argPropertyCode;
/*     */   }
/*     */   
/*     */   public void setValue(String argObjectIdValue) {
/*  58 */     String str = argObjectIdValue;
/*  59 */     if (StringUtils.isEmpty(str)) {
/*  60 */       throw new DtxException("argument passed to setValue() is null or empty - a valid value must be passed");
/*     */     }
/*     */     try {
/*  63 */       String[] tokens = str.split("::");
/*  64 */       str = tokens[0];
/*     */       
/*  66 */       setOrganizationId(Long.valueOf(str));
/*  67 */       str = tokens[1];
/*     */       
/*  69 */       if ("null".equals(str)) {
/*  70 */         setPromptPropertyCode((String)null);
/*     */       } else {
/*     */         
/*  73 */         setPromptPropertyCode(str);
/*     */       } 
/*  75 */       str = tokens[2];
/*     */       
/*  77 */       if ("null".equals(str)) {
/*  78 */         setEffectiveDate((Date)null);
/*     */       } else {
/*     */         
/*  81 */         setEffectiveDate((Date)new DtvDate());
/*  82 */         this._effectiveDate.setTimeFromSerialization(Long.parseLong(str));
/*     */       } 
/*  84 */       str = tokens[3];
/*     */       
/*  86 */       if ("null".equals(str)) {
/*  87 */         setPropertyCode((String)null);
/*     */       } else {
/*     */         
/*  90 */         setPropertyCode(str);
/*     */       }
/*     */     
/*  93 */     } catch (Exception ee) {
/*  94 */       throw new DtxException("An exception occured while parsing object id string: " + argObjectIdValue, ee);
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean equals(Object ob) {
/* 100 */     if (this == ob) {
/* 101 */       return true;
/*     */     }
/* 103 */     if (!(ob instanceof TransactionPropertyPromptPropertyId)) {
/* 104 */       return false;
/*     */     }
/* 106 */     TransactionPropertyPromptPropertyId other = (TransactionPropertyPromptPropertyId)ob;
/* 107 */     return (((this._organizationId == null && other._organizationId == null) || (this._organizationId != null && this._organizationId
/*     */ 
/*     */       
/* 110 */       .equals(other._organizationId))) && ((this._promptPropertyCode == null && other._promptPropertyCode == null) || (this._promptPropertyCode != null && this._promptPropertyCode
/*     */ 
/*     */       
/* 113 */       .equals(other._promptPropertyCode))) && ((this._effectiveDate == null && other._effectiveDate == null) || (this._effectiveDate != null && this._effectiveDate
/*     */ 
/*     */       
/* 116 */       .equals(other._effectiveDate))) && ((this._propertyCode == null && other._propertyCode == null) || (this._propertyCode != null && this._propertyCode
/*     */ 
/*     */       
/* 119 */       .equals(other._propertyCode))));
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public int hashCode() {
/* 125 */     return ((this._organizationId == null) ? 0 : this._organizationId
/* 126 */       .hashCode()) + ((this._promptPropertyCode == null) ? 0 : this._promptPropertyCode
/* 127 */       .hashCode()) + ((this._effectiveDate == null) ? 0 : this._effectiveDate
/* 128 */       .hashCode()) + ((this._propertyCode == null) ? 0 : this._propertyCode
/* 129 */       .hashCode());
/*     */   }
/*     */ 
/*     */   
/*     */   public String getDtxTypeName() {
/* 134 */     return "TransactionPropertyPromptProperty";
/*     */   }
/*     */ 
/*     */   
/*     */   public String toString() {
/* 139 */     StringBuilder buff = new StringBuilder(48);
/*     */     
/* 141 */     return buff.append(
/* 142 */         String.valueOf(this._organizationId))
/* 143 */       .append("::").append(this._promptPropertyCode)
/* 144 */       .append("::").append((this._effectiveDate == null) ? "null" : String.valueOf(this._effectiveDate.getTimeSerializable()))
/* 145 */       .append("::").append(this._propertyCode)
/* 146 */       .toString();
/*     */   }
/*     */   
/*     */   public boolean validate() {
/* 150 */     if (this._promptPropertyCode == null) {
/* 151 */       return false;
/*     */     }
/* 153 */     if (this._effectiveDate == null) {
/* 154 */       return false;
/*     */     }
/* 156 */     if (this._propertyCode == null) {
/* 157 */       return false;
/*     */     }
/* 159 */     return true;
/*     */   }
/*     */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\com\TransactionPropertyPromptPropertyId.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */