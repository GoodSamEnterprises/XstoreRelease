/*     */ package dtv.xst.dao.itm.impl;
/*     */ 
/*     */ import dtv.data2.access.DaoUtils;
/*     */ import dtv.data2.access.IObjectId;
/*     */ import dtv.data2.access.exception.DtxException;
/*     */ import dtv.data2.access.impl.AbstractDAOImpl;
/*     */ import dtv.util.DtvDate;
/*     */ import dtv.xst.dao.itm.KitComponentId;
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
/*     */ public class KitComponentDAO
/*     */   extends AbstractDAOImpl
/*     */ {
/*     */   private static final long serialVersionUID = 673268455L;
/*  23 */   private static final Logger _logger = Logger.getLogger(KitComponentDAO.class);
/*     */   
/*     */   private Long _organizationId;
/*     */   private String _kitItemId;
/*     */   private String _componentItemId;
/*     */   private Long _sequenceNumber;
/*     */   private DtvDate _createDate;
/*     */   private String _createUserId;
/*     */   private DtvDate _updateDate;
/*     */   private String _updateUserId;
/*     */   private String _orgCode;
/*     */   private String _orgValue;
/*     */   private Integer _displayOrder;
/*     */   private Integer _quantityPerKit;
/*     */   private DtvDate _beginDatetime;
/*     */   private DtvDate _endDatetime;
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
/*     */   public String getKitItemId() {
/*  51 */     return this._kitItemId;
/*     */   }
/*     */   
/*     */   public void setKitItemId(String argKitItemId) {
/*  55 */     if (changed(argKitItemId, this._kitItemId, "kitItemId")) {
/*  56 */       this._kitItemId = (argKitItemId != null && MANAGE_CASE) ? argKitItemId.toUpperCase() : argKitItemId;
/*     */     }
/*     */   }
/*     */   
/*     */   public String getComponentItemId() {
/*  61 */     return this._componentItemId;
/*     */   }
/*     */   
/*     */   public void setComponentItemId(String argComponentItemId) {
/*  65 */     if (changed(argComponentItemId, this._componentItemId, "componentItemId")) {
/*  66 */       this._componentItemId = (argComponentItemId != null && MANAGE_CASE) ? argComponentItemId.toUpperCase() : argComponentItemId;
/*     */     }
/*     */   }
/*     */   
/*     */   public Long getSequenceNumber() {
/*  71 */     return this._sequenceNumber;
/*     */   }
/*     */   
/*     */   public void setSequenceNumber(Long argSequenceNumber) {
/*  75 */     if (changed(argSequenceNumber, this._sequenceNumber, "sequenceNumber")) {
/*  76 */       this._sequenceNumber = argSequenceNumber;
/*     */     }
/*     */   }
/*     */   
/*     */   public Date getCreateDate() {
/*  81 */     return (Date)this._createDate;
/*     */   }
/*     */   
/*     */   public void setCreateDate(Date argCreateDate) {
/*  85 */     if (changed(argCreateDate, this._createDate, "createDate")) {
/*  86 */       this._createDate = (argCreateDate == null || argCreateDate instanceof DtvDate) ? (DtvDate)argCreateDate : new DtvDate(argCreateDate);
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public String getCreateUserId() {
/*  92 */     return this._createUserId;
/*     */   }
/*     */   
/*     */   public void setCreateUserId(String argCreateUserId) {
/*  96 */     if (changed(argCreateUserId, this._createUserId, "createUserId")) {
/*  97 */       this._createUserId = argCreateUserId;
/*     */     }
/*     */   }
/*     */   
/*     */   public Date getUpdateDate() {
/* 102 */     return (Date)this._updateDate;
/*     */   }
/*     */   
/*     */   public void setUpdateDate(Date argUpdateDate) {
/* 106 */     if (changed(argUpdateDate, this._updateDate, "updateDate")) {
/* 107 */       this._updateDate = (argUpdateDate == null || argUpdateDate instanceof DtvDate) ? (DtvDate)argUpdateDate : new DtvDate(argUpdateDate);
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public String getUpdateUserId() {
/* 113 */     return this._updateUserId;
/*     */   }
/*     */   
/*     */   public void setUpdateUserId(String argUpdateUserId) {
/* 117 */     if (changed(argUpdateUserId, this._updateUserId, "updateUserId")) {
/* 118 */       this._updateUserId = argUpdateUserId;
/*     */     }
/*     */   }
/*     */   
/*     */   public String getOrgCode() {
/* 123 */     return this._orgCode;
/*     */   }
/*     */   
/*     */   public void setOrgCode(String argOrgCode) {
/* 127 */     if (changed(argOrgCode, this._orgCode, "orgCode")) {
/* 128 */       this._orgCode = argOrgCode;
/*     */     }
/*     */   }
/*     */   
/*     */   public String getOrgValue() {
/* 133 */     return this._orgValue;
/*     */   }
/*     */   
/*     */   public void setOrgValue(String argOrgValue) {
/* 137 */     if (changed(argOrgValue, this._orgValue, "orgValue")) {
/* 138 */       this._orgValue = argOrgValue;
/*     */     }
/*     */   }
/*     */   
/*     */   public Integer getDisplayOrder() {
/* 143 */     return this._displayOrder;
/*     */   }
/*     */   
/*     */   public void setDisplayOrder(Integer argDisplayOrder) {
/* 147 */     if (changed(argDisplayOrder, this._displayOrder, "displayOrder")) {
/* 148 */       this._displayOrder = argDisplayOrder;
/*     */     }
/*     */   }
/*     */   
/*     */   public Integer getQuantityPerKit() {
/* 153 */     return this._quantityPerKit;
/*     */   }
/*     */   
/*     */   public void setQuantityPerKit(Integer argQuantityPerKit) {
/* 157 */     if (changed(argQuantityPerKit, this._quantityPerKit, "quantityPerKit")) {
/* 158 */       this._quantityPerKit = argQuantityPerKit;
/*     */     }
/*     */   }
/*     */   
/*     */   public Date getBeginDatetime() {
/* 163 */     return (Date)this._beginDatetime;
/*     */   }
/*     */   
/*     */   public void setBeginDatetime(Date argBeginDatetime) {
/* 167 */     if (changed(argBeginDatetime, this._beginDatetime, "beginDatetime")) {
/* 168 */       this._beginDatetime = (argBeginDatetime == null || argBeginDatetime instanceof DtvDate) ? (DtvDate)argBeginDatetime : new DtvDate(argBeginDatetime);
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public Date getEndDatetime() {
/* 174 */     return (Date)this._endDatetime;
/*     */   }
/*     */   
/*     */   public void setEndDatetime(Date argEndDatetime) {
/* 178 */     if (changed(argEndDatetime, this._endDatetime, "endDatetime")) {
/* 179 */       this._endDatetime = (argEndDatetime == null || argEndDatetime instanceof DtvDate) ? (DtvDate)argEndDatetime : new DtvDate(argEndDatetime);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String toString() {
/* 187 */     StringBuilder buf = new StringBuilder(512);
/* 188 */     buf.append(super.toString()).append(" Id: ").append(getObjectId()).append(" Values: ");
/* 189 */     if (getOrganizationId() != null) {
/* 190 */       buf.append("organizationId").append("=").append(getOrganizationId()).append(" ");
/*     */     }
/* 192 */     if (getKitItemId() != null) {
/* 193 */       buf.append("kitItemId").append("=").append(getKitItemId()).append(" ");
/*     */     }
/* 195 */     if (getComponentItemId() != null) {
/* 196 */       buf.append("componentItemId").append("=").append(getComponentItemId()).append(" ");
/*     */     }
/* 198 */     if (getSequenceNumber() != null) {
/* 199 */       buf.append("sequenceNumber").append("=").append(getSequenceNumber()).append(" ");
/*     */     }
/* 201 */     if (getCreateDate() != null) {
/* 202 */       buf.append("createDate").append("=").append(getCreateDate()).append(" ");
/*     */     }
/* 204 */     if (getCreateUserId() != null) {
/* 205 */       buf.append("createUserId").append("=").append(getCreateUserId()).append(" ");
/*     */     }
/* 207 */     if (getUpdateDate() != null) {
/* 208 */       buf.append("updateDate").append("=").append(getUpdateDate()).append(" ");
/*     */     }
/* 210 */     if (getUpdateUserId() != null) {
/* 211 */       buf.append("updateUserId").append("=").append(getUpdateUserId()).append(" ");
/*     */     }
/* 213 */     if (getOrgCode() != null) {
/* 214 */       buf.append("orgCode").append("=").append(getOrgCode()).append(" ");
/*     */     }
/* 216 */     if (getOrgValue() != null) {
/* 217 */       buf.append("orgValue").append("=").append(getOrgValue()).append(" ");
/*     */     }
/* 219 */     if (getDisplayOrder() != null) {
/* 220 */       buf.append("displayOrder").append("=").append(getDisplayOrder()).append(" ");
/*     */     }
/* 222 */     if (getQuantityPerKit() != null) {
/* 223 */       buf.append("quantityPerKit").append("=").append(getQuantityPerKit()).append(" ");
/*     */     }
/* 225 */     if (getBeginDatetime() != null) {
/* 226 */       buf.append("beginDatetime").append("=").append(getBeginDatetime()).append(" ");
/*     */     }
/* 228 */     if (getEndDatetime() != null) {
/* 229 */       buf.append("endDatetime").append("=").append(getEndDatetime()).append(" ");
/*     */     }
/*     */     
/* 232 */     return buf.toString();
/*     */   }
/*     */   
/*     */   public IObjectId getObjectId() {
/* 236 */     KitComponentId id = new KitComponentId();
/* 237 */     id.setOrganizationId(getOrganizationId());
/* 238 */     id.setKitItemId(getKitItemId());
/* 239 */     id.setComponentItemId(getComponentItemId());
/* 240 */     id.setSequenceNumber(getSequenceNumber());
/* 241 */     return (IObjectId)id;
/*     */   }
/*     */   
/*     */   public void setObjectId(IObjectId argObjectId) {
/* 245 */     setOrganizationId(((KitComponentId)argObjectId).getOrganizationId());
/* 246 */     setKitItemId(((KitComponentId)argObjectId).getKitItemId());
/* 247 */     setComponentItemId(((KitComponentId)argObjectId).getComponentItemId());
/* 248 */     setSequenceNumber(((KitComponentId)argObjectId).getSequenceNumber());
/*     */   }
/*     */   
/*     */   public String getImplementingClass() {
/* 252 */     return null;
/*     */   }
/*     */   
/*     */   public String toXmlString() {
/* 256 */     StringBuilder buf = new StringBuilder(700);
/* 257 */     buf.append("<").append("dao").append(" name=\"KitComponent\" cmd=\"" + getObjectStateString() + "\">");
/* 258 */     getFieldsAsXml(buf);
/* 259 */     buf.append("</").append("dao").append(">");
/*     */     
/* 261 */     return buf.toString();
/*     */   }
/*     */   
/*     */   public Map<String, String> getValues() {
/* 265 */     Map<String, String> values = super.getValues();
/* 266 */     if (this._organizationId != null) values.put("OrganizationId", DaoUtils.getXmlSafeFieldValue(-5, this._organizationId)); 
/* 267 */     if (this._kitItemId != null) values.put("KitItemId", DaoUtils.getXmlSafeFieldValue(12, this._kitItemId)); 
/* 268 */     if (this._componentItemId != null) values.put("ComponentItemId", DaoUtils.getXmlSafeFieldValue(12, this._componentItemId)); 
/* 269 */     if (this._sequenceNumber != null) values.put("SequenceNumber", DaoUtils.getXmlSafeFieldValue(-5, this._sequenceNumber)); 
/* 270 */     if (this._createDate != null) values.put("CreateDate", DaoUtils.getXmlSafeFieldValue(91, this._createDate)); 
/* 271 */     if (this._createUserId != null) values.put("CreateUserId", DaoUtils.getXmlSafeFieldValue(12, this._createUserId)); 
/* 272 */     if (this._updateDate != null) values.put("UpdateDate", DaoUtils.getXmlSafeFieldValue(91, this._updateDate)); 
/* 273 */     if (this._updateUserId != null) values.put("UpdateUserId", DaoUtils.getXmlSafeFieldValue(12, this._updateUserId)); 
/* 274 */     if (this._orgCode != null) values.put("OrgCode", DaoUtils.getXmlSafeFieldValue(12, this._orgCode)); 
/* 275 */     if (this._orgValue != null) values.put("OrgValue", DaoUtils.getXmlSafeFieldValue(12, this._orgValue)); 
/* 276 */     if (this._displayOrder != null) values.put("DisplayOrder", DaoUtils.getXmlSafeFieldValue(4, this._displayOrder)); 
/* 277 */     if (this._quantityPerKit != null) values.put("QuantityPerKit", DaoUtils.getXmlSafeFieldValue(4, this._quantityPerKit)); 
/* 278 */     if (this._beginDatetime != null) values.put("BeginDatetime", DaoUtils.getXmlSafeFieldValue(91, this._beginDatetime)); 
/* 279 */     if (this._endDatetime != null) values.put("EndDatetime", DaoUtils.getXmlSafeFieldValue(91, this._endDatetime)); 
/* 280 */     return values;
/*     */   }
/*     */ 
/*     */   
/*     */   public void setValues(Map<String, String> argValues) {
/* 285 */     super.setValues(argValues);
/* 286 */     for (Map.Entry<String, String> field : argValues.entrySet()) {
/*     */       
/* 288 */       String fieldName = field.getKey();
/* 289 */       String fieldValue = field.getValue();
/* 290 */       switch (fieldName) {
/*     */         
/*     */         case "OrganizationId":
/*     */           try {
/* 294 */             Object value = DaoUtils.getFieldValueForXmlString(-5, fieldValue);
/* 295 */             setOrganizationId((Long)value);
/* 296 */           } catch (Exception ee) {
/* 297 */             throw new DtxException("An exception occurred while calling setOrganizationId() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "KitItemId":
/*     */           try {
/* 303 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 304 */             setKitItemId((String)value);
/* 305 */           } catch (Exception ee) {
/* 306 */             throw new DtxException("An exception occurred while calling setKitItemId() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "ComponentItemId":
/*     */           try {
/* 312 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 313 */             setComponentItemId((String)value);
/* 314 */           } catch (Exception ee) {
/* 315 */             throw new DtxException("An exception occurred while calling setComponentItemId() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "SequenceNumber":
/*     */           try {
/* 321 */             Object value = DaoUtils.getFieldValueForXmlString(-5, fieldValue);
/* 322 */             setSequenceNumber((Long)value);
/* 323 */           } catch (Exception ee) {
/* 324 */             throw new DtxException("An exception occurred while calling setSequenceNumber() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "CreateDate":
/*     */           try {
/* 330 */             Object value = DaoUtils.getFieldValueForXmlString(91, fieldValue);
/* 331 */             setCreateDate((Date)value);
/* 332 */           } catch (Exception ee) {
/* 333 */             throw new DtxException("An exception occurred while calling setCreateDate() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "CreateUserId":
/*     */           try {
/* 339 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 340 */             setCreateUserId((String)value);
/* 341 */           } catch (Exception ee) {
/* 342 */             throw new DtxException("An exception occurred while calling setCreateUserId() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "UpdateDate":
/*     */           try {
/* 348 */             Object value = DaoUtils.getFieldValueForXmlString(91, fieldValue);
/* 349 */             setUpdateDate((Date)value);
/* 350 */           } catch (Exception ee) {
/* 351 */             throw new DtxException("An exception occurred while calling setUpdateDate() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "UpdateUserId":
/*     */           try {
/* 357 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 358 */             setUpdateUserId((String)value);
/* 359 */           } catch (Exception ee) {
/* 360 */             throw new DtxException("An exception occurred while calling setUpdateUserId() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "OrgCode":
/*     */           try {
/* 366 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 367 */             setOrgCode((String)value);
/* 368 */           } catch (Exception ee) {
/* 369 */             throw new DtxException("An exception occurred while calling setOrgCode() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "OrgValue":
/*     */           try {
/* 375 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 376 */             setOrgValue((String)value);
/* 377 */           } catch (Exception ee) {
/* 378 */             throw new DtxException("An exception occurred while calling setOrgValue() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "DisplayOrder":
/*     */           try {
/* 384 */             Object value = DaoUtils.getFieldValueForXmlString(4, fieldValue);
/* 385 */             setDisplayOrder((Integer)value);
/* 386 */           } catch (Exception ee) {
/* 387 */             throw new DtxException("An exception occurred while calling setDisplayOrder() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "QuantityPerKit":
/*     */           try {
/* 393 */             Object value = DaoUtils.getFieldValueForXmlString(4, fieldValue);
/* 394 */             setQuantityPerKit((Integer)value);
/* 395 */           } catch (Exception ee) {
/* 396 */             throw new DtxException("An exception occurred while calling setQuantityPerKit() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "BeginDatetime":
/*     */           try {
/* 402 */             Object value = DaoUtils.getFieldValueForXmlString(91, fieldValue);
/* 403 */             setBeginDatetime((Date)value);
/* 404 */           } catch (Exception ee) {
/* 405 */             throw new DtxException("An exception occurred while calling setBeginDatetime() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "EndDatetime":
/*     */           try {
/* 411 */             Object value = DaoUtils.getFieldValueForXmlString(91, fieldValue);
/* 412 */             setEndDatetime((Date)value);
/* 413 */           } catch (Exception ee) {
/* 414 */             throw new DtxException("An exception occurred while calling setEndDatetime() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */       } 
/*     */     } 
/*     */   }
/*     */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\itm\impl\KitComponentDAO.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */