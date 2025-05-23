/*     */ package dtv.xst.dao.cwo.impl;
/*     */ 
/*     */ import dtv.data2.access.DaoUtils;
/*     */ import dtv.data2.access.exception.DtxException;
/*     */ import dtv.util.DtvDate;
/*     */ import dtv.xst.dao.cat.impl.CustomerItemAccountJournalDAO;
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
/*     */ public class WorkOrderAccountJournalDAO
/*     */   extends CustomerItemAccountJournalDAO
/*     */ {
/*     */   private static final long serialVersionUID = 389449799L;
/*  23 */   private static final Logger _logger = Logger.getLogger(WorkOrderAccountJournalDAO.class);
/*     */   
/*     */   private DtvDate _createDate;
/*     */   private String _createUserId;
/*     */   private DtvDate _updateDate;
/*     */   private String _updateUserId;
/*     */   private BigDecimal _totalValue;
/*     */   private DtvDate _estimatedCompletionDate;
/*     */   private BigDecimal _approvedWorkAmount;
/*     */   private DtvDate _approvedWorkDate;
/*     */   private String _priorityCode;
/*     */   private String _contactMethod;
/*     */   private DtvDate _lastCustomerNoticeDate;
/*     */   private String _categoryId;
/*     */   private String _serviceLocationId;
/*     */   private String _priceCodeString;
/*     */   
/*     */   public Date getCreateDate() {
/*  41 */     return (Date)this._createDate;
/*     */   }
/*     */   
/*     */   public void setCreateDate(Date argCreateDate) {
/*  45 */     if (changed(argCreateDate, this._createDate, "createDate")) {
/*  46 */       this._createDate = (argCreateDate == null || argCreateDate instanceof DtvDate) ? (DtvDate)argCreateDate : new DtvDate(argCreateDate);
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public String getCreateUserId() {
/*  52 */     return this._createUserId;
/*     */   }
/*     */   
/*     */   public void setCreateUserId(String argCreateUserId) {
/*  56 */     if (changed(argCreateUserId, this._createUserId, "createUserId")) {
/*  57 */       this._createUserId = argCreateUserId;
/*     */     }
/*     */   }
/*     */   
/*     */   public Date getUpdateDate() {
/*  62 */     return (Date)this._updateDate;
/*     */   }
/*     */   
/*     */   public void setUpdateDate(Date argUpdateDate) {
/*  66 */     if (changed(argUpdateDate, this._updateDate, "updateDate")) {
/*  67 */       this._updateDate = (argUpdateDate == null || argUpdateDate instanceof DtvDate) ? (DtvDate)argUpdateDate : new DtvDate(argUpdateDate);
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public String getUpdateUserId() {
/*  73 */     return this._updateUserId;
/*     */   }
/*     */   
/*     */   public void setUpdateUserId(String argUpdateUserId) {
/*  77 */     if (changed(argUpdateUserId, this._updateUserId, "updateUserId")) {
/*  78 */       this._updateUserId = argUpdateUserId;
/*     */     }
/*     */   }
/*     */   
/*     */   public BigDecimal getTotalValue() {
/*  83 */     return this._totalValue;
/*     */   }
/*     */   
/*     */   public void setTotalValue(BigDecimal argTotalValue) {
/*  87 */     if (changed(argTotalValue, this._totalValue, "totalValue")) {
/*  88 */       this._totalValue = argTotalValue;
/*     */     }
/*     */   }
/*     */   
/*     */   public Date getEstimatedCompletionDate() {
/*  93 */     return (Date)this._estimatedCompletionDate;
/*     */   }
/*     */   
/*     */   public void setEstimatedCompletionDate(Date argEstimatedCompletionDate) {
/*  97 */     if (changed(argEstimatedCompletionDate, this._estimatedCompletionDate, "estimatedCompletionDate")) {
/*  98 */       this._estimatedCompletionDate = (argEstimatedCompletionDate == null || argEstimatedCompletionDate instanceof DtvDate) ? (DtvDate)argEstimatedCompletionDate : new DtvDate(argEstimatedCompletionDate);
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public BigDecimal getApprovedWorkAmount() {
/* 104 */     return this._approvedWorkAmount;
/*     */   }
/*     */   
/*     */   public void setApprovedWorkAmount(BigDecimal argApprovedWorkAmount) {
/* 108 */     if (changed(argApprovedWorkAmount, this._approvedWorkAmount, "approvedWorkAmount")) {
/* 109 */       this._approvedWorkAmount = argApprovedWorkAmount;
/*     */     }
/*     */   }
/*     */   
/*     */   public Date getApprovedWorkDate() {
/* 114 */     return (Date)this._approvedWorkDate;
/*     */   }
/*     */   
/*     */   public void setApprovedWorkDate(Date argApprovedWorkDate) {
/* 118 */     if (changed(argApprovedWorkDate, this._approvedWorkDate, "approvedWorkDate")) {
/* 119 */       this._approvedWorkDate = (argApprovedWorkDate == null || argApprovedWorkDate instanceof DtvDate) ? (DtvDate)argApprovedWorkDate : new DtvDate(argApprovedWorkDate);
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public String getPriorityCode() {
/* 125 */     return this._priorityCode;
/*     */   }
/*     */   
/*     */   public void setPriorityCode(String argPriorityCode) {
/* 129 */     if (changed(argPriorityCode, this._priorityCode, "priorityCode")) {
/* 130 */       this._priorityCode = argPriorityCode;
/*     */     }
/*     */   }
/*     */   
/*     */   public String getContactMethod() {
/* 135 */     return this._contactMethod;
/*     */   }
/*     */   
/*     */   public void setContactMethod(String argContactMethod) {
/* 139 */     if (changed(argContactMethod, this._contactMethod, "contactMethod")) {
/* 140 */       this._contactMethod = argContactMethod;
/*     */     }
/*     */   }
/*     */   
/*     */   public Date getLastCustomerNoticeDate() {
/* 145 */     return (Date)this._lastCustomerNoticeDate;
/*     */   }
/*     */   
/*     */   public void setLastCustomerNoticeDate(Date argLastCustomerNoticeDate) {
/* 149 */     if (changed(argLastCustomerNoticeDate, this._lastCustomerNoticeDate, "lastCustomerNoticeDate")) {
/* 150 */       this._lastCustomerNoticeDate = (argLastCustomerNoticeDate == null || argLastCustomerNoticeDate instanceof DtvDate) ? (DtvDate)argLastCustomerNoticeDate : new DtvDate(argLastCustomerNoticeDate);
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public String getCategoryId() {
/* 156 */     return this._categoryId;
/*     */   }
/*     */   
/*     */   public void setCategoryId(String argCategoryId) {
/* 160 */     if (changed(argCategoryId, this._categoryId, "categoryId")) {
/* 161 */       this._categoryId = argCategoryId;
/*     */     }
/*     */   }
/*     */   
/*     */   public String getServiceLocationId() {
/* 166 */     return this._serviceLocationId;
/*     */   }
/*     */   
/*     */   public void setServiceLocationId(String argServiceLocationId) {
/* 170 */     if (changed(argServiceLocationId, this._serviceLocationId, "serviceLocationId")) {
/* 171 */       this._serviceLocationId = argServiceLocationId;
/*     */     }
/*     */   }
/*     */   
/*     */   public String getPriceCodeString() {
/* 176 */     return this._priceCodeString;
/*     */   }
/*     */   
/*     */   public void setPriceCodeString(String argPriceCodeString) {
/* 180 */     if (changed(argPriceCodeString, this._priceCodeString, "priceCodeString")) {
/* 181 */       this._priceCodeString = argPriceCodeString;
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public String toString() {
/* 188 */     StringBuilder buf = new StringBuilder(512);
/* 189 */     buf.append(super.toString());
/* 190 */     if (getCreateDate() != null) {
/* 191 */       buf.append("createDate").append("=").append(getCreateDate()).append(" ");
/*     */     }
/* 193 */     if (getCreateUserId() != null) {
/* 194 */       buf.append("createUserId").append("=").append(getCreateUserId()).append(" ");
/*     */     }
/* 196 */     if (getUpdateDate() != null) {
/* 197 */       buf.append("updateDate").append("=").append(getUpdateDate()).append(" ");
/*     */     }
/* 199 */     if (getUpdateUserId() != null) {
/* 200 */       buf.append("updateUserId").append("=").append(getUpdateUserId()).append(" ");
/*     */     }
/* 202 */     if (getTotalValue() != null) {
/* 203 */       buf.append("totalValue").append("=").append(getTotalValue()).append(" ");
/*     */     }
/* 205 */     if (getEstimatedCompletionDate() != null) {
/* 206 */       buf.append("estimatedCompletionDate").append("=").append(getEstimatedCompletionDate()).append(" ");
/*     */     }
/* 208 */     if (getApprovedWorkAmount() != null) {
/* 209 */       buf.append("approvedWorkAmount").append("=").append(getApprovedWorkAmount()).append(" ");
/*     */     }
/* 211 */     if (getApprovedWorkDate() != null) {
/* 212 */       buf.append("approvedWorkDate").append("=").append(getApprovedWorkDate()).append(" ");
/*     */     }
/* 214 */     if (getPriorityCode() != null) {
/* 215 */       buf.append("priorityCode").append("=").append(getPriorityCode()).append(" ");
/*     */     }
/* 217 */     if (getContactMethod() != null) {
/* 218 */       buf.append("contactMethod").append("=").append(getContactMethod()).append(" ");
/*     */     }
/* 220 */     if (getLastCustomerNoticeDate() != null) {
/* 221 */       buf.append("lastCustomerNoticeDate").append("=").append(getLastCustomerNoticeDate()).append(" ");
/*     */     }
/* 223 */     if (getCategoryId() != null) {
/* 224 */       buf.append("categoryId").append("=").append(getCategoryId()).append(" ");
/*     */     }
/* 226 */     if (getServiceLocationId() != null) {
/* 227 */       buf.append("serviceLocationId").append("=").append(getServiceLocationId()).append(" ");
/*     */     }
/* 229 */     if (getPriceCodeString() != null) {
/* 230 */       buf.append("priceCodeString").append("=").append(getPriceCodeString()).append(" ");
/*     */     }
/*     */     
/* 233 */     return buf.toString();
/*     */   }
/*     */ 
/*     */   
/*     */   public String toXmlString() {
/* 238 */     StringBuilder buf = new StringBuilder(2100);
/* 239 */     buf.append("<").append("dao").append(" name=\"WorkOrderAccountJournal\" cmd=\"" + getObjectStateString() + "\">");
/* 240 */     getFieldsAsXml(buf);
/* 241 */     buf.append("</").append("dao").append(">");
/*     */     
/* 243 */     return buf.toString();
/*     */   }
/*     */   
/*     */   public Map<String, String> getValues() {
/* 247 */     Map<String, String> values = super.getValues();
/* 248 */     if (this._createDate != null) values.put("CreateDate", DaoUtils.getXmlSafeFieldValue(91, this._createDate)); 
/* 249 */     if (this._createUserId != null) values.put("CreateUserId", DaoUtils.getXmlSafeFieldValue(12, this._createUserId)); 
/* 250 */     if (this._updateDate != null) values.put("UpdateDate", DaoUtils.getXmlSafeFieldValue(91, this._updateDate)); 
/* 251 */     if (this._updateUserId != null) values.put("UpdateUserId", DaoUtils.getXmlSafeFieldValue(12, this._updateUserId)); 
/* 252 */     if (this._totalValue != null) values.put("TotalValue", DaoUtils.getXmlSafeFieldValue(3, this._totalValue)); 
/* 253 */     if (this._estimatedCompletionDate != null) values.put("EstimatedCompletionDate", DaoUtils.getXmlSafeFieldValue(91, this._estimatedCompletionDate)); 
/* 254 */     if (this._approvedWorkAmount != null) values.put("ApprovedWorkAmount", DaoUtils.getXmlSafeFieldValue(3, this._approvedWorkAmount)); 
/* 255 */     if (this._approvedWorkDate != null) values.put("ApprovedWorkDate", DaoUtils.getXmlSafeFieldValue(91, this._approvedWorkDate)); 
/* 256 */     if (this._priorityCode != null) values.put("PriorityCode", DaoUtils.getXmlSafeFieldValue(12, this._priorityCode)); 
/* 257 */     if (this._contactMethod != null) values.put("ContactMethod", DaoUtils.getXmlSafeFieldValue(12, this._contactMethod)); 
/* 258 */     if (this._lastCustomerNoticeDate != null) values.put("LastCustomerNoticeDate", DaoUtils.getXmlSafeFieldValue(91, this._lastCustomerNoticeDate)); 
/* 259 */     if (this._categoryId != null) values.put("CategoryId", DaoUtils.getXmlSafeFieldValue(12, this._categoryId)); 
/* 260 */     if (this._serviceLocationId != null) values.put("ServiceLocationId", DaoUtils.getXmlSafeFieldValue(12, this._serviceLocationId)); 
/* 261 */     if (this._priceCodeString != null) values.put("PriceCodeString", DaoUtils.getXmlSafeFieldValue(12, this._priceCodeString)); 
/* 262 */     return values;
/*     */   }
/*     */ 
/*     */   
/*     */   public void setValues(Map<String, String> argValues) {
/* 267 */     super.setValues(argValues);
/* 268 */     for (Map.Entry<String, String> field : argValues.entrySet()) {
/*     */       
/* 270 */       String fieldName = field.getKey();
/* 271 */       String fieldValue = field.getValue();
/* 272 */       switch (fieldName) {
/*     */         
/*     */         case "CreateDate":
/*     */           try {
/* 276 */             Object value = DaoUtils.getFieldValueForXmlString(91, fieldValue);
/* 277 */             setCreateDate((Date)value);
/* 278 */           } catch (Exception ee) {
/* 279 */             throw new DtxException("An exception occurred while calling setCreateDate() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "CreateUserId":
/*     */           try {
/* 285 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 286 */             setCreateUserId((String)value);
/* 287 */           } catch (Exception ee) {
/* 288 */             throw new DtxException("An exception occurred while calling setCreateUserId() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "UpdateDate":
/*     */           try {
/* 294 */             Object value = DaoUtils.getFieldValueForXmlString(91, fieldValue);
/* 295 */             setUpdateDate((Date)value);
/* 296 */           } catch (Exception ee) {
/* 297 */             throw new DtxException("An exception occurred while calling setUpdateDate() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "UpdateUserId":
/*     */           try {
/* 303 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 304 */             setUpdateUserId((String)value);
/* 305 */           } catch (Exception ee) {
/* 306 */             throw new DtxException("An exception occurred while calling setUpdateUserId() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "TotalValue":
/*     */           try {
/* 312 */             Object value = DaoUtils.getFieldValueForXmlString(3, fieldValue);
/* 313 */             setTotalValue((BigDecimal)value);
/* 314 */           } catch (Exception ee) {
/* 315 */             throw new DtxException("An exception occurred while calling setTotalValue() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "EstimatedCompletionDate":
/*     */           try {
/* 321 */             Object value = DaoUtils.getFieldValueForXmlString(91, fieldValue);
/* 322 */             setEstimatedCompletionDate((Date)value);
/* 323 */           } catch (Exception ee) {
/* 324 */             throw new DtxException("An exception occurred while calling setEstimatedCompletionDate() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "ApprovedWorkAmount":
/*     */           try {
/* 330 */             Object value = DaoUtils.getFieldValueForXmlString(3, fieldValue);
/* 331 */             setApprovedWorkAmount((BigDecimal)value);
/* 332 */           } catch (Exception ee) {
/* 333 */             throw new DtxException("An exception occurred while calling setApprovedWorkAmount() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "ApprovedWorkDate":
/*     */           try {
/* 339 */             Object value = DaoUtils.getFieldValueForXmlString(91, fieldValue);
/* 340 */             setApprovedWorkDate((Date)value);
/* 341 */           } catch (Exception ee) {
/* 342 */             throw new DtxException("An exception occurred while calling setApprovedWorkDate() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "PriorityCode":
/*     */           try {
/* 348 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 349 */             setPriorityCode((String)value);
/* 350 */           } catch (Exception ee) {
/* 351 */             throw new DtxException("An exception occurred while calling setPriorityCode() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "ContactMethod":
/*     */           try {
/* 357 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 358 */             setContactMethod((String)value);
/* 359 */           } catch (Exception ee) {
/* 360 */             throw new DtxException("An exception occurred while calling setContactMethod() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "LastCustomerNoticeDate":
/*     */           try {
/* 366 */             Object value = DaoUtils.getFieldValueForXmlString(91, fieldValue);
/* 367 */             setLastCustomerNoticeDate((Date)value);
/* 368 */           } catch (Exception ee) {
/* 369 */             throw new DtxException("An exception occurred while calling setLastCustomerNoticeDate() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "CategoryId":
/*     */           try {
/* 375 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 376 */             setCategoryId((String)value);
/* 377 */           } catch (Exception ee) {
/* 378 */             throw new DtxException("An exception occurred while calling setCategoryId() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "ServiceLocationId":
/*     */           try {
/* 384 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 385 */             setServiceLocationId((String)value);
/* 386 */           } catch (Exception ee) {
/* 387 */             throw new DtxException("An exception occurred while calling setServiceLocationId() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "PriceCodeString":
/*     */           try {
/* 393 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 394 */             setPriceCodeString((String)value);
/* 395 */           } catch (Exception ee) {
/* 396 */             throw new DtxException("An exception occurred while calling setPriceCodeString() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */       } 
/*     */     } 
/*     */   }
/*     */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\cwo\impl\WorkOrderAccountJournalDAO.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */