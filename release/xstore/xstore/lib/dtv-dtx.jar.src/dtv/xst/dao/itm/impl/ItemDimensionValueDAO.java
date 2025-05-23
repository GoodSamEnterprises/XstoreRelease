/*     */ package dtv.xst.dao.itm.impl;
/*     */ 
/*     */ import dtv.data2.access.DaoUtils;
/*     */ import dtv.data2.access.IObjectId;
/*     */ import dtv.data2.access.exception.DtxException;
/*     */ import dtv.data2.access.impl.AbstractDAOImpl;
/*     */ import dtv.util.DtvDate;
/*     */ import dtv.xst.dao.itm.ItemDimensionValueId;
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
/*     */ public class ItemDimensionValueDAO
/*     */   extends AbstractDAOImpl
/*     */ {
/*     */   private static final long serialVersionUID = -1859499586L;
/*  23 */   private static final Logger _logger = Logger.getLogger(ItemDimensionValueDAO.class);
/*     */   
/*     */   private Long _organizationId;
/*     */   private String _dimensionSystem;
/*     */   private String _dimension;
/*     */   private String _dimensionValue;
/*     */   private String _orgCode;
/*     */   private String _orgValue;
/*     */   private DtvDate _createDate;
/*     */   private String _createUserId;
/*     */   private DtvDate _updateDate;
/*     */   private String _updateUserId;
/*     */   private Integer _sortOrder;
/*     */   private String _description;
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
/*     */   public String getDimensionSystem() {
/*  49 */     return this._dimensionSystem;
/*     */   }
/*     */   
/*     */   public void setDimensionSystem(String argDimensionSystem) {
/*  53 */     if (changed(argDimensionSystem, this._dimensionSystem, "dimensionSystem")) {
/*  54 */       this._dimensionSystem = (argDimensionSystem != null && MANAGE_CASE) ? argDimensionSystem.toUpperCase() : argDimensionSystem;
/*     */     }
/*     */   }
/*     */   
/*     */   public String getDimension() {
/*  59 */     return this._dimension;
/*     */   }
/*     */   
/*     */   public void setDimension(String argDimension) {
/*  63 */     if (changed(argDimension, this._dimension, "dimension")) {
/*  64 */       this._dimension = (argDimension != null && MANAGE_CASE) ? argDimension.toUpperCase() : argDimension;
/*     */     }
/*     */   }
/*     */   
/*     */   public String getDimensionValue() {
/*  69 */     return this._dimensionValue;
/*     */   }
/*     */   
/*     */   public void setDimensionValue(String argDimensionValue) {
/*  73 */     if (changed(argDimensionValue, this._dimensionValue, "dimensionValue")) {
/*  74 */       this._dimensionValue = (argDimensionValue != null && MANAGE_CASE) ? argDimensionValue.toUpperCase() : argDimensionValue;
/*     */     }
/*     */   }
/*     */   
/*     */   public String getOrgCode() {
/*  79 */     return this._orgCode;
/*     */   }
/*     */   
/*     */   public void setOrgCode(String argOrgCode) {
/*  83 */     if (changed(argOrgCode, this._orgCode, "orgCode")) {
/*  84 */       this._orgCode = argOrgCode;
/*     */     }
/*     */   }
/*     */   
/*     */   public String getOrgValue() {
/*  89 */     return this._orgValue;
/*     */   }
/*     */   
/*     */   public void setOrgValue(String argOrgValue) {
/*  93 */     if (changed(argOrgValue, this._orgValue, "orgValue")) {
/*  94 */       this._orgValue = argOrgValue;
/*     */     }
/*     */   }
/*     */   
/*     */   public Date getCreateDate() {
/*  99 */     return (Date)this._createDate;
/*     */   }
/*     */   
/*     */   public void setCreateDate(Date argCreateDate) {
/* 103 */     if (changed(argCreateDate, this._createDate, "createDate")) {
/* 104 */       this._createDate = (argCreateDate == null || argCreateDate instanceof DtvDate) ? (DtvDate)argCreateDate : new DtvDate(argCreateDate);
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public String getCreateUserId() {
/* 110 */     return this._createUserId;
/*     */   }
/*     */   
/*     */   public void setCreateUserId(String argCreateUserId) {
/* 114 */     if (changed(argCreateUserId, this._createUserId, "createUserId")) {
/* 115 */       this._createUserId = argCreateUserId;
/*     */     }
/*     */   }
/*     */   
/*     */   public Date getUpdateDate() {
/* 120 */     return (Date)this._updateDate;
/*     */   }
/*     */   
/*     */   public void setUpdateDate(Date argUpdateDate) {
/* 124 */     if (changed(argUpdateDate, this._updateDate, "updateDate")) {
/* 125 */       this._updateDate = (argUpdateDate == null || argUpdateDate instanceof DtvDate) ? (DtvDate)argUpdateDate : new DtvDate(argUpdateDate);
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public String getUpdateUserId() {
/* 131 */     return this._updateUserId;
/*     */   }
/*     */   
/*     */   public void setUpdateUserId(String argUpdateUserId) {
/* 135 */     if (changed(argUpdateUserId, this._updateUserId, "updateUserId")) {
/* 136 */       this._updateUserId = argUpdateUserId;
/*     */     }
/*     */   }
/*     */   
/*     */   public Integer getSortOrder() {
/* 141 */     return this._sortOrder;
/*     */   }
/*     */   
/*     */   public void setSortOrder(Integer argSortOrder) {
/* 145 */     if (changed(argSortOrder, this._sortOrder, "sortOrder")) {
/* 146 */       this._sortOrder = argSortOrder;
/*     */     }
/*     */   }
/*     */   
/*     */   public String getDescription() {
/* 151 */     return this._description;
/*     */   }
/*     */   
/*     */   public void setDescription(String argDescription) {
/* 155 */     if (changed(argDescription, this._description, "description")) {
/* 156 */       this._description = argDescription;
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public String toString() {
/* 163 */     StringBuilder buf = new StringBuilder(512);
/* 164 */     buf.append(super.toString()).append(" Id: ").append(getObjectId()).append(" Values: ");
/* 165 */     if (getOrganizationId() != null) {
/* 166 */       buf.append("organizationId").append("=").append(getOrganizationId()).append(" ");
/*     */     }
/* 168 */     if (getDimensionSystem() != null) {
/* 169 */       buf.append("dimensionSystem").append("=").append(getDimensionSystem()).append(" ");
/*     */     }
/* 171 */     if (getDimension() != null) {
/* 172 */       buf.append("dimension").append("=").append(getDimension()).append(" ");
/*     */     }
/* 174 */     if (getDimensionValue() != null) {
/* 175 */       buf.append("dimensionValue").append("=").append(getDimensionValue()).append(" ");
/*     */     }
/* 177 */     if (getOrgCode() != null) {
/* 178 */       buf.append("orgCode").append("=").append(getOrgCode()).append(" ");
/*     */     }
/* 180 */     if (getOrgValue() != null) {
/* 181 */       buf.append("orgValue").append("=").append(getOrgValue()).append(" ");
/*     */     }
/* 183 */     if (getCreateDate() != null) {
/* 184 */       buf.append("createDate").append("=").append(getCreateDate()).append(" ");
/*     */     }
/* 186 */     if (getCreateUserId() != null) {
/* 187 */       buf.append("createUserId").append("=").append(getCreateUserId()).append(" ");
/*     */     }
/* 189 */     if (getUpdateDate() != null) {
/* 190 */       buf.append("updateDate").append("=").append(getUpdateDate()).append(" ");
/*     */     }
/* 192 */     if (getUpdateUserId() != null) {
/* 193 */       buf.append("updateUserId").append("=").append(getUpdateUserId()).append(" ");
/*     */     }
/* 195 */     if (getSortOrder() != null) {
/* 196 */       buf.append("sortOrder").append("=").append(getSortOrder()).append(" ");
/*     */     }
/* 198 */     if (getDescription() != null) {
/* 199 */       buf.append("description").append("=").append(getDescription()).append(" ");
/*     */     }
/*     */     
/* 202 */     return buf.toString();
/*     */   }
/*     */   
/*     */   public IObjectId getObjectId() {
/* 206 */     ItemDimensionValueId id = new ItemDimensionValueId();
/* 207 */     id.setOrganizationId(getOrganizationId());
/* 208 */     id.setDimensionSystem(getDimensionSystem());
/* 209 */     id.setDimension(getDimension());
/* 210 */     id.setDimensionValue(getDimensionValue());
/* 211 */     return (IObjectId)id;
/*     */   }
/*     */   
/*     */   public void setObjectId(IObjectId argObjectId) {
/* 215 */     setOrganizationId(((ItemDimensionValueId)argObjectId).getOrganizationId());
/* 216 */     setDimensionSystem(((ItemDimensionValueId)argObjectId).getDimensionSystem());
/* 217 */     setDimension(((ItemDimensionValueId)argObjectId).getDimension());
/* 218 */     setDimensionValue(((ItemDimensionValueId)argObjectId).getDimensionValue());
/*     */   }
/*     */   
/*     */   public String getImplementingClass() {
/* 222 */     return null;
/*     */   }
/*     */   
/*     */   public String toXmlString() {
/* 226 */     StringBuilder buf = new StringBuilder(600);
/* 227 */     buf.append("<").append("dao").append(" name=\"ItemDimensionValue\" cmd=\"" + getObjectStateString() + "\">");
/* 228 */     getFieldsAsXml(buf);
/* 229 */     buf.append("</").append("dao").append(">");
/*     */     
/* 231 */     return buf.toString();
/*     */   }
/*     */   
/*     */   public Map<String, String> getValues() {
/* 235 */     Map<String, String> values = super.getValues();
/* 236 */     if (this._organizationId != null) values.put("OrganizationId", DaoUtils.getXmlSafeFieldValue(-5, this._organizationId)); 
/* 237 */     if (this._dimensionSystem != null) values.put("DimensionSystem", DaoUtils.getXmlSafeFieldValue(12, this._dimensionSystem)); 
/* 238 */     if (this._dimension != null) values.put("Dimension", DaoUtils.getXmlSafeFieldValue(12, this._dimension)); 
/* 239 */     if (this._dimensionValue != null) values.put("DimensionValue", DaoUtils.getXmlSafeFieldValue(12, this._dimensionValue)); 
/* 240 */     if (this._orgCode != null) values.put("OrgCode", DaoUtils.getXmlSafeFieldValue(12, this._orgCode)); 
/* 241 */     if (this._orgValue != null) values.put("OrgValue", DaoUtils.getXmlSafeFieldValue(12, this._orgValue)); 
/* 242 */     if (this._createDate != null) values.put("CreateDate", DaoUtils.getXmlSafeFieldValue(91, this._createDate)); 
/* 243 */     if (this._createUserId != null) values.put("CreateUserId", DaoUtils.getXmlSafeFieldValue(12, this._createUserId)); 
/* 244 */     if (this._updateDate != null) values.put("UpdateDate", DaoUtils.getXmlSafeFieldValue(91, this._updateDate)); 
/* 245 */     if (this._updateUserId != null) values.put("UpdateUserId", DaoUtils.getXmlSafeFieldValue(12, this._updateUserId)); 
/* 246 */     if (this._sortOrder != null) values.put("SortOrder", DaoUtils.getXmlSafeFieldValue(4, this._sortOrder)); 
/* 247 */     if (this._description != null) values.put("Description", DaoUtils.getXmlSafeFieldValue(12, this._description)); 
/* 248 */     return values;
/*     */   }
/*     */ 
/*     */   
/*     */   public void setValues(Map<String, String> argValues) {
/* 253 */     super.setValues(argValues);
/* 254 */     for (Map.Entry<String, String> field : argValues.entrySet()) {
/*     */       
/* 256 */       String fieldName = field.getKey();
/* 257 */       String fieldValue = field.getValue();
/* 258 */       switch (fieldName) {
/*     */         
/*     */         case "OrganizationId":
/*     */           try {
/* 262 */             Object value = DaoUtils.getFieldValueForXmlString(-5, fieldValue);
/* 263 */             setOrganizationId((Long)value);
/* 264 */           } catch (Exception ee) {
/* 265 */             throw new DtxException("An exception occurred while calling setOrganizationId() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "DimensionSystem":
/*     */           try {
/* 271 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 272 */             setDimensionSystem((String)value);
/* 273 */           } catch (Exception ee) {
/* 274 */             throw new DtxException("An exception occurred while calling setDimensionSystem() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "Dimension":
/*     */           try {
/* 280 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 281 */             setDimension((String)value);
/* 282 */           } catch (Exception ee) {
/* 283 */             throw new DtxException("An exception occurred while calling setDimension() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "DimensionValue":
/*     */           try {
/* 289 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 290 */             setDimensionValue((String)value);
/* 291 */           } catch (Exception ee) {
/* 292 */             throw new DtxException("An exception occurred while calling setDimensionValue() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "OrgCode":
/*     */           try {
/* 298 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 299 */             setOrgCode((String)value);
/* 300 */           } catch (Exception ee) {
/* 301 */             throw new DtxException("An exception occurred while calling setOrgCode() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "OrgValue":
/*     */           try {
/* 307 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 308 */             setOrgValue((String)value);
/* 309 */           } catch (Exception ee) {
/* 310 */             throw new DtxException("An exception occurred while calling setOrgValue() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "CreateDate":
/*     */           try {
/* 316 */             Object value = DaoUtils.getFieldValueForXmlString(91, fieldValue);
/* 317 */             setCreateDate((Date)value);
/* 318 */           } catch (Exception ee) {
/* 319 */             throw new DtxException("An exception occurred while calling setCreateDate() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "CreateUserId":
/*     */           try {
/* 325 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 326 */             setCreateUserId((String)value);
/* 327 */           } catch (Exception ee) {
/* 328 */             throw new DtxException("An exception occurred while calling setCreateUserId() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "UpdateDate":
/*     */           try {
/* 334 */             Object value = DaoUtils.getFieldValueForXmlString(91, fieldValue);
/* 335 */             setUpdateDate((Date)value);
/* 336 */           } catch (Exception ee) {
/* 337 */             throw new DtxException("An exception occurred while calling setUpdateDate() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "UpdateUserId":
/*     */           try {
/* 343 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 344 */             setUpdateUserId((String)value);
/* 345 */           } catch (Exception ee) {
/* 346 */             throw new DtxException("An exception occurred while calling setUpdateUserId() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "SortOrder":
/*     */           try {
/* 352 */             Object value = DaoUtils.getFieldValueForXmlString(4, fieldValue);
/* 353 */             setSortOrder((Integer)value);
/* 354 */           } catch (Exception ee) {
/* 355 */             throw new DtxException("An exception occurred while calling setSortOrder() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "Description":
/*     */           try {
/* 361 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 362 */             setDescription((String)value);
/* 363 */           } catch (Exception ee) {
/* 364 */             throw new DtxException("An exception occurred while calling setDescription() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */       } 
/*     */     } 
/*     */   }
/*     */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\itm\impl\ItemDimensionValueDAO.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */