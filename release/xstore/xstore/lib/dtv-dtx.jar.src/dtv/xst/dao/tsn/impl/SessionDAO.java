/*     */ package dtv.xst.dao.tsn.impl;
/*     */ 
/*     */ import dtv.data2.access.DaoUtils;
/*     */ import dtv.data2.access.IObjectId;
/*     */ import dtv.data2.access.exception.DtxException;
/*     */ import dtv.data2.access.impl.AbstractDAOImpl;
/*     */ import dtv.util.DtvDate;
/*     */ import dtv.xst.dao.tsn.SessionId;
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
/*     */ public class SessionDAO
/*     */   extends AbstractDAOImpl
/*     */ {
/*     */   private static final long serialVersionUID = -645326218L;
/*  23 */   private static final Logger _logger = Logger.getLogger(SessionDAO.class);
/*     */   
/*     */   private Long _organizationId;
/*     */   private Long _retailLocationId;
/*     */   private Long _sessionId;
/*     */   private DtvDate _createDate;
/*     */   private String _createUserId;
/*     */   private DtvDate _updateDate;
/*     */   private String _updateUserId;
/*     */   private DtvDate _beginDatetimestamp;
/*     */   private DtvDate _businessDate;
/*     */   private DtvDate _endDatetimestamp;
/*     */   private String _statusCode;
/*     */   private Long _employeePartyId;
/*     */   private String _tenderRepositoryId;
/*     */   private String _cashDrawerId;
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
/*     */   public Long getSessionId() {
/*  61 */     return this._sessionId;
/*     */   }
/*     */   
/*     */   public void setSessionId(Long argSessionId) {
/*  65 */     if (changed(argSessionId, this._sessionId, "sessionId")) {
/*  66 */       this._sessionId = argSessionId;
/*     */     }
/*     */   }
/*     */   
/*     */   public Date getCreateDate() {
/*  71 */     return (Date)this._createDate;
/*     */   }
/*     */   
/*     */   public void setCreateDate(Date argCreateDate) {
/*  75 */     if (changed(argCreateDate, this._createDate, "createDate")) {
/*  76 */       this._createDate = (argCreateDate == null || argCreateDate instanceof DtvDate) ? (DtvDate)argCreateDate : new DtvDate(argCreateDate);
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public String getCreateUserId() {
/*  82 */     return this._createUserId;
/*     */   }
/*     */   
/*     */   public void setCreateUserId(String argCreateUserId) {
/*  86 */     if (changed(argCreateUserId, this._createUserId, "createUserId")) {
/*  87 */       this._createUserId = argCreateUserId;
/*     */     }
/*     */   }
/*     */   
/*     */   public Date getUpdateDate() {
/*  92 */     return (Date)this._updateDate;
/*     */   }
/*     */   
/*     */   public void setUpdateDate(Date argUpdateDate) {
/*  96 */     if (changed(argUpdateDate, this._updateDate, "updateDate")) {
/*  97 */       this._updateDate = (argUpdateDate == null || argUpdateDate instanceof DtvDate) ? (DtvDate)argUpdateDate : new DtvDate(argUpdateDate);
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public String getUpdateUserId() {
/* 103 */     return this._updateUserId;
/*     */   }
/*     */   
/*     */   public void setUpdateUserId(String argUpdateUserId) {
/* 107 */     if (changed(argUpdateUserId, this._updateUserId, "updateUserId")) {
/* 108 */       this._updateUserId = argUpdateUserId;
/*     */     }
/*     */   }
/*     */   
/*     */   public Date getBeginDatetimestamp() {
/* 113 */     return (Date)this._beginDatetimestamp;
/*     */   }
/*     */   
/*     */   public void setBeginDatetimestamp(Date argBeginDatetimestamp) {
/* 117 */     if (changed(argBeginDatetimestamp, this._beginDatetimestamp, "beginDatetimestamp")) {
/* 118 */       this._beginDatetimestamp = (argBeginDatetimestamp == null || argBeginDatetimestamp instanceof DtvDate) ? (DtvDate)argBeginDatetimestamp : new DtvDate(argBeginDatetimestamp);
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public Date getBusinessDate() {
/* 124 */     return (Date)this._businessDate;
/*     */   }
/*     */   
/*     */   public void setBusinessDate(Date argBusinessDate) {
/* 128 */     if (changed(argBusinessDate, this._businessDate, "businessDate")) {
/* 129 */       this._businessDate = (argBusinessDate == null || argBusinessDate instanceof DtvDate) ? (DtvDate)argBusinessDate : new DtvDate(argBusinessDate);
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public Date getEndDatetimestamp() {
/* 135 */     return (Date)this._endDatetimestamp;
/*     */   }
/*     */   
/*     */   public void setEndDatetimestamp(Date argEndDatetimestamp) {
/* 139 */     if (changed(argEndDatetimestamp, this._endDatetimestamp, "endDatetimestamp")) {
/* 140 */       this._endDatetimestamp = (argEndDatetimestamp == null || argEndDatetimestamp instanceof DtvDate) ? (DtvDate)argEndDatetimestamp : new DtvDate(argEndDatetimestamp);
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public String getStatusCode() {
/* 146 */     return this._statusCode;
/*     */   }
/*     */   
/*     */   public void setStatusCode(String argStatusCode) {
/* 150 */     if (changed(argStatusCode, this._statusCode, "statusCode")) {
/* 151 */       this._statusCode = argStatusCode;
/*     */     }
/*     */   }
/*     */   
/*     */   public Long getEmployeePartyId() {
/* 156 */     return this._employeePartyId;
/*     */   }
/*     */   
/*     */   public void setEmployeePartyId(Long argEmployeePartyId) {
/* 160 */     if (changed(argEmployeePartyId, this._employeePartyId, "employeePartyId")) {
/* 161 */       this._employeePartyId = argEmployeePartyId;
/*     */     }
/*     */   }
/*     */   
/*     */   public String getTenderRepositoryId() {
/* 166 */     return this._tenderRepositoryId;
/*     */   }
/*     */   
/*     */   public void setTenderRepositoryId(String argTenderRepositoryId) {
/* 170 */     if (changed(argTenderRepositoryId, this._tenderRepositoryId, "tenderRepositoryId")) {
/* 171 */       this._tenderRepositoryId = argTenderRepositoryId;
/*     */     }
/*     */   }
/*     */   
/*     */   public String getCashDrawerId() {
/* 176 */     return this._cashDrawerId;
/*     */   }
/*     */   
/*     */   public void setCashDrawerId(String argCashDrawerId) {
/* 180 */     if (changed(argCashDrawerId, this._cashDrawerId, "cashDrawerId")) {
/* 181 */       this._cashDrawerId = argCashDrawerId;
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public String toString() {
/* 188 */     StringBuilder buf = new StringBuilder(512);
/* 189 */     buf.append(super.toString()).append(" Id: ").append(getObjectId()).append(" Values: ");
/* 190 */     if (getOrganizationId() != null) {
/* 191 */       buf.append("organizationId").append("=").append(getOrganizationId()).append(" ");
/*     */     }
/* 193 */     if (getRetailLocationId() != null) {
/* 194 */       buf.append("retailLocationId").append("=").append(getRetailLocationId()).append(" ");
/*     */     }
/* 196 */     if (getSessionId() != null) {
/* 197 */       buf.append("sessionId").append("=").append(getSessionId()).append(" ");
/*     */     }
/* 199 */     if (getCreateDate() != null) {
/* 200 */       buf.append("createDate").append("=").append(getCreateDate()).append(" ");
/*     */     }
/* 202 */     if (getCreateUserId() != null) {
/* 203 */       buf.append("createUserId").append("=").append(getCreateUserId()).append(" ");
/*     */     }
/* 205 */     if (getUpdateDate() != null) {
/* 206 */       buf.append("updateDate").append("=").append(getUpdateDate()).append(" ");
/*     */     }
/* 208 */     if (getUpdateUserId() != null) {
/* 209 */       buf.append("updateUserId").append("=").append(getUpdateUserId()).append(" ");
/*     */     }
/* 211 */     if (getBeginDatetimestamp() != null) {
/* 212 */       buf.append("beginDatetimestamp").append("=").append(getBeginDatetimestamp()).append(" ");
/*     */     }
/* 214 */     if (getBusinessDate() != null) {
/* 215 */       buf.append("businessDate").append("=").append(getBusinessDate()).append(" ");
/*     */     }
/* 217 */     if (getEndDatetimestamp() != null) {
/* 218 */       buf.append("endDatetimestamp").append("=").append(getEndDatetimestamp()).append(" ");
/*     */     }
/* 220 */     if (getStatusCode() != null) {
/* 221 */       buf.append("statusCode").append("=").append(getStatusCode()).append(" ");
/*     */     }
/* 223 */     if (getEmployeePartyId() != null) {
/* 224 */       buf.append("employeePartyId").append("=").append(getEmployeePartyId()).append(" ");
/*     */     }
/* 226 */     if (getTenderRepositoryId() != null) {
/* 227 */       buf.append("tenderRepositoryId").append("=").append(getTenderRepositoryId()).append(" ");
/*     */     }
/* 229 */     if (getCashDrawerId() != null) {
/* 230 */       buf.append("cashDrawerId").append("=").append(getCashDrawerId()).append(" ");
/*     */     }
/*     */     
/* 233 */     return buf.toString();
/*     */   }
/*     */   
/*     */   public IObjectId getObjectId() {
/* 237 */     SessionId id = new SessionId();
/* 238 */     id.setOrganizationId(getOrganizationId());
/* 239 */     id.setRetailLocationId(getRetailLocationId());
/* 240 */     id.setSessionId(getSessionId());
/* 241 */     return (IObjectId)id;
/*     */   }
/*     */   
/*     */   public void setObjectId(IObjectId argObjectId) {
/* 245 */     setOrganizationId(((SessionId)argObjectId).getOrganizationId());
/* 246 */     setRetailLocationId(((SessionId)argObjectId).getRetailLocationId());
/* 247 */     setSessionId(((SessionId)argObjectId).getSessionId());
/*     */   }
/*     */   
/*     */   public String getImplementingClass() {
/* 251 */     return null;
/*     */   }
/*     */   
/*     */   public String toXmlString() {
/* 255 */     StringBuilder buf = new StringBuilder(700);
/* 256 */     buf.append("<").append("dao").append(" name=\"Session\" cmd=\"" + getObjectStateString() + "\">");
/* 257 */     getFieldsAsXml(buf);
/* 258 */     buf.append("</").append("dao").append(">");
/*     */     
/* 260 */     return buf.toString();
/*     */   }
/*     */   
/*     */   public Map<String, String> getValues() {
/* 264 */     Map<String, String> values = super.getValues();
/* 265 */     if (this._organizationId != null) values.put("OrganizationId", DaoUtils.getXmlSafeFieldValue(-5, this._organizationId)); 
/* 266 */     if (this._retailLocationId != null) values.put("RetailLocationId", DaoUtils.getXmlSafeFieldValue(-5, this._retailLocationId)); 
/* 267 */     if (this._sessionId != null) values.put("SessionId", DaoUtils.getXmlSafeFieldValue(-5, this._sessionId)); 
/* 268 */     if (this._createDate != null) values.put("CreateDate", DaoUtils.getXmlSafeFieldValue(91, this._createDate)); 
/* 269 */     if (this._createUserId != null) values.put("CreateUserId", DaoUtils.getXmlSafeFieldValue(12, this._createUserId)); 
/* 270 */     if (this._updateDate != null) values.put("UpdateDate", DaoUtils.getXmlSafeFieldValue(91, this._updateDate)); 
/* 271 */     if (this._updateUserId != null) values.put("UpdateUserId", DaoUtils.getXmlSafeFieldValue(12, this._updateUserId)); 
/* 272 */     if (this._beginDatetimestamp != null) values.put("BeginDatetimestamp", DaoUtils.getXmlSafeFieldValue(91, this._beginDatetimestamp)); 
/* 273 */     if (this._businessDate != null) values.put("BusinessDate", DaoUtils.getXmlSafeFieldValue(91, this._businessDate)); 
/* 274 */     if (this._endDatetimestamp != null) values.put("EndDatetimestamp", DaoUtils.getXmlSafeFieldValue(91, this._endDatetimestamp)); 
/* 275 */     if (this._statusCode != null) values.put("StatusCode", DaoUtils.getXmlSafeFieldValue(12, this._statusCode)); 
/* 276 */     if (this._employeePartyId != null) values.put("EmployeePartyId", DaoUtils.getXmlSafeFieldValue(-5, this._employeePartyId)); 
/* 277 */     if (this._tenderRepositoryId != null) values.put("TenderRepositoryId", DaoUtils.getXmlSafeFieldValue(12, this._tenderRepositoryId)); 
/* 278 */     if (this._cashDrawerId != null) values.put("CashDrawerId", DaoUtils.getXmlSafeFieldValue(12, this._cashDrawerId)); 
/* 279 */     return values;
/*     */   }
/*     */ 
/*     */   
/*     */   public void setValues(Map<String, String> argValues) {
/* 284 */     super.setValues(argValues);
/* 285 */     for (Map.Entry<String, String> field : argValues.entrySet()) {
/*     */       
/* 287 */       String fieldName = field.getKey();
/* 288 */       String fieldValue = field.getValue();
/* 289 */       switch (fieldName) {
/*     */         
/*     */         case "OrganizationId":
/*     */           try {
/* 293 */             Object value = DaoUtils.getFieldValueForXmlString(-5, fieldValue);
/* 294 */             setOrganizationId((Long)value);
/* 295 */           } catch (Exception ee) {
/* 296 */             throw new DtxException("An exception occurred while calling setOrganizationId() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "RetailLocationId":
/*     */           try {
/* 302 */             Object value = DaoUtils.getFieldValueForXmlString(-5, fieldValue);
/* 303 */             setRetailLocationId((Long)value);
/* 304 */           } catch (Exception ee) {
/* 305 */             throw new DtxException("An exception occurred while calling setRetailLocationId() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "SessionId":
/*     */           try {
/* 311 */             Object value = DaoUtils.getFieldValueForXmlString(-5, fieldValue);
/* 312 */             setSessionId((Long)value);
/* 313 */           } catch (Exception ee) {
/* 314 */             throw new DtxException("An exception occurred while calling setSessionId() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "CreateDate":
/*     */           try {
/* 320 */             Object value = DaoUtils.getFieldValueForXmlString(91, fieldValue);
/* 321 */             setCreateDate((Date)value);
/* 322 */           } catch (Exception ee) {
/* 323 */             throw new DtxException("An exception occurred while calling setCreateDate() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "CreateUserId":
/*     */           try {
/* 329 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 330 */             setCreateUserId((String)value);
/* 331 */           } catch (Exception ee) {
/* 332 */             throw new DtxException("An exception occurred while calling setCreateUserId() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "UpdateDate":
/*     */           try {
/* 338 */             Object value = DaoUtils.getFieldValueForXmlString(91, fieldValue);
/* 339 */             setUpdateDate((Date)value);
/* 340 */           } catch (Exception ee) {
/* 341 */             throw new DtxException("An exception occurred while calling setUpdateDate() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "UpdateUserId":
/*     */           try {
/* 347 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 348 */             setUpdateUserId((String)value);
/* 349 */           } catch (Exception ee) {
/* 350 */             throw new DtxException("An exception occurred while calling setUpdateUserId() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "BeginDatetimestamp":
/*     */           try {
/* 356 */             Object value = DaoUtils.getFieldValueForXmlString(91, fieldValue);
/* 357 */             setBeginDatetimestamp((Date)value);
/* 358 */           } catch (Exception ee) {
/* 359 */             throw new DtxException("An exception occurred while calling setBeginDatetimestamp() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "BusinessDate":
/*     */           try {
/* 365 */             Object value = DaoUtils.getFieldValueForXmlString(91, fieldValue);
/* 366 */             setBusinessDate((Date)value);
/* 367 */           } catch (Exception ee) {
/* 368 */             throw new DtxException("An exception occurred while calling setBusinessDate() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "EndDatetimestamp":
/*     */           try {
/* 374 */             Object value = DaoUtils.getFieldValueForXmlString(91, fieldValue);
/* 375 */             setEndDatetimestamp((Date)value);
/* 376 */           } catch (Exception ee) {
/* 377 */             throw new DtxException("An exception occurred while calling setEndDatetimestamp() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "StatusCode":
/*     */           try {
/* 383 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 384 */             setStatusCode((String)value);
/* 385 */           } catch (Exception ee) {
/* 386 */             throw new DtxException("An exception occurred while calling setStatusCode() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "EmployeePartyId":
/*     */           try {
/* 392 */             Object value = DaoUtils.getFieldValueForXmlString(-5, fieldValue);
/* 393 */             setEmployeePartyId((Long)value);
/* 394 */           } catch (Exception ee) {
/* 395 */             throw new DtxException("An exception occurred while calling setEmployeePartyId() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "TenderRepositoryId":
/*     */           try {
/* 401 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 402 */             setTenderRepositoryId((String)value);
/* 403 */           } catch (Exception ee) {
/* 404 */             throw new DtxException("An exception occurred while calling setTenderRepositoryId() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "CashDrawerId":
/*     */           try {
/* 410 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 411 */             setCashDrawerId((String)value);
/* 412 */           } catch (Exception ee) {
/* 413 */             throw new DtxException("An exception occurred while calling setCashDrawerId() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */       } 
/*     */     } 
/*     */   }
/*     */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\tsn\impl\SessionDAO.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */