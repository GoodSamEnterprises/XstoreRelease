/*     */ package dtv.xst.dao.tsn.impl;
/*     */ 
/*     */ import dtv.data2.access.DaoUtils;
/*     */ import dtv.data2.access.IObjectId;
/*     */ import dtv.data2.access.exception.DtxException;
/*     */ import dtv.data2.access.impl.AbstractDAOImpl;
/*     */ import dtv.util.DtvDate;
/*     */ import dtv.xst.dao.tsn.SessionWorkstationId;
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
/*     */ public class SessionWorkstationDAO
/*     */   extends AbstractDAOImpl
/*     */ {
/*     */   private static final long serialVersionUID = 597220525L;
/*  23 */   private static final Logger _logger = Logger.getLogger(SessionWorkstationDAO.class);
/*     */   
/*     */   private Long _organizationId;
/*     */   private Long _retailLocationId;
/*     */   private Long _sessionId;
/*     */   private Integer _sessionWorkstationSequenceNbr;
/*     */   private DtvDate _createDate;
/*     */   private String _createUserId;
/*     */   private DtvDate _updateDate;
/*     */   private String _updateUserId;
/*     */   private DtvDate _beginDatetimestamp;
/*     */   private String _cashDrawerId;
/*     */   private DtvDate _endDatetimestamp;
/*  36 */   private Boolean _attached = Boolean.FALSE;
/*     */   private Long _workstationId;
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
/*     */   public Long getSessionId() {
/*  60 */     return this._sessionId;
/*     */   }
/*     */   
/*     */   public void setSessionId(Long argSessionId) {
/*  64 */     if (changed(argSessionId, this._sessionId, "sessionId")) {
/*  65 */       this._sessionId = argSessionId;
/*     */     }
/*     */   }
/*     */   
/*     */   public Integer getSessionWorkstationSequenceNbr() {
/*  70 */     return this._sessionWorkstationSequenceNbr;
/*     */   }
/*     */   
/*     */   public void setSessionWorkstationSequenceNbr(Integer argSessionWorkstationSequenceNbr) {
/*  74 */     if (changed(argSessionWorkstationSequenceNbr, this._sessionWorkstationSequenceNbr, "sessionWorkstationSequenceNbr")) {
/*  75 */       this._sessionWorkstationSequenceNbr = argSessionWorkstationSequenceNbr;
/*     */     }
/*     */   }
/*     */   
/*     */   public Date getCreateDate() {
/*  80 */     return (Date)this._createDate;
/*     */   }
/*     */   
/*     */   public void setCreateDate(Date argCreateDate) {
/*  84 */     if (changed(argCreateDate, this._createDate, "createDate")) {
/*  85 */       this._createDate = (argCreateDate == null || argCreateDate instanceof DtvDate) ? (DtvDate)argCreateDate : new DtvDate(argCreateDate);
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public String getCreateUserId() {
/*  91 */     return this._createUserId;
/*     */   }
/*     */   
/*     */   public void setCreateUserId(String argCreateUserId) {
/*  95 */     if (changed(argCreateUserId, this._createUserId, "createUserId")) {
/*  96 */       this._createUserId = argCreateUserId;
/*     */     }
/*     */   }
/*     */   
/*     */   public Date getUpdateDate() {
/* 101 */     return (Date)this._updateDate;
/*     */   }
/*     */   
/*     */   public void setUpdateDate(Date argUpdateDate) {
/* 105 */     if (changed(argUpdateDate, this._updateDate, "updateDate")) {
/* 106 */       this._updateDate = (argUpdateDate == null || argUpdateDate instanceof DtvDate) ? (DtvDate)argUpdateDate : new DtvDate(argUpdateDate);
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public String getUpdateUserId() {
/* 112 */     return this._updateUserId;
/*     */   }
/*     */   
/*     */   public void setUpdateUserId(String argUpdateUserId) {
/* 116 */     if (changed(argUpdateUserId, this._updateUserId, "updateUserId")) {
/* 117 */       this._updateUserId = argUpdateUserId;
/*     */     }
/*     */   }
/*     */   
/*     */   public Date getBeginDatetimestamp() {
/* 122 */     return (Date)this._beginDatetimestamp;
/*     */   }
/*     */   
/*     */   public void setBeginDatetimestamp(Date argBeginDatetimestamp) {
/* 126 */     if (changed(argBeginDatetimestamp, this._beginDatetimestamp, "beginDatetimestamp")) {
/* 127 */       this._beginDatetimestamp = (argBeginDatetimestamp == null || argBeginDatetimestamp instanceof DtvDate) ? (DtvDate)argBeginDatetimestamp : new DtvDate(argBeginDatetimestamp);
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public String getCashDrawerId() {
/* 133 */     return this._cashDrawerId;
/*     */   }
/*     */   
/*     */   public void setCashDrawerId(String argCashDrawerId) {
/* 137 */     if (changed(argCashDrawerId, this._cashDrawerId, "cashDrawerId")) {
/* 138 */       this._cashDrawerId = argCashDrawerId;
/*     */     }
/*     */   }
/*     */   
/*     */   public Date getEndDatetimestamp() {
/* 143 */     return (Date)this._endDatetimestamp;
/*     */   }
/*     */   
/*     */   public void setEndDatetimestamp(Date argEndDatetimestamp) {
/* 147 */     if (changed(argEndDatetimestamp, this._endDatetimestamp, "endDatetimestamp")) {
/* 148 */       this._endDatetimestamp = (argEndDatetimestamp == null || argEndDatetimestamp instanceof DtvDate) ? (DtvDate)argEndDatetimestamp : new DtvDate(argEndDatetimestamp);
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public Boolean getAttached() {
/* 154 */     return this._attached;
/*     */   }
/*     */   
/*     */   public void setAttached(Boolean argAttached) {
/* 158 */     if (changed(argAttached, this._attached, "attached")) {
/* 159 */       this._attached = argAttached;
/*     */     }
/*     */   }
/*     */   
/*     */   public Long getWorkstationId() {
/* 164 */     return this._workstationId;
/*     */   }
/*     */   
/*     */   public void setWorkstationId(Long argWorkstationId) {
/* 168 */     if (changed(argWorkstationId, this._workstationId, "workstationId")) {
/* 169 */       this._workstationId = argWorkstationId;
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public String toString() {
/* 176 */     StringBuilder buf = new StringBuilder(512);
/* 177 */     buf.append(super.toString()).append(" Id: ").append(getObjectId()).append(" Values: ");
/* 178 */     if (getOrganizationId() != null) {
/* 179 */       buf.append("organizationId").append("=").append(getOrganizationId()).append(" ");
/*     */     }
/* 181 */     if (getRetailLocationId() != null) {
/* 182 */       buf.append("retailLocationId").append("=").append(getRetailLocationId()).append(" ");
/*     */     }
/* 184 */     if (getSessionId() != null) {
/* 185 */       buf.append("sessionId").append("=").append(getSessionId()).append(" ");
/*     */     }
/* 187 */     if (getSessionWorkstationSequenceNbr() != null) {
/* 188 */       buf.append("sessionWorkstationSequenceNbr").append("=").append(getSessionWorkstationSequenceNbr()).append(" ");
/*     */     }
/* 190 */     if (getCreateDate() != null) {
/* 191 */       buf.append("createDate").append("=").append(getCreateDate()).append(" ");
/*     */     }
/* 193 */     if (getCreateUserId() != null) {
/* 194 */       buf.append("createUserId").append("=").append(getCreateUserId()).append(" ");
/*     */     }
/* 196 */     if (getUpdateDate() != null) {
/* 197 */       buf.append("updateDate").append("=").append(getUpdateDate()).append(" ");
/*     */     }
/* 199 */     if (getUpdateUserId() != null) {
/* 200 */       buf.append("updateUserId").append("=").append(getUpdateUserId()).append(" ");
/*     */     }
/* 202 */     if (getBeginDatetimestamp() != null) {
/* 203 */       buf.append("beginDatetimestamp").append("=").append(getBeginDatetimestamp()).append(" ");
/*     */     }
/* 205 */     if (getCashDrawerId() != null) {
/* 206 */       buf.append("cashDrawerId").append("=").append(getCashDrawerId()).append(" ");
/*     */     }
/* 208 */     if (getEndDatetimestamp() != null) {
/* 209 */       buf.append("endDatetimestamp").append("=").append(getEndDatetimestamp()).append(" ");
/*     */     }
/* 211 */     if (getAttached() != null && getAttached().booleanValue()) {
/* 212 */       buf.append("attached").append("=").append(getAttached()).append(" ");
/*     */     }
/* 214 */     if (getWorkstationId() != null) {
/* 215 */       buf.append("workstationId").append("=").append(getWorkstationId()).append(" ");
/*     */     }
/*     */     
/* 218 */     return buf.toString();
/*     */   }
/*     */   
/*     */   public IObjectId getObjectId() {
/* 222 */     SessionWorkstationId id = new SessionWorkstationId();
/* 223 */     id.setOrganizationId(getOrganizationId());
/* 224 */     id.setRetailLocationId(getRetailLocationId());
/* 225 */     id.setSessionId(getSessionId());
/* 226 */     id.setSessionWorkstationSequenceNbr(getSessionWorkstationSequenceNbr());
/* 227 */     return (IObjectId)id;
/*     */   }
/*     */   
/*     */   public void setObjectId(IObjectId argObjectId) {
/* 231 */     setOrganizationId(((SessionWorkstationId)argObjectId).getOrganizationId());
/* 232 */     setRetailLocationId(((SessionWorkstationId)argObjectId).getRetailLocationId());
/* 233 */     setSessionId(((SessionWorkstationId)argObjectId).getSessionId());
/* 234 */     setSessionWorkstationSequenceNbr(((SessionWorkstationId)argObjectId).getSessionWorkstationSequenceNbr());
/*     */   }
/*     */   
/*     */   public String getImplementingClass() {
/* 238 */     return null;
/*     */   }
/*     */   
/*     */   public String toXmlString() {
/* 242 */     StringBuilder buf = new StringBuilder(650);
/* 243 */     buf.append("<").append("dao").append(" name=\"SessionWorkstation\" cmd=\"" + getObjectStateString() + "\">");
/* 244 */     getFieldsAsXml(buf);
/* 245 */     buf.append("</").append("dao").append(">");
/*     */     
/* 247 */     return buf.toString();
/*     */   }
/*     */   
/*     */   public Map<String, String> getValues() {
/* 251 */     Map<String, String> values = super.getValues();
/* 252 */     if (this._organizationId != null) values.put("OrganizationId", DaoUtils.getXmlSafeFieldValue(-5, this._organizationId)); 
/* 253 */     if (this._retailLocationId != null) values.put("RetailLocationId", DaoUtils.getXmlSafeFieldValue(-5, this._retailLocationId)); 
/* 254 */     if (this._sessionId != null) values.put("SessionId", DaoUtils.getXmlSafeFieldValue(-5, this._sessionId)); 
/* 255 */     if (this._sessionWorkstationSequenceNbr != null) values.put("SessionWorkstationSequenceNbr", DaoUtils.getXmlSafeFieldValue(4, this._sessionWorkstationSequenceNbr)); 
/* 256 */     if (this._createDate != null) values.put("CreateDate", DaoUtils.getXmlSafeFieldValue(91, this._createDate)); 
/* 257 */     if (this._createUserId != null) values.put("CreateUserId", DaoUtils.getXmlSafeFieldValue(12, this._createUserId)); 
/* 258 */     if (this._updateDate != null) values.put("UpdateDate", DaoUtils.getXmlSafeFieldValue(91, this._updateDate)); 
/* 259 */     if (this._updateUserId != null) values.put("UpdateUserId", DaoUtils.getXmlSafeFieldValue(12, this._updateUserId)); 
/* 260 */     if (this._beginDatetimestamp != null) values.put("BeginDatetimestamp", DaoUtils.getXmlSafeFieldValue(91, this._beginDatetimestamp)); 
/* 261 */     if (this._cashDrawerId != null) values.put("CashDrawerId", DaoUtils.getXmlSafeFieldValue(12, this._cashDrawerId)); 
/* 262 */     if (this._endDatetimestamp != null) values.put("EndDatetimestamp", DaoUtils.getXmlSafeFieldValue(91, this._endDatetimestamp)); 
/* 263 */     if (this._attached != null) values.put("Attached", DaoUtils.getXmlSafeFieldValue(-7, this._attached)); 
/* 264 */     if (this._workstationId != null) values.put("WorkstationId", DaoUtils.getXmlSafeFieldValue(-5, this._workstationId)); 
/* 265 */     return values;
/*     */   }
/*     */ 
/*     */   
/*     */   public void setValues(Map<String, String> argValues) {
/* 270 */     super.setValues(argValues);
/* 271 */     for (Map.Entry<String, String> field : argValues.entrySet()) {
/*     */       
/* 273 */       String fieldName = field.getKey();
/* 274 */       String fieldValue = field.getValue();
/* 275 */       switch (fieldName) {
/*     */         
/*     */         case "OrganizationId":
/*     */           try {
/* 279 */             Object value = DaoUtils.getFieldValueForXmlString(-5, fieldValue);
/* 280 */             setOrganizationId((Long)value);
/* 281 */           } catch (Exception ee) {
/* 282 */             throw new DtxException("An exception occurred while calling setOrganizationId() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "RetailLocationId":
/*     */           try {
/* 288 */             Object value = DaoUtils.getFieldValueForXmlString(-5, fieldValue);
/* 289 */             setRetailLocationId((Long)value);
/* 290 */           } catch (Exception ee) {
/* 291 */             throw new DtxException("An exception occurred while calling setRetailLocationId() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "SessionId":
/*     */           try {
/* 297 */             Object value = DaoUtils.getFieldValueForXmlString(-5, fieldValue);
/* 298 */             setSessionId((Long)value);
/* 299 */           } catch (Exception ee) {
/* 300 */             throw new DtxException("An exception occurred while calling setSessionId() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "SessionWorkstationSequenceNbr":
/*     */           try {
/* 306 */             Object value = DaoUtils.getFieldValueForXmlString(4, fieldValue);
/* 307 */             setSessionWorkstationSequenceNbr((Integer)value);
/* 308 */           } catch (Exception ee) {
/* 309 */             throw new DtxException("An exception occurred while calling setSessionWorkstationSequenceNbr() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "CreateDate":
/*     */           try {
/* 315 */             Object value = DaoUtils.getFieldValueForXmlString(91, fieldValue);
/* 316 */             setCreateDate((Date)value);
/* 317 */           } catch (Exception ee) {
/* 318 */             throw new DtxException("An exception occurred while calling setCreateDate() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "CreateUserId":
/*     */           try {
/* 324 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 325 */             setCreateUserId((String)value);
/* 326 */           } catch (Exception ee) {
/* 327 */             throw new DtxException("An exception occurred while calling setCreateUserId() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "UpdateDate":
/*     */           try {
/* 333 */             Object value = DaoUtils.getFieldValueForXmlString(91, fieldValue);
/* 334 */             setUpdateDate((Date)value);
/* 335 */           } catch (Exception ee) {
/* 336 */             throw new DtxException("An exception occurred while calling setUpdateDate() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "UpdateUserId":
/*     */           try {
/* 342 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 343 */             setUpdateUserId((String)value);
/* 344 */           } catch (Exception ee) {
/* 345 */             throw new DtxException("An exception occurred while calling setUpdateUserId() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "BeginDatetimestamp":
/*     */           try {
/* 351 */             Object value = DaoUtils.getFieldValueForXmlString(91, fieldValue);
/* 352 */             setBeginDatetimestamp((Date)value);
/* 353 */           } catch (Exception ee) {
/* 354 */             throw new DtxException("An exception occurred while calling setBeginDatetimestamp() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "CashDrawerId":
/*     */           try {
/* 360 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 361 */             setCashDrawerId((String)value);
/* 362 */           } catch (Exception ee) {
/* 363 */             throw new DtxException("An exception occurred while calling setCashDrawerId() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "EndDatetimestamp":
/*     */           try {
/* 369 */             Object value = DaoUtils.getFieldValueForXmlString(91, fieldValue);
/* 370 */             setEndDatetimestamp((Date)value);
/* 371 */           } catch (Exception ee) {
/* 372 */             throw new DtxException("An exception occurred while calling setEndDatetimestamp() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "Attached":
/*     */           try {
/* 378 */             Object value = DaoUtils.getFieldValueForXmlString(-7, fieldValue);
/* 379 */             setAttached((Boolean)value);
/* 380 */           } catch (Exception ee) {
/* 381 */             throw new DtxException("An exception occurred while calling setAttached() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "WorkstationId":
/*     */           try {
/* 387 */             Object value = DaoUtils.getFieldValueForXmlString(-5, fieldValue);
/* 388 */             setWorkstationId((Long)value);
/* 389 */           } catch (Exception ee) {
/* 390 */             throw new DtxException("An exception occurred while calling setWorkstationId() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */       } 
/*     */     } 
/*     */   }
/*     */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\tsn\impl\SessionWorkstationDAO.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */