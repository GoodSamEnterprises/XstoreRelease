/*     */ package dtv.xst.dao.cat.impl;
/*     */ 
/*     */ import dtv.data2.access.DaoUtils;
/*     */ import dtv.data2.access.IObjectId;
/*     */ import dtv.data2.access.exception.DtxException;
/*     */ import dtv.data2.access.impl.AbstractDAOImpl;
/*     */ import dtv.util.DtvDate;
/*     */ import dtv.xst.dao.cat.CustomerAccountAuthorizationId;
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
/*     */ public class CustomerAccountAuthorizationDAO
/*     */   extends AbstractDAOImpl
/*     */ {
/*     */   private static final long serialVersionUID = -1099471766L;
/*  23 */   private static final Logger _logger = Logger.getLogger(CustomerAccountAuthorizationDAO.class);
/*     */   
/*     */   private Long _organizationId;
/*     */   private Integer _retailTransactionLineItemSequence;
/*     */   private Long _retailLocationId;
/*     */   private Long _workstationId;
/*     */   private DtvDate _businessDate;
/*     */   private Long _transactionSequence;
/*     */   private DtvDate _createDate;
/*     */   private String _createUserId;
/*     */   private DtvDate _updateDate;
/*     */   private String _updateUserId;
/*     */   private String _statusCode;
/*     */   private DtvDate _statusDatetime;
/*     */   private String _authorizationType;
/*     */   
/*     */   public Long getOrganizationId() {
/*  40 */     return this._organizationId;
/*     */   }
/*     */   
/*     */   public void setOrganizationId(Long argOrganizationId) {
/*  44 */     if (changed(argOrganizationId, this._organizationId, "organizationId")) {
/*  45 */       this._organizationId = argOrganizationId;
/*     */     }
/*     */   }
/*     */   
/*     */   public Integer getRetailTransactionLineItemSequence() {
/*  50 */     return this._retailTransactionLineItemSequence;
/*     */   }
/*     */   
/*     */   public void setRetailTransactionLineItemSequence(Integer argRetailTransactionLineItemSequence) {
/*  54 */     if (changed(argRetailTransactionLineItemSequence, this._retailTransactionLineItemSequence, "retailTransactionLineItemSequence")) {
/*  55 */       this._retailTransactionLineItemSequence = argRetailTransactionLineItemSequence;
/*     */     }
/*     */   }
/*     */   
/*     */   public Long getRetailLocationId() {
/*  60 */     return this._retailLocationId;
/*     */   }
/*     */   
/*     */   public void setRetailLocationId(Long argRetailLocationId) {
/*  64 */     if (changed(argRetailLocationId, this._retailLocationId, "retailLocationId")) {
/*  65 */       this._retailLocationId = argRetailLocationId;
/*     */     }
/*     */   }
/*     */   
/*     */   public Long getWorkstationId() {
/*  70 */     return this._workstationId;
/*     */   }
/*     */   
/*     */   public void setWorkstationId(Long argWorkstationId) {
/*  74 */     if (changed(argWorkstationId, this._workstationId, "workstationId")) {
/*  75 */       this._workstationId = argWorkstationId;
/*     */     }
/*     */   }
/*     */   
/*     */   public Date getBusinessDate() {
/*  80 */     return (Date)this._businessDate;
/*     */   }
/*     */   
/*     */   public void setBusinessDate(Date argBusinessDate) {
/*  84 */     if (changed(argBusinessDate, this._businessDate, "businessDate")) {
/*  85 */       this._businessDate = (argBusinessDate == null || argBusinessDate instanceof DtvDate) ? (DtvDate)argBusinessDate : new DtvDate(argBusinessDate);
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public Long getTransactionSequence() {
/*  91 */     return this._transactionSequence;
/*     */   }
/*     */   
/*     */   public void setTransactionSequence(Long argTransactionSequence) {
/*  95 */     if (changed(argTransactionSequence, this._transactionSequence, "transactionSequence")) {
/*  96 */       this._transactionSequence = argTransactionSequence;
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
/*     */   public String getStatusCode() {
/* 143 */     return this._statusCode;
/*     */   }
/*     */   
/*     */   public void setStatusCode(String argStatusCode) {
/* 147 */     if (changed(argStatusCode, this._statusCode, "statusCode")) {
/* 148 */       this._statusCode = argStatusCode;
/*     */     }
/*     */   }
/*     */   
/*     */   public Date getStatusDatetime() {
/* 153 */     return (Date)this._statusDatetime;
/*     */   }
/*     */   
/*     */   public void setStatusDatetime(Date argStatusDatetime) {
/* 157 */     if (changed(argStatusDatetime, this._statusDatetime, "statusDatetime")) {
/* 158 */       this._statusDatetime = (argStatusDatetime == null || argStatusDatetime instanceof DtvDate) ? (DtvDate)argStatusDatetime : new DtvDate(argStatusDatetime);
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public String getAuthorizationType() {
/* 164 */     return this._authorizationType;
/*     */   }
/*     */   
/*     */   public void setAuthorizationType(String argAuthorizationType) {
/* 168 */     if (changed(argAuthorizationType, this._authorizationType, "authorizationType")) {
/* 169 */       this._authorizationType = argAuthorizationType;
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public String toString() {
/* 176 */     StringBuilder buf = new StringBuilder(512);
/* 177 */     buf.append(super.toString()).append(" Id: ").append(getObjectId()).append(" Values: ");
/* 178 */     if (getOrganizationId() != null) {
/* 179 */       buf.append("organizationId").append("=").append(getOrganizationId()).append(" ");
/*     */     }
/* 181 */     if (getRetailTransactionLineItemSequence() != null) {
/* 182 */       buf.append("retailTransactionLineItemSequence").append("=").append(getRetailTransactionLineItemSequence()).append(" ");
/*     */     }
/* 184 */     if (getRetailLocationId() != null) {
/* 185 */       buf.append("retailLocationId").append("=").append(getRetailLocationId()).append(" ");
/*     */     }
/* 187 */     if (getWorkstationId() != null) {
/* 188 */       buf.append("workstationId").append("=").append(getWorkstationId()).append(" ");
/*     */     }
/* 190 */     if (getBusinessDate() != null) {
/* 191 */       buf.append("businessDate").append("=").append(getBusinessDate()).append(" ");
/*     */     }
/* 193 */     if (getTransactionSequence() != null) {
/* 194 */       buf.append("transactionSequence").append("=").append(getTransactionSequence()).append(" ");
/*     */     }
/* 196 */     if (getCreateDate() != null) {
/* 197 */       buf.append("createDate").append("=").append(getCreateDate()).append(" ");
/*     */     }
/* 199 */     if (getCreateUserId() != null) {
/* 200 */       buf.append("createUserId").append("=").append(getCreateUserId()).append(" ");
/*     */     }
/* 202 */     if (getUpdateDate() != null) {
/* 203 */       buf.append("updateDate").append("=").append(getUpdateDate()).append(" ");
/*     */     }
/* 205 */     if (getUpdateUserId() != null) {
/* 206 */       buf.append("updateUserId").append("=").append(getUpdateUserId()).append(" ");
/*     */     }
/* 208 */     if (getStatusCode() != null) {
/* 209 */       buf.append("statusCode").append("=").append(getStatusCode()).append(" ");
/*     */     }
/* 211 */     if (getStatusDatetime() != null) {
/* 212 */       buf.append("statusDatetime").append("=").append(getStatusDatetime()).append(" ");
/*     */     }
/* 214 */     if (getAuthorizationType() != null) {
/* 215 */       buf.append("authorizationType").append("=").append(getAuthorizationType()).append(" ");
/*     */     }
/*     */     
/* 218 */     return buf.toString();
/*     */   }
/*     */   
/*     */   public IObjectId getObjectId() {
/* 222 */     CustomerAccountAuthorizationId id = new CustomerAccountAuthorizationId();
/* 223 */     id.setOrganizationId(getOrganizationId());
/* 224 */     id.setRetailTransactionLineItemSequence(getRetailTransactionLineItemSequence());
/* 225 */     id.setRetailLocationId(getRetailLocationId());
/* 226 */     id.setWorkstationId(getWorkstationId());
/* 227 */     id.setBusinessDate(getBusinessDate());
/* 228 */     id.setTransactionSequence(getTransactionSequence());
/* 229 */     return (IObjectId)id;
/*     */   }
/*     */   
/*     */   public void setObjectId(IObjectId argObjectId) {
/* 233 */     setOrganizationId(((CustomerAccountAuthorizationId)argObjectId).getOrganizationId());
/* 234 */     setRetailTransactionLineItemSequence(((CustomerAccountAuthorizationId)argObjectId).getRetailTransactionLineItemSequence());
/* 235 */     setRetailLocationId(((CustomerAccountAuthorizationId)argObjectId).getRetailLocationId());
/* 236 */     setWorkstationId(((CustomerAccountAuthorizationId)argObjectId).getWorkstationId());
/* 237 */     setBusinessDate(((CustomerAccountAuthorizationId)argObjectId).getBusinessDate());
/* 238 */     setTransactionSequence(((CustomerAccountAuthorizationId)argObjectId).getTransactionSequence());
/*     */   }
/*     */   
/*     */   public String getImplementingClass() {
/* 242 */     return null;
/*     */   }
/*     */   
/*     */   public String toXmlString() {
/* 246 */     StringBuilder buf = new StringBuilder(650);
/* 247 */     buf.append("<").append("dao").append(" name=\"CustomerAccountAuthorization\" cmd=\"" + getObjectStateString() + "\">");
/* 248 */     getFieldsAsXml(buf);
/* 249 */     buf.append("</").append("dao").append(">");
/*     */     
/* 251 */     return buf.toString();
/*     */   }
/*     */   
/*     */   public Map<String, String> getValues() {
/* 255 */     Map<String, String> values = super.getValues();
/* 256 */     if (this._organizationId != null) values.put("OrganizationId", DaoUtils.getXmlSafeFieldValue(-5, this._organizationId)); 
/* 257 */     if (this._retailTransactionLineItemSequence != null) values.put("RetailTransactionLineItemSequence", DaoUtils.getXmlSafeFieldValue(4, this._retailTransactionLineItemSequence)); 
/* 258 */     if (this._retailLocationId != null) values.put("RetailLocationId", DaoUtils.getXmlSafeFieldValue(-5, this._retailLocationId)); 
/* 259 */     if (this._workstationId != null) values.put("WorkstationId", DaoUtils.getXmlSafeFieldValue(-5, this._workstationId)); 
/* 260 */     if (this._businessDate != null) values.put("BusinessDate", DaoUtils.getXmlSafeFieldValue(91, this._businessDate)); 
/* 261 */     if (this._transactionSequence != null) values.put("TransactionSequence", DaoUtils.getXmlSafeFieldValue(-5, this._transactionSequence)); 
/* 262 */     if (this._createDate != null) values.put("CreateDate", DaoUtils.getXmlSafeFieldValue(91, this._createDate)); 
/* 263 */     if (this._createUserId != null) values.put("CreateUserId", DaoUtils.getXmlSafeFieldValue(12, this._createUserId)); 
/* 264 */     if (this._updateDate != null) values.put("UpdateDate", DaoUtils.getXmlSafeFieldValue(91, this._updateDate)); 
/* 265 */     if (this._updateUserId != null) values.put("UpdateUserId", DaoUtils.getXmlSafeFieldValue(12, this._updateUserId)); 
/* 266 */     if (this._statusCode != null) values.put("StatusCode", DaoUtils.getXmlSafeFieldValue(12, this._statusCode)); 
/* 267 */     if (this._statusDatetime != null) values.put("StatusDatetime", DaoUtils.getXmlSafeFieldValue(91, this._statusDatetime)); 
/* 268 */     if (this._authorizationType != null) values.put("AuthorizationType", DaoUtils.getXmlSafeFieldValue(12, this._authorizationType)); 
/* 269 */     return values;
/*     */   }
/*     */ 
/*     */   
/*     */   public void setValues(Map<String, String> argValues) {
/* 274 */     super.setValues(argValues);
/* 275 */     for (Map.Entry<String, String> field : argValues.entrySet()) {
/*     */       
/* 277 */       String fieldName = field.getKey();
/* 278 */       String fieldValue = field.getValue();
/* 279 */       switch (fieldName) {
/*     */         
/*     */         case "OrganizationId":
/*     */           try {
/* 283 */             Object value = DaoUtils.getFieldValueForXmlString(-5, fieldValue);
/* 284 */             setOrganizationId((Long)value);
/* 285 */           } catch (Exception ee) {
/* 286 */             throw new DtxException("An exception occurred while calling setOrganizationId() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "RetailTransactionLineItemSequence":
/*     */           try {
/* 292 */             Object value = DaoUtils.getFieldValueForXmlString(4, fieldValue);
/* 293 */             setRetailTransactionLineItemSequence((Integer)value);
/* 294 */           } catch (Exception ee) {
/* 295 */             throw new DtxException("An exception occurred while calling setRetailTransactionLineItemSequence() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "RetailLocationId":
/*     */           try {
/* 301 */             Object value = DaoUtils.getFieldValueForXmlString(-5, fieldValue);
/* 302 */             setRetailLocationId((Long)value);
/* 303 */           } catch (Exception ee) {
/* 304 */             throw new DtxException("An exception occurred while calling setRetailLocationId() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "WorkstationId":
/*     */           try {
/* 310 */             Object value = DaoUtils.getFieldValueForXmlString(-5, fieldValue);
/* 311 */             setWorkstationId((Long)value);
/* 312 */           } catch (Exception ee) {
/* 313 */             throw new DtxException("An exception occurred while calling setWorkstationId() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "BusinessDate":
/*     */           try {
/* 319 */             Object value = DaoUtils.getFieldValueForXmlString(91, fieldValue);
/* 320 */             setBusinessDate((Date)value);
/* 321 */           } catch (Exception ee) {
/* 322 */             throw new DtxException("An exception occurred while calling setBusinessDate() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "TransactionSequence":
/*     */           try {
/* 328 */             Object value = DaoUtils.getFieldValueForXmlString(-5, fieldValue);
/* 329 */             setTransactionSequence((Long)value);
/* 330 */           } catch (Exception ee) {
/* 331 */             throw new DtxException("An exception occurred while calling setTransactionSequence() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "CreateDate":
/*     */           try {
/* 337 */             Object value = DaoUtils.getFieldValueForXmlString(91, fieldValue);
/* 338 */             setCreateDate((Date)value);
/* 339 */           } catch (Exception ee) {
/* 340 */             throw new DtxException("An exception occurred while calling setCreateDate() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "CreateUserId":
/*     */           try {
/* 346 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 347 */             setCreateUserId((String)value);
/* 348 */           } catch (Exception ee) {
/* 349 */             throw new DtxException("An exception occurred while calling setCreateUserId() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "UpdateDate":
/*     */           try {
/* 355 */             Object value = DaoUtils.getFieldValueForXmlString(91, fieldValue);
/* 356 */             setUpdateDate((Date)value);
/* 357 */           } catch (Exception ee) {
/* 358 */             throw new DtxException("An exception occurred while calling setUpdateDate() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "UpdateUserId":
/*     */           try {
/* 364 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 365 */             setUpdateUserId((String)value);
/* 366 */           } catch (Exception ee) {
/* 367 */             throw new DtxException("An exception occurred while calling setUpdateUserId() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "StatusCode":
/*     */           try {
/* 373 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 374 */             setStatusCode((String)value);
/* 375 */           } catch (Exception ee) {
/* 376 */             throw new DtxException("An exception occurred while calling setStatusCode() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "StatusDatetime":
/*     */           try {
/* 382 */             Object value = DaoUtils.getFieldValueForXmlString(91, fieldValue);
/* 383 */             setStatusDatetime((Date)value);
/* 384 */           } catch (Exception ee) {
/* 385 */             throw new DtxException("An exception occurred while calling setStatusDatetime() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "AuthorizationType":
/*     */           try {
/* 391 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 392 */             setAuthorizationType((String)value);
/* 393 */           } catch (Exception ee) {
/* 394 */             throw new DtxException("An exception occurred while calling setAuthorizationType() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */       } 
/*     */     } 
/*     */   }
/*     */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\cat\impl\CustomerAccountAuthorizationDAO.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */