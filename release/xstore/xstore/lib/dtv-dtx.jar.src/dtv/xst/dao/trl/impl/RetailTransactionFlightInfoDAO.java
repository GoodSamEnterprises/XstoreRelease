/*     */ package dtv.xst.dao.trl.impl;
/*     */ 
/*     */ import dtv.data2.access.DaoUtils;
/*     */ import dtv.data2.access.IObjectId;
/*     */ import dtv.data2.access.exception.DtxException;
/*     */ import dtv.data2.access.impl.AbstractDAOImpl;
/*     */ import dtv.util.DtvDate;
/*     */ import dtv.xst.dao.trl.RetailTransactionFlightInfoId;
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
/*     */ public class RetailTransactionFlightInfoDAO
/*     */   extends AbstractDAOImpl
/*     */ {
/*     */   private static final long serialVersionUID = 978775385L;
/*  23 */   private static final Logger _logger = Logger.getLogger(RetailTransactionFlightInfoDAO.class);
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
/*     */   private String _flightNumber;
/*     */   private String _destinationAirport;
/*     */   private String _destinationCountry;
/*     */   private String _destinationZone;
/*     */   private String _destinationAirportName;
/*     */   private String _originAirport;
/*     */   private String _taxCalculationMode;
/*     */   private String _firstFlightNumber;
/*     */   private String _firstDestinationAirport;
/*     */   private String _firstOriginAirport;
/*     */   private String _firstFlightSeatNumber;
/*     */   private DtvDate _firstFlightScheduledDate;
/*     */   
/*     */   public Long getOrganizationId() {
/*  48 */     return this._organizationId;
/*     */   }
/*     */   
/*     */   public void setOrganizationId(Long argOrganizationId) {
/*  52 */     if (changed(argOrganizationId, this._organizationId, "organizationId")) {
/*  53 */       this._organizationId = argOrganizationId;
/*     */     }
/*     */   }
/*     */   
/*     */   public Long getRetailLocationId() {
/*  58 */     return this._retailLocationId;
/*     */   }
/*     */   
/*     */   public void setRetailLocationId(Long argRetailLocationId) {
/*  62 */     if (changed(argRetailLocationId, this._retailLocationId, "retailLocationId")) {
/*  63 */       this._retailLocationId = argRetailLocationId;
/*     */     }
/*     */   }
/*     */   
/*     */   public Date getBusinessDate() {
/*  68 */     return (Date)this._businessDate;
/*     */   }
/*     */   
/*     */   public void setBusinessDate(Date argBusinessDate) {
/*  72 */     if (changed(argBusinessDate, this._businessDate, "businessDate")) {
/*  73 */       this._businessDate = (argBusinessDate == null || argBusinessDate instanceof DtvDate) ? (DtvDate)argBusinessDate : new DtvDate(argBusinessDate);
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public Long getWorkstationId() {
/*  79 */     return this._workstationId;
/*     */   }
/*     */   
/*     */   public void setWorkstationId(Long argWorkstationId) {
/*  83 */     if (changed(argWorkstationId, this._workstationId, "workstationId")) {
/*  84 */       this._workstationId = argWorkstationId;
/*     */     }
/*     */   }
/*     */   
/*     */   public Long getTransactionSequence() {
/*  89 */     return this._transactionSequence;
/*     */   }
/*     */   
/*     */   public void setTransactionSequence(Long argTransactionSequence) {
/*  93 */     if (changed(argTransactionSequence, this._transactionSequence, "transactionSequence")) {
/*  94 */       this._transactionSequence = argTransactionSequence;
/*     */     }
/*     */   }
/*     */   
/*     */   public Date getCreateDate() {
/*  99 */     return (Date)this._createDate;
/*     */   }
/*     */   
/*     */   public void setCreateDate(Date argCreateDate) {
/* 103 */     if (changed(argCreateDate, this._createDate, "createDate")) {
/* 104 */       this._createDate = (argCreateDate == null || argCreateDate instanceof DtvDate) ? (DtvDate)argCreateDate : new DtvDate(argCreateDate);
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public String getCreateUserId() {
/* 110 */     return this._createUserId;
/*     */   }
/*     */   
/*     */   public void setCreateUserId(String argCreateUserId) {
/* 114 */     if (changed(argCreateUserId, this._createUserId, "createUserId")) {
/* 115 */       this._createUserId = argCreateUserId;
/*     */     }
/*     */   }
/*     */   
/*     */   public Date getUpdateDate() {
/* 120 */     return (Date)this._updateDate;
/*     */   }
/*     */   
/*     */   public void setUpdateDate(Date argUpdateDate) {
/* 124 */     if (changed(argUpdateDate, this._updateDate, "updateDate")) {
/* 125 */       this._updateDate = (argUpdateDate == null || argUpdateDate instanceof DtvDate) ? (DtvDate)argUpdateDate : new DtvDate(argUpdateDate);
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public String getUpdateUserId() {
/* 131 */     return this._updateUserId;
/*     */   }
/*     */   
/*     */   public void setUpdateUserId(String argUpdateUserId) {
/* 135 */     if (changed(argUpdateUserId, this._updateUserId, "updateUserId")) {
/* 136 */       this._updateUserId = argUpdateUserId;
/*     */     }
/*     */   }
/*     */   
/*     */   public String getFlightNumber() {
/* 141 */     return this._flightNumber;
/*     */   }
/*     */   
/*     */   public void setFlightNumber(String argFlightNumber) {
/* 145 */     if (changed(argFlightNumber, this._flightNumber, "flightNumber")) {
/* 146 */       this._flightNumber = argFlightNumber;
/*     */     }
/*     */   }
/*     */   
/*     */   public String getDestinationAirport() {
/* 151 */     return this._destinationAirport;
/*     */   }
/*     */   
/*     */   public void setDestinationAirport(String argDestinationAirport) {
/* 155 */     if (changed(argDestinationAirport, this._destinationAirport, "destinationAirport")) {
/* 156 */       this._destinationAirport = argDestinationAirport;
/*     */     }
/*     */   }
/*     */   
/*     */   public String getDestinationCountry() {
/* 161 */     return this._destinationCountry;
/*     */   }
/*     */   
/*     */   public void setDestinationCountry(String argDestinationCountry) {
/* 165 */     if (changed(argDestinationCountry, this._destinationCountry, "destinationCountry")) {
/* 166 */       this._destinationCountry = argDestinationCountry;
/*     */     }
/*     */   }
/*     */   
/*     */   public String getDestinationZone() {
/* 171 */     return this._destinationZone;
/*     */   }
/*     */   
/*     */   public void setDestinationZone(String argDestinationZone) {
/* 175 */     if (changed(argDestinationZone, this._destinationZone, "destinationZone")) {
/* 176 */       this._destinationZone = argDestinationZone;
/*     */     }
/*     */   }
/*     */   
/*     */   public String getDestinationAirportName() {
/* 181 */     return this._destinationAirportName;
/*     */   }
/*     */   
/*     */   public void setDestinationAirportName(String argDestinationAirportName) {
/* 185 */     if (changed(argDestinationAirportName, this._destinationAirportName, "destinationAirportName")) {
/* 186 */       this._destinationAirportName = argDestinationAirportName;
/*     */     }
/*     */   }
/*     */   
/*     */   public String getOriginAirport() {
/* 191 */     return this._originAirport;
/*     */   }
/*     */   
/*     */   public void setOriginAirport(String argOriginAirport) {
/* 195 */     if (changed(argOriginAirport, this._originAirport, "originAirport")) {
/* 196 */       this._originAirport = argOriginAirport;
/*     */     }
/*     */   }
/*     */   
/*     */   public String getTaxCalculationMode() {
/* 201 */     return this._taxCalculationMode;
/*     */   }
/*     */   
/*     */   public void setTaxCalculationMode(String argTaxCalculationMode) {
/* 205 */     if (changed(argTaxCalculationMode, this._taxCalculationMode, "taxCalculationMode")) {
/* 206 */       this._taxCalculationMode = argTaxCalculationMode;
/*     */     }
/*     */   }
/*     */   
/*     */   public String getFirstFlightNumber() {
/* 211 */     return this._firstFlightNumber;
/*     */   }
/*     */   
/*     */   public void setFirstFlightNumber(String argFirstFlightNumber) {
/* 215 */     if (changed(argFirstFlightNumber, this._firstFlightNumber, "firstFlightNumber")) {
/* 216 */       this._firstFlightNumber = argFirstFlightNumber;
/*     */     }
/*     */   }
/*     */   
/*     */   public String getFirstDestinationAirport() {
/* 221 */     return this._firstDestinationAirport;
/*     */   }
/*     */   
/*     */   public void setFirstDestinationAirport(String argFirstDestinationAirport) {
/* 225 */     if (changed(argFirstDestinationAirport, this._firstDestinationAirport, "firstDestinationAirport")) {
/* 226 */       this._firstDestinationAirport = argFirstDestinationAirport;
/*     */     }
/*     */   }
/*     */   
/*     */   public String getFirstOriginAirport() {
/* 231 */     return this._firstOriginAirport;
/*     */   }
/*     */   
/*     */   public void setFirstOriginAirport(String argFirstOriginAirport) {
/* 235 */     if (changed(argFirstOriginAirport, this._firstOriginAirport, "firstOriginAirport")) {
/* 236 */       this._firstOriginAirport = argFirstOriginAirport;
/*     */     }
/*     */   }
/*     */   
/*     */   public String getFirstFlightSeatNumber() {
/* 241 */     return this._firstFlightSeatNumber;
/*     */   }
/*     */   
/*     */   public void setFirstFlightSeatNumber(String argFirstFlightSeatNumber) {
/* 245 */     if (changed(argFirstFlightSeatNumber, this._firstFlightSeatNumber, "firstFlightSeatNumber")) {
/* 246 */       this._firstFlightSeatNumber = argFirstFlightSeatNumber;
/*     */     }
/*     */   }
/*     */   
/*     */   public Date getFirstFlightScheduledDate() {
/* 251 */     return (Date)this._firstFlightScheduledDate;
/*     */   }
/*     */   
/*     */   public void setFirstFlightScheduledDate(Date argFirstFlightScheduledDate) {
/* 255 */     if (changed(argFirstFlightScheduledDate, this._firstFlightScheduledDate, "firstFlightScheduledDate")) {
/* 256 */       this._firstFlightScheduledDate = (argFirstFlightScheduledDate == null || argFirstFlightScheduledDate instanceof DtvDate) ? (DtvDate)argFirstFlightScheduledDate : new DtvDate(argFirstFlightScheduledDate);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String toString() {
/* 264 */     StringBuilder buf = new StringBuilder(512);
/* 265 */     buf.append(super.toString()).append(" Id: ").append(getObjectId()).append(" Values: ");
/* 266 */     if (getOrganizationId() != null) {
/* 267 */       buf.append("organizationId").append("=").append(getOrganizationId()).append(" ");
/*     */     }
/* 269 */     if (getRetailLocationId() != null) {
/* 270 */       buf.append("retailLocationId").append("=").append(getRetailLocationId()).append(" ");
/*     */     }
/* 272 */     if (getBusinessDate() != null) {
/* 273 */       buf.append("businessDate").append("=").append(getBusinessDate()).append(" ");
/*     */     }
/* 275 */     if (getWorkstationId() != null) {
/* 276 */       buf.append("workstationId").append("=").append(getWorkstationId()).append(" ");
/*     */     }
/* 278 */     if (getTransactionSequence() != null) {
/* 279 */       buf.append("transactionSequence").append("=").append(getTransactionSequence()).append(" ");
/*     */     }
/* 281 */     if (getCreateDate() != null) {
/* 282 */       buf.append("createDate").append("=").append(getCreateDate()).append(" ");
/*     */     }
/* 284 */     if (getCreateUserId() != null) {
/* 285 */       buf.append("createUserId").append("=").append(getCreateUserId()).append(" ");
/*     */     }
/* 287 */     if (getUpdateDate() != null) {
/* 288 */       buf.append("updateDate").append("=").append(getUpdateDate()).append(" ");
/*     */     }
/* 290 */     if (getUpdateUserId() != null) {
/* 291 */       buf.append("updateUserId").append("=").append(getUpdateUserId()).append(" ");
/*     */     }
/* 293 */     if (getFlightNumber() != null) {
/* 294 */       buf.append("flightNumber").append("=").append(getFlightNumber()).append(" ");
/*     */     }
/* 296 */     if (getDestinationAirport() != null) {
/* 297 */       buf.append("destinationAirport").append("=").append(getDestinationAirport()).append(" ");
/*     */     }
/* 299 */     if (getDestinationCountry() != null) {
/* 300 */       buf.append("destinationCountry").append("=").append(getDestinationCountry()).append(" ");
/*     */     }
/* 302 */     if (getDestinationZone() != null) {
/* 303 */       buf.append("destinationZone").append("=").append(getDestinationZone()).append(" ");
/*     */     }
/* 305 */     if (getDestinationAirportName() != null) {
/* 306 */       buf.append("destinationAirportName").append("=").append(getDestinationAirportName()).append(" ");
/*     */     }
/* 308 */     if (getOriginAirport() != null) {
/* 309 */       buf.append("originAirport").append("=").append(getOriginAirport()).append(" ");
/*     */     }
/* 311 */     if (getTaxCalculationMode() != null) {
/* 312 */       buf.append("taxCalculationMode").append("=").append(getTaxCalculationMode()).append(" ");
/*     */     }
/* 314 */     if (getFirstFlightNumber() != null) {
/* 315 */       buf.append("firstFlightNumber").append("=").append(getFirstFlightNumber()).append(" ");
/*     */     }
/* 317 */     if (getFirstDestinationAirport() != null) {
/* 318 */       buf.append("firstDestinationAirport").append("=").append(getFirstDestinationAirport()).append(" ");
/*     */     }
/* 320 */     if (getFirstOriginAirport() != null) {
/* 321 */       buf.append("firstOriginAirport").append("=").append(getFirstOriginAirport()).append(" ");
/*     */     }
/* 323 */     if (getFirstFlightSeatNumber() != null) {
/* 324 */       buf.append("firstFlightSeatNumber").append("=").append(getFirstFlightSeatNumber()).append(" ");
/*     */     }
/* 326 */     if (getFirstFlightScheduledDate() != null) {
/* 327 */       buf.append("firstFlightScheduledDate").append("=").append(getFirstFlightScheduledDate()).append(" ");
/*     */     }
/*     */     
/* 330 */     return buf.toString();
/*     */   }
/*     */   
/*     */   public IObjectId getObjectId() {
/* 334 */     RetailTransactionFlightInfoId id = new RetailTransactionFlightInfoId();
/* 335 */     id.setOrganizationId(getOrganizationId());
/* 336 */     id.setRetailLocationId(getRetailLocationId());
/* 337 */     id.setBusinessDate(getBusinessDate());
/* 338 */     id.setWorkstationId(getWorkstationId());
/* 339 */     id.setTransactionSequence(getTransactionSequence());
/* 340 */     return (IObjectId)id;
/*     */   }
/*     */   
/*     */   public void setObjectId(IObjectId argObjectId) {
/* 344 */     setOrganizationId(((RetailTransactionFlightInfoId)argObjectId).getOrganizationId());
/* 345 */     setRetailLocationId(((RetailTransactionFlightInfoId)argObjectId).getRetailLocationId());
/* 346 */     setBusinessDate(((RetailTransactionFlightInfoId)argObjectId).getBusinessDate());
/* 347 */     setWorkstationId(((RetailTransactionFlightInfoId)argObjectId).getWorkstationId());
/* 348 */     setTransactionSequence(((RetailTransactionFlightInfoId)argObjectId).getTransactionSequence());
/*     */   }
/*     */   
/*     */   public String getImplementingClass() {
/* 352 */     return null;
/*     */   }
/*     */   
/*     */   public String toXmlString() {
/* 356 */     StringBuilder buf = new StringBuilder(1050);
/* 357 */     buf.append("<").append("dao").append(" name=\"RetailTransactionFlightInfo\" cmd=\"" + getObjectStateString() + "\">");
/* 358 */     getFieldsAsXml(buf);
/* 359 */     buf.append("</").append("dao").append(">");
/*     */     
/* 361 */     return buf.toString();
/*     */   }
/*     */   
/*     */   public Map<String, String> getValues() {
/* 365 */     Map<String, String> values = super.getValues();
/* 366 */     if (this._organizationId != null) values.put("OrganizationId", DaoUtils.getXmlSafeFieldValue(-5, this._organizationId)); 
/* 367 */     if (this._retailLocationId != null) values.put("RetailLocationId", DaoUtils.getXmlSafeFieldValue(-5, this._retailLocationId)); 
/* 368 */     if (this._businessDate != null) values.put("BusinessDate", DaoUtils.getXmlSafeFieldValue(91, this._businessDate)); 
/* 369 */     if (this._workstationId != null) values.put("WorkstationId", DaoUtils.getXmlSafeFieldValue(-5, this._workstationId)); 
/* 370 */     if (this._transactionSequence != null) values.put("TransactionSequence", DaoUtils.getXmlSafeFieldValue(-5, this._transactionSequence)); 
/* 371 */     if (this._createDate != null) values.put("CreateDate", DaoUtils.getXmlSafeFieldValue(91, this._createDate)); 
/* 372 */     if (this._createUserId != null) values.put("CreateUserId", DaoUtils.getXmlSafeFieldValue(12, this._createUserId)); 
/* 373 */     if (this._updateDate != null) values.put("UpdateDate", DaoUtils.getXmlSafeFieldValue(91, this._updateDate)); 
/* 374 */     if (this._updateUserId != null) values.put("UpdateUserId", DaoUtils.getXmlSafeFieldValue(12, this._updateUserId)); 
/* 375 */     if (this._flightNumber != null) values.put("FlightNumber", DaoUtils.getXmlSafeFieldValue(12, this._flightNumber)); 
/* 376 */     if (this._destinationAirport != null) values.put("DestinationAirport", DaoUtils.getXmlSafeFieldValue(12, this._destinationAirport)); 
/* 377 */     if (this._destinationCountry != null) values.put("DestinationCountry", DaoUtils.getXmlSafeFieldValue(12, this._destinationCountry)); 
/* 378 */     if (this._destinationZone != null) values.put("DestinationZone", DaoUtils.getXmlSafeFieldValue(12, this._destinationZone)); 
/* 379 */     if (this._destinationAirportName != null) values.put("DestinationAirportName", DaoUtils.getXmlSafeFieldValue(12, this._destinationAirportName)); 
/* 380 */     if (this._originAirport != null) values.put("OriginAirport", DaoUtils.getXmlSafeFieldValue(12, this._originAirport)); 
/* 381 */     if (this._taxCalculationMode != null) values.put("TaxCalculationMode", DaoUtils.getXmlSafeFieldValue(12, this._taxCalculationMode)); 
/* 382 */     if (this._firstFlightNumber != null) values.put("FirstFlightNumber", DaoUtils.getXmlSafeFieldValue(12, this._firstFlightNumber)); 
/* 383 */     if (this._firstDestinationAirport != null) values.put("FirstDestinationAirport", DaoUtils.getXmlSafeFieldValue(12, this._firstDestinationAirport)); 
/* 384 */     if (this._firstOriginAirport != null) values.put("FirstOriginAirport", DaoUtils.getXmlSafeFieldValue(12, this._firstOriginAirport)); 
/* 385 */     if (this._firstFlightSeatNumber != null) values.put("FirstFlightSeatNumber", DaoUtils.getXmlSafeFieldValue(12, this._firstFlightSeatNumber)); 
/* 386 */     if (this._firstFlightScheduledDate != null) values.put("FirstFlightScheduledDate", DaoUtils.getXmlSafeFieldValue(91, this._firstFlightScheduledDate)); 
/* 387 */     return values;
/*     */   }
/*     */ 
/*     */   
/*     */   public void setValues(Map<String, String> argValues) {
/* 392 */     super.setValues(argValues);
/* 393 */     for (Map.Entry<String, String> field : argValues.entrySet()) {
/*     */       
/* 395 */       String fieldName = field.getKey();
/* 396 */       String fieldValue = field.getValue();
/* 397 */       switch (fieldName) {
/*     */         
/*     */         case "OrganizationId":
/*     */           try {
/* 401 */             Object value = DaoUtils.getFieldValueForXmlString(-5, fieldValue);
/* 402 */             setOrganizationId((Long)value);
/* 403 */           } catch (Exception ee) {
/* 404 */             throw new DtxException("An exception occurred while calling setOrganizationId() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "RetailLocationId":
/*     */           try {
/* 410 */             Object value = DaoUtils.getFieldValueForXmlString(-5, fieldValue);
/* 411 */             setRetailLocationId((Long)value);
/* 412 */           } catch (Exception ee) {
/* 413 */             throw new DtxException("An exception occurred while calling setRetailLocationId() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "BusinessDate":
/*     */           try {
/* 419 */             Object value = DaoUtils.getFieldValueForXmlString(91, fieldValue);
/* 420 */             setBusinessDate((Date)value);
/* 421 */           } catch (Exception ee) {
/* 422 */             throw new DtxException("An exception occurred while calling setBusinessDate() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "WorkstationId":
/*     */           try {
/* 428 */             Object value = DaoUtils.getFieldValueForXmlString(-5, fieldValue);
/* 429 */             setWorkstationId((Long)value);
/* 430 */           } catch (Exception ee) {
/* 431 */             throw new DtxException("An exception occurred while calling setWorkstationId() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "TransactionSequence":
/*     */           try {
/* 437 */             Object value = DaoUtils.getFieldValueForXmlString(-5, fieldValue);
/* 438 */             setTransactionSequence((Long)value);
/* 439 */           } catch (Exception ee) {
/* 440 */             throw new DtxException("An exception occurred while calling setTransactionSequence() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "CreateDate":
/*     */           try {
/* 446 */             Object value = DaoUtils.getFieldValueForXmlString(91, fieldValue);
/* 447 */             setCreateDate((Date)value);
/* 448 */           } catch (Exception ee) {
/* 449 */             throw new DtxException("An exception occurred while calling setCreateDate() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "CreateUserId":
/*     */           try {
/* 455 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 456 */             setCreateUserId((String)value);
/* 457 */           } catch (Exception ee) {
/* 458 */             throw new DtxException("An exception occurred while calling setCreateUserId() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "UpdateDate":
/*     */           try {
/* 464 */             Object value = DaoUtils.getFieldValueForXmlString(91, fieldValue);
/* 465 */             setUpdateDate((Date)value);
/* 466 */           } catch (Exception ee) {
/* 467 */             throw new DtxException("An exception occurred while calling setUpdateDate() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "UpdateUserId":
/*     */           try {
/* 473 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 474 */             setUpdateUserId((String)value);
/* 475 */           } catch (Exception ee) {
/* 476 */             throw new DtxException("An exception occurred while calling setUpdateUserId() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "FlightNumber":
/*     */           try {
/* 482 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 483 */             setFlightNumber((String)value);
/* 484 */           } catch (Exception ee) {
/* 485 */             throw new DtxException("An exception occurred while calling setFlightNumber() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "DestinationAirport":
/*     */           try {
/* 491 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 492 */             setDestinationAirport((String)value);
/* 493 */           } catch (Exception ee) {
/* 494 */             throw new DtxException("An exception occurred while calling setDestinationAirport() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "DestinationCountry":
/*     */           try {
/* 500 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 501 */             setDestinationCountry((String)value);
/* 502 */           } catch (Exception ee) {
/* 503 */             throw new DtxException("An exception occurred while calling setDestinationCountry() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "DestinationZone":
/*     */           try {
/* 509 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 510 */             setDestinationZone((String)value);
/* 511 */           } catch (Exception ee) {
/* 512 */             throw new DtxException("An exception occurred while calling setDestinationZone() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "DestinationAirportName":
/*     */           try {
/* 518 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 519 */             setDestinationAirportName((String)value);
/* 520 */           } catch (Exception ee) {
/* 521 */             throw new DtxException("An exception occurred while calling setDestinationAirportName() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "OriginAirport":
/*     */           try {
/* 527 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 528 */             setOriginAirport((String)value);
/* 529 */           } catch (Exception ee) {
/* 530 */             throw new DtxException("An exception occurred while calling setOriginAirport() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "TaxCalculationMode":
/*     */           try {
/* 536 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 537 */             setTaxCalculationMode((String)value);
/* 538 */           } catch (Exception ee) {
/* 539 */             throw new DtxException("An exception occurred while calling setTaxCalculationMode() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "FirstFlightNumber":
/*     */           try {
/* 545 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 546 */             setFirstFlightNumber((String)value);
/* 547 */           } catch (Exception ee) {
/* 548 */             throw new DtxException("An exception occurred while calling setFirstFlightNumber() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "FirstDestinationAirport":
/*     */           try {
/* 554 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 555 */             setFirstDestinationAirport((String)value);
/* 556 */           } catch (Exception ee) {
/* 557 */             throw new DtxException("An exception occurred while calling setFirstDestinationAirport() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "FirstOriginAirport":
/*     */           try {
/* 563 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 564 */             setFirstOriginAirport((String)value);
/* 565 */           } catch (Exception ee) {
/* 566 */             throw new DtxException("An exception occurred while calling setFirstOriginAirport() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "FirstFlightSeatNumber":
/*     */           try {
/* 572 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 573 */             setFirstFlightSeatNumber((String)value);
/* 574 */           } catch (Exception ee) {
/* 575 */             throw new DtxException("An exception occurred while calling setFirstFlightSeatNumber() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "FirstFlightScheduledDate":
/*     */           try {
/* 581 */             Object value = DaoUtils.getFieldValueForXmlString(91, fieldValue);
/* 582 */             setFirstFlightScheduledDate((Date)value);
/* 583 */           } catch (Exception ee) {
/* 584 */             throw new DtxException("An exception occurred while calling setFirstFlightScheduledDate() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */       } 
/*     */     } 
/*     */   }
/*     */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\trl\impl\RetailTransactionFlightInfoDAO.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */