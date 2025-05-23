/*     */ package dtv.xst.dao.thr.impl;
/*     */ 
/*     */ import dtv.data2.access.DaoUtils;
/*     */ import dtv.data2.access.IObjectId;
/*     */ import dtv.data2.access.exception.DtxException;
/*     */ import dtv.data2.access.impl.AbstractDAOImpl;
/*     */ import dtv.util.DtvDate;
/*     */ import dtv.xst.dao.thr.TimecardEntryCommentPropertyId;
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
/*     */ public class TimecardEntryCommentPropertyDAO
/*     */   extends AbstractDAOImpl
/*     */ {
/*     */   private static final long serialVersionUID = 991786399L;
/*  23 */   private static final Logger _logger = Logger.getLogger(TimecardEntryCommentPropertyDAO.class);
/*     */   
/*     */   private Long _organizationId;
/*     */   private DtvDate _weekEndingDate;
/*     */   private Long _retailLocationId;
/*     */   private Long _workstationId;
/*     */   private Long _partyId;
/*     */   private Long _commentSeq;
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
/*  42 */     return this._organizationId;
/*     */   }
/*     */   
/*     */   public void setOrganizationId(Long argOrganizationId) {
/*  46 */     if (changed(argOrganizationId, this._organizationId, "organizationId")) {
/*  47 */       this._organizationId = argOrganizationId;
/*     */     }
/*     */   }
/*     */   
/*     */   public Date getWeekEndingDate() {
/*  52 */     return (Date)this._weekEndingDate;
/*     */   }
/*     */   
/*     */   public void setWeekEndingDate(Date argWeekEndingDate) {
/*  56 */     if (changed(argWeekEndingDate, this._weekEndingDate, "weekEndingDate")) {
/*  57 */       this._weekEndingDate = (argWeekEndingDate == null || argWeekEndingDate instanceof DtvDate) ? (DtvDate)argWeekEndingDate : new DtvDate(argWeekEndingDate);
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public Long getRetailLocationId() {
/*  63 */     return this._retailLocationId;
/*     */   }
/*     */   
/*     */   public void setRetailLocationId(Long argRetailLocationId) {
/*  67 */     if (changed(argRetailLocationId, this._retailLocationId, "retailLocationId")) {
/*  68 */       this._retailLocationId = argRetailLocationId;
/*     */     }
/*     */   }
/*     */   
/*     */   public Long getWorkstationId() {
/*  73 */     return this._workstationId;
/*     */   }
/*     */   
/*     */   public void setWorkstationId(Long argWorkstationId) {
/*  77 */     if (changed(argWorkstationId, this._workstationId, "workstationId")) {
/*  78 */       this._workstationId = argWorkstationId;
/*     */     }
/*     */   }
/*     */   
/*     */   public Long getPartyId() {
/*  83 */     return this._partyId;
/*     */   }
/*     */   
/*     */   public void setPartyId(Long argPartyId) {
/*  87 */     if (changed(argPartyId, this._partyId, "partyId")) {
/*  88 */       this._partyId = argPartyId;
/*     */     }
/*     */   }
/*     */   
/*     */   public Long getCommentSeq() {
/*  93 */     return this._commentSeq;
/*     */   }
/*     */   
/*     */   public void setCommentSeq(Long argCommentSeq) {
/*  97 */     if (changed(argCommentSeq, this._commentSeq, "commentSeq")) {
/*  98 */       this._commentSeq = argCommentSeq;
/*     */     }
/*     */   }
/*     */   
/*     */   public String getPropertyCode() {
/* 103 */     return this._propertyCode;
/*     */   }
/*     */   
/*     */   public void setPropertyCode(String argPropertyCode) {
/* 107 */     if (changed(argPropertyCode, this._propertyCode, "propertyCode")) {
/* 108 */       this._propertyCode = (argPropertyCode != null && MANAGE_CASE) ? argPropertyCode.toUpperCase() : argPropertyCode;
/*     */     }
/*     */   }
/*     */   
/*     */   public String getType() {
/* 113 */     return this._type;
/*     */   }
/*     */   
/*     */   public void setType(String argType) {
/* 117 */     if (changed(argType, this._type, "type")) {
/* 118 */       this._type = argType;
/*     */     }
/*     */   }
/*     */   
/*     */   public String getStringValue() {
/* 123 */     return this._stringValue;
/*     */   }
/*     */   
/*     */   public void setStringValue(String argStringValue) {
/* 127 */     if (changed(argStringValue, this._stringValue, "stringValue")) {
/* 128 */       this._stringValue = argStringValue;
/*     */     }
/*     */   }
/*     */   
/*     */   public Date getDateValue() {
/* 133 */     return (Date)this._dateValue;
/*     */   }
/*     */   
/*     */   public void setDateValue(Date argDateValue) {
/* 137 */     if (changed(argDateValue, this._dateValue, "dateValue")) {
/* 138 */       this._dateValue = (argDateValue == null || argDateValue instanceof DtvDate) ? (DtvDate)argDateValue : new DtvDate(argDateValue);
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public BigDecimal getDecimalValue() {
/* 144 */     return this._decimalValue;
/*     */   }
/*     */   
/*     */   public void setDecimalValue(BigDecimal argDecimalValue) {
/* 148 */     if (changed(argDecimalValue, this._decimalValue, "decimalValue")) {
/* 149 */       this._decimalValue = argDecimalValue;
/*     */     }
/*     */   }
/*     */   
/*     */   public Date getCreateDate() {
/* 154 */     return (Date)this._createDate;
/*     */   }
/*     */   
/*     */   public void setCreateDate(Date argCreateDate) {
/* 158 */     if (changed(argCreateDate, this._createDate, "createDate")) {
/* 159 */       this._createDate = (argCreateDate == null || argCreateDate instanceof DtvDate) ? (DtvDate)argCreateDate : new DtvDate(argCreateDate);
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public String getCreateUserId() {
/* 165 */     return this._createUserId;
/*     */   }
/*     */   
/*     */   public void setCreateUserId(String argCreateUserId) {
/* 169 */     if (changed(argCreateUserId, this._createUserId, "createUserId")) {
/* 170 */       this._createUserId = argCreateUserId;
/*     */     }
/*     */   }
/*     */   
/*     */   public Date getUpdateDate() {
/* 175 */     return (Date)this._updateDate;
/*     */   }
/*     */   
/*     */   public void setUpdateDate(Date argUpdateDate) {
/* 179 */     if (changed(argUpdateDate, this._updateDate, "updateDate")) {
/* 180 */       this._updateDate = (argUpdateDate == null || argUpdateDate instanceof DtvDate) ? (DtvDate)argUpdateDate : new DtvDate(argUpdateDate);
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public String getUpdateUserId() {
/* 186 */     return this._updateUserId;
/*     */   }
/*     */   
/*     */   public void setUpdateUserId(String argUpdateUserId) {
/* 190 */     if (changed(argUpdateUserId, this._updateUserId, "updateUserId")) {
/* 191 */       this._updateUserId = argUpdateUserId;
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public String toString() {
/* 198 */     StringBuilder buf = new StringBuilder(512);
/* 199 */     buf.append(super.toString()).append(" Id: ").append(getObjectId()).append(" Values: ");
/* 200 */     if (getOrganizationId() != null) {
/* 201 */       buf.append("organizationId").append("=").append(getOrganizationId()).append(" ");
/*     */     }
/* 203 */     if (getWeekEndingDate() != null) {
/* 204 */       buf.append("weekEndingDate").append("=").append(getWeekEndingDate()).append(" ");
/*     */     }
/* 206 */     if (getRetailLocationId() != null) {
/* 207 */       buf.append("retailLocationId").append("=").append(getRetailLocationId()).append(" ");
/*     */     }
/* 209 */     if (getWorkstationId() != null) {
/* 210 */       buf.append("workstationId").append("=").append(getWorkstationId()).append(" ");
/*     */     }
/* 212 */     if (getPartyId() != null) {
/* 213 */       buf.append("partyId").append("=").append(getPartyId()).append(" ");
/*     */     }
/* 215 */     if (getCommentSeq() != null) {
/* 216 */       buf.append("commentSeq").append("=").append(getCommentSeq()).append(" ");
/*     */     }
/* 218 */     if (getPropertyCode() != null) {
/* 219 */       buf.append("propertyCode").append("=").append(getPropertyCode()).append(" ");
/*     */     }
/* 221 */     if (getType() != null) {
/* 222 */       buf.append("type").append("=").append(getType()).append(" ");
/*     */     }
/* 224 */     if (getStringValue() != null) {
/* 225 */       buf.append("stringValue").append("=").append(getStringValue()).append(" ");
/*     */     }
/* 227 */     if (getDateValue() != null) {
/* 228 */       buf.append("dateValue").append("=").append(getDateValue()).append(" ");
/*     */     }
/* 230 */     if (getDecimalValue() != null) {
/* 231 */       buf.append("decimalValue").append("=").append(getDecimalValue()).append(" ");
/*     */     }
/* 233 */     if (getCreateDate() != null) {
/* 234 */       buf.append("createDate").append("=").append(getCreateDate()).append(" ");
/*     */     }
/* 236 */     if (getCreateUserId() != null) {
/* 237 */       buf.append("createUserId").append("=").append(getCreateUserId()).append(" ");
/*     */     }
/* 239 */     if (getUpdateDate() != null) {
/* 240 */       buf.append("updateDate").append("=").append(getUpdateDate()).append(" ");
/*     */     }
/* 242 */     if (getUpdateUserId() != null) {
/* 243 */       buf.append("updateUserId").append("=").append(getUpdateUserId()).append(" ");
/*     */     }
/*     */     
/* 246 */     return buf.toString();
/*     */   }
/*     */   
/*     */   public IObjectId getObjectId() {
/* 250 */     TimecardEntryCommentPropertyId id = new TimecardEntryCommentPropertyId();
/* 251 */     id.setOrganizationId(getOrganizationId());
/* 252 */     id.setWeekEndingDate(getWeekEndingDate());
/* 253 */     id.setRetailLocationId(getRetailLocationId());
/* 254 */     id.setWorkstationId(getWorkstationId());
/* 255 */     id.setPartyId(getPartyId());
/* 256 */     id.setCommentSeq(getCommentSeq());
/* 257 */     id.setPropertyCode(getPropertyCode());
/* 258 */     return (IObjectId)id;
/*     */   }
/*     */   
/*     */   public void setObjectId(IObjectId argObjectId) {
/* 262 */     setOrganizationId(((TimecardEntryCommentPropertyId)argObjectId).getOrganizationId());
/* 263 */     setWeekEndingDate(((TimecardEntryCommentPropertyId)argObjectId).getWeekEndingDate());
/* 264 */     setRetailLocationId(((TimecardEntryCommentPropertyId)argObjectId).getRetailLocationId());
/* 265 */     setWorkstationId(((TimecardEntryCommentPropertyId)argObjectId).getWorkstationId());
/* 266 */     setPartyId(((TimecardEntryCommentPropertyId)argObjectId).getPartyId());
/* 267 */     setCommentSeq(((TimecardEntryCommentPropertyId)argObjectId).getCommentSeq());
/* 268 */     setPropertyCode(((TimecardEntryCommentPropertyId)argObjectId).getPropertyCode());
/*     */   }
/*     */   
/*     */   public String getImplementingClass() {
/* 272 */     return null;
/*     */   }
/*     */   
/*     */   public String toXmlString() {
/* 276 */     StringBuilder buf = new StringBuilder(750);
/* 277 */     buf.append("<").append("dao").append(" name=\"TimecardEntryCommentProperty\" cmd=\"" + getObjectStateString() + "\">");
/* 278 */     getFieldsAsXml(buf);
/* 279 */     buf.append("</").append("dao").append(">");
/*     */     
/* 281 */     return buf.toString();
/*     */   }
/*     */   
/*     */   public Map<String, String> getValues() {
/* 285 */     Map<String, String> values = super.getValues();
/* 286 */     if (this._organizationId != null) values.put("OrganizationId", DaoUtils.getXmlSafeFieldValue(-5, this._organizationId)); 
/* 287 */     if (this._weekEndingDate != null) values.put("WeekEndingDate", DaoUtils.getXmlSafeFieldValue(91, this._weekEndingDate)); 
/* 288 */     if (this._retailLocationId != null) values.put("RetailLocationId", DaoUtils.getXmlSafeFieldValue(-5, this._retailLocationId)); 
/* 289 */     if (this._workstationId != null) values.put("WorkstationId", DaoUtils.getXmlSafeFieldValue(-5, this._workstationId)); 
/* 290 */     if (this._partyId != null) values.put("PartyId", DaoUtils.getXmlSafeFieldValue(-5, this._partyId)); 
/* 291 */     if (this._commentSeq != null) values.put("CommentSeq", DaoUtils.getXmlSafeFieldValue(-5, this._commentSeq)); 
/* 292 */     if (this._propertyCode != null) values.put("PropertyCode", DaoUtils.getXmlSafeFieldValue(12, this._propertyCode)); 
/* 293 */     if (this._type != null) values.put("Type", DaoUtils.getXmlSafeFieldValue(12, this._type)); 
/* 294 */     if (this._stringValue != null) values.put("StringValue", DaoUtils.getXmlSafeFieldValue(12, this._stringValue)); 
/* 295 */     if (this._dateValue != null) values.put("DateValue", DaoUtils.getXmlSafeFieldValue(91, this._dateValue)); 
/* 296 */     if (this._decimalValue != null) values.put("DecimalValue", DaoUtils.getXmlSafeFieldValue(3, this._decimalValue)); 
/* 297 */     if (this._createDate != null) values.put("CreateDate", DaoUtils.getXmlSafeFieldValue(91, this._createDate)); 
/* 298 */     if (this._createUserId != null) values.put("CreateUserId", DaoUtils.getXmlSafeFieldValue(12, this._createUserId)); 
/* 299 */     if (this._updateDate != null) values.put("UpdateDate", DaoUtils.getXmlSafeFieldValue(91, this._updateDate)); 
/* 300 */     if (this._updateUserId != null) values.put("UpdateUserId", DaoUtils.getXmlSafeFieldValue(12, this._updateUserId)); 
/* 301 */     return values;
/*     */   }
/*     */ 
/*     */   
/*     */   public void setValues(Map<String, String> argValues) {
/* 306 */     super.setValues(argValues);
/* 307 */     for (Map.Entry<String, String> field : argValues.entrySet()) {
/*     */       
/* 309 */       String fieldName = field.getKey();
/* 310 */       String fieldValue = field.getValue();
/* 311 */       switch (fieldName) {
/*     */         
/*     */         case "OrganizationId":
/*     */           try {
/* 315 */             Object value = DaoUtils.getFieldValueForXmlString(-5, fieldValue);
/* 316 */             setOrganizationId((Long)value);
/* 317 */           } catch (Exception ee) {
/* 318 */             throw new DtxException("An exception occurred while calling setOrganizationId() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "WeekEndingDate":
/*     */           try {
/* 324 */             Object value = DaoUtils.getFieldValueForXmlString(91, fieldValue);
/* 325 */             setWeekEndingDate((Date)value);
/* 326 */           } catch (Exception ee) {
/* 327 */             throw new DtxException("An exception occurred while calling setWeekEndingDate() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "RetailLocationId":
/*     */           try {
/* 333 */             Object value = DaoUtils.getFieldValueForXmlString(-5, fieldValue);
/* 334 */             setRetailLocationId((Long)value);
/* 335 */           } catch (Exception ee) {
/* 336 */             throw new DtxException("An exception occurred while calling setRetailLocationId() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "WorkstationId":
/*     */           try {
/* 342 */             Object value = DaoUtils.getFieldValueForXmlString(-5, fieldValue);
/* 343 */             setWorkstationId((Long)value);
/* 344 */           } catch (Exception ee) {
/* 345 */             throw new DtxException("An exception occurred while calling setWorkstationId() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "PartyId":
/*     */           try {
/* 351 */             Object value = DaoUtils.getFieldValueForXmlString(-5, fieldValue);
/* 352 */             setPartyId((Long)value);
/* 353 */           } catch (Exception ee) {
/* 354 */             throw new DtxException("An exception occurred while calling setPartyId() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "CommentSeq":
/*     */           try {
/* 360 */             Object value = DaoUtils.getFieldValueForXmlString(-5, fieldValue);
/* 361 */             setCommentSeq((Long)value);
/* 362 */           } catch (Exception ee) {
/* 363 */             throw new DtxException("An exception occurred while calling setCommentSeq() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "PropertyCode":
/*     */           try {
/* 369 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 370 */             setPropertyCode((String)value);
/* 371 */           } catch (Exception ee) {
/* 372 */             throw new DtxException("An exception occurred while calling setPropertyCode() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "Type":
/*     */           try {
/* 378 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 379 */             setType((String)value);
/* 380 */           } catch (Exception ee) {
/* 381 */             throw new DtxException("An exception occurred while calling setType() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "StringValue":
/*     */           try {
/* 387 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 388 */             setStringValue((String)value);
/* 389 */           } catch (Exception ee) {
/* 390 */             throw new DtxException("An exception occurred while calling setStringValue() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "DateValue":
/*     */           try {
/* 396 */             Object value = DaoUtils.getFieldValueForXmlString(91, fieldValue);
/* 397 */             setDateValue((Date)value);
/* 398 */           } catch (Exception ee) {
/* 399 */             throw new DtxException("An exception occurred while calling setDateValue() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "DecimalValue":
/*     */           try {
/* 405 */             Object value = DaoUtils.getFieldValueForXmlString(3, fieldValue);
/* 406 */             setDecimalValue((BigDecimal)value);
/* 407 */           } catch (Exception ee) {
/* 408 */             throw new DtxException("An exception occurred while calling setDecimalValue() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "CreateDate":
/*     */           try {
/* 414 */             Object value = DaoUtils.getFieldValueForXmlString(91, fieldValue);
/* 415 */             setCreateDate((Date)value);
/* 416 */           } catch (Exception ee) {
/* 417 */             throw new DtxException("An exception occurred while calling setCreateDate() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "CreateUserId":
/*     */           try {
/* 423 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 424 */             setCreateUserId((String)value);
/* 425 */           } catch (Exception ee) {
/* 426 */             throw new DtxException("An exception occurred while calling setCreateUserId() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "UpdateDate":
/*     */           try {
/* 432 */             Object value = DaoUtils.getFieldValueForXmlString(91, fieldValue);
/* 433 */             setUpdateDate((Date)value);
/* 434 */           } catch (Exception ee) {
/* 435 */             throw new DtxException("An exception occurred while calling setUpdateDate() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "UpdateUserId":
/*     */           try {
/* 441 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 442 */             setUpdateUserId((String)value);
/* 443 */           } catch (Exception ee) {
/* 444 */             throw new DtxException("An exception occurred while calling setUpdateUserId() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */       } 
/*     */     } 
/*     */   }
/*     */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\thr\impl\TimecardEntryCommentPropertyDAO.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */