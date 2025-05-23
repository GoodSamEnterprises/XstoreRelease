/*     */ package dtv.xst.dao.sec.impl;
/*     */ 
/*     */ import dtv.data2.access.DaoUtils;
/*     */ import dtv.data2.access.IHasConfigElement;
/*     */ import dtv.data2.access.IObjectId;
/*     */ import dtv.data2.access.exception.DtxException;
/*     */ import dtv.data2.access.impl.AbstractDAOImpl;
/*     */ import dtv.util.DtvDate;
/*     */ import dtv.xst.dao.sec.PrivilegeId;
/*     */ import java.util.Date;
/*     */ import java.util.Map;
/*     */ import org.apache.log4j.Logger;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class PrivilegeDAO
/*     */   extends AbstractDAOImpl
/*     */   implements IHasConfigElement
/*     */ {
/*     */   private static final long serialVersionUID = 426579601L;
/*  23 */   private static final Logger _logger = Logger.getLogger(PrivilegeDAO.class);
/*     */   
/*     */   private Long _organizationId;
/*     */   private String _privilegeType;
/*     */   private DtvDate _createDate;
/*     */   private String _createUserId;
/*     */   private DtvDate _updateDate;
/*     */   private String _updateUserId;
/*     */   private String _configElement;
/*  32 */   private Boolean _authenticationRequired = Boolean.FALSE;
/*     */   private String _groupMembershipRaw;
/*  34 */   private Boolean _overridable = Boolean.FALSE;
/*     */   private String _description;
/*     */   private String _secondPromptSettings;
/*  37 */   private Boolean _secondPromptReqrDiffEmp = Boolean.FALSE;
/*     */   private String _secondPromptGroupMembershipRaw;
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
/*     */   public String getPrivilegeType() {
/*  51 */     return this._privilegeType;
/*     */   }
/*     */   
/*     */   public void setPrivilegeType(String argPrivilegeType) {
/*  55 */     if (changed(argPrivilegeType, this._privilegeType, "privilegeType")) {
/*  56 */       this._privilegeType = (argPrivilegeType != null && MANAGE_CASE) ? argPrivilegeType.toUpperCase() : argPrivilegeType;
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
/*     */   public String getConfigElement() {
/* 103 */     return this._configElement;
/*     */   }
/*     */   
/*     */   public void setConfigElement(String argConfigElement) {
/* 107 */     if (changed(argConfigElement, this._configElement, "configElement")) {
/* 108 */       this._configElement = argConfigElement;
/*     */     }
/*     */   }
/*     */   
/*     */   public Boolean getAuthenticationRequired() {
/* 113 */     return this._authenticationRequired;
/*     */   }
/*     */   
/*     */   public void setAuthenticationRequired(Boolean argAuthenticationRequired) {
/* 117 */     if (changed(argAuthenticationRequired, this._authenticationRequired, "authenticationRequired")) {
/* 118 */       this._authenticationRequired = argAuthenticationRequired;
/*     */     }
/*     */   }
/*     */   
/*     */   public String getGroupMembershipRaw() {
/* 123 */     return this._groupMembershipRaw;
/*     */   }
/*     */   
/*     */   public void setGroupMembershipRaw(String argGroupMembershipRaw) {
/* 127 */     if (changed(argGroupMembershipRaw, this._groupMembershipRaw, "groupMembershipRaw")) {
/* 128 */       this._groupMembershipRaw = argGroupMembershipRaw;
/*     */     }
/*     */   }
/*     */   
/*     */   public Boolean getOverridable() {
/* 133 */     return this._overridable;
/*     */   }
/*     */   
/*     */   public void setOverridable(Boolean argOverridable) {
/* 137 */     if (changed(argOverridable, this._overridable, "overridable")) {
/* 138 */       this._overridable = argOverridable;
/*     */     }
/*     */   }
/*     */   
/*     */   public String getDescription() {
/* 143 */     return this._description;
/*     */   }
/*     */   
/*     */   public void setDescription(String argDescription) {
/* 147 */     if (changed(argDescription, this._description, "description")) {
/* 148 */       this._description = argDescription;
/*     */     }
/*     */   }
/*     */   
/*     */   public String getSecondPromptSettings() {
/* 153 */     return this._secondPromptSettings;
/*     */   }
/*     */   
/*     */   public void setSecondPromptSettings(String argSecondPromptSettings) {
/* 157 */     if (changed(argSecondPromptSettings, this._secondPromptSettings, "secondPromptSettings")) {
/* 158 */       this._secondPromptSettings = argSecondPromptSettings;
/*     */     }
/*     */   }
/*     */   
/*     */   public Boolean getSecondPromptReqrDiffEmp() {
/* 163 */     return this._secondPromptReqrDiffEmp;
/*     */   }
/*     */   
/*     */   public void setSecondPromptReqrDiffEmp(Boolean argSecondPromptReqrDiffEmp) {
/* 167 */     if (changed(argSecondPromptReqrDiffEmp, this._secondPromptReqrDiffEmp, "secondPromptReqrDiffEmp")) {
/* 168 */       this._secondPromptReqrDiffEmp = argSecondPromptReqrDiffEmp;
/*     */     }
/*     */   }
/*     */   
/*     */   public String getSecondPromptGroupMembershipRaw() {
/* 173 */     return this._secondPromptGroupMembershipRaw;
/*     */   }
/*     */   
/*     */   public void setSecondPromptGroupMembershipRaw(String argSecondPromptGroupMembershipRaw) {
/* 177 */     if (changed(argSecondPromptGroupMembershipRaw, this._secondPromptGroupMembershipRaw, "secondPromptGroupMembershipRaw")) {
/* 178 */       this._secondPromptGroupMembershipRaw = argSecondPromptGroupMembershipRaw;
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public String toString() {
/* 185 */     StringBuilder buf = new StringBuilder(512);
/* 186 */     buf.append(super.toString()).append(" Id: ").append(getObjectId()).append(" Values: ");
/* 187 */     if (getOrganizationId() != null) {
/* 188 */       buf.append("organizationId").append("=").append(getOrganizationId()).append(" ");
/*     */     }
/* 190 */     if (getPrivilegeType() != null) {
/* 191 */       buf.append("privilegeType").append("=").append(getPrivilegeType()).append(" ");
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
/* 205 */     if (getConfigElement() != null) {
/* 206 */       buf.append("configElement").append("=").append(getConfigElement()).append(" ");
/*     */     }
/* 208 */     if (getAuthenticationRequired() != null && getAuthenticationRequired().booleanValue()) {
/* 209 */       buf.append("authenticationRequired").append("=").append(getAuthenticationRequired()).append(" ");
/*     */     }
/* 211 */     if (getGroupMembershipRaw() != null) {
/* 212 */       buf.append("groupMembershipRaw").append("=").append(getGroupMembershipRaw()).append(" ");
/*     */     }
/* 214 */     if (getOverridable() != null && getOverridable().booleanValue()) {
/* 215 */       buf.append("overridable").append("=").append(getOverridable()).append(" ");
/*     */     }
/* 217 */     if (getDescription() != null) {
/* 218 */       buf.append("description").append("=").append(getDescription()).append(" ");
/*     */     }
/* 220 */     if (getSecondPromptSettings() != null) {
/* 221 */       buf.append("secondPromptSettings").append("=").append(getSecondPromptSettings()).append(" ");
/*     */     }
/* 223 */     if (getSecondPromptReqrDiffEmp() != null && getSecondPromptReqrDiffEmp().booleanValue()) {
/* 224 */       buf.append("secondPromptReqrDiffEmp").append("=").append(getSecondPromptReqrDiffEmp()).append(" ");
/*     */     }
/* 226 */     if (getSecondPromptGroupMembershipRaw() != null) {
/* 227 */       buf.append("secondPromptGroupMembershipRaw").append("=").append(getSecondPromptGroupMembershipRaw()).append(" ");
/*     */     }
/*     */     
/* 230 */     return buf.toString();
/*     */   }
/*     */   
/*     */   public IObjectId getObjectId() {
/* 234 */     PrivilegeId id = new PrivilegeId();
/* 235 */     id.setOrganizationId(getOrganizationId());
/* 236 */     id.setPrivilegeType(getPrivilegeType());
/* 237 */     return (IObjectId)id;
/*     */   }
/*     */   
/*     */   public void setObjectId(IObjectId argObjectId) {
/* 241 */     setOrganizationId(((PrivilegeId)argObjectId).getOrganizationId());
/* 242 */     setPrivilegeType(((PrivilegeId)argObjectId).getPrivilegeType());
/*     */   }
/*     */   
/*     */   public String getImplementingClass() {
/* 246 */     return null;
/*     */   }
/*     */   
/*     */   public String toXmlString() {
/* 250 */     StringBuilder buf = new StringBuilder(700);
/* 251 */     buf.append("<").append("dao").append(" name=\"Privilege\" cmd=\"" + getObjectStateString() + "\">");
/* 252 */     getFieldsAsXml(buf);
/* 253 */     buf.append("</").append("dao").append(">");
/*     */     
/* 255 */     return buf.toString();
/*     */   }
/*     */   
/*     */   public Map<String, String> getValues() {
/* 259 */     Map<String, String> values = super.getValues();
/* 260 */     if (this._organizationId != null) values.put("OrganizationId", DaoUtils.getXmlSafeFieldValue(-5, this._organizationId)); 
/* 261 */     if (this._privilegeType != null) values.put("PrivilegeType", DaoUtils.getXmlSafeFieldValue(12, this._privilegeType)); 
/* 262 */     if (this._createDate != null) values.put("CreateDate", DaoUtils.getXmlSafeFieldValue(91, this._createDate)); 
/* 263 */     if (this._createUserId != null) values.put("CreateUserId", DaoUtils.getXmlSafeFieldValue(12, this._createUserId)); 
/* 264 */     if (this._updateDate != null) values.put("UpdateDate", DaoUtils.getXmlSafeFieldValue(91, this._updateDate)); 
/* 265 */     if (this._updateUserId != null) values.put("UpdateUserId", DaoUtils.getXmlSafeFieldValue(12, this._updateUserId)); 
/* 266 */     if (this._configElement != null) values.put("ConfigElement", DaoUtils.getXmlSafeFieldValue(12, this._configElement)); 
/* 267 */     if (this._authenticationRequired != null) values.put("AuthenticationRequired", DaoUtils.getXmlSafeFieldValue(-7, this._authenticationRequired)); 
/* 268 */     if (this._groupMembershipRaw != null) values.put("GroupMembershipRaw", DaoUtils.getXmlSafeFieldValue(2005, this._groupMembershipRaw)); 
/* 269 */     if (this._overridable != null) values.put("Overridable", DaoUtils.getXmlSafeFieldValue(-7, this._overridable)); 
/* 270 */     if (this._description != null) values.put("Description", DaoUtils.getXmlSafeFieldValue(12, this._description)); 
/* 271 */     if (this._secondPromptSettings != null) values.put("SecondPromptSettings", DaoUtils.getXmlSafeFieldValue(12, this._secondPromptSettings)); 
/* 272 */     if (this._secondPromptReqrDiffEmp != null) values.put("SecondPromptReqrDiffEmp", DaoUtils.getXmlSafeFieldValue(-7, this._secondPromptReqrDiffEmp)); 
/* 273 */     if (this._secondPromptGroupMembershipRaw != null) values.put("SecondPromptGroupMembershipRaw", DaoUtils.getXmlSafeFieldValue(2005, this._secondPromptGroupMembershipRaw)); 
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
/*     */         case "OrganizationId":
/*     */           try {
/* 288 */             Object value = DaoUtils.getFieldValueForXmlString(-5, fieldValue);
/* 289 */             setOrganizationId((Long)value);
/* 290 */           } catch (Exception ee) {
/* 291 */             throw new DtxException("An exception occurred while calling setOrganizationId() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "PrivilegeType":
/*     */           try {
/* 297 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 298 */             setPrivilegeType((String)value);
/* 299 */           } catch (Exception ee) {
/* 300 */             throw new DtxException("An exception occurred while calling setPrivilegeType() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
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
/*     */         case "ConfigElement":
/*     */           try {
/* 342 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 343 */             setConfigElement((String)value);
/* 344 */           } catch (Exception ee) {
/* 345 */             throw new DtxException("An exception occurred while calling setConfigElement() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "AuthenticationRequired":
/*     */           try {
/* 351 */             Object value = DaoUtils.getFieldValueForXmlString(-7, fieldValue);
/* 352 */             setAuthenticationRequired((Boolean)value);
/* 353 */           } catch (Exception ee) {
/* 354 */             throw new DtxException("An exception occurred while calling setAuthenticationRequired() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "GroupMembershipRaw":
/*     */           try {
/* 360 */             Object value = DaoUtils.getFieldValueForXmlString(2005, fieldValue);
/* 361 */             setGroupMembershipRaw((String)value);
/* 362 */           } catch (Exception ee) {
/* 363 */             throw new DtxException("An exception occurred while calling setGroupMembershipRaw() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "Overridable":
/*     */           try {
/* 369 */             Object value = DaoUtils.getFieldValueForXmlString(-7, fieldValue);
/* 370 */             setOverridable((Boolean)value);
/* 371 */           } catch (Exception ee) {
/* 372 */             throw new DtxException("An exception occurred while calling setOverridable() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "Description":
/*     */           try {
/* 378 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 379 */             setDescription((String)value);
/* 380 */           } catch (Exception ee) {
/* 381 */             throw new DtxException("An exception occurred while calling setDescription() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "SecondPromptSettings":
/*     */           try {
/* 387 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 388 */             setSecondPromptSettings((String)value);
/* 389 */           } catch (Exception ee) {
/* 390 */             throw new DtxException("An exception occurred while calling setSecondPromptSettings() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "SecondPromptReqrDiffEmp":
/*     */           try {
/* 396 */             Object value = DaoUtils.getFieldValueForXmlString(-7, fieldValue);
/* 397 */             setSecondPromptReqrDiffEmp((Boolean)value);
/* 398 */           } catch (Exception ee) {
/* 399 */             throw new DtxException("An exception occurred while calling setSecondPromptReqrDiffEmp() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "SecondPromptGroupMembershipRaw":
/*     */           try {
/* 405 */             Object value = DaoUtils.getFieldValueForXmlString(2005, fieldValue);
/* 406 */             setSecondPromptGroupMembershipRaw((String)value);
/* 407 */           } catch (Exception ee) {
/* 408 */             throw new DtxException("An exception occurred while calling setSecondPromptGroupMembershipRaw() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */       } 
/*     */     } 
/*     */   }
/*     */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\sec\impl\PrivilegeDAO.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */