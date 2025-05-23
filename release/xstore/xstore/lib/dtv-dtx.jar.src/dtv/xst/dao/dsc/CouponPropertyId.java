/*     */ package dtv.xst.dao.dsc;
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
/*     */ public class CouponPropertyId
/*     */   extends AbstractObjectId
/*     */ {
/*     */   private static final long serialVersionUID = -1711120325L;
/*     */   private String _couponSerialNumber;
/*     */   private String _propertyCode;
/*     */   
/*     */   public CouponPropertyId() {}
/*     */   
/*     */   public CouponPropertyId(String argObjectIdValue) {
/*  23 */     setValue(argObjectIdValue);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getCouponSerialNumber() {
/*  30 */     return this._couponSerialNumber;
/*     */   }
/*     */   
/*     */   public void setCouponSerialNumber(String argCouponSerialNumber) {
/*  34 */     this._couponSerialNumber = (argCouponSerialNumber != null && MANAGE_CASE) ? argCouponSerialNumber.toUpperCase() : argCouponSerialNumber;
/*     */   }
/*     */   
/*     */   public String getPropertyCode() {
/*  38 */     return this._propertyCode;
/*     */   }
/*     */   
/*     */   public void setPropertyCode(String argPropertyCode) {
/*  42 */     this._propertyCode = (argPropertyCode != null && MANAGE_CASE) ? argPropertyCode.toUpperCase() : argPropertyCode;
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
/*  54 */       if ("null".equals(str)) {
/*  55 */         setCouponSerialNumber((String)null);
/*     */       } else {
/*     */         
/*  58 */         setCouponSerialNumber(str);
/*     */       } 
/*  60 */       str = tokens[1];
/*     */       
/*  62 */       setOrganizationId(Long.valueOf(str));
/*  63 */       str = tokens[2];
/*     */       
/*  65 */       if ("null".equals(str)) {
/*  66 */         setPropertyCode((String)null);
/*     */       } else {
/*     */         
/*  69 */         setPropertyCode(str);
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
/*  82 */     if (!(ob instanceof CouponPropertyId)) {
/*  83 */       return false;
/*     */     }
/*  85 */     CouponPropertyId other = (CouponPropertyId)ob;
/*  86 */     return (((this._couponSerialNumber == null && other._couponSerialNumber == null) || (this._couponSerialNumber != null && this._couponSerialNumber
/*     */ 
/*     */       
/*  89 */       .equals(other._couponSerialNumber))) && ((this._organizationId == null && other._organizationId == null) || (this._organizationId != null && this._organizationId
/*     */ 
/*     */       
/*  92 */       .equals(other._organizationId))) && ((this._propertyCode == null && other._propertyCode == null) || (this._propertyCode != null && this._propertyCode
/*     */ 
/*     */       
/*  95 */       .equals(other._propertyCode))));
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public int hashCode() {
/* 101 */     return ((this._couponSerialNumber == null) ? 0 : this._couponSerialNumber
/* 102 */       .hashCode()) + ((this._organizationId == null) ? 0 : this._organizationId
/* 103 */       .hashCode()) + ((this._propertyCode == null) ? 0 : this._propertyCode
/* 104 */       .hashCode());
/*     */   }
/*     */ 
/*     */   
/*     */   public String getDtxTypeName() {
/* 109 */     return "CouponProperty";
/*     */   }
/*     */ 
/*     */   
/*     */   public String toString() {
/* 114 */     StringBuilder buff = new StringBuilder(36);
/*     */     
/* 116 */     return buff.append(this._couponSerialNumber)
/*     */       
/* 118 */       .append("::").append(String.valueOf(this._organizationId))
/* 119 */       .append("::").append(this._propertyCode)
/* 120 */       .toString();
/*     */   }
/*     */   
/*     */   public boolean validate() {
/* 124 */     if (this._couponSerialNumber == null) {
/* 125 */       return false;
/*     */     }
/* 127 */     if (this._propertyCode == null) {
/* 128 */       return false;
/*     */     }
/* 130 */     return true;
/*     */   }
/*     */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\dsc\CouponPropertyId.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */