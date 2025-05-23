/*     */ package dtv.xst.dao.ttr.impl;
/*     */ 
/*     */ import dtv.data2.access.DaoUtils;
/*     */ import dtv.data2.access.exception.DtxException;
/*     */ import dtv.util.DtvDate;
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
/*     */ 
/*     */ public class CouponTenderLineItemDAO
/*     */   extends TenderLineItemDAO
/*     */ {
/*     */   private static final long serialVersionUID = -1207671295L;
/*  23 */   private static final Logger _logger = Logger.getLogger(CouponTenderLineItemDAO.class);
/*     */   
/*     */   private DtvDate _createDate;
/*     */   private String _createUserId;
/*     */   private DtvDate _updateDate;
/*     */   private String _updateUserId;
/*     */   private String _couponTypeCode;
/*     */   private DtvDate _expirationDate;
/*  31 */   private Boolean _keyEntered = Boolean.FALSE;
/*     */   private String _manufacturerFamilyCode;
/*     */   private String _manufacturerId;
/*     */   private String _promotionCode;
/*     */   private String _scanCode;
/*     */   
/*     */   public Date getCreateDate() {
/*  38 */     return (Date)this._createDate;
/*     */   }
/*     */   
/*     */   public void setCreateDate(Date argCreateDate) {
/*  42 */     if (changed(argCreateDate, this._createDate, "createDate")) {
/*  43 */       this._createDate = (argCreateDate == null || argCreateDate instanceof DtvDate) ? (DtvDate)argCreateDate : new DtvDate(argCreateDate);
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public String getCreateUserId() {
/*  49 */     return this._createUserId;
/*     */   }
/*     */   
/*     */   public void setCreateUserId(String argCreateUserId) {
/*  53 */     if (changed(argCreateUserId, this._createUserId, "createUserId")) {
/*  54 */       this._createUserId = argCreateUserId;
/*     */     }
/*     */   }
/*     */   
/*     */   public Date getUpdateDate() {
/*  59 */     return (Date)this._updateDate;
/*     */   }
/*     */   
/*     */   public void setUpdateDate(Date argUpdateDate) {
/*  63 */     if (changed(argUpdateDate, this._updateDate, "updateDate")) {
/*  64 */       this._updateDate = (argUpdateDate == null || argUpdateDate instanceof DtvDate) ? (DtvDate)argUpdateDate : new DtvDate(argUpdateDate);
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public String getUpdateUserId() {
/*  70 */     return this._updateUserId;
/*     */   }
/*     */   
/*     */   public void setUpdateUserId(String argUpdateUserId) {
/*  74 */     if (changed(argUpdateUserId, this._updateUserId, "updateUserId")) {
/*  75 */       this._updateUserId = argUpdateUserId;
/*     */     }
/*     */   }
/*     */   
/*     */   public String getCouponTypeCode() {
/*  80 */     return this._couponTypeCode;
/*     */   }
/*     */   
/*     */   public void setCouponTypeCode(String argCouponTypeCode) {
/*  84 */     if (changed(argCouponTypeCode, this._couponTypeCode, "couponTypeCode")) {
/*  85 */       this._couponTypeCode = argCouponTypeCode;
/*     */     }
/*     */   }
/*     */   
/*     */   public Date getExpirationDate() {
/*  90 */     return (Date)this._expirationDate;
/*     */   }
/*     */   
/*     */   public void setExpirationDate(Date argExpirationDate) {
/*  94 */     if (changed(argExpirationDate, this._expirationDate, "expirationDate")) {
/*  95 */       this._expirationDate = (argExpirationDate == null || argExpirationDate instanceof DtvDate) ? (DtvDate)argExpirationDate : new DtvDate(argExpirationDate);
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public Boolean getKeyEntered() {
/* 101 */     return this._keyEntered;
/*     */   }
/*     */   
/*     */   public void setKeyEntered(Boolean argKeyEntered) {
/* 105 */     if (changed(argKeyEntered, this._keyEntered, "keyEntered")) {
/* 106 */       this._keyEntered = argKeyEntered;
/*     */     }
/*     */   }
/*     */   
/*     */   public String getManufacturerFamilyCode() {
/* 111 */     return this._manufacturerFamilyCode;
/*     */   }
/*     */   
/*     */   public void setManufacturerFamilyCode(String argManufacturerFamilyCode) {
/* 115 */     if (changed(argManufacturerFamilyCode, this._manufacturerFamilyCode, "manufacturerFamilyCode")) {
/* 116 */       this._manufacturerFamilyCode = argManufacturerFamilyCode;
/*     */     }
/*     */   }
/*     */   
/*     */   public String getManufacturerId() {
/* 121 */     return this._manufacturerId;
/*     */   }
/*     */   
/*     */   public void setManufacturerId(String argManufacturerId) {
/* 125 */     if (changed(argManufacturerId, this._manufacturerId, "manufacturerId")) {
/* 126 */       this._manufacturerId = argManufacturerId;
/*     */     }
/*     */   }
/*     */   
/*     */   public String getPromotionCode() {
/* 131 */     return this._promotionCode;
/*     */   }
/*     */   
/*     */   public void setPromotionCode(String argPromotionCode) {
/* 135 */     if (changed(argPromotionCode, this._promotionCode, "promotionCode")) {
/* 136 */       this._promotionCode = argPromotionCode;
/*     */     }
/*     */   }
/*     */   
/*     */   public String getScanCode() {
/* 141 */     return this._scanCode;
/*     */   }
/*     */   
/*     */   public void setScanCode(String argScanCode) {
/* 145 */     if (changed(argScanCode, this._scanCode, "scanCode")) {
/* 146 */       this._scanCode = argScanCode;
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public String toString() {
/* 153 */     StringBuilder buf = new StringBuilder(512);
/* 154 */     buf.append(super.toString());
/* 155 */     if (getCreateDate() != null) {
/* 156 */       buf.append("createDate").append("=").append(getCreateDate()).append(" ");
/*     */     }
/* 158 */     if (getCreateUserId() != null) {
/* 159 */       buf.append("createUserId").append("=").append(getCreateUserId()).append(" ");
/*     */     }
/* 161 */     if (getUpdateDate() != null) {
/* 162 */       buf.append("updateDate").append("=").append(getUpdateDate()).append(" ");
/*     */     }
/* 164 */     if (getUpdateUserId() != null) {
/* 165 */       buf.append("updateUserId").append("=").append(getUpdateUserId()).append(" ");
/*     */     }
/* 167 */     if (getCouponTypeCode() != null) {
/* 168 */       buf.append("couponTypeCode").append("=").append(getCouponTypeCode()).append(" ");
/*     */     }
/* 170 */     if (getExpirationDate() != null) {
/* 171 */       buf.append("expirationDate").append("=").append(getExpirationDate()).append(" ");
/*     */     }
/* 173 */     if (getKeyEntered() != null && getKeyEntered().booleanValue()) {
/* 174 */       buf.append("keyEntered").append("=").append(getKeyEntered()).append(" ");
/*     */     }
/* 176 */     if (getManufacturerFamilyCode() != null) {
/* 177 */       buf.append("manufacturerFamilyCode").append("=").append(getManufacturerFamilyCode()).append(" ");
/*     */     }
/* 179 */     if (getManufacturerId() != null) {
/* 180 */       buf.append("manufacturerId").append("=").append(getManufacturerId()).append(" ");
/*     */     }
/* 182 */     if (getPromotionCode() != null) {
/* 183 */       buf.append("promotionCode").append("=").append(getPromotionCode()).append(" ");
/*     */     }
/* 185 */     if (getScanCode() != null) {
/* 186 */       buf.append("scanCode").append("=").append(getScanCode()).append(" ");
/*     */     }
/*     */     
/* 189 */     return buf.toString();
/*     */   }
/*     */ 
/*     */   
/*     */   public String toXmlString() {
/* 194 */     StringBuilder buf = new StringBuilder(2200);
/* 195 */     buf.append("<").append("dao").append(" name=\"CouponTenderLineItem\" cmd=\"" + getObjectStateString() + "\">");
/* 196 */     getFieldsAsXml(buf);
/* 197 */     buf.append("</").append("dao").append(">");
/*     */     
/* 199 */     return buf.toString();
/*     */   }
/*     */   
/*     */   public Map<String, String> getValues() {
/* 203 */     Map<String, String> values = super.getValues();
/* 204 */     if (this._createDate != null) values.put("CreateDate", DaoUtils.getXmlSafeFieldValue(91, this._createDate)); 
/* 205 */     if (this._createUserId != null) values.put("CreateUserId", DaoUtils.getXmlSafeFieldValue(12, this._createUserId)); 
/* 206 */     if (this._updateDate != null) values.put("UpdateDate", DaoUtils.getXmlSafeFieldValue(91, this._updateDate)); 
/* 207 */     if (this._updateUserId != null) values.put("UpdateUserId", DaoUtils.getXmlSafeFieldValue(12, this._updateUserId)); 
/* 208 */     if (this._couponTypeCode != null) values.put("CouponTypeCode", DaoUtils.getXmlSafeFieldValue(12, this._couponTypeCode)); 
/* 209 */     if (this._expirationDate != null) values.put("ExpirationDate", DaoUtils.getXmlSafeFieldValue(91, this._expirationDate)); 
/* 210 */     if (this._keyEntered != null) values.put("KeyEntered", DaoUtils.getXmlSafeFieldValue(-7, this._keyEntered)); 
/* 211 */     if (this._manufacturerFamilyCode != null) values.put("ManufacturerFamilyCode", DaoUtils.getXmlSafeFieldValue(12, this._manufacturerFamilyCode)); 
/* 212 */     if (this._manufacturerId != null) values.put("ManufacturerId", DaoUtils.getXmlSafeFieldValue(12, this._manufacturerId)); 
/* 213 */     if (this._promotionCode != null) values.put("PromotionCode", DaoUtils.getXmlSafeFieldValue(12, this._promotionCode)); 
/* 214 */     if (this._scanCode != null) values.put("ScanCode", DaoUtils.getXmlSafeFieldValue(12, this._scanCode)); 
/* 215 */     return values;
/*     */   }
/*     */ 
/*     */   
/*     */   public void setValues(Map<String, String> argValues) {
/* 220 */     super.setValues(argValues);
/* 221 */     for (Map.Entry<String, String> field : argValues.entrySet()) {
/*     */       
/* 223 */       String fieldName = field.getKey();
/* 224 */       String fieldValue = field.getValue();
/* 225 */       switch (fieldName) {
/*     */         
/*     */         case "CreateDate":
/*     */           try {
/* 229 */             Object value = DaoUtils.getFieldValueForXmlString(91, fieldValue);
/* 230 */             setCreateDate((Date)value);
/* 231 */           } catch (Exception ee) {
/* 232 */             throw new DtxException("An exception occurred while calling setCreateDate() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "CreateUserId":
/*     */           try {
/* 238 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 239 */             setCreateUserId((String)value);
/* 240 */           } catch (Exception ee) {
/* 241 */             throw new DtxException("An exception occurred while calling setCreateUserId() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "UpdateDate":
/*     */           try {
/* 247 */             Object value = DaoUtils.getFieldValueForXmlString(91, fieldValue);
/* 248 */             setUpdateDate((Date)value);
/* 249 */           } catch (Exception ee) {
/* 250 */             throw new DtxException("An exception occurred while calling setUpdateDate() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "UpdateUserId":
/*     */           try {
/* 256 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 257 */             setUpdateUserId((String)value);
/* 258 */           } catch (Exception ee) {
/* 259 */             throw new DtxException("An exception occurred while calling setUpdateUserId() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "CouponTypeCode":
/*     */           try {
/* 265 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 266 */             setCouponTypeCode((String)value);
/* 267 */           } catch (Exception ee) {
/* 268 */             throw new DtxException("An exception occurred while calling setCouponTypeCode() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "ExpirationDate":
/*     */           try {
/* 274 */             Object value = DaoUtils.getFieldValueForXmlString(91, fieldValue);
/* 275 */             setExpirationDate((Date)value);
/* 276 */           } catch (Exception ee) {
/* 277 */             throw new DtxException("An exception occurred while calling setExpirationDate() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "KeyEntered":
/*     */           try {
/* 283 */             Object value = DaoUtils.getFieldValueForXmlString(-7, fieldValue);
/* 284 */             setKeyEntered((Boolean)value);
/* 285 */           } catch (Exception ee) {
/* 286 */             throw new DtxException("An exception occurred while calling setKeyEntered() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "ManufacturerFamilyCode":
/*     */           try {
/* 292 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 293 */             setManufacturerFamilyCode((String)value);
/* 294 */           } catch (Exception ee) {
/* 295 */             throw new DtxException("An exception occurred while calling setManufacturerFamilyCode() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "ManufacturerId":
/*     */           try {
/* 301 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 302 */             setManufacturerId((String)value);
/* 303 */           } catch (Exception ee) {
/* 304 */             throw new DtxException("An exception occurred while calling setManufacturerId() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "PromotionCode":
/*     */           try {
/* 310 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 311 */             setPromotionCode((String)value);
/* 312 */           } catch (Exception ee) {
/* 313 */             throw new DtxException("An exception occurred while calling setPromotionCode() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "ScanCode":
/*     */           try {
/* 319 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 320 */             setScanCode((String)value);
/* 321 */           } catch (Exception ee) {
/* 322 */             throw new DtxException("An exception occurred while calling setScanCode() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */       } 
/*     */     } 
/*     */   }
/*     */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\ttr\impl\CouponTenderLineItemDAO.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */