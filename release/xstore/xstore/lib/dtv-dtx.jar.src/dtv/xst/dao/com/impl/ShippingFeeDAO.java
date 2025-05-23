/*     */ package dtv.xst.dao.com.impl;
/*     */ 
/*     */ import dtv.data2.access.DaoUtils;
/*     */ import dtv.data2.access.IObjectId;
/*     */ import dtv.data2.access.exception.DtxException;
/*     */ import dtv.data2.access.impl.AbstractDAOImpl;
/*     */ import dtv.util.DtvDate;
/*     */ import dtv.xst.dao.com.ShippingFeeId;
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
/*     */ public class ShippingFeeDAO
/*     */   extends AbstractDAOImpl
/*     */ {
/*     */   private static final long serialVersionUID = -1531586856L;
/*  23 */   private static final Logger _logger = Logger.getLogger(ShippingFeeDAO.class);
/*     */   
/*     */   private String _ruleName;
/*     */   private Long _organizationId;
/*     */   private DtvDate _createDate;
/*     */   private String _createUserId;
/*     */   private DtvDate _updateDate;
/*     */   private String _updateUserId;
/*     */   private String _orgCode;
/*     */   private String _orgValue;
/*     */   private Long _priority;
/*     */   private String _shipItemID;
/*     */   private String _aggregationType;
/*     */   private String _ruleType;
/*     */   private String _param1;
/*     */   private String _param2;
/*     */   
/*     */   public String getRuleName() {
/*  41 */     return this._ruleName;
/*     */   }
/*     */   
/*     */   public void setRuleName(String argRuleName) {
/*  45 */     if (changed(argRuleName, this._ruleName, "ruleName")) {
/*  46 */       this._ruleName = (argRuleName != null && MANAGE_CASE) ? argRuleName.toUpperCase() : argRuleName;
/*     */     }
/*     */   }
/*     */   
/*     */   public Long getOrganizationId() {
/*  51 */     return this._organizationId;
/*     */   }
/*     */   
/*     */   public void setOrganizationId(Long argOrganizationId) {
/*  55 */     if (changed(argOrganizationId, this._organizationId, "organizationId")) {
/*  56 */       this._organizationId = argOrganizationId;
/*     */     }
/*     */   }
/*     */   
/*     */   public Date getCreateDate() {
/*  61 */     return (Date)this._createDate;
/*     */   }
/*     */   
/*     */   public void setCreateDate(Date argCreateDate) {
/*  65 */     if (changed(argCreateDate, this._createDate, "createDate")) {
/*  66 */       this._createDate = (argCreateDate == null || argCreateDate instanceof DtvDate) ? (DtvDate)argCreateDate : new DtvDate(argCreateDate);
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public String getCreateUserId() {
/*  72 */     return this._createUserId;
/*     */   }
/*     */   
/*     */   public void setCreateUserId(String argCreateUserId) {
/*  76 */     if (changed(argCreateUserId, this._createUserId, "createUserId")) {
/*  77 */       this._createUserId = argCreateUserId;
/*     */     }
/*     */   }
/*     */   
/*     */   public Date getUpdateDate() {
/*  82 */     return (Date)this._updateDate;
/*     */   }
/*     */   
/*     */   public void setUpdateDate(Date argUpdateDate) {
/*  86 */     if (changed(argUpdateDate, this._updateDate, "updateDate")) {
/*  87 */       this._updateDate = (argUpdateDate == null || argUpdateDate instanceof DtvDate) ? (DtvDate)argUpdateDate : new DtvDate(argUpdateDate);
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public String getUpdateUserId() {
/*  93 */     return this._updateUserId;
/*     */   }
/*     */   
/*     */   public void setUpdateUserId(String argUpdateUserId) {
/*  97 */     if (changed(argUpdateUserId, this._updateUserId, "updateUserId")) {
/*  98 */       this._updateUserId = argUpdateUserId;
/*     */     }
/*     */   }
/*     */   
/*     */   public String getOrgCode() {
/* 103 */     return this._orgCode;
/*     */   }
/*     */   
/*     */   public void setOrgCode(String argOrgCode) {
/* 107 */     if (changed(argOrgCode, this._orgCode, "orgCode")) {
/* 108 */       this._orgCode = argOrgCode;
/*     */     }
/*     */   }
/*     */   
/*     */   public String getOrgValue() {
/* 113 */     return this._orgValue;
/*     */   }
/*     */   
/*     */   public void setOrgValue(String argOrgValue) {
/* 117 */     if (changed(argOrgValue, this._orgValue, "orgValue")) {
/* 118 */       this._orgValue = argOrgValue;
/*     */     }
/*     */   }
/*     */   
/*     */   public Long getPriority() {
/* 123 */     return this._priority;
/*     */   }
/*     */   
/*     */   public void setPriority(Long argPriority) {
/* 127 */     if (changed(argPriority, this._priority, "priority")) {
/* 128 */       this._priority = argPriority;
/*     */     }
/*     */   }
/*     */   
/*     */   public String getShipItemID() {
/* 133 */     return this._shipItemID;
/*     */   }
/*     */   
/*     */   public void setShipItemID(String argShipItemID) {
/* 137 */     if (changed(argShipItemID, this._shipItemID, "shipItemID")) {
/* 138 */       this._shipItemID = argShipItemID;
/*     */     }
/*     */   }
/*     */   
/*     */   public String getAggregationType() {
/* 143 */     return this._aggregationType;
/*     */   }
/*     */   
/*     */   public void setAggregationType(String argAggregationType) {
/* 147 */     if (changed(argAggregationType, this._aggregationType, "aggregationType")) {
/* 148 */       this._aggregationType = argAggregationType;
/*     */     }
/*     */   }
/*     */   
/*     */   public String getRuleType() {
/* 153 */     return this._ruleType;
/*     */   }
/*     */   
/*     */   public void setRuleType(String argRuleType) {
/* 157 */     if (changed(argRuleType, this._ruleType, "ruleType")) {
/* 158 */       this._ruleType = argRuleType;
/*     */     }
/*     */   }
/*     */   
/*     */   public String getParam1() {
/* 163 */     return this._param1;
/*     */   }
/*     */   
/*     */   public void setParam1(String argParam1) {
/* 167 */     if (changed(argParam1, this._param1, "param1")) {
/* 168 */       this._param1 = argParam1;
/*     */     }
/*     */   }
/*     */   
/*     */   public String getParam2() {
/* 173 */     return this._param2;
/*     */   }
/*     */   
/*     */   public void setParam2(String argParam2) {
/* 177 */     if (changed(argParam2, this._param2, "param2")) {
/* 178 */       this._param2 = argParam2;
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public String toString() {
/* 185 */     StringBuilder buf = new StringBuilder(512);
/* 186 */     buf.append(super.toString()).append(" Id: ").append(getObjectId()).append(" Values: ");
/* 187 */     if (getRuleName() != null) {
/* 188 */       buf.append("ruleName").append("=").append(getRuleName()).append(" ");
/*     */     }
/* 190 */     if (getOrganizationId() != null) {
/* 191 */       buf.append("organizationId").append("=").append(getOrganizationId()).append(" ");
/*     */     }
/* 193 */     if (getCreateDate() != null) {
/* 194 */       buf.append("createDate").append("=").append(getCreateDate()).append(" ");
/*     */     }
/* 196 */     if (getCreateUserId() != null) {
/* 197 */       buf.append("createUserId").append("=").append(getCreateUserId()).append(" ");
/*     */     }
/* 199 */     if (getUpdateDate() != null) {
/* 200 */       buf.append("updateDate").append("=").append(getUpdateDate()).append(" ");
/*     */     }
/* 202 */     if (getUpdateUserId() != null) {
/* 203 */       buf.append("updateUserId").append("=").append(getUpdateUserId()).append(" ");
/*     */     }
/* 205 */     if (getOrgCode() != null) {
/* 206 */       buf.append("orgCode").append("=").append(getOrgCode()).append(" ");
/*     */     }
/* 208 */     if (getOrgValue() != null) {
/* 209 */       buf.append("orgValue").append("=").append(getOrgValue()).append(" ");
/*     */     }
/* 211 */     if (getPriority() != null) {
/* 212 */       buf.append("priority").append("=").append(getPriority()).append(" ");
/*     */     }
/* 214 */     if (getShipItemID() != null) {
/* 215 */       buf.append("shipItemID").append("=").append(getShipItemID()).append(" ");
/*     */     }
/* 217 */     if (getAggregationType() != null) {
/* 218 */       buf.append("aggregationType").append("=").append(getAggregationType()).append(" ");
/*     */     }
/* 220 */     if (getRuleType() != null) {
/* 221 */       buf.append("ruleType").append("=").append(getRuleType()).append(" ");
/*     */     }
/* 223 */     if (getParam1() != null) {
/* 224 */       buf.append("param1").append("=").append(getParam1()).append(" ");
/*     */     }
/* 226 */     if (getParam2() != null) {
/* 227 */       buf.append("param2").append("=").append(getParam2()).append(" ");
/*     */     }
/*     */     
/* 230 */     return buf.toString();
/*     */   }
/*     */   
/*     */   public IObjectId getObjectId() {
/* 234 */     ShippingFeeId id = new ShippingFeeId();
/* 235 */     id.setRuleName(getRuleName());
/* 236 */     id.setOrganizationId(getOrganizationId());
/* 237 */     return (IObjectId)id;
/*     */   }
/*     */   
/*     */   public void setObjectId(IObjectId argObjectId) {
/* 241 */     setRuleName(((ShippingFeeId)argObjectId).getRuleName());
/* 242 */     setOrganizationId(((ShippingFeeId)argObjectId).getOrganizationId());
/*     */   }
/*     */   
/*     */   public String getImplementingClass() {
/* 246 */     return null;
/*     */   }
/*     */   
/*     */   public String toXmlString() {
/* 250 */     StringBuilder buf = new StringBuilder(700);
/* 251 */     buf.append("<").append("dao").append(" name=\"ShippingFee\" cmd=\"" + getObjectStateString() + "\">");
/* 252 */     getFieldsAsXml(buf);
/* 253 */     buf.append("</").append("dao").append(">");
/*     */     
/* 255 */     return buf.toString();
/*     */   }
/*     */   
/*     */   public Map<String, String> getValues() {
/* 259 */     Map<String, String> values = super.getValues();
/* 260 */     if (this._ruleName != null) values.put("RuleName", DaoUtils.getXmlSafeFieldValue(12, this._ruleName)); 
/* 261 */     if (this._organizationId != null) values.put("OrganizationId", DaoUtils.getXmlSafeFieldValue(-5, this._organizationId)); 
/* 262 */     if (this._createDate != null) values.put("CreateDate", DaoUtils.getXmlSafeFieldValue(91, this._createDate)); 
/* 263 */     if (this._createUserId != null) values.put("CreateUserId", DaoUtils.getXmlSafeFieldValue(12, this._createUserId)); 
/* 264 */     if (this._updateDate != null) values.put("UpdateDate", DaoUtils.getXmlSafeFieldValue(91, this._updateDate)); 
/* 265 */     if (this._updateUserId != null) values.put("UpdateUserId", DaoUtils.getXmlSafeFieldValue(12, this._updateUserId)); 
/* 266 */     if (this._orgCode != null) values.put("OrgCode", DaoUtils.getXmlSafeFieldValue(12, this._orgCode)); 
/* 267 */     if (this._orgValue != null) values.put("OrgValue", DaoUtils.getXmlSafeFieldValue(12, this._orgValue)); 
/* 268 */     if (this._priority != null) values.put("Priority", DaoUtils.getXmlSafeFieldValue(-5, this._priority)); 
/* 269 */     if (this._shipItemID != null) values.put("ShipItemID", DaoUtils.getXmlSafeFieldValue(12, this._shipItemID)); 
/* 270 */     if (this._aggregationType != null) values.put("AggregationType", DaoUtils.getXmlSafeFieldValue(12, this._aggregationType)); 
/* 271 */     if (this._ruleType != null) values.put("RuleType", DaoUtils.getXmlSafeFieldValue(12, this._ruleType)); 
/* 272 */     if (this._param1 != null) values.put("Param1", DaoUtils.getXmlSafeFieldValue(12, this._param1)); 
/* 273 */     if (this._param2 != null) values.put("Param2", DaoUtils.getXmlSafeFieldValue(12, this._param2)); 
/* 274 */     return values;
/*     */   }
/*     */ 
/*     */   
/*     */   public void setValues(Map<String, String> argValues) {
/* 279 */     super.setValues(argValues);
/* 280 */     for (Map.Entry<String, String> field : argValues.entrySet()) {
/*     */       
/* 282 */       String fieldName = field.getKey();
/* 283 */       String fieldValue = field.getValue();
/* 284 */       switch (fieldName) {
/*     */         
/*     */         case "RuleName":
/*     */           try {
/* 288 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 289 */             setRuleName((String)value);
/* 290 */           } catch (Exception ee) {
/* 291 */             throw new DtxException("An exception occurred while calling setRuleName() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "OrganizationId":
/*     */           try {
/* 297 */             Object value = DaoUtils.getFieldValueForXmlString(-5, fieldValue);
/* 298 */             setOrganizationId((Long)value);
/* 299 */           } catch (Exception ee) {
/* 300 */             throw new DtxException("An exception occurred while calling setOrganizationId() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "CreateDate":
/*     */           try {
/* 306 */             Object value = DaoUtils.getFieldValueForXmlString(91, fieldValue);
/* 307 */             setCreateDate((Date)value);
/* 308 */           } catch (Exception ee) {
/* 309 */             throw new DtxException("An exception occurred while calling setCreateDate() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "CreateUserId":
/*     */           try {
/* 315 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 316 */             setCreateUserId((String)value);
/* 317 */           } catch (Exception ee) {
/* 318 */             throw new DtxException("An exception occurred while calling setCreateUserId() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "UpdateDate":
/*     */           try {
/* 324 */             Object value = DaoUtils.getFieldValueForXmlString(91, fieldValue);
/* 325 */             setUpdateDate((Date)value);
/* 326 */           } catch (Exception ee) {
/* 327 */             throw new DtxException("An exception occurred while calling setUpdateDate() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "UpdateUserId":
/*     */           try {
/* 333 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 334 */             setUpdateUserId((String)value);
/* 335 */           } catch (Exception ee) {
/* 336 */             throw new DtxException("An exception occurred while calling setUpdateUserId() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "OrgCode":
/*     */           try {
/* 342 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 343 */             setOrgCode((String)value);
/* 344 */           } catch (Exception ee) {
/* 345 */             throw new DtxException("An exception occurred while calling setOrgCode() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "OrgValue":
/*     */           try {
/* 351 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 352 */             setOrgValue((String)value);
/* 353 */           } catch (Exception ee) {
/* 354 */             throw new DtxException("An exception occurred while calling setOrgValue() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "Priority":
/*     */           try {
/* 360 */             Object value = DaoUtils.getFieldValueForXmlString(-5, fieldValue);
/* 361 */             setPriority((Long)value);
/* 362 */           } catch (Exception ee) {
/* 363 */             throw new DtxException("An exception occurred while calling setPriority() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "ShipItemID":
/*     */           try {
/* 369 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 370 */             setShipItemID((String)value);
/* 371 */           } catch (Exception ee) {
/* 372 */             throw new DtxException("An exception occurred while calling setShipItemID() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "AggregationType":
/*     */           try {
/* 378 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 379 */             setAggregationType((String)value);
/* 380 */           } catch (Exception ee) {
/* 381 */             throw new DtxException("An exception occurred while calling setAggregationType() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "RuleType":
/*     */           try {
/* 387 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 388 */             setRuleType((String)value);
/* 389 */           } catch (Exception ee) {
/* 390 */             throw new DtxException("An exception occurred while calling setRuleType() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "Param1":
/*     */           try {
/* 396 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 397 */             setParam1((String)value);
/* 398 */           } catch (Exception ee) {
/* 399 */             throw new DtxException("An exception occurred while calling setParam1() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "Param2":
/*     */           try {
/* 405 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 406 */             setParam2((String)value);
/* 407 */           } catch (Exception ee) {
/* 408 */             throw new DtxException("An exception occurred while calling setParam2() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */       } 
/*     */     } 
/*     */   }
/*     */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\com\impl\ShippingFeeDAO.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */