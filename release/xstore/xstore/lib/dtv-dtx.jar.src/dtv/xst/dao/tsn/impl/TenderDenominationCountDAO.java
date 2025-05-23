/*     */ package dtv.xst.dao.tsn.impl;
/*     */ 
/*     */ import dtv.data2.access.DaoUtils;
/*     */ import dtv.data2.access.IObjectId;
/*     */ import dtv.data2.access.exception.DtxException;
/*     */ import dtv.data2.access.impl.AbstractDAOImpl;
/*     */ import dtv.util.DtvDate;
/*     */ import dtv.xst.dao.tsn.TenderDenominationCountId;
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
/*     */ public class TenderDenominationCountDAO
/*     */   extends AbstractDAOImpl
/*     */ {
/*     */   private static final long serialVersionUID = -1378804842L;
/*  23 */   private static final Logger _logger = Logger.getLogger(TenderDenominationCountDAO.class);
/*     */   
/*     */   private DtvDate _businessDayDate;
/*     */   private String _denominationId;
/*     */   private Long _organizationId;
/*     */   private Long _retailLocationId;
/*     */   private String _tenderId;
/*     */   private String _tenderTypeCode;
/*     */   private Long _transactionSequence;
/*     */   private Long _workstationId;
/*     */   private DtvDate _createDate;
/*     */   private String _createUserId;
/*     */   private DtvDate _updateDate;
/*     */   private String _updateUserId;
/*     */   private BigDecimal _amount;
/*     */   private BigDecimal _differenceAmount;
/*     */   private Integer _differenceMediaCount;
/*     */   private Integer _mediaCount;
/*     */   
/*     */   public Date getBusinessDayDate() {
/*  43 */     return (Date)this._businessDayDate;
/*     */   }
/*     */   
/*     */   public void setBusinessDayDate(Date argBusinessDayDate) {
/*  47 */     if (changed(argBusinessDayDate, this._businessDayDate, "businessDayDate")) {
/*  48 */       this._businessDayDate = (argBusinessDayDate == null || argBusinessDayDate instanceof DtvDate) ? (DtvDate)argBusinessDayDate : new DtvDate(argBusinessDayDate);
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public String getDenominationId() {
/*  54 */     return this._denominationId;
/*     */   }
/*     */   
/*     */   public void setDenominationId(String argDenominationId) {
/*  58 */     if (changed(argDenominationId, this._denominationId, "denominationId")) {
/*  59 */       this._denominationId = (argDenominationId != null && MANAGE_CASE) ? argDenominationId.toUpperCase() : argDenominationId;
/*     */     }
/*     */   }
/*     */   
/*     */   public Long getOrganizationId() {
/*  64 */     return this._organizationId;
/*     */   }
/*     */   
/*     */   public void setOrganizationId(Long argOrganizationId) {
/*  68 */     if (changed(argOrganizationId, this._organizationId, "organizationId")) {
/*  69 */       this._organizationId = argOrganizationId;
/*     */     }
/*     */   }
/*     */   
/*     */   public Long getRetailLocationId() {
/*  74 */     return this._retailLocationId;
/*     */   }
/*     */   
/*     */   public void setRetailLocationId(Long argRetailLocationId) {
/*  78 */     if (changed(argRetailLocationId, this._retailLocationId, "retailLocationId")) {
/*  79 */       this._retailLocationId = argRetailLocationId;
/*     */     }
/*     */   }
/*     */   
/*     */   public String getTenderId() {
/*  84 */     return this._tenderId;
/*     */   }
/*     */   
/*     */   public void setTenderId(String argTenderId) {
/*  88 */     if (changed(argTenderId, this._tenderId, "tenderId")) {
/*  89 */       this._tenderId = (argTenderId != null && MANAGE_CASE) ? argTenderId.toUpperCase() : argTenderId;
/*     */     }
/*     */   }
/*     */   
/*     */   public String getTenderTypeCode() {
/*  94 */     return this._tenderTypeCode;
/*     */   }
/*     */   
/*     */   public void setTenderTypeCode(String argTenderTypeCode) {
/*  98 */     if (changed(argTenderTypeCode, this._tenderTypeCode, "tenderTypeCode")) {
/*  99 */       this._tenderTypeCode = (argTenderTypeCode != null && MANAGE_CASE) ? argTenderTypeCode.toUpperCase() : argTenderTypeCode;
/*     */     }
/*     */   }
/*     */   
/*     */   public Long getTransactionSequence() {
/* 104 */     return this._transactionSequence;
/*     */   }
/*     */   
/*     */   public void setTransactionSequence(Long argTransactionSequence) {
/* 108 */     if (changed(argTransactionSequence, this._transactionSequence, "transactionSequence")) {
/* 109 */       this._transactionSequence = argTransactionSequence;
/*     */     }
/*     */   }
/*     */   
/*     */   public Long getWorkstationId() {
/* 114 */     return this._workstationId;
/*     */   }
/*     */   
/*     */   public void setWorkstationId(Long argWorkstationId) {
/* 118 */     if (changed(argWorkstationId, this._workstationId, "workstationId")) {
/* 119 */       this._workstationId = argWorkstationId;
/*     */     }
/*     */   }
/*     */   
/*     */   public Date getCreateDate() {
/* 124 */     return (Date)this._createDate;
/*     */   }
/*     */   
/*     */   public void setCreateDate(Date argCreateDate) {
/* 128 */     if (changed(argCreateDate, this._createDate, "createDate")) {
/* 129 */       this._createDate = (argCreateDate == null || argCreateDate instanceof DtvDate) ? (DtvDate)argCreateDate : new DtvDate(argCreateDate);
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public String getCreateUserId() {
/* 135 */     return this._createUserId;
/*     */   }
/*     */   
/*     */   public void setCreateUserId(String argCreateUserId) {
/* 139 */     if (changed(argCreateUserId, this._createUserId, "createUserId")) {
/* 140 */       this._createUserId = argCreateUserId;
/*     */     }
/*     */   }
/*     */   
/*     */   public Date getUpdateDate() {
/* 145 */     return (Date)this._updateDate;
/*     */   }
/*     */   
/*     */   public void setUpdateDate(Date argUpdateDate) {
/* 149 */     if (changed(argUpdateDate, this._updateDate, "updateDate")) {
/* 150 */       this._updateDate = (argUpdateDate == null || argUpdateDate instanceof DtvDate) ? (DtvDate)argUpdateDate : new DtvDate(argUpdateDate);
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public String getUpdateUserId() {
/* 156 */     return this._updateUserId;
/*     */   }
/*     */   
/*     */   public void setUpdateUserId(String argUpdateUserId) {
/* 160 */     if (changed(argUpdateUserId, this._updateUserId, "updateUserId")) {
/* 161 */       this._updateUserId = argUpdateUserId;
/*     */     }
/*     */   }
/*     */   
/*     */   public BigDecimal getAmount() {
/* 166 */     return this._amount;
/*     */   }
/*     */   
/*     */   public void setAmount(BigDecimal argAmount) {
/* 170 */     if (changed(argAmount, this._amount, "amount")) {
/* 171 */       this._amount = argAmount;
/*     */     }
/*     */   }
/*     */   
/*     */   public BigDecimal getDifferenceAmount() {
/* 176 */     return this._differenceAmount;
/*     */   }
/*     */   
/*     */   public void setDifferenceAmount(BigDecimal argDifferenceAmount) {
/* 180 */     if (changed(argDifferenceAmount, this._differenceAmount, "differenceAmount")) {
/* 181 */       this._differenceAmount = argDifferenceAmount;
/*     */     }
/*     */   }
/*     */   
/*     */   public Integer getDifferenceMediaCount() {
/* 186 */     return this._differenceMediaCount;
/*     */   }
/*     */   
/*     */   public void setDifferenceMediaCount(Integer argDifferenceMediaCount) {
/* 190 */     if (changed(argDifferenceMediaCount, this._differenceMediaCount, "differenceMediaCount")) {
/* 191 */       this._differenceMediaCount = argDifferenceMediaCount;
/*     */     }
/*     */   }
/*     */   
/*     */   public Integer getMediaCount() {
/* 196 */     return this._mediaCount;
/*     */   }
/*     */   
/*     */   public void setMediaCount(Integer argMediaCount) {
/* 200 */     if (changed(argMediaCount, this._mediaCount, "mediaCount")) {
/* 201 */       this._mediaCount = argMediaCount;
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public String toString() {
/* 208 */     StringBuilder buf = new StringBuilder(512);
/* 209 */     buf.append(super.toString()).append(" Id: ").append(getObjectId()).append(" Values: ");
/* 210 */     if (getBusinessDayDate() != null) {
/* 211 */       buf.append("businessDayDate").append("=").append(getBusinessDayDate()).append(" ");
/*     */     }
/* 213 */     if (getDenominationId() != null) {
/* 214 */       buf.append("denominationId").append("=").append(getDenominationId()).append(" ");
/*     */     }
/* 216 */     if (getOrganizationId() != null) {
/* 217 */       buf.append("organizationId").append("=").append(getOrganizationId()).append(" ");
/*     */     }
/* 219 */     if (getRetailLocationId() != null) {
/* 220 */       buf.append("retailLocationId").append("=").append(getRetailLocationId()).append(" ");
/*     */     }
/* 222 */     if (getTenderId() != null) {
/* 223 */       buf.append("tenderId").append("=").append(getTenderId()).append(" ");
/*     */     }
/* 225 */     if (getTenderTypeCode() != null) {
/* 226 */       buf.append("tenderTypeCode").append("=").append(getTenderTypeCode()).append(" ");
/*     */     }
/* 228 */     if (getTransactionSequence() != null) {
/* 229 */       buf.append("transactionSequence").append("=").append(getTransactionSequence()).append(" ");
/*     */     }
/* 231 */     if (getWorkstationId() != null) {
/* 232 */       buf.append("workstationId").append("=").append(getWorkstationId()).append(" ");
/*     */     }
/* 234 */     if (getCreateDate() != null) {
/* 235 */       buf.append("createDate").append("=").append(getCreateDate()).append(" ");
/*     */     }
/* 237 */     if (getCreateUserId() != null) {
/* 238 */       buf.append("createUserId").append("=").append(getCreateUserId()).append(" ");
/*     */     }
/* 240 */     if (getUpdateDate() != null) {
/* 241 */       buf.append("updateDate").append("=").append(getUpdateDate()).append(" ");
/*     */     }
/* 243 */     if (getUpdateUserId() != null) {
/* 244 */       buf.append("updateUserId").append("=").append(getUpdateUserId()).append(" ");
/*     */     }
/* 246 */     if (getAmount() != null) {
/* 247 */       buf.append("amount").append("=").append(getAmount()).append(" ");
/*     */     }
/* 249 */     if (getDifferenceAmount() != null) {
/* 250 */       buf.append("differenceAmount").append("=").append(getDifferenceAmount()).append(" ");
/*     */     }
/* 252 */     if (getDifferenceMediaCount() != null) {
/* 253 */       buf.append("differenceMediaCount").append("=").append(getDifferenceMediaCount()).append(" ");
/*     */     }
/* 255 */     if (getMediaCount() != null) {
/* 256 */       buf.append("mediaCount").append("=").append(getMediaCount()).append(" ");
/*     */     }
/*     */     
/* 259 */     return buf.toString();
/*     */   }
/*     */   
/*     */   public IObjectId getObjectId() {
/* 263 */     TenderDenominationCountId id = new TenderDenominationCountId();
/* 264 */     id.setBusinessDayDate(getBusinessDayDate());
/* 265 */     id.setDenominationId(getDenominationId());
/* 266 */     id.setOrganizationId(getOrganizationId());
/* 267 */     id.setRetailLocationId(getRetailLocationId());
/* 268 */     id.setTenderId(getTenderId());
/* 269 */     id.setTenderTypeCode(getTenderTypeCode());
/* 270 */     id.setTransactionSequence(getTransactionSequence());
/* 271 */     id.setWorkstationId(getWorkstationId());
/* 272 */     return (IObjectId)id;
/*     */   }
/*     */   
/*     */   public void setObjectId(IObjectId argObjectId) {
/* 276 */     setBusinessDayDate(((TenderDenominationCountId)argObjectId).getBusinessDayDate());
/* 277 */     setDenominationId(((TenderDenominationCountId)argObjectId).getDenominationId());
/* 278 */     setOrganizationId(((TenderDenominationCountId)argObjectId).getOrganizationId());
/* 279 */     setRetailLocationId(((TenderDenominationCountId)argObjectId).getRetailLocationId());
/* 280 */     setTenderId(((TenderDenominationCountId)argObjectId).getTenderId());
/* 281 */     setTenderTypeCode(((TenderDenominationCountId)argObjectId).getTenderTypeCode());
/* 282 */     setTransactionSequence(((TenderDenominationCountId)argObjectId).getTransactionSequence());
/* 283 */     setWorkstationId(((TenderDenominationCountId)argObjectId).getWorkstationId());
/*     */   }
/*     */   
/*     */   public String getImplementingClass() {
/* 287 */     return null;
/*     */   }
/*     */   
/*     */   public String toXmlString() {
/* 291 */     StringBuilder buf = new StringBuilder(800);
/* 292 */     buf.append("<").append("dao").append(" name=\"TenderDenominationCount\" cmd=\"" + getObjectStateString() + "\">");
/* 293 */     getFieldsAsXml(buf);
/* 294 */     buf.append("</").append("dao").append(">");
/*     */     
/* 296 */     return buf.toString();
/*     */   }
/*     */   
/*     */   public Map<String, String> getValues() {
/* 300 */     Map<String, String> values = super.getValues();
/* 301 */     if (this._businessDayDate != null) values.put("BusinessDayDate", DaoUtils.getXmlSafeFieldValue(91, this._businessDayDate)); 
/* 302 */     if (this._denominationId != null) values.put("DenominationId", DaoUtils.getXmlSafeFieldValue(12, this._denominationId)); 
/* 303 */     if (this._organizationId != null) values.put("OrganizationId", DaoUtils.getXmlSafeFieldValue(-5, this._organizationId)); 
/* 304 */     if (this._retailLocationId != null) values.put("RetailLocationId", DaoUtils.getXmlSafeFieldValue(-5, this._retailLocationId)); 
/* 305 */     if (this._tenderId != null) values.put("TenderId", DaoUtils.getXmlSafeFieldValue(12, this._tenderId)); 
/* 306 */     if (this._tenderTypeCode != null) values.put("TenderTypeCode", DaoUtils.getXmlSafeFieldValue(12, this._tenderTypeCode)); 
/* 307 */     if (this._transactionSequence != null) values.put("TransactionSequence", DaoUtils.getXmlSafeFieldValue(-5, this._transactionSequence)); 
/* 308 */     if (this._workstationId != null) values.put("WorkstationId", DaoUtils.getXmlSafeFieldValue(-5, this._workstationId)); 
/* 309 */     if (this._createDate != null) values.put("CreateDate", DaoUtils.getXmlSafeFieldValue(91, this._createDate)); 
/* 310 */     if (this._createUserId != null) values.put("CreateUserId", DaoUtils.getXmlSafeFieldValue(12, this._createUserId)); 
/* 311 */     if (this._updateDate != null) values.put("UpdateDate", DaoUtils.getXmlSafeFieldValue(91, this._updateDate)); 
/* 312 */     if (this._updateUserId != null) values.put("UpdateUserId", DaoUtils.getXmlSafeFieldValue(12, this._updateUserId)); 
/* 313 */     if (this._amount != null) values.put("Amount", DaoUtils.getXmlSafeFieldValue(3, this._amount)); 
/* 314 */     if (this._differenceAmount != null) values.put("DifferenceAmount", DaoUtils.getXmlSafeFieldValue(3, this._differenceAmount)); 
/* 315 */     if (this._differenceMediaCount != null) values.put("DifferenceMediaCount", DaoUtils.getXmlSafeFieldValue(4, this._differenceMediaCount)); 
/* 316 */     if (this._mediaCount != null) values.put("MediaCount", DaoUtils.getXmlSafeFieldValue(4, this._mediaCount)); 
/* 317 */     return values;
/*     */   }
/*     */ 
/*     */   
/*     */   public void setValues(Map<String, String> argValues) {
/* 322 */     super.setValues(argValues);
/* 323 */     for (Map.Entry<String, String> field : argValues.entrySet()) {
/*     */       
/* 325 */       String fieldName = field.getKey();
/* 326 */       String fieldValue = field.getValue();
/* 327 */       switch (fieldName) {
/*     */         
/*     */         case "BusinessDayDate":
/*     */           try {
/* 331 */             Object value = DaoUtils.getFieldValueForXmlString(91, fieldValue);
/* 332 */             setBusinessDayDate((Date)value);
/* 333 */           } catch (Exception ee) {
/* 334 */             throw new DtxException("An exception occurred while calling setBusinessDayDate() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "DenominationId":
/*     */           try {
/* 340 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 341 */             setDenominationId((String)value);
/* 342 */           } catch (Exception ee) {
/* 343 */             throw new DtxException("An exception occurred while calling setDenominationId() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "OrganizationId":
/*     */           try {
/* 349 */             Object value = DaoUtils.getFieldValueForXmlString(-5, fieldValue);
/* 350 */             setOrganizationId((Long)value);
/* 351 */           } catch (Exception ee) {
/* 352 */             throw new DtxException("An exception occurred while calling setOrganizationId() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "RetailLocationId":
/*     */           try {
/* 358 */             Object value = DaoUtils.getFieldValueForXmlString(-5, fieldValue);
/* 359 */             setRetailLocationId((Long)value);
/* 360 */           } catch (Exception ee) {
/* 361 */             throw new DtxException("An exception occurred while calling setRetailLocationId() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "TenderId":
/*     */           try {
/* 367 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 368 */             setTenderId((String)value);
/* 369 */           } catch (Exception ee) {
/* 370 */             throw new DtxException("An exception occurred while calling setTenderId() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "TenderTypeCode":
/*     */           try {
/* 376 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 377 */             setTenderTypeCode((String)value);
/* 378 */           } catch (Exception ee) {
/* 379 */             throw new DtxException("An exception occurred while calling setTenderTypeCode() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "TransactionSequence":
/*     */           try {
/* 385 */             Object value = DaoUtils.getFieldValueForXmlString(-5, fieldValue);
/* 386 */             setTransactionSequence((Long)value);
/* 387 */           } catch (Exception ee) {
/* 388 */             throw new DtxException("An exception occurred while calling setTransactionSequence() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "WorkstationId":
/*     */           try {
/* 394 */             Object value = DaoUtils.getFieldValueForXmlString(-5, fieldValue);
/* 395 */             setWorkstationId((Long)value);
/* 396 */           } catch (Exception ee) {
/* 397 */             throw new DtxException("An exception occurred while calling setWorkstationId() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "CreateDate":
/*     */           try {
/* 403 */             Object value = DaoUtils.getFieldValueForXmlString(91, fieldValue);
/* 404 */             setCreateDate((Date)value);
/* 405 */           } catch (Exception ee) {
/* 406 */             throw new DtxException("An exception occurred while calling setCreateDate() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "CreateUserId":
/*     */           try {
/* 412 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 413 */             setCreateUserId((String)value);
/* 414 */           } catch (Exception ee) {
/* 415 */             throw new DtxException("An exception occurred while calling setCreateUserId() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "UpdateDate":
/*     */           try {
/* 421 */             Object value = DaoUtils.getFieldValueForXmlString(91, fieldValue);
/* 422 */             setUpdateDate((Date)value);
/* 423 */           } catch (Exception ee) {
/* 424 */             throw new DtxException("An exception occurred while calling setUpdateDate() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "UpdateUserId":
/*     */           try {
/* 430 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 431 */             setUpdateUserId((String)value);
/* 432 */           } catch (Exception ee) {
/* 433 */             throw new DtxException("An exception occurred while calling setUpdateUserId() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "Amount":
/*     */           try {
/* 439 */             Object value = DaoUtils.getFieldValueForXmlString(3, fieldValue);
/* 440 */             setAmount((BigDecimal)value);
/* 441 */           } catch (Exception ee) {
/* 442 */             throw new DtxException("An exception occurred while calling setAmount() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "DifferenceAmount":
/*     */           try {
/* 448 */             Object value = DaoUtils.getFieldValueForXmlString(3, fieldValue);
/* 449 */             setDifferenceAmount((BigDecimal)value);
/* 450 */           } catch (Exception ee) {
/* 451 */             throw new DtxException("An exception occurred while calling setDifferenceAmount() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "DifferenceMediaCount":
/*     */           try {
/* 457 */             Object value = DaoUtils.getFieldValueForXmlString(4, fieldValue);
/* 458 */             setDifferenceMediaCount((Integer)value);
/* 459 */           } catch (Exception ee) {
/* 460 */             throw new DtxException("An exception occurred while calling setDifferenceMediaCount() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "MediaCount":
/*     */           try {
/* 466 */             Object value = DaoUtils.getFieldValueForXmlString(4, fieldValue);
/* 467 */             setMediaCount((Integer)value);
/* 468 */           } catch (Exception ee) {
/* 469 */             throw new DtxException("An exception occurred while calling setMediaCount() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */       } 
/*     */     } 
/*     */   }
/*     */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\tsn\impl\TenderDenominationCountDAO.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */