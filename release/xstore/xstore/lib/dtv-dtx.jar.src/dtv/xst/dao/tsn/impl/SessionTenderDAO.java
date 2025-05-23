/*     */ package dtv.xst.dao.tsn.impl;
/*     */ 
/*     */ import dtv.data2.access.DaoUtils;
/*     */ import dtv.data2.access.IObjectId;
/*     */ import dtv.data2.access.exception.DtxException;
/*     */ import dtv.data2.access.impl.AbstractDAOImpl;
/*     */ import dtv.data2.access.impl.IHasIncrementalValues;
/*     */ import dtv.util.DtvDate;
/*     */ import dtv.xst.dao.tsn.SessionTenderId;
/*     */ import java.math.BigDecimal;
/*     */ import java.util.Date;
/*     */ import java.util.Map;
/*     */ import org.apache.log4j.Logger;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class SessionTenderDAO
/*     */   extends AbstractDAOImpl
/*     */   implements IHasIncrementalValues
/*     */ {
/*     */   private static final long serialVersionUID = 671533290L;
/*  23 */   private static final Logger _logger = Logger.getLogger(SessionTenderDAO.class);
/*     */   
/*     */   private Long _organizationId;
/*     */   private Long _retailLocationId;
/*     */   private Long _sessionId;
/*     */   private String _tenderId;
/*     */   private DtvDate _createDate;
/*     */   private String _createUserId;
/*     */   private DtvDate _updateDate;
/*     */   private String _updateUserId;
/*     */   private BigDecimal _mediaAmount;
/*     */   private BigDecimal _initMediaAmount;
/*     */   private Integer _mediaCount;
/*     */   private Integer _initMediaCount;
/*     */   protected boolean _incrementalActive = true;
/*     */   
/*     */   public void setIncrementalActive(boolean argActive) {
/*  40 */     this._incrementalActive = argActive;
/*     */   }
/*     */   
/*     */   public boolean getIncrementalActive() {
/*  44 */     return this._incrementalActive;
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
/*     */   public Long getRetailLocationId() {
/*  58 */     return this._retailLocationId;
/*     */   }
/*     */   
/*     */   public void setRetailLocationId(Long argRetailLocationId) {
/*  62 */     if (changed(argRetailLocationId, this._retailLocationId, "retailLocationId")) {
/*  63 */       this._retailLocationId = argRetailLocationId;
/*     */     }
/*     */   }
/*     */   
/*     */   public Long getSessionId() {
/*  68 */     return this._sessionId;
/*     */   }
/*     */   
/*     */   public void setSessionId(Long argSessionId) {
/*  72 */     if (changed(argSessionId, this._sessionId, "sessionId")) {
/*  73 */       this._sessionId = argSessionId;
/*     */     }
/*     */   }
/*     */   
/*     */   public String getTenderId() {
/*  78 */     return this._tenderId;
/*     */   }
/*     */   
/*     */   public void setTenderId(String argTenderId) {
/*  82 */     if (changed(argTenderId, this._tenderId, "tenderId")) {
/*  83 */       this._tenderId = (argTenderId != null && MANAGE_CASE) ? argTenderId.toUpperCase() : argTenderId;
/*     */     }
/*     */   }
/*     */   
/*     */   public Date getCreateDate() {
/*  88 */     return (Date)this._createDate;
/*     */   }
/*     */   
/*     */   public void setCreateDate(Date argCreateDate) {
/*  92 */     if (changed(argCreateDate, this._createDate, "createDate")) {
/*  93 */       this._createDate = (argCreateDate == null || argCreateDate instanceof DtvDate) ? (DtvDate)argCreateDate : new DtvDate(argCreateDate);
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public String getCreateUserId() {
/*  99 */     return this._createUserId;
/*     */   }
/*     */   
/*     */   public void setCreateUserId(String argCreateUserId) {
/* 103 */     if (changed(argCreateUserId, this._createUserId, "createUserId")) {
/* 104 */       this._createUserId = argCreateUserId;
/*     */     }
/*     */   }
/*     */   
/*     */   public Date getUpdateDate() {
/* 109 */     return (Date)this._updateDate;
/*     */   }
/*     */   
/*     */   public void setUpdateDate(Date argUpdateDate) {
/* 113 */     if (changed(argUpdateDate, this._updateDate, "updateDate")) {
/* 114 */       this._updateDate = (argUpdateDate == null || argUpdateDate instanceof DtvDate) ? (DtvDate)argUpdateDate : new DtvDate(argUpdateDate);
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public String getUpdateUserId() {
/* 120 */     return this._updateUserId;
/*     */   }
/*     */   
/*     */   public void setUpdateUserId(String argUpdateUserId) {
/* 124 */     if (changed(argUpdateUserId, this._updateUserId, "updateUserId")) {
/* 125 */       this._updateUserId = argUpdateUserId;
/*     */     }
/*     */   }
/*     */   
/*     */   public BigDecimal getMediaAmount() {
/* 130 */     return this._mediaAmount;
/*     */   }
/*     */   
/*     */   public BigDecimal getInitMediaAmount() {
/* 134 */     return this._initMediaAmount;
/*     */   }
/*     */   
/*     */   public void setMediaAmount(BigDecimal argMediaAmount) {
/* 138 */     if (changed(argMediaAmount, this._mediaAmount, "mediaAmount")) {
/* 139 */       this._mediaAmount = argMediaAmount;
/*     */     }
/*     */   }
/*     */   
/*     */   public void setInitMediaAmount(BigDecimal argMediaAmount) {
/* 144 */     this._initMediaAmount = argMediaAmount;
/*     */   }
/*     */   
/*     */   public Integer getMediaCount() {
/* 148 */     return this._mediaCount;
/*     */   }
/*     */   
/*     */   public Integer getInitMediaCount() {
/* 152 */     return this._initMediaCount;
/*     */   }
/*     */   
/*     */   public void setMediaCount(Integer argMediaCount) {
/* 156 */     if (changed(argMediaCount, this._mediaCount, "mediaCount")) {
/* 157 */       this._mediaCount = argMediaCount;
/*     */     }
/*     */   }
/*     */   
/*     */   public void setInitMediaCount(Integer argMediaCount) {
/* 162 */     this._initMediaCount = argMediaCount;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private BigDecimal getMediaAmountDiff() {
/*     */     BigDecimal val1, val2;
/* 170 */     if (this._mediaAmount == null) {
/* 171 */       val1 = new BigDecimal(0);
/*     */     } else {
/*     */       
/* 174 */       val1 = this._mediaAmount;
/*     */     } 
/*     */     
/* 177 */     if (this._initMediaAmount == null) {
/* 178 */       val2 = new BigDecimal(0);
/*     */     } else {
/*     */       
/* 181 */       val2 = this._initMediaAmount;
/*     */     } 
/*     */     
/* 184 */     BigDecimal res = val1.subtract(val2);
/*     */     
/* 186 */     if (res.scale() < 8) {
/* 187 */       res = res.setScale(8);
/*     */     }
/*     */     
/* 190 */     return res;
/*     */   }
/*     */ 
/*     */   
/*     */   private Integer getMediaCountDiff() {
/*     */     Integer val1;
/*     */     Integer val2;
/* 197 */     if (this._mediaCount == null) {
/* 198 */       val1 = new Integer(0);
/*     */     } else {
/*     */       
/* 201 */       val1 = this._mediaCount;
/*     */     } 
/*     */     
/* 204 */     if (this._initMediaCount == null) {
/* 205 */       val2 = new Integer(0);
/*     */     } else {
/*     */       
/* 208 */       val2 = this._initMediaCount;
/*     */     } 
/*     */     
/* 211 */     return Integer.valueOf(val1.intValue() - val2.intValue());
/*     */   }
/*     */ 
/*     */   
/*     */   public String toString() {
/* 216 */     StringBuilder buf = new StringBuilder(512);
/* 217 */     buf.append(super.toString()).append(" Id: ").append(getObjectId()).append(" Values: ");
/* 218 */     if (getOrganizationId() != null) {
/* 219 */       buf.append("organizationId").append("=").append(getOrganizationId()).append(" ");
/*     */     }
/* 221 */     if (getRetailLocationId() != null) {
/* 222 */       buf.append("retailLocationId").append("=").append(getRetailLocationId()).append(" ");
/*     */     }
/* 224 */     if (getSessionId() != null) {
/* 225 */       buf.append("sessionId").append("=").append(getSessionId()).append(" ");
/*     */     }
/* 227 */     if (getTenderId() != null) {
/* 228 */       buf.append("tenderId").append("=").append(getTenderId()).append(" ");
/*     */     }
/* 230 */     if (getCreateDate() != null) {
/* 231 */       buf.append("createDate").append("=").append(getCreateDate()).append(" ");
/*     */     }
/* 233 */     if (getCreateUserId() != null) {
/* 234 */       buf.append("createUserId").append("=").append(getCreateUserId()).append(" ");
/*     */     }
/* 236 */     if (getUpdateDate() != null) {
/* 237 */       buf.append("updateDate").append("=").append(getUpdateDate()).append(" ");
/*     */     }
/* 239 */     if (getUpdateUserId() != null) {
/* 240 */       buf.append("updateUserId").append("=").append(getUpdateUserId()).append(" ");
/*     */     }
/* 242 */     if (getMediaAmount() != null) {
/* 243 */       buf.append("mediaAmount").append("=").append(getMediaAmount()).append(" ");
/*     */     }
/* 245 */     if (getMediaCount() != null) {
/* 246 */       buf.append("mediaCount").append("=").append(getMediaCount()).append(" ");
/*     */     }
/*     */     
/* 249 */     return buf.toString();
/*     */   }
/*     */   
/*     */   public IObjectId getObjectId() {
/* 253 */     SessionTenderId id = new SessionTenderId();
/* 254 */     id.setOrganizationId(getOrganizationId());
/* 255 */     id.setRetailLocationId(getRetailLocationId());
/* 256 */     id.setSessionId(getSessionId());
/* 257 */     id.setTenderId(getTenderId());
/* 258 */     return (IObjectId)id;
/*     */   }
/*     */   
/*     */   public void setObjectId(IObjectId argObjectId) {
/* 262 */     setOrganizationId(((SessionTenderId)argObjectId).getOrganizationId());
/* 263 */     setRetailLocationId(((SessionTenderId)argObjectId).getRetailLocationId());
/* 264 */     setSessionId(((SessionTenderId)argObjectId).getSessionId());
/* 265 */     setTenderId(((SessionTenderId)argObjectId).getTenderId());
/*     */   }
/*     */   
/*     */   public String getImplementingClass() {
/* 269 */     return null;
/*     */   }
/*     */   
/*     */   public String toXmlString() {
/* 273 */     StringBuilder buf = new StringBuilder(500);
/* 274 */     buf.append("<").append("dao").append(" name=\"SessionTender\" cmd=\"" + getObjectStateString() + "\">");
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
/* 285 */     if (this._sessionId != null) values.put("SessionId", DaoUtils.getXmlSafeFieldValue(-5, this._sessionId)); 
/* 286 */     if (this._tenderId != null) values.put("TenderId", DaoUtils.getXmlSafeFieldValue(12, this._tenderId)); 
/* 287 */     if (this._createDate != null) values.put("CreateDate", DaoUtils.getXmlSafeFieldValue(91, this._createDate)); 
/* 288 */     if (this._createUserId != null) values.put("CreateUserId", DaoUtils.getXmlSafeFieldValue(12, this._createUserId)); 
/* 289 */     if (this._updateDate != null) values.put("UpdateDate", DaoUtils.getXmlSafeFieldValue(91, this._updateDate)); 
/* 290 */     if (this._updateUserId != null) values.put("UpdateUserId", DaoUtils.getXmlSafeFieldValue(12, this._updateUserId)); 
/* 291 */     if (this._mediaAmount != null) values.put("MediaAmount", DaoUtils.getXmlSafeFieldValue(3, getMediaAmountDiff())); 
/* 292 */     if (this._mediaCount != null) values.put("MediaCount", DaoUtils.getXmlSafeFieldValue(4, getMediaCountDiff())); 
/* 293 */     return values;
/*     */   }
/*     */ 
/*     */   
/*     */   public void setValues(Map<String, String> argValues) {
/* 298 */     super.setValues(argValues);
/* 299 */     for (Map.Entry<String, String> field : argValues.entrySet()) {
/*     */       
/* 301 */       String fieldName = field.getKey();
/* 302 */       String fieldValue = field.getValue();
/* 303 */       switch (fieldName) {
/*     */         
/*     */         case "OrganizationId":
/*     */           try {
/* 307 */             Object value = DaoUtils.getFieldValueForXmlString(-5, fieldValue);
/* 308 */             setOrganizationId((Long)value);
/* 309 */           } catch (Exception ee) {
/* 310 */             throw new DtxException("An exception occurred while calling setOrganizationId() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "RetailLocationId":
/*     */           try {
/* 316 */             Object value = DaoUtils.getFieldValueForXmlString(-5, fieldValue);
/* 317 */             setRetailLocationId((Long)value);
/* 318 */           } catch (Exception ee) {
/* 319 */             throw new DtxException("An exception occurred while calling setRetailLocationId() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "SessionId":
/*     */           try {
/* 325 */             Object value = DaoUtils.getFieldValueForXmlString(-5, fieldValue);
/* 326 */             setSessionId((Long)value);
/* 327 */           } catch (Exception ee) {
/* 328 */             throw new DtxException("An exception occurred while calling setSessionId() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "TenderId":
/*     */           try {
/* 334 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 335 */             setTenderId((String)value);
/* 336 */           } catch (Exception ee) {
/* 337 */             throw new DtxException("An exception occurred while calling setTenderId() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "CreateDate":
/*     */           try {
/* 343 */             Object value = DaoUtils.getFieldValueForXmlString(91, fieldValue);
/* 344 */             setCreateDate((Date)value);
/* 345 */           } catch (Exception ee) {
/* 346 */             throw new DtxException("An exception occurred while calling setCreateDate() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "CreateUserId":
/*     */           try {
/* 352 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 353 */             setCreateUserId((String)value);
/* 354 */           } catch (Exception ee) {
/* 355 */             throw new DtxException("An exception occurred while calling setCreateUserId() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "UpdateDate":
/*     */           try {
/* 361 */             Object value = DaoUtils.getFieldValueForXmlString(91, fieldValue);
/* 362 */             setUpdateDate((Date)value);
/* 363 */           } catch (Exception ee) {
/* 364 */             throw new DtxException("An exception occurred while calling setUpdateDate() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "UpdateUserId":
/*     */           try {
/* 370 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 371 */             setUpdateUserId((String)value);
/* 372 */           } catch (Exception ee) {
/* 373 */             throw new DtxException("An exception occurred while calling setUpdateUserId() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "MediaAmount":
/*     */           try {
/* 379 */             Object value = DaoUtils.getFieldValueForXmlString(3, fieldValue);
/* 380 */             setMediaAmount((BigDecimal)value);
/* 381 */           } catch (Exception ee) {
/* 382 */             throw new DtxException("An exception occurred while calling setMediaAmount() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "MediaCount":
/*     */           try {
/* 388 */             Object value = DaoUtils.getFieldValueForXmlString(4, fieldValue);
/* 389 */             setMediaCount((Integer)value);
/* 390 */           } catch (Exception ee) {
/* 391 */             throw new DtxException("An exception occurred while calling setMediaCount() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */       } 
/*     */     } 
/*     */   }
/*     */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\tsn\impl\SessionTenderDAO.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */