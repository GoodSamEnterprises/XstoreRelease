/*     */ package dtv.xst.dao.tnd.impl;
/*     */ 
/*     */ import dtv.data2.access.DaoUtils;
/*     */ import dtv.data2.access.IHasConfigElement;
/*     */ import dtv.data2.access.IObjectId;
/*     */ import dtv.data2.access.exception.DtxException;
/*     */ import dtv.data2.access.impl.AbstractDAOImpl;
/*     */ import dtv.util.DtvDate;
/*     */ import dtv.xst.dao.tnd.TenderUserSettingsPropertyId;
/*     */ import java.math.BigDecimal;
/*     */ import java.util.Date;
/*     */ import java.util.Map;
/*     */ import org.apache.log4j.Logger;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class TenderUserSettingsPropertyDAO
/*     */   extends AbstractDAOImpl
/*     */   implements IHasConfigElement
/*     */ {
/*     */   private static final long serialVersionUID = 1267758615L;
/*  23 */   private static final Logger _logger = Logger.getLogger(TenderUserSettingsPropertyDAO.class);
/*     */   
/*     */   private String _groupId;
/*     */   private Long _organizationId;
/*     */   private String _tenderId;
/*     */   private String _usageCode;
/*     */   private String _entryMethodCode;
/*     */   private String _configElement;
/*     */   private String _propertyCode;
/*     */   private String _type;
/*     */   private String _stringValue;
/*     */   private DtvDate _dateValue;
/*     */   private BigDecimal _decimalValue;
/*     */   private DtvDate _createDate;
/*     */   private String _createUserId;
/*     */   private DtvDate _updateDate;
/*     */   private String _updateUserId;
/*     */   
/*     */   public String getGroupId() {
/*  42 */     return this._groupId;
/*     */   }
/*     */   
/*     */   public void setGroupId(String argGroupId) {
/*  46 */     if (changed(argGroupId, this._groupId, "groupId")) {
/*  47 */       this._groupId = (argGroupId != null && MANAGE_CASE) ? argGroupId.toUpperCase() : argGroupId;
/*     */     }
/*     */   }
/*     */   
/*     */   public Long getOrganizationId() {
/*  52 */     return this._organizationId;
/*     */   }
/*     */   
/*     */   public void setOrganizationId(Long argOrganizationId) {
/*  56 */     if (changed(argOrganizationId, this._organizationId, "organizationId")) {
/*  57 */       this._organizationId = argOrganizationId;
/*     */     }
/*     */   }
/*     */   
/*     */   public String getTenderId() {
/*  62 */     return this._tenderId;
/*     */   }
/*     */   
/*     */   public void setTenderId(String argTenderId) {
/*  66 */     if (changed(argTenderId, this._tenderId, "tenderId")) {
/*  67 */       this._tenderId = (argTenderId != null && MANAGE_CASE) ? argTenderId.toUpperCase() : argTenderId;
/*     */     }
/*     */   }
/*     */   
/*     */   public String getUsageCode() {
/*  72 */     return this._usageCode;
/*     */   }
/*     */   
/*     */   public void setUsageCode(String argUsageCode) {
/*  76 */     if (changed(argUsageCode, this._usageCode, "usageCode")) {
/*  77 */       this._usageCode = (argUsageCode != null && MANAGE_CASE) ? argUsageCode.toUpperCase() : argUsageCode;
/*     */     }
/*     */   }
/*     */   
/*     */   public String getEntryMethodCode() {
/*  82 */     return this._entryMethodCode;
/*     */   }
/*     */   
/*     */   public void setEntryMethodCode(String argEntryMethodCode) {
/*  86 */     if (changed(argEntryMethodCode, this._entryMethodCode, "entryMethodCode")) {
/*  87 */       this._entryMethodCode = (argEntryMethodCode != null && MANAGE_CASE) ? argEntryMethodCode.toUpperCase() : argEntryMethodCode;
/*     */     }
/*     */   }
/*     */   
/*     */   public String getConfigElement() {
/*  92 */     return this._configElement;
/*     */   }
/*     */   
/*     */   public void setConfigElement(String argConfigElement) {
/*  96 */     if (changed(argConfigElement, this._configElement, "configElement")) {
/*  97 */       this._configElement = (argConfigElement != null && MANAGE_CASE) ? argConfigElement.toUpperCase() : argConfigElement;
/*     */     }
/*     */   }
/*     */   
/*     */   public String getPropertyCode() {
/* 102 */     return this._propertyCode;
/*     */   }
/*     */   
/*     */   public void setPropertyCode(String argPropertyCode) {
/* 106 */     if (changed(argPropertyCode, this._propertyCode, "propertyCode")) {
/* 107 */       this._propertyCode = (argPropertyCode != null && MANAGE_CASE) ? argPropertyCode.toUpperCase() : argPropertyCode;
/*     */     }
/*     */   }
/*     */   
/*     */   public String getType() {
/* 112 */     return this._type;
/*     */   }
/*     */   
/*     */   public void setType(String argType) {
/* 116 */     if (changed(argType, this._type, "type")) {
/* 117 */       this._type = argType;
/*     */     }
/*     */   }
/*     */   
/*     */   public String getStringValue() {
/* 122 */     return this._stringValue;
/*     */   }
/*     */   
/*     */   public void setStringValue(String argStringValue) {
/* 126 */     if (changed(argStringValue, this._stringValue, "stringValue")) {
/* 127 */       this._stringValue = argStringValue;
/*     */     }
/*     */   }
/*     */   
/*     */   public Date getDateValue() {
/* 132 */     return (Date)this._dateValue;
/*     */   }
/*     */   
/*     */   public void setDateValue(Date argDateValue) {
/* 136 */     if (changed(argDateValue, this._dateValue, "dateValue")) {
/* 137 */       this._dateValue = (argDateValue == null || argDateValue instanceof DtvDate) ? (DtvDate)argDateValue : new DtvDate(argDateValue);
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public BigDecimal getDecimalValue() {
/* 143 */     return this._decimalValue;
/*     */   }
/*     */   
/*     */   public void setDecimalValue(BigDecimal argDecimalValue) {
/* 147 */     if (changed(argDecimalValue, this._decimalValue, "decimalValue")) {
/* 148 */       this._decimalValue = argDecimalValue;
/*     */     }
/*     */   }
/*     */   
/*     */   public Date getCreateDate() {
/* 153 */     return (Date)this._createDate;
/*     */   }
/*     */   
/*     */   public void setCreateDate(Date argCreateDate) {
/* 157 */     if (changed(argCreateDate, this._createDate, "createDate")) {
/* 158 */       this._createDate = (argCreateDate == null || argCreateDate instanceof DtvDate) ? (DtvDate)argCreateDate : new DtvDate(argCreateDate);
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public String getCreateUserId() {
/* 164 */     return this._createUserId;
/*     */   }
/*     */   
/*     */   public void setCreateUserId(String argCreateUserId) {
/* 168 */     if (changed(argCreateUserId, this._createUserId, "createUserId")) {
/* 169 */       this._createUserId = argCreateUserId;
/*     */     }
/*     */   }
/*     */   
/*     */   public Date getUpdateDate() {
/* 174 */     return (Date)this._updateDate;
/*     */   }
/*     */   
/*     */   public void setUpdateDate(Date argUpdateDate) {
/* 178 */     if (changed(argUpdateDate, this._updateDate, "updateDate")) {
/* 179 */       this._updateDate = (argUpdateDate == null || argUpdateDate instanceof DtvDate) ? (DtvDate)argUpdateDate : new DtvDate(argUpdateDate);
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public String getUpdateUserId() {
/* 185 */     return this._updateUserId;
/*     */   }
/*     */   
/*     */   public void setUpdateUserId(String argUpdateUserId) {
/* 189 */     if (changed(argUpdateUserId, this._updateUserId, "updateUserId")) {
/* 190 */       this._updateUserId = argUpdateUserId;
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public String toString() {
/* 197 */     StringBuilder buf = new StringBuilder(512);
/* 198 */     buf.append(super.toString()).append(" Id: ").append(getObjectId()).append(" Values: ");
/* 199 */     if (getGroupId() != null) {
/* 200 */       buf.append("groupId").append("=").append(getGroupId()).append(" ");
/*     */     }
/* 202 */     if (getOrganizationId() != null) {
/* 203 */       buf.append("organizationId").append("=").append(getOrganizationId()).append(" ");
/*     */     }
/* 205 */     if (getTenderId() != null) {
/* 206 */       buf.append("tenderId").append("=").append(getTenderId()).append(" ");
/*     */     }
/* 208 */     if (getUsageCode() != null) {
/* 209 */       buf.append("usageCode").append("=").append(getUsageCode()).append(" ");
/*     */     }
/* 211 */     if (getEntryMethodCode() != null) {
/* 212 */       buf.append("entryMethodCode").append("=").append(getEntryMethodCode()).append(" ");
/*     */     }
/* 214 */     if (getConfigElement() != null) {
/* 215 */       buf.append("configElement").append("=").append(getConfigElement()).append(" ");
/*     */     }
/* 217 */     if (getPropertyCode() != null) {
/* 218 */       buf.append("propertyCode").append("=").append(getPropertyCode()).append(" ");
/*     */     }
/* 220 */     if (getType() != null) {
/* 221 */       buf.append("type").append("=").append(getType()).append(" ");
/*     */     }
/* 223 */     if (getStringValue() != null) {
/* 224 */       buf.append("stringValue").append("=").append(getStringValue()).append(" ");
/*     */     }
/* 226 */     if (getDateValue() != null) {
/* 227 */       buf.append("dateValue").append("=").append(getDateValue()).append(" ");
/*     */     }
/* 229 */     if (getDecimalValue() != null) {
/* 230 */       buf.append("decimalValue").append("=").append(getDecimalValue()).append(" ");
/*     */     }
/* 232 */     if (getCreateDate() != null) {
/* 233 */       buf.append("createDate").append("=").append(getCreateDate()).append(" ");
/*     */     }
/* 235 */     if (getCreateUserId() != null) {
/* 236 */       buf.append("createUserId").append("=").append(getCreateUserId()).append(" ");
/*     */     }
/* 238 */     if (getUpdateDate() != null) {
/* 239 */       buf.append("updateDate").append("=").append(getUpdateDate()).append(" ");
/*     */     }
/* 241 */     if (getUpdateUserId() != null) {
/* 242 */       buf.append("updateUserId").append("=").append(getUpdateUserId()).append(" ");
/*     */     }
/*     */     
/* 245 */     return buf.toString();
/*     */   }
/*     */   
/*     */   public IObjectId getObjectId() {
/* 249 */     TenderUserSettingsPropertyId id = new TenderUserSettingsPropertyId();
/* 250 */     id.setGroupId(getGroupId());
/* 251 */     id.setOrganizationId(getOrganizationId());
/* 252 */     id.setTenderId(getTenderId());
/* 253 */     id.setUsageCode(getUsageCode());
/* 254 */     id.setEntryMethodCode(getEntryMethodCode());
/* 255 */     id.setConfigElement(getConfigElement());
/* 256 */     id.setPropertyCode(getPropertyCode());
/* 257 */     return (IObjectId)id;
/*     */   }
/*     */   
/*     */   public void setObjectId(IObjectId argObjectId) {
/* 261 */     setGroupId(((TenderUserSettingsPropertyId)argObjectId).getGroupId());
/* 262 */     setOrganizationId(((TenderUserSettingsPropertyId)argObjectId).getOrganizationId());
/* 263 */     setTenderId(((TenderUserSettingsPropertyId)argObjectId).getTenderId());
/* 264 */     setUsageCode(((TenderUserSettingsPropertyId)argObjectId).getUsageCode());
/* 265 */     setEntryMethodCode(((TenderUserSettingsPropertyId)argObjectId).getEntryMethodCode());
/* 266 */     setConfigElement(((TenderUserSettingsPropertyId)argObjectId).getConfigElement());
/* 267 */     setPropertyCode(((TenderUserSettingsPropertyId)argObjectId).getPropertyCode());
/*     */   }
/*     */   
/*     */   public String getImplementingClass() {
/* 271 */     return null;
/*     */   }
/*     */   
/*     */   public String toXmlString() {
/* 275 */     StringBuilder buf = new StringBuilder(750);
/* 276 */     buf.append("<").append("dao").append(" name=\"TenderUserSettingsProperty\" cmd=\"" + getObjectStateString() + "\">");
/* 277 */     getFieldsAsXml(buf);
/* 278 */     buf.append("</").append("dao").append(">");
/*     */     
/* 280 */     return buf.toString();
/*     */   }
/*     */   
/*     */   public Map<String, String> getValues() {
/* 284 */     Map<String, String> values = super.getValues();
/* 285 */     if (this._groupId != null) values.put("GroupId", DaoUtils.getXmlSafeFieldValue(12, this._groupId)); 
/* 286 */     if (this._organizationId != null) values.put("OrganizationId", DaoUtils.getXmlSafeFieldValue(-5, this._organizationId)); 
/* 287 */     if (this._tenderId != null) values.put("TenderId", DaoUtils.getXmlSafeFieldValue(12, this._tenderId)); 
/* 288 */     if (this._usageCode != null) values.put("UsageCode", DaoUtils.getXmlSafeFieldValue(12, this._usageCode)); 
/* 289 */     if (this._entryMethodCode != null) values.put("EntryMethodCode", DaoUtils.getXmlSafeFieldValue(12, this._entryMethodCode)); 
/* 290 */     if (this._configElement != null) values.put("ConfigElement", DaoUtils.getXmlSafeFieldValue(12, this._configElement)); 
/* 291 */     if (this._propertyCode != null) values.put("PropertyCode", DaoUtils.getXmlSafeFieldValue(12, this._propertyCode)); 
/* 292 */     if (this._type != null) values.put("Type", DaoUtils.getXmlSafeFieldValue(12, this._type)); 
/* 293 */     if (this._stringValue != null) values.put("StringValue", DaoUtils.getXmlSafeFieldValue(12, this._stringValue)); 
/* 294 */     if (this._dateValue != null) values.put("DateValue", DaoUtils.getXmlSafeFieldValue(91, this._dateValue)); 
/* 295 */     if (this._decimalValue != null) values.put("DecimalValue", DaoUtils.getXmlSafeFieldValue(3, this._decimalValue)); 
/* 296 */     if (this._createDate != null) values.put("CreateDate", DaoUtils.getXmlSafeFieldValue(91, this._createDate)); 
/* 297 */     if (this._createUserId != null) values.put("CreateUserId", DaoUtils.getXmlSafeFieldValue(12, this._createUserId)); 
/* 298 */     if (this._updateDate != null) values.put("UpdateDate", DaoUtils.getXmlSafeFieldValue(91, this._updateDate)); 
/* 299 */     if (this._updateUserId != null) values.put("UpdateUserId", DaoUtils.getXmlSafeFieldValue(12, this._updateUserId)); 
/* 300 */     return values;
/*     */   }
/*     */ 
/*     */   
/*     */   public void setValues(Map<String, String> argValues) {
/* 305 */     super.setValues(argValues);
/* 306 */     for (Map.Entry<String, String> field : argValues.entrySet()) {
/*     */       
/* 308 */       String fieldName = field.getKey();
/* 309 */       String fieldValue = field.getValue();
/* 310 */       switch (fieldName) {
/*     */         
/*     */         case "GroupId":
/*     */           try {
/* 314 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 315 */             setGroupId((String)value);
/* 316 */           } catch (Exception ee) {
/* 317 */             throw new DtxException("An exception occurred while calling setGroupId() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "OrganizationId":
/*     */           try {
/* 323 */             Object value = DaoUtils.getFieldValueForXmlString(-5, fieldValue);
/* 324 */             setOrganizationId((Long)value);
/* 325 */           } catch (Exception ee) {
/* 326 */             throw new DtxException("An exception occurred while calling setOrganizationId() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "TenderId":
/*     */           try {
/* 332 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 333 */             setTenderId((String)value);
/* 334 */           } catch (Exception ee) {
/* 335 */             throw new DtxException("An exception occurred while calling setTenderId() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "UsageCode":
/*     */           try {
/* 341 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 342 */             setUsageCode((String)value);
/* 343 */           } catch (Exception ee) {
/* 344 */             throw new DtxException("An exception occurred while calling setUsageCode() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "EntryMethodCode":
/*     */           try {
/* 350 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 351 */             setEntryMethodCode((String)value);
/* 352 */           } catch (Exception ee) {
/* 353 */             throw new DtxException("An exception occurred while calling setEntryMethodCode() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "ConfigElement":
/*     */           try {
/* 359 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 360 */             setConfigElement((String)value);
/* 361 */           } catch (Exception ee) {
/* 362 */             throw new DtxException("An exception occurred while calling setConfigElement() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "PropertyCode":
/*     */           try {
/* 368 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 369 */             setPropertyCode((String)value);
/* 370 */           } catch (Exception ee) {
/* 371 */             throw new DtxException("An exception occurred while calling setPropertyCode() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "Type":
/*     */           try {
/* 377 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 378 */             setType((String)value);
/* 379 */           } catch (Exception ee) {
/* 380 */             throw new DtxException("An exception occurred while calling setType() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "StringValue":
/*     */           try {
/* 386 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 387 */             setStringValue((String)value);
/* 388 */           } catch (Exception ee) {
/* 389 */             throw new DtxException("An exception occurred while calling setStringValue() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "DateValue":
/*     */           try {
/* 395 */             Object value = DaoUtils.getFieldValueForXmlString(91, fieldValue);
/* 396 */             setDateValue((Date)value);
/* 397 */           } catch (Exception ee) {
/* 398 */             throw new DtxException("An exception occurred while calling setDateValue() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "DecimalValue":
/*     */           try {
/* 404 */             Object value = DaoUtils.getFieldValueForXmlString(3, fieldValue);
/* 405 */             setDecimalValue((BigDecimal)value);
/* 406 */           } catch (Exception ee) {
/* 407 */             throw new DtxException("An exception occurred while calling setDecimalValue() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "CreateDate":
/*     */           try {
/* 413 */             Object value = DaoUtils.getFieldValueForXmlString(91, fieldValue);
/* 414 */             setCreateDate((Date)value);
/* 415 */           } catch (Exception ee) {
/* 416 */             throw new DtxException("An exception occurred while calling setCreateDate() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "CreateUserId":
/*     */           try {
/* 422 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 423 */             setCreateUserId((String)value);
/* 424 */           } catch (Exception ee) {
/* 425 */             throw new DtxException("An exception occurred while calling setCreateUserId() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "UpdateDate":
/*     */           try {
/* 431 */             Object value = DaoUtils.getFieldValueForXmlString(91, fieldValue);
/* 432 */             setUpdateDate((Date)value);
/* 433 */           } catch (Exception ee) {
/* 434 */             throw new DtxException("An exception occurred while calling setUpdateDate() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "UpdateUserId":
/*     */           try {
/* 440 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 441 */             setUpdateUserId((String)value);
/* 442 */           } catch (Exception ee) {
/* 443 */             throw new DtxException("An exception occurred while calling setUpdateUserId() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */       } 
/*     */     } 
/*     */   }
/*     */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\tnd\impl\TenderUserSettingsPropertyDAO.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */