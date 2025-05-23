/*     */ package dtv.xst.dao.loc.impl;
/*     */ 
/*     */ import dtv.data2.access.DaoUtils;
/*     */ import dtv.data2.access.IObjectId;
/*     */ import dtv.data2.access.exception.DtxException;
/*     */ import dtv.data2.access.impl.AbstractDAOImpl;
/*     */ import dtv.util.DtvDate;
/*     */ import dtv.xst.dao.loc.CycleQuestionId;
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
/*     */ public class CycleQuestionDAO
/*     */   extends AbstractDAOImpl
/*     */ {
/*     */   private static final long serialVersionUID = -267705652L;
/*  23 */   private static final Logger _logger = Logger.getLogger(CycleQuestionDAO.class);
/*     */   
/*     */   private Long _organizationId;
/*     */   private String _questionId;
/*     */   private DtvDate _createDate;
/*     */   private String _createUserId;
/*     */   private DtvDate _updateDate;
/*     */   private String _updateUserId;
/*     */   private DtvDate _effectiveDate;
/*     */   private DtvDate _expirationDate;
/*     */   private String _questionTextKey;
/*     */   private String _questionTypeCode;
/*     */   private Integer _sortOrder;
/*     */   private Long _retailLocationId;
/*  37 */   private Boolean _corporateMessage = Boolean.FALSE;
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
/*     */   public String getQuestionId() {
/*  50 */     return this._questionId;
/*     */   }
/*     */   
/*     */   public void setQuestionId(String argQuestionId) {
/*  54 */     if (changed(argQuestionId, this._questionId, "questionId")) {
/*  55 */       this._questionId = (argQuestionId != null && MANAGE_CASE) ? argQuestionId.toUpperCase() : argQuestionId;
/*     */     }
/*     */   }
/*     */   
/*     */   public Date getCreateDate() {
/*  60 */     return (Date)this._createDate;
/*     */   }
/*     */   
/*     */   public void setCreateDate(Date argCreateDate) {
/*  64 */     if (changed(argCreateDate, this._createDate, "createDate")) {
/*  65 */       this._createDate = (argCreateDate == null || argCreateDate instanceof DtvDate) ? (DtvDate)argCreateDate : new DtvDate(argCreateDate);
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public String getCreateUserId() {
/*  71 */     return this._createUserId;
/*     */   }
/*     */   
/*     */   public void setCreateUserId(String argCreateUserId) {
/*  75 */     if (changed(argCreateUserId, this._createUserId, "createUserId")) {
/*  76 */       this._createUserId = argCreateUserId;
/*     */     }
/*     */   }
/*     */   
/*     */   public Date getUpdateDate() {
/*  81 */     return (Date)this._updateDate;
/*     */   }
/*     */   
/*     */   public void setUpdateDate(Date argUpdateDate) {
/*  85 */     if (changed(argUpdateDate, this._updateDate, "updateDate")) {
/*  86 */       this._updateDate = (argUpdateDate == null || argUpdateDate instanceof DtvDate) ? (DtvDate)argUpdateDate : new DtvDate(argUpdateDate);
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public String getUpdateUserId() {
/*  92 */     return this._updateUserId;
/*     */   }
/*     */   
/*     */   public void setUpdateUserId(String argUpdateUserId) {
/*  96 */     if (changed(argUpdateUserId, this._updateUserId, "updateUserId")) {
/*  97 */       this._updateUserId = argUpdateUserId;
/*     */     }
/*     */   }
/*     */   
/*     */   public Date getEffectiveDate() {
/* 102 */     return (Date)this._effectiveDate;
/*     */   }
/*     */   
/*     */   public void setEffectiveDate(Date argEffectiveDate) {
/* 106 */     if (changed(argEffectiveDate, this._effectiveDate, "effectiveDate")) {
/* 107 */       this._effectiveDate = (argEffectiveDate == null || argEffectiveDate instanceof DtvDate) ? (DtvDate)argEffectiveDate : new DtvDate(argEffectiveDate);
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public Date getExpirationDate() {
/* 113 */     return (Date)this._expirationDate;
/*     */   }
/*     */   
/*     */   public void setExpirationDate(Date argExpirationDate) {
/* 117 */     if (changed(argExpirationDate, this._expirationDate, "expirationDate")) {
/* 118 */       this._expirationDate = (argExpirationDate == null || argExpirationDate instanceof DtvDate) ? (DtvDate)argExpirationDate : new DtvDate(argExpirationDate);
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public String getQuestionTextKey() {
/* 124 */     return this._questionTextKey;
/*     */   }
/*     */   
/*     */   public void setQuestionTextKey(String argQuestionTextKey) {
/* 128 */     if (changed(argQuestionTextKey, this._questionTextKey, "questionTextKey")) {
/* 129 */       this._questionTextKey = argQuestionTextKey;
/*     */     }
/*     */   }
/*     */   
/*     */   public String getQuestionTypeCode() {
/* 134 */     return this._questionTypeCode;
/*     */   }
/*     */   
/*     */   public void setQuestionTypeCode(String argQuestionTypeCode) {
/* 138 */     if (changed(argQuestionTypeCode, this._questionTypeCode, "questionTypeCode")) {
/* 139 */       this._questionTypeCode = argQuestionTypeCode;
/*     */     }
/*     */   }
/*     */   
/*     */   public Integer getSortOrder() {
/* 144 */     return this._sortOrder;
/*     */   }
/*     */   
/*     */   public void setSortOrder(Integer argSortOrder) {
/* 148 */     if (changed(argSortOrder, this._sortOrder, "sortOrder")) {
/* 149 */       this._sortOrder = argSortOrder;
/*     */     }
/*     */   }
/*     */   
/*     */   public Long getRetailLocationId() {
/* 154 */     return this._retailLocationId;
/*     */   }
/*     */   
/*     */   public void setRetailLocationId(Long argRetailLocationId) {
/* 158 */     if (changed(argRetailLocationId, this._retailLocationId, "retailLocationId")) {
/* 159 */       this._retailLocationId = argRetailLocationId;
/*     */     }
/*     */   }
/*     */   
/*     */   public Boolean getCorporateMessage() {
/* 164 */     return this._corporateMessage;
/*     */   }
/*     */   
/*     */   public void setCorporateMessage(Boolean argCorporateMessage) {
/* 168 */     if (changed(argCorporateMessage, this._corporateMessage, "corporateMessage")) {
/* 169 */       this._corporateMessage = argCorporateMessage;
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
/* 181 */     if (getQuestionId() != null) {
/* 182 */       buf.append("questionId").append("=").append(getQuestionId()).append(" ");
/*     */     }
/* 184 */     if (getCreateDate() != null) {
/* 185 */       buf.append("createDate").append("=").append(getCreateDate()).append(" ");
/*     */     }
/* 187 */     if (getCreateUserId() != null) {
/* 188 */       buf.append("createUserId").append("=").append(getCreateUserId()).append(" ");
/*     */     }
/* 190 */     if (getUpdateDate() != null) {
/* 191 */       buf.append("updateDate").append("=").append(getUpdateDate()).append(" ");
/*     */     }
/* 193 */     if (getUpdateUserId() != null) {
/* 194 */       buf.append("updateUserId").append("=").append(getUpdateUserId()).append(" ");
/*     */     }
/* 196 */     if (getEffectiveDate() != null) {
/* 197 */       buf.append("effectiveDate").append("=").append(getEffectiveDate()).append(" ");
/*     */     }
/* 199 */     if (getExpirationDate() != null) {
/* 200 */       buf.append("expirationDate").append("=").append(getExpirationDate()).append(" ");
/*     */     }
/* 202 */     if (getQuestionTextKey() != null) {
/* 203 */       buf.append("questionTextKey").append("=").append(getQuestionTextKey()).append(" ");
/*     */     }
/* 205 */     if (getQuestionTypeCode() != null) {
/* 206 */       buf.append("questionTypeCode").append("=").append(getQuestionTypeCode()).append(" ");
/*     */     }
/* 208 */     if (getSortOrder() != null) {
/* 209 */       buf.append("sortOrder").append("=").append(getSortOrder()).append(" ");
/*     */     }
/* 211 */     if (getRetailLocationId() != null) {
/* 212 */       buf.append("retailLocationId").append("=").append(getRetailLocationId()).append(" ");
/*     */     }
/* 214 */     if (getCorporateMessage() != null && getCorporateMessage().booleanValue()) {
/* 215 */       buf.append("corporateMessage").append("=").append(getCorporateMessage()).append(" ");
/*     */     }
/*     */     
/* 218 */     return buf.toString();
/*     */   }
/*     */   
/*     */   public IObjectId getObjectId() {
/* 222 */     CycleQuestionId id = new CycleQuestionId();
/* 223 */     id.setOrganizationId(getOrganizationId());
/* 224 */     id.setQuestionId(getQuestionId());
/* 225 */     return (IObjectId)id;
/*     */   }
/*     */   
/*     */   public void setObjectId(IObjectId argObjectId) {
/* 229 */     setOrganizationId(((CycleQuestionId)argObjectId).getOrganizationId());
/* 230 */     setQuestionId(((CycleQuestionId)argObjectId).getQuestionId());
/*     */   }
/*     */   
/*     */   public String getImplementingClass() {
/* 234 */     return null;
/*     */   }
/*     */   
/*     */   public String toXmlString() {
/* 238 */     StringBuilder buf = new StringBuilder(650);
/* 239 */     buf.append("<").append("dao").append(" name=\"CycleQuestion\" cmd=\"" + getObjectStateString() + "\">");
/* 240 */     getFieldsAsXml(buf);
/* 241 */     buf.append("</").append("dao").append(">");
/*     */     
/* 243 */     return buf.toString();
/*     */   }
/*     */   
/*     */   public Map<String, String> getValues() {
/* 247 */     Map<String, String> values = super.getValues();
/* 248 */     if (this._organizationId != null) values.put("OrganizationId", DaoUtils.getXmlSafeFieldValue(-5, this._organizationId)); 
/* 249 */     if (this._questionId != null) values.put("QuestionId", DaoUtils.getXmlSafeFieldValue(12, this._questionId)); 
/* 250 */     if (this._createDate != null) values.put("CreateDate", DaoUtils.getXmlSafeFieldValue(91, this._createDate)); 
/* 251 */     if (this._createUserId != null) values.put("CreateUserId", DaoUtils.getXmlSafeFieldValue(12, this._createUserId)); 
/* 252 */     if (this._updateDate != null) values.put("UpdateDate", DaoUtils.getXmlSafeFieldValue(91, this._updateDate)); 
/* 253 */     if (this._updateUserId != null) values.put("UpdateUserId", DaoUtils.getXmlSafeFieldValue(12, this._updateUserId)); 
/* 254 */     if (this._effectiveDate != null) values.put("EffectiveDate", DaoUtils.getXmlSafeFieldValue(91, this._effectiveDate)); 
/* 255 */     if (this._expirationDate != null) values.put("ExpirationDate", DaoUtils.getXmlSafeFieldValue(91, this._expirationDate)); 
/* 256 */     if (this._questionTextKey != null) values.put("QuestionTextKey", DaoUtils.getXmlSafeFieldValue(12, this._questionTextKey)); 
/* 257 */     if (this._questionTypeCode != null) values.put("QuestionTypeCode", DaoUtils.getXmlSafeFieldValue(12, this._questionTypeCode)); 
/* 258 */     if (this._sortOrder != null) values.put("SortOrder", DaoUtils.getXmlSafeFieldValue(4, this._sortOrder)); 
/* 259 */     if (this._retailLocationId != null) values.put("RetailLocationId", DaoUtils.getXmlSafeFieldValue(-5, this._retailLocationId)); 
/* 260 */     if (this._corporateMessage != null) values.put("CorporateMessage", DaoUtils.getXmlSafeFieldValue(-7, this._corporateMessage)); 
/* 261 */     return values;
/*     */   }
/*     */ 
/*     */   
/*     */   public void setValues(Map<String, String> argValues) {
/* 266 */     super.setValues(argValues);
/* 267 */     for (Map.Entry<String, String> field : argValues.entrySet()) {
/*     */       
/* 269 */       String fieldName = field.getKey();
/* 270 */       String fieldValue = field.getValue();
/* 271 */       switch (fieldName) {
/*     */         
/*     */         case "OrganizationId":
/*     */           try {
/* 275 */             Object value = DaoUtils.getFieldValueForXmlString(-5, fieldValue);
/* 276 */             setOrganizationId((Long)value);
/* 277 */           } catch (Exception ee) {
/* 278 */             throw new DtxException("An exception occurred while calling setOrganizationId() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "QuestionId":
/*     */           try {
/* 284 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 285 */             setQuestionId((String)value);
/* 286 */           } catch (Exception ee) {
/* 287 */             throw new DtxException("An exception occurred while calling setQuestionId() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "CreateDate":
/*     */           try {
/* 293 */             Object value = DaoUtils.getFieldValueForXmlString(91, fieldValue);
/* 294 */             setCreateDate((Date)value);
/* 295 */           } catch (Exception ee) {
/* 296 */             throw new DtxException("An exception occurred while calling setCreateDate() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "CreateUserId":
/*     */           try {
/* 302 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 303 */             setCreateUserId((String)value);
/* 304 */           } catch (Exception ee) {
/* 305 */             throw new DtxException("An exception occurred while calling setCreateUserId() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "UpdateDate":
/*     */           try {
/* 311 */             Object value = DaoUtils.getFieldValueForXmlString(91, fieldValue);
/* 312 */             setUpdateDate((Date)value);
/* 313 */           } catch (Exception ee) {
/* 314 */             throw new DtxException("An exception occurred while calling setUpdateDate() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "UpdateUserId":
/*     */           try {
/* 320 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 321 */             setUpdateUserId((String)value);
/* 322 */           } catch (Exception ee) {
/* 323 */             throw new DtxException("An exception occurred while calling setUpdateUserId() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "EffectiveDate":
/*     */           try {
/* 329 */             Object value = DaoUtils.getFieldValueForXmlString(91, fieldValue);
/* 330 */             setEffectiveDate((Date)value);
/* 331 */           } catch (Exception ee) {
/* 332 */             throw new DtxException("An exception occurred while calling setEffectiveDate() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "ExpirationDate":
/*     */           try {
/* 338 */             Object value = DaoUtils.getFieldValueForXmlString(91, fieldValue);
/* 339 */             setExpirationDate((Date)value);
/* 340 */           } catch (Exception ee) {
/* 341 */             throw new DtxException("An exception occurred while calling setExpirationDate() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "QuestionTextKey":
/*     */           try {
/* 347 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 348 */             setQuestionTextKey((String)value);
/* 349 */           } catch (Exception ee) {
/* 350 */             throw new DtxException("An exception occurred while calling setQuestionTextKey() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "QuestionTypeCode":
/*     */           try {
/* 356 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 357 */             setQuestionTypeCode((String)value);
/* 358 */           } catch (Exception ee) {
/* 359 */             throw new DtxException("An exception occurred while calling setQuestionTypeCode() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "SortOrder":
/*     */           try {
/* 365 */             Object value = DaoUtils.getFieldValueForXmlString(4, fieldValue);
/* 366 */             setSortOrder((Integer)value);
/* 367 */           } catch (Exception ee) {
/* 368 */             throw new DtxException("An exception occurred while calling setSortOrder() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "RetailLocationId":
/*     */           try {
/* 374 */             Object value = DaoUtils.getFieldValueForXmlString(-5, fieldValue);
/* 375 */             setRetailLocationId((Long)value);
/* 376 */           } catch (Exception ee) {
/* 377 */             throw new DtxException("An exception occurred while calling setRetailLocationId() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "CorporateMessage":
/*     */           try {
/* 383 */             Object value = DaoUtils.getFieldValueForXmlString(-7, fieldValue);
/* 384 */             setCorporateMessage((Boolean)value);
/* 385 */           } catch (Exception ee) {
/* 386 */             throw new DtxException("An exception occurred while calling setCorporateMessage() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */       } 
/*     */     } 
/*     */   }
/*     */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\loc\impl\CycleQuestionDAO.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */