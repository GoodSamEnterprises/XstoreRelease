/*     */ package dtv.xst.dao.cat.impl;
/*     */ 
/*     */ import dtv.data2.access.DaoUtils;
/*     */ import dtv.data2.access.IObjectId;
/*     */ import dtv.data2.access.exception.DtxException;
/*     */ import dtv.data2.access.impl.AbstractDAOImpl;
/*     */ import dtv.util.DtvDate;
/*     */ import dtv.xst.dao.cat.EscrowAccountActivityId;
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
/*     */ public class EscrowAccountActivityDAO
/*     */   extends AbstractDAOImpl
/*     */ {
/*     */   private static final long serialVersionUID = -374900425L;
/*  23 */   private static final Logger _logger = Logger.getLogger(EscrowAccountActivityDAO.class);
/*     */   
/*     */   private Long _organizationId;
/*     */   private String _custAccountId;
/*     */   private Long _seqNbr;
/*     */   private DtvDate _createDate;
/*     */   private String _createUserId;
/*     */   private DtvDate _updateDate;
/*     */   private String _updateUserId;
/*     */   private DtvDate _activityDate;
/*     */   private String _activityEnum;
/*     */   private BigDecimal _amt;
/*     */   private DtvDate _businessDate;
/*     */   private Long _transactionSequence;
/*     */   private Long _workstationId;
/*     */   private Long _retailLocationId;
/*     */   private String _sourceCustAccountId;
/*     */   private String _sourceCustAccountCode;
/*     */   
/*     */   public Long getOrganizationId() {
/*  43 */     return this._organizationId;
/*     */   }
/*     */   
/*     */   public void setOrganizationId(Long argOrganizationId) {
/*  47 */     if (changed(argOrganizationId, this._organizationId, "organizationId")) {
/*  48 */       this._organizationId = argOrganizationId;
/*     */     }
/*     */   }
/*     */   
/*     */   public String getCustAccountId() {
/*  53 */     return this._custAccountId;
/*     */   }
/*     */   
/*     */   public void setCustAccountId(String argCustAccountId) {
/*  57 */     if (changed(argCustAccountId, this._custAccountId, "custAccountId")) {
/*  58 */       this._custAccountId = (argCustAccountId != null && MANAGE_CASE) ? argCustAccountId.toUpperCase() : argCustAccountId;
/*     */     }
/*     */   }
/*     */   
/*     */   public Long getSeqNbr() {
/*  63 */     return this._seqNbr;
/*     */   }
/*     */   
/*     */   public void setSeqNbr(Long argSeqNbr) {
/*  67 */     if (changed(argSeqNbr, this._seqNbr, "seqNbr")) {
/*  68 */       this._seqNbr = argSeqNbr;
/*     */     }
/*     */   }
/*     */   
/*     */   public Date getCreateDate() {
/*  73 */     return (Date)this._createDate;
/*     */   }
/*     */   
/*     */   public void setCreateDate(Date argCreateDate) {
/*  77 */     if (changed(argCreateDate, this._createDate, "createDate")) {
/*  78 */       this._createDate = (argCreateDate == null || argCreateDate instanceof DtvDate) ? (DtvDate)argCreateDate : new DtvDate(argCreateDate);
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public String getCreateUserId() {
/*  84 */     return this._createUserId;
/*     */   }
/*     */   
/*     */   public void setCreateUserId(String argCreateUserId) {
/*  88 */     if (changed(argCreateUserId, this._createUserId, "createUserId")) {
/*  89 */       this._createUserId = argCreateUserId;
/*     */     }
/*     */   }
/*     */   
/*     */   public Date getUpdateDate() {
/*  94 */     return (Date)this._updateDate;
/*     */   }
/*     */   
/*     */   public void setUpdateDate(Date argUpdateDate) {
/*  98 */     if (changed(argUpdateDate, this._updateDate, "updateDate")) {
/*  99 */       this._updateDate = (argUpdateDate == null || argUpdateDate instanceof DtvDate) ? (DtvDate)argUpdateDate : new DtvDate(argUpdateDate);
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public String getUpdateUserId() {
/* 105 */     return this._updateUserId;
/*     */   }
/*     */   
/*     */   public void setUpdateUserId(String argUpdateUserId) {
/* 109 */     if (changed(argUpdateUserId, this._updateUserId, "updateUserId")) {
/* 110 */       this._updateUserId = argUpdateUserId;
/*     */     }
/*     */   }
/*     */   
/*     */   public Date getActivityDate() {
/* 115 */     return (Date)this._activityDate;
/*     */   }
/*     */   
/*     */   public void setActivityDate(Date argActivityDate) {
/* 119 */     if (changed(argActivityDate, this._activityDate, "activityDate")) {
/* 120 */       this._activityDate = (argActivityDate == null || argActivityDate instanceof DtvDate) ? (DtvDate)argActivityDate : new DtvDate(argActivityDate);
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public String getActivityEnum() {
/* 126 */     return this._activityEnum;
/*     */   }
/*     */   
/*     */   public void setActivityEnum(String argActivityEnum) {
/* 130 */     if (changed(argActivityEnum, this._activityEnum, "activityEnum")) {
/* 131 */       this._activityEnum = argActivityEnum;
/*     */     }
/*     */   }
/*     */   
/*     */   public BigDecimal getAmt() {
/* 136 */     return this._amt;
/*     */   }
/*     */   
/*     */   public void setAmt(BigDecimal argAmt) {
/* 140 */     if (changed(argAmt, this._amt, "amt")) {
/* 141 */       this._amt = argAmt;
/*     */     }
/*     */   }
/*     */   
/*     */   public Date getBusinessDate() {
/* 146 */     return (Date)this._businessDate;
/*     */   }
/*     */   
/*     */   public void setBusinessDate(Date argBusinessDate) {
/* 150 */     if (changed(argBusinessDate, this._businessDate, "businessDate")) {
/* 151 */       this._businessDate = (argBusinessDate == null || argBusinessDate instanceof DtvDate) ? (DtvDate)argBusinessDate : new DtvDate(argBusinessDate);
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public Long getTransactionSequence() {
/* 157 */     return this._transactionSequence;
/*     */   }
/*     */   
/*     */   public void setTransactionSequence(Long argTransactionSequence) {
/* 161 */     if (changed(argTransactionSequence, this._transactionSequence, "transactionSequence")) {
/* 162 */       this._transactionSequence = argTransactionSequence;
/*     */     }
/*     */   }
/*     */   
/*     */   public Long getWorkstationId() {
/* 167 */     return this._workstationId;
/*     */   }
/*     */   
/*     */   public void setWorkstationId(Long argWorkstationId) {
/* 171 */     if (changed(argWorkstationId, this._workstationId, "workstationId")) {
/* 172 */       this._workstationId = argWorkstationId;
/*     */     }
/*     */   }
/*     */   
/*     */   public Long getRetailLocationId() {
/* 177 */     return this._retailLocationId;
/*     */   }
/*     */   
/*     */   public void setRetailLocationId(Long argRetailLocationId) {
/* 181 */     if (changed(argRetailLocationId, this._retailLocationId, "retailLocationId")) {
/* 182 */       this._retailLocationId = argRetailLocationId;
/*     */     }
/*     */   }
/*     */   
/*     */   public String getSourceCustAccountId() {
/* 187 */     return this._sourceCustAccountId;
/*     */   }
/*     */   
/*     */   public void setSourceCustAccountId(String argSourceCustAccountId) {
/* 191 */     if (changed(argSourceCustAccountId, this._sourceCustAccountId, "sourceCustAccountId")) {
/* 192 */       this._sourceCustAccountId = argSourceCustAccountId;
/*     */     }
/*     */   }
/*     */   
/*     */   public String getSourceCustAccountCode() {
/* 197 */     return this._sourceCustAccountCode;
/*     */   }
/*     */   
/*     */   public void setSourceCustAccountCode(String argSourceCustAccountCode) {
/* 201 */     if (changed(argSourceCustAccountCode, this._sourceCustAccountCode, "sourceCustAccountCode")) {
/* 202 */       this._sourceCustAccountCode = argSourceCustAccountCode;
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public String toString() {
/* 209 */     StringBuilder buf = new StringBuilder(512);
/* 210 */     buf.append(super.toString()).append(" Id: ").append(getObjectId()).append(" Values: ");
/* 211 */     if (getOrganizationId() != null) {
/* 212 */       buf.append("organizationId").append("=").append(getOrganizationId()).append(" ");
/*     */     }
/* 214 */     if (getCustAccountId() != null) {
/* 215 */       buf.append("custAccountId").append("=").append(getCustAccountId()).append(" ");
/*     */     }
/* 217 */     if (getSeqNbr() != null) {
/* 218 */       buf.append("seqNbr").append("=").append(getSeqNbr()).append(" ");
/*     */     }
/* 220 */     if (getCreateDate() != null) {
/* 221 */       buf.append("createDate").append("=").append(getCreateDate()).append(" ");
/*     */     }
/* 223 */     if (getCreateUserId() != null) {
/* 224 */       buf.append("createUserId").append("=").append(getCreateUserId()).append(" ");
/*     */     }
/* 226 */     if (getUpdateDate() != null) {
/* 227 */       buf.append("updateDate").append("=").append(getUpdateDate()).append(" ");
/*     */     }
/* 229 */     if (getUpdateUserId() != null) {
/* 230 */       buf.append("updateUserId").append("=").append(getUpdateUserId()).append(" ");
/*     */     }
/* 232 */     if (getActivityDate() != null) {
/* 233 */       buf.append("activityDate").append("=").append(getActivityDate()).append(" ");
/*     */     }
/* 235 */     if (getActivityEnum() != null) {
/* 236 */       buf.append("activityEnum").append("=").append(getActivityEnum()).append(" ");
/*     */     }
/* 238 */     if (getAmt() != null) {
/* 239 */       buf.append("amt").append("=").append(getAmt()).append(" ");
/*     */     }
/* 241 */     if (getBusinessDate() != null) {
/* 242 */       buf.append("businessDate").append("=").append(getBusinessDate()).append(" ");
/*     */     }
/* 244 */     if (getTransactionSequence() != null) {
/* 245 */       buf.append("transactionSequence").append("=").append(getTransactionSequence()).append(" ");
/*     */     }
/* 247 */     if (getWorkstationId() != null) {
/* 248 */       buf.append("workstationId").append("=").append(getWorkstationId()).append(" ");
/*     */     }
/* 250 */     if (getRetailLocationId() != null) {
/* 251 */       buf.append("retailLocationId").append("=").append(getRetailLocationId()).append(" ");
/*     */     }
/* 253 */     if (getSourceCustAccountId() != null) {
/* 254 */       buf.append("sourceCustAccountId").append("=").append(getSourceCustAccountId()).append(" ");
/*     */     }
/* 256 */     if (getSourceCustAccountCode() != null) {
/* 257 */       buf.append("sourceCustAccountCode").append("=").append(getSourceCustAccountCode()).append(" ");
/*     */     }
/*     */     
/* 260 */     return buf.toString();
/*     */   }
/*     */   
/*     */   public IObjectId getObjectId() {
/* 264 */     EscrowAccountActivityId id = new EscrowAccountActivityId();
/* 265 */     id.setOrganizationId(getOrganizationId());
/* 266 */     id.setCustAccountId(getCustAccountId());
/* 267 */     id.setSeqNbr(getSeqNbr());
/* 268 */     return (IObjectId)id;
/*     */   }
/*     */   
/*     */   public void setObjectId(IObjectId argObjectId) {
/* 272 */     setOrganizationId(((EscrowAccountActivityId)argObjectId).getOrganizationId());
/* 273 */     setCustAccountId(((EscrowAccountActivityId)argObjectId).getCustAccountId());
/* 274 */     setSeqNbr(((EscrowAccountActivityId)argObjectId).getSeqNbr());
/*     */   }
/*     */   
/*     */   public String getImplementingClass() {
/* 278 */     return null;
/*     */   }
/*     */   
/*     */   public String toXmlString() {
/* 282 */     StringBuilder buf = new StringBuilder(800);
/* 283 */     buf.append("<").append("dao").append(" name=\"EscrowAccountActivity\" cmd=\"" + getObjectStateString() + "\">");
/* 284 */     getFieldsAsXml(buf);
/* 285 */     buf.append("</").append("dao").append(">");
/*     */     
/* 287 */     return buf.toString();
/*     */   }
/*     */   
/*     */   public Map<String, String> getValues() {
/* 291 */     Map<String, String> values = super.getValues();
/* 292 */     if (this._organizationId != null) values.put("OrganizationId", DaoUtils.getXmlSafeFieldValue(-5, this._organizationId)); 
/* 293 */     if (this._custAccountId != null) values.put("CustAccountId", DaoUtils.getXmlSafeFieldValue(12, this._custAccountId)); 
/* 294 */     if (this._seqNbr != null) values.put("SeqNbr", DaoUtils.getXmlSafeFieldValue(-5, this._seqNbr)); 
/* 295 */     if (this._createDate != null) values.put("CreateDate", DaoUtils.getXmlSafeFieldValue(91, this._createDate)); 
/* 296 */     if (this._createUserId != null) values.put("CreateUserId", DaoUtils.getXmlSafeFieldValue(12, this._createUserId)); 
/* 297 */     if (this._updateDate != null) values.put("UpdateDate", DaoUtils.getXmlSafeFieldValue(91, this._updateDate)); 
/* 298 */     if (this._updateUserId != null) values.put("UpdateUserId", DaoUtils.getXmlSafeFieldValue(12, this._updateUserId)); 
/* 299 */     if (this._activityDate != null) values.put("ActivityDate", DaoUtils.getXmlSafeFieldValue(91, this._activityDate)); 
/* 300 */     if (this._activityEnum != null) values.put("ActivityEnum", DaoUtils.getXmlSafeFieldValue(12, this._activityEnum)); 
/* 301 */     if (this._amt != null) values.put("Amt", DaoUtils.getXmlSafeFieldValue(3, this._amt)); 
/* 302 */     if (this._businessDate != null) values.put("BusinessDate", DaoUtils.getXmlSafeFieldValue(91, this._businessDate)); 
/* 303 */     if (this._transactionSequence != null) values.put("TransactionSequence", DaoUtils.getXmlSafeFieldValue(-5, this._transactionSequence)); 
/* 304 */     if (this._workstationId != null) values.put("WorkstationId", DaoUtils.getXmlSafeFieldValue(-5, this._workstationId)); 
/* 305 */     if (this._retailLocationId != null) values.put("RetailLocationId", DaoUtils.getXmlSafeFieldValue(-5, this._retailLocationId)); 
/* 306 */     if (this._sourceCustAccountId != null) values.put("SourceCustAccountId", DaoUtils.getXmlSafeFieldValue(12, this._sourceCustAccountId)); 
/* 307 */     if (this._sourceCustAccountCode != null) values.put("SourceCustAccountCode", DaoUtils.getXmlSafeFieldValue(12, this._sourceCustAccountCode)); 
/* 308 */     return values;
/*     */   }
/*     */ 
/*     */   
/*     */   public void setValues(Map<String, String> argValues) {
/* 313 */     super.setValues(argValues);
/* 314 */     for (Map.Entry<String, String> field : argValues.entrySet()) {
/*     */       
/* 316 */       String fieldName = field.getKey();
/* 317 */       String fieldValue = field.getValue();
/* 318 */       switch (fieldName) {
/*     */         
/*     */         case "OrganizationId":
/*     */           try {
/* 322 */             Object value = DaoUtils.getFieldValueForXmlString(-5, fieldValue);
/* 323 */             setOrganizationId((Long)value);
/* 324 */           } catch (Exception ee) {
/* 325 */             throw new DtxException("An exception occurred while calling setOrganizationId() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "CustAccountId":
/*     */           try {
/* 331 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 332 */             setCustAccountId((String)value);
/* 333 */           } catch (Exception ee) {
/* 334 */             throw new DtxException("An exception occurred while calling setCustAccountId() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "SeqNbr":
/*     */           try {
/* 340 */             Object value = DaoUtils.getFieldValueForXmlString(-5, fieldValue);
/* 341 */             setSeqNbr((Long)value);
/* 342 */           } catch (Exception ee) {
/* 343 */             throw new DtxException("An exception occurred while calling setSeqNbr() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "CreateDate":
/*     */           try {
/* 349 */             Object value = DaoUtils.getFieldValueForXmlString(91, fieldValue);
/* 350 */             setCreateDate((Date)value);
/* 351 */           } catch (Exception ee) {
/* 352 */             throw new DtxException("An exception occurred while calling setCreateDate() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "CreateUserId":
/*     */           try {
/* 358 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 359 */             setCreateUserId((String)value);
/* 360 */           } catch (Exception ee) {
/* 361 */             throw new DtxException("An exception occurred while calling setCreateUserId() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "UpdateDate":
/*     */           try {
/* 367 */             Object value = DaoUtils.getFieldValueForXmlString(91, fieldValue);
/* 368 */             setUpdateDate((Date)value);
/* 369 */           } catch (Exception ee) {
/* 370 */             throw new DtxException("An exception occurred while calling setUpdateDate() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "UpdateUserId":
/*     */           try {
/* 376 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 377 */             setUpdateUserId((String)value);
/* 378 */           } catch (Exception ee) {
/* 379 */             throw new DtxException("An exception occurred while calling setUpdateUserId() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "ActivityDate":
/*     */           try {
/* 385 */             Object value = DaoUtils.getFieldValueForXmlString(91, fieldValue);
/* 386 */             setActivityDate((Date)value);
/* 387 */           } catch (Exception ee) {
/* 388 */             throw new DtxException("An exception occurred while calling setActivityDate() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "ActivityEnum":
/*     */           try {
/* 394 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 395 */             setActivityEnum((String)value);
/* 396 */           } catch (Exception ee) {
/* 397 */             throw new DtxException("An exception occurred while calling setActivityEnum() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "Amt":
/*     */           try {
/* 403 */             Object value = DaoUtils.getFieldValueForXmlString(3, fieldValue);
/* 404 */             setAmt((BigDecimal)value);
/* 405 */           } catch (Exception ee) {
/* 406 */             throw new DtxException("An exception occurred while calling setAmt() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "BusinessDate":
/*     */           try {
/* 412 */             Object value = DaoUtils.getFieldValueForXmlString(91, fieldValue);
/* 413 */             setBusinessDate((Date)value);
/* 414 */           } catch (Exception ee) {
/* 415 */             throw new DtxException("An exception occurred while calling setBusinessDate() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "TransactionSequence":
/*     */           try {
/* 421 */             Object value = DaoUtils.getFieldValueForXmlString(-5, fieldValue);
/* 422 */             setTransactionSequence((Long)value);
/* 423 */           } catch (Exception ee) {
/* 424 */             throw new DtxException("An exception occurred while calling setTransactionSequence() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "WorkstationId":
/*     */           try {
/* 430 */             Object value = DaoUtils.getFieldValueForXmlString(-5, fieldValue);
/* 431 */             setWorkstationId((Long)value);
/* 432 */           } catch (Exception ee) {
/* 433 */             throw new DtxException("An exception occurred while calling setWorkstationId() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "RetailLocationId":
/*     */           try {
/* 439 */             Object value = DaoUtils.getFieldValueForXmlString(-5, fieldValue);
/* 440 */             setRetailLocationId((Long)value);
/* 441 */           } catch (Exception ee) {
/* 442 */             throw new DtxException("An exception occurred while calling setRetailLocationId() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "SourceCustAccountId":
/*     */           try {
/* 448 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 449 */             setSourceCustAccountId((String)value);
/* 450 */           } catch (Exception ee) {
/* 451 */             throw new DtxException("An exception occurred while calling setSourceCustAccountId() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "SourceCustAccountCode":
/*     */           try {
/* 457 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 458 */             setSourceCustAccountCode((String)value);
/* 459 */           } catch (Exception ee) {
/* 460 */             throw new DtxException("An exception occurred while calling setSourceCustAccountCode() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */       } 
/*     */     } 
/*     */   }
/*     */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\cat\impl\EscrowAccountActivityDAO.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */