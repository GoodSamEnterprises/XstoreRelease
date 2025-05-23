/*     */ package dtv.xst.dao.itm.impl;
/*     */ 
/*     */ import dtv.data2.access.DaoUtils;
/*     */ import dtv.data2.access.IObjectId;
/*     */ import dtv.data2.access.exception.DtxException;
/*     */ import dtv.data2.access.impl.AbstractDAOImpl;
/*     */ import dtv.util.DtvDate;
/*     */ import dtv.xst.dao.itm.SubstituteItemsId;
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
/*     */ public class SubstituteItemsDAO
/*     */   extends AbstractDAOImpl
/*     */ {
/*     */   private static final long serialVersionUID = 453630758L;
/*  23 */   private static final Logger _logger = Logger.getLogger(SubstituteItemsDAO.class);
/*     */   
/*     */   private Long _organizationId;
/*     */   private String _primaryItemId;
/*     */   private String _substituteItemId;
/*     */   private String _levelCode;
/*     */   private String _levelValue;
/*     */   private DtvDate _createDate;
/*     */   private String _createUserId;
/*     */   private DtvDate _updateDate;
/*     */   private String _updateUserId;
/*     */   private DtvDate _beginDatetime;
/*     */   private DtvDate _endDatetime;
/*     */   private String _externalId;
/*     */   private String _externalSystem;
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
/*     */   public String getPrimaryItemId() {
/*  50 */     return this._primaryItemId;
/*     */   }
/*     */   
/*     */   public void setPrimaryItemId(String argPrimaryItemId) {
/*  54 */     if (changed(argPrimaryItemId, this._primaryItemId, "primaryItemId")) {
/*  55 */       this._primaryItemId = (argPrimaryItemId != null && MANAGE_CASE) ? argPrimaryItemId.toUpperCase() : argPrimaryItemId;
/*     */     }
/*     */   }
/*     */   
/*     */   public String getSubstituteItemId() {
/*  60 */     return this._substituteItemId;
/*     */   }
/*     */   
/*     */   public void setSubstituteItemId(String argSubstituteItemId) {
/*  64 */     if (changed(argSubstituteItemId, this._substituteItemId, "substituteItemId")) {
/*  65 */       this._substituteItemId = (argSubstituteItemId != null && MANAGE_CASE) ? argSubstituteItemId.toUpperCase() : argSubstituteItemId;
/*     */     }
/*     */   }
/*     */   
/*     */   public String getLevelCode() {
/*  70 */     return this._levelCode;
/*     */   }
/*     */   
/*     */   public void setLevelCode(String argLevelCode) {
/*  74 */     if (changed(argLevelCode, this._levelCode, "levelCode")) {
/*  75 */       this._levelCode = (argLevelCode != null && MANAGE_CASE) ? argLevelCode.toUpperCase() : argLevelCode;
/*     */     }
/*     */   }
/*     */   
/*     */   public String getLevelValue() {
/*  80 */     return this._levelValue;
/*     */   }
/*     */   
/*     */   public void setLevelValue(String argLevelValue) {
/*  84 */     if (changed(argLevelValue, this._levelValue, "levelValue")) {
/*  85 */       this._levelValue = (argLevelValue != null && MANAGE_CASE) ? argLevelValue.toUpperCase() : argLevelValue;
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
/*     */   public Date getBeginDatetime() {
/* 132 */     return (Date)this._beginDatetime;
/*     */   }
/*     */   
/*     */   public void setBeginDatetime(Date argBeginDatetime) {
/* 136 */     if (changed(argBeginDatetime, this._beginDatetime, "beginDatetime")) {
/* 137 */       this._beginDatetime = (argBeginDatetime == null || argBeginDatetime instanceof DtvDate) ? (DtvDate)argBeginDatetime : new DtvDate(argBeginDatetime);
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public Date getEndDatetime() {
/* 143 */     return (Date)this._endDatetime;
/*     */   }
/*     */   
/*     */   public void setEndDatetime(Date argEndDatetime) {
/* 147 */     if (changed(argEndDatetime, this._endDatetime, "endDatetime")) {
/* 148 */       this._endDatetime = (argEndDatetime == null || argEndDatetime instanceof DtvDate) ? (DtvDate)argEndDatetime : new DtvDate(argEndDatetime);
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public String getExternalId() {
/* 154 */     return this._externalId;
/*     */   }
/*     */   
/*     */   public void setExternalId(String argExternalId) {
/* 158 */     if (changed(argExternalId, this._externalId, "externalId")) {
/* 159 */       this._externalId = argExternalId;
/*     */     }
/*     */   }
/*     */   
/*     */   public String getExternalSystem() {
/* 164 */     return this._externalSystem;
/*     */   }
/*     */   
/*     */   public void setExternalSystem(String argExternalSystem) {
/* 168 */     if (changed(argExternalSystem, this._externalSystem, "externalSystem")) {
/* 169 */       this._externalSystem = argExternalSystem;
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public String toString() {
/* 176 */     StringBuilder buf = new StringBuilder(512);
/* 177 */     buf.append(super.toString()).append(" Id: ").append(getObjectId()).append(" Values: ");
/* 178 */     if (getOrganizationId() != null) {
/* 179 */       buf.append("organizationId").append("=").append(getOrganizationId()).append(" ");
/*     */     }
/* 181 */     if (getPrimaryItemId() != null) {
/* 182 */       buf.append("primaryItemId").append("=").append(getPrimaryItemId()).append(" ");
/*     */     }
/* 184 */     if (getSubstituteItemId() != null) {
/* 185 */       buf.append("substituteItemId").append("=").append(getSubstituteItemId()).append(" ");
/*     */     }
/* 187 */     if (getLevelCode() != null) {
/* 188 */       buf.append("levelCode").append("=").append(getLevelCode()).append(" ");
/*     */     }
/* 190 */     if (getLevelValue() != null) {
/* 191 */       buf.append("levelValue").append("=").append(getLevelValue()).append(" ");
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
/* 205 */     if (getBeginDatetime() != null) {
/* 206 */       buf.append("beginDatetime").append("=").append(getBeginDatetime()).append(" ");
/*     */     }
/* 208 */     if (getEndDatetime() != null) {
/* 209 */       buf.append("endDatetime").append("=").append(getEndDatetime()).append(" ");
/*     */     }
/* 211 */     if (getExternalId() != null) {
/* 212 */       buf.append("externalId").append("=").append(getExternalId()).append(" ");
/*     */     }
/* 214 */     if (getExternalSystem() != null) {
/* 215 */       buf.append("externalSystem").append("=").append(getExternalSystem()).append(" ");
/*     */     }
/*     */     
/* 218 */     return buf.toString();
/*     */   }
/*     */   
/*     */   public IObjectId getObjectId() {
/* 222 */     SubstituteItemsId id = new SubstituteItemsId();
/* 223 */     id.setOrganizationId(getOrganizationId());
/* 224 */     id.setPrimaryItemId(getPrimaryItemId());
/* 225 */     id.setSubstituteItemId(getSubstituteItemId());
/* 226 */     id.setLevelCode(getLevelCode());
/* 227 */     id.setLevelValue(getLevelValue());
/* 228 */     return (IObjectId)id;
/*     */   }
/*     */   
/*     */   public void setObjectId(IObjectId argObjectId) {
/* 232 */     setOrganizationId(((SubstituteItemsId)argObjectId).getOrganizationId());
/* 233 */     setPrimaryItemId(((SubstituteItemsId)argObjectId).getPrimaryItemId());
/* 234 */     setSubstituteItemId(((SubstituteItemsId)argObjectId).getSubstituteItemId());
/* 235 */     setLevelCode(((SubstituteItemsId)argObjectId).getLevelCode());
/* 236 */     setLevelValue(((SubstituteItemsId)argObjectId).getLevelValue());
/*     */   }
/*     */   
/*     */   public String getImplementingClass() {
/* 240 */     return null;
/*     */   }
/*     */   
/*     */   public String toXmlString() {
/* 244 */     StringBuilder buf = new StringBuilder(650);
/* 245 */     buf.append("<").append("dao").append(" name=\"SubstituteItems\" cmd=\"" + getObjectStateString() + "\">");
/* 246 */     getFieldsAsXml(buf);
/* 247 */     buf.append("</").append("dao").append(">");
/*     */     
/* 249 */     return buf.toString();
/*     */   }
/*     */   
/*     */   public Map<String, String> getValues() {
/* 253 */     Map<String, String> values = super.getValues();
/* 254 */     if (this._organizationId != null) values.put("OrganizationId", DaoUtils.getXmlSafeFieldValue(-5, this._organizationId)); 
/* 255 */     if (this._primaryItemId != null) values.put("PrimaryItemId", DaoUtils.getXmlSafeFieldValue(12, this._primaryItemId)); 
/* 256 */     if (this._substituteItemId != null) values.put("SubstituteItemId", DaoUtils.getXmlSafeFieldValue(12, this._substituteItemId)); 
/* 257 */     if (this._levelCode != null) values.put("LevelCode", DaoUtils.getXmlSafeFieldValue(12, this._levelCode)); 
/* 258 */     if (this._levelValue != null) values.put("LevelValue", DaoUtils.getXmlSafeFieldValue(12, this._levelValue)); 
/* 259 */     if (this._createDate != null) values.put("CreateDate", DaoUtils.getXmlSafeFieldValue(91, this._createDate)); 
/* 260 */     if (this._createUserId != null) values.put("CreateUserId", DaoUtils.getXmlSafeFieldValue(12, this._createUserId)); 
/* 261 */     if (this._updateDate != null) values.put("UpdateDate", DaoUtils.getXmlSafeFieldValue(91, this._updateDate)); 
/* 262 */     if (this._updateUserId != null) values.put("UpdateUserId", DaoUtils.getXmlSafeFieldValue(12, this._updateUserId)); 
/* 263 */     if (this._beginDatetime != null) values.put("BeginDatetime", DaoUtils.getXmlSafeFieldValue(91, this._beginDatetime)); 
/* 264 */     if (this._endDatetime != null) values.put("EndDatetime", DaoUtils.getXmlSafeFieldValue(91, this._endDatetime)); 
/* 265 */     if (this._externalId != null) values.put("ExternalId", DaoUtils.getXmlSafeFieldValue(12, this._externalId)); 
/* 266 */     if (this._externalSystem != null) values.put("ExternalSystem", DaoUtils.getXmlSafeFieldValue(12, this._externalSystem)); 
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
/*     */         case "PrimaryItemId":
/*     */           try {
/* 290 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 291 */             setPrimaryItemId((String)value);
/* 292 */           } catch (Exception ee) {
/* 293 */             throw new DtxException("An exception occurred while calling setPrimaryItemId() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "SubstituteItemId":
/*     */           try {
/* 299 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 300 */             setSubstituteItemId((String)value);
/* 301 */           } catch (Exception ee) {
/* 302 */             throw new DtxException("An exception occurred while calling setSubstituteItemId() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "LevelCode":
/*     */           try {
/* 308 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 309 */             setLevelCode((String)value);
/* 310 */           } catch (Exception ee) {
/* 311 */             throw new DtxException("An exception occurred while calling setLevelCode() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "LevelValue":
/*     */           try {
/* 317 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 318 */             setLevelValue((String)value);
/* 319 */           } catch (Exception ee) {
/* 320 */             throw new DtxException("An exception occurred while calling setLevelValue() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
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
/*     */         case "BeginDatetime":
/*     */           try {
/* 362 */             Object value = DaoUtils.getFieldValueForXmlString(91, fieldValue);
/* 363 */             setBeginDatetime((Date)value);
/* 364 */           } catch (Exception ee) {
/* 365 */             throw new DtxException("An exception occurred while calling setBeginDatetime() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "EndDatetime":
/*     */           try {
/* 371 */             Object value = DaoUtils.getFieldValueForXmlString(91, fieldValue);
/* 372 */             setEndDatetime((Date)value);
/* 373 */           } catch (Exception ee) {
/* 374 */             throw new DtxException("An exception occurred while calling setEndDatetime() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "ExternalId":
/*     */           try {
/* 380 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 381 */             setExternalId((String)value);
/* 382 */           } catch (Exception ee) {
/* 383 */             throw new DtxException("An exception occurred while calling setExternalId() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "ExternalSystem":
/*     */           try {
/* 389 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 390 */             setExternalSystem((String)value);
/* 391 */           } catch (Exception ee) {
/* 392 */             throw new DtxException("An exception occurred while calling setExternalSystem() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */       } 
/*     */     } 
/*     */   }
/*     */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\itm\impl\SubstituteItemsDAO.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */