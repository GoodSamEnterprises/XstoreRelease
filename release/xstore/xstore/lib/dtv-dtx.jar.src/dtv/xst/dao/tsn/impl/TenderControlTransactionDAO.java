/*     */ package dtv.xst.dao.tsn.impl;
/*     */ 
/*     */ import dtv.data2.access.DaoUtils;
/*     */ import dtv.data2.access.exception.DtxException;
/*     */ import dtv.util.DtvDate;
/*     */ import dtv.xst.dao.trn.impl.PosTransactionDAO;
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
/*     */ public class TenderControlTransactionDAO
/*     */   extends PosTransactionDAO
/*     */ {
/*     */   private static final long serialVersionUID = -645771435L;
/*  23 */   private static final Logger _logger = Logger.getLogger(TenderControlTransactionDAO.class);
/*     */   
/*     */   private DtvDate _createDate;
/*     */   private String _createUserId;
/*     */   private DtvDate _updateDate;
/*     */   private String _updateUserId;
/*     */   private BigDecimal _amount;
/*     */   private DtvDate _depositDate;
/*     */   private String _typeCode;
/*     */   private Long _fundsReceiptPartyId;
/*     */   private Long _inboundSessionId;
/*     */   private String _inboundTenderRepositoryId;
/*     */   private Long _outboundSessionId;
/*     */   private String _outboundTenderRepositoryId;
/*     */   private String _reasonCode;
/*     */   private String _safeBagId;
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
/*     */   public BigDecimal getAmount() {
/*  83 */     return this._amount;
/*     */   }
/*     */   
/*     */   public void setAmount(BigDecimal argAmount) {
/*  87 */     if (changed(argAmount, this._amount, "amount")) {
/*  88 */       this._amount = argAmount;
/*     */     }
/*     */   }
/*     */   
/*     */   public Date getDepositDate() {
/*  93 */     return (Date)this._depositDate;
/*     */   }
/*     */   
/*     */   public void setDepositDate(Date argDepositDate) {
/*  97 */     if (changed(argDepositDate, this._depositDate, "depositDate")) {
/*  98 */       this._depositDate = (argDepositDate == null || argDepositDate instanceof DtvDate) ? (DtvDate)argDepositDate : new DtvDate(argDepositDate);
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public String getTypeCode() {
/* 104 */     return this._typeCode;
/*     */   }
/*     */   
/*     */   public void setTypeCode(String argTypeCode) {
/* 108 */     if (changed(argTypeCode, this._typeCode, "typeCode")) {
/* 109 */       this._typeCode = argTypeCode;
/*     */     }
/*     */   }
/*     */   
/*     */   public Long getFundsReceiptPartyId() {
/* 114 */     return this._fundsReceiptPartyId;
/*     */   }
/*     */   
/*     */   public void setFundsReceiptPartyId(Long argFundsReceiptPartyId) {
/* 118 */     if (changed(argFundsReceiptPartyId, this._fundsReceiptPartyId, "fundsReceiptPartyId")) {
/* 119 */       this._fundsReceiptPartyId = argFundsReceiptPartyId;
/*     */     }
/*     */   }
/*     */   
/*     */   public Long getInboundSessionId() {
/* 124 */     return this._inboundSessionId;
/*     */   }
/*     */   
/*     */   public void setInboundSessionId(Long argInboundSessionId) {
/* 128 */     if (changed(argInboundSessionId, this._inboundSessionId, "inboundSessionId")) {
/* 129 */       this._inboundSessionId = argInboundSessionId;
/*     */     }
/*     */   }
/*     */   
/*     */   public String getInboundTenderRepositoryId() {
/* 134 */     return this._inboundTenderRepositoryId;
/*     */   }
/*     */   
/*     */   public void setInboundTenderRepositoryId(String argInboundTenderRepositoryId) {
/* 138 */     if (changed(argInboundTenderRepositoryId, this._inboundTenderRepositoryId, "inboundTenderRepositoryId")) {
/* 139 */       this._inboundTenderRepositoryId = argInboundTenderRepositoryId;
/*     */     }
/*     */   }
/*     */   
/*     */   public Long getOutboundSessionId() {
/* 144 */     return this._outboundSessionId;
/*     */   }
/*     */   
/*     */   public void setOutboundSessionId(Long argOutboundSessionId) {
/* 148 */     if (changed(argOutboundSessionId, this._outboundSessionId, "outboundSessionId")) {
/* 149 */       this._outboundSessionId = argOutboundSessionId;
/*     */     }
/*     */   }
/*     */   
/*     */   public String getOutboundTenderRepositoryId() {
/* 154 */     return this._outboundTenderRepositoryId;
/*     */   }
/*     */   
/*     */   public void setOutboundTenderRepositoryId(String argOutboundTenderRepositoryId) {
/* 158 */     if (changed(argOutboundTenderRepositoryId, this._outboundTenderRepositoryId, "outboundTenderRepositoryId")) {
/* 159 */       this._outboundTenderRepositoryId = argOutboundTenderRepositoryId;
/*     */     }
/*     */   }
/*     */   
/*     */   public String getReasonCode() {
/* 164 */     return this._reasonCode;
/*     */   }
/*     */   
/*     */   public void setReasonCode(String argReasonCode) {
/* 168 */     if (changed(argReasonCode, this._reasonCode, "reasonCode")) {
/* 169 */       this._reasonCode = argReasonCode;
/*     */     }
/*     */   }
/*     */   
/*     */   public String getSafeBagId() {
/* 174 */     return this._safeBagId;
/*     */   }
/*     */   
/*     */   public void setSafeBagId(String argSafeBagId) {
/* 178 */     if (changed(argSafeBagId, this._safeBagId, "safeBagId")) {
/* 179 */       this._safeBagId = argSafeBagId;
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public String toString() {
/* 186 */     StringBuilder buf = new StringBuilder(512);
/* 187 */     buf.append(super.toString());
/* 188 */     if (getCreateDate() != null) {
/* 189 */       buf.append("createDate").append("=").append(getCreateDate()).append(" ");
/*     */     }
/* 191 */     if (getCreateUserId() != null) {
/* 192 */       buf.append("createUserId").append("=").append(getCreateUserId()).append(" ");
/*     */     }
/* 194 */     if (getUpdateDate() != null) {
/* 195 */       buf.append("updateDate").append("=").append(getUpdateDate()).append(" ");
/*     */     }
/* 197 */     if (getUpdateUserId() != null) {
/* 198 */       buf.append("updateUserId").append("=").append(getUpdateUserId()).append(" ");
/*     */     }
/* 200 */     if (getAmount() != null) {
/* 201 */       buf.append("amount").append("=").append(getAmount()).append(" ");
/*     */     }
/* 203 */     if (getDepositDate() != null) {
/* 204 */       buf.append("depositDate").append("=").append(getDepositDate()).append(" ");
/*     */     }
/* 206 */     if (getTypeCode() != null) {
/* 207 */       buf.append("typeCode").append("=").append(getTypeCode()).append(" ");
/*     */     }
/* 209 */     if (getFundsReceiptPartyId() != null) {
/* 210 */       buf.append("fundsReceiptPartyId").append("=").append(getFundsReceiptPartyId()).append(" ");
/*     */     }
/* 212 */     if (getInboundSessionId() != null) {
/* 213 */       buf.append("inboundSessionId").append("=").append(getInboundSessionId()).append(" ");
/*     */     }
/* 215 */     if (getInboundTenderRepositoryId() != null) {
/* 216 */       buf.append("inboundTenderRepositoryId").append("=").append(getInboundTenderRepositoryId()).append(" ");
/*     */     }
/* 218 */     if (getOutboundSessionId() != null) {
/* 219 */       buf.append("outboundSessionId").append("=").append(getOutboundSessionId()).append(" ");
/*     */     }
/* 221 */     if (getOutboundTenderRepositoryId() != null) {
/* 222 */       buf.append("outboundTenderRepositoryId").append("=").append(getOutboundTenderRepositoryId()).append(" ");
/*     */     }
/* 224 */     if (getReasonCode() != null) {
/* 225 */       buf.append("reasonCode").append("=").append(getReasonCode()).append(" ");
/*     */     }
/* 227 */     if (getSafeBagId() != null) {
/* 228 */       buf.append("safeBagId").append("=").append(getSafeBagId()).append(" ");
/*     */     }
/*     */     
/* 231 */     return buf.toString();
/*     */   }
/*     */ 
/*     */   
/*     */   public String toXmlString() {
/* 236 */     StringBuilder buf = new StringBuilder(2150);
/* 237 */     buf.append("<").append("dao").append(" name=\"TenderControlTransaction\" cmd=\"" + getObjectStateString() + "\">");
/* 238 */     getFieldsAsXml(buf);
/* 239 */     buf.append("</").append("dao").append(">");
/*     */     
/* 241 */     return buf.toString();
/*     */   }
/*     */   
/*     */   public Map<String, String> getValues() {
/* 245 */     Map<String, String> values = super.getValues();
/* 246 */     if (this._createDate != null) values.put("CreateDate", DaoUtils.getXmlSafeFieldValue(91, this._createDate)); 
/* 247 */     if (this._createUserId != null) values.put("CreateUserId", DaoUtils.getXmlSafeFieldValue(12, this._createUserId)); 
/* 248 */     if (this._updateDate != null) values.put("UpdateDate", DaoUtils.getXmlSafeFieldValue(91, this._updateDate)); 
/* 249 */     if (this._updateUserId != null) values.put("UpdateUserId", DaoUtils.getXmlSafeFieldValue(12, this._updateUserId)); 
/* 250 */     if (this._amount != null) values.put("Amount", DaoUtils.getXmlSafeFieldValue(3, this._amount)); 
/* 251 */     if (this._depositDate != null) values.put("DepositDate", DaoUtils.getXmlSafeFieldValue(91, this._depositDate)); 
/* 252 */     if (this._typeCode != null) values.put("TypeCode", DaoUtils.getXmlSafeFieldValue(12, this._typeCode)); 
/* 253 */     if (this._fundsReceiptPartyId != null) values.put("FundsReceiptPartyId", DaoUtils.getXmlSafeFieldValue(-5, this._fundsReceiptPartyId)); 
/* 254 */     if (this._inboundSessionId != null) values.put("InboundSessionId", DaoUtils.getXmlSafeFieldValue(-5, this._inboundSessionId)); 
/* 255 */     if (this._inboundTenderRepositoryId != null) values.put("InboundTenderRepositoryId", DaoUtils.getXmlSafeFieldValue(12, this._inboundTenderRepositoryId)); 
/* 256 */     if (this._outboundSessionId != null) values.put("OutboundSessionId", DaoUtils.getXmlSafeFieldValue(-5, this._outboundSessionId)); 
/* 257 */     if (this._outboundTenderRepositoryId != null) values.put("OutboundTenderRepositoryId", DaoUtils.getXmlSafeFieldValue(12, this._outboundTenderRepositoryId)); 
/* 258 */     if (this._reasonCode != null) values.put("ReasonCode", DaoUtils.getXmlSafeFieldValue(12, this._reasonCode)); 
/* 259 */     if (this._safeBagId != null) values.put("SafeBagId", DaoUtils.getXmlSafeFieldValue(12, this._safeBagId)); 
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
/*     */         case "CreateDate":
/*     */           try {
/* 274 */             Object value = DaoUtils.getFieldValueForXmlString(91, fieldValue);
/* 275 */             setCreateDate((Date)value);
/* 276 */           } catch (Exception ee) {
/* 277 */             throw new DtxException("An exception occurred while calling setCreateDate() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "CreateUserId":
/*     */           try {
/* 283 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 284 */             setCreateUserId((String)value);
/* 285 */           } catch (Exception ee) {
/* 286 */             throw new DtxException("An exception occurred while calling setCreateUserId() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "UpdateDate":
/*     */           try {
/* 292 */             Object value = DaoUtils.getFieldValueForXmlString(91, fieldValue);
/* 293 */             setUpdateDate((Date)value);
/* 294 */           } catch (Exception ee) {
/* 295 */             throw new DtxException("An exception occurred while calling setUpdateDate() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "UpdateUserId":
/*     */           try {
/* 301 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 302 */             setUpdateUserId((String)value);
/* 303 */           } catch (Exception ee) {
/* 304 */             throw new DtxException("An exception occurred while calling setUpdateUserId() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "Amount":
/*     */           try {
/* 310 */             Object value = DaoUtils.getFieldValueForXmlString(3, fieldValue);
/* 311 */             setAmount((BigDecimal)value);
/* 312 */           } catch (Exception ee) {
/* 313 */             throw new DtxException("An exception occurred while calling setAmount() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "DepositDate":
/*     */           try {
/* 319 */             Object value = DaoUtils.getFieldValueForXmlString(91, fieldValue);
/* 320 */             setDepositDate((Date)value);
/* 321 */           } catch (Exception ee) {
/* 322 */             throw new DtxException("An exception occurred while calling setDepositDate() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "TypeCode":
/*     */           try {
/* 328 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 329 */             setTypeCode((String)value);
/* 330 */           } catch (Exception ee) {
/* 331 */             throw new DtxException("An exception occurred while calling setTypeCode() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "FundsReceiptPartyId":
/*     */           try {
/* 337 */             Object value = DaoUtils.getFieldValueForXmlString(-5, fieldValue);
/* 338 */             setFundsReceiptPartyId((Long)value);
/* 339 */           } catch (Exception ee) {
/* 340 */             throw new DtxException("An exception occurred while calling setFundsReceiptPartyId() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "InboundSessionId":
/*     */           try {
/* 346 */             Object value = DaoUtils.getFieldValueForXmlString(-5, fieldValue);
/* 347 */             setInboundSessionId((Long)value);
/* 348 */           } catch (Exception ee) {
/* 349 */             throw new DtxException("An exception occurred while calling setInboundSessionId() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "InboundTenderRepositoryId":
/*     */           try {
/* 355 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 356 */             setInboundTenderRepositoryId((String)value);
/* 357 */           } catch (Exception ee) {
/* 358 */             throw new DtxException("An exception occurred while calling setInboundTenderRepositoryId() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "OutboundSessionId":
/*     */           try {
/* 364 */             Object value = DaoUtils.getFieldValueForXmlString(-5, fieldValue);
/* 365 */             setOutboundSessionId((Long)value);
/* 366 */           } catch (Exception ee) {
/* 367 */             throw new DtxException("An exception occurred while calling setOutboundSessionId() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "OutboundTenderRepositoryId":
/*     */           try {
/* 373 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 374 */             setOutboundTenderRepositoryId((String)value);
/* 375 */           } catch (Exception ee) {
/* 376 */             throw new DtxException("An exception occurred while calling setOutboundTenderRepositoryId() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "ReasonCode":
/*     */           try {
/* 382 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 383 */             setReasonCode((String)value);
/* 384 */           } catch (Exception ee) {
/* 385 */             throw new DtxException("An exception occurred while calling setReasonCode() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "SafeBagId":
/*     */           try {
/* 391 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 392 */             setSafeBagId((String)value);
/* 393 */           } catch (Exception ee) {
/* 394 */             throw new DtxException("An exception occurred while calling setSafeBagId() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */       } 
/*     */     } 
/*     */   }
/*     */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\tsn\impl\TenderControlTransactionDAO.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */