/*     */ package dtv.xst.dao.cat.impl;
/*     */ 
/*     */ import dtv.data2.access.DaoUtils;
/*     */ import dtv.data2.access.IObjectId;
/*     */ import dtv.data2.access.exception.DtxException;
/*     */ import dtv.data2.access.impl.AbstractDAOImpl;
/*     */ import dtv.util.DtvDate;
/*     */ import dtv.xst.dao.cat.ChargeAccountInvoiceId;
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
/*     */ public class ChargeAccountInvoiceDAO
/*     */   extends AbstractDAOImpl
/*     */ {
/*     */   private static final long serialVersionUID = 749161524L;
/*  23 */   private static final Logger _logger = Logger.getLogger(ChargeAccountInvoiceDAO.class);
/*     */   
/*     */   private Long _organizationId;
/*     */   private String _custAccountId;
/*     */   private String _custAccountCode;
/*     */   private String _invoiceNumber;
/*     */   private DtvDate _createDate;
/*     */   private String _createUserId;
/*     */   private DtvDate _updateDate;
/*     */   private String _updateUserId;
/*     */   private BigDecimal _originalInvoiceBalance;
/*     */   private BigDecimal _invoiceBalance;
/*     */   private DtvDate _lastActivityDate;
/*     */   private DtvDate _invoiceDate;
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
/*     */   public String getCustAccountId() {
/*  49 */     return this._custAccountId;
/*     */   }
/*     */   
/*     */   public void setCustAccountId(String argCustAccountId) {
/*  53 */     if (changed(argCustAccountId, this._custAccountId, "custAccountId")) {
/*  54 */       this._custAccountId = (argCustAccountId != null && MANAGE_CASE) ? argCustAccountId.toUpperCase() : argCustAccountId;
/*     */     }
/*     */   }
/*     */   
/*     */   public String getCustAccountCode() {
/*  59 */     return this._custAccountCode;
/*     */   }
/*     */   
/*     */   public void setCustAccountCode(String argCustAccountCode) {
/*  63 */     if (changed(argCustAccountCode, this._custAccountCode, "custAccountCode")) {
/*  64 */       this._custAccountCode = (argCustAccountCode != null && MANAGE_CASE) ? argCustAccountCode.toUpperCase() : argCustAccountCode;
/*     */     }
/*     */   }
/*     */   
/*     */   public String getInvoiceNumber() {
/*  69 */     return this._invoiceNumber;
/*     */   }
/*     */   
/*     */   public void setInvoiceNumber(String argInvoiceNumber) {
/*  73 */     if (changed(argInvoiceNumber, this._invoiceNumber, "invoiceNumber")) {
/*  74 */       this._invoiceNumber = (argInvoiceNumber != null && MANAGE_CASE) ? argInvoiceNumber.toUpperCase() : argInvoiceNumber;
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
/*     */   public BigDecimal getOriginalInvoiceBalance() {
/* 121 */     return this._originalInvoiceBalance;
/*     */   }
/*     */   
/*     */   public void setOriginalInvoiceBalance(BigDecimal argOriginalInvoiceBalance) {
/* 125 */     if (changed(argOriginalInvoiceBalance, this._originalInvoiceBalance, "originalInvoiceBalance")) {
/* 126 */       this._originalInvoiceBalance = argOriginalInvoiceBalance;
/*     */     }
/*     */   }
/*     */   
/*     */   public BigDecimal getInvoiceBalance() {
/* 131 */     return this._invoiceBalance;
/*     */   }
/*     */   
/*     */   public void setInvoiceBalance(BigDecimal argInvoiceBalance) {
/* 135 */     if (changed(argInvoiceBalance, this._invoiceBalance, "invoiceBalance")) {
/* 136 */       this._invoiceBalance = argInvoiceBalance;
/*     */     }
/*     */   }
/*     */   
/*     */   public Date getLastActivityDate() {
/* 141 */     return (Date)this._lastActivityDate;
/*     */   }
/*     */   
/*     */   public void setLastActivityDate(Date argLastActivityDate) {
/* 145 */     if (changed(argLastActivityDate, this._lastActivityDate, "lastActivityDate")) {
/* 146 */       this._lastActivityDate = (argLastActivityDate == null || argLastActivityDate instanceof DtvDate) ? (DtvDate)argLastActivityDate : new DtvDate(argLastActivityDate);
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public Date getInvoiceDate() {
/* 152 */     return (Date)this._invoiceDate;
/*     */   }
/*     */   
/*     */   public void setInvoiceDate(Date argInvoiceDate) {
/* 156 */     if (changed(argInvoiceDate, this._invoiceDate, "invoiceDate")) {
/* 157 */       this._invoiceDate = (argInvoiceDate == null || argInvoiceDate instanceof DtvDate) ? (DtvDate)argInvoiceDate : new DtvDate(argInvoiceDate);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String toString() {
/* 165 */     StringBuilder buf = new StringBuilder(512);
/* 166 */     buf.append(super.toString()).append(" Id: ").append(getObjectId()).append(" Values: ");
/* 167 */     if (getOrganizationId() != null) {
/* 168 */       buf.append("organizationId").append("=").append(getOrganizationId()).append(" ");
/*     */     }
/* 170 */     if (getCustAccountId() != null) {
/* 171 */       buf.append("custAccountId").append("=").append(getCustAccountId()).append(" ");
/*     */     }
/* 173 */     if (getCustAccountCode() != null) {
/* 174 */       buf.append("custAccountCode").append("=").append(getCustAccountCode()).append(" ");
/*     */     }
/* 176 */     if (getInvoiceNumber() != null) {
/* 177 */       buf.append("invoiceNumber").append("=").append(getInvoiceNumber()).append(" ");
/*     */     }
/* 179 */     if (getCreateDate() != null) {
/* 180 */       buf.append("createDate").append("=").append(getCreateDate()).append(" ");
/*     */     }
/* 182 */     if (getCreateUserId() != null) {
/* 183 */       buf.append("createUserId").append("=").append(getCreateUserId()).append(" ");
/*     */     }
/* 185 */     if (getUpdateDate() != null) {
/* 186 */       buf.append("updateDate").append("=").append(getUpdateDate()).append(" ");
/*     */     }
/* 188 */     if (getUpdateUserId() != null) {
/* 189 */       buf.append("updateUserId").append("=").append(getUpdateUserId()).append(" ");
/*     */     }
/* 191 */     if (getOriginalInvoiceBalance() != null) {
/* 192 */       buf.append("originalInvoiceBalance").append("=").append(getOriginalInvoiceBalance()).append(" ");
/*     */     }
/* 194 */     if (getInvoiceBalance() != null) {
/* 195 */       buf.append("invoiceBalance").append("=").append(getInvoiceBalance()).append(" ");
/*     */     }
/* 197 */     if (getLastActivityDate() != null) {
/* 198 */       buf.append("lastActivityDate").append("=").append(getLastActivityDate()).append(" ");
/*     */     }
/* 200 */     if (getInvoiceDate() != null) {
/* 201 */       buf.append("invoiceDate").append("=").append(getInvoiceDate()).append(" ");
/*     */     }
/*     */     
/* 204 */     return buf.toString();
/*     */   }
/*     */   
/*     */   public IObjectId getObjectId() {
/* 208 */     ChargeAccountInvoiceId id = new ChargeAccountInvoiceId();
/* 209 */     id.setOrganizationId(getOrganizationId());
/* 210 */     id.setCustAccountId(getCustAccountId());
/* 211 */     id.setCustAccountCode(getCustAccountCode());
/* 212 */     id.setInvoiceNumber(getInvoiceNumber());
/* 213 */     return (IObjectId)id;
/*     */   }
/*     */   
/*     */   public void setObjectId(IObjectId argObjectId) {
/* 217 */     setOrganizationId(((ChargeAccountInvoiceId)argObjectId).getOrganizationId());
/* 218 */     setCustAccountId(((ChargeAccountInvoiceId)argObjectId).getCustAccountId());
/* 219 */     setCustAccountCode(((ChargeAccountInvoiceId)argObjectId).getCustAccountCode());
/* 220 */     setInvoiceNumber(((ChargeAccountInvoiceId)argObjectId).getInvoiceNumber());
/*     */   }
/*     */   
/*     */   public String getImplementingClass() {
/* 224 */     return null;
/*     */   }
/*     */   
/*     */   public String toXmlString() {
/* 228 */     StringBuilder buf = new StringBuilder(600);
/* 229 */     buf.append("<").append("dao").append(" name=\"ChargeAccountInvoice\" cmd=\"" + getObjectStateString() + "\">");
/* 230 */     getFieldsAsXml(buf);
/* 231 */     buf.append("</").append("dao").append(">");
/*     */     
/* 233 */     return buf.toString();
/*     */   }
/*     */   
/*     */   public Map<String, String> getValues() {
/* 237 */     Map<String, String> values = super.getValues();
/* 238 */     if (this._organizationId != null) values.put("OrganizationId", DaoUtils.getXmlSafeFieldValue(-5, this._organizationId)); 
/* 239 */     if (this._custAccountId != null) values.put("CustAccountId", DaoUtils.getXmlSafeFieldValue(12, this._custAccountId)); 
/* 240 */     if (this._custAccountCode != null) values.put("CustAccountCode", DaoUtils.getXmlSafeFieldValue(12, this._custAccountCode)); 
/* 241 */     if (this._invoiceNumber != null) values.put("InvoiceNumber", DaoUtils.getXmlSafeFieldValue(12, this._invoiceNumber)); 
/* 242 */     if (this._createDate != null) values.put("CreateDate", DaoUtils.getXmlSafeFieldValue(91, this._createDate)); 
/* 243 */     if (this._createUserId != null) values.put("CreateUserId", DaoUtils.getXmlSafeFieldValue(12, this._createUserId)); 
/* 244 */     if (this._updateDate != null) values.put("UpdateDate", DaoUtils.getXmlSafeFieldValue(91, this._updateDate)); 
/* 245 */     if (this._updateUserId != null) values.put("UpdateUserId", DaoUtils.getXmlSafeFieldValue(12, this._updateUserId)); 
/* 246 */     if (this._originalInvoiceBalance != null) values.put("OriginalInvoiceBalance", DaoUtils.getXmlSafeFieldValue(3, this._originalInvoiceBalance)); 
/* 247 */     if (this._invoiceBalance != null) values.put("InvoiceBalance", DaoUtils.getXmlSafeFieldValue(3, this._invoiceBalance)); 
/* 248 */     if (this._lastActivityDate != null) values.put("LastActivityDate", DaoUtils.getXmlSafeFieldValue(91, this._lastActivityDate)); 
/* 249 */     if (this._invoiceDate != null) values.put("InvoiceDate", DaoUtils.getXmlSafeFieldValue(91, this._invoiceDate)); 
/* 250 */     return values;
/*     */   }
/*     */ 
/*     */   
/*     */   public void setValues(Map<String, String> argValues) {
/* 255 */     super.setValues(argValues);
/* 256 */     for (Map.Entry<String, String> field : argValues.entrySet()) {
/*     */       
/* 258 */       String fieldName = field.getKey();
/* 259 */       String fieldValue = field.getValue();
/* 260 */       switch (fieldName) {
/*     */         
/*     */         case "OrganizationId":
/*     */           try {
/* 264 */             Object value = DaoUtils.getFieldValueForXmlString(-5, fieldValue);
/* 265 */             setOrganizationId((Long)value);
/* 266 */           } catch (Exception ee) {
/* 267 */             throw new DtxException("An exception occurred while calling setOrganizationId() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "CustAccountId":
/*     */           try {
/* 273 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 274 */             setCustAccountId((String)value);
/* 275 */           } catch (Exception ee) {
/* 276 */             throw new DtxException("An exception occurred while calling setCustAccountId() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "CustAccountCode":
/*     */           try {
/* 282 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 283 */             setCustAccountCode((String)value);
/* 284 */           } catch (Exception ee) {
/* 285 */             throw new DtxException("An exception occurred while calling setCustAccountCode() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "InvoiceNumber":
/*     */           try {
/* 291 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 292 */             setInvoiceNumber((String)value);
/* 293 */           } catch (Exception ee) {
/* 294 */             throw new DtxException("An exception occurred while calling setInvoiceNumber() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "CreateDate":
/*     */           try {
/* 300 */             Object value = DaoUtils.getFieldValueForXmlString(91, fieldValue);
/* 301 */             setCreateDate((Date)value);
/* 302 */           } catch (Exception ee) {
/* 303 */             throw new DtxException("An exception occurred while calling setCreateDate() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "CreateUserId":
/*     */           try {
/* 309 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 310 */             setCreateUserId((String)value);
/* 311 */           } catch (Exception ee) {
/* 312 */             throw new DtxException("An exception occurred while calling setCreateUserId() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "UpdateDate":
/*     */           try {
/* 318 */             Object value = DaoUtils.getFieldValueForXmlString(91, fieldValue);
/* 319 */             setUpdateDate((Date)value);
/* 320 */           } catch (Exception ee) {
/* 321 */             throw new DtxException("An exception occurred while calling setUpdateDate() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "UpdateUserId":
/*     */           try {
/* 327 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 328 */             setUpdateUserId((String)value);
/* 329 */           } catch (Exception ee) {
/* 330 */             throw new DtxException("An exception occurred while calling setUpdateUserId() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "OriginalInvoiceBalance":
/*     */           try {
/* 336 */             Object value = DaoUtils.getFieldValueForXmlString(3, fieldValue);
/* 337 */             setOriginalInvoiceBalance((BigDecimal)value);
/* 338 */           } catch (Exception ee) {
/* 339 */             throw new DtxException("An exception occurred while calling setOriginalInvoiceBalance() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "InvoiceBalance":
/*     */           try {
/* 345 */             Object value = DaoUtils.getFieldValueForXmlString(3, fieldValue);
/* 346 */             setInvoiceBalance((BigDecimal)value);
/* 347 */           } catch (Exception ee) {
/* 348 */             throw new DtxException("An exception occurred while calling setInvoiceBalance() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "LastActivityDate":
/*     */           try {
/* 354 */             Object value = DaoUtils.getFieldValueForXmlString(91, fieldValue);
/* 355 */             setLastActivityDate((Date)value);
/* 356 */           } catch (Exception ee) {
/* 357 */             throw new DtxException("An exception occurred while calling setLastActivityDate() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "InvoiceDate":
/*     */           try {
/* 363 */             Object value = DaoUtils.getFieldValueForXmlString(91, fieldValue);
/* 364 */             setInvoiceDate((Date)value);
/* 365 */           } catch (Exception ee) {
/* 366 */             throw new DtxException("An exception occurred while calling setInvoiceDate() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */       } 
/*     */     } 
/*     */   }
/*     */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\cat\impl\ChargeAccountInvoiceDAO.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */