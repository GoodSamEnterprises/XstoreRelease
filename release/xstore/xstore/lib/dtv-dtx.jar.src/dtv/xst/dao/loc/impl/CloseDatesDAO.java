/*     */ package dtv.xst.dao.loc.impl;
/*     */ 
/*     */ import dtv.data2.access.DaoUtils;
/*     */ import dtv.data2.access.IObjectId;
/*     */ import dtv.data2.access.exception.DtxException;
/*     */ import dtv.data2.access.impl.AbstractDAOImpl;
/*     */ import dtv.util.DtvDate;
/*     */ import dtv.xst.dao.loc.CloseDatesId;
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
/*     */ public class CloseDatesDAO
/*     */   extends AbstractDAOImpl
/*     */ {
/*     */   private static final long serialVersionUID = -93581427L;
/*  23 */   private static final Logger _logger = Logger.getLogger(CloseDatesDAO.class);
/*     */   
/*     */   private Long _organizationId;
/*     */   private Long _retailLocationId;
/*     */   private DtvDate _closeDate;
/*     */   private DtvDate _createDate;
/*     */   private String _createUserId;
/*     */   private DtvDate _updateDate;
/*     */   private String _updateUserId;
/*     */   private String _reasonCode;
/*     */   
/*     */   public Long getOrganizationId() {
/*  35 */     return this._organizationId;
/*     */   }
/*     */   
/*     */   public void setOrganizationId(Long argOrganizationId) {
/*  39 */     if (changed(argOrganizationId, this._organizationId, "organizationId")) {
/*  40 */       this._organizationId = argOrganizationId;
/*     */     }
/*     */   }
/*     */   
/*     */   public Long getRetailLocationId() {
/*  45 */     return this._retailLocationId;
/*     */   }
/*     */   
/*     */   public void setRetailLocationId(Long argRetailLocationId) {
/*  49 */     if (changed(argRetailLocationId, this._retailLocationId, "retailLocationId")) {
/*  50 */       this._retailLocationId = argRetailLocationId;
/*     */     }
/*     */   }
/*     */   
/*     */   public Date getCloseDate() {
/*  55 */     return (Date)this._closeDate;
/*     */   }
/*     */   
/*     */   public void setCloseDate(Date argCloseDate) {
/*  59 */     if (changed(argCloseDate, this._closeDate, "closeDate")) {
/*  60 */       this._closeDate = (argCloseDate == null || argCloseDate instanceof DtvDate) ? (DtvDate)argCloseDate : new DtvDate(argCloseDate);
/*     */     }
/*     */   }
/*     */ 
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
/*     */   public String getReasonCode() {
/* 108 */     return this._reasonCode;
/*     */   }
/*     */   
/*     */   public void setReasonCode(String argReasonCode) {
/* 112 */     if (changed(argReasonCode, this._reasonCode, "reasonCode")) {
/* 113 */       this._reasonCode = argReasonCode;
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public String toString() {
/* 120 */     StringBuilder buf = new StringBuilder(512);
/* 121 */     buf.append(super.toString()).append(" Id: ").append(getObjectId()).append(" Values: ");
/* 122 */     if (getOrganizationId() != null) {
/* 123 */       buf.append("organizationId").append("=").append(getOrganizationId()).append(" ");
/*     */     }
/* 125 */     if (getRetailLocationId() != null) {
/* 126 */       buf.append("retailLocationId").append("=").append(getRetailLocationId()).append(" ");
/*     */     }
/* 128 */     if (getCloseDate() != null) {
/* 129 */       buf.append("closeDate").append("=").append(getCloseDate()).append(" ");
/*     */     }
/* 131 */     if (getCreateDate() != null) {
/* 132 */       buf.append("createDate").append("=").append(getCreateDate()).append(" ");
/*     */     }
/* 134 */     if (getCreateUserId() != null) {
/* 135 */       buf.append("createUserId").append("=").append(getCreateUserId()).append(" ");
/*     */     }
/* 137 */     if (getUpdateDate() != null) {
/* 138 */       buf.append("updateDate").append("=").append(getUpdateDate()).append(" ");
/*     */     }
/* 140 */     if (getUpdateUserId() != null) {
/* 141 */       buf.append("updateUserId").append("=").append(getUpdateUserId()).append(" ");
/*     */     }
/* 143 */     if (getReasonCode() != null) {
/* 144 */       buf.append("reasonCode").append("=").append(getReasonCode()).append(" ");
/*     */     }
/*     */     
/* 147 */     return buf.toString();
/*     */   }
/*     */   
/*     */   public IObjectId getObjectId() {
/* 151 */     CloseDatesId id = new CloseDatesId();
/* 152 */     id.setOrganizationId(getOrganizationId());
/* 153 */     id.setRetailLocationId(getRetailLocationId());
/* 154 */     id.setCloseDate(getCloseDate());
/* 155 */     return (IObjectId)id;
/*     */   }
/*     */   
/*     */   public void setObjectId(IObjectId argObjectId) {
/* 159 */     setOrganizationId(((CloseDatesId)argObjectId).getOrganizationId());
/* 160 */     setRetailLocationId(((CloseDatesId)argObjectId).getRetailLocationId());
/* 161 */     setCloseDate(((CloseDatesId)argObjectId).getCloseDate());
/*     */   }
/*     */   
/*     */   public String getImplementingClass() {
/* 165 */     return null;
/*     */   }
/*     */   
/*     */   public String toXmlString() {
/* 169 */     StringBuilder buf = new StringBuilder(400);
/* 170 */     buf.append("<").append("dao").append(" name=\"CloseDates\" cmd=\"" + getObjectStateString() + "\">");
/* 171 */     getFieldsAsXml(buf);
/* 172 */     buf.append("</").append("dao").append(">");
/*     */     
/* 174 */     return buf.toString();
/*     */   }
/*     */   
/*     */   public Map<String, String> getValues() {
/* 178 */     Map<String, String> values = super.getValues();
/* 179 */     if (this._organizationId != null) values.put("OrganizationId", DaoUtils.getXmlSafeFieldValue(-5, this._organizationId)); 
/* 180 */     if (this._retailLocationId != null) values.put("RetailLocationId", DaoUtils.getXmlSafeFieldValue(-5, this._retailLocationId)); 
/* 181 */     if (this._closeDate != null) values.put("CloseDate", DaoUtils.getXmlSafeFieldValue(91, this._closeDate)); 
/* 182 */     if (this._createDate != null) values.put("CreateDate", DaoUtils.getXmlSafeFieldValue(91, this._createDate)); 
/* 183 */     if (this._createUserId != null) values.put("CreateUserId", DaoUtils.getXmlSafeFieldValue(12, this._createUserId)); 
/* 184 */     if (this._updateDate != null) values.put("UpdateDate", DaoUtils.getXmlSafeFieldValue(91, this._updateDate)); 
/* 185 */     if (this._updateUserId != null) values.put("UpdateUserId", DaoUtils.getXmlSafeFieldValue(12, this._updateUserId)); 
/* 186 */     if (this._reasonCode != null) values.put("ReasonCode", DaoUtils.getXmlSafeFieldValue(12, this._reasonCode)); 
/* 187 */     return values;
/*     */   }
/*     */ 
/*     */   
/*     */   public void setValues(Map<String, String> argValues) {
/* 192 */     super.setValues(argValues);
/* 193 */     for (Map.Entry<String, String> field : argValues.entrySet()) {
/*     */       
/* 195 */       String fieldName = field.getKey();
/* 196 */       String fieldValue = field.getValue();
/* 197 */       switch (fieldName) {
/*     */         
/*     */         case "OrganizationId":
/*     */           try {
/* 201 */             Object value = DaoUtils.getFieldValueForXmlString(-5, fieldValue);
/* 202 */             setOrganizationId((Long)value);
/* 203 */           } catch (Exception ee) {
/* 204 */             throw new DtxException("An exception occurred while calling setOrganizationId() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "RetailLocationId":
/*     */           try {
/* 210 */             Object value = DaoUtils.getFieldValueForXmlString(-5, fieldValue);
/* 211 */             setRetailLocationId((Long)value);
/* 212 */           } catch (Exception ee) {
/* 213 */             throw new DtxException("An exception occurred while calling setRetailLocationId() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "CloseDate":
/*     */           try {
/* 219 */             Object value = DaoUtils.getFieldValueForXmlString(91, fieldValue);
/* 220 */             setCloseDate((Date)value);
/* 221 */           } catch (Exception ee) {
/* 222 */             throw new DtxException("An exception occurred while calling setCloseDate() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "CreateDate":
/*     */           try {
/* 228 */             Object value = DaoUtils.getFieldValueForXmlString(91, fieldValue);
/* 229 */             setCreateDate((Date)value);
/* 230 */           } catch (Exception ee) {
/* 231 */             throw new DtxException("An exception occurred while calling setCreateDate() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "CreateUserId":
/*     */           try {
/* 237 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 238 */             setCreateUserId((String)value);
/* 239 */           } catch (Exception ee) {
/* 240 */             throw new DtxException("An exception occurred while calling setCreateUserId() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "UpdateDate":
/*     */           try {
/* 246 */             Object value = DaoUtils.getFieldValueForXmlString(91, fieldValue);
/* 247 */             setUpdateDate((Date)value);
/* 248 */           } catch (Exception ee) {
/* 249 */             throw new DtxException("An exception occurred while calling setUpdateDate() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "UpdateUserId":
/*     */           try {
/* 255 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 256 */             setUpdateUserId((String)value);
/* 257 */           } catch (Exception ee) {
/* 258 */             throw new DtxException("An exception occurred while calling setUpdateUserId() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "ReasonCode":
/*     */           try {
/* 264 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 265 */             setReasonCode((String)value);
/* 266 */           } catch (Exception ee) {
/* 267 */             throw new DtxException("An exception occurred while calling setReasonCode() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */       } 
/*     */     } 
/*     */   }
/*     */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\loc\impl\CloseDatesDAO.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */