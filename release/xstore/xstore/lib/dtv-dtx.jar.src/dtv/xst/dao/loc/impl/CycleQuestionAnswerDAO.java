/*     */ package dtv.xst.dao.loc.impl;
/*     */ 
/*     */ import dtv.data2.access.DaoUtils;
/*     */ import dtv.data2.access.IObjectId;
/*     */ import dtv.data2.access.exception.DtxException;
/*     */ import dtv.data2.access.impl.AbstractDAOImpl;
/*     */ import dtv.util.DtvDate;
/*     */ import dtv.xst.dao.loc.CycleQuestionAnswerId;
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
/*     */ public class CycleQuestionAnswerDAO
/*     */   extends AbstractDAOImpl
/*     */ {
/*     */   private static final long serialVersionUID = -1404041814L;
/*  23 */   private static final Logger _logger = Logger.getLogger(CycleQuestionAnswerDAO.class);
/*     */   
/*     */   private String _answerId;
/*     */   private DtvDate _answerTimestamp;
/*     */   private Long _organizationId;
/*     */   private String _questionId;
/*     */   private DtvDate _createDate;
/*     */   private String _createUserId;
/*     */   private DtvDate _updateDate;
/*     */   private String _updateUserId;
/*     */   private Long _retailLocationId;
/*     */   
/*     */   public String getAnswerId() {
/*  36 */     return this._answerId;
/*     */   }
/*     */   
/*     */   public void setAnswerId(String argAnswerId) {
/*  40 */     if (changed(argAnswerId, this._answerId, "answerId")) {
/*  41 */       this._answerId = (argAnswerId != null && MANAGE_CASE) ? argAnswerId.toUpperCase() : argAnswerId;
/*     */     }
/*     */   }
/*     */   
/*     */   public Date getAnswerTimestamp() {
/*  46 */     return (Date)this._answerTimestamp;
/*     */   }
/*     */   
/*     */   public void setAnswerTimestamp(Date argAnswerTimestamp) {
/*  50 */     if (changed(argAnswerTimestamp, this._answerTimestamp, "answerTimestamp")) {
/*  51 */       this._answerTimestamp = (argAnswerTimestamp == null || argAnswerTimestamp instanceof DtvDate) ? (DtvDate)argAnswerTimestamp : new DtvDate(argAnswerTimestamp);
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public Long getOrganizationId() {
/*  57 */     return this._organizationId;
/*     */   }
/*     */   
/*     */   public void setOrganizationId(Long argOrganizationId) {
/*  61 */     if (changed(argOrganizationId, this._organizationId, "organizationId")) {
/*  62 */       this._organizationId = argOrganizationId;
/*     */     }
/*     */   }
/*     */   
/*     */   public String getQuestionId() {
/*  67 */     return this._questionId;
/*     */   }
/*     */   
/*     */   public void setQuestionId(String argQuestionId) {
/*  71 */     if (changed(argQuestionId, this._questionId, "questionId")) {
/*  72 */       this._questionId = (argQuestionId != null && MANAGE_CASE) ? argQuestionId.toUpperCase() : argQuestionId;
/*     */     }
/*     */   }
/*     */   
/*     */   public Date getCreateDate() {
/*  77 */     return (Date)this._createDate;
/*     */   }
/*     */   
/*     */   public void setCreateDate(Date argCreateDate) {
/*  81 */     if (changed(argCreateDate, this._createDate, "createDate")) {
/*  82 */       this._createDate = (argCreateDate == null || argCreateDate instanceof DtvDate) ? (DtvDate)argCreateDate : new DtvDate(argCreateDate);
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public String getCreateUserId() {
/*  88 */     return this._createUserId;
/*     */   }
/*     */   
/*     */   public void setCreateUserId(String argCreateUserId) {
/*  92 */     if (changed(argCreateUserId, this._createUserId, "createUserId")) {
/*  93 */       this._createUserId = argCreateUserId;
/*     */     }
/*     */   }
/*     */   
/*     */   public Date getUpdateDate() {
/*  98 */     return (Date)this._updateDate;
/*     */   }
/*     */   
/*     */   public void setUpdateDate(Date argUpdateDate) {
/* 102 */     if (changed(argUpdateDate, this._updateDate, "updateDate")) {
/* 103 */       this._updateDate = (argUpdateDate == null || argUpdateDate instanceof DtvDate) ? (DtvDate)argUpdateDate : new DtvDate(argUpdateDate);
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public String getUpdateUserId() {
/* 109 */     return this._updateUserId;
/*     */   }
/*     */   
/*     */   public void setUpdateUserId(String argUpdateUserId) {
/* 113 */     if (changed(argUpdateUserId, this._updateUserId, "updateUserId")) {
/* 114 */       this._updateUserId = argUpdateUserId;
/*     */     }
/*     */   }
/*     */   
/*     */   public Long getRetailLocationId() {
/* 119 */     return this._retailLocationId;
/*     */   }
/*     */   
/*     */   public void setRetailLocationId(Long argRetailLocationId) {
/* 123 */     if (changed(argRetailLocationId, this._retailLocationId, "retailLocationId")) {
/* 124 */       this._retailLocationId = argRetailLocationId;
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public String toString() {
/* 131 */     StringBuilder buf = new StringBuilder(512);
/* 132 */     buf.append(super.toString()).append(" Id: ").append(getObjectId()).append(" Values: ");
/* 133 */     if (getAnswerId() != null) {
/* 134 */       buf.append("answerId").append("=").append(getAnswerId()).append(" ");
/*     */     }
/* 136 */     if (getAnswerTimestamp() != null) {
/* 137 */       buf.append("answerTimestamp").append("=").append(getAnswerTimestamp()).append(" ");
/*     */     }
/* 139 */     if (getOrganizationId() != null) {
/* 140 */       buf.append("organizationId").append("=").append(getOrganizationId()).append(" ");
/*     */     }
/* 142 */     if (getQuestionId() != null) {
/* 143 */       buf.append("questionId").append("=").append(getQuestionId()).append(" ");
/*     */     }
/* 145 */     if (getCreateDate() != null) {
/* 146 */       buf.append("createDate").append("=").append(getCreateDate()).append(" ");
/*     */     }
/* 148 */     if (getCreateUserId() != null) {
/* 149 */       buf.append("createUserId").append("=").append(getCreateUserId()).append(" ");
/*     */     }
/* 151 */     if (getUpdateDate() != null) {
/* 152 */       buf.append("updateDate").append("=").append(getUpdateDate()).append(" ");
/*     */     }
/* 154 */     if (getUpdateUserId() != null) {
/* 155 */       buf.append("updateUserId").append("=").append(getUpdateUserId()).append(" ");
/*     */     }
/* 157 */     if (getRetailLocationId() != null) {
/* 158 */       buf.append("retailLocationId").append("=").append(getRetailLocationId()).append(" ");
/*     */     }
/*     */     
/* 161 */     return buf.toString();
/*     */   }
/*     */   
/*     */   public IObjectId getObjectId() {
/* 165 */     CycleQuestionAnswerId id = new CycleQuestionAnswerId();
/* 166 */     id.setAnswerId(getAnswerId());
/* 167 */     id.setAnswerTimestamp(getAnswerTimestamp());
/* 168 */     id.setOrganizationId(getOrganizationId());
/* 169 */     id.setQuestionId(getQuestionId());
/* 170 */     return (IObjectId)id;
/*     */   }
/*     */   
/*     */   public void setObjectId(IObjectId argObjectId) {
/* 174 */     setAnswerId(((CycleQuestionAnswerId)argObjectId).getAnswerId());
/* 175 */     setAnswerTimestamp(((CycleQuestionAnswerId)argObjectId).getAnswerTimestamp());
/* 176 */     setOrganizationId(((CycleQuestionAnswerId)argObjectId).getOrganizationId());
/* 177 */     setQuestionId(((CycleQuestionAnswerId)argObjectId).getQuestionId());
/*     */   }
/*     */   
/*     */   public String getImplementingClass() {
/* 181 */     return null;
/*     */   }
/*     */   
/*     */   public String toXmlString() {
/* 185 */     StringBuilder buf = new StringBuilder(450);
/* 186 */     buf.append("<").append("dao").append(" name=\"CycleQuestionAnswer\" cmd=\"" + getObjectStateString() + "\">");
/* 187 */     getFieldsAsXml(buf);
/* 188 */     buf.append("</").append("dao").append(">");
/*     */     
/* 190 */     return buf.toString();
/*     */   }
/*     */   
/*     */   public Map<String, String> getValues() {
/* 194 */     Map<String, String> values = super.getValues();
/* 195 */     if (this._answerId != null) values.put("AnswerId", DaoUtils.getXmlSafeFieldValue(12, this._answerId)); 
/* 196 */     if (this._answerTimestamp != null) values.put("AnswerTimestamp", DaoUtils.getXmlSafeFieldValue(91, this._answerTimestamp)); 
/* 197 */     if (this._organizationId != null) values.put("OrganizationId", DaoUtils.getXmlSafeFieldValue(-5, this._organizationId)); 
/* 198 */     if (this._questionId != null) values.put("QuestionId", DaoUtils.getXmlSafeFieldValue(12, this._questionId)); 
/* 199 */     if (this._createDate != null) values.put("CreateDate", DaoUtils.getXmlSafeFieldValue(91, this._createDate)); 
/* 200 */     if (this._createUserId != null) values.put("CreateUserId", DaoUtils.getXmlSafeFieldValue(12, this._createUserId)); 
/* 201 */     if (this._updateDate != null) values.put("UpdateDate", DaoUtils.getXmlSafeFieldValue(91, this._updateDate)); 
/* 202 */     if (this._updateUserId != null) values.put("UpdateUserId", DaoUtils.getXmlSafeFieldValue(12, this._updateUserId)); 
/* 203 */     if (this._retailLocationId != null) values.put("RetailLocationId", DaoUtils.getXmlSafeFieldValue(-5, this._retailLocationId)); 
/* 204 */     return values;
/*     */   }
/*     */ 
/*     */   
/*     */   public void setValues(Map<String, String> argValues) {
/* 209 */     super.setValues(argValues);
/* 210 */     for (Map.Entry<String, String> field : argValues.entrySet()) {
/*     */       
/* 212 */       String fieldName = field.getKey();
/* 213 */       String fieldValue = field.getValue();
/* 214 */       switch (fieldName) {
/*     */         
/*     */         case "AnswerId":
/*     */           try {
/* 218 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 219 */             setAnswerId((String)value);
/* 220 */           } catch (Exception ee) {
/* 221 */             throw new DtxException("An exception occurred while calling setAnswerId() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "AnswerTimestamp":
/*     */           try {
/* 227 */             Object value = DaoUtils.getFieldValueForXmlString(91, fieldValue);
/* 228 */             setAnswerTimestamp((Date)value);
/* 229 */           } catch (Exception ee) {
/* 230 */             throw new DtxException("An exception occurred while calling setAnswerTimestamp() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "OrganizationId":
/*     */           try {
/* 236 */             Object value = DaoUtils.getFieldValueForXmlString(-5, fieldValue);
/* 237 */             setOrganizationId((Long)value);
/* 238 */           } catch (Exception ee) {
/* 239 */             throw new DtxException("An exception occurred while calling setOrganizationId() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "QuestionId":
/*     */           try {
/* 245 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 246 */             setQuestionId((String)value);
/* 247 */           } catch (Exception ee) {
/* 248 */             throw new DtxException("An exception occurred while calling setQuestionId() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "CreateDate":
/*     */           try {
/* 254 */             Object value = DaoUtils.getFieldValueForXmlString(91, fieldValue);
/* 255 */             setCreateDate((Date)value);
/* 256 */           } catch (Exception ee) {
/* 257 */             throw new DtxException("An exception occurred while calling setCreateDate() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "CreateUserId":
/*     */           try {
/* 263 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 264 */             setCreateUserId((String)value);
/* 265 */           } catch (Exception ee) {
/* 266 */             throw new DtxException("An exception occurred while calling setCreateUserId() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "UpdateDate":
/*     */           try {
/* 272 */             Object value = DaoUtils.getFieldValueForXmlString(91, fieldValue);
/* 273 */             setUpdateDate((Date)value);
/* 274 */           } catch (Exception ee) {
/* 275 */             throw new DtxException("An exception occurred while calling setUpdateDate() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "UpdateUserId":
/*     */           try {
/* 281 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 282 */             setUpdateUserId((String)value);
/* 283 */           } catch (Exception ee) {
/* 284 */             throw new DtxException("An exception occurred while calling setUpdateUserId() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "RetailLocationId":
/*     */           try {
/* 290 */             Object value = DaoUtils.getFieldValueForXmlString(-5, fieldValue);
/* 291 */             setRetailLocationId((Long)value);
/* 292 */           } catch (Exception ee) {
/* 293 */             throw new DtxException("An exception occurred while calling setRetailLocationId() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */       } 
/*     */     } 
/*     */   }
/*     */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\loc\impl\CycleQuestionAnswerDAO.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */