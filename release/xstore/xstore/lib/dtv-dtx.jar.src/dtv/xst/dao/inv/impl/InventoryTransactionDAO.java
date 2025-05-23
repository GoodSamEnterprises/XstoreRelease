/*     */ package dtv.xst.dao.inv.impl;
/*     */ 
/*     */ import dtv.data2.access.DaoUtils;
/*     */ import dtv.data2.access.exception.DtxException;
/*     */ import dtv.util.DtvDate;
/*     */ import dtv.xst.dao.trn.impl.PosTransactionDAO;
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
/*     */ 
/*     */ 
/*     */ public class InventoryTransactionDAO
/*     */   extends PosTransactionDAO
/*     */ {
/*     */   private static final long serialVersionUID = 708666370L;
/*  23 */   private static final Logger _logger = Logger.getLogger(InventoryTransactionDAO.class);
/*     */   
/*     */   private DtvDate _createDate;
/*     */   private String _createUserId;
/*     */   private DtvDate _updateDate;
/*     */   private String _updateUserId;
/*     */   private String _oldStatusCode;
/*     */   private String _newStatusCode;
/*     */   private String _reasonCode;
/*     */   private Long _inventoryDocumentRetailLocationId;
/*     */   private String _documentTypeCode;
/*     */   private String _documentId;
/*     */   private DtvDate _documentDate;
/*     */   
/*     */   public Date getCreateDate() {
/*  38 */     return (Date)this._createDate;
/*     */   }
/*     */   
/*     */   public void setCreateDate(Date argCreateDate) {
/*  42 */     if (changed(argCreateDate, this._createDate, "createDate")) {
/*  43 */       this._createDate = (argCreateDate == null || argCreateDate instanceof DtvDate) ? (DtvDate)argCreateDate : new DtvDate(argCreateDate);
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public String getCreateUserId() {
/*  49 */     return this._createUserId;
/*     */   }
/*     */   
/*     */   public void setCreateUserId(String argCreateUserId) {
/*  53 */     if (changed(argCreateUserId, this._createUserId, "createUserId")) {
/*  54 */       this._createUserId = argCreateUserId;
/*     */     }
/*     */   }
/*     */   
/*     */   public Date getUpdateDate() {
/*  59 */     return (Date)this._updateDate;
/*     */   }
/*     */   
/*     */   public void setUpdateDate(Date argUpdateDate) {
/*  63 */     if (changed(argUpdateDate, this._updateDate, "updateDate")) {
/*  64 */       this._updateDate = (argUpdateDate == null || argUpdateDate instanceof DtvDate) ? (DtvDate)argUpdateDate : new DtvDate(argUpdateDate);
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public String getUpdateUserId() {
/*  70 */     return this._updateUserId;
/*     */   }
/*     */   
/*     */   public void setUpdateUserId(String argUpdateUserId) {
/*  74 */     if (changed(argUpdateUserId, this._updateUserId, "updateUserId")) {
/*  75 */       this._updateUserId = argUpdateUserId;
/*     */     }
/*     */   }
/*     */   
/*     */   public String getOldStatusCode() {
/*  80 */     return this._oldStatusCode;
/*     */   }
/*     */   
/*     */   public void setOldStatusCode(String argOldStatusCode) {
/*  84 */     if (changed(argOldStatusCode, this._oldStatusCode, "oldStatusCode")) {
/*  85 */       this._oldStatusCode = argOldStatusCode;
/*     */     }
/*     */   }
/*     */   
/*     */   public String getNewStatusCode() {
/*  90 */     return this._newStatusCode;
/*     */   }
/*     */   
/*     */   public void setNewStatusCode(String argNewStatusCode) {
/*  94 */     if (changed(argNewStatusCode, this._newStatusCode, "newStatusCode")) {
/*  95 */       this._newStatusCode = argNewStatusCode;
/*     */     }
/*     */   }
/*     */   
/*     */   public String getReasonCode() {
/* 100 */     return this._reasonCode;
/*     */   }
/*     */   
/*     */   public void setReasonCode(String argReasonCode) {
/* 104 */     if (changed(argReasonCode, this._reasonCode, "reasonCode")) {
/* 105 */       this._reasonCode = argReasonCode;
/*     */     }
/*     */   }
/*     */   
/*     */   public Long getInventoryDocumentRetailLocationId() {
/* 110 */     return this._inventoryDocumentRetailLocationId;
/*     */   }
/*     */   
/*     */   public void setInventoryDocumentRetailLocationId(Long argInventoryDocumentRetailLocationId) {
/* 114 */     if (changed(argInventoryDocumentRetailLocationId, this._inventoryDocumentRetailLocationId, "inventoryDocumentRetailLocationId")) {
/* 115 */       this._inventoryDocumentRetailLocationId = argInventoryDocumentRetailLocationId;
/*     */     }
/*     */   }
/*     */   
/*     */   public String getDocumentTypeCode() {
/* 120 */     return this._documentTypeCode;
/*     */   }
/*     */   
/*     */   public void setDocumentTypeCode(String argDocumentTypeCode) {
/* 124 */     if (changed(argDocumentTypeCode, this._documentTypeCode, "documentTypeCode")) {
/* 125 */       this._documentTypeCode = argDocumentTypeCode;
/*     */     }
/*     */   }
/*     */   
/*     */   public String getDocumentId() {
/* 130 */     return this._documentId;
/*     */   }
/*     */   
/*     */   public void setDocumentId(String argDocumentId) {
/* 134 */     if (changed(argDocumentId, this._documentId, "documentId")) {
/* 135 */       this._documentId = argDocumentId;
/*     */     }
/*     */   }
/*     */   
/*     */   public Date getDocumentDate() {
/* 140 */     return (Date)this._documentDate;
/*     */   }
/*     */   
/*     */   public void setDocumentDate(Date argDocumentDate) {
/* 144 */     if (changed(argDocumentDate, this._documentDate, "documentDate")) {
/* 145 */       this._documentDate = (argDocumentDate == null || argDocumentDate instanceof DtvDate) ? (DtvDate)argDocumentDate : new DtvDate(argDocumentDate);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String toString() {
/* 153 */     StringBuilder buf = new StringBuilder(512);
/* 154 */     buf.append(super.toString());
/* 155 */     if (getCreateDate() != null) {
/* 156 */       buf.append("createDate").append("=").append(getCreateDate()).append(" ");
/*     */     }
/* 158 */     if (getCreateUserId() != null) {
/* 159 */       buf.append("createUserId").append("=").append(getCreateUserId()).append(" ");
/*     */     }
/* 161 */     if (getUpdateDate() != null) {
/* 162 */       buf.append("updateDate").append("=").append(getUpdateDate()).append(" ");
/*     */     }
/* 164 */     if (getUpdateUserId() != null) {
/* 165 */       buf.append("updateUserId").append("=").append(getUpdateUserId()).append(" ");
/*     */     }
/* 167 */     if (getOldStatusCode() != null) {
/* 168 */       buf.append("oldStatusCode").append("=").append(getOldStatusCode()).append(" ");
/*     */     }
/* 170 */     if (getNewStatusCode() != null) {
/* 171 */       buf.append("newStatusCode").append("=").append(getNewStatusCode()).append(" ");
/*     */     }
/* 173 */     if (getReasonCode() != null) {
/* 174 */       buf.append("reasonCode").append("=").append(getReasonCode()).append(" ");
/*     */     }
/* 176 */     if (getInventoryDocumentRetailLocationId() != null) {
/* 177 */       buf.append("inventoryDocumentRetailLocationId").append("=").append(getInventoryDocumentRetailLocationId()).append(" ");
/*     */     }
/* 179 */     if (getDocumentTypeCode() != null) {
/* 180 */       buf.append("documentTypeCode").append("=").append(getDocumentTypeCode()).append(" ");
/*     */     }
/* 182 */     if (getDocumentId() != null) {
/* 183 */       buf.append("documentId").append("=").append(getDocumentId()).append(" ");
/*     */     }
/* 185 */     if (getDocumentDate() != null) {
/* 186 */       buf.append("documentDate").append("=").append(getDocumentDate()).append(" ");
/*     */     }
/*     */     
/* 189 */     return buf.toString();
/*     */   }
/*     */ 
/*     */   
/*     */   public String toXmlString() {
/* 194 */     StringBuilder buf = new StringBuilder(2000);
/* 195 */     buf.append("<").append("dao").append(" name=\"InventoryTransaction\" cmd=\"" + getObjectStateString() + "\">");
/* 196 */     getFieldsAsXml(buf);
/* 197 */     buf.append("</").append("dao").append(">");
/*     */     
/* 199 */     return buf.toString();
/*     */   }
/*     */   
/*     */   public Map<String, String> getValues() {
/* 203 */     Map<String, String> values = super.getValues();
/* 204 */     if (this._createDate != null) values.put("CreateDate", DaoUtils.getXmlSafeFieldValue(91, this._createDate)); 
/* 205 */     if (this._createUserId != null) values.put("CreateUserId", DaoUtils.getXmlSafeFieldValue(12, this._createUserId)); 
/* 206 */     if (this._updateDate != null) values.put("UpdateDate", DaoUtils.getXmlSafeFieldValue(91, this._updateDate)); 
/* 207 */     if (this._updateUserId != null) values.put("UpdateUserId", DaoUtils.getXmlSafeFieldValue(12, this._updateUserId)); 
/* 208 */     if (this._oldStatusCode != null) values.put("OldStatusCode", DaoUtils.getXmlSafeFieldValue(12, this._oldStatusCode)); 
/* 209 */     if (this._newStatusCode != null) values.put("NewStatusCode", DaoUtils.getXmlSafeFieldValue(12, this._newStatusCode)); 
/* 210 */     if (this._reasonCode != null) values.put("ReasonCode", DaoUtils.getXmlSafeFieldValue(12, this._reasonCode)); 
/* 211 */     if (this._inventoryDocumentRetailLocationId != null) values.put("InventoryDocumentRetailLocationId", DaoUtils.getXmlSafeFieldValue(-5, this._inventoryDocumentRetailLocationId)); 
/* 212 */     if (this._documentTypeCode != null) values.put("DocumentTypeCode", DaoUtils.getXmlSafeFieldValue(12, this._documentTypeCode)); 
/* 213 */     if (this._documentId != null) values.put("DocumentId", DaoUtils.getXmlSafeFieldValue(12, this._documentId)); 
/* 214 */     if (this._documentDate != null) values.put("DocumentDate", DaoUtils.getXmlSafeFieldValue(91, this._documentDate)); 
/* 215 */     return values;
/*     */   }
/*     */ 
/*     */   
/*     */   public void setValues(Map<String, String> argValues) {
/* 220 */     super.setValues(argValues);
/* 221 */     for (Map.Entry<String, String> field : argValues.entrySet()) {
/*     */       
/* 223 */       String fieldName = field.getKey();
/* 224 */       String fieldValue = field.getValue();
/* 225 */       switch (fieldName) {
/*     */         
/*     */         case "CreateDate":
/*     */           try {
/* 229 */             Object value = DaoUtils.getFieldValueForXmlString(91, fieldValue);
/* 230 */             setCreateDate((Date)value);
/* 231 */           } catch (Exception ee) {
/* 232 */             throw new DtxException("An exception occurred while calling setCreateDate() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "CreateUserId":
/*     */           try {
/* 238 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 239 */             setCreateUserId((String)value);
/* 240 */           } catch (Exception ee) {
/* 241 */             throw new DtxException("An exception occurred while calling setCreateUserId() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "UpdateDate":
/*     */           try {
/* 247 */             Object value = DaoUtils.getFieldValueForXmlString(91, fieldValue);
/* 248 */             setUpdateDate((Date)value);
/* 249 */           } catch (Exception ee) {
/* 250 */             throw new DtxException("An exception occurred while calling setUpdateDate() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "UpdateUserId":
/*     */           try {
/* 256 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 257 */             setUpdateUserId((String)value);
/* 258 */           } catch (Exception ee) {
/* 259 */             throw new DtxException("An exception occurred while calling setUpdateUserId() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "OldStatusCode":
/*     */           try {
/* 265 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 266 */             setOldStatusCode((String)value);
/* 267 */           } catch (Exception ee) {
/* 268 */             throw new DtxException("An exception occurred while calling setOldStatusCode() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "NewStatusCode":
/*     */           try {
/* 274 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 275 */             setNewStatusCode((String)value);
/* 276 */           } catch (Exception ee) {
/* 277 */             throw new DtxException("An exception occurred while calling setNewStatusCode() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "ReasonCode":
/*     */           try {
/* 283 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 284 */             setReasonCode((String)value);
/* 285 */           } catch (Exception ee) {
/* 286 */             throw new DtxException("An exception occurred while calling setReasonCode() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "InventoryDocumentRetailLocationId":
/*     */           try {
/* 292 */             Object value = DaoUtils.getFieldValueForXmlString(-5, fieldValue);
/* 293 */             setInventoryDocumentRetailLocationId((Long)value);
/* 294 */           } catch (Exception ee) {
/* 295 */             throw new DtxException("An exception occurred while calling setInventoryDocumentRetailLocationId() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "DocumentTypeCode":
/*     */           try {
/* 301 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 302 */             setDocumentTypeCode((String)value);
/* 303 */           } catch (Exception ee) {
/* 304 */             throw new DtxException("An exception occurred while calling setDocumentTypeCode() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "DocumentId":
/*     */           try {
/* 310 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 311 */             setDocumentId((String)value);
/* 312 */           } catch (Exception ee) {
/* 313 */             throw new DtxException("An exception occurred while calling setDocumentId() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "DocumentDate":
/*     */           try {
/* 319 */             Object value = DaoUtils.getFieldValueForXmlString(91, fieldValue);
/* 320 */             setDocumentDate((Date)value);
/* 321 */           } catch (Exception ee) {
/* 322 */             throw new DtxException("An exception occurred while calling setDocumentDate() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */       } 
/*     */     } 
/*     */   }
/*     */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\inv\impl\InventoryTransactionDAO.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */