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
/*     */ 
/*     */ public class VoucherId
/*     */   extends AbstractObjectId
/*     */ {
/*     */   private static final long serialVersionUID = -1990121842L;
/*     */   private String _serialNumber;
/*     */   private String _voucherTypeCode;
/*     */   
/*     */   public VoucherId() {}
/*     */   
/*     */   public VoucherId(String argObjectIdValue) {
/*  23 */     setValue(argObjectIdValue);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getSerialNumber() {
/*  30 */     return this._serialNumber;
/*     */   }
/*     */   
/*     */   public void setSerialNumber(String argSerialNumber) {
/*  34 */     this._serialNumber = (argSerialNumber != null && MANAGE_CASE) ? argSerialNumber.toUpperCase() : argSerialNumber;
/*     */   }
/*     */   
/*     */   public String getVoucherTypeCode() {
/*  38 */     return this._voucherTypeCode;
/*     */   }
/*     */   
/*     */   public void setVoucherTypeCode(String argVoucherTypeCode) {
/*  42 */     this._voucherTypeCode = (argVoucherTypeCode != null && MANAGE_CASE) ? argVoucherTypeCode.toUpperCase() : argVoucherTypeCode;
/*     */   }
/*     */   
/*     */   public void setValue(String argObjectIdValue) {
/*  46 */     String str = argObjectIdValue;
/*  47 */     if (StringUtils.isEmpty(str)) {
/*  48 */       throw new DtxException("argument passed to setValue() is null or empty - a valid value must be passed");
/*     */     }
/*     */     try {
/*  51 */       String[] tokens = str.split("::");
/*  52 */       str = tokens[0];
/*     */       
/*  54 */       setOrganizationId(Long.valueOf(str));
/*  55 */       str = tokens[1];
/*     */       
/*  57 */       if ("null".equals(str)) {
/*  58 */         setSerialNumber((String)null);
/*     */       } else {
/*     */         
/*  61 */         setSerialNumber(str);
/*     */       } 
/*  63 */       str = tokens[2];
/*     */       
/*  65 */       if ("null".equals(str)) {
/*  66 */         setVoucherTypeCode((String)null);
/*     */       } else {
/*     */         
/*  69 */         setVoucherTypeCode(str);
/*     */       }
/*     */     
/*  72 */     } catch (Exception ee) {
/*  73 */       throw new DtxException("An exception occured while parsing object id string: " + argObjectIdValue, ee);
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean equals(Object ob) {
/*  79 */     if (this == ob) {
/*  80 */       return true;
/*     */     }
/*  82 */     if (!(ob instanceof VoucherId)) {
/*  83 */       return false;
/*     */     }
/*  85 */     VoucherId other = (VoucherId)ob;
/*  86 */     return (((this._organizationId == null && other._organizationId == null) || (this._organizationId != null && this._organizationId
/*     */ 
/*     */       
/*  89 */       .equals(other._organizationId))) && ((this._serialNumber == null && other._serialNumber == null) || (this._serialNumber != null && this._serialNumber
/*     */ 
/*     */       
/*  92 */       .equals(other._serialNumber))) && ((this._voucherTypeCode == null && other._voucherTypeCode == null) || (this._voucherTypeCode != null && this._voucherTypeCode
/*     */ 
/*     */       
/*  95 */       .equals(other._voucherTypeCode))));
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public int hashCode() {
/* 101 */     return ((this._organizationId == null) ? 0 : this._organizationId
/* 102 */       .hashCode()) + ((this._serialNumber == null) ? 0 : this._serialNumber
/* 103 */       .hashCode()) + ((this._voucherTypeCode == null) ? 0 : this._voucherTypeCode
/* 104 */       .hashCode());
/*     */   }
/*     */ 
/*     */   
/*     */   public String getDtxTypeName() {
/* 109 */     return "Voucher";
/*     */   }
/*     */ 
/*     */   
/*     */   public String toString() {
/* 114 */     StringBuilder buff = new StringBuilder(36);
/*     */     
/* 116 */     return buff.append(
/* 117 */         String.valueOf(this._organizationId))
/* 118 */       .append("::").append(this._serialNumber)
/* 119 */       .append("::").append(this._voucherTypeCode)
/* 120 */       .toString();
/*     */   }
/*     */   
/*     */   public boolean validate() {
/* 124 */     if (this._serialNumber == null) {
/* 125 */       return false;
/*     */     }
/* 127 */     if (this._voucherTypeCode == null) {
/* 128 */       return false;
/*     */     }
/* 130 */     return true;
/*     */   }
/*     */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\ttr\VoucherId.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */