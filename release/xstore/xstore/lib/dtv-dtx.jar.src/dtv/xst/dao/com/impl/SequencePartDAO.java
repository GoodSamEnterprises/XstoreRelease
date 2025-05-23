/*     */ package dtv.xst.dao.com.impl;
/*     */ 
/*     */ import dtv.data2.access.DaoUtils;
/*     */ import dtv.data2.access.IObjectId;
/*     */ import dtv.data2.access.exception.DtxException;
/*     */ import dtv.data2.access.impl.AbstractDAOImpl;
/*     */ import dtv.util.DtvDate;
/*     */ import dtv.xst.dao.com.SequencePartId;
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
/*     */ public class SequencePartDAO
/*     */   extends AbstractDAOImpl
/*     */ {
/*     */   private static final long serialVersionUID = 971889524L;
/*  23 */   private static final Logger _logger = Logger.getLogger(SequencePartDAO.class);
/*     */   
/*     */   private Long _organizationId;
/*     */   private String _sequenceId;
/*     */   private DtvDate _createDate;
/*     */   private String _createUserId;
/*     */   private DtvDate _updateDate;
/*     */   private String _updateUserId;
/*     */   private String _prefix;
/*     */   private String _suffix;
/*  33 */   private Boolean _encode = Boolean.FALSE;
/*     */   private String _checkDigitAlgorithm;
/*  35 */   private Boolean _numeric = Boolean.FALSE;
/*     */   private Long _padLength;
/*     */   private String _padCharacter;
/*     */   private Long _initialValue;
/*     */   private Long _maxValue;
/*     */   private Long _valueIncrement;
/*  41 */   private Boolean _includeStoreId = Boolean.FALSE;
/*     */   private Long _storePadLength;
/*  43 */   private Boolean _includeWorkstationId = Boolean.FALSE;
/*     */   private Long _workstationPadLength;
/*     */   
/*     */   public Long getOrganizationId() {
/*  47 */     return this._organizationId;
/*     */   }
/*     */   
/*     */   public void setOrganizationId(Long argOrganizationId) {
/*  51 */     if (changed(argOrganizationId, this._organizationId, "organizationId")) {
/*  52 */       this._organizationId = argOrganizationId;
/*     */     }
/*     */   }
/*     */   
/*     */   public String getSequenceId() {
/*  57 */     return this._sequenceId;
/*     */   }
/*     */   
/*     */   public void setSequenceId(String argSequenceId) {
/*  61 */     if (changed(argSequenceId, this._sequenceId, "sequenceId")) {
/*  62 */       this._sequenceId = (argSequenceId != null && MANAGE_CASE) ? argSequenceId.toUpperCase() : argSequenceId;
/*     */     }
/*     */   }
/*     */   
/*     */   public Date getCreateDate() {
/*  67 */     return (Date)this._createDate;
/*     */   }
/*     */   
/*     */   public void setCreateDate(Date argCreateDate) {
/*  71 */     if (changed(argCreateDate, this._createDate, "createDate")) {
/*  72 */       this._createDate = (argCreateDate == null || argCreateDate instanceof DtvDate) ? (DtvDate)argCreateDate : new DtvDate(argCreateDate);
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public String getCreateUserId() {
/*  78 */     return this._createUserId;
/*     */   }
/*     */   
/*     */   public void setCreateUserId(String argCreateUserId) {
/*  82 */     if (changed(argCreateUserId, this._createUserId, "createUserId")) {
/*  83 */       this._createUserId = argCreateUserId;
/*     */     }
/*     */   }
/*     */   
/*     */   public Date getUpdateDate() {
/*  88 */     return (Date)this._updateDate;
/*     */   }
/*     */   
/*     */   public void setUpdateDate(Date argUpdateDate) {
/*  92 */     if (changed(argUpdateDate, this._updateDate, "updateDate")) {
/*  93 */       this._updateDate = (argUpdateDate == null || argUpdateDate instanceof DtvDate) ? (DtvDate)argUpdateDate : new DtvDate(argUpdateDate);
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public String getUpdateUserId() {
/*  99 */     return this._updateUserId;
/*     */   }
/*     */   
/*     */   public void setUpdateUserId(String argUpdateUserId) {
/* 103 */     if (changed(argUpdateUserId, this._updateUserId, "updateUserId")) {
/* 104 */       this._updateUserId = argUpdateUserId;
/*     */     }
/*     */   }
/*     */   
/*     */   public String getPrefix() {
/* 109 */     return this._prefix;
/*     */   }
/*     */   
/*     */   public void setPrefix(String argPrefix) {
/* 113 */     if (changed(argPrefix, this._prefix, "prefix")) {
/* 114 */       this._prefix = argPrefix;
/*     */     }
/*     */   }
/*     */   
/*     */   public String getSuffix() {
/* 119 */     return this._suffix;
/*     */   }
/*     */   
/*     */   public void setSuffix(String argSuffix) {
/* 123 */     if (changed(argSuffix, this._suffix, "suffix")) {
/* 124 */       this._suffix = argSuffix;
/*     */     }
/*     */   }
/*     */   
/*     */   public Boolean getEncode() {
/* 129 */     return this._encode;
/*     */   }
/*     */   
/*     */   public void setEncode(Boolean argEncode) {
/* 133 */     if (changed(argEncode, this._encode, "encode")) {
/* 134 */       this._encode = argEncode;
/*     */     }
/*     */   }
/*     */   
/*     */   public String getCheckDigitAlgorithm() {
/* 139 */     return this._checkDigitAlgorithm;
/*     */   }
/*     */   
/*     */   public void setCheckDigitAlgorithm(String argCheckDigitAlgorithm) {
/* 143 */     if (changed(argCheckDigitAlgorithm, this._checkDigitAlgorithm, "checkDigitAlgorithm")) {
/* 144 */       this._checkDigitAlgorithm = argCheckDigitAlgorithm;
/*     */     }
/*     */   }
/*     */   
/*     */   public Boolean getNumeric() {
/* 149 */     return this._numeric;
/*     */   }
/*     */   
/*     */   public void setNumeric(Boolean argNumeric) {
/* 153 */     if (changed(argNumeric, this._numeric, "numeric")) {
/* 154 */       this._numeric = argNumeric;
/*     */     }
/*     */   }
/*     */   
/*     */   public Long getPadLength() {
/* 159 */     return this._padLength;
/*     */   }
/*     */   
/*     */   public void setPadLength(Long argPadLength) {
/* 163 */     if (changed(argPadLength, this._padLength, "padLength")) {
/* 164 */       this._padLength = argPadLength;
/*     */     }
/*     */   }
/*     */   
/*     */   public String getPadCharacter() {
/* 169 */     return this._padCharacter;
/*     */   }
/*     */   
/*     */   public void setPadCharacter(String argPadCharacter) {
/* 173 */     if (changed(argPadCharacter, this._padCharacter, "padCharacter")) {
/* 174 */       this._padCharacter = argPadCharacter;
/*     */     }
/*     */   }
/*     */   
/*     */   public Long getInitialValue() {
/* 179 */     return this._initialValue;
/*     */   }
/*     */   
/*     */   public void setInitialValue(Long argInitialValue) {
/* 183 */     if (changed(argInitialValue, this._initialValue, "initialValue")) {
/* 184 */       this._initialValue = argInitialValue;
/*     */     }
/*     */   }
/*     */   
/*     */   public Long getMaxValue() {
/* 189 */     return this._maxValue;
/*     */   }
/*     */   
/*     */   public void setMaxValue(Long argMaxValue) {
/* 193 */     if (changed(argMaxValue, this._maxValue, "maxValue")) {
/* 194 */       this._maxValue = argMaxValue;
/*     */     }
/*     */   }
/*     */   
/*     */   public Long getValueIncrement() {
/* 199 */     return this._valueIncrement;
/*     */   }
/*     */   
/*     */   public void setValueIncrement(Long argValueIncrement) {
/* 203 */     if (changed(argValueIncrement, this._valueIncrement, "valueIncrement")) {
/* 204 */       this._valueIncrement = argValueIncrement;
/*     */     }
/*     */   }
/*     */   
/*     */   public Boolean getIncludeStoreId() {
/* 209 */     return this._includeStoreId;
/*     */   }
/*     */   
/*     */   public void setIncludeStoreId(Boolean argIncludeStoreId) {
/* 213 */     if (changed(argIncludeStoreId, this._includeStoreId, "includeStoreId")) {
/* 214 */       this._includeStoreId = argIncludeStoreId;
/*     */     }
/*     */   }
/*     */   
/*     */   public Long getStorePadLength() {
/* 219 */     return this._storePadLength;
/*     */   }
/*     */   
/*     */   public void setStorePadLength(Long argStorePadLength) {
/* 223 */     if (changed(argStorePadLength, this._storePadLength, "storePadLength")) {
/* 224 */       this._storePadLength = argStorePadLength;
/*     */     }
/*     */   }
/*     */   
/*     */   public Boolean getIncludeWorkstationId() {
/* 229 */     return this._includeWorkstationId;
/*     */   }
/*     */   
/*     */   public void setIncludeWorkstationId(Boolean argIncludeWorkstationId) {
/* 233 */     if (changed(argIncludeWorkstationId, this._includeWorkstationId, "includeWorkstationId")) {
/* 234 */       this._includeWorkstationId = argIncludeWorkstationId;
/*     */     }
/*     */   }
/*     */   
/*     */   public Long getWorkstationPadLength() {
/* 239 */     return this._workstationPadLength;
/*     */   }
/*     */   
/*     */   public void setWorkstationPadLength(Long argWorkstationPadLength) {
/* 243 */     if (changed(argWorkstationPadLength, this._workstationPadLength, "workstationPadLength")) {
/* 244 */       this._workstationPadLength = argWorkstationPadLength;
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public String toString() {
/* 251 */     StringBuilder buf = new StringBuilder(512);
/* 252 */     buf.append(super.toString()).append(" Id: ").append(getObjectId()).append(" Values: ");
/* 253 */     if (getOrganizationId() != null) {
/* 254 */       buf.append("organizationId").append("=").append(getOrganizationId()).append(" ");
/*     */     }
/* 256 */     if (getSequenceId() != null) {
/* 257 */       buf.append("sequenceId").append("=").append(getSequenceId()).append(" ");
/*     */     }
/* 259 */     if (getCreateDate() != null) {
/* 260 */       buf.append("createDate").append("=").append(getCreateDate()).append(" ");
/*     */     }
/* 262 */     if (getCreateUserId() != null) {
/* 263 */       buf.append("createUserId").append("=").append(getCreateUserId()).append(" ");
/*     */     }
/* 265 */     if (getUpdateDate() != null) {
/* 266 */       buf.append("updateDate").append("=").append(getUpdateDate()).append(" ");
/*     */     }
/* 268 */     if (getUpdateUserId() != null) {
/* 269 */       buf.append("updateUserId").append("=").append(getUpdateUserId()).append(" ");
/*     */     }
/* 271 */     if (getPrefix() != null) {
/* 272 */       buf.append("prefix").append("=").append(getPrefix()).append(" ");
/*     */     }
/* 274 */     if (getSuffix() != null) {
/* 275 */       buf.append("suffix").append("=").append(getSuffix()).append(" ");
/*     */     }
/* 277 */     if (getEncode() != null && getEncode().booleanValue()) {
/* 278 */       buf.append("encode").append("=").append(getEncode()).append(" ");
/*     */     }
/* 280 */     if (getCheckDigitAlgorithm() != null) {
/* 281 */       buf.append("checkDigitAlgorithm").append("=").append(getCheckDigitAlgorithm()).append(" ");
/*     */     }
/* 283 */     if (getNumeric() != null && getNumeric().booleanValue()) {
/* 284 */       buf.append("numeric").append("=").append(getNumeric()).append(" ");
/*     */     }
/* 286 */     if (getPadLength() != null) {
/* 287 */       buf.append("padLength").append("=").append(getPadLength()).append(" ");
/*     */     }
/* 289 */     if (getPadCharacter() != null) {
/* 290 */       buf.append("padCharacter").append("=").append(getPadCharacter()).append(" ");
/*     */     }
/* 292 */     if (getInitialValue() != null) {
/* 293 */       buf.append("initialValue").append("=").append(getInitialValue()).append(" ");
/*     */     }
/* 295 */     if (getMaxValue() != null) {
/* 296 */       buf.append("maxValue").append("=").append(getMaxValue()).append(" ");
/*     */     }
/* 298 */     if (getValueIncrement() != null) {
/* 299 */       buf.append("valueIncrement").append("=").append(getValueIncrement()).append(" ");
/*     */     }
/* 301 */     if (getIncludeStoreId() != null && getIncludeStoreId().booleanValue()) {
/* 302 */       buf.append("includeStoreId").append("=").append(getIncludeStoreId()).append(" ");
/*     */     }
/* 304 */     if (getStorePadLength() != null) {
/* 305 */       buf.append("storePadLength").append("=").append(getStorePadLength()).append(" ");
/*     */     }
/* 307 */     if (getIncludeWorkstationId() != null && getIncludeWorkstationId().booleanValue()) {
/* 308 */       buf.append("includeWorkstationId").append("=").append(getIncludeWorkstationId()).append(" ");
/*     */     }
/* 310 */     if (getWorkstationPadLength() != null) {
/* 311 */       buf.append("workstationPadLength").append("=").append(getWorkstationPadLength()).append(" ");
/*     */     }
/*     */     
/* 314 */     return buf.toString();
/*     */   }
/*     */   
/*     */   public IObjectId getObjectId() {
/* 318 */     SequencePartId id = new SequencePartId();
/* 319 */     id.setOrganizationId(getOrganizationId());
/* 320 */     id.setSequenceId(getSequenceId());
/* 321 */     return (IObjectId)id;
/*     */   }
/*     */   
/*     */   public void setObjectId(IObjectId argObjectId) {
/* 325 */     setOrganizationId(((SequencePartId)argObjectId).getOrganizationId());
/* 326 */     setSequenceId(((SequencePartId)argObjectId).getSequenceId());
/*     */   }
/*     */   
/*     */   public String getImplementingClass() {
/* 330 */     return null;
/*     */   }
/*     */   
/*     */   public String toXmlString() {
/* 334 */     StringBuilder buf = new StringBuilder(1000);
/* 335 */     buf.append("<").append("dao").append(" name=\"SequencePart\" cmd=\"" + getObjectStateString() + "\">");
/* 336 */     getFieldsAsXml(buf);
/* 337 */     buf.append("</").append("dao").append(">");
/*     */     
/* 339 */     return buf.toString();
/*     */   }
/*     */   
/*     */   public Map<String, String> getValues() {
/* 343 */     Map<String, String> values = super.getValues();
/* 344 */     if (this._organizationId != null) values.put("OrganizationId", DaoUtils.getXmlSafeFieldValue(-5, this._organizationId)); 
/* 345 */     if (this._sequenceId != null) values.put("SequenceId", DaoUtils.getXmlSafeFieldValue(12, this._sequenceId)); 
/* 346 */     if (this._createDate != null) values.put("CreateDate", DaoUtils.getXmlSafeFieldValue(91, this._createDate)); 
/* 347 */     if (this._createUserId != null) values.put("CreateUserId", DaoUtils.getXmlSafeFieldValue(12, this._createUserId)); 
/* 348 */     if (this._updateDate != null) values.put("UpdateDate", DaoUtils.getXmlSafeFieldValue(91, this._updateDate)); 
/* 349 */     if (this._updateUserId != null) values.put("UpdateUserId", DaoUtils.getXmlSafeFieldValue(12, this._updateUserId)); 
/* 350 */     if (this._prefix != null) values.put("Prefix", DaoUtils.getXmlSafeFieldValue(12, this._prefix)); 
/* 351 */     if (this._suffix != null) values.put("Suffix", DaoUtils.getXmlSafeFieldValue(12, this._suffix)); 
/* 352 */     if (this._encode != null) values.put("Encode", DaoUtils.getXmlSafeFieldValue(-7, this._encode)); 
/* 353 */     if (this._checkDigitAlgorithm != null) values.put("CheckDigitAlgorithm", DaoUtils.getXmlSafeFieldValue(12, this._checkDigitAlgorithm)); 
/* 354 */     if (this._numeric != null) values.put("Numeric", DaoUtils.getXmlSafeFieldValue(-7, this._numeric)); 
/* 355 */     if (this._padLength != null) values.put("PadLength", DaoUtils.getXmlSafeFieldValue(-5, this._padLength)); 
/* 356 */     if (this._padCharacter != null) values.put("PadCharacter", DaoUtils.getXmlSafeFieldValue(12, this._padCharacter)); 
/* 357 */     if (this._initialValue != null) values.put("InitialValue", DaoUtils.getXmlSafeFieldValue(-5, this._initialValue)); 
/* 358 */     if (this._maxValue != null) values.put("MaxValue", DaoUtils.getXmlSafeFieldValue(-5, this._maxValue)); 
/* 359 */     if (this._valueIncrement != null) values.put("ValueIncrement", DaoUtils.getXmlSafeFieldValue(-5, this._valueIncrement)); 
/* 360 */     if (this._includeStoreId != null) values.put("IncludeStoreId", DaoUtils.getXmlSafeFieldValue(-7, this._includeStoreId)); 
/* 361 */     if (this._storePadLength != null) values.put("StorePadLength", DaoUtils.getXmlSafeFieldValue(-5, this._storePadLength)); 
/* 362 */     if (this._includeWorkstationId != null) values.put("IncludeWorkstationId", DaoUtils.getXmlSafeFieldValue(-7, this._includeWorkstationId)); 
/* 363 */     if (this._workstationPadLength != null) values.put("WorkstationPadLength", DaoUtils.getXmlSafeFieldValue(-5, this._workstationPadLength)); 
/* 364 */     return values;
/*     */   }
/*     */ 
/*     */   
/*     */   public void setValues(Map<String, String> argValues) {
/* 369 */     super.setValues(argValues);
/* 370 */     for (Map.Entry<String, String> field : argValues.entrySet()) {
/*     */       
/* 372 */       String fieldName = field.getKey();
/* 373 */       String fieldValue = field.getValue();
/* 374 */       switch (fieldName) {
/*     */         
/*     */         case "OrganizationId":
/*     */           try {
/* 378 */             Object value = DaoUtils.getFieldValueForXmlString(-5, fieldValue);
/* 379 */             setOrganizationId((Long)value);
/* 380 */           } catch (Exception ee) {
/* 381 */             throw new DtxException("An exception occurred while calling setOrganizationId() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "SequenceId":
/*     */           try {
/* 387 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 388 */             setSequenceId((String)value);
/* 389 */           } catch (Exception ee) {
/* 390 */             throw new DtxException("An exception occurred while calling setSequenceId() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "CreateDate":
/*     */           try {
/* 396 */             Object value = DaoUtils.getFieldValueForXmlString(91, fieldValue);
/* 397 */             setCreateDate((Date)value);
/* 398 */           } catch (Exception ee) {
/* 399 */             throw new DtxException("An exception occurred while calling setCreateDate() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "CreateUserId":
/*     */           try {
/* 405 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 406 */             setCreateUserId((String)value);
/* 407 */           } catch (Exception ee) {
/* 408 */             throw new DtxException("An exception occurred while calling setCreateUserId() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "UpdateDate":
/*     */           try {
/* 414 */             Object value = DaoUtils.getFieldValueForXmlString(91, fieldValue);
/* 415 */             setUpdateDate((Date)value);
/* 416 */           } catch (Exception ee) {
/* 417 */             throw new DtxException("An exception occurred while calling setUpdateDate() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "UpdateUserId":
/*     */           try {
/* 423 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 424 */             setUpdateUserId((String)value);
/* 425 */           } catch (Exception ee) {
/* 426 */             throw new DtxException("An exception occurred while calling setUpdateUserId() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "Prefix":
/*     */           try {
/* 432 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 433 */             setPrefix((String)value);
/* 434 */           } catch (Exception ee) {
/* 435 */             throw new DtxException("An exception occurred while calling setPrefix() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "Suffix":
/*     */           try {
/* 441 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 442 */             setSuffix((String)value);
/* 443 */           } catch (Exception ee) {
/* 444 */             throw new DtxException("An exception occurred while calling setSuffix() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "Encode":
/*     */           try {
/* 450 */             Object value = DaoUtils.getFieldValueForXmlString(-7, fieldValue);
/* 451 */             setEncode((Boolean)value);
/* 452 */           } catch (Exception ee) {
/* 453 */             throw new DtxException("An exception occurred while calling setEncode() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "CheckDigitAlgorithm":
/*     */           try {
/* 459 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 460 */             setCheckDigitAlgorithm((String)value);
/* 461 */           } catch (Exception ee) {
/* 462 */             throw new DtxException("An exception occurred while calling setCheckDigitAlgorithm() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "Numeric":
/*     */           try {
/* 468 */             Object value = DaoUtils.getFieldValueForXmlString(-7, fieldValue);
/* 469 */             setNumeric((Boolean)value);
/* 470 */           } catch (Exception ee) {
/* 471 */             throw new DtxException("An exception occurred while calling setNumeric() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "PadLength":
/*     */           try {
/* 477 */             Object value = DaoUtils.getFieldValueForXmlString(-5, fieldValue);
/* 478 */             setPadLength((Long)value);
/* 479 */           } catch (Exception ee) {
/* 480 */             throw new DtxException("An exception occurred while calling setPadLength() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "PadCharacter":
/*     */           try {
/* 486 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 487 */             setPadCharacter((String)value);
/* 488 */           } catch (Exception ee) {
/* 489 */             throw new DtxException("An exception occurred while calling setPadCharacter() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "InitialValue":
/*     */           try {
/* 495 */             Object value = DaoUtils.getFieldValueForXmlString(-5, fieldValue);
/* 496 */             setInitialValue((Long)value);
/* 497 */           } catch (Exception ee) {
/* 498 */             throw new DtxException("An exception occurred while calling setInitialValue() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "MaxValue":
/*     */           try {
/* 504 */             Object value = DaoUtils.getFieldValueForXmlString(-5, fieldValue);
/* 505 */             setMaxValue((Long)value);
/* 506 */           } catch (Exception ee) {
/* 507 */             throw new DtxException("An exception occurred while calling setMaxValue() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "ValueIncrement":
/*     */           try {
/* 513 */             Object value = DaoUtils.getFieldValueForXmlString(-5, fieldValue);
/* 514 */             setValueIncrement((Long)value);
/* 515 */           } catch (Exception ee) {
/* 516 */             throw new DtxException("An exception occurred while calling setValueIncrement() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "IncludeStoreId":
/*     */           try {
/* 522 */             Object value = DaoUtils.getFieldValueForXmlString(-7, fieldValue);
/* 523 */             setIncludeStoreId((Boolean)value);
/* 524 */           } catch (Exception ee) {
/* 525 */             throw new DtxException("An exception occurred while calling setIncludeStoreId() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "StorePadLength":
/*     */           try {
/* 531 */             Object value = DaoUtils.getFieldValueForXmlString(-5, fieldValue);
/* 532 */             setStorePadLength((Long)value);
/* 533 */           } catch (Exception ee) {
/* 534 */             throw new DtxException("An exception occurred while calling setStorePadLength() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "IncludeWorkstationId":
/*     */           try {
/* 540 */             Object value = DaoUtils.getFieldValueForXmlString(-7, fieldValue);
/* 541 */             setIncludeWorkstationId((Boolean)value);
/* 542 */           } catch (Exception ee) {
/* 543 */             throw new DtxException("An exception occurred while calling setIncludeWorkstationId() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "WorkstationPadLength":
/*     */           try {
/* 549 */             Object value = DaoUtils.getFieldValueForXmlString(-5, fieldValue);
/* 550 */             setWorkstationPadLength((Long)value);
/* 551 */           } catch (Exception ee) {
/* 552 */             throw new DtxException("An exception occurred while calling setWorkstationPadLength() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */       } 
/*     */     } 
/*     */   }
/*     */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\com\impl\SequencePartDAO.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */