/*     */ package dtv.xst.dao.tax.impl;
/*     */ 
/*     */ import dtv.data2.access.DaoUtils;
/*     */ import dtv.data2.access.IObjectId;
/*     */ import dtv.data2.access.exception.DtxException;
/*     */ import dtv.data2.access.impl.AbstractDAOImpl;
/*     */ import dtv.util.DtvDate;
/*     */ import dtv.xst.dao.tax.TaxGroupRuleId;
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
/*     */ public class TaxGroupRuleDAO
/*     */   extends AbstractDAOImpl
/*     */ {
/*     */   private static final long serialVersionUID = -1838428464L;
/*  23 */   private static final Logger _logger = Logger.getLogger(TaxGroupRuleDAO.class);
/*     */   
/*     */   private Long _organizationId;
/*     */   private String _taxGroupId;
/*     */   private String _taxLocationId;
/*     */   private Integer _taxRuleSequence;
/*     */   private DtvDate _createDate;
/*     */   private String _createUserId;
/*     */   private DtvDate _updateDate;
/*     */   private String _updateUserId;
/*     */   private String _orgCode;
/*     */   private String _orgValue;
/*  35 */   private Boolean _compound = Boolean.FALSE;
/*     */   private Integer _compoundSequence;
/*     */   private String _description;
/*     */   private String _name;
/*     */   private String _taxTypeCode;
/*  40 */   private Boolean _taxedAtTransLevel = Boolean.FALSE;
/*     */   private String _taxAuthorityId;
/*     */   private String _externalSystem;
/*     */   
/*     */   public Long getOrganizationId() {
/*  45 */     return this._organizationId;
/*     */   }
/*     */   
/*     */   public void setOrganizationId(Long argOrganizationId) {
/*  49 */     if (changed(argOrganizationId, this._organizationId, "organizationId")) {
/*  50 */       this._organizationId = argOrganizationId;
/*     */     }
/*     */   }
/*     */   
/*     */   public String getTaxGroupId() {
/*  55 */     return this._taxGroupId;
/*     */   }
/*     */   
/*     */   public void setTaxGroupId(String argTaxGroupId) {
/*  59 */     if (changed(argTaxGroupId, this._taxGroupId, "taxGroupId")) {
/*  60 */       this._taxGroupId = (argTaxGroupId != null && MANAGE_CASE) ? argTaxGroupId.toUpperCase() : argTaxGroupId;
/*     */     }
/*     */   }
/*     */   
/*     */   public String getTaxLocationId() {
/*  65 */     return this._taxLocationId;
/*     */   }
/*     */   
/*     */   public void setTaxLocationId(String argTaxLocationId) {
/*  69 */     if (changed(argTaxLocationId, this._taxLocationId, "taxLocationId")) {
/*  70 */       this._taxLocationId = (argTaxLocationId != null && MANAGE_CASE) ? argTaxLocationId.toUpperCase() : argTaxLocationId;
/*     */     }
/*     */   }
/*     */   
/*     */   public Integer getTaxRuleSequence() {
/*  75 */     return this._taxRuleSequence;
/*     */   }
/*     */   
/*     */   public void setTaxRuleSequence(Integer argTaxRuleSequence) {
/*  79 */     if (changed(argTaxRuleSequence, this._taxRuleSequence, "taxRuleSequence")) {
/*  80 */       this._taxRuleSequence = argTaxRuleSequence;
/*     */     }
/*     */   }
/*     */   
/*     */   public Date getCreateDate() {
/*  85 */     return (Date)this._createDate;
/*     */   }
/*     */   
/*     */   public void setCreateDate(Date argCreateDate) {
/*  89 */     if (changed(argCreateDate, this._createDate, "createDate")) {
/*  90 */       this._createDate = (argCreateDate == null || argCreateDate instanceof DtvDate) ? (DtvDate)argCreateDate : new DtvDate(argCreateDate);
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public String getCreateUserId() {
/*  96 */     return this._createUserId;
/*     */   }
/*     */   
/*     */   public void setCreateUserId(String argCreateUserId) {
/* 100 */     if (changed(argCreateUserId, this._createUserId, "createUserId")) {
/* 101 */       this._createUserId = argCreateUserId;
/*     */     }
/*     */   }
/*     */   
/*     */   public Date getUpdateDate() {
/* 106 */     return (Date)this._updateDate;
/*     */   }
/*     */   
/*     */   public void setUpdateDate(Date argUpdateDate) {
/* 110 */     if (changed(argUpdateDate, this._updateDate, "updateDate")) {
/* 111 */       this._updateDate = (argUpdateDate == null || argUpdateDate instanceof DtvDate) ? (DtvDate)argUpdateDate : new DtvDate(argUpdateDate);
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public String getUpdateUserId() {
/* 117 */     return this._updateUserId;
/*     */   }
/*     */   
/*     */   public void setUpdateUserId(String argUpdateUserId) {
/* 121 */     if (changed(argUpdateUserId, this._updateUserId, "updateUserId")) {
/* 122 */       this._updateUserId = argUpdateUserId;
/*     */     }
/*     */   }
/*     */   
/*     */   public String getOrgCode() {
/* 127 */     return this._orgCode;
/*     */   }
/*     */   
/*     */   public void setOrgCode(String argOrgCode) {
/* 131 */     if (changed(argOrgCode, this._orgCode, "orgCode")) {
/* 132 */       this._orgCode = argOrgCode;
/*     */     }
/*     */   }
/*     */   
/*     */   public String getOrgValue() {
/* 137 */     return this._orgValue;
/*     */   }
/*     */   
/*     */   public void setOrgValue(String argOrgValue) {
/* 141 */     if (changed(argOrgValue, this._orgValue, "orgValue")) {
/* 142 */       this._orgValue = argOrgValue;
/*     */     }
/*     */   }
/*     */   
/*     */   public Boolean getCompound() {
/* 147 */     return this._compound;
/*     */   }
/*     */   
/*     */   public void setCompound(Boolean argCompound) {
/* 151 */     if (changed(argCompound, this._compound, "compound")) {
/* 152 */       this._compound = argCompound;
/*     */     }
/*     */   }
/*     */   
/*     */   public Integer getCompoundSequence() {
/* 157 */     return this._compoundSequence;
/*     */   }
/*     */   
/*     */   public void setCompoundSequence(Integer argCompoundSequence) {
/* 161 */     if (changed(argCompoundSequence, this._compoundSequence, "compoundSequence")) {
/* 162 */       this._compoundSequence = argCompoundSequence;
/*     */     }
/*     */   }
/*     */   
/*     */   public String getDescription() {
/* 167 */     return this._description;
/*     */   }
/*     */   
/*     */   public void setDescription(String argDescription) {
/* 171 */     if (changed(argDescription, this._description, "description")) {
/* 172 */       this._description = argDescription;
/*     */     }
/*     */   }
/*     */   
/*     */   public String getName() {
/* 177 */     return this._name;
/*     */   }
/*     */   
/*     */   public void setName(String argName) {
/* 181 */     if (changed(argName, this._name, "name")) {
/* 182 */       this._name = argName;
/*     */     }
/*     */   }
/*     */   
/*     */   public String getTaxTypeCode() {
/* 187 */     return this._taxTypeCode;
/*     */   }
/*     */   
/*     */   public void setTaxTypeCode(String argTaxTypeCode) {
/* 191 */     if (changed(argTaxTypeCode, this._taxTypeCode, "taxTypeCode")) {
/* 192 */       this._taxTypeCode = argTaxTypeCode;
/*     */     }
/*     */   }
/*     */   
/*     */   public Boolean getTaxedAtTransLevel() {
/* 197 */     return this._taxedAtTransLevel;
/*     */   }
/*     */   
/*     */   public void setTaxedAtTransLevel(Boolean argTaxedAtTransLevel) {
/* 201 */     if (changed(argTaxedAtTransLevel, this._taxedAtTransLevel, "taxedAtTransLevel")) {
/* 202 */       this._taxedAtTransLevel = argTaxedAtTransLevel;
/*     */     }
/*     */   }
/*     */   
/*     */   public String getTaxAuthorityId() {
/* 207 */     return this._taxAuthorityId;
/*     */   }
/*     */   
/*     */   public void setTaxAuthorityId(String argTaxAuthorityId) {
/* 211 */     if (changed(argTaxAuthorityId, this._taxAuthorityId, "taxAuthorityId")) {
/* 212 */       this._taxAuthorityId = argTaxAuthorityId;
/*     */     }
/*     */   }
/*     */   
/*     */   public String getExternalSystem() {
/* 217 */     return this._externalSystem;
/*     */   }
/*     */   
/*     */   public void setExternalSystem(String argExternalSystem) {
/* 221 */     if (changed(argExternalSystem, this._externalSystem, "externalSystem")) {
/* 222 */       this._externalSystem = argExternalSystem;
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public String toString() {
/* 229 */     StringBuilder buf = new StringBuilder(512);
/* 230 */     buf.append(super.toString()).append(" Id: ").append(getObjectId()).append(" Values: ");
/* 231 */     if (getOrganizationId() != null) {
/* 232 */       buf.append("organizationId").append("=").append(getOrganizationId()).append(" ");
/*     */     }
/* 234 */     if (getTaxGroupId() != null) {
/* 235 */       buf.append("taxGroupId").append("=").append(getTaxGroupId()).append(" ");
/*     */     }
/* 237 */     if (getTaxLocationId() != null) {
/* 238 */       buf.append("taxLocationId").append("=").append(getTaxLocationId()).append(" ");
/*     */     }
/* 240 */     if (getTaxRuleSequence() != null) {
/* 241 */       buf.append("taxRuleSequence").append("=").append(getTaxRuleSequence()).append(" ");
/*     */     }
/* 243 */     if (getCreateDate() != null) {
/* 244 */       buf.append("createDate").append("=").append(getCreateDate()).append(" ");
/*     */     }
/* 246 */     if (getCreateUserId() != null) {
/* 247 */       buf.append("createUserId").append("=").append(getCreateUserId()).append(" ");
/*     */     }
/* 249 */     if (getUpdateDate() != null) {
/* 250 */       buf.append("updateDate").append("=").append(getUpdateDate()).append(" ");
/*     */     }
/* 252 */     if (getUpdateUserId() != null) {
/* 253 */       buf.append("updateUserId").append("=").append(getUpdateUserId()).append(" ");
/*     */     }
/* 255 */     if (getOrgCode() != null) {
/* 256 */       buf.append("orgCode").append("=").append(getOrgCode()).append(" ");
/*     */     }
/* 258 */     if (getOrgValue() != null) {
/* 259 */       buf.append("orgValue").append("=").append(getOrgValue()).append(" ");
/*     */     }
/* 261 */     if (getCompound() != null && getCompound().booleanValue()) {
/* 262 */       buf.append("compound").append("=").append(getCompound()).append(" ");
/*     */     }
/* 264 */     if (getCompoundSequence() != null) {
/* 265 */       buf.append("compoundSequence").append("=").append(getCompoundSequence()).append(" ");
/*     */     }
/* 267 */     if (getDescription() != null) {
/* 268 */       buf.append("description").append("=").append(getDescription()).append(" ");
/*     */     }
/* 270 */     if (getName() != null) {
/* 271 */       buf.append("name").append("=").append(getName()).append(" ");
/*     */     }
/* 273 */     if (getTaxTypeCode() != null) {
/* 274 */       buf.append("taxTypeCode").append("=").append(getTaxTypeCode()).append(" ");
/*     */     }
/* 276 */     if (getTaxedAtTransLevel() != null && getTaxedAtTransLevel().booleanValue()) {
/* 277 */       buf.append("taxedAtTransLevel").append("=").append(getTaxedAtTransLevel()).append(" ");
/*     */     }
/* 279 */     if (getTaxAuthorityId() != null) {
/* 280 */       buf.append("taxAuthorityId").append("=").append(getTaxAuthorityId()).append(" ");
/*     */     }
/* 282 */     if (getExternalSystem() != null) {
/* 283 */       buf.append("externalSystem").append("=").append(getExternalSystem()).append(" ");
/*     */     }
/*     */     
/* 286 */     return buf.toString();
/*     */   }
/*     */   
/*     */   public IObjectId getObjectId() {
/* 290 */     TaxGroupRuleId id = new TaxGroupRuleId();
/* 291 */     id.setOrganizationId(getOrganizationId());
/* 292 */     id.setTaxGroupId(getTaxGroupId());
/* 293 */     id.setTaxLocationId(getTaxLocationId());
/* 294 */     id.setTaxRuleSequence(getTaxRuleSequence());
/* 295 */     return (IObjectId)id;
/*     */   }
/*     */   
/*     */   public void setObjectId(IObjectId argObjectId) {
/* 299 */     setOrganizationId(((TaxGroupRuleId)argObjectId).getOrganizationId());
/* 300 */     setTaxGroupId(((TaxGroupRuleId)argObjectId).getTaxGroupId());
/* 301 */     setTaxLocationId(((TaxGroupRuleId)argObjectId).getTaxLocationId());
/* 302 */     setTaxRuleSequence(((TaxGroupRuleId)argObjectId).getTaxRuleSequence());
/*     */   }
/*     */   
/*     */   public String getImplementingClass() {
/* 306 */     return null;
/*     */   }
/*     */   
/*     */   public String toXmlString() {
/* 310 */     StringBuilder buf = new StringBuilder(900);
/* 311 */     buf.append("<").append("dao").append(" name=\"TaxGroupRule\" cmd=\"" + getObjectStateString() + "\">");
/* 312 */     getFieldsAsXml(buf);
/* 313 */     buf.append("</").append("dao").append(">");
/*     */     
/* 315 */     return buf.toString();
/*     */   }
/*     */   
/*     */   public Map<String, String> getValues() {
/* 319 */     Map<String, String> values = super.getValues();
/* 320 */     if (this._organizationId != null) values.put("OrganizationId", DaoUtils.getXmlSafeFieldValue(-5, this._organizationId)); 
/* 321 */     if (this._taxGroupId != null) values.put("TaxGroupId", DaoUtils.getXmlSafeFieldValue(12, this._taxGroupId)); 
/* 322 */     if (this._taxLocationId != null) values.put("TaxLocationId", DaoUtils.getXmlSafeFieldValue(12, this._taxLocationId)); 
/* 323 */     if (this._taxRuleSequence != null) values.put("TaxRuleSequence", DaoUtils.getXmlSafeFieldValue(4, this._taxRuleSequence)); 
/* 324 */     if (this._createDate != null) values.put("CreateDate", DaoUtils.getXmlSafeFieldValue(91, this._createDate)); 
/* 325 */     if (this._createUserId != null) values.put("CreateUserId", DaoUtils.getXmlSafeFieldValue(12, this._createUserId)); 
/* 326 */     if (this._updateDate != null) values.put("UpdateDate", DaoUtils.getXmlSafeFieldValue(91, this._updateDate)); 
/* 327 */     if (this._updateUserId != null) values.put("UpdateUserId", DaoUtils.getXmlSafeFieldValue(12, this._updateUserId)); 
/* 328 */     if (this._orgCode != null) values.put("OrgCode", DaoUtils.getXmlSafeFieldValue(12, this._orgCode)); 
/* 329 */     if (this._orgValue != null) values.put("OrgValue", DaoUtils.getXmlSafeFieldValue(12, this._orgValue)); 
/* 330 */     if (this._compound != null) values.put("Compound", DaoUtils.getXmlSafeFieldValue(-7, this._compound)); 
/* 331 */     if (this._compoundSequence != null) values.put("CompoundSequence", DaoUtils.getXmlSafeFieldValue(4, this._compoundSequence)); 
/* 332 */     if (this._description != null) values.put("Description", DaoUtils.getXmlSafeFieldValue(12, this._description)); 
/* 333 */     if (this._name != null) values.put("Name", DaoUtils.getXmlSafeFieldValue(12, this._name)); 
/* 334 */     if (this._taxTypeCode != null) values.put("TaxTypeCode", DaoUtils.getXmlSafeFieldValue(12, this._taxTypeCode)); 
/* 335 */     if (this._taxedAtTransLevel != null) values.put("TaxedAtTransLevel", DaoUtils.getXmlSafeFieldValue(-7, this._taxedAtTransLevel)); 
/* 336 */     if (this._taxAuthorityId != null) values.put("TaxAuthorityId", DaoUtils.getXmlSafeFieldValue(12, this._taxAuthorityId)); 
/* 337 */     if (this._externalSystem != null) values.put("ExternalSystem", DaoUtils.getXmlSafeFieldValue(12, this._externalSystem)); 
/* 338 */     return values;
/*     */   }
/*     */ 
/*     */   
/*     */   public void setValues(Map<String, String> argValues) {
/* 343 */     super.setValues(argValues);
/* 344 */     for (Map.Entry<String, String> field : argValues.entrySet()) {
/*     */       
/* 346 */       String fieldName = field.getKey();
/* 347 */       String fieldValue = field.getValue();
/* 348 */       switch (fieldName) {
/*     */         
/*     */         case "OrganizationId":
/*     */           try {
/* 352 */             Object value = DaoUtils.getFieldValueForXmlString(-5, fieldValue);
/* 353 */             setOrganizationId((Long)value);
/* 354 */           } catch (Exception ee) {
/* 355 */             throw new DtxException("An exception occurred while calling setOrganizationId() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "TaxGroupId":
/*     */           try {
/* 361 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 362 */             setTaxGroupId((String)value);
/* 363 */           } catch (Exception ee) {
/* 364 */             throw new DtxException("An exception occurred while calling setTaxGroupId() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "TaxLocationId":
/*     */           try {
/* 370 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 371 */             setTaxLocationId((String)value);
/* 372 */           } catch (Exception ee) {
/* 373 */             throw new DtxException("An exception occurred while calling setTaxLocationId() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "TaxRuleSequence":
/*     */           try {
/* 379 */             Object value = DaoUtils.getFieldValueForXmlString(4, fieldValue);
/* 380 */             setTaxRuleSequence((Integer)value);
/* 381 */           } catch (Exception ee) {
/* 382 */             throw new DtxException("An exception occurred while calling setTaxRuleSequence() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "CreateDate":
/*     */           try {
/* 388 */             Object value = DaoUtils.getFieldValueForXmlString(91, fieldValue);
/* 389 */             setCreateDate((Date)value);
/* 390 */           } catch (Exception ee) {
/* 391 */             throw new DtxException("An exception occurred while calling setCreateDate() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "CreateUserId":
/*     */           try {
/* 397 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 398 */             setCreateUserId((String)value);
/* 399 */           } catch (Exception ee) {
/* 400 */             throw new DtxException("An exception occurred while calling setCreateUserId() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "UpdateDate":
/*     */           try {
/* 406 */             Object value = DaoUtils.getFieldValueForXmlString(91, fieldValue);
/* 407 */             setUpdateDate((Date)value);
/* 408 */           } catch (Exception ee) {
/* 409 */             throw new DtxException("An exception occurred while calling setUpdateDate() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "UpdateUserId":
/*     */           try {
/* 415 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 416 */             setUpdateUserId((String)value);
/* 417 */           } catch (Exception ee) {
/* 418 */             throw new DtxException("An exception occurred while calling setUpdateUserId() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "OrgCode":
/*     */           try {
/* 424 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 425 */             setOrgCode((String)value);
/* 426 */           } catch (Exception ee) {
/* 427 */             throw new DtxException("An exception occurred while calling setOrgCode() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "OrgValue":
/*     */           try {
/* 433 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 434 */             setOrgValue((String)value);
/* 435 */           } catch (Exception ee) {
/* 436 */             throw new DtxException("An exception occurred while calling setOrgValue() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "Compound":
/*     */           try {
/* 442 */             Object value = DaoUtils.getFieldValueForXmlString(-7, fieldValue);
/* 443 */             setCompound((Boolean)value);
/* 444 */           } catch (Exception ee) {
/* 445 */             throw new DtxException("An exception occurred while calling setCompound() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "CompoundSequence":
/*     */           try {
/* 451 */             Object value = DaoUtils.getFieldValueForXmlString(4, fieldValue);
/* 452 */             setCompoundSequence((Integer)value);
/* 453 */           } catch (Exception ee) {
/* 454 */             throw new DtxException("An exception occurred while calling setCompoundSequence() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "Description":
/*     */           try {
/* 460 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 461 */             setDescription((String)value);
/* 462 */           } catch (Exception ee) {
/* 463 */             throw new DtxException("An exception occurred while calling setDescription() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "Name":
/*     */           try {
/* 469 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 470 */             setName((String)value);
/* 471 */           } catch (Exception ee) {
/* 472 */             throw new DtxException("An exception occurred while calling setName() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "TaxTypeCode":
/*     */           try {
/* 478 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 479 */             setTaxTypeCode((String)value);
/* 480 */           } catch (Exception ee) {
/* 481 */             throw new DtxException("An exception occurred while calling setTaxTypeCode() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "TaxedAtTransLevel":
/*     */           try {
/* 487 */             Object value = DaoUtils.getFieldValueForXmlString(-7, fieldValue);
/* 488 */             setTaxedAtTransLevel((Boolean)value);
/* 489 */           } catch (Exception ee) {
/* 490 */             throw new DtxException("An exception occurred while calling setTaxedAtTransLevel() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "TaxAuthorityId":
/*     */           try {
/* 496 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 497 */             setTaxAuthorityId((String)value);
/* 498 */           } catch (Exception ee) {
/* 499 */             throw new DtxException("An exception occurred while calling setTaxAuthorityId() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "ExternalSystem":
/*     */           try {
/* 505 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 506 */             setExternalSystem((String)value);
/* 507 */           } catch (Exception ee) {
/* 508 */             throw new DtxException("An exception occurred while calling setExternalSystem() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */       } 
/*     */     } 
/*     */   }
/*     */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\tax\impl\TaxGroupRuleDAO.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */