/*     */ package dtv.xst.dao.inv.impl;
/*     */ 
/*     */ import dtv.data2.access.DaoUtils;
/*     */ import dtv.data2.access.IObjectId;
/*     */ import dtv.data2.access.exception.DtxException;
/*     */ import dtv.data2.access.impl.AbstractDAOImpl;
/*     */ import dtv.util.DtvDate;
/*     */ import dtv.xst.dao.inv.DocumentNoteId;
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
/*     */ public class DocumentNoteDAO
/*     */   extends AbstractDAOImpl
/*     */ {
/*     */   private static final long serialVersionUID = -1309064243L;
/*  23 */   private static final Logger _logger = Logger.getLogger(DocumentNoteDAO.class);
/*     */   
/*     */   private Long _organizationId;
/*     */   private Long _retailLocationId;
/*     */   private String _documentId;
/*     */   private String _documentTypeCode;
/*     */   private Long _noteId;
/*     */   private DtvDate _createDate;
/*     */   private String _createUserId;
/*     */   private DtvDate _updateDate;
/*     */   private String _updateUserId;
/*     */   private DtvDate _noteDatetimestamp;
/*     */   private String _note;
/*     */   private Long _creatorPartyId;
/*     */   private String _noteType;
/*     */   
/*     */   public Long getOrganizationId() {
/*  40 */     return this._organizationId;
/*     */   }
/*     */   
/*     */   public void setOrganizationId(Long argOrganizationId) {
/*  44 */     if (changed(argOrganizationId, this._organizationId, "organizationId")) {
/*  45 */       this._organizationId = argOrganizationId;
/*     */     }
/*     */   }
/*     */   
/*     */   public Long getRetailLocationId() {
/*  50 */     return this._retailLocationId;
/*     */   }
/*     */   
/*     */   public void setRetailLocationId(Long argRetailLocationId) {
/*  54 */     if (changed(argRetailLocationId, this._retailLocationId, "retailLocationId")) {
/*  55 */       this._retailLocationId = argRetailLocationId;
/*     */     }
/*     */   }
/*     */   
/*     */   public String getDocumentId() {
/*  60 */     return this._documentId;
/*     */   }
/*     */   
/*     */   public void setDocumentId(String argDocumentId) {
/*  64 */     if (changed(argDocumentId, this._documentId, "documentId")) {
/*  65 */       this._documentId = (argDocumentId != null && MANAGE_CASE) ? argDocumentId.toUpperCase() : argDocumentId;
/*     */     }
/*     */   }
/*     */   
/*     */   public String getDocumentTypeCode() {
/*  70 */     return this._documentTypeCode;
/*     */   }
/*     */   
/*     */   public void setDocumentTypeCode(String argDocumentTypeCode) {
/*  74 */     if (changed(argDocumentTypeCode, this._documentTypeCode, "documentTypeCode")) {
/*  75 */       this._documentTypeCode = (argDocumentTypeCode != null && MANAGE_CASE) ? argDocumentTypeCode.toUpperCase() : argDocumentTypeCode;
/*     */     }
/*     */   }
/*     */   
/*     */   public Long getNoteId() {
/*  80 */     return this._noteId;
/*     */   }
/*     */   
/*     */   public void setNoteId(Long argNoteId) {
/*  84 */     if (changed(argNoteId, this._noteId, "noteId")) {
/*  85 */       this._noteId = argNoteId;
/*     */     }
/*     */   }
/*     */   
/*     */   public Date getCreateDate() {
/*  90 */     return (Date)this._createDate;
/*     */   }
/*     */   
/*     */   public void setCreateDate(Date argCreateDate) {
/*  94 */     if (changed(argCreateDate, this._createDate, "createDate")) {
/*  95 */       this._createDate = (argCreateDate == null || argCreateDate instanceof DtvDate) ? (DtvDate)argCreateDate : new DtvDate(argCreateDate);
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public String getCreateUserId() {
/* 101 */     return this._createUserId;
/*     */   }
/*     */   
/*     */   public void setCreateUserId(String argCreateUserId) {
/* 105 */     if (changed(argCreateUserId, this._createUserId, "createUserId")) {
/* 106 */       this._createUserId = argCreateUserId;
/*     */     }
/*     */   }
/*     */   
/*     */   public Date getUpdateDate() {
/* 111 */     return (Date)this._updateDate;
/*     */   }
/*     */   
/*     */   public void setUpdateDate(Date argUpdateDate) {
/* 115 */     if (changed(argUpdateDate, this._updateDate, "updateDate")) {
/* 116 */       this._updateDate = (argUpdateDate == null || argUpdateDate instanceof DtvDate) ? (DtvDate)argUpdateDate : new DtvDate(argUpdateDate);
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public String getUpdateUserId() {
/* 122 */     return this._updateUserId;
/*     */   }
/*     */   
/*     */   public void setUpdateUserId(String argUpdateUserId) {
/* 126 */     if (changed(argUpdateUserId, this._updateUserId, "updateUserId")) {
/* 127 */       this._updateUserId = argUpdateUserId;
/*     */     }
/*     */   }
/*     */   
/*     */   public Date getNoteDatetimestamp() {
/* 132 */     return (Date)this._noteDatetimestamp;
/*     */   }
/*     */   
/*     */   public void setNoteDatetimestamp(Date argNoteDatetimestamp) {
/* 136 */     if (changed(argNoteDatetimestamp, this._noteDatetimestamp, "noteDatetimestamp")) {
/* 137 */       this._noteDatetimestamp = (argNoteDatetimestamp == null || argNoteDatetimestamp instanceof DtvDate) ? (DtvDate)argNoteDatetimestamp : new DtvDate(argNoteDatetimestamp);
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public String getNote() {
/* 143 */     return this._note;
/*     */   }
/*     */   
/*     */   public void setNote(String argNote) {
/* 147 */     if (changed(argNote, this._note, "note")) {
/* 148 */       this._note = argNote;
/*     */     }
/*     */   }
/*     */   
/*     */   public Long getCreatorPartyId() {
/* 153 */     return this._creatorPartyId;
/*     */   }
/*     */   
/*     */   public void setCreatorPartyId(Long argCreatorPartyId) {
/* 157 */     if (changed(argCreatorPartyId, this._creatorPartyId, "creatorPartyId")) {
/* 158 */       this._creatorPartyId = argCreatorPartyId;
/*     */     }
/*     */   }
/*     */   
/*     */   public String getNoteType() {
/* 163 */     return this._noteType;
/*     */   }
/*     */   
/*     */   public void setNoteType(String argNoteType) {
/* 167 */     if (changed(argNoteType, this._noteType, "noteType")) {
/* 168 */       this._noteType = argNoteType;
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public String toString() {
/* 175 */     StringBuilder buf = new StringBuilder(512);
/* 176 */     buf.append(super.toString()).append(" Id: ").append(getObjectId()).append(" Values: ");
/* 177 */     if (getOrganizationId() != null) {
/* 178 */       buf.append("organizationId").append("=").append(getOrganizationId()).append(" ");
/*     */     }
/* 180 */     if (getRetailLocationId() != null) {
/* 181 */       buf.append("retailLocationId").append("=").append(getRetailLocationId()).append(" ");
/*     */     }
/* 183 */     if (getDocumentId() != null) {
/* 184 */       buf.append("documentId").append("=").append(getDocumentId()).append(" ");
/*     */     }
/* 186 */     if (getDocumentTypeCode() != null) {
/* 187 */       buf.append("documentTypeCode").append("=").append(getDocumentTypeCode()).append(" ");
/*     */     }
/* 189 */     if (getNoteId() != null) {
/* 190 */       buf.append("noteId").append("=").append(getNoteId()).append(" ");
/*     */     }
/* 192 */     if (getCreateDate() != null) {
/* 193 */       buf.append("createDate").append("=").append(getCreateDate()).append(" ");
/*     */     }
/* 195 */     if (getCreateUserId() != null) {
/* 196 */       buf.append("createUserId").append("=").append(getCreateUserId()).append(" ");
/*     */     }
/* 198 */     if (getUpdateDate() != null) {
/* 199 */       buf.append("updateDate").append("=").append(getUpdateDate()).append(" ");
/*     */     }
/* 201 */     if (getUpdateUserId() != null) {
/* 202 */       buf.append("updateUserId").append("=").append(getUpdateUserId()).append(" ");
/*     */     }
/* 204 */     if (getNoteDatetimestamp() != null) {
/* 205 */       buf.append("noteDatetimestamp").append("=").append(getNoteDatetimestamp()).append(" ");
/*     */     }
/* 207 */     if (getNote() != null) {
/* 208 */       buf.append("note").append("=").append(getNote()).append(" ");
/*     */     }
/* 210 */     if (getCreatorPartyId() != null) {
/* 211 */       buf.append("creatorPartyId").append("=").append(getCreatorPartyId()).append(" ");
/*     */     }
/* 213 */     if (getNoteType() != null) {
/* 214 */       buf.append("noteType").append("=").append(getNoteType()).append(" ");
/*     */     }
/*     */     
/* 217 */     return buf.toString();
/*     */   }
/*     */   
/*     */   public IObjectId getObjectId() {
/* 221 */     DocumentNoteId id = new DocumentNoteId();
/* 222 */     id.setOrganizationId(getOrganizationId());
/* 223 */     id.setRetailLocationId(getRetailLocationId());
/* 224 */     id.setDocumentId(getDocumentId());
/* 225 */     id.setDocumentTypeCode(getDocumentTypeCode());
/* 226 */     id.setNoteId(getNoteId());
/* 227 */     return (IObjectId)id;
/*     */   }
/*     */   
/*     */   public void setObjectId(IObjectId argObjectId) {
/* 231 */     setOrganizationId(((DocumentNoteId)argObjectId).getOrganizationId());
/* 232 */     setRetailLocationId(((DocumentNoteId)argObjectId).getRetailLocationId());
/* 233 */     setDocumentId(((DocumentNoteId)argObjectId).getDocumentId());
/* 234 */     setDocumentTypeCode(((DocumentNoteId)argObjectId).getDocumentTypeCode());
/* 235 */     setNoteId(((DocumentNoteId)argObjectId).getNoteId());
/*     */   }
/*     */   
/*     */   public String getImplementingClass() {
/* 239 */     return null;
/*     */   }
/*     */   
/*     */   public String toXmlString() {
/* 243 */     StringBuilder buf = new StringBuilder(650);
/* 244 */     buf.append("<").append("dao").append(" name=\"DocumentNote\" cmd=\"" + getObjectStateString() + "\">");
/* 245 */     getFieldsAsXml(buf);
/* 246 */     buf.append("</").append("dao").append(">");
/*     */     
/* 248 */     return buf.toString();
/*     */   }
/*     */   
/*     */   public Map<String, String> getValues() {
/* 252 */     Map<String, String> values = super.getValues();
/* 253 */     if (this._organizationId != null) values.put("OrganizationId", DaoUtils.getXmlSafeFieldValue(-5, this._organizationId)); 
/* 254 */     if (this._retailLocationId != null) values.put("RetailLocationId", DaoUtils.getXmlSafeFieldValue(-5, this._retailLocationId)); 
/* 255 */     if (this._documentId != null) values.put("DocumentId", DaoUtils.getXmlSafeFieldValue(12, this._documentId)); 
/* 256 */     if (this._documentTypeCode != null) values.put("DocumentTypeCode", DaoUtils.getXmlSafeFieldValue(12, this._documentTypeCode)); 
/* 257 */     if (this._noteId != null) values.put("NoteId", DaoUtils.getXmlSafeFieldValue(-5, this._noteId)); 
/* 258 */     if (this._createDate != null) values.put("CreateDate", DaoUtils.getXmlSafeFieldValue(91, this._createDate)); 
/* 259 */     if (this._createUserId != null) values.put("CreateUserId", DaoUtils.getXmlSafeFieldValue(12, this._createUserId)); 
/* 260 */     if (this._updateDate != null) values.put("UpdateDate", DaoUtils.getXmlSafeFieldValue(91, this._updateDate)); 
/* 261 */     if (this._updateUserId != null) values.put("UpdateUserId", DaoUtils.getXmlSafeFieldValue(12, this._updateUserId)); 
/* 262 */     if (this._noteDatetimestamp != null) values.put("NoteDatetimestamp", DaoUtils.getXmlSafeFieldValue(91, this._noteDatetimestamp)); 
/* 263 */     if (this._note != null) values.put("Note", DaoUtils.getXmlSafeFieldValue(2005, this._note)); 
/* 264 */     if (this._creatorPartyId != null) values.put("CreatorPartyId", DaoUtils.getXmlSafeFieldValue(-5, this._creatorPartyId)); 
/* 265 */     if (this._noteType != null) values.put("NoteType", DaoUtils.getXmlSafeFieldValue(12, this._noteType)); 
/* 266 */     return values;
/*     */   }
/*     */ 
/*     */   
/*     */   public void setValues(Map<String, String> argValues) {
/* 271 */     super.setValues(argValues);
/* 272 */     for (Map.Entry<String, String> field : argValues.entrySet()) {
/*     */       
/* 274 */       String fieldName = field.getKey();
/* 275 */       String fieldValue = field.getValue();
/* 276 */       switch (fieldName) {
/*     */         
/*     */         case "OrganizationId":
/*     */           try {
/* 280 */             Object value = DaoUtils.getFieldValueForXmlString(-5, fieldValue);
/* 281 */             setOrganizationId((Long)value);
/* 282 */           } catch (Exception ee) {
/* 283 */             throw new DtxException("An exception occurred while calling setOrganizationId() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "RetailLocationId":
/*     */           try {
/* 289 */             Object value = DaoUtils.getFieldValueForXmlString(-5, fieldValue);
/* 290 */             setRetailLocationId((Long)value);
/* 291 */           } catch (Exception ee) {
/* 292 */             throw new DtxException("An exception occurred while calling setRetailLocationId() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "DocumentId":
/*     */           try {
/* 298 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 299 */             setDocumentId((String)value);
/* 300 */           } catch (Exception ee) {
/* 301 */             throw new DtxException("An exception occurred while calling setDocumentId() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "DocumentTypeCode":
/*     */           try {
/* 307 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 308 */             setDocumentTypeCode((String)value);
/* 309 */           } catch (Exception ee) {
/* 310 */             throw new DtxException("An exception occurred while calling setDocumentTypeCode() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "NoteId":
/*     */           try {
/* 316 */             Object value = DaoUtils.getFieldValueForXmlString(-5, fieldValue);
/* 317 */             setNoteId((Long)value);
/* 318 */           } catch (Exception ee) {
/* 319 */             throw new DtxException("An exception occurred while calling setNoteId() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "CreateDate":
/*     */           try {
/* 325 */             Object value = DaoUtils.getFieldValueForXmlString(91, fieldValue);
/* 326 */             setCreateDate((Date)value);
/* 327 */           } catch (Exception ee) {
/* 328 */             throw new DtxException("An exception occurred while calling setCreateDate() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "CreateUserId":
/*     */           try {
/* 334 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 335 */             setCreateUserId((String)value);
/* 336 */           } catch (Exception ee) {
/* 337 */             throw new DtxException("An exception occurred while calling setCreateUserId() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "UpdateDate":
/*     */           try {
/* 343 */             Object value = DaoUtils.getFieldValueForXmlString(91, fieldValue);
/* 344 */             setUpdateDate((Date)value);
/* 345 */           } catch (Exception ee) {
/* 346 */             throw new DtxException("An exception occurred while calling setUpdateDate() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "UpdateUserId":
/*     */           try {
/* 352 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 353 */             setUpdateUserId((String)value);
/* 354 */           } catch (Exception ee) {
/* 355 */             throw new DtxException("An exception occurred while calling setUpdateUserId() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "NoteDatetimestamp":
/*     */           try {
/* 361 */             Object value = DaoUtils.getFieldValueForXmlString(91, fieldValue);
/* 362 */             setNoteDatetimestamp((Date)value);
/* 363 */           } catch (Exception ee) {
/* 364 */             throw new DtxException("An exception occurred while calling setNoteDatetimestamp() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "Note":
/*     */           try {
/* 370 */             Object value = DaoUtils.getFieldValueForXmlString(2005, fieldValue);
/* 371 */             setNote((String)value);
/* 372 */           } catch (Exception ee) {
/* 373 */             throw new DtxException("An exception occurred while calling setNote() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "CreatorPartyId":
/*     */           try {
/* 379 */             Object value = DaoUtils.getFieldValueForXmlString(-5, fieldValue);
/* 380 */             setCreatorPartyId((Long)value);
/* 381 */           } catch (Exception ee) {
/* 382 */             throw new DtxException("An exception occurred while calling setCreatorPartyId() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "NoteType":
/*     */           try {
/* 388 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 389 */             setNoteType((String)value);
/* 390 */           } catch (Exception ee) {
/* 391 */             throw new DtxException("An exception occurred while calling setNoteType() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */       } 
/*     */     } 
/*     */   }
/*     */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\inv\impl\DocumentNoteDAO.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */