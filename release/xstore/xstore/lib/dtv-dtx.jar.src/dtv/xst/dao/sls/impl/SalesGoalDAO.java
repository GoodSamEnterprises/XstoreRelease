/*     */ package dtv.xst.dao.sls.impl;
/*     */ 
/*     */ import dtv.data2.access.DaoUtils;
/*     */ import dtv.data2.access.IObjectId;
/*     */ import dtv.data2.access.exception.DtxException;
/*     */ import dtv.data2.access.impl.AbstractDAOImpl;
/*     */ import dtv.util.DtvDate;
/*     */ import dtv.xst.dao.sls.SalesGoalId;
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
/*     */ public class SalesGoalDAO
/*     */   extends AbstractDAOImpl
/*     */ {
/*     */   private static final long serialVersionUID = 1920136735L;
/*  23 */   private static final Logger _logger = Logger.getLogger(SalesGoalDAO.class);
/*     */   
/*     */   private Long _organizationId;
/*     */   private String _salesGoalId;
/*     */   private String _orgCode;
/*     */   private String _orgValue;
/*     */   private BigDecimal _salesGoalValue;
/*     */   private DtvDate _effectiveDate;
/*     */   private DtvDate _endDate;
/*     */   private String _description;
/*     */   private DtvDate _createDate;
/*     */   private String _createUserId;
/*     */   private DtvDate _updateDate;
/*     */   private String _updateUserId;
/*     */   
/*     */   public Long getOrganizationId() {
/*  39 */     return this._organizationId;
/*     */   }
/*     */   
/*     */   public void setOrganizationId(Long argOrganizationId) {
/*  43 */     if (changed(argOrganizationId, this._organizationId, "organizationId")) {
/*  44 */       this._organizationId = argOrganizationId;
/*     */     }
/*     */   }
/*     */   
/*     */   public String getSalesGoalId() {
/*  49 */     return this._salesGoalId;
/*     */   }
/*     */   
/*     */   public void setSalesGoalId(String argSalesGoalId) {
/*  53 */     if (changed(argSalesGoalId, this._salesGoalId, "salesGoalId")) {
/*  54 */       this._salesGoalId = (argSalesGoalId != null && MANAGE_CASE) ? argSalesGoalId.toUpperCase() : argSalesGoalId;
/*     */     }
/*     */   }
/*     */   
/*     */   public String getOrgCode() {
/*  59 */     return this._orgCode;
/*     */   }
/*     */   
/*     */   public void setOrgCode(String argOrgCode) {
/*  63 */     if (changed(argOrgCode, this._orgCode, "orgCode")) {
/*  64 */       this._orgCode = argOrgCode;
/*     */     }
/*     */   }
/*     */   
/*     */   public String getOrgValue() {
/*  69 */     return this._orgValue;
/*     */   }
/*     */   
/*     */   public void setOrgValue(String argOrgValue) {
/*  73 */     if (changed(argOrgValue, this._orgValue, "orgValue")) {
/*  74 */       this._orgValue = argOrgValue;
/*     */     }
/*     */   }
/*     */   
/*     */   public BigDecimal getSalesGoalValue() {
/*  79 */     return this._salesGoalValue;
/*     */   }
/*     */   
/*     */   public void setSalesGoalValue(BigDecimal argSalesGoalValue) {
/*  83 */     if (changed(argSalesGoalValue, this._salesGoalValue, "salesGoalValue")) {
/*  84 */       this._salesGoalValue = argSalesGoalValue;
/*     */     }
/*     */   }
/*     */   
/*     */   public Date getEffectiveDate() {
/*  89 */     return (Date)this._effectiveDate;
/*     */   }
/*     */   
/*     */   public void setEffectiveDate(Date argEffectiveDate) {
/*  93 */     if (changed(argEffectiveDate, this._effectiveDate, "effectiveDate")) {
/*  94 */       this._effectiveDate = (argEffectiveDate == null || argEffectiveDate instanceof DtvDate) ? (DtvDate)argEffectiveDate : new DtvDate(argEffectiveDate);
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public Date getEndDate() {
/* 100 */     return (Date)this._endDate;
/*     */   }
/*     */   
/*     */   public void setEndDate(Date argEndDate) {
/* 104 */     if (changed(argEndDate, this._endDate, "endDate")) {
/* 105 */       this._endDate = (argEndDate == null || argEndDate instanceof DtvDate) ? (DtvDate)argEndDate : new DtvDate(argEndDate);
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public String getDescription() {
/* 111 */     return this._description;
/*     */   }
/*     */   
/*     */   public void setDescription(String argDescription) {
/* 115 */     if (changed(argDescription, this._description, "description")) {
/* 116 */       this._description = argDescription;
/*     */     }
/*     */   }
/*     */   
/*     */   public Date getCreateDate() {
/* 121 */     return (Date)this._createDate;
/*     */   }
/*     */   
/*     */   public void setCreateDate(Date argCreateDate) {
/* 125 */     if (changed(argCreateDate, this._createDate, "createDate")) {
/* 126 */       this._createDate = (argCreateDate == null || argCreateDate instanceof DtvDate) ? (DtvDate)argCreateDate : new DtvDate(argCreateDate);
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public String getCreateUserId() {
/* 132 */     return this._createUserId;
/*     */   }
/*     */   
/*     */   public void setCreateUserId(String argCreateUserId) {
/* 136 */     if (changed(argCreateUserId, this._createUserId, "createUserId")) {
/* 137 */       this._createUserId = argCreateUserId;
/*     */     }
/*     */   }
/*     */   
/*     */   public Date getUpdateDate() {
/* 142 */     return (Date)this._updateDate;
/*     */   }
/*     */   
/*     */   public void setUpdateDate(Date argUpdateDate) {
/* 146 */     if (changed(argUpdateDate, this._updateDate, "updateDate")) {
/* 147 */       this._updateDate = (argUpdateDate == null || argUpdateDate instanceof DtvDate) ? (DtvDate)argUpdateDate : new DtvDate(argUpdateDate);
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public String getUpdateUserId() {
/* 153 */     return this._updateUserId;
/*     */   }
/*     */   
/*     */   public void setUpdateUserId(String argUpdateUserId) {
/* 157 */     if (changed(argUpdateUserId, this._updateUserId, "updateUserId")) {
/* 158 */       this._updateUserId = argUpdateUserId;
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public String toString() {
/* 165 */     StringBuilder buf = new StringBuilder(512);
/* 166 */     buf.append(super.toString()).append(" Id: ").append(getObjectId()).append(" Values: ");
/* 167 */     if (getOrganizationId() != null) {
/* 168 */       buf.append("organizationId").append("=").append(getOrganizationId()).append(" ");
/*     */     }
/* 170 */     if (getSalesGoalId() != null) {
/* 171 */       buf.append("salesGoalId").append("=").append(getSalesGoalId()).append(" ");
/*     */     }
/* 173 */     if (getOrgCode() != null) {
/* 174 */       buf.append("orgCode").append("=").append(getOrgCode()).append(" ");
/*     */     }
/* 176 */     if (getOrgValue() != null) {
/* 177 */       buf.append("orgValue").append("=").append(getOrgValue()).append(" ");
/*     */     }
/* 179 */     if (getSalesGoalValue() != null) {
/* 180 */       buf.append("salesGoalValue").append("=").append(getSalesGoalValue()).append(" ");
/*     */     }
/* 182 */     if (getEffectiveDate() != null) {
/* 183 */       buf.append("effectiveDate").append("=").append(getEffectiveDate()).append(" ");
/*     */     }
/* 185 */     if (getEndDate() != null) {
/* 186 */       buf.append("endDate").append("=").append(getEndDate()).append(" ");
/*     */     }
/* 188 */     if (getDescription() != null) {
/* 189 */       buf.append("description").append("=").append(getDescription()).append(" ");
/*     */     }
/* 191 */     if (getCreateDate() != null) {
/* 192 */       buf.append("createDate").append("=").append(getCreateDate()).append(" ");
/*     */     }
/* 194 */     if (getCreateUserId() != null) {
/* 195 */       buf.append("createUserId").append("=").append(getCreateUserId()).append(" ");
/*     */     }
/* 197 */     if (getUpdateDate() != null) {
/* 198 */       buf.append("updateDate").append("=").append(getUpdateDate()).append(" ");
/*     */     }
/* 200 */     if (getUpdateUserId() != null) {
/* 201 */       buf.append("updateUserId").append("=").append(getUpdateUserId()).append(" ");
/*     */     }
/*     */     
/* 204 */     return buf.toString();
/*     */   }
/*     */   
/*     */   public IObjectId getObjectId() {
/* 208 */     SalesGoalId id = new SalesGoalId();
/* 209 */     id.setOrganizationId(getOrganizationId());
/* 210 */     id.setSalesGoalId(getSalesGoalId());
/* 211 */     return (IObjectId)id;
/*     */   }
/*     */   
/*     */   public void setObjectId(IObjectId argObjectId) {
/* 215 */     setOrganizationId(((SalesGoalId)argObjectId).getOrganizationId());
/* 216 */     setSalesGoalId(((SalesGoalId)argObjectId).getSalesGoalId());
/*     */   }
/*     */   
/*     */   public String getImplementingClass() {
/* 220 */     return null;
/*     */   }
/*     */   
/*     */   public String toXmlString() {
/* 224 */     StringBuilder buf = new StringBuilder(600);
/* 225 */     buf.append("<").append("dao").append(" name=\"SalesGoal\" cmd=\"" + getObjectStateString() + "\">");
/* 226 */     getFieldsAsXml(buf);
/* 227 */     buf.append("</").append("dao").append(">");
/*     */     
/* 229 */     return buf.toString();
/*     */   }
/*     */   
/*     */   public Map<String, String> getValues() {
/* 233 */     Map<String, String> values = super.getValues();
/* 234 */     if (this._organizationId != null) values.put("OrganizationId", DaoUtils.getXmlSafeFieldValue(-5, this._organizationId)); 
/* 235 */     if (this._salesGoalId != null) values.put("SalesGoalId", DaoUtils.getXmlSafeFieldValue(12, this._salesGoalId)); 
/* 236 */     if (this._orgCode != null) values.put("OrgCode", DaoUtils.getXmlSafeFieldValue(12, this._orgCode)); 
/* 237 */     if (this._orgValue != null) values.put("OrgValue", DaoUtils.getXmlSafeFieldValue(12, this._orgValue)); 
/* 238 */     if (this._salesGoalValue != null) values.put("SalesGoalValue", DaoUtils.getXmlSafeFieldValue(3, this._salesGoalValue)); 
/* 239 */     if (this._effectiveDate != null) values.put("EffectiveDate", DaoUtils.getXmlSafeFieldValue(91, this._effectiveDate)); 
/* 240 */     if (this._endDate != null) values.put("EndDate", DaoUtils.getXmlSafeFieldValue(91, this._endDate)); 
/* 241 */     if (this._description != null) values.put("Description", DaoUtils.getXmlSafeFieldValue(12, this._description)); 
/* 242 */     if (this._createDate != null) values.put("CreateDate", DaoUtils.getXmlSafeFieldValue(91, this._createDate)); 
/* 243 */     if (this._createUserId != null) values.put("CreateUserId", DaoUtils.getXmlSafeFieldValue(12, this._createUserId)); 
/* 244 */     if (this._updateDate != null) values.put("UpdateDate", DaoUtils.getXmlSafeFieldValue(91, this._updateDate)); 
/* 245 */     if (this._updateUserId != null) values.put("UpdateUserId", DaoUtils.getXmlSafeFieldValue(12, this._updateUserId)); 
/* 246 */     return values;
/*     */   }
/*     */ 
/*     */   
/*     */   public void setValues(Map<String, String> argValues) {
/* 251 */     super.setValues(argValues);
/* 252 */     for (Map.Entry<String, String> field : argValues.entrySet()) {
/*     */       
/* 254 */       String fieldName = field.getKey();
/* 255 */       String fieldValue = field.getValue();
/* 256 */       switch (fieldName) {
/*     */         
/*     */         case "OrganizationId":
/*     */           try {
/* 260 */             Object value = DaoUtils.getFieldValueForXmlString(-5, fieldValue);
/* 261 */             setOrganizationId((Long)value);
/* 262 */           } catch (Exception ee) {
/* 263 */             throw new DtxException("An exception occurred while calling setOrganizationId() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "SalesGoalId":
/*     */           try {
/* 269 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 270 */             setSalesGoalId((String)value);
/* 271 */           } catch (Exception ee) {
/* 272 */             throw new DtxException("An exception occurred while calling setSalesGoalId() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "OrgCode":
/*     */           try {
/* 278 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 279 */             setOrgCode((String)value);
/* 280 */           } catch (Exception ee) {
/* 281 */             throw new DtxException("An exception occurred while calling setOrgCode() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "OrgValue":
/*     */           try {
/* 287 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 288 */             setOrgValue((String)value);
/* 289 */           } catch (Exception ee) {
/* 290 */             throw new DtxException("An exception occurred while calling setOrgValue() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "SalesGoalValue":
/*     */           try {
/* 296 */             Object value = DaoUtils.getFieldValueForXmlString(3, fieldValue);
/* 297 */             setSalesGoalValue((BigDecimal)value);
/* 298 */           } catch (Exception ee) {
/* 299 */             throw new DtxException("An exception occurred while calling setSalesGoalValue() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "EffectiveDate":
/*     */           try {
/* 305 */             Object value = DaoUtils.getFieldValueForXmlString(91, fieldValue);
/* 306 */             setEffectiveDate((Date)value);
/* 307 */           } catch (Exception ee) {
/* 308 */             throw new DtxException("An exception occurred while calling setEffectiveDate() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "EndDate":
/*     */           try {
/* 314 */             Object value = DaoUtils.getFieldValueForXmlString(91, fieldValue);
/* 315 */             setEndDate((Date)value);
/* 316 */           } catch (Exception ee) {
/* 317 */             throw new DtxException("An exception occurred while calling setEndDate() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "Description":
/*     */           try {
/* 323 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 324 */             setDescription((String)value);
/* 325 */           } catch (Exception ee) {
/* 326 */             throw new DtxException("An exception occurred while calling setDescription() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "CreateDate":
/*     */           try {
/* 332 */             Object value = DaoUtils.getFieldValueForXmlString(91, fieldValue);
/* 333 */             setCreateDate((Date)value);
/* 334 */           } catch (Exception ee) {
/* 335 */             throw new DtxException("An exception occurred while calling setCreateDate() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "CreateUserId":
/*     */           try {
/* 341 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 342 */             setCreateUserId((String)value);
/* 343 */           } catch (Exception ee) {
/* 344 */             throw new DtxException("An exception occurred while calling setCreateUserId() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "UpdateDate":
/*     */           try {
/* 350 */             Object value = DaoUtils.getFieldValueForXmlString(91, fieldValue);
/* 351 */             setUpdateDate((Date)value);
/* 352 */           } catch (Exception ee) {
/* 353 */             throw new DtxException("An exception occurred while calling setUpdateDate() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "UpdateUserId":
/*     */           try {
/* 359 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 360 */             setUpdateUserId((String)value);
/* 361 */           } catch (Exception ee) {
/* 362 */             throw new DtxException("An exception occurred while calling setUpdateUserId() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */       } 
/*     */     } 
/*     */   }
/*     */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\sls\impl\SalesGoalDAO.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */