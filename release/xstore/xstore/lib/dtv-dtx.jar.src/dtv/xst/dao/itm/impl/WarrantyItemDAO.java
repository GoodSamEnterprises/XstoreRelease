/*     */ package dtv.xst.dao.itm.impl;
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
/*     */ public class WarrantyItemDAO
/*     */   extends NonPhysicalItemDAO
/*     */ {
/*     */   private static final long serialVersionUID = -1154324913L;
/*  23 */   private static final Logger _logger = Logger.getLogger(WarrantyItemDAO.class);
/*     */   
/*     */   private DtvDate _createDate;
/*     */   private String _createUserId;
/*     */   private DtvDate _updateDate;
/*     */   private String _updateUserId;
/*     */   private String _pricingMethodCode;
/*     */   private BigDecimal _warrantyPriceAmt;
/*     */   private BigDecimal _warrantyPricePercentage;
/*     */   private BigDecimal _warrantyMinPriceAmt;
/*     */   private Long _expirationDays;
/*     */   private Long _serviceDays;
/*  35 */   private Boolean _renewable = Boolean.FALSE;
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
/*     */   public String getPricingMethodCode() {
/*  80 */     return this._pricingMethodCode;
/*     */   }
/*     */   
/*     */   public void setPricingMethodCode(String argPricingMethodCode) {
/*  84 */     if (changed(argPricingMethodCode, this._pricingMethodCode, "pricingMethodCode")) {
/*  85 */       this._pricingMethodCode = argPricingMethodCode;
/*     */     }
/*     */   }
/*     */   
/*     */   public BigDecimal getWarrantyPriceAmt() {
/*  90 */     return this._warrantyPriceAmt;
/*     */   }
/*     */   
/*     */   public void setWarrantyPriceAmt(BigDecimal argWarrantyPriceAmt) {
/*  94 */     if (changed(argWarrantyPriceAmt, this._warrantyPriceAmt, "warrantyPriceAmt")) {
/*  95 */       this._warrantyPriceAmt = argWarrantyPriceAmt;
/*     */     }
/*     */   }
/*     */   
/*     */   public BigDecimal getWarrantyPricePercentage() {
/* 100 */     return this._warrantyPricePercentage;
/*     */   }
/*     */   
/*     */   public void setWarrantyPricePercentage(BigDecimal argWarrantyPricePercentage) {
/* 104 */     if (changed(argWarrantyPricePercentage, this._warrantyPricePercentage, "warrantyPricePercentage")) {
/* 105 */       this._warrantyPricePercentage = argWarrantyPricePercentage;
/*     */     }
/*     */   }
/*     */   
/*     */   public BigDecimal getWarrantyMinPriceAmt() {
/* 110 */     return this._warrantyMinPriceAmt;
/*     */   }
/*     */   
/*     */   public void setWarrantyMinPriceAmt(BigDecimal argWarrantyMinPriceAmt) {
/* 114 */     if (changed(argWarrantyMinPriceAmt, this._warrantyMinPriceAmt, "warrantyMinPriceAmt")) {
/* 115 */       this._warrantyMinPriceAmt = argWarrantyMinPriceAmt;
/*     */     }
/*     */   }
/*     */   
/*     */   public Long getExpirationDays() {
/* 120 */     return this._expirationDays;
/*     */   }
/*     */   
/*     */   public void setExpirationDays(Long argExpirationDays) {
/* 124 */     if (changed(argExpirationDays, this._expirationDays, "expirationDays")) {
/* 125 */       this._expirationDays = argExpirationDays;
/*     */     }
/*     */   }
/*     */   
/*     */   public Long getServiceDays() {
/* 130 */     return this._serviceDays;
/*     */   }
/*     */   
/*     */   public void setServiceDays(Long argServiceDays) {
/* 134 */     if (changed(argServiceDays, this._serviceDays, "serviceDays")) {
/* 135 */       this._serviceDays = argServiceDays;
/*     */     }
/*     */   }
/*     */   
/*     */   public Boolean getRenewable() {
/* 140 */     return this._renewable;
/*     */   }
/*     */   
/*     */   public void setRenewable(Boolean argRenewable) {
/* 144 */     if (changed(argRenewable, this._renewable, "renewable")) {
/* 145 */       this._renewable = argRenewable;
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public String toString() {
/* 152 */     StringBuilder buf = new StringBuilder(512);
/* 153 */     buf.append(super.toString());
/* 154 */     if (getCreateDate() != null) {
/* 155 */       buf.append("createDate").append("=").append(getCreateDate()).append(" ");
/*     */     }
/* 157 */     if (getCreateUserId() != null) {
/* 158 */       buf.append("createUserId").append("=").append(getCreateUserId()).append(" ");
/*     */     }
/* 160 */     if (getUpdateDate() != null) {
/* 161 */       buf.append("updateDate").append("=").append(getUpdateDate()).append(" ");
/*     */     }
/* 163 */     if (getUpdateUserId() != null) {
/* 164 */       buf.append("updateUserId").append("=").append(getUpdateUserId()).append(" ");
/*     */     }
/* 166 */     if (getPricingMethodCode() != null) {
/* 167 */       buf.append("pricingMethodCode").append("=").append(getPricingMethodCode()).append(" ");
/*     */     }
/* 169 */     if (getWarrantyPriceAmt() != null) {
/* 170 */       buf.append("warrantyPriceAmt").append("=").append(getWarrantyPriceAmt()).append(" ");
/*     */     }
/* 172 */     if (getWarrantyPricePercentage() != null) {
/* 173 */       buf.append("warrantyPricePercentage").append("=").append(getWarrantyPricePercentage()).append(" ");
/*     */     }
/* 175 */     if (getWarrantyMinPriceAmt() != null) {
/* 176 */       buf.append("warrantyMinPriceAmt").append("=").append(getWarrantyMinPriceAmt()).append(" ");
/*     */     }
/* 178 */     if (getExpirationDays() != null) {
/* 179 */       buf.append("expirationDays").append("=").append(getExpirationDays()).append(" ");
/*     */     }
/* 181 */     if (getServiceDays() != null) {
/* 182 */       buf.append("serviceDays").append("=").append(getServiceDays()).append(" ");
/*     */     }
/* 184 */     if (getRenewable() != null && getRenewable().booleanValue()) {
/* 185 */       buf.append("renewable").append("=").append(getRenewable()).append(" ");
/*     */     }
/*     */     
/* 188 */     return buf.toString();
/*     */   }
/*     */ 
/*     */   
/*     */   public String toXmlString() {
/* 193 */     StringBuilder buf = new StringBuilder(2350);
/* 194 */     buf.append("<").append("dao").append(" name=\"WarrantyItem\" cmd=\"" + getObjectStateString() + "\">");
/* 195 */     getFieldsAsXml(buf);
/* 196 */     buf.append("</").append("dao").append(">");
/*     */     
/* 198 */     return buf.toString();
/*     */   }
/*     */   
/*     */   public Map<String, String> getValues() {
/* 202 */     Map<String, String> values = super.getValues();
/* 203 */     if (this._createDate != null) values.put("CreateDate", DaoUtils.getXmlSafeFieldValue(91, this._createDate)); 
/* 204 */     if (this._createUserId != null) values.put("CreateUserId", DaoUtils.getXmlSafeFieldValue(12, this._createUserId)); 
/* 205 */     if (this._updateDate != null) values.put("UpdateDate", DaoUtils.getXmlSafeFieldValue(91, this._updateDate)); 
/* 206 */     if (this._updateUserId != null) values.put("UpdateUserId", DaoUtils.getXmlSafeFieldValue(12, this._updateUserId)); 
/* 207 */     if (this._pricingMethodCode != null) values.put("PricingMethodCode", DaoUtils.getXmlSafeFieldValue(12, this._pricingMethodCode)); 
/* 208 */     if (this._warrantyPriceAmt != null) values.put("WarrantyPriceAmt", DaoUtils.getXmlSafeFieldValue(3, this._warrantyPriceAmt)); 
/* 209 */     if (this._warrantyPricePercentage != null) values.put("WarrantyPricePercentage", DaoUtils.getXmlSafeFieldValue(3, this._warrantyPricePercentage)); 
/* 210 */     if (this._warrantyMinPriceAmt != null) values.put("WarrantyMinPriceAmt", DaoUtils.getXmlSafeFieldValue(3, this._warrantyMinPriceAmt)); 
/* 211 */     if (this._expirationDays != null) values.put("ExpirationDays", DaoUtils.getXmlSafeFieldValue(-5, this._expirationDays)); 
/* 212 */     if (this._serviceDays != null) values.put("ServiceDays", DaoUtils.getXmlSafeFieldValue(-5, this._serviceDays)); 
/* 213 */     if (this._renewable != null) values.put("Renewable", DaoUtils.getXmlSafeFieldValue(-7, this._renewable)); 
/* 214 */     return values;
/*     */   }
/*     */ 
/*     */   
/*     */   public void setValues(Map<String, String> argValues) {
/* 219 */     super.setValues(argValues);
/* 220 */     for (Map.Entry<String, String> field : argValues.entrySet()) {
/*     */       
/* 222 */       String fieldName = field.getKey();
/* 223 */       String fieldValue = field.getValue();
/* 224 */       switch (fieldName) {
/*     */         
/*     */         case "CreateDate":
/*     */           try {
/* 228 */             Object value = DaoUtils.getFieldValueForXmlString(91, fieldValue);
/* 229 */             setCreateDate((Date)value);
/* 230 */           } catch (Exception ee) {
/* 231 */             throw new DtxException("An exception occurred while calling setCreateDate() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "CreateUserId":
/*     */           try {
/* 237 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 238 */             setCreateUserId((String)value);
/* 239 */           } catch (Exception ee) {
/* 240 */             throw new DtxException("An exception occurred while calling setCreateUserId() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "UpdateDate":
/*     */           try {
/* 246 */             Object value = DaoUtils.getFieldValueForXmlString(91, fieldValue);
/* 247 */             setUpdateDate((Date)value);
/* 248 */           } catch (Exception ee) {
/* 249 */             throw new DtxException("An exception occurred while calling setUpdateDate() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "UpdateUserId":
/*     */           try {
/* 255 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 256 */             setUpdateUserId((String)value);
/* 257 */           } catch (Exception ee) {
/* 258 */             throw new DtxException("An exception occurred while calling setUpdateUserId() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "PricingMethodCode":
/*     */           try {
/* 264 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 265 */             setPricingMethodCode((String)value);
/* 266 */           } catch (Exception ee) {
/* 267 */             throw new DtxException("An exception occurred while calling setPricingMethodCode() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "WarrantyPriceAmt":
/*     */           try {
/* 273 */             Object value = DaoUtils.getFieldValueForXmlString(3, fieldValue);
/* 274 */             setWarrantyPriceAmt((BigDecimal)value);
/* 275 */           } catch (Exception ee) {
/* 276 */             throw new DtxException("An exception occurred while calling setWarrantyPriceAmt() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "WarrantyPricePercentage":
/*     */           try {
/* 282 */             Object value = DaoUtils.getFieldValueForXmlString(3, fieldValue);
/* 283 */             setWarrantyPricePercentage((BigDecimal)value);
/* 284 */           } catch (Exception ee) {
/* 285 */             throw new DtxException("An exception occurred while calling setWarrantyPricePercentage() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "WarrantyMinPriceAmt":
/*     */           try {
/* 291 */             Object value = DaoUtils.getFieldValueForXmlString(3, fieldValue);
/* 292 */             setWarrantyMinPriceAmt((BigDecimal)value);
/* 293 */           } catch (Exception ee) {
/* 294 */             throw new DtxException("An exception occurred while calling setWarrantyMinPriceAmt() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "ExpirationDays":
/*     */           try {
/* 300 */             Object value = DaoUtils.getFieldValueForXmlString(-5, fieldValue);
/* 301 */             setExpirationDays((Long)value);
/* 302 */           } catch (Exception ee) {
/* 303 */             throw new DtxException("An exception occurred while calling setExpirationDays() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "ServiceDays":
/*     */           try {
/* 309 */             Object value = DaoUtils.getFieldValueForXmlString(-5, fieldValue);
/* 310 */             setServiceDays((Long)value);
/* 311 */           } catch (Exception ee) {
/* 312 */             throw new DtxException("An exception occurred while calling setServiceDays() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "Renewable":
/*     */           try {
/* 318 */             Object value = DaoUtils.getFieldValueForXmlString(-7, fieldValue);
/* 319 */             setRenewable((Boolean)value);
/* 320 */           } catch (Exception ee) {
/* 321 */             throw new DtxException("An exception occurred while calling setRenewable() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */       } 
/*     */     } 
/*     */   }
/*     */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\itm\impl\WarrantyItemDAO.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */