/*     */ package dtv.xst.dao.trn.impl;
/*     */ 
/*     */ import dtv.data2.access.DaoUtils;
/*     */ import dtv.data2.access.exception.DtxException;
/*     */ import dtv.util.DtvDate;
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
/*     */ 
/*     */ public class PostVoidTransactionDAO
/*     */   extends PosTransactionDAO
/*     */ {
/*     */   private static final long serialVersionUID = -906774582L;
/*  23 */   private static final Logger _logger = Logger.getLogger(PostVoidTransactionDAO.class);
/*     */   
/*     */   private DtvDate _createDate;
/*     */   private String _createUserId;
/*     */   private DtvDate _updateDate;
/*     */   private String _updateUserId;
/*     */   private String _voidedTransactionEntryCode;
/*     */   private DtvDate _voidedBusinessDate;
/*     */   private Long _voidedWorkstationId;
/*     */   private Long _voidedTransactionId;
/*     */   private Long _voidedRetailStoreId;
/*     */   private Long _voidedOrganizationId;
/*     */   private String _postVoidReasonCode;
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
/*     */   public String getVoidedTransactionEntryCode() {
/*  80 */     return this._voidedTransactionEntryCode;
/*     */   }
/*     */   
/*     */   public void setVoidedTransactionEntryCode(String argVoidedTransactionEntryCode) {
/*  84 */     if (changed(argVoidedTransactionEntryCode, this._voidedTransactionEntryCode, "voidedTransactionEntryCode")) {
/*  85 */       this._voidedTransactionEntryCode = argVoidedTransactionEntryCode;
/*     */     }
/*     */   }
/*     */   
/*     */   public Date getVoidedBusinessDate() {
/*  90 */     return (Date)this._voidedBusinessDate;
/*     */   }
/*     */   
/*     */   public void setVoidedBusinessDate(Date argVoidedBusinessDate) {
/*  94 */     if (changed(argVoidedBusinessDate, this._voidedBusinessDate, "voidedBusinessDate")) {
/*  95 */       this._voidedBusinessDate = (argVoidedBusinessDate == null || argVoidedBusinessDate instanceof DtvDate) ? (DtvDate)argVoidedBusinessDate : new DtvDate(argVoidedBusinessDate);
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public Long getVoidedWorkstationId() {
/* 101 */     return this._voidedWorkstationId;
/*     */   }
/*     */   
/*     */   public void setVoidedWorkstationId(Long argVoidedWorkstationId) {
/* 105 */     if (changed(argVoidedWorkstationId, this._voidedWorkstationId, "voidedWorkstationId")) {
/* 106 */       this._voidedWorkstationId = argVoidedWorkstationId;
/*     */     }
/*     */   }
/*     */   
/*     */   public Long getVoidedTransactionId() {
/* 111 */     return this._voidedTransactionId;
/*     */   }
/*     */   
/*     */   public void setVoidedTransactionId(Long argVoidedTransactionId) {
/* 115 */     if (changed(argVoidedTransactionId, this._voidedTransactionId, "voidedTransactionId")) {
/* 116 */       this._voidedTransactionId = argVoidedTransactionId;
/*     */     }
/*     */   }
/*     */   
/*     */   public Long getVoidedRetailStoreId() {
/* 121 */     return this._voidedRetailStoreId;
/*     */   }
/*     */   
/*     */   public void setVoidedRetailStoreId(Long argVoidedRetailStoreId) {
/* 125 */     if (changed(argVoidedRetailStoreId, this._voidedRetailStoreId, "voidedRetailStoreId")) {
/* 126 */       this._voidedRetailStoreId = argVoidedRetailStoreId;
/*     */     }
/*     */   }
/*     */   
/*     */   public Long getVoidedOrganizationId() {
/* 131 */     return this._voidedOrganizationId;
/*     */   }
/*     */   
/*     */   public void setVoidedOrganizationId(Long argVoidedOrganizationId) {
/* 135 */     if (changed(argVoidedOrganizationId, this._voidedOrganizationId, "voidedOrganizationId")) {
/* 136 */       this._voidedOrganizationId = argVoidedOrganizationId;
/*     */     }
/*     */   }
/*     */   
/*     */   public String getPostVoidReasonCode() {
/* 141 */     return this._postVoidReasonCode;
/*     */   }
/*     */   
/*     */   public void setPostVoidReasonCode(String argPostVoidReasonCode) {
/* 145 */     if (changed(argPostVoidReasonCode, this._postVoidReasonCode, "postVoidReasonCode")) {
/* 146 */       this._postVoidReasonCode = argPostVoidReasonCode;
/*     */     }
/*     */   }
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
/* 167 */     if (getVoidedTransactionEntryCode() != null) {
/* 168 */       buf.append("voidedTransactionEntryCode").append("=").append(getVoidedTransactionEntryCode()).append(" ");
/*     */     }
/* 170 */     if (getVoidedBusinessDate() != null) {
/* 171 */       buf.append("voidedBusinessDate").append("=").append(getVoidedBusinessDate()).append(" ");
/*     */     }
/* 173 */     if (getVoidedWorkstationId() != null) {
/* 174 */       buf.append("voidedWorkstationId").append("=").append(getVoidedWorkstationId()).append(" ");
/*     */     }
/* 176 */     if (getVoidedTransactionId() != null) {
/* 177 */       buf.append("voidedTransactionId").append("=").append(getVoidedTransactionId()).append(" ");
/*     */     }
/* 179 */     if (getVoidedRetailStoreId() != null) {
/* 180 */       buf.append("voidedRetailStoreId").append("=").append(getVoidedRetailStoreId()).append(" ");
/*     */     }
/* 182 */     if (getVoidedOrganizationId() != null) {
/* 183 */       buf.append("voidedOrganizationId").append("=").append(getVoidedOrganizationId()).append(" ");
/*     */     }
/* 185 */     if (getPostVoidReasonCode() != null) {
/* 186 */       buf.append("postVoidReasonCode").append("=").append(getPostVoidReasonCode()).append(" ");
/*     */     }
/*     */     
/* 189 */     return buf.toString();
/*     */   }
/*     */ 
/*     */   
/*     */   public String toXmlString() {
/* 194 */     StringBuilder buf = new StringBuilder(2000);
/* 195 */     buf.append("<").append("dao").append(" name=\"PostVoidTransaction\" cmd=\"" + getObjectStateString() + "\">");
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
/* 208 */     if (this._voidedTransactionEntryCode != null) values.put("VoidedTransactionEntryCode", DaoUtils.getXmlSafeFieldValue(12, this._voidedTransactionEntryCode)); 
/* 209 */     if (this._voidedBusinessDate != null) values.put("VoidedBusinessDate", DaoUtils.getXmlSafeFieldValue(91, this._voidedBusinessDate)); 
/* 210 */     if (this._voidedWorkstationId != null) values.put("VoidedWorkstationId", DaoUtils.getXmlSafeFieldValue(-5, this._voidedWorkstationId)); 
/* 211 */     if (this._voidedTransactionId != null) values.put("VoidedTransactionId", DaoUtils.getXmlSafeFieldValue(-5, this._voidedTransactionId)); 
/* 212 */     if (this._voidedRetailStoreId != null) values.put("VoidedRetailStoreId", DaoUtils.getXmlSafeFieldValue(-5, this._voidedRetailStoreId)); 
/* 213 */     if (this._voidedOrganizationId != null) values.put("VoidedOrganizationId", DaoUtils.getXmlSafeFieldValue(-5, this._voidedOrganizationId)); 
/* 214 */     if (this._postVoidReasonCode != null) values.put("PostVoidReasonCode", DaoUtils.getXmlSafeFieldValue(12, this._postVoidReasonCode)); 
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
/*     */         case "VoidedTransactionEntryCode":
/*     */           try {
/* 265 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 266 */             setVoidedTransactionEntryCode((String)value);
/* 267 */           } catch (Exception ee) {
/* 268 */             throw new DtxException("An exception occurred while calling setVoidedTransactionEntryCode() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "VoidedBusinessDate":
/*     */           try {
/* 274 */             Object value = DaoUtils.getFieldValueForXmlString(91, fieldValue);
/* 275 */             setVoidedBusinessDate((Date)value);
/* 276 */           } catch (Exception ee) {
/* 277 */             throw new DtxException("An exception occurred while calling setVoidedBusinessDate() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "VoidedWorkstationId":
/*     */           try {
/* 283 */             Object value = DaoUtils.getFieldValueForXmlString(-5, fieldValue);
/* 284 */             setVoidedWorkstationId((Long)value);
/* 285 */           } catch (Exception ee) {
/* 286 */             throw new DtxException("An exception occurred while calling setVoidedWorkstationId() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "VoidedTransactionId":
/*     */           try {
/* 292 */             Object value = DaoUtils.getFieldValueForXmlString(-5, fieldValue);
/* 293 */             setVoidedTransactionId((Long)value);
/* 294 */           } catch (Exception ee) {
/* 295 */             throw new DtxException("An exception occurred while calling setVoidedTransactionId() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "VoidedRetailStoreId":
/*     */           try {
/* 301 */             Object value = DaoUtils.getFieldValueForXmlString(-5, fieldValue);
/* 302 */             setVoidedRetailStoreId((Long)value);
/* 303 */           } catch (Exception ee) {
/* 304 */             throw new DtxException("An exception occurred while calling setVoidedRetailStoreId() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "VoidedOrganizationId":
/*     */           try {
/* 310 */             Object value = DaoUtils.getFieldValueForXmlString(-5, fieldValue);
/* 311 */             setVoidedOrganizationId((Long)value);
/* 312 */           } catch (Exception ee) {
/* 313 */             throw new DtxException("An exception occurred while calling setVoidedOrganizationId() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "PostVoidReasonCode":
/*     */           try {
/* 319 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 320 */             setPostVoidReasonCode((String)value);
/* 321 */           } catch (Exception ee) {
/* 322 */             throw new DtxException("An exception occurred while calling setPostVoidReasonCode() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */       } 
/*     */     } 
/*     */   }
/*     */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\trn\impl\PostVoidTransactionDAO.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */