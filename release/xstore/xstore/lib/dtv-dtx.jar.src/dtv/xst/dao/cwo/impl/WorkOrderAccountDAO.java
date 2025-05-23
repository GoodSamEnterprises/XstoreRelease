/*     */ package dtv.xst.dao.cwo.impl;
/*     */ 
/*     */ import dtv.data2.access.DaoUtils;
/*     */ import dtv.data2.access.exception.DtxException;
/*     */ import dtv.util.DtvDate;
/*     */ import dtv.xst.dao.cat.impl.CustomerItemAccountDAO;
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
/*     */ 
/*     */ 
/*     */ public class WorkOrderAccountDAO
/*     */   extends CustomerItemAccountDAO
/*     */ {
/*     */   private static final long serialVersionUID = -588729136L;
/*  23 */   private static final Logger _logger = Logger.getLogger(WorkOrderAccountDAO.class);
/*     */   
/*     */   private DtvDate _createDate;
/*     */   private String _createUserId;
/*     */   private DtvDate _updateDate;
/*     */   private String _updateUserId;
/*     */   private BigDecimal _totalValueDao;
/*     */   private DtvDate _estimatedCompletionDate;
/*     */   private BigDecimal _approvedWorkAmount;
/*     */   private DtvDate _approvedWorkDate;
/*     */   private DtvDate _lastCustomerNoticeDate;
/*     */   private String _contactMethodCode;
/*     */   private String _priorityCode;
/*     */   private String _serviceLocationId;
/*     */   private String _categoryId;
/*     */   private String _priceCodeString;
/*     */   private BigDecimal _cost;
/*     */   private String _invoiceNumber;
/*     */   
/*     */   public Date getCreateDate() {
/*  43 */     return (Date)this._createDate;
/*     */   }
/*     */   
/*     */   public void setCreateDate(Date argCreateDate) {
/*  47 */     if (changed(argCreateDate, this._createDate, "createDate")) {
/*  48 */       this._createDate = (argCreateDate == null || argCreateDate instanceof DtvDate) ? (DtvDate)argCreateDate : new DtvDate(argCreateDate);
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public String getCreateUserId() {
/*  54 */     return this._createUserId;
/*     */   }
/*     */   
/*     */   public void setCreateUserId(String argCreateUserId) {
/*  58 */     if (changed(argCreateUserId, this._createUserId, "createUserId")) {
/*  59 */       this._createUserId = argCreateUserId;
/*     */     }
/*     */   }
/*     */   
/*     */   public Date getUpdateDate() {
/*  64 */     return (Date)this._updateDate;
/*     */   }
/*     */   
/*     */   public void setUpdateDate(Date argUpdateDate) {
/*  68 */     if (changed(argUpdateDate, this._updateDate, "updateDate")) {
/*  69 */       this._updateDate = (argUpdateDate == null || argUpdateDate instanceof DtvDate) ? (DtvDate)argUpdateDate : new DtvDate(argUpdateDate);
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public String getUpdateUserId() {
/*  75 */     return this._updateUserId;
/*     */   }
/*     */   
/*     */   public void setUpdateUserId(String argUpdateUserId) {
/*  79 */     if (changed(argUpdateUserId, this._updateUserId, "updateUserId")) {
/*  80 */       this._updateUserId = argUpdateUserId;
/*     */     }
/*     */   }
/*     */   
/*     */   public BigDecimal getTotalValueDao() {
/*  85 */     return this._totalValueDao;
/*     */   }
/*     */   
/*     */   public void setTotalValueDao(BigDecimal argTotalValueDao) {
/*  89 */     if (changed(argTotalValueDao, this._totalValueDao, "totalValueDao")) {
/*  90 */       this._totalValueDao = argTotalValueDao;
/*     */     }
/*     */   }
/*     */   
/*     */   public Date getEstimatedCompletionDate() {
/*  95 */     return (Date)this._estimatedCompletionDate;
/*     */   }
/*     */   
/*     */   public void setEstimatedCompletionDate(Date argEstimatedCompletionDate) {
/*  99 */     if (changed(argEstimatedCompletionDate, this._estimatedCompletionDate, "estimatedCompletionDate")) {
/* 100 */       this._estimatedCompletionDate = (argEstimatedCompletionDate == null || argEstimatedCompletionDate instanceof DtvDate) ? (DtvDate)argEstimatedCompletionDate : new DtvDate(argEstimatedCompletionDate);
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public BigDecimal getApprovedWorkAmount() {
/* 106 */     return this._approvedWorkAmount;
/*     */   }
/*     */   
/*     */   public void setApprovedWorkAmount(BigDecimal argApprovedWorkAmount) {
/* 110 */     if (changed(argApprovedWorkAmount, this._approvedWorkAmount, "approvedWorkAmount")) {
/* 111 */       this._approvedWorkAmount = argApprovedWorkAmount;
/*     */     }
/*     */   }
/*     */   
/*     */   public Date getApprovedWorkDate() {
/* 116 */     return (Date)this._approvedWorkDate;
/*     */   }
/*     */   
/*     */   public void setApprovedWorkDate(Date argApprovedWorkDate) {
/* 120 */     if (changed(argApprovedWorkDate, this._approvedWorkDate, "approvedWorkDate")) {
/* 121 */       this._approvedWorkDate = (argApprovedWorkDate == null || argApprovedWorkDate instanceof DtvDate) ? (DtvDate)argApprovedWorkDate : new DtvDate(argApprovedWorkDate);
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public Date getLastCustomerNoticeDate() {
/* 127 */     return (Date)this._lastCustomerNoticeDate;
/*     */   }
/*     */   
/*     */   public void setLastCustomerNoticeDate(Date argLastCustomerNoticeDate) {
/* 131 */     if (changed(argLastCustomerNoticeDate, this._lastCustomerNoticeDate, "lastCustomerNoticeDate")) {
/* 132 */       this._lastCustomerNoticeDate = (argLastCustomerNoticeDate == null || argLastCustomerNoticeDate instanceof DtvDate) ? (DtvDate)argLastCustomerNoticeDate : new DtvDate(argLastCustomerNoticeDate);
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public String getContactMethodCode() {
/* 138 */     return this._contactMethodCode;
/*     */   }
/*     */   
/*     */   public void setContactMethodCode(String argContactMethodCode) {
/* 142 */     if (changed(argContactMethodCode, this._contactMethodCode, "contactMethodCode")) {
/* 143 */       this._contactMethodCode = argContactMethodCode;
/*     */     }
/*     */   }
/*     */   
/*     */   public String getPriorityCode() {
/* 148 */     return this._priorityCode;
/*     */   }
/*     */   
/*     */   public void setPriorityCode(String argPriorityCode) {
/* 152 */     if (changed(argPriorityCode, this._priorityCode, "priorityCode")) {
/* 153 */       this._priorityCode = argPriorityCode;
/*     */     }
/*     */   }
/*     */   
/*     */   public String getServiceLocationId() {
/* 158 */     return this._serviceLocationId;
/*     */   }
/*     */   
/*     */   public void setServiceLocationId(String argServiceLocationId) {
/* 162 */     if (changed(argServiceLocationId, this._serviceLocationId, "serviceLocationId")) {
/* 163 */       this._serviceLocationId = argServiceLocationId;
/*     */     }
/*     */   }
/*     */   
/*     */   public String getCategoryId() {
/* 168 */     return this._categoryId;
/*     */   }
/*     */   
/*     */   public void setCategoryId(String argCategoryId) {
/* 172 */     if (changed(argCategoryId, this._categoryId, "categoryId")) {
/* 173 */       this._categoryId = argCategoryId;
/*     */     }
/*     */   }
/*     */   
/*     */   public String getPriceCodeString() {
/* 178 */     return this._priceCodeString;
/*     */   }
/*     */   
/*     */   public void setPriceCodeString(String argPriceCodeString) {
/* 182 */     if (changed(argPriceCodeString, this._priceCodeString, "priceCodeString")) {
/* 183 */       this._priceCodeString = argPriceCodeString;
/*     */     }
/*     */   }
/*     */   
/*     */   public BigDecimal getCost() {
/* 188 */     return this._cost;
/*     */   }
/*     */   
/*     */   public void setCost(BigDecimal argCost) {
/* 192 */     if (changed(argCost, this._cost, "cost")) {
/* 193 */       this._cost = argCost;
/*     */     }
/*     */   }
/*     */   
/*     */   public String getInvoiceNumber() {
/* 198 */     return this._invoiceNumber;
/*     */   }
/*     */   
/*     */   public void setInvoiceNumber(String argInvoiceNumber) {
/* 202 */     if (changed(argInvoiceNumber, this._invoiceNumber, "invoiceNumber")) {
/* 203 */       this._invoiceNumber = argInvoiceNumber;
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public String toString() {
/* 210 */     StringBuilder buf = new StringBuilder(512);
/* 211 */     buf.append(super.toString());
/* 212 */     if (getCreateDate() != null) {
/* 213 */       buf.append("createDate").append("=").append(getCreateDate()).append(" ");
/*     */     }
/* 215 */     if (getCreateUserId() != null) {
/* 216 */       buf.append("createUserId").append("=").append(getCreateUserId()).append(" ");
/*     */     }
/* 218 */     if (getUpdateDate() != null) {
/* 219 */       buf.append("updateDate").append("=").append(getUpdateDate()).append(" ");
/*     */     }
/* 221 */     if (getUpdateUserId() != null) {
/* 222 */       buf.append("updateUserId").append("=").append(getUpdateUserId()).append(" ");
/*     */     }
/* 224 */     if (getTotalValueDao() != null) {
/* 225 */       buf.append("totalValueDao").append("=").append(getTotalValueDao()).append(" ");
/*     */     }
/* 227 */     if (getEstimatedCompletionDate() != null) {
/* 228 */       buf.append("estimatedCompletionDate").append("=").append(getEstimatedCompletionDate()).append(" ");
/*     */     }
/* 230 */     if (getApprovedWorkAmount() != null) {
/* 231 */       buf.append("approvedWorkAmount").append("=").append(getApprovedWorkAmount()).append(" ");
/*     */     }
/* 233 */     if (getApprovedWorkDate() != null) {
/* 234 */       buf.append("approvedWorkDate").append("=").append(getApprovedWorkDate()).append(" ");
/*     */     }
/* 236 */     if (getLastCustomerNoticeDate() != null) {
/* 237 */       buf.append("lastCustomerNoticeDate").append("=").append(getLastCustomerNoticeDate()).append(" ");
/*     */     }
/* 239 */     if (getContactMethodCode() != null) {
/* 240 */       buf.append("contactMethodCode").append("=").append(getContactMethodCode()).append(" ");
/*     */     }
/* 242 */     if (getPriorityCode() != null) {
/* 243 */       buf.append("priorityCode").append("=").append(getPriorityCode()).append(" ");
/*     */     }
/* 245 */     if (getServiceLocationId() != null) {
/* 246 */       buf.append("serviceLocationId").append("=").append(getServiceLocationId()).append(" ");
/*     */     }
/* 248 */     if (getCategoryId() != null) {
/* 249 */       buf.append("categoryId").append("=").append(getCategoryId()).append(" ");
/*     */     }
/* 251 */     if (getPriceCodeString() != null) {
/* 252 */       buf.append("priceCodeString").append("=").append(getPriceCodeString()).append(" ");
/*     */     }
/* 254 */     if (getCost() != null) {
/* 255 */       buf.append("cost").append("=").append(getCost()).append(" ");
/*     */     }
/* 257 */     if (getInvoiceNumber() != null) {
/* 258 */       buf.append("invoiceNumber").append("=").append(getInvoiceNumber()).append(" ");
/*     */     }
/*     */     
/* 261 */     return buf.toString();
/*     */   }
/*     */ 
/*     */   
/*     */   public String toXmlString() {
/* 266 */     StringBuilder buf = new StringBuilder(2050);
/* 267 */     buf.append("<").append("dao").append(" name=\"WorkOrderAccount\" cmd=\"" + getObjectStateString() + "\">");
/* 268 */     getFieldsAsXml(buf);
/* 269 */     buf.append("</").append("dao").append(">");
/*     */     
/* 271 */     return buf.toString();
/*     */   }
/*     */   
/*     */   public Map<String, String> getValues() {
/* 275 */     Map<String, String> values = super.getValues();
/* 276 */     if (this._createDate != null) values.put("CreateDate", DaoUtils.getXmlSafeFieldValue(91, this._createDate)); 
/* 277 */     if (this._createUserId != null) values.put("CreateUserId", DaoUtils.getXmlSafeFieldValue(12, this._createUserId)); 
/* 278 */     if (this._updateDate != null) values.put("UpdateDate", DaoUtils.getXmlSafeFieldValue(91, this._updateDate)); 
/* 279 */     if (this._updateUserId != null) values.put("UpdateUserId", DaoUtils.getXmlSafeFieldValue(12, this._updateUserId)); 
/* 280 */     if (this._totalValueDao != null) values.put("TotalValueDao", DaoUtils.getXmlSafeFieldValue(3, this._totalValueDao)); 
/* 281 */     if (this._estimatedCompletionDate != null) values.put("EstimatedCompletionDate", DaoUtils.getXmlSafeFieldValue(91, this._estimatedCompletionDate)); 
/* 282 */     if (this._approvedWorkAmount != null) values.put("ApprovedWorkAmount", DaoUtils.getXmlSafeFieldValue(3, this._approvedWorkAmount)); 
/* 283 */     if (this._approvedWorkDate != null) values.put("ApprovedWorkDate", DaoUtils.getXmlSafeFieldValue(91, this._approvedWorkDate)); 
/* 284 */     if (this._lastCustomerNoticeDate != null) values.put("LastCustomerNoticeDate", DaoUtils.getXmlSafeFieldValue(91, this._lastCustomerNoticeDate)); 
/* 285 */     if (this._contactMethodCode != null) values.put("ContactMethodCode", DaoUtils.getXmlSafeFieldValue(12, this._contactMethodCode)); 
/* 286 */     if (this._priorityCode != null) values.put("PriorityCode", DaoUtils.getXmlSafeFieldValue(12, this._priorityCode)); 
/* 287 */     if (this._serviceLocationId != null) values.put("ServiceLocationId", DaoUtils.getXmlSafeFieldValue(12, this._serviceLocationId)); 
/* 288 */     if (this._categoryId != null) values.put("CategoryId", DaoUtils.getXmlSafeFieldValue(12, this._categoryId)); 
/* 289 */     if (this._priceCodeString != null) values.put("PriceCodeString", DaoUtils.getXmlSafeFieldValue(12, this._priceCodeString)); 
/* 290 */     if (this._cost != null) values.put("Cost", DaoUtils.getXmlSafeFieldValue(3, this._cost)); 
/* 291 */     if (this._invoiceNumber != null) values.put("InvoiceNumber", DaoUtils.getXmlSafeFieldValue(12, this._invoiceNumber)); 
/* 292 */     return values;
/*     */   }
/*     */ 
/*     */   
/*     */   public void setValues(Map<String, String> argValues) {
/* 297 */     super.setValues(argValues);
/* 298 */     for (Map.Entry<String, String> field : argValues.entrySet()) {
/*     */       
/* 300 */       String fieldName = field.getKey();
/* 301 */       String fieldValue = field.getValue();
/* 302 */       switch (fieldName) {
/*     */         
/*     */         case "CreateDate":
/*     */           try {
/* 306 */             Object value = DaoUtils.getFieldValueForXmlString(91, fieldValue);
/* 307 */             setCreateDate((Date)value);
/* 308 */           } catch (Exception ee) {
/* 309 */             throw new DtxException("An exception occurred while calling setCreateDate() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "CreateUserId":
/*     */           try {
/* 315 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 316 */             setCreateUserId((String)value);
/* 317 */           } catch (Exception ee) {
/* 318 */             throw new DtxException("An exception occurred while calling setCreateUserId() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "UpdateDate":
/*     */           try {
/* 324 */             Object value = DaoUtils.getFieldValueForXmlString(91, fieldValue);
/* 325 */             setUpdateDate((Date)value);
/* 326 */           } catch (Exception ee) {
/* 327 */             throw new DtxException("An exception occurred while calling setUpdateDate() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "UpdateUserId":
/*     */           try {
/* 333 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 334 */             setUpdateUserId((String)value);
/* 335 */           } catch (Exception ee) {
/* 336 */             throw new DtxException("An exception occurred while calling setUpdateUserId() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "TotalValueDao":
/*     */           try {
/* 342 */             Object value = DaoUtils.getFieldValueForXmlString(3, fieldValue);
/* 343 */             setTotalValueDao((BigDecimal)value);
/* 344 */           } catch (Exception ee) {
/* 345 */             throw new DtxException("An exception occurred while calling setTotalValueDao() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "EstimatedCompletionDate":
/*     */           try {
/* 351 */             Object value = DaoUtils.getFieldValueForXmlString(91, fieldValue);
/* 352 */             setEstimatedCompletionDate((Date)value);
/* 353 */           } catch (Exception ee) {
/* 354 */             throw new DtxException("An exception occurred while calling setEstimatedCompletionDate() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "ApprovedWorkAmount":
/*     */           try {
/* 360 */             Object value = DaoUtils.getFieldValueForXmlString(3, fieldValue);
/* 361 */             setApprovedWorkAmount((BigDecimal)value);
/* 362 */           } catch (Exception ee) {
/* 363 */             throw new DtxException("An exception occurred while calling setApprovedWorkAmount() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "ApprovedWorkDate":
/*     */           try {
/* 369 */             Object value = DaoUtils.getFieldValueForXmlString(91, fieldValue);
/* 370 */             setApprovedWorkDate((Date)value);
/* 371 */           } catch (Exception ee) {
/* 372 */             throw new DtxException("An exception occurred while calling setApprovedWorkDate() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "LastCustomerNoticeDate":
/*     */           try {
/* 378 */             Object value = DaoUtils.getFieldValueForXmlString(91, fieldValue);
/* 379 */             setLastCustomerNoticeDate((Date)value);
/* 380 */           } catch (Exception ee) {
/* 381 */             throw new DtxException("An exception occurred while calling setLastCustomerNoticeDate() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "ContactMethodCode":
/*     */           try {
/* 387 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 388 */             setContactMethodCode((String)value);
/* 389 */           } catch (Exception ee) {
/* 390 */             throw new DtxException("An exception occurred while calling setContactMethodCode() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "PriorityCode":
/*     */           try {
/* 396 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 397 */             setPriorityCode((String)value);
/* 398 */           } catch (Exception ee) {
/* 399 */             throw new DtxException("An exception occurred while calling setPriorityCode() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "ServiceLocationId":
/*     */           try {
/* 405 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 406 */             setServiceLocationId((String)value);
/* 407 */           } catch (Exception ee) {
/* 408 */             throw new DtxException("An exception occurred while calling setServiceLocationId() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "CategoryId":
/*     */           try {
/* 414 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 415 */             setCategoryId((String)value);
/* 416 */           } catch (Exception ee) {
/* 417 */             throw new DtxException("An exception occurred while calling setCategoryId() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "PriceCodeString":
/*     */           try {
/* 423 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 424 */             setPriceCodeString((String)value);
/* 425 */           } catch (Exception ee) {
/* 426 */             throw new DtxException("An exception occurred while calling setPriceCodeString() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "Cost":
/*     */           try {
/* 432 */             Object value = DaoUtils.getFieldValueForXmlString(3, fieldValue);
/* 433 */             setCost((BigDecimal)value);
/* 434 */           } catch (Exception ee) {
/* 435 */             throw new DtxException("An exception occurred while calling setCost() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "InvoiceNumber":
/*     */           try {
/* 441 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 442 */             setInvoiceNumber((String)value);
/* 443 */           } catch (Exception ee) {
/* 444 */             throw new DtxException("An exception occurred while calling setInvoiceNumber() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */       } 
/*     */     } 
/*     */   }
/*     */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\cwo\impl\WorkOrderAccountDAO.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */