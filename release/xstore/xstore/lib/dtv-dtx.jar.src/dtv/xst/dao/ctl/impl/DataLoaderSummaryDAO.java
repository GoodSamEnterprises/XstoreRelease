/*     */ package dtv.xst.dao.ctl.impl;
/*     */ 
/*     */ import dtv.data2.access.DaoUtils;
/*     */ import dtv.data2.access.IObjectId;
/*     */ import dtv.data2.access.exception.DtxException;
/*     */ import dtv.data2.access.impl.AbstractDAOImpl;
/*     */ import dtv.util.DtvDate;
/*     */ import dtv.xst.dao.ctl.DataLoaderSummaryId;
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
/*     */ public class DataLoaderSummaryDAO
/*     */   extends AbstractDAOImpl
/*     */ {
/*     */   private static final long serialVersionUID = -471652247L;
/*  23 */   private static final Logger _logger = Logger.getLogger(DataLoaderSummaryDAO.class);
/*     */   
/*     */   private Long _organizationId;
/*     */   private String _fileName;
/*     */   private Long _runTime;
/*     */   private DtvDate _createDate;
/*     */   private String _createUserId;
/*     */   private DtvDate _updateDate;
/*     */   private String _updateUserId;
/*  32 */   private Boolean _success = Boolean.FALSE;
/*     */   private Integer _successfulRows;
/*     */   private Integer _failedRows;
/*     */   
/*     */   public Long getOrganizationId() {
/*  37 */     return this._organizationId;
/*     */   }
/*     */   
/*     */   public void setOrganizationId(Long argOrganizationId) {
/*  41 */     if (changed(argOrganizationId, this._organizationId, "organizationId")) {
/*  42 */       this._organizationId = argOrganizationId;
/*     */     }
/*     */   }
/*     */   
/*     */   public String getFileName() {
/*  47 */     return this._fileName;
/*     */   }
/*     */   
/*     */   public void setFileName(String argFileName) {
/*  51 */     if (changed(argFileName, this._fileName, "fileName")) {
/*  52 */       this._fileName = (argFileName != null && MANAGE_CASE) ? argFileName.toUpperCase() : argFileName;
/*     */     }
/*     */   }
/*     */   
/*     */   public Long getRunTime() {
/*  57 */     return this._runTime;
/*     */   }
/*     */   
/*     */   public void setRunTime(Long argRunTime) {
/*  61 */     if (changed(argRunTime, this._runTime, "runTime")) {
/*  62 */       this._runTime = argRunTime;
/*     */     }
/*     */   }
/*     */   
/*     */   public Date getCreateDate() {
/*  67 */     return (Date)this._createDate;
/*     */   }
/*     */   
/*     */   public void setCreateDate(Date argCreateDate) {
/*  71 */     if (changed(argCreateDate, this._createDate, "createDate")) {
/*  72 */       this._createDate = (argCreateDate == null || argCreateDate instanceof DtvDate) ? (DtvDate)argCreateDate : new DtvDate(argCreateDate);
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public String getCreateUserId() {
/*  78 */     return this._createUserId;
/*     */   }
/*     */   
/*     */   public void setCreateUserId(String argCreateUserId) {
/*  82 */     if (changed(argCreateUserId, this._createUserId, "createUserId")) {
/*  83 */       this._createUserId = argCreateUserId;
/*     */     }
/*     */   }
/*     */   
/*     */   public Date getUpdateDate() {
/*  88 */     return (Date)this._updateDate;
/*     */   }
/*     */   
/*     */   public void setUpdateDate(Date argUpdateDate) {
/*  92 */     if (changed(argUpdateDate, this._updateDate, "updateDate")) {
/*  93 */       this._updateDate = (argUpdateDate == null || argUpdateDate instanceof DtvDate) ? (DtvDate)argUpdateDate : new DtvDate(argUpdateDate);
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public String getUpdateUserId() {
/*  99 */     return this._updateUserId;
/*     */   }
/*     */   
/*     */   public void setUpdateUserId(String argUpdateUserId) {
/* 103 */     if (changed(argUpdateUserId, this._updateUserId, "updateUserId")) {
/* 104 */       this._updateUserId = argUpdateUserId;
/*     */     }
/*     */   }
/*     */   
/*     */   public Boolean getSuccess() {
/* 109 */     return this._success;
/*     */   }
/*     */   
/*     */   public void setSuccess(Boolean argSuccess) {
/* 113 */     if (changed(argSuccess, this._success, "success")) {
/* 114 */       this._success = argSuccess;
/*     */     }
/*     */   }
/*     */   
/*     */   public Integer getSuccessfulRows() {
/* 119 */     return this._successfulRows;
/*     */   }
/*     */   
/*     */   public void setSuccessfulRows(Integer argSuccessfulRows) {
/* 123 */     if (changed(argSuccessfulRows, this._successfulRows, "successfulRows")) {
/* 124 */       this._successfulRows = argSuccessfulRows;
/*     */     }
/*     */   }
/*     */   
/*     */   public Integer getFailedRows() {
/* 129 */     return this._failedRows;
/*     */   }
/*     */   
/*     */   public void setFailedRows(Integer argFailedRows) {
/* 133 */     if (changed(argFailedRows, this._failedRows, "failedRows")) {
/* 134 */       this._failedRows = argFailedRows;
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public String toString() {
/* 141 */     StringBuilder buf = new StringBuilder(512);
/* 142 */     buf.append(super.toString()).append(" Id: ").append(getObjectId()).append(" Values: ");
/* 143 */     if (getOrganizationId() != null) {
/* 144 */       buf.append("organizationId").append("=").append(getOrganizationId()).append(" ");
/*     */     }
/* 146 */     if (getFileName() != null) {
/* 147 */       buf.append("fileName").append("=").append(getFileName()).append(" ");
/*     */     }
/* 149 */     if (getRunTime() != null) {
/* 150 */       buf.append("runTime").append("=").append(getRunTime()).append(" ");
/*     */     }
/* 152 */     if (getCreateDate() != null) {
/* 153 */       buf.append("createDate").append("=").append(getCreateDate()).append(" ");
/*     */     }
/* 155 */     if (getCreateUserId() != null) {
/* 156 */       buf.append("createUserId").append("=").append(getCreateUserId()).append(" ");
/*     */     }
/* 158 */     if (getUpdateDate() != null) {
/* 159 */       buf.append("updateDate").append("=").append(getUpdateDate()).append(" ");
/*     */     }
/* 161 */     if (getUpdateUserId() != null) {
/* 162 */       buf.append("updateUserId").append("=").append(getUpdateUserId()).append(" ");
/*     */     }
/* 164 */     if (getSuccess() != null && getSuccess().booleanValue()) {
/* 165 */       buf.append("success").append("=").append(getSuccess()).append(" ");
/*     */     }
/* 167 */     if (getSuccessfulRows() != null) {
/* 168 */       buf.append("successfulRows").append("=").append(getSuccessfulRows()).append(" ");
/*     */     }
/* 170 */     if (getFailedRows() != null) {
/* 171 */       buf.append("failedRows").append("=").append(getFailedRows()).append(" ");
/*     */     }
/*     */     
/* 174 */     return buf.toString();
/*     */   }
/*     */   
/*     */   public IObjectId getObjectId() {
/* 178 */     DataLoaderSummaryId id = new DataLoaderSummaryId();
/* 179 */     id.setOrganizationId(getOrganizationId());
/* 180 */     id.setFileName(getFileName());
/* 181 */     id.setRunTime(getRunTime());
/* 182 */     return (IObjectId)id;
/*     */   }
/*     */   
/*     */   public void setObjectId(IObjectId argObjectId) {
/* 186 */     setOrganizationId(((DataLoaderSummaryId)argObjectId).getOrganizationId());
/* 187 */     setFileName(((DataLoaderSummaryId)argObjectId).getFileName());
/* 188 */     setRunTime(((DataLoaderSummaryId)argObjectId).getRunTime());
/*     */   }
/*     */   
/*     */   public String getImplementingClass() {
/* 192 */     return null;
/*     */   }
/*     */   
/*     */   public String toXmlString() {
/* 196 */     StringBuilder buf = new StringBuilder(500);
/* 197 */     buf.append("<").append("dao").append(" name=\"DataLoaderSummary\" cmd=\"" + getObjectStateString() + "\">");
/* 198 */     getFieldsAsXml(buf);
/* 199 */     buf.append("</").append("dao").append(">");
/*     */     
/* 201 */     return buf.toString();
/*     */   }
/*     */   
/*     */   public Map<String, String> getValues() {
/* 205 */     Map<String, String> values = super.getValues();
/* 206 */     if (this._organizationId != null) values.put("OrganizationId", DaoUtils.getXmlSafeFieldValue(-5, this._organizationId)); 
/* 207 */     if (this._fileName != null) values.put("FileName", DaoUtils.getXmlSafeFieldValue(12, this._fileName)); 
/* 208 */     if (this._runTime != null) values.put("RunTime", DaoUtils.getXmlSafeFieldValue(-5, this._runTime)); 
/* 209 */     if (this._createDate != null) values.put("CreateDate", DaoUtils.getXmlSafeFieldValue(91, this._createDate)); 
/* 210 */     if (this._createUserId != null) values.put("CreateUserId", DaoUtils.getXmlSafeFieldValue(12, this._createUserId)); 
/* 211 */     if (this._updateDate != null) values.put("UpdateDate", DaoUtils.getXmlSafeFieldValue(91, this._updateDate)); 
/* 212 */     if (this._updateUserId != null) values.put("UpdateUserId", DaoUtils.getXmlSafeFieldValue(12, this._updateUserId)); 
/* 213 */     if (this._success != null) values.put("Success", DaoUtils.getXmlSafeFieldValue(-7, this._success)); 
/* 214 */     if (this._successfulRows != null) values.put("SuccessfulRows", DaoUtils.getXmlSafeFieldValue(4, this._successfulRows)); 
/* 215 */     if (this._failedRows != null) values.put("FailedRows", DaoUtils.getXmlSafeFieldValue(4, this._failedRows)); 
/* 216 */     return values;
/*     */   }
/*     */ 
/*     */   
/*     */   public void setValues(Map<String, String> argValues) {
/* 221 */     super.setValues(argValues);
/* 222 */     for (Map.Entry<String, String> field : argValues.entrySet()) {
/*     */       
/* 224 */       String fieldName = field.getKey();
/* 225 */       String fieldValue = field.getValue();
/* 226 */       switch (fieldName) {
/*     */         
/*     */         case "OrganizationId":
/*     */           try {
/* 230 */             Object value = DaoUtils.getFieldValueForXmlString(-5, fieldValue);
/* 231 */             setOrganizationId((Long)value);
/* 232 */           } catch (Exception ee) {
/* 233 */             throw new DtxException("An exception occurred while calling setOrganizationId() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "FileName":
/*     */           try {
/* 239 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 240 */             setFileName((String)value);
/* 241 */           } catch (Exception ee) {
/* 242 */             throw new DtxException("An exception occurred while calling setFileName() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "RunTime":
/*     */           try {
/* 248 */             Object value = DaoUtils.getFieldValueForXmlString(-5, fieldValue);
/* 249 */             setRunTime((Long)value);
/* 250 */           } catch (Exception ee) {
/* 251 */             throw new DtxException("An exception occurred while calling setRunTime() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "CreateDate":
/*     */           try {
/* 257 */             Object value = DaoUtils.getFieldValueForXmlString(91, fieldValue);
/* 258 */             setCreateDate((Date)value);
/* 259 */           } catch (Exception ee) {
/* 260 */             throw new DtxException("An exception occurred while calling setCreateDate() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "CreateUserId":
/*     */           try {
/* 266 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 267 */             setCreateUserId((String)value);
/* 268 */           } catch (Exception ee) {
/* 269 */             throw new DtxException("An exception occurred while calling setCreateUserId() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "UpdateDate":
/*     */           try {
/* 275 */             Object value = DaoUtils.getFieldValueForXmlString(91, fieldValue);
/* 276 */             setUpdateDate((Date)value);
/* 277 */           } catch (Exception ee) {
/* 278 */             throw new DtxException("An exception occurred while calling setUpdateDate() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "UpdateUserId":
/*     */           try {
/* 284 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 285 */             setUpdateUserId((String)value);
/* 286 */           } catch (Exception ee) {
/* 287 */             throw new DtxException("An exception occurred while calling setUpdateUserId() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "Success":
/*     */           try {
/* 293 */             Object value = DaoUtils.getFieldValueForXmlString(-7, fieldValue);
/* 294 */             setSuccess((Boolean)value);
/* 295 */           } catch (Exception ee) {
/* 296 */             throw new DtxException("An exception occurred while calling setSuccess() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "SuccessfulRows":
/*     */           try {
/* 302 */             Object value = DaoUtils.getFieldValueForXmlString(4, fieldValue);
/* 303 */             setSuccessfulRows((Integer)value);
/* 304 */           } catch (Exception ee) {
/* 305 */             throw new DtxException("An exception occurred while calling setSuccessfulRows() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "FailedRows":
/*     */           try {
/* 311 */             Object value = DaoUtils.getFieldValueForXmlString(4, fieldValue);
/* 312 */             setFailedRows((Integer)value);
/* 313 */           } catch (Exception ee) {
/* 314 */             throw new DtxException("An exception occurred while calling setFailedRows() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */       } 
/*     */     } 
/*     */   }
/*     */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\ctl\impl\DataLoaderSummaryDAO.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */