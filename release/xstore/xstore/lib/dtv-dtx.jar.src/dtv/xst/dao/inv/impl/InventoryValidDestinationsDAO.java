/*     */ package dtv.xst.dao.inv.impl;
/*     */ 
/*     */ import dtv.data2.access.DaoUtils;
/*     */ import dtv.data2.access.IObjectId;
/*     */ import dtv.data2.access.exception.DtxException;
/*     */ import dtv.data2.access.impl.AbstractDAOImpl;
/*     */ import dtv.util.DtvDate;
/*     */ import dtv.xst.dao.inv.InventoryValidDestinationsId;
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
/*     */ public class InventoryValidDestinationsDAO
/*     */   extends AbstractDAOImpl
/*     */ {
/*     */   private static final long serialVersionUID = 866266725L;
/*  23 */   private static final Logger _logger = Logger.getLogger(InventoryValidDestinationsDAO.class);
/*     */   
/*     */   private Long _organizationId;
/*     */   private Long _retailLocationId;
/*     */   private String _documentTypeCode;
/*     */   private String _documentSubtypeCode;
/*     */   private String _destinationTypeEnum;
/*     */   private String _destinationId;
/*     */   private DtvDate _createDate;
/*     */   private String _createUserId;
/*     */   private DtvDate _updateDate;
/*     */   private String _updateUserId;
/*     */   private String _description;
/*     */   private Integer _sortOrder;
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
/*     */   public String getDocumentTypeCode() {
/*  59 */     return this._documentTypeCode;
/*     */   }
/*     */   
/*     */   public void setDocumentTypeCode(String argDocumentTypeCode) {
/*  63 */     if (changed(argDocumentTypeCode, this._documentTypeCode, "documentTypeCode")) {
/*  64 */       this._documentTypeCode = (argDocumentTypeCode != null && MANAGE_CASE) ? argDocumentTypeCode.toUpperCase() : argDocumentTypeCode;
/*     */     }
/*     */   }
/*     */   
/*     */   public String getDocumentSubtypeCode() {
/*  69 */     return this._documentSubtypeCode;
/*     */   }
/*     */   
/*     */   public void setDocumentSubtypeCode(String argDocumentSubtypeCode) {
/*  73 */     if (changed(argDocumentSubtypeCode, this._documentSubtypeCode, "documentSubtypeCode")) {
/*  74 */       this._documentSubtypeCode = (argDocumentSubtypeCode != null && MANAGE_CASE) ? argDocumentSubtypeCode.toUpperCase() : argDocumentSubtypeCode;
/*     */     }
/*     */   }
/*     */   
/*     */   public String getDestinationTypeEnum() {
/*  79 */     return this._destinationTypeEnum;
/*     */   }
/*     */   
/*     */   public void setDestinationTypeEnum(String argDestinationTypeEnum) {
/*  83 */     if (changed(argDestinationTypeEnum, this._destinationTypeEnum, "destinationTypeEnum")) {
/*  84 */       this._destinationTypeEnum = (argDestinationTypeEnum != null && MANAGE_CASE) ? argDestinationTypeEnum.toUpperCase() : argDestinationTypeEnum;
/*     */     }
/*     */   }
/*     */   
/*     */   public String getDestinationId() {
/*  89 */     return this._destinationId;
/*     */   }
/*     */   
/*     */   public void setDestinationId(String argDestinationId) {
/*  93 */     if (changed(argDestinationId, this._destinationId, "destinationId")) {
/*  94 */       this._destinationId = (argDestinationId != null && MANAGE_CASE) ? argDestinationId.toUpperCase() : argDestinationId;
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
/*     */   public String getDescription() {
/* 141 */     return this._description;
/*     */   }
/*     */   
/*     */   public void setDescription(String argDescription) {
/* 145 */     if (changed(argDescription, this._description, "description")) {
/* 146 */       this._description = argDescription;
/*     */     }
/*     */   }
/*     */   
/*     */   public Integer getSortOrder() {
/* 151 */     return this._sortOrder;
/*     */   }
/*     */   
/*     */   public void setSortOrder(Integer argSortOrder) {
/* 155 */     if (changed(argSortOrder, this._sortOrder, "sortOrder")) {
/* 156 */       this._sortOrder = argSortOrder;
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
/* 171 */     if (getDocumentTypeCode() != null) {
/* 172 */       buf.append("documentTypeCode").append("=").append(getDocumentTypeCode()).append(" ");
/*     */     }
/* 174 */     if (getDocumentSubtypeCode() != null) {
/* 175 */       buf.append("documentSubtypeCode").append("=").append(getDocumentSubtypeCode()).append(" ");
/*     */     }
/* 177 */     if (getDestinationTypeEnum() != null) {
/* 178 */       buf.append("destinationTypeEnum").append("=").append(getDestinationTypeEnum()).append(" ");
/*     */     }
/* 180 */     if (getDestinationId() != null) {
/* 181 */       buf.append("destinationId").append("=").append(getDestinationId()).append(" ");
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
/* 195 */     if (getDescription() != null) {
/* 196 */       buf.append("description").append("=").append(getDescription()).append(" ");
/*     */     }
/* 198 */     if (getSortOrder() != null) {
/* 199 */       buf.append("sortOrder").append("=").append(getSortOrder()).append(" ");
/*     */     }
/*     */     
/* 202 */     return buf.toString();
/*     */   }
/*     */   
/*     */   public IObjectId getObjectId() {
/* 206 */     InventoryValidDestinationsId id = new InventoryValidDestinationsId();
/* 207 */     id.setOrganizationId(getOrganizationId());
/* 208 */     id.setRetailLocationId(getRetailLocationId());
/* 209 */     id.setDocumentTypeCode(getDocumentTypeCode());
/* 210 */     id.setDocumentSubtypeCode(getDocumentSubtypeCode());
/* 211 */     id.setDestinationTypeEnum(getDestinationTypeEnum());
/* 212 */     id.setDestinationId(getDestinationId());
/* 213 */     return (IObjectId)id;
/*     */   }
/*     */   
/*     */   public void setObjectId(IObjectId argObjectId) {
/* 217 */     setOrganizationId(((InventoryValidDestinationsId)argObjectId).getOrganizationId());
/* 218 */     setRetailLocationId(((InventoryValidDestinationsId)argObjectId).getRetailLocationId());
/* 219 */     setDocumentTypeCode(((InventoryValidDestinationsId)argObjectId).getDocumentTypeCode());
/* 220 */     setDocumentSubtypeCode(((InventoryValidDestinationsId)argObjectId).getDocumentSubtypeCode());
/* 221 */     setDestinationTypeEnum(((InventoryValidDestinationsId)argObjectId).getDestinationTypeEnum());
/* 222 */     setDestinationId(((InventoryValidDestinationsId)argObjectId).getDestinationId());
/*     */   }
/*     */   
/*     */   public String getImplementingClass() {
/* 226 */     return null;
/*     */   }
/*     */   
/*     */   public String toXmlString() {
/* 230 */     StringBuilder buf = new StringBuilder(600);
/* 231 */     buf.append("<").append("dao").append(" name=\"InventoryValidDestinations\" cmd=\"" + getObjectStateString() + "\">");
/* 232 */     getFieldsAsXml(buf);
/* 233 */     buf.append("</").append("dao").append(">");
/*     */     
/* 235 */     return buf.toString();
/*     */   }
/*     */   
/*     */   public Map<String, String> getValues() {
/* 239 */     Map<String, String> values = super.getValues();
/* 240 */     if (this._organizationId != null) values.put("OrganizationId", DaoUtils.getXmlSafeFieldValue(-5, this._organizationId)); 
/* 241 */     if (this._retailLocationId != null) values.put("RetailLocationId", DaoUtils.getXmlSafeFieldValue(-5, this._retailLocationId)); 
/* 242 */     if (this._documentTypeCode != null) values.put("DocumentTypeCode", DaoUtils.getXmlSafeFieldValue(12, this._documentTypeCode)); 
/* 243 */     if (this._documentSubtypeCode != null) values.put("DocumentSubtypeCode", DaoUtils.getXmlSafeFieldValue(12, this._documentSubtypeCode)); 
/* 244 */     if (this._destinationTypeEnum != null) values.put("DestinationTypeEnum", DaoUtils.getXmlSafeFieldValue(12, this._destinationTypeEnum)); 
/* 245 */     if (this._destinationId != null) values.put("DestinationId", DaoUtils.getXmlSafeFieldValue(12, this._destinationId)); 
/* 246 */     if (this._createDate != null) values.put("CreateDate", DaoUtils.getXmlSafeFieldValue(91, this._createDate)); 
/* 247 */     if (this._createUserId != null) values.put("CreateUserId", DaoUtils.getXmlSafeFieldValue(12, this._createUserId)); 
/* 248 */     if (this._updateDate != null) values.put("UpdateDate", DaoUtils.getXmlSafeFieldValue(91, this._updateDate)); 
/* 249 */     if (this._updateUserId != null) values.put("UpdateUserId", DaoUtils.getXmlSafeFieldValue(12, this._updateUserId)); 
/* 250 */     if (this._description != null) values.put("Description", DaoUtils.getXmlSafeFieldValue(12, this._description)); 
/* 251 */     if (this._sortOrder != null) values.put("SortOrder", DaoUtils.getXmlSafeFieldValue(4, this._sortOrder)); 
/* 252 */     return values;
/*     */   }
/*     */ 
/*     */   
/*     */   public void setValues(Map<String, String> argValues) {
/* 257 */     super.setValues(argValues);
/* 258 */     for (Map.Entry<String, String> field : argValues.entrySet()) {
/*     */       
/* 260 */       String fieldName = field.getKey();
/* 261 */       String fieldValue = field.getValue();
/* 262 */       switch (fieldName) {
/*     */         
/*     */         case "OrganizationId":
/*     */           try {
/* 266 */             Object value = DaoUtils.getFieldValueForXmlString(-5, fieldValue);
/* 267 */             setOrganizationId((Long)value);
/* 268 */           } catch (Exception ee) {
/* 269 */             throw new DtxException("An exception occurred while calling setOrganizationId() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "RetailLocationId":
/*     */           try {
/* 275 */             Object value = DaoUtils.getFieldValueForXmlString(-5, fieldValue);
/* 276 */             setRetailLocationId((Long)value);
/* 277 */           } catch (Exception ee) {
/* 278 */             throw new DtxException("An exception occurred while calling setRetailLocationId() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "DocumentTypeCode":
/*     */           try {
/* 284 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 285 */             setDocumentTypeCode((String)value);
/* 286 */           } catch (Exception ee) {
/* 287 */             throw new DtxException("An exception occurred while calling setDocumentTypeCode() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "DocumentSubtypeCode":
/*     */           try {
/* 293 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 294 */             setDocumentSubtypeCode((String)value);
/* 295 */           } catch (Exception ee) {
/* 296 */             throw new DtxException("An exception occurred while calling setDocumentSubtypeCode() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "DestinationTypeEnum":
/*     */           try {
/* 302 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 303 */             setDestinationTypeEnum((String)value);
/* 304 */           } catch (Exception ee) {
/* 305 */             throw new DtxException("An exception occurred while calling setDestinationTypeEnum() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "DestinationId":
/*     */           try {
/* 311 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 312 */             setDestinationId((String)value);
/* 313 */           } catch (Exception ee) {
/* 314 */             throw new DtxException("An exception occurred while calling setDestinationId() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
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
/*     */         case "Description":
/*     */           try {
/* 356 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 357 */             setDescription((String)value);
/* 358 */           } catch (Exception ee) {
/* 359 */             throw new DtxException("An exception occurred while calling setDescription() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
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
/*     */       } 
/*     */     } 
/*     */   }
/*     */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\inv\impl\InventoryValidDestinationsDAO.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */