/*     */ package dtv.xst.dao.com.impl;
/*     */ 
/*     */ import dtv.data2.access.DaoUtils;
/*     */ import dtv.data2.access.IObjectId;
/*     */ import dtv.data2.access.exception.DtxException;
/*     */ import dtv.data2.access.impl.AbstractDAOImpl;
/*     */ import dtv.util.DtvDate;
/*     */ import dtv.xst.dao.com.ReportDataId;
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
/*     */ public class ReportDataDAO
/*     */   extends AbstractDAOImpl
/*     */ {
/*     */   private static final long serialVersionUID = -370615522L;
/*  23 */   private static final Logger _logger = Logger.getLogger(ReportDataDAO.class);
/*     */   
/*     */   private Long _organizationId;
/*     */   private String _ownerId;
/*     */   private String _ownerType;
/*     */   private String _reportId;
/*     */   private DtvDate _createDate;
/*     */   private String _createUserId;
/*     */   private DtvDate _updateDate;
/*     */   private String _updateUserId;
/*     */   private String _orgCode;
/*     */   private String _orgValue;
/*     */   private Object _reportData;
/*  36 */   private Boolean _delete = Boolean.FALSE;
/*     */   
/*     */   public Long getOrganizationId() {
/*  39 */     return this._organizationId;
/*     */   }
/*     */   
/*     */   public void setOrganizationId(Long argOrganizationId) {
/*  43 */     if (changed(argOrganizationId, this._organizationId, "organizationId")) {
/*  44 */       this._organizationId = argOrganizationId;
/*     */     }
/*     */   }
/*     */   
/*     */   public String getOwnerId() {
/*  49 */     return this._ownerId;
/*     */   }
/*     */   
/*     */   public void setOwnerId(String argOwnerId) {
/*  53 */     if (changed(argOwnerId, this._ownerId, "ownerId")) {
/*  54 */       this._ownerId = (argOwnerId != null && MANAGE_CASE) ? argOwnerId.toUpperCase() : argOwnerId;
/*     */     }
/*     */   }
/*     */   
/*     */   public String getOwnerType() {
/*  59 */     return this._ownerType;
/*     */   }
/*     */   
/*     */   public void setOwnerType(String argOwnerType) {
/*  63 */     if (changed(argOwnerType, this._ownerType, "ownerType")) {
/*  64 */       this._ownerType = (argOwnerType != null && MANAGE_CASE) ? argOwnerType.toUpperCase() : argOwnerType;
/*     */     }
/*     */   }
/*     */   
/*     */   public String getReportId() {
/*  69 */     return this._reportId;
/*     */   }
/*     */   
/*     */   public void setReportId(String argReportId) {
/*  73 */     if (changed(argReportId, this._reportId, "reportId")) {
/*  74 */       this._reportId = (argReportId != null && MANAGE_CASE) ? argReportId.toUpperCase() : argReportId;
/*     */     }
/*     */   }
/*     */   
/*     */   public Date getCreateDate() {
/*  79 */     return (Date)this._createDate;
/*     */   }
/*     */   
/*     */   public void setCreateDate(Date argCreateDate) {
/*  83 */     if (changed(argCreateDate, this._createDate, "createDate")) {
/*  84 */       this._createDate = (argCreateDate == null || argCreateDate instanceof DtvDate) ? (DtvDate)argCreateDate : new DtvDate(argCreateDate);
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public String getCreateUserId() {
/*  90 */     return this._createUserId;
/*     */   }
/*     */   
/*     */   public void setCreateUserId(String argCreateUserId) {
/*  94 */     if (changed(argCreateUserId, this._createUserId, "createUserId")) {
/*  95 */       this._createUserId = argCreateUserId;
/*     */     }
/*     */   }
/*     */   
/*     */   public Date getUpdateDate() {
/* 100 */     return (Date)this._updateDate;
/*     */   }
/*     */   
/*     */   public void setUpdateDate(Date argUpdateDate) {
/* 104 */     if (changed(argUpdateDate, this._updateDate, "updateDate")) {
/* 105 */       this._updateDate = (argUpdateDate == null || argUpdateDate instanceof DtvDate) ? (DtvDate)argUpdateDate : new DtvDate(argUpdateDate);
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public String getUpdateUserId() {
/* 111 */     return this._updateUserId;
/*     */   }
/*     */   
/*     */   public void setUpdateUserId(String argUpdateUserId) {
/* 115 */     if (changed(argUpdateUserId, this._updateUserId, "updateUserId")) {
/* 116 */       this._updateUserId = argUpdateUserId;
/*     */     }
/*     */   }
/*     */   
/*     */   public String getOrgCode() {
/* 121 */     return this._orgCode;
/*     */   }
/*     */   
/*     */   public void setOrgCode(String argOrgCode) {
/* 125 */     if (changed(argOrgCode, this._orgCode, "orgCode")) {
/* 126 */       this._orgCode = argOrgCode;
/*     */     }
/*     */   }
/*     */   
/*     */   public String getOrgValue() {
/* 131 */     return this._orgValue;
/*     */   }
/*     */   
/*     */   public void setOrgValue(String argOrgValue) {
/* 135 */     if (changed(argOrgValue, this._orgValue, "orgValue")) {
/* 136 */       this._orgValue = argOrgValue;
/*     */     }
/*     */   }
/*     */   
/*     */   public Object getReportData() {
/* 141 */     return this._reportData;
/*     */   }
/*     */   
/*     */   public void setReportData(Object argReportData) {
/* 145 */     if (changed(argReportData, this._reportData, "reportData")) {
/* 146 */       this._reportData = argReportData;
/*     */     }
/*     */   }
/*     */   
/*     */   public Boolean getDelete() {
/* 151 */     return this._delete;
/*     */   }
/*     */   
/*     */   public void setDelete(Boolean argDelete) {
/* 155 */     if (changed(argDelete, this._delete, "delete")) {
/* 156 */       this._delete = argDelete;
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public String toString() {
/* 163 */     StringBuilder buf = new StringBuilder(512);
/* 164 */     buf.append(super.toString()).append(" Id: ").append(getObjectId()).append(" Values: ");
/* 165 */     if (getOrganizationId() != null) {
/* 166 */       buf.append("organizationId").append("=").append(getOrganizationId()).append(" ");
/*     */     }
/* 168 */     if (getOwnerId() != null) {
/* 169 */       buf.append("ownerId").append("=").append(getOwnerId()).append(" ");
/*     */     }
/* 171 */     if (getOwnerType() != null) {
/* 172 */       buf.append("ownerType").append("=").append(getOwnerType()).append(" ");
/*     */     }
/* 174 */     if (getReportId() != null) {
/* 175 */       buf.append("reportId").append("=").append(getReportId()).append(" ");
/*     */     }
/* 177 */     if (getCreateDate() != null) {
/* 178 */       buf.append("createDate").append("=").append(getCreateDate()).append(" ");
/*     */     }
/* 180 */     if (getCreateUserId() != null) {
/* 181 */       buf.append("createUserId").append("=").append(getCreateUserId()).append(" ");
/*     */     }
/* 183 */     if (getUpdateDate() != null) {
/* 184 */       buf.append("updateDate").append("=").append(getUpdateDate()).append(" ");
/*     */     }
/* 186 */     if (getUpdateUserId() != null) {
/* 187 */       buf.append("updateUserId").append("=").append(getUpdateUserId()).append(" ");
/*     */     }
/* 189 */     if (getOrgCode() != null) {
/* 190 */       buf.append("orgCode").append("=").append(getOrgCode()).append(" ");
/*     */     }
/* 192 */     if (getOrgValue() != null) {
/* 193 */       buf.append("orgValue").append("=").append(getOrgValue()).append(" ");
/*     */     }
/* 195 */     if (getReportData() != null) {
/* 196 */       buf.append("reportData").append("=").append(getReportData()).append(" ");
/*     */     }
/* 198 */     if (getDelete() != null && getDelete().booleanValue()) {
/* 199 */       buf.append("delete").append("=").append(getDelete()).append(" ");
/*     */     }
/*     */     
/* 202 */     return buf.toString();
/*     */   }
/*     */   
/*     */   public IObjectId getObjectId() {
/* 206 */     ReportDataId id = new ReportDataId();
/* 207 */     id.setOrganizationId(getOrganizationId());
/* 208 */     id.setOwnerId(getOwnerId());
/* 209 */     id.setOwnerType(getOwnerType());
/* 210 */     id.setReportId(getReportId());
/* 211 */     return (IObjectId)id;
/*     */   }
/*     */   
/*     */   public void setObjectId(IObjectId argObjectId) {
/* 215 */     setOrganizationId(((ReportDataId)argObjectId).getOrganizationId());
/* 216 */     setOwnerId(((ReportDataId)argObjectId).getOwnerId());
/* 217 */     setOwnerType(((ReportDataId)argObjectId).getOwnerType());
/* 218 */     setReportId(((ReportDataId)argObjectId).getReportId());
/*     */   }
/*     */   
/*     */   public String getImplementingClass() {
/* 222 */     return null;
/*     */   }
/*     */   
/*     */   public String toXmlString() {
/* 226 */     StringBuilder buf = new StringBuilder(600);
/* 227 */     buf.append("<").append("dao").append(" name=\"ReportData\" cmd=\"" + getObjectStateString() + "\">");
/* 228 */     getFieldsAsXml(buf);
/* 229 */     buf.append("</").append("dao").append(">");
/*     */     
/* 231 */     return buf.toString();
/*     */   }
/*     */   
/*     */   public Map<String, String> getValues() {
/* 235 */     Map<String, String> values = super.getValues();
/* 236 */     if (this._organizationId != null) values.put("OrganizationId", DaoUtils.getXmlSafeFieldValue(-5, this._organizationId)); 
/* 237 */     if (this._ownerId != null) values.put("OwnerId", DaoUtils.getXmlSafeFieldValue(12, this._ownerId)); 
/* 238 */     if (this._ownerType != null) values.put("OwnerType", DaoUtils.getXmlSafeFieldValue(12, this._ownerType)); 
/* 239 */     if (this._reportId != null) values.put("ReportId", DaoUtils.getXmlSafeFieldValue(12, this._reportId)); 
/* 240 */     if (this._createDate != null) values.put("CreateDate", DaoUtils.getXmlSafeFieldValue(91, this._createDate)); 
/* 241 */     if (this._createUserId != null) values.put("CreateUserId", DaoUtils.getXmlSafeFieldValue(12, this._createUserId)); 
/* 242 */     if (this._updateDate != null) values.put("UpdateDate", DaoUtils.getXmlSafeFieldValue(91, this._updateDate)); 
/* 243 */     if (this._updateUserId != null) values.put("UpdateUserId", DaoUtils.getXmlSafeFieldValue(12, this._updateUserId)); 
/* 244 */     if (this._orgCode != null) values.put("OrgCode", DaoUtils.getXmlSafeFieldValue(12, this._orgCode)); 
/* 245 */     if (this._orgValue != null) values.put("OrgValue", DaoUtils.getXmlSafeFieldValue(12, this._orgValue)); 
/* 246 */     if (this._reportData != null) values.put("ReportData", DaoUtils.getXmlSafeFieldValue(-4, this._reportData)); 
/* 247 */     if (this._delete != null) values.put("Delete", DaoUtils.getXmlSafeFieldValue(-7, this._delete)); 
/* 248 */     return values;
/*     */   }
/*     */ 
/*     */   
/*     */   public void setValues(Map<String, String> argValues) {
/* 253 */     super.setValues(argValues);
/* 254 */     for (Map.Entry<String, String> field : argValues.entrySet()) {
/*     */       
/* 256 */       String fieldName = field.getKey();
/* 257 */       String fieldValue = field.getValue();
/* 258 */       switch (fieldName) {
/*     */         
/*     */         case "OrganizationId":
/*     */           try {
/* 262 */             Object value = DaoUtils.getFieldValueForXmlString(-5, fieldValue);
/* 263 */             setOrganizationId((Long)value);
/* 264 */           } catch (Exception ee) {
/* 265 */             throw new DtxException("An exception occurred while calling setOrganizationId() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "OwnerId":
/*     */           try {
/* 271 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 272 */             setOwnerId((String)value);
/* 273 */           } catch (Exception ee) {
/* 274 */             throw new DtxException("An exception occurred while calling setOwnerId() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "OwnerType":
/*     */           try {
/* 280 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 281 */             setOwnerType((String)value);
/* 282 */           } catch (Exception ee) {
/* 283 */             throw new DtxException("An exception occurred while calling setOwnerType() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "ReportId":
/*     */           try {
/* 289 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 290 */             setReportId((String)value);
/* 291 */           } catch (Exception ee) {
/* 292 */             throw new DtxException("An exception occurred while calling setReportId() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "CreateDate":
/*     */           try {
/* 298 */             Object value = DaoUtils.getFieldValueForXmlString(91, fieldValue);
/* 299 */             setCreateDate((Date)value);
/* 300 */           } catch (Exception ee) {
/* 301 */             throw new DtxException("An exception occurred while calling setCreateDate() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "CreateUserId":
/*     */           try {
/* 307 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 308 */             setCreateUserId((String)value);
/* 309 */           } catch (Exception ee) {
/* 310 */             throw new DtxException("An exception occurred while calling setCreateUserId() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "UpdateDate":
/*     */           try {
/* 316 */             Object value = DaoUtils.getFieldValueForXmlString(91, fieldValue);
/* 317 */             setUpdateDate((Date)value);
/* 318 */           } catch (Exception ee) {
/* 319 */             throw new DtxException("An exception occurred while calling setUpdateDate() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "UpdateUserId":
/*     */           try {
/* 325 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 326 */             setUpdateUserId((String)value);
/* 327 */           } catch (Exception ee) {
/* 328 */             throw new DtxException("An exception occurred while calling setUpdateUserId() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "OrgCode":
/*     */           try {
/* 334 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 335 */             setOrgCode((String)value);
/* 336 */           } catch (Exception ee) {
/* 337 */             throw new DtxException("An exception occurred while calling setOrgCode() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "OrgValue":
/*     */           try {
/* 343 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 344 */             setOrgValue((String)value);
/* 345 */           } catch (Exception ee) {
/* 346 */             throw new DtxException("An exception occurred while calling setOrgValue() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "ReportData":
/*     */           try {
/* 352 */             Object value = DaoUtils.getFieldValueForXmlString(-4, fieldValue);
/* 353 */             setReportData(value);
/* 354 */           } catch (Exception ee) {
/* 355 */             throw new DtxException("An exception occurred while calling setReportData() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "Delete":
/*     */           try {
/* 361 */             Object value = DaoUtils.getFieldValueForXmlString(-7, fieldValue);
/* 362 */             setDelete((Boolean)value);
/* 363 */           } catch (Exception ee) {
/* 364 */             throw new DtxException("An exception occurred while calling setDelete() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */       } 
/*     */     } 
/*     */   }
/*     */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\com\impl\ReportDataDAO.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */