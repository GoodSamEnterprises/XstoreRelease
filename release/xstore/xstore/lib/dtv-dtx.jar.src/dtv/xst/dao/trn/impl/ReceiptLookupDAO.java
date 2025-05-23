/*     */ package dtv.xst.dao.trn.impl;
/*     */ 
/*     */ import dtv.data2.access.DaoUtils;
/*     */ import dtv.data2.access.IObjectId;
/*     */ import dtv.data2.access.exception.DtxException;
/*     */ import dtv.data2.access.impl.AbstractDAOImpl;
/*     */ import dtv.util.DtvDate;
/*     */ import dtv.xst.dao.trn.ReceiptLookupId;
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
/*     */ public class ReceiptLookupDAO
/*     */   extends AbstractDAOImpl
/*     */ {
/*     */   private static final long serialVersionUID = 660712882L;
/*  23 */   private static final Logger _logger = Logger.getLogger(ReceiptLookupDAO.class);
/*     */   
/*     */   private Long _organizationId;
/*     */   private Long _retailLocationId;
/*     */   private Long _workstationId;
/*     */   private DtvDate _businessDate;
/*     */   private Long _transactionSequence;
/*     */   private String _receiptId;
/*     */   private DtvDate _createDate;
/*     */   private String _createUserId;
/*     */   private DtvDate _updateDate;
/*     */   private String _updateUserId;
/*     */   private String _receiptUrl;
/*     */   
/*     */   public Long getOrganizationId() {
/*  38 */     return this._organizationId;
/*     */   }
/*     */   
/*     */   public void setOrganizationId(Long argOrganizationId) {
/*  42 */     if (changed(argOrganizationId, this._organizationId, "organizationId")) {
/*  43 */       this._organizationId = argOrganizationId;
/*     */     }
/*     */   }
/*     */   
/*     */   public Long getRetailLocationId() {
/*  48 */     return this._retailLocationId;
/*     */   }
/*     */   
/*     */   public void setRetailLocationId(Long argRetailLocationId) {
/*  52 */     if (changed(argRetailLocationId, this._retailLocationId, "retailLocationId")) {
/*  53 */       this._retailLocationId = argRetailLocationId;
/*     */     }
/*     */   }
/*     */   
/*     */   public Long getWorkstationId() {
/*  58 */     return this._workstationId;
/*     */   }
/*     */   
/*     */   public void setWorkstationId(Long argWorkstationId) {
/*  62 */     if (changed(argWorkstationId, this._workstationId, "workstationId")) {
/*  63 */       this._workstationId = argWorkstationId;
/*     */     }
/*     */   }
/*     */   
/*     */   public Date getBusinessDate() {
/*  68 */     return (Date)this._businessDate;
/*     */   }
/*     */   
/*     */   public void setBusinessDate(Date argBusinessDate) {
/*  72 */     if (changed(argBusinessDate, this._businessDate, "businessDate")) {
/*  73 */       this._businessDate = (argBusinessDate == null || argBusinessDate instanceof DtvDate) ? (DtvDate)argBusinessDate : new DtvDate(argBusinessDate);
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public Long getTransactionSequence() {
/*  79 */     return this._transactionSequence;
/*     */   }
/*     */   
/*     */   public void setTransactionSequence(Long argTransactionSequence) {
/*  83 */     if (changed(argTransactionSequence, this._transactionSequence, "transactionSequence")) {
/*  84 */       this._transactionSequence = argTransactionSequence;
/*     */     }
/*     */   }
/*     */   
/*     */   public String getReceiptId() {
/*  89 */     return this._receiptId;
/*     */   }
/*     */   
/*     */   public void setReceiptId(String argReceiptId) {
/*  93 */     if (changed(argReceiptId, this._receiptId, "receiptId")) {
/*  94 */       this._receiptId = (argReceiptId != null && MANAGE_CASE) ? argReceiptId.toUpperCase() : argReceiptId;
/*     */     }
/*     */   }
/*     */   
/*     */   public Date getCreateDate() {
/*  99 */     return (Date)this._createDate;
/*     */   }
/*     */   
/*     */   public void setCreateDate(Date argCreateDate) {
/* 103 */     if (changed(argCreateDate, this._createDate, "createDate")) {
/* 104 */       this._createDate = (argCreateDate == null || argCreateDate instanceof DtvDate) ? (DtvDate)argCreateDate : new DtvDate(argCreateDate);
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public String getCreateUserId() {
/* 110 */     return this._createUserId;
/*     */   }
/*     */   
/*     */   public void setCreateUserId(String argCreateUserId) {
/* 114 */     if (changed(argCreateUserId, this._createUserId, "createUserId")) {
/* 115 */       this._createUserId = argCreateUserId;
/*     */     }
/*     */   }
/*     */   
/*     */   public Date getUpdateDate() {
/* 120 */     return (Date)this._updateDate;
/*     */   }
/*     */   
/*     */   public void setUpdateDate(Date argUpdateDate) {
/* 124 */     if (changed(argUpdateDate, this._updateDate, "updateDate")) {
/* 125 */       this._updateDate = (argUpdateDate == null || argUpdateDate instanceof DtvDate) ? (DtvDate)argUpdateDate : new DtvDate(argUpdateDate);
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public String getUpdateUserId() {
/* 131 */     return this._updateUserId;
/*     */   }
/*     */   
/*     */   public void setUpdateUserId(String argUpdateUserId) {
/* 135 */     if (changed(argUpdateUserId, this._updateUserId, "updateUserId")) {
/* 136 */       this._updateUserId = argUpdateUserId;
/*     */     }
/*     */   }
/*     */   
/*     */   public String getReceiptUrl() {
/* 141 */     return this._receiptUrl;
/*     */   }
/*     */   
/*     */   public void setReceiptUrl(String argReceiptUrl) {
/* 145 */     if (changed(argReceiptUrl, this._receiptUrl, "receiptUrl")) {
/* 146 */       this._receiptUrl = argReceiptUrl;
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public String toString() {
/* 153 */     StringBuilder buf = new StringBuilder(512);
/* 154 */     buf.append(super.toString()).append(" Id: ").append(getObjectId()).append(" Values: ");
/* 155 */     if (getOrganizationId() != null) {
/* 156 */       buf.append("organizationId").append("=").append(getOrganizationId()).append(" ");
/*     */     }
/* 158 */     if (getRetailLocationId() != null) {
/* 159 */       buf.append("retailLocationId").append("=").append(getRetailLocationId()).append(" ");
/*     */     }
/* 161 */     if (getWorkstationId() != null) {
/* 162 */       buf.append("workstationId").append("=").append(getWorkstationId()).append(" ");
/*     */     }
/* 164 */     if (getBusinessDate() != null) {
/* 165 */       buf.append("businessDate").append("=").append(getBusinessDate()).append(" ");
/*     */     }
/* 167 */     if (getTransactionSequence() != null) {
/* 168 */       buf.append("transactionSequence").append("=").append(getTransactionSequence()).append(" ");
/*     */     }
/* 170 */     if (getReceiptId() != null) {
/* 171 */       buf.append("receiptId").append("=").append(getReceiptId()).append(" ");
/*     */     }
/* 173 */     if (getCreateDate() != null) {
/* 174 */       buf.append("createDate").append("=").append(getCreateDate()).append(" ");
/*     */     }
/* 176 */     if (getCreateUserId() != null) {
/* 177 */       buf.append("createUserId").append("=").append(getCreateUserId()).append(" ");
/*     */     }
/* 179 */     if (getUpdateDate() != null) {
/* 180 */       buf.append("updateDate").append("=").append(getUpdateDate()).append(" ");
/*     */     }
/* 182 */     if (getUpdateUserId() != null) {
/* 183 */       buf.append("updateUserId").append("=").append(getUpdateUserId()).append(" ");
/*     */     }
/* 185 */     if (getReceiptUrl() != null) {
/* 186 */       buf.append("receiptUrl").append("=").append(getReceiptUrl()).append(" ");
/*     */     }
/*     */     
/* 189 */     return buf.toString();
/*     */   }
/*     */   
/*     */   public IObjectId getObjectId() {
/* 193 */     ReceiptLookupId id = new ReceiptLookupId();
/* 194 */     id.setOrganizationId(getOrganizationId());
/* 195 */     id.setRetailLocationId(getRetailLocationId());
/* 196 */     id.setWorkstationId(getWorkstationId());
/* 197 */     id.setBusinessDate(getBusinessDate());
/* 198 */     id.setTransactionSequence(getTransactionSequence());
/* 199 */     id.setReceiptId(getReceiptId());
/* 200 */     return (IObjectId)id;
/*     */   }
/*     */   
/*     */   public void setObjectId(IObjectId argObjectId) {
/* 204 */     setOrganizationId(((ReceiptLookupId)argObjectId).getOrganizationId());
/* 205 */     setRetailLocationId(((ReceiptLookupId)argObjectId).getRetailLocationId());
/* 206 */     setWorkstationId(((ReceiptLookupId)argObjectId).getWorkstationId());
/* 207 */     setBusinessDate(((ReceiptLookupId)argObjectId).getBusinessDate());
/* 208 */     setTransactionSequence(((ReceiptLookupId)argObjectId).getTransactionSequence());
/* 209 */     setReceiptId(((ReceiptLookupId)argObjectId).getReceiptId());
/*     */   }
/*     */   
/*     */   public String getImplementingClass() {
/* 213 */     return null;
/*     */   }
/*     */   
/*     */   public String toXmlString() {
/* 217 */     StringBuilder buf = new StringBuilder(550);
/* 218 */     buf.append("<").append("dao").append(" name=\"ReceiptLookup\" cmd=\"" + getObjectStateString() + "\">");
/* 219 */     getFieldsAsXml(buf);
/* 220 */     buf.append("</").append("dao").append(">");
/*     */     
/* 222 */     return buf.toString();
/*     */   }
/*     */   
/*     */   public Map<String, String> getValues() {
/* 226 */     Map<String, String> values = super.getValues();
/* 227 */     if (this._organizationId != null) values.put("OrganizationId", DaoUtils.getXmlSafeFieldValue(-5, this._organizationId)); 
/* 228 */     if (this._retailLocationId != null) values.put("RetailLocationId", DaoUtils.getXmlSafeFieldValue(-5, this._retailLocationId)); 
/* 229 */     if (this._workstationId != null) values.put("WorkstationId", DaoUtils.getXmlSafeFieldValue(-5, this._workstationId)); 
/* 230 */     if (this._businessDate != null) values.put("BusinessDate", DaoUtils.getXmlSafeFieldValue(91, this._businessDate)); 
/* 231 */     if (this._transactionSequence != null) values.put("TransactionSequence", DaoUtils.getXmlSafeFieldValue(-5, this._transactionSequence)); 
/* 232 */     if (this._receiptId != null) values.put("ReceiptId", DaoUtils.getXmlSafeFieldValue(12, this._receiptId)); 
/* 233 */     if (this._createDate != null) values.put("CreateDate", DaoUtils.getXmlSafeFieldValue(91, this._createDate)); 
/* 234 */     if (this._createUserId != null) values.put("CreateUserId", DaoUtils.getXmlSafeFieldValue(12, this._createUserId)); 
/* 235 */     if (this._updateDate != null) values.put("UpdateDate", DaoUtils.getXmlSafeFieldValue(91, this._updateDate)); 
/* 236 */     if (this._updateUserId != null) values.put("UpdateUserId", DaoUtils.getXmlSafeFieldValue(12, this._updateUserId)); 
/* 237 */     if (this._receiptUrl != null) values.put("ReceiptUrl", DaoUtils.getXmlSafeFieldValue(12, this._receiptUrl)); 
/* 238 */     return values;
/*     */   }
/*     */ 
/*     */   
/*     */   public void setValues(Map<String, String> argValues) {
/* 243 */     super.setValues(argValues);
/* 244 */     for (Map.Entry<String, String> field : argValues.entrySet()) {
/*     */       
/* 246 */       String fieldName = field.getKey();
/* 247 */       String fieldValue = field.getValue();
/* 248 */       switch (fieldName) {
/*     */         
/*     */         case "OrganizationId":
/*     */           try {
/* 252 */             Object value = DaoUtils.getFieldValueForXmlString(-5, fieldValue);
/* 253 */             setOrganizationId((Long)value);
/* 254 */           } catch (Exception ee) {
/* 255 */             throw new DtxException("An exception occurred while calling setOrganizationId() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "RetailLocationId":
/*     */           try {
/* 261 */             Object value = DaoUtils.getFieldValueForXmlString(-5, fieldValue);
/* 262 */             setRetailLocationId((Long)value);
/* 263 */           } catch (Exception ee) {
/* 264 */             throw new DtxException("An exception occurred while calling setRetailLocationId() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "WorkstationId":
/*     */           try {
/* 270 */             Object value = DaoUtils.getFieldValueForXmlString(-5, fieldValue);
/* 271 */             setWorkstationId((Long)value);
/* 272 */           } catch (Exception ee) {
/* 273 */             throw new DtxException("An exception occurred while calling setWorkstationId() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "BusinessDate":
/*     */           try {
/* 279 */             Object value = DaoUtils.getFieldValueForXmlString(91, fieldValue);
/* 280 */             setBusinessDate((Date)value);
/* 281 */           } catch (Exception ee) {
/* 282 */             throw new DtxException("An exception occurred while calling setBusinessDate() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "TransactionSequence":
/*     */           try {
/* 288 */             Object value = DaoUtils.getFieldValueForXmlString(-5, fieldValue);
/* 289 */             setTransactionSequence((Long)value);
/* 290 */           } catch (Exception ee) {
/* 291 */             throw new DtxException("An exception occurred while calling setTransactionSequence() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "ReceiptId":
/*     */           try {
/* 297 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 298 */             setReceiptId((String)value);
/* 299 */           } catch (Exception ee) {
/* 300 */             throw new DtxException("An exception occurred while calling setReceiptId() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "CreateDate":
/*     */           try {
/* 306 */             Object value = DaoUtils.getFieldValueForXmlString(91, fieldValue);
/* 307 */             setCreateDate((Date)value);
/* 308 */           } catch (Exception ee) {
/* 309 */             throw new DtxException("An exception occurred while calling setCreateDate() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "CreateUserId":
/*     */           try {
/* 315 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 316 */             setCreateUserId((String)value);
/* 317 */           } catch (Exception ee) {
/* 318 */             throw new DtxException("An exception occurred while calling setCreateUserId() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "UpdateDate":
/*     */           try {
/* 324 */             Object value = DaoUtils.getFieldValueForXmlString(91, fieldValue);
/* 325 */             setUpdateDate((Date)value);
/* 326 */           } catch (Exception ee) {
/* 327 */             throw new DtxException("An exception occurred while calling setUpdateDate() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "UpdateUserId":
/*     */           try {
/* 333 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 334 */             setUpdateUserId((String)value);
/* 335 */           } catch (Exception ee) {
/* 336 */             throw new DtxException("An exception occurred while calling setUpdateUserId() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "ReceiptUrl":
/*     */           try {
/* 342 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 343 */             setReceiptUrl((String)value);
/* 344 */           } catch (Exception ee) {
/* 345 */             throw new DtxException("An exception occurred while calling setReceiptUrl() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */       } 
/*     */     } 
/*     */   }
/*     */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\trn\impl\ReceiptLookupDAO.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */