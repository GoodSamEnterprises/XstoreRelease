/*     */ package dtv.xst.dao.tsn.impl;
/*     */ 
/*     */ import dtv.data2.access.DaoUtils;
/*     */ import dtv.data2.access.IObjectId;
/*     */ import dtv.data2.access.exception.DtxException;
/*     */ import dtv.data2.access.impl.AbstractDAOImpl;
/*     */ import dtv.util.DtvDate;
/*     */ import dtv.xst.dao.tsn.TillControlTransactionDetailId;
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
/*     */ public class TillControlTransactionDetailDAO
/*     */   extends AbstractDAOImpl
/*     */ {
/*     */   private static final long serialVersionUID = 1585992935L;
/*  23 */   private static final Logger _logger = Logger.getLogger(TillControlTransactionDetailDAO.class);
/*     */   
/*     */   private Long _organizationId;
/*     */   private Long _retailLocationId;
/*     */   private Long _workstationId;
/*     */   private DtvDate _businessDate;
/*     */   private Long _transactionSequence;
/*     */   private Long _transactionLineItemSequence;
/*     */   private DtvDate _createDate;
/*     */   private String _createUserId;
/*     */   private DtvDate _updateDate;
/*     */   private String _updateUserId;
/*     */   private String _affectedTenderRepositoryId;
/*     */   private Long _affectedWorkstationId;
/*     */   private String _currencyId;
/*     */   private BigDecimal _oldAmount;
/*     */   private BigDecimal _newAmount;
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
/*     */   public Long getWorkstationId() {
/*  62 */     return this._workstationId;
/*     */   }
/*     */   
/*     */   public void setWorkstationId(Long argWorkstationId) {
/*  66 */     if (changed(argWorkstationId, this._workstationId, "workstationId")) {
/*  67 */       this._workstationId = argWorkstationId;
/*     */     }
/*     */   }
/*     */   
/*     */   public Date getBusinessDate() {
/*  72 */     return (Date)this._businessDate;
/*     */   }
/*     */   
/*     */   public void setBusinessDate(Date argBusinessDate) {
/*  76 */     if (changed(argBusinessDate, this._businessDate, "businessDate")) {
/*  77 */       this._businessDate = (argBusinessDate == null || argBusinessDate instanceof DtvDate) ? (DtvDate)argBusinessDate : new DtvDate(argBusinessDate);
/*     */     }
/*     */   }
/*     */ 
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
/*     */   public Long getTransactionLineItemSequence() {
/*  93 */     return this._transactionLineItemSequence;
/*     */   }
/*     */   
/*     */   public void setTransactionLineItemSequence(Long argTransactionLineItemSequence) {
/*  97 */     if (changed(argTransactionLineItemSequence, this._transactionLineItemSequence, "transactionLineItemSequence")) {
/*  98 */       this._transactionLineItemSequence = argTransactionLineItemSequence;
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
/*     */   public String getAffectedTenderRepositoryId() {
/* 145 */     return this._affectedTenderRepositoryId;
/*     */   }
/*     */   
/*     */   public void setAffectedTenderRepositoryId(String argAffectedTenderRepositoryId) {
/* 149 */     if (changed(argAffectedTenderRepositoryId, this._affectedTenderRepositoryId, "affectedTenderRepositoryId")) {
/* 150 */       this._affectedTenderRepositoryId = argAffectedTenderRepositoryId;
/*     */     }
/*     */   }
/*     */   
/*     */   public Long getAffectedWorkstationId() {
/* 155 */     return this._affectedWorkstationId;
/*     */   }
/*     */   
/*     */   public void setAffectedWorkstationId(Long argAffectedWorkstationId) {
/* 159 */     if (changed(argAffectedWorkstationId, this._affectedWorkstationId, "affectedWorkstationId")) {
/* 160 */       this._affectedWorkstationId = argAffectedWorkstationId;
/*     */     }
/*     */   }
/*     */   
/*     */   public String getCurrencyId() {
/* 165 */     return this._currencyId;
/*     */   }
/*     */   
/*     */   public void setCurrencyId(String argCurrencyId) {
/* 169 */     if (changed(argCurrencyId, this._currencyId, "currencyId")) {
/* 170 */       this._currencyId = argCurrencyId;
/*     */     }
/*     */   }
/*     */   
/*     */   public BigDecimal getOldAmount() {
/* 175 */     return this._oldAmount;
/*     */   }
/*     */   
/*     */   public void setOldAmount(BigDecimal argOldAmount) {
/* 179 */     if (changed(argOldAmount, this._oldAmount, "oldAmount")) {
/* 180 */       this._oldAmount = argOldAmount;
/*     */     }
/*     */   }
/*     */   
/*     */   public BigDecimal getNewAmount() {
/* 185 */     return this._newAmount;
/*     */   }
/*     */   
/*     */   public void setNewAmount(BigDecimal argNewAmount) {
/* 189 */     if (changed(argNewAmount, this._newAmount, "newAmount")) {
/* 190 */       this._newAmount = argNewAmount;
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
/* 205 */     if (getWorkstationId() != null) {
/* 206 */       buf.append("workstationId").append("=").append(getWorkstationId()).append(" ");
/*     */     }
/* 208 */     if (getBusinessDate() != null) {
/* 209 */       buf.append("businessDate").append("=").append(getBusinessDate()).append(" ");
/*     */     }
/* 211 */     if (getTransactionSequence() != null) {
/* 212 */       buf.append("transactionSequence").append("=").append(getTransactionSequence()).append(" ");
/*     */     }
/* 214 */     if (getTransactionLineItemSequence() != null) {
/* 215 */       buf.append("transactionLineItemSequence").append("=").append(getTransactionLineItemSequence()).append(" ");
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
/* 229 */     if (getAffectedTenderRepositoryId() != null) {
/* 230 */       buf.append("affectedTenderRepositoryId").append("=").append(getAffectedTenderRepositoryId()).append(" ");
/*     */     }
/* 232 */     if (getAffectedWorkstationId() != null) {
/* 233 */       buf.append("affectedWorkstationId").append("=").append(getAffectedWorkstationId()).append(" ");
/*     */     }
/* 235 */     if (getCurrencyId() != null) {
/* 236 */       buf.append("currencyId").append("=").append(getCurrencyId()).append(" ");
/*     */     }
/* 238 */     if (getOldAmount() != null) {
/* 239 */       buf.append("oldAmount").append("=").append(getOldAmount()).append(" ");
/*     */     }
/* 241 */     if (getNewAmount() != null) {
/* 242 */       buf.append("newAmount").append("=").append(getNewAmount()).append(" ");
/*     */     }
/*     */     
/* 245 */     return buf.toString();
/*     */   }
/*     */   
/*     */   public IObjectId getObjectId() {
/* 249 */     TillControlTransactionDetailId id = new TillControlTransactionDetailId();
/* 250 */     id.setOrganizationId(getOrganizationId());
/* 251 */     id.setRetailLocationId(getRetailLocationId());
/* 252 */     id.setWorkstationId(getWorkstationId());
/* 253 */     id.setBusinessDate(getBusinessDate());
/* 254 */     id.setTransactionSequence(getTransactionSequence());
/* 255 */     id.setTransactionLineItemSequence(getTransactionLineItemSequence());
/* 256 */     return (IObjectId)id;
/*     */   }
/*     */   
/*     */   public void setObjectId(IObjectId argObjectId) {
/* 260 */     setOrganizationId(((TillControlTransactionDetailId)argObjectId).getOrganizationId());
/* 261 */     setRetailLocationId(((TillControlTransactionDetailId)argObjectId).getRetailLocationId());
/* 262 */     setWorkstationId(((TillControlTransactionDetailId)argObjectId).getWorkstationId());
/* 263 */     setBusinessDate(((TillControlTransactionDetailId)argObjectId).getBusinessDate());
/* 264 */     setTransactionSequence(((TillControlTransactionDetailId)argObjectId).getTransactionSequence());
/* 265 */     setTransactionLineItemSequence(((TillControlTransactionDetailId)argObjectId).getTransactionLineItemSequence());
/*     */   }
/*     */   
/*     */   public String getImplementingClass() {
/* 269 */     return null;
/*     */   }
/*     */   
/*     */   public String toXmlString() {
/* 273 */     StringBuilder buf = new StringBuilder(750);
/* 274 */     buf.append("<").append("dao").append(" name=\"TillControlTransactionDetail\" cmd=\"" + getObjectStateString() + "\">");
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
/* 285 */     if (this._workstationId != null) values.put("WorkstationId", DaoUtils.getXmlSafeFieldValue(-5, this._workstationId)); 
/* 286 */     if (this._businessDate != null) values.put("BusinessDate", DaoUtils.getXmlSafeFieldValue(91, this._businessDate)); 
/* 287 */     if (this._transactionSequence != null) values.put("TransactionSequence", DaoUtils.getXmlSafeFieldValue(-5, this._transactionSequence)); 
/* 288 */     if (this._transactionLineItemSequence != null) values.put("TransactionLineItemSequence", DaoUtils.getXmlSafeFieldValue(-5, this._transactionLineItemSequence)); 
/* 289 */     if (this._createDate != null) values.put("CreateDate", DaoUtils.getXmlSafeFieldValue(91, this._createDate)); 
/* 290 */     if (this._createUserId != null) values.put("CreateUserId", DaoUtils.getXmlSafeFieldValue(12, this._createUserId)); 
/* 291 */     if (this._updateDate != null) values.put("UpdateDate", DaoUtils.getXmlSafeFieldValue(91, this._updateDate)); 
/* 292 */     if (this._updateUserId != null) values.put("UpdateUserId", DaoUtils.getXmlSafeFieldValue(12, this._updateUserId)); 
/* 293 */     if (this._affectedTenderRepositoryId != null) values.put("AffectedTenderRepositoryId", DaoUtils.getXmlSafeFieldValue(12, this._affectedTenderRepositoryId)); 
/* 294 */     if (this._affectedWorkstationId != null) values.put("AffectedWorkstationId", DaoUtils.getXmlSafeFieldValue(-5, this._affectedWorkstationId)); 
/* 295 */     if (this._currencyId != null) values.put("CurrencyId", DaoUtils.getXmlSafeFieldValue(12, this._currencyId)); 
/* 296 */     if (this._oldAmount != null) values.put("OldAmount", DaoUtils.getXmlSafeFieldValue(3, this._oldAmount)); 
/* 297 */     if (this._newAmount != null) values.put("NewAmount", DaoUtils.getXmlSafeFieldValue(3, this._newAmount)); 
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
/*     */         case "WorkstationId":
/*     */           try {
/* 330 */             Object value = DaoUtils.getFieldValueForXmlString(-5, fieldValue);
/* 331 */             setWorkstationId((Long)value);
/* 332 */           } catch (Exception ee) {
/* 333 */             throw new DtxException("An exception occurred while calling setWorkstationId() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "BusinessDate":
/*     */           try {
/* 339 */             Object value = DaoUtils.getFieldValueForXmlString(91, fieldValue);
/* 340 */             setBusinessDate((Date)value);
/* 341 */           } catch (Exception ee) {
/* 342 */             throw new DtxException("An exception occurred while calling setBusinessDate() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
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
/*     */         case "TransactionLineItemSequence":
/*     */           try {
/* 357 */             Object value = DaoUtils.getFieldValueForXmlString(-5, fieldValue);
/* 358 */             setTransactionLineItemSequence((Long)value);
/* 359 */           } catch (Exception ee) {
/* 360 */             throw new DtxException("An exception occurred while calling setTransactionLineItemSequence() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
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
/*     */         case "AffectedTenderRepositoryId":
/*     */           try {
/* 402 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 403 */             setAffectedTenderRepositoryId((String)value);
/* 404 */           } catch (Exception ee) {
/* 405 */             throw new DtxException("An exception occurred while calling setAffectedTenderRepositoryId() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "AffectedWorkstationId":
/*     */           try {
/* 411 */             Object value = DaoUtils.getFieldValueForXmlString(-5, fieldValue);
/* 412 */             setAffectedWorkstationId((Long)value);
/* 413 */           } catch (Exception ee) {
/* 414 */             throw new DtxException("An exception occurred while calling setAffectedWorkstationId() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "CurrencyId":
/*     */           try {
/* 420 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 421 */             setCurrencyId((String)value);
/* 422 */           } catch (Exception ee) {
/* 423 */             throw new DtxException("An exception occurred while calling setCurrencyId() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "OldAmount":
/*     */           try {
/* 429 */             Object value = DaoUtils.getFieldValueForXmlString(3, fieldValue);
/* 430 */             setOldAmount((BigDecimal)value);
/* 431 */           } catch (Exception ee) {
/* 432 */             throw new DtxException("An exception occurred while calling setOldAmount() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "NewAmount":
/*     */           try {
/* 438 */             Object value = DaoUtils.getFieldValueForXmlString(3, fieldValue);
/* 439 */             setNewAmount((BigDecimal)value);
/* 440 */           } catch (Exception ee) {
/* 441 */             throw new DtxException("An exception occurred while calling setNewAmount() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */       } 
/*     */     } 
/*     */   }
/*     */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\tsn\impl\TillControlTransactionDetailDAO.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */