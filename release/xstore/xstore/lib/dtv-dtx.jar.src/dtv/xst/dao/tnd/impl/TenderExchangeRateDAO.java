/*     */ package dtv.xst.dao.tnd.impl;
/*     */ 
/*     */ import dtv.data2.access.DaoUtils;
/*     */ import dtv.data2.access.IObjectId;
/*     */ import dtv.data2.access.exception.DtxException;
/*     */ import dtv.data2.access.impl.AbstractDAOImpl;
/*     */ import dtv.util.DtvDate;
/*     */ import dtv.xst.dao.tnd.TenderExchangeRateId;
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
/*     */ public class TenderExchangeRateDAO
/*     */   extends AbstractDAOImpl
/*     */ {
/*     */   private static final long serialVersionUID = 186706615L;
/*  23 */   private static final Logger _logger = Logger.getLogger(TenderExchangeRateDAO.class);
/*     */   
/*     */   private Long _organizationId;
/*     */   private String _baseCurrency;
/*     */   private String _targetCurrency;
/*     */   private String _levelCode;
/*     */   private String _levelValue;
/*     */   private DtvDate _createDate;
/*     */   private String _createUserId;
/*     */   private DtvDate _updateDate;
/*     */   private String _updateUserId;
/*     */   private BigDecimal _exchangeRate;
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
/*     */   public String getBaseCurrency() {
/*  47 */     return this._baseCurrency;
/*     */   }
/*     */   
/*     */   public void setBaseCurrency(String argBaseCurrency) {
/*  51 */     if (changed(argBaseCurrency, this._baseCurrency, "baseCurrency")) {
/*  52 */       this._baseCurrency = (argBaseCurrency != null && MANAGE_CASE) ? argBaseCurrency.toUpperCase() : argBaseCurrency;
/*     */     }
/*     */   }
/*     */   
/*     */   public String getTargetCurrency() {
/*  57 */     return this._targetCurrency;
/*     */   }
/*     */   
/*     */   public void setTargetCurrency(String argTargetCurrency) {
/*  61 */     if (changed(argTargetCurrency, this._targetCurrency, "targetCurrency")) {
/*  62 */       this._targetCurrency = (argTargetCurrency != null && MANAGE_CASE) ? argTargetCurrency.toUpperCase() : argTargetCurrency;
/*     */     }
/*     */   }
/*     */   
/*     */   public String getLevelCode() {
/*  67 */     return this._levelCode;
/*     */   }
/*     */   
/*     */   public void setLevelCode(String argLevelCode) {
/*  71 */     if (changed(argLevelCode, this._levelCode, "levelCode")) {
/*  72 */       this._levelCode = (argLevelCode != null && MANAGE_CASE) ? argLevelCode.toUpperCase() : argLevelCode;
/*     */     }
/*     */   }
/*     */   
/*     */   public String getLevelValue() {
/*  77 */     return this._levelValue;
/*     */   }
/*     */   
/*     */   public void setLevelValue(String argLevelValue) {
/*  81 */     if (changed(argLevelValue, this._levelValue, "levelValue")) {
/*  82 */       this._levelValue = (argLevelValue != null && MANAGE_CASE) ? argLevelValue.toUpperCase() : argLevelValue;
/*     */     }
/*     */   }
/*     */   
/*     */   public Date getCreateDate() {
/*  87 */     return (Date)this._createDate;
/*     */   }
/*     */   
/*     */   public void setCreateDate(Date argCreateDate) {
/*  91 */     if (changed(argCreateDate, this._createDate, "createDate")) {
/*  92 */       this._createDate = (argCreateDate == null || argCreateDate instanceof DtvDate) ? (DtvDate)argCreateDate : new DtvDate(argCreateDate);
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public String getCreateUserId() {
/*  98 */     return this._createUserId;
/*     */   }
/*     */   
/*     */   public void setCreateUserId(String argCreateUserId) {
/* 102 */     if (changed(argCreateUserId, this._createUserId, "createUserId")) {
/* 103 */       this._createUserId = argCreateUserId;
/*     */     }
/*     */   }
/*     */   
/*     */   public Date getUpdateDate() {
/* 108 */     return (Date)this._updateDate;
/*     */   }
/*     */   
/*     */   public void setUpdateDate(Date argUpdateDate) {
/* 112 */     if (changed(argUpdateDate, this._updateDate, "updateDate")) {
/* 113 */       this._updateDate = (argUpdateDate == null || argUpdateDate instanceof DtvDate) ? (DtvDate)argUpdateDate : new DtvDate(argUpdateDate);
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public String getUpdateUserId() {
/* 119 */     return this._updateUserId;
/*     */   }
/*     */   
/*     */   public void setUpdateUserId(String argUpdateUserId) {
/* 123 */     if (changed(argUpdateUserId, this._updateUserId, "updateUserId")) {
/* 124 */       this._updateUserId = argUpdateUserId;
/*     */     }
/*     */   }
/*     */   
/*     */   public BigDecimal getExchangeRate() {
/* 129 */     return this._exchangeRate;
/*     */   }
/*     */   
/*     */   public void setExchangeRate(BigDecimal argExchangeRate) {
/* 133 */     if (changed(argExchangeRate, this._exchangeRate, "exchangeRate")) {
/* 134 */       this._exchangeRate = argExchangeRate;
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public String toString() {
/* 141 */     StringBuilder buf = new StringBuilder(512);
/* 142 */     buf.append(super.toString()).append(" Id: ").append(getObjectId()).append(" Values: ");
/* 143 */     if (getOrganizationId() != null) {
/* 144 */       buf.append("organizationId").append("=").append(getOrganizationId()).append(" ");
/*     */     }
/* 146 */     if (getBaseCurrency() != null) {
/* 147 */       buf.append("baseCurrency").append("=").append(getBaseCurrency()).append(" ");
/*     */     }
/* 149 */     if (getTargetCurrency() != null) {
/* 150 */       buf.append("targetCurrency").append("=").append(getTargetCurrency()).append(" ");
/*     */     }
/* 152 */     if (getLevelCode() != null) {
/* 153 */       buf.append("levelCode").append("=").append(getLevelCode()).append(" ");
/*     */     }
/* 155 */     if (getLevelValue() != null) {
/* 156 */       buf.append("levelValue").append("=").append(getLevelValue()).append(" ");
/*     */     }
/* 158 */     if (getCreateDate() != null) {
/* 159 */       buf.append("createDate").append("=").append(getCreateDate()).append(" ");
/*     */     }
/* 161 */     if (getCreateUserId() != null) {
/* 162 */       buf.append("createUserId").append("=").append(getCreateUserId()).append(" ");
/*     */     }
/* 164 */     if (getUpdateDate() != null) {
/* 165 */       buf.append("updateDate").append("=").append(getUpdateDate()).append(" ");
/*     */     }
/* 167 */     if (getUpdateUserId() != null) {
/* 168 */       buf.append("updateUserId").append("=").append(getUpdateUserId()).append(" ");
/*     */     }
/* 170 */     if (getExchangeRate() != null) {
/* 171 */       buf.append("exchangeRate").append("=").append(getExchangeRate()).append(" ");
/*     */     }
/*     */     
/* 174 */     return buf.toString();
/*     */   }
/*     */   
/*     */   public IObjectId getObjectId() {
/* 178 */     TenderExchangeRateId id = new TenderExchangeRateId();
/* 179 */     id.setOrganizationId(getOrganizationId());
/* 180 */     id.setBaseCurrency(getBaseCurrency());
/* 181 */     id.setTargetCurrency(getTargetCurrency());
/* 182 */     id.setLevelCode(getLevelCode());
/* 183 */     id.setLevelValue(getLevelValue());
/* 184 */     return (IObjectId)id;
/*     */   }
/*     */   
/*     */   public void setObjectId(IObjectId argObjectId) {
/* 188 */     setOrganizationId(((TenderExchangeRateId)argObjectId).getOrganizationId());
/* 189 */     setBaseCurrency(((TenderExchangeRateId)argObjectId).getBaseCurrency());
/* 190 */     setTargetCurrency(((TenderExchangeRateId)argObjectId).getTargetCurrency());
/* 191 */     setLevelCode(((TenderExchangeRateId)argObjectId).getLevelCode());
/* 192 */     setLevelValue(((TenderExchangeRateId)argObjectId).getLevelValue());
/*     */   }
/*     */   
/*     */   public String getImplementingClass() {
/* 196 */     return null;
/*     */   }
/*     */   
/*     */   public String toXmlString() {
/* 200 */     StringBuilder buf = new StringBuilder(500);
/* 201 */     buf.append("<").append("dao").append(" name=\"TenderExchangeRate\" cmd=\"" + getObjectStateString() + "\">");
/* 202 */     getFieldsAsXml(buf);
/* 203 */     buf.append("</").append("dao").append(">");
/*     */     
/* 205 */     return buf.toString();
/*     */   }
/*     */   
/*     */   public Map<String, String> getValues() {
/* 209 */     Map<String, String> values = super.getValues();
/* 210 */     if (this._organizationId != null) values.put("OrganizationId", DaoUtils.getXmlSafeFieldValue(-5, this._organizationId)); 
/* 211 */     if (this._baseCurrency != null) values.put("BaseCurrency", DaoUtils.getXmlSafeFieldValue(12, this._baseCurrency)); 
/* 212 */     if (this._targetCurrency != null) values.put("TargetCurrency", DaoUtils.getXmlSafeFieldValue(12, this._targetCurrency)); 
/* 213 */     if (this._levelCode != null) values.put("LevelCode", DaoUtils.getXmlSafeFieldValue(12, this._levelCode)); 
/* 214 */     if (this._levelValue != null) values.put("LevelValue", DaoUtils.getXmlSafeFieldValue(12, this._levelValue)); 
/* 215 */     if (this._createDate != null) values.put("CreateDate", DaoUtils.getXmlSafeFieldValue(91, this._createDate)); 
/* 216 */     if (this._createUserId != null) values.put("CreateUserId", DaoUtils.getXmlSafeFieldValue(12, this._createUserId)); 
/* 217 */     if (this._updateDate != null) values.put("UpdateDate", DaoUtils.getXmlSafeFieldValue(91, this._updateDate)); 
/* 218 */     if (this._updateUserId != null) values.put("UpdateUserId", DaoUtils.getXmlSafeFieldValue(12, this._updateUserId)); 
/* 219 */     if (this._exchangeRate != null) values.put("ExchangeRate", DaoUtils.getXmlSafeFieldValue(3, this._exchangeRate)); 
/* 220 */     return values;
/*     */   }
/*     */ 
/*     */   
/*     */   public void setValues(Map<String, String> argValues) {
/* 225 */     super.setValues(argValues);
/* 226 */     for (Map.Entry<String, String> field : argValues.entrySet()) {
/*     */       
/* 228 */       String fieldName = field.getKey();
/* 229 */       String fieldValue = field.getValue();
/* 230 */       switch (fieldName) {
/*     */         
/*     */         case "OrganizationId":
/*     */           try {
/* 234 */             Object value = DaoUtils.getFieldValueForXmlString(-5, fieldValue);
/* 235 */             setOrganizationId((Long)value);
/* 236 */           } catch (Exception ee) {
/* 237 */             throw new DtxException("An exception occurred while calling setOrganizationId() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "BaseCurrency":
/*     */           try {
/* 243 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 244 */             setBaseCurrency((String)value);
/* 245 */           } catch (Exception ee) {
/* 246 */             throw new DtxException("An exception occurred while calling setBaseCurrency() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "TargetCurrency":
/*     */           try {
/* 252 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 253 */             setTargetCurrency((String)value);
/* 254 */           } catch (Exception ee) {
/* 255 */             throw new DtxException("An exception occurred while calling setTargetCurrency() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "LevelCode":
/*     */           try {
/* 261 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 262 */             setLevelCode((String)value);
/* 263 */           } catch (Exception ee) {
/* 264 */             throw new DtxException("An exception occurred while calling setLevelCode() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "LevelValue":
/*     */           try {
/* 270 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 271 */             setLevelValue((String)value);
/* 272 */           } catch (Exception ee) {
/* 273 */             throw new DtxException("An exception occurred while calling setLevelValue() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "CreateDate":
/*     */           try {
/* 279 */             Object value = DaoUtils.getFieldValueForXmlString(91, fieldValue);
/* 280 */             setCreateDate((Date)value);
/* 281 */           } catch (Exception ee) {
/* 282 */             throw new DtxException("An exception occurred while calling setCreateDate() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "CreateUserId":
/*     */           try {
/* 288 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 289 */             setCreateUserId((String)value);
/* 290 */           } catch (Exception ee) {
/* 291 */             throw new DtxException("An exception occurred while calling setCreateUserId() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "UpdateDate":
/*     */           try {
/* 297 */             Object value = DaoUtils.getFieldValueForXmlString(91, fieldValue);
/* 298 */             setUpdateDate((Date)value);
/* 299 */           } catch (Exception ee) {
/* 300 */             throw new DtxException("An exception occurred while calling setUpdateDate() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "UpdateUserId":
/*     */           try {
/* 306 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 307 */             setUpdateUserId((String)value);
/* 308 */           } catch (Exception ee) {
/* 309 */             throw new DtxException("An exception occurred while calling setUpdateUserId() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "ExchangeRate":
/*     */           try {
/* 315 */             Object value = DaoUtils.getFieldValueForXmlString(3, fieldValue);
/* 316 */             setExchangeRate((BigDecimal)value);
/* 317 */           } catch (Exception ee) {
/* 318 */             throw new DtxException("An exception occurred while calling setExchangeRate() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */       } 
/*     */     } 
/*     */   }
/*     */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\tnd\impl\TenderExchangeRateDAO.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */