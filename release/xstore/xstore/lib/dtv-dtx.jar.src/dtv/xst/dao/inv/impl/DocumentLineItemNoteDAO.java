/*     */ package dtv.xst.dao.inv.impl;
/*     */ 
/*     */ import dtv.data2.access.DaoUtils;
/*     */ import dtv.data2.access.IObjectId;
/*     */ import dtv.data2.access.exception.DtxException;
/*     */ import dtv.data2.access.impl.AbstractDAOImpl;
/*     */ import dtv.util.DtvDate;
/*     */ import dtv.xst.dao.inv.DocumentLineItemNoteId;
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
/*     */ public class DocumentLineItemNoteDAO
/*     */   extends AbstractDAOImpl
/*     */ {
/*     */   private static final long serialVersionUID = 1348617876L;
/*  23 */   private static final Logger _logger = Logger.getLogger(DocumentLineItemNoteDAO.class);
/*     */   
/*     */   private Long _organizationId;
/*     */   private Long _retailLocationId;
/*     */   private String _documentId;
/*     */   private String _documentTypeCode;
/*     */   private Integer _inventoryDocumentLineNumber;
/*     */   private Long _noteId;
/*     */   private DtvDate _createDate;
/*     */   private String _createUserId;
/*     */   private DtvDate _updateDate;
/*     */   private String _updateUserId;
/*     */   private DtvDate _noteDatetimestamp;
/*     */   private String _note;
/*     */   private Long _creatorPartyId;
/*     */   private String _noteType;
/*     */   private String _recordCreationType;
/*     */   
/*     */   public Long getOrganizationId() {
/*  42 */     return this._organizationId;
/*     */   }
/*     */   
/*     */   public void setOrganizationId(Long argOrganizationId) {
/*  46 */     if (changed(argOrganizationId, this._organizationId, "organizationId")) {
/*  47 */       this._organizationId = argOrganizationId;
/*     */     }
/*     */   }
/*     */   
/*     */   public Long getRetailLocationId() {
/*  52 */     return this._retailLocationId;
/*     */   }
/*     */   
/*     */   public void setRetailLocationId(Long argRetailLocationId) {
/*  56 */     if (changed(argRetailLocationId, this._retailLocationId, "retailLocationId")) {
/*  57 */       this._retailLocationId = argRetailLocationId;
/*     */     }
/*     */   }
/*     */   
/*     */   public String getDocumentId() {
/*  62 */     return this._documentId;
/*     */   }
/*     */   
/*     */   public void setDocumentId(String argDocumentId) {
/*  66 */     if (changed(argDocumentId, this._documentId, "documentId")) {
/*  67 */       this._documentId = (argDocumentId != null && MANAGE_CASE) ? argDocumentId.toUpperCase() : argDocumentId;
/*     */     }
/*     */   }
/*     */   
/*     */   public String getDocumentTypeCode() {
/*  72 */     return this._documentTypeCode;
/*     */   }
/*     */   
/*     */   public void setDocumentTypeCode(String argDocumentTypeCode) {
/*  76 */     if (changed(argDocumentTypeCode, this._documentTypeCode, "documentTypeCode")) {
/*  77 */       this._documentTypeCode = (argDocumentTypeCode != null && MANAGE_CASE) ? argDocumentTypeCode.toUpperCase() : argDocumentTypeCode;
/*     */     }
/*     */   }
/*     */   
/*     */   public Integer getInventoryDocumentLineNumber() {
/*  82 */     return this._inventoryDocumentLineNumber;
/*     */   }
/*     */   
/*     */   public void setInventoryDocumentLineNumber(Integer argInventoryDocumentLineNumber) {
/*  86 */     if (changed(argInventoryDocumentLineNumber, this._inventoryDocumentLineNumber, "inventoryDocumentLineNumber")) {
/*  87 */       this._inventoryDocumentLineNumber = argInventoryDocumentLineNumber;
/*     */     }
/*     */   }
/*     */   
/*     */   public Long getNoteId() {
/*  92 */     return this._noteId;
/*     */   }
/*     */   
/*     */   public void setNoteId(Long argNoteId) {
/*  96 */     if (changed(argNoteId, this._noteId, "noteId")) {
/*  97 */       this._noteId = argNoteId;
/*     */     }
/*     */   }
/*     */   
/*     */   public Date getCreateDate() {
/* 102 */     return (Date)this._createDate;
/*     */   }
/*     */   
/*     */   public void setCreateDate(Date argCreateDate) {
/* 106 */     if (changed(argCreateDate, this._createDate, "createDate")) {
/* 107 */       this._createDate = (argCreateDate == null || argCreateDate instanceof DtvDate) ? (DtvDate)argCreateDate : new DtvDate(argCreateDate);
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public String getCreateUserId() {
/* 113 */     return this._createUserId;
/*     */   }
/*     */   
/*     */   public void setCreateUserId(String argCreateUserId) {
/* 117 */     if (changed(argCreateUserId, this._createUserId, "createUserId")) {
/* 118 */       this._createUserId = argCreateUserId;
/*     */     }
/*     */   }
/*     */   
/*     */   public Date getUpdateDate() {
/* 123 */     return (Date)this._updateDate;
/*     */   }
/*     */   
/*     */   public void setUpdateDate(Date argUpdateDate) {
/* 127 */     if (changed(argUpdateDate, this._updateDate, "updateDate")) {
/* 128 */       this._updateDate = (argUpdateDate == null || argUpdateDate instanceof DtvDate) ? (DtvDate)argUpdateDate : new DtvDate(argUpdateDate);
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public String getUpdateUserId() {
/* 134 */     return this._updateUserId;
/*     */   }
/*     */   
/*     */   public void setUpdateUserId(String argUpdateUserId) {
/* 138 */     if (changed(argUpdateUserId, this._updateUserId, "updateUserId")) {
/* 139 */       this._updateUserId = argUpdateUserId;
/*     */     }
/*     */   }
/*     */   
/*     */   public Date getNoteDatetimestamp() {
/* 144 */     return (Date)this._noteDatetimestamp;
/*     */   }
/*     */   
/*     */   public void setNoteDatetimestamp(Date argNoteDatetimestamp) {
/* 148 */     if (changed(argNoteDatetimestamp, this._noteDatetimestamp, "noteDatetimestamp")) {
/* 149 */       this._noteDatetimestamp = (argNoteDatetimestamp == null || argNoteDatetimestamp instanceof DtvDate) ? (DtvDate)argNoteDatetimestamp : new DtvDate(argNoteDatetimestamp);
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public String getNote() {
/* 155 */     return this._note;
/*     */   }
/*     */   
/*     */   public void setNote(String argNote) {
/* 159 */     if (changed(argNote, this._note, "note")) {
/* 160 */       this._note = argNote;
/*     */     }
/*     */   }
/*     */   
/*     */   public Long getCreatorPartyId() {
/* 165 */     return this._creatorPartyId;
/*     */   }
/*     */   
/*     */   public void setCreatorPartyId(Long argCreatorPartyId) {
/* 169 */     if (changed(argCreatorPartyId, this._creatorPartyId, "creatorPartyId")) {
/* 170 */       this._creatorPartyId = argCreatorPartyId;
/*     */     }
/*     */   }
/*     */   
/*     */   public String getNoteType() {
/* 175 */     return this._noteType;
/*     */   }
/*     */   
/*     */   public void setNoteType(String argNoteType) {
/* 179 */     if (changed(argNoteType, this._noteType, "noteType")) {
/* 180 */       this._noteType = argNoteType;
/*     */     }
/*     */   }
/*     */   
/*     */   public String getRecordCreationType() {
/* 185 */     return this._recordCreationType;
/*     */   }
/*     */   
/*     */   public void setRecordCreationType(String argRecordCreationType) {
/* 189 */     if (changed(argRecordCreationType, this._recordCreationType, "recordCreationType")) {
/* 190 */       this._recordCreationType = argRecordCreationType;
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public String toString() {
/* 197 */     StringBuilder buf = new StringBuilder(512);
/* 198 */     buf.append(super.toString()).append(" Id: ").append(getObjectId()).append(" Values: ");
/* 199 */     if (getOrganizationId() != null) {
/* 200 */       buf.append("organizationId").append("=").append(getOrganizationId()).append(" ");
/*     */     }
/* 202 */     if (getRetailLocationId() != null) {
/* 203 */       buf.append("retailLocationId").append("=").append(getRetailLocationId()).append(" ");
/*     */     }
/* 205 */     if (getDocumentId() != null) {
/* 206 */       buf.append("documentId").append("=").append(getDocumentId()).append(" ");
/*     */     }
/* 208 */     if (getDocumentTypeCode() != null) {
/* 209 */       buf.append("documentTypeCode").append("=").append(getDocumentTypeCode()).append(" ");
/*     */     }
/* 211 */     if (getInventoryDocumentLineNumber() != null) {
/* 212 */       buf.append("inventoryDocumentLineNumber").append("=").append(getInventoryDocumentLineNumber()).append(" ");
/*     */     }
/* 214 */     if (getNoteId() != null) {
/* 215 */       buf.append("noteId").append("=").append(getNoteId()).append(" ");
/*     */     }
/* 217 */     if (getCreateDate() != null) {
/* 218 */       buf.append("createDate").append("=").append(getCreateDate()).append(" ");
/*     */     }
/* 220 */     if (getCreateUserId() != null) {
/* 221 */       buf.append("createUserId").append("=").append(getCreateUserId()).append(" ");
/*     */     }
/* 223 */     if (getUpdateDate() != null) {
/* 224 */       buf.append("updateDate").append("=").append(getUpdateDate()).append(" ");
/*     */     }
/* 226 */     if (getUpdateUserId() != null) {
/* 227 */       buf.append("updateUserId").append("=").append(getUpdateUserId()).append(" ");
/*     */     }
/* 229 */     if (getNoteDatetimestamp() != null) {
/* 230 */       buf.append("noteDatetimestamp").append("=").append(getNoteDatetimestamp()).append(" ");
/*     */     }
/* 232 */     if (getNote() != null) {
/* 233 */       buf.append("note").append("=").append(getNote()).append(" ");
/*     */     }
/* 235 */     if (getCreatorPartyId() != null) {
/* 236 */       buf.append("creatorPartyId").append("=").append(getCreatorPartyId()).append(" ");
/*     */     }
/* 238 */     if (getNoteType() != null) {
/* 239 */       buf.append("noteType").append("=").append(getNoteType()).append(" ");
/*     */     }
/* 241 */     if (getRecordCreationType() != null) {
/* 242 */       buf.append("recordCreationType").append("=").append(getRecordCreationType()).append(" ");
/*     */     }
/*     */     
/* 245 */     return buf.toString();
/*     */   }
/*     */   
/*     */   public IObjectId getObjectId() {
/* 249 */     DocumentLineItemNoteId id = new DocumentLineItemNoteId();
/* 250 */     id.setOrganizationId(getOrganizationId());
/* 251 */     id.setRetailLocationId(getRetailLocationId());
/* 252 */     id.setDocumentId(getDocumentId());
/* 253 */     id.setDocumentTypeCode(getDocumentTypeCode());
/* 254 */     id.setInventoryDocumentLineNumber(getInventoryDocumentLineNumber());
/* 255 */     id.setNoteId(getNoteId());
/* 256 */     return (IObjectId)id;
/*     */   }
/*     */   
/*     */   public void setObjectId(IObjectId argObjectId) {
/* 260 */     setOrganizationId(((DocumentLineItemNoteId)argObjectId).getOrganizationId());
/* 261 */     setRetailLocationId(((DocumentLineItemNoteId)argObjectId).getRetailLocationId());
/* 262 */     setDocumentId(((DocumentLineItemNoteId)argObjectId).getDocumentId());
/* 263 */     setDocumentTypeCode(((DocumentLineItemNoteId)argObjectId).getDocumentTypeCode());
/* 264 */     setInventoryDocumentLineNumber(((DocumentLineItemNoteId)argObjectId).getInventoryDocumentLineNumber());
/* 265 */     setNoteId(((DocumentLineItemNoteId)argObjectId).getNoteId());
/*     */   }
/*     */   
/*     */   public String getImplementingClass() {
/* 269 */     return null;
/*     */   }
/*     */   
/*     */   public String toXmlString() {
/* 273 */     StringBuilder buf = new StringBuilder(750);
/* 274 */     buf.append("<").append("dao").append(" name=\"DocumentLineItemNote\" cmd=\"" + getObjectStateString() + "\">");
/* 275 */     getFieldsAsXml(buf);
/* 276 */     buf.append("</").append("dao").append(">");
/*     */     
/* 278 */     return buf.toString();
/*     */   }
/*     */   
/*     */   public Map<String, String> getValues() {
/* 282 */     Map<String, String> values = super.getValues();
/* 283 */     if (this._organizationId != null) values.put("OrganizationId", DaoUtils.getXmlSafeFieldValue(-5, this._organizationId)); 
/* 284 */     if (this._retailLocationId != null) values.put("RetailLocationId", DaoUtils.getXmlSafeFieldValue(-5, this._retailLocationId)); 
/* 285 */     if (this._documentId != null) values.put("DocumentId", DaoUtils.getXmlSafeFieldValue(12, this._documentId)); 
/* 286 */     if (this._documentTypeCode != null) values.put("DocumentTypeCode", DaoUtils.getXmlSafeFieldValue(12, this._documentTypeCode)); 
/* 287 */     if (this._inventoryDocumentLineNumber != null) values.put("InventoryDocumentLineNumber", DaoUtils.getXmlSafeFieldValue(4, this._inventoryDocumentLineNumber)); 
/* 288 */     if (this._noteId != null) values.put("NoteId", DaoUtils.getXmlSafeFieldValue(-5, this._noteId)); 
/* 289 */     if (this._createDate != null) values.put("CreateDate", DaoUtils.getXmlSafeFieldValue(91, this._createDate)); 
/* 290 */     if (this._createUserId != null) values.put("CreateUserId", DaoUtils.getXmlSafeFieldValue(12, this._createUserId)); 
/* 291 */     if (this._updateDate != null) values.put("UpdateDate", DaoUtils.getXmlSafeFieldValue(91, this._updateDate)); 
/* 292 */     if (this._updateUserId != null) values.put("UpdateUserId", DaoUtils.getXmlSafeFieldValue(12, this._updateUserId)); 
/* 293 */     if (this._noteDatetimestamp != null) values.put("NoteDatetimestamp", DaoUtils.getXmlSafeFieldValue(91, this._noteDatetimestamp)); 
/* 294 */     if (this._note != null) values.put("Note", DaoUtils.getXmlSafeFieldValue(2005, this._note)); 
/* 295 */     if (this._creatorPartyId != null) values.put("CreatorPartyId", DaoUtils.getXmlSafeFieldValue(-5, this._creatorPartyId)); 
/* 296 */     if (this._noteType != null) values.put("NoteType", DaoUtils.getXmlSafeFieldValue(12, this._noteType)); 
/* 297 */     if (this._recordCreationType != null) values.put("RecordCreationType", DaoUtils.getXmlSafeFieldValue(12, this._recordCreationType)); 
/* 298 */     return values;
/*     */   }
/*     */ 
/*     */   
/*     */   public void setValues(Map<String, String> argValues) {
/* 303 */     super.setValues(argValues);
/* 304 */     for (Map.Entry<String, String> field : argValues.entrySet()) {
/*     */       
/* 306 */       String fieldName = field.getKey();
/* 307 */       String fieldValue = field.getValue();
/* 308 */       switch (fieldName) {
/*     */         
/*     */         case "OrganizationId":
/*     */           try {
/* 312 */             Object value = DaoUtils.getFieldValueForXmlString(-5, fieldValue);
/* 313 */             setOrganizationId((Long)value);
/* 314 */           } catch (Exception ee) {
/* 315 */             throw new DtxException("An exception occurred while calling setOrganizationId() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "RetailLocationId":
/*     */           try {
/* 321 */             Object value = DaoUtils.getFieldValueForXmlString(-5, fieldValue);
/* 322 */             setRetailLocationId((Long)value);
/* 323 */           } catch (Exception ee) {
/* 324 */             throw new DtxException("An exception occurred while calling setRetailLocationId() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "DocumentId":
/*     */           try {
/* 330 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 331 */             setDocumentId((String)value);
/* 332 */           } catch (Exception ee) {
/* 333 */             throw new DtxException("An exception occurred while calling setDocumentId() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "DocumentTypeCode":
/*     */           try {
/* 339 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 340 */             setDocumentTypeCode((String)value);
/* 341 */           } catch (Exception ee) {
/* 342 */             throw new DtxException("An exception occurred while calling setDocumentTypeCode() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "InventoryDocumentLineNumber":
/*     */           try {
/* 348 */             Object value = DaoUtils.getFieldValueForXmlString(4, fieldValue);
/* 349 */             setInventoryDocumentLineNumber((Integer)value);
/* 350 */           } catch (Exception ee) {
/* 351 */             throw new DtxException("An exception occurred while calling setInventoryDocumentLineNumber() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "NoteId":
/*     */           try {
/* 357 */             Object value = DaoUtils.getFieldValueForXmlString(-5, fieldValue);
/* 358 */             setNoteId((Long)value);
/* 359 */           } catch (Exception ee) {
/* 360 */             throw new DtxException("An exception occurred while calling setNoteId() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "CreateDate":
/*     */           try {
/* 366 */             Object value = DaoUtils.getFieldValueForXmlString(91, fieldValue);
/* 367 */             setCreateDate((Date)value);
/* 368 */           } catch (Exception ee) {
/* 369 */             throw new DtxException("An exception occurred while calling setCreateDate() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "CreateUserId":
/*     */           try {
/* 375 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 376 */             setCreateUserId((String)value);
/* 377 */           } catch (Exception ee) {
/* 378 */             throw new DtxException("An exception occurred while calling setCreateUserId() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "UpdateDate":
/*     */           try {
/* 384 */             Object value = DaoUtils.getFieldValueForXmlString(91, fieldValue);
/* 385 */             setUpdateDate((Date)value);
/* 386 */           } catch (Exception ee) {
/* 387 */             throw new DtxException("An exception occurred while calling setUpdateDate() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "UpdateUserId":
/*     */           try {
/* 393 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 394 */             setUpdateUserId((String)value);
/* 395 */           } catch (Exception ee) {
/* 396 */             throw new DtxException("An exception occurred while calling setUpdateUserId() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "NoteDatetimestamp":
/*     */           try {
/* 402 */             Object value = DaoUtils.getFieldValueForXmlString(91, fieldValue);
/* 403 */             setNoteDatetimestamp((Date)value);
/* 404 */           } catch (Exception ee) {
/* 405 */             throw new DtxException("An exception occurred while calling setNoteDatetimestamp() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "Note":
/*     */           try {
/* 411 */             Object value = DaoUtils.getFieldValueForXmlString(2005, fieldValue);
/* 412 */             setNote((String)value);
/* 413 */           } catch (Exception ee) {
/* 414 */             throw new DtxException("An exception occurred while calling setNote() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "CreatorPartyId":
/*     */           try {
/* 420 */             Object value = DaoUtils.getFieldValueForXmlString(-5, fieldValue);
/* 421 */             setCreatorPartyId((Long)value);
/* 422 */           } catch (Exception ee) {
/* 423 */             throw new DtxException("An exception occurred while calling setCreatorPartyId() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "NoteType":
/*     */           try {
/* 429 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 430 */             setNoteType((String)value);
/* 431 */           } catch (Exception ee) {
/* 432 */             throw new DtxException("An exception occurred while calling setNoteType() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "RecordCreationType":
/*     */           try {
/* 438 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 439 */             setRecordCreationType((String)value);
/* 440 */           } catch (Exception ee) {
/* 441 */             throw new DtxException("An exception occurred while calling setRecordCreationType() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */       } 
/*     */     } 
/*     */   }
/*     */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\inv\impl\DocumentLineItemNoteDAO.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */