/*     */ package dtv.xst.dao.trn.impl;
/*     */ 
/*     */ import dtv.data2.access.DaoUtils;
/*     */ import dtv.data2.access.IObjectId;
/*     */ import dtv.data2.access.exception.DtxException;
/*     */ import dtv.data2.access.impl.AbstractDAOImpl;
/*     */ import dtv.util.DtvDate;
/*     */ import dtv.xst.dao.trn.LineItemGenericStorageId;
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
/*     */ public class LineItemGenericStorageDAO
/*     */   extends AbstractDAOImpl
/*     */ {
/*     */   private static final long serialVersionUID = 608488907L;
/*  23 */   private static final Logger _logger = Logger.getLogger(LineItemGenericStorageDAO.class);
/*     */   
/*     */   private DtvDate _businessDate;
/*     */   private Long _organizationId;
/*     */   private Long _retailLocationId;
/*     */   private Integer _lineItemSequence;
/*     */   private Long _transactionSequence;
/*     */   private Long _workstationId;
/*     */   private DtvDate _createDate;
/*     */   private String _createUserId;
/*     */   private DtvDate _updateDate;
/*     */   private String _updateUserId;
/*     */   private String _dataStorage;
/*     */   
/*     */   public Date getBusinessDate() {
/*  38 */     return (Date)this._businessDate;
/*     */   }
/*     */   
/*     */   public void setBusinessDate(Date argBusinessDate) {
/*  42 */     if (changed(argBusinessDate, this._businessDate, "businessDate")) {
/*  43 */       this._businessDate = (argBusinessDate == null || argBusinessDate instanceof DtvDate) ? (DtvDate)argBusinessDate : new DtvDate(argBusinessDate);
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public Long getOrganizationId() {
/*  49 */     return this._organizationId;
/*     */   }
/*     */   
/*     */   public void setOrganizationId(Long argOrganizationId) {
/*  53 */     if (changed(argOrganizationId, this._organizationId, "organizationId")) {
/*  54 */       this._organizationId = argOrganizationId;
/*     */     }
/*     */   }
/*     */   
/*     */   public Long getRetailLocationId() {
/*  59 */     return this._retailLocationId;
/*     */   }
/*     */   
/*     */   public void setRetailLocationId(Long argRetailLocationId) {
/*  63 */     if (changed(argRetailLocationId, this._retailLocationId, "retailLocationId")) {
/*  64 */       this._retailLocationId = argRetailLocationId;
/*     */     }
/*     */   }
/*     */   
/*     */   public Integer getLineItemSequence() {
/*  69 */     return this._lineItemSequence;
/*     */   }
/*     */   
/*     */   public void setLineItemSequence(Integer argLineItemSequence) {
/*  73 */     if (changed(argLineItemSequence, this._lineItemSequence, "lineItemSequence")) {
/*  74 */       this._lineItemSequence = argLineItemSequence;
/*     */     }
/*     */   }
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
/*     */   public Long getWorkstationId() {
/*  89 */     return this._workstationId;
/*     */   }
/*     */   
/*     */   public void setWorkstationId(Long argWorkstationId) {
/*  93 */     if (changed(argWorkstationId, this._workstationId, "workstationId")) {
/*  94 */       this._workstationId = argWorkstationId;
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
/*     */   public String getDataStorage() {
/* 141 */     return this._dataStorage;
/*     */   }
/*     */   
/*     */   public void setDataStorage(String argDataStorage) {
/* 145 */     if (changed(argDataStorage, this._dataStorage, "dataStorage")) {
/* 146 */       this._dataStorage = argDataStorage;
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public String toString() {
/* 153 */     StringBuilder buf = new StringBuilder(512);
/* 154 */     buf.append(super.toString()).append(" Id: ").append(getObjectId()).append(" Values: ");
/* 155 */     if (getBusinessDate() != null) {
/* 156 */       buf.append("businessDate").append("=").append(getBusinessDate()).append(" ");
/*     */     }
/* 158 */     if (getOrganizationId() != null) {
/* 159 */       buf.append("organizationId").append("=").append(getOrganizationId()).append(" ");
/*     */     }
/* 161 */     if (getRetailLocationId() != null) {
/* 162 */       buf.append("retailLocationId").append("=").append(getRetailLocationId()).append(" ");
/*     */     }
/* 164 */     if (getLineItemSequence() != null) {
/* 165 */       buf.append("lineItemSequence").append("=").append(getLineItemSequence()).append(" ");
/*     */     }
/* 167 */     if (getTransactionSequence() != null) {
/* 168 */       buf.append("transactionSequence").append("=").append(getTransactionSequence()).append(" ");
/*     */     }
/* 170 */     if (getWorkstationId() != null) {
/* 171 */       buf.append("workstationId").append("=").append(getWorkstationId()).append(" ");
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
/* 185 */     if (getDataStorage() != null) {
/* 186 */       buf.append("dataStorage").append("=").append(getDataStorage()).append(" ");
/*     */     }
/*     */     
/* 189 */     return buf.toString();
/*     */   }
/*     */   
/*     */   public IObjectId getObjectId() {
/* 193 */     LineItemGenericStorageId id = new LineItemGenericStorageId();
/* 194 */     id.setBusinessDate(getBusinessDate());
/* 195 */     id.setOrganizationId(getOrganizationId());
/* 196 */     id.setRetailLocationId(getRetailLocationId());
/* 197 */     id.setLineItemSequence(getLineItemSequence());
/* 198 */     id.setTransactionSequence(getTransactionSequence());
/* 199 */     id.setWorkstationId(getWorkstationId());
/* 200 */     return (IObjectId)id;
/*     */   }
/*     */   
/*     */   public void setObjectId(IObjectId argObjectId) {
/* 204 */     setBusinessDate(((LineItemGenericStorageId)argObjectId).getBusinessDate());
/* 205 */     setOrganizationId(((LineItemGenericStorageId)argObjectId).getOrganizationId());
/* 206 */     setRetailLocationId(((LineItemGenericStorageId)argObjectId).getRetailLocationId());
/* 207 */     setLineItemSequence(((LineItemGenericStorageId)argObjectId).getLineItemSequence());
/* 208 */     setTransactionSequence(((LineItemGenericStorageId)argObjectId).getTransactionSequence());
/* 209 */     setWorkstationId(((LineItemGenericStorageId)argObjectId).getWorkstationId());
/*     */   }
/*     */   
/*     */   public String getImplementingClass() {
/* 213 */     return null;
/*     */   }
/*     */   
/*     */   public String toXmlString() {
/* 217 */     StringBuilder buf = new StringBuilder(550);
/* 218 */     buf.append("<").append("dao").append(" name=\"LineItemGenericStorage\" cmd=\"" + getObjectStateString() + "\">");
/* 219 */     getFieldsAsXml(buf);
/* 220 */     buf.append("</").append("dao").append(">");
/*     */     
/* 222 */     return buf.toString();
/*     */   }
/*     */   
/*     */   public Map<String, String> getValues() {
/* 226 */     Map<String, String> values = super.getValues();
/* 227 */     if (this._businessDate != null) values.put("BusinessDate", DaoUtils.getXmlSafeFieldValue(91, this._businessDate)); 
/* 228 */     if (this._organizationId != null) values.put("OrganizationId", DaoUtils.getXmlSafeFieldValue(-5, this._organizationId)); 
/* 229 */     if (this._retailLocationId != null) values.put("RetailLocationId", DaoUtils.getXmlSafeFieldValue(-5, this._retailLocationId)); 
/* 230 */     if (this._lineItemSequence != null) values.put("LineItemSequence", DaoUtils.getXmlSafeFieldValue(4, this._lineItemSequence)); 
/* 231 */     if (this._transactionSequence != null) values.put("TransactionSequence", DaoUtils.getXmlSafeFieldValue(-5, this._transactionSequence)); 
/* 232 */     if (this._workstationId != null) values.put("WorkstationId", DaoUtils.getXmlSafeFieldValue(-5, this._workstationId)); 
/* 233 */     if (this._createDate != null) values.put("CreateDate", DaoUtils.getXmlSafeFieldValue(91, this._createDate)); 
/* 234 */     if (this._createUserId != null) values.put("CreateUserId", DaoUtils.getXmlSafeFieldValue(12, this._createUserId)); 
/* 235 */     if (this._updateDate != null) values.put("UpdateDate", DaoUtils.getXmlSafeFieldValue(91, this._updateDate)); 
/* 236 */     if (this._updateUserId != null) values.put("UpdateUserId", DaoUtils.getXmlSafeFieldValue(12, this._updateUserId)); 
/* 237 */     if (this._dataStorage != null) values.put("DataStorage", DaoUtils.getXmlSafeFieldValue(2005, this._dataStorage)); 
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
/*     */         case "BusinessDate":
/*     */           try {
/* 252 */             Object value = DaoUtils.getFieldValueForXmlString(91, fieldValue);
/* 253 */             setBusinessDate((Date)value);
/* 254 */           } catch (Exception ee) {
/* 255 */             throw new DtxException("An exception occurred while calling setBusinessDate() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "OrganizationId":
/*     */           try {
/* 261 */             Object value = DaoUtils.getFieldValueForXmlString(-5, fieldValue);
/* 262 */             setOrganizationId((Long)value);
/* 263 */           } catch (Exception ee) {
/* 264 */             throw new DtxException("An exception occurred while calling setOrganizationId() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "RetailLocationId":
/*     */           try {
/* 270 */             Object value = DaoUtils.getFieldValueForXmlString(-5, fieldValue);
/* 271 */             setRetailLocationId((Long)value);
/* 272 */           } catch (Exception ee) {
/* 273 */             throw new DtxException("An exception occurred while calling setRetailLocationId() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "LineItemSequence":
/*     */           try {
/* 279 */             Object value = DaoUtils.getFieldValueForXmlString(4, fieldValue);
/* 280 */             setLineItemSequence((Integer)value);
/* 281 */           } catch (Exception ee) {
/* 282 */             throw new DtxException("An exception occurred while calling setLineItemSequence() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
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
/*     */         case "WorkstationId":
/*     */           try {
/* 297 */             Object value = DaoUtils.getFieldValueForXmlString(-5, fieldValue);
/* 298 */             setWorkstationId((Long)value);
/* 299 */           } catch (Exception ee) {
/* 300 */             throw new DtxException("An exception occurred while calling setWorkstationId() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
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
/*     */         case "DataStorage":
/*     */           try {
/* 342 */             Object value = DaoUtils.getFieldValueForXmlString(2005, fieldValue);
/* 343 */             setDataStorage((String)value);
/* 344 */           } catch (Exception ee) {
/* 345 */             throw new DtxException("An exception occurred while calling setDataStorage() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */       } 
/*     */     } 
/*     */   }
/*     */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\trn\impl\LineItemGenericStorageDAO.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */