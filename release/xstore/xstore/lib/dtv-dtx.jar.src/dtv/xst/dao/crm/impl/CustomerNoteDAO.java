/*     */ package dtv.xst.dao.crm.impl;
/*     */ 
/*     */ import dtv.data2.access.DaoUtils;
/*     */ import dtv.data2.access.IObjectId;
/*     */ import dtv.data2.access.exception.DtxException;
/*     */ import dtv.data2.access.impl.AbstractDAOImpl;
/*     */ import dtv.util.DtvDate;
/*     */ import dtv.xst.dao.crm.CustomerNoteId;
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
/*     */ public class CustomerNoteDAO
/*     */   extends AbstractDAOImpl
/*     */ {
/*     */   private static final long serialVersionUID = 1064491280L;
/*  23 */   private static final Logger _logger = Logger.getLogger(CustomerNoteDAO.class);
/*     */   
/*     */   private Long _organizationId;
/*     */   private Long _partyId;
/*     */   private Long _noteSequence;
/*     */   private DtvDate _createDate;
/*     */   private String _createUserId;
/*     */   private DtvDate _updateDate;
/*     */   private String _updateUserId;
/*     */   private String _creatorId;
/*     */   private String _note;
/*     */   private DtvDate _noteTimeStamp;
/*     */   
/*     */   public Long getOrganizationId() {
/*  37 */     return this._organizationId;
/*     */   }
/*     */   
/*     */   public void setOrganizationId(Long argOrganizationId) {
/*  41 */     if (changed(argOrganizationId, this._organizationId, "organizationId")) {
/*  42 */       this._organizationId = argOrganizationId;
/*     */     }
/*     */   }
/*     */   
/*     */   public Long getPartyId() {
/*  47 */     return this._partyId;
/*     */   }
/*     */   
/*     */   public void setPartyId(Long argPartyId) {
/*  51 */     if (changed(argPartyId, this._partyId, "partyId")) {
/*  52 */       this._partyId = argPartyId;
/*     */     }
/*     */   }
/*     */   
/*     */   public Long getNoteSequence() {
/*  57 */     return this._noteSequence;
/*     */   }
/*     */   
/*     */   public void setNoteSequence(Long argNoteSequence) {
/*  61 */     if (changed(argNoteSequence, this._noteSequence, "noteSequence")) {
/*  62 */       this._noteSequence = argNoteSequence;
/*     */     }
/*     */   }
/*     */   
/*     */   public Date getCreateDate() {
/*  67 */     return (Date)this._createDate;
/*     */   }
/*     */   
/*     */   public void setCreateDate(Date argCreateDate) {
/*  71 */     if (changed(argCreateDate, this._createDate, "createDate")) {
/*  72 */       this._createDate = (argCreateDate == null || argCreateDate instanceof DtvDate) ? (DtvDate)argCreateDate : new DtvDate(argCreateDate);
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public String getCreateUserId() {
/*  78 */     return this._createUserId;
/*     */   }
/*     */   
/*     */   public void setCreateUserId(String argCreateUserId) {
/*  82 */     if (changed(argCreateUserId, this._createUserId, "createUserId")) {
/*  83 */       this._createUserId = argCreateUserId;
/*     */     }
/*     */   }
/*     */   
/*     */   public Date getUpdateDate() {
/*  88 */     return (Date)this._updateDate;
/*     */   }
/*     */   
/*     */   public void setUpdateDate(Date argUpdateDate) {
/*  92 */     if (changed(argUpdateDate, this._updateDate, "updateDate")) {
/*  93 */       this._updateDate = (argUpdateDate == null || argUpdateDate instanceof DtvDate) ? (DtvDate)argUpdateDate : new DtvDate(argUpdateDate);
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public String getUpdateUserId() {
/*  99 */     return this._updateUserId;
/*     */   }
/*     */   
/*     */   public void setUpdateUserId(String argUpdateUserId) {
/* 103 */     if (changed(argUpdateUserId, this._updateUserId, "updateUserId")) {
/* 104 */       this._updateUserId = argUpdateUserId;
/*     */     }
/*     */   }
/*     */   
/*     */   public String getCreatorId() {
/* 109 */     return this._creatorId;
/*     */   }
/*     */   
/*     */   public void setCreatorId(String argCreatorId) {
/* 113 */     if (changed(argCreatorId, this._creatorId, "creatorId")) {
/* 114 */       this._creatorId = argCreatorId;
/*     */     }
/*     */   }
/*     */   
/*     */   public String getNote() {
/* 119 */     return this._note;
/*     */   }
/*     */   
/*     */   public void setNote(String argNote) {
/* 123 */     if (changed(argNote, this._note, "note")) {
/* 124 */       this._note = argNote;
/*     */     }
/*     */   }
/*     */   
/*     */   public Date getNoteTimeStamp() {
/* 129 */     return (Date)this._noteTimeStamp;
/*     */   }
/*     */   
/*     */   public void setNoteTimeStamp(Date argNoteTimeStamp) {
/* 133 */     if (changed(argNoteTimeStamp, this._noteTimeStamp, "noteTimeStamp")) {
/* 134 */       this._noteTimeStamp = (argNoteTimeStamp == null || argNoteTimeStamp instanceof DtvDate) ? (DtvDate)argNoteTimeStamp : new DtvDate(argNoteTimeStamp);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String toString() {
/* 142 */     StringBuilder buf = new StringBuilder(512);
/* 143 */     buf.append(super.toString()).append(" Id: ").append(getObjectId()).append(" Values: ");
/* 144 */     if (getOrganizationId() != null) {
/* 145 */       buf.append("organizationId").append("=").append(getOrganizationId()).append(" ");
/*     */     }
/* 147 */     if (getPartyId() != null) {
/* 148 */       buf.append("partyId").append("=").append(getPartyId()).append(" ");
/*     */     }
/* 150 */     if (getNoteSequence() != null) {
/* 151 */       buf.append("noteSequence").append("=").append(getNoteSequence()).append(" ");
/*     */     }
/* 153 */     if (getCreateDate() != null) {
/* 154 */       buf.append("createDate").append("=").append(getCreateDate()).append(" ");
/*     */     }
/* 156 */     if (getCreateUserId() != null) {
/* 157 */       buf.append("createUserId").append("=").append(getCreateUserId()).append(" ");
/*     */     }
/* 159 */     if (getUpdateDate() != null) {
/* 160 */       buf.append("updateDate").append("=").append(getUpdateDate()).append(" ");
/*     */     }
/* 162 */     if (getUpdateUserId() != null) {
/* 163 */       buf.append("updateUserId").append("=").append(getUpdateUserId()).append(" ");
/*     */     }
/* 165 */     if (getCreatorId() != null) {
/* 166 */       buf.append("creatorId").append("=").append(getCreatorId()).append(" ");
/*     */     }
/* 168 */     if (getNote() != null) {
/* 169 */       buf.append("note").append("=").append(getNote()).append(" ");
/*     */     }
/* 171 */     if (getNoteTimeStamp() != null) {
/* 172 */       buf.append("noteTimeStamp").append("=").append(getNoteTimeStamp()).append(" ");
/*     */     }
/*     */     
/* 175 */     return buf.toString();
/*     */   }
/*     */   
/*     */   public IObjectId getObjectId() {
/* 179 */     CustomerNoteId id = new CustomerNoteId();
/* 180 */     id.setOrganizationId(getOrganizationId());
/* 181 */     id.setPartyId(getPartyId());
/* 182 */     id.setNoteSequence(getNoteSequence());
/* 183 */     return (IObjectId)id;
/*     */   }
/*     */   
/*     */   public void setObjectId(IObjectId argObjectId) {
/* 187 */     setOrganizationId(((CustomerNoteId)argObjectId).getOrganizationId());
/* 188 */     setPartyId(((CustomerNoteId)argObjectId).getPartyId());
/* 189 */     setNoteSequence(((CustomerNoteId)argObjectId).getNoteSequence());
/*     */   }
/*     */   
/*     */   public String getImplementingClass() {
/* 193 */     return null;
/*     */   }
/*     */   
/*     */   public String toXmlString() {
/* 197 */     StringBuilder buf = new StringBuilder(500);
/* 198 */     buf.append("<").append("dao").append(" name=\"CustomerNote\" cmd=\"" + getObjectStateString() + "\">");
/* 199 */     getFieldsAsXml(buf);
/* 200 */     buf.append("</").append("dao").append(">");
/*     */     
/* 202 */     return buf.toString();
/*     */   }
/*     */   
/*     */   public Map<String, String> getValues() {
/* 206 */     Map<String, String> values = super.getValues();
/* 207 */     if (this._organizationId != null) values.put("OrganizationId", DaoUtils.getXmlSafeFieldValue(-5, this._organizationId)); 
/* 208 */     if (this._partyId != null) values.put("PartyId", DaoUtils.getXmlSafeFieldValue(-5, this._partyId)); 
/* 209 */     if (this._noteSequence != null) values.put("NoteSequence", DaoUtils.getXmlSafeFieldValue(-5, this._noteSequence)); 
/* 210 */     if (this._createDate != null) values.put("CreateDate", DaoUtils.getXmlSafeFieldValue(91, this._createDate)); 
/* 211 */     if (this._createUserId != null) values.put("CreateUserId", DaoUtils.getXmlSafeFieldValue(12, this._createUserId)); 
/* 212 */     if (this._updateDate != null) values.put("UpdateDate", DaoUtils.getXmlSafeFieldValue(91, this._updateDate)); 
/* 213 */     if (this._updateUserId != null) values.put("UpdateUserId", DaoUtils.getXmlSafeFieldValue(12, this._updateUserId)); 
/* 214 */     if (this._creatorId != null) values.put("CreatorId", DaoUtils.getXmlSafeFieldValue(12, this._creatorId)); 
/* 215 */     if (this._note != null) values.put("Note", DaoUtils.getXmlSafeFieldValue(2005, this._note)); 
/* 216 */     if (this._noteTimeStamp != null) values.put("NoteTimeStamp", DaoUtils.getXmlSafeFieldValue(91, this._noteTimeStamp)); 
/* 217 */     return values;
/*     */   }
/*     */ 
/*     */   
/*     */   public void setValues(Map<String, String> argValues) {
/* 222 */     super.setValues(argValues);
/* 223 */     for (Map.Entry<String, String> field : argValues.entrySet()) {
/*     */       
/* 225 */       String fieldName = field.getKey();
/* 226 */       String fieldValue = field.getValue();
/* 227 */       switch (fieldName) {
/*     */         
/*     */         case "OrganizationId":
/*     */           try {
/* 231 */             Object value = DaoUtils.getFieldValueForXmlString(-5, fieldValue);
/* 232 */             setOrganizationId((Long)value);
/* 233 */           } catch (Exception ee) {
/* 234 */             throw new DtxException("An exception occurred while calling setOrganizationId() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "PartyId":
/*     */           try {
/* 240 */             Object value = DaoUtils.getFieldValueForXmlString(-5, fieldValue);
/* 241 */             setPartyId((Long)value);
/* 242 */           } catch (Exception ee) {
/* 243 */             throw new DtxException("An exception occurred while calling setPartyId() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "NoteSequence":
/*     */           try {
/* 249 */             Object value = DaoUtils.getFieldValueForXmlString(-5, fieldValue);
/* 250 */             setNoteSequence((Long)value);
/* 251 */           } catch (Exception ee) {
/* 252 */             throw new DtxException("An exception occurred while calling setNoteSequence() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "CreateDate":
/*     */           try {
/* 258 */             Object value = DaoUtils.getFieldValueForXmlString(91, fieldValue);
/* 259 */             setCreateDate((Date)value);
/* 260 */           } catch (Exception ee) {
/* 261 */             throw new DtxException("An exception occurred while calling setCreateDate() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "CreateUserId":
/*     */           try {
/* 267 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 268 */             setCreateUserId((String)value);
/* 269 */           } catch (Exception ee) {
/* 270 */             throw new DtxException("An exception occurred while calling setCreateUserId() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "UpdateDate":
/*     */           try {
/* 276 */             Object value = DaoUtils.getFieldValueForXmlString(91, fieldValue);
/* 277 */             setUpdateDate((Date)value);
/* 278 */           } catch (Exception ee) {
/* 279 */             throw new DtxException("An exception occurred while calling setUpdateDate() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "UpdateUserId":
/*     */           try {
/* 285 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 286 */             setUpdateUserId((String)value);
/* 287 */           } catch (Exception ee) {
/* 288 */             throw new DtxException("An exception occurred while calling setUpdateUserId() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "CreatorId":
/*     */           try {
/* 294 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 295 */             setCreatorId((String)value);
/* 296 */           } catch (Exception ee) {
/* 297 */             throw new DtxException("An exception occurred while calling setCreatorId() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "Note":
/*     */           try {
/* 303 */             Object value = DaoUtils.getFieldValueForXmlString(2005, fieldValue);
/* 304 */             setNote((String)value);
/* 305 */           } catch (Exception ee) {
/* 306 */             throw new DtxException("An exception occurred while calling setNote() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "NoteTimeStamp":
/*     */           try {
/* 312 */             Object value = DaoUtils.getFieldValueForXmlString(91, fieldValue);
/* 313 */             setNoteTimeStamp((Date)value);
/* 314 */           } catch (Exception ee) {
/* 315 */             throw new DtxException("An exception occurred while calling setNoteTimeStamp() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */       } 
/*     */     } 
/*     */   }
/*     */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\crm\impl\CustomerNoteDAO.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */