/*     */ package dtv.xst.dao.sec.impl;
/*     */ 
/*     */ import dtv.data2.access.DaoUtils;
/*     */ import dtv.data2.access.IObjectId;
/*     */ import dtv.data2.access.exception.DtxException;
/*     */ import dtv.data2.access.impl.AbstractDAOImpl;
/*     */ import dtv.util.DtvDate;
/*     */ import dtv.xst.dao.sec.AccessControlListId;
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
/*     */ public class AccessControlListDAO
/*     */   extends AbstractDAOImpl
/*     */ {
/*     */   private static final long serialVersionUID = 699875191L;
/*  23 */   private static final Logger _logger = Logger.getLogger(AccessControlListDAO.class);
/*     */   
/*     */   private Long _organizationId;
/*     */   private String _securedObjectId;
/*     */   private DtvDate _createDate;
/*     */   private String _createUserId;
/*     */   private DtvDate _updateDate;
/*     */   private String _updateUserId;
/*  31 */   private Boolean _authenticationRequired = Boolean.FALSE;
/*     */   
/*     */   public Long getOrganizationId() {
/*  34 */     return this._organizationId;
/*     */   }
/*     */   
/*     */   public void setOrganizationId(Long argOrganizationId) {
/*  38 */     if (changed(argOrganizationId, this._organizationId, "organizationId")) {
/*  39 */       this._organizationId = argOrganizationId;
/*     */     }
/*     */   }
/*     */   
/*     */   public String getSecuredObjectId() {
/*  44 */     return this._securedObjectId;
/*     */   }
/*     */   
/*     */   public void setSecuredObjectId(String argSecuredObjectId) {
/*  48 */     if (changed(argSecuredObjectId, this._securedObjectId, "securedObjectId")) {
/*  49 */       this._securedObjectId = (argSecuredObjectId != null && MANAGE_CASE) ? argSecuredObjectId.toUpperCase() : argSecuredObjectId;
/*     */     }
/*     */   }
/*     */   
/*     */   public Date getCreateDate() {
/*  54 */     return (Date)this._createDate;
/*     */   }
/*     */   
/*     */   public void setCreateDate(Date argCreateDate) {
/*  58 */     if (changed(argCreateDate, this._createDate, "createDate")) {
/*  59 */       this._createDate = (argCreateDate == null || argCreateDate instanceof DtvDate) ? (DtvDate)argCreateDate : new DtvDate(argCreateDate);
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public String getCreateUserId() {
/*  65 */     return this._createUserId;
/*     */   }
/*     */   
/*     */   public void setCreateUserId(String argCreateUserId) {
/*  69 */     if (changed(argCreateUserId, this._createUserId, "createUserId")) {
/*  70 */       this._createUserId = argCreateUserId;
/*     */     }
/*     */   }
/*     */   
/*     */   public Date getUpdateDate() {
/*  75 */     return (Date)this._updateDate;
/*     */   }
/*     */   
/*     */   public void setUpdateDate(Date argUpdateDate) {
/*  79 */     if (changed(argUpdateDate, this._updateDate, "updateDate")) {
/*  80 */       this._updateDate = (argUpdateDate == null || argUpdateDate instanceof DtvDate) ? (DtvDate)argUpdateDate : new DtvDate(argUpdateDate);
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public String getUpdateUserId() {
/*  86 */     return this._updateUserId;
/*     */   }
/*     */   
/*     */   public void setUpdateUserId(String argUpdateUserId) {
/*  90 */     if (changed(argUpdateUserId, this._updateUserId, "updateUserId")) {
/*  91 */       this._updateUserId = argUpdateUserId;
/*     */     }
/*     */   }
/*     */   
/*     */   public Boolean getAuthenticationRequired() {
/*  96 */     return this._authenticationRequired;
/*     */   }
/*     */   
/*     */   public void setAuthenticationRequired(Boolean argAuthenticationRequired) {
/* 100 */     if (changed(argAuthenticationRequired, this._authenticationRequired, "authenticationRequired")) {
/* 101 */       this._authenticationRequired = argAuthenticationRequired;
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public String toString() {
/* 108 */     StringBuilder buf = new StringBuilder(512);
/* 109 */     buf.append(super.toString()).append(" Id: ").append(getObjectId()).append(" Values: ");
/* 110 */     if (getOrganizationId() != null) {
/* 111 */       buf.append("organizationId").append("=").append(getOrganizationId()).append(" ");
/*     */     }
/* 113 */     if (getSecuredObjectId() != null) {
/* 114 */       buf.append("securedObjectId").append("=").append(getSecuredObjectId()).append(" ");
/*     */     }
/* 116 */     if (getCreateDate() != null) {
/* 117 */       buf.append("createDate").append("=").append(getCreateDate()).append(" ");
/*     */     }
/* 119 */     if (getCreateUserId() != null) {
/* 120 */       buf.append("createUserId").append("=").append(getCreateUserId()).append(" ");
/*     */     }
/* 122 */     if (getUpdateDate() != null) {
/* 123 */       buf.append("updateDate").append("=").append(getUpdateDate()).append(" ");
/*     */     }
/* 125 */     if (getUpdateUserId() != null) {
/* 126 */       buf.append("updateUserId").append("=").append(getUpdateUserId()).append(" ");
/*     */     }
/* 128 */     if (getAuthenticationRequired() != null && getAuthenticationRequired().booleanValue()) {
/* 129 */       buf.append("authenticationRequired").append("=").append(getAuthenticationRequired()).append(" ");
/*     */     }
/*     */     
/* 132 */     return buf.toString();
/*     */   }
/*     */   
/*     */   public IObjectId getObjectId() {
/* 136 */     AccessControlListId id = new AccessControlListId();
/* 137 */     id.setOrganizationId(getOrganizationId());
/* 138 */     id.setSecuredObjectId(getSecuredObjectId());
/* 139 */     return (IObjectId)id;
/*     */   }
/*     */   
/*     */   public void setObjectId(IObjectId argObjectId) {
/* 143 */     setOrganizationId(((AccessControlListId)argObjectId).getOrganizationId());
/* 144 */     setSecuredObjectId(((AccessControlListId)argObjectId).getSecuredObjectId());
/*     */   }
/*     */   
/*     */   public String getImplementingClass() {
/* 148 */     return null;
/*     */   }
/*     */   
/*     */   public String toXmlString() {
/* 152 */     StringBuilder buf = new StringBuilder(350);
/* 153 */     buf.append("<").append("dao").append(" name=\"AccessControlList\" cmd=\"" + getObjectStateString() + "\">");
/* 154 */     getFieldsAsXml(buf);
/* 155 */     buf.append("</").append("dao").append(">");
/*     */     
/* 157 */     return buf.toString();
/*     */   }
/*     */   
/*     */   public Map<String, String> getValues() {
/* 161 */     Map<String, String> values = super.getValues();
/* 162 */     if (this._organizationId != null) values.put("OrganizationId", DaoUtils.getXmlSafeFieldValue(-5, this._organizationId)); 
/* 163 */     if (this._securedObjectId != null) values.put("SecuredObjectId", DaoUtils.getXmlSafeFieldValue(12, this._securedObjectId)); 
/* 164 */     if (this._createDate != null) values.put("CreateDate", DaoUtils.getXmlSafeFieldValue(91, this._createDate)); 
/* 165 */     if (this._createUserId != null) values.put("CreateUserId", DaoUtils.getXmlSafeFieldValue(12, this._createUserId)); 
/* 166 */     if (this._updateDate != null) values.put("UpdateDate", DaoUtils.getXmlSafeFieldValue(91, this._updateDate)); 
/* 167 */     if (this._updateUserId != null) values.put("UpdateUserId", DaoUtils.getXmlSafeFieldValue(12, this._updateUserId)); 
/* 168 */     if (this._authenticationRequired != null) values.put("AuthenticationRequired", DaoUtils.getXmlSafeFieldValue(-7, this._authenticationRequired)); 
/* 169 */     return values;
/*     */   }
/*     */ 
/*     */   
/*     */   public void setValues(Map<String, String> argValues) {
/* 174 */     super.setValues(argValues);
/* 175 */     for (Map.Entry<String, String> field : argValues.entrySet()) {
/*     */       
/* 177 */       String fieldName = field.getKey();
/* 178 */       String fieldValue = field.getValue();
/* 179 */       switch (fieldName) {
/*     */         
/*     */         case "OrganizationId":
/*     */           try {
/* 183 */             Object value = DaoUtils.getFieldValueForXmlString(-5, fieldValue);
/* 184 */             setOrganizationId((Long)value);
/* 185 */           } catch (Exception ee) {
/* 186 */             throw new DtxException("An exception occurred while calling setOrganizationId() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "SecuredObjectId":
/*     */           try {
/* 192 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 193 */             setSecuredObjectId((String)value);
/* 194 */           } catch (Exception ee) {
/* 195 */             throw new DtxException("An exception occurred while calling setSecuredObjectId() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "CreateDate":
/*     */           try {
/* 201 */             Object value = DaoUtils.getFieldValueForXmlString(91, fieldValue);
/* 202 */             setCreateDate((Date)value);
/* 203 */           } catch (Exception ee) {
/* 204 */             throw new DtxException("An exception occurred while calling setCreateDate() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "CreateUserId":
/*     */           try {
/* 210 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 211 */             setCreateUserId((String)value);
/* 212 */           } catch (Exception ee) {
/* 213 */             throw new DtxException("An exception occurred while calling setCreateUserId() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "UpdateDate":
/*     */           try {
/* 219 */             Object value = DaoUtils.getFieldValueForXmlString(91, fieldValue);
/* 220 */             setUpdateDate((Date)value);
/* 221 */           } catch (Exception ee) {
/* 222 */             throw new DtxException("An exception occurred while calling setUpdateDate() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "UpdateUserId":
/*     */           try {
/* 228 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 229 */             setUpdateUserId((String)value);
/* 230 */           } catch (Exception ee) {
/* 231 */             throw new DtxException("An exception occurred while calling setUpdateUserId() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "AuthenticationRequired":
/*     */           try {
/* 237 */             Object value = DaoUtils.getFieldValueForXmlString(-7, fieldValue);
/* 238 */             setAuthenticationRequired((Boolean)value);
/* 239 */           } catch (Exception ee) {
/* 240 */             throw new DtxException("An exception occurred while calling setAuthenticationRequired() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */       } 
/*     */     } 
/*     */   }
/*     */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\sec\impl\AccessControlListDAO.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */