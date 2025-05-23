/*     */ package dtv.xst.dao.itm.impl;
/*     */ 
/*     */ import dtv.data2.access.DaoUtils;
/*     */ import dtv.data2.access.IObjectId;
/*     */ import dtv.data2.access.exception.DtxException;
/*     */ import dtv.data2.access.impl.AbstractDAOImpl;
/*     */ import dtv.util.DtvDate;
/*     */ import dtv.xst.dao.itm.MerchandiseHierarchyId;
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
/*     */ public class MerchandiseHierarchyDAO
/*     */   extends AbstractDAOImpl
/*     */ {
/*     */   private static final long serialVersionUID = -746218030L;
/*  23 */   private static final Logger _logger = Logger.getLogger(MerchandiseHierarchyDAO.class);
/*     */   
/*     */   private String _hierarchyId;
/*     */   private Long _organizationId;
/*     */   private String _orgCode;
/*     */   private String _orgValue;
/*     */   private DtvDate _createDate;
/*     */   private String _createUserId;
/*     */   private DtvDate _updateDate;
/*     */   private String _updateUserId;
/*     */   private String _parentId;
/*     */   private String _description;
/*     */   private String _levelCode;
/*     */   private Integer _sortOrder;
/*  37 */   private Boolean _hidden = Boolean.FALSE;
/*  38 */   private Boolean _disallowItemMatrixDisplay = Boolean.FALSE;
/*     */   private String _itemMatrixColor;
/*     */   
/*     */   public String getHierarchyId() {
/*  42 */     return this._hierarchyId;
/*     */   }
/*     */   
/*     */   public void setHierarchyId(String argHierarchyId) {
/*  46 */     if (changed(argHierarchyId, this._hierarchyId, "hierarchyId")) {
/*  47 */       this._hierarchyId = (argHierarchyId != null && MANAGE_CASE) ? argHierarchyId.toUpperCase() : argHierarchyId;
/*     */     }
/*     */   }
/*     */   
/*     */   public Long getOrganizationId() {
/*  52 */     return this._organizationId;
/*     */   }
/*     */   
/*     */   public void setOrganizationId(Long argOrganizationId) {
/*  56 */     if (changed(argOrganizationId, this._organizationId, "organizationId")) {
/*  57 */       this._organizationId = argOrganizationId;
/*     */     }
/*     */   }
/*     */   
/*     */   public String getOrgCode() {
/*  62 */     return this._orgCode;
/*     */   }
/*     */   
/*     */   public void setOrgCode(String argOrgCode) {
/*  66 */     if (changed(argOrgCode, this._orgCode, "orgCode")) {
/*  67 */       this._orgCode = argOrgCode;
/*     */     }
/*     */   }
/*     */   
/*     */   public String getOrgValue() {
/*  72 */     return this._orgValue;
/*     */   }
/*     */   
/*     */   public void setOrgValue(String argOrgValue) {
/*  76 */     if (changed(argOrgValue, this._orgValue, "orgValue")) {
/*  77 */       this._orgValue = argOrgValue;
/*     */     }
/*     */   }
/*     */   
/*     */   public Date getCreateDate() {
/*  82 */     return (Date)this._createDate;
/*     */   }
/*     */   
/*     */   public void setCreateDate(Date argCreateDate) {
/*  86 */     if (changed(argCreateDate, this._createDate, "createDate")) {
/*  87 */       this._createDate = (argCreateDate == null || argCreateDate instanceof DtvDate) ? (DtvDate)argCreateDate : new DtvDate(argCreateDate);
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public String getCreateUserId() {
/*  93 */     return this._createUserId;
/*     */   }
/*     */   
/*     */   public void setCreateUserId(String argCreateUserId) {
/*  97 */     if (changed(argCreateUserId, this._createUserId, "createUserId")) {
/*  98 */       this._createUserId = argCreateUserId;
/*     */     }
/*     */   }
/*     */   
/*     */   public Date getUpdateDate() {
/* 103 */     return (Date)this._updateDate;
/*     */   }
/*     */   
/*     */   public void setUpdateDate(Date argUpdateDate) {
/* 107 */     if (changed(argUpdateDate, this._updateDate, "updateDate")) {
/* 108 */       this._updateDate = (argUpdateDate == null || argUpdateDate instanceof DtvDate) ? (DtvDate)argUpdateDate : new DtvDate(argUpdateDate);
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public String getUpdateUserId() {
/* 114 */     return this._updateUserId;
/*     */   }
/*     */   
/*     */   public void setUpdateUserId(String argUpdateUserId) {
/* 118 */     if (changed(argUpdateUserId, this._updateUserId, "updateUserId")) {
/* 119 */       this._updateUserId = argUpdateUserId;
/*     */     }
/*     */   }
/*     */   
/*     */   public String getParentId() {
/* 124 */     return this._parentId;
/*     */   }
/*     */   
/*     */   public void setParentId(String argParentId) {
/* 128 */     if (changed(argParentId, this._parentId, "parentId")) {
/* 129 */       this._parentId = argParentId;
/*     */     }
/*     */   }
/*     */   
/*     */   public String getDescription() {
/* 134 */     return this._description;
/*     */   }
/*     */   
/*     */   public void setDescription(String argDescription) {
/* 138 */     if (changed(argDescription, this._description, "description")) {
/* 139 */       this._description = argDescription;
/*     */     }
/*     */   }
/*     */   
/*     */   public String getLevelCode() {
/* 144 */     return this._levelCode;
/*     */   }
/*     */   
/*     */   public void setLevelCode(String argLevelCode) {
/* 148 */     if (changed(argLevelCode, this._levelCode, "levelCode")) {
/* 149 */       this._levelCode = argLevelCode;
/*     */     }
/*     */   }
/*     */   
/*     */   public Integer getSortOrder() {
/* 154 */     return this._sortOrder;
/*     */   }
/*     */   
/*     */   public void setSortOrder(Integer argSortOrder) {
/* 158 */     if (changed(argSortOrder, this._sortOrder, "sortOrder")) {
/* 159 */       this._sortOrder = argSortOrder;
/*     */     }
/*     */   }
/*     */   
/*     */   public Boolean getHidden() {
/* 164 */     return this._hidden;
/*     */   }
/*     */   
/*     */   public void setHidden(Boolean argHidden) {
/* 168 */     if (changed(argHidden, this._hidden, "hidden")) {
/* 169 */       this._hidden = argHidden;
/*     */     }
/*     */   }
/*     */   
/*     */   public Boolean getDisallowItemMatrixDisplay() {
/* 174 */     return this._disallowItemMatrixDisplay;
/*     */   }
/*     */   
/*     */   public void setDisallowItemMatrixDisplay(Boolean argDisallowItemMatrixDisplay) {
/* 178 */     if (changed(argDisallowItemMatrixDisplay, this._disallowItemMatrixDisplay, "disallowItemMatrixDisplay")) {
/* 179 */       this._disallowItemMatrixDisplay = argDisallowItemMatrixDisplay;
/*     */     }
/*     */   }
/*     */   
/*     */   public String getItemMatrixColor() {
/* 184 */     return this._itemMatrixColor;
/*     */   }
/*     */   
/*     */   public void setItemMatrixColor(String argItemMatrixColor) {
/* 188 */     if (changed(argItemMatrixColor, this._itemMatrixColor, "itemMatrixColor")) {
/* 189 */       this._itemMatrixColor = argItemMatrixColor;
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public String toString() {
/* 196 */     StringBuilder buf = new StringBuilder(512);
/* 197 */     buf.append(super.toString()).append(" Id: ").append(getObjectId()).append(" Values: ");
/* 198 */     if (getHierarchyId() != null) {
/* 199 */       buf.append("hierarchyId").append("=").append(getHierarchyId()).append(" ");
/*     */     }
/* 201 */     if (getOrganizationId() != null) {
/* 202 */       buf.append("organizationId").append("=").append(getOrganizationId()).append(" ");
/*     */     }
/* 204 */     if (getOrgCode() != null) {
/* 205 */       buf.append("orgCode").append("=").append(getOrgCode()).append(" ");
/*     */     }
/* 207 */     if (getOrgValue() != null) {
/* 208 */       buf.append("orgValue").append("=").append(getOrgValue()).append(" ");
/*     */     }
/* 210 */     if (getCreateDate() != null) {
/* 211 */       buf.append("createDate").append("=").append(getCreateDate()).append(" ");
/*     */     }
/* 213 */     if (getCreateUserId() != null) {
/* 214 */       buf.append("createUserId").append("=").append(getCreateUserId()).append(" ");
/*     */     }
/* 216 */     if (getUpdateDate() != null) {
/* 217 */       buf.append("updateDate").append("=").append(getUpdateDate()).append(" ");
/*     */     }
/* 219 */     if (getUpdateUserId() != null) {
/* 220 */       buf.append("updateUserId").append("=").append(getUpdateUserId()).append(" ");
/*     */     }
/* 222 */     if (getParentId() != null) {
/* 223 */       buf.append("parentId").append("=").append(getParentId()).append(" ");
/*     */     }
/* 225 */     if (getDescription() != null) {
/* 226 */       buf.append("description").append("=").append(getDescription()).append(" ");
/*     */     }
/* 228 */     if (getLevelCode() != null) {
/* 229 */       buf.append("levelCode").append("=").append(getLevelCode()).append(" ");
/*     */     }
/* 231 */     if (getSortOrder() != null) {
/* 232 */       buf.append("sortOrder").append("=").append(getSortOrder()).append(" ");
/*     */     }
/* 234 */     if (getHidden() != null && getHidden().booleanValue()) {
/* 235 */       buf.append("hidden").append("=").append(getHidden()).append(" ");
/*     */     }
/* 237 */     if (getDisallowItemMatrixDisplay() != null && getDisallowItemMatrixDisplay().booleanValue()) {
/* 238 */       buf.append("disallowItemMatrixDisplay").append("=").append(getDisallowItemMatrixDisplay()).append(" ");
/*     */     }
/* 240 */     if (getItemMatrixColor() != null) {
/* 241 */       buf.append("itemMatrixColor").append("=").append(getItemMatrixColor()).append(" ");
/*     */     }
/*     */     
/* 244 */     return buf.toString();
/*     */   }
/*     */   
/*     */   public IObjectId getObjectId() {
/* 248 */     MerchandiseHierarchyId id = new MerchandiseHierarchyId();
/* 249 */     id.setHierarchyId(getHierarchyId());
/* 250 */     id.setOrganizationId(getOrganizationId());
/* 251 */     return (IObjectId)id;
/*     */   }
/*     */   
/*     */   public void setObjectId(IObjectId argObjectId) {
/* 255 */     setHierarchyId(((MerchandiseHierarchyId)argObjectId).getHierarchyId());
/* 256 */     setOrganizationId(((MerchandiseHierarchyId)argObjectId).getOrganizationId());
/*     */   }
/*     */   
/*     */   public String getImplementingClass() {
/* 260 */     return null;
/*     */   }
/*     */   
/*     */   public String toXmlString() {
/* 264 */     StringBuilder buf = new StringBuilder(750);
/* 265 */     buf.append("<").append("dao").append(" name=\"MerchandiseHierarchy\" cmd=\"" + getObjectStateString() + "\">");
/* 266 */     getFieldsAsXml(buf);
/* 267 */     buf.append("</").append("dao").append(">");
/*     */     
/* 269 */     return buf.toString();
/*     */   }
/*     */   
/*     */   public Map<String, String> getValues() {
/* 273 */     Map<String, String> values = super.getValues();
/* 274 */     if (this._hierarchyId != null) values.put("HierarchyId", DaoUtils.getXmlSafeFieldValue(12, this._hierarchyId)); 
/* 275 */     if (this._organizationId != null) values.put("OrganizationId", DaoUtils.getXmlSafeFieldValue(-5, this._organizationId)); 
/* 276 */     if (this._orgCode != null) values.put("OrgCode", DaoUtils.getXmlSafeFieldValue(12, this._orgCode)); 
/* 277 */     if (this._orgValue != null) values.put("OrgValue", DaoUtils.getXmlSafeFieldValue(12, this._orgValue)); 
/* 278 */     if (this._createDate != null) values.put("CreateDate", DaoUtils.getXmlSafeFieldValue(91, this._createDate)); 
/* 279 */     if (this._createUserId != null) values.put("CreateUserId", DaoUtils.getXmlSafeFieldValue(12, this._createUserId)); 
/* 280 */     if (this._updateDate != null) values.put("UpdateDate", DaoUtils.getXmlSafeFieldValue(91, this._updateDate)); 
/* 281 */     if (this._updateUserId != null) values.put("UpdateUserId", DaoUtils.getXmlSafeFieldValue(12, this._updateUserId)); 
/* 282 */     if (this._parentId != null) values.put("ParentId", DaoUtils.getXmlSafeFieldValue(12, this._parentId)); 
/* 283 */     if (this._description != null) values.put("Description", DaoUtils.getXmlSafeFieldValue(12, this._description)); 
/* 284 */     if (this._levelCode != null) values.put("LevelCode", DaoUtils.getXmlSafeFieldValue(12, this._levelCode)); 
/* 285 */     if (this._sortOrder != null) values.put("SortOrder", DaoUtils.getXmlSafeFieldValue(4, this._sortOrder)); 
/* 286 */     if (this._hidden != null) values.put("Hidden", DaoUtils.getXmlSafeFieldValue(-7, this._hidden)); 
/* 287 */     if (this._disallowItemMatrixDisplay != null) values.put("DisallowItemMatrixDisplay", DaoUtils.getXmlSafeFieldValue(-7, this._disallowItemMatrixDisplay)); 
/* 288 */     if (this._itemMatrixColor != null) values.put("ItemMatrixColor", DaoUtils.getXmlSafeFieldValue(12, this._itemMatrixColor)); 
/* 289 */     return values;
/*     */   }
/*     */ 
/*     */   
/*     */   public void setValues(Map<String, String> argValues) {
/* 294 */     super.setValues(argValues);
/* 295 */     for (Map.Entry<String, String> field : argValues.entrySet()) {
/*     */       
/* 297 */       String fieldName = field.getKey();
/* 298 */       String fieldValue = field.getValue();
/* 299 */       switch (fieldName) {
/*     */         
/*     */         case "HierarchyId":
/*     */           try {
/* 303 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 304 */             setHierarchyId((String)value);
/* 305 */           } catch (Exception ee) {
/* 306 */             throw new DtxException("An exception occurred while calling setHierarchyId() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "OrganizationId":
/*     */           try {
/* 312 */             Object value = DaoUtils.getFieldValueForXmlString(-5, fieldValue);
/* 313 */             setOrganizationId((Long)value);
/* 314 */           } catch (Exception ee) {
/* 315 */             throw new DtxException("An exception occurred while calling setOrganizationId() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "OrgCode":
/*     */           try {
/* 321 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 322 */             setOrgCode((String)value);
/* 323 */           } catch (Exception ee) {
/* 324 */             throw new DtxException("An exception occurred while calling setOrgCode() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "OrgValue":
/*     */           try {
/* 330 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 331 */             setOrgValue((String)value);
/* 332 */           } catch (Exception ee) {
/* 333 */             throw new DtxException("An exception occurred while calling setOrgValue() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "CreateDate":
/*     */           try {
/* 339 */             Object value = DaoUtils.getFieldValueForXmlString(91, fieldValue);
/* 340 */             setCreateDate((Date)value);
/* 341 */           } catch (Exception ee) {
/* 342 */             throw new DtxException("An exception occurred while calling setCreateDate() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "CreateUserId":
/*     */           try {
/* 348 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 349 */             setCreateUserId((String)value);
/* 350 */           } catch (Exception ee) {
/* 351 */             throw new DtxException("An exception occurred while calling setCreateUserId() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "UpdateDate":
/*     */           try {
/* 357 */             Object value = DaoUtils.getFieldValueForXmlString(91, fieldValue);
/* 358 */             setUpdateDate((Date)value);
/* 359 */           } catch (Exception ee) {
/* 360 */             throw new DtxException("An exception occurred while calling setUpdateDate() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "UpdateUserId":
/*     */           try {
/* 366 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 367 */             setUpdateUserId((String)value);
/* 368 */           } catch (Exception ee) {
/* 369 */             throw new DtxException("An exception occurred while calling setUpdateUserId() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "ParentId":
/*     */           try {
/* 375 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 376 */             setParentId((String)value);
/* 377 */           } catch (Exception ee) {
/* 378 */             throw new DtxException("An exception occurred while calling setParentId() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "Description":
/*     */           try {
/* 384 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 385 */             setDescription((String)value);
/* 386 */           } catch (Exception ee) {
/* 387 */             throw new DtxException("An exception occurred while calling setDescription() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "LevelCode":
/*     */           try {
/* 393 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 394 */             setLevelCode((String)value);
/* 395 */           } catch (Exception ee) {
/* 396 */             throw new DtxException("An exception occurred while calling setLevelCode() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "SortOrder":
/*     */           try {
/* 402 */             Object value = DaoUtils.getFieldValueForXmlString(4, fieldValue);
/* 403 */             setSortOrder((Integer)value);
/* 404 */           } catch (Exception ee) {
/* 405 */             throw new DtxException("An exception occurred while calling setSortOrder() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "Hidden":
/*     */           try {
/* 411 */             Object value = DaoUtils.getFieldValueForXmlString(-7, fieldValue);
/* 412 */             setHidden((Boolean)value);
/* 413 */           } catch (Exception ee) {
/* 414 */             throw new DtxException("An exception occurred while calling setHidden() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "DisallowItemMatrixDisplay":
/*     */           try {
/* 420 */             Object value = DaoUtils.getFieldValueForXmlString(-7, fieldValue);
/* 421 */             setDisallowItemMatrixDisplay((Boolean)value);
/* 422 */           } catch (Exception ee) {
/* 423 */             throw new DtxException("An exception occurred while calling setDisallowItemMatrixDisplay() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "ItemMatrixColor":
/*     */           try {
/* 429 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 430 */             setItemMatrixColor((String)value);
/* 431 */           } catch (Exception ee) {
/* 432 */             throw new DtxException("An exception occurred while calling setItemMatrixColor() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */       } 
/*     */     } 
/*     */   }
/*     */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\itm\impl\MerchandiseHierarchyDAO.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */