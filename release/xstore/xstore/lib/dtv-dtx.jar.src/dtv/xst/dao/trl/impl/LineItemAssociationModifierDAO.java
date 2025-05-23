/*     */ package dtv.xst.dao.trl.impl;
/*     */ 
/*     */ import dtv.data2.access.DaoUtils;
/*     */ import dtv.data2.access.IObjectId;
/*     */ import dtv.data2.access.exception.DtxException;
/*     */ import dtv.data2.access.impl.AbstractDAOImpl;
/*     */ import dtv.util.DtvDate;
/*     */ import dtv.xst.dao.trl.LineItemAssociationModifierId;
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
/*     */ public class LineItemAssociationModifierDAO
/*     */   extends AbstractDAOImpl
/*     */ {
/*     */   private static final long serialVersionUID = 387442097L;
/*  23 */   private static final Logger _logger = Logger.getLogger(LineItemAssociationModifierDAO.class);
/*     */   
/*     */   private DtvDate _businessDate;
/*     */   private Integer _lineItemAssociationModifierSequence;
/*     */   private Long _organizationId;
/*     */   private Long _retailLocationId;
/*     */   private Integer _retailTransactionLineItemSequence;
/*     */   private Long _transactionSequence;
/*     */   private Long _workstationId;
/*     */   private DtvDate _createDate;
/*     */   private String _createUserId;
/*     */   private DtvDate _updateDate;
/*     */   private String _updateUserId;
/*     */   private DtvDate _childBusinessDate;
/*     */   private Long _childRetailLocationId;
/*     */   private Integer _childRetailTransactionLineItemSequence;
/*     */   private Long _childTransactionSequence;
/*     */   private Long _childWorkstationId;
/*     */   private String _lineItemAssociationTypeCodeString;
/*     */   
/*     */   public Date getBusinessDate() {
/*  44 */     return (Date)this._businessDate;
/*     */   }
/*     */   
/*     */   public void setBusinessDate(Date argBusinessDate) {
/*  48 */     if (changed(argBusinessDate, this._businessDate, "businessDate")) {
/*  49 */       this._businessDate = (argBusinessDate == null || argBusinessDate instanceof DtvDate) ? (DtvDate)argBusinessDate : new DtvDate(argBusinessDate);
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public Integer getLineItemAssociationModifierSequence() {
/*  55 */     return this._lineItemAssociationModifierSequence;
/*     */   }
/*     */   
/*     */   public void setLineItemAssociationModifierSequence(Integer argLineItemAssociationModifierSequence) {
/*  59 */     if (changed(argLineItemAssociationModifierSequence, this._lineItemAssociationModifierSequence, "lineItemAssociationModifierSequence")) {
/*  60 */       this._lineItemAssociationModifierSequence = argLineItemAssociationModifierSequence;
/*     */     }
/*     */   }
/*     */   
/*     */   public Long getOrganizationId() {
/*  65 */     return this._organizationId;
/*     */   }
/*     */   
/*     */   public void setOrganizationId(Long argOrganizationId) {
/*  69 */     if (changed(argOrganizationId, this._organizationId, "organizationId")) {
/*  70 */       this._organizationId = argOrganizationId;
/*     */     }
/*     */   }
/*     */   
/*     */   public Long getRetailLocationId() {
/*  75 */     return this._retailLocationId;
/*     */   }
/*     */   
/*     */   public void setRetailLocationId(Long argRetailLocationId) {
/*  79 */     if (changed(argRetailLocationId, this._retailLocationId, "retailLocationId")) {
/*  80 */       this._retailLocationId = argRetailLocationId;
/*     */     }
/*     */   }
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
/*     */   public Long getWorkstationId() {
/* 105 */     return this._workstationId;
/*     */   }
/*     */   
/*     */   public void setWorkstationId(Long argWorkstationId) {
/* 109 */     if (changed(argWorkstationId, this._workstationId, "workstationId")) {
/* 110 */       this._workstationId = argWorkstationId;
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
/*     */   public Date getChildBusinessDate() {
/* 157 */     return (Date)this._childBusinessDate;
/*     */   }
/*     */   
/*     */   public void setChildBusinessDate(Date argChildBusinessDate) {
/* 161 */     if (changed(argChildBusinessDate, this._childBusinessDate, "childBusinessDate")) {
/* 162 */       this._childBusinessDate = (argChildBusinessDate == null || argChildBusinessDate instanceof DtvDate) ? (DtvDate)argChildBusinessDate : new DtvDate(argChildBusinessDate);
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public Long getChildRetailLocationId() {
/* 168 */     return this._childRetailLocationId;
/*     */   }
/*     */   
/*     */   public void setChildRetailLocationId(Long argChildRetailLocationId) {
/* 172 */     if (changed(argChildRetailLocationId, this._childRetailLocationId, "childRetailLocationId")) {
/* 173 */       this._childRetailLocationId = argChildRetailLocationId;
/*     */     }
/*     */   }
/*     */   
/*     */   public Integer getChildRetailTransactionLineItemSequence() {
/* 178 */     return this._childRetailTransactionLineItemSequence;
/*     */   }
/*     */   
/*     */   public void setChildRetailTransactionLineItemSequence(Integer argChildRetailTransactionLineItemSequence) {
/* 182 */     if (changed(argChildRetailTransactionLineItemSequence, this._childRetailTransactionLineItemSequence, "childRetailTransactionLineItemSequence")) {
/* 183 */       this._childRetailTransactionLineItemSequence = argChildRetailTransactionLineItemSequence;
/*     */     }
/*     */   }
/*     */   
/*     */   public Long getChildTransactionSequence() {
/* 188 */     return this._childTransactionSequence;
/*     */   }
/*     */   
/*     */   public void setChildTransactionSequence(Long argChildTransactionSequence) {
/* 192 */     if (changed(argChildTransactionSequence, this._childTransactionSequence, "childTransactionSequence")) {
/* 193 */       this._childTransactionSequence = argChildTransactionSequence;
/*     */     }
/*     */   }
/*     */   
/*     */   public Long getChildWorkstationId() {
/* 198 */     return this._childWorkstationId;
/*     */   }
/*     */   
/*     */   public void setChildWorkstationId(Long argChildWorkstationId) {
/* 202 */     if (changed(argChildWorkstationId, this._childWorkstationId, "childWorkstationId")) {
/* 203 */       this._childWorkstationId = argChildWorkstationId;
/*     */     }
/*     */   }
/*     */   
/*     */   public String getLineItemAssociationTypeCodeString() {
/* 208 */     return this._lineItemAssociationTypeCodeString;
/*     */   }
/*     */   
/*     */   public void setLineItemAssociationTypeCodeString(String argLineItemAssociationTypeCodeString) {
/* 212 */     if (changed(argLineItemAssociationTypeCodeString, this._lineItemAssociationTypeCodeString, "lineItemAssociationTypeCodeString")) {
/* 213 */       this._lineItemAssociationTypeCodeString = argLineItemAssociationTypeCodeString;
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public String toString() {
/* 220 */     StringBuilder buf = new StringBuilder(512);
/* 221 */     buf.append(super.toString()).append(" Id: ").append(getObjectId()).append(" Values: ");
/* 222 */     if (getBusinessDate() != null) {
/* 223 */       buf.append("businessDate").append("=").append(getBusinessDate()).append(" ");
/*     */     }
/* 225 */     if (getLineItemAssociationModifierSequence() != null) {
/* 226 */       buf.append("lineItemAssociationModifierSequence").append("=").append(getLineItemAssociationModifierSequence()).append(" ");
/*     */     }
/* 228 */     if (getOrganizationId() != null) {
/* 229 */       buf.append("organizationId").append("=").append(getOrganizationId()).append(" ");
/*     */     }
/* 231 */     if (getRetailLocationId() != null) {
/* 232 */       buf.append("retailLocationId").append("=").append(getRetailLocationId()).append(" ");
/*     */     }
/* 234 */     if (getRetailTransactionLineItemSequence() != null) {
/* 235 */       buf.append("retailTransactionLineItemSequence").append("=").append(getRetailTransactionLineItemSequence()).append(" ");
/*     */     }
/* 237 */     if (getTransactionSequence() != null) {
/* 238 */       buf.append("transactionSequence").append("=").append(getTransactionSequence()).append(" ");
/*     */     }
/* 240 */     if (getWorkstationId() != null) {
/* 241 */       buf.append("workstationId").append("=").append(getWorkstationId()).append(" ");
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
/* 255 */     if (getChildBusinessDate() != null) {
/* 256 */       buf.append("childBusinessDate").append("=").append(getChildBusinessDate()).append(" ");
/*     */     }
/* 258 */     if (getChildRetailLocationId() != null) {
/* 259 */       buf.append("childRetailLocationId").append("=").append(getChildRetailLocationId()).append(" ");
/*     */     }
/* 261 */     if (getChildRetailTransactionLineItemSequence() != null) {
/* 262 */       buf.append("childRetailTransactionLineItemSequence").append("=").append(getChildRetailTransactionLineItemSequence()).append(" ");
/*     */     }
/* 264 */     if (getChildTransactionSequence() != null) {
/* 265 */       buf.append("childTransactionSequence").append("=").append(getChildTransactionSequence()).append(" ");
/*     */     }
/* 267 */     if (getChildWorkstationId() != null) {
/* 268 */       buf.append("childWorkstationId").append("=").append(getChildWorkstationId()).append(" ");
/*     */     }
/* 270 */     if (getLineItemAssociationTypeCodeString() != null) {
/* 271 */       buf.append("lineItemAssociationTypeCodeString").append("=").append(getLineItemAssociationTypeCodeString()).append(" ");
/*     */     }
/*     */     
/* 274 */     return buf.toString();
/*     */   }
/*     */   
/*     */   public IObjectId getObjectId() {
/* 278 */     LineItemAssociationModifierId id = new LineItemAssociationModifierId();
/* 279 */     id.setBusinessDate(getBusinessDate());
/* 280 */     id.setLineItemAssociationModifierSequence(getLineItemAssociationModifierSequence());
/* 281 */     id.setOrganizationId(getOrganizationId());
/* 282 */     id.setRetailLocationId(getRetailLocationId());
/* 283 */     id.setRetailTransactionLineItemSequence(getRetailTransactionLineItemSequence());
/* 284 */     id.setTransactionSequence(getTransactionSequence());
/* 285 */     id.setWorkstationId(getWorkstationId());
/* 286 */     return (IObjectId)id;
/*     */   }
/*     */   
/*     */   public void setObjectId(IObjectId argObjectId) {
/* 290 */     setBusinessDate(((LineItemAssociationModifierId)argObjectId).getBusinessDate());
/* 291 */     setLineItemAssociationModifierSequence(((LineItemAssociationModifierId)argObjectId).getLineItemAssociationModifierSequence());
/* 292 */     setOrganizationId(((LineItemAssociationModifierId)argObjectId).getOrganizationId());
/* 293 */     setRetailLocationId(((LineItemAssociationModifierId)argObjectId).getRetailLocationId());
/* 294 */     setRetailTransactionLineItemSequence(((LineItemAssociationModifierId)argObjectId).getRetailTransactionLineItemSequence());
/* 295 */     setTransactionSequence(((LineItemAssociationModifierId)argObjectId).getTransactionSequence());
/* 296 */     setWorkstationId(((LineItemAssociationModifierId)argObjectId).getWorkstationId());
/*     */   }
/*     */   
/*     */   public String getImplementingClass() {
/* 300 */     return null;
/*     */   }
/*     */   
/*     */   public String toXmlString() {
/* 304 */     StringBuilder buf = new StringBuilder(850);
/* 305 */     buf.append("<").append("dao").append(" name=\"LineItemAssociationModifier\" cmd=\"" + getObjectStateString() + "\">");
/* 306 */     getFieldsAsXml(buf);
/* 307 */     buf.append("</").append("dao").append(">");
/*     */     
/* 309 */     return buf.toString();
/*     */   }
/*     */   
/*     */   public Map<String, String> getValues() {
/* 313 */     Map<String, String> values = super.getValues();
/* 314 */     if (this._businessDate != null) values.put("BusinessDate", DaoUtils.getXmlSafeFieldValue(91, this._businessDate)); 
/* 315 */     if (this._lineItemAssociationModifierSequence != null) values.put("LineItemAssociationModifierSequence", DaoUtils.getXmlSafeFieldValue(4, this._lineItemAssociationModifierSequence)); 
/* 316 */     if (this._organizationId != null) values.put("OrganizationId", DaoUtils.getXmlSafeFieldValue(-5, this._organizationId)); 
/* 317 */     if (this._retailLocationId != null) values.put("RetailLocationId", DaoUtils.getXmlSafeFieldValue(-5, this._retailLocationId)); 
/* 318 */     if (this._retailTransactionLineItemSequence != null) values.put("RetailTransactionLineItemSequence", DaoUtils.getXmlSafeFieldValue(4, this._retailTransactionLineItemSequence)); 
/* 319 */     if (this._transactionSequence != null) values.put("TransactionSequence", DaoUtils.getXmlSafeFieldValue(-5, this._transactionSequence)); 
/* 320 */     if (this._workstationId != null) values.put("WorkstationId", DaoUtils.getXmlSafeFieldValue(-5, this._workstationId)); 
/* 321 */     if (this._createDate != null) values.put("CreateDate", DaoUtils.getXmlSafeFieldValue(91, this._createDate)); 
/* 322 */     if (this._createUserId != null) values.put("CreateUserId", DaoUtils.getXmlSafeFieldValue(12, this._createUserId)); 
/* 323 */     if (this._updateDate != null) values.put("UpdateDate", DaoUtils.getXmlSafeFieldValue(91, this._updateDate)); 
/* 324 */     if (this._updateUserId != null) values.put("UpdateUserId", DaoUtils.getXmlSafeFieldValue(12, this._updateUserId)); 
/* 325 */     if (this._childBusinessDate != null) values.put("ChildBusinessDate", DaoUtils.getXmlSafeFieldValue(91, this._childBusinessDate)); 
/* 326 */     if (this._childRetailLocationId != null) values.put("ChildRetailLocationId", DaoUtils.getXmlSafeFieldValue(-5, this._childRetailLocationId)); 
/* 327 */     if (this._childRetailTransactionLineItemSequence != null) values.put("ChildRetailTransactionLineItemSequence", DaoUtils.getXmlSafeFieldValue(4, this._childRetailTransactionLineItemSequence)); 
/* 328 */     if (this._childTransactionSequence != null) values.put("ChildTransactionSequence", DaoUtils.getXmlSafeFieldValue(-5, this._childTransactionSequence)); 
/* 329 */     if (this._childWorkstationId != null) values.put("ChildWorkstationId", DaoUtils.getXmlSafeFieldValue(-5, this._childWorkstationId)); 
/* 330 */     if (this._lineItemAssociationTypeCodeString != null) values.put("LineItemAssociationTypeCodeString", DaoUtils.getXmlSafeFieldValue(12, this._lineItemAssociationTypeCodeString)); 
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
/*     */         case "BusinessDate":
/*     */           try {
/* 345 */             Object value = DaoUtils.getFieldValueForXmlString(91, fieldValue);
/* 346 */             setBusinessDate((Date)value);
/* 347 */           } catch (Exception ee) {
/* 348 */             throw new DtxException("An exception occurred while calling setBusinessDate() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "LineItemAssociationModifierSequence":
/*     */           try {
/* 354 */             Object value = DaoUtils.getFieldValueForXmlString(4, fieldValue);
/* 355 */             setLineItemAssociationModifierSequence((Integer)value);
/* 356 */           } catch (Exception ee) {
/* 357 */             throw new DtxException("An exception occurred while calling setLineItemAssociationModifierSequence() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "OrganizationId":
/*     */           try {
/* 363 */             Object value = DaoUtils.getFieldValueForXmlString(-5, fieldValue);
/* 364 */             setOrganizationId((Long)value);
/* 365 */           } catch (Exception ee) {
/* 366 */             throw new DtxException("An exception occurred while calling setOrganizationId() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "RetailLocationId":
/*     */           try {
/* 372 */             Object value = DaoUtils.getFieldValueForXmlString(-5, fieldValue);
/* 373 */             setRetailLocationId((Long)value);
/* 374 */           } catch (Exception ee) {
/* 375 */             throw new DtxException("An exception occurred while calling setRetailLocationId() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
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
/*     */         case "WorkstationId":
/*     */           try {
/* 399 */             Object value = DaoUtils.getFieldValueForXmlString(-5, fieldValue);
/* 400 */             setWorkstationId((Long)value);
/* 401 */           } catch (Exception ee) {
/* 402 */             throw new DtxException("An exception occurred while calling setWorkstationId() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
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
/*     */         case "ChildBusinessDate":
/*     */           try {
/* 444 */             Object value = DaoUtils.getFieldValueForXmlString(91, fieldValue);
/* 445 */             setChildBusinessDate((Date)value);
/* 446 */           } catch (Exception ee) {
/* 447 */             throw new DtxException("An exception occurred while calling setChildBusinessDate() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "ChildRetailLocationId":
/*     */           try {
/* 453 */             Object value = DaoUtils.getFieldValueForXmlString(-5, fieldValue);
/* 454 */             setChildRetailLocationId((Long)value);
/* 455 */           } catch (Exception ee) {
/* 456 */             throw new DtxException("An exception occurred while calling setChildRetailLocationId() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "ChildRetailTransactionLineItemSequence":
/*     */           try {
/* 462 */             Object value = DaoUtils.getFieldValueForXmlString(4, fieldValue);
/* 463 */             setChildRetailTransactionLineItemSequence((Integer)value);
/* 464 */           } catch (Exception ee) {
/* 465 */             throw new DtxException("An exception occurred while calling setChildRetailTransactionLineItemSequence() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "ChildTransactionSequence":
/*     */           try {
/* 471 */             Object value = DaoUtils.getFieldValueForXmlString(-5, fieldValue);
/* 472 */             setChildTransactionSequence((Long)value);
/* 473 */           } catch (Exception ee) {
/* 474 */             throw new DtxException("An exception occurred while calling setChildTransactionSequence() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "ChildWorkstationId":
/*     */           try {
/* 480 */             Object value = DaoUtils.getFieldValueForXmlString(-5, fieldValue);
/* 481 */             setChildWorkstationId((Long)value);
/* 482 */           } catch (Exception ee) {
/* 483 */             throw new DtxException("An exception occurred while calling setChildWorkstationId() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "LineItemAssociationTypeCodeString":
/*     */           try {
/* 489 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 490 */             setLineItemAssociationTypeCodeString((String)value);
/* 491 */           } catch (Exception ee) {
/* 492 */             throw new DtxException("An exception occurred while calling setLineItemAssociationTypeCodeString() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */       } 
/*     */     } 
/*     */   }
/*     */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\trl\impl\LineItemAssociationModifierDAO.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */