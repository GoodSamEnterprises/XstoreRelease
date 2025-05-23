/*     */ package dtv.xst.dao.prc.impl;
/*     */ 
/*     */ import dtv.data2.access.DaoUtils;
/*     */ import dtv.data2.access.IObjectId;
/*     */ import dtv.data2.access.exception.DtxException;
/*     */ import dtv.data2.access.impl.AbstractDAOImpl;
/*     */ import dtv.util.DtvDate;
/*     */ import dtv.xst.dao.prc.DealWeekId;
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
/*     */ public class DealWeekDAO
/*     */   extends AbstractDAOImpl
/*     */ {
/*     */   private static final long serialVersionUID = 575037088L;
/*  23 */   private static final Logger _logger = Logger.getLogger(DealWeekDAO.class);
/*     */   
/*     */   private Long _organizationId;
/*     */   private String _dealId;
/*     */   private String _dayCode;
/*     */   private DtvDate _startTime;
/*     */   private String _orgCode;
/*     */   private String _orgValue;
/*     */   private DtvDate _createDate;
/*     */   private String _createUserId;
/*     */   private DtvDate _updateDate;
/*     */   private String _updateUserId;
/*     */   private DtvDate _endTime;
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
/*     */   public String getDealId() {
/*  48 */     return this._dealId;
/*     */   }
/*     */   
/*     */   public void setDealId(String argDealId) {
/*  52 */     if (changed(argDealId, this._dealId, "dealId")) {
/*  53 */       this._dealId = (argDealId != null && MANAGE_CASE) ? argDealId.toUpperCase() : argDealId;
/*     */     }
/*     */   }
/*     */   
/*     */   public String getDayCode() {
/*  58 */     return this._dayCode;
/*     */   }
/*     */   
/*     */   public void setDayCode(String argDayCode) {
/*  62 */     if (changed(argDayCode, this._dayCode, "dayCode")) {
/*  63 */       this._dayCode = (argDayCode != null && MANAGE_CASE) ? argDayCode.toUpperCase() : argDayCode;
/*     */     }
/*     */   }
/*     */   
/*     */   public Date getStartTime() {
/*  68 */     return (Date)this._startTime;
/*     */   }
/*     */   
/*     */   public void setStartTime(Date argStartTime) {
/*  72 */     if (changed(argStartTime, this._startTime, "startTime")) {
/*  73 */       this._startTime = (argStartTime == null || argStartTime instanceof DtvDate) ? (DtvDate)argStartTime : new DtvDate(argStartTime);
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public String getOrgCode() {
/*  79 */     return this._orgCode;
/*     */   }
/*     */   
/*     */   public void setOrgCode(String argOrgCode) {
/*  83 */     if (changed(argOrgCode, this._orgCode, "orgCode")) {
/*  84 */       this._orgCode = argOrgCode;
/*     */     }
/*     */   }
/*     */   
/*     */   public String getOrgValue() {
/*  89 */     return this._orgValue;
/*     */   }
/*     */   
/*     */   public void setOrgValue(String argOrgValue) {
/*  93 */     if (changed(argOrgValue, this._orgValue, "orgValue")) {
/*  94 */       this._orgValue = argOrgValue;
/*     */     }
/*     */   }
/*     */   
/*     */   public Date getCreateDate() {
/*  99 */     return (Date)this._createDate;
/*     */   }
/*     */   
/*     */   public void setCreateDate(Date argCreateDate) {
/* 103 */     if (changed(argCreateDate, this._createDate, "createDate")) {
/* 104 */       this._createDate = (argCreateDate == null || argCreateDate instanceof DtvDate) ? (DtvDate)argCreateDate : new DtvDate(argCreateDate);
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public String getCreateUserId() {
/* 110 */     return this._createUserId;
/*     */   }
/*     */   
/*     */   public void setCreateUserId(String argCreateUserId) {
/* 114 */     if (changed(argCreateUserId, this._createUserId, "createUserId")) {
/* 115 */       this._createUserId = argCreateUserId;
/*     */     }
/*     */   }
/*     */   
/*     */   public Date getUpdateDate() {
/* 120 */     return (Date)this._updateDate;
/*     */   }
/*     */   
/*     */   public void setUpdateDate(Date argUpdateDate) {
/* 124 */     if (changed(argUpdateDate, this._updateDate, "updateDate")) {
/* 125 */       this._updateDate = (argUpdateDate == null || argUpdateDate instanceof DtvDate) ? (DtvDate)argUpdateDate : new DtvDate(argUpdateDate);
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public String getUpdateUserId() {
/* 131 */     return this._updateUserId;
/*     */   }
/*     */   
/*     */   public void setUpdateUserId(String argUpdateUserId) {
/* 135 */     if (changed(argUpdateUserId, this._updateUserId, "updateUserId")) {
/* 136 */       this._updateUserId = argUpdateUserId;
/*     */     }
/*     */   }
/*     */   
/*     */   public Date getEndTime() {
/* 141 */     return (Date)this._endTime;
/*     */   }
/*     */   
/*     */   public void setEndTime(Date argEndTime) {
/* 145 */     if (changed(argEndTime, this._endTime, "endTime")) {
/* 146 */       this._endTime = (argEndTime == null || argEndTime instanceof DtvDate) ? (DtvDate)argEndTime : new DtvDate(argEndTime);
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
/* 159 */     if (getDealId() != null) {
/* 160 */       buf.append("dealId").append("=").append(getDealId()).append(" ");
/*     */     }
/* 162 */     if (getDayCode() != null) {
/* 163 */       buf.append("dayCode").append("=").append(getDayCode()).append(" ");
/*     */     }
/* 165 */     if (getStartTime() != null) {
/* 166 */       buf.append("startTime").append("=").append(getStartTime()).append(" ");
/*     */     }
/* 168 */     if (getOrgCode() != null) {
/* 169 */       buf.append("orgCode").append("=").append(getOrgCode()).append(" ");
/*     */     }
/* 171 */     if (getOrgValue() != null) {
/* 172 */       buf.append("orgValue").append("=").append(getOrgValue()).append(" ");
/*     */     }
/* 174 */     if (getCreateDate() != null) {
/* 175 */       buf.append("createDate").append("=").append(getCreateDate()).append(" ");
/*     */     }
/* 177 */     if (getCreateUserId() != null) {
/* 178 */       buf.append("createUserId").append("=").append(getCreateUserId()).append(" ");
/*     */     }
/* 180 */     if (getUpdateDate() != null) {
/* 181 */       buf.append("updateDate").append("=").append(getUpdateDate()).append(" ");
/*     */     }
/* 183 */     if (getUpdateUserId() != null) {
/* 184 */       buf.append("updateUserId").append("=").append(getUpdateUserId()).append(" ");
/*     */     }
/* 186 */     if (getEndTime() != null) {
/* 187 */       buf.append("endTime").append("=").append(getEndTime()).append(" ");
/*     */     }
/*     */     
/* 190 */     return buf.toString();
/*     */   }
/*     */   
/*     */   public IObjectId getObjectId() {
/* 194 */     DealWeekId id = new DealWeekId();
/* 195 */     id.setOrganizationId(getOrganizationId());
/* 196 */     id.setDealId(getDealId());
/* 197 */     id.setDayCode(getDayCode());
/* 198 */     id.setStartTime(getStartTime());
/* 199 */     return (IObjectId)id;
/*     */   }
/*     */   
/*     */   public void setObjectId(IObjectId argObjectId) {
/* 203 */     setOrganizationId(((DealWeekId)argObjectId).getOrganizationId());
/* 204 */     setDealId(((DealWeekId)argObjectId).getDealId());
/* 205 */     setDayCode(((DealWeekId)argObjectId).getDayCode());
/* 206 */     setStartTime(((DealWeekId)argObjectId).getStartTime());
/*     */   }
/*     */   
/*     */   public String getImplementingClass() {
/* 210 */     return null;
/*     */   }
/*     */   
/*     */   public String toXmlString() {
/* 214 */     StringBuilder buf = new StringBuilder(550);
/* 215 */     buf.append("<").append("dao").append(" name=\"DealWeek\" cmd=\"" + getObjectStateString() + "\">");
/* 216 */     getFieldsAsXml(buf);
/* 217 */     buf.append("</").append("dao").append(">");
/*     */     
/* 219 */     return buf.toString();
/*     */   }
/*     */   
/*     */   public Map<String, String> getValues() {
/* 223 */     Map<String, String> values = super.getValues();
/* 224 */     if (this._organizationId != null) values.put("OrganizationId", DaoUtils.getXmlSafeFieldValue(-5, this._organizationId)); 
/* 225 */     if (this._dealId != null) values.put("DealId", DaoUtils.getXmlSafeFieldValue(12, this._dealId)); 
/* 226 */     if (this._dayCode != null) values.put("DayCode", DaoUtils.getXmlSafeFieldValue(12, this._dayCode)); 
/* 227 */     if (this._startTime != null) values.put("StartTime", DaoUtils.getXmlSafeFieldValue(91, this._startTime)); 
/* 228 */     if (this._orgCode != null) values.put("OrgCode", DaoUtils.getXmlSafeFieldValue(12, this._orgCode)); 
/* 229 */     if (this._orgValue != null) values.put("OrgValue", DaoUtils.getXmlSafeFieldValue(12, this._orgValue)); 
/* 230 */     if (this._createDate != null) values.put("CreateDate", DaoUtils.getXmlSafeFieldValue(91, this._createDate)); 
/* 231 */     if (this._createUserId != null) values.put("CreateUserId", DaoUtils.getXmlSafeFieldValue(12, this._createUserId)); 
/* 232 */     if (this._updateDate != null) values.put("UpdateDate", DaoUtils.getXmlSafeFieldValue(91, this._updateDate)); 
/* 233 */     if (this._updateUserId != null) values.put("UpdateUserId", DaoUtils.getXmlSafeFieldValue(12, this._updateUserId)); 
/* 234 */     if (this._endTime != null) values.put("EndTime", DaoUtils.getXmlSafeFieldValue(91, this._endTime)); 
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
/*     */         case "DealId":
/*     */           try {
/* 258 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 259 */             setDealId((String)value);
/* 260 */           } catch (Exception ee) {
/* 261 */             throw new DtxException("An exception occurred while calling setDealId() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "DayCode":
/*     */           try {
/* 267 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 268 */             setDayCode((String)value);
/* 269 */           } catch (Exception ee) {
/* 270 */             throw new DtxException("An exception occurred while calling setDayCode() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "StartTime":
/*     */           try {
/* 276 */             Object value = DaoUtils.getFieldValueForXmlString(91, fieldValue);
/* 277 */             setStartTime((Date)value);
/* 278 */           } catch (Exception ee) {
/* 279 */             throw new DtxException("An exception occurred while calling setStartTime() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "OrgCode":
/*     */           try {
/* 285 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 286 */             setOrgCode((String)value);
/* 287 */           } catch (Exception ee) {
/* 288 */             throw new DtxException("An exception occurred while calling setOrgCode() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "OrgValue":
/*     */           try {
/* 294 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 295 */             setOrgValue((String)value);
/* 296 */           } catch (Exception ee) {
/* 297 */             throw new DtxException("An exception occurred while calling setOrgValue() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "CreateDate":
/*     */           try {
/* 303 */             Object value = DaoUtils.getFieldValueForXmlString(91, fieldValue);
/* 304 */             setCreateDate((Date)value);
/* 305 */           } catch (Exception ee) {
/* 306 */             throw new DtxException("An exception occurred while calling setCreateDate() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "CreateUserId":
/*     */           try {
/* 312 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 313 */             setCreateUserId((String)value);
/* 314 */           } catch (Exception ee) {
/* 315 */             throw new DtxException("An exception occurred while calling setCreateUserId() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "UpdateDate":
/*     */           try {
/* 321 */             Object value = DaoUtils.getFieldValueForXmlString(91, fieldValue);
/* 322 */             setUpdateDate((Date)value);
/* 323 */           } catch (Exception ee) {
/* 324 */             throw new DtxException("An exception occurred while calling setUpdateDate() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "UpdateUserId":
/*     */           try {
/* 330 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 331 */             setUpdateUserId((String)value);
/* 332 */           } catch (Exception ee) {
/* 333 */             throw new DtxException("An exception occurred while calling setUpdateUserId() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "EndTime":
/*     */           try {
/* 339 */             Object value = DaoUtils.getFieldValueForXmlString(91, fieldValue);
/* 340 */             setEndTime((Date)value);
/* 341 */           } catch (Exception ee) {
/* 342 */             throw new DtxException("An exception occurred while calling setEndTime() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */       } 
/*     */     } 
/*     */   }
/*     */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\prc\impl\DealWeekDAO.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */