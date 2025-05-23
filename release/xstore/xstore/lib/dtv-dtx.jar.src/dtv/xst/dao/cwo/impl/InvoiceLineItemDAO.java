/*     */ package dtv.xst.dao.cwo.impl;
/*     */ 
/*     */ import dtv.data2.access.DaoUtils;
/*     */ import dtv.data2.access.IObjectId;
/*     */ import dtv.data2.access.exception.DtxException;
/*     */ import dtv.data2.access.impl.AbstractDAOImpl;
/*     */ import dtv.util.DtvDate;
/*     */ import dtv.xst.dao.cwo.InvoiceLineItemId;
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
/*     */ public class InvoiceLineItemDAO
/*     */   extends AbstractDAOImpl
/*     */ {
/*     */   private static final long serialVersionUID = 1194092372L;
/*  23 */   private static final Logger _logger = Logger.getLogger(InvoiceLineItemDAO.class);
/*     */   
/*     */   private Long _organizationId;
/*     */   private String _serviceLocationId;
/*     */   private String _invoiceNumber;
/*     */   private Integer _invoiceLineItemSequence;
/*     */   private DtvDate _createDate;
/*     */   private String _createUserId;
/*     */   private DtvDate _updateDate;
/*     */   private String _updateUserId;
/*     */   private String _lineItemTypeCode;
/*     */   private BigDecimal _amount;
/*     */   private String _glAccount;
/*     */   private String _custAccountId;
/*     */   
/*     */   public Long getOrganizationId() {
/*  39 */     return this._organizationId;
/*     */   }
/*     */   
/*     */   public void setOrganizationId(Long argOrganizationId) {
/*  43 */     if (changed(argOrganizationId, this._organizationId, "organizationId")) {
/*  44 */       this._organizationId = argOrganizationId;
/*     */     }
/*     */   }
/*     */   
/*     */   public String getServiceLocationId() {
/*  49 */     return this._serviceLocationId;
/*     */   }
/*     */   
/*     */   public void setServiceLocationId(String argServiceLocationId) {
/*  53 */     if (changed(argServiceLocationId, this._serviceLocationId, "serviceLocationId")) {
/*  54 */       this._serviceLocationId = (argServiceLocationId != null && MANAGE_CASE) ? argServiceLocationId.toUpperCase() : argServiceLocationId;
/*     */     }
/*     */   }
/*     */   
/*     */   public String getInvoiceNumber() {
/*  59 */     return this._invoiceNumber;
/*     */   }
/*     */   
/*     */   public void setInvoiceNumber(String argInvoiceNumber) {
/*  63 */     if (changed(argInvoiceNumber, this._invoiceNumber, "invoiceNumber")) {
/*  64 */       this._invoiceNumber = (argInvoiceNumber != null && MANAGE_CASE) ? argInvoiceNumber.toUpperCase() : argInvoiceNumber;
/*     */     }
/*     */   }
/*     */   
/*     */   public Integer getInvoiceLineItemSequence() {
/*  69 */     return this._invoiceLineItemSequence;
/*     */   }
/*     */   
/*     */   public void setInvoiceLineItemSequence(Integer argInvoiceLineItemSequence) {
/*  73 */     if (changed(argInvoiceLineItemSequence, this._invoiceLineItemSequence, "invoiceLineItemSequence")) {
/*  74 */       this._invoiceLineItemSequence = argInvoiceLineItemSequence;
/*     */     }
/*     */   }
/*     */   
/*     */   public Date getCreateDate() {
/*  79 */     return (Date)this._createDate;
/*     */   }
/*     */   
/*     */   public void setCreateDate(Date argCreateDate) {
/*  83 */     if (changed(argCreateDate, this._createDate, "createDate")) {
/*  84 */       this._createDate = (argCreateDate == null || argCreateDate instanceof DtvDate) ? (DtvDate)argCreateDate : new DtvDate(argCreateDate);
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public String getCreateUserId() {
/*  90 */     return this._createUserId;
/*     */   }
/*     */   
/*     */   public void setCreateUserId(String argCreateUserId) {
/*  94 */     if (changed(argCreateUserId, this._createUserId, "createUserId")) {
/*  95 */       this._createUserId = argCreateUserId;
/*     */     }
/*     */   }
/*     */   
/*     */   public Date getUpdateDate() {
/* 100 */     return (Date)this._updateDate;
/*     */   }
/*     */   
/*     */   public void setUpdateDate(Date argUpdateDate) {
/* 104 */     if (changed(argUpdateDate, this._updateDate, "updateDate")) {
/* 105 */       this._updateDate = (argUpdateDate == null || argUpdateDate instanceof DtvDate) ? (DtvDate)argUpdateDate : new DtvDate(argUpdateDate);
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public String getUpdateUserId() {
/* 111 */     return this._updateUserId;
/*     */   }
/*     */   
/*     */   public void setUpdateUserId(String argUpdateUserId) {
/* 115 */     if (changed(argUpdateUserId, this._updateUserId, "updateUserId")) {
/* 116 */       this._updateUserId = argUpdateUserId;
/*     */     }
/*     */   }
/*     */   
/*     */   public String getLineItemTypeCode() {
/* 121 */     return this._lineItemTypeCode;
/*     */   }
/*     */   
/*     */   public void setLineItemTypeCode(String argLineItemTypeCode) {
/* 125 */     if (changed(argLineItemTypeCode, this._lineItemTypeCode, "lineItemTypeCode")) {
/* 126 */       this._lineItemTypeCode = argLineItemTypeCode;
/*     */     }
/*     */   }
/*     */   
/*     */   public BigDecimal getAmount() {
/* 131 */     return this._amount;
/*     */   }
/*     */   
/*     */   public void setAmount(BigDecimal argAmount) {
/* 135 */     if (changed(argAmount, this._amount, "amount")) {
/* 136 */       this._amount = argAmount;
/*     */     }
/*     */   }
/*     */   
/*     */   public String getGlAccount() {
/* 141 */     return this._glAccount;
/*     */   }
/*     */   
/*     */   public void setGlAccount(String argGlAccount) {
/* 145 */     if (changed(argGlAccount, this._glAccount, "glAccount")) {
/* 146 */       this._glAccount = argGlAccount;
/*     */     }
/*     */   }
/*     */   
/*     */   public String getCustAccountId() {
/* 151 */     return this._custAccountId;
/*     */   }
/*     */   
/*     */   public void setCustAccountId(String argCustAccountId) {
/* 155 */     if (changed(argCustAccountId, this._custAccountId, "custAccountId")) {
/* 156 */       this._custAccountId = argCustAccountId;
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public String toString() {
/* 163 */     StringBuilder buf = new StringBuilder(512);
/* 164 */     buf.append(super.toString()).append(" Id: ").append(getObjectId()).append(" Values: ");
/* 165 */     if (getOrganizationId() != null) {
/* 166 */       buf.append("organizationId").append("=").append(getOrganizationId()).append(" ");
/*     */     }
/* 168 */     if (getServiceLocationId() != null) {
/* 169 */       buf.append("serviceLocationId").append("=").append(getServiceLocationId()).append(" ");
/*     */     }
/* 171 */     if (getInvoiceNumber() != null) {
/* 172 */       buf.append("invoiceNumber").append("=").append(getInvoiceNumber()).append(" ");
/*     */     }
/* 174 */     if (getInvoiceLineItemSequence() != null) {
/* 175 */       buf.append("invoiceLineItemSequence").append("=").append(getInvoiceLineItemSequence()).append(" ");
/*     */     }
/* 177 */     if (getCreateDate() != null) {
/* 178 */       buf.append("createDate").append("=").append(getCreateDate()).append(" ");
/*     */     }
/* 180 */     if (getCreateUserId() != null) {
/* 181 */       buf.append("createUserId").append("=").append(getCreateUserId()).append(" ");
/*     */     }
/* 183 */     if (getUpdateDate() != null) {
/* 184 */       buf.append("updateDate").append("=").append(getUpdateDate()).append(" ");
/*     */     }
/* 186 */     if (getUpdateUserId() != null) {
/* 187 */       buf.append("updateUserId").append("=").append(getUpdateUserId()).append(" ");
/*     */     }
/* 189 */     if (getLineItemTypeCode() != null) {
/* 190 */       buf.append("lineItemTypeCode").append("=").append(getLineItemTypeCode()).append(" ");
/*     */     }
/* 192 */     if (getAmount() != null) {
/* 193 */       buf.append("amount").append("=").append(getAmount()).append(" ");
/*     */     }
/* 195 */     if (getGlAccount() != null) {
/* 196 */       buf.append("glAccount").append("=").append(getGlAccount()).append(" ");
/*     */     }
/* 198 */     if (getCustAccountId() != null) {
/* 199 */       buf.append("custAccountId").append("=").append(getCustAccountId()).append(" ");
/*     */     }
/*     */     
/* 202 */     return buf.toString();
/*     */   }
/*     */   
/*     */   public IObjectId getObjectId() {
/* 206 */     InvoiceLineItemId id = new InvoiceLineItemId();
/* 207 */     id.setOrganizationId(getOrganizationId());
/* 208 */     id.setServiceLocationId(getServiceLocationId());
/* 209 */     id.setInvoiceNumber(getInvoiceNumber());
/* 210 */     id.setInvoiceLineItemSequence(getInvoiceLineItemSequence());
/* 211 */     return (IObjectId)id;
/*     */   }
/*     */   
/*     */   public void setObjectId(IObjectId argObjectId) {
/* 215 */     setOrganizationId(((InvoiceLineItemId)argObjectId).getOrganizationId());
/* 216 */     setServiceLocationId(((InvoiceLineItemId)argObjectId).getServiceLocationId());
/* 217 */     setInvoiceNumber(((InvoiceLineItemId)argObjectId).getInvoiceNumber());
/* 218 */     setInvoiceLineItemSequence(((InvoiceLineItemId)argObjectId).getInvoiceLineItemSequence());
/*     */   }
/*     */   
/*     */   public String getImplementingClass() {
/* 222 */     return null;
/*     */   }
/*     */   
/*     */   public String toXmlString() {
/* 226 */     StringBuilder buf = new StringBuilder(600);
/* 227 */     buf.append("<").append("dao").append(" name=\"InvoiceLineItem\" cmd=\"" + getObjectStateString() + "\">");
/* 228 */     getFieldsAsXml(buf);
/* 229 */     buf.append("</").append("dao").append(">");
/*     */     
/* 231 */     return buf.toString();
/*     */   }
/*     */   
/*     */   public Map<String, String> getValues() {
/* 235 */     Map<String, String> values = super.getValues();
/* 236 */     if (this._organizationId != null) values.put("OrganizationId", DaoUtils.getXmlSafeFieldValue(-5, this._organizationId)); 
/* 237 */     if (this._serviceLocationId != null) values.put("ServiceLocationId", DaoUtils.getXmlSafeFieldValue(12, this._serviceLocationId)); 
/* 238 */     if (this._invoiceNumber != null) values.put("InvoiceNumber", DaoUtils.getXmlSafeFieldValue(12, this._invoiceNumber)); 
/* 239 */     if (this._invoiceLineItemSequence != null) values.put("InvoiceLineItemSequence", DaoUtils.getXmlSafeFieldValue(4, this._invoiceLineItemSequence)); 
/* 240 */     if (this._createDate != null) values.put("CreateDate", DaoUtils.getXmlSafeFieldValue(91, this._createDate)); 
/* 241 */     if (this._createUserId != null) values.put("CreateUserId", DaoUtils.getXmlSafeFieldValue(12, this._createUserId)); 
/* 242 */     if (this._updateDate != null) values.put("UpdateDate", DaoUtils.getXmlSafeFieldValue(91, this._updateDate)); 
/* 243 */     if (this._updateUserId != null) values.put("UpdateUserId", DaoUtils.getXmlSafeFieldValue(12, this._updateUserId)); 
/* 244 */     if (this._lineItemTypeCode != null) values.put("LineItemTypeCode", DaoUtils.getXmlSafeFieldValue(12, this._lineItemTypeCode)); 
/* 245 */     if (this._amount != null) values.put("Amount", DaoUtils.getXmlSafeFieldValue(3, this._amount)); 
/* 246 */     if (this._glAccount != null) values.put("GlAccount", DaoUtils.getXmlSafeFieldValue(12, this._glAccount)); 
/* 247 */     if (this._custAccountId != null) values.put("CustAccountId", DaoUtils.getXmlSafeFieldValue(12, this._custAccountId)); 
/* 248 */     return values;
/*     */   }
/*     */ 
/*     */   
/*     */   public void setValues(Map<String, String> argValues) {
/* 253 */     super.setValues(argValues);
/* 254 */     for (Map.Entry<String, String> field : argValues.entrySet()) {
/*     */       
/* 256 */       String fieldName = field.getKey();
/* 257 */       String fieldValue = field.getValue();
/* 258 */       switch (fieldName) {
/*     */         
/*     */         case "OrganizationId":
/*     */           try {
/* 262 */             Object value = DaoUtils.getFieldValueForXmlString(-5, fieldValue);
/* 263 */             setOrganizationId((Long)value);
/* 264 */           } catch (Exception ee) {
/* 265 */             throw new DtxException("An exception occurred while calling setOrganizationId() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "ServiceLocationId":
/*     */           try {
/* 271 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 272 */             setServiceLocationId((String)value);
/* 273 */           } catch (Exception ee) {
/* 274 */             throw new DtxException("An exception occurred while calling setServiceLocationId() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "InvoiceNumber":
/*     */           try {
/* 280 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 281 */             setInvoiceNumber((String)value);
/* 282 */           } catch (Exception ee) {
/* 283 */             throw new DtxException("An exception occurred while calling setInvoiceNumber() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "InvoiceLineItemSequence":
/*     */           try {
/* 289 */             Object value = DaoUtils.getFieldValueForXmlString(4, fieldValue);
/* 290 */             setInvoiceLineItemSequence((Integer)value);
/* 291 */           } catch (Exception ee) {
/* 292 */             throw new DtxException("An exception occurred while calling setInvoiceLineItemSequence() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "CreateDate":
/*     */           try {
/* 298 */             Object value = DaoUtils.getFieldValueForXmlString(91, fieldValue);
/* 299 */             setCreateDate((Date)value);
/* 300 */           } catch (Exception ee) {
/* 301 */             throw new DtxException("An exception occurred while calling setCreateDate() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "CreateUserId":
/*     */           try {
/* 307 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 308 */             setCreateUserId((String)value);
/* 309 */           } catch (Exception ee) {
/* 310 */             throw new DtxException("An exception occurred while calling setCreateUserId() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "UpdateDate":
/*     */           try {
/* 316 */             Object value = DaoUtils.getFieldValueForXmlString(91, fieldValue);
/* 317 */             setUpdateDate((Date)value);
/* 318 */           } catch (Exception ee) {
/* 319 */             throw new DtxException("An exception occurred while calling setUpdateDate() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "UpdateUserId":
/*     */           try {
/* 325 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 326 */             setUpdateUserId((String)value);
/* 327 */           } catch (Exception ee) {
/* 328 */             throw new DtxException("An exception occurred while calling setUpdateUserId() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "LineItemTypeCode":
/*     */           try {
/* 334 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 335 */             setLineItemTypeCode((String)value);
/* 336 */           } catch (Exception ee) {
/* 337 */             throw new DtxException("An exception occurred while calling setLineItemTypeCode() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "Amount":
/*     */           try {
/* 343 */             Object value = DaoUtils.getFieldValueForXmlString(3, fieldValue);
/* 344 */             setAmount((BigDecimal)value);
/* 345 */           } catch (Exception ee) {
/* 346 */             throw new DtxException("An exception occurred while calling setAmount() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "GlAccount":
/*     */           try {
/* 352 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 353 */             setGlAccount((String)value);
/* 354 */           } catch (Exception ee) {
/* 355 */             throw new DtxException("An exception occurred while calling setGlAccount() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "CustAccountId":
/*     */           try {
/* 361 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 362 */             setCustAccountId((String)value);
/* 363 */           } catch (Exception ee) {
/* 364 */             throw new DtxException("An exception occurred while calling setCustAccountId() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */       } 
/*     */     } 
/*     */   }
/*     */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\cwo\impl\InvoiceLineItemDAO.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */