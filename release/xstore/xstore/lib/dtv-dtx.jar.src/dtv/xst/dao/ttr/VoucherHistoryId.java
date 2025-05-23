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
/*     */ public class VoucherHistoryId
/*     */   extends AbstractObjectId
/*     */ {
/*     */   private static final long serialVersionUID = -41453018L;
/*     */   private String _serialNumber;
/*     */   private String _voucherTypeCode;
/*     */   private Long _historySequence;
/*     */   
/*     */   public VoucherHistoryId() {}
/*     */   
/*     */   public VoucherHistoryId(String argObjectIdValue) {
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
/*     */   public Long getHistorySequence() {
/*  47 */     return this._historySequence;
/*     */   }
/*     */   
/*     */   public void setHistorySequence(Long argHistorySequence) {
/*  51 */     this._historySequence = argHistorySequence;
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
/*  82 */       setHistorySequence(Long.valueOf(str));
/*     */     }
/*  84 */     catch (Exception ee) {
/*  85 */       throw new DtxException("An exception occured while parsing object id string: " + argObjectIdValue, ee);
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean equals(Object ob) {
/*  91 */     if (this == ob) {
/*  92 */       return true;
/*     */     }
/*  94 */     if (!(ob instanceof VoucherHistoryId)) {
/*  95 */       return false;
/*     */     }
/*  97 */     VoucherHistoryId other = (VoucherHistoryId)ob;
/*  98 */     return (((this._organizationId == null && other._organizationId == null) || (this._organizationId != null && this._organizationId
/*     */ 
/*     */       
/* 101 */       .equals(other._organizationId))) && ((this._serialNumber == null && other._serialNumber == null) || (this._serialNumber != null && this._serialNumber
/*     */ 
/*     */       
/* 104 */       .equals(other._serialNumber))) && ((this._voucherTypeCode == null && other._voucherTypeCode == null) || (this._voucherTypeCode != null && this._voucherTypeCode
/*     */ 
/*     */       
/* 107 */       .equals(other._voucherTypeCode))) && ((this._historySequence == null && other._historySequence == null) || (this._historySequence != null && this._historySequence
/*     */ 
/*     */       
/* 110 */       .equals(other._historySequence))));
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public int hashCode() {
/* 116 */     return ((this._organizationId == null) ? 0 : this._organizationId
/* 117 */       .hashCode()) + ((this._serialNumber == null) ? 0 : this._serialNumber
/* 118 */       .hashCode()) + ((this._voucherTypeCode == null) ? 0 : this._voucherTypeCode
/* 119 */       .hashCode()) + ((this._historySequence == null) ? 0 : this._historySequence
/* 120 */       .hashCode());
/*     */   }
/*     */ 
/*     */   
/*     */   public String getDtxTypeName() {
/* 125 */     return "VoucherHistory";
/*     */   }
/*     */ 
/*     */   
/*     */   public String toString() {
/* 130 */     StringBuilder buff = new StringBuilder(48);
/*     */     
/* 132 */     return buff.append(
/* 133 */         String.valueOf(this._organizationId))
/* 134 */       .append("::").append(this._serialNumber)
/* 135 */       .append("::").append(this._voucherTypeCode)
/* 136 */       .append("::").append(String.valueOf(this._historySequence))
/* 137 */       .toString();
/*     */   }
/*     */   
/*     */   public boolean validate() {
/* 141 */     if (this._serialNumber == null) {
/* 142 */       return false;
/*     */     }
/* 144 */     if (this._voucherTypeCode == null) {
/* 145 */       return false;
/*     */     }
/* 147 */     if (this._historySequence == null) {
/* 148 */       return false;
/*     */     }
/* 150 */     return true;
/*     */   }
/*     */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\ttr\VoucherHistoryId.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */