/*     */ package dtv.xst.dao.hrs.impl;
/*     */ 
/*     */ import dtv.data2.access.DaoUtils;
/*     */ import dtv.data2.access.IObjectId;
/*     */ import dtv.data2.access.exception.DtxException;
/*     */ import dtv.data2.access.impl.AbstractDAOImpl;
/*     */ import dtv.util.DtvDate;
/*     */ import dtv.xst.dao.hrs.WorkCodesId;
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
/*     */ public class WorkCodesDAO
/*     */   extends AbstractDAOImpl
/*     */ {
/*     */   private static final long serialVersionUID = -1226491019L;
/*  23 */   private static final Logger _logger = Logger.getLogger(WorkCodesDAO.class);
/*     */   
/*     */   private Long _organizationId;
/*     */   private String _workCode;
/*     */   private String _orgCode;
/*     */   private String _orgValue;
/*     */   private DtvDate _createDate;
/*     */   private String _createUserId;
/*     */   private DtvDate _updateDate;
/*     */   private String _updateUserId;
/*     */   private String _description;
/*     */   private Integer _sortOrder;
/*  35 */   private Boolean _selling = Boolean.FALSE;
/*     */   private String _privilege;
/*     */   private String _payrollCategoryString;
/*     */   private Integer _minimumClockInDuration;
/*     */   private Integer _minimumClockOutDuration;
/*  40 */   private Boolean _hidden = Boolean.FALSE;
/*     */   
/*     */   public Long getOrganizationId() {
/*  43 */     return this._organizationId;
/*     */   }
/*     */   
/*     */   public void setOrganizationId(Long argOrganizationId) {
/*  47 */     if (changed(argOrganizationId, this._organizationId, "organizationId")) {
/*  48 */       this._organizationId = argOrganizationId;
/*     */     }
/*     */   }
/*     */   
/*     */   public String getWorkCode() {
/*  53 */     return this._workCode;
/*     */   }
/*     */   
/*     */   public void setWorkCode(String argWorkCode) {
/*  57 */     if (changed(argWorkCode, this._workCode, "workCode")) {
/*  58 */       this._workCode = (argWorkCode != null && MANAGE_CASE) ? argWorkCode.toUpperCase() : argWorkCode;
/*     */     }
/*     */   }
/*     */   
/*     */   public String getOrgCode() {
/*  63 */     return this._orgCode;
/*     */   }
/*     */   
/*     */   public void setOrgCode(String argOrgCode) {
/*  67 */     if (changed(argOrgCode, this._orgCode, "orgCode")) {
/*  68 */       this._orgCode = argOrgCode;
/*     */     }
/*     */   }
/*     */   
/*     */   public String getOrgValue() {
/*  73 */     return this._orgValue;
/*     */   }
/*     */   
/*     */   public void setOrgValue(String argOrgValue) {
/*  77 */     if (changed(argOrgValue, this._orgValue, "orgValue")) {
/*  78 */       this._orgValue = argOrgValue;
/*     */     }
/*     */   }
/*     */   
/*     */   public Date getCreateDate() {
/*  83 */     return (Date)this._createDate;
/*     */   }
/*     */   
/*     */   public void setCreateDate(Date argCreateDate) {
/*  87 */     if (changed(argCreateDate, this._createDate, "createDate")) {
/*  88 */       this._createDate = (argCreateDate == null || argCreateDate instanceof DtvDate) ? (DtvDate)argCreateDate : new DtvDate(argCreateDate);
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public String getCreateUserId() {
/*  94 */     return this._createUserId;
/*     */   }
/*     */   
/*     */   public void setCreateUserId(String argCreateUserId) {
/*  98 */     if (changed(argCreateUserId, this._createUserId, "createUserId")) {
/*  99 */       this._createUserId = argCreateUserId;
/*     */     }
/*     */   }
/*     */   
/*     */   public Date getUpdateDate() {
/* 104 */     return (Date)this._updateDate;
/*     */   }
/*     */   
/*     */   public void setUpdateDate(Date argUpdateDate) {
/* 108 */     if (changed(argUpdateDate, this._updateDate, "updateDate")) {
/* 109 */       this._updateDate = (argUpdateDate == null || argUpdateDate instanceof DtvDate) ? (DtvDate)argUpdateDate : new DtvDate(argUpdateDate);
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public String getUpdateUserId() {
/* 115 */     return this._updateUserId;
/*     */   }
/*     */   
/*     */   public void setUpdateUserId(String argUpdateUserId) {
/* 119 */     if (changed(argUpdateUserId, this._updateUserId, "updateUserId")) {
/* 120 */       this._updateUserId = argUpdateUserId;
/*     */     }
/*     */   }
/*     */   
/*     */   public String getDescription() {
/* 125 */     return this._description;
/*     */   }
/*     */   
/*     */   public void setDescription(String argDescription) {
/* 129 */     if (changed(argDescription, this._description, "description")) {
/* 130 */       this._description = argDescription;
/*     */     }
/*     */   }
/*     */   
/*     */   public Integer getSortOrder() {
/* 135 */     return this._sortOrder;
/*     */   }
/*     */   
/*     */   public void setSortOrder(Integer argSortOrder) {
/* 139 */     if (changed(argSortOrder, this._sortOrder, "sortOrder")) {
/* 140 */       this._sortOrder = argSortOrder;
/*     */     }
/*     */   }
/*     */   
/*     */   public Boolean getSelling() {
/* 145 */     return this._selling;
/*     */   }
/*     */   
/*     */   public void setSelling(Boolean argSelling) {
/* 149 */     if (changed(argSelling, this._selling, "selling")) {
/* 150 */       this._selling = argSelling;
/*     */     }
/*     */   }
/*     */   
/*     */   public String getPrivilege() {
/* 155 */     return this._privilege;
/*     */   }
/*     */   
/*     */   public void setPrivilege(String argPrivilege) {
/* 159 */     if (changed(argPrivilege, this._privilege, "privilege")) {
/* 160 */       this._privilege = argPrivilege;
/*     */     }
/*     */   }
/*     */   
/*     */   public String getPayrollCategoryString() {
/* 165 */     return this._payrollCategoryString;
/*     */   }
/*     */   
/*     */   public void setPayrollCategoryString(String argPayrollCategoryString) {
/* 169 */     if (changed(argPayrollCategoryString, this._payrollCategoryString, "payrollCategoryString")) {
/* 170 */       this._payrollCategoryString = argPayrollCategoryString;
/*     */     }
/*     */   }
/*     */   
/*     */   public Integer getMinimumClockInDuration() {
/* 175 */     return this._minimumClockInDuration;
/*     */   }
/*     */   
/*     */   public void setMinimumClockInDuration(Integer argMinimumClockInDuration) {
/* 179 */     if (changed(argMinimumClockInDuration, this._minimumClockInDuration, "minimumClockInDuration")) {
/* 180 */       this._minimumClockInDuration = argMinimumClockInDuration;
/*     */     }
/*     */   }
/*     */   
/*     */   public Integer getMinimumClockOutDuration() {
/* 185 */     return this._minimumClockOutDuration;
/*     */   }
/*     */   
/*     */   public void setMinimumClockOutDuration(Integer argMinimumClockOutDuration) {
/* 189 */     if (changed(argMinimumClockOutDuration, this._minimumClockOutDuration, "minimumClockOutDuration")) {
/* 190 */       this._minimumClockOutDuration = argMinimumClockOutDuration;
/*     */     }
/*     */   }
/*     */   
/*     */   public Boolean getHidden() {
/* 195 */     return this._hidden;
/*     */   }
/*     */   
/*     */   public void setHidden(Boolean argHidden) {
/* 199 */     if (changed(argHidden, this._hidden, "hidden")) {
/* 200 */       this._hidden = argHidden;
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public String toString() {
/* 207 */     StringBuilder buf = new StringBuilder(512);
/* 208 */     buf.append(super.toString()).append(" Id: ").append(getObjectId()).append(" Values: ");
/* 209 */     if (getOrganizationId() != null) {
/* 210 */       buf.append("organizationId").append("=").append(getOrganizationId()).append(" ");
/*     */     }
/* 212 */     if (getWorkCode() != null) {
/* 213 */       buf.append("workCode").append("=").append(getWorkCode()).append(" ");
/*     */     }
/* 215 */     if (getOrgCode() != null) {
/* 216 */       buf.append("orgCode").append("=").append(getOrgCode()).append(" ");
/*     */     }
/* 218 */     if (getOrgValue() != null) {
/* 219 */       buf.append("orgValue").append("=").append(getOrgValue()).append(" ");
/*     */     }
/* 221 */     if (getCreateDate() != null) {
/* 222 */       buf.append("createDate").append("=").append(getCreateDate()).append(" ");
/*     */     }
/* 224 */     if (getCreateUserId() != null) {
/* 225 */       buf.append("createUserId").append("=").append(getCreateUserId()).append(" ");
/*     */     }
/* 227 */     if (getUpdateDate() != null) {
/* 228 */       buf.append("updateDate").append("=").append(getUpdateDate()).append(" ");
/*     */     }
/* 230 */     if (getUpdateUserId() != null) {
/* 231 */       buf.append("updateUserId").append("=").append(getUpdateUserId()).append(" ");
/*     */     }
/* 233 */     if (getDescription() != null) {
/* 234 */       buf.append("description").append("=").append(getDescription()).append(" ");
/*     */     }
/* 236 */     if (getSortOrder() != null) {
/* 237 */       buf.append("sortOrder").append("=").append(getSortOrder()).append(" ");
/*     */     }
/* 239 */     if (getSelling() != null && getSelling().booleanValue()) {
/* 240 */       buf.append("selling").append("=").append(getSelling()).append(" ");
/*     */     }
/* 242 */     if (getPrivilege() != null) {
/* 243 */       buf.append("privilege").append("=").append(getPrivilege()).append(" ");
/*     */     }
/* 245 */     if (getPayrollCategoryString() != null) {
/* 246 */       buf.append("payrollCategoryString").append("=").append(getPayrollCategoryString()).append(" ");
/*     */     }
/* 248 */     if (getMinimumClockInDuration() != null) {
/* 249 */       buf.append("minimumClockInDuration").append("=").append(getMinimumClockInDuration()).append(" ");
/*     */     }
/* 251 */     if (getMinimumClockOutDuration() != null) {
/* 252 */       buf.append("minimumClockOutDuration").append("=").append(getMinimumClockOutDuration()).append(" ");
/*     */     }
/* 254 */     if (getHidden() != null && getHidden().booleanValue()) {
/* 255 */       buf.append("hidden").append("=").append(getHidden()).append(" ");
/*     */     }
/*     */     
/* 258 */     return buf.toString();
/*     */   }
/*     */   
/*     */   public IObjectId getObjectId() {
/* 262 */     WorkCodesId id = new WorkCodesId();
/* 263 */     id.setOrganizationId(getOrganizationId());
/* 264 */     id.setWorkCode(getWorkCode());
/* 265 */     return (IObjectId)id;
/*     */   }
/*     */   
/*     */   public void setObjectId(IObjectId argObjectId) {
/* 269 */     setOrganizationId(((WorkCodesId)argObjectId).getOrganizationId());
/* 270 */     setWorkCode(((WorkCodesId)argObjectId).getWorkCode());
/*     */   }
/*     */   
/*     */   public String getImplementingClass() {
/* 274 */     return null;
/*     */   }
/*     */   
/*     */   public String toXmlString() {
/* 278 */     StringBuilder buf = new StringBuilder(800);
/* 279 */     buf.append("<").append("dao").append(" name=\"WorkCodes\" cmd=\"" + getObjectStateString() + "\">");
/* 280 */     getFieldsAsXml(buf);
/* 281 */     buf.append("</").append("dao").append(">");
/*     */     
/* 283 */     return buf.toString();
/*     */   }
/*     */   
/*     */   public Map<String, String> getValues() {
/* 287 */     Map<String, String> values = super.getValues();
/* 288 */     if (this._organizationId != null) values.put("OrganizationId", DaoUtils.getXmlSafeFieldValue(-5, this._organizationId)); 
/* 289 */     if (this._workCode != null) values.put("WorkCode", DaoUtils.getXmlSafeFieldValue(12, this._workCode)); 
/* 290 */     if (this._orgCode != null) values.put("OrgCode", DaoUtils.getXmlSafeFieldValue(12, this._orgCode)); 
/* 291 */     if (this._orgValue != null) values.put("OrgValue", DaoUtils.getXmlSafeFieldValue(12, this._orgValue)); 
/* 292 */     if (this._createDate != null) values.put("CreateDate", DaoUtils.getXmlSafeFieldValue(91, this._createDate)); 
/* 293 */     if (this._createUserId != null) values.put("CreateUserId", DaoUtils.getXmlSafeFieldValue(12, this._createUserId)); 
/* 294 */     if (this._updateDate != null) values.put("UpdateDate", DaoUtils.getXmlSafeFieldValue(91, this._updateDate)); 
/* 295 */     if (this._updateUserId != null) values.put("UpdateUserId", DaoUtils.getXmlSafeFieldValue(12, this._updateUserId)); 
/* 296 */     if (this._description != null) values.put("Description", DaoUtils.getXmlSafeFieldValue(12, this._description)); 
/* 297 */     if (this._sortOrder != null) values.put("SortOrder", DaoUtils.getXmlSafeFieldValue(4, this._sortOrder)); 
/* 298 */     if (this._selling != null) values.put("Selling", DaoUtils.getXmlSafeFieldValue(-7, this._selling)); 
/* 299 */     if (this._privilege != null) values.put("Privilege", DaoUtils.getXmlSafeFieldValue(12, this._privilege)); 
/* 300 */     if (this._payrollCategoryString != null) values.put("PayrollCategoryString", DaoUtils.getXmlSafeFieldValue(12, this._payrollCategoryString)); 
/* 301 */     if (this._minimumClockInDuration != null) values.put("MinimumClockInDuration", DaoUtils.getXmlSafeFieldValue(4, this._minimumClockInDuration)); 
/* 302 */     if (this._minimumClockOutDuration != null) values.put("MinimumClockOutDuration", DaoUtils.getXmlSafeFieldValue(4, this._minimumClockOutDuration)); 
/* 303 */     if (this._hidden != null) values.put("Hidden", DaoUtils.getXmlSafeFieldValue(-7, this._hidden)); 
/* 304 */     return values;
/*     */   }
/*     */ 
/*     */   
/*     */   public void setValues(Map<String, String> argValues) {
/* 309 */     super.setValues(argValues);
/* 310 */     for (Map.Entry<String, String> field : argValues.entrySet()) {
/*     */       
/* 312 */       String fieldName = field.getKey();
/* 313 */       String fieldValue = field.getValue();
/* 314 */       switch (fieldName) {
/*     */         
/*     */         case "OrganizationId":
/*     */           try {
/* 318 */             Object value = DaoUtils.getFieldValueForXmlString(-5, fieldValue);
/* 319 */             setOrganizationId((Long)value);
/* 320 */           } catch (Exception ee) {
/* 321 */             throw new DtxException("An exception occurred while calling setOrganizationId() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "WorkCode":
/*     */           try {
/* 327 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 328 */             setWorkCode((String)value);
/* 329 */           } catch (Exception ee) {
/* 330 */             throw new DtxException("An exception occurred while calling setWorkCode() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "OrgCode":
/*     */           try {
/* 336 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 337 */             setOrgCode((String)value);
/* 338 */           } catch (Exception ee) {
/* 339 */             throw new DtxException("An exception occurred while calling setOrgCode() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "OrgValue":
/*     */           try {
/* 345 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 346 */             setOrgValue((String)value);
/* 347 */           } catch (Exception ee) {
/* 348 */             throw new DtxException("An exception occurred while calling setOrgValue() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "CreateDate":
/*     */           try {
/* 354 */             Object value = DaoUtils.getFieldValueForXmlString(91, fieldValue);
/* 355 */             setCreateDate((Date)value);
/* 356 */           } catch (Exception ee) {
/* 357 */             throw new DtxException("An exception occurred while calling setCreateDate() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "CreateUserId":
/*     */           try {
/* 363 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 364 */             setCreateUserId((String)value);
/* 365 */           } catch (Exception ee) {
/* 366 */             throw new DtxException("An exception occurred while calling setCreateUserId() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "UpdateDate":
/*     */           try {
/* 372 */             Object value = DaoUtils.getFieldValueForXmlString(91, fieldValue);
/* 373 */             setUpdateDate((Date)value);
/* 374 */           } catch (Exception ee) {
/* 375 */             throw new DtxException("An exception occurred while calling setUpdateDate() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "UpdateUserId":
/*     */           try {
/* 381 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 382 */             setUpdateUserId((String)value);
/* 383 */           } catch (Exception ee) {
/* 384 */             throw new DtxException("An exception occurred while calling setUpdateUserId() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "Description":
/*     */           try {
/* 390 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 391 */             setDescription((String)value);
/* 392 */           } catch (Exception ee) {
/* 393 */             throw new DtxException("An exception occurred while calling setDescription() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "SortOrder":
/*     */           try {
/* 399 */             Object value = DaoUtils.getFieldValueForXmlString(4, fieldValue);
/* 400 */             setSortOrder((Integer)value);
/* 401 */           } catch (Exception ee) {
/* 402 */             throw new DtxException("An exception occurred while calling setSortOrder() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "Selling":
/*     */           try {
/* 408 */             Object value = DaoUtils.getFieldValueForXmlString(-7, fieldValue);
/* 409 */             setSelling((Boolean)value);
/* 410 */           } catch (Exception ee) {
/* 411 */             throw new DtxException("An exception occurred while calling setSelling() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "Privilege":
/*     */           try {
/* 417 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 418 */             setPrivilege((String)value);
/* 419 */           } catch (Exception ee) {
/* 420 */             throw new DtxException("An exception occurred while calling setPrivilege() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "PayrollCategoryString":
/*     */           try {
/* 426 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 427 */             setPayrollCategoryString((String)value);
/* 428 */           } catch (Exception ee) {
/* 429 */             throw new DtxException("An exception occurred while calling setPayrollCategoryString() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "MinimumClockInDuration":
/*     */           try {
/* 435 */             Object value = DaoUtils.getFieldValueForXmlString(4, fieldValue);
/* 436 */             setMinimumClockInDuration((Integer)value);
/* 437 */           } catch (Exception ee) {
/* 438 */             throw new DtxException("An exception occurred while calling setMinimumClockInDuration() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "MinimumClockOutDuration":
/*     */           try {
/* 444 */             Object value = DaoUtils.getFieldValueForXmlString(4, fieldValue);
/* 445 */             setMinimumClockOutDuration((Integer)value);
/* 446 */           } catch (Exception ee) {
/* 447 */             throw new DtxException("An exception occurred while calling setMinimumClockOutDuration() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "Hidden":
/*     */           try {
/* 453 */             Object value = DaoUtils.getFieldValueForXmlString(-7, fieldValue);
/* 454 */             setHidden((Boolean)value);
/* 455 */           } catch (Exception ee) {
/* 456 */             throw new DtxException("An exception occurred while calling setHidden() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */       } 
/*     */     } 
/*     */   }
/*     */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\hrs\impl\WorkCodesDAO.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */