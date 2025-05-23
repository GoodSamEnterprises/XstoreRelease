/*     */ package dtv.xst.dao.tsn.impl;
/*     */ 
/*     */ import dtv.data2.access.DaoUtils;
/*     */ import dtv.data2.access.IObjectId;
/*     */ import dtv.data2.access.exception.DtxException;
/*     */ import dtv.data2.access.impl.AbstractDAOImpl;
/*     */ import dtv.util.DtvDate;
/*     */ import dtv.xst.dao.tsn.TenderTypeCountId;
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
/*     */ public class TenderTypeCountDAO
/*     */   extends AbstractDAOImpl
/*     */ {
/*     */   private static final long serialVersionUID = 838474081L;
/*  23 */   private static final Logger _logger = Logger.getLogger(TenderTypeCountDAO.class);
/*     */   
/*     */   private DtvDate _businessDayDate;
/*     */   private Long _organizationId;
/*     */   private Long _retailLocationId;
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
/*  41 */     return (Date)this._businessDayDate;
/*     */   }
/*     */   
/*     */   public void setBusinessDayDate(Date argBusinessDayDate) {
/*  45 */     if (changed(argBusinessDayDate, this._businessDayDate, "businessDayDate")) {
/*  46 */       this._businessDayDate = (argBusinessDayDate == null || argBusinessDayDate instanceof DtvDate) ? (DtvDate)argBusinessDayDate : new DtvDate(argBusinessDayDate);
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public Long getOrganizationId() {
/*  52 */     return this._organizationId;
/*     */   }
/*     */   
/*     */   public void setOrganizationId(Long argOrganizationId) {
/*  56 */     if (changed(argOrganizationId, this._organizationId, "organizationId")) {
/*  57 */       this._organizationId = argOrganizationId;
/*     */     }
/*     */   }
/*     */   
/*     */   public Long getRetailLocationId() {
/*  62 */     return this._retailLocationId;
/*     */   }
/*     */   
/*     */   public void setRetailLocationId(Long argRetailLocationId) {
/*  66 */     if (changed(argRetailLocationId, this._retailLocationId, "retailLocationId")) {
/*  67 */       this._retailLocationId = argRetailLocationId;
/*     */     }
/*     */   }
/*     */   
/*     */   public String getTenderTypeCode() {
/*  72 */     return this._tenderTypeCode;
/*     */   }
/*     */   
/*     */   public void setTenderTypeCode(String argTenderTypeCode) {
/*  76 */     if (changed(argTenderTypeCode, this._tenderTypeCode, "tenderTypeCode")) {
/*  77 */       this._tenderTypeCode = (argTenderTypeCode != null && MANAGE_CASE) ? argTenderTypeCode.toUpperCase() : argTenderTypeCode;
/*     */     }
/*     */   }
/*     */   
/*     */   public Long getTransactionSequence() {
/*  82 */     return this._transactionSequence;
/*     */   }
/*     */   
/*     */   public void setTransactionSequence(Long argTransactionSequence) {
/*  86 */     if (changed(argTransactionSequence, this._transactionSequence, "transactionSequence")) {
/*  87 */       this._transactionSequence = argTransactionSequence;
/*     */     }
/*     */   }
/*     */   
/*     */   public Long getWorkstationId() {
/*  92 */     return this._workstationId;
/*     */   }
/*     */   
/*     */   public void setWorkstationId(Long argWorkstationId) {
/*  96 */     if (changed(argWorkstationId, this._workstationId, "workstationId")) {
/*  97 */       this._workstationId = argWorkstationId;
/*     */     }
/*     */   }
/*     */   
/*     */   public Date getCreateDate() {
/* 102 */     return (Date)this._createDate;
/*     */   }
/*     */   
/*     */   public void setCreateDate(Date argCreateDate) {
/* 106 */     if (changed(argCreateDate, this._createDate, "createDate")) {
/* 107 */       this._createDate = (argCreateDate == null || argCreateDate instanceof DtvDate) ? (DtvDate)argCreateDate : new DtvDate(argCreateDate);
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public String getCreateUserId() {
/* 113 */     return this._createUserId;
/*     */   }
/*     */   
/*     */   public void setCreateUserId(String argCreateUserId) {
/* 117 */     if (changed(argCreateUserId, this._createUserId, "createUserId")) {
/* 118 */       this._createUserId = argCreateUserId;
/*     */     }
/*     */   }
/*     */   
/*     */   public Date getUpdateDate() {
/* 123 */     return (Date)this._updateDate;
/*     */   }
/*     */   
/*     */   public void setUpdateDate(Date argUpdateDate) {
/* 127 */     if (changed(argUpdateDate, this._updateDate, "updateDate")) {
/* 128 */       this._updateDate = (argUpdateDate == null || argUpdateDate instanceof DtvDate) ? (DtvDate)argUpdateDate : new DtvDate(argUpdateDate);
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public String getUpdateUserId() {
/* 134 */     return this._updateUserId;
/*     */   }
/*     */   
/*     */   public void setUpdateUserId(String argUpdateUserId) {
/* 138 */     if (changed(argUpdateUserId, this._updateUserId, "updateUserId")) {
/* 139 */       this._updateUserId = argUpdateUserId;
/*     */     }
/*     */   }
/*     */   
/*     */   public BigDecimal getAmount() {
/* 144 */     return this._amount;
/*     */   }
/*     */   
/*     */   public void setAmount(BigDecimal argAmount) {
/* 148 */     if (changed(argAmount, this._amount, "amount")) {
/* 149 */       this._amount = argAmount;
/*     */     }
/*     */   }
/*     */   
/*     */   public BigDecimal getDifferenceAmount() {
/* 154 */     return this._differenceAmount;
/*     */   }
/*     */   
/*     */   public void setDifferenceAmount(BigDecimal argDifferenceAmount) {
/* 158 */     if (changed(argDifferenceAmount, this._differenceAmount, "differenceAmount")) {
/* 159 */       this._differenceAmount = argDifferenceAmount;
/*     */     }
/*     */   }
/*     */   
/*     */   public Integer getDifferenceMediaCount() {
/* 164 */     return this._differenceMediaCount;
/*     */   }
/*     */   
/*     */   public void setDifferenceMediaCount(Integer argDifferenceMediaCount) {
/* 168 */     if (changed(argDifferenceMediaCount, this._differenceMediaCount, "differenceMediaCount")) {
/* 169 */       this._differenceMediaCount = argDifferenceMediaCount;
/*     */     }
/*     */   }
/*     */   
/*     */   public Integer getMediaCount() {
/* 174 */     return this._mediaCount;
/*     */   }
/*     */   
/*     */   public void setMediaCount(Integer argMediaCount) {
/* 178 */     if (changed(argMediaCount, this._mediaCount, "mediaCount")) {
/* 179 */       this._mediaCount = argMediaCount;
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public String toString() {
/* 186 */     StringBuilder buf = new StringBuilder(512);
/* 187 */     buf.append(super.toString()).append(" Id: ").append(getObjectId()).append(" Values: ");
/* 188 */     if (getBusinessDayDate() != null) {
/* 189 */       buf.append("businessDayDate").append("=").append(getBusinessDayDate()).append(" ");
/*     */     }
/* 191 */     if (getOrganizationId() != null) {
/* 192 */       buf.append("organizationId").append("=").append(getOrganizationId()).append(" ");
/*     */     }
/* 194 */     if (getRetailLocationId() != null) {
/* 195 */       buf.append("retailLocationId").append("=").append(getRetailLocationId()).append(" ");
/*     */     }
/* 197 */     if (getTenderTypeCode() != null) {
/* 198 */       buf.append("tenderTypeCode").append("=").append(getTenderTypeCode()).append(" ");
/*     */     }
/* 200 */     if (getTransactionSequence() != null) {
/* 201 */       buf.append("transactionSequence").append("=").append(getTransactionSequence()).append(" ");
/*     */     }
/* 203 */     if (getWorkstationId() != null) {
/* 204 */       buf.append("workstationId").append("=").append(getWorkstationId()).append(" ");
/*     */     }
/* 206 */     if (getCreateDate() != null) {
/* 207 */       buf.append("createDate").append("=").append(getCreateDate()).append(" ");
/*     */     }
/* 209 */     if (getCreateUserId() != null) {
/* 210 */       buf.append("createUserId").append("=").append(getCreateUserId()).append(" ");
/*     */     }
/* 212 */     if (getUpdateDate() != null) {
/* 213 */       buf.append("updateDate").append("=").append(getUpdateDate()).append(" ");
/*     */     }
/* 215 */     if (getUpdateUserId() != null) {
/* 216 */       buf.append("updateUserId").append("=").append(getUpdateUserId()).append(" ");
/*     */     }
/* 218 */     if (getAmount() != null) {
/* 219 */       buf.append("amount").append("=").append(getAmount()).append(" ");
/*     */     }
/* 221 */     if (getDifferenceAmount() != null) {
/* 222 */       buf.append("differenceAmount").append("=").append(getDifferenceAmount()).append(" ");
/*     */     }
/* 224 */     if (getDifferenceMediaCount() != null) {
/* 225 */       buf.append("differenceMediaCount").append("=").append(getDifferenceMediaCount()).append(" ");
/*     */     }
/* 227 */     if (getMediaCount() != null) {
/* 228 */       buf.append("mediaCount").append("=").append(getMediaCount()).append(" ");
/*     */     }
/*     */     
/* 231 */     return buf.toString();
/*     */   }
/*     */   
/*     */   public IObjectId getObjectId() {
/* 235 */     TenderTypeCountId id = new TenderTypeCountId();
/* 236 */     id.setBusinessDayDate(getBusinessDayDate());
/* 237 */     id.setOrganizationId(getOrganizationId());
/* 238 */     id.setRetailLocationId(getRetailLocationId());
/* 239 */     id.setTenderTypeCode(getTenderTypeCode());
/* 240 */     id.setTransactionSequence(getTransactionSequence());
/* 241 */     id.setWorkstationId(getWorkstationId());
/* 242 */     return (IObjectId)id;
/*     */   }
/*     */   
/*     */   public void setObjectId(IObjectId argObjectId) {
/* 246 */     setBusinessDayDate(((TenderTypeCountId)argObjectId).getBusinessDayDate());
/* 247 */     setOrganizationId(((TenderTypeCountId)argObjectId).getOrganizationId());
/* 248 */     setRetailLocationId(((TenderTypeCountId)argObjectId).getRetailLocationId());
/* 249 */     setTenderTypeCode(((TenderTypeCountId)argObjectId).getTenderTypeCode());
/* 250 */     setTransactionSequence(((TenderTypeCountId)argObjectId).getTransactionSequence());
/* 251 */     setWorkstationId(((TenderTypeCountId)argObjectId).getWorkstationId());
/*     */   }
/*     */   
/*     */   public String getImplementingClass() {
/* 255 */     return null;
/*     */   }
/*     */   
/*     */   public String toXmlString() {
/* 259 */     StringBuilder buf = new StringBuilder(700);
/* 260 */     buf.append("<").append("dao").append(" name=\"TenderTypeCount\" cmd=\"" + getObjectStateString() + "\">");
/* 261 */     getFieldsAsXml(buf);
/* 262 */     buf.append("</").append("dao").append(">");
/*     */     
/* 264 */     return buf.toString();
/*     */   }
/*     */   
/*     */   public Map<String, String> getValues() {
/* 268 */     Map<String, String> values = super.getValues();
/* 269 */     if (this._businessDayDate != null) values.put("BusinessDayDate", DaoUtils.getXmlSafeFieldValue(91, this._businessDayDate)); 
/* 270 */     if (this._organizationId != null) values.put("OrganizationId", DaoUtils.getXmlSafeFieldValue(-5, this._organizationId)); 
/* 271 */     if (this._retailLocationId != null) values.put("RetailLocationId", DaoUtils.getXmlSafeFieldValue(-5, this._retailLocationId)); 
/* 272 */     if (this._tenderTypeCode != null) values.put("TenderTypeCode", DaoUtils.getXmlSafeFieldValue(12, this._tenderTypeCode)); 
/* 273 */     if (this._transactionSequence != null) values.put("TransactionSequence", DaoUtils.getXmlSafeFieldValue(-5, this._transactionSequence)); 
/* 274 */     if (this._workstationId != null) values.put("WorkstationId", DaoUtils.getXmlSafeFieldValue(-5, this._workstationId)); 
/* 275 */     if (this._createDate != null) values.put("CreateDate", DaoUtils.getXmlSafeFieldValue(91, this._createDate)); 
/* 276 */     if (this._createUserId != null) values.put("CreateUserId", DaoUtils.getXmlSafeFieldValue(12, this._createUserId)); 
/* 277 */     if (this._updateDate != null) values.put("UpdateDate", DaoUtils.getXmlSafeFieldValue(91, this._updateDate)); 
/* 278 */     if (this._updateUserId != null) values.put("UpdateUserId", DaoUtils.getXmlSafeFieldValue(12, this._updateUserId)); 
/* 279 */     if (this._amount != null) values.put("Amount", DaoUtils.getXmlSafeFieldValue(3, this._amount)); 
/* 280 */     if (this._differenceAmount != null) values.put("DifferenceAmount", DaoUtils.getXmlSafeFieldValue(3, this._differenceAmount)); 
/* 281 */     if (this._differenceMediaCount != null) values.put("DifferenceMediaCount", DaoUtils.getXmlSafeFieldValue(4, this._differenceMediaCount)); 
/* 282 */     if (this._mediaCount != null) values.put("MediaCount", DaoUtils.getXmlSafeFieldValue(4, this._mediaCount)); 
/* 283 */     return values;
/*     */   }
/*     */ 
/*     */   
/*     */   public void setValues(Map<String, String> argValues) {
/* 288 */     super.setValues(argValues);
/* 289 */     for (Map.Entry<String, String> field : argValues.entrySet()) {
/*     */       
/* 291 */       String fieldName = field.getKey();
/* 292 */       String fieldValue = field.getValue();
/* 293 */       switch (fieldName) {
/*     */         
/*     */         case "BusinessDayDate":
/*     */           try {
/* 297 */             Object value = DaoUtils.getFieldValueForXmlString(91, fieldValue);
/* 298 */             setBusinessDayDate((Date)value);
/* 299 */           } catch (Exception ee) {
/* 300 */             throw new DtxException("An exception occurred while calling setBusinessDayDate() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "OrganizationId":
/*     */           try {
/* 306 */             Object value = DaoUtils.getFieldValueForXmlString(-5, fieldValue);
/* 307 */             setOrganizationId((Long)value);
/* 308 */           } catch (Exception ee) {
/* 309 */             throw new DtxException("An exception occurred while calling setOrganizationId() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "RetailLocationId":
/*     */           try {
/* 315 */             Object value = DaoUtils.getFieldValueForXmlString(-5, fieldValue);
/* 316 */             setRetailLocationId((Long)value);
/* 317 */           } catch (Exception ee) {
/* 318 */             throw new DtxException("An exception occurred while calling setRetailLocationId() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "TenderTypeCode":
/*     */           try {
/* 324 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 325 */             setTenderTypeCode((String)value);
/* 326 */           } catch (Exception ee) {
/* 327 */             throw new DtxException("An exception occurred while calling setTenderTypeCode() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "TransactionSequence":
/*     */           try {
/* 333 */             Object value = DaoUtils.getFieldValueForXmlString(-5, fieldValue);
/* 334 */             setTransactionSequence((Long)value);
/* 335 */           } catch (Exception ee) {
/* 336 */             throw new DtxException("An exception occurred while calling setTransactionSequence() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "WorkstationId":
/*     */           try {
/* 342 */             Object value = DaoUtils.getFieldValueForXmlString(-5, fieldValue);
/* 343 */             setWorkstationId((Long)value);
/* 344 */           } catch (Exception ee) {
/* 345 */             throw new DtxException("An exception occurred while calling setWorkstationId() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "CreateDate":
/*     */           try {
/* 351 */             Object value = DaoUtils.getFieldValueForXmlString(91, fieldValue);
/* 352 */             setCreateDate((Date)value);
/* 353 */           } catch (Exception ee) {
/* 354 */             throw new DtxException("An exception occurred while calling setCreateDate() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "CreateUserId":
/*     */           try {
/* 360 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 361 */             setCreateUserId((String)value);
/* 362 */           } catch (Exception ee) {
/* 363 */             throw new DtxException("An exception occurred while calling setCreateUserId() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "UpdateDate":
/*     */           try {
/* 369 */             Object value = DaoUtils.getFieldValueForXmlString(91, fieldValue);
/* 370 */             setUpdateDate((Date)value);
/* 371 */           } catch (Exception ee) {
/* 372 */             throw new DtxException("An exception occurred while calling setUpdateDate() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "UpdateUserId":
/*     */           try {
/* 378 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 379 */             setUpdateUserId((String)value);
/* 380 */           } catch (Exception ee) {
/* 381 */             throw new DtxException("An exception occurred while calling setUpdateUserId() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "Amount":
/*     */           try {
/* 387 */             Object value = DaoUtils.getFieldValueForXmlString(3, fieldValue);
/* 388 */             setAmount((BigDecimal)value);
/* 389 */           } catch (Exception ee) {
/* 390 */             throw new DtxException("An exception occurred while calling setAmount() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "DifferenceAmount":
/*     */           try {
/* 396 */             Object value = DaoUtils.getFieldValueForXmlString(3, fieldValue);
/* 397 */             setDifferenceAmount((BigDecimal)value);
/* 398 */           } catch (Exception ee) {
/* 399 */             throw new DtxException("An exception occurred while calling setDifferenceAmount() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "DifferenceMediaCount":
/*     */           try {
/* 405 */             Object value = DaoUtils.getFieldValueForXmlString(4, fieldValue);
/* 406 */             setDifferenceMediaCount((Integer)value);
/* 407 */           } catch (Exception ee) {
/* 408 */             throw new DtxException("An exception occurred while calling setDifferenceMediaCount() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "MediaCount":
/*     */           try {
/* 414 */             Object value = DaoUtils.getFieldValueForXmlString(4, fieldValue);
/* 415 */             setMediaCount((Integer)value);
/* 416 */           } catch (Exception ee) {
/* 417 */             throw new DtxException("An exception occurred while calling setMediaCount() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */       } 
/*     */     } 
/*     */   }
/*     */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\tsn\impl\TenderTypeCountDAO.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */