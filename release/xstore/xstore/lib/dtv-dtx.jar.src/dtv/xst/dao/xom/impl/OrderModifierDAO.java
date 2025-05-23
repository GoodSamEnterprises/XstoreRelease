/*     */ package dtv.xst.dao.xom.impl;
/*     */ 
/*     */ import dtv.data2.access.DaoUtils;
/*     */ import dtv.data2.access.IObjectId;
/*     */ import dtv.data2.access.exception.DtxException;
/*     */ import dtv.data2.access.impl.AbstractDAOImpl;
/*     */ import dtv.util.DtvDate;
/*     */ import dtv.xst.dao.xom.OrderModifierId;
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
/*     */ public class OrderModifierDAO
/*     */   extends AbstractDAOImpl
/*     */ {
/*     */   private static final long serialVersionUID = 2004742181L;
/*  23 */   private static final Logger _logger = Logger.getLogger(OrderModifierDAO.class);
/*     */   
/*     */   private Long _organizationId;
/*     */   private Long _retailLocationId;
/*     */   private DtvDate _businessDate;
/*     */   private Long _workstationId;
/*     */   private Long _transactionSequence;
/*     */   private Integer _retailTransactionLineItemSequence;
/*     */   private DtvDate _createDate;
/*     */   private String _createUserId;
/*     */   private DtvDate _updateDate;
/*     */   private String _updateUserId;
/*     */   private String _orderId;
/*     */   private String _externalOrderId;
/*     */   private String _orderType;
/*     */   private String _detailType;
/*     */   private Integer _detailSequence;
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
/*     */   public Long getRetailLocationId() {
/*  52 */     return this._retailLocationId;
/*     */   }
/*     */   
/*     */   public void setRetailLocationId(Long argRetailLocationId) {
/*  56 */     if (changed(argRetailLocationId, this._retailLocationId, "retailLocationId")) {
/*  57 */       this._retailLocationId = argRetailLocationId;
/*     */     }
/*     */   }
/*     */   
/*     */   public Date getBusinessDate() {
/*  62 */     return (Date)this._businessDate;
/*     */   }
/*     */   
/*     */   public void setBusinessDate(Date argBusinessDate) {
/*  66 */     if (changed(argBusinessDate, this._businessDate, "businessDate")) {
/*  67 */       this._businessDate = (argBusinessDate == null || argBusinessDate instanceof DtvDate) ? (DtvDate)argBusinessDate : new DtvDate(argBusinessDate);
/*     */     }
/*     */   }
/*     */ 
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
/*     */   public Long getTransactionSequence() {
/*  83 */     return this._transactionSequence;
/*     */   }
/*     */   
/*     */   public void setTransactionSequence(Long argTransactionSequence) {
/*  87 */     if (changed(argTransactionSequence, this._transactionSequence, "transactionSequence")) {
/*  88 */       this._transactionSequence = argTransactionSequence;
/*     */     }
/*     */   }
/*     */   
/*     */   public Integer getRetailTransactionLineItemSequence() {
/*  93 */     return this._retailTransactionLineItemSequence;
/*     */   }
/*     */   
/*     */   public void setRetailTransactionLineItemSequence(Integer argRetailTransactionLineItemSequence) {
/*  97 */     if (changed(argRetailTransactionLineItemSequence, this._retailTransactionLineItemSequence, "retailTransactionLineItemSequence")) {
/*  98 */       this._retailTransactionLineItemSequence = argRetailTransactionLineItemSequence;
/*     */     }
/*     */   }
/*     */   
/*     */   public Date getCreateDate() {
/* 103 */     return (Date)this._createDate;
/*     */   }
/*     */   
/*     */   public void setCreateDate(Date argCreateDate) {
/* 107 */     if (changed(argCreateDate, this._createDate, "createDate")) {
/* 108 */       this._createDate = (argCreateDate == null || argCreateDate instanceof DtvDate) ? (DtvDate)argCreateDate : new DtvDate(argCreateDate);
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public String getCreateUserId() {
/* 114 */     return this._createUserId;
/*     */   }
/*     */   
/*     */   public void setCreateUserId(String argCreateUserId) {
/* 118 */     if (changed(argCreateUserId, this._createUserId, "createUserId")) {
/* 119 */       this._createUserId = argCreateUserId;
/*     */     }
/*     */   }
/*     */   
/*     */   public Date getUpdateDate() {
/* 124 */     return (Date)this._updateDate;
/*     */   }
/*     */   
/*     */   public void setUpdateDate(Date argUpdateDate) {
/* 128 */     if (changed(argUpdateDate, this._updateDate, "updateDate")) {
/* 129 */       this._updateDate = (argUpdateDate == null || argUpdateDate instanceof DtvDate) ? (DtvDate)argUpdateDate : new DtvDate(argUpdateDate);
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public String getUpdateUserId() {
/* 135 */     return this._updateUserId;
/*     */   }
/*     */   
/*     */   public void setUpdateUserId(String argUpdateUserId) {
/* 139 */     if (changed(argUpdateUserId, this._updateUserId, "updateUserId")) {
/* 140 */       this._updateUserId = argUpdateUserId;
/*     */     }
/*     */   }
/*     */   
/*     */   public String getOrderId() {
/* 145 */     return this._orderId;
/*     */   }
/*     */   
/*     */   public void setOrderId(String argOrderId) {
/* 149 */     if (changed(argOrderId, this._orderId, "orderId")) {
/* 150 */       this._orderId = argOrderId;
/*     */     }
/*     */   }
/*     */   
/*     */   public String getExternalOrderId() {
/* 155 */     return this._externalOrderId;
/*     */   }
/*     */   
/*     */   public void setExternalOrderId(String argExternalOrderId) {
/* 159 */     if (changed(argExternalOrderId, this._externalOrderId, "externalOrderId")) {
/* 160 */       this._externalOrderId = argExternalOrderId;
/*     */     }
/*     */   }
/*     */   
/*     */   public String getOrderType() {
/* 165 */     return this._orderType;
/*     */   }
/*     */   
/*     */   public void setOrderType(String argOrderType) {
/* 169 */     if (changed(argOrderType, this._orderType, "orderType")) {
/* 170 */       this._orderType = argOrderType;
/*     */     }
/*     */   }
/*     */   
/*     */   public String getDetailType() {
/* 175 */     return this._detailType;
/*     */   }
/*     */   
/*     */   public void setDetailType(String argDetailType) {
/* 179 */     if (changed(argDetailType, this._detailType, "detailType")) {
/* 180 */       this._detailType = argDetailType;
/*     */     }
/*     */   }
/*     */   
/*     */   public Integer getDetailSequence() {
/* 185 */     return this._detailSequence;
/*     */   }
/*     */   
/*     */   public void setDetailSequence(Integer argDetailSequence) {
/* 189 */     if (changed(argDetailSequence, this._detailSequence, "detailSequence")) {
/* 190 */       this._detailSequence = argDetailSequence;
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
/* 202 */     if (getRetailLocationId() != null) {
/* 203 */       buf.append("retailLocationId").append("=").append(getRetailLocationId()).append(" ");
/*     */     }
/* 205 */     if (getBusinessDate() != null) {
/* 206 */       buf.append("businessDate").append("=").append(getBusinessDate()).append(" ");
/*     */     }
/* 208 */     if (getWorkstationId() != null) {
/* 209 */       buf.append("workstationId").append("=").append(getWorkstationId()).append(" ");
/*     */     }
/* 211 */     if (getTransactionSequence() != null) {
/* 212 */       buf.append("transactionSequence").append("=").append(getTransactionSequence()).append(" ");
/*     */     }
/* 214 */     if (getRetailTransactionLineItemSequence() != null) {
/* 215 */       buf.append("retailTransactionLineItemSequence").append("=").append(getRetailTransactionLineItemSequence()).append(" ");
/*     */     }
/* 217 */     if (getCreateDate() != null) {
/* 218 */       buf.append("createDate").append("=").append(getCreateDate()).append(" ");
/*     */     }
/* 220 */     if (getCreateUserId() != null) {
/* 221 */       buf.append("createUserId").append("=").append(getCreateUserId()).append(" ");
/*     */     }
/* 223 */     if (getUpdateDate() != null) {
/* 224 */       buf.append("updateDate").append("=").append(getUpdateDate()).append(" ");
/*     */     }
/* 226 */     if (getUpdateUserId() != null) {
/* 227 */       buf.append("updateUserId").append("=").append(getUpdateUserId()).append(" ");
/*     */     }
/* 229 */     if (getOrderId() != null) {
/* 230 */       buf.append("orderId").append("=").append(getOrderId()).append(" ");
/*     */     }
/* 232 */     if (getExternalOrderId() != null) {
/* 233 */       buf.append("externalOrderId").append("=").append(getExternalOrderId()).append(" ");
/*     */     }
/* 235 */     if (getOrderType() != null) {
/* 236 */       buf.append("orderType").append("=").append(getOrderType()).append(" ");
/*     */     }
/* 238 */     if (getDetailType() != null) {
/* 239 */       buf.append("detailType").append("=").append(getDetailType()).append(" ");
/*     */     }
/* 241 */     if (getDetailSequence() != null) {
/* 242 */       buf.append("detailSequence").append("=").append(getDetailSequence()).append(" ");
/*     */     }
/*     */     
/* 245 */     return buf.toString();
/*     */   }
/*     */   
/*     */   public IObjectId getObjectId() {
/* 249 */     OrderModifierId id = new OrderModifierId();
/* 250 */     id.setOrganizationId(getOrganizationId());
/* 251 */     id.setRetailLocationId(getRetailLocationId());
/* 252 */     id.setBusinessDate(getBusinessDate());
/* 253 */     id.setWorkstationId(getWorkstationId());
/* 254 */     id.setTransactionSequence(getTransactionSequence());
/* 255 */     id.setRetailTransactionLineItemSequence(getRetailTransactionLineItemSequence());
/* 256 */     return (IObjectId)id;
/*     */   }
/*     */   
/*     */   public void setObjectId(IObjectId argObjectId) {
/* 260 */     setOrganizationId(((OrderModifierId)argObjectId).getOrganizationId());
/* 261 */     setRetailLocationId(((OrderModifierId)argObjectId).getRetailLocationId());
/* 262 */     setBusinessDate(((OrderModifierId)argObjectId).getBusinessDate());
/* 263 */     setWorkstationId(((OrderModifierId)argObjectId).getWorkstationId());
/* 264 */     setTransactionSequence(((OrderModifierId)argObjectId).getTransactionSequence());
/* 265 */     setRetailTransactionLineItemSequence(((OrderModifierId)argObjectId).getRetailTransactionLineItemSequence());
/*     */   }
/*     */   
/*     */   public String getImplementingClass() {
/* 269 */     return null;
/*     */   }
/*     */   
/*     */   public String toXmlString() {
/* 273 */     StringBuilder buf = new StringBuilder(750);
/* 274 */     buf.append("<").append("dao").append(" name=\"OrderModifier\" cmd=\"" + getObjectStateString() + "\">");
/* 275 */     getFieldsAsXml(buf);
/* 276 */     buf.append("</").append("dao").append(">");
/*     */     
/* 278 */     return buf.toString();
/*     */   }
/*     */   
/*     */   public Map<String, String> getValues() {
/* 282 */     Map<String, String> values = super.getValues();
/* 283 */     if (this._organizationId != null) values.put("OrganizationId", DaoUtils.getXmlSafeFieldValue(-5, this._organizationId)); 
/* 284 */     if (this._retailLocationId != null) values.put("RetailLocationId", DaoUtils.getXmlSafeFieldValue(-5, this._retailLocationId)); 
/* 285 */     if (this._businessDate != null) values.put("BusinessDate", DaoUtils.getXmlSafeFieldValue(91, this._businessDate)); 
/* 286 */     if (this._workstationId != null) values.put("WorkstationId", DaoUtils.getXmlSafeFieldValue(-5, this._workstationId)); 
/* 287 */     if (this._transactionSequence != null) values.put("TransactionSequence", DaoUtils.getXmlSafeFieldValue(-5, this._transactionSequence)); 
/* 288 */     if (this._retailTransactionLineItemSequence != null) values.put("RetailTransactionLineItemSequence", DaoUtils.getXmlSafeFieldValue(4, this._retailTransactionLineItemSequence)); 
/* 289 */     if (this._createDate != null) values.put("CreateDate", DaoUtils.getXmlSafeFieldValue(91, this._createDate)); 
/* 290 */     if (this._createUserId != null) values.put("CreateUserId", DaoUtils.getXmlSafeFieldValue(12, this._createUserId)); 
/* 291 */     if (this._updateDate != null) values.put("UpdateDate", DaoUtils.getXmlSafeFieldValue(91, this._updateDate)); 
/* 292 */     if (this._updateUserId != null) values.put("UpdateUserId", DaoUtils.getXmlSafeFieldValue(12, this._updateUserId)); 
/* 293 */     if (this._orderId != null) values.put("OrderId", DaoUtils.getXmlSafeFieldValue(12, this._orderId)); 
/* 294 */     if (this._externalOrderId != null) values.put("ExternalOrderId", DaoUtils.getXmlSafeFieldValue(12, this._externalOrderId)); 
/* 295 */     if (this._orderType != null) values.put("OrderType", DaoUtils.getXmlSafeFieldValue(12, this._orderType)); 
/* 296 */     if (this._detailType != null) values.put("DetailType", DaoUtils.getXmlSafeFieldValue(12, this._detailType)); 
/* 297 */     if (this._detailSequence != null) values.put("DetailSequence", DaoUtils.getXmlSafeFieldValue(4, this._detailSequence)); 
/* 298 */     return values;
/*     */   }
/*     */ 
/*     */   
/*     */   public void setValues(Map<String, String> argValues) {
/* 303 */     super.setValues(argValues);
/* 304 */     for (Map.Entry<String, String> field : argValues.entrySet()) {
/*     */       
/* 306 */       String fieldName = field.getKey();
/* 307 */       String fieldValue = field.getValue();
/* 308 */       switch (fieldName) {
/*     */         
/*     */         case "OrganizationId":
/*     */           try {
/* 312 */             Object value = DaoUtils.getFieldValueForXmlString(-5, fieldValue);
/* 313 */             setOrganizationId((Long)value);
/* 314 */           } catch (Exception ee) {
/* 315 */             throw new DtxException("An exception occurred while calling setOrganizationId() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "RetailLocationId":
/*     */           try {
/* 321 */             Object value = DaoUtils.getFieldValueForXmlString(-5, fieldValue);
/* 322 */             setRetailLocationId((Long)value);
/* 323 */           } catch (Exception ee) {
/* 324 */             throw new DtxException("An exception occurred while calling setRetailLocationId() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "BusinessDate":
/*     */           try {
/* 330 */             Object value = DaoUtils.getFieldValueForXmlString(91, fieldValue);
/* 331 */             setBusinessDate((Date)value);
/* 332 */           } catch (Exception ee) {
/* 333 */             throw new DtxException("An exception occurred while calling setBusinessDate() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "WorkstationId":
/*     */           try {
/* 339 */             Object value = DaoUtils.getFieldValueForXmlString(-5, fieldValue);
/* 340 */             setWorkstationId((Long)value);
/* 341 */           } catch (Exception ee) {
/* 342 */             throw new DtxException("An exception occurred while calling setWorkstationId() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "TransactionSequence":
/*     */           try {
/* 348 */             Object value = DaoUtils.getFieldValueForXmlString(-5, fieldValue);
/* 349 */             setTransactionSequence((Long)value);
/* 350 */           } catch (Exception ee) {
/* 351 */             throw new DtxException("An exception occurred while calling setTransactionSequence() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "RetailTransactionLineItemSequence":
/*     */           try {
/* 357 */             Object value = DaoUtils.getFieldValueForXmlString(4, fieldValue);
/* 358 */             setRetailTransactionLineItemSequence((Integer)value);
/* 359 */           } catch (Exception ee) {
/* 360 */             throw new DtxException("An exception occurred while calling setRetailTransactionLineItemSequence() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "CreateDate":
/*     */           try {
/* 366 */             Object value = DaoUtils.getFieldValueForXmlString(91, fieldValue);
/* 367 */             setCreateDate((Date)value);
/* 368 */           } catch (Exception ee) {
/* 369 */             throw new DtxException("An exception occurred while calling setCreateDate() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "CreateUserId":
/*     */           try {
/* 375 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 376 */             setCreateUserId((String)value);
/* 377 */           } catch (Exception ee) {
/* 378 */             throw new DtxException("An exception occurred while calling setCreateUserId() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "UpdateDate":
/*     */           try {
/* 384 */             Object value = DaoUtils.getFieldValueForXmlString(91, fieldValue);
/* 385 */             setUpdateDate((Date)value);
/* 386 */           } catch (Exception ee) {
/* 387 */             throw new DtxException("An exception occurred while calling setUpdateDate() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "UpdateUserId":
/*     */           try {
/* 393 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 394 */             setUpdateUserId((String)value);
/* 395 */           } catch (Exception ee) {
/* 396 */             throw new DtxException("An exception occurred while calling setUpdateUserId() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "OrderId":
/*     */           try {
/* 402 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 403 */             setOrderId((String)value);
/* 404 */           } catch (Exception ee) {
/* 405 */             throw new DtxException("An exception occurred while calling setOrderId() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "ExternalOrderId":
/*     */           try {
/* 411 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 412 */             setExternalOrderId((String)value);
/* 413 */           } catch (Exception ee) {
/* 414 */             throw new DtxException("An exception occurred while calling setExternalOrderId() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "OrderType":
/*     */           try {
/* 420 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 421 */             setOrderType((String)value);
/* 422 */           } catch (Exception ee) {
/* 423 */             throw new DtxException("An exception occurred while calling setOrderType() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "DetailType":
/*     */           try {
/* 429 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 430 */             setDetailType((String)value);
/* 431 */           } catch (Exception ee) {
/* 432 */             throw new DtxException("An exception occurred while calling setDetailType() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "DetailSequence":
/*     */           try {
/* 438 */             Object value = DaoUtils.getFieldValueForXmlString(4, fieldValue);
/* 439 */             setDetailSequence((Integer)value);
/* 440 */           } catch (Exception ee) {
/* 441 */             throw new DtxException("An exception occurred while calling setDetailSequence() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */       } 
/*     */     } 
/*     */   }
/*     */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\xom\impl\OrderModifierDAO.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */