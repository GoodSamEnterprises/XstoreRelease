/*     */ package dtv.xst.dao.inv.impl;
/*     */ 
/*     */ import dtv.data2.access.DaoUtils;
/*     */ import dtv.data2.access.IObjectId;
/*     */ import dtv.data2.access.exception.DtxException;
/*     */ import dtv.data2.access.impl.AbstractDAOImpl;
/*     */ import dtv.util.DtvDate;
/*     */ import dtv.xst.dao.inv.InventoryCountId;
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
/*     */ public class InventoryCountDAO
/*     */   extends AbstractDAOImpl
/*     */ {
/*     */   private static final long serialVersionUID = -1061122765L;
/*  23 */   private static final Logger _logger = Logger.getLogger(InventoryCountDAO.class);
/*     */   
/*     */   private Long _organizationId;
/*     */   private Long _retailLocationId;
/*     */   private String _inventoryCountId;
/*     */   private DtvDate _createDate;
/*     */   private String _createUserId;
/*     */   private DtvDate _updateDate;
/*     */   private String _updateUserId;
/*     */   private String _description;
/*     */   private String _typeCode;
/*     */   private DtvDate _beginDate;
/*     */   private DtvDate _endDate;
/*     */   private String _countStatus;
/*  37 */   private Boolean _storeCreated = Boolean.FALSE;
/*  38 */   private Boolean _void = Boolean.FALSE;
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
/*     */   public Long getRetailLocationId() {
/*  51 */     return this._retailLocationId;
/*     */   }
/*     */   
/*     */   public void setRetailLocationId(Long argRetailLocationId) {
/*  55 */     if (changed(argRetailLocationId, this._retailLocationId, "retailLocationId")) {
/*  56 */       this._retailLocationId = argRetailLocationId;
/*     */     }
/*     */   }
/*     */   
/*     */   public String getInventoryCountId() {
/*  61 */     return this._inventoryCountId;
/*     */   }
/*     */   
/*     */   public void setInventoryCountId(String argInventoryCountId) {
/*  65 */     if (changed(argInventoryCountId, this._inventoryCountId, "inventoryCountId")) {
/*  66 */       this._inventoryCountId = (argInventoryCountId != null && MANAGE_CASE) ? argInventoryCountId.toUpperCase() : argInventoryCountId;
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
/*     */   public String getDescription() {
/* 113 */     return this._description;
/*     */   }
/*     */   
/*     */   public void setDescription(String argDescription) {
/* 117 */     if (changed(argDescription, this._description, "description")) {
/* 118 */       this._description = argDescription;
/*     */     }
/*     */   }
/*     */   
/*     */   public String getTypeCode() {
/* 123 */     return this._typeCode;
/*     */   }
/*     */   
/*     */   public void setTypeCode(String argTypeCode) {
/* 127 */     if (changed(argTypeCode, this._typeCode, "typeCode")) {
/* 128 */       this._typeCode = argTypeCode;
/*     */     }
/*     */   }
/*     */   
/*     */   public Date getBeginDate() {
/* 133 */     return (Date)this._beginDate;
/*     */   }
/*     */   
/*     */   public void setBeginDate(Date argBeginDate) {
/* 137 */     if (changed(argBeginDate, this._beginDate, "beginDate")) {
/* 138 */       this._beginDate = (argBeginDate == null || argBeginDate instanceof DtvDate) ? (DtvDate)argBeginDate : new DtvDate(argBeginDate);
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public Date getEndDate() {
/* 144 */     return (Date)this._endDate;
/*     */   }
/*     */   
/*     */   public void setEndDate(Date argEndDate) {
/* 148 */     if (changed(argEndDate, this._endDate, "endDate")) {
/* 149 */       this._endDate = (argEndDate == null || argEndDate instanceof DtvDate) ? (DtvDate)argEndDate : new DtvDate(argEndDate);
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public String getCountStatus() {
/* 155 */     return this._countStatus;
/*     */   }
/*     */   
/*     */   public void setCountStatus(String argCountStatus) {
/* 159 */     if (changed(argCountStatus, this._countStatus, "countStatus")) {
/* 160 */       this._countStatus = argCountStatus;
/*     */     }
/*     */   }
/*     */   
/*     */   public Boolean getStoreCreated() {
/* 165 */     return this._storeCreated;
/*     */   }
/*     */   
/*     */   public void setStoreCreated(Boolean argStoreCreated) {
/* 169 */     if (changed(argStoreCreated, this._storeCreated, "storeCreated")) {
/* 170 */       this._storeCreated = argStoreCreated;
/*     */     }
/*     */   }
/*     */   
/*     */   public Boolean getVoid() {
/* 175 */     return this._void;
/*     */   }
/*     */   
/*     */   public void setVoid(Boolean argVoid) {
/* 179 */     if (changed(argVoid, this._void, "void")) {
/* 180 */       this._void = argVoid;
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public String toString() {
/* 187 */     StringBuilder buf = new StringBuilder(512);
/* 188 */     buf.append(super.toString()).append(" Id: ").append(getObjectId()).append(" Values: ");
/* 189 */     if (getOrganizationId() != null) {
/* 190 */       buf.append("organizationId").append("=").append(getOrganizationId()).append(" ");
/*     */     }
/* 192 */     if (getRetailLocationId() != null) {
/* 193 */       buf.append("retailLocationId").append("=").append(getRetailLocationId()).append(" ");
/*     */     }
/* 195 */     if (getInventoryCountId() != null) {
/* 196 */       buf.append("inventoryCountId").append("=").append(getInventoryCountId()).append(" ");
/*     */     }
/* 198 */     if (getCreateDate() != null) {
/* 199 */       buf.append("createDate").append("=").append(getCreateDate()).append(" ");
/*     */     }
/* 201 */     if (getCreateUserId() != null) {
/* 202 */       buf.append("createUserId").append("=").append(getCreateUserId()).append(" ");
/*     */     }
/* 204 */     if (getUpdateDate() != null) {
/* 205 */       buf.append("updateDate").append("=").append(getUpdateDate()).append(" ");
/*     */     }
/* 207 */     if (getUpdateUserId() != null) {
/* 208 */       buf.append("updateUserId").append("=").append(getUpdateUserId()).append(" ");
/*     */     }
/* 210 */     if (getDescription() != null) {
/* 211 */       buf.append("description").append("=").append(getDescription()).append(" ");
/*     */     }
/* 213 */     if (getTypeCode() != null) {
/* 214 */       buf.append("typeCode").append("=").append(getTypeCode()).append(" ");
/*     */     }
/* 216 */     if (getBeginDate() != null) {
/* 217 */       buf.append("beginDate").append("=").append(getBeginDate()).append(" ");
/*     */     }
/* 219 */     if (getEndDate() != null) {
/* 220 */       buf.append("endDate").append("=").append(getEndDate()).append(" ");
/*     */     }
/* 222 */     if (getCountStatus() != null) {
/* 223 */       buf.append("countStatus").append("=").append(getCountStatus()).append(" ");
/*     */     }
/* 225 */     if (getStoreCreated() != null && getStoreCreated().booleanValue()) {
/* 226 */       buf.append("storeCreated").append("=").append(getStoreCreated()).append(" ");
/*     */     }
/* 228 */     if (getVoid() != null && getVoid().booleanValue()) {
/* 229 */       buf.append("void").append("=").append(getVoid()).append(" ");
/*     */     }
/*     */     
/* 232 */     return buf.toString();
/*     */   }
/*     */   
/*     */   public IObjectId getObjectId() {
/* 236 */     InventoryCountId id = new InventoryCountId();
/* 237 */     id.setOrganizationId(getOrganizationId());
/* 238 */     id.setRetailLocationId(getRetailLocationId());
/* 239 */     id.setInventoryCountId(getInventoryCountId());
/* 240 */     return (IObjectId)id;
/*     */   }
/*     */   
/*     */   public void setObjectId(IObjectId argObjectId) {
/* 244 */     setOrganizationId(((InventoryCountId)argObjectId).getOrganizationId());
/* 245 */     setRetailLocationId(((InventoryCountId)argObjectId).getRetailLocationId());
/* 246 */     setInventoryCountId(((InventoryCountId)argObjectId).getInventoryCountId());
/*     */   }
/*     */   
/*     */   public String getImplementingClass() {
/* 250 */     return null;
/*     */   }
/*     */   
/*     */   public String toXmlString() {
/* 254 */     StringBuilder buf = new StringBuilder(700);
/* 255 */     buf.append("<").append("dao").append(" name=\"InventoryCount\" cmd=\"" + getObjectStateString() + "\">");
/* 256 */     getFieldsAsXml(buf);
/* 257 */     buf.append("</").append("dao").append(">");
/*     */     
/* 259 */     return buf.toString();
/*     */   }
/*     */   
/*     */   public Map<String, String> getValues() {
/* 263 */     Map<String, String> values = super.getValues();
/* 264 */     if (this._organizationId != null) values.put("OrganizationId", DaoUtils.getXmlSafeFieldValue(-5, this._organizationId)); 
/* 265 */     if (this._retailLocationId != null) values.put("RetailLocationId", DaoUtils.getXmlSafeFieldValue(-5, this._retailLocationId)); 
/* 266 */     if (this._inventoryCountId != null) values.put("InventoryCountId", DaoUtils.getXmlSafeFieldValue(12, this._inventoryCountId)); 
/* 267 */     if (this._createDate != null) values.put("CreateDate", DaoUtils.getXmlSafeFieldValue(91, this._createDate)); 
/* 268 */     if (this._createUserId != null) values.put("CreateUserId", DaoUtils.getXmlSafeFieldValue(12, this._createUserId)); 
/* 269 */     if (this._updateDate != null) values.put("UpdateDate", DaoUtils.getXmlSafeFieldValue(91, this._updateDate)); 
/* 270 */     if (this._updateUserId != null) values.put("UpdateUserId", DaoUtils.getXmlSafeFieldValue(12, this._updateUserId)); 
/* 271 */     if (this._description != null) values.put("Description", DaoUtils.getXmlSafeFieldValue(12, this._description)); 
/* 272 */     if (this._typeCode != null) values.put("TypeCode", DaoUtils.getXmlSafeFieldValue(12, this._typeCode)); 
/* 273 */     if (this._beginDate != null) values.put("BeginDate", DaoUtils.getXmlSafeFieldValue(91, this._beginDate)); 
/* 274 */     if (this._endDate != null) values.put("EndDate", DaoUtils.getXmlSafeFieldValue(91, this._endDate)); 
/* 275 */     if (this._countStatus != null) values.put("CountStatus", DaoUtils.getXmlSafeFieldValue(12, this._countStatus)); 
/* 276 */     if (this._storeCreated != null) values.put("StoreCreated", DaoUtils.getXmlSafeFieldValue(-7, this._storeCreated)); 
/* 277 */     if (this._void != null) values.put("Void", DaoUtils.getXmlSafeFieldValue(-7, this._void)); 
/* 278 */     return values;
/*     */   }
/*     */ 
/*     */   
/*     */   public void setValues(Map<String, String> argValues) {
/* 283 */     super.setValues(argValues);
/* 284 */     for (Map.Entry<String, String> field : argValues.entrySet()) {
/*     */       
/* 286 */       String fieldName = field.getKey();
/* 287 */       String fieldValue = field.getValue();
/* 288 */       switch (fieldName) {
/*     */         
/*     */         case "OrganizationId":
/*     */           try {
/* 292 */             Object value = DaoUtils.getFieldValueForXmlString(-5, fieldValue);
/* 293 */             setOrganizationId((Long)value);
/* 294 */           } catch (Exception ee) {
/* 295 */             throw new DtxException("An exception occurred while calling setOrganizationId() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "RetailLocationId":
/*     */           try {
/* 301 */             Object value = DaoUtils.getFieldValueForXmlString(-5, fieldValue);
/* 302 */             setRetailLocationId((Long)value);
/* 303 */           } catch (Exception ee) {
/* 304 */             throw new DtxException("An exception occurred while calling setRetailLocationId() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "InventoryCountId":
/*     */           try {
/* 310 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 311 */             setInventoryCountId((String)value);
/* 312 */           } catch (Exception ee) {
/* 313 */             throw new DtxException("An exception occurred while calling setInventoryCountId() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "CreateDate":
/*     */           try {
/* 319 */             Object value = DaoUtils.getFieldValueForXmlString(91, fieldValue);
/* 320 */             setCreateDate((Date)value);
/* 321 */           } catch (Exception ee) {
/* 322 */             throw new DtxException("An exception occurred while calling setCreateDate() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "CreateUserId":
/*     */           try {
/* 328 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 329 */             setCreateUserId((String)value);
/* 330 */           } catch (Exception ee) {
/* 331 */             throw new DtxException("An exception occurred while calling setCreateUserId() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "UpdateDate":
/*     */           try {
/* 337 */             Object value = DaoUtils.getFieldValueForXmlString(91, fieldValue);
/* 338 */             setUpdateDate((Date)value);
/* 339 */           } catch (Exception ee) {
/* 340 */             throw new DtxException("An exception occurred while calling setUpdateDate() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "UpdateUserId":
/*     */           try {
/* 346 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 347 */             setUpdateUserId((String)value);
/* 348 */           } catch (Exception ee) {
/* 349 */             throw new DtxException("An exception occurred while calling setUpdateUserId() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "Description":
/*     */           try {
/* 355 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 356 */             setDescription((String)value);
/* 357 */           } catch (Exception ee) {
/* 358 */             throw new DtxException("An exception occurred while calling setDescription() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "TypeCode":
/*     */           try {
/* 364 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 365 */             setTypeCode((String)value);
/* 366 */           } catch (Exception ee) {
/* 367 */             throw new DtxException("An exception occurred while calling setTypeCode() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "BeginDate":
/*     */           try {
/* 373 */             Object value = DaoUtils.getFieldValueForXmlString(91, fieldValue);
/* 374 */             setBeginDate((Date)value);
/* 375 */           } catch (Exception ee) {
/* 376 */             throw new DtxException("An exception occurred while calling setBeginDate() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "EndDate":
/*     */           try {
/* 382 */             Object value = DaoUtils.getFieldValueForXmlString(91, fieldValue);
/* 383 */             setEndDate((Date)value);
/* 384 */           } catch (Exception ee) {
/* 385 */             throw new DtxException("An exception occurred while calling setEndDate() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "CountStatus":
/*     */           try {
/* 391 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 392 */             setCountStatus((String)value);
/* 393 */           } catch (Exception ee) {
/* 394 */             throw new DtxException("An exception occurred while calling setCountStatus() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "StoreCreated":
/*     */           try {
/* 400 */             Object value = DaoUtils.getFieldValueForXmlString(-7, fieldValue);
/* 401 */             setStoreCreated((Boolean)value);
/* 402 */           } catch (Exception ee) {
/* 403 */             throw new DtxException("An exception occurred while calling setStoreCreated() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "Void":
/*     */           try {
/* 409 */             Object value = DaoUtils.getFieldValueForXmlString(-7, fieldValue);
/* 410 */             setVoid((Boolean)value);
/* 411 */           } catch (Exception ee) {
/* 412 */             throw new DtxException("An exception occurred while calling setVoid() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */       } 
/*     */     } 
/*     */   }
/*     */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\inv\impl\InventoryCountDAO.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */