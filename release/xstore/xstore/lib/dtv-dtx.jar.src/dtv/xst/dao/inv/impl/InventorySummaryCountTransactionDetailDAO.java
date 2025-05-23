/*     */ package dtv.xst.dao.inv.impl;
/*     */ 
/*     */ import dtv.data2.access.DaoUtils;
/*     */ import dtv.data2.access.IObjectId;
/*     */ import dtv.data2.access.exception.DtxException;
/*     */ import dtv.data2.access.impl.AbstractDAOImpl;
/*     */ import dtv.util.DtvDate;
/*     */ import dtv.xst.dao.inv.InventorySummaryCountTransactionDetailId;
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
/*     */ public class InventorySummaryCountTransactionDetailDAO
/*     */   extends AbstractDAOImpl
/*     */ {
/*     */   private static final long serialVersionUID = -1159165206L;
/*  23 */   private static final Logger _logger = Logger.getLogger(InventorySummaryCountTransactionDetailDAO.class);
/*     */   
/*     */   private Long _organizationId;
/*     */   private Long _retailLocationId;
/*     */   private Long _workstationId;
/*     */   private DtvDate _businessDate;
/*     */   private Long _transactionSequence;
/*     */   private Integer _transLineSequence;
/*     */   private DtvDate _createDate;
/*     */   private String _createUserId;
/*     */   private DtvDate _updateDate;
/*     */   private String _updateUserId;
/*     */   private String _locationId;
/*     */   private String _bucketId;
/*     */   private BigDecimal _systemCount;
/*     */   private BigDecimal _declaredCount;
/*     */   
/*     */   public Long getOrganizationId() {
/*  41 */     return this._organizationId;
/*     */   }
/*     */   
/*     */   public void setOrganizationId(Long argOrganizationId) {
/*  45 */     if (changed(argOrganizationId, this._organizationId, "organizationId")) {
/*  46 */       this._organizationId = argOrganizationId;
/*     */     }
/*     */   }
/*     */   
/*     */   public Long getRetailLocationId() {
/*  51 */     return this._retailLocationId;
/*     */   }
/*     */   
/*     */   public void setRetailLocationId(Long argRetailLocationId) {
/*  55 */     if (changed(argRetailLocationId, this._retailLocationId, "retailLocationId")) {
/*  56 */       this._retailLocationId = argRetailLocationId;
/*     */     }
/*     */   }
/*     */   
/*     */   public Long getWorkstationId() {
/*  61 */     return this._workstationId;
/*     */   }
/*     */   
/*     */   public void setWorkstationId(Long argWorkstationId) {
/*  65 */     if (changed(argWorkstationId, this._workstationId, "workstationId")) {
/*  66 */       this._workstationId = argWorkstationId;
/*     */     }
/*     */   }
/*     */   
/*     */   public Date getBusinessDate() {
/*  71 */     return (Date)this._businessDate;
/*     */   }
/*     */   
/*     */   public void setBusinessDate(Date argBusinessDate) {
/*  75 */     if (changed(argBusinessDate, this._businessDate, "businessDate")) {
/*  76 */       this._businessDate = (argBusinessDate == null || argBusinessDate instanceof DtvDate) ? (DtvDate)argBusinessDate : new DtvDate(argBusinessDate);
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public Long getTransactionSequence() {
/*  82 */     return this._transactionSequence;
/*     */   }
/*     */   
/*     */   public void setTransactionSequence(Long argTransactionSequence) {
/*  86 */     if (changed(argTransactionSequence, this._transactionSequence, "transactionSequence")) {
/*  87 */       this._transactionSequence = argTransactionSequence;
/*     */     }
/*     */   }
/*     */   
/*     */   public Integer getTransLineSequence() {
/*  92 */     return this._transLineSequence;
/*     */   }
/*     */   
/*     */   public void setTransLineSequence(Integer argTransLineSequence) {
/*  96 */     if (changed(argTransLineSequence, this._transLineSequence, "transLineSequence")) {
/*  97 */       this._transLineSequence = argTransLineSequence;
/*     */     }
/*     */   }
/*     */   
/*     */   public Date getCreateDate() {
/* 102 */     return (Date)this._createDate;
/*     */   }
/*     */   
/*     */   public void setCreateDate(Date argCreateDate) {
/* 106 */     if (changed(argCreateDate, this._createDate, "createDate")) {
/* 107 */       this._createDate = (argCreateDate == null || argCreateDate instanceof DtvDate) ? (DtvDate)argCreateDate : new DtvDate(argCreateDate);
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public String getCreateUserId() {
/* 113 */     return this._createUserId;
/*     */   }
/*     */   
/*     */   public void setCreateUserId(String argCreateUserId) {
/* 117 */     if (changed(argCreateUserId, this._createUserId, "createUserId")) {
/* 118 */       this._createUserId = argCreateUserId;
/*     */     }
/*     */   }
/*     */   
/*     */   public Date getUpdateDate() {
/* 123 */     return (Date)this._updateDate;
/*     */   }
/*     */   
/*     */   public void setUpdateDate(Date argUpdateDate) {
/* 127 */     if (changed(argUpdateDate, this._updateDate, "updateDate")) {
/* 128 */       this._updateDate = (argUpdateDate == null || argUpdateDate instanceof DtvDate) ? (DtvDate)argUpdateDate : new DtvDate(argUpdateDate);
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public String getUpdateUserId() {
/* 134 */     return this._updateUserId;
/*     */   }
/*     */   
/*     */   public void setUpdateUserId(String argUpdateUserId) {
/* 138 */     if (changed(argUpdateUserId, this._updateUserId, "updateUserId")) {
/* 139 */       this._updateUserId = argUpdateUserId;
/*     */     }
/*     */   }
/*     */   
/*     */   public String getLocationId() {
/* 144 */     return this._locationId;
/*     */   }
/*     */   
/*     */   public void setLocationId(String argLocationId) {
/* 148 */     if (changed(argLocationId, this._locationId, "locationId")) {
/* 149 */       this._locationId = argLocationId;
/*     */     }
/*     */   }
/*     */   
/*     */   public String getBucketId() {
/* 154 */     return this._bucketId;
/*     */   }
/*     */   
/*     */   public void setBucketId(String argBucketId) {
/* 158 */     if (changed(argBucketId, this._bucketId, "bucketId")) {
/* 159 */       this._bucketId = argBucketId;
/*     */     }
/*     */   }
/*     */   
/*     */   public BigDecimal getSystemCount() {
/* 164 */     return this._systemCount;
/*     */   }
/*     */   
/*     */   public void setSystemCount(BigDecimal argSystemCount) {
/* 168 */     if (changed(argSystemCount, this._systemCount, "systemCount")) {
/* 169 */       this._systemCount = argSystemCount;
/*     */     }
/*     */   }
/*     */   
/*     */   public BigDecimal getDeclaredCount() {
/* 174 */     return this._declaredCount;
/*     */   }
/*     */   
/*     */   public void setDeclaredCount(BigDecimal argDeclaredCount) {
/* 178 */     if (changed(argDeclaredCount, this._declaredCount, "declaredCount")) {
/* 179 */       this._declaredCount = argDeclaredCount;
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public String toString() {
/* 186 */     StringBuilder buf = new StringBuilder(512);
/* 187 */     buf.append(super.toString()).append(" Id: ").append(getObjectId()).append(" Values: ");
/* 188 */     if (getOrganizationId() != null) {
/* 189 */       buf.append("organizationId").append("=").append(getOrganizationId()).append(" ");
/*     */     }
/* 191 */     if (getRetailLocationId() != null) {
/* 192 */       buf.append("retailLocationId").append("=").append(getRetailLocationId()).append(" ");
/*     */     }
/* 194 */     if (getWorkstationId() != null) {
/* 195 */       buf.append("workstationId").append("=").append(getWorkstationId()).append(" ");
/*     */     }
/* 197 */     if (getBusinessDate() != null) {
/* 198 */       buf.append("businessDate").append("=").append(getBusinessDate()).append(" ");
/*     */     }
/* 200 */     if (getTransactionSequence() != null) {
/* 201 */       buf.append("transactionSequence").append("=").append(getTransactionSequence()).append(" ");
/*     */     }
/* 203 */     if (getTransLineSequence() != null) {
/* 204 */       buf.append("transLineSequence").append("=").append(getTransLineSequence()).append(" ");
/*     */     }
/* 206 */     if (getCreateDate() != null) {
/* 207 */       buf.append("createDate").append("=").append(getCreateDate()).append(" ");
/*     */     }
/* 209 */     if (getCreateUserId() != null) {
/* 210 */       buf.append("createUserId").append("=").append(getCreateUserId()).append(" ");
/*     */     }
/* 212 */     if (getUpdateDate() != null) {
/* 213 */       buf.append("updateDate").append("=").append(getUpdateDate()).append(" ");
/*     */     }
/* 215 */     if (getUpdateUserId() != null) {
/* 216 */       buf.append("updateUserId").append("=").append(getUpdateUserId()).append(" ");
/*     */     }
/* 218 */     if (getLocationId() != null) {
/* 219 */       buf.append("locationId").append("=").append(getLocationId()).append(" ");
/*     */     }
/* 221 */     if (getBucketId() != null) {
/* 222 */       buf.append("bucketId").append("=").append(getBucketId()).append(" ");
/*     */     }
/* 224 */     if (getSystemCount() != null) {
/* 225 */       buf.append("systemCount").append("=").append(getSystemCount()).append(" ");
/*     */     }
/* 227 */     if (getDeclaredCount() != null) {
/* 228 */       buf.append("declaredCount").append("=").append(getDeclaredCount()).append(" ");
/*     */     }
/*     */     
/* 231 */     return buf.toString();
/*     */   }
/*     */   
/*     */   public IObjectId getObjectId() {
/* 235 */     InventorySummaryCountTransactionDetailId id = new InventorySummaryCountTransactionDetailId();
/* 236 */     id.setOrganizationId(getOrganizationId());
/* 237 */     id.setRetailLocationId(getRetailLocationId());
/* 238 */     id.setWorkstationId(getWorkstationId());
/* 239 */     id.setBusinessDate(getBusinessDate());
/* 240 */     id.setTransactionSequence(getTransactionSequence());
/* 241 */     id.setTransLineSequence(getTransLineSequence());
/* 242 */     return (IObjectId)id;
/*     */   }
/*     */   
/*     */   public void setObjectId(IObjectId argObjectId) {
/* 246 */     setOrganizationId(((InventorySummaryCountTransactionDetailId)argObjectId).getOrganizationId());
/* 247 */     setRetailLocationId(((InventorySummaryCountTransactionDetailId)argObjectId).getRetailLocationId());
/* 248 */     setWorkstationId(((InventorySummaryCountTransactionDetailId)argObjectId).getWorkstationId());
/* 249 */     setBusinessDate(((InventorySummaryCountTransactionDetailId)argObjectId).getBusinessDate());
/* 250 */     setTransactionSequence(((InventorySummaryCountTransactionDetailId)argObjectId).getTransactionSequence());
/* 251 */     setTransLineSequence(((InventorySummaryCountTransactionDetailId)argObjectId).getTransLineSequence());
/*     */   }
/*     */   
/*     */   public String getImplementingClass() {
/* 255 */     return null;
/*     */   }
/*     */   
/*     */   public String toXmlString() {
/* 259 */     StringBuilder buf = new StringBuilder(700);
/* 260 */     buf.append("<").append("dao").append(" name=\"InventorySummaryCountTransactionDetail\" cmd=\"" + getObjectStateString() + "\">");
/* 261 */     getFieldsAsXml(buf);
/* 262 */     buf.append("</").append("dao").append(">");
/*     */     
/* 264 */     return buf.toString();
/*     */   }
/*     */   
/*     */   public Map<String, String> getValues() {
/* 268 */     Map<String, String> values = super.getValues();
/* 269 */     if (this._organizationId != null) values.put("OrganizationId", DaoUtils.getXmlSafeFieldValue(-5, this._organizationId)); 
/* 270 */     if (this._retailLocationId != null) values.put("RetailLocationId", DaoUtils.getXmlSafeFieldValue(-5, this._retailLocationId)); 
/* 271 */     if (this._workstationId != null) values.put("WorkstationId", DaoUtils.getXmlSafeFieldValue(-5, this._workstationId)); 
/* 272 */     if (this._businessDate != null) values.put("BusinessDate", DaoUtils.getXmlSafeFieldValue(91, this._businessDate)); 
/* 273 */     if (this._transactionSequence != null) values.put("TransactionSequence", DaoUtils.getXmlSafeFieldValue(-5, this._transactionSequence)); 
/* 274 */     if (this._transLineSequence != null) values.put("TransLineSequence", DaoUtils.getXmlSafeFieldValue(4, this._transLineSequence)); 
/* 275 */     if (this._createDate != null) values.put("CreateDate", DaoUtils.getXmlSafeFieldValue(91, this._createDate)); 
/* 276 */     if (this._createUserId != null) values.put("CreateUserId", DaoUtils.getXmlSafeFieldValue(12, this._createUserId)); 
/* 277 */     if (this._updateDate != null) values.put("UpdateDate", DaoUtils.getXmlSafeFieldValue(91, this._updateDate)); 
/* 278 */     if (this._updateUserId != null) values.put("UpdateUserId", DaoUtils.getXmlSafeFieldValue(12, this._updateUserId)); 
/* 279 */     if (this._locationId != null) values.put("LocationId", DaoUtils.getXmlSafeFieldValue(12, this._locationId)); 
/* 280 */     if (this._bucketId != null) values.put("BucketId", DaoUtils.getXmlSafeFieldValue(12, this._bucketId)); 
/* 281 */     if (this._systemCount != null) values.put("SystemCount", DaoUtils.getXmlSafeFieldValue(3, this._systemCount)); 
/* 282 */     if (this._declaredCount != null) values.put("DeclaredCount", DaoUtils.getXmlSafeFieldValue(3, this._declaredCount)); 
/* 283 */     return values;
/*     */   }
/*     */ 
/*     */   
/*     */   public void setValues(Map<String, String> argValues) {
/* 288 */     super.setValues(argValues);
/* 289 */     for (Map.Entry<String, String> field : argValues.entrySet()) {
/*     */       
/* 291 */       String fieldName = field.getKey();
/* 292 */       String fieldValue = field.getValue();
/* 293 */       switch (fieldName) {
/*     */         
/*     */         case "OrganizationId":
/*     */           try {
/* 297 */             Object value = DaoUtils.getFieldValueForXmlString(-5, fieldValue);
/* 298 */             setOrganizationId((Long)value);
/* 299 */           } catch (Exception ee) {
/* 300 */             throw new DtxException("An exception occurred while calling setOrganizationId() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "RetailLocationId":
/*     */           try {
/* 306 */             Object value = DaoUtils.getFieldValueForXmlString(-5, fieldValue);
/* 307 */             setRetailLocationId((Long)value);
/* 308 */           } catch (Exception ee) {
/* 309 */             throw new DtxException("An exception occurred while calling setRetailLocationId() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "WorkstationId":
/*     */           try {
/* 315 */             Object value = DaoUtils.getFieldValueForXmlString(-5, fieldValue);
/* 316 */             setWorkstationId((Long)value);
/* 317 */           } catch (Exception ee) {
/* 318 */             throw new DtxException("An exception occurred while calling setWorkstationId() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "BusinessDate":
/*     */           try {
/* 324 */             Object value = DaoUtils.getFieldValueForXmlString(91, fieldValue);
/* 325 */             setBusinessDate((Date)value);
/* 326 */           } catch (Exception ee) {
/* 327 */             throw new DtxException("An exception occurred while calling setBusinessDate() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "TransactionSequence":
/*     */           try {
/* 333 */             Object value = DaoUtils.getFieldValueForXmlString(-5, fieldValue);
/* 334 */             setTransactionSequence((Long)value);
/* 335 */           } catch (Exception ee) {
/* 336 */             throw new DtxException("An exception occurred while calling setTransactionSequence() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "TransLineSequence":
/*     */           try {
/* 342 */             Object value = DaoUtils.getFieldValueForXmlString(4, fieldValue);
/* 343 */             setTransLineSequence((Integer)value);
/* 344 */           } catch (Exception ee) {
/* 345 */             throw new DtxException("An exception occurred while calling setTransLineSequence() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "CreateDate":
/*     */           try {
/* 351 */             Object value = DaoUtils.getFieldValueForXmlString(91, fieldValue);
/* 352 */             setCreateDate((Date)value);
/* 353 */           } catch (Exception ee) {
/* 354 */             throw new DtxException("An exception occurred while calling setCreateDate() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "CreateUserId":
/*     */           try {
/* 360 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 361 */             setCreateUserId((String)value);
/* 362 */           } catch (Exception ee) {
/* 363 */             throw new DtxException("An exception occurred while calling setCreateUserId() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "UpdateDate":
/*     */           try {
/* 369 */             Object value = DaoUtils.getFieldValueForXmlString(91, fieldValue);
/* 370 */             setUpdateDate((Date)value);
/* 371 */           } catch (Exception ee) {
/* 372 */             throw new DtxException("An exception occurred while calling setUpdateDate() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "UpdateUserId":
/*     */           try {
/* 378 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 379 */             setUpdateUserId((String)value);
/* 380 */           } catch (Exception ee) {
/* 381 */             throw new DtxException("An exception occurred while calling setUpdateUserId() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "LocationId":
/*     */           try {
/* 387 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 388 */             setLocationId((String)value);
/* 389 */           } catch (Exception ee) {
/* 390 */             throw new DtxException("An exception occurred while calling setLocationId() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "BucketId":
/*     */           try {
/* 396 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 397 */             setBucketId((String)value);
/* 398 */           } catch (Exception ee) {
/* 399 */             throw new DtxException("An exception occurred while calling setBucketId() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "SystemCount":
/*     */           try {
/* 405 */             Object value = DaoUtils.getFieldValueForXmlString(3, fieldValue);
/* 406 */             setSystemCount((BigDecimal)value);
/* 407 */           } catch (Exception ee) {
/* 408 */             throw new DtxException("An exception occurred while calling setSystemCount() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "DeclaredCount":
/*     */           try {
/* 414 */             Object value = DaoUtils.getFieldValueForXmlString(3, fieldValue);
/* 415 */             setDeclaredCount((BigDecimal)value);
/* 416 */           } catch (Exception ee) {
/* 417 */             throw new DtxException("An exception occurred while calling setDeclaredCount() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */       } 
/*     */     } 
/*     */   }
/*     */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\inv\impl\InventorySummaryCountTransactionDetailDAO.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */