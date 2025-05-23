/*     */ package dtv.xst.dao.hrs.impl;
/*     */ 
/*     */ import dtv.data2.access.DaoUtils;
/*     */ import dtv.data2.access.IObjectId;
/*     */ import dtv.data2.access.exception.DtxException;
/*     */ import dtv.data2.access.impl.AbstractDAOImpl;
/*     */ import dtv.util.DtvDate;
/*     */ import dtv.xst.dao.hrs.EmployeePasswordId;
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
/*     */ public class EmployeePasswordDAO
/*     */   extends AbstractDAOImpl
/*     */ {
/*     */   private static final long serialVersionUID = 1636350857L;
/*  23 */   private static final Logger _logger = Logger.getLogger(EmployeePasswordDAO.class);
/*     */   
/*     */   private Long _organizationId;
/*     */   private String _employeeId;
/*     */   private Integer _sequence;
/*     */   private DtvDate _createDate;
/*     */   private String _createUserId;
/*     */   private DtvDate _updateDate;
/*     */   private String _updateUserId;
/*     */   private String _password;
/*     */   private DtvDate _effectiveDate;
/*  34 */   private Boolean _temporary = Boolean.FALSE;
/*  35 */   private Boolean _current = Boolean.FALSE;
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
/*     */   public String getEmployeeId() {
/*  48 */     return this._employeeId;
/*     */   }
/*     */   
/*     */   public void setEmployeeId(String argEmployeeId) {
/*  52 */     if (changed(argEmployeeId, this._employeeId, "employeeId")) {
/*  53 */       this._employeeId = (argEmployeeId != null && MANAGE_CASE) ? argEmployeeId.toUpperCase() : argEmployeeId;
/*     */     }
/*     */   }
/*     */   
/*     */   public Integer getSequence() {
/*  58 */     return this._sequence;
/*     */   }
/*     */   
/*     */   public void setSequence(Integer argSequence) {
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
/*     */   public String getPassword() {
/* 110 */     return this._password;
/*     */   }
/*     */   
/*     */   public void setPassword(String argPassword) {
/* 114 */     if (changed(argPassword, this._password, "password")) {
/* 115 */       this._password = argPassword;
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
/*     */   public Boolean getTemporary() {
/* 131 */     return this._temporary;
/*     */   }
/*     */   
/*     */   public void setTemporary(Boolean argTemporary) {
/* 135 */     if (changed(argTemporary, this._temporary, "temporary")) {
/* 136 */       this._temporary = argTemporary;
/*     */     }
/*     */   }
/*     */   
/*     */   public Boolean getCurrent() {
/* 141 */     return this._current;
/*     */   }
/*     */   
/*     */   public void setCurrent(Boolean argCurrent) {
/* 145 */     if (changed(argCurrent, this._current, "current")) {
/* 146 */       this._current = argCurrent;
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public String toString() {
/* 153 */     StringBuilder buf = new StringBuilder(512);
/* 154 */     buf.append(super.toString()).append(" Id: ").append(getObjectId()).append(" Values: ");
/* 155 */     if (getOrganizationId() != null) {
/* 156 */       buf.append("organizationId").append("=").append(getOrganizationId()).append(" ");
/*     */     }
/* 158 */     if (getEmployeeId() != null) {
/* 159 */       buf.append("employeeId").append("=").append(getEmployeeId()).append(" ");
/*     */     }
/* 161 */     if (getSequence() != null) {
/* 162 */       buf.append("sequence").append("=").append(getSequence()).append(" ");
/*     */     }
/* 164 */     if (getCreateDate() != null) {
/* 165 */       buf.append("createDate").append("=").append(getCreateDate()).append(" ");
/*     */     }
/* 167 */     if (getCreateUserId() != null) {
/* 168 */       buf.append("createUserId").append("=").append(getCreateUserId()).append(" ");
/*     */     }
/* 170 */     if (getUpdateDate() != null) {
/* 171 */       buf.append("updateDate").append("=").append(getUpdateDate()).append(" ");
/*     */     }
/* 173 */     if (getUpdateUserId() != null) {
/* 174 */       buf.append("updateUserId").append("=").append(getUpdateUserId()).append(" ");
/*     */     }
/* 176 */     if (getPassword() != null) {
/* 177 */       buf.append("password").append("=").append("[REDACTED]").append(" ");
/*     */     }
/* 179 */     if (getEffectiveDate() != null) {
/* 180 */       buf.append("effectiveDate").append("=").append(getEffectiveDate()).append(" ");
/*     */     }
/* 182 */     if (getTemporary() != null && getTemporary().booleanValue()) {
/* 183 */       buf.append("temporary").append("=").append(getTemporary()).append(" ");
/*     */     }
/* 185 */     if (getCurrent() != null && getCurrent().booleanValue()) {
/* 186 */       buf.append("current").append("=").append(getCurrent()).append(" ");
/*     */     }
/*     */     
/* 189 */     return buf.toString();
/*     */   }
/*     */   
/*     */   public IObjectId getObjectId() {
/* 193 */     EmployeePasswordId id = new EmployeePasswordId();
/* 194 */     id.setOrganizationId(getOrganizationId());
/* 195 */     id.setEmployeeId(getEmployeeId());
/* 196 */     id.setSequence(getSequence());
/* 197 */     return (IObjectId)id;
/*     */   }
/*     */   
/*     */   public void setObjectId(IObjectId argObjectId) {
/* 201 */     setOrganizationId(((EmployeePasswordId)argObjectId).getOrganizationId());
/* 202 */     setEmployeeId(((EmployeePasswordId)argObjectId).getEmployeeId());
/* 203 */     setSequence(((EmployeePasswordId)argObjectId).getSequence());
/*     */   }
/*     */   
/*     */   public String getImplementingClass() {
/* 207 */     return null;
/*     */   }
/*     */   
/*     */   public String toXmlString() {
/* 211 */     StringBuilder buf = new StringBuilder(550);
/* 212 */     buf.append("<").append("dao").append(" name=\"EmployeePassword\" cmd=\"" + getObjectStateString() + "\">");
/* 213 */     getFieldsAsXml(buf);
/* 214 */     buf.append("</").append("dao").append(">");
/*     */     
/* 216 */     return buf.toString();
/*     */   }
/*     */   
/*     */   public Map<String, String> getValues() {
/* 220 */     Map<String, String> values = super.getValues();
/* 221 */     if (this._organizationId != null) values.put("OrganizationId", DaoUtils.getXmlSafeFieldValue(-5, this._organizationId)); 
/* 222 */     if (this._employeeId != null) values.put("EmployeeId", DaoUtils.getXmlSafeFieldValue(12, this._employeeId)); 
/* 223 */     if (this._sequence != null) values.put("Sequence", DaoUtils.getXmlSafeFieldValue(4, this._sequence)); 
/* 224 */     if (this._createDate != null) values.put("CreateDate", DaoUtils.getXmlSafeFieldValue(91, this._createDate)); 
/* 225 */     if (this._createUserId != null) values.put("CreateUserId", DaoUtils.getXmlSafeFieldValue(12, this._createUserId)); 
/* 226 */     if (this._updateDate != null) values.put("UpdateDate", DaoUtils.getXmlSafeFieldValue(91, this._updateDate)); 
/* 227 */     if (this._updateUserId != null) values.put("UpdateUserId", DaoUtils.getXmlSafeFieldValue(12, this._updateUserId)); 
/* 228 */     if (this._password != null) values.put("Password", DaoUtils.getXmlSafeFieldValue(12, this._password)); 
/* 229 */     if (this._effectiveDate != null) values.put("EffectiveDate", DaoUtils.getXmlSafeFieldValue(91, this._effectiveDate)); 
/* 230 */     if (this._temporary != null) values.put("Temporary", DaoUtils.getXmlSafeFieldValue(-7, this._temporary)); 
/* 231 */     if (this._current != null) values.put("Current", DaoUtils.getXmlSafeFieldValue(-7, this._current)); 
/* 232 */     return values;
/*     */   }
/*     */ 
/*     */   
/*     */   public void setValues(Map<String, String> argValues) {
/* 237 */     super.setValues(argValues);
/* 238 */     for (Map.Entry<String, String> field : argValues.entrySet()) {
/*     */       
/* 240 */       String fieldName = field.getKey();
/* 241 */       String fieldValue = field.getValue();
/* 242 */       switch (fieldName) {
/*     */         
/*     */         case "OrganizationId":
/*     */           try {
/* 246 */             Object value = DaoUtils.getFieldValueForXmlString(-5, fieldValue);
/* 247 */             setOrganizationId((Long)value);
/* 248 */           } catch (Exception ee) {
/* 249 */             throw new DtxException("An exception occurred while calling setOrganizationId() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "EmployeeId":
/*     */           try {
/* 255 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 256 */             setEmployeeId((String)value);
/* 257 */           } catch (Exception ee) {
/* 258 */             throw new DtxException("An exception occurred while calling setEmployeeId() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "Sequence":
/*     */           try {
/* 264 */             Object value = DaoUtils.getFieldValueForXmlString(4, fieldValue);
/* 265 */             setSequence((Integer)value);
/* 266 */           } catch (Exception ee) {
/* 267 */             throw new DtxException("An exception occurred while calling setSequence() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "CreateDate":
/*     */           try {
/* 273 */             Object value = DaoUtils.getFieldValueForXmlString(91, fieldValue);
/* 274 */             setCreateDate((Date)value);
/* 275 */           } catch (Exception ee) {
/* 276 */             throw new DtxException("An exception occurred while calling setCreateDate() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "CreateUserId":
/*     */           try {
/* 282 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 283 */             setCreateUserId((String)value);
/* 284 */           } catch (Exception ee) {
/* 285 */             throw new DtxException("An exception occurred while calling setCreateUserId() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "UpdateDate":
/*     */           try {
/* 291 */             Object value = DaoUtils.getFieldValueForXmlString(91, fieldValue);
/* 292 */             setUpdateDate((Date)value);
/* 293 */           } catch (Exception ee) {
/* 294 */             throw new DtxException("An exception occurred while calling setUpdateDate() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "UpdateUserId":
/*     */           try {
/* 300 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 301 */             setUpdateUserId((String)value);
/* 302 */           } catch (Exception ee) {
/* 303 */             throw new DtxException("An exception occurred while calling setUpdateUserId() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "Password":
/*     */           try {
/* 309 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 310 */             setPassword((String)value);
/* 311 */           } catch (Exception ee) {
/* 312 */             throw new DtxException("An exception occurred while calling setPassword() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "EffectiveDate":
/*     */           try {
/* 318 */             Object value = DaoUtils.getFieldValueForXmlString(91, fieldValue);
/* 319 */             setEffectiveDate((Date)value);
/* 320 */           } catch (Exception ee) {
/* 321 */             throw new DtxException("An exception occurred while calling setEffectiveDate() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "Temporary":
/*     */           try {
/* 327 */             Object value = DaoUtils.getFieldValueForXmlString(-7, fieldValue);
/* 328 */             setTemporary((Boolean)value);
/* 329 */           } catch (Exception ee) {
/* 330 */             throw new DtxException("An exception occurred while calling setTemporary() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "Current":
/*     */           try {
/* 336 */             Object value = DaoUtils.getFieldValueForXmlString(-7, fieldValue);
/* 337 */             setCurrent((Boolean)value);
/* 338 */           } catch (Exception ee) {
/* 339 */             throw new DtxException("An exception occurred while calling setCurrent() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */       } 
/*     */     } 
/*     */   }
/*     */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\hrs\impl\EmployeePasswordDAO.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */