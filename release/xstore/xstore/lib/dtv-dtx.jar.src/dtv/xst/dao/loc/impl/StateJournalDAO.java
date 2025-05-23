/*     */ package dtv.xst.dao.loc.impl;
/*     */ 
/*     */ import dtv.data2.access.DaoUtils;
/*     */ import dtv.data2.access.IObjectId;
/*     */ import dtv.data2.access.exception.DtxException;
/*     */ import dtv.data2.access.impl.AbstractDAOImpl;
/*     */ import dtv.util.DtvDate;
/*     */ import dtv.xst.dao.loc.StateJournalId;
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
/*     */ public class StateJournalDAO
/*     */   extends AbstractDAOImpl
/*     */ {
/*     */   private static final long serialVersionUID = -1081884282L;
/*  23 */   private static final Logger _logger = Logger.getLogger(StateJournalDAO.class);
/*     */   
/*     */   private Long _organizationId;
/*     */   private Long _retailLocationId;
/*     */   private Long _workstationId;
/*     */   private String _statusTypcode;
/*     */   private String _stateJournalId;
/*     */   private DtvDate _createDate;
/*     */   private String _createUserId;
/*     */   private DtvDate _updateDate;
/*     */   private String _updateUserId;
/*     */   private DtvDate _dateValue;
/*     */   private String _stringValue;
/*     */   private BigDecimal _decimalValue;
/*     */   private DtvDate _timeStamp;
/*     */   
/*     */   public Long getOrganizationId() {
/*  40 */     return this._organizationId;
/*     */   }
/*     */   
/*     */   public void setOrganizationId(Long argOrganizationId) {
/*  44 */     if (changed(argOrganizationId, this._organizationId, "organizationId")) {
/*  45 */       this._organizationId = argOrganizationId;
/*     */     }
/*     */   }
/*     */   
/*     */   public Long getRetailLocationId() {
/*  50 */     return this._retailLocationId;
/*     */   }
/*     */   
/*     */   public void setRetailLocationId(Long argRetailLocationId) {
/*  54 */     if (changed(argRetailLocationId, this._retailLocationId, "retailLocationId")) {
/*  55 */       this._retailLocationId = argRetailLocationId;
/*     */     }
/*     */   }
/*     */   
/*     */   public Long getWorkstationId() {
/*  60 */     return this._workstationId;
/*     */   }
/*     */   
/*     */   public void setWorkstationId(Long argWorkstationId) {
/*  64 */     if (changed(argWorkstationId, this._workstationId, "workstationId")) {
/*  65 */       this._workstationId = argWorkstationId;
/*     */     }
/*     */   }
/*     */   
/*     */   public String getStatusTypcode() {
/*  70 */     return this._statusTypcode;
/*     */   }
/*     */   
/*     */   public void setStatusTypcode(String argStatusTypcode) {
/*  74 */     if (changed(argStatusTypcode, this._statusTypcode, "statusTypcode")) {
/*  75 */       this._statusTypcode = (argStatusTypcode != null && MANAGE_CASE) ? argStatusTypcode.toUpperCase() : argStatusTypcode;
/*     */     }
/*     */   }
/*     */   
/*     */   public String getStateJournalId() {
/*  80 */     return this._stateJournalId;
/*     */   }
/*     */   
/*     */   public void setStateJournalId(String argStateJournalId) {
/*  84 */     if (changed(argStateJournalId, this._stateJournalId, "stateJournalId")) {
/*  85 */       this._stateJournalId = (argStateJournalId != null && MANAGE_CASE) ? argStateJournalId.toUpperCase() : argStateJournalId;
/*     */     }
/*     */   }
/*     */   
/*     */   public Date getCreateDate() {
/*  90 */     return (Date)this._createDate;
/*     */   }
/*     */   
/*     */   public void setCreateDate(Date argCreateDate) {
/*  94 */     if (changed(argCreateDate, this._createDate, "createDate")) {
/*  95 */       this._createDate = (argCreateDate == null || argCreateDate instanceof DtvDate) ? (DtvDate)argCreateDate : new DtvDate(argCreateDate);
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public String getCreateUserId() {
/* 101 */     return this._createUserId;
/*     */   }
/*     */   
/*     */   public void setCreateUserId(String argCreateUserId) {
/* 105 */     if (changed(argCreateUserId, this._createUserId, "createUserId")) {
/* 106 */       this._createUserId = argCreateUserId;
/*     */     }
/*     */   }
/*     */   
/*     */   public Date getUpdateDate() {
/* 111 */     return (Date)this._updateDate;
/*     */   }
/*     */   
/*     */   public void setUpdateDate(Date argUpdateDate) {
/* 115 */     if (changed(argUpdateDate, this._updateDate, "updateDate")) {
/* 116 */       this._updateDate = (argUpdateDate == null || argUpdateDate instanceof DtvDate) ? (DtvDate)argUpdateDate : new DtvDate(argUpdateDate);
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public String getUpdateUserId() {
/* 122 */     return this._updateUserId;
/*     */   }
/*     */   
/*     */   public void setUpdateUserId(String argUpdateUserId) {
/* 126 */     if (changed(argUpdateUserId, this._updateUserId, "updateUserId")) {
/* 127 */       this._updateUserId = argUpdateUserId;
/*     */     }
/*     */   }
/*     */   
/*     */   public Date getDateValue() {
/* 132 */     return (Date)this._dateValue;
/*     */   }
/*     */   
/*     */   public void setDateValue(Date argDateValue) {
/* 136 */     if (changed(argDateValue, this._dateValue, "dateValue")) {
/* 137 */       this._dateValue = (argDateValue == null || argDateValue instanceof DtvDate) ? (DtvDate)argDateValue : new DtvDate(argDateValue);
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public String getStringValue() {
/* 143 */     return this._stringValue;
/*     */   }
/*     */   
/*     */   public void setStringValue(String argStringValue) {
/* 147 */     if (changed(argStringValue, this._stringValue, "stringValue")) {
/* 148 */       this._stringValue = argStringValue;
/*     */     }
/*     */   }
/*     */   
/*     */   public BigDecimal getDecimalValue() {
/* 153 */     return this._decimalValue;
/*     */   }
/*     */   
/*     */   public void setDecimalValue(BigDecimal argDecimalValue) {
/* 157 */     if (changed(argDecimalValue, this._decimalValue, "decimalValue")) {
/* 158 */       this._decimalValue = argDecimalValue;
/*     */     }
/*     */   }
/*     */   
/*     */   public Date getTimeStamp() {
/* 163 */     return (Date)this._timeStamp;
/*     */   }
/*     */   
/*     */   public void setTimeStamp(Date argTimeStamp) {
/* 167 */     if (changed(argTimeStamp, this._timeStamp, "timeStamp")) {
/* 168 */       this._timeStamp = (argTimeStamp == null || argTimeStamp instanceof DtvDate) ? (DtvDate)argTimeStamp : new DtvDate(argTimeStamp);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String toString() {
/* 176 */     StringBuilder buf = new StringBuilder(512);
/* 177 */     buf.append(super.toString()).append(" Id: ").append(getObjectId()).append(" Values: ");
/* 178 */     if (getOrganizationId() != null) {
/* 179 */       buf.append("organizationId").append("=").append(getOrganizationId()).append(" ");
/*     */     }
/* 181 */     if (getRetailLocationId() != null) {
/* 182 */       buf.append("retailLocationId").append("=").append(getRetailLocationId()).append(" ");
/*     */     }
/* 184 */     if (getWorkstationId() != null) {
/* 185 */       buf.append("workstationId").append("=").append(getWorkstationId()).append(" ");
/*     */     }
/* 187 */     if (getStatusTypcode() != null) {
/* 188 */       buf.append("statusTypcode").append("=").append(getStatusTypcode()).append(" ");
/*     */     }
/* 190 */     if (getStateJournalId() != null) {
/* 191 */       buf.append("stateJournalId").append("=").append(getStateJournalId()).append(" ");
/*     */     }
/* 193 */     if (getCreateDate() != null) {
/* 194 */       buf.append("createDate").append("=").append(getCreateDate()).append(" ");
/*     */     }
/* 196 */     if (getCreateUserId() != null) {
/* 197 */       buf.append("createUserId").append("=").append(getCreateUserId()).append(" ");
/*     */     }
/* 199 */     if (getUpdateDate() != null) {
/* 200 */       buf.append("updateDate").append("=").append(getUpdateDate()).append(" ");
/*     */     }
/* 202 */     if (getUpdateUserId() != null) {
/* 203 */       buf.append("updateUserId").append("=").append(getUpdateUserId()).append(" ");
/*     */     }
/* 205 */     if (getDateValue() != null) {
/* 206 */       buf.append("dateValue").append("=").append(getDateValue()).append(" ");
/*     */     }
/* 208 */     if (getStringValue() != null) {
/* 209 */       buf.append("stringValue").append("=").append(getStringValue()).append(" ");
/*     */     }
/* 211 */     if (getDecimalValue() != null) {
/* 212 */       buf.append("decimalValue").append("=").append(getDecimalValue()).append(" ");
/*     */     }
/* 214 */     if (getTimeStamp() != null) {
/* 215 */       buf.append("timeStamp").append("=").append(getTimeStamp()).append(" ");
/*     */     }
/*     */     
/* 218 */     return buf.toString();
/*     */   }
/*     */   
/*     */   public IObjectId getObjectId() {
/* 222 */     StateJournalId id = new StateJournalId();
/* 223 */     id.setOrganizationId(getOrganizationId());
/* 224 */     id.setRetailLocationId(getRetailLocationId());
/* 225 */     id.setWorkstationId(getWorkstationId());
/* 226 */     id.setStatusTypcode(getStatusTypcode());
/* 227 */     id.setStateJournalId(getStateJournalId());
/* 228 */     return (IObjectId)id;
/*     */   }
/*     */   
/*     */   public void setObjectId(IObjectId argObjectId) {
/* 232 */     setOrganizationId(((StateJournalId)argObjectId).getOrganizationId());
/* 233 */     setRetailLocationId(((StateJournalId)argObjectId).getRetailLocationId());
/* 234 */     setWorkstationId(((StateJournalId)argObjectId).getWorkstationId());
/* 235 */     setStatusTypcode(((StateJournalId)argObjectId).getStatusTypcode());
/* 236 */     setStateJournalId(((StateJournalId)argObjectId).getStateJournalId());
/*     */   }
/*     */   
/*     */   public String getImplementingClass() {
/* 240 */     return null;
/*     */   }
/*     */   
/*     */   public String toXmlString() {
/* 244 */     StringBuilder buf = new StringBuilder(650);
/* 245 */     buf.append("<").append("dao").append(" name=\"StateJournal\" cmd=\"" + getObjectStateString() + "\">");
/* 246 */     getFieldsAsXml(buf);
/* 247 */     buf.append("</").append("dao").append(">");
/*     */     
/* 249 */     return buf.toString();
/*     */   }
/*     */   
/*     */   public Map<String, String> getValues() {
/* 253 */     Map<String, String> values = super.getValues();
/* 254 */     if (this._organizationId != null) values.put("OrganizationId", DaoUtils.getXmlSafeFieldValue(-5, this._organizationId)); 
/* 255 */     if (this._retailLocationId != null) values.put("RetailLocationId", DaoUtils.getXmlSafeFieldValue(-5, this._retailLocationId)); 
/* 256 */     if (this._workstationId != null) values.put("WorkstationId", DaoUtils.getXmlSafeFieldValue(-5, this._workstationId)); 
/* 257 */     if (this._statusTypcode != null) values.put("StatusTypcode", DaoUtils.getXmlSafeFieldValue(12, this._statusTypcode)); 
/* 258 */     if (this._stateJournalId != null) values.put("StateJournalId", DaoUtils.getXmlSafeFieldValue(12, this._stateJournalId)); 
/* 259 */     if (this._createDate != null) values.put("CreateDate", DaoUtils.getXmlSafeFieldValue(91, this._createDate)); 
/* 260 */     if (this._createUserId != null) values.put("CreateUserId", DaoUtils.getXmlSafeFieldValue(12, this._createUserId)); 
/* 261 */     if (this._updateDate != null) values.put("UpdateDate", DaoUtils.getXmlSafeFieldValue(91, this._updateDate)); 
/* 262 */     if (this._updateUserId != null) values.put("UpdateUserId", DaoUtils.getXmlSafeFieldValue(12, this._updateUserId)); 
/* 263 */     if (this._dateValue != null) values.put("DateValue", DaoUtils.getXmlSafeFieldValue(91, this._dateValue)); 
/* 264 */     if (this._stringValue != null) values.put("StringValue", DaoUtils.getXmlSafeFieldValue(12, this._stringValue)); 
/* 265 */     if (this._decimalValue != null) values.put("DecimalValue", DaoUtils.getXmlSafeFieldValue(3, this._decimalValue)); 
/* 266 */     if (this._timeStamp != null) values.put("TimeStamp", DaoUtils.getXmlSafeFieldValue(91, this._timeStamp)); 
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
/*     */         case "OrganizationId":
/*     */           try {
/* 281 */             Object value = DaoUtils.getFieldValueForXmlString(-5, fieldValue);
/* 282 */             setOrganizationId((Long)value);
/* 283 */           } catch (Exception ee) {
/* 284 */             throw new DtxException("An exception occurred while calling setOrganizationId() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "RetailLocationId":
/*     */           try {
/* 290 */             Object value = DaoUtils.getFieldValueForXmlString(-5, fieldValue);
/* 291 */             setRetailLocationId((Long)value);
/* 292 */           } catch (Exception ee) {
/* 293 */             throw new DtxException("An exception occurred while calling setRetailLocationId() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "WorkstationId":
/*     */           try {
/* 299 */             Object value = DaoUtils.getFieldValueForXmlString(-5, fieldValue);
/* 300 */             setWorkstationId((Long)value);
/* 301 */           } catch (Exception ee) {
/* 302 */             throw new DtxException("An exception occurred while calling setWorkstationId() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "StatusTypcode":
/*     */           try {
/* 308 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 309 */             setStatusTypcode((String)value);
/* 310 */           } catch (Exception ee) {
/* 311 */             throw new DtxException("An exception occurred while calling setStatusTypcode() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "StateJournalId":
/*     */           try {
/* 317 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 318 */             setStateJournalId((String)value);
/* 319 */           } catch (Exception ee) {
/* 320 */             throw new DtxException("An exception occurred while calling setStateJournalId() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "CreateDate":
/*     */           try {
/* 326 */             Object value = DaoUtils.getFieldValueForXmlString(91, fieldValue);
/* 327 */             setCreateDate((Date)value);
/* 328 */           } catch (Exception ee) {
/* 329 */             throw new DtxException("An exception occurred while calling setCreateDate() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "CreateUserId":
/*     */           try {
/* 335 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 336 */             setCreateUserId((String)value);
/* 337 */           } catch (Exception ee) {
/* 338 */             throw new DtxException("An exception occurred while calling setCreateUserId() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "UpdateDate":
/*     */           try {
/* 344 */             Object value = DaoUtils.getFieldValueForXmlString(91, fieldValue);
/* 345 */             setUpdateDate((Date)value);
/* 346 */           } catch (Exception ee) {
/* 347 */             throw new DtxException("An exception occurred while calling setUpdateDate() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "UpdateUserId":
/*     */           try {
/* 353 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 354 */             setUpdateUserId((String)value);
/* 355 */           } catch (Exception ee) {
/* 356 */             throw new DtxException("An exception occurred while calling setUpdateUserId() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "DateValue":
/*     */           try {
/* 362 */             Object value = DaoUtils.getFieldValueForXmlString(91, fieldValue);
/* 363 */             setDateValue((Date)value);
/* 364 */           } catch (Exception ee) {
/* 365 */             throw new DtxException("An exception occurred while calling setDateValue() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "StringValue":
/*     */           try {
/* 371 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 372 */             setStringValue((String)value);
/* 373 */           } catch (Exception ee) {
/* 374 */             throw new DtxException("An exception occurred while calling setStringValue() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "DecimalValue":
/*     */           try {
/* 380 */             Object value = DaoUtils.getFieldValueForXmlString(3, fieldValue);
/* 381 */             setDecimalValue((BigDecimal)value);
/* 382 */           } catch (Exception ee) {
/* 383 */             throw new DtxException("An exception occurred while calling setDecimalValue() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "TimeStamp":
/*     */           try {
/* 389 */             Object value = DaoUtils.getFieldValueForXmlString(91, fieldValue);
/* 390 */             setTimeStamp((Date)value);
/* 391 */           } catch (Exception ee) {
/* 392 */             throw new DtxException("An exception occurred while calling setTimeStamp() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */       } 
/*     */     } 
/*     */   }
/*     */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\loc\impl\StateJournalDAO.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */