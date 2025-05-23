/*     */ package dtv.xst.dao.trl.impl;
/*     */ 
/*     */ import dtv.data2.access.DaoUtils;
/*     */ import dtv.data2.access.exception.DtxException;
/*     */ import dtv.util.DtvDate;
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
/*     */ 
/*     */ 
/*     */ 
/*     */ public class CouponLineItemDAO
/*     */   extends RetailTransactionLineItemDAO
/*     */ {
/*     */   private static final long serialVersionUID = 470353805L;
/*  23 */   private static final Logger _logger = Logger.getLogger(CouponLineItemDAO.class);
/*     */   
/*     */   private DtvDate _createDate;
/*     */   private String _createUserId;
/*     */   private DtvDate _updateDate;
/*     */   private String _updateUserId;
/*     */   private String _couponId;
/*     */   private String _couponTypeCode;
/*     */   private DtvDate _expirationDate;
/*     */   private String _entryMethodCode;
/*     */   private String _manufacturerId;
/*     */   private String _valueCode;
/*     */   private BigDecimal _amountEntered;
/*     */   private String _manufacturerFamilyCode;
/*  37 */   private Boolean _serialized = Boolean.FALSE;
/*  38 */   private Boolean _authorized = Boolean.FALSE;
/*     */   private String _redemptionTransId;
/*     */   
/*     */   public Date getCreateDate() {
/*  42 */     return (Date)this._createDate;
/*     */   }
/*     */   
/*     */   public void setCreateDate(Date argCreateDate) {
/*  46 */     if (changed(argCreateDate, this._createDate, "createDate")) {
/*  47 */       this._createDate = (argCreateDate == null || argCreateDate instanceof DtvDate) ? (DtvDate)argCreateDate : new DtvDate(argCreateDate);
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public String getCreateUserId() {
/*  53 */     return this._createUserId;
/*     */   }
/*     */   
/*     */   public void setCreateUserId(String argCreateUserId) {
/*  57 */     if (changed(argCreateUserId, this._createUserId, "createUserId")) {
/*  58 */       this._createUserId = argCreateUserId;
/*     */     }
/*     */   }
/*     */   
/*     */   public Date getUpdateDate() {
/*  63 */     return (Date)this._updateDate;
/*     */   }
/*     */   
/*     */   public void setUpdateDate(Date argUpdateDate) {
/*  67 */     if (changed(argUpdateDate, this._updateDate, "updateDate")) {
/*  68 */       this._updateDate = (argUpdateDate == null || argUpdateDate instanceof DtvDate) ? (DtvDate)argUpdateDate : new DtvDate(argUpdateDate);
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public String getUpdateUserId() {
/*  74 */     return this._updateUserId;
/*     */   }
/*     */   
/*     */   public void setUpdateUserId(String argUpdateUserId) {
/*  78 */     if (changed(argUpdateUserId, this._updateUserId, "updateUserId")) {
/*  79 */       this._updateUserId = argUpdateUserId;
/*     */     }
/*     */   }
/*     */   
/*     */   public String getCouponId() {
/*  84 */     return this._couponId;
/*     */   }
/*     */   
/*     */   public void setCouponId(String argCouponId) {
/*  88 */     if (changed(argCouponId, this._couponId, "couponId")) {
/*  89 */       this._couponId = argCouponId;
/*     */     }
/*     */   }
/*     */   
/*     */   public String getCouponTypeCode() {
/*  94 */     return this._couponTypeCode;
/*     */   }
/*     */   
/*     */   public void setCouponTypeCode(String argCouponTypeCode) {
/*  98 */     if (changed(argCouponTypeCode, this._couponTypeCode, "couponTypeCode")) {
/*  99 */       this._couponTypeCode = argCouponTypeCode;
/*     */     }
/*     */   }
/*     */   
/*     */   public Date getExpirationDate() {
/* 104 */     return (Date)this._expirationDate;
/*     */   }
/*     */   
/*     */   public void setExpirationDate(Date argExpirationDate) {
/* 108 */     if (changed(argExpirationDate, this._expirationDate, "expirationDate")) {
/* 109 */       this._expirationDate = (argExpirationDate == null || argExpirationDate instanceof DtvDate) ? (DtvDate)argExpirationDate : new DtvDate(argExpirationDate);
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public String getEntryMethodCode() {
/* 115 */     return this._entryMethodCode;
/*     */   }
/*     */   
/*     */   public void setEntryMethodCode(String argEntryMethodCode) {
/* 119 */     if (changed(argEntryMethodCode, this._entryMethodCode, "entryMethodCode")) {
/* 120 */       this._entryMethodCode = argEntryMethodCode;
/*     */     }
/*     */   }
/*     */   
/*     */   public String getManufacturerId() {
/* 125 */     return this._manufacturerId;
/*     */   }
/*     */   
/*     */   public void setManufacturerId(String argManufacturerId) {
/* 129 */     if (changed(argManufacturerId, this._manufacturerId, "manufacturerId")) {
/* 130 */       this._manufacturerId = argManufacturerId;
/*     */     }
/*     */   }
/*     */   
/*     */   public String getValueCode() {
/* 135 */     return this._valueCode;
/*     */   }
/*     */   
/*     */   public void setValueCode(String argValueCode) {
/* 139 */     if (changed(argValueCode, this._valueCode, "valueCode")) {
/* 140 */       this._valueCode = argValueCode;
/*     */     }
/*     */   }
/*     */   
/*     */   public BigDecimal getAmountEntered() {
/* 145 */     return this._amountEntered;
/*     */   }
/*     */   
/*     */   public void setAmountEntered(BigDecimal argAmountEntered) {
/* 149 */     if (changed(argAmountEntered, this._amountEntered, "amountEntered")) {
/* 150 */       this._amountEntered = argAmountEntered;
/*     */     }
/*     */   }
/*     */   
/*     */   public String getManufacturerFamilyCode() {
/* 155 */     return this._manufacturerFamilyCode;
/*     */   }
/*     */   
/*     */   public void setManufacturerFamilyCode(String argManufacturerFamilyCode) {
/* 159 */     if (changed(argManufacturerFamilyCode, this._manufacturerFamilyCode, "manufacturerFamilyCode")) {
/* 160 */       this._manufacturerFamilyCode = argManufacturerFamilyCode;
/*     */     }
/*     */   }
/*     */   
/*     */   public Boolean getSerialized() {
/* 165 */     return this._serialized;
/*     */   }
/*     */   
/*     */   public void setSerialized(Boolean argSerialized) {
/* 169 */     if (changed(argSerialized, this._serialized, "serialized")) {
/* 170 */       this._serialized = argSerialized;
/*     */     }
/*     */   }
/*     */   
/*     */   public Boolean getAuthorized() {
/* 175 */     return this._authorized;
/*     */   }
/*     */   
/*     */   public void setAuthorized(Boolean argAuthorized) {
/* 179 */     if (changed(argAuthorized, this._authorized, "authorized")) {
/* 180 */       this._authorized = argAuthorized;
/*     */     }
/*     */   }
/*     */   
/*     */   public String getRedemptionTransId() {
/* 185 */     return this._redemptionTransId;
/*     */   }
/*     */   
/*     */   public void setRedemptionTransId(String argRedemptionTransId) {
/* 189 */     if (changed(argRedemptionTransId, this._redemptionTransId, "redemptionTransId")) {
/* 190 */       this._redemptionTransId = argRedemptionTransId;
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public String toString() {
/* 197 */     StringBuilder buf = new StringBuilder(512);
/* 198 */     buf.append(super.toString());
/* 199 */     if (getCreateDate() != null) {
/* 200 */       buf.append("createDate").append("=").append(getCreateDate()).append(" ");
/*     */     }
/* 202 */     if (getCreateUserId() != null) {
/* 203 */       buf.append("createUserId").append("=").append(getCreateUserId()).append(" ");
/*     */     }
/* 205 */     if (getUpdateDate() != null) {
/* 206 */       buf.append("updateDate").append("=").append(getUpdateDate()).append(" ");
/*     */     }
/* 208 */     if (getUpdateUserId() != null) {
/* 209 */       buf.append("updateUserId").append("=").append(getUpdateUserId()).append(" ");
/*     */     }
/* 211 */     if (getCouponId() != null) {
/* 212 */       buf.append("couponId").append("=").append(getCouponId()).append(" ");
/*     */     }
/* 214 */     if (getCouponTypeCode() != null) {
/* 215 */       buf.append("couponTypeCode").append("=").append(getCouponTypeCode()).append(" ");
/*     */     }
/* 217 */     if (getExpirationDate() != null) {
/* 218 */       buf.append("expirationDate").append("=").append(getExpirationDate()).append(" ");
/*     */     }
/* 220 */     if (getEntryMethodCode() != null) {
/* 221 */       buf.append("entryMethodCode").append("=").append(getEntryMethodCode()).append(" ");
/*     */     }
/* 223 */     if (getManufacturerId() != null) {
/* 224 */       buf.append("manufacturerId").append("=").append(getManufacturerId()).append(" ");
/*     */     }
/* 226 */     if (getValueCode() != null) {
/* 227 */       buf.append("valueCode").append("=").append(getValueCode()).append(" ");
/*     */     }
/* 229 */     if (getAmountEntered() != null) {
/* 230 */       buf.append("amountEntered").append("=").append(getAmountEntered()).append(" ");
/*     */     }
/* 232 */     if (getManufacturerFamilyCode() != null) {
/* 233 */       buf.append("manufacturerFamilyCode").append("=").append(getManufacturerFamilyCode()).append(" ");
/*     */     }
/* 235 */     if (getSerialized() != null && getSerialized().booleanValue()) {
/* 236 */       buf.append("serialized").append("=").append(getSerialized()).append(" ");
/*     */     }
/* 238 */     if (getAuthorized() != null && getAuthorized().booleanValue()) {
/* 239 */       buf.append("authorized").append("=").append(getAuthorized()).append(" ");
/*     */     }
/* 241 */     if (getRedemptionTransId() != null) {
/* 242 */       buf.append("redemptionTransId").append("=").append(getRedemptionTransId()).append(" ");
/*     */     }
/*     */     
/* 245 */     return buf.toString();
/*     */   }
/*     */ 
/*     */   
/*     */   public String toXmlString() {
/* 250 */     StringBuilder buf = new StringBuilder(1800);
/* 251 */     buf.append("<").append("dao").append(" name=\"CouponLineItem\" cmd=\"" + getObjectStateString() + "\">");
/* 252 */     getFieldsAsXml(buf);
/* 253 */     buf.append("</").append("dao").append(">");
/*     */     
/* 255 */     return buf.toString();
/*     */   }
/*     */   
/*     */   public Map<String, String> getValues() {
/* 259 */     Map<String, String> values = super.getValues();
/* 260 */     if (this._createDate != null) values.put("CreateDate", DaoUtils.getXmlSafeFieldValue(91, this._createDate)); 
/* 261 */     if (this._createUserId != null) values.put("CreateUserId", DaoUtils.getXmlSafeFieldValue(12, this._createUserId)); 
/* 262 */     if (this._updateDate != null) values.put("UpdateDate", DaoUtils.getXmlSafeFieldValue(91, this._updateDate)); 
/* 263 */     if (this._updateUserId != null) values.put("UpdateUserId", DaoUtils.getXmlSafeFieldValue(12, this._updateUserId)); 
/* 264 */     if (this._couponId != null) values.put("CouponId", DaoUtils.getXmlSafeFieldValue(12, this._couponId)); 
/* 265 */     if (this._couponTypeCode != null) values.put("CouponTypeCode", DaoUtils.getXmlSafeFieldValue(12, this._couponTypeCode)); 
/* 266 */     if (this._expirationDate != null) values.put("ExpirationDate", DaoUtils.getXmlSafeFieldValue(91, this._expirationDate)); 
/* 267 */     if (this._entryMethodCode != null) values.put("EntryMethodCode", DaoUtils.getXmlSafeFieldValue(12, this._entryMethodCode)); 
/* 268 */     if (this._manufacturerId != null) values.put("ManufacturerId", DaoUtils.getXmlSafeFieldValue(12, this._manufacturerId)); 
/* 269 */     if (this._valueCode != null) values.put("ValueCode", DaoUtils.getXmlSafeFieldValue(12, this._valueCode)); 
/* 270 */     if (this._amountEntered != null) values.put("AmountEntered", DaoUtils.getXmlSafeFieldValue(3, this._amountEntered)); 
/* 271 */     if (this._manufacturerFamilyCode != null) values.put("ManufacturerFamilyCode", DaoUtils.getXmlSafeFieldValue(12, this._manufacturerFamilyCode)); 
/* 272 */     if (this._serialized != null) values.put("Serialized", DaoUtils.getXmlSafeFieldValue(-7, this._serialized)); 
/* 273 */     if (this._authorized != null) values.put("Authorized", DaoUtils.getXmlSafeFieldValue(-7, this._authorized)); 
/* 274 */     if (this._redemptionTransId != null) values.put("RedemptionTransId", DaoUtils.getXmlSafeFieldValue(12, this._redemptionTransId)); 
/* 275 */     return values;
/*     */   }
/*     */ 
/*     */   
/*     */   public void setValues(Map<String, String> argValues) {
/* 280 */     super.setValues(argValues);
/* 281 */     for (Map.Entry<String, String> field : argValues.entrySet()) {
/*     */       
/* 283 */       String fieldName = field.getKey();
/* 284 */       String fieldValue = field.getValue();
/* 285 */       switch (fieldName) {
/*     */         
/*     */         case "CreateDate":
/*     */           try {
/* 289 */             Object value = DaoUtils.getFieldValueForXmlString(91, fieldValue);
/* 290 */             setCreateDate((Date)value);
/* 291 */           } catch (Exception ee) {
/* 292 */             throw new DtxException("An exception occurred while calling setCreateDate() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "CreateUserId":
/*     */           try {
/* 298 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 299 */             setCreateUserId((String)value);
/* 300 */           } catch (Exception ee) {
/* 301 */             throw new DtxException("An exception occurred while calling setCreateUserId() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "UpdateDate":
/*     */           try {
/* 307 */             Object value = DaoUtils.getFieldValueForXmlString(91, fieldValue);
/* 308 */             setUpdateDate((Date)value);
/* 309 */           } catch (Exception ee) {
/* 310 */             throw new DtxException("An exception occurred while calling setUpdateDate() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "UpdateUserId":
/*     */           try {
/* 316 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 317 */             setUpdateUserId((String)value);
/* 318 */           } catch (Exception ee) {
/* 319 */             throw new DtxException("An exception occurred while calling setUpdateUserId() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "CouponId":
/*     */           try {
/* 325 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 326 */             setCouponId((String)value);
/* 327 */           } catch (Exception ee) {
/* 328 */             throw new DtxException("An exception occurred while calling setCouponId() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "CouponTypeCode":
/*     */           try {
/* 334 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 335 */             setCouponTypeCode((String)value);
/* 336 */           } catch (Exception ee) {
/* 337 */             throw new DtxException("An exception occurred while calling setCouponTypeCode() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "ExpirationDate":
/*     */           try {
/* 343 */             Object value = DaoUtils.getFieldValueForXmlString(91, fieldValue);
/* 344 */             setExpirationDate((Date)value);
/* 345 */           } catch (Exception ee) {
/* 346 */             throw new DtxException("An exception occurred while calling setExpirationDate() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "EntryMethodCode":
/*     */           try {
/* 352 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 353 */             setEntryMethodCode((String)value);
/* 354 */           } catch (Exception ee) {
/* 355 */             throw new DtxException("An exception occurred while calling setEntryMethodCode() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "ManufacturerId":
/*     */           try {
/* 361 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 362 */             setManufacturerId((String)value);
/* 363 */           } catch (Exception ee) {
/* 364 */             throw new DtxException("An exception occurred while calling setManufacturerId() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "ValueCode":
/*     */           try {
/* 370 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 371 */             setValueCode((String)value);
/* 372 */           } catch (Exception ee) {
/* 373 */             throw new DtxException("An exception occurred while calling setValueCode() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "AmountEntered":
/*     */           try {
/* 379 */             Object value = DaoUtils.getFieldValueForXmlString(3, fieldValue);
/* 380 */             setAmountEntered((BigDecimal)value);
/* 381 */           } catch (Exception ee) {
/* 382 */             throw new DtxException("An exception occurred while calling setAmountEntered() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "ManufacturerFamilyCode":
/*     */           try {
/* 388 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 389 */             setManufacturerFamilyCode((String)value);
/* 390 */           } catch (Exception ee) {
/* 391 */             throw new DtxException("An exception occurred while calling setManufacturerFamilyCode() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "Serialized":
/*     */           try {
/* 397 */             Object value = DaoUtils.getFieldValueForXmlString(-7, fieldValue);
/* 398 */             setSerialized((Boolean)value);
/* 399 */           } catch (Exception ee) {
/* 400 */             throw new DtxException("An exception occurred while calling setSerialized() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "Authorized":
/*     */           try {
/* 406 */             Object value = DaoUtils.getFieldValueForXmlString(-7, fieldValue);
/* 407 */             setAuthorized((Boolean)value);
/* 408 */           } catch (Exception ee) {
/* 409 */             throw new DtxException("An exception occurred while calling setAuthorized() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "RedemptionTransId":
/*     */           try {
/* 415 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 416 */             setRedemptionTransId((String)value);
/* 417 */           } catch (Exception ee) {
/* 418 */             throw new DtxException("An exception occurred while calling setRedemptionTransId() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */       } 
/*     */     } 
/*     */   }
/*     */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\trl\impl\CouponLineItemDAO.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */