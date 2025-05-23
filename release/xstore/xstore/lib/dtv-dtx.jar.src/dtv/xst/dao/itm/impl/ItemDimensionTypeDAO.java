/*     */ package dtv.xst.dao.itm.impl;
/*     */ 
/*     */ import dtv.data2.access.DaoUtils;
/*     */ import dtv.data2.access.IObjectId;
/*     */ import dtv.data2.access.exception.DtxException;
/*     */ import dtv.data2.access.impl.AbstractDAOImpl;
/*     */ import dtv.util.DtvDate;
/*     */ import dtv.xst.dao.itm.ItemDimensionTypeId;
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
/*     */ public class ItemDimensionTypeDAO
/*     */   extends AbstractDAOImpl
/*     */ {
/*     */   private static final long serialVersionUID = -198567603L;
/*  23 */   private static final Logger _logger = Logger.getLogger(ItemDimensionTypeDAO.class);
/*     */   
/*     */   private Long _organizationId;
/*     */   private String _dimensionSystem;
/*     */   private String _dimension;
/*     */   private String _orgCode;
/*     */   private String _orgValue;
/*     */   private DtvDate _createDate;
/*     */   private String _createUserId;
/*     */   private DtvDate _updateDate;
/*     */   private String _updateUserId;
/*     */   private Integer _sequence;
/*     */   private Integer _sortOrder;
/*     */   private String _description;
/*     */   private String _promptMessage;
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
/*     */   public String getDimensionSystem() {
/*  50 */     return this._dimensionSystem;
/*     */   }
/*     */   
/*     */   public void setDimensionSystem(String argDimensionSystem) {
/*  54 */     if (changed(argDimensionSystem, this._dimensionSystem, "dimensionSystem")) {
/*  55 */       this._dimensionSystem = (argDimensionSystem != null && MANAGE_CASE) ? argDimensionSystem.toUpperCase() : argDimensionSystem;
/*     */     }
/*     */   }
/*     */   
/*     */   public String getDimension() {
/*  60 */     return this._dimension;
/*     */   }
/*     */   
/*     */   public void setDimension(String argDimension) {
/*  64 */     if (changed(argDimension, this._dimension, "dimension")) {
/*  65 */       this._dimension = (argDimension != null && MANAGE_CASE) ? argDimension.toUpperCase() : argDimension;
/*     */     }
/*     */   }
/*     */   
/*     */   public String getOrgCode() {
/*  70 */     return this._orgCode;
/*     */   }
/*     */   
/*     */   public void setOrgCode(String argOrgCode) {
/*  74 */     if (changed(argOrgCode, this._orgCode, "orgCode")) {
/*  75 */       this._orgCode = argOrgCode;
/*     */     }
/*     */   }
/*     */   
/*     */   public String getOrgValue() {
/*  80 */     return this._orgValue;
/*     */   }
/*     */   
/*     */   public void setOrgValue(String argOrgValue) {
/*  84 */     if (changed(argOrgValue, this._orgValue, "orgValue")) {
/*  85 */       this._orgValue = argOrgValue;
/*     */     }
/*     */   }
/*     */   
/*     */   public Date getCreateDate() {
/*  90 */     return (Date)this._createDate;
/*     */   }
/*     */   
/*     */   public void setCreateDate(Date argCreateDate) {
/*  94 */     if (changed(argCreateDate, this._createDate, "createDate")) {
/*  95 */       this._createDate = (argCreateDate == null || argCreateDate instanceof DtvDate) ? (DtvDate)argCreateDate : new DtvDate(argCreateDate);
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public String getCreateUserId() {
/* 101 */     return this._createUserId;
/*     */   }
/*     */   
/*     */   public void setCreateUserId(String argCreateUserId) {
/* 105 */     if (changed(argCreateUserId, this._createUserId, "createUserId")) {
/* 106 */       this._createUserId = argCreateUserId;
/*     */     }
/*     */   }
/*     */   
/*     */   public Date getUpdateDate() {
/* 111 */     return (Date)this._updateDate;
/*     */   }
/*     */   
/*     */   public void setUpdateDate(Date argUpdateDate) {
/* 115 */     if (changed(argUpdateDate, this._updateDate, "updateDate")) {
/* 116 */       this._updateDate = (argUpdateDate == null || argUpdateDate instanceof DtvDate) ? (DtvDate)argUpdateDate : new DtvDate(argUpdateDate);
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public String getUpdateUserId() {
/* 122 */     return this._updateUserId;
/*     */   }
/*     */   
/*     */   public void setUpdateUserId(String argUpdateUserId) {
/* 126 */     if (changed(argUpdateUserId, this._updateUserId, "updateUserId")) {
/* 127 */       this._updateUserId = argUpdateUserId;
/*     */     }
/*     */   }
/*     */   
/*     */   public Integer getSequence() {
/* 132 */     return this._sequence;
/*     */   }
/*     */   
/*     */   public void setSequence(Integer argSequence) {
/* 136 */     if (changed(argSequence, this._sequence, "sequence")) {
/* 137 */       this._sequence = argSequence;
/*     */     }
/*     */   }
/*     */   
/*     */   public Integer getSortOrder() {
/* 142 */     return this._sortOrder;
/*     */   }
/*     */   
/*     */   public void setSortOrder(Integer argSortOrder) {
/* 146 */     if (changed(argSortOrder, this._sortOrder, "sortOrder")) {
/* 147 */       this._sortOrder = argSortOrder;
/*     */     }
/*     */   }
/*     */   
/*     */   public String getDescription() {
/* 152 */     return this._description;
/*     */   }
/*     */   
/*     */   public void setDescription(String argDescription) {
/* 156 */     if (changed(argDescription, this._description, "description")) {
/* 157 */       this._description = argDescription;
/*     */     }
/*     */   }
/*     */   
/*     */   public String getPromptMessage() {
/* 162 */     return this._promptMessage;
/*     */   }
/*     */   
/*     */   public void setPromptMessage(String argPromptMessage) {
/* 166 */     if (changed(argPromptMessage, this._promptMessage, "promptMessage")) {
/* 167 */       this._promptMessage = argPromptMessage;
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
/* 179 */     if (getDimensionSystem() != null) {
/* 180 */       buf.append("dimensionSystem").append("=").append(getDimensionSystem()).append(" ");
/*     */     }
/* 182 */     if (getDimension() != null) {
/* 183 */       buf.append("dimension").append("=").append(getDimension()).append(" ");
/*     */     }
/* 185 */     if (getOrgCode() != null) {
/* 186 */       buf.append("orgCode").append("=").append(getOrgCode()).append(" ");
/*     */     }
/* 188 */     if (getOrgValue() != null) {
/* 189 */       buf.append("orgValue").append("=").append(getOrgValue()).append(" ");
/*     */     }
/* 191 */     if (getCreateDate() != null) {
/* 192 */       buf.append("createDate").append("=").append(getCreateDate()).append(" ");
/*     */     }
/* 194 */     if (getCreateUserId() != null) {
/* 195 */       buf.append("createUserId").append("=").append(getCreateUserId()).append(" ");
/*     */     }
/* 197 */     if (getUpdateDate() != null) {
/* 198 */       buf.append("updateDate").append("=").append(getUpdateDate()).append(" ");
/*     */     }
/* 200 */     if (getUpdateUserId() != null) {
/* 201 */       buf.append("updateUserId").append("=").append(getUpdateUserId()).append(" ");
/*     */     }
/* 203 */     if (getSequence() != null) {
/* 204 */       buf.append("sequence").append("=").append(getSequence()).append(" ");
/*     */     }
/* 206 */     if (getSortOrder() != null) {
/* 207 */       buf.append("sortOrder").append("=").append(getSortOrder()).append(" ");
/*     */     }
/* 209 */     if (getDescription() != null) {
/* 210 */       buf.append("description").append("=").append(getDescription()).append(" ");
/*     */     }
/* 212 */     if (getPromptMessage() != null) {
/* 213 */       buf.append("promptMessage").append("=").append(getPromptMessage()).append(" ");
/*     */     }
/*     */     
/* 216 */     return buf.toString();
/*     */   }
/*     */   
/*     */   public IObjectId getObjectId() {
/* 220 */     ItemDimensionTypeId id = new ItemDimensionTypeId();
/* 221 */     id.setOrganizationId(getOrganizationId());
/* 222 */     id.setDimensionSystem(getDimensionSystem());
/* 223 */     id.setDimension(getDimension());
/* 224 */     return (IObjectId)id;
/*     */   }
/*     */   
/*     */   public void setObjectId(IObjectId argObjectId) {
/* 228 */     setOrganizationId(((ItemDimensionTypeId)argObjectId).getOrganizationId());
/* 229 */     setDimensionSystem(((ItemDimensionTypeId)argObjectId).getDimensionSystem());
/* 230 */     setDimension(((ItemDimensionTypeId)argObjectId).getDimension());
/*     */   }
/*     */   
/*     */   public String getImplementingClass() {
/* 234 */     return null;
/*     */   }
/*     */   
/*     */   public String toXmlString() {
/* 238 */     StringBuilder buf = new StringBuilder(650);
/* 239 */     buf.append("<").append("dao").append(" name=\"ItemDimensionType\" cmd=\"" + getObjectStateString() + "\">");
/* 240 */     getFieldsAsXml(buf);
/* 241 */     buf.append("</").append("dao").append(">");
/*     */     
/* 243 */     return buf.toString();
/*     */   }
/*     */   
/*     */   public Map<String, String> getValues() {
/* 247 */     Map<String, String> values = super.getValues();
/* 248 */     if (this._organizationId != null) values.put("OrganizationId", DaoUtils.getXmlSafeFieldValue(-5, this._organizationId)); 
/* 249 */     if (this._dimensionSystem != null) values.put("DimensionSystem", DaoUtils.getXmlSafeFieldValue(12, this._dimensionSystem)); 
/* 250 */     if (this._dimension != null) values.put("Dimension", DaoUtils.getXmlSafeFieldValue(12, this._dimension)); 
/* 251 */     if (this._orgCode != null) values.put("OrgCode", DaoUtils.getXmlSafeFieldValue(12, this._orgCode)); 
/* 252 */     if (this._orgValue != null) values.put("OrgValue", DaoUtils.getXmlSafeFieldValue(12, this._orgValue)); 
/* 253 */     if (this._createDate != null) values.put("CreateDate", DaoUtils.getXmlSafeFieldValue(91, this._createDate)); 
/* 254 */     if (this._createUserId != null) values.put("CreateUserId", DaoUtils.getXmlSafeFieldValue(12, this._createUserId)); 
/* 255 */     if (this._updateDate != null) values.put("UpdateDate", DaoUtils.getXmlSafeFieldValue(91, this._updateDate)); 
/* 256 */     if (this._updateUserId != null) values.put("UpdateUserId", DaoUtils.getXmlSafeFieldValue(12, this._updateUserId)); 
/* 257 */     if (this._sequence != null) values.put("Sequence", DaoUtils.getXmlSafeFieldValue(4, this._sequence)); 
/* 258 */     if (this._sortOrder != null) values.put("SortOrder", DaoUtils.getXmlSafeFieldValue(4, this._sortOrder)); 
/* 259 */     if (this._description != null) values.put("Description", DaoUtils.getXmlSafeFieldValue(12, this._description)); 
/* 260 */     if (this._promptMessage != null) values.put("PromptMessage", DaoUtils.getXmlSafeFieldValue(12, this._promptMessage)); 
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
/*     */         case "DimensionSystem":
/*     */           try {
/* 284 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 285 */             setDimensionSystem((String)value);
/* 286 */           } catch (Exception ee) {
/* 287 */             throw new DtxException("An exception occurred while calling setDimensionSystem() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "Dimension":
/*     */           try {
/* 293 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 294 */             setDimension((String)value);
/* 295 */           } catch (Exception ee) {
/* 296 */             throw new DtxException("An exception occurred while calling setDimension() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "OrgCode":
/*     */           try {
/* 302 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 303 */             setOrgCode((String)value);
/* 304 */           } catch (Exception ee) {
/* 305 */             throw new DtxException("An exception occurred while calling setOrgCode() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "OrgValue":
/*     */           try {
/* 311 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 312 */             setOrgValue((String)value);
/* 313 */           } catch (Exception ee) {
/* 314 */             throw new DtxException("An exception occurred while calling setOrgValue() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "CreateDate":
/*     */           try {
/* 320 */             Object value = DaoUtils.getFieldValueForXmlString(91, fieldValue);
/* 321 */             setCreateDate((Date)value);
/* 322 */           } catch (Exception ee) {
/* 323 */             throw new DtxException("An exception occurred while calling setCreateDate() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "CreateUserId":
/*     */           try {
/* 329 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 330 */             setCreateUserId((String)value);
/* 331 */           } catch (Exception ee) {
/* 332 */             throw new DtxException("An exception occurred while calling setCreateUserId() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "UpdateDate":
/*     */           try {
/* 338 */             Object value = DaoUtils.getFieldValueForXmlString(91, fieldValue);
/* 339 */             setUpdateDate((Date)value);
/* 340 */           } catch (Exception ee) {
/* 341 */             throw new DtxException("An exception occurred while calling setUpdateDate() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "UpdateUserId":
/*     */           try {
/* 347 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 348 */             setUpdateUserId((String)value);
/* 349 */           } catch (Exception ee) {
/* 350 */             throw new DtxException("An exception occurred while calling setUpdateUserId() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "Sequence":
/*     */           try {
/* 356 */             Object value = DaoUtils.getFieldValueForXmlString(4, fieldValue);
/* 357 */             setSequence((Integer)value);
/* 358 */           } catch (Exception ee) {
/* 359 */             throw new DtxException("An exception occurred while calling setSequence() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
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
/*     */         case "Description":
/*     */           try {
/* 374 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 375 */             setDescription((String)value);
/* 376 */           } catch (Exception ee) {
/* 377 */             throw new DtxException("An exception occurred while calling setDescription() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "PromptMessage":
/*     */           try {
/* 383 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 384 */             setPromptMessage((String)value);
/* 385 */           } catch (Exception ee) {
/* 386 */             throw new DtxException("An exception occurred while calling setPromptMessage() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */       } 
/*     */     } 
/*     */   }
/*     */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\itm\impl\ItemDimensionTypeDAO.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */