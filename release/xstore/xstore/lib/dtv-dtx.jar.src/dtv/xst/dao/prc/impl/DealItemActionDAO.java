/*     */ package dtv.xst.dao.prc.impl;
/*     */ 
/*     */ import dtv.data2.access.DaoUtils;
/*     */ import dtv.data2.access.IObjectId;
/*     */ import dtv.data2.access.exception.DtxException;
/*     */ import dtv.data2.access.impl.AbstractDAOImpl;
/*     */ import dtv.util.DtvDate;
/*     */ import dtv.xst.dao.prc.DealItemActionId;
/*     */ import java.math.BigDecimal;
/*     */ import java.util.Date;
/*     */ import java.util.Map;
/*     */ import org.apache.log4j.Logger;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class DealItemActionDAO
/*     */   extends AbstractDAOImpl
/*     */ {
/*     */   private static final long serialVersionUID = -1580459819L;
/*  23 */   private static final Logger _logger = Logger.getLogger(DealItemActionDAO.class);
/*     */   
/*     */   private Long _organizationId;
/*     */   private String _dealId;
/*     */   private Integer _ordinal;
/*     */   private String _orgCode;
/*     */   private String _orgValue;
/*     */   private DtvDate _createDate;
/*     */   private String _createUserId;
/*     */   private DtvDate _updateDate;
/*     */   private String _updateUserId;
/*  34 */   private Boolean _consumable = Boolean.FALSE;
/*     */   private BigDecimal _minQty;
/*     */   private BigDecimal _maxQty;
/*     */   private BigDecimal _minItemTotal;
/*     */   private String _actionType;
/*     */   private BigDecimal _actionArg;
/*     */   private BigDecimal _actionArgQty;
/*     */   
/*     */   public Long getOrganizationId() {
/*  43 */     return this._organizationId;
/*     */   }
/*     */   
/*     */   public void setOrganizationId(Long argOrganizationId) {
/*  47 */     if (changed(argOrganizationId, this._organizationId, "organizationId")) {
/*  48 */       this._organizationId = argOrganizationId;
/*     */     }
/*     */   }
/*     */   
/*     */   public String getDealId() {
/*  53 */     return this._dealId;
/*     */   }
/*     */   
/*     */   public void setDealId(String argDealId) {
/*  57 */     if (changed(argDealId, this._dealId, "dealId")) {
/*  58 */       this._dealId = (argDealId != null && MANAGE_CASE) ? argDealId.toUpperCase() : argDealId;
/*     */     }
/*     */   }
/*     */   
/*     */   public Integer getOrdinal() {
/*  63 */     return this._ordinal;
/*     */   }
/*     */   
/*     */   public void setOrdinal(Integer argOrdinal) {
/*  67 */     if (changed(argOrdinal, this._ordinal, "ordinal")) {
/*  68 */       this._ordinal = argOrdinal;
/*     */     }
/*     */   }
/*     */   
/*     */   public String getOrgCode() {
/*  73 */     return this._orgCode;
/*     */   }
/*     */   
/*     */   public void setOrgCode(String argOrgCode) {
/*  77 */     if (changed(argOrgCode, this._orgCode, "orgCode")) {
/*  78 */       this._orgCode = argOrgCode;
/*     */     }
/*     */   }
/*     */   
/*     */   public String getOrgValue() {
/*  83 */     return this._orgValue;
/*     */   }
/*     */   
/*     */   public void setOrgValue(String argOrgValue) {
/*  87 */     if (changed(argOrgValue, this._orgValue, "orgValue")) {
/*  88 */       this._orgValue = argOrgValue;
/*     */     }
/*     */   }
/*     */   
/*     */   public Date getCreateDate() {
/*  93 */     return (Date)this._createDate;
/*     */   }
/*     */   
/*     */   public void setCreateDate(Date argCreateDate) {
/*  97 */     if (changed(argCreateDate, this._createDate, "createDate")) {
/*  98 */       this._createDate = (argCreateDate == null || argCreateDate instanceof DtvDate) ? (DtvDate)argCreateDate : new DtvDate(argCreateDate);
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public String getCreateUserId() {
/* 104 */     return this._createUserId;
/*     */   }
/*     */   
/*     */   public void setCreateUserId(String argCreateUserId) {
/* 108 */     if (changed(argCreateUserId, this._createUserId, "createUserId")) {
/* 109 */       this._createUserId = argCreateUserId;
/*     */     }
/*     */   }
/*     */   
/*     */   public Date getUpdateDate() {
/* 114 */     return (Date)this._updateDate;
/*     */   }
/*     */   
/*     */   public void setUpdateDate(Date argUpdateDate) {
/* 118 */     if (changed(argUpdateDate, this._updateDate, "updateDate")) {
/* 119 */       this._updateDate = (argUpdateDate == null || argUpdateDate instanceof DtvDate) ? (DtvDate)argUpdateDate : new DtvDate(argUpdateDate);
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public String getUpdateUserId() {
/* 125 */     return this._updateUserId;
/*     */   }
/*     */   
/*     */   public void setUpdateUserId(String argUpdateUserId) {
/* 129 */     if (changed(argUpdateUserId, this._updateUserId, "updateUserId")) {
/* 130 */       this._updateUserId = argUpdateUserId;
/*     */     }
/*     */   }
/*     */   
/*     */   public Boolean getConsumable() {
/* 135 */     return this._consumable;
/*     */   }
/*     */   
/*     */   public void setConsumable(Boolean argConsumable) {
/* 139 */     if (changed(argConsumable, this._consumable, "consumable")) {
/* 140 */       this._consumable = argConsumable;
/*     */     }
/*     */   }
/*     */   
/*     */   public BigDecimal getMinQty() {
/* 145 */     return this._minQty;
/*     */   }
/*     */   
/*     */   public void setMinQty(BigDecimal argMinQty) {
/* 149 */     if (changed(argMinQty, this._minQty, "minQty")) {
/* 150 */       this._minQty = argMinQty;
/*     */     }
/*     */   }
/*     */   
/*     */   public BigDecimal getMaxQty() {
/* 155 */     return this._maxQty;
/*     */   }
/*     */   
/*     */   public void setMaxQty(BigDecimal argMaxQty) {
/* 159 */     if (changed(argMaxQty, this._maxQty, "maxQty")) {
/* 160 */       this._maxQty = argMaxQty;
/*     */     }
/*     */   }
/*     */   
/*     */   public BigDecimal getMinItemTotal() {
/* 165 */     return this._minItemTotal;
/*     */   }
/*     */   
/*     */   public void setMinItemTotal(BigDecimal argMinItemTotal) {
/* 169 */     if (changed(argMinItemTotal, this._minItemTotal, "minItemTotal")) {
/* 170 */       this._minItemTotal = argMinItemTotal;
/*     */     }
/*     */   }
/*     */   
/*     */   public String getActionType() {
/* 175 */     return this._actionType;
/*     */   }
/*     */   
/*     */   public void setActionType(String argActionType) {
/* 179 */     if (changed(argActionType, this._actionType, "actionType")) {
/* 180 */       this._actionType = argActionType;
/*     */     }
/*     */   }
/*     */   
/*     */   public BigDecimal getActionArg() {
/* 185 */     return this._actionArg;
/*     */   }
/*     */   
/*     */   public void setActionArg(BigDecimal argActionArg) {
/* 189 */     if (changed(argActionArg, this._actionArg, "actionArg")) {
/* 190 */       this._actionArg = argActionArg;
/*     */     }
/*     */   }
/*     */   
/*     */   public BigDecimal getActionArgQty() {
/* 195 */     return this._actionArgQty;
/*     */   }
/*     */   
/*     */   public void setActionArgQty(BigDecimal argActionArgQty) {
/* 199 */     if (changed(argActionArgQty, this._actionArgQty, "actionArgQty")) {
/* 200 */       this._actionArgQty = argActionArgQty;
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public String toString() {
/* 207 */     StringBuilder buf = new StringBuilder(512);
/* 208 */     buf.append(super.toString()).append(" Id: ").append(getObjectId()).append(" Values: ");
/* 209 */     if (getOrganizationId() != null) {
/* 210 */       buf.append("organizationId").append("=").append(getOrganizationId()).append(" ");
/*     */     }
/* 212 */     if (getDealId() != null) {
/* 213 */       buf.append("dealId").append("=").append(getDealId()).append(" ");
/*     */     }
/* 215 */     if (getOrdinal() != null) {
/* 216 */       buf.append("ordinal").append("=").append(getOrdinal()).append(" ");
/*     */     }
/* 218 */     if (getOrgCode() != null) {
/* 219 */       buf.append("orgCode").append("=").append(getOrgCode()).append(" ");
/*     */     }
/* 221 */     if (getOrgValue() != null) {
/* 222 */       buf.append("orgValue").append("=").append(getOrgValue()).append(" ");
/*     */     }
/* 224 */     if (getCreateDate() != null) {
/* 225 */       buf.append("createDate").append("=").append(getCreateDate()).append(" ");
/*     */     }
/* 227 */     if (getCreateUserId() != null) {
/* 228 */       buf.append("createUserId").append("=").append(getCreateUserId()).append(" ");
/*     */     }
/* 230 */     if (getUpdateDate() != null) {
/* 231 */       buf.append("updateDate").append("=").append(getUpdateDate()).append(" ");
/*     */     }
/* 233 */     if (getUpdateUserId() != null) {
/* 234 */       buf.append("updateUserId").append("=").append(getUpdateUserId()).append(" ");
/*     */     }
/* 236 */     if (getConsumable() != null && getConsumable().booleanValue()) {
/* 237 */       buf.append("consumable").append("=").append(getConsumable()).append(" ");
/*     */     }
/* 239 */     if (getMinQty() != null) {
/* 240 */       buf.append("minQty").append("=").append(getMinQty()).append(" ");
/*     */     }
/* 242 */     if (getMaxQty() != null) {
/* 243 */       buf.append("maxQty").append("=").append(getMaxQty()).append(" ");
/*     */     }
/* 245 */     if (getMinItemTotal() != null) {
/* 246 */       buf.append("minItemTotal").append("=").append(getMinItemTotal()).append(" ");
/*     */     }
/* 248 */     if (getActionType() != null) {
/* 249 */       buf.append("actionType").append("=").append(getActionType()).append(" ");
/*     */     }
/* 251 */     if (getActionArg() != null) {
/* 252 */       buf.append("actionArg").append("=").append(getActionArg()).append(" ");
/*     */     }
/* 254 */     if (getActionArgQty() != null) {
/* 255 */       buf.append("actionArgQty").append("=").append(getActionArgQty()).append(" ");
/*     */     }
/*     */     
/* 258 */     return buf.toString();
/*     */   }
/*     */   
/*     */   public IObjectId getObjectId() {
/* 262 */     DealItemActionId id = new DealItemActionId();
/* 263 */     id.setOrganizationId(getOrganizationId());
/* 264 */     id.setDealId(getDealId());
/* 265 */     id.setOrdinal(getOrdinal());
/* 266 */     return (IObjectId)id;
/*     */   }
/*     */   
/*     */   public void setObjectId(IObjectId argObjectId) {
/* 270 */     setOrganizationId(((DealItemActionId)argObjectId).getOrganizationId());
/* 271 */     setDealId(((DealItemActionId)argObjectId).getDealId());
/* 272 */     setOrdinal(((DealItemActionId)argObjectId).getOrdinal());
/*     */   }
/*     */   
/*     */   public String getImplementingClass() {
/* 276 */     return null;
/*     */   }
/*     */   
/*     */   public String toXmlString() {
/* 280 */     StringBuilder buf = new StringBuilder(800);
/* 281 */     buf.append("<").append("dao").append(" name=\"DealItemAction\" cmd=\"" + getObjectStateString() + "\">");
/* 282 */     getFieldsAsXml(buf);
/* 283 */     buf.append("</").append("dao").append(">");
/*     */     
/* 285 */     return buf.toString();
/*     */   }
/*     */   
/*     */   public Map<String, String> getValues() {
/* 289 */     Map<String, String> values = super.getValues();
/* 290 */     if (this._organizationId != null) values.put("OrganizationId", DaoUtils.getXmlSafeFieldValue(-5, this._organizationId)); 
/* 291 */     if (this._dealId != null) values.put("DealId", DaoUtils.getXmlSafeFieldValue(12, this._dealId)); 
/* 292 */     if (this._ordinal != null) values.put("Ordinal", DaoUtils.getXmlSafeFieldValue(4, this._ordinal)); 
/* 293 */     if (this._orgCode != null) values.put("OrgCode", DaoUtils.getXmlSafeFieldValue(12, this._orgCode)); 
/* 294 */     if (this._orgValue != null) values.put("OrgValue", DaoUtils.getXmlSafeFieldValue(12, this._orgValue)); 
/* 295 */     if (this._createDate != null) values.put("CreateDate", DaoUtils.getXmlSafeFieldValue(91, this._createDate)); 
/* 296 */     if (this._createUserId != null) values.put("CreateUserId", DaoUtils.getXmlSafeFieldValue(12, this._createUserId)); 
/* 297 */     if (this._updateDate != null) values.put("UpdateDate", DaoUtils.getXmlSafeFieldValue(91, this._updateDate)); 
/* 298 */     if (this._updateUserId != null) values.put("UpdateUserId", DaoUtils.getXmlSafeFieldValue(12, this._updateUserId)); 
/* 299 */     if (this._consumable != null) values.put("Consumable", DaoUtils.getXmlSafeFieldValue(-7, this._consumable)); 
/* 300 */     if (this._minQty != null) values.put("MinQty", DaoUtils.getXmlSafeFieldValue(3, this._minQty)); 
/* 301 */     if (this._maxQty != null) values.put("MaxQty", DaoUtils.getXmlSafeFieldValue(3, this._maxQty)); 
/* 302 */     if (this._minItemTotal != null) values.put("MinItemTotal", DaoUtils.getXmlSafeFieldValue(3, this._minItemTotal)); 
/* 303 */     if (this._actionType != null) values.put("ActionType", DaoUtils.getXmlSafeFieldValue(12, this._actionType)); 
/* 304 */     if (this._actionArg != null) values.put("ActionArg", DaoUtils.getXmlSafeFieldValue(3, this._actionArg)); 
/* 305 */     if (this._actionArgQty != null) values.put("ActionArgQty", DaoUtils.getXmlSafeFieldValue(3, this._actionArgQty)); 
/* 306 */     return values;
/*     */   }
/*     */ 
/*     */   
/*     */   public void setValues(Map<String, String> argValues) {
/* 311 */     super.setValues(argValues);
/* 312 */     for (Map.Entry<String, String> field : argValues.entrySet()) {
/*     */       
/* 314 */       String fieldName = field.getKey();
/* 315 */       String fieldValue = field.getValue();
/* 316 */       switch (fieldName) {
/*     */         
/*     */         case "OrganizationId":
/*     */           try {
/* 320 */             Object value = DaoUtils.getFieldValueForXmlString(-5, fieldValue);
/* 321 */             setOrganizationId((Long)value);
/* 322 */           } catch (Exception ee) {
/* 323 */             throw new DtxException("An exception occurred while calling setOrganizationId() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "DealId":
/*     */           try {
/* 329 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 330 */             setDealId((String)value);
/* 331 */           } catch (Exception ee) {
/* 332 */             throw new DtxException("An exception occurred while calling setDealId() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "Ordinal":
/*     */           try {
/* 338 */             Object value = DaoUtils.getFieldValueForXmlString(4, fieldValue);
/* 339 */             setOrdinal((Integer)value);
/* 340 */           } catch (Exception ee) {
/* 341 */             throw new DtxException("An exception occurred while calling setOrdinal() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "OrgCode":
/*     */           try {
/* 347 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 348 */             setOrgCode((String)value);
/* 349 */           } catch (Exception ee) {
/* 350 */             throw new DtxException("An exception occurred while calling setOrgCode() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "OrgValue":
/*     */           try {
/* 356 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 357 */             setOrgValue((String)value);
/* 358 */           } catch (Exception ee) {
/* 359 */             throw new DtxException("An exception occurred while calling setOrgValue() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "CreateDate":
/*     */           try {
/* 365 */             Object value = DaoUtils.getFieldValueForXmlString(91, fieldValue);
/* 366 */             setCreateDate((Date)value);
/* 367 */           } catch (Exception ee) {
/* 368 */             throw new DtxException("An exception occurred while calling setCreateDate() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "CreateUserId":
/*     */           try {
/* 374 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 375 */             setCreateUserId((String)value);
/* 376 */           } catch (Exception ee) {
/* 377 */             throw new DtxException("An exception occurred while calling setCreateUserId() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "UpdateDate":
/*     */           try {
/* 383 */             Object value = DaoUtils.getFieldValueForXmlString(91, fieldValue);
/* 384 */             setUpdateDate((Date)value);
/* 385 */           } catch (Exception ee) {
/* 386 */             throw new DtxException("An exception occurred while calling setUpdateDate() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "UpdateUserId":
/*     */           try {
/* 392 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 393 */             setUpdateUserId((String)value);
/* 394 */           } catch (Exception ee) {
/* 395 */             throw new DtxException("An exception occurred while calling setUpdateUserId() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "Consumable":
/*     */           try {
/* 401 */             Object value = DaoUtils.getFieldValueForXmlString(-7, fieldValue);
/* 402 */             setConsumable((Boolean)value);
/* 403 */           } catch (Exception ee) {
/* 404 */             throw new DtxException("An exception occurred while calling setConsumable() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "MinQty":
/*     */           try {
/* 410 */             Object value = DaoUtils.getFieldValueForXmlString(3, fieldValue);
/* 411 */             setMinQty((BigDecimal)value);
/* 412 */           } catch (Exception ee) {
/* 413 */             throw new DtxException("An exception occurred while calling setMinQty() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "MaxQty":
/*     */           try {
/* 419 */             Object value = DaoUtils.getFieldValueForXmlString(3, fieldValue);
/* 420 */             setMaxQty((BigDecimal)value);
/* 421 */           } catch (Exception ee) {
/* 422 */             throw new DtxException("An exception occurred while calling setMaxQty() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "MinItemTotal":
/*     */           try {
/* 428 */             Object value = DaoUtils.getFieldValueForXmlString(3, fieldValue);
/* 429 */             setMinItemTotal((BigDecimal)value);
/* 430 */           } catch (Exception ee) {
/* 431 */             throw new DtxException("An exception occurred while calling setMinItemTotal() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "ActionType":
/*     */           try {
/* 437 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 438 */             setActionType((String)value);
/* 439 */           } catch (Exception ee) {
/* 440 */             throw new DtxException("An exception occurred while calling setActionType() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "ActionArg":
/*     */           try {
/* 446 */             Object value = DaoUtils.getFieldValueForXmlString(3, fieldValue);
/* 447 */             setActionArg((BigDecimal)value);
/* 448 */           } catch (Exception ee) {
/* 449 */             throw new DtxException("An exception occurred while calling setActionArg() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "ActionArgQty":
/*     */           try {
/* 455 */             Object value = DaoUtils.getFieldValueForXmlString(3, fieldValue);
/* 456 */             setActionArgQty((BigDecimal)value);
/* 457 */           } catch (Exception ee) {
/* 458 */             throw new DtxException("An exception occurred while calling setActionArgQty() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */       } 
/*     */     } 
/*     */   }
/*     */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\prc\impl\DealItemActionDAO.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */