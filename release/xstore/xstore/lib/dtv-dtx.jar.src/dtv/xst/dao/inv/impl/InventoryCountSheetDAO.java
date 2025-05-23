/*     */ package dtv.xst.dao.inv.impl;
/*     */ 
/*     */ import dtv.data2.access.DaoUtils;
/*     */ import dtv.data2.access.IObjectId;
/*     */ import dtv.data2.access.exception.DtxException;
/*     */ import dtv.data2.access.impl.AbstractDAOImpl;
/*     */ import dtv.util.DtvDate;
/*     */ import dtv.xst.dao.inv.InventoryCountSheetId;
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
/*     */ public class InventoryCountSheetDAO
/*     */   extends AbstractDAOImpl
/*     */ {
/*     */   private static final long serialVersionUID = -1369888788L;
/*  23 */   private static final Logger _logger = Logger.getLogger(InventoryCountSheetDAO.class);
/*     */   
/*     */   private Long _organizationId;
/*     */   private Long _retailLocationId;
/*     */   private String _inventoryCountId;
/*     */   private Integer _countSheetNumber;
/*     */   private DtvDate _createDate;
/*     */   private String _createUserId;
/*     */   private DtvDate _updateDate;
/*     */   private String _updateUserId;
/*     */   private String _inventoryBucketId;
/*     */   private Integer _sectionNumber;
/*     */   private String _sectionId;
/*     */   private Integer _countCycle;
/*     */   private String _sheetStatus;
/*  38 */   private Boolean _checkedOut = Boolean.FALSE;
/*     */   private String _inventoryBucketName;
/*     */   
/*     */   public Long getOrganizationId() {
/*  42 */     return this._organizationId;
/*     */   }
/*     */   
/*     */   public void setOrganizationId(Long argOrganizationId) {
/*  46 */     if (changed(argOrganizationId, this._organizationId, "organizationId")) {
/*  47 */       this._organizationId = argOrganizationId;
/*     */     }
/*     */   }
/*     */   
/*     */   public Long getRetailLocationId() {
/*  52 */     return this._retailLocationId;
/*     */   }
/*     */   
/*     */   public void setRetailLocationId(Long argRetailLocationId) {
/*  56 */     if (changed(argRetailLocationId, this._retailLocationId, "retailLocationId")) {
/*  57 */       this._retailLocationId = argRetailLocationId;
/*     */     }
/*     */   }
/*     */   
/*     */   public String getInventoryCountId() {
/*  62 */     return this._inventoryCountId;
/*     */   }
/*     */   
/*     */   public void setInventoryCountId(String argInventoryCountId) {
/*  66 */     if (changed(argInventoryCountId, this._inventoryCountId, "inventoryCountId")) {
/*  67 */       this._inventoryCountId = (argInventoryCountId != null && MANAGE_CASE) ? argInventoryCountId.toUpperCase() : argInventoryCountId;
/*     */     }
/*     */   }
/*     */   
/*     */   public Integer getCountSheetNumber() {
/*  72 */     return this._countSheetNumber;
/*     */   }
/*     */   
/*     */   public void setCountSheetNumber(Integer argCountSheetNumber) {
/*  76 */     if (changed(argCountSheetNumber, this._countSheetNumber, "countSheetNumber")) {
/*  77 */       this._countSheetNumber = argCountSheetNumber;
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
/*     */   public String getInventoryBucketId() {
/* 124 */     return this._inventoryBucketId;
/*     */   }
/*     */   
/*     */   public void setInventoryBucketId(String argInventoryBucketId) {
/* 128 */     if (changed(argInventoryBucketId, this._inventoryBucketId, "inventoryBucketId")) {
/* 129 */       this._inventoryBucketId = argInventoryBucketId;
/*     */     }
/*     */   }
/*     */   
/*     */   public Integer getSectionNumber() {
/* 134 */     return this._sectionNumber;
/*     */   }
/*     */   
/*     */   public void setSectionNumber(Integer argSectionNumber) {
/* 138 */     if (changed(argSectionNumber, this._sectionNumber, "sectionNumber")) {
/* 139 */       this._sectionNumber = argSectionNumber;
/*     */     }
/*     */   }
/*     */   
/*     */   public String getSectionId() {
/* 144 */     return this._sectionId;
/*     */   }
/*     */   
/*     */   public void setSectionId(String argSectionId) {
/* 148 */     if (changed(argSectionId, this._sectionId, "sectionId")) {
/* 149 */       this._sectionId = argSectionId;
/*     */     }
/*     */   }
/*     */   
/*     */   public Integer getCountCycle() {
/* 154 */     return this._countCycle;
/*     */   }
/*     */   
/*     */   public void setCountCycle(Integer argCountCycle) {
/* 158 */     if (changed(argCountCycle, this._countCycle, "countCycle")) {
/* 159 */       this._countCycle = argCountCycle;
/*     */     }
/*     */   }
/*     */   
/*     */   public String getSheetStatus() {
/* 164 */     return this._sheetStatus;
/*     */   }
/*     */   
/*     */   public void setSheetStatus(String argSheetStatus) {
/* 168 */     if (changed(argSheetStatus, this._sheetStatus, "sheetStatus")) {
/* 169 */       this._sheetStatus = argSheetStatus;
/*     */     }
/*     */   }
/*     */   
/*     */   public Boolean getCheckedOut() {
/* 174 */     return this._checkedOut;
/*     */   }
/*     */   
/*     */   public void setCheckedOut(Boolean argCheckedOut) {
/* 178 */     if (changed(argCheckedOut, this._checkedOut, "checkedOut")) {
/* 179 */       this._checkedOut = argCheckedOut;
/*     */     }
/*     */   }
/*     */   
/*     */   public String getInventoryBucketName() {
/* 184 */     return this._inventoryBucketName;
/*     */   }
/*     */   
/*     */   public void setInventoryBucketName(String argInventoryBucketName) {
/* 188 */     if (changed(argInventoryBucketName, this._inventoryBucketName, "inventoryBucketName")) {
/* 189 */       this._inventoryBucketName = argInventoryBucketName;
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public String toString() {
/* 196 */     StringBuilder buf = new StringBuilder(512);
/* 197 */     buf.append(super.toString()).append(" Id: ").append(getObjectId()).append(" Values: ");
/* 198 */     if (getOrganizationId() != null) {
/* 199 */       buf.append("organizationId").append("=").append(getOrganizationId()).append(" ");
/*     */     }
/* 201 */     if (getRetailLocationId() != null) {
/* 202 */       buf.append("retailLocationId").append("=").append(getRetailLocationId()).append(" ");
/*     */     }
/* 204 */     if (getInventoryCountId() != null) {
/* 205 */       buf.append("inventoryCountId").append("=").append(getInventoryCountId()).append(" ");
/*     */     }
/* 207 */     if (getCountSheetNumber() != null) {
/* 208 */       buf.append("countSheetNumber").append("=").append(getCountSheetNumber()).append(" ");
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
/* 222 */     if (getInventoryBucketId() != null) {
/* 223 */       buf.append("inventoryBucketId").append("=").append(getInventoryBucketId()).append(" ");
/*     */     }
/* 225 */     if (getSectionNumber() != null) {
/* 226 */       buf.append("sectionNumber").append("=").append(getSectionNumber()).append(" ");
/*     */     }
/* 228 */     if (getSectionId() != null) {
/* 229 */       buf.append("sectionId").append("=").append(getSectionId()).append(" ");
/*     */     }
/* 231 */     if (getCountCycle() != null) {
/* 232 */       buf.append("countCycle").append("=").append(getCountCycle()).append(" ");
/*     */     }
/* 234 */     if (getSheetStatus() != null) {
/* 235 */       buf.append("sheetStatus").append("=").append(getSheetStatus()).append(" ");
/*     */     }
/* 237 */     if (getCheckedOut() != null && getCheckedOut().booleanValue()) {
/* 238 */       buf.append("checkedOut").append("=").append(getCheckedOut()).append(" ");
/*     */     }
/* 240 */     if (getInventoryBucketName() != null) {
/* 241 */       buf.append("inventoryBucketName").append("=").append(getInventoryBucketName()).append(" ");
/*     */     }
/*     */     
/* 244 */     return buf.toString();
/*     */   }
/*     */   
/*     */   public IObjectId getObjectId() {
/* 248 */     InventoryCountSheetId id = new InventoryCountSheetId();
/* 249 */     id.setOrganizationId(getOrganizationId());
/* 250 */     id.setRetailLocationId(getRetailLocationId());
/* 251 */     id.setInventoryCountId(getInventoryCountId());
/* 252 */     id.setCountSheetNumber(getCountSheetNumber());
/* 253 */     return (IObjectId)id;
/*     */   }
/*     */   
/*     */   public void setObjectId(IObjectId argObjectId) {
/* 257 */     setOrganizationId(((InventoryCountSheetId)argObjectId).getOrganizationId());
/* 258 */     setRetailLocationId(((InventoryCountSheetId)argObjectId).getRetailLocationId());
/* 259 */     setInventoryCountId(((InventoryCountSheetId)argObjectId).getInventoryCountId());
/* 260 */     setCountSheetNumber(((InventoryCountSheetId)argObjectId).getCountSheetNumber());
/*     */   }
/*     */   
/*     */   public String getImplementingClass() {
/* 264 */     return null;
/*     */   }
/*     */   
/*     */   public String toXmlString() {
/* 268 */     StringBuilder buf = new StringBuilder(750);
/* 269 */     buf.append("<").append("dao").append(" name=\"InventoryCountSheet\" cmd=\"" + getObjectStateString() + "\">");
/* 270 */     getFieldsAsXml(buf);
/* 271 */     buf.append("</").append("dao").append(">");
/*     */     
/* 273 */     return buf.toString();
/*     */   }
/*     */   
/*     */   public Map<String, String> getValues() {
/* 277 */     Map<String, String> values = super.getValues();
/* 278 */     if (this._organizationId != null) values.put("OrganizationId", DaoUtils.getXmlSafeFieldValue(-5, this._organizationId)); 
/* 279 */     if (this._retailLocationId != null) values.put("RetailLocationId", DaoUtils.getXmlSafeFieldValue(-5, this._retailLocationId)); 
/* 280 */     if (this._inventoryCountId != null) values.put("InventoryCountId", DaoUtils.getXmlSafeFieldValue(12, this._inventoryCountId)); 
/* 281 */     if (this._countSheetNumber != null) values.put("CountSheetNumber", DaoUtils.getXmlSafeFieldValue(4, this._countSheetNumber)); 
/* 282 */     if (this._createDate != null) values.put("CreateDate", DaoUtils.getXmlSafeFieldValue(91, this._createDate)); 
/* 283 */     if (this._createUserId != null) values.put("CreateUserId", DaoUtils.getXmlSafeFieldValue(12, this._createUserId)); 
/* 284 */     if (this._updateDate != null) values.put("UpdateDate", DaoUtils.getXmlSafeFieldValue(91, this._updateDate)); 
/* 285 */     if (this._updateUserId != null) values.put("UpdateUserId", DaoUtils.getXmlSafeFieldValue(12, this._updateUserId)); 
/* 286 */     if (this._inventoryBucketId != null) values.put("InventoryBucketId", DaoUtils.getXmlSafeFieldValue(12, this._inventoryBucketId)); 
/* 287 */     if (this._sectionNumber != null) values.put("SectionNumber", DaoUtils.getXmlSafeFieldValue(4, this._sectionNumber)); 
/* 288 */     if (this._sectionId != null) values.put("SectionId", DaoUtils.getXmlSafeFieldValue(12, this._sectionId)); 
/* 289 */     if (this._countCycle != null) values.put("CountCycle", DaoUtils.getXmlSafeFieldValue(4, this._countCycle)); 
/* 290 */     if (this._sheetStatus != null) values.put("SheetStatus", DaoUtils.getXmlSafeFieldValue(12, this._sheetStatus)); 
/* 291 */     if (this._checkedOut != null) values.put("CheckedOut", DaoUtils.getXmlSafeFieldValue(-7, this._checkedOut)); 
/* 292 */     if (this._inventoryBucketName != null) values.put("InventoryBucketName", DaoUtils.getXmlSafeFieldValue(12, this._inventoryBucketName)); 
/* 293 */     return values;
/*     */   }
/*     */ 
/*     */   
/*     */   public void setValues(Map<String, String> argValues) {
/* 298 */     super.setValues(argValues);
/* 299 */     for (Map.Entry<String, String> field : argValues.entrySet()) {
/*     */       
/* 301 */       String fieldName = field.getKey();
/* 302 */       String fieldValue = field.getValue();
/* 303 */       switch (fieldName) {
/*     */         
/*     */         case "OrganizationId":
/*     */           try {
/* 307 */             Object value = DaoUtils.getFieldValueForXmlString(-5, fieldValue);
/* 308 */             setOrganizationId((Long)value);
/* 309 */           } catch (Exception ee) {
/* 310 */             throw new DtxException("An exception occurred while calling setOrganizationId() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "RetailLocationId":
/*     */           try {
/* 316 */             Object value = DaoUtils.getFieldValueForXmlString(-5, fieldValue);
/* 317 */             setRetailLocationId((Long)value);
/* 318 */           } catch (Exception ee) {
/* 319 */             throw new DtxException("An exception occurred while calling setRetailLocationId() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "InventoryCountId":
/*     */           try {
/* 325 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 326 */             setInventoryCountId((String)value);
/* 327 */           } catch (Exception ee) {
/* 328 */             throw new DtxException("An exception occurred while calling setInventoryCountId() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "CountSheetNumber":
/*     */           try {
/* 334 */             Object value = DaoUtils.getFieldValueForXmlString(4, fieldValue);
/* 335 */             setCountSheetNumber((Integer)value);
/* 336 */           } catch (Exception ee) {
/* 337 */             throw new DtxException("An exception occurred while calling setCountSheetNumber() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "CreateDate":
/*     */           try {
/* 343 */             Object value = DaoUtils.getFieldValueForXmlString(91, fieldValue);
/* 344 */             setCreateDate((Date)value);
/* 345 */           } catch (Exception ee) {
/* 346 */             throw new DtxException("An exception occurred while calling setCreateDate() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "CreateUserId":
/*     */           try {
/* 352 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 353 */             setCreateUserId((String)value);
/* 354 */           } catch (Exception ee) {
/* 355 */             throw new DtxException("An exception occurred while calling setCreateUserId() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "UpdateDate":
/*     */           try {
/* 361 */             Object value = DaoUtils.getFieldValueForXmlString(91, fieldValue);
/* 362 */             setUpdateDate((Date)value);
/* 363 */           } catch (Exception ee) {
/* 364 */             throw new DtxException("An exception occurred while calling setUpdateDate() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "UpdateUserId":
/*     */           try {
/* 370 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 371 */             setUpdateUserId((String)value);
/* 372 */           } catch (Exception ee) {
/* 373 */             throw new DtxException("An exception occurred while calling setUpdateUserId() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "InventoryBucketId":
/*     */           try {
/* 379 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 380 */             setInventoryBucketId((String)value);
/* 381 */           } catch (Exception ee) {
/* 382 */             throw new DtxException("An exception occurred while calling setInventoryBucketId() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "SectionNumber":
/*     */           try {
/* 388 */             Object value = DaoUtils.getFieldValueForXmlString(4, fieldValue);
/* 389 */             setSectionNumber((Integer)value);
/* 390 */           } catch (Exception ee) {
/* 391 */             throw new DtxException("An exception occurred while calling setSectionNumber() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "SectionId":
/*     */           try {
/* 397 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 398 */             setSectionId((String)value);
/* 399 */           } catch (Exception ee) {
/* 400 */             throw new DtxException("An exception occurred while calling setSectionId() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "CountCycle":
/*     */           try {
/* 406 */             Object value = DaoUtils.getFieldValueForXmlString(4, fieldValue);
/* 407 */             setCountCycle((Integer)value);
/* 408 */           } catch (Exception ee) {
/* 409 */             throw new DtxException("An exception occurred while calling setCountCycle() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "SheetStatus":
/*     */           try {
/* 415 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 416 */             setSheetStatus((String)value);
/* 417 */           } catch (Exception ee) {
/* 418 */             throw new DtxException("An exception occurred while calling setSheetStatus() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "CheckedOut":
/*     */           try {
/* 424 */             Object value = DaoUtils.getFieldValueForXmlString(-7, fieldValue);
/* 425 */             setCheckedOut((Boolean)value);
/* 426 */           } catch (Exception ee) {
/* 427 */             throw new DtxException("An exception occurred while calling setCheckedOut() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "InventoryBucketName":
/*     */           try {
/* 433 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 434 */             setInventoryBucketName((String)value);
/* 435 */           } catch (Exception ee) {
/* 436 */             throw new DtxException("An exception occurred while calling setInventoryBucketName() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */       } 
/*     */     } 
/*     */   }
/*     */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\inv\impl\InventoryCountSheetDAO.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */