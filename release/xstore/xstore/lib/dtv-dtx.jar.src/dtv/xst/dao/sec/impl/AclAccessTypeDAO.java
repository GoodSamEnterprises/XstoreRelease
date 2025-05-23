/*     */ package dtv.xst.dao.sec.impl;
/*     */ 
/*     */ import dtv.data2.access.DaoUtils;
/*     */ import dtv.data2.access.IObjectId;
/*     */ import dtv.data2.access.exception.DtxException;
/*     */ import dtv.data2.access.impl.AbstractDAOImpl;
/*     */ import dtv.util.DtvDate;
/*     */ import dtv.xst.dao.sec.AclAccessTypeId;
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
/*     */ public class AclAccessTypeDAO
/*     */   extends AbstractDAOImpl
/*     */ {
/*     */   private static final long serialVersionUID = -1942796600L;
/*  23 */   private static final Logger _logger = Logger.getLogger(AclAccessTypeDAO.class);
/*     */   
/*     */   private String _accessTypeCode;
/*     */   private Long _organizationId;
/*     */   private String _securedObjectId;
/*     */   private DtvDate _createDate;
/*     */   private String _createUserId;
/*     */   private DtvDate _updateDate;
/*     */   private String _updateUserId;
/*     */   private String _groupMembershipRaw;
/*     */   private String _noAccessSettings;
/*     */   
/*     */   public String getAccessTypeCode() {
/*  36 */     return this._accessTypeCode;
/*     */   }
/*     */   
/*     */   public void setAccessTypeCode(String argAccessTypeCode) {
/*  40 */     if (changed(argAccessTypeCode, this._accessTypeCode, "accessTypeCode")) {
/*  41 */       this._accessTypeCode = (argAccessTypeCode != null && MANAGE_CASE) ? argAccessTypeCode.toUpperCase() : argAccessTypeCode;
/*     */     }
/*     */   }
/*     */   
/*     */   public Long getOrganizationId() {
/*  46 */     return this._organizationId;
/*     */   }
/*     */   
/*     */   public void setOrganizationId(Long argOrganizationId) {
/*  50 */     if (changed(argOrganizationId, this._organizationId, "organizationId")) {
/*  51 */       this._organizationId = argOrganizationId;
/*     */     }
/*     */   }
/*     */   
/*     */   public String getSecuredObjectId() {
/*  56 */     return this._securedObjectId;
/*     */   }
/*     */   
/*     */   public void setSecuredObjectId(String argSecuredObjectId) {
/*  60 */     if (changed(argSecuredObjectId, this._securedObjectId, "securedObjectId")) {
/*  61 */       this._securedObjectId = (argSecuredObjectId != null && MANAGE_CASE) ? argSecuredObjectId.toUpperCase() : argSecuredObjectId;
/*     */     }
/*     */   }
/*     */   
/*     */   public Date getCreateDate() {
/*  66 */     return (Date)this._createDate;
/*     */   }
/*     */   
/*     */   public void setCreateDate(Date argCreateDate) {
/*  70 */     if (changed(argCreateDate, this._createDate, "createDate")) {
/*  71 */       this._createDate = (argCreateDate == null || argCreateDate instanceof DtvDate) ? (DtvDate)argCreateDate : new DtvDate(argCreateDate);
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public String getCreateUserId() {
/*  77 */     return this._createUserId;
/*     */   }
/*     */   
/*     */   public void setCreateUserId(String argCreateUserId) {
/*  81 */     if (changed(argCreateUserId, this._createUserId, "createUserId")) {
/*  82 */       this._createUserId = argCreateUserId;
/*     */     }
/*     */   }
/*     */   
/*     */   public Date getUpdateDate() {
/*  87 */     return (Date)this._updateDate;
/*     */   }
/*     */   
/*     */   public void setUpdateDate(Date argUpdateDate) {
/*  91 */     if (changed(argUpdateDate, this._updateDate, "updateDate")) {
/*  92 */       this._updateDate = (argUpdateDate == null || argUpdateDate instanceof DtvDate) ? (DtvDate)argUpdateDate : new DtvDate(argUpdateDate);
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public String getUpdateUserId() {
/*  98 */     return this._updateUserId;
/*     */   }
/*     */   
/*     */   public void setUpdateUserId(String argUpdateUserId) {
/* 102 */     if (changed(argUpdateUserId, this._updateUserId, "updateUserId")) {
/* 103 */       this._updateUserId = argUpdateUserId;
/*     */     }
/*     */   }
/*     */   
/*     */   public String getGroupMembershipRaw() {
/* 108 */     return this._groupMembershipRaw;
/*     */   }
/*     */   
/*     */   public void setGroupMembershipRaw(String argGroupMembershipRaw) {
/* 112 */     if (changed(argGroupMembershipRaw, this._groupMembershipRaw, "groupMembershipRaw")) {
/* 113 */       this._groupMembershipRaw = argGroupMembershipRaw;
/*     */     }
/*     */   }
/*     */   
/*     */   public String getNoAccessSettings() {
/* 118 */     return this._noAccessSettings;
/*     */   }
/*     */   
/*     */   public void setNoAccessSettings(String argNoAccessSettings) {
/* 122 */     if (changed(argNoAccessSettings, this._noAccessSettings, "noAccessSettings")) {
/* 123 */       this._noAccessSettings = argNoAccessSettings;
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public String toString() {
/* 130 */     StringBuilder buf = new StringBuilder(512);
/* 131 */     buf.append(super.toString()).append(" Id: ").append(getObjectId()).append(" Values: ");
/* 132 */     if (getAccessTypeCode() != null) {
/* 133 */       buf.append("accessTypeCode").append("=").append(getAccessTypeCode()).append(" ");
/*     */     }
/* 135 */     if (getOrganizationId() != null) {
/* 136 */       buf.append("organizationId").append("=").append(getOrganizationId()).append(" ");
/*     */     }
/* 138 */     if (getSecuredObjectId() != null) {
/* 139 */       buf.append("securedObjectId").append("=").append(getSecuredObjectId()).append(" ");
/*     */     }
/* 141 */     if (getCreateDate() != null) {
/* 142 */       buf.append("createDate").append("=").append(getCreateDate()).append(" ");
/*     */     }
/* 144 */     if (getCreateUserId() != null) {
/* 145 */       buf.append("createUserId").append("=").append(getCreateUserId()).append(" ");
/*     */     }
/* 147 */     if (getUpdateDate() != null) {
/* 148 */       buf.append("updateDate").append("=").append(getUpdateDate()).append(" ");
/*     */     }
/* 150 */     if (getUpdateUserId() != null) {
/* 151 */       buf.append("updateUserId").append("=").append(getUpdateUserId()).append(" ");
/*     */     }
/* 153 */     if (getGroupMembershipRaw() != null) {
/* 154 */       buf.append("groupMembershipRaw").append("=").append(getGroupMembershipRaw()).append(" ");
/*     */     }
/* 156 */     if (getNoAccessSettings() != null) {
/* 157 */       buf.append("noAccessSettings").append("=").append(getNoAccessSettings()).append(" ");
/*     */     }
/*     */     
/* 160 */     return buf.toString();
/*     */   }
/*     */   
/*     */   public IObjectId getObjectId() {
/* 164 */     AclAccessTypeId id = new AclAccessTypeId();
/* 165 */     id.setAccessTypeCode(getAccessTypeCode());
/* 166 */     id.setOrganizationId(getOrganizationId());
/* 167 */     id.setSecuredObjectId(getSecuredObjectId());
/* 168 */     return (IObjectId)id;
/*     */   }
/*     */   
/*     */   public void setObjectId(IObjectId argObjectId) {
/* 172 */     setAccessTypeCode(((AclAccessTypeId)argObjectId).getAccessTypeCode());
/* 173 */     setOrganizationId(((AclAccessTypeId)argObjectId).getOrganizationId());
/* 174 */     setSecuredObjectId(((AclAccessTypeId)argObjectId).getSecuredObjectId());
/*     */   }
/*     */   
/*     */   public String getImplementingClass() {
/* 178 */     return null;
/*     */   }
/*     */   
/*     */   public String toXmlString() {
/* 182 */     StringBuilder buf = new StringBuilder(450);
/* 183 */     buf.append("<").append("dao").append(" name=\"AclAccessType\" cmd=\"" + getObjectStateString() + "\">");
/* 184 */     getFieldsAsXml(buf);
/* 185 */     buf.append("</").append("dao").append(">");
/*     */     
/* 187 */     return buf.toString();
/*     */   }
/*     */   
/*     */   public Map<String, String> getValues() {
/* 191 */     Map<String, String> values = super.getValues();
/* 192 */     if (this._accessTypeCode != null) values.put("AccessTypeCode", DaoUtils.getXmlSafeFieldValue(12, this._accessTypeCode)); 
/* 193 */     if (this._organizationId != null) values.put("OrganizationId", DaoUtils.getXmlSafeFieldValue(-5, this._organizationId)); 
/* 194 */     if (this._securedObjectId != null) values.put("SecuredObjectId", DaoUtils.getXmlSafeFieldValue(12, this._securedObjectId)); 
/* 195 */     if (this._createDate != null) values.put("CreateDate", DaoUtils.getXmlSafeFieldValue(91, this._createDate)); 
/* 196 */     if (this._createUserId != null) values.put("CreateUserId", DaoUtils.getXmlSafeFieldValue(12, this._createUserId)); 
/* 197 */     if (this._updateDate != null) values.put("UpdateDate", DaoUtils.getXmlSafeFieldValue(91, this._updateDate)); 
/* 198 */     if (this._updateUserId != null) values.put("UpdateUserId", DaoUtils.getXmlSafeFieldValue(12, this._updateUserId)); 
/* 199 */     if (this._groupMembershipRaw != null) values.put("GroupMembershipRaw", DaoUtils.getXmlSafeFieldValue(2005, this._groupMembershipRaw)); 
/* 200 */     if (this._noAccessSettings != null) values.put("NoAccessSettings", DaoUtils.getXmlSafeFieldValue(12, this._noAccessSettings)); 
/* 201 */     return values;
/*     */   }
/*     */ 
/*     */   
/*     */   public void setValues(Map<String, String> argValues) {
/* 206 */     super.setValues(argValues);
/* 207 */     for (Map.Entry<String, String> field : argValues.entrySet()) {
/*     */       
/* 209 */       String fieldName = field.getKey();
/* 210 */       String fieldValue = field.getValue();
/* 211 */       switch (fieldName) {
/*     */         
/*     */         case "AccessTypeCode":
/*     */           try {
/* 215 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 216 */             setAccessTypeCode((String)value);
/* 217 */           } catch (Exception ee) {
/* 218 */             throw new DtxException("An exception occurred while calling setAccessTypeCode() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "OrganizationId":
/*     */           try {
/* 224 */             Object value = DaoUtils.getFieldValueForXmlString(-5, fieldValue);
/* 225 */             setOrganizationId((Long)value);
/* 226 */           } catch (Exception ee) {
/* 227 */             throw new DtxException("An exception occurred while calling setOrganizationId() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "SecuredObjectId":
/*     */           try {
/* 233 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 234 */             setSecuredObjectId((String)value);
/* 235 */           } catch (Exception ee) {
/* 236 */             throw new DtxException("An exception occurred while calling setSecuredObjectId() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "CreateDate":
/*     */           try {
/* 242 */             Object value = DaoUtils.getFieldValueForXmlString(91, fieldValue);
/* 243 */             setCreateDate((Date)value);
/* 244 */           } catch (Exception ee) {
/* 245 */             throw new DtxException("An exception occurred while calling setCreateDate() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "CreateUserId":
/*     */           try {
/* 251 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 252 */             setCreateUserId((String)value);
/* 253 */           } catch (Exception ee) {
/* 254 */             throw new DtxException("An exception occurred while calling setCreateUserId() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "UpdateDate":
/*     */           try {
/* 260 */             Object value = DaoUtils.getFieldValueForXmlString(91, fieldValue);
/* 261 */             setUpdateDate((Date)value);
/* 262 */           } catch (Exception ee) {
/* 263 */             throw new DtxException("An exception occurred while calling setUpdateDate() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "UpdateUserId":
/*     */           try {
/* 269 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 270 */             setUpdateUserId((String)value);
/* 271 */           } catch (Exception ee) {
/* 272 */             throw new DtxException("An exception occurred while calling setUpdateUserId() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "GroupMembershipRaw":
/*     */           try {
/* 278 */             Object value = DaoUtils.getFieldValueForXmlString(2005, fieldValue);
/* 279 */             setGroupMembershipRaw((String)value);
/* 280 */           } catch (Exception ee) {
/* 281 */             throw new DtxException("An exception occurred while calling setGroupMembershipRaw() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "NoAccessSettings":
/*     */           try {
/* 287 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 288 */             setNoAccessSettings((String)value);
/* 289 */           } catch (Exception ee) {
/* 290 */             throw new DtxException("An exception occurred while calling setNoAccessSettings() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */       } 
/*     */     } 
/*     */   }
/*     */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\sec\impl\AclAccessTypeDAO.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */