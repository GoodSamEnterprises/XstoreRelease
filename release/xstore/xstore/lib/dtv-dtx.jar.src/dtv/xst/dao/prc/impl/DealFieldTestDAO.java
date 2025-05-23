/*     */ package dtv.xst.dao.prc.impl;
/*     */ 
/*     */ import dtv.data2.access.DaoUtils;
/*     */ import dtv.data2.access.IObjectId;
/*     */ import dtv.data2.access.exception.DtxException;
/*     */ import dtv.data2.access.impl.AbstractDAOImpl;
/*     */ import dtv.util.DtvDate;
/*     */ import dtv.xst.dao.prc.DealFieldTestId;
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
/*     */ public class DealFieldTestDAO
/*     */   extends AbstractDAOImpl
/*     */ {
/*     */   private static final long serialVersionUID = -1604134528L;
/*  23 */   private static final Logger _logger = Logger.getLogger(DealFieldTestDAO.class);
/*     */   
/*     */   private Long _organizationId;
/*     */   private String _dealId;
/*     */   private Integer _ordinal;
/*     */   private Integer _itemConditionGroup;
/*     */   private Integer _itemConditionSeq;
/*     */   private String _orgCode;
/*     */   private String _orgValue;
/*     */   private DtvDate _createDate;
/*     */   private String _createUserId;
/*     */   private DtvDate _updateDate;
/*     */   private String _updateUserId;
/*     */   private String _field;
/*     */   private String _matchRule;
/*     */   private String _value1;
/*     */   private String _value2;
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
/*     */   public String getDealId() {
/*  52 */     return this._dealId;
/*     */   }
/*     */   
/*     */   public void setDealId(String argDealId) {
/*  56 */     if (changed(argDealId, this._dealId, "dealId")) {
/*  57 */       this._dealId = (argDealId != null && MANAGE_CASE) ? argDealId.toUpperCase() : argDealId;
/*     */     }
/*     */   }
/*     */   
/*     */   public Integer getOrdinal() {
/*  62 */     return this._ordinal;
/*     */   }
/*     */   
/*     */   public void setOrdinal(Integer argOrdinal) {
/*  66 */     if (changed(argOrdinal, this._ordinal, "ordinal")) {
/*  67 */       this._ordinal = argOrdinal;
/*     */     }
/*     */   }
/*     */   
/*     */   public Integer getItemConditionGroup() {
/*  72 */     return this._itemConditionGroup;
/*     */   }
/*     */   
/*     */   public void setItemConditionGroup(Integer argItemConditionGroup) {
/*  76 */     if (changed(argItemConditionGroup, this._itemConditionGroup, "itemConditionGroup")) {
/*  77 */       this._itemConditionGroup = argItemConditionGroup;
/*     */     }
/*     */   }
/*     */   
/*     */   public Integer getItemConditionSeq() {
/*  82 */     return this._itemConditionSeq;
/*     */   }
/*     */   
/*     */   public void setItemConditionSeq(Integer argItemConditionSeq) {
/*  86 */     if (changed(argItemConditionSeq, this._itemConditionSeq, "itemConditionSeq")) {
/*  87 */       this._itemConditionSeq = argItemConditionSeq;
/*     */     }
/*     */   }
/*     */   
/*     */   public String getOrgCode() {
/*  92 */     return this._orgCode;
/*     */   }
/*     */   
/*     */   public void setOrgCode(String argOrgCode) {
/*  96 */     if (changed(argOrgCode, this._orgCode, "orgCode")) {
/*  97 */       this._orgCode = argOrgCode;
/*     */     }
/*     */   }
/*     */   
/*     */   public String getOrgValue() {
/* 102 */     return this._orgValue;
/*     */   }
/*     */   
/*     */   public void setOrgValue(String argOrgValue) {
/* 106 */     if (changed(argOrgValue, this._orgValue, "orgValue")) {
/* 107 */       this._orgValue = argOrgValue;
/*     */     }
/*     */   }
/*     */   
/*     */   public Date getCreateDate() {
/* 112 */     return (Date)this._createDate;
/*     */   }
/*     */   
/*     */   public void setCreateDate(Date argCreateDate) {
/* 116 */     if (changed(argCreateDate, this._createDate, "createDate")) {
/* 117 */       this._createDate = (argCreateDate == null || argCreateDate instanceof DtvDate) ? (DtvDate)argCreateDate : new DtvDate(argCreateDate);
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public String getCreateUserId() {
/* 123 */     return this._createUserId;
/*     */   }
/*     */   
/*     */   public void setCreateUserId(String argCreateUserId) {
/* 127 */     if (changed(argCreateUserId, this._createUserId, "createUserId")) {
/* 128 */       this._createUserId = argCreateUserId;
/*     */     }
/*     */   }
/*     */   
/*     */   public Date getUpdateDate() {
/* 133 */     return (Date)this._updateDate;
/*     */   }
/*     */   
/*     */   public void setUpdateDate(Date argUpdateDate) {
/* 137 */     if (changed(argUpdateDate, this._updateDate, "updateDate")) {
/* 138 */       this._updateDate = (argUpdateDate == null || argUpdateDate instanceof DtvDate) ? (DtvDate)argUpdateDate : new DtvDate(argUpdateDate);
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public String getUpdateUserId() {
/* 144 */     return this._updateUserId;
/*     */   }
/*     */   
/*     */   public void setUpdateUserId(String argUpdateUserId) {
/* 148 */     if (changed(argUpdateUserId, this._updateUserId, "updateUserId")) {
/* 149 */       this._updateUserId = argUpdateUserId;
/*     */     }
/*     */   }
/*     */   
/*     */   public String getField() {
/* 154 */     return this._field;
/*     */   }
/*     */   
/*     */   public void setField(String argField) {
/* 158 */     if (changed(argField, this._field, "field")) {
/* 159 */       this._field = argField;
/*     */     }
/*     */   }
/*     */   
/*     */   public String getMatchRule() {
/* 164 */     return this._matchRule;
/*     */   }
/*     */   
/*     */   public void setMatchRule(String argMatchRule) {
/* 168 */     if (changed(argMatchRule, this._matchRule, "matchRule")) {
/* 169 */       this._matchRule = argMatchRule;
/*     */     }
/*     */   }
/*     */   
/*     */   public String getValue1() {
/* 174 */     return this._value1;
/*     */   }
/*     */   
/*     */   public void setValue1(String argValue1) {
/* 178 */     if (changed(argValue1, this._value1, "value1")) {
/* 179 */       this._value1 = argValue1;
/*     */     }
/*     */   }
/*     */   
/*     */   public String getValue2() {
/* 184 */     return this._value2;
/*     */   }
/*     */   
/*     */   public void setValue2(String argValue2) {
/* 188 */     if (changed(argValue2, this._value2, "value2")) {
/* 189 */       this._value2 = argValue2;
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
/* 201 */     if (getDealId() != null) {
/* 202 */       buf.append("dealId").append("=").append(getDealId()).append(" ");
/*     */     }
/* 204 */     if (getOrdinal() != null) {
/* 205 */       buf.append("ordinal").append("=").append(getOrdinal()).append(" ");
/*     */     }
/* 207 */     if (getItemConditionGroup() != null) {
/* 208 */       buf.append("itemConditionGroup").append("=").append(getItemConditionGroup()).append(" ");
/*     */     }
/* 210 */     if (getItemConditionSeq() != null) {
/* 211 */       buf.append("itemConditionSeq").append("=").append(getItemConditionSeq()).append(" ");
/*     */     }
/* 213 */     if (getOrgCode() != null) {
/* 214 */       buf.append("orgCode").append("=").append(getOrgCode()).append(" ");
/*     */     }
/* 216 */     if (getOrgValue() != null) {
/* 217 */       buf.append("orgValue").append("=").append(getOrgValue()).append(" ");
/*     */     }
/* 219 */     if (getCreateDate() != null) {
/* 220 */       buf.append("createDate").append("=").append(getCreateDate()).append(" ");
/*     */     }
/* 222 */     if (getCreateUserId() != null) {
/* 223 */       buf.append("createUserId").append("=").append(getCreateUserId()).append(" ");
/*     */     }
/* 225 */     if (getUpdateDate() != null) {
/* 226 */       buf.append("updateDate").append("=").append(getUpdateDate()).append(" ");
/*     */     }
/* 228 */     if (getUpdateUserId() != null) {
/* 229 */       buf.append("updateUserId").append("=").append(getUpdateUserId()).append(" ");
/*     */     }
/* 231 */     if (getField() != null) {
/* 232 */       buf.append("field").append("=").append(getField()).append(" ");
/*     */     }
/* 234 */     if (getMatchRule() != null) {
/* 235 */       buf.append("matchRule").append("=").append(getMatchRule()).append(" ");
/*     */     }
/* 237 */     if (getValue1() != null) {
/* 238 */       buf.append("value1").append("=").append(getValue1()).append(" ");
/*     */     }
/* 240 */     if (getValue2() != null) {
/* 241 */       buf.append("value2").append("=").append(getValue2()).append(" ");
/*     */     }
/*     */     
/* 244 */     return buf.toString();
/*     */   }
/*     */   
/*     */   public IObjectId getObjectId() {
/* 248 */     DealFieldTestId id = new DealFieldTestId();
/* 249 */     id.setOrganizationId(getOrganizationId());
/* 250 */     id.setDealId(getDealId());
/* 251 */     id.setOrdinal(getOrdinal());
/* 252 */     id.setItemConditionGroup(getItemConditionGroup());
/* 253 */     id.setItemConditionSeq(getItemConditionSeq());
/* 254 */     return (IObjectId)id;
/*     */   }
/*     */   
/*     */   public void setObjectId(IObjectId argObjectId) {
/* 258 */     setOrganizationId(((DealFieldTestId)argObjectId).getOrganizationId());
/* 259 */     setDealId(((DealFieldTestId)argObjectId).getDealId());
/* 260 */     setOrdinal(((DealFieldTestId)argObjectId).getOrdinal());
/* 261 */     setItemConditionGroup(((DealFieldTestId)argObjectId).getItemConditionGroup());
/* 262 */     setItemConditionSeq(((DealFieldTestId)argObjectId).getItemConditionSeq());
/*     */   }
/*     */   
/*     */   public String getImplementingClass() {
/* 266 */     return null;
/*     */   }
/*     */   
/*     */   public String toXmlString() {
/* 270 */     StringBuilder buf = new StringBuilder(750);
/* 271 */     buf.append("<").append("dao").append(" name=\"DealFieldTest\" cmd=\"" + getObjectStateString() + "\">");
/* 272 */     getFieldsAsXml(buf);
/* 273 */     buf.append("</").append("dao").append(">");
/*     */     
/* 275 */     return buf.toString();
/*     */   }
/*     */   
/*     */   public Map<String, String> getValues() {
/* 279 */     Map<String, String> values = super.getValues();
/* 280 */     if (this._organizationId != null) values.put("OrganizationId", DaoUtils.getXmlSafeFieldValue(-5, this._organizationId)); 
/* 281 */     if (this._dealId != null) values.put("DealId", DaoUtils.getXmlSafeFieldValue(12, this._dealId)); 
/* 282 */     if (this._ordinal != null) values.put("Ordinal", DaoUtils.getXmlSafeFieldValue(4, this._ordinal)); 
/* 283 */     if (this._itemConditionGroup != null) values.put("ItemConditionGroup", DaoUtils.getXmlSafeFieldValue(4, this._itemConditionGroup)); 
/* 284 */     if (this._itemConditionSeq != null) values.put("ItemConditionSeq", DaoUtils.getXmlSafeFieldValue(4, this._itemConditionSeq)); 
/* 285 */     if (this._orgCode != null) values.put("OrgCode", DaoUtils.getXmlSafeFieldValue(12, this._orgCode)); 
/* 286 */     if (this._orgValue != null) values.put("OrgValue", DaoUtils.getXmlSafeFieldValue(12, this._orgValue)); 
/* 287 */     if (this._createDate != null) values.put("CreateDate", DaoUtils.getXmlSafeFieldValue(91, this._createDate)); 
/* 288 */     if (this._createUserId != null) values.put("CreateUserId", DaoUtils.getXmlSafeFieldValue(12, this._createUserId)); 
/* 289 */     if (this._updateDate != null) values.put("UpdateDate", DaoUtils.getXmlSafeFieldValue(91, this._updateDate)); 
/* 290 */     if (this._updateUserId != null) values.put("UpdateUserId", DaoUtils.getXmlSafeFieldValue(12, this._updateUserId)); 
/* 291 */     if (this._field != null) values.put("Field", DaoUtils.getXmlSafeFieldValue(12, this._field)); 
/* 292 */     if (this._matchRule != null) values.put("MatchRule", DaoUtils.getXmlSafeFieldValue(12, this._matchRule)); 
/* 293 */     if (this._value1 != null) values.put("Value1", DaoUtils.getXmlSafeFieldValue(12, this._value1)); 
/* 294 */     if (this._value2 != null) values.put("Value2", DaoUtils.getXmlSafeFieldValue(12, this._value2)); 
/* 295 */     return values;
/*     */   }
/*     */ 
/*     */   
/*     */   public void setValues(Map<String, String> argValues) {
/* 300 */     super.setValues(argValues);
/* 301 */     for (Map.Entry<String, String> field : argValues.entrySet()) {
/*     */       
/* 303 */       String fieldName = field.getKey();
/* 304 */       String fieldValue = field.getValue();
/* 305 */       switch (fieldName) {
/*     */         
/*     */         case "OrganizationId":
/*     */           try {
/* 309 */             Object value = DaoUtils.getFieldValueForXmlString(-5, fieldValue);
/* 310 */             setOrganizationId((Long)value);
/* 311 */           } catch (Exception ee) {
/* 312 */             throw new DtxException("An exception occurred while calling setOrganizationId() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "DealId":
/*     */           try {
/* 318 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 319 */             setDealId((String)value);
/* 320 */           } catch (Exception ee) {
/* 321 */             throw new DtxException("An exception occurred while calling setDealId() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "Ordinal":
/*     */           try {
/* 327 */             Object value = DaoUtils.getFieldValueForXmlString(4, fieldValue);
/* 328 */             setOrdinal((Integer)value);
/* 329 */           } catch (Exception ee) {
/* 330 */             throw new DtxException("An exception occurred while calling setOrdinal() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "ItemConditionGroup":
/*     */           try {
/* 336 */             Object value = DaoUtils.getFieldValueForXmlString(4, fieldValue);
/* 337 */             setItemConditionGroup((Integer)value);
/* 338 */           } catch (Exception ee) {
/* 339 */             throw new DtxException("An exception occurred while calling setItemConditionGroup() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "ItemConditionSeq":
/*     */           try {
/* 345 */             Object value = DaoUtils.getFieldValueForXmlString(4, fieldValue);
/* 346 */             setItemConditionSeq((Integer)value);
/* 347 */           } catch (Exception ee) {
/* 348 */             throw new DtxException("An exception occurred while calling setItemConditionSeq() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "OrgCode":
/*     */           try {
/* 354 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 355 */             setOrgCode((String)value);
/* 356 */           } catch (Exception ee) {
/* 357 */             throw new DtxException("An exception occurred while calling setOrgCode() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "OrgValue":
/*     */           try {
/* 363 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 364 */             setOrgValue((String)value);
/* 365 */           } catch (Exception ee) {
/* 366 */             throw new DtxException("An exception occurred while calling setOrgValue() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "CreateDate":
/*     */           try {
/* 372 */             Object value = DaoUtils.getFieldValueForXmlString(91, fieldValue);
/* 373 */             setCreateDate((Date)value);
/* 374 */           } catch (Exception ee) {
/* 375 */             throw new DtxException("An exception occurred while calling setCreateDate() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "CreateUserId":
/*     */           try {
/* 381 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 382 */             setCreateUserId((String)value);
/* 383 */           } catch (Exception ee) {
/* 384 */             throw new DtxException("An exception occurred while calling setCreateUserId() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "UpdateDate":
/*     */           try {
/* 390 */             Object value = DaoUtils.getFieldValueForXmlString(91, fieldValue);
/* 391 */             setUpdateDate((Date)value);
/* 392 */           } catch (Exception ee) {
/* 393 */             throw new DtxException("An exception occurred while calling setUpdateDate() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "UpdateUserId":
/*     */           try {
/* 399 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 400 */             setUpdateUserId((String)value);
/* 401 */           } catch (Exception ee) {
/* 402 */             throw new DtxException("An exception occurred while calling setUpdateUserId() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "Field":
/*     */           try {
/* 408 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 409 */             setField((String)value);
/* 410 */           } catch (Exception ee) {
/* 411 */             throw new DtxException("An exception occurred while calling setField() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "MatchRule":
/*     */           try {
/* 417 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 418 */             setMatchRule((String)value);
/* 419 */           } catch (Exception ee) {
/* 420 */             throw new DtxException("An exception occurred while calling setMatchRule() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "Value1":
/*     */           try {
/* 426 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 427 */             setValue1((String)value);
/* 428 */           } catch (Exception ee) {
/* 429 */             throw new DtxException("An exception occurred while calling setValue1() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "Value2":
/*     */           try {
/* 435 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 436 */             setValue2((String)value);
/* 437 */           } catch (Exception ee) {
/* 438 */             throw new DtxException("An exception occurred while calling setValue2() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */       } 
/*     */     } 
/*     */   }
/*     */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\prc\impl\DealFieldTestDAO.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */