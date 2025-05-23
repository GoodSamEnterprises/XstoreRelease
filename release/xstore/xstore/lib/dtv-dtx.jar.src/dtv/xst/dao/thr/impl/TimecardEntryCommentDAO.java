/*     */ package dtv.xst.dao.thr.impl;
/*     */ 
/*     */ import dtv.data2.access.DaoUtils;
/*     */ import dtv.data2.access.IObjectId;
/*     */ import dtv.data2.access.exception.DtxException;
/*     */ import dtv.data2.access.impl.AbstractDAOImpl;
/*     */ import dtv.util.DtvDate;
/*     */ import dtv.xst.dao.thr.TimecardEntryCommentId;
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
/*     */ public class TimecardEntryCommentDAO
/*     */   extends AbstractDAOImpl
/*     */ {
/*     */   private static final long serialVersionUID = 1657830826L;
/*  23 */   private static final Logger _logger = Logger.getLogger(TimecardEntryCommentDAO.class);
/*     */   
/*     */   private Long _organizationId;
/*     */   private DtvDate _weekEndingDate;
/*     */   private Long _retailLocationId;
/*     */   private Long _workstationId;
/*     */   private Long _partyId;
/*     */   private Long _commentSeq;
/*     */   private DtvDate _createDate;
/*     */   private String _createUserId;
/*     */   private DtvDate _updateDate;
/*     */   private String _updateUserId;
/*     */   private DtvDate _commentDateTime;
/*     */   private String _commentText;
/*     */   private String _creatorId;
/*     */   private DtvDate _businessDate;
/*     */   private Long _timecardEntryId;
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
/*     */   public Date getWeekEndingDate() {
/*  52 */     return (Date)this._weekEndingDate;
/*     */   }
/*     */   
/*     */   public void setWeekEndingDate(Date argWeekEndingDate) {
/*  56 */     if (changed(argWeekEndingDate, this._weekEndingDate, "weekEndingDate")) {
/*  57 */       this._weekEndingDate = (argWeekEndingDate == null || argWeekEndingDate instanceof DtvDate) ? (DtvDate)argWeekEndingDate : new DtvDate(argWeekEndingDate);
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public Long getRetailLocationId() {
/*  63 */     return this._retailLocationId;
/*     */   }
/*     */   
/*     */   public void setRetailLocationId(Long argRetailLocationId) {
/*  67 */     if (changed(argRetailLocationId, this._retailLocationId, "retailLocationId")) {
/*  68 */       this._retailLocationId = argRetailLocationId;
/*     */     }
/*     */   }
/*     */   
/*     */   public Long getWorkstationId() {
/*  73 */     return this._workstationId;
/*     */   }
/*     */   
/*     */   public void setWorkstationId(Long argWorkstationId) {
/*  77 */     if (changed(argWorkstationId, this._workstationId, "workstationId")) {
/*  78 */       this._workstationId = argWorkstationId;
/*     */     }
/*     */   }
/*     */   
/*     */   public Long getPartyId() {
/*  83 */     return this._partyId;
/*     */   }
/*     */   
/*     */   public void setPartyId(Long argPartyId) {
/*  87 */     if (changed(argPartyId, this._partyId, "partyId")) {
/*  88 */       this._partyId = argPartyId;
/*     */     }
/*     */   }
/*     */   
/*     */   public Long getCommentSeq() {
/*  93 */     return this._commentSeq;
/*     */   }
/*     */   
/*     */   public void setCommentSeq(Long argCommentSeq) {
/*  97 */     if (changed(argCommentSeq, this._commentSeq, "commentSeq")) {
/*  98 */       this._commentSeq = argCommentSeq;
/*     */     }
/*     */   }
/*     */   
/*     */   public Date getCreateDate() {
/* 103 */     return (Date)this._createDate;
/*     */   }
/*     */   
/*     */   public void setCreateDate(Date argCreateDate) {
/* 107 */     if (changed(argCreateDate, this._createDate, "createDate")) {
/* 108 */       this._createDate = (argCreateDate == null || argCreateDate instanceof DtvDate) ? (DtvDate)argCreateDate : new DtvDate(argCreateDate);
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public String getCreateUserId() {
/* 114 */     return this._createUserId;
/*     */   }
/*     */   
/*     */   public void setCreateUserId(String argCreateUserId) {
/* 118 */     if (changed(argCreateUserId, this._createUserId, "createUserId")) {
/* 119 */       this._createUserId = argCreateUserId;
/*     */     }
/*     */   }
/*     */   
/*     */   public Date getUpdateDate() {
/* 124 */     return (Date)this._updateDate;
/*     */   }
/*     */   
/*     */   public void setUpdateDate(Date argUpdateDate) {
/* 128 */     if (changed(argUpdateDate, this._updateDate, "updateDate")) {
/* 129 */       this._updateDate = (argUpdateDate == null || argUpdateDate instanceof DtvDate) ? (DtvDate)argUpdateDate : new DtvDate(argUpdateDate);
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public String getUpdateUserId() {
/* 135 */     return this._updateUserId;
/*     */   }
/*     */   
/*     */   public void setUpdateUserId(String argUpdateUserId) {
/* 139 */     if (changed(argUpdateUserId, this._updateUserId, "updateUserId")) {
/* 140 */       this._updateUserId = argUpdateUserId;
/*     */     }
/*     */   }
/*     */   
/*     */   public Date getCommentDateTime() {
/* 145 */     return (Date)this._commentDateTime;
/*     */   }
/*     */   
/*     */   public void setCommentDateTime(Date argCommentDateTime) {
/* 149 */     if (changed(argCommentDateTime, this._commentDateTime, "commentDateTime")) {
/* 150 */       this._commentDateTime = (argCommentDateTime == null || argCommentDateTime instanceof DtvDate) ? (DtvDate)argCommentDateTime : new DtvDate(argCommentDateTime);
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public String getCommentText() {
/* 156 */     return this._commentText;
/*     */   }
/*     */   
/*     */   public void setCommentText(String argCommentText) {
/* 160 */     if (changed(argCommentText, this._commentText, "commentText")) {
/* 161 */       this._commentText = argCommentText;
/*     */     }
/*     */   }
/*     */   
/*     */   public String getCreatorId() {
/* 166 */     return this._creatorId;
/*     */   }
/*     */   
/*     */   public void setCreatorId(String argCreatorId) {
/* 170 */     if (changed(argCreatorId, this._creatorId, "creatorId")) {
/* 171 */       this._creatorId = argCreatorId;
/*     */     }
/*     */   }
/*     */   
/*     */   public Date getBusinessDate() {
/* 176 */     return (Date)this._businessDate;
/*     */   }
/*     */   
/*     */   public void setBusinessDate(Date argBusinessDate) {
/* 180 */     if (changed(argBusinessDate, this._businessDate, "businessDate")) {
/* 181 */       this._businessDate = (argBusinessDate == null || argBusinessDate instanceof DtvDate) ? (DtvDate)argBusinessDate : new DtvDate(argBusinessDate);
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public Long getTimecardEntryId() {
/* 187 */     return this._timecardEntryId;
/*     */   }
/*     */   
/*     */   public void setTimecardEntryId(Long argTimecardEntryId) {
/* 191 */     if (changed(argTimecardEntryId, this._timecardEntryId, "timecardEntryId")) {
/* 192 */       this._timecardEntryId = argTimecardEntryId;
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public String toString() {
/* 199 */     StringBuilder buf = new StringBuilder(512);
/* 200 */     buf.append(super.toString()).append(" Id: ").append(getObjectId()).append(" Values: ");
/* 201 */     if (getOrganizationId() != null) {
/* 202 */       buf.append("organizationId").append("=").append(getOrganizationId()).append(" ");
/*     */     }
/* 204 */     if (getWeekEndingDate() != null) {
/* 205 */       buf.append("weekEndingDate").append("=").append(getWeekEndingDate()).append(" ");
/*     */     }
/* 207 */     if (getRetailLocationId() != null) {
/* 208 */       buf.append("retailLocationId").append("=").append(getRetailLocationId()).append(" ");
/*     */     }
/* 210 */     if (getWorkstationId() != null) {
/* 211 */       buf.append("workstationId").append("=").append(getWorkstationId()).append(" ");
/*     */     }
/* 213 */     if (getPartyId() != null) {
/* 214 */       buf.append("partyId").append("=").append(getPartyId()).append(" ");
/*     */     }
/* 216 */     if (getCommentSeq() != null) {
/* 217 */       buf.append("commentSeq").append("=").append(getCommentSeq()).append(" ");
/*     */     }
/* 219 */     if (getCreateDate() != null) {
/* 220 */       buf.append("createDate").append("=").append(getCreateDate()).append(" ");
/*     */     }
/* 222 */     if (getCreateUserId() != null) {
/* 223 */       buf.append("createUserId").append("=").append(getCreateUserId()).append(" ");
/*     */     }
/* 225 */     if (getUpdateDate() != null) {
/* 226 */       buf.append("updateDate").append("=").append(getUpdateDate()).append(" ");
/*     */     }
/* 228 */     if (getUpdateUserId() != null) {
/* 229 */       buf.append("updateUserId").append("=").append(getUpdateUserId()).append(" ");
/*     */     }
/* 231 */     if (getCommentDateTime() != null) {
/* 232 */       buf.append("commentDateTime").append("=").append(getCommentDateTime()).append(" ");
/*     */     }
/* 234 */     if (getCommentText() != null) {
/* 235 */       buf.append("commentText").append("=").append(getCommentText()).append(" ");
/*     */     }
/* 237 */     if (getCreatorId() != null) {
/* 238 */       buf.append("creatorId").append("=").append(getCreatorId()).append(" ");
/*     */     }
/* 240 */     if (getBusinessDate() != null) {
/* 241 */       buf.append("businessDate").append("=").append(getBusinessDate()).append(" ");
/*     */     }
/* 243 */     if (getTimecardEntryId() != null) {
/* 244 */       buf.append("timecardEntryId").append("=").append(getTimecardEntryId()).append(" ");
/*     */     }
/*     */     
/* 247 */     return buf.toString();
/*     */   }
/*     */   
/*     */   public IObjectId getObjectId() {
/* 251 */     TimecardEntryCommentId id = new TimecardEntryCommentId();
/* 252 */     id.setOrganizationId(getOrganizationId());
/* 253 */     id.setWeekEndingDate(getWeekEndingDate());
/* 254 */     id.setRetailLocationId(getRetailLocationId());
/* 255 */     id.setWorkstationId(getWorkstationId());
/* 256 */     id.setPartyId(getPartyId());
/* 257 */     id.setCommentSeq(getCommentSeq());
/* 258 */     return (IObjectId)id;
/*     */   }
/*     */   
/*     */   public void setObjectId(IObjectId argObjectId) {
/* 262 */     setOrganizationId(((TimecardEntryCommentId)argObjectId).getOrganizationId());
/* 263 */     setWeekEndingDate(((TimecardEntryCommentId)argObjectId).getWeekEndingDate());
/* 264 */     setRetailLocationId(((TimecardEntryCommentId)argObjectId).getRetailLocationId());
/* 265 */     setWorkstationId(((TimecardEntryCommentId)argObjectId).getWorkstationId());
/* 266 */     setPartyId(((TimecardEntryCommentId)argObjectId).getPartyId());
/* 267 */     setCommentSeq(((TimecardEntryCommentId)argObjectId).getCommentSeq());
/*     */   }
/*     */   
/*     */   public String getImplementingClass() {
/* 271 */     return null;
/*     */   }
/*     */   
/*     */   public String toXmlString() {
/* 275 */     StringBuilder buf = new StringBuilder(750);
/* 276 */     buf.append("<").append("dao").append(" name=\"TimecardEntryComment\" cmd=\"" + getObjectStateString() + "\">");
/* 277 */     getFieldsAsXml(buf);
/* 278 */     buf.append("</").append("dao").append(">");
/*     */     
/* 280 */     return buf.toString();
/*     */   }
/*     */   
/*     */   public Map<String, String> getValues() {
/* 284 */     Map<String, String> values = super.getValues();
/* 285 */     if (this._organizationId != null) values.put("OrganizationId", DaoUtils.getXmlSafeFieldValue(-5, this._organizationId)); 
/* 286 */     if (this._weekEndingDate != null) values.put("WeekEndingDate", DaoUtils.getXmlSafeFieldValue(91, this._weekEndingDate)); 
/* 287 */     if (this._retailLocationId != null) values.put("RetailLocationId", DaoUtils.getXmlSafeFieldValue(-5, this._retailLocationId)); 
/* 288 */     if (this._workstationId != null) values.put("WorkstationId", DaoUtils.getXmlSafeFieldValue(-5, this._workstationId)); 
/* 289 */     if (this._partyId != null) values.put("PartyId", DaoUtils.getXmlSafeFieldValue(-5, this._partyId)); 
/* 290 */     if (this._commentSeq != null) values.put("CommentSeq", DaoUtils.getXmlSafeFieldValue(-5, this._commentSeq)); 
/* 291 */     if (this._createDate != null) values.put("CreateDate", DaoUtils.getXmlSafeFieldValue(91, this._createDate)); 
/* 292 */     if (this._createUserId != null) values.put("CreateUserId", DaoUtils.getXmlSafeFieldValue(12, this._createUserId)); 
/* 293 */     if (this._updateDate != null) values.put("UpdateDate", DaoUtils.getXmlSafeFieldValue(91, this._updateDate)); 
/* 294 */     if (this._updateUserId != null) values.put("UpdateUserId", DaoUtils.getXmlSafeFieldValue(12, this._updateUserId)); 
/* 295 */     if (this._commentDateTime != null) values.put("CommentDateTime", DaoUtils.getXmlSafeFieldValue(91, this._commentDateTime)); 
/* 296 */     if (this._commentText != null) values.put("CommentText", DaoUtils.getXmlSafeFieldValue(2005, this._commentText)); 
/* 297 */     if (this._creatorId != null) values.put("CreatorId", DaoUtils.getXmlSafeFieldValue(12, this._creatorId)); 
/* 298 */     if (this._businessDate != null) values.put("BusinessDate", DaoUtils.getXmlSafeFieldValue(91, this._businessDate)); 
/* 299 */     if (this._timecardEntryId != null) values.put("TimecardEntryId", DaoUtils.getXmlSafeFieldValue(-5, this._timecardEntryId)); 
/* 300 */     return values;
/*     */   }
/*     */ 
/*     */   
/*     */   public void setValues(Map<String, String> argValues) {
/* 305 */     super.setValues(argValues);
/* 306 */     for (Map.Entry<String, String> field : argValues.entrySet()) {
/*     */       
/* 308 */       String fieldName = field.getKey();
/* 309 */       String fieldValue = field.getValue();
/* 310 */       switch (fieldName) {
/*     */         
/*     */         case "OrganizationId":
/*     */           try {
/* 314 */             Object value = DaoUtils.getFieldValueForXmlString(-5, fieldValue);
/* 315 */             setOrganizationId((Long)value);
/* 316 */           } catch (Exception ee) {
/* 317 */             throw new DtxException("An exception occurred while calling setOrganizationId() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "WeekEndingDate":
/*     */           try {
/* 323 */             Object value = DaoUtils.getFieldValueForXmlString(91, fieldValue);
/* 324 */             setWeekEndingDate((Date)value);
/* 325 */           } catch (Exception ee) {
/* 326 */             throw new DtxException("An exception occurred while calling setWeekEndingDate() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "RetailLocationId":
/*     */           try {
/* 332 */             Object value = DaoUtils.getFieldValueForXmlString(-5, fieldValue);
/* 333 */             setRetailLocationId((Long)value);
/* 334 */           } catch (Exception ee) {
/* 335 */             throw new DtxException("An exception occurred while calling setRetailLocationId() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "WorkstationId":
/*     */           try {
/* 341 */             Object value = DaoUtils.getFieldValueForXmlString(-5, fieldValue);
/* 342 */             setWorkstationId((Long)value);
/* 343 */           } catch (Exception ee) {
/* 344 */             throw new DtxException("An exception occurred while calling setWorkstationId() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "PartyId":
/*     */           try {
/* 350 */             Object value = DaoUtils.getFieldValueForXmlString(-5, fieldValue);
/* 351 */             setPartyId((Long)value);
/* 352 */           } catch (Exception ee) {
/* 353 */             throw new DtxException("An exception occurred while calling setPartyId() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "CommentSeq":
/*     */           try {
/* 359 */             Object value = DaoUtils.getFieldValueForXmlString(-5, fieldValue);
/* 360 */             setCommentSeq((Long)value);
/* 361 */           } catch (Exception ee) {
/* 362 */             throw new DtxException("An exception occurred while calling setCommentSeq() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "CreateDate":
/*     */           try {
/* 368 */             Object value = DaoUtils.getFieldValueForXmlString(91, fieldValue);
/* 369 */             setCreateDate((Date)value);
/* 370 */           } catch (Exception ee) {
/* 371 */             throw new DtxException("An exception occurred while calling setCreateDate() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "CreateUserId":
/*     */           try {
/* 377 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 378 */             setCreateUserId((String)value);
/* 379 */           } catch (Exception ee) {
/* 380 */             throw new DtxException("An exception occurred while calling setCreateUserId() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "UpdateDate":
/*     */           try {
/* 386 */             Object value = DaoUtils.getFieldValueForXmlString(91, fieldValue);
/* 387 */             setUpdateDate((Date)value);
/* 388 */           } catch (Exception ee) {
/* 389 */             throw new DtxException("An exception occurred while calling setUpdateDate() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "UpdateUserId":
/*     */           try {
/* 395 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 396 */             setUpdateUserId((String)value);
/* 397 */           } catch (Exception ee) {
/* 398 */             throw new DtxException("An exception occurred while calling setUpdateUserId() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "CommentDateTime":
/*     */           try {
/* 404 */             Object value = DaoUtils.getFieldValueForXmlString(91, fieldValue);
/* 405 */             setCommentDateTime((Date)value);
/* 406 */           } catch (Exception ee) {
/* 407 */             throw new DtxException("An exception occurred while calling setCommentDateTime() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "CommentText":
/*     */           try {
/* 413 */             Object value = DaoUtils.getFieldValueForXmlString(2005, fieldValue);
/* 414 */             setCommentText((String)value);
/* 415 */           } catch (Exception ee) {
/* 416 */             throw new DtxException("An exception occurred while calling setCommentText() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "CreatorId":
/*     */           try {
/* 422 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 423 */             setCreatorId((String)value);
/* 424 */           } catch (Exception ee) {
/* 425 */             throw new DtxException("An exception occurred while calling setCreatorId() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "BusinessDate":
/*     */           try {
/* 431 */             Object value = DaoUtils.getFieldValueForXmlString(91, fieldValue);
/* 432 */             setBusinessDate((Date)value);
/* 433 */           } catch (Exception ee) {
/* 434 */             throw new DtxException("An exception occurred while calling setBusinessDate() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "TimecardEntryId":
/*     */           try {
/* 440 */             Object value = DaoUtils.getFieldValueForXmlString(-5, fieldValue);
/* 441 */             setTimecardEntryId((Long)value);
/* 442 */           } catch (Exception ee) {
/* 443 */             throw new DtxException("An exception occurred while calling setTimecardEntryId() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */       } 
/*     */     } 
/*     */   }
/*     */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\thr\impl\TimecardEntryCommentDAO.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */