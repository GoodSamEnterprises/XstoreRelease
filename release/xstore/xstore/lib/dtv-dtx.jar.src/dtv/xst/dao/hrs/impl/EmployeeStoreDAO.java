/*     */ package dtv.xst.dao.hrs.impl;
/*     */ 
/*     */ import dtv.data2.access.DaoUtils;
/*     */ import dtv.data2.access.IObjectId;
/*     */ import dtv.data2.access.exception.DtxException;
/*     */ import dtv.data2.access.impl.AbstractDAOImpl;
/*     */ import dtv.util.DtvDate;
/*     */ import dtv.xst.dao.hrs.EmployeeStoreId;
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
/*     */ public class EmployeeStoreDAO
/*     */   extends AbstractDAOImpl
/*     */ {
/*     */   private static final long serialVersionUID = -1240510797L;
/*  23 */   private static final Logger _logger = Logger.getLogger(EmployeeStoreDAO.class);
/*     */   
/*     */   private Long _organizationId;
/*     */   private String _employeeId;
/*     */   private Long _retailLocationId;
/*     */   private Integer _employeeStoreSequence;
/*     */   private DtvDate _createDate;
/*     */   private String _createUserId;
/*     */   private DtvDate _updateDate;
/*     */   private String _updateUserId;
/*     */   private DtvDate _beginDate;
/*     */   private DtvDate _endDate;
/*  35 */   private Boolean _temporaryAssignment = Boolean.FALSE;
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
/*     */   public Long getRetailLocationId() {
/*  58 */     return this._retailLocationId;
/*     */   }
/*     */   
/*     */   public void setRetailLocationId(Long argRetailLocationId) {
/*  62 */     if (changed(argRetailLocationId, this._retailLocationId, "retailLocationId")) {
/*  63 */       this._retailLocationId = argRetailLocationId;
/*     */     }
/*     */   }
/*     */   
/*     */   public Integer getEmployeeStoreSequence() {
/*  68 */     return this._employeeStoreSequence;
/*     */   }
/*     */   
/*     */   public void setEmployeeStoreSequence(Integer argEmployeeStoreSequence) {
/*  72 */     if (changed(argEmployeeStoreSequence, this._employeeStoreSequence, "employeeStoreSequence")) {
/*  73 */       this._employeeStoreSequence = argEmployeeStoreSequence;
/*     */     }
/*     */   }
/*     */   
/*     */   public Date getCreateDate() {
/*  78 */     return (Date)this._createDate;
/*     */   }
/*     */   
/*     */   public void setCreateDate(Date argCreateDate) {
/*  82 */     if (changed(argCreateDate, this._createDate, "createDate")) {
/*  83 */       this._createDate = (argCreateDate == null || argCreateDate instanceof DtvDate) ? (DtvDate)argCreateDate : new DtvDate(argCreateDate);
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public String getCreateUserId() {
/*  89 */     return this._createUserId;
/*     */   }
/*     */   
/*     */   public void setCreateUserId(String argCreateUserId) {
/*  93 */     if (changed(argCreateUserId, this._createUserId, "createUserId")) {
/*  94 */       this._createUserId = argCreateUserId;
/*     */     }
/*     */   }
/*     */   
/*     */   public Date getUpdateDate() {
/*  99 */     return (Date)this._updateDate;
/*     */   }
/*     */   
/*     */   public void setUpdateDate(Date argUpdateDate) {
/* 103 */     if (changed(argUpdateDate, this._updateDate, "updateDate")) {
/* 104 */       this._updateDate = (argUpdateDate == null || argUpdateDate instanceof DtvDate) ? (DtvDate)argUpdateDate : new DtvDate(argUpdateDate);
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public String getUpdateUserId() {
/* 110 */     return this._updateUserId;
/*     */   }
/*     */   
/*     */   public void setUpdateUserId(String argUpdateUserId) {
/* 114 */     if (changed(argUpdateUserId, this._updateUserId, "updateUserId")) {
/* 115 */       this._updateUserId = argUpdateUserId;
/*     */     }
/*     */   }
/*     */   
/*     */   public Date getBeginDate() {
/* 120 */     return (Date)this._beginDate;
/*     */   }
/*     */   
/*     */   public void setBeginDate(Date argBeginDate) {
/* 124 */     if (changed(argBeginDate, this._beginDate, "beginDate")) {
/* 125 */       this._beginDate = (argBeginDate == null || argBeginDate instanceof DtvDate) ? (DtvDate)argBeginDate : new DtvDate(argBeginDate);
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public Date getEndDate() {
/* 131 */     return (Date)this._endDate;
/*     */   }
/*     */   
/*     */   public void setEndDate(Date argEndDate) {
/* 135 */     if (changed(argEndDate, this._endDate, "endDate")) {
/* 136 */       this._endDate = (argEndDate == null || argEndDate instanceof DtvDate) ? (DtvDate)argEndDate : new DtvDate(argEndDate);
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public Boolean getTemporaryAssignment() {
/* 142 */     return this._temporaryAssignment;
/*     */   }
/*     */   
/*     */   public void setTemporaryAssignment(Boolean argTemporaryAssignment) {
/* 146 */     if (changed(argTemporaryAssignment, this._temporaryAssignment, "temporaryAssignment")) {
/* 147 */       this._temporaryAssignment = argTemporaryAssignment;
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public String toString() {
/* 154 */     StringBuilder buf = new StringBuilder(512);
/* 155 */     buf.append(super.toString()).append(" Id: ").append(getObjectId()).append(" Values: ");
/* 156 */     if (getOrganizationId() != null) {
/* 157 */       buf.append("organizationId").append("=").append(getOrganizationId()).append(" ");
/*     */     }
/* 159 */     if (getEmployeeId() != null) {
/* 160 */       buf.append("employeeId").append("=").append(getEmployeeId()).append(" ");
/*     */     }
/* 162 */     if (getRetailLocationId() != null) {
/* 163 */       buf.append("retailLocationId").append("=").append(getRetailLocationId()).append(" ");
/*     */     }
/* 165 */     if (getEmployeeStoreSequence() != null) {
/* 166 */       buf.append("employeeStoreSequence").append("=").append(getEmployeeStoreSequence()).append(" ");
/*     */     }
/* 168 */     if (getCreateDate() != null) {
/* 169 */       buf.append("createDate").append("=").append(getCreateDate()).append(" ");
/*     */     }
/* 171 */     if (getCreateUserId() != null) {
/* 172 */       buf.append("createUserId").append("=").append(getCreateUserId()).append(" ");
/*     */     }
/* 174 */     if (getUpdateDate() != null) {
/* 175 */       buf.append("updateDate").append("=").append(getUpdateDate()).append(" ");
/*     */     }
/* 177 */     if (getUpdateUserId() != null) {
/* 178 */       buf.append("updateUserId").append("=").append(getUpdateUserId()).append(" ");
/*     */     }
/* 180 */     if (getBeginDate() != null) {
/* 181 */       buf.append("beginDate").append("=").append(getBeginDate()).append(" ");
/*     */     }
/* 183 */     if (getEndDate() != null) {
/* 184 */       buf.append("endDate").append("=").append(getEndDate()).append(" ");
/*     */     }
/* 186 */     if (getTemporaryAssignment() != null && getTemporaryAssignment().booleanValue()) {
/* 187 */       buf.append("temporaryAssignment").append("=").append(getTemporaryAssignment()).append(" ");
/*     */     }
/*     */     
/* 190 */     return buf.toString();
/*     */   }
/*     */   
/*     */   public IObjectId getObjectId() {
/* 194 */     EmployeeStoreId id = new EmployeeStoreId();
/* 195 */     id.setOrganizationId(getOrganizationId());
/* 196 */     id.setEmployeeId(getEmployeeId());
/* 197 */     id.setRetailLocationId(getRetailLocationId());
/* 198 */     id.setEmployeeStoreSequence(getEmployeeStoreSequence());
/* 199 */     return (IObjectId)id;
/*     */   }
/*     */   
/*     */   public void setObjectId(IObjectId argObjectId) {
/* 203 */     setOrganizationId(((EmployeeStoreId)argObjectId).getOrganizationId());
/* 204 */     setEmployeeId(((EmployeeStoreId)argObjectId).getEmployeeId());
/* 205 */     setRetailLocationId(((EmployeeStoreId)argObjectId).getRetailLocationId());
/* 206 */     setEmployeeStoreSequence(((EmployeeStoreId)argObjectId).getEmployeeStoreSequence());
/*     */   }
/*     */   
/*     */   public String getImplementingClass() {
/* 210 */     return null;
/*     */   }
/*     */   
/*     */   public String toXmlString() {
/* 214 */     StringBuilder buf = new StringBuilder(550);
/* 215 */     buf.append("<").append("dao").append(" name=\"EmployeeStore\" cmd=\"" + getObjectStateString() + "\">");
/* 216 */     getFieldsAsXml(buf);
/* 217 */     buf.append("</").append("dao").append(">");
/*     */     
/* 219 */     return buf.toString();
/*     */   }
/*     */   
/*     */   public Map<String, String> getValues() {
/* 223 */     Map<String, String> values = super.getValues();
/* 224 */     if (this._organizationId != null) values.put("OrganizationId", DaoUtils.getXmlSafeFieldValue(-5, this._organizationId)); 
/* 225 */     if (this._employeeId != null) values.put("EmployeeId", DaoUtils.getXmlSafeFieldValue(12, this._employeeId)); 
/* 226 */     if (this._retailLocationId != null) values.put("RetailLocationId", DaoUtils.getXmlSafeFieldValue(-5, this._retailLocationId)); 
/* 227 */     if (this._employeeStoreSequence != null) values.put("EmployeeStoreSequence", DaoUtils.getXmlSafeFieldValue(4, this._employeeStoreSequence)); 
/* 228 */     if (this._createDate != null) values.put("CreateDate", DaoUtils.getXmlSafeFieldValue(91, this._createDate)); 
/* 229 */     if (this._createUserId != null) values.put("CreateUserId", DaoUtils.getXmlSafeFieldValue(12, this._createUserId)); 
/* 230 */     if (this._updateDate != null) values.put("UpdateDate", DaoUtils.getXmlSafeFieldValue(91, this._updateDate)); 
/* 231 */     if (this._updateUserId != null) values.put("UpdateUserId", DaoUtils.getXmlSafeFieldValue(12, this._updateUserId)); 
/* 232 */     if (this._beginDate != null) values.put("BeginDate", DaoUtils.getXmlSafeFieldValue(91, this._beginDate)); 
/* 233 */     if (this._endDate != null) values.put("EndDate", DaoUtils.getXmlSafeFieldValue(91, this._endDate)); 
/* 234 */     if (this._temporaryAssignment != null) values.put("TemporaryAssignment", DaoUtils.getXmlSafeFieldValue(-7, this._temporaryAssignment)); 
/* 235 */     return values;
/*     */   }
/*     */ 
/*     */   
/*     */   public void setValues(Map<String, String> argValues) {
/* 240 */     super.setValues(argValues);
/* 241 */     for (Map.Entry<String, String> field : argValues.entrySet()) {
/*     */       
/* 243 */       String fieldName = field.getKey();
/* 244 */       String fieldValue = field.getValue();
/* 245 */       switch (fieldName) {
/*     */         
/*     */         case "OrganizationId":
/*     */           try {
/* 249 */             Object value = DaoUtils.getFieldValueForXmlString(-5, fieldValue);
/* 250 */             setOrganizationId((Long)value);
/* 251 */           } catch (Exception ee) {
/* 252 */             throw new DtxException("An exception occurred while calling setOrganizationId() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "EmployeeId":
/*     */           try {
/* 258 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 259 */             setEmployeeId((String)value);
/* 260 */           } catch (Exception ee) {
/* 261 */             throw new DtxException("An exception occurred while calling setEmployeeId() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "RetailLocationId":
/*     */           try {
/* 267 */             Object value = DaoUtils.getFieldValueForXmlString(-5, fieldValue);
/* 268 */             setRetailLocationId((Long)value);
/* 269 */           } catch (Exception ee) {
/* 270 */             throw new DtxException("An exception occurred while calling setRetailLocationId() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "EmployeeStoreSequence":
/*     */           try {
/* 276 */             Object value = DaoUtils.getFieldValueForXmlString(4, fieldValue);
/* 277 */             setEmployeeStoreSequence((Integer)value);
/* 278 */           } catch (Exception ee) {
/* 279 */             throw new DtxException("An exception occurred while calling setEmployeeStoreSequence() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "CreateDate":
/*     */           try {
/* 285 */             Object value = DaoUtils.getFieldValueForXmlString(91, fieldValue);
/* 286 */             setCreateDate((Date)value);
/* 287 */           } catch (Exception ee) {
/* 288 */             throw new DtxException("An exception occurred while calling setCreateDate() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "CreateUserId":
/*     */           try {
/* 294 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 295 */             setCreateUserId((String)value);
/* 296 */           } catch (Exception ee) {
/* 297 */             throw new DtxException("An exception occurred while calling setCreateUserId() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "UpdateDate":
/*     */           try {
/* 303 */             Object value = DaoUtils.getFieldValueForXmlString(91, fieldValue);
/* 304 */             setUpdateDate((Date)value);
/* 305 */           } catch (Exception ee) {
/* 306 */             throw new DtxException("An exception occurred while calling setUpdateDate() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "UpdateUserId":
/*     */           try {
/* 312 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 313 */             setUpdateUserId((String)value);
/* 314 */           } catch (Exception ee) {
/* 315 */             throw new DtxException("An exception occurred while calling setUpdateUserId() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "BeginDate":
/*     */           try {
/* 321 */             Object value = DaoUtils.getFieldValueForXmlString(91, fieldValue);
/* 322 */             setBeginDate((Date)value);
/* 323 */           } catch (Exception ee) {
/* 324 */             throw new DtxException("An exception occurred while calling setBeginDate() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "EndDate":
/*     */           try {
/* 330 */             Object value = DaoUtils.getFieldValueForXmlString(91, fieldValue);
/* 331 */             setEndDate((Date)value);
/* 332 */           } catch (Exception ee) {
/* 333 */             throw new DtxException("An exception occurred while calling setEndDate() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "TemporaryAssignment":
/*     */           try {
/* 339 */             Object value = DaoUtils.getFieldValueForXmlString(-7, fieldValue);
/* 340 */             setTemporaryAssignment((Boolean)value);
/* 341 */           } catch (Exception ee) {
/* 342 */             throw new DtxException("An exception occurred while calling setTemporaryAssignment() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */       } 
/*     */     } 
/*     */   }
/*     */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\hrs\impl\EmployeeStoreDAO.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */