/*     */ package dtv.xst.dao.trn.impl;
/*     */ 
/*     */ import dtv.data2.access.DaoUtils;
/*     */ import dtv.data2.access.IObjectId;
/*     */ import dtv.data2.access.exception.DtxException;
/*     */ import dtv.data2.access.impl.AbstractDAOImpl;
/*     */ import dtv.util.DtvDate;
/*     */ import dtv.xst.dao.trn.TransactionVersionId;
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
/*     */ public class TransactionVersionDAO
/*     */   extends AbstractDAOImpl
/*     */ {
/*     */   private static final long serialVersionUID = 1583695930L;
/*  23 */   private static final Logger _logger = Logger.getLogger(TransactionVersionDAO.class);
/*     */   
/*     */   private Long _organizationId;
/*     */   private Long _retailLocationId;
/*     */   private DtvDate _businessDate;
/*     */   private Long _workstationId;
/*     */   private Long _transactionSequence;
/*     */   private DtvDate _createDate;
/*     */   private String _createUserId;
/*     */   private DtvDate _updateDate;
/*     */   private String _updateUserId;
/*     */   private String _baseAppVersion;
/*     */   private DtvDate _baseAppDate;
/*     */   private String _baseSchemaVersion;
/*     */   private DtvDate _baseSchemaDate;
/*     */   private String _customerAppVersion;
/*     */   private String _customerSchemaVersion;
/*     */   private DtvDate _customerSchemaDate;
/*     */   
/*     */   public Long getOrganizationId() {
/*  43 */     return this._organizationId;
/*     */   }
/*     */   
/*     */   public void setOrganizationId(Long argOrganizationId) {
/*  47 */     if (changed(argOrganizationId, this._organizationId, "organizationId")) {
/*  48 */       this._organizationId = argOrganizationId;
/*     */     }
/*     */   }
/*     */   
/*     */   public Long getRetailLocationId() {
/*  53 */     return this._retailLocationId;
/*     */   }
/*     */   
/*     */   public void setRetailLocationId(Long argRetailLocationId) {
/*  57 */     if (changed(argRetailLocationId, this._retailLocationId, "retailLocationId")) {
/*  58 */       this._retailLocationId = argRetailLocationId;
/*     */     }
/*     */   }
/*     */   
/*     */   public Date getBusinessDate() {
/*  63 */     return (Date)this._businessDate;
/*     */   }
/*     */   
/*     */   public void setBusinessDate(Date argBusinessDate) {
/*  67 */     if (changed(argBusinessDate, this._businessDate, "businessDate")) {
/*  68 */       this._businessDate = (argBusinessDate == null || argBusinessDate instanceof DtvDate) ? (DtvDate)argBusinessDate : new DtvDate(argBusinessDate);
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public Long getWorkstationId() {
/*  74 */     return this._workstationId;
/*     */   }
/*     */   
/*     */   public void setWorkstationId(Long argWorkstationId) {
/*  78 */     if (changed(argWorkstationId, this._workstationId, "workstationId")) {
/*  79 */       this._workstationId = argWorkstationId;
/*     */     }
/*     */   }
/*     */   
/*     */   public Long getTransactionSequence() {
/*  84 */     return this._transactionSequence;
/*     */   }
/*     */   
/*     */   public void setTransactionSequence(Long argTransactionSequence) {
/*  88 */     if (changed(argTransactionSequence, this._transactionSequence, "transactionSequence")) {
/*  89 */       this._transactionSequence = argTransactionSequence;
/*     */     }
/*     */   }
/*     */   
/*     */   public Date getCreateDate() {
/*  94 */     return (Date)this._createDate;
/*     */   }
/*     */   
/*     */   public void setCreateDate(Date argCreateDate) {
/*  98 */     if (changed(argCreateDate, this._createDate, "createDate")) {
/*  99 */       this._createDate = (argCreateDate == null || argCreateDate instanceof DtvDate) ? (DtvDate)argCreateDate : new DtvDate(argCreateDate);
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public String getCreateUserId() {
/* 105 */     return this._createUserId;
/*     */   }
/*     */   
/*     */   public void setCreateUserId(String argCreateUserId) {
/* 109 */     if (changed(argCreateUserId, this._createUserId, "createUserId")) {
/* 110 */       this._createUserId = argCreateUserId;
/*     */     }
/*     */   }
/*     */   
/*     */   public Date getUpdateDate() {
/* 115 */     return (Date)this._updateDate;
/*     */   }
/*     */   
/*     */   public void setUpdateDate(Date argUpdateDate) {
/* 119 */     if (changed(argUpdateDate, this._updateDate, "updateDate")) {
/* 120 */       this._updateDate = (argUpdateDate == null || argUpdateDate instanceof DtvDate) ? (DtvDate)argUpdateDate : new DtvDate(argUpdateDate);
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public String getUpdateUserId() {
/* 126 */     return this._updateUserId;
/*     */   }
/*     */   
/*     */   public void setUpdateUserId(String argUpdateUserId) {
/* 130 */     if (changed(argUpdateUserId, this._updateUserId, "updateUserId")) {
/* 131 */       this._updateUserId = argUpdateUserId;
/*     */     }
/*     */   }
/*     */   
/*     */   public String getBaseAppVersion() {
/* 136 */     return this._baseAppVersion;
/*     */   }
/*     */   
/*     */   public void setBaseAppVersion(String argBaseAppVersion) {
/* 140 */     if (changed(argBaseAppVersion, this._baseAppVersion, "baseAppVersion")) {
/* 141 */       this._baseAppVersion = argBaseAppVersion;
/*     */     }
/*     */   }
/*     */   
/*     */   public Date getBaseAppDate() {
/* 146 */     return (Date)this._baseAppDate;
/*     */   }
/*     */   
/*     */   public void setBaseAppDate(Date argBaseAppDate) {
/* 150 */     if (changed(argBaseAppDate, this._baseAppDate, "baseAppDate")) {
/* 151 */       this._baseAppDate = (argBaseAppDate == null || argBaseAppDate instanceof DtvDate) ? (DtvDate)argBaseAppDate : new DtvDate(argBaseAppDate);
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public String getBaseSchemaVersion() {
/* 157 */     return this._baseSchemaVersion;
/*     */   }
/*     */   
/*     */   public void setBaseSchemaVersion(String argBaseSchemaVersion) {
/* 161 */     if (changed(argBaseSchemaVersion, this._baseSchemaVersion, "baseSchemaVersion")) {
/* 162 */       this._baseSchemaVersion = argBaseSchemaVersion;
/*     */     }
/*     */   }
/*     */   
/*     */   public Date getBaseSchemaDate() {
/* 167 */     return (Date)this._baseSchemaDate;
/*     */   }
/*     */   
/*     */   public void setBaseSchemaDate(Date argBaseSchemaDate) {
/* 171 */     if (changed(argBaseSchemaDate, this._baseSchemaDate, "baseSchemaDate")) {
/* 172 */       this._baseSchemaDate = (argBaseSchemaDate == null || argBaseSchemaDate instanceof DtvDate) ? (DtvDate)argBaseSchemaDate : new DtvDate(argBaseSchemaDate);
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public String getCustomerAppVersion() {
/* 178 */     return this._customerAppVersion;
/*     */   }
/*     */   
/*     */   public void setCustomerAppVersion(String argCustomerAppVersion) {
/* 182 */     if (changed(argCustomerAppVersion, this._customerAppVersion, "customerAppVersion")) {
/* 183 */       this._customerAppVersion = argCustomerAppVersion;
/*     */     }
/*     */   }
/*     */   
/*     */   public String getCustomerSchemaVersion() {
/* 188 */     return this._customerSchemaVersion;
/*     */   }
/*     */   
/*     */   public void setCustomerSchemaVersion(String argCustomerSchemaVersion) {
/* 192 */     if (changed(argCustomerSchemaVersion, this._customerSchemaVersion, "customerSchemaVersion")) {
/* 193 */       this._customerSchemaVersion = argCustomerSchemaVersion;
/*     */     }
/*     */   }
/*     */   
/*     */   public Date getCustomerSchemaDate() {
/* 198 */     return (Date)this._customerSchemaDate;
/*     */   }
/*     */   
/*     */   public void setCustomerSchemaDate(Date argCustomerSchemaDate) {
/* 202 */     if (changed(argCustomerSchemaDate, this._customerSchemaDate, "customerSchemaDate")) {
/* 203 */       this._customerSchemaDate = (argCustomerSchemaDate == null || argCustomerSchemaDate instanceof DtvDate) ? (DtvDate)argCustomerSchemaDate : new DtvDate(argCustomerSchemaDate);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String toString() {
/* 211 */     StringBuilder buf = new StringBuilder(512);
/* 212 */     buf.append(super.toString()).append(" Id: ").append(getObjectId()).append(" Values: ");
/* 213 */     if (getOrganizationId() != null) {
/* 214 */       buf.append("organizationId").append("=").append(getOrganizationId()).append(" ");
/*     */     }
/* 216 */     if (getRetailLocationId() != null) {
/* 217 */       buf.append("retailLocationId").append("=").append(getRetailLocationId()).append(" ");
/*     */     }
/* 219 */     if (getBusinessDate() != null) {
/* 220 */       buf.append("businessDate").append("=").append(getBusinessDate()).append(" ");
/*     */     }
/* 222 */     if (getWorkstationId() != null) {
/* 223 */       buf.append("workstationId").append("=").append(getWorkstationId()).append(" ");
/*     */     }
/* 225 */     if (getTransactionSequence() != null) {
/* 226 */       buf.append("transactionSequence").append("=").append(getTransactionSequence()).append(" ");
/*     */     }
/* 228 */     if (getCreateDate() != null) {
/* 229 */       buf.append("createDate").append("=").append(getCreateDate()).append(" ");
/*     */     }
/* 231 */     if (getCreateUserId() != null) {
/* 232 */       buf.append("createUserId").append("=").append(getCreateUserId()).append(" ");
/*     */     }
/* 234 */     if (getUpdateDate() != null) {
/* 235 */       buf.append("updateDate").append("=").append(getUpdateDate()).append(" ");
/*     */     }
/* 237 */     if (getUpdateUserId() != null) {
/* 238 */       buf.append("updateUserId").append("=").append(getUpdateUserId()).append(" ");
/*     */     }
/* 240 */     if (getBaseAppVersion() != null) {
/* 241 */       buf.append("baseAppVersion").append("=").append(getBaseAppVersion()).append(" ");
/*     */     }
/* 243 */     if (getBaseAppDate() != null) {
/* 244 */       buf.append("baseAppDate").append("=").append(getBaseAppDate()).append(" ");
/*     */     }
/* 246 */     if (getBaseSchemaVersion() != null) {
/* 247 */       buf.append("baseSchemaVersion").append("=").append(getBaseSchemaVersion()).append(" ");
/*     */     }
/* 249 */     if (getBaseSchemaDate() != null) {
/* 250 */       buf.append("baseSchemaDate").append("=").append(getBaseSchemaDate()).append(" ");
/*     */     }
/* 252 */     if (getCustomerAppVersion() != null) {
/* 253 */       buf.append("customerAppVersion").append("=").append(getCustomerAppVersion()).append(" ");
/*     */     }
/* 255 */     if (getCustomerSchemaVersion() != null) {
/* 256 */       buf.append("customerSchemaVersion").append("=").append(getCustomerSchemaVersion()).append(" ");
/*     */     }
/* 258 */     if (getCustomerSchemaDate() != null) {
/* 259 */       buf.append("customerSchemaDate").append("=").append(getCustomerSchemaDate()).append(" ");
/*     */     }
/*     */     
/* 262 */     return buf.toString();
/*     */   }
/*     */   
/*     */   public IObjectId getObjectId() {
/* 266 */     TransactionVersionId id = new TransactionVersionId();
/* 267 */     id.setOrganizationId(getOrganizationId());
/* 268 */     id.setRetailLocationId(getRetailLocationId());
/* 269 */     id.setBusinessDate(getBusinessDate());
/* 270 */     id.setWorkstationId(getWorkstationId());
/* 271 */     id.setTransactionSequence(getTransactionSequence());
/* 272 */     return (IObjectId)id;
/*     */   }
/*     */   
/*     */   public void setObjectId(IObjectId argObjectId) {
/* 276 */     setOrganizationId(((TransactionVersionId)argObjectId).getOrganizationId());
/* 277 */     setRetailLocationId(((TransactionVersionId)argObjectId).getRetailLocationId());
/* 278 */     setBusinessDate(((TransactionVersionId)argObjectId).getBusinessDate());
/* 279 */     setWorkstationId(((TransactionVersionId)argObjectId).getWorkstationId());
/* 280 */     setTransactionSequence(((TransactionVersionId)argObjectId).getTransactionSequence());
/*     */   }
/*     */   
/*     */   public String getImplementingClass() {
/* 284 */     return null;
/*     */   }
/*     */   
/*     */   public String toXmlString() {
/* 288 */     StringBuilder buf = new StringBuilder(800);
/* 289 */     buf.append("<").append("dao").append(" name=\"TransactionVersion\" cmd=\"" + getObjectStateString() + "\">");
/* 290 */     getFieldsAsXml(buf);
/* 291 */     buf.append("</").append("dao").append(">");
/*     */     
/* 293 */     return buf.toString();
/*     */   }
/*     */   
/*     */   public Map<String, String> getValues() {
/* 297 */     Map<String, String> values = super.getValues();
/* 298 */     if (this._organizationId != null) values.put("OrganizationId", DaoUtils.getXmlSafeFieldValue(-5, this._organizationId)); 
/* 299 */     if (this._retailLocationId != null) values.put("RetailLocationId", DaoUtils.getXmlSafeFieldValue(-5, this._retailLocationId)); 
/* 300 */     if (this._businessDate != null) values.put("BusinessDate", DaoUtils.getXmlSafeFieldValue(91, this._businessDate)); 
/* 301 */     if (this._workstationId != null) values.put("WorkstationId", DaoUtils.getXmlSafeFieldValue(-5, this._workstationId)); 
/* 302 */     if (this._transactionSequence != null) values.put("TransactionSequence", DaoUtils.getXmlSafeFieldValue(-5, this._transactionSequence)); 
/* 303 */     if (this._createDate != null) values.put("CreateDate", DaoUtils.getXmlSafeFieldValue(91, this._createDate)); 
/* 304 */     if (this._createUserId != null) values.put("CreateUserId", DaoUtils.getXmlSafeFieldValue(12, this._createUserId)); 
/* 305 */     if (this._updateDate != null) values.put("UpdateDate", DaoUtils.getXmlSafeFieldValue(91, this._updateDate)); 
/* 306 */     if (this._updateUserId != null) values.put("UpdateUserId", DaoUtils.getXmlSafeFieldValue(12, this._updateUserId)); 
/* 307 */     if (this._baseAppVersion != null) values.put("BaseAppVersion", DaoUtils.getXmlSafeFieldValue(12, this._baseAppVersion)); 
/* 308 */     if (this._baseAppDate != null) values.put("BaseAppDate", DaoUtils.getXmlSafeFieldValue(91, this._baseAppDate)); 
/* 309 */     if (this._baseSchemaVersion != null) values.put("BaseSchemaVersion", DaoUtils.getXmlSafeFieldValue(12, this._baseSchemaVersion)); 
/* 310 */     if (this._baseSchemaDate != null) values.put("BaseSchemaDate", DaoUtils.getXmlSafeFieldValue(91, this._baseSchemaDate)); 
/* 311 */     if (this._customerAppVersion != null) values.put("CustomerAppVersion", DaoUtils.getXmlSafeFieldValue(12, this._customerAppVersion)); 
/* 312 */     if (this._customerSchemaVersion != null) values.put("CustomerSchemaVersion", DaoUtils.getXmlSafeFieldValue(12, this._customerSchemaVersion)); 
/* 313 */     if (this._customerSchemaDate != null) values.put("CustomerSchemaDate", DaoUtils.getXmlSafeFieldValue(91, this._customerSchemaDate)); 
/* 314 */     return values;
/*     */   }
/*     */ 
/*     */   
/*     */   public void setValues(Map<String, String> argValues) {
/* 319 */     super.setValues(argValues);
/* 320 */     for (Map.Entry<String, String> field : argValues.entrySet()) {
/*     */       
/* 322 */       String fieldName = field.getKey();
/* 323 */       String fieldValue = field.getValue();
/* 324 */       switch (fieldName) {
/*     */         
/*     */         case "OrganizationId":
/*     */           try {
/* 328 */             Object value = DaoUtils.getFieldValueForXmlString(-5, fieldValue);
/* 329 */             setOrganizationId((Long)value);
/* 330 */           } catch (Exception ee) {
/* 331 */             throw new DtxException("An exception occurred while calling setOrganizationId() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "RetailLocationId":
/*     */           try {
/* 337 */             Object value = DaoUtils.getFieldValueForXmlString(-5, fieldValue);
/* 338 */             setRetailLocationId((Long)value);
/* 339 */           } catch (Exception ee) {
/* 340 */             throw new DtxException("An exception occurred while calling setRetailLocationId() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "BusinessDate":
/*     */           try {
/* 346 */             Object value = DaoUtils.getFieldValueForXmlString(91, fieldValue);
/* 347 */             setBusinessDate((Date)value);
/* 348 */           } catch (Exception ee) {
/* 349 */             throw new DtxException("An exception occurred while calling setBusinessDate() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "WorkstationId":
/*     */           try {
/* 355 */             Object value = DaoUtils.getFieldValueForXmlString(-5, fieldValue);
/* 356 */             setWorkstationId((Long)value);
/* 357 */           } catch (Exception ee) {
/* 358 */             throw new DtxException("An exception occurred while calling setWorkstationId() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "TransactionSequence":
/*     */           try {
/* 364 */             Object value = DaoUtils.getFieldValueForXmlString(-5, fieldValue);
/* 365 */             setTransactionSequence((Long)value);
/* 366 */           } catch (Exception ee) {
/* 367 */             throw new DtxException("An exception occurred while calling setTransactionSequence() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "CreateDate":
/*     */           try {
/* 373 */             Object value = DaoUtils.getFieldValueForXmlString(91, fieldValue);
/* 374 */             setCreateDate((Date)value);
/* 375 */           } catch (Exception ee) {
/* 376 */             throw new DtxException("An exception occurred while calling setCreateDate() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "CreateUserId":
/*     */           try {
/* 382 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 383 */             setCreateUserId((String)value);
/* 384 */           } catch (Exception ee) {
/* 385 */             throw new DtxException("An exception occurred while calling setCreateUserId() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "UpdateDate":
/*     */           try {
/* 391 */             Object value = DaoUtils.getFieldValueForXmlString(91, fieldValue);
/* 392 */             setUpdateDate((Date)value);
/* 393 */           } catch (Exception ee) {
/* 394 */             throw new DtxException("An exception occurred while calling setUpdateDate() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "UpdateUserId":
/*     */           try {
/* 400 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 401 */             setUpdateUserId((String)value);
/* 402 */           } catch (Exception ee) {
/* 403 */             throw new DtxException("An exception occurred while calling setUpdateUserId() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "BaseAppVersion":
/*     */           try {
/* 409 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 410 */             setBaseAppVersion((String)value);
/* 411 */           } catch (Exception ee) {
/* 412 */             throw new DtxException("An exception occurred while calling setBaseAppVersion() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "BaseAppDate":
/*     */           try {
/* 418 */             Object value = DaoUtils.getFieldValueForXmlString(91, fieldValue);
/* 419 */             setBaseAppDate((Date)value);
/* 420 */           } catch (Exception ee) {
/* 421 */             throw new DtxException("An exception occurred while calling setBaseAppDate() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "BaseSchemaVersion":
/*     */           try {
/* 427 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 428 */             setBaseSchemaVersion((String)value);
/* 429 */           } catch (Exception ee) {
/* 430 */             throw new DtxException("An exception occurred while calling setBaseSchemaVersion() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "BaseSchemaDate":
/*     */           try {
/* 436 */             Object value = DaoUtils.getFieldValueForXmlString(91, fieldValue);
/* 437 */             setBaseSchemaDate((Date)value);
/* 438 */           } catch (Exception ee) {
/* 439 */             throw new DtxException("An exception occurred while calling setBaseSchemaDate() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "CustomerAppVersion":
/*     */           try {
/* 445 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 446 */             setCustomerAppVersion((String)value);
/* 447 */           } catch (Exception ee) {
/* 448 */             throw new DtxException("An exception occurred while calling setCustomerAppVersion() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "CustomerSchemaVersion":
/*     */           try {
/* 454 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 455 */             setCustomerSchemaVersion((String)value);
/* 456 */           } catch (Exception ee) {
/* 457 */             throw new DtxException("An exception occurred while calling setCustomerSchemaVersion() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "CustomerSchemaDate":
/*     */           try {
/* 463 */             Object value = DaoUtils.getFieldValueForXmlString(91, fieldValue);
/* 464 */             setCustomerSchemaDate((Date)value);
/* 465 */           } catch (Exception ee) {
/* 466 */             throw new DtxException("An exception occurred while calling setCustomerSchemaDate() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */       } 
/*     */     } 
/*     */   }
/*     */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\trn\impl\TransactionVersionDAO.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */