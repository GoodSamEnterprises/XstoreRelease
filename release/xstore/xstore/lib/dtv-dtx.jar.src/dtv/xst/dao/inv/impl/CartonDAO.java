/*     */ package dtv.xst.dao.inv.impl;
/*     */ 
/*     */ import dtv.data2.access.DaoUtils;
/*     */ import dtv.data2.access.IObjectId;
/*     */ import dtv.data2.access.exception.DtxException;
/*     */ import dtv.data2.access.impl.AbstractDAOImpl;
/*     */ import dtv.util.DtvDate;
/*     */ import dtv.xst.dao.inv.CartonId;
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
/*     */ public class CartonDAO
/*     */   extends AbstractDAOImpl
/*     */ {
/*     */   private static final long serialVersionUID = 2011245855L;
/*  23 */   private static final Logger _logger = Logger.getLogger(CartonDAO.class);
/*     */   
/*     */   private String _documentId;
/*     */   private String _documentTypeCode;
/*     */   private String _cartonId;
/*     */   private Long _organizationId;
/*     */   private Long _retailLocationId;
/*     */   private DtvDate _createDate;
/*     */   private String _createUserId;
/*     */   private DtvDate _updateDate;
/*     */   private String _updateUserId;
/*     */   private String _cartonStatusCode;
/*     */   private String _controlNumber;
/*     */   private String _recordCreationType;
/*     */   
/*     */   public String getDocumentId() {
/*  39 */     return this._documentId;
/*     */   }
/*     */   
/*     */   public void setDocumentId(String argDocumentId) {
/*  43 */     if (changed(argDocumentId, this._documentId, "documentId")) {
/*  44 */       this._documentId = (argDocumentId != null && MANAGE_CASE) ? argDocumentId.toUpperCase() : argDocumentId;
/*     */     }
/*     */   }
/*     */   
/*     */   public String getDocumentTypeCode() {
/*  49 */     return this._documentTypeCode;
/*     */   }
/*     */   
/*     */   public void setDocumentTypeCode(String argDocumentTypeCode) {
/*  53 */     if (changed(argDocumentTypeCode, this._documentTypeCode, "documentTypeCode")) {
/*  54 */       this._documentTypeCode = (argDocumentTypeCode != null && MANAGE_CASE) ? argDocumentTypeCode.toUpperCase() : argDocumentTypeCode;
/*     */     }
/*     */   }
/*     */   
/*     */   public String getCartonId() {
/*  59 */     return this._cartonId;
/*     */   }
/*     */   
/*     */   public void setCartonId(String argCartonId) {
/*  63 */     if (changed(argCartonId, this._cartonId, "cartonId")) {
/*  64 */       this._cartonId = (argCartonId != null && MANAGE_CASE) ? argCartonId.toUpperCase() : argCartonId;
/*     */     }
/*     */   }
/*     */   
/*     */   public Long getOrganizationId() {
/*  69 */     return this._organizationId;
/*     */   }
/*     */   
/*     */   public void setOrganizationId(Long argOrganizationId) {
/*  73 */     if (changed(argOrganizationId, this._organizationId, "organizationId")) {
/*  74 */       this._organizationId = argOrganizationId;
/*     */     }
/*     */   }
/*     */   
/*     */   public Long getRetailLocationId() {
/*  79 */     return this._retailLocationId;
/*     */   }
/*     */   
/*     */   public void setRetailLocationId(Long argRetailLocationId) {
/*  83 */     if (changed(argRetailLocationId, this._retailLocationId, "retailLocationId")) {
/*  84 */       this._retailLocationId = argRetailLocationId;
/*     */     }
/*     */   }
/*     */   
/*     */   public Date getCreateDate() {
/*  89 */     return (Date)this._createDate;
/*     */   }
/*     */   
/*     */   public void setCreateDate(Date argCreateDate) {
/*  93 */     if (changed(argCreateDate, this._createDate, "createDate")) {
/*  94 */       this._createDate = (argCreateDate == null || argCreateDate instanceof DtvDate) ? (DtvDate)argCreateDate : new DtvDate(argCreateDate);
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public String getCreateUserId() {
/* 100 */     return this._createUserId;
/*     */   }
/*     */   
/*     */   public void setCreateUserId(String argCreateUserId) {
/* 104 */     if (changed(argCreateUserId, this._createUserId, "createUserId")) {
/* 105 */       this._createUserId = argCreateUserId;
/*     */     }
/*     */   }
/*     */   
/*     */   public Date getUpdateDate() {
/* 110 */     return (Date)this._updateDate;
/*     */   }
/*     */   
/*     */   public void setUpdateDate(Date argUpdateDate) {
/* 114 */     if (changed(argUpdateDate, this._updateDate, "updateDate")) {
/* 115 */       this._updateDate = (argUpdateDate == null || argUpdateDate instanceof DtvDate) ? (DtvDate)argUpdateDate : new DtvDate(argUpdateDate);
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public String getUpdateUserId() {
/* 121 */     return this._updateUserId;
/*     */   }
/*     */   
/*     */   public void setUpdateUserId(String argUpdateUserId) {
/* 125 */     if (changed(argUpdateUserId, this._updateUserId, "updateUserId")) {
/* 126 */       this._updateUserId = argUpdateUserId;
/*     */     }
/*     */   }
/*     */   
/*     */   public String getCartonStatusCode() {
/* 131 */     return this._cartonStatusCode;
/*     */   }
/*     */   
/*     */   public void setCartonStatusCode(String argCartonStatusCode) {
/* 135 */     if (changed(argCartonStatusCode, this._cartonStatusCode, "cartonStatusCode")) {
/* 136 */       this._cartonStatusCode = argCartonStatusCode;
/*     */     }
/*     */   }
/*     */   
/*     */   public String getControlNumber() {
/* 141 */     return this._controlNumber;
/*     */   }
/*     */   
/*     */   public void setControlNumber(String argControlNumber) {
/* 145 */     if (changed(argControlNumber, this._controlNumber, "controlNumber")) {
/* 146 */       this._controlNumber = argControlNumber;
/*     */     }
/*     */   }
/*     */   
/*     */   public String getRecordCreationType() {
/* 151 */     return this._recordCreationType;
/*     */   }
/*     */   
/*     */   public void setRecordCreationType(String argRecordCreationType) {
/* 155 */     if (changed(argRecordCreationType, this._recordCreationType, "recordCreationType")) {
/* 156 */       this._recordCreationType = argRecordCreationType;
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public String toString() {
/* 163 */     StringBuilder buf = new StringBuilder(512);
/* 164 */     buf.append(super.toString()).append(" Id: ").append(getObjectId()).append(" Values: ");
/* 165 */     if (getDocumentId() != null) {
/* 166 */       buf.append("documentId").append("=").append(getDocumentId()).append(" ");
/*     */     }
/* 168 */     if (getDocumentTypeCode() != null) {
/* 169 */       buf.append("documentTypeCode").append("=").append(getDocumentTypeCode()).append(" ");
/*     */     }
/* 171 */     if (getCartonId() != null) {
/* 172 */       buf.append("cartonId").append("=").append(getCartonId()).append(" ");
/*     */     }
/* 174 */     if (getOrganizationId() != null) {
/* 175 */       buf.append("organizationId").append("=").append(getOrganizationId()).append(" ");
/*     */     }
/* 177 */     if (getRetailLocationId() != null) {
/* 178 */       buf.append("retailLocationId").append("=").append(getRetailLocationId()).append(" ");
/*     */     }
/* 180 */     if (getCreateDate() != null) {
/* 181 */       buf.append("createDate").append("=").append(getCreateDate()).append(" ");
/*     */     }
/* 183 */     if (getCreateUserId() != null) {
/* 184 */       buf.append("createUserId").append("=").append(getCreateUserId()).append(" ");
/*     */     }
/* 186 */     if (getUpdateDate() != null) {
/* 187 */       buf.append("updateDate").append("=").append(getUpdateDate()).append(" ");
/*     */     }
/* 189 */     if (getUpdateUserId() != null) {
/* 190 */       buf.append("updateUserId").append("=").append(getUpdateUserId()).append(" ");
/*     */     }
/* 192 */     if (getCartonStatusCode() != null) {
/* 193 */       buf.append("cartonStatusCode").append("=").append(getCartonStatusCode()).append(" ");
/*     */     }
/* 195 */     if (getControlNumber() != null) {
/* 196 */       buf.append("controlNumber").append("=").append(getControlNumber()).append(" ");
/*     */     }
/* 198 */     if (getRecordCreationType() != null) {
/* 199 */       buf.append("recordCreationType").append("=").append(getRecordCreationType()).append(" ");
/*     */     }
/*     */     
/* 202 */     return buf.toString();
/*     */   }
/*     */   
/*     */   public IObjectId getObjectId() {
/* 206 */     CartonId id = new CartonId();
/* 207 */     id.setDocumentId(getDocumentId());
/* 208 */     id.setDocumentTypeCode(getDocumentTypeCode());
/* 209 */     id.setCartonId(getCartonId());
/* 210 */     id.setOrganizationId(getOrganizationId());
/* 211 */     id.setRetailLocationId(getRetailLocationId());
/* 212 */     return (IObjectId)id;
/*     */   }
/*     */   
/*     */   public void setObjectId(IObjectId argObjectId) {
/* 216 */     setDocumentId(((CartonId)argObjectId).getDocumentId());
/* 217 */     setDocumentTypeCode(((CartonId)argObjectId).getDocumentTypeCode());
/* 218 */     setCartonId(((CartonId)argObjectId).getCartonId());
/* 219 */     setOrganizationId(((CartonId)argObjectId).getOrganizationId());
/* 220 */     setRetailLocationId(((CartonId)argObjectId).getRetailLocationId());
/*     */   }
/*     */   
/*     */   public String getImplementingClass() {
/* 224 */     return null;
/*     */   }
/*     */   
/*     */   public String toXmlString() {
/* 228 */     StringBuilder buf = new StringBuilder(600);
/* 229 */     buf.append("<").append("dao").append(" name=\"Carton\" cmd=\"" + getObjectStateString() + "\">");
/* 230 */     getFieldsAsXml(buf);
/* 231 */     buf.append("</").append("dao").append(">");
/*     */     
/* 233 */     return buf.toString();
/*     */   }
/*     */   
/*     */   public Map<String, String> getValues() {
/* 237 */     Map<String, String> values = super.getValues();
/* 238 */     if (this._documentId != null) values.put("DocumentId", DaoUtils.getXmlSafeFieldValue(12, this._documentId)); 
/* 239 */     if (this._documentTypeCode != null) values.put("DocumentTypeCode", DaoUtils.getXmlSafeFieldValue(12, this._documentTypeCode)); 
/* 240 */     if (this._cartonId != null) values.put("CartonId", DaoUtils.getXmlSafeFieldValue(12, this._cartonId)); 
/* 241 */     if (this._organizationId != null) values.put("OrganizationId", DaoUtils.getXmlSafeFieldValue(-5, this._organizationId)); 
/* 242 */     if (this._retailLocationId != null) values.put("RetailLocationId", DaoUtils.getXmlSafeFieldValue(-5, this._retailLocationId)); 
/* 243 */     if (this._createDate != null) values.put("CreateDate", DaoUtils.getXmlSafeFieldValue(91, this._createDate)); 
/* 244 */     if (this._createUserId != null) values.put("CreateUserId", DaoUtils.getXmlSafeFieldValue(12, this._createUserId)); 
/* 245 */     if (this._updateDate != null) values.put("UpdateDate", DaoUtils.getXmlSafeFieldValue(91, this._updateDate)); 
/* 246 */     if (this._updateUserId != null) values.put("UpdateUserId", DaoUtils.getXmlSafeFieldValue(12, this._updateUserId)); 
/* 247 */     if (this._cartonStatusCode != null) values.put("CartonStatusCode", DaoUtils.getXmlSafeFieldValue(12, this._cartonStatusCode)); 
/* 248 */     if (this._controlNumber != null) values.put("ControlNumber", DaoUtils.getXmlSafeFieldValue(12, this._controlNumber)); 
/* 249 */     if (this._recordCreationType != null) values.put("RecordCreationType", DaoUtils.getXmlSafeFieldValue(12, this._recordCreationType)); 
/* 250 */     return values;
/*     */   }
/*     */ 
/*     */   
/*     */   public void setValues(Map<String, String> argValues) {
/* 255 */     super.setValues(argValues);
/* 256 */     for (Map.Entry<String, String> field : argValues.entrySet()) {
/*     */       
/* 258 */       String fieldName = field.getKey();
/* 259 */       String fieldValue = field.getValue();
/* 260 */       switch (fieldName) {
/*     */         
/*     */         case "DocumentId":
/*     */           try {
/* 264 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 265 */             setDocumentId((String)value);
/* 266 */           } catch (Exception ee) {
/* 267 */             throw new DtxException("An exception occurred while calling setDocumentId() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "DocumentTypeCode":
/*     */           try {
/* 273 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 274 */             setDocumentTypeCode((String)value);
/* 275 */           } catch (Exception ee) {
/* 276 */             throw new DtxException("An exception occurred while calling setDocumentTypeCode() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "CartonId":
/*     */           try {
/* 282 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 283 */             setCartonId((String)value);
/* 284 */           } catch (Exception ee) {
/* 285 */             throw new DtxException("An exception occurred while calling setCartonId() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "OrganizationId":
/*     */           try {
/* 291 */             Object value = DaoUtils.getFieldValueForXmlString(-5, fieldValue);
/* 292 */             setOrganizationId((Long)value);
/* 293 */           } catch (Exception ee) {
/* 294 */             throw new DtxException("An exception occurred while calling setOrganizationId() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "RetailLocationId":
/*     */           try {
/* 300 */             Object value = DaoUtils.getFieldValueForXmlString(-5, fieldValue);
/* 301 */             setRetailLocationId((Long)value);
/* 302 */           } catch (Exception ee) {
/* 303 */             throw new DtxException("An exception occurred while calling setRetailLocationId() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "CreateDate":
/*     */           try {
/* 309 */             Object value = DaoUtils.getFieldValueForXmlString(91, fieldValue);
/* 310 */             setCreateDate((Date)value);
/* 311 */           } catch (Exception ee) {
/* 312 */             throw new DtxException("An exception occurred while calling setCreateDate() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "CreateUserId":
/*     */           try {
/* 318 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 319 */             setCreateUserId((String)value);
/* 320 */           } catch (Exception ee) {
/* 321 */             throw new DtxException("An exception occurred while calling setCreateUserId() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "UpdateDate":
/*     */           try {
/* 327 */             Object value = DaoUtils.getFieldValueForXmlString(91, fieldValue);
/* 328 */             setUpdateDate((Date)value);
/* 329 */           } catch (Exception ee) {
/* 330 */             throw new DtxException("An exception occurred while calling setUpdateDate() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "UpdateUserId":
/*     */           try {
/* 336 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 337 */             setUpdateUserId((String)value);
/* 338 */           } catch (Exception ee) {
/* 339 */             throw new DtxException("An exception occurred while calling setUpdateUserId() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "CartonStatusCode":
/*     */           try {
/* 345 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 346 */             setCartonStatusCode((String)value);
/* 347 */           } catch (Exception ee) {
/* 348 */             throw new DtxException("An exception occurred while calling setCartonStatusCode() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "ControlNumber":
/*     */           try {
/* 354 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 355 */             setControlNumber((String)value);
/* 356 */           } catch (Exception ee) {
/* 357 */             throw new DtxException("An exception occurred while calling setControlNumber() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "RecordCreationType":
/*     */           try {
/* 363 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 364 */             setRecordCreationType((String)value);
/* 365 */           } catch (Exception ee) {
/* 366 */             throw new DtxException("An exception occurred while calling setRecordCreationType() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */       } 
/*     */     } 
/*     */   }
/*     */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\inv\impl\CartonDAO.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */