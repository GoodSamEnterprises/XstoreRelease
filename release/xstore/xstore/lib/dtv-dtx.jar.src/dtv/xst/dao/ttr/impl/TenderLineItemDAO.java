/*     */ package dtv.xst.dao.ttr.impl;
/*     */ 
/*     */ import dtv.data2.access.DaoUtils;
/*     */ import dtv.data2.access.exception.DtxException;
/*     */ import dtv.util.DtvDate;
/*     */ import dtv.xst.dao.trl.impl.RetailTransactionLineItemDAO;
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
/*     */ public class TenderLineItemDAO
/*     */   extends RetailTransactionLineItemDAO
/*     */ {
/*     */   private static final long serialVersionUID = 1615107131L;
/*  23 */   private static final Logger _logger = Logger.getLogger(TenderLineItemDAO.class);
/*     */   
/*     */   private DtvDate _createDate;
/*     */   private String _createUserId;
/*     */   private DtvDate _updateDate;
/*     */   private String _updateUserId;
/*     */   private BigDecimal _amount;
/*  30 */   private Boolean _change = Boolean.FALSE;
/*  31 */   private Boolean _hostValidation = Boolean.FALSE;
/*     */   private String _serialNumber;
/*     */   private String _tenderId;
/*     */   private String _tenderStatusCode;
/*     */   private BigDecimal _exchangeRate;
/*     */   private BigDecimal _foreignAmount;
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
/*     */   public Boolean getChange() {
/*  91 */     return this._change;
/*     */   }
/*     */   
/*     */   public void setChange(Boolean argChange) {
/*  95 */     if (changed(argChange, this._change, "change")) {
/*  96 */       this._change = argChange;
/*     */     }
/*     */   }
/*     */   
/*     */   public Boolean getHostValidation() {
/* 101 */     return this._hostValidation;
/*     */   }
/*     */   
/*     */   public void setHostValidation(Boolean argHostValidation) {
/* 105 */     if (changed(argHostValidation, this._hostValidation, "hostValidation")) {
/* 106 */       this._hostValidation = argHostValidation;
/*     */     }
/*     */   }
/*     */   
/*     */   public String getSerialNumber() {
/* 111 */     return this._serialNumber;
/*     */   }
/*     */   
/*     */   public void setSerialNumber(String argSerialNumber) {
/* 115 */     if (changed(argSerialNumber, this._serialNumber, "serialNumber")) {
/* 116 */       this._serialNumber = argSerialNumber;
/*     */     }
/*     */   }
/*     */   
/*     */   public String getTenderId() {
/* 121 */     return this._tenderId;
/*     */   }
/*     */   
/*     */   public void setTenderId(String argTenderId) {
/* 125 */     if (changed(argTenderId, this._tenderId, "tenderId")) {
/* 126 */       this._tenderId = argTenderId;
/*     */     }
/*     */   }
/*     */   
/*     */   public String getTenderStatusCode() {
/* 131 */     return this._tenderStatusCode;
/*     */   }
/*     */   
/*     */   public void setTenderStatusCode(String argTenderStatusCode) {
/* 135 */     if (changed(argTenderStatusCode, this._tenderStatusCode, "tenderStatusCode")) {
/* 136 */       this._tenderStatusCode = argTenderStatusCode;
/*     */     }
/*     */   }
/*     */   
/*     */   public BigDecimal getExchangeRate() {
/* 141 */     return this._exchangeRate;
/*     */   }
/*     */   
/*     */   public void setExchangeRate(BigDecimal argExchangeRate) {
/* 145 */     if (changed(argExchangeRate, this._exchangeRate, "exchangeRate")) {
/* 146 */       this._exchangeRate = argExchangeRate;
/*     */     }
/*     */   }
/*     */   
/*     */   public BigDecimal getForeignAmount() {
/* 151 */     return this._foreignAmount;
/*     */   }
/*     */   
/*     */   public void setForeignAmount(BigDecimal argForeignAmount) {
/* 155 */     if (changed(argForeignAmount, this._foreignAmount, "foreignAmount")) {
/* 156 */       this._foreignAmount = argForeignAmount;
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
/* 180 */     if (getChange() != null && getChange().booleanValue()) {
/* 181 */       buf.append("change").append("=").append(getChange()).append(" ");
/*     */     }
/* 183 */     if (getHostValidation() != null && getHostValidation().booleanValue()) {
/* 184 */       buf.append("hostValidation").append("=").append(getHostValidation()).append(" ");
/*     */     }
/* 186 */     if (getSerialNumber() != null) {
/* 187 */       buf.append("serialNumber").append("=").append("[REDACTED]").append(" ");
/*     */     }
/* 189 */     if (getTenderId() != null) {
/* 190 */       buf.append("tenderId").append("=").append(getTenderId()).append(" ");
/*     */     }
/* 192 */     if (getTenderStatusCode() != null) {
/* 193 */       buf.append("tenderStatusCode").append("=").append(getTenderStatusCode()).append(" ");
/*     */     }
/* 195 */     if (getExchangeRate() != null) {
/* 196 */       buf.append("exchangeRate").append("=").append(getExchangeRate()).append(" ");
/*     */     }
/* 198 */     if (getForeignAmount() != null) {
/* 199 */       buf.append("foreignAmount").append("=").append(getForeignAmount()).append(" ");
/*     */     }
/*     */     
/* 202 */     return buf.toString();
/*     */   }
/*     */ 
/*     */   
/*     */   public String toXmlString() {
/* 207 */     StringBuilder buf = new StringBuilder(1650);
/* 208 */     buf.append("<").append("dao").append(" name=\"TenderLineItem\" cmd=\"" + getObjectStateString() + "\">");
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
/* 222 */     if (this._change != null) values.put("Change", DaoUtils.getXmlSafeFieldValue(-7, this._change)); 
/* 223 */     if (this._hostValidation != null) values.put("HostValidation", DaoUtils.getXmlSafeFieldValue(-7, this._hostValidation)); 
/* 224 */     if (this._serialNumber != null) values.put("SerialNumber", DaoUtils.getXmlSafeFieldValue(12, this._serialNumber)); 
/* 225 */     if (this._tenderId != null) values.put("TenderId", DaoUtils.getXmlSafeFieldValue(12, this._tenderId)); 
/* 226 */     if (this._tenderStatusCode != null) values.put("TenderStatusCode", DaoUtils.getXmlSafeFieldValue(12, this._tenderStatusCode)); 
/* 227 */     if (this._exchangeRate != null) values.put("ExchangeRate", DaoUtils.getXmlSafeFieldValue(3, this._exchangeRate)); 
/* 228 */     if (this._foreignAmount != null) values.put("ForeignAmount", DaoUtils.getXmlSafeFieldValue(3, this._foreignAmount)); 
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
/*     */         case "Change":
/*     */           try {
/* 288 */             Object value = DaoUtils.getFieldValueForXmlString(-7, fieldValue);
/* 289 */             setChange((Boolean)value);
/* 290 */           } catch (Exception ee) {
/* 291 */             throw new DtxException("An exception occurred while calling setChange() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "HostValidation":
/*     */           try {
/* 297 */             Object value = DaoUtils.getFieldValueForXmlString(-7, fieldValue);
/* 298 */             setHostValidation((Boolean)value);
/* 299 */           } catch (Exception ee) {
/* 300 */             throw new DtxException("An exception occurred while calling setHostValidation() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "SerialNumber":
/*     */           try {
/* 306 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 307 */             setSerialNumber((String)value);
/* 308 */           } catch (Exception ee) {
/* 309 */             throw new DtxException("An exception occurred while calling setSerialNumber() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "TenderId":
/*     */           try {
/* 315 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 316 */             setTenderId((String)value);
/* 317 */           } catch (Exception ee) {
/* 318 */             throw new DtxException("An exception occurred while calling setTenderId() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "TenderStatusCode":
/*     */           try {
/* 324 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 325 */             setTenderStatusCode((String)value);
/* 326 */           } catch (Exception ee) {
/* 327 */             throw new DtxException("An exception occurred while calling setTenderStatusCode() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "ExchangeRate":
/*     */           try {
/* 333 */             Object value = DaoUtils.getFieldValueForXmlString(3, fieldValue);
/* 334 */             setExchangeRate((BigDecimal)value);
/* 335 */           } catch (Exception ee) {
/* 336 */             throw new DtxException("An exception occurred while calling setExchangeRate() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "ForeignAmount":
/*     */           try {
/* 342 */             Object value = DaoUtils.getFieldValueForXmlString(3, fieldValue);
/* 343 */             setForeignAmount((BigDecimal)value);
/* 344 */           } catch (Exception ee) {
/* 345 */             throw new DtxException("An exception occurred while calling setForeignAmount() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */       } 
/*     */     } 
/*     */   }
/*     */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\ttr\impl\TenderLineItemDAO.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */