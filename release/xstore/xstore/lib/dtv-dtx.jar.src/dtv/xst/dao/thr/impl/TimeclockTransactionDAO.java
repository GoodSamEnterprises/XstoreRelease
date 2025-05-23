/*     */ package dtv.xst.dao.thr.impl;
/*     */ 
/*     */ import dtv.data2.access.DaoUtils;
/*     */ import dtv.data2.access.exception.DtxException;
/*     */ import dtv.util.DtvDate;
/*     */ import dtv.xst.dao.trn.impl.PosTransactionDAO;
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
/*     */ 
/*     */ 
/*     */ public class TimeclockTransactionDAO
/*     */   extends PosTransactionDAO
/*     */ {
/*     */   private static final long serialVersionUID = 1261991645L;
/*  23 */   private static final Logger _logger = Logger.getLogger(TimeclockTransactionDAO.class);
/*     */   
/*     */   private DtvDate _createDate;
/*     */   private String _createUserId;
/*     */   private DtvDate _updateDate;
/*     */   private String _updateUserId;
/*     */   private String _timeclockEntryCodes;
/*     */   private Long _partyId;
/*     */   private Long _timecardEntryId;
/*     */   private Long _timecardEntrySeq;
/*     */   private DtvDate _timecardEntryBusinessDate;
/*     */   private Long _timecardEntryWorkstationId;
/*     */   private String _workCodeString;
/*     */   
/*     */   public Date getCreateDate() {
/*  38 */     return (Date)this._createDate;
/*     */   }
/*     */   
/*     */   public void setCreateDate(Date argCreateDate) {
/*  42 */     if (changed(argCreateDate, this._createDate, "createDate")) {
/*  43 */       this._createDate = (argCreateDate == null || argCreateDate instanceof DtvDate) ? (DtvDate)argCreateDate : new DtvDate(argCreateDate);
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public String getCreateUserId() {
/*  49 */     return this._createUserId;
/*     */   }
/*     */   
/*     */   public void setCreateUserId(String argCreateUserId) {
/*  53 */     if (changed(argCreateUserId, this._createUserId, "createUserId")) {
/*  54 */       this._createUserId = argCreateUserId;
/*     */     }
/*     */   }
/*     */   
/*     */   public Date getUpdateDate() {
/*  59 */     return (Date)this._updateDate;
/*     */   }
/*     */   
/*     */   public void setUpdateDate(Date argUpdateDate) {
/*  63 */     if (changed(argUpdateDate, this._updateDate, "updateDate")) {
/*  64 */       this._updateDate = (argUpdateDate == null || argUpdateDate instanceof DtvDate) ? (DtvDate)argUpdateDate : new DtvDate(argUpdateDate);
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public String getUpdateUserId() {
/*  70 */     return this._updateUserId;
/*     */   }
/*     */   
/*     */   public void setUpdateUserId(String argUpdateUserId) {
/*  74 */     if (changed(argUpdateUserId, this._updateUserId, "updateUserId")) {
/*  75 */       this._updateUserId = argUpdateUserId;
/*     */     }
/*     */   }
/*     */   
/*     */   public String getTimeclockEntryCodes() {
/*  80 */     return this._timeclockEntryCodes;
/*     */   }
/*     */   
/*     */   public void setTimeclockEntryCodes(String argTimeclockEntryCodes) {
/*  84 */     if (changed(argTimeclockEntryCodes, this._timeclockEntryCodes, "timeclockEntryCodes")) {
/*  85 */       this._timeclockEntryCodes = argTimeclockEntryCodes;
/*     */     }
/*     */   }
/*     */   
/*     */   public Long getPartyId() {
/*  90 */     return this._partyId;
/*     */   }
/*     */   
/*     */   public void setPartyId(Long argPartyId) {
/*  94 */     if (changed(argPartyId, this._partyId, "partyId")) {
/*  95 */       this._partyId = argPartyId;
/*     */     }
/*     */   }
/*     */   
/*     */   public Long getTimecardEntryId() {
/* 100 */     return this._timecardEntryId;
/*     */   }
/*     */   
/*     */   public void setTimecardEntryId(Long argTimecardEntryId) {
/* 104 */     if (changed(argTimecardEntryId, this._timecardEntryId, "timecardEntryId")) {
/* 105 */       this._timecardEntryId = argTimecardEntryId;
/*     */     }
/*     */   }
/*     */   
/*     */   public Long getTimecardEntrySeq() {
/* 110 */     return this._timecardEntrySeq;
/*     */   }
/*     */   
/*     */   public void setTimecardEntrySeq(Long argTimecardEntrySeq) {
/* 114 */     if (changed(argTimecardEntrySeq, this._timecardEntrySeq, "timecardEntrySeq")) {
/* 115 */       this._timecardEntrySeq = argTimecardEntrySeq;
/*     */     }
/*     */   }
/*     */   
/*     */   public Date getTimecardEntryBusinessDate() {
/* 120 */     return (Date)this._timecardEntryBusinessDate;
/*     */   }
/*     */   
/*     */   public void setTimecardEntryBusinessDate(Date argTimecardEntryBusinessDate) {
/* 124 */     if (changed(argTimecardEntryBusinessDate, this._timecardEntryBusinessDate, "timecardEntryBusinessDate")) {
/* 125 */       this._timecardEntryBusinessDate = (argTimecardEntryBusinessDate == null || argTimecardEntryBusinessDate instanceof DtvDate) ? (DtvDate)argTimecardEntryBusinessDate : new DtvDate(argTimecardEntryBusinessDate);
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public Long getTimecardEntryWorkstationId() {
/* 131 */     return this._timecardEntryWorkstationId;
/*     */   }
/*     */   
/*     */   public void setTimecardEntryWorkstationId(Long argTimecardEntryWorkstationId) {
/* 135 */     if (changed(argTimecardEntryWorkstationId, this._timecardEntryWorkstationId, "timecardEntryWorkstationId")) {
/* 136 */       this._timecardEntryWorkstationId = argTimecardEntryWorkstationId;
/*     */     }
/*     */   }
/*     */   
/*     */   public String getWorkCodeString() {
/* 141 */     return this._workCodeString;
/*     */   }
/*     */   
/*     */   public void setWorkCodeString(String argWorkCodeString) {
/* 145 */     if (changed(argWorkCodeString, this._workCodeString, "workCodeString")) {
/* 146 */       this._workCodeString = argWorkCodeString;
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public String toString() {
/* 153 */     StringBuilder buf = new StringBuilder(512);
/* 154 */     buf.append(super.toString());
/* 155 */     if (getCreateDate() != null) {
/* 156 */       buf.append("createDate").append("=").append(getCreateDate()).append(" ");
/*     */     }
/* 158 */     if (getCreateUserId() != null) {
/* 159 */       buf.append("createUserId").append("=").append(getCreateUserId()).append(" ");
/*     */     }
/* 161 */     if (getUpdateDate() != null) {
/* 162 */       buf.append("updateDate").append("=").append(getUpdateDate()).append(" ");
/*     */     }
/* 164 */     if (getUpdateUserId() != null) {
/* 165 */       buf.append("updateUserId").append("=").append(getUpdateUserId()).append(" ");
/*     */     }
/* 167 */     if (getTimeclockEntryCodes() != null) {
/* 168 */       buf.append("timeclockEntryCodes").append("=").append(getTimeclockEntryCodes()).append(" ");
/*     */     }
/* 170 */     if (getPartyId() != null) {
/* 171 */       buf.append("partyId").append("=").append(getPartyId()).append(" ");
/*     */     }
/* 173 */     if (getTimecardEntryId() != null) {
/* 174 */       buf.append("timecardEntryId").append("=").append(getTimecardEntryId()).append(" ");
/*     */     }
/* 176 */     if (getTimecardEntrySeq() != null) {
/* 177 */       buf.append("timecardEntrySeq").append("=").append(getTimecardEntrySeq()).append(" ");
/*     */     }
/* 179 */     if (getTimecardEntryBusinessDate() != null) {
/* 180 */       buf.append("timecardEntryBusinessDate").append("=").append(getTimecardEntryBusinessDate()).append(" ");
/*     */     }
/* 182 */     if (getTimecardEntryWorkstationId() != null) {
/* 183 */       buf.append("timecardEntryWorkstationId").append("=").append(getTimecardEntryWorkstationId()).append(" ");
/*     */     }
/* 185 */     if (getWorkCodeString() != null) {
/* 186 */       buf.append("workCodeString").append("=").append(getWorkCodeString()).append(" ");
/*     */     }
/*     */     
/* 189 */     return buf.toString();
/*     */   }
/*     */ 
/*     */   
/*     */   public String toXmlString() {
/* 194 */     StringBuilder buf = new StringBuilder(2000);
/* 195 */     buf.append("<").append("dao").append(" name=\"TimeclockTransaction\" cmd=\"" + getObjectStateString() + "\">");
/* 196 */     getFieldsAsXml(buf);
/* 197 */     buf.append("</").append("dao").append(">");
/*     */     
/* 199 */     return buf.toString();
/*     */   }
/*     */   
/*     */   public Map<String, String> getValues() {
/* 203 */     Map<String, String> values = super.getValues();
/* 204 */     if (this._createDate != null) values.put("CreateDate", DaoUtils.getXmlSafeFieldValue(91, this._createDate)); 
/* 205 */     if (this._createUserId != null) values.put("CreateUserId", DaoUtils.getXmlSafeFieldValue(12, this._createUserId)); 
/* 206 */     if (this._updateDate != null) values.put("UpdateDate", DaoUtils.getXmlSafeFieldValue(91, this._updateDate)); 
/* 207 */     if (this._updateUserId != null) values.put("UpdateUserId", DaoUtils.getXmlSafeFieldValue(12, this._updateUserId)); 
/* 208 */     if (this._timeclockEntryCodes != null) values.put("TimeclockEntryCodes", DaoUtils.getXmlSafeFieldValue(12, this._timeclockEntryCodes)); 
/* 209 */     if (this._partyId != null) values.put("PartyId", DaoUtils.getXmlSafeFieldValue(-5, this._partyId)); 
/* 210 */     if (this._timecardEntryId != null) values.put("TimecardEntryId", DaoUtils.getXmlSafeFieldValue(-5, this._timecardEntryId)); 
/* 211 */     if (this._timecardEntrySeq != null) values.put("TimecardEntrySeq", DaoUtils.getXmlSafeFieldValue(-5, this._timecardEntrySeq)); 
/* 212 */     if (this._timecardEntryBusinessDate != null) values.put("TimecardEntryBusinessDate", DaoUtils.getXmlSafeFieldValue(91, this._timecardEntryBusinessDate)); 
/* 213 */     if (this._timecardEntryWorkstationId != null) values.put("TimecardEntryWorkstationId", DaoUtils.getXmlSafeFieldValue(-5, this._timecardEntryWorkstationId)); 
/* 214 */     if (this._workCodeString != null) values.put("WorkCodeString", DaoUtils.getXmlSafeFieldValue(12, this._workCodeString)); 
/* 215 */     return values;
/*     */   }
/*     */ 
/*     */   
/*     */   public void setValues(Map<String, String> argValues) {
/* 220 */     super.setValues(argValues);
/* 221 */     for (Map.Entry<String, String> field : argValues.entrySet()) {
/*     */       
/* 223 */       String fieldName = field.getKey();
/* 224 */       String fieldValue = field.getValue();
/* 225 */       switch (fieldName) {
/*     */         
/*     */         case "CreateDate":
/*     */           try {
/* 229 */             Object value = DaoUtils.getFieldValueForXmlString(91, fieldValue);
/* 230 */             setCreateDate((Date)value);
/* 231 */           } catch (Exception ee) {
/* 232 */             throw new DtxException("An exception occurred while calling setCreateDate() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "CreateUserId":
/*     */           try {
/* 238 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 239 */             setCreateUserId((String)value);
/* 240 */           } catch (Exception ee) {
/* 241 */             throw new DtxException("An exception occurred while calling setCreateUserId() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "UpdateDate":
/*     */           try {
/* 247 */             Object value = DaoUtils.getFieldValueForXmlString(91, fieldValue);
/* 248 */             setUpdateDate((Date)value);
/* 249 */           } catch (Exception ee) {
/* 250 */             throw new DtxException("An exception occurred while calling setUpdateDate() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "UpdateUserId":
/*     */           try {
/* 256 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 257 */             setUpdateUserId((String)value);
/* 258 */           } catch (Exception ee) {
/* 259 */             throw new DtxException("An exception occurred while calling setUpdateUserId() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "TimeclockEntryCodes":
/*     */           try {
/* 265 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 266 */             setTimeclockEntryCodes((String)value);
/* 267 */           } catch (Exception ee) {
/* 268 */             throw new DtxException("An exception occurred while calling setTimeclockEntryCodes() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "PartyId":
/*     */           try {
/* 274 */             Object value = DaoUtils.getFieldValueForXmlString(-5, fieldValue);
/* 275 */             setPartyId((Long)value);
/* 276 */           } catch (Exception ee) {
/* 277 */             throw new DtxException("An exception occurred while calling setPartyId() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "TimecardEntryId":
/*     */           try {
/* 283 */             Object value = DaoUtils.getFieldValueForXmlString(-5, fieldValue);
/* 284 */             setTimecardEntryId((Long)value);
/* 285 */           } catch (Exception ee) {
/* 286 */             throw new DtxException("An exception occurred while calling setTimecardEntryId() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "TimecardEntrySeq":
/*     */           try {
/* 292 */             Object value = DaoUtils.getFieldValueForXmlString(-5, fieldValue);
/* 293 */             setTimecardEntrySeq((Long)value);
/* 294 */           } catch (Exception ee) {
/* 295 */             throw new DtxException("An exception occurred while calling setTimecardEntrySeq() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "TimecardEntryBusinessDate":
/*     */           try {
/* 301 */             Object value = DaoUtils.getFieldValueForXmlString(91, fieldValue);
/* 302 */             setTimecardEntryBusinessDate((Date)value);
/* 303 */           } catch (Exception ee) {
/* 304 */             throw new DtxException("An exception occurred while calling setTimecardEntryBusinessDate() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "TimecardEntryWorkstationId":
/*     */           try {
/* 310 */             Object value = DaoUtils.getFieldValueForXmlString(-5, fieldValue);
/* 311 */             setTimecardEntryWorkstationId((Long)value);
/* 312 */           } catch (Exception ee) {
/* 313 */             throw new DtxException("An exception occurred while calling setTimecardEntryWorkstationId() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "WorkCodeString":
/*     */           try {
/* 319 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 320 */             setWorkCodeString((String)value);
/* 321 */           } catch (Exception ee) {
/* 322 */             throw new DtxException("An exception occurred while calling setWorkCodeString() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */       } 
/*     */     } 
/*     */   }
/*     */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\thr\impl\TimeclockTransactionDAO.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */