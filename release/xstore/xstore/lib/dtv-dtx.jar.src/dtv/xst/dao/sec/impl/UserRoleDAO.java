/*     */ package dtv.xst.dao.sec.impl;
/*     */ 
/*     */ import dtv.data2.access.DaoUtils;
/*     */ import dtv.data2.access.IObjectId;
/*     */ import dtv.data2.access.exception.DtxException;
/*     */ import dtv.data2.access.impl.AbstractDAOImpl;
/*     */ import dtv.util.DtvDate;
/*     */ import dtv.xst.dao.sec.UserRoleId;
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
/*     */ public class UserRoleDAO
/*     */   extends AbstractDAOImpl
/*     */ {
/*     */   private static final long serialVersionUID = -201890047L;
/*  23 */   private static final Logger _logger = Logger.getLogger(UserRoleDAO.class);
/*     */   
/*     */   private Long _organizationId;
/*     */   private Integer _userRoleId;
/*     */   private DtvDate _createDate;
/*     */   private String _createUserId;
/*     */   private DtvDate _updateDate;
/*     */   private String _updateUserId;
/*     */   private String _user;
/*     */   private String _roleCode;
/*     */   
/*     */   public Long getOrganizationId() {
/*  35 */     return this._organizationId;
/*     */   }
/*     */   
/*     */   public void setOrganizationId(Long argOrganizationId) {
/*  39 */     if (changed(argOrganizationId, this._organizationId, "organizationId")) {
/*  40 */       this._organizationId = argOrganizationId;
/*     */     }
/*     */   }
/*     */   
/*     */   public Integer getUserRoleId() {
/*  45 */     return this._userRoleId;
/*     */   }
/*     */   
/*     */   public void setUserRoleId(Integer argUserRoleId) {
/*  49 */     if (changed(argUserRoleId, this._userRoleId, "userRoleId")) {
/*  50 */       this._userRoleId = argUserRoleId;
/*     */     }
/*     */   }
/*     */   
/*     */   public Date getCreateDate() {
/*  55 */     return (Date)this._createDate;
/*     */   }
/*     */   
/*     */   public void setCreateDate(Date argCreateDate) {
/*  59 */     if (changed(argCreateDate, this._createDate, "createDate")) {
/*  60 */       this._createDate = (argCreateDate == null || argCreateDate instanceof DtvDate) ? (DtvDate)argCreateDate : new DtvDate(argCreateDate);
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public String getCreateUserId() {
/*  66 */     return this._createUserId;
/*     */   }
/*     */   
/*     */   public void setCreateUserId(String argCreateUserId) {
/*  70 */     if (changed(argCreateUserId, this._createUserId, "createUserId")) {
/*  71 */       this._createUserId = argCreateUserId;
/*     */     }
/*     */   }
/*     */   
/*     */   public Date getUpdateDate() {
/*  76 */     return (Date)this._updateDate;
/*     */   }
/*     */   
/*     */   public void setUpdateDate(Date argUpdateDate) {
/*  80 */     if (changed(argUpdateDate, this._updateDate, "updateDate")) {
/*  81 */       this._updateDate = (argUpdateDate == null || argUpdateDate instanceof DtvDate) ? (DtvDate)argUpdateDate : new DtvDate(argUpdateDate);
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public String getUpdateUserId() {
/*  87 */     return this._updateUserId;
/*     */   }
/*     */   
/*     */   public void setUpdateUserId(String argUpdateUserId) {
/*  91 */     if (changed(argUpdateUserId, this._updateUserId, "updateUserId")) {
/*  92 */       this._updateUserId = argUpdateUserId;
/*     */     }
/*     */   }
/*     */   
/*     */   public String getUser() {
/*  97 */     return this._user;
/*     */   }
/*     */   
/*     */   public void setUser(String argUser) {
/* 101 */     if (changed(argUser, this._user, "user")) {
/* 102 */       this._user = argUser;
/*     */     }
/*     */   }
/*     */   
/*     */   public String getRoleCode() {
/* 107 */     return this._roleCode;
/*     */   }
/*     */   
/*     */   public void setRoleCode(String argRoleCode) {
/* 111 */     if (changed(argRoleCode, this._roleCode, "roleCode")) {
/* 112 */       this._roleCode = argRoleCode;
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public String toString() {
/* 119 */     StringBuilder buf = new StringBuilder(512);
/* 120 */     buf.append(super.toString()).append(" Id: ").append(getObjectId()).append(" Values: ");
/* 121 */     if (getOrganizationId() != null) {
/* 122 */       buf.append("organizationId").append("=").append(getOrganizationId()).append(" ");
/*     */     }
/* 124 */     if (getUserRoleId() != null) {
/* 125 */       buf.append("userRoleId").append("=").append(getUserRoleId()).append(" ");
/*     */     }
/* 127 */     if (getCreateDate() != null) {
/* 128 */       buf.append("createDate").append("=").append(getCreateDate()).append(" ");
/*     */     }
/* 130 */     if (getCreateUserId() != null) {
/* 131 */       buf.append("createUserId").append("=").append(getCreateUserId()).append(" ");
/*     */     }
/* 133 */     if (getUpdateDate() != null) {
/* 134 */       buf.append("updateDate").append("=").append(getUpdateDate()).append(" ");
/*     */     }
/* 136 */     if (getUpdateUserId() != null) {
/* 137 */       buf.append("updateUserId").append("=").append(getUpdateUserId()).append(" ");
/*     */     }
/* 139 */     if (getUser() != null) {
/* 140 */       buf.append("user").append("=").append(getUser()).append(" ");
/*     */     }
/* 142 */     if (getRoleCode() != null) {
/* 143 */       buf.append("roleCode").append("=").append(getRoleCode()).append(" ");
/*     */     }
/*     */     
/* 146 */     return buf.toString();
/*     */   }
/*     */   
/*     */   public IObjectId getObjectId() {
/* 150 */     UserRoleId id = new UserRoleId();
/* 151 */     id.setOrganizationId(getOrganizationId());
/* 152 */     id.setUserRoleId(getUserRoleId());
/* 153 */     return (IObjectId)id;
/*     */   }
/*     */   
/*     */   public void setObjectId(IObjectId argObjectId) {
/* 157 */     setOrganizationId(((UserRoleId)argObjectId).getOrganizationId());
/* 158 */     setUserRoleId(((UserRoleId)argObjectId).getUserRoleId());
/*     */   }
/*     */   
/*     */   public String getImplementingClass() {
/* 162 */     return null;
/*     */   }
/*     */   
/*     */   public String toXmlString() {
/* 166 */     StringBuilder buf = new StringBuilder(400);
/* 167 */     buf.append("<").append("dao").append(" name=\"UserRole\" cmd=\"" + getObjectStateString() + "\">");
/* 168 */     getFieldsAsXml(buf);
/* 169 */     buf.append("</").append("dao").append(">");
/*     */     
/* 171 */     return buf.toString();
/*     */   }
/*     */   
/*     */   public Map<String, String> getValues() {
/* 175 */     Map<String, String> values = super.getValues();
/* 176 */     if (this._organizationId != null) values.put("OrganizationId", DaoUtils.getXmlSafeFieldValue(-5, this._organizationId)); 
/* 177 */     if (this._userRoleId != null) values.put("UserRoleId", DaoUtils.getXmlSafeFieldValue(4, this._userRoleId)); 
/* 178 */     if (this._createDate != null) values.put("CreateDate", DaoUtils.getXmlSafeFieldValue(91, this._createDate)); 
/* 179 */     if (this._createUserId != null) values.put("CreateUserId", DaoUtils.getXmlSafeFieldValue(12, this._createUserId)); 
/* 180 */     if (this._updateDate != null) values.put("UpdateDate", DaoUtils.getXmlSafeFieldValue(91, this._updateDate)); 
/* 181 */     if (this._updateUserId != null) values.put("UpdateUserId", DaoUtils.getXmlSafeFieldValue(12, this._updateUserId)); 
/* 182 */     if (this._user != null) values.put("User", DaoUtils.getXmlSafeFieldValue(12, this._user)); 
/* 183 */     if (this._roleCode != null) values.put("RoleCode", DaoUtils.getXmlSafeFieldValue(12, this._roleCode)); 
/* 184 */     return values;
/*     */   }
/*     */ 
/*     */   
/*     */   public void setValues(Map<String, String> argValues) {
/* 189 */     super.setValues(argValues);
/* 190 */     for (Map.Entry<String, String> field : argValues.entrySet()) {
/*     */       
/* 192 */       String fieldName = field.getKey();
/* 193 */       String fieldValue = field.getValue();
/* 194 */       switch (fieldName) {
/*     */         
/*     */         case "OrganizationId":
/*     */           try {
/* 198 */             Object value = DaoUtils.getFieldValueForXmlString(-5, fieldValue);
/* 199 */             setOrganizationId((Long)value);
/* 200 */           } catch (Exception ee) {
/* 201 */             throw new DtxException("An exception occurred while calling setOrganizationId() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "UserRoleId":
/*     */           try {
/* 207 */             Object value = DaoUtils.getFieldValueForXmlString(4, fieldValue);
/* 208 */             setUserRoleId((Integer)value);
/* 209 */           } catch (Exception ee) {
/* 210 */             throw new DtxException("An exception occurred while calling setUserRoleId() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "CreateDate":
/*     */           try {
/* 216 */             Object value = DaoUtils.getFieldValueForXmlString(91, fieldValue);
/* 217 */             setCreateDate((Date)value);
/* 218 */           } catch (Exception ee) {
/* 219 */             throw new DtxException("An exception occurred while calling setCreateDate() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "CreateUserId":
/*     */           try {
/* 225 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 226 */             setCreateUserId((String)value);
/* 227 */           } catch (Exception ee) {
/* 228 */             throw new DtxException("An exception occurred while calling setCreateUserId() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "UpdateDate":
/*     */           try {
/* 234 */             Object value = DaoUtils.getFieldValueForXmlString(91, fieldValue);
/* 235 */             setUpdateDate((Date)value);
/* 236 */           } catch (Exception ee) {
/* 237 */             throw new DtxException("An exception occurred while calling setUpdateDate() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "UpdateUserId":
/*     */           try {
/* 243 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 244 */             setUpdateUserId((String)value);
/* 245 */           } catch (Exception ee) {
/* 246 */             throw new DtxException("An exception occurred while calling setUpdateUserId() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "User":
/*     */           try {
/* 252 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 253 */             setUser((String)value);
/* 254 */           } catch (Exception ee) {
/* 255 */             throw new DtxException("An exception occurred while calling setUser() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "RoleCode":
/*     */           try {
/* 261 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 262 */             setRoleCode((String)value);
/* 263 */           } catch (Exception ee) {
/* 264 */             throw new DtxException("An exception occurred while calling setRoleCode() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */       } 
/*     */     } 
/*     */   }
/*     */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\sec\impl\UserRoleDAO.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */