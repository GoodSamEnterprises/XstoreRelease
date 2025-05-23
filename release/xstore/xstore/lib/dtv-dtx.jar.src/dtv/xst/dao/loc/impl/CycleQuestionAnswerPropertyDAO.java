/*     */ package dtv.xst.dao.loc.impl;
/*     */ 
/*     */ import dtv.data2.access.DaoUtils;
/*     */ import dtv.data2.access.IObjectId;
/*     */ import dtv.data2.access.exception.DtxException;
/*     */ import dtv.data2.access.impl.AbstractDAOImpl;
/*     */ import dtv.util.DtvDate;
/*     */ import dtv.xst.dao.loc.CycleQuestionAnswerPropertyId;
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
/*     */ public class CycleQuestionAnswerPropertyDAO
/*     */   extends AbstractDAOImpl
/*     */ {
/*     */   private static final long serialVersionUID = -258671201L;
/*  23 */   private static final Logger _logger = Logger.getLogger(CycleQuestionAnswerPropertyDAO.class);
/*     */   
/*     */   private String _answerId;
/*     */   private DtvDate _answerTimestamp;
/*     */   private Long _organizationId;
/*     */   private String _questionId;
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
/*     */   public String getAnswerId() {
/*  40 */     return this._answerId;
/*     */   }
/*     */   
/*     */   public void setAnswerId(String argAnswerId) {
/*  44 */     if (changed(argAnswerId, this._answerId, "answerId")) {
/*  45 */       this._answerId = (argAnswerId != null && MANAGE_CASE) ? argAnswerId.toUpperCase() : argAnswerId;
/*     */     }
/*     */   }
/*     */   
/*     */   public Date getAnswerTimestamp() {
/*  50 */     return (Date)this._answerTimestamp;
/*     */   }
/*     */   
/*     */   public void setAnswerTimestamp(Date argAnswerTimestamp) {
/*  54 */     if (changed(argAnswerTimestamp, this._answerTimestamp, "answerTimestamp")) {
/*  55 */       this._answerTimestamp = (argAnswerTimestamp == null || argAnswerTimestamp instanceof DtvDate) ? (DtvDate)argAnswerTimestamp : new DtvDate(argAnswerTimestamp);
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public Long getOrganizationId() {
/*  61 */     return this._organizationId;
/*     */   }
/*     */   
/*     */   public void setOrganizationId(Long argOrganizationId) {
/*  65 */     if (changed(argOrganizationId, this._organizationId, "organizationId")) {
/*  66 */       this._organizationId = argOrganizationId;
/*     */     }
/*     */   }
/*     */   
/*     */   public String getQuestionId() {
/*  71 */     return this._questionId;
/*     */   }
/*     */   
/*     */   public void setQuestionId(String argQuestionId) {
/*  75 */     if (changed(argQuestionId, this._questionId, "questionId")) {
/*  76 */       this._questionId = (argQuestionId != null && MANAGE_CASE) ? argQuestionId.toUpperCase() : argQuestionId;
/*     */     }
/*     */   }
/*     */   
/*     */   public String getPropertyCode() {
/*  81 */     return this._propertyCode;
/*     */   }
/*     */   
/*     */   public void setPropertyCode(String argPropertyCode) {
/*  85 */     if (changed(argPropertyCode, this._propertyCode, "propertyCode")) {
/*  86 */       this._propertyCode = (argPropertyCode != null && MANAGE_CASE) ? argPropertyCode.toUpperCase() : argPropertyCode;
/*     */     }
/*     */   }
/*     */   
/*     */   public String getType() {
/*  91 */     return this._type;
/*     */   }
/*     */   
/*     */   public void setType(String argType) {
/*  95 */     if (changed(argType, this._type, "type")) {
/*  96 */       this._type = argType;
/*     */     }
/*     */   }
/*     */   
/*     */   public String getStringValue() {
/* 101 */     return this._stringValue;
/*     */   }
/*     */   
/*     */   public void setStringValue(String argStringValue) {
/* 105 */     if (changed(argStringValue, this._stringValue, "stringValue")) {
/* 106 */       this._stringValue = argStringValue;
/*     */     }
/*     */   }
/*     */   
/*     */   public Date getDateValue() {
/* 111 */     return (Date)this._dateValue;
/*     */   }
/*     */   
/*     */   public void setDateValue(Date argDateValue) {
/* 115 */     if (changed(argDateValue, this._dateValue, "dateValue")) {
/* 116 */       this._dateValue = (argDateValue == null || argDateValue instanceof DtvDate) ? (DtvDate)argDateValue : new DtvDate(argDateValue);
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public BigDecimal getDecimalValue() {
/* 122 */     return this._decimalValue;
/*     */   }
/*     */   
/*     */   public void setDecimalValue(BigDecimal argDecimalValue) {
/* 126 */     if (changed(argDecimalValue, this._decimalValue, "decimalValue")) {
/* 127 */       this._decimalValue = argDecimalValue;
/*     */     }
/*     */   }
/*     */   
/*     */   public Date getCreateDate() {
/* 132 */     return (Date)this._createDate;
/*     */   }
/*     */   
/*     */   public void setCreateDate(Date argCreateDate) {
/* 136 */     if (changed(argCreateDate, this._createDate, "createDate")) {
/* 137 */       this._createDate = (argCreateDate == null || argCreateDate instanceof DtvDate) ? (DtvDate)argCreateDate : new DtvDate(argCreateDate);
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public String getCreateUserId() {
/* 143 */     return this._createUserId;
/*     */   }
/*     */   
/*     */   public void setCreateUserId(String argCreateUserId) {
/* 147 */     if (changed(argCreateUserId, this._createUserId, "createUserId")) {
/* 148 */       this._createUserId = argCreateUserId;
/*     */     }
/*     */   }
/*     */   
/*     */   public Date getUpdateDate() {
/* 153 */     return (Date)this._updateDate;
/*     */   }
/*     */   
/*     */   public void setUpdateDate(Date argUpdateDate) {
/* 157 */     if (changed(argUpdateDate, this._updateDate, "updateDate")) {
/* 158 */       this._updateDate = (argUpdateDate == null || argUpdateDate instanceof DtvDate) ? (DtvDate)argUpdateDate : new DtvDate(argUpdateDate);
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public String getUpdateUserId() {
/* 164 */     return this._updateUserId;
/*     */   }
/*     */   
/*     */   public void setUpdateUserId(String argUpdateUserId) {
/* 168 */     if (changed(argUpdateUserId, this._updateUserId, "updateUserId")) {
/* 169 */       this._updateUserId = argUpdateUserId;
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public String toString() {
/* 176 */     StringBuilder buf = new StringBuilder(512);
/* 177 */     buf.append(super.toString()).append(" Id: ").append(getObjectId()).append(" Values: ");
/* 178 */     if (getAnswerId() != null) {
/* 179 */       buf.append("answerId").append("=").append(getAnswerId()).append(" ");
/*     */     }
/* 181 */     if (getAnswerTimestamp() != null) {
/* 182 */       buf.append("answerTimestamp").append("=").append(getAnswerTimestamp()).append(" ");
/*     */     }
/* 184 */     if (getOrganizationId() != null) {
/* 185 */       buf.append("organizationId").append("=").append(getOrganizationId()).append(" ");
/*     */     }
/* 187 */     if (getQuestionId() != null) {
/* 188 */       buf.append("questionId").append("=").append(getQuestionId()).append(" ");
/*     */     }
/* 190 */     if (getPropertyCode() != null) {
/* 191 */       buf.append("propertyCode").append("=").append(getPropertyCode()).append(" ");
/*     */     }
/* 193 */     if (getType() != null) {
/* 194 */       buf.append("type").append("=").append(getType()).append(" ");
/*     */     }
/* 196 */     if (getStringValue() != null) {
/* 197 */       buf.append("stringValue").append("=").append(getStringValue()).append(" ");
/*     */     }
/* 199 */     if (getDateValue() != null) {
/* 200 */       buf.append("dateValue").append("=").append(getDateValue()).append(" ");
/*     */     }
/* 202 */     if (getDecimalValue() != null) {
/* 203 */       buf.append("decimalValue").append("=").append(getDecimalValue()).append(" ");
/*     */     }
/* 205 */     if (getCreateDate() != null) {
/* 206 */       buf.append("createDate").append("=").append(getCreateDate()).append(" ");
/*     */     }
/* 208 */     if (getCreateUserId() != null) {
/* 209 */       buf.append("createUserId").append("=").append(getCreateUserId()).append(" ");
/*     */     }
/* 211 */     if (getUpdateDate() != null) {
/* 212 */       buf.append("updateDate").append("=").append(getUpdateDate()).append(" ");
/*     */     }
/* 214 */     if (getUpdateUserId() != null) {
/* 215 */       buf.append("updateUserId").append("=").append(getUpdateUserId()).append(" ");
/*     */     }
/*     */     
/* 218 */     return buf.toString();
/*     */   }
/*     */   
/*     */   public IObjectId getObjectId() {
/* 222 */     CycleQuestionAnswerPropertyId id = new CycleQuestionAnswerPropertyId();
/* 223 */     id.setAnswerId(getAnswerId());
/* 224 */     id.setAnswerTimestamp(getAnswerTimestamp());
/* 225 */     id.setOrganizationId(getOrganizationId());
/* 226 */     id.setQuestionId(getQuestionId());
/* 227 */     id.setPropertyCode(getPropertyCode());
/* 228 */     return (IObjectId)id;
/*     */   }
/*     */   
/*     */   public void setObjectId(IObjectId argObjectId) {
/* 232 */     setAnswerId(((CycleQuestionAnswerPropertyId)argObjectId).getAnswerId());
/* 233 */     setAnswerTimestamp(((CycleQuestionAnswerPropertyId)argObjectId).getAnswerTimestamp());
/* 234 */     setOrganizationId(((CycleQuestionAnswerPropertyId)argObjectId).getOrganizationId());
/* 235 */     setQuestionId(((CycleQuestionAnswerPropertyId)argObjectId).getQuestionId());
/* 236 */     setPropertyCode(((CycleQuestionAnswerPropertyId)argObjectId).getPropertyCode());
/*     */   }
/*     */   
/*     */   public String getImplementingClass() {
/* 240 */     return null;
/*     */   }
/*     */   
/*     */   public String toXmlString() {
/* 244 */     StringBuilder buf = new StringBuilder(650);
/* 245 */     buf.append("<").append("dao").append(" name=\"CycleQuestionAnswerProperty\" cmd=\"" + getObjectStateString() + "\">");
/* 246 */     getFieldsAsXml(buf);
/* 247 */     buf.append("</").append("dao").append(">");
/*     */     
/* 249 */     return buf.toString();
/*     */   }
/*     */   
/*     */   public Map<String, String> getValues() {
/* 253 */     Map<String, String> values = super.getValues();
/* 254 */     if (this._answerId != null) values.put("AnswerId", DaoUtils.getXmlSafeFieldValue(12, this._answerId)); 
/* 255 */     if (this._answerTimestamp != null) values.put("AnswerTimestamp", DaoUtils.getXmlSafeFieldValue(91, this._answerTimestamp)); 
/* 256 */     if (this._organizationId != null) values.put("OrganizationId", DaoUtils.getXmlSafeFieldValue(-5, this._organizationId)); 
/* 257 */     if (this._questionId != null) values.put("QuestionId", DaoUtils.getXmlSafeFieldValue(12, this._questionId)); 
/* 258 */     if (this._propertyCode != null) values.put("PropertyCode", DaoUtils.getXmlSafeFieldValue(12, this._propertyCode)); 
/* 259 */     if (this._type != null) values.put("Type", DaoUtils.getXmlSafeFieldValue(12, this._type)); 
/* 260 */     if (this._stringValue != null) values.put("StringValue", DaoUtils.getXmlSafeFieldValue(12, this._stringValue)); 
/* 261 */     if (this._dateValue != null) values.put("DateValue", DaoUtils.getXmlSafeFieldValue(91, this._dateValue)); 
/* 262 */     if (this._decimalValue != null) values.put("DecimalValue", DaoUtils.getXmlSafeFieldValue(3, this._decimalValue)); 
/* 263 */     if (this._createDate != null) values.put("CreateDate", DaoUtils.getXmlSafeFieldValue(91, this._createDate)); 
/* 264 */     if (this._createUserId != null) values.put("CreateUserId", DaoUtils.getXmlSafeFieldValue(12, this._createUserId)); 
/* 265 */     if (this._updateDate != null) values.put("UpdateDate", DaoUtils.getXmlSafeFieldValue(91, this._updateDate)); 
/* 266 */     if (this._updateUserId != null) values.put("UpdateUserId", DaoUtils.getXmlSafeFieldValue(12, this._updateUserId)); 
/* 267 */     return values;
/*     */   }
/*     */ 
/*     */   
/*     */   public void setValues(Map<String, String> argValues) {
/* 272 */     super.setValues(argValues);
/* 273 */     for (Map.Entry<String, String> field : argValues.entrySet()) {
/*     */       
/* 275 */       String fieldName = field.getKey();
/* 276 */       String fieldValue = field.getValue();
/* 277 */       switch (fieldName) {
/*     */         
/*     */         case "AnswerId":
/*     */           try {
/* 281 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 282 */             setAnswerId((String)value);
/* 283 */           } catch (Exception ee) {
/* 284 */             throw new DtxException("An exception occurred while calling setAnswerId() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "AnswerTimestamp":
/*     */           try {
/* 290 */             Object value = DaoUtils.getFieldValueForXmlString(91, fieldValue);
/* 291 */             setAnswerTimestamp((Date)value);
/* 292 */           } catch (Exception ee) {
/* 293 */             throw new DtxException("An exception occurred while calling setAnswerTimestamp() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
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
/*     */         case "QuestionId":
/*     */           try {
/* 308 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 309 */             setQuestionId((String)value);
/* 310 */           } catch (Exception ee) {
/* 311 */             throw new DtxException("An exception occurred while calling setQuestionId() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "PropertyCode":
/*     */           try {
/* 317 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 318 */             setPropertyCode((String)value);
/* 319 */           } catch (Exception ee) {
/* 320 */             throw new DtxException("An exception occurred while calling setPropertyCode() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "Type":
/*     */           try {
/* 326 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 327 */             setType((String)value);
/* 328 */           } catch (Exception ee) {
/* 329 */             throw new DtxException("An exception occurred while calling setType() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "StringValue":
/*     */           try {
/* 335 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 336 */             setStringValue((String)value);
/* 337 */           } catch (Exception ee) {
/* 338 */             throw new DtxException("An exception occurred while calling setStringValue() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "DateValue":
/*     */           try {
/* 344 */             Object value = DaoUtils.getFieldValueForXmlString(91, fieldValue);
/* 345 */             setDateValue((Date)value);
/* 346 */           } catch (Exception ee) {
/* 347 */             throw new DtxException("An exception occurred while calling setDateValue() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "DecimalValue":
/*     */           try {
/* 353 */             Object value = DaoUtils.getFieldValueForXmlString(3, fieldValue);
/* 354 */             setDecimalValue((BigDecimal)value);
/* 355 */           } catch (Exception ee) {
/* 356 */             throw new DtxException("An exception occurred while calling setDecimalValue() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "CreateDate":
/*     */           try {
/* 362 */             Object value = DaoUtils.getFieldValueForXmlString(91, fieldValue);
/* 363 */             setCreateDate((Date)value);
/* 364 */           } catch (Exception ee) {
/* 365 */             throw new DtxException("An exception occurred while calling setCreateDate() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "CreateUserId":
/*     */           try {
/* 371 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 372 */             setCreateUserId((String)value);
/* 373 */           } catch (Exception ee) {
/* 374 */             throw new DtxException("An exception occurred while calling setCreateUserId() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "UpdateDate":
/*     */           try {
/* 380 */             Object value = DaoUtils.getFieldValueForXmlString(91, fieldValue);
/* 381 */             setUpdateDate((Date)value);
/* 382 */           } catch (Exception ee) {
/* 383 */             throw new DtxException("An exception occurred while calling setUpdateDate() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "UpdateUserId":
/*     */           try {
/* 389 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 390 */             setUpdateUserId((String)value);
/* 391 */           } catch (Exception ee) {
/* 392 */             throw new DtxException("An exception occurred while calling setUpdateUserId() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */       } 
/*     */     } 
/*     */   }
/*     */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\loc\impl\CycleQuestionAnswerPropertyDAO.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */