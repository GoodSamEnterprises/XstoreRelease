/*     */ package dtv.xst.dao.ttr;
/*     */ 
/*     */ import dtv.data2.access.AbstractObjectId;
/*     */ import dtv.data2.access.exception.DtxException;
/*     */ import dtv.util.StringUtils;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class VoucherPropertyId
/*     */   extends AbstractObjectId
/*     */ {
/*     */   private static final long serialVersionUID = -948372861L;
/*     */   private String _serialNumber;
/*     */   private String _voucherTypeCode;
/*     */   private String _propertyCode;
/*     */   
/*     */   public VoucherPropertyId() {}
/*     */   
/*     */   public VoucherPropertyId(String argObjectIdValue) {
/*  23 */     setValue(argObjectIdValue);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getSerialNumber() {
/*  31 */     return this._serialNumber;
/*     */   }
/*     */   
/*     */   public void setSerialNumber(String argSerialNumber) {
/*  35 */     this._serialNumber = (argSerialNumber != null && MANAGE_CASE) ? argSerialNumber.toUpperCase() : argSerialNumber;
/*     */   }
/*     */   
/*     */   public String getVoucherTypeCode() {
/*  39 */     return this._voucherTypeCode;
/*     */   }
/*     */   
/*     */   public void setVoucherTypeCode(String argVoucherTypeCode) {
/*  43 */     this._voucherTypeCode = (argVoucherTypeCode != null && MANAGE_CASE) ? argVoucherTypeCode.toUpperCase() : argVoucherTypeCode;
/*     */   }
/*     */   
/*     */   public String getPropertyCode() {
/*  47 */     return this._propertyCode;
/*     */   }
/*     */   
/*     */   public void setPropertyCode(String argPropertyCode) {
/*  51 */     this._propertyCode = (argPropertyCode != null && MANAGE_CASE) ? argPropertyCode.toUpperCase() : argPropertyCode;
/*     */   }
/*     */   
/*     */   public void setValue(String argObjectIdValue) {
/*  55 */     String str = argObjectIdValue;
/*  56 */     if (StringUtils.isEmpty(str)) {
/*  57 */       throw new DtxException("argument passed to setValue() is null or empty - a valid value must be passed");
/*     */     }
/*     */     try {
/*  60 */       String[] tokens = str.split("::");
/*  61 */       str = tokens[0];
/*     */       
/*  63 */       setOrganizationId(Long.valueOf(str));
/*  64 */       str = tokens[1];
/*     */       
/*  66 */       if ("null".equals(str)) {
/*  67 */         setSerialNumber((String)null);
/*     */       } else {
/*     */         
/*  70 */         setSerialNumber(str);
/*     */       } 
/*  72 */       str = tokens[2];
/*     */       
/*  74 */       if ("null".equals(str)) {
/*  75 */         setVoucherTypeCode((String)null);
/*     */       } else {
/*     */         
/*  78 */         setVoucherTypeCode(str);
/*     */       } 
/*  80 */       str = tokens[3];
/*     */       
/*  82 */       if ("null".equals(str)) {
/*  83 */         setPropertyCode((String)null);
/*     */       } else {
/*     */         
/*  86 */         setPropertyCode(str);
/*     */       }
/*     */     
/*  89 */     } catch (Exception ee) {
/*  90 */       throw new DtxException("An exception occured while parsing object id string: " + argObjectIdValue, ee);
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean equals(Object ob) {
/*  96 */     if (this == ob) {
/*  97 */       return true;
/*     */     }
/*  99 */     if (!(ob instanceof VoucherPropertyId)) {
/* 100 */       return false;
/*     */     }
/* 102 */     VoucherPropertyId other = (VoucherPropertyId)ob;
/* 103 */     return (((this._organizationId == null && other._organizationId == null) || (this._organizationId != null && this._organizationId
/*     */ 
/*     */       
/* 106 */       .equals(other._organizationId))) && ((this._serialNumber == null && other._serialNumber == null) || (this._serialNumber != null && this._serialNumber
/*     */ 
/*     */       
/* 109 */       .equals(other._serialNumber))) && ((this._voucherTypeCode == null && other._voucherTypeCode == null) || (this._voucherTypeCode != null && this._voucherTypeCode
/*     */ 
/*     */       
/* 112 */       .equals(other._voucherTypeCode))) && ((this._propertyCode == null && other._propertyCode == null) || (this._propertyCode != null && this._propertyCode
/*     */ 
/*     */       
/* 115 */       .equals(other._propertyCode))));
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public int hashCode() {
/* 121 */     return ((this._organizationId == null) ? 0 : this._organizationId
/* 122 */       .hashCode()) + ((this._serialNumber == null) ? 0 : this._serialNumber
/* 123 */       .hashCode()) + ((this._voucherTypeCode == null) ? 0 : this._voucherTypeCode
/* 124 */       .hashCode()) + ((this._propertyCode == null) ? 0 : this._propertyCode
/* 125 */       .hashCode());
/*     */   }
/*     */ 
/*     */   
/*     */   public String getDtxTypeName() {
/* 130 */     return "VoucherProperty";
/*     */   }
/*     */ 
/*     */   
/*     */   public String toString() {
/* 135 */     StringBuilder buff = new StringBuilder(48);
/*     */     
/* 137 */     return buff.append(
/* 138 */         String.valueOf(this._organizationId))
/* 139 */       .append("::").append(this._serialNumber)
/* 140 */       .append("::").append(this._voucherTypeCode)
/* 141 */       .append("::").append(this._propertyCode)
/* 142 */       .toString();
/*     */   }
/*     */   
/*     */   public boolean validate() {
/* 146 */     if (this._serialNumber == null) {
/* 147 */       return false;
/*     */     }
/* 149 */     if (this._voucherTypeCode == null) {
/* 150 */       return false;
/*     */     }
/* 152 */     if (this._propertyCode == null) {
/* 153 */       return false;
/*     */     }
/* 155 */     return true;
/*     */   }
/*     */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\ttr\VoucherPropertyId.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */