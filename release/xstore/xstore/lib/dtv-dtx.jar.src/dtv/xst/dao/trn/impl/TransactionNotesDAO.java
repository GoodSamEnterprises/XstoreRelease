/*     */ package dtv.xst.dao.trn.impl;
/*     */ 
/*     */ import dtv.data2.access.DaoUtils;
/*     */ import dtv.data2.access.IObjectId;
/*     */ import dtv.data2.access.exception.DtxException;
/*     */ import dtv.data2.access.impl.AbstractDAOImpl;
/*     */ import dtv.util.DtvDate;
/*     */ import dtv.xst.dao.trn.TransactionNotesId;
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
/*     */ public class TransactionNotesDAO
/*     */   extends AbstractDAOImpl
/*     */ {
/*     */   private static final long serialVersionUID = -349574493L;
/*  23 */   private static final Logger _logger = Logger.getLogger(TransactionNotesDAO.class);
/*     */   
/*     */   private DtvDate _businessDate;
/*     */   private Integer _noteSequence;
/*     */   private Long _organizationId;
/*     */   private Long _retailLocationId;
/*     */   private Long _transactionSequence;
/*     */   private Long _workstationId;
/*     */   private DtvDate _createDate;
/*     */   private String _createUserId;
/*     */   private DtvDate _updateDate;
/*     */   private String _updateUserId;
/*     */   private String _note;
/*     */   private DtvDate _noteDatetimestamp;
/*  37 */   private Boolean _posted = Boolean.FALSE;
/*     */   
/*     */   public Date getBusinessDate() {
/*  40 */     return (Date)this._businessDate;
/*     */   }
/*     */   
/*     */   public void setBusinessDate(Date argBusinessDate) {
/*  44 */     if (changed(argBusinessDate, this._businessDate, "businessDate")) {
/*  45 */       this._businessDate = (argBusinessDate == null || argBusinessDate instanceof DtvDate) ? (DtvDate)argBusinessDate : new DtvDate(argBusinessDate);
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public Integer getNoteSequence() {
/*  51 */     return this._noteSequence;
/*     */   }
/*     */   
/*     */   public void setNoteSequence(Integer argNoteSequence) {
/*  55 */     if (changed(argNoteSequence, this._noteSequence, "noteSequence")) {
/*  56 */       this._noteSequence = argNoteSequence;
/*     */     }
/*     */   }
/*     */   
/*     */   public Long getOrganizationId() {
/*  61 */     return this._organizationId;
/*     */   }
/*     */   
/*     */   public void setOrganizationId(Long argOrganizationId) {
/*  65 */     if (changed(argOrganizationId, this._organizationId, "organizationId")) {
/*  66 */       this._organizationId = argOrganizationId;
/*     */     }
/*     */   }
/*     */   
/*     */   public Long getRetailLocationId() {
/*  71 */     return this._retailLocationId;
/*     */   }
/*     */   
/*     */   public void setRetailLocationId(Long argRetailLocationId) {
/*  75 */     if (changed(argRetailLocationId, this._retailLocationId, "retailLocationId")) {
/*  76 */       this._retailLocationId = argRetailLocationId;
/*     */     }
/*     */   }
/*     */   
/*     */   public Long getTransactionSequence() {
/*  81 */     return this._transactionSequence;
/*     */   }
/*     */   
/*     */   public void setTransactionSequence(Long argTransactionSequence) {
/*  85 */     if (changed(argTransactionSequence, this._transactionSequence, "transactionSequence")) {
/*  86 */       this._transactionSequence = argTransactionSequence;
/*     */     }
/*     */   }
/*     */   
/*     */   public Long getWorkstationId() {
/*  91 */     return this._workstationId;
/*     */   }
/*     */   
/*     */   public void setWorkstationId(Long argWorkstationId) {
/*  95 */     if (changed(argWorkstationId, this._workstationId, "workstationId")) {
/*  96 */       this._workstationId = argWorkstationId;
/*     */     }
/*     */   }
/*     */   
/*     */   public Date getCreateDate() {
/* 101 */     return (Date)this._createDate;
/*     */   }
/*     */   
/*     */   public void setCreateDate(Date argCreateDate) {
/* 105 */     if (changed(argCreateDate, this._createDate, "createDate")) {
/* 106 */       this._createDate = (argCreateDate == null || argCreateDate instanceof DtvDate) ? (DtvDate)argCreateDate : new DtvDate(argCreateDate);
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public String getCreateUserId() {
/* 112 */     return this._createUserId;
/*     */   }
/*     */   
/*     */   public void setCreateUserId(String argCreateUserId) {
/* 116 */     if (changed(argCreateUserId, this._createUserId, "createUserId")) {
/* 117 */       this._createUserId = argCreateUserId;
/*     */     }
/*     */   }
/*     */   
/*     */   public Date getUpdateDate() {
/* 122 */     return (Date)this._updateDate;
/*     */   }
/*     */   
/*     */   public void setUpdateDate(Date argUpdateDate) {
/* 126 */     if (changed(argUpdateDate, this._updateDate, "updateDate")) {
/* 127 */       this._updateDate = (argUpdateDate == null || argUpdateDate instanceof DtvDate) ? (DtvDate)argUpdateDate : new DtvDate(argUpdateDate);
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public String getUpdateUserId() {
/* 133 */     return this._updateUserId;
/*     */   }
/*     */   
/*     */   public void setUpdateUserId(String argUpdateUserId) {
/* 137 */     if (changed(argUpdateUserId, this._updateUserId, "updateUserId")) {
/* 138 */       this._updateUserId = argUpdateUserId;
/*     */     }
/*     */   }
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
/*     */   public Date getNoteDatetimestamp() {
/* 153 */     return (Date)this._noteDatetimestamp;
/*     */   }
/*     */   
/*     */   public void setNoteDatetimestamp(Date argNoteDatetimestamp) {
/* 157 */     if (changed(argNoteDatetimestamp, this._noteDatetimestamp, "noteDatetimestamp")) {
/* 158 */       this._noteDatetimestamp = (argNoteDatetimestamp == null || argNoteDatetimestamp instanceof DtvDate) ? (DtvDate)argNoteDatetimestamp : new DtvDate(argNoteDatetimestamp);
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public Boolean getPosted() {
/* 164 */     return this._posted;
/*     */   }
/*     */   
/*     */   public void setPosted(Boolean argPosted) {
/* 168 */     if (changed(argPosted, this._posted, "posted")) {
/* 169 */       this._posted = argPosted;
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public String toString() {
/* 176 */     StringBuilder buf = new StringBuilder(512);
/* 177 */     buf.append(super.toString()).append(" Id: ").append(getObjectId()).append(" Values: ");
/* 178 */     if (getBusinessDate() != null) {
/* 179 */       buf.append("businessDate").append("=").append(getBusinessDate()).append(" ");
/*     */     }
/* 181 */     if (getNoteSequence() != null) {
/* 182 */       buf.append("noteSequence").append("=").append(getNoteSequence()).append(" ");
/*     */     }
/* 184 */     if (getOrganizationId() != null) {
/* 185 */       buf.append("organizationId").append("=").append(getOrganizationId()).append(" ");
/*     */     }
/* 187 */     if (getRetailLocationId() != null) {
/* 188 */       buf.append("retailLocationId").append("=").append(getRetailLocationId()).append(" ");
/*     */     }
/* 190 */     if (getTransactionSequence() != null) {
/* 191 */       buf.append("transactionSequence").append("=").append(getTransactionSequence()).append(" ");
/*     */     }
/* 193 */     if (getWorkstationId() != null) {
/* 194 */       buf.append("workstationId").append("=").append(getWorkstationId()).append(" ");
/*     */     }
/* 196 */     if (getCreateDate() != null) {
/* 197 */       buf.append("createDate").append("=").append(getCreateDate()).append(" ");
/*     */     }
/* 199 */     if (getCreateUserId() != null) {
/* 200 */       buf.append("createUserId").append("=").append(getCreateUserId()).append(" ");
/*     */     }
/* 202 */     if (getUpdateDate() != null) {
/* 203 */       buf.append("updateDate").append("=").append(getUpdateDate()).append(" ");
/*     */     }
/* 205 */     if (getUpdateUserId() != null) {
/* 206 */       buf.append("updateUserId").append("=").append(getUpdateUserId()).append(" ");
/*     */     }
/* 208 */     if (getNote() != null) {
/* 209 */       buf.append("note").append("=").append(getNote()).append(" ");
/*     */     }
/* 211 */     if (getNoteDatetimestamp() != null) {
/* 212 */       buf.append("noteDatetimestamp").append("=").append(getNoteDatetimestamp()).append(" ");
/*     */     }
/* 214 */     if (getPosted() != null && getPosted().booleanValue()) {
/* 215 */       buf.append("posted").append("=").append(getPosted()).append(" ");
/*     */     }
/*     */     
/* 218 */     return buf.toString();
/*     */   }
/*     */   
/*     */   public IObjectId getObjectId() {
/* 222 */     TransactionNotesId id = new TransactionNotesId();
/* 223 */     id.setBusinessDate(getBusinessDate());
/* 224 */     id.setNoteSequence(getNoteSequence());
/* 225 */     id.setOrganizationId(getOrganizationId());
/* 226 */     id.setRetailLocationId(getRetailLocationId());
/* 227 */     id.setTransactionSequence(getTransactionSequence());
/* 228 */     id.setWorkstationId(getWorkstationId());
/* 229 */     return (IObjectId)id;
/*     */   }
/*     */   
/*     */   public void setObjectId(IObjectId argObjectId) {
/* 233 */     setBusinessDate(((TransactionNotesId)argObjectId).getBusinessDate());
/* 234 */     setNoteSequence(((TransactionNotesId)argObjectId).getNoteSequence());
/* 235 */     setOrganizationId(((TransactionNotesId)argObjectId).getOrganizationId());
/* 236 */     setRetailLocationId(((TransactionNotesId)argObjectId).getRetailLocationId());
/* 237 */     setTransactionSequence(((TransactionNotesId)argObjectId).getTransactionSequence());
/* 238 */     setWorkstationId(((TransactionNotesId)argObjectId).getWorkstationId());
/*     */   }
/*     */   
/*     */   public String getImplementingClass() {
/* 242 */     return null;
/*     */   }
/*     */   
/*     */   public String toXmlString() {
/* 246 */     StringBuilder buf = new StringBuilder(650);
/* 247 */     buf.append("<").append("dao").append(" name=\"TransactionNotes\" cmd=\"" + getObjectStateString() + "\">");
/* 248 */     getFieldsAsXml(buf);
/* 249 */     buf.append("</").append("dao").append(">");
/*     */     
/* 251 */     return buf.toString();
/*     */   }
/*     */   
/*     */   public Map<String, String> getValues() {
/* 255 */     Map<String, String> values = super.getValues();
/* 256 */     if (this._businessDate != null) values.put("BusinessDate", DaoUtils.getXmlSafeFieldValue(91, this._businessDate)); 
/* 257 */     if (this._noteSequence != null) values.put("NoteSequence", DaoUtils.getXmlSafeFieldValue(4, this._noteSequence)); 
/* 258 */     if (this._organizationId != null) values.put("OrganizationId", DaoUtils.getXmlSafeFieldValue(-5, this._organizationId)); 
/* 259 */     if (this._retailLocationId != null) values.put("RetailLocationId", DaoUtils.getXmlSafeFieldValue(-5, this._retailLocationId)); 
/* 260 */     if (this._transactionSequence != null) values.put("TransactionSequence", DaoUtils.getXmlSafeFieldValue(-5, this._transactionSequence)); 
/* 261 */     if (this._workstationId != null) values.put("WorkstationId", DaoUtils.getXmlSafeFieldValue(-5, this._workstationId)); 
/* 262 */     if (this._createDate != null) values.put("CreateDate", DaoUtils.getXmlSafeFieldValue(91, this._createDate)); 
/* 263 */     if (this._createUserId != null) values.put("CreateUserId", DaoUtils.getXmlSafeFieldValue(12, this._createUserId)); 
/* 264 */     if (this._updateDate != null) values.put("UpdateDate", DaoUtils.getXmlSafeFieldValue(91, this._updateDate)); 
/* 265 */     if (this._updateUserId != null) values.put("UpdateUserId", DaoUtils.getXmlSafeFieldValue(12, this._updateUserId)); 
/* 266 */     if (this._note != null) values.put("Note", DaoUtils.getXmlSafeFieldValue(2005, this._note)); 
/* 267 */     if (this._noteDatetimestamp != null) values.put("NoteDatetimestamp", DaoUtils.getXmlSafeFieldValue(91, this._noteDatetimestamp)); 
/* 268 */     if (this._posted != null) values.put("Posted", DaoUtils.getXmlSafeFieldValue(-7, this._posted)); 
/* 269 */     return values;
/*     */   }
/*     */ 
/*     */   
/*     */   public void setValues(Map<String, String> argValues) {
/* 274 */     super.setValues(argValues);
/* 275 */     for (Map.Entry<String, String> field : argValues.entrySet()) {
/*     */       
/* 277 */       String fieldName = field.getKey();
/* 278 */       String fieldValue = field.getValue();
/* 279 */       switch (fieldName) {
/*     */         
/*     */         case "BusinessDate":
/*     */           try {
/* 283 */             Object value = DaoUtils.getFieldValueForXmlString(91, fieldValue);
/* 284 */             setBusinessDate((Date)value);
/* 285 */           } catch (Exception ee) {
/* 286 */             throw new DtxException("An exception occurred while calling setBusinessDate() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "NoteSequence":
/*     */           try {
/* 292 */             Object value = DaoUtils.getFieldValueForXmlString(4, fieldValue);
/* 293 */             setNoteSequence((Integer)value);
/* 294 */           } catch (Exception ee) {
/* 295 */             throw new DtxException("An exception occurred while calling setNoteSequence() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "OrganizationId":
/*     */           try {
/* 301 */             Object value = DaoUtils.getFieldValueForXmlString(-5, fieldValue);
/* 302 */             setOrganizationId((Long)value);
/* 303 */           } catch (Exception ee) {
/* 304 */             throw new DtxException("An exception occurred while calling setOrganizationId() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "RetailLocationId":
/*     */           try {
/* 310 */             Object value = DaoUtils.getFieldValueForXmlString(-5, fieldValue);
/* 311 */             setRetailLocationId((Long)value);
/* 312 */           } catch (Exception ee) {
/* 313 */             throw new DtxException("An exception occurred while calling setRetailLocationId() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "TransactionSequence":
/*     */           try {
/* 319 */             Object value = DaoUtils.getFieldValueForXmlString(-5, fieldValue);
/* 320 */             setTransactionSequence((Long)value);
/* 321 */           } catch (Exception ee) {
/* 322 */             throw new DtxException("An exception occurred while calling setTransactionSequence() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "WorkstationId":
/*     */           try {
/* 328 */             Object value = DaoUtils.getFieldValueForXmlString(-5, fieldValue);
/* 329 */             setWorkstationId((Long)value);
/* 330 */           } catch (Exception ee) {
/* 331 */             throw new DtxException("An exception occurred while calling setWorkstationId() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "CreateDate":
/*     */           try {
/* 337 */             Object value = DaoUtils.getFieldValueForXmlString(91, fieldValue);
/* 338 */             setCreateDate((Date)value);
/* 339 */           } catch (Exception ee) {
/* 340 */             throw new DtxException("An exception occurred while calling setCreateDate() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "CreateUserId":
/*     */           try {
/* 346 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 347 */             setCreateUserId((String)value);
/* 348 */           } catch (Exception ee) {
/* 349 */             throw new DtxException("An exception occurred while calling setCreateUserId() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "UpdateDate":
/*     */           try {
/* 355 */             Object value = DaoUtils.getFieldValueForXmlString(91, fieldValue);
/* 356 */             setUpdateDate((Date)value);
/* 357 */           } catch (Exception ee) {
/* 358 */             throw new DtxException("An exception occurred while calling setUpdateDate() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "UpdateUserId":
/*     */           try {
/* 364 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 365 */             setUpdateUserId((String)value);
/* 366 */           } catch (Exception ee) {
/* 367 */             throw new DtxException("An exception occurred while calling setUpdateUserId() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "Note":
/*     */           try {
/* 373 */             Object value = DaoUtils.getFieldValueForXmlString(2005, fieldValue);
/* 374 */             setNote((String)value);
/* 375 */           } catch (Exception ee) {
/* 376 */             throw new DtxException("An exception occurred while calling setNote() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "NoteDatetimestamp":
/*     */           try {
/* 382 */             Object value = DaoUtils.getFieldValueForXmlString(91, fieldValue);
/* 383 */             setNoteDatetimestamp((Date)value);
/* 384 */           } catch (Exception ee) {
/* 385 */             throw new DtxException("An exception occurred while calling setNoteDatetimestamp() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "Posted":
/*     */           try {
/* 391 */             Object value = DaoUtils.getFieldValueForXmlString(-7, fieldValue);
/* 392 */             setPosted((Boolean)value);
/* 393 */           } catch (Exception ee) {
/* 394 */             throw new DtxException("An exception occurred while calling setPosted() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */       } 
/*     */     } 
/*     */   }
/*     */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\trn\impl\TransactionNotesDAO.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */