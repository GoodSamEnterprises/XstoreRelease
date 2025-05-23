/*     */ package dtv.xst.dao.loc.impl;
/*     */ 
/*     */ import dtv.data2.access.DaoUtils;
/*     */ import dtv.data2.access.IObjectId;
/*     */ import dtv.data2.access.exception.DtxException;
/*     */ import dtv.data2.access.impl.AbstractDAOImpl;
/*     */ import dtv.util.DtvDate;
/*     */ import dtv.xst.dao.loc.CycleQuestionChoiceId;
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
/*     */ public class CycleQuestionChoiceDAO
/*     */   extends AbstractDAOImpl
/*     */ {
/*     */   private static final long serialVersionUID = -1352457331L;
/*  23 */   private static final Logger _logger = Logger.getLogger(CycleQuestionChoiceDAO.class);
/*     */   
/*     */   private String _answerId;
/*     */   private Long _organizationId;
/*     */   private String _questionId;
/*     */   private DtvDate _createDate;
/*     */   private String _createUserId;
/*     */   private DtvDate _updateDate;
/*     */   private String _updateUserId;
/*     */   private String _answerTextKey;
/*     */   private Integer _sortOrder;
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
/*     */   public String getQuestionId() {
/*  56 */     return this._questionId;
/*     */   }
/*     */   
/*     */   public void setQuestionId(String argQuestionId) {
/*  60 */     if (changed(argQuestionId, this._questionId, "questionId")) {
/*  61 */       this._questionId = (argQuestionId != null && MANAGE_CASE) ? argQuestionId.toUpperCase() : argQuestionId;
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
/*     */   public String getAnswerTextKey() {
/* 108 */     return this._answerTextKey;
/*     */   }
/*     */   
/*     */   public void setAnswerTextKey(String argAnswerTextKey) {
/* 112 */     if (changed(argAnswerTextKey, this._answerTextKey, "answerTextKey")) {
/* 113 */       this._answerTextKey = argAnswerTextKey;
/*     */     }
/*     */   }
/*     */   
/*     */   public Integer getSortOrder() {
/* 118 */     return this._sortOrder;
/*     */   }
/*     */   
/*     */   public void setSortOrder(Integer argSortOrder) {
/* 122 */     if (changed(argSortOrder, this._sortOrder, "sortOrder")) {
/* 123 */       this._sortOrder = argSortOrder;
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public String toString() {
/* 130 */     StringBuilder buf = new StringBuilder(512);
/* 131 */     buf.append(super.toString()).append(" Id: ").append(getObjectId()).append(" Values: ");
/* 132 */     if (getAnswerId() != null) {
/* 133 */       buf.append("answerId").append("=").append(getAnswerId()).append(" ");
/*     */     }
/* 135 */     if (getOrganizationId() != null) {
/* 136 */       buf.append("organizationId").append("=").append(getOrganizationId()).append(" ");
/*     */     }
/* 138 */     if (getQuestionId() != null) {
/* 139 */       buf.append("questionId").append("=").append(getQuestionId()).append(" ");
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
/* 153 */     if (getAnswerTextKey() != null) {
/* 154 */       buf.append("answerTextKey").append("=").append(getAnswerTextKey()).append(" ");
/*     */     }
/* 156 */     if (getSortOrder() != null) {
/* 157 */       buf.append("sortOrder").append("=").append(getSortOrder()).append(" ");
/*     */     }
/*     */     
/* 160 */     return buf.toString();
/*     */   }
/*     */   
/*     */   public IObjectId getObjectId() {
/* 164 */     CycleQuestionChoiceId id = new CycleQuestionChoiceId();
/* 165 */     id.setAnswerId(getAnswerId());
/* 166 */     id.setOrganizationId(getOrganizationId());
/* 167 */     id.setQuestionId(getQuestionId());
/* 168 */     return (IObjectId)id;
/*     */   }
/*     */   
/*     */   public void setObjectId(IObjectId argObjectId) {
/* 172 */     setAnswerId(((CycleQuestionChoiceId)argObjectId).getAnswerId());
/* 173 */     setOrganizationId(((CycleQuestionChoiceId)argObjectId).getOrganizationId());
/* 174 */     setQuestionId(((CycleQuestionChoiceId)argObjectId).getQuestionId());
/*     */   }
/*     */   
/*     */   public String getImplementingClass() {
/* 178 */     return null;
/*     */   }
/*     */   
/*     */   public String toXmlString() {
/* 182 */     StringBuilder buf = new StringBuilder(450);
/* 183 */     buf.append("<").append("dao").append(" name=\"CycleQuestionChoice\" cmd=\"" + getObjectStateString() + "\">");
/* 184 */     getFieldsAsXml(buf);
/* 185 */     buf.append("</").append("dao").append(">");
/*     */     
/* 187 */     return buf.toString();
/*     */   }
/*     */   
/*     */   public Map<String, String> getValues() {
/* 191 */     Map<String, String> values = super.getValues();
/* 192 */     if (this._answerId != null) values.put("AnswerId", DaoUtils.getXmlSafeFieldValue(12, this._answerId)); 
/* 193 */     if (this._organizationId != null) values.put("OrganizationId", DaoUtils.getXmlSafeFieldValue(-5, this._organizationId)); 
/* 194 */     if (this._questionId != null) values.put("QuestionId", DaoUtils.getXmlSafeFieldValue(12, this._questionId)); 
/* 195 */     if (this._createDate != null) values.put("CreateDate", DaoUtils.getXmlSafeFieldValue(91, this._createDate)); 
/* 196 */     if (this._createUserId != null) values.put("CreateUserId", DaoUtils.getXmlSafeFieldValue(12, this._createUserId)); 
/* 197 */     if (this._updateDate != null) values.put("UpdateDate", DaoUtils.getXmlSafeFieldValue(91, this._updateDate)); 
/* 198 */     if (this._updateUserId != null) values.put("UpdateUserId", DaoUtils.getXmlSafeFieldValue(12, this._updateUserId)); 
/* 199 */     if (this._answerTextKey != null) values.put("AnswerTextKey", DaoUtils.getXmlSafeFieldValue(12, this._answerTextKey)); 
/* 200 */     if (this._sortOrder != null) values.put("SortOrder", DaoUtils.getXmlSafeFieldValue(4, this._sortOrder)); 
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
/*     */         case "AnswerId":
/*     */           try {
/* 215 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 216 */             setAnswerId((String)value);
/* 217 */           } catch (Exception ee) {
/* 218 */             throw new DtxException("An exception occurred while calling setAnswerId() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
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
/*     */         case "QuestionId":
/*     */           try {
/* 233 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 234 */             setQuestionId((String)value);
/* 235 */           } catch (Exception ee) {
/* 236 */             throw new DtxException("An exception occurred while calling setQuestionId() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
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
/*     */         case "AnswerTextKey":
/*     */           try {
/* 278 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 279 */             setAnswerTextKey((String)value);
/* 280 */           } catch (Exception ee) {
/* 281 */             throw new DtxException("An exception occurred while calling setAnswerTextKey() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "SortOrder":
/*     */           try {
/* 287 */             Object value = DaoUtils.getFieldValueForXmlString(4, fieldValue);
/* 288 */             setSortOrder((Integer)value);
/* 289 */           } catch (Exception ee) {
/* 290 */             throw new DtxException("An exception occurred while calling setSortOrder() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */       } 
/*     */     } 
/*     */   }
/*     */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\loc\impl\CycleQuestionChoiceDAO.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */