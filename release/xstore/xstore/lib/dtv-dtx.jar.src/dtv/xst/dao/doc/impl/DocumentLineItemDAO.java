/*     */ package dtv.xst.dao.doc.impl;
/*     */ 
/*     */ import dtv.data2.access.DaoUtils;
/*     */ import dtv.data2.access.exception.DtxException;
/*     */ import dtv.util.DtvDate;
/*     */ import dtv.xst.dao.trl.impl.RetailTransactionLineItemDAO;
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
/*     */ 
/*     */ 
/*     */ public class DocumentLineItemDAO
/*     */   extends RetailTransactionLineItemDAO
/*     */ {
/*     */   private static final long serialVersionUID = -1314475134L;
/*  23 */   private static final Logger _logger = Logger.getLogger(DocumentLineItemDAO.class);
/*     */   
/*     */   private DtvDate _createDate;
/*     */   private String _createUserId;
/*     */   private DtvDate _updateDate;
/*     */   private String _updateUserId;
/*     */   private String _seriesId;
/*     */   private String _documentId;
/*     */   private String _documentType;
/*     */   private String _activityCode;
/*     */   
/*     */   public Date getCreateDate() {
/*  35 */     return (Date)this._createDate;
/*     */   }
/*     */   
/*     */   public void setCreateDate(Date argCreateDate) {
/*  39 */     if (changed(argCreateDate, this._createDate, "createDate")) {
/*  40 */       this._createDate = (argCreateDate == null || argCreateDate instanceof DtvDate) ? (DtvDate)argCreateDate : new DtvDate(argCreateDate);
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public String getCreateUserId() {
/*  46 */     return this._createUserId;
/*     */   }
/*     */   
/*     */   public void setCreateUserId(String argCreateUserId) {
/*  50 */     if (changed(argCreateUserId, this._createUserId, "createUserId")) {
/*  51 */       this._createUserId = argCreateUserId;
/*     */     }
/*     */   }
/*     */   
/*     */   public Date getUpdateDate() {
/*  56 */     return (Date)this._updateDate;
/*     */   }
/*     */   
/*     */   public void setUpdateDate(Date argUpdateDate) {
/*  60 */     if (changed(argUpdateDate, this._updateDate, "updateDate")) {
/*  61 */       this._updateDate = (argUpdateDate == null || argUpdateDate instanceof DtvDate) ? (DtvDate)argUpdateDate : new DtvDate(argUpdateDate);
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public String getUpdateUserId() {
/*  67 */     return this._updateUserId;
/*     */   }
/*     */   
/*     */   public void setUpdateUserId(String argUpdateUserId) {
/*  71 */     if (changed(argUpdateUserId, this._updateUserId, "updateUserId")) {
/*  72 */       this._updateUserId = argUpdateUserId;
/*     */     }
/*     */   }
/*     */   
/*     */   public String getSeriesId() {
/*  77 */     return this._seriesId;
/*     */   }
/*     */   
/*     */   public void setSeriesId(String argSeriesId) {
/*  81 */     if (changed(argSeriesId, this._seriesId, "seriesId")) {
/*  82 */       this._seriesId = argSeriesId;
/*     */     }
/*     */   }
/*     */   
/*     */   public String getDocumentId() {
/*  87 */     return this._documentId;
/*     */   }
/*     */   
/*     */   public void setDocumentId(String argDocumentId) {
/*  91 */     if (changed(argDocumentId, this._documentId, "documentId")) {
/*  92 */       this._documentId = argDocumentId;
/*     */     }
/*     */   }
/*     */   
/*     */   public String getDocumentType() {
/*  97 */     return this._documentType;
/*     */   }
/*     */   
/*     */   public void setDocumentType(String argDocumentType) {
/* 101 */     if (changed(argDocumentType, this._documentType, "documentType")) {
/* 102 */       this._documentType = argDocumentType;
/*     */     }
/*     */   }
/*     */   
/*     */   public String getActivityCode() {
/* 107 */     return this._activityCode;
/*     */   }
/*     */   
/*     */   public void setActivityCode(String argActivityCode) {
/* 111 */     if (changed(argActivityCode, this._activityCode, "activityCode")) {
/* 112 */       this._activityCode = argActivityCode;
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public String toString() {
/* 119 */     StringBuilder buf = new StringBuilder(512);
/* 120 */     buf.append(super.toString());
/* 121 */     if (getCreateDate() != null) {
/* 122 */       buf.append("createDate").append("=").append(getCreateDate()).append(" ");
/*     */     }
/* 124 */     if (getCreateUserId() != null) {
/* 125 */       buf.append("createUserId").append("=").append(getCreateUserId()).append(" ");
/*     */     }
/* 127 */     if (getUpdateDate() != null) {
/* 128 */       buf.append("updateDate").append("=").append(getUpdateDate()).append(" ");
/*     */     }
/* 130 */     if (getUpdateUserId() != null) {
/* 131 */       buf.append("updateUserId").append("=").append(getUpdateUserId()).append(" ");
/*     */     }
/* 133 */     if (getSeriesId() != null) {
/* 134 */       buf.append("seriesId").append("=").append(getSeriesId()).append(" ");
/*     */     }
/* 136 */     if (getDocumentId() != null) {
/* 137 */       buf.append("documentId").append("=").append(getDocumentId()).append(" ");
/*     */     }
/* 139 */     if (getDocumentType() != null) {
/* 140 */       buf.append("documentType").append("=").append(getDocumentType()).append(" ");
/*     */     }
/* 142 */     if (getActivityCode() != null) {
/* 143 */       buf.append("activityCode").append("=").append(getActivityCode()).append(" ");
/*     */     }
/*     */     
/* 146 */     return buf.toString();
/*     */   }
/*     */ 
/*     */   
/*     */   public String toXmlString() {
/* 151 */     StringBuilder buf = new StringBuilder(1450);
/* 152 */     buf.append("<").append("dao").append(" name=\"DocumentLineItem\" cmd=\"" + getObjectStateString() + "\">");
/* 153 */     getFieldsAsXml(buf);
/* 154 */     buf.append("</").append("dao").append(">");
/*     */     
/* 156 */     return buf.toString();
/*     */   }
/*     */   
/*     */   public Map<String, String> getValues() {
/* 160 */     Map<String, String> values = super.getValues();
/* 161 */     if (this._createDate != null) values.put("CreateDate", DaoUtils.getXmlSafeFieldValue(91, this._createDate)); 
/* 162 */     if (this._createUserId != null) values.put("CreateUserId", DaoUtils.getXmlSafeFieldValue(12, this._createUserId)); 
/* 163 */     if (this._updateDate != null) values.put("UpdateDate", DaoUtils.getXmlSafeFieldValue(91, this._updateDate)); 
/* 164 */     if (this._updateUserId != null) values.put("UpdateUserId", DaoUtils.getXmlSafeFieldValue(12, this._updateUserId)); 
/* 165 */     if (this._seriesId != null) values.put("SeriesId", DaoUtils.getXmlSafeFieldValue(12, this._seriesId)); 
/* 166 */     if (this._documentId != null) values.put("DocumentId", DaoUtils.getXmlSafeFieldValue(12, this._documentId)); 
/* 167 */     if (this._documentType != null) values.put("DocumentType", DaoUtils.getXmlSafeFieldValue(12, this._documentType)); 
/* 168 */     if (this._activityCode != null) values.put("ActivityCode", DaoUtils.getXmlSafeFieldValue(12, this._activityCode)); 
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
/*     */         case "CreateDate":
/*     */           try {
/* 183 */             Object value = DaoUtils.getFieldValueForXmlString(91, fieldValue);
/* 184 */             setCreateDate((Date)value);
/* 185 */           } catch (Exception ee) {
/* 186 */             throw new DtxException("An exception occurred while calling setCreateDate() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "CreateUserId":
/*     */           try {
/* 192 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 193 */             setCreateUserId((String)value);
/* 194 */           } catch (Exception ee) {
/* 195 */             throw new DtxException("An exception occurred while calling setCreateUserId() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "UpdateDate":
/*     */           try {
/* 201 */             Object value = DaoUtils.getFieldValueForXmlString(91, fieldValue);
/* 202 */             setUpdateDate((Date)value);
/* 203 */           } catch (Exception ee) {
/* 204 */             throw new DtxException("An exception occurred while calling setUpdateDate() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "UpdateUserId":
/*     */           try {
/* 210 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 211 */             setUpdateUserId((String)value);
/* 212 */           } catch (Exception ee) {
/* 213 */             throw new DtxException("An exception occurred while calling setUpdateUserId() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "SeriesId":
/*     */           try {
/* 219 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 220 */             setSeriesId((String)value);
/* 221 */           } catch (Exception ee) {
/* 222 */             throw new DtxException("An exception occurred while calling setSeriesId() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "DocumentId":
/*     */           try {
/* 228 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 229 */             setDocumentId((String)value);
/* 230 */           } catch (Exception ee) {
/* 231 */             throw new DtxException("An exception occurred while calling setDocumentId() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "DocumentType":
/*     */           try {
/* 237 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 238 */             setDocumentType((String)value);
/* 239 */           } catch (Exception ee) {
/* 240 */             throw new DtxException("An exception occurred while calling setDocumentType() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "ActivityCode":
/*     */           try {
/* 246 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 247 */             setActivityCode((String)value);
/* 248 */           } catch (Exception ee) {
/* 249 */             throw new DtxException("An exception occurred while calling setActivityCode() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */       } 
/*     */     } 
/*     */   }
/*     */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\doc\impl\DocumentLineItemDAO.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */