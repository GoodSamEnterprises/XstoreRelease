/*     */ package dtv.xst.dao.trl.impl;
/*     */ 
/*     */ import dtv.data2.access.DaoUtils;
/*     */ import dtv.data2.access.IObjectId;
/*     */ import dtv.data2.access.exception.DtxException;
/*     */ import dtv.data2.access.impl.AbstractDAOImpl;
/*     */ import dtv.util.DtvDate;
/*     */ import dtv.xst.dao.trl.RetailTransactionLineItemNotesId;
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
/*     */ public class RetailTransactionLineItemNotesDAO
/*     */   extends AbstractDAOImpl
/*     */ {
/*     */   private static final long serialVersionUID = 1536161759L;
/*  23 */   private static final Logger _logger = Logger.getLogger(RetailTransactionLineItemNotesDAO.class);
/*     */   
/*     */   private DtvDate _businessDate;
/*     */   private Long _organizationId;
/*     */   private Long _retailLocationId;
/*     */   private Integer _retailTransactionLineItemSequence;
/*     */   private Long _transactionSequence;
/*     */   private Long _workstationId;
/*     */   private Long _noteSeq;
/*     */   private DtvDate _createDate;
/*     */   private String _createUserId;
/*     */   private DtvDate _updateDate;
/*     */   private String _updateUserId;
/*     */   private String _note;
/*     */   private DtvDate _noteDatetimestamp;
/*  38 */   private Boolean _posted = Boolean.FALSE;
/*     */   
/*     */   public Date getBusinessDate() {
/*  41 */     return (Date)this._businessDate;
/*     */   }
/*     */   
/*     */   public void setBusinessDate(Date argBusinessDate) {
/*  45 */     if (changed(argBusinessDate, this._businessDate, "businessDate")) {
/*  46 */       this._businessDate = (argBusinessDate == null || argBusinessDate instanceof DtvDate) ? (DtvDate)argBusinessDate : new DtvDate(argBusinessDate);
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public Long getOrganizationId() {
/*  52 */     return this._organizationId;
/*     */   }
/*     */   
/*     */   public void setOrganizationId(Long argOrganizationId) {
/*  56 */     if (changed(argOrganizationId, this._organizationId, "organizationId")) {
/*  57 */       this._organizationId = argOrganizationId;
/*     */     }
/*     */   }
/*     */   
/*     */   public Long getRetailLocationId() {
/*  62 */     return this._retailLocationId;
/*     */   }
/*     */   
/*     */   public void setRetailLocationId(Long argRetailLocationId) {
/*  66 */     if (changed(argRetailLocationId, this._retailLocationId, "retailLocationId")) {
/*  67 */       this._retailLocationId = argRetailLocationId;
/*     */     }
/*     */   }
/*     */   
/*     */   public Integer getRetailTransactionLineItemSequence() {
/*  72 */     return this._retailTransactionLineItemSequence;
/*     */   }
/*     */   
/*     */   public void setRetailTransactionLineItemSequence(Integer argRetailTransactionLineItemSequence) {
/*  76 */     if (changed(argRetailTransactionLineItemSequence, this._retailTransactionLineItemSequence, "retailTransactionLineItemSequence")) {
/*  77 */       this._retailTransactionLineItemSequence = argRetailTransactionLineItemSequence;
/*     */     }
/*     */   }
/*     */   
/*     */   public Long getTransactionSequence() {
/*  82 */     return this._transactionSequence;
/*     */   }
/*     */   
/*     */   public void setTransactionSequence(Long argTransactionSequence) {
/*  86 */     if (changed(argTransactionSequence, this._transactionSequence, "transactionSequence")) {
/*  87 */       this._transactionSequence = argTransactionSequence;
/*     */     }
/*     */   }
/*     */   
/*     */   public Long getWorkstationId() {
/*  92 */     return this._workstationId;
/*     */   }
/*     */   
/*     */   public void setWorkstationId(Long argWorkstationId) {
/*  96 */     if (changed(argWorkstationId, this._workstationId, "workstationId")) {
/*  97 */       this._workstationId = argWorkstationId;
/*     */     }
/*     */   }
/*     */   
/*     */   public Long getNoteSeq() {
/* 102 */     return this._noteSeq;
/*     */   }
/*     */   
/*     */   public void setNoteSeq(Long argNoteSeq) {
/* 106 */     if (changed(argNoteSeq, this._noteSeq, "noteSeq")) {
/* 107 */       this._noteSeq = argNoteSeq;
/*     */     }
/*     */   }
/*     */   
/*     */   public Date getCreateDate() {
/* 112 */     return (Date)this._createDate;
/*     */   }
/*     */   
/*     */   public void setCreateDate(Date argCreateDate) {
/* 116 */     if (changed(argCreateDate, this._createDate, "createDate")) {
/* 117 */       this._createDate = (argCreateDate == null || argCreateDate instanceof DtvDate) ? (DtvDate)argCreateDate : new DtvDate(argCreateDate);
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public String getCreateUserId() {
/* 123 */     return this._createUserId;
/*     */   }
/*     */   
/*     */   public void setCreateUserId(String argCreateUserId) {
/* 127 */     if (changed(argCreateUserId, this._createUserId, "createUserId")) {
/* 128 */       this._createUserId = argCreateUserId;
/*     */     }
/*     */   }
/*     */   
/*     */   public Date getUpdateDate() {
/* 133 */     return (Date)this._updateDate;
/*     */   }
/*     */   
/*     */   public void setUpdateDate(Date argUpdateDate) {
/* 137 */     if (changed(argUpdateDate, this._updateDate, "updateDate")) {
/* 138 */       this._updateDate = (argUpdateDate == null || argUpdateDate instanceof DtvDate) ? (DtvDate)argUpdateDate : new DtvDate(argUpdateDate);
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public String getUpdateUserId() {
/* 144 */     return this._updateUserId;
/*     */   }
/*     */   
/*     */   public void setUpdateUserId(String argUpdateUserId) {
/* 148 */     if (changed(argUpdateUserId, this._updateUserId, "updateUserId")) {
/* 149 */       this._updateUserId = argUpdateUserId;
/*     */     }
/*     */   }
/*     */   
/*     */   public String getNote() {
/* 154 */     return this._note;
/*     */   }
/*     */   
/*     */   public void setNote(String argNote) {
/* 158 */     if (changed(argNote, this._note, "note")) {
/* 159 */       this._note = argNote;
/*     */     }
/*     */   }
/*     */   
/*     */   public Date getNoteDatetimestamp() {
/* 164 */     return (Date)this._noteDatetimestamp;
/*     */   }
/*     */   
/*     */   public void setNoteDatetimestamp(Date argNoteDatetimestamp) {
/* 168 */     if (changed(argNoteDatetimestamp, this._noteDatetimestamp, "noteDatetimestamp")) {
/* 169 */       this._noteDatetimestamp = (argNoteDatetimestamp == null || argNoteDatetimestamp instanceof DtvDate) ? (DtvDate)argNoteDatetimestamp : new DtvDate(argNoteDatetimestamp);
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public Boolean getPosted() {
/* 175 */     return this._posted;
/*     */   }
/*     */   
/*     */   public void setPosted(Boolean argPosted) {
/* 179 */     if (changed(argPosted, this._posted, "posted")) {
/* 180 */       this._posted = argPosted;
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public String toString() {
/* 187 */     StringBuilder buf = new StringBuilder(512);
/* 188 */     buf.append(super.toString()).append(" Id: ").append(getObjectId()).append(" Values: ");
/* 189 */     if (getBusinessDate() != null) {
/* 190 */       buf.append("businessDate").append("=").append(getBusinessDate()).append(" ");
/*     */     }
/* 192 */     if (getOrganizationId() != null) {
/* 193 */       buf.append("organizationId").append("=").append(getOrganizationId()).append(" ");
/*     */     }
/* 195 */     if (getRetailLocationId() != null) {
/* 196 */       buf.append("retailLocationId").append("=").append(getRetailLocationId()).append(" ");
/*     */     }
/* 198 */     if (getRetailTransactionLineItemSequence() != null) {
/* 199 */       buf.append("retailTransactionLineItemSequence").append("=").append(getRetailTransactionLineItemSequence()).append(" ");
/*     */     }
/* 201 */     if (getTransactionSequence() != null) {
/* 202 */       buf.append("transactionSequence").append("=").append(getTransactionSequence()).append(" ");
/*     */     }
/* 204 */     if (getWorkstationId() != null) {
/* 205 */       buf.append("workstationId").append("=").append(getWorkstationId()).append(" ");
/*     */     }
/* 207 */     if (getNoteSeq() != null) {
/* 208 */       buf.append("noteSeq").append("=").append(getNoteSeq()).append(" ");
/*     */     }
/* 210 */     if (getCreateDate() != null) {
/* 211 */       buf.append("createDate").append("=").append(getCreateDate()).append(" ");
/*     */     }
/* 213 */     if (getCreateUserId() != null) {
/* 214 */       buf.append("createUserId").append("=").append(getCreateUserId()).append(" ");
/*     */     }
/* 216 */     if (getUpdateDate() != null) {
/* 217 */       buf.append("updateDate").append("=").append(getUpdateDate()).append(" ");
/*     */     }
/* 219 */     if (getUpdateUserId() != null) {
/* 220 */       buf.append("updateUserId").append("=").append(getUpdateUserId()).append(" ");
/*     */     }
/* 222 */     if (getNote() != null) {
/* 223 */       buf.append("note").append("=").append(getNote()).append(" ");
/*     */     }
/* 225 */     if (getNoteDatetimestamp() != null) {
/* 226 */       buf.append("noteDatetimestamp").append("=").append(getNoteDatetimestamp()).append(" ");
/*     */     }
/* 228 */     if (getPosted() != null && getPosted().booleanValue()) {
/* 229 */       buf.append("posted").append("=").append(getPosted()).append(" ");
/*     */     }
/*     */     
/* 232 */     return buf.toString();
/*     */   }
/*     */   
/*     */   public IObjectId getObjectId() {
/* 236 */     RetailTransactionLineItemNotesId id = new RetailTransactionLineItemNotesId();
/* 237 */     id.setBusinessDate(getBusinessDate());
/* 238 */     id.setOrganizationId(getOrganizationId());
/* 239 */     id.setRetailLocationId(getRetailLocationId());
/* 240 */     id.setRetailTransactionLineItemSequence(getRetailTransactionLineItemSequence());
/* 241 */     id.setTransactionSequence(getTransactionSequence());
/* 242 */     id.setWorkstationId(getWorkstationId());
/* 243 */     id.setNoteSeq(getNoteSeq());
/* 244 */     return (IObjectId)id;
/*     */   }
/*     */   
/*     */   public void setObjectId(IObjectId argObjectId) {
/* 248 */     setBusinessDate(((RetailTransactionLineItemNotesId)argObjectId).getBusinessDate());
/* 249 */     setOrganizationId(((RetailTransactionLineItemNotesId)argObjectId).getOrganizationId());
/* 250 */     setRetailLocationId(((RetailTransactionLineItemNotesId)argObjectId).getRetailLocationId());
/* 251 */     setRetailTransactionLineItemSequence(((RetailTransactionLineItemNotesId)argObjectId).getRetailTransactionLineItemSequence());
/* 252 */     setTransactionSequence(((RetailTransactionLineItemNotesId)argObjectId).getTransactionSequence());
/* 253 */     setWorkstationId(((RetailTransactionLineItemNotesId)argObjectId).getWorkstationId());
/* 254 */     setNoteSeq(((RetailTransactionLineItemNotesId)argObjectId).getNoteSeq());
/*     */   }
/*     */   
/*     */   public String getImplementingClass() {
/* 258 */     return null;
/*     */   }
/*     */   
/*     */   public String toXmlString() {
/* 262 */     StringBuilder buf = new StringBuilder(700);
/* 263 */     buf.append("<").append("dao").append(" name=\"RetailTransactionLineItemNotes\" cmd=\"" + getObjectStateString() + "\">");
/* 264 */     getFieldsAsXml(buf);
/* 265 */     buf.append("</").append("dao").append(">");
/*     */     
/* 267 */     return buf.toString();
/*     */   }
/*     */   
/*     */   public Map<String, String> getValues() {
/* 271 */     Map<String, String> values = super.getValues();
/* 272 */     if (this._businessDate != null) values.put("BusinessDate", DaoUtils.getXmlSafeFieldValue(91, this._businessDate)); 
/* 273 */     if (this._organizationId != null) values.put("OrganizationId", DaoUtils.getXmlSafeFieldValue(-5, this._organizationId)); 
/* 274 */     if (this._retailLocationId != null) values.put("RetailLocationId", DaoUtils.getXmlSafeFieldValue(-5, this._retailLocationId)); 
/* 275 */     if (this._retailTransactionLineItemSequence != null) values.put("RetailTransactionLineItemSequence", DaoUtils.getXmlSafeFieldValue(4, this._retailTransactionLineItemSequence)); 
/* 276 */     if (this._transactionSequence != null) values.put("TransactionSequence", DaoUtils.getXmlSafeFieldValue(-5, this._transactionSequence)); 
/* 277 */     if (this._workstationId != null) values.put("WorkstationId", DaoUtils.getXmlSafeFieldValue(-5, this._workstationId)); 
/* 278 */     if (this._noteSeq != null) values.put("NoteSeq", DaoUtils.getXmlSafeFieldValue(-5, this._noteSeq)); 
/* 279 */     if (this._createDate != null) values.put("CreateDate", DaoUtils.getXmlSafeFieldValue(91, this._createDate)); 
/* 280 */     if (this._createUserId != null) values.put("CreateUserId", DaoUtils.getXmlSafeFieldValue(12, this._createUserId)); 
/* 281 */     if (this._updateDate != null) values.put("UpdateDate", DaoUtils.getXmlSafeFieldValue(91, this._updateDate)); 
/* 282 */     if (this._updateUserId != null) values.put("UpdateUserId", DaoUtils.getXmlSafeFieldValue(12, this._updateUserId)); 
/* 283 */     if (this._note != null) values.put("Note", DaoUtils.getXmlSafeFieldValue(2005, this._note)); 
/* 284 */     if (this._noteDatetimestamp != null) values.put("NoteDatetimestamp", DaoUtils.getXmlSafeFieldValue(91, this._noteDatetimestamp)); 
/* 285 */     if (this._posted != null) values.put("Posted", DaoUtils.getXmlSafeFieldValue(-7, this._posted)); 
/* 286 */     return values;
/*     */   }
/*     */ 
/*     */   
/*     */   public void setValues(Map<String, String> argValues) {
/* 291 */     super.setValues(argValues);
/* 292 */     for (Map.Entry<String, String> field : argValues.entrySet()) {
/*     */       
/* 294 */       String fieldName = field.getKey();
/* 295 */       String fieldValue = field.getValue();
/* 296 */       switch (fieldName) {
/*     */         
/*     */         case "BusinessDate":
/*     */           try {
/* 300 */             Object value = DaoUtils.getFieldValueForXmlString(91, fieldValue);
/* 301 */             setBusinessDate((Date)value);
/* 302 */           } catch (Exception ee) {
/* 303 */             throw new DtxException("An exception occurred while calling setBusinessDate() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "OrganizationId":
/*     */           try {
/* 309 */             Object value = DaoUtils.getFieldValueForXmlString(-5, fieldValue);
/* 310 */             setOrganizationId((Long)value);
/* 311 */           } catch (Exception ee) {
/* 312 */             throw new DtxException("An exception occurred while calling setOrganizationId() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "RetailLocationId":
/*     */           try {
/* 318 */             Object value = DaoUtils.getFieldValueForXmlString(-5, fieldValue);
/* 319 */             setRetailLocationId((Long)value);
/* 320 */           } catch (Exception ee) {
/* 321 */             throw new DtxException("An exception occurred while calling setRetailLocationId() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "RetailTransactionLineItemSequence":
/*     */           try {
/* 327 */             Object value = DaoUtils.getFieldValueForXmlString(4, fieldValue);
/* 328 */             setRetailTransactionLineItemSequence((Integer)value);
/* 329 */           } catch (Exception ee) {
/* 330 */             throw new DtxException("An exception occurred while calling setRetailTransactionLineItemSequence() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "TransactionSequence":
/*     */           try {
/* 336 */             Object value = DaoUtils.getFieldValueForXmlString(-5, fieldValue);
/* 337 */             setTransactionSequence((Long)value);
/* 338 */           } catch (Exception ee) {
/* 339 */             throw new DtxException("An exception occurred while calling setTransactionSequence() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "WorkstationId":
/*     */           try {
/* 345 */             Object value = DaoUtils.getFieldValueForXmlString(-5, fieldValue);
/* 346 */             setWorkstationId((Long)value);
/* 347 */           } catch (Exception ee) {
/* 348 */             throw new DtxException("An exception occurred while calling setWorkstationId() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "NoteSeq":
/*     */           try {
/* 354 */             Object value = DaoUtils.getFieldValueForXmlString(-5, fieldValue);
/* 355 */             setNoteSeq((Long)value);
/* 356 */           } catch (Exception ee) {
/* 357 */             throw new DtxException("An exception occurred while calling setNoteSeq() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "CreateDate":
/*     */           try {
/* 363 */             Object value = DaoUtils.getFieldValueForXmlString(91, fieldValue);
/* 364 */             setCreateDate((Date)value);
/* 365 */           } catch (Exception ee) {
/* 366 */             throw new DtxException("An exception occurred while calling setCreateDate() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "CreateUserId":
/*     */           try {
/* 372 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 373 */             setCreateUserId((String)value);
/* 374 */           } catch (Exception ee) {
/* 375 */             throw new DtxException("An exception occurred while calling setCreateUserId() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "UpdateDate":
/*     */           try {
/* 381 */             Object value = DaoUtils.getFieldValueForXmlString(91, fieldValue);
/* 382 */             setUpdateDate((Date)value);
/* 383 */           } catch (Exception ee) {
/* 384 */             throw new DtxException("An exception occurred while calling setUpdateDate() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "UpdateUserId":
/*     */           try {
/* 390 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 391 */             setUpdateUserId((String)value);
/* 392 */           } catch (Exception ee) {
/* 393 */             throw new DtxException("An exception occurred while calling setUpdateUserId() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "Note":
/*     */           try {
/* 399 */             Object value = DaoUtils.getFieldValueForXmlString(2005, fieldValue);
/* 400 */             setNote((String)value);
/* 401 */           } catch (Exception ee) {
/* 402 */             throw new DtxException("An exception occurred while calling setNote() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "NoteDatetimestamp":
/*     */           try {
/* 408 */             Object value = DaoUtils.getFieldValueForXmlString(91, fieldValue);
/* 409 */             setNoteDatetimestamp((Date)value);
/* 410 */           } catch (Exception ee) {
/* 411 */             throw new DtxException("An exception occurred while calling setNoteDatetimestamp() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "Posted":
/*     */           try {
/* 417 */             Object value = DaoUtils.getFieldValueForXmlString(-7, fieldValue);
/* 418 */             setPosted((Boolean)value);
/* 419 */           } catch (Exception ee) {
/* 420 */             throw new DtxException("An exception occurred while calling setPosted() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */       } 
/*     */     } 
/*     */   }
/*     */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\trl\impl\RetailTransactionLineItemNotesDAO.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */