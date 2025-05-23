/*     */ package dtv.xst.dao.hrs.impl;
/*     */ 
/*     */ import dtv.data2.access.DaoUtils;
/*     */ import dtv.data2.access.IObjectId;
/*     */ import dtv.data2.access.exception.DtxException;
/*     */ import dtv.data2.access.impl.AbstractDAOImpl;
/*     */ import dtv.util.DtvDate;
/*     */ import dtv.xst.dao.hrs.EmployeeTaskNoteId;
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
/*     */ public class EmployeeTaskNoteDAO
/*     */   extends AbstractDAOImpl
/*     */ {
/*     */   private static final long serialVersionUID = 9048069L;
/*  23 */   private static final Logger _logger = Logger.getLogger(EmployeeTaskNoteDAO.class);
/*     */   
/*     */   private Long _organizationId;
/*     */   private Long _retailLocationId;
/*     */   private Long _taskId;
/*     */   private Long _noteSequence;
/*     */   private DtvDate _createDate;
/*     */   private String _createUserId;
/*     */   private DtvDate _updateDate;
/*     */   private String _updateUserId;
/*     */   private String _note;
/*     */   private DtvDate _noteTimeStamp;
/*     */   private Long _creatorPartyId;
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
/*     */   public Long getRetailLocationId() {
/*  48 */     return this._retailLocationId;
/*     */   }
/*     */   
/*     */   public void setRetailLocationId(Long argRetailLocationId) {
/*  52 */     if (changed(argRetailLocationId, this._retailLocationId, "retailLocationId")) {
/*  53 */       this._retailLocationId = argRetailLocationId;
/*     */     }
/*     */   }
/*     */   
/*     */   public Long getTaskId() {
/*  58 */     return this._taskId;
/*     */   }
/*     */   
/*     */   public void setTaskId(Long argTaskId) {
/*  62 */     if (changed(argTaskId, this._taskId, "taskId")) {
/*  63 */       this._taskId = argTaskId;
/*     */     }
/*     */   }
/*     */   
/*     */   public Long getNoteSequence() {
/*  68 */     return this._noteSequence;
/*     */   }
/*     */   
/*     */   public void setNoteSequence(Long argNoteSequence) {
/*  72 */     if (changed(argNoteSequence, this._noteSequence, "noteSequence")) {
/*  73 */       this._noteSequence = argNoteSequence;
/*     */     }
/*     */   }
/*     */   
/*     */   public Date getCreateDate() {
/*  78 */     return (Date)this._createDate;
/*     */   }
/*     */   
/*     */   public void setCreateDate(Date argCreateDate) {
/*  82 */     if (changed(argCreateDate, this._createDate, "createDate")) {
/*  83 */       this._createDate = (argCreateDate == null || argCreateDate instanceof DtvDate) ? (DtvDate)argCreateDate : new DtvDate(argCreateDate);
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public String getCreateUserId() {
/*  89 */     return this._createUserId;
/*     */   }
/*     */   
/*     */   public void setCreateUserId(String argCreateUserId) {
/*  93 */     if (changed(argCreateUserId, this._createUserId, "createUserId")) {
/*  94 */       this._createUserId = argCreateUserId;
/*     */     }
/*     */   }
/*     */   
/*     */   public Date getUpdateDate() {
/*  99 */     return (Date)this._updateDate;
/*     */   }
/*     */   
/*     */   public void setUpdateDate(Date argUpdateDate) {
/* 103 */     if (changed(argUpdateDate, this._updateDate, "updateDate")) {
/* 104 */       this._updateDate = (argUpdateDate == null || argUpdateDate instanceof DtvDate) ? (DtvDate)argUpdateDate : new DtvDate(argUpdateDate);
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public String getUpdateUserId() {
/* 110 */     return this._updateUserId;
/*     */   }
/*     */   
/*     */   public void setUpdateUserId(String argUpdateUserId) {
/* 114 */     if (changed(argUpdateUserId, this._updateUserId, "updateUserId")) {
/* 115 */       this._updateUserId = argUpdateUserId;
/*     */     }
/*     */   }
/*     */   
/*     */   public String getNote() {
/* 120 */     return this._note;
/*     */   }
/*     */   
/*     */   public void setNote(String argNote) {
/* 124 */     if (changed(argNote, this._note, "note")) {
/* 125 */       this._note = argNote;
/*     */     }
/*     */   }
/*     */   
/*     */   public Date getNoteTimeStamp() {
/* 130 */     return (Date)this._noteTimeStamp;
/*     */   }
/*     */   
/*     */   public void setNoteTimeStamp(Date argNoteTimeStamp) {
/* 134 */     if (changed(argNoteTimeStamp, this._noteTimeStamp, "noteTimeStamp")) {
/* 135 */       this._noteTimeStamp = (argNoteTimeStamp == null || argNoteTimeStamp instanceof DtvDate) ? (DtvDate)argNoteTimeStamp : new DtvDate(argNoteTimeStamp);
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public Long getCreatorPartyId() {
/* 141 */     return this._creatorPartyId;
/*     */   }
/*     */   
/*     */   public void setCreatorPartyId(Long argCreatorPartyId) {
/* 145 */     if (changed(argCreatorPartyId, this._creatorPartyId, "creatorPartyId")) {
/* 146 */       this._creatorPartyId = argCreatorPartyId;
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public String toString() {
/* 153 */     StringBuilder buf = new StringBuilder(512);
/* 154 */     buf.append(super.toString()).append(" Id: ").append(getObjectId()).append(" Values: ");
/* 155 */     if (getOrganizationId() != null) {
/* 156 */       buf.append("organizationId").append("=").append(getOrganizationId()).append(" ");
/*     */     }
/* 158 */     if (getRetailLocationId() != null) {
/* 159 */       buf.append("retailLocationId").append("=").append(getRetailLocationId()).append(" ");
/*     */     }
/* 161 */     if (getTaskId() != null) {
/* 162 */       buf.append("taskId").append("=").append(getTaskId()).append(" ");
/*     */     }
/* 164 */     if (getNoteSequence() != null) {
/* 165 */       buf.append("noteSequence").append("=").append(getNoteSequence()).append(" ");
/*     */     }
/* 167 */     if (getCreateDate() != null) {
/* 168 */       buf.append("createDate").append("=").append(getCreateDate()).append(" ");
/*     */     }
/* 170 */     if (getCreateUserId() != null) {
/* 171 */       buf.append("createUserId").append("=").append(getCreateUserId()).append(" ");
/*     */     }
/* 173 */     if (getUpdateDate() != null) {
/* 174 */       buf.append("updateDate").append("=").append(getUpdateDate()).append(" ");
/*     */     }
/* 176 */     if (getUpdateUserId() != null) {
/* 177 */       buf.append("updateUserId").append("=").append(getUpdateUserId()).append(" ");
/*     */     }
/* 179 */     if (getNote() != null) {
/* 180 */       buf.append("note").append("=").append(getNote()).append(" ");
/*     */     }
/* 182 */     if (getNoteTimeStamp() != null) {
/* 183 */       buf.append("noteTimeStamp").append("=").append(getNoteTimeStamp()).append(" ");
/*     */     }
/* 185 */     if (getCreatorPartyId() != null) {
/* 186 */       buf.append("creatorPartyId").append("=").append(getCreatorPartyId()).append(" ");
/*     */     }
/*     */     
/* 189 */     return buf.toString();
/*     */   }
/*     */   
/*     */   public IObjectId getObjectId() {
/* 193 */     EmployeeTaskNoteId id = new EmployeeTaskNoteId();
/* 194 */     id.setOrganizationId(getOrganizationId());
/* 195 */     id.setRetailLocationId(getRetailLocationId());
/* 196 */     id.setTaskId(getTaskId());
/* 197 */     id.setNoteSequence(getNoteSequence());
/* 198 */     return (IObjectId)id;
/*     */   }
/*     */   
/*     */   public void setObjectId(IObjectId argObjectId) {
/* 202 */     setOrganizationId(((EmployeeTaskNoteId)argObjectId).getOrganizationId());
/* 203 */     setRetailLocationId(((EmployeeTaskNoteId)argObjectId).getRetailLocationId());
/* 204 */     setTaskId(((EmployeeTaskNoteId)argObjectId).getTaskId());
/* 205 */     setNoteSequence(((EmployeeTaskNoteId)argObjectId).getNoteSequence());
/*     */   }
/*     */   
/*     */   public String getImplementingClass() {
/* 209 */     return null;
/*     */   }
/*     */   
/*     */   public String toXmlString() {
/* 213 */     StringBuilder buf = new StringBuilder(550);
/* 214 */     buf.append("<").append("dao").append(" name=\"EmployeeTaskNote\" cmd=\"" + getObjectStateString() + "\">");
/* 215 */     getFieldsAsXml(buf);
/* 216 */     buf.append("</").append("dao").append(">");
/*     */     
/* 218 */     return buf.toString();
/*     */   }
/*     */   
/*     */   public Map<String, String> getValues() {
/* 222 */     Map<String, String> values = super.getValues();
/* 223 */     if (this._organizationId != null) values.put("OrganizationId", DaoUtils.getXmlSafeFieldValue(-5, this._organizationId)); 
/* 224 */     if (this._retailLocationId != null) values.put("RetailLocationId", DaoUtils.getXmlSafeFieldValue(-5, this._retailLocationId)); 
/* 225 */     if (this._taskId != null) values.put("TaskId", DaoUtils.getXmlSafeFieldValue(-5, this._taskId)); 
/* 226 */     if (this._noteSequence != null) values.put("NoteSequence", DaoUtils.getXmlSafeFieldValue(-5, this._noteSequence)); 
/* 227 */     if (this._createDate != null) values.put("CreateDate", DaoUtils.getXmlSafeFieldValue(91, this._createDate)); 
/* 228 */     if (this._createUserId != null) values.put("CreateUserId", DaoUtils.getXmlSafeFieldValue(12, this._createUserId)); 
/* 229 */     if (this._updateDate != null) values.put("UpdateDate", DaoUtils.getXmlSafeFieldValue(91, this._updateDate)); 
/* 230 */     if (this._updateUserId != null) values.put("UpdateUserId", DaoUtils.getXmlSafeFieldValue(12, this._updateUserId)); 
/* 231 */     if (this._note != null) values.put("Note", DaoUtils.getXmlSafeFieldValue(2005, this._note)); 
/* 232 */     if (this._noteTimeStamp != null) values.put("NoteTimeStamp", DaoUtils.getXmlSafeFieldValue(91, this._noteTimeStamp)); 
/* 233 */     if (this._creatorPartyId != null) values.put("CreatorPartyId", DaoUtils.getXmlSafeFieldValue(-5, this._creatorPartyId)); 
/* 234 */     return values;
/*     */   }
/*     */ 
/*     */   
/*     */   public void setValues(Map<String, String> argValues) {
/* 239 */     super.setValues(argValues);
/* 240 */     for (Map.Entry<String, String> field : argValues.entrySet()) {
/*     */       
/* 242 */       String fieldName = field.getKey();
/* 243 */       String fieldValue = field.getValue();
/* 244 */       switch (fieldName) {
/*     */         
/*     */         case "OrganizationId":
/*     */           try {
/* 248 */             Object value = DaoUtils.getFieldValueForXmlString(-5, fieldValue);
/* 249 */             setOrganizationId((Long)value);
/* 250 */           } catch (Exception ee) {
/* 251 */             throw new DtxException("An exception occurred while calling setOrganizationId() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "RetailLocationId":
/*     */           try {
/* 257 */             Object value = DaoUtils.getFieldValueForXmlString(-5, fieldValue);
/* 258 */             setRetailLocationId((Long)value);
/* 259 */           } catch (Exception ee) {
/* 260 */             throw new DtxException("An exception occurred while calling setRetailLocationId() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "TaskId":
/*     */           try {
/* 266 */             Object value = DaoUtils.getFieldValueForXmlString(-5, fieldValue);
/* 267 */             setTaskId((Long)value);
/* 268 */           } catch (Exception ee) {
/* 269 */             throw new DtxException("An exception occurred while calling setTaskId() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "NoteSequence":
/*     */           try {
/* 275 */             Object value = DaoUtils.getFieldValueForXmlString(-5, fieldValue);
/* 276 */             setNoteSequence((Long)value);
/* 277 */           } catch (Exception ee) {
/* 278 */             throw new DtxException("An exception occurred while calling setNoteSequence() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "CreateDate":
/*     */           try {
/* 284 */             Object value = DaoUtils.getFieldValueForXmlString(91, fieldValue);
/* 285 */             setCreateDate((Date)value);
/* 286 */           } catch (Exception ee) {
/* 287 */             throw new DtxException("An exception occurred while calling setCreateDate() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "CreateUserId":
/*     */           try {
/* 293 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 294 */             setCreateUserId((String)value);
/* 295 */           } catch (Exception ee) {
/* 296 */             throw new DtxException("An exception occurred while calling setCreateUserId() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "UpdateDate":
/*     */           try {
/* 302 */             Object value = DaoUtils.getFieldValueForXmlString(91, fieldValue);
/* 303 */             setUpdateDate((Date)value);
/* 304 */           } catch (Exception ee) {
/* 305 */             throw new DtxException("An exception occurred while calling setUpdateDate() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "UpdateUserId":
/*     */           try {
/* 311 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 312 */             setUpdateUserId((String)value);
/* 313 */           } catch (Exception ee) {
/* 314 */             throw new DtxException("An exception occurred while calling setUpdateUserId() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "Note":
/*     */           try {
/* 320 */             Object value = DaoUtils.getFieldValueForXmlString(2005, fieldValue);
/* 321 */             setNote((String)value);
/* 322 */           } catch (Exception ee) {
/* 323 */             throw new DtxException("An exception occurred while calling setNote() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "NoteTimeStamp":
/*     */           try {
/* 329 */             Object value = DaoUtils.getFieldValueForXmlString(91, fieldValue);
/* 330 */             setNoteTimeStamp((Date)value);
/* 331 */           } catch (Exception ee) {
/* 332 */             throw new DtxException("An exception occurred while calling setNoteTimeStamp() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "CreatorPartyId":
/*     */           try {
/* 338 */             Object value = DaoUtils.getFieldValueForXmlString(-5, fieldValue);
/* 339 */             setCreatorPartyId((Long)value);
/* 340 */           } catch (Exception ee) {
/* 341 */             throw new DtxException("An exception occurred while calling setCreatorPartyId() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */       } 
/*     */     } 
/*     */   }
/*     */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\hrs\impl\EmployeeTaskNoteDAO.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */