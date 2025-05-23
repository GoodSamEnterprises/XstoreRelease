/*     */ package dtv.xst.dao.trl.impl;
/*     */ 
/*     */ import dtv.data2.access.DaoUtils;
/*     */ import dtv.data2.access.IObjectId;
/*     */ import dtv.data2.access.exception.DtxException;
/*     */ import dtv.data2.access.impl.AbstractDAOImpl;
/*     */ import dtv.util.DtvDate;
/*     */ import dtv.xst.dao.trl.CustomerItemAccountModifierId;
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
/*     */ public class CustomerItemAccountModifierDAO
/*     */   extends AbstractDAOImpl
/*     */ {
/*     */   private static final long serialVersionUID = 1611431859L;
/*  23 */   private static final Logger _logger = Logger.getLogger(CustomerItemAccountModifierDAO.class);
/*     */   
/*     */   private DtvDate _businessDate;
/*     */   private Long _organizationId;
/*     */   private Long _retailLocationId;
/*     */   private Integer _retailTransactionLineItemSequence;
/*     */   private Long _transactionSequence;
/*     */   private Long _workstationId;
/*     */   private DtvDate _createDate;
/*     */   private String _createUserId;
/*     */   private DtvDate _updateDate;
/*     */   private String _updateUserId;
/*     */   private String _custAccountId;
/*     */   private String _custAccountCode;
/*     */   private BigDecimal _itemAccountExtendedPrice;
/*     */   
/*     */   public Date getBusinessDate() {
/*  40 */     return (Date)this._businessDate;
/*     */   }
/*     */   
/*     */   public void setBusinessDate(Date argBusinessDate) {
/*  44 */     if (changed(argBusinessDate, this._businessDate, "businessDate")) {
/*  45 */       this._businessDate = (argBusinessDate == null || argBusinessDate instanceof DtvDate) ? (DtvDate)argBusinessDate : new DtvDate(argBusinessDate);
/*     */     }
/*     */   }
/*     */ 
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
/*     */   public Integer getRetailTransactionLineItemSequence() {
/*  71 */     return this._retailTransactionLineItemSequence;
/*     */   }
/*     */   
/*     */   public void setRetailTransactionLineItemSequence(Integer argRetailTransactionLineItemSequence) {
/*  75 */     if (changed(argRetailTransactionLineItemSequence, this._retailTransactionLineItemSequence, "retailTransactionLineItemSequence")) {
/*  76 */       this._retailTransactionLineItemSequence = argRetailTransactionLineItemSequence;
/*     */     }
/*     */   }
/*     */   
/*     */   public Long getTransactionSequence() {
/*  81 */     return this._transactionSequence;
/*     */   }
/*     */   
/*     */   public void setTransactionSequence(Long argTransactionSequence) {
/*  85 */     if (changed(argTransactionSequence, this._transactionSequence, "transactionSequence")) {
/*  86 */       this._transactionSequence = argTransactionSequence;
/*     */     }
/*     */   }
/*     */   
/*     */   public Long getWorkstationId() {
/*  91 */     return this._workstationId;
/*     */   }
/*     */   
/*     */   public void setWorkstationId(Long argWorkstationId) {
/*  95 */     if (changed(argWorkstationId, this._workstationId, "workstationId")) {
/*  96 */       this._workstationId = argWorkstationId;
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
/*     */   public String getCustAccountId() {
/* 143 */     return this._custAccountId;
/*     */   }
/*     */   
/*     */   public void setCustAccountId(String argCustAccountId) {
/* 147 */     if (changed(argCustAccountId, this._custAccountId, "custAccountId")) {
/* 148 */       this._custAccountId = argCustAccountId;
/*     */     }
/*     */   }
/*     */   
/*     */   public String getCustAccountCode() {
/* 153 */     return this._custAccountCode;
/*     */   }
/*     */   
/*     */   public void setCustAccountCode(String argCustAccountCode) {
/* 157 */     if (changed(argCustAccountCode, this._custAccountCode, "custAccountCode")) {
/* 158 */       this._custAccountCode = argCustAccountCode;
/*     */     }
/*     */   }
/*     */   
/*     */   public BigDecimal getItemAccountExtendedPrice() {
/* 163 */     return this._itemAccountExtendedPrice;
/*     */   }
/*     */   
/*     */   public void setItemAccountExtendedPrice(BigDecimal argItemAccountExtendedPrice) {
/* 167 */     if (changed(argItemAccountExtendedPrice, this._itemAccountExtendedPrice, "itemAccountExtendedPrice")) {
/* 168 */       this._itemAccountExtendedPrice = argItemAccountExtendedPrice;
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public String toString() {
/* 175 */     StringBuilder buf = new StringBuilder(512);
/* 176 */     buf.append(super.toString()).append(" Id: ").append(getObjectId()).append(" Values: ");
/* 177 */     if (getBusinessDate() != null) {
/* 178 */       buf.append("businessDate").append("=").append(getBusinessDate()).append(" ");
/*     */     }
/* 180 */     if (getOrganizationId() != null) {
/* 181 */       buf.append("organizationId").append("=").append(getOrganizationId()).append(" ");
/*     */     }
/* 183 */     if (getRetailLocationId() != null) {
/* 184 */       buf.append("retailLocationId").append("=").append(getRetailLocationId()).append(" ");
/*     */     }
/* 186 */     if (getRetailTransactionLineItemSequence() != null) {
/* 187 */       buf.append("retailTransactionLineItemSequence").append("=").append(getRetailTransactionLineItemSequence()).append(" ");
/*     */     }
/* 189 */     if (getTransactionSequence() != null) {
/* 190 */       buf.append("transactionSequence").append("=").append(getTransactionSequence()).append(" ");
/*     */     }
/* 192 */     if (getWorkstationId() != null) {
/* 193 */       buf.append("workstationId").append("=").append(getWorkstationId()).append(" ");
/*     */     }
/* 195 */     if (getCreateDate() != null) {
/* 196 */       buf.append("createDate").append("=").append(getCreateDate()).append(" ");
/*     */     }
/* 198 */     if (getCreateUserId() != null) {
/* 199 */       buf.append("createUserId").append("=").append(getCreateUserId()).append(" ");
/*     */     }
/* 201 */     if (getUpdateDate() != null) {
/* 202 */       buf.append("updateDate").append("=").append(getUpdateDate()).append(" ");
/*     */     }
/* 204 */     if (getUpdateUserId() != null) {
/* 205 */       buf.append("updateUserId").append("=").append(getUpdateUserId()).append(" ");
/*     */     }
/* 207 */     if (getCustAccountId() != null) {
/* 208 */       buf.append("custAccountId").append("=").append(getCustAccountId()).append(" ");
/*     */     }
/* 210 */     if (getCustAccountCode() != null) {
/* 211 */       buf.append("custAccountCode").append("=").append(getCustAccountCode()).append(" ");
/*     */     }
/* 213 */     if (getItemAccountExtendedPrice() != null) {
/* 214 */       buf.append("itemAccountExtendedPrice").append("=").append(getItemAccountExtendedPrice()).append(" ");
/*     */     }
/*     */     
/* 217 */     return buf.toString();
/*     */   }
/*     */   
/*     */   public IObjectId getObjectId() {
/* 221 */     CustomerItemAccountModifierId id = new CustomerItemAccountModifierId();
/* 222 */     id.setBusinessDate(getBusinessDate());
/* 223 */     id.setOrganizationId(getOrganizationId());
/* 224 */     id.setRetailLocationId(getRetailLocationId());
/* 225 */     id.setRetailTransactionLineItemSequence(getRetailTransactionLineItemSequence());
/* 226 */     id.setTransactionSequence(getTransactionSequence());
/* 227 */     id.setWorkstationId(getWorkstationId());
/* 228 */     return (IObjectId)id;
/*     */   }
/*     */   
/*     */   public void setObjectId(IObjectId argObjectId) {
/* 232 */     setBusinessDate(((CustomerItemAccountModifierId)argObjectId).getBusinessDate());
/* 233 */     setOrganizationId(((CustomerItemAccountModifierId)argObjectId).getOrganizationId());
/* 234 */     setRetailLocationId(((CustomerItemAccountModifierId)argObjectId).getRetailLocationId());
/* 235 */     setRetailTransactionLineItemSequence(((CustomerItemAccountModifierId)argObjectId).getRetailTransactionLineItemSequence());
/* 236 */     setTransactionSequence(((CustomerItemAccountModifierId)argObjectId).getTransactionSequence());
/* 237 */     setWorkstationId(((CustomerItemAccountModifierId)argObjectId).getWorkstationId());
/*     */   }
/*     */   
/*     */   public String getImplementingClass() {
/* 241 */     return null;
/*     */   }
/*     */   
/*     */   public String toXmlString() {
/* 245 */     StringBuilder buf = new StringBuilder(650);
/* 246 */     buf.append("<").append("dao").append(" name=\"CustomerItemAccountModifier\" cmd=\"" + getObjectStateString() + "\">");
/* 247 */     getFieldsAsXml(buf);
/* 248 */     buf.append("</").append("dao").append(">");
/*     */     
/* 250 */     return buf.toString();
/*     */   }
/*     */   
/*     */   public Map<String, String> getValues() {
/* 254 */     Map<String, String> values = super.getValues();
/* 255 */     if (this._businessDate != null) values.put("BusinessDate", DaoUtils.getXmlSafeFieldValue(91, this._businessDate)); 
/* 256 */     if (this._organizationId != null) values.put("OrganizationId", DaoUtils.getXmlSafeFieldValue(-5, this._organizationId)); 
/* 257 */     if (this._retailLocationId != null) values.put("RetailLocationId", DaoUtils.getXmlSafeFieldValue(-5, this._retailLocationId)); 
/* 258 */     if (this._retailTransactionLineItemSequence != null) values.put("RetailTransactionLineItemSequence", DaoUtils.getXmlSafeFieldValue(4, this._retailTransactionLineItemSequence)); 
/* 259 */     if (this._transactionSequence != null) values.put("TransactionSequence", DaoUtils.getXmlSafeFieldValue(-5, this._transactionSequence)); 
/* 260 */     if (this._workstationId != null) values.put("WorkstationId", DaoUtils.getXmlSafeFieldValue(-5, this._workstationId)); 
/* 261 */     if (this._createDate != null) values.put("CreateDate", DaoUtils.getXmlSafeFieldValue(91, this._createDate)); 
/* 262 */     if (this._createUserId != null) values.put("CreateUserId", DaoUtils.getXmlSafeFieldValue(12, this._createUserId)); 
/* 263 */     if (this._updateDate != null) values.put("UpdateDate", DaoUtils.getXmlSafeFieldValue(91, this._updateDate)); 
/* 264 */     if (this._updateUserId != null) values.put("UpdateUserId", DaoUtils.getXmlSafeFieldValue(12, this._updateUserId)); 
/* 265 */     if (this._custAccountId != null) values.put("CustAccountId", DaoUtils.getXmlSafeFieldValue(12, this._custAccountId)); 
/* 266 */     if (this._custAccountCode != null) values.put("CustAccountCode", DaoUtils.getXmlSafeFieldValue(12, this._custAccountCode)); 
/* 267 */     if (this._itemAccountExtendedPrice != null) values.put("ItemAccountExtendedPrice", DaoUtils.getXmlSafeFieldValue(3, this._itemAccountExtendedPrice)); 
/* 268 */     return values;
/*     */   }
/*     */ 
/*     */   
/*     */   public void setValues(Map<String, String> argValues) {
/* 273 */     super.setValues(argValues);
/* 274 */     for (Map.Entry<String, String> field : argValues.entrySet()) {
/*     */       
/* 276 */       String fieldName = field.getKey();
/* 277 */       String fieldValue = field.getValue();
/* 278 */       switch (fieldName) {
/*     */         
/*     */         case "BusinessDate":
/*     */           try {
/* 282 */             Object value = DaoUtils.getFieldValueForXmlString(91, fieldValue);
/* 283 */             setBusinessDate((Date)value);
/* 284 */           } catch (Exception ee) {
/* 285 */             throw new DtxException("An exception occurred while calling setBusinessDate() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "OrganizationId":
/*     */           try {
/* 291 */             Object value = DaoUtils.getFieldValueForXmlString(-5, fieldValue);
/* 292 */             setOrganizationId((Long)value);
/* 293 */           } catch (Exception ee) {
/* 294 */             throw new DtxException("An exception occurred while calling setOrganizationId() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "RetailLocationId":
/*     */           try {
/* 300 */             Object value = DaoUtils.getFieldValueForXmlString(-5, fieldValue);
/* 301 */             setRetailLocationId((Long)value);
/* 302 */           } catch (Exception ee) {
/* 303 */             throw new DtxException("An exception occurred while calling setRetailLocationId() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "RetailTransactionLineItemSequence":
/*     */           try {
/* 309 */             Object value = DaoUtils.getFieldValueForXmlString(4, fieldValue);
/* 310 */             setRetailTransactionLineItemSequence((Integer)value);
/* 311 */           } catch (Exception ee) {
/* 312 */             throw new DtxException("An exception occurred while calling setRetailTransactionLineItemSequence() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "TransactionSequence":
/*     */           try {
/* 318 */             Object value = DaoUtils.getFieldValueForXmlString(-5, fieldValue);
/* 319 */             setTransactionSequence((Long)value);
/* 320 */           } catch (Exception ee) {
/* 321 */             throw new DtxException("An exception occurred while calling setTransactionSequence() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "WorkstationId":
/*     */           try {
/* 327 */             Object value = DaoUtils.getFieldValueForXmlString(-5, fieldValue);
/* 328 */             setWorkstationId((Long)value);
/* 329 */           } catch (Exception ee) {
/* 330 */             throw new DtxException("An exception occurred while calling setWorkstationId() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "CreateDate":
/*     */           try {
/* 336 */             Object value = DaoUtils.getFieldValueForXmlString(91, fieldValue);
/* 337 */             setCreateDate((Date)value);
/* 338 */           } catch (Exception ee) {
/* 339 */             throw new DtxException("An exception occurred while calling setCreateDate() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "CreateUserId":
/*     */           try {
/* 345 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 346 */             setCreateUserId((String)value);
/* 347 */           } catch (Exception ee) {
/* 348 */             throw new DtxException("An exception occurred while calling setCreateUserId() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "UpdateDate":
/*     */           try {
/* 354 */             Object value = DaoUtils.getFieldValueForXmlString(91, fieldValue);
/* 355 */             setUpdateDate((Date)value);
/* 356 */           } catch (Exception ee) {
/* 357 */             throw new DtxException("An exception occurred while calling setUpdateDate() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "UpdateUserId":
/*     */           try {
/* 363 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 364 */             setUpdateUserId((String)value);
/* 365 */           } catch (Exception ee) {
/* 366 */             throw new DtxException("An exception occurred while calling setUpdateUserId() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "CustAccountId":
/*     */           try {
/* 372 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 373 */             setCustAccountId((String)value);
/* 374 */           } catch (Exception ee) {
/* 375 */             throw new DtxException("An exception occurred while calling setCustAccountId() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "CustAccountCode":
/*     */           try {
/* 381 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 382 */             setCustAccountCode((String)value);
/* 383 */           } catch (Exception ee) {
/* 384 */             throw new DtxException("An exception occurred while calling setCustAccountCode() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "ItemAccountExtendedPrice":
/*     */           try {
/* 390 */             Object value = DaoUtils.getFieldValueForXmlString(3, fieldValue);
/* 391 */             setItemAccountExtendedPrice((BigDecimal)value);
/* 392 */           } catch (Exception ee) {
/* 393 */             throw new DtxException("An exception occurred while calling setItemAccountExtendedPrice() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */       } 
/*     */     } 
/*     */   }
/*     */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\trl\impl\CustomerItemAccountModifierDAO.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */