/*     */ package dtv.xst.dao.trl.impl;
/*     */ 
/*     */ import dtv.data2.access.DaoUtils;
/*     */ import dtv.data2.access.exception.DtxException;
/*     */ import dtv.util.DtvDate;
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
/*     */ 
/*     */ 
/*     */ public class RetailTransactionExchangeLineItemDAO
/*     */   extends RetailTransactionLineItemDAO
/*     */ {
/*     */   private static final long serialVersionUID = -790483899L;
/*  23 */   private static final Logger _logger = Logger.getLogger(RetailTransactionExchangeLineItemDAO.class);
/*     */   
/*     */   private String _itemId;
/*     */   private DtvDate _createDate;
/*     */   private String _createUserId;
/*     */   private DtvDate _updateDate;
/*     */   private String _updateUserId;
/*     */   private String _originalSerialNumber;
/*     */   private String _newSerialNumber;
/*     */   private Long _originalRetailLocationId;
/*     */   private DtvDate _originalBusinessDate;
/*     */   private Long _originalWorkstationId;
/*     */   private Long _originalTransactionSequence;
/*     */   private Integer _oiginalLineItemSequence;
/*     */   private String _exchangeReasonCode;
/*     */   private String _exchangeComment;
/*     */   
/*     */   public String getItemId() {
/*  41 */     return this._itemId;
/*     */   }
/*     */   
/*     */   public void setItemId(String argItemId) {
/*  45 */     if (changed(argItemId, this._itemId, "itemId")) {
/*  46 */       this._itemId = argItemId;
/*     */     }
/*     */   }
/*     */   
/*     */   public Date getCreateDate() {
/*  51 */     return (Date)this._createDate;
/*     */   }
/*     */   
/*     */   public void setCreateDate(Date argCreateDate) {
/*  55 */     if (changed(argCreateDate, this._createDate, "createDate")) {
/*  56 */       this._createDate = (argCreateDate == null || argCreateDate instanceof DtvDate) ? (DtvDate)argCreateDate : new DtvDate(argCreateDate);
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public String getCreateUserId() {
/*  62 */     return this._createUserId;
/*     */   }
/*     */   
/*     */   public void setCreateUserId(String argCreateUserId) {
/*  66 */     if (changed(argCreateUserId, this._createUserId, "createUserId")) {
/*  67 */       this._createUserId = argCreateUserId;
/*     */     }
/*     */   }
/*     */   
/*     */   public Date getUpdateDate() {
/*  72 */     return (Date)this._updateDate;
/*     */   }
/*     */   
/*     */   public void setUpdateDate(Date argUpdateDate) {
/*  76 */     if (changed(argUpdateDate, this._updateDate, "updateDate")) {
/*  77 */       this._updateDate = (argUpdateDate == null || argUpdateDate instanceof DtvDate) ? (DtvDate)argUpdateDate : new DtvDate(argUpdateDate);
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public String getUpdateUserId() {
/*  83 */     return this._updateUserId;
/*     */   }
/*     */   
/*     */   public void setUpdateUserId(String argUpdateUserId) {
/*  87 */     if (changed(argUpdateUserId, this._updateUserId, "updateUserId")) {
/*  88 */       this._updateUserId = argUpdateUserId;
/*     */     }
/*     */   }
/*     */   
/*     */   public String getOriginalSerialNumber() {
/*  93 */     return this._originalSerialNumber;
/*     */   }
/*     */   
/*     */   public void setOriginalSerialNumber(String argOriginalSerialNumber) {
/*  97 */     if (changed(argOriginalSerialNumber, this._originalSerialNumber, "originalSerialNumber")) {
/*  98 */       this._originalSerialNumber = argOriginalSerialNumber;
/*     */     }
/*     */   }
/*     */   
/*     */   public String getNewSerialNumber() {
/* 103 */     return this._newSerialNumber;
/*     */   }
/*     */   
/*     */   public void setNewSerialNumber(String argNewSerialNumber) {
/* 107 */     if (changed(argNewSerialNumber, this._newSerialNumber, "newSerialNumber")) {
/* 108 */       this._newSerialNumber = argNewSerialNumber;
/*     */     }
/*     */   }
/*     */   
/*     */   public Long getOriginalRetailLocationId() {
/* 113 */     return this._originalRetailLocationId;
/*     */   }
/*     */   
/*     */   public void setOriginalRetailLocationId(Long argOriginalRetailLocationId) {
/* 117 */     if (changed(argOriginalRetailLocationId, this._originalRetailLocationId, "originalRetailLocationId")) {
/* 118 */       this._originalRetailLocationId = argOriginalRetailLocationId;
/*     */     }
/*     */   }
/*     */   
/*     */   public Date getOriginalBusinessDate() {
/* 123 */     return (Date)this._originalBusinessDate;
/*     */   }
/*     */   
/*     */   public void setOriginalBusinessDate(Date argOriginalBusinessDate) {
/* 127 */     if (changed(argOriginalBusinessDate, this._originalBusinessDate, "originalBusinessDate")) {
/* 128 */       this._originalBusinessDate = (argOriginalBusinessDate == null || argOriginalBusinessDate instanceof DtvDate) ? (DtvDate)argOriginalBusinessDate : new DtvDate(argOriginalBusinessDate);
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public Long getOriginalWorkstationId() {
/* 134 */     return this._originalWorkstationId;
/*     */   }
/*     */   
/*     */   public void setOriginalWorkstationId(Long argOriginalWorkstationId) {
/* 138 */     if (changed(argOriginalWorkstationId, this._originalWorkstationId, "originalWorkstationId")) {
/* 139 */       this._originalWorkstationId = argOriginalWorkstationId;
/*     */     }
/*     */   }
/*     */   
/*     */   public Long getOriginalTransactionSequence() {
/* 144 */     return this._originalTransactionSequence;
/*     */   }
/*     */   
/*     */   public void setOriginalTransactionSequence(Long argOriginalTransactionSequence) {
/* 148 */     if (changed(argOriginalTransactionSequence, this._originalTransactionSequence, "originalTransactionSequence")) {
/* 149 */       this._originalTransactionSequence = argOriginalTransactionSequence;
/*     */     }
/*     */   }
/*     */   
/*     */   public Integer getOiginalLineItemSequence() {
/* 154 */     return this._oiginalLineItemSequence;
/*     */   }
/*     */   
/*     */   public void setOiginalLineItemSequence(Integer argOiginalLineItemSequence) {
/* 158 */     if (changed(argOiginalLineItemSequence, this._oiginalLineItemSequence, "oiginalLineItemSequence")) {
/* 159 */       this._oiginalLineItemSequence = argOiginalLineItemSequence;
/*     */     }
/*     */   }
/*     */   
/*     */   public String getExchangeReasonCode() {
/* 164 */     return this._exchangeReasonCode;
/*     */   }
/*     */   
/*     */   public void setExchangeReasonCode(String argExchangeReasonCode) {
/* 168 */     if (changed(argExchangeReasonCode, this._exchangeReasonCode, "exchangeReasonCode")) {
/* 169 */       this._exchangeReasonCode = argExchangeReasonCode;
/*     */     }
/*     */   }
/*     */   
/*     */   public String getExchangeComment() {
/* 174 */     return this._exchangeComment;
/*     */   }
/*     */   
/*     */   public void setExchangeComment(String argExchangeComment) {
/* 178 */     if (changed(argExchangeComment, this._exchangeComment, "exchangeComment")) {
/* 179 */       this._exchangeComment = argExchangeComment;
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public String toString() {
/* 186 */     StringBuilder buf = new StringBuilder(512);
/* 187 */     buf.append(super.toString());
/* 188 */     if (getItemId() != null) {
/* 189 */       buf.append("itemId").append("=").append(getItemId()).append(" ");
/*     */     }
/* 191 */     if (getCreateDate() != null) {
/* 192 */       buf.append("createDate").append("=").append(getCreateDate()).append(" ");
/*     */     }
/* 194 */     if (getCreateUserId() != null) {
/* 195 */       buf.append("createUserId").append("=").append(getCreateUserId()).append(" ");
/*     */     }
/* 197 */     if (getUpdateDate() != null) {
/* 198 */       buf.append("updateDate").append("=").append(getUpdateDate()).append(" ");
/*     */     }
/* 200 */     if (getUpdateUserId() != null) {
/* 201 */       buf.append("updateUserId").append("=").append(getUpdateUserId()).append(" ");
/*     */     }
/* 203 */     if (getOriginalSerialNumber() != null) {
/* 204 */       buf.append("originalSerialNumber").append("=").append(getOriginalSerialNumber()).append(" ");
/*     */     }
/* 206 */     if (getNewSerialNumber() != null) {
/* 207 */       buf.append("newSerialNumber").append("=").append(getNewSerialNumber()).append(" ");
/*     */     }
/* 209 */     if (getOriginalRetailLocationId() != null) {
/* 210 */       buf.append("originalRetailLocationId").append("=").append(getOriginalRetailLocationId()).append(" ");
/*     */     }
/* 212 */     if (getOriginalBusinessDate() != null) {
/* 213 */       buf.append("originalBusinessDate").append("=").append(getOriginalBusinessDate()).append(" ");
/*     */     }
/* 215 */     if (getOriginalWorkstationId() != null) {
/* 216 */       buf.append("originalWorkstationId").append("=").append(getOriginalWorkstationId()).append(" ");
/*     */     }
/* 218 */     if (getOriginalTransactionSequence() != null) {
/* 219 */       buf.append("originalTransactionSequence").append("=").append(getOriginalTransactionSequence()).append(" ");
/*     */     }
/* 221 */     if (getOiginalLineItemSequence() != null) {
/* 222 */       buf.append("oiginalLineItemSequence").append("=").append(getOiginalLineItemSequence()).append(" ");
/*     */     }
/* 224 */     if (getExchangeReasonCode() != null) {
/* 225 */       buf.append("exchangeReasonCode").append("=").append(getExchangeReasonCode()).append(" ");
/*     */     }
/* 227 */     if (getExchangeComment() != null) {
/* 228 */       buf.append("exchangeComment").append("=").append(getExchangeComment()).append(" ");
/*     */     }
/*     */     
/* 231 */     return buf.toString();
/*     */   }
/*     */ 
/*     */   
/*     */   public String toXmlString() {
/* 236 */     StringBuilder buf = new StringBuilder(1750);
/* 237 */     buf.append("<").append("dao").append(" name=\"RetailTransactionExchangeLineItem\" cmd=\"" + getObjectStateString() + "\">");
/* 238 */     getFieldsAsXml(buf);
/* 239 */     buf.append("</").append("dao").append(">");
/*     */     
/* 241 */     return buf.toString();
/*     */   }
/*     */   
/*     */   public Map<String, String> getValues() {
/* 245 */     Map<String, String> values = super.getValues();
/* 246 */     if (this._itemId != null) values.put("ItemId", DaoUtils.getXmlSafeFieldValue(12, this._itemId)); 
/* 247 */     if (this._createDate != null) values.put("CreateDate", DaoUtils.getXmlSafeFieldValue(91, this._createDate)); 
/* 248 */     if (this._createUserId != null) values.put("CreateUserId", DaoUtils.getXmlSafeFieldValue(12, this._createUserId)); 
/* 249 */     if (this._updateDate != null) values.put("UpdateDate", DaoUtils.getXmlSafeFieldValue(91, this._updateDate)); 
/* 250 */     if (this._updateUserId != null) values.put("UpdateUserId", DaoUtils.getXmlSafeFieldValue(12, this._updateUserId)); 
/* 251 */     if (this._originalSerialNumber != null) values.put("OriginalSerialNumber", DaoUtils.getXmlSafeFieldValue(12, this._originalSerialNumber)); 
/* 252 */     if (this._newSerialNumber != null) values.put("NewSerialNumber", DaoUtils.getXmlSafeFieldValue(12, this._newSerialNumber)); 
/* 253 */     if (this._originalRetailLocationId != null) values.put("OriginalRetailLocationId", DaoUtils.getXmlSafeFieldValue(-5, this._originalRetailLocationId)); 
/* 254 */     if (this._originalBusinessDate != null) values.put("OriginalBusinessDate", DaoUtils.getXmlSafeFieldValue(91, this._originalBusinessDate)); 
/* 255 */     if (this._originalWorkstationId != null) values.put("OriginalWorkstationId", DaoUtils.getXmlSafeFieldValue(-5, this._originalWorkstationId)); 
/* 256 */     if (this._originalTransactionSequence != null) values.put("OriginalTransactionSequence", DaoUtils.getXmlSafeFieldValue(-5, this._originalTransactionSequence)); 
/* 257 */     if (this._oiginalLineItemSequence != null) values.put("OiginalLineItemSequence", DaoUtils.getXmlSafeFieldValue(4, this._oiginalLineItemSequence)); 
/* 258 */     if (this._exchangeReasonCode != null) values.put("ExchangeReasonCode", DaoUtils.getXmlSafeFieldValue(12, this._exchangeReasonCode)); 
/* 259 */     if (this._exchangeComment != null) values.put("ExchangeComment", DaoUtils.getXmlSafeFieldValue(12, this._exchangeComment)); 
/* 260 */     return values;
/*     */   }
/*     */ 
/*     */   
/*     */   public void setValues(Map<String, String> argValues) {
/* 265 */     super.setValues(argValues);
/* 266 */     for (Map.Entry<String, String> field : argValues.entrySet()) {
/*     */       
/* 268 */       String fieldName = field.getKey();
/* 269 */       String fieldValue = field.getValue();
/* 270 */       switch (fieldName) {
/*     */         
/*     */         case "ItemId":
/*     */           try {
/* 274 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 275 */             setItemId((String)value);
/* 276 */           } catch (Exception ee) {
/* 277 */             throw new DtxException("An exception occurred while calling setItemId() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "CreateDate":
/*     */           try {
/* 283 */             Object value = DaoUtils.getFieldValueForXmlString(91, fieldValue);
/* 284 */             setCreateDate((Date)value);
/* 285 */           } catch (Exception ee) {
/* 286 */             throw new DtxException("An exception occurred while calling setCreateDate() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "CreateUserId":
/*     */           try {
/* 292 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 293 */             setCreateUserId((String)value);
/* 294 */           } catch (Exception ee) {
/* 295 */             throw new DtxException("An exception occurred while calling setCreateUserId() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "UpdateDate":
/*     */           try {
/* 301 */             Object value = DaoUtils.getFieldValueForXmlString(91, fieldValue);
/* 302 */             setUpdateDate((Date)value);
/* 303 */           } catch (Exception ee) {
/* 304 */             throw new DtxException("An exception occurred while calling setUpdateDate() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "UpdateUserId":
/*     */           try {
/* 310 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 311 */             setUpdateUserId((String)value);
/* 312 */           } catch (Exception ee) {
/* 313 */             throw new DtxException("An exception occurred while calling setUpdateUserId() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "OriginalSerialNumber":
/*     */           try {
/* 319 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 320 */             setOriginalSerialNumber((String)value);
/* 321 */           } catch (Exception ee) {
/* 322 */             throw new DtxException("An exception occurred while calling setOriginalSerialNumber() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "NewSerialNumber":
/*     */           try {
/* 328 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 329 */             setNewSerialNumber((String)value);
/* 330 */           } catch (Exception ee) {
/* 331 */             throw new DtxException("An exception occurred while calling setNewSerialNumber() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "OriginalRetailLocationId":
/*     */           try {
/* 337 */             Object value = DaoUtils.getFieldValueForXmlString(-5, fieldValue);
/* 338 */             setOriginalRetailLocationId((Long)value);
/* 339 */           } catch (Exception ee) {
/* 340 */             throw new DtxException("An exception occurred while calling setOriginalRetailLocationId() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "OriginalBusinessDate":
/*     */           try {
/* 346 */             Object value = DaoUtils.getFieldValueForXmlString(91, fieldValue);
/* 347 */             setOriginalBusinessDate((Date)value);
/* 348 */           } catch (Exception ee) {
/* 349 */             throw new DtxException("An exception occurred while calling setOriginalBusinessDate() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "OriginalWorkstationId":
/*     */           try {
/* 355 */             Object value = DaoUtils.getFieldValueForXmlString(-5, fieldValue);
/* 356 */             setOriginalWorkstationId((Long)value);
/* 357 */           } catch (Exception ee) {
/* 358 */             throw new DtxException("An exception occurred while calling setOriginalWorkstationId() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "OriginalTransactionSequence":
/*     */           try {
/* 364 */             Object value = DaoUtils.getFieldValueForXmlString(-5, fieldValue);
/* 365 */             setOriginalTransactionSequence((Long)value);
/* 366 */           } catch (Exception ee) {
/* 367 */             throw new DtxException("An exception occurred while calling setOriginalTransactionSequence() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "OiginalLineItemSequence":
/*     */           try {
/* 373 */             Object value = DaoUtils.getFieldValueForXmlString(4, fieldValue);
/* 374 */             setOiginalLineItemSequence((Integer)value);
/* 375 */           } catch (Exception ee) {
/* 376 */             throw new DtxException("An exception occurred while calling setOiginalLineItemSequence() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "ExchangeReasonCode":
/*     */           try {
/* 382 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 383 */             setExchangeReasonCode((String)value);
/* 384 */           } catch (Exception ee) {
/* 385 */             throw new DtxException("An exception occurred while calling setExchangeReasonCode() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "ExchangeComment":
/*     */           try {
/* 391 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 392 */             setExchangeComment((String)value);
/* 393 */           } catch (Exception ee) {
/* 394 */             throw new DtxException("An exception occurred while calling setExchangeComment() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */       } 
/*     */     } 
/*     */   }
/*     */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\trl\impl\RetailTransactionExchangeLineItemDAO.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */