/*     */ package dtv.xst.dao._test.impl;
/*     */ 
/*     */ import dtv.data2.access.DaoUtils;
/*     */ import dtv.data2.access.IObjectId;
/*     */ import dtv.data2.access.exception.DtxException;
/*     */ import dtv.data2.access.impl.AbstractDAOImpl;
/*     */ import dtv.util.DtvDate;
/*     */ import dtv.xst.dao._test.XunitResultItemId;
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
/*     */ public class XunitResultItemDAO
/*     */   extends AbstractDAOImpl
/*     */ {
/*     */   private static final long serialVersionUID = -1907652660L;
/*  23 */   private static final Logger _logger = Logger.getLogger(XunitResultItemDAO.class);
/*     */   
/*     */   private Long _organizationId;
/*     */   private String _hostname;
/*     */   private Long _resultTimestamp;
/*     */   private Long _resultItemSequence;
/*     */   private DtvDate _createDate;
/*     */   private String _createUserId;
/*     */   private DtvDate _updateDate;
/*     */   private String _updateUserId;
/*     */   private String _testCaseName;
/*     */   private Long _testNumber;
/*     */   private Long _testIteration;
/*     */   private String _resultItemStatus;
/*     */   private DtvDate _resultItemDatetimestamp;
/*     */   private String _failureReason;
/*     */   private String _logData;
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
/*     */   public String getHostname() {
/*  52 */     return this._hostname;
/*     */   }
/*     */   
/*     */   public void setHostname(String argHostname) {
/*  56 */     if (changed(argHostname, this._hostname, "hostname")) {
/*  57 */       this._hostname = (argHostname != null && MANAGE_CASE) ? argHostname.toUpperCase() : argHostname;
/*     */     }
/*     */   }
/*     */   
/*     */   public Long getResultTimestamp() {
/*  62 */     return this._resultTimestamp;
/*     */   }
/*     */   
/*     */   public void setResultTimestamp(Long argResultTimestamp) {
/*  66 */     if (changed(argResultTimestamp, this._resultTimestamp, "resultTimestamp")) {
/*  67 */       this._resultTimestamp = argResultTimestamp;
/*     */     }
/*     */   }
/*     */   
/*     */   public Long getResultItemSequence() {
/*  72 */     return this._resultItemSequence;
/*     */   }
/*     */   
/*     */   public void setResultItemSequence(Long argResultItemSequence) {
/*  76 */     if (changed(argResultItemSequence, this._resultItemSequence, "resultItemSequence")) {
/*  77 */       this._resultItemSequence = argResultItemSequence;
/*     */     }
/*     */   }
/*     */   
/*     */   public Date getCreateDate() {
/*  82 */     return (Date)this._createDate;
/*     */   }
/*     */   
/*     */   public void setCreateDate(Date argCreateDate) {
/*  86 */     if (changed(argCreateDate, this._createDate, "createDate")) {
/*  87 */       this._createDate = (argCreateDate == null || argCreateDate instanceof DtvDate) ? (DtvDate)argCreateDate : new DtvDate(argCreateDate);
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public String getCreateUserId() {
/*  93 */     return this._createUserId;
/*     */   }
/*     */   
/*     */   public void setCreateUserId(String argCreateUserId) {
/*  97 */     if (changed(argCreateUserId, this._createUserId, "createUserId")) {
/*  98 */       this._createUserId = argCreateUserId;
/*     */     }
/*     */   }
/*     */   
/*     */   public Date getUpdateDate() {
/* 103 */     return (Date)this._updateDate;
/*     */   }
/*     */   
/*     */   public void setUpdateDate(Date argUpdateDate) {
/* 107 */     if (changed(argUpdateDate, this._updateDate, "updateDate")) {
/* 108 */       this._updateDate = (argUpdateDate == null || argUpdateDate instanceof DtvDate) ? (DtvDate)argUpdateDate : new DtvDate(argUpdateDate);
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public String getUpdateUserId() {
/* 114 */     return this._updateUserId;
/*     */   }
/*     */   
/*     */   public void setUpdateUserId(String argUpdateUserId) {
/* 118 */     if (changed(argUpdateUserId, this._updateUserId, "updateUserId")) {
/* 119 */       this._updateUserId = argUpdateUserId;
/*     */     }
/*     */   }
/*     */   
/*     */   public String getTestCaseName() {
/* 124 */     return this._testCaseName;
/*     */   }
/*     */   
/*     */   public void setTestCaseName(String argTestCaseName) {
/* 128 */     if (changed(argTestCaseName, this._testCaseName, "testCaseName")) {
/* 129 */       this._testCaseName = argTestCaseName;
/*     */     }
/*     */   }
/*     */   
/*     */   public Long getTestNumber() {
/* 134 */     return this._testNumber;
/*     */   }
/*     */   
/*     */   public void setTestNumber(Long argTestNumber) {
/* 138 */     if (changed(argTestNumber, this._testNumber, "testNumber")) {
/* 139 */       this._testNumber = argTestNumber;
/*     */     }
/*     */   }
/*     */   
/*     */   public Long getTestIteration() {
/* 144 */     return this._testIteration;
/*     */   }
/*     */   
/*     */   public void setTestIteration(Long argTestIteration) {
/* 148 */     if (changed(argTestIteration, this._testIteration, "testIteration")) {
/* 149 */       this._testIteration = argTestIteration;
/*     */     }
/*     */   }
/*     */   
/*     */   public String getResultItemStatus() {
/* 154 */     return this._resultItemStatus;
/*     */   }
/*     */   
/*     */   public void setResultItemStatus(String argResultItemStatus) {
/* 158 */     if (changed(argResultItemStatus, this._resultItemStatus, "resultItemStatus")) {
/* 159 */       this._resultItemStatus = argResultItemStatus;
/*     */     }
/*     */   }
/*     */   
/*     */   public Date getResultItemDatetimestamp() {
/* 164 */     return (Date)this._resultItemDatetimestamp;
/*     */   }
/*     */   
/*     */   public void setResultItemDatetimestamp(Date argResultItemDatetimestamp) {
/* 168 */     if (changed(argResultItemDatetimestamp, this._resultItemDatetimestamp, "resultItemDatetimestamp")) {
/* 169 */       this._resultItemDatetimestamp = (argResultItemDatetimestamp == null || argResultItemDatetimestamp instanceof DtvDate) ? (DtvDate)argResultItemDatetimestamp : new DtvDate(argResultItemDatetimestamp);
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public String getFailureReason() {
/* 175 */     return this._failureReason;
/*     */   }
/*     */   
/*     */   public void setFailureReason(String argFailureReason) {
/* 179 */     if (changed(argFailureReason, this._failureReason, "failureReason")) {
/* 180 */       this._failureReason = argFailureReason;
/*     */     }
/*     */   }
/*     */   
/*     */   public String getLogData() {
/* 185 */     return this._logData;
/*     */   }
/*     */   
/*     */   public void setLogData(String argLogData) {
/* 189 */     if (changed(argLogData, this._logData, "logData")) {
/* 190 */       this._logData = argLogData;
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public String toString() {
/* 197 */     StringBuilder buf = new StringBuilder(512);
/* 198 */     buf.append(super.toString()).append(" Id: ").append(getObjectId()).append(" Values: ");
/* 199 */     if (getOrganizationId() != null) {
/* 200 */       buf.append("organizationId").append("=").append(getOrganizationId()).append(" ");
/*     */     }
/* 202 */     if (getHostname() != null) {
/* 203 */       buf.append("hostname").append("=").append(getHostname()).append(" ");
/*     */     }
/* 205 */     if (getResultTimestamp() != null) {
/* 206 */       buf.append("resultTimestamp").append("=").append(getResultTimestamp()).append(" ");
/*     */     }
/* 208 */     if (getResultItemSequence() != null) {
/* 209 */       buf.append("resultItemSequence").append("=").append(getResultItemSequence()).append(" ");
/*     */     }
/* 211 */     if (getCreateDate() != null) {
/* 212 */       buf.append("createDate").append("=").append(getCreateDate()).append(" ");
/*     */     }
/* 214 */     if (getCreateUserId() != null) {
/* 215 */       buf.append("createUserId").append("=").append(getCreateUserId()).append(" ");
/*     */     }
/* 217 */     if (getUpdateDate() != null) {
/* 218 */       buf.append("updateDate").append("=").append(getUpdateDate()).append(" ");
/*     */     }
/* 220 */     if (getUpdateUserId() != null) {
/* 221 */       buf.append("updateUserId").append("=").append(getUpdateUserId()).append(" ");
/*     */     }
/* 223 */     if (getTestCaseName() != null) {
/* 224 */       buf.append("testCaseName").append("=").append(getTestCaseName()).append(" ");
/*     */     }
/* 226 */     if (getTestNumber() != null) {
/* 227 */       buf.append("testNumber").append("=").append(getTestNumber()).append(" ");
/*     */     }
/* 229 */     if (getTestIteration() != null) {
/* 230 */       buf.append("testIteration").append("=").append(getTestIteration()).append(" ");
/*     */     }
/* 232 */     if (getResultItemStatus() != null) {
/* 233 */       buf.append("resultItemStatus").append("=").append(getResultItemStatus()).append(" ");
/*     */     }
/* 235 */     if (getResultItemDatetimestamp() != null) {
/* 236 */       buf.append("resultItemDatetimestamp").append("=").append(getResultItemDatetimestamp()).append(" ");
/*     */     }
/* 238 */     if (getFailureReason() != null) {
/* 239 */       buf.append("failureReason").append("=").append(getFailureReason()).append(" ");
/*     */     }
/* 241 */     if (getLogData() != null) {
/* 242 */       buf.append("logData").append("=").append(getLogData()).append(" ");
/*     */     }
/*     */     
/* 245 */     return buf.toString();
/*     */   }
/*     */   
/*     */   public IObjectId getObjectId() {
/* 249 */     XunitResultItemId id = new XunitResultItemId();
/* 250 */     id.setOrganizationId(getOrganizationId());
/* 251 */     id.setHostname(getHostname());
/* 252 */     id.setResultTimestamp(getResultTimestamp());
/* 253 */     id.setResultItemSequence(getResultItemSequence());
/* 254 */     return (IObjectId)id;
/*     */   }
/*     */   
/*     */   public void setObjectId(IObjectId argObjectId) {
/* 258 */     setOrganizationId(((XunitResultItemId)argObjectId).getOrganizationId());
/* 259 */     setHostname(((XunitResultItemId)argObjectId).getHostname());
/* 260 */     setResultTimestamp(((XunitResultItemId)argObjectId).getResultTimestamp());
/* 261 */     setResultItemSequence(((XunitResultItemId)argObjectId).getResultItemSequence());
/*     */   }
/*     */   
/*     */   public String getImplementingClass() {
/* 265 */     return null;
/*     */   }
/*     */   
/*     */   public String toXmlString() {
/* 269 */     StringBuilder buf = new StringBuilder(750);
/* 270 */     buf.append("<").append("dao").append(" name=\"XunitResultItem\" cmd=\"" + getObjectStateString() + "\">");
/* 271 */     getFieldsAsXml(buf);
/* 272 */     buf.append("</").append("dao").append(">");
/*     */     
/* 274 */     return buf.toString();
/*     */   }
/*     */   
/*     */   public Map<String, String> getValues() {
/* 278 */     Map<String, String> values = super.getValues();
/* 279 */     if (this._organizationId != null) values.put("OrganizationId", DaoUtils.getXmlSafeFieldValue(-5, this._organizationId)); 
/* 280 */     if (this._hostname != null) values.put("Hostname", DaoUtils.getXmlSafeFieldValue(12, this._hostname)); 
/* 281 */     if (this._resultTimestamp != null) values.put("ResultTimestamp", DaoUtils.getXmlSafeFieldValue(-5, this._resultTimestamp)); 
/* 282 */     if (this._resultItemSequence != null) values.put("ResultItemSequence", DaoUtils.getXmlSafeFieldValue(-5, this._resultItemSequence)); 
/* 283 */     if (this._createDate != null) values.put("CreateDate", DaoUtils.getXmlSafeFieldValue(91, this._createDate)); 
/* 284 */     if (this._createUserId != null) values.put("CreateUserId", DaoUtils.getXmlSafeFieldValue(12, this._createUserId)); 
/* 285 */     if (this._updateDate != null) values.put("UpdateDate", DaoUtils.getXmlSafeFieldValue(91, this._updateDate)); 
/* 286 */     if (this._updateUserId != null) values.put("UpdateUserId", DaoUtils.getXmlSafeFieldValue(12, this._updateUserId)); 
/* 287 */     if (this._testCaseName != null) values.put("TestCaseName", DaoUtils.getXmlSafeFieldValue(12, this._testCaseName)); 
/* 288 */     if (this._testNumber != null) values.put("TestNumber", DaoUtils.getXmlSafeFieldValue(-5, this._testNumber)); 
/* 289 */     if (this._testIteration != null) values.put("TestIteration", DaoUtils.getXmlSafeFieldValue(-5, this._testIteration)); 
/* 290 */     if (this._resultItemStatus != null) values.put("ResultItemStatus", DaoUtils.getXmlSafeFieldValue(12, this._resultItemStatus)); 
/* 291 */     if (this._resultItemDatetimestamp != null) values.put("ResultItemDatetimestamp", DaoUtils.getXmlSafeFieldValue(91, this._resultItemDatetimestamp)); 
/* 292 */     if (this._failureReason != null) values.put("FailureReason", DaoUtils.getXmlSafeFieldValue(12, this._failureReason)); 
/* 293 */     if (this._logData != null) values.put("LogData", DaoUtils.getXmlSafeFieldValue(12, this._logData)); 
/* 294 */     return values;
/*     */   }
/*     */ 
/*     */   
/*     */   public void setValues(Map<String, String> argValues) {
/* 299 */     super.setValues(argValues);
/* 300 */     for (Map.Entry<String, String> field : argValues.entrySet()) {
/*     */       
/* 302 */       String fieldName = field.getKey();
/* 303 */       String fieldValue = field.getValue();
/* 304 */       switch (fieldName) {
/*     */         
/*     */         case "OrganizationId":
/*     */           try {
/* 308 */             Object value = DaoUtils.getFieldValueForXmlString(-5, fieldValue);
/* 309 */             setOrganizationId((Long)value);
/* 310 */           } catch (Exception ee) {
/* 311 */             throw new DtxException("An exception occurred while calling setOrganizationId() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "Hostname":
/*     */           try {
/* 317 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 318 */             setHostname((String)value);
/* 319 */           } catch (Exception ee) {
/* 320 */             throw new DtxException("An exception occurred while calling setHostname() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "ResultTimestamp":
/*     */           try {
/* 326 */             Object value = DaoUtils.getFieldValueForXmlString(-5, fieldValue);
/* 327 */             setResultTimestamp((Long)value);
/* 328 */           } catch (Exception ee) {
/* 329 */             throw new DtxException("An exception occurred while calling setResultTimestamp() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "ResultItemSequence":
/*     */           try {
/* 335 */             Object value = DaoUtils.getFieldValueForXmlString(-5, fieldValue);
/* 336 */             setResultItemSequence((Long)value);
/* 337 */           } catch (Exception ee) {
/* 338 */             throw new DtxException("An exception occurred while calling setResultItemSequence() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "CreateDate":
/*     */           try {
/* 344 */             Object value = DaoUtils.getFieldValueForXmlString(91, fieldValue);
/* 345 */             setCreateDate((Date)value);
/* 346 */           } catch (Exception ee) {
/* 347 */             throw new DtxException("An exception occurred while calling setCreateDate() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "CreateUserId":
/*     */           try {
/* 353 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 354 */             setCreateUserId((String)value);
/* 355 */           } catch (Exception ee) {
/* 356 */             throw new DtxException("An exception occurred while calling setCreateUserId() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "UpdateDate":
/*     */           try {
/* 362 */             Object value = DaoUtils.getFieldValueForXmlString(91, fieldValue);
/* 363 */             setUpdateDate((Date)value);
/* 364 */           } catch (Exception ee) {
/* 365 */             throw new DtxException("An exception occurred while calling setUpdateDate() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "UpdateUserId":
/*     */           try {
/* 371 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 372 */             setUpdateUserId((String)value);
/* 373 */           } catch (Exception ee) {
/* 374 */             throw new DtxException("An exception occurred while calling setUpdateUserId() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "TestCaseName":
/*     */           try {
/* 380 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 381 */             setTestCaseName((String)value);
/* 382 */           } catch (Exception ee) {
/* 383 */             throw new DtxException("An exception occurred while calling setTestCaseName() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "TestNumber":
/*     */           try {
/* 389 */             Object value = DaoUtils.getFieldValueForXmlString(-5, fieldValue);
/* 390 */             setTestNumber((Long)value);
/* 391 */           } catch (Exception ee) {
/* 392 */             throw new DtxException("An exception occurred while calling setTestNumber() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "TestIteration":
/*     */           try {
/* 398 */             Object value = DaoUtils.getFieldValueForXmlString(-5, fieldValue);
/* 399 */             setTestIteration((Long)value);
/* 400 */           } catch (Exception ee) {
/* 401 */             throw new DtxException("An exception occurred while calling setTestIteration() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "ResultItemStatus":
/*     */           try {
/* 407 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 408 */             setResultItemStatus((String)value);
/* 409 */           } catch (Exception ee) {
/* 410 */             throw new DtxException("An exception occurred while calling setResultItemStatus() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "ResultItemDatetimestamp":
/*     */           try {
/* 416 */             Object value = DaoUtils.getFieldValueForXmlString(91, fieldValue);
/* 417 */             setResultItemDatetimestamp((Date)value);
/* 418 */           } catch (Exception ee) {
/* 419 */             throw new DtxException("An exception occurred while calling setResultItemDatetimestamp() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "FailureReason":
/*     */           try {
/* 425 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 426 */             setFailureReason((String)value);
/* 427 */           } catch (Exception ee) {
/* 428 */             throw new DtxException("An exception occurred while calling setFailureReason() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "LogData":
/*     */           try {
/* 434 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 435 */             setLogData((String)value);
/* 436 */           } catch (Exception ee) {
/* 437 */             throw new DtxException("An exception occurred while calling setLogData() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */       } 
/*     */     } 
/*     */   }
/*     */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\_test\impl\XunitResultItemDAO.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */