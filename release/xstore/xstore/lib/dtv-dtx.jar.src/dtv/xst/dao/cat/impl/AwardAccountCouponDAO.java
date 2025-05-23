/*     */ package dtv.xst.dao.cat.impl;
/*     */ 
/*     */ import dtv.data2.access.DaoUtils;
/*     */ import dtv.data2.access.IObjectId;
/*     */ import dtv.data2.access.exception.DtxException;
/*     */ import dtv.data2.access.impl.AbstractDAOImpl;
/*     */ import dtv.util.DtvDate;
/*     */ import dtv.xst.dao.cat.AwardAccountCouponId;
/*     */ import java.math.BigDecimal;
/*     */ import java.util.Date;
/*     */ import java.util.Map;
/*     */ import org.apache.log4j.Logger;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class AwardAccountCouponDAO
/*     */   extends AbstractDAOImpl
/*     */ {
/*     */   private static final long serialVersionUID = -18798218L;
/*  23 */   private static final Logger _logger = Logger.getLogger(AwardAccountCouponDAO.class);
/*     */   
/*     */   private Long _organizationId;
/*     */   private String _cardNumber;
/*     */   private String _accountId;
/*     */   private String _couponId;
/*     */   private DtvDate _createDate;
/*     */   private String _createUserId;
/*     */   private DtvDate _updateDate;
/*     */   private String _updateUserId;
/*     */   private BigDecimal _amount;
/*     */   private DtvDate _expirationDate;
/*     */   
/*     */   public Long getOrganizationId() {
/*  37 */     return this._organizationId;
/*     */   }
/*     */   
/*     */   public void setOrganizationId(Long argOrganizationId) {
/*  41 */     if (changed(argOrganizationId, this._organizationId, "organizationId")) {
/*  42 */       this._organizationId = argOrganizationId;
/*     */     }
/*     */   }
/*     */   
/*     */   public String getCardNumber() {
/*  47 */     return this._cardNumber;
/*     */   }
/*     */   
/*     */   public void setCardNumber(String argCardNumber) {
/*  51 */     if (changed(argCardNumber, this._cardNumber, "cardNumber")) {
/*  52 */       this._cardNumber = (argCardNumber != null && MANAGE_CASE) ? argCardNumber.toUpperCase() : argCardNumber;
/*     */     }
/*     */   }
/*     */   
/*     */   public String getAccountId() {
/*  57 */     return this._accountId;
/*     */   }
/*     */   
/*     */   public void setAccountId(String argAccountId) {
/*  61 */     if (changed(argAccountId, this._accountId, "accountId")) {
/*  62 */       this._accountId = (argAccountId != null && MANAGE_CASE) ? argAccountId.toUpperCase() : argAccountId;
/*     */     }
/*     */   }
/*     */   
/*     */   public String getCouponId() {
/*  67 */     return this._couponId;
/*     */   }
/*     */   
/*     */   public void setCouponId(String argCouponId) {
/*  71 */     if (changed(argCouponId, this._couponId, "couponId")) {
/*  72 */       this._couponId = (argCouponId != null && MANAGE_CASE) ? argCouponId.toUpperCase() : argCouponId;
/*     */     }
/*     */   }
/*     */   
/*     */   public Date getCreateDate() {
/*  77 */     return (Date)this._createDate;
/*     */   }
/*     */   
/*     */   public void setCreateDate(Date argCreateDate) {
/*  81 */     if (changed(argCreateDate, this._createDate, "createDate")) {
/*  82 */       this._createDate = (argCreateDate == null || argCreateDate instanceof DtvDate) ? (DtvDate)argCreateDate : new DtvDate(argCreateDate);
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public String getCreateUserId() {
/*  88 */     return this._createUserId;
/*     */   }
/*     */   
/*     */   public void setCreateUserId(String argCreateUserId) {
/*  92 */     if (changed(argCreateUserId, this._createUserId, "createUserId")) {
/*  93 */       this._createUserId = argCreateUserId;
/*     */     }
/*     */   }
/*     */   
/*     */   public Date getUpdateDate() {
/*  98 */     return (Date)this._updateDate;
/*     */   }
/*     */   
/*     */   public void setUpdateDate(Date argUpdateDate) {
/* 102 */     if (changed(argUpdateDate, this._updateDate, "updateDate")) {
/* 103 */       this._updateDate = (argUpdateDate == null || argUpdateDate instanceof DtvDate) ? (DtvDate)argUpdateDate : new DtvDate(argUpdateDate);
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public String getUpdateUserId() {
/* 109 */     return this._updateUserId;
/*     */   }
/*     */   
/*     */   public void setUpdateUserId(String argUpdateUserId) {
/* 113 */     if (changed(argUpdateUserId, this._updateUserId, "updateUserId")) {
/* 114 */       this._updateUserId = argUpdateUserId;
/*     */     }
/*     */   }
/*     */   
/*     */   public BigDecimal getAmount() {
/* 119 */     return this._amount;
/*     */   }
/*     */   
/*     */   public void setAmount(BigDecimal argAmount) {
/* 123 */     if (changed(argAmount, this._amount, "amount")) {
/* 124 */       this._amount = argAmount;
/*     */     }
/*     */   }
/*     */   
/*     */   public Date getExpirationDate() {
/* 129 */     return (Date)this._expirationDate;
/*     */   }
/*     */   
/*     */   public void setExpirationDate(Date argExpirationDate) {
/* 133 */     if (changed(argExpirationDate, this._expirationDate, "expirationDate")) {
/* 134 */       this._expirationDate = (argExpirationDate == null || argExpirationDate instanceof DtvDate) ? (DtvDate)argExpirationDate : new DtvDate(argExpirationDate);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String toString() {
/* 142 */     StringBuilder buf = new StringBuilder(512);
/* 143 */     buf.append(super.toString()).append(" Id: ").append(getObjectId()).append(" Values: ");
/* 144 */     if (getOrganizationId() != null) {
/* 145 */       buf.append("organizationId").append("=").append(getOrganizationId()).append(" ");
/*     */     }
/* 147 */     if (getCardNumber() != null) {
/* 148 */       buf.append("cardNumber").append("=").append(getCardNumber()).append(" ");
/*     */     }
/* 150 */     if (getAccountId() != null) {
/* 151 */       buf.append("accountId").append("=").append(getAccountId()).append(" ");
/*     */     }
/* 153 */     if (getCouponId() != null) {
/* 154 */       buf.append("couponId").append("=").append(getCouponId()).append(" ");
/*     */     }
/* 156 */     if (getCreateDate() != null) {
/* 157 */       buf.append("createDate").append("=").append(getCreateDate()).append(" ");
/*     */     }
/* 159 */     if (getCreateUserId() != null) {
/* 160 */       buf.append("createUserId").append("=").append(getCreateUserId()).append(" ");
/*     */     }
/* 162 */     if (getUpdateDate() != null) {
/* 163 */       buf.append("updateDate").append("=").append(getUpdateDate()).append(" ");
/*     */     }
/* 165 */     if (getUpdateUserId() != null) {
/* 166 */       buf.append("updateUserId").append("=").append(getUpdateUserId()).append(" ");
/*     */     }
/* 168 */     if (getAmount() != null) {
/* 169 */       buf.append("amount").append("=").append(getAmount()).append(" ");
/*     */     }
/* 171 */     if (getExpirationDate() != null) {
/* 172 */       buf.append("expirationDate").append("=").append(getExpirationDate()).append(" ");
/*     */     }
/*     */     
/* 175 */     return buf.toString();
/*     */   }
/*     */   
/*     */   public IObjectId getObjectId() {
/* 179 */     AwardAccountCouponId id = new AwardAccountCouponId();
/* 180 */     id.setOrganizationId(getOrganizationId());
/* 181 */     id.setCardNumber(getCardNumber());
/* 182 */     id.setAccountId(getAccountId());
/* 183 */     id.setCouponId(getCouponId());
/* 184 */     return (IObjectId)id;
/*     */   }
/*     */   
/*     */   public void setObjectId(IObjectId argObjectId) {
/* 188 */     setOrganizationId(((AwardAccountCouponId)argObjectId).getOrganizationId());
/* 189 */     setCardNumber(((AwardAccountCouponId)argObjectId).getCardNumber());
/* 190 */     setAccountId(((AwardAccountCouponId)argObjectId).getAccountId());
/* 191 */     setCouponId(((AwardAccountCouponId)argObjectId).getCouponId());
/*     */   }
/*     */   
/*     */   public String getImplementingClass() {
/* 195 */     return null;
/*     */   }
/*     */   
/*     */   public String toXmlString() {
/* 199 */     StringBuilder buf = new StringBuilder(500);
/* 200 */     buf.append("<").append("dao").append(" name=\"AwardAccountCoupon\" cmd=\"" + getObjectStateString() + "\">");
/* 201 */     getFieldsAsXml(buf);
/* 202 */     buf.append("</").append("dao").append(">");
/*     */     
/* 204 */     return buf.toString();
/*     */   }
/*     */   
/*     */   public Map<String, String> getValues() {
/* 208 */     Map<String, String> values = super.getValues();
/* 209 */     if (this._organizationId != null) values.put("OrganizationId", DaoUtils.getXmlSafeFieldValue(-5, this._organizationId)); 
/* 210 */     if (this._cardNumber != null) values.put("CardNumber", DaoUtils.getXmlSafeFieldValue(12, this._cardNumber)); 
/* 211 */     if (this._accountId != null) values.put("AccountId", DaoUtils.getXmlSafeFieldValue(12, this._accountId)); 
/* 212 */     if (this._couponId != null) values.put("CouponId", DaoUtils.getXmlSafeFieldValue(12, this._couponId)); 
/* 213 */     if (this._createDate != null) values.put("CreateDate", DaoUtils.getXmlSafeFieldValue(91, this._createDate)); 
/* 214 */     if (this._createUserId != null) values.put("CreateUserId", DaoUtils.getXmlSafeFieldValue(12, this._createUserId)); 
/* 215 */     if (this._updateDate != null) values.put("UpdateDate", DaoUtils.getXmlSafeFieldValue(91, this._updateDate)); 
/* 216 */     if (this._updateUserId != null) values.put("UpdateUserId", DaoUtils.getXmlSafeFieldValue(12, this._updateUserId)); 
/* 217 */     if (this._amount != null) values.put("Amount", DaoUtils.getXmlSafeFieldValue(3, this._amount)); 
/* 218 */     if (this._expirationDate != null) values.put("ExpirationDate", DaoUtils.getXmlSafeFieldValue(91, this._expirationDate)); 
/* 219 */     return values;
/*     */   }
/*     */ 
/*     */   
/*     */   public void setValues(Map<String, String> argValues) {
/* 224 */     super.setValues(argValues);
/* 225 */     for (Map.Entry<String, String> field : argValues.entrySet()) {
/*     */       
/* 227 */       String fieldName = field.getKey();
/* 228 */       String fieldValue = field.getValue();
/* 229 */       switch (fieldName) {
/*     */         
/*     */         case "OrganizationId":
/*     */           try {
/* 233 */             Object value = DaoUtils.getFieldValueForXmlString(-5, fieldValue);
/* 234 */             setOrganizationId((Long)value);
/* 235 */           } catch (Exception ee) {
/* 236 */             throw new DtxException("An exception occurred while calling setOrganizationId() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "CardNumber":
/*     */           try {
/* 242 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 243 */             setCardNumber((String)value);
/* 244 */           } catch (Exception ee) {
/* 245 */             throw new DtxException("An exception occurred while calling setCardNumber() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "AccountId":
/*     */           try {
/* 251 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 252 */             setAccountId((String)value);
/* 253 */           } catch (Exception ee) {
/* 254 */             throw new DtxException("An exception occurred while calling setAccountId() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "CouponId":
/*     */           try {
/* 260 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 261 */             setCouponId((String)value);
/* 262 */           } catch (Exception ee) {
/* 263 */             throw new DtxException("An exception occurred while calling setCouponId() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "CreateDate":
/*     */           try {
/* 269 */             Object value = DaoUtils.getFieldValueForXmlString(91, fieldValue);
/* 270 */             setCreateDate((Date)value);
/* 271 */           } catch (Exception ee) {
/* 272 */             throw new DtxException("An exception occurred while calling setCreateDate() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "CreateUserId":
/*     */           try {
/* 278 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 279 */             setCreateUserId((String)value);
/* 280 */           } catch (Exception ee) {
/* 281 */             throw new DtxException("An exception occurred while calling setCreateUserId() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "UpdateDate":
/*     */           try {
/* 287 */             Object value = DaoUtils.getFieldValueForXmlString(91, fieldValue);
/* 288 */             setUpdateDate((Date)value);
/* 289 */           } catch (Exception ee) {
/* 290 */             throw new DtxException("An exception occurred while calling setUpdateDate() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "UpdateUserId":
/*     */           try {
/* 296 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 297 */             setUpdateUserId((String)value);
/* 298 */           } catch (Exception ee) {
/* 299 */             throw new DtxException("An exception occurred while calling setUpdateUserId() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "Amount":
/*     */           try {
/* 305 */             Object value = DaoUtils.getFieldValueForXmlString(3, fieldValue);
/* 306 */             setAmount((BigDecimal)value);
/* 307 */           } catch (Exception ee) {
/* 308 */             throw new DtxException("An exception occurred while calling setAmount() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "ExpirationDate":
/*     */           try {
/* 314 */             Object value = DaoUtils.getFieldValueForXmlString(91, fieldValue);
/* 315 */             setExpirationDate((Date)value);
/* 316 */           } catch (Exception ee) {
/* 317 */             throw new DtxException("An exception occurred while calling setExpirationDate() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */       } 
/*     */     } 
/*     */   }
/*     */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\cat\impl\AwardAccountCouponDAO.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */