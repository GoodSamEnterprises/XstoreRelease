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
/*     */ public class DiscountLineItemDAO
/*     */   extends RetailTransactionLineItemDAO
/*     */ {
/*     */   private static final long serialVersionUID = 1289146792L;
/*  23 */   private static final Logger _logger = Logger.getLogger(DiscountLineItemDAO.class);
/*     */   
/*     */   private DtvDate _createDate;
/*     */   private String _createUserId;
/*     */   private DtvDate _updateDate;
/*     */   private String _updateUserId;
/*     */   private BigDecimal _amount;
/*     */   private BigDecimal _percent;
/*     */   private BigDecimal _newPrice;
/*     */   private BigDecimal _newPriceQuantity;
/*     */   private String _serialNumber;
/*     */   private String _discountCode;
/*     */   private String _taxabilityCode;
/*     */   private String _awardTransactionId;
/*     */   
/*     */   public Date getCreateDate() {
/*  39 */     return (Date)this._createDate;
/*     */   }
/*     */   
/*     */   public void setCreateDate(Date argCreateDate) {
/*  43 */     if (changed(argCreateDate, this._createDate, "createDate")) {
/*  44 */       this._createDate = (argCreateDate == null || argCreateDate instanceof DtvDate) ? (DtvDate)argCreateDate : new DtvDate(argCreateDate);
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public String getCreateUserId() {
/*  50 */     return this._createUserId;
/*     */   }
/*     */   
/*     */   public void setCreateUserId(String argCreateUserId) {
/*  54 */     if (changed(argCreateUserId, this._createUserId, "createUserId")) {
/*  55 */       this._createUserId = argCreateUserId;
/*     */     }
/*     */   }
/*     */   
/*     */   public Date getUpdateDate() {
/*  60 */     return (Date)this._updateDate;
/*     */   }
/*     */   
/*     */   public void setUpdateDate(Date argUpdateDate) {
/*  64 */     if (changed(argUpdateDate, this._updateDate, "updateDate")) {
/*  65 */       this._updateDate = (argUpdateDate == null || argUpdateDate instanceof DtvDate) ? (DtvDate)argUpdateDate : new DtvDate(argUpdateDate);
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public String getUpdateUserId() {
/*  71 */     return this._updateUserId;
/*     */   }
/*     */   
/*     */   public void setUpdateUserId(String argUpdateUserId) {
/*  75 */     if (changed(argUpdateUserId, this._updateUserId, "updateUserId")) {
/*  76 */       this._updateUserId = argUpdateUserId;
/*     */     }
/*     */   }
/*     */   
/*     */   public BigDecimal getAmount() {
/*  81 */     return this._amount;
/*     */   }
/*     */   
/*     */   public void setAmount(BigDecimal argAmount) {
/*  85 */     if (changed(argAmount, this._amount, "amount")) {
/*  86 */       this._amount = argAmount;
/*     */     }
/*     */   }
/*     */   
/*     */   public BigDecimal getPercent() {
/*  91 */     return this._percent;
/*     */   }
/*     */   
/*     */   public void setPercent(BigDecimal argPercent) {
/*  95 */     if (changed(argPercent, this._percent, "percent")) {
/*  96 */       this._percent = argPercent;
/*     */     }
/*     */   }
/*     */   
/*     */   public BigDecimal getNewPrice() {
/* 101 */     return this._newPrice;
/*     */   }
/*     */   
/*     */   public void setNewPrice(BigDecimal argNewPrice) {
/* 105 */     if (changed(argNewPrice, this._newPrice, "newPrice")) {
/* 106 */       this._newPrice = argNewPrice;
/*     */     }
/*     */   }
/*     */   
/*     */   public BigDecimal getNewPriceQuantity() {
/* 111 */     return this._newPriceQuantity;
/*     */   }
/*     */   
/*     */   public void setNewPriceQuantity(BigDecimal argNewPriceQuantity) {
/* 115 */     if (changed(argNewPriceQuantity, this._newPriceQuantity, "newPriceQuantity")) {
/* 116 */       this._newPriceQuantity = argNewPriceQuantity;
/*     */     }
/*     */   }
/*     */   
/*     */   public String getSerialNumber() {
/* 121 */     return this._serialNumber;
/*     */   }
/*     */   
/*     */   public void setSerialNumber(String argSerialNumber) {
/* 125 */     if (changed(argSerialNumber, this._serialNumber, "serialNumber")) {
/* 126 */       this._serialNumber = argSerialNumber;
/*     */     }
/*     */   }
/*     */   
/*     */   public String getDiscountCode() {
/* 131 */     return this._discountCode;
/*     */   }
/*     */   
/*     */   public void setDiscountCode(String argDiscountCode) {
/* 135 */     if (changed(argDiscountCode, this._discountCode, "discountCode")) {
/* 136 */       this._discountCode = argDiscountCode;
/*     */     }
/*     */   }
/*     */   
/*     */   public String getTaxabilityCode() {
/* 141 */     return this._taxabilityCode;
/*     */   }
/*     */   
/*     */   public void setTaxabilityCode(String argTaxabilityCode) {
/* 145 */     if (changed(argTaxabilityCode, this._taxabilityCode, "taxabilityCode")) {
/* 146 */       this._taxabilityCode = argTaxabilityCode;
/*     */     }
/*     */   }
/*     */   
/*     */   public String getAwardTransactionId() {
/* 151 */     return this._awardTransactionId;
/*     */   }
/*     */   
/*     */   public void setAwardTransactionId(String argAwardTransactionId) {
/* 155 */     if (changed(argAwardTransactionId, this._awardTransactionId, "awardTransactionId")) {
/* 156 */       this._awardTransactionId = argAwardTransactionId;
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public String toString() {
/* 163 */     StringBuilder buf = new StringBuilder(512);
/* 164 */     buf.append(super.toString());
/* 165 */     if (getCreateDate() != null) {
/* 166 */       buf.append("createDate").append("=").append(getCreateDate()).append(" ");
/*     */     }
/* 168 */     if (getCreateUserId() != null) {
/* 169 */       buf.append("createUserId").append("=").append(getCreateUserId()).append(" ");
/*     */     }
/* 171 */     if (getUpdateDate() != null) {
/* 172 */       buf.append("updateDate").append("=").append(getUpdateDate()).append(" ");
/*     */     }
/* 174 */     if (getUpdateUserId() != null) {
/* 175 */       buf.append("updateUserId").append("=").append(getUpdateUserId()).append(" ");
/*     */     }
/* 177 */     if (getAmount() != null) {
/* 178 */       buf.append("amount").append("=").append(getAmount()).append(" ");
/*     */     }
/* 180 */     if (getPercent() != null) {
/* 181 */       buf.append("percent").append("=").append(getPercent()).append(" ");
/*     */     }
/* 183 */     if (getNewPrice() != null) {
/* 184 */       buf.append("newPrice").append("=").append(getNewPrice()).append(" ");
/*     */     }
/* 186 */     if (getNewPriceQuantity() != null) {
/* 187 */       buf.append("newPriceQuantity").append("=").append(getNewPriceQuantity()).append(" ");
/*     */     }
/* 189 */     if (getSerialNumber() != null) {
/* 190 */       buf.append("serialNumber").append("=").append(getSerialNumber()).append(" ");
/*     */     }
/* 192 */     if (getDiscountCode() != null) {
/* 193 */       buf.append("discountCode").append("=").append(getDiscountCode()).append(" ");
/*     */     }
/* 195 */     if (getTaxabilityCode() != null) {
/* 196 */       buf.append("taxabilityCode").append("=").append(getTaxabilityCode()).append(" ");
/*     */     }
/* 198 */     if (getAwardTransactionId() != null) {
/* 199 */       buf.append("awardTransactionId").append("=").append(getAwardTransactionId()).append(" ");
/*     */     }
/*     */     
/* 202 */     return buf.toString();
/*     */   }
/*     */ 
/*     */   
/*     */   public String toXmlString() {
/* 207 */     StringBuilder buf = new StringBuilder(1650);
/* 208 */     buf.append("<").append("dao").append(" name=\"DiscountLineItem\" cmd=\"" + getObjectStateString() + "\">");
/* 209 */     getFieldsAsXml(buf);
/* 210 */     buf.append("</").append("dao").append(">");
/*     */     
/* 212 */     return buf.toString();
/*     */   }
/*     */   
/*     */   public Map<String, String> getValues() {
/* 216 */     Map<String, String> values = super.getValues();
/* 217 */     if (this._createDate != null) values.put("CreateDate", DaoUtils.getXmlSafeFieldValue(91, this._createDate)); 
/* 218 */     if (this._createUserId != null) values.put("CreateUserId", DaoUtils.getXmlSafeFieldValue(12, this._createUserId)); 
/* 219 */     if (this._updateDate != null) values.put("UpdateDate", DaoUtils.getXmlSafeFieldValue(91, this._updateDate)); 
/* 220 */     if (this._updateUserId != null) values.put("UpdateUserId", DaoUtils.getXmlSafeFieldValue(12, this._updateUserId)); 
/* 221 */     if (this._amount != null) values.put("Amount", DaoUtils.getXmlSafeFieldValue(3, this._amount)); 
/* 222 */     if (this._percent != null) values.put("Percent", DaoUtils.getXmlSafeFieldValue(3, this._percent)); 
/* 223 */     if (this._newPrice != null) values.put("NewPrice", DaoUtils.getXmlSafeFieldValue(3, this._newPrice)); 
/* 224 */     if (this._newPriceQuantity != null) values.put("NewPriceQuantity", DaoUtils.getXmlSafeFieldValue(3, this._newPriceQuantity)); 
/* 225 */     if (this._serialNumber != null) values.put("SerialNumber", DaoUtils.getXmlSafeFieldValue(12, this._serialNumber)); 
/* 226 */     if (this._discountCode != null) values.put("DiscountCode", DaoUtils.getXmlSafeFieldValue(12, this._discountCode)); 
/* 227 */     if (this._taxabilityCode != null) values.put("TaxabilityCode", DaoUtils.getXmlSafeFieldValue(12, this._taxabilityCode)); 
/* 228 */     if (this._awardTransactionId != null) values.put("AwardTransactionId", DaoUtils.getXmlSafeFieldValue(12, this._awardTransactionId)); 
/* 229 */     return values;
/*     */   }
/*     */ 
/*     */   
/*     */   public void setValues(Map<String, String> argValues) {
/* 234 */     super.setValues(argValues);
/* 235 */     for (Map.Entry<String, String> field : argValues.entrySet()) {
/*     */       
/* 237 */       String fieldName = field.getKey();
/* 238 */       String fieldValue = field.getValue();
/* 239 */       switch (fieldName) {
/*     */         
/*     */         case "CreateDate":
/*     */           try {
/* 243 */             Object value = DaoUtils.getFieldValueForXmlString(91, fieldValue);
/* 244 */             setCreateDate((Date)value);
/* 245 */           } catch (Exception ee) {
/* 246 */             throw new DtxException("An exception occurred while calling setCreateDate() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "CreateUserId":
/*     */           try {
/* 252 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 253 */             setCreateUserId((String)value);
/* 254 */           } catch (Exception ee) {
/* 255 */             throw new DtxException("An exception occurred while calling setCreateUserId() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "UpdateDate":
/*     */           try {
/* 261 */             Object value = DaoUtils.getFieldValueForXmlString(91, fieldValue);
/* 262 */             setUpdateDate((Date)value);
/* 263 */           } catch (Exception ee) {
/* 264 */             throw new DtxException("An exception occurred while calling setUpdateDate() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "UpdateUserId":
/*     */           try {
/* 270 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 271 */             setUpdateUserId((String)value);
/* 272 */           } catch (Exception ee) {
/* 273 */             throw new DtxException("An exception occurred while calling setUpdateUserId() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "Amount":
/*     */           try {
/* 279 */             Object value = DaoUtils.getFieldValueForXmlString(3, fieldValue);
/* 280 */             setAmount((BigDecimal)value);
/* 281 */           } catch (Exception ee) {
/* 282 */             throw new DtxException("An exception occurred while calling setAmount() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "Percent":
/*     */           try {
/* 288 */             Object value = DaoUtils.getFieldValueForXmlString(3, fieldValue);
/* 289 */             setPercent((BigDecimal)value);
/* 290 */           } catch (Exception ee) {
/* 291 */             throw new DtxException("An exception occurred while calling setPercent() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "NewPrice":
/*     */           try {
/* 297 */             Object value = DaoUtils.getFieldValueForXmlString(3, fieldValue);
/* 298 */             setNewPrice((BigDecimal)value);
/* 299 */           } catch (Exception ee) {
/* 300 */             throw new DtxException("An exception occurred while calling setNewPrice() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "NewPriceQuantity":
/*     */           try {
/* 306 */             Object value = DaoUtils.getFieldValueForXmlString(3, fieldValue);
/* 307 */             setNewPriceQuantity((BigDecimal)value);
/* 308 */           } catch (Exception ee) {
/* 309 */             throw new DtxException("An exception occurred while calling setNewPriceQuantity() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "SerialNumber":
/*     */           try {
/* 315 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 316 */             setSerialNumber((String)value);
/* 317 */           } catch (Exception ee) {
/* 318 */             throw new DtxException("An exception occurred while calling setSerialNumber() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "DiscountCode":
/*     */           try {
/* 324 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 325 */             setDiscountCode((String)value);
/* 326 */           } catch (Exception ee) {
/* 327 */             throw new DtxException("An exception occurred while calling setDiscountCode() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "TaxabilityCode":
/*     */           try {
/* 333 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 334 */             setTaxabilityCode((String)value);
/* 335 */           } catch (Exception ee) {
/* 336 */             throw new DtxException("An exception occurred while calling setTaxabilityCode() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "AwardTransactionId":
/*     */           try {
/* 342 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 343 */             setAwardTransactionId((String)value);
/* 344 */           } catch (Exception ee) {
/* 345 */             throw new DtxException("An exception occurred while calling setAwardTransactionId() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */       } 
/*     */     } 
/*     */   }
/*     */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\trl\impl\DiscountLineItemDAO.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */