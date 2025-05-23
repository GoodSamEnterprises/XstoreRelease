/*     */ package dtv.xst.dao.cat.impl;
/*     */ 
/*     */ import dtv.data2.access.DaoUtils;
/*     */ import dtv.data2.access.IObjectId;
/*     */ import dtv.data2.access.exception.DtxException;
/*     */ import dtv.data2.access.impl.AbstractDAOImpl;
/*     */ import dtv.util.DtvDate;
/*     */ import dtv.xst.dao.cat.CustomerAccountNoteId;
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
/*     */ public class CustomerAccountNoteDAO
/*     */   extends AbstractDAOImpl
/*     */ {
/*     */   private static final long serialVersionUID = 1544669409L;
/*  23 */   private static final Logger _logger = Logger.getLogger(CustomerAccountNoteDAO.class);
/*     */   
/*     */   private Long _noteSequence;
/*     */   private Long _organizationId;
/*     */   private String _custAccountId;
/*     */   private String _custAccountCode;
/*     */   private DtvDate _createDate;
/*     */   private String _createUserId;
/*     */   private DtvDate _updateDate;
/*     */   private String _updateUserId;
/*     */   private DtvDate _entryTimestamp;
/*     */   private Long _entryPartyId;
/*     */   private String _note;
/*     */   
/*     */   public Long getNoteSequence() {
/*  38 */     return this._noteSequence;
/*     */   }
/*     */   
/*     */   public void setNoteSequence(Long argNoteSequence) {
/*  42 */     if (changed(argNoteSequence, this._noteSequence, "noteSequence")) {
/*  43 */       this._noteSequence = argNoteSequence;
/*     */     }
/*     */   }
/*     */   
/*     */   public Long getOrganizationId() {
/*  48 */     return this._organizationId;
/*     */   }
/*     */   
/*     */   public void setOrganizationId(Long argOrganizationId) {
/*  52 */     if (changed(argOrganizationId, this._organizationId, "organizationId")) {
/*  53 */       this._organizationId = argOrganizationId;
/*     */     }
/*     */   }
/*     */   
/*     */   public String getCustAccountId() {
/*  58 */     return this._custAccountId;
/*     */   }
/*     */   
/*     */   public void setCustAccountId(String argCustAccountId) {
/*  62 */     if (changed(argCustAccountId, this._custAccountId, "custAccountId")) {
/*  63 */       this._custAccountId = (argCustAccountId != null && MANAGE_CASE) ? argCustAccountId.toUpperCase() : argCustAccountId;
/*     */     }
/*     */   }
/*     */   
/*     */   public String getCustAccountCode() {
/*  68 */     return this._custAccountCode;
/*     */   }
/*     */   
/*     */   public void setCustAccountCode(String argCustAccountCode) {
/*  72 */     if (changed(argCustAccountCode, this._custAccountCode, "custAccountCode")) {
/*  73 */       this._custAccountCode = (argCustAccountCode != null && MANAGE_CASE) ? argCustAccountCode.toUpperCase() : argCustAccountCode;
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
/*     */   public Date getEntryTimestamp() {
/* 120 */     return (Date)this._entryTimestamp;
/*     */   }
/*     */   
/*     */   public void setEntryTimestamp(Date argEntryTimestamp) {
/* 124 */     if (changed(argEntryTimestamp, this._entryTimestamp, "entryTimestamp")) {
/* 125 */       this._entryTimestamp = (argEntryTimestamp == null || argEntryTimestamp instanceof DtvDate) ? (DtvDate)argEntryTimestamp : new DtvDate(argEntryTimestamp);
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public Long getEntryPartyId() {
/* 131 */     return this._entryPartyId;
/*     */   }
/*     */   
/*     */   public void setEntryPartyId(Long argEntryPartyId) {
/* 135 */     if (changed(argEntryPartyId, this._entryPartyId, "entryPartyId")) {
/* 136 */       this._entryPartyId = argEntryPartyId;
/*     */     }
/*     */   }
/*     */   
/*     */   public String getNote() {
/* 141 */     return this._note;
/*     */   }
/*     */   
/*     */   public void setNote(String argNote) {
/* 145 */     if (changed(argNote, this._note, "note")) {
/* 146 */       this._note = argNote;
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public String toString() {
/* 153 */     StringBuilder buf = new StringBuilder(512);
/* 154 */     buf.append(super.toString()).append(" Id: ").append(getObjectId()).append(" Values: ");
/* 155 */     if (getNoteSequence() != null) {
/* 156 */       buf.append("noteSequence").append("=").append(getNoteSequence()).append(" ");
/*     */     }
/* 158 */     if (getOrganizationId() != null) {
/* 159 */       buf.append("organizationId").append("=").append(getOrganizationId()).append(" ");
/*     */     }
/* 161 */     if (getCustAccountId() != null) {
/* 162 */       buf.append("custAccountId").append("=").append(getCustAccountId()).append(" ");
/*     */     }
/* 164 */     if (getCustAccountCode() != null) {
/* 165 */       buf.append("custAccountCode").append("=").append(getCustAccountCode()).append(" ");
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
/* 179 */     if (getEntryTimestamp() != null) {
/* 180 */       buf.append("entryTimestamp").append("=").append(getEntryTimestamp()).append(" ");
/*     */     }
/* 182 */     if (getEntryPartyId() != null) {
/* 183 */       buf.append("entryPartyId").append("=").append(getEntryPartyId()).append(" ");
/*     */     }
/* 185 */     if (getNote() != null) {
/* 186 */       buf.append("note").append("=").append(getNote()).append(" ");
/*     */     }
/*     */     
/* 189 */     return buf.toString();
/*     */   }
/*     */   
/*     */   public IObjectId getObjectId() {
/* 193 */     CustomerAccountNoteId id = new CustomerAccountNoteId();
/* 194 */     id.setNoteSequence(getNoteSequence());
/* 195 */     id.setOrganizationId(getOrganizationId());
/* 196 */     id.setCustAccountId(getCustAccountId());
/* 197 */     id.setCustAccountCode(getCustAccountCode());
/* 198 */     return (IObjectId)id;
/*     */   }
/*     */   
/*     */   public void setObjectId(IObjectId argObjectId) {
/* 202 */     setNoteSequence(((CustomerAccountNoteId)argObjectId).getNoteSequence());
/* 203 */     setOrganizationId(((CustomerAccountNoteId)argObjectId).getOrganizationId());
/* 204 */     setCustAccountId(((CustomerAccountNoteId)argObjectId).getCustAccountId());
/* 205 */     setCustAccountCode(((CustomerAccountNoteId)argObjectId).getCustAccountCode());
/*     */   }
/*     */   
/*     */   public String getImplementingClass() {
/* 209 */     return null;
/*     */   }
/*     */   
/*     */   public String toXmlString() {
/* 213 */     StringBuilder buf = new StringBuilder(550);
/* 214 */     buf.append("<").append("dao").append(" name=\"CustomerAccountNote\" cmd=\"" + getObjectStateString() + "\">");
/* 215 */     getFieldsAsXml(buf);
/* 216 */     buf.append("</").append("dao").append(">");
/*     */     
/* 218 */     return buf.toString();
/*     */   }
/*     */   
/*     */   public Map<String, String> getValues() {
/* 222 */     Map<String, String> values = super.getValues();
/* 223 */     if (this._noteSequence != null) values.put("NoteSequence", DaoUtils.getXmlSafeFieldValue(-5, this._noteSequence)); 
/* 224 */     if (this._organizationId != null) values.put("OrganizationId", DaoUtils.getXmlSafeFieldValue(-5, this._organizationId)); 
/* 225 */     if (this._custAccountId != null) values.put("CustAccountId", DaoUtils.getXmlSafeFieldValue(12, this._custAccountId)); 
/* 226 */     if (this._custAccountCode != null) values.put("CustAccountCode", DaoUtils.getXmlSafeFieldValue(12, this._custAccountCode)); 
/* 227 */     if (this._createDate != null) values.put("CreateDate", DaoUtils.getXmlSafeFieldValue(91, this._createDate)); 
/* 228 */     if (this._createUserId != null) values.put("CreateUserId", DaoUtils.getXmlSafeFieldValue(12, this._createUserId)); 
/* 229 */     if (this._updateDate != null) values.put("UpdateDate", DaoUtils.getXmlSafeFieldValue(91, this._updateDate)); 
/* 230 */     if (this._updateUserId != null) values.put("UpdateUserId", DaoUtils.getXmlSafeFieldValue(12, this._updateUserId)); 
/* 231 */     if (this._entryTimestamp != null) values.put("EntryTimestamp", DaoUtils.getXmlSafeFieldValue(91, this._entryTimestamp)); 
/* 232 */     if (this._entryPartyId != null) values.put("EntryPartyId", DaoUtils.getXmlSafeFieldValue(-5, this._entryPartyId)); 
/* 233 */     if (this._note != null) values.put("Note", DaoUtils.getXmlSafeFieldValue(2005, this._note)); 
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
/*     */         case "NoteSequence":
/*     */           try {
/* 248 */             Object value = DaoUtils.getFieldValueForXmlString(-5, fieldValue);
/* 249 */             setNoteSequence((Long)value);
/* 250 */           } catch (Exception ee) {
/* 251 */             throw new DtxException("An exception occurred while calling setNoteSequence() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "OrganizationId":
/*     */           try {
/* 257 */             Object value = DaoUtils.getFieldValueForXmlString(-5, fieldValue);
/* 258 */             setOrganizationId((Long)value);
/* 259 */           } catch (Exception ee) {
/* 260 */             throw new DtxException("An exception occurred while calling setOrganizationId() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "CustAccountId":
/*     */           try {
/* 266 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 267 */             setCustAccountId((String)value);
/* 268 */           } catch (Exception ee) {
/* 269 */             throw new DtxException("An exception occurred while calling setCustAccountId() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "CustAccountCode":
/*     */           try {
/* 275 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 276 */             setCustAccountCode((String)value);
/* 277 */           } catch (Exception ee) {
/* 278 */             throw new DtxException("An exception occurred while calling setCustAccountCode() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
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
/*     */         case "EntryTimestamp":
/*     */           try {
/* 320 */             Object value = DaoUtils.getFieldValueForXmlString(91, fieldValue);
/* 321 */             setEntryTimestamp((Date)value);
/* 322 */           } catch (Exception ee) {
/* 323 */             throw new DtxException("An exception occurred while calling setEntryTimestamp() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "EntryPartyId":
/*     */           try {
/* 329 */             Object value = DaoUtils.getFieldValueForXmlString(-5, fieldValue);
/* 330 */             setEntryPartyId((Long)value);
/* 331 */           } catch (Exception ee) {
/* 332 */             throw new DtxException("An exception occurred while calling setEntryPartyId() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "Note":
/*     */           try {
/* 338 */             Object value = DaoUtils.getFieldValueForXmlString(2005, fieldValue);
/* 339 */             setNote((String)value);
/* 340 */           } catch (Exception ee) {
/* 341 */             throw new DtxException("An exception occurred while calling setNote() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */       } 
/*     */     } 
/*     */   }
/*     */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\cat\impl\CustomerAccountNoteDAO.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */