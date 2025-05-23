/*     */ package dtv.xst.dao.com.impl;
/*     */ 
/*     */ import dtv.data2.access.DaoUtils;
/*     */ import dtv.data2.access.IObjectId;
/*     */ import dtv.data2.access.exception.DtxException;
/*     */ import dtv.data2.access.impl.AbstractDAOImpl;
/*     */ import dtv.util.DtvDate;
/*     */ import dtv.xst.dao.com.ShippingFeeTierId;
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
/*     */ public class ShippingFeeTierDAO
/*     */   extends AbstractDAOImpl
/*     */ {
/*     */   private static final long serialVersionUID = 367423706L;
/*  23 */   private static final Logger _logger = Logger.getLogger(ShippingFeeTierDAO.class);
/*     */   
/*     */   private String _ruleName;
/*     */   private Long _organizationId;
/*     */   private String _parentRuleName;
/*     */   private DtvDate _createDate;
/*     */   private String _createUserId;
/*     */   private DtvDate _updateDate;
/*     */   private String _updateUserId;
/*     */   private String _orgCode;
/*     */   private String _orgValue;
/*     */   private Long _priority;
/*     */   private String _feeType;
/*     */   private BigDecimal _feeValue;
/*     */   private String _shipMethod;
/*     */   private BigDecimal _minPrice;
/*     */   private BigDecimal _maxPrice;
/*     */   private String _itemId;
/*     */   private String _ruleType;
/*     */   private String _param1;
/*     */   private String _param2;
/*     */   
/*     */   public String getRuleName() {
/*  46 */     return this._ruleName;
/*     */   }
/*     */   
/*     */   public void setRuleName(String argRuleName) {
/*  50 */     if (changed(argRuleName, this._ruleName, "ruleName")) {
/*  51 */       this._ruleName = (argRuleName != null && MANAGE_CASE) ? argRuleName.toUpperCase() : argRuleName;
/*     */     }
/*     */   }
/*     */   
/*     */   public Long getOrganizationId() {
/*  56 */     return this._organizationId;
/*     */   }
/*     */   
/*     */   public void setOrganizationId(Long argOrganizationId) {
/*  60 */     if (changed(argOrganizationId, this._organizationId, "organizationId")) {
/*  61 */       this._organizationId = argOrganizationId;
/*     */     }
/*     */   }
/*     */   
/*     */   public String getParentRuleName() {
/*  66 */     return this._parentRuleName;
/*     */   }
/*     */   
/*     */   public void setParentRuleName(String argParentRuleName) {
/*  70 */     if (changed(argParentRuleName, this._parentRuleName, "parentRuleName")) {
/*  71 */       this._parentRuleName = (argParentRuleName != null && MANAGE_CASE) ? argParentRuleName.toUpperCase() : argParentRuleName;
/*     */     }
/*     */   }
/*     */   
/*     */   public Date getCreateDate() {
/*  76 */     return (Date)this._createDate;
/*     */   }
/*     */   
/*     */   public void setCreateDate(Date argCreateDate) {
/*  80 */     if (changed(argCreateDate, this._createDate, "createDate")) {
/*  81 */       this._createDate = (argCreateDate == null || argCreateDate instanceof DtvDate) ? (DtvDate)argCreateDate : new DtvDate(argCreateDate);
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public String getCreateUserId() {
/*  87 */     return this._createUserId;
/*     */   }
/*     */   
/*     */   public void setCreateUserId(String argCreateUserId) {
/*  91 */     if (changed(argCreateUserId, this._createUserId, "createUserId")) {
/*  92 */       this._createUserId = argCreateUserId;
/*     */     }
/*     */   }
/*     */   
/*     */   public Date getUpdateDate() {
/*  97 */     return (Date)this._updateDate;
/*     */   }
/*     */   
/*     */   public void setUpdateDate(Date argUpdateDate) {
/* 101 */     if (changed(argUpdateDate, this._updateDate, "updateDate")) {
/* 102 */       this._updateDate = (argUpdateDate == null || argUpdateDate instanceof DtvDate) ? (DtvDate)argUpdateDate : new DtvDate(argUpdateDate);
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public String getUpdateUserId() {
/* 108 */     return this._updateUserId;
/*     */   }
/*     */   
/*     */   public void setUpdateUserId(String argUpdateUserId) {
/* 112 */     if (changed(argUpdateUserId, this._updateUserId, "updateUserId")) {
/* 113 */       this._updateUserId = argUpdateUserId;
/*     */     }
/*     */   }
/*     */   
/*     */   public String getOrgCode() {
/* 118 */     return this._orgCode;
/*     */   }
/*     */   
/*     */   public void setOrgCode(String argOrgCode) {
/* 122 */     if (changed(argOrgCode, this._orgCode, "orgCode")) {
/* 123 */       this._orgCode = argOrgCode;
/*     */     }
/*     */   }
/*     */   
/*     */   public String getOrgValue() {
/* 128 */     return this._orgValue;
/*     */   }
/*     */   
/*     */   public void setOrgValue(String argOrgValue) {
/* 132 */     if (changed(argOrgValue, this._orgValue, "orgValue")) {
/* 133 */       this._orgValue = argOrgValue;
/*     */     }
/*     */   }
/*     */   
/*     */   public Long getPriority() {
/* 138 */     return this._priority;
/*     */   }
/*     */   
/*     */   public void setPriority(Long argPriority) {
/* 142 */     if (changed(argPriority, this._priority, "priority")) {
/* 143 */       this._priority = argPriority;
/*     */     }
/*     */   }
/*     */   
/*     */   public String getFeeType() {
/* 148 */     return this._feeType;
/*     */   }
/*     */   
/*     */   public void setFeeType(String argFeeType) {
/* 152 */     if (changed(argFeeType, this._feeType, "feeType")) {
/* 153 */       this._feeType = argFeeType;
/*     */     }
/*     */   }
/*     */   
/*     */   public BigDecimal getFeeValue() {
/* 158 */     return this._feeValue;
/*     */   }
/*     */   
/*     */   public void setFeeValue(BigDecimal argFeeValue) {
/* 162 */     if (changed(argFeeValue, this._feeValue, "feeValue")) {
/* 163 */       this._feeValue = argFeeValue;
/*     */     }
/*     */   }
/*     */   
/*     */   public String getShipMethod() {
/* 168 */     return this._shipMethod;
/*     */   }
/*     */   
/*     */   public void setShipMethod(String argShipMethod) {
/* 172 */     if (changed(argShipMethod, this._shipMethod, "shipMethod")) {
/* 173 */       this._shipMethod = argShipMethod;
/*     */     }
/*     */   }
/*     */   
/*     */   public BigDecimal getMinPrice() {
/* 178 */     return this._minPrice;
/*     */   }
/*     */   
/*     */   public void setMinPrice(BigDecimal argMinPrice) {
/* 182 */     if (changed(argMinPrice, this._minPrice, "minPrice")) {
/* 183 */       this._minPrice = argMinPrice;
/*     */     }
/*     */   }
/*     */   
/*     */   public BigDecimal getMaxPrice() {
/* 188 */     return this._maxPrice;
/*     */   }
/*     */   
/*     */   public void setMaxPrice(BigDecimal argMaxPrice) {
/* 192 */     if (changed(argMaxPrice, this._maxPrice, "maxPrice")) {
/* 193 */       this._maxPrice = argMaxPrice;
/*     */     }
/*     */   }
/*     */   
/*     */   public String getItemId() {
/* 198 */     return this._itemId;
/*     */   }
/*     */   
/*     */   public void setItemId(String argItemId) {
/* 202 */     if (changed(argItemId, this._itemId, "itemId")) {
/* 203 */       this._itemId = argItemId;
/*     */     }
/*     */   }
/*     */   
/*     */   public String getRuleType() {
/* 208 */     return this._ruleType;
/*     */   }
/*     */   
/*     */   public void setRuleType(String argRuleType) {
/* 212 */     if (changed(argRuleType, this._ruleType, "ruleType")) {
/* 213 */       this._ruleType = argRuleType;
/*     */     }
/*     */   }
/*     */   
/*     */   public String getParam1() {
/* 218 */     return this._param1;
/*     */   }
/*     */   
/*     */   public void setParam1(String argParam1) {
/* 222 */     if (changed(argParam1, this._param1, "param1")) {
/* 223 */       this._param1 = argParam1;
/*     */     }
/*     */   }
/*     */   
/*     */   public String getParam2() {
/* 228 */     return this._param2;
/*     */   }
/*     */   
/*     */   public void setParam2(String argParam2) {
/* 232 */     if (changed(argParam2, this._param2, "param2")) {
/* 233 */       this._param2 = argParam2;
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public String toString() {
/* 240 */     StringBuilder buf = new StringBuilder(512);
/* 241 */     buf.append(super.toString()).append(" Id: ").append(getObjectId()).append(" Values: ");
/* 242 */     if (getRuleName() != null) {
/* 243 */       buf.append("ruleName").append("=").append(getRuleName()).append(" ");
/*     */     }
/* 245 */     if (getOrganizationId() != null) {
/* 246 */       buf.append("organizationId").append("=").append(getOrganizationId()).append(" ");
/*     */     }
/* 248 */     if (getParentRuleName() != null) {
/* 249 */       buf.append("parentRuleName").append("=").append(getParentRuleName()).append(" ");
/*     */     }
/* 251 */     if (getCreateDate() != null) {
/* 252 */       buf.append("createDate").append("=").append(getCreateDate()).append(" ");
/*     */     }
/* 254 */     if (getCreateUserId() != null) {
/* 255 */       buf.append("createUserId").append("=").append(getCreateUserId()).append(" ");
/*     */     }
/* 257 */     if (getUpdateDate() != null) {
/* 258 */       buf.append("updateDate").append("=").append(getUpdateDate()).append(" ");
/*     */     }
/* 260 */     if (getUpdateUserId() != null) {
/* 261 */       buf.append("updateUserId").append("=").append(getUpdateUserId()).append(" ");
/*     */     }
/* 263 */     if (getOrgCode() != null) {
/* 264 */       buf.append("orgCode").append("=").append(getOrgCode()).append(" ");
/*     */     }
/* 266 */     if (getOrgValue() != null) {
/* 267 */       buf.append("orgValue").append("=").append(getOrgValue()).append(" ");
/*     */     }
/* 269 */     if (getPriority() != null) {
/* 270 */       buf.append("priority").append("=").append(getPriority()).append(" ");
/*     */     }
/* 272 */     if (getFeeType() != null) {
/* 273 */       buf.append("feeType").append("=").append(getFeeType()).append(" ");
/*     */     }
/* 275 */     if (getFeeValue() != null) {
/* 276 */       buf.append("feeValue").append("=").append(getFeeValue()).append(" ");
/*     */     }
/* 278 */     if (getShipMethod() != null) {
/* 279 */       buf.append("shipMethod").append("=").append(getShipMethod()).append(" ");
/*     */     }
/* 281 */     if (getMinPrice() != null) {
/* 282 */       buf.append("minPrice").append("=").append(getMinPrice()).append(" ");
/*     */     }
/* 284 */     if (getMaxPrice() != null) {
/* 285 */       buf.append("maxPrice").append("=").append(getMaxPrice()).append(" ");
/*     */     }
/* 287 */     if (getItemId() != null) {
/* 288 */       buf.append("itemId").append("=").append(getItemId()).append(" ");
/*     */     }
/* 290 */     if (getRuleType() != null) {
/* 291 */       buf.append("ruleType").append("=").append(getRuleType()).append(" ");
/*     */     }
/* 293 */     if (getParam1() != null) {
/* 294 */       buf.append("param1").append("=").append(getParam1()).append(" ");
/*     */     }
/* 296 */     if (getParam2() != null) {
/* 297 */       buf.append("param2").append("=").append(getParam2()).append(" ");
/*     */     }
/*     */     
/* 300 */     return buf.toString();
/*     */   }
/*     */   
/*     */   public IObjectId getObjectId() {
/* 304 */     ShippingFeeTierId id = new ShippingFeeTierId();
/* 305 */     id.setRuleName(getRuleName());
/* 306 */     id.setOrganizationId(getOrganizationId());
/* 307 */     id.setParentRuleName(getParentRuleName());
/* 308 */     return (IObjectId)id;
/*     */   }
/*     */   
/*     */   public void setObjectId(IObjectId argObjectId) {
/* 312 */     setRuleName(((ShippingFeeTierId)argObjectId).getRuleName());
/* 313 */     setOrganizationId(((ShippingFeeTierId)argObjectId).getOrganizationId());
/* 314 */     setParentRuleName(((ShippingFeeTierId)argObjectId).getParentRuleName());
/*     */   }
/*     */   
/*     */   public String getImplementingClass() {
/* 318 */     return null;
/*     */   }
/*     */   
/*     */   public String toXmlString() {
/* 322 */     StringBuilder buf = new StringBuilder(950);
/* 323 */     buf.append("<").append("dao").append(" name=\"ShippingFeeTier\" cmd=\"" + getObjectStateString() + "\">");
/* 324 */     getFieldsAsXml(buf);
/* 325 */     buf.append("</").append("dao").append(">");
/*     */     
/* 327 */     return buf.toString();
/*     */   }
/*     */   
/*     */   public Map<String, String> getValues() {
/* 331 */     Map<String, String> values = super.getValues();
/* 332 */     if (this._ruleName != null) values.put("RuleName", DaoUtils.getXmlSafeFieldValue(12, this._ruleName)); 
/* 333 */     if (this._organizationId != null) values.put("OrganizationId", DaoUtils.getXmlSafeFieldValue(-5, this._organizationId)); 
/* 334 */     if (this._parentRuleName != null) values.put("ParentRuleName", DaoUtils.getXmlSafeFieldValue(12, this._parentRuleName)); 
/* 335 */     if (this._createDate != null) values.put("CreateDate", DaoUtils.getXmlSafeFieldValue(91, this._createDate)); 
/* 336 */     if (this._createUserId != null) values.put("CreateUserId", DaoUtils.getXmlSafeFieldValue(12, this._createUserId)); 
/* 337 */     if (this._updateDate != null) values.put("UpdateDate", DaoUtils.getXmlSafeFieldValue(91, this._updateDate)); 
/* 338 */     if (this._updateUserId != null) values.put("UpdateUserId", DaoUtils.getXmlSafeFieldValue(12, this._updateUserId)); 
/* 339 */     if (this._orgCode != null) values.put("OrgCode", DaoUtils.getXmlSafeFieldValue(12, this._orgCode)); 
/* 340 */     if (this._orgValue != null) values.put("OrgValue", DaoUtils.getXmlSafeFieldValue(12, this._orgValue)); 
/* 341 */     if (this._priority != null) values.put("Priority", DaoUtils.getXmlSafeFieldValue(-5, this._priority)); 
/* 342 */     if (this._feeType != null) values.put("FeeType", DaoUtils.getXmlSafeFieldValue(12, this._feeType)); 
/* 343 */     if (this._feeValue != null) values.put("FeeValue", DaoUtils.getXmlSafeFieldValue(3, this._feeValue)); 
/* 344 */     if (this._shipMethod != null) values.put("ShipMethod", DaoUtils.getXmlSafeFieldValue(12, this._shipMethod)); 
/* 345 */     if (this._minPrice != null) values.put("MinPrice", DaoUtils.getXmlSafeFieldValue(3, this._minPrice)); 
/* 346 */     if (this._maxPrice != null) values.put("MaxPrice", DaoUtils.getXmlSafeFieldValue(3, this._maxPrice)); 
/* 347 */     if (this._itemId != null) values.put("ItemId", DaoUtils.getXmlSafeFieldValue(12, this._itemId)); 
/* 348 */     if (this._ruleType != null) values.put("RuleType", DaoUtils.getXmlSafeFieldValue(12, this._ruleType)); 
/* 349 */     if (this._param1 != null) values.put("Param1", DaoUtils.getXmlSafeFieldValue(12, this._param1)); 
/* 350 */     if (this._param2 != null) values.put("Param2", DaoUtils.getXmlSafeFieldValue(12, this._param2)); 
/* 351 */     return values;
/*     */   }
/*     */ 
/*     */   
/*     */   public void setValues(Map<String, String> argValues) {
/* 356 */     super.setValues(argValues);
/* 357 */     for (Map.Entry<String, String> field : argValues.entrySet()) {
/*     */       
/* 359 */       String fieldName = field.getKey();
/* 360 */       String fieldValue = field.getValue();
/* 361 */       switch (fieldName) {
/*     */         
/*     */         case "RuleName":
/*     */           try {
/* 365 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 366 */             setRuleName((String)value);
/* 367 */           } catch (Exception ee) {
/* 368 */             throw new DtxException("An exception occurred while calling setRuleName() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "OrganizationId":
/*     */           try {
/* 374 */             Object value = DaoUtils.getFieldValueForXmlString(-5, fieldValue);
/* 375 */             setOrganizationId((Long)value);
/* 376 */           } catch (Exception ee) {
/* 377 */             throw new DtxException("An exception occurred while calling setOrganizationId() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "ParentRuleName":
/*     */           try {
/* 383 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 384 */             setParentRuleName((String)value);
/* 385 */           } catch (Exception ee) {
/* 386 */             throw new DtxException("An exception occurred while calling setParentRuleName() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "CreateDate":
/*     */           try {
/* 392 */             Object value = DaoUtils.getFieldValueForXmlString(91, fieldValue);
/* 393 */             setCreateDate((Date)value);
/* 394 */           } catch (Exception ee) {
/* 395 */             throw new DtxException("An exception occurred while calling setCreateDate() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "CreateUserId":
/*     */           try {
/* 401 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 402 */             setCreateUserId((String)value);
/* 403 */           } catch (Exception ee) {
/* 404 */             throw new DtxException("An exception occurred while calling setCreateUserId() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "UpdateDate":
/*     */           try {
/* 410 */             Object value = DaoUtils.getFieldValueForXmlString(91, fieldValue);
/* 411 */             setUpdateDate((Date)value);
/* 412 */           } catch (Exception ee) {
/* 413 */             throw new DtxException("An exception occurred while calling setUpdateDate() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "UpdateUserId":
/*     */           try {
/* 419 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 420 */             setUpdateUserId((String)value);
/* 421 */           } catch (Exception ee) {
/* 422 */             throw new DtxException("An exception occurred while calling setUpdateUserId() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "OrgCode":
/*     */           try {
/* 428 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 429 */             setOrgCode((String)value);
/* 430 */           } catch (Exception ee) {
/* 431 */             throw new DtxException("An exception occurred while calling setOrgCode() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "OrgValue":
/*     */           try {
/* 437 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 438 */             setOrgValue((String)value);
/* 439 */           } catch (Exception ee) {
/* 440 */             throw new DtxException("An exception occurred while calling setOrgValue() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "Priority":
/*     */           try {
/* 446 */             Object value = DaoUtils.getFieldValueForXmlString(-5, fieldValue);
/* 447 */             setPriority((Long)value);
/* 448 */           } catch (Exception ee) {
/* 449 */             throw new DtxException("An exception occurred while calling setPriority() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "FeeType":
/*     */           try {
/* 455 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 456 */             setFeeType((String)value);
/* 457 */           } catch (Exception ee) {
/* 458 */             throw new DtxException("An exception occurred while calling setFeeType() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "FeeValue":
/*     */           try {
/* 464 */             Object value = DaoUtils.getFieldValueForXmlString(3, fieldValue);
/* 465 */             setFeeValue((BigDecimal)value);
/* 466 */           } catch (Exception ee) {
/* 467 */             throw new DtxException("An exception occurred while calling setFeeValue() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "ShipMethod":
/*     */           try {
/* 473 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 474 */             setShipMethod((String)value);
/* 475 */           } catch (Exception ee) {
/* 476 */             throw new DtxException("An exception occurred while calling setShipMethod() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "MinPrice":
/*     */           try {
/* 482 */             Object value = DaoUtils.getFieldValueForXmlString(3, fieldValue);
/* 483 */             setMinPrice((BigDecimal)value);
/* 484 */           } catch (Exception ee) {
/* 485 */             throw new DtxException("An exception occurred while calling setMinPrice() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "MaxPrice":
/*     */           try {
/* 491 */             Object value = DaoUtils.getFieldValueForXmlString(3, fieldValue);
/* 492 */             setMaxPrice((BigDecimal)value);
/* 493 */           } catch (Exception ee) {
/* 494 */             throw new DtxException("An exception occurred while calling setMaxPrice() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "ItemId":
/*     */           try {
/* 500 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 501 */             setItemId((String)value);
/* 502 */           } catch (Exception ee) {
/* 503 */             throw new DtxException("An exception occurred while calling setItemId() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "RuleType":
/*     */           try {
/* 509 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 510 */             setRuleType((String)value);
/* 511 */           } catch (Exception ee) {
/* 512 */             throw new DtxException("An exception occurred while calling setRuleType() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "Param1":
/*     */           try {
/* 518 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 519 */             setParam1((String)value);
/* 520 */           } catch (Exception ee) {
/* 521 */             throw new DtxException("An exception occurred while calling setParam1() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "Param2":
/*     */           try {
/* 527 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 528 */             setParam2((String)value);
/* 529 */           } catch (Exception ee) {
/* 530 */             throw new DtxException("An exception occurred while calling setParam2() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */       } 
/*     */     } 
/*     */   }
/*     */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\com\impl\ShippingFeeTierDAO.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */