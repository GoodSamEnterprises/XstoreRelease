/*     */ package dtv.xst.dao.com.impl;
/*     */ 
/*     */ import dtv.data2.access.DaoUtils;
/*     */ import dtv.data2.access.IObjectId;
/*     */ import dtv.data2.access.exception.DtxException;
/*     */ import dtv.data2.access.impl.AbstractDAOImpl;
/*     */ import dtv.util.DtvDate;
/*     */ import dtv.xst.dao.com.SequenceId;
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
/*     */ public class SequenceDAO
/*     */   extends AbstractDAOImpl
/*     */ {
/*     */   private static final long serialVersionUID = 1414192097L;
/*  23 */   private static final Logger _logger = Logger.getLogger(SequenceDAO.class);
/*     */   
/*     */   private Long _organizationId;
/*     */   private Long _retailLocationId;
/*     */   private Long _workstationId;
/*     */   private String _sequenceId;
/*     */   private String _sequenceMode;
/*     */   private DtvDate _createDate;
/*     */   private String _createUserId;
/*     */   private DtvDate _updateDate;
/*     */   private String _updateUserId;
/*     */   private Long _sequenceNumber;
/*     */   
/*     */   public Long getOrganizationId() {
/*  37 */     return this._organizationId;
/*     */   }
/*     */   
/*     */   public void setOrganizationId(Long argOrganizationId) {
/*  41 */     if (changed(argOrganizationId, this._organizationId, "organizationId")) {
/*  42 */       this._organizationId = argOrganizationId;
/*     */     }
/*     */   }
/*     */   
/*     */   public Long getRetailLocationId() {
/*  47 */     return this._retailLocationId;
/*     */   }
/*     */   
/*     */   public void setRetailLocationId(Long argRetailLocationId) {
/*  51 */     if (changed(argRetailLocationId, this._retailLocationId, "retailLocationId")) {
/*  52 */       this._retailLocationId = argRetailLocationId;
/*     */     }
/*     */   }
/*     */   
/*     */   public Long getWorkstationId() {
/*  57 */     return this._workstationId;
/*     */   }
/*     */   
/*     */   public void setWorkstationId(Long argWorkstationId) {
/*  61 */     if (changed(argWorkstationId, this._workstationId, "workstationId")) {
/*  62 */       this._workstationId = argWorkstationId;
/*     */     }
/*     */   }
/*     */   
/*     */   public String getSequenceId() {
/*  67 */     return this._sequenceId;
/*     */   }
/*     */   
/*     */   public void setSequenceId(String argSequenceId) {
/*  71 */     if (changed(argSequenceId, this._sequenceId, "sequenceId")) {
/*  72 */       this._sequenceId = (argSequenceId != null && MANAGE_CASE) ? argSequenceId.toUpperCase() : argSequenceId;
/*     */     }
/*     */   }
/*     */   
/*     */   public String getSequenceMode() {
/*  77 */     return this._sequenceMode;
/*     */   }
/*     */   
/*     */   public void setSequenceMode(String argSequenceMode) {
/*  81 */     if (changed(argSequenceMode, this._sequenceMode, "sequenceMode")) {
/*  82 */       this._sequenceMode = (argSequenceMode != null && MANAGE_CASE) ? argSequenceMode.toUpperCase() : argSequenceMode;
/*     */     }
/*     */   }
/*     */   
/*     */   public Date getCreateDate() {
/*  87 */     return (Date)this._createDate;
/*     */   }
/*     */   
/*     */   public void setCreateDate(Date argCreateDate) {
/*  91 */     if (changed(argCreateDate, this._createDate, "createDate")) {
/*  92 */       this._createDate = (argCreateDate == null || argCreateDate instanceof DtvDate) ? (DtvDate)argCreateDate : new DtvDate(argCreateDate);
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public String getCreateUserId() {
/*  98 */     return this._createUserId;
/*     */   }
/*     */   
/*     */   public void setCreateUserId(String argCreateUserId) {
/* 102 */     if (changed(argCreateUserId, this._createUserId, "createUserId")) {
/* 103 */       this._createUserId = argCreateUserId;
/*     */     }
/*     */   }
/*     */   
/*     */   public Date getUpdateDate() {
/* 108 */     return (Date)this._updateDate;
/*     */   }
/*     */   
/*     */   public void setUpdateDate(Date argUpdateDate) {
/* 112 */     if (changed(argUpdateDate, this._updateDate, "updateDate")) {
/* 113 */       this._updateDate = (argUpdateDate == null || argUpdateDate instanceof DtvDate) ? (DtvDate)argUpdateDate : new DtvDate(argUpdateDate);
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public String getUpdateUserId() {
/* 119 */     return this._updateUserId;
/*     */   }
/*     */   
/*     */   public void setUpdateUserId(String argUpdateUserId) {
/* 123 */     if (changed(argUpdateUserId, this._updateUserId, "updateUserId")) {
/* 124 */       this._updateUserId = argUpdateUserId;
/*     */     }
/*     */   }
/*     */   
/*     */   public Long getSequenceNumber() {
/* 129 */     return this._sequenceNumber;
/*     */   }
/*     */   
/*     */   public void setSequenceNumber(Long argSequenceNumber) {
/* 133 */     if (changed(argSequenceNumber, this._sequenceNumber, "sequenceNumber")) {
/* 134 */       this._sequenceNumber = argSequenceNumber;
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public String toString() {
/* 141 */     StringBuilder buf = new StringBuilder(512);
/* 142 */     buf.append(super.toString()).append(" Id: ").append(getObjectId()).append(" Values: ");
/* 143 */     if (getOrganizationId() != null) {
/* 144 */       buf.append("organizationId").append("=").append(getOrganizationId()).append(" ");
/*     */     }
/* 146 */     if (getRetailLocationId() != null) {
/* 147 */       buf.append("retailLocationId").append("=").append(getRetailLocationId()).append(" ");
/*     */     }
/* 149 */     if (getWorkstationId() != null) {
/* 150 */       buf.append("workstationId").append("=").append(getWorkstationId()).append(" ");
/*     */     }
/* 152 */     if (getSequenceId() != null) {
/* 153 */       buf.append("sequenceId").append("=").append(getSequenceId()).append(" ");
/*     */     }
/* 155 */     if (getSequenceMode() != null) {
/* 156 */       buf.append("sequenceMode").append("=").append(getSequenceMode()).append(" ");
/*     */     }
/* 158 */     if (getCreateDate() != null) {
/* 159 */       buf.append("createDate").append("=").append(getCreateDate()).append(" ");
/*     */     }
/* 161 */     if (getCreateUserId() != null) {
/* 162 */       buf.append("createUserId").append("=").append(getCreateUserId()).append(" ");
/*     */     }
/* 164 */     if (getUpdateDate() != null) {
/* 165 */       buf.append("updateDate").append("=").append(getUpdateDate()).append(" ");
/*     */     }
/* 167 */     if (getUpdateUserId() != null) {
/* 168 */       buf.append("updateUserId").append("=").append(getUpdateUserId()).append(" ");
/*     */     }
/* 170 */     if (getSequenceNumber() != null) {
/* 171 */       buf.append("sequenceNumber").append("=").append(getSequenceNumber()).append(" ");
/*     */     }
/*     */     
/* 174 */     return buf.toString();
/*     */   }
/*     */   
/*     */   public IObjectId getObjectId() {
/* 178 */     SequenceId id = new SequenceId();
/* 179 */     id.setOrganizationId(getOrganizationId());
/* 180 */     id.setRetailLocationId(getRetailLocationId());
/* 181 */     id.setWorkstationId(getWorkstationId());
/* 182 */     id.setSequenceId(getSequenceId());
/* 183 */     id.setSequenceMode(getSequenceMode());
/* 184 */     return (IObjectId)id;
/*     */   }
/*     */   
/*     */   public void setObjectId(IObjectId argObjectId) {
/* 188 */     setOrganizationId(((SequenceId)argObjectId).getOrganizationId());
/* 189 */     setRetailLocationId(((SequenceId)argObjectId).getRetailLocationId());
/* 190 */     setWorkstationId(((SequenceId)argObjectId).getWorkstationId());
/* 191 */     setSequenceId(((SequenceId)argObjectId).getSequenceId());
/* 192 */     setSequenceMode(((SequenceId)argObjectId).getSequenceMode());
/*     */   }
/*     */   
/*     */   public String getImplementingClass() {
/* 196 */     return null;
/*     */   }
/*     */   
/*     */   public String toXmlString() {
/* 200 */     StringBuilder buf = new StringBuilder(500);
/* 201 */     buf.append("<").append("dao").append(" name=\"Sequence\" cmd=\"" + getObjectStateString() + "\">");
/* 202 */     getFieldsAsXml(buf);
/* 203 */     buf.append("</").append("dao").append(">");
/*     */     
/* 205 */     return buf.toString();
/*     */   }
/*     */   
/*     */   public Map<String, String> getValues() {
/* 209 */     Map<String, String> values = super.getValues();
/* 210 */     if (this._organizationId != null) values.put("OrganizationId", DaoUtils.getXmlSafeFieldValue(-5, this._organizationId)); 
/* 211 */     if (this._retailLocationId != null) values.put("RetailLocationId", DaoUtils.getXmlSafeFieldValue(-5, this._retailLocationId)); 
/* 212 */     if (this._workstationId != null) values.put("WorkstationId", DaoUtils.getXmlSafeFieldValue(-5, this._workstationId)); 
/* 213 */     if (this._sequenceId != null) values.put("SequenceId", DaoUtils.getXmlSafeFieldValue(12, this._sequenceId)); 
/* 214 */     if (this._sequenceMode != null) values.put("SequenceMode", DaoUtils.getXmlSafeFieldValue(12, this._sequenceMode)); 
/* 215 */     if (this._createDate != null) values.put("CreateDate", DaoUtils.getXmlSafeFieldValue(91, this._createDate)); 
/* 216 */     if (this._createUserId != null) values.put("CreateUserId", DaoUtils.getXmlSafeFieldValue(12, this._createUserId)); 
/* 217 */     if (this._updateDate != null) values.put("UpdateDate", DaoUtils.getXmlSafeFieldValue(91, this._updateDate)); 
/* 218 */     if (this._updateUserId != null) values.put("UpdateUserId", DaoUtils.getXmlSafeFieldValue(12, this._updateUserId)); 
/* 219 */     if (this._sequenceNumber != null) values.put("SequenceNumber", DaoUtils.getXmlSafeFieldValue(-5, this._sequenceNumber)); 
/* 220 */     return values;
/*     */   }
/*     */ 
/*     */   
/*     */   public void setValues(Map<String, String> argValues) {
/* 225 */     super.setValues(argValues);
/* 226 */     for (Map.Entry<String, String> field : argValues.entrySet()) {
/*     */       
/* 228 */       String fieldName = field.getKey();
/* 229 */       String fieldValue = field.getValue();
/* 230 */       switch (fieldName) {
/*     */         
/*     */         case "OrganizationId":
/*     */           try {
/* 234 */             Object value = DaoUtils.getFieldValueForXmlString(-5, fieldValue);
/* 235 */             setOrganizationId((Long)value);
/* 236 */           } catch (Exception ee) {
/* 237 */             throw new DtxException("An exception occurred while calling setOrganizationId() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "RetailLocationId":
/*     */           try {
/* 243 */             Object value = DaoUtils.getFieldValueForXmlString(-5, fieldValue);
/* 244 */             setRetailLocationId((Long)value);
/* 245 */           } catch (Exception ee) {
/* 246 */             throw new DtxException("An exception occurred while calling setRetailLocationId() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "WorkstationId":
/*     */           try {
/* 252 */             Object value = DaoUtils.getFieldValueForXmlString(-5, fieldValue);
/* 253 */             setWorkstationId((Long)value);
/* 254 */           } catch (Exception ee) {
/* 255 */             throw new DtxException("An exception occurred while calling setWorkstationId() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "SequenceId":
/*     */           try {
/* 261 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 262 */             setSequenceId((String)value);
/* 263 */           } catch (Exception ee) {
/* 264 */             throw new DtxException("An exception occurred while calling setSequenceId() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "SequenceMode":
/*     */           try {
/* 270 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 271 */             setSequenceMode((String)value);
/* 272 */           } catch (Exception ee) {
/* 273 */             throw new DtxException("An exception occurred while calling setSequenceMode() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "CreateDate":
/*     */           try {
/* 279 */             Object value = DaoUtils.getFieldValueForXmlString(91, fieldValue);
/* 280 */             setCreateDate((Date)value);
/* 281 */           } catch (Exception ee) {
/* 282 */             throw new DtxException("An exception occurred while calling setCreateDate() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "CreateUserId":
/*     */           try {
/* 288 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 289 */             setCreateUserId((String)value);
/* 290 */           } catch (Exception ee) {
/* 291 */             throw new DtxException("An exception occurred while calling setCreateUserId() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "UpdateDate":
/*     */           try {
/* 297 */             Object value = DaoUtils.getFieldValueForXmlString(91, fieldValue);
/* 298 */             setUpdateDate((Date)value);
/* 299 */           } catch (Exception ee) {
/* 300 */             throw new DtxException("An exception occurred while calling setUpdateDate() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "UpdateUserId":
/*     */           try {
/* 306 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 307 */             setUpdateUserId((String)value);
/* 308 */           } catch (Exception ee) {
/* 309 */             throw new DtxException("An exception occurred while calling setUpdateUserId() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "SequenceNumber":
/*     */           try {
/* 315 */             Object value = DaoUtils.getFieldValueForXmlString(-5, fieldValue);
/* 316 */             setSequenceNumber((Long)value);
/* 317 */           } catch (Exception ee) {
/* 318 */             throw new DtxException("An exception occurred while calling setSequenceNumber() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */       } 
/*     */     } 
/*     */   }
/*     */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\com\impl\SequenceDAO.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */