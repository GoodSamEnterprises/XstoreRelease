/*     */ package dtv.xst.dao.inv.impl;
/*     */ 
/*     */ import dtv.data2.access.DaoUtils;
/*     */ import dtv.data2.access.IObjectId;
/*     */ import dtv.data2.access.exception.DtxException;
/*     */ import dtv.data2.access.impl.AbstractDAOImpl;
/*     */ import dtv.util.DtvDate;
/*     */ import dtv.xst.dao.inv.ShipmentId;
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
/*     */ public class ShipmentDAO
/*     */   extends AbstractDAOImpl
/*     */ {
/*     */   private static final long serialVersionUID = -451684934L;
/*  23 */   private static final Logger _logger = Logger.getLogger(ShipmentDAO.class);
/*     */   
/*     */   private Long _organizationId;
/*     */   private Long _retailLocationId;
/*     */   private String _documentId;
/*     */   private String _documentTypeCode;
/*     */   private Integer _shipmentSequence;
/*     */   private DtvDate _createDate;
/*     */   private String _createUserId;
/*     */   private DtvDate _updateDate;
/*     */   private String _updateUserId;
/*     */   private DtvDate _expectedDeliveryDate;
/*     */   private DtvDate _actualDeliveryDate;
/*     */   private DtvDate _expectedShipDate;
/*     */   private DtvDate _actualShipDate;
/*     */   private String _destinationName;
/*     */   private String _shippingCarrier;
/*     */   private String _trackingNumber;
/*     */   private String _shipmentStatusCode;
/*     */   private Long _destinationPartyId;
/*     */   private Long _destinationRetailLocationId;
/*     */   private String _recordCreationType;
/*     */   private String _shippingMethod;
/*     */   private String _shippingLabel;
/*     */   private String _destinationType;
/*     */   private String _destinationServiceLocationId;
/*     */   
/*     */   public Long getOrganizationId() {
/*  51 */     return this._organizationId;
/*     */   }
/*     */   
/*     */   public void setOrganizationId(Long argOrganizationId) {
/*  55 */     if (changed(argOrganizationId, this._organizationId, "organizationId")) {
/*  56 */       this._organizationId = argOrganizationId;
/*     */     }
/*     */   }
/*     */   
/*     */   public Long getRetailLocationId() {
/*  61 */     return this._retailLocationId;
/*     */   }
/*     */   
/*     */   public void setRetailLocationId(Long argRetailLocationId) {
/*  65 */     if (changed(argRetailLocationId, this._retailLocationId, "retailLocationId")) {
/*  66 */       this._retailLocationId = argRetailLocationId;
/*     */     }
/*     */   }
/*     */   
/*     */   public String getDocumentId() {
/*  71 */     return this._documentId;
/*     */   }
/*     */   
/*     */   public void setDocumentId(String argDocumentId) {
/*  75 */     if (changed(argDocumentId, this._documentId, "documentId")) {
/*  76 */       this._documentId = (argDocumentId != null && MANAGE_CASE) ? argDocumentId.toUpperCase() : argDocumentId;
/*     */     }
/*     */   }
/*     */   
/*     */   public String getDocumentTypeCode() {
/*  81 */     return this._documentTypeCode;
/*     */   }
/*     */   
/*     */   public void setDocumentTypeCode(String argDocumentTypeCode) {
/*  85 */     if (changed(argDocumentTypeCode, this._documentTypeCode, "documentTypeCode")) {
/*  86 */       this._documentTypeCode = (argDocumentTypeCode != null && MANAGE_CASE) ? argDocumentTypeCode.toUpperCase() : argDocumentTypeCode;
/*     */     }
/*     */   }
/*     */   
/*     */   public Integer getShipmentSequence() {
/*  91 */     return this._shipmentSequence;
/*     */   }
/*     */   
/*     */   public void setShipmentSequence(Integer argShipmentSequence) {
/*  95 */     if (changed(argShipmentSequence, this._shipmentSequence, "shipmentSequence")) {
/*  96 */       this._shipmentSequence = argShipmentSequence;
/*     */     }
/*     */   }
/*     */   
/*     */   public Date getCreateDate() {
/* 101 */     return (Date)this._createDate;
/*     */   }
/*     */   
/*     */   public void setCreateDate(Date argCreateDate) {
/* 105 */     if (changed(argCreateDate, this._createDate, "createDate")) {
/* 106 */       this._createDate = (argCreateDate == null || argCreateDate instanceof DtvDate) ? (DtvDate)argCreateDate : new DtvDate(argCreateDate);
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public String getCreateUserId() {
/* 112 */     return this._createUserId;
/*     */   }
/*     */   
/*     */   public void setCreateUserId(String argCreateUserId) {
/* 116 */     if (changed(argCreateUserId, this._createUserId, "createUserId")) {
/* 117 */       this._createUserId = argCreateUserId;
/*     */     }
/*     */   }
/*     */   
/*     */   public Date getUpdateDate() {
/* 122 */     return (Date)this._updateDate;
/*     */   }
/*     */   
/*     */   public void setUpdateDate(Date argUpdateDate) {
/* 126 */     if (changed(argUpdateDate, this._updateDate, "updateDate")) {
/* 127 */       this._updateDate = (argUpdateDate == null || argUpdateDate instanceof DtvDate) ? (DtvDate)argUpdateDate : new DtvDate(argUpdateDate);
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public String getUpdateUserId() {
/* 133 */     return this._updateUserId;
/*     */   }
/*     */   
/*     */   public void setUpdateUserId(String argUpdateUserId) {
/* 137 */     if (changed(argUpdateUserId, this._updateUserId, "updateUserId")) {
/* 138 */       this._updateUserId = argUpdateUserId;
/*     */     }
/*     */   }
/*     */   
/*     */   public Date getExpectedDeliveryDate() {
/* 143 */     return (Date)this._expectedDeliveryDate;
/*     */   }
/*     */   
/*     */   public void setExpectedDeliveryDate(Date argExpectedDeliveryDate) {
/* 147 */     if (changed(argExpectedDeliveryDate, this._expectedDeliveryDate, "expectedDeliveryDate")) {
/* 148 */       this._expectedDeliveryDate = (argExpectedDeliveryDate == null || argExpectedDeliveryDate instanceof DtvDate) ? (DtvDate)argExpectedDeliveryDate : new DtvDate(argExpectedDeliveryDate);
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public Date getActualDeliveryDate() {
/* 154 */     return (Date)this._actualDeliveryDate;
/*     */   }
/*     */   
/*     */   public void setActualDeliveryDate(Date argActualDeliveryDate) {
/* 158 */     if (changed(argActualDeliveryDate, this._actualDeliveryDate, "actualDeliveryDate")) {
/* 159 */       this._actualDeliveryDate = (argActualDeliveryDate == null || argActualDeliveryDate instanceof DtvDate) ? (DtvDate)argActualDeliveryDate : new DtvDate(argActualDeliveryDate);
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public Date getExpectedShipDate() {
/* 165 */     return (Date)this._expectedShipDate;
/*     */   }
/*     */   
/*     */   public void setExpectedShipDate(Date argExpectedShipDate) {
/* 169 */     if (changed(argExpectedShipDate, this._expectedShipDate, "expectedShipDate")) {
/* 170 */       this._expectedShipDate = (argExpectedShipDate == null || argExpectedShipDate instanceof DtvDate) ? (DtvDate)argExpectedShipDate : new DtvDate(argExpectedShipDate);
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public Date getActualShipDate() {
/* 176 */     return (Date)this._actualShipDate;
/*     */   }
/*     */   
/*     */   public void setActualShipDate(Date argActualShipDate) {
/* 180 */     if (changed(argActualShipDate, this._actualShipDate, "actualShipDate")) {
/* 181 */       this._actualShipDate = (argActualShipDate == null || argActualShipDate instanceof DtvDate) ? (DtvDate)argActualShipDate : new DtvDate(argActualShipDate);
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public String getDestinationName() {
/* 187 */     return this._destinationName;
/*     */   }
/*     */   
/*     */   public void setDestinationName(String argDestinationName) {
/* 191 */     if (changed(argDestinationName, this._destinationName, "destinationName")) {
/* 192 */       this._destinationName = argDestinationName;
/*     */     }
/*     */   }
/*     */   
/*     */   public String getShippingCarrier() {
/* 197 */     return this._shippingCarrier;
/*     */   }
/*     */   
/*     */   public void setShippingCarrier(String argShippingCarrier) {
/* 201 */     if (changed(argShippingCarrier, this._shippingCarrier, "shippingCarrier")) {
/* 202 */       this._shippingCarrier = argShippingCarrier;
/*     */     }
/*     */   }
/*     */   
/*     */   public String getTrackingNumber() {
/* 207 */     return this._trackingNumber;
/*     */   }
/*     */   
/*     */   public void setTrackingNumber(String argTrackingNumber) {
/* 211 */     if (changed(argTrackingNumber, this._trackingNumber, "trackingNumber")) {
/* 212 */       this._trackingNumber = argTrackingNumber;
/*     */     }
/*     */   }
/*     */   
/*     */   public String getShipmentStatusCode() {
/* 217 */     return this._shipmentStatusCode;
/*     */   }
/*     */   
/*     */   public void setShipmentStatusCode(String argShipmentStatusCode) {
/* 221 */     if (changed(argShipmentStatusCode, this._shipmentStatusCode, "shipmentStatusCode")) {
/* 222 */       this._shipmentStatusCode = argShipmentStatusCode;
/*     */     }
/*     */   }
/*     */   
/*     */   public Long getDestinationPartyId() {
/* 227 */     return this._destinationPartyId;
/*     */   }
/*     */   
/*     */   public void setDestinationPartyId(Long argDestinationPartyId) {
/* 231 */     if (changed(argDestinationPartyId, this._destinationPartyId, "destinationPartyId")) {
/* 232 */       this._destinationPartyId = argDestinationPartyId;
/*     */     }
/*     */   }
/*     */   
/*     */   public Long getDestinationRetailLocationId() {
/* 237 */     return this._destinationRetailLocationId;
/*     */   }
/*     */   
/*     */   public void setDestinationRetailLocationId(Long argDestinationRetailLocationId) {
/* 241 */     if (changed(argDestinationRetailLocationId, this._destinationRetailLocationId, "destinationRetailLocationId")) {
/* 242 */       this._destinationRetailLocationId = argDestinationRetailLocationId;
/*     */     }
/*     */   }
/*     */   
/*     */   public String getRecordCreationType() {
/* 247 */     return this._recordCreationType;
/*     */   }
/*     */   
/*     */   public void setRecordCreationType(String argRecordCreationType) {
/* 251 */     if (changed(argRecordCreationType, this._recordCreationType, "recordCreationType")) {
/* 252 */       this._recordCreationType = argRecordCreationType;
/*     */     }
/*     */   }
/*     */   
/*     */   public String getShippingMethod() {
/* 257 */     return this._shippingMethod;
/*     */   }
/*     */   
/*     */   public void setShippingMethod(String argShippingMethod) {
/* 261 */     if (changed(argShippingMethod, this._shippingMethod, "shippingMethod")) {
/* 262 */       this._shippingMethod = argShippingMethod;
/*     */     }
/*     */   }
/*     */   
/*     */   public String getShippingLabel() {
/* 267 */     return this._shippingLabel;
/*     */   }
/*     */   
/*     */   public void setShippingLabel(String argShippingLabel) {
/* 271 */     if (changed(argShippingLabel, this._shippingLabel, "shippingLabel")) {
/* 272 */       this._shippingLabel = argShippingLabel;
/*     */     }
/*     */   }
/*     */   
/*     */   public String getDestinationType() {
/* 277 */     return this._destinationType;
/*     */   }
/*     */   
/*     */   public void setDestinationType(String argDestinationType) {
/* 281 */     if (changed(argDestinationType, this._destinationType, "destinationType")) {
/* 282 */       this._destinationType = argDestinationType;
/*     */     }
/*     */   }
/*     */   
/*     */   public String getDestinationServiceLocationId() {
/* 287 */     return this._destinationServiceLocationId;
/*     */   }
/*     */   
/*     */   public void setDestinationServiceLocationId(String argDestinationServiceLocationId) {
/* 291 */     if (changed(argDestinationServiceLocationId, this._destinationServiceLocationId, "destinationServiceLocationId")) {
/* 292 */       this._destinationServiceLocationId = argDestinationServiceLocationId;
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public String toString() {
/* 299 */     StringBuilder buf = new StringBuilder(512);
/* 300 */     buf.append(super.toString()).append(" Id: ").append(getObjectId()).append(" Values: ");
/* 301 */     if (getOrganizationId() != null) {
/* 302 */       buf.append("organizationId").append("=").append(getOrganizationId()).append(" ");
/*     */     }
/* 304 */     if (getRetailLocationId() != null) {
/* 305 */       buf.append("retailLocationId").append("=").append(getRetailLocationId()).append(" ");
/*     */     }
/* 307 */     if (getDocumentId() != null) {
/* 308 */       buf.append("documentId").append("=").append(getDocumentId()).append(" ");
/*     */     }
/* 310 */     if (getDocumentTypeCode() != null) {
/* 311 */       buf.append("documentTypeCode").append("=").append(getDocumentTypeCode()).append(" ");
/*     */     }
/* 313 */     if (getShipmentSequence() != null) {
/* 314 */       buf.append("shipmentSequence").append("=").append(getShipmentSequence()).append(" ");
/*     */     }
/* 316 */     if (getCreateDate() != null) {
/* 317 */       buf.append("createDate").append("=").append(getCreateDate()).append(" ");
/*     */     }
/* 319 */     if (getCreateUserId() != null) {
/* 320 */       buf.append("createUserId").append("=").append(getCreateUserId()).append(" ");
/*     */     }
/* 322 */     if (getUpdateDate() != null) {
/* 323 */       buf.append("updateDate").append("=").append(getUpdateDate()).append(" ");
/*     */     }
/* 325 */     if (getUpdateUserId() != null) {
/* 326 */       buf.append("updateUserId").append("=").append(getUpdateUserId()).append(" ");
/*     */     }
/* 328 */     if (getExpectedDeliveryDate() != null) {
/* 329 */       buf.append("expectedDeliveryDate").append("=").append(getExpectedDeliveryDate()).append(" ");
/*     */     }
/* 331 */     if (getActualDeliveryDate() != null) {
/* 332 */       buf.append("actualDeliveryDate").append("=").append(getActualDeliveryDate()).append(" ");
/*     */     }
/* 334 */     if (getExpectedShipDate() != null) {
/* 335 */       buf.append("expectedShipDate").append("=").append(getExpectedShipDate()).append(" ");
/*     */     }
/* 337 */     if (getActualShipDate() != null) {
/* 338 */       buf.append("actualShipDate").append("=").append(getActualShipDate()).append(" ");
/*     */     }
/* 340 */     if (getDestinationName() != null) {
/* 341 */       buf.append("destinationName").append("=").append(getDestinationName()).append(" ");
/*     */     }
/* 343 */     if (getShippingCarrier() != null) {
/* 344 */       buf.append("shippingCarrier").append("=").append(getShippingCarrier()).append(" ");
/*     */     }
/* 346 */     if (getTrackingNumber() != null) {
/* 347 */       buf.append("trackingNumber").append("=").append(getTrackingNumber()).append(" ");
/*     */     }
/* 349 */     if (getShipmentStatusCode() != null) {
/* 350 */       buf.append("shipmentStatusCode").append("=").append(getShipmentStatusCode()).append(" ");
/*     */     }
/* 352 */     if (getDestinationPartyId() != null) {
/* 353 */       buf.append("destinationPartyId").append("=").append(getDestinationPartyId()).append(" ");
/*     */     }
/* 355 */     if (getDestinationRetailLocationId() != null) {
/* 356 */       buf.append("destinationRetailLocationId").append("=").append(getDestinationRetailLocationId()).append(" ");
/*     */     }
/* 358 */     if (getRecordCreationType() != null) {
/* 359 */       buf.append("recordCreationType").append("=").append(getRecordCreationType()).append(" ");
/*     */     }
/* 361 */     if (getShippingMethod() != null) {
/* 362 */       buf.append("shippingMethod").append("=").append(getShippingMethod()).append(" ");
/*     */     }
/* 364 */     if (getShippingLabel() != null) {
/* 365 */       buf.append("shippingLabel").append("=").append(getShippingLabel()).append(" ");
/*     */     }
/* 367 */     if (getDestinationType() != null) {
/* 368 */       buf.append("destinationType").append("=").append(getDestinationType()).append(" ");
/*     */     }
/* 370 */     if (getDestinationServiceLocationId() != null) {
/* 371 */       buf.append("destinationServiceLocationId").append("=").append(getDestinationServiceLocationId()).append(" ");
/*     */     }
/*     */     
/* 374 */     return buf.toString();
/*     */   }
/*     */   
/*     */   public IObjectId getObjectId() {
/* 378 */     ShipmentId id = new ShipmentId();
/* 379 */     id.setOrganizationId(getOrganizationId());
/* 380 */     id.setRetailLocationId(getRetailLocationId());
/* 381 */     id.setDocumentId(getDocumentId());
/* 382 */     id.setDocumentTypeCode(getDocumentTypeCode());
/* 383 */     id.setShipmentSequence(getShipmentSequence());
/* 384 */     return (IObjectId)id;
/*     */   }
/*     */   
/*     */   public void setObjectId(IObjectId argObjectId) {
/* 388 */     setOrganizationId(((ShipmentId)argObjectId).getOrganizationId());
/* 389 */     setRetailLocationId(((ShipmentId)argObjectId).getRetailLocationId());
/* 390 */     setDocumentId(((ShipmentId)argObjectId).getDocumentId());
/* 391 */     setDocumentTypeCode(((ShipmentId)argObjectId).getDocumentTypeCode());
/* 392 */     setShipmentSequence(((ShipmentId)argObjectId).getShipmentSequence());
/*     */   }
/*     */   
/*     */   public String getImplementingClass() {
/* 396 */     return null;
/*     */   }
/*     */   
/*     */   public String toXmlString() {
/* 400 */     StringBuilder buf = new StringBuilder(1200);
/* 401 */     buf.append("<").append("dao").append(" name=\"Shipment\" cmd=\"" + getObjectStateString() + "\">");
/* 402 */     getFieldsAsXml(buf);
/* 403 */     buf.append("</").append("dao").append(">");
/*     */     
/* 405 */     return buf.toString();
/*     */   }
/*     */   
/*     */   public Map<String, String> getValues() {
/* 409 */     Map<String, String> values = super.getValues();
/* 410 */     if (this._organizationId != null) values.put("OrganizationId", DaoUtils.getXmlSafeFieldValue(-5, this._organizationId)); 
/* 411 */     if (this._retailLocationId != null) values.put("RetailLocationId", DaoUtils.getXmlSafeFieldValue(-5, this._retailLocationId)); 
/* 412 */     if (this._documentId != null) values.put("DocumentId", DaoUtils.getXmlSafeFieldValue(12, this._documentId)); 
/* 413 */     if (this._documentTypeCode != null) values.put("DocumentTypeCode", DaoUtils.getXmlSafeFieldValue(12, this._documentTypeCode)); 
/* 414 */     if (this._shipmentSequence != null) values.put("ShipmentSequence", DaoUtils.getXmlSafeFieldValue(4, this._shipmentSequence)); 
/* 415 */     if (this._createDate != null) values.put("CreateDate", DaoUtils.getXmlSafeFieldValue(91, this._createDate)); 
/* 416 */     if (this._createUserId != null) values.put("CreateUserId", DaoUtils.getXmlSafeFieldValue(12, this._createUserId)); 
/* 417 */     if (this._updateDate != null) values.put("UpdateDate", DaoUtils.getXmlSafeFieldValue(91, this._updateDate)); 
/* 418 */     if (this._updateUserId != null) values.put("UpdateUserId", DaoUtils.getXmlSafeFieldValue(12, this._updateUserId)); 
/* 419 */     if (this._expectedDeliveryDate != null) values.put("ExpectedDeliveryDate", DaoUtils.getXmlSafeFieldValue(91, this._expectedDeliveryDate)); 
/* 420 */     if (this._actualDeliveryDate != null) values.put("ActualDeliveryDate", DaoUtils.getXmlSafeFieldValue(91, this._actualDeliveryDate)); 
/* 421 */     if (this._expectedShipDate != null) values.put("ExpectedShipDate", DaoUtils.getXmlSafeFieldValue(91, this._expectedShipDate)); 
/* 422 */     if (this._actualShipDate != null) values.put("ActualShipDate", DaoUtils.getXmlSafeFieldValue(91, this._actualShipDate)); 
/* 423 */     if (this._destinationName != null) values.put("DestinationName", DaoUtils.getXmlSafeFieldValue(12, this._destinationName)); 
/* 424 */     if (this._shippingCarrier != null) values.put("ShippingCarrier", DaoUtils.getXmlSafeFieldValue(12, this._shippingCarrier)); 
/* 425 */     if (this._trackingNumber != null) values.put("TrackingNumber", DaoUtils.getXmlSafeFieldValue(12, this._trackingNumber)); 
/* 426 */     if (this._shipmentStatusCode != null) values.put("ShipmentStatusCode", DaoUtils.getXmlSafeFieldValue(12, this._shipmentStatusCode)); 
/* 427 */     if (this._destinationPartyId != null) values.put("DestinationPartyId", DaoUtils.getXmlSafeFieldValue(-5, this._destinationPartyId)); 
/* 428 */     if (this._destinationRetailLocationId != null) values.put("DestinationRetailLocationId", DaoUtils.getXmlSafeFieldValue(-5, this._destinationRetailLocationId)); 
/* 429 */     if (this._recordCreationType != null) values.put("RecordCreationType", DaoUtils.getXmlSafeFieldValue(12, this._recordCreationType)); 
/* 430 */     if (this._shippingMethod != null) values.put("ShippingMethod", DaoUtils.getXmlSafeFieldValue(12, this._shippingMethod)); 
/* 431 */     if (this._shippingLabel != null) values.put("ShippingLabel", DaoUtils.getXmlSafeFieldValue(12, this._shippingLabel)); 
/* 432 */     if (this._destinationType != null) values.put("DestinationType", DaoUtils.getXmlSafeFieldValue(12, this._destinationType)); 
/* 433 */     if (this._destinationServiceLocationId != null) values.put("DestinationServiceLocationId", DaoUtils.getXmlSafeFieldValue(12, this._destinationServiceLocationId)); 
/* 434 */     return values;
/*     */   }
/*     */ 
/*     */   
/*     */   public void setValues(Map<String, String> argValues) {
/* 439 */     super.setValues(argValues);
/* 440 */     for (Map.Entry<String, String> field : argValues.entrySet()) {
/*     */       
/* 442 */       String fieldName = field.getKey();
/* 443 */       String fieldValue = field.getValue();
/* 444 */       switch (fieldName) {
/*     */         
/*     */         case "OrganizationId":
/*     */           try {
/* 448 */             Object value = DaoUtils.getFieldValueForXmlString(-5, fieldValue);
/* 449 */             setOrganizationId((Long)value);
/* 450 */           } catch (Exception ee) {
/* 451 */             throw new DtxException("An exception occurred while calling setOrganizationId() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "RetailLocationId":
/*     */           try {
/* 457 */             Object value = DaoUtils.getFieldValueForXmlString(-5, fieldValue);
/* 458 */             setRetailLocationId((Long)value);
/* 459 */           } catch (Exception ee) {
/* 460 */             throw new DtxException("An exception occurred while calling setRetailLocationId() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "DocumentId":
/*     */           try {
/* 466 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 467 */             setDocumentId((String)value);
/* 468 */           } catch (Exception ee) {
/* 469 */             throw new DtxException("An exception occurred while calling setDocumentId() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "DocumentTypeCode":
/*     */           try {
/* 475 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 476 */             setDocumentTypeCode((String)value);
/* 477 */           } catch (Exception ee) {
/* 478 */             throw new DtxException("An exception occurred while calling setDocumentTypeCode() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "ShipmentSequence":
/*     */           try {
/* 484 */             Object value = DaoUtils.getFieldValueForXmlString(4, fieldValue);
/* 485 */             setShipmentSequence((Integer)value);
/* 486 */           } catch (Exception ee) {
/* 487 */             throw new DtxException("An exception occurred while calling setShipmentSequence() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "CreateDate":
/*     */           try {
/* 493 */             Object value = DaoUtils.getFieldValueForXmlString(91, fieldValue);
/* 494 */             setCreateDate((Date)value);
/* 495 */           } catch (Exception ee) {
/* 496 */             throw new DtxException("An exception occurred while calling setCreateDate() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "CreateUserId":
/*     */           try {
/* 502 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 503 */             setCreateUserId((String)value);
/* 504 */           } catch (Exception ee) {
/* 505 */             throw new DtxException("An exception occurred while calling setCreateUserId() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "UpdateDate":
/*     */           try {
/* 511 */             Object value = DaoUtils.getFieldValueForXmlString(91, fieldValue);
/* 512 */             setUpdateDate((Date)value);
/* 513 */           } catch (Exception ee) {
/* 514 */             throw new DtxException("An exception occurred while calling setUpdateDate() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "UpdateUserId":
/*     */           try {
/* 520 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 521 */             setUpdateUserId((String)value);
/* 522 */           } catch (Exception ee) {
/* 523 */             throw new DtxException("An exception occurred while calling setUpdateUserId() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "ExpectedDeliveryDate":
/*     */           try {
/* 529 */             Object value = DaoUtils.getFieldValueForXmlString(91, fieldValue);
/* 530 */             setExpectedDeliveryDate((Date)value);
/* 531 */           } catch (Exception ee) {
/* 532 */             throw new DtxException("An exception occurred while calling setExpectedDeliveryDate() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "ActualDeliveryDate":
/*     */           try {
/* 538 */             Object value = DaoUtils.getFieldValueForXmlString(91, fieldValue);
/* 539 */             setActualDeliveryDate((Date)value);
/* 540 */           } catch (Exception ee) {
/* 541 */             throw new DtxException("An exception occurred while calling setActualDeliveryDate() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "ExpectedShipDate":
/*     */           try {
/* 547 */             Object value = DaoUtils.getFieldValueForXmlString(91, fieldValue);
/* 548 */             setExpectedShipDate((Date)value);
/* 549 */           } catch (Exception ee) {
/* 550 */             throw new DtxException("An exception occurred while calling setExpectedShipDate() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "ActualShipDate":
/*     */           try {
/* 556 */             Object value = DaoUtils.getFieldValueForXmlString(91, fieldValue);
/* 557 */             setActualShipDate((Date)value);
/* 558 */           } catch (Exception ee) {
/* 559 */             throw new DtxException("An exception occurred while calling setActualShipDate() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "DestinationName":
/*     */           try {
/* 565 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 566 */             setDestinationName((String)value);
/* 567 */           } catch (Exception ee) {
/* 568 */             throw new DtxException("An exception occurred while calling setDestinationName() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "ShippingCarrier":
/*     */           try {
/* 574 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 575 */             setShippingCarrier((String)value);
/* 576 */           } catch (Exception ee) {
/* 577 */             throw new DtxException("An exception occurred while calling setShippingCarrier() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "TrackingNumber":
/*     */           try {
/* 583 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 584 */             setTrackingNumber((String)value);
/* 585 */           } catch (Exception ee) {
/* 586 */             throw new DtxException("An exception occurred while calling setTrackingNumber() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "ShipmentStatusCode":
/*     */           try {
/* 592 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 593 */             setShipmentStatusCode((String)value);
/* 594 */           } catch (Exception ee) {
/* 595 */             throw new DtxException("An exception occurred while calling setShipmentStatusCode() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "DestinationPartyId":
/*     */           try {
/* 601 */             Object value = DaoUtils.getFieldValueForXmlString(-5, fieldValue);
/* 602 */             setDestinationPartyId((Long)value);
/* 603 */           } catch (Exception ee) {
/* 604 */             throw new DtxException("An exception occurred while calling setDestinationPartyId() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "DestinationRetailLocationId":
/*     */           try {
/* 610 */             Object value = DaoUtils.getFieldValueForXmlString(-5, fieldValue);
/* 611 */             setDestinationRetailLocationId((Long)value);
/* 612 */           } catch (Exception ee) {
/* 613 */             throw new DtxException("An exception occurred while calling setDestinationRetailLocationId() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "RecordCreationType":
/*     */           try {
/* 619 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 620 */             setRecordCreationType((String)value);
/* 621 */           } catch (Exception ee) {
/* 622 */             throw new DtxException("An exception occurred while calling setRecordCreationType() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "ShippingMethod":
/*     */           try {
/* 628 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 629 */             setShippingMethod((String)value);
/* 630 */           } catch (Exception ee) {
/* 631 */             throw new DtxException("An exception occurred while calling setShippingMethod() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "ShippingLabel":
/*     */           try {
/* 637 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 638 */             setShippingLabel((String)value);
/* 639 */           } catch (Exception ee) {
/* 640 */             throw new DtxException("An exception occurred while calling setShippingLabel() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "DestinationType":
/*     */           try {
/* 646 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 647 */             setDestinationType((String)value);
/* 648 */           } catch (Exception ee) {
/* 649 */             throw new DtxException("An exception occurred while calling setDestinationType() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "DestinationServiceLocationId":
/*     */           try {
/* 655 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 656 */             setDestinationServiceLocationId((String)value);
/* 657 */           } catch (Exception ee) {
/* 658 */             throw new DtxException("An exception occurred while calling setDestinationServiceLocationId() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */       } 
/*     */     } 
/*     */   }
/*     */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\inv\impl\ShipmentDAO.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */