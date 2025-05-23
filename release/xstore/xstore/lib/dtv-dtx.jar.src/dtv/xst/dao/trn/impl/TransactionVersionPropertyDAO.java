/*     */ package dtv.xst.dao.trn.impl;
/*     */ 
/*     */ import dtv.data2.access.DaoUtils;
/*     */ import dtv.data2.access.IObjectId;
/*     */ import dtv.data2.access.exception.DtxException;
/*     */ import dtv.data2.access.impl.AbstractDAOImpl;
/*     */ import dtv.util.DtvDate;
/*     */ import dtv.xst.dao.trn.TransactionVersionPropertyId;
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
/*     */ public class TransactionVersionPropertyDAO
/*     */   extends AbstractDAOImpl
/*     */ {
/*     */   private static final long serialVersionUID = -926502865L;
/*  23 */   private static final Logger _logger = Logger.getLogger(TransactionVersionPropertyDAO.class);
/*     */   
/*     */   private Long _organizationId;
/*     */   private Long _retailLocationId;
/*     */   private DtvDate _businessDate;
/*     */   private Long _workstationId;
/*     */   private Long _transactionSequence;
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
/*     */   public Long getRetailLocationId() {
/*  51 */     return this._retailLocationId;
/*     */   }
/*     */   
/*     */   public void setRetailLocationId(Long argRetailLocationId) {
/*  55 */     if (changed(argRetailLocationId, this._retailLocationId, "retailLocationId")) {
/*  56 */       this._retailLocationId = argRetailLocationId;
/*     */     }
/*     */   }
/*     */   
/*     */   public Date getBusinessDate() {
/*  61 */     return (Date)this._businessDate;
/*     */   }
/*     */   
/*     */   public void setBusinessDate(Date argBusinessDate) {
/*  65 */     if (changed(argBusinessDate, this._businessDate, "businessDate")) {
/*  66 */       this._businessDate = (argBusinessDate == null || argBusinessDate instanceof DtvDate) ? (DtvDate)argBusinessDate : new DtvDate(argBusinessDate);
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public Long getWorkstationId() {
/*  72 */     return this._workstationId;
/*     */   }
/*     */   
/*     */   public void setWorkstationId(Long argWorkstationId) {
/*  76 */     if (changed(argWorkstationId, this._workstationId, "workstationId")) {
/*  77 */       this._workstationId = argWorkstationId;
/*     */     }
/*     */   }
/*     */   
/*     */   public Long getTransactionSequence() {
/*  82 */     return this._transactionSequence;
/*     */   }
/*     */   
/*     */   public void setTransactionSequence(Long argTransactionSequence) {
/*  86 */     if (changed(argTransactionSequence, this._transactionSequence, "transactionSequence")) {
/*  87 */       this._transactionSequence = argTransactionSequence;
/*     */     }
/*     */   }
/*     */   
/*     */   public String getPropertyCode() {
/*  92 */     return this._propertyCode;
/*     */   }
/*     */   
/*     */   public void setPropertyCode(String argPropertyCode) {
/*  96 */     if (changed(argPropertyCode, this._propertyCode, "propertyCode")) {
/*  97 */       this._propertyCode = (argPropertyCode != null && MANAGE_CASE) ? argPropertyCode.toUpperCase() : argPropertyCode;
/*     */     }
/*     */   }
/*     */   
/*     */   public String getType() {
/* 102 */     return this._type;
/*     */   }
/*     */   
/*     */   public void setType(String argType) {
/* 106 */     if (changed(argType, this._type, "type")) {
/* 107 */       this._type = argType;
/*     */     }
/*     */   }
/*     */   
/*     */   public String getStringValue() {
/* 112 */     return this._stringValue;
/*     */   }
/*     */   
/*     */   public void setStringValue(String argStringValue) {
/* 116 */     if (changed(argStringValue, this._stringValue, "stringValue")) {
/* 117 */       this._stringValue = argStringValue;
/*     */     }
/*     */   }
/*     */   
/*     */   public Date getDateValue() {
/* 122 */     return (Date)this._dateValue;
/*     */   }
/*     */   
/*     */   public void setDateValue(Date argDateValue) {
/* 126 */     if (changed(argDateValue, this._dateValue, "dateValue")) {
/* 127 */       this._dateValue = (argDateValue == null || argDateValue instanceof DtvDate) ? (DtvDate)argDateValue : new DtvDate(argDateValue);
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public BigDecimal getDecimalValue() {
/* 133 */     return this._decimalValue;
/*     */   }
/*     */   
/*     */   public void setDecimalValue(BigDecimal argDecimalValue) {
/* 137 */     if (changed(argDecimalValue, this._decimalValue, "decimalValue")) {
/* 138 */       this._decimalValue = argDecimalValue;
/*     */     }
/*     */   }
/*     */   
/*     */   public Date getCreateDate() {
/* 143 */     return (Date)this._createDate;
/*     */   }
/*     */   
/*     */   public void setCreateDate(Date argCreateDate) {
/* 147 */     if (changed(argCreateDate, this._createDate, "createDate")) {
/* 148 */       this._createDate = (argCreateDate == null || argCreateDate instanceof DtvDate) ? (DtvDate)argCreateDate : new DtvDate(argCreateDate);
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public String getCreateUserId() {
/* 154 */     return this._createUserId;
/*     */   }
/*     */   
/*     */   public void setCreateUserId(String argCreateUserId) {
/* 158 */     if (changed(argCreateUserId, this._createUserId, "createUserId")) {
/* 159 */       this._createUserId = argCreateUserId;
/*     */     }
/*     */   }
/*     */   
/*     */   public Date getUpdateDate() {
/* 164 */     return (Date)this._updateDate;
/*     */   }
/*     */   
/*     */   public void setUpdateDate(Date argUpdateDate) {
/* 168 */     if (changed(argUpdateDate, this._updateDate, "updateDate")) {
/* 169 */       this._updateDate = (argUpdateDate == null || argUpdateDate instanceof DtvDate) ? (DtvDate)argUpdateDate : new DtvDate(argUpdateDate);
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public String getUpdateUserId() {
/* 175 */     return this._updateUserId;
/*     */   }
/*     */   
/*     */   public void setUpdateUserId(String argUpdateUserId) {
/* 179 */     if (changed(argUpdateUserId, this._updateUserId, "updateUserId")) {
/* 180 */       this._updateUserId = argUpdateUserId;
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public String toString() {
/* 187 */     StringBuilder buf = new StringBuilder(512);
/* 188 */     buf.append(super.toString()).append(" Id: ").append(getObjectId()).append(" Values: ");
/* 189 */     if (getOrganizationId() != null) {
/* 190 */       buf.append("organizationId").append("=").append(getOrganizationId()).append(" ");
/*     */     }
/* 192 */     if (getRetailLocationId() != null) {
/* 193 */       buf.append("retailLocationId").append("=").append(getRetailLocationId()).append(" ");
/*     */     }
/* 195 */     if (getBusinessDate() != null) {
/* 196 */       buf.append("businessDate").append("=").append(getBusinessDate()).append(" ");
/*     */     }
/* 198 */     if (getWorkstationId() != null) {
/* 199 */       buf.append("workstationId").append("=").append(getWorkstationId()).append(" ");
/*     */     }
/* 201 */     if (getTransactionSequence() != null) {
/* 202 */       buf.append("transactionSequence").append("=").append(getTransactionSequence()).append(" ");
/*     */     }
/* 204 */     if (getPropertyCode() != null) {
/* 205 */       buf.append("propertyCode").append("=").append(getPropertyCode()).append(" ");
/*     */     }
/* 207 */     if (getType() != null) {
/* 208 */       buf.append("type").append("=").append(getType()).append(" ");
/*     */     }
/* 210 */     if (getStringValue() != null) {
/* 211 */       buf.append("stringValue").append("=").append(getStringValue()).append(" ");
/*     */     }
/* 213 */     if (getDateValue() != null) {
/* 214 */       buf.append("dateValue").append("=").append(getDateValue()).append(" ");
/*     */     }
/* 216 */     if (getDecimalValue() != null) {
/* 217 */       buf.append("decimalValue").append("=").append(getDecimalValue()).append(" ");
/*     */     }
/* 219 */     if (getCreateDate() != null) {
/* 220 */       buf.append("createDate").append("=").append(getCreateDate()).append(" ");
/*     */     }
/* 222 */     if (getCreateUserId() != null) {
/* 223 */       buf.append("createUserId").append("=").append(getCreateUserId()).append(" ");
/*     */     }
/* 225 */     if (getUpdateDate() != null) {
/* 226 */       buf.append("updateDate").append("=").append(getUpdateDate()).append(" ");
/*     */     }
/* 228 */     if (getUpdateUserId() != null) {
/* 229 */       buf.append("updateUserId").append("=").append(getUpdateUserId()).append(" ");
/*     */     }
/*     */     
/* 232 */     return buf.toString();
/*     */   }
/*     */   
/*     */   public IObjectId getObjectId() {
/* 236 */     TransactionVersionPropertyId id = new TransactionVersionPropertyId();
/* 237 */     id.setOrganizationId(getOrganizationId());
/* 238 */     id.setRetailLocationId(getRetailLocationId());
/* 239 */     id.setBusinessDate(getBusinessDate());
/* 240 */     id.setWorkstationId(getWorkstationId());
/* 241 */     id.setTransactionSequence(getTransactionSequence());
/* 242 */     id.setPropertyCode(getPropertyCode());
/* 243 */     return (IObjectId)id;
/*     */   }
/*     */   
/*     */   public void setObjectId(IObjectId argObjectId) {
/* 247 */     setOrganizationId(((TransactionVersionPropertyId)argObjectId).getOrganizationId());
/* 248 */     setRetailLocationId(((TransactionVersionPropertyId)argObjectId).getRetailLocationId());
/* 249 */     setBusinessDate(((TransactionVersionPropertyId)argObjectId).getBusinessDate());
/* 250 */     setWorkstationId(((TransactionVersionPropertyId)argObjectId).getWorkstationId());
/* 251 */     setTransactionSequence(((TransactionVersionPropertyId)argObjectId).getTransactionSequence());
/* 252 */     setPropertyCode(((TransactionVersionPropertyId)argObjectId).getPropertyCode());
/*     */   }
/*     */   
/*     */   public String getImplementingClass() {
/* 256 */     return null;
/*     */   }
/*     */   
/*     */   public String toXmlString() {
/* 260 */     StringBuilder buf = new StringBuilder(700);
/* 261 */     buf.append("<").append("dao").append(" name=\"TransactionVersionProperty\" cmd=\"" + getObjectStateString() + "\">");
/* 262 */     getFieldsAsXml(buf);
/* 263 */     buf.append("</").append("dao").append(">");
/*     */     
/* 265 */     return buf.toString();
/*     */   }
/*     */   
/*     */   public Map<String, String> getValues() {
/* 269 */     Map<String, String> values = super.getValues();
/* 270 */     if (this._organizationId != null) values.put("OrganizationId", DaoUtils.getXmlSafeFieldValue(-5, this._organizationId)); 
/* 271 */     if (this._retailLocationId != null) values.put("RetailLocationId", DaoUtils.getXmlSafeFieldValue(-5, this._retailLocationId)); 
/* 272 */     if (this._businessDate != null) values.put("BusinessDate", DaoUtils.getXmlSafeFieldValue(91, this._businessDate)); 
/* 273 */     if (this._workstationId != null) values.put("WorkstationId", DaoUtils.getXmlSafeFieldValue(-5, this._workstationId)); 
/* 274 */     if (this._transactionSequence != null) values.put("TransactionSequence", DaoUtils.getXmlSafeFieldValue(-5, this._transactionSequence)); 
/* 275 */     if (this._propertyCode != null) values.put("PropertyCode", DaoUtils.getXmlSafeFieldValue(12, this._propertyCode)); 
/* 276 */     if (this._type != null) values.put("Type", DaoUtils.getXmlSafeFieldValue(12, this._type)); 
/* 277 */     if (this._stringValue != null) values.put("StringValue", DaoUtils.getXmlSafeFieldValue(12, this._stringValue)); 
/* 278 */     if (this._dateValue != null) values.put("DateValue", DaoUtils.getXmlSafeFieldValue(91, this._dateValue)); 
/* 279 */     if (this._decimalValue != null) values.put("DecimalValue", DaoUtils.getXmlSafeFieldValue(3, this._decimalValue)); 
/* 280 */     if (this._createDate != null) values.put("CreateDate", DaoUtils.getXmlSafeFieldValue(91, this._createDate)); 
/* 281 */     if (this._createUserId != null) values.put("CreateUserId", DaoUtils.getXmlSafeFieldValue(12, this._createUserId)); 
/* 282 */     if (this._updateDate != null) values.put("UpdateDate", DaoUtils.getXmlSafeFieldValue(91, this._updateDate)); 
/* 283 */     if (this._updateUserId != null) values.put("UpdateUserId", DaoUtils.getXmlSafeFieldValue(12, this._updateUserId)); 
/* 284 */     return values;
/*     */   }
/*     */ 
/*     */   
/*     */   public void setValues(Map<String, String> argValues) {
/* 289 */     super.setValues(argValues);
/* 290 */     for (Map.Entry<String, String> field : argValues.entrySet()) {
/*     */       
/* 292 */       String fieldName = field.getKey();
/* 293 */       String fieldValue = field.getValue();
/* 294 */       switch (fieldName) {
/*     */         
/*     */         case "OrganizationId":
/*     */           try {
/* 298 */             Object value = DaoUtils.getFieldValueForXmlString(-5, fieldValue);
/* 299 */             setOrganizationId((Long)value);
/* 300 */           } catch (Exception ee) {
/* 301 */             throw new DtxException("An exception occurred while calling setOrganizationId() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "RetailLocationId":
/*     */           try {
/* 307 */             Object value = DaoUtils.getFieldValueForXmlString(-5, fieldValue);
/* 308 */             setRetailLocationId((Long)value);
/* 309 */           } catch (Exception ee) {
/* 310 */             throw new DtxException("An exception occurred while calling setRetailLocationId() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "BusinessDate":
/*     */           try {
/* 316 */             Object value = DaoUtils.getFieldValueForXmlString(91, fieldValue);
/* 317 */             setBusinessDate((Date)value);
/* 318 */           } catch (Exception ee) {
/* 319 */             throw new DtxException("An exception occurred while calling setBusinessDate() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "WorkstationId":
/*     */           try {
/* 325 */             Object value = DaoUtils.getFieldValueForXmlString(-5, fieldValue);
/* 326 */             setWorkstationId((Long)value);
/* 327 */           } catch (Exception ee) {
/* 328 */             throw new DtxException("An exception occurred while calling setWorkstationId() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "TransactionSequence":
/*     */           try {
/* 334 */             Object value = DaoUtils.getFieldValueForXmlString(-5, fieldValue);
/* 335 */             setTransactionSequence((Long)value);
/* 336 */           } catch (Exception ee) {
/* 337 */             throw new DtxException("An exception occurred while calling setTransactionSequence() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "PropertyCode":
/*     */           try {
/* 343 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 344 */             setPropertyCode((String)value);
/* 345 */           } catch (Exception ee) {
/* 346 */             throw new DtxException("An exception occurred while calling setPropertyCode() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "Type":
/*     */           try {
/* 352 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 353 */             setType((String)value);
/* 354 */           } catch (Exception ee) {
/* 355 */             throw new DtxException("An exception occurred while calling setType() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "StringValue":
/*     */           try {
/* 361 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 362 */             setStringValue((String)value);
/* 363 */           } catch (Exception ee) {
/* 364 */             throw new DtxException("An exception occurred while calling setStringValue() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "DateValue":
/*     */           try {
/* 370 */             Object value = DaoUtils.getFieldValueForXmlString(91, fieldValue);
/* 371 */             setDateValue((Date)value);
/* 372 */           } catch (Exception ee) {
/* 373 */             throw new DtxException("An exception occurred while calling setDateValue() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "DecimalValue":
/*     */           try {
/* 379 */             Object value = DaoUtils.getFieldValueForXmlString(3, fieldValue);
/* 380 */             setDecimalValue((BigDecimal)value);
/* 381 */           } catch (Exception ee) {
/* 382 */             throw new DtxException("An exception occurred while calling setDecimalValue() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "CreateDate":
/*     */           try {
/* 388 */             Object value = DaoUtils.getFieldValueForXmlString(91, fieldValue);
/* 389 */             setCreateDate((Date)value);
/* 390 */           } catch (Exception ee) {
/* 391 */             throw new DtxException("An exception occurred while calling setCreateDate() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "CreateUserId":
/*     */           try {
/* 397 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 398 */             setCreateUserId((String)value);
/* 399 */           } catch (Exception ee) {
/* 400 */             throw new DtxException("An exception occurred while calling setCreateUserId() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "UpdateDate":
/*     */           try {
/* 406 */             Object value = DaoUtils.getFieldValueForXmlString(91, fieldValue);
/* 407 */             setUpdateDate((Date)value);
/* 408 */           } catch (Exception ee) {
/* 409 */             throw new DtxException("An exception occurred while calling setUpdateDate() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "UpdateUserId":
/*     */           try {
/* 415 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 416 */             setUpdateUserId((String)value);
/* 417 */           } catch (Exception ee) {
/* 418 */             throw new DtxException("An exception occurred while calling setUpdateUserId() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */       } 
/*     */     } 
/*     */   }
/*     */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\trn\impl\TransactionVersionPropertyDAO.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */