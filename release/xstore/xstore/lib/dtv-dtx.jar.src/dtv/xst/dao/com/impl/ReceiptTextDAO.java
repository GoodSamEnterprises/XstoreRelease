/*     */ package dtv.xst.dao.com.impl;
/*     */ 
/*     */ import dtv.data2.access.DaoUtils;
/*     */ import dtv.data2.access.IHasConfigElement;
/*     */ import dtv.data2.access.IObjectId;
/*     */ import dtv.data2.access.exception.DtxException;
/*     */ import dtv.data2.access.impl.AbstractDAOImpl;
/*     */ import dtv.util.DtvDate;
/*     */ import dtv.xst.dao.com.ReceiptTextId;
/*     */ import java.util.Date;
/*     */ import java.util.Map;
/*     */ import org.apache.log4j.Logger;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class ReceiptTextDAO
/*     */   extends AbstractDAOImpl
/*     */   implements IHasConfigElement
/*     */ {
/*     */   private static final long serialVersionUID = -593496219L;
/*  23 */   private static final Logger _logger = Logger.getLogger(ReceiptTextDAO.class);
/*     */   
/*     */   private Long _organizationId;
/*     */   private String _textCode;
/*     */   private Integer _textSequence;
/*     */   private String _textSubcode;
/*     */   private String _configElement;
/*     */   private DtvDate _createDate;
/*     */   private String _createUserId;
/*     */   private DtvDate _updateDate;
/*     */   private String _updateUserId;
/*     */   private String _receiptText;
/*     */   private DtvDate _effectiveDate;
/*     */   private DtvDate _expirationDate;
/*     */   private String _lineFormat;
/*  38 */   private Boolean _reformat = Boolean.FALSE;
/*     */   
/*     */   public Long getOrganizationId() {
/*  41 */     return this._organizationId;
/*     */   }
/*     */   
/*     */   public void setOrganizationId(Long argOrganizationId) {
/*  45 */     if (changed(argOrganizationId, this._organizationId, "organizationId")) {
/*  46 */       this._organizationId = argOrganizationId;
/*     */     }
/*     */   }
/*     */   
/*     */   public String getTextCode() {
/*  51 */     return this._textCode;
/*     */   }
/*     */   
/*     */   public void setTextCode(String argTextCode) {
/*  55 */     if (changed(argTextCode, this._textCode, "textCode")) {
/*  56 */       this._textCode = (argTextCode != null && MANAGE_CASE) ? argTextCode.toUpperCase() : argTextCode;
/*     */     }
/*     */   }
/*     */   
/*     */   public Integer getTextSequence() {
/*  61 */     return this._textSequence;
/*     */   }
/*     */   
/*     */   public void setTextSequence(Integer argTextSequence) {
/*  65 */     if (changed(argTextSequence, this._textSequence, "textSequence")) {
/*  66 */       this._textSequence = argTextSequence;
/*     */     }
/*     */   }
/*     */   
/*     */   public String getTextSubcode() {
/*  71 */     return this._textSubcode;
/*     */   }
/*     */   
/*     */   public void setTextSubcode(String argTextSubcode) {
/*  75 */     if (changed(argTextSubcode, this._textSubcode, "textSubcode")) {
/*  76 */       this._textSubcode = (argTextSubcode != null && MANAGE_CASE) ? argTextSubcode.toUpperCase() : argTextSubcode;
/*     */     }
/*     */   }
/*     */   
/*     */   public String getConfigElement() {
/*  81 */     return this._configElement;
/*     */   }
/*     */   
/*     */   public void setConfigElement(String argConfigElement) {
/*  85 */     if (changed(argConfigElement, this._configElement, "configElement")) {
/*  86 */       this._configElement = (argConfigElement != null && MANAGE_CASE) ? argConfigElement.toUpperCase() : argConfigElement;
/*     */     }
/*     */   }
/*     */   
/*     */   public Date getCreateDate() {
/*  91 */     return (Date)this._createDate;
/*     */   }
/*     */   
/*     */   public void setCreateDate(Date argCreateDate) {
/*  95 */     if (changed(argCreateDate, this._createDate, "createDate")) {
/*  96 */       this._createDate = (argCreateDate == null || argCreateDate instanceof DtvDate) ? (DtvDate)argCreateDate : new DtvDate(argCreateDate);
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public String getCreateUserId() {
/* 102 */     return this._createUserId;
/*     */   }
/*     */   
/*     */   public void setCreateUserId(String argCreateUserId) {
/* 106 */     if (changed(argCreateUserId, this._createUserId, "createUserId")) {
/* 107 */       this._createUserId = argCreateUserId;
/*     */     }
/*     */   }
/*     */   
/*     */   public Date getUpdateDate() {
/* 112 */     return (Date)this._updateDate;
/*     */   }
/*     */   
/*     */   public void setUpdateDate(Date argUpdateDate) {
/* 116 */     if (changed(argUpdateDate, this._updateDate, "updateDate")) {
/* 117 */       this._updateDate = (argUpdateDate == null || argUpdateDate instanceof DtvDate) ? (DtvDate)argUpdateDate : new DtvDate(argUpdateDate);
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public String getUpdateUserId() {
/* 123 */     return this._updateUserId;
/*     */   }
/*     */   
/*     */   public void setUpdateUserId(String argUpdateUserId) {
/* 127 */     if (changed(argUpdateUserId, this._updateUserId, "updateUserId")) {
/* 128 */       this._updateUserId = argUpdateUserId;
/*     */     }
/*     */   }
/*     */   
/*     */   public String getReceiptText() {
/* 133 */     return this._receiptText;
/*     */   }
/*     */   
/*     */   public void setReceiptText(String argReceiptText) {
/* 137 */     if (changed(argReceiptText, this._receiptText, "receiptText")) {
/* 138 */       this._receiptText = argReceiptText;
/*     */     }
/*     */   }
/*     */   
/*     */   public Date getEffectiveDate() {
/* 143 */     return (Date)this._effectiveDate;
/*     */   }
/*     */   
/*     */   public void setEffectiveDate(Date argEffectiveDate) {
/* 147 */     if (changed(argEffectiveDate, this._effectiveDate, "effectiveDate")) {
/* 148 */       this._effectiveDate = (argEffectiveDate == null || argEffectiveDate instanceof DtvDate) ? (DtvDate)argEffectiveDate : new DtvDate(argEffectiveDate);
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public Date getExpirationDate() {
/* 154 */     return (Date)this._expirationDate;
/*     */   }
/*     */   
/*     */   public void setExpirationDate(Date argExpirationDate) {
/* 158 */     if (changed(argExpirationDate, this._expirationDate, "expirationDate")) {
/* 159 */       this._expirationDate = (argExpirationDate == null || argExpirationDate instanceof DtvDate) ? (DtvDate)argExpirationDate : new DtvDate(argExpirationDate);
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public String getLineFormat() {
/* 165 */     return this._lineFormat;
/*     */   }
/*     */   
/*     */   public void setLineFormat(String argLineFormat) {
/* 169 */     if (changed(argLineFormat, this._lineFormat, "lineFormat")) {
/* 170 */       this._lineFormat = argLineFormat;
/*     */     }
/*     */   }
/*     */   
/*     */   public Boolean getReformat() {
/* 175 */     return this._reformat;
/*     */   }
/*     */   
/*     */   public void setReformat(Boolean argReformat) {
/* 179 */     if (changed(argReformat, this._reformat, "reformat")) {
/* 180 */       this._reformat = argReformat;
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public String toString() {
/* 187 */     StringBuilder buf = new StringBuilder(512);
/* 188 */     buf.append(super.toString()).append(" Id: ").append(getObjectId()).append(" Values: ");
/* 189 */     if (getOrganizationId() != null) {
/* 190 */       buf.append("organizationId").append("=").append(getOrganizationId()).append(" ");
/*     */     }
/* 192 */     if (getTextCode() != null) {
/* 193 */       buf.append("textCode").append("=").append(getTextCode()).append(" ");
/*     */     }
/* 195 */     if (getTextSequence() != null) {
/* 196 */       buf.append("textSequence").append("=").append(getTextSequence()).append(" ");
/*     */     }
/* 198 */     if (getTextSubcode() != null) {
/* 199 */       buf.append("textSubcode").append("=").append(getTextSubcode()).append(" ");
/*     */     }
/* 201 */     if (getConfigElement() != null) {
/* 202 */       buf.append("configElement").append("=").append(getConfigElement()).append(" ");
/*     */     }
/* 204 */     if (getCreateDate() != null) {
/* 205 */       buf.append("createDate").append("=").append(getCreateDate()).append(" ");
/*     */     }
/* 207 */     if (getCreateUserId() != null) {
/* 208 */       buf.append("createUserId").append("=").append(getCreateUserId()).append(" ");
/*     */     }
/* 210 */     if (getUpdateDate() != null) {
/* 211 */       buf.append("updateDate").append("=").append(getUpdateDate()).append(" ");
/*     */     }
/* 213 */     if (getUpdateUserId() != null) {
/* 214 */       buf.append("updateUserId").append("=").append(getUpdateUserId()).append(" ");
/*     */     }
/* 216 */     if (getReceiptText() != null) {
/* 217 */       buf.append("receiptText").append("=").append(getReceiptText()).append(" ");
/*     */     }
/* 219 */     if (getEffectiveDate() != null) {
/* 220 */       buf.append("effectiveDate").append("=").append(getEffectiveDate()).append(" ");
/*     */     }
/* 222 */     if (getExpirationDate() != null) {
/* 223 */       buf.append("expirationDate").append("=").append(getExpirationDate()).append(" ");
/*     */     }
/* 225 */     if (getLineFormat() != null) {
/* 226 */       buf.append("lineFormat").append("=").append(getLineFormat()).append(" ");
/*     */     }
/* 228 */     if (getReformat() != null && getReformat().booleanValue()) {
/* 229 */       buf.append("reformat").append("=").append(getReformat()).append(" ");
/*     */     }
/*     */     
/* 232 */     return buf.toString();
/*     */   }
/*     */   
/*     */   public IObjectId getObjectId() {
/* 236 */     ReceiptTextId id = new ReceiptTextId();
/* 237 */     id.setOrganizationId(getOrganizationId());
/* 238 */     id.setTextCode(getTextCode());
/* 239 */     id.setTextSequence(getTextSequence());
/* 240 */     id.setTextSubcode(getTextSubcode());
/* 241 */     id.setConfigElement(getConfigElement());
/* 242 */     return (IObjectId)id;
/*     */   }
/*     */   
/*     */   public void setObjectId(IObjectId argObjectId) {
/* 246 */     setOrganizationId(((ReceiptTextId)argObjectId).getOrganizationId());
/* 247 */     setTextCode(((ReceiptTextId)argObjectId).getTextCode());
/* 248 */     setTextSequence(((ReceiptTextId)argObjectId).getTextSequence());
/* 249 */     setTextSubcode(((ReceiptTextId)argObjectId).getTextSubcode());
/* 250 */     setConfigElement(((ReceiptTextId)argObjectId).getConfigElement());
/*     */   }
/*     */   
/*     */   public String getImplementingClass() {
/* 254 */     return null;
/*     */   }
/*     */   
/*     */   public String toXmlString() {
/* 258 */     StringBuilder buf = new StringBuilder(700);
/* 259 */     buf.append("<").append("dao").append(" name=\"ReceiptText\" cmd=\"" + getObjectStateString() + "\">");
/* 260 */     getFieldsAsXml(buf);
/* 261 */     buf.append("</").append("dao").append(">");
/*     */     
/* 263 */     return buf.toString();
/*     */   }
/*     */   
/*     */   public Map<String, String> getValues() {
/* 267 */     Map<String, String> values = super.getValues();
/* 268 */     if (this._organizationId != null) values.put("OrganizationId", DaoUtils.getXmlSafeFieldValue(-5, this._organizationId)); 
/* 269 */     if (this._textCode != null) values.put("TextCode", DaoUtils.getXmlSafeFieldValue(12, this._textCode)); 
/* 270 */     if (this._textSequence != null) values.put("TextSequence", DaoUtils.getXmlSafeFieldValue(4, this._textSequence)); 
/* 271 */     if (this._textSubcode != null) values.put("TextSubcode", DaoUtils.getXmlSafeFieldValue(12, this._textSubcode)); 
/* 272 */     if (this._configElement != null) values.put("ConfigElement", DaoUtils.getXmlSafeFieldValue(12, this._configElement)); 
/* 273 */     if (this._createDate != null) values.put("CreateDate", DaoUtils.getXmlSafeFieldValue(91, this._createDate)); 
/* 274 */     if (this._createUserId != null) values.put("CreateUserId", DaoUtils.getXmlSafeFieldValue(12, this._createUserId)); 
/* 275 */     if (this._updateDate != null) values.put("UpdateDate", DaoUtils.getXmlSafeFieldValue(91, this._updateDate)); 
/* 276 */     if (this._updateUserId != null) values.put("UpdateUserId", DaoUtils.getXmlSafeFieldValue(12, this._updateUserId)); 
/* 277 */     if (this._receiptText != null) values.put("ReceiptText", DaoUtils.getXmlSafeFieldValue(12, this._receiptText)); 
/* 278 */     if (this._effectiveDate != null) values.put("EffectiveDate", DaoUtils.getXmlSafeFieldValue(91, this._effectiveDate)); 
/* 279 */     if (this._expirationDate != null) values.put("ExpirationDate", DaoUtils.getXmlSafeFieldValue(91, this._expirationDate)); 
/* 280 */     if (this._lineFormat != null) values.put("LineFormat", DaoUtils.getXmlSafeFieldValue(12, this._lineFormat)); 
/* 281 */     if (this._reformat != null) values.put("Reformat", DaoUtils.getXmlSafeFieldValue(-7, this._reformat)); 
/* 282 */     return values;
/*     */   }
/*     */ 
/*     */   
/*     */   public void setValues(Map<String, String> argValues) {
/* 287 */     super.setValues(argValues);
/* 288 */     for (Map.Entry<String, String> field : argValues.entrySet()) {
/*     */       
/* 290 */       String fieldName = field.getKey();
/* 291 */       String fieldValue = field.getValue();
/* 292 */       switch (fieldName) {
/*     */         
/*     */         case "OrganizationId":
/*     */           try {
/* 296 */             Object value = DaoUtils.getFieldValueForXmlString(-5, fieldValue);
/* 297 */             setOrganizationId((Long)value);
/* 298 */           } catch (Exception ee) {
/* 299 */             throw new DtxException("An exception occurred while calling setOrganizationId() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "TextCode":
/*     */           try {
/* 305 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 306 */             setTextCode((String)value);
/* 307 */           } catch (Exception ee) {
/* 308 */             throw new DtxException("An exception occurred while calling setTextCode() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "TextSequence":
/*     */           try {
/* 314 */             Object value = DaoUtils.getFieldValueForXmlString(4, fieldValue);
/* 315 */             setTextSequence((Integer)value);
/* 316 */           } catch (Exception ee) {
/* 317 */             throw new DtxException("An exception occurred while calling setTextSequence() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "TextSubcode":
/*     */           try {
/* 323 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 324 */             setTextSubcode((String)value);
/* 325 */           } catch (Exception ee) {
/* 326 */             throw new DtxException("An exception occurred while calling setTextSubcode() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "ConfigElement":
/*     */           try {
/* 332 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 333 */             setConfigElement((String)value);
/* 334 */           } catch (Exception ee) {
/* 335 */             throw new DtxException("An exception occurred while calling setConfigElement() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "CreateDate":
/*     */           try {
/* 341 */             Object value = DaoUtils.getFieldValueForXmlString(91, fieldValue);
/* 342 */             setCreateDate((Date)value);
/* 343 */           } catch (Exception ee) {
/* 344 */             throw new DtxException("An exception occurred while calling setCreateDate() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "CreateUserId":
/*     */           try {
/* 350 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 351 */             setCreateUserId((String)value);
/* 352 */           } catch (Exception ee) {
/* 353 */             throw new DtxException("An exception occurred while calling setCreateUserId() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "UpdateDate":
/*     */           try {
/* 359 */             Object value = DaoUtils.getFieldValueForXmlString(91, fieldValue);
/* 360 */             setUpdateDate((Date)value);
/* 361 */           } catch (Exception ee) {
/* 362 */             throw new DtxException("An exception occurred while calling setUpdateDate() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "UpdateUserId":
/*     */           try {
/* 368 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 369 */             setUpdateUserId((String)value);
/* 370 */           } catch (Exception ee) {
/* 371 */             throw new DtxException("An exception occurred while calling setUpdateUserId() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "ReceiptText":
/*     */           try {
/* 377 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 378 */             setReceiptText((String)value);
/* 379 */           } catch (Exception ee) {
/* 380 */             throw new DtxException("An exception occurred while calling setReceiptText() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "EffectiveDate":
/*     */           try {
/* 386 */             Object value = DaoUtils.getFieldValueForXmlString(91, fieldValue);
/* 387 */             setEffectiveDate((Date)value);
/* 388 */           } catch (Exception ee) {
/* 389 */             throw new DtxException("An exception occurred while calling setEffectiveDate() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "ExpirationDate":
/*     */           try {
/* 395 */             Object value = DaoUtils.getFieldValueForXmlString(91, fieldValue);
/* 396 */             setExpirationDate((Date)value);
/* 397 */           } catch (Exception ee) {
/* 398 */             throw new DtxException("An exception occurred while calling setExpirationDate() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "LineFormat":
/*     */           try {
/* 404 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 405 */             setLineFormat((String)value);
/* 406 */           } catch (Exception ee) {
/* 407 */             throw new DtxException("An exception occurred while calling setLineFormat() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "Reformat":
/*     */           try {
/* 413 */             Object value = DaoUtils.getFieldValueForXmlString(-7, fieldValue);
/* 414 */             setReformat((Boolean)value);
/* 415 */           } catch (Exception ee) {
/* 416 */             throw new DtxException("An exception occurred while calling setReformat() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */       } 
/*     */     } 
/*     */   }
/*     */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\com\impl\ReceiptTextDAO.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */