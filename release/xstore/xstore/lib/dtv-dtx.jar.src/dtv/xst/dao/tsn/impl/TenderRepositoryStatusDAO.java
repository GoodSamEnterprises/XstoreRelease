/*     */ package dtv.xst.dao.tsn.impl;
/*     */ 
/*     */ import dtv.data2.access.DaoUtils;
/*     */ import dtv.data2.access.IObjectId;
/*     */ import dtv.data2.access.exception.DtxException;
/*     */ import dtv.data2.access.impl.AbstractDAOImpl;
/*     */ import dtv.util.DtvDate;
/*     */ import dtv.xst.dao.tsn.TenderRepositoryStatusId;
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
/*     */ public class TenderRepositoryStatusDAO
/*     */   extends AbstractDAOImpl
/*     */ {
/*     */   private static final long serialVersionUID = -1132449040L;
/*  23 */   private static final Logger _logger = Logger.getLogger(TenderRepositoryStatusDAO.class);
/*     */   
/*     */   private Long _organizationId;
/*     */   private Long _retailLocationId;
/*     */   private String _tenderRepositoryId;
/*     */   private DtvDate _createDate;
/*     */   private String _createUserId;
/*     */   private DtvDate _updateDate;
/*     */   private String _updateUserId;
/*  32 */   private Boolean _issued = Boolean.FALSE;
/*     */   private Long _activeSessionId;
/*     */   
/*     */   public Long getOrganizationId() {
/*  36 */     return this._organizationId;
/*     */   }
/*     */   
/*     */   public void setOrganizationId(Long argOrganizationId) {
/*  40 */     if (changed(argOrganizationId, this._organizationId, "organizationId")) {
/*  41 */       this._organizationId = argOrganizationId;
/*     */     }
/*     */   }
/*     */   
/*     */   public Long getRetailLocationId() {
/*  46 */     return this._retailLocationId;
/*     */   }
/*     */   
/*     */   public void setRetailLocationId(Long argRetailLocationId) {
/*  50 */     if (changed(argRetailLocationId, this._retailLocationId, "retailLocationId")) {
/*  51 */       this._retailLocationId = argRetailLocationId;
/*     */     }
/*     */   }
/*     */   
/*     */   public String getTenderRepositoryId() {
/*  56 */     return this._tenderRepositoryId;
/*     */   }
/*     */   
/*     */   public void setTenderRepositoryId(String argTenderRepositoryId) {
/*  60 */     if (changed(argTenderRepositoryId, this._tenderRepositoryId, "tenderRepositoryId")) {
/*  61 */       this._tenderRepositoryId = (argTenderRepositoryId != null && MANAGE_CASE) ? argTenderRepositoryId.toUpperCase() : argTenderRepositoryId;
/*     */     }
/*     */   }
/*     */   
/*     */   public Date getCreateDate() {
/*  66 */     return (Date)this._createDate;
/*     */   }
/*     */   
/*     */   public void setCreateDate(Date argCreateDate) {
/*  70 */     if (changed(argCreateDate, this._createDate, "createDate")) {
/*  71 */       this._createDate = (argCreateDate == null || argCreateDate instanceof DtvDate) ? (DtvDate)argCreateDate : new DtvDate(argCreateDate);
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public String getCreateUserId() {
/*  77 */     return this._createUserId;
/*     */   }
/*     */   
/*     */   public void setCreateUserId(String argCreateUserId) {
/*  81 */     if (changed(argCreateUserId, this._createUserId, "createUserId")) {
/*  82 */       this._createUserId = argCreateUserId;
/*     */     }
/*     */   }
/*     */   
/*     */   public Date getUpdateDate() {
/*  87 */     return (Date)this._updateDate;
/*     */   }
/*     */   
/*     */   public void setUpdateDate(Date argUpdateDate) {
/*  91 */     if (changed(argUpdateDate, this._updateDate, "updateDate")) {
/*  92 */       this._updateDate = (argUpdateDate == null || argUpdateDate instanceof DtvDate) ? (DtvDate)argUpdateDate : new DtvDate(argUpdateDate);
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public String getUpdateUserId() {
/*  98 */     return this._updateUserId;
/*     */   }
/*     */   
/*     */   public void setUpdateUserId(String argUpdateUserId) {
/* 102 */     if (changed(argUpdateUserId, this._updateUserId, "updateUserId")) {
/* 103 */       this._updateUserId = argUpdateUserId;
/*     */     }
/*     */   }
/*     */   
/*     */   public Boolean getIssued() {
/* 108 */     return this._issued;
/*     */   }
/*     */   
/*     */   public void setIssued(Boolean argIssued) {
/* 112 */     if (changed(argIssued, this._issued, "issued")) {
/* 113 */       this._issued = argIssued;
/*     */     }
/*     */   }
/*     */   
/*     */   public Long getActiveSessionId() {
/* 118 */     return this._activeSessionId;
/*     */   }
/*     */   
/*     */   public void setActiveSessionId(Long argActiveSessionId) {
/* 122 */     if (changed(argActiveSessionId, this._activeSessionId, "activeSessionId")) {
/* 123 */       this._activeSessionId = argActiveSessionId;
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public String toString() {
/* 130 */     StringBuilder buf = new StringBuilder(512);
/* 131 */     buf.append(super.toString()).append(" Id: ").append(getObjectId()).append(" Values: ");
/* 132 */     if (getOrganizationId() != null) {
/* 133 */       buf.append("organizationId").append("=").append(getOrganizationId()).append(" ");
/*     */     }
/* 135 */     if (getRetailLocationId() != null) {
/* 136 */       buf.append("retailLocationId").append("=").append(getRetailLocationId()).append(" ");
/*     */     }
/* 138 */     if (getTenderRepositoryId() != null) {
/* 139 */       buf.append("tenderRepositoryId").append("=").append(getTenderRepositoryId()).append(" ");
/*     */     }
/* 141 */     if (getCreateDate() != null) {
/* 142 */       buf.append("createDate").append("=").append(getCreateDate()).append(" ");
/*     */     }
/* 144 */     if (getCreateUserId() != null) {
/* 145 */       buf.append("createUserId").append("=").append(getCreateUserId()).append(" ");
/*     */     }
/* 147 */     if (getUpdateDate() != null) {
/* 148 */       buf.append("updateDate").append("=").append(getUpdateDate()).append(" ");
/*     */     }
/* 150 */     if (getUpdateUserId() != null) {
/* 151 */       buf.append("updateUserId").append("=").append(getUpdateUserId()).append(" ");
/*     */     }
/* 153 */     if (getIssued() != null && getIssued().booleanValue()) {
/* 154 */       buf.append("issued").append("=").append(getIssued()).append(" ");
/*     */     }
/* 156 */     if (getActiveSessionId() != null) {
/* 157 */       buf.append("activeSessionId").append("=").append(getActiveSessionId()).append(" ");
/*     */     }
/*     */     
/* 160 */     return buf.toString();
/*     */   }
/*     */   
/*     */   public IObjectId getObjectId() {
/* 164 */     TenderRepositoryStatusId id = new TenderRepositoryStatusId();
/* 165 */     id.setOrganizationId(getOrganizationId());
/* 166 */     id.setRetailLocationId(getRetailLocationId());
/* 167 */     id.setTenderRepositoryId(getTenderRepositoryId());
/* 168 */     return (IObjectId)id;
/*     */   }
/*     */   
/*     */   public void setObjectId(IObjectId argObjectId) {
/* 172 */     setOrganizationId(((TenderRepositoryStatusId)argObjectId).getOrganizationId());
/* 173 */     setRetailLocationId(((TenderRepositoryStatusId)argObjectId).getRetailLocationId());
/* 174 */     setTenderRepositoryId(((TenderRepositoryStatusId)argObjectId).getTenderRepositoryId());
/*     */   }
/*     */   
/*     */   public String getImplementingClass() {
/* 178 */     return null;
/*     */   }
/*     */   
/*     */   public String toXmlString() {
/* 182 */     StringBuilder buf = new StringBuilder(450);
/* 183 */     buf.append("<").append("dao").append(" name=\"TenderRepositoryStatus\" cmd=\"" + getObjectStateString() + "\">");
/* 184 */     getFieldsAsXml(buf);
/* 185 */     buf.append("</").append("dao").append(">");
/*     */     
/* 187 */     return buf.toString();
/*     */   }
/*     */   
/*     */   public Map<String, String> getValues() {
/* 191 */     Map<String, String> values = super.getValues();
/* 192 */     if (this._organizationId != null) values.put("OrganizationId", DaoUtils.getXmlSafeFieldValue(-5, this._organizationId)); 
/* 193 */     if (this._retailLocationId != null) values.put("RetailLocationId", DaoUtils.getXmlSafeFieldValue(-5, this._retailLocationId)); 
/* 194 */     if (this._tenderRepositoryId != null) values.put("TenderRepositoryId", DaoUtils.getXmlSafeFieldValue(12, this._tenderRepositoryId)); 
/* 195 */     if (this._createDate != null) values.put("CreateDate", DaoUtils.getXmlSafeFieldValue(91, this._createDate)); 
/* 196 */     if (this._createUserId != null) values.put("CreateUserId", DaoUtils.getXmlSafeFieldValue(12, this._createUserId)); 
/* 197 */     if (this._updateDate != null) values.put("UpdateDate", DaoUtils.getXmlSafeFieldValue(91, this._updateDate)); 
/* 198 */     if (this._updateUserId != null) values.put("UpdateUserId", DaoUtils.getXmlSafeFieldValue(12, this._updateUserId)); 
/* 199 */     if (this._issued != null) values.put("Issued", DaoUtils.getXmlSafeFieldValue(-7, this._issued)); 
/* 200 */     if (this._activeSessionId != null) values.put("ActiveSessionId", DaoUtils.getXmlSafeFieldValue(-5, this._activeSessionId)); 
/* 201 */     return values;
/*     */   }
/*     */ 
/*     */   
/*     */   public void setValues(Map<String, String> argValues) {
/* 206 */     super.setValues(argValues);
/* 207 */     for (Map.Entry<String, String> field : argValues.entrySet()) {
/*     */       
/* 209 */       String fieldName = field.getKey();
/* 210 */       String fieldValue = field.getValue();
/* 211 */       switch (fieldName) {
/*     */         
/*     */         case "OrganizationId":
/*     */           try {
/* 215 */             Object value = DaoUtils.getFieldValueForXmlString(-5, fieldValue);
/* 216 */             setOrganizationId((Long)value);
/* 217 */           } catch (Exception ee) {
/* 218 */             throw new DtxException("An exception occurred while calling setOrganizationId() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "RetailLocationId":
/*     */           try {
/* 224 */             Object value = DaoUtils.getFieldValueForXmlString(-5, fieldValue);
/* 225 */             setRetailLocationId((Long)value);
/* 226 */           } catch (Exception ee) {
/* 227 */             throw new DtxException("An exception occurred while calling setRetailLocationId() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "TenderRepositoryId":
/*     */           try {
/* 233 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 234 */             setTenderRepositoryId((String)value);
/* 235 */           } catch (Exception ee) {
/* 236 */             throw new DtxException("An exception occurred while calling setTenderRepositoryId() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "CreateDate":
/*     */           try {
/* 242 */             Object value = DaoUtils.getFieldValueForXmlString(91, fieldValue);
/* 243 */             setCreateDate((Date)value);
/* 244 */           } catch (Exception ee) {
/* 245 */             throw new DtxException("An exception occurred while calling setCreateDate() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "CreateUserId":
/*     */           try {
/* 251 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 252 */             setCreateUserId((String)value);
/* 253 */           } catch (Exception ee) {
/* 254 */             throw new DtxException("An exception occurred while calling setCreateUserId() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "UpdateDate":
/*     */           try {
/* 260 */             Object value = DaoUtils.getFieldValueForXmlString(91, fieldValue);
/* 261 */             setUpdateDate((Date)value);
/* 262 */           } catch (Exception ee) {
/* 263 */             throw new DtxException("An exception occurred while calling setUpdateDate() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "UpdateUserId":
/*     */           try {
/* 269 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 270 */             setUpdateUserId((String)value);
/* 271 */           } catch (Exception ee) {
/* 272 */             throw new DtxException("An exception occurred while calling setUpdateUserId() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "Issued":
/*     */           try {
/* 278 */             Object value = DaoUtils.getFieldValueForXmlString(-7, fieldValue);
/* 279 */             setIssued((Boolean)value);
/* 280 */           } catch (Exception ee) {
/* 281 */             throw new DtxException("An exception occurred while calling setIssued() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "ActiveSessionId":
/*     */           try {
/* 287 */             Object value = DaoUtils.getFieldValueForXmlString(-5, fieldValue);
/* 288 */             setActiveSessionId((Long)value);
/* 289 */           } catch (Exception ee) {
/* 290 */             throw new DtxException("An exception occurred while calling setActiveSessionId() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */       } 
/*     */     } 
/*     */   }
/*     */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\tsn\impl\TenderRepositoryStatusDAO.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */