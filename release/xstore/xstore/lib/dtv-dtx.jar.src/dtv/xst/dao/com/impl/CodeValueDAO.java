/*     */ package dtv.xst.dao.com.impl;
/*     */ 
/*     */ import dtv.data2.access.DaoUtils;
/*     */ import dtv.data2.access.IHasConfigElement;
/*     */ import dtv.data2.access.IObjectId;
/*     */ import dtv.data2.access.exception.DtxException;
/*     */ import dtv.data2.access.impl.AbstractDAOImpl;
/*     */ import dtv.util.DtvDate;
/*     */ import dtv.xst.dao.com.CodeValueId;
/*     */ import java.util.Date;
/*     */ import java.util.Map;
/*     */ import org.apache.log4j.Logger;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class CodeValueDAO
/*     */   extends AbstractDAOImpl
/*     */   implements IHasConfigElement
/*     */ {
/*     */   private static final long serialVersionUID = 868073316L;
/*  23 */   private static final Logger _logger = Logger.getLogger(CodeValueDAO.class);
/*     */   
/*     */   private Long _organizationId;
/*     */   private String _category;
/*     */   private String _code;
/*     */   private DtvDate _createDate;
/*     */   private String _createUserId;
/*     */   private DtvDate _updateDate;
/*     */   private String _updateUserId;
/*     */   private String _configElement;
/*     */   private String _description;
/*     */   private Integer _sortOrder;
/*  35 */   private Boolean _hidden = Boolean.FALSE;
/*     */   private Integer _rank;
/*     */   private String _imageUrl;
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
/*     */   public String getCategory() {
/*  50 */     return this._category;
/*     */   }
/*     */   
/*     */   public void setCategory(String argCategory) {
/*  54 */     if (changed(argCategory, this._category, "category")) {
/*  55 */       this._category = (argCategory != null && MANAGE_CASE) ? argCategory.toUpperCase() : argCategory;
/*     */     }
/*     */   }
/*     */   
/*     */   public String getCode() {
/*  60 */     return this._code;
/*     */   }
/*     */   
/*     */   public void setCode(String argCode) {
/*  64 */     if (changed(argCode, this._code, "code")) {
/*  65 */       this._code = (argCode != null && MANAGE_CASE) ? argCode.toUpperCase() : argCode;
/*     */     }
/*     */   }
/*     */   
/*     */   public Date getCreateDate() {
/*  70 */     return (Date)this._createDate;
/*     */   }
/*     */   
/*     */   public void setCreateDate(Date argCreateDate) {
/*  74 */     if (changed(argCreateDate, this._createDate, "createDate")) {
/*  75 */       this._createDate = (argCreateDate == null || argCreateDate instanceof DtvDate) ? (DtvDate)argCreateDate : new DtvDate(argCreateDate);
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public String getCreateUserId() {
/*  81 */     return this._createUserId;
/*     */   }
/*     */   
/*     */   public void setCreateUserId(String argCreateUserId) {
/*  85 */     if (changed(argCreateUserId, this._createUserId, "createUserId")) {
/*  86 */       this._createUserId = argCreateUserId;
/*     */     }
/*     */   }
/*     */   
/*     */   public Date getUpdateDate() {
/*  91 */     return (Date)this._updateDate;
/*     */   }
/*     */   
/*     */   public void setUpdateDate(Date argUpdateDate) {
/*  95 */     if (changed(argUpdateDate, this._updateDate, "updateDate")) {
/*  96 */       this._updateDate = (argUpdateDate == null || argUpdateDate instanceof DtvDate) ? (DtvDate)argUpdateDate : new DtvDate(argUpdateDate);
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public String getUpdateUserId() {
/* 102 */     return this._updateUserId;
/*     */   }
/*     */   
/*     */   public void setUpdateUserId(String argUpdateUserId) {
/* 106 */     if (changed(argUpdateUserId, this._updateUserId, "updateUserId")) {
/* 107 */       this._updateUserId = argUpdateUserId;
/*     */     }
/*     */   }
/*     */   
/*     */   public String getConfigElement() {
/* 112 */     return this._configElement;
/*     */   }
/*     */   
/*     */   public void setConfigElement(String argConfigElement) {
/* 116 */     if (changed(argConfigElement, this._configElement, "configElement")) {
/* 117 */       this._configElement = argConfigElement;
/*     */     }
/*     */   }
/*     */   
/*     */   public String getDescription() {
/* 122 */     return this._description;
/*     */   }
/*     */   
/*     */   public void setDescription(String argDescription) {
/* 126 */     if (changed(argDescription, this._description, "description")) {
/* 127 */       this._description = argDescription;
/*     */     }
/*     */   }
/*     */   
/*     */   public Integer getSortOrder() {
/* 132 */     return this._sortOrder;
/*     */   }
/*     */   
/*     */   public void setSortOrder(Integer argSortOrder) {
/* 136 */     if (changed(argSortOrder, this._sortOrder, "sortOrder")) {
/* 137 */       this._sortOrder = argSortOrder;
/*     */     }
/*     */   }
/*     */   
/*     */   public Boolean getHidden() {
/* 142 */     return this._hidden;
/*     */   }
/*     */   
/*     */   public void setHidden(Boolean argHidden) {
/* 146 */     if (changed(argHidden, this._hidden, "hidden")) {
/* 147 */       this._hidden = argHidden;
/*     */     }
/*     */   }
/*     */   
/*     */   public Integer getRank() {
/* 152 */     return this._rank;
/*     */   }
/*     */   
/*     */   public void setRank(Integer argRank) {
/* 156 */     if (changed(argRank, this._rank, "rank")) {
/* 157 */       this._rank = argRank;
/*     */     }
/*     */   }
/*     */   
/*     */   public String getImageUrl() {
/* 162 */     return this._imageUrl;
/*     */   }
/*     */   
/*     */   public void setImageUrl(String argImageUrl) {
/* 166 */     if (changed(argImageUrl, this._imageUrl, "imageUrl")) {
/* 167 */       this._imageUrl = argImageUrl;
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public String toString() {
/* 174 */     StringBuilder buf = new StringBuilder(512);
/* 175 */     buf.append(super.toString()).append(" Id: ").append(getObjectId()).append(" Values: ");
/* 176 */     if (getOrganizationId() != null) {
/* 177 */       buf.append("organizationId").append("=").append(getOrganizationId()).append(" ");
/*     */     }
/* 179 */     if (getCategory() != null) {
/* 180 */       buf.append("category").append("=").append(getCategory()).append(" ");
/*     */     }
/* 182 */     if (getCode() != null) {
/* 183 */       buf.append("code").append("=").append(getCode()).append(" ");
/*     */     }
/* 185 */     if (getCreateDate() != null) {
/* 186 */       buf.append("createDate").append("=").append(getCreateDate()).append(" ");
/*     */     }
/* 188 */     if (getCreateUserId() != null) {
/* 189 */       buf.append("createUserId").append("=").append(getCreateUserId()).append(" ");
/*     */     }
/* 191 */     if (getUpdateDate() != null) {
/* 192 */       buf.append("updateDate").append("=").append(getUpdateDate()).append(" ");
/*     */     }
/* 194 */     if (getUpdateUserId() != null) {
/* 195 */       buf.append("updateUserId").append("=").append(getUpdateUserId()).append(" ");
/*     */     }
/* 197 */     if (getConfigElement() != null) {
/* 198 */       buf.append("configElement").append("=").append(getConfigElement()).append(" ");
/*     */     }
/* 200 */     if (getDescription() != null) {
/* 201 */       buf.append("description").append("=").append(getDescription()).append(" ");
/*     */     }
/* 203 */     if (getSortOrder() != null) {
/* 204 */       buf.append("sortOrder").append("=").append(getSortOrder()).append(" ");
/*     */     }
/* 206 */     if (getHidden() != null && getHidden().booleanValue()) {
/* 207 */       buf.append("hidden").append("=").append(getHidden()).append(" ");
/*     */     }
/* 209 */     if (getRank() != null) {
/* 210 */       buf.append("rank").append("=").append(getRank()).append(" ");
/*     */     }
/* 212 */     if (getImageUrl() != null) {
/* 213 */       buf.append("imageUrl").append("=").append(getImageUrl()).append(" ");
/*     */     }
/*     */     
/* 216 */     return buf.toString();
/*     */   }
/*     */   
/*     */   public IObjectId getObjectId() {
/* 220 */     CodeValueId id = new CodeValueId();
/* 221 */     id.setOrganizationId(getOrganizationId());
/* 222 */     id.setCategory(getCategory());
/* 223 */     id.setCode(getCode());
/* 224 */     return (IObjectId)id;
/*     */   }
/*     */   
/*     */   public void setObjectId(IObjectId argObjectId) {
/* 228 */     setOrganizationId(((CodeValueId)argObjectId).getOrganizationId());
/* 229 */     setCategory(((CodeValueId)argObjectId).getCategory());
/* 230 */     setCode(((CodeValueId)argObjectId).getCode());
/*     */   }
/*     */   
/*     */   public String getImplementingClass() {
/* 234 */     return null;
/*     */   }
/*     */   
/*     */   public String toXmlString() {
/* 238 */     StringBuilder buf = new StringBuilder(650);
/* 239 */     buf.append("<").append("dao").append(" name=\"CodeValue\" cmd=\"" + getObjectStateString() + "\">");
/* 240 */     getFieldsAsXml(buf);
/* 241 */     buf.append("</").append("dao").append(">");
/*     */     
/* 243 */     return buf.toString();
/*     */   }
/*     */   
/*     */   public Map<String, String> getValues() {
/* 247 */     Map<String, String> values = super.getValues();
/* 248 */     if (this._organizationId != null) values.put("OrganizationId", DaoUtils.getXmlSafeFieldValue(-5, this._organizationId)); 
/* 249 */     if (this._category != null) values.put("Category", DaoUtils.getXmlSafeFieldValue(12, this._category)); 
/* 250 */     if (this._code != null) values.put("Code", DaoUtils.getXmlSafeFieldValue(12, this._code)); 
/* 251 */     if (this._createDate != null) values.put("CreateDate", DaoUtils.getXmlSafeFieldValue(91, this._createDate)); 
/* 252 */     if (this._createUserId != null) values.put("CreateUserId", DaoUtils.getXmlSafeFieldValue(12, this._createUserId)); 
/* 253 */     if (this._updateDate != null) values.put("UpdateDate", DaoUtils.getXmlSafeFieldValue(91, this._updateDate)); 
/* 254 */     if (this._updateUserId != null) values.put("UpdateUserId", DaoUtils.getXmlSafeFieldValue(12, this._updateUserId)); 
/* 255 */     if (this._configElement != null) values.put("ConfigElement", DaoUtils.getXmlSafeFieldValue(12, this._configElement)); 
/* 256 */     if (this._description != null) values.put("Description", DaoUtils.getXmlSafeFieldValue(12, this._description)); 
/* 257 */     if (this._sortOrder != null) values.put("SortOrder", DaoUtils.getXmlSafeFieldValue(4, this._sortOrder)); 
/* 258 */     if (this._hidden != null) values.put("Hidden", DaoUtils.getXmlSafeFieldValue(-7, this._hidden)); 
/* 259 */     if (this._rank != null) values.put("Rank", DaoUtils.getXmlSafeFieldValue(4, this._rank)); 
/* 260 */     if (this._imageUrl != null) values.put("ImageUrl", DaoUtils.getXmlSafeFieldValue(12, this._imageUrl)); 
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
/*     */         case "Category":
/*     */           try {
/* 284 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 285 */             setCategory((String)value);
/* 286 */           } catch (Exception ee) {
/* 287 */             throw new DtxException("An exception occurred while calling setCategory() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "Code":
/*     */           try {
/* 293 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 294 */             setCode((String)value);
/* 295 */           } catch (Exception ee) {
/* 296 */             throw new DtxException("An exception occurred while calling setCode() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "CreateDate":
/*     */           try {
/* 302 */             Object value = DaoUtils.getFieldValueForXmlString(91, fieldValue);
/* 303 */             setCreateDate((Date)value);
/* 304 */           } catch (Exception ee) {
/* 305 */             throw new DtxException("An exception occurred while calling setCreateDate() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "CreateUserId":
/*     */           try {
/* 311 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 312 */             setCreateUserId((String)value);
/* 313 */           } catch (Exception ee) {
/* 314 */             throw new DtxException("An exception occurred while calling setCreateUserId() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "UpdateDate":
/*     */           try {
/* 320 */             Object value = DaoUtils.getFieldValueForXmlString(91, fieldValue);
/* 321 */             setUpdateDate((Date)value);
/* 322 */           } catch (Exception ee) {
/* 323 */             throw new DtxException("An exception occurred while calling setUpdateDate() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "UpdateUserId":
/*     */           try {
/* 329 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 330 */             setUpdateUserId((String)value);
/* 331 */           } catch (Exception ee) {
/* 332 */             throw new DtxException("An exception occurred while calling setUpdateUserId() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "ConfigElement":
/*     */           try {
/* 338 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 339 */             setConfigElement((String)value);
/* 340 */           } catch (Exception ee) {
/* 341 */             throw new DtxException("An exception occurred while calling setConfigElement() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "Description":
/*     */           try {
/* 347 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 348 */             setDescription((String)value);
/* 349 */           } catch (Exception ee) {
/* 350 */             throw new DtxException("An exception occurred while calling setDescription() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "SortOrder":
/*     */           try {
/* 356 */             Object value = DaoUtils.getFieldValueForXmlString(4, fieldValue);
/* 357 */             setSortOrder((Integer)value);
/* 358 */           } catch (Exception ee) {
/* 359 */             throw new DtxException("An exception occurred while calling setSortOrder() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "Hidden":
/*     */           try {
/* 365 */             Object value = DaoUtils.getFieldValueForXmlString(-7, fieldValue);
/* 366 */             setHidden((Boolean)value);
/* 367 */           } catch (Exception ee) {
/* 368 */             throw new DtxException("An exception occurred while calling setHidden() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "Rank":
/*     */           try {
/* 374 */             Object value = DaoUtils.getFieldValueForXmlString(4, fieldValue);
/* 375 */             setRank((Integer)value);
/* 376 */           } catch (Exception ee) {
/* 377 */             throw new DtxException("An exception occurred while calling setRank() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "ImageUrl":
/*     */           try {
/* 383 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 384 */             setImageUrl((String)value);
/* 385 */           } catch (Exception ee) {
/* 386 */             throw new DtxException("An exception occurred while calling setImageUrl() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */       } 
/*     */     } 
/*     */   }
/*     */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\com\impl\CodeValueDAO.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */