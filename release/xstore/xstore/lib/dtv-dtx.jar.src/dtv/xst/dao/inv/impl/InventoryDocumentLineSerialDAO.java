/*     */ package dtv.xst.dao.inv.impl;
/*     */ 
/*     */ import dtv.data2.access.DaoUtils;
/*     */ import dtv.data2.access.IObjectId;
/*     */ import dtv.data2.access.exception.DtxException;
/*     */ import dtv.data2.access.impl.AbstractDAOImpl;
/*     */ import dtv.util.DtvDate;
/*     */ import dtv.xst.dao.inv.InventoryDocumentLineSerialId;
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
/*     */ public class InventoryDocumentLineSerialDAO
/*     */   extends AbstractDAOImpl
/*     */ {
/*     */   private static final long serialVersionUID = 423606495L;
/*  23 */   private static final Logger _logger = Logger.getLogger(InventoryDocumentLineSerialDAO.class);
/*     */   
/*     */   private String _documentId;
/*     */   private String _documentTypeCode;
/*     */   private Integer _inventoryDocumentLineNumber;
/*     */   private Long _organizationId;
/*     */   private Long _retailLocationId;
/*     */   private Integer _serialLineNumber;
/*     */   private DtvDate _createDate;
/*     */   private String _createUserId;
/*     */   private DtvDate _updateDate;
/*     */   private String _updateUserId;
/*     */   private String _serialNumber;
/*     */   
/*     */   public String getDocumentId() {
/*  38 */     return this._documentId;
/*     */   }
/*     */   
/*     */   public void setDocumentId(String argDocumentId) {
/*  42 */     if (changed(argDocumentId, this._documentId, "documentId")) {
/*  43 */       this._documentId = (argDocumentId != null && MANAGE_CASE) ? argDocumentId.toUpperCase() : argDocumentId;
/*     */     }
/*     */   }
/*     */   
/*     */   public String getDocumentTypeCode() {
/*  48 */     return this._documentTypeCode;
/*     */   }
/*     */   
/*     */   public void setDocumentTypeCode(String argDocumentTypeCode) {
/*  52 */     if (changed(argDocumentTypeCode, this._documentTypeCode, "documentTypeCode")) {
/*  53 */       this._documentTypeCode = (argDocumentTypeCode != null && MANAGE_CASE) ? argDocumentTypeCode.toUpperCase() : argDocumentTypeCode;
/*     */     }
/*     */   }
/*     */   
/*     */   public Integer getInventoryDocumentLineNumber() {
/*  58 */     return this._inventoryDocumentLineNumber;
/*     */   }
/*     */   
/*     */   public void setInventoryDocumentLineNumber(Integer argInventoryDocumentLineNumber) {
/*  62 */     if (changed(argInventoryDocumentLineNumber, this._inventoryDocumentLineNumber, "inventoryDocumentLineNumber")) {
/*  63 */       this._inventoryDocumentLineNumber = argInventoryDocumentLineNumber;
/*     */     }
/*     */   }
/*     */   
/*     */   public Long getOrganizationId() {
/*  68 */     return this._organizationId;
/*     */   }
/*     */   
/*     */   public void setOrganizationId(Long argOrganizationId) {
/*  72 */     if (changed(argOrganizationId, this._organizationId, "organizationId")) {
/*  73 */       this._organizationId = argOrganizationId;
/*     */     }
/*     */   }
/*     */   
/*     */   public Long getRetailLocationId() {
/*  78 */     return this._retailLocationId;
/*     */   }
/*     */   
/*     */   public void setRetailLocationId(Long argRetailLocationId) {
/*  82 */     if (changed(argRetailLocationId, this._retailLocationId, "retailLocationId")) {
/*  83 */       this._retailLocationId = argRetailLocationId;
/*     */     }
/*     */   }
/*     */   
/*     */   public Integer getSerialLineNumber() {
/*  88 */     return this._serialLineNumber;
/*     */   }
/*     */   
/*     */   public void setSerialLineNumber(Integer argSerialLineNumber) {
/*  92 */     if (changed(argSerialLineNumber, this._serialLineNumber, "serialLineNumber")) {
/*  93 */       this._serialLineNumber = argSerialLineNumber;
/*     */     }
/*     */   }
/*     */   
/*     */   public Date getCreateDate() {
/*  98 */     return (Date)this._createDate;
/*     */   }
/*     */   
/*     */   public void setCreateDate(Date argCreateDate) {
/* 102 */     if (changed(argCreateDate, this._createDate, "createDate")) {
/* 103 */       this._createDate = (argCreateDate == null || argCreateDate instanceof DtvDate) ? (DtvDate)argCreateDate : new DtvDate(argCreateDate);
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public String getCreateUserId() {
/* 109 */     return this._createUserId;
/*     */   }
/*     */   
/*     */   public void setCreateUserId(String argCreateUserId) {
/* 113 */     if (changed(argCreateUserId, this._createUserId, "createUserId")) {
/* 114 */       this._createUserId = argCreateUserId;
/*     */     }
/*     */   }
/*     */   
/*     */   public Date getUpdateDate() {
/* 119 */     return (Date)this._updateDate;
/*     */   }
/*     */   
/*     */   public void setUpdateDate(Date argUpdateDate) {
/* 123 */     if (changed(argUpdateDate, this._updateDate, "updateDate")) {
/* 124 */       this._updateDate = (argUpdateDate == null || argUpdateDate instanceof DtvDate) ? (DtvDate)argUpdateDate : new DtvDate(argUpdateDate);
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public String getUpdateUserId() {
/* 130 */     return this._updateUserId;
/*     */   }
/*     */   
/*     */   public void setUpdateUserId(String argUpdateUserId) {
/* 134 */     if (changed(argUpdateUserId, this._updateUserId, "updateUserId")) {
/* 135 */       this._updateUserId = argUpdateUserId;
/*     */     }
/*     */   }
/*     */   
/*     */   public String getSerialNumber() {
/* 140 */     return this._serialNumber;
/*     */   }
/*     */   
/*     */   public void setSerialNumber(String argSerialNumber) {
/* 144 */     if (changed(argSerialNumber, this._serialNumber, "serialNumber")) {
/* 145 */       this._serialNumber = argSerialNumber;
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public String toString() {
/* 152 */     StringBuilder buf = new StringBuilder(512);
/* 153 */     buf.append(super.toString()).append(" Id: ").append(getObjectId()).append(" Values: ");
/* 154 */     if (getDocumentId() != null) {
/* 155 */       buf.append("documentId").append("=").append(getDocumentId()).append(" ");
/*     */     }
/* 157 */     if (getDocumentTypeCode() != null) {
/* 158 */       buf.append("documentTypeCode").append("=").append(getDocumentTypeCode()).append(" ");
/*     */     }
/* 160 */     if (getInventoryDocumentLineNumber() != null) {
/* 161 */       buf.append("inventoryDocumentLineNumber").append("=").append(getInventoryDocumentLineNumber()).append(" ");
/*     */     }
/* 163 */     if (getOrganizationId() != null) {
/* 164 */       buf.append("organizationId").append("=").append(getOrganizationId()).append(" ");
/*     */     }
/* 166 */     if (getRetailLocationId() != null) {
/* 167 */       buf.append("retailLocationId").append("=").append(getRetailLocationId()).append(" ");
/*     */     }
/* 169 */     if (getSerialLineNumber() != null) {
/* 170 */       buf.append("serialLineNumber").append("=").append(getSerialLineNumber()).append(" ");
/*     */     }
/* 172 */     if (getCreateDate() != null) {
/* 173 */       buf.append("createDate").append("=").append(getCreateDate()).append(" ");
/*     */     }
/* 175 */     if (getCreateUserId() != null) {
/* 176 */       buf.append("createUserId").append("=").append(getCreateUserId()).append(" ");
/*     */     }
/* 178 */     if (getUpdateDate() != null) {
/* 179 */       buf.append("updateDate").append("=").append(getUpdateDate()).append(" ");
/*     */     }
/* 181 */     if (getUpdateUserId() != null) {
/* 182 */       buf.append("updateUserId").append("=").append(getUpdateUserId()).append(" ");
/*     */     }
/* 184 */     if (getSerialNumber() != null) {
/* 185 */       buf.append("serialNumber").append("=").append(getSerialNumber()).append(" ");
/*     */     }
/*     */     
/* 188 */     return buf.toString();
/*     */   }
/*     */   
/*     */   public IObjectId getObjectId() {
/* 192 */     InventoryDocumentLineSerialId id = new InventoryDocumentLineSerialId();
/* 193 */     id.setDocumentId(getDocumentId());
/* 194 */     id.setDocumentTypeCode(getDocumentTypeCode());
/* 195 */     id.setInventoryDocumentLineNumber(getInventoryDocumentLineNumber());
/* 196 */     id.setOrganizationId(getOrganizationId());
/* 197 */     id.setRetailLocationId(getRetailLocationId());
/* 198 */     id.setSerialLineNumber(getSerialLineNumber());
/* 199 */     return (IObjectId)id;
/*     */   }
/*     */   
/*     */   public void setObjectId(IObjectId argObjectId) {
/* 203 */     setDocumentId(((InventoryDocumentLineSerialId)argObjectId).getDocumentId());
/* 204 */     setDocumentTypeCode(((InventoryDocumentLineSerialId)argObjectId).getDocumentTypeCode());
/* 205 */     setInventoryDocumentLineNumber(((InventoryDocumentLineSerialId)argObjectId).getInventoryDocumentLineNumber());
/* 206 */     setOrganizationId(((InventoryDocumentLineSerialId)argObjectId).getOrganizationId());
/* 207 */     setRetailLocationId(((InventoryDocumentLineSerialId)argObjectId).getRetailLocationId());
/* 208 */     setSerialLineNumber(((InventoryDocumentLineSerialId)argObjectId).getSerialLineNumber());
/*     */   }
/*     */   
/*     */   public String getImplementingClass() {
/* 212 */     return null;
/*     */   }
/*     */   
/*     */   public String toXmlString() {
/* 216 */     StringBuilder buf = new StringBuilder(550);
/* 217 */     buf.append("<").append("dao").append(" name=\"InventoryDocumentLineSerial\" cmd=\"" + getObjectStateString() + "\">");
/* 218 */     getFieldsAsXml(buf);
/* 219 */     buf.append("</").append("dao").append(">");
/*     */     
/* 221 */     return buf.toString();
/*     */   }
/*     */   
/*     */   public Map<String, String> getValues() {
/* 225 */     Map<String, String> values = super.getValues();
/* 226 */     if (this._documentId != null) values.put("DocumentId", DaoUtils.getXmlSafeFieldValue(12, this._documentId)); 
/* 227 */     if (this._documentTypeCode != null) values.put("DocumentTypeCode", DaoUtils.getXmlSafeFieldValue(12, this._documentTypeCode)); 
/* 228 */     if (this._inventoryDocumentLineNumber != null) values.put("InventoryDocumentLineNumber", DaoUtils.getXmlSafeFieldValue(4, this._inventoryDocumentLineNumber)); 
/* 229 */     if (this._organizationId != null) values.put("OrganizationId", DaoUtils.getXmlSafeFieldValue(-5, this._organizationId)); 
/* 230 */     if (this._retailLocationId != null) values.put("RetailLocationId", DaoUtils.getXmlSafeFieldValue(-5, this._retailLocationId)); 
/* 231 */     if (this._serialLineNumber != null) values.put("SerialLineNumber", DaoUtils.getXmlSafeFieldValue(4, this._serialLineNumber)); 
/* 232 */     if (this._createDate != null) values.put("CreateDate", DaoUtils.getXmlSafeFieldValue(91, this._createDate)); 
/* 233 */     if (this._createUserId != null) values.put("CreateUserId", DaoUtils.getXmlSafeFieldValue(12, this._createUserId)); 
/* 234 */     if (this._updateDate != null) values.put("UpdateDate", DaoUtils.getXmlSafeFieldValue(91, this._updateDate)); 
/* 235 */     if (this._updateUserId != null) values.put("UpdateUserId", DaoUtils.getXmlSafeFieldValue(12, this._updateUserId)); 
/* 236 */     if (this._serialNumber != null) values.put("SerialNumber", DaoUtils.getXmlSafeFieldValue(12, this._serialNumber)); 
/* 237 */     return values;
/*     */   }
/*     */ 
/*     */   
/*     */   public void setValues(Map<String, String> argValues) {
/* 242 */     super.setValues(argValues);
/* 243 */     for (Map.Entry<String, String> field : argValues.entrySet()) {
/*     */       
/* 245 */       String fieldName = field.getKey();
/* 246 */       String fieldValue = field.getValue();
/* 247 */       switch (fieldName) {
/*     */         
/*     */         case "DocumentId":
/*     */           try {
/* 251 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 252 */             setDocumentId((String)value);
/* 253 */           } catch (Exception ee) {
/* 254 */             throw new DtxException("An exception occurred while calling setDocumentId() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "DocumentTypeCode":
/*     */           try {
/* 260 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 261 */             setDocumentTypeCode((String)value);
/* 262 */           } catch (Exception ee) {
/* 263 */             throw new DtxException("An exception occurred while calling setDocumentTypeCode() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "InventoryDocumentLineNumber":
/*     */           try {
/* 269 */             Object value = DaoUtils.getFieldValueForXmlString(4, fieldValue);
/* 270 */             setInventoryDocumentLineNumber((Integer)value);
/* 271 */           } catch (Exception ee) {
/* 272 */             throw new DtxException("An exception occurred while calling setInventoryDocumentLineNumber() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "OrganizationId":
/*     */           try {
/* 278 */             Object value = DaoUtils.getFieldValueForXmlString(-5, fieldValue);
/* 279 */             setOrganizationId((Long)value);
/* 280 */           } catch (Exception ee) {
/* 281 */             throw new DtxException("An exception occurred while calling setOrganizationId() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "RetailLocationId":
/*     */           try {
/* 287 */             Object value = DaoUtils.getFieldValueForXmlString(-5, fieldValue);
/* 288 */             setRetailLocationId((Long)value);
/* 289 */           } catch (Exception ee) {
/* 290 */             throw new DtxException("An exception occurred while calling setRetailLocationId() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "SerialLineNumber":
/*     */           try {
/* 296 */             Object value = DaoUtils.getFieldValueForXmlString(4, fieldValue);
/* 297 */             setSerialLineNumber((Integer)value);
/* 298 */           } catch (Exception ee) {
/* 299 */             throw new DtxException("An exception occurred while calling setSerialLineNumber() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "CreateDate":
/*     */           try {
/* 305 */             Object value = DaoUtils.getFieldValueForXmlString(91, fieldValue);
/* 306 */             setCreateDate((Date)value);
/* 307 */           } catch (Exception ee) {
/* 308 */             throw new DtxException("An exception occurred while calling setCreateDate() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "CreateUserId":
/*     */           try {
/* 314 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 315 */             setCreateUserId((String)value);
/* 316 */           } catch (Exception ee) {
/* 317 */             throw new DtxException("An exception occurred while calling setCreateUserId() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "UpdateDate":
/*     */           try {
/* 323 */             Object value = DaoUtils.getFieldValueForXmlString(91, fieldValue);
/* 324 */             setUpdateDate((Date)value);
/* 325 */           } catch (Exception ee) {
/* 326 */             throw new DtxException("An exception occurred while calling setUpdateDate() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "UpdateUserId":
/*     */           try {
/* 332 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 333 */             setUpdateUserId((String)value);
/* 334 */           } catch (Exception ee) {
/* 335 */             throw new DtxException("An exception occurred while calling setUpdateUserId() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "SerialNumber":
/*     */           try {
/* 341 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 342 */             setSerialNumber((String)value);
/* 343 */           } catch (Exception ee) {
/* 344 */             throw new DtxException("An exception occurred while calling setSerialNumber() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */       } 
/*     */     } 
/*     */   }
/*     */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\inv\impl\InventoryDocumentLineSerialDAO.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */