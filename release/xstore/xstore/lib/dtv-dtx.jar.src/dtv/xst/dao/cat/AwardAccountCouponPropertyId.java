/*     */ package dtv.xst.dao.cat;
/*     */ 
/*     */ import dtv.data2.access.AbstractObjectId;
/*     */ import dtv.data2.access.exception.DtxException;
/*     */ import dtv.util.StringUtils;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class AwardAccountCouponPropertyId
/*     */   extends AbstractObjectId
/*     */ {
/*     */   private static final long serialVersionUID = -1545890453L;
/*     */   private String _cardNumber;
/*     */   private String _accountId;
/*     */   private String _couponId;
/*     */   private String _propertyCode;
/*     */   
/*     */   public AwardAccountCouponPropertyId() {}
/*     */   
/*     */   public AwardAccountCouponPropertyId(String argObjectIdValue) {
/*  23 */     setValue(argObjectIdValue);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getCardNumber() {
/*  32 */     return this._cardNumber;
/*     */   }
/*     */   
/*     */   public void setCardNumber(String argCardNumber) {
/*  36 */     this._cardNumber = (argCardNumber != null && MANAGE_CASE) ? argCardNumber.toUpperCase() : argCardNumber;
/*     */   }
/*     */   
/*     */   public String getAccountId() {
/*  40 */     return this._accountId;
/*     */   }
/*     */   
/*     */   public void setAccountId(String argAccountId) {
/*  44 */     this._accountId = (argAccountId != null && MANAGE_CASE) ? argAccountId.toUpperCase() : argAccountId;
/*     */   }
/*     */   
/*     */   public String getCouponId() {
/*  48 */     return this._couponId;
/*     */   }
/*     */   
/*     */   public void setCouponId(String argCouponId) {
/*  52 */     this._couponId = (argCouponId != null && MANAGE_CASE) ? argCouponId.toUpperCase() : argCouponId;
/*     */   }
/*     */   
/*     */   public String getPropertyCode() {
/*  56 */     return this._propertyCode;
/*     */   }
/*     */   
/*     */   public void setPropertyCode(String argPropertyCode) {
/*  60 */     this._propertyCode = (argPropertyCode != null && MANAGE_CASE) ? argPropertyCode.toUpperCase() : argPropertyCode;
/*     */   }
/*     */   
/*     */   public void setValue(String argObjectIdValue) {
/*  64 */     String str = argObjectIdValue;
/*  65 */     if (StringUtils.isEmpty(str)) {
/*  66 */       throw new DtxException("argument passed to setValue() is null or empty - a valid value must be passed");
/*     */     }
/*     */     try {
/*  69 */       String[] tokens = str.split("::");
/*  70 */       str = tokens[0];
/*     */       
/*  72 */       setOrganizationId(Long.valueOf(str));
/*  73 */       str = tokens[1];
/*     */       
/*  75 */       if ("null".equals(str)) {
/*  76 */         setCardNumber((String)null);
/*     */       } else {
/*     */         
/*  79 */         setCardNumber(str);
/*     */       } 
/*  81 */       str = tokens[2];
/*     */       
/*  83 */       if ("null".equals(str)) {
/*  84 */         setAccountId((String)null);
/*     */       } else {
/*     */         
/*  87 */         setAccountId(str);
/*     */       } 
/*  89 */       str = tokens[3];
/*     */       
/*  91 */       if ("null".equals(str)) {
/*  92 */         setCouponId((String)null);
/*     */       } else {
/*     */         
/*  95 */         setCouponId(str);
/*     */       } 
/*  97 */       str = tokens[4];
/*     */       
/*  99 */       if ("null".equals(str)) {
/* 100 */         setPropertyCode((String)null);
/*     */       } else {
/*     */         
/* 103 */         setPropertyCode(str);
/*     */       }
/*     */     
/* 106 */     } catch (Exception ee) {
/* 107 */       throw new DtxException("An exception occured while parsing object id string: " + argObjectIdValue, ee);
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean equals(Object ob) {
/* 113 */     if (this == ob) {
/* 114 */       return true;
/*     */     }
/* 116 */     if (!(ob instanceof AwardAccountCouponPropertyId)) {
/* 117 */       return false;
/*     */     }
/* 119 */     AwardAccountCouponPropertyId other = (AwardAccountCouponPropertyId)ob;
/* 120 */     return (((this._organizationId == null && other._organizationId == null) || (this._organizationId != null && this._organizationId
/*     */ 
/*     */       
/* 123 */       .equals(other._organizationId))) && ((this._cardNumber == null && other._cardNumber == null) || (this._cardNumber != null && this._cardNumber
/*     */ 
/*     */       
/* 126 */       .equals(other._cardNumber))) && ((this._accountId == null && other._accountId == null) || (this._accountId != null && this._accountId
/*     */ 
/*     */       
/* 129 */       .equals(other._accountId))) && ((this._couponId == null && other._couponId == null) || (this._couponId != null && this._couponId
/*     */ 
/*     */       
/* 132 */       .equals(other._couponId))) && ((this._propertyCode == null && other._propertyCode == null) || (this._propertyCode != null && this._propertyCode
/*     */ 
/*     */       
/* 135 */       .equals(other._propertyCode))));
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public int hashCode() {
/* 141 */     return ((this._organizationId == null) ? 0 : this._organizationId
/* 142 */       .hashCode()) + ((this._cardNumber == null) ? 0 : this._cardNumber
/* 143 */       .hashCode()) + ((this._accountId == null) ? 0 : this._accountId
/* 144 */       .hashCode()) + ((this._couponId == null) ? 0 : this._couponId
/* 145 */       .hashCode()) + ((this._propertyCode == null) ? 0 : this._propertyCode
/* 146 */       .hashCode());
/*     */   }
/*     */ 
/*     */   
/*     */   public String getDtxTypeName() {
/* 151 */     return "AwardAccountCouponProperty";
/*     */   }
/*     */ 
/*     */   
/*     */   public String toString() {
/* 156 */     StringBuilder buff = new StringBuilder(60);
/*     */     
/* 158 */     return buff.append(
/* 159 */         String.valueOf(this._organizationId))
/* 160 */       .append("::").append(this._cardNumber)
/* 161 */       .append("::").append(this._accountId)
/* 162 */       .append("::").append(this._couponId)
/* 163 */       .append("::").append(this._propertyCode)
/* 164 */       .toString();
/*     */   }
/*     */   
/*     */   public boolean validate() {
/* 168 */     if (this._cardNumber == null) {
/* 169 */       return false;
/*     */     }
/* 171 */     if (this._accountId == null) {
/* 172 */       return false;
/*     */     }
/* 174 */     if (this._couponId == null) {
/* 175 */       return false;
/*     */     }
/* 177 */     if (this._propertyCode == null) {
/* 178 */       return false;
/*     */     }
/* 180 */     return true;
/*     */   }
/*     */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\cat\AwardAccountCouponPropertyId.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */