/*     */ package dtv.xst.dao.itm.impl;
/*     */ 
/*     */ import dtv.data2.access.DaoUtils;
/*     */ import dtv.data2.access.IObjectId;
/*     */ import dtv.data2.access.exception.DtxException;
/*     */ import dtv.data2.access.impl.AbstractDAOImpl;
/*     */ import dtv.util.DtvDate;
/*     */ import dtv.xst.dao.itm.ItemMessageId;
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
/*     */ public class ItemMessageDAO
/*     */   extends AbstractDAOImpl
/*     */ {
/*     */   private static final long serialVersionUID = 2088876372L;
/*  23 */   private static final Logger _logger = Logger.getLogger(ItemMessageDAO.class);
/*     */   
/*     */   private String _messageId;
/*     */   private Long _organizationId;
/*     */   private DtvDate _effectiveDate;
/*     */   private String _orgCode;
/*     */   private String _orgValue;
/*     */   private DtvDate _createDate;
/*     */   private String _createUserId;
/*     */   private DtvDate _updateDate;
/*     */   private String _updateUserId;
/*     */   private String _contentType;
/*     */   private DtvDate _expirationDate;
/*     */   private String _messageKey;
/*     */   private String _titleKey;
/*     */   
/*     */   public String getMessageId() {
/*  40 */     return this._messageId;
/*     */   }
/*     */   
/*     */   public void setMessageId(String argMessageId) {
/*  44 */     if (changed(argMessageId, this._messageId, "messageId")) {
/*  45 */       this._messageId = (argMessageId != null && MANAGE_CASE) ? argMessageId.toUpperCase() : argMessageId;
/*     */     }
/*     */   }
/*     */   
/*     */   public Long getOrganizationId() {
/*  50 */     return this._organizationId;
/*     */   }
/*     */   
/*     */   public void setOrganizationId(Long argOrganizationId) {
/*  54 */     if (changed(argOrganizationId, this._organizationId, "organizationId")) {
/*  55 */       this._organizationId = argOrganizationId;
/*     */     }
/*     */   }
/*     */   
/*     */   public Date getEffectiveDate() {
/*  60 */     return (Date)this._effectiveDate;
/*     */   }
/*     */   
/*     */   public void setEffectiveDate(Date argEffectiveDate) {
/*  64 */     if (changed(argEffectiveDate, this._effectiveDate, "effectiveDate")) {
/*  65 */       this._effectiveDate = (argEffectiveDate == null || argEffectiveDate instanceof DtvDate) ? (DtvDate)argEffectiveDate : new DtvDate(argEffectiveDate);
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public String getOrgCode() {
/*  71 */     return this._orgCode;
/*     */   }
/*     */   
/*     */   public void setOrgCode(String argOrgCode) {
/*  75 */     if (changed(argOrgCode, this._orgCode, "orgCode")) {
/*  76 */       this._orgCode = argOrgCode;
/*     */     }
/*     */   }
/*     */   
/*     */   public String getOrgValue() {
/*  81 */     return this._orgValue;
/*     */   }
/*     */   
/*     */   public void setOrgValue(String argOrgValue) {
/*  85 */     if (changed(argOrgValue, this._orgValue, "orgValue")) {
/*  86 */       this._orgValue = argOrgValue;
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
/*     */   public String getContentType() {
/* 133 */     return this._contentType;
/*     */   }
/*     */   
/*     */   public void setContentType(String argContentType) {
/* 137 */     if (changed(argContentType, this._contentType, "contentType")) {
/* 138 */       this._contentType = argContentType;
/*     */     }
/*     */   }
/*     */   
/*     */   public Date getExpirationDate() {
/* 143 */     return (Date)this._expirationDate;
/*     */   }
/*     */   
/*     */   public void setExpirationDate(Date argExpirationDate) {
/* 147 */     if (changed(argExpirationDate, this._expirationDate, "expirationDate")) {
/* 148 */       this._expirationDate = (argExpirationDate == null || argExpirationDate instanceof DtvDate) ? (DtvDate)argExpirationDate : new DtvDate(argExpirationDate);
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public String getMessageKey() {
/* 154 */     return this._messageKey;
/*     */   }
/*     */   
/*     */   public void setMessageKey(String argMessageKey) {
/* 158 */     if (changed(argMessageKey, this._messageKey, "messageKey")) {
/* 159 */       this._messageKey = argMessageKey;
/*     */     }
/*     */   }
/*     */   
/*     */   public String getTitleKey() {
/* 164 */     return this._titleKey;
/*     */   }
/*     */   
/*     */   public void setTitleKey(String argTitleKey) {
/* 168 */     if (changed(argTitleKey, this._titleKey, "titleKey")) {
/* 169 */       this._titleKey = argTitleKey;
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public String toString() {
/* 176 */     StringBuilder buf = new StringBuilder(512);
/* 177 */     buf.append(super.toString()).append(" Id: ").append(getObjectId()).append(" Values: ");
/* 178 */     if (getMessageId() != null) {
/* 179 */       buf.append("messageId").append("=").append(getMessageId()).append(" ");
/*     */     }
/* 181 */     if (getOrganizationId() != null) {
/* 182 */       buf.append("organizationId").append("=").append(getOrganizationId()).append(" ");
/*     */     }
/* 184 */     if (getEffectiveDate() != null) {
/* 185 */       buf.append("effectiveDate").append("=").append(getEffectiveDate()).append(" ");
/*     */     }
/* 187 */     if (getOrgCode() != null) {
/* 188 */       buf.append("orgCode").append("=").append(getOrgCode()).append(" ");
/*     */     }
/* 190 */     if (getOrgValue() != null) {
/* 191 */       buf.append("orgValue").append("=").append(getOrgValue()).append(" ");
/*     */     }
/* 193 */     if (getCreateDate() != null) {
/* 194 */       buf.append("createDate").append("=").append(getCreateDate()).append(" ");
/*     */     }
/* 196 */     if (getCreateUserId() != null) {
/* 197 */       buf.append("createUserId").append("=").append(getCreateUserId()).append(" ");
/*     */     }
/* 199 */     if (getUpdateDate() != null) {
/* 200 */       buf.append("updateDate").append("=").append(getUpdateDate()).append(" ");
/*     */     }
/* 202 */     if (getUpdateUserId() != null) {
/* 203 */       buf.append("updateUserId").append("=").append(getUpdateUserId()).append(" ");
/*     */     }
/* 205 */     if (getContentType() != null) {
/* 206 */       buf.append("contentType").append("=").append(getContentType()).append(" ");
/*     */     }
/* 208 */     if (getExpirationDate() != null) {
/* 209 */       buf.append("expirationDate").append("=").append(getExpirationDate()).append(" ");
/*     */     }
/* 211 */     if (getMessageKey() != null) {
/* 212 */       buf.append("messageKey").append("=").append(getMessageKey()).append(" ");
/*     */     }
/* 214 */     if (getTitleKey() != null) {
/* 215 */       buf.append("titleKey").append("=").append(getTitleKey()).append(" ");
/*     */     }
/*     */     
/* 218 */     return buf.toString();
/*     */   }
/*     */   
/*     */   public IObjectId getObjectId() {
/* 222 */     ItemMessageId id = new ItemMessageId();
/* 223 */     id.setMessageId(getMessageId());
/* 224 */     id.setOrganizationId(getOrganizationId());
/* 225 */     id.setEffectiveDate(getEffectiveDate());
/* 226 */     return (IObjectId)id;
/*     */   }
/*     */   
/*     */   public void setObjectId(IObjectId argObjectId) {
/* 230 */     setMessageId(((ItemMessageId)argObjectId).getMessageId());
/* 231 */     setOrganizationId(((ItemMessageId)argObjectId).getOrganizationId());
/* 232 */     setEffectiveDate(((ItemMessageId)argObjectId).getEffectiveDate());
/*     */   }
/*     */   
/*     */   public String getImplementingClass() {
/* 236 */     return null;
/*     */   }
/*     */   
/*     */   public String toXmlString() {
/* 240 */     StringBuilder buf = new StringBuilder(650);
/* 241 */     buf.append("<").append("dao").append(" name=\"ItemMessage\" cmd=\"" + getObjectStateString() + "\">");
/* 242 */     getFieldsAsXml(buf);
/* 243 */     buf.append("</").append("dao").append(">");
/*     */     
/* 245 */     return buf.toString();
/*     */   }
/*     */   
/*     */   public Map<String, String> getValues() {
/* 249 */     Map<String, String> values = super.getValues();
/* 250 */     if (this._messageId != null) values.put("MessageId", DaoUtils.getXmlSafeFieldValue(12, this._messageId)); 
/* 251 */     if (this._organizationId != null) values.put("OrganizationId", DaoUtils.getXmlSafeFieldValue(-5, this._organizationId)); 
/* 252 */     if (this._effectiveDate != null) values.put("EffectiveDate", DaoUtils.getXmlSafeFieldValue(91, this._effectiveDate)); 
/* 253 */     if (this._orgCode != null) values.put("OrgCode", DaoUtils.getXmlSafeFieldValue(12, this._orgCode)); 
/* 254 */     if (this._orgValue != null) values.put("OrgValue", DaoUtils.getXmlSafeFieldValue(12, this._orgValue)); 
/* 255 */     if (this._createDate != null) values.put("CreateDate", DaoUtils.getXmlSafeFieldValue(91, this._createDate)); 
/* 256 */     if (this._createUserId != null) values.put("CreateUserId", DaoUtils.getXmlSafeFieldValue(12, this._createUserId)); 
/* 257 */     if (this._updateDate != null) values.put("UpdateDate", DaoUtils.getXmlSafeFieldValue(91, this._updateDate)); 
/* 258 */     if (this._updateUserId != null) values.put("UpdateUserId", DaoUtils.getXmlSafeFieldValue(12, this._updateUserId)); 
/* 259 */     if (this._contentType != null) values.put("ContentType", DaoUtils.getXmlSafeFieldValue(12, this._contentType)); 
/* 260 */     if (this._expirationDate != null) values.put("ExpirationDate", DaoUtils.getXmlSafeFieldValue(91, this._expirationDate)); 
/* 261 */     if (this._messageKey != null) values.put("MessageKey", DaoUtils.getXmlSafeFieldValue(12, this._messageKey)); 
/* 262 */     if (this._titleKey != null) values.put("TitleKey", DaoUtils.getXmlSafeFieldValue(12, this._titleKey)); 
/* 263 */     return values;
/*     */   }
/*     */ 
/*     */   
/*     */   public void setValues(Map<String, String> argValues) {
/* 268 */     super.setValues(argValues);
/* 269 */     for (Map.Entry<String, String> field : argValues.entrySet()) {
/*     */       
/* 271 */       String fieldName = field.getKey();
/* 272 */       String fieldValue = field.getValue();
/* 273 */       switch (fieldName) {
/*     */         
/*     */         case "MessageId":
/*     */           try {
/* 277 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 278 */             setMessageId((String)value);
/* 279 */           } catch (Exception ee) {
/* 280 */             throw new DtxException("An exception occurred while calling setMessageId() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "OrganizationId":
/*     */           try {
/* 286 */             Object value = DaoUtils.getFieldValueForXmlString(-5, fieldValue);
/* 287 */             setOrganizationId((Long)value);
/* 288 */           } catch (Exception ee) {
/* 289 */             throw new DtxException("An exception occurred while calling setOrganizationId() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "EffectiveDate":
/*     */           try {
/* 295 */             Object value = DaoUtils.getFieldValueForXmlString(91, fieldValue);
/* 296 */             setEffectiveDate((Date)value);
/* 297 */           } catch (Exception ee) {
/* 298 */             throw new DtxException("An exception occurred while calling setEffectiveDate() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "OrgCode":
/*     */           try {
/* 304 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 305 */             setOrgCode((String)value);
/* 306 */           } catch (Exception ee) {
/* 307 */             throw new DtxException("An exception occurred while calling setOrgCode() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "OrgValue":
/*     */           try {
/* 313 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 314 */             setOrgValue((String)value);
/* 315 */           } catch (Exception ee) {
/* 316 */             throw new DtxException("An exception occurred while calling setOrgValue() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "CreateDate":
/*     */           try {
/* 322 */             Object value = DaoUtils.getFieldValueForXmlString(91, fieldValue);
/* 323 */             setCreateDate((Date)value);
/* 324 */           } catch (Exception ee) {
/* 325 */             throw new DtxException("An exception occurred while calling setCreateDate() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "CreateUserId":
/*     */           try {
/* 331 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 332 */             setCreateUserId((String)value);
/* 333 */           } catch (Exception ee) {
/* 334 */             throw new DtxException("An exception occurred while calling setCreateUserId() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "UpdateDate":
/*     */           try {
/* 340 */             Object value = DaoUtils.getFieldValueForXmlString(91, fieldValue);
/* 341 */             setUpdateDate((Date)value);
/* 342 */           } catch (Exception ee) {
/* 343 */             throw new DtxException("An exception occurred while calling setUpdateDate() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "UpdateUserId":
/*     */           try {
/* 349 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 350 */             setUpdateUserId((String)value);
/* 351 */           } catch (Exception ee) {
/* 352 */             throw new DtxException("An exception occurred while calling setUpdateUserId() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "ContentType":
/*     */           try {
/* 358 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 359 */             setContentType((String)value);
/* 360 */           } catch (Exception ee) {
/* 361 */             throw new DtxException("An exception occurred while calling setContentType() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "ExpirationDate":
/*     */           try {
/* 367 */             Object value = DaoUtils.getFieldValueForXmlString(91, fieldValue);
/* 368 */             setExpirationDate((Date)value);
/* 369 */           } catch (Exception ee) {
/* 370 */             throw new DtxException("An exception occurred while calling setExpirationDate() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "MessageKey":
/*     */           try {
/* 376 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 377 */             setMessageKey((String)value);
/* 378 */           } catch (Exception ee) {
/* 379 */             throw new DtxException("An exception occurred while calling setMessageKey() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "TitleKey":
/*     */           try {
/* 385 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 386 */             setTitleKey((String)value);
/* 387 */           } catch (Exception ee) {
/* 388 */             throw new DtxException("An exception occurred while calling setTitleKey() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */       } 
/*     */     } 
/*     */   }
/*     */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\itm\impl\ItemMessageDAO.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */