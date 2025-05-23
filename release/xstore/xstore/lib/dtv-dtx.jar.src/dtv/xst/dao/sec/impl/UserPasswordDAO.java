/*     */ package dtv.xst.dao.sec.impl;
/*     */ 
/*     */ import dtv.data2.access.DaoUtils;
/*     */ import dtv.data2.access.IObjectId;
/*     */ import dtv.data2.access.exception.DtxException;
/*     */ import dtv.data2.access.impl.AbstractDAOImpl;
/*     */ import dtv.util.DtvDate;
/*     */ import dtv.xst.dao.sec.UserPasswordId;
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
/*     */ public class UserPasswordDAO
/*     */   extends AbstractDAOImpl
/*     */ {
/*     */   private static final long serialVersionUID = 613376934L;
/*  23 */   private static final Logger _logger = Logger.getLogger(UserPasswordDAO.class);
/*     */   
/*     */   private Long _organizationId;
/*     */   private String _user;
/*     */   private Long _sequence;
/*     */   private DtvDate _createDate;
/*     */   private String _createUserId;
/*     */   private DtvDate _updateDate;
/*     */   private String _updateUserId;
/*     */   private String _hash;
/*     */   private DtvDate _effectiveDate;
/*     */   private Integer _failedAttempts;
/*     */   private DtvDate _lockedOutTimeStamp;
/*     */   
/*     */   public Long getOrganizationId() {
/*  38 */     return this._organizationId;
/*     */   }
/*     */   
/*     */   public void setOrganizationId(Long argOrganizationId) {
/*  42 */     if (changed(argOrganizationId, this._organizationId, "organizationId")) {
/*  43 */       this._organizationId = argOrganizationId;
/*     */     }
/*     */   }
/*     */   
/*     */   public String getUser() {
/*  48 */     return this._user;
/*     */   }
/*     */   
/*     */   public void setUser(String argUser) {
/*  52 */     if (changed(argUser, this._user, "user")) {
/*  53 */       this._user = (argUser != null && MANAGE_CASE) ? argUser.toUpperCase() : argUser;
/*     */     }
/*     */   }
/*     */   
/*     */   public Long getSequence() {
/*  58 */     return this._sequence;
/*     */   }
/*     */   
/*     */   public void setSequence(Long argSequence) {
/*  62 */     if (changed(argSequence, this._sequence, "sequence")) {
/*  63 */       this._sequence = argSequence;
/*     */     }
/*     */   }
/*     */   
/*     */   public Date getCreateDate() {
/*  68 */     return (Date)this._createDate;
/*     */   }
/*     */   
/*     */   public void setCreateDate(Date argCreateDate) {
/*  72 */     if (changed(argCreateDate, this._createDate, "createDate")) {
/*  73 */       this._createDate = (argCreateDate == null || argCreateDate instanceof DtvDate) ? (DtvDate)argCreateDate : new DtvDate(argCreateDate);
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public String getCreateUserId() {
/*  79 */     return this._createUserId;
/*     */   }
/*     */   
/*     */   public void setCreateUserId(String argCreateUserId) {
/*  83 */     if (changed(argCreateUserId, this._createUserId, "createUserId")) {
/*  84 */       this._createUserId = argCreateUserId;
/*     */     }
/*     */   }
/*     */   
/*     */   public Date getUpdateDate() {
/*  89 */     return (Date)this._updateDate;
/*     */   }
/*     */   
/*     */   public void setUpdateDate(Date argUpdateDate) {
/*  93 */     if (changed(argUpdateDate, this._updateDate, "updateDate")) {
/*  94 */       this._updateDate = (argUpdateDate == null || argUpdateDate instanceof DtvDate) ? (DtvDate)argUpdateDate : new DtvDate(argUpdateDate);
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public String getUpdateUserId() {
/* 100 */     return this._updateUserId;
/*     */   }
/*     */   
/*     */   public void setUpdateUserId(String argUpdateUserId) {
/* 104 */     if (changed(argUpdateUserId, this._updateUserId, "updateUserId")) {
/* 105 */       this._updateUserId = argUpdateUserId;
/*     */     }
/*     */   }
/*     */   
/*     */   public String getHash() {
/* 110 */     return this._hash;
/*     */   }
/*     */   
/*     */   public void setHash(String argHash) {
/* 114 */     if (changed(argHash, this._hash, "hash")) {
/* 115 */       this._hash = argHash;
/*     */     }
/*     */   }
/*     */   
/*     */   public Date getEffectiveDate() {
/* 120 */     return (Date)this._effectiveDate;
/*     */   }
/*     */   
/*     */   public void setEffectiveDate(Date argEffectiveDate) {
/* 124 */     if (changed(argEffectiveDate, this._effectiveDate, "effectiveDate")) {
/* 125 */       this._effectiveDate = (argEffectiveDate == null || argEffectiveDate instanceof DtvDate) ? (DtvDate)argEffectiveDate : new DtvDate(argEffectiveDate);
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public Integer getFailedAttempts() {
/* 131 */     return this._failedAttempts;
/*     */   }
/*     */   
/*     */   public void setFailedAttempts(Integer argFailedAttempts) {
/* 135 */     if (changed(argFailedAttempts, this._failedAttempts, "failedAttempts")) {
/* 136 */       this._failedAttempts = argFailedAttempts;
/*     */     }
/*     */   }
/*     */   
/*     */   public Date getLockedOutTimeStamp() {
/* 141 */     return (Date)this._lockedOutTimeStamp;
/*     */   }
/*     */   
/*     */   public void setLockedOutTimeStamp(Date argLockedOutTimeStamp) {
/* 145 */     if (changed(argLockedOutTimeStamp, this._lockedOutTimeStamp, "lockedOutTimeStamp")) {
/* 146 */       this._lockedOutTimeStamp = (argLockedOutTimeStamp == null || argLockedOutTimeStamp instanceof DtvDate) ? (DtvDate)argLockedOutTimeStamp : new DtvDate(argLockedOutTimeStamp);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String toString() {
/* 154 */     StringBuilder buf = new StringBuilder(512);
/* 155 */     buf.append(super.toString()).append(" Id: ").append(getObjectId()).append(" Values: ");
/* 156 */     if (getOrganizationId() != null) {
/* 157 */       buf.append("organizationId").append("=").append(getOrganizationId()).append(" ");
/*     */     }
/* 159 */     if (getUser() != null) {
/* 160 */       buf.append("user").append("=").append(getUser()).append(" ");
/*     */     }
/* 162 */     if (getSequence() != null) {
/* 163 */       buf.append("sequence").append("=").append(getSequence()).append(" ");
/*     */     }
/* 165 */     if (getCreateDate() != null) {
/* 166 */       buf.append("createDate").append("=").append(getCreateDate()).append(" ");
/*     */     }
/* 168 */     if (getCreateUserId() != null) {
/* 169 */       buf.append("createUserId").append("=").append(getCreateUserId()).append(" ");
/*     */     }
/* 171 */     if (getUpdateDate() != null) {
/* 172 */       buf.append("updateDate").append("=").append(getUpdateDate()).append(" ");
/*     */     }
/* 174 */     if (getUpdateUserId() != null) {
/* 175 */       buf.append("updateUserId").append("=").append(getUpdateUserId()).append(" ");
/*     */     }
/* 177 */     if (getHash() != null) {
/* 178 */       buf.append("hash").append("=").append(getHash()).append(" ");
/*     */     }
/* 180 */     if (getEffectiveDate() != null) {
/* 181 */       buf.append("effectiveDate").append("=").append(getEffectiveDate()).append(" ");
/*     */     }
/* 183 */     if (getFailedAttempts() != null) {
/* 184 */       buf.append("failedAttempts").append("=").append(getFailedAttempts()).append(" ");
/*     */     }
/* 186 */     if (getLockedOutTimeStamp() != null) {
/* 187 */       buf.append("lockedOutTimeStamp").append("=").append(getLockedOutTimeStamp()).append(" ");
/*     */     }
/*     */     
/* 190 */     return buf.toString();
/*     */   }
/*     */   
/*     */   public IObjectId getObjectId() {
/* 194 */     UserPasswordId id = new UserPasswordId();
/* 195 */     id.setOrganizationId(getOrganizationId());
/* 196 */     id.setUser(getUser());
/* 197 */     id.setSequence(getSequence());
/* 198 */     return (IObjectId)id;
/*     */   }
/*     */   
/*     */   public void setObjectId(IObjectId argObjectId) {
/* 202 */     setOrganizationId(((UserPasswordId)argObjectId).getOrganizationId());
/* 203 */     setUser(((UserPasswordId)argObjectId).getUser());
/* 204 */     setSequence(((UserPasswordId)argObjectId).getSequence());
/*     */   }
/*     */   
/*     */   public String getImplementingClass() {
/* 208 */     return null;
/*     */   }
/*     */   
/*     */   public String toXmlString() {
/* 212 */     StringBuilder buf = new StringBuilder(550);
/* 213 */     buf.append("<").append("dao").append(" name=\"UserPassword\" cmd=\"" + getObjectStateString() + "\">");
/* 214 */     getFieldsAsXml(buf);
/* 215 */     buf.append("</").append("dao").append(">");
/*     */     
/* 217 */     return buf.toString();
/*     */   }
/*     */   
/*     */   public Map<String, String> getValues() {
/* 221 */     Map<String, String> values = super.getValues();
/* 222 */     if (this._organizationId != null) values.put("OrganizationId", DaoUtils.getXmlSafeFieldValue(-5, this._organizationId)); 
/* 223 */     if (this._user != null) values.put("User", DaoUtils.getXmlSafeFieldValue(12, this._user)); 
/* 224 */     if (this._sequence != null) values.put("Sequence", DaoUtils.getXmlSafeFieldValue(-5, this._sequence)); 
/* 225 */     if (this._createDate != null) values.put("CreateDate", DaoUtils.getXmlSafeFieldValue(91, this._createDate)); 
/* 226 */     if (this._createUserId != null) values.put("CreateUserId", DaoUtils.getXmlSafeFieldValue(12, this._createUserId)); 
/* 227 */     if (this._updateDate != null) values.put("UpdateDate", DaoUtils.getXmlSafeFieldValue(91, this._updateDate)); 
/* 228 */     if (this._updateUserId != null) values.put("UpdateUserId", DaoUtils.getXmlSafeFieldValue(12, this._updateUserId)); 
/* 229 */     if (this._hash != null) values.put("Hash", DaoUtils.getXmlSafeFieldValue(12, this._hash)); 
/* 230 */     if (this._effectiveDate != null) values.put("EffectiveDate", DaoUtils.getXmlSafeFieldValue(91, this._effectiveDate)); 
/* 231 */     if (this._failedAttempts != null) values.put("FailedAttempts", DaoUtils.getXmlSafeFieldValue(4, this._failedAttempts)); 
/* 232 */     if (this._lockedOutTimeStamp != null) values.put("LockedOutTimeStamp", DaoUtils.getXmlSafeFieldValue(91, this._lockedOutTimeStamp)); 
/* 233 */     return values;
/*     */   }
/*     */ 
/*     */   
/*     */   public void setValues(Map<String, String> argValues) {
/* 238 */     super.setValues(argValues);
/* 239 */     for (Map.Entry<String, String> field : argValues.entrySet()) {
/*     */       
/* 241 */       String fieldName = field.getKey();
/* 242 */       String fieldValue = field.getValue();
/* 243 */       switch (fieldName) {
/*     */         
/*     */         case "OrganizationId":
/*     */           try {
/* 247 */             Object value = DaoUtils.getFieldValueForXmlString(-5, fieldValue);
/* 248 */             setOrganizationId((Long)value);
/* 249 */           } catch (Exception ee) {
/* 250 */             throw new DtxException("An exception occurred while calling setOrganizationId() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "User":
/*     */           try {
/* 256 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 257 */             setUser((String)value);
/* 258 */           } catch (Exception ee) {
/* 259 */             throw new DtxException("An exception occurred while calling setUser() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "Sequence":
/*     */           try {
/* 265 */             Object value = DaoUtils.getFieldValueForXmlString(-5, fieldValue);
/* 266 */             setSequence((Long)value);
/* 267 */           } catch (Exception ee) {
/* 268 */             throw new DtxException("An exception occurred while calling setSequence() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "CreateDate":
/*     */           try {
/* 274 */             Object value = DaoUtils.getFieldValueForXmlString(91, fieldValue);
/* 275 */             setCreateDate((Date)value);
/* 276 */           } catch (Exception ee) {
/* 277 */             throw new DtxException("An exception occurred while calling setCreateDate() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "CreateUserId":
/*     */           try {
/* 283 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 284 */             setCreateUserId((String)value);
/* 285 */           } catch (Exception ee) {
/* 286 */             throw new DtxException("An exception occurred while calling setCreateUserId() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "UpdateDate":
/*     */           try {
/* 292 */             Object value = DaoUtils.getFieldValueForXmlString(91, fieldValue);
/* 293 */             setUpdateDate((Date)value);
/* 294 */           } catch (Exception ee) {
/* 295 */             throw new DtxException("An exception occurred while calling setUpdateDate() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "UpdateUserId":
/*     */           try {
/* 301 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 302 */             setUpdateUserId((String)value);
/* 303 */           } catch (Exception ee) {
/* 304 */             throw new DtxException("An exception occurred while calling setUpdateUserId() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "Hash":
/*     */           try {
/* 310 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 311 */             setHash((String)value);
/* 312 */           } catch (Exception ee) {
/* 313 */             throw new DtxException("An exception occurred while calling setHash() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "EffectiveDate":
/*     */           try {
/* 319 */             Object value = DaoUtils.getFieldValueForXmlString(91, fieldValue);
/* 320 */             setEffectiveDate((Date)value);
/* 321 */           } catch (Exception ee) {
/* 322 */             throw new DtxException("An exception occurred while calling setEffectiveDate() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "FailedAttempts":
/*     */           try {
/* 328 */             Object value = DaoUtils.getFieldValueForXmlString(4, fieldValue);
/* 329 */             setFailedAttempts((Integer)value);
/* 330 */           } catch (Exception ee) {
/* 331 */             throw new DtxException("An exception occurred while calling setFailedAttempts() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "LockedOutTimeStamp":
/*     */           try {
/* 337 */             Object value = DaoUtils.getFieldValueForXmlString(91, fieldValue);
/* 338 */             setLockedOutTimeStamp((Date)value);
/* 339 */           } catch (Exception ee) {
/* 340 */             throw new DtxException("An exception occurred while calling setLockedOutTimeStamp() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */       } 
/*     */     } 
/*     */   }
/*     */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\sec\impl\UserPasswordDAO.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */