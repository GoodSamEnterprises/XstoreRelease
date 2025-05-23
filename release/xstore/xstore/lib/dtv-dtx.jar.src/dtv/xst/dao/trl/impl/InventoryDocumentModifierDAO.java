/*     */ package dtv.xst.dao.trl.impl;
/*     */ 
/*     */ import dtv.data2.access.DaoUtils;
/*     */ import dtv.data2.access.IObjectId;
/*     */ import dtv.data2.access.exception.DtxException;
/*     */ import dtv.data2.access.impl.AbstractDAOImpl;
/*     */ import dtv.util.DtvDate;
/*     */ import dtv.xst.dao.trl.InventoryDocumentModifierId;
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
/*     */ public class InventoryDocumentModifierDAO
/*     */   extends AbstractDAOImpl
/*     */ {
/*     */   private static final long serialVersionUID = -1151176082L;
/*  23 */   private static final Logger _logger = Logger.getLogger(InventoryDocumentModifierDAO.class);
/*     */   
/*     */   private DtvDate _businessDate;
/*     */   private Integer _documentModifierSequence;
/*     */   private Long _organizationId;
/*     */   private Long _retailLocationId;
/*     */   private Long _transactionSequence;
/*     */   private Long _workstationId;
/*     */   private DtvDate _createDate;
/*     */   private String _createUserId;
/*     */   private DtvDate _updateDate;
/*     */   private String _updateUserId;
/*     */   private String _documentId;
/*     */   private String _documentTypeCode;
/*     */   
/*     */   public Date getBusinessDate() {
/*  39 */     return (Date)this._businessDate;
/*     */   }
/*     */   
/*     */   public void setBusinessDate(Date argBusinessDate) {
/*  43 */     if (changed(argBusinessDate, this._businessDate, "businessDate")) {
/*  44 */       this._businessDate = (argBusinessDate == null || argBusinessDate instanceof DtvDate) ? (DtvDate)argBusinessDate : new DtvDate(argBusinessDate);
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public Integer getDocumentModifierSequence() {
/*  50 */     return this._documentModifierSequence;
/*     */   }
/*     */   
/*     */   public void setDocumentModifierSequence(Integer argDocumentModifierSequence) {
/*  54 */     if (changed(argDocumentModifierSequence, this._documentModifierSequence, "documentModifierSequence")) {
/*  55 */       this._documentModifierSequence = argDocumentModifierSequence;
/*     */     }
/*     */   }
/*     */   
/*     */   public Long getOrganizationId() {
/*  60 */     return this._organizationId;
/*     */   }
/*     */   
/*     */   public void setOrganizationId(Long argOrganizationId) {
/*  64 */     if (changed(argOrganizationId, this._organizationId, "organizationId")) {
/*  65 */       this._organizationId = argOrganizationId;
/*     */     }
/*     */   }
/*     */   
/*     */   public Long getRetailLocationId() {
/*  70 */     return this._retailLocationId;
/*     */   }
/*     */   
/*     */   public void setRetailLocationId(Long argRetailLocationId) {
/*  74 */     if (changed(argRetailLocationId, this._retailLocationId, "retailLocationId")) {
/*  75 */       this._retailLocationId = argRetailLocationId;
/*     */     }
/*     */   }
/*     */   
/*     */   public Long getTransactionSequence() {
/*  80 */     return this._transactionSequence;
/*     */   }
/*     */   
/*     */   public void setTransactionSequence(Long argTransactionSequence) {
/*  84 */     if (changed(argTransactionSequence, this._transactionSequence, "transactionSequence")) {
/*  85 */       this._transactionSequence = argTransactionSequence;
/*     */     }
/*     */   }
/*     */   
/*     */   public Long getWorkstationId() {
/*  90 */     return this._workstationId;
/*     */   }
/*     */   
/*     */   public void setWorkstationId(Long argWorkstationId) {
/*  94 */     if (changed(argWorkstationId, this._workstationId, "workstationId")) {
/*  95 */       this._workstationId = argWorkstationId;
/*     */     }
/*     */   }
/*     */   
/*     */   public Date getCreateDate() {
/* 100 */     return (Date)this._createDate;
/*     */   }
/*     */   
/*     */   public void setCreateDate(Date argCreateDate) {
/* 104 */     if (changed(argCreateDate, this._createDate, "createDate")) {
/* 105 */       this._createDate = (argCreateDate == null || argCreateDate instanceof DtvDate) ? (DtvDate)argCreateDate : new DtvDate(argCreateDate);
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public String getCreateUserId() {
/* 111 */     return this._createUserId;
/*     */   }
/*     */   
/*     */   public void setCreateUserId(String argCreateUserId) {
/* 115 */     if (changed(argCreateUserId, this._createUserId, "createUserId")) {
/* 116 */       this._createUserId = argCreateUserId;
/*     */     }
/*     */   }
/*     */   
/*     */   public Date getUpdateDate() {
/* 121 */     return (Date)this._updateDate;
/*     */   }
/*     */   
/*     */   public void setUpdateDate(Date argUpdateDate) {
/* 125 */     if (changed(argUpdateDate, this._updateDate, "updateDate")) {
/* 126 */       this._updateDate = (argUpdateDate == null || argUpdateDate instanceof DtvDate) ? (DtvDate)argUpdateDate : new DtvDate(argUpdateDate);
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public String getUpdateUserId() {
/* 132 */     return this._updateUserId;
/*     */   }
/*     */   
/*     */   public void setUpdateUserId(String argUpdateUserId) {
/* 136 */     if (changed(argUpdateUserId, this._updateUserId, "updateUserId")) {
/* 137 */       this._updateUserId = argUpdateUserId;
/*     */     }
/*     */   }
/*     */   
/*     */   public String getDocumentId() {
/* 142 */     return this._documentId;
/*     */   }
/*     */   
/*     */   public void setDocumentId(String argDocumentId) {
/* 146 */     if (changed(argDocumentId, this._documentId, "documentId")) {
/* 147 */       this._documentId = argDocumentId;
/*     */     }
/*     */   }
/*     */   
/*     */   public String getDocumentTypeCode() {
/* 152 */     return this._documentTypeCode;
/*     */   }
/*     */   
/*     */   public void setDocumentTypeCode(String argDocumentTypeCode) {
/* 156 */     if (changed(argDocumentTypeCode, this._documentTypeCode, "documentTypeCode")) {
/* 157 */       this._documentTypeCode = argDocumentTypeCode;
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public String toString() {
/* 164 */     StringBuilder buf = new StringBuilder(512);
/* 165 */     buf.append(super.toString()).append(" Id: ").append(getObjectId()).append(" Values: ");
/* 166 */     if (getBusinessDate() != null) {
/* 167 */       buf.append("businessDate").append("=").append(getBusinessDate()).append(" ");
/*     */     }
/* 169 */     if (getDocumentModifierSequence() != null) {
/* 170 */       buf.append("documentModifierSequence").append("=").append(getDocumentModifierSequence()).append(" ");
/*     */     }
/* 172 */     if (getOrganizationId() != null) {
/* 173 */       buf.append("organizationId").append("=").append(getOrganizationId()).append(" ");
/*     */     }
/* 175 */     if (getRetailLocationId() != null) {
/* 176 */       buf.append("retailLocationId").append("=").append(getRetailLocationId()).append(" ");
/*     */     }
/* 178 */     if (getTransactionSequence() != null) {
/* 179 */       buf.append("transactionSequence").append("=").append(getTransactionSequence()).append(" ");
/*     */     }
/* 181 */     if (getWorkstationId() != null) {
/* 182 */       buf.append("workstationId").append("=").append(getWorkstationId()).append(" ");
/*     */     }
/* 184 */     if (getCreateDate() != null) {
/* 185 */       buf.append("createDate").append("=").append(getCreateDate()).append(" ");
/*     */     }
/* 187 */     if (getCreateUserId() != null) {
/* 188 */       buf.append("createUserId").append("=").append(getCreateUserId()).append(" ");
/*     */     }
/* 190 */     if (getUpdateDate() != null) {
/* 191 */       buf.append("updateDate").append("=").append(getUpdateDate()).append(" ");
/*     */     }
/* 193 */     if (getUpdateUserId() != null) {
/* 194 */       buf.append("updateUserId").append("=").append(getUpdateUserId()).append(" ");
/*     */     }
/* 196 */     if (getDocumentId() != null) {
/* 197 */       buf.append("documentId").append("=").append(getDocumentId()).append(" ");
/*     */     }
/* 199 */     if (getDocumentTypeCode() != null) {
/* 200 */       buf.append("documentTypeCode").append("=").append(getDocumentTypeCode()).append(" ");
/*     */     }
/*     */     
/* 203 */     return buf.toString();
/*     */   }
/*     */   
/*     */   public IObjectId getObjectId() {
/* 207 */     InventoryDocumentModifierId id = new InventoryDocumentModifierId();
/* 208 */     id.setBusinessDate(getBusinessDate());
/* 209 */     id.setDocumentModifierSequence(getDocumentModifierSequence());
/* 210 */     id.setOrganizationId(getOrganizationId());
/* 211 */     id.setRetailLocationId(getRetailLocationId());
/* 212 */     id.setTransactionSequence(getTransactionSequence());
/* 213 */     id.setWorkstationId(getWorkstationId());
/* 214 */     return (IObjectId)id;
/*     */   }
/*     */   
/*     */   public void setObjectId(IObjectId argObjectId) {
/* 218 */     setBusinessDate(((InventoryDocumentModifierId)argObjectId).getBusinessDate());
/* 219 */     setDocumentModifierSequence(((InventoryDocumentModifierId)argObjectId).getDocumentModifierSequence());
/* 220 */     setOrganizationId(((InventoryDocumentModifierId)argObjectId).getOrganizationId());
/* 221 */     setRetailLocationId(((InventoryDocumentModifierId)argObjectId).getRetailLocationId());
/* 222 */     setTransactionSequence(((InventoryDocumentModifierId)argObjectId).getTransactionSequence());
/* 223 */     setWorkstationId(((InventoryDocumentModifierId)argObjectId).getWorkstationId());
/*     */   }
/*     */   
/*     */   public String getImplementingClass() {
/* 227 */     return null;
/*     */   }
/*     */   
/*     */   public String toXmlString() {
/* 231 */     StringBuilder buf = new StringBuilder(600);
/* 232 */     buf.append("<").append("dao").append(" name=\"InventoryDocumentModifier\" cmd=\"" + getObjectStateString() + "\">");
/* 233 */     getFieldsAsXml(buf);
/* 234 */     buf.append("</").append("dao").append(">");
/*     */     
/* 236 */     return buf.toString();
/*     */   }
/*     */   
/*     */   public Map<String, String> getValues() {
/* 240 */     Map<String, String> values = super.getValues();
/* 241 */     if (this._businessDate != null) values.put("BusinessDate", DaoUtils.getXmlSafeFieldValue(91, this._businessDate)); 
/* 242 */     if (this._documentModifierSequence != null) values.put("DocumentModifierSequence", DaoUtils.getXmlSafeFieldValue(4, this._documentModifierSequence)); 
/* 243 */     if (this._organizationId != null) values.put("OrganizationId", DaoUtils.getXmlSafeFieldValue(-5, this._organizationId)); 
/* 244 */     if (this._retailLocationId != null) values.put("RetailLocationId", DaoUtils.getXmlSafeFieldValue(-5, this._retailLocationId)); 
/* 245 */     if (this._transactionSequence != null) values.put("TransactionSequence", DaoUtils.getXmlSafeFieldValue(-5, this._transactionSequence)); 
/* 246 */     if (this._workstationId != null) values.put("WorkstationId", DaoUtils.getXmlSafeFieldValue(-5, this._workstationId)); 
/* 247 */     if (this._createDate != null) values.put("CreateDate", DaoUtils.getXmlSafeFieldValue(91, this._createDate)); 
/* 248 */     if (this._createUserId != null) values.put("CreateUserId", DaoUtils.getXmlSafeFieldValue(12, this._createUserId)); 
/* 249 */     if (this._updateDate != null) values.put("UpdateDate", DaoUtils.getXmlSafeFieldValue(91, this._updateDate)); 
/* 250 */     if (this._updateUserId != null) values.put("UpdateUserId", DaoUtils.getXmlSafeFieldValue(12, this._updateUserId)); 
/* 251 */     if (this._documentId != null) values.put("DocumentId", DaoUtils.getXmlSafeFieldValue(12, this._documentId)); 
/* 252 */     if (this._documentTypeCode != null) values.put("DocumentTypeCode", DaoUtils.getXmlSafeFieldValue(12, this._documentTypeCode)); 
/* 253 */     return values;
/*     */   }
/*     */ 
/*     */   
/*     */   public void setValues(Map<String, String> argValues) {
/* 258 */     super.setValues(argValues);
/* 259 */     for (Map.Entry<String, String> field : argValues.entrySet()) {
/*     */       
/* 261 */       String fieldName = field.getKey();
/* 262 */       String fieldValue = field.getValue();
/* 263 */       switch (fieldName) {
/*     */         
/*     */         case "BusinessDate":
/*     */           try {
/* 267 */             Object value = DaoUtils.getFieldValueForXmlString(91, fieldValue);
/* 268 */             setBusinessDate((Date)value);
/* 269 */           } catch (Exception ee) {
/* 270 */             throw new DtxException("An exception occurred while calling setBusinessDate() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "DocumentModifierSequence":
/*     */           try {
/* 276 */             Object value = DaoUtils.getFieldValueForXmlString(4, fieldValue);
/* 277 */             setDocumentModifierSequence((Integer)value);
/* 278 */           } catch (Exception ee) {
/* 279 */             throw new DtxException("An exception occurred while calling setDocumentModifierSequence() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "OrganizationId":
/*     */           try {
/* 285 */             Object value = DaoUtils.getFieldValueForXmlString(-5, fieldValue);
/* 286 */             setOrganizationId((Long)value);
/* 287 */           } catch (Exception ee) {
/* 288 */             throw new DtxException("An exception occurred while calling setOrganizationId() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "RetailLocationId":
/*     */           try {
/* 294 */             Object value = DaoUtils.getFieldValueForXmlString(-5, fieldValue);
/* 295 */             setRetailLocationId((Long)value);
/* 296 */           } catch (Exception ee) {
/* 297 */             throw new DtxException("An exception occurred while calling setRetailLocationId() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "TransactionSequence":
/*     */           try {
/* 303 */             Object value = DaoUtils.getFieldValueForXmlString(-5, fieldValue);
/* 304 */             setTransactionSequence((Long)value);
/* 305 */           } catch (Exception ee) {
/* 306 */             throw new DtxException("An exception occurred while calling setTransactionSequence() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "WorkstationId":
/*     */           try {
/* 312 */             Object value = DaoUtils.getFieldValueForXmlString(-5, fieldValue);
/* 313 */             setWorkstationId((Long)value);
/* 314 */           } catch (Exception ee) {
/* 315 */             throw new DtxException("An exception occurred while calling setWorkstationId() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "CreateDate":
/*     */           try {
/* 321 */             Object value = DaoUtils.getFieldValueForXmlString(91, fieldValue);
/* 322 */             setCreateDate((Date)value);
/* 323 */           } catch (Exception ee) {
/* 324 */             throw new DtxException("An exception occurred while calling setCreateDate() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "CreateUserId":
/*     */           try {
/* 330 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 331 */             setCreateUserId((String)value);
/* 332 */           } catch (Exception ee) {
/* 333 */             throw new DtxException("An exception occurred while calling setCreateUserId() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "UpdateDate":
/*     */           try {
/* 339 */             Object value = DaoUtils.getFieldValueForXmlString(91, fieldValue);
/* 340 */             setUpdateDate((Date)value);
/* 341 */           } catch (Exception ee) {
/* 342 */             throw new DtxException("An exception occurred while calling setUpdateDate() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "UpdateUserId":
/*     */           try {
/* 348 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 349 */             setUpdateUserId((String)value);
/* 350 */           } catch (Exception ee) {
/* 351 */             throw new DtxException("An exception occurred while calling setUpdateUserId() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "DocumentId":
/*     */           try {
/* 357 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 358 */             setDocumentId((String)value);
/* 359 */           } catch (Exception ee) {
/* 360 */             throw new DtxException("An exception occurred while calling setDocumentId() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "DocumentTypeCode":
/*     */           try {
/* 366 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 367 */             setDocumentTypeCode((String)value);
/* 368 */           } catch (Exception ee) {
/* 369 */             throw new DtxException("An exception occurred while calling setDocumentTypeCode() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */       } 
/*     */     } 
/*     */   }
/*     */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\trl\impl\InventoryDocumentModifierDAO.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */