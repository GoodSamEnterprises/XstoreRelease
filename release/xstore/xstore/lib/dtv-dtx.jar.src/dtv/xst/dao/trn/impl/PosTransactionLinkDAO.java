/*     */ package dtv.xst.dao.trn.impl;
/*     */ 
/*     */ import dtv.data2.access.DaoUtils;
/*     */ import dtv.data2.access.IObjectId;
/*     */ import dtv.data2.access.exception.DtxException;
/*     */ import dtv.data2.access.impl.AbstractDAOImpl;
/*     */ import dtv.util.DtvDate;
/*     */ import dtv.xst.dao.trn.PosTransactionLinkId;
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
/*     */ public class PosTransactionLinkDAO
/*     */   extends AbstractDAOImpl
/*     */ {
/*     */   private static final long serialVersionUID = -878991580L;
/*  23 */   private static final Logger _logger = Logger.getLogger(PosTransactionLinkDAO.class);
/*     */   
/*     */   private DtvDate _businessDate;
/*     */   private DtvDate _linkBusinessDate;
/*     */   private Long _linkRetailLocationId;
/*     */   private Long _linkTransactionSequence;
/*     */   private Long _linkWorkstationId;
/*     */   private Long _organizationId;
/*     */   private Long _retailLocationId;
/*     */   private Long _transactionSequence;
/*     */   private Long _workstationId;
/*     */   private DtvDate _createDate;
/*     */   private String _createUserId;
/*     */   private DtvDate _updateDate;
/*     */   private String _updateUserId;
/*     */   private String _linkTypeCode;
/*     */   
/*     */   public Date getBusinessDate() {
/*  41 */     return (Date)this._businessDate;
/*     */   }
/*     */   
/*     */   public void setBusinessDate(Date argBusinessDate) {
/*  45 */     if (changed(argBusinessDate, this._businessDate, "businessDate")) {
/*  46 */       this._businessDate = (argBusinessDate == null || argBusinessDate instanceof DtvDate) ? (DtvDate)argBusinessDate : new DtvDate(argBusinessDate);
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public Date getLinkBusinessDate() {
/*  52 */     return (Date)this._linkBusinessDate;
/*     */   }
/*     */   
/*     */   public void setLinkBusinessDate(Date argLinkBusinessDate) {
/*  56 */     if (changed(argLinkBusinessDate, this._linkBusinessDate, "linkBusinessDate")) {
/*  57 */       this._linkBusinessDate = (argLinkBusinessDate == null || argLinkBusinessDate instanceof DtvDate) ? (DtvDate)argLinkBusinessDate : new DtvDate(argLinkBusinessDate);
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public Long getLinkRetailLocationId() {
/*  63 */     return this._linkRetailLocationId;
/*     */   }
/*     */   
/*     */   public void setLinkRetailLocationId(Long argLinkRetailLocationId) {
/*  67 */     if (changed(argLinkRetailLocationId, this._linkRetailLocationId, "linkRetailLocationId")) {
/*  68 */       this._linkRetailLocationId = argLinkRetailLocationId;
/*     */     }
/*     */   }
/*     */   
/*     */   public Long getLinkTransactionSequence() {
/*  73 */     return this._linkTransactionSequence;
/*     */   }
/*     */   
/*     */   public void setLinkTransactionSequence(Long argLinkTransactionSequence) {
/*  77 */     if (changed(argLinkTransactionSequence, this._linkTransactionSequence, "linkTransactionSequence")) {
/*  78 */       this._linkTransactionSequence = argLinkTransactionSequence;
/*     */     }
/*     */   }
/*     */   
/*     */   public Long getLinkWorkstationId() {
/*  83 */     return this._linkWorkstationId;
/*     */   }
/*     */   
/*     */   public void setLinkWorkstationId(Long argLinkWorkstationId) {
/*  87 */     if (changed(argLinkWorkstationId, this._linkWorkstationId, "linkWorkstationId")) {
/*  88 */       this._linkWorkstationId = argLinkWorkstationId;
/*     */     }
/*     */   }
/*     */   
/*     */   public Long getOrganizationId() {
/*  93 */     return this._organizationId;
/*     */   }
/*     */   
/*     */   public void setOrganizationId(Long argOrganizationId) {
/*  97 */     if (changed(argOrganizationId, this._organizationId, "organizationId")) {
/*  98 */       this._organizationId = argOrganizationId;
/*     */     }
/*     */   }
/*     */   
/*     */   public Long getRetailLocationId() {
/* 103 */     return this._retailLocationId;
/*     */   }
/*     */   
/*     */   public void setRetailLocationId(Long argRetailLocationId) {
/* 107 */     if (changed(argRetailLocationId, this._retailLocationId, "retailLocationId")) {
/* 108 */       this._retailLocationId = argRetailLocationId;
/*     */     }
/*     */   }
/*     */   
/*     */   public Long getTransactionSequence() {
/* 113 */     return this._transactionSequence;
/*     */   }
/*     */   
/*     */   public void setTransactionSequence(Long argTransactionSequence) {
/* 117 */     if (changed(argTransactionSequence, this._transactionSequence, "transactionSequence")) {
/* 118 */       this._transactionSequence = argTransactionSequence;
/*     */     }
/*     */   }
/*     */   
/*     */   public Long getWorkstationId() {
/* 123 */     return this._workstationId;
/*     */   }
/*     */   
/*     */   public void setWorkstationId(Long argWorkstationId) {
/* 127 */     if (changed(argWorkstationId, this._workstationId, "workstationId")) {
/* 128 */       this._workstationId = argWorkstationId;
/*     */     }
/*     */   }
/*     */   
/*     */   public Date getCreateDate() {
/* 133 */     return (Date)this._createDate;
/*     */   }
/*     */   
/*     */   public void setCreateDate(Date argCreateDate) {
/* 137 */     if (changed(argCreateDate, this._createDate, "createDate")) {
/* 138 */       this._createDate = (argCreateDate == null || argCreateDate instanceof DtvDate) ? (DtvDate)argCreateDate : new DtvDate(argCreateDate);
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public String getCreateUserId() {
/* 144 */     return this._createUserId;
/*     */   }
/*     */   
/*     */   public void setCreateUserId(String argCreateUserId) {
/* 148 */     if (changed(argCreateUserId, this._createUserId, "createUserId")) {
/* 149 */       this._createUserId = argCreateUserId;
/*     */     }
/*     */   }
/*     */   
/*     */   public Date getUpdateDate() {
/* 154 */     return (Date)this._updateDate;
/*     */   }
/*     */   
/*     */   public void setUpdateDate(Date argUpdateDate) {
/* 158 */     if (changed(argUpdateDate, this._updateDate, "updateDate")) {
/* 159 */       this._updateDate = (argUpdateDate == null || argUpdateDate instanceof DtvDate) ? (DtvDate)argUpdateDate : new DtvDate(argUpdateDate);
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public String getUpdateUserId() {
/* 165 */     return this._updateUserId;
/*     */   }
/*     */   
/*     */   public void setUpdateUserId(String argUpdateUserId) {
/* 169 */     if (changed(argUpdateUserId, this._updateUserId, "updateUserId")) {
/* 170 */       this._updateUserId = argUpdateUserId;
/*     */     }
/*     */   }
/*     */   
/*     */   public String getLinkTypeCode() {
/* 175 */     return this._linkTypeCode;
/*     */   }
/*     */   
/*     */   public void setLinkTypeCode(String argLinkTypeCode) {
/* 179 */     if (changed(argLinkTypeCode, this._linkTypeCode, "linkTypeCode")) {
/* 180 */       this._linkTypeCode = argLinkTypeCode;
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public String toString() {
/* 187 */     StringBuilder buf = new StringBuilder(512);
/* 188 */     buf.append(super.toString()).append(" Id: ").append(getObjectId()).append(" Values: ");
/* 189 */     if (getBusinessDate() != null) {
/* 190 */       buf.append("businessDate").append("=").append(getBusinessDate()).append(" ");
/*     */     }
/* 192 */     if (getLinkBusinessDate() != null) {
/* 193 */       buf.append("linkBusinessDate").append("=").append(getLinkBusinessDate()).append(" ");
/*     */     }
/* 195 */     if (getLinkRetailLocationId() != null) {
/* 196 */       buf.append("linkRetailLocationId").append("=").append(getLinkRetailLocationId()).append(" ");
/*     */     }
/* 198 */     if (getLinkTransactionSequence() != null) {
/* 199 */       buf.append("linkTransactionSequence").append("=").append(getLinkTransactionSequence()).append(" ");
/*     */     }
/* 201 */     if (getLinkWorkstationId() != null) {
/* 202 */       buf.append("linkWorkstationId").append("=").append(getLinkWorkstationId()).append(" ");
/*     */     }
/* 204 */     if (getOrganizationId() != null) {
/* 205 */       buf.append("organizationId").append("=").append(getOrganizationId()).append(" ");
/*     */     }
/* 207 */     if (getRetailLocationId() != null) {
/* 208 */       buf.append("retailLocationId").append("=").append(getRetailLocationId()).append(" ");
/*     */     }
/* 210 */     if (getTransactionSequence() != null) {
/* 211 */       buf.append("transactionSequence").append("=").append(getTransactionSequence()).append(" ");
/*     */     }
/* 213 */     if (getWorkstationId() != null) {
/* 214 */       buf.append("workstationId").append("=").append(getWorkstationId()).append(" ");
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
/* 228 */     if (getLinkTypeCode() != null) {
/* 229 */       buf.append("linkTypeCode").append("=").append(getLinkTypeCode()).append(" ");
/*     */     }
/*     */     
/* 232 */     return buf.toString();
/*     */   }
/*     */   
/*     */   public IObjectId getObjectId() {
/* 236 */     PosTransactionLinkId id = new PosTransactionLinkId();
/* 237 */     id.setBusinessDate(getBusinessDate());
/* 238 */     id.setLinkBusinessDate(getLinkBusinessDate());
/* 239 */     id.setLinkRetailLocationId(getLinkRetailLocationId());
/* 240 */     id.setLinkTransactionSequence(getLinkTransactionSequence());
/* 241 */     id.setLinkWorkstationId(getLinkWorkstationId());
/* 242 */     id.setOrganizationId(getOrganizationId());
/* 243 */     id.setRetailLocationId(getRetailLocationId());
/* 244 */     id.setTransactionSequence(getTransactionSequence());
/* 245 */     id.setWorkstationId(getWorkstationId());
/* 246 */     return (IObjectId)id;
/*     */   }
/*     */   
/*     */   public void setObjectId(IObjectId argObjectId) {
/* 250 */     setBusinessDate(((PosTransactionLinkId)argObjectId).getBusinessDate());
/* 251 */     setLinkBusinessDate(((PosTransactionLinkId)argObjectId).getLinkBusinessDate());
/* 252 */     setLinkRetailLocationId(((PosTransactionLinkId)argObjectId).getLinkRetailLocationId());
/* 253 */     setLinkTransactionSequence(((PosTransactionLinkId)argObjectId).getLinkTransactionSequence());
/* 254 */     setLinkWorkstationId(((PosTransactionLinkId)argObjectId).getLinkWorkstationId());
/* 255 */     setOrganizationId(((PosTransactionLinkId)argObjectId).getOrganizationId());
/* 256 */     setRetailLocationId(((PosTransactionLinkId)argObjectId).getRetailLocationId());
/* 257 */     setTransactionSequence(((PosTransactionLinkId)argObjectId).getTransactionSequence());
/* 258 */     setWorkstationId(((PosTransactionLinkId)argObjectId).getWorkstationId());
/*     */   }
/*     */   
/*     */   public String getImplementingClass() {
/* 262 */     return null;
/*     */   }
/*     */   
/*     */   public String toXmlString() {
/* 266 */     StringBuilder buf = new StringBuilder(700);
/* 267 */     buf.append("<").append("dao").append(" name=\"PosTransactionLink\" cmd=\"" + getObjectStateString() + "\">");
/* 268 */     getFieldsAsXml(buf);
/* 269 */     buf.append("</").append("dao").append(">");
/*     */     
/* 271 */     return buf.toString();
/*     */   }
/*     */   
/*     */   public Map<String, String> getValues() {
/* 275 */     Map<String, String> values = super.getValues();
/* 276 */     if (this._businessDate != null) values.put("BusinessDate", DaoUtils.getXmlSafeFieldValue(91, this._businessDate)); 
/* 277 */     if (this._linkBusinessDate != null) values.put("LinkBusinessDate", DaoUtils.getXmlSafeFieldValue(91, this._linkBusinessDate)); 
/* 278 */     if (this._linkRetailLocationId != null) values.put("LinkRetailLocationId", DaoUtils.getXmlSafeFieldValue(-5, this._linkRetailLocationId)); 
/* 279 */     if (this._linkTransactionSequence != null) values.put("LinkTransactionSequence", DaoUtils.getXmlSafeFieldValue(-5, this._linkTransactionSequence)); 
/* 280 */     if (this._linkWorkstationId != null) values.put("LinkWorkstationId", DaoUtils.getXmlSafeFieldValue(-5, this._linkWorkstationId)); 
/* 281 */     if (this._organizationId != null) values.put("OrganizationId", DaoUtils.getXmlSafeFieldValue(-5, this._organizationId)); 
/* 282 */     if (this._retailLocationId != null) values.put("RetailLocationId", DaoUtils.getXmlSafeFieldValue(-5, this._retailLocationId)); 
/* 283 */     if (this._transactionSequence != null) values.put("TransactionSequence", DaoUtils.getXmlSafeFieldValue(-5, this._transactionSequence)); 
/* 284 */     if (this._workstationId != null) values.put("WorkstationId", DaoUtils.getXmlSafeFieldValue(-5, this._workstationId)); 
/* 285 */     if (this._createDate != null) values.put("CreateDate", DaoUtils.getXmlSafeFieldValue(91, this._createDate)); 
/* 286 */     if (this._createUserId != null) values.put("CreateUserId", DaoUtils.getXmlSafeFieldValue(12, this._createUserId)); 
/* 287 */     if (this._updateDate != null) values.put("UpdateDate", DaoUtils.getXmlSafeFieldValue(91, this._updateDate)); 
/* 288 */     if (this._updateUserId != null) values.put("UpdateUserId", DaoUtils.getXmlSafeFieldValue(12, this._updateUserId)); 
/* 289 */     if (this._linkTypeCode != null) values.put("LinkTypeCode", DaoUtils.getXmlSafeFieldValue(12, this._linkTypeCode)); 
/* 290 */     return values;
/*     */   }
/*     */ 
/*     */   
/*     */   public void setValues(Map<String, String> argValues) {
/* 295 */     super.setValues(argValues);
/* 296 */     for (Map.Entry<String, String> field : argValues.entrySet()) {
/*     */       
/* 298 */       String fieldName = field.getKey();
/* 299 */       String fieldValue = field.getValue();
/* 300 */       switch (fieldName) {
/*     */         
/*     */         case "BusinessDate":
/*     */           try {
/* 304 */             Object value = DaoUtils.getFieldValueForXmlString(91, fieldValue);
/* 305 */             setBusinessDate((Date)value);
/* 306 */           } catch (Exception ee) {
/* 307 */             throw new DtxException("An exception occurred while calling setBusinessDate() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "LinkBusinessDate":
/*     */           try {
/* 313 */             Object value = DaoUtils.getFieldValueForXmlString(91, fieldValue);
/* 314 */             setLinkBusinessDate((Date)value);
/* 315 */           } catch (Exception ee) {
/* 316 */             throw new DtxException("An exception occurred while calling setLinkBusinessDate() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "LinkRetailLocationId":
/*     */           try {
/* 322 */             Object value = DaoUtils.getFieldValueForXmlString(-5, fieldValue);
/* 323 */             setLinkRetailLocationId((Long)value);
/* 324 */           } catch (Exception ee) {
/* 325 */             throw new DtxException("An exception occurred while calling setLinkRetailLocationId() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "LinkTransactionSequence":
/*     */           try {
/* 331 */             Object value = DaoUtils.getFieldValueForXmlString(-5, fieldValue);
/* 332 */             setLinkTransactionSequence((Long)value);
/* 333 */           } catch (Exception ee) {
/* 334 */             throw new DtxException("An exception occurred while calling setLinkTransactionSequence() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "LinkWorkstationId":
/*     */           try {
/* 340 */             Object value = DaoUtils.getFieldValueForXmlString(-5, fieldValue);
/* 341 */             setLinkWorkstationId((Long)value);
/* 342 */           } catch (Exception ee) {
/* 343 */             throw new DtxException("An exception occurred while calling setLinkWorkstationId() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "OrganizationId":
/*     */           try {
/* 349 */             Object value = DaoUtils.getFieldValueForXmlString(-5, fieldValue);
/* 350 */             setOrganizationId((Long)value);
/* 351 */           } catch (Exception ee) {
/* 352 */             throw new DtxException("An exception occurred while calling setOrganizationId() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "RetailLocationId":
/*     */           try {
/* 358 */             Object value = DaoUtils.getFieldValueForXmlString(-5, fieldValue);
/* 359 */             setRetailLocationId((Long)value);
/* 360 */           } catch (Exception ee) {
/* 361 */             throw new DtxException("An exception occurred while calling setRetailLocationId() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "TransactionSequence":
/*     */           try {
/* 367 */             Object value = DaoUtils.getFieldValueForXmlString(-5, fieldValue);
/* 368 */             setTransactionSequence((Long)value);
/* 369 */           } catch (Exception ee) {
/* 370 */             throw new DtxException("An exception occurred while calling setTransactionSequence() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "WorkstationId":
/*     */           try {
/* 376 */             Object value = DaoUtils.getFieldValueForXmlString(-5, fieldValue);
/* 377 */             setWorkstationId((Long)value);
/* 378 */           } catch (Exception ee) {
/* 379 */             throw new DtxException("An exception occurred while calling setWorkstationId() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "CreateDate":
/*     */           try {
/* 385 */             Object value = DaoUtils.getFieldValueForXmlString(91, fieldValue);
/* 386 */             setCreateDate((Date)value);
/* 387 */           } catch (Exception ee) {
/* 388 */             throw new DtxException("An exception occurred while calling setCreateDate() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "CreateUserId":
/*     */           try {
/* 394 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 395 */             setCreateUserId((String)value);
/* 396 */           } catch (Exception ee) {
/* 397 */             throw new DtxException("An exception occurred while calling setCreateUserId() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "UpdateDate":
/*     */           try {
/* 403 */             Object value = DaoUtils.getFieldValueForXmlString(91, fieldValue);
/* 404 */             setUpdateDate((Date)value);
/* 405 */           } catch (Exception ee) {
/* 406 */             throw new DtxException("An exception occurred while calling setUpdateDate() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "UpdateUserId":
/*     */           try {
/* 412 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 413 */             setUpdateUserId((String)value);
/* 414 */           } catch (Exception ee) {
/* 415 */             throw new DtxException("An exception occurred while calling setUpdateUserId() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "LinkTypeCode":
/*     */           try {
/* 421 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 422 */             setLinkTypeCode((String)value);
/* 423 */           } catch (Exception ee) {
/* 424 */             throw new DtxException("An exception occurred while calling setLinkTypeCode() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */       } 
/*     */     } 
/*     */   }
/*     */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\trn\impl\PosTransactionLinkDAO.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */