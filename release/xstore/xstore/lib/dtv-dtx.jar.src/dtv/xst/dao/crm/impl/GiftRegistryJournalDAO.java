/*     */ package dtv.xst.dao.crm.impl;
/*     */ 
/*     */ import dtv.data2.access.DaoUtils;
/*     */ import dtv.data2.access.IObjectId;
/*     */ import dtv.data2.access.exception.DtxException;
/*     */ import dtv.data2.access.impl.AbstractDAOImpl;
/*     */ import dtv.util.DtvDate;
/*     */ import dtv.xst.dao.crm.GiftRegistryJournalId;
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
/*     */ public class GiftRegistryJournalDAO
/*     */   extends AbstractDAOImpl
/*     */ {
/*     */   private static final long serialVersionUID = -909944630L;
/*  23 */   private static final Logger _logger = Logger.getLogger(GiftRegistryJournalDAO.class);
/*     */   
/*     */   private Long _organizationId;
/*     */   private Long _journalSequence;
/*     */   private DtvDate _createDate;
/*     */   private String _createUserId;
/*     */   private DtvDate _updateDate;
/*     */   private String _updateUserId;
/*     */   private Long _registryId;
/*     */   private String _actionCode;
/*     */   private String _registryStatus;
/*     */   private Long _transRetailLocationId;
/*     */   private Long _transWorkstationId;
/*     */   private DtvDate _transBusinessDate;
/*     */   private Long _transSequence;
/*     */   
/*     */   public Long getOrganizationId() {
/*  40 */     return this._organizationId;
/*     */   }
/*     */   
/*     */   public void setOrganizationId(Long argOrganizationId) {
/*  44 */     if (changed(argOrganizationId, this._organizationId, "organizationId")) {
/*  45 */       this._organizationId = argOrganizationId;
/*     */     }
/*     */   }
/*     */   
/*     */   public Long getJournalSequence() {
/*  50 */     return this._journalSequence;
/*     */   }
/*     */   
/*     */   public void setJournalSequence(Long argJournalSequence) {
/*  54 */     if (changed(argJournalSequence, this._journalSequence, "journalSequence")) {
/*  55 */       this._journalSequence = argJournalSequence;
/*     */     }
/*     */   }
/*     */   
/*     */   public Date getCreateDate() {
/*  60 */     return (Date)this._createDate;
/*     */   }
/*     */   
/*     */   public void setCreateDate(Date argCreateDate) {
/*  64 */     if (changed(argCreateDate, this._createDate, "createDate")) {
/*  65 */       this._createDate = (argCreateDate == null || argCreateDate instanceof DtvDate) ? (DtvDate)argCreateDate : new DtvDate(argCreateDate);
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public String getCreateUserId() {
/*  71 */     return this._createUserId;
/*     */   }
/*     */   
/*     */   public void setCreateUserId(String argCreateUserId) {
/*  75 */     if (changed(argCreateUserId, this._createUserId, "createUserId")) {
/*  76 */       this._createUserId = argCreateUserId;
/*     */     }
/*     */   }
/*     */   
/*     */   public Date getUpdateDate() {
/*  81 */     return (Date)this._updateDate;
/*     */   }
/*     */   
/*     */   public void setUpdateDate(Date argUpdateDate) {
/*  85 */     if (changed(argUpdateDate, this._updateDate, "updateDate")) {
/*  86 */       this._updateDate = (argUpdateDate == null || argUpdateDate instanceof DtvDate) ? (DtvDate)argUpdateDate : new DtvDate(argUpdateDate);
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public String getUpdateUserId() {
/*  92 */     return this._updateUserId;
/*     */   }
/*     */   
/*     */   public void setUpdateUserId(String argUpdateUserId) {
/*  96 */     if (changed(argUpdateUserId, this._updateUserId, "updateUserId")) {
/*  97 */       this._updateUserId = argUpdateUserId;
/*     */     }
/*     */   }
/*     */   
/*     */   public Long getRegistryId() {
/* 102 */     return this._registryId;
/*     */   }
/*     */   
/*     */   public void setRegistryId(Long argRegistryId) {
/* 106 */     if (changed(argRegistryId, this._registryId, "registryId")) {
/* 107 */       this._registryId = argRegistryId;
/*     */     }
/*     */   }
/*     */   
/*     */   public String getActionCode() {
/* 112 */     return this._actionCode;
/*     */   }
/*     */   
/*     */   public void setActionCode(String argActionCode) {
/* 116 */     if (changed(argActionCode, this._actionCode, "actionCode")) {
/* 117 */       this._actionCode = argActionCode;
/*     */     }
/*     */   }
/*     */   
/*     */   public String getRegistryStatus() {
/* 122 */     return this._registryStatus;
/*     */   }
/*     */   
/*     */   public void setRegistryStatus(String argRegistryStatus) {
/* 126 */     if (changed(argRegistryStatus, this._registryStatus, "registryStatus")) {
/* 127 */       this._registryStatus = argRegistryStatus;
/*     */     }
/*     */   }
/*     */   
/*     */   public Long getTransRetailLocationId() {
/* 132 */     return this._transRetailLocationId;
/*     */   }
/*     */   
/*     */   public void setTransRetailLocationId(Long argTransRetailLocationId) {
/* 136 */     if (changed(argTransRetailLocationId, this._transRetailLocationId, "transRetailLocationId")) {
/* 137 */       this._transRetailLocationId = argTransRetailLocationId;
/*     */     }
/*     */   }
/*     */   
/*     */   public Long getTransWorkstationId() {
/* 142 */     return this._transWorkstationId;
/*     */   }
/*     */   
/*     */   public void setTransWorkstationId(Long argTransWorkstationId) {
/* 146 */     if (changed(argTransWorkstationId, this._transWorkstationId, "transWorkstationId")) {
/* 147 */       this._transWorkstationId = argTransWorkstationId;
/*     */     }
/*     */   }
/*     */   
/*     */   public Date getTransBusinessDate() {
/* 152 */     return (Date)this._transBusinessDate;
/*     */   }
/*     */   
/*     */   public void setTransBusinessDate(Date argTransBusinessDate) {
/* 156 */     if (changed(argTransBusinessDate, this._transBusinessDate, "transBusinessDate")) {
/* 157 */       this._transBusinessDate = (argTransBusinessDate == null || argTransBusinessDate instanceof DtvDate) ? (DtvDate)argTransBusinessDate : new DtvDate(argTransBusinessDate);
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public Long getTransSequence() {
/* 163 */     return this._transSequence;
/*     */   }
/*     */   
/*     */   public void setTransSequence(Long argTransSequence) {
/* 167 */     if (changed(argTransSequence, this._transSequence, "transSequence")) {
/* 168 */       this._transSequence = argTransSequence;
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public String toString() {
/* 175 */     StringBuilder buf = new StringBuilder(512);
/* 176 */     buf.append(super.toString()).append(" Id: ").append(getObjectId()).append(" Values: ");
/* 177 */     if (getOrganizationId() != null) {
/* 178 */       buf.append("organizationId").append("=").append(getOrganizationId()).append(" ");
/*     */     }
/* 180 */     if (getJournalSequence() != null) {
/* 181 */       buf.append("journalSequence").append("=").append(getJournalSequence()).append(" ");
/*     */     }
/* 183 */     if (getCreateDate() != null) {
/* 184 */       buf.append("createDate").append("=").append(getCreateDate()).append(" ");
/*     */     }
/* 186 */     if (getCreateUserId() != null) {
/* 187 */       buf.append("createUserId").append("=").append(getCreateUserId()).append(" ");
/*     */     }
/* 189 */     if (getUpdateDate() != null) {
/* 190 */       buf.append("updateDate").append("=").append(getUpdateDate()).append(" ");
/*     */     }
/* 192 */     if (getUpdateUserId() != null) {
/* 193 */       buf.append("updateUserId").append("=").append(getUpdateUserId()).append(" ");
/*     */     }
/* 195 */     if (getRegistryId() != null) {
/* 196 */       buf.append("registryId").append("=").append(getRegistryId()).append(" ");
/*     */     }
/* 198 */     if (getActionCode() != null) {
/* 199 */       buf.append("actionCode").append("=").append(getActionCode()).append(" ");
/*     */     }
/* 201 */     if (getRegistryStatus() != null) {
/* 202 */       buf.append("registryStatus").append("=").append(getRegistryStatus()).append(" ");
/*     */     }
/* 204 */     if (getTransRetailLocationId() != null) {
/* 205 */       buf.append("transRetailLocationId").append("=").append(getTransRetailLocationId()).append(" ");
/*     */     }
/* 207 */     if (getTransWorkstationId() != null) {
/* 208 */       buf.append("transWorkstationId").append("=").append(getTransWorkstationId()).append(" ");
/*     */     }
/* 210 */     if (getTransBusinessDate() != null) {
/* 211 */       buf.append("transBusinessDate").append("=").append(getTransBusinessDate()).append(" ");
/*     */     }
/* 213 */     if (getTransSequence() != null) {
/* 214 */       buf.append("transSequence").append("=").append(getTransSequence()).append(" ");
/*     */     }
/*     */     
/* 217 */     return buf.toString();
/*     */   }
/*     */   
/*     */   public IObjectId getObjectId() {
/* 221 */     GiftRegistryJournalId id = new GiftRegistryJournalId();
/* 222 */     id.setOrganizationId(getOrganizationId());
/* 223 */     id.setJournalSequence(getJournalSequence());
/* 224 */     return (IObjectId)id;
/*     */   }
/*     */   
/*     */   public void setObjectId(IObjectId argObjectId) {
/* 228 */     setOrganizationId(((GiftRegistryJournalId)argObjectId).getOrganizationId());
/* 229 */     setJournalSequence(((GiftRegistryJournalId)argObjectId).getJournalSequence());
/*     */   }
/*     */   
/*     */   public String getImplementingClass() {
/* 233 */     return null;
/*     */   }
/*     */   
/*     */   public String toXmlString() {
/* 237 */     StringBuilder buf = new StringBuilder(650);
/* 238 */     buf.append("<").append("dao").append(" name=\"GiftRegistryJournal\" cmd=\"" + getObjectStateString() + "\">");
/* 239 */     getFieldsAsXml(buf);
/* 240 */     buf.append("</").append("dao").append(">");
/*     */     
/* 242 */     return buf.toString();
/*     */   }
/*     */   
/*     */   public Map<String, String> getValues() {
/* 246 */     Map<String, String> values = super.getValues();
/* 247 */     if (this._organizationId != null) values.put("OrganizationId", DaoUtils.getXmlSafeFieldValue(-5, this._organizationId)); 
/* 248 */     if (this._journalSequence != null) values.put("JournalSequence", DaoUtils.getXmlSafeFieldValue(-5, this._journalSequence)); 
/* 249 */     if (this._createDate != null) values.put("CreateDate", DaoUtils.getXmlSafeFieldValue(91, this._createDate)); 
/* 250 */     if (this._createUserId != null) values.put("CreateUserId", DaoUtils.getXmlSafeFieldValue(12, this._createUserId)); 
/* 251 */     if (this._updateDate != null) values.put("UpdateDate", DaoUtils.getXmlSafeFieldValue(91, this._updateDate)); 
/* 252 */     if (this._updateUserId != null) values.put("UpdateUserId", DaoUtils.getXmlSafeFieldValue(12, this._updateUserId)); 
/* 253 */     if (this._registryId != null) values.put("RegistryId", DaoUtils.getXmlSafeFieldValue(-5, this._registryId)); 
/* 254 */     if (this._actionCode != null) values.put("ActionCode", DaoUtils.getXmlSafeFieldValue(12, this._actionCode)); 
/* 255 */     if (this._registryStatus != null) values.put("RegistryStatus", DaoUtils.getXmlSafeFieldValue(12, this._registryStatus)); 
/* 256 */     if (this._transRetailLocationId != null) values.put("TransRetailLocationId", DaoUtils.getXmlSafeFieldValue(-5, this._transRetailLocationId)); 
/* 257 */     if (this._transWorkstationId != null) values.put("TransWorkstationId", DaoUtils.getXmlSafeFieldValue(-5, this._transWorkstationId)); 
/* 258 */     if (this._transBusinessDate != null) values.put("TransBusinessDate", DaoUtils.getXmlSafeFieldValue(91, this._transBusinessDate)); 
/* 259 */     if (this._transSequence != null) values.put("TransSequence", DaoUtils.getXmlSafeFieldValue(-5, this._transSequence)); 
/* 260 */     return values;
/*     */   }
/*     */ 
/*     */   
/*     */   public void setValues(Map<String, String> argValues) {
/* 265 */     super.setValues(argValues);
/* 266 */     for (Map.Entry<String, String> field : argValues.entrySet()) {
/*     */       
/* 268 */       String fieldName = field.getKey();
/* 269 */       String fieldValue = field.getValue();
/* 270 */       switch (fieldName) {
/*     */         
/*     */         case "OrganizationId":
/*     */           try {
/* 274 */             Object value = DaoUtils.getFieldValueForXmlString(-5, fieldValue);
/* 275 */             setOrganizationId((Long)value);
/* 276 */           } catch (Exception ee) {
/* 277 */             throw new DtxException("An exception occurred while calling setOrganizationId() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "JournalSequence":
/*     */           try {
/* 283 */             Object value = DaoUtils.getFieldValueForXmlString(-5, fieldValue);
/* 284 */             setJournalSequence((Long)value);
/* 285 */           } catch (Exception ee) {
/* 286 */             throw new DtxException("An exception occurred while calling setJournalSequence() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "CreateDate":
/*     */           try {
/* 292 */             Object value = DaoUtils.getFieldValueForXmlString(91, fieldValue);
/* 293 */             setCreateDate((Date)value);
/* 294 */           } catch (Exception ee) {
/* 295 */             throw new DtxException("An exception occurred while calling setCreateDate() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "CreateUserId":
/*     */           try {
/* 301 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 302 */             setCreateUserId((String)value);
/* 303 */           } catch (Exception ee) {
/* 304 */             throw new DtxException("An exception occurred while calling setCreateUserId() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "UpdateDate":
/*     */           try {
/* 310 */             Object value = DaoUtils.getFieldValueForXmlString(91, fieldValue);
/* 311 */             setUpdateDate((Date)value);
/* 312 */           } catch (Exception ee) {
/* 313 */             throw new DtxException("An exception occurred while calling setUpdateDate() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "UpdateUserId":
/*     */           try {
/* 319 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 320 */             setUpdateUserId((String)value);
/* 321 */           } catch (Exception ee) {
/* 322 */             throw new DtxException("An exception occurred while calling setUpdateUserId() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "RegistryId":
/*     */           try {
/* 328 */             Object value = DaoUtils.getFieldValueForXmlString(-5, fieldValue);
/* 329 */             setRegistryId((Long)value);
/* 330 */           } catch (Exception ee) {
/* 331 */             throw new DtxException("An exception occurred while calling setRegistryId() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "ActionCode":
/*     */           try {
/* 337 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 338 */             setActionCode((String)value);
/* 339 */           } catch (Exception ee) {
/* 340 */             throw new DtxException("An exception occurred while calling setActionCode() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "RegistryStatus":
/*     */           try {
/* 346 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 347 */             setRegistryStatus((String)value);
/* 348 */           } catch (Exception ee) {
/* 349 */             throw new DtxException("An exception occurred while calling setRegistryStatus() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "TransRetailLocationId":
/*     */           try {
/* 355 */             Object value = DaoUtils.getFieldValueForXmlString(-5, fieldValue);
/* 356 */             setTransRetailLocationId((Long)value);
/* 357 */           } catch (Exception ee) {
/* 358 */             throw new DtxException("An exception occurred while calling setTransRetailLocationId() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "TransWorkstationId":
/*     */           try {
/* 364 */             Object value = DaoUtils.getFieldValueForXmlString(-5, fieldValue);
/* 365 */             setTransWorkstationId((Long)value);
/* 366 */           } catch (Exception ee) {
/* 367 */             throw new DtxException("An exception occurred while calling setTransWorkstationId() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "TransBusinessDate":
/*     */           try {
/* 373 */             Object value = DaoUtils.getFieldValueForXmlString(91, fieldValue);
/* 374 */             setTransBusinessDate((Date)value);
/* 375 */           } catch (Exception ee) {
/* 376 */             throw new DtxException("An exception occurred while calling setTransBusinessDate() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "TransSequence":
/*     */           try {
/* 382 */             Object value = DaoUtils.getFieldValueForXmlString(-5, fieldValue);
/* 383 */             setTransSequence((Long)value);
/* 384 */           } catch (Exception ee) {
/* 385 */             throw new DtxException("An exception occurred while calling setTransSequence() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */       } 
/*     */     } 
/*     */   }
/*     */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\crm\impl\GiftRegistryJournalDAO.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */