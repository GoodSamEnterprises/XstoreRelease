/*     */ package dtv.xst.dao.com.impl;
/*     */ 
/*     */ import dtv.data2.access.DaoUtils;
/*     */ import dtv.data2.access.IHasConfigElement;
/*     */ import dtv.data2.access.IObjectId;
/*     */ import dtv.data2.access.exception.DtxException;
/*     */ import dtv.data2.access.impl.AbstractDAOImpl;
/*     */ import dtv.util.DtvDate;
/*     */ import dtv.xst.dao.com.ReceiptTextPropertyId;
/*     */ import java.math.BigDecimal;
/*     */ import java.util.Date;
/*     */ import java.util.Map;
/*     */ import org.apache.log4j.Logger;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class ReceiptTextPropertyDAO
/*     */   extends AbstractDAOImpl
/*     */   implements IHasConfigElement
/*     */ {
/*     */   private static final long serialVersionUID = 476120154L;
/*  23 */   private static final Logger _logger = Logger.getLogger(ReceiptTextPropertyDAO.class);
/*     */   
/*     */   private Long _organizationId;
/*     */   private String _textCode;
/*     */   private Integer _textSequence;
/*     */   private String _textSubcode;
/*     */   private String _configElement;
/*     */   private String _propertyCode;
/*     */   private String _type;
/*     */   private String _stringValue;
/*     */   private DtvDate _dateValue;
/*     */   private BigDecimal _decimalValue;
/*     */   private DtvDate _createDate;
/*     */   private String _createUserId;
/*     */   private DtvDate _updateDate;
/*     */   private String _updateUserId;
/*     */   
/*     */   public Long getOrganizationId() {
/*  41 */     return this._organizationId;
/*     */   }
/*     */   
/*     */   public void setOrganizationId(Long argOrganizationId) {
/*  45 */     if (changed(argOrganizationId, this._organizationId, "organizationId")) {
/*  46 */       this._organizationId = argOrganizationId;
/*     */     }
/*     */   }
/*     */   
/*     */   public String getTextCode() {
/*  51 */     return this._textCode;
/*     */   }
/*     */   
/*     */   public void setTextCode(String argTextCode) {
/*  55 */     if (changed(argTextCode, this._textCode, "textCode")) {
/*  56 */       this._textCode = (argTextCode != null && MANAGE_CASE) ? argTextCode.toUpperCase() : argTextCode;
/*     */     }
/*     */   }
/*     */   
/*     */   public Integer getTextSequence() {
/*  61 */     return this._textSequence;
/*     */   }
/*     */   
/*     */   public void setTextSequence(Integer argTextSequence) {
/*  65 */     if (changed(argTextSequence, this._textSequence, "textSequence")) {
/*  66 */       this._textSequence = argTextSequence;
/*     */     }
/*     */   }
/*     */   
/*     */   public String getTextSubcode() {
/*  71 */     return this._textSubcode;
/*     */   }
/*     */   
/*     */   public void setTextSubcode(String argTextSubcode) {
/*  75 */     if (changed(argTextSubcode, this._textSubcode, "textSubcode")) {
/*  76 */       this._textSubcode = (argTextSubcode != null && MANAGE_CASE) ? argTextSubcode.toUpperCase() : argTextSubcode;
/*     */     }
/*     */   }
/*     */   
/*     */   public String getConfigElement() {
/*  81 */     return this._configElement;
/*     */   }
/*     */   
/*     */   public void setConfigElement(String argConfigElement) {
/*  85 */     if (changed(argConfigElement, this._configElement, "configElement")) {
/*  86 */       this._configElement = (argConfigElement != null && MANAGE_CASE) ? argConfigElement.toUpperCase() : argConfigElement;
/*     */     }
/*     */   }
/*     */   
/*     */   public String getPropertyCode() {
/*  91 */     return this._propertyCode;
/*     */   }
/*     */   
/*     */   public void setPropertyCode(String argPropertyCode) {
/*  95 */     if (changed(argPropertyCode, this._propertyCode, "propertyCode")) {
/*  96 */       this._propertyCode = (argPropertyCode != null && MANAGE_CASE) ? argPropertyCode.toUpperCase() : argPropertyCode;
/*     */     }
/*     */   }
/*     */   
/*     */   public String getType() {
/* 101 */     return this._type;
/*     */   }
/*     */   
/*     */   public void setType(String argType) {
/* 105 */     if (changed(argType, this._type, "type")) {
/* 106 */       this._type = argType;
/*     */     }
/*     */   }
/*     */   
/*     */   public String getStringValue() {
/* 111 */     return this._stringValue;
/*     */   }
/*     */   
/*     */   public void setStringValue(String argStringValue) {
/* 115 */     if (changed(argStringValue, this._stringValue, "stringValue")) {
/* 116 */       this._stringValue = argStringValue;
/*     */     }
/*     */   }
/*     */   
/*     */   public Date getDateValue() {
/* 121 */     return (Date)this._dateValue;
/*     */   }
/*     */   
/*     */   public void setDateValue(Date argDateValue) {
/* 125 */     if (changed(argDateValue, this._dateValue, "dateValue")) {
/* 126 */       this._dateValue = (argDateValue == null || argDateValue instanceof DtvDate) ? (DtvDate)argDateValue : new DtvDate(argDateValue);
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public BigDecimal getDecimalValue() {
/* 132 */     return this._decimalValue;
/*     */   }
/*     */   
/*     */   public void setDecimalValue(BigDecimal argDecimalValue) {
/* 136 */     if (changed(argDecimalValue, this._decimalValue, "decimalValue")) {
/* 137 */       this._decimalValue = argDecimalValue;
/*     */     }
/*     */   }
/*     */   
/*     */   public Date getCreateDate() {
/* 142 */     return (Date)this._createDate;
/*     */   }
/*     */   
/*     */   public void setCreateDate(Date argCreateDate) {
/* 146 */     if (changed(argCreateDate, this._createDate, "createDate")) {
/* 147 */       this._createDate = (argCreateDate == null || argCreateDate instanceof DtvDate) ? (DtvDate)argCreateDate : new DtvDate(argCreateDate);
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public String getCreateUserId() {
/* 153 */     return this._createUserId;
/*     */   }
/*     */   
/*     */   public void setCreateUserId(String argCreateUserId) {
/* 157 */     if (changed(argCreateUserId, this._createUserId, "createUserId")) {
/* 158 */       this._createUserId = argCreateUserId;
/*     */     }
/*     */   }
/*     */   
/*     */   public Date getUpdateDate() {
/* 163 */     return (Date)this._updateDate;
/*     */   }
/*     */   
/*     */   public void setUpdateDate(Date argUpdateDate) {
/* 167 */     if (changed(argUpdateDate, this._updateDate, "updateDate")) {
/* 168 */       this._updateDate = (argUpdateDate == null || argUpdateDate instanceof DtvDate) ? (DtvDate)argUpdateDate : new DtvDate(argUpdateDate);
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public String getUpdateUserId() {
/* 174 */     return this._updateUserId;
/*     */   }
/*     */   
/*     */   public void setUpdateUserId(String argUpdateUserId) {
/* 178 */     if (changed(argUpdateUserId, this._updateUserId, "updateUserId")) {
/* 179 */       this._updateUserId = argUpdateUserId;
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public String toString() {
/* 186 */     StringBuilder buf = new StringBuilder(512);
/* 187 */     buf.append(super.toString()).append(" Id: ").append(getObjectId()).append(" Values: ");
/* 188 */     if (getOrganizationId() != null) {
/* 189 */       buf.append("organizationId").append("=").append(getOrganizationId()).append(" ");
/*     */     }
/* 191 */     if (getTextCode() != null) {
/* 192 */       buf.append("textCode").append("=").append(getTextCode()).append(" ");
/*     */     }
/* 194 */     if (getTextSequence() != null) {
/* 195 */       buf.append("textSequence").append("=").append(getTextSequence()).append(" ");
/*     */     }
/* 197 */     if (getTextSubcode() != null) {
/* 198 */       buf.append("textSubcode").append("=").append(getTextSubcode()).append(" ");
/*     */     }
/* 200 */     if (getConfigElement() != null) {
/* 201 */       buf.append("configElement").append("=").append(getConfigElement()).append(" ");
/*     */     }
/* 203 */     if (getPropertyCode() != null) {
/* 204 */       buf.append("propertyCode").append("=").append(getPropertyCode()).append(" ");
/*     */     }
/* 206 */     if (getType() != null) {
/* 207 */       buf.append("type").append("=").append(getType()).append(" ");
/*     */     }
/* 209 */     if (getStringValue() != null) {
/* 210 */       buf.append("stringValue").append("=").append(getStringValue()).append(" ");
/*     */     }
/* 212 */     if (getDateValue() != null) {
/* 213 */       buf.append("dateValue").append("=").append(getDateValue()).append(" ");
/*     */     }
/* 215 */     if (getDecimalValue() != null) {
/* 216 */       buf.append("decimalValue").append("=").append(getDecimalValue()).append(" ");
/*     */     }
/* 218 */     if (getCreateDate() != null) {
/* 219 */       buf.append("createDate").append("=").append(getCreateDate()).append(" ");
/*     */     }
/* 221 */     if (getCreateUserId() != null) {
/* 222 */       buf.append("createUserId").append("=").append(getCreateUserId()).append(" ");
/*     */     }
/* 224 */     if (getUpdateDate() != null) {
/* 225 */       buf.append("updateDate").append("=").append(getUpdateDate()).append(" ");
/*     */     }
/* 227 */     if (getUpdateUserId() != null) {
/* 228 */       buf.append("updateUserId").append("=").append(getUpdateUserId()).append(" ");
/*     */     }
/*     */     
/* 231 */     return buf.toString();
/*     */   }
/*     */   
/*     */   public IObjectId getObjectId() {
/* 235 */     ReceiptTextPropertyId id = new ReceiptTextPropertyId();
/* 236 */     id.setOrganizationId(getOrganizationId());
/* 237 */     id.setTextCode(getTextCode());
/* 238 */     id.setTextSequence(getTextSequence());
/* 239 */     id.setTextSubcode(getTextSubcode());
/* 240 */     id.setConfigElement(getConfigElement());
/* 241 */     id.setPropertyCode(getPropertyCode());
/* 242 */     return (IObjectId)id;
/*     */   }
/*     */   
/*     */   public void setObjectId(IObjectId argObjectId) {
/* 246 */     setOrganizationId(((ReceiptTextPropertyId)argObjectId).getOrganizationId());
/* 247 */     setTextCode(((ReceiptTextPropertyId)argObjectId).getTextCode());
/* 248 */     setTextSequence(((ReceiptTextPropertyId)argObjectId).getTextSequence());
/* 249 */     setTextSubcode(((ReceiptTextPropertyId)argObjectId).getTextSubcode());
/* 250 */     setConfigElement(((ReceiptTextPropertyId)argObjectId).getConfigElement());
/* 251 */     setPropertyCode(((ReceiptTextPropertyId)argObjectId).getPropertyCode());
/*     */   }
/*     */   
/*     */   public String getImplementingClass() {
/* 255 */     return null;
/*     */   }
/*     */   
/*     */   public String toXmlString() {
/* 259 */     StringBuilder buf = new StringBuilder(700);
/* 260 */     buf.append("<").append("dao").append(" name=\"ReceiptTextProperty\" cmd=\"" + getObjectStateString() + "\">");
/* 261 */     getFieldsAsXml(buf);
/* 262 */     buf.append("</").append("dao").append(">");
/*     */     
/* 264 */     return buf.toString();
/*     */   }
/*     */   
/*     */   public Map<String, String> getValues() {
/* 268 */     Map<String, String> values = super.getValues();
/* 269 */     if (this._organizationId != null) values.put("OrganizationId", DaoUtils.getXmlSafeFieldValue(-5, this._organizationId)); 
/* 270 */     if (this._textCode != null) values.put("TextCode", DaoUtils.getXmlSafeFieldValue(12, this._textCode)); 
/* 271 */     if (this._textSequence != null) values.put("TextSequence", DaoUtils.getXmlSafeFieldValue(4, this._textSequence)); 
/* 272 */     if (this._textSubcode != null) values.put("TextSubcode", DaoUtils.getXmlSafeFieldValue(12, this._textSubcode)); 
/* 273 */     if (this._configElement != null) values.put("ConfigElement", DaoUtils.getXmlSafeFieldValue(12, this._configElement)); 
/* 274 */     if (this._propertyCode != null) values.put("PropertyCode", DaoUtils.getXmlSafeFieldValue(12, this._propertyCode)); 
/* 275 */     if (this._type != null) values.put("Type", DaoUtils.getXmlSafeFieldValue(12, this._type)); 
/* 276 */     if (this._stringValue != null) values.put("StringValue", DaoUtils.getXmlSafeFieldValue(12, this._stringValue)); 
/* 277 */     if (this._dateValue != null) values.put("DateValue", DaoUtils.getXmlSafeFieldValue(91, this._dateValue)); 
/* 278 */     if (this._decimalValue != null) values.put("DecimalValue", DaoUtils.getXmlSafeFieldValue(3, this._decimalValue)); 
/* 279 */     if (this._createDate != null) values.put("CreateDate", DaoUtils.getXmlSafeFieldValue(91, this._createDate)); 
/* 280 */     if (this._createUserId != null) values.put("CreateUserId", DaoUtils.getXmlSafeFieldValue(12, this._createUserId)); 
/* 281 */     if (this._updateDate != null) values.put("UpdateDate", DaoUtils.getXmlSafeFieldValue(91, this._updateDate)); 
/* 282 */     if (this._updateUserId != null) values.put("UpdateUserId", DaoUtils.getXmlSafeFieldValue(12, this._updateUserId)); 
/* 283 */     return values;
/*     */   }
/*     */ 
/*     */   
/*     */   public void setValues(Map<String, String> argValues) {
/* 288 */     super.setValues(argValues);
/* 289 */     for (Map.Entry<String, String> field : argValues.entrySet()) {
/*     */       
/* 291 */       String fieldName = field.getKey();
/* 292 */       String fieldValue = field.getValue();
/* 293 */       switch (fieldName) {
/*     */         
/*     */         case "OrganizationId":
/*     */           try {
/* 297 */             Object value = DaoUtils.getFieldValueForXmlString(-5, fieldValue);
/* 298 */             setOrganizationId((Long)value);
/* 299 */           } catch (Exception ee) {
/* 300 */             throw new DtxException("An exception occurred while calling setOrganizationId() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "TextCode":
/*     */           try {
/* 306 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 307 */             setTextCode((String)value);
/* 308 */           } catch (Exception ee) {
/* 309 */             throw new DtxException("An exception occurred while calling setTextCode() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "TextSequence":
/*     */           try {
/* 315 */             Object value = DaoUtils.getFieldValueForXmlString(4, fieldValue);
/* 316 */             setTextSequence((Integer)value);
/* 317 */           } catch (Exception ee) {
/* 318 */             throw new DtxException("An exception occurred while calling setTextSequence() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "TextSubcode":
/*     */           try {
/* 324 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 325 */             setTextSubcode((String)value);
/* 326 */           } catch (Exception ee) {
/* 327 */             throw new DtxException("An exception occurred while calling setTextSubcode() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "ConfigElement":
/*     */           try {
/* 333 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 334 */             setConfigElement((String)value);
/* 335 */           } catch (Exception ee) {
/* 336 */             throw new DtxException("An exception occurred while calling setConfigElement() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "PropertyCode":
/*     */           try {
/* 342 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 343 */             setPropertyCode((String)value);
/* 344 */           } catch (Exception ee) {
/* 345 */             throw new DtxException("An exception occurred while calling setPropertyCode() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "Type":
/*     */           try {
/* 351 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 352 */             setType((String)value);
/* 353 */           } catch (Exception ee) {
/* 354 */             throw new DtxException("An exception occurred while calling setType() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "StringValue":
/*     */           try {
/* 360 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 361 */             setStringValue((String)value);
/* 362 */           } catch (Exception ee) {
/* 363 */             throw new DtxException("An exception occurred while calling setStringValue() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "DateValue":
/*     */           try {
/* 369 */             Object value = DaoUtils.getFieldValueForXmlString(91, fieldValue);
/* 370 */             setDateValue((Date)value);
/* 371 */           } catch (Exception ee) {
/* 372 */             throw new DtxException("An exception occurred while calling setDateValue() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "DecimalValue":
/*     */           try {
/* 378 */             Object value = DaoUtils.getFieldValueForXmlString(3, fieldValue);
/* 379 */             setDecimalValue((BigDecimal)value);
/* 380 */           } catch (Exception ee) {
/* 381 */             throw new DtxException("An exception occurred while calling setDecimalValue() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "CreateDate":
/*     */           try {
/* 387 */             Object value = DaoUtils.getFieldValueForXmlString(91, fieldValue);
/* 388 */             setCreateDate((Date)value);
/* 389 */           } catch (Exception ee) {
/* 390 */             throw new DtxException("An exception occurred while calling setCreateDate() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "CreateUserId":
/*     */           try {
/* 396 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 397 */             setCreateUserId((String)value);
/* 398 */           } catch (Exception ee) {
/* 399 */             throw new DtxException("An exception occurred while calling setCreateUserId() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "UpdateDate":
/*     */           try {
/* 405 */             Object value = DaoUtils.getFieldValueForXmlString(91, fieldValue);
/* 406 */             setUpdateDate((Date)value);
/* 407 */           } catch (Exception ee) {
/* 408 */             throw new DtxException("An exception occurred while calling setUpdateDate() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "UpdateUserId":
/*     */           try {
/* 414 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 415 */             setUpdateUserId((String)value);
/* 416 */           } catch (Exception ee) {
/* 417 */             throw new DtxException("An exception occurred while calling setUpdateUserId() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */       } 
/*     */     } 
/*     */   }
/*     */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\com\impl\ReceiptTextPropertyDAO.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */