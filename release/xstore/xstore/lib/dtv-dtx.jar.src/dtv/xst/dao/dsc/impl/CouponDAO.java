/*     */ package dtv.xst.dao.dsc.impl;
/*     */ 
/*     */ import dtv.data2.access.DaoUtils;
/*     */ import dtv.data2.access.IObjectId;
/*     */ import dtv.data2.access.exception.DtxException;
/*     */ import dtv.data2.access.impl.AbstractDAOImpl;
/*     */ import dtv.util.DtvDate;
/*     */ import dtv.xst.dao.dsc.CouponId;
/*     */ import java.util.Date;
/*     */ import java.util.Map;
/*     */ import org.apache.log4j.Logger;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class CouponDAO
/*     */   extends AbstractDAOImpl
/*     */ {
/*     */   private static final long serialVersionUID = 2024260678L;
/*  23 */   private static final Logger _logger = Logger.getLogger(CouponDAO.class);
/*     */   
/*     */   private String _couponSerialNumber;
/*     */   private Long _organizationId;
/*     */   private String _orgCode;
/*     */   private String _orgValue;
/*     */   private DtvDate _createDate;
/*     */   private String _createUserId;
/*     */   private DtvDate _updateDate;
/*     */   private String _updateUserId;
/*     */   private String _discountCode;
/*     */   private String _couponType;
/*     */   private String _tenderId;
/*     */   private DtvDate _effectiveDate;
/*     */   private DtvDate _expirationDate;
/*  38 */   private Boolean _serialized = Boolean.FALSE;
/*     */   
/*     */   public String getCouponSerialNumber() {
/*  41 */     return this._couponSerialNumber;
/*     */   }
/*     */   
/*     */   public void setCouponSerialNumber(String argCouponSerialNumber) {
/*  45 */     if (changed(argCouponSerialNumber, this._couponSerialNumber, "couponSerialNumber")) {
/*  46 */       this._couponSerialNumber = (argCouponSerialNumber != null && MANAGE_CASE) ? argCouponSerialNumber.toUpperCase() : argCouponSerialNumber;
/*     */     }
/*     */   }
/*     */   
/*     */   public Long getOrganizationId() {
/*  51 */     return this._organizationId;
/*     */   }
/*     */   
/*     */   public void setOrganizationId(Long argOrganizationId) {
/*  55 */     if (changed(argOrganizationId, this._organizationId, "organizationId")) {
/*  56 */       this._organizationId = argOrganizationId;
/*     */     }
/*     */   }
/*     */   
/*     */   public String getOrgCode() {
/*  61 */     return this._orgCode;
/*     */   }
/*     */   
/*     */   public void setOrgCode(String argOrgCode) {
/*  65 */     if (changed(argOrgCode, this._orgCode, "orgCode")) {
/*  66 */       this._orgCode = argOrgCode;
/*     */     }
/*     */   }
/*     */   
/*     */   public String getOrgValue() {
/*  71 */     return this._orgValue;
/*     */   }
/*     */   
/*     */   public void setOrgValue(String argOrgValue) {
/*  75 */     if (changed(argOrgValue, this._orgValue, "orgValue")) {
/*  76 */       this._orgValue = argOrgValue;
/*     */     }
/*     */   }
/*     */   
/*     */   public Date getCreateDate() {
/*  81 */     return (Date)this._createDate;
/*     */   }
/*     */   
/*     */   public void setCreateDate(Date argCreateDate) {
/*  85 */     if (changed(argCreateDate, this._createDate, "createDate")) {
/*  86 */       this._createDate = (argCreateDate == null || argCreateDate instanceof DtvDate) ? (DtvDate)argCreateDate : new DtvDate(argCreateDate);
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public String getCreateUserId() {
/*  92 */     return this._createUserId;
/*     */   }
/*     */   
/*     */   public void setCreateUserId(String argCreateUserId) {
/*  96 */     if (changed(argCreateUserId, this._createUserId, "createUserId")) {
/*  97 */       this._createUserId = argCreateUserId;
/*     */     }
/*     */   }
/*     */   
/*     */   public Date getUpdateDate() {
/* 102 */     return (Date)this._updateDate;
/*     */   }
/*     */   
/*     */   public void setUpdateDate(Date argUpdateDate) {
/* 106 */     if (changed(argUpdateDate, this._updateDate, "updateDate")) {
/* 107 */       this._updateDate = (argUpdateDate == null || argUpdateDate instanceof DtvDate) ? (DtvDate)argUpdateDate : new DtvDate(argUpdateDate);
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public String getUpdateUserId() {
/* 113 */     return this._updateUserId;
/*     */   }
/*     */   
/*     */   public void setUpdateUserId(String argUpdateUserId) {
/* 117 */     if (changed(argUpdateUserId, this._updateUserId, "updateUserId")) {
/* 118 */       this._updateUserId = argUpdateUserId;
/*     */     }
/*     */   }
/*     */   
/*     */   public String getDiscountCode() {
/* 123 */     return this._discountCode;
/*     */   }
/*     */   
/*     */   public void setDiscountCode(String argDiscountCode) {
/* 127 */     if (changed(argDiscountCode, this._discountCode, "discountCode")) {
/* 128 */       this._discountCode = argDiscountCode;
/*     */     }
/*     */   }
/*     */   
/*     */   public String getCouponType() {
/* 133 */     return this._couponType;
/*     */   }
/*     */   
/*     */   public void setCouponType(String argCouponType) {
/* 137 */     if (changed(argCouponType, this._couponType, "couponType")) {
/* 138 */       this._couponType = argCouponType;
/*     */     }
/*     */   }
/*     */   
/*     */   public String getTenderId() {
/* 143 */     return this._tenderId;
/*     */   }
/*     */   
/*     */   public void setTenderId(String argTenderId) {
/* 147 */     if (changed(argTenderId, this._tenderId, "tenderId")) {
/* 148 */       this._tenderId = argTenderId;
/*     */     }
/*     */   }
/*     */   
/*     */   public Date getEffectiveDate() {
/* 153 */     return (Date)this._effectiveDate;
/*     */   }
/*     */   
/*     */   public void setEffectiveDate(Date argEffectiveDate) {
/* 157 */     if (changed(argEffectiveDate, this._effectiveDate, "effectiveDate")) {
/* 158 */       this._effectiveDate = (argEffectiveDate == null || argEffectiveDate instanceof DtvDate) ? (DtvDate)argEffectiveDate : new DtvDate(argEffectiveDate);
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public Date getExpirationDate() {
/* 164 */     return (Date)this._expirationDate;
/*     */   }
/*     */   
/*     */   public void setExpirationDate(Date argExpirationDate) {
/* 168 */     if (changed(argExpirationDate, this._expirationDate, "expirationDate")) {
/* 169 */       this._expirationDate = (argExpirationDate == null || argExpirationDate instanceof DtvDate) ? (DtvDate)argExpirationDate : new DtvDate(argExpirationDate);
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public Boolean getSerialized() {
/* 175 */     return this._serialized;
/*     */   }
/*     */   
/*     */   public void setSerialized(Boolean argSerialized) {
/* 179 */     if (changed(argSerialized, this._serialized, "serialized")) {
/* 180 */       this._serialized = argSerialized;
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public String toString() {
/* 187 */     StringBuilder buf = new StringBuilder(512);
/* 188 */     buf.append(super.toString()).append(" Id: ").append(getObjectId()).append(" Values: ");
/* 189 */     if (getCouponSerialNumber() != null) {
/* 190 */       buf.append("couponSerialNumber").append("=").append(getCouponSerialNumber()).append(" ");
/*     */     }
/* 192 */     if (getOrganizationId() != null) {
/* 193 */       buf.append("organizationId").append("=").append(getOrganizationId()).append(" ");
/*     */     }
/* 195 */     if (getOrgCode() != null) {
/* 196 */       buf.append("orgCode").append("=").append(getOrgCode()).append(" ");
/*     */     }
/* 198 */     if (getOrgValue() != null) {
/* 199 */       buf.append("orgValue").append("=").append(getOrgValue()).append(" ");
/*     */     }
/* 201 */     if (getCreateDate() != null) {
/* 202 */       buf.append("createDate").append("=").append(getCreateDate()).append(" ");
/*     */     }
/* 204 */     if (getCreateUserId() != null) {
/* 205 */       buf.append("createUserId").append("=").append(getCreateUserId()).append(" ");
/*     */     }
/* 207 */     if (getUpdateDate() != null) {
/* 208 */       buf.append("updateDate").append("=").append(getUpdateDate()).append(" ");
/*     */     }
/* 210 */     if (getUpdateUserId() != null) {
/* 211 */       buf.append("updateUserId").append("=").append(getUpdateUserId()).append(" ");
/*     */     }
/* 213 */     if (getDiscountCode() != null) {
/* 214 */       buf.append("discountCode").append("=").append(getDiscountCode()).append(" ");
/*     */     }
/* 216 */     if (getCouponType() != null) {
/* 217 */       buf.append("couponType").append("=").append(getCouponType()).append(" ");
/*     */     }
/* 219 */     if (getTenderId() != null) {
/* 220 */       buf.append("tenderId").append("=").append(getTenderId()).append(" ");
/*     */     }
/* 222 */     if (getEffectiveDate() != null) {
/* 223 */       buf.append("effectiveDate").append("=").append(getEffectiveDate()).append(" ");
/*     */     }
/* 225 */     if (getExpirationDate() != null) {
/* 226 */       buf.append("expirationDate").append("=").append(getExpirationDate()).append(" ");
/*     */     }
/* 228 */     if (getSerialized() != null && getSerialized().booleanValue()) {
/* 229 */       buf.append("serialized").append("=").append(getSerialized()).append(" ");
/*     */     }
/*     */     
/* 232 */     return buf.toString();
/*     */   }
/*     */   
/*     */   public IObjectId getObjectId() {
/* 236 */     CouponId id = new CouponId();
/* 237 */     id.setCouponSerialNumber(getCouponSerialNumber());
/* 238 */     id.setOrganizationId(getOrganizationId());
/* 239 */     return (IObjectId)id;
/*     */   }
/*     */   
/*     */   public void setObjectId(IObjectId argObjectId) {
/* 243 */     setCouponSerialNumber(((CouponId)argObjectId).getCouponSerialNumber());
/* 244 */     setOrganizationId(((CouponId)argObjectId).getOrganizationId());
/*     */   }
/*     */   
/*     */   public String getImplementingClass() {
/* 248 */     return null;
/*     */   }
/*     */   
/*     */   public String toXmlString() {
/* 252 */     StringBuilder buf = new StringBuilder(700);
/* 253 */     buf.append("<").append("dao").append(" name=\"Coupon\" cmd=\"" + getObjectStateString() + "\">");
/* 254 */     getFieldsAsXml(buf);
/* 255 */     buf.append("</").append("dao").append(">");
/*     */     
/* 257 */     return buf.toString();
/*     */   }
/*     */   
/*     */   public Map<String, String> getValues() {
/* 261 */     Map<String, String> values = super.getValues();
/* 262 */     if (this._couponSerialNumber != null) values.put("CouponSerialNumber", DaoUtils.getXmlSafeFieldValue(12, this._couponSerialNumber)); 
/* 263 */     if (this._organizationId != null) values.put("OrganizationId", DaoUtils.getXmlSafeFieldValue(-5, this._organizationId)); 
/* 264 */     if (this._orgCode != null) values.put("OrgCode", DaoUtils.getXmlSafeFieldValue(12, this._orgCode)); 
/* 265 */     if (this._orgValue != null) values.put("OrgValue", DaoUtils.getXmlSafeFieldValue(12, this._orgValue)); 
/* 266 */     if (this._createDate != null) values.put("CreateDate", DaoUtils.getXmlSafeFieldValue(91, this._createDate)); 
/* 267 */     if (this._createUserId != null) values.put("CreateUserId", DaoUtils.getXmlSafeFieldValue(12, this._createUserId)); 
/* 268 */     if (this._updateDate != null) values.put("UpdateDate", DaoUtils.getXmlSafeFieldValue(91, this._updateDate)); 
/* 269 */     if (this._updateUserId != null) values.put("UpdateUserId", DaoUtils.getXmlSafeFieldValue(12, this._updateUserId)); 
/* 270 */     if (this._discountCode != null) values.put("DiscountCode", DaoUtils.getXmlSafeFieldValue(12, this._discountCode)); 
/* 271 */     if (this._couponType != null) values.put("CouponType", DaoUtils.getXmlSafeFieldValue(12, this._couponType)); 
/* 272 */     if (this._tenderId != null) values.put("TenderId", DaoUtils.getXmlSafeFieldValue(12, this._tenderId)); 
/* 273 */     if (this._effectiveDate != null) values.put("EffectiveDate", DaoUtils.getXmlSafeFieldValue(91, this._effectiveDate)); 
/* 274 */     if (this._expirationDate != null) values.put("ExpirationDate", DaoUtils.getXmlSafeFieldValue(91, this._expirationDate)); 
/* 275 */     if (this._serialized != null) values.put("Serialized", DaoUtils.getXmlSafeFieldValue(-7, this._serialized)); 
/* 276 */     return values;
/*     */   }
/*     */ 
/*     */   
/*     */   public void setValues(Map<String, String> argValues) {
/* 281 */     super.setValues(argValues);
/* 282 */     for (Map.Entry<String, String> field : argValues.entrySet()) {
/*     */       
/* 284 */       String fieldName = field.getKey();
/* 285 */       String fieldValue = field.getValue();
/* 286 */       switch (fieldName) {
/*     */         
/*     */         case "CouponSerialNumber":
/*     */           try {
/* 290 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 291 */             setCouponSerialNumber((String)value);
/* 292 */           } catch (Exception ee) {
/* 293 */             throw new DtxException("An exception occurred while calling setCouponSerialNumber() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "OrganizationId":
/*     */           try {
/* 299 */             Object value = DaoUtils.getFieldValueForXmlString(-5, fieldValue);
/* 300 */             setOrganizationId((Long)value);
/* 301 */           } catch (Exception ee) {
/* 302 */             throw new DtxException("An exception occurred while calling setOrganizationId() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "OrgCode":
/*     */           try {
/* 308 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 309 */             setOrgCode((String)value);
/* 310 */           } catch (Exception ee) {
/* 311 */             throw new DtxException("An exception occurred while calling setOrgCode() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "OrgValue":
/*     */           try {
/* 317 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 318 */             setOrgValue((String)value);
/* 319 */           } catch (Exception ee) {
/* 320 */             throw new DtxException("An exception occurred while calling setOrgValue() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "CreateDate":
/*     */           try {
/* 326 */             Object value = DaoUtils.getFieldValueForXmlString(91, fieldValue);
/* 327 */             setCreateDate((Date)value);
/* 328 */           } catch (Exception ee) {
/* 329 */             throw new DtxException("An exception occurred while calling setCreateDate() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "CreateUserId":
/*     */           try {
/* 335 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 336 */             setCreateUserId((String)value);
/* 337 */           } catch (Exception ee) {
/* 338 */             throw new DtxException("An exception occurred while calling setCreateUserId() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "UpdateDate":
/*     */           try {
/* 344 */             Object value = DaoUtils.getFieldValueForXmlString(91, fieldValue);
/* 345 */             setUpdateDate((Date)value);
/* 346 */           } catch (Exception ee) {
/* 347 */             throw new DtxException("An exception occurred while calling setUpdateDate() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "UpdateUserId":
/*     */           try {
/* 353 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 354 */             setUpdateUserId((String)value);
/* 355 */           } catch (Exception ee) {
/* 356 */             throw new DtxException("An exception occurred while calling setUpdateUserId() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "DiscountCode":
/*     */           try {
/* 362 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 363 */             setDiscountCode((String)value);
/* 364 */           } catch (Exception ee) {
/* 365 */             throw new DtxException("An exception occurred while calling setDiscountCode() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "CouponType":
/*     */           try {
/* 371 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 372 */             setCouponType((String)value);
/* 373 */           } catch (Exception ee) {
/* 374 */             throw new DtxException("An exception occurred while calling setCouponType() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "TenderId":
/*     */           try {
/* 380 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 381 */             setTenderId((String)value);
/* 382 */           } catch (Exception ee) {
/* 383 */             throw new DtxException("An exception occurred while calling setTenderId() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "EffectiveDate":
/*     */           try {
/* 389 */             Object value = DaoUtils.getFieldValueForXmlString(91, fieldValue);
/* 390 */             setEffectiveDate((Date)value);
/* 391 */           } catch (Exception ee) {
/* 392 */             throw new DtxException("An exception occurred while calling setEffectiveDate() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "ExpirationDate":
/*     */           try {
/* 398 */             Object value = DaoUtils.getFieldValueForXmlString(91, fieldValue);
/* 399 */             setExpirationDate((Date)value);
/* 400 */           } catch (Exception ee) {
/* 401 */             throw new DtxException("An exception occurred while calling setExpirationDate() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "Serialized":
/*     */           try {
/* 407 */             Object value = DaoUtils.getFieldValueForXmlString(-7, fieldValue);
/* 408 */             setSerialized((Boolean)value);
/* 409 */           } catch (Exception ee) {
/* 410 */             throw new DtxException("An exception occurred while calling setSerialized() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */       } 
/*     */     } 
/*     */   }
/*     */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\dsc\impl\CouponDAO.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */