/*     */ package dtv.xst.dao.loc.impl;
/*     */ 
/*     */ import dtv.data2.access.DaoUtils;
/*     */ import dtv.data2.access.IObjectId;
/*     */ import dtv.data2.access.exception.DtxException;
/*     */ import dtv.data2.access.impl.AbstractDAOImpl;
/*     */ import dtv.util.DtvDate;
/*     */ import dtv.xst.dao.loc.OrgHierarchyId;
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
/*     */ public class OrgHierarchyDAO
/*     */   extends AbstractDAOImpl
/*     */ {
/*     */   private static final long serialVersionUID = -323299375L;
/*  23 */   private static final Logger _logger = Logger.getLogger(OrgHierarchyDAO.class);
/*     */   
/*     */   private Long _organizationId;
/*     */   private String _levelCode;
/*     */   private String _levelValue;
/*     */   private DtvDate _createDate;
/*     */   private String _createUserId;
/*     */   private DtvDate _updateDate;
/*     */   private String _updateUserId;
/*     */   private String _parentCode;
/*     */   private String _parentValue;
/*     */   private String _description;
/*     */   private String _levelManager;
/*     */   private Integer _levelOrder;
/*     */   private Integer _sortOrder;
/*  38 */   private Boolean _inactive = Boolean.FALSE;
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
/*     */   public String getLevelCode() {
/*  51 */     return this._levelCode;
/*     */   }
/*     */   
/*     */   public void setLevelCode(String argLevelCode) {
/*  55 */     if (changed(argLevelCode, this._levelCode, "levelCode")) {
/*  56 */       this._levelCode = (argLevelCode != null && MANAGE_CASE) ? argLevelCode.toUpperCase() : argLevelCode;
/*     */     }
/*     */   }
/*     */   
/*     */   public String getLevelValue() {
/*  61 */     return this._levelValue;
/*     */   }
/*     */   
/*     */   public void setLevelValue(String argLevelValue) {
/*  65 */     if (changed(argLevelValue, this._levelValue, "levelValue")) {
/*  66 */       this._levelValue = (argLevelValue != null && MANAGE_CASE) ? argLevelValue.toUpperCase() : argLevelValue;
/*     */     }
/*     */   }
/*     */   
/*     */   public Date getCreateDate() {
/*  71 */     return (Date)this._createDate;
/*     */   }
/*     */   
/*     */   public void setCreateDate(Date argCreateDate) {
/*  75 */     if (changed(argCreateDate, this._createDate, "createDate")) {
/*  76 */       this._createDate = (argCreateDate == null || argCreateDate instanceof DtvDate) ? (DtvDate)argCreateDate : new DtvDate(argCreateDate);
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public String getCreateUserId() {
/*  82 */     return this._createUserId;
/*     */   }
/*     */   
/*     */   public void setCreateUserId(String argCreateUserId) {
/*  86 */     if (changed(argCreateUserId, this._createUserId, "createUserId")) {
/*  87 */       this._createUserId = argCreateUserId;
/*     */     }
/*     */   }
/*     */   
/*     */   public Date getUpdateDate() {
/*  92 */     return (Date)this._updateDate;
/*     */   }
/*     */   
/*     */   public void setUpdateDate(Date argUpdateDate) {
/*  96 */     if (changed(argUpdateDate, this._updateDate, "updateDate")) {
/*  97 */       this._updateDate = (argUpdateDate == null || argUpdateDate instanceof DtvDate) ? (DtvDate)argUpdateDate : new DtvDate(argUpdateDate);
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public String getUpdateUserId() {
/* 103 */     return this._updateUserId;
/*     */   }
/*     */   
/*     */   public void setUpdateUserId(String argUpdateUserId) {
/* 107 */     if (changed(argUpdateUserId, this._updateUserId, "updateUserId")) {
/* 108 */       this._updateUserId = argUpdateUserId;
/*     */     }
/*     */   }
/*     */   
/*     */   public String getParentCode() {
/* 113 */     return this._parentCode;
/*     */   }
/*     */   
/*     */   public void setParentCode(String argParentCode) {
/* 117 */     if (changed(argParentCode, this._parentCode, "parentCode")) {
/* 118 */       this._parentCode = argParentCode;
/*     */     }
/*     */   }
/*     */   
/*     */   public String getParentValue() {
/* 123 */     return this._parentValue;
/*     */   }
/*     */   
/*     */   public void setParentValue(String argParentValue) {
/* 127 */     if (changed(argParentValue, this._parentValue, "parentValue")) {
/* 128 */       this._parentValue = argParentValue;
/*     */     }
/*     */   }
/*     */   
/*     */   public String getDescription() {
/* 133 */     return this._description;
/*     */   }
/*     */   
/*     */   public void setDescription(String argDescription) {
/* 137 */     if (changed(argDescription, this._description, "description")) {
/* 138 */       this._description = argDescription;
/*     */     }
/*     */   }
/*     */   
/*     */   public String getLevelManager() {
/* 143 */     return this._levelManager;
/*     */   }
/*     */   
/*     */   public void setLevelManager(String argLevelManager) {
/* 147 */     if (changed(argLevelManager, this._levelManager, "levelManager")) {
/* 148 */       this._levelManager = argLevelManager;
/*     */     }
/*     */   }
/*     */   
/*     */   public Integer getLevelOrder() {
/* 153 */     return this._levelOrder;
/*     */   }
/*     */   
/*     */   public void setLevelOrder(Integer argLevelOrder) {
/* 157 */     if (changed(argLevelOrder, this._levelOrder, "levelOrder")) {
/* 158 */       this._levelOrder = argLevelOrder;
/*     */     }
/*     */   }
/*     */   
/*     */   public Integer getSortOrder() {
/* 163 */     return this._sortOrder;
/*     */   }
/*     */   
/*     */   public void setSortOrder(Integer argSortOrder) {
/* 167 */     if (changed(argSortOrder, this._sortOrder, "sortOrder")) {
/* 168 */       this._sortOrder = argSortOrder;
/*     */     }
/*     */   }
/*     */   
/*     */   public Boolean getInactive() {
/* 173 */     return this._inactive;
/*     */   }
/*     */   
/*     */   public void setInactive(Boolean argInactive) {
/* 177 */     if (changed(argInactive, this._inactive, "inactive")) {
/* 178 */       this._inactive = argInactive;
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public String toString() {
/* 185 */     StringBuilder buf = new StringBuilder(512);
/* 186 */     buf.append(super.toString()).append(" Id: ").append(getObjectId()).append(" Values: ");
/* 187 */     if (getOrganizationId() != null) {
/* 188 */       buf.append("organizationId").append("=").append(getOrganizationId()).append(" ");
/*     */     }
/* 190 */     if (getLevelCode() != null) {
/* 191 */       buf.append("levelCode").append("=").append(getLevelCode()).append(" ");
/*     */     }
/* 193 */     if (getLevelValue() != null) {
/* 194 */       buf.append("levelValue").append("=").append(getLevelValue()).append(" ");
/*     */     }
/* 196 */     if (getCreateDate() != null) {
/* 197 */       buf.append("createDate").append("=").append(getCreateDate()).append(" ");
/*     */     }
/* 199 */     if (getCreateUserId() != null) {
/* 200 */       buf.append("createUserId").append("=").append(getCreateUserId()).append(" ");
/*     */     }
/* 202 */     if (getUpdateDate() != null) {
/* 203 */       buf.append("updateDate").append("=").append(getUpdateDate()).append(" ");
/*     */     }
/* 205 */     if (getUpdateUserId() != null) {
/* 206 */       buf.append("updateUserId").append("=").append(getUpdateUserId()).append(" ");
/*     */     }
/* 208 */     if (getParentCode() != null) {
/* 209 */       buf.append("parentCode").append("=").append(getParentCode()).append(" ");
/*     */     }
/* 211 */     if (getParentValue() != null) {
/* 212 */       buf.append("parentValue").append("=").append(getParentValue()).append(" ");
/*     */     }
/* 214 */     if (getDescription() != null) {
/* 215 */       buf.append("description").append("=").append(getDescription()).append(" ");
/*     */     }
/* 217 */     if (getLevelManager() != null) {
/* 218 */       buf.append("levelManager").append("=").append(getLevelManager()).append(" ");
/*     */     }
/* 220 */     if (getLevelOrder() != null) {
/* 221 */       buf.append("levelOrder").append("=").append(getLevelOrder()).append(" ");
/*     */     }
/* 223 */     if (getSortOrder() != null) {
/* 224 */       buf.append("sortOrder").append("=").append(getSortOrder()).append(" ");
/*     */     }
/* 226 */     if (getInactive() != null && getInactive().booleanValue()) {
/* 227 */       buf.append("inactive").append("=").append(getInactive()).append(" ");
/*     */     }
/*     */     
/* 230 */     return buf.toString();
/*     */   }
/*     */   
/*     */   public IObjectId getObjectId() {
/* 234 */     OrgHierarchyId id = new OrgHierarchyId();
/* 235 */     id.setOrganizationId(getOrganizationId());
/* 236 */     id.setLevelCode(getLevelCode());
/* 237 */     id.setLevelValue(getLevelValue());
/* 238 */     return (IObjectId)id;
/*     */   }
/*     */   
/*     */   public void setObjectId(IObjectId argObjectId) {
/* 242 */     setOrganizationId(((OrgHierarchyId)argObjectId).getOrganizationId());
/* 243 */     setLevelCode(((OrgHierarchyId)argObjectId).getLevelCode());
/* 244 */     setLevelValue(((OrgHierarchyId)argObjectId).getLevelValue());
/*     */   }
/*     */   
/*     */   public String getImplementingClass() {
/* 248 */     return null;
/*     */   }
/*     */   
/*     */   public String toXmlString() {
/* 252 */     StringBuilder buf = new StringBuilder(700);
/* 253 */     buf.append("<").append("dao").append(" name=\"OrgHierarchy\" cmd=\"" + getObjectStateString() + "\">");
/* 254 */     getFieldsAsXml(buf);
/* 255 */     buf.append("</").append("dao").append(">");
/*     */     
/* 257 */     return buf.toString();
/*     */   }
/*     */   
/*     */   public Map<String, String> getValues() {
/* 261 */     Map<String, String> values = super.getValues();
/* 262 */     if (this._organizationId != null) values.put("OrganizationId", DaoUtils.getXmlSafeFieldValue(-5, this._organizationId)); 
/* 263 */     if (this._levelCode != null) values.put("LevelCode", DaoUtils.getXmlSafeFieldValue(12, this._levelCode)); 
/* 264 */     if (this._levelValue != null) values.put("LevelValue", DaoUtils.getXmlSafeFieldValue(12, this._levelValue)); 
/* 265 */     if (this._createDate != null) values.put("CreateDate", DaoUtils.getXmlSafeFieldValue(91, this._createDate)); 
/* 266 */     if (this._createUserId != null) values.put("CreateUserId", DaoUtils.getXmlSafeFieldValue(12, this._createUserId)); 
/* 267 */     if (this._updateDate != null) values.put("UpdateDate", DaoUtils.getXmlSafeFieldValue(91, this._updateDate)); 
/* 268 */     if (this._updateUserId != null) values.put("UpdateUserId", DaoUtils.getXmlSafeFieldValue(12, this._updateUserId)); 
/* 269 */     if (this._parentCode != null) values.put("ParentCode", DaoUtils.getXmlSafeFieldValue(12, this._parentCode)); 
/* 270 */     if (this._parentValue != null) values.put("ParentValue", DaoUtils.getXmlSafeFieldValue(12, this._parentValue)); 
/* 271 */     if (this._description != null) values.put("Description", DaoUtils.getXmlSafeFieldValue(12, this._description)); 
/* 272 */     if (this._levelManager != null) values.put("LevelManager", DaoUtils.getXmlSafeFieldValue(12, this._levelManager)); 
/* 273 */     if (this._levelOrder != null) values.put("LevelOrder", DaoUtils.getXmlSafeFieldValue(4, this._levelOrder)); 
/* 274 */     if (this._sortOrder != null) values.put("SortOrder", DaoUtils.getXmlSafeFieldValue(4, this._sortOrder)); 
/* 275 */     if (this._inactive != null) values.put("Inactive", DaoUtils.getXmlSafeFieldValue(-7, this._inactive)); 
/* 276 */     return values;
/*     */   }
/*     */ 
/*     */   
/*     */   public void setValues(Map<String, String> argValues) {
/* 281 */     super.setValues(argValues);
/* 282 */     for (Map.Entry<String, String> field : argValues.entrySet()) {
/*     */       
/* 284 */       String fieldName = field.getKey();
/* 285 */       String fieldValue = field.getValue();
/* 286 */       switch (fieldName) {
/*     */         
/*     */         case "OrganizationId":
/*     */           try {
/* 290 */             Object value = DaoUtils.getFieldValueForXmlString(-5, fieldValue);
/* 291 */             setOrganizationId((Long)value);
/* 292 */           } catch (Exception ee) {
/* 293 */             throw new DtxException("An exception occurred while calling setOrganizationId() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "LevelCode":
/*     */           try {
/* 299 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 300 */             setLevelCode((String)value);
/* 301 */           } catch (Exception ee) {
/* 302 */             throw new DtxException("An exception occurred while calling setLevelCode() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "LevelValue":
/*     */           try {
/* 308 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 309 */             setLevelValue((String)value);
/* 310 */           } catch (Exception ee) {
/* 311 */             throw new DtxException("An exception occurred while calling setLevelValue() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "CreateDate":
/*     */           try {
/* 317 */             Object value = DaoUtils.getFieldValueForXmlString(91, fieldValue);
/* 318 */             setCreateDate((Date)value);
/* 319 */           } catch (Exception ee) {
/* 320 */             throw new DtxException("An exception occurred while calling setCreateDate() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "CreateUserId":
/*     */           try {
/* 326 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 327 */             setCreateUserId((String)value);
/* 328 */           } catch (Exception ee) {
/* 329 */             throw new DtxException("An exception occurred while calling setCreateUserId() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "UpdateDate":
/*     */           try {
/* 335 */             Object value = DaoUtils.getFieldValueForXmlString(91, fieldValue);
/* 336 */             setUpdateDate((Date)value);
/* 337 */           } catch (Exception ee) {
/* 338 */             throw new DtxException("An exception occurred while calling setUpdateDate() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "UpdateUserId":
/*     */           try {
/* 344 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 345 */             setUpdateUserId((String)value);
/* 346 */           } catch (Exception ee) {
/* 347 */             throw new DtxException("An exception occurred while calling setUpdateUserId() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "ParentCode":
/*     */           try {
/* 353 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 354 */             setParentCode((String)value);
/* 355 */           } catch (Exception ee) {
/* 356 */             throw new DtxException("An exception occurred while calling setParentCode() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "ParentValue":
/*     */           try {
/* 362 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 363 */             setParentValue((String)value);
/* 364 */           } catch (Exception ee) {
/* 365 */             throw new DtxException("An exception occurred while calling setParentValue() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "Description":
/*     */           try {
/* 371 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 372 */             setDescription((String)value);
/* 373 */           } catch (Exception ee) {
/* 374 */             throw new DtxException("An exception occurred while calling setDescription() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "LevelManager":
/*     */           try {
/* 380 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 381 */             setLevelManager((String)value);
/* 382 */           } catch (Exception ee) {
/* 383 */             throw new DtxException("An exception occurred while calling setLevelManager() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "LevelOrder":
/*     */           try {
/* 389 */             Object value = DaoUtils.getFieldValueForXmlString(4, fieldValue);
/* 390 */             setLevelOrder((Integer)value);
/* 391 */           } catch (Exception ee) {
/* 392 */             throw new DtxException("An exception occurred while calling setLevelOrder() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "SortOrder":
/*     */           try {
/* 398 */             Object value = DaoUtils.getFieldValueForXmlString(4, fieldValue);
/* 399 */             setSortOrder((Integer)value);
/* 400 */           } catch (Exception ee) {
/* 401 */             throw new DtxException("An exception occurred while calling setSortOrder() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "Inactive":
/*     */           try {
/* 407 */             Object value = DaoUtils.getFieldValueForXmlString(-7, fieldValue);
/* 408 */             setInactive((Boolean)value);
/* 409 */           } catch (Exception ee) {
/* 410 */             throw new DtxException("An exception occurred while calling setInactive() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */       } 
/*     */     } 
/*     */   }
/*     */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\loc\impl\OrgHierarchyDAO.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */