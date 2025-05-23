/*     */ package dtv.xst.dao.hrs.impl;
/*     */ 
/*     */ import dtv.data2.access.DaoUtils;
/*     */ import dtv.data2.access.IObjectId;
/*     */ import dtv.data2.access.exception.DtxException;
/*     */ import dtv.data2.access.impl.AbstractDAOImpl;
/*     */ import dtv.util.DtvDate;
/*     */ import dtv.xst.dao.hrs.EmployeeAnswersId;
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
/*     */ public class EmployeeAnswersDAO
/*     */   extends AbstractDAOImpl
/*     */ {
/*     */   private static final long serialVersionUID = -1388060217L;
/*  23 */   private static final Logger _logger = Logger.getLogger(EmployeeAnswersDAO.class);
/*     */   
/*     */   private Long _organizationId;
/*     */   private String _employeeId;
/*     */   private String _challengeCode;
/*     */   private DtvDate _createDate;
/*     */   private String _createUserId;
/*     */   private DtvDate _updateDate;
/*     */   private String _updateUserId;
/*     */   private String _challengeAnswer;
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
/*     */   public String getEmployeeId() {
/*  45 */     return this._employeeId;
/*     */   }
/*     */   
/*     */   public void setEmployeeId(String argEmployeeId) {
/*  49 */     if (changed(argEmployeeId, this._employeeId, "employeeId")) {
/*  50 */       this._employeeId = (argEmployeeId != null && MANAGE_CASE) ? argEmployeeId.toUpperCase() : argEmployeeId;
/*     */     }
/*     */   }
/*     */   
/*     */   public String getChallengeCode() {
/*  55 */     return this._challengeCode;
/*     */   }
/*     */   
/*     */   public void setChallengeCode(String argChallengeCode) {
/*  59 */     if (changed(argChallengeCode, this._challengeCode, "challengeCode")) {
/*  60 */       this._challengeCode = (argChallengeCode != null && MANAGE_CASE) ? argChallengeCode.toUpperCase() : argChallengeCode;
/*     */     }
/*     */   }
/*     */   
/*     */   public Date getCreateDate() {
/*  65 */     return (Date)this._createDate;
/*     */   }
/*     */   
/*     */   public void setCreateDate(Date argCreateDate) {
/*  69 */     if (changed(argCreateDate, this._createDate, "createDate")) {
/*  70 */       this._createDate = (argCreateDate == null || argCreateDate instanceof DtvDate) ? (DtvDate)argCreateDate : new DtvDate(argCreateDate);
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public String getCreateUserId() {
/*  76 */     return this._createUserId;
/*     */   }
/*     */   
/*     */   public void setCreateUserId(String argCreateUserId) {
/*  80 */     if (changed(argCreateUserId, this._createUserId, "createUserId")) {
/*  81 */       this._createUserId = argCreateUserId;
/*     */     }
/*     */   }
/*     */   
/*     */   public Date getUpdateDate() {
/*  86 */     return (Date)this._updateDate;
/*     */   }
/*     */   
/*     */   public void setUpdateDate(Date argUpdateDate) {
/*  90 */     if (changed(argUpdateDate, this._updateDate, "updateDate")) {
/*  91 */       this._updateDate = (argUpdateDate == null || argUpdateDate instanceof DtvDate) ? (DtvDate)argUpdateDate : new DtvDate(argUpdateDate);
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public String getUpdateUserId() {
/*  97 */     return this._updateUserId;
/*     */   }
/*     */   
/*     */   public void setUpdateUserId(String argUpdateUserId) {
/* 101 */     if (changed(argUpdateUserId, this._updateUserId, "updateUserId")) {
/* 102 */       this._updateUserId = argUpdateUserId;
/*     */     }
/*     */   }
/*     */   
/*     */   public String getChallengeAnswer() {
/* 107 */     return this._challengeAnswer;
/*     */   }
/*     */   
/*     */   public void setChallengeAnswer(String argChallengeAnswer) {
/* 111 */     if (changed(argChallengeAnswer, this._challengeAnswer, "challengeAnswer")) {
/* 112 */       this._challengeAnswer = argChallengeAnswer;
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
/* 124 */     if (getEmployeeId() != null) {
/* 125 */       buf.append("employeeId").append("=").append(getEmployeeId()).append(" ");
/*     */     }
/* 127 */     if (getChallengeCode() != null) {
/* 128 */       buf.append("challengeCode").append("=").append(getChallengeCode()).append(" ");
/*     */     }
/* 130 */     if (getCreateDate() != null) {
/* 131 */       buf.append("createDate").append("=").append(getCreateDate()).append(" ");
/*     */     }
/* 133 */     if (getCreateUserId() != null) {
/* 134 */       buf.append("createUserId").append("=").append(getCreateUserId()).append(" ");
/*     */     }
/* 136 */     if (getUpdateDate() != null) {
/* 137 */       buf.append("updateDate").append("=").append(getUpdateDate()).append(" ");
/*     */     }
/* 139 */     if (getUpdateUserId() != null) {
/* 140 */       buf.append("updateUserId").append("=").append(getUpdateUserId()).append(" ");
/*     */     }
/* 142 */     if (getChallengeAnswer() != null) {
/* 143 */       buf.append("challengeAnswer").append("=").append(getChallengeAnswer()).append(" ");
/*     */     }
/*     */     
/* 146 */     return buf.toString();
/*     */   }
/*     */   
/*     */   public IObjectId getObjectId() {
/* 150 */     EmployeeAnswersId id = new EmployeeAnswersId();
/* 151 */     id.setOrganizationId(getOrganizationId());
/* 152 */     id.setEmployeeId(getEmployeeId());
/* 153 */     id.setChallengeCode(getChallengeCode());
/* 154 */     return (IObjectId)id;
/*     */   }
/*     */   
/*     */   public void setObjectId(IObjectId argObjectId) {
/* 158 */     setOrganizationId(((EmployeeAnswersId)argObjectId).getOrganizationId());
/* 159 */     setEmployeeId(((EmployeeAnswersId)argObjectId).getEmployeeId());
/* 160 */     setChallengeCode(((EmployeeAnswersId)argObjectId).getChallengeCode());
/*     */   }
/*     */   
/*     */   public String getImplementingClass() {
/* 164 */     return null;
/*     */   }
/*     */   
/*     */   public String toXmlString() {
/* 168 */     StringBuilder buf = new StringBuilder(400);
/* 169 */     buf.append("<").append("dao").append(" name=\"EmployeeAnswers\" cmd=\"" + getObjectStateString() + "\">");
/* 170 */     getFieldsAsXml(buf);
/* 171 */     buf.append("</").append("dao").append(">");
/*     */     
/* 173 */     return buf.toString();
/*     */   }
/*     */   
/*     */   public Map<String, String> getValues() {
/* 177 */     Map<String, String> values = super.getValues();
/* 178 */     if (this._organizationId != null) values.put("OrganizationId", DaoUtils.getXmlSafeFieldValue(-5, this._organizationId)); 
/* 179 */     if (this._employeeId != null) values.put("EmployeeId", DaoUtils.getXmlSafeFieldValue(12, this._employeeId)); 
/* 180 */     if (this._challengeCode != null) values.put("ChallengeCode", DaoUtils.getXmlSafeFieldValue(12, this._challengeCode)); 
/* 181 */     if (this._createDate != null) values.put("CreateDate", DaoUtils.getXmlSafeFieldValue(91, this._createDate)); 
/* 182 */     if (this._createUserId != null) values.put("CreateUserId", DaoUtils.getXmlSafeFieldValue(12, this._createUserId)); 
/* 183 */     if (this._updateDate != null) values.put("UpdateDate", DaoUtils.getXmlSafeFieldValue(91, this._updateDate)); 
/* 184 */     if (this._updateUserId != null) values.put("UpdateUserId", DaoUtils.getXmlSafeFieldValue(12, this._updateUserId)); 
/* 185 */     if (this._challengeAnswer != null) values.put("ChallengeAnswer", DaoUtils.getXmlSafeFieldValue(12, this._challengeAnswer)); 
/* 186 */     return values;
/*     */   }
/*     */ 
/*     */   
/*     */   public void setValues(Map<String, String> argValues) {
/* 191 */     super.setValues(argValues);
/* 192 */     for (Map.Entry<String, String> field : argValues.entrySet()) {
/*     */       
/* 194 */       String fieldName = field.getKey();
/* 195 */       String fieldValue = field.getValue();
/* 196 */       switch (fieldName) {
/*     */         
/*     */         case "OrganizationId":
/*     */           try {
/* 200 */             Object value = DaoUtils.getFieldValueForXmlString(-5, fieldValue);
/* 201 */             setOrganizationId((Long)value);
/* 202 */           } catch (Exception ee) {
/* 203 */             throw new DtxException("An exception occurred while calling setOrganizationId() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "EmployeeId":
/*     */           try {
/* 209 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 210 */             setEmployeeId((String)value);
/* 211 */           } catch (Exception ee) {
/* 212 */             throw new DtxException("An exception occurred while calling setEmployeeId() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "ChallengeCode":
/*     */           try {
/* 218 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 219 */             setChallengeCode((String)value);
/* 220 */           } catch (Exception ee) {
/* 221 */             throw new DtxException("An exception occurred while calling setChallengeCode() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "CreateDate":
/*     */           try {
/* 227 */             Object value = DaoUtils.getFieldValueForXmlString(91, fieldValue);
/* 228 */             setCreateDate((Date)value);
/* 229 */           } catch (Exception ee) {
/* 230 */             throw new DtxException("An exception occurred while calling setCreateDate() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "CreateUserId":
/*     */           try {
/* 236 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 237 */             setCreateUserId((String)value);
/* 238 */           } catch (Exception ee) {
/* 239 */             throw new DtxException("An exception occurred while calling setCreateUserId() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "UpdateDate":
/*     */           try {
/* 245 */             Object value = DaoUtils.getFieldValueForXmlString(91, fieldValue);
/* 246 */             setUpdateDate((Date)value);
/* 247 */           } catch (Exception ee) {
/* 248 */             throw new DtxException("An exception occurred while calling setUpdateDate() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "UpdateUserId":
/*     */           try {
/* 254 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 255 */             setUpdateUserId((String)value);
/* 256 */           } catch (Exception ee) {
/* 257 */             throw new DtxException("An exception occurred while calling setUpdateUserId() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "ChallengeAnswer":
/*     */           try {
/* 263 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 264 */             setChallengeAnswer((String)value);
/* 265 */           } catch (Exception ee) {
/* 266 */             throw new DtxException("An exception occurred while calling setChallengeAnswer() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */       } 
/*     */     } 
/*     */   }
/*     */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\hrs\impl\EmployeeAnswersDAO.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */