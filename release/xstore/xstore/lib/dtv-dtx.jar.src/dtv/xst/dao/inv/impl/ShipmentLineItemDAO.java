/*     */ package dtv.xst.dao.inv.impl;
/*     */ 
/*     */ import dtv.data2.access.DaoUtils;
/*     */ import dtv.data2.access.IObjectId;
/*     */ import dtv.data2.access.exception.DtxException;
/*     */ import dtv.data2.access.impl.AbstractDAOImpl;
/*     */ import dtv.util.DtvDate;
/*     */ import dtv.xst.dao.inv.ShipmentLineItemId;
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
/*     */ public class ShipmentLineItemDAO
/*     */   extends AbstractDAOImpl
/*     */ {
/*     */   private static final long serialVersionUID = 383149313L;
/*  23 */   private static final Logger _logger = Logger.getLogger(ShipmentLineItemDAO.class);
/*     */   
/*     */   private Long _organizationId;
/*     */   private Long _retailLocationId;
/*     */   private String _documentId;
/*     */   private String _documentTypeCode;
/*     */   private Integer _shipmentSequence;
/*     */   private Integer _lineItemSequence;
/*     */   private DtvDate _createDate;
/*     */   private String _createUserId;
/*     */   private DtvDate _updateDate;
/*     */   private String _updateUserId;
/*     */   private Integer _inventoryDocumentLineNumber;
/*     */   private BigDecimal _shipQuantity;
/*     */   private String _cartonId;
/*     */   private String _statusCode;
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
/*     */   public String getDocumentId() {
/*  61 */     return this._documentId;
/*     */   }
/*     */   
/*     */   public void setDocumentId(String argDocumentId) {
/*  65 */     if (changed(argDocumentId, this._documentId, "documentId")) {
/*  66 */       this._documentId = (argDocumentId != null && MANAGE_CASE) ? argDocumentId.toUpperCase() : argDocumentId;
/*     */     }
/*     */   }
/*     */   
/*     */   public String getDocumentTypeCode() {
/*  71 */     return this._documentTypeCode;
/*     */   }
/*     */   
/*     */   public void setDocumentTypeCode(String argDocumentTypeCode) {
/*  75 */     if (changed(argDocumentTypeCode, this._documentTypeCode, "documentTypeCode")) {
/*  76 */       this._documentTypeCode = (argDocumentTypeCode != null && MANAGE_CASE) ? argDocumentTypeCode.toUpperCase() : argDocumentTypeCode;
/*     */     }
/*     */   }
/*     */   
/*     */   public Integer getShipmentSequence() {
/*  81 */     return this._shipmentSequence;
/*     */   }
/*     */   
/*     */   public void setShipmentSequence(Integer argShipmentSequence) {
/*  85 */     if (changed(argShipmentSequence, this._shipmentSequence, "shipmentSequence")) {
/*  86 */       this._shipmentSequence = argShipmentSequence;
/*     */     }
/*     */   }
/*     */   
/*     */   public Integer getLineItemSequence() {
/*  91 */     return this._lineItemSequence;
/*     */   }
/*     */   
/*     */   public void setLineItemSequence(Integer argLineItemSequence) {
/*  95 */     if (changed(argLineItemSequence, this._lineItemSequence, "lineItemSequence")) {
/*  96 */       this._lineItemSequence = argLineItemSequence;
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
/*     */   public Integer getInventoryDocumentLineNumber() {
/* 143 */     return this._inventoryDocumentLineNumber;
/*     */   }
/*     */   
/*     */   public void setInventoryDocumentLineNumber(Integer argInventoryDocumentLineNumber) {
/* 147 */     if (changed(argInventoryDocumentLineNumber, this._inventoryDocumentLineNumber, "inventoryDocumentLineNumber")) {
/* 148 */       this._inventoryDocumentLineNumber = argInventoryDocumentLineNumber;
/*     */     }
/*     */   }
/*     */   
/*     */   public BigDecimal getShipQuantity() {
/* 153 */     return this._shipQuantity;
/*     */   }
/*     */   
/*     */   public void setShipQuantity(BigDecimal argShipQuantity) {
/* 157 */     if (changed(argShipQuantity, this._shipQuantity, "shipQuantity")) {
/* 158 */       this._shipQuantity = argShipQuantity;
/*     */     }
/*     */   }
/*     */   
/*     */   public String getCartonId() {
/* 163 */     return this._cartonId;
/*     */   }
/*     */   
/*     */   public void setCartonId(String argCartonId) {
/* 167 */     if (changed(argCartonId, this._cartonId, "cartonId")) {
/* 168 */       this._cartonId = argCartonId;
/*     */     }
/*     */   }
/*     */   
/*     */   public String getStatusCode() {
/* 173 */     return this._statusCode;
/*     */   }
/*     */   
/*     */   public void setStatusCode(String argStatusCode) {
/* 177 */     if (changed(argStatusCode, this._statusCode, "statusCode")) {
/* 178 */       this._statusCode = argStatusCode;
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public String toString() {
/* 185 */     StringBuilder buf = new StringBuilder(512);
/* 186 */     buf.append(super.toString()).append(" Id: ").append(getObjectId()).append(" Values: ");
/* 187 */     if (getOrganizationId() != null) {
/* 188 */       buf.append("organizationId").append("=").append(getOrganizationId()).append(" ");
/*     */     }
/* 190 */     if (getRetailLocationId() != null) {
/* 191 */       buf.append("retailLocationId").append("=").append(getRetailLocationId()).append(" ");
/*     */     }
/* 193 */     if (getDocumentId() != null) {
/* 194 */       buf.append("documentId").append("=").append(getDocumentId()).append(" ");
/*     */     }
/* 196 */     if (getDocumentTypeCode() != null) {
/* 197 */       buf.append("documentTypeCode").append("=").append(getDocumentTypeCode()).append(" ");
/*     */     }
/* 199 */     if (getShipmentSequence() != null) {
/* 200 */       buf.append("shipmentSequence").append("=").append(getShipmentSequence()).append(" ");
/*     */     }
/* 202 */     if (getLineItemSequence() != null) {
/* 203 */       buf.append("lineItemSequence").append("=").append(getLineItemSequence()).append(" ");
/*     */     }
/* 205 */     if (getCreateDate() != null) {
/* 206 */       buf.append("createDate").append("=").append(getCreateDate()).append(" ");
/*     */     }
/* 208 */     if (getCreateUserId() != null) {
/* 209 */       buf.append("createUserId").append("=").append(getCreateUserId()).append(" ");
/*     */     }
/* 211 */     if (getUpdateDate() != null) {
/* 212 */       buf.append("updateDate").append("=").append(getUpdateDate()).append(" ");
/*     */     }
/* 214 */     if (getUpdateUserId() != null) {
/* 215 */       buf.append("updateUserId").append("=").append(getUpdateUserId()).append(" ");
/*     */     }
/* 217 */     if (getInventoryDocumentLineNumber() != null) {
/* 218 */       buf.append("inventoryDocumentLineNumber").append("=").append(getInventoryDocumentLineNumber()).append(" ");
/*     */     }
/* 220 */     if (getShipQuantity() != null) {
/* 221 */       buf.append("shipQuantity").append("=").append(getShipQuantity()).append(" ");
/*     */     }
/* 223 */     if (getCartonId() != null) {
/* 224 */       buf.append("cartonId").append("=").append(getCartonId()).append(" ");
/*     */     }
/* 226 */     if (getStatusCode() != null) {
/* 227 */       buf.append("statusCode").append("=").append(getStatusCode()).append(" ");
/*     */     }
/*     */     
/* 230 */     return buf.toString();
/*     */   }
/*     */   
/*     */   public IObjectId getObjectId() {
/* 234 */     ShipmentLineItemId id = new ShipmentLineItemId();
/* 235 */     id.setOrganizationId(getOrganizationId());
/* 236 */     id.setRetailLocationId(getRetailLocationId());
/* 237 */     id.setDocumentId(getDocumentId());
/* 238 */     id.setDocumentTypeCode(getDocumentTypeCode());
/* 239 */     id.setShipmentSequence(getShipmentSequence());
/* 240 */     id.setLineItemSequence(getLineItemSequence());
/* 241 */     return (IObjectId)id;
/*     */   }
/*     */   
/*     */   public void setObjectId(IObjectId argObjectId) {
/* 245 */     setOrganizationId(((ShipmentLineItemId)argObjectId).getOrganizationId());
/* 246 */     setRetailLocationId(((ShipmentLineItemId)argObjectId).getRetailLocationId());
/* 247 */     setDocumentId(((ShipmentLineItemId)argObjectId).getDocumentId());
/* 248 */     setDocumentTypeCode(((ShipmentLineItemId)argObjectId).getDocumentTypeCode());
/* 249 */     setShipmentSequence(((ShipmentLineItemId)argObjectId).getShipmentSequence());
/* 250 */     setLineItemSequence(((ShipmentLineItemId)argObjectId).getLineItemSequence());
/*     */   }
/*     */   
/*     */   public String getImplementingClass() {
/* 254 */     return null;
/*     */   }
/*     */   
/*     */   public String toXmlString() {
/* 258 */     StringBuilder buf = new StringBuilder(700);
/* 259 */     buf.append("<").append("dao").append(" name=\"ShipmentLineItem\" cmd=\"" + getObjectStateString() + "\">");
/* 260 */     getFieldsAsXml(buf);
/* 261 */     buf.append("</").append("dao").append(">");
/*     */     
/* 263 */     return buf.toString();
/*     */   }
/*     */   
/*     */   public Map<String, String> getValues() {
/* 267 */     Map<String, String> values = super.getValues();
/* 268 */     if (this._organizationId != null) values.put("OrganizationId", DaoUtils.getXmlSafeFieldValue(-5, this._organizationId)); 
/* 269 */     if (this._retailLocationId != null) values.put("RetailLocationId", DaoUtils.getXmlSafeFieldValue(-5, this._retailLocationId)); 
/* 270 */     if (this._documentId != null) values.put("DocumentId", DaoUtils.getXmlSafeFieldValue(12, this._documentId)); 
/* 271 */     if (this._documentTypeCode != null) values.put("DocumentTypeCode", DaoUtils.getXmlSafeFieldValue(12, this._documentTypeCode)); 
/* 272 */     if (this._shipmentSequence != null) values.put("ShipmentSequence", DaoUtils.getXmlSafeFieldValue(4, this._shipmentSequence)); 
/* 273 */     if (this._lineItemSequence != null) values.put("LineItemSequence", DaoUtils.getXmlSafeFieldValue(4, this._lineItemSequence)); 
/* 274 */     if (this._createDate != null) values.put("CreateDate", DaoUtils.getXmlSafeFieldValue(91, this._createDate)); 
/* 275 */     if (this._createUserId != null) values.put("CreateUserId", DaoUtils.getXmlSafeFieldValue(12, this._createUserId)); 
/* 276 */     if (this._updateDate != null) values.put("UpdateDate", DaoUtils.getXmlSafeFieldValue(91, this._updateDate)); 
/* 277 */     if (this._updateUserId != null) values.put("UpdateUserId", DaoUtils.getXmlSafeFieldValue(12, this._updateUserId)); 
/* 278 */     if (this._inventoryDocumentLineNumber != null) values.put("InventoryDocumentLineNumber", DaoUtils.getXmlSafeFieldValue(4, this._inventoryDocumentLineNumber)); 
/* 279 */     if (this._shipQuantity != null) values.put("ShipQuantity", DaoUtils.getXmlSafeFieldValue(3, this._shipQuantity)); 
/* 280 */     if (this._cartonId != null) values.put("CartonId", DaoUtils.getXmlSafeFieldValue(12, this._cartonId)); 
/* 281 */     if (this._statusCode != null) values.put("StatusCode", DaoUtils.getXmlSafeFieldValue(12, this._statusCode)); 
/* 282 */     return values;
/*     */   }
/*     */ 
/*     */   
/*     */   public void setValues(Map<String, String> argValues) {
/* 287 */     super.setValues(argValues);
/* 288 */     for (Map.Entry<String, String> field : argValues.entrySet()) {
/*     */       
/* 290 */       String fieldName = field.getKey();
/* 291 */       String fieldValue = field.getValue();
/* 292 */       switch (fieldName) {
/*     */         
/*     */         case "OrganizationId":
/*     */           try {
/* 296 */             Object value = DaoUtils.getFieldValueForXmlString(-5, fieldValue);
/* 297 */             setOrganizationId((Long)value);
/* 298 */           } catch (Exception ee) {
/* 299 */             throw new DtxException("An exception occurred while calling setOrganizationId() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "RetailLocationId":
/*     */           try {
/* 305 */             Object value = DaoUtils.getFieldValueForXmlString(-5, fieldValue);
/* 306 */             setRetailLocationId((Long)value);
/* 307 */           } catch (Exception ee) {
/* 308 */             throw new DtxException("An exception occurred while calling setRetailLocationId() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "DocumentId":
/*     */           try {
/* 314 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 315 */             setDocumentId((String)value);
/* 316 */           } catch (Exception ee) {
/* 317 */             throw new DtxException("An exception occurred while calling setDocumentId() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "DocumentTypeCode":
/*     */           try {
/* 323 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 324 */             setDocumentTypeCode((String)value);
/* 325 */           } catch (Exception ee) {
/* 326 */             throw new DtxException("An exception occurred while calling setDocumentTypeCode() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "ShipmentSequence":
/*     */           try {
/* 332 */             Object value = DaoUtils.getFieldValueForXmlString(4, fieldValue);
/* 333 */             setShipmentSequence((Integer)value);
/* 334 */           } catch (Exception ee) {
/* 335 */             throw new DtxException("An exception occurred while calling setShipmentSequence() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "LineItemSequence":
/*     */           try {
/* 341 */             Object value = DaoUtils.getFieldValueForXmlString(4, fieldValue);
/* 342 */             setLineItemSequence((Integer)value);
/* 343 */           } catch (Exception ee) {
/* 344 */             throw new DtxException("An exception occurred while calling setLineItemSequence() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "CreateDate":
/*     */           try {
/* 350 */             Object value = DaoUtils.getFieldValueForXmlString(91, fieldValue);
/* 351 */             setCreateDate((Date)value);
/* 352 */           } catch (Exception ee) {
/* 353 */             throw new DtxException("An exception occurred while calling setCreateDate() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "CreateUserId":
/*     */           try {
/* 359 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 360 */             setCreateUserId((String)value);
/* 361 */           } catch (Exception ee) {
/* 362 */             throw new DtxException("An exception occurred while calling setCreateUserId() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "UpdateDate":
/*     */           try {
/* 368 */             Object value = DaoUtils.getFieldValueForXmlString(91, fieldValue);
/* 369 */             setUpdateDate((Date)value);
/* 370 */           } catch (Exception ee) {
/* 371 */             throw new DtxException("An exception occurred while calling setUpdateDate() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "UpdateUserId":
/*     */           try {
/* 377 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 378 */             setUpdateUserId((String)value);
/* 379 */           } catch (Exception ee) {
/* 380 */             throw new DtxException("An exception occurred while calling setUpdateUserId() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "InventoryDocumentLineNumber":
/*     */           try {
/* 386 */             Object value = DaoUtils.getFieldValueForXmlString(4, fieldValue);
/* 387 */             setInventoryDocumentLineNumber((Integer)value);
/* 388 */           } catch (Exception ee) {
/* 389 */             throw new DtxException("An exception occurred while calling setInventoryDocumentLineNumber() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "ShipQuantity":
/*     */           try {
/* 395 */             Object value = DaoUtils.getFieldValueForXmlString(3, fieldValue);
/* 396 */             setShipQuantity((BigDecimal)value);
/* 397 */           } catch (Exception ee) {
/* 398 */             throw new DtxException("An exception occurred while calling setShipQuantity() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "CartonId":
/*     */           try {
/* 404 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 405 */             setCartonId((String)value);
/* 406 */           } catch (Exception ee) {
/* 407 */             throw new DtxException("An exception occurred while calling setCartonId() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "StatusCode":
/*     */           try {
/* 413 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 414 */             setStatusCode((String)value);
/* 415 */           } catch (Exception ee) {
/* 416 */             throw new DtxException("An exception occurred while calling setStatusCode() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */       } 
/*     */     } 
/*     */   }
/*     */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\inv\impl\ShipmentLineItemDAO.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */