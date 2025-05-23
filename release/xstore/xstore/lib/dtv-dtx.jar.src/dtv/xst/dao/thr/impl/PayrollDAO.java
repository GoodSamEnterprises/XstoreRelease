/*     */ package dtv.xst.dao.thr.impl;
/*     */ 
/*     */ import dtv.data2.access.DaoUtils;
/*     */ import dtv.data2.access.IObjectId;
/*     */ import dtv.data2.access.exception.DtxException;
/*     */ import dtv.data2.access.impl.AbstractDAOImpl;
/*     */ import dtv.util.DtvDate;
/*     */ import dtv.xst.dao.thr.PayrollId;
/*     */ import java.math.BigDecimal;
/*     */ import java.util.Date;
/*     */ import java.util.Map;
/*     */ import org.apache.log4j.Logger;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class PayrollDAO
/*     */   extends AbstractDAOImpl
/*     */ {
/*     */   private static final long serialVersionUID = 878130437L;
/*  23 */   private static final Logger _logger = Logger.getLogger(PayrollDAO.class);
/*     */   
/*     */   private Long _retailLocId;
/*     */   private Long _partyId;
/*     */   private Long _organizationId;
/*     */   private DtvDate _businessDate;
/*     */   private String _payrollCategory;
/*     */   private DtvDate _createDate;
/*     */   private String _createUserId;
/*     */   private DtvDate _updateDate;
/*     */   private String _updateUserId;
/*     */   private BigDecimal _hoursCount;
/*  35 */   private Boolean _posted = Boolean.FALSE;
/*     */   private DtvDate _postedDate;
/*     */   private String _payrollStatus;
/*     */   private DtvDate _reviewedDate;
/*     */   private String _payCode;
/*     */   
/*     */   public Long getRetailLocId() {
/*  42 */     return this._retailLocId;
/*     */   }
/*     */   
/*     */   public void setRetailLocId(Long argRetailLocId) {
/*  46 */     if (changed(argRetailLocId, this._retailLocId, "retailLocId")) {
/*  47 */       this._retailLocId = argRetailLocId;
/*     */     }
/*     */   }
/*     */   
/*     */   public Long getPartyId() {
/*  52 */     return this._partyId;
/*     */   }
/*     */   
/*     */   public void setPartyId(Long argPartyId) {
/*  56 */     if (changed(argPartyId, this._partyId, "partyId")) {
/*  57 */       this._partyId = argPartyId;
/*     */     }
/*     */   }
/*     */   
/*     */   public Long getOrganizationId() {
/*  62 */     return this._organizationId;
/*     */   }
/*     */   
/*     */   public void setOrganizationId(Long argOrganizationId) {
/*  66 */     if (changed(argOrganizationId, this._organizationId, "organizationId")) {
/*  67 */       this._organizationId = argOrganizationId;
/*     */     }
/*     */   }
/*     */   
/*     */   public Date getBusinessDate() {
/*  72 */     return (Date)this._businessDate;
/*     */   }
/*     */   
/*     */   public void setBusinessDate(Date argBusinessDate) {
/*  76 */     if (changed(argBusinessDate, this._businessDate, "businessDate")) {
/*  77 */       this._businessDate = (argBusinessDate == null || argBusinessDate instanceof DtvDate) ? (DtvDate)argBusinessDate : new DtvDate(argBusinessDate);
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public String getPayrollCategory() {
/*  83 */     return this._payrollCategory;
/*     */   }
/*     */   
/*     */   public void setPayrollCategory(String argPayrollCategory) {
/*  87 */     if (changed(argPayrollCategory, this._payrollCategory, "payrollCategory")) {
/*  88 */       this._payrollCategory = (argPayrollCategory != null && MANAGE_CASE) ? argPayrollCategory.toUpperCase() : argPayrollCategory;
/*     */     }
/*     */   }
/*     */   
/*     */   public Date getCreateDate() {
/*  93 */     return (Date)this._createDate;
/*     */   }
/*     */   
/*     */   public void setCreateDate(Date argCreateDate) {
/*  97 */     if (changed(argCreateDate, this._createDate, "createDate")) {
/*  98 */       this._createDate = (argCreateDate == null || argCreateDate instanceof DtvDate) ? (DtvDate)argCreateDate : new DtvDate(argCreateDate);
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public String getCreateUserId() {
/* 104 */     return this._createUserId;
/*     */   }
/*     */   
/*     */   public void setCreateUserId(String argCreateUserId) {
/* 108 */     if (changed(argCreateUserId, this._createUserId, "createUserId")) {
/* 109 */       this._createUserId = argCreateUserId;
/*     */     }
/*     */   }
/*     */   
/*     */   public Date getUpdateDate() {
/* 114 */     return (Date)this._updateDate;
/*     */   }
/*     */   
/*     */   public void setUpdateDate(Date argUpdateDate) {
/* 118 */     if (changed(argUpdateDate, this._updateDate, "updateDate")) {
/* 119 */       this._updateDate = (argUpdateDate == null || argUpdateDate instanceof DtvDate) ? (DtvDate)argUpdateDate : new DtvDate(argUpdateDate);
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public String getUpdateUserId() {
/* 125 */     return this._updateUserId;
/*     */   }
/*     */   
/*     */   public void setUpdateUserId(String argUpdateUserId) {
/* 129 */     if (changed(argUpdateUserId, this._updateUserId, "updateUserId")) {
/* 130 */       this._updateUserId = argUpdateUserId;
/*     */     }
/*     */   }
/*     */   
/*     */   public BigDecimal getHoursCount() {
/* 135 */     return this._hoursCount;
/*     */   }
/*     */   
/*     */   public void setHoursCount(BigDecimal argHoursCount) {
/* 139 */     if (changed(argHoursCount, this._hoursCount, "hoursCount")) {
/* 140 */       this._hoursCount = argHoursCount;
/*     */     }
/*     */   }
/*     */   
/*     */   public Boolean getPosted() {
/* 145 */     return this._posted;
/*     */   }
/*     */   
/*     */   public void setPosted(Boolean argPosted) {
/* 149 */     if (changed(argPosted, this._posted, "posted")) {
/* 150 */       this._posted = argPosted;
/*     */     }
/*     */   }
/*     */   
/*     */   public Date getPostedDate() {
/* 155 */     return (Date)this._postedDate;
/*     */   }
/*     */   
/*     */   public void setPostedDate(Date argPostedDate) {
/* 159 */     if (changed(argPostedDate, this._postedDate, "postedDate")) {
/* 160 */       this._postedDate = (argPostedDate == null || argPostedDate instanceof DtvDate) ? (DtvDate)argPostedDate : new DtvDate(argPostedDate);
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public String getPayrollStatus() {
/* 166 */     return this._payrollStatus;
/*     */   }
/*     */   
/*     */   public void setPayrollStatus(String argPayrollStatus) {
/* 170 */     if (changed(argPayrollStatus, this._payrollStatus, "payrollStatus")) {
/* 171 */       this._payrollStatus = argPayrollStatus;
/*     */     }
/*     */   }
/*     */   
/*     */   public Date getReviewedDate() {
/* 176 */     return (Date)this._reviewedDate;
/*     */   }
/*     */   
/*     */   public void setReviewedDate(Date argReviewedDate) {
/* 180 */     if (changed(argReviewedDate, this._reviewedDate, "reviewedDate")) {
/* 181 */       this._reviewedDate = (argReviewedDate == null || argReviewedDate instanceof DtvDate) ? (DtvDate)argReviewedDate : new DtvDate(argReviewedDate);
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public String getPayCode() {
/* 187 */     return this._payCode;
/*     */   }
/*     */   
/*     */   public void setPayCode(String argPayCode) {
/* 191 */     if (changed(argPayCode, this._payCode, "payCode")) {
/* 192 */       this._payCode = argPayCode;
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public String toString() {
/* 199 */     StringBuilder buf = new StringBuilder(512);
/* 200 */     buf.append(super.toString()).append(" Id: ").append(getObjectId()).append(" Values: ");
/* 201 */     if (getRetailLocId() != null) {
/* 202 */       buf.append("retailLocId").append("=").append(getRetailLocId()).append(" ");
/*     */     }
/* 204 */     if (getPartyId() != null) {
/* 205 */       buf.append("partyId").append("=").append(getPartyId()).append(" ");
/*     */     }
/* 207 */     if (getOrganizationId() != null) {
/* 208 */       buf.append("organizationId").append("=").append(getOrganizationId()).append(" ");
/*     */     }
/* 210 */     if (getBusinessDate() != null) {
/* 211 */       buf.append("businessDate").append("=").append(getBusinessDate()).append(" ");
/*     */     }
/* 213 */     if (getPayrollCategory() != null) {
/* 214 */       buf.append("payrollCategory").append("=").append(getPayrollCategory()).append(" ");
/*     */     }
/* 216 */     if (getCreateDate() != null) {
/* 217 */       buf.append("createDate").append("=").append(getCreateDate()).append(" ");
/*     */     }
/* 219 */     if (getCreateUserId() != null) {
/* 220 */       buf.append("createUserId").append("=").append(getCreateUserId()).append(" ");
/*     */     }
/* 222 */     if (getUpdateDate() != null) {
/* 223 */       buf.append("updateDate").append("=").append(getUpdateDate()).append(" ");
/*     */     }
/* 225 */     if (getUpdateUserId() != null) {
/* 226 */       buf.append("updateUserId").append("=").append(getUpdateUserId()).append(" ");
/*     */     }
/* 228 */     if (getHoursCount() != null) {
/* 229 */       buf.append("hoursCount").append("=").append(getHoursCount()).append(" ");
/*     */     }
/* 231 */     if (getPosted() != null && getPosted().booleanValue()) {
/* 232 */       buf.append("posted").append("=").append(getPosted()).append(" ");
/*     */     }
/* 234 */     if (getPostedDate() != null) {
/* 235 */       buf.append("postedDate").append("=").append(getPostedDate()).append(" ");
/*     */     }
/* 237 */     if (getPayrollStatus() != null) {
/* 238 */       buf.append("payrollStatus").append("=").append(getPayrollStatus()).append(" ");
/*     */     }
/* 240 */     if (getReviewedDate() != null) {
/* 241 */       buf.append("reviewedDate").append("=").append(getReviewedDate()).append(" ");
/*     */     }
/* 243 */     if (getPayCode() != null) {
/* 244 */       buf.append("payCode").append("=").append(getPayCode()).append(" ");
/*     */     }
/*     */     
/* 247 */     return buf.toString();
/*     */   }
/*     */   
/*     */   public IObjectId getObjectId() {
/* 251 */     PayrollId id = new PayrollId();
/* 252 */     id.setRetailLocId(getRetailLocId());
/* 253 */     id.setPartyId(getPartyId());
/* 254 */     id.setOrganizationId(getOrganizationId());
/* 255 */     id.setBusinessDate(getBusinessDate());
/* 256 */     id.setPayrollCategory(getPayrollCategory());
/* 257 */     return (IObjectId)id;
/*     */   }
/*     */   
/*     */   public void setObjectId(IObjectId argObjectId) {
/* 261 */     setRetailLocId(((PayrollId)argObjectId).getRetailLocId());
/* 262 */     setPartyId(((PayrollId)argObjectId).getPartyId());
/* 263 */     setOrganizationId(((PayrollId)argObjectId).getOrganizationId());
/* 264 */     setBusinessDate(((PayrollId)argObjectId).getBusinessDate());
/* 265 */     setPayrollCategory(((PayrollId)argObjectId).getPayrollCategory());
/*     */   }
/*     */   
/*     */   public String getImplementingClass() {
/* 269 */     return null;
/*     */   }
/*     */   
/*     */   public String toXmlString() {
/* 273 */     StringBuilder buf = new StringBuilder(750);
/* 274 */     buf.append("<").append("dao").append(" name=\"Payroll\" cmd=\"" + getObjectStateString() + "\">");
/* 275 */     getFieldsAsXml(buf);
/* 276 */     buf.append("</").append("dao").append(">");
/*     */     
/* 278 */     return buf.toString();
/*     */   }
/*     */   
/*     */   public Map<String, String> getValues() {
/* 282 */     Map<String, String> values = super.getValues();
/* 283 */     if (this._retailLocId != null) values.put("RetailLocId", DaoUtils.getXmlSafeFieldValue(-5, this._retailLocId)); 
/* 284 */     if (this._partyId != null) values.put("PartyId", DaoUtils.getXmlSafeFieldValue(-5, this._partyId)); 
/* 285 */     if (this._organizationId != null) values.put("OrganizationId", DaoUtils.getXmlSafeFieldValue(-5, this._organizationId)); 
/* 286 */     if (this._businessDate != null) values.put("BusinessDate", DaoUtils.getXmlSafeFieldValue(91, this._businessDate)); 
/* 287 */     if (this._payrollCategory != null) values.put("PayrollCategory", DaoUtils.getXmlSafeFieldValue(12, this._payrollCategory)); 
/* 288 */     if (this._createDate != null) values.put("CreateDate", DaoUtils.getXmlSafeFieldValue(91, this._createDate)); 
/* 289 */     if (this._createUserId != null) values.put("CreateUserId", DaoUtils.getXmlSafeFieldValue(12, this._createUserId)); 
/* 290 */     if (this._updateDate != null) values.put("UpdateDate", DaoUtils.getXmlSafeFieldValue(91, this._updateDate)); 
/* 291 */     if (this._updateUserId != null) values.put("UpdateUserId", DaoUtils.getXmlSafeFieldValue(12, this._updateUserId)); 
/* 292 */     if (this._hoursCount != null) values.put("HoursCount", DaoUtils.getXmlSafeFieldValue(3, this._hoursCount)); 
/* 293 */     if (this._posted != null) values.put("Posted", DaoUtils.getXmlSafeFieldValue(-7, this._posted)); 
/* 294 */     if (this._postedDate != null) values.put("PostedDate", DaoUtils.getXmlSafeFieldValue(91, this._postedDate)); 
/* 295 */     if (this._payrollStatus != null) values.put("PayrollStatus", DaoUtils.getXmlSafeFieldValue(12, this._payrollStatus)); 
/* 296 */     if (this._reviewedDate != null) values.put("ReviewedDate", DaoUtils.getXmlSafeFieldValue(91, this._reviewedDate)); 
/* 297 */     if (this._payCode != null) values.put("PayCode", DaoUtils.getXmlSafeFieldValue(12, this._payCode)); 
/* 298 */     return values;
/*     */   }
/*     */ 
/*     */   
/*     */   public void setValues(Map<String, String> argValues) {
/* 303 */     super.setValues(argValues);
/* 304 */     for (Map.Entry<String, String> field : argValues.entrySet()) {
/*     */       
/* 306 */       String fieldName = field.getKey();
/* 307 */       String fieldValue = field.getValue();
/* 308 */       switch (fieldName) {
/*     */         
/*     */         case "RetailLocId":
/*     */           try {
/* 312 */             Object value = DaoUtils.getFieldValueForXmlString(-5, fieldValue);
/* 313 */             setRetailLocId((Long)value);
/* 314 */           } catch (Exception ee) {
/* 315 */             throw new DtxException("An exception occurred while calling setRetailLocId() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "PartyId":
/*     */           try {
/* 321 */             Object value = DaoUtils.getFieldValueForXmlString(-5, fieldValue);
/* 322 */             setPartyId((Long)value);
/* 323 */           } catch (Exception ee) {
/* 324 */             throw new DtxException("An exception occurred while calling setPartyId() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "OrganizationId":
/*     */           try {
/* 330 */             Object value = DaoUtils.getFieldValueForXmlString(-5, fieldValue);
/* 331 */             setOrganizationId((Long)value);
/* 332 */           } catch (Exception ee) {
/* 333 */             throw new DtxException("An exception occurred while calling setOrganizationId() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "BusinessDate":
/*     */           try {
/* 339 */             Object value = DaoUtils.getFieldValueForXmlString(91, fieldValue);
/* 340 */             setBusinessDate((Date)value);
/* 341 */           } catch (Exception ee) {
/* 342 */             throw new DtxException("An exception occurred while calling setBusinessDate() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "PayrollCategory":
/*     */           try {
/* 348 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 349 */             setPayrollCategory((String)value);
/* 350 */           } catch (Exception ee) {
/* 351 */             throw new DtxException("An exception occurred while calling setPayrollCategory() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "CreateDate":
/*     */           try {
/* 357 */             Object value = DaoUtils.getFieldValueForXmlString(91, fieldValue);
/* 358 */             setCreateDate((Date)value);
/* 359 */           } catch (Exception ee) {
/* 360 */             throw new DtxException("An exception occurred while calling setCreateDate() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "CreateUserId":
/*     */           try {
/* 366 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 367 */             setCreateUserId((String)value);
/* 368 */           } catch (Exception ee) {
/* 369 */             throw new DtxException("An exception occurred while calling setCreateUserId() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "UpdateDate":
/*     */           try {
/* 375 */             Object value = DaoUtils.getFieldValueForXmlString(91, fieldValue);
/* 376 */             setUpdateDate((Date)value);
/* 377 */           } catch (Exception ee) {
/* 378 */             throw new DtxException("An exception occurred while calling setUpdateDate() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "UpdateUserId":
/*     */           try {
/* 384 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 385 */             setUpdateUserId((String)value);
/* 386 */           } catch (Exception ee) {
/* 387 */             throw new DtxException("An exception occurred while calling setUpdateUserId() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "HoursCount":
/*     */           try {
/* 393 */             Object value = DaoUtils.getFieldValueForXmlString(3, fieldValue);
/* 394 */             setHoursCount((BigDecimal)value);
/* 395 */           } catch (Exception ee) {
/* 396 */             throw new DtxException("An exception occurred while calling setHoursCount() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "Posted":
/*     */           try {
/* 402 */             Object value = DaoUtils.getFieldValueForXmlString(-7, fieldValue);
/* 403 */             setPosted((Boolean)value);
/* 404 */           } catch (Exception ee) {
/* 405 */             throw new DtxException("An exception occurred while calling setPosted() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "PostedDate":
/*     */           try {
/* 411 */             Object value = DaoUtils.getFieldValueForXmlString(91, fieldValue);
/* 412 */             setPostedDate((Date)value);
/* 413 */           } catch (Exception ee) {
/* 414 */             throw new DtxException("An exception occurred while calling setPostedDate() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "PayrollStatus":
/*     */           try {
/* 420 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 421 */             setPayrollStatus((String)value);
/* 422 */           } catch (Exception ee) {
/* 423 */             throw new DtxException("An exception occurred while calling setPayrollStatus() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "ReviewedDate":
/*     */           try {
/* 429 */             Object value = DaoUtils.getFieldValueForXmlString(91, fieldValue);
/* 430 */             setReviewedDate((Date)value);
/* 431 */           } catch (Exception ee) {
/* 432 */             throw new DtxException("An exception occurred while calling setReviewedDate() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "PayCode":
/*     */           try {
/* 438 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 439 */             setPayCode((String)value);
/* 440 */           } catch (Exception ee) {
/* 441 */             throw new DtxException("An exception occurred while calling setPayCode() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */       } 
/*     */     } 
/*     */   }
/*     */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\thr\impl\PayrollDAO.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */