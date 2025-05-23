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
/*     */ 
/*     */ public class AwardAccountCouponId
/*     */   extends AbstractObjectId
/*     */ {
/*     */   private static final long serialVersionUID = -18798218L;
/*     */   private String _cardNumber;
/*     */   private String _accountId;
/*     */   private String _couponId;
/*     */   
/*     */   public AwardAccountCouponId() {}
/*     */   
/*     */   public AwardAccountCouponId(String argObjectIdValue) {
/*  23 */     setValue(argObjectIdValue);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getCardNumber() {
/*  31 */     return this._cardNumber;
/*     */   }
/*     */   
/*     */   public void setCardNumber(String argCardNumber) {
/*  35 */     this._cardNumber = (argCardNumber != null && MANAGE_CASE) ? argCardNumber.toUpperCase() : argCardNumber;
/*     */   }
/*     */   
/*     */   public String getAccountId() {
/*  39 */     return this._accountId;
/*     */   }
/*     */   
/*     */   public void setAccountId(String argAccountId) {
/*  43 */     this._accountId = (argAccountId != null && MANAGE_CASE) ? argAccountId.toUpperCase() : argAccountId;
/*     */   }
/*     */   
/*     */   public String getCouponId() {
/*  47 */     return this._couponId;
/*     */   }
/*     */   
/*     */   public void setCouponId(String argCouponId) {
/*  51 */     this._couponId = (argCouponId != null && MANAGE_CASE) ? argCouponId.toUpperCase() : argCouponId;
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
/*  67 */         setCardNumber((String)null);
/*     */       } else {
/*     */         
/*  70 */         setCardNumber(str);
/*     */       } 
/*  72 */       str = tokens[2];
/*     */       
/*  74 */       if ("null".equals(str)) {
/*  75 */         setAccountId((String)null);
/*     */       } else {
/*     */         
/*  78 */         setAccountId(str);
/*     */       } 
/*  80 */       str = tokens[3];
/*     */       
/*  82 */       if ("null".equals(str)) {
/*  83 */         setCouponId((String)null);
/*     */       } else {
/*     */         
/*  86 */         setCouponId(str);
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
/*  99 */     if (!(ob instanceof AwardAccountCouponId)) {
/* 100 */       return false;
/*     */     }
/* 102 */     AwardAccountCouponId other = (AwardAccountCouponId)ob;
/* 103 */     return (((this._organizationId == null && other._organizationId == null) || (this._organizationId != null && this._organizationId
/*     */ 
/*     */       
/* 106 */       .equals(other._organizationId))) && ((this._cardNumber == null && other._cardNumber == null) || (this._cardNumber != null && this._cardNumber
/*     */ 
/*     */       
/* 109 */       .equals(other._cardNumber))) && ((this._accountId == null && other._accountId == null) || (this._accountId != null && this._accountId
/*     */ 
/*     */       
/* 112 */       .equals(other._accountId))) && ((this._couponId == null && other._couponId == null) || (this._couponId != null && this._couponId
/*     */ 
/*     */       
/* 115 */       .equals(other._couponId))));
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public int hashCode() {
/* 121 */     return ((this._organizationId == null) ? 0 : this._organizationId
/* 122 */       .hashCode()) + ((this._cardNumber == null) ? 0 : this._cardNumber
/* 123 */       .hashCode()) + ((this._accountId == null) ? 0 : this._accountId
/* 124 */       .hashCode()) + ((this._couponId == null) ? 0 : this._couponId
/* 125 */       .hashCode());
/*     */   }
/*     */ 
/*     */   
/*     */   public String getDtxTypeName() {
/* 130 */     return "AwardAccountCoupon";
/*     */   }
/*     */ 
/*     */   
/*     */   public String toString() {
/* 135 */     StringBuilder buff = new StringBuilder(48);
/*     */     
/* 137 */     return buff.append(
/* 138 */         String.valueOf(this._organizationId))
/* 139 */       .append("::").append(this._cardNumber)
/* 140 */       .append("::").append(this._accountId)
/* 141 */       .append("::").append(this._couponId)
/* 142 */       .toString();
/*     */   }
/*     */   
/*     */   public boolean validate() {
/* 146 */     if (this._cardNumber == null) {
/* 147 */       return false;
/*     */     }
/* 149 */     if (this._accountId == null) {
/* 150 */       return false;
/*     */     }
/* 152 */     if (this._couponId == null) {
/* 153 */       return false;
/*     */     }
/* 155 */     return true;
/*     */   }
/*     */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\cat\AwardAccountCouponId.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */