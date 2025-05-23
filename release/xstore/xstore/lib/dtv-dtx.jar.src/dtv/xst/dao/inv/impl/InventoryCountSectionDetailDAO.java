/*     */ package dtv.xst.dao.inv.impl;
/*     */ 
/*     */ import dtv.data2.access.DaoUtils;
/*     */ import dtv.data2.access.IObjectId;
/*     */ import dtv.data2.access.exception.DtxException;
/*     */ import dtv.data2.access.impl.AbstractDAOImpl;
/*     */ import dtv.util.DtvDate;
/*     */ import dtv.xst.dao.inv.InventoryCountSectionDetailId;
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
/*     */ public class InventoryCountSectionDetailDAO
/*     */   extends AbstractDAOImpl
/*     */ {
/*     */   private static final long serialVersionUID = 1362489635L;
/*  23 */   private static final Logger _logger = Logger.getLogger(InventoryCountSectionDetailDAO.class);
/*     */   
/*     */   private Long _organizationId;
/*     */   private Long _retailLocationId;
/*     */   private String _inventoryBucketId;
/*     */   private String _sectionId;
/*     */   private Integer _sectionDetailNumber;
/*     */   private DtvDate _createDate;
/*     */   private String _createUserId;
/*     */   private DtvDate _updateDate;
/*     */   private String _updateUserId;
/*     */   private String _merchandiseHierarchyLevel;
/*     */   private String _merchandiseHierarchyId;
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
/*     */   public Long getRetailLocationId() {
/*  49 */     return this._retailLocationId;
/*     */   }
/*     */   
/*     */   public void setRetailLocationId(Long argRetailLocationId) {
/*  53 */     if (changed(argRetailLocationId, this._retailLocationId, "retailLocationId")) {
/*  54 */       this._retailLocationId = argRetailLocationId;
/*     */     }
/*     */   }
/*     */   
/*     */   public String getInventoryBucketId() {
/*  59 */     return this._inventoryBucketId;
/*     */   }
/*     */   
/*     */   public void setInventoryBucketId(String argInventoryBucketId) {
/*  63 */     if (changed(argInventoryBucketId, this._inventoryBucketId, "inventoryBucketId")) {
/*  64 */       this._inventoryBucketId = (argInventoryBucketId != null && MANAGE_CASE) ? argInventoryBucketId.toUpperCase() : argInventoryBucketId;
/*     */     }
/*     */   }
/*     */   
/*     */   public String getSectionId() {
/*  69 */     return this._sectionId;
/*     */   }
/*     */   
/*     */   public void setSectionId(String argSectionId) {
/*  73 */     if (changed(argSectionId, this._sectionId, "sectionId")) {
/*  74 */       this._sectionId = (argSectionId != null && MANAGE_CASE) ? argSectionId.toUpperCase() : argSectionId;
/*     */     }
/*     */   }
/*     */   
/*     */   public Integer getSectionDetailNumber() {
/*  79 */     return this._sectionDetailNumber;
/*     */   }
/*     */   
/*     */   public void setSectionDetailNumber(Integer argSectionDetailNumber) {
/*  83 */     if (changed(argSectionDetailNumber, this._sectionDetailNumber, "sectionDetailNumber")) {
/*  84 */       this._sectionDetailNumber = argSectionDetailNumber;
/*     */     }
/*     */   }
/*     */   
/*     */   public Date getCreateDate() {
/*  89 */     return (Date)this._createDate;
/*     */   }
/*     */   
/*     */   public void setCreateDate(Date argCreateDate) {
/*  93 */     if (changed(argCreateDate, this._createDate, "createDate")) {
/*  94 */       this._createDate = (argCreateDate == null || argCreateDate instanceof DtvDate) ? (DtvDate)argCreateDate : new DtvDate(argCreateDate);
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public String getCreateUserId() {
/* 100 */     return this._createUserId;
/*     */   }
/*     */   
/*     */   public void setCreateUserId(String argCreateUserId) {
/* 104 */     if (changed(argCreateUserId, this._createUserId, "createUserId")) {
/* 105 */       this._createUserId = argCreateUserId;
/*     */     }
/*     */   }
/*     */   
/*     */   public Date getUpdateDate() {
/* 110 */     return (Date)this._updateDate;
/*     */   }
/*     */   
/*     */   public void setUpdateDate(Date argUpdateDate) {
/* 114 */     if (changed(argUpdateDate, this._updateDate, "updateDate")) {
/* 115 */       this._updateDate = (argUpdateDate == null || argUpdateDate instanceof DtvDate) ? (DtvDate)argUpdateDate : new DtvDate(argUpdateDate);
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public String getUpdateUserId() {
/* 121 */     return this._updateUserId;
/*     */   }
/*     */   
/*     */   public void setUpdateUserId(String argUpdateUserId) {
/* 125 */     if (changed(argUpdateUserId, this._updateUserId, "updateUserId")) {
/* 126 */       this._updateUserId = argUpdateUserId;
/*     */     }
/*     */   }
/*     */   
/*     */   public String getMerchandiseHierarchyLevel() {
/* 131 */     return this._merchandiseHierarchyLevel;
/*     */   }
/*     */   
/*     */   public void setMerchandiseHierarchyLevel(String argMerchandiseHierarchyLevel) {
/* 135 */     if (changed(argMerchandiseHierarchyLevel, this._merchandiseHierarchyLevel, "merchandiseHierarchyLevel")) {
/* 136 */       this._merchandiseHierarchyLevel = argMerchandiseHierarchyLevel;
/*     */     }
/*     */   }
/*     */   
/*     */   public String getMerchandiseHierarchyId() {
/* 141 */     return this._merchandiseHierarchyId;
/*     */   }
/*     */   
/*     */   public void setMerchandiseHierarchyId(String argMerchandiseHierarchyId) {
/* 145 */     if (changed(argMerchandiseHierarchyId, this._merchandiseHierarchyId, "merchandiseHierarchyId")) {
/* 146 */       this._merchandiseHierarchyId = argMerchandiseHierarchyId;
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
/* 168 */     if (getRetailLocationId() != null) {
/* 169 */       buf.append("retailLocationId").append("=").append(getRetailLocationId()).append(" ");
/*     */     }
/* 171 */     if (getInventoryBucketId() != null) {
/* 172 */       buf.append("inventoryBucketId").append("=").append(getInventoryBucketId()).append(" ");
/*     */     }
/* 174 */     if (getSectionId() != null) {
/* 175 */       buf.append("sectionId").append("=").append(getSectionId()).append(" ");
/*     */     }
/* 177 */     if (getSectionDetailNumber() != null) {
/* 178 */       buf.append("sectionDetailNumber").append("=").append(getSectionDetailNumber()).append(" ");
/*     */     }
/* 180 */     if (getCreateDate() != null) {
/* 181 */       buf.append("createDate").append("=").append(getCreateDate()).append(" ");
/*     */     }
/* 183 */     if (getCreateUserId() != null) {
/* 184 */       buf.append("createUserId").append("=").append(getCreateUserId()).append(" ");
/*     */     }
/* 186 */     if (getUpdateDate() != null) {
/* 187 */       buf.append("updateDate").append("=").append(getUpdateDate()).append(" ");
/*     */     }
/* 189 */     if (getUpdateUserId() != null) {
/* 190 */       buf.append("updateUserId").append("=").append(getUpdateUserId()).append(" ");
/*     */     }
/* 192 */     if (getMerchandiseHierarchyLevel() != null) {
/* 193 */       buf.append("merchandiseHierarchyLevel").append("=").append(getMerchandiseHierarchyLevel()).append(" ");
/*     */     }
/* 195 */     if (getMerchandiseHierarchyId() != null) {
/* 196 */       buf.append("merchandiseHierarchyId").append("=").append(getMerchandiseHierarchyId()).append(" ");
/*     */     }
/* 198 */     if (getDescription() != null) {
/* 199 */       buf.append("description").append("=").append(getDescription()).append(" ");
/*     */     }
/*     */     
/* 202 */     return buf.toString();
/*     */   }
/*     */   
/*     */   public IObjectId getObjectId() {
/* 206 */     InventoryCountSectionDetailId id = new InventoryCountSectionDetailId();
/* 207 */     id.setOrganizationId(getOrganizationId());
/* 208 */     id.setRetailLocationId(getRetailLocationId());
/* 209 */     id.setInventoryBucketId(getInventoryBucketId());
/* 210 */     id.setSectionId(getSectionId());
/* 211 */     id.setSectionDetailNumber(getSectionDetailNumber());
/* 212 */     return (IObjectId)id;
/*     */   }
/*     */   
/*     */   public void setObjectId(IObjectId argObjectId) {
/* 216 */     setOrganizationId(((InventoryCountSectionDetailId)argObjectId).getOrganizationId());
/* 217 */     setRetailLocationId(((InventoryCountSectionDetailId)argObjectId).getRetailLocationId());
/* 218 */     setInventoryBucketId(((InventoryCountSectionDetailId)argObjectId).getInventoryBucketId());
/* 219 */     setSectionId(((InventoryCountSectionDetailId)argObjectId).getSectionId());
/* 220 */     setSectionDetailNumber(((InventoryCountSectionDetailId)argObjectId).getSectionDetailNumber());
/*     */   }
/*     */   
/*     */   public String getImplementingClass() {
/* 224 */     return null;
/*     */   }
/*     */   
/*     */   public String toXmlString() {
/* 228 */     StringBuilder buf = new StringBuilder(600);
/* 229 */     buf.append("<").append("dao").append(" name=\"InventoryCountSectionDetail\" cmd=\"" + getObjectStateString() + "\">");
/* 230 */     getFieldsAsXml(buf);
/* 231 */     buf.append("</").append("dao").append(">");
/*     */     
/* 233 */     return buf.toString();
/*     */   }
/*     */   
/*     */   public Map<String, String> getValues() {
/* 237 */     Map<String, String> values = super.getValues();
/* 238 */     if (this._organizationId != null) values.put("OrganizationId", DaoUtils.getXmlSafeFieldValue(-5, this._organizationId)); 
/* 239 */     if (this._retailLocationId != null) values.put("RetailLocationId", DaoUtils.getXmlSafeFieldValue(-5, this._retailLocationId)); 
/* 240 */     if (this._inventoryBucketId != null) values.put("InventoryBucketId", DaoUtils.getXmlSafeFieldValue(12, this._inventoryBucketId)); 
/* 241 */     if (this._sectionId != null) values.put("SectionId", DaoUtils.getXmlSafeFieldValue(12, this._sectionId)); 
/* 242 */     if (this._sectionDetailNumber != null) values.put("SectionDetailNumber", DaoUtils.getXmlSafeFieldValue(4, this._sectionDetailNumber)); 
/* 243 */     if (this._createDate != null) values.put("CreateDate", DaoUtils.getXmlSafeFieldValue(91, this._createDate)); 
/* 244 */     if (this._createUserId != null) values.put("CreateUserId", DaoUtils.getXmlSafeFieldValue(12, this._createUserId)); 
/* 245 */     if (this._updateDate != null) values.put("UpdateDate", DaoUtils.getXmlSafeFieldValue(91, this._updateDate)); 
/* 246 */     if (this._updateUserId != null) values.put("UpdateUserId", DaoUtils.getXmlSafeFieldValue(12, this._updateUserId)); 
/* 247 */     if (this._merchandiseHierarchyLevel != null) values.put("MerchandiseHierarchyLevel", DaoUtils.getXmlSafeFieldValue(12, this._merchandiseHierarchyLevel)); 
/* 248 */     if (this._merchandiseHierarchyId != null) values.put("MerchandiseHierarchyId", DaoUtils.getXmlSafeFieldValue(12, this._merchandiseHierarchyId)); 
/* 249 */     if (this._description != null) values.put("Description", DaoUtils.getXmlSafeFieldValue(12, this._description)); 
/* 250 */     return values;
/*     */   }
/*     */ 
/*     */   
/*     */   public void setValues(Map<String, String> argValues) {
/* 255 */     super.setValues(argValues);
/* 256 */     for (Map.Entry<String, String> field : argValues.entrySet()) {
/*     */       
/* 258 */       String fieldName = field.getKey();
/* 259 */       String fieldValue = field.getValue();
/* 260 */       switch (fieldName) {
/*     */         
/*     */         case "OrganizationId":
/*     */           try {
/* 264 */             Object value = DaoUtils.getFieldValueForXmlString(-5, fieldValue);
/* 265 */             setOrganizationId((Long)value);
/* 266 */           } catch (Exception ee) {
/* 267 */             throw new DtxException("An exception occurred while calling setOrganizationId() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "RetailLocationId":
/*     */           try {
/* 273 */             Object value = DaoUtils.getFieldValueForXmlString(-5, fieldValue);
/* 274 */             setRetailLocationId((Long)value);
/* 275 */           } catch (Exception ee) {
/* 276 */             throw new DtxException("An exception occurred while calling setRetailLocationId() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "InventoryBucketId":
/*     */           try {
/* 282 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 283 */             setInventoryBucketId((String)value);
/* 284 */           } catch (Exception ee) {
/* 285 */             throw new DtxException("An exception occurred while calling setInventoryBucketId() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "SectionId":
/*     */           try {
/* 291 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 292 */             setSectionId((String)value);
/* 293 */           } catch (Exception ee) {
/* 294 */             throw new DtxException("An exception occurred while calling setSectionId() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "SectionDetailNumber":
/*     */           try {
/* 300 */             Object value = DaoUtils.getFieldValueForXmlString(4, fieldValue);
/* 301 */             setSectionDetailNumber((Integer)value);
/* 302 */           } catch (Exception ee) {
/* 303 */             throw new DtxException("An exception occurred while calling setSectionDetailNumber() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "CreateDate":
/*     */           try {
/* 309 */             Object value = DaoUtils.getFieldValueForXmlString(91, fieldValue);
/* 310 */             setCreateDate((Date)value);
/* 311 */           } catch (Exception ee) {
/* 312 */             throw new DtxException("An exception occurred while calling setCreateDate() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "CreateUserId":
/*     */           try {
/* 318 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 319 */             setCreateUserId((String)value);
/* 320 */           } catch (Exception ee) {
/* 321 */             throw new DtxException("An exception occurred while calling setCreateUserId() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "UpdateDate":
/*     */           try {
/* 327 */             Object value = DaoUtils.getFieldValueForXmlString(91, fieldValue);
/* 328 */             setUpdateDate((Date)value);
/* 329 */           } catch (Exception ee) {
/* 330 */             throw new DtxException("An exception occurred while calling setUpdateDate() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "UpdateUserId":
/*     */           try {
/* 336 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 337 */             setUpdateUserId((String)value);
/* 338 */           } catch (Exception ee) {
/* 339 */             throw new DtxException("An exception occurred while calling setUpdateUserId() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "MerchandiseHierarchyLevel":
/*     */           try {
/* 345 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 346 */             setMerchandiseHierarchyLevel((String)value);
/* 347 */           } catch (Exception ee) {
/* 348 */             throw new DtxException("An exception occurred while calling setMerchandiseHierarchyLevel() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "MerchandiseHierarchyId":
/*     */           try {
/* 354 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 355 */             setMerchandiseHierarchyId((String)value);
/* 356 */           } catch (Exception ee) {
/* 357 */             throw new DtxException("An exception occurred while calling setMerchandiseHierarchyId() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "Description":
/*     */           try {
/* 363 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 364 */             setDescription((String)value);
/* 365 */           } catch (Exception ee) {
/* 366 */             throw new DtxException("An exception occurred while calling setDescription() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */       } 
/*     */     } 
/*     */   }
/*     */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\inv\impl\InventoryCountSectionDetailDAO.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */