/*     */ package dtv.xst.dao.trl.impl;
/*     */ 
/*     */ import dtv.data2.access.DaoUtils;
/*     */ import dtv.data2.access.IObjectId;
/*     */ import dtv.data2.access.exception.DtxException;
/*     */ import dtv.data2.access.impl.AbstractDAOImpl;
/*     */ import dtv.util.DtvDate;
/*     */ import dtv.xst.dao.trl.ReturnedItemJournalId;
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
/*     */ public class ReturnedItemJournalDAO
/*     */   extends AbstractDAOImpl
/*     */ {
/*     */   private static final long serialVersionUID = 769133365L;
/*  23 */   private static final Logger _logger = Logger.getLogger(ReturnedItemJournalDAO.class);
/*     */   
/*     */   private Long _organizationId;
/*     */   private Long _retailLocationId;
/*     */   private Long _workstationId;
/*     */   private DtvDate _businessDate;
/*     */   private Integer _retailTransactionLineItemSequence;
/*     */   private Long _transactionSequence;
/*     */   private Long _journalSequence;
/*     */   private DtvDate _createDate;
/*     */   private String _createUserId;
/*     */   private DtvDate _updateDate;
/*     */   private String _updateUserId;
/*     */   private BigDecimal _returnedCount;
/*     */   private Long _returnedRetailLocationId;
/*     */   private Long _returnedWorkstationId;
/*     */   private DtvDate _returnedBusinessDate;
/*     */   private Integer _returnedRetailTransactionLineItemSequence;
/*     */   private Long _returnedTransactionSequence;
/*     */   
/*     */   public Long getOrganizationId() {
/*  44 */     return this._organizationId;
/*     */   }
/*     */   
/*     */   public void setOrganizationId(Long argOrganizationId) {
/*  48 */     if (changed(argOrganizationId, this._organizationId, "organizationId")) {
/*  49 */       this._organizationId = argOrganizationId;
/*     */     }
/*     */   }
/*     */   
/*     */   public Long getRetailLocationId() {
/*  54 */     return this._retailLocationId;
/*     */   }
/*     */   
/*     */   public void setRetailLocationId(Long argRetailLocationId) {
/*  58 */     if (changed(argRetailLocationId, this._retailLocationId, "retailLocationId")) {
/*  59 */       this._retailLocationId = argRetailLocationId;
/*     */     }
/*     */   }
/*     */   
/*     */   public Long getWorkstationId() {
/*  64 */     return this._workstationId;
/*     */   }
/*     */   
/*     */   public void setWorkstationId(Long argWorkstationId) {
/*  68 */     if (changed(argWorkstationId, this._workstationId, "workstationId")) {
/*  69 */       this._workstationId = argWorkstationId;
/*     */     }
/*     */   }
/*     */   
/*     */   public Date getBusinessDate() {
/*  74 */     return (Date)this._businessDate;
/*     */   }
/*     */   
/*     */   public void setBusinessDate(Date argBusinessDate) {
/*  78 */     if (changed(argBusinessDate, this._businessDate, "businessDate")) {
/*  79 */       this._businessDate = (argBusinessDate == null || argBusinessDate instanceof DtvDate) ? (DtvDate)argBusinessDate : new DtvDate(argBusinessDate);
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public Integer getRetailTransactionLineItemSequence() {
/*  85 */     return this._retailTransactionLineItemSequence;
/*     */   }
/*     */   
/*     */   public void setRetailTransactionLineItemSequence(Integer argRetailTransactionLineItemSequence) {
/*  89 */     if (changed(argRetailTransactionLineItemSequence, this._retailTransactionLineItemSequence, "retailTransactionLineItemSequence")) {
/*  90 */       this._retailTransactionLineItemSequence = argRetailTransactionLineItemSequence;
/*     */     }
/*     */   }
/*     */   
/*     */   public Long getTransactionSequence() {
/*  95 */     return this._transactionSequence;
/*     */   }
/*     */   
/*     */   public void setTransactionSequence(Long argTransactionSequence) {
/*  99 */     if (changed(argTransactionSequence, this._transactionSequence, "transactionSequence")) {
/* 100 */       this._transactionSequence = argTransactionSequence;
/*     */     }
/*     */   }
/*     */   
/*     */   public Long getJournalSequence() {
/* 105 */     return this._journalSequence;
/*     */   }
/*     */   
/*     */   public void setJournalSequence(Long argJournalSequence) {
/* 109 */     if (changed(argJournalSequence, this._journalSequence, "journalSequence")) {
/* 110 */       this._journalSequence = argJournalSequence;
/*     */     }
/*     */   }
/*     */   
/*     */   public Date getCreateDate() {
/* 115 */     return (Date)this._createDate;
/*     */   }
/*     */   
/*     */   public void setCreateDate(Date argCreateDate) {
/* 119 */     if (changed(argCreateDate, this._createDate, "createDate")) {
/* 120 */       this._createDate = (argCreateDate == null || argCreateDate instanceof DtvDate) ? (DtvDate)argCreateDate : new DtvDate(argCreateDate);
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public String getCreateUserId() {
/* 126 */     return this._createUserId;
/*     */   }
/*     */   
/*     */   public void setCreateUserId(String argCreateUserId) {
/* 130 */     if (changed(argCreateUserId, this._createUserId, "createUserId")) {
/* 131 */       this._createUserId = argCreateUserId;
/*     */     }
/*     */   }
/*     */   
/*     */   public Date getUpdateDate() {
/* 136 */     return (Date)this._updateDate;
/*     */   }
/*     */   
/*     */   public void setUpdateDate(Date argUpdateDate) {
/* 140 */     if (changed(argUpdateDate, this._updateDate, "updateDate")) {
/* 141 */       this._updateDate = (argUpdateDate == null || argUpdateDate instanceof DtvDate) ? (DtvDate)argUpdateDate : new DtvDate(argUpdateDate);
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public String getUpdateUserId() {
/* 147 */     return this._updateUserId;
/*     */   }
/*     */   
/*     */   public void setUpdateUserId(String argUpdateUserId) {
/* 151 */     if (changed(argUpdateUserId, this._updateUserId, "updateUserId")) {
/* 152 */       this._updateUserId = argUpdateUserId;
/*     */     }
/*     */   }
/*     */   
/*     */   public BigDecimal getReturnedCount() {
/* 157 */     return this._returnedCount;
/*     */   }
/*     */   
/*     */   public void setReturnedCount(BigDecimal argReturnedCount) {
/* 161 */     if (changed(argReturnedCount, this._returnedCount, "returnedCount")) {
/* 162 */       this._returnedCount = argReturnedCount;
/*     */     }
/*     */   }
/*     */   
/*     */   public Long getReturnedRetailLocationId() {
/* 167 */     return this._returnedRetailLocationId;
/*     */   }
/*     */   
/*     */   public void setReturnedRetailLocationId(Long argReturnedRetailLocationId) {
/* 171 */     if (changed(argReturnedRetailLocationId, this._returnedRetailLocationId, "returnedRetailLocationId")) {
/* 172 */       this._returnedRetailLocationId = argReturnedRetailLocationId;
/*     */     }
/*     */   }
/*     */   
/*     */   public Long getReturnedWorkstationId() {
/* 177 */     return this._returnedWorkstationId;
/*     */   }
/*     */   
/*     */   public void setReturnedWorkstationId(Long argReturnedWorkstationId) {
/* 181 */     if (changed(argReturnedWorkstationId, this._returnedWorkstationId, "returnedWorkstationId")) {
/* 182 */       this._returnedWorkstationId = argReturnedWorkstationId;
/*     */     }
/*     */   }
/*     */   
/*     */   public Date getReturnedBusinessDate() {
/* 187 */     return (Date)this._returnedBusinessDate;
/*     */   }
/*     */   
/*     */   public void setReturnedBusinessDate(Date argReturnedBusinessDate) {
/* 191 */     if (changed(argReturnedBusinessDate, this._returnedBusinessDate, "returnedBusinessDate")) {
/* 192 */       this._returnedBusinessDate = (argReturnedBusinessDate == null || argReturnedBusinessDate instanceof DtvDate) ? (DtvDate)argReturnedBusinessDate : new DtvDate(argReturnedBusinessDate);
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public Integer getReturnedRetailTransactionLineItemSequence() {
/* 198 */     return this._returnedRetailTransactionLineItemSequence;
/*     */   }
/*     */   
/*     */   public void setReturnedRetailTransactionLineItemSequence(Integer argReturnedRetailTransactionLineItemSequence) {
/* 202 */     if (changed(argReturnedRetailTransactionLineItemSequence, this._returnedRetailTransactionLineItemSequence, "returnedRetailTransactionLineItemSequence")) {
/* 203 */       this._returnedRetailTransactionLineItemSequence = argReturnedRetailTransactionLineItemSequence;
/*     */     }
/*     */   }
/*     */   
/*     */   public Long getReturnedTransactionSequence() {
/* 208 */     return this._returnedTransactionSequence;
/*     */   }
/*     */   
/*     */   public void setReturnedTransactionSequence(Long argReturnedTransactionSequence) {
/* 212 */     if (changed(argReturnedTransactionSequence, this._returnedTransactionSequence, "returnedTransactionSequence")) {
/* 213 */       this._returnedTransactionSequence = argReturnedTransactionSequence;
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public String toString() {
/* 220 */     StringBuilder buf = new StringBuilder(512);
/* 221 */     buf.append(super.toString()).append(" Id: ").append(getObjectId()).append(" Values: ");
/* 222 */     if (getOrganizationId() != null) {
/* 223 */       buf.append("organizationId").append("=").append(getOrganizationId()).append(" ");
/*     */     }
/* 225 */     if (getRetailLocationId() != null) {
/* 226 */       buf.append("retailLocationId").append("=").append(getRetailLocationId()).append(" ");
/*     */     }
/* 228 */     if (getWorkstationId() != null) {
/* 229 */       buf.append("workstationId").append("=").append(getWorkstationId()).append(" ");
/*     */     }
/* 231 */     if (getBusinessDate() != null) {
/* 232 */       buf.append("businessDate").append("=").append(getBusinessDate()).append(" ");
/*     */     }
/* 234 */     if (getRetailTransactionLineItemSequence() != null) {
/* 235 */       buf.append("retailTransactionLineItemSequence").append("=").append(getRetailTransactionLineItemSequence()).append(" ");
/*     */     }
/* 237 */     if (getTransactionSequence() != null) {
/* 238 */       buf.append("transactionSequence").append("=").append(getTransactionSequence()).append(" ");
/*     */     }
/* 240 */     if (getJournalSequence() != null) {
/* 241 */       buf.append("journalSequence").append("=").append(getJournalSequence()).append(" ");
/*     */     }
/* 243 */     if (getCreateDate() != null) {
/* 244 */       buf.append("createDate").append("=").append(getCreateDate()).append(" ");
/*     */     }
/* 246 */     if (getCreateUserId() != null) {
/* 247 */       buf.append("createUserId").append("=").append(getCreateUserId()).append(" ");
/*     */     }
/* 249 */     if (getUpdateDate() != null) {
/* 250 */       buf.append("updateDate").append("=").append(getUpdateDate()).append(" ");
/*     */     }
/* 252 */     if (getUpdateUserId() != null) {
/* 253 */       buf.append("updateUserId").append("=").append(getUpdateUserId()).append(" ");
/*     */     }
/* 255 */     if (getReturnedCount() != null) {
/* 256 */       buf.append("returnedCount").append("=").append(getReturnedCount()).append(" ");
/*     */     }
/* 258 */     if (getReturnedRetailLocationId() != null) {
/* 259 */       buf.append("returnedRetailLocationId").append("=").append(getReturnedRetailLocationId()).append(" ");
/*     */     }
/* 261 */     if (getReturnedWorkstationId() != null) {
/* 262 */       buf.append("returnedWorkstationId").append("=").append(getReturnedWorkstationId()).append(" ");
/*     */     }
/* 264 */     if (getReturnedBusinessDate() != null) {
/* 265 */       buf.append("returnedBusinessDate").append("=").append(getReturnedBusinessDate()).append(" ");
/*     */     }
/* 267 */     if (getReturnedRetailTransactionLineItemSequence() != null) {
/* 268 */       buf.append("returnedRetailTransactionLineItemSequence").append("=").append(getReturnedRetailTransactionLineItemSequence()).append(" ");
/*     */     }
/* 270 */     if (getReturnedTransactionSequence() != null) {
/* 271 */       buf.append("returnedTransactionSequence").append("=").append(getReturnedTransactionSequence()).append(" ");
/*     */     }
/*     */     
/* 274 */     return buf.toString();
/*     */   }
/*     */   
/*     */   public IObjectId getObjectId() {
/* 278 */     ReturnedItemJournalId id = new ReturnedItemJournalId();
/* 279 */     id.setOrganizationId(getOrganizationId());
/* 280 */     id.setRetailLocationId(getRetailLocationId());
/* 281 */     id.setWorkstationId(getWorkstationId());
/* 282 */     id.setBusinessDate(getBusinessDate());
/* 283 */     id.setRetailTransactionLineItemSequence(getRetailTransactionLineItemSequence());
/* 284 */     id.setTransactionSequence(getTransactionSequence());
/* 285 */     id.setJournalSequence(getJournalSequence());
/* 286 */     return (IObjectId)id;
/*     */   }
/*     */   
/*     */   public void setObjectId(IObjectId argObjectId) {
/* 290 */     setOrganizationId(((ReturnedItemJournalId)argObjectId).getOrganizationId());
/* 291 */     setRetailLocationId(((ReturnedItemJournalId)argObjectId).getRetailLocationId());
/* 292 */     setWorkstationId(((ReturnedItemJournalId)argObjectId).getWorkstationId());
/* 293 */     setBusinessDate(((ReturnedItemJournalId)argObjectId).getBusinessDate());
/* 294 */     setRetailTransactionLineItemSequence(((ReturnedItemJournalId)argObjectId).getRetailTransactionLineItemSequence());
/* 295 */     setTransactionSequence(((ReturnedItemJournalId)argObjectId).getTransactionSequence());
/* 296 */     setJournalSequence(((ReturnedItemJournalId)argObjectId).getJournalSequence());
/*     */   }
/*     */   
/*     */   public String getImplementingClass() {
/* 300 */     return null;
/*     */   }
/*     */   
/*     */   public String toXmlString() {
/* 304 */     StringBuilder buf = new StringBuilder(850);
/* 305 */     buf.append("<").append("dao").append(" name=\"ReturnedItemJournal\" cmd=\"" + getObjectStateString() + "\">");
/* 306 */     getFieldsAsXml(buf);
/* 307 */     buf.append("</").append("dao").append(">");
/*     */     
/* 309 */     return buf.toString();
/*     */   }
/*     */   
/*     */   public Map<String, String> getValues() {
/* 313 */     Map<String, String> values = super.getValues();
/* 314 */     if (this._organizationId != null) values.put("OrganizationId", DaoUtils.getXmlSafeFieldValue(-5, this._organizationId)); 
/* 315 */     if (this._retailLocationId != null) values.put("RetailLocationId", DaoUtils.getXmlSafeFieldValue(-5, this._retailLocationId)); 
/* 316 */     if (this._workstationId != null) values.put("WorkstationId", DaoUtils.getXmlSafeFieldValue(-5, this._workstationId)); 
/* 317 */     if (this._businessDate != null) values.put("BusinessDate", DaoUtils.getXmlSafeFieldValue(91, this._businessDate)); 
/* 318 */     if (this._retailTransactionLineItemSequence != null) values.put("RetailTransactionLineItemSequence", DaoUtils.getXmlSafeFieldValue(4, this._retailTransactionLineItemSequence)); 
/* 319 */     if (this._transactionSequence != null) values.put("TransactionSequence", DaoUtils.getXmlSafeFieldValue(-5, this._transactionSequence)); 
/* 320 */     if (this._journalSequence != null) values.put("JournalSequence", DaoUtils.getXmlSafeFieldValue(-5, this._journalSequence)); 
/* 321 */     if (this._createDate != null) values.put("CreateDate", DaoUtils.getXmlSafeFieldValue(91, this._createDate)); 
/* 322 */     if (this._createUserId != null) values.put("CreateUserId", DaoUtils.getXmlSafeFieldValue(12, this._createUserId)); 
/* 323 */     if (this._updateDate != null) values.put("UpdateDate", DaoUtils.getXmlSafeFieldValue(91, this._updateDate)); 
/* 324 */     if (this._updateUserId != null) values.put("UpdateUserId", DaoUtils.getXmlSafeFieldValue(12, this._updateUserId)); 
/* 325 */     if (this._returnedCount != null) values.put("ReturnedCount", DaoUtils.getXmlSafeFieldValue(3, this._returnedCount)); 
/* 326 */     if (this._returnedRetailLocationId != null) values.put("ReturnedRetailLocationId", DaoUtils.getXmlSafeFieldValue(-5, this._returnedRetailLocationId)); 
/* 327 */     if (this._returnedWorkstationId != null) values.put("ReturnedWorkstationId", DaoUtils.getXmlSafeFieldValue(-5, this._returnedWorkstationId)); 
/* 328 */     if (this._returnedBusinessDate != null) values.put("ReturnedBusinessDate", DaoUtils.getXmlSafeFieldValue(91, this._returnedBusinessDate)); 
/* 329 */     if (this._returnedRetailTransactionLineItemSequence != null) values.put("ReturnedRetailTransactionLineItemSequence", DaoUtils.getXmlSafeFieldValue(4, this._returnedRetailTransactionLineItemSequence)); 
/* 330 */     if (this._returnedTransactionSequence != null) values.put("ReturnedTransactionSequence", DaoUtils.getXmlSafeFieldValue(-5, this._returnedTransactionSequence)); 
/* 331 */     return values;
/*     */   }
/*     */ 
/*     */   
/*     */   public void setValues(Map<String, String> argValues) {
/* 336 */     super.setValues(argValues);
/* 337 */     for (Map.Entry<String, String> field : argValues.entrySet()) {
/*     */       
/* 339 */       String fieldName = field.getKey();
/* 340 */       String fieldValue = field.getValue();
/* 341 */       switch (fieldName) {
/*     */         
/*     */         case "OrganizationId":
/*     */           try {
/* 345 */             Object value = DaoUtils.getFieldValueForXmlString(-5, fieldValue);
/* 346 */             setOrganizationId((Long)value);
/* 347 */           } catch (Exception ee) {
/* 348 */             throw new DtxException("An exception occurred while calling setOrganizationId() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "RetailLocationId":
/*     */           try {
/* 354 */             Object value = DaoUtils.getFieldValueForXmlString(-5, fieldValue);
/* 355 */             setRetailLocationId((Long)value);
/* 356 */           } catch (Exception ee) {
/* 357 */             throw new DtxException("An exception occurred while calling setRetailLocationId() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "WorkstationId":
/*     */           try {
/* 363 */             Object value = DaoUtils.getFieldValueForXmlString(-5, fieldValue);
/* 364 */             setWorkstationId((Long)value);
/* 365 */           } catch (Exception ee) {
/* 366 */             throw new DtxException("An exception occurred while calling setWorkstationId() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "BusinessDate":
/*     */           try {
/* 372 */             Object value = DaoUtils.getFieldValueForXmlString(91, fieldValue);
/* 373 */             setBusinessDate((Date)value);
/* 374 */           } catch (Exception ee) {
/* 375 */             throw new DtxException("An exception occurred while calling setBusinessDate() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "RetailTransactionLineItemSequence":
/*     */           try {
/* 381 */             Object value = DaoUtils.getFieldValueForXmlString(4, fieldValue);
/* 382 */             setRetailTransactionLineItemSequence((Integer)value);
/* 383 */           } catch (Exception ee) {
/* 384 */             throw new DtxException("An exception occurred while calling setRetailTransactionLineItemSequence() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "TransactionSequence":
/*     */           try {
/* 390 */             Object value = DaoUtils.getFieldValueForXmlString(-5, fieldValue);
/* 391 */             setTransactionSequence((Long)value);
/* 392 */           } catch (Exception ee) {
/* 393 */             throw new DtxException("An exception occurred while calling setTransactionSequence() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "JournalSequence":
/*     */           try {
/* 399 */             Object value = DaoUtils.getFieldValueForXmlString(-5, fieldValue);
/* 400 */             setJournalSequence((Long)value);
/* 401 */           } catch (Exception ee) {
/* 402 */             throw new DtxException("An exception occurred while calling setJournalSequence() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "CreateDate":
/*     */           try {
/* 408 */             Object value = DaoUtils.getFieldValueForXmlString(91, fieldValue);
/* 409 */             setCreateDate((Date)value);
/* 410 */           } catch (Exception ee) {
/* 411 */             throw new DtxException("An exception occurred while calling setCreateDate() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "CreateUserId":
/*     */           try {
/* 417 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 418 */             setCreateUserId((String)value);
/* 419 */           } catch (Exception ee) {
/* 420 */             throw new DtxException("An exception occurred while calling setCreateUserId() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "UpdateDate":
/*     */           try {
/* 426 */             Object value = DaoUtils.getFieldValueForXmlString(91, fieldValue);
/* 427 */             setUpdateDate((Date)value);
/* 428 */           } catch (Exception ee) {
/* 429 */             throw new DtxException("An exception occurred while calling setUpdateDate() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "UpdateUserId":
/*     */           try {
/* 435 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 436 */             setUpdateUserId((String)value);
/* 437 */           } catch (Exception ee) {
/* 438 */             throw new DtxException("An exception occurred while calling setUpdateUserId() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "ReturnedCount":
/*     */           try {
/* 444 */             Object value = DaoUtils.getFieldValueForXmlString(3, fieldValue);
/* 445 */             setReturnedCount((BigDecimal)value);
/* 446 */           } catch (Exception ee) {
/* 447 */             throw new DtxException("An exception occurred while calling setReturnedCount() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "ReturnedRetailLocationId":
/*     */           try {
/* 453 */             Object value = DaoUtils.getFieldValueForXmlString(-5, fieldValue);
/* 454 */             setReturnedRetailLocationId((Long)value);
/* 455 */           } catch (Exception ee) {
/* 456 */             throw new DtxException("An exception occurred while calling setReturnedRetailLocationId() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "ReturnedWorkstationId":
/*     */           try {
/* 462 */             Object value = DaoUtils.getFieldValueForXmlString(-5, fieldValue);
/* 463 */             setReturnedWorkstationId((Long)value);
/* 464 */           } catch (Exception ee) {
/* 465 */             throw new DtxException("An exception occurred while calling setReturnedWorkstationId() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "ReturnedBusinessDate":
/*     */           try {
/* 471 */             Object value = DaoUtils.getFieldValueForXmlString(91, fieldValue);
/* 472 */             setReturnedBusinessDate((Date)value);
/* 473 */           } catch (Exception ee) {
/* 474 */             throw new DtxException("An exception occurred while calling setReturnedBusinessDate() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "ReturnedRetailTransactionLineItemSequence":
/*     */           try {
/* 480 */             Object value = DaoUtils.getFieldValueForXmlString(4, fieldValue);
/* 481 */             setReturnedRetailTransactionLineItemSequence((Integer)value);
/* 482 */           } catch (Exception ee) {
/* 483 */             throw new DtxException("An exception occurred while calling setReturnedRetailTransactionLineItemSequence() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "ReturnedTransactionSequence":
/*     */           try {
/* 489 */             Object value = DaoUtils.getFieldValueForXmlString(-5, fieldValue);
/* 490 */             setReturnedTransactionSequence((Long)value);
/* 491 */           } catch (Exception ee) {
/* 492 */             throw new DtxException("An exception occurred while calling setReturnedTransactionSequence() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */       } 
/*     */     } 
/*     */   }
/*     */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\trl\impl\ReturnedItemJournalDAO.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */