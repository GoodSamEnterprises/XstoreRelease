/*     */ package dtv.xst.dao.thr.impl;
/*     */ 
/*     */ import dtv.data2.access.DaoUtils;
/*     */ import dtv.data2.access.IObjectId;
/*     */ import dtv.data2.access.exception.DtxException;
/*     */ import dtv.data2.access.impl.AbstractDAOImpl;
/*     */ import dtv.util.DtvDate;
/*     */ import dtv.xst.dao.thr.PayrollNotesId;
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
/*     */ public class PayrollNotesDAO
/*     */   extends AbstractDAOImpl
/*     */ {
/*     */   private static final long serialVersionUID = 1743357116L;
/*  23 */   private static final Logger _logger = Logger.getLogger(PayrollNotesDAO.class);
/*     */   
/*     */   private Long _organizationId;
/*     */   private Long _partyId;
/*     */   private DtvDate _weekEndingDate;
/*     */   private Long _noteSeq;
/*     */   private DtvDate _createDate;
/*     */   private String _createUserId;
/*     */   private DtvDate _updateDate;
/*     */   private String _updateUserId;
/*     */   private String _noteText;
/*     */   
/*     */   public Long getOrganizationId() {
/*  36 */     return this._organizationId;
/*     */   }
/*     */   
/*     */   public void setOrganizationId(Long argOrganizationId) {
/*  40 */     if (changed(argOrganizationId, this._organizationId, "organizationId")) {
/*  41 */       this._organizationId = argOrganizationId;
/*     */     }
/*     */   }
/*     */   
/*     */   public Long getPartyId() {
/*  46 */     return this._partyId;
/*     */   }
/*     */   
/*     */   public void setPartyId(Long argPartyId) {
/*  50 */     if (changed(argPartyId, this._partyId, "partyId")) {
/*  51 */       this._partyId = argPartyId;
/*     */     }
/*     */   }
/*     */   
/*     */   public Date getWeekEndingDate() {
/*  56 */     return (Date)this._weekEndingDate;
/*     */   }
/*     */   
/*     */   public void setWeekEndingDate(Date argWeekEndingDate) {
/*  60 */     if (changed(argWeekEndingDate, this._weekEndingDate, "weekEndingDate")) {
/*  61 */       this._weekEndingDate = (argWeekEndingDate == null || argWeekEndingDate instanceof DtvDate) ? (DtvDate)argWeekEndingDate : new DtvDate(argWeekEndingDate);
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public Long getNoteSeq() {
/*  67 */     return this._noteSeq;
/*     */   }
/*     */   
/*     */   public void setNoteSeq(Long argNoteSeq) {
/*  71 */     if (changed(argNoteSeq, this._noteSeq, "noteSeq")) {
/*  72 */       this._noteSeq = argNoteSeq;
/*     */     }
/*     */   }
/*     */   
/*     */   public Date getCreateDate() {
/*  77 */     return (Date)this._createDate;
/*     */   }
/*     */   
/*     */   public void setCreateDate(Date argCreateDate) {
/*  81 */     if (changed(argCreateDate, this._createDate, "createDate")) {
/*  82 */       this._createDate = (argCreateDate == null || argCreateDate instanceof DtvDate) ? (DtvDate)argCreateDate : new DtvDate(argCreateDate);
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public String getCreateUserId() {
/*  88 */     return this._createUserId;
/*     */   }
/*     */   
/*     */   public void setCreateUserId(String argCreateUserId) {
/*  92 */     if (changed(argCreateUserId, this._createUserId, "createUserId")) {
/*  93 */       this._createUserId = argCreateUserId;
/*     */     }
/*     */   }
/*     */   
/*     */   public Date getUpdateDate() {
/*  98 */     return (Date)this._updateDate;
/*     */   }
/*     */   
/*     */   public void setUpdateDate(Date argUpdateDate) {
/* 102 */     if (changed(argUpdateDate, this._updateDate, "updateDate")) {
/* 103 */       this._updateDate = (argUpdateDate == null || argUpdateDate instanceof DtvDate) ? (DtvDate)argUpdateDate : new DtvDate(argUpdateDate);
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public String getUpdateUserId() {
/* 109 */     return this._updateUserId;
/*     */   }
/*     */   
/*     */   public void setUpdateUserId(String argUpdateUserId) {
/* 113 */     if (changed(argUpdateUserId, this._updateUserId, "updateUserId")) {
/* 114 */       this._updateUserId = argUpdateUserId;
/*     */     }
/*     */   }
/*     */   
/*     */   public String getNoteText() {
/* 119 */     return this._noteText;
/*     */   }
/*     */   
/*     */   public void setNoteText(String argNoteText) {
/* 123 */     if (changed(argNoteText, this._noteText, "noteText")) {
/* 124 */       this._noteText = argNoteText;
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public String toString() {
/* 131 */     StringBuilder buf = new StringBuilder(512);
/* 132 */     buf.append(super.toString()).append(" Id: ").append(getObjectId()).append(" Values: ");
/* 133 */     if (getOrganizationId() != null) {
/* 134 */       buf.append("organizationId").append("=").append(getOrganizationId()).append(" ");
/*     */     }
/* 136 */     if (getPartyId() != null) {
/* 137 */       buf.append("partyId").append("=").append(getPartyId()).append(" ");
/*     */     }
/* 139 */     if (getWeekEndingDate() != null) {
/* 140 */       buf.append("weekEndingDate").append("=").append(getWeekEndingDate()).append(" ");
/*     */     }
/* 142 */     if (getNoteSeq() != null) {
/* 143 */       buf.append("noteSeq").append("=").append(getNoteSeq()).append(" ");
/*     */     }
/* 145 */     if (getCreateDate() != null) {
/* 146 */       buf.append("createDate").append("=").append(getCreateDate()).append(" ");
/*     */     }
/* 148 */     if (getCreateUserId() != null) {
/* 149 */       buf.append("createUserId").append("=").append(getCreateUserId()).append(" ");
/*     */     }
/* 151 */     if (getUpdateDate() != null) {
/* 152 */       buf.append("updateDate").append("=").append(getUpdateDate()).append(" ");
/*     */     }
/* 154 */     if (getUpdateUserId() != null) {
/* 155 */       buf.append("updateUserId").append("=").append(getUpdateUserId()).append(" ");
/*     */     }
/* 157 */     if (getNoteText() != null) {
/* 158 */       buf.append("noteText").append("=").append(getNoteText()).append(" ");
/*     */     }
/*     */     
/* 161 */     return buf.toString();
/*     */   }
/*     */   
/*     */   public IObjectId getObjectId() {
/* 165 */     PayrollNotesId id = new PayrollNotesId();
/* 166 */     id.setOrganizationId(getOrganizationId());
/* 167 */     id.setPartyId(getPartyId());
/* 168 */     id.setWeekEndingDate(getWeekEndingDate());
/* 169 */     id.setNoteSeq(getNoteSeq());
/* 170 */     return (IObjectId)id;
/*     */   }
/*     */   
/*     */   public void setObjectId(IObjectId argObjectId) {
/* 174 */     setOrganizationId(((PayrollNotesId)argObjectId).getOrganizationId());
/* 175 */     setPartyId(((PayrollNotesId)argObjectId).getPartyId());
/* 176 */     setWeekEndingDate(((PayrollNotesId)argObjectId).getWeekEndingDate());
/* 177 */     setNoteSeq(((PayrollNotesId)argObjectId).getNoteSeq());
/*     */   }
/*     */   
/*     */   public String getImplementingClass() {
/* 181 */     return null;
/*     */   }
/*     */   
/*     */   public String toXmlString() {
/* 185 */     StringBuilder buf = new StringBuilder(450);
/* 186 */     buf.append("<").append("dao").append(" name=\"PayrollNotes\" cmd=\"" + getObjectStateString() + "\">");
/* 187 */     getFieldsAsXml(buf);
/* 188 */     buf.append("</").append("dao").append(">");
/*     */     
/* 190 */     return buf.toString();
/*     */   }
/*     */   
/*     */   public Map<String, String> getValues() {
/* 194 */     Map<String, String> values = super.getValues();
/* 195 */     if (this._organizationId != null) values.put("OrganizationId", DaoUtils.getXmlSafeFieldValue(-5, this._organizationId)); 
/* 196 */     if (this._partyId != null) values.put("PartyId", DaoUtils.getXmlSafeFieldValue(-5, this._partyId)); 
/* 197 */     if (this._weekEndingDate != null) values.put("WeekEndingDate", DaoUtils.getXmlSafeFieldValue(91, this._weekEndingDate)); 
/* 198 */     if (this._noteSeq != null) values.put("NoteSeq", DaoUtils.getXmlSafeFieldValue(-5, this._noteSeq)); 
/* 199 */     if (this._createDate != null) values.put("CreateDate", DaoUtils.getXmlSafeFieldValue(91, this._createDate)); 
/* 200 */     if (this._createUserId != null) values.put("CreateUserId", DaoUtils.getXmlSafeFieldValue(12, this._createUserId)); 
/* 201 */     if (this._updateDate != null) values.put("UpdateDate", DaoUtils.getXmlSafeFieldValue(91, this._updateDate)); 
/* 202 */     if (this._updateUserId != null) values.put("UpdateUserId", DaoUtils.getXmlSafeFieldValue(12, this._updateUserId)); 
/* 203 */     if (this._noteText != null) values.put("NoteText", DaoUtils.getXmlSafeFieldValue(2005, this._noteText)); 
/* 204 */     return values;
/*     */   }
/*     */ 
/*     */   
/*     */   public void setValues(Map<String, String> argValues) {
/* 209 */     super.setValues(argValues);
/* 210 */     for (Map.Entry<String, String> field : argValues.entrySet()) {
/*     */       
/* 212 */       String fieldName = field.getKey();
/* 213 */       String fieldValue = field.getValue();
/* 214 */       switch (fieldName) {
/*     */         
/*     */         case "OrganizationId":
/*     */           try {
/* 218 */             Object value = DaoUtils.getFieldValueForXmlString(-5, fieldValue);
/* 219 */             setOrganizationId((Long)value);
/* 220 */           } catch (Exception ee) {
/* 221 */             throw new DtxException("An exception occurred while calling setOrganizationId() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "PartyId":
/*     */           try {
/* 227 */             Object value = DaoUtils.getFieldValueForXmlString(-5, fieldValue);
/* 228 */             setPartyId((Long)value);
/* 229 */           } catch (Exception ee) {
/* 230 */             throw new DtxException("An exception occurred while calling setPartyId() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "WeekEndingDate":
/*     */           try {
/* 236 */             Object value = DaoUtils.getFieldValueForXmlString(91, fieldValue);
/* 237 */             setWeekEndingDate((Date)value);
/* 238 */           } catch (Exception ee) {
/* 239 */             throw new DtxException("An exception occurred while calling setWeekEndingDate() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "NoteSeq":
/*     */           try {
/* 245 */             Object value = DaoUtils.getFieldValueForXmlString(-5, fieldValue);
/* 246 */             setNoteSeq((Long)value);
/* 247 */           } catch (Exception ee) {
/* 248 */             throw new DtxException("An exception occurred while calling setNoteSeq() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "CreateDate":
/*     */           try {
/* 254 */             Object value = DaoUtils.getFieldValueForXmlString(91, fieldValue);
/* 255 */             setCreateDate((Date)value);
/* 256 */           } catch (Exception ee) {
/* 257 */             throw new DtxException("An exception occurred while calling setCreateDate() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "CreateUserId":
/*     */           try {
/* 263 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 264 */             setCreateUserId((String)value);
/* 265 */           } catch (Exception ee) {
/* 266 */             throw new DtxException("An exception occurred while calling setCreateUserId() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "UpdateDate":
/*     */           try {
/* 272 */             Object value = DaoUtils.getFieldValueForXmlString(91, fieldValue);
/* 273 */             setUpdateDate((Date)value);
/* 274 */           } catch (Exception ee) {
/* 275 */             throw new DtxException("An exception occurred while calling setUpdateDate() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "UpdateUserId":
/*     */           try {
/* 281 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 282 */             setUpdateUserId((String)value);
/* 283 */           } catch (Exception ee) {
/* 284 */             throw new DtxException("An exception occurred while calling setUpdateUserId() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "NoteText":
/*     */           try {
/* 290 */             Object value = DaoUtils.getFieldValueForXmlString(2005, fieldValue);
/* 291 */             setNoteText((String)value);
/* 292 */           } catch (Exception ee) {
/* 293 */             throw new DtxException("An exception occurred while calling setNoteText() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */       } 
/*     */     } 
/*     */   }
/*     */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\thr\impl\PayrollNotesDAO.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */