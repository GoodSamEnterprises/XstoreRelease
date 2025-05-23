/*     */ package dtv.xst.dao.inv.impl;
/*     */ 
/*     */ import dtv.data2.access.DaoUtils;
/*     */ import dtv.data2.access.IObjectId;
/*     */ import dtv.data2.access.exception.DtxException;
/*     */ import dtv.data2.access.impl.AbstractDAOImpl;
/*     */ import dtv.util.DtvDate;
/*     */ import dtv.xst.dao.inv.InventoryDocumentCrossReferenceId;
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
/*     */ public class InventoryDocumentCrossReferenceDAO
/*     */   extends AbstractDAOImpl
/*     */ {
/*     */   private static final long serialVersionUID = -683921086L;
/*  23 */   private static final Logger _logger = Logger.getLogger(InventoryDocumentCrossReferenceDAO.class);
/*     */   
/*     */   private Long _organizationId;
/*     */   private String _documentId;
/*     */   private Integer _inventoryDocumentLineNumber;
/*     */   private String _documentTypeCode;
/*     */   private Long _retailLocationId;
/*     */   private DtvDate _createDate;
/*     */   private String _createUserId;
/*     */   private DtvDate _updateDate;
/*     */   private String _updateUserId;
/*     */   private Long _crossRefOrganizationId;
/*     */   private String _crossRefDocumentId;
/*     */   private Integer _crossRefLineNumber;
/*     */   private String _crossRefDocumentTypeCode;
/*     */   private Long _crossRefRetailLocationId;
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
/*     */   public String getDocumentId() {
/*  51 */     return this._documentId;
/*     */   }
/*     */   
/*     */   public void setDocumentId(String argDocumentId) {
/*  55 */     if (changed(argDocumentId, this._documentId, "documentId")) {
/*  56 */       this._documentId = (argDocumentId != null && MANAGE_CASE) ? argDocumentId.toUpperCase() : argDocumentId;
/*     */     }
/*     */   }
/*     */   
/*     */   public Integer getInventoryDocumentLineNumber() {
/*  61 */     return this._inventoryDocumentLineNumber;
/*     */   }
/*     */   
/*     */   public void setInventoryDocumentLineNumber(Integer argInventoryDocumentLineNumber) {
/*  65 */     if (changed(argInventoryDocumentLineNumber, this._inventoryDocumentLineNumber, "inventoryDocumentLineNumber")) {
/*  66 */       this._inventoryDocumentLineNumber = argInventoryDocumentLineNumber;
/*     */     }
/*     */   }
/*     */   
/*     */   public String getDocumentTypeCode() {
/*  71 */     return this._documentTypeCode;
/*     */   }
/*     */   
/*     */   public void setDocumentTypeCode(String argDocumentTypeCode) {
/*  75 */     if (changed(argDocumentTypeCode, this._documentTypeCode, "documentTypeCode")) {
/*  76 */       this._documentTypeCode = (argDocumentTypeCode != null && MANAGE_CASE) ? argDocumentTypeCode.toUpperCase() : argDocumentTypeCode;
/*     */     }
/*     */   }
/*     */   
/*     */   public Long getRetailLocationId() {
/*  81 */     return this._retailLocationId;
/*     */   }
/*     */   
/*     */   public void setRetailLocationId(Long argRetailLocationId) {
/*  85 */     if (changed(argRetailLocationId, this._retailLocationId, "retailLocationId")) {
/*  86 */       this._retailLocationId = argRetailLocationId;
/*     */     }
/*     */   }
/*     */   
/*     */   public Date getCreateDate() {
/*  91 */     return (Date)this._createDate;
/*     */   }
/*     */   
/*     */   public void setCreateDate(Date argCreateDate) {
/*  95 */     if (changed(argCreateDate, this._createDate, "createDate")) {
/*  96 */       this._createDate = (argCreateDate == null || argCreateDate instanceof DtvDate) ? (DtvDate)argCreateDate : new DtvDate(argCreateDate);
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public String getCreateUserId() {
/* 102 */     return this._createUserId;
/*     */   }
/*     */   
/*     */   public void setCreateUserId(String argCreateUserId) {
/* 106 */     if (changed(argCreateUserId, this._createUserId, "createUserId")) {
/* 107 */       this._createUserId = argCreateUserId;
/*     */     }
/*     */   }
/*     */   
/*     */   public Date getUpdateDate() {
/* 112 */     return (Date)this._updateDate;
/*     */   }
/*     */   
/*     */   public void setUpdateDate(Date argUpdateDate) {
/* 116 */     if (changed(argUpdateDate, this._updateDate, "updateDate")) {
/* 117 */       this._updateDate = (argUpdateDate == null || argUpdateDate instanceof DtvDate) ? (DtvDate)argUpdateDate : new DtvDate(argUpdateDate);
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public String getUpdateUserId() {
/* 123 */     return this._updateUserId;
/*     */   }
/*     */   
/*     */   public void setUpdateUserId(String argUpdateUserId) {
/* 127 */     if (changed(argUpdateUserId, this._updateUserId, "updateUserId")) {
/* 128 */       this._updateUserId = argUpdateUserId;
/*     */     }
/*     */   }
/*     */   
/*     */   public Long getCrossRefOrganizationId() {
/* 133 */     return this._crossRefOrganizationId;
/*     */   }
/*     */   
/*     */   public void setCrossRefOrganizationId(Long argCrossRefOrganizationId) {
/* 137 */     if (changed(argCrossRefOrganizationId, this._crossRefOrganizationId, "crossRefOrganizationId")) {
/* 138 */       this._crossRefOrganizationId = argCrossRefOrganizationId;
/*     */     }
/*     */   }
/*     */   
/*     */   public String getCrossRefDocumentId() {
/* 143 */     return this._crossRefDocumentId;
/*     */   }
/*     */   
/*     */   public void setCrossRefDocumentId(String argCrossRefDocumentId) {
/* 147 */     if (changed(argCrossRefDocumentId, this._crossRefDocumentId, "crossRefDocumentId")) {
/* 148 */       this._crossRefDocumentId = argCrossRefDocumentId;
/*     */     }
/*     */   }
/*     */   
/*     */   public Integer getCrossRefLineNumber() {
/* 153 */     return this._crossRefLineNumber;
/*     */   }
/*     */   
/*     */   public void setCrossRefLineNumber(Integer argCrossRefLineNumber) {
/* 157 */     if (changed(argCrossRefLineNumber, this._crossRefLineNumber, "crossRefLineNumber")) {
/* 158 */       this._crossRefLineNumber = argCrossRefLineNumber;
/*     */     }
/*     */   }
/*     */   
/*     */   public String getCrossRefDocumentTypeCode() {
/* 163 */     return this._crossRefDocumentTypeCode;
/*     */   }
/*     */   
/*     */   public void setCrossRefDocumentTypeCode(String argCrossRefDocumentTypeCode) {
/* 167 */     if (changed(argCrossRefDocumentTypeCode, this._crossRefDocumentTypeCode, "crossRefDocumentTypeCode")) {
/* 168 */       this._crossRefDocumentTypeCode = argCrossRefDocumentTypeCode;
/*     */     }
/*     */   }
/*     */   
/*     */   public Long getCrossRefRetailLocationId() {
/* 173 */     return this._crossRefRetailLocationId;
/*     */   }
/*     */   
/*     */   public void setCrossRefRetailLocationId(Long argCrossRefRetailLocationId) {
/* 177 */     if (changed(argCrossRefRetailLocationId, this._crossRefRetailLocationId, "crossRefRetailLocationId")) {
/* 178 */       this._crossRefRetailLocationId = argCrossRefRetailLocationId;
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public String toString() {
/* 185 */     StringBuilder buf = new StringBuilder(512);
/* 186 */     buf.append(super.toString()).append(" Id: ").append(getObjectId()).append(" Values: ");
/* 187 */     if (getOrganizationId() != null) {
/* 188 */       buf.append("organizationId").append("=").append(getOrganizationId()).append(" ");
/*     */     }
/* 190 */     if (getDocumentId() != null) {
/* 191 */       buf.append("documentId").append("=").append(getDocumentId()).append(" ");
/*     */     }
/* 193 */     if (getInventoryDocumentLineNumber() != null) {
/* 194 */       buf.append("inventoryDocumentLineNumber").append("=").append(getInventoryDocumentLineNumber()).append(" ");
/*     */     }
/* 196 */     if (getDocumentTypeCode() != null) {
/* 197 */       buf.append("documentTypeCode").append("=").append(getDocumentTypeCode()).append(" ");
/*     */     }
/* 199 */     if (getRetailLocationId() != null) {
/* 200 */       buf.append("retailLocationId").append("=").append(getRetailLocationId()).append(" ");
/*     */     }
/* 202 */     if (getCreateDate() != null) {
/* 203 */       buf.append("createDate").append("=").append(getCreateDate()).append(" ");
/*     */     }
/* 205 */     if (getCreateUserId() != null) {
/* 206 */       buf.append("createUserId").append("=").append(getCreateUserId()).append(" ");
/*     */     }
/* 208 */     if (getUpdateDate() != null) {
/* 209 */       buf.append("updateDate").append("=").append(getUpdateDate()).append(" ");
/*     */     }
/* 211 */     if (getUpdateUserId() != null) {
/* 212 */       buf.append("updateUserId").append("=").append(getUpdateUserId()).append(" ");
/*     */     }
/* 214 */     if (getCrossRefOrganizationId() != null) {
/* 215 */       buf.append("crossRefOrganizationId").append("=").append(getCrossRefOrganizationId()).append(" ");
/*     */     }
/* 217 */     if (getCrossRefDocumentId() != null) {
/* 218 */       buf.append("crossRefDocumentId").append("=").append(getCrossRefDocumentId()).append(" ");
/*     */     }
/* 220 */     if (getCrossRefLineNumber() != null) {
/* 221 */       buf.append("crossRefLineNumber").append("=").append(getCrossRefLineNumber()).append(" ");
/*     */     }
/* 223 */     if (getCrossRefDocumentTypeCode() != null) {
/* 224 */       buf.append("crossRefDocumentTypeCode").append("=").append(getCrossRefDocumentTypeCode()).append(" ");
/*     */     }
/* 226 */     if (getCrossRefRetailLocationId() != null) {
/* 227 */       buf.append("crossRefRetailLocationId").append("=").append(getCrossRefRetailLocationId()).append(" ");
/*     */     }
/*     */     
/* 230 */     return buf.toString();
/*     */   }
/*     */   
/*     */   public IObjectId getObjectId() {
/* 234 */     InventoryDocumentCrossReferenceId id = new InventoryDocumentCrossReferenceId();
/* 235 */     id.setOrganizationId(getOrganizationId());
/* 236 */     id.setDocumentId(getDocumentId());
/* 237 */     id.setInventoryDocumentLineNumber(getInventoryDocumentLineNumber());
/* 238 */     id.setDocumentTypeCode(getDocumentTypeCode());
/* 239 */     id.setRetailLocationId(getRetailLocationId());
/* 240 */     return (IObjectId)id;
/*     */   }
/*     */   
/*     */   public void setObjectId(IObjectId argObjectId) {
/* 244 */     setOrganizationId(((InventoryDocumentCrossReferenceId)argObjectId).getOrganizationId());
/* 245 */     setDocumentId(((InventoryDocumentCrossReferenceId)argObjectId).getDocumentId());
/* 246 */     setInventoryDocumentLineNumber(((InventoryDocumentCrossReferenceId)argObjectId).getInventoryDocumentLineNumber());
/* 247 */     setDocumentTypeCode(((InventoryDocumentCrossReferenceId)argObjectId).getDocumentTypeCode());
/* 248 */     setRetailLocationId(((InventoryDocumentCrossReferenceId)argObjectId).getRetailLocationId());
/*     */   }
/*     */   
/*     */   public String getImplementingClass() {
/* 252 */     return null;
/*     */   }
/*     */   
/*     */   public String toXmlString() {
/* 256 */     StringBuilder buf = new StringBuilder(700);
/* 257 */     buf.append("<").append("dao").append(" name=\"InventoryDocumentCrossReference\" cmd=\"" + getObjectStateString() + "\">");
/* 258 */     getFieldsAsXml(buf);
/* 259 */     buf.append("</").append("dao").append(">");
/*     */     
/* 261 */     return buf.toString();
/*     */   }
/*     */   
/*     */   public Map<String, String> getValues() {
/* 265 */     Map<String, String> values = super.getValues();
/* 266 */     if (this._organizationId != null) values.put("OrganizationId", DaoUtils.getXmlSafeFieldValue(-5, this._organizationId)); 
/* 267 */     if (this._documentId != null) values.put("DocumentId", DaoUtils.getXmlSafeFieldValue(12, this._documentId)); 
/* 268 */     if (this._inventoryDocumentLineNumber != null) values.put("InventoryDocumentLineNumber", DaoUtils.getXmlSafeFieldValue(4, this._inventoryDocumentLineNumber)); 
/* 269 */     if (this._documentTypeCode != null) values.put("DocumentTypeCode", DaoUtils.getXmlSafeFieldValue(12, this._documentTypeCode)); 
/* 270 */     if (this._retailLocationId != null) values.put("RetailLocationId", DaoUtils.getXmlSafeFieldValue(-5, this._retailLocationId)); 
/* 271 */     if (this._createDate != null) values.put("CreateDate", DaoUtils.getXmlSafeFieldValue(91, this._createDate)); 
/* 272 */     if (this._createUserId != null) values.put("CreateUserId", DaoUtils.getXmlSafeFieldValue(12, this._createUserId)); 
/* 273 */     if (this._updateDate != null) values.put("UpdateDate", DaoUtils.getXmlSafeFieldValue(91, this._updateDate)); 
/* 274 */     if (this._updateUserId != null) values.put("UpdateUserId", DaoUtils.getXmlSafeFieldValue(12, this._updateUserId)); 
/* 275 */     if (this._crossRefOrganizationId != null) values.put("CrossRefOrganizationId", DaoUtils.getXmlSafeFieldValue(-5, this._crossRefOrganizationId)); 
/* 276 */     if (this._crossRefDocumentId != null) values.put("CrossRefDocumentId", DaoUtils.getXmlSafeFieldValue(12, this._crossRefDocumentId)); 
/* 277 */     if (this._crossRefLineNumber != null) values.put("CrossRefLineNumber", DaoUtils.getXmlSafeFieldValue(4, this._crossRefLineNumber)); 
/* 278 */     if (this._crossRefDocumentTypeCode != null) values.put("CrossRefDocumentTypeCode", DaoUtils.getXmlSafeFieldValue(12, this._crossRefDocumentTypeCode)); 
/* 279 */     if (this._crossRefRetailLocationId != null) values.put("CrossRefRetailLocationId", DaoUtils.getXmlSafeFieldValue(-5, this._crossRefRetailLocationId)); 
/* 280 */     return values;
/*     */   }
/*     */ 
/*     */   
/*     */   public void setValues(Map<String, String> argValues) {
/* 285 */     super.setValues(argValues);
/* 286 */     for (Map.Entry<String, String> field : argValues.entrySet()) {
/*     */       
/* 288 */       String fieldName = field.getKey();
/* 289 */       String fieldValue = field.getValue();
/* 290 */       switch (fieldName) {
/*     */         
/*     */         case "OrganizationId":
/*     */           try {
/* 294 */             Object value = DaoUtils.getFieldValueForXmlString(-5, fieldValue);
/* 295 */             setOrganizationId((Long)value);
/* 296 */           } catch (Exception ee) {
/* 297 */             throw new DtxException("An exception occurred while calling setOrganizationId() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "DocumentId":
/*     */           try {
/* 303 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 304 */             setDocumentId((String)value);
/* 305 */           } catch (Exception ee) {
/* 306 */             throw new DtxException("An exception occurred while calling setDocumentId() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "InventoryDocumentLineNumber":
/*     */           try {
/* 312 */             Object value = DaoUtils.getFieldValueForXmlString(4, fieldValue);
/* 313 */             setInventoryDocumentLineNumber((Integer)value);
/* 314 */           } catch (Exception ee) {
/* 315 */             throw new DtxException("An exception occurred while calling setInventoryDocumentLineNumber() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "DocumentTypeCode":
/*     */           try {
/* 321 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 322 */             setDocumentTypeCode((String)value);
/* 323 */           } catch (Exception ee) {
/* 324 */             throw new DtxException("An exception occurred while calling setDocumentTypeCode() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "RetailLocationId":
/*     */           try {
/* 330 */             Object value = DaoUtils.getFieldValueForXmlString(-5, fieldValue);
/* 331 */             setRetailLocationId((Long)value);
/* 332 */           } catch (Exception ee) {
/* 333 */             throw new DtxException("An exception occurred while calling setRetailLocationId() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "CreateDate":
/*     */           try {
/* 339 */             Object value = DaoUtils.getFieldValueForXmlString(91, fieldValue);
/* 340 */             setCreateDate((Date)value);
/* 341 */           } catch (Exception ee) {
/* 342 */             throw new DtxException("An exception occurred while calling setCreateDate() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "CreateUserId":
/*     */           try {
/* 348 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 349 */             setCreateUserId((String)value);
/* 350 */           } catch (Exception ee) {
/* 351 */             throw new DtxException("An exception occurred while calling setCreateUserId() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "UpdateDate":
/*     */           try {
/* 357 */             Object value = DaoUtils.getFieldValueForXmlString(91, fieldValue);
/* 358 */             setUpdateDate((Date)value);
/* 359 */           } catch (Exception ee) {
/* 360 */             throw new DtxException("An exception occurred while calling setUpdateDate() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "UpdateUserId":
/*     */           try {
/* 366 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 367 */             setUpdateUserId((String)value);
/* 368 */           } catch (Exception ee) {
/* 369 */             throw new DtxException("An exception occurred while calling setUpdateUserId() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "CrossRefOrganizationId":
/*     */           try {
/* 375 */             Object value = DaoUtils.getFieldValueForXmlString(-5, fieldValue);
/* 376 */             setCrossRefOrganizationId((Long)value);
/* 377 */           } catch (Exception ee) {
/* 378 */             throw new DtxException("An exception occurred while calling setCrossRefOrganizationId() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "CrossRefDocumentId":
/*     */           try {
/* 384 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 385 */             setCrossRefDocumentId((String)value);
/* 386 */           } catch (Exception ee) {
/* 387 */             throw new DtxException("An exception occurred while calling setCrossRefDocumentId() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "CrossRefLineNumber":
/*     */           try {
/* 393 */             Object value = DaoUtils.getFieldValueForXmlString(4, fieldValue);
/* 394 */             setCrossRefLineNumber((Integer)value);
/* 395 */           } catch (Exception ee) {
/* 396 */             throw new DtxException("An exception occurred while calling setCrossRefLineNumber() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "CrossRefDocumentTypeCode":
/*     */           try {
/* 402 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 403 */             setCrossRefDocumentTypeCode((String)value);
/* 404 */           } catch (Exception ee) {
/* 405 */             throw new DtxException("An exception occurred while calling setCrossRefDocumentTypeCode() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "CrossRefRetailLocationId":
/*     */           try {
/* 411 */             Object value = DaoUtils.getFieldValueForXmlString(-5, fieldValue);
/* 412 */             setCrossRefRetailLocationId((Long)value);
/* 413 */           } catch (Exception ee) {
/* 414 */             throw new DtxException("An exception occurred while calling setCrossRefRetailLocationId() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */       } 
/*     */     } 
/*     */   }
/*     */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\inv\impl\InventoryDocumentCrossReferenceDAO.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */