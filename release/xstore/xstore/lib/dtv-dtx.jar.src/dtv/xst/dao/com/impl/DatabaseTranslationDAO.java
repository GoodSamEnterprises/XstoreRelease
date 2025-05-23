/*     */ package dtv.xst.dao.com.impl;
/*     */ 
/*     */ import dtv.data2.access.DaoUtils;
/*     */ import dtv.data2.access.IObjectId;
/*     */ import dtv.data2.access.exception.DtxException;
/*     */ import dtv.data2.access.impl.AbstractDAOImpl;
/*     */ import dtv.util.DtvDate;
/*     */ import dtv.xst.dao.com.DatabaseTranslationId;
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
/*     */ public class DatabaseTranslationDAO
/*     */   extends AbstractDAOImpl
/*     */ {
/*     */   private static final long serialVersionUID = 1081353750L;
/*  23 */   private static final Logger _logger = Logger.getLogger(DatabaseTranslationDAO.class);
/*     */   
/*     */   private Long _organizationId;
/*     */   private String _locale;
/*     */   private String _translationKey;
/*     */   private DtvDate _createDate;
/*     */   private String _createUserId;
/*     */   private DtvDate _updateDate;
/*     */   private String _updateUserId;
/*     */   private String _orgCode;
/*     */   private String _orgValue;
/*     */   private String _translation;
/*     */   private String _externalSystem;
/*     */   
/*     */   public Long getOrganizationId() {
/*  38 */     return this._organizationId;
/*     */   }
/*     */   
/*     */   public void setOrganizationId(Long argOrganizationId) {
/*  42 */     if (changed(argOrganizationId, this._organizationId, "organizationId")) {
/*  43 */       this._organizationId = argOrganizationId;
/*     */     }
/*     */   }
/*     */   
/*     */   public String getLocale() {
/*  48 */     return this._locale;
/*     */   }
/*     */   
/*     */   public void setLocale(String argLocale) {
/*  52 */     if (changed(argLocale, this._locale, "locale")) {
/*  53 */       this._locale = (argLocale != null && MANAGE_CASE) ? argLocale.toUpperCase() : argLocale;
/*     */     }
/*     */   }
/*     */   
/*     */   public String getTranslationKey() {
/*  58 */     return this._translationKey;
/*     */   }
/*     */   
/*     */   public void setTranslationKey(String argTranslationKey) {
/*  62 */     if (changed(argTranslationKey, this._translationKey, "translationKey")) {
/*  63 */       this._translationKey = (argTranslationKey != null && MANAGE_CASE) ? argTranslationKey.toUpperCase() : argTranslationKey;
/*     */     }
/*     */   }
/*     */   
/*     */   public Date getCreateDate() {
/*  68 */     return (Date)this._createDate;
/*     */   }
/*     */   
/*     */   public void setCreateDate(Date argCreateDate) {
/*  72 */     if (changed(argCreateDate, this._createDate, "createDate")) {
/*  73 */       this._createDate = (argCreateDate == null || argCreateDate instanceof DtvDate) ? (DtvDate)argCreateDate : new DtvDate(argCreateDate);
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public String getCreateUserId() {
/*  79 */     return this._createUserId;
/*     */   }
/*     */   
/*     */   public void setCreateUserId(String argCreateUserId) {
/*  83 */     if (changed(argCreateUserId, this._createUserId, "createUserId")) {
/*  84 */       this._createUserId = argCreateUserId;
/*     */     }
/*     */   }
/*     */   
/*     */   public Date getUpdateDate() {
/*  89 */     return (Date)this._updateDate;
/*     */   }
/*     */   
/*     */   public void setUpdateDate(Date argUpdateDate) {
/*  93 */     if (changed(argUpdateDate, this._updateDate, "updateDate")) {
/*  94 */       this._updateDate = (argUpdateDate == null || argUpdateDate instanceof DtvDate) ? (DtvDate)argUpdateDate : new DtvDate(argUpdateDate);
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public String getUpdateUserId() {
/* 100 */     return this._updateUserId;
/*     */   }
/*     */   
/*     */   public void setUpdateUserId(String argUpdateUserId) {
/* 104 */     if (changed(argUpdateUserId, this._updateUserId, "updateUserId")) {
/* 105 */       this._updateUserId = argUpdateUserId;
/*     */     }
/*     */   }
/*     */   
/*     */   public String getOrgCode() {
/* 110 */     return this._orgCode;
/*     */   }
/*     */   
/*     */   public void setOrgCode(String argOrgCode) {
/* 114 */     if (changed(argOrgCode, this._orgCode, "orgCode")) {
/* 115 */       this._orgCode = argOrgCode;
/*     */     }
/*     */   }
/*     */   
/*     */   public String getOrgValue() {
/* 120 */     return this._orgValue;
/*     */   }
/*     */   
/*     */   public void setOrgValue(String argOrgValue) {
/* 124 */     if (changed(argOrgValue, this._orgValue, "orgValue")) {
/* 125 */       this._orgValue = argOrgValue;
/*     */     }
/*     */   }
/*     */   
/*     */   public String getTranslation() {
/* 130 */     return this._translation;
/*     */   }
/*     */   
/*     */   public void setTranslation(String argTranslation) {
/* 134 */     if (changed(argTranslation, this._translation, "translation")) {
/* 135 */       this._translation = argTranslation;
/*     */     }
/*     */   }
/*     */   
/*     */   public String getExternalSystem() {
/* 140 */     return this._externalSystem;
/*     */   }
/*     */   
/*     */   public void setExternalSystem(String argExternalSystem) {
/* 144 */     if (changed(argExternalSystem, this._externalSystem, "externalSystem")) {
/* 145 */       this._externalSystem = argExternalSystem;
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public String toString() {
/* 152 */     StringBuilder buf = new StringBuilder(512);
/* 153 */     buf.append(super.toString()).append(" Id: ").append(getObjectId()).append(" Values: ");
/* 154 */     if (getOrganizationId() != null) {
/* 155 */       buf.append("organizationId").append("=").append(getOrganizationId()).append(" ");
/*     */     }
/* 157 */     if (getLocale() != null) {
/* 158 */       buf.append("locale").append("=").append(getLocale()).append(" ");
/*     */     }
/* 160 */     if (getTranslationKey() != null) {
/* 161 */       buf.append("translationKey").append("=").append(getTranslationKey()).append(" ");
/*     */     }
/* 163 */     if (getCreateDate() != null) {
/* 164 */       buf.append("createDate").append("=").append(getCreateDate()).append(" ");
/*     */     }
/* 166 */     if (getCreateUserId() != null) {
/* 167 */       buf.append("createUserId").append("=").append(getCreateUserId()).append(" ");
/*     */     }
/* 169 */     if (getUpdateDate() != null) {
/* 170 */       buf.append("updateDate").append("=").append(getUpdateDate()).append(" ");
/*     */     }
/* 172 */     if (getUpdateUserId() != null) {
/* 173 */       buf.append("updateUserId").append("=").append(getUpdateUserId()).append(" ");
/*     */     }
/* 175 */     if (getOrgCode() != null) {
/* 176 */       buf.append("orgCode").append("=").append(getOrgCode()).append(" ");
/*     */     }
/* 178 */     if (getOrgValue() != null) {
/* 179 */       buf.append("orgValue").append("=").append(getOrgValue()).append(" ");
/*     */     }
/* 181 */     if (getTranslation() != null) {
/* 182 */       buf.append("translation").append("=").append(getTranslation()).append(" ");
/*     */     }
/* 184 */     if (getExternalSystem() != null) {
/* 185 */       buf.append("externalSystem").append("=").append(getExternalSystem()).append(" ");
/*     */     }
/*     */     
/* 188 */     return buf.toString();
/*     */   }
/*     */   
/*     */   public IObjectId getObjectId() {
/* 192 */     DatabaseTranslationId id = new DatabaseTranslationId();
/* 193 */     id.setOrganizationId(getOrganizationId());
/* 194 */     id.setLocale(getLocale());
/* 195 */     id.setTranslationKey(getTranslationKey());
/* 196 */     return (IObjectId)id;
/*     */   }
/*     */   
/*     */   public void setObjectId(IObjectId argObjectId) {
/* 200 */     setOrganizationId(((DatabaseTranslationId)argObjectId).getOrganizationId());
/* 201 */     setLocale(((DatabaseTranslationId)argObjectId).getLocale());
/* 202 */     setTranslationKey(((DatabaseTranslationId)argObjectId).getTranslationKey());
/*     */   }
/*     */   
/*     */   public String getImplementingClass() {
/* 206 */     return null;
/*     */   }
/*     */   
/*     */   public String toXmlString() {
/* 210 */     StringBuilder buf = new StringBuilder(550);
/* 211 */     buf.append("<").append("dao").append(" name=\"DatabaseTranslation\" cmd=\"" + getObjectStateString() + "\">");
/* 212 */     getFieldsAsXml(buf);
/* 213 */     buf.append("</").append("dao").append(">");
/*     */     
/* 215 */     return buf.toString();
/*     */   }
/*     */   
/*     */   public Map<String, String> getValues() {
/* 219 */     Map<String, String> values = super.getValues();
/* 220 */     if (this._organizationId != null) values.put("OrganizationId", DaoUtils.getXmlSafeFieldValue(-5, this._organizationId)); 
/* 221 */     if (this._locale != null) values.put("Locale", DaoUtils.getXmlSafeFieldValue(12, this._locale)); 
/* 222 */     if (this._translationKey != null) values.put("TranslationKey", DaoUtils.getXmlSafeFieldValue(12, this._translationKey)); 
/* 223 */     if (this._createDate != null) values.put("CreateDate", DaoUtils.getXmlSafeFieldValue(91, this._createDate)); 
/* 224 */     if (this._createUserId != null) values.put("CreateUserId", DaoUtils.getXmlSafeFieldValue(12, this._createUserId)); 
/* 225 */     if (this._updateDate != null) values.put("UpdateDate", DaoUtils.getXmlSafeFieldValue(91, this._updateDate)); 
/* 226 */     if (this._updateUserId != null) values.put("UpdateUserId", DaoUtils.getXmlSafeFieldValue(12, this._updateUserId)); 
/* 227 */     if (this._orgCode != null) values.put("OrgCode", DaoUtils.getXmlSafeFieldValue(12, this._orgCode)); 
/* 228 */     if (this._orgValue != null) values.put("OrgValue", DaoUtils.getXmlSafeFieldValue(12, this._orgValue)); 
/* 229 */     if (this._translation != null) values.put("Translation", DaoUtils.getXmlSafeFieldValue(12, this._translation)); 
/* 230 */     if (this._externalSystem != null) values.put("ExternalSystem", DaoUtils.getXmlSafeFieldValue(12, this._externalSystem)); 
/* 231 */     return values;
/*     */   }
/*     */ 
/*     */   
/*     */   public void setValues(Map<String, String> argValues) {
/* 236 */     super.setValues(argValues);
/* 237 */     for (Map.Entry<String, String> field : argValues.entrySet()) {
/*     */       
/* 239 */       String fieldName = field.getKey();
/* 240 */       String fieldValue = field.getValue();
/* 241 */       switch (fieldName) {
/*     */         
/*     */         case "OrganizationId":
/*     */           try {
/* 245 */             Object value = DaoUtils.getFieldValueForXmlString(-5, fieldValue);
/* 246 */             setOrganizationId((Long)value);
/* 247 */           } catch (Exception ee) {
/* 248 */             throw new DtxException("An exception occurred while calling setOrganizationId() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "Locale":
/*     */           try {
/* 254 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 255 */             setLocale((String)value);
/* 256 */           } catch (Exception ee) {
/* 257 */             throw new DtxException("An exception occurred while calling setLocale() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "TranslationKey":
/*     */           try {
/* 263 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 264 */             setTranslationKey((String)value);
/* 265 */           } catch (Exception ee) {
/* 266 */             throw new DtxException("An exception occurred while calling setTranslationKey() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "CreateDate":
/*     */           try {
/* 272 */             Object value = DaoUtils.getFieldValueForXmlString(91, fieldValue);
/* 273 */             setCreateDate((Date)value);
/* 274 */           } catch (Exception ee) {
/* 275 */             throw new DtxException("An exception occurred while calling setCreateDate() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "CreateUserId":
/*     */           try {
/* 281 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 282 */             setCreateUserId((String)value);
/* 283 */           } catch (Exception ee) {
/* 284 */             throw new DtxException("An exception occurred while calling setCreateUserId() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "UpdateDate":
/*     */           try {
/* 290 */             Object value = DaoUtils.getFieldValueForXmlString(91, fieldValue);
/* 291 */             setUpdateDate((Date)value);
/* 292 */           } catch (Exception ee) {
/* 293 */             throw new DtxException("An exception occurred while calling setUpdateDate() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "UpdateUserId":
/*     */           try {
/* 299 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 300 */             setUpdateUserId((String)value);
/* 301 */           } catch (Exception ee) {
/* 302 */             throw new DtxException("An exception occurred while calling setUpdateUserId() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "OrgCode":
/*     */           try {
/* 308 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 309 */             setOrgCode((String)value);
/* 310 */           } catch (Exception ee) {
/* 311 */             throw new DtxException("An exception occurred while calling setOrgCode() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "OrgValue":
/*     */           try {
/* 317 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 318 */             setOrgValue((String)value);
/* 319 */           } catch (Exception ee) {
/* 320 */             throw new DtxException("An exception occurred while calling setOrgValue() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "Translation":
/*     */           try {
/* 326 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 327 */             setTranslation((String)value);
/* 328 */           } catch (Exception ee) {
/* 329 */             throw new DtxException("An exception occurred while calling setTranslation() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "ExternalSystem":
/*     */           try {
/* 335 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 336 */             setExternalSystem((String)value);
/* 337 */           } catch (Exception ee) {
/* 338 */             throw new DtxException("An exception occurred while calling setExternalSystem() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */       } 
/*     */     } 
/*     */   }
/*     */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\com\impl\DatabaseTranslationDAO.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */