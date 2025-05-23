/*     */ package dtv.xst.dao.cfg.impl;
/*     */ 
/*     */ import dtv.data2.access.DaoUtils;
/*     */ import dtv.data2.access.IObjectId;
/*     */ import dtv.data2.access.exception.DtxException;
/*     */ import dtv.data2.access.impl.AbstractDAOImpl;
/*     */ import dtv.util.DtvDate;
/*     */ import dtv.xst.dao.cfg.XadminUserId;
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
/*     */ public class XadminUserDAO
/*     */   extends AbstractDAOImpl
/*     */ {
/*     */   private static final long serialVersionUID = -91421086L;
/*  23 */   private static final Logger _logger = Logger.getLogger(XadminUserDAO.class);
/*     */   
/*     */   private String _userName;
/*     */   private DtvDate _updateDate;
/*     */   private String _updateUserId;
/*     */   private DtvDate _createDate;
/*     */   private String _createUserId;
/*     */   private String _firstName;
/*     */   private String _lastName;
/*     */   private String _roleId;
/*     */   private String _locale;
/*     */   private Long _organizationId;
/*     */   private String _emailAddress;
/*     */   private String _directoryType;
/*     */   
/*     */   public String getUserName() {
/*  39 */     return this._userName;
/*     */   }
/*     */   
/*     */   public void setUserName(String argUserName) {
/*  43 */     if (changed(argUserName, this._userName, "userName")) {
/*  44 */       this._userName = (argUserName != null && MANAGE_CASE) ? argUserName.toUpperCase() : argUserName;
/*     */     }
/*     */   }
/*     */   
/*     */   public Date getUpdateDate() {
/*  49 */     return (Date)this._updateDate;
/*     */   }
/*     */   
/*     */   public void setUpdateDate(Date argUpdateDate) {
/*  53 */     if (changed(argUpdateDate, this._updateDate, "updateDate")) {
/*  54 */       this._updateDate = (argUpdateDate == null || argUpdateDate instanceof DtvDate) ? (DtvDate)argUpdateDate : new DtvDate(argUpdateDate);
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public String getUpdateUserId() {
/*  60 */     return this._updateUserId;
/*     */   }
/*     */   
/*     */   public void setUpdateUserId(String argUpdateUserId) {
/*  64 */     if (changed(argUpdateUserId, this._updateUserId, "updateUserId")) {
/*  65 */       this._updateUserId = argUpdateUserId;
/*     */     }
/*     */   }
/*     */   
/*     */   public Date getCreateDate() {
/*  70 */     return (Date)this._createDate;
/*     */   }
/*     */   
/*     */   public void setCreateDate(Date argCreateDate) {
/*  74 */     if (changed(argCreateDate, this._createDate, "createDate")) {
/*  75 */       this._createDate = (argCreateDate == null || argCreateDate instanceof DtvDate) ? (DtvDate)argCreateDate : new DtvDate(argCreateDate);
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public String getCreateUserId() {
/*  81 */     return this._createUserId;
/*     */   }
/*     */   
/*     */   public void setCreateUserId(String argCreateUserId) {
/*  85 */     if (changed(argCreateUserId, this._createUserId, "createUserId")) {
/*  86 */       this._createUserId = argCreateUserId;
/*     */     }
/*     */   }
/*     */   
/*     */   public String getFirstName() {
/*  91 */     return this._firstName;
/*     */   }
/*     */   
/*     */   public void setFirstName(String argFirstName) {
/*  95 */     if (changed(argFirstName, this._firstName, "firstName")) {
/*  96 */       this._firstName = argFirstName;
/*     */     }
/*     */   }
/*     */   
/*     */   public String getLastName() {
/* 101 */     return this._lastName;
/*     */   }
/*     */   
/*     */   public void setLastName(String argLastName) {
/* 105 */     if (changed(argLastName, this._lastName, "lastName")) {
/* 106 */       this._lastName = argLastName;
/*     */     }
/*     */   }
/*     */   
/*     */   public String getRoleId() {
/* 111 */     return this._roleId;
/*     */   }
/*     */   
/*     */   public void setRoleId(String argRoleId) {
/* 115 */     if (changed(argRoleId, this._roleId, "roleId")) {
/* 116 */       this._roleId = argRoleId;
/*     */     }
/*     */   }
/*     */   
/*     */   public String getLocale() {
/* 121 */     return this._locale;
/*     */   }
/*     */   
/*     */   public void setLocale(String argLocale) {
/* 125 */     if (changed(argLocale, this._locale, "locale")) {
/* 126 */       this._locale = argLocale;
/*     */     }
/*     */   }
/*     */   
/*     */   public Long getOrganizationId() {
/* 131 */     return this._organizationId;
/*     */   }
/*     */   
/*     */   public void setOrganizationId(Long argOrganizationId) {
/* 135 */     if (changed(argOrganizationId, this._organizationId, "organizationId")) {
/* 136 */       this._organizationId = argOrganizationId;
/*     */     }
/*     */   }
/*     */   
/*     */   public String getEmailAddress() {
/* 141 */     return this._emailAddress;
/*     */   }
/*     */   
/*     */   public void setEmailAddress(String argEmailAddress) {
/* 145 */     if (changed(argEmailAddress, this._emailAddress, "emailAddress")) {
/* 146 */       this._emailAddress = argEmailAddress;
/*     */     }
/*     */   }
/*     */   
/*     */   public String getDirectoryType() {
/* 151 */     return this._directoryType;
/*     */   }
/*     */   
/*     */   public void setDirectoryType(String argDirectoryType) {
/* 155 */     if (changed(argDirectoryType, this._directoryType, "directoryType")) {
/* 156 */       this._directoryType = argDirectoryType;
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public String toString() {
/* 163 */     StringBuilder buf = new StringBuilder(512);
/* 164 */     buf.append(super.toString()).append(" Id: ").append(getObjectId()).append(" Values: ");
/* 165 */     if (getUserName() != null) {
/* 166 */       buf.append("userName").append("=").append(getUserName()).append(" ");
/*     */     }
/* 168 */     if (getUpdateDate() != null) {
/* 169 */       buf.append("updateDate").append("=").append(getUpdateDate()).append(" ");
/*     */     }
/* 171 */     if (getUpdateUserId() != null) {
/* 172 */       buf.append("updateUserId").append("=").append(getUpdateUserId()).append(" ");
/*     */     }
/* 174 */     if (getCreateDate() != null) {
/* 175 */       buf.append("createDate").append("=").append(getCreateDate()).append(" ");
/*     */     }
/* 177 */     if (getCreateUserId() != null) {
/* 178 */       buf.append("createUserId").append("=").append(getCreateUserId()).append(" ");
/*     */     }
/* 180 */     if (getFirstName() != null) {
/* 181 */       buf.append("firstName").append("=").append(getFirstName()).append(" ");
/*     */     }
/* 183 */     if (getLastName() != null) {
/* 184 */       buf.append("lastName").append("=").append(getLastName()).append(" ");
/*     */     }
/* 186 */     if (getRoleId() != null) {
/* 187 */       buf.append("roleId").append("=").append(getRoleId()).append(" ");
/*     */     }
/* 189 */     if (getLocale() != null) {
/* 190 */       buf.append("locale").append("=").append(getLocale()).append(" ");
/*     */     }
/* 192 */     if (getOrganizationId() != null) {
/* 193 */       buf.append("organizationId").append("=").append(getOrganizationId()).append(" ");
/*     */     }
/* 195 */     if (getEmailAddress() != null) {
/* 196 */       buf.append("emailAddress").append("=").append(getEmailAddress()).append(" ");
/*     */     }
/* 198 */     if (getDirectoryType() != null) {
/* 199 */       buf.append("directoryType").append("=").append(getDirectoryType()).append(" ");
/*     */     }
/*     */     
/* 202 */     return buf.toString();
/*     */   }
/*     */   
/*     */   public IObjectId getObjectId() {
/* 206 */     XadminUserId id = new XadminUserId();
/* 207 */     id.setUserName(getUserName());
/* 208 */     return (IObjectId)id;
/*     */   }
/*     */   
/*     */   public void setObjectId(IObjectId argObjectId) {
/* 212 */     setUserName(((XadminUserId)argObjectId).getUserName());
/*     */   }
/*     */   
/*     */   public String getImplementingClass() {
/* 216 */     return null;
/*     */   }
/*     */   
/*     */   public String toXmlString() {
/* 220 */     StringBuilder buf = new StringBuilder(600);
/* 221 */     buf.append("<").append("dao").append(" name=\"XadminUser\" cmd=\"" + getObjectStateString() + "\">");
/* 222 */     getFieldsAsXml(buf);
/* 223 */     buf.append("</").append("dao").append(">");
/*     */     
/* 225 */     return buf.toString();
/*     */   }
/*     */   
/*     */   public Map<String, String> getValues() {
/* 229 */     Map<String, String> values = super.getValues();
/* 230 */     if (this._userName != null) values.put("UserName", DaoUtils.getXmlSafeFieldValue(12, this._userName)); 
/* 231 */     if (this._updateDate != null) values.put("UpdateDate", DaoUtils.getXmlSafeFieldValue(91, this._updateDate)); 
/* 232 */     if (this._updateUserId != null) values.put("UpdateUserId", DaoUtils.getXmlSafeFieldValue(12, this._updateUserId)); 
/* 233 */     if (this._createDate != null) values.put("CreateDate", DaoUtils.getXmlSafeFieldValue(91, this._createDate)); 
/* 234 */     if (this._createUserId != null) values.put("CreateUserId", DaoUtils.getXmlSafeFieldValue(12, this._createUserId)); 
/* 235 */     if (this._firstName != null) values.put("FirstName", DaoUtils.getXmlSafeFieldValue(12, this._firstName)); 
/* 236 */     if (this._lastName != null) values.put("LastName", DaoUtils.getXmlSafeFieldValue(12, this._lastName)); 
/* 237 */     if (this._roleId != null) values.put("RoleId", DaoUtils.getXmlSafeFieldValue(12, this._roleId)); 
/* 238 */     if (this._locale != null) values.put("Locale", DaoUtils.getXmlSafeFieldValue(12, this._locale)); 
/* 239 */     if (this._organizationId != null) values.put("OrganizationId", DaoUtils.getXmlSafeFieldValue(-5, this._organizationId)); 
/* 240 */     if (this._emailAddress != null) values.put("EmailAddress", DaoUtils.getXmlSafeFieldValue(12, this._emailAddress)); 
/* 241 */     if (this._directoryType != null) values.put("DirectoryType", DaoUtils.getXmlSafeFieldValue(12, this._directoryType)); 
/* 242 */     return values;
/*     */   }
/*     */ 
/*     */   
/*     */   public void setValues(Map<String, String> argValues) {
/* 247 */     super.setValues(argValues);
/* 248 */     for (Map.Entry<String, String> field : argValues.entrySet()) {
/*     */       
/* 250 */       String fieldName = field.getKey();
/* 251 */       String fieldValue = field.getValue();
/* 252 */       switch (fieldName) {
/*     */         
/*     */         case "UserName":
/*     */           try {
/* 256 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 257 */             setUserName((String)value);
/* 258 */           } catch (Exception ee) {
/* 259 */             throw new DtxException("An exception occurred while calling setUserName() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "UpdateDate":
/*     */           try {
/* 265 */             Object value = DaoUtils.getFieldValueForXmlString(91, fieldValue);
/* 266 */             setUpdateDate((Date)value);
/* 267 */           } catch (Exception ee) {
/* 268 */             throw new DtxException("An exception occurred while calling setUpdateDate() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "UpdateUserId":
/*     */           try {
/* 274 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 275 */             setUpdateUserId((String)value);
/* 276 */           } catch (Exception ee) {
/* 277 */             throw new DtxException("An exception occurred while calling setUpdateUserId() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "CreateDate":
/*     */           try {
/* 283 */             Object value = DaoUtils.getFieldValueForXmlString(91, fieldValue);
/* 284 */             setCreateDate((Date)value);
/* 285 */           } catch (Exception ee) {
/* 286 */             throw new DtxException("An exception occurred while calling setCreateDate() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "CreateUserId":
/*     */           try {
/* 292 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 293 */             setCreateUserId((String)value);
/* 294 */           } catch (Exception ee) {
/* 295 */             throw new DtxException("An exception occurred while calling setCreateUserId() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "FirstName":
/*     */           try {
/* 301 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 302 */             setFirstName((String)value);
/* 303 */           } catch (Exception ee) {
/* 304 */             throw new DtxException("An exception occurred while calling setFirstName() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "LastName":
/*     */           try {
/* 310 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 311 */             setLastName((String)value);
/* 312 */           } catch (Exception ee) {
/* 313 */             throw new DtxException("An exception occurred while calling setLastName() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "RoleId":
/*     */           try {
/* 319 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 320 */             setRoleId((String)value);
/* 321 */           } catch (Exception ee) {
/* 322 */             throw new DtxException("An exception occurred while calling setRoleId() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "Locale":
/*     */           try {
/* 328 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 329 */             setLocale((String)value);
/* 330 */           } catch (Exception ee) {
/* 331 */             throw new DtxException("An exception occurred while calling setLocale() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "OrganizationId":
/*     */           try {
/* 337 */             Object value = DaoUtils.getFieldValueForXmlString(-5, fieldValue);
/* 338 */             setOrganizationId((Long)value);
/* 339 */           } catch (Exception ee) {
/* 340 */             throw new DtxException("An exception occurred while calling setOrganizationId() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "EmailAddress":
/*     */           try {
/* 346 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 347 */             setEmailAddress((String)value);
/* 348 */           } catch (Exception ee) {
/* 349 */             throw new DtxException("An exception occurred while calling setEmailAddress() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "DirectoryType":
/*     */           try {
/* 355 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 356 */             setDirectoryType((String)value);
/* 357 */           } catch (Exception ee) {
/* 358 */             throw new DtxException("An exception occurred while calling setDirectoryType() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */       } 
/*     */     } 
/*     */   }
/*     */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\cfg\impl\XadminUserDAO.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */